package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC045 extends Keywords {

	public void Import_Documentation_SC045(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
	
		String testcase_Name="TC_Import_Documentation_SC045";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String DropdownCondition1 = Excel_data.get("DropdownCondition1");
		String bl_Number = Excel_data.get("bl_Number");
		String SavedPopup = Excel_data.get("SavedPopup");
		String remove_pop_exp = Excel_data.get("Remove_pop");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String Charge_code_values=Excel_data.get("Charge_code_values");
		String multiple_remove_popup=Excel_data.get("multiple_remove_popup");
		String delete_confirmation_popup = Excel_data.get("delete_confirmation_popup");
		String deleted_popup_expected = Excel_data.get("deleted_popup_expected").trim();
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String condition=Excel_data.get("condition");
		String do_you_want_to_delete = Excel_data.get("do_you_want_to_delete");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String pol_Value=Excel_data.get("pol_Value");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		Extent_cal(test, test1, "Checking the visibility of Main menu");
		verifyMainMenu(driver);

		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		
		Extent_call(test, test1, "********** Switch the Profile - End **********");	
		Extent_call(test, test1, "********** Enter Import Documentation Module **********");
	
		
		Step_Start(1, "open the Import Documentation Retrive the new  bill using tool bar search", test, test1);
		
		moduleNavigate(driver, ImportDocumentationModule);
		
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
		
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, DropdownCondition1, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			
			newButton(driver);
			
			waitForElement(driver, ServiceInput_IMD );
			sendKeys(driver, ServiceInput_IMD , first_service_data);
			
			if(!Vessels.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC ,Vessels);
			}
			
			if(!Voyagenumber1.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC , Voyagenumber1);
			}
			if(!Boundinput.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Boundinput);
			}

			if(!portCode.trim().equals("")) {
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC , portCode);
			}

			if(!terminalCode.trim().equals("")) {
				horizontalscroll(driver, grid_scroll, 300);		
				click(driver, grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC , terminalCode);
			}
			
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			
			scrollTop(driver);
			scrollTop(driver);
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, condition, pol_Value);
			}
			
			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			
			waitForElement(driver, select_Option_1);
			click(driver, select_Option_1);
			
			waitForElement(driver, slection_Label_2);
			click(driver, slection_Label_2);
			
			waitForElement(driver, select_Option_2);
			click(driver, select_Option_2);
			
			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);
			
			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);
			
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, condition, bl_Number);	
		}
		Step_End(1, "open the Import Documentation Retrive the new  bill using tool bar search", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (!house_BL_Status.equalsIgnoreCase("NEW")) {
			System.out.println("Expected : Given BL should be in 'NEW' Status || Actual : Given BL is not in 'NEW' Mode ");
			Extent_FailNew(driver, "Expected : Given BL should be in 'NEW' Status || Actual : Given BL is not in 'NEW' Mode ", test, test1);
		}else {
			System.out.println("Expected : Given BL should be in 'NEW' Status || Actual : Given BL is in 'NEW' Mode");
			Extent_pass_New(driver, "Expected : Given BL should be in 'NEW' Status || Actual : Given BL is in 'NEW' Mode", test, test1);
		}
		Step_Start(2, "after retrive the bl,go to the charge tab.", test, test1);
		
		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);
		scrollBottom(driver);
		Step_End(2, "after retrive the bl,go to the charge tab.", test, test1);
		
		Step_Start(3, "select the agency charge code .same as another charge code based on the data sheet", test, test1);

		Actions actions=new Actions(driver);
		actions.keyDown(Keys.CONTROL).build().perform();
		List<String> Charge_code_text = splitAndExpand(Charge_code_values);
		for(int i=0;i<Charge_code_text.size();i++) {
			 String chargeCode = Charge_code_text.get(i);
			 String Charges_row = String.format(Charges_row_with_text, chargeCode);
			 click(driver, Charges_row);			
		}
        actions.keyUp(Keys.CONTROL).build().perform();

		Step_End(3, "select the agency charge code .same as another charge code based on the data sheet", test, test1);

        scrollTop(driver);
    	Step_Start(4, "click the remove button .", test, test1);

		waitForElement(driver, collect_charges_remove_IMP_DOC);
		click(driver, collect_charges_remove_IMP_DOC);
		
		Step_End(4, "click the remove button .", test, test1);

		Step_Start(5, "system has validate Do you want to remove the row? yes or no", test, test1);
		waitForPopup(driver, popup_Message, remove_pop_exp);
		
		if(Charge_code_text.size() == 1) {
			String remove_pop_Act= getText(driver, popup_Message);
			if(remove_pop_exp.equals(remove_pop_Act)) {
				System.out.println("Matched || Expected Popup was : " + remove_pop_exp + " || Actual Popup was : " + remove_pop_Act);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + remove_pop_exp + " || Actual Popup was : " + remove_pop_Act, test,test1);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + remove_pop_exp + " || Actual Popup was : " + remove_pop_Act);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + remove_pop_exp + " || Actual Popup was : " + remove_pop_Act,test, test1);
			}
		}else {
			String remove_pop_Act= getText(driver, popup_Message);
			if(multiple_remove_popup.equals(remove_pop_Act)) {
				System.out.println("Matched || Expected Popup was : " + multiple_remove_popup + " || Actual Popup was : " + remove_pop_Act);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + multiple_remove_popup + " || Actual Popup was : " + remove_pop_Act, test,test1);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + multiple_remove_popup + " || Actual Popup was : " + remove_pop_Act);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + multiple_remove_popup + " || Actual Popup was : " + remove_pop_Act,test, test1);
			}
		}
		Step_End(5, "system has validate Do you want to remove the row? yes or no", test, test1);

		Step_Start(6, "click the yes button ..", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		
		Step_End(6, "click the yes button ..", test, test1);
		
		Step_Start(7, "selected charge code has removed in the below grid.", test, test1);
		waitForElement(driver, Charges_table_headers);
		mouseOverToElement(driver, Charges_table_headers);
		List<Map<String, String>> charges_tabledata = getTableData(driver, Charges_table_headers, Charges_table_rows);
		List<String> Charge_code_column = getValuesByHeader(charges_tabledata, "Charge Code");
		
		for(String Charge_code_value:Charge_code_column) {
			if(Charge_code_text.contains(Charge_code_value)) {
				System.out.println("Failed || Expected : The removed charges code Should not present || Actual : The removed charges code still present : "+ Charge_code_value);
				Extent_fail(driver, "Failed || Expected : The removed charges code Should not present || Actual : The removed charges code still present : "+ Charge_code_value, test, test1);
			}
		}
		Step_End(7, "selected charge code has removed in the below grid.", test, test1);

		Step_Start(8, "save the import documentation.", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		Step_End(8, "save the import documentation.", test, test1);

		Step_Start(9, "once saved the import documentation system has validate import documentation is saved.", test, test1);

		waitForPopup(driver, popup_Message, SavedPopup);
		String BL_StatusValue= getText(driver, popup_Message);
		if(BL_StatusValue.equals(SavedPopup)) {
			System.out.println("Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + SavedPopup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + SavedPopup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + SavedPopup);
			Extent_fail(driver, "Not Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + SavedPopup,test, test1);
		}	
		
		Step_End(9, "once saved the import documentation system has validate import documentation is saved.", test, test1);

		Step_Start(10, "once saved the import documentation new ,search,edit and delete icon has shown in tool bar", test, test1);
		waitForDisplay(driver, NewButton_ToolBar);
		if(isdisplayed(driver, NewButton_ToolBar)) {
			System.out.println("Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is not displayed in the Toolbar", test, test1);
		}
		
		if(isdisplayed(driver, SearchButton_Toolbar)) {
			System.out.println("Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is not displayed in the Toolbar", test, test1);
		}
		
		if(isdisplayed(driver, Edit_Button_toolBar)) {
			System.out.println("Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is not displayed in the Toolbar", test, test1);
		}
		
	    if(isdisplayed(driver, Delete_button_toolBar)) {
	    	System.out.println("Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is not displayed in the Toolbar", test, test1);
		}

		Step_End(10, "once saved the import documentation new ,search,edit and delete icon has shown in tool bar", test, test1);
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_Start(11, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(12, "click the yes and system has validate import dcoumentation is deleted .", test, test1);

		if(do_you_want_to_delete.equalsIgnoreCase("Yes")) {
			deleteImportDocument(driver, delete_confirmation_popup, deleted_popup_expected);
		}
		Step_End(11, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(12, "click the yes and system has validate import dcoumentation is deleted .", test, test1);

		Extent_completed(testcase_Name, test, test1);
		//
	
	}
}




