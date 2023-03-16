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
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;

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
	
	public static int registerAccount(account user) {
		String sql="insert into account values(default,?,?,?,?,?)";
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
			pstmt.setInt(5,user.getUser_check());

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
	
	
}