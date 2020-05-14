package childhomecare.admintestcases;

import org.testng.annotations.AfterMethod;
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
	
	@AfterMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.VerifyLogin(prop.getProperty("AdminUserName"), prop.getProperty("AdminPassword"));
		dashboardPage.NavigateToBuyClientPackage();
		buyPackagePage = new AdminClientBuyPackage();
	}
	
	@Test
	public void VerifyPackageName() throws InterruptedException{
		buyPackagePage.VerifyPackageTitle("12 Month Access");
	}
	
}
