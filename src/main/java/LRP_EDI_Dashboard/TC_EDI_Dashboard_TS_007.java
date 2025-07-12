package LRP_EDI_Dashboard;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Dashboard_TS_007 extends Keywords {
	public void EDI_Dashboard_TS_007(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_EDI_Dashboard_TS_007";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String EDI_Dashboard_Module = Excel_data.get("EDI_Dashboard_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String Column_condition = Excel_data.get("Column_condition");
		String Agency_Code_Input = Excel_data.get("Agency_Code_Input");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID_Value = Excel_data.get("EDI_ID_Value");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String POL = Excel_data.get("POL");
		String BL_Numbers = Excel_data.get("BL_Numbers");
		String Exp_Generate_Edi_Popup = Excel_data.get("Exp_Generate_Edi_Popup");
		String Show_button = Excel_data.get("Show_button");
		String Dynamic_Data_Col = Excel_data.get("Dynamic_Data_Col");
		String Dynamic_Data_Input = Excel_data.get("Dynamic_Data_Input");
		String Select_All_data = Excel_data.get("Select_All_data");
		String EDI_Tracker_Yes = Excel_data.get("EDI_Tracker_Yes");
		String EXP_Backround_Color = Excel_data.get("EXP_Backround_Color");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);
		moduleNavigate(driver, EDI_Dashboard_Module);

		Step_Start(1, "Enter the agency code (AEESAD)", test, test1);

		waitForElement(driver, EDI_DB_Agency_Button);
		click(driver, EDI_DB_Agency_Button);

		twoColumnSearchWindow(driver, AgencyCode_Header, Column_condition, Agency_Code_Input);

		Step_End(1, "Enter the agency code (AEESAD)", test, test1);

		Step_Start(2, "Enter the EDI details (EDI734)", test, test1);

		waitForElement(driver, EDI_DB_EDI_Buttton);
		click(driver, EDI_DB_EDI_Buttton);

		twoColumnMultipleSearchWindow(driver, EDI_ID_Header, Column_condition, EDI_ID_Value);

		Step_End(2, "Enter the EDI details (EDI734))", test, test1);

		Step_Start(3, "Click the Dynamic data button ", test, test1);

		waitForElement(driver, EDI_DB_Dynamic_Data_Button);
		click(driver, EDI_DB_Dynamic_Data_Button);

		Step_End(3, "Click the Dynamic data button ", test, test1);

		Step_Start(4, "Enter all the datas and Click apply button ", test, test1);

		List<String> Element_Header_name = splitAndExpand(Dynamic_Data_Col, ",");
		List<String> Element_Input_value = splitAndExpand(Dynamic_Data_Input, ",");

		for (int v = 0; v < Element_Header_name.size(); v++) {

			String inputColumn = String.format(EDI_Dynamic_Data_Table, Element_Header_name.get(v));
			waitForElement(driver, inputColumn);
			doubleClick(driver, inputColumn);

			String ValueInput = String.format(EDI_Dynamic_Data_Input_Table, Element_Header_name.get(v));
			waitForElement(driver, ValueInput);
			sendKeys(driver, ValueInput, Element_Input_value.get(v));
			enter(driver);

		}

		waitForElement(driver, EDI_Dynamic_Apply_Button);
		click(driver, EDI_Dynamic_Apply_Button);

		Step_End(4, "Enter all the datas and Click apply button ", test, test1);

		Step_Start(5, "Select Service code field (0610)", test, test1);
		Step_Start(6, "Select any data from the favorite  search", test, test1);

		waitForElement(driver, EDI_Service_Code_Input);
		clear(driver, EDI_Service_Code_Input);
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

		Step_End(5, "Select Service code field (0610)", test, test1);
		Step_End(6, "Select any data from the favorite  search", test, test1);

		Step_Start(7, "Click the show button", test, test1);

		waitForElement(driver, EDI_DB_Show_Button);
		click(driver, EDI_DB_Show_Button);

		Step_End(7, "Click the show button", test, test1);

		Step_Start(8, "And select all the datas ", test, test1);

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

		Step_End(8, "And select all the datas ", test, test1);

		Step_Start(9, "Click the Generate EDI button", test, test1);

		waitForElement(driver, EDI_DB_Generate_EDI_Button);
		click(driver, EDI_DB_Generate_EDI_Button);

		Step_End(9, "Click the Generate EDI button", test, test1);

		Step_Start(10,
				"Dynamic input details are not updated for all fields. Do you want to continue? if yes to continue else No means stop",
				test, test1);

		waitForPopup(driver, popup_Message, Exp_Generate_Edi_Popup);
		String Act_Popup = getText(driver, popup_Message);
		if (Act_Popup.contains(Exp_Generate_Edi_Popup)) {
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

		waitForElement(driver, popup_Message_Yes_Button);

		if (EDI_Tracker_Yes.equalsIgnoreCase("Yes")) {
			click(driver, popup_Message_Yes_Button);

			waitForElement(driver, EDI_Tracks_Show_Button);
			click(driver, EDI_Tracks_Show_Button);

			int ShowLimit = Integer.parseInt(Show_button);

			for (int k = 0; k < ShowLimit; k++) {

				waitForElement(driver, EDI_Track_Filter_Option);
				click(driver, EDI_Track_Filter_Option);

				if (!Select_All_data.equalsIgnoreCase("Yes")) {
					waitForElement(driver, EDI_DB_Input_Details);
					Newclear(driver, EDI_DB_Input_Details);
					sendKeys(driver, EDI_DB_Input_Details, Numbers.get(0));
				}

				waitForElement(driver, EDI_Track_Input_Status_Field);
				String Act_Val = getText(driver, EDI_Track_Input_Status_Field);
				if (Act_Val.equalsIgnoreCase("Completed")) {
					break;
				}

				waitForElement(driver, EDI_Tracks_Show_Button);
				click(driver, EDI_Tracks_Show_Button);

			}

			if (!Select_All_data.equalsIgnoreCase("Yes")) {
				waitForElement(driver, EDI_Track_Filter_Option);
				click(driver, EDI_Track_Filter_Option);

				for (int k = 0; k < Numbers.size(); k++) {

					waitForElement(driver, EDI_DB_Input_Details);
					Newclear(driver, EDI_DB_Input_Details);
					sendKeys(driver, EDI_DB_Input_Details, Numbers.get(k));

					waitForElement(driver, EDI_Track_Input_Status_Field);
					String Act_Val = getText(driver, EDI_Track_Input_Status_Field);
					if (Act_Val.equalsIgnoreCase("Completed")) {

						System.out.println(
								"Matched: Expected: 'Status changed in completed' should be displayed || Actual: 'Status changed in completed' is displayed");
						Extent_pass_New(driver,
								"Matched: Expected: 'Status changed in completed' should be displayed || Actual: 'Status changed in completed' is displayed",
								test, test1);

					} else {
						System.out.println("Not Matched: Expected: 'Status changed in :" + Act_Val
								+ " should be displayed || Actual: 'Status changed in : " + Act_Val + " is displayed");
						Extent_pass_New(driver, "Not Matched: Expected: 'Status changed in :" + Act_Val
								+ " should be displayed || Actual: 'Status changed in :" + Act_Val + " is displayed",
								test, test1);

					}
				}

			} else {
				waitForElement(driver, EDI_Track_Input_Status_Field);
				String Act_Val = getText(driver, EDI_Track_Input_Status_Field);
				if (Act_Val.equalsIgnoreCase("Completed")) {

					System.out.println(
							"Matched: Expected: 'Status changed in completed' should be displayed || Actual: 'Status changed in completed' is displayed");
					Extent_pass_New(driver,
							"Matched: Expected: 'Status changed in completed' should be displayed || Actual: 'Status changed in completed' is displayed",
							test, test1);

				} else {

					System.out.println("Not Matched: Expected: 'Status changed in :" + Act_Val
							+ " should be displayed || Actual: 'Status changed in : " + Act_Val + " is displayed");
					Extent_pass_New(driver, "Not Matched: Expected: 'Status changed in :" + Act_Val
							+ " should be displayed || Actual: 'Status changed in :" + Act_Val + " is displayed", test,
							test1);

				}
			}

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			waitForElement(driver, EDI_DB_Show_Button);
			click(driver, EDI_DB_Show_Button);

			waitForElement(driver, EDI_DB_Edi_Ref_Field);
			String Exp_Ref_Number = getText(driver, EDI_DB_Edi_Ref_Field);

			if (!Exp_Ref_Number.isEmpty()) {
				System.out.println(
						"Matched: Expected: Once EDI is tracked, the status should change to completed and an EDI reference should be : "
								+ Exp_Ref_Number
								+ "generated || Actual: Once EDI is tracked, the status changes to completed and an EDI reference is generated.");
				Extent_pass_New(driver,
						"Matched: Expected: Once EDI is tracked, the status should change to completed and an EDI reference should be : "
								+ Exp_Ref_Number
								+ " generated || Actual: Once EDI is tracked, the status changes to completed and an EDI reference is generated.",
						test, test1);
			} else {
				System.out.println(
						"Not Matched: Expected: Once EDI is tracked, the status should change to completed and an EDI reference should be : "
								+ Exp_Ref_Number
								+ " generated || Actual: Once EDI is tracked, the status changes to completed and an EDI reference is Not generated.");
				Extent_fail(driver,
						"NOt Matched: Expected: Once EDI is tracked, the status should change to completed and an EDI reference should be : "
								+ Exp_Ref_Number
								+ " generated || Actual: Once EDI is tracked, the status changes to completed and an EDI reference is Not generated.",
						test, test1);
			}

			waitForElement(driver, EDI_DB_Date_Cr);
			String Exp_Date_CR = getText(driver, EDI_DB_Date_Cr);
			waitForDisplay(driver, EDI_DB_Date_Cr);
			if (isdisplayed(driver, EDI_DB_Date_Cr)) {
				if (!Exp_Date_CR.isEmpty()) {
					System.out.println(
							"Matched: Expected: Once EDI is tracked, the status should change to completed and an 'Date CR' should be : "
									+ Exp_Date_CR
									+ "generated || Actual: Once EDI is tracked, the status changes to completed and an'Date CR' is generated.");
					Extent_pass_New(driver,
							"Matched: Expected: Once EDI is tracked, the status should change to completed and an 'Date CR' should be : "
									+ Exp_Date_CR
									+ " generated || Actual: Once EDI is tracked, the status changes to completed and an 'Date CR' is generated.",
							test, test1);
				} else {
					System.out.println(
							"Not Matched: Expected: Once EDI is tracked, the status should change to completed and an 'Date CR' should be : "
									+ Exp_Date_CR
									+ " generated || Actual: Once EDI is tracked, the status changes to completed and an 'Date CR' is Not generated.");
					Extent_fail(driver,
							"NOt Matched: Expected: Once EDI is tracked, the status should change to completed and an 'Date CR' should be : "
									+ Exp_Date_CR
									+ " generated || Actual: Once EDI is tracked, the status changes to completed and an 'Date CR' is Not generated.",
							test, test1);
				}

			}

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

		} else {

			click(driver, popup_Message_No_Button);

			waitForDisplay(driver, EDI_DB_Agency_Button);
			if (isdisplayed(driver, EDI_DB_Agency_Button)) {
				System.out.println(
						"Matched: Expected: 'Do you want to navigate to EDI Tracker?' and select the value 'NO'. It should not navigate to the EDI Tracker module || Actual: 'Do you want to navigate to EDI Tracker?' and select the value 'NO'. It should not navigate to the EDI Tracker module");
				Extent_pass_New(driver,
						"Matched: Expected: 'Do you want to navigate to EDI Tracker?' and select the value 'NO'. It should not navigate to the EDI Tracker module || Actual: 'Do you want to navigate to EDI Tracker?' and select the value 'NO'. It should not navigate to the EDI Tracker module",
						test, test1);

			} else {
				System.out.println(
						"NOt Matched: Expected: 'Do you want to navigate to EDI Tracker?' and select the value 'NO'. It should not navigate to the EDI Tracker module || Actual: 'Do you want to navigate to EDI Tracker?' and select the value 'NO'. It should  navigate to the EDI Tracker module");
				Extent_fail(driver,
						"Not Matched: Expected: 'Do you want to navigate to EDI Tracker?' and select the value 'NO'. It should not navigate to the EDI Tracker module || Actual: 'Do you want to navigate to EDI Tracker?' and select the value 'NO'. It should  navigate to the EDI Tracker module",
						test, test1);

			}

		}

		Extent_completed(testcase_Name, test, test1);

	}
}