package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC60 extends Keywords {

	public void Feeder_Contract_SC60(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC60";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Feeder_Contract_No = Excel_data.get("Feeder_Contract_No");
		String Change_input_value_popup = Excel_data.get("Change_input_value_popup");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Vendor_Header = Excel_data.get("Vendor_Header");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String saved_popup = Excel_data.get("saved_popup");
		String Confirmation_Message_popup = Excel_data.get("Confirmation_Message_popup");

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
		Step_Start(7, "Double click the Contract detials ", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Search_Condition, Select_field, Feeder_Contract_No, "", "", "", "");

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(7, "Double click the Contract detials ", test, test1);
		Step_End(6, "System will show cotract details based on the Contarct number ", test, test1);
		Step_End(5, "Click on the search button.", test, test1);
		Step_End(4, "Enter the saved fdr contract number in the contract number search field.", test, test1);
		Step_End(3, "Check whether the system opens the contract details search window", test, test1);
		Step_End(2, "Click on the global search option which is available in the tool bar", test, test1);

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

		Step_Start(9, "Click save as ,It generete the new Contract with same details or else we can able to edit.",
				test, test1);

		waitForElement(driver, SaveAs_button_toolBar);
		click(driver, SaveAs_button_toolBar);

		waitForPopup(driver, popup_Message, Change_input_value_popup);
		String verified_popup = getText(driver, popup_Message);

		if (verified_popup.equals(Change_input_value_popup)) {
			Extent_pass(driver,
					"Matched || Expected value is : After click on save as button the popup  message should be : "
							+ Change_input_value_popup
							+ " || Actual value is : After click on save as button the popup  message is : "
							+ verified_popup,
					test, test1);

			System.out.println(
					"Matched || Expected value is : After click on save as button the popup  message should be : "
							+ Change_input_value_popup
							+ " || Actual value is : After click on save as button the popup  message is : "
							+ verified_popup);
		} else {
			System.out.println(
					"Not Matched || Expected value is : After click on save as button the popup  message should be : "
							+ Change_input_value_popup
							+ " || Actual value is : After click on save as button the popup  message is not display :"
							+ verified_popup);
			Extent_fail(driver,
					"Not Matched || Expected value is : After click on save as button the popup  message should be : "
							+ Change_input_value_popup
							+ " || Actual value is : After click on save as button the popup  message is not display : "
							+ verified_popup,
					test, test1);

		}

		waitForDisplay(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		waitForElement(driver, FC_Vendor_Search_Button);
		click(driver, FC_Vendor_Search_Button);

		twoColumnSearchWindow(driver, Vendor_Header, Two_Column_Condition, Vendor_Code);

		waitForElement(driver, SaveAs_button_toolBar);
		click(driver, SaveAs_button_toolBar);

		waitForPopup(driver, FC_Confirmation_Message_popup, Confirmation_Message_popup);

		String Actualpopup = getText(driver, FC_Confirmation_Message_popup);

		if (Confirmation_Message_popup.equals(Actualpopup)) {

			System.out.println("Matched || Expected popup message was : " + Confirmation_Message_popup
					+ " || Actual popup message was : " + Actualpopup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Confirmation_Message_popup
					+ " || Actual popup message was : " + Actualpopup, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup message was : " + Confirmation_Message_popup
					+ " || Actual popup message was : " + Actualpopup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Confirmation_Message_popup
					+ " || Actual popup message was : " + Actualpopup, test, test1);

		}

		waitForElement(driver, FC_Confirmation_Message_okbtn);
		click(driver, FC_Confirmation_Message_okbtn);

		waitForPopup(driver, popup_Message, saved_popup);
		String update_popup = getText(driver, popup_Message);

		if (update_popup.equals(saved_popup)) {
			Extent_pass(driver,
					"Matched || Expected value is : After click on save as button the popup  message should be : "
							+ update_popup
							+ " || Actual value is : After click on save as button the popup  message is : "
							+ saved_popup,
					test, test1);

			System.out.println(
					"Matched || Expected value is : After click on save as button the popup  message should be : "
							+ update_popup
							+ " || Actual value is : After click on save as button the popup  message is : "
							+ saved_popup);
		} else {
			System.out.println(
					"Not Matched || Expected value is : After click on save as button the popup  message should be : "
							+ update_popup
							+ " || Actual value is : After click on save as button the popup  message is not display :"
							+ saved_popup);
			Extent_fail(driver,
					"Not Matched || Expected value is : After click on save as button the popup  message should be : "
							+ update_popup
							+ " || Actual value is : After click on save as button the popup  message is not display : "
							+ saved_popup,
					test, test1);

		}

		waitForDisplay(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(9, "Click save as ,It generete the new Contract with same details or else we can able to edit.", test,
				test1);

	}
}
