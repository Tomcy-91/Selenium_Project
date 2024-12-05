package testscript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends BaseClass {
	@Test
	public void verifyUserisAbletoUpdatetheContactUsInfomrationfields() throws IOException {

		String username = ExcelUtility.getstringdata(1, 0, "loginpage");
		String password = ExcelUtility.getstringdata(1, 1, "loginpage");
		String phonefieldinContactUspage = ExcelUtility.getintegerdata(1, 0, "ManageContactPage");
		String deliveryTimefieldinContactUspage = ExcelUtility.getstringdata(1, 1, "ManageContactPage");
		// String phonefieldinContactUspage ="9976542300";
		// String deliveryTimefieldinContactUspage ="Three hrs";

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNamefield_and_enterPasswordfield(username, password);
		loginpage.clickOnsigninbutton();
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.isUserabletoClickonManageContactMoreInfoLink();
		managecontactpage.isUserabletoClickonActionButtoninManageCotactPage();
		managecontactpage.updatePhonefieldinContactUspage(phonefieldinContactUspage);
		managecontactpage.updateDeliverytimefieldinContactUspage(deliveryTimefieldinContactUspage);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		managecontactpage.isUserabletoClickonUpdateButton();
		boolean isContactInfoUpdate = managecontactpage.getvalidConfirmationforContractUpdate();
		Assert.assertTrue(isContactInfoUpdate, Constant.CONFIRMATION_MESSAGE_FOR_NEW_ADMINUSER_CREATION);
	}
}
