package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC003 extends Keywords {

	public void Import_Invoice_SC003(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name = "TC_Import_Invoice_SC003";
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String import_Invoice_Module = Excel_data.get("import_Invoice_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String Delete_Popup_Exp = Excel_data.get("Delete_Popup_Exp");
		String Delete_Success_Msg = Excel_data.get("Delete_Success_Msg");
		String Action_By = Excel_data.get("Action_By");
		String NewButton = Excel_data.get("NewButton");
		String SearchButton = Excel_data.get("SearchButton");
		String SaveButton = Excel_data.get("SaveButton");
		String EditButton = Excel_data.get("EditButton");
		String DeleteButton = Excel_data.get("DeleteButton");
		String CancelButton = Excel_data.get("CancelButton");
		String SaveAsButton = Excel_data.get("SaveAsButton");
		String ExportButton = Excel_data.get("ExportButton");
		String PrintButton = Excel_data.get("PrintButton");
		String Move_To_First_Record_Button = Excel_data.get("Move_To_First_Record_Button");
		String Move_To_Previous_Record_Button = Excel_data.get("Move_To_Previous_Record_Button");
		String Move_To_Next_Record_Button = Excel_data.get("Move_To_Next_Record_Button");
		String Move_To_Last_Record_Button = Excel_data.get("Move_To_Last_Record_Button");

		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		// Login to the Application
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to Agency,", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to Agency,", test, test1);

		Step_Start(2, "Open Import Invoice Module", test, test1);
		moduleNavigate(driver, import_Invoice_Module);
		Step_End(2, "Open Import Invoice Module", test, test1);

		if (Action_By.equalsIgnoreCase("By Opening module")) {
			System.out.println("By Opening module");

		} else if (Action_By.equalsIgnoreCase("By Click New Button")) {
			Step_Start(3, "Click on new button", test, test1);
			System.out.println("By Click New Button");

			newButton(driver);

			Step_End(3, "Click on new button", test, test1);

		}

		else if (Action_By.equalsIgnoreCase("By Click Save Button")) {

			Step_Start(3, "Click on new button", test, test1);

			newButton(driver);

			Step_End(3, "Click on new button", test, test1);

			Step_Start(4, "Click the BL no Search and enter the BL No", test, test1);

			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

			Step_End(4, "Click the BL no Search and enter the BL No", test, test1);

			Step_Start(5, "Click on save Button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(5, "Click on save Button", test, test1);

			Step_Start(6, "Click ok in import Documentation saved validation", test, test1);

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
			Step_End(6, "Click ok in import Documentation saved validation", test, test1);

		} else if (Action_By.equalsIgnoreCase("By Click Edit Button")) {
			Step_Start(3, "Click on new button", test, test1);
			System.out.println("By Click Edit Button");

			newButton(driver);

			Step_End(3, "Click on new button", test, test1);

			Step_Start(4, "Click the BL no Search and enter the BL No", test, test1);
			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);
			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

			Step_End(4, "Click the BL no Search and enter the BL No", test, test1);

			Step_Start(5, "Click on save Button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(5, "Click on save Button", test, test1);

			Step_Start(6, "Click ok in import Documentation saved validation", test, test1);

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
			Step_End(6, "Click ok in import Documentation saved validation", test, test1);

			Step_Start(7, "then Click on Edit Button", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			Step_End(7, "then Click on Edit Button", test, test1);

		} else if (Action_By.equalsIgnoreCase("By Click Cancel Button")) {

			Step_Start(3, "Click on new button", test, test1);

			System.out.println("By Click Cancel Button");

			newButton(driver);
			Step_End(3, "Click on new button", test, test1);

			Step_Start(4, "Click the BL no Search and enter the BL No", test, test1);
			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

			Step_End(4, "Click the BL no Search and enter the BL No", test, test1);

			Step_Start(5, "Click on save Button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			Step_End(5, "Click on save Button", test, test1);

			Step_Start(6, "Click ok in import Documentation saved validation", test, test1);

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
			Step_End(6, "Click ok in import Documentation saved validation", test, test1);

			Step_Start(7, "then Click on Edit Button", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			Step_End(7, "then Click on Edit Button", test, test1);

			Step_Start(8, "Click on Cancel button", test, test1);
			waitForElement(driver, cancel_Common_btn);
			click(driver, cancel_Common_btn);
			Step_End(8, "Click on Cancel button", test, test1);

		}

		else if (Action_By.equalsIgnoreCase("By click Delete Button")) {
			Step_Start(3, "Click on new button", test, test1);
			System.out.println("By click Delete Button");
			newButton(driver);
			Step_End(3, "Click on new button", test, test1);

			Step_Start(4, "Click the BL no Search and enter the BL No", test, test1);
			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

			Step_End(4, "Click the BL no Search and enter the BL No", test, test1);

			Step_Start(5, "Click on save Button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(5, "Click on save Button", test, test1);

			Step_Start(6, "Click ok in import Documentation saved validation", test, test1);

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
			Step_Start(6, "Click ok in import Documentation saved validation", test, test1);

			Step_Start(7, "then Click on Delete Button", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(7, "then Click on Delete Button", test, test1);

			Step_Start(8, "Validation \"  Do you want to delete the Import invoice?\" then click Yes", test, test1);

			waitForPopup(driver, popup_Message, Delete_Popup_Exp);

			String Act_Delete_popText = getText(driver, popup_Message);

			if (Delete_Popup_Exp.equals(Act_Delete_popText)) {
				Extent_pass_New(driver, "Matched || Expected Delete Popup : " + Delete_Popup_Exp
						+ " || Actual Delete Popup : " + Act_Delete_popText, test, test1);
				System.out.println("Matched || Expected Delete Popup : " + Delete_Popup_Exp
						+ " || Actual Delete Popup : " + Act_Delete_popText);
			} else {
				System.out.println("Not Matched || Expected Delete Popup : " + Delete_Popup_Exp
						+ " || Actual Delete Popup : " + Act_Delete_popText);
				Extent_fail(driver, "Not Matched || Expected Delete Popup : " + Delete_Popup_Exp
						+ " || Actual Delete Popup : " + Act_Delete_popText, test, test1);
			}

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(8, "Validation \"  Do you want to delete the Import invoice?\" then click Yes", test, test1);

			Step_Start(9, "\r\n" + "Vaidation \"Import Invoice Deleted\" Click ok", test, test1);

			waitForPopup(driver, popup_Message, Delete_Success_Msg);

			String Act_Delete_Text = getText(driver, popup_Message);

			if (Delete_Success_Msg.equals(Act_Delete_Text)) {
				Extent_pass_New(driver, "Matched || Expected Delete Popup : " + Delete_Success_Msg
						+ " || Actual Delete Popup : " + Act_Delete_Text, test, test1);
				System.out.println("Matched || Expected Delete Popup : " + Delete_Success_Msg
						+ " || Actual Delete Popup : " + Act_Delete_Text);
			} else {
				System.out.println("Not Matched || Expected Delete Popup : " + Delete_Success_Msg
						+ " || Actual Delete Popup : " + Act_Delete_Text);
				Extent_fail(driver, "Not Matched || Expected Delete Popup : " + Delete_Success_Msg
						+ " || Actual Delete Popup : " + Act_Delete_Text, test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(9, "Vaidation \"Import Invoice Deleted\" Click ok", test, test1);

		}

		else if (Action_By.equalsIgnoreCase("Move_To_First_Record_Button")) {
			System.out.println("by Move_To_First_Record_Button");
			newButton(driver);

			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);

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

			waitForElement(driver, first_Common_btn);
			click(driver, first_Common_btn);

		}

		else if (Action_By.equalsIgnoreCase("Move_To_Previous_Record_Button")) {
			System.out.println("by Move_To_Previous_Record_Button");
			Step_Start(3, "Click on new button", test, test1);
			newButton(driver);
			Step_End(3, "Click on new button", test, test1);

			Step_Start(4, "Click the BL no Search and enter the BL No", test, test1);
			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

			Step_End(4, "Click the BL no Search and enter the BL No", test, test1);

			Step_Start(5, "Click on save Button", test, test1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(5, "Click on save Button", test, test1);

			Step_Start(6, "Click ok in import Documentation saved validation", test, test1);

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
			Step_End(6, "Click ok in import Documentation saved validation", test, test1);

			Step_Start(7, "Click on Move_To_Previous_Record_Button", test, test1);
			waitForElement(driver, prev_Common_btn);
			click(driver, prev_Common_btn);
			Step_End(7, "Click on Move_To_Previous_Record_Button", test, test1);

		}

		else if (Action_By.equalsIgnoreCase("Move_To_Next_Record_Button")) {
			System.out.println("by Move_To_Next_Record_Button");
			Step_Start(3, "Click on new button", test, test1);
			newButton(driver);
			Step_End(3, "Click on new button", test, test1);

			Step_Start(4, "Click the BL no Search and enter the BL No", test, test1);
			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);
			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

			Step_End(4, "Click the BL no Search and enter the BL No", test, test1);

			Step_Start(5, "Click on save Button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(5, "Click on save Button", test, test1);

			Step_Start(6, "Click ok in import Documentation saved validation", test, test1);

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
			Step_End(6, "Click ok in import Documentation saved validation", test, test1);

			Step_Start(7, "click Move_To_Next_Record_Button", test, test1);
			waitForElement(driver, next_Common_btn);
			click(driver, next_Common_btn);
			Step_End(7, "click Move_To_Next_Record_Button", test, test1);

		}

		else if (Action_By.equalsIgnoreCase("Last Record Navigation button")) {
		
			Step_Start(3, "Click on new button", test, test1);

			newButton(driver);
			
			Step_End(3, "Click on new button", test, test1);

			Step_Start(4, "Click the BL no Search and enter the BL No", test, test1);
			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

			Step_End(4, "Click the BL no Search and enter the BL No", test, test1);

			Step_Start(5, "Click on save Button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			Step_End(5, "Click on save Button", test, test1);

			Step_Start(6, "Click ok in import Documentation saved validation", test, test1);

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
			Step_End(6, "Click ok in import Documentation saved validation", test, test1);

			Step_Start(7, "click on Move_To_Last_Record_Button", test, test1);
			waitForElement(driver, last_Common_btn);
			click(driver, last_Common_btn);
			Step_End(7, "click on Move_To_Last_Record_Button", test, test1);

		}

		if (NewButton.equalsIgnoreCase("Enable")) {

			waitForElement(driver,  NewButton_ToolBar);

			if (isElementEnabled(driver, NewButton_ToolBar)) {
				System.out.println(
						"Pass || Expected result is : New button should be enabled || Actual result is : New button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : New button should be enabled || Actual result is : New button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : New button should be enabled || Actual result is : New button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : New button should be enabled || Actual result is : New button is disabled",
						test, test1);
			}
		} else if (NewButton.equalsIgnoreCase("Disable")) {

			waitForElement(driver, NewButton_ToolBar);

			if (!isElementEnabled(driver, NewButton_ToolBar)) {
				System.out.println(
						"Pass || Expected result is : New button should be disabled || Actual result is : New button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : New button should be disabled || Actual result is : New button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : New button should be disabled || Actual result is : New button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : New button should be disabled || Actual result is : New button is enabled",
						test, test1);
			}

		}

		if (SearchButton.equalsIgnoreCase("Enable")) {

			if (isElementEnabled(driver, SearchButton_Toolbar)) {
				System.out.println(
						"Pass || Expected result is : Search button should be enabled || Actual result is : Search button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Search button should be enabled || Actual result is : Search button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Search button should be enabled || Actual result is : Search button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : Search button should be enabled || Actual result is : Search button is disabled",
						test, test1);
			}

		} else if (SearchButton.equalsIgnoreCase("Disable")) {

			if (!isElementEnabled(driver, SearchButton_Toolbar)) {

				System.out.println(
						"Pass || Expected result is : Search button should be disabled || Actual result is : Search button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Search button should be disabled || Actual result is : Search button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Search button should be disabled || Actual result is : Search button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : Search button should be disabled || Actual result is : Search button is enabled",
						test, test1);
			}
		}

		if (SaveButton.equalsIgnoreCase("Enable")) {
			if (isElementEnabled(driver, SaveButton_ToolBar)) {
				System.out.println(
						"Pass || Expected result is : Save button should be enabled || Actual result is : Save button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Save button should be enabled || Actual result is : Save button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Save button should be enabled || Actual result is : Save button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : Save button should be enabled || Actual result is : Save button is disabled",
						test, test1);
			}
		} else if (SaveButton.equalsIgnoreCase("Disable")) {

			if (!isElementEnabled(driver, SaveButton_ToolBar)) {

				System.out.println(
						"Pass || Expected result is : Save button should be disabled || Actual result is : Save button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Save button should be disabled || Actual result is : Save button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Save button should be disabled || Actual result is : Save button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : Save button should be disabled || Actual result is : Save button is enabled",
						test, test1);
			}
		}

		if (EditButton.equalsIgnoreCase("Enable")) {
			if (isElementEnabled(driver, Edit_Button_toolBar)) {
				System.out.println(
						"Pass || Expected result is : Edit button should be enabled || Actual result is : Edit button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Edit button should be enabled || Actual result is : Edit button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Edit button should be enabled || Actual result is : Edit button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : Edit button should be enabled || Actual result is : Edit button is disabled",
						test, test1);
			}
		} else if (EditButton.equalsIgnoreCase("Disable")) {

			if (!isElementEnabled(driver, Edit_Button_toolBar)) {

				System.out.println(
						"Pass || Expected result is : Edit button should be disabled || Actual result is : Edit button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Edit button should be disabled || Actual result is : Edit button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Edit button should be disabled || Actual result is : Edit button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : Edit button should be disabled || Actual result is : Edit button is enabled",
						test, test1);
			}
		}

		if (DeleteButton.equalsIgnoreCase("Enable")) {

			if (isElementEnabled(driver, Delete_button_toolBar)) {
				System.out.println(
						"Pass || Expected result is : Delete button should be enabled || Actual result is : Delete button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Delete button should be enabled || Actual result is : Delete button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Delete button should be enabled || Actual result is : Delete button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : Delete button should be enabled || Actual result is : Delete button is disabled",
						test, test1);
			}
		} else if (DeleteButton.equalsIgnoreCase("Disable")) {

			if (!isElementEnabled(driver, Delete_button_toolBar)) {

				System.out.println(
						"Pass || Expected result is : Delete button should be disabled || Actual result is : Delete button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Delete button should be disabled || Actual result is : Delete button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Delete button should be disabled || Actual result is : Delete button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : Delete button should be disabled || Actual result is : Delete button is enabled",
						test, test1);
			}
		}

		if (CancelButton.equalsIgnoreCase("Enable")) {
			if (isElementEnabled(driver, cancel_Common_btn)) {
				System.out.println(
						"Pass || Expected result is : Cancel button should be enabled || Actual result is : Cancel button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Cancel button should be enabled || Actual result is : Cancel button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Cancel button should be enabled || Actual result is : Cancel button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : Cancel button should be enabled || Actual result is : Cancel button is disabled",
						test, test1);
			}
		} else if (CancelButton.equalsIgnoreCase("Disable")) {

			if (!isElementEnabled(driver, cancel_Common_btn)) {

				System.out.println(
						"Pass || Expected result is : Cancel button should be disabled || Actual result is : Cancel button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Cancel button should be disabled || Actual result is : Cancel button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Cancel button should be disabled || Actual result is : Cancel button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : Cancel button should be disabled || Actual result is : Cancel button is enabled",
						test, test1);
			}
		}

		if (SaveAsButton.equalsIgnoreCase("Enable")) {

			if (isElementEnabled(driver, SaveAs_button_toolBar)) {
				System.out.println(
						"Pass || Expected result is : SaveAs button should be enabled || Actual result is : SaveAs button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : SaveAs button should be enabled || Actual result is : SaveAs button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : SaveAs button should be enabled || Actual result is : SaveAs button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : SaveAs button should be enabled || Actual result is : SaveAs button is disabled",
						test, test1);
			}
		} else if (SaveAsButton.equalsIgnoreCase("Disable")) {

			if (!isElementEnabled(driver, SaveAs_button_toolBar)) {

				System.out.println(
						"Pass || Expected result is : SaveAs button should be disabled || Actual result is : SaveAs button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : SaveAs button should be disabled || Actual result is : SaveAs button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : SaveAs button should be disabled || Actual result is : SaveAs button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : SaveAs button should be disabled || Actual result is : SaveAs button is enabled",
						test, test1);
			}
		}

		if (ExportButton.equalsIgnoreCase("Enable")) {

			if (isElementEnabled(driver, Export_button_toolBar)) {
				System.out.println(
						"Pass || Expected result is : Export button should be enabled || Actual result is : Export button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Export button should be enabled || Actual result is : Export button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Export button should be enabled || Actual result is : Export button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : Export button should be enabled || Actual result is : Export button is disabled",
						test, test1);
			}
		} else if (ExportButton.equalsIgnoreCase("Disable")) {

			if (!isElementEnabled(driver, Export_button_toolBar)) {

				System.out.println(
						"Pass || Expected result is : Export button should be disabled || Actual result is : Export button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Export button should be disabled || Actual result is : Export button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Export button should be disabled || Actual result is : Export button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : Export button should be disabled || Actual result is : Export button is enabled",
						test, test1);
			}
		}

		if (PrintButton.equalsIgnoreCase("Enable")) {

			if (isElementEnabled(driver, print_Common_btn)) {
				System.out.println(
						"Pass || Expected result is : Print button should be enabled || Actual result is : Print button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Print button should be enabled || Actual result is : Print button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Print button should be enabled || Actual result is : Print button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : Print button should be enabled || Actual result is : Print button is disabled",
						test, test1);
			}
		} else if (PrintButton.equalsIgnoreCase("Disable")) {

			if (!isElementEnabled(driver, print_Common_btn)) {

				System.out.println(
						"Pass || Expected result is : Print button should be disabled || Actual result is : Print button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Print button should be disabled || Actual result is : Print button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Print button should be disabled || Actual result is : Print button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : Print button should be disabled || Actual result is : Print button is enabled",
						test, test1);
			}
		}

		if (Move_To_First_Record_Button.equalsIgnoreCase("Enable")) {

			if (isElementEnabled(driver, first_Common_btn)) {
				System.out.println(
						"Pass || Expected result is : Move to first button should be enabled || Actual result is : Move to first button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Move to first button should be enabled || Actual result is : Move to first button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Move to first button should be enabled || Actual result is : Move to first button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : Move to first button should be enabled || Actual result is : Move to first button is disabled",
						test, test1);
			}
		} else if (Move_To_First_Record_Button.equalsIgnoreCase("Disable")) {

			if (!isElementEnabled(driver, first_Common_btn)) {

				System.out.println(
						"Pass || Expected result is : Move to first button should be disabled || Actual result is : Move to first button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Move to first button should be disabled || Actual result is : Move to first button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Move to first button should be disabled || Actual result is : Move to first button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : Move to first button should be disabled || Actual result is : Move to first button is enabled",
						test, test1);
			}
		}

		if (Move_To_Previous_Record_Button.equalsIgnoreCase("Enable")) {

			if (isElementEnabled(driver, prev_Common_btn)) {
				System.out.println(
						"Pass || Expected result is : Move to previous button should be enabled || Actual result is : Move to previous button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Move to previous button should be enabled || Actual result is : Move to previous button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Move to previous button should be enabled || Actual result is : Move to previous button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : Move to previous button should be enabled || Actual result is : Move to previous button is disabled",
						test, test1);
			}
		} else if (Move_To_Previous_Record_Button.equalsIgnoreCase("Disable")) {

			if (!isElementEnabled(driver, prev_Common_btn)) {

				System.out.println(
						"Pass || Expected result is : Move to previous button should be disabled || Actual result is : Move to previous button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Move to previous button should be disabled || Actual result is : Move to previous button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Move to previous button should be disabled || Actual result is : Move to previous button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : Move to previous button should be disabled || Actual result is : Move to previous button is enabled",
						test, test1);
			}
		}

		if (Move_To_Next_Record_Button.equalsIgnoreCase("Enable")) {

			if (isElementEnabled(driver, next_Common_btn)) {
				System.out.println(
						"Pass || Expected result is : Move to Next button should be enabled || Actual result is : Move to Next button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Move to Next button should be enabled || Actual result is : Move to Next button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Move to Next button should be enabled || Actual result is : Move to Next button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : Move to Next button should be enabled || Actual result is : Move to Next button is disabled",
						test, test1);
			}
		} else if (Move_To_Next_Record_Button.equalsIgnoreCase("Disable")) {

			if (!isElementEnabled(driver, next_Common_btn)) {

				System.out.println(
						"Pass || Expected result is : Move to Next button should be disabled || Actual result is : Move to Next button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Move to Next button should be disabled || Actual result is : Move to Next button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Move to Next button should be disabled || Actual result is : Move to Next button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : Move to Next button should be disabled || Actual result is : Move to Next button is enabled",
						test, test1);
			}
		}

		if (Move_To_Last_Record_Button.equalsIgnoreCase("Enable")) {

			if (isElementEnabled(driver, last_Common_btn)) {
				System.out.println(
						"Pass || Expected result is : Move to Last button should be enabled || Actual result is : Move to Last button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Move to Last button should be enabled || Actual result is : Move to Last button is enabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Move to Last button should be enabled || Actual result is : Move to Last button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : Move to Last button should be enabled || Actual result is : Move to Last button is disabled",
						test, test1);
			}
		} else if (Move_To_Last_Record_Button.equalsIgnoreCase("Disable")) {
			if (!isElementEnabled(driver, last_Common_btn)) {

				System.out.println(
						"Pass || Expected result is : Move to Last button should be disabled || Actual result is : Move to Last button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : Move to Last button should be disabled || Actual result is : Move to Last button is disabled",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : Move to Last button should be disabled || Actual result is : Move to Last button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : Move to Last button should be disabled || Actual result is : Move to Last button is enabled",
						test, test1);
			} 
		}

		Extent_completed(tc_Name, test, test1);

	}

}
