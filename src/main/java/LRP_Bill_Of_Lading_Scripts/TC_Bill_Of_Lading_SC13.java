package LRP_Bill_Of_Lading_Scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Bill_Of_Lading_Locators;

public class TC_Bill_Of_Lading_SC13 extends Keywords {

	public void Bill_Of_Lading_SC13(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws IOException {
		String testcase_Name="TC_Bill_Of_Lading_SC13";
		
		
		



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
		String terminalCode = Excel_data.get("terminalCode");
		String portCode = Excel_data.get("portCode");
		String Boundinput = Excel_data.get("Boundinput");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String vesselCode = Excel_data.get("vesselCode");
		String Servicecode = Excel_data.get("Servicecode");
		String load_confirmation_popup = Excel_data.get("load_confirmation_popup");
		String Load_Confirmation_Module = Excel_data.get("Load_Confirmation_Module");
		String File_Name = Excel_data.get("File_Name");
		String BL_Original_Print_Colour = Excel_data.get("BL_Original_Print_Colour");
		String Commodity_group = Excel_data.get("Commodity_group");
		String Package_Quantity = Excel_data.get("Package_Quantity");
		String package_exp = Excel_data.get("Package_pop_expected");
		String BL_Number_Search = Excel_data.get("BL_Number_Search");









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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + bl_mismatch_pop_exp + " || Actual Report Activity  POPUP is : " + bl_mismatch_pop_act, test,test1); 

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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + carrier_pop_exp + " || Actual Report Activity  POPUP is : " + Reset_pop_act, test,test1); 

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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + package_act + " || Actual Report Activity  POPUP is : " + package_exp, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + valid_comm_pop_exp + " || Actual Report Activity  POPUP is : " + valid_comm_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + comm_dis_pop_exp + " || Actual Report Activity  POPUP is : " + comm_dis_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + marks_number_pop_exp + " || Actual Report Activity  POPUP is : " + marks_number_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + enter_commodity_pop_exp + " || Actual Report Activity  POPUP is : " + enter_commodity_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + enter_package_pop_exp + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + Commodity_group + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + Package_Quantity + " || Actual Report Activity  POPUP is : " + enter_package_pop_act, test,test1); 
			
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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + consignee_pop_exp + " || Actual Report Activity  POPUP is : " + consignee_pop_act, test,test1); 

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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + notify_pop_exp + " || Actual Report Activity  POPUP is : " + notify_pop_act, test,test1); 

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
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + saved_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + saved_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + saved_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + saved_pop_exp + " || Actual Report Activity  POPUP is : " + saved_pop_act, test,test1); 

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
			System.out.println("Matched || " + " Expected Report Activity colour  is : " + booking_confirmed_Color + " || Actual Report Activity colour is : " + bill_number_colour);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity colour is : " + booking_confirmed_Color + " || Actual Report Activity colour is : " + bill_number_colour, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity colour is : " + booking_confirmed_Color + " || Actual Report Activity colour is : " + bill_number_colour);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity colour is : " + booking_confirmed_Color + " || Actual Report Activity colour is : " + bill_number_colour, test,test1); 

		} 

		Step_End(4, "Edit the BL using tool bar & save the BL in confirmed status", test, test1);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		moduleNavigate(driver, Load_Confirmation_Module);

		
		
		waitForElement(driver, L_load_servicecode);
		sendKeys(driver, L_load_servicecode,Servicecode );
		
