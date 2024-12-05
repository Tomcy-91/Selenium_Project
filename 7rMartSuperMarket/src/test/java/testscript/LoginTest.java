package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {
	@DataProvider(name = "credentials")
	public Object[][] testData() {
		Object[][] input = new Object[2][2];
		input[0][0] = "admin";
		input[0][1] = "admin";
		input[1][0] = "admin1234000";
		input[1][1] = "admin";
		return input;

	}

	@Test(dataProvider = "credentials")
	public void verifyUserIsAbletoLoginValidCredentials(String username, String password) throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNamefield_and_enterPasswordfield(username, password);
		loginpage.clickOnsigninbutton();
		boolean ishomepageloaded = loginpage.isdashboarddisplayed();
		Assert.assertTrue(ishomepageloaded, Constant.ERRORMESSAGEFORLOGINPAGE);

	}

	@Test
	@Parameters({ "username", "password" })
	public void validusernameinvalidpassword(String username, String password) throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNamefield_and_enterPasswordfield(username, password);
		loginpage.clickOnsigninbutton();
		boolean isErrorMessageDisplayed = loginpage.getInvalidConfirmation();
		Assert.assertTrue(isErrorMessageDisplayed, Constant.ERRORMESSAGEFORLOGINPAGE);

	}

	@Test(groups = { "smoke" })
	public void invalidUsernameValidPassword() throws IOException {

		String username = ExcelUtility.getstringdata(3, 0, "loginpage");
		String password = ExcelUtility.getstringdata(3, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNamefield_and_enterPasswordfield(username, password);
		loginpage.clickOnsigninbutton();
		boolean isErrorMessageDisplayed = loginpage.getInvalidConfirmation();
		Assert.assertTrue(isErrorMessageDisplayed, Constant.ERRORMESSAGEFORLOGINPAGE);

	}

	@Test(retryAnalyzer = retry.Retry.class)
	public void invalidUsernameInvalidPassword() throws IOException {

		String username = ExcelUtility.getstringdata(4, 0, "loginpage");
		String password = ExcelUtility.getstringdata(4, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNamefield_and_enterPasswordfield(username, password);
		loginpage.clickOnsigninbutton();
		boolean isErrorMessageDisplayed = loginpage.getInvalidConfirmation();
		Assert.assertTrue(isErrorMessageDisplayed, Constant.ERRORMESSAGEFORLOGINPAGE);

	}
}
