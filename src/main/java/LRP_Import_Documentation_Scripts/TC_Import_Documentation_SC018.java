package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC018 extends Keywords {

	public void Import_Documentation_SC018(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Import_Documentation_SC018";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_ImportDocumentation = Excel_data.get("ImportDocumentationModule");
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
		String CargoType_status_ALL = Excel_data.get("CargoType_status_ALL");
		String conditionFilter=Excel_data.get("ConditionFilter");

		String POL_Search_Header=Excel_data.get("POL_Search_Header");
	
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		//Login

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		
		Step_Start(1, "switch to agency", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, "switch to agency", test, test1);
		Step_Start(2, "open the import documentation module", test, test1);
		
		moduleNavigate(driver, module_ImportDocumentation);

		waitForElement(driver, importDocumentation_Tab_IMP);
		if (isDisplayed(driver, importDocumentation_Tab_IMP)) {
			System.out.println("Expected Result : "+module_ImportDocumentation+" module should be Open || Actual result : "+module_ImportDocumentation+" module is opened");
			Extent_pass_New(driver, "Expected Result : "+module_ImportDocumentation+" module should be Open || Actual result : "+module_ImportDocumentation+" module is opened", test, test1);
		} else {
			System.out.println("Expected Result : "+module_ImportDocumentation+" module should be Open || Actual result : "+module_ImportDocumentation+" module is not opened");
			Extent_fail(driver, "Expected Result : "+module_ImportDocumentation+" module should be Open || Actual result : "+module_ImportDocumentation+" module is not opened", test, test1);
		}
		
		Step_End(2, "open the import documentation module", test, test1);
		//Vignesh-> As discussed with Suresh on 16_04_2025, I have Removed the (Step 3) Codes for validating all the Toolbar functions accessiblity
		
		if(IsElementEnabled(driver, NewButton_ToolBar)) {
			Step_Start(4, "Click the Home button", test, test1);
			click(driver, NewButton_ToolBar);

			Step_End(4, "Click the Home button", test, test1);

			Step_Start(5, "The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.", test, test1);
			waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
			String new_import_documentation=getText(driver, popup_Message);
			if(new_import_documentation.equals(NewImportDocumentationPopup)) {
				System.out.println("Matched || Expected Pop up : "+NewImportDocumentationPopup +" || Actual Pop up : "+new_import_documentation);
				Extent_pass_New(driver, "Matched || Expected Pop up : "+NewImportDocumentationPopup +" || Actual Pop up : "+new_import_documentation, test, test1);
			}else {
				System.out.println("Not Matched || Expected Pop up : "+NewImportDocumentationPopup +" || Actual Pop up : "+new_import_documentation);
				Extent_fail(driver, "Not Matched || Expected Pop up : "+NewImportDocumentationPopup +" || Actual Pop up : "+new_import_documentation, test, test1);
			}

			Step_End(5, "The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.", test, test1);

			Step_Start(6, "Click the Yes button", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			safeclick(driver, popup_Message_Yes_Button);
			Step_End(6, "Click the Yes button", test, test1);

		}
	
		//Vignesh-> As discussed with Suresh on 17_04_2025, I have Removed the (Step 7) Codes for validating the Service, POL search field, all dropdown fields, and Show BL's button are enabled.

		
		Step_Start(8, "enter the valid service", test, test1);
		
		waitForElement(driver, ServiceInput_IMD);
		sendKeys(driver, ServiceInput_IMD, Service);
		
		Step_End(8, "enter the valid service", test, test1);
		Step_Start(9, "populate the vessel details based on provided service ",test, test1);
		
		waitForElement(driver, retrieved_Service_Name_IMD);
		String retrieved_Service=getText(driver, retrieved_Service_Name_IMD);
		
		if(retrieved_Service.equalsIgnoreCase(Service)) {
			System.out.println("Passed || Expected : The vessel details based on provided service should be populated || Actual : The vessel details based on provided service has populated");
			Extent_pass_New(driver, "Passed || Expected : The vessel details based on provided service should be populated || Actual : The vessel details based on provided service has populated", test, test1);
		}else {
			System.out.println("Failed || Expected : The vessel details based on provided service should be populated || Actual : The vessel details based on provided service has not populated");
			Extent_fail(driver, "Failed || Expected : The vessel details based on provided service should be populated || Actual : The vessel details based on provided service has not populated", test, test1);
		}
		
		Step_End(9, "populate the vessel details based on provided service ",test, test1);
		Step_Start(10, "select the service and vessel details",test, test1);

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
			scrollUsingElement(driver, grid_scroll);
			horizontalscroll(driver, grid_scroll, 300);

			waitForElement(driver, grid_terminal_IMP_DOC);
			sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
		}
		
		waitForElement(driver, Select_Service_Details);
		click(driver,Select_Service_Details);
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		
		Step_End(10, "select the service and vessel details",test, test1);
		
		Step_Start(11,"POL Search field-based on datasheet it will set",test, test1);

		if(!POL_Loction.trim().equals("")) {
			scrollTop(driver);
			waitForElement(driver, POLSearch);
			safeclick(driver, POLSearch);
			
			twoColumnMultipleSearchWindow(driver, POL_Search_Header, conditionFilter, POL_Loction);
		}
		Step_End(11,"POL Search field-based on datasheet it will set",test, test1);
		Step_Start(12, "ALL ,SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);
		
		waitForElement(driver, all_Dropdown_1_IMD);
		click(driver, all_Dropdown_1_IMD);
		
		String select_All_Dropdown_1_Option=String.format(all_Dropdown_1_Option_IMD, all_Dropdown_1);
		waitForElement(driver, select_All_Dropdown_1_Option);
		click(driver, select_All_Dropdown_1_Option);
		
		Step_End(12, "ALL ,SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);
		Step_Start(13, "ALL,LOCAL,TRANS-Based on the data set it will set", test, test1);
		
		waitForElement(driver, all_Dropdown_2_IMD);
		click(driver, all_Dropdown_2_IMD);
		
		String select_All_Dropdown_2_Option=String.format(all_Dropdown_2_Option_IMD, all_Dropdown_2);
		waitForElement(driver, select_All_Dropdown_2_Option);
		click(driver, select_All_Dropdown_2_Option);
		
		Step_End(13, "ALL,LOCAL,TRANS-Based on the data set it will set", test, test1);
		Step_Start(14, "click the show bi's button", test, test1);
		
		waitForElement(driver, Show_BL_Button);
		safeclick(driver, Show_BL_Button);

		Step_End(14, "click the show bi's button", test, test1);
		
		Step_Start(15, "system has ALL  Bl's  has to be shown\r\n"
				+ "---navigate all the Bl's", test, test1);

		waitForElement(driver, Previous_BL_Button);
		waitForElement(driver, BL_Count);
		String BL_LABEL_COUNT=getText(driver, BL_Count);
		int[] BL_CountDisplay=getBlCount(BL_LABEL_COUNT);
		int Endvalue=BL_CountDisplay[1];
		int firstvalue=BL_CountDisplay[0];
		int firstVal=firstvalue;
		try {
			if(firstVal>1) {
				while(firstVal==1) {
					safeclick(driver, Previous_BL_Button);
					waitForDisplay(driver, Previous_BL_Button);
					String BL_LABEL_COUNT1=getText(driver, BL_Count);
					int[] BL_CountDisplay1=getBlCount(BL_LABEL_COUNT1);
					firstVal=BL_CountDisplay1[0];
				}
			}
		}catch(Exception e) {
			
		}
		List<String> Exp_Cargo_Status_Values=splitAndExpand(CargoType_status_ALL, ",");
		boolean Cargo_Status_Check=true;
		List<String> UnMatched_BL_Numbers=new ArrayList<String>();
		for(int i=1;i<Endvalue;i++) {
			waitForElement(driver, Cargo_Type_IMP_DOC);
			String BL_Cargo_Status_Act=getText(driver, Cargo_Type_IMP_DOC);
			String BL_NumberValue=getAttribute(driver, BL_Number, "value");
			if(!Exp_Cargo_Status_Values.contains(BL_Cargo_Status_Act)) {
				UnMatched_BL_Numbers.add(BL_NumberValue);
				Cargo_Status_Check=false;
			}
		}
		
		if(Cargo_Status_Check) {
			System.out.println("Matched || Expected : All the BL Number's Cargo Status should be equalt to "+CargoType_status_ALL+" When selected '"+all_Dropdown_2+"' in the dropdown || Actual : All the BL Number's Cargo Status equal to "+CargoType_status_ALL);
			Extent_pass_New(driver, "Matched || Expected : All the BL Number's Cargo Status should be equalt to "+CargoType_status_ALL+" When selected '"+all_Dropdown_2+"' in the dropdown || Actual : All the BL Number's Cargo Status equal to "+CargoType_status_ALL, test, test1);
		}else {
			System.out.println("Not Matched || Expected : All the BL Number's Cargo Status should be equalt to "+CargoType_status_ALL+" When selected '"+all_Dropdown_2+"' in the dropdown || Actual : Some BL Number's Cargo Status is not equal to "+CargoType_status_ALL+" || BL Cargo Status Mismatched BL Numbers : "+UnMatched_BL_Numbers);
			Extent_fail(driver, "Not Matched || Expected : All the BL Number's Cargo Status should be equalt to "+CargoType_status_ALL+" When selected '"+all_Dropdown_2+"' in the dropdown || Actual : Some BL Number's Cargo Status is not equal to "+CargoType_status_ALL+" || BL Cargo Status Mismatched BL Numbers : "+UnMatched_BL_Numbers, test, test1);
		}
		
		Step_End(15, "system has ALL  Bl's  has to be shown\r\n"
				+ "---navigate all the Bl's", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
