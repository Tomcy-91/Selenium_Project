package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminSearchPage;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminSerachTest extends BaseClass{
	
	HomePage homepage;
	AdminSearchPage adminsearchpage;
	AdminUserPage adminuserpage;
  @Test
  @Parameters({"adminsearchusername","adminsearchusertype"})
  public void verifyuserisabletosearchanadminuser(String adminsearchusername , String adminsearchusertype ) throws IOException {
	  
	String username= ExcelUtility.getstringdata(1, 0, "loginpage");
	String password = ExcelUtility.getstringdata(1, 1,"loginpage");
	//String adminsearchusername= ExcelUtility.getstringdata(1, 0, "AdminSearchPage");
	//String adminsearchusertype = ExcelUtility.getstringdata(1, 1,"AdminSearchPage");
	//LoginPage loginpage = new LoginPage(driver);
	//loginpage.enterUserNamefield(username);
	//loginpage.enterPasswordfield(password);
	//loginpage.clickOnsigninbutton();
	//AdminSearchPage adminsearchpage = new AdminSearchPage(driver);
	//adminsearchpage.IsUserAbletoClickonAdminUserMoreInfolink();
	//Assert.assertTrue(adminsearchpage.isAdminSearchButtonVisible(),Constant.ERRORMESSAGE_FOR_SEARCH_BUTTON_IS_NOT_Visible);
	//adminsearchpage.isuserabletoclickonAdminSearchbutton();
	//adminsearchpage.isuserabletoentertheUsernameinAdminSearchPage(adminsearchusername);
	//adminsearchpage.isuserabletoselectUserTypeinAdminSearchPage(adminsearchusertype);
	//adminsearchpage.isuserabletoclickonSearchbutton();
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUserNamefield_and_enterPasswordfield(username, password);
	homepage = loginpage.clickOnsigninbutton();
	adminuserpage =homepage.IsUserAbletoClickonAdminUserMoreInfolink();
	adminsearchpage.isuserabletoclickonAdminSearchbutton().isuserabletoentertheUsernameinAdminSearchPage(adminsearchusername).isuserabletoselectUserTypeinAdminSearchPage(adminsearchusertype).isuserabletoclickonSearchbutton();
	Assert.assertTrue(adminsearchpage.resultnotfounderrormessage(),Constant.USER_NOT_FOUND_MESSAGE);
	adminsearchpage.isuserabletoclickonResetButton();
  }
}
