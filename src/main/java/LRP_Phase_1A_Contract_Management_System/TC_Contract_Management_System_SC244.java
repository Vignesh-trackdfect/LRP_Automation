package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC244 extends Keywords {

	public void Contract_Management_System_SC244(WebDriver driver, ExtentTest test, ExtentTest test1,

			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC244";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String MainSheetName = Excel_data.get("MainSheetName");
		String ImportFilename = Excel_data.get("ImportFilename");
		String Column_Header = Excel_data.get("Column_Header");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String Tariffs_of_General_Applicability = Excel_data.get("Tariffs_of_General_Applicability");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Contract_Verified = Excel_data.get("Contract_Verified");
		String Activated = Excel_data.get("Activated");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition = Excel_data.get("Search_Condition");
		
		
		String MainSheet_option = String.format(SelectMainSheet, MainSheetName);
 
		Extent_Start(testCaseName, test, test1);
 
		navigateUrl(driver, url);
 
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		moduleNavigate(driver, Contract_Management_System_Module);
 
		Step_Start(1, "select Non_FMC check box", test, test1);
 
		waitForElement(driver, Contract_Management_System_NFMC);
		click(driver, Contract_Management_System_NFMC);
 
		Step_End(1, "select NON_FMC check box", test, test1);
 
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
		
		Step_Start(4, "Add named customer.", test, test1);
		
		waitForElement(driver, CMS_Addnamed_customer);
		click(driver, CMS_Addnamed_customer);
 
		globalValueSearchWindow(driver, Search_Condition, Select_field, Customer_code_Value, "", "", "", "");
 
		waitForElement(driver, CMS_Aff_checkbox);
		doubleClick(driver, CMS_Aff_checkbox);
 
		Step_End(4, "Add named customer.", test, test1);
 
 
		Step_Start(5, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);
 
		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);
 
		waitForElement(driver, Contract_Management_System_Internal_Commodity);
		sendKeys(driver, Contract_Management_System_Internal_Commodity, Internal_Commodity);
 
		String select_Internal_Commmodity = String.format(Contract_Management_System_Commodity_val, Internal_Commodity);
		waitForElement(driver, select_Internal_Commmodity);
		safeclick(driver, select_Internal_Commmodity);
 
		waitForElement(driver, Contract_Management_System_Internal_Commodity_add);
		click(driver, Contract_Management_System_Internal_Commodity_add);
 
		Step_End(5, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);
 
		Step_Start(6, "switch to port pair tab", test, test1);
 
		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);
 
		Step_End(6, "switch to port pair tab", test, test1);
 
		Step_Start(7, ".Import the port pair lanes", test, test1);
 
		waitForElement(driver, ImportExcel);
		click(driver, ImportExcel);
 
		uploadfile_new(driver, ImportInput, ImportFilename);
 
		String ExcelrowCount = rowcountxls(driver, ImportFilename, MainSheetName);
 
		waitForElement(driver, SelectSheet_dropdown1);
		click(driver, SelectSheet_dropdown1);
 
		waitForElement(driver, MainSheet_option);
		click(driver, MainSheet_option);
 
		waitForElement(driver, LoadSheet_Main);
		click(driver, LoadSheet_Main);
 
		waitForElement(driver, Automap_Yes);
		click(driver, Automap_Yes);
 
		waitForElement(driver, Upload_Excel);
		click(driver, Upload_Excel);
 
		scrollBottom(driver);
 
		waitForElement(driver, PortpairGridCount);
		String gridcount = getText(driver, PortpairGridCount).trim();
 
		if (gridcount.equals(ExcelrowCount)) {
 
			System.out.println("All the row values are imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "All the row values are imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		} else {
 
			System.out.println("Some of the row values are not imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "Some of the row values are not imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		}
 
		scrollTop(driver);
		Step_End(7, ".Import the port pair lanes", test, test1);
 
		Step_Start(8, "calculate the routing and surcharge.", test, test1);
		
		waitForElement(driver, RouteSch);
		click(driver, RouteSch);
 
		waitForDisplay(driver, RouteSch_Ok);
		click(driver, RouteSch_Ok);
		
		//switch to general tab and click on save
		
		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);
 
		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);
		
		waitForElement(driver, Contract_Management_System_Signatory_Name);
		sendKeys(driver, Contract_Management_System_Signatory_Name, Signatory_Name);
 
		waitForElement(driver, Contract_Management_System_Signatory_Title);
		sendKeys(driver, Contract_Management_System_Signatory_Title, Signatory_Title);
		
		waitForElement(driver, Cms_Contract_effective_Date);
		String effective_date = getAttribute(driver, Cms_Contract_effective_Date, "value");
		System.out.println(effective_date);
		waitForElement(driver, Cms_Contract_expiry_Date);
		String expiry_date =getAttribute(driver, Cms_Contract_expiry_Date, "value");
		System.out.println(expiry_date);
		
		
 
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
		
		Step_End(8, "calculate the routing and surcharge.", test, test1);
 
		Step_Start(9, "And activate the contract..", test, test1);
		
		// Step start to verify and Activate
		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);
		
		
		waitForElement(driver, Contract_Management_System_Approved);
		click(driver, Contract_Management_System_Approved);
		

	
		
		waitForPopup(driver, Popup_Message, Contract_Verified);
		String verified_popup =getText(driver, Popup_Message);
		System.out.println("verified_popup :"+verified_popup);
		
		if(Contract_Verified.equals(verified_popup)) {
			Extent_pass(driver,"Matched || Expected value is : After click on Verify button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on Verify button the popup  message is : "+ verified_popup, test,test1);
			System.out.println("Matched || Expected value is : After click on Verify button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on Verify button the popup  message is : "+ verified_popup);
		}else {
			System.out.println("Not Matched || Expected value is : After click on Verify button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on Verify button the popup  message is not display :"+ verified_popup);
			Extent_fail(driver,"Not Matched || Expected value is : After click on Verify button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on Verify button the popup  message is not display : "+ verified_popup, test,test1);
			
		}	
		
		
		// steps to activate	
 
		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);
		
		waitForElement(driver, Contract_Management_System_Active);
		click(driver, Contract_Management_System_Active);
		
