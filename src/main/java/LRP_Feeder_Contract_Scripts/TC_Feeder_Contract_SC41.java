package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import locators.Bill_Upload_Gate;

public class TC_Feeder_Contract_SC41 extends Keywords {
	public void Feeder_Contract_SC41(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {
		String testcase_Name = "TC_Feeder_Contract_SC41";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Feeder_Contract_Module_Name = Excel_data.get("Feeder_Contract_Module_Name");
		String Contarct_Numer_Header = Excel_data.get("Contarct_Numer_Header");
		String condition = Excel_data.get("condition");
		String Contract_Number = Excel_data.get("Contract_Number");
		String Remove_Line = Excel_data.get("Remove_Line");
		String Excel_SheetName_Master_Data = Excel_data.get("Excel_SheetName_Master_Data");
		String Expected_pop = Excel_data.get("Expected_pop");
		String Sheet_select = Excel_data.get("Sheet_select");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, ".Enter the screen name as \"\"Feeder Contracts\"\" in module search field..", test, test1);

		moduleNavigate(driver, Feeder_Contract_Module_Name);

		Step_End(1, "Enter the screen name as \"\"Feeder Contracts\"\" in module search field..", test, test1);

		Step_Start(2, "Click on the global search option which is available in the tool bar.    ", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(2, "Click on the global search option which is available in the tool bar.    ", test, test1);

		Step_Start(3, "Check whether it opens a Contract details search window.        ", test, test1);
		Step_Start(4, ".Enter the saved Contract number in the Contract number search field.  .", test, test1);
		Step_Start(5, "Then click on the search button.                 .", test, test1);
		Step_Start(6, "System will show the Contract details based on the FDR contract Number. .", test, test1);
		Step_Start(7, "Click on the select button.                   .", test, test1);
		globalValueSearchWindow(driver, condition, Contarct_Numer_Header, Contract_Number, "", "", "", "");
		Step_End(3, "Check whether it opens a Contract details search window.        ", test, test1);
		Step_End(4, ".Enter the saved Contract number in the Contract number search field.  .", test, test1);
		Step_End(5, "Then click on the search button.                 .", test, test1);
		Step_End(6, "System will show the Contract details based on the FDR contract Number. .", test, test1);
		Step_End(7, "Click on the select button.                   .", test, test1);
		waitForElement(driver, FC_Fdr_Contract_number_field);

		Step_Start(8, "System will retrieve the contract.  ", test, test1);

		String validation = getAttribute(driver, FC_Fdr_Contract_number_field, "value");
		System.out.println(validation);

		if (validation.equals(Contract_Number)) {
			System.out.println("Expected Value From test data :" + Contract_Number
					+ " Actual Value Taken after global search the contract number: " + validation);
			Extent_pass_New(driver,
					"Expected Value From test data:" + Contract_Number
							+ " Actual Value Taken after global search the contract number : " + validation,
					test, test1);
		} else {
			System.out.println("Expected Value From test data:" + Contract_Number
					+ "Actual Value Taken after global search the contract number  : " + validation);
			Extent_fail(driver,
					"Expected Value From test data :" + Contract_Number
							+ " Actual Value Taken after global search the contract number: " + validation,
					test, test1);
		}

		Step_End(8, "System will retrieve the contract.  ", test, test1);

		Step_Start(9, "Download the excel ", test, test1);

		waitForElement(driver, Export_button_Toolbar);
		String filePath = downloadFile(driver, Export_button_Toolbar);
		String editedFilepath = removeFirstNLines(filePath, Excel_SheetName_Master_Data, Remove_Line);
		waitForDisplay(driver, Server_ok_Button);
		if (isdisplayed(driver, Server_ok_Button)) {
			click(driver, Server_ok_Button);
		}
		Step_End(9, "Download the excel ", test, test1);

		Step_Start(10, "Again import the same excel ", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Import_Button_FC);
		click(driver, Import_Button_FC);

		waitForPresenceOfElement(driver, Select_excel_FC);
		uploadfile1(driver, Select_excel_FC, editedFilepath);

		Step_End(10, "Again import the same excel ", test, test1);

		Step_Start(11, "Again import the same excel and select the sheet ", test, test1);

		waitForElement(driver, Aselectexcelfiledroupdown);
		click(driver, Aselectexcelfiledroupdown);

		formatLocatorClick(driver, Bill_Upload_Gate.Sheet_sel, Sheet_select);

		Step_End(11, "Again import the same excel and select the sheet ", test, test1);

		waitForElement(driver, Aloadsheet);
		click(driver, Aloadsheet);

		waitForElement(driver, Amapyesbutton);
		click(driver, Amapyesbutton);

		Step_Start(12, "click the upload button ", test, test1);

		waitForElement(driver, Auploadfile);
		click(driver, Auploadfile);

		Step_End(12, "click the upload button ", test, test1);

		Step_Start(13, "popup will be shown updated", test, test1);

		waitForPopup(driver, popup_Message, Expected_pop);

		waitForElement(driver, popup_Message);
		String Act_pop = getText(driver, popup_Message);

		if (Expected_pop.equals(Act_pop)) {
			System.out.println("Expected popup is :" + Expected_pop + " Actual popup is : " + Act_pop);
			Extent_pass_New(driver, "Expected  popup is :" + Expected_pop + " Actual  popup is : " + Act_pop, test,
					test1);
		} else {
			System.out.println("Expected  popup is :" + Expected_pop
					+ " Actual Result taken from application after two coloum search : " + Act_pop);
			Extent_fail(driver,
					"Expected  popup is :" + Expected_pop
							+ " Actual Result taken from application after two coloum search : " + Act_pop,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(13, "popup will be shown updated", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
