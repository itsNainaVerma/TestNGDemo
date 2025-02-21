package dataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRM {
	WebDriver driver;
	WebDriverWait wait;
	
	@Test (dataProviderClass=LogIn2.class,dataProvider="Login Data-Provider")
	public void signIn(String UserName, String Password, boolean success) {
		System.setProperty("webdriver.chrome.driver", "E:\\\\\\\\Applications\\\\\\\\chromedriver-win64\\\\\\\\chromedriver-win64\\\\\\\\chromedriver.exe");
	    driver = new ChromeDriver();
	    wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    
	    //driver.manage().window().maximize();
	    
	    driver.get("https://opensource-demo.orangehrmlive.com");
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	    driver.findElement(By.name("username")).sendKeys(UserName);
	    driver.findElement(By.name("password")).sendKeys(Password);
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	    
	    System.out.println("Sign In Credentials: \n" +
	    		"  Username = " + UserName + "\n" +
				"  Password = " + Password + "\n" +
				"  Successful Sign In = " + success + "\n"
	    		);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    String actualResults = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText();
		String expectedResults = "Dashboard";
		Assert.assertEquals(actualResults,expectedResults, "The actual and expected result do not match");
	    driver.quit();
	}
	
}
