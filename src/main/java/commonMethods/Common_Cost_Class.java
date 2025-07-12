package commonMethods;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import locators.Rate_Request_Loactors;

public class Common_Cost_Class extends Keywords {
	String From_Location_External = "";
	String To_Location_External = "";
	String From_Terminal_External = "";
	String Service_External = "";
	String To_Terminal_External = "";
public void EquipmentData(WebDriver driver, String input, ExtentTest test, ExtentTest test1,
		String selected_dataset,String ContainerTypes) {


	Map<String, String> Data = Utils.GetAllData("Common_Data", "Common_Cost_Datas", "Dataset" + selected_dataset,"TestData_Commercial");
	String condition = Data.get("condition");
	String datePicker = Data.get("datePicker");
	String Start_Date = Data.get("Start_Date");
	String End_Date = Data.get("End_Date");
	String Fec_module = Data.get("Fec_module");
	String Ac_module = Data.get("Ac_module");
	String External_Feeder_Cost_Module = Data.get("External_Feeder_Cost_Module");
	String transshipmentCost_Module = Data.get("TranshipmentCost_Module");
	String equipment_Operation_cost_Origin_Module = Data.get("equipment_Operation_cost_Origin_Module");
	String Condition_filter_C = Data.get("Condition_filter_C");
	String amount_C = Data.get("amount_C");
	String amount_Type_C = Data.get("amount_Type_C");
	String cost_Origin_Saved_Popup_C = Data.get("cost_Origin_Saved_Popup_C");
	String dischargeCost_Module = Data.get("DischargeCost_Module");
	String container_Type_DSC = ContainerTypes;
	String local_Amount_DSC = Data.get("Local_Amount_DSC");
	String in_Transist_Checkbox_DSC = Data.get("In_Transist_Checkbox_DSC");
	String port_Code_DSC = Data.get("Port_Code_DSC");
	String activity_Type_Conditional_Behaviour_DSC = Data.get("Activity_Type_Conditional_Behaviour_DSC");
	String local_Amount_Conditional_Behaviour_DSC = Data.get("Local_Amount_Conditional_Behaviour_DSC");
	String activity_Type_DSC = Data.get("Activity_Type_DSC");
	String currency_data_Ac = Data.get("currency_data_Ac");
	String radio_btn_data_Ac = Data.get("radio_btn_data_Ac");
	String soc_flag_Ac = Data.get("soc_flag_Ac");
	String container_type_data_Ac =ContainerTypes;
	String bl_type_data_Ac = Data.get("bl_type_data_Ac");
	String amount_data_Ac = Data.get("amount_data_Ac");
	String loadCost_Module = Data.get("LoadCost_Module");
	String container_Type_LDC = ContainerTypes;
	String local_Amount_LDC = Data.get("Local_Amount_LDC");
	String in_Transist_Checkbox_LDC = Data.get("In_Transist_Checkbox_LDC");
	String port_Code_LDC = Data.get("Port_Code_LDC");
	String activity_Type_LDC = Data.get("Activity_Type_LDC");
	String activity_Type_Conditional_Behaviour_LDC = Data.get("Activity_Type_Conditional_Behaviour_LDC");
	String local_Amount_Conditional_Behaviour_LDC = Data.get("Local_Amount_Conditional_Behaviour_LDC");
	String soc_flg_Fec = Data.get("soc_flg_Fec");
	String container_type_data_Fec = ContainerTypes;
	String service_data_Fec = Data.get("service_data_Fec");
	String currency_data_Fec = Data.get("currency_data_Fec");
	String voyage_time_data_Fec = Data.get("voyage_time_data_Fec");
	String outbound_data_Fec = Data.get("outbound_data_Fec");
	String inbound_data_Fec = Data.get("inbound_data_Fec");
	String empty_field_data_Fec = Data.get("empty_field_data_Fec");
	String per_diem_data_Fec = Data.get("per_diem_data_Fec");
	String ICO_Module_Name = Data.get("ICO_Module_Name");
	String ICO_Amount_Input = Data.get("ICO_Amount_Input");
	String ICO_Curreny_Input = Data.get("ICO_Curreny_Input");
	String ICO_Location_Code_Header = Data.get("ICO_Location_Code_Header");
	String ICO_Equip_Type_Header = Data.get("ICO_Equip_Type_Header");
	String ICD_Origin_Input = Data.get("ICD_Origin_Input");
	String ICD_Module_Name = Data.get("ICD_Module_Name");
	String ICD_Amount_Input = Data.get("ICD_Amount_Input");
	String ICD_Curreny_Input = Data.get("ICD_Curreny_Input");
	String ICD_Delivery_Port_Column_Header = Data.get("ICD_Delivery_Port_Column_Header");
	String ICD_Origin_Port_Column_Header = Data.get("ICD_Origin_Port_Column_Header");
	String ICD_Equip_Type_Column_Header = Data.get("ICD_Equip_Type_Column_Header");
	String claims_Module_Name = Data.get("claims_Module_Name");
	String claims_Amount_Input = Data.get("claims_Amount_Input");
	String claims_From_Location_Column_Header = Data.get("claims_From_Location_Column_Header");
	String claims_To_Location_Column_Header = Data.get("claims_To_Location_Column_Header");
	String claims_Equip_Type_Column_Header = Data.get("claims_Equip_Type_Column_Header");
	String claims_Curreny_Input = Data.get("claims_Curreny_Input");
	String container_Type_TCS_DT1 = ContainerTypes;
	String local_Amount_TCS_DT1 = Data.get("Local_Amount_TCS_DT1");
	String activity_Type_TCS_DT1 = Data.get("Activity_Type_TCS_DT1");
	String transhipmentType_TCS_DT = Data.get("TranshipmentType_TCS_DT");
	String activity_Type_Conditional_Behaviour_TSC_DT1 = Data.get("Activity_Type_Conditional_Behaviour_TSC_DT1");
	String local_Amount_Conditional_Behaviour_TSC_DT1 = Data.get("Local_Amount_Conditional_Behaviour_TSC_DT1");
	String equipment_Operation_cost_Delivery_Module = Data.get("equipment_Operation_cost_Delivery_Module");
	String Condition_filter_D = Data.get("Condition_filter_D");
	String amount_D = Data.get("amount_D");
	String amount_Type_D = Data.get("amount_Type_D");
	String cost_Delivery_Saved_Popup_D = Data.get("cost_Delivery_Saved_Popup_D");
	String container_Type_TCS_LT1 =ContainerTypes;
	String local_Amount_TCS_LT1 = Data.get("Local_Amount_TCS_LT1");
	String activity_Type_TCS_LT1 = Data.get("Activity_Type_TCS_LT1");
	String transhipmentType_TCS_LT = Data.get("TranshipmentType_TCS_LT");
	String activity_Type_Conditional_Behaviour_TSC_LT1 = Data.get("Activity_Type_Conditional_Behaviour_TSC_LT1");
	String local_Amount_Conditional_Behaviour_TSC_LT1 = Data.get("Local_Amount_Conditional_Behaviour_TSC_LT1");
	String container_Type_TCS_DT2 = ContainerTypes;
	String local_Amount_TCS_DT2 = Data.get("Local_Amount_TCS_DT2");
	String activity_Type_TCS_DT2 = Data.get("Activity_Type_TCS_DT2");
	String activity_Type_Conditional_Behaviour_TSC_DT2 = Data.get("Activity_Type_Conditional_Behaviour_TSC_DT2");
	String local_Amount_Conditional_Behaviour_TSC_DT2 = Data.get("Local_Amount_Conditional_Behaviour_TSC_DT2");
	String container_Type_TCS_LT2 = ContainerTypes;
	String local_Amount_TCS_LT2 = Data.get("Local_Amount_TCS_LT2");
	String activity_Type_TCS_LT2 = Data.get("Activity_Type_TCS_LT2");
	String activity_Type_Conditional_Behaviour_TSC_LT2 = Data.get("Activity_Type_Conditional_Behaviour_TSC_LT2");
	String local_Amount_Conditional_Behaviour_TSC_LT2 = Data.get("Local_Amount_Conditional_Behaviour_TSC_LT2");
	String container_Type_TCS_DT3 = ContainerTypes;
	String local_Amount_TCS_DT3 = Data.get("Local_Amount_TCS_DT3");
	String activity_Type_TCS_DT3 = Data.get("Activity_Type_TCS_DT3");
	String activity_Type_Conditional_Behaviour_TSC_DT3 = Data.get("Activity_Type_Conditional_Behaviour_TSC_DT3");
	String local_Amount_Conditional_Behaviour_TSC_DT3 = Data.get("Local_Amount_Conditional_Behaviour_TSC_DT3");
	String container_Type_TCS_LT3 = ContainerTypes;
	String local_Amount_TCS_LT3 = Data.get("Local_Amount_TCS_LT3");
	String activity_Type_TCS_LT3 = Data.get("Activity_Type_TCS_LT3");
	String activity_Type_Conditional_Behaviour_TSC_LT3 = Data.get("Activity_Type_Conditional_Behaviour_TSC_LT3");
	String local_Amount_Conditional_Behaviour_TSC_LT3 = Data.get("Local_Amount_Conditional_Behaviour_TSC_LT3");

	String Container_External_feeder1 = ContainerTypes;
	String Activity_Code_External_amount1 = Data.get("Activity_Code_External_amount1");
	String Activity_Code_External1 = Data.get("Activity_Code_External1");
	String Condition_Equipment_group_External_feeder1 = Data.get("Condition_Equipment_group_External_feeder1");
	String Condition_Activity_Code_External1 = Data.get("Condition_Activity_Code_External1");
	String Container_External_feeder2 = ContainerTypes;
	String Activity_Code_External_amount2 = Data.get("Activity_Code_External_amount2");
	String Activity_Code_External2 = Data.get("Activity_Code_External2");
	String Condition_Equipment_group_External_feeder2 = Data.get("Condition_Equipment_group_External_feeder2");
	String Condition_Activity_Code_External2 = Data.get("Condition_Activity_Code_External2");
	String Container_External_feeder3 = ContainerTypes;
	String Activity_Code_External_amount3 = Data.get("Activity_Code_External_amount3");
	String Activity_Code_External3 = Data.get("Activity_Code_External3");
	String Condition_Equipment_group_External_feeder3 = Data.get("Condition_Equipment_group_External_feeder3");
	String Condition_Activity_Code_External3 = Data.get("Condition_Activity_Code_External3");
	String Container_External_feeder4 =ContainerTypes;
	String Activity_Code_External_amount4 = Data.get("Activity_Code_External_amount4");
	String Activity_Code_External4 = Data.get("Activity_Code_External4");
	String Condition_Equipment_group_External_feeder4 = Data.get("Condition_Equipment_group_External_feeder4");
	String Condition_Activity_Code_External4 = Data.get("Condition_Activity_Code_External4");
	String Haulage_Cost_Module = Data.get("Haulage_Cost_Module");
	String From_Terminal_code_Haulage = Data.get("From_Terminal_code_Haulage");
	String To_Terminal_Haulage = Data.get("To_Terminal_Haulage");
	String Container_Haulage = ContainerTypes;
	String Activity_Code_Haulage_amount = Data.get("Activity_Code_Haulage_amount");
	String Activity_Code_Haulage = Data.get("Activity_Code_Haulage");
	String Condition_Equipment_group_Haulage = Data.get("Condition_Equipment_group_Haulage");
	String Condition_Activity_Code_Haulage = Data.get("Condition_Activity_Code_Haulage");
	String To_Terminal_CodeHaulage = Data.get("To_Terminal_CodeHaulage");
	String To_Location_CodeHaulage = Data.get("To_Location_CodeHaulage");
	String From_Location_code_Haulage = Data.get("From_Location_code_Haulage");
	String From_Terminal_CodeHaulage = Data.get("From_Terminal_CodeHaulage");

	From_Location_External = Data.get("From_Location_External");
	From_Terminal_External = Data.get("From_Terminal_External");
	To_Location_External = Data.get("To_Location_External");
	To_Terminal_External = Data.get("To_Terminal_External");
	Service_External = Data.get("Service_External");

	String locationDetails_Filter_DC = Data.get("locationDetails_Filter_DC");
	String terminalDetails_Filter_DC = Data.get("terminalDetails_Filter_DC");
	String servicelDetails_Filter_DC = Data.get("servicelDetails_Filter_DC");

	String locationDetails_Filter_LC = Data.get("locationDetails_Filter_LC");
	String terminalDetails_Filter_LC = Data.get("terminalDetails_Filter_LC");
	String servicelDetails_Filter_LC = Data.get("servicelDetails_Filter_LC");

	String locationDetails_Filter_TC1 = Data.get("locationDetails_Filter_TC1");
	String terminalDetails_Filter_TC1 = Data.get("terminalDetails_Filter_TC1");
	String servicelDetails_Filter_TC1 = Data.get("servicelDetails_Filter_TC1");
	String locationDetails_Filter_TC2 = Data.get("locationDetails_Filter_TC2");
	String terminalDetails_Filter_TC2 = Data.get("terminalDetails_Filter_TC2");
	String servicelDetails_Filter_TC2 = Data.get("servicelDetails_Filter_TC2");
	String locationDetails_Filter_TC3 = Data.get("locationDetails_Filter_TC3");
	String terminalDetails_Filter_TC3 = Data.get("terminalDetails_Filter_TC3");
	String servicelDetails_Filter_TC3 = Data.get("servicelDetails_Filter_TC3");
	String Equip_Type_Header_C = Data.get("Equip_Type_Header_C");
	String Port_Code_Header_C = Data.get("Port_Code_Header_C");
	String Location_Code_Header_D = Data.get("Location_Code_Header_D");
	String Equip_Type_Header_D = Data.get("Equip_Type_Header_D");

	String portCodeDetails_Filter_DC = Data.get("portCodeDetails_Filter_DC");
	String portCodeDetails_Filter_LC = Data.get("portCodeDetails_Filter_LC");

	// FEC HEADERS
	String service_code_header_Fec = Data.get("service_code_header_Fec");
	String location_code_header_Fec = Data.get("location_code_header_Fec");
	String equipment_type_header_Fec = Data.get("equipment_type_header_Fec");

	// ADMIN COST HEADERS

	String service_code_header_Ac = Data.get("service_code_header_Ac");

	String equipmentType = "";

	// Extract Equipment Type (first line before #)
	String[] inputParts = input.split("#", 2);
	if (inputParts[0].contains("Equipment Type :")) {
		equipmentType = inputParts[0].split(":")[1].trim();
	}
	// Split sections based on #
	String[] sections = input.split("#");
	for (String section : sections) {
		if (section.trim().isEmpty())
			continue;

		String[] parts = section.split(" - ");
		if (parts.length < 2)
			continue;
		String moduleName = parts[0].trim();
		String[] values = parts[1].split(",");
		Map<String, String> moduleData = new LinkedHashMap<>();
		moduleData.put("Module Name", moduleName);
		moduleData.put("Equipment Type", equipmentType); // Use extracted Equipment Type
		switch (moduleName) {
		case "Discharge Cost":
			moduleData.put("Port Name", values[0].trim());
			moduleData.put("Terminal", values[1].trim());
			moduleData.put("Service", values[2].trim());
			moduleData.put("T.service", values[4].trim());
			String t_Service_DSC = moduleData.get("T.service");
			if (moduleData.get("T.service").contains("CY")) {
				t_Service_DSC = "CONTAINER YARD";
			} else if (moduleData.get("T.service").contains("CT")) {
				t_Service_DSC = "CONTAINER TERMINAL";
			}
			String eqp_Group_DSC = moduleData.get("Equipment Type");
			if (moduleData.get("Equipment Type").contains("2")) {
				eqp_Group_DSC = "20S";
			} else if (moduleData.get("Equipment Type").contains("4")) {
				eqp_Group_DSC = "40S";
			} else {
				eqp_Group_DSC = "20S";
			}
			Step_Start(1, "Open the screen through module search.", test, test1);
			scrollTop(driver);
			moduleNavigate(driver, dischargeCost_Module);
			Step_End(1, "Open the screen through module search.", test, test1);
			Step_Start(2, "Click new button.", test, test1);
			scrollTop(driver);

			newButton(driver);

			Step_End(2, "Click new button.", test, test1);

			String select_Container_Type_DC = String.format(containerType_RadioButton_DC, container_Type_DSC);
			waitForElement(driver, select_Container_Type_DC);
			click(driver, select_Container_Type_DC);
			Step_Start(3, "Enter the load port.", test, test1);
			waitForElement(driver, location_SearchButton_DC);
			click(driver, location_SearchButton_DC);

			twoColumnSearchWindow(driver, locationDetails_Filter_DC, condition, moduleData.get("Port Name"));

			Step_End(3, "Enter the load port.", test, test1);
			Step_Start(4, "Enter the load terminal.", test, test1);
			waitForElement(driver, terminal_SearchButton_DC);
			click(driver, terminal_SearchButton_DC);

			twoColumnSearchWindow(driver, terminalDetails_Filter_DC, condition, moduleData.get("Terminal"));

			Step_End(4, "Enter the load terminal.", test, test1);
			Step_Start(5, "Enter the Equipment group", test, test1);
			waitForElement(driver, eqp_Group_Dropdown_DC);
			click(driver, eqp_Group_Dropdown_DC);
			String eqpGroup_DC = String.format(DropDown_Select, eqp_Group_DSC);
			waitForElement(driver, eqpGroup_DC);
			click(driver, eqpGroup_DC);
			Step_End(5, "Enter the Equipment group", test, test1);
			Step_Start(6, "Enter the Tservice", test, test1);
			waitForElement(driver, t_Service_Dropdown_DC);
			click(driver, t_Service_Dropdown_DC);
			String T_Service_DC = String.format(DropDown_Select, t_Service_DSC);
			waitForElement(driver, T_Service_DC);
			click(driver, T_Service_DC);
			Step_End(6, "Enter the Tservice", test, test1);
			Step_Start(7, "Enter the service", test, test1);
			waitForElement(driver, service_SearchButton_DC);
			click(driver, service_SearchButton_DC);

			twoColumnSearchWindow(driver, servicelDetails_Filter_DC, condition, moduleData.get("Service"));

			Step_End(7, "Enter the service", test, test1);
			if (!Start_Date.equals("")) {

				waitForElement(driver, fromDate_DC);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, fromDate_DC, Start_Date);
				} else {
					waitForElement(driver, fromDate_DC);
					clearAndType(driver, fromDate_DC, Start_Date);
				}
			}
			if (!End_Date.equals("")) {

				waitForElement(driver, toDate_DC);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, toDate_DC, End_Date);
				} else {
					waitForElement(driver, toDate_DC);
					clearAndType(driver, toDate_DC, End_Date);
				}
			}
			if (in_Transist_Checkbox_DSC.equalsIgnoreCase("Yes")) {
				waitForDisplay(driver, in_Transist_Checkbox_DC);
				checkBox(driver, in_Transist_Checkbox_DC, in_Transist_Checkbox_DSC);
				waitForDisplay(driver, pol_Add_Button_DC);
				click(driver, pol_Add_Button_DC);
				twoColumnSearchWindow(driver, portCodeDetails_Filter_DC, condition, port_Code_DSC);

			}
			Step_Start(8, "Enter the amount in the local amount column", test, test1);
			List<String> activity_Types_DSC = splitAndExpand(activity_Type_DSC);
			List<String> local_Amounts_DSC = splitAndExpand(local_Amount_DSC);
			for (int i = 0; i < activity_Types_DSC.size(); i++) {
				String activityType_DSC = activity_Types_DSC.get(i);
				String localAmount_DSC = local_Amounts_DSC.get(i);
				String localAmount = String.format(standardCost_Table_LocalAmount_DC, activityType_DSC);
				waitForElement(driver, localAmount);
				click(driver, localAmount);
				if (!activityType_DSC.equals(" ") && !localAmount_DSC.equals(" ")) {
					String localAmount_Input_DSC = String.format(standardCost_Table_LocalAmount_Input_DC,
							activityType_DSC);
					waitForElement(driver, localAmount_Input_DSC);
					clearAndType(driver, localAmount_Input_DSC, localAmount_DSC);
				}
				waitForElement(driver, standardCost_Table_Rows_DC);
				click(driver, standardCost_Table_Rows_DC);
			}
			waitForElement(driver, standardCost_Table_Rows_DC);
			click(driver, standardCost_Table_Rows_DC);
			// Conditional Behaviour
			List<String> activity_Types_Condi_DSC = splitAndExpand(activity_Type_Conditional_Behaviour_DSC);
			List<String> local_Amounts_Condi_DSC = splitAndExpand(local_Amount_Conditional_Behaviour_DSC);
			for (int i = 0; i < activity_Types_Condi_DSC.size(); i++) {
				String activityType = activity_Types_Condi_DSC.get(i);
				String localAmount_DSC = local_Amounts_Condi_DSC.get(i);
				String localAmount = String.format(conditional_Behaviour_Cost_LocalAmount_DC, activityType);
				waitForElement(driver, localAmount);
				click(driver, localAmount);
				if (!activityType.equals(" ") && !localAmount_DSC.equals(" ")) {
					String localAmount_Input = String.format(conditional_Behaviour_Cost_LocalAmount_Input_DC,
							activityType);
					waitForElement(driver, localAmount_Input);
					clearAndType(driver, localAmount_Input, localAmount_DSC);
				}
				waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_DC);
				click(driver, conditional_Behaviour_Cost_Table_Rows_DC);
			}
			waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_DC);
			click(driver, conditional_Behaviour_Cost_Table_Rows_DC);
			Step_End(8, "Enter the amount in the local amount column", test, test1);
			Step_Start(9, "Click save", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
			Step_End(9, "Click save", test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		case "Admin Cost":
			moduleData.put("Service", values[0].trim());
			Step_Start(1, "Open the screen through module search", test, test1);
			scrollTop(driver);
			moduleNavigate(driver, Ac_module);
			Step_End(1, "Open the screen through module search", test, test1);
			Step_Start(2, "Click new button", test, test1);
			scrollTop(driver);
			newButton(driver);
			Step_End(2, "Click new button", test, test1);
			Step_Start(3, "Enter the service", test, test1);
			waitForElement(driver, service_search_icon_Ac);
			click(driver, service_search_icon_Ac);
			twoColumnSearchWindow(driver, service_code_header_Ac, condition, moduleData.get("Service"));

			Step_End(3, "Enter the service", test, test1);
			// non-mandadtory
			if (!currency_data_Ac.equals("")) {
				waitForElement(driver, currency_dd_Ac);
				click(driver, currency_dd_Ac);
				String currency_value = String.format(currency_dd_value_Ac, currency_data_Ac);
				waitForElement(driver, currency_value);
				click(driver, currency_value);
			}
			if (!radio_btn_data_Ac.equals("")) {
				String radio_btn_to_click = String.format(radio_btn_Ac, radio_btn_data_Ac);
				waitForElement(driver, radio_btn_to_click);
				click(driver, radio_btn_to_click);
			}
			checkBox(driver, soc_chckbox_Ac, soc_flag_Ac);
			if (!container_type_data_Ac.equals("")) {
				String container_type_to_select = String.format(container_type_radio_btn_Ac,
						container_type_data_Ac);
				waitForElement(driver, container_type_to_select);
				click(driver, container_type_to_select);
			}
			if (!bl_type_data_Ac.equals("")) {
				waitForElement(driver, bl_type_label_Ac);
				click(driver, bl_type_label_Ac);
				String bl_type_to_select = String.format(bl_type_options_Ac, bl_type_data_Ac);
				waitForElement(driver, bl_type_to_select);
				click(driver, bl_type_to_select);
			}
			if (!Start_Date.equals("")) {
				waitForElement(driver, start_date_Ac);
				selectDatePicker(driver, start_date_Ac, Start_Date);
			} else {
				clearAndType(driver, start_date_Ac, Start_Date);
			}
			if (!End_Date.equals("")) {
				waitForElement(driver, End_date_Ac);
				selectDatePicker(driver, End_date_Ac, End_Date);
			} else {
				clearAndType(driver, End_date_Ac, End_Date);
			}
			Step_Start(4, "Enter the amount", test, test1);
			waitForElement(driver, amount_txtfld_Ac);
			sendKeys(driver, amount_txtfld_Ac, amount_data_Ac);
			Step_End(4, "Enter the amount", test, test1);
			Step_Start(5, "Click save", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(5, "Click save", test, test1);
			
			waitForDisplay(driver, popup_Message_Yes_Button);
			if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
			}
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		case "Loading Cost":
			moduleData.put("Port Name", values[0].trim());
			moduleData.put("Terminal", values[1].trim());
			moduleData.put("Service", values[2].trim());
			moduleData.put("T.service", values[4].trim());
			String t_Service_LDC = moduleData.get("T.service");
			if (moduleData.get("T.service").contains("CY")) {
				t_Service_LDC = "CONTAINER YARD";
			} else if (moduleData.get("T.service").contains("CT")) {
				t_Service_LDC = "CONTAINER YARD";
			}
			String eqp_Group_LDC = moduleData.get("Equipment Type");
			if (moduleData.get("Equipment Type").contains("2")) {
				eqp_Group_LDC = "20S";
			} else if (moduleData.get("Equipment Type").contains("4")) {
				eqp_Group_LDC = "40S";
			} else {
				eqp_Group_LDC = "20S";
			}
			Step_Start(1, "Open the screen through module search.", test, test1);
			moduleNavigate(driver, loadCost_Module);
			Step_End(1, "Open the screen through module search.", test, test1);
			Step_Start(2, "Click new button.", test, test1);
			newButton(driver);
			Step_End(2, "Click new button.", test, test1);
			String select_Container_Type = String.format(containerType_RadioButton_LC, container_Type_LDC);
			waitForElement(driver, select_Container_Type);
			click(driver, select_Container_Type);
			Step_Start(3, "Enter the load port.", test, test1);
			waitForElement(driver, location_SearchButton_LC);
			click(driver, location_SearchButton_LC);

			twoColumnSearchWindow(driver, locationDetails_Filter_LC, condition, moduleData.get("Port Name"));

			Step_End(3, "Enter the load port.", test, test1);
			Step_Start(4, "Enter the load terminal.", test, test1);
			waitForElement(driver, terminal_SearchButton_LC);
			click(driver, terminal_SearchButton_LC);

			twoColumnSearchWindow(driver, terminalDetails_Filter_LC, condition, moduleData.get("Terminal"));

			Step_End(4, "Enter the load terminal.", test, test1);
			Step_Start(5, "Enter the Equipment group", test, test1);
			waitForElement(driver, eqp_Group_Dropdown_LC);
			click(driver, eqp_Group_Dropdown_LC);
			String eqpGroup = String.format(DropDown_Select, eqp_Group_LDC);
			waitForElement(driver, eqpGroup);
			click(driver, eqpGroup);
			Step_End(5, "Enter the Equipment group", test, test1);
			Step_Start(6, "Enter the Tservice", test, test1);
			waitForElement(driver, t_Service_Dropdown_LC);
			click(driver, t_Service_Dropdown_LC);
			String T_Service = String.format(DropDown_Select, t_Service_LDC);
			waitForElement(driver, T_Service);
			click(driver, T_Service);
			Step_End(6, "Enter the Tservice", test, test1);
			Step_Start(7, "Enter the service", test, test1);
			waitForElement(driver, service_SearchButton_LC);
			click(driver, service_SearchButton_LC);

			twoColumnSearchWindow(driver, servicelDetails_Filter_LC, condition, moduleData.get("Service"));

			Step_End(7, "Enter the service", test, test1);
			if (!Start_Date.equals("")) {
				waitForElement(driver, fromDate_LC);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, fromDate_LC, Start_Date);
				} else {
					waitForElement(driver, fromDate_LC);
					clearAndType(driver, fromDate_LC, Start_Date);
				}
			}
			if (!End_Date.equals("")) {

				waitForElement(driver, toDate_LC);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, toDate_LC, End_Date);
				} else {
					waitForElement(driver, toDate_LC);
					clearAndType(driver, toDate_LC, End_Date);
				}
			}
			if (in_Transist_Checkbox_LDC.equalsIgnoreCase("Yes")) {
				waitForDisplay(driver, in_Transist_Checkbox_LC);
				checkBox(driver, in_Transist_Checkbox_LC, in_Transist_Checkbox_LDC);
				waitForDisplay(driver, pol_Add_Button_LC);
				click(driver, pol_Add_Button_LC);
				twoColumnSearchWindow(driver, portCodeDetails_Filter_LC, condition, port_Code_LDC);

			}
			Step_Start(8, "Enter the amount in the local amount column", test, test1);
			List<String> activity_Types_LDC = splitAndExpand(activity_Type_LDC);
			List<String> local_Amounts_LDC = splitAndExpand(local_Amount_LDC);
			for (int i = 0; i < activity_Types_LDC.size(); i++) {
				String activityType = activity_Types_LDC.get(i);
				String localAmount_LDC = local_Amounts_LDC.get(i);
				String localAmount = String.format(standardCost_Table_LocalAmount_LC, activityType);
				waitForElement(driver, localAmount);
				click(driver, localAmount);
				if (!activityType.equals(" ") && !localAmount_LDC.equals(" ")) {
					String localAmount_Input = String.format(standardCost_Table_LocalAmount_Input_LC, activityType);
					waitForElement(driver, localAmount_Input);
					clearAndType(driver, localAmount_Input, localAmount_LDC);
				}
				waitForElement(driver, standardCost_Table_Rows_LC);
				click(driver, standardCost_Table_Rows_LC);
			}
			waitForElement(driver, standardCost_Table_Rows_LC);
			click(driver, standardCost_Table_Rows_LC);
			// Conditional Behaviour
			List<String> activity_Types_LDC1 = splitAndExpand(activity_Type_Conditional_Behaviour_LDC);
			List<String> local_Amounts_LDC1 = splitAndExpand(local_Amount_Conditional_Behaviour_LDC);
			for (int i = 0; i < activity_Types_LDC1.size(); i++) {
				String activityType = activity_Types_LDC1.get(i);
				String localAmount_LDC = local_Amounts_LDC1.get(i);
				String localAmount = String.format(conditional_Behaviour_Cost_LocalAmount_LC, activityType);
				waitForElement(driver, localAmount);
				click(driver, localAmount);
				if (!activityType.equals(" ") && !localAmount_LDC.equals(" ")) {
					String localAmount_Input = String.format(conditional_Behaviour_Cost_LocalAmount_Input_LC,
							activityType);
					waitForElement(driver, localAmount_Input);
					clearAndType(driver, localAmount_Input, localAmount_LDC);
				}
				waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_LC);
				click(driver, conditional_Behaviour_Cost_Table_Rows_LC);
			}
			waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_LC);
			click(driver, conditional_Behaviour_Cost_Table_Rows_LC);
			Step_End(8, "Enter the amount in the local amount column", test, test1);
			Step_Start(9, "Click save", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);
			}
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);
			}
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);
			}
			Step_End(9, "Click save", test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		case "Load Haulage Cost":
			moduleData.put("From_location", values[0].trim());
			moduleData.put("To_Location", values[1].trim());
			waitForElement(driver, Routing_click);
			click(driver, Routing_click);
			String mode_value = getText(driver, get_mode);
			System.out.println("Mode Value: " + mode_value);
			switch (mode_value) {
			case "R":
				mode_value = "Rail";
				break;
			case "T":
				mode_value = "Truck";
				break;
			case "C":
				mode_value = "Combined";
				break;
			case "B":
				mode_value = "Barge";
				break;
			}
			waitForElement(driver, Routing_click_close);
			click(driver, Routing_click_close);
			String equipment_group = String.format(Rate_Request_Loactors.select_type, equipmentType);
			String container_click = String.format(Rate_Request_Loactors.Container_type_internal_feeder,
					Container_Haulage);
			String mode = String.format(Rate_Request_Loactors.select_type, mode_value);
			scrollTop(driver);
			moduleNavigate(driver, Haulage_Cost_Module);
			scrollTop(driver);
			newButton(driver);
			waitForElement(driver, container_click);
			click(driver, container_click);
			waitForElement(driver, From_location_search_Haulage);
			click(driver, From_location_search_Haulage);

			twoColumnSearchWindow(driver, From_Location_code_Haulage, condition, moduleData.get("From_location"));

			waitForElement(driver, From_terminal_search_Haulage);
			click(driver, From_terminal_search_Haulage);
			twoColumnSearchWindow(driver, From_Terminal_CodeHaulage, condition, From_Terminal_code_Haulage);

			waitForElement(driver, TO_location_search_Haulage);
			click(driver, TO_location_search_Haulage);
			twoColumnSearchWindow(driver, To_Location_CodeHaulage, condition, moduleData.get("To_Location"));
			waitForElement(driver, to_terminal_search_Haulage);
			click(driver, to_terminal_search_Haulage);
			twoColumnSearchWindow(driver, To_Terminal_CodeHaulage, condition, To_Terminal_Haulage);
			waitForElement(driver, mode_Haulage_click);
			click(driver, mode_Haulage_click);
			waitForElement(driver, mode);
			click(driver, mode);
			if (!Start_Date.equals("")) {
				waitForElement(driver, start_date_Haulage);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, start_date_Haulage, Start_Date);
				} else {
					waitForElement(driver, start_date_Haulage);
					clearAndType(driver, start_date_Haulage, Start_Date);
				}
			}
			if (!End_Date.equals("")) {
				waitForElement(driver, to_date_Haulage);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, to_date_Haulage, End_Date);
				} else {
					waitForElement(driver, to_date_Haulage);
					clearAndType(driver, to_date_Haulage, End_Date);
				}
			}
			waitForElement(driver, eqp_group_dd_Haulage);
			click(driver, eqp_group_dd_Haulage);
			waitForElement(driver, equipment_group);
			click(driver, equipment_group);
			List<String> activity_Types_DSC1 = splitAndExpand(Activity_Code_Haulage);
			List<String> local_Amounts_DSC1 = splitAndExpand(Activity_Code_Haulage_amount);
			for (int i = 0; i < activity_Types_DSC1.size(); i++) {
				String activityType_DSC = activity_Types_DSC1.get(i);
				String localAmount_DSC = local_Amounts_DSC1.get(i);
				String localAmount = String.format(Rate_Request_Loactors.standardCost_Table_LocalAmount_HC,
						activityType_DSC);
				waitForElement(driver, localAmount);
				click(driver, localAmount);
				if (!activityType_DSC.equals(" ") && !localAmount_DSC.equals(" ")) {
					String localAmount_Input_DSC = String.format(standardCost_Table_LocalAmount_Input_HC,
							activityType_DSC);
					waitForElement(driver, localAmount_Input_DSC);
					clearAndType(driver, localAmount_Input_DSC, localAmount_DSC);
				}
				waitForElement(driver, standardCost_Table_Rows_HC);
				click(driver, standardCost_Table_Rows_HC);
			}
			waitForElement(driver, standardCost_Table_Rows_HC);
			click(driver, standardCost_Table_Rows_HC);
			// Conditional Behaviour
			List<String> activity_Types_Condi_DSC1 = splitAndExpand(Condition_Activity_Code_Haulage);
			List<String> local_Amounts_Condi_DSC1 = splitAndExpand(Condition_Equipment_group_Haulage);
			for (int i = 0; i < activity_Types_Condi_DSC1.size(); i++) {
				String activityType = activity_Types_Condi_DSC1.get(i);
				String localAmount_DSC = local_Amounts_Condi_DSC1.get(i);
				String localAmount = String.format(conditional_Behaviour_Cost_LocalAmount_HC, activityType);
				waitForElement(driver, localAmount);
				click(driver, localAmount);
				if (!activityType.equals(" ") && !localAmount_DSC.equals(" ")) {
					String localAmount_Input = String.format(conditional_Behaviour_Cost_LocalAmount_Input_HC,
							activityType);
					waitForElement(driver, localAmount_Input);
					clearAndType(driver, localAmount_Input, localAmount_DSC);
				}
				waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_HC);
				click(driver, conditional_Behaviour_Cost_Table_Rows_HC);
			}
			waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_HC);
			click(driver, conditional_Behaviour_Cost_Table_Rows_HC);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;
		case "External Feeder 1 Cost":
			moduleData.put("From_location", values[0].trim());
			moduleData.put("From_Terminal", values[1].trim());
			moduleData.put("To_Location", values[2].trim());
			moduleData.put("To_Terminal", values[3].trim());
			moduleData.put("Service_input", values[4].trim());
			externalFeeder(driver, External_Feeder_Cost_Module, equipmentType, Container_External_feeder1,
					condition, moduleData, datePicker, Start_Date, End_Date, Condition_Activity_Code_External1,
					Condition_Equipment_group_External_feeder1, Activity_Code_External1,
					Activity_Code_External_amount1, test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;
		case "External Feeder 2 Cost":
			moduleData.put("From_location", values[0].trim());
			moduleData.put("From_Terminal", values[1].trim());
			moduleData.put("To_Location", values[2].trim());
			moduleData.put("To_Terminal", values[3].trim());
			moduleData.put("Service_input", values[4].trim());
			externalFeeder(driver, External_Feeder_Cost_Module, equipmentType, Container_External_feeder2,
					condition, moduleData, datePicker, Start_Date, End_Date, Condition_Activity_Code_External2,
					Condition_Equipment_group_External_feeder2, Activity_Code_External2,
					Activity_Code_External_amount2, test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;
		case "External Feeder 3 Cost":
			moduleData.put("From_location", values[0].trim());
			moduleData.put("From_Terminal", values[1].trim());
			moduleData.put("To_Location", values[2].trim());
			moduleData.put("To_Terminal", values[3].trim());
			moduleData.put("Service_input", values[4].trim());
			externalFeeder(driver, External_Feeder_Cost_Module, equipmentType, Container_External_feeder3,
					condition, moduleData, datePicker, Start_Date, End_Date, Condition_Activity_Code_External3,
					Condition_Equipment_group_External_feeder3, Activity_Code_External3,
					Activity_Code_External_amount3, test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;
		case "External Feeder 4 Cost":
			moduleData.put("From_location", values[0].trim());
			moduleData.put("From_Terminal", values[1].trim());
			moduleData.put("To_Location", values[2].trim());
			moduleData.put("To_Terminal", values[3].trim());
			moduleData.put("Service_input", values[4].trim());
			externalFeeder(driver, External_Feeder_Cost_Module, equipmentType, Container_External_feeder4,
					condition, moduleData, datePicker, Start_Date, End_Date, Condition_Activity_Code_External4,
					Condition_Equipment_group_External_feeder4, Activity_Code_External4,
					Activity_Code_External_amount4, test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;
		case "Equipment Operation Cost Origin":
			moduleData.put("Origin", values[0].trim());
			scrollTop(driver);
			Step_Start(1, "Open the screen through module search", test, test1);
			moduleNavigate(driver, equipment_Operation_cost_Origin_Module);
			Step_End(1, "Open the screen through module search", test, test1);
			scrollTop(driver);
			Step_Start(2, "Click new button", test, test1);
			newButton(driver);
			Step_End(2, "Click new button", test, test1);
			Step_Start(3, "Enter the From Location", test, test1);
			waitForElement(driver, Cost_Origin_Location_TF);
			sendKeys(driver, Cost_Origin_Location_TF, moduleData.get("Origin"));
			waitForElement(driver, cost_Origin_Location_Search_Button);
			click(driver, cost_Origin_Location_Search_Button);
			twoColumnSearchWindow(driver, Port_Code_Header_C, Condition_filter_C, moduleData.get("Origin"));
			Step_End(3, "Enter the From Location", test, test1);

			Step_Start(4, "Enter the Equipment Type", test, test1);
			waitForElement(driver, cost_Origin_Equipment_Type_Plus_Button);
			click(driver, cost_Origin_Equipment_Type_Plus_Button);
			twoColumnSearchWindow(driver, Equip_Type_Header_C, Condition_filter_C, equipmentType);
			Step_End(4, "Enter the Equipment Type", test, test1);

			if (!Start_Date.equals("")) {
				waitForElement(driver, cost_Origin_Start_Date);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, cost_Origin_Start_Date, Start_Date);
				} else {
					waitForElement(driver, cost_Origin_Start_Date);
					clearAndType(driver, cost_Origin_Start_Date, Start_Date);
				}
			}
			// Selecting the to Date

			if (!End_Date.equals("")) {
				waitForElement(driver, cost_Origin_End_Date);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, cost_Origin_End_Date, End_Date);
				} else {
					waitForElement(driver, cost_Origin_End_Date);
					clearAndType(driver, cost_Origin_End_Date, End_Date);
				}
			}
			Step_Start(5, "Enter the amount", test, test1);
			waitForElement(driver, cost_Origin_Amount_TF);
			clearAndType(driver, cost_Origin_Amount_TF, amount_C);
			Step_End(5, "Enter the amount", test, test1);
			waitForElement(driver, cost_Origin_amount_Type_Dropdown);
			click(driver, cost_Origin_amount_Type_Dropdown);
			String select_Amount_Type = String.format(Rate_Request_Loactors.cost_Origin_Amount_Type_Select,
					amount_Type_C);
			waitForElement(driver, select_Amount_Type);
			click(driver, select_Amount_Type);
			Step_Start(6, "Click save", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(6, "Click save", test, test1);
			if (isdisplayed(driver, Popup_Message)) {
				waitForPopup(driver, Popup_Message, cost_Origin_Saved_Popup_C);
				String cost_origin_Saved = getText(driver, Popup_Message);
				if (cost_origin_Saved.equals(cost_Origin_Saved_Popup_C)) {
					System.out.println("Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
							+ " || Actual popup is : " + cost_origin_Saved);
					Extent_pass(driver, "Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
							+ " || Actual popup is : " + cost_origin_Saved, test, test1);
				} else {
					System.out.println("Not Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
							+ " || Actual popup is : " + cost_origin_Saved);
					Extent_fail(driver, "Not Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
							+ " || Actual popup is : " + cost_origin_Saved, test, test1);
				}
			} else {
				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Yes_Button);
				} else {
					waitForPopup(driver, Popup_Message, cost_Origin_Saved_Popup_C);
					String cost_origin_Saved = getText(driver, Popup_Message);
					if (cost_origin_Saved.equals(cost_Origin_Saved_Popup_C)) {
						System.out.println("Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
								+ " || Actual popup is : " + cost_origin_Saved);
						Extent_pass(driver, "Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
								+ " || Actual popup is : " + cost_origin_Saved, test, test1);
					} else {
						System.out.println("Not Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
								+ " || Actual popup is : " + cost_origin_Saved);
						Extent_fail(driver, "Not Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
								+ " || Actual popup is : " + cost_origin_Saved, test, test1);
					}
				}
			}
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		case "Equipment Operation Cost Delivery":
			moduleData.put("Origin", values[0].trim());
			scrollTop(driver);
			Step_Start(1, "Open the screen through module search", test, test1);
			moduleNavigate(driver, equipment_Operation_cost_Delivery_Module);
			Step_End(1, "Open the screen through module search.", test, test1);
			scrollTop(driver);

			Step_Start(2, "Click new button", test, test1);
			newButton(driver);
			Step_End(2, "Click new button", test, test1);
			Step_Start(3, "Enter the From Location", test, test1);
			waitForElement(driver, cost_Delivery_Location_TF);
			sendKeys(driver, cost_Delivery_Location_TF, moduleData.get("Origin"));
			waitForElement(driver, cost_Delivery_Location_Search_Button);
			click(driver, cost_Delivery_Location_Search_Button);
			twoColumnSearchWindow(driver, Location_Code_Header_D, Condition_filter_C, moduleData.get("Origin"));

			Step_End(3, "Enter the From Location", test, test1);

			Step_Start(4, "Enter the Equipment Type", test, test1);
			waitForElement(driver, cost_Delivery_Equipment_Type_Plus_Button);
			click(driver, cost_Delivery_Equipment_Type_Plus_Button);
			twoColumnSearchWindow(driver, Equip_Type_Header_D, Condition_filter_D, equipmentType);

			Step_End(4, "Enter the Equipment Type", test, test1);
			if (!Start_Date.equals("")) {
				waitForElement(driver, cost_Delivery_Start_Date);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, cost_Delivery_Start_Date, Start_Date);
				} else {
					waitForElement(driver, cost_Delivery_Start_Date);
					clearAndType(driver, cost_Delivery_Start_Date, Start_Date);
				}
			}
			// Selecting the to Date
			if (!End_Date.equals("")) {
				waitForElement(driver, cost_Delivery_End_Date);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, cost_Delivery_End_Date, End_Date);
				} else {
					waitForElement(driver, cost_Delivery_End_Date);
					clearAndType(driver, cost_Delivery_End_Date, End_Date);
				}
			}
			Step_Start(5, "Enter the amount", test, test1);
			waitForElement(driver, cost_Delivery_Amount_TF);
			clearAndType(driver, cost_Delivery_Amount_TF, amount_D);
			Step_End(5, "Enter the amount", test, test1);
			waitForElement(driver, cost_Delivery_Amount_Type_Dropdown);
			click(driver, cost_Delivery_Amount_Type_Dropdown);
			String select_Amount_Type_D = String.format(Rate_Request_Loactors.cost_Delivery_Amount_Type_Select,
					amount_Type_D);
			waitForElement(driver, select_Amount_Type_D);
			click(driver, select_Amount_Type_D);
			Step_Start(6, "Click save", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(6, "Click save", test, test1);
			if (isdisplayed(driver, Popup_Message)) {
				waitForPopup(driver, Popup_Message, cost_Delivery_Saved_Popup_D);
				String cost_Delivery_Saved = getText(driver, Popup_Message);
				if (cost_Delivery_Saved.equals(cost_Delivery_Saved_Popup_D)) {
					System.out.println("Matched || " + " Expected popup is : " + cost_Delivery_Saved_Popup_D
							+ " || Actual popup is : " + cost_Delivery_Saved);
					Extent_pass(driver, "Matched || " + " Expected popup is : " + cost_Delivery_Saved_Popup_D
							+ " || Actual popup is : " + cost_Delivery_Saved, test, test1);
				} else {
					System.out.println("Not Matched || " + " Expected popup is : " + cost_Delivery_Saved_Popup_D
							+ " || Actual popup is : " + cost_Delivery_Saved);
					Extent_fail(driver, "Not Matched || " + " Expected popup is : " + cost_Delivery_Saved_Popup_D
							+ " || Actual popup is : " + cost_Delivery_Saved, test, test1);
				}
			} else {
				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Yes_Button);
				} else {
					waitForPopup(driver, Popup_Message, cost_Delivery_Saved_Popup_D);
					String cost_Delivery_Saved = getText(driver, Popup_Message);
					if (cost_Delivery_Saved.equals(cost_Delivery_Saved_Popup_D)) {
						System.out.println("Matched || " + " Expected popup is : " + cost_Delivery_Saved
								+ " || Actual popup is : " + cost_Delivery_Saved_Popup_D);
						Extent_pass(driver, "Matched || " + " Expected popup is : " + cost_Delivery_Saved
								+ " || Actual popup is : " + cost_Delivery_Saved_Popup_D, test, test1);
					} else {
						System.out.println("Not Matched || " + " Expected popup is : " + cost_Delivery_Saved
								+ " || Actual popup is : " + cost_Delivery_Saved_Popup_D);
						Extent_fail(driver, "Not Matched || " + " Expected popup is : " + cost_Delivery_Saved
								+ " || Actual popup is : " + cost_Delivery_Saved_Popup_D, test, test1);
					}
				}
			}
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;
		case "Fixed Equipment Cost":
			String[] fixedValues = parts[1].split(",");
			for (String val : fixedValues) {
				if (val.contains("Origin"))
					moduleData.put("Origin", val.split(":")[1].trim());
				if (val.contains("POL"))
					moduleData.put("POL", val.split(":")[1].trim());
				if (val.contains("Delivery"))
					moduleData.put("Delivery", val.split(":")[1].trim());
				if (val.contains("POD"))
					moduleData.put("POD", val.split(":")[1].trim());
			}
			Step_Start(1, "Open the screen through module search", test, test1);
			Step_Start(1, "Open the screen through module search", test, test1);
			scrollTop(driver);
			moduleNavigate(driver, Fec_module);
			Step_End(1, "Open the screen through module search", test, test1);
			Step_Start(2, "Click new button", test, test1);
			scrollTop(driver);
			newButton(driver);
			Step_End(2, "Click new button", test, test1);
			Step_Start(3, "Enter the service", test, test1);
			if (!service_data_Fec.equals("")) {
				waitForElement(driver, service_search_icon_Fec);
				click(driver, service_search_icon_Fec);
//					selectValue(driver, condition, service_data_Fec);
				twoColumnSearchWindow(driver, service_code_header_Fec, condition, service_data_Fec);
			}

			Step_End(3, "Enter the service", test, test1);
			Step_Start(4, "Enter the origin", test, test1);
			waitForElement(driver, origin_search_icon_Fec);
			click(driver, origin_search_icon_Fec);
