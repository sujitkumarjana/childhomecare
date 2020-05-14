package childhomecare.pagesadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import childhomecare.base.TestBase;

public class FamilyInformationPage extends TestBase{
	
	@FindBy (xpath = "//i[@class='fa fa-envelope']//parent::strong/following-sibling::span")
	WebElement UserEmailLabel;
	@FindBy (xpath = "//span[text()='Primary']//parent::td/preceding-sibling::td/span[@ng-bind='family.FirstName']")
	WebElement FirstNameLabel;
	@FindBy (xpath = "//span[text()='Primary']//parent::td/preceding-sibling::td/span[@ng-bind='family.LastName']")
	WebElement LastNameLabel;
	@FindBy (xpath = "//b[contains(text(), 'Family Name:')]")
	WebElement NameLabelinProfilePanel;
	@FindBy (xpath = "//span[@id='spnAction' and @title='add new']")
	WebElement AddParentButton;
	@FindBy (xpath = "//input[@name='txtRelationshipToChild']")
	WebElement RelationshipToChild;
	@FindBy (xpath = "//input[@name='txtFirstName']")
	WebElement AddParentFirstName;
	@FindBy (xpath = "//input[@name='txtLastName']")
	WebElement AddParentLastName;
	@FindBy (xpath = "//input[@name='txtStreetAddress']")
	WebElement StreetAddress;
	@FindBy (xpath = "//input[@name='txtAppartment']")
	WebElement ApartmentSuite;
	@FindBy (xpath = "//input[@name='txtCity']")
	WebElement City;
	@FindBy (xpath = "//input[@name='txtZip']")
	WebElement Zip;
	@FindBy (xpath = "//input[@name='txtCellPhone']")
	WebElement CellPhone;
	@FindBy (xpath = "//input[@name='txtEmailAddress']")
	WebElement EmailAddress;
	@FindBy (xpath = "//input[@name='txtSkypeId']")
	WebElement SkypeID;
	
	
	public FamilyInformationPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyClientByEmail(){
		return UserEmailLabel.getText();
	}
	
	public String VerifyClientByName(){
		String FirstName = FirstNameLabel.getText();
		String LastName = LastNameLabel.getText();
		String FullName = FirstName +" "+ LastName;
		return FullName;
	}
	
	public void VerifyParentUserNameInProfilePanel(){
		
		
	}
	
	public void AddParent(String ParentType, String ChildRelationship, String ParentFirstName, String ParentLastName, String ParentStreetAddress,
			String ParentApartmentSuite, String ParentCountry, String ParentState, String ParentCity, String ParentZip, String ParentNeighborhood,
			String ParentCellPhone, String ParentEmailAddress, String ParentSkypeId){
		AddParentButton.click();		
		List <WebElement> UserTypes = driver.findElements(By.xpath("//div[@id='divPrimaryInfo']/label"));
		(new WebDriverWait(driver, 25)).until(ExpectedConditions.visibilityOfAllElements(UserTypes));
		for(WebElement UserType : UserTypes){
			String UT = UserType.getText();
			if(UT.equals(ParentType)){
				UserType.click();
			}
			else{
				System.out.println("Parent Contact type not matched");
			}
		}
		RelationshipToChild.sendKeys(ChildRelationship);
		AddParentFirstName.sendKeys(ParentFirstName);
		AddParentLastName.sendKeys(ParentLastName);
		StreetAddress.sendKeys(ParentStreetAddress);
		ApartmentSuite.sendKeys(ParentApartmentSuite);
		
		//Way to Select Country
		driver.findElement(By.xpath("//span[contains(text(), 'Select Country')]")).click();
		System.out.println("Country dropdown clicked");
		//driver.findElement(By.xpath("//*[@id='ddlCountry_chosen']/a/div/b")).click();
		
		/*List <WebElement> CountryList = driver.findElements(By.xpath("//div[@id='ddlCountry_chosen']//li"));
		for(WebElement CountryLists : CountryList){
			String CountryListText = CountryLists.getText();
			System.out.println(CountryListText);
			if(CountryListText.equalsIgnoreCase(ParentCountry)){
				CountryLists.click();
			}
		}*/
		
		/*Select select = new Select (driver.findElement(By.id("ddlCountry")));
		select.selectByVisibleText("United States");*/
		
		/*Actions action = new Actions(driver);
		WebElement CountryDropDown = driver.findElement(By.xpath("//div[@id='ddlCountry_chosen']"));
		action.moveToElement(CountryDropDown).click().perform();
		Select select = new Select(driver.findElement(By.id("ddlCPStatus")));
		select.selectByVisibleText(ParentCountry);
		WebElement Country = driver.findElement(By.xpath("//li[text()='"+ ParentCountry +"']"));
		action.moveToElement(Country).click().perform();*/
		
		/*//Way to Select State
		driver.findElement(By.xpath("//div[@id='ddlState_chosen']")).click();
		driver.findElement(By.xpath("//li[contains(text(), '"+ ParentState +"')]")).click();
		
		City.sendKeys(ParentCity);
		Zip.sendKeys(ParentZip);
		CellPhone.sendKeys(ParentCellPhone);
		EmailAddress.sendKeys(ParentEmailAddress);
		SkypeID.sendKeys(ParentSkypeId);*/
	}
	

}
