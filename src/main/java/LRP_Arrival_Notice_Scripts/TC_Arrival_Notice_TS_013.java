package LRP_Arrival_Notice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_013  extends Keywords{
	
	public void Arrival_Notice_TS_013(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Arrival_Notice_TS_013";
		
		
		


		
		
		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String Field_Names =Excel_data.get("Arrival_Module_Search");
		String equal_select =Excel_data.get("equal_select");
		String customer_select =Excel_data.get("customer_select");
		String Customer_Code =Excel_data.get("Customer_Code");
		String BL_Number_box =Excel_data.get("BL_Number_box");
		String saved_pop_exp =Excel_data.get("saved_pop_exp");
		String Delete_Perform = Excel_data.get("Delete_Perform");
	
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, username, pass_word);

		//Switch User
		Step_Start(1, " Switch the agency", test, test1);
		
		SwitchProfile(driver, agencyUser);

		Step_End(1, " Switch the agency", test, test1);
		Step_Start(2, "Search the module name  ( \"Arrival Notice / Freight Memo\" ) in module search", test, test1);

		moduleNavigate(driver, Field_Names);

		Step_End(2, "Search the module name  ( \"Arrival Notice / Freight Memo\" ) in module search", test, test1);
		Step_Start(3, " Click the new button on tool bar", test, test1);
		newButton(driver);
		Step_End(3, " Click the new button on tool bar", test, test1);
		Step_Start(4, " Choose the option of customer option. ", test, test1);
		waitForElement(driver, by_customer_click);
		click(driver,by_customer_click);
		Step_End(4, " Choose the option of customer option. ", test, test1);
		waitForElement(driver, by_customer_search);
		click(driver,by_customer_search);
	
	
		Step_Start(5, " Enter the valid customer code ", test, test1);
		globalValueSearchWindow(driver, equal_select, customer_select, Customer_Code, "", "", "", "");
	
		Step_End(5, " Enter the valid customer code ", test, test1);
		Step_Start(6, " .Click the Show button ", test, test1);
		waitForElement(driver, by_customer_show);
		doubleClick(driver, by_customer_show);
		Step_End(6, " .Click the Show button ", test, test1);
		Step_Start(7, " Select the Multiple Bl numbers in below grid ", test, test1);
		List<String> datas = splitAndExpand(BL_Number_box);
		
		for(String data :datas) {
			String select_checkbox1 =  String.format(Arrival_Notice_Locators.bl_select_box,data); 
			
			waitForElement(driver, condition_Filter_AN);
			click(driver, condition_Filter_AN);
			waitForElement(driver, blNumber_Filter_AN);
			clear(driver, blNumber_Filter_AN);
			waitForElement(driver, blNumber_Filter_AN);
			sendKeys(driver, blNumber_Filter_AN, data);
			waitForElement(driver, blNumber_Filter_AN);
			waitForElement(driver, select_checkbox1);
			click(driver, select_checkbox1);
		}
		Step_End(7, " Select the Multiple Bl numbers in below grid ", test, test1);
		
		Step_Start(8, " Click edit button on tool bar  ", test, test1);
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		Step_End(8, " Click edit button on tool bar  ", test, test1);
		Step_Start(9, " .Click the save button on tool bar   ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		Step_End(9, " .Click the save button on tool bar   ", test, test1);
	
	
	
		waitForPopup(driver, Popup_Message, saved_pop_exp);                                                                                                                         
		String saved_pop_act=getText(driver, Popup_Message);    
		System.out.println(saved_pop_act);
		if(saved_pop_exp.equals(saved_pop_act)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + saved_pop_exp + " || Actual Report Activity is : " + saved_pop_act);            
			Extent_pass(driver, "Matched || " + " Expected Report Activity is : " + saved_pop_exp + " || Actual Report Activity is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + saved_pop_exp + " || Actual Report Activity is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + saved_pop_exp + " || Actual Report Activity is : " + saved_pop_act, test,test1); 
			
		} 
	
		Step_Start(10, "Click the saved Arrival notice bl and click Delete button ", test, test1);
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		waitForElement(driver, Delete_button_toolBar);
		click(driver,Delete_button_toolBar);
		Step_End(10, "Click the saved Arrival notice bl and click Delete button ", test, test1);
		Step_Start(11, "Click Yes and system validates Arrival notice deleted.", test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver,popup_Message_Yes_Button);
		}
		Step_End(11, "Click Yes and system validates Arrival notice deleted.", test, test1);
		
		Extent_completed(testcase_Name, test, test1);

}}