//				selectValue(driver, condition, moduleData.get("Origin"));
			twoColumnSearchWindow(driver, location_code_header_Fec, condition, moduleData.get("Origin"));

			Step_End(4, "Enter the origin", test, test1);
			Step_Start(5, "Enter the POL", test, test1);
			waitForElement(driver, pol_search_icon_Fec);
			click(driver, pol_search_icon_Fec);
//				selectValue(driver, condition,  moduleData.get("POL"));
			twoColumnSearchWindow(driver, location_code_header_Fec, condition, moduleData.get("POL"));

			Step_End(5, "Enter the POL", test, test1);
			Step_Start(6, "Enter the POD", test, test1);
			waitForElement(driver, pod_search_icon_Fec);
			click(driver, pod_search_icon_Fec);
//				selectValue(driver, condition, moduleData.get("POD"));
			twoColumnSearchWindow(driver, location_code_header_Fec, condition, moduleData.get("POD"));

			Step_End(6, "Enter the POD", test, test1);
			Step_Start(7, "Enter the Delivery", test, test1);
			waitForElement(driver, delivery_search_icon_Fec);
			click(driver, delivery_search_icon_Fec);
//				selectValue(driver, condition, moduleData.get("Delivery"));
			twoColumnSearchWindow(driver, location_code_header_Fec, condition, moduleData.get("Delivery"));

			Step_End(7, "Enter the Delivery", test, test1);
			Step_Start(8, "Enter the Equipment type", test, test1);
			waitForElement(driver, equip_type_add_btn_Fec);
			click(driver, equip_type_add_btn_Fec);
