package LRP_Phase_1A_Contract_Management_System;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC056 extends Keywords {

	
public void Contract_Management_System_SC56(WebDriver driver, ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName = "TC_Contract_Management_System_SC056";
		
		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String MainSheetName = Excel_data.get("MainSheetName");
		String ImportFilename = Excel_data.get("ImportFilename");
		String Tariffs_of_General_Applicability = Excel_data.get("Tariffs_of_General_Applicability");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String Draft = Excel_data.get("Draft");
		String Updated_popup = Excel_data.get("Updated_popup");
		String DimensionSheetName = Excel_data.get("DimensionSheetName");
		String CMS_Duplicate_table_Header = Excel_data.get("CMS_Duplicate_table_Header");
		
		String DGheet_option = String.format(SelectDGSheet, DimensionSheetName);
		String MainSheet_option = String.format(SelectMainSheet, MainSheetName);
		

		
		
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		moduleNavigate(driver, Contract_Management_System_Module);


      Step_Start(1, "select N-N-FMC check box", test, test1);
		
		waitForElement(driver, Contract_Management_System_NFMC);
		click(driver, Contract_Management_System_NFMC);
		
		Step_End(1, "select N-N-FMC check box", test, test1);
		
		Step_Start(2, "select Non-containerized check box", test, test1);
		
		waitForElement(driver, Contract_Management_System_Non_Containerized);
		click(driver, Contract_Management_System_Non_Containerized);
		
		Step_End(2, "select Non-containerized check box", test, test1);
		

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


		waitForElement(driver, SelectSheet_dropdown1);
		click(driver, SelectSheet_dropdown1);

		waitForElement(driver, MainSheet_option);
		click(driver, MainSheet_option);

		waitForElement(driver, LoadSheet_Main);
		click(driver, LoadSheet_Main);

		waitForElement(driver, Automap_Yes);
		click(driver, Automap_Yes);
//		
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

		scrollTop(driver);

		Step_End(7, "select the sheet,click import", test, test1);

		Step_Start(8, "Click route/S.ch", test, test1);

		waitForElement(driver, RouteSch);
		click(driver, RouteSch);

		waitForDisplay(driver, RouteSch_Ok);
		click(driver, RouteSch_Ok);

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
		
		Step_Start(10, "Enter the signatory name and tittle", test, test1);
		
		
		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);


		waitForElement(driver, Contract_Management_System_Signatory_Name);
		sendKeys(driver, Contract_Management_System_Signatory_Name, Signatory_Name);

		waitForElement(driver, Contract_Management_System_Signatory_Title);
		sendKeys(driver, Contract_Management_System_Signatory_Title, Signatory_Title);

		Step_End(10, "Enter the signatory name and tittle", test, test1);

		Step_Start(11, "Update the contract in draft status", test, test1);
		
		
		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);
		
		String Actual_Updated_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + Actual_Updated_popup);
	 
	 
		
		if(Updated_popup.equals(Actual_Updated_popup)) {
			Extent_pass(driver,"Matched || Expected popup value was : "+Updated_popup+" ||  Actual popup value was is display : "+ Actual_Updated_popup, test,test1);
			System.out.println("Matched || Expected popup value was : "+Updated_popup+" || Actual popup value was is display: "+ Actual_Updated_popup);
		}else {
			System.out.println("Not Matched || Expected popup value was : "+Updated_popup+" || Actual popup value was not display: "+ Actual_Updated_popup);
			Extent_fail(driver,"Not Matched || Expected popup value was : "+Updated_popup+" || Actual popup value was not display: "+ Actual_Updated_popup, test,test1);
						
		}
		
		
		
		waitForElement(driver, Contract_Management_System_status);
		String Draftnumber =getAttribute(driver, Contract_Management_System_status,"value");
		
		
		if(Draft.equals(Draftnumber)) {
			System.out.println("Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draftnumber);
			Extent_pass(driver,"Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draftnumber, test,test1);
			
		}else {
			
			System.out.println("Not Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draftnumber);
			Extent_fail(driver,"Not Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draftnumber, test,test1);
			
		}
		
		Step_End(11, "Update the contract in draft status", test, test1);
		
		Step_Start(12, "And click on edit button and re-import the same data", test, test1);
		
		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);

		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);
		

		waitForElement(driver, ImportExcel);
		click(driver, ImportExcel);

		waitForElement(driver, ImportExcel);
		uploadfile_new(driver, ImportInput, ImportFilename);

		

		rowcountxls(driver, ImportFilename, MainSheetName);

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


//
		waitForElement(driver, Upload_Excel);
		click(driver, Upload_Excel);
//

		Step_End(12, "And click on edit button and re-import the same data", test, test1);


		Step_Start(13, "And calculate the routing and surcharge process", test, test1);

		waitForElement(driver, RouteSch);
		click(driver, RouteSch);

		waitForDisplay(driver, RouteSch_Ok);
		click(driver, RouteSch_Ok);

		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);

		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		clear(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);

		Step_End(13, "And calculate the routing and surcharge process", test, test1);
		
		Step_Start(14, "Then click on verify button", test, test1);
		
		waitForElement(driver, Contract_Management_System_Approved);
		click(driver, Contract_Management_System_Approved);
		

		
		
		List<Map<String, String>> tableData = getTableData(driver, CMS_Verify_Duplicate_Table, CMS_Verify_Duplicate_Table_row);
		List<String> bookingHeaders = splitAndExpand(CMS_Duplicate_table_Header, ",");
		String DuplicateReportTable = TableDataForReport(driver, tableData,  "DuplicateItems",bookingHeaders);
	         
			if (isdisplayed(driver, CMS_Verify_Duplicate_Table_Page)) {
				 Extent_pass(driver,"After Clicking verify Button , Duplicate Records page should be displayed  "+DuplicateReportTable,test, test1);
			} else {
				 Extent_fail(driver,"After Clicking verify Button , Duplicate Records page not displayed  "+DuplicateReportTable,test, test1);
			}
			
		Step_End(14, "Then click on verify button", test, test1);
			
		 Extent_completed(testCaseName, test, test1);
	}
	
}
