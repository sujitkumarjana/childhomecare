package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import childhomecare.base.TestBase;
import childhomecare.pagesadmin.AdministratorPage;
import childhomecare.pagesadmin.DashboardPage;
import childhomecare.pagesadmin.LoginPage;

public class Practice extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	AdministratorPage adminPage;
	
	public Practice(){
		PageFactory.initElements(driver, this);
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.VerifyLogin(prop.getProperty("AdminUserName"), prop.getProperty("AdminPassword"));
		dashBoardPage.NavigateToAdministratorPage();
	}
	
	@Test
	public void practicewithAdministratiorPage() throws InterruptedException{
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title='add new' and @id='spnAction']")).click();
		driver.findElement(By.xpath("//span[text()='Select UserType']")).click();
		List<WebElement> UserTypes = driver.findElements(By.xpath("//ul[@class='chosen-results']/li"));
		for(WebElement UserTypeList : UserTypes){
			String UserTypeLists = UserTypeList.getText();
			System.out.println("User Types are : " + UserTypeLists);
			if(UserTypeLists.equals("Site Visit Representatives")){
				UserTypeList.click();
				break;
			}
			
		}
		driver.findElement(By.xpath("//input[@name = 'txtPhone' and @id = 'txtPhone']")).sendKeys("9831906286");
		driver.findElement(By.xpath("//input[@id = 'txtUserName' and @placeholder = 'Email Address']")).sendKeys("sujit122@mailinator.com");
		driver.findElement(By.xpath("//input[@id = 'txtPassword' and @placeholder = 'Password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id = 'txtFirstName' and @placeholder = 'First Name']")).sendKeys("Sujit");
		driver.findElement(By.xpath("//input[@id = 'txtLastName' and @placeholder = 'Last Name']")).sendKeys("Jana");
		driver.findElement(By.xpath("//input[@type='button' and @value='Submit']")).click();
	}

}