//				selectValue2(driver, condition, equipmentType);
			twoColumnSearchWindow(driver, equipment_type_header_Fec, condition, equipmentType);

			Step_End(8, "Enter the Equipment type", test, test1);

			Step_Start(13, "Enter the Fixed Equipment cost", test, test1);
			waitForElement(driver, per_diem_txtfld_Fec);
			click(driver, per_diem_txtfld_Fec);
			waitForElement(driver, per_diem_txtfld_Fec);
			clearAndType(driver, per_diem_txtfld_Fec, per_diem_data_Fec);
			waitForElement(driver, per_diem_txtfld_Fec);
			click(driver, per_diem_txtfld_Fec);
			Step_End(13, "Enter the Fixed Equipment cost", test, test1);

			Step_Start(12, "Enter the empty", test, test1);
			waitForElement(driver, empty_txtfld_Fec);
			click(driver, empty_txtfld_Fec);
			waitForElement(driver, empty_txtfld_Fec);
			clear(driver, empty_txtfld_Fec);
			waitForElement(driver, empty_txtfld_Fec);
			sendKeys(driver, empty_txtfld_Fec, empty_field_data_Fec);
			click(driver, empty_txtfld_Fec);
			Step_End(12, "Enter the empty", test, test1);

			Step_Start(9, "Enter the Voyage time", test, test1);
			waitForElement(driver, voyage_time_txtfld_Fec);
			click(driver, voyage_time_txtfld_Fec);
			waitForElement(driver, voyage_time_txtfld_Fec);
			clear(driver, voyage_time_txtfld_Fec);
			waitForElement(driver, voyage_time_txtfld_Fec);
			sendKeys(driver, voyage_time_txtfld_Fec, voyage_time_data_Fec);
			click(driver, voyage_time_txtfld_Fec);
			Step_End(9, "Enter the Voyage time", test, test1);

			Step_Start(10, "Enter the out bound", test, test1);
			waitForElement(driver, outbound_txtfld_Fec);
			click(driver, outbound_txtfld_Fec);
			waitForElement(driver, outbound_txtfld_Fec);
			clear(driver, outbound_txtfld_Fec);
			waitForElement(driver, outbound_txtfld_Fec);
			sendKeys(driver, outbound_txtfld_Fec, outbound_data_Fec);
			waitForElement(driver, outbound_txtfld_Fec);
			click(driver, outbound_txtfld_Fec);

			Step_End(10, "Enter the out bound", test, test1);
			Step_Start(11, "Enter the inbound", test, test1);
			waitForElement(driver, inbound_txtfld_Fec);
			click(driver, inbound_txtfld_Fec);
			waitForElement(driver, inbound_txtfld_Fec);
			clear(driver, inbound_txtfld_Fec);
			waitForElement(driver, inbound_txtfld_Fec);
			sendKeys(driver, inbound_txtfld_Fec, inbound_data_Fec);
			waitForElement(driver, inbound_txtfld_Fec);
			click(driver, inbound_txtfld_Fec);

			Step_End(11, "Enter the inbound", test, test1);
			waitForElement(driver, per_diem_txtfld_Fec);
			click(driver, per_diem_txtfld_Fec);

			checkBox(driver, soc_checkbox_Fec, soc_flg_Fec);
			if (!container_type_data_Fec.equals("")) {
				String container_to_select = String.format(container_type_radio_btn_Fec, container_type_data_Fec);
				waitForElement(driver, container_to_select);
				click(driver, container_to_select);
			}
			if (!currency_data_Fec.equals("")) {
				waitForElement(driver, currency_dd_Fec);
				click(driver, currency_dd_Fec);
				String currency_to_select = String.format(currency_dd_options_Fec, currency_data_Fec);
				waitForElement(driver, currency_to_select);
				click(driver, currency_to_select);
			}
			if (!Start_Date.equals("")) {
				waitForElement(driver, start_date_Fec);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, start_date_Fec, Start_Date);
				} else {
					waitForElement(driver, start_date_Fec);
					clearAndType(driver, start_date_Fec, Start_Date);
				}
			}

			if (!End_Date.equals("")) {
				waitForElement(driver, End_date_Fec);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, End_date_Fec, End_Date);
				} else {
					waitForElement(driver, End_date_Fec);
					clearAndType(driver, End_date_Fec, End_Date);
				}
			}
			Step_Start(14, "Click save", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				waitForElement(driver, popup_Message);
				click(driver, popup_Message_Yes_Button);
			}
			Step_End(14, "Click save", test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);

			break;

		case "Imbalance Cost  Origin":
			moduleData.put("Origin", values[0].trim());
			scrollTop(driver);
			moduleNavigate(driver, ICO_Module_Name);
			scrollTop(driver);
			
			newButton(driver);
			
			waitForElement(driver, ICO_LocationField);
			sendKeys(driver, ICO_LocationField, moduleData.get("Origin"));
			waitForElement(driver, ICO_LocationButton);
			click(driver, ICO_LocationButton);
			twoColumnSearchWindow(driver, ICO_Location_Code_Header, condition, moduleData.get("Origin"));

			waitForElement(driver, ICO_EquipTypeButton);
			click(driver, ICO_EquipTypeButton);
			twoColumnSearchWindow(driver, ICO_Equip_Type_Header, condition, equipmentType);
			if (!Start_Date.equals("")) {
				waitForElement(driver, ICO_StartDate);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, ICO_StartDate, Start_Date);
				} else {
					waitForElement(driver, ICO_StartDate);
					clearAndType(driver, ICO_StartDate, Start_Date);
				}
			}
			if (!End_Date.equals("")) {
				waitForElement(driver, ICO_EndDate);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, ICO_EndDate, End_Date);
				} else {
					waitForElement(driver, ICO_EndDate);
					clearAndType(driver, ICO_EndDate, End_Date);
				}
			}
			waitForElement(driver, ICO_Amount_Field);
			clearAndType(driver, ICO_Amount_Field, ICO_Amount_Input);
			waitForElement(driver, ICO_Currency_DD);
			click(driver, ICO_Currency_DD);
			String currency_Select = String.format(DropDown_Select, ICO_Curreny_Input);
			waitForElement(driver, currency_Select);
			click(driver, currency_Select);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		case "Imbalance  Cost Delivery":
			scrollTop(driver);
			moduleNavigate(driver, ICD_Module_Name);
			moduleData.put("Delivery", values[0].trim());
			scrollTop(driver);
			
			newButton(driver);
			
			waitForElement(driver, ICD_DeliveryPortField);
			sendKeys(driver, ICD_DeliveryPortField, moduleData.get("Delivery"));
			waitForElement(driver, ICD_DeliveryPortButton);
			click(driver, ICD_DeliveryPortButton);
			twoColumnSearchWindow(driver, ICD_Delivery_Port_Column_Header, condition, moduleData.get("Delivery"));
			if (!ICD_Origin_Input.equals("")) {
				waitForElement(driver, ICD_OriginPortField);
				sendKeys(driver, ICD_OriginPortField, ICD_Origin_Input);
				waitForElement(driver, ICD_OriginPortButton);
				click(driver, ICD_OriginPortButton);
				twoColumnSearchWindow(driver, ICD_Origin_Port_Column_Header, condition, ICD_Origin_Input);
			}
			waitForElement(driver, ICD_EquipTypeButton);
			click(driver, ICD_EquipTypeButton);
			twoColumnSearchWindow(driver, ICD_Equip_Type_Column_Header, condition, equipmentType);
			if (!Start_Date.equals("")) {
				waitForElement(driver, ICD_StartDate);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, ICD_StartDate, Start_Date);
				} else {
					waitForElement(driver, ICD_StartDate);
					clearAndType(driver, ICD_StartDate, Start_Date);
				}
			}
			if (!End_Date.equals("")) {
				waitForElement(driver, ICD_EndDate);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, ICD_EndDate, End_Date);
				} else {
					waitForElement(driver, ICD_EndDate);
					clearAndType(driver, ICD_EndDate, End_Date);
				}
			}
			waitForElement(driver, ICD_Amount_Field);
			clearAndType(driver, ICD_Amount_Field, ICD_Amount_Input);
			waitForElement(driver, ICD_Currency_DD);
			click(driver, ICD_Currency_DD);
			String ICD_currency_Select = String.format(DropDown_Select, ICD_Curreny_Input);
			waitForElement(driver, ICD_currency_Select);
			click(driver, ICD_currency_Select);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		case "Claims":
			moduleData.put("Origin", values[0].trim());
			moduleData.put("Delivery", values[1].trim());
			scrollTop(driver);
			moduleNavigate(driver, claims_Module_Name);
			scrollTop(driver);
			
			newButton(driver);
			
			waitForElement(driver, claims_FromLocationButton);
			click(driver, claims_FromLocationButton);
			twoColumnSearchWindow(driver, claims_From_Location_Column_Header, condition, moduleData.get("Origin"));
			waitForElement(driver, claims_ToLocationButton);
			click(driver, claims_ToLocationButton);
			twoColumnSearchWindow(driver, claims_To_Location_Column_Header, condition, moduleData.get("Delivery"));
			waitForElement(driver, claims_EquipTypeButton);
			click(driver, claims_EquipTypeButton);
			twoColumnSearchWindow(driver, claims_Equip_Type_Column_Header, condition, equipmentType);
			if (!Start_Date.equals("")) {
				waitForElement(driver, claims_StartDate);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, claims_StartDate, Start_Date);
				} else {
					waitForElement(driver, claims_StartDate);
					clearAndType(driver, claims_StartDate, Start_Date);
				}
			}
			if (!End_Date.equals("")) {
				waitForElement(driver, claims_EndDate);
				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, claims_EndDate, End_Date);
				} else {
					waitForElement(driver, claims_EndDate);
					clearAndType(driver, claims_EndDate, End_Date);
				}
			}
			waitForElement(driver, claims_Amount_Field);
			clearAndType(driver, claims_Amount_Field, claims_Amount_Input);
			waitForElement(driver, claims_Currency_DD);
			click(driver, claims_Currency_DD);
			String claims_currency_Select = String.format(DropDown_Select, claims_Curreny_Input);
			waitForElement(driver, claims_currency_Select);
			click(driver, claims_currency_Select);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		case "Disc. Trans 1 Cost":
