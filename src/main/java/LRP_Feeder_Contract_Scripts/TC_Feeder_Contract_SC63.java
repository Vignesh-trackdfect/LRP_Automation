package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC63 extends Keywords {

	public void Feeder_Contract_SC63(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC63";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Search_By = Excel_data.get("Search_By");
		String FDR_Contract_Number = Excel_data.get("FDR_Contract_Number");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the global search option which is available in the tool bar.", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(2, "Click on the global search option which is available in the tool bar.", test, test1);
		Step_Start(3, "Check whether the system opens the contract details search window", test, test1);
		Step_Start(4, "Enter the saved fdr contract number in the contract number search field.  ", test, test1);
		Step_Start(5, "Click on the search button", test, test1);
		Step_Start(6, "System will show cotract details based on the Contarct number ", test, test1);
		Step_Start(7, "Double click the Contract detials.  ", test, test1);

		globalValueSearchWindow(driver, Global_Search_Condition, Search_By, FDR_Contract_Number, "", "", "", "");
		Step_End(3, "Check whether the system opens the contract details search window", test, test1);
		Step_End(4, "Enter the saved fdr contract number in the contract number search field.  ", test, test1);
		Step_End(5, "Click on the search button", test, test1);
		Step_End(6, "System will show cotract details based on the Contarct number ", test, test1);
		Step_End(7, "Double click the Contract detials.  ", test, test1);

		Step_Start(8, "Check whether the system retrieves the saved contract number.", test, test1);

		waitForElement(driver, FC_FDR_Contract_No_Textfield);
		String actual_FDR_ContractNumber = getAttribute(driver, FC_FDR_Contract_No_Textfield, "value");

		if (actual_FDR_ContractNumber.equals(FDR_Contract_Number)) {

			System.out.println("Matched || Expected FDR Contract Number : " + FDR_Contract_Number
					+ " || Actual FDR Contract Number : " + actual_FDR_ContractNumber);
			Extent_pass_New(driver, "Matched || Expected FDR Contract Number : " + FDR_Contract_Number
					+ " || Actual FDR Contract Number : " + actual_FDR_ContractNumber, test, test1);

		} else {

			System.out.println("Not Matched || Expected FDR Contract Number : " + FDR_Contract_Number
					+ " || Actual FDR Contract Number : " + actual_FDR_ContractNumber);
			Extent_fail(driver, "Not Matched || Expected FDR Contract Number : " + FDR_Contract_Number
					+ " || Actual FDR Contract Number : " + actual_FDR_ContractNumber, test, test1);

		}

		Step_End(8, "Check whether the system retrieves the saved contract number.", test, test1);
	
		Step_Start(9, "Click Document attach", test, test1);

		scrollTop(driver);
		waitForElement(driver, Attachement_Button_toolBar);
		click(driver, Attachement_Button_toolBar);

		waitForDisplay(driver, FC_Document_Attach_Window);
		if (isdisplayed(driver, FC_Document_Attach_Window)) {
			System.out.println(
					"Matched || Expected : Document Attachment Window should be displayed || Actual :  Document Attachment Window is displayed");
			Extent_pass_New(driver,
					"Matched || Expected : Document Attachment Window should be displayed || Actual :  Document Attachment Window is displayed",
					test, test1);
			click(driver, FC_Document_Attach_Window_Close);
		} else {
			System.out.println(
					"Not Matched || Expected : Document Attachment Window should be displayed || Actual :  Document Attachment Window is not displayed");
			Extent_fail(driver,
					"Not Matched || Expected : Document Attachment Window should be displayed || Actual :  Document Attachment Window is not displayed",
					test, test1);
		}

		Step_End(9, "Click Document attach", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
