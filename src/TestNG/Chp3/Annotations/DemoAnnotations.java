package TestNG.Chp3.Annotations;

import org.testng.annotations.BeforeMethod;

public class DemoAnnotations {
	
	//write @ Annotation name and 
	//press ctrl+shift+O to import it
	//ctrl+shift+L to open all the shortcuts
	
	@BeforeMethod  
	 void SetUp() {
		System.out.println("Sign In");
}
	
}
