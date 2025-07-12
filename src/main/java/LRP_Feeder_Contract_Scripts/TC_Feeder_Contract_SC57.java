package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC57 extends Keywords {

	public void Feeder_Contract_SC57(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC57";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Feeder_Contract_No = Excel_data.get("Feeder_Contract_No");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the global search option which is available in the tool bar", test, test1);
		Step_Start(3, "Check whether the system opens the contract details search window", test, test1);
		Step_Start(4, "Enter the saved fdr contract number in the contract number search field.", test, test1);
		Step_Start(5, "Click on the search button.", test, test1);
		Step_Start(6, "System will show cotract details based on the Contarct number ", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Search_Condition, Select_field, Feeder_Contract_No, "", "", "", "");

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(6, "System will show cotract details based on the Contarct number ", test, test1);
		Step_End(5, "Click on the search button.", test, test1);
		Step_End(4, "Enter the saved fdr contract number in the contract number search field.", test, test1);
		Step_End(3, "Check whether the system opens the contract details search window", test, test1);
		Step_End(2, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(7, "System will show cotract details based on the Contarct number ", test, test1);

		waitForDisplay(driver, AG_Grid_First_Row);

		if (isdisplayed(driver, AG_Grid_First_Row)) {

			System.out.println(
					"Expected result : The system should show contract details based on contract number || Actual result : The system shows contract details based on contract number");
			Extent_pass_New(driver,
					"Expected result : The system should show contract details based on contract number || Actual result : The system shows contract details based on contract number",
					test, test1);
		} else {

			System.out.println(
					"Expected result : The system should show contract details based on contract number || Actual result : The system not shows contract details based on contract number");
			Extent_fail(driver,
					"Expected result : The system should show contract details based on contract number || Actual result : The system not shows contract details based on contract number",
					test, test1);

		}

		Step_End(7, "System will show cotract details based on the Contarct number ", test, test1);

		Step_Start(8, "Check whether the system retrieves the saved contract number", test, test1);

		waitForElement(driver, FC_Fdr_Contract_No);
		String FC_Fdr_Contract_Num = getAttribute(driver, FC_Fdr_Contract_No, "value");
		System.out.println(" Feeder Contract Number :" + FC_Fdr_Contract_Num);

		if (Feeder_Contract_No.equals(FC_Fdr_Contract_Num)) {
			Extent_pass(driver,
					"Matched || Expected : The System Retrieves Feeder Contract Number is: " + Feeder_Contract_No
							+ " || Actual : The System Retrieves Feeder saved Contract Number is : "
							+ FC_Fdr_Contract_Num,
					test, test1);
			System.out.println("Matched || Expected : The System Retrieves Feeder Contract Number is : "
					+ Feeder_Contract_No + " || Actual : The System Retrieves Feeder saved Contract Number is : "
					+ FC_Fdr_Contract_Num);
		} else {
			System.out.println("Not Matched || Expected : The System Retrieves Feeder Contract Number is : "
					+ Feeder_Contract_No + " || Actual : The System Retrieves Feeder saved Contract Number is : "
					+ FC_Fdr_Contract_Num);
			Extent_fail(driver,
					"Not Matched || Expected : The System Retrieves Feeder Contract Number is : " + Feeder_Contract_No
							+ " || Actual : The System Retrieves Feeder saved Contract Number is : "
							+ FC_Fdr_Contract_Num,
					test, test1);

		}

		Step_End(8, "Check whether the system retrieves the saved contract number", test, test1);

		Step_Start(9, "Click edit and select the New location pair", test, test1);

		waitForElement(driver, FC_New_Location_Pair);
		click(driver, FC_New_Location_Pair);

		Step_End(9, "Click edit and select the New location pair", test, test1);

		Step_Start(10, "Click copy the exsiting record and Paste the Feeder contract screen", test, test1);

		waitForDisplay(driver, FC_Copy_Button);

		if (isdisplayed(driver, FC_Copy_Button)) {
			System.out.println(
					"Expected result : Feeder contract copy the exsiting record should be displayed || Actual result : Feeder contract copy the exsiting record should be displayed ");
			Extent_pass_New(driver,
					"Expected result : Feeder contract copy the exsiting record should be displayed || Actual result : Feeder contract copy the exsiting record should be displayed ",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Feeder contract copy the exsiting record should be displayed || Actual result : Feeder contract copy the exsiting record should Not be displayed ");
			Extent_fail(driver,
					"Expected result : Feeder contract copy the exsiting record should be displayed || Actual result : Feeder contract copy the exsiting record should Not be displayed ",
					test, test1);

		}

		if (isdisplayed(driver, FC_Paste_Button)) {
			System.out.println(
					"Expected result : Feeder contract past the exsiting record should be displayed || Actual result : Feeder contract past the exsiting record should be displayed ");
			Extent_pass_New(driver,
					"Expected result : Feeder contract past the exsiting record should be displayed || Actual result : Feeder contract past the exsiting record should be displayed ",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Feeder contract past the exsiting record should be displayed || Actual result : Feeder contract past the exsiting record should not be displayed ");
			Extent_fail(driver,
					"Expected result : Feeder contract past the exsiting record should be displayed || Actual result : Feeder contract past the exsiting record should not be displayed ",
					test, test1);

		}

		Step_End(10, "Click copy the exsiting record and Paste the Feeder contract screen", test, test1);

	}
}
