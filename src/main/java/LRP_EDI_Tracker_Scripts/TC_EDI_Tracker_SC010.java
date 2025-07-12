package LRP_EDI_Tracker_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Tracker_SC010 extends Keywords {
	public void EDI_Tracker_SC010(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_Excel_dataset,
			Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Tracker_SC010";
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
		String EDI_Tracker_Resend_Popup = Excel_data.get("EDI_Tracker_Resend_Popup");

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

		Step_End(2, "Select the from date (01/01/2025) and To date(21/04/2025)", test, test1);

		Step_Start(3, "select the status (Inprogess)", test, test1);

		waitForElement(driver, Status_Dropdown_ET);
		click(driver, Status_Dropdown_ET);

		formatLocatorClick(driver, DropDown_Select, Status);

		Step_End(3, "select the status (Inprogess)", test, test1);

		Step_Start(4, "click the show button", test, test1);

		waitForElement(driver, Show_Btn_ET);
		click(driver, Show_Btn_ET);

		Step_End(4, "click the show button", test, test1);

		Step_Start(5, "click the resend button one by one for all the records", test, test1);
		Step_Start(6, "print the request id and EDI name and partner id and agency for all the resend data", test,
				test1);

		waitForElement(driver, Select_First_Row_ET);

		String totalCountText = getText(driver, Total_Count_ET);
		int totalSize = Integer.parseInt(totalCountText);

		for (int i = 0; i < totalSize; i++) {

			waitForElement(driver, Row_Data_ET);
			click(driver, Row_Data_ET);

			String refIDText = getText(driver, ReferenceID_Column_ET);
			System.out.println("Selected Reference ID : " + refIDText);

			String ediIDText = getText(driver, EDI_ID_Column);
			System.out.println("Selected EDI ID : " + ediIDText);

			String partnerIDText = getText(driver, Partner_ID_ET);
			System.out.println("Selected Partner ID : " + partnerIDText);

			String agencyText = getText(driver, Agency_Column_ET);
			System.out.println("Selected Agency : " + agencyText);

			waitForElement(driver, Resent_Btn_ET);
			click(driver, Resent_Btn_ET);

			waitForPopup(driver, Popup_Message, EDI_Tracker_Resend_Popup);
			String Act_Popup = getText(driver, Popup_Message);
			System.out.println(Act_Popup);

			if (EDI_Tracker_Resend_Popup.equals(Act_Popup)) {

				System.out.println("The row which has Reference Id : " + refIDText + ", EDI Id : " + ediIDText
						+ ", Partner ID : " + partnerIDText + " and Agenct : " + agencyText + " has been resend");
				Extent_cal(test, test1, "The row which has Reference Id : " + refIDText + ", EDI Id : " + ediIDText
						+ ", Partner ID : " + partnerIDText + " and Agenct : " + agencyText + " has been resend");

				System.out.println("Matched || Expected EDI details updated popup : " + EDI_Tracker_Resend_Popup
						+ " || Actual : " + Act_Popup);
				Extent_pass_New(driver, "Matched || Expected EDI details updated popup: " + EDI_Tracker_Resend_Popup
						+ " || Actual: " + Act_Popup, test, test1);
			} else {

				Extent_fail(
						driver, "The row which has Reference Id : " + refIDText + ", EDI Id : " + ediIDText
								+ ", Partner ID : " + partnerIDText + " and Agenct : " + agencyText + " has not resend",
						test, test1);

				System.out.println("Not Matched || Expected EDI details updated popup : " + EDI_Tracker_Resend_Popup
						+ " || Actual : " + Act_Popup);
				Extent_fail(driver, "Not Matched || Expected EDI details updated popup : " + EDI_Tracker_Resend_Popup
						+ " || Actual: " + Act_Popup, test, test1);
			}

			for (int j = 0; j < 5; j++) {
				waitForElement(driver, Show_Btn_ET);
				click(driver, Show_Btn_ET);
			}

			waitForElement(driver, Grid_Filter_Btn_ET);
			click(driver, Grid_Filter_Btn_ET);

			waitForElement(driver, Reference_ID_Filter_Input_Field_ET);
			sendKeys(driver, Reference_ID_Filter_Input_Field_ET, refIDText);

			if (!isdisplayed(driver, Verify_Reference_ID_Value_ET)) {
				System.out.println(
						"Expected result : After Resend, reference ID should not present in the Data grid || Actual result : After Resend, reference ID is not present in the Data grid");
				Extent_pass_New(driver,
						"Expected result : After Resend, reference ID should not present in the Data grid || Actual result : After Resend, reference ID is not present in the Data grid",
						test, test1);
			} else {
				System.out.println(
						"Expected result : After Resend, reference ID should not present in the Data grid || Actual result : After Resend, reference ID is present in the Data grid");
				Extent_fail(driver,
						"Expected result : After Resend, reference ID should not present in the Data grid || Actual result : After Resend, reference ID is present in the Data grid",
						test, test1);
			}

			clear(driver, Reference_ID_Filter_Input_Field_ET);

		}

		Step_End(6, "print the request id and EDI name and partner id and agency for all the resend data", test, test1);
		Step_End(5, "click the resend button one by one for all the records", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
