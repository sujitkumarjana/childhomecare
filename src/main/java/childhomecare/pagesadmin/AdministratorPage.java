package childhomecare.pagesadmin;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import childhomecare.base.TestBase;

public class AdministratorPage extends TestBase{
	
	@FindBy (xpath = "//span[@id='spnAction' and @title='add new']")
	WebElement AddNewAdministrator;
	@FindBy (xpath = "//span[text()='Select UserType']")
	WebElement UserTypeDropdown;
	@FindBy (xpath = "//input[@name = 'txtPhone' and @id = 'txtPhone']")
	WebElement PhoneNumberField;
	@FindBy (xpath = "//input[@id = 'txtUserName' and @placeholder = 'Email Address']")
	WebElement EmailAddressField;
	@FindBy (xpath = "//input[@id = 'txtPassword' and @placeholder = 'Password']")
	WebElement PasswordField;
	@FindBy (xpath = "//input[@id = 'txtFirstName' and @placeholder = 'First Name']")
	WebElement FirstNameField;
	@FindBy (xpath = "//input[@id = 'txtLastName' and @placeholder = 'Last Name']")
	WebElement LastNameField;
	@FindBy (xpath = "//input[@type='button' and @value='Submit']")
	WebElement SubmitButton;
	
	//Initialing Properties File
			public AdministratorPage(){
				PageFactory.initElements(driver, this);
			}

		public void NewAdminUser(String UserType, String PhoneNumber, String EmailAddress, String Password, String FirstName, String LastName) throws InterruptedException{
			AddNewAdministrator.click();
			Thread.sleep(2000);
			UserTypeDropdown.click();
			Thread.sleep(2000);
			List<WebElement> UserTypes = driver.findElements(By.xpath("//ul[@class='chosen-results']/li"));
			for(WebElement UserTypeList : UserTypes){
				String UserTypeLists = UserTypeList.getText();
				System.out.println("User Types are : " + UserTypeLists);
				if(UserTypeLists.equals(UserType)){
					UserTypeList.click();
					break;
				}
			}
			PhoneNumberField.sendKeys(PhoneNumber);
			EmailAddressField.sendKeys(EmailAddress);
			PasswordField.sendKeys(Password);
			FirstNameField.sendKeys(FirstName);
			LastNameField.sendKeys(LastName);
			SubmitButton.click();
		}
		
		public boolean VerifyAdminUser(String EmailAddress){
			return driver.findElement(By.xpath("//td[text()='"+ EmailAddress +"']")).isDisplayed();
		}
			
}
