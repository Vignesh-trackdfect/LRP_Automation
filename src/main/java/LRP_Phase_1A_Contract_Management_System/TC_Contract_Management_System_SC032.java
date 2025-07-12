package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC032 extends Keywords {
	public void Contract_Management_System_SC32(WebDriver driver, ExtentTest test, ExtentTest test1,

			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Contract_Management_System_SC032";
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
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition2 = Excel_data.get("Search_Condition2");		
		String Delete_Popup = Excel_data.get("Delete_Popup");
		String Updated_popup = Excel_data.get("Updated_popup");
		String Delete_Confirm_Popup = Excel_data.get("Delete_Confirm_Popup");
		String Draft = Excel_data.get("Draft");
		String No_Records_Popup = Excel_data.get("No_Records_Popup");
		

		String MainSheet_option = String.format(SelectMainSheet, MainSheetName);
	    String DGheet_option = String.format(SelectDGSheet, DimensionSheetName);

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		moduleNavigate(driver, Contract_Management_System_Module);


		Step_Start(1, "select NON FMC check box", test, test1);

		Step_Start(2, "select Non - containerized check box", test, test1);

		waitForElement(driver, Contract_Management_System_Non_Containerized);
		click(driver, Contract_Management_System_Non_Containerized);

		waitForElement(driver, N_FMC);
		click(driver, N_FMC);

		Step_End(1, "select NON FMC check box", test, test1);

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


		if(Contract_saved.equals(saved_popup)) {
			Extent_pass(driver,"Matched || Expected popup value was : "+Contract_saved+" ||  Actual popup value was is display : "+ saved_popup, test,test1);
			System.out.println("Matched || Expected popup value was : "+Contract_saved+" || Actual popup value was is display: "+ saved_popup);
		}else {
			System.out.println("Not Matched || Expected popup value was : "+Contract_saved+" || Actual popup value was not display: "+ saved_popup);
			Extent_fail(driver,"Not Matched || Expected popup value was : "+Contract_saved+" || Actual popup value was not display: "+ saved_popup, test,test1);
						
		}
		Step_End(9, "click Save", test, test1);

		Step_Start(10, "Retrieve the contract in the global search", test, test1);

		waitForElement(driver, Contract_Management_System_contract);
		String contract_number = getAttribute(driver, Contract_Management_System_contract, "value");
		System.out.println("contect_number :" + contract_number);

		waitForElement(driver, Contract_Management_System_status);
		String Draftnumber = getAttribute(driver, Contract_Management_System_status, "value");
		System.out.println("Draftnumber :" + Draftnumber);

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
		Step_Start(13, "Update the contract in draft status.", test, test1);
		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);

		waitForPopup(driver, Popup_Message, Updated_popup);

		String Actual_Updated_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + Actual_Updated_popup);


		
		if(Updated_popup.equals(Actual_Updated_popup)) {
			Extent_pass(driver,"Matched || Expected popup value was : "+Updated_popup+" ||  Actual popup value was is display : "+ Actual_Updated_popup, test,test1);
			System.out.println("Matched || Expected popup value was : "+Updated_popup+" || Actual popup value was is display: "+ Actual_Updated_popup);
		}else {
			System.out.println("Not Matched || Expected popup value was : "+Updated_popup+" || Actual popup value was not display: "+ Actual_Updated_popup);
			Extent_fail(driver,"Not Matched || Expected popup value was : "+Updated_popup+" || Actual popup value was not display: "+ Actual_Updated_popup, test,test1);
						
		}
		Step_End(13, "Update the contract in draft status.", test, test1);
		Step_Start(14, "Search the contract through global search click on delete button", test, test1);
		
		

		waitForElement(driver, Contract_Management_System_contract);
		String contract_number1 = getAttribute(driver, Contract_Management_System_contract, "value");
		System.out.println("contect_number :" + contract_number1);

		waitForElement(driver, Contract_Management_System_status);
		String Draftnumber1 = getAttribute(driver, Contract_Management_System_status, "value");
		System.out.println("Draftnumber :" + Draftnumber1);
		if (Draft.equals(Draftnumber1)) {
			System.out.println("Matched || Expected the status  : After click on save button, The status should be : "
					+ Draft + " || Actual value is After click on save button, The status is : " + Draftnumber1);
			Extent_pass(driver,
					"Matched || Expected the status  : After click on save button, The status should be : " + Draft
							+ " || Actual value is After click on save button, The status is : " + Draftnumber1,
					test, test1);

		} else {

			System.out
					.println("Not Matched || Expected the status  : After click on save button, The status should be : "
							+ Draft + " || Actual value is After click on save button, The status is : " + Draftnumber1);
			Extent_fail(driver,
					"Not Matched || Expected the status  : After click on save button, The status should be : " + Draft
							+ " || Actual value is After click on save button, The status is : " + Draftnumber1,
					test, test1);

		}

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition2, Select_field, contract_number1, "", "", "", "");
		
		
		
		
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		waitForDisplay(driver, popup_Message);
		String Actual_Deleted = getText(driver, popup_Message);
		System.out.println("saved_popup :" + Actual_Deleted);
		
		if(Delete_Popup.equals(Actual_Deleted)) {
			Extent_pass(driver,"Matched || Expected popup value was : "+Delete_Popup+" ||  Actual popup value was is display : "+ Actual_Deleted, test,test1);
			System.out.println("Matched || Expected popup value was : "+Delete_Popup+" || Actual popup value was is display: "+ Actual_Deleted);
		
		}else {
			System.out.println("Not Matched || Expected popup value was : "+Delete_Popup+" || Actual popup value was not display: "+ Actual_Deleted);
			Extent_fail(driver,"Not Matched || Expected popup value was : "+Delete_Popup+" || Actual popup value was not display: "+ Actual_Deleted, test,test1);
						
		}
		waitForPopup(driver, popup_Message_Yes_Button, Delete_Popup);
		click(driver, popup_Message_Yes_Button);
		
		waitForPopup(driver, Popup_Message, Delete_Confirm_Popup);
		
		String Actual_Confirm_Deleted = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + Actual_Deleted);
		
		if(Delete_Confirm_Popup.equals(Actual_Confirm_Deleted)) {
			Extent_pass(driver,"Matched || Expected popup value was : "+Delete_Confirm_Popup+" ||  Actual popup value was is display : "+ Actual_Confirm_Deleted, test,test1);
			System.out.println("Matched || Expected popup value was : "+Delete_Confirm_Popup+" || Actual popup value was is display: "+ Actual_Confirm_Deleted);
		
		}else {
			System.out.println("Not Matched || Expected popup value was : "+Delete_Confirm_Popup+" || Actual popup value was not display: "+ Actual_Confirm_Deleted);
			Extent_fail(driver,"Not Matched || Expected popup value was : "+Delete_Confirm_Popup+" || Actual popup value was not display: "+ Actual_Confirm_Deleted, test,test1);
						
		}
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow1(driver, Search_Condition2, Select_field, contract_number1, "", "", "", "");
		
		waitForDisplay(driver, Popup_Message);
		String Actual_No_records = getText(driver, Popup_Message);
		System.out.println("popup :" + Actual_No_records);
		if(No_Records_Popup.equals(Actual_No_records)) {
			Extent_pass(driver,"Matched || Expected popup value was : "+No_Records_Popup+" ||  Actual popup value was is display : "+ Actual_No_records, test,test1);
			System.out.println("Matched || Expected popup value was : "+No_Records_Popup+" || Actual popup value was is display: "+ Actual_No_records);
		
		}else {
			System.out.println("Not Matched || Expected popup value was : "+No_Records_Popup+" || Actual popup value was not display: "+ Actual_No_records);
			Extent_fail(driver,"Not Matched || Expected popup value was : "+No_Records_Popup+" || Actual popup value was not display: "+ Actual_No_records, test,test1);
		}		
		
		
		Step_End(14, "Search the contract through global search click on delete button", test, test1);
		
		   Extent_completed(testCaseName, test, test1);
		
		
		

		}


}
