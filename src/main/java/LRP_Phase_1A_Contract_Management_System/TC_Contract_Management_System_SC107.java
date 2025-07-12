package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC107 extends Keywords{

	
	public void Contract_Management_System_SC107(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
	
		
		String testCaseName = "TC_Contract_Management_System_SC107";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_Name_Value = Excel_data.get("Customer_Name_Value");
		String Internal_Commodity_Value = Excel_data.get("Internal_Commodity_Value");
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String Rate_Type_Value = Excel_data.get("Rate_Type_Value");
		String Origin_Value = Excel_data.get("Origin_Value");
		String Delivery_Order_Value = Excel_data.get("Delivery_Order_Value");
		String POL_Value = Excel_data.get("POL_Value");
		String POD_Value = Excel_data.get("POD_Value");
		String Rate_Type_Header = Excel_data.get("Rate_Type_Header");
		String Origin_Code_Header = Excel_data.get("Origin_Code_Header");
		String Delivery_Order_Header = Excel_data.get("Delivery_Order_Header");
		String POL_Header = Excel_data.get("POL_Header");
		String POD_Header = Excel_data.get("POD_Header");
		String Gross_Weight_value = Excel_data.get("Gross_Weight_value");

		String OFR_Amount_Validation = Excel_data.get("OFR_Amount_Validation");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		moduleNavigate(driver, Contract_Management_System_Module);			
				
		Step_Start(2, "select Non-containerized check box.", test, test1);
		waitForElement(driver, Contract_Management_System_Non_Containerized);
		click(driver, Contract_Management_System_Non_Containerized);		
		Step_End(2, "select Non-containerized check box.", test, test1);
		
		Step_Start(1, ".select FMC check box.", test, test1);
		waitForElement(driver, Contract_Management_System_Fmc);
		click(driver, Contract_Management_System_Fmc);		
		Step_End(1, ".select FMC check box.", test, test1);

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

		
		Step_Start(6, "Trying to add without the OFR details", test, test1);

		waitForElement(driver, Rate_type_Search);
		click(driver,Rate_type_Search);
		twoColumnSearchWindow(driver, Rate_Type_Header, Two_Column_Search_Condition, Rate_Type_Value);			
		
		waitForElement(driver, Contract_Management_System_Origin_seach);
		click(driver,Contract_Management_System_Origin_seach);
		twoColumnSearchWindow(driver, Origin_Code_Header, Two_Column_Search_Condition, Origin_Value);
		
		waitForElement(driver, Contract_Management_System_Delivery);
		click(driver, Contract_Management_System_Delivery);
		twoColumnSearchWindow(driver, Delivery_Order_Header, Two_Column_Search_Condition, Delivery_Order_Value);
		
		if(!POL_Value.trim().equals("")) {
			waitForElement(driver, POL_Search_Button_CMS);
			click(driver,POL_Search_Button_CMS);
			twoColumnSearchWindow(driver, POL_Header, Two_Column_Search_Condition, POL_Value);
		}
		
		if(!POD_Value.trim().equals("")) {
			waitForElement(driver, POD_Search_Button_CMS);
			click(driver,POD_Search_Button_CMS);
			twoColumnSearchWindow(driver, POD_Header, Two_Column_Search_Condition, POD_Value);
		}

		if(!Gross_Weight_value.trim().equals("")) {
			waitForElement(driver, Contract_Management_System_weight);
			Newclear(driver, Contract_Management_System_weight);
			sendKeys(driver, Contract_Management_System_weight, Gross_Weight_value);
		}
		waitForElement(driver, Contract_Management_System_Add);
		click(driver,Contract_Management_System_Add);
		
		
		waitForPopup(driver, Popup_Message, OFR_Amount_Validation);
		String Act_Popup=getText(driver, Popup_Message);
		if(OFR_Amount_Validation.equals(Act_Popup)) {
			System.out.println("Popup Matched ||  Expected : "+OFR_Amount_Validation+" || Actual :  "+Act_Popup);
			Extent_pass_New(driver, "Popup Matched ||  Expected : "+OFR_Amount_Validation+" || Actual :  "+Act_Popup, test, test1);
		}else {
			System.out.println("Popup Not Matched ||  Expected : "+OFR_Amount_Validation+" || Actual :  "+Act_Popup);
			Extent_fail(driver, "Popup Not Matched ||  Expected : "+OFR_Amount_Validation+" || Actual :  "+Act_Popup, test, test1);
		}		
		
		Step_End(6, "Trying to add without the OFR details", test, test1);

		
		Extent_completed(testCaseName, test, test1);
		
		
		
		
		
		
		
	}
}
