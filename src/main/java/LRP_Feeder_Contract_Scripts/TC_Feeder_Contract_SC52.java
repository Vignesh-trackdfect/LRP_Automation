package LRP_Feeder_Contract_Scripts;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC52 extends Keywords {

	public void Feeder_Contract_SC52(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws AWTException {

		String testcase_Name = "TC_Feeder_Contract_SC52";

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
		String DG_Class_Header = Excel_data.get("DG_Class_Header");
		String DG_Charge_Type = Excel_data.get("DG_Charge_Type");
		String DG_Amount = Excel_data.get("DG_Amount");
		String DG_Class = Excel_data.get("DG_Class");
		String DGClassName_Header = Excel_data.get("DGClassName_Header");
		String DG_Classname_Value = Excel_data.get("DG_Classname_Value");
		String ApplyDg_Popup = Excel_data.get("ApplyDg_Popup");
		String Currency_Header = Excel_data.get("Currency_Header");
		String Currency_Value = Excel_data.get("Currency_Value");

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

		Step_End(3, "Click on the '+' Button to add the all details ", test, test1);

		Step_Start(4, "Click on the POL and Select the Load loaction.", test, test1);

		waitForElement(driver, FC_POL_Search);
		click(driver, FC_POL_Search);

		twoColumnSearchWindow(driver, POL_Header, Two_Column_Condition, POL_Value);

		Step_End(4, "Click on the POL and Select the Load loaction.", test, test1);

		Step_Start(5, "Click on the POD and select the Discharge location.", test, test1);

		waitForElement(driver, FC_POD_Search);
		click(driver, FC_POD_Search);

		twoColumnSearchWindow(driver, POD_Header, Two_Column_Condition, POD_Value);

		Step_End(5, "Click on the POD and select the Discharge location.", test, test1);

		Step_Start(6, "Click on the PickupTerminal and Select the terminal based on the POL.", test, test1);

		waitForElement(driver, FC_PickupTerminal);
		click(driver, FC_PickupTerminal);

		twoColumnSearchWindow(driver, Pickup_Header, Two_Column_Condition, Pickup_Value);

		Step_End(6, "Click on the PickupTerminal and Select the terminal based on the POL.", test, test1);

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

		Step_Start(9, "Click on the Discharge term search button and select the Terminal. ", test, test1);

		waitForElement(driver, FC_DischargeTerm);
		click(driver, FC_DischargeTerm);

		twoColumnSearchWindow(driver, DischargeTerm_Header, Two_Column_Condition, DischargeTerm_Value);

		Step_End(9, "Click on the Discharge term search button and select the Terminal. ", test, test1);

		Step_Start(10, "Click on the Equipment drop down and select the equipment type. ", test, test1);

		waitForElement(driver, FC_EquipmentDropdown);
		click(driver, FC_EquipmentDropdown);

		formatLocatorClick(driver, DropDown_Select, EquipmentType);

		Step_End(10, "Click on the Equipment drop down and select the equipment type. ", test, test1);

		Step_Start(11, "Click on the Eqp status drop down and Select the Status of the Equipment. ", test, test1);

		waitForElement(driver, FC_EqpStatusDropdown);
		click(driver, FC_EqpStatusDropdown);

		formatLocatorClick(driver, DropDown_Select, EquipmentStatus);

		Step_End(11, "Click on the Eqp status drop down and Select the Status of the Equipment. ", test, test1);

		Step_Start(12, "Click on the Service code search button and select the Service code. ", test, test1);

		waitForElement(driver, FC_ServiceCode_Search);
		click(driver, FC_ServiceCode_Search);

		twoColumnSearchWindow(driver, Service_Header, Two_Column_Condition, Service_Value);

		Step_End(12, "Click on the Service code search button and select the Service code. ", test, test1);

		Step_Start(13, "Click on the Currency search button and select the Currency . ", test, test1);

		waitForElement(driver, FC_CurrencySearch);
		click(driver, FC_CurrencySearch);

		twoColumnSearchWindow(driver, Currency_Header, Two_Column_Condition, Currency_Value);

		Step_End(13, "Click on the Currency search button and select the Currency . ", test, test1);

		Step_Start(14, ".Click on the amount field and enter the amount based on the currency. ", test, test1);

		waitForElement(driver, FC_AmountInput);
		click(driver, FC_AmountInput);
		Newclear(driver, FC_AmountInput);
		sendKeys(driver, FC_AmountInput, AmountValue);

		Tab(driver);

		Step_End(14, ".Click on the amount field and enter the amount based on the currency. ", test, test1);

		Step_Start(15, "Click on the Negotiated By drop down and select the Value . ", test, test1);

		waitForElement(driver, FC_NegotiatedBy_dropdown);
		click(driver, FC_NegotiatedBy_dropdown);

		formatLocatorClick(driver, DropDown_Select, NegotiatedBy);

		Step_End(15, "Click on the Negotiated By drop down and select the Value . ", test, test1);

		Step_Start(16, "Select the Basis while click the Drop down.", test, test1);

		waitForElement(driver, FC_BasisDropdown);
		click(driver, FC_BasisDropdown);

		formatLocatorClick(driver, DropDown_Select, Basis_Option);

		Step_End(16, "Select the Basis while click the Drop down. ", test, test1);

		Step_Start(17, "Select the Duration type ", test, test1);

		waitForElement(driver, FC_DurationType);
		click(driver, FC_DurationType);

		formatLocatorClick(driver, DropDown_Select, DurationType);

		Step_End(17, "Select the Duration type. ", test, test1);

		Step_Start(18, "Select the valid fromand valid to date . ", test, test1);

		selectDatePicker(driver, FC_ValidTo, ValidTo);

		selectDatePicker(driver, FC_ValidFrom, ValidFrom);

		waitForElement(driver, FC_POL_radiobutton);
		click(driver, FC_POL_radiobutton);

		Step_End(18, "Select the valid fromand valid to date  ", test, test1);

		Step_Start(19, "Click on the OK button ", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		Step_End(19, "Click on the OK button ", test, test1);

		Step_Start(20, "Saved details show in the Feeder contract. ", test, test1);


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

		Step_End(20, "Saved details show in the Feeder contract. ", test, test1);

		Step_Start(21, "Click the " + " in DG and select the DG code  ", test, test1);
		Step_Start(22, "Double click the amount in DG and Edit the amount.  ", test, test1);

		click(driver, AG_Grid_First_Row);

		waitForElement(driver, FC_Add_DG);
		click(driver, FC_Add_DG);

		twoColumnSearchWindowMultipleValue_multipleheader(driver, DG_Class_Header, Two_Column_Condition, DG_Class,
				DGClassName_Header, DG_Classname_Value);
		waitForElement(driver, FC_Add_DG);

		List<String> given_ChargeTypes = splitAndExpand(DG_Charge_Type);
		List<String> DGAmount = splitAndExpand(DG_Amount);

		int k = 0;

		for (String charge_Type : given_ChargeTypes) {

			waitForDisplay(driver, FC_DG_ChargeType);
			formatLocatorjsClick(driver, FC_DG_ChargeType, String.valueOf(k));

			formatLocatorClick(driver, DropDown_Select, charge_Type);

			String AmountInput = String.format(FC_DG_AmountInput, k);

			jsClick(driver, AmountInput);

			doubleClick(driver, AmountInput);

			sendKeysUsingRobot(DGAmount.get(k));

			Tab(driver);

			waitForDisplay(driver, FC_DG_Amountvaluefield);

			String Amountvalue_Field = String.format(FC_DG_Amountvaluefield, k);

			String changedamount = getText(driver, Amountvalue_Field);

			if (changedamount.equals(DGAmount.get(k))) {

				System.out.println(
						"Matched || Expected amount :" + DGAmount.get(k) + " || Actual amount :" + changedamount);

				Extent_pass_New(driver,
						"Matched || Expected amount :" + DGAmount.get(k) + " ||  Actual result : " + changedamount,
						test, test1);
			} else {

				System.out.println(
						"Not Matched || Expected amount :" + DGAmount.get(k) + " || Actual amount :" + changedamount);

				Extent_fail(driver,
						"Not Matched || Expected amount :" + DGAmount.get(k) + " || Actual amount :" + changedamount,
						test, test1);

			}

			k++;

		}

		Step_End(21, " Click the " + " in DG and select the DG code ", test, test1);

		Step_End(22, " Double click the amount in DG and Edit the amount. ", test, test1);

		Step_Start(23, "Select the Location pair details and click the Apply DG. ", test, test1);

		waitForElement(driver, FC_DG_Apply_Button);
		click(driver, FC_DG_Apply_Button);

		waitForPopup(driver, popup_Message, ApplyDg_Popup);

		String Actualpopup = getText(driver, popup_Message);

		if (ApplyDg_Popup.equals(Actualpopup)) {

			System.out.println("Matched || Expected popup message was : " + ApplyDg_Popup
					+ " || Actual popup message was : " + Actualpopup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + ApplyDg_Popup
					+ " || Actual popup message was : " + Actualpopup, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup message was : " + ApplyDg_Popup
					+ " || Actual popup message was : " + Actualpopup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + ApplyDg_Popup
					+ " || Actual popup message was : " + Actualpopup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(23, "Select the Location pair details and click the Apply DG. ", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}

}
