package LRP_Bill_Of_Lading_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Bill_Of_Lading_Locators;

public class TC_Bill_Of_Lading_SC07 extends Keywords{


	public void Bill_Of_Lading_SC07(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {



		String testcase_Name="TC_Bill_Of_Lading_SC07";
		
		
		 	



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
		String package_data = Excel_data.get("package_data");
		String quantity_data = Excel_data.get("quantity_data");
		String commodity_data = Excel_data.get("commodity_data");
		String search_by_commodity_code = Excel_data.get("search_by_commodity_code");
		String marks_no_data = Excel_data.get("marks_no_data");
		String headers_to_print = Excel_data.get("headers_to_print");
		String commodity_Cargo_Weight_input = Excel_data.get("commodity_Cargo_Weight_input");
		String bl_mismatch_pop_exp = Excel_data.get("bl_mismatch_pop_exp");
		String Equipment_id_input = Excel_data.get("Equipment_id_input");
		String carr_seal_input_value = Excel_data.get("carr_seal_input_value");
		String shipper_pop_exp = Excel_data.get("shipper_pop_exp");
		String Customer_type_input_CONSIGNEE = Excel_data.get("Customer_type_input_CONSIGNEE");
		String Customer_type_input = Excel_data.get("Customer_type_input");
		String customer_easy_search_input_notify = Excel_data.get("customer_easy_search_input_notify");
		String customer_easy_search_input = Excel_data.get("customer_easy_search_input");
		String customer_easy_search_input_consignee = Excel_data.get("customer_easy_search_input_consignee");
		String Customer_type_input_Notify = Excel_data.get("Customer_type_input_Notify");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Global_Book_num_search = Excel_data.get("Global_Book_num_search");
		String CRO_search = Excel_data.get("CRO_search");
		String CRO_search_condition = Excel_data.get("CRO_search_condition");
		


		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);




		Extent_call(test, test1,"**Switch the Profile Start**");

		//


		Step_Start(1, "Switch to agency", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, "Switch to agency", test, test1);

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

		waitForDisplay(driver, Rate_Grid);
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
			
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity POPUP  is : " + booking_draft_Color + " || The Actual Report Activity POPUP is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity POPUP  is : " + booking_draft_Color + " || The Actual Report Activity POPUP is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity POPUP  is : " + booking_draft_Color + " || The Actual Report Activity POPUP is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity POPUP  is : " + booking_draft_Color + " || The Actual Report Activity POPUP is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		} 


		Step_End(7, "Save the booking in Draft status", test, test1);

