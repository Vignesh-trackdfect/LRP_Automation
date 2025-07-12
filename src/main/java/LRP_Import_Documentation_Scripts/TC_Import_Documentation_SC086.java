package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
public class TC_Import_Documentation_SC086 extends Keywords {
	public void Import_Documentation_SC086(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		//Get data from test data
		String testcase_Name="TC_Import_Documentation_SC086";
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_AgencyConfiguration=Excel_data.get("Module_AgencyConfiguration");
		String module_ImportDocumentation=Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String globalSearchFilterOption_IMD=Excel_data.get("GlobalSearchFilterOption_IMD");
		String agencyConfig_Description=Excel_data.get("AgencyConfig_Description");
		String value=Excel_data.get("Value");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String defaultValue=Excel_data.get("DefaultValue");
		String chargeCode=Excel_data.get("ChargeCode");
		String type=Excel_data.get("Type");
		String updatedPopup=Excel_data.get("UpdatedPopup");
		String wantToDelete_Popup_IMD = Excel_data.get("WantToDelete_Popup_IMD");
		String deleted_Popup_IMD = Excel_data.get("Deleted_Popup_IMD");
		String saved_Popup_IMD = Excel_data.get("Saved_Popup_IMD");
		String attribute = Excel_data.get("Attribute");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Terminal = Excel_data.get("Terminal");
		String Port = Excel_data.get("Port");
		String all_Dropdown_1 = Excel_data.get("All_Dropdown_1");
		String all_Dropdown_2 = Excel_data.get("All_Dropdown_2");
		String POL_Loction = Excel_data.get("POL_Loction");
		String BL_Retrieve_Option = Excel_data.get("BL_Retrieve_Option");
		String wantToDelete = Excel_data.get("WantToDelete");
		String conditionFilter=Excel_data.get("ConditionFilter");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String reset = Excel_data.get("reset");

		String select_Type=String.format(chargeType, type);
		String select_ChargeCode=String.format(chargeCode_IMD, chargeCode);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);

		// Login
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		Step_Start(1, "switch the agency and .open the  Agency configuration module ", test, test1);

		SwitchProfile(driver, agencyUser);

		// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);
		
