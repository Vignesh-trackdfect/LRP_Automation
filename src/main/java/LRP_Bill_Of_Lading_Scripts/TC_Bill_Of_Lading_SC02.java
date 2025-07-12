package LRP_Bill_Of_Lading_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Bill_Of_Lading_Locators;

public class TC_Bill_Of_Lading_SC02 extends Keywords{
	public void Bill_Of_Lading_SC02(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
	
		String testcase_Name="TC_Bill_Of_Lading_SC02";
		
		



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
	String bl_mismatch_pop_exp = Excel_data.get("bl_mismatch_pop_exp");
	String Equipment_id_input = Excel_data.get("Equipment_id_input");
	String carrier_pop_exp = Excel_data.get("carrier_pop_exp");
	String carr_seal_input_value = Excel_data.get("carr_seal_input_value");
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
	String valid_comm_pop_exp = Excel_data.get("valid_comm_pop_exp");
	String comm_dis_pop_exp = Excel_data.get("comm_dis_pop_exp");
	String marks_number_pop_exp = Excel_data.get("marks_number_pop_exp");
	String enter_commodity_pop_exp = Excel_data.get("enter_commodity_pop_exp");
	String enter_package_pop_exp = Excel_data.get("enter_package_pop_exp");
	String Quantity_value_input = Excel_data.get("Quantity_value_input");
	String Package_value_input = Excel_data.get("Package_value_input");
	String commodity_grp_input = Excel_data.get("commodity_grp_input_value");
	String HS_code_input_value = Excel_data.get("HS_code_input_value");
	String commodity_desc_input = Excel_data.get("commodity_desc_input");
	String mark_number_input = Excel_data.get("mark_number_input");
	String Last_pop = Excel_data.get("Last_pop");
	String Select_search_value_hs = Excel_data.get("Select_search_value_hs");
	String Roe_pop_Exp = Excel_data.get("Roe_pop_Exp");
	String Treasury_ROE = Excel_data.get("Treasury_ROE");
	String Roe_Date_input = Excel_data.get("Roe_Date_input");
	String Roe_updated_pop_ext = Excel_data.get("Roe_updated_pop_ext");
	String Roe_exchange_input = Excel_data.get("Roe_exchange_input");
	String currency_code_input = Excel_data.get("currency_code_input");
	String Terminal_Code = Excel_data.get("Terminal_Code");
	String first_service_data_edit = Excel_data.get("first_service_data_edit");
	String Saved_pop_draft = Excel_data.get("Saved_pop_draft");
	String Saved_pop_updated = Excel_data.get("Saved_pop_updated");
	String Roe_perform = Excel_data.get("Roe_perform");
	String Roe_Search = Excel_data.get("Roe_Search");
	String CRO_search_condition = Excel_data.get("CRO_search_condition");
	String CRO_search = Excel_data.get("CRO_search");
	String Global_Book_num_search = Excel_data.get("Global_Book_num_search");
	String Commodity_group = Excel_data.get("Commodity_group");
	String Package_Quantity = Excel_data.get("Package_Quantity");
	String Unit = Excel_data.get("Unit");
	String package_exp = Excel_data.get("Package_pop_expected");
	String Volume_Input = Excel_data.get("Volume_Input");
	String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

	//locators


	Extent_Start(testcase_Name, test, test1);

	navigateUrl(driver, url);

	
	LRP_Login(driver, Username, Password);

	Extent_call(test, test1,"**Switch the Profile Start**");

	SwitchProfile(driver, agencyUser);

	
//
////	Extent_cal(test, test1,"** Enter Booking Module **");
Step_Start(1, "To create Booking  and CRO, kindly use scenario 46 .", test, test1);
	
	moduleNavigate(driver, search_module);

	waitForElement(driver, AgrPartyInput);
	sendKeys(driver, AgrPartyInput, arg_party);
	tab(driver);


	waitForElement(driver, OrginInput);
	sendKeys(driver, OrginInput, origin);
	tab(driver);

	waitForElement(driver, DeliveryInput);
	sendKeys(driver, DeliveryInput, delivery);
	tab(driver);


	waitForDisplay(driver, Rate_Grid);
	if(isdisplayed(driver, Rate_Grid)) {
		System.out.println("*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed");            
		Extent_pass_New(driver,"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed", test,test1);     
	}                                                                                                                                                                        
	else {  
	waitForElement(driver, RatedBtn);
	click(driver, RatedBtn);
	waitForElement(driver, $Rates);
	click(driver, $Rates);

	waitForElement(driver, rate_reference_tab);
	if(isDisplayed(driver,rate_reference_tab)) {
		System.out.println("*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Showed");            
		Extent_pass_New(driver,"*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Showed", test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Not Showed");        
		Extent_fail(driver, "*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Not Showed", test,test1); 
	
	}
	}

	waitForElement(driver, rateref_toolbtn);
	click(driver, rateref_toolbtn);

	waitForElement(driver, rateref_cond_filter);
	click(driver, rateref_cond_filter);

	waitForElement(driver, rate_filter_inp);
	sendKeys(driver, rate_filter_inp, rate_no);
	waitForElement(driver, Rate_No_Select);
	safeclick(driver, Rate_No_Select);
	waitForElement(driver, ok_btn);
	safeclick(driver, ok_btn);
	
	if(Roe_perform.equalsIgnoreCase("YES")) {
	waitForDisplay(driver, popup_Message);		
	if (isdisplayed(driver, popup_Message)) {
		click(driver, popup_Message_Ok_Button);
	}
	waitForElement(driver, Routingedit);
	safeclick(driver, Routingedit);
	if(isdisplayed(driver, No_Button)) {
	waitForElement(driver, No_Button);
	safeclick(driver, No_Button);
	}
	waitForElement(driver, Grid);
	safeclick(driver, Grid);
	waitForElement(driver, ConditionFilter);
	safeclick(driver, ConditionFilter);
	waitForElement(driver, ServiceInnput);
	sendKeys(driver, ServiceInnput, first_service_data_edit);

	waitForElement(driver, Terminal_input);
	sendKeys(driver, Terminal_input, Terminal_Code);


	waitForElement(driver, Routing_Search_valueSelect);
	safeclick(driver, Routing_Search_valueSelect);
	waitForElement(driver, RouteOK);
	safeclick(driver, RouteOK);
	if(isdisplayed(driver, validation_close)) {
	waitForElement(driver, validation_close);
	safeclick(driver, validation_close);
	}
	waitForElement(driver, FirstserviceInput);
	clearAndType(driver, FirstserviceInput, first_service_data);
	click(driver, FirstserviceInput);
	keyDown(driver);
	
	selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
	
	
	}
	
	
	
	if(Roe_perform.equalsIgnoreCase("NO")) {
		waitForElement(driver, FirstserviceInput);
		String service_Value = getAttribute(driver, FirstserviceInput, "value");
		if(service_Value.equals("")) {
			Step_Start(4, "Select the Schedule", test, test1);
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)){
				String Popup_Text = getText(driver,popup_Message);
				if (Popup_Text.equals(No_Schedule_Popup)) {
					click(driver, popup_Message_Ok_Button);
					System.out.println("NoSchedule available, Entering data in first service input");
					selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
				}
			}else if(isdisplayed(driver,Invalid_date_popup)) {
				waitForDisplay(driver, Invalid_date_popup);	
				Extent_call(test, test1,"******** If There is Invalid ETA date popup showed Select the Rout Manually - Start ********");
				safeclick(driver, Invalid_date_popup_Close);
				selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
				Extent_call(test, test1,"******** If There is Invalid ETA date popup showed Select the Rout Manually - End ********");
				Step_End(4, "Select the Schedule", test, test1);
			}
		}
	}


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

