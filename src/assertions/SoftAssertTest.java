package assertions;

/*
Using same code of BC_MC_OrangeHRM.java to check assertion
added method testHomePageVerification() for assertion check
Soft Assert Fail scenarios

-->A soft assert continues execution after a fail 
and moves on to the next statement line <--
*/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest
{

		WebDriver driver;
		WebDriverWait wait;
		SoftAssert softAssert = new SoftAssert();// this is an in-build TestNG class
		
		@BeforeClass
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "E:\\Applications\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			
			//driver.manage().window().maximize(); 
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			System.out.println("1. Open chrome & application");
		}
		@Test
		public void signIn() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
			WebElement username =  driver.findElement(By.name("username"));
			username.sendKeys("Admin");
			
			WebElement password =  driver.findElement(By.name("password"));
			password.sendKeys("admin123");
			
			WebElement loginButtom =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
			loginButtom.click();
			
			
			System.out.println("2. Sign In");
		}
	
		@Test
		public void testHomePageVerification() {
			softAssert.assertEquals(true,false,"Welcome link is not correct on home page");
			System.out.println("3. Verify Welcome Link");
			
			//execution will continue here because we have used softAssert
			softAssert.assertFalse(true, "The admin tab is not displayed");
			System.out.println("4. Verify Admin Tab");
			 
			softAssert.assertEquals(true, true);
			
			softAssert.assertTrue(false,"The dashboard is not corrrect");
			System.out.println("5. Verify dashboard");
			
			softAssert.assertAll();
		}
		
		@Test
		public void userSearch() {
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")));
			WebElement menuAdmin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span"));
			menuAdmin.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]/button/i")));
			WebElement dropDownArrow = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]/button/i"));
			dropDownArrow.click();
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			WebElement textUsername =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
			if (textUsername.isDisplayed() && textUsername.isEnabled()) {
				textUsername.sendKeys("Admiin");
			} else {
			    System.out.println("Element is not interactable.");
			}//just added if else for fun, this will work if you directly find element and send keys.
		
			WebElement searchButton =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
			searchButton.click();
			
			System.out.println("6. searched user");
		
		}
		
		@AfterClass
		public void signOut() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")));
			WebElement userProfile = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p"));
			userProfile.click();
			
			WebElement logout = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a"));
			logout.click();
			
			System.out.println("7. signed out");
		}
		
		
		@AfterTest
		public void tearDown() {
			System.out.println("closing chrome");
			driver.quit();
		}

	
}