//	Select service
		
			waitForElement(driver, L_vessel_Input);
			sendKeys(driver, L_vessel_Input,vesselCode );
		
			
			waitForElement(driver, L_VoyageInput);
			sendKeys(driver, L_VoyageInput, Voyagenumber1);
			
			waitForElement(driver, L_Boundinpiut);
			sendKeys(driver, L_Boundinpiut, Boundinput);
			
			
			waitForElement(driver, L_portCode_Inputfield);
			sendKeys(driver, L_portCode_Inputfield, portCode);
			
			
			waitForElement(driver, L_terminalCode_Inputfield);
			sendKeys(driver, L_terminalCode_Inputfield, terminalCode);
			
			
			waitForElement(driver, L_select_Service);
			doubleClick(driver, L_select_Service);	
		


			
			waitForElement(driver, L_show_Button);
			click(driver, L_show_Button);
			

			

			
			waitForElement(driver, bookingnumber);

			click(driver, bookingnumber);
			sendKeys(driver, bookingnumber,book_Num);
		
		
		 waitForElement(driver, actual_containerno_1);
			click(driver, actual_containerno_1);

			Actionsendkeys(driver, actual_containerno_1, Equipment_id_input);
			

			waitForElement(driver, Checkbox_1);
			safeclick(driver, Checkbox_1);
			
			waitForElement(driver, L_loadConfirmation_Button);
			click(driver, L_loadConfirmation_Button);
			

			waitForPopup(driver, popup_Message,load_confirmation_popup);
			
			String loadconfimationpopupmessage = getText(driver, popup_Message);
			System.out.println(loadconfimationpopupmessage);
			
			if(loadconfimationpopupmessage.contains(load_confirmation_popup)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity  POPUP is : " + load_confirmation_popup);   
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity  POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity  POPUP is : " + load_confirmation_popup, test, test1);
			Extent_call(test, test1, loadconfimationpopupmessage);
			
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity  POPUP is : " + load_confirmation_popup);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity  POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity  POPUP is : " + load_confirmation_popup, test,test1); 
			} 
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			moduleNavigate(driver, bill_Of_Lading_Module);
			
			
			waitForElement(driver, search_Button_BL);
			safeclick(driver, search_Button_BL);
			
			globalValueSearchWindow(driver, condition, BL_Number_Search, bill_number, "", "", "", "");
			

            Step_Start(5, "Click the print button in master tab", test, test1);
            
			
			waitForElement(driver, print_Button_BL);
			click(driver, print_Button_BL);
			
           Step_End(5, "Click the print button in master tab", test, test1);

          Step_Start(6, "Select the BL Original radio button", test, test1);
			String BL_print_button = String.format(Bill_Of_Lading_Locators.bL_Print_Radio_Button, Bl_Radio_Button);
			waitForElement(driver, BL_print_button);
			click(driver, BL_print_button);
			
			Step_End(6, "Select the BL Original radio button", test, test1);
		//	checkBox(driver, signature_CheckBox, Signature);

              Step_Start(7, "Click the print button", test, test1);
			String filePath = downloadFile(driver, bl_Print_Popup_Print_Button);
			Step_End(7, "Click the print button", test, test1);
			
			String javawsPath = Excel_data.get("javaws_Path");

		    try {
		        // Validate javaws.exe
		        File javawsFile = new File(javawsPath);
		        if (!javawsFile.exists()) {
		            System.out.println("javaws.exe not found: " + javawsPath);
		            return;
		        }

		        // Validate JNLP file
		        File file = new File(filePath);
		        if (!file.exists()) {
		            System.out.println("JNLP file does not exist: " + filePath);
		            return;
		        }
				Step_Start(8, "System will launch JNLP", test, test1);

		        System.out.println("Launching JNLP file...");
		        ProcessBuilder processBuilder = new ProcessBuilder(javawsPath, filePath);
		        Process process = processBuilder.start();
		        Robot robo = new Robot();
		        System.out.println(".jnlp file launched successfully.");
		        
		        Step_End(8, "System will launch JNLP", test, test1);
		        
		        Step_Start(9, "Double click the BL No. in the JNLP, System will retreive the BL data in Print", test, test1);
		        wait(driver,"10");
		        Screen screen = new Screen();
		        Pattern runButton = new Pattern(System.getProperty("user.dir")+"/uploads/JNLP/run_Button.png").similar(0.7);
		        screen.wait(runButton, 5);
		        screen.click(runButton);
		        
		        Pattern startButton = new Pattern(System.getProperty("user.dir")+"/uploads/JNLP/Capture.png").similar(0.7);
		        screen.wait(startButton, 5);
		        screen.click(startButton);
		        
		        Step_Start(10, "Click the print button & save the PDF in local", test, test1);
		        Pattern printButton = new Pattern(System.getProperty("user.dir")+"/uploads/JNLP/Print_button.PNG").similar(0.7);
		        screen.wait(printButton, 10);
		        screen.click(printButton);
		        Step_End(10, "Click the print button & save the PDF in local", test, test1);
		        
		        wait(driver,"10");

		        screen.type(File_Name);

		        Step_End(9, "Double click the BL No. in the JNLP, System will retreive the BL data in Print", test, test1);
		        Pattern saveButton = new Pattern(System.getProperty("user.dir")+"/uploads/JNLP/save_Button.png").similar(0.7);
		        screen.wait(saveButton, 5);
		        screen.click(saveButton);
		        
		        wait(driver,"10");
		        robo.keyPress(KeyEvent.VK_ENTER);
		        robo.keyRelease(KeyEvent.VK_ENTER);
		        
		        wait(driver, "10");

		        // Close the JNLP process
		        System.out.println("Closing the JNLP file...");
		        process.destroy(); // Gracefully terminate the process
		        if (process.isAlive()) {
		            process.destroyForcibly(); // Force terminate if still running
		        }
		        System.out.println("JNLP process closed.");
		        
				
		        waitForElement(driver, search_Button_BL);
				safeclick(driver, search_Button_BL);
				globalValueSearchWindow(driver, condition, BL_Number_Search, bill_number, "", "", "", "");
			
				
				
				Step_Start(11, "Now BL will changed to issued status", test, test1);
				Step_Start(12, "BL No. indication should be changed in blue color", test, test1);
				
				waitForElement(driver, BL_Number_Field);
				String actual_MCN_Textfield_Color1=getTextBackgroundColor(driver, BL_Number_Field);
				String actual_MCN_Textfield_Color=getColorName(actual_MCN_Textfield_Color1);
				System.out.println(actual_MCN_Textfield_Color);
				if(actual_MCN_Textfield_Color.equalsIgnoreCase(BL_Original_Print_Colour)) {
					System.out.println("Matched || The background color of MCN Textfield is Blue || Expected MCN Textfield Color is : "+BL_Original_Print_Colour+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
					Extent_pass_New(driver, "Matched || The background color of MCN Textfield is Blue || Expected MCN Textfield Color is : "+BL_Original_Print_Colour+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
				}else {
					System.out.println("Not Matched || The background color of MCN Textfield is not Blue || Expected MCN Textfield Color is : "+BL_Original_Print_Colour+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
					Extent_fail(driver, "Not Matched || The background color of MCN Textfield is not Blue || Expected MCN Textfield Color is : "+BL_Original_Print_Colour+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
				}
		        
				Step_End(11, "Now BL will changed to issued status", test, test1);
				Step_End(12, "BL No. indication should be changed in blue color", test, test1);


		    } catch (Exception e) {
		        e.printStackTrace();
		        Extent_fail(driver, "File not found  "+ e.getLocalizedMessage(), test, test1);
		    }
		
		

		
	}
}
