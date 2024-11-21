package testscript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;

public class SubCategoryTest extends BaseClass {
	
	FileUploadUtility fileupload;
  @Test
  @Parameters({"username" , "password" ,"subcategorydropdownValue" , "subcategoryfield" , "selection"})
  public void verifyuserisabletoaddnewsubcategory(String username , String password , String subcategorydropdownValue , String subcategoryfield_value, String selection ) throws IOException {
	  
	  
	 // String username= ExcelUtility.getstringdata(1, 0, "loginpage");
	 // String password = ExcelUtility.getstringdata(1, 1,"loginpage");
	  
	  //String selection="C:\\Users\\tomcy\\apple.jpg";
	  
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNamefield(username);
		loginpage.enterPasswordfield(password);
		loginpage.clickOnsigninbutton();
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.isUserabletoclickonsubCategoryInfoLink();
		subcategorypage.isUserabletoClickonNewbuttoninsubCategorypage();
		subcategorypage.selectsubcategoryvaluefromdropdown(subcategorydropdownValue);
		subcategorypage.entervalueinsubCategoryfield(subcategoryfield_value);
		subcategorypage.isuserabletouploadafileinsubcategorypage(selection);
		subcategorypage.isuserabletoclickonSavebutton();
		
		
  }
}
