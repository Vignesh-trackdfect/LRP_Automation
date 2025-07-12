package LRP_Bill_Of_Lading_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Bill_Of_Lading_Locators;

public class TC_Bill_Of_Lading_SC10 extends Keywords {



	public void Bill_Of_Lading_SC10(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Bill_Of_Lading_SC10";
		
		
		


		String 	Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String bol_module = Excel_data.get("bol_module");
		String agencyUser = Excel_data.get("agencyUser");
		String dropdownCondition1 = Excel_data.get("DropdownCondition1");
		String Select_search_By_bl = Excel_data.get("Select_search_By_bl");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String status = Excel_data.get("status").trim();
		String search_module = Excel_data.get("search_module");
		String first_service_data = Excel_data.get("first_service_data");
		String charge_code_data = Excel_data.get("charge_code_data");
		String base_rate_data = Excel_data.get("base_rate_data");
		String currency_data = Excel_data.get("currency_data");
		String base_rate_unit_data = Excel_data.get("base_rate_unit_data");
		String equipment_type_data = Excel_data.get("equipment_type_data");
		String payment_mode_data = Excel_data.get("payment_mode_data");
		String auto_Rated_Expected = Excel_data.get("auto_Rated_Expected");
		String package_exp = Excel_data.get("Package_pop_expected");
		String bl_mismatch_pop_exp = Excel_data.get("bl_mismatch_pop_exp");
		String Equipment_id_input = Excel_data.get("Equipment_id_input");
		String carrier_pop_exp = Excel_data.get("carrier_pop_exp");
		String carr_seal_input_value = Excel_data.get("carr_seal_input_value");
		String shipper_pop_exp = Excel_data.get("shipper_pop_exp");
		String Customer_type_input = Excel_data.get("Customer_type_input");
		String customer_easy_search_input = Excel_data.get("customer_easy_search_input");
		String consignee_pop_exp = Excel_data.get("consignee_pop_exp");
		String Customer_type_input_CONSIGNEE = Excel_data.get("Customer_type_input_CONSIGNEE");
		String customer_easy_search_input_consignee = Excel_data.get("customer_easy_search_input_consignee");
		String notify_pop_exp = Excel_data.get("notify_pop_exp");
		String Customer_type_input_Notify = Excel_data.get("Customer_type_input_Notify");
		String customer_easy_search_input_notify = Excel_data.get("customer_easy_search_input_notify");
		String commodity_Cargo_Weight_input = Excel_data.get("commodity_Cargo_Weight_input");
		String valid_comm_pop_exp = Excel_data.get("valid_comm_pop_exp");
		String comm_dis_pop_exp = Excel_data.get("comm_dis_pop_exp");
		String marks_number_pop_exp = Excel_data.get("marks_number_pop_exp");
		String enter_commodity_pop_exp = Excel_data.get("enter_commodity_pop_exp");
		String enter_package_pop_exp = Excel_data.get("enter_package_pop_exp");
		String Quantity_value_input = Excel_data.get("Quantity_value_input");
		String Package_value_input = Excel_data.get("Package_value_input");
		String commodity_grp_input = Excel_data.get("commodity_grp_input");
		String Select_search_value_hs = Excel_data.get("Select_search_value_hs");
		String HS_code_input_value = Excel_data.get("HS_code_input_value");
		String mark_number_input = Excel_data.get("mark_number_input");
		String commodity_desc_input = Excel_data.get("commodity_desc_input");
		String updated_pop_exp = Excel_data.get("updated_pop_exp");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Global_Book_num_search = Excel_data.get("Global_Book_num_search");
		String CRO_search = Excel_data.get("CRO_search");
		String CRO_search_condition = Excel_data.get("CRO_search_condition");
		String Unit_code_search = Excel_data.get("Unit_code_search");
		String Currency_code_search = Excel_data.get("Currency_code_search");
		String Charge_code_search = Excel_data.get("Charge_code_search");
		String Commodity_group = Excel_data.get("Commodity_group");
		String Package_Quantity = Excel_data.get("Package_Quantity");
		
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
	
		Extent_call(test, test1,"**Switch the Profile Start**");

		
		Step_Start(1, "Switch to agency", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, "Switch to agency", test, test1);
		//

		Extent_cal(test, test1,"** Enter Booking Module **");

		moduleNavigate(driver, search_module);

		Step_Start(1, "Enter the Agr Party Input", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(1, "Enter the Agr Party Input", test, test1);

		Step_Start(2, "Enter the Orgin and delivery", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the Orgin and delivery", test, test1);

		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		waitForElement(driver, Draft_Button);
		safeclick(driver, Draft_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		
		waitForElement(driver, booking_no);
		String draft_bookingColor1=getTextBackgroundColor(driver,booking_no);
		String draft_bookingColor=getColorName(draft_bookingColor1);
		if(draft_bookingColor.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity  popup is : " + booking_draft_Color + " || The Actual Report Activity  popup is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity  popup is : " + booking_draft_Color + " || The Actual Report Activity  popup is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity  popup is : " + booking_draft_Color + " || The Actual Report Activity  popup is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity  popup is : " + booking_draft_Color + " || The Actual Report Activity  popup is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		} 
		Step_End(5, "Save the booking in Draft", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_Start(6, "Save the booking in Confirmed", test, test1);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		click(driver, AutoRated);


		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);



		waitForElement(driver, booking_no);	
		String submit_bookingColor1=getTextBackgroundColor(driver,booking_no);
		String submit_bookingColor=getColorName(submit_bookingColor1);
		if(submit_bookingColor.equals(booking_confirmed_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity  popup is : " + booking_confirmed_Color + " || The Actual Report Activity  popup is : " + submit_bookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity  popup is : " + booking_confirmed_Color + " || The Actual Report Activity  popup is : " + submit_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity  popup is : " + booking_confirmed_Color + " || The Actual Report Activity  popup is : " + submit_bookingColor+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity  popup is : " + booking_confirmed_Color + " || The Actual Report Activity  popup is : " + submit_bookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		}  

		Step_End(6, "Save the booking in Confirmed", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		Step_Start(7, "Release the CRO", test, test1);

		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);
		twoColumnSearchWindow(driver, CRO_search, CRO_search_condition, acc_term_value);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(7, "Release the CRO", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, Global_Book_num_search, booknum, "", "", "", "");
	
		waitForElement(driver, bl_contacts_tab);
		waitForElement(driver, ready_BL);
		String readyBL_status=getAttribute(driver, ready_BL, "class").trim();
		if(readyBL_status.contains(status)) {
			Extent_pass_New(driver,"Matched || Ready For Bl Check Box is Selected and the status is : "+status, test, test1);
			System.out.println("Matched || Ready For Bl Check Box is Selected and the status is : "+status); 
		}
		else {
			Extent_fail(driver,"Not Matched || Ready For Bl Check Box is Not Selected", test, test1);
			System.out.println("Not Matched || Ready For Bl Check Box is Not Selected");
		}

		waitForElement(driver, ready_OP);
		String readyOP_status=getAttribute(driver, ready_OP, "class").trim();
		if(readyOP_status.contains(status)) {
			Extent_pass_New(driver,"Matched || Ready For Operation Check Box is Selected and the status is : "+readyOP_status, test, test1);
			System.out.println("Matched || Ready For Operation Check Box is Selected and the status is : "+readyOP_status); 
		}
		else {
			Extent_fail(driver,"Not Matched || Ready For Operation Check Box is Not Selected", test, test1);
			System.out.println("Not Matched || Ready For Operation Check Box is Not Selected");
		}

		String Generated_Bl_Number = getAttribute(driver, booking_No_Txtfld, "value");


		Step_Start(2, "Open the Bill of Lading module", test, test1);

		moduleNavigate(driver, bol_module);


		Step_End(2, "Open the Bill of Lading module", test, test1);

		Step_Start(3, "By using book no local search retrieve the data", test, test1);

		waitForElement(driver, book_Number_Search_Icon_Bl);
		click(driver, book_Number_Search_Icon_Bl);
		
		globalValueSearchWindow(driver, dropdownCondition1, Select_search_By_bl, Generated_Bl_Number, "", "", "", "");
	
		Step_End(3, "By using book no local search retrieve the data", test, test1);

		Step_Start(4, "Edit the BL using tool bar & save the BL in draft status", test, test1);

		waitForElement(driver, bl_Edit_Button);
		click(driver, bl_Edit_Button);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, bl_Edit_Button);
		click(driver, bl_Edit_Button);

		Step_End(4, "Edit the BL using toolbar & save the BL in draft status", test, test1); 

		waitForElement(driver, bl_charges_Tab);
		click(driver, bl_charges_Tab);

		Step_Start(5, "By using two column search select any charge code", test, test1); 

		waitForElement(driver, bl_charge_code_search_icon);
		click(driver, bl_charge_code_search_icon);

		//chargecode
		twoColumnSearchWindow(driver, Charge_code_search, CRO_search_condition, charge_code_data);
		
		Step_End(5, "By using two column search select any charge code", test, test1); 

		Step_Start(6, "By using easy search select any base rate unit", test, test1); 

		//baserate unit
		waitForElement(driver, bl_base_rate_unit_search_icon);
		click(driver, bl_base_rate_unit_search_icon);
		twoColumnSearchWindow(driver, Unit_code_search, CRO_search_condition, base_rate_unit_data);
		
		Step_End(6, "By using easy search select any base rate unit", test, test1); 

		Step_Start(7, "By using easy search select the currency as USD", test, test1); 

		//currency
		waitForElement(driver, bl_currency_code_search_icon);
		click(driver, bl_currency_code_search_icon);
		twoColumnSearchWindow(driver, Currency_code_search, CRO_search_condition, currency_data);
		Step_Start(8, "By using two column search select the invoice currency as USD", test, test1); 

	

		Step_End(8, "By using two column search select the invoice currency as USD", test, test1); 

		Step_End(7, "By using easy search select the currency as USD", test, test1); 


		Step_Start(9, "Select the equipment type in dropdown", test, test1); 

		//equip type

		waitForElement(driver, bl_equipment_type_drpdwn);
		click(driver, bl_equipment_type_drpdwn);

		String bl_equipment_type_option=String.format(bl_equipment_type_drpdwn_options, equipment_type_data);
		waitForElement(driver, bl_equipment_type_option);
		click(driver, bl_equipment_type_option);

		Step_End(9, "Select the equipment type in dropdown", test, test1); 


		//base rate	
		waitForElement(driver, bl_base_rate_txtfld);
		doubleClick(driver, bl_base_rate_txtfld);
		sendKeys(driver, bl_base_rate_txtfld, base_rate_data);

		Step_Start(10, "Enter the amount in base rate field", test, test1); 

		//verify rate ref number

		waitForElement(driver, bl_rate_ref_No_txtfld);
		verifyElementHasText(driver, bl_rate_ref_No_txtfld);

		Step_End(10, "Enter the amount in base rate field", test, test1); 

		//payment mode

		waitForElement(driver, bl_payment_mode_drpdwn);
		click(driver, bl_payment_mode_drpdwn);

		Step_Start(11, "Select the payment mode as either prepaid/collect", test, test1); 

		String payment_mode_option=String.format(bl_payment_mode_options, payment_mode_data);
		click(driver, payment_mode_option);

		Step_End(11, "Select the payment mode as either prepaid/collect", test, test1); 

		waitForDisplay(driver, bl_charge_txtfld);
		if(verifyElementHasNoValue(driver, bl_charge_txtfld)) {

			waitForElement(driver, bl_charge_code_search_icon);
			click(driver, bl_charge_code_search_icon);
			//chargecode
			waitForElement(driver, bl_charge_code_txtfld);
			sendKeys(driver, bl_charge_code_txtfld, charge_code_data);
			waitForElement(driver, bl_panel_first_click);
			click(driver, bl_panel_first_click);
			click(driver, bl_panel_select_Btn);
		}

		Step_Start(12, "Click add button to proceed", test, test1); 

		waitForElement(driver, bl_add_button);
		click(driver, bl_add_button);

		Step_End(12, "Click add button to proceed", test, test1); 

		waitForElement(driver, bl_charges_table_header);
		List<Map<String, String>> charges_table = getTableData(driver, bl_charges_table_header, bl_charges_table_rows);

		String actual_auto_rate_value = getValueByFirstColumnAndHeader(charges_table, "Charge Code", charge_code_data, "Auto Rated");

		if(auto_Rated_Expected.equals(actual_auto_rate_value)) {

			System.out.println("Auto-rate value after adding the details ->|| Expected auto-rate value is : "+auto_Rated_Expected+"||Actual auto-rate value is :"+actual_auto_rate_value);
			Extent_pass_New(driver, "Auto-rate value after adding the details ->|| Expected auto-rate value is : "+auto_Rated_Expected+"||Actual auto-rate value is :"+actual_auto_rate_value, test, test1);

		}else {
			System.out.println("Auto-rate value after adding the details ->|| Expected auto-rate value is : "+auto_Rated_Expected+"||Actual auto-rate value is :"+actual_auto_rate_value);
			Extent_fail(driver, "Auto-rate value after adding the details ->|| Expected auto-rate value is : "+auto_Rated_Expected+"||Actual auto-rate value is :"+actual_auto_rate_value, test, test1);

		}


		waitForElement(driver, bl_master_tab);
		click(driver, bl_master_tab);

		Step_Start(13, "Click the confirm button in master tab & then save.", test, test1);

		waitForElement(driver, bl_confirm_btn);
		click(driver, bl_confirm_btn);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(13, "Click the confirm button in master tab & then save.", test, test1);


		Step_Start(14, "System will validate for Equipment type mismatch.", test, test1);

		waitForPopup(driver, bl_mismatch_pop,bl_mismatch_pop_exp);
		String bl_mismatch_pop_act = getText(driver, bl_mismatch_pop);
		System.out.println(bl_mismatch_pop_act);

		if(bl_mismatch_pop_act.trim().contains(bl_mismatch_pop_exp.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act, test,test1); 

		} 

		Step_End(14, "System will validate for Equipment type mismatch.", test, test1);

		waitForElement(driver, bl_mismatch_pop_close);
		click(driver, bl_mismatch_pop_close);

		Step_Start(15, "Entered the actual container in equipment id field and click edit button.", test, test1);
		waitForElement(driver, gird_edit);
		click(driver, gird_edit);
		waitForElement(driver, BL_equip_field);
		clear(driver, BL_equip_field);
		sendKeys(driver, BL_equip_field, Equipment_id_input);
		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);

		Step_End(15, "Entered the actual container in equipment id field and click edit button.", test, test1);

		waitForPopup(driver, popup_Message,carrier_pop_exp);
		String Reset_pop_act = getText(driver, popup_Message);
		System.out.println(Reset_pop_act);
		Step_Start(16, "Now system should validate for carrier Seal.", test, test1);

		if(carrier_pop_exp.trim().contains(Reset_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1); 

		} 

		Step_End(16, "Now system should validate for carrier Seal.", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);


		Step_Start(17, "Entered the carrier Seal and click edit.", test, test1);
		waitForElement(driver, carr_seal_input);
		clear(driver, carr_seal_input);
		sendKeys(driver, carr_seal_input, carr_seal_input_value);
		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);

		Step_End(17, "Entered the carrier Seal and click edit.", test, test1);

		Step_Start(18, "Now again click save button then system validate to enter the shipper.", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		
		
		
		waitForPopup(driver, popup_Message,package_exp);
		String package_act = getText(driver, popup_Message);
		
		
		if(package_act.equals(package_exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp, test,test1); 
			
		} 
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		
		waitForElement(driver, commodity_gird_edit);
		doubleClick(driver, commodity_gird_edit);
		
		
		waitForElement(driver, bl_package_txtfld);
		sendKeys(driver, bl_package_txtfld, Package_value_input);
		enter(driver);
		waitForElement(driver, bl_commodity_add_button);
		click(driver, bl_commodity_add_button);
//		waitForElement(driver, SaveButton_ToolBar);
//		click(driver, SaveButton_ToolBar);
		
		
		
		waitForDisplay(driver, valid_commodity_pop);
		if(isdisplayed(driver, valid_commodity_pop)) {
			waitForPopup(driver, valid_commodity_pop,valid_comm_pop_exp);
		String valid_comm_pop_act = getText(driver, valid_commodity_pop);
		System.out.println(valid_comm_pop_act);

		if(valid_comm_pop_exp.trim().equals(valid_comm_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act, test,test1); 
			
		} 
		waitForElement(driver, valid_commodity_pop_ok);
		click(driver, valid_commodity_pop_ok);
		}
		waitForDisplay(driver, commodity_discription_pop);
		if(isdisplayed(driver, commodity_discription_pop)) {
			waitForPopup(driver, commodity_discription_pop,comm_dis_pop_exp);
		String comm_dis_pop_act = getText(driver, commodity_discription_pop);
		System.out.println(comm_dis_pop_act);

		if(comm_dis_pop_exp.trim().contains(comm_dis_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act, test,test1); 
			
		} 
		waitForElement(driver, commodity_discription_pop_ok);
		click(driver, commodity_discription_pop_ok);	
		}
		waitForDisplay(driver, marks_number_pop);
		if(isdisplayed(driver, marks_number_pop)) {
			waitForPopup(driver, marks_number_pop,marks_number_pop_exp);
		String marks_number_pop_act = getText(driver, marks_number_pop);
		System.out.println(marks_number_pop_act);

		if(marks_number_pop_exp.trim().contains(marks_number_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act, test,test1); 
			
		} 
		waitForElement(driver, marks_number_pop_ok);
		click(driver, marks_number_pop_ok);	
		}
		waitForDisplay(driver, enter_commodity_pop);
		if(isdisplayed(driver, enter_commodity_pop)) {
			waitForPopup(driver, enter_commodity_pop,enter_commodity_pop_exp);
		String enter_commodity_pop_act = getText(driver, enter_commodity_pop);
		System.out.println(enter_commodity_pop_act);

		if(enter_commodity_pop_exp.trim().contains(enter_commodity_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act, test,test1); 
			
		} 
		waitForElement(driver, enter_commodity_pop_ok);
		click(driver, enter_commodity_pop_ok);	
		}
		
		waitForDisplay(driver, enter_package_pop);
		if(isdisplayed(driver, enter_package_pop)) {
			waitForPopup(driver, enter_package_pop,enter_package_pop_exp);
		String enter_package_pop_act = getText(driver, enter_package_pop);
		System.out.println(enter_package_pop_act);

		if(enter_package_pop_exp.trim().contains(enter_package_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
			
		} 
		waitForElement(driver, enter_package_pop_ok);
		click(driver, enter_package_pop_ok);
		}
		
		waitForDisplay(driver, commodity_group);
		if(isdisplayed(driver, commodity_group)) {
			waitForPopup(driver, commodity_group,Commodity_group);
		String enter_package_pop_act = getText(driver, commodity_group);
		System.out.println(enter_package_pop_act);

		if(Commodity_group.trim().contains(enter_package_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
			
		} 
		waitForElement(driver, commodity_group_ok);
		click(driver, commodity_group_ok);
		}
		
		waitForDisplay(driver, Package_quantity);
		if(isdisplayed(driver, Package_quantity)) {
			waitForPopup(driver, Package_quantity,Package_Quantity);
		String enter_package_pop_act = getText(driver, Package_quantity);
		System.out.println(enter_package_pop_act);

		if(Package_Quantity.trim().contains(enter_package_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
			
		} 
		waitForElement(driver, Package_quantity_ok);
		click(driver, Package_quantity_ok);
		}
		
		
		
		waitForElement(driver, quantity_input);
		clearAndType(driver, quantity_input, Quantity_value_input);


	

		waitForElement(driver, commodity_grp);
		clear(driver, commodity_grp);
		sendKeys(driver, commodity_grp, commodity_grp_input);
		enter(driver);

		waitForElement(driver, hs_search);
		click(driver, hs_search);
		globalValueSearchWindow(driver, dropdownCondition1, Select_search_value_hs, HS_code_input_value, "", "", "", "");
	

		waitForElement(driver, mark_number);
		clearAndType(driver, mark_number, mark_number_input);	
		waitForElement(driver, commodity_dcse);
		clearAndType(driver, commodity_dcse, commodity_desc_input);	
		waitForElement(driver, MCN_CargoWeight);
		click(driver, MCN_CargoWeight);
		Actionsendkeys(driver, MCN_CargoWeight, commodity_Cargo_Weight_input);
		click(driver, commodity_grp);

		Step_Start(28, "Now click save button system validate to enter the Following mandatory charges.", test, test1);
		waitForElement(driver, bl_commodity_add_button);
		click(driver, bl_commodity_add_button);

		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);
			
		}
		
		
		
		
		
		
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		

		waitForPopup(driver, shipper_pop,shipper_pop_exp);
		String shipper_pop_act = getText(driver, shipper_pop);
		System.out.println(shipper_pop_act);

		if(shipper_pop_exp.trim().contains(shipper_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity  POPUP is : " + shipper_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity  POPUP is : " + shipper_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity  POPUP is : " + shipper_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity  POPUP is : " + shipper_pop_act, test,test1); 

		} 
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);

		Step_End(18, "Now again click save button then system validate to enter the shipper.", test, test1);

		waitForElement(driver, customer_type_dp);
		click(driver, customer_type_dp);
		String customer_type_selectt=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input);
		waitForElement(driver, customer_type_selectt);
		click(driver, customer_type_selectt);
		waitForElement(driver, customer_easy_search);
		sendKeys(driver, customer_easy_search, customer_easy_search_input);
		waitForElement(driver, customer_easy_search_select);
		click(driver, customer_easy_search_select);
		waitForElement(driver, customer_Add_btn);
		click(driver, customer_Add_btn);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_Start(20, "Now system validate to enter the consignee.", test, test1);

		waitForPopup(driver, consignee_pop,consignee_pop_exp);
		String consignee_pop_act = getText(driver, consignee_pop);
		System.out.println(consignee_pop_act);

		if(consignee_pop_exp.trim().contains(consignee_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act, test,test1); 

		} 

		Step_End(20, "Now system validate to enter the consignee.", test, test1);

		waitForElement(driver, shipper_close);
		click(driver, shipper_close);

		Step_Start(21, "Enter Consignee customer details and click save button.", test, test1);
		waitForElement(driver, customer_type_dp);
		click(driver, customer_type_dp);
		String customer_type_selectt_con=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input_CONSIGNEE);
		waitForElement(driver, customer_type_selectt_con);
		click(driver, customer_type_selectt_con);
		waitForElement(driver, customer_easy_search);
		sendKeys(driver, customer_easy_search, customer_easy_search_input_consignee);
		waitForElement(driver, customer_easy_search_select);
		click(driver, customer_easy_search_select);
		waitForElement(driver, customer_Add_btn);
		click(driver, customer_Add_btn);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(21, "Enter Consignee customer details and click save button.", test, test1);

		Step_Start(22, "Now system validate to enter the Notify party.", test, test1);

		waitForPopup(driver, notify_pop,notify_pop_exp);
		String notify_pop_act = getText(driver, notify_pop);
		System.out.println(notify_pop_act);

		if(notify_pop_exp.trim().contains(notify_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act, test,test1); 

		} 

		Step_End(22, "Now system validate to enter the Notify party.", test, test1);

		waitForElement(driver, shipper_close);
		click(driver, shipper_close);

		Step_Start(23, "Enter notify party and click save button.", test, test1);

		waitForElement(driver, customer_type_dp);
		click(driver, customer_type_dp);
		String customer_type_selectt_not=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input_Notify);
		waitForElement(driver, customer_type_selectt_not);
		click(driver, customer_type_selectt_not);
		waitForElement(driver, customer_easy_search);
		sendKeys(driver, customer_easy_search, customer_easy_search_input_notify);
		waitForElement(driver, customer_easy_search_select);
		click(driver, customer_easy_search_select);
		waitForElement(driver, customer_Add_btn);
		click(driver, customer_Add_btn);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(23, "Enter notify party and click save button.", test, test1);

