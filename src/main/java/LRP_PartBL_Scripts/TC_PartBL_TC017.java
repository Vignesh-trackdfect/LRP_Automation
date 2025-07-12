package LRP_PartBL_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC017 extends Keywords {

	public void PartBL_TC017(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC017";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String ModuleName = Excel_data.get("ModuleName");
		String Column_Header = Excel_data.get("Column_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String value = Excel_data.get("value");
		String EnableStatus = Excel_data.get("EnableStatus");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Select_field = Excel_data.get("Select_field");
		String No_Of_parts_TextField = Excel_data.get("No_Of_parts_TextField");
		String Eqp_ID = Excel_data.get("Eqp_ID");
		String Quantity_Text_Field = Excel_data.get("Quantity_Text_Field");
		String Select_Package_popup = Excel_data.get("Select_Package_popup");
		String BL_No_Dropdown_Select = Excel_data.get("BL_No_Dropdown_Select");
		String PartBL_Created_Popup = Excel_data.get("PartBL_Created_Popup");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String PBL_Avl_Header = Excel_data.get("PBL_Avl_Header");
		String PBL_Eqp_Header = Excel_data.get("PBL_Eqp_Header");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);

		PartBL_Common_Creation partBL_Data_Creation = new PartBL_Common_Creation();

		Map<String, String> BL_MCN_Numbers = partBL_Data_Creation.Common_PartBL(driver, test, test1, Excel_data);

		System.out.println("BL_Number:" + BL_MCN_Numbers.get("BL_Number"));

		String BLNumber = BL_MCN_Numbers.get("BL_Number");

		Step_Start(1, ".Set PLTM plugin is false.", test, test1);

		setPluginConfig(driver, ModuleName, Column_Header, Condition_Filter, value, EnableStatus);

		Step_End(1, ".Set PLTM plugin is false.", test, test1);

		Step_Start(2, "Open the Part BL module", test, test1);

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(2, "Open the Part BL module", test, test1);

		Step_Start(3, ".Click the Create button.", test, test1);

		newButton(driver);

		Step_End(3, ".Click the Create button.", test, test1);

		Step_Start(4, "Use the BL number search to retrieve the data.", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, Search_Condition, Select_field, BLNumber, "", "", "", "");
		Step_End(4, "Use the BL number search to retrieve the data.", test, test1);

		Step_Start(5, "Enter the number of parts", test, test1);

		waitForElement(driver, PBL_No_Of_parts_Field);
		sendKeys(driver, PBL_No_Of_parts_Field, No_Of_parts_TextField);

		Step_End(5, "Enter the number of parts", test, test1);

		Step_Start(6, "Click the Create button.", test, test1);

		waitForElement(driver, PBL_Create_Btn);
		click(driver, PBL_Create_Btn);

		Step_End(6, "Click the Create button.", test, test1);

		Step_Start(7, "Select Move all charges to master", test, test1);

		waitForElement(driver, PBL_Move_All_Charges_Checkbox);
		click(driver, PBL_Move_All_Charges_Checkbox);

		Step_End(7, "Select Move all charges to master", test, test1);

		Step_Start(8, "Enter the quantity", test, test1);

		if (!Eqp_ID.equals("")) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, Eqp_ID);
		}

		waitForElement(driver, PBL_Quantity_Field);
		sendKeys(driver, PBL_Quantity_Field, Quantity_Text_Field);

		Step_End(8, "Enter the quantity", test, test1);

		Step_Start(9, "Add the quantity using the (+) symbol", test, test1);

		waitForElement(driver, PBL_Weight_Add_Btn);
		click(driver, PBL_Weight_Add_Btn);

		Step_End(9, "Add the quantity using the (+) symbol", test, test1);

		Step_Start(10, "Click the Apply button..", test, test1);

		waitForElement(driver, PBL_Apply_Btn);
		click(driver, PBL_Apply_Btn);

		Step_End(10, "Click the Apply button.", test, test1);

		Step_Start(11, "Selected Packages assigned for this Part BL message shown.", test, test1);

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

		Step_End(11, "Selected Packages assigned for this Part BL message shown.", test, test1);

		Step_Start(12, "Click the OK button.", test, test1);

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		Step_End(12, "Click the OK button.", test, test1);

		Step_Start(13, "Change the BL number to PARTBL-1..", test, test1);

		waitForElement(driver, PBL_No_Dropdown);
		click(driver, PBL_No_Dropdown);

		formatLocatorClick(driver, PBL_No_Dropdown_Sel, BL_No_Dropdown_Select);

		Step_End(13, "Change the BL number to PARTBL-1..", test, test1);

		Step_Start(14, "Enter the remaining available quantity..", test, test1);
		Step_Start(15, "Add the quantity using the (+) symbol..", test, test1);

		waitForElement(driver, PBL_CommodityGrid_Headers);

		List<Map<String, String>> commoditydatas = getTableData(driver, PBL_CommodityGrid_Headers,
				PBL_CommodityGrid_Row);

		List<String> Comm_Eqp_Ids = new ArrayList<String>();

		for (Map<String, String> griddatas : commoditydatas) {

			String EqpID = griddatas.get(PBL_Eqp_Header);

			Comm_Eqp_Ids.add(EqpID);

		}

		System.out.println("Comm_Eqp_Ids : " + Comm_Eqp_Ids);

		List<String> Available_Qties = new ArrayList<String>();

		for (Map<String, String> griddatas : commoditydatas) {

			String avai_Qty = griddatas.get(PBL_Avl_Header);

			Available_Qties.add(avai_Qty);

		}

		System.out.println("Available_Qties : " + Available_Qties);

		int i = 0;

		for (String Comm_Eqp_Id : Comm_Eqp_Ids) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, Comm_Eqp_Id);

			waitForElement(driver, PBL_Quantity_Field);
			sendKeys(driver, PBL_Quantity_Field, Available_Qties.get(i));

			waitForElement(driver, PBL_AddCargo);
			click(driver, PBL_AddCargo);

			i++;

		}

		Step_End(14, "Enter the remaining available quantity..", test, test1);

		Step_End(15, "Add the quantity using the (+) symbol..", test, test1);

		Step_Start(16, "Click the Apply button..", test, test1);

		waitForElement(driver, PBL_Apply_Btn);
		click(driver, PBL_Apply_Btn);

		Step_End(16, "Click the Apply button.", test, test1);

		Step_Start(17, "Selected Packages assigned for this Part BL message shown.", test, test1);

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

		Step_End(17, "Selected Packages assigned for this Part BL message shown.", test, test1);

		Step_Start(18, "Click the OK button.", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(18, "Click the OK button.", test, test1);

		Step_Start(19, "Click the Save button.", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(19, "Click the Save button.", test, test1);

		Step_Start(20,
				"Part BL created successfull message shown and the Part BL number will be displayed in the MCN and Part BL fields.",
				test, test1);

		waitForPopup(driver, popup_Message, PartBL_Created_Popup);
		String Actual_PartBL_Created_Popup = getText(driver, popup_Message);
		System.out.println("Actual_PartBL_Created_Popup is :" + Actual_PartBL_Created_Popup);

		if (PartBL_Created_Popup.equals(Actual_PartBL_Created_Popup)) {
			Extent_pass_New(driver, "Matched || Expected popup value was : " + PartBL_Created_Popup
					+ " || Actual popup was  displayed : " + Actual_PartBL_Created_Popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + PartBL_Created_Popup
					+ " || Actual popup was displayed: " + Actual_PartBL_Created_Popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + PartBL_Created_Popup
					+ " || Actual popup  was not displayed: " + Actual_PartBL_Created_Popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + PartBL_Created_Popup
					+ " || Actual popup  was not displayed: " + Actual_PartBL_Created_Popup, test, test1);

		}

		Step_End(20,
				"Part BL created successfull message shown and the Part BL number will be displayed in the MCN and Part BL fields.",
				test, test1);

		Step_Start(21, "Click ok button", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(21, "Click ok button", test, test1);

		Step_Start(22, "Double click the MCN number in MCN and part BL field.", test, test1);

		waitForElement(driver, PBL_MCN_ID);

		String Mcn_in_PBL = getText(driver, PBL_MCN_ID);

		System.out.println("MCN number in MCN and part BL field : " + Mcn_in_PBL);

		waitForElement(driver, PBL_MCN_ID);
		doubleClick(driver, PBL_MCN_ID);

		Step_End(22, "Double click the MCN number in MCN and part BL field..", test, test1);

		Step_Start(23, "System navigated to the manifest correction notes module..", test, test1);

		waitForElement(driver, MCN_Number_Textfield);

		String Mcn_number_Mcn = getAttribute(driver, MCN_Number_Textfield, "value");

		System.out.println("MCN number in MCN Module : " + Mcn_number_Mcn);

		if (Mcn_in_PBL.equals(Mcn_number_Mcn)) {
			Extent_pass(driver,
					"Matched || Expected value is : MCN number in MCN and part BL field should be same in MCN module : "
							+ Mcn_in_PBL
							+ " || Actual value is : MCN number in MCN and part BL field is same in MCN module : "
							+ Mcn_number_Mcn,
					test, test1);
			System.out.println(
					"Matched || Expected value is : MCN number in MCN and part BL field should be same in MCN module : "
							+ Mcn_in_PBL
							+ " || Actual value is : MCN number in MCN and part BL field is same in MCN module  "
							+ Mcn_number_Mcn);
		} else {
			System.out.println(
					"Not Matched || Expected value is : MCN number in MCN and part BL field should be same in MCN module : "
							+ Mcn_in_PBL
							+ " || Actual value is : MCN number in MCN and part BL field is not same in MCN module : "
							+ Mcn_number_Mcn);
			Extent_fail(driver,
					"Not Matched || Expected value is : MCN number in MCN and part BL field should be  same in MCN module  : "
							+ Mcn_in_PBL
							+ " || Actual value is :MCN number in MCN and part BL field is not same in MCN module : "
							+ Mcn_number_Mcn,
					test, test1);

		}
		Step_End(23, "System navigated to the manifest correction notes module.", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
