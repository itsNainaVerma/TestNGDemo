package dataDrivenTesting;

//used Data provider Name

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogIn2 {
	
	@Test (dataProvider="Login Data-Provider")
	public void logIn(String Username, String Password, boolean success) {
		System.out.println("Log in credenntials: \n" +
				" Email = " + Username + "\n" +
				" Password = " +Password+"\n" +
				" Successful Login = " + success + "\n"
				);
	}
	
	@DataProvider (name="Login Data-Provider")
	public Object [][] logInData (){
		Object [][] data = new Object [3][3];
		
		data[0][0]="Admin"; data[0][1]="admin123"; data[0][2]=true;
		data[1][0]="Joe"; data[1][1]="JD1234"; data[1][2]=false;
		data[2][0]="admin"; data[2][1]="admin123"; data[2][2]=true;
		
		return data;
	}

}
