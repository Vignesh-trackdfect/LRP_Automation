package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_025 extends Keywords {

	public void Ecommerce_Gateway_Validator_025(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_025";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Ecomm_Gateway_Module = Excel_data.get("Ecomm_Gateway_Module");
		String CustomerTab_Header_Name = Excel_data.get("CustomerTab_Header_Name");
		String AP_Not_Remove_Popup = Excel_data.get("AP_Not_Remove_Popup");

		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String Transaction_Type_Value = Excel_data.get("Transaction_Type_Value");
		String From_Date_Value = Excel_data.get("From_Date_Value");
		String To_Date_Value = Excel_data.get("To_Date_Value");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Ecomm_Gateway_Module);

		Step_Start(1, " Enter the Agreement Party ", test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		String Transaction_type_Select = String.format(EG_Select_Transaction_type, Transaction_Type_Value);
		waitForElement(driver, Transaction_type_Select);
		click(driver, Transaction_type_Select);

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
		
		Step_End(1, " Enter the Agreement Party ", test, test1);

		Step_Start(2, " Enter the POL and POD and select the Rates using Rates window ", test, test1);
		Step_End(2, " Enter the POL and POD and select the Rates using Rates window ", test, test1);

		Step_Start(3, " Select the Routing ", test, test1);
		Step_End(3, " Select the Routing  ", test, test1);

		Step_Start(4, " Select the Schedule ", test, test1);
		Step_End(4, " Select the Schedule   ", test, test1);

		Step_Start(5, " Click the save button to save the changes ", test, test1);
		Step_End(5, "Click the save button to save the changes ", test, test1);

		Step_Start(6,
				"  To accept the booking, click the accept button once the actual booking number is generated.          ",
				test, test1);
		Step_End(6,
				"  To accept the booking, click the accept button once the actual booking number is generated.          ",
				test, test1);

		Step_Start(7,
				" Select the AP Customer and click remove button Agr.Party can not be removed validate the message",
				test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		if (isDisplayed(driver, popup_Message)) {
			waitForDownload(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}

		waitForElement(driver, Header_Panel_EComm_Validator);
		String Customer_header = String.format(Header_Panel_List_Ecomm_Validator, CustomerTab_Header_Name);
		waitForElement(driver, Customer_header);
		click(driver, Customer_header);

		waitForElement(driver, Customer_Table_EComm_Validator);

		waitForElement(driver, AP_Column_CustomerTable_EComm_Validator);
		click(driver, AP_Column_CustomerTable_EComm_Validator);

		waitForElement(driver, Remove_Btn_Customer_EComm_Validator);
		click(driver, Remove_Btn_Customer_EComm_Validator);

		waitForPopup(driver, popup_Message, AP_Not_Remove_Popup);
		String Act_Popup = getText(driver, popup_Message);
		if (Act_Popup.equals(AP_Not_Remove_Popup)) {
			System.out.println("Popup Matched || Expected : " + AP_Not_Remove_Popup + "  ||  Actual  : " + Act_Popup);
			Extent_pass_New(driver, "Popup Matched || Expected : " + AP_Not_Remove_Popup + "  ||  Actual  : " + Act_Popup,
					test, test1);
		} else {
			System.out
					.println("Popup Not Matched || Expected : " + AP_Not_Remove_Popup + "  ||  Actual  : " + Act_Popup);
			Extent_fail(driver,
					"Popup Not Matched || Expected : " + AP_Not_Remove_Popup + "  ||  Actual  : " + Act_Popup, test,
					test1);
		}

		click(driver, popup_Message_Ok_Button);
		Step_End(7, " Select the AP Customer and click remove button Agr.Party can not be removed validate the message",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
