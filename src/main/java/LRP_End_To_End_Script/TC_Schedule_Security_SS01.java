package LRP_End_To_End_Script;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Schedule_Security_Locators;

public class TC_Schedule_Security_SS01  extends Keywords{

	public void Schedule_Security_SS01(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Schedule_Security_SS01";
		String search_module = Excel_data.get("Module_Search_Schedule_Security");
		String User_Group_Button = Excel_data.get("User_Group_Button");
		String User_Details_Header = Excel_data.get("User_Details_Header");
		String dropdownCondition = Excel_data.get("Condition");
		String Username_Input = Excel_data.get("Username");	
		String ServiceCode_Input = Excel_data.get("Service_Code_new");
		String Service_Code_header = Excel_data.get("Service_Code_header");	
		String VesselCode_Input = Excel_data.get("Add_Vessels");
		String Vessel_Code_Header = Excel_data.get("Vessel_Code_Header");
		String schedule_Security_Pop_Exp = Excel_data.get("schedule_Security_Pop_Exp");
		String Vessels_Select = Excel_data.get("Vessels_Select");
		String Read_Write_Button = Excel_data.get("Read_Write_Button");
		String schedule_Security_Btn_select=String.format(Schedule_Security_Locators.schedule_Security_Btn_Click, User_Group_Button);
		String schedule_Security_Vessels_Btn_select=String.format(Schedule_Security_Locators.schedule_Security_Btn_Click, Vessels_Select);
		String schedule_Security_Write_Btn_select=String.format(Schedule_Security_Locators.schedule_Security_Btn_Click, Read_Write_Button);

		Extent_Start(testcase_Name, test, test1);
		// Module search
		Step_Start(1, "  Click on the new button in the toolbar", test, test1);
		moduleNavigate(driver, search_module);
		newButton(driver);
		Step_End(1, "  Click on the new button in the toolbar", test, test1);
		Step_Start(2, "Click on the User Button.", test, test1);
		waitForElement(driver, schedule_Security_Btn_select);
		click(driver, schedule_Security_Btn_select);
		Step_End(2, "Click on the User Button.", test, test1);
		Step_Start(3, "Select the Username using  user name  search box.", test, test1);
		waitForElement(driver, schedule_Security_username_search_btn);
		click(driver, schedule_Security_username_search_btn);
		twoColumnSearchWindow(driver, User_Details_Header, dropdownCondition, Username_Input);
		Step_End(3, "Select the Username using  user name  search box.", test, test1);
		Step_Start(4, "Click on the Service Code Plus Button. ", test, test1);
		List<String> datas = splitAndExpand1(ServiceCode_Input);
		for (String data : datas) {
			waitForElement(driver, schedule_Security_Service_Code_Add);
			safeclick(driver, schedule_Security_Service_Code_Add);
			Step_End(4, "Click on the Service Code Plus Button. ", test, test1);
			Step_Start(5, "Service code details should be diplayed with checkbox options. ", test, test1);
			twoColumnSearchWindow(driver, Service_Code_header, dropdownCondition, data);
		}
		Step_End(6, "Select the Service code  from the Checkbox. ", test, test1);
		List<String> datas1 = splitAndExpand1(VesselCode_Input);
		for (String data : datas1) {
			Step_Start(7, "Click on the Vessel Code Plus Button.             ", test, test1);
			waitForElement(driver, schedule_Security_Vessel_Code_Add);
			safeclick(driver, schedule_Security_Vessel_Code_Add);
			Step_End(7, "Click on the Vessel Code Plus Button.             ", test, test1);
			Step_Start(8, "Vessel code details should be diplayed with checkbox options ", test, test1);
			twoColumnSearchWindow(driver, Vessel_Code_Header, dropdownCondition, data);
			Step_End(8, "Vessel code details should be diplayed with checkbox options ", test, test1);
			Step_Start(9, ".Select the Vessel Code from the  Checkbox.   ", test, test1);
			Step_End(9, ".Select the Vessel Code from the  Checkbox.   ", test, test1);
		}
		Step_Start(10, "Click on the Select  Vessel Button to give access for diplay. ", test, test1);
		waitForElement(driver, schedule_Security_Vessels_Btn_select);
		click(driver, schedule_Security_Vessels_Btn_select);
		Step_End(10, "Click on the Select  Vessel Button to give access for diplay. ", test, test1);
		Step_Start(11, "Click on the Write  Button to give access for modify. ", test, test1);
		waitForElement(driver, schedule_Security_Write_Btn_select);
		click(driver, schedule_Security_Write_Btn_select);
		Step_End(11, "Click on the Write  Button to give access for modify. ", test, test1);
		Step_Start(12, "Click on Save button from the toolbar ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(12, "Click on Save button from the toolbar ", test, test1);
		Step_Start(13, "System Should show the pop message says Schedule Security Saved", test, test1);
		waitForPopup(driver, popup_Message,schedule_Security_Pop_Exp);
		String schedule_Security_Pop_Act=getText(driver, popup_Message);
		if(schedule_Security_Pop_Exp.equals(schedule_Security_Pop_Act)) {
			Extent_pass_New(driver, "Matched || Expected : After click on save button Popup value should be display in the Schedule Security  Screen : "+schedule_Security_Pop_Exp+" || Actual Actual : After click on save button Popup value is display in the Schedule Security  Screen : "+schedule_Security_Pop_Act, test, test1);
			System.out.println("Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+schedule_Security_Pop_Exp+" || Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Security_Pop_Act);

			waitForElement(driver, popup_Message_Ok_Button);	
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched ||Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+schedule_Security_Pop_Exp+" || But the  Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Security_Pop_Act);
			Extent_fail(driver, "Not Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+schedule_Security_Pop_Exp+" || But the Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Security_Pop_Act, test, test1);
		}
		Step_End(13, "System Should show the pop message says Schedule Security Saved", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}