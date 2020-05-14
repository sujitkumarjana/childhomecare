package childhomecare.admintestcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import childhomecare.base.TestBase;
import childhomecare.pagesadmin.AdministratorPage;
import childhomecare.pagesadmin.DashboardPage;
import childhomecare.pagesadmin.LoginPage;
import childhomecare.utilities.ExcelUtility;

public class AdministratorPageTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	AdministratorPage AdminPage;
	
	public AdministratorPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.VerifyLogin(prop.getProperty("AdminUserName"), prop.getProperty("AdminPassword"));
		dashBoardPage.NavigateToAdministratorPage();
		AdminPage = new AdministratorPage();
	}
	
	@Test
	public void AddNewAdminUser() throws InterruptedException{
		ExcelUtility excelUtil = new ExcelUtility("E:\\WorkSpace\\childhomecare\\src\\main\\java\\childhomecare\\testdata\\TestData.xlsx");
		int RowCount = excelUtil.getRowCount("AdminData");
		for (int i=1;i<=RowCount;i++){
			String AdminUserType = excelUtil.getCellData("AdminData", "User Type", i);
			String AdminPhone = excelUtil.getCellData("AdminData", "Phone", i);
			String AdminEmail = excelUtil.getCellData("AdminData", "Email Address", i);
			String AdminPassword = excelUtil.getCellData("AdminData", "Password", i);
			String AdminFirstName = excelUtil.getCellData("AdminData", "First Name", i);
			String AdminLastName = excelUtil.getCellData("AdminData", "Last Name", i);
			AdminPage.NewAdminUser(AdminUserType, AdminPhone, AdminEmail, AdminPassword, AdminFirstName, AdminLastName);
			//dashBoardPage.NavigateToAdministratorPage();
			//Assert.assertTrue(AdminPage.VerifyAdminUser(AdminEmail));
		}
		
		
	}
	

}
