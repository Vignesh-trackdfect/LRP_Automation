package LRP_Commercial_V1_Contract_Management_System_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Contract_Management_System_SC009 extends Keywords {


	public void Contract_Management_System_SC009(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Contract_Management_System_SC009";
		
		
		

		


		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String MainSheetName = Excel_data.get("MainSheetName");
		String DGSheetName = Excel_data.get("DGSheetName");
		String OOGSheetName = Excel_data.get("OOGSheetName");
		String ImportFilename = Excel_data.get("ImportFilename");
		String Tariffs_of_General_Applicability = Excel_data.get("Tariffs_of_General_Applicability");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String Verified = Excel_data.get("Verified");
		String Contract_Verified = Excel_data.get("Contract_Verified");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Contract_Activated = Excel_data.get("Contract_Activated");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition2 = Excel_data.get("Search_Condition2");
		String Surcharge_Name = Excel_data.get("Surcharge_Name");
		String Contract_Activated_popup = Excel_data.get("Contract_Activated_popup");
		String Contract_Amendment = Excel_data.get("Contract_Amendment");
		String Remark = Excel_data.get("Remark");
		String Charges_Header = Excel_data.get("Charges_Header");
		
		
		
		String MainSheet_option = String.format(SelectMainSheet, MainSheetName);
		String DGheet_option = String.format(SelectDGSheet, DGSheetName);
		String OOGSheet_option = String.format(SelectOOGSheet, OOGSheetName);

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

		waitForElement(driver, Contract_Management_System_Surcharge_rule);
		click(driver, Contract_Management_System_Surcharge_rule);

		waitForElement(driver, Surcharge_Serach);
		click(driver, Surcharge_Serach);

		twoColumnSearchWindow(driver, Charges_Header, Search_Condition, Surcharge_Name);

		waitForElement(driver, SelectAll_Surcharge);
		click(driver, SelectAll_Surcharge);

		waitForElement(driver, Add_Surcharge);
		click(driver, Add_Surcharge);

		Step_Start(5, "switch to port pair tab", test, test1);

		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);

		Step_End(5, "switch to port pair tab", test, test1);

		Step_Start(6, "Click on the import excel button", test, test1);

		waitForElement(driver, ImportExcel);
		click(driver, ImportExcel);

		uploadfile_new(driver, ImportInput, ImportFilename);

		Step_End(6, "Click on the import excel button", test, test1);

		Step_Start(7, "select the sheet,click import", test, test1);

		String ExcelrowCount = rowcountxls(driver, ImportFilename, MainSheetName);

		waitForElement(driver, SelectSheet_dropdown1);
		click(driver, SelectSheet_dropdown1);

		waitForElement(driver, MainSheet_option);
		click(driver, MainSheet_option);

		waitForElement(driver, LoadSheet_Main);
		click(driver, LoadSheet_Main);

		waitForElement(driver, Automap_Yes);
		click(driver, Automap_Yes);

		waitForElement(driver, ImportExcel_DG);
		click(driver, ImportExcel_DG);

		waitForElement(driver, SelectSheet_dropdown2);
		click(driver, SelectSheet_dropdown2);

		waitForElement(driver, DGheet_option);
		click(driver, DGheet_option);

		waitForElement(driver, LoadSheet_DG);
		click(driver, LoadSheet_DG);

		waitForElement(driver, Automap_Yes);
		click(driver, Automap_Yes);

		waitForElement(driver, ImportExcel_OOG);
		click(driver, ImportExcel_OOG);

		waitForElement(driver, SelectSheet_dropdown3);
		click(driver, SelectSheet_dropdown3);

		waitForElement(driver, OOGSheet_option);
		click(driver, OOGSheet_option);

		waitForElement(driver, LoadSheet_OOG);
		click(driver, LoadSheet_OOG);

		waitForElement(driver, Automap_Yes);
		click(driver, Automap_Yes);

		waitForElement(driver, Upload_Excel);
		click(driver, Upload_Excel);

		scrollBottom(driver);

		waitForElement(driver, PortpairGridCount);
		String gridcount = getText(driver, PortpairGridCount).trim();

		if (gridcount.equals(ExcelrowCount)) {

			System.out.println("All the row values are imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "All the row values are imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		} else {

			System.out.println("Some of the row values are not imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "Some of the row values are not imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		}

		scrollTop(driver);

		Step_End(7, "select the sheet,click import", test, test1);

		Step_Start(8, "Click route/S.ch", test, test1);

		waitForElement(driver, RouteSch);
		click(driver, RouteSch);

		waitForDisplay(driver, RouteSch_Ok);
		click(driver, RouteSch_Ok);

		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);

		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);

		Step_End(8, "Click route/S.ch", test, test1);

		Step_Start(9, "click Save", test, test1);

		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);

		waitForPopup(driver, Popup_Message, Contract_saved);

		String saved_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + saved_popup);


		
		if(Contract_saved.equals(saved_popup)) {
			Extent_pass(driver,"Matched || Expected popup value was : "+Contract_saved+" ||  Actual popup value was is display : "+ saved_popup, test,test1);
			System.out.println("Matched || Expected popup value was : "+Contract_saved+" || Actual popup value was is display: "+ saved_popup);
		}else {
			System.out.println("Not Matched || Expected popup value was : "+Contract_saved+" || Actual popup value was not display: "+ saved_popup);
			Extent_fail(driver,"Not Matched || Expected popup value was : "+Contract_saved+" || Actual popup value was not display: "+ saved_popup, test,test1);
						
		}

		Step_End(9, "click Save", test, test1);

		Step_Start(10, "Retrieve the contract in the global search", test, test1);

		waitForElement(driver, Contract_Management_System_contract);
		String contract_number = getAttribute(driver, Contract_Management_System_contract, "value");
		System.out.println("contect_number :" + contract_number);

		waitForElement(driver, Contract_Management_System_status);
		String Draftnumber = getAttribute(driver, Contract_Management_System_status, "value");
		System.out.println("Draftnumber :" + Draftnumber);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition2, Select_field, contract_number, "", "", "", "");

		Step_End(10, "Retrieve the contract in the global search", test, test1);

		Step_Start(11, "click edit", test, test1);

		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);

		Step_End(11, "click edit", test, test1);

		Step_Start(12, "Enter the signatory name and tittle", test, test1);

		waitForElement(driver, Contract_Management_System_Signatory_Name);
		sendKeys(driver, Contract_Management_System_Signatory_Name, Signatory_Name);

		waitForElement(driver, Contract_Management_System_Signatory_Title);
		sendKeys(driver, Contract_Management_System_Signatory_Title, Signatory_Title);

		Step_End(12, "Enter the signatory name and tittle", test, test1);

		Step_Start(13, " click verify", test, test1);

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
		if(Contract_Verified.equals(verified_popup)) {
			Extent_pass(driver,"Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is : "+ verified_popup, test,test1);
			System.out.println("Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is : "+ verified_popup);
		}else {
			System.out.println("Not Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is not display :"+ verified_popup);
			Extent_fail(driver,"Not Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is not display : "+ verified_popup, test,test1);
			
		}	
		waitForElement(driver, Contract_Management_System_status);
		String verifiednumber = getAttribute(driver, Contract_Management_System_status, "value");
		System.out.println("verifiednumber :" + verifiednumber);


		if(Verified.equals(verifiednumber)) {
			Extent_pass(driver,"Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is :"+ verifiednumber, test,test1);
			System.out.println("Matched || Expected value is After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is :"+ verifiednumber);
		}else {
			System.out.println("Not Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is : "+ verifiednumber);
			Extent_fail(driver,"Not Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is : "+ verifiednumber, test,test1);
			
			
		}


		
		Step_End(13, " click verify", test, test1);

		Step_Start(14, "Enter the signatory date", test, test1);

		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);

		Step_End(14, " Enter the signatory date", test, test1);

		Step_Start(15, "click activate", test, test1);

		waitForElement(driver, Contract_Management_System_Active);
		click(driver, Contract_Management_System_Active);

		String verified_popup2="";
		waitForDisplay(driver, Popup_Message);
		if (isdisplayed(driver, Popup_Message)) {
			System.out.println("popup message is not display");
			waitForPopup(driver, Popup_Message, Contract_Verified);
			verified_popup2 = getText(driver, Popup_Message);
		} else {
			waitForDisplay(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			waitForPopup(driver, Popup_Message, Contract_Verified);
			verified_popup2 = getText(driver, Popup_Message);
		}
		System.out.println("verified_popup :" + verified_popup2);


		if (Contract_Activated_popup.equals(verified_popup2)) {
			System.out.println("Matched || Expected value is :  After click on edit button, The status should be : " + Contract_Activated_popup + " || Actual value is :  After click on edit button, The status is : "+ verified_popup2);
			Extent_pass(driver, "Matched || Expected value is :  After click on edit button, The status should be :" + Contract_Activated_popup + " || Actual value is :  After click on edit button, The status is : "+ verified_popup2, test, test1);
			
		} else {
			System.out.println("Not Matched || Expected value is :  After click on edit button, The status should be :  " + Contract_Activated_popup + " || Actual value is :  After click on edit button, The status is : "+ verified_popup2);
			Extent_fail(driver, "Not Matched || Expected value is :  After click on edit button, The status should be :" + Contract_Activated_popup + " || Actual value is :  After click on edit button, The status is : "+ verified_popup2, test, test1);
			
		}

		waitForElement(driver, Contract_Management_System_status);
		String Currentstatus = getAttribute(driver, Contract_Management_System_status, "value");

	
		if (Contract_Activated.equals(Currentstatus)) {
			System.out.println("Matched || Expected value is : After click on edit button, The status should be : " + Contract_Activated + " Actual value is : After click on edit button, The status is : " + Currentstatus);
			Extent_pass(driver,"Matched || Expected value is : After click on edit button, The status should be : " + Contract_Activated + " Actual value is : After click on edit button, The status is :" + Currentstatus,test, test1);
			
		} else {
			System.out.println("Not Matched || Expected value is : After click on edit button, The status should be : " + Contract_Activated + " Actual value is : After click on edit button, The status is not display : "+ Currentstatus);

			Extent_fail(driver,"Not Matched || Expected value is : After click on edit button, The status should be : " + Contract_Activated + " Actual value is : After click on edit button, The status is not display : " + Currentstatus,test, test1);
		
		}


		Step_End(15, "click activate", test, test1);

		Step_Start(16, "Filed the contract", test, test1);

		waitForElement(driver, File_Button);
		click(driver, File_Button);
		
		waitForDisplay(driver, popup_Message_Yes_Button);
		if (isdisplayed(driver, popup_Message_Yes_Button)) {

			click(driver, popup_Message_Yes_Button);
		}

		waitForElement(driver, CM_Remarks_Input);
		sendKeys(driver, CM_Remarks_Input, Remark);

		waitForElement(driver, CM_Remark_Ok);
		click(driver, CM_Remark_Ok);

		waitForElement(driver, AMendment);
		click(driver, AMendment);

		waitForPopup(driver, Popup_Message, Contract_Amendment);
		String AmendmentPopup = getText(driver, Popup_Message);


	       if (Contract_Amendment.equals(AmendmentPopup)) {
				
				System.out.println("Matched || Expected value is : After click on amendment button the value should be  : " + Contract_Amendment + " || Actual value is : After click on amendment button the value  is : " + AmendmentPopup);
				Extent_pass(driver,"Matched || Expected value is : After click on amendment button the value should be : " + Contract_Amendment + "||  Actual value is : After click on amendment button the value  is : " + AmendmentPopup,test, test1);
			} else {

				System.out.println("Not Matched || Expected value is : After click on amendment button the value should be :" + Contract_Amendment + "|| Actual value is : After click on amendment button the value  is not display :"+ AmendmentPopup);
				Extent_fail(driver,"Not Matched || Expected value is : After click on amendment button the value should be : " + Contract_Amendment + "|| Actual value is : After click on amendment button the value  is not display :" + AmendmentPopup,test, test1);
			
			}
		Step_End(16, "Filed the contract", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}