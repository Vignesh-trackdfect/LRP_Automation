package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC31 extends Keywords {

	public void Feeder_Contract_SC31(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC31";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Vendor_Header = Excel_data.get("Vendor_Header");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String POL_Header = Excel_data.get("POL_Header");
		String POL_Value = Excel_data.get("POL_Value");
		String POD_Header = Excel_data.get("POD_Header");
		String POD_Value = Excel_data.get("POD_Value");
		String LoadTerm_Header = Excel_data.get("LoadTerm_Header");
		String LoadTerm_Value = Excel_data.get("LoadTerm_Value");
		String EquipmentType = Excel_data.get("EquipmentType");
		String EquipmentStatus = Excel_data.get("EquipmentStatus");
		String NegotiatedBy = Excel_data.get("NegotiatedBy");
		String DurationType = Excel_data.get("DurationType");
		String Pickup_Header = Excel_data.get("Pickup_Header");
		String Pickup_Value = Excel_data.get("Pickup_Value");
		String Drop_Header = Excel_data.get("Drop_Header");
		String Drop_Value = Excel_data.get("Drop_Value");
		String DischargeTerm_Header = Excel_data.get("DischargeTerm_Header");
		String DischargeTerm_Value = Excel_data.get("DischargeTerm_Value");
		String Service_Header = Excel_data.get("Service_Header");
		String Service_Value = Excel_data.get("Service_Value");
		String AmountValue = Excel_data.get("AmountValue");
		String Basis_Option = Excel_data.get("Basis_Option");
		String ValidFrom = Excel_data.get("ValidFrom");
		String ValidTo = Excel_data.get("ValidTo");
		String Payable_Option = Excel_data.get("Payable_Option");
		String Filter_Columns = Excel_data.get("Filter_Columns");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master",
				test, test1);

		waitForElement(driver, FC_Vendor_Search_Button);
		click(driver, FC_Vendor_Search_Button);

		twoColumnSearchWindow(driver, Vendor_Header, Two_Column_Condition, Vendor_Code);

		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master",
				test, test1);

		Step_Start(3, "Click on the '+' Button to add the all details ", test, test1);

		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);

		Step_End(3, "Click on the '+' Button to add the all details ", test, test1);

		Step_Start(4, "It show the Feeder Contract input details page", test, test1);

		if (isdisplayed(driver, FC_DurationType)) {
			System.out.println(
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is displayed");
			Extent_pass_New(driver,
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is displayed",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is not displayed");
			Extent_fail(driver,
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is not displayed",
					test, test1);

		}

		Step_End(4, "It show the Feeder Contract input details page", test, test1);

		Step_Start(5, "Click the POL in the Payat details", test, test1);

		waitForElement(driver, FC_POL_Search);
		click(driver, FC_POL_Search);

		twoColumnSearchWindow(driver, POL_Header, Two_Column_Condition, POL_Value);

		waitForElement(driver, FC_POD_Search);
		click(driver, FC_POD_Search);

		twoColumnSearchWindow(driver, POD_Header, Two_Column_Condition, POD_Value);

		waitForElement(driver, FC_Load_Term);
		click(driver, FC_Load_Term);

		twoColumnSearchWindow(driver, LoadTerm_Header, Two_Column_Condition, LoadTerm_Value);

		waitForElement(driver, FC_EquipmentDropdown);
		click(driver, FC_EquipmentDropdown);

		formatLocatorClick(driver, DropDown_Select, EquipmentType);

		waitForElement(driver, FC_EqpStatusDropdown);
		click(driver, FC_EqpStatusDropdown);

		formatLocatorClick(driver, DropDown_Select, EquipmentStatus);

		waitForElement(driver, FC_NegotiatedBy_dropdown);
		click(driver, FC_NegotiatedBy_dropdown);

		formatLocatorClick(driver, DropDown_Select, NegotiatedBy);

		waitForElement(driver, FC_DurationType);
		click(driver, FC_DurationType);

		formatLocatorClick(driver, DropDown_Select, DurationType);

		waitForElement(driver, FC_PickupTerminal);
		click(driver, FC_PickupTerminal);

		twoColumnSearchWindow(driver, Pickup_Header, Two_Column_Condition, Pickup_Value);

		waitForElement(driver, FC_DropTerminal);
		click(driver, FC_DropTerminal);

		twoColumnSearchWindow(driver, Drop_Header, Two_Column_Condition, Drop_Value);

		waitForElement(driver, FC_DischargeTerm);
		click(driver, FC_DischargeTerm);

		twoColumnSearchWindow(driver, DischargeTerm_Header, Two_Column_Condition, DischargeTerm_Value);

		waitForElement(driver, FC_ServiceCode_Search);
		click(driver, FC_ServiceCode_Search);

		twoColumnSearchWindow(driver, Service_Header, Two_Column_Condition, Service_Value);

		waitForElement(driver, FC_AmountInput);
		click(driver, FC_AmountInput);
		Newclear(driver, FC_AmountInput);
		sendKeys(driver, FC_AmountInput, AmountValue);

		Tab(driver);

		waitForElement(driver, FC_BasisDropdown);
		click(driver, FC_BasisDropdown);

		formatLocatorClick(driver, DropDown_Select, Basis_Option);

		selectDatePicker(driver, FC_ValidTo, ValidTo);

		selectDatePicker(driver, FC_ValidFrom, ValidFrom);

		waitForElement(driver, FC_POD_radiobutton);
		click(driver, FC_POD_radiobutton);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		reArrangeAG_GridColumns(driver, Filter_Columns);

		String gridPayable = getText(driver, FC_Grid_Payable);

		String gridLocation = getText(driver, FC_Grid_LocationToPay);

		if (Payable_Option.equals(gridPayable)) {

			System.out.println("Expected result || The selected payable option " + Payable_Option
					+ " should be displayed in the grid payable field || Actual result : The selected payable option "
					+ gridPayable + " was displayed in the grid payable field");
			Extent_pass_New(driver, "Expected result || The selected payable option " + Payable_Option
					+ " should be displayed in the grid payable field || Actual result : The selected payable option "
					+ gridPayable + " was displayed in the grid payable field", test, test1);

		} else {

			System.out.println("Expected result || The selected payable option " + Payable_Option
					+ " should be displayed in the grid payable field || Actual result : The selected payable option "
					+ gridPayable + " was not displayed in the grid payable field");
			Extent_fail(driver, "Expected result || The selected payable option " + Payable_Option
					+ " should be displayed in the grid payable field || Actual result : The selected payable option "
					+ gridPayable + " was not displayed in the grid payable field", test, test1);

		}

		if (POD_Value.equals(gridLocation)) {

			System.out.println("Expected result || The selected Location To Pay " + POD_Value
					+ " should be displayed in the grid LocationToPay || Actual result : The selected Location To Pay "
					+ gridLocation + " was displayed in the grid LocationToPay");
			Extent_pass_New(driver, "Expected result || The selected Location To Pay " + POD_Value
					+ " should be displayed in the grid LocationToPay || Actual result : The selected Location To Pay "
					+ gridLocation + " was displayed in the grid LocationToPay", test, test1);

		} else {

			System.out.println("Expected result || The selected Location To Pay " + POD_Value
					+ " should be displayed in the grid LocationToPay || Actual result : The selected Location To Pay "
					+ gridLocation + " was not displayed in the grid LocationToPay");
			Extent_fail(driver, "Expected result || The selected Location To Pay " + POD_Value
					+ " should be displayed in the grid LocationToPay || Actual result : The selected Location To Pay "
					+ gridLocation + " was not displayed in the grid LocationToPay", test, test1);

		}

		Step_End(5, "Click the POL in the Payat details", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
