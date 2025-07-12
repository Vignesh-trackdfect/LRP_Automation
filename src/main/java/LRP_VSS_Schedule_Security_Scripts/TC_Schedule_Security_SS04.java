package LRP_VSS_Schedule_Security_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Schedule_Security_SS04 extends Keywords {
	
public void Schedule_Security_SS04(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Schedule_Security_SS04";
		
		


		
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("Module_Search");
		String User_Name = Excel_data.get("User_Name");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Access = Excel_data.get("Access");
		String User_Profile = Excel_data.get("User_Profile");
		String schedule_Security_Pop_Exp = Excel_data.get("schedule_Security_Pop_Exp");
		
		String schedule_Security_Pop_Delete = Excel_data.get("schedule_Security_Pop_Delete");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		
// Login
		
		LRP_Login(driver, Username, Password);
	
// Module search

		moduleNavigate(driver, search_module);
		
		newButton(driver);
		
		Step_Start(1, " Click on the Show All User/Group button in the toolbar", test, test1);
		waitForElement(driver, show_All_User_Group);
		click(driver, show_All_User_Group);
		Step_End(1, " Click on the Show All User/Group button in the toolbar", test, test1);
		Step_Start(2, "   System should diplay the All User/Group records in AgGrid Table.", test, test1);
		waitForElement(driver, schedule_Security_filter);
		click(driver, schedule_Security_filter);
		waitForElement(driver, schedule_Security_filter_click);
		click(driver, schedule_Security_filter_click);
		
		
		waitForElement(driver, schedule_Security_username_filter);
		sendKeys(driver, schedule_Security_username_filter, User_Name);
		waitForElement(driver, schedule_Security_servicecode_filter);
		sendKeys(driver, schedule_Security_servicecode_filter, Service_Code);
		waitForElement(driver, schedule_Security_vesselcode_filter);
		sendKeys(driver, schedule_Security_vesselcode_filter, Vessel_Code);
		waitForElement(driver, schedule_Security_access_filter);
		sendKeys(driver, schedule_Security_access_filter, Access);
		waitForElement(driver, schedule_Security_user_filter);
		sendKeys(driver, schedule_Security_user_filter, User_Profile);
		Step_End(2, "   System should diplay the All User/Group records in AgGrid Table.", test, test1);
		Step_Start(3, "  Double click on the saved record from the AgGrid table below", test, test1);
		waitForElement(driver, schedule_Security_gird_firstclick);
		doubleClick(driver, schedule_Security_gird_firstclick);
		Step_End(3, "  Double click on the saved record from the AgGrid table below", test, test1);
		Step_Start(4, "  Click on the Delete button from the toolbar.        ", test, test1);
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(4, "  Click on the Delete button from the toolbar.        ", test, test1);
		
		Step_Start(5, " System Should show the pop message says \"Do you want to delete the Schedule Security?\"                  ", test, test1);
		waitForPopup(driver, popup_Message,schedule_Security_Pop_Exp);
		String schedule_Security_Pop_Act=getText(driver, popup_Message);
	
		
		if(schedule_Security_Pop_Exp.equals(schedule_Security_Pop_Act)) {

			Extent_pass_New(driver, "Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen :"+schedule_Security_Pop_Exp+" || Actual : After click on save button Popup value is display in the Schedule Security Screen :"+schedule_Security_Pop_Act, test, test1);
			System.out.println("Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen :"+schedule_Security_Pop_Exp+" || Actual : After click on save button Popup value is display in the Schedule Security Screen :"+schedule_Security_Pop_Act);
			waitForElement(driver, popup_Message_Yes_Button);	
			click(driver, popup_Message_Yes_Button);
		}else {
			System.out.println("Not Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+schedule_Security_Pop_Exp+" || Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Security_Pop_Act);
			Extent_fail(driver, "Not Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+schedule_Security_Pop_Exp+" || Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Security_Pop_Act, test, test1);

		}
		Step_End(5, " System Should show the pop message says \"Do you want to delete the Schedule Security?\"                  ", test, test1);
		Step_End(6, " Click on Yes button on the Popup. ", test, test1);
		Step_Start(7, " System Should show the pop message says \"Schedule Security deleted\". ", test, test1);
		waitForPopup(driver, popup_Message,schedule_Security_Pop_Delete);
		String schedule_Security_Pop_Act1=getText(driver, popup_Message);
		if(schedule_Security_Pop_Delete.equals(schedule_Security_Pop_Act1)) {

			Extent_pass_New(driver, "Matched ||Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+schedule_Security_Pop_Delete+" || Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Security_Pop_Act1, test, test1);
			System.out.println("Matched ||Expected : After click on save button Popup value should be display in the Schedule Security Screen :"+schedule_Security_Pop_Delete+" || Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Security_Pop_Act1);
			waitForElement(driver, popup_Message_Ok_Button);	
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen :"+schedule_Security_Pop_Delete+" || Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Security_Pop_Act1);
			Extent_fail(driver, "Not Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+schedule_Security_Pop_Delete+" || Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Security_Pop_Act1, test, test1);

		}
		Step_End(7, " System Should show the pop message says \"Schedule Security deleted\". ", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
		
		
		
		
}}