//			moduleNavigate(driver, moduleData.get(moduleName));
			moduleData.put("Origin", values[0].trim());
			moduleData.put("Terminal", values[1].trim());
			moduleData.put("Service", values[2].trim());

			transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_DT, equipmentType,
					container_Type_TCS_DT1, condition, moduleData, datePicker, activity_Type_TCS_DT1,
					local_Amount_TCS_DT1, activity_Type_Conditional_Behaviour_TSC_DT1,
					local_Amount_Conditional_Behaviour_TSC_DT1, Start_Date, End_Date, locationDetails_Filter_TC1,
					terminalDetails_Filter_TC1, servicelDetails_Filter_TC1, test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		case "Load Trans 1 Cost":
//			moduleNavigate(driver, moduleData.get(moduleName));
			moduleData.put("Origin", values[0].trim());
			moduleData.put("Terminal", values[1].trim());
			moduleData.put("Service", values[2].trim());

			transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_LT, equipmentType,
					container_Type_TCS_LT1, condition, moduleData, datePicker, activity_Type_TCS_LT1,
					local_Amount_TCS_LT1, activity_Type_Conditional_Behaviour_TSC_LT1,
					local_Amount_Conditional_Behaviour_TSC_LT1, Start_Date, End_Date, locationDetails_Filter_TC1,
					terminalDetails_Filter_TC1, servicelDetails_Filter_TC1, test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;
		case "Disc. Trans 2 Cost ":
//			moduleNavigate(driver, moduleData.get(moduleName));
			moduleData.put("Origin", values[0].trim());
			moduleData.put("Terminal", values[1].trim());
			moduleData.put("Service", values[2].trim());

			transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_DT, equipmentType,
					container_Type_TCS_DT2, condition, moduleData, datePicker, activity_Type_TCS_DT2,
					local_Amount_TCS_DT2, activity_Type_Conditional_Behaviour_TSC_DT2,
					local_Amount_Conditional_Behaviour_TSC_DT2, Start_Date, End_Date, locationDetails_Filter_TC2,
					terminalDetails_Filter_TC2, servicelDetails_Filter_TC2, test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		case "Load Trans 2 Cost":
//			moduleNavigate(driver, moduleData.get(moduleName));
			moduleData.put("Origin", values[0].trim());
			moduleData.put("Terminal", values[1].trim());
			moduleData.put("Service", values[2].trim());

			transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_LT, equipmentType,
					container_Type_TCS_LT2, condition, moduleData, datePicker, activity_Type_TCS_LT2,
					local_Amount_TCS_LT2, activity_Type_Conditional_Behaviour_TSC_LT2,
					local_Amount_Conditional_Behaviour_TSC_LT2, Start_Date, End_Date, locationDetails_Filter_TC2,
					terminalDetails_Filter_TC2, servicelDetails_Filter_TC2, test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		case "Disc. Trans 3 Cost ":
//			moduleNavigate(driver, moduleData.get(moduleName));
			moduleData.put("Origin", values[0].trim());
			moduleData.put("Terminal", values[1].trim());
			moduleData.put("Service", values[2].trim());

			transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_DT, equipmentType,
					container_Type_TCS_DT3, condition, moduleData, datePicker, activity_Type_TCS_DT3,
					local_Amount_TCS_DT3, activity_Type_Conditional_Behaviour_TSC_DT3,
					local_Amount_Conditional_Behaviour_TSC_DT3, Start_Date, End_Date, locationDetails_Filter_TC3,
					terminalDetails_Filter_TC3, servicelDetails_Filter_TC3, test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		case "Load Trans 3 Cost":
