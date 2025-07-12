package LRP_Bill_Of_Lading_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Bill_Of_Lading_Locators;

public class TC_Bill_Of_Lading_SC04  extends Keywords{
	
	public void Bill_Of_Lading_SC04(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
	String testcase_Name="TC_Bill_Of_Lading_SC04";
	
	
	


	String Username = Excel_data.get("Username");
	String Password = Excel_data.get("Password");
	String search_module = Excel_data.get("search_module");
	String agencyUser = Excel_data.get("agencyUser");
	String arg_party = Excel_data.get("arg_party");
	String origin = Excel_data.get("origin");
	String delivery = Excel_data.get("delivery");
	String rate_no = Excel_data.get("rate_no");
	String first_service_data = Excel_data.get("first_service_data");
	String Voyagenumber1 = Excel_data.get("Voyagenumber1");
	String Boundinput = Excel_data.get("Boundinput");
	String booking_draft_Color = Excel_data.get("booking_draft_Color");
	String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
	String status = Excel_data.get("status");
	String Module_Search_BL = Excel_data.get("Module_Search");
	String dropdownCondition1 = Excel_data.get("dropdownCondition1");
	String Select_search_value_bill = Excel_data.get("Select_search_value_bill");
	String Reset_pop_exp = Excel_data.get("Reset_pop_exp");
	String rate_ref_number = Excel_data.get("rate_ref_number");
	String gird_edit_Equ_id = Excel_data.get("gird_edit_Equ_id");
	String carrier_pop_exp = Excel_data.get("carrier_pop_exp");
	String carrier_seal_input = Excel_data.get("carrier_seal_input");
	String BL_equip_field_input = Excel_data.get("BL_equip_field_input");
	String Saved_pop_draft = Excel_data.get("Saved_pop_draft");
	String shipper_pop_exp = Excel_data.get("shipper_pop_exp");
	String Customer_type_input = Excel_data.get("Customer_type_input");
	String customer_easy_search_input = Excel_data.get("customer_easy_search_input_shipper");
	String consignee_pop_exp = Excel_data.get("consignee_pop_exp");
	String Customer_type_input_CONSIGNEE = Excel_data.get("Customer_type_input_CONSIGNEE");
	String notify_pop_exp = Excel_data.get("notify_pop_exp");
	String customer_easy_search_input_consignee = Excel_data.get("customer_easy_search_input_consignee");
	String Customer_type_input_Notify = Excel_data.get("Customer_type_input_Notify");
	String customer_easy_search_input_notify = Excel_data.get("customer_easy_search_input_notify");
	String cargo_pop_exp = Excel_data.get("cargo_pop_exp");
	String commodity_Cargo_Weight_input = Excel_data.get("commodity_Cargo_Weight_input");
	String Quantity_value_input = Excel_data.get("Quantity_value_input");
	String Package_value_input = Excel_data.get("Package_value_input");
	String commodity_grp_input = Excel_data.get("commodity_grp_input");
	String HS_code_input_value = Excel_data.get("HS_code_input_value");
	String commodity_desc_input = Excel_data.get("commodity_desc_input");
	String mark_number_input = Excel_data.get("mark_number_input");
	String Last_pop = Excel_data.get("Last_pop");
	String Select_search_value_hs = Excel_data.get("Select_search_value_hs");
	String updated_pop_exp = Excel_data.get("updated_pop_exp");
	String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
	String CRO_search = Excel_data.get("CRO_search");
	String Global_Book_num_search = Excel_data.get("Global_Book_num_search");
	String CRO_search_condition = Excel_data.get("CRO_search_condition");
	String gird_editt1=String.format(Bill_Of_Lading_Locators.gird_edit1, gird_edit_Equ_id);
	String gird_editt11=String.format(Bill_Of_Lading_Locators.gird_edit1, BL_equip_field_input);
	String enter_commodity_pop_exp = Excel_data.get("enter_commodity_pop_exp");
	String enter_package_pop_exp = Excel_data.get("enter_package_pop_exp");
	String Commodity_group = Excel_data.get("Commodity_group");
	String Package_Quantity = Excel_data.get("Package_Quantity");
	String Unit = Excel_data.get("Unit");
	String comm_dis_pop_exp = Excel_data.get("comm_dis_pop_exp");
	String marks_number_pop_exp = Excel_data.get("marks_number_pop_exp");
	String valid_comm_pop_exp = Excel_data.get("valid_comm_pop_exp");
	String package_exp = Excel_data.get("Package_pop_expected");
	//locators


	Extent_Start(testcase_Name, test, test1);

	navigateUrl(driver, url);

	LRP_Login(driver, Username, Password);
	



	
	Extent_call(test, test1,"**Switch the Profile Start**");

	Step_Start(1, "Switch to agency. ", test, test1);
	
	SwitchProfile(driver, agencyUser);

	
	Step_End(1, "Switch to agency. ", test, test1);
//
//	Extent_cal(test, test1,"** Enter Booking Module **");
	Step_Start(2, "Open the Booking module.", test, test1);

	moduleNavigate(driver, search_module);

	Step_End(2, "Open the Booking module.", test, test1);
	Step_Start(3, "Enter the Agreement Party in master tab..", test, test1);
	waitForElement(driver, AgrPartyInput);
	sendKeys(driver, AgrPartyInput, arg_party);
	tab(driver);

	Step_End(3, "Enter the Agreement Party in master tab..", test, test1);
	Step_Start(4, "Enter the POL and POD and select the Rates using Rates window.", test, test1);
	waitForElement(driver, OrginInput);
	sendKeys(driver, OrginInput, origin);
	tab(driver);

	waitForElement(driver, DeliveryInput);
	sendKeys(driver, DeliveryInput, delivery);
	tab(driver);
	Step_End(4, "Enter the POL and POD and select the Rates using Rates window.", test, test1);
	Step_Start(5, "Select the Routing. ", test, test1);

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


	waitForElement(driver, master_tab);
	click(driver, master_tab);

	String booknum = getAttribute(driver, booking_no,"value");
	System.out.println(booknum);

	waitForElement(driver, Edit_Button_toolBar);
	click(driver, Edit_Button_toolBar);
	Step_Start(11, "Select the confirm button in master tab & save the booking. ", test, test1);
	waitForElement(driver, Confirmed_Button);
	safeclick(driver, Confirmed_Button);
	
	waitForElement(driver, Charges_tab);
	click(driver, Charges_tab);
	Step_Start(10, "Click autorate button in charges tab. ", test, test1);
	waitForElement(driver, AutoRated);
	click(driver, AutoRated);
	Step_End(10, "Click autorate button in charges tab. ", test, test1);
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

	waitForElement(driver, master_tab);
	click(driver, master_tab);

	Step_Start(12, "Click CRO navigation button.", test, test1);
	waitForElement(driver, CRO_btn);
	click(driver, CRO_btn);
	Step_End(12, "Click CRO navigation button.", test, test1);
	Step_Start(13, "In toolbar click edit and save. .", test, test1);
	waitForElement(driver, Edit_Button_toolBar);
	click(driver, Edit_Button_toolBar);

	waitForElement(driver, acc_terminal);
	String acc_term_value=getAttribute(driver, acc_terminal, "value");
	System.out.println(acc_term_value);

	waitForElement(driver, rel_terminal_searchicon);
	click(driver, rel_terminal_searchicon);
	twoColumnSearchWindow(driver, CRO_search, CRO_search_condition, acc_term_value);


	waitForElement(driver, SaveButton_ToolBar);
	jsClick(driver, SaveButton_ToolBar);
	Step_End(13, "In toolbar click edit and save. .", test, test1);
	waitForElement(driver, Close_Current_tab);
	click(driver, Close_Current_tab);


	waitForElement(driver, SearchButton_Toolbar);
	click(driver, SearchButton_Toolbar);
	globalValueSearchWindow(driver, dropdownCondition1, Global_Book_num_search, booknum, "", "", "", "");
	


	waitForElement(driver, ready_BL);
	waitForElement(driver, ready_BL);
	String readyBL_status=getAttribute(driver, ready_BL, "class");
	System.out.println(readyBL_status);
	if(readyBL_status.contains(status)) {
		Extent_pass_New(driver,"Matched ||Excepted  Ready For Bl Check Box is should be Selected and the status is:"+ readyBL_status +" Actual Ready For Bl Check Box is  be Selected and the status is:"+ status, test, test1);
		System.out.println("Matched ||Excepted Ready For Bl Check Box is should be Selected and the status is:"+ readyBL_status +" Actual Ready For Bl Check Box is  be Selected and the status is:"+ status);
	}
	else {
		System.out.println("Not matched ||Excepted Ready For Bl Check Box is should be Selected and the status is:"+ readyBL_status +" Actual Ready For Bl Check Box is not  be Selected and the status is:"+ status);
		Extent_fail(driver,"Not matched ||Excepted Ready For Bl Check Box is should be Selected and the status is:"+ readyBL_status +" Actual Ready For Bl Check Box is  not be Selected and the status is:"+ status, test, test1);
	}
		
	waitForElement(driver, ready_OP);
	String readyOP_status=getAttribute(driver, ready_OP, "class");
	if(readyOP_status.contains(status)) {
		Extent_pass_New(driver,"Matched ||Excepted Ready For Operation Check Box is Selected and the status is:"+ readyOP_status +" Actual Ready For Operation Check Box is Selected and the status is:"+ status, test, test1);
		System.out.println("Matched ||Excepted Ready For Operation Check Box is Selected and the status is:"+ readyOP_status +" Actual Ready For Bl Check Box is  be Selected and the status is:"+ status);
	}
	else {
		System.out.println("Not matched ||Excepted Ready For Operation Check Box is Selected and the status is:"+ readyOP_status +" Actual Ready For Operation Check Box is not Selected and the status is:"+ status);
		Extent_fail(driver,"Not matched ||Excepted Ready For Operation Check Box is Selected and the status is:"+ readyOP_status +" Actual Ready For Operation Check Box isnot  Selected and the status is:"+ status, test, test1);
	}
		

	waitForElement(driver, Close_Current_tab);
	safeclick(driver, Close_Current_tab);
	
	Step_Start(14, ".Open the Bill of Lading module.", test, test1);
	
	moduleNavigate(driver, Module_Search_BL);

	Step_End(14, ".Open the Bill of Lading module.", test, test1);
	Step_Start(15, ".By using book no local search retrieve the data.", test, test1);
	waitForElement(driver, bl_search_btn);
	safeclick(driver, bl_search_btn);
	

	globalValueSearchWindow(driver, dropdownCondition1, Select_search_value_bill, booknum, "", "", "", "");
	
	
	
		Step_End(15, ".By using book no local search retrieve the data.", test, test1);
		Step_Start(16, "Edit the BL using tool bar & save the BL in draft status.", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		
		waitForPopup(driver, popup_Message,Saved_pop_draft);
		String saved_pop_act= getText(driver, popup_Message);
		System.out.println(saved_pop_act);

		if(saved_pop_act.trim().contains(Saved_pop_draft.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_draft + " || Actual Report Activity  POPUP is : " + saved_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_draft + " || Actual Report Activity  POPUP is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_draft + " || Actual Report Activity  POPUP is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_draft + " || Actual Report Activity  POPUP is : " + saved_pop_act, test,test1); 
			
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(16, "Edit the BL using tool bar & save the BL in draft status.", test, test1);
		Step_Start(17, "Click the edit button in container tab grid. ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, Container_Tab);
		click(driver, Container_Tab);
		Step_End(17, "Click the edit button in container tab grid. ", test, test1);
	
		waitForElement(driver, gird_editt1);
		click(driver, gird_editt1);
		Step_Start(18, "Click the rateref button to Reset the rate reference. ", test, test1);
		waitForElement(driver, rate_ref_number_field);
		waitForElement(driver, rate_ref_number_field);
		String rate_numberbeforeedit = getAttribute(driver, rate_ref_number_field,"value");
		System.out.println(rate_numberbeforeedit);
		
		Step_End(18, "Click the rateref button to Reset the rate reference. ", test, test1);
	
		waitForElement(driver, reset_reference);
		click(driver, reset_reference);
		Step_Start(19, "System will poup with \" Do you want to reset the Rate Ref No\".", test, test1);
		waitForPopup(driver, popup_Message,Reset_pop_exp);
		String Reset_pop_act = getText(driver, popup_Message);
		System.out.println(Reset_pop_act);
	
		if(Reset_pop_exp.trim().contains(Reset_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + Reset_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + Reset_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + Reset_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + Reset_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1); 
			
		} 
		Step_End(19, "System will poup with \" Do you want to reset the Rate Ref No\".", test, test1);
		Step_Start(20, "Click yes to proceed.", test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		Step_End(20, "Click yes to proceed.", test, test1);
		Step_Start(21, "System will clear the rate reference.", test, test1);
		Step_Start(22, "Click the Rate RefNo.{Orange color} button to set the rate reference.", test, test1);
		
		waitForElement(driver, rate_ref_searchh);
		click(driver, rate_ref_searchh);
		
		
		
		waitForElement(driver, rateref_toolbtn1);
		click(driver, rateref_toolbtn1);

		waitForElement(driver, rateref_cond_filter1);
		click(driver, rateref_cond_filter1);
		Step_End(21, "System will clear the rate reference.", test, test1);
		Step_End(22, "Click the Rate RefNo.{Orange color} button to set the rate reference.", test, test1);
		Step_Start(23, "System will popup the rate reference search window..", test, test1);
		Step_Start(24, "Select the rate reference & click the ok button/ Double click the rate reference. ", test, test1);
		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_ref_number);
		Step_End(23, "System will popup the rate reference search window..", test, test1);
		waitForElement(driver, select_rate_BL);
		click(driver, select_rate_BL);
		waitForElement(driver, ok_btn_BL);
		click(driver, ok_btn_BL);
		Step_End(24, "Select the rate reference & click the ok button/ Double click the rate reference. ", test, test1);
		waitForElement(driver, BL_equip_field);
		clearAndType(driver, BL_equip_field, BL_equip_field_input);
		Step_Start(25, "Click the edit button  in container tab. ", test, test1);
		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);
		Step_End(25, "Click the edit button  in container tab. ", test, test1);
		Step_Start(26, "System will validate for Carrier seal.  ", test, test1);
		waitForPopup(driver, popup_Message,carrier_pop_exp);
		String Reset_pop_act1 = getText(driver, popup_Message);
		System.out.println(Reset_pop_act1);
	
		if(carrier_pop_exp.trim().contains(Reset_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act1, test,test1); 
			
		} 
		Step_End(26, "System will validate for Carrier seal.  ", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_Start(27, "Enter the Carrier seal,actual container & click the edit button  in container tab.", test, test1);
		waitForElement(driver, carr_seal_input);
		clearAndType(driver, carr_seal_input, carrier_seal_input);
		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);
		Step_End(27, "Enter the Carrier seal,actual container & click the edit button  in container tab.", test, test1);
		waitForElement(driver, gird_editt11);
		click(driver, gird_editt11);
		Step_Start(28, "System will set the new rate reference no. & Carrier seal in container tab. ", test, test1);
		waitForElement(driver, rate_ref_number_field);
		waitForPopup(driver, rate_ref_number_field,rate_numberbeforeedit);
		String rate_numberafteredit = getAttribute(driver, rate_ref_number_field,"value");
		System.out.println(rate_numberafteredit);
		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);

		if(rate_numberbeforeedit.trim().contains(rate_numberafteredit.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity before reset the rate reference** : " + rate_numberbeforeedit + " || Actual Report Activity After reset the rate reference** : " + rate_numberafteredit);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity before reset the rate reference** : " + rate_numberbeforeedit + " || Actual Report Activity After reset the rate reference** : " + rate_numberafteredit, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity before reset the rate reference** : " + rate_numberbeforeedit + " || Actual Report Activity After reset the rate reference** : " + rate_numberafteredit);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity before reset the rate reference** : " + rate_numberbeforeedit + " || Actual Report Activity After reset the rate reference** : " + rate_numberafteredit, test,test1); 
			
		} 
		Step_End(28, "System will set the new rate reference no. & Carrier seal in container tab. ", test, test1);
		waitForElement(driver, BL_Master);
		click(driver, BL_Master);
		Step_Start(29, "In master tab select the confirm button then save,system validate to enter Shipper.", test, test1);
		waitForElement(driver, bl_confirm_btn);
		click(driver, bl_confirm_btn);
	
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(29, "In master tab select the confirm button then save,system validate to enter Shipper.", test, test1);
		
		
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

		waitForDisplay(driver, valid_commodity_pop);
		if(isdisplayed(driver, valid_commodity_pop)) {
			waitForPopup(driver, popup_Message,valid_comm_pop_exp);
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
			waitForDisplay(driver, commodity_discription_pop);
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
		

			Step_Start(24, "Enter the Quantity.", test, test1);
			waitForElement(driver, quantity_input);
			clearAndType(driver, quantity_input, Quantity_value_input);
			Step_End(24, "Enter the Quantity.", test, test1);
			Step_Start(25, "Enter the package using easy search. ", test, test1);

			Step_End(25, "Enter the package using easy search. ", test, test1);
			waitForElement(driver, commodity_grp);
			clearAndType(driver, commodity_grp, commodity_grp_input);
			enter(driver);
			Step_Start(26, ".Choose hs code by entering % in local search,mark no and commodity desc the click edit button.23.Enter Quantity,package,commodity group,choose hs code,mark no and commodity desc the click edit button. ", test, test1);
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
			

			waitForElement(driver, unit_dd);
			click(driver, unit_dd);
			
			String unit_select_option = String.format(unit_dd_select, Unit);
			waitForElement(driver, unit_select_option);
			click(driver, unit_select_option);

			waitForElement(driver, commodity_Add);
			click(driver, commodity_Add);
			Step_End(26, ".Choose hs code by entering % in local search,mark no and commodity desc the click edit button.23.Enter Quantity,package,commodity group,choose hs code,mark no and commodity desc the click edit button. ", test, test1);
			

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
		Step_Start(30, "In customer tab, Select the customer type as \"Shipper\".", test, test1);
		waitForElement(driver, customer_type_dp);
		click(driver, customer_type_dp);
		String customer_type_selectt=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input);
		waitForElement(driver, customer_type_selectt);
		click(driver, customer_type_selectt);
		Step_End(30, "In customer tab, Select the customer type as \"Shipper\".", test, test1);
		Step_Start(31, "In customer tab, Select the customer type as \"Shipper\".By entering  % symbol in JDLC customer search system will list all the customers.", test, test1);
		waitForElement(driver, customer_easy_search);
		sendKeys(driver, customer_easy_search, customer_easy_search_input);
		Step_End(31, "In customer tab, Select the customer type as \"Shipper\".By entering  % symbol in JDLC customer search system will list all the customers.", test, test1);
		waitForElement(driver, customer_easy_search_select);
		click(driver, customer_easy_search_select);
		Step_Start(32, "Select the shipper customer details and click add button.", test, test1);
		waitForElement(driver, customer_Add_btn);
		click(driver, customer_Add_btn);
		Step_End(32, "Select the shipper customer details and click add button.", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
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
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);
		Step_Start(33, "Now Select the customer type as \"Consignee\"", test, test1);
		waitForElement(driver, customer_type_dp);
		click(driver, customer_type_dp);
		String customer_type_selectt_con=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input_CONSIGNEE);
		waitForElement(driver, customer_type_selectt_con);
		click(driver, customer_type_selectt_con);
		Step_End(33, "Now Select the customer type as \"Consignee\"", test, test1);
		Step_Start(34, "By using Easy search system will list all the customers. ", test, test1);
		waitForElement(driver, customer_easy_search);
		sendKeys(driver, customer_easy_search, customer_easy_search_input_consignee);
		waitForElement(driver, customer_easy_search_select);
		click(driver, customer_easy_search_select);
		Step_End(34, "By using Easy search system will list all the customers. ", test, test1);
		Step_Start(35, "Select the consignee customer details and click add button. ", test, test1);
			waitForElement(driver, customer_Add_btn);
			click(driver, customer_Add_btn);
			Step_End(35, "Select the consignee customer details and click add button. ", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
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
			waitForElement(driver, shipper_close);
			click(driver, shipper_close);
			Step_Start(37, "Select the Customer type as \"Notify\" & click paste. ", test, test1);
			
			waitForElement(driver, customer_type_dp);
			click(driver, customer_type_dp);
			String customer_type_selectt_not=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input_Notify);
			waitForElement(driver, customer_type_selectt_not);
			click(driver, customer_type_selectt_not);
			Step_End(37, "Select the Customer type as \"Notify\" & click paste. ", test, test1);
			waitForElement(driver, customer_easy_search);
			sendKeys(driver, customer_easy_search, customer_easy_search_input_notify);
			waitForElement(driver, customer_easy_search_select);
			click(driver, customer_easy_search_select);
				waitForElement(driver, customer_Add_btn);
				click(driver, customer_Add_btn);
				Step_Start(38, "Now click save button system validate to enter the Following mandatory charges.", test, test1);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				if(isdisplayed(driver, cargo_pop)) {
					waitForPopup(driver, cargo_pop,cargo_pop_exp);
				String cargo_pop_act = getText(driver, cargo_pop);
				System.out.println(cargo_pop_act);

				if(cargo_pop_act.trim().contains(cargo_pop_exp.trim())) {                                                                                                                  
					System.out.println("Matched || " + " Expected Report Activity POPUP is : " + cargo_pop_exp + " || Actual Report Activity  POPUP is : " + cargo_pop_act);            
					Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + cargo_pop_exp + " || Actual Report Activity  POPUP is : " + cargo_pop_act, test,test1);     
				}                                                                                                                                                                        
				else {                                                                                                                                                                   
					System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + cargo_pop_exp + " || Actual Report Activity  POPUP is : " + cargo_pop_act);        
					Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + cargo_pop_exp + " || Actual Report Activity  POPUP is : " + cargo_pop_act, test,test1); 
					
				} }
				Step_End(16, "Now system validate to enter cargo weight.", test, test1);
				waitForElement(driver, shipper_close);
				click(driver, shipper_close);
				Step_Start(17, "Edit commodity and enter cargo weight then click on edit button.", test, test1);
			
				waitForElement(driver, commoditytab);
				click(driver, commoditytab);
	
			waitForElement(driver, commodity_gird_edit);
			click(driver, commodity_gird_edit);
			
			waitForElement(driver, quantity_input);
			clearAndType(driver, quantity_input, Quantity_value_input);
			
			
			waitForElement(driver, bl_package_txtfld);
			click(driver, bl_package_txtfld);
			sendKeys(driver, bl_package_txtfld, Package_value_input);
			waitForElement(driver, bl_package_txtfld);
			enter(driver);
			
			waitForElement(driver, commodity_grp);
			clearAndType(driver, commodity_grp, commodity_grp_input);
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
			waitForElement(driver, bl_commodity_add_button);
			click(driver, bl_commodity_add_button);
			
			if(isdisplayed(driver, popup_Message)) {
				waitForPopup(driver, popup_Message,Last_pop);
			String last1 = getText(driver, popup_Message);
			System.out.println(last1);

			if(Last_pop.trim().contains(last1.trim())) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity POPUP is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last1);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last1, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last1);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last1, test,test1); 
				
			} 
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			}
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForElement(driver, shipper_close);
			click(driver, shipper_close);
			Step_End(38, "Now click save button system validate to enter the Following mandatory charges.", test, test1);
			Step_Start(39, "click on auto rate button, once charges pop up now click save button..", test, test1);
			click(driver, Auto_rate_button);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(39, "click on auto rate button, once charges pop up now click save button..", test, test1);
			waitForElement(driver, shipper_close);
			click(driver, shipper_close);	
			
			Step_Start(52, "click on cargo summary button and click save..", test, test1);
			
			
		
			waitForElement(driver, cargo_summary);
			click(driver, cargo_summary);	
			
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(52, "click on cargo summary button and click save..", test, test1);
			Step_Start(53, "Now BL should be confirmed and bl number indication should be in green color. .", test, test1);
			waitForPopup(driver, popup_Message,updated_pop_exp);
			String saved_pop_act1= getText(driver, popup_Message);
			System.out.println(saved_pop_act1);

			if(saved_pop_act1.contains(updated_pop_exp)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act1);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act1, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act1);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + updated_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act1, test,test1); 
				
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
			
			
			
			
			
			if(booking_confirmed_Color.contains(bill_number_colour)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour, test,test1); 
				
			} 
			Step_End(53, "Now BL should be confirmed and bl number indication should be in green color. .", test, test1);
			Extent_completed(testcase_Name, test, test1);
			
			
			
			
			
}}
