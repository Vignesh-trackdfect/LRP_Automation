package LRP_Feeder_Contract_Scripts;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC48 extends Keywords {

	public void Feeder_Contract_SC48(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws AWTException {

		String testcase_Name = "TC_Feeder_Contract_SC48";

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
		String Pickup_Header = Excel_data.get("Pickup_Header");
		String Pickup_Value = Excel_data.get("Pickup_Value");
		String Drop_Header = Excel_data.get("Drop_Header");
		String Drop_Value = Excel_data.get("Drop_Value");
		String LoadTerm_Header = Excel_data.get("LoadTerm_Header");
		String LoadTerm_Value = Excel_data.get("LoadTerm_Value");
		String DischargeTerm_Header = Excel_data.get("DischargeTerm_Header");
		String DischargeTerm_Value = Excel_data.get("DischargeTerm_Value");
		String EquipmentType = Excel_data.get("EquipmentType");
		String EquipmentStatus = Excel_data.get("EquipmentStatus");
		String Service_Header = Excel_data.get("Service_Header");
		String Service_Value = Excel_data.get("Service_Value");
		String Currency_Header = Excel_data.get("Currency_Header");
		String Currency_Value = Excel_data.get("Currency_Value");
		String AmountValue = Excel_data.get("AmountValue");
		String NegotiatedBy = Excel_data.get("NegotiatedBy");
		String Negotiated_Date = Excel_data.get("Negotiated_Date");
		String Basis_Option = Excel_data.get("Basis_Option");
		String DurationType = Excel_data.get("DurationType");
		String ValidFrom = Excel_data.get("ValidFrom");
		String ValidTo = Excel_data.get("ValidTo");
		String Surcharge_Header = Excel_data.get("Surcharge_Header");
		String Surcharge_Value = Excel_data.get("Surcharge_Value");
		String Eqp_Behavior = Excel_data.get("Eqp_Behavior");
		String remove_popup = Excel_data.get("remove_popup");
		String remove_popup1 = Excel_data.get("remove_popup11");
		String Remove_Charge_Code = Excel_data.get("Remove_Charge_Code");

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

		Step_Start(4, "Click on the POL and Select the Load loaction", test, test1);

		waitForDisplay(driver, FC_DurationType);

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

		waitForElement(driver, FC_POL_Search);
		click(driver, FC_POL_Search);

		twoColumnSearchWindow(driver, POL_Header, Two_Column_Condition, POL_Value);

		Step_End(4, "Click on the POL and Select the Load loaction", test, test1);

		Step_Start(5, "Click on the POD and select the Discharge loction", test, test1);

		waitForElement(driver, FC_POD_Search);
		click(driver, FC_POD_Search);

		twoColumnSearchWindow(driver, POD_Header, Two_Column_Condition, POD_Value);

		Step_End(5, "Click on the POD and select the Discharge loction", test, test1);

		Step_Start(6, "Click on the PickupTerminal and Select the terminal based on the POL", test, test1);

		waitForElement(driver, FC_PickupTerminal);
		click(driver, FC_PickupTerminal);

		twoColumnSearchWindow(driver, Pickup_Header, Two_Column_Condition, Pickup_Value);

		Step_End(6, "Click on the PickupTerminal and Select the terminal based on the POL", test, test1);

		Step_Start(7, "Click on the Drop Terminal and select the Terminal based on the POD", test, test1);

		waitForElement(driver, FC_DropTerminal);
		click(driver, FC_DropTerminal);

		twoColumnSearchWindow(driver, Drop_Header, Two_Column_Condition, Drop_Value);

		Step_End(7, "Click on the Drop Terminal and select the Terminal based on the POD", test, test1);

		Step_Start(8, "Click on the Load term search button and select the Terminal ", test, test1);

		waitForElement(driver, FC_Load_Term);
		click(driver, FC_Load_Term);

		twoColumnSearchWindow(driver, LoadTerm_Header, Two_Column_Condition, LoadTerm_Value);

		Step_End(8, "Click on the Load term search button and select the Terminal ", test, test1);

		Step_Start(9, "Click on the Discharge term search button and select the Terminal", test, test1);

		waitForElement(driver, FC_DischargeTerm);
		click(driver, FC_DischargeTerm);

		twoColumnSearchWindow(driver, DischargeTerm_Header, Two_Column_Condition, DischargeTerm_Value);

		Step_End(9, "Click on the Discharge term search button and select the Terminal", test, test1);

		Step_Start(10, ".Click on the Equipment drop down and select the equipment type", test, test1);

		waitForElement(driver, FC_EquipmentDropdown);
		click(driver, FC_EquipmentDropdown);

		formatLocatorClick(driver, DropDown_Select, EquipmentType);

		Step_End(10, ".Click on the Equipment drop down and select the equipment type", test, test1);

		Step_Start(11, "Click on the Eqp status drop down and Select the Status of the Equipment.", test, test1);

		waitForElement(driver, FC_EqpStatusDropdown);
		click(driver, FC_EqpStatusDropdown);

		formatLocatorClick(driver, DropDown_Select, EquipmentStatus);

		Step_End(11, "Click on the Eqp status drop down and Select the Status of the Equipment.", test, test1);

		Step_Start(12, "Click on the Service code search button and select the Service code", test, test1);

		waitForElement(driver, FC_ServiceCode_Search);
		click(driver, FC_ServiceCode_Search);

		twoColumnSearchWindow(driver, Service_Header, Two_Column_Condition, Service_Value);

		Step_End(12, "Click on the Service code search button and select the Service code", test, test1);

		Step_Start(13, "Click on the Currency search button and select the Currency", test, test1);

		waitForElement(driver, FC_CurrencySearch);
		click(driver, FC_CurrencySearch);

		twoColumnSearchWindow(driver, Currency_Header, Two_Column_Condition, Currency_Value);

		Step_End(13, "Click on the Currency search button and select the Currency", test, test1);

		Step_Start(14, "Click on the amount field and enter the amount based on the currency.", test, test1);

		waitForElement(driver, FC_AmountInput);
		click(driver, FC_AmountInput);
		Newclear(driver, FC_AmountInput);
		sendKeys(driver, FC_AmountInput, AmountValue);

		Tab(driver);

		Step_End(14, "Click on the amount field and enter the amount based on the currency.", test, test1);

		Step_Start(15, "Click on the Negotiated By drop down and select the Value", test, test1);

		waitForElement(driver, FC_NegotiatedBy_dropdown);
		click(driver, FC_NegotiatedBy_dropdown);

		formatLocatorClick(driver, DropDown_Select, NegotiatedBy);

		if (!Negotiated_Date.equals("")) {

			selectDatePicker(driver, FC_NegotiatedOn, Negotiated_Date);

		}

		Step_End(15, "Click on the Negotiated By drop down and select the Value", test, test1);

		Step_Start(16, "Select the Basis while click the Drop downe", test, test1);

		waitForElement(driver, FC_BasisDropdown);
		click(driver, FC_BasisDropdown);

		formatLocatorClick(driver, DropDown_Select, Basis_Option);

		Step_End(16, "Select the Basis while click the Drop downe", test, test1);

		Step_Start(17, "Select the Duration type", test, test1);

		waitForElement(driver, FC_DurationType);
		click(driver, FC_DurationType);

		formatLocatorClick(driver, DropDown_Select, DurationType);

		Step_End(17, "Select the Duration type", test, test1);

		Step_Start(18, "Select the valid fromand valid to date", test, test1);

		selectDatePicker(driver, FC_ValidTo, ValidTo);

		selectDatePicker(driver, FC_ValidFrom, ValidFrom);

		Step_End(18, "Select the valid fromand valid to date", test, test1);

		Step_Start(19, "Click on the OK button", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		Step_End(19, "Click on the OK button", test, test1);

		Step_Start(20, "Saved details show in the Feeder contract.", test, test1);

		waitForDisplay(driver, AG_Grid_First_Row);

		if (isdisplayed(driver, AG_Grid_First_Row)) {

			System.out.println(
					"Expected result : The given values should be added in the grid || Actual result : The given values are added in the grid");
			Extent_pass_New(driver,
					"Expected result : The given values should be added in the grid || Actual result : The given values are added in the grid",
					test, test1);
		} else {

			System.out.println(
					"Expected result : The given values should be added in the grid || Actual result : The given values are not added in the grid");
			Extent_fail(driver,
					"Expected result : The given values should be added in the grid || Actual result : The given values are not added in the grid",
					test, test1);

		}

		Step_End(20, "Saved details show in the Feeder contract.", test, test1);

		Step_Start(21, "Click the '+' in surcharge and select the Charge code .", test, test1);

		click(driver, AG_Grid_First_Row);

		waitForElement(driver, FC_AddDischarge);
		click(driver, FC_AddDischarge);

		twoColumnSearchWindowMultipleValue(driver, Surcharge_Header, Two_Column_Condition, Surcharge_Value);

		waitForElement(driver, FC_AddDischarge);

		Step_End(21, "Click the '+' in surcharge and select the Charge code .", test, test1);

		Step_Start(22, "Click and select the EQP behaviour.", test, test1);

		List<String> Eqp_Behaviors = splitAndExpand(Eqp_Behavior);

		int i = 0;

		for (String EqpBehavior : Eqp_Behaviors) {

			waitForDisplay(driver, FC_Eqp_Dropdown);
			formatLocatorjsClick(driver, FC_Eqp_Dropdown, String.valueOf(i));

			formatLocatorClick(driver, DropDown_Select, EqpBehavior);

			Tab(driver);

			String selctedeqpoption = String.format(FC_Selected_Eqp, String.valueOf(i));

			String SelectedEqp = getText(driver, selctedeqpoption);

			if (SelectedEqp.equals(EqpBehavior)) {

				System.out.println("Expected result : The Eqp behavior " + EqpBehavior
						+ " should be selected || Actual result : The Eqp behavior " + SelectedEqp + " was selected");
				Extent_pass_New(driver, "Expected result : The Eqp behavior " + EqpBehavior
						+ " should be selected || Actual result : The Eqp behavior " + SelectedEqp + " was selected",
						test, test1);
			} else {
				System.out.println("Expected result : The Eqp behavior " + EqpBehavior
						+ " should be selected || Actual result : Different Eqp behavior " + SelectedEqp
						+ " was selected");
				Extent_fail(driver,
						"Expected result : The Eqp behavior " + EqpBehavior
								+ " should be selected || Actual result : Different Eqp behavior " + SelectedEqp
								+ " was selected",
						test, test1);
			}

			i++;

		}

		Step_Start(23,
				".Click the \"\"-\"\" The surcharge should deleted.Click the remove surcharge,It should be remove from the Loaction pair details.",
				test, test1);
		List<String> surcharge_Value = splitAndExpand(Remove_Charge_Code);

		for (String surcharge : surcharge_Value) {
			if (surcharge != null && !surcharge.trim().isEmpty()) {

				String added = formatLocatorClick(driver, Surcharge_gird_value_FC, surcharge);
				waitForDisplay(driver, added);

				click(driver, added);
				waitForElement(driver, FC_Remove_Surcharge_Button);
				click(driver, FC_Remove_Surcharge_Button);

				waitForElement(driver, popup_Message);
				String remove_popup_Act = getText(driver, popup_Message);
				System.out.println(remove_popup_Act);

				if (remove_popup.equals(remove_popup_Act)) {
					System.out.println("Expected Popup is :" + remove_popup + " Actual Popup Is : " + remove_popup_Act);
					Extent_pass_New(driver,
							"Expected Popup is :" + remove_popup + " Actual Popup Is  : " + remove_popup_Act, test,
							test1);
				} else {
					System.out
							.println("Expected Popup is :" + remove_popup + " Actual Popup Is  : " + remove_popup_Act);
					Extent_fail(driver,
							"Expected Popup is :" + remove_popup + " Actual Popup Is  : " + remove_popup_Act, test,
							test1);
				}

				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);

				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					String remove_popup_Act1 = getText(driver, popup_Message);
					System.out.println(remove_popup_Act1);

					if (remove_popup1.equals(remove_popup_Act1)) {
						System.out.println(
								"Expected Popup is :" + remove_popup1 + " Actual Popup Is : " + remove_popup_Act1);
						Extent_pass_New(driver,
								"Expected Popup is :" + remove_popup1 + " Actual Popup Is  : " + remove_popup_Act1,
								test, test1);
					} else {
						System.out.println(
								"Expected Popup is :" + remove_popup1 + " Actual Popup Is  : " + remove_popup_Act1);
						Extent_fail(driver,
								"Expected Popup is :" + remove_popup1 + " Actual Popup Is  : " + remove_popup_Act1,
								test, test1);
					}

					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);

				}

				// Step 4: Check if displayed and perform mouse over
				if (!isdisplayed(driver, added)) {
					System.out.println("Expected result : The selected charged code " + surcharge
							+ " should be removed Charge code was removed: Actual result : The surchage code "
							+ surcharge + "was removed");
					Extent_pass(driver,
							"Expected result : The selected charged code " + surcharge
									+ " should be removed Charge code was removed: Actual result : The surchage code "
									+ surcharge + "was removed",
							test, test1);
				} else {
					System.out.println("Expected result : The selected charged code " + surcharge
							+ " should be removed Charge code was removed: Actual result : The surchage code "
							+ surcharge + "was not removed");
					Extent_fail(driver,
							"Expected result : The selected charged code " + surcharge
									+ " should be removed Charge code was removed: Actual result : The surchage code "
									+ surcharge + "was not removed",
							test, test1);
				}
			}
		}

		Step_End(23,
				".Click the \"\"-\"\" The surcharge should deleted.Click the remove surcharge,It should be remove from the Loaction pair details.",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
