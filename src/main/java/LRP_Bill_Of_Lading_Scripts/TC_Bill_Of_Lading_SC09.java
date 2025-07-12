package LRP_Bill_Of_Lading_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Bill_Of_Lading_Locators;
import locators.Booking_Locators;

public class TC_Bill_Of_Lading_SC09 extends Keywords {
	
	
public void Bill_Of_Lading_SC09(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Bill_Of_Lading_SC09";
		
		
		


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
		String CRO_search = Excel_data.get("CRO_search");
		String CRO_search_condition = Excel_data.get("CRO_search_condition");
		String Global_Book_num_search = Excel_data.get("Global_Book_num_search");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Rate_Module = Excel_data.get("Rate_Module");
		String Rate_search_option = Excel_data.get("Rate_search_option");
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
		String Saved_pop_draft = Excel_data.get("Saved_pop_draft");
		String Saved_pop_updated = Excel_data.get("Saved_pop_updated");
		String Commodity_group = Excel_data.get("Commodity_group");
		String Package_Quantity = Excel_data.get("Package_Quantity");
		String Unit = Excel_data.get("Unit");
		String package_exp = Excel_data.get("Package_pop_expected");
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
	
		Extent_call(test, test1,"**Switch the Profile Start**");

		
		//
		
		Step_Start(1, "Switch to agency", test, test1);
		
		SwitchProfile(driver, agencyUser);
		
		Step_End(1, "Switch to agency", test, test1);
		
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
		Step_Start(5, "Save the booking in Draft", test, test1);
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
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

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
			Extent_pass_New(driver,"Matched || Ready For Bl Check Box is Selected and the status is : "+readyBL_status, test, test1);
			System.out.println("Matched || Ready For Bl Check Box is Selected and the status is : "+readyBL_status); 
		}
		else {
			Extent_fail(driver,"Not Matched || Ready For Bl Check Box is Not Selected"+readyBL_status, test, test1);
			System.out.println("Not Matched || Ready For Bl Check Box is Not Selected"+readyBL_status);
		}

		waitForElement(driver, ready_OP);
		String readyOP_status=getAttribute(driver, ready_OP, "class").trim();
		if(readyOP_status.contains(status)) {
			Extent_pass_New(driver,"Matched || Ready For Operation Check Box is Selected and the status is : "+readyOP_status, test, test1);
			System.out.println("Matched || Ready For Operation Check Box is Selected and the status is : "+readyOP_status); 
		}
		else {
			Extent_fail(driver,"Not Matched || Ready For Operation Check Box is Not Selected"+readyOP_status, test, test1);
			System.out.println("Not Matched || Ready For Operation Check Box is Not Selected"+readyOP_status);
		}
		
