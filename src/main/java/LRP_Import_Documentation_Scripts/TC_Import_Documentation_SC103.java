package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC103 extends Keywords {

	public void Import_Documentation_SC103(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC103";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String import_Doc_Module_Search = Excel_data.get("Import_Doc_Module_Search");
		String global_Module_Search = Excel_data.get("Global_Module_Search");
		String global_Attribute_Data = Excel_data.get("Global_Attribute_Data");
		String global_Value = Excel_data.get("Global_Value");
		String default_value = Excel_data.get("default_value");
		String Reset_Global_Config = Excel_data.get("Reset_Global_Config");		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Extent_call(test, test1, " Global Configuration SetUp start");
	    setGlobalConfiguration(driver, global_Module_Search, global_Attribute_Data, global_Value);
		Extent_call(test, test1, " Global Configuration SetUp End");

		Step_Start(1, "open the Import Documentation.", test, test1);
		moduleNavigate(driver, import_Doc_Module_Search);
		Step_End(1, "open the Import Documentation.", test, test1);
		
		Step_Start(2, "In Import documentation module import invoice button has to be shown .", test, test1);
		waitForDisplay(driver, import_Invoice_Btn);
		if(isDisplayed(driver, import_Invoice_Btn)) {
			System.out.println("Expected : Import invoice button Should be display || Actual : Import invoice button is displayed");
			Extent_pass_New(driver, "Expected : Import invoice button Should be display || Actual : Import invoice button is displayed", test, test1);
		}else {
			System.out.println("Expected : Import invoice button Should be display || Actual : Import invoice button is not displayed");
			Extent_fail(driver, "Expected : Import invoice button Should be display || Actual : Import invoice button is not displayed", test, test1);
		}
		
		Step_End(2, "In Import documentation module import invoice button has to be shown .", test, test1);
		//reset to default
		
		Extent_call(test, test1, "Reser Global Configuration ");
		reSetGlobalConfiguration(driver, Reset_Global_Config, global_Module_Search, global_Attribute_Data, default_value);
		Extent_call(test, test1, "Reser Global Configuration ");

		Extent_completed(testcase_Name, test, test1);
	}
}
