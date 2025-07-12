package LRP_PartBL_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC019 extends Keywords {
	public void PartBL_TC019(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC019";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String Plugin_Module_Name = Excel_data.get("Plugin_Module_Name");
		String Plugin_Header = Excel_data.get("Plugin_Header");
		String Plugin_Value = Excel_data.get("Plugin_Value");
		String Plugin_condition_Filter = Excel_data.get("Plugin_condition_Filter");
		String Plugin_Status = Excel_data.get("Plugin_Status");
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

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);
		PartBL_Common_Creation partBL_Data_Creation = new PartBL_Common_Creation();
		Map<String, String> BL_MCN_Numbers = partBL_Data_Creation.Common_PartBL(driver, test, test1, Excel_data);

		String BL_Number = BL_MCN_Numbers.get("BL_Number");

		System.out.println("MCN_Number:" + BL_MCN_Numbers.get("MCN_Number"));
		System.out.println("BL_Number:" + BL_MCN_Numbers.get("BL_Number"));

		Step_Start(1, "Set PLTM plugin is false", test, test1);
		setPluginConfig(driver, Plugin_Module_Name, Plugin_Header, Plugin_condition_Filter, Plugin_Value,
				Plugin_Status);
		Step_End(1, "Set PLTM plugin is false", test, test1);

		Step_Start(2, "Open the Part BL module", test, test1);

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(2, "Open the Part BL module", test, test1);

		Step_Start(3, "Click the \"new\" button", test, test1);

		newButton(driver);

		Step_End(3, "Click the \"new\" button", test, test1);

		Step_Start(4, "Use the BL number search to retrieve the data.", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, PartBL_SearchOption, BL_Number, "", "", "", "");

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

		Step_Start(22, "Retrive the next version MCN and child BL", test, test1);

		waitForElement(driver, PBL_PartBL_ID);
		String PRT_Mcn_Number = getText(driver, PBL_PartBL_ID);
		System.out.println("Mcn_Number is  :" + PRT_Mcn_Number);

		waitForElement(driver, PBL_PartBL_ID);
		doubleClick(driver, PBL_PartBL_ID);

		waitForElement(driver, MCN_Number_Textfield);
		String Mcn_Number = getAttribute(driver, MCN_Number_Textfield, "value");
		System.out.println("Mcn_Number is  :" + Mcn_Number);

		if (PRT_Mcn_Number.equals(Mcn_Number)) {

			System.out.println("  Matched || Expected  The Mcn Number from the partBl module is  : " + PRT_Mcn_Number
					+ " Actual The MCN Number From MCN Module is : " + Mcn_Number);
			Extent_pass_New(driver, "  Matched || Expected  The Mcn Number from the partBl module is  : "
					+ PRT_Mcn_Number + " Actual The MCN Number From MCN Module is : " + Mcn_Number, test, test1);

		} else {

			System.out.println("  Not  Matched || Expected  The Mcn Number from the partBl module is  : "
					+ PRT_Mcn_Number + " Actual The MCN Number From MCN Module is : " + Mcn_Number);
			Extent_fail(driver, "  Not Matched || Expected  The Mcn Number from the partBl module is  : "
					+ PRT_Mcn_Number + " Actual The MCN Number From MCN Module is : " + Mcn_Number, test, test1);

		}

		Step_End(22, "Retrive the next version MCN and child BL", test, test1);

		Extent_completed(testCaseName, test, test1);
	}
}
