package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC006 extends Keywords {

	public void Import_Invoice_SC006(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC006";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String BL_Condition = Excel_data.get("BL_Condition");
		String No_records_pop = Excel_data.get("No_records_pop");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String IMPDOCStatus = Excel_data.get("IMPDOCStatus");
		String Import_Invoice_search_value = Excel_data.get("Import_Invoice_search_value");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal");
		String pol_Value = Excel_data.get("pol_Value"); 
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String Select_Search_Type_Import_Doc = Excel_data.get("Select_Search_Type_Import_Doc");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String POL_Header = Excel_data.get("POL_Header");
		

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		verifyMainMenu(driver);

		Step_End(1, "switch to import agency", test, test1);

		Step_Start(2, "open the import documentation module", test, test1);

		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(2, "open the import documentation module", test, test1);

		Step_Start(3,
				"retrieve the bl in tool bar -bl has not  saved.In Case if it is saved delete the Import Documentation and go to step4",
				test, test1);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {

			waitForDisplay(driver, NewButton_ToolBar);

			if (isdisplayed(driver, NewButton_ToolBar) && IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);

				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);

				String NewImportDocumentation = getText(driver, popup_Message).trim();
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected value was : " + NewImportDocumentationPopup
							+ " || Actual value was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected value was : " + NewImportDocumentationPopup
							+ " || Actual value was : " + NewImportDocumentation, test, test1);
					safeclick(driver, popup_Message_Yes_Button);
				} else {
					System.out.println("NotMatched || Expected value was : " + NewImportDocumentationPopup
							+ " || Actual value was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected value was : " + NewImportDocumentationPopup
							+ " || Actual value was : " + NewImportDocumentation, test, test1);
				}
			}

			waitForDisplay(driver, cancel_Common_btn);
			if (isClickable(driver, cancel_Common_btn)) {
				click(driver, cancel_Common_btn);
			}

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, BL_Number_input, "", "",
					"", "");

		

		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if (isdisplayed(driver, NewButton_ToolBar) && IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				if (isdisplayed(driver, popup_Message_Yes_Button)) {

					waitForPopup(driver, popup_Message, NewImportDocumentationPopup);

					String NewImportDocumentation = getText(driver, popup_Message).trim();
					if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
						System.out.println("Matched || Expected value was : " + NewImportDocumentationPopup
								+ " || Actual value was : " + NewImportDocumentation);
						Extent_pass_New(driver, "Matched || Expected value was : " + NewImportDocumentationPopup
								+ " || Actual value was : " + NewImportDocumentation, test, test1);
						safeclick(driver, popup_Message_Yes_Button);
					} else {
						System.out.println("NotMatched || Expected value was : " + NewImportDocumentationPopup
								+ " || Actual value was : " + NewImportDocumentation);
						Extent_fail(driver, "NotMatched || Expected value was : " + NewImportDocumentationPopup
								+ " || Actual value was : " + NewImportDocumentation, test, test1);
					}
				}
			}
			waitForElement(driver, ID_servicename);
			sendKeys(driver, ID_servicename, Service);

			if (!Vessel.equals("")) {
				waitForElement(driver, ID_grid_vesselcode);
				sendKeys(driver, ID_grid_vesselcode, Vessel);
			}
			if (!Voyage.equals("")) {
				sendKeys(driver, ID_grid_voyagecode, Voyage);
			}
			if (!Bound.equals("")) {
				sendKeys(driver, ID_grid_bound, Bound);
			}
			if (!Port.equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				sendKeys(driver, ID_grid_portcode, Port);
			}
			if (!Terminal.equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 500);
				click1(driver, ID_grid_terminal);
				sendKeys(driver, ID_grid_terminal, Terminal);
			}

			
			

			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			click(driver, ID_grid_selectbtn);

			if (!pol_Value.equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnSearchWindow(driver, POL_Header, Condition_Filter, pol_Value);
			}

			scrollTop(driver);

			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			click(driver, select_Option_1);
			click(driver, slection_Label_2);
			click(driver, select_Option_2);
			click(driver, Show_BL_Button);

			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);

			waitForElement(driver, BlNoSearchButton);
			click(driver, BlNoSearchButton);

			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, BL_Number_input);

		
		}
		
		
		waitForElement(driver, BL_status_IMP_DOC);
		String BL_status = getText(driver, BL_status_IMP_DOC);
		System.out.println(BL_status);
		if (IMPDOCStatus.equals(BL_status)) {
			Extent_pass_New(driver, "Matched || Expected BL Status : " + IMPDOCStatus
					+ " || Actual BL Status from Import Documentaion : " + BL_status, test, test1);
			System.out.println("Matched || Expected BL Status : " + IMPDOCStatus
					+ " || Actual BL Status from Import Documentaion : " + BL_status);
		} else {
			System.out.println("Not Matched || Expected BL Status : " + IMPDOCStatus
					+ " || Actual BL Status from Import Documentaion : " + BL_status);

		}
		
		Step_End(3,
				"retrieve the bl in tool bar -bl has not  saved.In Case if it is saved delete the Import Documentation and go to step4",
				test, test1);

		Step_Start(4, "open the import invoice module", test, test1);

		moduleNavigate(driver, Field_Names);

		Step_End(4, "open the import invoice module", test, test1);

		Step_Start(5, "click the new button", test, test1);

		newButton(driver);

		Step_End(5, "click the new button", test, test1);

		Step_Start(6, "retrieve the bl in bl number search field", test, test1);

		waitForElement(driver, import_invoice_bl_search);
		click(driver, import_invoice_bl_search);

		globalValueSearchWindow1(driver, BL_Condition, Import_Invoice_search_value, BL_Number_input, "", "", "", "");

		Step_End(7, "click the search", test, test1);
		Step_Start(8, "Verify that system has validate No records found", test, test1);

		waitForPopup(driver, Popup_Message, No_records_pop);

		String norecordsPopupact = getText(driver, Popup_Message);
		System.out.println(norecordsPopupact);

		if (No_records_pop.equals(norecordsPopupact)) {
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + No_records_pop + " || Actual Popup : " + norecordsPopupact, test,
					test1);
			System.out.println(
					"Matched || Expected Popup : " + No_records_pop + " || Actual Popup : " + norecordsPopupact);
		} else {
			System.out.println(
					"Not Matched || Expected Popup : " + No_records_pop + " || Actual Popup : " + norecordsPopupact);
			Extent_fail(driver,
					"Not Matched || Expected Popup : " + No_records_pop + " || Actual Popup : " + norecordsPopupact,
					test, test1);
		}

		Step_End(8, "Verify that system has validate No records found", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
