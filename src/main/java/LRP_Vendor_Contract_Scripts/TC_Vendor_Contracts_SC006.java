package LRP_Vendor_Contract_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Contracts_SC006 extends Keywords{

	public void Vendor_Contracts_SC006(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName = "TC_Vendor_Contracts_SC006";
		// Get data from excel sheet
		
		
		



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
		String Select_Main_Activity = Excel_data.get("Select_Main_Activity");
		String Select_Eqp_Type = Excel_data.get("Select_Eqp_Type");
		String EquipmentType_Selected_Popup = Excel_data.get("EquipmentType_Selected_Popup");
		String Select_Eqp_Status = Excel_data.get("Select_Eqp_Status");
		String EquipmentStatus_Selected_Popup = Excel_data.get("EquipmentStatus_Selected_Popup");
		String Select_Eqp_Currency = Excel_data.get("Select_Eqp_Currency");
		String EquipmentCurrency_Selected_Popup = Excel_data.get("EquipmentCurrency_Selected_Popup");
		String Select_Disbursement = Excel_data.get("Select_Disbursement");
		String Send_Disbursement_Poup = Excel_data.get("Send_Disbursement_Poup");
		String Select_Activities_List = Excel_data.get("Select_Activities_List");
		String Filter_Headers_AG_Grid = Excel_data.get("Filter_Headers_AG_Grid");
		String Amount_List_Activity = Excel_data.get("Amount_List_Activity");
		String Sub_To_Formula_Activity = Excel_data.get("Sub_To_Formula_Activity");
		String Select_ChargeType = Excel_data.get("Select_ChargeType");
		String Charge_Type_Selected_popup = Excel_data.get("Charge_Type_Selected_popup");
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
		String Select_Period_Type = Excel_data.get("Select_Period_Type");
		String Port_Code_Input = Excel_data.get("Port_Code_Input");
		String Select_Terminal_Type = Excel_data.get("Select_Terminal_Type");
		String Depot_Value_Select = Excel_data.get("Depot_Value_Select");
		String LumpSum_ChargeType = Excel_data.get("LumpSum_ChargeType");
		String Free_pool_Value = Excel_data.get("Free_pool_Value");

		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);
		
		// Login
		LRP_Login(driver, username, password);
		SwitchProfile(driver, Agency_User);
		//	Vendor Contract
		Step_Start(1, "Enter the  screen name as 'Vendor contracts' in module search field.   ", test, test1);
		moduleNavigate(driver, Vendor_Contract_Module);
		Step_End(1, "Enter the  screen name as 'Vendor contracts' in module search field.   ", test, test1);

		newButton(driver);

		Step_Start(2, "Click on the contract type search button and select the required contract.  ", test, test1);
		waitForElement(driver, search_icon_contract_type_Vc);
		click(driver,search_icon_contract_type_Vc);
		twoColumnSearchWindowMultipleValue(driver, Contract_Type_Header, Two_Column_Filter_Condition, Contract_Code);
		Step_End(2, "Click on the contract type search button and select the required contract.  ", test, test1);

		Step_Start(3, "Click on the vendor code search button and select the required vendor.   ", test, test1);
		waitForElement(driver, vendor_code_search_icon_Vc);
		click(driver,vendor_code_search_icon_Vc);
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

		Step_Start(5, "Select the period type as per the requirement.  ", test, test1);
		waitForElement(driver, Period_Input_VC);
		click(driver,Period_Input_VC);
		formatLocatorClick(driver, Select_Period_Options_VC, Select_Period_Type);
		Step_End(5, "Select the period type as per the requirement.  ", test, test1);

		Step_Start(6, "Enter the port code and terminal type and enter the terminal/depot code as per the requirement. ", test, test1);
		waitForElement(driver, PortCode_input_VC);
		click(driver,PortCode_input_VC);
		sendKeys(driver, PortCode_input_VC, Port_Code_Input);
		formatLocatorClick(driver, Select_PortCode_VC, Port_Code_Input);
		
		waitForElement(driver, Terminal_Type_Input_VC);
		click(driver,Terminal_Type_Input_VC);
		formatLocatorClick(driver, Select_Terminal_Option_VC, Select_Terminal_Type);
		
		waitForElement(driver, Depot_Terminal_Input_VC);
		click(driver,Depot_Terminal_Input_VC);
		sendKeys(driver, Depot_Terminal_Input_VC, Depot_Value_Select);
		formatLocatorClick(driver, Select_PortCode_VC, Depot_Value_Select);
		Step_End(6, "Enter the port code and terminal type and enter the terminal/depot code as per the requirement. ", test, test1);

		Step_Start(7, "Click on the currency search option and select the required currency.  ", test, test1);

		waitForElement(driver, currency_search_icon_vc);
		click(driver,currency_search_icon_vc);
		twoColumnSearchWindowMultipleValue(driver, Currency_Select_Header, Two_Column_Filter_Condition, Currency_Code_Value);
		Step_End(7, "Click on the currency search option and select the required currency.  ", test, test1);

		Step_Start(8, "Click on the show button.  ", test, test1);
		waitForElement(driver, show_btn_vc);
		click(driver,show_btn_vc);
		Step_End(8, "Click on the show button.  ", test, test1);
		
		Step_Start(9, "Select the main activity which is present and Click the 'Enter edit input fields' option", test, test1);
		waitForElement(driver, vc_rows);
		formatLocatorClick(driver, Select_Activity_VC, Select_Main_Activity);
		
		waitForElement(driver, edit_input_field_Vc);
		click(driver,edit_input_field_Vc);
		Step_End(9, "Select the main activity which is present and Click the 'Enter edit input fields' option", test, test1);
		
		Step_Start(10, "Select the charge type as 'Lumpsum'.   ", test, test1);
		waitForElement(driver, ChargeType_Input_VC);
		click(driver,ChargeType_Input_VC);
		formatLocatorClick(driver, Select_ChargeTypeOption, LumpSum_ChargeType);
		Step_End(10, "Select the charge type as 'Lumpsum'.   ", test, test1);

		Step_Start(11, "Select the required equipment type and equipment status. ", test, test1);
		waitForElement(driver, equip_type_dd_label_Vc);
		jsClick(driver,equip_type_dd_label_Vc);
		formatLocatorClick(driver, equip_type_options_Vc, Select_Eqp_Type);
		
		waitForPopup(driver, Popup_Message, EquipmentType_Selected_Popup);
		String Eqp_Popup_Act=getText(driver, Popup_Message);
		if(EquipmentType_Selected_Popup.equals(Eqp_Popup_Act)) {
			System.out.println("Equipement Type Popup Matched || Expected Popup : "+EquipmentType_Selected_Popup+" || Actual Popup : "+Eqp_Popup_Act);
			Extent_pass_New(driver, "Equipement Type Popup Matched || Expected Popup : "+EquipmentType_Selected_Popup+" || Actual Popup : "+Eqp_Popup_Act, test, test1);
		}else {
			System.out.println("Equipement Type Popup Not Matched || Expected Popup : "+EquipmentType_Selected_Popup+" || Actual Popup : "+Eqp_Popup_Act);
			Extent_fail(driver, "Equipement Type Popup Not Matched || Expected Popup : "+EquipmentType_Selected_Popup+" || Actual Popup : "+Eqp_Popup_Act, test, test1);
		}
		elementnotvisible1(driver, Popup_Message);
		
		waitForElement(driver, eqp_sts_label_vc);
		jsClick(driver,eqp_sts_label_vc);
		String newloc = String.format(equip_sts_Vc_option, Select_Eqp_Status);
		VerticalScroll_Visible(driver, newloc, verticalscroll);
		formatLocatorClick(driver, equip_sts_Vc_option, Select_Eqp_Status);

		waitForPopup(driver, Popup_Message, EquipmentStatus_Selected_Popup);
		String EqpStatus_Popup_Act=getText(driver, Popup_Message);
		if(EquipmentStatus_Selected_Popup.equals(EqpStatus_Popup_Act)) {
			System.out.println("Equipement Status Popup Matched || Expected Popup : "+EquipmentStatus_Selected_Popup+" || Actual Popup : "+EqpStatus_Popup_Act);
			Extent_pass_New(driver, "Equipement Status Popup Matched || Expected Popup : "+EquipmentStatus_Selected_Popup+" || Actual Popup : "+EqpStatus_Popup_Act, test, test1);
		}else {
			System.out.println("Equipement Status Popup Not Matched || Expected Popup : "+EquipmentStatus_Selected_Popup+" || Actual Popup : "+EqpStatus_Popup_Act);
			Extent_fail(driver, "Equipement Status Popup Not Matched || Expected Popup : "+EquipmentStatus_Selected_Popup+" || Actual Popup : "+EqpStatus_Popup_Act, test, test1);
		}
		elementnotvisible1(driver, Popup_Message);
		Step_End(11, "Select the required equipment type and equipment status. ", test, test1);

		Step_Start(12, "Select the required currency. ", test, test1);

		waitForElement(driver, currency_dd_Vc);
		jsClick(driver,currency_dd_Vc);
		formatLocatorClick(driver, currency_dd_options, Select_Eqp_Currency);
		
		waitForPopup(driver, Popup_Message, EquipmentCurrency_Selected_Popup);
		String EqpCurrency_Popup_Act=getText(driver, Popup_Message);
		if(EquipmentCurrency_Selected_Popup.equals(EqpCurrency_Popup_Act)) {
			System.out.println("Equipement Currency Popup Matched || Expected Popup : "+EquipmentCurrency_Selected_Popup+" || Actual Popup : "+EqpCurrency_Popup_Act);
			Extent_pass_New(driver, "Equipement Currency Popup Matched || Expected Popup : "+EquipmentCurrency_Selected_Popup+" || Actual Popup : "+EqpCurrency_Popup_Act, test, test1);
		}else {
			System.out.println("Equipement Currency Popup Not Matched || Expected Popup : "+EquipmentCurrency_Selected_Popup+" || Actual Popup : "+EqpCurrency_Popup_Act);
			Extent_fail(driver, "Equipement Currency Popup Not Matched || Expected Popup : "+EquipmentCurrency_Selected_Popup+" || Actual Popup : "+EqpCurrency_Popup_Act, test, test1);
		}
		elementnotvisible1(driver, Popup_Message);
		Step_End(12, "Select the required currency. ", test, test1);

		Step_Start(13, " Select the Send to Disbursement and click 'Yes'.       ", test, test1);

		waitForElement(driver, Disbursement_Input_VC);
		click(driver,Disbursement_Input_VC);
		formatLocatorClick(driver, Select_Disbursement_option_VC, Select_Disbursement);
		
		waitForPopup(driver, Popup_Message, Send_Disbursement_Poup);
		String Disbursement_Popup_Act=getText(driver, Popup_Message);
		if(Send_Disbursement_Poup.equals(Disbursement_Popup_Act)) {
			System.out.println("Disbursement Popup Matched || Expected Popup : "+Send_Disbursement_Poup+" || Actual Popup : "+Disbursement_Popup_Act);
			Extent_pass_New(driver, "Disbursement Popup Matched || Expected Popup : "+Send_Disbursement_Poup+" || Actual Popup : "+Disbursement_Popup_Act, test, test1);
		}else {
			System.out.println("Disbursement Popup Not Matched || Expected Popup : "+Send_Disbursement_Poup+" || Actual Popup : "+Disbursement_Popup_Act);
			Extent_fail(driver, "Disbursement Popup Not Matched || Expected Popup : "+Send_Disbursement_Poup+" || Actual Popup : "+Disbursement_Popup_Act, test, test1);
		}
		elementnotvisible1(driver, Popup_Message);
		Step_End(13, " Select the Send to Disbursement and click 'Yes'.       ", test, test1);

		Step_Start(14, "Select the main activity in the grid and right click and select 'add item' option.    ", test, test1);

		formatRightClick(driver, Select_Activity_VC, Select_Main_Activity);
		
		waitForElement(driver, Add_item_PAB);
		click(driver,Add_item_PAB);
		Step_End(14, "Select the main activity in the grid and right click and select 'add item' option.    ", test, test1);

		Step_Start(15, "Click on the required activities and click 'select' option.", test, test1);

		List<String> Activities_List=splitAndExpand(Select_Activities_List,",");
		waitForElement(driver, Activity_Select_Window);
		for(String Activity:Activities_List) {
			formatLocatorClick(driver, Select_Activities_VC, Activity);
		}
		
		waitForElement(driver, select_Button);
		click(driver, select_Button);
		Step_End(15, "Click on the required activities and click 'select' option.", test, test1);

		Step_Start(16, "Double click on the amount column an give the required amount for the activities.", test, test1);

		waitForElement(driver, Columns_AG_Grid_VC);
		reArrangeAG_GridColumnsNew(driver, Columns_AG_Grid_VC, Filter_Headers_AG_Grid);
		
		List<String> AmountList=splitAndExpand(Amount_List_Activity, ",");
		
		for(int k=0;k<Activities_List.size();k++) {
			String Activity=Activities_List.get(k);
			String Act_Amount=AmountList.get(k);
			formatLocatorDoubleClick(driver, Activity_Amount_Column_VC, Activity);
			formatLocatorSendKeys(driver, Activity_Amount_input_VC, Activity, Act_Amount);
		}
		formatLocatorClick(driver, Select_Activity_VC, Select_Main_Activity);

		for(int k=0;k<Activities_List.size();k++) {
			String Activity=Activities_List.get(k);
			formatLocatorDoubleClick(driver, Free_pool_Column_VC, Activity);
			formatLocatorSendKeys(driver, Free_Pool_Input_VC, Activity, Free_pool_Value);
		}
		
		Step_End(16, "Double click on the amount column an give the required amount for the activities.", test, test1);

		Step_Start(17, "Select the required activity and change the charge type as 'Sub to Formula' for the activity.", test, test1);

		waitForElement(driver, vc_rows);		
		formatLocatorClick(driver, Activity_Amount_Column_VC, Sub_To_Formula_Activity);
		
		waitForElement(driver, edit_input_field_Vc);
		click(driver,edit_input_field_Vc);
		
		waitForElement(driver, ChargeType_Input_VC);
		click(driver,ChargeType_Input_VC);
		formatLocatorClick(driver, Select_ChargeTypeOption, Select_ChargeType);
		
		waitForPopup(driver, Popup_Message, Charge_Type_Selected_popup);
		String ChargeType_Popup_Act=getText(driver, Popup_Message);
		if(Charge_Type_Selected_popup.equals(ChargeType_Popup_Act)) {
			System.out.println("Charge Type Popup Matched || Expected Popup : "+Charge_Type_Selected_popup+" || Actual Popup : "+ChargeType_Popup_Act);
			Extent_pass_New(driver, "Charge Type Popup Matched || Expected Popup : "+Charge_Type_Selected_popup+" || Actual Popup : "+ChargeType_Popup_Act, test, test1);
		}else {
			System.out.println("Charge Type Popup Not Matched || Expected Popup : "+Charge_Type_Selected_popup+" || Actual Popup : "+ChargeType_Popup_Act);
			Extent_fail(driver, "Charge Type Popup Not Matched || Expected Popup : "+Charge_Type_Selected_popup+" || Actual Popup : "+ChargeType_Popup_Act, test, test1);
		}
		elementnotvisible1(driver, Popup_Message);
		Step_End(17, "Select the required activity and change the charge type as 'Sub to Formula' for the activity.", test, test1);

		Step_Start(18, "Select that activity and click on Formula builder option. ", test, test1);
		formatLocatorClick(driver, Activity_Amount_Column_VC, Sub_To_Formula_Activity);
		
		waitForElement(driver, Formula_builder_btn_VC);
		click(driver,Formula_builder_btn_VC);
		
		waitForElement(driver, Formula_Bulder_Window_VC);
		Step_End(18, "Select that activity and click on Formula builder option. ", test, test1);


		if(Formula_Build_Option.equals("By_Sendkeys")) {
			waitForElement(driver, Formula_Input_FormulaBuilder_VC);
			sendKeys(driver, Formula_Input_FormulaBuilder_VC, Formula_Value);
			
		}else {
			Step_Start(19, "Click on Variable search and select the required variable code.", test, test1);

			waitForElement(driver, Variable_SearchBtn_VC);
			click(driver,Variable_SearchBtn_VC);
			
			twoColumnSearchWindowMultipleValue(driver, Formula_Variable_Header, Two_Column_Filter_Condition, Formula_Variable);
			Step_End(19, "Click on Variable search and select the required variable code.", test, test1);

			Step_Start(20, "Click Assign option and give the formula as per the requirement.", test, test1);

			waitForElement(driver, Assign_Btn_FormulaBuilder_VC);
			click(driver,Assign_Btn_FormulaBuilder_VC);
			
			formatLocatorClick(driver, Select_Condition_Formula_VC, Select_Formula_Condition);

			waitForElement(driver, Elements_FormulaBuild_VC);
			click(driver,Elements_FormulaBuild_VC);
			
			waitForElement(driver, Variable_Input_Formula_VC);
			sendKeys(driver, Variable_Input_Formula_VC, Num_Value_Formula);
			
			waitForElement(driver, Assign_Btn_Element_VC);
			click(driver,Assign_Btn_Element_VC);
			Step_End(20, "Click Assign option and give the formula as per the requirement.", test, test1);
			

			Step_Start(21, "Click on slab builder and double click on the variable to give from,to and constant", test, test1);
			Step_Start(22, "Click on add option to give multiple slabs", test, test1);

			waitForElement(driver, Slab_Builder_Btn_VC);
			click(driver,Slab_Builder_Btn_VC);
			
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
			Step_End(22, "Click on add option to give multiple slabs", test, test1);
			Step_End(21, "Click on slab builder and double click on the variable to give from,to and constant", test, test1);

			Step_Start(23, "Select Cumulative and Report by agency if required and click ok option.  ", test, test1);

			if(Cumulative_Select.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Cumulative_Checkbox_VC);
				click(driver,Cumulative_Checkbox_VC);
			}
			
			waitForElement(driver, Save_Slab_button_VC);
			click(driver,Save_Slab_button_VC);
			
			waitForElement(driver, Slab_ok_Btn_VC);
			click(driver,Slab_ok_Btn_VC);
			Step_End(23, "Select Cumulative and Report by agency if required and click ok option.  ", test, test1);

		}
		Step_Start(24, "Click ok Option.  ", test, test1);

		waitForElement(driver, Formula_Ok_Btn_VC);
		click(driver,Formula_Ok_Btn_VC);
		Step_End(24, "Click ok Option.  ", test, test1);

		Step_Start(25, "Click on save option in toolbar and check whether the system shows a confirmation message as 'Vendor contracts saved' and click ok and generates the contract number", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		
		waitForPopup(driver, popup_Message, Vendor_Contract_Saved_Popup);
		String Vendor_Contract_Saved_Popup_Act=getText(driver, popup_Message);
		if(Vendor_Contract_Saved_Popup.equals(Vendor_Contract_Saved_Popup_Act)) {
			System.out.println("Vendor_Contract_Saved Popup Matched || Expected Popup : "+Vendor_Contract_Saved_Popup+" || Actual Popup : "+Vendor_Contract_Saved_Popup_Act);
			Extent_pass_New(driver, "Vendor_Contract_Saved Popup Matched || Expected Popup : "+Vendor_Contract_Saved_Popup+" || Actual Popup : "+Vendor_Contract_Saved_Popup_Act, test, test1);
		}else {
			System.out.println("Vendor_Contract_Saved Popup Not Matched || Expected Popup : "+Vendor_Contract_Saved_Popup+" || Actual Popup : "+Vendor_Contract_Saved_Popup_Act);
			Extent_fail(driver, "Vendor_Contract_Saved Popup Not Matched || Expected Popup : "+Vendor_Contract_Saved_Popup+" || Actual Popup : "+Vendor_Contract_Saved_Popup_Act, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		waitForElement(driver, contract_No_VC);
		String Vendor_Num_Act=getAttribute(driver, contract_No_VC, "value");
		if(Vendor_Num_Act==null || Vendor_Num_Act.isEmpty()|| Vendor_Num_Act.equals("<<New>>")) {
			System.out.println("Expected : Vendor Contract Number should be generated ||  Actual : Vendor Contract Number is not generated,  Contract Number :  "+Vendor_Num_Act);
			Extent_fail(driver, "Expected : Vendor Contract Number should be generated ||  Actual : Vendor Contract Number is not generated,  Contract Number :  "+Vendor_Num_Act, test, test1);
		}else {
			System.out.println("Expected : Vendor Contract Number should be generated ||  Actual : Vendor Contract Number is generated,  Contract Number :  "+Vendor_Num_Act);
			Extent_pass_New(driver, "Expected : Vendor Contract Number should be generated ||  Actual : Vendor Contract Number is generated,  Contract Number :  "+Vendor_Num_Act, test, test1);
		}
		
		Step_End(25, "Click on save option in toolbar and check whether the system shows a confirmation message as 'Vendor contracts saved' and click ok and generates the contract number", test, test1);

		Extent_completed(testCaseName, test, test1);

		
	}
}
