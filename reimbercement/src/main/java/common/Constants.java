package common;

public interface Constants {
	//list of constants for configuration and SQL/Error building
	public static final int HTTP_OK = 200;
	public static final int HTTP_ERROR = 300;
	public static final String HTTP_JSON_CONTENT = "application/json";
//	public static final String config= "config-file";
//	public static final String db_url = "db_url";
//	public static final String db_user = "db_user";
//	public static final String db_pass = "db_password";
//	public static final String error = "An error has occurred.  Please check the information and try again.";
//	public static final String calcError = "Invalid amount.  Please try again.";
	public static final StringBuilder selectTicekt = new StringBuilder("SELECT * FROM reimberse.ticket");
	public static final StringBuilder insert = new StringBuilder("INSERT INTO reimberse.tickets");
//	public static final String SQLerror = "An error occurred in contacting the database.";
	public static final StringBuilder selectJoin = new StringBuilder("select * from reimberse.employeelogin natural join "
																	+ "reimberse.tickets");
}
