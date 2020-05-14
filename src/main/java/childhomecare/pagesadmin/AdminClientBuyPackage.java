package childhomecare.pagesadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import childhomecare.base.TestBase;

public class AdminClientBuyPackage extends TestBase {


	// Initialing Properties File
	public AdminClientBuyPackage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	
	public String VerifyPageTitle(){
		return driver.getTitle();
	}
	
	public boolean VerifyPriceIDColumnPresentorNot(){
		return driver.findElement(By.xpath("//th[contains(text(), 'Pricing ID')]")).isDisplayed();
	}
	
	public boolean VerifyServiceCategoryColumnPresentorNot(){
		return driver.findElement(By.xpath("//th[contains(text(), 'Service Category')]")).isDisplayed();
	}
	
	public boolean VerifyAppointmentTypeColumnPresentorNot(){
		return driver.findElement(By.xpath("//th[contains(text(), 'Appointment Type')]")).isDisplayed();
	}
	
	public boolean VerifyTitleColumnPresentorNot(){
		return driver.findElement(By.xpath("//th[contains(text(), 'Title')]")).isDisplayed();
	}
	
	public boolean VerifyNoOfSessionsColumnPresentorNot(){
		return driver.findElement(By.xpath("//th[contains(text(), 'No Of Sessions')]")).isDisplayed();
	}
	
	public boolean VerifyPriceColumnPresentorNot(){
		return driver.findElement(By.xpath("//th[contains(text(), 'Price')]")).isDisplayed();
	}
	
	public boolean VerifyActionColumnPresentorNot(){
		return driver.findElement(By.xpath("//th[contains(text(), 'Action')]")).isDisplayed();
	}
	
	public void VerifyPackageTitle(String PackageName) {
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		driver.findElement(By
				.xpath("//span[contains(text(), '"+ PackageName +"')]//parent::td//following-sibling::td[@class='text-center footable-last-visible']/button[@id='spnBuy']"))
				.click();
		driver.findElement(By.xpath("//span[contains(text(),'Select Client')]")).click();
		driver.findElement(By.xpath("//li[contains(text(), 'Tuli Client 6')]")).click();
	}

}
