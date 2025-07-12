package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Contract_Management_System_SC252 extends Keywords{


	public void Contract_Management_System_SC252(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {
 
		String testCaseName = "TC_Contract_Management_System_SC252";
 
		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String MainSheetName = Excel_data.get("MainSheetName");
		String ImportFilename = Excel_data.get("ImportFilename");
		String Tariffs_of_General_Applicability = Excel_data.get("Tariffs_of_General_Applicability");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Expected_Tab_Name = Excel_data.get("Expected_Tab_Name");

		
		String MainSheet_option = String.format(SelectMainSheet, MainSheetName);
 
		Extent_Start(testCaseName, test, test1);
 
		navigateUrl(driver, url);
 
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		moduleNavigate(driver, Contract_Management_System_Module);
 
		Step_Start(1, "select Non FMC check box", test, test1);
		Step_Start(2, "select - containerized check box", test, test1);
 
		waitForElement(driver, Contract_Management_System_Containerized);
		click(driver, Contract_Management_System_Containerized);
 
		waitForElement(driver, Contract_Management_System_NFMC);
		click(driver, Contract_Management_System_NFMC);
 
		Step_End(1, "select Non FMC check box", test, test1);
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
 
		Step_Start(6, ".Import the port pair lanes", test, test1);
 
		waitForElement(driver, ImportExcel);
		click(driver, ImportExcel);
 
		uploadfile_new(driver, ImportInput, ImportFilename);
 
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
 
		scrollTop(driver);
		
		
		Step_End(6, ".Import the port pair lanes", test, test1);
 
		Step_Start(7, "calculate the routing and surcharge.", test, test1);
		
		waitForElement(driver, RouteSch);
		click(driver, RouteSch);
 
		waitForDisplay(driver, RouteSch_Ok);
		click(driver, RouteSch_Ok);
		
  
		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);
 
		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);
 
		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);
 
		waitForPopup(driver, Popup_Message, Contract_saved);
		String saved_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + saved_popup);
 
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
		
		waitForElement(driver, CMS_Customer_Profile_Btn);
		click(driver, CMS_Customer_Profile_Btn);
		
		waitForElement(driver, CMS_Verify_Tab); 
		String Actual_Tab_Name = getText(driver, CMS_Verify_Tab);
		
		if(Actual_Tab_Name.equals(Expected_Tab_Name)) {
			
			System.out.println("Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name);
			Extent_pass_New(driver, "Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name, test, test1);
			
		}else {
			System.out.println("Not Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name);
			Extent_fail(driver, "Not Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name, test, test1);
		}
		
		
		Step_End(7, "calculate the routing and surcharge.", test, test1);

		Extent_completed(testCaseName, test, test1);
		
		
		

	}

}


