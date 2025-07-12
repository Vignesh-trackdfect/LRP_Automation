package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC20 extends Keywords{
	public void Haulage_Contract_SC20(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC20";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String condition = Excel_data.get("condition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String User_Name_Input = Excel_data.get("User_Name_Input");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Neg_On_Date = Excel_data.get("Neg_On_Date");



		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		Step_Start(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		moduleNavigate(driver, Haulage_Contract_Module_Name);
		
		Step_End(1, ".Enter the  screen name as ' Haulage contracts' in module search field.", test, test1);
		
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
		
		Step_Start(5, ".Click the Neg on date and select the date", test, test1);
		
		
		
		
		waitForElement(driver, HC_Neg_on_date);
		selectDatePicker(driver, HC_Neg_on_date, Neg_On_Date);
		
		
		waitForElement(driver, HC_Neg_on_date);
		   String HC_From_Date_Act = getAttribute(driver, HC_Neg_on_date,"value");
		   if(Neg_On_Date.equalsIgnoreCase(HC_From_Date_Act)) {
	        	 System.out.println("Matched ||Expected Value taken in test data for selecting Neg On :"+ Neg_On_Date + "|| Actual Value taken in Neg On Date in Application: "+ HC_From_Date_Act);
	        	 Extent_pass_New(driver, "Matched ||Expected Value taken in test data for selecting Neg On:"+ Neg_On_Date + " ||Actual Value taken in Neg On Date in Application  : "+ HC_From_Date_Act, test, test1);
	         }else {
	        	 System.out.println("NotMatched ||Expected Value taken in test data for selecting Neg On:"+ Neg_On_Date + " ||Actual Value taken in Neg On Date in Application : "+ HC_From_Date_Act);
	             Extent_fail(driver, "NotMatched ||Expected Value taken in test data for selecting Neg On:"+ Neg_On_Date + " ||Actual Value taken in Neg On Date in Application: "+ HC_From_Date_Act, test, test1);
	         }
		
		   Step_End(5, ".Click the Neg on date and select the date", test, test1);
		   Step_Start(6, ".Click the Neg by.Search field and select the value.", test, test1);
			
		waitForElement(driver, HC_Neg_by_Input);
		click(driver, HC_Neg_by_Input);
		
		twoColumnMultipleSearchWindow(driver, User_Name_Header, condition, User_Name_Input);
		
		waitForElement(driver, HC_Neg_by_Input_Value);
         String Pickup_Location_Value_Act = getAttribute(driver, HC_Neg_by_Input_Value, "value");	
         
         if(User_Name_Input.equals(Pickup_Location_Value_Act)) {
        	 System.out.println("Matched|| Expected  User name Value taken from Test Data :"+User_Name_Input + " || Actual User name Value taken from Application : "+Pickup_Location_Value_Act);
        	 Extent_pass_New(driver, "Matched|| Expected User name Value taken from Test Data :"+User_Name_Input + "||  Actual User name Value taken from Application : "+Pickup_Location_Value_Act, test, test1);
         }else {
        	 System.out.println("NotMatched|| Expected User name Value taken from Test Data :"+User_Name_Input + " || Actual User name Value taken from Application : "+Pickup_Location_Value_Act);
             Extent_fail(driver, "NotMatched|| Expected User name Value taken from Test Data :"+User_Name_Input + " || Actual User name Value taken from Application : "+Pickup_Location_Value_Act, test, test1);
         }
		
         Step_End(6, ".Click the Neg by.Search field and select the value.", test, test1);
         Extent_completed(testcase_Name, test, test1);
		
	}

}