	waitForElement(driver, global_Editbtn);
	click(driver, global_Editbtn);

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


	waitForElement(driver, master_tab);
	click(driver, master_tab);


	waitForElement(driver, CRO_btn);
	click(driver, CRO_btn);

	waitForElement(driver, CRO_editbtn);
	click(driver, CRO_editbtn);

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


	waitForElement(driver, SearchButton_Toolbar);
	click(driver, SearchButton_Toolbar);
	globalValueSearchWindow(driver, dropdownCondition1, Global_Book_num_search, booknum, "", "", "", "");


	


	waitForElement(driver, ready_BL);
	waitForElement(driver, ready_BL);
	String readyBL_status=getAttribute(driver, ready_BL, "class");
	System.out.println(readyBL_status);
	if(readyBL_status.contains(status)) {
		Extent_pass_New(driver,"Matched || Ready For Bl Check Box is Selected and the status is : "+status, test, test1);
		System.out.println("Matched || Ready For Bl Check Box is Selected and the status is : "+status); 
	}
	else {
		Extent_fail(driver,"Not Matched || Ready For Bl Check Box is Not Selected", test, test1);
		System.out.println("Not Matched || Ready For Bl Check Box is Not Selected");
	}

	waitForElement(driver, ready_OP);
	String readyOP_status=getAttribute(driver, ready_OP, "class");
	if(readyOP_status.contains(status)) {
		Extent_pass_New(driver,"Matched || Ready For Operation Check Box is Selected and the status is : "+readyOP_status, test, test1);
		System.out.println("Matched || Ready For Operation Check Box is Selected and the status is : "+readyOP_status); 
	}
	else {
		Extent_fail(driver,"Not Matched || Ready For Operation Check Box is Not Selected", test, test1);
		System.out.println("Not Matched || Ready For Operation Check Box is Not Selected");
	}
	Step_End(1, "To create Booking  and CRO, kindly use scenario 46 .", test, test1);
	waitForElement(driver,Close_Current_tab);
	safeclick(driver, Close_Current_tab);
	
	Step_Start(2, ".Open the Bill of Lading module.", test, test1);
	moduleNavigate(driver, Module_Search_BL);


	Step_End(2, ".Open the Bill of Lading module.", test, test1);
	Step_Start(3, "By using book no local search retrieve the data.", test, test1);
	waitForElement(driver, bl_search_btn);
	safeclick(driver, bl_search_btn);
	
	
	
	waitForElement(driver, select_first);
	click(driver,select_first);
	globalValueSearchWindow(driver, dropdownCondition1, Select_search_value_bill, booknum, "", "", "", "");
	
	
		Step_End(3, "By using book no local search retrieve the data.", test, test1);
		Step_Start(4, " Edit the BL using tool bar.", test, test1);
		waitForElement(driver, bl_edit_btn);
		click(driver, bl_edit_btn);
		Step_End(4, " Edit the BL using tool bar.", test, test1);
		Step_Start(5, " Click the confirm button in master tab & then save.", test, test1);
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		
		waitForPopup(driver, popup_Message,Saved_pop_draft);

		String saved_pop_act= getText(driver, popup_Message);
		System.out.println(saved_pop_act);

		if(saved_pop_act.trim().contains(Saved_pop_draft.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  Popup is : " + Saved_pop_draft + " || Actual Report Activity Popup is : " + saved_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity Popup is : " + Saved_pop_draft + " || Actual Report Activity Popup is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity Popup is : " + Saved_pop_draft + " || Actual Report Activity Popup is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity Popup is : " + Saved_pop_draft + " || Actual Report Activity Popup is : " + saved_pop_act, test,test1); 
			
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, bl_confirm_btn);
		click(driver, bl_confirm_btn);
	
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(5, " Click the confirm button in master tab & then save.", test, test1);
	
		Step_Start(6, "System will validate for Equipment type mismatch.", test, test1);
		waitForPopup(driver, bl_mismatch_pop,bl_mismatch_pop_exp);
		String bl_mismatch_pop_act = getText(driver, bl_mismatch_pop);
		System.out.println(bl_mismatch_pop_act);
	
		if(bl_mismatch_pop_act.trim().contains(bl_mismatch_pop_exp.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  popup is : " + bl_mismatch_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  popup is : " + bl_mismatch_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  popup is : " + bl_mismatch_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  popup is : " + bl_mismatch_pop_act, test,test1); 
			
		} 
		Step_End(6, "System will validate for Equipment type mismatch.", test, test1);
		waitForElement(driver, bl_mismatch_pop_close);
		click(driver, bl_mismatch_pop_close);
		Step_Start(7, "Entered the actual container in equipment id field and click edit button.", test, test1);
		waitForElement(driver, gird_edit);
		click(driver, gird_edit);
		waitForElement(driver, BL_equip_field);
	clearAndType(driver, BL_equip_field, Equipment_id_input);
	waitForElement(driver, BL_editbtn);
	click(driver, BL_editbtn);
	Step_End(7, "Entered the actual container in equipment id field and click edit button.", test, test1);
	Step_Start(8, "Now system should validate for carrier Seal.", test, test1);
	
