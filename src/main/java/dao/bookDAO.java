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

import dto.book;

public class bookDAO {
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
	
	public static int registerbook(book bo) {
		String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, bo.getBook_name());
			pstmt.setString(2, bo.getAuthor_name());
			pstmt.setString(3, bo.getPublisher());
			pstmt.setString(4, bo.getPub_date());
			pstmt.setString(5, bo.getIsbn());
			pstmt.setInt(6, bo.getCategory_id());
			pstmt.setInt(7, bo.getBrand_check());
			pstmt.setString(8, bo.getComment());
			pstmt.setString(9, bo.getURL());
			
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
	
			public static List<book> selectAllbook() {
				
				List<book> result = new ArrayList<>();

				String sql = "SELECT * FROM book";
				
				try (
						Connection con = getConnection();
						PreparedStatement pstmt = con.prepareStatement(sql);
						){
					try (ResultSet rs = pstmt.executeQuery()){
						while(rs.next()) {
							int id = rs.getInt("id");
							String book_name = rs.getString("book_name");
							String author_name = rs.getString("author_name");
							String publisher = rs.getString("publisher");
							String pub_date = rs.getString("pub_date");
							String isbn = rs.getString("isbn");
							int category_id = rs.getInt("category_id");
							int brand_check = rs.getInt("brand_check");
							String comment = rs.getString("comment");
							String URL = rs.getString("URL");

							book books = new book(id, book_name, author_name, publisher, pub_date, isbn, category_id, brand_check, comment, URL);
							
							result.add(books);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				return result;
			}

		public static int deletebook(int ID) {
			String sql = "DELETE FROM book WHERE id = ?";
			int result = 0;
			try (
				 Connection con = getConnection();	                   
				 PreparedStatement pstmt = con.prepareStatement(sql); 
				 ){
			
				pstmt.setInt(1, ID);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} finally {
				System.out.println(result + "件削除しました。");
			}
			return result;
		}
}
