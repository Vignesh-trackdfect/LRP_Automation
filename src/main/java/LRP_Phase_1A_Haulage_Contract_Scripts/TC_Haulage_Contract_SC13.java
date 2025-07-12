package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC13 extends Keywords{
	public void Haulage_Contract_SC13(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC13";
		
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
		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);

		
		Step_Start(3, "Click on the \"+\" Button to add the all details", test, test1);
		waitForElement(driver, HC_Vendor_Name_Field);
		String Vendor_Name = getAttribute(driver, HC_Vendor_Name_Field, "value");
		
		waitForElement(driver, HC_Plus_Button);
		click(driver, HC_Plus_Button);
		
		Step_End(3, "Click on the \"+\" Button to add the all details", test, test1);
		
		Step_Start(4, "It show the Haulage Contract input details page", test, test1);
		
		waitForDisplay(driver, HC_Haulage_Contract_Input_Page);
		if(isdisplayed(driver, HC_Haulage_Contract_Input_Page)) {
			System.out.println("Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ");
			Extent_pass_New(driver, "Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ", test, test1);
		}else {
			System.out.println("Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ");
		    Extent_fail(driver, "Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ", test, test1);
		}
		
		Step_End(4, "It show the Haulage Contract input details page", test, test1);
		
		Step_Start(5, "Vendor should auto fetch from the Haulage Contract screen", test, test1);
		waitForElement(driver, Hc_Vendor_Code_Input_details);
		String Vendor_code_Act = getAttribute(driver, Hc_Vendor_Code_Input_details, "value");
		
		waitForElement(driver, HC_Vendor_Name_Input_Details);
		String Vendor_Name_Act = getAttribute(driver, HC_Vendor_Name_Input_Details, "value");
		
		if(Vendor_Code.equals(Vendor_code_Act)) {
			System.out.println("Matched || Expected Result is : "+Vendor_Code + " || Accepted Result is : " +Vendor_code_Act);
			Extent_pass_New(driver, "Matched || Expected Result is : "+Vendor_Code + " || Accepted Result is : " +Vendor_code_Act, test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : "+Vendor_Code + " || Accepted Result is : " +Vendor_code_Act);
			Extent_fail(driver, "Not Matched || Expected Result is : "+Vendor_Code + " || Accepted Result is : " +Vendor_code_Act, test, test1);
		}
		
		if(Vendor_Name.equals(Vendor_Name_Act)) {
			System.out.println("Matched || Expected Result is : "+Vendor_Name + " || Accepted Result is : " +Vendor_Name_Act);
			Extent_pass_New(driver, "Matched || Expected Result is : "+Vendor_Name + " || Accepted Result is : " +Vendor_Name_Act, test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : "+Vendor_Name + " || Accepted Result is : " +Vendor_Name_Act);
			Extent_fail(driver, "Not Matched || Expected Result is : "+Vendor_Name + " || Accepted Result is : " +Vendor_Name_Act, test, test1);
		}
		
		Step_End(6, "Vendor should auto fetch from the Haulage Contract screen", test, test1);
		Extent_completed(testcase_Name, test, test1);

		
	}

}
