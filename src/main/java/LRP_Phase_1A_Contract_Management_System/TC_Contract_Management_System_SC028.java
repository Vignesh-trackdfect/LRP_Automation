package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC028 extends Keywords {
	
	public void Contract_Management_System_SC28(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Contract_Management_System_SC028";
		
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
		String ImportDemurrage = Excel_data.get("ImportDemurrage");
		String ExportDemurrage = Excel_data.get("ExportDemurrage");
		String ImportDetention = Excel_data.get("ImportDetention");
		String ExportDetention = Excel_data.get("ExportDetention");
		String Tariffs_of_General_Applicability = Excel_data.get("Tariffs_of_General_Applicability");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String Verified = Excel_data.get("Verified");
		String Contract_Verified = Excel_data.get("Contract_Verified");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Contract_Activated = Excel_data.get("Contract_Activated");
		String Contract_Amendment = Excel_data.get("Contract_Amendment");
		String DG_Condition = Excel_data.get("DG_Condition");
		String DGCLass_Value = Excel_data.get("DGCLass_Value");
		String Select_field = Excel_data.get("Select_field");
		String GrWt = Excel_data.get("GrWt");
		String Length = Excel_data.get("Length");
		String Width = Excel_data.get("Width");
		String Height = Excel_data.get("Height");
		String Quantity = Excel_data.get("Quantity");
		String Origin_Header = Excel_data.get("Origin_Header");
		String Delivery_Header = Excel_data.get("Delivery_Header");
		String DatePicker = Excel_data.get("DatePicker");
		String Effective_Date_Perform = Excel_data.get("Effective_Date_Perform");
		String EffectiveDate = Excel_data.get("EffectiveDate");
		String CMS_Equipment_Type_Header = Excel_data.get("CMS_Equipment_Type_Header");
		String Dg_header = Excel_data.get("DG_Header");
		String CMS_Carrier_remarks_TextField = Excel_data.get("CMS_Carrier_remarks_TextField");
		String Rateview_ModuleName = Excel_data.get("Rateview_ModuleName");
		String Quote_Header = Excel_data.get("Quote_Header");
		String Rateview_Search_condition = Excel_data.get("Rateview_Search_condition");
		String GR_WT = Excel_data.get("GrWt");
		String Description = Excel_data.get("Description1");
		

		



		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		moduleNavigate(driver, Contract_Management_System_Module);

		waitForDisplay(driver, Contract_Management_System);

	
		Step_Start(1, "select non FMC check box", test, test1);

		Step_Start(2, "select  NON containerized check box", test, test1);

		waitForElement(driver, Contract_Management_System_NFMC);
		click(driver, Contract_Management_System_NFMC);
		waitForElement(driver, Contract_Management_System_Non_Containerized);
		click(driver, Contract_Management_System_Non_Containerized);

	

		Step_End(1, "select FMC check box", test, test1);

		Step_End(2, "select  NON containerized check box", test, test1);

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

		Step_Start(5, "switch to port pair tab", test, test1);

		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);

		Step_End(5, "switch to port pair tab", test, test1);

		Step_Start(6, "Enter the equipment", test, test1);

		waitForElement(driver, Rate_type_Search);
		click(driver, Rate_type_Search);

		twoColumnSearchWindow(driver, CMS_Equipment_Type_Header, Search_Condition, Eqp_Type);

		Step_End(6, "Enter the equipment", test, test1);

	
	
		Step_Start(7, "Enter the origin", test, test1);

		waitForElement(driver, Contract_Management_System_Origin_seach);
		click(driver, Contract_Management_System_Origin_seach);

		twoColumnSearchWindow(driver, Origin_Header, Search_Condition, Origin);

		Step_End(7, "Enter the origin", test, test1);

		Step_Start(8, "Enter the delivery", test, test1);

		waitForElement(driver, Contract_Management_System_Delivery);
		click(driver, Contract_Management_System_Delivery);

		twoColumnSearchWindow(driver, Delivery_Header, Search_Condition, Delivery);

		Step_End(8, "Enter the delivery", test, test1);

		Step_Start(9, "Enter the OFR", test, test1);

		waitForElement(driver, Contract_Management_System_OFR);
		sendKeys(driver, Contract_Management_System_OFR, OFR);

		Step_End(9, "Enter the OFR", test, test1);
		
		waitForElement(driver, Contract_Management_System_weight);
		Newclear(driver, Contract_Management_System_weight);
		sendKeys(driver, Contract_Management_System_weight, weight);
		click(driver,Contract_Management_System_OFR);

		waitForElement(driver, Contract_Management_System_Add_Dimensions);
		click(driver, Contract_Management_System_Add_Dimensions);

		waitForElement(driver, Contract_Management_System_Gr_wt);
		Newclear(driver, Contract_Management_System_Gr_wt);
		sendKeys(driver, Contract_Management_System_Gr_wt, GR_WT);
        click(driver,Contract_Management_System_Width);
		
		waitForElement(driver, Contract_Management_System_Length);
		Newclear(driver, Contract_Management_System_Length);
		sendKeys(driver, Contract_Management_System_Length, Length);

		waitForElement(driver, Contract_Management_System_Width);
		Newclear(driver, Contract_Management_System_Width);
		sendKeys(driver, Contract_Management_System_Width, Width);

		waitForElement(driver, Contract_Management_System_Height);
		Newclear(driver, Contract_Management_System_Height);
		sendKeys(driver, Contract_Management_System_Height, Height);
		click(driver,Contract_Management_System_Width);

		waitForElement(driver, Contract_Management_System_Quantity);
		Newclear(driver, Contract_Management_System_Quantity);
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
		 
			
		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);

	
		waitForElement(driver, Contract_Management_System_OFR);
		mouseOverToElement(driver, DG_Checkbox);
		
		waitForDisplay(driver,DG_Checkbox );
		if (isdisplayed(driver, DG_Checkbox)) {
		
		waitForElement(driver, Contract_Management_System_import_Demurrage);
		sendKeys(driver, Contract_Management_System_import_Demurrage, ImportDemurrage);

		waitForElement(driver, Contract_Management_System_export_Demurrage);
		sendKeys(driver, Contract_Management_System_export_Demurrage, ExportDemurrage);

		waitForElement(driver, Contract_Management_System_export_Detention);
		sendKeys(driver, Contract_Management_System_export_Detention, ImportDetention);

		waitForElement(driver, Contract_Management_System_import_Detention);
		sendKeys(driver, Contract_Management_System_import_Detention, ExportDetention);

		if (DG_Condition.equals("Yes")) {

			mouseOverToElement(driver, DG_Checkbox);
			waitForElement(driver, DG_Checkbox);
			click(driver, DG_Checkbox);
      
			waitForElement(driver, DG_Class);
			click(driver, DG_Class);

			twoColumnSearchWindow(driver,Dg_header,Search_Condition,DGCLass_Value);
			
			waitForElement(driver, Add_DG_Class);
			click(driver, Add_DG_Class);

			waitForElement(driver, RR_firstRow);
			click(driver, RR_firstRow);

			waitForElement(driver, DGSelectButton);
			click(driver, DGSelectButton);

			waitForDisplay(driver, DGDetails1);
			if (isdisplayed(driver, DGDetails1)) {

				System.out.println("Matched || Expected : Selected DG details are added should be in the DG Details tab || Actual : Selected DG details are added is in the DG Details tab ");
				Extent_pass(driver, "Matched || Expected : Selected DG details are added should be in the DG Details tab || Actual : Selected DG details are added is in the DG Details tab ", test, test1);
			} else {

				System.out.println("Not Matched || Expected : Selected DG details are added should be in the DG Details tab || Actual : Selected DG details are added is in the DG Details tab ");
				Extent_fail(driver, "NOt Matched || Expected : Selected DG details are added should be in the DG Details tab || Actual : Selected DG details are added is in the DG Details tab ", test, test1);

			}

			waitForElement(driver, DG_Ok);
			click(driver, DG_Ok);
		}

		scrollTop(driver);

		}
		waitForElement(driver, Contract_Management_System_weight);
		clear(driver,Contract_Management_System_weight);
		sendKeys(driver, Contract_Management_System_weight, GrWt);

		
		


		Step_End(10, "Enter the gross weight", test, test1);

		
		Step_Start(11, "click ADD.", test, test1);

		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);

		Step_End(11, "click ADD.", test, test1);

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
		
		
		
		
		

		Step_Start(12, "click Save", test, test1);

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

		Step_End(12, "click Save", test, test1);

		Step_Start(13, "Retrieve the contract in the global search", test, test1);

		waitForElement(driver, Contract_Management_System_contract);
		String contract_number = getAttribute(driver, Contract_Management_System_contract, "value");
		System.out.println("contect_number :" + contract_number);

		waitForElement(driver, Contract_Management_System_status);
		String Draftnumber = getAttribute(driver, Contract_Management_System_status, "value");
		System.out.println("Draftnumber :" + Draftnumber);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition, Select_field, contract_number, "", "", "", "");

		Step_End(13, "Retrieve the contract in the global search", test, test1);

		Step_Start(14, "click edit", test, test1);

		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);

		Step_End(14, "click edit", test, test1);

		Step_Start(15, "Enter the signatory name and tittle", test, test1);

		waitForElement(driver, Contract_Management_System_Signatory_Name);
		sendKeys(driver, Contract_Management_System_Signatory_Name, Signatory_Name);

		waitForElement(driver, Contract_Management_System_Signatory_Title);
		sendKeys(driver, Contract_Management_System_Signatory_Title, Signatory_Title);

		Step_End(15, "Enter the signatory name and tittle", test, test1);

		Step_Start(16, " click verify", test, test1);

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

		Step_End(16, " click verify", test, test1);

		Step_Start(17, "Enter the signatory date", test, test1);

		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);

		Step_End(17, " Enter the signatory date", test, test1);

		Step_Start(18, "click activate", test, test1);

		waitForElement(driver, Contract_Management_System_Active);
		click(driver, Contract_Management_System_Active);

		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);

		} else {
			System.out.println("Popup message is not display");
		}

		waitForElement(driver, Contract_Management_System_status);
		String Currentstatus = getAttribute(driver, Contract_Management_System_status, "value");

	
		
		if (Contract_Activated.equals(Currentstatus)) {
			System.out.println("Matched || Expected value is : After click on save button, The status should be  : " + Contract_Activated + " || Actual value is : After click on save button, The status is :" + Currentstatus);
			Extent_pass(driver,"Matched || Expected value is : After click on save button, The status should be  : " + Contract_Activated + " || Actual value is : After click on save button, The status is :" + Currentstatus, test,test1);
			
		} else {

			System.out.println("Matched || Expected value is : After click on save button, The status should be  : " + Contract_Activated + " || Actual value is : After click on save button, The status is :" + Currentstatus);

			Extent_fail(driver,"Matched || Expected value is : After click on save button, The status should be  : " + Contract_Activated + " || Actual value is : After click on save button, The status is :" + Currentstatus, test,test1);
		
		}

		Step_End(18, "click activate", test, test1);

		Step_Start(19, "move the contract to next amendment using amendment button", test, test1);

		
		waitForElement(driver, AMendment);
		click(driver, AMendment);

		waitForPopup(driver, Popup_Message, Contract_saved);
		String AmendmentPopup = getText(driver, Popup_Message);


         if (Contract_Amendment.equals(AmendmentPopup)) {
			
			System.out.println("Matched || Expected value is : After click on amendment button the value should be  : " + Contract_Amendment + " || Actual value is : After click on amendment button the value  is : " + AmendmentPopup);
			Extent_pass(driver,"Matched || Expected value is : After click on amendment button the value should be : " + Contract_Amendment + "||  Actual value is : After click on amendment button the value  is : " + AmendmentPopup,test, test1);
		} else {

			System.out.println("Not Matched || Expected value is : After click on amendment button the value should be :" + Contract_Amendment + "|| Actual value is : After click on amendment button the value  is not display :"+ AmendmentPopup);
			Extent_fail(driver,"Not Matched || Expected value is : After click on amendment button the value should be : " + Contract_Amendment + "|| Actual value is : After click on amendment button the value  is not display :" + AmendmentPopup,test, test1);
		
		}

		Step_End(19, "move the contract to next amendment using amendment button", test, test1);
	
    Step_Start(20, "activate the current amendment with effective date greater than previous amendment.", test, test1);	
    
    waitForElement(driver, Contract_Management_System_Edit);
	click(driver, Contract_Management_System_Edit);
	if(Effective_Date_Perform.equalsIgnoreCase("Yes")) {
		if(DatePicker.equalsIgnoreCase("Yes")) {
			waitForElement(driver, AMD_Effective_Date);
			click(driver, AMD_Effective_Date);
			selectDatePicker(driver, EffectiveDate);
		}else {
			waitForElement(driver, AMD_Effective_Date);
			clearAndType(driver, AMD_Effective_Date, EffectiveDate);
		}
	}
	
	waitForElement(driver, Contract_Management_System_status);
	String verifiednumber2 =getAttribute(driver, Contract_Management_System_status,"value");
	System.out.println("verifiednumber :"+verifiednumber2);	
	
	if(Verified.equals(verifiednumber)) {
		Extent_pass(driver,"Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is :"+ verifiednumber2, test,test1);
		System.out.println("Matched || Expected value is After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is :"+ verifiednumber2);
	}else {
		System.out.println("Not Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is : "+ verifiednumber2);
		Extent_fail(driver,"Not Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is : "+ verifiednumber2, test,test1);
		
		
	}
	
	waitForElement(driver, Contract_Management_System_Approved);
	click(driver, Contract_Management_System_Approved);

	String verified_popup0f2="";
	waitForDisplay(driver, Popup_Message);
	if(isdisplayed(driver, Popup_Message)) {
		verified_popup =getText(driver, Popup_Message);
		System.out.println("verified_popup :"+verified_popup0f2);
	}
	if(isdisplayed(driver, popup_Message)) {
		click(driver, popup_Message_Yes_Button);
		waitForPopup(driver, Popup_Message, Contract_Verified);
		verified_popup =getText(driver, Popup_Message);
		System.out.println("verified_popup :"+verified_popup0f2);
	}else {
		System.out.println("Popup message is not display");
	}

	if(Contract_Verified.equals(verified_popup)) {
		Extent_pass(driver,"Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is : "+ verified_popup0f2, test,test1);
		System.out.println("Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is : "+ verified_popup0f2);
	}else {
		System.out.println("Not Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is not display :"+ verified_popup0f2);
		Extent_fail(driver,"Not Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is not display : "+ verified_popup0f2, test,test1);
		
	}	
	

	//SIGNDATE
	
	waitForElement(driver, Contract_Management_System_status);
	String verifiednumberaftersigned = getAttribute(driver, Contract_Management_System_status, "value");
	System.out.println("verifiednumber :" + verifiednumberaftersigned);


	
	if(Verified.equals(verifiednumberaftersigned)) {
		Extent_pass(driver,"Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is :"+ verifiednumberaftersigned, test,test1);
		System.out.println("Matched || Expected value is After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is :"+ verifiednumberaftersigned);
	}else {
		System.out.println("Not Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is : "+ verifiednumberaftersigned);
		Extent_fail(driver,"Not Matched || Expected value is : After click on save button, The status should be : "+Verified+" || Actual value is : After click on save button, The status is : "+ verifiednumberaftersigned, test,test1);
		
	}
	
	waitForElement(driver, Contract_Management_System_Edit);
	click(driver, Contract_Management_System_Edit);
	
	//active
	waitForElement(driver, Contract_Management_System_Active);
	click(driver, Contract_Management_System_Active);

	waitForDisplay(driver, popup_Message);
	if (isdisplayed(driver, popup_Message)) {
		click(driver, popup_Message_Yes_Button);

	} else {
		System.out.println("Popup message is not display");
	}

	
	waitForElement(driver, Contract_Management_System_contract);
	String contract_number1 = getAttribute(driver, Contract_Management_System_contract, "value");
	System.out.println("contect_number :" + contract_number1);

	//filed
	

	Step_End(20, "activate the current amendment with effective date greater than previous amendment.", test, test1);
	 Step_Start(21, "open the rate view module and fetch the contract details.", test, test1);	
	
	moduleNavigate(driver, Rateview_ModuleName);
	waitForElement(driver, NewButton_ToolBar);
	 click(driver, NewButton_ToolBar);
	 
		waitForElement(driver, Rateview_Quote_CheckBox);
		 click(driver, Rateview_Quote_CheckBox);

			waitForElement(driver, Rateview_Quote_NONConternized);
			 click(driver, Rateview_Quote_NONConternized);
		 
			waitForElement(driver, Rateview_Quote_Serch);
			 click(driver, Rateview_Quote_Serch);
			 
			 twoColumnSearchWindow(driver, Quote_Header, Rateview_Search_condition, contract_number1);
			 
				waitForElement(driver, Rateview_Show_btn);
				 click(driver, Rateview_Show_btn);
		//		 reArrangeAG_GridColumns(driver, rateview_rearrange_ColumHeader);
				 
				 

					waitForElement(driver, Rateview_Valid_To);
					 String ValidTo_date = getText(driver, Rateview_Valid_To);
					 System.out.println(ValidTo_date);
					 
					 String expectedDate=beforeDaysToDate(EffectiveDate,"1");
					 
					
					 
						if(expectedDate.equals(ValidTo_date)) {
							Extent_pass(driver,"Matched || Expected value is :  The efective  date from the CMS module should be  : "+expectedDate+" || the valid TO  date from the RateView module should be less than  one day is  :"+ ValidTo_date, test,test1);
							System.out.println("Matched || Expected value is :  The efective  date from the CMS module should  be  : " +expectedDate+ "|| the valid TO  date from the RateView module should be less than  one day is :"+ ValidTo_date);
						}else {
							System.out.println("Not Matched || Expected value is :   The efective  date from the CMS module should be : "+expectedDate+" || the valid TO  date from the RateView module should be less than  one day is : "+ ValidTo_date);
							Extent_fail(driver,"Not Matched || Expected value is :   The efective  date from the CMS module should be : "+expectedDate+" || Actual value is : the valid TO  date from the RateView module should be less than  one day is: "+ ValidTo_date, test,test1);
							
						}
					 


	
	

			
			
	      Step_End(21, "open the rate view module and fetch the contract details.", test, test1);	

		
		Extent_completed(testCaseName, test, test1);
		
		
	
	
	
	
	}
	}
