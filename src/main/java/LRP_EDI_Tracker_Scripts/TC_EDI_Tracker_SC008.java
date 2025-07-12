package LRP_EDI_Tracker_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Tracker_SC008 extends Keywords {
	public void EDI_Tracker_SC008(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_Excel_dataset,
			Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Tracker_SC008";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Direction = Excel_data.get("Direction");
		String Month = Excel_data.get("Month");
		String From_Date = Excel_data.get("From_Date");
		String Status = Excel_data.get("Status");
		String Ref_ID = Excel_data.get("Ref_ID");

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
		Step_Start(2, "Enter the RefID in the field ", test, test1);

		waitForElement(driver, From_Date_Input_Field_ET);
		click(driver, From_Date_Input_Field_ET);

		selectByText(driver, Select_Calender_Month_ET, Month);

		String date = String.format(Select_Calender_From_Date_ET, From_Date);
		click(driver, date);

		waitForElement(driver, To_Date_Input_Field_ET);
		click(driver, To_Date_Input_Field_ET);

		waitForElement(driver, Select_Calender_To_Date_ET);
		click(driver, Select_Calender_To_Date_ET);

		waitForElement(driver, Status_Dropdown_ET);
		click(driver, Status_Dropdown_ET);

		formatLocatorClick(driver, DropDown_Select, Status);

		waitForElement(driver, Reference_ID_Input_Field_ET);
		sendKeys(driver, Reference_ID_Input_Field_ET, Ref_ID);

		Step_End(2, "Enter the RefID in the field ", test, test1);

		Step_Start(3, "click the show button ", test, test1);

		waitForElement(driver, Show_Btn_ET);
		click(driver, Show_Btn_ET);

		waitForElement(driver, Select_First_Row_ET);

		Step_End(3, "click the show button ", test, test1);

		Step_Start(4, "Click the view file button  ", test, test1);

		click(driver, Select_First_Row_ET);

		waitForElement(driver, View_File_Btn_ET);
		click(driver, View_File_Btn_ET);

		Step_End(4, "Click the view file button", test, test1);

		Step_Start(5, "if file view pass this scenario otherwise fail  ", test, test1);

		waitForElement(driver, EDI_File_Details_Popup_ET);

		String Selected_Ref_ID = getText(driver, Reference_ID_Verify_ET);

		if (Selected_Ref_ID.equals(Ref_ID)) {
			System.out.println("Matched || " + " Expected Reference ID : " + Ref_ID + " || Actual Reference ID : "
					+ Selected_Ref_ID);
			Extent_pass_New(driver, "Matched || " + " Expected Reference ID : " + Ref_ID + " || Actual Reference ID : "
					+ Selected_Ref_ID, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Reference ID : " + Ref_ID + " || Actual Reference ID : "
					+ Selected_Ref_ID);
			Extent_fail(driver, "Not Matched || " + " Expected Reference ID : " + Ref_ID + " || Actual Reference ID : "
					+ Selected_Ref_ID, test, test1);
		}

		if (isdisplayed(driver, FileDetails_ET)) {
			System.out.println(
					"Passed || Expected result : EDI File should have text || Actual result : EDI File Details have text");
			Extent_pass_New(driver,
					"Passed || Expected result : EDI File should have text || Actual result :  EDI File Details have text",
					test, test1);

		} else {
			System.out.println(
					"Failed || Expected result : EDI File should have text || Actual result :  EDI File Details is empty");
			Extent_fail(driver,
					"Failed || Expected result : EDI File should have text || Actual result :  EDI File Details is empty",
					test, test1);

		}

		Step_End(5, "if file view pass this scenario otherwise fail", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