		Step_Start(8, "Edit the booking & select the container in container tab and click copy", test, test1);
		//
		waitForElement(driver, master_tab);
		click(driver, master_tab);

		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);

		waitForElement(driver, global_Editbtn);
		click(driver, global_Editbtn);

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


		//

		Step_End(8, "Edit the booking & select the container in container tab and click copy", test, test1);

		Step_Start(9, "Enter the no. of additional container in enter the rows column & click ok", test, test1);
		Step_End(9, "Enter the no. of additional container in enter the rows column & click ok", test, test1);

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
		
		

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, Global_Book_num_search, booknum, "", "", "", "");

	
		waitForElement(driver, bl_contacts_tab);

		waitForElement(driver, ready_BL);
		String readyBL_status=getAttribute(driver, ready_BL, "class");
		if(readyBL_status.contains(status)) {
			Extent_pass_New(driver,"Matched || Ready For Bl Check Box is Selected and the status is : "+readyBL_status, test, test1);
			System.out.println("Matched || Ready For Bl Check Box is Selected and the status is : "+readyBL_status); 
		}
		else {

			System.out.println("Not Matched || Ready For Bl Check Box is Not Selected and the status is : "+readyBL_status);
			Extent_fail(driver,"Not Matched || Ready For Bl Check Box is Not Selectedand the status is : "+readyBL_status, test, test1);
		}

		waitForElement(driver, ready_OP);
		String readyOP_status=getAttribute(driver, ready_OP, "class");
		if(readyOP_status.contains(status)) {
			Extent_pass_New(driver,"Matched || Ready For Operation Check Box is Selected and the status is : "+readyOP_status, test, test1);
			System.out.println("Matched || Ready For Operation Check Box is Selected and the status is : "+readyOP_status); 
		}
		else {
			System.out.println("Not Matched || Ready For Operation Check Box is Not Selected and the status is : "+readyOP_status);
			Extent_fail(driver,"Not Matched || Ready For Operation Check Box is Not Selected and the status is : "+readyOP_status, test, test1);
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

		waitForElement(driver, bl_Edit_Button);
		click(driver, bl_Edit_Button);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, bl_Edit_Button);
		click(driver, bl_Edit_Button);

		Step_End(16, "Edit the BL using tool bar & save the BL in draft status", test, test1);

		Step_Start(17, "Click the edit button in commodity grid", test, test1);

		waitForElement(driver, bl_commodity_tab);
		click(driver, bl_commodity_tab);

		waitForElement(driver, commodity_gird_edit);
		click(driver, commodity_gird_edit);


		waitForElement(driver, bl_package_txtfld);
		sendKeys(driver, bl_package_txtfld, package_data);
		waitForElement(driver, bl_package_panel_first_row);
		click(driver, bl_package_panel_first_row);

		Step_End(18, "By using easy search system allowed to select the package", test, test1);

		Step_Start(19, "Click the edit button in commodity grid system validate to enter the Valid Commodity Code, Commodity Description, Marks No, Commodity Code, Commodity Group", test, test1);

		Step_End(19, "Click the edit button in commodity grid system validate to enter the Valid Commodity Code, Commodity Description, Marks No, Commodity Code, Commodity Group", test, test1);

		waitForElement(driver, bl_quantity_txtfld);
		clear(driver, bl_quantity_txtfld);
		sendKeys(driver, bl_quantity_txtfld, quantity_data);

		Step_Start(20, "Select the Comdty.Grp. By using easy search", test, test1);

		Step_Start(21, "Select the HS Code by using easy search/entering % symbol in JDLC commodity", test, test1);
		waitForElement(driver, bl_hs_code_search_icon);
		click(driver, bl_hs_code_search_icon);
		
		globalValueSearchWindow(driver, dropdownCondition1, search_by_commodity_code,commodity_data, "", "", "", "");

	

		Step_End(21, "Select the HS Code by using easy search/entering % symbol in JDLC commodity", test, test1);

		

	
		Step_End(20, "Select the Comdty.Grp. By using easy search", test, test1);

		Step_Start(22, "Enter Marks No. manually", test, test1);

		waitForElement(driver, mark_number);
		sendKeys(driver, mark_number, marks_no_data);

		Step_End(22, "Enter Marks No. manually", test, test1);

		Step_Start(23, "Enter Commodity Desc. manually/click copy button", test, test1);

		waitForElement(driver, MCN_CargoWeight);
		clear(driver, MCN_CargoWeight);
		sendKeys(driver, MCN_CargoWeight, commodity_Cargo_Weight_input);

		waitForElement(driver, bl_copy_desc_button);
		click(driver, bl_copy_desc_button);

		Step_End(23, "Enter Commodity Desc. manually/click copy button", test, test1);

		List<Map<String, String>> table_before_click_add = getTableData(driver, bl_commodity_table_headers, bl_commodity_table_rows);

		List<String> headers=splitAndExpand(headers_to_print);

		String table_before = TableDataForReport(driver, table_before_click_add, "commodity table before", headers);

		Extent_pass_New(driver, table_before, test, test1);

		waitForElement(driver, bl_commodity_add_button);
		click(driver, bl_commodity_add_button);

		waitForElement(driver, bl_commodity_table_headers);
		List<Map<String, String>> table_after_click_add = getTableData(driver, bl_commodity_table_headers, bl_commodity_table_rows);


		String table_after = TableDataForReport(driver, table_after_click_add, "commodity table after", headers);

		Extent_pass_New(driver, table_after, test, test1);

		Step_Start(24, "Click the edit button in commodity grid system validate to enter the commodity weight", test, test1);

		Step_End(24, "Click the edit button in commodity grid system validate to enter the commodity weight", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_Start(25, "After entered commodity weight click the edit button in commodity grid system will set all the commodity details", test, test1);


		Step_End(25, "After entered commodity weight click the edit button in commodity grid system will set all the commodity details", test, test1);

		Step_Start(26, "Then confirm the BL", test, test1);

		waitForElement(driver, bl_master_tab);
		click(driver, bl_master_tab);

		waitForElement(driver, bl_confirm_btn);
		click(driver, bl_confirm_btn);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);


		waitForPopup(driver, bl_mismatch_pop,bl_mismatch_pop_exp);
		String bl_mismatch_pop_act = getText(driver, bl_mismatch_pop);
		System.out.println(bl_mismatch_pop_act);

		if(bl_mismatch_pop_act.trim().contains(bl_mismatch_pop_exp.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + bl_mismatch_pop_exp + " || Actual Report Activity POPUP is : " + bl_mismatch_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + bl_mismatch_pop_exp + " || Actual Report Activity POPUP is : " + bl_mismatch_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + bl_mismatch_pop_exp + " || Actual Report Activity POPUP is : " + bl_mismatch_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + bl_mismatch_pop_exp + " || Actual Report Activity POPUP is : " + bl_mismatch_pop_act, test,test1); 

		} 

		waitForElement(driver, bl_mismatch_pop_close);
		click(driver, bl_mismatch_pop_close);

		waitForElement(driver, gird_edit);
		click(driver, gird_edit);
		waitForElement(driver, BL_equip_field);
		clear(driver, BL_equip_field);
		sendKeys(driver, BL_equip_field, Equipment_id_input);
		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, carr_seal_input);
		clear(driver, carr_seal_input);
		sendKeys(driver, carr_seal_input, carr_seal_input_value);
		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, shipper_pop,shipper_pop_exp);
		String shipper_pop_act = getText(driver, shipper_pop);
		System.out.println(shipper_pop_act);

		if(shipper_pop_exp.trim().contains(shipper_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + shipper_pop_exp + " || Actual Report Activity POPUP is : " + shipper_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + shipper_pop_exp + " || Actual Report Activity POPUP is : " + shipper_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + shipper_pop_exp + " || Actual Report Activity POPUP is : " + shipper_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + shipper_pop_exp + " || Actual Report Activity POPUP is : " + shipper_pop_act, test,test1); 

		} 
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);

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

		waitForElement(driver, shipper_close);
		click(driver, shipper_close);

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

		waitForElement(driver, shipper_close);
		click(driver, shipper_close);

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

		waitForElement(driver, bl_autorate_Btn);
		click(driver, bl_autorate_Btn);

		waitForElement(driver, bl_charges_table_rows);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, shipper_close);
		click(driver, shipper_close);	

		waitForElement(driver, cargo_summary);
		click(driver, cargo_summary);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);


		waitForElement(driver, BL_no);
		String bill_number= getAttribute(driver, BL_no,"value");
		System.out.println(bill_number);
		Extent_call(test, test1, "****Bill number was generated as **"+bill_number);

		String bill_number_colour1= getTextBackgroundColor(driver, BL_no);
		System.out.println(bill_number_colour1);
		String bill_number_colour=getColorName(bill_number_colour1);

		




		if(booking_confirmed_Color.contains(bill_number_colour)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity Colour is : " + booking_confirmed_Color + " || Actual Report Activity Colour is : " + bill_number_colour);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  Colour is : " + booking_confirmed_Color + " || Actual Report Activity Colour is : " + bill_number_colour, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity Colour is : " + booking_confirmed_Color + " || Actual Report Activity Colour is : " + bill_number_colour);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity Colour  is : " + booking_confirmed_Color + " || Actual Report Activity Colour is : " + bill_number_colour, test,test1); 

		} 

		Step_End(26, "Then confirm the BL", test, test1);


		Extent_completed(testcase_Name, test, test1);










	}


}
