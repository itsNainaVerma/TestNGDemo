package dependencyTesting;

import java.time.Duration;

// failure in test2_openOrangeHRM assertion

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Groups_DependsOnGroups_FAIL {

	WebDriver driver;
	WebDriverWait wait;
	 
	@Test (groups = "initialize")
	public void test1_SetUpChrome() {
		System.setProperty("webdriver.chrome.driver", "E:\\\\Applications\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("1. set up chrome");
	}
	
	@Test (dependsOnGroups="initialize", groups = "env_application")
	public void test2_openOrangeHRM() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Assert.assertEquals(false, true);
		System.out.println("2. Open OrangeHRM");
	}
	
	@Test (dependsOnGroups="env_application", groups="Sign_In")
	public void test3_signIn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		WebElement username =  driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		
		WebElement password =  driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		
		WebElement loginButtom =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginButtom.click();
		
		
		System.out.println("3. Sign In");
	}
	
	@Test (dependsOnGroups="Sign_In")
	public void test4_userSearch() {
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
		
		System.out.println("4. searched user");
	
	}
	
	@Test (dependsOnGroups="Sign_In")
	public void test5_searchEmployee() {
        WebElement txtEmployee = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input"));
        txtEmployee.sendKeys("Alex");
        
        WebElement searchButton =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
		searchButton.click();
		
        System.out.println("5. searched Employee");
    	
	}
	
	@Test (dependsOnGroups={"env_application","Sign_In"})
	public void test6_signOut() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")));
		WebElement userProfile = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p"));
		userProfile.click();
		
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a"));
		logout.click();
		
		System.out.println("6. signed out");
	}

}

