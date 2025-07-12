package LRP_PartBL_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC028 extends Keywords {

	public void PartBL_TC028(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC028";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String PartBL_SearchOption = Excel_data.get("PartBL_SearchOption");
		String NumOfParts = Excel_data.get("NumOfParts");
		String Eqp_ID = Excel_data.get("Eqp_ID");
		String Quantity = Excel_data.get("Quantity");
		String Assigned_Popup = Excel_data.get("Assigned_Popup");
		String BL_dropdownOption = Excel_data.get("BL_dropdownOption");
		String PBL_Eqp_Header = Excel_data.get("PBL_Eqp_Header");
		String PBL_Avl_Header = Excel_data.get("PBL_Avl_Header");
		String Saved_Popup = Excel_data.get("Saved_Popup");

		PartBL_Common_Creation commonCreation = new PartBL_Common_Creation();

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);

		Map<String, String> BL_MCN_Numbers = commonCreation.Common_PartBL(driver, test, test1, Excel_data);

		String BLNumber = BL_MCN_Numbers.get("BL_Number");

		System.out.println("BLNumber : " + BLNumber);

		Step_Start(1, "Open the Part BL module", test, test1);

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(1, "Open the Part BL module", test, test1);

		Step_Start(2, "Click the \"new\" button", test, test1);

		newButton(driver);

		Step_End(2, "Click the \"new\" button", test, test1);

		Step_Start(3, "Use the BL number search to retrieve the data.", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, PartBL_SearchOption, BLNumber, "", "", "", "");

		Step_End(3, "Use the BL number search to retrieve the data.", test, test1);

		Step_Start(4, "Enter the number of parts", test, test1);

		waitForElement(driver, PBL_No_Of_parts_Field);
		sendKeys(driver, PBL_No_Of_parts_Field, NumOfParts);

		Step_End(4, "Enter the number of parts", test, test1);

		Step_Start(5, "Click the \"Create\" button", test, test1);

		waitForElement(driver, PBL_Create_Btn);
		click(driver, PBL_Create_Btn);

		Step_End(5, "Click the \"Create\" button", test, test1);

		Step_Start(6, "Select \"Move charges Package/Weight basis\" option", test, test1);

		waitForElement(driver, PBL_Movecharges_Package_radio);
		click(driver, PBL_Movecharges_Package_radio);

		Step_End(6, "Select \"Move charges Package/Weight basis\" option", test, test1);

		Step_Start(7, "Enter the quantity", test, test1);

		if (!Eqp_ID.equals("")) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, Eqp_ID);
		}

		waitForElement(driver, PBL_Quantity_Field);
		sendKeys(driver, PBL_Quantity_Field, Quantity);

		Step_End(7, "Enter the quantity", test, test1);

		Step_Start(8, "Add the quantity using the (+) symbol", test, test1);

		waitForElement(driver, PBL_AddCargo);
		click(driver, PBL_AddCargo);

		Step_End(8, "Add the quantity using the (+) symbol", test, test1);

		Step_Start(9, "Click the \"Apply\" button", test, test1);

		waitForElement(driver, PBL_Apply_Btn);
		click(driver, PBL_Apply_Btn);

		Step_End(9, "Click the \"Apply\" button", test, test1);

		Step_Start(10, "\"Selected Packages assigned for this Part BL\" message shown.", test, test1);

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

		Step_End(10, "\"Selected Packages assigned for this Part BL\" message shown.", test, test1);

		Step_Start(11, "Click the \"OK\" button", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(11, "Click the \"OK\" button", test, test1);

		Step_Start(12, "Change the BL number to PARTBL-1", test, test1);

		waitForElement(driver, PBL_BLDropdown);
		click(driver, PBL_BLDropdown);

		formatLocatorClick(driver, DropDown_Select, BL_dropdownOption);

		Step_End(12, "Change the BL number to PARTBL-1", test, test1);

		Step_Start(13, "Enter the remaining available quantity", test, test1);

		Step_Start(14, "Add the quantity using the (+) symbol", test, test1);

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

		Step_End(14, "Add the quantity using the (+) symbol", test, test1);

		Step_End(13, "Enter the remaining available quantity", test, test1);

		Step_Start(15, "Click the \"Apply\" button", test, test1);

		waitForElement(driver, PBL_Apply_Btn);
		click(driver, PBL_Apply_Btn);

		Step_End(15, "Click the \"Apply\" button", test, test1);

		Step_Start(16, "\"Selected Packages assigned for this Part BL\" message shown", test, test1);

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

		Step_End(16, "\"Selected Packages assigned for this Part BL\" message shown.", test, test1);

		Step_Start(17, "Click the \"OK\" button", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(17, "Click the \"OK\" button", test, test1);

		Step_Start(18, "Click the \"Save\" button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(18, "Click the \"Save\" button", test, test1);

		Step_Start(19,
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

		Step_End(19,
				"\"Part BL created successfull\" message shown and the Part BL number will be displayed in the MCN and Part BL fields",
				test, test1);

		Step_Start(20, "Click ok button", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(20, "Click ok button", test, test1);

		Step_Start(21, "Click new button", test, test1);

		newButton(driver);

		Step_End(21, "Click new button", test, test1);

		Step_Start(22, "Retrive the same BL number again", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, PartBL_SearchOption, BLNumber, "", "", "", "");

		waitForElement(driver, PBL_No_Of_parts_Field);
		sendKeys(driver, PBL_No_Of_parts_Field, NumOfParts);

		waitForElement(driver, PBL_Create_Btn);
		click(driver, PBL_Create_Btn);

		Step_End(22, "Retrive the same BL number again", test, test1);

		Step_Start(23, "'Move charges Package/Weight basis' option selected automatically", test, test1);

		waitForElement(driver, PBL_Movecharges_enable);

		String radiobutton = getAttribute(driver, PBL_Movecharges_enable, "class");

		if (extractstatus(radiobutton)) {

			System.out.println(
					"Expected result || The move charges Package/weight radio button should be enabled automatically || Actual result : The move charges Package/weight radio button was enabled automatically");
			Extent_pass_New(driver,
					"Expected result || The move charges Package/weight radio button should be enabled automatically || Actual result : The move charges Package/weight radio button was enabled automatically",
					test, test1);
		} else {

			System.out.println(
					"Expected result || The move charges Package/weight radio button should be enabled automatically || Actual result : The move charges Package/weight radio button was not enabled automatically");
			Extent_fail(driver,
					"Expected result || The move charges Package/weight radio button should be enabled automatically || Actual result : The move charges Package/weight radio button was not enabled automatically",
					test, test1);

		}

		Step_End(23, "'Move charges Package/Weight basis' option selected automatically", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
