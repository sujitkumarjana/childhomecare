package childhomecare.admintestcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import childhomecare.base.TestBase;
import childhomecare.pagesadmin.ClientPage;
import childhomecare.pagesadmin.DashboardPage;
import childhomecare.pagesadmin.FamilyInformationPage;
import childhomecare.pagesadmin.LoginPage;
import childhomecare.utilities.ExcelUtility;

public class ClientPageTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	ClientPage clientPage;
	FamilyInformationPage FamilyProfilePage;
	
	
	public ClientPageTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.VerifyLogin(prop.getProperty("AdminUserName"), prop.getProperty("AdminPassword"));
		dashBoardPage.NavigateToClientListingPage();
		clientPage = new ClientPage();
		FamilyProfilePage = new FamilyInformationPage();
		}

	@Test(enabled = false)
	public void AddClientTest(){
		ExcelUtility excelUtil = new ExcelUtility("E:\\WorkSpace\\childhomecare\\src\\main\\java\\childhomecare\\testdata\\TestData.xlsx");
		int RowCount = excelUtil.getRowCount("ClientData");
		for (int i=2; i<=RowCount; i++){
			String FirstName = excelUtil.getCellData("ClientData", "First Name", i);
			String LastName = excelUtil.getCellData("ClientData", "Last Name", i);
			String Email = excelUtil.getCellData("ClientData", "Email", i);
			String ServiceType = excelUtil.getCellData("ClientData", "Service Type", i);
		clientPage.ClientRegistration(FirstName, LastName, Email, ServiceType);
		dashBoardPage.NavigateToClientListingPage();
		String FullName = FirstName +" " + LastName;
		Assert.assertTrue(clientPage.VerifyClient(FullName));
		}
	}
	
	@Test(enabled = false)
	public void NavigateToClientProfileTest(){
		ExcelUtility excelUtil = new ExcelUtility("E:\\WorkSpace\\childhomecare\\src\\main\\java\\childhomecare\\testdata\\TestData.xlsx");
		int RowCount = excelUtil.getRowCount("ClientData");
		for (int i=2; i<=RowCount; i++){
			String Email = excelUtil.getCellData("ClientData", "Email", i);
			FamilyProfilePage = clientPage.NavigateToClientProfilePage(Email);
			String userEmialID = FamilyProfilePage.VerifyClientByEmail();
			Assert.assertEquals(Email, userEmialID);
		}
	}
	
	@Test
	public void Changeprofilehyperlink(){
		clientPage.ChangeProfileLink("Angela@mailinator.com", "sclient");
		/*driver.switchTo().activeElement();
		String LinkText = driver.findElement(By.xpath("//input[@id='txtPermalink']")).getText();
		System.out.println(LinkText);*/
	}
	
	
	
	/*@AfterMethod
	public void Teardown(){
		driver.quit();
	}*/
}
