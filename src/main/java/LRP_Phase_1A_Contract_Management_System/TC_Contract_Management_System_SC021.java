package LRP_Phase_1A_Contract_Management_System;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC021  extends Keywords{

	public void Contract_Management_System_SC21(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC021";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String CMS_Charge_Amount = Excel_data.get("CMS_Charge_Amount");
		String CMS_Charge_Name = Excel_data.get("CMS_Charge_Name");
		String Eqp_Type = Excel_data.get("Eqp_Type");
		String Origin = Excel_data.get("Origin");
		String Delivery = Excel_data.get("Delivery");
		String OFR = Excel_data.get("OFR");
		String weight = Excel_data.get("weight");
		String Draft = Excel_data.get("Draft");
		String Search_Condition = Excel_data.get("Search_Condition");
		String CMS_Equipment_Type_Header = Excel_data.get("CMS_Equipment_Type_Header");
		String CMS_Delivery_Code_Header = Excel_data.get("CMS_Delivery_Code_Header");
		String CMS_Origin_Header = Excel_data.get("CMS_Origin_Header");
		String Charges_Header = Excel_data.get("Charges_Header");
		String Tariffs_of_General_Applicability = Excel_data.get("Tariffs_of_General_Applicability");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String CMS_Surcharge_Grid_Header = Excel_data.get("CMS_Surcharge_Grid_Header");


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
		
        Step_Start(5, "Switch to surcharge rule tab and select the charge code and define the amount.", test, test1);
		
		
		waitForElement(driver, Contract_Management_System_Surcharge_rule);
		click(driver, Contract_Management_System_Surcharge_rule);

		waitForElement(driver, Surcharge_Serach);
		click(driver, Surcharge_Serach);
		
		
		twoColumnSearchWindow(driver, Charges_Header, Search_Condition, CMS_Charge_Name);
		
		waitForElement(driver, SelectAll_Surcharge);
    	click(driver,SelectAll_Surcharge);

	    waitForElement(driver, CMS_Charge_Amount_field);
	    click(driver, CMS_Charge_Amount_field);
	    clearAndType(driver, CMS_Charge_Amount_field, CMS_Charge_Amount);
		

		waitForElement(driver, Add_Surcharge);
		click(driver, Add_Surcharge);
		
		scrollBottom(driver);
		
		reArrangeAG_GridColumns(driver, CMS_Surcharge_Grid_Header);
		

		waitForElement(driver, CMS_Surcharge_Filter_Btn);
		click(driver, CMS_Surcharge_Filter_Btn);
	 
		waitForElement(driver, CMS_Eqp_Filter_Field);
		sendKeys(driver, CMS_Eqp_Filter_Field, Eqp_Type);
		
		waitForElement(driver, CMS_Add_Amount_Capture);
		String CMS_Surcharge_Amount = getText(driver, CMS_Add_Amount_Capture);
		
		double Sur_Amount=getNumberValue(CMS_Surcharge_Amount);
		
		System.out.println("CMS_Surcharge_Amount is " +Sur_Amount);
		
		
		Step_End(5, "Switch to surcharge rule tab and select the charge code and define the amount.", test, test1);
		
       Step_Start(6, "switch to port pair tab", test, test1);
		
		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);
		
		Step_End(6, "switch to port pair tab", test, test1);
		
		Step_Start(7, "Enter the equipment", test, test1);
		
		
		waitForElement(driver, Eqp_Search);
		click(driver, Eqp_Search);
		
		twoColumnSearchWindow(driver, CMS_Equipment_Type_Header, Search_Condition, Eqp_Type);
		
	
		Step_End(7, "Enter the equipment", test, test1);
		
		Step_Start(8, "Enter the origin", test, test1);
		
		waitForElement(driver, Contract_Management_System_Origin_seach);
		click(driver, Contract_Management_System_Origin_seach);
		
		twoColumnSearchWindow(driver, CMS_Origin_Header, Search_Condition, Origin);
		
		
		Step_End(8, "Enter the origin", test, test1);
		
		Step_Start(9, "Enter the delivery", test, test1);	
		
		waitForElement(driver, Contract_Management_System_Delivery);
		click(driver, Contract_Management_System_Delivery);
		
		
		twoColumnSearchWindow(driver, CMS_Delivery_Code_Header, Search_Condition, Delivery);
	
		Step_End(9, "Enter the delivery", test, test1);	
		
		Step_Start(10, "Enter the OFR", test, test1);	
		
		waitForElement(driver, Contract_Management_System_OFR);
		sendKeys(driver, Contract_Management_System_OFR, OFR);
		
		Step_End(10, "Enter the OFR", test, test1);	
		
		Step_Start(11, "Enter the gross weight", test, test1);
		
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
		

		Step_End(11, "Enter the gross weight", test, test1);
		
		Step_Start(12, "click ADD.", test, test1);
		
		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);
		
		Step_End(12, "click ADD.", test, test1);
		
		Step_Start(13, "click Save", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);
		
		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);
		
		waitForElement(driver, Contract_Management_System_Signatory_Name);
		sendKeys(driver, Contract_Management_System_Signatory_Name, Signatory_Name);

		waitForElement(driver, Contract_Management_System_Signatory_Title);
		sendKeys(driver, Contract_Management_System_Signatory_Title, Signatory_Title);
		
		
		
         waitForElement(driver, Contract_Management_System_save);
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
		
		
		waitForElement(driver, Contract_Management_System_status);
		String Draft_Confirm =getAttribute(driver, Contract_Management_System_status,"value");
		
		
		if(Draft.equals(Draft_Confirm)) {
			System.out.println("Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draft_Confirm);
			Extent_pass(driver,"Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draft_Confirm, test,test1);
			
		}else {
			
			System.out.println("Not Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draft_Confirm);
			Extent_fail(driver,"Not Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draft_Confirm, test,test1);
			
		}
		

		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);
		
		scrollBottom(driver);
		
			
		waitForElement(driver, CMS_ItemNo_Value_Grid);
		doubleClick(driver, CMS_ItemNo_Value_Grid);
		
		scrollTop(driver);
		
		
		
		waitForElement(driver, cms_Surcharge_Header);
		List<Map<String, String>> tableData = getTableData(driver, cms_Surcharge_Header, cms_Surcharge_Body);
         
		
		String BAFValue=getValueByFirstColumnAndHeader(tableData,"Charges","BAF","Amount (LOC)");
		

		double Portpair_Sur_Amt=getNumberValue(BAFValue);
		System.out.println("Surcharge Amount LOC :" + Portpair_Sur_Amt);
		
		
		
		if(Sur_Amount==(Portpair_Sur_Amt)) {
			Extent_pass(driver," Expected : The amount added in Surcharge Rule Tab  is: "+Sur_Amount+" || Actual : After Overewriting the Amount in Port Pair tab is : "+ Portpair_Sur_Amt, test,test1);
			System.out.println(" Expected : The amount added in Surcharge Rule Tab  is : "+Sur_Amount+" || Actual : After Overewriting the Amount in Port Pair tab is : "+ Portpair_Sur_Amt);
		}else {
			System.out.println("UnExpected :The amount added in Surcharge Rule Tab is  "+Sur_Amount+" || Actual : After Overewriting the Amount in Port Pair tab is : "+ Portpair_Sur_Amt);
			Extent_fail(driver,"UnExpected : The amount added in Surcharge Rule Tab  is : "+Sur_Amount+" || Actual : After Overewriting the Amount in Port Pair tab is : "+ Portpair_Sur_Amt, test,test1);
						
		}
		
		
		
	
		Step_End(13, "click Save", test, test1);
		
		
		
		
		Extent_completed(testCaseName, test, test1);
		
	
	}	
}
