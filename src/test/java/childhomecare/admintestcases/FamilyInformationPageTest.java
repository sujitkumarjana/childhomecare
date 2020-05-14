package childhomecare.admintestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import childhomecare.base.TestBase;
import childhomecare.pagesadmin.AdminClientPage;
import childhomecare.pagesadmin.DashboardPage;
import childhomecare.pagesadmin.FamilyInformationPage;
import childhomecare.pagesadmin.LoginPage;
import childhomecare.utilities.ExcelUtility;

public class FamilyInformationPageTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	AdminClientPage clientPage;
	FamilyInformationPage familyProfilePage;
	ExcelUtility excelUtil;
	
	public FamilyInformationPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.VerifyLogin(prop.getProperty("AdminUserName"), prop.getProperty("AdminPassword"));
		clientPage = dashBoardPage.NavigateToClientListingPage();
		familyProfilePage = new FamilyInformationPage();
	}
	
	@Test (enabled = false)
	public void VerifyCorrctUserByEmailTest(){
		ExcelUtility excelUtil = new ExcelUtility("E:\\WorkSpace\\childhomecare\\src\\main\\java\\childhomecare\\testdata\\TestData.xlsx");
		int RowCount = excelUtil.getRowCount("ClientData");
		for (int i=2; i<=RowCount; i++){
			String EmailID = excelUtil.getCellData("ClientData", "Email", i);
			clientPage.NavigateToClientProfilePage(EmailID);
			String UserEmailID = familyProfilePage.VerifyClientByEmail();
			Assert.assertEquals(EmailID, UserEmailID, "Primary parent's email ID is not matched");
		}
	}
	
	@Test (enabled = false)
	public void VerifyCorrectUserByNameTest() throws InterruptedException{
		ExcelUtility excelUtil = new ExcelUtility("E:\\WorkSpace\\childhomecare\\src\\main\\java\\childhomecare\\testdata\\TestData.xlsx");
		int RowCount = excelUtil.getRowCount("ClientData");
		for (int i=2; i<=RowCount; i++){
			String FirstName = excelUtil.getCellData("ClientData", "First Name", i);
			String LastName = excelUtil.getCellData("ClientData", "Last Name", i);
			String EmailID = excelUtil.getCellData("ClientData", "Email", i);
			String FullName = FirstName +" " + LastName;
			clientPage.NavigateToClientProfilePage(EmailID);
			String UserName = familyProfilePage.VerifyClientByName();
			Assert.assertEquals(FullName, UserName, "Primary parent's name is not matched");
		}
	}
	
	@Test(priority = 1)
	public void AddParent(){
		
		excelUtil = new ExcelUtility("E:\\WorkSpace\\childhomecare\\src\\main\\java\\childhomecare\\testdata\\TestData.xlsx");
		int RowCount = excelUtil.getRowCount("ClientData");
		for (int i=2; i<=RowCount; i++){
			String EmailID = excelUtil.getCellData("ClientData", "Email", i);
			clientPage.NavigateToClientProfilePage(EmailID);
		}
		//excelUtil = new ExcelUtility("E:\\WorkSpace\\childhomecare\\src\\main\\java\\childhomecare\\testdata\\TestData.xlsx");
		int RowCount1 = excelUtil.getRowCount("ParentInfo");
		for (int i=2; i<=RowCount1; i++){
			String ContactType = excelUtil.getCellData("ParentInfo", "Contact Type", i);
			String ChildRelation = excelUtil.getCellData("ParentInfo", "Relationship To Child", i);
			String FName = excelUtil.getCellData("ParentInfo", "First Name", i);
			String LName = excelUtil.getCellData("ParentInfo", "Last Name", i);
			String SAddress = excelUtil.getCellData("ParentInfo", "Street Address", i);
			String ASuite = excelUtil.getCellData("ParentInfo", "Apartment/Suite", i);
			String Country = excelUtil.getCellData("ParentInfo", "Country", i);
			String State = excelUtil.getCellData("ParentInfo", "State", i);
			String City = excelUtil.getCellData("ParentInfo", "City", i);
			String Zip = excelUtil.getCellData("ParentInfo", "Zip", i);
			String Neighborhood = excelUtil.getCellData("ParentInfo", "Neighborhood", i);
			String CellPhone = excelUtil.getCellData("ParentInfo", "Cell Phone", i);
			String EAddress = excelUtil.getCellData("ParentInfo", "Email Address", i);
			String SkypeID = excelUtil.getCellData("ParentInfo", "Skype Id", i);
			
			familyProfilePage.AddParent(ContactType, ChildRelation, FName, LName, SAddress, ASuite, Country, State, City, Zip, 
					Neighborhood, CellPhone, EAddress, SkypeID);
		}
		
	}
	

	/*@AfterMethod
	public void TearDown(){
		driver.quit();
	}*/
	
}
