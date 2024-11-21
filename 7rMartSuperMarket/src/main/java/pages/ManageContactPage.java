package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageContactPage {
	

		  
		WebDriver driver;
		public WaitUtility wait;
		public  ManageContactPage (WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver,this);
	}
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']") WebElement manageContactMoreInfoLink;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1' and @class='btn btn-sm btn btn-primary btncss']") WebElement manageContact_ActionButton;
		@FindBy(xpath="//input[@id='phone']") WebElement phonefieldinContactUspage;
		@FindBy(xpath="//textarea[@id='content' and @name='del_time']") WebElement deliveryTimefieldinContactUspage;
		@FindBy(xpath="//i[@class='fa fa-save']") WebElement updateButtonfieldinContactUspage;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement contactUpdateConfirmationMessage;

		public void isUserabletoClickonManageContactMoreInfoLink() {
			
			manageContactMoreInfoLink.click();
			
		}
		
		public void isUserabletoClickonActionButtoninManageCotactPage() {
			
			manageContact_ActionButton.click();
			
		}
		
		public void updatePhonefieldinContactUspage(String phonefield) {
			
			
			phonefieldinContactUspage.clear();
			phonefieldinContactUspage.sendKeys(phonefield);
			
		}
		
		public void updateDeliverytimefieldinContactUspage(String deliveryTimefield) {
			
			deliveryTimefieldinContactUspage.clear();
			deliveryTimefieldinContactUspage.sendKeys(deliveryTimefield);
			
		}
		
		public void isUserabletoClickonUpdateButton() {
			
			
			Actions mousehover = new Actions(driver);
			mousehover.moveToElement(updateButtonfieldinContactUspage).build().perform();
			updateButtonfieldinContactUspage.click();
		}
		
		
		public boolean getvalidConfirmationforContractUpdate() {
				
				return contactUpdateConfirmationMessage.isDisplayed();
			}
	}


