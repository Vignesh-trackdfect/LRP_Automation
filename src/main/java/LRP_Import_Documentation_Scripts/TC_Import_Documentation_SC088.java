package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC088 extends Keywords{
	public void Import_Documentation_SC088(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		// Get data from test data
		String testcase_Name="TC_Import_Documentation_SC088";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String globalConfigurationModule = Excel_data.get("Module_GlobalConfiguration");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String globalAttribute = Excel_data.get("GlobalAttribute");
		String globalValue = Excel_data.get("GlobalValue");
		String chargeCodes=Excel_data.get("ChargeCodes");
		String type=Excel_data.get("Type");
		String consigneeOption=Excel_data.get("ConsigneeOption");
		String notifyPartyOption=Excel_data.get("NotifyPartyOption");
		String globalSearchFilterOption_IMD=Excel_data.get("GlobalSearchFilterOption_IMD");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String payByType = Excel_data.get("PayBy_Type_Edit");
		String saved_Popup_IMD = Excel_data.get("Saved_Popup_IMD");
		String master_BL_Status = Excel_data.get("Master_BL_Status");
		String wantToDelete_Popup_IMD = Excel_data.get("WantToDelete_Popup_IMD");
		String deleted_Popup_IMD = Excel_data.get("Deleted_Popup_IMD");
		String defaultValue = Excel_data.get("DefaultValue");
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

		String select_Type=String.format(ImportDocumentation_Locators.chargeType, type);

		 Extent_Start(testcase_Name, test, test1);
		 navigateUrl(driver, url);

		// Login
		 LRP_Login(driver, username, password);

		 verifyMainMenu(driver);
			
		// Switch User
		SwitchProfile(driver, agencyUser);

		// Global Configuration
	   	setGlobalConfiguration(driver, globalConfigurationModule, globalAttribute, globalValue);
	 
		Extent_cal(test, test1, module_ImportDocumentation);

		Step_Start(8, "open the Import Documentationmodule and  Retrieve the new  bill using tool bar search.or retrive the saved bill then click the edit in tool bar and then go the sam steps.", test, test1);

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
				scrollTop(driver);
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
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
		
		Step_End(8, "open the Import Documentationmodule and  Retrieve the new  bill using tool bar search.or retrive the saved bill then click the edit in tool bar and then go the sam steps.", test, test1);
		Step_Start(9, "Go to the collect charge tab select the charge and right click", test, test1);

		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);

		Step_End(9, "Go to the collect charge tab select the charge and right click", test, test1);
		Step_Start(10, "pay bay combo box  open and "+globalValue+" has shown .\r\n"
				+ "--------Verify---------\r\n"
				+globalValue+" has to pass it from Data sheet all the Place,\r\n"
				+ "Verify Given Data is matched with Step 5 then Result Pass else Fail.", test, test1);

		List<String> chargeCode = splitAndExpand(chargeCodes);
		
		String actualType=getText(driver, select_Type);
		String select_ChargeCode=String.format(ImportDocumentation_Locators.chargeCode_IMD, chargeCode.get(0));

		if(actualType.equals(type) ) {            
			click(driver, select_ChargeCode);
			RightClick(driver, select_ChargeCode);

			waitForElement(driver, payBy_ComboBox);
			mouseOverToElement(driver, payBy_ComboBox);

			waitForElement(driver, Collect_Charges_Tab);

			if(!isDisplayed(driver, pay_By_Options) && globalValue.trim().equals("")){
				Extent_pass_New(driver, "Matched || "+consigneeOption+","+notifyPartyOption+" options are not available", test, test1);
				System.out.println("Matched || "+consigneeOption+","+notifyPartyOption+" options are not available");

			}else{

				String actualPayByOption;
				List<WebElement> PayBy_Options =listOfElements(driver, pay_By_Options);
				for(WebElement PayBy_Option : PayBy_Options) {
					actualPayByOption=PayBy_Option.getText();
					if(globalValue.equals("CN")&&actualPayByOption.equals(consigneeOption)) {
						System.out.println("Matched || Expected : "+actualPayByOption+" option Should be available || Actual : "+actualPayByOption+" option is available");
						Extent_pass_New(driver, "Matched || Expected : "+actualPayByOption+" option Should be available || Actual : "+actualPayByOption+" option is available", test, test1);

					}else if(globalValue.equals("NT")&&actualPayByOption.equals(notifyPartyOption)){
						System.out.println("Matched || Expected : "+actualPayByOption+" option Should be available || Actual : "+actualPayByOption+" option is available");
						Extent_pass_New(driver, "Matched || Expected : "+actualPayByOption+" option Should be available || Actual : "+actualPayByOption+" option is available", test, test1);


					}else if(globalValue.equals("CN,NT")&&actualPayByOption.equals(notifyPartyOption)||actualPayByOption.equals(consigneeOption)) {
						System.out.println("Matched || Expected : "+actualPayByOption+" option Should be available || Actual : "+actualPayByOption+" option is available");
						Extent_pass_New(driver, "Matched || Expected : "+actualPayByOption+" option Should be available || Actual : "+actualPayByOption+" option is available", test, test1);

					}else {
						System.out.println("Not Matched || Expected options should not available || Actual Option : "+actualPayByOption);
						Extent_fail(driver, "Not Matched || Expected options should not available || Actual Option : "+actualPayByOption, test, test1);
					}

				}


				Step_End(10, "pay bay combo box  open and "+globalValue+" has shown .\r\n"+ "--------Verify---------\r\n"+globalValue+" has to pass it from Data sheet all the Place,\r\n"+ "Verify Given Data is matched with Step 5 then Result Pass else Fail.", test, test1);
				
				Step_Start(11, "change the customer if i click NT -then payby column has changed NT", test, test1);
				Step_Start(12, "like that multiple charge code has to be change", test, test1);

				for(int i=0;i<chargeCode.size();i++) {
				String select_ChargeCode1=String.format(ImportDocumentation_Locators.chargeCode_IMD, chargeCode.get(i));
				
				click(driver, collectChargersTab_Rows);
				waitForElement(driver, select_ChargeCode1);

				click(driver, select_ChargeCode1);
				RightClick(driver, select_ChargeCode1);

				waitForDisplay(driver, payBy_ComboBox);
				mouseOverToElement(driver, payBy_ComboBox);

				String select_PayBy=String.format(payBy_Type, payByType);
				waitForDisplay(driver, select_PayBy);
				click(driver, select_PayBy);
				
				waitForElement(driver, collectChargersTab_Rows);
				List<Map<String, String>> collectCharges_TableData = getTableData(driver, collectChargersTab_Coloumns, collectChargersTab_Rows);
				String actualPayBy = getValueByFirstColumnAndHeader(collectCharges_TableData, "Charge Code", chargeCode.get(i), "Pay By");
				
				if(payByType.equals("Notify party")) {
					payByType="NT";
					if(actualPayBy.equals(payByType)) {
						System.out.println("Matched || Expected Pay By : "+payByType+" || Actual Pay By : "+actualPayBy);
						Extent_pass_New(driver, "Matched || Expected Pay By : "+payByType+" || Actual Pay By : "+actualPayBy, test, test1);
					}else {
						System.out.println("Not Matched || Expected Pay By : "+payByType+" || Actual Pay By : "+actualPayBy);
						Extent_fail(driver, "Not Matched || Expected Pay By : "+payByType+" || Actual Pay By : "+actualPayBy, test, test1);
					}
				}else if(payByType.equals("Consignee")) {
					payByType="CN";
					if(actualPayBy.equals(payByType)) {
						System.out.println("Matched || Expected Pay By : "+payByType+" || Actual Pay By : "+actualPayBy);
						Extent_pass_New(driver, "Matched || Expected Pay By : "+payByType+" || Actual Pay By : "+actualPayBy, test, test1);
					}else {
						System.out.println("Not Matched || Expected Pay By : "+payByType+" || Actual Pay By : "+actualPayBy);
						Extent_fail(driver, "Not Matched || Expected Pay By : "+payByType+" || Actual Pay By : "+actualPayBy, test, test1);
					}
					

				}else {
					System.out.println("Consignee and Notify Party are not available");
				}
				
				payByType = Excel_data.get("PayBy_Type_Edit");

			}
				Step_End(11, "change the customer if i click NT -then payby column has changed NT", test, test1);
				Step_End(12, "like that multiple charge code has to be change", test, test1);
				
				Step_Start(13, "Save the Import Documentation.\r\n"
						+ ".system has validate -Import Documentation is saved.Ok", test, test1);
				

				scrollTop(driver);
				waitForElement(driver, BL_status_IMP_DOC);
				String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
				if(actual_Master_BL_Status.equals(master_BL_Status)) {
					waitForElement(driver, SaveButton_ToolBar);
					jsClick(driver, SaveButton_ToolBar);

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
				}
				Step_End(13, "Save the Import Documentation.\r\n"
						+ ".system has validate -Import Documentation is saved.Ok", test, test1);
				
				scrollTop(driver);
				Step_Start(14, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
				Step_Start(15, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
						+ "YES or N0  ", test, test1);
				Step_Start(16, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

				if(wantToDelete.equalsIgnoreCase("Yes")){
					deleteImportDocument(driver, wantToDelete_Popup_IMD, deleted_Popup_IMD);
				}
				
				Step_End(14, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
				Step_End(15, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
						+ "YES or N0  ", test, test1);
				Step_End(16, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

			}
		}

		reSetGlobalConfiguration(driver, "Yes", globalConfigurationModule, globalAttribute, defaultValue);	
		
		Extent_completed(testcase_Name, test, test1);

	}
}
