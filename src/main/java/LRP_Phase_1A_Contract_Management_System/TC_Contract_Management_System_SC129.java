package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC129 extends Keywords {

	
public void Contract_Management_System_SC129(WebDriver driver, ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Contract_Management_System_SC129";
		

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
		String CMS_Tariff_Popup = Excel_data.get("CMS_Tariff_Popup");
		String DG_Condition = Excel_data.get("DG_Condition");
		String DGCLass_Value = Excel_data.get("DGCLass_Value");
		String Dg_header = Excel_data.get("Dg_header");
			
		String Search_Condition = Excel_data.get("Search_Condition");
		String CMS_Delivery_Code_Header = Excel_data.get("CMS_Delivery_Code_Header");
		String CMS_Origin_Header = Excel_data.get("CMS_Origin_Header");
		String RateType_Code_Header = Excel_data.get("RateType_Code_Header");
		String ImportDemurrage = Excel_data.get("ImportDemurrage");
		String ExportDemurrage = Excel_data.get("ExportDemurrage");
		String ImportDetention = Excel_data.get("ImportDetention");
		String ExportDetention = Excel_data.get("ExportDetention");
		String CMS_Carrier_remarks_TextField = Excel_data.get("CMS_Carrier_remarks_TextField");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String GR_WT = Excel_data.get("GRWT");
		String Length = Excel_data.get("Length");
		String Width = Excel_data.get("Width");
		String Height = Excel_data.get("Height");
		String Quantity = Excel_data.get("Quantity");
		String Description = Excel_data.get("Description_value");
		
	
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		moduleNavigate(driver, Contract_Management_System_Module);

	
		Step_Start(1, "select FMC check box", test, test1);
		
		Step_Start(2, "select Non-containerized check box", test, test1);
		
		waitForElement(driver, Contract_Management_System_Non_Containerized);
		click(driver, Contract_Management_System_Non_Containerized);
	
		
		waitForElement(driver, Contract_Management_System_Fmc);
		click(driver, Contract_Management_System_Fmc);
		
		
		Step_End(1, "select FMC check box", test, test1);
		
		Step_End(2, "select Non-containerized check box", test, test1);
		
		
		
		Step_Start(3, "Enter the customer name", test, test1);
		
		waitForElement(driver, Contract_Management_System_CustomerName);
		sendKeys(driver, Contract_Management_System_CustomerName, Customer_code_Value);
		
		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);
		
		waitForDisplay(driver, Contract_Management_System_Exit);
		if(isdisplayed(driver, Contract_Management_System_Exit)) {
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
		
		Step_Start(6, "Add the port pair lanes below main grid", test, test1);
		
		waitForElement(driver, Rate_type_Search);
		click(driver, Rate_type_Search);
 
		twoColumnSearchWindow(driver, RateType_Code_Header, Search_Condition, Eqp_Type);
		
		
		waitForElement(driver, Contract_Management_System_Origin_seach);
		click(driver, Contract_Management_System_Origin_seach);
		
		twoColumnSearchWindow(driver, CMS_Origin_Header, Search_Condition, Origin);
		
		
		
		waitForElement(driver, Contract_Management_System_Delivery);
		click(driver, Contract_Management_System_Delivery);
		
		
		twoColumnSearchWindow(driver, CMS_Delivery_Code_Header, Search_Condition, Delivery);
	
			
		
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
		Newclear(driver, Contract_Management_System_weight);
		sendKeys(driver, Contract_Management_System_weight, weight);
		waitForElement(driver, Contract_Management_System_OFR);
		
		waitForElement(driver, Contract_Management_System_Add_Dimensions);
		click(driver, Contract_Management_System_Add_Dimensions);
 
		waitForElement(driver, Contract_Management_System_Gr_wt);
		clearAndType(driver, Contract_Management_System_Gr_wt, GR_WT);
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
			
		 if (IsElementEnabled(driver, Add_FreeDays_Btn)) {
				waitForElement(driver, Add_FreeDays_Btn);
				click(driver, Add_FreeDays_Btn);
		 }
		
		waitForElement(driver, Free_days);
		mouseOverToElement(driver, DG_Checkbox);

		if(IsElementEnabled(driver, Contract_Management_System_import_Demurrage)) {
			waitForElement(driver, Contract_Management_System_import_Demurrage);
			sendKeys(driver, Contract_Management_System_import_Demurrage, ImportDemurrage);
		}
		
		if(IsElementEnabled(driver, Contract_Management_System_export_Demurrage)) {
			waitForElement(driver, Contract_Management_System_export_Demurrage);
			sendKeys(driver, Contract_Management_System_export_Demurrage, ExportDemurrage);
		}
		
		if(IsElementEnabled(driver, Contract_Management_System_export_Detention)) {
			waitForElement(driver, Contract_Management_System_export_Detention);
			sendKeys(driver, Contract_Management_System_export_Detention, ImportDetention);
		}
		
		if(IsElementEnabled(driver, Contract_Management_System_import_Detention)) {
			waitForElement(driver, Contract_Management_System_import_Detention);
			sendKeys(driver, Contract_Management_System_import_Detention, ExportDetention);
		}
		
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

		
		
		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);
		

		scrollTop(driver);
		
		Step_End(6, "Add the port pair lanes below main grid", test, test1);
		
		Step_Start(7, "Enter the carrier and customer info", test, test1);
//		
		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);
		
		waitForElement(driver, Cari_info_Signatory_Name);
		clear(driver, Cari_info_Signatory_Name);
		sendKeys(driver, Cari_info_Signatory_Name, Signatory_Name);
		
		waitForElement(driver, Cari_info_Signatory_Title);
		clear(driver, Cari_info_Signatory_Title);
		sendKeys(driver, Cari_info_Signatory_Title, Signatory_Title);
		
		waitForElement(driver, CMS_Carrier_Remarks_Field);
		sendKeys(driver, CMS_Carrier_Remarks_Field, CMS_Carrier_remarks_TextField);
		
		
		Step_End(7, "Enter the carrier and customer info", test, test1);
//		
		Step_Start(8, "save the contract without Tariff general", test, test1);
		
		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);
		
		waitForDisplay(driver, Popup_Message);
		waitForPopup(driver, Popup_Message, CMS_Tariff_Popup);
		String ACtual_Tariff_popup = getText(driver, Popup_Message);
		
		if (CMS_Tariff_Popup.equals(ACtual_Tariff_popup)) {
			Extent_pass(driver,"Expected popup|| Without Adding General Tariff We Should Get This  Popup Message : "+CMS_Tariff_Popup+" || Actual popup || We are getting this popup without adding  General Tariff : "+ ACtual_Tariff_popup, test,test1);
			System.out.println("Expected popup|| Without Adding General Tariff We Should Get This  Popup Message : "+CMS_Tariff_Popup+" || Actual popup || We are getting this popup without adding  General Tariff : "+ ACtual_Tariff_popup);
		}else {
			System.out.println("Expected popup|| Without Adding General Tariff We Should Get This  Popup Message : "+CMS_Tariff_Popup+" || Actual popup || We are getting this popup without adding  General Tariff: "+ ACtual_Tariff_popup);
			Extent_fail(driver,"Expected popup|| Without Adding General Tariff We Should Get This  Popup Message : "+CMS_Tariff_Popup+" || Actual popup  || We are getting this popup without adding  General Tariff : "+ ACtual_Tariff_popup, test,test1);
						
		}
			
		
		Step_End(8, "save the contract without Tariff general", test, test1);
		
		Extent_completed(testCaseName, test, test1);
		
}	
	
}
