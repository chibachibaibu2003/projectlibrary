package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dto.account;

public class SendMailDAO{
	private static final String FROM = "i.chiba.sys22@morijyobi.ac.jp";
	private static final String NAME = "Tibazon";
	private static final String PW = "ymibavywcouwvlco";
	private static final String CHARSET = "UTF-8";
	
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
	
	public static List<account> getNearInfo(){
		String sql="select * from lendbook where  delay_date -interval'2 day' <=now()::date and return_date IS NULL; ";
		List<account> result=new ArrayList<>();
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String mail=rs.getString("mail");
					String salt=rs.getString("salt");
					String pass=rs.getString("pass");
					account list=new account(id,name,mail,salt,pass,0);
					result.add(list);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<account> getOverInfo(){
		String sql="select * from lendbook where  delay_date  < now()::date and return_date IS NULL; ";
		List<account> result=new ArrayList<>();
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String mail=rs.getString("mail");
					String salt=rs.getString("salt");
					String pass=rs.getString("pass");
					account list=new account(id,name,mail,salt,pass,0);
					result.add(list);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void SendNearNoticeMail(List<account> data) {
		Properties property = new Properties();
		String subject="返却期限にていての連絡";
		String text="明後日が返却期限ですので、忘れずに返却をお願いします。";
		List<account> list=data;

		// 各種プロパティの設定
		property.put("mail.smtp.auth", "true");
		property.put("mail.smtp.starttls.enable", "true");
		property.put("mail.smtp.host", "smtp.gmail.com");
		property.put("mail.smtp.port", "587");
		property.put("mail.smtp.debug", "true");
		
		Session session = Session.getInstance(property,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM,PW);
			}
		});
		
		try{
			for(account info :list) {
			// 送信するメール本体のインスタンス
			MimeMessage message = new MimeMessage(session);

			// 送信元の設定
			// 第1引数：送信元アドレス
			// 第2引数：送信者名
			message.setFrom(new InternetAddress(FROM, NAME));

			// 送信先の設定
			// 第1引数：TO,CC,BCCの区分
			// 第2引数：送信先アドレス
			Address toAddress = new InternetAddress(info.getMail());
			message.setRecipient(Message.RecipientType.TO, toAddress);
			// message.setRecipient(Message.RecipientType.CC, toAddress);
			// message.setRecipient(Message.RecipientType.BCC, toAddress);

			// 件名と本文の設定
			message.setSubject(subject, CHARSET);
			message.setText(text, CHARSET);

			// 送信実行！
			Transport.send(message);

			System.out.println("メール送信完了！");
		}
		} catch (MessagingException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void SendOverNoticeMail(List<account> data) {
		Properties property = new Properties();
		String subject="貸出図書の延滞にていての連絡";
		String text="返却期限を過ぎていますので、忘れずに返却をお願いします。";
		List<account> list=data;

		// 各種プロパティの設定
		property.put("mail.smtp.auth", "true");
		property.put("mail.smtp.starttls.enable", "true");
		property.put("mail.smtp.host", "smtp.gmail.com");
		property.put("mail.smtp.port", "587");
		property.put("mail.smtp.debug", "true");
		
		Session session = Session.getInstance(property,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM,PW);
			}
		});
		
		try{
			for(account info :list) {
			// 送信するメール本体のインスタンス
			MimeMessage message = new MimeMessage(session);

			// 送信元の設定
			// 第1引数：送信元アドレス
			// 第2引数：送信者名
			message.setFrom(new InternetAddress(FROM, NAME));

			// 送信先の設定
			// 第1引数：TO,CC,BCCの区分
			// 第2引数：送信先アドレス
			Address toAddress = new InternetAddress(info.getMail());
			message.setRecipient(Message.RecipientType.TO, toAddress);
			// message.setRecipient(Message.RecipientType.CC, toAddress);
			// message.setRecipient(Message.RecipientType.BCC, toAddress);

			// 件名と本文の設定
			message.setSubject(subject, CHARSET);
			message.setText(text, CHARSET);

			// 送信実行！
			Transport.send(message);

			System.out.println("メール送信完了！");
		}
		} catch (MessagingException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}