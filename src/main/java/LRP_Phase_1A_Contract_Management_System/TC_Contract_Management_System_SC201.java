package LRP_Phase_1A_Contract_Management_System;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC201 extends Keywords{

	public void Contract_Management_System_SC201(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC201";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String dropdown_select = Excel_data.get("dropdown_select");
		String Multiple_Class_Counts = Excel_data.get("Multiple_Class_Counts");
		String Commodity_Headers = Excel_data.get("Commodity_Headers");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

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

		waitForDisplay(driver, Contract_Management_System_Exit);
		if (isdisplayed(driver, Contract_Management_System_Exit)) {
			click(driver, Contract_Management_System_Exit);
		} else {
			System.out.println("customer name System Page is not displayed");
		}

		Step_End(3, "Enter the customer name", test, test1);

		Step_Start(4, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);
		Step_Start(5, "once again trying to add the same commodity in different commodity class.", test, test1);

		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);

		int loopCount= Integer.parseInt(Multiple_Class_Counts);
		
		for (int i = 0; i < loopCount; i++) {

			if (i > 0) {

				waitForElement(driver, Cms_class_dropdown);
				click(driver, Cms_class_dropdown);

				String dropdown = String.format(Cms_classno_select, dropdown_select);
				waitForElement(driver, dropdown);
				safeclick(driver, dropdown);

			}

			waitForElement(driver, Contract_Management_System_Internal_Commodity);
			clear(driver, Contract_Management_System_Internal_Commodity);
			sendKeys(driver, Contract_Management_System_Internal_Commodity, Internal_Commodity);

			String select_Internal_Commmodity = String.format(Contract_Management_System_Commodity_val,
					Internal_Commodity);
			waitForElement(driver, select_Internal_Commmodity);
			safeclick(driver, select_Internal_Commmodity);

			waitForElement(driver, Contract_Management_System_Internal_Commodity_add);
			click(driver, Contract_Management_System_Internal_Commodity_add);
			

		}

		List<String> Commodity_Headers_list = splitAndExpand(Commodity_Headers, ",");
        List<Map<String, String>> tableData = getTableData(driver, Cms_Commodity_Header_grid, Cms_Commodity_Row_grid);
		String Class_report = TableDataForReport(driver, tableData, "Commodity_Headers", Commodity_Headers_list);

		System.out.println(Class_report);
		
		if (isdisplayed(driver, Cms_Commodity_Row_grid)) {
			  
			Extent_pass(driver,"When trying to add the same commodity  in different class the system  should allow " +Class_report, test, test1);
			
			
		} else {

			Extent_fail(driver,"When trying to add the same commodity  in different class the system Not allowed " , test, test1);
			
		}

 
		Step_End(4, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);
		Step_End(5, "once again trying to add the same commodity in different commodity class.", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
