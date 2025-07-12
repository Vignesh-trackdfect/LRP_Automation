package LRP_Cost_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS077 extends Keywords {
	
	public void  Cost_Activity_Report_TS077(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS077";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String activity_module = Excel_data.get("Activity_module");
		String activity_desc_data = Excel_data.get("Activity_desc_data");
		String activity_type_data = Excel_data.get("Activity_type_data");
		String contract_type_data = Excel_data.get("Contract_type_data");
		String gam_module = Excel_data.get("GAM_module");
		String condition = Excel_data.get("condition");
		String main_activity_data = Excel_data.get("main_activity_data");
		String global_updated_msg = Excel_data.get("global_updated_msg");
		String vendor_contract_module = Excel_data.get("vendor_contract_module");
		String vendor_code_data_Vc = Excel_data.get("vendor_code_data_Vc");
		String datepicker = Excel_data.get("datepicker");
		String from_date_Vc = Excel_data.get("from_date_Vc");
		String To_date_Vc = Excel_data.get("To_date_Vc");
		String Currency_Value_VC = Excel_data.get("Currency_Value_VC");
		String mappingSavedPopup = Excel_data.get("MappingSavedPopup");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String CAR_Saved_Poupup = Excel_data.get("CAR_Saved_Poupup");
		String Arrival_Date_Condition = Excel_data.get("Arrival_Date_Condition");
		String Arrival_Date_Value = Excel_data.get("Arrival_Date_Value");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_Mode_type = Excel_data.get("Select_Mode_type");
		String Predictable_Select_Type = Excel_data.get("Predictable_Select_Type");
		String Predictable_Select_Codition = Excel_data.get("Predictable_Select_Codition");
		String Predictable_Activity_Module = Excel_data.get("Predictable_Activity_Module");
		String Popup_Text_Exp = Excel_data.get("Popup_Text_Exp");
		String Un_Predictable_Table_Filter_Headers = Excel_data.get("Un_Predictable_Table_Filter_Headers");
		String columnHeaders_predictable = Excel_data.get("ColumnHeaders_predictable");
		String contract_code_header = Excel_data.get("contract_code_header");
		String vendor_code_header = Excel_data.get("vendor_code_header");
		String currency_code_header = Excel_data.get("currency_code_header");
		String port_code_header = Excel_data.get("port_code_header");
		String service_header = Excel_data.get("service_header");
		String vessel_code_header = Excel_data.get("vessel_code_header");
		String terminal_code_header = Excel_data.get("terminal_code_header");
		String arrival_date_header = Excel_data.get("arrival_date_header");
		String Activity_code_data = Excel_data.get("Activity_code_data");
		String Activity_Saved_Popup = Excel_data.get("Activity_Saved_Popup");
		String Activities_Mapped_popup = Excel_data.get("Activities_Mapped_popup");
		String Parent_Activity_Code_GAM = Excel_data.get("Parent_Activity_Code_GAM");
		String Sub_Activity_Code_GAM = Excel_data.get("Sub_Activity_Code_GAM");
		String Select_ChargeType = Excel_data.get("Select_ChargeType");
		String Select_Eqp_Type = Excel_data.get("Select_Eqp_Type");
		String Select_Eqp_Status = Excel_data.get("Select_Eqp_Status");
		String Select_Eqp_Currency = Excel_data.get("Select_Eqp_Currency");
		String Select_Disbursement = Excel_data.get("Select_Disbursement");
		String Formula_Values = Excel_data.get("Formula_Values");		
		String Activitity_Add_Header = Excel_data.get("Activitity_Add_Header");
		String Table_Headers_Filter_AG_Grid = Excel_data.get("Table_Headers_Filter_AG_Grid");
		String Predictable_Activity_Need_To_Add = Excel_data.get("Predictable_Activity_Need_To_Add");
		String Predictable_MainActivity_Header = Excel_data.get("Predictable_MainActivity_Header");
		String Predictable_SubActivity_Header = Excel_data.get("Predictable_SubActivity_Header");
		String Vendor_Contract_Saved_popup = Excel_data.get("Vendor_Contract_Saved_popup");
		String Activitity_Module_Perform = Excel_data.get("Activitity_Module_Perform");

		Actions actions=new Actions(driver);

		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		
		if(Activitity_Module_Perform.equalsIgnoreCase("Yes")) {
			Step_Start(1, "Once login to the application, enter the screen name as 'Activity' in the module search field.", test, test1);
			
			moduleNavigate(driver, activity_module);

			Step_End(1, "Once login to the application, enter the screen name as 'Activity' in the module search field.", test, test1);

			Step_Start(2, "Enter the Activity code with the required alphabets and give the required activity description and select the activity type as Sub and contract type as CTL and click the add option and next click the save option in the toolbar.", test, test1);
		
			waitForDisplay(driver, new_button_Act_Mod);
			if(isdisplayed(driver, new_button_Act_Mod)) {
				click(driver, new_button_Act_Mod);
			}
			
			newButton(driver);
			
			List<String> Activity_Codes=splitAndExpand(Activity_code_data);
			List<String> Description_Values=splitAndExpand(activity_desc_data);
			
			
			for(int i=0;i<Activity_Codes.size();i++) {
				
				waitForElement(driver, activity_code_Act_Mod);
				sendKeys(driver, activity_code_Act_Mod, Activity_Codes.get(i));
				
				waitForElement(driver, activity_description_Act_Mod);
				sendKeys(driver, activity_description_Act_Mod, Description_Values.get(i));
				
				waitForElement(driver, activity_type_dd_label);
				click(driver, activity_type_dd_label);
				
				formatLocatorClick(driver, activity_type_dd_options, activity_type_data);
			
				waitForElement(driver, contract_type_dd_label);
				click(driver, contract_type_dd_label);
				
				formatLocatorClick(driver, contract_type_dd_options, contract_type_data);

				waitForElement(driver, add_button_Act_Mod);
				click(driver, add_button_Act_Mod);
				
				if(isdisplayed(driver, popup_Message)) {
					String Poupmessage=getText(driver, popup_Message);
					System.out.println("Expected : Activity Should be add in the grid without any Error || Actual : popup displayed When try to add the Activity, popup : "+Poupmessage);
					Extent_fail(driver, "Expected : Activity Should be add in the grid without any Error || Actual : popup displayed When try to add the Activity, popup : "+Poupmessage, test, test1);
				}
			}
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message, Activity_Saved_Popup);
			String Act_Popup_Save=getText(driver, popup_Message);
			
			if(Act_Popup_Save.equals(Activity_Saved_Popup)) {
				System.out.println("Popup Matched ||  Expected : "+Activity_Saved_Popup +" ||  Actual : "+Act_Popup_Save);
				Extent_pass_New(driver, "Popup Matched ||  Expected : "+Activity_Saved_Popup +" ||  Actual : "+Act_Popup_Save, test, test1);
			}else {
				System.out.println("Popup Not Matched ||  Expected : "+Activity_Saved_Popup +" ||  Actual : "+Act_Popup_Save);
				Extent_fail(driver, "Popup Not Matched ||  Expected : "+Activity_Saved_Popup +" ||  Actual : "+Act_Popup_Save, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			Step_End(2, "Enter the Activity code with the required alphabets and give the required activity description and select the activity type as Sub and contract type as CTL and click the add option and next click the save option in the toolbar.", test, test1);
		}
		
		Step_Start(3, "Next enter the screen name as 'Global activity mapping' in the module search field.", test, test1);
	
		moduleNavigate(driver, gam_module);
		
		newButton(driver);
		Step_End(3, "Next enter the screen name as 'Global activity mapping' in the module search field.", test, test1);

		Step_Start(4, "Click the global search option and enter the contract code as CTL and check the system retrieves and then click on the edit option.", test, test1);

		waitForElement(driver, contract_type_search_icon_Gam);
		click(driver, contract_type_search_icon_Gam);
		twoColumnSearchWindow(driver, contract_code_header, condition, contract_type_data);
		
		waitForElement(driver, show_button_Gam_Mod);
		click(driver, show_button_Gam_Mod);
		
		waitForPopup(driver, popup_Message, Activities_Mapped_popup);
		String ActivityMap_Popup_Act=getText(driver, popup_Message);
		
		if(ActivityMap_Popup_Act.equals(Activities_Mapped_popup)) {
			System.out.println("Popup Matched ||  Expected : "+Activities_Mapped_popup +" ||  Actual : "+ActivityMap_Popup_Act);
			Extent_pass_New(driver, "Popup Matched ||  Expected : "+Activities_Mapped_popup +" ||  Actual : "+ActivityMap_Popup_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched ||  Expected : "+Activities_Mapped_popup +" ||  Actual : "+ActivityMap_Popup_Act);
			Extent_fail(driver, "Popup Not Matched ||  Expected : "+Activities_Mapped_popup +" ||  Actual : "+ActivityMap_Popup_Act, test, test1);
		}
		
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_End(4, "Click the global search option and enter the contract code as CTL and check the system retrieves and then click on the edit option.", test, test1);

		Step_Start(5, "Select the required main-activity and then select the required newly added sub-activities and click on the Add option. Click the save option in the toolbar. Ensure that system validates as 'Global Activity Updated'. Click on the ok option.", test, test1);
	
		
		List<String> Main_Activities_GAM=splitAndExpand(main_activity_data);
		List<String> ParentActivities_GAM=splitAndExpandNew(Parent_Activity_Code_GAM,"|");
		List<String> Sub_Activities_Main_GAM=splitAndExpandNew(Sub_Activity_Code_GAM,"|");
		
		Map<String,List<String>>  Parent_Sub_Activities_GAM=new HashMap<String, List<String>>();
		for(int i=0;i<Main_Activities_GAM.size();i++) {
			String ActivityName=Main_Activities_GAM.get(i);
			List<String> SubAct=splitAndExpand(Sub_Activities_Main_GAM.get(i));
			Parent_Sub_Activities_GAM.put(ActivityName, SubAct);
		}
		
		for(int m=0;m<Main_Activities_GAM.size();m++) {
			
			waitForElement(driver, ActivityName_Filter_Input_GAM);
			Newclear(driver, ActivityName_Filter_Input_GAM);
			sendKeys(driver, ActivityName_Filter_Input_GAM, "-"+Main_Activities_GAM.get(m));
			actions.sendKeys(Keys.BACK_SPACE).build().perform();
			
			String Parent_Act=ParentActivities_GAM.get(m);
			if(!Parent_Act.trim().equals("")) {
				waitForElement(driver, act_code_textfield);
				Newclear(driver, act_code_textfield);
				sendKeys(driver, act_code_textfield, Parent_Act);
				
				waitForElement(driver, subActivity_Table_Row_GAM);
				click(driver, subActivity_Table_Row_GAM);
				
				String main_activity_data_checkbox = String.format(main_activity_to_map, Main_Activities_GAM.get(m));
				waitForElement(driver, main_activity_data_checkbox);
				click(driver, main_activity_data_checkbox);
				
				waitForElement(driver, plus_icon_Gam);
				safeclick(driver, plus_icon_Gam);
				
				waitForElement(driver, main_activity_data_checkbox);
				click(driver, main_activity_data_checkbox);
				
				waitForElement(driver, ActivityName_Filter_Input_GAM);
				Newclear(driver, ActivityName_Filter_Input_GAM);
				sendKeys(driver, ActivityName_Filter_Input_GAM, "-"+Parent_Act);
				actions.sendKeys(Keys.BACK_SPACE).build().perform();
				
				String Parent_CheckBox_GAM=String.format(Parent_Activity_Checkbox_GAM,Main_Activities_GAM.get(m),Parent_Act);
				waitForElement(driver, Parent_CheckBox_GAM);
				click(driver,Parent_CheckBox_GAM);
			}else {
				String main_activity_data_checkbox = String.format(main_activity_to_map, Main_Activities_GAM.get(m));
				waitForElement(driver, main_activity_data_checkbox);
				click(driver, main_activity_data_checkbox);
			}
			
			List<String> SubActivities_List=Parent_Sub_Activities_GAM.get(Main_Activities_GAM.get(m));
			for(int s=0;s<SubActivities_List.size();s++) {
				waitForElement(driver, act_code_textfield);
				Newclear(driver, act_code_textfield);
				sendKeys(driver, act_code_textfield, SubActivities_List.get(s));
				
				waitForElement(driver, subActivity_Table_Row_GAM);
				click(driver, subActivity_Table_Row_GAM);
				
				waitForElement(driver, plus_icon_Gam);
				safeclick(driver, plus_icon_Gam);
			}
			
			if(!Parent_Act.trim().equals("")) {
				waitForElement(driver, ActivityName_Filter_Input_GAM);
				Newclear(driver, ActivityName_Filter_Input_GAM);
				sendKeys(driver, ActivityName_Filter_Input_GAM, "-"+Parent_Act+"-");
				actions.sendKeys(Keys.BACK_SPACE).build().perform();
				
				String Parent_CheckBox_GAM=String.format(Parent_Activity_Checkbox_GAM,Main_Activities_GAM.get(m),Parent_Act);
				waitForElement(driver, Parent_CheckBox_GAM);
				click(driver,Parent_CheckBox_GAM);
			}else {
				
				waitForElement(driver, ActivityName_Filter_Input_GAM);
				Newclear(driver, ActivityName_Filter_Input_GAM);
				sendKeys(driver, ActivityName_Filter_Input_GAM, "-"+Main_Activities_GAM.get(m));
				actions.sendKeys(Keys.BACK_SPACE).build().perform();
				
				String main_activity_data_checkbox = String.format(main_activity_to_map, Main_Activities_GAM.get(m));
				waitForElement(driver, main_activity_data_checkbox);
				click(driver, main_activity_data_checkbox);
			}
		}
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, global_updated_msg);
		String global_updated_msg_actual = getText(driver, popup_Message).trim();
		
		if(global_updated_msg_actual.equals(global_updated_msg.trim())) {
			System.out.println("Matched || Expected popup ->"+global_updated_msg+"||actual popup ->"+global_updated_msg_actual);
			Extent_pass_New(driver, "Matched || Expected popup ->"+global_updated_msg+"||actual popup ->"+global_updated_msg_actual, test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Matched || Expected popup ->"+global_updated_msg+"||actual popup ->"+global_updated_msg_actual);
			Extent_fail(driver, "Matched || Expected popup ->"+global_updated_msg+"||actual popup ->"+global_updated_msg_actual, test, test1);
		}
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		Step_End(5, "Select the required main-activity and then select the required newly added sub-activities and click on the Add option. Click the save option in the toolbar. Ensure that system validates as 'Global Activity Updated'. Click on the ok option.", test, test1);

		Step_Start(6, "Next enter the screen name as 'Vendor contracts' in the module search field. Select the contract type as CTL.", test, test1);
	
		// Vendor Contracts
		moduleNavigate(driver, vendor_contract_module);
		
		waitForElement(driver, search_icon_contract_type_Vc);
		click(driver, search_icon_contract_type_Vc);
		twoColumnSearchWindow(driver, contract_code_header, condition, contract_type_data);

		Step_End(6, "Next enter the screen name as 'Vendor contracts' in the module search field. Select the contract type as CTL.", test, test1);

		Step_Start(7, "Enter the required vendor code, valid from, valid to, currency and click the show option.", test, test1);
	
		waitForElement(driver, vendor_code_search_icon_Vc);
		click(driver, vendor_code_search_icon_Vc);
		twoColumnSearchWindow(driver, vendor_code_header, condition, vendor_code_data_Vc);
		
		if(datepicker.equalsIgnoreCase("yes")) {
			waitForElement(driver, valid_from_date_Vc);
			selectDatePicker(driver, valid_from_date_Vc, from_date_Vc);
		}
		
		if(datepicker.equalsIgnoreCase("yes")) {
			waitForElement(driver, valid_To_date_Vc);
			selectDatePicker(driver, valid_To_date_Vc, To_date_Vc);
		}

		waitForElement(driver, currency_search_icon_vc);
		click(driver, currency_search_icon_vc);
		twoColumnSearchWindow(driver, currency_code_header, condition, Currency_Value_VC);
		waitForElement(driver, show_btn_vc);
		click(driver, show_btn_vc);
		
		Step_End(7, "Enter the required vendor code, valid from, valid to, currency and click the show option.", test, test1);

		Step_Start(8, "System will pop up a confirmation message as 'Do you want to get activities from predictable activity behavior?' and click on No.", test, test1);
	
		waitForElement(driver, popup_Message_No_Button);
		click(driver, popup_Message_No_Button);
		
		Step_End(8, "System will pop up a confirmation message as 'Do you want to get activities from predictable activity behavior?' and click on No.", test, test1);

		Step_Start(9, "System will add the main activities in the AG grid.", test, test1);
		Step_Start(10, "Select the required main activity and right click on it and select the Remove_Btn_CAR selected items option and click on Yes.", test, test1);

		waitForElement(driver, vc_rows);
		
		List<WebElement>  Actvities_List1=listOfElements(driver, vc_rows);
		while(Actvities_List1.size()>Main_Activities_GAM.size()) {			
			actions.keyDown(Keys.CONTROL).build().perform();
			for(WebElement Ele:Actvities_List1) {
				String ActivityName=Ele.getText();
				boolean actRemove=true;
				for(String activity:Main_Activities_GAM) {
					if(activity.equals(ActivityName)) {
						actRemove=false;
					}
				}
				
				if(actRemove) {
					actions.moveToElement(Ele).build().perform();
					Ele.click();
				}
			}
			actions.keyUp(Keys.CONTROL).build().perform();
			actions.contextClick().perform();
			waitForElement(driver, remove_Option_Vc);
			click(driver, remove_Option_Vc);
			
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			
			waitForElement(driver, vc_rows);
			Actvities_List1=listOfElements(driver, vc_rows);
		}
        
		Step_End(9, "System will add the main activities in the AG grid.", test, test1);
		Step_End(10, "Select the required main activity and right click on it and select the Remove_Btn_CAR selected items option and click on Yes.", test, test1);

		Step_Start(11, "Then select the required main activity and click on the Edit input fields option and select the required charge type, equipment type, equipment status, currency and send to disbursement.", test, test1);
		
		waitForElement(driver, edit_input_field_Vc);
		click(driver, edit_input_field_Vc);
		
		List<String>  ChargeTypes_List=splitAndExpand(Select_ChargeType);
		List<String>  EqpTypes_List=splitAndExpand(Select_Eqp_Type);
		List<String>  EqpStatus_List=splitAndExpand(Select_Eqp_Status);
		List<String>  EqpCurrency_List=splitAndExpand(Select_Eqp_Currency);
		List<String>  Disbursment_List=splitAndExpand(Select_Disbursement);
		List<String>  Formula_Values_List=splitAndExpand(Formula_Values);

		for(int i=0;i<Main_Activities_GAM.size();i++) {
			
			waitForElement(driver, edit_input_field_Vc);
			if(!isdisplayed(driver, equip_type_dd_label_Vc)) {
				click(driver, edit_input_field_Vc);
			}
			formatLocatorClick(driver, Select_Activity_VC, Main_Activities_GAM.get(i));
			
			waitForElement(driver, ChargeType_Input_VC);
			click(driver,ChargeType_Input_VC);
			formatLocatorClick(driver, Select_ChargeTypeOption, ChargeTypes_List.get(i));
			elementnotvisible1(driver, Popup_Message);
			
			waitForElement(driver, equip_type_dd_label_Vc);
			jsClick(driver,equip_type_dd_label_Vc);
			formatLocatorClick(driver, equip_type_options_Vc, EqpTypes_List.get(i));
			elementnotvisible1(driver, Popup_Message);
			
			waitForElement(driver, eqp_sts_label_vc);
			jsClick(driver,eqp_sts_label_vc);
			formatLocatorClick(driver, equip_sts_Vc_option, EqpStatus_List.get(i));
			elementnotvisible1(driver, Popup_Message);
			
			waitForElement(driver, currency_dd_Vc);
			jsClick(driver,currency_dd_Vc);
			formatLocatorClick(driver, currency_dd_options, EqpCurrency_List.get(i));
			elementnotvisible1(driver, Popup_Message);
				
			waitForElement(driver, Disbursement_Input_VC);
			click(driver,Disbursement_Input_VC);
			formatLocatorClick(driver, Select_Disbursement_option_VC, Disbursment_List.get(i));
			
			formatRightClick(driver, Select_Activity_VC, Main_Activities_GAM.get(i));
			waitForElement(driver, Add_item_PAB);
			click(driver,Add_item_PAB);
			
			String Parent_Act=ParentActivities_GAM.get(i);
			if(!Parent_Act.trim().equals("")) {
				
				twoColumnSearchWindow(driver, Activitity_Add_Header, condition, Parent_Act);

				waitForElement(driver, Columns_AG_Grid_VC);
				reArrangeAG_GridColumnsNew(driver, Columns_AG_Grid_VC, Table_Headers_Filter_AG_Grid);
				
				formatLocatorClick(driver, Activity_Code_Column_VC, Parent_Act);
				formatRightClick(driver, Activity_Code_Column_VC, Parent_Act);
				
				waitForElement(driver, Add_item_PAB);
				click(driver,Add_item_PAB);
				
			}
			
			List<String> Activities_List=Parent_Sub_Activities_GAM.get(Main_Activities_GAM.get(i));
			waitForElement(driver, Activity_Select_Window);
			for(String Activity:Activities_List) {
				formatLocatorClick(driver, Select_Activities_VC, Activity);
			}
			
			waitForElement(driver, select_Button);
			click(driver, select_Button);
			
			if(ChargeTypes_List.get(i).equals("Sub to Formula")) {
				waitForElement(driver, Columns_AG_Grid_VC);
				reArrangeAG_GridColumnsNew(driver, Columns_AG_Grid_VC, Table_Headers_Filter_AG_Grid);
				
				for(String actSub:Activities_List) {
					formatLocatorClick(driver, Activity_Code_Column_VC, actSub);
				}
				
				waitForElement(driver, edit_input_field_Vc);
				if(!isdisplayed(driver, equip_type_dd_label_Vc)) {
					click(driver, edit_input_field_Vc);
				}
				waitForElement(driver, ChargeType_Input_VC);
				click(driver,ChargeType_Input_VC);
				formatLocatorClick(driver, Select_ChargeTypeOption, ChargeTypes_List.get(i));
				elementnotvisible1(driver, Popup_Message);
				
				waitForElement(driver, Formula_builder_btn_VC);
				click(driver,Formula_builder_btn_VC);
				
				waitForElement(driver, Formula_Bulder_Window_VC);
				
				waitForElement(driver, Formula_Input_FormulaBuilder_VC);
				sendKeys(driver, Formula_Input_FormulaBuilder_VC, Formula_Values_List.get(i));
				
				waitForElement(driver, Formula_Ok_Btn_VC);
				click(driver,Formula_Ok_Btn_VC);
			}
		}
		
		Step_End(11, "Then select the required main activity and click on the Edit input fields option and select the required charge type, equipment type, equipment status, currency and send to disbursement.", test, test1);

		Step_Start(12, "Right click on it and add the required activities and enter the amount for that activity.", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Vendor_Contract_Saved_popup);
		String contractSaved_popupAct=getText(driver, popup_Message);
		if(Vendor_Contract_Saved_popup.equalsIgnoreCase(contractSaved_popupAct)) {
			System.out.println("Popup Matched || Expected : "+Vendor_Contract_Saved_popup+"  || Actual : "+contractSaved_popupAct);
			Extent_pass_New(driver, "Popup Matched || Expected : "+Vendor_Contract_Saved_popup+"  || Actual : "+contractSaved_popupAct, test, test1);
		}else {
			System.out.println("Popup Not Matched || Expected : "+Vendor_Contract_Saved_popup+"  || Actual : "+contractSaved_popupAct);
			Extent_fail(driver, "Popup Not Matched || Expected : "+Vendor_Contract_Saved_popup+"  || Actual : "+contractSaved_popupAct, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		waitForElement(driver, contract_No_VC);
		String actual_Vendor_No=getAttribute(driver, contract_No_VC, "value");
		System.out.println("actual_Vendor_No : "+actual_Vendor_No);
		Extent_pass_New(driver, "actual_Vendor_No : "+actual_Vendor_No, test, test1);

		waitForElement(driver, accept_Button_VC);
		click(driver, accept_Button_VC);
		
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		
		//  Contract Mapping
		waitForElement(driver, port_Plus_Button_CM);
		click(driver, port_Plus_Button_CM);
		
		twoColumnSearchWindow(driver, port_code_header, condition, Port_Code);
		
		String select_Checkbox=String.format(terminal_Select_Checkbox_CM, Terminal_Code);
		boolean terminalPresent=true;
		while(terminalPresent) {
			if(isdisplayed(driver, select_Checkbox)) {
				waitForElement(driver, select_Checkbox);
				click(driver, select_Checkbox);
				terminalPresent=false;
			}else if(IsElementEnabled(driver, Port_Code_Next_Button_CM)){
				waitForElement(driver, Port_Code_Next_Button_CM);
				click(driver,Port_Code_Next_Button_CM);
			}else {
				System.out.println("Expected : '"+Terminal_Code+"' should be present || Actual : '"+Terminal_Code+"' is not present");
				Extent_fail(driver, "Expected : '"+Terminal_Code+"' should be present || Actual : '"+Terminal_Code+"' is not present", test, test1);
			}
		}
		
		waitForElement(driver, terminal_Select_Ok_Button_CM);
		click(driver, terminal_Select_Ok_Button_CM);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message,mappingSavedPopup);
		String actual_Popup_CM=getText(driver, popup_Message);
		if(actual_Popup_CM.equals(mappingSavedPopup)) {
			System.out.println("Matched || Expected Popup : "+mappingSavedPopup+" || Actual Popup : "+actual_Popup_CM);
			Extent_pass_New(driver, "Matched || Expected Popup : "+mappingSavedPopup+" || Actual Popup : "+actual_Popup_CM, test, test1);
			click(driver, popup_Message_Ok_Button);
		}
		else {
			System.out.println("Not Matched || Expected Popup : "+mappingSavedPopup+" || Actual Popup : "+actual_Popup_CM);
			Extent_fail(driver, "Not Matched || Expected Popup : "+mappingSavedPopup+" || Actual Popup : "+actual_Popup_CM, test, test1);
		}
		
		waitForElement(driver, Port_Mapping_ID_Textfield_CM);
		String port_Mapping_ID=getAttribute(driver, Port_Mapping_ID_Textfield_CM, "value");
		System.out.println("port_Mapping_ID : "+port_Mapping_ID);
		Extent_pass_New(driver, "port_Mapping_ID : "+port_Mapping_ID, test, test1);
		
		SwitchProfile(driver, AgencyUser);
		
		//	CAR
		moduleNavigate(driver, Cost_Activity_Report_Module);
		
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		Step_Start(3, "Select the required contract type as \"PTC\" by using Contract type dropdown", test, test1);

		waitForElement(driver, Contract_Type_Input_CAR);
		click(driver,Contract_Type_Input_CAR);
		
		formatLocatorClick(driver, Select_Contract_Type_CAR, contract_type_data);
		
		Step_End(3, "Select the required contract type as \"PTC\" by using Contract type dropdown", test, test1);
		Step_Start(4, "Select the required \"Mode\" by using Mode dropdown.", test, test1);

		waitForElement(driver, Mode_Select_Input_CAR);
		click(driver,Mode_Select_Input_CAR);
		
		formatLocatorClick(driver, Select_Mode_type_CAR, Select_Mode_type);

		Step_End(4, "Select the required \"Mode\" by using Mode dropdown.", test, test1);
		Step_Start(5, "Click on the Service search button and select the required service code.", test, test1);

		waitForElement(driver, Service_Search_Btn_CAR);
		click(driver,Service_Search_Btn_CAR);
		twoColumnSearchWindow(driver, service_header, condition, Service_Code);

		Step_End(5, "Click on the Service search button and select the required service code.", test, test1);
		Step_Start(6, "Click on the Vessel search button and select the required vessel code.", test, test1);

		waitForElement(driver, Vessel_Search_Btn_CAR);
		click(driver,Vessel_Search_Btn_CAR);
		twoColumnSearchWindow(driver, vessel_code_header, condition, Vessel_Code);
		Step_End(6, "Click on the Vessel search button and select the required vessel code.", test, test1);
		Step_Start(7, "Click on the Port search button and select the required port code.", test, test1);

		waitForElement(driver, Port_Search_Btn_CAR);
		click(driver,Port_Search_Btn_CAR);
		twoColumnSearchWindow(driver, port_code_header, condition, Port_Code);
		Step_End(7, "Click on the Port search button and select the required port code.", test, test1);
		Step_Start(8, "Click on the Terminal search button and select the required terminal code.", test, test1);

		waitForElement(driver, Terminal_Search_Btn_CAR);
		click(driver,Terminal_Search_Btn_CAR);
		twoColumnSearchWindow(driver, terminal_code_header, condition, Terminal_Code);
		Step_End(8, "Click on the Terminal search button and select the required terminal code.", test, test1);
		Step_Start(9, "Click on the Arrival date search button and select the required date.", test, test1);

		waitForElement(driver, Arrival_Date_Search_Btn_CAR);
		click(driver,Arrival_Date_Search_Btn_CAR);
		twoColumnSearchWindow(driver, arrival_date_header, Arrival_Date_Condition, Arrival_Date_Value);
		
		Step_End(9, "Click on the Arrival date search button and select the required date.", test, test1);
		
		Step_Start(10, "Click on the Show button.", test, test1);
		
		waitForElement(driver, Show_Button_CAR);
		click(driver,Show_Button_CAR);
		
		waitForElement(driver, Arrival_Date_Input_CAR);
		String actual_Arr_Date=getAttribute(driver, Arrival_Date_Input_CAR, "value");
		System.out.println("actual_Arr_Date : "+actual_Arr_Date);
		
		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver,UnPredictable_Tab_CAR);
		
		waitForElement(driver, More_Grid_UnPredictable_CAR);
		click(driver,More_Grid_UnPredictable_CAR);
		
		waitForElement(driver, Condition_UnPredictable_CAR);
		click(driver,Condition_UnPredictable_CAR);
		
		waitForDisplay(driver, UnPredictable_Table_CAR);
		waitForElement(driver, Column_SelectMenu);
		click(driver, Column_SelectMenu);
		waitForElement(driver, column_SearchBox_CAR);
		jsClick(driver, UnPredictable_All_Checkbox_CAR);
		
		List<String> Unpredictable_Headers=splitAndExpand(Un_Predictable_Table_Filter_Headers);
		for(String FilterHeader : Unpredictable_Headers) {
			waitForElement(driver, column_SearchBox_CAR);
			clear(driver, column_SearchBox_CAR);
			waitForElement(driver, column_SearchBox_CAR);
			sendKeys(driver, column_SearchBox_CAR,FilterHeader);
		
			String checkbox=String.format(Select_Column_CAR,FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}
		
		jsClick(driver, Column_SelectMenu);
		
		for(int i=0;i<Main_Activities_GAM.size();i++) {
			String Main_Activity=Main_Activities_GAM.get(i);
			waitForElement(driver, Main_Act_Filter_Input_UnPre_CAR);
			Newclear(driver, Main_Act_Filter_Input_UnPre_CAR);
			sendKeys(driver, Main_Act_Filter_Input_UnPre_CAR, Main_Activity);
			
			List<String> Activities_List=Parent_Sub_Activities_GAM.get(Main_Activities_GAM.get(i));
			for(String subAct:Activities_List) {
				waitForElement(driver, activity_Code_Filter_CAR);
				Newclear(driver, activity_Code_Filter_CAR);
				sendKeys(driver, activity_Code_Filter_CAR, subAct);
				
				waitForDisplay(driver, Main_Act_Filter_Input_UnPre_CAR);
				if(isdisplayed(driver, UnPredictable_Grid_Cell_CAR)) {
					System.out.println("Expected : Newly added Sub Activity '"+subAct+"' should be added under the Main Activity '"+Main_Activity+"' ||  Actual : Newly added Sub Activity '"+subAct+"' is successfully added under the Main Activity "+Main_Activity);
					Extent_pass_New(driver, "Expected : Newly added Sub Activity '"+subAct+"' should be added under the Main Activity '"+Main_Activity+"' ||  Actual : Newly added Sub Activity '"+subAct+"' is successfully added under the Main Activity "+Main_Activity, test, test1);
				}else {
					System.out.println("Expected : Newly added Sub Activity '"+subAct+"' should be added under the Main Activity '"+Main_Activity+"' ||  Actual : Newly added Sub Activity '"+subAct+"' is not added under the Main Activity "+Main_Activity);
					Extent_fail(driver, "Expected : Newly added Sub Activity '"+subAct+"' should be added under the Main Activity '"+Main_Activity+"' ||  Actual : Newly added Sub Activity '"+subAct+"' is not added under the Main Activity "+Main_Activity, test, test1);
				}
				String mainAct=String.format(Select_main_Activity_CAR, Main_Activity);
				waitForDisplay(driver, mainAct);
				jsClick(driver, mainAct);
			}			
		}
	
		if(Predictable_Activity_Need_To_Add.equalsIgnoreCase("Yes")) {
			
			waitForElement(driver, Contracts_Used_Btn_CAR);
			click(driver,Contracts_Used_Btn_CAR);

			waitForElement(driver, Contracts_Details_tab_CAR);
			waitForElement(driver, Activity_Behaviour_ID_CAR);
			String Activity_ID_Full=getText(driver, Activity_Behaviour_ID_CAR);
			
			List<String>  Activity_ID_Split=splitAndExpand(Activity_ID_Full, ":");
			String template_No=Activity_ID_Split.get(1);
			waitForElement(driver, Contract_Details_Ok_Btn_CAR);
			click(driver,Contract_Details_Ok_Btn_CAR);
			
			//Predictable Activity Behaviour
			Step_Start(17, "If the newly added activity needs to be mapped in the Predictable reporting tab, enter the screen name as 'Predictable activity behaviour' in the module search field.", test, test1);

			moduleNavigate(driver, Predictable_Activity_Module);

			Step_End(17, "If the newly added activity needs to be mapped in the Predictable reporting tab, enter the screen name as 'Predictable activity behaviour' in the module search field.", test, test1);

			Step_Start(18, "Click on the global search option and enter the required fields and click the search option. Next select the required details and click on the select option.", test, test1);

			if(!template_No.trim().equals("")) {
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, Predictable_Select_Codition, Predictable_Select_Type, template_No, "", "", "", "");
			
				Step_Start(19, "Click on the edit option in the toolbar and map the required newly sub-activities under the mapped main-activity.", test, test1);
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
				Step_End(19, "Click on the edit option in the toolbar and map the required newly sub-activities under the mapped main-activity.", test, test1);

			}else {
				waitForElement(driver, contract_Type_Dropdown_PAB);
				click(driver,contract_Type_Dropdown_PAB);
				
				String SelectContract_PAB=String.format(DropDown_Select, contract_type_data);
				waitForElement(driver, SelectContract_PAB);
				click(driver,SelectContract_PAB);
						
				waitForElement(driver, fromDate_PAB);
				click(driver,fromDate_PAB);
				
				selectDatePicker(driver, fromDate_PAB, from_date_Vc);
				
				waitForElement(driver, toDate_PAB);
				click(driver,toDate_PAB);
				
				selectDatePicker(driver, toDate_PAB, To_date_Vc);
				
				waitForElement(driver, port_SearchButton_PAB);
				click(driver,port_SearchButton_PAB);
				twoColumnSearchWindow(driver, port_code_header, condition, Port_Code);
				
				
				waitForElement(driver, terminal_SearchButton_PAB);
				click(driver,terminal_SearchButton_PAB);
				twoColumnSearchWindow(driver, terminal_code_header, condition, Terminal_Code);
		
				waitForElement(driver, show_Button_PAB);
				click(driver,show_Button_PAB);
				
			}
			
			Step_End(18, "Click on the global search option and enter the required fields and click the search option. Next select the required details and click on the select option.", test, test1);

			for(int p=0;p<Main_Activities_GAM.size();p++) {
				
				String Main_Act_Name=Main_Activities_GAM.get(p);
				String MainActivity_Name_Column=String.format(Activity_Name_PAB, Main_Act_Name);
				waitForDisplay(driver, MainActivity_Name_Column);
				if(!isdisplayed(driver, MainActivity_Name_Column)) {
					waitForElement(driver, Predictable_Activity_Table_Column);
					click(driver,Predictable_Activity_Table_Column);
					RightClick(driver, Predictable_Activity_Table_Column);
					
					waitForElement(driver, Add_Main_Item_PAB);
					click(driver,Add_Main_Item_PAB);
					twoColumnSearchWindow(driver, Predictable_MainActivity_Header, condition, Main_Act_Name);
				}
				
				String Parent_Act=ParentActivities_GAM.get(p);
				String Activity_Column=String.format(Activity_Name_PAB, Main_Act_Name);
				waitForElement(driver, Activity_Column);
				click(driver,Activity_Column);
				RightClick(driver, Activity_Column);
				waitForElement(driver, Add_item_PAB);
				click(driver,Add_item_PAB);
				if(!Parent_Act.trim().equals("")) {
					twoColumnSearchWindow(driver,Predictable_SubActivity_Header,condition,Parent_Act);
					String Parent_Column=String.format(Activity_Column_PAB, Parent_Act);
					waitForElement(driver, Parent_Column);
					click(driver,Parent_Column);
					RightClick(driver, Parent_Column);
					
					waitForElement(driver, Add_item_PAB);
					click(driver,Add_item_PAB);
					twoColumnSearchWindowMultipleValue(driver, Predictable_SubActivity_Header, condition, Sub_Activities_Main_GAM.get(p));
				}else {
					twoColumnSearchWindowMultipleValue(driver, Predictable_SubActivity_Header, condition, Sub_Activities_Main_GAM.get(p));
				}
			}
			
			Step_Start(20, "Click on the save option in the toolbar. System validates as 'Predictable activity behaviour updated'.", test, test1);
		
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
		    
			waitForPopup(driver, popup_Message, Popup_Text_Exp);
			String PopupText_Act=getText(driver, popup_Message);
			
			if(PopupText_Act.equals(Popup_Text_Exp)) {
				System.out.println("Popup Matched  ||   Expected : "+Popup_Text_Exp+"   ||   Actual   : "+PopupText_Act);
				Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Popup_Text_Exp+"   ||   Actual   : "+PopupText_Act, test, test1);
			}else if(PopupText_Act.contains("saved")||PopupText_Act.contains("Saved")) {
				System.out.println("Popup Matched  ||   Expected : Predictable Activity Behavior Saved   ||   Actual   : "+PopupText_Act);
				Extent_pass_New(driver, "Popup Matched  ||   Expected : Predictable Activity Behavior Saved   ||   Actual   : "+PopupText_Act, test, test1);
			}else {
				System.out.println("Popup Not Matched  ||   Expected : "+Popup_Text_Exp+"   ||   Actual   : "+PopupText_Act);
				Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Popup_Text_Exp+"   ||   Actual   : "+PopupText_Act, test, test1);
			}
			Step_End(20, "Click on the save option in the toolbar. System validates as 'Predictable activity behaviour updated'.", test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);

			Step_Start(21, "Go to the CAR screen and click on the refresh option.", test, test1);

			waitForElement(driver, CAR_Module);
			click(driver,CAR_Module);
			
			waitForElement(driver, Refresh_Button_CAR);
			click(driver,Refresh_Button_CAR);
			
			Step_End(21, "Go to the CAR screen and click on the refresh option.", test, test1);
			
			
			Step_Start(22, "Ensure that the mapped sub-activities are shown under the predictable reporting tab.", test, test1);

			waitForElement(driver, Predictable_Reporting_CAR);
			click(driver,Predictable_Reporting_CAR);
			
			waitForElement(driver, Predicatble_More_Grid_CAR);
			click(driver,Predicatble_More_Grid_CAR);
			
			waitForElement(driver, Predicatble_ConditionFilter_CAR);
			click(driver,Predicatble_ConditionFilter_CAR);
			
			reArrangeAG_GridColumns(driver, columnHeaders_predictable);

			for(int i=0;i<Main_Activities_GAM.size();i++) {
				String Main_Activity=Main_Activities_GAM.get(i);
				
				waitForElement(driver, Main_Activity_Filter_Input_CAR);
				Newclear(driver, Main_Activity_Filter_Input_CAR);
				sendKeys(driver, Main_Activity_Filter_Input_CAR, Main_Activity);
				
				List<String> Activities_List=Parent_Sub_Activities_GAM.get(Main_Activities_GAM.get(i));
				for(String subAct:Activities_List) {
					
					waitForElement(driver, Sub_Activity_Filter_Input_CAR);
					Newclear(driver, Sub_Activity_Filter_Input_CAR);
					sendKeys(driver, Sub_Activity_Filter_Input_CAR, subAct);
					
					waitForDisplay(driver, Main_Activity_Filter_Input_CAR);
					if(isdisplayed(driver, Predictable_Grid_Cell_CAR)) {
						System.out.println("Expected : Newly added Sub Activity '"+subAct+"' should be added under the Main Activity '"+Main_Activity+"' in the Predictable Tab ||  Actual : Newly added Sub Activity '"+subAct+"' is successfully added under the Main Activity "+Main_Activity+" in the Predictable Tab");
						Extent_pass_New(driver, "Expected : Newly added Sub Activity '"+subAct+"' should be added under the Main Activity '"+Main_Activity+"' in the Predictable Tab ||  Actual : Newly added Sub Activity '"+subAct+"' is successfully added under the Main Activity "+Main_Activity+" in the Predictable Tab", test, test1);
					}else {
						System.out.println("Expected : Newly added Sub Activity '"+subAct+"' should be added under the Main Activity '"+Main_Activity+"' in the Predictable Tab ||  Actual : Newly added Sub Activity '"+subAct+"' is not added under the Main Activity "+Main_Activity+" in the Predictable Tab");
						Extent_fail(driver, "Expected : Newly added Sub Activity '"+subAct+"' should be added under the Main Activity '"+Main_Activity+"' in the Predictable Tab ||  Actual : Newly added Sub Activity '"+subAct+"' is not added under the Main Activity "+Main_Activity+" in the Predictable Tab", test, test1);
					}
					formatLocatorClick(driver, Main_Activity_Column_CAR, Main_Activity);
				}
			}
			Step_End(22, "Ensure that the mapped sub-activities are shown under the predictable reporting tab.", test, test1);
		}
		
		Step_Start(23, "Click the save option in the toolbar and system validates as 'Container report activity saved'. Click the ok option.", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);

		waitForDisplay(driver, Ok_Message_Button_CAR);
		if(isdisplayed(driver, Ok_Message_Button_CAR)) {
			click(driver, Ok_Message_Button_CAR);
		}
		waitForPopup(driver, popup_Message, CAR_Saved_Poupup);
		String actualSavedPopup=getText(driver, popup_Message);

		if(CAR_Saved_Poupup.equals(actualSavedPopup)) {
			System.out.println("Popup Matched  ||   Expected : "+CAR_Saved_Poupup+"   ||   Actual   : "+actualSavedPopup);
			Extent_pass_New(driver, "Popup Matched  ||   Expected : "+CAR_Saved_Poupup+"   ||   Actual   : "+actualSavedPopup, test, test1);
			click(driver, popup_Message_Ok_Button);

		}else {
			System.out.println("Popup Not Matched  ||   Expected : "+CAR_Saved_Poupup+"   ||   Actual   : "+actualSavedPopup);
			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+CAR_Saved_Poupup+"   ||   Actual   : "+actualSavedPopup, test, test1);
		}
		Step_End(23, "Click the save option in the toolbar and system validates as 'Container report activity saved'. Click the ok option.", test, test1);

		Extent_completed(tc_Name, test, test1);
	
	}
}
