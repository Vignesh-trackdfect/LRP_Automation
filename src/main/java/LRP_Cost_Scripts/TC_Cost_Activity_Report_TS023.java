package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS023 extends Keywords {

	public void Cost_Activity_Report_TS023(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS023";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String GivenContract_Type = Excel_data.get("GivenContract_Type");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal");
		String Arrival_Date = Excel_data.get("Arrival_Date");
		String Condition1 = Excel_data.get("Condition1");
		String GivenMode = Excel_data.get("GivenMode");
		String FilterColumn = Excel_data.get("FilterColumn");
		String ActivityName = Excel_data.get("GivenActivity_Unpredictable");
		String Updated_Popup = Excel_data.get("Updated_Popup");
		String Save_Popup = Excel_data.get("Save_Popup");
		String Simulator_Value = Excel_data.get("Simulator_Value");
		String Agency = Excel_data.get("Agency");
		String Service_Filter_Header = Excel_data.get("Service_Filter_Header");
		String Vessel_Filter_Header = Excel_data.get("Vessel_Filter_Header");
		String Port_Filter_Header = Excel_data.get("Port_Filter_Header");
		String Terminal_Filter_Header = Excel_data.get("Terminal_Filter_Header");
		String ArrivalDate_Filter_Header = Excel_data.get("ArrivalDate_Filter_Header");

		String GivenActivity_Predictable = Excel_data.get("GivenActivity_Predictable");
		String Head_Values_Predictable = Excel_data.get("Head_Values_Predictable");
		String Contract_Number_Values_Predictable = Excel_data.get("Contract_Number_Values_Predictable");
		String Version_Number_Values_Predictable = Excel_data.get("Version_Number_Values_Predictable");
		String Equipement_Type_Predictable = Excel_data.get("Equipement_Type_Predictable");
		String Equipement_Status_Predictable = Excel_data.get("Equipement_Status_Predictable");

		String Head_Values = Excel_data.get("Head_Values_Unpredictable");
		String Contract_Number_Values = Excel_data.get("Contract_Number_Values_Unpredictable");
		String Version_Number_Values = Excel_data.get("Version_Number_Values_Unpredictable");
		String Type_Quantity = Excel_data.get("Type_Quantity");
		String Equipement_Type = Excel_data.get("Equipement_Type_Unpredictable");
		String Equipement_Status = Excel_data.get("Equipement_Status_Unpredictable");

		String Contract_option = String.format(Select_ContractType, GivenContract_Type);
		String Mode_option = String.format(Select_ModeOption, GivenMode);

		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		LRP_Login(driver, username, password);

		if (!Agency.equals("")) {

			SwitchProfile(driver, Agency);

		}

		verifyMainMenu(driver);

		Step_End(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);
		Step_Start(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		Step_Start(3, "Click on the Service search button and select the required service code", test, test1);

		waitForElement(driver, Contract_type);
		click(driver, Contract_type);

		waitForElement(driver, Contract_option);
		click(driver, Contract_option);

		waitForElement(driver, Select_Mode);
		click(driver, Select_Mode);

		waitForElement(driver, Mode_option);
		click(driver, Mode_option);

		waitForElement(driver, Service_Search);
		click(driver, Service_Search);

		twoColumnSearchWindow(driver, Service_Filter_Header, Condition1, Service);

		Step_End(3, "Click on the Service search button and select the required service code", test, test1);

		Step_Start(4, "Click on the Vessel search button and select the required vessel code", test, test1);

		waitForElement(driver, Vessel_Search);
		click(driver, Vessel_Search);

		twoColumnSearchWindow(driver, Vessel_Filter_Header, Condition1, Vessel);

		Step_End(4, "Click on the Vessel search button and select the required vessel code", test, test1);

		Step_Start(5, "Click on the Port search button and select the required port code", test, test1);

		waitForElement(driver, port_Search);
		click(driver, port_Search);

		twoColumnSearchWindow(driver, Port_Filter_Header, Condition1, Port);

		Step_End(5, "Click on the Port search button and select the required port code", test, test1);

		Step_Start(6, "Click on the Terminal search button and select the required terminal code", test, test1);

		waitForElement(driver, CAR_Terminal_Search);
		click(driver, CAR_Terminal_Search);

		twoColumnSearchWindow(driver, Terminal_Filter_Header, Condition1, Terminal);

		Step_End(6, "Click on the Terminal search button and select the required terminal code", test, test1);

		Step_Start(7, "Click on the Arrival date search button and select the required date", test, test1);

		waitForElement(driver, ArrivalDate_Search);
		click(driver, ArrivalDate_Search);

		twoColumnSearchWindow(driver, ArrivalDate_Filter_Header, Condition1, Arrival_Date);

		Step_End(7, "Click on the Arrival date search button and select the required date", test, test1);

		Step_Start(8, "Click on the Show button", test, test1);

		waitForElement(driver, Show_Button_CAR);
		click(driver, Show_Button_CAR);

		waitForDisplay(driver, popup_Message_Yes_Button);

		boolean flag = true;

		if (isdisplayed(driver, popup_Message_Yes_Button)) {

			click(driver, popup_Message_Yes_Button);

			Extent_cal(test, test1, "CAR has been created for this vessel/voyage");

			flag = true;
		} else {

			flag = false;

		}

		Step_End(8, "Click on the Show button", test, test1);

		Step_Start(9, "Click on the Predictable Reporting tab", test, test1);

		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver, Predictable_Reporting_CAR);
		waitForElement(driver, Predictable_Table_CAR);

		Step_End(9, "Click on the Predictable Reporting tab", test, test1);

		Step_Start(10, "Select the required data in the grid by using the check box selection", test, test1);

		waitForElement(driver, Predicatble_More_Grid_CAR);
		click(driver, Predicatble_More_Grid_CAR);

		waitForElement(driver, Predicatble_ConditionFilter_CAR);
		click(driver, Predicatble_ConditionFilter_CAR);

		reArrangeAG_GridColumns(driver, FilterColumn);

		List<String> Table_Activities_Values = splitAndExpand(GivenActivity_Predictable);

		List<String> pred_Activity_Head_Values = splitAndExpand(Head_Values_Predictable);
		List<String> pred_Contract_Numbers = splitAndExpand(Contract_Number_Values_Predictable);
		List<String> pred_Version_Numbers = splitAndExpand(Version_Number_Values_Predictable);
		List<String> pred_EquipmentTypeList = splitAndExpand(Equipement_Type_Predictable);
		List<String> pred_EquipmentStatusList = splitAndExpand(Equipement_Status_Predictable);

		for (int i = 0; i < Table_Activities_Values.size(); i++) {
			String Activity = Table_Activities_Values.get(i);
			String Head = pred_Activity_Head_Values.get(i);
			String Contract_Num = pred_Contract_Numbers.get(i);
			String Version_Num = pred_Version_Numbers.get(i);
			String EqpType = pred_EquipmentTypeList.get(i);
			String EqpStatus = pred_EquipmentStatusList.get(i);

			waitForElement(driver, Activity_Name_CAR);
			Newclear(driver, Activity_Name_CAR);
			sendKeys(driver, Activity_Name_CAR, Activity);

			if (!Head.trim().equals("")) {
				waitForElement(driver, Head_Filter_input_CAR);
				Newclear(driver, Head_Filter_input_CAR);
				sendKeys(driver, Head_Filter_input_CAR, Head);
			}

			if (!Contract_Num.trim().equals("")) {
				waitForElement(driver, ContractNo_Filter_Input_CAR);
				Newclear(driver, ContractNo_Filter_Input_CAR);
				sendKeys(driver, ContractNo_Filter_Input_CAR, Contract_Num);
			}

			if (!Version_Num.trim().equals("")) {
				waitForElement(driver, VersionNo_Filter_Input_CAR);
				Newclear(driver, VersionNo_Filter_Input_CAR);
				sendKeys(driver, VersionNo_Filter_Input_CAR, Version_Num);
			}

			if (!EqpType.trim().equals("")) {
				waitForElement(driver, EqpType_Filter_input_CAR);
				Newclear(driver, EqpType_Filter_input_CAR);
				sendKeys(driver, EqpType_Filter_input_CAR, EqpType);
			}

			if (!EqpStatus.trim().equals("")) {
				waitForElement(driver, EqpStatus_Filter_input_CAR);
				Newclear(driver, EqpStatus_Filter_input_CAR);
				sendKeys(driver, EqpStatus_Filter_input_CAR, EqpStatus);
			}

			waitForDisplay(driver, SelectCheckbox_CAR);
			jsClick(driver, SelectCheckbox_CAR);

		}

		Step_End(10, "Select the required data in the grid by using the check box selection", test, test1);

		Step_Start(11, "Click on the Unpredictable Reporting tab", test, test1);

		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver, UnPredictable_Tab_CAR);

		Step_End(11, "Click on the Unpredictable Reporting tab", test, test1);

		Step_Start(12, "Select the required data in the grid by using the check box selection", test, test1);

		Step_End(12, "Select the required data in the grid by using the check box selection", test, test1);

		Step_Start(13,
				"After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and check whether the activity has any variables in formula colomn",
				test, test1);

		Step_Start(15,
				".Incase,if the selected activity contains any formula along with the To be reported(Formula) checkbox selection false means,we have to input the required variable values in the value field and click the simulator option. An information message will be displayed as \"The result for Sample Values along with simulator value\" and click ok option",
				test, test1);

		if (IsElementEnabled(driver, Edit_Button_toolBar)) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
		}

		reArrangeAG_GridColumns(driver, FilterColumn);

		waitForElement(driver, More_Grid_UnPredictable_CAR);
		click(driver, More_Grid_UnPredictable_CAR);

		waitForElement(driver, Condition_UnPredictable_CAR);
		click(driver, Condition_UnPredictable_CAR);

		List<String> Givenactivities = splitAndExpand(ActivityName);

		List<String> Activity_Head_Values = splitAndExpand(Head_Values);
		List<String> Contract_Numbers = splitAndExpand(Contract_Number_Values);
		List<String> Version_Numbers = splitAndExpand(Version_Number_Values);
		List<String> Quantity_Lists = splitAndExpand(Type_Quantity);
		List<String> EquipmentTypeList = splitAndExpand(Equipement_Type);
		List<String> EquipmentStatusList = splitAndExpand(Equipement_Status);

		for (int i = 0; i < Givenactivities.size(); i++) {

			String Activity = Givenactivities.get(i);//

			String Head = Activity_Head_Values.get(i);
			String Contract_Num = Contract_Numbers.get(i);
			String Version_Num = Version_Numbers.get(i);
			String Quantity = Quantity_Lists.get(i);

			String EqpType = EquipmentTypeList.get(i);
			String EqpStatus = EquipmentStatusList.get(i);

			waitForElement(driver, ActivityName_Filter);
			Newclear(driver, ActivityName_Filter);
			sendKeys(driver, ActivityName_Filter, Activity);

			if (!Head.trim().equals("")) {
				waitForElement(driver, Head_Filter);
				Newclear(driver, Head_Filter);
				sendKeys(driver, Head_Filter, Head);
			}

			if (!Contract_Num.trim().equals("")) {
				waitForElement(driver, ContractNo_Filter_Input_CAR);
				Newclear(driver, ContractNo_Filter_Input_CAR);
				sendKeys(driver, ContractNo_Filter_Input_CAR, Contract_Num);
			}

			if (!Version_Num.trim().equals("")) {
				waitForElement(driver, VersionNo_Filter_Input_CAR);
				Newclear(driver, VersionNo_Filter_Input_CAR);
				sendKeys(driver, VersionNo_Filter_Input_CAR, Version_Num);
			}

			if (!EqpType.trim().equals("")) {
				waitForElement(driver, EqpType_Filter_input_CAR);
				Newclear(driver, EqpType_Filter_input_CAR);
				sendKeys(driver, EqpType_Filter_input_CAR, EqpType);
			}

			if (!EqpStatus.trim().equals("")) {
				waitForElement(driver, EqpStatus_Filter_input_CAR);
				Newclear(driver, EqpStatus_Filter_input_CAR);
				sendKeys(driver, EqpStatus_Filter_input_CAR, EqpStatus);
			}

			waitForElement(driver, AG_Grid_First_Row);
			click(driver, AG_Grid_First_Row);

			waitForElement(driver, Quantity_Column_CAR);
			doubleClick(driver, Quantity_Column_CAR);
			waitForElement(driver, quantity_Input_CAR);
			Newclear(driver, quantity_Input_CAR);

			sendKeys(driver, quantity_Input_CAR, Quantity);
			waitForElement(driver, AG_Grid_First_Row);
			click(driver, AG_Grid_First_Row);

			Step_End(13,
					"After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and check whether the activity has any variables in formula colomn",
					test, test1);

			String FindRow = String.format(Given_Row, Activity);

			waitForElement(driver, FindRow);
			String rowid = getAttribute(driver, FindRow, "row-id");

			String Checkbox = String.format(Select_Checkbox_CAR, rowid);

			checkBox(driver, Checkbox, "Yes");

			String Formual_value = String.format(Formula_field, rowid);

			waitForElement(driver, Formual_value);

			String Formual_Text = getText(driver, Formual_value);

			if (!Formual_Text.isEmpty()) {

				scrollBottom(driver);

				String formulavalue = evaluateExpression(Formual_Text, Simulator_Value);

				String expectedvalue = String.format("%.2f", Double.parseDouble(formulavalue));

				waitForElement(driver, Variable_Input);
				jsClick(driver, Variable_Input);

				Newclear_Type(driver);
				typeText(Simulator_Value);

				click(driver, Formual_value);

				waitForElement(driver, Simulator);
				click(driver, Simulator);

				Step_End(15,
						".Incase,if the selected activity contains any formula along with the To be reported(Formula) checkbox selection false means,we have to input the required variable values in the value field and click the simulator option. An information message will be displayed as \"The result for Sample Values along with simulator value\" and click ok option",
						test, test1);

				Step_Start(16, "Ensure that Total cost and charge rate gets updated for that activity", test, test1);

				waitForPopup(driver, popup_Message, expectedvalue);
				String SimulatorPopupmessage = getText(driver, popup_Message);

				if (SimulatorPopupmessage.contains(expectedvalue)) {

					System.out.println("Simulator option is working fine for the formula || Expected value : "
							+ expectedvalue + " Actual value was : " + SimulatorPopupmessage);
					Extent_pass_New(driver, "Simulator option is working fine for the formula || Expected value : "
							+ expectedvalue + " Actual value was : " + SimulatorPopupmessage, test, test1);

				} else {

					System.out.println("Simulator option is not working fine for the formula || Expected value : "
							+ expectedvalue + " Actual value was : " + SimulatorPopupmessage);
					Extent_fail(driver, "Simulator option is not working fine for the formula || Expected value : "
							+ expectedvalue + " Actual value was : " + SimulatorPopupmessage, test, test1);

				}

				Step_End(16, "Ensure that Total cost and charge rate gets updated for that activity", test, test1);

				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);

			}

		}

		scrollTop(driver);

		if (flag == true) {

			Step_Start(14,
					".Click on the tool bar save button and check whether the system shows the information message as Container Activity Report Saved Click on the ok option",
					test, test1);

			Step_Start(17,
					".Click on the tool bar save button and check whether the system shows the information message as Container Activity Report Saved Click on the ok option",
					test, test1);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Updated_Popup);
			String SavePopupmessage = getText(driver, popup_Message);

			if (SavePopupmessage.equals(Updated_Popup)) {

				System.out.println(
						"Expected popup was : " + Updated_Popup + " || Actual popup was : " + SavePopupmessage);
				Extent_pass_New(driver,
						"Expected popup was : " + Updated_Popup + " || Actual popup was : " + SavePopupmessage, test,
						test1);
			} else {

				System.out.println(
						"Expected popup was : " + Updated_Popup + " || Actual popup was : " + SavePopupmessage);
				Extent_fail(driver,
						"Expected popup was : " + Updated_Popup + " || Actual popup was : " + SavePopupmessage, test,
						test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(14,
					".Click on the tool bar save button and check whether the system shows the information message as Container Activity Report Saved Click on the ok option",
					test, test1);

			Step_End(17,
					".Click on the tool bar save button and check whether the system shows the information message as Container Activity Report Saved Click on the ok option",
					test, test1);

		} else {

			Step_Start(14,
					".Click on the tool bar save button and check whether the system shows the information message as Container Activity Report Saved Click on the ok option",
					test, test1);

			Step_Start(17,
					".Click on the tool bar save button and check whether the system shows the information message as Container Activity Report Saved Click on the ok option",
					test, test1);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Save_Popup);
			String SavePopupmessage = getText(driver, popup_Message);

			if (SavePopupmessage.equals(Save_Popup)) {

				System.out.println("Expected popup was : " + Save_Popup + " || Actual popup was : " + SavePopupmessage);
				Extent_pass_New(driver,
						"Expected popup was : " + Save_Popup + " || Actual popup was : " + SavePopupmessage, test,
						test1);
			} else {

				System.out.println("Expected popup was : " + Save_Popup + " || Actual popup was : " + SavePopupmessage);
				Extent_fail(driver, "Expected popup was : " + Save_Popup + " || Actual popup was : " + SavePopupmessage,
						test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(14,
					".Click on the tool bar save button and check whether the system shows the information message as Container Activity Report Saved Click on the ok option",
					test, test1);

			Step_End(17,
					".Click on the tool bar save button and check whether the system shows the information message as Container Activity Report Saved Click on the ok option",
					test, test1);

		}

		Extent_completed(tc_Name, test, test1);

	}

}
