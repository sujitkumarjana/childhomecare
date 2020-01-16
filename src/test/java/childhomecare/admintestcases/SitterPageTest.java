package childhomecare.admintestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import childhomecare.base.TestBase;
import childhomecare.pagesadmin.DashboardPage;
import childhomecare.pagesadmin.LoginPage;
import childhomecare.pagesadmin.SitterPage;
import childhomecare.utilities.ExcelUtility;

public class SitterPageTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	SitterPage sitterPage;
	
	
	public SitterPageTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.VerifyLogin(prop.getProperty("AdminUserName"), prop.getProperty("AdminPassword"));
		dashBoardPage.NavigateToSitterListingPage();
		sitterPage = new SitterPage();
	}
	
	@Test(priority = 1)
	public void VerifyPaegTitleTest(){
		String SitterPageTitle = sitterPage.VerifyPageTitle();
		Assert.assertEquals(SitterPageTitle, "Child Home Care - Sitter List", "Sitter Page Title Not Matched");
	}
	
	@Test(priority = 2)
	public void AddSitterTest(){
		ExcelUtility ExcelUtil = new ExcelUtility("E:\\WorkSpace\\childhomecare\\src\\main\\java\\childhomecare\\testdata\\TestData.xlsx");
		int SitterRow = ExcelUtil.getRowCount("SitterData");
		for(int i = 2; i<=SitterRow; i++){
			String firstName = ExcelUtil.getCellData("SitterData", "First Name", i);
			String lastName = ExcelUtil.getCellData("SitterData", "Last Name", i);
			String emailAddress = ExcelUtil.getCellData("SitterData", "Email Address", i);
			sitterPage.SitterRegistration(firstName, lastName, emailAddress);
			dashBoardPage.NavigateToSitterListingPage();
			String FullName = firstName + " " + lastName;
			Assert.assertTrue(sitterPage.VerifySitter(FullName));
		}
	}

	
	/*@AfterMethod
	public void Teardown(){
		driver.quit();
	}*/
}
