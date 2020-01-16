package childhomecare.admintestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import childhomecare.base.TestBase;
import childhomecare.pagesadmin.DashboardPage;
import childhomecare.pagesadmin.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
	}
	
	/*@Test(priority = 1)
	public void verifyLoginPageTitleTest(){
		String LoginPageTitle = loginPage.VerifyLoginPageTitle();
		Assert.assertEquals(LoginPageTitle, "Child Home Care | Login", "Login Page Title Not Matched");
	}
	
	@Test(priority = 2)
	public void verifyClientRegistrationLinkTest(){
		Assert.assertTrue(loginPage.VerifyClientRegistrationLink(), "Client Registration Link Not Found");
	}
	
	@Test(priority = 3)
	public void verifySitterRegistrationLinkTest(){
		Assert.assertTrue(loginPage.VerifySitterRegistrationLink(), "Sitter Registration Link Not Found");
	}
	
	@Test(priority = 4)
	public void verifyForgotPasswordLinkTest(){
		Assert.assertTrue(loginPage.VerifyForgotPasswordLink(), "Forgot Password Link Not Found");
	}*/
	
	@Test(priority = 5)
	public void VerifyLoginTest(){
		dashboardPage = loginPage.VerifyLogin(prop.getProperty("AdminUserName"), prop.getProperty("AdminPassword"));
		String DashBoardPageTitle = dashboardPage.VerifyDashboardPageTitle();
		Assert.assertEquals(DashBoardPageTitle, "Child Home Care - Dashboard");dashboardPage.VerifyDashboardPageTitle();
	}
	
	/*@AfterMethod
	public void TearDown(){
		driver.quit();
	}*/
	

}
