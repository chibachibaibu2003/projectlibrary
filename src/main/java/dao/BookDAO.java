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

public class BookDAO {

	// DBへのConnectionを取得(参考：これまで教えていたやり方)
//	private static Connection getConnection() throws URISyntaxException, SQLException {
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//	    String username = "postgres";
//	    String password = "morijyobi";
//	    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
//
//	    return DriverManager.getConnection(dbUrl, username, password);
//	}
	
	// DBへのConnectionを取得（本番環境/テスト環境 切り替え用）
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
	
	// 引数の Book インスタンスを元にデータを1件INSERTするメソッド
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
			pstmt.setInt(5, bo.getIsbn());
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
	// 本のデータを全件取得する
			public static List<book> selectAllbook() {
				
				// 返却用変数
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
							int isbn = rs.getInt("isbn");
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
				// Listを返却する。0件の場合は空のListが返却される。
				return result;
			}

		public static int deletebook(int ID) {
			String sql = "DELETE FROM book WHERE id = ?";
			int result = 0;
			try (
				 Connection con = getConnection();	                   // DB接続
				 PreparedStatement pstmt = con.prepareStatement(sql); // 構文解析
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
