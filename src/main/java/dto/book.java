package dto;

public class book{
	private int book_id;
	private String book_name;
	private String author_name;
	private String publisher;
	private String pub_date;
	private String isbn;
	private int category_id;
	private int brand_check;
	private String comment;
	private String URL;
	public book(int book_id, String book_name, String author_name, String publisher, String pub_date, String isbn,
			int category_id, int brand_check, String comment, String uRL) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.author_name = author_name;
		this.publisher = publisher;
		this.pub_date = pub_date;
		this.isbn = isbn;
		this.category_id = category_id;
		this.brand_check = brand_check;
		this.comment = comment;
		URL = uRL;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getBrand_check() {
		return brand_check;
	}
	public void setBrand_check(int brand_check) {
		this.brand_check = brand_check;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
}