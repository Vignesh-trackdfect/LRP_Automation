package LRP_VSS_Schedule_Security_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Schedule_Security_Locators;

public class TC_Schedule_Security_SS05 extends Keywords{

	public void Schedule_Security_SS05(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Schedule_Security_SS05";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("Module_Search");
		String User_Group_Button = Excel_data.get("User_Group_Button");
		String Username_Input = Excel_data.get("Username_Input");
		String ServiceCode_Input = Excel_data.get("ServiceCode_Input");
		String Select_User_Popup = Excel_data.get("Select_User_Popup");
		String Select_Service_Popup = Excel_data.get("Select_Service_Popup");
		String Select_Vessel_Popup = Excel_data.get("Select_Vessel_Popup");
		String dropdownCondition = Excel_data.get("dropdownCondition");
		String User_Details_Header = Excel_data.get("User_Details_Header");
		String Service_Code_header = Excel_data.get("Service_Code_header");
		String schedule_Security_Btn_select=String.format(Schedule_Security_Locators.schedule_Security_Btn_Click, User_Group_Button);
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login
		LRP_Login(driver, Username, Password);
		// Module search
		Step_Start(1, "  Click on the new button in the toolbar", test, test1);
		moduleNavigate(driver, search_module);

		newButton(driver);
		
		Step_End(1, "  Click on the new button in the toolbar", test, test1);
		Step_Start(2, "Click on the User Button.", test, test1);
		waitForElement(driver, schedule_Security_Btn_select);
		click(driver, schedule_Security_Btn_select);
		Step_End(2, "Click on the User Button.", test, test1);
		Step_Start(3, "Click on Save button without selecting  the value in the User name", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(3, "System Should show the pop message says 'Select the User Name' ", test, test1);
		
		Step_Start(4, "System Should show the pop message says 'Select the User Name' ", test, test1);
		waitForPopup(driver, popup_Message,Select_User_Popup);
		
		String schedule_Pop_Act=getText(driver, popup_Message);
		if(Select_User_Popup.equals(schedule_Pop_Act)) {
			Extent_pass_New(driver, "Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+Select_User_Popup+" || Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Pop_Act, test, test1);
			System.out.println("Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+Select_User_Popup+" || Actual : After click on save button Popup value is display in the Schedule Security Screen :"+schedule_Pop_Act);
			waitForElement(driver, popup_Message_Ok_Button);	
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+Select_User_Popup+" || Actual : After click on save button Popup value is Not display in the Schedule Security Screen :"+schedule_Pop_Act);
			Extent_fail(driver, "Not Matched ||Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+Select_User_Popup+" || Actual : After click on save button Popup value is Not display in the Schedule Security Screen : "+schedule_Pop_Act, test, test1);
		}
		Step_Start(4, "System Should show the pop message says 'Select the User Name' ", test, test1);
		Step_Start(5, "Click on Save button without selecting  the value in the Service Code", test, test1);
		
		waitForElement(driver, schedule_Security_username_search_btn);
		click(driver, schedule_Security_username_search_btn);
		
		twoColumnSearchWindow(driver, User_Details_Header, dropdownCondition, Username_Input);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(5, "Click on Save button without selecting  the value in the Service Code", test, test1);
		Step_Start(6, "System Should show the pop message says 'Select the Service Code'", test, test1);
		waitForPopup(driver, popup_Message,Select_Service_Popup);
		schedule_Pop_Act=getText(driver, popup_Message);
		if(Select_Service_Popup.equals(schedule_Pop_Act)) {
			Extent_pass_New(driver, "Matched ||Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+Select_Service_Popup+" || Actual : After click on save button Popup value is display in the Schedule Security Screen :"+schedule_Pop_Act, test, test1);
			System.out.println("Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen :"+Select_Service_Popup+" || Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Pop_Act);
			waitForElement(driver, popup_Message_Ok_Button);	
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen :"+Select_Service_Popup+" || Actual : After click on save button Popup value is Not display in the Schedule Security Screen : "+schedule_Pop_Act);
			Extent_fail(driver, "Not Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen :"+Select_Service_Popup+" || Actual : After click on save button Popup value is Not display in the Schedule Security Screen :"+schedule_Pop_Act, test, test1);
		}
		Step_End(6, "System Should show the pop message says 'Select the Service Code'", test, test1);
		Step_Start(7, "Click on Save button without selecting  the value in the Vessel Code. ", test, test1);
		List<String> datas = splitAndExpand1(ServiceCode_Input);
		for (String data : datas) {
		
			waitForElement(driver, schedule_Security_Service_Code_Add);
			safeclick(driver, schedule_Security_Service_Code_Add);
			
			twoColumnSearchWindow(driver, Service_Code_header, dropdownCondition, data);

		}
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(7, "Click on Save button without selecting  the value in the Vessel Code. ", test, test1);
		Step_Start(8, "System Should show the pop message says 'Select the Vessel Code'", test, test1);
		waitForPopup(driver, popup_Message,Select_Vessel_Popup);
		schedule_Pop_Act=getText(driver, popup_Message);
		if(Select_Vessel_Popup.equals(schedule_Pop_Act)) {

			Extent_pass_New(driver, "Matched ||Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+Select_Vessel_Popup+" ||Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Pop_Act, test, test1);
			System.out.println("Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+Select_Vessel_Popup+" || Actual : After click on save button Popup value is display in the Schedule Security Screen :"+schedule_Pop_Act);
			waitForElement(driver, popup_Message_Ok_Button);	
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+Select_Vessel_Popup+" || Actual : After click on save button Popup value is Not display in the Schedule Security Screen : "+schedule_Pop_Act);
			Extent_fail(driver, "Not Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+Select_Vessel_Popup+" || Actual : After click on save button Popup value is Not display in the Schedule Security Screen :"+schedule_Pop_Act, test, test1);
		}
		Step_End(8, "System Should show the pop message says 'Select the Vessel Code'", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
