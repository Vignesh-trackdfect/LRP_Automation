package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_019 extends Keywords {

	public void Ecommerce_Gateway_Validator_019(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_019";

		
		

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
		String CRO_Popup = Excel_data.get("CRO_Popup");

		String TerminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String ReleaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String Acceptance_Terminal = Excel_data.get("Acceptance_Terminal");
		String Acceptance_TerminalDetails_Filter = Excel_data.get("Acceptance_TerminalDetails_Filter");
		String condition_Filter = Excel_data.get("condition_Filter");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Search_By = Excel_data.get("Search_By");
		String UpdatedPopup = Excel_data.get("UpdatedPopup");

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

		waitForElement(driver, EG_Retrieved_Record_AG_Gridcell);
		Step_End(3,"Booking and SI records show a grid.",test, test1);
		Step_Start(4,"Select SI row and double-click the e-commerce validator corrector module",test, test1);

		doubleClick(driver, EG_Retrieved_Record_AG_Gridcell);

		Step_End(4,"Select SI row and double-click the e-commerce validator corrector module",test, test1);
		Step_Start(5,"To accept the SI,  (Create the CRO) popup,    CRO not created system  doesn't allow to accept the  SI,",test, test1);


		waitForElement(driver, Accept_Btn_EComm_Validator);
		click(driver, Accept_Btn_EComm_Validator);
		

		waitForPopup(driver, popup_Message, CRO_Popup);
		String actualPopup=getText(driver, popup_Message);
		if(actualPopup.equals(CRO_Popup)) {
			System.out.println("Matched || Expected Popup : "+CRO_Popup+" || Actual Popup : "+actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup : "+CRO_Popup+" || Actual Popup : "+actualPopup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup : "+CRO_Popup+" || Actual Popup : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+CRO_Popup+" || Actual Popup : "+actualPopup, test, test1);
		
		}
		
		click(driver, popup_Message_Ok_Button);
		
		Step_End(5,"To accept the SI,  (Create the CRO) popup,    CRO not created system  doesn't allow to accept the  SI,",test, test1);
		Step_Start(6,"Booking  and CRO, kindly use scenario 46 ",test, test1);
		
		waitForElement(driver, Booking_Module_Navigate_Button);
		click(driver, Booking_Module_Navigate_Button);
		
		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);
		
//		waitForElement(driver, Edit_Button_toolBar);
//		click(driver, Edit_Button_toolBar);
		
		
//	CRO 
		
//		waitForElement(driver, CRO_btn);
//		click(driver, CRO_btn);

moduleNavigate(driver, CRO_Module_Name);
		
		Step_End(15, "Open \"Container release order\" module.", test, test1);
		Step_Start(16, "Search booking No.", test, test1);

		scrollTop(driver);
		waitForElement(driver, booking_No_SearchButton_CRO);
		click(driver, booking_No_SearchButton_CRO);
		
		Step_Start(17, "Enter the draft book number in search", test, test1);
		Step_Start(18, "Click search button.", test, test1);

		globalValueSearchWindow(driver, Global_Search_Condition, Search_By, booknum, "", "", "", "");
		
		
		Extent_cal(test, test1, "CRO");

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value = getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);

		if (!ReleaseDepTerminal.equals("")) {
			twoColumnSearchWindow(driver, TerminalDetails_Filter, condition_Filter, ReleaseDepTerminal);
		} else {
			twoColumnSearchWindow(driver, TerminalDetails_Filter, condition_Filter, acc_term_value);
		}
		
		if(!Acceptance_Terminal.equals("")) {
			waitForElement(driver, acceptance_Terminal_SearchButton_CRO);
			click(driver, acceptance_Terminal_SearchButton_CRO);
			twoColumnSearchWindow(driver, Acceptance_TerminalDetails_Filter, condition_Filter, Acceptance_Terminal);
		}
		Step_Start(7,"CRO is created",test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);

		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		
		Step_End(6,"Booking  and CRO, kindly use scenario 46 ",test, test1);

		Step_End(7,"CRO is created",test, test1);
		Step_Start(8,"To accept the SI, click the accept button once the actual BL number is generated",test, test1);

		waitForElement(driver, Accept_Btn_EComm_Validator);
		click(driver, Accept_Btn_EComm_Validator);
		
		waitForPopup(driver, popup_Message, UpdatedPopup);
		 actualPopup=getText(driver, popup_Message);
		if (actualPopup.contains(UpdatedPopup)) {
			System.out.println("Matched || The Excepted POPUP Msg is : " + UpdatedPopup
					+ " || The Actual PopUP Msg is : " + actualPopup);
			Extent_pass_New(driver, "Matched || The Excepted POPUP Msg is : " + UpdatedPopup
					+ " || The Actual PopUP Msg is : " + actualPopup, test, test1);

			click(driver, popup_Message_Ok_Button);

		}else {
			System.out.println(" Not Matched || The Excepted POPUP Msg is : " + UpdatedPopup
					+ " || The Actual PopUP Msg is : " + actualPopup);
			Extent_fail(driver, " Not Matched || The Excepted POPUP Msg is : " + UpdatedPopup
					+ "|| The Actual PopUP Msg is : " + actualPopup, test, test1);

		}
		
		
		Step_End(8,"To accept the SI, click the accept button once the actual BL number is generated",test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
