package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC62 extends Keywords{
	public void Haulage_Contract_SC62(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC62";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String module_UserLevelSecurity=Excel_data.get("module_UserLevelSecurity");
		String Username_Header = Excel_data.get("Username_Header");
		String conditionFilter=Excel_data.get("ConditionFilter");
		String Module_Haulage_Contract=Excel_data.get("Module_Haulage_Contract");
		String privilegeCode=Excel_data.get("PrivilegeCode");
		String updatedPopup=Excel_data.get("UpdatedPopup");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		
		Step_Start(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);

		moduleNavigate(driver, Haulage_Contract_Module_Name);

		Step_End(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		Step_Start(2, "Check the approve Button present in the Haulage contract.", test, test1);
		
		waitForDisplay(driver, HC_Reject_Button);
		if(isdisplayed(driver, HC_Reject_Button)) {
			System.out.println("Expected Result: 'Approve' button should be present in the Haulage contract || Actual Result: 'Approve' button is present in the Haulage contract.");
			Extent_pass_New(driver, "Expected Result: 'Approve' button should be present in the Haulage contract || Actual Result: 'Approve' button is present in the Haulage contract.", test, test1);

		}else {
			
			System.out.println("Expected Result: 'Approve' button should be present in the Haulage contract || Actual Result: 'Approve' button is Not present in the Haulage contract.");
			Extent_fail(driver, "Expected Result: 'Approve' button should be present in the Haulage contract || Actual Result: 'Approve' button is Not present in the Haulage contract.", test, test1);

		}

		Step_End(2, "Check the approve Button present in the Haulage contract.", test, test1);

		Step_Start(3, ".Enter the  screen name as 'user level security' in module search field. ", test, test1);
	
		
		
		moduleNavigate(driver, module_UserLevelSecurity);
		
		Step_End(3, ".Enter the  screen name as 'user level security' in module search field. ", test, test1);

		Step_Start(4, "Select the user name and Click edit  ", test, test1);

		waitForElement(driver, userName_SearchButton);
		click(driver, userName_SearchButton);
		waitForDisplay(driver, userLevelSecurity_SearchFrame);
		if(isdisplayed(driver, userLevelSecurity_SearchFrame)) {
			twoColumnSearchWindow(driver,Username_Header,conditionFilter,Username);
		}
		
		waitForElement(driver, userLevelSecurity_Edit);
		click(driver, userLevelSecurity_Edit);
		
		Step_End(4, "Select the user name and Click edit  ", test, test1);
		
		Step_Start(5, ".Remove the reject button privilege on the user level security for haulage contract. ", test, test1);

		waitForElement(driver, loadModules_Button);
		click(driver, loadModules_Button);
		
		waitForElement(driver, treeActivitySubFilter);
		click(driver, treeActivitySubFilter);
		sendKeys(driver, treeActivitySubFilter, Module_Haulage_Contract);
		
		waitForDisplay(driver, UL_Haulage_Contract);
		click(driver, UL_Haulage_Contract);
		
		waitForDisplay(driver, UL_privilege_RJM);
		if(isdisplayed(driver, UL_privilege_RJM)) {
			click(driver, UL_privilege_RJM);
			waitForElement(driver, privilege_Remove_Button);
			click(driver, privilege_Remove_Button);
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
		
		Step_End(5, ".Remove the reject button privilege on the user level security for haulage contract. ", test, test1);

		////Logout & Login
		Step_Start(6, "once added the privilege and then logout the application.", test, test1);
		
		waitForElement(driver, User_Logout);
		click(driver, User_Logout);
		waitForElement(driver, Logout_Popup);
		click(driver, Logout_Yes);
		alertAccept(driver);
		
		LRP_Login(driver, Username, Password);
		
		Step_End(6, "once added the privilege and then logout the application.", test, test1);
		
		Step_Start(7, "Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);

		moduleNavigate(driver, Haulage_Contract_Module_Name);
		
		
		Step_End(7, "Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		Step_Start(8, "Check Reject button not present in the Haulage contract.", test, test1);
		
		waitForDisplay(driver, HC_Reject_Button);
		if(!isdisplayed(driver, HC_Reject_Button)) {
			System.out.println("Expected Result: 'Reject' button should be present in the Haulage contract || Actual Result: 'Reject' button is present in the Haulage contract.");
			Extent_pass_New(driver, "Expected Result: 'Reject' button should be present in the Haulage contract || Actual Result: 'Reject' button is present in the Haulage contract.", test, test1);

		}else {
			
			System.out.println("Expected Result: 'Reject' button should be present in the Haulage contract || Actual Result: 'Reject' button is Not present in the Haulage contract.");
			Extent_fail(driver, "Expected Result: 'Reject' button should be present in the Haulage contract || Actual Result: 'Reject' button is Not present in the Haulage contract.", test, test1);

		}
		
		Step_End(8, "Check Reject button not present in the Haulage contract.", test, test1);

		
		moduleNavigate(driver, module_UserLevelSecurity);
		
		waitForElement(driver, userName_SearchButton);
		click(driver, userName_SearchButton);
		waitForDisplay(driver, userLevelSecurity_SearchFrame);
		if(isdisplayed(driver, userLevelSecurity_SearchFrame)) {
			twoColumnSearchWindow(driver,Username_Header,conditionFilter,Username);
		}
		
		waitForElement(driver, userLevelSecurity_Edit);
		click(driver, userLevelSecurity_Edit);
		

		waitForElement(driver, loadModules_Button);
		click(driver, loadModules_Button);
		
		waitForElement(driver, treeActivitySubFilter);
		click(driver, treeActivitySubFilter);
		sendKeys(driver, treeActivitySubFilter, Module_Haulage_Contract);
		
		waitForDisplay(driver, UL_Haulage_Contract);
		click(driver, UL_Haulage_Contract);
		
		
		waitForDisplay(driver, UL_privilege_APM);
		if(!isdisplayed(driver, UL_privilege_APM)) {
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
		String actualPopup1=getText(driver, userLevelSecurity_Popup);
		if(actualPopup1.equals(updatedPopup)) {
			Extent_pass_New(driver, "Matched || Expected Popup : "+updatedPopup+" || Actual Popup : "+actualPopup1, test, test1);
			System.out.println("Matched || Expected Popup : "+updatedPopup+" || Actual Popup : "+actualPopup1);
			click(driver, userLevelSecurity_Popup_Ok);
		}else {
			System.out.println("Not Matched || Expected Popup : "+updatedPopup+" || Actual Popup : "+actualPopup1);
			Extent_fail(driver, "Not Matched || Expected Popup : "+updatedPopup+" || Actual Popup : "+actualPopup1, test, test1);
		}
		
		
		Extent_completed(testcase_Name, test, test1);

}

}
