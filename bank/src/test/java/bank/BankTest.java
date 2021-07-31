
 package bank; 

import static org.junit.Assert.*;
import java.sql.*;
 import org.junit.*; 
 import org.junit.runner.JUnitCore; 
 import org.junit.runner.Result;
  
  import bankcommon.Accounts;
import bankcommon.DBUtil;
import clientapp.Main;
  
  
  public class BankTest { 
	  static Accounts account = new Accounts(); Result result;
  
  @BeforeClass public static void beforeClass() {
  System.out.println("Calling before class"); 
  }
  
  
  
  @Before public void makingAccounts() { 
	  System.out.println("Inside making accounts");
	  account.setAccBalance(100.50); 
	  account.setId(20); 
	  account.setUser("Tim");
	  account.setPassword("pass");
  }
  
  @Test public void testAccountsComparePass() { 
	//  result =JUnitCore.runClasses(); 
	  System.out.println("Setting the Accounts object");
	  
  
	  int dbID = account.getId(); 
	  assertEquals(20, dbID);
//  System.out.println("Test pass? " + result.wasSuccessful()); 
  }
  
  @Test 
  public void testAccountsCompareFail() { 
//	  result =JUnitCore.runClasses();
  System.out.println("Failure of account verification");
  account.setAccBalance(100.50); 
  account.setId(400); 
  account.setUser("John");
  account.setPassword("pass");
  
  String pass = account.getPassword(); 
  assertNotEquals("word", pass);
 // System.out.println("Test pass? " + result.wasSuccessful()); 
  }
  @Test
  public void testAccountSet() {
	 Accounts newAcc = new Accounts(5, "Thomas", "password", 50.0);
	account=newAcc;
	assertEquals(account, newAcc);
}
  @Test
  public void testAccountGetFail() {
	 Accounts newAcc = new Accounts(5, "Steve", "password", 50.0);
	Accounts account = new Accounts(5, "Thomas", "password", 50.0);
	assertNotEquals(account, newAcc);
  }
  @Test
  public void incorrectUsernameFail() {
	  Accounts newAcc = new Accounts(10, "thing", "nosfer", 40.0);
	  Accounts account = new Accounts(10, "Thomas", "nosfer", 40.0);
	  assertNotEquals(newAcc.getUser(), account.getUser());
  }
  @Test
  public void checkBalanceFail() {
	  double balance = 500.0;
	  double change = 1000.00;
	  double newBal=balance + -(change);
	  assertFalse(newBal>=0.0);
  }
  @Test
  public void checkBalancePass() {
	  double balance = 15.00;
	  double change = 10.0;
	  double newBal=balance + -(change);
	  assertTrue(newBal>=0.0);
  }
  @Test
  public void checkBalanceWithNeg() {
	  double balance = 1000;
	  double change = -500;
	  double newBal=balance+-(change);
	  assertTrue(newBal>=0.0);
	  System.out.println(newBal);
  }
  @SuppressWarnings("deprecation")
@Test
  	public void careatingNegAmount() {
	  double change = 300.0;
	  change = -change;
	  assertEquals(-300.0, change, 0);
  }
  @Test
  	public void failedLoginTest() {
	  Accounts newAcc = new Accounts(10, "thing", "nosfer", 40.0);
	  Accounts acc = new Accounts(10, "thing", null, 40.0);
	  assertNotEquals(newAcc.getPassword(), acc.getPassword());
  }
  @AfterClass public static void printAccounts() {
  System.out.println(account.getAccBalance());
  System.out.println(account.getId());
  System.out.println(account.getPassword());
  System.out.println(account.getUser()); 
  } 
  }
 
