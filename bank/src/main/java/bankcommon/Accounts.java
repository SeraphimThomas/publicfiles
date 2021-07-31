package bankcommon;

/*
 * POJO for the accounts with getters and setters for the id, user name, password and balance.
 */

public class Accounts{
	private int id;
	private String user;
	private String password;
	private double accBalance;
	
	public Accounts() {
		super();
	}
	
	public Accounts(int id, String user, String password, double accBalance) {
		super();
		this.id=id;
		this.user=user;
		this.password=password;
		this.accBalance=accBalance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}



	
}
