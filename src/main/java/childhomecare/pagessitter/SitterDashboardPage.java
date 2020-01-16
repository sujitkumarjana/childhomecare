package childhomecare.pagessitter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import childhomecare.base.TestBase;

public class SitterDashboardPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='box-body box-profile']/p[3]")
	WebElement SitterEmailLevel;
	
	@FindBy(xpath = "//span[contains(text(), 'Financial Information')]")
	WebElement FinancialInformationLink;
	
	public SitterDashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String VerifySitterDashBoardURL(){
		return driver.getCurrentUrl();
	}
	
	public String VerifySItterPageTitle(){
		return driver.getTitle();
	}
	
	public String VerifyCorrectSitterLogin(){
		return SitterEmailLevel.getText();
	}
	
	public SitterFinancialInformationPage NavigatetoSitterFinancialInformationPage(){
		FinancialInformationLink.click();
		return new SitterFinancialInformationPage();
	}

}
