package parameterizedTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
     WebDriver driver;
     
     @Test
     @Parameters ({"URL","BrowserType"})
     public void verifyWebApp(String url, String browserType) {
    	 
    	 if(browserType.equalsIgnoreCase("Edge"))
    	 {
    		 System.setProperty("webdriver.edge.driver", "E:\\\\Applications\\\\edgedriver_win64\\\\msedgedriver.exe\\" );
    		 driver = new EdgeDriver();
    	 
    	 }
    	 else if(browserType.equalsIgnoreCase("Chrome"))
    	 {
    		 System.setProperty("webdriver.chrome.driver","E:\\\\Applications\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe\\");
    	     driver = new ChromeDriver();
    	 }else {
             System.out.println("Invalid browser type: " + browserType);
             return; }
    	 
    	 //driver.manage().window().maximize();
 		
    	 if (driver != null) { 
    	 driver.get(url);
 		
 		System.out.println("\n" + "Open " + browserType);
		System.out.println("   " +  driver.getTitle());
		System.out.println("Close " + browserType + "\n");
 		
		driver.quit();
    	 }
    	 
    	 else {
    		 System.out.println("Invalid browser type: " + browserType);
    	 }
    	 
     }
	
}
