package bankcommon;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DBUtil implements Constants{
	private static DBUtil _instatnce;
	private Connection conn = null;
	//FileInputStream inputStream = new FileInputStream("C:\\Users\\foxbo\\GitHubRoot\\SpringTools\\bank\\src\\main\\resources\\config.properties");
	
	private DBUtil() { //default constructor
	}
	//create conncection
	public static DBUtil getInstance() {
		if(_instatnce == null) {
			_instatnce = new DBUtil();
		}
		return _instatnce;
	}
	public Connection getConnection() {
		if(this.conn == null) {
			
			String configFilePath = System.getProperty(Constants.config);
			
			try(FileInputStream fis = new FileInputStream(configFilePath)) {
				Properties props = new Properties();
				props.load(fis);
				this.conn = DriverManager.getConnection(props.getProperty(Constants.db_url),
							props.getProperty(Constants.db_user),
							props.getProperty(Constants.db_pass));
			} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
		return this.conn;
	}
}
