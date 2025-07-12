package LRP_PartBL_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC015 extends Keywords {

	public void PartBL_TC015(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC015";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String Plugin_Module = Excel_data.get("Plugin_Module");
		String pluginID = Excel_data.get("pluginID");
		String PluginStatus = Excel_data.get("PluginStatus");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String PartBL_SearchOption = Excel_data.get("PartBL_SearchOption");
		String NumOfParts = Excel_data.get("NumOfParts");
		String Eqp_ID = Excel_data.get("Eqp_ID");
		String Quantity = Excel_data.get("Quantity");
		String Assigned_Popup = Excel_data.get("Assigned_Popup");
		String BL_dropdownOption = Excel_data.get("BL_dropdownOption");
		String Saved_Popup = Excel_data.get("Saved_Popup");
		String PBL_Eqp_Header = Excel_data.get("PBL_Eqp_Header");
		String PBL_Avl_Header = Excel_data.get("PBL_Avl_Header");
		String Plugin_faalse = Excel_data.get("Plugin_faalse");
		String TransMovement_Header = Excel_data.get("TransMovement_Header");
		String Transmovement = Excel_data.get("Transmovement");
		String BL_Commodity_Qty_Header = Excel_data.get("BL_Commodity_Qty_Header");

		String Plugin_True = String.format(PluginTrue, PluginStatus);
		String Plugin_False = String.format(PluginFalse, Plugin_faalse);

		PartBL_Common_Creation commonCreation = new PartBL_Common_Creation();

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);

		Map<String, String> BL_MCN_Numbers = commonCreation.Common_PartBL(driver, test, test1, Excel_data);

		String BLNumber = BL_MCN_Numbers.get("BL_Number");

		System.out.println("BLNumber : " + BLNumber);

		Step_Start(1, "Set ICF plugin is true", test, test1);

		moduleNavigate(driver, Plugin_Module);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);

		waitForElement(driver, Plugin_True);
		safeclick(driver, Plugin_True);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);

		Step_End(1, "Set ICF plugin is true", test, test1);

		Step_Start(2, "Open the Part BL module", test, test1);

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(2, "Open the Part BL module", test, test1);

		Step_Start(3, "Click the \"new\" button", test, test1);

		newButton(driver);

		Step_End(3, "Click the \"new\" button", test, test1);

		Step_Start(4, "Use the BL number search to retrieve the data.", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, PartBL_SearchOption, BLNumber, "", "", "", "");

		Step_End(4, "Use the BL number search to retrieve the data.", test, test1);

		Step_Start(5, "Enter the number of parts", test, test1);

		waitForElement(driver, PBL_No_Of_parts_Field);
		sendKeys(driver, PBL_No_Of_parts_Field, NumOfParts);

		Step_End(5, "Enter the number of parts", test, test1);

		Step_Start(6, "Click the \"Create\" button", test, test1);

		waitForElement(driver, PBL_Create_Btn);
		click(driver, PBL_Create_Btn);

		Step_End(6, "Click the \"Create\" button", test, test1);

		Step_Start(7, "Select \"Move all charges to master.\"", test, test1);

		waitForElement(driver, PBL_Move_All_Charges_Checkbox);
		click(driver, PBL_Move_All_Charges_Checkbox);

		Step_End(7, "Select \"Move all charges to master.\"", test, test1);

		Step_Start(8, "Enter the quantity", test, test1);

		if (!Eqp_ID.equals("")) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, Eqp_ID);
		}

		waitForElement(driver, PBL_Quantity_Field);
		sendKeys(driver, PBL_Quantity_Field, Quantity);

		Step_End(8, "Enter the quantity", test, test1);

		Step_Start(9, "Add the quantity using the (+) symbol", test, test1);

		waitForElement(driver, PBL_AddCargo);
		click(driver, PBL_AddCargo);

		Step_End(9, "Add the quantity using the (+) symbol", test, test1);

		Step_Start(10, "Click the \"Apply\" button", test, test1);

		waitForElement(driver, PBL_Apply_Btn);
		click(driver, PBL_Apply_Btn);

		Step_End(10, "Click the \"Apply\" button", test, test1);

		Step_Start(11, "\"Selected Packages assigned for this Part BL\" message shown.", test, test1);

		waitForPopup(driver, popup_Message, Assigned_Popup);

		String Actual_assigned = getText(driver, popup_Message);

		if (Actual_assigned.equals(Assigned_Popup)) {

			System.out.println("Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned);
			Extent_pass_New(driver,
					"Expected popup message was : " + Assigned_Popup + " Actual popup message was : " + Actual_assigned,
					test, test1);

		} else {

			System.out.println("Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned);
			Extent_fail(driver,
					"Expected popup message was : " + Assigned_Popup + " Actual popup message was : " + Actual_assigned,
					test, test1);

		}

		Step_End(11, "\"Selected Packages assigned for this Part BL\" message shown.", test, test1);

		Step_Start(12, "Click the \"OK\" button", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(12, "Click the \"OK\" button", test, test1);

		Step_Start(13, "Change the BL number to PARTBL-1", test, test1);

		waitForElement(driver, PBL_BLDropdown);
		click(driver, PBL_BLDropdown);

		formatLocatorClick(driver, DropDown_Select, BL_dropdownOption);

		Step_End(13, "Change the BL number to PARTBL-1", test, test1);

		Step_Start(14, "Enter the remaining available quantity", test, test1);

		Step_Start(15, "Add the quantity using the (+) symbol", test, test1);

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

		Step_End(15, "Add the quantity using the (+) symbol", test, test1);

		Step_End(14, "Enter the remaining available quantity", test, test1);

		Step_Start(16, "Click the \"Apply\" button", test, test1);

		waitForElement(driver, PBL_Apply_Btn);
		click(driver, PBL_Apply_Btn);

		Step_End(16, "Click the \"Apply\" button", test, test1);

		Step_Start(17, "\"Selected Packages assigned for this Part BL\" message shown", test, test1);

		waitForPopup(driver, popup_Message, Assigned_Popup);

		String Actual_assigned_All = getText(driver, popup_Message);

		if (Actual_assigned_All.equals(Assigned_Popup)) {

			System.out.println("Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned_All);
			Extent_pass_New(driver, "Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned_All, test, test1);

		} else {

			System.out.println("Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned_All);
			Extent_fail(driver, "Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned_All, test, test1);

		}

		Step_End(17, "\"Selected Packages assigned for this Part BL\" message shown.", test, test1);

		Step_Start(18, "Click the \"OK\" button", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(18, "Click the \"OK\" button", test, test1);

		Step_Start(19, "Click the \"Save\" button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(19, "Click the \"Save\" button", test, test1);

		Step_Start(20,
				"\"Part BL created successfull\" message shown and the Part BL number will be displayed in the MCN and Part BL fields",
				test, test1);

		waitForPopup(driver, popup_Message, Saved_Popup);

		String Actual_Savedpopup = getText(driver, popup_Message);

		if (Actual_Savedpopup.equals(Saved_Popup)) {

			System.out.println(
					"Expected popup message was : " + Saved_Popup + " Actual popup message was : " + Actual_Savedpopup);
			Extent_pass_New(driver,
					"Expected popup message was : " + Saved_Popup + " Actual popup message was : " + Actual_Savedpopup,
					test, test1);

		} else {

			System.out.println(
					"Expected popup message was : " + Saved_Popup + " Actual popup message was : " + Actual_Savedpopup);
			Extent_fail(driver,
					"Expected popup message was : " + Saved_Popup + " Actual popup message was : " + Actual_Savedpopup,
					test, test1);

		}

		Step_End(20,
				"\"Part BL created successfull\" message shown and the Part BL number will be displayed in the MCN and Part BL fields",
				test, test1);

		Step_Start(21, "Click ok button", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(21, "Click ok button", test, test1);

		Step_Start(22, "Retrieve the BL in the Bill of Lading module and check the clause tab.", test, test1);

		waitForElement(driver, PBL_ChildBL_ID);

		List<WebElement> PartBL_Id = listOfElements(driver, PBL_PartBL_ID);

		List<String> BLIds = new ArrayList<String>();

		for (WebElement ele : PartBL_Id) {

			String partbl_No = ele.getText();

			BLIds.add(partbl_No);

		}

		waitForElement(driver, PBL_ChildBL_ID);
		String ChildBL_Id = getText(driver, PBL_ChildBL_ID);
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

			String Com_Quantity = griddatas.get(BL_Commodity_Qty_Header);

			Commodity_Qties.add(Com_Quantity);

		}

		boolean allPairsMatch = true;
		List<String> missingPairs = new ArrayList<>();

		for (int k = 0; k < Comm_Eqp_Ids.size(); k++) {
			String eqpId = Comm_Eqp_Ids.get(k);
			String qty = Available_Qties.get(k);

			// Check if this (eqpId, qty) pair exists in Set 2
			boolean pairFound = false;
			for (int j = 0; j < Commodity_Eqps.size(); j++) {
				if (eqpId.equals(Commodity_Eqps.get(j)) && qty.equals(Commodity_Qties.get(j))) {
					pairFound = true;
					break;
				}
			}

			if (!pairFound) {
				allPairsMatch = false;
				missingPairs.add("[" + eqpId + ", " + qty + "]");
			}
		}

		// Log the result
		if (allPairsMatch) {
			System.out.println("Expected result The Part Bl module's equipment Id " + Comm_Eqp_Ids
					+ " and respective quanity " + Available_Qties
					+ " should be present in the Bill of lading commodity Tab || Actual result : Expected result The Part Bl module's equipment Id "
					+ Comm_Eqp_Ids + " and respective quanity " + Available_Qties
					+ " was present in the Bill of lading commodity Tab");
			Extent_pass_New(driver, "Expected result The Part Bl module's equipment Id " + Comm_Eqp_Ids
					+ " and respective quanity " + Available_Qties
					+ " should be present in the Bill of lading commodity Tab || Actual result : Expected result The Part Bl module's equipment Id "
					+ Comm_Eqp_Ids + " and respective quanity " + Available_Qties
					+ " was present in the Bill of lading commodity Tab", test, test1);
		} else {
			System.out.println("Expected result The Part Bl module's equipment Id " + Comm_Eqp_Ids
					+ " and respective quanity " + Available_Qties
					+ " should be present in the Bill of lading commodity Tab || Actual result : Expected result The Part Bl module's"
					+ missingPairs + " was missing");
			Extent_fail(driver, "Expected result The Part Bl module's equipment Id " + Comm_Eqp_Ids
					+ " and respective quanity " + Available_Qties
					+ " should be present in the Bill of lading commodity Tab || Actual result : Expected result The Part Bl module's"
					+ missingPairs + " was missing", test, test1);
		}

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);

		waitForElement(driver, PBL_PartBL_ID);
		doubleClick(driver, PBL_PartBL_ID);

		waitForElement(driver, BOL_Remarks_Tab);
		mouseOverToElement(driver, BOL_Remarks_Tab);
		safeclick(driver, BOL_Remarks_Tab);

		waitForElement(driver, BOL_Remarks_Texts);

		String Parent_BOL_Remarks = getText(driver, BOL_Remarks_Texts);

		if (Parent_BOL_Remarks.contains(ChildBL_Id)) {

			System.out.println("Expected result : This Part BL Created from this parent Bl : " + ChildBL_Id
					+ " message should be displayed || Actual result : This Part BL Created from this parent Bl : "
					+ BLNumber + " message is displayed and remarks was : " + Parent_BOL_Remarks);
			Extent_pass_New(driver, "Expected result : This Part BL Created from this parent Bl : " + ChildBL_Id
					+ " message should be displayed || Actual result : This Part BL Created from this parent Bl : "
					+ BLNumber + " message is displayed and remarks was : " + Parent_BOL_Remarks, test, test1);

		} else {

			System.out.println("Expected result : This Part BL Created from this parent Bl : " + ChildBL_Id
					+ " message should be displayed || Actual result : This Part BL Created from this parent Bl : "
					+ BLNumber + " message is not displayed and remarks was : " + Parent_BOL_Remarks);
			Extent_fail(driver, "Expected result : This Part BL Created from this parent Bl : " + ChildBL_Id
					+ " message should be displayed || Actual result : This Part BL Created from this parent Bl : "
					+ BLNumber + " message is not displayed and remarks was : " + Parent_BOL_Remarks, test, test1);
		}

		Step_End(22, "Retrieve the BL in the Bill of Lading module and check the clause tab.", test, test1);

		Step_Start(23, "Set ICF plugin is true", test, test1);

		moduleNavigate(driver, Plugin_Module);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);

		waitForElement(driver, Plugin_False);
		safeclick(driver, Plugin_False);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);

		Step_End(23, "Set ICF plugin is true", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
