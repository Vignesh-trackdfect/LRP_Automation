package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC104 extends Keywords {

	public void Import_Documentation_SC104(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC104";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agency_Name = Excel_data.get("Agency_User");	
		String agency_Value = Excel_data.get("Agency_Value");
		String import_Doc_Module_Search = Excel_data.get("Import_Doc_Module_Search");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String bl_NO = Excel_data.get("BL_No");
		String expected_Cargotype_Status = Excel_data.get("Cargotype_Status");
		String expected_Popup = Excel_data.get("Expected_Popup");
		String Select_search_value_import = Excel_data.get("Select_search_value_import");
		String default_value = Excel_data.get("default_value");
		String Expected_Updated_Popup=Excel_data.get("Expected_Updated_Popup");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String do_you_want_to_delete=Excel_data.get("do_you_want_to_delete");
		String module_AgencyConfiguration = Excel_data.get("Module_AgencyConfiguration");
		String Agency_Attribute_Data=Excel_data.get("Agency_Attribute_Data");
		String Agency_Description_Data=Excel_data.get("Agency_Description_Data");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String reset = Excel_data.get("reset");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Condition = Excel_data.get("Condition");
		String pol_Value = Excel_data.get("pol_Value");
		String popup_before_Delete_Expected = Excel_data.get("popup_before_Delete_Expected");
		String Deleted_Popup_IMD = Excel_data.get("Deleted_Popup_IMD");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		
		verifyMainMenu(driver);
		
		SwitchProfile(driver, agency_Name);

	// Agency Configuration
		Extent_call(test, test1, "Step no 1 to 5 - Agency Configuration SetUp start");
		List<Boolean> newlyAdded = setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, dropdownCondition, agency_Name, Agency_Attribute_Data, Agency_Description_Data, agency_Value);
		Extent_call(test, test1, "Step no 1 to 5 - Agency Configuration SetUp End");
		
		Step_Start(6, "go the transshipment port agency ", test, test1);
		Step_Start(7, "open the import documentation module and retrieve the bl.", test, test1);

		moduleNavigate(driver, import_Doc_Module_Search);
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			waitForElement(driver, SearchButton_Toolbar );
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition, Select_search_value_import, bl_NO, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
		
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if( IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);

				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation = getText(driver, popup_Message);
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup+ " || Actual Popup was : " + NewImportDocumentation, test, test1);

				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup	+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
				}
				waitForElement(driver, popup_Message_Yes_Button );
				click(driver, popup_Message_Yes_Button);
			}
			
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

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
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				waitForElement(driver, pol_Text_field);
				twoColumnSearchWindow(driver, Pol_Header, Condition, pol_Value);

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
			
			waitForElement(driver, BL_Number);
			String Get_BL_Number = getAttribute(driver, BL_Number,"value");
			System.out.println("Get_BL_Number:"+ Get_BL_Number);

			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			waitForElement(driver, bl_input_TF);
			twoColumnSearchWindow(driver, BLNumber_Header, Condition, bl_NO);

		}
		Step_End(6, "go the transshipment port agency ", test, test1);
		Step_End(7, "open the import documentation module and retrieve the bl.", test, test1);

		Extent_call(test, test1, "Verifying the cargo status type");
		waitForElement(driver, IMD_cargotype);
		String actual_Cargo_Type_Status = getText(driver, IMD_cargotype);
		
		if(actual_Cargo_Type_Status.equals(expected_Cargotype_Status)) {
			Extent_pass_New(driver, "Matched : Expected Type -> "+expected_Cargotype_Status+" || Actual Type -> "+actual_Cargo_Type_Status, test, test1);
			System.out.println("Matched : Expected Type -> "+expected_Cargotype_Status+" || Actual Type -> "+actual_Cargo_Type_Status);
		}else {
			
			System.out.println("Not Matched : Expected Type -> "+expected_Cargotype_Status+" || Actual Type -> "+actual_Cargo_Type_Status);
			Extent_fail(driver, "Not Matched : Expected Type -> "+expected_Cargotype_Status+" || Actual Type -> "+actual_Cargo_Type_Status, test, test1);
		}
		
		scrollTop(driver);
		
		Step_Start(8, "save the import documentation.", test, test1);
			
		boolean new_flag=false;
		waitForElement(driver, SaveButton_ToolBar);
		if(isElementEnabled(driver, SaveButton_ToolBar)) {
			new_flag=true;
			jsClick(driver, SaveButton_ToolBar);
		}else {
			click(driver, Edit_Button_toolBar);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
		}
		
		Step_End(8, "save the import documentation.", test, test1);

		if(new_flag) {
		waitForPopup(driver, popup_Message, expected_Popup);
		String actual_Popup1 = getText(driver, popup_Message);
		if(actual_Popup1.equals(expected_Popup)) {
			System.out.println("Matched || Expected Popup -> "+expected_Popup+" || Actual Popup ->"+actual_Popup1 );
			System.out.println("able to save import documentation without manifest close");
			Extent_pass_New(driver,"Matched || Expected Popup -> "+expected_Popup+" || Actual Popup ->"+actual_Popup1 , test, test1);
			waitForElement(driver, popup_Message_Ok_Button);safeclick(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Popup -> "+expected_Popup+" || Actual Popup ->"+actual_Popup1 );
			Extent_fail(driver,"Not Matched || Expected Popup -> "+expected_Popup+" || Actual Popup ->"+actual_Popup1 , test, test1);
		}
		}else {
			waitForPopup(driver, popup_Message, Expected_Updated_Popup);
			String actual_Popup2 = getText(driver, popup_Message);
			if(actual_Popup2.equals(Expected_Updated_Popup)) {
				System.out.println("Matched || Expected Popup -> "+Expected_Updated_Popup+" || Actual Popup ->"+actual_Popup2 );
				System.out.println("able to save import documentation without manifest close");
				Extent_pass_New(driver,"Matched || Expected Popup -> "+Expected_Updated_Popup+" || Actual Popup ->"+actual_Popup2 , test, test1);
				waitForElement(driver, popup_Message_Ok_Button);safeclick(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup -> "+Expected_Updated_Popup+"Actual Popup ->"+actual_Popup2 );
				Extent_fail(driver,"Not Matched || Expected Popup -> "+Expected_Updated_Popup+"Actual Popup ->"+actual_Popup2 , test, test1);
			}
		}
		Step_Start(9, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		waitForDisplay(driver, NewButton_ToolBar);
		if(IsElementEnabled(driver, NewButton_ToolBar)) {
			System.out.println("Expected Result :  New button Should be Enabled || Actual Result : New Button is Enabled ");
			Extent_pass_New(driver, "Expected Result :  New button Should be Enabled || Actual Result : New Button is Enabled", test, test1);
		}else {
			System.out.println("Expected Result :  New button Should be Enabled || Actual Result : New Button is Not Enabled");
			Extent_pass_New(driver, "Expected Result :  New button Should be Enabled || Actual Result : New Button is Not Enabled", test, test1);
		}	
		// Verifying Search button is enabled
		waitForElement(driver, SearchButton_Toolbar);
		if(IsElementEnabled(driver, SearchButton_Toolbar)) {
			System.out.println("Expected Result :  Search button Should be Enabled || Actual Result : Search Button is Enabled ");
			Extent_pass_New(driver, "Expected Result :  Search button Should be Enabled || Actual Result : Search Button is Enabled", test, test1);
		}else {
			System.out.println("Expected Result :  Search button Should be Enabled || Actual Result : Search Button is Not Enabled");
			Extent_fail(driver, "Expected Result :  Search button Should be Enabled || Actual Result : Search Button is Not Enabled", test, test1);
		}	
		
		// Verifying Save button is disabled
		waitForElement(driver, SaveButton_ToolBar);
		if(!isClickable(driver, SaveButton_ToolBar)) {
			System.out.println("Expected Result :  Save button Should be disabled || Actual Result : Save Button is disabled ");
			Extent_pass_New(driver, "Expected Result :  Save button Should be disabled || Actual Result : Save Button is disabled", test, test1);
		}else {
			System.out.println("Expected Result :  Save button Should be disabled || Actual Result : Save Button is Not disabled");
			Extent_fail(driver, "Expected Result :  Save button Should be disabled || Actual Result : Save Button is Not disabled", test, test1);
		}	
		
		// Verifying Edit button is Enabled
		waitForElement(driver, Edit_Button_toolBar);
		if(isClickable(driver, Edit_Button_toolBar)) {
			System.out.println("Expected Result :  Edit button Should be Enabled || Actual Result : Edit Button is Enabled ");
			Extent_pass_New(driver, "Expected Result :  Edit button Should be Enabled || Actual Result : Edit Button is Enabled", test, test1);
		}else {
			System.out.println("Expected Result :  Edit button Should be Enabled || Actual Result : Edit Button is Not Enabled");
			Extent_fail(driver, "Expected Result :  Edit button Should be Enabled || Actual Result : Edit Button is Not Enabled", test, test1);
		}	

		// Verifying Delete button is Enabled		
		waitForElement(driver, Delete_button_toolBar);
		if(isClickable(driver, Delete_button_toolBar)) {
			System.out.println("Expected Result :  Delete button Should be Enabled || Actual Result : Delete Button is Enabled ");
			Extent_pass_New(driver, "Expected Result :  Delete button Should be Enabled || Actual Result : Delete Button is Enabled", test, test1);
		}else {
			System.out.println("Expected Result :  Delete button Should be Enabled || Actual Result : Delete Button is Not Enabled");
			Extent_fail(driver, "Expected Result :  Delete button Should be Enabled || Actual Result : Delete Button is Not Enabled", test, test1);
		}	
		Step_End(9, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);

		Step_Start(10, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(11, "click the yes and system has validate import documentation is deleted .", test, test1);

		if(do_you_want_to_delete.equalsIgnoreCase("yes")) {
			deleteImportDocument(driver, popup_before_Delete_Expected, Deleted_Popup_IMD);			
		}
		
		Step_End(10, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(11, "click the yes and system has validate import documentation is deleted .", test, test1);

		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Extent_call(test, test1, "Reset Agency Configuration");
		reSetAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, agency_Name, Agency_Description_Data, default_value, newlyAdded, reset);
		Extent_call(test, test1, "Reset Agency Configuration");
		Extent_completed(testcase_Name, test, test1);
	}
}
