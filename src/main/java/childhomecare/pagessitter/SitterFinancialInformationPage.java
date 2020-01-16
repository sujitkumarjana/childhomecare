package childhomecare.pagessitter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import childhomecare.base.TestBase;

public class SitterFinancialInformationPage extends TestBase{
	
	@FindBy(xpath = "//span[@id='spnAction']")
	WebElement AddNewCard;
	
	@FindBy(xpath = "//input[@placeholder='NameOnCard']")
	WebElement nameOnCard;
	
	@FindBy(xpath = "//input[@placeholder='Address']")
	WebElement address;
	
	@FindBy(xpath = "//input[@placeholder='City']")
	WebElement city;
	
	@FindBy(xpath = "//input[@placeholder='Zip']")
	WebElement zip;
	
	@FindBy (xpath = "//input[@placeholder='Card Number']")
	WebElement cardNumber;
	
	@FindBy (xpath = "//input[@placeholder='Expiration Date']")
	WebElement expirationDate;
	
	@FindBy (xpath = "//input[@placeholder='CVV']")
	WebElement cvv;
	
	@FindBy (xpath = "//input[@ng-click='SaveFinancial()']")
	WebElement CCInfoSaveButton;
	
	@FindBy (xpath = "//*[@id='tblListing']/tbody/tr/td[1]/span")
	WebElement CardNameList;
	
	public SitterFinancialInformationPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void AddCardInformation(String NameOnCard, String Address, String City, String State, String Zip, String CardNumber, String ExpirationDate, String CVV){
		AddNewCard.click();
		nameOnCard.sendKeys(NameOnCard);
		address.sendKeys(Address);
		city.sendKeys(City);
		Select select = new Select(driver.findElement(By.id("ddlStates")));
		select.selectByVisibleText(State);
		zip.sendKeys(Zip);
		cardNumber.sendKeys(CardNumber);
		expirationDate.sendKeys(ExpirationDate);
		cvv.sendKeys(CVV);
		CCInfoSaveButton.click();
	}
	
	public boolean VerifyCardInformation(String NameOnCard){
		return driver.findElement(By.xpath("//span[text()='"+NameOnCard+"']")).isDisplayed();
	}
}
