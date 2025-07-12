package LRP_Bill_Of_Lading_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Bill_Of_Lading_Locators;

public class TC_Bill_Of_Lading_SC15 extends Keywords {

	public void Bill_Of_Lading_SC15(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Bill_Of_Lading_SC15";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_User = Excel_data.get("Agency_User");
		String bill_Of_Lading_Module = Excel_data.get("bill_Of_Lading_Module");
		String globalsearch_BL = Excel_data.get("globalsearch_BL");
		String condition = Excel_data.get("condition");
		String book_Num = Excel_data.get("book_Num");
		String Bl_Radio_Button = Excel_data.get("Bl_Radio_Button");
		String bl_mismatch_pop_exp = Excel_data.get("bl_mismatch_pop_exp");
		String Equipment_id_input = Excel_data.get("Equipment_id_input");
		String carrier_pop_exp = Excel_data.get("carrier_pop_exp");
		String carr_seal_input_value = Excel_data.get("carr_seal_input_value");
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
		String saved_pop_exp = Excel_data.get("saved_pop_exp");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String non_Negotiable = Excel_data.get("non_Negotiable");
		String Commodity_group = Excel_data.get("Commodity_group");
		String Package_Quantity = Excel_data.get("Package_Quantity");
		String package_exp = Excel_data.get("Package_pop_expected");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);



		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, Agency_User);
		Step_End(1, "Switch to agency", test, test1);
		
	
		Step_Start(2, "Open the Bill of Lading module", test, test1);
		moduleNavigate(driver, bill_Of_Lading_Module);

		Step_End(2, "Open the Bill of Lading module", test, test1);

		
		Step_Start(3, "By using BL no global/Local search retrieve the data", test, test1);
		waitForElement(driver, bl_search_btn);
		safeclick(driver, bl_search_btn);

		globalValueSearchWindow(driver, condition, globalsearch_BL, book_Num, "", "", "", "");

		
		Step_End(3, "By using BL no global/Local search retrieve the data", test, test1);




		Step_Start(4, "Edit the BL using tool bar & save the BL in confirmed status", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, bl_confirm_btn);
		click(driver, bl_confirm_btn);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, bl_mismatch_pop,bl_mismatch_pop_exp);
		String bl_mismatch_pop_act = getText(driver, bl_mismatch_pop);
		System.out.println(bl_mismatch_pop_act);

		if(bl_mismatch_pop_act.trim().contains(bl_mismatch_pop_exp.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act, test,test1); 

		} 
		waitForElement(driver, bl_mismatch_pop_close);
		click(driver, bl_mismatch_pop_close);

		waitForElement(driver, gird_edit);
		click(driver, gird_edit);
		waitForElement(driver, BL_equip_field);
		clearAndType(driver, BL_equip_field, Equipment_id_input);
		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);


		waitForPopup(driver, popup_Message,carrier_pop_exp);
		String Reset_pop_act = getText(driver, popup_Message);
		System.out.println(Reset_pop_act);

		if(carrier_pop_exp.trim().contains(Reset_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1); 

		} 
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, carr_seal_input);
		clearAndType(driver, carr_seal_input, carr_seal_input_value);
		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);


		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		
		
		waitForPopup(driver, popup_Message,package_exp);
		String package_act = getText(driver, popup_Message);
		
		
		if(package_act.equals(package_exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
			
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
		
		globalValueSearchWindow(driver, condition, Select_search_value_hs, HS_code_input_value, "", "", "", "");
	

		waitForElement(driver, mark_number);
		clearAndType(driver, mark_number, mark_number_input);	
		waitForElement(driver, commodity_dcse);
		clearAndType(driver, commodity_dcse, commodity_desc_input);	
		waitForElement(driver, MCN_CargoWeight);
		click(driver, MCN_CargoWeight);
		clearAndType(driver, MCN_CargoWeight, commodity_Cargo_Weight_input);
		click(driver, commodity_grp);
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


		waitForPopup(driver, consignee_pop,consignee_pop_exp);
		String consignee_pop_act = getText(driver, consignee_pop);
		System.out.println(consignee_pop_act);

		if(consignee_pop_exp.trim().equals(consignee_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act, test,test1); 

		} 
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


		waitForPopup(driver, notify_pop,notify_pop_exp);
		String notify_pop_act = getText(driver, notify_pop);
		System.out.println(notify_pop_act);

		if(notify_pop_exp.trim().contains(notify_pop_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act, test,test1); 

		} 
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


	
		waitForElement(driver, Auto_rate_button);
		click(driver, Auto_rate_button);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForElement(driver, shipper_close);
		click(driver, shipper_close);	

		waitForElement(driver, cargo_summary);
		click(driver, cargo_summary);	


		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);


		waitForPopup(driver, popup_Message,saved_pop_exp);
		String saved_pop_act= getText(driver, popup_Message);
		System.out.println(saved_pop_act);

		if(saved_pop_act.contains(saved_pop_exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + saved_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP  is : " + saved_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity POPUP  is : " + saved_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + saved_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act, test,test1); 

		} 
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);


		waitForElement(driver, BL_no);
		String bill_number= getAttribute(driver, BL_no,"value");
		System.out.println(bill_number);
		Extent_call(test, test1, "****Bill number was generated as **"+bill_number);

		String bill_number_colourCode= getTextBackgroundColor(driver, BL_no);
		String bill_number_colour = getColorName(bill_number_colourCode);
		System.out.println(bill_number_colour);

		if(booking_confirmed_Color.equals(bill_number_colour)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity Colour is : " + booking_confirmed_Color + " || Actual Report Activity Colour is : " +bill_number_colour);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity Colour is : " + booking_confirmed_Color + " || Actual Report Activity Colour is : " +bill_number_colour, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity Colour is : " + booking_confirmed_Color + " || Actual Report Activity Colour is : " +bill_number_colour);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity Colour is : " + booking_confirmed_Color + " || Actual Report Activity Colour is : " +bill_number_colour, test,test1); 

		} 

		Step_End(4, "Edit the BL using tool bar & save the BL in confirmed status", test, test1);

            Step_Start(5, "Click the print button in master tab", test, test1);
            
			
			waitForElement(driver, print_Button_BL);
			click(driver, print_Button_BL);
			
           Step_End(5, "Click the print button in master tab", test, test1);
		Step_Start(6, "Select the BL draft radio button", test, test1);
		String BL_print_button = String.format(Bill_Of_Lading_Locators.bL_Print_Radio_Button, Bl_Radio_Button);
		waitForElement(driver, BL_print_button);
		click(driver, BL_print_button);
		Step_End(6, "Select the BL draft radio button", test, test1);
		Step_Start(7, "Click the print button", test, test1);
		waitForElement(driver, bl_Print_Popup_Print_Button);
		click(driver, bl_Print_Popup_Print_Button);
		Step_End(7, "Click the print button", test, test1);
		Step_Start(8, "System will load the data in print", test, test1);
		switchToFrame(driver, jsp_Iframe);	
		scrollToElement(driver, pdf_Non_Negotiable);
		waitForElement(driver, pdf_Non_Negotiable);
		Step_End(8, "System will load the data in print", test, test1);
		Step_Start(9, "Capture whether the \"NON NEGOTIABLE\" text available", test, test1);
		String Non_Negotiable_Pdf_Value=getText(driver, pdf_Non_Negotiable) ;
		if(non_Negotiable.trim().equals(Non_Negotiable_Pdf_Value.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity value shown as is : " + non_Negotiable + " || Actual Report Activity value shown as is : " + Non_Negotiable_Pdf_Value);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity value shown as is : " + non_Negotiable + " || Actual Report Activity value shown as is : " + Non_Negotiable_Pdf_Value, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity value shown as is : " + non_Negotiable + " || Actual Report Activity value shown as is : " + Non_Negotiable_Pdf_Value);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity value shown as is : " + non_Negotiable + " || Actual Report Activity value shown as is : " + Non_Negotiable_Pdf_Value, test,test1); 
		} 
		Step_End(9, "Capture whether the \"NON NEGOTIABLE\" text available", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}