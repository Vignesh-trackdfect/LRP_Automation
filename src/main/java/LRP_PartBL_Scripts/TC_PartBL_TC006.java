package LRP_PartBL_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC006 extends Keywords {

	public void PartBL_TC006(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC006";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Global_BL_Search_Header = Excel_data.get("Global_BL_Search_Header");
		String No_Of_parts_TextField = Excel_data.get("No_Of_parts_TextField");
		String Weight_Text_Field = Excel_data.get("Weight_Text_Field");
		String Select_Package_popup = Excel_data.get("Select_Package_popup");
		String BL_No_Dropdown_Select = Excel_data.get("BL_No_Dropdown_Select");
		String PartBL_Created_Popup = Excel_data.get("PartBL_Created_Popup");
		String PBL_Avl_Header = Excel_data.get("PBL_Avl_Header");
		String PBL_Eqp_Header = Excel_data.get("PBL_Eqp_Header");
		String BOL_COMM_Weight_Header = Excel_data.get("BOL_COMM_Weight_Header");
		String Eqp_ID = Excel_data.get("Eqp_ID");
		String Transmovement = Excel_data.get("Transmovement");
		String TransMovement_Header = Excel_data.get("TransMovement_Header");

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

		Step_Start(6, "Select weight option", test, test1);

		waitForElement(driver, PBL_Weight_Checkbox);
		click(driver, PBL_Weight_Checkbox);

		Step_End(6, "Select weight option.", test, test1);

		Step_Start(7, "Select Move all charges to master", test, test1);

		waitForElement(driver, PBL_Move_All_Charges_Checkbox);
		click(driver, PBL_Move_All_Charges_Checkbox);

		Step_End(7, "Select Move all charges to master", test, test1);

		Step_Start(8, ".Enter the weight", test, test1);

		if (!Eqp_ID.equals("")) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, Eqp_ID);
		}

		waitForElement(driver, PBL_Weight_Field);
		sendKeys(driver, PBL_Weight_Field, Weight_Text_Field);

		Step_End(8, ".Enter the weight", test, test1);

		Step_Start(9, "Add the weight using the (+) symbol.", test, test1);

		waitForElement(driver, PBL_Weight_Add_Btn);
		click(driver, PBL_Weight_Add_Btn);

		Step_End(9, "Add the weight using the (+) symbol", test, test1);

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
		} else {
			System.out.println("Not Matched || Excepted :Select Packages popup is :" + Select_Package_popup
					+ "|| Actual :Select Packages popup is :" + Actual_Select_Packages_Popup);
			Extent_fail(driver, "Not Matched || Excepted :Select Packages popup is :" + Select_Package_popup
					+ "|| Actual : Select Packages popup is :" + Actual_Select_Packages_Popup, test, test1);
		}

		Step_End(11, "Selected Packages assigned for this Part BL message shown.", test, test1);

		Step_Start(12, "Click the OK button.", test, test1);

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		Step_End(12, "Click the OK button.", test, test1);

		Step_Start(13, "Change the BL number to PARTBL-1", test, test1);

		waitForElement(driver, PBL_No_Dropdown);
		click(driver, PBL_No_Dropdown);

		formatLocatorClick(driver, DropDown_Select, BL_No_Dropdown_Select);

		Step_End(13, "Change the BL number to PARTBL-1", test, test1);

		Step_Start(14, "Enter the remaining weight", test, test1);

		Step_Start(15, "Add the weight using the (+) symbol.", test, test1);

		waitForElement(driver, PBL_CommodityGrid_Headers);
		List<Map<String, String>> commoditydatas_ChildBl = getTableData(driver, PBL_CommodityGrid_Headers,
				PBL_CommodityGrid_Row);

		List<String> Comm_Eqp_Ids_ChildBl = new ArrayList<String>();

		for (Map<String, String> griddatas : commoditydatas_ChildBl) {

			String EqpID = griddatas.get(PBL_Eqp_Header);

			Comm_Eqp_Ids_ChildBl.add(EqpID);

		}

		System.out.println("Comm_Eqp_Ids_ChildBl : " + Comm_Eqp_Ids_ChildBl);

		List<String> Available_Weight_ChildBl = new ArrayList<String>();

		String avai_Weight = "";

		for (Map<String, String> griddatas : commoditydatas_ChildBl) {

			avai_Weight = griddatas.get(PBL_Avl_Header);

			Available_Weight_ChildBl.add(avai_Weight);

		}

		System.out.println("Available_Weight is : " + Available_Weight_ChildBl);

		int l = 0;

		for (String Comm_Eqp_Id_Child : Comm_Eqp_Ids_ChildBl) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, Comm_Eqp_Id_Child);

			waitForElement(driver, PBL_Weight_Field);
			sendKeys(driver, PBL_Weight_Field, Available_Weight_ChildBl.get(l));

			waitForElement(driver, PBL_AddCargo);
			click(driver, PBL_AddCargo);

			l++;

		}

		Step_End(14, "Enter the remaining weight", test, test1);

		Step_End(15, "Add the weight using the (+) symbol", test, test1);

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

		waitForElement(driver, popup_Message);
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

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(20,
				"Part BL created successfull message shown and the Part BL number will be displayed in the MCN and Part BL fields.",
				test, test1);

		Step_Start(21, "Retrieve the BL in the Bill of Lading module and check the weight.", test, test1);

		waitForElement(driver, PBL_ChildBL_ID);
		doubleClick(driver, PBL_ChildBL_ID);

		waitForDisplay(driver, BOL_PartLot_Checkbox);

		String partlot_status = getAttribute(driver, BOL_PartLot_Checkbox, "class");

		if (extractstatus(partlot_status)) {

			System.out.println(
					"Expected result : The PartLot checkbox should be checked || Actual result : The partlot checkbox is checked");
			Extent_pass_New(driver,
					"Expected result : The PartLot checkbox should be checked || Actual result : The partlot checkbox is checked",
					test, test1);
		} else {

			System.out.println(
					"Expected result : The PartLot checkbox should be checked || Actual result : The partlot checkbox is unchecked");
			Extent_fail(driver,
					"Expected result : The PartLot checkbox should be checked || Actual result : The partlot checkbox is unchecked",
					test, test1);

		}

		// Containers

		waitForElement(driver, bl_Container_Tab);
		mouseOverToElement(driver, bl_Container_Tab);
		safeclick(driver, bl_Container_Tab);

		waitForElement(driver, bl_container_Table_headers);
		List<Map<String, String>> BL_ContainersTable = getTableData(driver, bl_container_Table_headers,
				bl_container_table_rows);

		List<String> TransMoves = new ArrayList<String>();

		for (Map<String, String> griddatas : BL_ContainersTable) {

			String Transhipment = griddatas.get(TransMovement_Header);

			TransMoves.add(Transhipment);

		}

		for (String Trans_movement : TransMoves) {

			if (Trans_movement.equals(Transmovement)) {

				System.out.println("Expected result : The expected transmovement " + Transmovement
						+ " should show in the Bill of lading containers tab || Actual result : The expected transmovement "
						+ Trans_movement + " is showing in the Bill of lading containers tab");
				Extent_pass_New(driver, "Expected result : The expected transmovement " + Transmovement
						+ " should show in the Bill of lading containers tab || Actual result : The expected transmovement "
						+ Trans_movement + " is showing in the Bill of lading containers tab", test, test1);

			} else {

				System.out.println("Expected result : The expected transmovement " + Transmovement
						+ " should show in the Bill of lading containers tab || Actual result : Different transmovement "
						+ Trans_movement + " is showing in the Bill of lading containers tab");
				Extent_fail(driver, "Expected result : The expected transmovement " + Transmovement
						+ " should show in the Bill of lading containers tab || Actual result : Different transmovement "
						+ Trans_movement + " is showing in the Bill of lading containers tab", test, test1);

			}

		}

		// Commodity verification

		waitForElement(driver, bl_commodity_tab);
		mouseOverToElement(driver, bl_commodity_tab);
		safeclick(driver, bl_commodity_tab);

		waitForElement(driver, bl_commodity_table_headers);
		List<Map<String, String>> CommodityTable = getTableData(driver, bl_commodity_table_headers,
				bl_commodity_table_rows);

		List<String> Commodity_Eqps = new ArrayList<String>();

		for (Map<String, String> griddatas : CommodityTable) {

			String Eqp_Ids = griddatas.get(PBL_Eqp_Header);

			Commodity_Eqps.add(Eqp_Ids);

		}

		List<String> Commodity_Qties = new ArrayList<String>();

		for (Map<String, String> griddatas : CommodityTable) {

			String Com_Quantity = griddatas.get(BOL_COMM_Weight_Header);

			Commodity_Qties.add(Com_Quantity);

		}

		boolean allPairsMatch = true;
		List<String> missingPairs = new ArrayList<>();

		for (int k = 0; k < Comm_Eqp_Ids_ChildBl.size(); k++) {
			String eqpId = Comm_Eqp_Ids_ChildBl.get(k);
			String weight = Available_Weight_ChildBl.get(k);

			// Check if this (eqpId, weight) pair exists in Set 2
			boolean pairFound = false;
			for (int j = 0; j < Commodity_Eqps.size(); j++) {
				if (eqpId.equals(Commodity_Eqps.get(j)) && weight.equals(Commodity_Qties.get(j))) {
					pairFound = true;
					break;
				}
			}

			if (!pairFound) {
				allPairsMatch = false;
				missingPairs.add("[" + eqpId + ", " + weight + "]");
			}
		}

		// Log the result
		if (allPairsMatch) {
			System.out.println("Expected result The Part Bl module's equipment Id " + Comm_Eqp_Ids_ChildBl
					+ " and respective weight " + Available_Weight_ChildBl
					+ " should be present in the Bill of lading commodity Tab || Actual result : Expected result The Part Bl module's equipment Id "
					+ Comm_Eqp_Ids_ChildBl + " and respective weight " + Available_Weight_ChildBl
					+ " was present in the Bill of lading commodity Tab");
			Extent_pass_New(driver, "Expected result The Part Bl module's equipment Id " + Comm_Eqp_Ids_ChildBl
					+ " and respective weight " + Available_Weight_ChildBl
					+ " should be present in the Bill of lading commodity Tab || Actual result : Expected result The Part Bl module's equipment Id "
					+ Comm_Eqp_Ids_ChildBl + " and respective weight " + Available_Weight_ChildBl
					+ " was present in the Bill of lading commodity Tab", test, test1);
		} else {
			System.out.println("Expected result The Part Bl module's equipment Id " + Comm_Eqp_Ids_ChildBl
					+ " and respective weight " + Available_Weight_ChildBl
					+ " should be present in the Bill of lading commodity Tab || Actual result : Expected result The Part Bl module's"
					+ missingPairs + " was missing");
			Extent_fail(driver, "Expected result The Part Bl module's equipment Id " + Comm_Eqp_Ids_ChildBl
					+ " and respective weight " + Available_Weight_ChildBl
					+ " should be present in the Bill of lading commodity Tab || Actual result : Expected result The Part Bl module's"
					+ missingPairs + " was missing", test, test1);
		}

		waitForElement(driver, BOL_Remarks_Tab);
		mouseOverToElement(driver, BOL_Remarks_Tab);
		safeclick(driver, BOL_Remarks_Tab);

		waitForElement(driver, BOL_Remarks_Texts);

		String BOL_Remarks = getText(driver, BOL_Remarks_Texts);

		if (BOL_Remarks.contains(BLNumber)) {

			System.out.println("Expected result : This Part BL Created from this parent Bl : " + BLNumber
					+ " message should be displayed || Actual result : This Part BL Created from this parent Bl : "
					+ BLNumber + " message is displayed and remarks was : " + BOL_Remarks);
			Extent_pass_New(driver, "Expected result : This Part BL Created from this parent Bl : " + BLNumber
					+ " message should be displayed || Actual result : This Part BL Created from this parent Bl : "
					+ BLNumber + " message is displayed and remarks was : " + BOL_Remarks, test, test1);

		} else {

			System.out.println("Expected result : This Part BL Created from this parent Bl : " + BLNumber
					+ " message should be displayed || Actual result : This Part BL Created from this parent Bl : "
					+ BLNumber + " message is not displayed and remarks was : " + BOL_Remarks);
			Extent_fail(driver, "Expected result : This Part BL Created from this parent Bl : " + BLNumber
					+ " message should be displayed || Actual result : This Part BL Created from this parent Bl : "
					+ BLNumber + " message is not displayed and remarks was : " + BOL_Remarks, test, test1);
		}

		Step_End(21, "Retrieve the BL in the Bill of Lading module and check the weight.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