		List<Boolean> newlyAdded = setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, conditionFilter, agencyUser, attribute, agencyConfig_Description, value);

		Extent_cal(test, test1, module_ImportDocumentation);
		
		Step_Start(21, "open the Import Documentationmodule and  Retrieve the new  bill using tool bar search.or retrive the saved bill then click the edit in tool bar and then go the sam steps.", test, test1);
		moduleNavigate(driver, module_ImportDocumentation);

		if(BL_Retrieve_Option.equals("By Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if( IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);


				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation = getText(driver, popup_Message);
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation, test, test1);

				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
				}
				safeclick(driver, popup_Message_Yes_Button);

			}
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

			if(!POL_Loction.trim().equals("")) {
				waitForElement(driver, POLSearch);
				safeclick(driver, POLSearch);
				twoColumnSearchWindow(driver, Pol_Header, conditionFilter, POL_Loction);
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
			twoColumnSearchWindow(driver, BLNumber_Header, conditionFilter, globalSearch_Number);

		}else if(BL_Retrieve_Option.equals("By BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, globalSearch_Number, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
		}

		Step_End(21, "open the Import Documentationmodule and  Retrieve the new  bill using tool bar search.or retrive the saved bill then click the edit in tool bar and then go the sam steps.", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
		if(!actual_Master_BL_Status.equals(master_BL_Status)) {
			click(driver, Edit_Button_toolBar);
		}

		Step_Start(22, "After retrive the bl,go to the charge tab.", test, test1);
		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);
		Step_End(22, "After retrive the bl,go to the charge tab.", test, test1);
		scrollBottom(driver);

		Step_Start(23, "select and double click in the charge tab below grid", test, test1);

		String actualType=getText(driver, select_Type);
		String actualChargeCode=getText(driver, select_ChargeCode);
		if(actualType.equals(type) && actualChargeCode.equals(chargeCode)) {
			click(driver, select_ChargeCode);
			doubleClick(driver, select_ChargeCode);
		}


		Step_End(23, "select and double click in the charge tab below grid", test, test1);
		Step_Start(24, "charge code details has shown respective  charge code  field", test, test1);

		waitForElement(driver, chargeCode_SearchButton_IMD);
		String actual_ChargeCode=getAttribute(driver, collectChargeTab_ChargeCode, "value");
		if(actual_ChargeCode.equals(chargeCode)) {
			System.out.println("Expected : Charge code details should be fetched || Actual : Charge code details fetched");
			Extent_pass_New(driver, "Expected : Charge code details should be fetched || Actual : Charge code details fetched", test, test1);
		}else {
			System.out.println("Expected : Charge code details should be fetched || Actual : Charge code details not fetched");
			Extent_fail(driver, "Expected : Charge code details should be fetched || Actual : Charge code details not fetched", test, test1);
		}

		Step_End(24, "charge code details has shown respective  charge code  field", test, test1);

		Step_Start(25, "in collect charge tab all field are disable .click the reset", test, test1);

		waitForElement(driver, chargeCode_SearchButton_IMD);
		if(!isElementAccessible(driver, chargeCode_SearchButton_IMD) &&  !isElementAccessible(driver, collectChargeTab_add_Button)) {
			System.out.println("Expected : Collect Charge Tab Fields Should be Disabled || Actual : Collect Charge Tab Fields Are Disabled");
			Extent_pass_New(driver, "Expected : Collect Charge Tab Fields Should be Disabled || Actual : Collect Charge Tab Fields Are Disabled", test, test1);

		}else {
			System.out.println("Expected : Collect Charge Tab Fields Should be Disabled || Actual : Collect Charge Tab Fields Are not Disabled");
			Extent_fail(driver, "Expected : Collect Charge Tab Fields Should be Disabled || Actual : Collect Charge Tab Fields Are not Disabled", test, test1);
		}

		click(driver, collectCharges_Reset_Button);
		Step_End(25, "in collect charge tab all field are disable .click the reset", test, test1);
		Step_Start(26, "save the import documentation.", test, test1);

		scrollTop(driver);
		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status1=getText(driver, BL_status_IMP_DOC);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		Step_End(26, "save the import documentation.", test, test1);
		Step_Start(27, "system has validate -Import Documentation is saved.Ok", test, test1);

		if(actual_Master_BL_Status1.equals(master_BL_Status)) {
			waitForPopup(driver, popup_Message, saved_Popup_IMD);
			String actualPopup=getText(driver, popup_Message);
			if(actualPopup.equals(saved_Popup_IMD)) {
				System.out.println("Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup);
				Extent_pass_New(driver, "Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup, test, test1);
				waitForElement(driver, popup_Message_Ok_Button);safeclick(driver, popup_Message_Ok_Button);
			}else {

				System.out.println("Not Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup, test, test1);

			}

		}else {
			waitForPopup(driver, popup_Message, updatedPopup);
			String actualPopup=getText(driver, popup_Message);
			if(actualPopup.equals(updatedPopup)) {
				System.out.println("Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup);
				Extent_pass_New(driver, "Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup, test, test1);
				waitForElement(driver, popup_Message_Ok_Button);safeclick(driver, popup_Message_Ok_Button);
			}else {

				System.out.println("Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup, test, test1);
			}
		}
		Step_End(27, "system has validate -Import Documentation is saved.Ok", test, test1);

		Step_Start(28, "Unable to edit/ add charges the collect charge field in import documentation", test, test1);
		if(!isElementAccessible(driver, collectChargeTab_add_Button)){
			Extent_pass_New(driver, "Matched || Unable to edit/ add charges the collect charge field in import documentation", test, test1);
			System.out.println("Matched || Unable to edit/ add charges the collect charge field in import documentation");
		}else {
			click(driver, collectChargeTab_add_Button);
			System.out.println("Not Matched || Able to edit/ add charges the collect charge field in import documentation");
			Extent_fail(driver, "Not Matched || Able to edit/ add charges the collect charge field in import documentation", test, test1);
		}
		Step_End(28, "Unable to edit/ add charges the collect charge field in import documentation", test, test1);
		Step_Start(29, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(30, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_Start(31, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

		scrollTop(driver);

		if(wantToDelete.equalsIgnoreCase("Yes")){
			deleteImportDocument(driver, wantToDelete_Popup_IMD, deleted_Popup_IMD);
		}
		Step_End(29, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_End(30, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_End(31, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

		Step_Start(32, "Go to Agency configuration module", test, test1);

		// Agency Configuration
		Extent_call(test, test1, "Reset Agency configuration");
		Extent_cal(test, test1, module_AgencyConfiguration);
		reSetAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, conditionFilter, agencyUser, agencyConfig_Description, defaultValue, newlyAdded, reset);
		
		Extent_completed(testcase_Name, test, test1);

	}
}
