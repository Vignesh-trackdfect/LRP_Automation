package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC047 extends Keywords {

	public void Contract_Management_System_SC47(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC047";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String MainSheetName = Excel_data.get("MainSheetName");
		String DimensionSheetName = Excel_data.get("DimensionSheetName");
		String ImportFilename = Excel_data.get("ImportFilename");
		String Tariffs_of_General_Applicability = Excel_data.get("Tariffs_of_General_Applicability");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String Verified = Excel_data.get("Verified");
		String Contract_Verified = Excel_data.get("Contract_Verified");
		String Contract_Activated = Excel_data.get("Contract_Activated");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition2 = Excel_data.get("Search_Condition2");
		String Contract_Activated_popup = Excel_data.get("Contract_Activated_popup");
		String Draft = Excel_data.get("Draft");
		String Updated_popup = Excel_data.get("Updated_popup");
		
		String MainSheet_option = String.format(SelectMainSheet, MainSheetName);
		String DGheet_option = String.format(SelectDGSheet, DimensionSheetName);

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		moduleNavigate(driver, Contract_Management_System_Module);

		Step_Start(1, "select FMC check box", test, test1);

		Step_Start(2, "select Non containerized check box", test, test1);

		waitForElement(driver, Contract_Management_System_Non_Containerized);
		click(driver, Contract_Management_System_Non_Containerized);

		waitForElement(driver, Contract_Management_System_Fmc);
		click(driver, Contract_Management_System_Fmc);

		Step_End(1, "select FMC check box", test, test1);

		Step_End(2, "select Non containerized check box", test, test1);

		Step_Start(3, "Enter the customer name", test, test1);

		waitForElement(driver, Contract_Management_System_CustomerName);
		sendKeys(driver, Contract_Management_System_CustomerName, Customer_code_Value);

		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);

		waitForDisplay(driver, Contract_Management_System_Commodity);
		if (isdisplayed(driver, Contract_Management_System_Exit)) {
			click(driver, Contract_Management_System_Exit);
		} else {
			System.out.println("customer name System Page is not displayed");
		}

		Step_End(3, "Enter the customer name", test, test1);

		Step_Start(4, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);

		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);

		waitForElement(driver, Contract_Management_System_Internal_Commodity);
		sendKeys(driver, Contract_Management_System_Internal_Commodity, Internal_Commodity);

		String select_Internal_Commmodity = String.format(Contract_Management_System_Commodity_val, Internal_Commodity);
		waitForElement(driver, select_Internal_Commmodity);
		safeclick(driver, select_Internal_Commmodity);

		waitForElement(driver, Contract_Management_System_Internal_Commodity_add);
		click(driver, Contract_Management_System_Internal_Commodity_add);

		Step_End(4, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);


        Step_Start(5, "switch to port pair tab", test, test1);
        waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);
		Step_End(5, "switch to port pair tab", test, test1);
		
		Step_Start(6, "Click on the import excel button", test, test1);

		waitForElement(driver, ImportExcel);
		click(driver, ImportExcel);

		uploadfile_new(driver, ImportInput, ImportFilename);

		Step_End(6, "Click on the import excel button", test, test1);

		Step_Start(7, "select the sheet,click import", test, test1);

		String ExcelrowCount = rowcountxls(driver, ImportFilename, MainSheetName);

		waitForElement(driver, SelectSheet_dropdown1);
		click(driver, SelectSheet_dropdown1);

		waitForElement(driver, MainSheet_option);
		click(driver, MainSheet_option);

		waitForElement(driver, LoadSheet_Main);
		click(driver, LoadSheet_Main);

		waitForElement(driver, Automap_Yes);
		click(driver, Automap_Yes);

		waitForElement(driver, ImportExcel_DG);
		click(driver, ImportExcel_DG);

		waitForElement(driver, SelectSheet_dropdown2);
		click(driver, SelectSheet_dropdown2);

		waitForElement(driver, DGheet_option);
		click(driver, DGheet_option);

		waitForElement(driver, LoadSheet_DG);
		click(driver, LoadSheet_DG);

		waitForElement(driver, Automap_Yes);
		click(driver, Automap_Yes);

		waitForElement(driver, Upload_Excel);
		click(driver, Upload_Excel);

		scrollBottom(driver);

		waitForElement(driver, PortpairGridCount);
		String gridcount = getText(driver, PortpairGridCount).trim();

		if (gridcount.equals(ExcelrowCount)) {

			System.out.println("All the row values are imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "All the row values are imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		} else {

			System.out.println("Some of the row values are not imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "Some of the row values are not imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		}

		Step_End(7, "select the sheet,click import", test, test1);


		Step_Start(8, "Click route/S.ch", test, test1);

		scrollTop(driver);

		waitForElement(driver, RouteSch);
		click(driver, RouteSch);

		waitForDisplay(driver, RouteSch_Ok);
		click(driver, RouteSch_Ok);

		scrollTop(driver);
		mouseOverToElement(driver, Contract_Management_System_General);
		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);

		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);

		Step_End(8, "Click route/S.ch", test, test1);

		Step_Start(9, "click Save", test, test1);

		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);

		waitForPopup(driver, Popup_Message, Contract_saved);

		String saved_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + saved_popup);

		if (Contract_saved.equals(saved_popup)) {
			Extent_pass(driver, "Matched || Expected popup value was : " + Contract_saved
					+ " ||  Actual popup value was is display : " + saved_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was is display: " + saved_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was not display: " + saved_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was not display: " + saved_popup, test, test1);

		}

		Step_End(9, "click Save", test, test1);

		Step_Start(10, "Retrieve the contract in the global search", test, test1);

		waitForElement(driver, Contract_Management_System_contract);
		String contract_number = getAttribute(driver, Contract_Management_System_contract, "value");
		System.out.println("contect_number :" + contract_number);

		waitForElement(driver, Contract_Management_System_status);
		String Draftnumber1 = getAttribute(driver, Contract_Management_System_status, "value");
		System.out.println("Draftnumber :" + Draftnumber1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition2, Select_field, contract_number, "", "", "", "");

		Step_End(10, "Retrieve the contract in the global search", test, test1);

		Step_Start(11, "click edit", test, test1);

		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);

		Step_End(11, "click edit", test, test1);

		Step_Start(12, "Enter the signatory name and tittle", test, test1);

		waitForElement(driver, Contract_Management_System_Signatory_Name);
		sendKeys(driver, Contract_Management_System_Signatory_Name, Signatory_Name);

		waitForElement(driver, Contract_Management_System_Signatory_Title);
		sendKeys(driver, Contract_Management_System_Signatory_Title, Signatory_Title);

		Step_End(12, "Enter the signatory name and tittle", test, test1);

		Step_Start(13, "Update the contract in draft status", test, test1);

		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);

		String Actual_Updated_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + Actual_Updated_popup);

		if (Updated_popup.equals(Actual_Updated_popup)) {
			Extent_pass(driver, "Matched || Expected popup value was : " + Updated_popup
					+ " ||  Actual popup value was is display : " + Actual_Updated_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Updated_popup
					+ " || Actual popup value was is display: " + Actual_Updated_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Updated_popup
					+ " || Actual popup value was not display: " + Actual_Updated_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Updated_popup
					+ " || Actual popup value was not display: " + Actual_Updated_popup, test, test1);

		}

		waitForElement(driver, Contract_Management_System_status);
		String Draftnumber = getAttribute(driver, Contract_Management_System_status, "value");

		if (Draft.equals(Draftnumber)) {
			System.out.println("Matched || Expected the status  : After click on save button, The status should be : "
					+ Draft + " || Actual value is After click on save button, The status is : " + Draftnumber);
			Extent_pass(driver,
					"Matched || Expected the status  : After click on save button, The status should be : " + Draft
							+ " || Actual value is After click on save button, The status is : " + Draftnumber,
					test, test1);

		} else {

			System.out
					.println("Not Matched || Expected the status  : After click on save button, The status should be : "
							+ Draft + " || Actual value is After click on save button, The status is : " + Draftnumber);
			Extent_fail(driver,
					"Not Matched || Expected the status  : After click on save button, The status should be : " + Draft
							+ " || Actual value is After click on save button, The status is : " + Draftnumber,
					test, test1);

		}

		Step_End(13, "Update the contract in draft status", test, test1);

		Step_Start(14, "And then verify and activate.", test, test1);

		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);

		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);

		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);
		waitForElement(driver, Contract_Management_System_Approved);
		click(driver, Contract_Management_System_Approved);

		String verified_popup = "";
		waitForDisplay(driver, Popup_Message);
		if (isdisplayed(driver, Popup_Message)) {
			System.out.println("popup message is not display");
			waitForPopup(driver, Popup_Message, Contract_Verified);
			verified_popup = getText(driver, Popup_Message);
		} else {
			waitForDisplay(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			waitForPopup(driver, Popup_Message, Contract_Verified);
			verified_popup = getText(driver, Popup_Message);
		}
		System.out.println("verified_popup :" + verified_popup);

		if (Contract_Verified.equals(verified_popup)) {
			Extent_pass(driver,
					"Matched || Expected value is : After click on approved button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on approved button the popup  message is : "
							+ verified_popup,
					test, test1);
			System.out.println(
					"Matched || Expected value is : After click on approved button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on approved button the popup  message is : "
							+ verified_popup);
		} else {
			System.out.println(
					"Not Matched || Expected value is : After click on approved button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on approved button the popup  message is not display :"
							+ verified_popup);
			Extent_fail(driver,
					"Not Matched || Expected value is : After click on approved button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on approved button the popup  message is not display : "
							+ verified_popup,
					test, test1);

		}

		waitForElement(driver, Contract_Management_System_status);
		String verifiednumber = getAttribute(driver, Contract_Management_System_status, "value");
		System.out.println("verifiednumber :" + verifiednumber);

		if (Verified.equals(verifiednumber)) {
			Extent_pass(driver,
					"Matched || Expected value is : After click on save button, The status should be : " + Verified
							+ " || Actual value is : After click on save button, The status is :" + verifiednumber,
					test, test1);
			System.out.println("Matched || Expected value is After click on save button, The status should be : "
					+ Verified + " || Actual value is : After click on save button, The status is :" + verifiednumber);
		} else {
			System.out.println("Not Matched || Expected value is : After click on save button, The status should be : "
					+ Verified + " || Actual value is : After click on save button, The status is : " + verifiednumber);
			Extent_fail(driver,
					"Not Matched || Expected value is : After click on save button, The status should be : " + Verified
							+ " || Actual value is : After click on save button, The status is : " + verifiednumber,
					test, test1);
		}

		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);

		waitForElement(driver, Contract_Management_System_Active);
		click(driver, Contract_Management_System_Active);

		String verified_popup2 = "";
		waitForDisplay(driver, Popup_Message);
		if (isdisplayed(driver, Popup_Message)) {
			System.out.println("popup message is not display");
			waitForPopup(driver, Popup_Message, Contract_Activated_popup);
			verified_popup2 = getText(driver, Popup_Message);
		} else {
			waitForDisplay(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			waitForPopup(driver, Popup_Message, Contract_Activated_popup);
			verified_popup2 = getText(driver, Popup_Message);
		}
		System.out.println("verified_popup :" + verified_popup);

		if (Contract_Activated_popup.equals(verified_popup2)) {
			System.out.println("Matched || Expected value is :  After click on edit button, The status should be : "
					+ Contract_Activated_popup + " || Actual value is :  After click on edit button, The status is : "
					+ verified_popup2);
			Extent_pass(driver,
					"Matched || Expected value is :  After click on edit button, The status should be :"
							+ Contract_Activated_popup
							+ " || Actual value is :  After click on edit button, The status is : " + verified_popup2,
					test, test1);

		} else {
			System.out
					.println("Not Matched || Expected value is :  After click on edit button, The status should be :  "
							+ Contract_Activated_popup
							+ " || Actual value is :  After click on edit button, The status is : " + verified_popup2);
			Extent_fail(driver,
					"Not Matched || Expected value is :  After click on edit button, The status should be :"
							+ Contract_Activated_popup
							+ " || Actual value is :  After click on edit button, The status is : " + verified_popup2,
					test, test1);

		}

		waitForElement(driver, Contract_Management_System_status);
		String ActivatePopup = getAttribute(driver, Contract_Management_System_status, "value");

		if (Contract_Activated.equals(ActivatePopup)) {
			System.out.println("Matched || Expected value is : After click on edit button, The status should be : "
					+ Contract_Activated + " Actual value is : After click on edit button, The status is : "
					+ ActivatePopup);
			Extent_pass(driver,
					"Matched || Expected value is : After click on edit button, The status should be : "
							+ Contract_Activated + " Actual value is : After click on edit button, The status is :"
							+ ActivatePopup,
					test, test1);

		} else {
			System.out.println("Not Matched || Expected value is : After click on edit button, The status should be : "
					+ Contract_Activated + " Actual value is : After click on edit button, The status is not display : "
					+ ActivatePopup);

			Extent_fail(driver, "Not Matched || Expected value is : After click on edit button, The status should be : "
					+ Contract_Activated + " Actual value is : After click on edit button, The status is not display : "
					+ ActivatePopup, test, test1);

		}

		Step_End(14, "And then verify and activate.", test, test1);

		Step_Start(15, "Follow the same step and create a duplicate record.", test, test1);

		waitForElement(driver, Contract_Management_System_contract);
		String contract_number1 = getAttribute(driver, Contract_Management_System_contract, "value");
		System.out.println("contect_number :" + contract_number);

		waitForElement(driver, CMS_Cancel_Btn);
		click(driver, CMS_Cancel_Btn);
		
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition2, Select_field, contract_number1, "", "", "", "");
		
		
		if (Contract_Activated.equals(ActivatePopup)) {
			System.out.println("Matched || Expected value is : After create a duplicate record, The status should be : "
					+ Contract_Activated + " Actual value is : After create a duplicate record, The status is : "
					+ ActivatePopup);
			Extent_pass(driver,
					"Matched || Expected value is : After create a duplicate record, The status should be : "
							+ Contract_Activated + " Actual value is : After create a duplicate record, The status is :"
							+ ActivatePopup,
					test, test1);

		} else {
			System.out.println("Not Matched || Expected value is : After create a duplicate record, The status should be : "
					+ Contract_Activated + " Actual value is : After create a duplicate record, The status is not display : "
					+ ActivatePopup);

			Extent_fail(driver, "Not Matched || Expected value is : After create a duplicate record, The status should be : "
					+ Contract_Activated + " Actual value is : Aftercreate a duplicate record, The status is not display : "
					+ ActivatePopup, test, test1);

		}

		Extent_completed(testCaseName, test, test1);
	}
}


