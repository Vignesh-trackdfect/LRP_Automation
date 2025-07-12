package LRP_Arrival_Notice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_015  extends Keywords{

	public void Arrival_Notice_TS_015(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Arrival_Notice_TS_015";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition =Excel_data.get("BL_Condition");
		String Select_service = Excel_data.get("Select_service");
		String Select_service_input = Excel_data.get("Select_service_input");
		String Select_vessels = Excel_data.get("Select_vessels");
		String Select_vessels_input = Excel_data.get("Select_vessels_input");
		String Select_voyage = Excel_data.get("Select_voyage");
		String Select_voyage_input = Excel_data.get("Select_voyage_input");
		String BlNumber_search =Excel_data.get("BlNumber_search");
		String BL_Num = Excel_data.get("BL_Num");
		String BL_Number_box =Excel_data.get("BL_Number_box");
		String saved_pop_exp =Excel_data.get("saved_pop_exp");
		String Delete_Perform =Excel_data.get("Delete_Perform");



		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Switch the agency ", test, test1);
		Extent_call(test, test1, "********** Switch the Profile - End **********");	
		Extent_call(test, test1, "********** Enter Import Documentation Module **********");
		Step_Start(2, ". Search the module name  \" Import documentation \" in module search", test, test1);
		

		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(2, ". Search the module name  \" Import documentation \" in module search", test, test1);
		Step_Start(3, "Click the search button ", test, test1);
		click(driver, SearchButton_Toolbar);
		Step_End(3, "Click the search button ", test, test1);
		Step_Start(4, "Enter the respective service,vessel and voyage and click search ", test, test1);
		
		
		globalValueSearchWindow(driver, BL_Condition, Select_service, Select_service_input, Select_vessels,Select_vessels_input, Select_voyage,Select_voyage_input);
	
		Step_End(4, "Enter the respective service,vessel and voyage and click search ", test, test1);
	
		Step_Start(5, ".select the Bl number in shown window ", test, test1);
		waitForElement(driver, AN_BlNoSearchButton);
		click(driver, AN_BlNoSearchButton);
		
		twoColumnMultipleSearchWindow(driver, BlNumber_search, BL_Condition, BL_Num);
		

		Step_End(5, ".select the Bl number in shown window ", test, test1);


//	
//		waitForElement(driver, local_checkbox);
//		checkBox(driver, local_checkbox,Volume_select);
//
//		scrollTop(driver);
//
//		waitForElement(driver, save_bl);
//		click(driver, save_bl);
//
//

//		waitForPopup(driver, popup_Message, Volume_select_POP);      
//
//		String masterall_pop_act=getText(driver, popup_Message);    
//		System.out.println(masterall_pop_act);
//		if(Volume_select_POP.equals(masterall_pop_act)) {                                                                                                                  
//			System.out.println("Matched || " + " Expected Report Activity popup is : " + Volume_select_POP + " || Actual Report Activity popup is : " + masterall_pop_act);            
//			Extent_pass(driver, "Matched || " + " Expected Report Activity popup is : " + Volume_select_POP + " || Actual Report Activity popup is : " + masterall_pop_act, test,test1);     
//		}                                                                                                                                                                        
//		else {                                                                                                                                                                   
//			System.out.println("Not Matched || " + " Expected Report Activity popup is : " + Volume_select_POP + " || Actual Report Activity popup is : " + masterall_pop_act);        
//			Extent_fail(driver, "Not Matched || " + " Expected Report Activity popup is : " + Volume_select_POP + " || Actual Report Activity popup is : " + masterall_pop_act, test,test1); 
//		} 
//
//		waitForElement(driver, import_yes);
//		click(driver, import_yes);
//
//		waitForPopup(driver, popup_Message, SavedPopup);      
//		String ImportDocumentationSaved=getText(driver, popup_Message);
//		if (SavedPopup.equals(ImportDocumentationSaved)) {
//			System.out.println("Matched || Expected value POPUP  should be  : " + SavedPopup + " || Actual value POPUP is : " + ImportDocumentationSaved);
//			System.out.println("***Import Documentation Saved***");
//			Extent_pass(driver, "Matched || Expected value POPUP was : " + SavedPopup + " || Actual value  POPUP is : " + ImportDocumentationSaved, test,
//					test1);
//
//		} else {
//			System.out.println("NotMatched || Expected value POPUP should be: " + SavedPopup + " || Actual value POPUP is : " + ImportDocumentationSaved);
//			Extent_fail(driver, "NotMatched || Expected value POPUP should be : " + SavedPopup + " || Actual value POPUP is : " + ImportDocumentationSaved,
//					test, test1);
//
//		}
//		safeclick(driver, popup_Message_Ok_Button);

		Step_Start(6, ".Click the \"Arrival Notice / Freight Memo\" button ", test, test1);

		waitForElement(driver, AN_Arrival_notice_button);
		click(driver, AN_Arrival_notice_button);
		Step_End(6, ".Click the \"Arrival Notice / Freight Memo\" button ", test, test1);
		Step_Start(7, "Ensure that system navigated to \"Arrival Notice / Freight Memo\" screen ", test, test1);
		Step_Start(9, "Select the Multiple Bl numbers in grid", test, test1);
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
		Step_End(9, "Select the Multiple Bl numbers in grid", test, test1);
		Step_Start(8, "Click edit button on tool bar ", test, test1);
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		Step_End(8, "Click edit button on tool bar ", test, test1);
		Step_Start(10, "Click the save button on tool bar ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		Step_End(10, "Click the save button on tool bar ", test, test1);


		waitForPopup(driver, Popup_Message, saved_pop_exp);      
		waitForElement(driver, Popup_Message);                                                                                                                                
		String saved_pop_act=getText(driver, Popup_Message);    
		System.out.println(saved_pop_act);
		if(saved_pop_exp.equals(saved_pop_act)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report popup is : " + saved_pop_exp + " || Actual Report popup is : " + saved_pop_act);            
			Extent_pass(driver, "Matched || " + " Expected Report popup is : " + saved_pop_exp + " || Actual Report popup is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report popup is : " + saved_pop_exp + " || Actual Report popup is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report popup is : " + saved_pop_exp + " || Actual Report popup is : " + saved_pop_act, test,test1); 

		} 

		Step_End(7, "Ensure that system navigated to \"Arrival Notice / Freight Memo\" screen ", test, test1);
		Step_Start(11, ".Click the saved Arrival notice bl and click Delete button ", test, test1);
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		waitForElement(driver, Delete_button_toolBar);
		click(driver,Delete_button_toolBar);
		Step_End(11, ".Click the saved Arrival notice bl and click Delete button ", test, test1);
		Step_Start(12, "Click Yes and system validates Arrival notice deleted.", test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver,popup_Message_Yes_Button);
		}
		Step_End(12, "Click Yes and system validates Arrival notice deleted.", test, test1);
		Extent_completed(testcase_Name, test, test1);


	}
}
