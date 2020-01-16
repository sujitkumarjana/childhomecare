package childhomecare.pagesadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import childhomecare.base.TestBase;

public class SitterPage extends TestBase{
	
	@FindBy(xpath = "//a[contains(text(), 'Add Sitter')]")
	WebElement addSitterButton;
	
	@FindBy(xpath = "//input[@id='txtFirstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='txtLastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='txtEmailAddress']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//input[@value='Sign Up']")
	WebElement saveButton;
	
	public SitterPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyPageTitle(){
		return driver.getTitle();
	}
	
	public boolean VerifySitter(String SitterNametoVerify){
		
		List <WebElement> SitterList = driver.findElements(By.xpath("//td[@class='footable-first-visible']/span[2]"));
		for (WebElement SitterNameList : SitterList){
			String SitterName = SitterNameList.getText();
			if(SitterName.equals(SitterNametoVerify)){
				Actions action = new Actions(driver);
				action.moveToElement(SitterNameList).build().perform();		
				return SitterNameList.isDisplayed();
			}
		}
		return false;
	}
	
	public void SitterRegistration(String FirstName, String LastName, String EmailAddress){
		addSitterButton.click();
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		emailAddress.sendKeys(EmailAddress);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Actions action = new Actions(driver);
		action.moveToElement(saveButton).click().perform();
		//saveButton.click();
	}

}
