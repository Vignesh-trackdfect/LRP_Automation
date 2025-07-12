package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC123 extends Keywords {

	public void Contract_Management_System_SC123(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC123";

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
		String Draft = Excel_data.get("Draft");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String Verified = Excel_data.get("Verified");
		String Contract_Verified = Excel_data.get("Contract_Verified");
		String DG_Condition = Excel_data.get("DG_Condition");
		String DGCLass_Value = Excel_data.get("DGCLass_Value");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition2 = Excel_data.get("Search_Condition2");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Dg_header = Excel_data.get("Dg_header");
		String Condition = Excel_data.get("Condition");
		String CMS_Delivery_Code_Header = Excel_data.get("CMS_Delivery_Code_Header");
		String CMS_Origin_Header = Excel_data.get("CMS_Origin_Header");
		String RateType_Code_Header = Excel_data.get("RateType_Code_Header");
		String GR_WT = Excel_data.get("GRWT");
		String Length = Excel_data.get("Length");
		String Width = Excel_data.get("Width");
		String Height = Excel_data.get("Height");
		String Quantity = Excel_data.get("Quantity");
		String Description = Excel_data.get("Description_value");
		String Excepted_PopUp = Excel_data.get("Excepted_PopUp");
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		moduleNavigate(driver, Contract_Management_System_Module);

		Step_Start(1, "select FMC check box", test, test1);

		waitForElement(driver, Contract_Management_System_Fmc);
		click(driver, Contract_Management_System_Fmc);

		Step_End(1, "select FMC check box", test, test1);

		Step_Start(2, "select Non-containerized check box.", test, test1);
		waitForElement(driver, Contract_Management_System_Non_Containerized);
		click(driver, Contract_Management_System_Non_Containerized);

		waitForElement(driver, Contract_Management_System_Fmc);
		click(driver, Contract_Management_System_Fmc);

		Step_End(2, "select Non-containerized check box.", test, test1);

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
		Step_Start(6, "add the port pair lanes below main grid", test, test1);
		waitForElement(driver, Rate_type_Search);
		click(driver, Rate_type_Search);

		twoColumnSearchWindow(driver, RateType_Code_Header, Condition, Eqp_Type);

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

		waitForElement(driver, Contract_Management_System_Add_Dimensions);
		click(driver, Contract_Management_System_Add_Dimensions);

		waitForElement(driver, Contract_Management_System_Gr_wt);
		clearAndType(driver, Contract_Management_System_Gr_wt, GR_WT);
		click(driver, Contract_Management_System_Width);

		waitForElement(driver, Contract_Management_System_Length);
		clear(driver, Contract_Management_System_Length);
		sendKeys(driver, Contract_Management_System_Length, Length);

		waitForElement(driver, Contract_Management_System_Width);
		clear(driver, Contract_Management_System_Width);
		sendKeys(driver, Contract_Management_System_Width, Width);

		waitForElement(driver, Contract_Management_System_Height);
		clear(driver, Contract_Management_System_Height);
		sendKeys(driver, Contract_Management_System_Height, Height);
		click(driver, Contract_Management_System_Width);

		waitForElement(driver, Contract_Management_System_Quantity);
		clear(driver, Contract_Management_System_Quantity);
		sendKeys(driver, Contract_Management_System_Quantity, Quantity);
		click(driver, Contract_Management_System_Width);

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

		if (IsElementEnabled(driver, Add_FreeDays_Btn)) {
			waitForElement(driver, Add_FreeDays_Btn);
			click(driver, Add_FreeDays_Btn);
		}

		waitForDisplay(driver, Contract_Management_System_import_Demurrage);
		if (isElementAccessible(driver, Contract_Management_System_import_Demurrage)) {
			sendKeys(driver, Contract_Management_System_import_Demurrage, ImportDemurrage);
		}

		waitForDisplay(driver, Contract_Management_System_export_Demurrage);
		if (isElementAccessible(driver, Contract_Management_System_export_Demurrage)) {
			sendKeys(driver, Contract_Management_System_export_Demurrage, ExportDemurrage);
		}
		if (isElementAccessible(driver, Contract_Management_System_export_Detention)) {
			waitForDisplay(driver, Contract_Management_System_export_Detention);
			sendKeys(driver, Contract_Management_System_export_Detention, ImportDetention);
		}
		if (isElementAccessible(driver, Contract_Management_System_import_Detention)) {
			waitForDisplay(driver, Contract_Management_System_import_Detention);
			sendKeys(driver, Contract_Management_System_import_Detention, ExportDetention);
		}

		if (DG_Condition.equals("Yes")) {

			mouseOverToElement(driver, DG_Checkbox);
			waitForElement(driver, DG_Checkbox);
			click(driver, DG_Checkbox);

			waitForElement(driver, DG_Class);
			click(driver, DG_Class);

			twoColumnSearchWindow(driver, Dg_header, Search_Condition, DGCLass_Value);

			waitForElement(driver, Add_DG_Class);
			click(driver, Add_DG_Class);

			waitForElement(driver, RR_firstRow);
			click(driver, RR_firstRow);

			waitForElement(driver, DGSelectButton);
			click(driver, DGSelectButton);

			waitForDisplay(driver, DGDetails1);
			if (isdisplayed(driver, DGDetails1)) {

				System.out.println(
						"Matched || Expected : Selected DG details are added should be in the DG Details tab || Actual : Selected DG details are added is in the DG Details tab ");
				Extent_pass(driver,
						"Matched || Expected : Selected DG details are added should be in the DG Details tab || Actual : Selected DG details are added is in the DG Details tab ",
						test, test1);
			} else {

				System.out.println(
						"Not Matched || Expected : Selected DG details are added should be in the DG Details tab || Actual : Selected DG details are added is in the DG Details tab ");
				Extent_fail(driver,
						"NOt Matched || Expected : Selected DG details are added should be in the DG Details tab || Actual : Selected DG details are added is in the DG Details tab ",
						test, test1);

			}

			waitForElement(driver, DG_Ok);
			click(driver, DG_Ok);
		}

		scrollTop(driver);

		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);

		Step_End(6, "add the port pair lanes below main grid", test, test1);
		Step_Start(7, "enter the carrier and customer info and update in draft and verify", test, test1);
		scrollTop(driver);
		mouseOverToElement(driver, Contract_Management_System_General);
		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);

		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);
		waitForElement(driver, Cari_info_Signatory_Name);
		sendKeys(driver, Cari_info_Signatory_Name, Signatory_Name);

		waitForElement(driver, Cari_info_Signatory_Title);
		sendKeys(driver, Cari_info_Signatory_Title, Signatory_Title);

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

		waitForElement(driver, Contract_Management_System_contract);
		String contract_number = getAttribute(driver, Contract_Management_System_contract, "value");
		System.out.println("contect_number :" + contract_number);

		waitForElement(driver, Contract_Management_System_status);
		String Draftnumber = getAttribute(driver, Contract_Management_System_status, "value");

		if (Draft.equals(Draftnumber)) {
			System.out.println("Matched || Expected the status  : After click on save button, The status should be : "
					+ Draft + " || Actual value is After click on save button, The status is : " + Draftnumber);
			Extent_pass(driver,
					"Matched || Expected the status  : After click on save button, The status should be : " + Draft
							+ " || Actual value is After click on save button, The status is : " + Draftnumber,
					test, test1);

		} else {

			System.out
					.println("Not Matched || Expected the status  : After click on save button, The status should be : "
							+ Draft + " || Actual value is After click on save button, The status is : " + Draftnumber);
			Extent_fail(driver,
					"Not Matched || Expected the status  : After click on save button, The status should be : " + Draft
							+ " || Actual value is After click on save button, The status is : " + Draftnumber,
					test, test1);

		}

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Search_Condition2, Select_field, contract_number, "", "", "", "");


		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);


		waitForElement(driver, Contract_Management_System_Signatory_Name);
		sendKeys(driver, Contract_Management_System_Signatory_Name, Signatory_Name);

		waitForElement(driver, Contract_Management_System_Signatory_Title);
		sendKeys(driver, Contract_Management_System_Signatory_Title, Signatory_Title);

		Step_End(7, "enter the carrier and customer info and update in draft and verify", test, test1);


		waitForElement(driver, Contract_Management_System_Approved);
		click(driver, Contract_Management_System_Approved);

		waitForDisplay(driver, Popup_Message);
		 if (isdisplayed(driver, popup_Message)) {
			 waitForDisplay(driver, popup_Message_Yes_Button);
			 click(driver, popup_Message_Yes_Button);
		 } else {
			 System.out.println("Popup message is not display");
		 }
		
		waitForPopup(driver, Popup_Message, Contract_Verified);
		String verified_popup = getText(driver, Popup_Message);
		System.out.println("verified_popup :" + verified_popup);

		if (Contract_Verified.equals(verified_popup)) {
			Extent_pass(driver,
					"Matched || Expected value is : After click on verify button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on verify button the popup  message is : "
							+ verified_popup,
					test, test1);
			System.out.println(
					"Matched || Expected value is : After click on verify button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on verify button the popup  message is : "
							+ verified_popup);
		} else {
			System.out.println(
					"Not Matched || Expected value is : After click on verify button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on verify button the popup  message is not display :"
							+ verified_popup);
			Extent_fail(driver,
					"Not Matched || Expected value is : After click on verify button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on verify button the popup  message is not display : "
							+ verified_popup,
					test, test1);

		}

		waitForElement(driver, Contract_Management_System_status);
		String verifiednumber = getAttribute(driver, Contract_Management_System_status, "value");
		System.out.println("verifiednumber :" + verifiednumber);

		if (Verified.equals(verifiednumber)) {
			Extent_pass(driver,
					"Matched || Expected value is : After click on verify button, The status should be : " + Verified
							+ " || Actual value is : After click on verify button, The status is :" + verifiednumber,
					test, test1);
			System.out.println(
					"Matched || Expected value is After click on verify button, The status should be : " + Verified
							+ " || Actual value is : After click on verify button, The status is :" + verifiednumber);
		} else {
			System.out
					.println("Not Matched || Expected value is : After click on verify button, The status should be : "
							+ Verified + " || Actual value is : After click on verify button, The status is : "
							+ verifiednumber);
			Extent_fail(driver,
					"Not Matched || Expected value is : After click on verify button, The status should be : "
							+ Verified + " || Actual value is : After click on verify button, The status is : "
							+ verifiednumber,
					test, test1);

		}

		Step_End(7, "enter the carrier and customer info and update in draft and verify", test, test1);


		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);

	

		Step_Start(8, "click on edit button and try to activate without selecting the signature date.", test, test1);

		waitForElement(driver, Contract_Management_System_Active);
		click(driver, Contract_Management_System_Active);

		waitForDisplay(driver, Popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			waitForDisplay(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		} else {
			System.out.println("Popup message is not display");
		}
		waitForDisplay(driver, Popup_Message);
		String Actual_Popup = getText(driver, Popup_Message);
		System.out.println("popup :" + Actual_Popup);
		if (Excepted_PopUp.equals(Actual_Popup)) {
			Extent_pass(driver, "Matched || Expected popup value was : " + Excepted_PopUp
					+ " ||  Actual popup value was is display : " + Actual_Popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Excepted_PopUp
					+ " || Actual popup value was is display: " + Actual_Popup);

		} else {
			System.out.println("Not Matched || Expected popup value was : " + Excepted_PopUp
					+ " || Actual popup value was not display: " + Actual_Popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Excepted_PopUp
					+ " || Actual popup value was not display: " + Actual_Popup, test, test1);

		}

		Step_End(8, "click on edit button and try to activate without selecting the signature date.", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}