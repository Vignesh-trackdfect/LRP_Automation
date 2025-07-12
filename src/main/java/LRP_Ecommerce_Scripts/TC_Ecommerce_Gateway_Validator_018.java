package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_018 extends Keywords {

	public void Ecommerce_Gateway_Validator_018(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_018";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");

		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Archive_Condition = Excel_data.get("Archive_Condition");
	
		String Transaction_Type_Value = Excel_data.get("Transaction_Type_Value");
		String From_Date_Value = Excel_data.get("From_Date_Value");
		String To_Date_Value = Excel_data.get("To_Date_Value");
		
		String Master_Header_Name = Excel_data.get("Master_Header_Name");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Module_Name);
		
    	Step_Start(1, " Click the Edit button and change the booking  & SI details ", test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver,EG_Transaction_type);
		
		String Transaction_type_Select=String.format(EG_Select_Transaction_type, Transaction_Type_Value);
		waitForElement(driver, Transaction_type_Select);
		click(driver,Transaction_type_Select);
				
		waitForElement(driver, EG_NonProcessed_Checkbox);
		checkBox(driver, EG_NonProcessed_Checkbox, NonProcessed_yes);
		
		waitForElement(driver, EG_FromDate_Input);
		selectDatePicker(driver, EG_FromDate_Input, From_Date_Value);
		
		waitForElement(driver, EG_ToDate_Input);
		selectDatePicker(driver, EG_ToDate_Input, To_Date_Value);
		
		
		if (Archive_Condition.equals("Yes")) {

			waitForElement(driver, EG_Archive_Checkbox);
			checkBox(driver, EG_Archive_Checkbox, Archive_Condition);

		}
		
		if (!Booking_Number.equals("")) {
			waitForElement(driver, EG_BookingNo_input);
			sendKeys(driver, EG_BookingNo_input, Booking_Number);
		}

		if (!Reference_Number.equals("")) {
			waitForElement(driver, EG_ReferenceNo_Input);
			sendKeys(driver, EG_ReferenceNo_Input, Reference_Number);
		}

		if (!bl_NumberInput.equals("")) {
			waitForElement(driver, EG_BLNo_input);
			sendKeys(driver, EG_BLNo_input, bl_NumberInput);
		}

		waitForDownload(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Retrieved_Record_AG_Gridcell);
		doubleClick(driver, EG_Retrieved_Record_AG_Gridcell);
		
		waitForElement(driver, Header_Panel_EComm_Validator);
		waitForElement(driver, Edit_Button_toolBar);
    	click(driver,Edit_Button_toolBar );
    	Step_End(1, " Click the Edit button and change the booking  & SI details ", test, test1);

    	Step_Start(2, " Click Route button (EDIT) ", test, test1);

		String Master_header=String.format(Header_Panel_List_Ecomm_Validator, Master_Header_Name);
		waitForElement(driver, Master_header);
		click(driver,Master_header);
    
		waitForElement(driver, Routing_Add_Btn_EComm_Validator);
		click(driver,Routing_Add_Btn_EComm_Validator);
		
		waitForDisplay(driver, Routing_Select_Tab_EComm_Validator);
		if(isDisplayed(driver, Routing_Select_Tab_EComm_Validator)) {
			System.out.println("Expected : Routing window should be display after clicking the Routing Add/Edit button || Actual : Routing window  displayed after clicking the Routing Add/Edit button");
			Extent_pass_New(driver, "Expected : Routing window should be display after clicking the Routing Add/Edit button || Actual : Routing window  displayed after clicking the Routing Add/Edit button", test, test1);
		}else {
			System.out.println("Expected : Routing window should be display after clicking the Routing Add/Edit button || Actual : Routing window not displayed after clicking the Routing Add/Edit button");
			Extent_fail(driver, "Expected : Routing window should be display after clicking the Routing Add/Edit button || Actual : Routing window not displayed after clicking the Routing Add/Edit button", test, test1);
		}
    	Step_End(2, " Click Route button (EDIT) ", test, test1);

		Extent_completed(testcase_Name, test, test1);

		
	}	
}
