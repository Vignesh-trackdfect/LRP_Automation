package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC093 extends Keywords {

	public void Import_Documentation_SC093(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC093";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("Module_Search");
		String BL_Num = Excel_data.get("BL_Num");
		String AccountingConfiguration = Excel_data.get("AccountingConfiguration");
		String Attribute_value = Excel_data.get("Attribute_value");
		String Value_checkbox_perform = Excel_data.get("Value_checkbox_perform");
		String Transport_service = Excel_data.get("Transport_service");
		String Table_name = Excel_data.get("Table_name");
		String Tables_headers = Excel_data.get("Tables_headers");
		String Type_Verify = Excel_data.get("Type_Verify");
		String SavedPopup = Excel_data.get("SavedPopup");
		String master_BL_Status = Excel_data.get("master_BL_Status");
		String Import_Documentation_delete_perform = Excel_data.get("Import_Documentation_delete_perform");
		String Terminal = Excel_data.get("Terminal");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Port = Excel_data.get("Port");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String attribute_Header = Excel_data.get("attribute_Header");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Agency_Search_Header = Excel_data.get("Agency_Search_Header");
		String updatedPopup=Excel_data.get("UpdatedPopup");
		String all_Dropdown_1 = Excel_data.get("All_Dropdown_1");
		String all_Dropdown_2 = Excel_data.get("All_Dropdown_2");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String Reset_Accounting_Configuration = Excel_data.get("Reset_Accounting_Configuration");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
//		Switch the Profile
		Step_Start(1, "Switch to agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency.", test, test1);
		
		// Accounting Configuration
		 Map<String, String> newlyadded = setAccountingConfiguration(driver, AccountingConfiguration, Agency_Search_Header, attribute_Header, Condition_Filter, AgencyUser, Attribute_value, "", "", "", Value_checkbox_perform);
		
		Step_Start(17, "open the Import Documentationmodule and  Retrieve the new  bill using tool bar search.", test, test1);

		moduleNavigate(driver, ImportDocumentationModule);
		if(BL_Retrive_Option.equals("By Service")) {
		
			newButton(driver);
			
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service);
	
			if(!Vessel.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
			}
			if(!Voyage.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
			}
			if(!Bound.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound);
			}
			if(!Port.trim().equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Port);
			}
			if(!Terminal.trim().equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 500);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
			}
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			
			if(!pol_Value.trim().equals("")) {
				scrollTop(driver);
				waitForElement(driver, POLSearch);
				safeclick(driver, POLSearch);
				twoColumnSearchWindow(driver, Pol_Header, Condition_Filter, pol_Value);
			}
			
	
			waitForElement(driver, all_Dropdown_1_IMD);
			click(driver, all_Dropdown_1_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_1);
			
			waitForElement(driver, all_Dropdown_2_IMD);
			click(driver, all_Dropdown_2_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_2);
			
			waitForElement(driver, show_BL_Button_IMD);
			safeclick(driver, show_BL_Button_IMD);
			
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
	
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, BL_Num);

		}else if(BL_Retrive_Option.equals("By BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, BL_Num, "", "", "", "");
	
		}	

        deleteSavedBL(driver, master_BL_Status, dropdownCondition1, BL_Num);//new line addded by vignesh
		
		Step_End(18, "search.(bl with carriage terms as FIFO must)", test, test1);
		
		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
		if(!actual_Master_BL_Status.equals(master_BL_Status)) {
			if(isClickable(driver, Edit_Button_toolBar)) {
			click(driver, Edit_Button_toolBar);
			}
		}
		waitForElement(driver, BL_Tab_IMD);
		click(driver, BL_Tab_IMD);
		waitForElement(driver,Transport_service_l);

		Step_Start(19, "Verify that Transport Service has to there with FIFO(ES)in bl/hbl summary tab transport service filed", test, test1);
		String TransportAct = getAttribute(driver, Transport_service_l,"value");
		System.out.println(TransportAct);
		if (Transport_service.equals(TransportAct)) {
			System.out.println(
					"Matched || Expected value was : " + Transport_service + " || Actual value was : " + TransportAct);
			Extent_pass_New(driver,
					"Matched || Expected value was : " + Transport_service + " || Actual value was : " + TransportAct, test,
					test1);

		} else {
			System.out.println(
					"NotMatched || Expected value was : " + Transport_service + " || Actual value was : " + TransportAct);
			Extent_fail(driver,
					"NotMatched || Expected value was : " + Transport_service + " || Actual value was : " + TransportAct,
					test, test1);

		}
		Step_End(19, "Verify that Transport Service has to there with FIFO(ES)in bl/hbl summary tab transport service filed", test, test1);

		Step_Start(20, "go to the collect charges-only manifest charges has shown.", test, test1);
		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);

		mouseOverToElement(driver, Collect_Charges_Table_Row);
		waitForElement(driver, Collect_Charges_Table_Row);
		List<Map<String, String>> collect_table = getTableData(driver, Collect_Charges_Table_Header, Collect_Charges_Table_Row);
		List<String> type_values = getValuesByHeader(collect_table, "Type");
		List<String> coloum_headd = splitAndExpand(Tables_headers);
		String HBL_Table = TableDataForReport(driver, collect_table,Table_name,coloum_headd);
		boolean agencyPresent=false;
		for(String type_value :type_values) {
			if (Type_Verify.equals(type_value)) {
				agencyPresent=true;
				Extent_pass_New(driver," Collect Charges table data : "+ "<pre>" +HBL_Table + "</pre>", test, test1);	
				System.out.println("Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data || Actual : '"+Type_Verify+"' is present in the Collect Charges table data ");
				Extent_fail(driver, "Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data || Actual : '"+Type_Verify+"' is present in the Collect Charges table data ", test, test1);
			}
		}
		
		if(agencyPresent!=false) {
			Extent_pass_New(driver," Collect Charges table data : "+ "<pre>" +HBL_Table + "</pre>", test, test1);	
			System.out.println("Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data || Actual : '"+Type_Verify+"' is not present in the Collect Charges table data ");
			Extent_fail(driver, "Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data || Actual : '"+Type_Verify+"' is not present in the Collect Charges table data ", test, test1);
		}
		Step_End(20, "go to the collect charges-only manifest charges has shown.", test, test1);
		Step_Start(21, "Save the Import Documentation.", test, test1);
	
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(21, "Save the Import Documentation.", test, test1);
		Step_Start(22, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		
		waitForPopup(driver, popup_Message, SavedPopup);
		String ImportDocumentationSaved=getText(driver, popup_Message);
		if (SavedPopup.equals(ImportDocumentationSaved)) {
			System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
			System.out.println("***Import Documentation Saved***");
			Extent_pass_New(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,
					test1);

		} 
		else if(ImportDocumentationSaved.equals(updatedPopup)) {
			System.out.println("Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+ImportDocumentationSaved);
			Extent_pass_New(driver, "Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+ImportDocumentationSaved, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+ImportDocumentationSaved);
			Extent_fail(driver, "Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+ImportDocumentationSaved, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		
		if(Import_Documentation_delete_perform.equalsIgnoreCase("YES")) {
			scrollTop(driver);
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);			
		}
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
	
		Step_Start(25, "Go to accounting configuration module, ", test, test1);
		
		// Accounting Configuration
		reSetAccountingConfiguration(driver, Reset_Accounting_Configuration, newlyadded, AccountingConfiguration, Agency_Search_Header, Condition_Filter, AgencyUser, Attribute_value,  "");
		
		Extent_completed(testcase_Name, test, test1);
	
	}
}