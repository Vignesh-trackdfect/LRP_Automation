package LRP_Bill_Of_Lading_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Bill_Of_Lading_Locators;

public class TC_Bill_Of_Lading_SC11 extends Keywords {

	public void Bill_Of_Lading_SC11(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Bill_Of_Lading_SC11";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_User = Excel_data.get("Agency_User");
		String bill_Of_Lading_Module = Excel_data.get("bill_Of_Lading_Module");
		String globalsearch_BL = Excel_data.get("globalsearch_BL");
		String condition = Excel_data.get("condition");
		String Booking_module = Excel_data.get("Booking_module");
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
		String Saved_pop_draft = Excel_data.get("Saved_pop_draft").trim();
		String customer_easy_search_input = Excel_data.get("customer_easy_search_input");
		String bl_mismatch_pop_exp = Excel_data.get("bl_mismatch_pop_exp");
		String Equipment_id_input = Excel_data.get("Equipment_id_input");
		String carrier_pop_exp = Excel_data.get("carrier_pop_exp");
		String carr_seal_input_value = Excel_data.get("carr_seal_input_value");
		String Quantity_value_input = Excel_data.get("Quantity_value_input");
		String Package_value_input = Excel_data.get("Package_value_input");
		String commodity_grp_input = Excel_data.get("commodity_grp_input_value");
		String Select_search_value_hs = Excel_data.get("Select_search_value_hs");
		String HS_code_input_value = Excel_data.get("HS_code_input_value");
		String mark_number_input = Excel_data.get("mark_number_input");
		String commodity_desc_input = Excel_data.get("commodity_desc_input");
		String commodity_Cargo_Weight_input = Excel_data.get("commodity_Cargo_Weight_input");
		String Customer_type_input = Excel_data.get("Customer_type_input");
		String Customer_type_input_CONSIGNEE = Excel_data.get("Customer_type_input_CONSIGNEE");
		String consignee_pop_exp = Excel_data.get("consignee_pop_exp");
		String customer_easy_search_input_consignee = Excel_data.get("customer_easy_search_input_consignee");
		String notify_pop_exp = Excel_data.get("notify_pop_exp");
		String Customer_type_input_Notify = Excel_data.get("Customer_type_input_Notify");
		String customer_easy_search_input_notify = Excel_data.get("customer_easy_search_input_notify");
		String valid_comm_pop_exp = Excel_data.get("valid_comm_pop_exp");
		String comm_dis_pop_exp = Excel_data.get("comm_dis_pop_exp");
		String marks_number_pop_exp = Excel_data.get("marks_number_pop_exp");
		String enter_commodity_pop_exp = Excel_data.get("enter_commodity_pop_exp");
		String enter_package_pop_exp = Excel_data.get("enter_package_pop_exp");
		String saved_pop_exp = Excel_data.get("saved_pop_exp");
		String updated_pop_exp = Excel_data.get("updated_pop_exp");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Global_Book_num_search = Excel_data.get("Global_Book_num_search");
		String CRO_search = Excel_data.get("CRO_search");
		String CRO_search_condition = Excel_data.get("CRO_search_condition");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String package_exp = Excel_data.get("Package_pop_expected");
		String Commodity_group = Excel_data.get("Commodity_group");
		String Package_Quantity = Excel_data.get("Package_Quantity");
		











		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);

		
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, Agency_User);
		Step_End(1, "Switch to agency", test, test1);


		Step_Start(1, "To create Booking  and CRO, kindly use scenario 46 .", test, test1);

		
		moduleNavigate(driver, Booking_module);
		


		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);


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


		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, Global_Book_num_search, booknum, "", "", "", "");
	
		waitForElement(driver, leg_tab);
		waitForElement(driver, ready_BL);
		String readyBL_status=getAttribute(driver, ready_BL, "class");
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
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);



		Step_Start(2, "Open the Bill of Lading module", test, test1);
	
		
		moduleNavigate(driver, bill_Of_Lading_Module);
		
		Step_End(2, "Open the Bill of Lading module", test, test1);


		Step_Start(3, "By using book no local search retrieve the data", test, test1);
		waitForElement(driver, bl_search_btn);
		safeclick(driver, bl_search_btn);
		globalValueSearchWindow(driver, condition, globalsearch_BL, booknum, "", "", "", "");
	
		Step_End(3, "By using book no local search retrieve the data." , test, test1);
	
		Step_Start(4, "Edit the BL using tool bar & save the BL in draft status." , test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,Saved_pop_draft);
		String saved_pop_act= getText(driver, popup_Message);
		System.out.println(saved_pop_act);

		if(saved_pop_act.trim().contains(Saved_pop_draft.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + Saved_pop_draft + " || Actual Report Activity POPUP is : " + saved_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + Saved_pop_draft + " || Actual Report Activity POPUP is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + Saved_pop_draft + " || Actual Report Activity POPUP is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + Saved_pop_draft + " || Actual Report Activity POPUP is : " + saved_pop_act, test,test1); 

		} 
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4, "Edit the BL using tool bar & save the BL in draft status." , test, test1);

		Step_Start(5, "Click the confirm button in master tab & then save", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);


		waitForElement(driver, bl_confirm_btn);
		click(driver, bl_confirm_btn);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(5, "Click the confirm button in master tab & then save", test, test1);

		Step_Start(6, "System will validate for Equipment type mismatch", test, test1);

		waitForPopup(driver, bl_mismatch_pop,bl_mismatch_pop_exp);
		String bl_mismatch_pop_act = getText(driver, bl_mismatch_pop);
		System.out.println(bl_mismatch_pop_act);

		if(bl_mismatch_pop_act.trim().contains(bl_mismatch_pop_exp.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity POPUP is : " + bl_mismatch_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity POPUP is : " + bl_mismatch_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity POPUP is : " + bl_mismatch_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity POPUP is : " + bl_mismatch_pop_act, test,test1); 

		} 
		waitForElement(driver, bl_mismatch_pop_close);
		click(driver, bl_mismatch_pop_close);

		Step_End(6, "System will validate for Equipment type mismatch", test, test1);

		Step_Start(7, "Entered the actual container in equipment id field and click edit button", test, test1);
		waitForElement(driver, gird_edit);
		click(driver, gird_edit);
		waitForElement(driver, BL_equip_field);
		clearAndType(driver, BL_equip_field, Equipment_id_input);
		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);
		Step_End(7, "Entered the actual container in equipment id field and click edit button", test, test1);

		Step_Start(8, "Now system should validate for carrier Seal", test, test1);
		waitForPopup(driver, popup_Message,carrier_pop_exp);
		String Reset_pop_act = getText(driver, popup_Message);
		System.out.println(Reset_pop_act);

		if(carrier_pop_exp.trim().equals(Reset_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + carrier_pop_exp + " || Actual Report Activity POPUP is : " + Reset_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + carrier_pop_exp + " || Actual Report Activity POPUP is : " + Reset_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + carrier_pop_exp + " || Actual Report Activity POPUP is : " + Reset_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + carrier_pop_exp + " || Actual Report Activity POPUP is : " + Reset_pop_act, test,test1); 

		} 
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(8, "Now system should validate for carrier Seal", test, test1);

		Step_Start(9, "Entered the carrier Seal and click edit", test, test1);
		waitForElement(driver, carr_seal_input);
		clearAndType(driver, carr_seal_input, carr_seal_input_value);
		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);
		Step_End(9, "Entered the carrier Seal and click edit", test, test1);

		Step_Start(10, "Now again click save button then system validate to enter the shipper", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		
		
		
		waitForPopup(driver, popup_Message,package_exp);
		String package_act = getText(driver, popup_Message);
		
		
		if(package_act.equals(package_exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + package_act + " || Actual Report Activity POPUP is : " + package_exp);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + package_act + " || Actual Report Activity POPUP is : " + package_exp, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + package_act + " || Actual Report Activity POPUP is : " + package_exp);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + package_act + " || Actual Report Activity POPUP is : " + package_exp, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity POPUP is : " + valid_comm_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity POPUP is : " + valid_comm_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity POPUP is : " + valid_comm_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity POPUP is : " + valid_comm_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity POPUP is : " + comm_dis_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity POPUP is : " + comm_dis_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity POPUP is : " + comm_dis_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity POPUP is : " + comm_dis_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + marks_number_pop_exp + " || Actual Report Activity POPUP is : " + marks_number_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + marks_number_pop_exp + " || Actual Report Activity POPUP is : " + marks_number_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + marks_number_pop_exp + " || Actual Report Activity POPUP is : " + marks_number_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + marks_number_pop_exp + " || Actual Report Activity POPUP is : " + marks_number_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity POPUP is : " + enter_commodity_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity POPUP is : " + enter_commodity_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity POPUP is : " + enter_commodity_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity POPUP is : " + enter_commodity_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + enter_package_pop_exp + " || Actual Report Activity POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + enter_package_pop_exp + " || Actual Report Activity POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + enter_package_pop_exp + " || Actual Report Activity POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + enter_package_pop_exp + " || Actual Report Activity POPUP is : " + enter_package_pop_act, test,test1); 
			
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
		clear(driver, MCN_CargoWeight);
		sendKeys(driver, MCN_CargoWeight, commodity_Cargo_Weight_input);
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
		
	
	
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);
		
		Step_End(10, "Now again click save button then system validate to enter the shipper", test, test1);
		Step_Start(11, "Enter shipper customer details and click save button", test, test1);
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
		Step_End(11, "Enter shipper customer details and click save button", test, test1);

		Step_Start(12, "now system validate to enter the consignee", test, test1);
		waitForPopup(driver, consignee_pop,consignee_pop_exp);
		String consignee_pop_act = getText(driver, consignee_pop);
		System.out.println(consignee_pop_act);

		if(consignee_pop_exp.trim().equals(consignee_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + consignee_pop_exp + " || Actual Report Activity POPUP is : " + consignee_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity POPUP is : " + consignee_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity POPUP is : " + consignee_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity POPUP is : " + consignee_pop_act, test,test1); 

		} 
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);
		Step_End(12, "now system validate to enter the consignee", test, test1);
		Step_Start(13, "Enter Consignee customer details and click save button", test, test1);

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
		Step_End(13, "Enter Consignee customer details and click save button", test, test1);
		Step_Start(14, "now system validate to enter the Notify party", test, test1);
		waitForPopup(driver, notify_pop,notify_pop_exp);
		String notify_pop_act = getText(driver, notify_pop);
		System.out.println(notify_pop_act);

		if(notify_pop_exp.trim().equals(notify_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + notify_pop_exp + " || Actual Report Activity POPUP is : " + notify_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + notify_pop_exp + " || Actual Report Activity POPUP is : " + notify_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + notify_pop_exp + " || Actual Report Activity POPUP is : " + notify_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + notify_pop_exp + " || Actual Report Activity POPUP is : " + notify_pop_act, test,test1); 

		} 
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);
		Step_End(14, "now system validate to enter the Notify party", test, test1);

		Step_End(15, "Enter notify party and click save button", test, test1);
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

		Step_End(15, "Enter notify party and click save button", test, test1);

		Step_Start(16, "Now system validate to enter cargo weight", test, test1);
	
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);
		Step_End(16, "Now system validate to enter cargo weight", test, test1);

		Step_Start(17, "Edit commodity and enter cargo weight then click on edit button", test, test1);
	
		
		

	
		waitForElement(driver, Auto_rate_button);
		click(driver, Auto_rate_button);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(21, "click on auto rate button, once charges pop up now click save button", test, test1);
		Step_Start(22, "While save system validate to enter the description of goods", test, test1);

		waitForElement(driver, shipper_close);
		click(driver, shipper_close);

		Step_End(22, "While save system validate to enter the description of goods", test, test1);

		Step_Start(23, "Go to body tab, Click .Click Cargo Summary/Cargo Details/Cargo Summary-I/Cargo-Summary-II & then compare the cargo weight.", test, test1);
		waitForElement(driver, cargo_summary);
		click(driver, cargo_summary);	


		waitForElement(driver, marks_And_Nos_InputArea_BL);
		String Marks_And_Nos=getText(driver, marks_And_Nos_InputArea_BL);
		System.out.println("Cargo Summary Marks_And_Nos :"+Marks_And_Nos);

		waitForElement(driver, description_Of_Goods_InputArea_BL);
		String Description_Of_Goods=getText(driver, description_Of_Goods_InputArea_BL);
		System.out.println("Cargo Summary Description_Of_Goods :"+Description_Of_Goods);

		waitForElement(driver, cargo_Weight_InputArea_BL);
		String Cargo_weight = getText(driver, cargo_Weight_InputArea_BL);
		System.out.println("Cargo Summary Cargo_weight :" + Cargo_weight);


		String[] cargoweight = Cargo_weight.split("\\.");  
		String cargo_Weight_Value = cargoweight[0];
		System.out.println(cargo_Weight_Value);

		if(commodity_Cargo_Weight_input.equals(cargo_Weight_Value)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + commodity_Cargo_Weight_input + " || Actual Report Activity POPUP is : " + cargo_Weight_Value);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + commodity_Cargo_Weight_input + " || Actual Report Activity POPUP is : " + cargo_Weight_Value, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + commodity_Cargo_Weight_input + " || Actual Report Activity POPUP is : " + cargo_Weight_Value);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + commodity_Cargo_Weight_input + " || Actual Report Activity POPUP is : " + cargo_Weight_Value, test,test1); 

		} 


		waitForElement(driver, container_Details_InputArea_BL);
		String Container_Details=getText(driver, container_Details_InputArea_BL);
		System.out.println("Cargo Summary Container_Details :"+Container_Details);

		waitForElement(driver, container_Details_InputArea_BL);
		String Measurement_Details=getText(driver, container_Details_InputArea_BL);
		System.out.println("Cargo Summary Measurement_Details :"+Measurement_Details);

		waitForElement(driver, cargo_Details_Button_BL);
		click(driver, cargo_Details_Button_BL);


		waitForElement(driver, marks_And_Nos_InputArea_BL);
		String Marks_And_Nos1=getText(driver, marks_And_Nos_InputArea_BL);
		System.out.println("Cargo Details Marks_And_Nos :"+Marks_And_Nos1);

		waitForElement(driver, description_Of_Goods_InputArea_BL);
		String Description_Of_Goods1=getText(driver, description_Of_Goods_InputArea_BL);
		System.out.println("Cargo Details Description_Of_Goods :"+Description_Of_Goods1);

		waitForElement(driver, cargo_Weight_InputArea_BL);
		String Cargo_weight1=getText(driver, cargo_Weight_InputArea_BL);
		System.out.println("Cargo Details Cargo_weight :"+Cargo_weight1);

		waitForElement(driver, container_Details_InputArea_BL);
		String Measurement_Details1=getText(driver, container_Details_InputArea_BL);
		System.out.println("Cargo Summary Measurement_Details :\n"+Measurement_Details1);


		waitForElement(driver, cargo_Summary_2_Button_BL);
		click(driver, cargo_Summary_2_Button_BL);

		waitForElement(driver, marks_And_Nos_InputArea_BL);
		String Marks_And_Nos2=getText(driver, marks_And_Nos_InputArea_BL);
		System.out.println("Cargo Summary Marks_And_Nos :"+Marks_And_Nos2);

		waitForElement(driver, description_Of_Goods_InputArea_BL);
		String Description_Of_Goods2=getText(driver, description_Of_Goods_InputArea_BL);
		System.out.println("Cargo Summary Description_Of_Goods :"+Description_Of_Goods2);

		waitForElement(driver, cargo_Weight_InputArea_BL);
		String Cargo_weight2=getText(driver, cargo_Weight_InputArea_BL);
		System.out.println("Cargo Summary Cargo_weight :"+Cargo_weight2);

		waitForElement(driver, container_Details_InputArea_BL);
		String Container_Details2=getText(driver, container_Details_InputArea_BL);
		System.out.println("Cargo Summary Container_Details :"+Container_Details2);

		waitForElement(driver, container_Details_InputArea_BL);
		String Measurement_Details2=getText(driver, container_Details_InputArea_BL);
		System.out.println("Cargo Summary Measurement_Details :\n"+Measurement_Details2);



		waitForElement(driver, cargo_Summary_1_Button_BL);
		click(driver, cargo_Summary_1_Button_BL);


		waitForElement(driver, marks_And_Nos_InputArea_BL);
		String Marks_And_Nos3=getText(driver, marks_And_Nos_InputArea_BL);
		System.out.println("Cargo Summary Marks_And_Nos :"+Marks_And_Nos3);

		waitForElement(driver, description_Of_Goods_InputArea_BL);
		String Description_Of_Goods3=getText(driver, description_Of_Goods_InputArea_BL);
		System.out.println("Cargo Summary Description_Of_Goods :"+Description_Of_Goods3);

		waitForElement(driver, cargo_Weight_InputArea_BL);
		String Cargo_weight3=getText(driver, cargo_Weight_InputArea_BL);
		System.out.println("Cargo Summary Cargo_weight :"+Cargo_weight3);

		waitForElement(driver, container_Details_InputArea_BL);
		String Container_Details3=getText(driver, container_Details_InputArea_BL);
		System.out.println("Cargo Summary Container_Details :"+Container_Details3);

		waitForElement(driver, container_Details_InputArea_BL);
		String Measurement_Details3=getText(driver, container_Details_InputArea_BL);
		System.out.println("Cargo Summary Measurement_Details :\n"+Measurement_Details3);
		
		Step_End(23, "Go to body tab, Click .Click Cargo Summary/Cargo Details/Cargo Summary-I/Cargo-Summary-II & then compare the cargo weight.", test, test1);