	if(isdisplayed(driver, popup_Message)) {
	waitForPopup(driver, popup_Message,carrier_pop_exp);
	String Reset_pop_act = getText(driver, popup_Message);
	System.out.println(Reset_pop_act);

	if(carrier_pop_exp.trim().contains(Reset_pop_act.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + carrier_pop_exp + " || Actual Report Activity  popup is : " + Reset_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + carrier_pop_exp + " || Actual Report Activity  popup is : " + Reset_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + carrier_pop_exp + " || Actual Report Activity  popup is : " + Reset_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + carrier_pop_exp + " || Actual Report Activity  popup is : " + Reset_pop_act, test,test1); 
		
	} 
	Step_End(8, "Now system should validate for carrier Seal.", test, test1);
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver, popup_Message_Ok_Button);
	
	Step_Start(9, "Entered the carrier Seal and click edit.", test, test1);
	waitForElement(driver, carr_seal_input);
	clearAndType(driver, carr_seal_input, carr_seal_input_value);
	waitForElement(driver, BL_editbtn);
	click(driver, BL_editbtn);
	}
	Step_End(9, "Entered the carrier Seal and click edit.", test, test1);
	Step_Start(10, "Now again click save button then system validate to enter the shipper.", test, test1);
	waitForElement(driver, SaveButton_ToolBar);
	click(driver, SaveButton_ToolBar);
	
	
	waitForPopup(driver, popup_Message,package_exp);
	String package_act = getText(driver, popup_Message);
	
	
	if(package_act.equals(package_exp)) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + package_act + " || Actual Report Activity  popup is : " + package_exp);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + package_act + " || Actual Report Activity  popup is : " + package_exp, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + package_act + " || Actual Report Activity  popup is : " + package_exp);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + package_act + " || Actual Report Activity  popup is : " + package_exp, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + valid_comm_pop_exp + " || Actual Report Activity  popup is : " + valid_comm_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + valid_comm_pop_exp + " || Actual Report Activity  popup is : " + valid_comm_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + valid_comm_pop_exp + " || Actual Report Activity  popup is : " + valid_comm_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + valid_comm_pop_exp + " || Actual Report Activity  popup is : " + valid_comm_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + comm_dis_pop_exp + " || Actual Report Activity  popup is : " + comm_dis_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + comm_dis_pop_exp + " || Actual Report Activity  popup is : " + comm_dis_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + comm_dis_pop_exp + " || Actual Report Activity  popup is : " + comm_dis_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + comm_dis_pop_exp + " || Actual Report Activity  popup is : " + comm_dis_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + marks_number_pop_exp + " || Actual Report Activity  popup is : " + marks_number_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + marks_number_pop_exp + " || Actual Report Activity  popup is : " + marks_number_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + marks_number_pop_exp + " || Actual Report Activity  popup is : " + marks_number_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + marks_number_pop_exp + " || Actual Report Activity  popup is : " + marks_number_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  popup is : " + enter_commodity_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  popup is : " + enter_commodity_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  popup is : " + enter_commodity_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  popup is : " + enter_commodity_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + enter_package_pop_exp + " || Actual Report Activity  popup is : " + enter_package_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + enter_package_pop_exp + " || Actual Report Activity  popup is : " + enter_package_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + enter_package_pop_exp + " || Actual Report Activity  popup is : " + enter_package_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + enter_package_pop_exp + " || Actual Report Activity  popup is : " + enter_package_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + Commodity_group + " || Actual Report Activity  popup is : " + enter_package_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + Commodity_group + " || Actual Report Activity  popup is : " + enter_package_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + Commodity_group + " || Actual Report Activity  popup is : " + enter_package_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + Commodity_group + " || Actual Report Activity  popup is : " + enter_package_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + Package_Quantity + " || Actual Report Activity  popup is : " + enter_package_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + Package_Quantity + " || Actual Report Activity  popup is : " + enter_package_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + Package_Quantity + " || Actual Report Activity  popup is : " + enter_package_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + Package_Quantity + " || Actual Report Activity  popup is : " + enter_package_pop_act, test,test1); 
		
	} 
	waitForElement(driver, Package_quantity_ok);
	click(driver, Package_quantity_ok);
	}
	
	
	
	waitForElement(driver, quantity_input);
	clearAndType(driver, quantity_input, Quantity_value_input);
	
	
	waitForElement(driver, billoflading_volume);
	click(driver, billoflading_volume);
	clearAndType(driver, billoflading_volume, Volume_Input);
//	waitForElement(driver, commodity_Package);
	enter(driver);
	
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
//	clear(driver, commodity_Cargo_Weight);
	click(driver, MCN_CargoWeight);
