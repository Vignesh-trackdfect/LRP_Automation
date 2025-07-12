package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC015 extends Keywords {

	public void Import_Documentation_SC015(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Import_Documentation_SC015";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		
		String BL_Status_Check_Exp = Excel_data.get("BL_Status_Check_Exp");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String POL_Value= Excel_data.get("POL_Value");	
		String Label_Select_1= Excel_data.get("Label_Select_1");
		String Label_Select_2= Excel_data.get("Label_Select_2");	
		String condition=Excel_data.get("condition");
		

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		//login
		LRP_Login(driver, Username, Password);
		
		Extent_cal(test, test1, "Checking the visibility of Main menu");
		verifyMainMenu(driver);

		Step_Start(1, "switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "switch to agency", test, test1);

		Step_Start(2, "open the import documentation module", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);
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
		clear(driver, ServiceInput_IMD);
		sendKeys(driver, ServiceInput_IMD, Service);

		Step_End(8, "enter the valid service", test, test1);

		Step_Start(9, "populate the vessel details based on provided service", test, test1);
		
		if(!Vessel.trim().equalsIgnoreCase("")) {
			waitForElement(driver, grid_vesselcode_IMP_DOC);
			sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
		}
		
		Step_End(9, "populate the vessel details based on provided service", test, test1);

		Step_Start(10, "select the service and vessel details", test, test1);
		if(!Voyage.trim().equalsIgnoreCase("")) {
			waitForElement(driver, grid_voyagecode_IMP_DOC);
			sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
		}
		
		if(!Bound.trim().equalsIgnoreCase("")) {
			waitForElement(driver, grid_bound_IMP_DOC);
			sendKeys(driver, grid_bound_IMP_DOC, Bound);
		}
		
		if(!portCode.trim().equalsIgnoreCase("")) {
			waitForElement(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC , portCode);
		}
		
		if(!terminalCode.trim().equalsIgnoreCase("")) {
			horizontalscroll(driver, grid_scroll, 300);	
			waitForElement(driver, grid_terminal_IMP_DOC);
			click(driver, grid_terminal_IMP_DOC);
			sendKeys(driver, grid_terminal_IMP_DOC , terminalCode);
		}
		
		waitForElement(driver, Select_Service_Details);
		click(driver,Select_Service_Details);
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		
		Step_End(10, "select the service and vessel details", test, test1);

		Step_Start(11, "POL Search field-based on datasheet it will set", test, test1);
		
		waitForElement(driver, POLSearch);
		if(!POL_Value.trim().equalsIgnoreCase("")) {
			click(driver, POLSearch);
			twoColumnMultipleSearchWindow(driver, POL_Search_Header, condition, POL_Value);
		}
		
		Step_End(11, "POL Search field-based on datasheet it will set", test, test1);

		Step_Start(12, "ALL ,SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);
		waitForElement(driver, slection_Label_1);
		click(driver, slection_Label_1);
		formatLocatorClick(driver, DropDown_Select, Label_Select_1);
		Step_End(12, "ALL ,SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);

		Step_Start(13, "ALL,LOCAL,TRANS-Based on the data set it will set", test, test1);
		waitForElement(driver, slection_Label_2);
		click(driver, slection_Label_2);
		formatLocatorClick(driver, DropDown_Select, Label_Select_2);
		Step_End(13, "ALL,LOCAL,TRANS-Based on the data set it will set", test, test1);

		Step_Start(14, "click the show bls button", test, test1);
		waitForElement(driver, Show_BL_Button);
		click(driver, Show_BL_Button);
		Step_End(14, "click the show bls button", test, test1);

		Step_Start(15, "saved bl's and unsaved bl's has shown for given service .(Navigate all the bl's)", test, test1);

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
		
		List<String> Expected_BL_Status=splitAndExpand(BL_Status_Check_Exp, ",");
		boolean statusCheck=true;
		List<String> UnMatched_BL_Numbers=new ArrayList<String>();
		for(int i=1;i<Endvalue;i++) {
			waitForElement(driver, BL_status_IMP_DOC);
			String BL_Status_Act=getText(driver, BL_status_IMP_DOC);
			String BL_NumberValue=getAttribute(driver, BL_Number, "value");
			if(!Expected_BL_Status.contains(BL_Status_Act)) {
				UnMatched_BL_Numbers.add(BL_NumberValue);
				statusCheck=false;
			}
		}
		
		if(statusCheck) {
			System.out.println("Matched || Expected : All the BL Number's Status should be equalt to "+BL_Status_Check_Exp+" When selected 'ALL in the dropdown || Actual : All the BL Number's Status equal to "+BL_Status_Check_Exp);
			Extent_pass_New(driver, "Matched || Expected : All the BL Number's Status should be equalt to "+BL_Status_Check_Exp+" When selected 'ALL' in the dropdown || Actual : All the BL Number's Status equal to "+BL_Status_Check_Exp, test, test1);
		}else {
			System.out.println("Not Matched || Expected : All the BL Number's Status should be equalt to "+BL_Status_Check_Exp+" When selected 'ALL' in the dropdown || Actual : Some BL Number's Status is not equal to "+BL_Status_Check_Exp+" || BL Status Mismatched BL Numbers : "+UnMatched_BL_Numbers);
			Extent_fail(driver, "Not Matched || Expected : All the BL Number's Status should be equalt to "+BL_Status_Check_Exp+" When selected 'ALL' in the dropdown || Actual : Some BL Number's Status is not equal to "+BL_Status_Check_Exp+" || BL Status Mismatched BL Numbers : "+UnMatched_BL_Numbers, test, test1);
		}
		
		Step_End(15, "saved bl's and unsaved bl's has shown for given service .(Navigate all the bl's)", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
