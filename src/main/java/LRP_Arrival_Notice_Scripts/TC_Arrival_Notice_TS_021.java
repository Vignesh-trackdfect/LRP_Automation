package LRP_Arrival_Notice_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_021 extends Keywords {

	public void Arrival_Notice_TS_021(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name = "TC_Arrival_Notice_TS_021";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String arrival_Module_Search = Excel_data.get("Arrival_Module_Search");
		String discharge_Service_Data = Excel_data.get("Discharge_Service_Data");
		String service_data =Excel_data.get("Service_data");
		String vessel =Excel_data.get("Vessel");
		String voyage =Excel_data.get("Voyage");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String delete_Popup_Expected = Excel_data.get("Delete_Popup_Expected");
		String delete_Popup_Expected_2 = Excel_data.get("Delete_Popup_Expected_2");
	
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		// Login to the Application

		LRP_Login(driver, username, password);


		Extent_call(test, test1, "**Switch the Profile Start**");

		Step_Start(1, " Switch the agency ", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, " Switch the agency ", test, test1);


		moduleNavigate(driver, arrival_Module_Search);


		Step_Start(2, "Click on New Button", test, test1);
		
		newButton(driver);
	
		Step_End(2, "Click on New Button", test, test1);

		Step_Start(3, "Click by vessel option", test, test1);
		waitForElement(driver, by_Vessel_AN);
		click(driver, by_Vessel_AN);
		Step_End(3, "Click by vessel option", test, test1);

		Step_Start(4, "Enter the discharge service ", test, test1);
		waitForElement(driver, discharge_Srvce_Txtfld_AN);
		sendKeys(driver, discharge_Srvce_Txtfld_AN, discharge_Service_Data);
		Step_End(4, "Enter the discharge service ", test, test1);
		waitForElement(driver, overlay_Box);
		sendKeys(driver, overlay_Service_Code_Txtfield, service_data);
		sendKeys(driver, overlay_Vessel_Code_Txtfield, vessel);
		sendKeys(driver, overlay_Voyage_Code_Txtfield, voyage);
		waitForElement(driver, Overlay_panel_First_Click);
		click(driver, Overlay_panel_First_Click);
		waitForElement(driver, Vessel_Select_Btn);
		click(driver, Vessel_Select_Btn);
		Step_Start(5, "select the voyage and then show", test, test1);

		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		Step_End(5, "select the voyage and then show", test, test1);

		Step_Start(6, "Select the  all records by select all check box", test, test1);

		waitForElement(driver, select_All_Checkbox_An);
		click(driver, select_All_Checkbox_An);

		Step_End(6, "Select the  all records by select all check box", test, test1);

		Step_Start(7, "Click delete button ", test, test1);
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(7, "Click delete button ", test, test1);

		Step_Start(8, "Ensure that system shows the validation message \"  Do you want to delete the selected BL Number(s) ? \"", test, test1);
		waitForPopup(driver, popup_Message, delete_Popup_Expected);      
		String actual_Delete_Text = getText(driver, popup_Message);
		if (actual_Delete_Text.equals(delete_Popup_Expected)) {
			System.out.println("Matched || Expected  popup->" + delete_Popup_Expected + " Actual popup : " + actual_Delete_Text);
			Extent_pass(driver, "Matched || Expected popup->" + delete_Popup_Expected + " Actual popup: " + actual_Delete_Text,
					test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		} else {

			System.out
					.println("Not Matched || Expected popup ->" + delete_Popup_Expected + " Actual popup: " + actual_Delete_Text);
			Extent_fail(driver,
					"Not Matched || Expected popup ->" + delete_Popup_Expected + " Actual popup: " + actual_Delete_Text, test,
					test1);
		}
		Step_End(8, "Ensure that system shows the validation message \"  Do you want to delete the selected BL Number(s) ? \"", test, test1);

		
				
		
		Step_Start(9, "System should be displayed the arrival notice unsaved bls.", test, test1);
		waitForElement(driver, delete_Header);
		List<Map<String, String>> tableData = getTableData(driver, delete_Header, delete_Rows);
		
		
		waitForDisplay(driver, delete_Popup1);
		if(isDisplayed(driver, delete_Popup1)) {
		List<String> unsaved_Bls = getValuesByHeader(tableData, "BL/HBL Number");
		
		System.out.println("unsaved bl were shown are: "+unsaved_Bls);
		Extent_pass(driver,"unsaved bl were shown are: "+unsaved_Bls , test, test1);
		}else {
			System.out.println("unsaved bl were not shown");
			Extent_fail(driver,"unsaved bl were not shown", test, test1);
			
		}
		Step_End(9, "System should be displayed the arrival notice unsaved bls.", test, test1);


		
		}

		Extent_completed(tc_Name, test, test1);

	}

}