Step_Start(24, "Then click clear button system will clear all the data", test, test1);
		waitForElement(driver, cargo_summary);
		click(driver, cargo_summary);	

		waitForElement(driver, clear_Button_BL);
		click(driver, clear_Button_BL);
		Step_End(24, "Then click clear button system will clear all the data", test, test1);
		
		Step_Start(25, "Now click refresh all button then compare the data with previous cleared data", test, test1);

		waitForElement(driver, BL_body);
		RightClick(driver, BL_body);


		waitForElement(driver, refresh_all);
		click(driver, refresh_all);


		waitForElement(driver, marks_And_Nos_InputArea_BL);
		String After_Refresh_Marks_And_Nos=getText(driver, marks_And_Nos_InputArea_BL);
		System.out.println("After_Refresh_Cargo Summary Marks_And_Nos :"+After_Refresh_Marks_And_Nos);

		waitForElement(driver, description_Of_Goods_InputArea_BL);
		String After_Refresh_Description_Of_Goods=getText(driver, description_Of_Goods_InputArea_BL);
		System.out.println("After_Refresh_Cargo Summary Description_Of_Goods :"+After_Refresh_Description_Of_Goods);

		waitForElement(driver, cargo_Weight_InputArea_BL);
		String After_Refresh_Cargo_weight = getText(driver, cargo_Weight_InputArea_BL);
		System.out.println("After_Refresh_Cargo Summary Cargo_weight :" + After_Refresh_Cargo_weight);

		waitForElement(driver, container_Details_InputArea_BL);
		String After_Refresh_Container_Details=getText(driver, container_Details_InputArea_BL);
		System.out.println("After_Refresh_Cargo Summary Container_Details :\n"+After_Refresh_Container_Details);






		if(Marks_And_Nos.equals(After_Refresh_Marks_And_Nos)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity   is : " + Marks_And_Nos + " || Actual Report Activity  is : " + After_Refresh_Marks_And_Nos);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity   is : " + Marks_And_Nos + " || Actual Report Activity  is : " + After_Refresh_Marks_And_Nos, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity   is : " + Marks_And_Nos + " || Actual Report Activity  is : " + After_Refresh_Marks_And_Nos);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity   is : " + Marks_And_Nos + " || Actual Report Activity  is : " + After_Refresh_Marks_And_Nos, test,test1); 

		} 

		if(Description_Of_Goods.equals(After_Refresh_Description_Of_Goods)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity   is : " + Description_Of_Goods + " || Actual Report Activity  is : " + After_Refresh_Description_Of_Goods);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity   is : " + Description_Of_Goods + " || Actual Report Activity  is : " + After_Refresh_Description_Of_Goods, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity   is : " + Description_Of_Goods + " || Actual Report Activity  is : " + After_Refresh_Description_Of_Goods);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity   is : " + Description_Of_Goods + " || Actual Report Activity  is : " + After_Refresh_Description_Of_Goods, test,test1); 

		} 

		if(Cargo_weight.equals(After_Refresh_Cargo_weight)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity   is : " + Cargo_weight + " || Actual Report Activity  is : " + After_Refresh_Cargo_weight);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity   is : " + Cargo_weight + " || Actual Report Activity  is : " + After_Refresh_Cargo_weight, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity   is : " + Cargo_weight + " || Actual Report Activity  is : " + After_Refresh_Cargo_weight);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity   is : " + Cargo_weight + " || Actual Report Activity  is : " + After_Refresh_Cargo_weight, test,test1); 
		} 

		if(Container_Details.equals(After_Refresh_Container_Details)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity   is : \n" + Container_Details + " || Actual Report Activity  is : \n" + After_Refresh_Container_Details);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity   is : \n" + Container_Details + " || Actual Report Activity  is : \n" + After_Refresh_Container_Details, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity   is : \n" + Container_Details + " || Actual Report Activity  is : \n" + After_Refresh_Container_Details);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity   is : \n" + Container_Details + " || Actual Report Activity  is : \n" + After_Refresh_Container_Details, test,test1); 
		} 


      Step_End(25, "Now click refresh all button then compare the data with previous cleared data", test, test1);

		Step_Start(26, "Now while save bl number should be confirmed and bl number indication should be in green color.", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);


		waitForPopup(driver, BL_Pop,updated_pop_exp);
		String saved_pop_act1= getText(driver, BL_Pop);
		System.out.println(saved_pop_act1);

		if(saved_pop_act1.contains(updated_pop_exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + saved_pop_exp + " || Actual Report Activity POPUP is : " + updated_pop_exp);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + saved_pop_exp + " || Actual Report Activity POPUP is : " + updated_pop_exp, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + saved_pop_exp + " || Actual Report Activity POPUP is : " + updated_pop_exp);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + saved_pop_exp + " || Actual Report Activity POPUP is : " + updated_pop_exp, test,test1); 

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





		if(booking_confirmed_Color.equals(bill_number_colour)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity COLOUR is : " + bill_number_colour, test,test1); 

		} 


		Step_End(26, "Now while save bl number should be confirmed and bl number indication should be in green color.", test, test1);
		Extent_completed(testcase_Name, test, test1);











	}

}
