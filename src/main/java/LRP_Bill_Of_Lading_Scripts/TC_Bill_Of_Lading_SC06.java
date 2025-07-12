package LRP_Bill_Of_Lading_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Bill_Of_Lading_Locators;

public class TC_Bill_Of_Lading_SC06 extends Keywords{

	public void Bill_Of_Lading_SC06(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Bill_Of_Lading_SC06";
		
		
		


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
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String status = Excel_data.get("status").trim();
		String search_module = Excel_data.get("search_module");
		String first_service_data = Excel_data.get("first_service_data");
		String row_to_select = Excel_data.get("row_to_select");
		String no_of_rows_to_copy = Excel_data.get("no_of_rows_to_copy");
		String copy_option = Excel_data.get("copy_option");
		String equipment_id_to_copy = Excel_data.get("equipment_id_to_copy");
		String Customer_type_input = Excel_data.get("Customer_type_input");
		String global_search1_by_cust_code = Excel_data.get("global_search1_by_cust_code");
		String system_code_data = Excel_data.get("system_code_data");
		String Customer_type_input_CONSIGNEE = Excel_data.get("Customer_type_input_CONSIGNEE");
		String customer_easy_search_input_consignee = Excel_data.get("customer_easy_search_input_consignee");
		String copy_action = Excel_data.get("copy_action");
		String consignee_customer_cell = Excel_data.get("consignee_customer_cell");
		String notify_option = Excel_data.get("notify_option");
		String shipper_pop_exp = Excel_data.get("shipper_pop_exp");
		String updated_pop_exp = Excel_data.get("updated_pop_exp");
		String comm_dis_pop_exp = Excel_data.get("comm_dis_pop_exp");
		String enter_commodity_pop_exp = Excel_data.get("enter_commodity_pop_exp");
		String mark_number_input = Excel_data.get("mark_number_input");
		String commodity_desc_input = Excel_data.get("commodity_desc_input");
		String commodity_Cargo_Weight_input = Excel_data.get("commodity_Cargo_Weight_input");
		String enter_package_pop_exp = Excel_data.get("enter_package_pop_exp");
		String marks_number_pop_exp = Excel_data.get("marks_number_pop_exp");
		String valid_comm_pop_exp = Excel_data.get("valid_comm_pop_exp");
		String Quantity_value_input = Excel_data.get("Quantity_value_input");
		String Package_value_input = Excel_data.get("Package_value_input");
		String commodity_grp_input = Excel_data.get("commodity_grp_input");
		String Select_search_value_hs = Excel_data.get("Select_search_value_hs");
		String HS_code_input_value = Excel_data.get("HS_code_input_value");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String CRO_search = Excel_data.get("CRO_search");
		String Global_Book_num_search = Excel_data.get("Global_Book_num_search");
		String CRO_search_condition = Excel_data.get("CRO_search_condition");
		String equipment_id_to_copy1 = Excel_data.get("equipment_id_to_copy1");
		String carrer_seal_input_2 = Excel_data.get("carrer_seal_input_2");
		String carrer_seal_input_1 = Excel_data.get("carrer_seal_input_1");
		String Commodity_group = Excel_data.get("Commodity_group");
		String Package_Quantity = Excel_data.get("Package_Quantity");
		String package_exp = Excel_data.get("Package_pop_expected");
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
	
		Extent_call(test, test1,"**Switch the Profile Start**");

		Step_Start(1, "Switch to agency", test, test1);

		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch to agency", test, test1);
		//

		Step_Start(2, "Open the Booking module", test, test1);
		moduleNavigate(driver, search_module);

		Step_End(2, "Open the Booking module", test, test1);

		Step_Start(3, "Enter the Agreement Party in master tab", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(3, "Enter the Agreement Party in master tab", test, test1);

		Step_Start(4, "Enter the POL and POD and select the Rates using Rates window", test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);



		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		waitForElement(driver, Draft_Button);
		safeclick(driver, Draft_Button);

scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		
		Step_End(7, "Save the booking in Draft status", test, test1);

		Step_Start(8, "Edit the booking & select the container in container tab and click copy", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, booking_container_tab);
		click(driver, booking_container_tab);


		String booking_container_rows=String.format(booking_container_table_rows, row_to_select);
		waitForElement(driver, booking_container_rows);
		RightClick(driver, booking_container_rows);

		String booking_copy_btn=String.format(booking_copy_option, copy_option);
		waitForElement(driver, booking_copy_btn);
		click(driver, booking_copy_btn);

		Step_End(8, "Edit the booking & select the container in container tab and click copy", test, test1);

		Step_Start(9, "Enter the no. of additional container in enter the rows column & click ok", test, test1);

		waitForElement(driver, booking_copy_window);
		sendKeys(driver, booking_copy_rows_input, no_of_rows_to_copy);

		waitForElement(driver, booking_copy_rows_ok_btn);
		click(driver, booking_copy_rows_ok_btn);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		Step_End(9, "Enter the no. of additional container in enter the rows column & click ok", test, test1);

		Step_Start(11, "Select the confirm button in master tab & save the booking", test, test1);

		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		
		
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);

		Step_Start(10, "Click autorate button in charges tab", test, test1);

		waitForElement(driver, AutoRated);
		click(driver, AutoRated);

		Step_End(10, "Click autorate button in charges tab", test, test1);

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


		Step_End(11, "Select the confirm button in master tab & save the booking", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		Step_Start(12, "Click CRO navigation button", test, test1);

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
	
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(12, "Click CRO navigation button", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, Global_Book_num_search, booknum, "", "", "", "");
		
		waitForElement(driver, ready_BL);
		waitForElement(driver, ready_BL);
		String readyBL_status=getAttribute(driver, ready_BL, "class").trim();
		if(readyBL_status.contains(status)) {
			Extent_pass_New(driver,"Matched ||Excepted  Ready For Bl Check Box is should be Selected and the status is:"+ readyBL_status +" Actual Ready For Bl Check Box is  be Selected and the status is:"+ status, test, test1);
			System.out.println("Matched ||Excepted Ready For Bl Check Box is should be Selected and the status is:"+ readyBL_status +" Actual Ready For Bl Check Box is  be Selected and the status is:"+ status);
		}
		else {
			System.out.println("Not matched ||Excepted Ready For Bl Check Box is should be Selected and the status is:"+ readyBL_status +" Actual Ready For Bl Check Box is not  be Selected and the status is:"+ status);
			Extent_fail(driver,"Not matched ||Excepted Ready For Bl Check Box is should be Selected and the status is:"+ readyBL_status +" Actual Ready For Bl Check Box is  not be Selected and the status is:"+ status, test, test1);
		}
	

		waitForElement(driver, ready_OP);
		String readyOP_status=getAttribute(driver, ready_OP, "class").trim();
		if(readyOP_status.contains(status)) {
			Extent_pass_New(driver,"Matched ||Excepted Ready For Operation Check Box is Selected and the status is:"+ readyOP_status +" Actual Ready For Operation Check Box is Selected and the status is:"+ status, test, test1);
			System.out.println("Matched ||Excepted Ready For Operation Check Box is Selected and the status is:"+ readyOP_status +" Actual Ready For Bl Check Box is  be Selected and the status is:"+ status);
		}
		else {
			System.out.println("Not matched ||Excepted Ready For Operation Check Box is Selected and the status is:"+ readyOP_status +" Actual Ready For Operation Check Box is not Selected and the status is:"+ status);
			Extent_fail(driver,"Not matched ||Excepted Ready For Operation Check Box is Selected and the status is:"+ readyOP_status +" Actual Ready For Operation Check Box isnot  Selected and the status is:"+ status, test, test1);
		}

		String Generated_Bl_Number = getAttribute(driver, booking_No_Txtfld, "value");

		Step_Start(13, "In toolbar click edit and save", test, test1);
		Step_End(13, "In toolbar click edit and save", test, test1);

		Step_Start(14, "Open the Bill of Lading module", test, test1);

		moduleNavigate(driver, bol_module);

		Step_End(14, "Open the Bill of Lading module", test, test1);

		Step_Start(15, "By using book no local search retrieve the data", test, test1);

		waitForElement(driver, book_Number_Search_Icon_Bl);
		click(driver, book_Number_Search_Icon_Bl);
		globalValueSearchWindow(driver, dropdownCondition1, Select_search_By_bl, Generated_Bl_Number, "", "", "", "");
		

		Step_End(15, "By using book no local search retrieve the data", test, test1);

		Step_Start(16, "Edit the BL using tool bar & save the BL in draft status", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
	

		Step_End(16, "Edit the BL using tool bar & save the BL in draft status", test, test1);

		Step_Start(17, "Click the smart import button in container tab", test, test1);

		waitForElement(driver, bl_Container_Tab);
		click(driver, bl_Container_Tab);
		waitForElement(driver, bl_smart_import_btn);
		waitForElement(driver, bl_smart_import_btn);
		click(driver, bl_smart_import_btn);

		Step_End(17, "Click the smart import button in container tab", test, test1);

		Step_Start(18, "Paste all the actual containers in Actual Eqp.ID column & carrier seal", test, test1);

	
		waitForElement(driver, booking_actual_Equip_id_cell);
		mouseOverToElement(driver, booking_actual_Equip_id_cell);
		click(driver, booking_actual_Equip_id_cell);
		Actionsendkeys(driver, booking_actual_Equip_id_cell, equipment_id_to_copy);
		enter(driver);
		waitForElement(driver, booking_actual_Equip_id_cell1);
		mouseOverToElement(driver, booking_actual_Equip_id_cell1);
		click(driver, booking_actual_Equip_id_cell1);
		Actionsendkeys(driver, booking_actual_Equip_id_cell1, equipment_id_to_copy1);
		enter(driver);
		Step_End(18, "Paste all the actual containers in Actual Eqp.ID column & carrier seal", test, test1);

		Step_Start(19, "Click the paste button", test, test1);
		waitForElement(driver, Carrerseal_add1);
		mouseOverToElement(driver, Carrerseal_add1);
		click(driver, Carrerseal_add1);
		doubleClick(driver, Carrerseal_add1);
		Actionsendkeys(driver, Carrerseal_add1, carrer_seal_input_1);
		enter(driver);

		waitForElement(driver, Carrerseal_add2);
		mouseOverToElement(driver, Carrerseal_add2);
		click(driver, Carrerseal_add2);
		doubleClick(driver, Carrerseal_add2);
		Actionsendkeys(driver, Carrerseal_add2, carrer_seal_input_2);
		enter(driver);

		waitForElement(driver, bl_container_paste_button);
		click(driver, bl_container_paste_button);

		Step_End(19, "Click the paste button", test, test1);

		Step_Start(20, "System will update the actual containers in container grid", test, test1);

		waitForElement(driver, bl_container_Table_headers);
		List<Map<String, String>> container_table_data = getTableData(driver, bl_container_Table_headers, bl_container_Table_Rows);
		List<String> copied_equipment_ids = getValuesByHeader(container_table_data, "Equipment ID");

		System.out.println("copied equipment id's are : "+copied_equipment_ids);

		waitForElement(driver, bl_master_tab);
		click(driver, bl_master_tab);
		waitForElement(driver, bl_confirm_btn);
		waitForElement(driver, bl_confirm_btn);
		safeclick(driver, bl_confirm_btn);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		
		
		
		
		waitForPopup(driver, popup_Message,package_exp);
		String package_act = getText(driver, popup_Message);
		
		
		if(package_act.equals(package_exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + package_act + " || Actual Report Activity POPUP is : " + package_exp);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + package_act + " || Actual Report Activity POPUP is : " + package_exp, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + package_act + " || Actual Report Activity POPUP is : " + package_exp);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + package_act + " || Actual Report Activity POPUP is : " + package_exp, test,test1); 
			
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
		
		
		
		waitForDisplay(driver, valid_commodity_pop);
		if(isdisplayed(driver, valid_commodity_pop)) {
			waitForPopup(driver, popup_Message,valid_comm_pop_exp);
		String valid_comm_pop_act = getText(driver, valid_commodity_pop);
		System.out.println(valid_comm_pop_act);

		if(valid_comm_pop_exp.trim().equals(valid_comm_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity POPUP is : " + valid_comm_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity POPUP is : " + valid_comm_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity POPUP is : " + valid_comm_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity POPUP is : " + valid_comm_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity POPUP is : " + comm_dis_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity POPUP is : " + comm_dis_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity POPUP is : " + comm_dis_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity POPUP is : " + comm_dis_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity POPUP is : " + marks_number_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity POPUP is : " + marks_number_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity POPUP is : " + marks_number_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity POPUP is : " + marks_number_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity POPUP is : " + enter_commodity_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity POPUP is : " + enter_commodity_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity POPUP is : " + enter_commodity_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity POPUP is : " + enter_commodity_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity POPUP is : " + enter_package_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + Commodity_group + " || Actual Report Activity POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + Commodity_group + " || Actual Report Activity POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + Commodity_group + " || Actual Report Activity POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + Commodity_group + " || Actual Report Activity POPUP is : " + enter_package_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + Package_Quantity + " || Actual Report Activity POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + Package_Quantity + " || Actual Report Activity POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + Package_Quantity + " || Actual Report Activity POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + Package_Quantity + " || Actual Report Activity POPUP is : " + enter_package_pop_act, test,test1); 
			
		} 
		waitForElement(driver, Package_quantity_ok);
		click(driver, Package_quantity_ok);
		}

		waitForElement(driver, quantity_input);
		clearAndType(driver, quantity_input, Quantity_value_input);

		Step_End(34, "Enter the Quantity.", test, test1);

		Step_Start(35, "Enter the package using easy search.", test, test1);

		
		Step_End(35, "Enter the package using easy search.", test, test1);

		Step_Start(36, "Choose hs code by entering % in local search, mark no and commodity desc then click edit button.", test, test1);

		waitForElement(driver, commodity_grp);
		clearAndType(driver, commodity_grp, commodity_grp_input);
		enter(driver);
		waitForElement(driver, hs_search);
		click(driver, hs_search);
		
		
		globalValueSearchWindow(driver, dropdownCondition1, Select_search_value_hs, HS_code_input_value, "", "", "", "");
		
		
		

		Step_End(36, "Choose hs code by entering % in local search, mark no and commodity desc then click edit button.", test, test1);


		waitForElement(driver, mark_number);
		clearAndType(driver, mark_number, mark_number_input);	
		waitForElement(driver, commodity_dcse);
		clearAndType(driver, commodity_dcse, commodity_desc_input);	

		click(driver, commodity_grp);
		
		waitForElement(driver, MCN_CargoWeight);
		clear(driver, MCN_CargoWeight);
		sendKeys(driver, MCN_CargoWeight, commodity_Cargo_Weight_input);

		waitForElement(driver, bl_commodity_add_button);
		click(driver, bl_commodity_add_button);
		
		
		waitForElement(driver, commodity_gird_edit2);
		click(driver, commodity_gird_edit2);
		
		waitForElement(driver, bl_package_txtfld);
		sendKeys(driver, bl_package_txtfld, Package_value_input);
		enter(driver);

		waitForElement(driver, quantity_input);
		clearAndType(driver, quantity_input, Quantity_value_input);

		Step_End(34, "Enter the Quantity.", test, test1);

		Step_Start(35, "Enter the package using easy search.", test, test1);

		
		Step_End(35, "Enter the package using easy search.", test, test1);

		Step_Start(36, "Choose hs code by entering % in local search, mark no and commodity desc then click edit button.", test, test1);

		waitForElement(driver, commodity_grp);
		clearAndType(driver, commodity_grp, commodity_grp_input);
		enter(driver);
		waitForElement(driver, hs_search);
		click(driver, hs_search);
		
		
		globalValueSearchWindow(driver, dropdownCondition1, Select_search_value_hs, HS_code_input_value, "", "", "", "");
		
		
		

		Step_End(36, "Choose hs code by entering % in local search, mark no and commodity desc then click edit button.", test, test1);


		waitForElement(driver, mark_number);
		clearAndType(driver, mark_number, mark_number_input);	
		waitForElement(driver, commodity_dcse);
		clearAndType(driver, commodity_dcse, commodity_desc_input);	

		click(driver, commodity_grp);
		
		waitForElement(driver, MCN_CargoWeight);
		clear(driver, MCN_CargoWeight);
		sendKeys(driver, MCN_CargoWeight, commodity_Cargo_Weight_input);

		waitForElement(driver, bl_commodity_add_button);
		click(driver, bl_commodity_add_button);

		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		
		}
	//

	Step_Start(37, "Now click save button system validate to enter the Following mandatory charges.", test, test1);

	waitForElement(driver, SaveButton_ToolBar);
	click(driver, SaveButton_ToolBar);


		
		
		
		
		Step_End(20, "System will update the actual containers in container grid", test, test1);

		Step_Start(21, "In customer tab, Select the customer type as 'Shipper'", test, test1);

		waitForPopup(driver, shipper_pop,shipper_pop_exp);
		String shipper_pop_act = getText(driver, shipper_pop);
		System.out.println(shipper_pop_act);

		if(shipper_pop_exp.trim().contains(shipper_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity POPUP is : " + shipper_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity POPUP is : " + shipper_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity POPUP is : " + shipper_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity POPUP is : " + shipper_pop_act, test,test1); 

		} 
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);

		waitForElement(driver, bl_customer_tab);
		click(driver, bl_customer_tab);
		waitForElement(driver, customer_type_dp);
		click(driver, customer_type_dp);
		String customer_type_selectt=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input);
		waitForElement(driver, customer_type_selectt);
		click(driver, customer_type_selectt);

