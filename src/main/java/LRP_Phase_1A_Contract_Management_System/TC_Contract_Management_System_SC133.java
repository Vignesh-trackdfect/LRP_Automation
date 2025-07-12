package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC133 extends Keywords{
	
	public void Contract_Management_System_SC133(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Contract_Management_System_SC133";
		
		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String Eqp_Type = Excel_data.get("Eqp_Type");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Delivery_Header = Excel_data.get("Delivery_Header");
		String Delivery = Excel_data.get("Delivery");
		String OFR = Excel_data.get("OFR");
		String Origin_Header = Excel_data.get("Origin_Header");
		String Origin = Excel_data.get("Origin");
		
		String ImportDemurrage = Excel_data.get("ImportDemurrage");
		String ExportDemurrage = Excel_data.get("ExportDemurrage");
		String ImportDetention = Excel_data.get("ImportDetention");
		String ExportDetention = Excel_data.get("ExportDetention");
		String Rate_Note_Num = Excel_data.get("Rate_Note_Num");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String CMS_Carrier_remarks_TextField = Excel_data.get("CMS_Carrier_remarks_TextField");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Rate_Note_Descriptions = Excel_data.get("Rate_Note_Descriptions");
		String Contract_Verified = Excel_data.get("Contract_Verified");
		String Verified = Excel_data.get("Verified");
		String weight = Excel_data.get("weight");
		String GrWt = Excel_data.get("GrWt");
		String Length = Excel_data.get("Length");
		String Width = Excel_data.get("Width");
		String Height = Excel_data.get("Height");
		String Quantity = Excel_data.get("Quantity");
		String Description = Excel_data.get("Description_value");
		String Tariffs_of_General_value = Excel_data.get("Tariffs_of_General_value");
	
	Extent_Start(testCaseName, test, test1);
	
	navigateUrl(driver, url);

	LRP_Login(driver, username, password);

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

	waitForElement(driver, Contract_Management_System_RateCalc_Type);
	sendKeys(driver, Contract_Management_System_RateCalc_Type, Eqp_Type);
	
	waitForElement(driver, Contract_Management_System_Origin_seach);
	click(driver, Contract_Management_System_Origin_seach);

	twoColumnSearchWindow(driver, Origin_Header, Search_Condition, Origin);
	
	waitForElement(driver, Contract_Management_System_Delivery);
	click(driver, Contract_Management_System_Delivery);

	twoColumnSearchWindow(driver, Delivery_Header, Search_Condition, Delivery);
	
	waitForElement(driver, Contract_Management_System_OFR);
	sendKeys(driver, Contract_Management_System_OFR, OFR);
	


	waitForElement(driver, Contract_Management_System_Valied_from);
	//isElementEnabled
	if(IsElementEnabled(driver, Contract_Management_System_Valied_from)) {
		waitForElement(driver, Contract_Management_System_Valied_from);
		click(driver, Contract_Management_System_Valied_from);
		
	}else {
		System.out.println("From data is Display");
	}
	
	waitForElement(driver, Contract_Management_System_Valied_to);
	if(IsElementEnabled(driver, Contract_Management_System_Valied_to)) {
		waitForElement(driver, Contract_Management_System_Valied_to);
		click(driver, Contract_Management_System_Valied_to);
		
	}else {
		System.out.println("To data is Display");
	}
	
	waitForElement(driver, Contract_Management_System_weight);
	clearAndType(driver, Contract_Management_System_weight, weight);

	waitForElement(driver, Contract_Management_System_Add_Dimensions);
	click(driver, Contract_Management_System_Add_Dimensions);

	waitForElement(driver, Contract_Management_System_Gr_wt);
	clearAndType(driver, Contract_Management_System_Gr_wt, GrWt);
    click(driver,Contract_Management_System_Width);
	
	waitForElement(driver, Contract_Management_System_Length);
	clear(driver, Contract_Management_System_Length);
	sendKeys(driver, Contract_Management_System_Length, Length);

	waitForElement(driver, Contract_Management_System_Width);
	clear(driver, Contract_Management_System_Width);
	sendKeys(driver, Contract_Management_System_Width, Width);

	waitForElement(driver, Contract_Management_System_Height);
	clear(driver, Contract_Management_System_Height);
	sendKeys(driver, Contract_Management_System_Height, Height);
	click(driver,Contract_Management_System_Width);

	waitForElement(driver, Contract_Management_System_Quantity);
	clear(driver, Contract_Management_System_Quantity);
	sendKeys(driver, Contract_Management_System_Quantity, Quantity);
	click(driver,Contract_Management_System_Width);
	
	 waitForElement(driver, Contract_Management_System_Add_Dimensions_add_package_Description);
	 click(driver, Contract_Management_System_Add_Dimensions_add_package_Description);
	
	
	 waitForElement(driver, Contract_Management_System_Add_Dimensions_add_package_Description_input);
	 sendKeys(driver, Contract_Management_System_Add_Dimensions_add_package_Description_input, Description);
	
	 waitForElement(driver, RR_firstRow);
	 click(driver, RR_firstRow);
	
	 waitForElement(driver, Contract_Management_System_Origin_select);
	 click(driver, Contract_Management_System_Origin_select);
	
	 waitForElement(driver, Contract_Management_System_Add_Dimensions_add);
	 click(driver, Contract_Management_System_Add_Dimensions_add);
	
	 waitForDisplay(driver, Contract_Management_System_Add_Dimensions_add_ok);
	 waitForElement(driver, Contract_Management_System_Add_Dimensions_add_ok);
	 click(driver, Contract_Management_System_Add_Dimensions_add_ok);
	
	Step_End(5, "switch to port pair tab", test, test1);
	
	Step_Start(6, "select the rate note number", test, test1);
		
	String select_Rate_Note_No=String.format(Rate_Note_No, Rate_Note_Num);
	waitForElement(driver, select_Rate_Note_No);
	safeclick(driver, select_Rate_Note_No);
	if (IsElementEnabled(driver, Add_FreeDays_Btn)) {
		waitForElement(driver, Add_FreeDays_Btn);
		click(driver, Add_FreeDays_Btn);
	}
	
	waitForDisplay(driver, Contract_Management_System_import_Demurrage);
	if (IsElementEnabled(driver, Contract_Management_System_import_Demurrage)) {
		sendKeys(driver, Contract_Management_System_import_Demurrage, ImportDemurrage);
	}

	waitForDisplay(driver, Contract_Management_System_export_Demurrage);
	if (IsElementEnabled(driver, Contract_Management_System_export_Demurrage)) {
		sendKeys(driver, Contract_Management_System_export_Demurrage, ExportDemurrage);
	}
	if (IsElementEnabled(driver, Contract_Management_System_export_Detention)) {
		waitForDisplay(driver, Contract_Management_System_export_Detention);
		sendKeys(driver, Contract_Management_System_export_Detention, ImportDetention);
	}
	if (IsElementEnabled(driver, Contract_Management_System_import_Detention)) {
		waitForDisplay(driver, Contract_Management_System_import_Detention);
		sendKeys(driver, Contract_Management_System_import_Detention, ExportDetention);
	}

	scrollTop(driver);
	
	Step_End(6, "select the rate note number", test, test1);
	
	Step_Start(7, "add the port pair lanes below main grid", test, test1);
	
	waitForElement(driver, Contract_Management_System_Add);
	click(driver, Contract_Management_System_Add);
	
	Step_End(7, "add the port pair lanes below main grid", test, test1);
	
	Step_Start(8, "Enter the carrier and customer info", test, test1);
	
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
	
	waitForElement(driver, Rate_Note_Tab);
	click(driver, Rate_Note_Tab);
	
	waitForElement(driver, Rate_Note_Description);
	sendKeys(driver, Rate_Note_Description, Rate_Note_Descriptions);

	waitForElement(driver, Rate_Note_Addbtn);
	click(driver, Rate_Note_Addbtn);
	
	
	Step_End(8, "Enter the carrier and customer info", test, test1);
	
	Step_Start(9, "save the contract", test, test1);

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
	
	waitForElement(driver, Rate_Note_Tab);
	click(driver, Rate_Note_Tab);
	
	waitForElement(driver, Rate_Note_Add_Description);
	sendKeys(driver, Rate_Note_Add_Description, Rate_Note_Descriptions);

	String enteredText = getText(driver, Rate_Note_Add_Description);
	if (Rate_Note_Descriptions.equals(enteredText)) {
	    System.out.println("Matched || Expected: After click on save button, The Rate Note should be : " + Rate_Note_Descriptions + " || Actual value is After click on save button, The Rate Note is : " + enteredText);
	    Extent_pass(driver, "Matched || Expected: After click on save button, The Rate Note should be : " + Rate_Note_Descriptions + " || Actual value is After click on save button, The Rate Note : " + enteredText, test, test1);
	} else {
	    System.out.println("Not Matched || Expected: After click on save button, The Rate Note should be : " + Rate_Note_Descriptions + " || Actual value is After click on save button, The Rate Note is : " + enteredText);
	    Extent_fail(driver, "Not Matched || Expected: After click on save button, The Rate Note should be :" + Rate_Note_Descriptions + " || Actual value is After click on save button, The Rate Note is : " + enteredText, test, test1);
	}
	

	Step_End(9, "save the contract", test, test1);
	
	Extent_completed(testCaseName, test, test1);
	}

}

