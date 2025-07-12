package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


public class TC_Import_Documentation_SC068 extends Keywords {

	public void Import_Documentation_SC068(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC068";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser").trim();
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String dropdownCondition1 = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String globalSearchFilterOption_IMD=Excel_data.get("GlobalSearchFilterOption_IMD");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
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
		String ports_Module = Excel_data.get("Ports_Module");
		String globalSearchFilterOption_Ports = Excel_data.get("GlobalSearchFilterOption_Ports");
		String conditionFilter=Excel_data.get("ConditionFilter");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String country_Code_Input = Excel_data.get("country_Code_Input");
		String Country_Code_search = Excel_data.get("Country_Code_search");
		String Location_Name_Input = Excel_data.get("Location_Name_Input");
		String Location_Name_Search = Excel_data.get("Location_Name_Search");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String ImportDoc_Select_Type2 = Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Value2 = Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Type3 = Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value3 = Excel_data.get("ImportDoc_Select_Value3");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		SwitchProfile(driver, agencyUser);

		Step_Start(1, "open the import documentation and retrieve the new bil or saved bill using tool bar search", test, test1);

		Extent_cal(test, test1, ImportDocumentationModule);
		moduleNavigate(driver, ImportDocumentationModule);

		if(BL_Retrieve_Option.equals("By Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
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
			waitForElement(driver, popup_Message_Yes_Button);
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
			
			scrollTop(driver);
			if(!POL_Loction.trim().equals("")) {
			waitForElement(driver, POLSearch);
			safeclick(driver, POLSearch);
			twoColumnSearchWindow(driver, Pol_Header, conditionFilter, POL_Loction);
			}
			
			waitForElement(driver, all_Dropdown_1_IMD);
			click(driver, all_Dropdown_1_IMD);
			
			String select_All_Dropdown_1_Option=String.format(all_Dropdown_1_Option_IMD, all_Dropdown_1);
			waitForElement(driver, select_All_Dropdown_1_Option);
			click(driver, select_All_Dropdown_1_Option);
			
			waitForElement(driver, all_Dropdown_2_IMD);
			click(driver, all_Dropdown_2_IMD);
			
			String select_All_Dropdown_2_Option=String.format(all_Dropdown_2_Option_IMD, all_Dropdown_2);
			waitForElement(driver, select_All_Dropdown_2_Option);
			click(driver, select_All_Dropdown_2_Option);
			
			waitForElement(driver, show_BL_Button_IMD);
			safeclick(driver, show_BL_Button_IMD);
			
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, conditionFilter, BL_Num);


		}else if(BL_Retrieve_Option.equals("By BL")) {
				waitForElement(driver, SearchButton_Toolbar);

				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
		}
		
		Step_End(1, "open the import documentation and retrieve the new bil or saved bill using tool bar search", test, test1);
		Step_Start(2, "save the new bill in import documentation in pod agency. or if the bill is already saved the go to 5th step", test, test1);
		
		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
		if(actual_Master_BL_Status.equals(master_BL_Status)) {
			Step_Start(3, "save the import documentation in pod agency", test, test1);
			
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			waitForPopup(driver, popup_Message, "Import Document Saved");
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
			Step_End(3, "save the import documentation in pod agency", test, test1);

		}
		
		Step_End(2, "save the new bill in import documentation in pod agency. or if the bill is already saved the go to 5th step", test, test1);
		
		Step_Start(4, ".one save the import documentation \r\n"
				+ "5. import invoice button is disabled in  POD Agency.", test, test1);
		waitForDisplay(driver, import_invoice_button);

		if(!isClickable(driver, import_invoice_button)) {
			System.out.println("Expected : Import Invoice button Should be Disable || Actual : Import Invoice button is Disabled");
			Extent_pass_New(driver, "Expected : Import Invoice button Should be Disable || Actual : Import Invoice button is Disabled", test, test1);
		}else {
			System.out.println("Expected : Import Invoice button Should be Disable || Actual : Import Invoice button is not Disabled");
			Extent_fail(driver, "Expected : Import Invoice button Should be Disable || Actual : Import Invoice button is not Disabled", test, test1);
		}


		Step_End(4, ".one save the import documentation \r\n"
				+ "5. import invoice button is disabled in  POD Agency.", test, test1);
		Step_Start(6, "go the pld agency open the imp doc retrive the bill import invoice button is enable in PLD Agency.", test, test1);
		
		scrollTop(driver);
		
		waitForElement(driver, import_invoice_button);
		String actualPLD_Port=getText(driver, pld_Agency_Text_Invoice);
		
		Extent_pass_New(driver, "Actual PLD Port  : "+actualPLD_Port, test, test1);
		
		Extent_cal(test, test1, ports_Module);

		moduleNavigate(driver, ports_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_Ports, actualPLD_Port, Location_Name_Search, Location_Name_Input, Country_Code_search, country_Code_Input);


		waitForElement(driver, Agency_text_Field_Ports);
		String port_Agency = getAttribute(driver, Agency_text_Field_Ports, "value");
		
		Extent_pass_New(driver,"Actual PLD Agency : "+ port_Agency, test, test1);
		Extent_cal(test, test1, "Switch to PLD Agency");

		SwitchProfile(driver, port_Agency);
		
		Extent_cal(test, test1, ImportDocumentationModule);

		moduleNavigate(driver, ImportDocumentationModule);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
	
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);		
		
		Step_End(6, "go the pld agency open the imp doc retrive the bill import invoice button is enable in PLD Agency.", test, test1);
		Step_Start(7, "Verify that Import invoice button is Disabled in POD agency  and Import invoice button is enabled in pld agency", test, test1);

		waitForDisplay(driver, import_invoice_button);

		if(isClickable(driver, import_invoice_button)) {
			System.out.println("Expected : Import Invoice button Should be Enable || Actual : Import Invoice button is Enabled");
			Extent_pass_New(driver, "Expected : Import Invoice button Should be Enable || Actual : Import Invoice button is Enabled", test, test1);
		}else {
			System.out.println("Expected : Import Invoice button Should be Enable || Actual : Import Invoice button is Disabled");
			Extent_fail(driver, "Expected : Import Invoice button Should be Enable || Actual : Import Invoice button is Disabled", test, test1);
		}

		Step_End(7, "Verify that Import invoice button is Disabled in POD agency  and Import invoice button is enabled in pld agency", test, test1);

		Extent_call(test, test1, "GO THE POD Agency open the import doc and retrive the bill");
		Extent_cal(test, test1, "Switch to POD Agency");

		SwitchProfile(driver, agencyUser);
		
		Extent_cal(test, test1, ImportDocumentationModule);

		moduleNavigate(driver, ImportDocumentationModule);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
	
		Step_Start(9, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(10, "click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0", test, test1);
		Step_Start(11, "click the yes and system has validate import documentation is deleted", test, test1);

		scrollTop(driver);
		if(wantToDelete.equalsIgnoreCase("Yes")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		
		Step_End(9, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_End(10, "click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0 ", test, test1);
		Step_End(11, "click the yes and system has validate import documentation is deleted", test, test1);

		
		Extent_completed(testcase_Name, test, test1);

	}
}
