package pages;

import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class CategoryPage {
	


	WebDriver driver;
	public WaitUtility wait;
	public  CategoryPage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer'][1]") WebElement categoryinfolink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newcategory;
	@FindBy(xpath="//input[@id='category']") WebElement categoryfield;
	@FindBy(xpath="//li[@id='134-selectable']") WebElement selectgroup;
	@FindBy(xpath="//input[@name='main_img']") WebElement choosefile;
	@FindBy(xpath="//button[@name='create']") WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement categorycreateConfirmation;
	
	
	public void isUserabletoclickonCategoryInfoLink() {
		
		categoryinfolink.click();
	}
	
	public void isUserabletoClickonNewCategoryButton() {
		
		newcategory.click();
	}
	
	public void entervalueinCategoryfield(String categoryfieldvalue) {
		
		categoryfield.sendKeys(categoryfieldvalue);
	}
	
	public void isUserabeltoseleectgroupbyclickonit() {
		
		selectgroup.click();
		
	}
	
	public void isuserabletouploadafile(String IMAGEUPLOADPATH) {
	
		wait.waitForElementTobeClickable(driver, choosefile);
		
		choosefile.sendKeys(IMAGEUPLOADPATH);
	}
	
public boolean getvalidConfirmationforCategorycreation() {
		
		return categorycreateConfirmation.isDisplayed();
	}
}
	

