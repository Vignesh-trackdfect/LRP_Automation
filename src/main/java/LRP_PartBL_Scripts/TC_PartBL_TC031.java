package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC031 extends Keywords {

	public void PartBL_TC031(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC031";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Global_BL_Search_Header = Excel_data.get("Global_BL_Search_Header");
		String Quatity_Text_Field = Excel_data.get("Quatity_Text_Field");
		String No_Of_parts_TextField = Excel_data.get("No_Of_parts_TextField");
		String Remove_Container_popup = Excel_data.get("Remove_Container_popup");

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
		String Actual_Remove_Conn_Popup = getText(driver, popup_Message);
		System.out.println("Actual_Remove_Container_Popup  is :" + Actual_Remove_Conn_Popup);

		if (Remove_Container_popup.equals(Actual_Remove_Conn_Popup)) {

			System.out
					.println("Matched || Excepted :After The container Removed from the Grid, The value should be is :"
							+ Remove_Container_popup
							+ "|| Actual :After The container Removed from the Grid, The value was :"
							+ Actual_Remove_Conn_Popup);
			Extent_pass_New(driver,
					"Matched || Excepted :After The container Removed from the Grid, The value should be is :"
							+ Remove_Container_popup
							+ "|| Actual :After The container Removed from the Grid, The value was :"
							+ Actual_Remove_Conn_Popup,
					test, test1);
		}

		else {
			System.out.println(
					"NotMatched || Excepted :After The container Removed from the Grid, The value should be is :"
							+ Remove_Container_popup
							+ "|| Actual :After The container Removed from the Grid, The value was:"
							+ Actual_Remove_Conn_Popup);
			Extent_fail(driver,
					"NotMatched || Excepted :After The container Removed from the Grid, The value should be is :"
							+ Remove_Container_popup
							+ "|| Actual : After The container Removed from the Grid, The value was :"
							+ Actual_Remove_Conn_Popup,
					test, test1);
		}

		Step_End(11, "Are you sure want to remove the selected Container And Commodity ? popup message shown.", test,
				test1);

		Step_Start(12, "Click yes.", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(12, "Click yes.", test, test1);

		Step_Start(13, "System removed the added commodity in grid.", test, test1);

		waitForDisplay(driver, PBL_Container_Grid_Row_value);

		if (verifyElementHasNoText(driver, PBL_Container_Grid_Row_value)) {

			System.out.println(
					"Excepted Result || After the system removed the added commodity from the grid, the Grid should be empty || Actual Result : After the system removed the added commodity from the grid, the grid was empty");
			Extent_pass_New(driver,
					"Excepted Result || After the system removed the added commodity from the grid,the Grid should be empty || Actual Result : After the system removed the added commodity from the grid, the grid was empty",
					test, test1);
		}

		else {
			System.out.println(
					"Excepted Result || After the system removed the added commodity from the grid, the Grid should be empty || Actual Result : After the system removed the added commodity from the grid, the grid was not empty");
			Extent_fail(driver,
					"Excepted Result || After the system removed the added commodity from the grid,the Grid should be empty || Actual Result : After the system removed the added commodity from the grid, the grid was  not empty",
					test, test1);
		}
		Step_End(13, "System removed the added commodity in grid.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
