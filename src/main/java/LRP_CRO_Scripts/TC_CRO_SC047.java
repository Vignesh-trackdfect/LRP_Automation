package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC047 extends Keywords{

	public void CRO_SC047(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_CRO_SC047";

		// Get data from excel sheet

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
		String Remark_text = Excel_data.get("Remark_text");
		String CRO_Popup_Exp = Excel_data.get("CRO_Popup_Exp");
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

//	Switch the ProfilepluginConfigurationModule
		SwitchProfile(driver, agencyUser);

		Step_Start(1, "Open plugin configuration module", test, test1);
		Step_Start(2, "Search CLR plugin", test, test1);
		Step_Start(3, "Set to False", test, test1);
		Step_Start(4, "Click save button", test, test1);
		Step_Start(5, " Updatted successfully message shown", test, test1);
		setPluginConfig(driver, pluginConfiguration_Module_Name, plugin_Header, Serach_Condition, pluginID,
				PluginStatus);
		Step_End(1, "Open plugin configuration module", test, test1);
		Step_End(2, "Search CLR plugin", test, test1);
		Step_End(3, "Set to False", test, test1);
		Step_End(4, "Click save button", test, test1);
		Step_End(5, " Updatted successfully message shown", test, test1);
		// booking

		Step_Start(6, "Go to Booking", test, test1);

		Confirmed_Booking_Creation createBooking = new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
		Step_End(6, "Go to Booking", test, test1);

		Step_Start(7, "Navigate CRO module", test, test1);
		// Create CRO

		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		Step_End(7, "Navigate CRO module", test, test1);
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

		Step_Start(11, "Add Operation / CRO Remark", test, test1);

		waitForElement(driver, Cro_Remarks_TextField);
		sendKeys(driver, Cro_Remarks_TextField,Remark_text);
		

		Step_End(11, "Add Operation / CRO Remark", test, test1);

		Step_Start(12, " Click save button.", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		String CRO_Popup_Act = getText(driver, Popup_Message);
		System.out.println(CRO_Popup_Act);
		if(CRO_Popup_Exp.equals(CRO_Popup_Act)) {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_pass_New(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}else {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_fail(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}
		Step_End(12, " Click save button.", test, test1);
		Step_Start(13, "Click print button.", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		
		Step_End(13, "Click print button.", test, test1);
		
		
	}
}