//			moduleNavigate(driver, moduleData.get(moduleName));
			moduleData.put("Origin", values[0].trim());
			moduleData.put("Terminal", values[1].trim());
			moduleData.put("Service", values[2].trim());

			transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_LT, equipmentType,
					container_Type_TCS_LT3, condition, moduleData, datePicker, activity_Type_TCS_LT3,
					local_Amount_TCS_LT3, activity_Type_Conditional_Behaviour_TSC_LT3,
					local_Amount_Conditional_Behaviour_TSC_LT3, Start_Date, End_Date, locationDetails_Filter_TC3,
					terminalDetails_Filter_TC3, servicelDetails_Filter_TC3, test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			break;

		default:
			System.out.println("Unknown Module: " + moduleName);
			break;
		}

	}

}
	public void parseEquipmentData(WebDriver driver, String input, ExtentTest test, ExtentTest test1,
			String selected_dataset) {

		Map<String, String> Data = Utils.GetAllData("Common_Data", "Common_Cost_Datas", "Dataset" + selected_dataset,"TestData_Commercial");
		String condition = Data.get("condition");
		String datePicker = Data.get("datePicker");
		String Start_Date = Data.get("Start_Date");
		String End_Date = Data.get("End_Date");
		String Fec_module = Data.get("Fec_module");
		String Ac_module = Data.get("Ac_module");
		String External_Feeder_Cost_Module = Data.get("External_Feeder_Cost_Module");
		String transshipmentCost_Module = Data.get("TranshipmentCost_Module");
		String equipment_Operation_cost_Origin_Module = Data.get("equipment_Operation_cost_Origin_Module");
		String Condition_filter_C = Data.get("Condition_filter_C");
		String amount_C = Data.get("amount_C");
		String amount_Type_C = Data.get("amount_Type_C");
		String cost_Origin_Saved_Popup_C = Data.get("cost_Origin_Saved_Popup_C");
		String dischargeCost_Module = Data.get("DischargeCost_Module");
		String container_Type_DSC = Data.get("Container_Type_DSC");
		String local_Amount_DSC = Data.get("Local_Amount_DSC");
		String in_Transist_Checkbox_DSC = Data.get("In_Transist_Checkbox_DSC");
		String port_Code_DSC = Data.get("Port_Code_DSC");
		String activity_Type_Conditional_Behaviour_DSC = Data.get("Activity_Type_Conditional_Behaviour_DSC");
		String local_Amount_Conditional_Behaviour_DSC = Data.get("Local_Amount_Conditional_Behaviour_DSC");
		String activity_Type_DSC = Data.get("Activity_Type_DSC");
		String currency_data_Ac = Data.get("currency_data_Ac");
		String radio_btn_data_Ac = Data.get("radio_btn_data_Ac");
		String soc_flag_Ac = Data.get("soc_flag_Ac");
		String container_type_data_Ac = Data.get("container_type_data_Ac");
		String bl_type_data_Ac = Data.get("bl_type_data_Ac");
		String amount_data_Ac = Data.get("amount_data_Ac");
		String loadCost_Module = Data.get("LoadCost_Module");
		String container_Type_LDC = Data.get("Container_Type_LDC");
		String local_Amount_LDC = Data.get("Local_Amount_LDC");
		String in_Transist_Checkbox_LDC = Data.get("In_Transist_Checkbox_LDC");
		String port_Code_LDC = Data.get("Port_Code_LDC");
		String activity_Type_LDC = Data.get("Activity_Type_LDC");
		String activity_Type_Conditional_Behaviour_LDC = Data.get("Activity_Type_Conditional_Behaviour_LDC");
		String local_Amount_Conditional_Behaviour_LDC = Data.get("Local_Amount_Conditional_Behaviour_LDC");
		String soc_flg_Fec = Data.get("soc_flg_Fec");
		String container_type_data_Fec = Data.get("container_type_data_Fec");
		String service_data_Fec = Data.get("service_data_Fec");
		String currency_data_Fec = Data.get("currency_data_Fec");
		String voyage_time_data_Fec = Data.get("voyage_time_data_Fec");
		String outbound_data_Fec = Data.get("outbound_data_Fec");
		String inbound_data_Fec = Data.get("inbound_data_Fec");
		String empty_field_data_Fec = Data.get("empty_field_data_Fec");
		String per_diem_data_Fec = Data.get("per_diem_data_Fec");
		String ICO_Module_Name = Data.get("ICO_Module_Name");
		String ICO_Amount_Input = Data.get("ICO_Amount_Input");
		String ICO_Curreny_Input = Data.get("ICO_Curreny_Input");
		String ICO_Location_Code_Header = Data.get("ICO_Location_Code_Header");
		String ICO_Equip_Type_Header = Data.get("ICO_Equip_Type_Header");
		String ICD_Origin_Input = Data.get("ICD_Origin_Input");
		String ICD_Module_Name = Data.get("ICD_Module_Name");
		String ICD_Amount_Input = Data.get("ICD_Amount_Input");
		String ICD_Curreny_Input = Data.get("ICD_Curreny_Input");
		String ICD_Delivery_Port_Column_Header = Data.get("ICD_Delivery_Port_Column_Header");
		String ICD_Origin_Port_Column_Header = Data.get("ICD_Origin_Port_Column_Header");
		String ICD_Equip_Type_Column_Header = Data.get("ICD_Equip_Type_Column_Header");
		String claims_Module_Name = Data.get("claims_Module_Name");
		String claims_Amount_Input = Data.get("claims_Amount_Input");
		String claims_From_Location_Column_Header = Data.get("claims_From_Location_Column_Header");
		String claims_To_Location_Column_Header = Data.get("claims_To_Location_Column_Header");
		String claims_Equip_Type_Column_Header = Data.get("claims_Equip_Type_Column_Header");
		String claims_Curreny_Input = Data.get("claims_Curreny_Input");
		String container_Type_TCS_DT1 = Data.get("Container_Type_TCS_DT1");
		String local_Amount_TCS_DT1 = Data.get("Local_Amount_TCS_DT1");
		String activity_Type_TCS_DT1 = Data.get("Activity_Type_TCS_DT1");
		String transhipmentType_TCS_DT = Data.get("TranshipmentType_TCS_DT");
		String activity_Type_Conditional_Behaviour_TSC_DT1 = Data.get("Activity_Type_Conditional_Behaviour_TSC_DT1");
		String local_Amount_Conditional_Behaviour_TSC_DT1 = Data.get("Local_Amount_Conditional_Behaviour_TSC_DT1");
		String equipment_Operation_cost_Delivery_Module = Data.get("equipment_Operation_cost_Delivery_Module");
		String Condition_filter_D = Data.get("Condition_filter_D");
		String amount_D = Data.get("amount_D");
		String amount_Type_D = Data.get("amount_Type_D");
		String cost_Delivery_Saved_Popup_D = Data.get("cost_Delivery_Saved_Popup_D");
		String container_Type_TCS_LT1 = Data.get("Container_Type_TCS_LT1");
		String local_Amount_TCS_LT1 = Data.get("Local_Amount_TCS_LT1");
		String activity_Type_TCS_LT1 = Data.get("Activity_Type_TCS_LT1");
		String transhipmentType_TCS_LT = Data.get("TranshipmentType_TCS_LT");
		String activity_Type_Conditional_Behaviour_TSC_LT1 = Data.get("Activity_Type_Conditional_Behaviour_TSC_LT1");
		String local_Amount_Conditional_Behaviour_TSC_LT1 = Data.get("Local_Amount_Conditional_Behaviour_TSC_LT1");
		String container_Type_TCS_DT2 = Data.get("Container_Type_TCS_DT2");
		String local_Amount_TCS_DT2 = Data.get("Local_Amount_TCS_DT2");
		String activity_Type_TCS_DT2 = Data.get("Activity_Type_TCS_DT2");
		String activity_Type_Conditional_Behaviour_TSC_DT2 = Data.get("Activity_Type_Conditional_Behaviour_TSC_DT2");
		String local_Amount_Conditional_Behaviour_TSC_DT2 = Data.get("Local_Amount_Conditional_Behaviour_TSC_DT2");
		String container_Type_TCS_LT2 = Data.get("Container_Type_TCS_LT2");
		String local_Amount_TCS_LT2 = Data.get("Local_Amount_TCS_LT2");
		String activity_Type_TCS_LT2 = Data.get("Activity_Type_TCS_LT2");
		String activity_Type_Conditional_Behaviour_TSC_LT2 = Data.get("Activity_Type_Conditional_Behaviour_TSC_LT2");
		String local_Amount_Conditional_Behaviour_TSC_LT2 = Data.get("Local_Amount_Conditional_Behaviour_TSC_LT2");
		String container_Type_TCS_DT3 = Data.get("Container_Type_TCS_DT3");
		String local_Amount_TCS_DT3 = Data.get("Local_Amount_TCS_DT3");
		String activity_Type_TCS_DT3 = Data.get("Activity_Type_TCS_DT3");
		String activity_Type_Conditional_Behaviour_TSC_DT3 = Data.get("Activity_Type_Conditional_Behaviour_TSC_DT3");
		String local_Amount_Conditional_Behaviour_TSC_DT3 = Data.get("Local_Amount_Conditional_Behaviour_TSC_DT3");
		String container_Type_TCS_LT3 = Data.get("Container_Type_TCS_LT3");
		String local_Amount_TCS_LT3 = Data.get("Local_Amount_TCS_LT3");
		String activity_Type_TCS_LT3 = Data.get("Activity_Type_TCS_LT3");
		String activity_Type_Conditional_Behaviour_TSC_LT3 = Data.get("Activity_Type_Conditional_Behaviour_TSC_LT3");
		String local_Amount_Conditional_Behaviour_TSC_LT3 = Data.get("Local_Amount_Conditional_Behaviour_TSC_LT3");

		String Container_External_feeder1 = Data.get("Container_External_feeder1");
		String Activity_Code_External_amount1 = Data.get("Activity_Code_External_amount1");
		String Activity_Code_External1 = Data.get("Activity_Code_External1");
		String Condition_Equipment_group_External_feeder1 = Data.get("Condition_Equipment_group_External_feeder1");
		String Condition_Activity_Code_External1 = Data.get("Condition_Activity_Code_External1");
		String Container_External_feeder2 = Data.get("Container_External_feeder2");
		String Activity_Code_External_amount2 = Data.get("Activity_Code_External_amount2");
		String Activity_Code_External2 = Data.get("Activity_Code_External2");
		String Condition_Equipment_group_External_feeder2 = Data.get("Condition_Equipment_group_External_feeder2");
		String Condition_Activity_Code_External2 = Data.get("Condition_Activity_Code_External2");
		String Container_External_feeder3 = Data.get("Container_External_feeder3");
		String Activity_Code_External_amount3 = Data.get("Activity_Code_External_amount3");
		String Activity_Code_External3 = Data.get("Activity_Code_External3");
		String Condition_Equipment_group_External_feeder3 = Data.get("Condition_Equipment_group_External_feeder3");
		String Condition_Activity_Code_External3 = Data.get("Condition_Activity_Code_External3");
		String Container_External_feeder4 = Data.get("Container_External_feeder4");
		String Activity_Code_External_amount4 = Data.get("Activity_Code_External_amount4");
		String Activity_Code_External4 = Data.get("Activity_Code_External4");
		String Condition_Equipment_group_External_feeder4 = Data.get("Condition_Equipment_group_External_feeder4");
		String Condition_Activity_Code_External4 = Data.get("Condition_Activity_Code_External4");
		String Haulage_Cost_Module = Data.get("Haulage_Cost_Module");
		String From_Terminal_code_Haulage = Data.get("From_Terminal_code_Haulage");
		String To_Terminal_Haulage = Data.get("To_Terminal_Haulage");
		String Container_Haulage = Data.get("Container_Haulage");
		String Activity_Code_Haulage_amount = Data.get("Activity_Code_Haulage_amount");
		String Activity_Code_Haulage = Data.get("Activity_Code_Haulage");
		String Condition_Equipment_group_Haulage = Data.get("Condition_Equipment_group_Haulage");
		String Condition_Activity_Code_Haulage = Data.get("Condition_Activity_Code_Haulage");
		String To_Terminal_CodeHaulage = Data.get("To_Terminal_CodeHaulage");
		String To_Location_CodeHaulage = Data.get("To_Location_CodeHaulage");
		String From_Location_code_Haulage = Data.get("From_Location_code_Haulage");
		String From_Terminal_CodeHaulage = Data.get("From_Terminal_CodeHaulage");

		From_Location_External = Data.get("From_Location_External");
		From_Terminal_External = Data.get("From_Terminal_External");
		To_Location_External = Data.get("To_Location_External");
		To_Terminal_External = Data.get("To_Terminal_External");
		Service_External = Data.get("Service_External");

		String locationDetails_Filter_DC = Data.get("locationDetails_Filter_DC");
		String terminalDetails_Filter_DC = Data.get("terminalDetails_Filter_DC");
		String servicelDetails_Filter_DC = Data.get("servicelDetails_Filter_DC");

		String locationDetails_Filter_LC = Data.get("locationDetails_Filter_LC");
		String terminalDetails_Filter_LC = Data.get("terminalDetails_Filter_LC");
		String servicelDetails_Filter_LC = Data.get("servicelDetails_Filter_LC");

		String locationDetails_Filter_TC1 = Data.get("locationDetails_Filter_TC1");
		String terminalDetails_Filter_TC1 = Data.get("terminalDetails_Filter_TC1");
		String servicelDetails_Filter_TC1 = Data.get("servicelDetails_Filter_TC1");
		String locationDetails_Filter_TC2 = Data.get("locationDetails_Filter_TC2");
		String terminalDetails_Filter_TC2 = Data.get("terminalDetails_Filter_TC2");
		String servicelDetails_Filter_TC2 = Data.get("servicelDetails_Filter_TC2");
		String locationDetails_Filter_TC3 = Data.get("locationDetails_Filter_TC3");
		String terminalDetails_Filter_TC3 = Data.get("terminalDetails_Filter_TC3");
		String servicelDetails_Filter_TC3 = Data.get("servicelDetails_Filter_TC3");
		String Equip_Type_Header_C = Data.get("Equip_Type_Header_C");
		String Port_Code_Header_C = Data.get("Port_Code_Header_C");
		String Location_Code_Header_D = Data.get("Location_Code_Header_D");
		String Equip_Type_Header_D = Data.get("Equip_Type_Header_D");

		String portCodeDetails_Filter_DC = Data.get("portCodeDetails_Filter_DC");
		String portCodeDetails_Filter_LC = Data.get("portCodeDetails_Filter_LC");

		// FEC HEADERS
		String service_code_header_Fec = Data.get("service_code_header_Fec");
		String location_code_header_Fec = Data.get("location_code_header_Fec");
		String equipment_type_header_Fec = Data.get("equipment_type_header_Fec");

		// ADMIN COST HEADERS

		String service_code_header_Ac = Data.get("service_code_header_Ac");

		String equipmentType = "";

		// Extract Equipment Type (first line before #)
		String[] inputParts = input.split("#", 2);
		if (inputParts[0].contains("Equipment Type :")) {
			equipmentType = inputParts[0].split(":")[1].trim();
		}
		// Split sections based on #
		String[] sections = input.split("#");
		for (String section : sections) {
			if (section.trim().isEmpty())
				continue;

			String[] parts = section.split(" - ");
			if (parts.length < 2)
				continue;
			String moduleName = parts[0].trim();
			String[] values = parts[1].split(",");
			Map<String, String> moduleData = new LinkedHashMap<>();
			moduleData.put("Module Name", moduleName);
			moduleData.put("Equipment Type", equipmentType); // Use extracted Equipment Type
			switch (moduleName) {
			case "Discharge Cost":
				moduleData.put("Port Name", values[0].trim());
				moduleData.put("Terminal", values[1].trim());
				moduleData.put("Service", values[2].trim());
				moduleData.put("T.service", values[4].trim());
				String t_Service_DSC = moduleData.get("T.service");
				if (moduleData.get("T.service").contains("CY")) {
					t_Service_DSC = "CONTAINER YARD";
				} else if (moduleData.get("T.service").contains("CT")) {
					t_Service_DSC = "CONTAINER TERMINAL";
				}
				String eqp_Group_DSC = moduleData.get("Equipment Type");
				if (moduleData.get("Equipment Type").contains("2")) {
					eqp_Group_DSC = "20S";
				} else if (moduleData.get("Equipment Type").contains("4")) {
					eqp_Group_DSC = "40S";
				} else {
					eqp_Group_DSC = "20S";
				}
				Step_Start(1, "Open the screen through module search.", test, test1);
				scrollTop(driver);
				moduleNavigate(driver, dischargeCost_Module);
				Step_End(1, "Open the screen through module search.", test, test1);
				Step_Start(2, "Click new button.", test, test1);
				scrollTop(driver);

				newButton(driver);

				Step_End(2, "Click new button.", test, test1);

				String select_Container_Type_DC = String.format(containerType_RadioButton_DC, container_Type_DSC);
				waitForElement(driver, select_Container_Type_DC);
				click(driver, select_Container_Type_DC);
				Step_Start(3, "Enter the load port.", test, test1);
				waitForElement(driver, location_SearchButton_DC);
				click(driver, location_SearchButton_DC);

				twoColumnSearchWindow(driver, locationDetails_Filter_DC, condition, moduleData.get("Port Name"));

				Step_End(3, "Enter the load port.", test, test1);
				Step_Start(4, "Enter the load terminal.", test, test1);
				waitForElement(driver, terminal_SearchButton_DC);
				click(driver, terminal_SearchButton_DC);

				twoColumnSearchWindow(driver, terminalDetails_Filter_DC, condition, moduleData.get("Terminal"));

				Step_End(4, "Enter the load terminal.", test, test1);
				Step_Start(5, "Enter the Equipment group", test, test1);
				waitForElement(driver, eqp_Group_Dropdown_DC);
				click(driver, eqp_Group_Dropdown_DC);
				String eqpGroup_DC = String.format(DropDown_Select, eqp_Group_DSC);
				waitForElement(driver, eqpGroup_DC);
				click(driver, eqpGroup_DC);
				Step_End(5, "Enter the Equipment group", test, test1);
				Step_Start(6, "Enter the Tservice", test, test1);
				waitForElement(driver, t_Service_Dropdown_DC);
				click(driver, t_Service_Dropdown_DC);
				String T_Service_DC = String.format(DropDown_Select, t_Service_DSC);
				waitForElement(driver, T_Service_DC);
				click(driver, T_Service_DC);
				Step_End(6, "Enter the Tservice", test, test1);
				Step_Start(7, "Enter the service", test, test1);
				waitForElement(driver, service_SearchButton_DC);
				click(driver, service_SearchButton_DC);

				twoColumnSearchWindow(driver, servicelDetails_Filter_DC, condition, moduleData.get("Service"));

				Step_End(7, "Enter the service", test, test1);
				if (!Start_Date.equals("")) {

					waitForElement(driver, fromDate_DC);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, fromDate_DC, Start_Date);
					} else {
						waitForElement(driver, fromDate_DC);
						clearAndType(driver, fromDate_DC, Start_Date);
					}
				}
				if (!End_Date.equals("")) {

					waitForElement(driver, toDate_DC);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, toDate_DC, End_Date);
					} else {
						waitForElement(driver, toDate_DC);
						clearAndType(driver, toDate_DC, End_Date);
					}
				}
				if (in_Transist_Checkbox_DSC.equalsIgnoreCase("Yes")) {
					waitForDisplay(driver, in_Transist_Checkbox_DC);
					checkBox(driver, in_Transist_Checkbox_DC, in_Transist_Checkbox_DSC);
					waitForDisplay(driver, pol_Add_Button_DC);
					click(driver, pol_Add_Button_DC);
					twoColumnSearchWindow(driver, portCodeDetails_Filter_DC, condition, port_Code_DSC);

				}
				Step_Start(8, "Enter the amount in the local amount column", test, test1);
				List<String> activity_Types_DSC = splitAndExpand(activity_Type_DSC);
				List<String> local_Amounts_DSC = splitAndExpand(local_Amount_DSC);
				for (int i = 0; i < activity_Types_DSC.size(); i++) {
					String activityType_DSC = activity_Types_DSC.get(i);
					String localAmount_DSC = local_Amounts_DSC.get(i);
					String localAmount = String.format(standardCost_Table_LocalAmount_DC, activityType_DSC);
					waitForElement(driver, localAmount);
					click(driver, localAmount);
					if (!activityType_DSC.equals(" ") && !localAmount_DSC.equals(" ")) {
						String localAmount_Input_DSC = String.format(standardCost_Table_LocalAmount_Input_DC,
								activityType_DSC);
						waitForElement(driver, localAmount_Input_DSC);
						clearAndType(driver, localAmount_Input_DSC, localAmount_DSC);
					}
					waitForElement(driver, standardCost_Table_Rows_DC);
					click(driver, standardCost_Table_Rows_DC);
				}
				waitForElement(driver, standardCost_Table_Rows_DC);
				click(driver, standardCost_Table_Rows_DC);
				// Conditional Behaviour
				List<String> activity_Types_Condi_DSC = splitAndExpand(activity_Type_Conditional_Behaviour_DSC);
				List<String> local_Amounts_Condi_DSC = splitAndExpand(local_Amount_Conditional_Behaviour_DSC);
				for (int i = 0; i < activity_Types_Condi_DSC.size(); i++) {
					String activityType = activity_Types_Condi_DSC.get(i);
					String localAmount_DSC = local_Amounts_Condi_DSC.get(i);
					String localAmount = String.format(conditional_Behaviour_Cost_LocalAmount_DC, activityType);
					waitForElement(driver, localAmount);
					click(driver, localAmount);
					if (!activityType.equals(" ") && !localAmount_DSC.equals(" ")) {
						String localAmount_Input = String.format(conditional_Behaviour_Cost_LocalAmount_Input_DC,
								activityType);
						waitForElement(driver, localAmount_Input);
						clearAndType(driver, localAmount_Input, localAmount_DSC);
					}
					waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_DC);
					click(driver, conditional_Behaviour_Cost_Table_Rows_DC);
				}
				waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_DC);
				click(driver, conditional_Behaviour_Cost_Table_Rows_DC);
				Step_End(8, "Enter the amount in the local amount column", test, test1);
				Step_Start(9, "Click save", test, test1);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				waitForDisplay(driver, popup_Message_Yes_Button);
				if (isdisplayed(driver, popup_Message_Yes_Button)) {
					click(driver, popup_Message_Yes_Button);
				}
				waitForDisplay(driver, popup_Message_Yes_Button);
				if (isdisplayed(driver, popup_Message_Yes_Button)) {
					click(driver, popup_Message_Yes_Button);
				}
				Step_End(9, "Click save", test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			case "Admin Cost":
				moduleData.put("Service", values[0].trim());
				Step_Start(1, "Open the screen through module search", test, test1);
				scrollTop(driver);
				moduleNavigate(driver, Ac_module);
				Step_End(1, "Open the screen through module search", test, test1);
				Step_Start(2, "Click new button", test, test1);
				scrollTop(driver);
				newButton(driver);
				Step_End(2, "Click new button", test, test1);
				Step_Start(3, "Enter the service", test, test1);
				waitForElement(driver, service_search_icon_Ac);
				click(driver, service_search_icon_Ac);
				twoColumnSearchWindow(driver, service_code_header_Ac, condition, moduleData.get("Service"));

				Step_End(3, "Enter the service", test, test1);
				// non-mandadtory
				if (!currency_data_Ac.equals("")) {
					waitForElement(driver, currency_dd_Ac);
					click(driver, currency_dd_Ac);
					String currency_value = String.format(currency_dd_value_Ac, currency_data_Ac);
					waitForElement(driver, currency_value);
					click(driver, currency_value);
				}
				if (!radio_btn_data_Ac.equals("")) {
					String radio_btn_to_click = String.format(radio_btn_Ac, radio_btn_data_Ac);
					waitForElement(driver, radio_btn_to_click);
					click(driver, radio_btn_to_click);
				}
				checkBox(driver, soc_chckbox_Ac, soc_flag_Ac);
				if (!container_type_data_Ac.equals("")) {
					String container_type_to_select = String.format(container_type_radio_btn_Ac,
							container_type_data_Ac);
					waitForElement(driver, container_type_to_select);
					click(driver, container_type_to_select);
				}
				if (!bl_type_data_Ac.equals("")) {
					waitForElement(driver, bl_type_label_Ac);
					click(driver, bl_type_label_Ac);
					String bl_type_to_select = String.format(bl_type_options_Ac, bl_type_data_Ac);
					waitForElement(driver, bl_type_to_select);
					click(driver, bl_type_to_select);
				}
				if (!Start_Date.equals("")) {
					waitForElement(driver, start_date_Ac);
					selectDatePicker(driver, start_date_Ac, Start_Date);
				} else {
					clearAndType(driver, start_date_Ac, Start_Date);
				}
				if (!End_Date.equals("")) {
					waitForElement(driver, End_date_Ac);
					selectDatePicker(driver, End_date_Ac, End_Date);
				} else {
					clearAndType(driver, End_date_Ac, End_Date);
				}
				Step_Start(4, "Enter the amount", test, test1);
				waitForElement(driver, amount_txtfld_Ac);
				sendKeys(driver, amount_txtfld_Ac, amount_data_Ac);
				Step_End(4, "Enter the amount", test, test1);
				Step_Start(5, "Click save", test, test1);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				Step_End(5, "Click save", test, test1);
				
				waitForDisplay(driver, popup_Message_Yes_Button);
				if(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
				}
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			case "Loading Cost":
				moduleData.put("Port Name", values[0].trim());
				moduleData.put("Terminal", values[1].trim());
				moduleData.put("Service", values[2].trim());
				moduleData.put("T.service", values[4].trim());
				String t_Service_LDC = moduleData.get("T.service");
				if (moduleData.get("T.service").contains("CY")) {
					t_Service_LDC = "CONTAINER YARD";
				} else if (moduleData.get("T.service").contains("CT")) {
					t_Service_LDC = "CONTAINER YARD";
				}
				String eqp_Group_LDC = moduleData.get("Equipment Type");
				if (moduleData.get("Equipment Type").contains("2")) {
					eqp_Group_LDC = "20S";
				} else if (moduleData.get("Equipment Type").contains("4")) {
					eqp_Group_LDC = "40S";
				} else {
					eqp_Group_LDC = "20S";
				}
				Step_Start(1, "Open the screen through module search.", test, test1);
				moduleNavigate(driver, loadCost_Module);
				Step_End(1, "Open the screen through module search.", test, test1);
				Step_Start(2, "Click new button.", test, test1);
				newButton(driver);
				Step_End(2, "Click new button.", test, test1);
				String select_Container_Type = String.format(containerType_RadioButton_LC, container_Type_LDC);
				waitForElement(driver, select_Container_Type);
				click(driver, select_Container_Type);
				Step_Start(3, "Enter the load port.", test, test1);
				waitForElement(driver, location_SearchButton_LC);
				click(driver, location_SearchButton_LC);

				twoColumnSearchWindow(driver, locationDetails_Filter_LC, condition, moduleData.get("Port Name"));

				Step_End(3, "Enter the load port.", test, test1);
				Step_Start(4, "Enter the load terminal.", test, test1);
				waitForElement(driver, terminal_SearchButton_LC);
				click(driver, terminal_SearchButton_LC);

				twoColumnSearchWindow(driver, terminalDetails_Filter_LC, condition, moduleData.get("Terminal"));

				Step_End(4, "Enter the load terminal.", test, test1);
				Step_Start(5, "Enter the Equipment group", test, test1);
				waitForElement(driver, eqp_Group_Dropdown_LC);
				click(driver, eqp_Group_Dropdown_LC);
				String eqpGroup = String.format(DropDown_Select, eqp_Group_LDC);
				waitForElement(driver, eqpGroup);
				click(driver, eqpGroup);
				Step_End(5, "Enter the Equipment group", test, test1);
				Step_Start(6, "Enter the Tservice", test, test1);
				waitForElement(driver, t_Service_Dropdown_LC);
				click(driver, t_Service_Dropdown_LC);
				String T_Service = String.format(DropDown_Select, t_Service_LDC);
				waitForElement(driver, T_Service);
				click(driver, T_Service);
				Step_End(6, "Enter the Tservice", test, test1);
				Step_Start(7, "Enter the service", test, test1);
				waitForElement(driver, service_SearchButton_LC);
				click(driver, service_SearchButton_LC);

				twoColumnSearchWindow(driver, servicelDetails_Filter_LC, condition, moduleData.get("Service"));

				Step_End(7, "Enter the service", test, test1);
				if (!Start_Date.equals("")) {
					waitForElement(driver, fromDate_LC);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, fromDate_LC, Start_Date);
					} else {
						waitForElement(driver, fromDate_LC);
						clearAndType(driver, fromDate_LC, Start_Date);
					}
				}
				if (!End_Date.equals("")) {

					waitForElement(driver, toDate_LC);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, toDate_LC, End_Date);
					} else {
						waitForElement(driver, toDate_LC);
						clearAndType(driver, toDate_LC, End_Date);
					}
				}
				if (in_Transist_Checkbox_LDC.equalsIgnoreCase("Yes")) {
					waitForDisplay(driver, in_Transist_Checkbox_LC);
					checkBox(driver, in_Transist_Checkbox_LC, in_Transist_Checkbox_LDC);
					waitForDisplay(driver, pol_Add_Button_LC);
					click(driver, pol_Add_Button_LC);
					twoColumnSearchWindow(driver, portCodeDetails_Filter_LC, condition, port_Code_LDC);

				}
				Step_Start(8, "Enter the amount in the local amount column", test, test1);
				List<String> activity_Types_LDC = splitAndExpand(activity_Type_LDC);
				List<String> local_Amounts_LDC = splitAndExpand(local_Amount_LDC);
				for (int i = 0; i < activity_Types_LDC.size(); i++) {
					String activityType = activity_Types_LDC.get(i);
					String localAmount_LDC = local_Amounts_LDC.get(i);
					String localAmount = String.format(standardCost_Table_LocalAmount_LC, activityType);
					waitForElement(driver, localAmount);
					click(driver, localAmount);
					if (!activityType.equals(" ") && !localAmount_LDC.equals(" ")) {
						String localAmount_Input = String.format(standardCost_Table_LocalAmount_Input_LC, activityType);
						waitForElement(driver, localAmount_Input);
						clearAndType(driver, localAmount_Input, localAmount_LDC);
					}
					waitForElement(driver, standardCost_Table_Rows_LC);
					click(driver, standardCost_Table_Rows_LC);
				}
				waitForElement(driver, standardCost_Table_Rows_LC);
				click(driver, standardCost_Table_Rows_LC);
				// Conditional Behaviour
				List<String> activity_Types_LDC1 = splitAndExpand(activity_Type_Conditional_Behaviour_LDC);
				List<String> local_Amounts_LDC1 = splitAndExpand(local_Amount_Conditional_Behaviour_LDC);
				for (int i = 0; i < activity_Types_LDC1.size(); i++) {
					String activityType = activity_Types_LDC1.get(i);
					String localAmount_LDC = local_Amounts_LDC1.get(i);
					String localAmount = String.format(conditional_Behaviour_Cost_LocalAmount_LC, activityType);
					waitForElement(driver, localAmount);
					click(driver, localAmount);
					if (!activityType.equals(" ") && !localAmount_LDC.equals(" ")) {
						String localAmount_Input = String.format(conditional_Behaviour_Cost_LocalAmount_Input_LC,
								activityType);
						waitForElement(driver, localAmount_Input);
						clearAndType(driver, localAmount_Input, localAmount_LDC);
					}
					waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_LC);
					click(driver, conditional_Behaviour_Cost_Table_Rows_LC);
				}
				waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_LC);
				click(driver, conditional_Behaviour_Cost_Table_Rows_LC);
				Step_End(8, "Enter the amount in the local amount column", test, test1);
				Step_Start(9, "Click save", test, test1);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Yes_Button);
				}
				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Yes_Button);
				}
				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Yes_Button);
				}
				Step_End(9, "Click save", test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			case "Load Haulage Cost":
				moduleData.put("From_location", values[0].trim());
				moduleData.put("To_Location", values[1].trim());
				waitForElement(driver, Routing_click);
				click(driver, Routing_click);
				String mode_value = getText(driver, get_mode);
				System.out.println("Mode Value: " + mode_value);
				switch (mode_value) {
				case "R":
					mode_value = "Rail";
					break;
				case "T":
					mode_value = "Truck";
					break;
				case "C":
					mode_value = "Combined";
					break;
				case "B":
					mode_value = "Barge";
					break;
				}
				waitForElement(driver, Routing_click_close);
				click(driver, Routing_click_close);
				String equipment_group = String.format(Rate_Request_Loactors.select_type, equipmentType);
				String container_click = String.format(Rate_Request_Loactors.Container_type_internal_feeder,
						Container_Haulage);
				String mode = String.format(Rate_Request_Loactors.select_type, mode_value);
				scrollTop(driver);
				moduleNavigate(driver, Haulage_Cost_Module);
				scrollTop(driver);
				newButton(driver);
				waitForElement(driver, container_click);
				click(driver, container_click);
				waitForElement(driver, From_location_search_Haulage);
				click(driver, From_location_search_Haulage);

				twoColumnSearchWindow(driver, From_Location_code_Haulage, condition, moduleData.get("From_location"));

				waitForElement(driver, From_terminal_search_Haulage);
				click(driver, From_terminal_search_Haulage);
				twoColumnSearchWindow(driver, From_Terminal_CodeHaulage, condition, From_Terminal_code_Haulage);

				waitForElement(driver, TO_location_search_Haulage);
				click(driver, TO_location_search_Haulage);
				twoColumnSearchWindow(driver, To_Location_CodeHaulage, condition, moduleData.get("To_Location"));
				waitForElement(driver, to_terminal_search_Haulage);
				click(driver, to_terminal_search_Haulage);
				twoColumnSearchWindow(driver, To_Terminal_CodeHaulage, condition, To_Terminal_Haulage);
				waitForElement(driver, mode_Haulage_click);
				click(driver, mode_Haulage_click);
				waitForElement(driver, mode);
				click(driver, mode);
				if (!Start_Date.equals("")) {
					waitForElement(driver, start_date_Haulage);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, start_date_Haulage, Start_Date);
					} else {
						waitForElement(driver, start_date_Haulage);
						clearAndType(driver, start_date_Haulage, Start_Date);
					}
				}
				if (!End_Date.equals("")) {
					waitForElement(driver, to_date_Haulage);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, to_date_Haulage, End_Date);
					} else {
						waitForElement(driver, to_date_Haulage);
						clearAndType(driver, to_date_Haulage, End_Date);
					}
				}
				waitForElement(driver, eqp_group_dd_Haulage);
				click(driver, eqp_group_dd_Haulage);
				waitForElement(driver, equipment_group);
				click(driver, equipment_group);
				List<String> activity_Types_DSC1 = splitAndExpand(Activity_Code_Haulage);
				List<String> local_Amounts_DSC1 = splitAndExpand(Activity_Code_Haulage_amount);
				for (int i = 0; i < activity_Types_DSC1.size(); i++) {
					String activityType_DSC = activity_Types_DSC1.get(i);
					String localAmount_DSC = local_Amounts_DSC1.get(i);
					String localAmount = String.format(Rate_Request_Loactors.standardCost_Table_LocalAmount_HC,
							activityType_DSC);
					waitForElement(driver, localAmount);
					click(driver, localAmount);
					if (!activityType_DSC.equals(" ") && !localAmount_DSC.equals(" ")) {
						String localAmount_Input_DSC = String.format(standardCost_Table_LocalAmount_Input_HC,
								activityType_DSC);
						waitForElement(driver, localAmount_Input_DSC);
						clearAndType(driver, localAmount_Input_DSC, localAmount_DSC);
					}
					waitForElement(driver, standardCost_Table_Rows_HC);
					click(driver, standardCost_Table_Rows_HC);
				}
				waitForElement(driver, standardCost_Table_Rows_HC);
				click(driver, standardCost_Table_Rows_HC);
				// Conditional Behaviour
				List<String> activity_Types_Condi_DSC1 = splitAndExpand(Condition_Activity_Code_Haulage);
				List<String> local_Amounts_Condi_DSC1 = splitAndExpand(Condition_Equipment_group_Haulage);
				for (int i = 0; i < activity_Types_Condi_DSC1.size(); i++) {
					String activityType = activity_Types_Condi_DSC1.get(i);
					String localAmount_DSC = local_Amounts_Condi_DSC1.get(i);
					String localAmount = String.format(conditional_Behaviour_Cost_LocalAmount_HC, activityType);
					waitForElement(driver, localAmount);
					click(driver, localAmount);
					if (!activityType.equals(" ") && !localAmount_DSC.equals(" ")) {
						String localAmount_Input = String.format(conditional_Behaviour_Cost_LocalAmount_Input_HC,
								activityType);
						waitForElement(driver, localAmount_Input);
						clearAndType(driver, localAmount_Input, localAmount_DSC);
					}
					waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_HC);
					click(driver, conditional_Behaviour_Cost_Table_Rows_HC);
				}
				waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_HC);
				click(driver, conditional_Behaviour_Cost_Table_Rows_HC);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				if (isdisplayed(driver, popup_Message_Yes_Button)) {
					click(driver, popup_Message_Yes_Button);
				}

				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;
			case "External Feeder 1 Cost":
				moduleData.put("From_location", values[0].trim());
				moduleData.put("From_Terminal", values[1].trim());
				moduleData.put("To_Location", values[2].trim());
				moduleData.put("To_Terminal", values[3].trim());
				moduleData.put("Service_input", values[4].trim());
				externalFeeder(driver, External_Feeder_Cost_Module, equipmentType, Container_External_feeder1,
						condition, moduleData, datePicker, Start_Date, End_Date, Condition_Activity_Code_External1,
						Condition_Equipment_group_External_feeder1, Activity_Code_External1,
						Activity_Code_External_amount1, test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;
			case "External Feeder 2 Cost":
				moduleData.put("From_location", values[0].trim());
				moduleData.put("From_Terminal", values[1].trim());
				moduleData.put("To_Location", values[2].trim());
				moduleData.put("To_Terminal", values[3].trim());
				moduleData.put("Service_input", values[4].trim());
				externalFeeder(driver, External_Feeder_Cost_Module, equipmentType, Container_External_feeder2,
						condition, moduleData, datePicker, Start_Date, End_Date, Condition_Activity_Code_External2,
						Condition_Equipment_group_External_feeder2, Activity_Code_External2,
						Activity_Code_External_amount2, test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;
			case "External Feeder 3 Cost":
				moduleData.put("From_location", values[0].trim());
				moduleData.put("From_Terminal", values[1].trim());
				moduleData.put("To_Location", values[2].trim());
				moduleData.put("To_Terminal", values[3].trim());
				moduleData.put("Service_input", values[4].trim());
				externalFeeder(driver, External_Feeder_Cost_Module, equipmentType, Container_External_feeder3,
						condition, moduleData, datePicker, Start_Date, End_Date, Condition_Activity_Code_External3,
						Condition_Equipment_group_External_feeder3, Activity_Code_External3,
						Activity_Code_External_amount3, test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;
			case "External Feeder 4 Cost":
				moduleData.put("From_location", values[0].trim());
				moduleData.put("From_Terminal", values[1].trim());
				moduleData.put("To_Location", values[2].trim());
				moduleData.put("To_Terminal", values[3].trim());
				moduleData.put("Service_input", values[4].trim());
				externalFeeder(driver, External_Feeder_Cost_Module, equipmentType, Container_External_feeder4,
						condition, moduleData, datePicker, Start_Date, End_Date, Condition_Activity_Code_External4,
						Condition_Equipment_group_External_feeder4, Activity_Code_External4,
						Activity_Code_External_amount4, test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;
			case "Equipment Operation Cost Origin":
				moduleData.put("Origin", values[0].trim());
				scrollTop(driver);
				Step_Start(1, "Open the screen through module search", test, test1);
				moduleNavigate(driver, equipment_Operation_cost_Origin_Module);
				Step_End(1, "Open the screen through module search", test, test1);
				scrollTop(driver);
				Step_Start(2, "Click new button", test, test1);
				newButton(driver);
				Step_End(2, "Click new button", test, test1);
				Step_Start(3, "Enter the From Location", test, test1);
				waitForElement(driver, Cost_Origin_Location_TF);
				sendKeys(driver, Cost_Origin_Location_TF, moduleData.get("Origin"));
				waitForElement(driver, cost_Origin_Location_Search_Button);
				click(driver, cost_Origin_Location_Search_Button);
				twoColumnSearchWindow(driver, Port_Code_Header_C, Condition_filter_C, moduleData.get("Origin"));
				Step_End(3, "Enter the From Location", test, test1);

				Step_Start(4, "Enter the Equipment Type", test, test1);
				waitForElement(driver, cost_Origin_Equipment_Type_Plus_Button);
				click(driver, cost_Origin_Equipment_Type_Plus_Button);
				twoColumnSearchWindow(driver, Equip_Type_Header_C, Condition_filter_C, equipmentType);
				Step_End(4, "Enter the Equipment Type", test, test1);

				if (!Start_Date.equals("")) {
					waitForElement(driver, cost_Origin_Start_Date);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, cost_Origin_Start_Date, Start_Date);
					} else {
						waitForElement(driver, cost_Origin_Start_Date);
						clearAndType(driver, cost_Origin_Start_Date, Start_Date);
					}
				}
				// Selecting the to Date

				if (!End_Date.equals("")) {
					waitForElement(driver, cost_Origin_End_Date);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, cost_Origin_End_Date, End_Date);
					} else {
						waitForElement(driver, cost_Origin_End_Date);
						clearAndType(driver, cost_Origin_End_Date, End_Date);
					}
				}
				Step_Start(5, "Enter the amount", test, test1);
				waitForElement(driver, cost_Origin_Amount_TF);
				clearAndType(driver, cost_Origin_Amount_TF, amount_C);
				Step_End(5, "Enter the amount", test, test1);
				waitForElement(driver, cost_Origin_amount_Type_Dropdown);
				click(driver, cost_Origin_amount_Type_Dropdown);
				String select_Amount_Type = String.format(Rate_Request_Loactors.cost_Origin_Amount_Type_Select,
						amount_Type_C);
				waitForElement(driver, select_Amount_Type);
				click(driver, select_Amount_Type);
				Step_Start(6, "Click save", test, test1);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				Step_End(6, "Click save", test, test1);
				if (isdisplayed(driver, Popup_Message)) {
					waitForPopup(driver, Popup_Message, cost_Origin_Saved_Popup_C);
					String cost_origin_Saved = getText(driver, Popup_Message);
					if (cost_origin_Saved.equals(cost_Origin_Saved_Popup_C)) {
						System.out.println("Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
								+ " || Actual popup is : " + cost_origin_Saved);
						Extent_pass(driver, "Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
								+ " || Actual popup is : " + cost_origin_Saved, test, test1);
					} else {
						System.out.println("Not Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
								+ " || Actual popup is : " + cost_origin_Saved);
						Extent_fail(driver, "Not Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
								+ " || Actual popup is : " + cost_origin_Saved, test, test1);
					}
				} else {
					waitForDisplay(driver, popup_Message);
					if (isdisplayed(driver, popup_Message)) {
						click(driver, popup_Message_Yes_Button);
					} else {
						waitForPopup(driver, Popup_Message, cost_Origin_Saved_Popup_C);
						String cost_origin_Saved = getText(driver, Popup_Message);
						if (cost_origin_Saved.equals(cost_Origin_Saved_Popup_C)) {
							System.out.println("Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
									+ " || Actual popup is : " + cost_origin_Saved);
							Extent_pass(driver, "Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
									+ " || Actual popup is : " + cost_origin_Saved, test, test1);
						} else {
							System.out.println("Not Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
									+ " || Actual popup is : " + cost_origin_Saved);
							Extent_fail(driver, "Not Matched || " + " Expected popup is : " + cost_Origin_Saved_Popup_C
									+ " || Actual popup is : " + cost_origin_Saved, test, test1);
						}
					}
				}
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			case "Equipment Operation Cost Delivery":
				moduleData.put("Origin", values[0].trim());
				scrollTop(driver);
				Step_Start(1, "Open the screen through module search", test, test1);
				moduleNavigate(driver, equipment_Operation_cost_Delivery_Module);
				Step_End(1, "Open the screen through module search.", test, test1);
				scrollTop(driver);

				Step_Start(2, "Click new button", test, test1);
				newButton(driver);
				Step_End(2, "Click new button", test, test1);
				Step_Start(3, "Enter the From Location", test, test1);
				waitForElement(driver, cost_Delivery_Location_TF);
				sendKeys(driver, cost_Delivery_Location_TF, moduleData.get("Origin"));
				waitForElement(driver, cost_Delivery_Location_Search_Button);
				click(driver, cost_Delivery_Location_Search_Button);
				twoColumnSearchWindow(driver, Location_Code_Header_D, Condition_filter_C, moduleData.get("Origin"));

				Step_End(3, "Enter the From Location", test, test1);

				Step_Start(4, "Enter the Equipment Type", test, test1);
				waitForElement(driver, cost_Delivery_Equipment_Type_Plus_Button);
				click(driver, cost_Delivery_Equipment_Type_Plus_Button);
				twoColumnSearchWindow(driver, Equip_Type_Header_D, Condition_filter_D, equipmentType);

				Step_End(4, "Enter the Equipment Type", test, test1);
				if (!Start_Date.equals("")) {
					waitForElement(driver, cost_Delivery_Start_Date);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, cost_Delivery_Start_Date, Start_Date);
					} else {
						waitForElement(driver, cost_Delivery_Start_Date);
						clearAndType(driver, cost_Delivery_Start_Date, Start_Date);
					}
				}
				// Selecting the to Date
				if (!End_Date.equals("")) {
					waitForElement(driver, cost_Delivery_End_Date);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, cost_Delivery_End_Date, End_Date);
					} else {
						waitForElement(driver, cost_Delivery_End_Date);
						clearAndType(driver, cost_Delivery_End_Date, End_Date);
					}
				}
				Step_Start(5, "Enter the amount", test, test1);
				waitForElement(driver, cost_Delivery_Amount_TF);
				clearAndType(driver, cost_Delivery_Amount_TF, amount_D);
				Step_End(5, "Enter the amount", test, test1);
				waitForElement(driver, cost_Delivery_Amount_Type_Dropdown);
				click(driver, cost_Delivery_Amount_Type_Dropdown);
				String select_Amount_Type_D = String.format(Rate_Request_Loactors.cost_Delivery_Amount_Type_Select,
						amount_Type_D);
				waitForElement(driver, select_Amount_Type_D);
				click(driver, select_Amount_Type_D);
				Step_Start(6, "Click save", test, test1);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				Step_End(6, "Click save", test, test1);
				if (isdisplayed(driver, Popup_Message)) {
					waitForPopup(driver, Popup_Message, cost_Delivery_Saved_Popup_D);
					String cost_Delivery_Saved = getText(driver, Popup_Message);
					if (cost_Delivery_Saved.equals(cost_Delivery_Saved_Popup_D)) {
						System.out.println("Matched || " + " Expected popup is : " + cost_Delivery_Saved_Popup_D
								+ " || Actual popup is : " + cost_Delivery_Saved);
						Extent_pass(driver, "Matched || " + " Expected popup is : " + cost_Delivery_Saved_Popup_D
								+ " || Actual popup is : " + cost_Delivery_Saved, test, test1);
					} else {
						System.out.println("Not Matched || " + " Expected popup is : " + cost_Delivery_Saved_Popup_D
								+ " || Actual popup is : " + cost_Delivery_Saved);
						Extent_fail(driver, "Not Matched || " + " Expected popup is : " + cost_Delivery_Saved_Popup_D
								+ " || Actual popup is : " + cost_Delivery_Saved, test, test1);
					}
				} else {
					waitForDisplay(driver, popup_Message);
					if (isdisplayed(driver, popup_Message)) {
						click(driver, popup_Message_Yes_Button);
					} else {
						waitForPopup(driver, Popup_Message, cost_Delivery_Saved_Popup_D);
						String cost_Delivery_Saved = getText(driver, Popup_Message);
						if (cost_Delivery_Saved.equals(cost_Delivery_Saved_Popup_D)) {
							System.out.println("Matched || " + " Expected popup is : " + cost_Delivery_Saved
									+ " || Actual popup is : " + cost_Delivery_Saved_Popup_D);
							Extent_pass(driver, "Matched || " + " Expected popup is : " + cost_Delivery_Saved
									+ " || Actual popup is : " + cost_Delivery_Saved_Popup_D, test, test1);
						} else {
							System.out.println("Not Matched || " + " Expected popup is : " + cost_Delivery_Saved
									+ " || Actual popup is : " + cost_Delivery_Saved_Popup_D);
							Extent_fail(driver, "Not Matched || " + " Expected popup is : " + cost_Delivery_Saved
									+ " || Actual popup is : " + cost_Delivery_Saved_Popup_D, test, test1);
						}
					}
				}
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;
			case "Fixed Equipment Cost":
				String[] fixedValues = parts[1].split(",");
				for (String val : fixedValues) {
					if (val.contains("Origin"))
						moduleData.put("Origin", val.split(":")[1].trim());
					if (val.contains("POL"))
						moduleData.put("POL", val.split(":")[1].trim());
					if (val.contains("Delivery"))
						moduleData.put("Delivery", val.split(":")[1].trim());
					if (val.contains("POD"))
						moduleData.put("POD", val.split(":")[1].trim());
				}
				Step_Start(1, "Open the screen through module search", test, test1);
				Step_Start(1, "Open the screen through module search", test, test1);
				scrollTop(driver);
				moduleNavigate(driver, Fec_module);
				Step_End(1, "Open the screen through module search", test, test1);
				Step_Start(2, "Click new button", test, test1);
				scrollTop(driver);
				newButton(driver);
				Step_End(2, "Click new button", test, test1);
				Step_Start(3, "Enter the service", test, test1);
				if (!service_data_Fec.equals("")) {
					waitForElement(driver, service_search_icon_Fec);
					click(driver, service_search_icon_Fec);
//						selectValue(driver, condition, service_data_Fec);
					twoColumnSearchWindow(driver, service_code_header_Fec, condition, service_data_Fec);
				}

				Step_End(3, "Enter the service", test, test1);
				Step_Start(4, "Enter the origin", test, test1);
				waitForElement(driver, origin_search_icon_Fec);
				click(driver, origin_search_icon_Fec);
