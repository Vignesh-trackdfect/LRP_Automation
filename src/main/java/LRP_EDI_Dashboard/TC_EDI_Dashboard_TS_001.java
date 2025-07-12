package LRP_EDI_Dashboard;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Dashboard_TS_001 extends Keywords {

	public void EDI_Dashboard_TS_001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_EDI_Dashboard_TS_001";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String EDI_Dashboard_Module = Excel_data.get("EDI_Dashboard_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String Column_condition = Excel_data.get("Column_condition");
		String Agency_Code_Input = Excel_data.get("Agency_Code_Input");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID_Value = Excel_data.get("EDI_ID_Value");
		String Mess_Function_Drop_Down = Excel_data.get("Mess_Function_Drop_Down");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String POL = Excel_data.get("POL");
		String BL_Numbers = Excel_data.get("BL_Numbers");
		String Exp_Generate_Edi_Popup = Excel_data.get("Exp_Generate_Edi_Popup");
		String Operation_Type_Dropdown = Excel_data.get("Operation_Type_Dropdown");
		String Dynamic_Data_Col = Excel_data.get("Dynamic_Data_Col");
		String Dynamic_Data_Input = Excel_data.get("Dynamic_Data_Input");
		String Select_All_data = Excel_data.get("Select_All_data");
		String Show_button = Excel_data.get("Show_button");
		String EDI_Tracker_Headers = Excel_data.get("EDI_Tracker_Headers");
		String Status_Completed = Excel_data.get("Status_Completed");
		String EXP_Backround_Color = Excel_data.get("EXP_Backround_Color");
		String Exp_Reset_Popup = Excel_data.get("Exp_Reset_Popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);
		moduleNavigate(driver, EDI_Dashboard_Module);

		Step_Start(1, "Enter the agency code ", test, test1);

		waitForElement(driver, EDI_DB_Agency_Button);
		click(driver, EDI_DB_Agency_Button);

		twoColumnSearchWindow(driver, AgencyCode_Header, Column_condition, Agency_Code_Input);

		Step_End(1, "Enter the agency code ", test, test1);

		Step_Start(2, "Enter the EDI details", test, test1);

		waitForElement(driver, EDI_DB_EDI_Buttton);
		click(driver, EDI_DB_EDI_Buttton);

		twoColumnMultipleSearchWindow(driver, EDI_ID_Header, Column_condition, EDI_ID_Value);

		Step_End(2, "Enter the EDI details", test, test1);

		Step_Start(3, "Select  Msg. Function dropdown \r\n" + " or else if it is disable skip it", test, test1);

		waitForElement(driver, EDI_DB_Mess_Enable);
		String FunctionDrop = getAttribute(driver, EDI_DB_Mess_Enable, "class");
		if (!FunctionDrop.contains("disabled")) {
			waitForElement(driver, EDI_DB_Mess_Function_Dropdwn);
			click(driver, EDI_DB_Mess_Function_Dropdwn);
			formatLocatorClick(driver, EDI_DB_Select_Mess_fuction, Mess_Function_Drop_Down);
		}

		Step_End(3, "Select  Msg. Function dropdown \r\n" + " or else if it is disable skip it", test, test1);

		Step_Start(4,
				"If the  Dynamic data button as been shows then click the dynamic data button and enter the value ",
				test, test1);

		waitForElement(driver, EDI_DB_Dynamic_Data_Button);
		click(driver, EDI_DB_Dynamic_Data_Button);

		List<String> Element_Header_name = splitAndExpand(Dynamic_Data_Col, ",");
		List<String> Element_Input_value = splitAndExpand(Dynamic_Data_Input, ",");

		for (int v = 0; v < Element_Header_name.size(); v++) {

			String inputColumn = String.format(EDI_Dynamic_Data_Table, Element_Header_name.get(v));
			waitForElement(driver, inputColumn);
			click(driver, inputColumn);
			mouseOverToElement(driver, inputColumn);
			waitForElement(driver, inputColumn);
			doubleClick(driver, inputColumn);

			String ValueInput = String.format(EDI_Dynamic_Data_Input_Table, Element_Header_name.get(v));
			waitForElement(driver, ValueInput);
			mouseOverToElement(driver, ValueInput);
			sendKeys(driver, ValueInput, Element_Input_value.get(v));
			enter(driver);

		}

		waitForElement(driver, EDI_Dynamic_Apply_Button);
		click(driver, EDI_Dynamic_Apply_Button);

		Step_Start(5,
				"If the  Dynamic data button as been shows then click the dynamic data button and enter the value ",
				test, test1);

		waitForDisplay(driver, EDI_DB_Operation_Type_DropDown);
		String FunctionDrop1 = getAttribute(driver, EDI_DB_Mess_Enable, "class");
		if (!FunctionDrop1.contains("disabled")) {

			waitForElement(driver, EDI_DB_Operation_Type_DropDown);
			click(driver, EDI_DB_Operation_Type_DropDown);

			formatLocatorClick(driver, EDI_DB_Operation_Type_Option, Operation_Type_Dropdown);
		}
		Step_End(5, "If the  Dynamic data button as been shows then click the dynamic data button and enter the value ",
				test, test1);

		Step_Start(6, "And enter the value in the service field ", test, test1);
		Step_Start(7, "Select value from the favitor search option ", test, test1);
		Step_Start(8, "After the values are set in ", test, test1);
		Step_Start(9, "Service,vessel,voyage,bound,pol / pod\r\n" + " then click the show button", test, test1);

		waitForElement(driver, EDI_Service_Code_Input);
		sendKeys(driver, EDI_Service_Code_Input, Service_Code);

		waitForElement(driver, EDI_DB_Vessel_input);
		clear(driver, EDI_DB_Vessel_input);
		waitForElement(driver, EDI_DB_Vessel_input);
		sendKeys(driver, EDI_DB_Vessel_input, Vessel_Code);

		waitForElement(driver, EDI_DB_Voyage_Input);
		clear(driver, EDI_DB_Voyage_Input);
		waitForElement(driver, EDI_DB_Voyage_Input);
		sendKeys(driver, EDI_DB_Voyage_Input, Voyage);

		waitForElement(driver, EDI_DB_Bound);
		clear(driver, EDI_DB_Bound);
		waitForElement(driver, EDI_DB_Bound);
		sendKeys(driver, EDI_DB_Bound, Bound);

		waitForElement(driver, EDI_DB_POL);
		clear(driver, EDI_DB_POL);
		waitForElement(driver, EDI_DB_POL);
		sendKeys(driver, EDI_DB_POL, POL);

		waitForElement(driver, EDI_DB_Service_First_Row);
		doubleClick(driver, EDI_DB_Service_First_Row);

		waitForElement(driver, EDI_DB_Show_Button);
		click(driver, EDI_DB_Show_Button);

		String EDI_TrackerFilterValue = "SERVICE = " + Service_Code + ", VESSEL = " + Vessel_Code + ", VOYAGE = "
				+ Voyage + "";

		Step_End(9, "Service,vessel,voyage,bound,pol / pod\r\n" + " then click the show button", test, test1);
		Step_End(8, "After the values are set in ", test, test1);
		Step_End(7, "Select value from the favitor search option ", test, test1);
		Step_End(6, "And enter the value in the service field ", test, test1);

		Step_Start(10, "Then values are showed in the grid select record and click the generate EDI button ", test,
				test1);

		List<String> Numbers = splitAndExpand(BL_Numbers, ",");

		if (Select_All_data.equalsIgnoreCase("Yes")) {

			waitForElement(driver, EDI_DB_Select_All_CheckBox);
			click(driver, EDI_DB_Select_All_CheckBox);

		} else {

			for (int i = 0; i < Numbers.size(); i++) {

				String Bl_Numbers_value = String.format(EDI_DB_Grid_Select_All, Numbers.get(i));

				waitForElement(driver, Bl_Numbers_value);
				click(driver, Bl_Numbers_value);

			}

		}

		waitForElement(driver, EDI_DB_Generate_EDI_Button);
		click(driver, EDI_DB_Generate_EDI_Button);

		Step_End(10, "Then values are showed in the grid select record and click the generate EDI button ", test,
				test1);

		Step_Start(11, "EDI Request submitted successfully notification as been shows  ", test, test1);

		waitForPopup(driver, popup_Message, Exp_Generate_Edi_Popup);
		String Act_Popup = getText(driver, popup_Message);
		if (Exp_Generate_Edi_Popup.equals(Act_Popup)) {
			System.out.println("Popup Matched ||  Expected : " + Exp_Generate_Edi_Popup + " || Actual : " + Act_Popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + Exp_Generate_Edi_Popup + " || Actual : " + Act_Popup, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + Exp_Generate_Edi_Popup + " || Actual : " + Act_Popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + Exp_Generate_Edi_Popup + " || Actual : " + Act_Popup, test,
					test1);
		}

		Step_End(11, "EDI Request submitted successfully notification as been shows  ", test, test1);

		Step_Start(12, ".Click Yes button ", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(12, ".Click Yes button ", test, test1);

		Step_Start(13, "It will navigation EDI tracker ", test, test1);

		waitForDisplay(driver, EDI_Tracks_Show_Button);
		if (isdisplayed(driver, EDI_Tracks_Show_Button)) {
			System.out.println(
					"Matched || Expected: Once EDI Request is submitted successfully, it should navigate to the EDI Tracker module || Actual: Once EDI Request is submitted successfully, it navigates to the EDI Tracker module");
			Extent_pass_New(driver,
					"Matched || Expected: Once EDI Request is submitted successfully, it should navigate to the EDI Tracker module || Actual: Once EDI Request is submitted successfully, it navigates to the EDI Tracker module",
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected: Once EDI Request is submitted successfully, it should navigate to the EDI Tracker module || Actual: Once EDI Request is submitted successfully, it Not navigates to the EDI Tracker module");
			Extent_fail(driver,
					"Not Matched || Expected: Once EDI Request is submitted successfully, it should navigate to the EDI Tracker module || Actual: Once EDI Request is submitted successfully, it NOt navigates to the EDI Tracker module",
					test, test1);
		}

		Step_End(13, "It will navigation EDI tracker ", test, test1);

		Step_Start(14, "Now click the show button until status as been compelted(2min)", test, test1);

		waitForElement(driver, EDI_Tracks_Show_Button);
		click(driver, EDI_Tracks_Show_Button);

		int ShowLimit = Integer.parseInt(Show_button);

		for (int k = 0; k < ShowLimit; k++) {

			waitForElement(driver, EDI_Track_Filter_Option);
			click(driver, EDI_Track_Filter_Option);

			reArrangeAG_GridColumns(driver, EDI_Tracker_Headers);

			waitForElement(driver, EDI_DB_Input_Details);
			Newclear(driver, EDI_DB_Input_Details);
			sendKeys(driver, EDI_DB_Input_Details, EDI_TrackerFilterValue);

			waitForElement(driver, EDI_Track_Input_Status_Field);
			String Act_Val = getText(driver, EDI_Track_Input_Status_Field);
			if (Act_Val.equalsIgnoreCase(Status_Completed)) {
				waitForElement(driver, EDI_Tracks_Show_Button);
				click(driver, EDI_Tracks_Show_Button);
				break;
			}

			waitForElement(driver, EDI_Tracks_Show_Button);
			click(driver, EDI_Tracks_Show_Button);

		}

		Step_End(14, "Now click the show button until status as been compelted(2min)", test, test1);

		Step_Start(15,
				"Back to EDI dashboard if theEDI generadted record colour as been change  to sent (orange colour)",
				test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		waitForElement(driver, EDI_DB_Show_Button);
		click(driver, EDI_DB_Show_Button);

		waitForElement(driver, EDI_DB_Color);
		String Back_round_color = getTextBackgroundColor(driver, EDI_DB_Color);
		System.out.println("Back_round_color :" + Back_round_color);

		String deleted_Column_color = getColorName(Back_round_color);

		if (deleted_Column_color.equals(EXP_Backround_Color)) {

			System.out.println(
					"Matched || Expected Result: Once the status is changed to 'Completed', it should be highlighted in :"
							+ EXP_Backround_Color
							+ " color || Actual Result: Once the status is changed to 'Completed', it is highlighted in :"
							+ deleted_Column_color + " color.");
			Extent_pass_New(driver,
					"Matched || Expected Result: Once the status is changed to 'Completed', it should be highlighted in : "
							+ EXP_Backround_Color
							+ " color || Actual Result: Once the status is changed to 'Completed', it is highlighted in :"
							+ deleted_Column_color + " color.",
					test, test1);

		} else {

			System.out.println(
					"Not Matched || Expected Result: Once the status is changed to 'Completed', it should be highlighted in :"
							+ EXP_Backround_Color
							+ " color || Actual Result: Once the status is changed to 'Completed', it is Not highlighted in :"
							+ deleted_Column_color + " color.");
			Extent_fail(driver,
					"Not Matched || Expected Result: Once the status is changed to 'Completed', it should be highlighted in :"
							+ EXP_Backround_Color
							+ " color || Actual Result: Once the status is changed to 'Completed', it is NOt highlighted in :"
							+ deleted_Column_color + " color.",
					test, test1);
		}

		Step_End(15, "Back to EDI dashboard if theEDI generadted record colour as been change  to sent (orange colour)",
				test, test1);

		Step_Start(16, "And select all the datas ", test, test1);

		if (Select_All_data.equalsIgnoreCase("Yes")) {

			waitForElement(driver, EDI_DB_Select_All_CheckBox);
			click(driver, EDI_DB_Select_All_CheckBox);

		} else {

			for (int i = 0; i < Numbers.size(); i++) {

				String Bl_Numbers_value = String.format(EDI_DB_Grid_Select_All, Numbers.get(i));

				waitForElement(driver, Bl_Numbers_value);
				click(driver, Bl_Numbers_value);

			}

		}

		Step_End(16, "And select all the datas ", test, test1);

		Step_Start(17, "Click the rest button  ", test, test1);

		waitForElement(driver, EDI_DB_Reset_Button);
		click(driver, EDI_DB_Reset_Button);

		waitForPopup(driver, popup_Message, Exp_Reset_Popup);
		String act_reset_popup = getText(driver, popup_Message);
		System.out.println("act_reset_popup :" + act_reset_popup);

		if (act_reset_popup.equals(Exp_Reset_Popup)) {
			System.out.println("Popup Matched ||  Expected : " + Exp_Reset_Popup + " || Actual : " + act_reset_popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + Exp_Reset_Popup + " || Actual : " + act_reset_popup, test, test1);
		} else {
			System.out
					.println("Popup Not Matched ||  Expected : " + Exp_Reset_Popup + " || Actual : " + act_reset_popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + Exp_Reset_Popup + " || Actual : " + act_reset_popup, test,
					test1);
		}

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		if (Select_All_data.equalsIgnoreCase("Yes")) {

			waitForElement(driver, EDI_DB_Select_All_CheckBox);
			click(driver, EDI_DB_Select_All_CheckBox);

		} else {

			for (int i = 0; i < Numbers.size(); i++) {

				String Bl_Numbers_value = String.format(EDI_DB_Grid_Select_All, Numbers.get(i));

				waitForElement(driver, Bl_Numbers_value);
				click(driver, Bl_Numbers_value);

			}

		}

		waitForElement(driver, EDI_DB_Edi_Ref_Field);
		String Exp_Ref_Number = getText(driver, EDI_DB_Edi_Ref_Field);

		if (Exp_Ref_Number.isEmpty()) {
			System.out.println(
					"Matched: Expected: Once clicked on the reset button, the value should be reset successfully. "
							+ Exp_Ref_Number
							+ " || Actual: Once clicked on the reset button, the value should be reset successfully.");
			Extent_pass_New(driver,
					"Matched: Expected: Once clicked on the reset button, the value should be reset successfully. "
							+ Exp_Ref_Number
							+ " || Actual: Once clicked on the reset button, the value should be reset successfully.",
					test, test1);

		} else {
			System.out.println(
					"Matched: Expected: Once clicked on the reset button, the value should be reset successfully. "
							+ Exp_Ref_Number
							+ " || Actual: Once clicked on the reset button, the value should be Not reset .");
			Extent_fail(driver,
					"Matched: Expected: Once clicked on the reset button, the value should be reset successfully. "
							+ Exp_Ref_Number
							+ " || Actual: Once clicked on the reset button, the value should be Not reset .",
					test, test1);

		}

		Step_End(17, "Click the rest button  ", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}