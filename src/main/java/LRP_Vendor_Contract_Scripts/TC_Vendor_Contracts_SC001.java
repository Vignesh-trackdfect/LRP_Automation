package LRP_Vendor_Contract_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Contracts_SC001 extends Keywords {

	public void Vendor_Contracts_SC001(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Vendor_Contracts_SC001";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_User = Excel_data.get("Agency_User");
		String Vendor_Contract_Module = Excel_data.get("Vendor_Contract_Module");
		String Two_Column_Filter_Condition = Excel_data.get("Two_Column_Filter_Condition");
		String Contract_Code = Excel_data.get("Contract_Code");
		String Contract_Type_Header = Excel_data.get("Contract_Type_Header");
		String Vendor_Code_Value = Excel_data.get("Vendor_Code_Value");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Date_Picker_Select = Excel_data.get("Date_Picker_Select");
		String From_Date_value = Excel_data.get("From_Date_value");
		String To_Date_Value = Excel_data.get("To_Date_Value");
		String Currency_Select_Header = Excel_data.get("Currency_Select_Header");
		String Currency_Code_Value = Excel_data.get("Currency_Code_Value");
		String Vendor_Contract_Activity_Popup = Excel_data.get("Vendor_Contract_Activity_Popup");
		String Select_Main_Activity = Excel_data.get("Select_Main_Activity");
		String Activity_Remove_Popup = Excel_data.get("Activity_Remove_Popup");
		String Select_Eqp_Type = Excel_data.get("Select_Eqp_Type");
		String Select_Eqp_Status = Excel_data.get("Select_Eqp_Status");
		String Select_Eqp_Currency = Excel_data.get("Select_Eqp_Currency");
		String Select_Disbursement = Excel_data.get("Select_Disbursement");
		String Select_ParentActibity = Excel_data.get("Select_ParentActibity");
		String Select_Subactivity_List = Excel_data.get("Select_Subactivity_List");
		String Filter_Headers_AG_Grid = Excel_data.get("Filter_Headers_AG_Grid");

		String Amount_Main_Activity = Excel_data.get("Amount_Main_Activity");
		String Amount_Subactivity_List = Excel_data.get("Amount_Subactivity_List");
		String Amount_all_Activity = Excel_data.get("Amount_all_Activity");

		String Formula_Main_Activity = Excel_data.get("Formula_Main_Activity");
		String Formula_Subactivity = Excel_data.get("Formula_Subactivity");

		String Select_ChargeType = Excel_data.get("Select_ChargeType");
		String Formula_Value = Excel_data.get("Formula_Value");
		String Formula_Variable = Excel_data.get("Formula_Variable");
		String Formula_Variable_Header = Excel_data.get("Formula_Variable_Header");
		String Select_Formula_Condition = Excel_data.get("Select_Formula_Condition");
		String Num_Value_Formula = Excel_data.get("Num_Value_Formula");
		String Vendor_Contract_Saved_Popup = Excel_data.get("Vendor_Contract_Saved_Popup");
		String Formula_Build_Option = Excel_data.get("Formula_Build_Option");
		String Select_Slab_Option = Excel_data.get("Select_Slab_Option");
		String Cumulative_Select = Excel_data.get("Cumulative_Select");
		String From_input_Slab = Excel_data.get("From_input_Slab");
		String To_Input_Slab = Excel_data.get("To_Input_Slab");
		String Consonant_Input_Slab = Excel_data.get("Consonant_Input_Slab");
		String Activitycode_column = Excel_data.get("Activitycode_column");
		String ActivityCode_ForDelete = Excel_data.get("ActivityCode_ForDelete");

		String TwocolumnHeader = Excel_data.get("TwocolumnHeader");
		String TwocolumnCondition = Excel_data.get("TwocolumnCondition");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		// Login
		LRP_Login(driver, username, password);
		SwitchProfile(driver, Agency_User);

		// Vendor Contract
		Step_Start(1, "Enter the  screen name as 'Vendor contracts' in module search field.   ", test, test1);
		moduleNavigate(driver, Vendor_Contract_Module);
		Step_End(1, "Enter the  screen name as 'Vendor contracts' in module search field.   ", test, test1);

		newButton(driver);

		Step_Start(2, "Click on the contract type search button and select the required contract.  ", test, test1);
		waitForElement(driver, search_icon_contract_type_Vc);
		click(driver, search_icon_contract_type_Vc);
		twoColumnSearchWindowMultipleValue(driver, Contract_Type_Header, Two_Column_Filter_Condition, Contract_Code);
		Step_End(2, "Click on the contract type search button and select the required contract.  ", test, test1);

		Step_Start(3, "Click on the vendor code search button and select the required vendor.   ", test, test1);
		waitForElement(driver, vendor_code_search_icon_Vc);
		click(driver, vendor_code_search_icon_Vc);
		twoColumnSearchWindowMultipleValue(driver, Vendor_Code_Header, Two_Column_Filter_Condition, Vendor_Code_Value);
		Step_End(3, "Click on the vendor code search button and select the required vendor.   ", test, test1);

		Step_Start(4, "Select the valid from and valid to and enter the required datas.       ", test, test1);

		waitForElement(driver, valid_from_date_Vc);
		if (Date_Picker_Select.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, valid_from_date_Vc, From_Date_value);
		} else {
			waitForElement(driver, valid_from_date_Vc);
			clearAndType(driver, valid_from_date_Vc, From_Date_value);
		}

		waitForElement(driver, valid_To_date_Vc);
		if (Date_Picker_Select.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, valid_To_date_Vc, To_Date_Value);
		} else {
			waitForElement(driver, valid_To_date_Vc);
			clearAndType(driver, valid_To_date_Vc, To_Date_Value);
		}

		Step_End(4, "Select the valid from and valid to and enter the required datas.       ", test, test1);

		Step_Start(5, "Click on the currency search option and select the required currency.  ", test, test1);

		waitForElement(driver, currency_search_icon_vc);
		click(driver, currency_search_icon_vc);
		twoColumnSearchWindowMultipleValue(driver, Currency_Select_Header, Two_Column_Filter_Condition,
				Currency_Code_Value);
		Step_End(5, "Click on the currency search option and select the required currency.  ", test, test1);

		Step_Start(6, "Click on the show button.  ", test, test1);
		waitForElement(driver, show_btn_vc);
		click(driver, show_btn_vc);
		Step_End(6, "Click on the show button.  ", test, test1);

		Step_Start(7, "Click on 'No' to get the activities not from predictable activity behaviour.   ", test, test1);

		waitForPopup(driver, popup_Message, Vendor_Contract_Activity_Popup);
		String Act_Vendor_Activity_popup = getText(driver, popup_Message).trim();
		if (Act_Vendor_Activity_popup.equals(Vendor_Contract_Activity_Popup.trim())) {
			System.out.println("Popup Matched || Expected popup : " + Vendor_Contract_Activity_Popup
					+ " || Actual popup : " + Act_Vendor_Activity_popup);
			Extent_pass_New(driver, "Popup Matched || Expected popup : " + Vendor_Contract_Activity_Popup
					+ " || Actual popup : " + Act_Vendor_Activity_popup, test, test1);
		} else {
			System.out.println("Popup Not Matched || Expected popup : " + Vendor_Contract_Activity_Popup
					+ " || Actual popup : " + Act_Vendor_Activity_popup);
			Extent_fail(driver, "Popup Not Matched || Expected popup : " + Vendor_Contract_Activity_Popup
					+ " || Actual popup : " + Act_Vendor_Activity_popup, test, test1);
		}

		waitForElement(driver, popup_Message_No_Button);
		click(driver, popup_Message_No_Button);
		Step_End(7, "Click on 'No' to get the activities not from predictable activity behaviour.   ", test, test1);

		Step_Start(8,
				"Select the activities which are not required and right click on that activities and select the ' remove selected items' to remove it. ",
				test, test1);

		List<String> activitycodes = splitAndExpand(ActivityCode_ForDelete);

		for (String activitycode : activitycodes) {

			reArrangeAG_GridColumnsNew(driver, AG_Gridcolumns_new, Activitycode_column);

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

			waitForDisplay(driver, popup_Message);
			String Activity_Remove_Popup_Act = getText(driver, popup_Message);
			if (Activity_Remove_Popup_Act.trim().equals(Activity_Remove_Popup)) {
				System.out.println("Popup Matched || Expected popup : " + Activity_Remove_Popup + " || Actual Popup : "
						+ Activity_Remove_Popup_Act);
				Extent_pass_New(driver, "Popup Matched || Expected popup : " + Activity_Remove_Popup
						+ " || Actual Popup : " + Activity_Remove_Popup_Act, test, test1);
			} else {
				System.out.println("Popup Not Matched || Expected popup : " + Activity_Remove_Popup
						+ " || Actual Popup : " + Activity_Remove_Popup_Act);
				Extent_fail(driver, "Popup Not Matched || Expected popup : " + Activity_Remove_Popup
						+ " || Actual Popup : " + Activity_Remove_Popup_Act, test, test1);
			}

			if (isdisplayed(driver, popup_Message_Yes_Button)) {

				click(driver, popup_Message_Yes_Button);
			}

			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {

				click(driver, popup_Message_Yes_Button);
			}

		}

		Step_End(8,
				"Select the activities which are not required and right click on that activities and select the ' remove selected items' to remove it. ",
				test, test1);

		Step_Start(9, "Click on 'Yes' option. ", test, test1);

		Step_End(9, "Click on 'Yes' option.  ", test, test1);

		Step_Start(10, "Select the main activity which is present and Click the 'Enter edit input fields' option", test,
				test1);

		List<String> Mainactivities = splitAndExpand(Select_Main_Activity, ",");

		List<String> Parentactivities = splitAndExpand(Select_ParentActibity, "/");

		int i = 0;

		for (String mainActivity : Mainactivities) {

			reArrangeAG_GridColumnsNew(driver, AG_Gridcolumns_new, Activitycode_column);

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

				twoColumnSearchWindow1(driver, TwocolumnHeader, TwocolumnCondition, Activity);

			}

			waitForElement(driver, select_Button);
			click(driver, select_Button);

			i++;
		}

		List<String> Parentactivities2 = splitAndExpand(Select_ParentActibity, "/");
		List<String> Subactivities = splitAndExpand(Select_Subactivity_List, "/");

		int j = 0;
		int k = 0;

		for (String Mainactivity : Mainactivities) {

			if (j >= Parentactivities2.size() || k >= Subactivities.size()) {
				break; // Prevent IndexOutOfBoundsException
			}

			List<String> selectedparents = splitAndExpand(Parentactivities2.get(j), ",");

			for (String parentactivity : selectedparents) {

				String subact = Subactivities.get(k);
				System.out.println("subact : " + subact);

				if (subact != null && !subact.isBlank()) {

					reArrangeAG_GridColumnsNew(driver, AG_Gridcolumns_new, Activitycode_column);

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
						twoColumnSearchWindow1(driver, TwocolumnHeader, TwocolumnCondition, SubActivity);
					}

					waitForElement(driver, select_Button);
					click(driver, select_Button);

				}

				k++;
			}

			j++;

		}

		Step_End(15, "Click on the required activities and click 'select' option.", test, test1);

		Step_Start(16, "Double click on the amount column an give the required amount for the activities.", test,
				test1);

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

		Step_End(16, "Double click on the amount column an give the required amount for the activities.", test, test1);

		Step_Start(17, "Select the required activity and change the charge type as 'Sub to Formula' for the activity.",
				test, test1);

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

					if (isdisplayed(driver, Popup_Message)) {

						elementnotvisible1(driver, Popup_Message);
					}

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

						twoColumnSearchWindowMultipleValue(driver, Formula_Variable_Header, Two_Column_Filter_Condition,
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
					Step_Start(24, "Click ok Option.  ", test, test1);

					waitForElement(driver, Formula_Ok_Btn_VC);
					click(driver, Formula_Ok_Btn_VC);

				}

			}

			p++;

		}

		Step_End(24, "Click ok Option.  ", test, test1);

		Step_Start(25,
				"Click on save option in toolbar and check whether the system shows a confirmation message as 'Vendor contracts saved' and click ok and generates the contract number",
				test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Vendor_Contract_Saved_Popup);
		String Vendor_Contract_Saved_Popup_Act = getText(driver, popup_Message);
		if (Vendor_Contract_Saved_Popup.equals(Vendor_Contract_Saved_Popup_Act)) {
			System.out.println("Vendor_Contract_Saved Popup Matched || Expected Popup : " + Vendor_Contract_Saved_Popup
					+ " || Actual Popup : " + Vendor_Contract_Saved_Popup_Act);
			Extent_pass_New(driver, "Vendor_Contract_Saved Popup Matched || Expected Popup : "
					+ Vendor_Contract_Saved_Popup + " || Actual Popup : " + Vendor_Contract_Saved_Popup_Act, test,
					test1);
		} else {
			System.out.println("Vendor_Contract_Saved Popup Not Matched || Expected Popup : "
					+ Vendor_Contract_Saved_Popup + " || Actual Popup : " + Vendor_Contract_Saved_Popup_Act);
			Extent_fail(driver, "Vendor_Contract_Saved Popup Not Matched || Expected Popup : "
					+ Vendor_Contract_Saved_Popup + " || Actual Popup : " + Vendor_Contract_Saved_Popup_Act, test,
					test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(25,
				"Click on save option in toolbar and check whether the system shows a confirmation message as 'Vendor contracts saved' and click ok and generates the contract number",
				test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
