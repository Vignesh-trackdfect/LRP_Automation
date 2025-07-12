package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
//import commonMethods.PartBL_Common_Creation;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC002 extends Keywords {
	public void PartBL_TC002(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC002";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Select_field = Excel_data.get("Select_field");
		String No_Of_parts_TextField = Excel_data.get("No_Of_parts_TextField");
		String NO_of_parts_popup = Excel_data.get("NO_of_parts_popup");
		String Agency_Name = Excel_data.get("Agency_Name");

		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the Part BL module", test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);
		
		PartBL_Common_Creation partBL_Data_Creation = new PartBL_Common_Creation();

		Map<String, String> BL_MCN_Numbers = partBL_Data_Creation.Common_PartBL(driver, test, test1, Excel_data);

		System.out.println("BL_Number:" + BL_MCN_Numbers.get("BL_Number"));

		String BLNumber = BL_MCN_Numbers.get("BL_Number");

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(1, "Open the Part BL module", test, test1);

		Step_Start(2, ".Click the Create button.", test, test1);

		newButton(driver);

		Step_End(2, ".Click the Create button.", test, test1);

		Step_Start(3, "Use the BL number search to retrieve the data.", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, Search_Condition, Select_field, BLNumber, "", "", "", "");

		Step_End(3, "Use the BL number search to retrieve the data.", test, test1);

		Step_Start(4, "Enter the number of parts 1", test, test1);

		waitForElement(driver, PBL_No_Of_parts_Field);
		sendKeys(driver, PBL_No_Of_parts_Field, No_Of_parts_TextField);

		Step_End(4, "Enter the number of parts 1", test, test1);

		Step_Start(5, "Click the Create button.", test, test1);

		waitForElement(driver, PBL_Create_Btn);
		click(driver, PBL_Create_Btn);

		Step_End(5, "Click the Create button.", test, test1);

		Step_Start(6, "No. of Splits should be greater than 1\" message shown..", test, test1);

		waitForPopup(driver, popup_Message, NO_of_parts_popup);
		String Actual_NO_of_part_Popup = getText(driver, popup_Message);
		System.out.println("Actual_Select_Packages_Popup  is :" + Actual_NO_of_part_Popup);

		if (NO_of_parts_popup.equals(Actual_NO_of_part_Popup)) {

			System.out.println("Matched || Excepted :Select Packages popup is :" + NO_of_parts_popup
					+ "|| Actual : Select Packages popup is :" + Actual_NO_of_part_Popup);
			Extent_pass_New(driver, "Matched || Excepted :Select Packages popup is :" + NO_of_parts_popup
					+ "|| Actual : Select Packages popup is :" + Actual_NO_of_part_Popup, test, test1);
		}

		else {
			System.out.println("Not Matched || Excepted :Select Packages popup is :" + NO_of_parts_popup
					+ "|| Actual :Select Packages popup is :" + Actual_NO_of_part_Popup);
			Extent_fail(driver, "Not Matched || Excepted :Select Packages popup is :" + NO_of_parts_popup
					+ "|| Actual : Select Packages popup is :" + Actual_NO_of_part_Popup, test, test1);

		}

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		Step_End(6, "No. of Splits should be greater than 1\" message shown..", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
