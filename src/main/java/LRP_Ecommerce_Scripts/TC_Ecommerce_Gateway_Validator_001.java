package LRP_Ecommerce_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_001 extends Keywords {

	public void Ecommerce_Gateway_Validator_001(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_001";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String ALL_Transaction = Excel_data.get("ALL_Transaction");
		String Booking_Transaction = Excel_data.get("Booking_Transaction");
		String SI_Transaction = Excel_data.get("SI_Transaction");
		String ALL_Reference_Number = Excel_data.get("ALL_Reference_Number");
		String Filter_Headers = Excel_data.get("Filter_Headers");
		String Booking_Reference_Number = Excel_data.get("Booking_Reference_Number");
		String SI_Reference_Number = Excel_data.get("SI_Reference_Number");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Module_Name);

		Step_Start(1,
				"Click the transaction type dropdown and select all, booking, and SI options in the e-commerce gateway",
				test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForElement(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, ALL_Transaction);

		waitForElement(driver, EG_Transaction_type);
		String Selected_transaction = getText(driver, EG_Transaction_type);

		if (Selected_transaction.equals(ALL_Transaction)) {
			System.out.println(
					"Expected : All Transaction Type Should be selected in the Transaction type dropdown || Actual : All Transaction Type is selected in the Transaction type dropdown");
			Extent_pass_New(driver,
					"Expected : All Transaction Type Should be selected in the Transaction type dropdown || Actual : All Transaction Type is selected in the Transaction type dropdown",
					test, test1);
		} else {
			System.out.println(
					"Expected : All Transaction Type Should be selected in the Transaction type dropdown || Actual : All Transaction Type is not selected in the Transaction type dropdown");
			Extent_fail(driver,
					"Expected : All Transaction Type Should be selected in the Transaction type dropdown || Actual : All Transaction Type is not selected in the Transaction type dropdown",
					test, test1);
		}

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForElement(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, Booking_Transaction);

		waitForElement(driver, EG_Transaction_type);
		String Selected_transaction2 = getText(driver, EG_Transaction_type);

		if (Selected_transaction2.equals(Booking_Transaction)) {
			System.out.println(
					"Expected : Booking Transaction Type Should be selected in the Transaction type dropdown || Actual : Booking Transaction Type is selected in the Transaction type dropdown");
			Extent_pass_New(driver,
					"Expected : Booking Transaction Type Should be selected in the Transaction type dropdown || Actual : Booking Transaction Type is selected in the Transaction type dropdown",
					test, test1);
		} else {
			System.out.println(
					"Expected : Booking Transaction Type Should be selected in the Transaction type dropdown || Actual : Booking Transaction Type is not selected in the Transaction type dropdown");
			Extent_fail(driver,
					"Expected : Booking Transaction Type Should be selected in the Transaction type dropdown || Actual : Booking Transaction Type is not selected in the Transaction type dropdown",
					test, test1);
		}

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForElement(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, SI_Transaction);

		waitForElement(driver, EG_Transaction_type);
		String Selected_transaction3 = getText(driver, EG_Transaction_type);

		if (Selected_transaction3.equals(SI_Transaction)) {
			System.out.println(
					"Expected : SI Transaction Type should be selected in the Transaction type dropdown || Actual : SI Transaction Type is selected in the Transaction type dropdown");
			Extent_pass_New(driver,
					"Expected : SI Transaction Type should be selected in the Transaction type dropdown || Actual : SI Transaction Type is selected in the Transaction type dropdown",
					test, test1);
		} else {
			System.out.println(
					"Expected : SI Transaction Type should be selected in the Transaction type dropdown || Actual : SI Transaction Type is not selected in the Transaction type dropdown");
			Extent_fail(driver,
					"Expected : SI Transaction Type should be selected in the Transaction type dropdown || Actual : SI Transaction Type is not selected in the Transaction type dropdown",
					test, test1);
		}

		Step_End(1,
				"Click the transaction type dropdown and select all, booking, and SI options in the e-commerce gateway",
				test, test1);

		Step_Start(2,
				"Select all in the transaction type and click the refresh button. Booking and SI records should show up in the grid",
				test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForElement(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, ALL_Transaction);

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_ConditionFilter);
		click(driver, EG_ConditionFilter);

		waitForElement(driver, EG_SourceName_FilterInput);
		sendKeys(driver, EG_SourceName_FilterInput, Booking_Transaction);

		waitForElement(driver, EG_SourceName_FilterInput);

		boolean flag = true;

		if (isdisplayed(driver, EG_SourceName)) {

			flag = true;

		} else {

			flag = false;
		}

		waitForElement(driver, EG_SourceName_FilterInput);
		clear(driver, EG_SourceName_FilterInput);
		sendKeys(driver, EG_SourceName_FilterInput, SI_Transaction);

		waitForElement(driver, EG_SourceName_FilterInput);

		if (isdisplayed(driver, EG_SourceName)) {

			flag = true;

		} else {

			flag = false;
		}

		if (flag == true) {

			System.out.println(
					"Expected : After select the All Transaction type, All the transactions should be displayed in the Grid || Actual : After select the All Transaction type, All the transactions are displayed in the Grid");
			Extent_pass_New(driver,
					"Expected : After select the All Transaction type, All the transactions should be displayed in the Grid || Actual : After select the All Transaction type, All the transactions are displayed in the Grid",
					test, test1);
		} else {
			System.out.println(
					"Expected : After select the All Transaction type, All the transactions should be displayed in the Grid || Actual : After select the All Transaction type, All the transactions are not displayed in the Grid");
			Extent_fail(driver,
					"Expected : After select the All Transaction type, All the transactions should be displayed in the Grid || Actual : After select the All Transaction type, All the transactions are not displayed in the Grid",
					test, test1);

		}

		Step_End(2,
				"Select all in the transaction type and click the refresh button. Booking and SI records should show up in the grid",
				test, test1);

		Step_Start(3,
				"Select booking in the transaction type and click the refresh button. Booking records should show up in the grid",
				test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForElement(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, Booking_Transaction);

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Refresh);

		List<WebElement> Source_Names = listOfElements(driver, EG_SourceName);

		for (WebElement element : Source_Names) {

			moveToElement(driver, element);

			String sourcename = element.getText();

			String TransactionType = Booking_Transaction.toUpperCase();

			if (sourcename.contains(TransactionType)) {

				System.out.println(
						"Expected : After select the Transaction Type as 'Booking', Booking transaction details should be displayed || Actual : After select the Transaction Type as 'Booking', Booking transaction details are displayed in the grid and the displayed Source name was : "
								+ sourcename);
				Extent_pass_New(driver,
						"Expected : After select the Transaction Type as 'Booking', Booking transaction details should be displayed || Actual : After select the Transaction Type as 'Booking', Booking transaction details are displayed in the grid and the displayed Source name was : "
								+ sourcename,
						test, test1);
			} else {
				System.out.println(
						"Expected : After select the Transaction Type as 'Booking', Booking transaction details should be displayed || Actual : After select the Transaction Type as 'Booking', Booking transaction details are not displayed in the grid and the displayed Source name was : "
								+ sourcename);
				Extent_fail(driver,
						"Expected : After select the Transaction Type as 'Booking', Booking transaction details should be displayed || Actual : After select the Transaction Type as 'Booking', Booking transaction details are not displayed in the grid and the displayed Source name was : "
								+ sourcename,
						test, test1);
			}

		}

		Step_End(3,
				"Select booking in the transaction type and click the refresh button. Booking records should show up in the grid",
				test, test1);

		Step_Start(4,
				"Select SI in the transaction type and click the refresh button. SI records should show up in the grid",
				test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForElement(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, SI_Transaction);

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Refresh);

		List<WebElement> Source_Names2 = listOfElements(driver, EG_SourceName);

		for (WebElement element : Source_Names2) {

			waitForElement(driver, element);

			moveToElement(driver, element);

			String sourcename = element.getText();

			String TransactionType = SI_Transaction.toUpperCase();

			if (sourcename.contains(TransactionType)) {

				System.out.println(
						"Expected : After select the Transaction Type as 'SI', SI transaction details should be displayed || Actual : After select the Transaction Type as 'SI', SI transaction details are displayed in the grid and the displayed Source name was : "
								+ sourcename);
				Extent_pass_New(driver,
						"Expected : After select the Transaction Type as 'SI', SI transaction details should be displayed || Actual : After select the Transaction Type as 'SI', SI transaction details are displayed in the grid and the displayed Source name was : "
								+ sourcename,
						test, test1);
			} else {
				System.out.println(
						"Expected : After select the Transaction Type as 'SI', SI transaction details should be displayed || Actual : After select the Transaction Type as 'SI', SI transaction details are not displayed in the grid and the displayed Source name was : "
								+ sourcename);
				Extent_fail(driver,
						"Expected : After select the Transaction Type as 'SI', SI transaction details should be displayed || Actual : After select the Transaction Type as 'SI', SI transaction details are not displayed in the grid and the displayed Source name was : "
								+ sourcename,
						test, test1);
			}
		}

		Step_End(4,
				"Select SI in the transaction type and click the refresh button. SI records should show up in the grid",
				test, test1);

		Step_Start(5,
				"Select all in the transaction type, enter the reference number, and click the refresh button. Booking and SI records should be shown based on the transaction type",
				test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForElement(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, ALL_Transaction);

		waitForElement(driver, EG_ReferenceNo_Input);
		sendKeys(driver, EG_ReferenceNo_Input, ALL_Reference_Number);

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Refresh);

		reArrangeAG_GridColumnsNew(driver, AG_Grid_Columns_Button_DW, Filter_Headers);

		List<WebElement> Ref_No = listOfElements(driver, EG_ReferenceNo);

		for (WebElement element : Ref_No) {

			waitForElement(driver, element);

			moveToElement(driver, element);

			String ReferenceNum = element.getText();

			if (ReferenceNum.equals(ALL_Reference_Number)) {

				System.out.println("Selected Reference Numbers transaction details are displayed || Expected number : "
						+ ALL_Reference_Number + " || Actual Number : " + ReferenceNum);
				Extent_pass_New(driver, "Selected Reference Numbers transaction details are displayed || Expected number : "
						+ ALL_Reference_Number + " || Actual Number : " + ReferenceNum, test, test1);

			} else {

				System.out.println(
						"Selected Reference Numbers transaction details are not displayed || Expected number : "
								+ ALL_Reference_Number + " || Actual Number : " + ReferenceNum);
				Extent_fail(driver,
						"Selected Reference Numbers transaction details are not displayed || Expected number : "
								+ ALL_Reference_Number + " || Actual Number : " + ReferenceNum,
						test, test1);
			}

		}

		Step_End(5,
				"Select all in the transaction type, enter the reference number, and click the refresh button. Booking and SI records should be shown based on the transaction type",
				test, test1);

		Step_Start(6,
				"Select booking in the transaction type, enter the reference number, and click the refresh button. Booking records should be shown based on the transaction type",
				test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForElement(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, Booking_Transaction);

		waitForElement(driver, EG_ReferenceNo_Input);
		clear(driver, EG_ReferenceNo_Input);
		sendKeys(driver, EG_ReferenceNo_Input, Booking_Reference_Number);

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Refresh);

		reArrangeAG_GridColumnsNew(driver, AG_Grid_Columns_Button_DW, Filter_Headers);

		List<WebElement> Booking_Ref_No = listOfElements(driver, EG_ReferenceNo);

		for (WebElement element : Booking_Ref_No) {

			waitForElement(driver, element);

			moveToElement(driver, element);

			String ReferenceNum = element.getText();

			if (ReferenceNum.equals(Booking_Reference_Number)) {

				System.out.println("Selected Reference Numbers transaction details are displayed || Expected number : "
						+ Booking_Reference_Number + " || Actual Number : " + ReferenceNum);
				Extent_pass_New(driver, "Selected Reference Numbers transaction details are displayed || Expected number : "
						+ Booking_Reference_Number + " || Actual Number : " + ReferenceNum, test, test1);

			} else {

				System.out.println(
						"Selected Reference Numbers transaction details are not displayed || Expected number : "
								+ Booking_Reference_Number + " || Actual Number : " + ReferenceNum);
				Extent_fail(driver,
						"Selected Reference Numbers transaction details are not displayed || Expected number : "
								+ Booking_Reference_Number + " || Actual Number : " + ReferenceNum,
						test, test1);
			}

		}

		Step_End(6,
				"Select booking in the transaction type, enter the reference number, and click the refresh button. Booking records should be shown based on the transaction type",
				test, test1);

		Step_Start(7,
				"Select SI in the transaction type, enter the reference number, and click the refresh button. SI records should be shown based on the transaction type",
				test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForElement(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, SI_Transaction);

		waitForElement(driver, EG_ReferenceNo_Input);
		clear(driver, EG_ReferenceNo_Input);
		sendKeys(driver, EG_ReferenceNo_Input, SI_Reference_Number);

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Refresh);

		reArrangeAG_GridColumnsNew(driver, AG_Grid_Columns_Button_DW, Filter_Headers);

		List<WebElement> SI_Ref_No = listOfElements(driver, EG_ReferenceNo);

		for (WebElement element : SI_Ref_No) {

			waitForElement(driver, element);

			moveToElement(driver, element);

			String ReferenceNum = element.getText();

			if (ReferenceNum.equals(SI_Reference_Number)) {

				System.out.println("Selected Reference Numbers transaction details are displayed || Expected number : "
						+ SI_Reference_Number + " || Actual Number : " + ReferenceNum);
				Extent_pass_New(driver, "Selected Reference Numbers transaction details are displayed || Expected number : "
						+ SI_Reference_Number + " || Actual Number : " + ReferenceNum, test, test1);

			} else {

				System.out.println(
						"Selected Reference Numbers transaction details are not displayed || Expected number : "
								+ SI_Reference_Number + " || Actual Number : " + ReferenceNum);
				Extent_fail(driver,
						"Selected Reference Numbers transaction details are not displayed || Expected number : "
								+ SI_Reference_Number + " || Actual Number : " + ReferenceNum,
						test, test1);
			}

		}

		Step_End(7,
				"Select SI in the transaction type, enter the reference number, and click the refresh button. SI records should be shown based on the transaction type",
				test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