		Step_Start(24, "Now system validate to enter cargo weight.", test, test1);
		
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);
		Step_End(24, "Now system validate to enter cargo weight.", test, test1);

		Step_Start(25, "Edit commodity and enter cargo weight then click on edit button.", test, test1);



		Step_Start(29, "Click on auto rate button, once charges pop up now click save button.", test, test1);
		waitForElement(driver, Auto_rate_button);
		click(driver, Auto_rate_button);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(29, "Click on auto rate button, once charges pop up now click save button.", test, test1);


		Step_Start(30, "Now system validate to enter the description of goods.", test, test1);
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);	

		Step_End(30, "Now system validate to enter the description of goods.", test, test1);

		Step_Start(32, "Click on cargo summary button and click save.", test, test1);
		waitForElement(driver, cargo_summary);
		click(driver, cargo_summary);	

		Step_End(32, "Click on cargo summary button and click save.", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);


		waitForPopup(driver, popup_Message,updated_pop_exp);
		String saved_pop_act= getText(driver, popup_Message);
		System.out.println(saved_pop_act);

		if(saved_pop_act.contains(updated_pop_exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act, test,test1); 

		} 
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_Start(33, "Now BL should be confirmed and BL number indication should be in green color.", test, test1);
		waitForElement(driver, BL_no);
		String bill_number= getAttribute(driver, BL_no,"value");
		System.out.println(bill_number);
		Extent_call(test, test1, "****Bill number was generated as **"+bill_number);

		String bill_number_colour1= getTextBackgroundColor(driver, BL_no);
		String bill_number_colour=getColorName(bill_number_colour1);
		System.out.println(bill_number_colour);




		if(booking_confirmed_Color.contains(bill_number_colour)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour, test,test1); 

		} 


		Step_End(33, "Now BL should be confirmed and BL number indication should be in green color.", test, test1);

		Extent_completed(testcase_Name, test, test1);










	}
}
