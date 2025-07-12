package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC104 extends Keywords{

	public void Contract_Management_System_SC104(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
	
	
		String testCaseName = "TC_Contract_Management_System_SC104";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_Name_Value = Excel_data.get("Customer_Name_Value");
		String Internal_Commodity_Value = Excel_data.get("Internal_Commodity_Value");
		String ImportFilename = Excel_data.get("ImportFilename");
		String MainSheetName = Excel_data.get("MainSheetName");
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		moduleNavigate(driver, Contract_Management_System_Module);			
		
		Step_Start(1, "select N-N-FMC check box.", test, test1);
		waitForElement(driver, Contract_Management_System_NFMC);
		click(driver, Contract_Management_System_NFMC);		
		Step_End(1, "select N-N-FMC check box.", test, test1);

		
		Step_Start(2, "select Non-containerized check box.", test, test1);
		waitForElement(driver, Contract_Management_System_Non_Containerized);
		click(driver, Contract_Management_System_Non_Containerized);		
		Step_End(2, "select Non-containerized check box.", test, test1);

		Step_Start(3, ".Enter the customer name.", test, test1);
		waitForElement(driver, Contract_Management_System_CustomerName);
		sendKeys(driver, Contract_Management_System_CustomerName, Customer_Name_Value);

		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);
		
		waitForDisplay(driver, Contract_Management_System_Commodity);
		if (isdisplayed(driver, Contract_Management_System_Exit)) {
			click(driver, Contract_Management_System_Exit);
		} else {
			System.out.println("customer name System Page is not displayed");
		}
		
		Step_End(3, ".Enter the customer name.", test, test1);

		Step_Start(4, "switch to commodity tab and enter the commodity name and click \"+\" button.", test, test1);
		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);

		waitForElement(driver, Contract_Management_System_Internal_Commodity);
		sendKeys(driver, Contract_Management_System_Internal_Commodity, Internal_Commodity_Value);

		String select_Internal_Commmodity = String.format(Contract_Management_System_Commodity_val, Internal_Commodity_Value);
		waitForElement(driver, select_Internal_Commmodity);
		safeclick(driver, select_Internal_Commmodity);
		
		waitForElement(driver, Contract_Management_System_Internal_Commodity_add);
		click(driver, Contract_Management_System_Internal_Commodity_add);		
		Step_End(4, "switch to commodity tab and enter the commodity name and click \"+\" button.", test, test1);

		Step_Start(5, "switch to port pair tab.", test, test1);
		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);		
		Step_End(5, "switch to port pair tab.", test, test1);

		
		Step_Start(6, "import the port pair lanes without the OFR amount.", test, test1);

		waitForElement(driver, ImportExcel);
		click(driver, ImportExcel);
		
		uploadfile_new(driver, ImportInput, ImportFilename);
		
		String ExcelrowCount = rowcountxls(driver, ImportFilename, MainSheetName);
		System.out.println("ExcelrowCount : "+ExcelrowCount);
		
		waitForElement(driver, SelectSheet_dropdown1);
		click(driver, SelectSheet_dropdown1);

		String MainSheet_option = String.format(SelectMainSheet, MainSheetName);
		waitForElement(driver, MainSheet_option);
		click(driver, MainSheet_option);

		waitForElement(driver, LoadSheet_Main);
		click(driver, LoadSheet_Main);

		waitForElement(driver, Automap_Yes);
		click(driver, Automap_Yes);
		
		waitForElement(driver, Upload_Excel);
		click(driver, Upload_Excel);

		waitForDisplay(driver, Mandatory_Column_Popup);
		if(isDisplayed(driver, Mandatory_Column_Popup)) {
			System.out.println("Expected : Validation Should display when upload the file without providing OFR Value || Actual : Validation is displayed when upload the file without providing the OFR Value");
			Extent_pass_New(driver, "Expected : Validation Should display when upload the file without providing OFR Value || Actual : Validation is displayed when upload the file without providing the OFR Value", test, test1);
		}else {
			System.out.println("Expected : Validation Should display when upload the file without providing OFR Value || Actual : Validation is not displayed when upload the file without providing the OFR Value");
			Extent_fail(driver, "Expected : Validation Should display when upload the file without providing OFR Value || Actual : Validation is not displayed when upload the file without providing the OFR Value", test, test1);
		}
		
		Step_End(6, "import the port pair lanes without the OFR amount.", test, test1);
		
		Extent_completed(testCaseName, test, test1);
		
		
	}
}
