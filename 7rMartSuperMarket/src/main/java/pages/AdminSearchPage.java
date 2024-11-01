package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;
import utilities.WaitUtility;

public class AdminSearchPage {
	
	WebDriver driver;
	
	public AdminSearchPage (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminusermoreinfolink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement adminsearchbutton;
	@FindBy(xpath= "//input[@id='un']") WebElement adminSearchUsername;
	@FindBy(xpath= "//select[@id='ut']") WebElement adminSearchUserType;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @value='sr']") WebElement searchAdminResult;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement adminResetButton;
	@FindBy(xpath="//a[@href= 'https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning']") WebElement resultnotfound;
	
public void IsUserAbletoClickonAdminUserMoreInfolink() {
		
		adminusermoreinfolink.click();
			
	}
	
	public boolean isAdminSearchButtonVisible() {
		
		return adminResetButton.isDisplayed();
		
	}
	
	public void isuserabletoclickonAdminSearchbutton() {
		
		adminsearchbutton.click();
	}
	
	public void isuserabletoentertheUsernameinAdminSearchPage(String searchUsernamefield) {
		
		adminSearchUsername.sendKeys(searchUsernamefield);
	}
	
	public void isuserabletoselectUserTypeinAdminSearchPage(String searchUserType) {
		
		PageUtilities pageutilities = new PageUtilities(driver);
		pageutilities.selectByValueofElement(adminSearchUserType, searchUserType);
	}
	
	public void isuserabletoclickonSearchbutton() {
		
		searchAdminResult.click();
		
	}
	
	public void isuserabletoclickonResetButton() {
		
		adminResetButton.click();
		
	}
	
	public boolean resultnotfounderrormessage()
	{
		return resultnotfound.isDisplayed();
	}
}


