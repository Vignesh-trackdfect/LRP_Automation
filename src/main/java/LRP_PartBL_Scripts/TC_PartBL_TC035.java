package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC035 extends Keywords {

	public void PartBL_TC035(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String test_Case_Name = "TC_PartBL_TC035";
//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String PartBL_SearchOption = Excel_data.get("PartBL_SearchOption");
		String NumOfParts = Excel_data.get("NumOfParts");
		String eqpNo = Excel_data.get("eqpNo");
		String Quantity = Excel_data.get("Quantity_PBL");
		String Package_Count_Popup = Excel_data.get("Package_Count_Popup");

		navigateUrl(driver, url);
		Extent_Start(test_Case_Name, test, test1);
// Login
		LRP_Login(driver, Username, Password);

//	Switch the Profile
		SwitchProfile(driver, Agency_Name);

		PartBL_Common_Creation partBL_Data_Creation = new PartBL_Common_Creation();
		Map<String, String> BL_MCN_Numbers = partBL_Data_Creation.Common_PartBL(driver, test, test1, Excel_data);

		String Bl_Number = BL_MCN_Numbers.get("BL_Number");
		System.out.println("BL_Number:" + Bl_Number);

		Step_Start(1, "Open the Part BL module", test, test1);

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(1, "Open the Part BL module", test, test1);

		Step_Start(2, "Click the \"Create\" button.", test, test1);

		newButton(driver);

		Step_End(2, "Click the \"Create\" button.", test, test1);

		Step_Start(3, "Use the BL number search to retrieve the data.", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, PartBL_SearchOption, Bl_Number, "", "", "", "");

		Step_End(3, "Use the BL number search to retrieve the data.", test, test1);

		Step_Start(4, "Enter the number of parts", test, test1);

		waitForElement(driver, PBL_No_Of_parts_Field);
		sendKeys(driver, PBL_No_Of_parts_Field, NumOfParts);

		Step_End(4, "Enter the number of parts", test, test1);

		Step_Start(5, "Click the \"Create\" button", test, test1);

		waitForElement(driver, PBL_Create_Btn);
		click(driver, PBL_Create_Btn);

		Step_End(5, "Click the \"Create\" button", test, test1);

		Step_Start(6, "Select \"Move all charges to master.\"", test, test1);

		waitForElement(driver, PBL_Move_All_Charges_Checkbox);
		click(driver, PBL_Move_All_Charges_Checkbox);

		Step_End(6, "Select \"Move all charges to master.\"", test, test1);

		Step_Start(7, "Enter the quantity", test, test1);

		if (!eqpNo.equals("")) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, eqpNo);
		}

		waitForElement(driver, PBL_Quantity_Field);
		sendKeys(driver, PBL_Quantity_Field, Quantity);

		Step_End(7, "Enter the quantity", test, test1);

		Step_Start(8, "Click + button.", test, test1);

		waitForElement(driver, PBL_AddCargo);
		click(driver, PBL_AddCargo);

		Step_End(8, "Click + button.", test, test1);

		Step_Start(9, "\"Packages count should be less than the Total Package Count\" message shown.", test, test1);

		waitForPopup(driver, popup_Message, Package_Count_Popup);

		String actual_Popup = getText(driver, popup_Message);

		if (actual_Popup.equals(Package_Count_Popup)) {

			System.out.println(
					"Matched || Expected popup  : " + Package_Count_Popup + " || Actual popup  : " + actual_Popup);
			Extent_pass_New(driver,
					"Matched || Expected popup  : " + Package_Count_Popup + " || Actual popup  : " + actual_Popup, test,
					test1);

		} else {

			System.out.println(
					"Not Matched || Expected popup  : " + Package_Count_Popup + " || Actual popup  : " + actual_Popup);
			Extent_fail(driver,
					"Not Matched || Expected popup  : " + Package_Count_Popup + " || Actual popup  : " + actual_Popup,
					test, test1);

		}

		Step_End(9, "\"Packages count should be less than the Total Package Count\" message shown.", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Extent_completed(test_Case_Name, test, test1);

	}

}