Actionsendkeys(driver, MCN_CargoWeight, commodity_Cargo_Weight_input);
	click(driver, commodity_grp);
	waitForElement(driver, unit_dd);
	click(driver, unit_dd);
	
	String unit_select_option = String.format(unit_dd_select, Unit);
	waitForElement(driver, unit_select_option);
	click(driver, unit_select_option);

	waitForElement(driver, bl_commodity_add_button);
	click(driver, bl_commodity_add_button);
	Step_End(19, ".Enter Quantity,package,commodity group,choose hs code,mark no and commodity desc the click edit button.", test, test1);
	
	Step_Start(20, ".Now click save button system validate to enter the Following mandatory charges.", test, test1);
	
	
	if(isdisplayed(driver, BL_Pop)) {
	waitForPopup(driver, BL_Pop,Last_pop);
	String last = getText(driver, BL_Pop);
	System.out.println(last);

	if(Last_pop.trim().contains(last.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + Last_pop + " || Actual Report Activity  popup is : " + last);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + Last_pop + " || Actual Report Activity  popup is : " + last, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + Last_pop + " || Actual Report Activity  popup is : " + last);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + Last_pop + " || Actual Report Activity  popup is : " + last, test,test1); 
		
	} 
	Step_End(20, ".Now click save button system validate to enter the Following mandatory charges.", test, test1);
	
	}
	
	if(isdisplayed(driver, popup_Message_Ok_Button)) {
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver, popup_Message_Ok_Button);
	}
	
	waitForElement(driver, SaveButton_ToolBar);
	click(driver, SaveButton_ToolBar);

	waitForPopup(driver, shipper_pop,shipper_pop_exp);
	String shipper_pop_act = getText(driver, shipper_pop);
	System.out.println(shipper_pop_act);

	if(shipper_pop_exp.trim().contains(shipper_pop_act.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + shipper_pop_exp + " || Actual Report Activity  popup is : " + shipper_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + shipper_pop_exp + " || Actual Report Activity  popup is : " + shipper_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + shipper_pop_exp + " || Actual Report Activity  popup is : " + shipper_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + shipper_pop_exp + " || Actual Report Activity  popup is : " + shipper_pop_act, test,test1); 
		
	} 
	Step_End(10, "Now again click save button then system validate to enter the shipper.", test, test1);
	waitForElement(driver, shipper_close);
	click(driver, shipper_close);
	Step_Start(11, "Enter shipper customer details and click save button.", test, test1);
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
	Step_End(11, "Enter shipper customer details and click save button.", test, test1);
	Step_Start(12, "now system validate to enter the consignee.", test, test1);
	waitForPopup(driver, consignee_pop,consignee_pop_exp);
	String consignee_pop_act = getText(driver, consignee_pop);
	System.out.println(consignee_pop_act);

	if(consignee_pop_exp.trim().contains(consignee_pop_act.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + consignee_pop_exp + " || Actual Report Activity  popup is : " + consignee_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + consignee_pop_exp + " || Actual Report Activity  popup is : " + consignee_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + consignee_pop_exp + " || Actual Report Activity  popup is : " + consignee_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + consignee_pop_exp + " || Actual Report Activity  popup is : " + consignee_pop_act, test,test1); 
		
	} 
	Step_End(12, "now system validate to enter the consignee.", test, test1);
	waitForElement(driver, shipper_close);
	click(driver, shipper_close);
	Step_Start(13, "Enter Consignee customer details and click save button.", test, test1);
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
		Step_End(13, "Enter Consignee customer details and click save button.", test, test1);
		Step_Start(14, "now system validate to enter the Notify party.", test, test1);
		waitForPopup(driver, notify_pop,notify_pop_exp);
		String notify_pop_act = getText(driver, notify_pop);
		System.out.println(notify_pop_act);

		if(notify_pop_exp.trim().contains(notify_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + notify_pop_exp + " || Actual Report Activity  popup is : " + notify_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + notify_pop_exp + " || Actual Report Activity  popup is : " + notify_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + notify_pop_exp + " || Actual Report Activity  popup is : " + notify_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + notify_pop_exp + " || Actual Report Activity  popup is : " + notify_pop_act, test,test1); 
			
		} 
		Step_End(14, "now system validate to enter the Notify party.", test, test1);
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);
		Step_Start(15, "Enter notify party and click save button.", test, test1);
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
			
	
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);	
		Step_Start(21, "click on auto rate button, once charges pop up now click save button.", test, test1);
		
		if(isdisplayed(driver, Auto_rate_button)) {
		waitForElement(driver, Auto_rate_button);
		click(driver, Auto_rate_button);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(21, "click on auto rate button, once charges pop up now click save button.", test, test1);
		}
		
		
		Step_Start(22, "Now system validate to enter ROE details.Note: If ROE details available then system will not validate) then it will move to 29th step.", test, test1);
		Step_Start(23, "Confirm the BL System will validate with \"Apply ROE\r\n"
				+ "\" message\" if any currency available without ROE.", test, test1);
		waitForDisplay(driver, Roe_pop);
		if(isdisplayed(driver, Roe_pop)) {
			String Roe_pop_act = getText(driver, Roe_pop);
			System.out.println(Roe_pop_act);

			if(Roe_pop_Exp.equals(Roe_pop_act)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity  popup is : " + Roe_pop_Exp + " || Actual Report Activity  popup is : " + Roe_pop_act);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + Roe_pop_Exp + " || Actual Report Activity  popup is : " + Roe_pop_act, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + Roe_pop_Exp + " || Actual Report Activity  popup is : " + Roe_pop_act);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + Roe_pop_Exp + " || Actual Report Activity  popup is : " + Roe_pop_act, test,test1); 
				
			} 
			Step_End(22, "Now system validate to enter ROE details.Note: If ROE details available then system will not validate) then it will move to 29th step.", test, test1);
			Step_End(23, "Confirm the BL System will validate with \"Apply ROE\r\n"
					+ "\" message\" if any currency available without ROE.", test, test1);
			waitForElement(driver, shipper_close);
			click(driver, shipper_close);	
			waitForElement(driver, bl_master_tab);
			click(driver, bl_master_tab);
			waitForElement(driver, bl_draft_btn);
			click(driver, bl_draft_btn);
		
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);	
			
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);	
			
