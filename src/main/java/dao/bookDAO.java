package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dto.account;
import dto.book;
import dto.lendbook;
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
		String sql = "INSERT INTO book VALUES(default, ?, ?, ?, ?, ?, ?, 0, ?, ?)";
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
		    public boolean isDateOverOneYear(String dateStr) {
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        LocalDate inputDate = LocalDate.parse(dateStr, formatter);
		        LocalDate currentDate = LocalDate.now();
		        return inputDate.isBefore(currentDate.minusYears(1));
		    }
		    
		    public static account getAccountBymail(String email) {
		        String query = "SELECT * FROM account WHERE mail = ?";
		        try(Connection con = getConnection();
		        	PreparedStatement statement = con.prepareStatement(query);
		        	){
		   
		            statement.setString(1, email);
		            try (ResultSet rs = statement.executeQuery()){
						
						if(rs.next()) {
							int userId=rs.getInt("id");
							String name=rs.getString("name");
							String mail=rs.getString("mail");
							int user_check=rs.getInt("user_check");
							
							return new account(userId, name, mail, null, null,user_check);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				return null;
		    }
		    
		    public static int Rendbook(lendbook le) {
		    	int result = 0;
		    	String sql = "INSERT INTO lendbook VALUES (default, ?, ?, ?, ?, ?)";
		      
		        try (Connection con = getConnection();
		        	 PreparedStatement ps = con.prepareStatement(sql)
		        	){           
		                    ps.setString(1, le.getLend_date());
		                    ps.setString(2, le.getReturn_date());
		                    ps.setString(3, le.getDelay_date());
		                    ps.setInt(4, le.getUser_id());
		                    ps.setInt(5, le.getBook_id());
		                    
		                    // データを追加
		                    result = ps.executeUpdate();
		                
		            } catch (SQLException e) {
		    			e.printStackTrace();
		    		} catch (URISyntaxException e) {
						e.printStackTrace();
		    		} 
		    		return result;
              }   
		    public static int getbrand(int ID) {
		    	int brand_check = 1;
				String sql = "SELECT brand_check FROM book WHERE id = ?";
				try (Connection con = getConnection();
					 PreparedStatement ps = con.prepareStatement(sql)
				     ){
				    ps.setInt(1, ID);
				    try (ResultSet rs = ps.executeQuery()) {
				        if (rs.next()) {
				        	
				           brand_check = rs.getInt("brand_check");
				        }
				    }
				 } catch (SQLException e) {
			    		e.printStackTrace();
				 } catch (URISyntaxException e) {
						e.printStackTrace();
			     } 
				 return brand_check;
			 }
				
				public static LocalDate getdelaydate(int id) {
				int brand = getbrand(id);
				LocalDate now = LocalDate.now();
				
				if (brand == 0) {
				    now = now.plusDays(7);
				} else {
				    now = now.plusDays(14);
				}
				return now;
			}
		}
					

