package childhomecare.pagesadmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import childhomecare.base.TestBase;

public class DashboardPage extends TestBase{

	@FindBy(xpath = "//span[contains(text(),'Client / Parent')]")
			WebElement ClientPageLink;
	@FindBy(xpath = "//span[contains(text(),'Sitter / Nanny')]")
			WebElement SitterPageLink;
	@FindBy(xpath = "//*[text()='Administrators']")
			WebElement AdministratorPageLink;
	
	public DashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyDashboardPageTitle(){
		return driver.getTitle();
	}
	
	//Navigate to ClientListing Page
	public ClientPage NavigateToClientListingPage(){
		 ClientPageLink.click();
		 return new ClientPage();
	}
	
	//Navigate to SitterListing Page
		public SitterPage NavigateToSitterListingPage(){
		SitterPageLink.click();
		return new SitterPage();		
		}
		
	//Navigate to Administrator Page	
		public AdministratorPage NavigateToAdministratorPage(){
			AdministratorPageLink.click();
			return new AdministratorPage();
		}
	
}
