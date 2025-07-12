package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC087 extends Keywords {

	public void Import_Documentation_SC087(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		//		Get data from test data
		String testcase_Name="TC_Import_Documentation_SC087";
		navigateUrl(driver, url);
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
		String defaultValue=Excel_data.get("DefaultValue");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String chargeCodes=Excel_data.get("ChargeCode");
		String type=Excel_data.get("Type");
		String ID_Charges_Table_Headers=Excel_data.get("ID_Charges_Table_Headers");
		String ID_Table_Name=Excel_data.get("ID_Table_Name");
		String saved_Popup_IMD = Excel_data.get("Saved_Popup_IMD");
		String wantToDelete_Popup_IMD = Excel_data.get("WantToDelete_Popup_IMD");
		String deleted_Popup_IMD = Excel_data.get("Deleted_Popup_IMD");
		String updatedPopup=Excel_data.get("UpdatedPopup");
		String chargeCodeEdit=Excel_data.get("ChargeCodeEdit");
		String baseRateUnit=Excel_data.get("BaseRateUnit");
		String currencyCode=Excel_data.get("CurrencyCode");
		String baseRate=Excel_data.get("BaseRate");
		String portCode=Excel_data.get("PortCode");
		String payBy=Excel_data.get("PayBy");
		String eqpType=Excel_data.get("EquipmentType");
		String baseRateQuantity=Excel_data.get("BaseRateQuantity");
		String attribute = Excel_data.get("Attribute");
		String conditionFilter=Excel_data.get("ConditionFilter");
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
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String reset = Excel_data.get("reset");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Pol_Header = Excel_data.get("Pol_Header");
		String ChargeCode_Search_Header = Excel_data.get("ChargeCode_Search_Header");
		String BaseRateUnit_Search_Header = Excel_data.get("BaseRateUnit_Search_Header");
		String Currency_Search_Header = Excel_data.get("Currency_Search_Header");
		String PayLocation_Search_Header = Excel_data.get("PayLocation_Search_Header");
	
		
		String select_Type=String.format(chargeType, type);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);

		//		Login
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		Step_Start(1, "switch the agency and .open the  Agency configuration module ", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "switch the agency and .open the  Agency configuration module ", test, test1);

		// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);

		List<Boolean> newlyAdded =setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, conditionFilter, agencyUser, attribute, agencyConfig_Description, value);
		Extent_cal(test, test1, module_ImportDocumentation);

		Step_Start(21, " open the Import Documentationmodule and  Retrieve the new  bill using tool bar search.or retrive the saved bill then click the edit in tool bar and then go the sam steps.", test, test1);

		moduleNavigate(driver, module_ImportDocumentation);
		
		if(BL_Retrieve_Option.equals("By Service")) {
			
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
			
			scrollTop(driver);
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
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, globalSearch_Number, "", "", "", "");
		}

		
		Step_End(21, " open the Import Documentationmodule and  Retrieve the new  bill using tool bar search.or retrive the saved bill then click the edit in tool bar and then go the sam steps.", test, test1);

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
		
		Step_Start(23, "In collect charge tab all field are enable", test, test1);
		
		waitForElement(driver, chargeCode_SearchButton_IMD);
		if(isElementAccessible(driver, chargeCode_SearchButton_IMD) &&  isElementAccessible(driver, collectChargeTab_add_Button)) {
			System.out.println("Expected : Collect Charge Tab Fields Should be Enable || Actual : Collect Charge Tab Fields Are Enabled");
			Extent_pass_New(driver, "Expected : Collect Charge Tab Fields Should be Enable || Actual : Collect Charge Tab Fields Are Enabled", test, test1);
			
		}else {
			System.out.println("Expected : Collect Charge Tab Fields Should be Enable || Actual : Collect Charge Tab Fields Are not Enabled");
			Extent_fail(driver, "Expected : Collect Charge Tab Fields Should be Enable || Actual : Collect Charge Tab Fields Are not Enabled", test, test1);
		}
			
		Step_End(23, "In collect charge tab all field are enable", test, test1);
				
		List<String> chargeCode = splitAndExpand(chargeCodes);

		String select_ChargeCode=String.format(chargeCode_IMD, chargeCode.get(0));

		String actualType=getText(driver, select_Type);
		if(!chargeCode.get(0).equals(" ")){
		String actualChargeCode=getText(driver, select_ChargeCode);
		if(actualType.equals(type) && actualChargeCode.equals(chargeCode.get(0))) {
			click(driver, select_ChargeCode);
			doubleClick(driver, select_ChargeCode);
		}
		}
		scrollBottom(driver);
		waitForElement(driver, collectChargersTab_Rows);

				
		Step_Start(25, "Change the charge code in charge code search field.", test, test1);
		
		for(int i=0;i<chargeCode.size();i++) {
			
			String select_ChargeCode1=String.format(chargeCode_IMD, chargeCode.get(i));

			List<String> baseRateUnits = splitAndExpand(baseRateUnit);
			List<String> chargeCodeEdits = splitAndExpand(chargeCodeEdit);
			List<String> currencyCodes = splitAndExpand(currencyCode);
			List<String> eqpTypes = splitAndExpand(eqpType);
			List<String> baseRateQuantities = splitAndExpand(baseRateQuantity);
			List<String> baseRates = splitAndExpand(baseRate);
			List<String> portCodes = splitAndExpand(portCode);
			List<String> payByies = splitAndExpand(payBy);
			
			String chargeCode_Input = chargeCode.get(i);
			String chargeCode_Edit_Input = chargeCodeEdits.get(i);
			String baseRate_Unit_Input = baseRateUnits.get(i);
			String currencyCode_Input = currencyCodes.get(i);
			String eqpType_Input = eqpTypes.get(i);
			String baseRateQuantity_Input = baseRateQuantities.get(i);
			String baseRate_Input = baseRates.get(i);
			String payBy_Input = payByies.get(i);
			String portCode_Input = portCodes.get(i);
			
			List<String> chargeCodeList=new ArrayList<String>();
			waitForElement(driver, collectChargersTab_Coloumns);
			List<Map<String, String>> collect_Chareges_Tabledata = getTableData(driver, collectChargersTab_Coloumns, collectChargersTab_Rows);

			List<String> columnheaders = splitAndExpand(ID_Charges_Table_Headers);
			String Charges_Tabledata = TableDataForReport(driver, collect_Chareges_Tabledata,ID_Table_Name,columnheaders);
			
			if(!chargeCode_Input.trim().equals("")) {
				String firstcolumnHeader = "Charge Code";
				String firstColumnValue = chargeCode_Input; 
				chargeCodeList = getValuesByFirstColumnAndHeader(collect_Chareges_Tabledata,firstcolumnHeader, firstColumnValue,  "Charge Code");
			}
			
			Step_Start(24, "double click the charge code in below grid and charge code details has shown respective  charge code  field.", test, test1);

			doubleClick(driver, select_ChargeCode1);

			Step_End(24, "double click the charge code in below grid and charge code details has shown respective  charge code  field.", test, test1);

		waitForElement(driver, chargeCode_SearchButton_IMD);
		String actual_ChargeCode=getAttribute(driver, collectChargeTab_ChargeCode, "value");
		if(actual_ChargeCode.equals(chargeCode_Input) && !chargeCode_Input.trim().equals("")) {
			Extent_pass_New(driver, "Charge Code Details is fetched in the field ||  Expected : "+chargeCode_Input+" || Actual : "+actual_ChargeCode, test, test1);
			System.out.println("Charge Code Details is fetched in the Field||  Expected : "+chargeCode_Input+" || Actual : "+actual_ChargeCode);
		}else {
			System.out.println("Charge Code Details is not fetched in the field ||  Expected : "+chargeCode_Input+" || Actual : "+actual_ChargeCode);
			Extent_fail(driver, "Charge Code Details is not fetched in the field ||  Expected : "+chargeCode_Input+" || Actual : "+actual_ChargeCode, test, test1);
		}
		
		if(!chargeCode_Edit_Input.trim().trim().equals("")) {
			waitForElement(driver, chargeCode_SearchButton_IMD);
			if(isClickable(driver, chargeCode_SearchButton_IMD)) {
				System.out.println("Expected :  Charge code search icon should be Enable || Actual : Charge code search icon is Enabled");
				Extent_pass_New(driver, "Expected :  Charge code search icon should be Enable || Actual : Charge code search icon is Enabled", test, test1);
				if(!chargeCode_Edit_Input.trim().equals("")) {
					click(driver, chargeCode_SearchButton_IMD);
					twoColumnSearchWindow(driver, ChargeCode_Search_Header, conditionFilter, chargeCode_Edit_Input);
				}
			}else {
				System.out.println("Expected : Charge code search icon should be Enable || Actual : Charge code search icon is not Enabled");
				Extent_fail(driver, "Expected : Charge code search icon should be Enable || Actual : Charge code search icon is not Enabled", test, test1);
			}
		}
			
		Step_End(25, "Change the charge code in charge code search field.", test, test1);
		Step_Start(26, "Change  the unit code in base rate unit field.", test, test1);
		
		if(!baseRate_Unit_Input.trim().equals("")) {
			waitForElement(driver, baseRateUnit_SearchButton_IMD);
			if(isClickable(driver, baseRateUnit_SearchButton_IMD)) {
				System.out.println("Expected :  Base Rate Unit icon should be Enable || Actual : Base Rate Unit icon is Enabled");
				Extent_pass_New(driver, "Expected :  Base Rate Unit icon should be Enable || Actual : Base Rate Unit icon is Enabled", test, test1);
				if(!baseRate_Unit_Input.trim().equals("")) {
					waitForElement(driver, baseRateUnit_SearchButton_IMD);
					click(driver, baseRateUnit_SearchButton_IMD);
					twoColumnSearchWindow(driver, BaseRateUnit_Search_Header, conditionFilter, baseRate_Unit_Input);		
				}
			}else {
				System.out.println("Expected :  Base Rate Unit icon should be Enable || Actual : Base Rate Unit icon is not Enabled");
				Extent_fail(driver, "Expected :  Base Rate Unit icon should be Enable || Actual : Base Rate Unit icon is not Enabled", test, test1);
			}
		}
		
		Step_End(26, "Change  the unit code in base rate unit field.", test, test1);
		Step_Start(27, "Change  the currency in using currency code field", test, test1);
		
		if(!currencyCode_Input.trim().equals("")) {

			waitForElement(driver, currency_SearchButton_IMD);
			if(isClickable(driver, currency_SearchButton_IMD)) {
				System.out.println("Expected :  Currency icon should be Enable || Actual : Currency icon is Enabled");
				Extent_pass_New(driver, "Expected :  Currency icon should be Enable || Actual : Currency icon is Enabled", test, test1);
				if(!currencyCode_Input.trim().equals("")) {
					waitForElement(driver, currency_SearchButton_IMD);
					click(driver, currency_SearchButton_IMD);
					twoColumnSearchWindow(driver, Currency_Search_Header, conditionFilter, currencyCode_Input);
				}
			}else {
				System.out.println("Expected :  Currency icon should be Enable || Actual : Currency icon is not Enabled");
				Extent_fail(driver, "Expected :  Currency icon should be Enable || Actual : Currency icon is not Enabled", test, test1);
			}
		}
		Step_End(27, "Change  the currency in using currency code field", test, test1);
		Step_Start(28, "select the equipment type in equipment type drop down field", test, test1);
		
		if(!currencyCode_Input.trim().equals("")) {
			waitForElement(driver, eqpmentType_Dropdown);
			if(isClickable(driver, eqpmentType_Dropdown)) {
				System.out.println("Expected :  Equipment Type Dropdown should be Enable || Actual : Equipment Type Dropdown is Enabled");
				Extent_pass_New(driver, "Expected :  Equipment Type Dropdown should be Enable || Actual : Equipment Type Dropdown is Enabled", test, test1);
				
				if(!currencyCode_Input.trim().equals("")) {
					waitForDisplay(driver, eqpmentType_Dropdown);
					click(driver, eqpmentType_Dropdown);
					String select_EqpmentType=String.format(eqpmentType_Select, eqpType_Input);

					click(driver, select_EqpmentType);
				}
				
			}else {
				System.out.println("Expected :  Equipment Type Dropdown should be Enable || Actual : Equipment Type Dropdown is not Enabled");
				Extent_fail(driver, "Expected :  Equipment Type Dropdown should be Enable || Actual : Equipment Type Dropdown is not Enabled", test, test1);
				
			}
		}
		
		Step_End(28, "select the equipment type in equipment type drop down field", test, test1);
		Step_Start(29, "Enter the quantity in Base Rate Quantity field.", test, test1);
		
		if(!baseRateQuantity_Input.trim().equals("")) {
			waitForElement(driver, baseRateQty);
			if(isClickable(driver, baseRateQty)) {
				System.out.println("Expected :  Base Rate Quantity should be Enable || Actual : Base Rate Quantity is Enabled");
				Extent_pass_New(driver, "Expected :  Base Rate Quantity should be Enable || Actual : Base Rate Quantity is Enabled", test, test1);
				if(!baseRateQuantity_Input.trim().equals("")) {
					waitForElement(driver, baseRateQty);
					click(driver, baseRateQty);
					clearAndType(driver, baseRateQty, baseRateQuantity_Input);
				}
			}else {
				System.out.println("Expected :  Base Rate Quantity should be Enable || Actual : Base Rate Quantity is not Enabled");
				Extent_fail(driver, "Expected :  Base Rate Quantity should be Enable || Actual : Base Rate Quantity is not Enabled", test, test1);
			}
		}
		
		Step_End(29, "Enter the quantity in Base Rate Quantity field.", test, test1);
		Step_Start(30, "Enter the Base Rate in Base Rate Field and select the paylocation in paylocation searchfield", test, test1);
		
		if(!baseRate_Input.trim().equals("")) {
			waitForElement(driver, baseRate_Textfield_IMD);
			if(isClickable(driver, baseRate_Textfield_IMD)) {
				
				System.out.println("Expected :  Base Rate Text should be Enable || Actual : Base Rate Text is Enabled");
				Extent_pass_New(driver, "Expected :  Base Rate Text should be Enable || Actual : Base Rate Text is Enabled", test, test1);
				
				if(!baseRate_Input.trim().equals("")) {
					waitForElement(driver, baseRate_Textfield_IMD);
					click(driver, baseRate_Textfield_IMD);
					clearAndType(driver, baseRate_Textfield_IMD, baseRate_Input);
				}
			}else {
				System.out.println("Expected :  Base Rate Text should be Enable || Actual : Base Rate Text is not Enabled");
				Extent_fail(driver, "Expected :  Base Rate Text should be Enable || Actual : Base Rate Text is not Enabled", test, test1);
			}
		}
		if(!portCode_Input.trim().equals("")) {

			waitForElement(driver, payLocation_SearchButton_IMD);
			if(isClickable(driver, payLocation_SearchButton_IMD)) {
				
				System.out.println("Expected : Pay Location Search button should be Enable || Actual : Pay Location Search button is Enabled");
				Extent_pass_New(driver, "Expected : Pay Location Search button should be Enable || Actual : Pay Location Search button is Enabled", test, test1);
				
				if(!portCode_Input.trim().equals("")) {
					waitForElement(driver, payLocation_SearchButton_IMD);
					click(driver, payLocation_SearchButton_IMD);
					
					twoColumnSearchWindow(driver, PayLocation_Search_Header, conditionFilter, portCode_Input);
				}
			}else {
				System.out.println("Expected : Pay Location Search button should be Enable || Actual : Pay Location Search button is not Enabled");
				Extent_fail(driver, "Expected : Pay Location Search button should be Enable || Actual : Pay Location Search button is not Enabled", test, test1);
				
			}
		}
		Step_End(30, "Enter the Base Rate in Base Rate Field and select the paylocation in paylocation searchfield", test, test1);
		Step_Start(31, "Select the payby  in Pay by drop down field.", test, test1);
		
		if(!payBy_Input.trim().equals("")) {

			waitForElement(driver, payBy_Dropdown_IMD);
			if(isClickable(driver, payBy_Dropdown_IMD)) {
				
				System.out.println("Expected : Pay By Dropdown should be Enable || Actual : Pay By Dropdown is Enabled");
				Extent_pass_New(driver, "Expected : Pay By Dropdown should be Enable || Actual : Pay By Dropdown is Enabled", test, test1);
				
				if(!payBy_Input.trim().equals("")) {
					click(driver, payBy_Dropdown_IMD);
					String select_PayBy=String.format(ImportDocumentation_Locators.payBy_Select, payBy_Input);
					click(driver, select_PayBy);
				} 
			}else {
				System.out.println("Expected : Pay By Dropdown should be Enable || Actual : Pay By Dropdown is not Enabled");
				Extent_fail(driver, "Expected : Pay By Dropdown should be Enable || Actual : Pay By Dropdown is not Enabled", test, test1);
			}
		}
		
		Step_End(31, "Select the payby  in Pay by drop down field.", test, test1);
		Step_Start(32, "Click the add button", test, test1);
		
		click(driver, collectChargeTab_add_Button);
		waitForElement(driver, collectChargeTab_add_Button);
		
		Step_End(32, "Click the add button", test, test1);
		
		Extent_call(test, test1, "Verify that new charge code added in Grid");
		Step_Start(35, "Verify that new charge code added in Grid", test, test1);

		waitForElement(driver, collectChargersTab_Rows);
		List<Map<String, String>> collect_Chareges_Tabledata2 = getTableData(driver, collectChargersTab_Coloumns, collectChargersTab_Rows);
		List<String> columnheaders2 = splitAndExpand(ID_Charges_Table_Headers);
		String Charges_Tabledata2 = TableDataForReport(driver, collect_Chareges_Tabledata2,ID_Table_Name,columnheaders2);
		
		List<String> chargeCodeList2=new ArrayList<String>();
		if(!chargeCode_Edit_Input.trim().equals("")) {
			String firstcolumnHeader = "Charge Code";
			String firstColumnValue = chargeCodeEdit; 
			chargeCodeList2 = getValuesByFirstColumnAndHeader(collect_Chareges_Tabledata,firstcolumnHeader, firstColumnValue,  "Charge Code");
			
		}
		
		if(!chargeCode_Edit_Input.trim().equals("") && !chargeCode_Input.trim().equals("")) {
			if(!chargeCodeList2.equals(chargeCodeList))	{
				Extent_pass_New(driver,"Matched || Before : \n"+ "<pre>" +Charges_Tabledata + "</pre>" +"|| After : \n"+ "<pre>" +Charges_Tabledata2+ "</pre>"  , test, test1);
			}else {
				System.out.println("Not Matched || Charge Code in Before Edit the Row:"+chargeCodeList);
				System.out.println("Not Matched || Charge Code in After Edit the Row:"+chargeCodeList2);
				Extent_fail(driver, "Not Matched || Charge Code in Before Edit the Row:"+chargeCodeList+" || Charge Code in After Edit the Row:"+chargeCodeList2, test, test1);
			}	
		}
		
		Step_End(35, "Verify that new charge code added in Grid", test, test1);
	}
					
				
		Step_Start(33, "Added charges shown in Below grid", test, test1);

		waitForElement(driver, collectChargersTab_Rows);
		
		Step_End(33, "Added charges shown in Below grid", test, test1);

				
		Step_Start(34, "Save the Import Documentation.\r\n.system has validate -Import Documentation is saved.Ok", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status1=getText(driver, BL_status_IMP_DOC);
		
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
	
		if(actual_Master_BL_Status1.equals(master_BL_Status)) {
			
			waitForPopup(driver, popup_Message, saved_Popup_IMD);
				String actualPopup=getText(driver, popup_Message);
				if(actualPopup.equals(saved_Popup_IMD)) {
					System.out.println("Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup);
					Extent_pass_New(driver, "Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup, test, test1);
					click(driver, popup_Message_Ok_Button);
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
				click(driver, popup_Message_Ok_Button);
			}else {
	
				System.out.println("Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup, test, test1);
	
			}
		}
			
		Step_End(34, "Save the Import Documentation.\r\n.system has validate -Import Documentation is saved.Ok", test, test1);
				
		scrollTop(driver);
		Step_Start(36, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(37, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_Start(38, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

		if(wantToDelete.equalsIgnoreCase("Yes")){
			deleteImportDocument(driver, wantToDelete_Popup_IMD, deleted_Popup_IMD);
		}
		Step_End(36, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_End(37, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_End(38, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

	// Agency Configuration
	Extent_cal(test, test1, "Reset Agency Configuration");

	
	reSetAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, attribute, conditionFilter, agencyUser, agencyConfig_Description, defaultValue, newlyAdded, reset);	

	
	Extent_completed(testcase_Name, test, test1);
	}
	
}
