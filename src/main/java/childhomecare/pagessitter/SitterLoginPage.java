package childhomecare.pagessitter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import childhomecare.base.TestBase;

public class SitterLoginPage extends TestBase{

	@FindBy(xpath = "//input[@id='EmailAddress']")
	WebElement UserNameField;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement PasswordField;
	@FindBy(xpath = "//button[contains(text(),'LOGIN')]")
	WebElement LoginButton;
	
	public SitterLoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public SitterDashboardPage VerifySitterLogin(String UserName, String Password){
		UserNameField.sendKeys(UserName);
		PasswordField.sendKeys(Password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Actions action = new Actions(driver);
		action.moveToElement(LoginButton).click().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new SitterDashboardPage();
		
	}
	
	
}

