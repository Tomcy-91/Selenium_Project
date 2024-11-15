package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class AdminUserPage {
	

	WebDriver driver;
	public  AdminUserPage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement adminUserNewbutton;
	@FindBy(xpath="//input[@id='username']")WebElement adminUsername;
	@FindBy(xpath="//input[@id='password']") WebElement adminPassword;
	@FindBy(xpath="//select[@id='user_type']") WebElement adminUserType;
	@FindBy(xpath="//button[@name='Create']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement adminusercreateConfirmation;
//	
//	public void IsUserAbletoClickonAdminUserMoreInfolink() {
//		
//		adminusermoreinfolink.click();
//			
//	}
	public AdminUserPage isUserAbletoClickonAdminUserNewButton() {
		
		adminUserNewbutton.click();
		return this;
	}
	
	public AdminUserPage enterAdminUserUsernamefield(String adminUsernamefield) {
		
		adminUsername.sendKeys(adminUsernamefield);
		return this;
		
	}
	
	public AdminUserPage enterAdminUserPasswordfield (String adminUserPasswordfield) {
		
		adminPassword.sendKeys(adminUserPasswordfield);
		return this;
		
	}
	
	public AdminUserPage selectAdminuserType( String adminUsertypeValue) {
		
		PageUtilities pageutilities = new PageUtilities(driver);
		pageutilities.selectByValueofElement(adminUserType, adminUsertypeValue);
		return this;
	}
	
	public AdminUserPage isUserabletoClickonSaveButton()
	{
		saveButton.click();
		return this;
	}
	
public boolean getvalidConfirmationfornewadminusercreation() {
		
		return adminusercreateConfirmation.isDisplayed();
	}
}

