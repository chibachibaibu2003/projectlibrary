package dto;

public class account{
	private int id;
	private String name;
	private String mail;
	private String salt;
	private String pass;
	private int user_check;
	public account(int id, String name, String mail, String salt, String pass, int user_check) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.salt = salt;
		this.pass = pass;
		this.user_check = user_check;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getUser_check() {
		return user_check;
	}
	public void setUser_check(int user_check) {
		this.user_check = user_check;
	}
}