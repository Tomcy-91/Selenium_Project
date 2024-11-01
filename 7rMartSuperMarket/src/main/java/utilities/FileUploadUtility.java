package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class FileUploadUtility {
	
	WebDriver driver;
	public FileUploadUtility() {
		
		this.driver = driver;
			PageFactory.initElements(driver,this);
		}
	
	
//
//	public void verify_FileUpload_UsingSendKeys(){
//		
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://demo.guru99.com/test/upload/");
//		WebElement chooseButton = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
//		chooseButton.sendKeys("C:\\Users\\tomcy\\git\\seleniumbasics\\seleniumbasics\\src\\main\\resources\\Array.docx");
//		WebElement terms = driver.findElement(By.id("terms"));
//		terms.click();
//		WebElement submitButton = driver.findElement(By.id("submitbutton"));
//		submitButton.click();
//	}
	public void verify_FileUpload_UsingRobot() throws AWTException {
		
		//WebDriver driver=new ChromeDriver();
		//driver.get("https://www.ilovepdf.com/pdf_to_word");
		//driver.manage().window().maximize();
		//WebElement  selectFile = driver.findElement(By.xpath("//input[@id='main_img']"));
		//selectFile.click();
		StringSelection selection = new StringSelection("C:\\Users\\tomcy\\apple.jpg");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
