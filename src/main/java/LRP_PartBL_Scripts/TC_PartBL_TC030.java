package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC030 extends Keywords {

	public void PartBL_TC030(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC030";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String PartBL_SearchOption = Excel_data.get("PartBL_SearchOption");
		String NumOfParts = Excel_data.get("NumOfParts");
		String Eqp_ID = Excel_data.get("Eqp_ID");
		String Quantity = Excel_data.get("Quantity");
		String Remove_Container_popup = Excel_data.get("Remove_Container_popup");

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

		Step_Start(9, ".Click in grid.", test, test1);

		waitForElement(driver, PBL_Container_Grid_Row);
		doubleClick(driver, PBL_Container_Grid_Row);

		Step_End(9, ".Click in grid.", test, test1);

		Step_Start(10, "Click - simbol.", test, test1);

		waitForElement(driver, PBL_CARGO_Remove_Btn);
		click(driver, PBL_CARGO_Remove_Btn);

		Step_End(10, "Click - simbol.", test, test1);

		Step_Start(11, "Are you sure want to remove the selected Container And Commodity ? popup message shown.", test,
				test1);

		waitForPopup(driver, popup_Message, Remove_Container_popup);
		String Actual_Remove_Popup = getText(driver, popup_Message);

		if (Remove_Container_popup.equals(Actual_Remove_Popup)) {

			System.out.println("Matched || Expected popup message was :" + Remove_Container_popup
					+ "|| Actual popup message was :" + Actual_Remove_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was :" + Remove_Container_popup
					+ "|| Actual popup message was :" + Actual_Remove_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was :" + Remove_Container_popup
					+ "|| Actual popup message was :" + Actual_Remove_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was :" + Remove_Container_popup
					+ "|| Actual popup message was :" + Actual_Remove_Popup, test, test1);
		}

		Step_End(11, "Are you sure want to remove the selected Container And Commodity ? popup message shown.", test,
				test1);

		Extent_completed(testCaseName, test, test1);

	}

}
