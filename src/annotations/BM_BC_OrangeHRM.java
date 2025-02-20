/*
choosing which annotation to use.
if we use @BeforeMethod instead of @BeforeClass 
the test will fail 
because we need to run all test one after other
*/
package annotations;

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

public class BM_BC_OrangeHRM {

	WebDriver driver;
	WebDriverWait wait;
	
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
		
		System.out.println("3. searched user");
	
	}
	
	@AfterClass
	public void signOut() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")));
		WebElement userProfile = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p"));
		userProfile.click();
		
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a"));
		logout.click();
		
		System.out.println("4. signed out");
	}
	
	
	@AfterTest
	public void tearDown() {
		System.out.println("closing chrome");
		driver.quit();
	}
	
}
