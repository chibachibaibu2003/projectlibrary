package dao;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;

import dto.account;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class libraryDAO{
	// 送信元のユーザの情報等を定数で設定する。
	private static final String FROM = "i.chiba.sys22@morijyobi.ac.jp";
	private static final String NAME = "Book Laboratory";
	private static final String PW = "ymibavywcouwvlco";
	private static final String CHARSET = "UTF-8";
		
		// 宛先、件名、本文を引数にメールを送信するメソッド
	public static void sendMail(String to, String subject,String text, URL url) {
		Properties property = new Properties();

		// 各種プロパティの設定
		property.put("mail.smtp.auth", "true");
		property.put("mail.smtp.starttls.enable", "true");
		property.put("mail.smtp.host", "smtp.gmail.com");
		property.put("mail.smtp.port", "587");
		property.put("mail.smtp.debug", "true");

			// ログイン情報の取得
		Session session = Session.getInstance(property,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM,PW);
			}
		});

		try{
			// 送信するメール本体のインスタンス
			MimeMessage message = new MimeMessage(session);

			// 送信元の設定
			// 第1引数：送信元アドレス
			// 第2引数：送信者名
			message.setFrom(new InternetAddress(FROM, NAME));

			// 送信先の設定
			// 第1引数：TO,CC,BCCの区分
			// 第2引数：送信先アドレス
			Address toAddress = new InternetAddress(to);
			message.setRecipient(Message.RecipientType.TO, toAddress);
			// message.setRecipient(Message.RecipientType.CC, toAddress);
			// message.setRecipient(Message.RecipientType.BCC, toAddress);

			// 件名と本文の設定
			message.setSubject(subject, CHARSET);
			message.setText(text+url, CHARSET);

			// 送信実行！
			Transport.send(message);

			System.out.println("メール送信完了！");

		} catch (MessagingException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	private static AmazonS3 auth() {
		AWSCredentials credentials = new BasicAWSCredentials(
				"AKIA5MGO6UUWLMS43AMK",
				"oHOkNrWSwr6ufrrWO2firpWWzpYdK/p6ihUJmxi1"
				);
	 
		AmazonS3 client = AmazonS3ClientBuilder
			.standard()
			.withCredentials(new AWSStaticCredentialsProvider(credentials))
			.withRegion(Regions.AP_NORTHEAST_1)
			.build();
		return client;
	}
	
	public static void upload(String fileBase64, String filename) throws FileNotFoundException, IOException {
		AmazonS3 client = auth();
		 byte[] buf = Base64.getDecoder().decode(fileBase64);
		    try (InputStream input = new ByteArrayInputStream(buf)) {
		        ObjectMetadata metaData = new ObjectMetadata();
		        metaData.setContentLength(buf.length);
		        PutObjectRequest request = new PutObjectRequest(
		            "coverimage",
		            filename,
		            input,
		            metaData
		        );
		        client.putObject(request);
		    }
	}
	
	public static String download(String file) {

        String bucketName = "coverimage";
        String objectKey = file;
        Regions clientRegion = Regions.DEFAULT_REGION;
        String mimeType = "image/jpeg";
        Date expiration = new Date();
        String url="";

        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60; // 1 hour
        expiration.setTime(expTimeMillis);

        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(clientRegion)
                    .build();

            ResponseHeaderOverrides headerOverrides = new ResponseHeaderOverrides()
                    .withContentType(mimeType);

            GeneratePresignedUrlRequest generatePresignedUrlRequest =
                    new GeneratePresignedUrlRequest(bucketName, objectKey)
                            .withMethod(HttpMethod.GET)
                            .withExpiration(expiration)
                            .withResponseHeaders(headerOverrides);

            URL urlStr = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
            url= urlStr.toString();
            
            System.out.println("Pre-Signed URL: " + urlStr.toString());
            

        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
        return url;
        
    }
	
	public static int registerUserAccount(account user) {
		String sql="insert into account values(default,?,?,?,?,0)";
		int result=0;
		
		String salt=GenerateSalt.getSalt(32);
		String hashedPw=GenerateHashedPw.getSafetyPassword(user.getPass(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getMail());
			pstmt.setString(3,salt);
			pstmt.setString(4,hashedPw);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static int registerAdminAccount(account user) {
		String sql="insert into account values(default,?,?,?,?,1)";
		String admin="administrator";
		int result=0;
		
		String salt=GenerateSalt.getSalt(32);
		String hashedPw=GenerateHashedPw.getSafetyPassword(user.getPass(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1,admin);
			pstmt.setString(2,user.getMail());
			pstmt.setString(3,salt);
			pstmt.setString(4,hashedPw);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM account WHERE mail = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static account login(String mail, String hashedPw) {
		String sql = "SELECT * FROM account WHERE mail = ? AND pass = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					int userId=rs.getInt("id");
					String name=rs.getString("name");
					String salt=rs.getString("salt");
					int user_check=rs.getInt("user_check");
					
					return new account(userId,name,mail,salt,hashedPw,user_check);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}