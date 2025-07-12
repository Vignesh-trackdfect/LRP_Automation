package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC097 extends Keywords {

	public void Contract_Management_System_SC97(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC097";
		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String Origin = Excel_data.get("Origin");
		String Delivery = Excel_data.get("Delivery");
		String Delivery_Validation = Excel_data.get("Delivery_Validation");
		String Origin_Validation = Excel_data.get("Origin_Validation");
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

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
		Step_Start(6, "without entering the origin & Delivery and clicking on add button", test, test1);

			
			waitForElement(driver, Contract_Management_System_Add);
			click(driver, Contract_Management_System_Add);
			Step_End(6, "without entering the origin & Delivery and clicking on add button", test, test1);

			Step_Start(7, "When the adding the system should validate for missing Origin & Delivery code", test, test1);

			waitForPopup(driver, popup_Message, Origin_Validation);
			String Validation_popup = getText(driver, popup_Message);
			System.out.println("verified_popup :" + Validation_popup);
			if (Origin_Validation.equals(Validation_popup)) {
				Extent_pass_New(driver,
						"Matched || Expected value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message should be : "
								+ Origin_Validation
								+ " || Actual value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message is : "
								+ Validation_popup,
						test, test1);
				System.out.println(
						"Matched || Expected value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message should be : "
								+ Origin_Validation
								+ " || Actual value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message is : "
								+ Validation_popup);
			} else {
				System.out.println(
						"Not Matched || Expected value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message should be : "
								+ Origin_Validation
								+ " || Actual value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message is : "
								+ Validation_popup);
				Extent_fail(driver,
						"Not Matched || Expected value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message should be : "
								+ Origin_Validation
								+ " || Actual value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message is : "
								+ Validation_popup,
						test, test1);
				}
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
			waitForElement(driver, Contract_Management_System_Origin_seach);
			click(driver, Contract_Management_System_Origin_seach);
			waitForElement(driver, Contract_Management_System_Origin_seach_Input_field);
			sendKeys(driver, Contract_Management_System_Origin_seach_Input_field, Origin);
			waitForElement(driver, RR_firstRow);
			click(driver, RR_firstRow);
			waitForElement(driver, Contract_Management_System_Origin_select);
			click(driver, Contract_Management_System_Origin_select);
		if (!Delivery.equals("")) {
			waitForElement(driver, Contract_Management_System_Delivery);
			click(driver, Contract_Management_System_Delivery);
			waitForElement(driver, Contract_Management_System_Delivery_seach_Input_field);
			sendKeys(driver, Contract_Management_System_Delivery_seach_Input_field, Delivery);
			waitForElement(driver, RR_firstRow);
			click(driver, RR_firstRow);
			waitForElement(driver, Contract_Management_System_Origin_select);
			click(driver, Contract_Management_System_Origin_select);
			
		}
		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);

		waitForPopup(driver, popup_Message, Delivery_Validation);
		 Validation_popup = getText(driver, popup_Message);
		System.out.println("verified_popup :" + Validation_popup);
		if (Delivery_Validation.equals(Validation_popup)) {
			Extent_pass_New(driver,
					"Matched || Expected value is : After Click on Add button without Entering the Delivery, Then the Pop-up message should be : "
							+ Delivery_Validation
							+ " || Actual value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message is : "
							+ Validation_popup,
					test, test1);
			System.out.println(
					"Matched || Expected value is : After Click on Add button without Entering the Delivery, Then the Pop-up message should be : "
							+ Delivery_Validation
							+ " || Actual value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message is : "
							+ Validation_popup);
		} else {
			System.out.println(
					"Not Matched || Expected value is : After Click on Add button without Entering the Delivery, Then the Pop-up message should be : "
							+ Delivery_Validation
							+ " || Actual value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message is : "
							+ Validation_popup);
			Extent_fail(driver,
					"Not Matched || Expected value is : After Click on Add button without Entering the Delivery, Then the Pop-up message should be : "
							+ Delivery_Validation
							+ " || Actual value is : After Click on Add button without Entering the Origin and Delivery, Then the Pop-up message is : "
							+ Validation_popup,
					test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(7, "When the adding the system should validate for missing Origin & Delivery code", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}