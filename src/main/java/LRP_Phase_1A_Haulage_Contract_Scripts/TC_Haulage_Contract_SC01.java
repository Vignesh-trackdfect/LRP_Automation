package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC01 extends Keywords{
	public void Haulage_Contract_SC01(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC01";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String condition = Excel_data.get("condition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");


		
		
		

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		Step_Start(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		moduleNavigate(driver, Haulage_Contract_Module_Name);
		
		Step_End(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
	
		
		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);
		
		waitForElement(driver, Vendor_Search_Button);
		click(driver, Vendor_Search_Button);
		
		twoColumnMultipleSearchWindow(driver, Vendor_Code_Header, condition, Vendor_Code);
		
		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);
		
		waitForElement(driver, Vendor_code_Field);
		String Vendor_code_Value = getAttribute(driver, Vendor_code_Field,"value");
		
		if(Vendor_Code.equals(Vendor_code_Value)) {
			System.out.println("Matched || Expected Vendor Code : "+Vendor_Code+ " ||  Actual Vendor Code  : " +Vendor_code_Value);
			Extent_pass_New(driver, "Matched || Expected Vendor Code : "+Vendor_Code+ " ||  Actual Vendor Code  : " +Vendor_code_Value, test, test1);
		}else {
			System.out.println("Not Matched || Expected Vendor Code : "+Vendor_Code+ " ||  Actual Vendor Code  : " +Vendor_code_Value);
			Extent_fail(driver, "Not Matched || Expected Vendor Code : "+Vendor_Code+ " ||  Actual Vendor Code  : " +Vendor_code_Value, test, test1);
		}
			
		Extent_completed(testcase_Name, test, test1);
	}

}
