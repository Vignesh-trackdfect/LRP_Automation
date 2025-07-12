package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC005A extends Keywords {
	
	public void Import_Invoice_SC005A(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC005A";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Retrive_Option = Excel_data.get("Import_Doc_BL_Retrive_Option");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String Select_Search_Type_Import_Doc = Excel_data.get("Select_Search_Type_Import_Doc");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String BL_Num = Excel_data.get("BL_Num");
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
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String Import_invoice_delete = Excel_data.get("Import_invoice_delete");
		String pol_Value1 = Excel_data.get("POL_HEADER");
		String BL_Number = Excel_data.get("BL_Number");

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Switch to agency", test, test1);

		Step_Start(2, "open the import documentation module", test, test1);

		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(2, "open the import documentation module", test, test1);
		Step_Start(3, "retrieve the bl in tool bar -bl has saved in import documentation", test, test1);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			Extent_call(test, test1, "Import Documentation retrived by BL");
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


			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, BL_Num, "", "", "", "");
			

		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			Extent_call(test, test1, "Import Documentation retrived by Service");
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

			scrollTop(driver);
			if (!pol_Value.equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnSearchWindow(driver, pol_Value1, Condition_Filter, pol_Value);
			}

			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			click(driver, select_Option_1);
			click(driver, slection_Label_2);
			click(driver, select_Option_2);
			click(driver, Show_BL_Button);

	
			waitForElement(driver, BlNoSearchButton);
			click(driver, BlNoSearchButton);

			twoColumnSearchWindow(driver, BL_Number, Condition_Filter, BL_Num);

		}
		
		waitForDisplay(driver, bl_saved);
		if (isdisplayed(driver, bl_saved)) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

		} else {

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}
		waitForElement(driver, Edit_Button_toolBar);
		if (isClickable(driver, Edit_Button_toolBar)) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
		}
		
		
		waitForElement(driver, importInvoice_Button);
		if(isElementEnabled(driver, importInvoice_Button)) {
			System.out.println("Expected Result is : Import Invoice Button Should be Enabled || Actual Result is : Import Invoice Button is Enabled");
			Extent_pass_New(driver, "Expected Result is : Import Invoice Button Should be Enabled || Actual Result is : Import Invoice Button is Enabled", test, test1);
		}else {
			System.out.println("Expected Result is : Import Invoice Button Should be Enabled || Actual Result is : Import Invoice Button is not Enabled");
             Extent_fail(driver, "Expected Result is : Import Invoice Button Should be Enabled || Actual Result is : Import Invoice Button is not Enabled", test, test1);
		}
		
		Step_End(3, "retrieve the bl in tool bar -bl has saved in import documentation", test, test1);

		Step_Start(4,
				"Navigate from Import Documentation Verify that same BL Number has to show in import invoice module Save the Import Invoice",
				test, test1);

			Extent_call(test, test1, "Import was navigate from Import Documentation");

			waitForElement(driver, importInvoice_Button);
			click(driver, importInvoice_Button);
			waitForElement(driver, by_Bl_Number_Txtfield);
			String Bl_number_import_invoice = getAttribute(driver, by_Bl_Number_Txtfield, "value");
			System.out.println(Bl_number_import_invoice);

			if (BL_Num.equals(Bl_number_import_invoice)) {
				System.out.println("Matched || Expected value shown in import documentation : " + BL_Num
						+ " || Actual value shown in import invoice : " + Bl_number_import_invoice);
				Extent_pass_New(driver,
						"Matched || Expected value shown in import documentation : " + BL_Num
								+ " || Actual value shown in import invoice : " + Bl_number_import_invoice,
						test, test1);

			} else {
				System.out.println("NotMatched || Expected value shown in import documentation : " + BL_Num
						+ " || Actual value shown in import invoice : " + Bl_number_import_invoice);
				Extent_fail(driver,
						"NotMatched || Expected value shown in import documentation : " + BL_Num
								+ " || Actual value shown in import invoice : " + Bl_number_import_invoice,
						test, test1);
			}

			waitForElement(driver, import_invoice_draft_button);
			click(driver, import_invoice_draft_button);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Draft_saved_pop);

			String import_saved_act = getText(driver, popup_Message);
			System.out.println(import_saved_act);

			if (Draft_saved_pop.equals(import_saved_act)) {
				System.out.println(
						"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act,
						test, test1);

			} else {
				System.out.println("Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
						+ import_saved_act);

				Extent_fail(driver,
						"Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act,
						test, test1);

			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		
		Step_End(4,
				"Navigate from Import Documentation Verify that same BL Number has to show in import invoice module Save the Import Invoice",
				test, test1);

		Step_Start(5, "Open Import Invoice module Directly and load the BL and Check open the import invoice module",
				test, test1);


		Step_End(9, "Verify that same BL Number has to show in import invoice module Save the Import Invoice", test,
				test1);


	
		Step_Start(16, "Delete the invoice Steps, has to follow.", test, test1);
	
		Import_Invoice_Draft_Delete(driver, Import_invoice_delete);
		
		
		Step_End(16, "Delete the invoice Steps, has to follow.", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
