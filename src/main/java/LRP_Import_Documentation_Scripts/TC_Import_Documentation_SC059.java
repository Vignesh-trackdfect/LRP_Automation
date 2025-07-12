package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC059 extends Keywords {

	public void Import_Documentation_SC059(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		//		Get data from test data
		String testcase_Name="TC_Import_Documentation_SC059";
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_ImportDocumentation=Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String savedPopup=Excel_data.get("SavedPopup");
		String globalSearch_Number = Excel_data.get("BL_Number");
		String globalSearchFilterOption_IMD=Excel_data.get("GlobalSearchFilterOption_IMD");
		String conditionFilter=Excel_data.get("ConditionFilter");
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
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String ImportDoc_Select_Type2 = Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Value2 = Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Type3 = Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value3 = Excel_data.get("ImportDoc_Select_Value3");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		
		Step_Start(1, "switch to agency ", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "switch to agency ", test, test1);

		Extent_cal(test, test1, module_ImportDocumentation);
		Step_Start(2, "Open the import documentation module", test, test1);
		
		moduleNavigate(driver, module_ImportDocumentation);
		
		Step_End(2, "open the import documentation module", test, test1);
		Step_Start(3, "load the bl in search field", test, test1);
		
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
			twoColumnSearchWindow(driver, BLNumber_Header, conditionFilter, globalSearch_Number);

		}else if(BL_Retrieve_Option.equals("By BL")) {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, globalSearch_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
		}
		
		Step_End(3, "load the bl in search field", test, test1);
		Step_End(4, "click the save in toolbar import documentation module", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
		if(actual_Master_BL_Status.equals(master_BL_Status)) {
			Extent_pass_New(driver, "Master BL is in New Status", test, test1);
			System.out.println("Master BL is in New Status");
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			Step_End(4, "click the save in toolbar import documentation module", test, test1);
			Step_Start(5, "once saved the import documentation system has validate import documentation is saved", test, test1);
			
			waitForPopup(driver, popup_Message, savedPopup);
			String ImportDocumentationSaved=getText(driver, popup_Message);
			if (savedPopup.equals(ImportDocumentationSaved)) {
				System.out.println("Matched || Expected Popup was : " + savedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + savedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,
						test1);
				waitForElement(driver, popup_Message_Ok_Button);
				safeclick(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + savedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + savedPopup + " || Actual Popup was : " + ImportDocumentationSaved,
						test, test1);
			}
		 	Step_End(5, "once saved the import documentation system has validate import documentation is saved", test, test1);
		}

		Step_Start(6, "Click the Vessel info button in Import documenation.", test, test1);
		
		waitForElement(driver, Vessel_Info_Button);
		String vesselInfo_Button_Text=getText(driver, Vessel_Info_Button);
		System.out.println("Text of the Vessel Info Button:"+vesselInfo_Button_Text);
		click(driver, Vessel_Info_Button);
	 	
		Step_End(6, "Click the Vessel info button in Import documenation.", test, test1);
		Step_Start(7, "Once clicked the vessel info button (Capture the Name) ,system has open the vessel info module.(Verify the Same name)", test, test1);

		String actual_Module_Title=getAttribute(driver, vesselInfo_Module, "title").trim();
		System.out.println("Vessel Info Module Text:"+actual_Module_Title);
	    
		Extent_cal(test, test1, actual_Module_Title);

		waitForDisplay(driver, vesselInfo_Module);
		if(isDisplayed(driver, vesselInfo_Module)) {
			Extent_pass_New(driver, "Expected : Vessel info Module Should Open || Actual :Vessel info Module is opened  ", test, test1);
			System.out.println( "Expected : Vessel info Module Should Open || Actual :Vessel info Module is opened ");
		}else {
			System.out.println("Expected : Vessel info Module Should Open || Actual :Vessel info Module is not opened ");
			Extent_fail(driver, "Expected : Vessel info Module Should Open || Actual :Vessel info Module is not opened ", test, test1);
		}
	 	
	     if (actual_Module_Title.contains(vesselInfo_Button_Text)) {
				System.out.println("Matched || Text of the Vessel Info Button : " + vesselInfo_Button_Text + " ||Vessel Info Module Text: " + actual_Module_Title);
				Extent_pass_New(driver, "Matched ||Text of the Vessel Info Button: " + vesselInfo_Button_Text + " ||Vessel Info Module Text: " + actual_Module_Title, test,
						test1);
	     } else {
				System.out.println("NotMatched || Text of the Vessel Info Button: " + vesselInfo_Button_Text + " ||Vessel Info Module Text : " + actual_Module_Title);
				Extent_fail(driver, "NotMatched ||Text of the Vessel Info Button: " + vesselInfo_Button_Text + " ||Vessel Info Module Text : " + actual_Module_Title,
						test, test1);
	     }
	    
		Step_End(7, "Once clicked the vessel info button (Capture the Name) ,system has open the vessel info module.(Verify the Same name)", test, test1);
		Step_Start(8, "Switch to the import documentation", test, test1);
		scrollTop(driver);
		 waitForElement(driver, Close_Current_tab);
	     click(driver, Close_Current_tab);
		Step_End(8, "Switch to the import documentation", test, test1);
		
		Step_Start(9, "Click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(10, "Click the yes and system has validate import dcoumentation is deleted ", test, test1);

		if(wantToDelete.equalsIgnoreCase("Yes")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		
		Step_End(9, "Click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(10, "Click the yes and system has validate import dcoumentation is deleted ", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}	
}
