package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC077 extends Keywords {

	public void Contract_Management_System_SC77(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC077";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String Eqp_Type = Excel_data.get("Eqp_Type");
		String Origin = Excel_data.get("Origin");
		String Delivery = Excel_data.get("Delivery");
		String OFR = Excel_data.get("OFR");
		String GrWt = Excel_data.get("GrWt");
		String BackRoundColor = Excel_data.get("BackRoundColor");

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

		waitForDisplay(driver, Contract_Management_System_Exit);
		if (isdisplayed(driver, Contract_Management_System_Exit)) {
			click(driver, Contract_Management_System_Exit);
		} else {
			System.out.println("customer name System Page is not displayed");
		}

		Step_End(3, "Enter the customer name", test, test1);

		Step_Start(4, "switch to commodity tab and enter the commodity name and click + button.", test, test1);

		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);

		waitForElement(driver, Contract_Management_System_Internal_Commodity);
		sendKeys(driver, Contract_Management_System_Internal_Commodity, Internal_Commodity);

		String select_Internal_Commmodity = String.format(Contract_Management_System_Commodity_val, Internal_Commodity);
		waitForElement(driver, select_Internal_Commmodity);
		safeclick(driver, select_Internal_Commmodity);

		waitForElement(driver, Contract_Management_System_Internal_Commodity_add);
		click(driver, Contract_Management_System_Internal_Commodity_add);

		Step_End(4, "switch to commodity tab and enter the commodity name and click + button.", test, test1);

		Step_Start(5, "switch to port pair tab", test, test1);

		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);

		Step_End(5, "switch to port pair tab", test, test1);

		Step_Start(6, "add the port pair lanes with no surcharge in master", test, test1);

		waitForElement(driver, Contract_Management_System_Eqp_Type);
		sendKeys(driver, Contract_Management_System_Eqp_Type, Eqp_Type);

		String select_Eqp_Type = String.format(Contract_Management_System_Commodity_val, Eqp_Type);
		waitForElement(driver, select_Eqp_Type);
		safeclick(driver, select_Eqp_Type);

		waitForElement(driver, Contract_Management_System_Origin_seach);
		click(driver, Contract_Management_System_Origin_seach);

		waitForElement(driver, Contract_Management_System_Origin_seach_Input_field);
		sendKeys(driver, Contract_Management_System_Origin_seach_Input_field, Origin);

		waitForElement(driver, RR_firstRow);
		click(driver, RR_firstRow);

		waitForElement(driver, Contract_Management_System_Origin_select);
		click(driver, Contract_Management_System_Origin_select);

		waitForElement(driver, Contract_Management_System_Delivery);
		click(driver, Contract_Management_System_Delivery);

		waitForElement(driver, Contract_Management_System_Delivery_seach_Input_field);
		sendKeys(driver, Contract_Management_System_Delivery_seach_Input_field, Delivery);

		waitForElement(driver, RR_firstRow);
		click(driver, RR_firstRow);

		waitForElement(driver, Contract_Management_System_Origin_select);
		click(driver, Contract_Management_System_Origin_select);

		waitForElement(driver, Contract_Management_System_OFR);
		sendKeys(driver, Contract_Management_System_OFR, OFR);

		waitForElement(driver, Contract_Management_System_Valied_from);
		if (IsElementEnabled(driver, Contract_Management_System_Valied_from)) {
			waitForElement(driver, Contract_Management_System_Valied_from);
			click(driver, Contract_Management_System_Valied_from);

		} else {
			System.out.println("From data is Display");
		}

		waitForElement(driver, Contract_Management_System_Valied_to);
		if (IsElementEnabled(driver, Contract_Management_System_Valied_to)) {
			waitForElement(driver, Contract_Management_System_Valied_to);
			click(driver, Contract_Management_System_Valied_to);

		} else {
			System.out.println("To data is Display");
		}

		waitForElement(driver, Contract_Management_System_weight);
		clearAndType(driver, Contract_Management_System_weight, GrWt);

		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);

		scrollBottom(driver);
		mouseOverToElement(driver, CMS_ItemNo_Value_Grid);
		waitForElement(driver, CMS_ItemNo_Value_Grid);

		String Act_color = getTextBackgroundColor(driver, CMS_ItemNo_Value_Grid);

		String color1 = getColorName(Act_color);

		System.out.println("Act_color : " + Act_color);

		if (BackRoundColor.equals(color1)) {
			System.out.println(
					"Expected ||  When adding the lane, the system should highlight the no surcharge lanes in master in "
							+ BackRoundColor
							+ " || Actual:  When adding the lane, the system should highlight the no surcharge lanes in "
							+ color1);
			Extent_pass(driver,
					"Expected||   When adding the lane, the system should highlight the no surcharge lanes in master in "
							+ BackRoundColor
							+ " || Actual:   When adding the lane, the system should highlight the no surcharge lanes in "
							+ color1,
					test, test1);

		}

		else {
			System.out.println(
					"UnExpected ||  When adding the lane, the system should highlight the no surcharge lanes in "
							+ BackRoundColor
							+ " || Actual: When adding the lane, the system is not highlighting the no surcharge lanes in master.");
			Extent_fail(driver,
					"UnExpected || When adding the lane, the system should highlight the no surcharge lanes in "
							+ BackRoundColor
							+ " || Actual: When adding the lane, the system is not highlighting the no surcharge lanes in master.",
					test, test1);
		}

		Step_End(6, "add the port pair lanes with no surcharge in master", test, test1);
		Extent_completed(testCaseName, test, test1);

	}
}
