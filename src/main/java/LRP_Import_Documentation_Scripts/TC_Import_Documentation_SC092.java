package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
public class TC_Import_Documentation_SC092 extends Keywords {

	public void Import_Documentation_SC092(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		// Get data from test data
		String testcase_Name="TC_Import_Documentation_SC092";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_AgencyConfiguration = Excel_data.get("Module_AgencyConfiguration");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String description = Excel_data.get("AttributeDescription");
		String value = Excel_data.get("Value");
		String defaultValue = Excel_data.get("DefaultValue");
		String globalSearchFilterOption_IMD=Excel_data.get("GlobalSearchFilterOption_IMD");
		String saved_Popup_IMD = Excel_data.get("Saved_Popup_IMD");
		String updatedPopup = Excel_data.get("UpdatedPopup");
		String attribute=Excel_data.get("Attribute");
		String wantToDelete_Popup_IMD = Excel_data.get("WantToDelete_Popup_IMD");
		String deleted_Popup_IMD = Excel_data.get("Deleted_Popup_IMD");
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

		// Switch User
		
		Step_Start(1, "switch the agency and .open the  Agency configuration module ", test, test1);

		SwitchProfile(driver, agencyUser);

		// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);
		List<Boolean> newlyAdded =setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, conditionFilter, agencyUser, attribute, description, value);
		Extent_cal(test, test1, module_ImportDocumentation);

		Step_Start(21, "open the Import Documentationmodule and  Retrieve the new  bill using tool bar search.or retrive the saved bill then click the edit in tool bar and then go the sam steps.", test, test1);
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
			
			if(!POL_Loction.trim().equals("")) {
				scrollTop(driver);
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
		
		Step_End(21, "open the Import Documentationmodule and  Retrieve the new  bill using tool bar search.or retrive the saved bill then click the edit in tool bar and then go the sam steps.", test, test1);
		Step_Start(22,
				"below column has not shown  in collect charges tab  \r\n" + "-----------Verify-----------\r\n"
						+ "Verify that these Fields are not available,\r\n" + "   1.Currency\r\n"
						+ "   2.Manifest Charges\r\n" + "   3.Agency Charges\r\n" + "   4.Total  ",
				test, test1);

		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);
		waitForElement(driver, Collect_Charges_Tab);

		if (!isDisplayed(driver, collectChrges_Total_Table_Headers)) {
			Extent_pass_New(driver, "Matched || 1.Currency\r\n" + "   2.Manifest Charges\r\n" + "   3.Agency Charges\r\n"
					+ "   4.Total  fields are not available", test, test1);
			System.out.println("Matched || 1.Currency\r\n" + "   2.Manifest Charges\r\n" + "   3.Agency Charges\r\n"
					+ "   4.Total  fields are not available");

		} else {
			System.out.println("Not Matched || 1.Currency\r\n" + "   2.Manifest Charges\r\n" + "   3.Agency Charges\r\n"+ "   4.Total  fields are available");
			Extent_fail(driver, "Not Matched || 1.Currency\r\n" + "   2.Manifest Charges\r\n"+ "   3.Agency Charges\r\n" + "   4.Total  fields are available", test, test1);
		}
		Step_End(22,
				"below column has not shown  in collect charges tab  \r\n" + "-----------Verify-----------\r\n"
						+ "Verify that these Fields are not available,\r\n" + "   1.Currency\r\n"
						+ "   2.Manifest Charges\r\n" + "   3.Agency Charges\r\n" + "   4.Total  ",
				test, test1);

		Step_Start(23, "Save the Import Documentation.\r\n"
				+ ".system has validate -Import Documentation is saved.Ok", test, test1);

		scrollTop(driver);
		
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, saved_Popup_IMD);
		String actualPopup=getText(driver, popup_Message);
		if(actualPopup.equals(saved_Popup_IMD)) {
			System.out.println("Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup, test, test1);
		}else if(actualPopup.equals(updatedPopup)) {
			System.out.println("Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(23, "Save the Import Documentation.\r\n"
				+ ".system has validate -Import Documentation is saved.Ok", test, test1);
		scrollTop(driver);
		Step_Start(24, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(25, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_Start(26, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

		if(wantToDelete.equalsIgnoreCase("Yes")){
			deleteImportDocument(driver, wantToDelete_Popup_IMD, deleted_Popup_IMD);
		}
		Step_End(24, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_End(25, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_End(26, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

		Step_Start(27, "Go to Agency configuration module", test, test1);

//		// Agency Configuration
		Extent_call(test, test1, "Reset Agency configuration");
		reSetAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, attribute, conditionFilter, agencyUser, description, defaultValue, newlyAdded, reset);	

		Extent_completed(testcase_Name, test, test1);

	}
}
