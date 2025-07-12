package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC007 extends Keywords {

	public void PartBL_TC007(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC007";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Global_BL_Search_Header = Excel_data.get("Global_BL_Search_Header");
		String Quatity_Text_Field = Excel_data.get("Quatity_Text_Field");
		String No_Of_parts_TextField = Excel_data.get("No_Of_parts_TextField");
		String Select_Package_popup = Excel_data.get("Select_Package_popup");
		String OverWrite_Container_Popup = Excel_data.get("OverWrite_Container_Popup");
		String eqpNo = Excel_data.get("Eqp_ID");

		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the Part BL module", test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

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

		globalValueSearchWindow(driver, Search_Condition1, Global_BL_Search_Header, BLNumber, "", "", "", "");

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
		sendKeys(driver, PBL_Quantity_Field, Quatity_Text_Field);

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
		String Actual_Select_Packages_Popup = getText(driver, popup_Message);
		System.out.println("Actual_Select_Packages_Popup  is :" + Actual_Select_Packages_Popup);

		if (Select_Package_popup.equals(Actual_Select_Packages_Popup)) {

			System.out.println("Matched || Excepted :Select Packages popup is :" + Select_Package_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Select_Packages_Popup);
			Extent_pass_New(driver, "Matched || Excepted :Select Packages popup is :" + Select_Package_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Select_Packages_Popup, test, test1);
		}

		else {
			System.out.println("NotMatched || Excepted :Select Packages popup is :" + Select_Package_popup
					+ "|| Actual :Select Packages popup is :" + Actual_Select_Packages_Popup);
			Extent_fail(driver, "NotMatched || Excepted :Select Packages popup is :" + Select_Package_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Select_Packages_Popup, test, test1);
		}

		Step_End(10, "Selected Packages assigned for this Part BL message shown.", test, test1);

		Step_Start(11, "Click the OK button.", test, test1);

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		Step_End(11, "Click the OK button.", test, test1);

		Step_Start(12, "Change the equipment id", test, test1);

		waitForElement(driver, PBL_Equipment_Dropdown);
		click(driver, PBL_Equipment_Dropdown);

		formatLocatorClick(driver, DropDown_Select, eqpNo);

		Step_End(12, "Change the equipment id", test, test1);

		Step_Start(13, "Enter the quantity", test, test1);

		waitForElement(driver, PBL_Quantity_Field);
		sendKeys(driver, PBL_Quantity_Field, Quatity_Text_Field);

		Step_End(13, "Enter the quantity", test, test1);

		Step_Start(14, "Add the quantity using the (+) symbol", test, test1);

		waitForElement(driver, PBL_AddCargo);
		click(driver, PBL_AddCargo);

		Step_End(14, "Add the quantity using the (+) symbol", test, test1);

		Step_Start(15, "Click the Apply button..", test, test1);

		waitForElement(driver, PBL_Apply_Btn);
		click(driver, PBL_Apply_Btn);

		Step_End(15, "Click the Apply button.", test, test1);

		Step_Start(16, "Do you want to overwrite the Containers for this BL  message shown.", test, test1);

		waitForPopup(driver, popup_Message, OverWrite_Container_Popup);
		String Actual_OverWrite_Container_Popup = getText(driver, popup_Message);
		System.out.println("Actual_OverWrite_Container_Popup is :" + Actual_OverWrite_Container_Popup);

		if (OverWrite_Container_Popup.equals(Actual_OverWrite_Container_Popup)) {
			Extent_pass_New(driver, "Matched || Expected popup value was : " + OverWrite_Container_Popup
					+ " || Actual popup was  displayed : " + Actual_OverWrite_Container_Popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + OverWrite_Container_Popup
					+ " || Actual popup was displayed: " + Actual_OverWrite_Container_Popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + OverWrite_Container_Popup
					+ " || Actual popup  was not displayed: " + Actual_OverWrite_Container_Popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + OverWrite_Container_Popup
					+ " || Actual popup  was not displayed: " + Actual_OverWrite_Container_Popup, test, test1);

		}

		waitForElement(driver, popup_Message_No_Button);
		click(driver, popup_Message_No_Button);

		Step_End(16,
				"Part BL created successfull message shown and the Part BL number will be displayed in the MCN and Part BL fields.",
				test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
