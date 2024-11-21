package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	
	public WebDriver driver;
	public PageUtilities(WebDriver driver) {
		
		this.driver = driver;
	}
	public void selectByValueofElement(WebElement dropdown,String value) {
		
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}

public void selectByValueofIndex(WebElement dropdown,String value) {
		
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}

public void selectByVisibleText(WebElement dropdown,String value) {
	
	Select select = new Select(dropdown);
	select.selectByValue(value);
}

public void scrollPageToDown(int pixels) {
	JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
	javaScriptExecutor.executeScript("window.scrollBy(0,"+pixels+ ")");
}

}