package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC089  extends Keywords {

	public void Contract_Management_System_SC89(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Contract_Management_System_SC089";
		
		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String Eqp_Type = Excel_data.get("Eqp_Type");
		String CMS_Equipment_Type_Header = Excel_data.get("CMS_Equipment_Type_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Delivery_Header = Excel_data.get("Delivery_Header");
		String Delivery = Excel_data.get("Delivery");
		String OFR = Excel_data.get("OFR");
		String originmissing_popup = Excel_data.get("originmissing_popup");
		
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
	
		waitForDisplay(driver, Contract_Management_System_Commodity);
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
	
		waitForElement(driver, Eqp_Search);
		click(driver, Eqp_Search);
		twoColumnSearchWindow(driver, CMS_Equipment_Type_Header, Search_Condition, Eqp_Type);
		
		waitForElement(driver, Contract_Management_System_Delivery);
		click(driver, Contract_Management_System_Delivery);

		twoColumnSearchWindow(driver, Delivery_Header, Search_Condition, Delivery);
		
		
		waitForElement(driver, Contract_Management_System_OFR);
		sendKeys(driver, Contract_Management_System_OFR, OFR);
		
 
		waitForElement(driver, Contract_Management_System_OFR);
		mouseOverToElement(driver, DG_Checkbox);
		
		Step_End(5, "switch to port pair tab", test, test1);
		
		Step_Start(6, "without entering the  origin and clicking on add button", test, test1);
 
		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);
		
		
		waitForPopup(driver, popup_Message, originmissing_popup);
   		String Popup_Text_Act=getText(driver, popup_Message);
		
		if(Popup_Text_Act.equals(originmissing_popup)) {
			System.out.println("Popup Matched  ||   Expected popup: "+ originmissing_popup+"   ||   Actual popup :  "+ Popup_Text_Act);
			Extent_pass(driver, "Popup Matched  ||   Expected popup: "+ originmissing_popup+"   ||   Actual popup  : "+ Popup_Text_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected popup:  "+ originmissing_popup+"   ||   Actual popup  : "+ Popup_Text_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected popup : "+ originmissing_popup+"   ||   Actual popup  : "+ Popup_Text_Act, test, test1);
		}
			Step_End(6, "without entering the  origin and clicking on add button", test, test1);
			
			
		Extent_completed(testCaseName, test, test1);
		
	
   }
 
}
	

