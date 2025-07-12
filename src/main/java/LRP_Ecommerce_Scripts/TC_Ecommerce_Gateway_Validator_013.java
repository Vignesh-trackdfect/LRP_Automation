package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ecommerce_Gateway_Validator_013 extends Keywords {
	public void Ecommerce_Gateway_Validator_013(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_013";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		String Excepted_Save_PopUp = Excel_data.get("Excepted_Save_PopUp");
		String Excepted_Save_PopUp1 = Excel_data.get("Excepted_Save_PopUp1");
		String Excepted_Update_PopUp = Excel_data.get("Excepted_Update_PopUp");
		String Excepted_Update_PopUp1 = Excel_data.get("Excepted_Update_PopUp1");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);
		Step_Start(1, "select the agency ", test, test1);
		if (!AgencyName.equals("")) {
			SwitchProfile(driver, AgencyName);
		}
		Step_End(1, "select the agency ", test, test1);
		moduleNavigate(driver, Module_Name);

		Step_Start(2, "Click the refresh button on the e-commerce gateway.", test, test1);

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

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		Step_End(2, "Click the refresh button on the e-commerce gateway.", test, test1);
		Step_Start(3, "Booking and SI records show a grid.", test, test1);

		Step_Start(4, "Select booking row and double-click the e-commerce validator", test, test1);

		waitForElement(driver, First_Row_Grid_Ecomm_Gate_Way);
		doubleClick(driver, First_Row_Grid_Ecomm_Gate_Way);

		Step_End(3, "Booking and SI records show a grid.", test, test1);
		Step_End(4, "Select booking row and double-click the e-commerce validator", test, test1);
		Step_Start(5, "Click the Edit button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(5, "Click the Edit button", test, test1);
		Step_Start(6, "cilck the save button ,  E-Commerce Booking Saved", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Excepted_Save_PopUp);
		String ActualP_Save_PopUp = getText(driver, popup_Message);

		if (Excepted_Save_PopUp.equals(ActualP_Save_PopUp)) {
			System.out.println("Matched || The Excepted POPUP Msg is : " + Excepted_Save_PopUp
					+ " || The Actual PopUP Msg is : " + ActualP_Save_PopUp);
			Extent_pass_New(driver, "Matched || The Excepted POPUP Msg is : " + Excepted_Save_PopUp
					+ " || The Actual PopUP Msg is : " + ActualP_Save_PopUp, test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		} else if (Excepted_Save_PopUp1.equals(ActualP_Save_PopUp)) {
			System.out.println("Matched || The Excepted POPUP Msg is : " + Excepted_Save_PopUp1
					+ " || The Actual PopUP Msg is : " + ActualP_Save_PopUp);
			Extent_pass_New(driver, "Matched || The Excepted POPUP Msg is : " + Excepted_Save_PopUp1
					+ " || The Actual PopUP Msg is : " + ActualP_Save_PopUp, test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}

		else {
			System.out.println(" Not Matched || The Excepted POPUP Msg is : " + Excepted_Save_PopUp
					+ "|| The Actual PopUP Msg is : " + ActualP_Save_PopUp);
			Extent_fail(driver, " Not Matched || The Excepted POPUP Msg is : " + Excepted_Save_PopUp
					+ " || The Actual PopUP Msg is : " + ActualP_Save_PopUp, test, test1);

		}

		Step_End(6, "cilck the save button ,  E-Commerce Booking Saved", test, test1);

		Step_Start(7,
				" To accept the booking, click the accept button once the actual booking number is generated,  Booking has been created  ",
				test, test1);

		waitForElement(driver, EBK_Accecpt_Button);
		click(driver, EBK_Accecpt_Button);
		waitForDisplay(driver, Update_Booking_Checbox_Ecomm_Validator);

		if (isdisplayed(driver, Update_Booking_Checbox_Ecomm_Validator)) {

			waitForElement(driver, Update_Booking_Checbox_Ecomm_Validator);
			click(driver, Update_Booking_Checbox_Ecomm_Validator);

		}
		waitForElement(driver, Submit_Btn_EComm_Validator);
		click(driver, Submit_Btn_EComm_Validator);
		waitForPopup(driver, popup_Message, Excepted_Update_PopUp);
		String ActualP_Update_PopUp = getText(driver, popup_Message);

		if (ActualP_Update_PopUp.contains(Excepted_Update_PopUp)) {
			System.out.println("Matched || The Excepted POPUP Msg is : " + Excepted_Update_PopUp
					+ " || The Actual PopUP Msg is : " + ActualP_Update_PopUp);
			Extent_pass_New(driver, "Matched || The Excepted POPUP Msg is : " + Excepted_Update_PopUp
					+ " || The Actual PopUP Msg is : " + ActualP_Update_PopUp, test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		} else if (ActualP_Update_PopUp.contains(Excepted_Update_PopUp1)) {
			System.out.println("Matched || The Excepted POPUP Msg is : " + Excepted_Update_PopUp1
					+ "|| The Actual PopUP Msg is : " + ActualP_Update_PopUp);
			Extent_pass_New(driver, "Matched || The Excepted POPUP Msg is : " + Excepted_Update_PopUp1
					+ "||The Actual PopUP Msg is : " + ActualP_Update_PopUp, test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}

		else {
			System.out.println(" Not Matched || The Excepted POPUP Msg is : " + Excepted_Update_PopUp
					+ " || The Actual PopUP Msg is : " + ActualP_Update_PopUp);
			Extent_fail(driver, " Not Matched || The Excepted POPUP Msg is : " + Excepted_Update_PopUp
					+ "|| The Actual PopUP Msg is : " + ActualP_Update_PopUp, test, test1);

		}

		Step_End(7,
				" To accept the booking, click the accept button once the actual booking number is generated,  Booking has been created  ",
				test, test1);
		Extent_completed(testcase_Name, test, test1);
	}

}
