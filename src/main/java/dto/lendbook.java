package dto;

public class lendbook{
	private int lend_id;
	private String lend_date;
	private String return_date;
	private String delay_date;
	private int user_id;
	private int book_id;
	public lendbook(int lend_id, String lend_date, String return_date, String delay_date, int user_id, int book_id) {
		super();
		this.lend_id = lend_id;
		this.lend_date = lend_date;
		this.return_date = return_date;
		this.delay_date = delay_date;
		this.user_id = user_id;
		this.book_id = book_id;
	}
	public int getLend_id() {
		return lend_id;
	}
	public void setLend_id(int lend_id) {
		this.lend_id = lend_id;
	}
	public String getLend_date() {
		return lend_date;
	}
	public void setLend_date(String lend_date) {
		this.lend_date = lend_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public String getDelay_date() {
		return delay_date;
	}
	public void setDelay_date(String delay_date) {
		this.delay_date = delay_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
}