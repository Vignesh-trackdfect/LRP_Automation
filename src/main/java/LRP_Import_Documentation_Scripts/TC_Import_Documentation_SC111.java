package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC111 extends Keywords {

	public void Import_Documentation_SC111(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		// Get data from test data
		String testcase_Name="TC_Import_Documentation_SC111";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_AgencyConfiguration = Excel_data.get("Module_AgencyConfiguration");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String globalSearchFilterOption_IMD=Excel_data.get("GlobalSearchFilterOption_IMD");
		String agencyConfig_Description = Excel_data.get("Description_AgencyConfiguration");
		String value = Excel_data.get("Value");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String attribute = Excel_data.get("Attribute");
		String saved_Popup_IMD = Excel_data.get("Saved_Popup_IMD");
		String wantToDelete_Popup_IMD = Excel_data.get("WantToDelete_Popup_IMD");
		String deleted_Popup_IMD = Excel_data.get("Deleted_Popup_IMD");
		String updatedPopup=Excel_data.get("UpdatedPopup");
		String defaultValue=Excel_data.get("DefaultValue");
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
		String conditionFilter = Excel_data.get("ConditionFilter");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String reset = Excel_data.get("reset");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Pol_Header = Excel_data.get("Pol_Header");

		Extent_Start(testcase_Name, test, test1);
		// Login
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		SwitchProfile(driver, agencyUser);

		// Agency Configuration
		Extent_call(test, test1, "Step no 1 to 19 - Agency Configuration SetUp start");
		List<Boolean> newlyAdded =setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, conditionFilter, agencyUser, attribute, agencyConfig_Description, value);
		Extent_call(test, test1, "Step no 1 to 19 - Agency Configuration SetUp End");
		
		Step_Start(20, "OPEN THE IMPORT DOUMENTATION", test, test1);
		moduleNavigate(driver, module_ImportDocumentation);
		Step_End(20, "OPEN THE IMPORT DOUMENTATION", test, test1);

		Step_Start(21, "after retrieve the bl in import documentation.(new bl or saved bl)", test, test1);

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
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, globalSearch_Number, "", "", "", "");
		}
	
		Step_End(21, "after retrieve the bl in import documentation.(new bl or saved bl)", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
		if(!actual_Master_BL_Status.equals(master_BL_Status)) {
			click(driver, Edit_Button_toolBar);
		}
		
		Step_Start(22, "After retrieve the bl in import documentation.------------Verify---------\r\n"
				+ "HBL manifest check box has not shown", test, test1);
		
		waitForDisplay(driver, hbl_Manifest_CheckBox);
		if(!isdisplayed(driver, hbl_Manifest_CheckBox)) {
			System.out.println("Expected : HBL manifest check box should not be Show || Actual : HBL manifest check box has not shown");
			Extent_pass_New(driver, "Expected : HBL manifest check box should not be Show || Actual : HBL manifest check box has not shown", test, test1);
		}else {
			System.out.println("Expected : HBL manifest check box should not be Show || Actual : HBL manifest check box has shown");
			Extent_fail(driver, "Expected : HBL manifest check box should not be Show || Actual : HBL manifest check box has shown", test, test1);
		}
		Step_End(22, "After retrieve the bl in import documentation.------------Verify---------\r\n"
				+ "HBL manifest check box has enable.", test, test1);
		
		Step_Start(23, "Save the Import Documentation.\r\n.system has validate -Import Documentation is saved.Ok", test, test1);
		
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
			
		Step_End(23, "Save the Import Documentation.\r\n.system has validate -Import Documentation is saved.Ok", test, test1);
		
		Step_Start(24, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(25, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_Start(26, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

		scrollTop(driver);

		if(wantToDelete.equalsIgnoreCase("Yes")){
			deleteImportDocument(driver, wantToDelete_Popup_IMD, deleted_Popup_IMD);		
		}
		Step_End(24, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_End(25, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_End(26, "iii.click the yes and system has validate import documentation is deleted .", test, test1);
	
		// Agency Configuration
		Extent_call(test, test1, "Finally all the Script process completed then the system has to remove the Configutation,");
		reSetAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, attribute, conditionFilter, agencyUser, agencyConfig_Description, defaultValue, newlyAdded, reset);	
		Extent_call(test, test1, "Finally all the Script process completed then the system has to remove the Configutation,");
				
		Extent_completed(testcase_Name, test, test1);
	}

}
