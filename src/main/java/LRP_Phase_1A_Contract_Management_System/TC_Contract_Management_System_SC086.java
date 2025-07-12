package LRP_Phase_1A_Contract_Management_System;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC086 extends Keywords {

	public void Contract_Management_System_SC86(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC086";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String MainSheetName = Excel_data.get("MainSheetName");

		String ImportFilename = Excel_data.get("ImportFilename");

		String CMS_Charge_Amount = Excel_data.get("CMS_Charge_Amount");

		String CMS_Charge_Name = Excel_data.get("CMS_Charge_Name");

		String Search_Condition = Excel_data.get("Search_Condition");
		String Charges_Header = Excel_data.get("Charges_Header");
		String Befor_Adding_surcharge_Color = Excel_data.get("Befor_Adding_surcharge_Color");
		String After_Adding_surcharge_Color = Excel_data.get("After_Adding_surcharge_Color");

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

		Step_Start(6, ".Import the port pair lanes with no route in master", test, test1);

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
		Step_End(6, ".Import the port pair lanes with no route in master", test, test1);

		Step_Start(7, "click on routing and surcharge button", test, test1);

		waitForElement(driver, RouteSch);
		click(driver, RouteSch);

		waitForDisplay(driver, RouteSch_Ok);
		click(driver, RouteSch_Ok);

		scrollBottom(driver);

		waitForElement(driver, CMS_ItemNo_Value_Grid);
		List<WebElement> listOfGridElements = listOfElements(driver, CMS_ItemNo_Value_Grid);
		boolean temp = true;
		for (int i = 0; i < listOfGridElements.size(); i++) {

			String Act_color = getTextBackgroundColor1(driver, listOfGridElements.get(i));

			String color1 = getColorName(Act_color);

			if (Befor_Adding_surcharge_Color.equals(color1)) {
				System.out.println(
						"Excepted ||  Imported port pair lanes with no Surcharge in the master data should be highlighted in : "
								+ Befor_Adding_surcharge_Color
								+ " || Actual Imported  Excel port pair lanes with no Surcharge is Highlighted in :"
								+ color1);
				Extent_pass(driver,
						"Excepted||  Imported port pair lanes with no Surcharge in the master data should be highlighted in : "
								+ Befor_Adding_surcharge_Color
								+ " || Actual  Imported Excel  port pair lanes with no Surcharge is Highlighted in :"
								+ color1,
						test, test1);
				temp = false;

			}
		}

		if (temp) {
			System.out.println(
					"UnExpected || Imported port pair lanes with no Surcharge in the master data should be highlighted in : "
							+ Befor_Adding_surcharge_Color
							+ " || Actual imported Excel file does not contain any lanes without  No Surcharge");
			Extent_fail(driver,
					"UnExpected || Imported port pair lanes with no Surcharge in the master data should be highlighted in : "
							+ Befor_Adding_surcharge_Color
							+ " || Actual imported Excel file does not contain any lanes without No Surcharge.",
					test, test1);
		}

		Step_End(7, "click on routing and surcharge button", test, test1);

		Step_Start(8, "Add the charge code in surcharge rule tab.", test, test1);

		scrollTop(driver);

		waitForElement(driver, Contract_Management_System_Surcharge_rule);
		click(driver, Contract_Management_System_Surcharge_rule);

		waitForElement(driver, Surcharge_Serach);
		click(driver, Surcharge_Serach);

		twoColumnSearchWindow(driver, Charges_Header, Search_Condition, CMS_Charge_Name);

		waitForElement(driver, SelectAll_Surcharge);
		click(driver, SelectAll_Surcharge);

		waitForElement(driver, CMS_Charge_Amount_field);
		clearAndType(driver, CMS_Charge_Amount_field, CMS_Charge_Amount);

		waitForElement(driver, Add_Surcharge);
		click(driver, Add_Surcharge);

		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);

		scrollBottom(driver);

		waitForElement(driver, CMS_ItemNo_Value_Grid);
		List<WebElement> listOfGridElements1 = listOfElements(driver, CMS_ItemNo_Value_Grid);
		boolean temp1 = true;
		for (int i = 0; i < listOfGridElements1.size(); i++) {

			String Act_color = getTextBackgroundColor1(driver, listOfGridElements1.get(i));

			String color1 = getColorName(Act_color);

			if (After_Adding_surcharge_Color.equals(color1)) {
				System.out.println("Excepted ||  After Adding Surcharge code  It should be highlighted in : "
						+ After_Adding_surcharge_Color
						+ "  Actual  || After Adding Surcharge code  It should be highlighted in :" + color1);
				Extent_pass(driver,
						"Excepted||  After Adding Surcharge code  It should be highlighted in :"
								+ After_Adding_surcharge_Color
								+ " Actual ||  After Adding Surcharge code  It should be highlighted in : " + color1,
						test, test1);
				temp1 = false;

			}
		}

		if (temp1) {
			System.out.println("UnExpected || After Adding Surcharge code  It should be highlighted in : "
					+ After_Adding_surcharge_Color
					+ "  Actual  || After Adding Surcharge code  It Does not highlighted ");
			Extent_fail(driver,
					"UnExpected || After Adding Surcharge code  It should be highlighted in : "
							+ After_Adding_surcharge_Color
							+ " Actual  || After Adding Surcharge code  It Does not highlighted :",
					test, test1);
		}

		Step_End(8, "Add the charge code in surcharge rule tab", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
