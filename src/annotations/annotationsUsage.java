package annotations;

/*The sequence of execution of annotation is as below -
@BeforeSuite
@BeforeTest
@BeforeClass
@BeforeMethod
@Test searchCustomer
@AfterMethod
@BeforeMethod
@Test searchProduct
@AfterMethod
@AfterClass
@AfterTest
@AfterSuite*/

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class annotationsUsage {
  @Test
  public void searchCustomer() {
	  System.out.println("Search for customer");
  }
  
  @Test
  public void searchProduct() {
	  System.out.println("Search for Product");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Sign In");
}

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Sign Out");
 }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Open Test Application");
}

  @AfterClass
  public void afterClass() {
	  System.out.println("Close Test Application");
 }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Open Chrome");

  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Close Chrome");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Chrome - Set up system property");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Chrome - Clean up all cookies");

  }
  

}