//			waitForElement(driver, BL_right_refresh);
//		RightClick(driver, BL_right_refresh);
//			waitForElement(driver, refresh_all);
//			click(driver, refresh_all);	
			
			
//			waitForElement(driver, bl_master_tab);
//			click(driver, bl_master_tab);
//			waitForElement(driver, bl_draft_btn);
//			click(driver, bl_draft_btn);
//		
//			waitForElement(driver, SaveButton_ToolBar);
//			click(driver, SaveButton_ToolBar);	
//			waitForElement(driver, popup_Message_Ok_Button);
//			click(driver, popup_Message_Ok_Button);	
//			
//			
//			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			Step_Start(24, "Then switch to line & Open the treasury ROE module.", test, test1);
			waitForElement(driver, Switch_Profile);
			safeclick(driver, Switch_Profile);
			waitForElement(driver, Reset_agency);
			safeclick(driver, Reset_agency);
			moduleNavigate(driver, Treasury_ROE);
			Step_End(24, "Then switch to line & Open the treasury ROE module.", test, test1);
			Step_Start(25, "By using the global search enter the sail date.", test, test1);
			waitForElement(driver, Roe_search);
			safeclick(driver, Roe_search);
			
			twoColumnSearchWindow(driver, Roe_Search, CRO_search_condition, Roe_Date_input);
			
			Step_End(25, "By using the global search enter the sail date.", test, test1);
			
			Step_Start(26, "Click the edit button & enter the currency then save.  .", test, test1);
			waitForElement(driver, Roe_edit);
			safeclick(driver, Roe_edit);
			waitForElement(driver, currency_code_search);
			safeclick(driver, currency_code_search);
			waitForElement(driver, currency_code);
			sendKeys(driver, currency_code, currency_code_input);
			waitForElement(driver, B_selectrouting1);
			safeclick(driver, B_selectrouting1);
			waitForElement(driver, Select_Button);
			safeclick(driver, Select_Button);
			waitForElement(driver, Roe_exchange);
			clearAndType1(driver, Roe_exchange, Roe_exchange_input);
			waitForElement(driver, Roe_add);
			safeclick(driver, Roe_add);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			Step_End(26, "Click the edit button & enter the currency then save.  .", test, test1);
			waitForElement(driver, Roe_Yes);
			safeclick(driver, Roe_Yes);
			waitForPopup(driver, Roe_updated_pop,Roe_updated_pop_ext);
			String Roe_updated_pop_act = getText(driver, Roe_updated_pop);
			System.out.println(Roe_updated_pop_act);

			if(Roe_updated_pop_ext.equals(Roe_updated_pop_act)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity  popup is : " + Roe_updated_pop_ext + " || Actual Report Activity  popup is : " + Roe_updated_pop_act);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + Roe_updated_pop_ext + " || Actual Report Activity  popup is : " + Roe_updated_pop_act, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + Roe_updated_pop_ext + " || Actual Report Activity  popup is : " + Roe_updated_pop_act);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + Roe_updated_pop_ext + " || Actual Report Activity  popup is : " + Roe_updated_pop_act, test,test1); 
				
			} 
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_Start(27, "Now switch to agency again & open the BL module.   .", test, test1);
			SwitchProfile(driver, agencyUser);
			
			
			
			
			
		moduleNavigate(driver, Module_Search_BL);
			Step_End(27, "Now switch to agency again & open the BL module.   .", test, test1);
			waitForElement(driver, bl_search_btn);
			safeclick(driver, bl_search_btn);
			
			
			globalValueSearchWindow(driver, dropdownCondition1, Select_search_value_bill, booknum, "", "", "", "");
			
				Step_Start(28, "Edit the BL & click confirm button to save. .", test, test1);
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
				waitForElement(driver, bl_confirm_btn);
				click(driver, bl_confirm_btn);
			
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				Step_End(28, "Edit the BL & click confirm button to save. .", test, test1);
		
			
		}
//		Step_Start(29, "Now system validate to enter the description of goods..", test, test1);
//		if(isdisplayed(driver, shipper_close)) {
//		waitForElement(driver, shipper_close);
//		click(driver, shipper_close);	
//		Step_End(29, "Now system validate to enter the description of goods..", test, test1);
//		}
//		Step_Start(30, "click on cargo summary button and click save.", test, test1);
//		if(isdisplayed(driver, cargo_summary)) {
//		waitForElement(driver, cargo_summary);
//		click(driver, cargo_summary);	
//		
//		Step_End(30, "click on cargo summary button and click save.", test, test1);
//		Step_Start(31, "Now bl number should be generated and bl number indication should be in green color.  ", test, test1);
//		waitForElement(driver, SaveButton_ToolBar);
//		click(driver, SaveButton_ToolBar);
//		
//		
		
		
		
		
		
		
		
		
		if(isdisplayed(driver, shipper_close)) {
			waitForElement(driver, shipper_close);
			click(driver, shipper_close);	
			Step_End(29, "Now system validate to enter the description of goods..", test, test1);
			}
			Step_Start(30, "click on cargo summary button and click save.", test, test1);
			if(isClickable(driver, cargo_summary)) {
			waitForElement(driver, cargo_summary);
			click(driver, cargo_summary);	
			}
		
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
		waitForPopup(driver, BL_Pop,Saved_pop_updated);
		String saved_pop_act1= getText(driver, BL_Pop);
		System.out.println(saved_pop_act1);

		if(saved_pop_act1.contains(Saved_pop_updated)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + Saved_pop_updated + " || Actual Report Activity  popup is : " + saved_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + Saved_pop_updated + " || Actual Report Activity  popup is : " + saved_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + Saved_pop_updated + " || Actual Report Activity  popup is : " + saved_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + Saved_pop_updated + " || Actual Report Activity  popup is : " + saved_pop_act1, test,test1); 
			
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
			
			
			System.out.println("Matched || " + " Expected Report Activity  colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour, test,test1); 
			
		} 
