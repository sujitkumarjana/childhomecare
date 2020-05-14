package childhomecare.admintestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import childhomecare.base.TestBase;
import childhomecare.pagesadmin.AdminClientBuyPackage;
import childhomecare.pagesadmin.DashboardPage;
import childhomecare.pagesadmin.LoginPage;

public class AdminClientBuyPackageTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AdminClientBuyPackage buyPackagePage;
	
	public AdminClientBuyPackageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.VerifyLogin(prop.getProperty("AdminUserName"), prop.getProperty("AdminPassword"));
		dashboardPage.NavigateToBuyClientPackage();
		buyPackagePage = new AdminClientBuyPackage();
	}
	
	@Test(enabled = false)
	public void verifyPageTitle(){
		Assert.assertEquals(buyPackagePage.VerifyPageTitle(), "Child Home Care - Buy Client Package", "Page title not matched");
	}
	
	
	@Test(enabled = false)
	public void VerifyPackageName(){
		buyPackagePage.VerifyPackageTitle("12 Month Access");
	}
	
	@Test(enabled = false)
	public void VerifyPriceIDColumnPresentorNotTest(){
		Assert.assertTrue(buyPackagePage.VerifyPriceIDColumnPresentorNot());;
	}
	
	@Test(enabled = false)
	public void VerifyServiceCategoryColumnPresentorNotTest(){
		Assert.assertTrue(buyPackagePage.VerifyServiceCategoryColumnPresentorNot());;
	}
	
	@Test(enabled = false)
	public void VerifyAppointmentTypeColumnPresentorNotTest(){
		Assert.assertTrue(buyPackagePage.VerifyAppointmentTypeColumnPresentorNot());;
	}
	
	@Test(enabled = false)
	public void VerifyTitleColumnPresentorNotTest(){
		Assert.assertTrue(buyPackagePage.VerifyTitleColumnPresentorNot());;
	}
	
	@Test(enabled = false)
	public void VerifyNoOfSessionsColumnPresentorNotTest(){
		Assert.assertTrue(buyPackagePage.VerifyNoOfSessionsColumnPresentorNot());;
	}
	
	@Test(enabled = false)
	public void VerifyPriceColumnPresentorNotTest(){
		Assert.assertTrue(buyPackagePage.VerifyPriceColumnPresentorNot());;
	}
	
	@Test(enabled = false)
	public void VerifyActionColumnPresentorNotTest(){
		Assert.assertTrue(buyPackagePage.VerifyActionColumnPresentorNot());;
	}
	
	
	/*@AfterMethod
	public void tearDown(){
		driver.quit();
	}*/
	
}
