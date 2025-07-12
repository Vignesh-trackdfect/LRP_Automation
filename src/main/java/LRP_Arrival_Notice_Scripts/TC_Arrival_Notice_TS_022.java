package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_022 extends Keywords {

	public void Arrival_Notice_TS_022(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name="TC_Arrival_Notice_TS_022";


		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String agencyUser =Excel_data.get("AgencyUser");
		String arrival_Module_Search =Excel_data.get("Arrival_Module_Search");
		String discharge_Service_Data =Excel_data.get("Discharge_Service_Data");
		String service_data =Excel_data.get("Service_data");
		String vessel =Excel_data.get("Vessel");
		String voyage =Excel_data.get("Voyage");
		String Delete_pop =Excel_data.get("Delete_pop");
		String delete_Popup_Expected = Excel_data.get("Delete_Popup_Expected").trim();
		String delete_Popup_Expected_2 = Excel_data.get("Delete_Popup_Expected_2").trim();



		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		// Login to the Application

		LRP_Login(driver, username, password);


		Extent_call(test, test1,"**Switch the Profile Start**");
		Step_Start(1, "Switch agency and open \"Arrival Notice / Freight Memo\" Module", test, test1);
		SwitchProfile(driver, agencyUser);

		Step_End(1, "Switch agency and open \"Arrival Notice / Freight Memo\" Module", test, test1);


	
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

		Step_Start(5, ".select the voyage and then show,", test, test1);
		waitForElement(driver, overlay_Box);
		sendKeys(driver, overlay_Service_Code_Txtfield, service_data);
		sendKeys(driver, overlay_Vessel_Code_Txtfield, vessel);
		sendKeys(driver, overlay_Voyage_Code_Txtfield, voyage);
		waitForElement(driver, Overlay_panel_First_Click);
		click(driver, Overlay_panel_First_Click);
		waitForElement(driver, Vessel_Select_Btn);
		click(driver, Vessel_Select_Btn);

		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		Step_End(5, ".select the voyage and then show,", test, test1);

		Step_Start(6, "Select the  all records by select all check box", test, test1);
		waitForElement(driver, select_All_Checkbox_An);
		click(driver, select_All_Checkbox_An);
		Step_End(6, "Select the  all records by select all check box", test, test1);


		Step_Start(7, "click delete button", test, test1);
		scrollTop(driver);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		waitForPopup(driver, popup_Message, delete_Popup_Expected);      
		String actual_Delete_Text = getText(driver, popup_Message);
		if (actual_Delete_Text.equals(delete_Popup_Expected)) {
			System.out.println("Matched || Expected  popup should be->" + delete_Popup_Expected + " Actual popup is : " + actual_Delete_Text);
			Extent_pass(driver, "Matched || Expected  popup should be->" + delete_Popup_Expected + " Actual popup is: " + actual_Delete_Text,
					test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		} else {

			System.out.println("Not Matched || Expected  popup should be->" + delete_Popup_Expected + " Actual popup is: " + actual_Delete_Text);
			Extent_fail(driver,"Not Matched || Expected  popup should be->" + delete_Popup_Expected + " Actual popup is: " + actual_Delete_Text, test,test1);
		}
		Step_End(7, "click delete button", test, test1);

		Step_Start(8, "Ensure that system shows the validation message \"  Do you want to delete the selected BL Number(s) ? \"", test, test1);
		waitForPopup(driver, delete_Popup1, delete_Popup_Expected_2);      
		String actual_Final_Popup = getText(driver, delete_Popup1);

		if (actual_Final_Popup.equals(delete_Popup_Expected_2)) {
			System.out.println("Matched || Expected popup should be->" + delete_Popup_Expected_2 + " Actual popup is: " + actual_Final_Popup);
			Extent_pass(driver, "Matched || Expected popup should be->" + delete_Popup_Expected_2 + " Actual popup is: " + actual_Final_Popup,
					test, test1);

			Step_Start(9, "yes_Final_Delete", test, test1);
			waitForElement(driver, yes_Final_Delete);
			click(driver, yes_Final_Delete);
			Step_End(9, "yes_Final_Delete", test, test1);

		} else {

			System.out.println(
					"Not Matched || Expected popup should be->" + delete_Popup_Expected_2 + " Actual popup is: " + actual_Final_Popup);
			Extent_fail(driver,
					"Not Matched || Expected popup should be->" + delete_Popup_Expected_2 + " Actual popup is: " + actual_Final_Popup, test,
					test1);
		}
		Step_End(8, "Ensure that system shows the validation message \"  Do you want to delete the selected BL Number(s) ? \"", test, test1);

		Step_Start(10, "Ensure  that saved arrival notice bls only deleted ", test, test1);
	
		Step_End(10, "Ensure  that saved arrival notice bls only deleted ", test, test1);
		waitForPopup(driver, Popup_Message, Delete_pop);
		String actual_Final_Popup1 = getText(driver, Popup_Message);
				if (actual_Final_Popup1.equals(Delete_pop)) {
			System.out.println("Matched || Expected popup->" + Delete_pop + " Actual popup : " + actual_Final_Popup1);
			Extent_pass(driver, "Matched || Expected popup->" + Delete_pop + " Actual popup: " + actual_Final_Popup1,
					test, test1);

		
		} else {

			System.out.println(
					"Not Matched || Expected popup->" + Delete_pop + " Actual popup: " + actual_Final_Popup1);
			Extent_fail(driver,
					"Not Matched || Expected popup->" + Delete_pop + " Actualpopup : " + actual_Final_Popup1, test,
					test1);
		}
		
		
		Extent_completed(tc_Name, test, test1);


	}

}
