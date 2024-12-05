package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends BaseClass {

	HomePage homepage;

	@Test
	public void verifyUserisabletoClickLogout() throws IOException {

		String username = ExcelUtility.getstringdata(1, 0, "loginpage");
		String password = ExcelUtility.getstringdata(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNamefield_and_enterPasswordfield(username, password);
		homepage = loginpage.clickOnsigninbutton();
		homepage.isUserabletoclickonAdmin();
		homepage.isUserabletoLogoutthepage();
//		HomePage homepage = new HomePage(driver);
//		homepage.isUserabletoclickonAdmin();
//		homepage.isUserabletoLogoutthepage();
		Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket", "Logout Failed !");
	}

}
