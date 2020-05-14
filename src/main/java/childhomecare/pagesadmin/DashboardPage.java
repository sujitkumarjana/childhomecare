package childhomecare.pagesadmin;

import org.openqa.selenium.By;
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
	@FindBy(xpath = "//span[contains(text(),'Buy Client Package')]")
			WebElement BuyClientPackageLink;
	
	public DashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyDashboardPageTitle(){
		return driver.getTitle();
	}
	
	//Navigate to ClientListing Page
	public AdminClientPage NavigateToClientListingPage(){
		 ClientPageLink.click();
		 return new AdminClientPage();
	}
	
	//Navigate to SitterListing Page
		public AdminSitterPage NavigateToSitterListingPage(){
		SitterPageLink.click();
		return new AdminSitterPage();		
		}
		
	//Navigate to Administrator Page	
		public AdministratorPage NavigateToAdministratorPage(){
			AdministratorPageLink.click();
			return new AdministratorPage();
		}
		
	//Navigate to BuyClientPackageLink
		public AdminClientBuyPackage NavigateToBuyClientPackage(){
			driver.findElement(By.xpath("//span[contains(text(),'Client Packages')]")).click();
			BuyClientPackageLink.click();
			return new AdminClientBuyPackage();
		}
	
}
