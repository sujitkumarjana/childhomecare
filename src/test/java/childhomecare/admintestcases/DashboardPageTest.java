package childhomecare.admintestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import childhomecare.base.TestBase;
import childhomecare.pagesadmin.AdminClientPage;
import childhomecare.pagesadmin.AdminSitterPage;
import childhomecare.pagesadmin.DashboardPage;
import childhomecare.pagesadmin.LoginPage;

public class DashboardPageTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	AdminSitterPage sitterPage;
	AdminClientPage clientPage;
	
	public DashboardPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void Setup(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.VerifyLogin(prop.getProperty("AdminUserName"), prop.getProperty("AdminPassword"));
		sitterPage = new AdminSitterPage();
		clientPage = new AdminClientPage();
	}
	
	@Test(priority = 1)
	public void VerifyDashBoardPageTitleTest(){
		String DashBoardPageTitle = dashBoardPage.VerifyDashboardPageTitle();
		Assert.assertEquals(DashBoardPageTitle, "Child Home Care - Dashboard", "Dashboard Page Title Not Matched");
	}
	
	@Test(priority = 2) //(enabled = false)
	public void NavigateToClientPageTest(){
		clientPage = dashBoardPage.NavigateToClientListingPage();
	}
	
	
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
	

}
