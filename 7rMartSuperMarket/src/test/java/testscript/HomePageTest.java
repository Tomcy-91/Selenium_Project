package testscript;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseClass {
	
	@Test
	public void verifyUserisabletoClickLogout() {
		
		  
		String username ="admin";
		String password = "admin";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNamefield(username);
		loginpage.enterPasswordfield(password);
		loginpage.clickOnsigninbutton();
		HomePage homepage = new HomePage(driver);
		homepage.isUserabletoclickonAdmin();
		homepage.isUserabletoLogoutthepage();
	}

}
