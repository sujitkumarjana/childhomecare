package childhomecare.pagesadmin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import childhomecare.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//a[contains(text(),'I forgot my password')]")
			WebElement ForgotPasswordLink;
	@FindBy(xpath = "//a[contains(text(),'Client')]")
			WebElement ClientRegistrationLink;
	@FindBy(xpath = "//a[contains(text(),'Sitter')]")
			WebElement SitterRegistrationLink;
	@FindBy(xpath = "//input[@id='EmailAddress']")
			WebElement UserNameField;
	@FindBy(xpath = "//input[@id='Password']")
			WebElement PasswordField;
	@FindBy(xpath = "//button[contains(text(),'LOGIN')]")
			WebElement LoginButton;
	
		JavascriptExecutor js;
	
	//Initializing properties file objects
	 public LoginPage (){
		 PageFactory.initElements(driver, this);
	 }
	 
	 //Actions
	 public String VerifyLoginPageTitle(){		 
		return driver.getTitle();
	 }
	 
	public boolean VerifyForgotPasswordLink(){
		return ForgotPasswordLink.isDisplayed();
	}
	
	public boolean VerifyClientRegistrationLink(){
		return ClientRegistrationLink.isDisplayed();
	}
	
	public boolean VerifySitterRegistrationLink(){
		return SitterRegistrationLink.isDisplayed();
	}
	
	public DashboardPage VerifyLogin(String UserName, String Password) {
		/*js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('EmailAddress').value='"+UserName+"'");*/
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
		return new DashboardPage();
	}
	

}
