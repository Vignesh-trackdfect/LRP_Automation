package LRP_PartBL_Scripts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC011 extends Keywords {

	public void PartBL_TC011(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC011";
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
		String NumOfParts_ChildBL = Excel_data.get("NumOfParts_ChildBL");
		String PBL_Eqp_Header = Excel_data.get("PBL_Eqp_Header");
		String PBL_Avl_Header = Excel_data.get("PBL_Avl_Header");
		String Plugin_faalse = Excel_data.get("Plugin_False");
		String TransMovement_Header = Excel_data.get("TransMovement_Header");
		String Transmovement = Excel_data.get("Transmovement");
		String BL_Commodity_Qty_Header = Excel_data.get("BL_Commodity_Qty_Header");

		String Plugin_True = String.format(PluginTrue, PluginStatus);
		String Plugin_Flase = String.format(PluginFalse, Plugin_faalse);

		PartBL_Common_Creation commonCreation = new PartBL_Common_Creation();

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);

		Map<String, String> BL_MCN_Numbers = commonCreation.Common_PartBL(driver, test, test1, Excel_data);

		String BLNumber = BL_MCN_Numbers.get("BL_Number");

		System.out.println("BLNumber : " + BLNumber);

		Step_Start(1, "Set PLC plugin is true", test, test1);

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

		Step_End(1, "Set PLC plugin is true", test, test1);

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

		Step_Start(22, "Click the \"New\" button", test, test1);

		waitForElement(driver, PBL_ChildBL_ID);
		String childBl = getText(driver, PBL_ChildBL_ID);

		Extent_cal(test, test1, "The created child Bill 1 was : " + childBl);

		newButton(driver);

		Step_End(22, "Click the \"New\" button", test, test1);

		Step_Start(23, "Retrieve the child part BL number in BL number search.", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, PartBL_SearchOption, childBl, "", "", "", "");

		Step_End(23, "Retrieve the child part BL number in BL number search.", test, test1);

		Step_Start(24, "Enter the number of parts", test, test1);

		waitForElement(driver, PBL_No_Of_parts_Field);
		sendKeys(driver, PBL_No_Of_parts_Field, NumOfParts_ChildBL);

		Step_End(24, "Enter the number of parts", test, test1);

		Step_Start(25, "Click the \"Create\" button", test, test1);

		waitForElement(driver, PBL_Create_Btn);
		click(driver, PBL_Create_Btn);

		Step_Start(25, "Click the \"Create\" button", test, test1);

		Step_Start(26, "Select \"Move all charges to master.\"", test, test1);

		waitForElement(driver, PBL_Move_All_Charges_Checkbox);
		click(driver, PBL_Move_All_Charges_Checkbox);

		Step_End(26, "Select \"Move all charges to master.\"", test, test1);

		Step_Start(27, "Enter the quantity", test, test1);

		if (!Eqp_ID.equals("")) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, Eqp_ID);
		}

		waitForElement(driver, PBL_Quantity_Field);
		sendKeys(driver, PBL_Quantity_Field, Quantity);

		Step_End(27, "Enter the quantity", test, test1);

		Step_Start(28, "Add the quantity using the (+) symbol", test, test1);

		waitForElement(driver, PBL_AddCargo);
		click(driver, PBL_AddCargo);

		Step_End(28, "Add the quantity using the (+) symbol", test, test1);

		Step_Start(29, "Click the \"Apply\" button", test, test1);

		waitForElement(driver, PBL_Apply_Btn);
		click(driver, PBL_Apply_Btn);

		Step_End(29, "Click the \"Apply\" button", test, test1);

		Step_Start(30, "\"Selected Packages assigned for this Part BL\" message shown.", test, test1);

		waitForPopup(driver, popup_Message, Assigned_Popup);

		String Actual_assigned2 = getText(driver, popup_Message);

		if (Actual_assigned2.equals(Assigned_Popup)) {

			System.out.println("Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned2);
			Extent_pass_New(driver, "Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned2, test, test1);

		} else {

			System.out.println("Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned2);
			Extent_fail(driver, "Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned2, test, test1);

		}

		Step_End(30, "\"Selected Packages assigned for this Part BL\" message shown.", test, test1);

		Step_Start(32, "Click the \"OK\" button", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(32, "Click the \"OK\" button", test, test1);

		Step_Start(33, "Change the BL number to PARTBL-1", test, test1);

		waitForElement(driver, PBL_BLDropdown);
		click(driver, PBL_BLDropdown);

		formatLocatorClick(driver, DropDown_Select, BL_dropdownOption);

		Step_End(33, "Change the BL number to PARTBL-1", test, test1);

		Step_Start(34, "Enter the remaining available quantity", test, test1);

		Step_Start(35, "Add the quantity using the (+) symbol", test, test1);

		waitForElement(driver, PBL_CommodityGrid_Headers);
		List<Map<String, String>> commoditydatas_ChildBl = getTableData(driver, PBL_CommodityGrid_Headers,
				PBL_CommodityGrid_Row);

		List<String> Comm_Eqp_Ids_ChildBl = new ArrayList<String>();

		for (Map<String, String> griddatas : commoditydatas_ChildBl) {

			String EqpID = griddatas.get(PBL_Eqp_Header);

			Comm_Eqp_Ids_ChildBl.add(EqpID);

		}

		System.out.println("Comm_Eqp_Ids_ChildBl : " + Comm_Eqp_Ids_ChildBl);

		List<String> Available_Qties_ChildBl = new ArrayList<String>();

		for (Map<String, String> griddatas : commoditydatas_ChildBl) {

			String avai_Qty = griddatas.get(PBL_Avl_Header);

			Available_Qties_ChildBl.add(avai_Qty);

		}

		System.out.println("Available_Qties : " + Available_Qties_ChildBl);

		int j = 0;

		for (String Comm_Eqp_Id_Child : Comm_Eqp_Ids_ChildBl) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, Comm_Eqp_Id_Child);

			waitForElement(driver, PBL_Quantity_Field);
			sendKeys(driver, PBL_Quantity_Field, Available_Qties_ChildBl.get(j));

			waitForElement(driver, PBL_AddCargo);
			click(driver, PBL_AddCargo);

			j++;

		}

		Step_End(34, "Add the quantity using the (+) symbol", test, test1);

		Step_Start(35, "Click the \"Apply\" button", test, test1);

		waitForElement(driver, PBL_Apply_Btn);
		click(driver, PBL_Apply_Btn);

		Step_End(35, "Click the \"Apply\" button", test, test1);

		Step_Start(36, "\"Selected Packages assigned for this Part BL\" message shown", test, test1);

		waitForPopup(driver, popup_Message, Assigned_Popup);

		String Actual_assigned_All2 = getText(driver, popup_Message);

		if (Actual_assigned_All2.equals(Assigned_Popup)) {

			System.out.println("Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned_All2);
			Extent_pass_New(driver, "Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned_All2, test, test1);

		} else {

			System.out.println("Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned_All2);
			Extent_fail(driver, "Expected popup message was : " + Assigned_Popup + " Actual popup message was : "
					+ Actual_assigned_All2, test, test1);

		}

		Step_End(36, "\"Selected Packages assigned for this Part BL\" message shown.", test, test1);

		Step_Start(37, "Click the \"OK\" button", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(37, "Click the \"OK\" button", test, test1);

		Step_Start(38, "Click the \"Save\" button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(38, "Click the \"Save\" button", test, test1);

		Step_Start(39,
				"\"Part BL created successfull\" message shown and the Part BL number will be displayed in the MCN and Part BL fields",
				test, test1);

		waitForPopup(driver, popup_Message, Saved_Popup);

		String Actual_Savedpopup2 = getText(driver, popup_Message);

		if (Actual_Savedpopup2.equals(Saved_Popup)) {

			System.out.println("Expected popup message was : " + Saved_Popup + " Actual popup message was : "
					+ Actual_Savedpopup2);
			Extent_pass_New(driver,
					"Expected popup message was : " + Saved_Popup + " Actual popup message was : " + Actual_Savedpopup2,
					test, test1);

		} else {

			System.out.println("Expected popup message was : " + Saved_Popup + " Actual popup message was : "
					+ Actual_Savedpopup2);
			Extent_fail(driver,
					"Expected popup message was : " + Saved_Popup + " Actual popup message was : " + Actual_Savedpopup2,
					test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, PBL_ChildBL_ID);
		String childBl2 = getText(driver, PBL_ChildBL_ID);

		System.out.println("childBl2 : " + childBl2);

		Extent_cal(test, test1, "The created child Bill 2 was : " + childBl2);

		Step_End(39,
				"\"Part BL created successfull\" message shown and the Part BL number will be displayed in the MCN and Part BL fields",
				test, test1);

		Step_Start(40, "Retrieve the BL in Bill of lading screen and check the commodity", test, test1);

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

		// Step 1: Prepare Set of actual (eqpId, qty) from Commodity tab
		Set<String> commodityPairs = new HashSet<>();
		for (int k = 0; k < Commodity_Eqps.size(); k++) {
			String eqp = Commodity_Eqps.get(k).trim();
			String qty = Commodity_Qties.get(k).trim();
			commodityPairs.add(eqp + "|" + qty);
		}

		// Step 2: Iterate through expected pairs and compare
		for (int l = 0; l < Comm_Eqp_Ids_ChildBl.size(); l++) {
			String eqpId = Comm_Eqp_Ids_ChildBl.get(l).trim();
			String qty = Available_Qties_ChildBl.get(l).trim();
			String key = eqpId + "|" + qty;

			if (commodityPairs.contains(key)) {
				System.out.println("Expected result: Equipment Id [" + eqpId + "] and quantity [" + qty
						+ "] should be present || Actual result: Found Equipment Id [" + eqpId + "] with quantity ["
						+ qty + "]");
				Extent_pass_New(driver,
						"Expected result: Equipment Id [" + eqpId + "] and quantity [" + qty
								+ "] should be present || Actual result: Found Equipment Id [" + eqpId
								+ "] with quantity [" + qty + "]",
						test, test1);
			} else {
				System.out.println("Expected result: Equipment Id [" + eqpId + "] and quantity [" + qty
						+ "] should be present || Actual result: Equipment Id [" + eqpId + "] with quantity [" + qty
						+ "] was not found");
				Extent_fail(driver,
						"Expected result: Equipment Id [" + eqpId + "] and quantity [" + qty
								+ "] should be present || Actual result: Equipment Id [" + eqpId + "] with quantity ["
								+ qty + "] was not found",
						test, test1);
			}
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
					+ BLNumber + " message is displayed and remarks was : " + BOL_Remarks, test, test1);

		} else {

			System.out.println("Expected result : This Part BL Created from this parent Bl : " + ChildBL_Id
					+ " message should be displayed || Actual result : This Part BL Created from this parent Bl : "
					+ BLNumber + " message is not displayed and remarks was : " + BOL_Remarks);
			Extent_fail(driver, "Expected result : This Part BL Created from this parent Bl : " + ChildBL_Id
					+ " message should be displayed || Actual result : This Part BL Created from this parent Bl : "
					+ BLNumber + " message is not displayed and remarks was : " + BOL_Remarks, test, test1);
		}

		Step_End(40, "Retrieve the BL in Bill of lading screen and check the commodity", test, test1);

		Step_Start(41, "Set PLC plugin false", test, test1);

		moduleNavigate(driver, Plugin_Module);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);

		waitForElement(driver, Plugin_Flase);
		safeclick(driver, Plugin_Flase);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);

		Step_End(41, "Set PLC plugin false", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
