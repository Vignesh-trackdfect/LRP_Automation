package LRP_EDI_Tracker_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Tracker_SC007 extends Keywords {
	public void EDI_Tracker_SC007(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_Excel_dataset,
			Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Tracker_SC007";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Direction = Excel_data.get("Direction");
		String Start_Month = Excel_data.get("Start_Month");
		String Start_Date = Excel_data.get("Start_Date");
		String To_Month = Excel_data.get("To_Month");
		String To_Date = Excel_data.get("To_Date");
		String Status = Excel_data.get("Status");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the Direction as (OutBound)", test, test1);

		waitForElement(driver, Direction_dropdown_btn_click_ET);
		click(driver, Direction_dropdown_btn_click_ET);

		formatLocatorClick(driver, DropDown_Select, Direction);

		Step_End(1, "Select the Direction as (OutBound)", test, test1);
		Step_Start(2, "Select the from date (01/01/2025) and To date(21/04/2025) ", test, test1);

		waitForElement(driver, From_Date_Input_Field_ET);
		click(driver, From_Date_Input_Field_ET);

		waitForElement(driver, Select_Calender_Month_ET);
		selectByText(driver, Select_Calender_Month_ET, Start_Month);

		String FromDate = String.format(Select_Calender_From_Date_ET, Start_Date);
		click(driver, FromDate);

		waitForElement(driver, To_Date_Input_Field_ET);
		click(driver, To_Date_Input_Field_ET);

		waitForElement(driver, Select_Calender_Month_ET);
		selectByText(driver, Select_Calender_Month_ET, To_Month);

		String ToDate = String.format(Select_Calender_From_Date_ET, To_Date);
		click(driver, ToDate);

		Step_End(2, "Select the from date and To date", test, test1);

		Step_Start(3, "Select the status as ERROR", test, test1);

		waitForElement(driver, Status_Dropdown_ET);
		click(driver, Status_Dropdown_ET);

		formatLocatorClick(driver, DropDown_Select, Status);

		Step_End(3, "Select the status as ERROR", test, test1);

		Step_Start(4, "click the show button", test, test1);

		waitForElement(driver, Show_Btn_ET);
		click(driver, Show_Btn_ET);

		Step_End(4, "click the show button", test, test1);

		Step_Start(5, "select the first record from the AG Grid and Click the view error button", test, test1);

		Step_Start(6, "the Error details Pop-up is shown and the detail  is caputre in the report", test, test1);

		Step_Start(7, "record selection one by one and get the error records", test, test1);

		waitForElement(driver, Select_First_Row_ET);

		String totalCountText = getText(driver, Total_Count_ET);
		int totalSize = Integer.parseInt(totalCountText);

		for (int i = 0; i < totalSize; i++) {

			String gridrow = String.format(RefGrid_list_ET, i);

			waitForElement(driver, gridrow);
			mouseOverToElement(driver, gridrow);
			click(driver, gridrow);

			String refIDText = getText(driver, gridrow);
			System.out.println("Selected Reference ID : " + refIDText);

			String EDI_field = String.format(EDIGrid_list_ET, i);
			String ediIDText = getText(driver, EDI_field);
			System.out.println("Selected EDI ID : " + ediIDText);

			String PartnerID_field = String.format(PartnerIDGrid_list_ET, i);
			String partnerIDText = getText(driver, PartnerID_field);
			System.out.println("Selected Partner ID : " + partnerIDText);

			waitForElement(driver, EDI_Viewerror_Button);
			click(driver, EDI_Viewerror_Button);

			waitForElement(driver, Error_Details_ET);
			String error_detail = getText(driver, Error_Details_ET);

			if (!error_detail.isBlank() || !error_detail.isEmpty()) {

				System.out.println("The Error message for Reference Id : " + refIDText + ", EDI Id : " + ediIDText
						+ ", Partner ID : " + partnerIDText + " was : " + error_detail);
				Extent_pass_New(driver, "The Error message for Reference Id : " + refIDText + ", EDI Id : " + ediIDText
						+ ", Partner ID : " + partnerIDText + " was : " + error_detail, test, test1);

			} else {

				System.out.println("The Error message for Reference Id : " + refIDText + ", EDI Id : " + ediIDText
						+ ", Partner ID : " + partnerIDText + " was not displayed ");
				Extent_fail(driver, "The Error message for Reference Id : " + refIDText + ", EDI Id : " + ediIDText
						+ ", Partner ID : " + partnerIDText + " was not displayed", test, test1);

			}

			waitForElement(driver, Error_Close_ET);
			click(driver, Error_Close_ET);

		}

		Step_Start(7, "record selection one by one and get the error records", test, test1);

		Step_Start(6, "the Error details Pop-up is shown and the detail  is caputre in the report", test, test1);

		Step_Start(5, "select the first record from the AG Grid and Click the view error button", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
