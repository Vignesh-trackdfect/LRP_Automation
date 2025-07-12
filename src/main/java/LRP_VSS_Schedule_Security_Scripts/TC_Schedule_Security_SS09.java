package LRP_VSS_Schedule_Security_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Schedule_Security_Locators;

public class TC_Schedule_Security_SS09  extends Keywords{

	public void Schedule_Security_SS09(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Schedule_Security_SS09";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("Module_Search");
		String User_Group_Button = Excel_data.get("User_Group_Button");
		String Group_Input = Excel_data.get("Group_Input");
		String ServiceCode_Input = Excel_data.get("ServiceCode_Input");
		String Vessels_Select = Excel_data.get("Vessels_Select");
		String Read_Write_Button = Excel_data.get("Read_Write_Button");
		String schedule_Security_Pop_Exp = Excel_data.get("schedule_Security_Pop_Exp");
		String Service_Code_header = Excel_data.get("Service_Code_header");
		String dropdownCondition = Excel_data.get("dropdownCondition");
		String Group_Code_Header = Excel_data.get("Group_Code_Header");
		
		
		String schedule_Security_Btn_select=String.format(Schedule_Security_Locators.schedule_Security_Btn_Click, User_Group_Button);
		String schedule_Security_Vessels_Btn_select=String.format(Schedule_Security_Locators.schedule_Security_Btn_Click, Vessels_Select);
		String schedule_Security_Write_Btn_select=String.format(Schedule_Security_Locators.schedule_Security_Btn_Click, Read_Write_Button);
	
		
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
		Step_Start(3, "Select the Group Code using  Group Code  search box", test, test1);
		waitForElement(driver, schedule_Security_Group_Code_Add);
	     click(driver, schedule_Security_Group_Code_Add);
	     
		twoColumnSearchWindow(driver, Group_Code_Header, dropdownCondition, Group_Input);
		
		Step_End(3, "Select the Group Code using  Group Code  search box", test, test1);
		Step_Start(4, "Click on the Service Code Plus Button. ", test, test1);
		List<String> datas = splitAndExpand1(ServiceCode_Input);
		for (String data : datas) {
		
			waitForElement(driver, schedule_Security_Service_Code_Add);
			safeclick(driver, schedule_Security_Service_Code_Add);
			Step_End(4, "Click on the Service Code Plus Button. ", test, test1);
			Step_Start(5, "Service code details should be diplayed with checkbox options. ", test, test1);
			
			twoColumnSearchWindow(driver, Service_Code_header, dropdownCondition, data);
			
			Step_End(5, "Service code details should be diplayed with checkbox options. ", test, test1);
			Step_Start(6, "Select the Service code  from the Checkbox. ", test, test1);
			
		}

		Step_End(6, "Select the Service code  from the Checkbox. ", test, test1);
		Step_Start(7, "Click on the All Vessel Button to give access for diplay", test, test1);
		
		waitForElement(driver, schedule_Security_Vessels_Btn_select);
		click(driver, schedule_Security_Vessels_Btn_select);

		Step_End(7, "Click on the All Vessel Button to give access for diplay", test, test1);
		Step_Start(8, "Click on the Write  Button to give access for modify.", test, test1);

		waitForElement(driver, schedule_Security_Write_Btn_select);
		click(driver, schedule_Security_Write_Btn_select);
		
		Step_End(8, "Click on the Write  Button to give access for modify.", test, test1);
		Step_Start(9, "Click on Save button from the toolbar ", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(9, "Click on Save button from the toolbar ", test, test1);
		Step_Start(10, "Click on Save button from the toolbar ", test, test1);
		
		waitForPopup(driver, popup_Message,schedule_Security_Pop_Exp);
		String schedule_Security_Pop_Act=getText(driver, popup_Message);
		
		if(schedule_Security_Pop_Exp.equals(schedule_Security_Pop_Act)) {
			Extent_pass_New(driver, "Matched ||Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+schedule_Security_Pop_Exp+" || Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Security_Pop_Act, test, test1);
			System.out.println("Matched || Expected : After click on save button Popup value should be display in the Schedule Security Screen :"+schedule_Security_Pop_Exp+" || Actual : After click on save button Popup value is display in the Schedule Security Screen : "+schedule_Security_Pop_Act);
			waitForElement(driver, popup_Message_Ok_Button);	
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched ||Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+schedule_Security_Pop_Exp+" ||Actual : After click on save button Popup value is not display in the Schedule Security Screen : "+schedule_Security_Pop_Act);
			Extent_fail(driver, "Not Matched ||Expected : After click on save button Popup value should be display in the Schedule Security Screen : "+schedule_Security_Pop_Exp+" || Actual : After click on save button Popup value is not display in the Schedule Security Screen : "+schedule_Security_Pop_Act, test, test1);
		}
		Step_End(10, "Click on Save button from the toolbar ", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
