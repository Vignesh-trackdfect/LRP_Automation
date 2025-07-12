package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC196 extends Keywords {
	public void Contract_Management_System_SC196(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC196";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String Loop_count = Excel_data.get("Loop_count");
		String already_commodity_existpopup = Excel_data.get("already_commodity_existpopup");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		moduleNavigate(driver, Contract_Management_System_Module);

		Step_Start(1, "select N-FMC check box", test, test1);

		waitForElement(driver, Contract_Management_System_NFMC);
		click(driver, Contract_Management_System_NFMC);

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

		waitForDisplay(driver, Contract_Management_System_Exit);
		if (isdisplayed(driver, Contract_Management_System_Exit)) {
			click(driver, Contract_Management_System_Exit);
		} else {
			System.out.println("customer name System Page is not displayed");
		}

		Step_End(3, "Enter the customer name", test, test1);

		Step_Start(4, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);
		Step_Start(5, "once again trying to add the same commodity in same commodity class.", test, test1);

		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);

		int loopCount = Integer.parseInt(Loop_count);
		for (int i = 0; i <= loopCount; i++) {

			waitForElement(driver, Contract_Management_System_Internal_Commodity);
			clear(driver, Contract_Management_System_Internal_Commodity);
			sendKeys(driver, Contract_Management_System_Internal_Commodity, Internal_Commodity);

			String select_Internal_Commmodity = String.format(Contract_Management_System_Commodity_val,
					Internal_Commodity);
			waitForElement(driver, select_Internal_Commmodity);
			safeclick(driver, select_Internal_Commmodity);

			waitForElement(driver, Contract_Management_System_Internal_Commodity_add);
			click(driver, Contract_Management_System_Internal_Commodity_add);

			if (i > 0) {

				waitForPopup(driver, Popup_Message, already_commodity_existpopup);
				String Popup_Text_Act = getText(driver, Popup_Message);

				if (Popup_Text_Act.equals(already_commodity_existpopup)) {
					System.out.println(
							" Matched  || Again trying to add the same commodity in same commodity class, Expected Popup is : "
									+ already_commodity_existpopup
									+ "   || Again trying to add the same commodity in same commodity class, Actual popup is : "
									+ Popup_Text_Act);
					Extent_pass(driver,
							" Matched  || Again trying to add the same commodity in same commodity class, Expected Popup is : "
									+ already_commodity_existpopup
									+ "   || Again trying to add the same commodity in same commodity class, Actual popup is : "
									+ Popup_Text_Act,
							test, test1);
				} else {
					System.out.println(
							"Not Matched  || Again trying to add the same commodity in same commodity class, Expected Popup is : "
									+ already_commodity_existpopup
									+ "   ||Again trying to add the same commodity in same commodity class, Actual popup is : "
									+ Popup_Text_Act);
					Extent_fail(driver,
							"Not Matched  || Again trying to add the same commodity in same commodity class, Expected Popup is : "
									+ already_commodity_existpopup
									+ "   || Again trying to add the same commodity in same commodity class, Actual popup is : "
									+ Popup_Text_Act,
							test, test1);

				}

			}

		}

		Step_End(4, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);
		Step_End(5, "once again trying to add the same commodity in same commodity class.", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
