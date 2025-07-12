package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ecommerce_Gateway_Validator_031 extends Keywords {
	public void Ecommerce_Gateway_Validator_031(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_031";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String Transaction_Type = Excel_data.get("Transaction_Type");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		String DateCheckbox_Status = Excel_data.get("DateCheckbox_Status");
		String Given_From_Date = Excel_data.get("Given_From_Date");
		String Given_To_Date = Excel_data.get("Given_To_Date");
		String DatePicker = Excel_data.get("DatePicker");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Mismatch_Popup = Excel_data.get("Mismatch_Popup");
		String PopUp_Select_Option = Excel_data.get("PopUp_Select_Option");
		String Excepted_Update_PopUp = Excel_data.get("Excepted_Update_PopUp");
		String Excepted_Update_PopUp1 = Excel_data.get("Excepted_Update_PopUp1");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		Step_Start(1,"select the agency",test, test1);

		SwitchProfile(driver, AgencyName);

		Step_End(1,"select the agency",test, test1);
		Step_Start(2,"Click the refresh button on the e-commerce gateway.",test, test1);

		moduleNavigate(driver, Module_Name);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForDownload(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, Transaction_Type);

		if (DateCheckbox_Status.equals("Yes")) {

			checkBox(driver, EG_byDate_Checkbox, DateCheckbox_Status);

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_FromDate_Input);
				selectDatePicker(driver, EG_FromDate_Input, Given_From_Date);

			} else {

				waitForElement(driver, EG_FromDate_Input);
				clear(driver, EG_FromDate_Input);
				sendKeys(driver, EG_FromDate_Input, Given_From_Date);

			}

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_ToDate_Input);
				selectDatePicker(driver, EG_ToDate_Input, Given_To_Date);

			} else {

				waitForElement(driver, EG_ToDate_Input);
				clear(driver, EG_ToDate_Input);
				sendKeys(driver, EG_ToDate_Input, Given_To_Date);

			}

		} else {

			waitForElement(driver, EG_FromDate_Input);

			Given_From_Date = getAttribute(driver, EG_FromDate_Input, "value");
			Given_To_Date = getAttribute(driver, EG_ToDate_Input, "value");

		}

		waitForElement(driver, EG_NonProcessed_Checkbox);
		checkBox(driver, EG_NonProcessed_Checkbox, NonProcessed_yes);

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

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		Step_End(2,"Click the refresh button on the e-commerce gateway.",test, test1);
		Step_Start(3,"Booking and SI records show a grid.",test, test1);


		
		Step_Start(4,"Select SI row and double-click the e-commerce validator corrector module",test, test1);
		waitForElement(driver, First_Row_Grid_Ecomm_Gate_Way);
		doubleClick(driver, First_Row_Grid_Ecomm_Gate_Way);
		Step_End(3,"Booking and SI records show a grid.",test, test1);
		Step_End(4,"Select SI row and double-click the e-commerce validator corrector module",test, test1);
	
		Step_Start(5, "E-commerce validator corrector header tab shows mismatch details between booking SI and BL; popup validation should appear", test, test1);
		Step_Start(6, "Verify popup validation message: 'The header information between the SI and the Booking/BL is mismatched. Please confirm if you want to refresh the data from the Booking/BL.'", test, test1);

		waitForElement(driver, Accept_Btn_EComm_Validator);
		click(driver, Accept_Btn_EComm_Validator);
		
		waitForPopup(driver, EBK_Mismatch_Header_Message, Mismatch_Popup);
		String actualPopup=getText(driver, EBK_Mismatch_Header_Message);
		
		if(actualPopup.equals(Mismatch_Popup)) {
			System.out.println("Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup, test, test1);
		
		}
		Step_End(5, "E-commerce validator corrector header tab shows mismatch details between booking SI and BL; popup validation should appear", test, test1);
		Step_End(6, "Verify popup validation message: 'The header information between the SI and the Booking/BL is mismatched. Please confirm if you want to refresh the data from the Booking/BL.'", test, test1);

		
		Step_Start(7,"click (cancel) in popup validation msg",test, test1);

		waitForElement(driver, EBK_Mismatch_Header_Message_Cancel_Button);
		click(driver, EBK_Mismatch_Header_Message_Cancel_Button);
		
		Step_End(7,"click (cancel) in popup validation msg",test, test1);
		Step_Start(8, "Click 'Yes' or 'No' option and accept", test, test1);

		waitForElement(driver, Accept_Btn_EComm_Validator);
		click(driver, Accept_Btn_EComm_Validator);

		
		waitForPopup(driver, EBK_Mismatch_Header_Message, Mismatch_Popup);
		String actualPopup1=getText(driver, EBK_Mismatch_Header_Message);
		
		if(actualPopup1.equals(Mismatch_Popup)) {
			System.out.println("Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup1);
			Extent_pass_New(driver, "Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup1, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup1);
			Extent_fail(driver, "Not Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup1, test, test1);
		
		}
		if (PopUp_Select_Option.equalsIgnoreCase("Yes")) {

			waitForElement(driver, EBK_Mismatch_Header_Message_Yes_Button);
			click(driver, EBK_Mismatch_Header_Message_Yes_Button);


		}
		if (PopUp_Select_Option.equalsIgnoreCase("NO")) {

			waitForElement(driver, EBK_Mismatch_Header_Message_No_Button);
			click(driver, EBK_Mismatch_Header_Message_No_Button);


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
		
		Step_End(8, "Click 'Yes' or 'No' option and accept", test, test1);

		
		Extent_completed(testcase_Name, test, test1);
	}

}


