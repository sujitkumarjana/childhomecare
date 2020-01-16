package childhomecare.sittertestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import childhomecare.base.TestBase;
import childhomecare.pagessitter.SitterDashboardPage;
import childhomecare.pagessitter.SitterFinancialInformationPage;
import childhomecare.pagessitter.SitterLoginPage;
import childhomecare.utilities.ExcelUtility;

public class SitterFinancialInformationPageTest extends TestBase{

	SitterLoginPage sitterLoginPage;
	SitterDashboardPage sitterDashBoardPage;
	SitterFinancialInformationPage sitterFinancialInformationPage;
	ExcelUtility excelUtil;
	
	public SitterFinancialInformationPageTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		initialization();
		sitterLoginPage = new SitterLoginPage();
		sitterDashBoardPage = sitterLoginPage.VerifySitterLogin(prop.getProperty("SitterUserName"), prop.getProperty("SitterPassword"));
		sitterDashBoardPage.NavigatetoSitterFinancialInformationPage();
		sitterFinancialInformationPage = new SitterFinancialInformationPage();
	}
	
	@Test
	public void  SitterAddCreditCardTest(){
		excelUtil = new ExcelUtility("E:/WorkSpace/childhomecare/src/main/java/childhomecare/testdata/TestData.xlsx");
		int RowCount = excelUtil.getRowCount("ccinfo");
		for (int i=2; i<=RowCount; i++){
			String nameoncard = excelUtil.getCellData("ccinfo", "Name on Card", i);
			String address = excelUtil.getCellData("ccinfo", "Address", i);
			String city = excelUtil.getCellData("ccinfo", "City", i);
			String state = excelUtil.getCellData("ccinfo", "State", i);
			String zip = excelUtil.getCellData("ccinfo", "Zip", i);
			String cardnumber = excelUtil.getCellData("ccinfo", "Card Number", i);
			String expirationdate = excelUtil.getCellData("ccinfo", "Expiration Date", i);
			String cvvcode = excelUtil.getCellData("ccinfo", "3 Digit Code", i);
			
			sitterFinancialInformationPage.AddCardInformation(nameoncard, address, city, state, zip, cardnumber, expirationdate, cvvcode);
			sitterDashBoardPage.NavigatetoSitterFinancialInformationPage();
			Assert.assertTrue(sitterFinancialInformationPage.VerifyCardInformation(nameoncard), "Card Information Not Matched");
		}
		
	}
}
