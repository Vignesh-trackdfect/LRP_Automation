package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC066 extends Keywords{
	
	public void Import_Documentation_SC066(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC066";
		
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_UserLevelSecurity=Excel_data.get("Module_UserLevelSecurity");
		String updatedPopup=Excel_data.get("UpdatedPopup");
		String module_ImportDocumentation=Excel_data.get("Module_ImportDocumentation");
		String privilegeCode=Excel_data.get("PrivilegeCode");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String globalSearchFilterOption_IMD=Excel_data.get("GlobalSearchFilterOption_IMD");
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
		String conditionFilter = Excel_data.get("ConditionFilter");
		String globalSearchFilterOption_IMD2 = Excel_data.get("globalSearchFilterOption_IMD2");
		String globalSearchFilterOption_IMD3 = Excel_data.get("globalSearchFilterOption_IMD3");
		String globalSearch_Number2 = Excel_data.get("globalSearch_Number2");
		String globalSearch_Number3 = Excel_data.get("globalSearch_Number3");
		String Username_Header = Excel_data.get("Username_Header");
		String POL_HEADER_Value =  Excel_data.get("POL_HEADER_Value");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		// Switch User
		SwitchProfile(driver, agencyUser);


		Extent_cal(test, test1, module_UserLevelSecurity);
		Step_Start(1, "Open the user level security ", test, test1);
		
		moduleNavigate(driver, module_UserLevelSecurity);

		Step_End(1, "Open the user level security ", test, test1);
		Step_Start(2, "Select the login user", test, test1);
		
		waitForElement(driver, userName_SearchButton);
		click(driver, userName_SearchButton);
		waitForDisplay(driver, userLevelSecurity_SearchFrame);
		if(isdisplayed(driver, userLevelSecurity_SearchFrame)) {
			twoColumnSearchWindow(driver,Username_Header,conditionFilter,username);
		}
		
		waitForElement(driver, userLevelSecurity_Edit);
		click(driver, userLevelSecurity_Edit);
		
		Step_End(2, "Select the login user", test, test1);
		Step_Start(3, "Load the module ", test, test1);
		
		waitForElement(driver, loadModules_Button);
		click(driver, loadModules_Button);
		
		Step_End(3, "Load the module ", test, test1);
		Step_Start(4, "Search the import documentation module and right side privilege field has shown ", test, test1);
		
		waitForElement(driver, treeActivitySubFilter);
		click(driver, treeActivitySubFilter);
		sendKeys(driver, treeActivitySubFilter, module_ImportDocumentation);
		
		waitForDisplay(driver, select_ImportDocumentation_Module);
		click(driver, select_ImportDocumentation_Module);
		
		Step_End(4, "Search the import documentation module and right side privilege field has shown ", test, test1);
		Step_Start(5, "Select the DIL privilege and add", test, test1); 
		
		
		waitForDisplay(driver, privilege_DIL);
		if(!isdisplayed(driver, privilege_DIL)) {
			click(driver, privilege_Add_Button);
			waitForElement(driver, privilege_SearchFrame);
			sendKeys(driver, privilegeCode_Filter, privilegeCode);
			String select_privilegeCode_=String.format(select_privilegeCode, privilegeCode);
			click(driver, select_privilegeCode_);
			waitForElement(driver, PrivilegeCode_SelectButton);
			click(driver, PrivilegeCode_SelectButton);
		}else {
			Extent_pass_New(driver, "Expected : Privilage code should  already present in Privilege table|| Actual : "+privilegeCode+" already present in Functional Privilege table", test, test1);
			System.out.println("Expected : Privilage code should  already present in Privilege table|| Actual : "+privilegeCode+" already present in Functional Privilege table");
		}
		
		waitForElement(driver, userLevelSecurity_Save);
		click(driver, userLevelSecurity_Save); 
		
		waitForElement(driver, userLevelSecurity_Popup);
		String actualPopup=getText(driver, userLevelSecurity_Popup);
		if(actualPopup.equals(updatedPopup)) {
			Extent_pass_New(driver, "Matched || Expected Popup : "+updatedPopup+" || Actual Popup : "+actualPopup, test, test1);
			System.out.println("Matched || Expected Popup : "+updatedPopup+" || Actual Popup : "+actualPopup);
			click(driver, userLevelSecurity_Popup_Ok);
		}else {
			System.out.println("Not Matched || Expected Popup : "+updatedPopup+" || Actual Popup : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+updatedPopup+" || Actual Popup : "+actualPopup, test, test1);
		}
		Step_End(5, "Select the DIL privilege and add", test, test1);

		////Logout & Login
		Step_Start(6, "once added the privilege and then logout the application.", test, test1);
		Extent_cal(test, test1, "Logout and Login");

		waitForElement(driver, User_Logout);
		click(driver, User_Logout);
		waitForElement(driver, Logout_Popup);
		click(driver, Logout_Yes);
		alertAccept(driver);
		
		LRP_Login(driver, username, password);
		
		Step_End(6, "once added the privilege and then logout the application.", test, test1);
		Step_Start(7, "open the application", test, test1);
		Step_Start(8, "switch the import agency", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(7, "open the application", test, test1);
		Step_End(8, "switch the import agency", test, test1);
		
		Extent_cal(test, test1, module_ImportDocumentation);
		
		Step_Start(9, "Open the import documentation module.", test, test1);
		
		moduleNavigate(driver, module_ImportDocumentation);

		Step_End(9, "Open the import documentation module", test, test1); 
		Step_Start(10, "Retrieve the bl in import documentation ", test, test1);
		
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
				twoColumnSearchWindow(driver,POL_HEADER_Value,conditionFilter,POL_Loction);
			}
			
			waitForElement(driver, all_Dropdown_1_IMD);
			click(driver, all_Dropdown_1_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_1);
			
			waitForElement(driver, all_Dropdown_2_IMD);
			click(driver, all_Dropdown_2_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_2);
			
			waitForElement(driver, Show_BL_Button);
			safeclick(driver, Show_BL_Button);
			
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);

			twoColumnMultipleSearchWindow(driver, BL_Number_Header, conditionFilter, globalSearch_Number);			

    		waitForElement(driver, SelectButton);

		}else if(BL_Retrieve_Option.equals("By BL")) {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, globalSearch_Number, globalSearchFilterOption_IMD2, globalSearch_Number2, globalSearchFilterOption_IMD3, globalSearch_Number3);

		}
		
		Step_End(10, "Retrieve the bl in import documentation ", test, test1);
		Step_Start(11, "Right side DO issue location field has enable so system has change the do issue location", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForDisplay(driver, DO_IssueLocation_SearchButton);
		if(isElementEnabled(driver, DO_IssueLocation_SearchButton)) {
			Extent_pass_New(driver, "Expected : DO Issue Location Should be Enabled || Actual : DO Issue Location Is Enabled", test, test1);
			System.out.println("Expected : DO Issue Location Should be Enabled || Actual : DO Issue Location Is Enabled");
			
		}else {
			System.out.println("Expected : DO Issue Location Should be Enabled || Actual : DO Issue Location Is not Enabled");
			Extent_fail(driver, "Expected : DO Issue Location Should be Enabled || Actual : DO Issue Location Is not Enabled", test, test1);
		}
		
		Step_End(11, "Right side DO issue location field has enable so system has change the do issue location", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
