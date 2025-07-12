package LRP_Vendor_Contract_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Contracts_SC013 extends Keywords {

	public void Vendor_Contracts_SC013(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Vendor_Contracts_SC013";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String agencyCode = Excel_data.get("AgencyCode");
		String Global_Search_Option = Excel_data.get("Global_Search_Option");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Contract_Number = Excel_data.get("Contract_Number");
		String ActivityCode_ForDelete = Excel_data.get("ActivityCode_ForDelete");
		String Given_From_Date = Excel_data.get("From_Date");
		String To_Date = Excel_data.get("To_Date");
		String VC_ActivityCode_Header = Excel_data.get("VC_ActivityCode_Header");
		String Twocolumnsearch_Condition = Excel_data.get("Twocolumnsearch_Condition");
		String Select_ChargeType = Excel_data.get("Select_ChargeType");
		String Select_Eqp_Type = Excel_data.get("Select_Eqp_Type");
		String Select_Eqp_Status = Excel_data.get("Select_Eqp_Status");
		String Select_Eqp_Currency = Excel_data.get("Select_Eqp_Currency");
		String Select_Disbursement = Excel_data.get("Select_Disbursement");
		String Formula_Build_Option = Excel_data.get("Formula_Build_Option");
		String Formula_Value = Excel_data.get("Formula_Value");
		String Formula_Variable = Excel_data.get("Formula_Variable");
		String Formula_Variable_Header = Excel_data.get("Formula_Variable_Header");
		String Select_Formula_Condition = Excel_data.get("Select_Formula_Condition");
		String Num_Value_Formula = Excel_data.get("Num_Value_Formula");
		String Select_Slab_Option = Excel_data.get("Select_Slab_Option");
		String Cumulative_Select = Excel_data.get("Cumulative_Select");
		String From_input_Slab = Excel_data.get("From_input_Slab");
		String To_Input_Slab = Excel_data.get("To_Input_Slab");
		String Consonant_Input_Slab = Excel_data.get("Consonant_Input_Slab");
		String Renegotitate_Popup = Excel_data.get("Renegotitate_Popup");
		String Update_Confirmation_Popup = Excel_data.get("Update_Confirmation_Popup");
		String Updated_popup = Excel_data.get("Updated_popup");
		String NegotiatedBY = Excel_data.get("NegotiatedBY");
		String Negotiated_From_Date = Excel_data.get("Negotiated_From_Date");
		String Negotiated_To_Date = Excel_data.get("Negotiated_To_Date");
		String Saved_popup = Excel_data.get("Saved_popup");
		String Amount_Main_Activity = Excel_data.get("Amount_Main_Activity");
		String Amount_Subactivity_List = Excel_data.get("Amount_Subactivity_List");
		String Amount_all_Activity = Excel_data.get("Amount_all_Activity");

		String Formula_Main_Activity = Excel_data.get("Formula_Main_Activity");
		String Formula_Subactivity = Excel_data.get("Formula_Subactivity");
		String Filter_Headers_AG_Grid = Excel_data.get("Filter_Headers_AG_Grid");
		
		String Select_ParentActibity = Excel_data.get("Select_ParentActibity");
		String Select_Subactivity_List = Excel_data.get("Select_Subactivity_List");
		String Select_Main_Activity = Excel_data.get("Select_Main_Activity");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		Step_Start(1,
				"Enter the screen name as 'Vendor contract' in module search field and select the saved contract using global search option in the toolbar",
				test, test1);

		SwitchProfile(driver, agencyCode);

		moduleNavigate(driver, moduleName);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Global_Search_Condition, Global_Search_Option, Contract_Number, "", "", "", "");

		waitForElement(driver, contract_No_VC);

		String contractNo = getAttribute(driver, contract_No_VC, "value");

		if (contractNo.equals(Contract_Number)) {

			System.out.println("Expected contract no was retrieved || Expected no : " + Contract_Number
					+ " || Actual no : " + contractNo);
			Extent_pass_New(driver, "Expected contract no was retrieved || Expected no : " + Contract_Number
					+ " || Actual no : " + contractNo, test, test1);
		} else {

			System.out.println("Expected contract no was not retrieved || Expected no : " + Contract_Number
					+ " || Actual no : " + contractNo);
			Extent_fail(driver, "Expected contract no was not retrieved || Expected no : " + Contract_Number
					+ " || Actual no : " + contractNo, test, test1);

		}

		Step_End(1,
				"Enter the screen name as 'Vendor contract' in module search field and select the saved contract using global search option in the toolbar",
				test, test1);

		Step_Start(2, "Click on the tool bar 'Edit' button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(2, "Click on the tool bar 'Edit' button", test, test1);

		List<String> activitycodes = splitAndExpand(ActivityCode_ForDelete);

		for (String activitycode : activitycodes) {

			reArrangeAG_GridColumnsNew(driver, AG_Gridcolumns_new, Filter_Headers_AG_Grid);

			waitForElement(driver, Vendor_Filter);
			click(driver, Vendor_Filter);

			waitForElement(driver, VC_activity_Code_TF);
			clear(driver, VC_activity_Code_TF);
			sendKeys(driver, VC_activity_Code_TF, activitycode);

			waitForElement(driver, AG_Grid_First_Row);
			click(driver, AG_Grid_First_Row);
			RightClick(driver, AG_Grid_First_Row);

			waitForElement(driver, Remove_Selected_Items_VC);
			click(driver, Remove_Selected_Items_VC);

			if (isdisplayed(driver, popup_Message_Yes_Button)) {

				click(driver, popup_Message_Yes_Button);
			}

			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {

				click(driver, popup_Message_Yes_Button);
			}

		}

		Step_Start(4, "Select the required valid from and valid to date and also currency", test, test1);

		waitForElement(driver, valid_from_date_Vc);
		selectDatePicker(driver, valid_from_date_Vc, Given_From_Date);

		waitForElement(driver, valid_To_date_Vc);
		selectDatePicker(driver, valid_To_date_Vc, To_Date);

		Step_End(4, "Select the required valid from and valid to date and also currency", test, test1);

		Step_Start(5, "Select the main activity to add the required subactivity", test, test1);

		List<String> Mainactivities = splitAndExpand(Select_Main_Activity, ",");

		List<String> Parentactivities = splitAndExpand(Select_ParentActibity, "/");

		int i = 0;

		for (String mainActivity : Mainactivities) {

			waitForElement(driver, Vendor_Filter);
			click(driver, Vendor_Filter);

			waitForElement(driver, VC_Activityfilter);
			sendKeys(driver, VC_Activityfilter, mainActivity);

			waitForElement(driver, vc_rows);
			formatLocatorClick(driver, Select_Activity_VC, mainActivity);

			waitForElement(driver, edit_input_field_Vc);
			click(driver, edit_input_field_Vc);
			Step_End(10, "Select the main activity which is present and Click the 'Enter edit input fields' option",
					test, test1);

			Step_Start(11, "Select the required equipment type and equipment status. ", test, test1);
			waitForElement(driver, equip_type_dd_label_Vc);
			jsClick(driver, equip_type_dd_label_Vc);
			formatLocatorClick(driver, equip_type_options_Vc, Select_Eqp_Type);

			if (isdisplayed(driver, Popup_Message)) {

				elementnotvisible1(driver, Popup_Message);
			}

			waitForElement(driver, eqp_sts_label_vc);
			jsClick(driver, eqp_sts_label_vc);
			String newloc = String.format(equip_sts_Vc_option, Select_Eqp_Status);
			VerticalScroll_Visible(driver, newloc, verticalscroll);
			formatLocatorClick(driver, equip_sts_Vc_option, Select_Eqp_Status);

			if (isdisplayed(driver, Popup_Message)) {

				elementnotvisible1(driver, Popup_Message);
			}
			
			Step_End(11, "Select the required equipment type and equipment status. ", test, test1);

			Step_Start(12, "Select the required currency. ", test, test1);

			waitForElement(driver, currency_dd_Vc);
			jsClick(driver, currency_dd_Vc);
			formatLocatorClick(driver, currency_dd_options, Select_Eqp_Currency);

			if (isdisplayed(driver, Popup_Message)) {

				elementnotvisible1(driver, Popup_Message);
			}
			
			Step_End(12, "Select the required currency. ", test, test1);

			Step_Start(13, " Select the Send to Disbursement and click 'Yes'.       ", test, test1);

			waitForElement(driver, Disbursement_Input_VC);
			click(driver, Disbursement_Input_VC);
			formatLocatorClick(driver, Select_Disbursement_option_VC, Select_Disbursement);

			if (isdisplayed(driver, Popup_Message)) {

				elementnotvisible1(driver, Popup_Message);
			}
			
			Step_End(13, " Select the Send to Disbursement and click 'Yes'.       ", test, test1);

			Step_Start(14, "Right click and select 'Add item' option. ", test, test1);

			formatRightClick(driver, Select_Activity_VC, mainActivity);

			waitForElement(driver, Add_item_PAB);
			click(driver, Add_item_PAB);
			Step_End(14, "Right click and select 'Add item' option. ", test, test1);

			Step_Start(15, "Click on the required activities and click 'select' option.", test, test1);

			List<String> Activities_List = splitAndExpand(Parentactivities.get(i), ",");
			waitForElement(driver, Activity_Select_Window);

			for (String Activity : Activities_List) {

				twoColumnSearchWindow1(driver, VC_ActivityCode_Header, Twocolumnsearch_Condition, Activity);

			}

			waitForElement(driver, select_Button);
			click(driver, select_Button);

			i++;
		}

		List<String> Parentactivities2 = splitAndExpand(Select_ParentActibity, "/");
		List<String> Subactivities = splitAndExpand(Select_Subactivity_List, "/");

		int j = 0;
		int k = 0;

		reArrangeAG_GridColumnsNew(driver, AG_Gridcolumns_new, Filter_Headers_AG_Grid);

		for (String Mainactivity : Mainactivities) {

			if (j >= Parentactivities2.size() || k >= Subactivities.size()) {
				break; // Prevent IndexOutOfBoundsException
			}

			List<String> selectedparents = splitAndExpand(Parentactivities2.get(j), ",");

			for (String parentactivity : selectedparents) {

				String subact = Subactivities.get(k);
				System.out.println("subact : " + subact);

				if (subact != null && !subact.isBlank()) {

					waitForElement(driver, Vendor_Filter);
					click(driver, Vendor_Filter);

					waitForElement(driver, VC_MainActivityfilter);
					sendKeys(driver, VC_MainActivityfilter, Mainactivity);

					waitForElement(driver, activity_Code_TF);
					sendKeys(driver, activity_Code_TF, parentactivity);

					waitForElement(driver, AG_Grid_First_Row);
					formatLocatorClick(driver, AG_Grid_First_Row, parentactivity);

					formatRightClick(driver, AG_Grid_First_Row, parentactivity);

					waitForElement(driver, Add_item_PAB);
					click(driver, Add_item_PAB);

					List<String> SubActivities_List = splitAndExpand(subact, ",");
					waitForElement(driver, Activity_Select_Window);

					for (String SubActivity : SubActivities_List) {
						twoColumnSearchWindow1(driver, VC_ActivityCode_Header, Twocolumnsearch_Condition, SubActivity);
					}

					waitForElement(driver, select_Button);
					click(driver, select_Button);

				}

				k++;
			}

			j++;

		}

		Step_End(5, "Select the main activity to add the required subactivity", test, test1);

		Step_Start(6, " Give the required charge type by clicking edit input details", test, test1);
		
		Step_Start(3, "Select any one of the activities to change the amount for LumpSum charge type", test, test1);
		
		List<String> Amount_Mainactivities = splitAndExpand(Amount_Main_Activity, ",");

		List<String> Amount_Subactivities = splitAndExpand(Amount_Subactivity_List, "/");

		List<String> Amount_of_Activities = splitAndExpand(Amount_all_Activity, "/");

		int m = 0;

		reArrangeAG_GridColumnsNew(driver, AG_Gridcolumns_new, Filter_Headers_AG_Grid);

		waitForElement(driver, Vendor_Filter);
		click(driver, Vendor_Filter);

		for (String Mainactivity : Amount_Mainactivities) {

			if (m >= Amount_Subactivities.size() || m >= Amount_of_Activities.size()) {
				break; // Prevent IndexOutOfBoundsException
			}

			List<String> selectedact = splitAndExpand(Amount_Subactivities.get(m), ",");
			List<String> amount = splitAndExpand(Amount_of_Activities.get(m), ",");

			waitForElement(driver, VC_MainActivityfilter);
			clear(driver, VC_MainActivityfilter);
			sendKeys(driver, VC_MainActivityfilter, Mainactivity);

			int n = 0;

			for (String activityname : selectedact) {

				if (activityname != null && !activityname.isBlank()) {

					waitForElement(driver, activity_Code_TF);
					clear(driver, activity_Code_TF);
					sendKeys(driver, activity_Code_TF, activityname);

					waitForDisplay(driver, Activity_Amount_Column_VC);
					formatLocatorDoubleClick(driver, Activity_Amount_Column_VC, activityname);
					formatLocatorSendKeys(driver, Activity_Amount_input_VC, activityname, amount.get(n));

					enter(driver);
				}

				n++;

			}

			m++;

		}

		Step_End(3, "Select any one of the activities to change the amount for LumpSum charge type", test, test1);
		
		List<String> Formula_Mainactivities = splitAndExpand(Formula_Main_Activity, ",");

		List<String> Formula_Subactivities = splitAndExpand(Formula_Subactivity, "/");

		int p = 0;

		for (String Mainactivity : Formula_Mainactivities) {

			if (p >= Formula_Subactivities.size()) {
				break;
			}

			List<String> selectedact = splitAndExpand(Formula_Subactivities.get(p), ",");

			waitForElement(driver, VC_MainActivityfilter);
			clear(driver, VC_MainActivityfilter);
			sendKeys(driver, VC_MainActivityfilter, Mainactivity);

			for (String activityname : selectedact) {

				if (activityname != null && !activityname.isBlank()) {

					waitForElement(driver, activity_Code_TF);
					clear(driver, activity_Code_TF);
					sendKeys(driver, activity_Code_TF, activityname);

					waitForElement(driver, Vendor_Filter);
					click(driver, Vendor_Filter);

					waitForElement(driver, activity_Code_TF);
					clear(driver, activity_Code_TF);
					sendKeys(driver, activity_Code_TF, activityname);

					formatLocatorClick(driver, Activity_Amount_Column_VC, activityname);

					if (!isdisplayed(driver, ChargeType_Input_VC)) {

						waitForElement(driver, edit_input_field_Vc);
						click(driver, edit_input_field_Vc);

					}

					waitForElement(driver, ChargeType_Input_VC);
					click(driver, ChargeType_Input_VC);
					formatLocatorClick(driver, Select_ChargeTypeOption, Select_ChargeType);

					Step_End(17,
							"Select the required activity and change the charge type as 'Sub to Formula' for the activity.",
							test, test1);

					Step_Start(18, "Select that activity and click on Formula builder option. ", test, test1);
					formatLocatorClick(driver, Activity_Amount_Column_VC, activityname);

					waitForElement(driver, Formula_builder_btn_VC);
					click(driver, Formula_builder_btn_VC);

					waitForElement(driver, Formula_Bulder_Window_VC);
					Step_End(18, "Select that activity and click on Formula builder option. ", test, test1);

					if (Formula_Build_Option.equals("By_Sendkeys")) {
						waitForElement(driver, Formula_Input_FormulaBuilder_VC);
						sendKeys(driver, Formula_Input_FormulaBuilder_VC, Formula_Value);

					} else {
						Step_Start(19, "Click on Variable search and select the required variable code.", test, test1);

						waitForElement(driver, VC_Variable);
						click(driver, VC_Variable);

						waitForElement(driver, Variable_SearchBtn_VC);
						click(driver, Variable_SearchBtn_VC);

						twoColumnSearchWindowMultipleValue(driver, Formula_Variable_Header, Twocolumnsearch_Condition,
								Formula_Variable);
						Step_End(19, "Click on Variable search and select the required variable code.", test, test1);

						Step_Start(20, "Click Assign option and give the formula as per the requirement.", test, test1);

						waitForElement(driver, Assign_Btn_FormulaBuilder_VC);
						click(driver, Assign_Btn_FormulaBuilder_VC);

						formatLocatorClick(driver, Select_Condition_Formula_VC, Select_Formula_Condition);
						Step_End(20, "Click Assign option and give the formula as per the requirement.", test, test1);

						waitForElement(driver, Elements_FormulaBuild_VC);
						click(driver, Elements_FormulaBuild_VC);

						waitForElement(driver, Variable_Input_Formula_VC);
						sendKeys(driver, Variable_Input_Formula_VC, Num_Value_Formula);

						waitForElement(driver, Assign_Btn_Element_VC);
						click(driver, Assign_Btn_Element_VC);
						Step_End(20, "Click Assign option and give the formula as per the requirement.", test, test1);

						Step_Start(21,
								"Click on slab builder and double click on the variable to give from,to and constant",
								test, test1);
						Step_Start(22, "Click on add option to give multiple slabs", test, test1);

						waitForElement(driver, Slab_Builder_Btn_VC);
						click(driver, Slab_Builder_Btn_VC);

						waitForElement(driver, Slab_builder_Window_VC);
						formatLocatorDoubleClick(driver, Variable_Column_SlabBuilder_VC, Formula_Variable);

						formatLocatorClick(driver, SlabType_select, Select_Slab_Option);

						waitForElement(driver, From_Input_Colum_Slab_VC);
						doubleClick(driver, From_Input_Colum_Slab_VC);
						sendKeys(driver, From_Input_Slab_VC, From_input_Slab);

						doubleClick(driver, To_Input_Column_Slab_VC);
						sendKeys(driver, To_Input_Slab_VC, To_Input_Slab);

						doubleClick(driver, Consant_Input_Column_Slab_VC);
						sendKeys(driver, Consant_Input_Slab_VC, Consonant_Input_Slab);

						Step_End(21, "Click on add option to give multiple slabs", test, test1);

						Step_End(22,
								"Click on slab builder and double click on the variable to give from,to and constant",
								test, test1);

						Step_Start(23, "Select Cumulative and Report by agency if required and click ok option.  ",
								test, test1);

						if (Cumulative_Select.equalsIgnoreCase("Yes")) {
							waitForElement(driver, Cumulative_Checkbox_VC);
							click(driver, Cumulative_Checkbox_VC);
						}

						waitForElement(driver, Save_Slab_button_VC);
						click(driver, Save_Slab_button_VC);

						waitForElement(driver, Slab_ok_Btn_VC);
						click(driver, Slab_ok_Btn_VC);
						Step_End(23, "Select Cumulative and Report by agency if required and click ok option.  ", test,
								test1);

					}

					waitForElement(driver, Formula_Ok_Btn_VC);
					click(driver, Formula_Ok_Btn_VC);

				}

			}

			p++;

		}

		Step_End(7,
				"If the charge type is Sub to formula, Click on the formula builder to give the required formula details",
				test, test1);

		Step_Start(8, "Click on the tool bar save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(8, "Click on the tool bar save button", test, test1);

		Step_Start(9, "Check whether the system populates the confirmation message as 'Do you want to renegotiate?'",
				test, test1);

		waitForPopup(driver, popup_Message, Renegotitate_Popup);

		String actual_negotiate_Popup = getText(driver, popup_Message);

		if (actual_negotiate_Popup.equals(Renegotitate_Popup)) {

			System.out.println("Renegotiate popup is displayed || Expected popup message was : " + Renegotitate_Popup
					+ " || Actual popup message was : " + actual_negotiate_Popup);
			Extent_pass_New(driver, "Renegotiate popup is displayed || Expected popup message was : "
					+ Renegotitate_Popup + " || Actual popup message was : " + actual_negotiate_Popup, test, test1);

		} else {

			System.out.println("Renegotiate popup is not displayed || Expected popup message was : "
					+ Renegotitate_Popup + " || Actual popup message was : " + actual_negotiate_Popup);
			Extent_fail(driver, "Renegotiate popup is not displayed || Expected popup message was : "
					+ Renegotitate_Popup + " || Actual popup message was : " + actual_negotiate_Popup, test, test1);
		}

		Step_End(9, "Check whether the system populates the confirmation message as 'Do you want to renegotiate?'",
				test, test1);

		Step_Start(10, "Click on 'No' option", test, test1);

		waitForElement(driver, popup_Message_No_Button);
		click(driver, popup_Message_No_Button);

		Step_End(10, "Click on 'No' option", test, test1);

		Step_Start(11,
				"Check whether the system populates the confirmation message as 'Do you want to update this contract?'",
				test, test1);

		waitForPopup(driver, popup_Message, Update_Confirmation_Popup);

		String Actualconfirmation_Popup = getText(driver, popup_Message);

		if (Actualconfirmation_Popup.equals(Update_Confirmation_Popup)) {

			System.out.println("Update confirmation popup is displayed || Expected popup message was : "
					+ Update_Confirmation_Popup + " || Actual popup message was : " + Actualconfirmation_Popup);
			Extent_pass_New(driver,
					"Update confirmation popup is displayed || Expected popup message was : "
							+ Update_Confirmation_Popup + " || Actual popup message was : " + Actualconfirmation_Popup,
					test, test1);

		} else {

			System.out.println("Update confirmation popup is not displayed || Expected popup message was : "
					+ Update_Confirmation_Popup + " || Actual popup message was : " + Actualconfirmation_Popup);
			Extent_fail(driver,
					"Update confirmation popup is not displayed || Expected popup message was : "
							+ Update_Confirmation_Popup + " || Actual popup message was : " + Actualconfirmation_Popup,
					test, test1);
		}

		Step_End(11,
				"Check whether the system populates the confirmation message as 'Do you want to update this contract?'",
				test, test1);

		Step_Start(12, "Click on 'No' option", test, test1);

		waitForElement(driver, popup_Message_No_Button);
		click(driver, popup_Message_No_Button);

		Step_End(12, "Click on 'No' option", test, test1);

		Step_Start(13, "Ensure that the vendor contract details are not updated", test, test1);

		if (!isdisplayed(driver, popup_Message_Ok_Button)) {

			System.out.println(
					"Expected result is : If the user click No button, Vendor contract should not be updated || Actual result is : If the user click No button, Vendor contract is not updated");
			Extent_pass_New(driver,
					"Expected result is : If the user click No button, Vendor contract should not be updated || Actual result is : If the user click No button, Vendor contract is not updated ",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : If the user click No button, Vendor contract should not be updated || Actual result is : If the user click No button, Vendor contract is updated");
			Extent_fail(driver,
					"Expected result is : If the user click No button, Vendor contract should not be updated || Actual result is : If the user click No button, Vendor contract is updated ",
					test, test1);

		}

		Step_End(13, "Ensure that the vendor contract details are not updated", test, test1);

		Step_Start(14, " Click on 'Yes' option for the confirmation message 'Do you want to update  the contract?'",
				test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_No_Button);
		click(driver, popup_Message_No_Button);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(14, " Click on 'Yes' option for the confirmation message 'Do you want to update  the contract?'", test,
				test1);

		Step_Start(15, "Click on 'ok' option for the validation message 'Vendor contracts updated'", test, test1);

		waitForPopup(driver, popup_Message, Updated_popup);

		String ActualUpdated_Popup = getText(driver, popup_Message);

		if (ActualUpdated_Popup.equals(Updated_popup)) {

			System.out.println("Vendor contract details are updated || Expected popup message was : " + Updated_popup
					+ " || Actual popup message was : " + ActualUpdated_Popup);
			Extent_pass_New(driver, "Vendor contract details are updated || Expected popup message was : "
					+ Updated_popup + " || Actual popup message was : " + ActualUpdated_Popup, test, test1);

		} else {

			System.out.println("Vendor contract details are updated || Expected popup message was : " + Updated_popup
					+ " || Actual popup message was : " + ActualUpdated_Popup);
			Extent_fail(driver, "Vendor contract details are updated || Expected popup message was : " + Updated_popup
					+ " || Actual popup message was : " + ActualUpdated_Popup, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(15, "Click on 'ok' option for the validation message 'Vendor contracts updated'", test, test1);

		Step_Start(16, "Click on 'Yes' for the confirmation message 'Do you want renegotiate?'", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(16, "Click on 'Yes' for the confirmation message 'Do you want renegotiate?'", test, test1);

		Step_Start(17, "Enter the negotiated by and enter the required negotiated valid from and valid to details",
				test, test1);

		waitForElement(driver, Negotiated_By);
		sendKeys(driver, Negotiated_By, NegotiatedBY);

		waitForElement(driver, Negotiated_FromDate);
		selectDatePicker(driver, Negotiated_FromDate, Negotiated_From_Date);

		waitForElement(driver, Negotiated_ToDate);
		selectDatePicker(driver, Negotiated_ToDate, Negotiated_To_Date);

		Step_End(17, "Enter the negotiated by and enter the required negotiated valid from and valid to details", test,
				test1);

		Step_Start(18, "Click on 'ok' option", test, test1);

		waitForElement(driver, Negotiated_Ok);
		click(driver, Negotiated_Ok);

		Step_End(18, "Click on 'ok' option", test, test1);

		Step_Start(19, "Ensure that the system shows the message as Vendor contract saved and click 'ok' option", test,
				test1);

		waitForPopup(driver, popup_Message, Saved_popup);

		String ActualSaved_Popup = getText(driver, popup_Message);

		if (ActualSaved_Popup.equals(Saved_popup)) {

			System.out.println("Vendor contract details are updated || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + ActualSaved_Popup);
			Extent_pass_New(driver, "Vendor contract details are updated || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + ActualSaved_Popup, test, test1);

		} else {

			System.out.println("Vendor contract details are updated || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + ActualSaved_Popup);
			Extent_fail(driver, "Vendor contract details are updated || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + ActualSaved_Popup, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(19, "Ensure that the system shows the message as Vendor contract saved and click 'ok' option", test,
				test1);

		Extent_completed(testCaseName, test, test1);

	}
}
