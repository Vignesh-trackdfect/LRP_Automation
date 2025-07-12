package LRP_Phase_1A_Contract_Management_System;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC204  extends Keywords {
	public void Contract_Management_System_SC204(WebDriver driver, ExtentTest test, ExtentTest test1,

			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Contract_Management_System_SC204";
		

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
		String Charges_Header = Excel_data.get("Charges_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Surcharge_Name = Excel_data.get("Surcharge_Name");
		String Surcharge_Amount = Excel_data.get("Surcharge_Amount");
		String CMS_Carrier_remarks_TextField = Excel_data.get("CMS_Carrier_remarks_TextField");
		String Sheet_Name = Excel_data.get("Sheet_Name");
		String Excelrow = Excel_data.get("Excelrow");
		
		String MainSheet_option = String.format(SelectMainSheet, MainSheetName);
		

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		moduleNavigate(driver, Contract_Management_System_Module);


		Step_Start(1, "select N-FMC check box", test, test1);

		waitForElement(driver, N_FMC);
		click(driver, N_FMC);

		Step_End(1, "select N-FMC check box", test, test1);

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
		waitForElement(driver, Contract_Management_System_Exit);
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


		waitForElement(driver, Upload_Excel);
		click(driver, Upload_Excel);

		scrollBottom(driver);

		waitForElement(driver, PortpairGridCount);
		String gridcount = getText(driver, PortpairGridCount).trim();

		if (gridcount.equals(ExcelrowCount)) {

			System.out.println("All the row values are imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "All the row values are imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		} else {

			System.out.println("Some of the row values are not imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "Some of the row values are not imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		}

		scrollTop(driver);

		Step_End(7, "select the sheet,click import", test, test1);

		Step_Start(8, "Click route/S.ch", test, test1);

		waitForElement(driver, RouteSch);
		click(driver, RouteSch);

		waitForDisplay(driver, RouteSch_Ok);
		jsClick(driver, RouteSch_Ok);
		
		scrollTop(driver);
		mouseOverToElement(driver, Contract_Management_System_Surcharge_rule);

		waitForElement(driver, Contract_Management_System_Surcharge_rule);
		click(driver, Contract_Management_System_Surcharge_rule);

		waitForElement(driver, Surcharge_Serach);
		click(driver, Surcharge_Serach);

		twoColumnSearchWindow(driver, Charges_Header, Search_Condition, Surcharge_Name);

		waitForElement(driver, SelectAll_Surcharge);
		click(driver, SelectAll_Surcharge);

		waitForElement(driver, Surcharge_Amount_field);
		clearAndType(driver, Surcharge_Amount_field, Surcharge_Amount);

		waitForElement(driver, Add_Surcharge);
		click(driver, Add_Surcharge);
		scrollTop(driver);
		mouseOverToElement(driver, Contract_Management_System_General);
		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);

		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);

		waitForElement(driver, Contract_Management_System_Signatory_Name);
		sendKeys(driver, Contract_Management_System_Signatory_Name, Signatory_Name);

		waitForElement(driver, Contract_Management_System_Signatory_Title);
		sendKeys(driver, Contract_Management_System_Signatory_Title, Signatory_Title);

		waitForElement(driver, Cari_info_Signatory_Name);
		clear(driver, Cari_info_Signatory_Name);
		sendKeys(driver, Cari_info_Signatory_Name, Signatory_Name);

		waitForElement(driver, Cari_info_Signatory_Title);
		clear(driver, Cari_info_Signatory_Title);
		sendKeys(driver, Cari_info_Signatory_Title, Signatory_Title);

		waitForElement(driver, CMS_Carrier_Remarks_Field);
		sendKeys(driver, CMS_Carrier_Remarks_Field, CMS_Carrier_remarks_TextField);
		Step_End(7, "and calculate the routing and surcharge.", test, test1);

		Step_Start(8, "and save the contract", test, test1);
		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);
		waitForPopup(driver, Popup_Message, Contract_saved);
		String saved_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + saved_popup);
		
          waitForDisplay(driver, saved_popup);
		if (Contract_saved.equals(saved_popup)) {
			Extent_pass(driver, "Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was is display : " + saved_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was is display: " + saved_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was not display: " + saved_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was not display: " + saved_popup, test, test1);

		}
		Step_End(8, "and save the contract", test, test1);
		
		Step_Start(9, "and click on export button.", test, test1);
		String downloaded_path =downloadFile(driver, Export_button_Toolbar);
		System.out.println(downloaded_path);
		
		waitForDisplay(driver, Contract_Management_System_port_pair);
		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);
		
	

		
		
		scrollBottom(driver);
		waitForElement(driver, PortpairGridCount);
		
		String Stringsize = getText(driver, PortpairGridCount);
		 int size =Integer.parseInt(Stringsize);
			System.out.println(size);
		Map<String,Map<String,String>> RowAmountValues=new HashMap<String, Map<String,String>>();
		
		
		for (int i = 0; i < size; i++) {
			scrollBottom(driver);
			waitForDisplay(driver, WaitForDisplay_Time);
			String row = String.valueOf(i);
			String Ele=formatLocatorDoubleClick(driver, CMS_Value_Grid_cell, row);
			mouseOverToElement(driver, Ele);
			scrollTop(driver);
			waitForElement(driver, cms_Surcharge_Header);
			List<Map<String, String>> tableData = getTableData(driver, cms_Surcharge_Header, cms_Surcharge_Body);

			String RowValue=String.valueOf(i+1);


			Map<String,String> amountValues=getValuesByHeaderMap(tableData,"Charges","Amount (LOC)");
			RowAmountValues.put(RowValue, amountValues);

		}

		
		Map<String,List<String>> ExpectedValues=convertRowAmountValues(RowAmountValues);
		System.out.println("ExpectedValues"+ExpectedValues);
		
		Map<String,List<String>> Excelvalues=new HashMap<String, List<String>>();
		
		 for (Map.Entry<String, List<String>> entry : ExpectedValues.entrySet()) {
			 String HeaderName=entry.getKey();
			 List<String> cellValues=readExcelFromDefineRow(downloaded_path,HeaderName+"(Local)",Sheet_Name,Excelrow);
			 Excelvalues.put(HeaderName, cellValues);
			
			 
		 }
		 
		 System.out.println("excelValue is: "+Excelvalues);
		
		if(CompareMapListValues2(ExpectedValues,Excelvalues)) {
			
			System.out.println(" Matched || The excepted is The Surcharge Detials From Port Pair Tab Should Matched with Downloaded  Excel Sheet || The Actual is The Surcharge Detials From Port Pair Tab is Matched with Downloaded  Excel Sheet  ");
			Extent_pass(driver, " Matched || The excepted is The Surcharge Detials From Port Pair Tab Should Matched with Downloaded  Excel Sheet || The Actual is The Surcharge Detials From Port Pair Tab is Matched with Downloaded  Excel Sheet  ", test, test1);
		}else {
			System.out.println(" Not Matched || The excepted is The Surcharge Detials From Port Pair Tab Should Matched with Downloaded  Excel Sheet || The Actual is The Surcharge Detials From Port Pair Tab is not Matched with Downloaded  Excel Sheet  ");
			Extent_fail(driver, "Not Matched || The excepted is The Surcharge Detials From Port Pair Tab Should Matched with Downloaded  Excel Sheet || The Actual is The Surcharge Detials From Port Pair Tab is not Matched with Downloaded  Excel Sheet  ", test, test1);
	
		}
		
		Step_End(9, "and click on export button.", test, test1);
		Extent_completed(testCaseName, test, test1);
		
		
		
		
		
		
	}
	
	
	
}
