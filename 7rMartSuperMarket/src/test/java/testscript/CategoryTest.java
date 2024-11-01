package testscript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUserPage;
import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;

public class CategoryTest extends BaseClass{
	FileUploadUtility fileupload;
	
	@Test
	@Parameters({"selection"})
	public void verifyUserisAbletoaddCategory(String selection) throws InterruptedException, IOException {
		
		String username= ExcelUtility.getstringdata(1, 0, "loginpage");
		String password = ExcelUtility.getstringdata(1, 1,"loginpage");
		String categoryfield= ExcelUtility.getstringdata(1, 0, "Categorypage");
		//String image = ExcelUtility.getstringdata(1, 1, "Categorypage");
		//String selection="C:\\Users\\tomcy\\apple.jpg";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNamefield(username);
		loginpage.enterPasswordfield(password);
		loginpage.clickOnsigninbutton();
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.isUserabletoclickonCategoryInfoLink();
		categorypage.isUserabletoClickonNewCategoryButton();
		categorypage.entervalueinCategoryfield(categoryfield);
		categorypage.isUserabeltoseleectgroupbyclickonit();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		categorypage.isuserabletouploadafile(selection);
		//fileupload.verify_FileUpload_UsingRobot(selection);
		boolean  isneCategoryCreated = categorypage.getvalidConfirmationforCategorycreation();
		Assert.assertTrue(isneCategoryCreated,Constant.CONFIRMATION_MESSAGE_FOR_NEW_CATEGORY_CREATION);
		
	}

}
