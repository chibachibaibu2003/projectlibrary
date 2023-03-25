package dto;

public class reviewList{
	private String userName;
	private String bookName;
	private String authorName;
	private String isbn;
	private String url;
	private String category;
	private int point;
	private String comTitle;
	private String comment;
	private String reviewDate;
	public reviewList(String userName, String bookName, String authorName, String isbn, String url, String category,
			int point, String comTitle, String comment, String reviewDate) {
		super();
		this.userName = userName;
		this.bookName = bookName;
		this.authorName = authorName;
		this.isbn = isbn;
		this.url = url;
		this.category = category;
		this.point = point;
		this.comTitle = comTitle;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getComTitle() {
		return comTitle;
	}
	public void setComTitle(String comTitle) {
		this.comTitle = comTitle;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	
}