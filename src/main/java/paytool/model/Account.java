package paytool.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Account {
	private int id;
	@NotEmpty(message="账户名不能为空")
	private String name;
	private User user;
	private double wallet;

	public Account(int id, String name, User user, double wallet) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.wallet = wallet;
	}

	public Account() {
		super();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", user=" + user
				+ ", wallet=" + wallet + "]";
	}

}