//		Step_End(31, "Now bl number should be generated and bl number indication should be in green color.  ", test, test1);
//		
//		
		if(isdisplayed(driver, bl_mismatch_pop)) {
			waitForPopup(driver, bl_mismatch_pop,bl_mismatch_pop_exp);
		String bl_mismatch_pop_act1 = getText(driver, bl_mismatch_pop);
		System.out.println(bl_mismatch_pop_act1);
	
		if(bl_mismatch_pop_act1.trim().contains(bl_mismatch_pop_exp.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  popup is : " + bl_mismatch_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  popup is : " + bl_mismatch_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  popup is : " + bl_mismatch_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  popup is : " + bl_mismatch_pop_act1, test,test1); 
			
		} 
		Step_End(6, "System will validate for Equipment type mismatch.", test, test1);
		waitForElement(driver, bl_mismatch_pop_close);
		click(driver, bl_mismatch_pop_close);
		Step_Start(7, "Entered the actual container in equipment id field and click edit button.", test, test1);
		waitForElement(driver, gird_edit);
		click(driver, gird_edit);
		waitForElement(driver, BL_equip_field);
	clearAndType(driver, BL_equip_field, Equipment_id_input);
	waitForElement(driver, BL_editbtn);
	click(driver, BL_editbtn);
	Step_End(7, "Entered the actual container in equipment id field and click edit button.", test, test1);
	Step_Start(8, "Now system should validate for carrier Seal.", test, test1);
	waitForPopup(driver, BL_Pop,carrier_pop_exp);
	String Reset_pop_act1 = getText(driver, BL_Pop);
	System.out.println(Reset_pop_act1);

	if(carrier_pop_exp.trim().contains(Reset_pop_act1.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + carrier_pop_exp + " || Actual Report Activity  popup is : " + Reset_pop_act1);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + carrier_pop_exp + " || Actual Report Activity  popup is : " + Reset_pop_act1, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + carrier_pop_exp + " || Actual Report Activity  popup is : " + Reset_pop_act1);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + carrier_pop_exp + " || Actual Report Activity  popup is : " + Reset_pop_act1, test,test1); 
		
	} 
	Step_End(8, "Now system should validate for carrier Seal.", test, test1);
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver, popup_Message_Ok_Button);
	
	Step_Start(9, "Entered the carrier Seal and click edit.", test, test1);
	waitForElement(driver, carr_seal_input);
	clearAndType(driver, carr_seal_input, carr_seal_input_value);
	waitForElement(driver, BL_editbtn);
	click(driver, BL_editbtn);
	Step_End(9, "Entered the carrier Seal and click edit.", test, test1);
	Step_Start(10, "Now again click save button then system validate to enter the shipper.", test, test1);
	waitForElement(driver, SaveButton_ToolBar);
	click(driver, SaveButton_ToolBar);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	waitForDisplay(driver, shipper_pop);
	String shipper_pop_act1 = getText(driver, shipper_pop);
	System.out.println(shipper_pop_act1);

	if(shipper_pop_exp.trim().contains(shipper_pop_act1.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + shipper_pop_exp + " || Actual Report Activity  popup is : " + shipper_pop_act1);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + shipper_pop_exp + " || Actual Report Activity  popup is : " + shipper_pop_act1, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + shipper_pop_exp + " || Actual Report Activity  popup is : " + shipper_pop_act1);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + shipper_pop_exp + " || Actual Report Activity  popup is : " + shipper_pop_act1, test,test1); 
		
	} 
	Step_End(10, "Now again click save button then system validate to enter the shipper.", test, test1);
	waitForElement(driver, shipper_close);
	click(driver, shipper_close);
	Step_Start(11, "Enter shipper customer details and click save button.", test, test1);
	waitForElement(driver, customer_type_dp);
	click(driver, customer_type_dp);
	String customer_type_selectt1=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input);
	waitForElement(driver, customer_type_selectt1);
	click(driver, customer_type_selectt1);
	waitForElement(driver, customer_easy_search);
	sendKeys(driver, customer_easy_search, customer_easy_search_input);
	waitForElement(driver, customer_easy_search_select);
	click(driver, customer_easy_search_select);
	waitForElement(driver, customer_Add_btn);
	click(driver, customer_Add_btn);
	waitForElement(driver, SaveButton_ToolBar);
	click(driver, SaveButton_ToolBar);
	Step_End(11, "Enter shipper customer details and click save button.", test, test1);
	Step_Start(12, "now system validate to enter the consignee.", test, test1);
	waitForPopup(driver, consignee_pop,consignee_pop_exp);
	String consignee_pop_act1 = getText(driver, consignee_pop);
	System.out.println(consignee_pop_act1);

	if(consignee_pop_exp.trim().contains(consignee_pop_act1.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity  popup is : " + consignee_pop_exp + " || Actual Report Activity  popup is : " + consignee_pop_act1);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + consignee_pop_exp + " || Actual Report Activity  popup is : " + consignee_pop_act1, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + consignee_pop_exp + " || Actual Report Activity  popup is : " + consignee_pop_act1);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + consignee_pop_exp + " || Actual Report Activity  popup is : " + consignee_pop_act1, test,test1); 
		
	} 
	Step_End(12, "now system validate to enter the consignee.", test, test1);
	waitForElement(driver, shipper_close);
	click(driver, shipper_close);
	Step_Start(13, "Enter Consignee customer details and click save button.", test, test1);
	waitForElement(driver, customer_type_dp);
	click(driver, customer_type_dp);
	String customer_type_selectt_con1=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input_CONSIGNEE);
	waitForElement(driver, customer_type_selectt_con1);
	click(driver, customer_type_selectt_con1);
	waitForElement(driver, customer_easy_search);
	sendKeys(driver, customer_easy_search, customer_easy_search_input_consignee);
	waitForElement(driver, customer_easy_search_select);
	click(driver, customer_easy_search_select);
		waitForElement(driver, customer_Add_btn);
		click(driver, customer_Add_btn);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(13, "Enter Consignee customer details and click save button.", test, test1);
		Step_Start(14, "now system validate to enter the Notify party.", test, test1);
		waitForPopup(driver, notify_pop,notify_pop_exp);
		String notify_pop_act1 = getText(driver, notify_pop);
		System.out.println(notify_pop_act1);

		if(notify_pop_exp.trim().contains(notify_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + notify_pop_exp + " || Actual Report Activity  popup is : " + notify_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + notify_pop_exp + " || Actual Report Activity  popup is : " + notify_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + notify_pop_exp + " || Actual Report Activity  popup is : " + notify_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + notify_pop_exp + " || Actual Report Activity  popup is : " + notify_pop_act1, test,test1); 
			
		} 
		Step_End(14, "now system validate to enter the Notify party.", test, test1);
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);
		Step_Start(15, "Enter notify party and click save button.", test, test1);
		waitForElement(driver, customer_type_dp);
		click(driver, customer_type_dp);
		String customer_type_selectt_not1=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input_Notify);
		waitForElement(driver, customer_type_selectt_not1);
		click(driver, customer_type_selectt_not1);
		waitForElement(driver, customer_easy_search);
		sendKeys(driver, customer_easy_search, customer_easy_search_input_notify);
		waitForElement(driver, customer_easy_search_select);
		click(driver, customer_easy_search_select);
			waitForElement(driver, customer_Add_btn);
			click(driver, customer_Add_btn);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(15, "Enter notify party and click save button.", test, test1);
			Step_Start(16, "Now system validate to enter cargo weight.", test, test1);
			waitForPopup(driver, cargo_pop,cargo_pop_exp);
			String cargo_pop_act1 = getText(driver, cargo_pop);
			System.out.println(cargo_pop_act1);

			if(cargo_pop_act1.trim().contains(cargo_pop_exp.trim())) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity  popup is : " + cargo_pop_exp + " || Actual Report Activity  popup is : " + cargo_pop_act1);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + cargo_pop_exp + " || Actual Report Activity  popup is : " + cargo_pop_act1, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + cargo_pop_exp + " || Actual Report Activity  popup is : " + cargo_pop_act1);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + cargo_pop_exp + " || Actual Report Activity  popup is : " + cargo_pop_act1, test,test1); 
				
			} 
			Step_End(16, "Now system validate to enter cargo weight.", test, test1);
			waitForElement(driver, shipper_close);
			click(driver, shipper_close);
			Step_Start(17, "Edit commodity and enter cargo weight then click on edit button.", test, test1);
			waitForElement(driver, commodity_gird_edit);
			click(driver, commodity_gird_edit);
			Step_End(17, "Edit commodity and enter cargo weight then click on edit button.", test, test1);
			Step_Start(18, "Now system validate to enter all mandatory details in commodity tab ( enter valid commodity code,enter the     commodity description,enter marks no.,enter the package)", test, test1);
			waitForElement(driver, MCN_CargoWeight);
		clearAndType(driver, MCN_CargoWeight, commodity_Cargo_Weight_input);
		waitForElement(driver, bl_commodity_add_button);
		click(driver, bl_commodity_add_button);
		waitForPopup(driver, valid_commodity_pop,valid_comm_pop_exp);
		String valid_comm_pop_act1 = getText(driver, valid_commodity_pop);
		System.out.println(valid_comm_pop_act1);

		if(valid_comm_pop_exp.trim().equals(valid_comm_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + valid_comm_pop_exp + " || Actual Report Activity  popup is : " + valid_comm_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + valid_comm_pop_exp + " || Actual Report Activity  popup is : " + valid_comm_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + valid_comm_pop_exp + " || Actual Report Activity  popup is : " + valid_comm_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + valid_comm_pop_exp + " || Actual Report Activity  popup is : " + valid_comm_pop_act1, test,test1); 
			
		} 
		waitForElement(driver, ID_Popup_Ok_Button5);
		click(driver, ID_Popup_Ok_Button5);
	
		waitForElement(driver, commodity_discription_pop);
		String comm_dis_pop_act1 = getText(driver, commodity_discription_pop);
		System.out.println(comm_dis_pop_act1);

		if(comm_dis_pop_exp.trim().contains(comm_dis_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + comm_dis_pop_exp + " || Actual Report Activity  popup is : " + comm_dis_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + comm_dis_pop_exp + " || Actual Report Activity  popup is : " + comm_dis_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + comm_dis_pop_exp + " || Actual Report Activity  popup is : " + comm_dis_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + comm_dis_pop_exp + " || Actual Report Activity  popup is : " + comm_dis_pop_act1, test,test1); 
			
		} 
		waitForElement(driver, ID_Popup_Ok_Button4);
		click(driver, ID_Popup_Ok_Button4);	
		
		waitForPopup(driver, marks_number_pop,marks_number_pop_exp);
		String marks_number_pop_act1 = getText(driver, marks_number_pop);
		System.out.println(marks_number_pop_act1);

		if(marks_number_pop_exp.trim().contains(marks_number_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + marks_number_pop_exp + " || Actual Report Activity  popup is : " + marks_number_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + marks_number_pop_exp + " || Actual Report Activity  popup is : " + marks_number_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + marks_number_pop_exp + " || Actual Report Activity  popup is : " + marks_number_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + marks_number_pop_exp + " || Actual Report Activity  popup is : " + marks_number_pop_act1, test,test1); 
			
		} 
		waitForElement(driver, ID_Popup_Ok_Buttonn3);
		click(driver, ID_Popup_Ok_Buttonn3);	
		
		
		waitForPopup(driver, enter_commodity_pop,enter_commodity_pop_exp);
		String enter_commodity_pop_act1 = getText(driver, enter_commodity_pop);
		System.out.println(enter_commodity_pop_act1);

		if(enter_commodity_pop_exp.trim().contains(enter_commodity_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  popup is : " + enter_commodity_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  popup is : " + enter_commodity_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  popup is : " + enter_commodity_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  popup is : " + enter_commodity_pop_act1, test,test1); 
			
		} 
		waitForElement(driver, ID_Popup_Ok_Buttonn2);
		click(driver, ID_Popup_Ok_Buttonn2);	
		
		waitForPopup(driver, enter_package_pop,enter_package_pop_exp);
		String enter_package_pop_act1 = getText(driver, enter_package_pop);
		System.out.println(enter_package_pop_act1);

		if(enter_package_pop_exp.trim().contains(enter_package_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + enter_package_pop_exp + " || Actual Report Activity  popup is : " + enter_package_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + enter_package_pop_exp + " || Actual Report Activity  popup is : " + enter_package_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + enter_package_pop_exp + " || Actual Report Activity  popup is : " + enter_package_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + enter_package_pop_exp + " || Actual Report Activity  popup is : " + enter_package_pop_act1, test,test1); 
		}
		} 
		
		Step_End(18, "Now system validate to enter all mandatory details in commodity tab ( enter valid commodity code,enter the     commodity description,enter marks no.,enter the package)", test, test1);
		Step_Start(19, ".Enter Quantity,package,commodity group,choose hs code,mark no and commodity desc the click edit button.", test, test1);
	
		
		
		Step_Start(22, "Now system validate to enter ROE details.Note: If ROE details available then system will not validate) then it will move to 29th step.", test, test1);
		Step_Start(23, "Confirm the BL System will validate with \"Apply ROE\r\n"
				+ "\" message\" if any currency available without ROE.", test, test1);
		waitForDisplay(driver, Roe_pop);
		if(isdisplayed(driver, Roe_pop)) {
			String Roe_pop_act = getText(driver, Roe_pop);
			System.out.println(Roe_pop_act);

			if(Roe_pop_Exp.equals(Roe_pop_act)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity  popup is : " + Roe_pop_Exp + " || Actual Report Activity  popup is : " + Roe_pop_act);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + Roe_pop_Exp + " || Actual Report Activity  popup is : " + Roe_pop_act, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + Roe_pop_Exp + " || Actual Report Activity  popup is : " + Roe_pop_act);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + Roe_pop_Exp + " || Actual Report Activity  popup is : " + Roe_pop_act, test,test1); 
				
			} 
			Step_End(22, "Now system validate to enter ROE details.Note: If ROE details available then system will not validate) then it will move to 29th step.", test, test1);
			Step_End(23, "Confirm the BL System will validate with \"Apply ROE\r\n"
					+ "\" message\" if any currency available without ROE.", test, test1);
			waitForElement(driver, shipper_close);
			click(driver, shipper_close);	
			Step_Start(24, "Then switch to line & Open the treasury ROE module.", test, test1);
			waitForElement(driver, Switch_Profile);
			safeclick(driver, Switch_Profile);
			waitForElement(driver, Reset_agency);
			safeclick(driver, Reset_agency);
			moduleNavigate(driver, Treasury_ROE);
			Step_End(24, "Then switch to line & Open the treasury ROE module.", test, test1);
			Step_Start(25, "By using the global search enter the sail date.", test, test1);
			waitForElement(driver, Roe_search);
			safeclick(driver, Roe_search);
			twoColumnSearchWindow(driver, CRO_search_condition, Roe_Search, Roe_Date_input);
		
			Step_End(25, "By using the global search enter the sail date.", test, test1);
			
			Step_Start(26, "Click the edit button & enter the currency then save.  .", test, test1);
			waitForElement(driver, Roe_edit);
			safeclick(driver, Roe_edit);
			waitForElement(driver, currency_code_search);
			safeclick(driver, currency_code_search);
			waitForElement(driver, currency_code);
			sendKeys(driver, currency_code, currency_code_input);
			waitForElement(driver, B_selectrouting1);
			safeclick(driver, B_selectrouting1);
			waitForElement(driver, Select_Button);
			safeclick(driver, Select_Button);
			waitForElement(driver, Roe_exchange);
			clearAndType1(driver, Roe_exchange, Roe_exchange_input);
			waitForElement(driver, Roe_add);
			safeclick(driver, Roe_add);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			Step_End(26, "Click the edit button & enter the currency then save.  .", test, test1);
			waitForElement(driver, Roe_Yes);
			safeclick(driver, Roe_Yes);
			waitForPopup(driver, Roe_updated_pop,Roe_updated_pop_ext);
			String Roe_updated_pop_act = getText(driver, Roe_updated_pop);
			System.out.println(Roe_updated_pop_act);

			if(Roe_updated_pop_ext.equals(Roe_updated_pop_act)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity  popup is : " + Roe_updated_pop_ext + " || Actual Report Activity  popup is : " + Roe_updated_pop_act);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + Roe_updated_pop_ext + " || Actual Report Activity  popup is : " + Roe_updated_pop_act, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + Roe_updated_pop_ext + " || Actual Report Activity  popup is : " + Roe_updated_pop_act);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + Roe_updated_pop_ext + " || Actual Report Activity  popup is : " + Roe_updated_pop_act, test,test1); 
				
			} 
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_Start(27, "Now switch to agency again & open the BL module.   .", test, test1);
			SwitchProfile(driver, agencyUser);
			
			moduleNavigate(driver, Module_Search_BL);
			Step_End(27, "Now switch to agency again & open the BL module.   .", test, test1);
			waitForElement(driver, bl_search_btn);
			safeclick(driver, bl_search_btn);
			
			
			globalValueSearchWindow(driver, dropdownCondition1, Select_search_value_bill, booknum, "", "", "", "");
			
				Step_Start(28, "Edit the BL & click confirm button to save. .", test, test1);
				waitForElement(driver, bl_edit_btn);
				click(driver, bl_edit_btn);
				waitForElement(driver, bl_confirm_btn);
				click(driver, bl_confirm_btn);
			
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				Step_End(28, "Edit the BL & click confirm button to save. .", test, test1);
		
			
		}
		Step_Start(29, "Now system validate to enter the description of goods..", test, test1);
		if(isdisplayed(driver, shipper_close)) {
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);	
		Step_End(29, "Now system validate to enter the description of goods..", test, test1);
		}
		Step_Start(30, "click on cargo summary button and click save.", test, test1);
		if(isClickable(driver, cargo_summary)) {
		waitForElement(driver, cargo_summary);
		click(driver, cargo_summary);	
		
		Step_End(30, "click on cargo summary button and click save.", test, test1);
		Step_Start(31, "Now bl number should be generated and bl number indication should be in green color.  ", test, test1);
		
		
		waitForDisplay(driver, SaveButton_ToolBar);
		if(isClickable(driver, SaveButton_ToolBar)) {
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		waitForPopup(driver, BL_Pop,Saved_pop_updated);
		String saved_pop_act11= getText(driver, BL_Pop);
		System.out.println(saved_pop_act11);

		if(saved_pop_act11.contains(Saved_pop_updated)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + Saved_pop_updated + " || Actual Report Activity  popup is : " + saved_pop_act11);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  popup is : " + Saved_pop_updated + " || Actual Report Activity  popup is : " + saved_pop_act11, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + Saved_pop_updated + " || Actual Report Activity  popup is : " + saved_pop_act11);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup is : " + Saved_pop_updated + " || Actual Report Activity  popup is : " + saved_pop_act11, test,test1); 
			
		} }
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		
		waitForElement(driver, BL_no);
		String bill_number1= getAttribute(driver, BL_no,"value");
		System.out.println(bill_number1);
		Extent_call(test, test1, "****Bill number was generated as **"+bill_number1);
		
		String bill_number_colour111= getTextBackgroundColor(driver, BL_no);
		String bill_number_colour11=getColorName(bill_number_colour111);
		System.out.println(bill_number_colour11);
		
		
		
		
		
		if(booking_confirmed_Color.contains(bill_number_colour11)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour11);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour11, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour11);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  colour is : " + booking_confirmed_Color + " || Actual Report Activity  colour is : " + bill_number_colour11, test,test1); 
			
		} }
		Extent_completed(testcase_Name, test, test1);

}}
