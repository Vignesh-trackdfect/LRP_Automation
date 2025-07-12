package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC003 extends Keywords {

	public void PartBL_TC003(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC003";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Select_field = Excel_data.get("Select_field");
		String No_Of_parts_TextField = Excel_data.get("No_Of_parts_TextField");
		String Select_Package_popup = Excel_data.get("Select_Package_popup");
		String Assign_package_popup = Excel_data.get("Assign_package_popup");
		String Quantity_Text_Field = Excel_data.get("Quantity_Text_Field");
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

		Step_Start(4, "Enter the number of parts", test, test1);

		waitForElement(driver, PBL_No_Of_parts_Field);
		sendKeys(driver, PBL_No_Of_parts_Field, No_Of_parts_TextField);

		Step_End(4, "Enter the number of parts", test, test1);

		Step_Start(5, "Click the Create button.", test, test1);

		waitForElement(driver, PBL_Create_Btn);
		click(driver, PBL_Create_Btn);

		Step_End(5, "Click the Create button.", test, test1);

		Step_Start(6, "Select Move all charges to master", test, test1);

		waitForElement(driver, PBL_Move_All_Charges_Checkbox);
		click(driver, PBL_Move_All_Charges_Checkbox);

		Step_End(6, "Select Move all charges to master", test, test1);

		Step_Start(7, "Enter the quantity", test, test1);

		waitForElement(driver, PBL_Quantity_Field);
		sendKeys(driver, PBL_Quantity_Field, Quantity_Text_Field);

		Step_End(7, "Enter the quantity", test, test1);

		Step_Start(8, "Add the quantity using the (+) symbol", test, test1);

		waitForElement(driver, PBL_Weight_Add_Btn);
		click(driver, PBL_Weight_Add_Btn);

		Step_End(8, "Add the quantity using the (+) symbol", test, test1);

		Step_Start(9, "Click the Apply button..", test, test1);

		waitForElement(driver, PBL_Apply_Btn);
		click(driver, PBL_Apply_Btn);

		Step_End(9, "Click the Apply button.", test, test1);

		Step_Start(10, "Selected Packages assigned for this Part BL message shown.", test, test1);

		waitForPopup(driver, popup_Message, Select_Package_popup);
		String Actual_Select_Packages_Popup1 = getText(driver, popup_Message);
		System.out.println("Actual_Select_Packages_Popup  is :" + Actual_Select_Packages_Popup1);

		if (Select_Package_popup.equals(Actual_Select_Packages_Popup1)) {

			System.out.println("Matched || Excepted :Select Packages popup is :" + Select_Package_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Select_Packages_Popup1);
			Extent_pass_New(driver, "Matched || Excepted :Select Packages popup is :" + Select_Package_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Select_Packages_Popup1, test, test1);
		}

		else {
			System.out.println("NotMatched || Excepted :Select Packages popup is :" + Select_Package_popup
					+ "|| Actual :Select Packages popup is :" + Actual_Select_Packages_Popup1);
			Extent_fail(driver, "NotMatched || Excepted :Select Packages popup is :" + Select_Package_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Select_Packages_Popup1, test, test1);
		}

		Step_End(10, "Selected Packages assigned for this Part BL message shown.", test, test1);

		Step_Start(11, "Click the OK button.", test, test1);

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		Step_End(11, "Click the OK button.", test, test1);

		Step_Start(12, "Click save button..", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(12, "Click save button.", test, test1);

		Step_Start(13, "Assign packages for this Part BL - PARTBL-1\" message shown.", test, test1);

		waitForPopup(driver, popup_Message, Assign_package_popup);
		String Actual_Assign_package_popup = getText(driver, popup_Message);
		System.out.println("Actual_Select_Packages_Popup  is :" + Actual_Assign_package_popup);

		if (Assign_package_popup.equals(Actual_Assign_package_popup)) {

			System.out.println("Matched || Excepted :Select Packages popup is :" + Assign_package_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Assign_package_popup);
			Extent_pass_New(driver, "Matched || Excepted :Select Packages popup is :" + Assign_package_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Assign_package_popup, test, test1);
		}

		else {
			System.out.println("NotMatched || Excepted :Select Packages popup is :" + Assign_package_popup
					+ "|| Actual :Select Packages popup is :" + Actual_Assign_package_popup);
			Extent_fail(driver, "NotMatched || Excepted :Select Packages popup is :" + Assign_package_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Assign_package_popup, test, test1);
		}

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		Step_End(13, "Assign packages for this Part BL - PARTBL-1\" message shown.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
