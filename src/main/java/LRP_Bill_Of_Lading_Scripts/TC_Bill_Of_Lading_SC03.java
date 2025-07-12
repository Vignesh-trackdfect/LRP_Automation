package LRP_Bill_Of_Lading_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Bill_Of_Lading_Locators;
import locators.Booking_Locators;

public class TC_Bill_Of_Lading_SC03  extends Keywords{
	public void Bill_Of_Lading_SC03(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
	String testcase_Name="TC_Bill_Of_Lading_SC03";
	


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
	String Customer_type_input = Excel_data.get("Customer_type_input");
	String customer_type_input = Excel_data.get("customer_type_input");
	String customer_code_input = Excel_data.get("customer_code_input");
	String Customer_type_input_CONSIGNEE = Excel_data.get("Customer_type_input_CONSIGNEE");
	String customer_easy_search_input = Excel_data.get("customer_easy_search_input");
	String Consignee_customer_COPY = Excel_data.get("Consignee_customer_COPY");
	String Select_Options=Excel_data.get("Select_Options");
	String Select_Options_1=Excel_data.get("Select_Options_1");
	String Remove_line=Excel_data.get("Remove_line");
	String Saved_pop_draft=Excel_data.get("Saved_pop_draft");
	String bl_mismatch_pop_exp = Excel_data.get("bl_mismatch_pop_exp");
	String Equipment_id_input = Excel_data.get("Equipment_id_input");
	String carrier_pop_exp = Excel_data.get("carrier_pop_exp");
	String carr_seal_input_value = Excel_data.get("carr_seal_input_value");
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
	String Global_Book_num_search = Excel_data.get("Global_Book_num_search");
	String Customer_search = Excel_data.get("Customer_search");
	String CRO_search = Excel_data.get("CRO_search");
	String CRO_search_condition = Excel_data.get("CRO_search_condition");
	String customr_tyep_search = Excel_data.get("customr_tyep_search");
	String package_exp = Excel_data.get("Package_pop_expected");
	String valid_comm_pop_exp = Excel_data.get("valid_comm_pop_exp");
	String comm_dis_pop_exp = Excel_data.get("comm_dis_pop_exp");
	String marks_number_pop_exp = Excel_data.get("marks_number_pop_exp");
	String enter_commodity_pop_exp = Excel_data.get("enter_commodity_pop_exp");
	String enter_package_pop_exp = Excel_data.get("enter_package_pop_exp");
	String Commodity_group = Excel_data.get("Commodity_group");
	String Package_Quantity = Excel_data.get("Package_Quantity");
	String Unit = Excel_data.get("Unit");
	
	
	String customer_type_selectt=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input);
	String customer_type_selectt_con=String.format(Bill_Of_Lading_Locators.customer_type_select, Customer_type_input_CONSIGNEE);
	String CON_copy=String.format(Bill_Of_Lading_Locators.customer_con_paste, Consignee_customer_COPY);
	String Remove_linee=String.format(Bill_Of_Lading_Locators.customer_con_paste, Remove_line);
	
	
	
	
	//locators


	Extent_Start(testcase_Name, test, test1);

	navigateUrl(driver, url);

	LRP_Login(driver, Username, Password);

	


	
	Step_Start(1, "Switch to agency" , test, test1);
	SwitchProfile(driver, agencyUser);
	Step_End(1, "Switch to agency" , test, test1);
//
//	Extent_cal(test, test1,"** Enter Booking Module **");
	Step_Start(2, "Open the Bill of Lading module." , test, test1);
	moduleNavigate(driver, search_module);

	Step_End(2, "Open the Bill of Lading module." , test, test1);

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
	if(isdisplayed(driver, popup_Message_Ok_Button)) {
		click(driver, popup_Message_Ok_Button);
	}
	
	
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
	
	moduleNavigate(driver, Module_Search_BL);
	
	Step_Start(3, "By using book no local search retrieve the data." , test, test1);
	waitForElement(driver, bl_search_btn);
	safeclick(driver, bl_search_btn);
	
	globalValueSearchWindow(driver, dropdownCondition1, Select_search_value_bill, booknum, "", "", "", "");
	
	
	Step_End(3, "By using book no local search retrieve the data." , test, test1);
	
