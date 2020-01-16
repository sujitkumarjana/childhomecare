package childhomecare.sittertestcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import childhomecare.base.TestBase;
import childhomecare.pagessitter.SitterDashboardPage;
import childhomecare.pagessitter.SitterLoginPage;

public class SitterDashboardPageTest extends TestBase{
	
	SitterLoginPage sitterloginPage;
	SitterDashboardPage sitterDashBoardPage;
	
	public SitterDashboardPageTest(){
		super();
	}
	
	@BeforeTest
	public void VerifySitterDashboardPageTitle(){
		initialization();
		sitterloginPage = new SitterLoginPage();
		sitterDashBoardPage = sitterloginPage.VerifySitterLogin(prop.getProperty("SitterUserName"), prop.getProperty("SitterPassword"));
	}
	
	@Test (priority = 1)
	public void VerifyPageURLTest(){
		String SitterPageURL = sitterDashBoardPage.VerifySitterDashBoardURL();
		Assert.assertEquals(SitterPageURL, "http://childhomecare.tulieservices.net/Sitter/Dashboard", "Sitter page URL not matched");
	}
	
	@Test (priority = 2)
	public void VerifySitterPageTitleTest(){
		String SitterDashBoardPageTitle = sitterDashBoardPage.VerifySItterPageTitle();
		Assert.assertEquals(SitterDashBoardPageTitle, "Child Home Care - Dashboard", "Sitter dashboard page title not matched");
	}
	
	@Test (priority = 3)
	public void VerifyCorrectSitterLevel(){
		String SitterEmailAddress = prop.getProperty("SitterUserName");
		String sitterlevel = sitterDashBoardPage.VerifyCorrectSitterLogin();
		String sl [] =  sitterlevel.split(" ");
		String sl1 = sl[1];
		Assert.assertEquals(SitterEmailAddress, sl1);
	}

}
