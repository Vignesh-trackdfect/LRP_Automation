package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC012 extends Keywords {

	public void Import_Documentation_SC012(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Import_Documentation_SC012";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Module_Search = Excel_data.get("Module_Search");	
		String NewImportDocumentationPopup= Excel_data.get("NewImportDocumentationPopup");	
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String Module2 = Excel_data.get("Module2");
		String POL_Value= Excel_data.get("POL_Value");	
		String Label_Select_1= Excel_data.get("Label_Select_1");	
		String Label_Select_2= Excel_data.get("Label_Select_2");	
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition");
		String bl_Number=Excel_data.get("BL_Number");

		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		
		String condition_filter=Excel_data.get("condition_filter");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header =  Excel_data.get("BL_Number_Header");

		String BOL_Select_Type1=Excel_data.get("BOL_Select_Type1");
		String BOL_Select_Type2=Excel_data.get("BOL_Select_Type2");
		String BOL_Select_Value2=Excel_data.get("BOL_Select_Value2");
		String BOL_Select_Type3=Excel_data.get("BOL_Select_Type3");
		String BOL_Select_Value3=Excel_data.get("BOL_Select_Value3");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");

		String MCN_Module = Excel_data.get("MCN_Module");
		String Select_Search_Type_MCN = Excel_data.get("Select_Search_Type_MCN");
		String MCN_Select_Type2=Excel_data.get("MCN_Select_Type2");
		String MCN_Select_Value2=Excel_data.get("MCN_Select_Value2");
		String MCN_Select_Type3=Excel_data.get("MCN_Select_Type3");
		String MCN_Select_Value3=Excel_data.get("MCN_Select_Value3");
	
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);
		//login
		LRP_Login(driver, Username, Password);
		
		Extent_cal(test, test1, "Checking the visibility of Main menu");
		verifyMainMenu(driver);
		
		//
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency", test, test1);

		Step_Start(2, "open the import documentation module", test, test1);
		moduleNavigate(driver, Module_Search);
		Step_End(2, "open the import documentation module", test, test1);
		
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
		
			Step_Start(3, "Load the BL in search field ", test, test1);
		
			waitForElement(driver, SearchButton_Toolbar );
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

			Step_End(3, "Load the BL in search field ", test, test1);
			Step_Start(4, "All datas has to be shown ", test, test1);
			
			waitForElement(driver, BL_status_IMP_DOC);
			String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
			if (!house_BL_Status.equalsIgnoreCase("NEW")) {
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
			}
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
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

			Step_Start(8, "Enter the valid service", test, test1);
			
			waitForElement(driver, ServiceInput_IMD );
			sendKeys(driver, ServiceInput_IMD , first_service_data);
			
			Step_End(8, "Enter the valid service", test, test1);

			Step_Start(9, "Populate the vessel details based on the provided service", test, test1);
			if(!Vessels.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC );
				sendKeys(driver, grid_vesselcode_IMP_DOC ,Vessels);
			}
			
			Step_End(9, "Populate the vessel details based on the provided service", test, test1);

			Step_Start(10, "Select the service and vessel details", test, test1);
			if(!Voyagenumber1.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC );
				sendKeys(driver, grid_voyagecode_IMP_DOC , Voyagenumber1);
			}
			
			if(!Boundinput.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC );
				sendKeys(driver, grid_bound_IMP_DOC, Boundinput);
			}
			
			if(!portCode.trim().equals("")) {
				waitForElement(driver, grid_portcodeIMP_DOC );
				sendKeys(driver, grid_portcodeIMP_DOC , portCode);
			}
			
			if(!terminalCode.trim().equals("")) {
				horizontalscroll(driver, grid_scroll, 300);		
				waitForElement(driver, grid_terminal_IMP_DOC );
				click(driver, grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC , terminalCode);
			}
			
			waitForElement(driver, Select_Service_Details);
			click(driver,Select_Service_Details);
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			
			Step_End(10, "Select the service and vessel details", test, test1);

			Step_Start(11, "POL Search field-based on datasheet it will set", test, test1);
			waitForElement(driver, POLSearch);

			if(!POL_Value.trim().equalsIgnoreCase("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, condition_filter, POL_Value);
			}
			Step_End(11, "POL Search field-based on datasheet it will set", test, test1);

			Step_Start(12, "ALL, SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);
			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			String label1=String.format(selection_label_1_option, Label_Select_1);
			waitForElement(driver, label1);
			click(driver, label1);
			Step_End(12, "ALL, SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);

			Step_Start(13, "ALL, LOCAL, TRANS-Based on the data set it will set", test, test1);
			
			waitForElement(driver, slection_Label_2);
			click(driver, slection_Label_2);
			String label2=String.format(selection_label_2_option, Label_Select_2);
			waitForElement(driver, label2);
			click(driver, label2);
			
			Step_End(13, "ALL, LOCAL, TRANS-Based on the data set it will set", test, test1);

			Step_Start(14, "Click the Show BL's button", test, test1);
			
			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);
			
			Step_End(14, "Click the Show BL's button", test, test1);

			Step_Start(15, "The respective service and vessel-based BL's will be shown in the import documentation module.-retrieve the bill", test, test1);
			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);

			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			
			twoColumnSearchWindow(driver,BL_Number_Header,condition_filter,bl_Number);
			
			waitForElement(driver, BL_Number);
			String Get_BL_Number = getAttribute(driver, BL_Number,"value");
			System.out.println("Get_BL_Number:"+ Get_BL_Number);
			if(Get_BL_Number.equals(bl_Number)) {
				System.out.println("Matched : Expected BL Number in Import Document : "+bl_Number+" || Actual BL Number in import Document : "+Get_BL_Number);
				Extent_pass_New(driver, "Matched : Expected BL Number in Import Document : "+bl_Number+" || Actual BL Number in import Document : "+Get_BL_Number, test, test1);
			}else {
				System.out.println("Not Matched : Expected BL Number in Import Document : "+bl_Number+" || Actual BL Number in import Document : "+Get_BL_Number);
				Extent_fail(driver, "Not Matched : Expected BL Number in Import Document : "+bl_Number+" || Actual BL Number in import Document : "+Get_BL_Number, test, test1);
			}
			Step_End(15, "The respective service and vessel-based BL's will be shown in the import documentation module.-retrieve the bill", test, test1);

		}
		
		Step_Start(16, "system bl type field value has to be shown", test, test1);
		waitForElement(driver, System_Bl_type);
		String System_BL_type_Import_Doc=getText(driver, System_Bl_type);
		
		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver,BL_HBL_Summary_Tab);
		waitForElement(driver, MCN_Text_Field_IMPORT_DOC);
		String MCN_Number = getAttribute(driver, MCN_Text_Field_IMPORT_DOC, "value");
		Step_End(16, "system bl type field value has to be shown", test, test1);

		
		if(MCN_Number.equals("")) {
			
			Step_Start(17, "open the bill of lading module", test, test1);
			moduleNavigate(driver, Module2);
			
			Step_End(17, "open the bill of lading module", test, test1);

			Step_Start(18, "load the bill in bill of lading module", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, BOL_Select_Type1, bl_Number, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOL_Select_Value3);
			
			Step_End(18, "load the bill in bill of lading module", test, test1);

			Step_Start(19, "system bl type field value match with import doc and bill of lading module", test, test1);
			
			waitForElement(driver, System_Bl_type1_value);
			String System_BL_type_BOL=getAttribute(driver, System_Bl_type1_value, "value");
			if (System_BL_type_Import_Doc.equals(System_BL_type_BOL)) {
				System.out.println("Matched || Expected System BL Type in Import Documentation : " + System_BL_type_Import_Doc + " || Actual System BL Type in Bill Of Lading : " + System_BL_type_BOL);
				Extent_pass_New(driver, "Matched || Expected System BL Type in Import Documentation : " + System_BL_type_Import_Doc + " || Actual System BL Type Bill Of Lading : " + System_BL_type_BOL, test,
						test1);
			} else {
				System.out.println("Not Matched || Expected System BL Type in Import Documentation : " + System_BL_type_Import_Doc + " || Actual System BL Type Bill Of Lading : " + System_BL_type_BOL);
				Extent_fail(driver, "Not Matched || Expected System BL Type in Import Documentation : " + System_BL_type_Import_Doc + " || Actual System BL Type Bill Of Lading : " + System_BL_type_BOL,
						test, test1);
			}
			
		}else {
			Step_Start(17, "open the MCN module", test, test1);
			scrollTop(driver);
			moduleNavigate(driver, MCN_Module);
			Step_End(17, "open the MCN module", test, test1);

			Step_Start(18, "load the bill in MCN module", test, test1);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_MCN, MCN_Number, MCN_Select_Type2, MCN_Select_Value2, MCN_Select_Type3, MCN_Select_Value3);
			Step_End(18, "load the bill in MCN module", test, test1);

			Step_Start(19, "system bl type field value match with import doc and MCN module", test, test1);
			waitForElement(driver, System_BL_Type_Input_MCN);
			String BL_Type_Value_MCN=getAttribute(driver, System_BL_Type_Input_MCN,"value");
			
			if (System_BL_type_Import_Doc.equals(BL_Type_Value_MCN)) {
				System.out.println("Matched || Expected System BL Type in Import Documentation : " + System_BL_type_Import_Doc + " || Actual System BL Type in MCN Module : " + BL_Type_Value_MCN);
				Extent_pass_New(driver, "Matched || Expected System BL Type in Import Documentation : " + System_BL_type_Import_Doc + " || Actual System BL Type in MCN Module : " + BL_Type_Value_MCN, test,
						test1);
			} else {
				System.out.println("Not Matched || Expected System BL Type in Import Documentation : " + System_BL_type_Import_Doc + " || Actual System BL Type in MCN Module : " + BL_Type_Value_MCN);
				Extent_fail(driver, "Not Matched || Expected System BL Type in Import Documentation : " + System_BL_type_Import_Doc + " || Actual System BL Type in MCN Module : " + BL_Type_Value_MCN,
						test, test1);
			}
			Step_End(19, "system bl type field value match with import doc and MCN module", test, test1);
		}

		Extent_completed(testCaseName, test, test1);
		
	}
}