//					selectValue(driver, condition, moduleData.get("Origin"));
				twoColumnSearchWindow(driver, location_code_header_Fec, condition, moduleData.get("Origin"));

				Step_End(4, "Enter the origin", test, test1);
				Step_Start(5, "Enter the POL", test, test1);
				waitForElement(driver, pol_search_icon_Fec);
				click(driver, pol_search_icon_Fec);
//					selectValue(driver, condition,  moduleData.get("POL"));
				twoColumnSearchWindow(driver, location_code_header_Fec, condition, moduleData.get("POL"));

				Step_End(5, "Enter the POL", test, test1);
				Step_Start(6, "Enter the POD", test, test1);
				waitForElement(driver, pod_search_icon_Fec);
				click(driver, pod_search_icon_Fec);
//					selectValue(driver, condition, moduleData.get("POD"));
				twoColumnSearchWindow(driver, location_code_header_Fec, condition, moduleData.get("POD"));

				Step_End(6, "Enter the POD", test, test1);
				Step_Start(7, "Enter the Delivery", test, test1);
				waitForElement(driver, delivery_search_icon_Fec);
				click(driver, delivery_search_icon_Fec);
//					selectValue(driver, condition, moduleData.get("Delivery"));
				twoColumnSearchWindow(driver, location_code_header_Fec, condition, moduleData.get("Delivery"));

				Step_End(7, "Enter the Delivery", test, test1);
				Step_Start(8, "Enter the Equipment type", test, test1);
				waitForElement(driver, equip_type_add_btn_Fec);
				click(driver, equip_type_add_btn_Fec);
