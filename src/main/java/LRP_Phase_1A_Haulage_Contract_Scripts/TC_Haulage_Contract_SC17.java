package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC17 extends Keywords{
	public void Haulage_Contract_SC17(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC17";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String condition = Excel_data.get("condition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Haulage_mode_Value = Excel_data.get("Haulage_mode_Value");



		
		
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

		Step_Start(3, "Click on the \"+\" Button to add the all details ", test, test1);
		waitForElement(driver, HC_Plus_Button);
		click(driver, HC_Plus_Button);
		
		Step_End(3, "Click on the \"+\" Button to add the all details ", test, test1);
		
		
		Step_Start(4, "It show the Haulage Contract input details page", test, test1);
		waitForDisplay(driver, HC_Haulage_Contract_Input_Page);
		if(isdisplayed(driver, HC_Haulage_Contract_Input_Page)) {
			System.out.println("Matched||Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ");
			Extent_pass_New(driver, "Matched||Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ", test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ");
			Extent_fail(driver, "NotMatched||Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ", test, test1);
		}
		Step_End(4, "It show the Haulage Contract input details page", test, test1);
		
	 	Step_Start(5, ".Click the H.mode and select the value from the Drop down..", test, test1);
		
		waitForElement(driver, HC_H_Mode);
		click(driver, HC_H_Mode);
		
		
		
		
           formatLocatorClick(driver, DropDown_Select, Haulage_mode_Value);
		waitForElement(driver, HC_drop_Type_Dropdown);
		
         String HC_H_Mode_Actual = getText(driver, HC_H_Mode);	
         
         if(HC_H_Mode_Actual.contains(Haulage_mode_Value)) {
        	 System.out.println("Matched||Expected Value taken in test data for selecting Haulage mode :"+ Haulage_mode_Value + " || Actual Value taken in  Haulage mode in Dropdown: "+ HC_H_Mode_Actual);
        	 Extent_pass_New(driver, "Matched||Expected Value taken in test data for selecting Haulage mode:"+ Haulage_mode_Value + "|| Actual Value taken in Haulage mode in Dropdown  : "+ HC_H_Mode_Actual, test, test1);
         }else {
        	 System.out.println("NotMatched||Expected Value taken in test data for selecting Haulage mode:"+ Haulage_mode_Value + " || Actual Value taken in  Haulage mode in Dropdown : "+ HC_H_Mode_Actual);
             Extent_fail(driver, "NotMatched||Expected Value taken in test data for selecting Haulage mode :"+ Haulage_mode_Value + " || Actual Value taken in  Haulage mode in Dropdown: "+ HC_H_Mode_Actual, test, test1);
         }
		
     	
 	 	Step_End(5, ".Click the H.mode and select the value from the Drop down..", test, test1);
 		
         Extent_completed(testcase_Name, test, test1);
		
	}

}
