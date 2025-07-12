package LRP_Commercial_V1_Contract_Management_System_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Contract_Management_System_SC002 extends Keywords{


	public void Contract_Management_System_SC002(WebDriver driver, ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Contract_Management_System_SC002";
		
		
		

		

		String username=Excel_data.get("username");
		String password=Excel_data.get("password");
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
		String Draft = Excel_data.get("Draft");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String Verified = Excel_data.get("Verified");
		String Contract_Verified = Excel_data.get("Contract_Verified");
		String Activated = Excel_data.get("Activated");
		String BackRoundColor = Excel_data.get("BackRoundColor");
		String Search_Condition = Excel_data.get("Search_Condition");
		String DGCLass_Value = Excel_data.get("DGCLass_Value");
		String DG_Condition = Excel_data.get("DG_Condition");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition2 = Excel_data.get("Search_Condition2");
		String Dg_header = Excel_data.get("Dg_header");



		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		moduleNavigate(driver, Contract_Management_System_Module);



		Step_Start(1, "select FMC check box", test, test1);


		waitForElement(driver, Contract_Management_System_NFMC);
		click(driver, Contract_Management_System_NFMC);

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
		if(isdisplayed(driver, Contract_Management_System_Exit)) {
			waitForElement(driver, Contract_Management_System_Exit);
			click(driver, Contract_Management_System_Exit);
		}else {
			System.out.println("customer name System Page is not displayed");
		}

		Step_End(3, "Enter the customer name", test, test1);

		Step_Start(4, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);

		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);


		waitForElement(driver, Contract_Management_System_Internal_Commodity);
		sendKeys(driver, Contract_Management_System_Internal_Commodity, Internal_Commodity);

		String select_Internal_Commmodity=String.format(Contract_Management_System_Commodity_val, Internal_Commodity);
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

		waitForElement(driver, Contract_Management_System_Eqp_Type);
		sendKeys(driver, Contract_Management_System_Eqp_Type, Eqp_Type);

		String select_Eqp_Type=String.format(Contract_Management_System_Commodity_val, Eqp_Type);
		waitForElement(driver, select_Eqp_Type);
		safeclick(driver, select_Eqp_Type);

		Step_End(6, "Enter the equipment", test, test1);

		Step_Start(7, "Enter the origin", test, test1);

		waitForElement(driver, Contract_Management_System_Origin_seach);
		click(driver, Contract_Management_System_Origin_seach);

		waitForElement(driver, Contract_Management_System_Origin_seach_Input_field);
		sendKeys(driver, Contract_Management_System_Origin_seach_Input_field, Origin);

		waitForElement(driver, RR_firstRow);
		click(driver, RR_firstRow);

		waitForElement(driver, Contract_Management_System_Origin_select);
		click(driver, Contract_Management_System_Origin_select);

		Step_End(7, "Enter the origin", test, test1);

		Step_Start(8, "Enter the delivery", test, test1);	

		waitForElement(driver, Contract_Management_System_Delivery);
		click(driver, Contract_Management_System_Delivery);

		waitForElement(driver, Contract_Management_System_Delivery_seach_Input_field);
		sendKeys(driver, Contract_Management_System_Delivery_seach_Input_field, Delivery);

		waitForElement(driver, RR_firstRow);
		click(driver, RR_firstRow);

		waitForElement(driver, Contract_Management_System_Origin_select);
		click(driver, Contract_Management_System_Origin_select);

		Step_End(8, "Enter the delivery", test, test1);	

		Step_Start(9, "Enter the OFR", test, test1);	

		waitForElement(driver, Contract_Management_System_OFR);
		sendKeys(driver, Contract_Management_System_OFR, OFR);

		Step_End(9, "Enter the OFR", test, test1);	

		Step_Start(10, "Enter the gross weight", test, test1);

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

		Step_End(10, "Enter the gross weight", test, test1);

		waitForElement(driver, Free_days);
		mouseOverToElement(driver, DG_Checkbox);

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

		Step_Start(11, "click ADD.", test, test1);

		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);

		Step_End(11, "click ADD.", test, test1);

		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);

		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);

		Step_Start(12, "click Save", test, test1);

		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);
		waitForPopup(driver, Popup_Message, Contract_saved);
		
		String saved_popup =getText(driver, Popup_Message);
		System.out.println("saved_popup :"+saved_popup);

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
		String Draftnumber =getAttribute(driver, Contract_Management_System_status,"value");
		System.out.println("Draftnumber :"+Draftnumber);	

		if(Draft.equals(Draftnumber)) {
			System.out.println("Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draftnumber);
			Extent_pass(driver,"Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draftnumber, test,test1);

		}else {

			System.out.println("Not Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draftnumber);
			Extent_fail(driver,"Not Matched || Expected the status  : After click on save button, The status should be : "+Draft+" || Actual value is After click on save button, The status is : "+ Draftnumber, test,test1);

		}

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Search_Condition2, Select_field, contract_number, "", "", "", "");


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
		String verifiednumber =getAttribute(driver, Contract_Management_System_status,"value");
		System.out.println("verifiednumber :"+verifiednumber);	

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

		waitForElement(driver, Contract_Management_System_Active);
		click(driver, Contract_Management_System_Active);

		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {

			click(driver, popup_Message_Yes_Button);
			waitForElement(driver, Contract_Management_System_Activity_close);
			click(driver, Contract_Management_System_Activity_close);
		}else {
			System.out.println("Popup message is not display");
		}
		Step_End(17, " Enter the signatory date", test, test1);	

		Step_Start(18, "click activate", test, test1);	

		waitForElement(driver, Contract_Management_System_status);
		String Activated_avl =getAttribute(driver, Contract_Management_System_status,"value");
		System.out.println("Activated_avl :"+Activated_avl);	

		if (Activated_avl.equals(Activated)) {
			System.out.println("Matched || Expected value is : After click on save button, The status should be  : " + Activated_avl + " || Actual value is : After click on save button, The status is :" + Activated_avl);
			Extent_pass(driver,"Matched || Expected value is : After click on save button, The status should be  : " + Activated_avl + " || Actual value is : After click on save button, The status is :" + Activated_avl, test,test1);

		} else {

			System.out.println("Matched || Expected value is : After click on save button, The status should be  : " + Activated_avl + " || Actual value is : After click on save button, The status is :" + Activated_avl);

			Extent_fail(driver,"Matched || Expected value is : After click on save button, The status should be  : " + Activated_avl + " || Actual value is : After click on save button, The status is :" + Activated_avl, test,test1);

		}

		waitForDisplay(driver, Contract_Management_System_Activity_close);
		if(isdisplayed(driver, Contract_Management_System_Activity_close)) {
			waitForElement(driver, Contract_Management_System_Activity_close);
			click(driver, Contract_Management_System_Activity_close);
		}else {
			System.out.println("Popup message is not display");
		}


		waitForElement(driver, Contract_Management_System_backrond_color);
		String Act_col=getTextBackgroundColor(driver, Contract_Management_System_backrond_color);
		System.out.println("Backround Color: "+Act_col);

		String color=getColorName(Act_col);

		if (BackRoundColor.equals(color)) {
			System.out.println("Matched || Expected : Backround color should be : " + BackRoundColor + " || actual value : Backround color is : " + color);
			Extent_pass(driver, "Matched || Expected : Backround color should be : "  + BackRoundColor+ " || actual value : Backround color is :  " + color, test, test1);
		} else {
			System.out.println("Not Matched || Expected : Backround color should be : " + BackRoundColor + " || actual value : Backround color is Not matched : " + color);
			Extent_fail(driver, "Not Matched || Expected : Backround color should be : " + BackRoundColor + " || actual value : Backround color is not matched : " + color, test, test1);
		}



		Step_End(18, "click activate", test, test1);	


	}
}