		String Generated_Bl_Number = getAttribute(driver, booking_No_Txtfld, "value");
		
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);

	
		Step_Start(2, "Open the Bill of Lading module", test, test1);
		moduleNavigate(driver, bol_module);
	
		
		Step_End(2, "Open the Bill of Lading module", test, test1);
		
		Step_Start(3, "By using book no local search retrieve the data", test, test1);
		
		waitForElement(driver, book_Number_Search_Icon_Bl);
		click(driver, book_Number_Search_Icon_Bl);
		globalValueSearchWindow(driver, dropdownCondition1, Select_search_By_bl, Generated_Bl_Number, "", "", "", "");
		
		
		Step_End(3, "By using book no local search retrieve the data", test, test1);
		
		Step_Start(4, "Edit the BL using tool bar & save the BL in draft status", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_End(4, "Edit the BL using tool bar & save the BL in draft status", test, test1);
		
		Step_Start(5, "Click the auto rate button to fetch the OFR Charges", test, test1);
		
		waitForElement(driver, bl_charges_Tab);
		click(driver, bl_charges_Tab);
		
		waitForElement(driver, bl_autorate_btn);
		click(driver, bl_autorate_btn);
		
		scrollBottom(driver);
		List<String> charge_Codes = new ArrayList<String>();
		List<WebElement> charges_Value = listOfElements(driver, charges_value_BILL_OF_LADING);

		Step_Start(6, "Storing the charges value", test, test1);
		for(WebElement element :charges_Value) {
			String Charge_code = getText1(driver, element);
			if(!Charge_code.equalsIgnoreCase("OFR")) {
				charge_Codes.add(Charge_code);
			}
		}
		Step_End(6, "Storing the charges value", test, test1);

		Step_Start(7, "Comapring the values in the rate request module", test, test1);
		moduleNavigate(driver, Rate_Module);
		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		
		globalValueSearchWindow(driver, dropdownCondition1, Rate_search_option, rate_no, "", "", "", "");
		
		
		

		for (String charge_Code : charge_Codes) {

			String value1 =String.format(Booking_Locators.value1, charge_Code);

			waitForElement(driver, value1);
			if(isDisplayed(driver, value1)) {

				String actual_Charges =String.format(actual_Charges_RATE, charge_Code);
				String charge = getText(driver,actual_Charges);
				System.out.println("Matched || The Expected Charege Code From Booking Charges Tab : "+charge_Code+" || The Actual Charege Code  Value in Rate Requst Module Tab : "+charge);	
				Extent_pass_New(driver, "Matched || The Expected Charege Code From Booking Charges Tab : "+charge_Code+" || The Actual Charege Code  Value in Rate Requst Module Tab : "+charge, test, test1);
			}else {
				System.out.println("Not Matched || The Expected Charege Code From Booking Charges Tab : "+charge_Code+" The Charge Code is Not Available In Rate Request");
				Extent_fail(driver, "Not Matched || The Expected Charege Code From Booking Charges Tab : "+charge_Code+" The Charge Code is Not Available In Rate Request", test, test1);
			}

		}
		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
	
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
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver, bl_master_tab);
		click(driver, bl_master_tab);
		
		
		
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
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act, test,test1); 
			
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
	waitForPopup(driver, popup_Message,carrier_pop_exp);
	String Reset_pop_act = getText(driver, popup_Message);
	System.out.println(Reset_pop_act);

	if(carrier_pop_exp.trim().contains(Reset_pop_act.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1); 
		
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
	waitForElement(driver, unit_dd);
	click(driver, unit_dd);
	
	String unit_select_option = String.format(unit_dd_select, Unit);
	waitForElement(driver, unit_select_option);
	click(driver, unit_select_option);

	waitForElement(driver, bl_commodity_add_button);
	click(driver, bl_commodity_add_button);
	Step_End(19, ".Enter Quantity,package,commodity group,choose hs code,mark no and commodity desc the click edit button.", test, test1);
	
	Step_Start(20, ".Now click save button system validate to enter the Following mandatory charges.", test, test1);
	waitForPopup(driver, popup_Message,Last_pop);
	String last = getText(driver, popup_Message);
	System.out.println(last);

	if(Last_pop.trim().contains(last.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity POPUP is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + Last_pop + " || Actual Report Activity  POPUP is : " + last, test,test1); 
		
	} 
	Step_End(20, ".Now click save button system validate to enter the Following mandatory charges.", test, test1);
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver, popup_Message_Ok_Button);
	
	
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
		System.out.println("Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act, test,test1); 
		
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
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act, test,test1); 
			
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
		waitForElement(driver, Auto_rate_button);
		click(driver, Auto_rate_button);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(21, "click on auto rate button, once charges pop up now click save button.", test, test1);
		
		
		
		Step_Start(22, "Now system validate to enter ROE details.Note: If ROE details available then system will not validate) then it will move to 29th step.", test, test1);
		Step_Start(23, "Confirm the BL System will validate with \"Apply ROE\r\n"
				+ "\" message\" if any currency available without ROE.", test, test1);
		
		Step_Start(29, "Now system validate to enter the description of goods..", test, test1);
		if(isdisplayed(driver, shipper_close)) {
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);	
		Step_End(29, "Now system validate to enter the description of goods..", test, test1);
		}
		Step_Start(30, "click on cargo summary button and click save.", test, test1);
		if(isdisplayed(driver, cargo_summary)) {
		waitForElement(driver, cargo_summary);
		click(driver, cargo_summary);	
		
		Step_End(30, "click on cargo summary button and click save.", test, test1);
		Step_Start(31, "Now bl number should be generated and bl number indication should be in green color.  ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		waitForPopup(driver, popup_Message,Saved_pop_updated);
		String saved_pop_act1= getText(driver, popup_Message);
		System.out.println(saved_pop_act1);

		if(saved_pop_act1.contains(Saved_pop_updated)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_updated + " || Actual Report Activity  POPUP is : " + saved_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_updated + " || Actual Report Activity  POPUP is : " + saved_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_updated + " || Actual Report Activity  POPUP is : " + saved_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_updated + " || Actual Report Activity  POPUP is : " + saved_pop_act1, test,test1); 
			
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
			
			
			System.out.println("Matched || " + " Expected Report Activity  Colour is : " + booking_confirmed_Color + " || Actual Report Activity  Colour is : " + bill_number_colour);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  Colour is : " + booking_confirmed_Color + " || Actual Report Activity Colour is : " + bill_number_colour, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity Colour is : " + booking_confirmed_Color + " || Actual Report Activity Colour is : " + bill_number_colour);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity Colour is : " + booking_confirmed_Color + " || Actual Report Activity Colour is : " + bill_number_colour, test,test1); 
			
		} }
		Step_End(31, "Now bl number should be generated and bl number indication should be in green color.  ", test, test1);
		
		
		if(isdisplayed(driver, bl_mismatch_pop)) {
		waitForElement(driver, bl_mismatch_pop);
		String bl_mismatch_pop_act1 = getAttribute(driver, bl_mismatch_pop, "value");
		System.out.println(bl_mismatch_pop_act1);
	
		if(bl_mismatch_pop_exp.trim().contains(bl_mismatch_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act1, test,test1); 
			
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
	waitForElement(driver, popup_Message);
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
	
	waitForElement(driver, shipper_pop);
	String shipper_pop_act1 = getText(driver, shipper_pop);
	System.out.println(shipper_pop_act1);

	if(shipper_pop_exp.trim().contains(shipper_pop_act1.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity  POPUP is : " + shipper_pop_act1);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity  POPUP is : " + shipper_pop_act1, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity  POPUP is : " + shipper_pop_act1);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + shipper_pop_exp + " || Actual Report Activity  POPUP is : " + shipper_pop_act1, test,test1); 
		
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
	waitForElement(driver, consignee_pop);
	String consignee_pop_act1 = getText(driver, consignee_pop);
	System.out.println(consignee_pop_act1);

	if(consignee_pop_exp.trim().contains(consignee_pop_act1.trim())) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act1);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act1, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act1);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act1, test,test1); 
		
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
		waitForElement(driver, notify_pop);
		String notify_pop_act1 = getText(driver, notify_pop);
		System.out.println(notify_pop_act1);

		if(notify_pop_exp.trim().contains(notify_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act1, test,test1); 
			
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
			waitForElement(driver, cargo_pop);
			String cargo_pop_act1 = getText(driver, cargo_pop);
			System.out.println(cargo_pop_act1);

			if(cargo_pop_act1.trim().contains(cargo_pop_exp.trim())) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity POPUP is : " + cargo_pop_exp + " || Actual Report Activity  POPUP is : " + cargo_pop_act1);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + cargo_pop_exp + " || Actual Report Activity  POPUP is : " + cargo_pop_act1, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + cargo_pop_exp + " || Actual Report Activity  POPUP is : " + cargo_pop_act1);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + cargo_pop_exp + " || Actual Report Activity  POPUP is : " + cargo_pop_act1, test,test1); 
				
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
		waitForElement(driver, valid_commodity_pop);
		String valid_comm_pop_act1 = getText(driver, valid_commodity_pop);
		System.out.println(valid_comm_pop_act1);

		if(valid_comm_pop_exp.trim().equals(valid_comm_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act1, test,test1); 
			
		} 
		waitForElement(driver, valid_commodity_pop_ok);
		click(driver, valid_commodity_pop_ok);
	
		waitForElement(driver, commodity_discription_pop);
		String comm_dis_pop_act1 = getText(driver, commodity_discription_pop);
		System.out.println(comm_dis_pop_act1);

		if(comm_dis_pop_exp.trim().contains(comm_dis_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act1, test,test1); 
			
		} 
		waitForElement(driver, commodity_discription_pop_ok);
		click(driver, commodity_discription_pop_ok);	
		
		waitForElement(driver, marks_number_pop);
		String marks_number_pop_act1 = getText(driver, marks_number_pop);
		System.out.println(marks_number_pop_act1);

		if(marks_number_pop_exp.trim().contains(marks_number_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act1, test,test1); 
			
		} 
		waitForElement(driver, marks_number_pop_ok);
		click(driver, marks_number_pop_ok);	
		
		
		waitForElement(driver, enter_commodity_pop);
		String enter_commodity_pop_act1 = getText(driver, enter_commodity_pop);
		System.out.println(enter_commodity_pop_act1);

		if(enter_commodity_pop_exp.trim().contains(enter_commodity_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act1, test,test1); 
			
		} 
		waitForElement(driver, enter_commodity_pop_ok);
		click(driver, enter_commodity_pop_ok);	
		
		waitForElement(driver, enter_package_pop);
		String enter_package_pop_act1 = getText(driver, enter_package_pop);
		System.out.println(enter_package_pop_act1);

		if(enter_package_pop_exp.trim().contains(enter_package_pop_act1.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act1, test,test1); 
		}
		} 
		
		Step_End(18, "Now system validate to enter all mandatory details in commodity tab ( enter valid commodity code,enter the     commodity description,enter marks no.,enter the package)", test, test1);
		Step_Start(19, ".Enter Quantity,package,commodity group,choose hs code,mark no and commodity desc the click edit button.", test, test1);
	
		
		
		Step_Start(22, "Now system validate to enter ROE details.Note: If ROE details available then system will not validate) then it will move to 29th step.", test, test1);
		Step_Start(23, "Confirm the BL System will validate with \"Apply ROE\r\n"
				+ "\" message\" if any currency available without ROE.", test, test1);
		
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
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		waitForElement(driver, popup_Message);
		String saved_pop_act11= getText(driver, popup_Message);
		System.out.println(saved_pop_act11);

		if(saved_pop_act11.contains(Saved_pop_updated)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_updated + " || Actual Report Activity  POPUP is : " + saved_pop_act11);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_updated + " || Actual Report Activity  POPUP is : " + saved_pop_act11, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_updated + " || Actual Report Activity  POPUP is : " + saved_pop_act11);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + Saved_pop_updated + " || Actual Report Activity  POPUP is : " + saved_pop_act11, test,test1); 
			
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		
		waitForElement(driver, BL_no);
		String bill_number1= getAttribute(driver, BL_no,"value");
		System.out.println(bill_number1);
		Extent_call(test, test1, "****Bill number was generated as **"+bill_number1);
		
		String bill_number_colour= getTextBackgroundColor(driver, BL_no);
		String bill_number_colour1=getColorName(bill_number_colour);
		System.out.println(bill_number_colour1);
		
		
		
		
		
		if(booking_confirmed_Color.contains(bill_number_colour1)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity COLOUR is : " + booking_confirmed_Color + " || Actual Report COLOUR is : " + bill_number_colour1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity COLOUR is : " + booking_confirmed_Color + " || Actual Report COLOUR is : " + bill_number_colour1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity COLOUR is : " + booking_confirmed_Color + " || Actual Report COLOUR is : " + bill_number_colour1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity COLOUR is : " + booking_confirmed_Color + " || Actual Report COLOUR is : " + bill_number_colour1, test,test1); 
			
		} }
		Extent_completed(testcase_Name, test, test1);

	
		
}
}
