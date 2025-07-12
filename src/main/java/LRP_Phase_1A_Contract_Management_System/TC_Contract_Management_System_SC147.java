package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC147 extends Keywords{
	public void Contract_Management_System_SC147(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC147";

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
		String Tariffs_of_General_Applicability = Excel_data.get("Tariffs_of_General_Applicability");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String CMS_Equipment_Type_Header = Excel_data.get("CMS_Equipment_Type_Header");
		String Condition = Excel_data.get("Condition");
		String CMS_Delivery_Code_Header = Excel_data.get("CMS_Delivery_Code_Header");
		String CMS_Origin_Header = Excel_data.get("CMS_Origin_Header");
		String Contract_Desc = Excel_data.get("Contract_Desc");
		String CMS_Carrier_remarks_TextField = Excel_data.get("CMS_Carrier_remarks_TextField");
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

		Step_Start(6, "add the port pair lanes with contract note.", test, test1);

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

		scrollTop(driver);

		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);

		// contract note

		waitForElement(driver, CMS_Contract_Note);
		click(driver, CMS_Contract_Note);
		waitForElement(driver, CMS_Contract_Note_Text);
		sendKeys(driver, CMS_Contract_Note_Text, Contract_Desc);
		
		

		scrollTop(driver);
		mouseOverToElement(driver, Contract_Management_System_General);

		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);

		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);
		
		waitForElement(driver, Contract_Management_System_Signatory_Name);
		sendKeys(driver, Contract_Management_System_Signatory_Name, Signatory_Name);

		waitForElement(driver, Contract_Management_System_Signatory_Title);
		sendKeys(driver, Contract_Management_System_Signatory_Title, Signatory_Title);

		waitForElement(driver, Cari_info_Signatory_Name);
		clear(driver, Cari_info_Signatory_Name);
		sendKeys(driver, Cari_info_Signatory_Name, Signatory_Name);

		waitForElement(driver, Cari_info_Signatory_Title);
		clear(driver, Cari_info_Signatory_Title);
		sendKeys(driver, Cari_info_Signatory_Title, Signatory_Title);

		waitForElement(driver, CMS_Carrier_Remarks_Field);
		sendKeys(driver, CMS_Carrier_Remarks_Field, CMS_Carrier_remarks_TextField);

		Step_End(6, "Add the port pair lanes without rate note number.", test, test1);

		Step_Start(7, ".And save the contract.", test, test1);
		
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
		

		// contract note

		waitForElement(driver, CMS_Contract_Note);
		click(driver, CMS_Contract_Note);
		waitForElement(driver, CMS_Contract_Note_Text);
		String  Saved_Contract_text = getText(driver, CMS_Contract_Note_Text);
		
		if (Contract_Desc.equals(Saved_Contract_text)) {
			System.out.println("Matched || Expected the status  : After click on save button, The Contract Note should be : "
					+ Contract_Desc + " || Actual value is After click on save button, The Contract Note is : " + Saved_Contract_text);
			Extent_pass(driver,
					"Matched || Expected the status  : After click on save button, The Contract Note should be : " + Contract_Desc
							+ " || Actual value is After click on save button, The Contract Note is : " + Saved_Contract_text,
					test, test1);

		} else {

			System.out
					.println("Not Matched || Expected the status  : After click on save button, The Contract Note should be : "
							+ Contract_Desc + " || Actual value is After click on save button, The Contract Note is : " + Saved_Contract_text);
			Extent_fail(driver,
					"Not Matched || Expected the status  : After click on save button, The Contract Note should be : " + Contract_Desc
							+ " || Actual value is After click on save button, The Contract Note is : " + Saved_Contract_text,
					test, test1);

		}

		Step_End(7, ".And save the contract.", test, test1);
		Extent_completed(testCaseName, test, test1);

	}
	

}