		Step_Start(4, "Edit the BL using tool bar & save the BL in draft status." , test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(4, "Edit the BL using tool bar & save the BL in draft status." , test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		
		waitForPopup(driver, popup_Message,Saved_pop_draft);

		String saved_pop_act= getText(driver, popup_Message);
		System.out.println(saved_pop_act);

		if(saved_pop_act.trim().contains(Saved_pop_draft.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report popup is : " + Saved_pop_draft + " || Actual Report Activity  POPUP is : " + saved_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + Saved_pop_draft + " || Actual Report Activity  POPUP is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report popup is : " + Saved_pop_draft + " || Actual Report Activity  POPUP is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + Saved_pop_draft + " || Actual Report Activity  POPUP is : " + saved_pop_act, test,test1); 
			
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		waitForElement(driver, bl_edit_btn);
		click(driver, bl_edit_btn);
		Step_Start(5, "In customer tab, Select the customer type as \"Shipper\".." , test, test1);
		waitForElement(driver, Customer_Tab);
		click(driver, Customer_Tab);
		waitForElement(driver, customer_type_dp);
		click(driver, customer_type_dp);
		waitForElement(driver, customer_type_selectt);
		click(driver, customer_type_selectt);
		Step_End(5, "In customer tab, Select the customer type as \"Shipper\".." , test, test1);
		Step_Start(6, "By entering  % symbol in JDLC customer search system will list all the customers." , test, test1);
		waitForElement(driver, customer_search_btn);
		click(driver, customer_search_btn);
	
		globalValueSearchWindow(driver, dropdownCondition1, Customer_search, customer_code_input, customr_tyep_search, customer_type_input, "", "");
	
		
		Step_End(6, "By entering  % symbol in JDLC customer search system will list all the customers." , test, test1);
		Step_Start(7, "Select the shipper customer details and click add button." , test, test1);
	
		
			waitForElement(driver, customer_Add_btn);
			click(driver, customer_Add_btn);
		
			Step_End(7, "Select the shipper customer details and click add button." , test, test1);
			Step_Start(8, "Now Select the customer type as \"Consignee\"" , test, test1);
			waitForElement(driver, customer_type_dp);
			click(driver, customer_type_dp);
			waitForElement(driver, customer_type_selectt_con);
			click(driver, customer_type_selectt_con);
			Step_End(8, "Now Select the customer type as \"Consignee\"" , test, test1);
			Step_Start(9, "By using Easy search system will list all the customers" , test, test1);
			waitForElement(driver, customer_easy_search);
			sendKeys(driver, customer_easy_search, customer_easy_search_input);
			waitForElement(driver, customer_easy_search_select);
			click(driver, customer_easy_search_select);
			Step_End(9, "By using Easy search system will list all the customers" , test, test1);
			Step_Start(10, "Select the consignee customer details and click add button." , test, test1);
				waitForElement(driver, customer_Add_btn);
				click(driver, customer_Add_btn);
				Step_End(10, "Select the consignee customer details and click add button." , test, test1);
				Step_Start(11, "Right click on the Consignee customer and click copy." , test, test1);
				waitForElement(driver, CON_copy);
				click(driver, CON_copy);
				RightClick(driver, CON_copy);
				waitForElement(driver, customer_Grid_Copy);
				click(driver, customer_Grid_Copy);
				Step_End(11, "Right click on the Consignee customer and click copy." , test, test1);
				Step_Start(12, "Select the Customer type as \"Notify\" & click paste." , test, test1);
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).build().perform();
				List<String> options = splitAndExpand(Select_Options);
				for(String option : options) {
					String select_Paste=String.format(Booking_Locators.select_Paste_Option,option);
					waitForElement(driver, select_Paste);
					click(driver, select_Paste);
				}
				
				action.keyUp(Keys.CONTROL).build().perform();
				waitForElement(driver, customer_Paste);
				safeclick(driver, customer_Paste);
				Step_End(12, "Select the Customer type as \"Notify\" & click paste." , test, test1);
				Step_Start(13, "Right click on the Consignee customer and click copy." , test, test1);
				waitForElement(driver, CON_copy);
				click(driver, CON_copy);
				RightClick(driver, CON_copy);
				waitForElement(driver, customer_Grid_Copy);
				click(driver, customer_Grid_Copy);
				Step_End(13, "Right click on the Consignee customer and click copy." , test, test1);
				Step_Start(14, ".Select the Customer type as \"Additional Notifier 1\" & click paste." , test, test1);
				Actions action1 = new Actions(driver);
				action1.keyDown(Keys.CONTROL).build().perform();
				List<String> options1 = splitAndExpand(Select_Options_1);
				for(String option : options1) {
					String select_Paste=String.format(Booking_Locators.select_Paste_Option,option);
					waitForElement(driver, select_Paste);
					click(driver, select_Paste);
				}
				action1.keyUp(Keys.CONTROL).build().perform();
				waitForElement(driver, customer_Paste);
				safeclick(driver, customer_Paste);
				Step_End(14, ".Select the Customer type as \"Additional Notifier 1\" & click paste." , test, test1);
				Step_Start(15, ".Select the Additional Notifier 1 customer and click remove." , test, test1);
				waitForElement(driver, Remove_linee);
				click(driver, Remove_linee);
				waitForElement(driver, customer_con_remove);
				click(driver, customer_con_remove);
				
			
		waitForDisplay(driver, Remove_linee);
		if(!isdisplayed(driver, Remove_linee)) {
			
			System.out.println("Matched || " + " Expected Customer type should  removed in Gird : " + Remove_line + " || Actual Report Activity  Customer type is  removed in Gird : " + Remove_line);            
			Extent_pass_New(driver, "Matched || " + " Expected Customer type should  removed in Gird : " + Remove_line + " || Actual Report Activity  Customer type is  removed in Gird : " + Remove_line, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Customer type should  removed in Gird : " + Remove_line + " || Actual Report Activity  Customer type is not  removed in Gird : " + Remove_line);        
			Extent_fail(driver, "Not Matched || " + " Expected Customer type should  removed in Gird : " + Remove_line + " || Actual Report Activity  Customer type is not  removed in Gird : " + Remove_line, test,test1); 
			
		} 
		
		Step_End(15, ".Select the Additional Notifier 1 customer and click remove." , test, test1);
		Step_Start(16, "Click the confirm button in master tab & then save..", test, test1);
		waitForElement(driver, BL_Master);
		click(driver, BL_Master);
	
		waitForElement(driver, bl_confirm_btn);
		click(driver, bl_confirm_btn);
	
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(16, "Click the confirm button in master tab & then save..", test, test1);
	
		Step_Start(17, "System will validate for Equipment type mismatch.", test, test1);
		waitForPopup(driver, bl_mismatch_pop,bl_mismatch_pop_exp);
		String bl_mismatch_pop_act = getText(driver, bl_mismatch_pop);
		System.out.println(bl_mismatch_pop_act);
	
		if(bl_mismatch_pop_act.contains(bl_mismatch_pop_exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act, test,test1); 
			
		} 
		Step_End(17, "System will validate for Equipment type mismatch.", test, test1);
		waitForElement(driver, bl_mismatch_pop_close);
		click(driver, bl_mismatch_pop_close);
		Step_Start(18, "Entered the actual container in equipment id field and click edit button.", test, test1);
		waitForElement(driver, gird_edit);
		click(driver, gird_edit);
		waitForElement(driver, BL_equip_field);
	clearAndType(driver, BL_equip_field, Equipment_id_input);
	waitForElement(driver, BL_editbtn);
	click(driver, BL_editbtn);
	Step_End(18, "Entered the actual container in equipment id field and click edit button", test, test1);
	Step_Start(19, "Now system should validate for carrier Seal.", test, test1);
	
	if(isdisplayed(driver, popup_Message)) {
	waitForPopup(driver, popup_Message,carrier_pop_exp);
	String Reset_pop_act = getText(driver, popup_Message);
	System.out.println(Reset_pop_act);

	if(carrier_pop_exp.trim().contains(Reset_pop_act.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report popup is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report popup is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1); 
		
	} 
	Step_End(19, "Now system should validate for carrier Seal.", test, test1);
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver, popup_Message_Ok_Button);
	
	Step_Start(20, "Entered the carrier Seal and click edit.", test, test1);
	waitForElement(driver, carr_seal_input);
	clearAndType(driver, carr_seal_input, carr_seal_input_value);
	
	waitForElement(driver, BL_editbtn);
	click(driver, BL_editbtn);
	}
	Step_End(20, "Entered the carrier Seal and click edit.", test, test1);
	Step_Start(21, ".Then while save system validate to enter cargo weight.", test, test1);
	Step_Start(22, "Edit commodity and enter cargo weight then click on edit button.", test, test1);
	waitForElement(driver, SaveButton_ToolBar);
	click(driver, SaveButton_ToolBar);
	Step_End(21, ".Then while save system validate to enter cargo weight.", test, test1);
	Step_End(22, "Edit commodity and enter cargo weight then click on edit button.", test, test1);
	Step_Start(23, "Now system validate to enter all mandatory details in commodity tab ( enter valid commodity code,enter the commodity description,enter marks no.,enter the package)", test, test1);

	waitForPopup(driver, popup_Message,package_exp);
	String package_act = getText(driver, popup_Message);
	
	
	if(package_act.equals(package_exp)) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report popup is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp);            
		Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report popup is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp);        
		Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp, test,test1); 
		
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
		waitForPopup(driver, valid_commodity_pop,valid_comm_pop_exp);
	String valid_comm_pop_act = getText(driver, valid_commodity_pop);
	System.out.println(valid_comm_pop_act);

	if(valid_comm_pop_exp.trim().equals(valid_comm_pop_act.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report popup is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report popup is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report popup is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report popup is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report popup is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report popup is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report popup is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report popup is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report popup is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report popup is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
		
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
		System.out.println("Matched || " + " Expected Report popup is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report popup is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
		
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
	//	clear(driver, commodity_Cargo_Weight);
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
		
		waitForPopup(driver, popup_Message,Last_pop);
		String last = getText(driver, popup_Message);
		System.out.println(last);

		if(Last_pop.trim().contains(last.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report popup is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last);            
			Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report popup is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last);        
			Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last, test,test1); 
			
		} 
		Step_Start(27, ".Now click save button system validate to enter the Following mandatory charges.", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
	
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);
		Step_End(27, ".Now click save button system validate to enter the Following mandatory charges.", test, test1);
		Step_Start(28, "click on auto rate button, once charges pop up now click save button.", test, test1);
		waitForElement(driver, Auto_rate_button);
		click(driver, Auto_rate_button);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(28, "click on auto rate button, once charges pop up now click save button.", test, test1);
		Step_Start(29, ".Now system validate to enter the description of goods.", test, test1);
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);	
		Step_End(29, ".Now system validate to enter the description of goods.", test, test1);
		Step_Start(30, ".click on cargo summary button and click save.", test, test1);
		waitForElement(driver, cargo_summary);
		click(driver, cargo_summary);	
		Step_End(30, ".click on cargo summary button and click save.", test, test1);
		Step_Start(31, ".Now bl number should be generated and bl number indication should be in green color.  .", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		waitForPopup(driver, popup_Message,updated_pop_exp);
		String saved_pop_act1= getText(driver, popup_Message);
		System.out.println(saved_pop_act1);

		if(saved_pop_act1.contains(updated_pop_exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report popup is : " + saved_pop_act1 + " || Actual Report Activity  POPUP is : " + updated_pop_exp);            
			Extent_pass_New(driver, "Matched || " + " Expected Report popup is : " + saved_pop_act1 + " || Actual Report Activity  POPUP is : " + updated_pop_exp, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report popup is : " + saved_pop_act1 + " || Actual Report Activity  POPUP is : " + updated_pop_exp);        
			Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + saved_pop_act1 + " || Actual Report Activity  POPUP is : " + updated_pop_exp, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity  COLOUR is : " + bill_number_colour);            
			Extent_pass_New(driver, "Matched || " + " Expected Report COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity  COLOUR is : " + bill_number_colour, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity  COLOUR is : " + bill_number_colour);        
			Extent_fail(driver, "Not Matched || " + " Expected Report COLOUR is : " + booking_confirmed_Color + " || Actual Report Activity  COLOUR is : " + bill_number_colour, test,test1); 
			
		} 
		Step_End(31, ".Now bl number should be generated and bl number indication should be in green color.  .", test, test1);
		Extent_completed(testcase_Name, test, test1);
	

}}
