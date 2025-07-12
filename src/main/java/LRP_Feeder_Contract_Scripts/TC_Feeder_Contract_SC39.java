package LRP_Feeder_Contract_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC39 extends Keywords {
	public void Feeder_Contract_SC39(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC39";

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
		String Currency_Code_Header = Excel_data.get("Currency_Code_Header");
		String Currency_Code_Value = Excel_data.get("Currency_Code_Value");
		String Grid_Header = Excel_data.get("Grid_Header");
		String Row_Values = Excel_data.get("Row_Values");
		String Edit_Rate_By = Excel_data.get("Edit_Rate_By");
		String Rates_Amount_Option = Excel_data.get("Rates_Amount_Option");
		String Rates_Amount_Input = Excel_data.get("Rates_Amount_Input");

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

		Step_Start(3, "Click on the \"+\" Button to add the all details", test, test1);

		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);

		Step_End(3, "Click on the '+' Button to add the all details ", test, test1);

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

		Step_Start(4, "Click on the POL and Select the Load loaction.", test, test1);

		waitForElement(driver, FC_POL_Search);
		click(driver, FC_POL_Search);

		twoColumnSearchWindow(driver, POL_Header, Two_Column_Condition, POL_Value);

		Step_End(4, "Click on the POL and Select the Load loaction.", test, test1);

		Step_Start(5, "Click on the POD and select the Discharge loction.", test, test1);

		waitForElement(driver, FC_POD_Search);
		click(driver, FC_POD_Search);

		twoColumnSearchWindow(driver, POD_Header, Two_Column_Condition, POD_Value);

		Step_End(5, "Click on the POD and select the Discharge loction.", test, test1);

		Step_Start(6, "lick on the PickupTerminal and Select the terminal based on the POL.", test, test1);

		waitForElement(driver, FC_PickupTerminal);
		click(driver, FC_PickupTerminal);

		twoColumnSearchWindow(driver, Pickup_Header, Two_Column_Condition, Pickup_Value);

		Step_End(6, "lick on the PickupTerminal and Select the terminal based on the POL.", test, test1);

		Step_Start(7, "Click on the Drop Terminal and select the Terminal based on the POD.", test, test1);

		waitForElement(driver, FC_DropTerminal);
		click(driver, FC_DropTerminal);

		twoColumnSearchWindow(driver, Drop_Header, Two_Column_Condition, Drop_Value);

		Step_End(7, "Click on the Drop Terminal and select the Terminal based on the POD.", test, test1);

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

		Step_Start(11, ".Click on the Eqp status drop down and Select the Status of the Equipment.", test, test1);

		waitForElement(driver, FC_EqpStatusDropdown);
		click(driver, FC_EqpStatusDropdown);

		formatLocatorClick(driver, DropDown_Select, EquipmentStatus);

		Step_End(11, ".Click on the Eqp status drop down and Select the Status of the Equipment.", test, test1);

		Step_Start(12, "Click on the Service code search button and select the Service code.", test, test1);

		waitForElement(driver, FC_ServiceCode_Search);
		click(driver, FC_ServiceCode_Search);

		twoColumnSearchWindow(driver, Service_Header, Two_Column_Condition, Service_Value);

		Step_End(12, "Click on the Service code search button and select the Service code.", test, test1);

		Step_Start(13, "Click on the Currency search button and select the Currency.", test, test1);

		waitForElement(driver, FC_CurrencySearch);
		click(driver, FC_CurrencySearch);

		twoColumnSearchWindow(driver, Currency_Code_Header, Two_Column_Condition, Currency_Code_Value);

		Step_End(13, "Click on the Currency search button and select the Currency.", test, test1);

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

		Step_End(15, "Click on the Negotiated By drop down and select the Value", test, test1);

		Step_Start(16, "Select the Basis while click the Drop down.", test, test1);

		waitForElement(driver, FC_BasisDropdown);
		click(driver, FC_BasisDropdown);

		formatLocatorClick(driver, DropDown_Select, Basis_Option);

		Step_End(16, "Select the Basis while click the Drop down.", test, test1);

		Step_Start(17, "Select the Duration type.", test, test1);

		waitForElement(driver, FC_DurationType);
		click(driver, FC_DurationType);

		formatLocatorClick(driver, DropDown_Select, DurationType);

		Step_End(17, "Select the Duration type.", test, test1);

		Step_Start(18, "Select the valid fromand valid to date ", test, test1);

		selectDatePicker(driver, FC_ValidTo, ValidTo);

		selectDatePicker(driver, FC_ValidFrom, ValidFrom);

		Step_End(18, "Select the valid fromand valid to date ", test, test1);

		Step_Start(19, "Click on the OK button", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		Step_End(19, "Click on the OK button", test, test1);

		Step_Start(20, ".Saved details show in the Feeder contract.", test, test1);

		waitForElement(driver, FC_Grid_Row);
		click(driver, FC_Grid_Row);

		waitForElement(driver, FC_Copy_Button);
		click(driver, FC_Copy_Button);

		waitForElement(driver, FC_Paste_Button);
		click(driver, FC_Paste_Button);

		List<WebElement> Boxes = listOfElements(driver, FC_Paste_Check_Boxes);
		for (int i = 0; i < Boxes.size(); i++) {
			String row = String.valueOf(i + 1);
			formatLocatorClick(driver, FC_Paste_Check_Box_Select, row);

		}
		formatLocatorClick(driver, FC_Paste_Check_Box, EquipmentType);

		waitForElement(driver, FC_Paste_Ok_Button);
		click(driver, FC_Paste_Ok_Button);

		Step_End(20, ".Saved details show in the Feeder contract.", test, test1);

		Step_Start(21, "Click Edit rate ,We can able edit the rate based on the Percentage,amount.", test, test1);

		reArrangeAG_GridColumns(driver, Grid_Header);

		formatLocatorClick(driver, FC_Grid_Row_First, Row_Values);

		waitForElement(driver, FC_Edit_Rate_Button);
		click(driver, FC_Edit_Rate_Button);

		// % select by start

		if (Edit_Rate_By.equals("Selected Rows")) {

			if (Rates_Amount_Option.equals("Increase Rates by %")) {

				String amount_get = formatLocatorGetText(driver, FC_Grid_Row_Amount, Row_Values);
				System.out.println("Amount_get (Row : ) " + amount_get);

				double amountValue = getNumberValue1(amount_get);
				double percentage = getNumberValue1(Rates_Amount_Input);

				double finalAmount = amountValue * (1 + (percentage / 100));

				System.out.println("Final Amount after adding " + percentage + "%: " + finalAmount);

				waitForElement(driver, FC_Selected_Rows_Button);
				click(driver, FC_Selected_Rows_Button);

				formatLocatorClick(driver, FC_Edit_Rates_Check_Box, Rates_Amount_Option);
				waitForElement(driver, FC_Increase_Rate_By);
				sendKeys(driver, FC_Increase_Rate_By, Rates_Amount_Input);

				waitForElement(driver, FC_Edit_Rates_OK_Button);
				click(driver, FC_Edit_Rates_OK_Button);

				reArrangeAG_GridColumns(driver, Grid_Header);

				String Act_amount_get = formatLocatorGetText(driver, FC_Grid_Row_Amount, Row_Values);
				double amountValue1 = getNumberValue1(Act_amount_get);
				System.out.println("Act_amount_get :" + amountValue1);

				if (amountValue1 == finalAmount) {
					System.out.println("Matched || Expected Equipment Value: " + finalAmount
							+ " || Actual Equipment Value: " + amountValue1);
					Extent_pass_New(driver, "Matched || Expected Equipment Value: " + finalAmount
							+ " || Actual Equipment Value: " + amountValue1, test, test1);
				} else {

					System.out.println("Not Matched || Expected Equipment Value: " + finalAmount
							+ " || Actual Equipment Value: " + amountValue1);
					Extent_fail(driver, "Not Matched || Expected Equipment Value: " + finalAmount
							+ " || Actual Equipment Value: " + amountValue1, test, test1);
				}

			} else if (Rates_Amount_Option.equals("Increase Rates by Amount")) {

				// % select by end

				// Amount increase select by start

				String amount_value = formatLocatorGetText(driver, FC_Grid_Row_Amount, Row_Values);
				System.out.println("Amount_get (Row : ) " + amount_value);

				double amount_Value_C = getNumberValue1(amount_value);
				double Amout_Test = getNumberValue1(Rates_Amount_Input);

				double final_Amount = amount_Value_C + Amout_Test;
				System.out.println("final_Amount :" + final_Amount);

				waitForElement(driver, FC_Increase_Rate_By_Amount);
				formatLocatorClick(driver, FC_Edit_Rates_Check_Box, Rates_Amount_Option);
				waitForElement(driver, FC_Increase_Rate_By_Amount);
				sendKeys(driver, FC_Increase_Rate_By_Amount, Rates_Amount_Input);

				waitForElement(driver, FC_Edit_Rates_OK_Button);
				click(driver, FC_Edit_Rates_OK_Button);

				reArrangeAG_GridColumns(driver, Grid_Header);

				String Act_amount_get1 = formatLocatorGetText(driver, FC_Grid_Row_Amount, Row_Values);
				double Act_amount_get_val = getNumberValue1(Act_amount_get1);
				System.out.println("Act_amount_get1 :" + Act_amount_get1);

				if (Act_amount_get_val == final_Amount) {
					System.out.println("Matched || Expected Equipment Value: " + final_Amount
							+ " || Actual Equipment Value: " + Act_amount_get_val);
					Extent_pass_New(driver, "Matched || Expected Equipment Value: " + final_Amount
							+ " || Actual Equipment Value: " + Act_amount_get_val, test, test1);
				} else {

					System.out.println("Not Matched || Expected Equipment Value: " + final_Amount
							+ " || Actual Equipment Value: " + Act_amount_get_val);
					Extent_fail(driver, "Not Matched || Expected Equipment Value: " + final_Amount
							+ " || Actual Equipment Value: " + Act_amount_get_val, test, test1);
				}

			} else if (Rates_Amount_Option.equals("Replace Rates to Amount")) {

				// Amount increase select by End

				// replace the amount start

				double Act_amount_Values = getNumberValue1(Rates_Amount_Input);
				System.out.println("Act_amount_Values:" + Act_amount_Values);

				formatLocatorClick(driver, FC_Edit_Rates_Check_Box, Rates_Amount_Option);
				waitForElement(driver, FC_Replace_Amout_Value);
				sendKeys(driver, FC_Replace_Amout_Value, Rates_Amount_Input);

				waitForElement(driver, FC_Edit_Rates_OK_Button);
				click(driver, FC_Edit_Rates_OK_Button);

				reArrangeAG_GridColumns(driver, Grid_Header);

				String Act_replace = formatLocatorGetText(driver, FC_Grid_Row_Amount, Row_Values);
				double Act_replace_Amount = getNumberValue1(Act_replace);
				System.out.println("Act_amount_get1 :" + Act_replace_Amount);

				if (Act_replace_Amount == Act_amount_Values) {
					System.out.println("Matched || Expected Equipment Value: " + Act_amount_Values
							+ " || Actual Equipment Value: " + Act_replace_Amount);
					Extent_pass_New(driver, "Matched || Expected Equipment Value: " + Act_amount_Values
							+ " || Actual Equipment Value: " + Act_replace_Amount, test, test1);
				} else {

					System.out.println("Not Matched || Expected Equipment Value: " + Act_amount_Values
							+ " || Actual Equipment Value: " + Act_replace_Amount);
					Extent_fail(driver, "Not Matched || Expected Equipment Value: " + Act_amount_Values
							+ " || Actual Equipment Value: " + Act_replace_Amount, test, test1);
				}

			}

		}

		List<Double> finalAmounts = new ArrayList<Double>();

		if (Edit_Rate_By.equals("All Rows")) {

			if (Rates_Amount_Option.equals("Increase Rates by %")) {

				List<WebElement> Grid_Rows_Amont = listOfElements(driver, FC_All_Rows_Grid);

				for (int i = 0; i < Grid_Rows_Amont.size(); i++) {

					String Row_all = String.valueOf(i);
					String amount_get = formatLocatorGetText(driver, FC_Grid_Row_Amount, Row_all);
					System.out.println("Amount_get (Row : ) " + Row_all);

					double amountValue = getNumberValue1(amount_get);
					double percentage = getNumberValue1(Rates_Amount_Input);

					double finalAmount = amountValue * (1 + (percentage / 100));
					finalAmounts.add(finalAmount);
					System.out.println("Final Amount after adding " + percentage + "%: " + finalAmount);

				}
				formatLocatorClick(driver, FC_Edit_Rates_Check_Box, Rates_Amount_Option);
				waitForElement(driver, FC_Increase_Rate_By);
				sendKeys(driver, FC_Increase_Rate_By, Rates_Amount_Input);
				waitForElement(driver, FC_Edit_Rates_OK_Button);
				click(driver, FC_Edit_Rates_OK_Button);

				reArrangeAG_GridColumns(driver, Grid_Header);

				List<WebElement> Act_Grid_Rows_Amont = listOfElements(driver, FC_All_Rows_Grid);

				for (int i = 0; i < Act_Grid_Rows_Amont.size(); i++) {

					String Act_Row_all = String.valueOf(i);
					String amount_get = formatLocatorGetText(driver, FC_Grid_Row_Amount, Act_Row_all);
					System.out.println("Amount_get (Row : ) " + Act_Row_all);

					double amountValue = getNumberValue1(amount_get);
					double percentage = getNumberValue1(Rates_Amount_Input);
					System.out.println("Final Amount after adding " + percentage + "%: " + amountValue);

					if (amountValue == finalAmounts.get(i)) {
						System.out.println("Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + amountValue);
						Extent_pass_New(driver, "Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + amountValue, test, test1);
					} else {

						System.out.println("Not Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + amountValue);
						Extent_fail(driver, "Not Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + amountValue, test, test1);
					}
				}
				// % select by end

			} else if (Rates_Amount_Option.equals("Increase Rates by Amount")) {

				List<WebElement> Grid_Rows_Amont = listOfElements(driver, FC_All_Rows_Grid);

				for (int i = 0; i < Grid_Rows_Amont.size(); i++) {

					String Row_all = String.valueOf(i);
					String amount_value = formatLocatorGetText(driver, FC_Grid_Row_Amount, Row_all);
					System.out.println("Amount_get (Row : ) " + amount_value);

					double amount_Value_C = getNumberValue1(amount_value);
					double Amout_Test = getNumberValue1(Rates_Amount_Input);

					double final_Amount = amount_Value_C + Amout_Test;
					System.out.println("final_Amount :" + final_Amount);
					finalAmounts.add(final_Amount);

				}
				// Amount increase select by start

				waitForElement(driver, FC_Increase_Rate_By_Amount);
				formatLocatorClick(driver, FC_Edit_Rates_Check_Box, Rates_Amount_Option);
				waitForElement(driver, FC_Increase_Rate_By_Amount);
				sendKeys(driver, FC_Increase_Rate_By_Amount, Rates_Amount_Input);

				waitForElement(driver, FC_Edit_Rates_OK_Button);
				click(driver, FC_Edit_Rates_OK_Button);

				reArrangeAG_GridColumns(driver, Grid_Header);

				List<WebElement> Act_Grid_Rows_Amont = listOfElements(driver, FC_All_Rows_Grid);
				for (int i = 0; i < Act_Grid_Rows_Amont.size(); i++) {

					String Act_Row_all = String.valueOf(i);
					String amount_get = formatLocatorGetText(driver, FC_Grid_Row_Amount, Act_Row_all);
					System.out.println("Amount_get (Row : ) " + Act_Row_all);

					double amountValue = getNumberValue1(amount_get);
					double percentage = getNumberValue1(Rates_Amount_Input);
					System.out.println("Final Amount after adding " + percentage + "%: " + amountValue);

					if (amountValue == finalAmounts.get(i)) {
						System.out.println("Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + amountValue);
						Extent_pass_New(driver, "Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + amountValue, test, test1);
					} else {

						System.out.println("Not Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + amountValue);
						Extent_fail(driver, "Not Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + amountValue, test, test1);
					}
				}

			} else if (Rates_Amount_Option.equals("Replace Rates to Amount")) {

				// Amount increase select by End

				// replace the amount start

				List<WebElement> Grid_Rows_Amont = listOfElements(driver, FC_All_Rows_Grid);

				for (int i = 0; i < Grid_Rows_Amont.size(); i++) {

					String Row_all = String.valueOf(i);
					String amount_value = formatLocatorGetText(driver, FC_Grid_Row_Amount, Row_all);
					System.out.println("Amount_get (Row : ) " + amount_value);

					double Amout_Test = getNumberValue1(Rates_Amount_Input);

					finalAmounts.add(Amout_Test);

				}

				formatLocatorClick(driver, FC_Edit_Rates_Check_Box, Rates_Amount_Option);
				sendKeys(driver, FC_Replace_Amout_Value, Rates_Amount_Input);

				waitForElement(driver, FC_Edit_Rates_OK_Button);
				click(driver, FC_Edit_Rates_OK_Button);

				reArrangeAG_GridColumns(driver, Grid_Header);

				List<WebElement> Act_Grid_Rows_Amont = listOfElements(driver, FC_All_Rows_Grid);
				for (int i = 0; i < Act_Grid_Rows_Amont.size(); i++) {

					String Act_Row_all = String.valueOf(i);
					String amount_get = formatLocatorGetText(driver, FC_Grid_Row_Amount, Act_Row_all);
					System.out.println("Amount_get (Row : ) " + Act_Row_all);

					double amountValue = getNumberValue1(amount_get);
					double percentage = getNumberValue1(Rates_Amount_Input);
					System.out.println("Final Amount after adding " + percentage + "%: " + amountValue);

					if (percentage == finalAmounts.get(i)) {
						System.out.println("Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + percentage);
						Extent_pass_New(driver, "Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + percentage, test, test1);
					} else {

						System.out.println("Not Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + percentage);
						Extent_fail(driver, "Not Matched || Expected Equipment Value: " + finalAmounts.get(i)
								+ " || Actual Equipment Value: " + percentage, test, test1);
					}
				}

			}

		}

		Step_End(21, "Click Edit rate ,We can able edit the rate based on the Percentage,amount.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
