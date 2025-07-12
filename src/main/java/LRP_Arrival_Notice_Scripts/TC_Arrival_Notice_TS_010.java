package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_010 extends Keywords{

	public void Arrival_Notice_TS_010(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {


		String tc_Name = "TC_Arrival_Notice_TS_010";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String arrival_Module_Search = Excel_data.get("Arrival_Module_Search");
		String discharge_Service_Data =Excel_data.get("Discharge_Service_Data");
		String service_data =Excel_data.get("Service_data");
		String vessel =Excel_data.get("Vessel");
		String voyage =Excel_data.get("Voyage");
		String bl_Number = Excel_data.get("Bl_Number");
		String saved_Popup_Expected =Excel_data.get("saved_Popup_Expected");
		String Delete_Perform =Excel_data.get("Delete_Perform");
		
	
		String click_checkbox_By_Bl_Num = String.format(Arrival_Notice_Locators.click_checkbox_By_Bl_Num, bl_Number);
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		// Login to the Application

		LRP_Login(driver, username, password);


		// Switch the Profile
		Extent_call(test, test1, "**Switch the Profile Start**");
		Step_Start(1, "Select the agency to save the 'Arrival Notice / Freight Memo'", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, "Select the agency to save the 'Arrival Notice / Freight Memo'", test, test1);

		Step_Start(2, "Search the module name ('Arrival Notice / Freight Memo') in module search", test, test1);


		moduleNavigate(driver, arrival_Module_Search);

		Step_End(2, "Search the module name ('Arrival Notice / Freight Memo') in module search", test, test1);


		Step_Start(3, "Click the new button on tool bar", test, test1);

		newButton(driver);
		Step_End(3, "Click the new button on tool bar", test, test1);

		Step_Start(4, "Choose the option of 'By vessel' option", test, test1);
		waitForElement(driver, by_Vessel_Button_AN);
		click(driver, by_Vessel_Button_AN);

		Step_End(4, "Choose the option of 'By vessel' option", test, test1);

		Step_Start(5, "Enter the valid Discharge service", test, test1);

		waitForElement(driver, discharge_Srvce_Txtfld_AN);
		sendKeys(driver, discharge_Srvce_Txtfld_AN, discharge_Service_Data);

		Step_End(5, "Enter the valid Discharge service", test, test1);

		Step_Start(6, "Choose the respective vessel and voyage details", test, test1);
		waitForElement(driver, overlay_Box);
		sendKeys(driver, overlay_Service_Code_Txtfield, service_data);
		sendKeys(driver, overlay_Vessel_Code_Txtfield, vessel);
		sendKeys(driver, overlay_Voyage_Code_Txtfield, voyage);
		waitForElement(driver, Overlay_panel_First_Click);
		click(driver, Overlay_panel_First_Click);
		waitForElement(driver, Vessel_Select_Btn);
		click(driver, Vessel_Select_Btn);
		Step_End(6, "Choose the respective vessel and voyage details", test, test1);

		Step_Start(7, "Click the Show button", test, test1);
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		Step_End(7, "Click the Show button", test, test1);

		Step_Start(8, "Select the displayed Bl number in below grid", test, test1);
		waitForElement(driver, click_checkbox_By_Bl_Num);
		click(driver, click_checkbox_By_Bl_Num);
		Step_End(8, "Select the displayed Bl number in below grid", test, test1);

		Step_Start(9, "Click edit button on tool bar ", test, test1);
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		Step_End(9, "Click edit button on tool bar ", test, test1);

		Step_Start(10, ".Click the save button on tool bar ", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(10, ".Click the save button on tool bar ", test, test1);

		Extent_call(test, test1, "Comparing the Saved popup ");

		waitForPopup(driver, Popup_Message, saved_Popup_Expected);
		String actual_Saved_Popup = getText(driver, Popup_Message);
		if(actual_Saved_Popup.equals(saved_Popup_Expected)) {
			System.out.println("Matched || Expected saved popup -> "+saved_Popup_Expected+" Actual saved popup -> "+actual_Saved_Popup);
			Extent_pass(driver, "Matched || Expected saved popup -> "+saved_Popup_Expected+" Actual saved popup -> "+actual_Saved_Popup, test, test1);
		}else {
			System.out.println("Not Matched ||  Expected saved popup -> "+saved_Popup_Expected +" Actual popup message -> "+ actual_Saved_Popup);
			Extent_fail(driver,"Not Matched ||  Expected saved popup -> "+saved_Popup_Expected +" Actual popup message -> "+ actual_Saved_Popup , test, test1);
		}

		if(Delete_Perform.equalsIgnoreCase("YES")) {
			Step_Start(11, "Click the saved Arrival notice BL and click Delete button", test, test1);
			scrollTop(driver);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(11, "Click the saved Arrival notice BL and click Delete button", test, test1);

			Step_Start(12, "Click Yes and system validates 'Arrival notice deleted'", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(12, "Click Yes and system validates 'Arrival notice deleted'", test, test1);
		}

		Extent_completed(tc_Name, test, test1);





	}

}
