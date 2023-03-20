package dto;

public class review{
	private int review_id;
	private int point;
	private String comment_title;
	private String comment;
	private int user_id;
	private String isbn;
	private String review_date;
	public review(int review_id, int point, String comment_title, String comment, int user_id, String isbn,
			String review_date) {
		super();
		this.review_id = review_id;
		this.point = point;
		this.comment_title = comment_title;
		this.comment = comment;
		this.user_id = user_id;
		this.isbn = isbn;
		this.review_date = review_date;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getComment_title() {
		return comment_title;
	}
	public void setComment_title(String comment_title) {
		this.comment_title = comment_title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getReview_date() {
		return review_date;
	}
	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
	
}