//		
		
        waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			waitForDisplay(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		} else {
			System.out.println("Popup message is not display");
		}
		
		
		waitForElement(driver, Contract_Management_System_status);
		String Activated_avl = getAttribute(driver, Contract_Management_System_status, "value");
		System.out.println("Activated_avl :" + Activated_avl);
 
		if (Activated_avl.equals(Activated)) {
			System.out.println("Matched || Expected value is : After click on Activate button, The status should be  : " + Activated + " || Actual value is : After click on Activate button, The status is :" + Activated_avl);
			Extent_pass(driver,"Matched || Expected value is : After click on Activate button, The status should be  : " + Activated + " || Actual value is : After click on Activate button, The status is :" + Activated_avl, test,test1);
			
		} else {
 
			System.out.println("UnMatched || Expected value is : After click on Activate button, The status should be  : " + Activated + " || Actual value is : After click on Activate button, The status is :" + Activated_avl);
 
			Extent_fail(driver,"UnMatched || Expected value is : After click on Activate button, The status should be  : " + Activated + " || Actual value is : After click on Activate button, The status is :" + Activated_avl, test,test1);
		
		}
		
		
		waitForDisplay(driver, Contract_Management_System_port_pair);
		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);
		
		scrollBottom(driver);
		reArrangeAG_GridColumns(driver, Column_Header);
		waitForElement(driver, Cms_validfrom_gridvalue);
		String Valid_from_date = getText(driver, Cms_validfrom_gridvalue);
		System.out.println("Valid_from_date is " +effective_date);
		
		
		waitForElement(driver, Cms_validto_gridvalue);
		String Valid_to_date = getText(driver, Cms_validto_gridvalue);
		System.out.println("Valid_to_date is "+Valid_to_date);
		
		if(effective_date.equals(Valid_from_date)) {
			Extent_pass(driver,"Matched || Expected value is : After click on Active button, The Effective date from Gendral tab should be : "+effective_date+" || Actual value is :  After click on Active button, The validfrom date from potpair tab is :"+ Valid_from_date, test,test1);
			System.out.println("Matched || Expected value is  After click on Active button, The Effective date from Gendral tab should be: "+effective_date+" || Actual value is : After click on Active button, The validfrom date from potpair tab is :"+ Valid_from_date);
		}else {
			System.out.println("Not Matched || Expected value is :  After click on Active button, The Effective date from Gendral tab should be: "+effective_date+" || Actual value is : After click on Active button, The validfrom date from potpair tab is : "+ Valid_from_date);
			Extent_fail(driver,"Not Matched || Expected value is :  After click on Active button, The Effective date from Gendral tab should be : "+effective_date+" || Actual value is : After click on Active button, The validfrom date from potpair tab is : "+ Valid_from_date, test,test1);
	

	}


		if(expiry_date.equals(Valid_to_date)) {
			Extent_pass(driver,"Matched || Expected value is : After click on Active button, The expiry date from Gendral tab should be : "+expiry_date+" || Actual value is :  After click on Active button, The validTo date from potpair tab is :"+ Valid_to_date, test,test1);
			System.out.println("Matched || Expected value is  After click on Active button, The expiry date from Gendral tab should be: "+expiry_date+" || Actual value is : After click on Active button, The validTo date from potpair tab is :"+ Valid_to_date);
		}else {
			System.out.println("Not Matched || Expected value is :  After click on Active button, The expiry date from Gendral tab should be: "+expiry_date+" || Actual value is : After click on Active button, The validTo date from potpair tab is : "+ Valid_to_date);
			Extent_fail(driver,"Not Matched || Expected value is :  After click on Active button, The expiry date from Gendral tab should be : "+expiry_date+" || Actual value is : After click on Active button, The validTo date from potpair tab is : "+ Valid_to_date, test,test1);
	

	}
		Step_End(9, "And activate the contract..", test, test1);
		Extent_completed(testCaseName, test, test1);
		
}


}
