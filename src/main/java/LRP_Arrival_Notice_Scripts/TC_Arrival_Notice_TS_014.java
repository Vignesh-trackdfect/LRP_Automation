package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_014  extends Keywords {

	public void Arrival_Notice_TS_014(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Arrival_Notice_TS_014";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Search_Number = Excel_data.get("Search_Number");
		String BL_Num = Excel_data.get("BL_Num");
		String saved_pop_exp = Excel_data.get("saved_pop_exp");
		String Delete_Perform = Excel_data.get("Delete_Perform");



		String select_checkbox =  String.format(Arrival_Notice_Locators.bl_select_box,BL_Num); 


		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		Step_Start(1, "Select the agency  ", test, test1);
		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Select the agency  ", test, test1);
		Extent_call(test, test1, "********** Switch the Profile - End **********");	
		Extent_call(test, test1, "********** Enter Import Documentation Module **********");
		Step_Start(2, "Search the module name  \" Import documentation\"  in module search", test, test1);


		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(2, "Search the module name  \" Import documentation\"  in module search", test, test1);
		Step_Start(3, "Click the search button ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(3, "Click the search button ", test, test1);
		Step_Start(4, "Enter the Bl number and click search ", test, test1);


		globalValueSearchWindow(driver, BL_Condition, Search_Number, BL_Num, "", "", "", "");

		Step_End(4, "Enter the Bl number and click search ", test, test1);
		Step_Start(5, "select the Bl number from pop up window", test, test1);
		waitForElement(driver, AN_servicename);
		String service_name_import=getAttribute(driver, AN_servicename,"value");    
		System.out.println(service_name_import);
		String vessels_name_import=getText(driver, AN_vesselcode_Field);    
		System.out.println(vessels_name_import);
		String voyage_name_import=getText(driver, ANvoyagecode_Field);    
		System.out.println(voyage_name_import);
		String bound_name_import=getText(driver, AN_bound_Field);    
		System.out.println(bound_name_import);
		String portcode_name_import=getText(driver, AN_portcode_Field);    
		System.out.println(portcode_name_import);
		String terminal_name_import=getText(driver, AN_terminal_Code);    
		System.out.println(terminal_name_import);
		Step_End(5, "select the Bl number from pop up window", test, test1);
		Step_Start(6, "Click the \"Arrival Notice / Freight Memo\" button  ", test, test1);
		waitForElement(driver, AN_Arrival_notice_button);
		doubleClick(driver, AN_Arrival_notice_button);
		Step_End(6, "Click the \"Arrival Notice / Freight Memo\" button  ", test, test1);


		Step_Start(7, ".Ensure that system navigated to \"Arrival Notice / Freight Memo\" screen  ", test, test1);

		Step_Start(9, ".Select the displayed Bl number from the grid", test, test1);
		waitForElement(driver, by_customer_show);
		
		waitForElement(driver, condition_Filter_AN);
		click(driver, condition_Filter_AN);
		waitForElement(driver, blNumber_Filter_AN);
		sendKeys(driver, blNumber_Filter_AN, BL_Num);
		
		waitForElement(driver, select_checkbox);
		click(driver,select_checkbox);
		Step_Start(8, ".Click edit button on tool bar ", test, test1);
		Step_End(9, ".Select the displayed Bl number from the grid", test, test1);
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		Step_End(8, ".Click edit button on tool bar ", test, test1);
		Step_Start(10, ".Click the save button on tool bar ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);

		Step_End(10, ".Click the save button on tool bar ", test, test1);


		waitForPopup(driver, Popup_Message, saved_pop_exp);                                                                                                                   
		String saved_pop_act=getText(driver, Popup_Message);    
		System.out.println(saved_pop_act);
		if(saved_pop_exp.equals(saved_pop_act)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  POPUP is : " + saved_pop_exp + " || Actual Report Activity POPUP is : " + saved_pop_act);            
			Extent_pass(driver, "Matched || " + " Expected Report Activity  POPUPis : " + saved_pop_exp + " || Actual Report Activity POPUP is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity  POPUP is : " + saved_pop_exp + " || Actual Report Activity POPUP is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + saved_pop_exp + " || Actual Report Activity POPUP is : " + saved_pop_act, test,test1); 

		} 
		Step_End(7, ".Ensure that system navigated to \"Arrival Notice / Freight Memo\" screen  ", test, test1);
		Step_Start(11, "Open import documentation module  ", test, test1);
		Step_Start(12, "Check vessel,voyage, bound of respective Bl ", test, test1);
		Step_Start(13, "Verify respective vessel ,voyage, bound should be matched", test, test1);

		waitForElement(driver, discharge_Service_TF_AN);
		String service_name_notice=getAttribute(driver, discharge_Service_TF_AN,"value");    
		System.out.println(service_name_notice);
		String vessels_name_notice=getAttribute(driver, discharge_Vessel_TF_AN,"value");    
		System.out.println(vessels_name_notice);

		String voyage_name_notice=getAttribute(driver,discharge_Voyage_TF_AN,"value");    
		System.out.println(voyage_name_notice);
		String bound_name_notice=getAttribute(driver, Bound_notice,"value");    
		System.out.println(bound_name_notice);
		String portcode_name_notice=getAttribute(driver, portcode_notice,"value");    
		System.out.println(portcode_name_notice);
		String terminal_name_notice=getAttribute(driver, Terminal_notice,"value");    
		System.out.println(terminal_name_notice);

		Step_End(11, "Open import documentation module  ", test, test1);
		Step_End(12, "Check vessel,voyage, bound of respective Bl ", test, test1);
		Step_End(13, "Verify respective vessel ,voyage, bound should be matched", test, test1);

		Step_Start(14, "Click the saved Arrival notice bl and click Delete button", test, test1);
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
			waitForElement(driver, Delete_button_toolBar);
			click(driver,Delete_button_toolBar);
			Step_End(14, "Click the saved Arrival notice bl and click Delete button", test, test1);
			Step_Start(15, "Click Yes and system validates Arrival notice deleted.", test, test1);

			waitForElement(driver, by_customer_save_pop_delete_yes);
			click(driver,by_customer_save_pop_delete_yes);
		}
		Step_End(15, "Click Yes and system validates Arrival notice deleted.", test, test1);




		if(service_name_import.equals(service_name_notice)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity should be : " + service_name_import + " || Actual Report Activity is : " + service_name_notice);            
			Extent_pass(driver, "Matched || " + " Expected Report Activity should be : " + service_name_import + " || Actual Report Activity is : " + service_name_notice, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity should be : " + service_name_import + " || Actual Report Activity is : " + service_name_notice);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity should be : " + service_name_import + " || Actual Report Activity is : " + service_name_notice, test,test1); 

		} 

		if(vessels_name_import.equals(vessels_name_notice)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity should be: " + vessels_name_import + " || Actual Report Activity is : " + vessels_name_notice);            
			Extent_pass(driver, "Matched || " + " Expected Report Activity should be : " + vessels_name_import + " || Actual Report Activity is : " + vessels_name_notice, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity should be : " + vessels_name_import + " || Actual Report Activity is : " + vessels_name_notice);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity should be : " + vessels_name_import + " || Actual Report Activity is : " + vessels_name_notice, test,test1); 

		} 

		if(voyage_name_import.equals(voyage_name_notice)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity should be : " + voyage_name_import + " || Actual Report Activity is : " + voyage_name_notice);            
			Extent_pass(driver, "Matched || " + " Expected Report Activity should be : " + voyage_name_import + " || Actual Report Activity is : " + voyage_name_notice, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity should be : " + voyage_name_import + " || Actual Report Activity is : " + voyage_name_notice);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity should be : " + voyage_name_import + " || Actual Report Activity is : " + voyage_name_notice, test,test1); 

		} 


		if(bound_name_import.equals(bound_name_notice)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity should be: " + bound_name_import + " || Actual Report Activity is : " + bound_name_notice);            
			Extent_pass(driver, "Matched || " + " Expected Report Activity should be : " + bound_name_import + " || Actual Report Activity is : " + bound_name_notice, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity should be : " + bound_name_import + " || Actual Report Activity is : " + bound_name_notice);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity should be : " + bound_name_import + " || Actual Report Activity is : " + bound_name_notice, test,test1); 

		} 


		if(portcode_name_import.equals(portcode_name_notice)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity should be : " + portcode_name_import + " || Actual Report Activity is : " + portcode_name_notice);            
			Extent_pass(driver, "Matched || " + " Expected Report Activity should be: " + portcode_name_import + " || Actual Report Activity is : " + portcode_name_notice, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity should be : " + portcode_name_import + " || Actual Report Activity is : " + portcode_name_notice);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity should be : " + portcode_name_import + " || Actual Report Activity is : " + portcode_name_notice, test,test1); 

		} 

		if(terminal_name_import.equals(terminal_name_notice)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity should be : " + terminal_name_import + " || Actual Report Activity is : " + terminal_name_notice);            
			Extent_pass(driver, "Matched || " + " Expected Report Activity should be : " + terminal_name_import + " || Actual Report Activity is : " + terminal_name_notice, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity should be : " + terminal_name_import + " || Actual Report Activity is : " + terminal_name_notice);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity should be : " + terminal_name_import + " || Actual Report Activity is : " + terminal_name_notice, test,test1); 

		} 

		Extent_completed(testcase_Name, test, test1);

	}
}
