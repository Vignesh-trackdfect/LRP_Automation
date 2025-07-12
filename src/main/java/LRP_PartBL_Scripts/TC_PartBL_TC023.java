package LRP_PartBL_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC023 extends Keywords {
	public void PartBL_TC023(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC023";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String Part_BL_Module_Name = Excel_data.get("Part_BL_Module_Name");
		String Excepted_Part_BL_popup = Excel_data.get("Excepted_Part_BL_popup");
		String Global_BL_Search_Header = Excel_data.get("Global_BL_Search_Header");
		String Quantity_Text_Field = Excel_data.get("Quantity_Text_Field");
		String No_Of_parts_TextField = Excel_data.get("No_Of_parts_TextField");
		String Table_Headers = Excel_data.get("Table_Headers");
		String Eqp_ID = Excel_data.get("Eqp_ID");
		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the Part BL module", test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);

		PartBL_Common_Creation partBL_Data_Creation = new PartBL_Common_Creation();
		Map<String, String> BL_MCN_Numbers = partBL_Data_Creation.Common_PartBL(driver, test, test1, Excel_data);

		String BL_Number = BL_MCN_Numbers.get("BL_Number");

		Step_Start(1, "Open the Part BL module.", test, test1);
		moduleNavigate(driver, Part_BL_Module_Name);
		Step_End(1, "Open the Part BL module.", test, test1);
		Step_Start(2, "Click the \"\"Create\"\" button", test, test1);
		waitForElement(driver, NewButton_ToolBar);
		click(driver, NewButton_ToolBar);
		Step_End(2, "Click the \"\"Create\"\" button", test, test1);
		Step_Start(3, "Use the BL number search to retrieve the data", test, test1);
		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Global_BL_Search_Header, BL_Number, "", "", "",
				"");
		Step_End(3, "Use the BL number search to retrieve the data", test, test1);

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
		if (!Eqp_ID.equals("")) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, Eqp_ID);
		}

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

		waitForPopup(driver, popup_Message, Excepted_Part_BL_popup);
		String Actual_Select_Packages_Popup = getText(driver, popup_Message);
		System.out.println("Actual_Select_Packages_Popup  is :" + Actual_Select_Packages_Popup);

		if (Excepted_Part_BL_popup.equals(Actual_Select_Packages_Popup)) {

			System.out.println("Matched || Excepted :Select Packages popup is :" + Excepted_Part_BL_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Select_Packages_Popup);
			Extent_pass_New(driver, "Matched || Excepted :Select Packages popup is :" + Excepted_Part_BL_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Select_Packages_Popup, test, test1);
		}

		else {
			System.out.println("NotMatched || Excepted :Select Packages popup is :" + Excepted_Part_BL_popup
					+ "|| Actual :Select Packages popup is :" + Actual_Select_Packages_Popup);
			Extent_fail(driver, "NotMatched || Excepted :Select Packages popup is :" + Excepted_Part_BL_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Select_Packages_Popup, test, test1);
		}

		Step_End(10, "Selected Packages assigned for this Part BL message shown.", test, test1);

		Step_Start(11, "Click the OK button.", test, test1);

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		Step_End(11, "Click the OK button.", test, test1);

		Step_Start(12, "Click charges tab in part BL module", test, test1);
		waitForElement(driver, PBL_Charges_Bttn);
		click(driver, PBL_Charges_Bttn);

		Step_End(12, "Click charges tab in part BL module", test, test1);

		Step_Start(13, " Check all charges are same above charges.", test, test1);
		waitForElement(driver, PBL_BLCharges_Table_Header);

		List<Map<String, String>> Bl_tableData = getTableData_PartBL(driver, PBL_BLCharges_Table_Header,
				PBL_BLCharges_Table_Row);

		List<Map<String, String>> PBL_tableData = getTableData_PartBL(driver, PBL_Table_Header, PBL_Table_Row);

		boolean isEqualIgnoreOrder = Bl_tableData.size() == PBL_tableData.size()
				&& Bl_tableData.containsAll(PBL_tableData) && PBL_tableData.containsAll(Bl_tableData);

		System.out.println("Match ignoring order: " + isEqualIgnoreOrder);

		List<Map<String, String>> missingInPBL = new ArrayList<>(Bl_tableData);
		missingInPBL.removeAll(PBL_tableData);

		List<Map<String, String>> missingInBL = new ArrayList<>(PBL_tableData);
		missingInBL.removeAll(Bl_tableData);

		List<String> tableHeader = splitAndExpand(Table_Headers, ",");

		String Pbl_tableDataForReport = TableDataForReport(driver, PBL_tableData, "Part BL Charges Table", tableHeader);
		String BL_tableDataForReport = TableDataForReport(driver, Bl_tableData, " BL Charges Table", tableHeader);

		if (isEqualIgnoreOrder == true) {
			System.out.println("Matched ||Excepted : The Table Data from the BL Charges table is :"
					+ BL_tableDataForReport + " || Actual : The Table Data from the Part BL Charges Table is  : "
					+ Pbl_tableDataForReport);
			Extent_pass_New(driver,
					"Matched ||Excepted : The Table Data from the BL Charges table is :" + BL_tableDataForReport
							+ " || Actual : The Table Data from the Part BL Charges Table is  : "
							+ Pbl_tableDataForReport,
					test, test1);

		} else {

			System.out.println(" Not Matched ||Excepted : The Table Data from the BL Charges table is :"
					+ BL_tableDataForReport + " || Actual : The Table Data from the Part BL Charges Table is  : "
					+ Pbl_tableDataForReport);

			Extent_cal(test, test1, "The Unmatched record from the BL Charges table  is : " + missingInBL
					+ "|| The Unmatched record from the BL Charges table  is : " + missingInPBL);

			Extent_fail(driver,
					" Not Matched ||Excepted : The Table Data from the BL Charges table is :" + BL_tableDataForReport
							+ " || Actual : The Table Data from the Part BL Charges Table is  : "
							+ Pbl_tableDataForReport,
					test, test1);

		}
		Step_End(13, " Check all charges are same above charges.", test, test1);
		Extent_completed(testCaseName, test, test1);

	}

}
