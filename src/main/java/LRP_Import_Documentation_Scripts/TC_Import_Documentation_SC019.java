package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC019 extends Keywords {

		public void Import_Documentation_SC019(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Import_Documentation_SC019";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_Discharge_Reconciliation = Excel_data.get("Module_Discharge_Reconciliation");
		String module_ImportDocumentation = Excel_data.get("ImportDocumentationModule");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String SavedPopup = Excel_data.get("SavedPopup");
		String Terminal = Excel_data.get("Terminal");
		String Port = Excel_data.get("Port");
		String bl_Number = Excel_data.get("BL_Number");
		String conditionFilter=Excel_data.get("ConditionFilter");
		String wantToDelete = Excel_data.get("WantToDelete");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);
		
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		
		SwitchProfile(driver, agencyUser);
		
		moduleNavigate(driver, module_Discharge_Reconciliation);
		
		newButton(driver);
		Step_Start(1, "Enter the vaid service in Discharge Reconcillation", test, test1);
		
		waitForElement(driver, Service_Searchfield_DRL);
		sendKeys(driver, Service_Searchfield_DRL, Service);
		
		Step_End(1, "Enter the vaid service in Discharge Reconcillation", test, test1);
		Step_Start(2, "Select the valid Vessel details", test, test1);

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
			waitForElement(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port);
		}
		
		if(!Terminal.trim().equals("")) {
			waitForElement(driver, grid_scroll);
			horizontalscroll(driver, grid_scroll, 300);
			waitForElement(driver, grid_terminal_IMP_DOC);
			sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
		}
		
		waitForElement(driver, Select_Service_Details);
		click(driver,Select_Service_Details);
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);

		Step_End(2, "Select the valid Vessel details", test, test1);
		Step_Start(3, "Download the BL's in Discharge Reconcillation", test, test1);

		waitForElement(driver, Download_BL_Button_DRL);
		safeclick(driver, Download_BL_Button_DRL);

		Step_End(3, "Download the BL's in Discharge Reconcillation", test, test1);
		Step_Start(4, "Import Documentation button is available in Discharge Reconcillation", test, test1);
		Step_Start(5, "Navigate to Import Documentation", test, test1);
		waitForElement(driver, ImportDocumentation_Button_DRL);
		click(driver, ImportDocumentation_Button_DRL);
		waitForDisplay(driver, importDocumentation_Tab_IMP);
		Step_End(5, "Navigate to Import Documentation", test, test1);
		Step_End(4, "Import Documentation button is available in Discharge Reconcillation", test, test1);

		Step_Start(6, "Import Documentation Module has to be open with valid data", test, test1);

		waitForElement(driver, importDocumentation_Tab_IMP);
		if (isDisplayed(driver, importDocumentation_Tab_IMP)) {
			System.out.println("Expected Result : "+module_ImportDocumentation+" module should be Open || Actual result : "+module_ImportDocumentation+" module is opened");
			Extent_pass_New(driver, "Expected Result : "+module_ImportDocumentation+" module should be Open || Actual result : "+module_ImportDocumentation+" module is opened", test, test1);
		} else {
			System.out.println("Expected Result : "+module_ImportDocumentation+" module should be Open || Actual result : "+module_ImportDocumentation+" module is not opened");
			Extent_fail(driver, "Expected Result : "+module_ImportDocumentation+" module should be Open || Actual result : "+module_ImportDocumentation+" module is not opened", test, test1);
		}

		Step_End(6, "Import Documentation Module has to be open with valid data", test, test1);
		Step_Start(7, "select the bl in BL No search field", test, test1);


		waitForElement(driver, BL_SearchButton_IMP_DOC);
		click(driver, BL_SearchButton_IMP_DOC);

		Step_End(7, "select the bl in BL No search field", test, test1);
		Step_Start(8, "Value has to be shown for above tabs and the value refer from BL/MCN.", test, test1);

		twoColumnMultipleSearchWindow(driver, BL_Number_Header, conditionFilter, bl_Number);

		Step_End(8, "Value has to be shown for above tabs and the value refer from BL/MCN.", test, test1);
		Step_Start(9, "click the save in toolbar import documentation module.", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
		if(!actual_Master_BL_Status.equals(master_BL_Status)) {
			click(driver, Edit_Button_toolBar);
		}
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(9, "click the save in toolbar import documentation module.", test, test1);
		Step_Start(10, "once saved the import documentation system has validate import documentation is saved.", test, test1);

		waitForPopup(driver, popup_Message, SavedPopup);
		if(actual_Master_BL_Status.equals(master_BL_Status)) {
			String ImportDocumentationSaved=getText(driver, popup_Message);
			if (SavedPopup.equals(ImportDocumentationSaved)) {
				System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,test1);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved,test, test1);
			}
		}
		Step_End(10, "once saved the import documentation system has validate import documentation is saved.", test, test1);
		
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		
		Step_Start(11, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(12, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(13, "click the yes and system has validate import dcoumentation is deleted", test, test1);

		scrollTop(driver);
		if(wantToDelete.equalsIgnoreCase("Yes")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Step_End(11, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_End(12, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(13, "click the yes and system has validate import dcoumentation is deleted", test, test1);

		Extent_completed(testCaseName, test, test1);
		
	}	
}
