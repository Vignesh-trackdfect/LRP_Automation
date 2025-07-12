package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC012 extends Keywords {
	public void CRO_SC012(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_CRO_SC012";

		// Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String pluginConfiguration_Module_Name = Excel_data.get("pluginConfiguration_Module_Name");
		String pluginID = Excel_data.get("pluginID");
		String plugin_Header = Excel_data.get("plugin_Header");
		String PluginStatus = Excel_data.get("PluginStatus");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String Release_Terminal_Header = Excel_data.get("Release_Terminal_Header");
		String Acceptance_Terminal_Header = Excel_data.get("Acceptance_Terminal_Header");
		String Equi_Header = Excel_data.get("Equi_Header");
		String Excepted_CRO_Saved_PopUp = Excel_data.get("Excepted_CRO_Saved_PopUp");
		String Ports_Header = Excel_data.get("Ports_Header");
		String Ports_Input = Excel_data.get("Ports_Input");
		String Release_Terminal_Input = Excel_data.get("Release_Terminal_Input");
		String Acceptance_Terminal_Input = Excel_data.get("Acceptance_Terminal_Input");
		String Equi_Input = Excel_data.get("Equi_Input");
		String Serach_Condition = Excel_data.get("Serach_Condition");
		String Quantity_Value = Excel_data.get("Quantity_Value");
		
		
		
		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Enter the test URL", test, test1);
		
		navigateUrl(driver, url);
		
		Step_End(1, "Open the browser", test, test1);
		Step_End(2, "Enter the test URL", test, test1);
		Step_Start(3, "Enter valid Username & Password in respective text fields", test, test1);
		Step_Start(4, "Click on Login Button", test, test1);
// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Step_End(3, "Enter valid Username & Password in respective text fields", test, test1);
		Step_End(4, "Click on Login Button", test, test1);
		Step_Start(5, "Click on Switch profile button in home page", test, test1);
		Step_Start(6, "Enter Agency code in code search field & Click on Select button", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(5, "Click on Switch profile button in home page", test, test1);
		Step_End(6, "Enter Agency code in code search field & Click on Select button", test, test1);
		Step_Start(7, "Enter plugin configurationin 'Search Module' Search search box & Select the module", test, test1);
		Step_Start(8, "Search CBL plugin and double click the record", test, test1);
		Step_Start(9, "Click edit button", test, test1);
		Step_Start(10, "Change status to true and click save button", test, test1);
		Step_Start(11, "Updated successfully message shown", test, test1);

		 setPluginConfig( driver, pluginConfiguration_Module_Name,  plugin_Header,  Serach_Condition, pluginID,PluginStatus);
	
		Step_End(7, "Enter plugin configurationin 'Search Module' Search search box & Select the module", test, test1);
		Step_End(8, "Search CBL plugin and double click the record", test, test1);
		Step_End(9, "Click edit button", test, test1);
		Step_End(10, "Change status to true and click save button", test, test1);
		Step_End(11, "Updated successfully message shown", test, test1);
		
// CroModule		
		Step_Start(12, "Open the Container release order module", test, test1);
		moduleNavigate(driver, CRO_Module_Name);
	
		Step_End(12, "Open the Container release order module", test, test1);	
		Step_Start(13, "Check CRO without booking option", test, test1);
		waitForElement(driver, Cro_WithoutBooking_CheckBox);
		click(driver, Cro_WithoutBooking_CheckBox);
		
		Step_End(13, "Check CRO without booking option", test, test1);
		
		Step_Start(14, "Select PORT in port option", test, test1);
		waitForElement(driver,CRO_Ports_SearchButton_CRO);
		click(driver, CRO_Ports_SearchButton_CRO);
		twoColumnSearchWindow(driver, Ports_Header, Serach_Condition, Ports_Input);
		Step_End(14, "Select PORT in port option", test, test1);
		Step_Start(15, "Select Release Depot/Terminal", test, test1);
		
		waitForElement(driver,Release_Terminal_SearchButton_CRO);
		click(driver, Release_Terminal_SearchButton_CRO);
		twoColumnSearchWindow(driver, Release_Terminal_Header, Serach_Condition, Release_Terminal_Input);
		
		Step_End(15, "Select Release Depot/Terminal", test, test1);
		Step_Start(16, "Select Acceptance Terminal", test, test1);
		
		waitForElement(driver,acceptance_Terminal_SearchButton_CRO);
		click(driver, acceptance_Terminal_SearchButton_CRO);
		twoColumnSearchWindow(driver, Acceptance_Terminal_Header, Serach_Condition, Acceptance_Terminal_Input);
		Step_End(16, "Select Acceptance Terminal", test, test1);
		
		Step_Start(17, "Select equipment profile by using by type option", test, test1);
		
		waitForElement(driver,Equipment_SearchButton_CRO);
		click(driver, Equipment_SearchButton_CRO);
		twoColumnSearchWindow(driver, Equi_Header, Serach_Condition, Equi_Input);
		Step_End(17, "Select equipment profile by using by type option", test, test1);
		
		Step_Start(18, "Enter quantity", test, test1);
		
		waitForElement(driver, Quantity_TF_CRO);
		sendKeys(driver, Quantity_TF_CRO, Quantity_Value);
		Step_End(18, "Enter quantity", test, test1);
		Step_Start(19, "Click add button", test, test1);
		
		waitForElement(driver,Add_Button_CRO);
		click(driver, Add_Button_CRO);
		
		Step_End(19, "Click add button", test, test1);
		
		Step_End(20, "Click save button", test, test1);
		
		waitForElement(driver,SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_Start(20, "Click save button", test, test1);
		Step_Start(21, "CRO is saved message shown", test, test1);
		waitForPopup(driver, Popup_Message, Excepted_CRO_Saved_PopUp);
		String Actual_Saved_Popup = getText(driver, Popup_Message);
		if (Excepted_CRO_Saved_PopUp.equals(Actual_Saved_Popup)) {
			System.out.println( "Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup); 
			Extent_pass_New(driver, "Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup, test, test);
		} else {
			System.out.println( " Not Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup); 
			Extent_fail(driver, " Not Matched ||  Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup, test, test);
		
		}
		waitForElement(driver, Release_number_Input);
		String CRO_Number = getAttribute(driver, Release_number_Input, "value");
		System.out.println( "The CRO Number is : " + CRO_Number);
		Step_End(21, "CRO is saved message shown", test, test1);
		Extent_completed(testCaseName, test, test1);
	}



}
