package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC15 extends Keywords{
	public void Haulage_Contract_SC15(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC15";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String condition = Excel_data.get("condition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Pickup_Location_Value = Excel_data.get("Pickup_Location_Value");
		String Port_Code_Header = Excel_data.get("Port_Code_Header");
		String Pickup_type_Value = Excel_data.get("Pickup_type_Value");
		String Pickup_Terminal_Value = Excel_data.get("Pickup_Terminal_Value");
		String Terminal_Code_Header = Excel_data.get("Terminal_Code_Header");
		String Drop_Type_Value = Excel_data.get("Drop_Type_Value");
		String Drop_Terminal_Value = Excel_data.get("Drop_Terminal_Value");
		String Equipment_Type = Excel_data.get("Equipment_Type");
		String HC_LDN_MTY_Value = Excel_data.get("HC_LDN_MTY_Value");
		String Drop_Loaction_Value = Excel_data.get("Drop_Loaction_Value");
		String Pick_Up_Term_Value = Excel_data.get("Pick_Up_Term_Value");
		String Drop_Term_Value = Excel_data.get("Drop_Term_Value");







		
		
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
			System.out.println("Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ");
			Extent_pass_New(driver, "Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ", test, test1);
		}else {
			System.out.println("Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ");
		    Extent_fail(driver, "Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ", test, test1);
		}
		
		Step_End(4, "It show the Haulage Contract input details page", test, test1);
		
		waitForElement(driver, HC_Pickup_Location_Search_Button);
		click(driver, HC_Pickup_Location_Search_Button);
		
		twoColumnMultipleSearchWindow(driver, Port_Code_Header, condition, Pickup_Location_Value);
		
		waitForElement(driver, HC_Pickup_Type_Dropdown);
		click(driver, HC_Pickup_Type_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Pickup_type_Value);
		
		
		waitForElement(driver, HC_Pickup_Terminal_Search_Button);
		click(driver, HC_Pickup_Terminal_Search_Button);
		
		twoColumnMultipleSearchWindow(driver, Terminal_Code_Header, condition, Pickup_Terminal_Value);
		
		
		waitForElement(driver, Hc_Drop_Loc_Search_Button);
		click(driver, Hc_Drop_Loc_Search_Button);
		
		twoColumnMultipleSearchWindow(driver, Port_Code_Header, condition, Drop_Loaction_Value);
		
		waitForElement(driver, HC_drop_Type_Dropdown);
		click(driver, HC_drop_Type_Dropdown);
		
		formatLocatorClick(driver, DropDown_Select, Drop_Type_Value);


		waitForElement(driver, HC_drop_Terminal_search_Button);
		click(driver, HC_drop_Terminal_search_Button);
		
		twoColumnMultipleSearchWindow(driver, Terminal_Code_Header, condition, Drop_Terminal_Value);
		
		waitForElement(driver, HC_Equipment_select);
		click(driver, HC_Equipment_select);
		
		  formatLocatorClick(driver, DropDown_Select, Equipment_Type);
		  
		
		  waitForElement(driver, HC_LDN_MTY_Select);
		click(driver, HC_LDN_MTY_Select);
			
	      formatLocatorClick(driver, DropDown_Select, HC_LDN_MTY_Value);
			  
			  
			  waitForElement(driver, HC_PickUp_Term);
			  click(driver, HC_PickUp_Term);
			  
		      formatLocatorClick(driver, DropDown_Select, Pick_Up_Term_Value);
		      
		      Step_Start(5, "Click the Drop term and select the value from the Drop down.", test, test1);
			  waitForElement(driver, HC_Drop_Term);
			  click(driver, HC_Drop_Term);
			  
		      formatLocatorClick(driver, DropDown_Select, Drop_Term_Value);
		      
		      
		      waitForElement(driver, HC_Drop_Term);
		     String drop_term_Act = getText(driver, HC_Drop_Term);
		     
		     if(Drop_Term_Value.equals(drop_term_Act)) {
		    	 System.out.println("Matched || Expected Result is : "+ Drop_Term_Value+ "||  Actual Result is :"+drop_term_Act );
		    	 Extent_pass_New(driver, "Matched || Expected Result is : "+ Drop_Term_Value+ "||  Actual Result is :"+drop_term_Act , test, test1);
		     }else {
		    	 System.out.println("Not Matched || Expected Result is : "+ Drop_Term_Value+ "||  Actual Result is :"+drop_term_Act );
		    	 Extent_fail(driver, "Not Matched || Expected Result is : "+ Drop_Term_Value+ "||  Actual Result is :"+drop_term_Act , test, test1);
		     }
		      
            Step_End(5, "Click the Drop term and select the value from the Drop down.", test, test1);
		    Extent_completed(testcase_Name, test, test1);  
	}

}
