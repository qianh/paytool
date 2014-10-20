package paytool.model;

public class Message {
	private int id;
	private String date;
	private String message;
	private double money;
	private Account account;

	public Message(int id, String date, String message, double money,
			Account account) {
		super();
		this.id = id;
		this.date = date;
		this.message = message;
		this.money = money;
		this.account = account;
	}

	public Message() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", date=" + date + ", message=" + message
				+ ", money=" + money + ", account=" + account + "]";
	}

}
