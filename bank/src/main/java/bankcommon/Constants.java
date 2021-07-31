package bankcommon;

public interface Constants {
	//list of constants for configuration and SQL/Error building
	public static final String config= "config-file";
	public static final String db_url = "db_url";
	public static final String db_user = "db_user";
	public static final String db_pass = "db_password";
	public static final String error = "An error has occured.  Please check the information and try again."+
										"/n ===============================";
	public static final String calcError = "Invalid amount.  Please try again.";
	public static final StringBuilder selectBal = new StringBuilder("SELECT * FROM bank_data.account_balance");
	public static final StringBuilder insert = new StringBuilder("INSERT INTO bank_data");
	public static final String SQLerror = "An error occured in contacting the database.";
	public static final StringBuilder selectJoin = new StringBuilder("select * from bank_data.account_balance natural join bank_data.bank_accounts");
}
