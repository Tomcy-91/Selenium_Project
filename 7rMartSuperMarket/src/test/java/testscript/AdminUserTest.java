package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends BaseClass {
	
	AdminUserPage adminuserpage;
	HomePage homepage;
	
	@Test
	@Parameters({"username","password","adminUsername","adminPassword","adminUserType"})
	public void verifyUserisAbletocreateNewAdminUser(String username , String password , String adminUsername , String adminPassword, String adminUserType) throws IOException {
		
		//String username= ExcelUtility.getstringdata(1, 0, "loginpage");
		//String password = ExcelUtility.getstringdata(1, 1,"loginpage");
		//String adminUsername= ExcelUtility.getstringdata(1, 0, "Adminuserpage");
		//String adminPassword = ExcelUtility.getstringdata(1, 1,"Adminuserpage");
		//String adminUserType = ExcelUtility.getstringdata(1, 2,"Adminuserpage");
//		LoginPage loginpage = new LoginPage(driver);
//		loginpage.enterUserNamefield(username);
//		loginpage.enterPasswordfield(password);
//		loginpage.clickOnsigninbutton();
//		AdminUserPage adminuserpage = new AdminUserPage(driver);
//		adminuserpage.IsUserAbletoClickonAdminUserMoreInfolink();
//		adminuserpage.isUserAbletoClickonAdminUserNewButton();
//		adminuserpage.enterAdminUserUsernamefield(adminUsername);
//		adminuserpage.enterAdminUserPasswordfield(adminPassword);
//		adminuserpage.selectAdminuserType(adminUserType);
//		adminuserpage.isUserabletoClickonSaveButton();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNamefield(username).enterPasswordfield(password);
		homepage = loginpage.clickOnsigninbutton();
		adminuserpage=homepage.IsUserAbletoClickonAdminUserMoreInfolink();
		adminuserpage.isUserAbletoClickonAdminUserNewButton().enterAdminUserUsernamefield(adminUsername).enterAdminUserPasswordfield(adminPassword)
		.selectAdminuserType(adminUserType).isUserabletoClickonSaveButton();
		boolean  isnewAdminCreated = adminuserpage.getvalidConfirmationfornewadminusercreation();
		Assert.assertTrue(isnewAdminCreated,Constant.CONFIRMATION_MESSAGE_FOR_NEW_ADMINUSER_CREATION);
		
	}

}
