package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_020 extends Keywords {

	public void Ecommerce_Gateway_Validator_020(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_020";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");

		String Transaction_Type_Value = Excel_data.get("Transaction_Type_Value");
		String From_Date_Value = Excel_data.get("From_Date_Value");
		String To_Date_Value = Excel_data.get("To_Date_Value");

		String Booking_Decline_popup = Excel_data.get("Booking_Decline_popup");
		String Decline_remark_text_Value = Excel_data.get("Decline_remark_text_Value");

		String Decline_popup_Exp = Excel_data.get("Decline_popup_Exp");

		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Module_Name);

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

		Step_Start(1, "The booking has been declined", test, test1);

		waitForElement(driver, Booking_Decline_Btn_Ecomm_Validator);
		click(driver, Booking_Decline_Btn_Ecomm_Validator);

		Step_End(1, "The booking has been declined", test, test1);

		Step_End(1, "decline this e-commerce booking", test, test1);

		waitForPopup(driver, popup_Message, Decline_popup_Exp);
		String Act_popup_Decline = getText(driver, popup_Message);
		if (Act_popup_Decline.contains(Decline_popup_Exp)) {
			System.out
					.println("Popup Matched : Expected : " + Decline_popup_Exp + "  || Actual : " + Act_popup_Decline);
			Extent_pass_New(driver,
					"Popup Matched : Expected : " + Decline_popup_Exp + "  || Actual : " + Act_popup_Decline, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched : Expected : " + Decline_popup_Exp + "  || Actual : " + Act_popup_Decline);
			Extent_fail(driver,
					"Popup Not Matched : Expected : " + Decline_popup_Exp + "  || Actual : " + Act_popup_Decline, test,
					test1);
		}

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(1, "decline this e-commerce booking", test, test1);

		waitForElement(driver, Decline_Remark_Input_EV);
		sendKeys(driver, Decline_Remark_Input_EV, Decline_remark_text_Value);

		waitForElement(driver, Decline_Remark_Ok_Btn_EV);
		click(driver, Decline_Remark_Ok_Btn_EV);

		Step_Start(3, "The booking has been declined", test, test1);

		waitForPopup(driver, popup_Message, Booking_Decline_popup);
		String Decline_Access = getText(driver, popup_Message);

		if (Decline_Access.equals(Booking_Decline_popup)) {
			System.out.println(
					"Matched || Excepted Popup : " + Booking_Decline_popup + " || Actual Popup : " + Decline_Access);
			Extent_pass_New(driver, "  Matched ||   Expected Popup : " + Booking_Decline_popup
					+ "   ||   Actual Popup    : " + Decline_Access, test, test1);
		} else {
			System.out.println(" Not Matched ||   Expected Popup  : " + Booking_Decline_popup
					+ "   ||   Actual Popup    : " + Decline_Access);
			Extent_fail(driver, " Not Matched ||   Expected Popup  : " + Booking_Decline_popup
					+ "   ||   Actual Popup    : " + Decline_Access, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(3, "The booking has been declined", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