//					selectValue2(driver, condition, equipmentType);
				twoColumnSearchWindow(driver, equipment_type_header_Fec, condition, equipmentType);

				Step_End(8, "Enter the Equipment type", test, test1);

				Step_Start(13, "Enter the Fixed Equipment cost", test, test1);
				waitForElement(driver, per_diem_txtfld_Fec);
				click(driver, per_diem_txtfld_Fec);
				waitForElement(driver, per_diem_txtfld_Fec);
				clearAndType(driver, per_diem_txtfld_Fec, per_diem_data_Fec);
				waitForElement(driver, per_diem_txtfld_Fec);
				click(driver, per_diem_txtfld_Fec);
				Step_End(13, "Enter the Fixed Equipment cost", test, test1);

				Step_Start(12, "Enter the empty", test, test1);
				waitForElement(driver, empty_txtfld_Fec);
				click(driver, empty_txtfld_Fec);
				waitForElement(driver, empty_txtfld_Fec);
				clear(driver, empty_txtfld_Fec);
				waitForElement(driver, empty_txtfld_Fec);
				sendKeys(driver, empty_txtfld_Fec, empty_field_data_Fec);
				click(driver, empty_txtfld_Fec);
				Step_End(12, "Enter the empty", test, test1);

				Step_Start(9, "Enter the Voyage time", test, test1);
				waitForElement(driver, voyage_time_txtfld_Fec);
				click(driver, voyage_time_txtfld_Fec);
				waitForElement(driver, voyage_time_txtfld_Fec);
				clear(driver, voyage_time_txtfld_Fec);
				waitForElement(driver, voyage_time_txtfld_Fec);
				sendKeys(driver, voyage_time_txtfld_Fec, voyage_time_data_Fec);
				click(driver, voyage_time_txtfld_Fec);
				Step_End(9, "Enter the Voyage time", test, test1);

				Step_Start(10, "Enter the out bound", test, test1);
				waitForElement(driver, outbound_txtfld_Fec);
				click(driver, outbound_txtfld_Fec);
				waitForElement(driver, outbound_txtfld_Fec);
				clear(driver, outbound_txtfld_Fec);
				waitForElement(driver, outbound_txtfld_Fec);
				sendKeys(driver, outbound_txtfld_Fec, outbound_data_Fec);
				waitForElement(driver, outbound_txtfld_Fec);
				click(driver, outbound_txtfld_Fec);

				Step_End(10, "Enter the out bound", test, test1);
				Step_Start(11, "Enter the inbound", test, test1);
				waitForElement(driver, inbound_txtfld_Fec);
				click(driver, inbound_txtfld_Fec);
				waitForElement(driver, inbound_txtfld_Fec);
				clear(driver, inbound_txtfld_Fec);
				waitForElement(driver, inbound_txtfld_Fec);
				sendKeys(driver, inbound_txtfld_Fec, inbound_data_Fec);
				waitForElement(driver, inbound_txtfld_Fec);
				click(driver, inbound_txtfld_Fec);

				Step_End(11, "Enter the inbound", test, test1);
				waitForElement(driver, per_diem_txtfld_Fec);
				click(driver, per_diem_txtfld_Fec);

				checkBox(driver, soc_checkbox_Fec, soc_flg_Fec);
				if (!container_type_data_Fec.equals("")) {
					String container_to_select = String.format(container_type_radio_btn_Fec, container_type_data_Fec);
					waitForElement(driver, container_to_select);
					click(driver, container_to_select);
				}
				if (!currency_data_Fec.equals("")) {
					waitForElement(driver, currency_dd_Fec);
					click(driver, currency_dd_Fec);
					String currency_to_select = String.format(currency_dd_options_Fec, currency_data_Fec);
					waitForElement(driver, currency_to_select);
					click(driver, currency_to_select);
				}
				if (!Start_Date.equals("")) {
					waitForElement(driver, start_date_Fec);

					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, start_date_Fec, Start_Date);
					} else {
						waitForElement(driver, start_date_Fec);
						clearAndType(driver, start_date_Fec, Start_Date);
					}
				}

				if (!End_Date.equals("")) {
					waitForElement(driver, End_date_Fec);

					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, End_date_Fec, End_Date);
					} else {
						waitForElement(driver, End_date_Fec);
						clearAndType(driver, End_date_Fec, End_Date);
					}
				}
				Step_Start(14, "Click save", test, test1);
				waitForElement(driver, SaveButton_ToolBar);
				click1(driver, SaveButton_ToolBar);
				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					waitForElement(driver, popup_Message);
					click(driver, popup_Message_Yes_Button);
				}
				Step_End(14, "Click save", test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);

				break;

			case "Imbalance Cost  Origin":
				moduleData.put("Origin", values[0].trim());
				scrollTop(driver);
				moduleNavigate(driver, ICO_Module_Name);
				scrollTop(driver);
				
				newButton(driver);
				
				waitForElement(driver, ICO_LocationField);
				sendKeys(driver, ICO_LocationField, moduleData.get("Origin"));
				waitForElement(driver, ICO_LocationButton);
				click(driver, ICO_LocationButton);
				twoColumnSearchWindow(driver, ICO_Location_Code_Header, condition, moduleData.get("Origin"));

				waitForElement(driver, ICO_EquipTypeButton);
				click(driver, ICO_EquipTypeButton);
				twoColumnSearchWindow(driver, ICO_Equip_Type_Header, condition, equipmentType);
				if (!Start_Date.equals("")) {
					waitForElement(driver, ICO_StartDate);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, ICO_StartDate, Start_Date);
					} else {
						waitForElement(driver, ICO_StartDate);
						clearAndType(driver, ICO_StartDate, Start_Date);
					}
				}
				if (!End_Date.equals("")) {
					waitForElement(driver, ICO_EndDate);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, ICO_EndDate, End_Date);
					} else {
						waitForElement(driver, ICO_EndDate);
						clearAndType(driver, ICO_EndDate, End_Date);
					}
				}
				waitForElement(driver, ICO_Amount_Field);
				clearAndType(driver, ICO_Amount_Field, ICO_Amount_Input);
				waitForElement(driver, ICO_Currency_DD);
				click(driver, ICO_Currency_DD);
				String currency_Select = String.format(DropDown_Select, ICO_Curreny_Input);
				waitForElement(driver, currency_Select);
				click(driver, currency_Select);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				waitForDisplay(driver, popup_Message_Yes_Button);
				if (isdisplayed(driver, popup_Message_Yes_Button)) {
					click(driver, popup_Message_Yes_Button);
				}
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			case "Imbalance  Cost Delivery":
				scrollTop(driver);
				moduleNavigate(driver, ICD_Module_Name);
				moduleData.put("Delivery", values[0].trim());
				scrollTop(driver);
				
				newButton(driver);
				
				waitForElement(driver, ICD_DeliveryPortField);
				sendKeys(driver, ICD_DeliveryPortField, moduleData.get("Delivery"));
				waitForElement(driver, ICD_DeliveryPortButton);
				click(driver, ICD_DeliveryPortButton);
				twoColumnSearchWindow(driver, ICD_Delivery_Port_Column_Header, condition, moduleData.get("Delivery"));
				if (!ICD_Origin_Input.equals("")) {
					waitForElement(driver, ICD_OriginPortField);
					sendKeys(driver, ICD_OriginPortField, ICD_Origin_Input);
					waitForElement(driver, ICD_OriginPortButton);
					click(driver, ICD_OriginPortButton);
					twoColumnSearchWindow(driver, ICD_Origin_Port_Column_Header, condition, ICD_Origin_Input);
				}
				waitForElement(driver, ICD_EquipTypeButton);
				click(driver, ICD_EquipTypeButton);
				twoColumnSearchWindow(driver, ICD_Equip_Type_Column_Header, condition, equipmentType);
				if (!Start_Date.equals("")) {
					waitForElement(driver, ICD_StartDate);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, ICD_StartDate, Start_Date);
					} else {
						waitForElement(driver, ICD_StartDate);
						clearAndType(driver, ICD_StartDate, Start_Date);
					}
				}
				if (!End_Date.equals("")) {
					waitForElement(driver, ICD_EndDate);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, ICD_EndDate, End_Date);
					} else {
						waitForElement(driver, ICD_EndDate);
						clearAndType(driver, ICD_EndDate, End_Date);
					}
				}
				waitForElement(driver, ICD_Amount_Field);
				clearAndType(driver, ICD_Amount_Field, ICD_Amount_Input);
				waitForElement(driver, ICD_Currency_DD);
				click(driver, ICD_Currency_DD);
				String ICD_currency_Select = String.format(DropDown_Select, ICD_Curreny_Input);
				waitForElement(driver, ICD_currency_Select);
				click(driver, ICD_currency_Select);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				waitForDisplay(driver, popup_Message_Yes_Button);
				if (isdisplayed(driver, popup_Message_Yes_Button)) {
					click(driver, popup_Message_Yes_Button);
				}
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			case "Claims":
				moduleData.put("Origin", values[0].trim());
				moduleData.put("Delivery", values[1].trim());
				scrollTop(driver);
				moduleNavigate(driver, claims_Module_Name);
				scrollTop(driver);
				
				newButton(driver);
				
				waitForElement(driver, claims_FromLocationButton);
				click(driver, claims_FromLocationButton);
				twoColumnSearchWindow(driver, claims_From_Location_Column_Header, condition, moduleData.get("Origin"));
				waitForElement(driver, claims_ToLocationButton);
				click(driver, claims_ToLocationButton);
				twoColumnSearchWindow(driver, claims_To_Location_Column_Header, condition, moduleData.get("Delivery"));
				waitForElement(driver, claims_EquipTypeButton);
				click(driver, claims_EquipTypeButton);
				twoColumnSearchWindow(driver, claims_Equip_Type_Column_Header, condition, equipmentType);
				if (!Start_Date.equals("")) {
					waitForElement(driver, claims_StartDate);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, claims_StartDate, Start_Date);
					} else {
						waitForElement(driver, claims_StartDate);
						clearAndType(driver, claims_StartDate, Start_Date);
					}
				}
				if (!End_Date.equals("")) {
					waitForElement(driver, claims_EndDate);
					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, claims_EndDate, End_Date);
					} else {
						waitForElement(driver, claims_EndDate);
						clearAndType(driver, claims_EndDate, End_Date);
					}
				}
				waitForElement(driver, claims_Amount_Field);
				clearAndType(driver, claims_Amount_Field, claims_Amount_Input);
				waitForElement(driver, claims_Currency_DD);
				click(driver, claims_Currency_DD);
				String claims_currency_Select = String.format(DropDown_Select, claims_Curreny_Input);
				waitForElement(driver, claims_currency_Select);
				click(driver, claims_currency_Select);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				waitForDisplay(driver, popup_Message_Yes_Button);
				if (isdisplayed(driver, popup_Message_Yes_Button)) {
					click(driver, popup_Message_Yes_Button);
				}
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			case "Disc. Trans 1 Cost":
//				moduleNavigate(driver, moduleData.get(moduleName));
				moduleData.put("Origin", values[0].trim());
				moduleData.put("Terminal", values[1].trim());
				moduleData.put("Service", values[2].trim());

				transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_DT, equipmentType,
						container_Type_TCS_DT1, condition, moduleData, datePicker, activity_Type_TCS_DT1,
						local_Amount_TCS_DT1, activity_Type_Conditional_Behaviour_TSC_DT1,
						local_Amount_Conditional_Behaviour_TSC_DT1, Start_Date, End_Date, locationDetails_Filter_TC1,
						terminalDetails_Filter_TC1, servicelDetails_Filter_TC1, test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			case "Load Trans 1 Cost":
