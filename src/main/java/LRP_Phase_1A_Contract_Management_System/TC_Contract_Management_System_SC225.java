package LRP_Phase_1A_Contract_Management_System;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC225 extends Keywords{

	public void Contract_Management_System_SC225(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC225";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String MainSheetName = Excel_data.get("MainSheetName");
		String ImportFilename = Excel_data.get("ImportFilename");
		String MainSheet_option = String.format(SelectMainSheet, MainSheetName);
		String DGSheetName = Excel_data.get("DGSheetName");
		String DGheet_option = String.format(SelectDGSheet, DGSheetName);
		String DG_Details_Missing_popup = Excel_data.get("DG_Details_Missing_popup");
	    String CMS_Missing_table_Header = Excel_data.get("CMS_Missing_table_Header");
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		moduleNavigate(driver, Contract_Management_System_Module);

		Step_Start(1, "select FMC check box", test, test1);

		waitForElement(driver, Contract_Management_System_Fmc);
		click(driver, Contract_Management_System_Fmc);

		Step_End(1, "select FMC check box", test, test1);

		Step_Start(2, "select containerized check box", test, test1);

		waitForElement(driver, Contract_Management_System_Containerized);
		click(driver, Contract_Management_System_Containerized);

		Step_End(2, "select containerized check box", test, test1);

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

		Step_Start(6, "Import the port pair lanes with DG YES and more than 15 DG class in DG tab", test, test1);

		waitForElement(driver, ImportExcel);
		click(driver, ImportExcel);

		uploadfile_new(driver, ImportInput, ImportFilename);


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
		
		List<Map<String, String>> tableData = getTableData(driver, CMS_Verify_Duplicate_Table,
				CMS_Verify_Duplicate_Table_row);
		List<String> bookingHeaders = splitAndExpand(CMS_Missing_table_Header, ",");
 
		String DuplicateReportTable = TableDataForReport(driver, tableData, "DG Exceed details", bookingHeaders);
 
		if (isdisplayed(driver, CMS_Verify_Duplicate_Table_Page)) {
			
		
    String DG_Class_Exceed_popup = getText(driver, CMS_DG_Missing_window_Row);
	System.out.println("DG_Class_Exceed_popup is"+DG_Class_Exceed_popup);
			
			if (DG_Details_Missing_popup.equals(DG_Class_Exceed_popup)) {
				System.out.println("After Clicking ON upload Button , If we try to add more than 15 DG details, we will get this message "
						+ DuplicateReportTable);
				Extent_pass(driver, "After Clicking ON upload Button , If we try to add more than 15 DG details, we will get this message "
						+ DuplicateReportTable, test, test1);
				
			} else {

				System.out.println("After Clicking ON upload Button , If we try to add more than 15 DG details, we will get this message ");
			
			Extent_fail(driver, "After Clicking ON upload Button , If we try to add more than 15 DG details, wew will  not get this message  ", test, test1);
		} 
		}
			else {
				
				Extent_fail(driver, "After Clicking ON upload Button , If we try to add more than 15 DG details, wew will  not get this Window ", test, test1);
			}
		

		Step_End(6, "Import the port pair lanes with DG YES and more than 15 DG class in DG tab", test, test1);

		   Extent_completed(testCaseName, test, test1);
		
	}
	
}
