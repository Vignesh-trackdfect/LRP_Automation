package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_ECOM_KYC_Details_SC001 extends Keywords{

	public void ECOM_KYC_Details_SC001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		String testcase_Name = "TC_ECOM_KYC_Details_SC001";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		
		String KYC_details_Module = Excel_data.get("KYC_details_Module");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
				
		SwitchProfile(driver, AgencyName);
		
		Step_Start(1, "Enter \"Ecom KYC Detail\" in the Module Search to access the module.", test, test1);

		moduleNavigate(driver, KYC_details_Module);
		
		Step_End(1, "Enter \"Ecom KYC Detail\" in the Module Search to access the module.", test, test1);
		
		Step_Start(2, "Line and Agency users can access the Ecom KYC Detail module.", test, test1);
		waitForDisplay(driver, SearchButton_Toolbar);
		
		waitForDisplay(driver, Country_SearchBtn_KYC_Details);
		if(isElementAccessible(driver, Country_SearchBtn_KYC_Details)) {
			System.out.println("Expected : Country Search button Should be Accessible  ||  Actual : Country Search button is Accessible ");
			Extent_pass_New(driver, "Expected : Country Search button Should be Accessible  ||  Actual : Country Search button is Accessible ", test, test1);
		}else {
			System.out.println("Expected : Country Search button Should be Accessible  ||  Actual : Country Search button is not Accessible ");
			Extent_fail(driver, "Expected : Country Search button Should be Accessible  ||  Actual : Country Search button is not Accessible ", test, test1);
		}
		
		
		waitForDisplay(driver, FieldName_Input_KYC_Details);
		if(isElementAccessible(driver, FieldName_Input_KYC_Details)) {
			System.out.println("Expected : Country Field Name input Should be Accessible || Actual : Country Field Name input is Accessible ");
			Extent_pass_New(driver, "Expected : Country Field Name input Should be Accessible || Actual : Country Field Name input is Accessible ", test, test1);
		}else {
			System.out.println("Expected : Country Field Name input Should be Accessible || Actual : Country Field Name input is not Accessible ");
			Extent_fail(driver, "Expected : Country Field Name input Should be Accessible || Actual : Country Field Name input is not Accessible ", test, test1);
		}
		
		waitForDisplay(driver, Mandatory_Fields_KYC_Details);
		if(isElementAccessible(driver, Mandatory_Fields_KYC_Details)) {
			System.out.println("Expected : Mandatory Select Input Should be Accessible || Actual : Mandatory Select Input is Accessible ");
			Extent_pass_New(driver, "Expected : Mandatory Select Input Should be Accessible || Actual : Mandatory Select Input is Accessible ", test, test1);
		}else {
			System.out.println("Expected : Mandatory Select Input Should be Accessible || Actual : Mandatory Select Input is not Accessible ");
			Extent_fail(driver, "Expected : Mandatory Select Input Should be Accessible || Actual : Mandatory Select Input is not Accessible ", test, test1);
		}
		
		Step_End(2, "Line and Agency users can access the Ecom KYC Detail module.", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
		
	}
	
}
