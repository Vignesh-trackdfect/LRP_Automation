package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC65 extends Keywords {

	public void Feeder_Contract_SC65(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC65";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Search_By = Excel_data.get("Search_By");
		String FDR_Contract_Number = Excel_data.get("FDR_Contract_Number");
		String POL_Port_Code = Excel_data.get("POL_Port_Code");
		String Want_To_Remove_Popup = Excel_data.get("Want_To_Remove_Popup");
		String Updated_Popup = Excel_data.get("Updated_Popup");

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
		Step_Start(4, "Enter the saved Popup in the contract number search field.  ", test, test1);
		Step_Start(5, "Click on the search button", test, test1);
		Step_Start(6, "System will show cotract details based on the Contarct number ", test, test1);
		Step_Start(7, "Double click the Contract detials.  ", test, test1);

		globalValueSearchWindow(driver, Global_Search_Condition, Search_By, FDR_Contract_Number, "", "", "", "");
		Step_End(3, "Check whether the system opens the contract details search window", test, test1);
		Step_End(4, "Enter the saved Popup in the contract number search field.  ", test, test1);
		Step_End(5, "Click on the search button", test, test1);
		Step_End(6, "System will show cotract details based on the Contarct number ", test, test1);
		Step_End(7, "Double click the Contract detials.  ", test, test1);

		Step_Start(8, "Check whether the system retrieves the saved contract number.", test, test1);

		waitForElement(driver, FC_FDR_Contract_No_Textfield);
		String actual_FDR_ContractNumber = getAttribute(driver, FC_FDR_Contract_No_Textfield, "value");

		if (actual_FDR_ContractNumber.equals(FDR_Contract_Number)) {

			System.out.println(
					"Matched ||  Popup : " + FDR_Contract_Number + " || Actual Popup : " + actual_FDR_ContractNumber);
			Extent_pass_New(driver,
					"Matched ||  Popup : " + FDR_Contract_Number + " || Actual Popup : " + actual_FDR_ContractNumber,
					test, test1);

		} else {

			System.out.println("Not Matched ||  Popup : " + FDR_Contract_Number + " || Actual Popup : "
					+ actual_FDR_ContractNumber);
			Extent_fail(driver, "Not Matched ||  Popup : " + FDR_Contract_Number + " || Actual Popup : "
					+ actual_FDR_ContractNumber, test, test1);

		}

		Step_End(8, "Check whether the system retrieves the saved contract number.", test, test1);
		Step_Start(9, "Double click the Exsiting record", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, FC_AG_Grid_Total_Records);
		String totalRecords_Before_Remove = getText(driver, FC_AG_Grid_Total_Records);

		waitForElement(driver, FC_AG_Grid_Filter_Button);
		click(driver, FC_AG_Grid_Filter_Button);

		waitForElement(driver, AG_Grid_POL_Filter_Searchfield);
		sendKeys(driver, AG_Grid_POL_Filter_Searchfield, POL_Port_Code);

		waitForElement(driver, FC_AG_Grid_Cell);
		click(driver, FC_AG_Grid_Cell);

		Step_End(9, "Double click the Exsiting record", test, test1);
		Step_Start(10, "Click Remove", test, test1);

		waitForElement(driver, FC_Remove_Button);
		click(driver, FC_Remove_Button);

		waitForPopup(driver, popup_Message, Want_To_Remove_Popup);
		String actual_Popup = getText(driver, popup_Message);

		if (actual_Popup.equals(Want_To_Remove_Popup)) {

			System.out.println("Matched ||  Popup : " + Want_To_Remove_Popup + " || Actual Popup : " + actual_Popup);
			Extent_pass_New(driver,
					"Matched ||  Popup : " + Want_To_Remove_Popup + " || Actual Popup : " + actual_Popup, test, test1);
			click(driver, popup_Message_Yes_Button);
		} else {

			System.out
					.println("Not Matched ||  Popup : " + Want_To_Remove_Popup + " || Actual Popup : " + actual_Popup);
			Extent_fail(driver,
					"Not Matched ||  Popup : " + Want_To_Remove_Popup + " || Actual Popup : " + actual_Popup, test,
					test1);

		}

		waitForElement(driver, FC_AG_Grid_Total_Records);
		String totalRecords_After_Remove = getText(driver, FC_AG_Grid_Total_Records);

		if (!totalRecords_After_Remove.equals(totalRecords_Before_Remove)) {

			System.out.println("Matched ||  No of records : " + totalRecords_Before_Remove + " ||  No of records : "
					+ totalRecords_After_Remove);
			Extent_pass_New(driver, "Matched ||  No of records : " + totalRecords_Before_Remove
					+ " ||  No of records : " + totalRecords_After_Remove, test, test1);
		} else {

			System.out.println("Not Matched ||  No of records : " + totalRecords_Before_Remove + " ||  No of records : "
					+ totalRecords_After_Remove);
			Extent_fail(driver, "Not Matched ||  No of records : " + totalRecords_Before_Remove
					+ " ||  No of records : " + totalRecords_After_Remove, test, test1);

		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Want_To_Remove_Popup);
		String actual_UpdatedPopup = getText(driver, popup_Message);

		if (actual_UpdatedPopup.equals(Updated_Popup)) {

			System.out.println("Matched ||  Popup : " + Updated_Popup + " || Actual Popup : " + actual_UpdatedPopup);
			Extent_pass_New(driver,
					"Matched ||  Popup : " + Updated_Popup + " || Actual Popup : " + actual_UpdatedPopup, test, test1);
			click(driver, popup_Message_Ok_Button);
		} else {

			System.out
					.println("Not Matched ||  Popup : " + Updated_Popup + " || Actual Popup : " + actual_UpdatedPopup);
			Extent_fail(driver,
					"Not Matched ||  Popup : " + Updated_Popup + " || Actual Popup : " + actual_UpdatedPopup, test,
					test1);

		}

		Step_End(10, "Click Remove", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
