package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCExample {
	public static void main(String[] args) {
		
		//C:\\Users\\foxbo\\GitHubRoot\\SpringTools\\bank\\src\\test\\resources\\config.properties
		
		//load properties file
		Properties props = new Properties();
		
		try (FileInputStream fileStream = new FileInputStream("C:\\Users\\foxbo\\GitHubRoot\\SpringTools\\bank\\src\\test\\resources\\config.properties")){
			props.load(fileStream);
			

		
		String URL = (String) props.get("db_url");
		String USERNAME = (String) props.get("db_user");
		String PASSSWORD = (String) props.get("db_password");
		
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSSWORD);
		
		try (Connection conn = DriverManager.getConnection(URL,USERNAME,PASSSWORD)){
			
			conn.setAutoCommit(false); //sets it so the things DON'T commit automagically
			// Get statement object
			//Statement stmt = conn.createStatement();
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO MyGames (gamename) VALUES (?)");
			pstmt.setString(1,"Megaman 7");
			
			int inserted = pstmt.executeUpdate();
			
			//Callable statement
			CallableStatement cstmt = conn.prepareCall("call sample.enroll_employee(?,?)");
			cstmt.setString(1,"Roger");  
			cstmt.setString(2,"M");  
			cstmt.execute();
			
			
			//Get Result
			//int inserted = stmt.executeUpdate("INSERT INTO MyGames (GameName) VALUES ('Final Fantasy 9')");
			//Statement stmt = conn.createStatement();
			System.out.println("Inserted:"+inserted);
			
		//	PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM MyGames WHERE GameSystem = ?");
		//	readData(pstmt2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		static void readData(Statement stmt) throws SQLException{
			ResultSet rs = stmt.executeQuery("SELECT * FROM MyGames");
			
			while (rs.next()) {
				String game = rs.getString("gamename");
				System.out.println(game);
		}
		
	}
}
