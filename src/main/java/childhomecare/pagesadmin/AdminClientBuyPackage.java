package childhomecare.pagesadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import childhomecare.base.TestBase;

public class AdminClientBuyPackage extends TestBase{
	
	/*@FindBy	(xpath="//span[@ng-bind='info.Title']")
			WebElement PackageTitle;*/
	
	//Initialing Properties File
			public AdminClientBuyPackage(){
				PageFactory.initElements(driver, this);
			}
		
			
	//Actions
			public void VerifyPackageTitle(String PackageName) throws InterruptedException{
				Thread.sleep(3000);
				List <WebElement> PackageList =  driver.findElements(By.xpath("//span[@ng-bind='info.Title']"));
				for(WebElement PackageListing : PackageList){
					String PackageNames = PackageListing.getText();
					System.out.println(PackageNames);
					if(PackageNames.equalsIgnoreCase(PackageName)){
						PackageListing.click();
					}
				}
			}
			

}
