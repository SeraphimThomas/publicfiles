package bank;



import bankdao.AccountDAO;
import clientapp.Main;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import bankcommon.Accounts;
import bankcommon.Constants;

public class AccountManager implements Constants{
	
	//creation of variables for all methods
	private static final Logger logger = LogManager.getLogger(AccountManager.class.getName());
	static AccountDAO accessData = new AccountDAO();
	Accounts account;
	
	//collects info from login and sends it off to DAO
	public void getAccount(String username,String password, int id){
			this.account = accessData.getAccount(username, password, id, 0.0);
			printAccount(account);
			
	}
	
	//method to print out account info when called for by user or other method
	public void printAccount(Accounts account) {
		if (account.getUser() != null) {
		System.out.println("========================");
		System.out.println("ID: "+account.getId());
		System.out.println("User: "+account.getUser());
		System.out.println("Balance: "+account.getAccBalance());
		System.out.println("========================");
		logger.info("Printing out account for " + account.getUser());
		Main.accOptions();
		}else {
		System.out.println("========================");
		Main.runProg();
		}
	}
	
	//creating the new account and sending it off
	public void setAccount(int id, String username, String password, double balance) {
		Accounts account = new Accounts (id, username, password, balance);
		try {
			accessData.insertAcc(account);
		} catch (SQLException e) {
			System.err.println(SQLerror);
		}
		this.account=account;
		printAccount(account);
		Main.accOptions();
	}
	
	//sets up a withdraw amount to be negative and do nothing to deposits
	public double alterAccount(double change, boolean inOrOut) {
		double newBal = 0.0;
		try {
		if (inOrOut == true) {
			change = -change;
			newBal = accessData.updateBalance(this.account, change);
		}else if (inOrOut == false){
			newBal=accessData.updateBalance(this.account, change);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.account.setAccBalance(newBal);
		return this.account.getAccBalance();
	}
	//checks balance to make sure it won't be negative
	//DB has check to make sure it won't be below 0.0 but this is a double check
	public boolean checkingBalance(double change, double balance) { 
		boolean hasMoney;
		if (balance + change >= 0.0) {
			hasMoney = true;
		}else {
			hasMoney = false;
		}
		return hasMoney;
	}
	
	public void printBalance() {
		System.out.println("==================================");
		System.out.println("Current Balance: ");
		System.out.println(this.account.getAccBalance());
		System.out.println("==================================");
	}
	public void removeAcc(String pass) { //takes in account info for deletion
		System.out.println("Deleting account with " +account.getUser() + " username and ID " + account.getId() + "...");
		try {
			accessData.deleteAcc(pass, account);
			System.out.println("Account removed.  All remaining funds have been withdrawn.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(SQLerror);
		}
		//sets account to null to clean it
		account.setAccBalance(0.0);
		account.setId(0);
		account.setPassword(null);
		account.setUser(null);
	}

	public void setCurrentAccout(int id, String username, String password, double balance) {
		this.account.setAccBalance(balance);
		this.account.setId(id);
		this.account.setPassword(password);
		this.account.setUser(username);
	}
		
}

	//create transaction boundary
	//deposit (int amt){
	//transaction table - insert (add new record)
	//account table - update (new balance)
	//}

	