		Step_End(21, "In customer tab, Select the customer type as 'Shipper'", test, test1);

		Step_Start(22, "By entering % symbol in JDLC customer search system will list all the customers", test, test1);

		waitForElement(driver, bl_customer_search_icon);
		click(driver, bl_customer_search_icon);
		
		globalValueSearchWindow(driver, dropdownCondition1, global_search1_by_cust_code, system_code_data, "", "", "", "");
		
		
	

		waitForElement(driver, customer_Add_btn);
		click(driver, customer_Add_btn);

		Step_End(23, "Select the shipper customer details and click add button", test, test1);

		Step_Start(24, "Now Select the customer type as 'Consignee'", test, test1);

		waitForElement(driver, customer_type_dp);
		click(driver, customer_type_dp);
		String customer_type_selectt_con=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input_CONSIGNEE);
		waitForElement(driver, customer_type_selectt_con);
		click(driver, customer_type_selectt_con);

		Step_End(24, "Now Select the customer type as 'Consignee'", test, test1);

		Step_Start(25, "By using Easy search system will list all the customers", test, test1);

		waitForElement(driver, customer_easy_search);
		sendKeys(driver, customer_easy_search, customer_easy_search_input_consignee);
		waitForElement(driver, customer_easy_search_select);
		click(driver, customer_easy_search_select);

		Step_End(25, "By using Easy search system will list all the customers", test, test1);

		Step_Start(26, "Select the consignee customer details and click add button", test, test1);

		waitForElement(driver, customer_Add_btn);
		click(driver, customer_Add_btn);

		Step_End(26, "Select the consignee customer details and click add button", test, test1);

		Step_Start(27, "Right click on the Consignee customer and click copy", test, test1);

		String Cn_cell = String.format(bl_consignee_customer_cell, consignee_customer_cell);
		waitForElement(driver, Cn_cell);
		RightClick(driver, Cn_cell);

		String copy_cell = String.format(bl_copy_action, copy_action);
		waitForElement(driver, copy_cell);
		click(driver, copy_cell);
		Step_End(27, "Right click on the Consignee customer and click copy", test, test1);

		Step_Start(28, "Select the Customer type as 'Notify' & click paste", test, test1);

		waitForElement(driver, bl_paste_window);
		String bl_paste_window_notify=String.format(bl_paste_window_notify_option, notify_option);
		waitForElement(driver, bl_paste_window_notify);
		click(driver, bl_paste_window_notify);

		waitForElement(driver, bl_paste_window_paste_button);
		click(driver, bl_paste_window_paste_button);
		Step_End(28, "Select the Customer type as 'Notify' & click paste", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		//attach charges mandate popup

		waitForElement(driver, shipper_close);
		click(driver, shipper_close);

		waitForElement(driver, bl_autorate_Btn);
		click(driver, bl_autorate_Btn);

		waitForElement(driver, bl_charges_table_rows);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_Start(31, "While save system validate to enter cargo weight.", test, test1);


	

		Step_End(31, "While save system validate to enter cargo weight.", test, test1);

		waitForElement(driver, shipper_close);
		click(driver, shipper_close);

		//need here to add loop	


	
		Step_End(38, "Click on auto rate button, once charges pop up now click save button.", test, test1);


		Step_Start(39, "Now system validate to enter the description of goods.", test, test1);


		Step_End(39, "Now system validate to enter the description of goods.", test, test1);

		waitForElement(driver, cargo_summary);
		click(driver, cargo_summary);	

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(40, "Click on cargo summary button and click save.", test, test1);

		//

		waitForPopup(driver, popup_Message,updated_pop_exp);
		String saved_pop_act= getText(driver, popup_Message);
		System.out.println(saved_pop_act);

		if(saved_pop_act.contains(updated_pop_exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity POPUP is : " + saved_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity POPUP is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity POPUP is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity POPUP is : " + saved_pop_act, test,test1); 

		} 
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);


		waitForElement(driver, BL_no);
		String bill_number= getAttribute(driver, BL_no,"value");
		System.out.println(bill_number);
		Extent_call(test, test1, "****Bill number was generated as **"+bill_number);

		String bill_number_colour1= getTextBackgroundColor(driver, BL_no);
		String bill_number_colour=getColorName(bill_number_colour1);
		System.out.println(bill_number_colour);

		Step_Start(41, "Now bl number should be confirmed and bl number indication should be in green color.", test, test1);

		if(booking_confirmed_Color.contains(bill_number_colour)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour, test,test1); 

		} 

		Step_End(41, "Now bl number should be confirmed and bl number indication should be in green color.", test, test1);


		Extent_completed(testcase_Name, test, test1);











	}
}