//				moduleNavigate(driver, moduleData.get(moduleName));
				moduleData.put("Origin", values[0].trim());
				moduleData.put("Terminal", values[1].trim());
				moduleData.put("Service", values[2].trim());

				transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_LT, equipmentType,
						container_Type_TCS_LT1, condition, moduleData, datePicker, activity_Type_TCS_LT1,
						local_Amount_TCS_LT1, activity_Type_Conditional_Behaviour_TSC_LT1,
						local_Amount_Conditional_Behaviour_TSC_LT1, Start_Date, End_Date, locationDetails_Filter_TC1,
						terminalDetails_Filter_TC1, servicelDetails_Filter_TC1, test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;
			case "Disc. Trans 2 Cost":
//				moduleNavigate(driver, moduleData.get(moduleName));
				moduleData.put("Origin", values[0].trim());
				moduleData.put("Terminal", values[1].trim());
				moduleData.put("Service", values[2].trim());

				transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_DT, equipmentType,
						container_Type_TCS_DT2, condition, moduleData, datePicker, activity_Type_TCS_DT2,
						local_Amount_TCS_DT2, activity_Type_Conditional_Behaviour_TSC_DT2,
						local_Amount_Conditional_Behaviour_TSC_DT2, Start_Date, End_Date, locationDetails_Filter_TC2,
						terminalDetails_Filter_TC2, servicelDetails_Filter_TC2, test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			case "Load Trans 2 Cost":
//				moduleNavigate(driver, moduleData.get(moduleName));
				moduleData.put("Origin", values[0].trim());
				moduleData.put("Terminal", values[1].trim());
				moduleData.put("Service", values[2].trim());

				transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_LT, equipmentType,
						container_Type_TCS_LT2, condition, moduleData, datePicker, activity_Type_TCS_LT2,
						local_Amount_TCS_LT2, activity_Type_Conditional_Behaviour_TSC_LT2,
						local_Amount_Conditional_Behaviour_TSC_LT2, Start_Date, End_Date, locationDetails_Filter_TC2,
						terminalDetails_Filter_TC2, servicelDetails_Filter_TC2, test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			case "Disc. Trans 3 Cost":
//				moduleNavigate(driver, moduleData.get(moduleName));
				moduleData.put("Origin", values[0].trim());
				moduleData.put("Terminal", values[1].trim());
				moduleData.put("Service", values[2].trim());

				transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_DT, equipmentType,
						container_Type_TCS_DT3, condition, moduleData, datePicker, activity_Type_TCS_DT3,
						local_Amount_TCS_DT3, activity_Type_Conditional_Behaviour_TSC_DT3,
						local_Amount_Conditional_Behaviour_TSC_DT3, Start_Date, End_Date, locationDetails_Filter_TC3,
						terminalDetails_Filter_TC3, servicelDetails_Filter_TC3, test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			case "Load Trans 3 Cost":
//				moduleNavigate(driver, moduleData.get(moduleName));
				moduleData.put("Origin", values[0].trim());
				moduleData.put("Terminal", values[1].trim());
				moduleData.put("Service", values[2].trim());

				transhipmentCost(driver, transshipmentCost_Module, transhipmentType_TCS_LT, equipmentType,
						container_Type_TCS_LT3, condition, moduleData, datePicker, activity_Type_TCS_LT3,
						local_Amount_TCS_LT3, activity_Type_Conditional_Behaviour_TSC_LT3,
						local_Amount_Conditional_Behaviour_TSC_LT3, Start_Date, End_Date, locationDetails_Filter_TC3,
						terminalDetails_Filter_TC3, servicelDetails_Filter_TC3, test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
				break;

			default:
				System.out.println("Unknown Module: " + moduleName);
				break;
			}

		}
	}

	public void externalFeeder(WebDriver driver, String Cost_Module, String equipmentType, String Container,
			String condition, Map<String, String> moduleData, String datePicker, String From_date, String To_date,
			String Condition_Activity_Code_External, String Condition_Equipment_group_External_feeder,
			String Activity_Code_External, String Activity_Code_External_amount, ExtentTest test, ExtentTest test1) {
		scrollTop(driver);
		moduleNavigate(driver, Cost_Module);
		String equipment_group = String.format(Rate_Request_Loactors.select_type, equipmentType);
		String container_click = String.format(Rate_Request_Loactors.Container_type_internal_feeder, Container);
		scrollTop(driver);
		
		newButton(driver);
		
		waitForElement(driver, container_click);
		click(driver, container_click);
		waitForElement(driver, From_location_search_external);
		click(driver, From_location_search_external);
		twoColumnSearchWindow(driver, From_Location_External, condition, moduleData.get("From_location"));
		waitForElement(driver, From_terminal_search_external);
		click(driver, From_terminal_search_external);
		twoColumnSearchWindow(driver, From_Terminal_External, condition, moduleData.get("From_Terminal"));
		waitForElement(driver, TO_location_search_external);
		click(driver, TO_location_search_external);
		twoColumnSearchWindow(driver, To_Location_External, condition, moduleData.get("To_Location"));

		waitForElement(driver, to_terminal_search_external);
		click(driver, to_terminal_search_external);
		twoColumnSearchWindow(driver, To_Terminal_External, condition, moduleData.get("To_Terminal"));

		waitForElement(driver, Service_search_external_feeder);
		click(driver, Service_search_external_feeder);
		twoColumnSearchWindow(driver, Service_External, condition, moduleData.get("Service_input"));

		waitForElement(driver, start_date_ex_feeder);
		if (!From_date.equals("")) {
			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, start_date_ex_feeder, From_date);
			} else {
				waitForElement(driver, start_date_ex_feeder);
				clearAndType(driver, start_date_ex_feeder, From_date);
			}
		}
		if (!To_date.equals("")) {
			waitForElement(driver, to_date_ex_feeder);
			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, to_date_ex_feeder, To_date);
			} else {
				waitForElement(driver, to_date_ex_feeder);
				clearAndType(driver, to_date_ex_feeder, To_date);
			}
		}
		waitForElement(driver, eqp_group_dd_external);
		click(driver, eqp_group_dd_external);
		waitForElement(driver, equipment_group);
		click(driver, equipment_group);
		List<String> activity_Types_DSC = splitAndExpand(Activity_Code_External);
		List<String> local_Amounts_DSC = splitAndExpand(Activity_Code_External_amount);
		for (int i = 0; i < activity_Types_DSC.size(); i++) {
			String activityType_DSC = activity_Types_DSC.get(i);
			String localAmount_DSC = local_Amounts_DSC.get(i);
			String localAmount = String.format(Rate_Request_Loactors.standardCost_Table_LocalAmount_EFC,
					activityType_DSC);
			waitForElement(driver, localAmount);
			click(driver, localAmount);
			if (!activityType_DSC.equals(" ") && !localAmount_DSC.equals(" ")) {
				String localAmount_Input_DSC = String.format(standardCost_Table_LocalAmount_Input_EFC,
						activityType_DSC);
				waitForElement(driver, localAmount_Input_DSC);
				clearAndType(driver, localAmount_Input_DSC, localAmount_DSC);
			}
			waitForElement(driver, standardCost_Table_Rows_EFC);
			click(driver, standardCost_Table_Rows_EFC);
		}
		waitForElement(driver, standardCost_Table_Rows_EFC);
		click(driver, standardCost_Table_Rows_EFC);
		// Conditional Behaviour
		List<String> activity_Types_Condi_DSC = splitAndExpand(Condition_Activity_Code_External);
		List<String> local_Amounts_Condi_DSC = splitAndExpand(Condition_Equipment_group_External_feeder);
		for (int i = 0; i < activity_Types_Condi_DSC.size(); i++) {
			String activityType = activity_Types_Condi_DSC.get(i);
			String localAmount_DSC = local_Amounts_Condi_DSC.get(i);
			String localAmount = String.format(conditional_Behaviour_Cost_LocalAmount_EFC, activityType);
			waitForElement(driver, localAmount);
			click(driver, localAmount);
			if (!activityType.equals(" ") && !localAmount_DSC.equals(" ")) {
				String localAmount_Input = String.format(conditional_Behaviour_Cost_LocalAmount_Input_EFC,
						activityType);
				waitForElement(driver, localAmount_Input);
				clearAndType(driver, localAmount_Input, localAmount_DSC);
			}
			waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_EFC);
			click(driver, conditional_Behaviour_Cost_Table_Rows_EFC);
		}
		waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_EFC);
		click(driver, conditional_Behaviour_Cost_Table_Rows_EFC);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		if (isdisplayed(driver, Yes_Btn)) {
			click(driver, Yes_Btn);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

	}

	public void transhipmentCost(WebDriver driver, String Cost_Module, String transhipmentType, String equipmentType,
			String Container, String condition, Map<String, String> moduleData, String datePicker, String activity_Type,
			String local_Amount, String activity_Type_Conditional_Behaviour, String local_Amount_Conditional_Behaviour,
			String From_date, String To_date, String locationDetails_Filter_TC, String terminalDetails_Filter_TC,
			String servicelDetails_Filter_TC, ExtentTest test, ExtentTest test1) {
		String eqp_Group_TSC = moduleData.get("Equipment Type");
		if (moduleData.get("Equipment Type").contains("2")) {
			eqp_Group_TSC = "20S";
		} else if (moduleData.get("Equipment Type").contains("4")) {
			eqp_Group_TSC = "40S";
		} else {
			eqp_Group_TSC = "20S";
		}
		Step_Start(1, "Open the screen through module search.", test, test1);
		moduleNavigate(driver, Cost_Module);
		Step_End(1, "Open the screen through module search.", test, test1);
		Step_Start(2, "Click new button.", test, test1);
		newButton(driver);
		Step_End(2, "Click new button.", test, test1);
		Step_Start(3, "Select the transshipment type.", test, test1);
		waitForElement(driver, transhipment_Type_TC);
		click(driver, transhipment_Type_TC);
		String select_Transhipment = String.format(DropDown_Select, transhipmentType);
		waitForElement(driver, select_Transhipment);
		click(driver, select_Transhipment);
		String select_Container_Type_TC = String.format(containerType_RadioButton_TC, Container);
		waitForElement(driver, select_Container_Type_TC);
		click(driver, select_Container_Type_TC);
		Step_End(3, "Select the transshipment type.", test, test1);
		Step_Start(4, "Enter the load port", test, test1);
		waitForElement(driver, location_SearchButton_TC);
		click(driver, location_SearchButton_TC);

		twoColumnSearchWindow(driver, locationDetails_Filter_TC, condition, moduleData.get("Origin"));

		Step_End(4, "Enter the load port", test, test1);
		Step_Start(5, "Enter the load terminal.", test, test1);
		waitForElement(driver, terminal_SearchButton_TC);
		click(driver, terminal_SearchButton_TC);

		twoColumnSearchWindow(driver, terminalDetails_Filter_TC, condition, moduleData.get("Terminal"));

		Step_End(5, "Enter the load terminal.", test, test1);
		Step_Start(6, "Enter the Equipment group", test, test1);
		waitForElement(driver, eqp_Group_Dropdown_TC);
		click(driver, eqp_Group_Dropdown_TC);
		String eqpGroup_TC = String.format(DropDown_Select, eqp_Group_TSC);
		waitForElement(driver, eqpGroup_TC);
		click(driver, eqpGroup_TC);
		Step_End(6, "Enter the Equipment group", test, test1);
		Step_Start(7, "Enter the service", test, test1);
		waitForElement(driver, service_SearchButton_TC);
		click(driver, service_SearchButton_TC);

		twoColumnSearchWindow(driver, servicelDetails_Filter_TC, condition, moduleData.get("Service"));

		Step_End(7, "Enter the service", test, test1);
		// Selecting the start Date
		if (!From_date.equals("")) {
			waitForElement(driver, startDate_TC);
			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, startDate_TC, From_date);
			} else {
				waitForElement(driver, startDate_TC);
				clearAndType(driver, startDate_TC, From_date);
			}
		}
		if (!To_date.equals("")) {
			// Selecting the end Date
			waitForElement(driver, endDate_TC);
			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, endDate_TC, To_date);
			} else {
				waitForElement(driver, endDate_TC);
				clearAndType(driver, endDate_TC, To_date);
			}
		}

		Step_Start(8, "Enter the amount in the local amount column", test, test1);
		List<String> activity_Types_TSC = splitAndExpand(activity_Type);
		List<String> local_Amounts_TSC = splitAndExpand(local_Amount);
		for (int i = 0; i < activity_Types_TSC.size(); i++) {
			String activityType_TSC = activity_Types_TSC.get(i);
			String localAmount_TSC = local_Amounts_TSC.get(i);
			String localAmount = String.format(standardCost_Table_LocalAmount_TC, activityType_TSC);
			waitForElement(driver, localAmount);
			click(driver, localAmount);
			if (!activityType_TSC.equals(" ") && !localAmount_TSC.equals(" ")) {
				String localAmount_Input_TSC = String.format(standardCost_Table_LocalAmount_Input_TC, activityType_TSC);
				waitForElement(driver, localAmount_Input_TSC);
				clearAndType(driver, localAmount_Input_TSC, localAmount_TSC);
			}
			waitForElement(driver, standardCost_Table_Rows_TC);
			click(driver, standardCost_Table_Rows_TC);
		}
		waitForElement(driver, standardCost_Table_Rows_TC);
		click(driver, standardCost_Table_Rows_TC);
		// Conditional Behaviour
		List<String> activity_Types_Condi_TSC = splitAndExpand(activity_Type_Conditional_Behaviour);
		List<String> local_Amounts_Condi_TSC = splitAndExpand(local_Amount_Conditional_Behaviour);
		for (int i = 0; i < activity_Types_Condi_TSC.size(); i++) {
			String activityType = activity_Types_Condi_TSC.get(i);
			String localAmount_TSC = local_Amounts_Condi_TSC.get(i);
			String localAmount = String.format(conditional_Behaviour_Cost_LocalAmount_TC, activityType);
			waitForElement(driver, localAmount);
			click(driver, localAmount);
			if (!activityType.equals(" ") && !localAmount_TSC.equals(" ")) {
				String localAmount_Input = String.format(conditional_Behaviour_Cost_LocalAmount_Input_TC, activityType);
				waitForElement(driver, localAmount_Input);
				clearAndType(driver, localAmount_Input, localAmount_TSC);
			}
			waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_TC);
			click(driver, conditional_Behaviour_Cost_Table_Rows_TC);
		}
		waitForElement(driver, conditional_Behaviour_Cost_Table_Rows_TC);
		click(driver, conditional_Behaviour_Cost_Table_Rows_TC);
		Step_End(8, "Enter the amount in the local amount column", test, test1);
		Step_Start(9, "Click save", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);
		}
		Step_End(9, "Click save", test, test1);
	}
}
