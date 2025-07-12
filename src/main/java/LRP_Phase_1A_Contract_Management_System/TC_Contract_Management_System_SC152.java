package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC152 extends Keywords{

	public void Contract_Management_System_SC152(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Contract_Management_System_SC152";
		
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
		String Origin_Header = Excel_data.get("Origin_Header");
		String Origin = Excel_data.get("Origin");
		
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String CMS_Carrier_remarks_TextField = Excel_data.get("CMS_Carrier_remarks_TextField");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Contract_Verified = Excel_data.get("Contract_Verified");
		String Verified = Excel_data.get("Verified");
		String Other_Provisions_textar = Excel_data.get("Other_Provisions_textar");
		String Tariffs_of_General_value = Excel_data.get("Tariffs_of_General_value");

		
	
	Extent_Start(testCaseName, test, test1);
	
	navigateUrl(driver, url);

	LRP_Login(driver, username, password);

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
	
	waitForElement(driver, Contract_Management_System_Origin_seach);
	click(driver, Contract_Management_System_Origin_seach);

	twoColumnSearchWindow(driver, Origin_Header, Search_Condition, Origin);
	
	waitForElement(driver, Contract_Management_System_Delivery);
	click(driver, Contract_Management_System_Delivery);

	twoColumnSearchWindow(driver, Delivery_Header, Search_Condition, Delivery);
	
	
	waitForElement(driver, Contract_Management_System_OFR);
	sendKeys(driver, Contract_Management_System_OFR, OFR);
	

	waitForElement(driver, Contract_Management_System_OFR);
	mouseOverToElement(driver, DG_Checkbox);
	
	
	waitForElement(driver, Contract_Management_System_Add);
	click(driver, Contract_Management_System_Add);
	
	
	Step_End(5, "switch to port pair tab", test, test1);
	
	Step_Start(6, "add the port pair lanes with Other Provisions ", test, test1);
		
	waitForElement(driver, Other_Provisions_tab);
	click(driver, Other_Provisions_tab);
	
	
	waitForElement(driver, Other_Provisions_textarea);
	sendKeys(driver, Other_Provisions_textarea, Other_Provisions_textar);

	
	Step_End(6, "add the port pair lanes with Other Provisions ", test, test1);
	
	
	Step_Start(7, "save the contract", test, test1);
	
	waitForElement(driver, Contract_Management_System_General);
	click(driver, Contract_Management_System_General);

	waitForElement(driver, Contract_Management_System_General);
	click(driver, Contract_Management_System_General);
	
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
	
	waitForElement(driver, Tariffs_of_General_val);
	sendKeys(driver, Tariffs_of_General_val, Tariffs_of_General_value);
	
	waitForPopup(driver, Contract_Management_System_save, Contract_saved);	

	click(driver, Contract_Management_System_save);
	waitForPopup(driver, Popup_Message, Contract_saved);
	String saved_popup =getText(driver, Popup_Message);
	System.out.println("saved_popup :"+saved_popup);
	
	if(Contract_saved.equals(saved_popup)) {
		Extent_pass(driver,"Matched || Expected popup value was : "+Contract_saved+" || Actual popup value was is display : "+ saved_popup, test,test1);
		System.out.println("Matched || Expected popup value was : "+Contract_saved+" || Actual popup value was is display: "+ saved_popup);
	}else {
		System.out.println("Not Matched || Expected popup value was : "+Contract_saved+" || Actual popup value was not display: "+ saved_popup);
		Extent_fail(driver,"Not Matched || Expected popup value was : "+Contract_saved+" || Actual popup value was not display: "+ saved_popup, test,test1);
					
	}
	
	waitForElement(driver, Contract_Management_System_Edit);
	click(driver, Contract_Management_System_Edit);

	waitForElement(driver, Contract_Management_System_Approved);
	click(driver, Contract_Management_System_Approved);
	
	
	String verified_popup="";
	waitForDisplay(driver, Popup_Message);
	if(isdisplayed(driver, Popup_Message)) {
		verified_popup =getText(driver, Popup_Message);
		System.out.println("verified_popup :"+verified_popup);
	}
	if(isdisplayed(driver, popup_Message)) {
		click(driver, popup_Message_Yes_Button);
		waitForPopup(driver, Popup_Message, Contract_Verified);
		verified_popup =getText(driver, Popup_Message);
		System.out.println("verified_popup :"+verified_popup);
	}else {
		System.out.println("Popup message is not display");
	}
	System.out.println("verified_popup :"+verified_popup);
	
	if(Contract_Verified.equals(verified_popup)) {
		Extent_pass(driver,"Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is : "+ verified_popup, test,test1);
		System.out.println("Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is : "+ verified_popup);
	}else {
		System.out.println("Not Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is not display :"+ verified_popup);
		Extent_fail(driver,"Not Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is not display : "+ verified_popup, test,test1);
		
	}	
	
	
	waitForElement(driver, Contract_Management_System_status);
	String verifiednumber =getAttribute(driver, Contract_Management_System_status,"value");
	System.out.println("verifiednumber :"+verifiednumber);	
	
	if(Verified.equals(verifiednumber)) {
		Extent_pass(driver,"Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is :"+ verifiednumber, test,test1);
		System.out.println("Matched || Expected value is After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is :"+ verifiednumber);
	}else {
		System.out.println("Not Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is : "+ verifiednumber);
		Extent_fail(driver,"Not Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is : "+ verifiednumber, test,test1);
		
		
	}
	
	waitForElement(driver, Other_Provisions_tab);
	click(driver, Other_Provisions_tab);

	waitForElement(driver, Other_Provisions_textarea);
//	sendKeys(driver, Other_Provisions_textarea, Other_Provisions_textar);

	String enteredText = getText(driver, Other_Provisions_textarea);
	if (Other_Provisions_textar.equals(enteredText)) {
	    System.out.println("Matched || Expected: After click on save button, The Other Provisions should be : " + Other_Provisions_textar + " || Actual value is After click on save button, The Other Provisions is : " + enteredText);
	    Extent_pass(driver, "Matched || Expected: After click on save button, The Other Provisions should be : " + Other_Provisions_textar + " || Actual value is After click on save button, The Other Provisions : " + enteredText, test, test1);
	} else {
	    System.out.println("Not Matched || Expected: After click on save button, The Other Provisions should be : " + Other_Provisions_textar + " || Actual value is After click on save button, The Other Provisions is : " + enteredText);
	    Extent_fail(driver, "Not Matched || Expected: After click on save button, The Other Provisions should be :" + Other_Provisions_textar + " || Actual value is After click on save button, The Other Provisions is : " + enteredText, test, test1);
	}

	
	Step_End(7, "save the contract", test, test1);
	
	Extent_completed(testCaseName, test, test1);
	}

	
}

