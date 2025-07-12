package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC082 extends Keywords {
	public void Contract_Management_System_SC82(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC082";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String Eqp_Type = Excel_data.get("Eqp_Type");
		String Origin = Excel_data.get("Origin");
		String Delivery = Excel_data.get("Delivery");
		String OFR = Excel_data.get("OFR");
		String weight = Excel_data.get("weight");
		String Search_Condition = Excel_data.get("Search_Condition");
		String CMS_Equipment_Type_Header = Excel_data.get("CMS_Equipment_Type_Header");
		String Condition = Excel_data.get("Condition");
		String CMS_Delivery_Code_Header = Excel_data.get("CMS_Delivery_Code_Header");
		String CMS_Origin_Header = Excel_data.get("CMS_Origin_Header");
		String Surcharge_Name = Excel_data.get("Surcharge_Name");
		String Charges_Header = Excel_data.get("Charges_Header");
		String Surcharge_Amount = Excel_data.get("Surcharge_Amount");
		String after_Surge_Add_Colour = Excel_data.get("after_Surge_Add_Colour");
		String Before_Surge_Add_Colour = Excel_data.get("Before_Surge_Add_Colour");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		moduleNavigate(driver, Contract_Management_System_Module);

		Step_Start(1, "select NON-FMC check box", test, test1);

		waitForElement(driver, Contract_Management_System_NFMC);
		click(driver, Contract_Management_System_NFMC);

		Step_End(1, "select NON-FMC check box", test, test1);

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

		Step_Start(6, "add the port pair lanes with no surcharge in master", test, test1);

		waitForElement(driver, Eqp_Search);
		click(driver, Eqp_Search);

		twoColumnSearchWindow(driver, CMS_Equipment_Type_Header, Condition, Eqp_Type);

		waitForElement(driver, Contract_Management_System_Origin_seach);
		click(driver, Contract_Management_System_Origin_seach);

		twoColumnSearchWindow(driver, CMS_Origin_Header, Condition, Origin);

		waitForElement(driver, Contract_Management_System_Delivery);
		click(driver, Contract_Management_System_Delivery);

		twoColumnSearchWindow(driver, CMS_Delivery_Code_Header, Condition, Delivery);

		waitForElement(driver, Contract_Management_System_OFR);
		sendKeys(driver, Contract_Management_System_OFR, OFR);

		waitForElement(driver, Contract_Management_System_Valied_from);
		// isElementEnabled
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
		clearAndType(driver, Contract_Management_System_weight, weight);

		click(driver, Contract_Management_System_weight);

	scrollTop(driver);

	

		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);
		
		scrollBottom(driver);
		mouseOverToElement(driver, CMS_ItemNo_Value_Grid);
		waitForElement(driver, CMS_ItemNo_Value_Grid);

		String Act_colorCode = getTextBackgroundColor(driver, CMS_ItemNo_Value_Grid);
		System.out.println("Act_color code : " + Act_colorCode);
		String Act_color1 = getColorName(Act_colorCode);
		System.out.println("Act_color : " + Act_color1);

		if (Before_Surge_Add_Colour.equals(Act_color1)) {
			Extent_pass(driver, "Matched || Expected colour Before adding the Surcharge Rule is  : "
					+ Before_Surge_Add_Colour + " ||  Actual colour Before adding the Surcharge Rule is : " + Act_color1,
					test, test1);
			System.out.println("Matched || Expected colour Before adding the Surcharge Rule is : "
					+ Before_Surge_Add_Colour + " || Actual colour Before adding the Surcharge Rule is: " + Act_color1);

		}

		else {
			Extent_fail(driver, " NOT Matched || Expected colour Before adding the Surcharge Rule is  : "
					+ Before_Surge_Add_Colour + " ||  Actual colour Before adding the Surcharge Rule is : " + Act_color1,
					test, test1);
			System.out.println(" NOT Matched || Expected colour Before adding the Surcharge Rule is : "
					+ Before_Surge_Add_Colour + " || Actual colour Before adding the Surcharge Rule is: " + Act_color1);

		}
		Step_End(6, "add the port pair lanes with no surcharge in master", test, test1);
		Step_Start(7, "and add the charge code in surcharge rule tab.", test, test1);
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

		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);
		scrollBottom(driver);
		mouseOverToElement(driver, CMS_ItemNo_Value_Grid);
		waitForElement(driver, CMS_ItemNo_Value_Grid);

		String excepted_colorCode = getTextBackgroundColor(driver, CMS_ItemNo_Value_Grid);

		String Act_color = getColorName(excepted_colorCode);

		System.out.println("Excpted_color : " + Act_color);

		if (after_Surge_Add_Colour.equals(Act_color)) {
			Extent_pass(driver, "Matched || Expected colour After adding the Surcharge Rule is  : "
					+ after_Surge_Add_Colour + " ||  Actual colour After adding the Surcharge Rule is : " + Act_color,
					test, test1);
			System.out.println("Matched || Expected colour After adding the Surcharge Rule is : "
					+ after_Surge_Add_Colour + " || Actual colour After adding the Surcharge Rule is: " + Act_color);

		}

		else {
			Extent_fail(driver, " NOT Matched || Expected colour After adding the Surcharge Rule is  : "
					+ after_Surge_Add_Colour + " ||  Actual colour After adding the Surcharge Rule is : " + Act_color,
					test, test1);
			System.out.println(" NOT Matched || Expected colour After adding the Surcharge Rule is : "
					+ after_Surge_Add_Colour + " || Actual colour After adding the Surcharge Rule is: " + Act_color);

		}
		Step_End(7, "and add the charge code in surcharge rule tab.", test, test1);
		Extent_completed(testCaseName, test, test1);
	}

}
