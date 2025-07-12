package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC046 extends Keywords{

	public void CRO_SC046(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		
		
	    String testCaseName="TC_CRO_SC046";
		
	    String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String pluginConfiguration_Module_Name = Excel_data.get("pluginConfiguration_Module_Name");
		String pluginID = Excel_data.get("pluginID");
		String plugin_Header = Excel_data.get("plugin_Header");
		String Serach_Condition = Excel_data.get("Serach_Condition");
		String PluginStatus = Excel_data.get("PluginStatus");
		String Release_Terminal_Header = Excel_data.get("Release_Terminal_Header");
		String Acceptance_Terminal_Header = Excel_data.get("Acceptance_Terminal_Header");
		String Release_Terminal_Input = Excel_data.get("Release_Terminal_Input");
		String Acceptance_Terminal_Input = Excel_data.get("Acceptance_Terminal_Input");
		String Agency_Special_Remarks = Excel_data.get("Agency_Special_Remarks");
		String Excepted_CRO_Saved_PopUp = Excel_data.get("Excepted_CRO_Saved_PopUp");
		
 
		Extent_Start(testCaseName, test, test1);
 
		navigateUrl(driver, url);
 

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
 

		SwitchProfile(driver, agencyUser);
 
		Step_Start(1, "Open plugin configuration module", test, test1);
		Step_Start(2, "Search CFT plugin and double click the record", test, test1);
		Step_Start(3, "Click edit button", test, test1);
		Step_Start(4, "Change status to True", test, test1);
		Step_Start(5, "Click save button", test, test1);
 
		setPluginConfig(driver, pluginConfiguration_Module_Name, plugin_Header, Serach_Condition, pluginID,
				PluginStatus);
		Step_End(1, "Open plugin configuration module", test, test1);
		Step_End(2, "Search CFT plugin and double click the record", test, test1);
		Step_End(3, "Click edit button", test, test1);
		Step_End(4, "Change status to True", test, test1);
		Step_End(5, "Click save button", test, test1);
 
 
		Step_Start(6, "Go to booking module and retrive the book number", test, test1);
 
		Confirmed_Booking_Creation createBooking = new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
		Step_End(6, "Go to booking module and retrive the book number", test, test1);
 
		Step_Start(7, "Navigate CRO from booking screen", test, test1);
	
 
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		Step_End(7, "Navigate CRO from booking screen", test, test1);
		Step_Start(8, "Click edit button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(8, "Click edit button", test, test1);
		Step_Start(9, "Select Release Depot/Terminal", test, test1);
 
		waitForElement(driver, Release_Terminal_SearchButton_CRO);
		click(driver, Release_Terminal_SearchButton_CRO);
		twoColumnSearchWindow(driver, Release_Terminal_Header, Serach_Condition, Release_Terminal_Input);
 
		Step_End(9, "Select Release Depot/Terminal", test, test1);
		Step_Start(10, "Select Acceptance Terminal", test, test1);
 
		waitForElement(driver, acceptance_Terminal_SearchButton_CRO);
		click(driver, acceptance_Terminal_SearchButton_CRO);
		twoColumnSearchWindow(driver, Acceptance_Terminal_Header, Serach_Condition, Acceptance_Terminal_Input);
		Step_End(10, "Select Acceptance Terminal", test, test1);
		
		Step_Start(11, "Add Agency & Special Remarks.", test, test1);
		
		waitForElement(driver, Agency_Special_Remarks_input);
		sendKeys(driver, Agency_Special_Remarks_input, Agency_Special_Remarks);
		
		Step_End(11, "Add Agency & Special Remarks.", test, test1);
		
		Step_Start(12, " Click save button", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		String Actual_Saved_Popup = getText(driver, Popup_Message);
		if (Excepted_CRO_Saved_PopUp.equals(Actual_Saved_Popup)) {
			System.out.println( "Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup);
			Extent_pass_New(driver, "Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup, test, test);
		} else {
			System.out.println( " Not Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup);
			Extent_fail(driver, " Not Matched ||  Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup, test, test);
		
		}
		
		Step_End(12, " Click save button", test, test1);
		
		Step_Start(13, "Click print button.", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver,Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		
		Step_Start(13, "Click print button.", test, test1);
		
		Step_Start(14, "Check Agency & Special Remarks in print.", test, test1);
		
		
		
		Step_End(14, "Check Agency & Special Remarks in print.", test, test1);
		
		Extent_completed(testCaseName, test, test1);
		
	}
}
