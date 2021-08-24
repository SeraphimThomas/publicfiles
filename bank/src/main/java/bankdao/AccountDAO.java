package bankdao;

import java.sql.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bank.AccountManager;
import bankcommon.*;



public class AccountDAO implements Constants{
	private static final Logger logger = LogManager.getLogger(AccountDAO.class.getName());
	static ResultSet rs;
	static Connection conn;
	static AccountManager accMan = new AccountManager();
	public Accounts getAccount(String userName, String password,int id, double bal){ //calls DB to get the account (if it exists)
		Accounts accountInfo = new Accounts();

		logger.info("Collecting information from database");
		try {
			Connection conn = DBUtil.getInstance().getConnection(); //getting connection
			PreparedStatement pstmt = conn.prepareStatement(selectJoin.toString() + " where user_name = ? AND accountid = ?");
			//above code calls a query based on a joining of the two tables to collect all info
			pstmt.setString(1, userName);
			pstmt.setInt(2, id);		
			rs = pstmt.executeQuery();
			rs.next();
			String accPass=rs.getString("password");
			if (password.equals(accPass)) {
				System.out.println("Logging in...");
				  accountInfo.setPassword(rs.getString("password"));
				  accountInfo.setAccBalance(rs.getDouble("account_balance"));
				  accountInfo.setId(rs.getInt("accountid"));
				 accountInfo.setUser(rs.getString("user_name"));
				 //get all info
				logger.info("Successful login for: " + rs.getString("user_name"));
			}else{
			System.err.println("Incorrect Username and/or Password.  Please try again.");
			System.out.println("======================================================");
			logger.warn("Incorrect login.  Credientials used: " + userName + "/n ID "+ id + "/n password " + password);
			rs.next();
			}	
		} catch (SQLException e) {
		//	e.printStackTrace();
			System.err.println(error);
		}
		return accountInfo; //If it fails, it will return null values for user to realize login failed
		
	}
	
	public void insertAcc(Accounts account) throws SQLException{ //calls DB to insert a new account
		conn = DBUtil.getInstance().getConnection();
		logger.info("Creating new account");
		try {
			//all methods to alter table are set to not auto-commit for database stability
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement(insert.toString()+".bank_accounts VALUES (?,?,?)");
		PreparedStatement pstmt2 = conn.prepareStatement(insert.toString()+".account_balance VALUES (?,?)");
		//setting the numbers for the login table
		pstmt.setInt(1, account.getId());	
		pstmt.setString(2, account.getUser());
		pstmt.setString(3, account.getPassword());
		//setting values for the new account balance
		pstmt2.setInt(1, account.getId());
		pstmt2.setDouble(2, account.getAccBalance());

		pstmt.executeUpdate();
		pstmt2.executeUpdate();
		conn.commit();
		logger.info("Successfully created new account with "+ account.getUser());
		} catch (SQLException e) {
			System.err.println(error);
			conn.rollback();
			logger.warn(SQLerror);
		}
	}
	public double updateBalance(Accounts account, double change) throws SQLException{ //calls the DB to update the balance of the loged-in account
		conn = DBUtil.getInstance().getConnection();
		double balance = 0.0;
		double newBalance =0.0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(selectBal.toString()+" WHERE ? = accountid");
			pstmt.setInt(1, account.getId());
			rs = pstmt.executeQuery();
			rs.next();
			balance = rs.getDouble("account_balance");
			if (accMan.checkingBalance(change, balance) == true) {
				 pstmt = conn.prepareStatement("UPDATE bank_data.account_balance SET account_balance = account_balance + ? WHERE accountid = ?");
				 System.out.println("Updating...");
				 pstmt.setDouble(1, change);
				 pstmt.setInt(2, account.getId());
				 pstmt.execute();
				conn.commit();
				newBalance = balance + change;
			}else {
				newBalance = balance;
				System.out.println("Invalid amount.  No change.");
			}
		}catch (Exception e) {
			System.err.println(calcError);
			conn.rollback();
			logger.warn(SQLerror + " Account balance not updated.");
		}
		return newBalance;
	}

	public void deleteAcc(String pass, Accounts account) throws SQLException {
		conn = DBUtil.getInstance().getConnection();
		try {
			int accID = account.getId();
			conn.setAutoCommit(false); 
			PreparedStatement pstmt = conn.prepareStatement(selectJoin.toString()+" WHERE ? = accountid AND ? = password");
			pstmt.setInt(1, accID);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			rs.next();
			if (rs.getString("password").equals(pass)) {
				pstmt = conn.prepareStatement("DELETE FROM bank_data.bank_accounts WHERE ? = accountid");
				pstmt.setInt(1, accID);
				pstmt.execute();
				conn.commit();
				logger.info("Deleted account");
			}else {
				logger.warn("An attempt to delete an account was stopped.  Account not removed.");
				System.err.println(error);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(SQLerror);
			conn.rollback();
			logger.warn(SQLerror);
		}
	}

}
