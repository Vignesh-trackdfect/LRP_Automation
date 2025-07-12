package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Notification_SC001 extends Keywords{

	public void Ecommerce_Notification_SC001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Notification_SC001";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Ecomm_Notification_Module = Excel_data.get("Ecomm_Notification_Module");

		Extent_Start(testcase_Name, test, test1);
		Step_Start(1," Navigate to Customer Service → Ecommerce → Ecom notification.",test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyName);
		Step_Start(2,"  Enter \"Ecom notification\" in the Module Search to access the module.",test, test1);

		moduleNavigate(driver, Ecomm_Notification_Module);
		Step_End(2,"  Enter \"Ecom notification\" in the Module Search to access the module.",test, test1);

		Step_End(1," Navigate to Customer Service → Ecommerce → Ecom notification.",test, test1);
		Step_Start(3,"   Line and Agency users can access the  Ecom notification module.",test, test1);

		waitForDisplay(driver, CustomerSelectOption_EN);
		if(isDisplayed(driver, CustomerSelectOption_EN)) {
			System.out.println("Expected : System Should allow to open the Ecom notification module  ||  Actual : System allows Open the Ecom notification module.");
			Extent_pass_New(driver, "Expected : System Should allow to open the Ecom notification module  ||  Actual : System allows Open the Ecom notification module.", test, test1);
		}else {
			System.out.println("Expected : System Should allow to open the Ecom notification module  ||  Actual : System Not allows Open the Ecom notification module.");
			Extent_fail(driver, "Expected : System Should allow to open the Ecom notification module  ||  Actual : System Not allows Open the Ecom notification module.", test, test1);			
		}
		Step_End(3,"   Line and Agency users can access the  Ecom notification module.",test, test1);
		Extent_completed(testcase_Name, test, test1);

	}	
}
