package childhomecare.pagesadmin;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import childhomecare.base.TestBase;

public class AdminClientPage extends TestBase{
	
	@FindBy(xpath = "//a[contains(text(),'Add Client')]")
	WebElement ClickAddClientButton;
	@FindBy(xpath = "//input[@name = 'txtUserFirstName']")
	WebElement firstName;
	@FindBy(xpath = "//input[@name = 'txtUserLastName']")
	WebElement lastName;
	@FindBy(xpath = "//input[@name = 'txtUserEmail']")
	WebElement email;
	@FindBy(xpath = "//input[@value = 'Sign Up']")
	WebElement signUpButton;
	@FindBy(xpath = "//td[@class='footable-first-visible']/span[2]")
	WebElement UserList;
	
	//Initialing Properties File
		public AdminClientPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public String VerifyClientPageTitle(){
			return driver.getTitle();
		}
		
		public boolean VerifyClient(String ClientNametoVerify){
			List <WebElement> ClientList = driver.findElements(By.xpath("//td[@class='footable-first-visible']/span[2]"));
			for(WebElement ClientNameList: ClientList){
				String ClientName = ClientNameList.getText();
				if(ClientName.equals(ClientNametoVerify)){
					Actions action = new Actions(driver);
					action.moveToElement(ClientNameList).build().perform();
					return ClientNameList.isDisplayed();
				}
			}
			return false;
		}
		
		public void ClientRegistration(String FirstName, String LastName, String Email, String TypeOfService){
			ClickAddClientButton.click();
			firstName.sendKeys(FirstName);
			lastName.sendKeys(LastName);
			email.sendKeys(Email);
			Select ServiceType = new Select(driver.findElement(By.xpath("//select[@id = 'ddlClientType']")));
			ServiceType.selectByVisibleText((TypeOfService));
			signUpButton.click();
		}
		
		public FamilyInformationPage NavigateToClientProfilePage(String ClientEmailAddress){
			driver.findElement(By.xpath("//span[contains(text(), '"+ ClientEmailAddress +"')]//parent::td//following-sibling::td[@class='text-center text-nowrap footable-last-visible']/a[contains(text(), 'View')]")).click();
			return new FamilyInformationPage();
		}
		
		public void ChangeProfileLink(String ClientEmailAddress, String NewLink){
			//driver.findElement(By.xpath("//span[contains(text(), '"+ ClientEmailAddress +"')]//parent::td//following-sibling::td[@class='text-center text-nowrap footable-last-visible']/a[@title= 'update profile link']")).click();
			driver.findElement(By.xpath("//span[contains(text(), '"+ ClientEmailAddress +"')]")).click();
			Alert alert = driver.switchTo().alert();
			String AlertText = alert.getText();
			System.out.println(AlertText);
			//driver.switchTo().alert().sendKeys(NewLink);
		}
		
		public void RemoveClientProfile(String ClientEmailAddress){
			driver.findElement(By.xpath("//span[contains(text(), '"+ ClientEmailAddress +"')]//parent::td//following-sibling::td[@class='text-center text-nowrap footable-last-visible']/a/i[@ng-click='RemoveUser(rowindex)']")).click();
			}
		
		
		
}
