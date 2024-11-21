package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;
import utilities.WaitUtility;

public class SubCategoryPage {
	

	WebDriver driver;
	public WaitUtility wait;
	public  SubCategoryPage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);

}
	
	@FindBy(xpath="//p[text()='Sub Category']") WebElement subcategoryinfolink;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement subcategory_newbutton;
	@FindBy(xpath="//select[@name='cat_id']") WebElement category_dropdownvalue;
	@FindBy(xpath="//input[@id='subcategory']") WebElement subcategoryfield_value;
	@FindBy(xpath="//input[@name='main_img']") WebElement subcategory_choosefilebutton;
	@FindBy(xpath="//button[text()='Save']") WebElement subcategory_savebutton;
	
public void isUserabletoclickonsubCategoryInfoLink() {
		
	subcategoryinfolink.click();
	}

public void isUserabletoClickonNewbuttoninsubCategorypage() {
	
	subcategory_newbutton.click();
}
public void selectsubcategoryvaluefromdropdown( String subcategorydropdownValue) {
	wait.waitForVisibilityOfElement(driver, category_dropdownvalue);
	PageUtilities pageutilities = new PageUtilities(driver);
	pageutilities.selectByVisibleText(category_dropdownvalue, subcategorydropdownValue);
	
}


public void entervalueinsubCategoryfield(String subcategoryfieldvalue) {
	wait.waitForVisibilityOfElement(driver, subcategoryfield_value);
	subcategoryfield_value.sendKeys(subcategoryfieldvalue);
}

public void isuserabletouploadafileinsubcategorypage(String IMAGEUPLOADPATH) {

	wait.waitForVisibilityOfElement(driver, subcategory_choosefilebutton);
	
	subcategory_choosefilebutton.sendKeys(IMAGEUPLOADPATH);
}

public void isuserabletoclickonSavebutton() {
	
	wait.waitForVisibilityOfElement(driver, subcategory_savebutton);
	subcategory_savebutton.click();
	
}
}