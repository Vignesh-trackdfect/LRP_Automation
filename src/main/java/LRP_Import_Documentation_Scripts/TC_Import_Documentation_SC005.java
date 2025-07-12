package LRP_Import_Documentation_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Import_Documentation_SC005 extends Keywords{
	public void Import_Documentation_SC005(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testCaseName="TC_Import_Documentation_SC005";

		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String AgencyUser =Excel_data.get("AgencyUser");
		String moduleImportDoc = Excel_data.get("moduleImportDoc");
		String Service = Excel_data.get("Service");
		String Delete_perform = Excel_data.get("Delete_perform");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String BillofLading_Module = Excel_data.get("BillofLading_Module");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup").trim();
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String pol_Value = Excel_data.get("pol_Value");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String BL_Number = Excel_data.get("BL_Number");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Port = Excel_data.get("Port");
		String Select_Search_Type_BOL = Excel_data.get("Select_Search_Type_BOL");
		String MCN_Module = Excel_data.get("MCN_Module");
		String Select_Search_Type_MCN = Excel_data.get("Select_Search_Type_MCN");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String BOL_Select_Type2=Excel_data.get("BOL_Select_Type2");
		String BOL_Select_Value2=Excel_data.get("BOL_Select_Value2");
		String BOL_Select_Type3=Excel_data.get("BOL_Select_Type3");
		String BOL_Select_Value3=Excel_data.get("BOL_Select_Value3");
		String MCN_Select_Type2=Excel_data.get("MCN_Select_Type2");
		String MCN_Select_Value2=Excel_data.get("MCN_Select_Value2");
		String MCN_Select_Type3=Excel_data.get("MCN_Select_Type3");
		String MCN_Select_Value3=Excel_data.get("MCN_Select_Value3");

		String Delete_Confirmation_Popup=Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup=Excel_data.get("Delete_Success_Popup");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
	
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver,url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
//		Switch the Profile
		Step_Start(1, "Switch to agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency.", test, test1);
		
		Step_Start(2, "Open the import documentation module.", test, test1);
		moduleNavigate(driver, moduleImportDoc);
		Step_End(2, "Open the import documentation module.", test, test1);
		
		//Vignesh-> As discussed with Suresh on 16_04_2025, I have Removed the (Step 3) Codes for validating all the Toolbar functions accessiblity
		
		Step_Start(4, "Click the Home button.", test, test1);		
		waitForDisplay(driver, NewButton_ToolBar);
		if(IsElementEnabled(driver, NewButton_ToolBar)) {
			click(driver, NewButton_ToolBar);
			Step_End(4, "Click the Home button.", test, test1);
			Step_Start(5,"The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.",
					test, test1);

			waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
			String new_import_documentation = getText(driver, popup_Message);
			if (new_import_documentation.equals(NewImportDocumentationPopup)) {
				System.out.println("Matched || Expected Pop up : " + NewImportDocumentationPopup + " || Actual Pop up : "
						+ new_import_documentation);
				Extent_pass_New(driver, "Matched || Expected Pop up : " + NewImportDocumentationPopup + " || Actual Pop up : "
						+ new_import_documentation, test, test1);
				
			} else {
				System.out.println("Not Matched || Expected Pop up : " + NewImportDocumentationPopup + " || Actual Pop up : "
						+ new_import_documentation);
				Extent_fail(driver, "Not Matched || Expected Pop up : " + NewImportDocumentationPopup + " || Actual Pop up : "
						+ new_import_documentation, test, test1);
				
			}
			Step_End(5,
					"The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.",
					test, test1);
			Step_Start(6, "Click the Yes button.", test, test1);

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(6, "Click the Yes button.", test, test1);
		}
		
		//Vignesh-> As discussed with Suresh on 17_04_2025, I have Removed the (Step 7) Codes for validating the Service, POL search field, all dropdown fields, and Show BL's button are enabled.

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, BL_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
		
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			
			Step_Start(8, " Enter the valid service.", test, test1);
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service);
			Step_End(8, " Enter the valid service.", test, test1);
			
			Step_Start(9, "Populate the vessel details based on the provided service.", test, test1);
			Step_Start(10, "Select the service and vessel details.", test, test1);

			if(!Vessel.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
			}
			if(!Voyage.trim().equals("")) {
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
			}
			if(!Bound.trim().equals("")) {
				sendKeys(driver, grid_bound_IMP_DOC, Bound);
			}
			if(!Port.trim().equals("")) {
				sendKeys(driver, grid_portcodeIMP_DOC, Port);
			}
			if(!Terminal.trim().equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 300);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
			}
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			waitForElement(driver, grid_selectbtn_IMP_DOC);;
			click(driver, grid_selectbtn_IMP_DOC);
			Step_End(9, "Populate the vessel details based on the provided service.", test, test1);
			Step_End(10, "Select the service and vessel details.", test, test1);

			Step_Start(11, "POL Search field-based on datasheet it will set ", test, test1);
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition_Filter, pol_Value);
			}
			Step_End(11, "POL Search field-based on datasheet it will set ", test, test1);

			Step_Start(11, "ALL ,SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);
			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			
			waitForElement(driver, select_Option_1);
			click(driver, select_Option_1);
			Step_End(11, "ALL ,SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);

			Step_Start(12, "ALL,LOCAL,TRANS-Based on the data set it will set", test, test1);
			waitForElement(driver, slection_Label_2);
			click(driver, slection_Label_2);
			
			waitForElement(driver, select_Option_2);
			click(driver, select_Option_2);
			Step_End(12, "ALL,LOCAL,TRANS-Based on the data set it will set", test, test1);

			Step_Start(13, "Click the Show BL's button.", test, test1);
			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);
			Step_End(13, "Click the Show BL's button.", test, test1);

			Step_Start(14, "The respective service and vessel-based BL's will be shown in the import,documentation module.-retrive the bill in bl no search", test, test1);			 
			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, Condition_Filter, BL_Number);	
			Step_End(14, "The respective service and vessel-based BL's will be shown in the import,documentation module.-retrive the bill in bl no search", test, test1);			 
		}
		
		Step_Start(18, "save the import documentation.", test, test1);

		waitForDisplay(driver, BL_status_IMP_DOC);
		String BL_Value=getText(driver, BL_status_IMP_DOC);
		if(!BL_Value.equalsIgnoreCase("NEW")) {
			System.out.println("bl was already saved");
		}else {
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		Step_End(18, "save the import documentation.", test, test1);

		Step_Start(15, "below Location details are shown in the right-side corner:\r\n"
				+ "    - PLA, POL, \r\n"
				+ "    - POD, PLD,", test, test1);

			waitForElement(driver, PLALocationId);
			String PLALocationIdText=getText(driver, PLALocationId);
			
			waitForElement(driver, POLLocationId);
			String POLLocationIdText=getText(driver, POLLocationId);

			waitForElement(driver, PODLocationId);
			String PODLocationIdText=getText(driver, PODLocationId);
			
			waitForElement(driver, PLDLocationId);
			String PLDLocationIdText=getText(driver, PLDLocationId);
			Step_End(15, "below Location details are shown in the right-side corner:\r\n"
					+ "  - PLA, POL, \r\n"
					+ "  - POD, PLD, ", test, test1);
			
			Step_Start(16, "bl is new status then go the BL/HBL summary tab-MCN  field -value is available or not", test, test1);
			Step_Start(17, ".if available -capture the MCN number and bl number or if MCN number not available then  save the import doc.", test, test1);

		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver,BL_HBL_Summary_Tab);
		waitForElement(driver, MCN_Text_Field_IMPORT_DOC);
		String MCN_Number = getAttribute(driver, MCN_Text_Field_IMPORT_DOC, "value");
		Step_End(16, "bl is new status then go the BL/HBL summary tab-MCN  field -value is available or not", test, test1);
		Step_End(17, ".if available -capture the MCN number and bl number or if MCN number not available then  save the import doc.", test, test1);

		if(MCN_Number.equals("")) {
			scrollTop(driver);
			Step_Start(22, "if MCN no is not  available then open the Bill of lading module.", test, test1);
			Extent_cal(test, test1, "Bill Of Lading");
			
			moduleNavigate(driver, BillofLading_Module);
			Step_End(22, "if MCN no is not  available then open the Bill of lading module.", test, test1);

			Step_Start(23, "load the  same bill in bill of lading module", test, test1);

			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_BOL, BL_Number, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOL_Select_Value3);
			Step_End(23, "load the  same bill in bill of lading module", test, test1);

			Step_Start(24, "PLA ,POL,POD AND PLD details has shown in billof lading module.", test, test1);

			waitForElement(driver, PLALocationIdBoL);
			String PLALocationIdTextBoL=getText(driver, PLALocationIdBoL);
			
			waitForElement(driver, POLLocationIdBoL);
			String POLLocationIdTextBol=getText(driver, POLLocationIdBoL);
			
			waitForElement(driver, PODLocationIdBoL);
			String PODLocationIdTextBol=getText(driver, PODLocationIdBoL);
			
			waitForElement(driver, PLDLocationIdBoL);
			String PLDLocationIdTextBoL=getText(driver, PLDLocationIdBoL);
			
			if(PLALocationIdText.equals(PLALocationIdTextBoL)) {
				System.out.println("Matched || Expected The Import Documentaion PLA Location ID was : "+PLALocationIdText +" || Actual The Bill Off Lading PLA Location is : "+PLALocationIdTextBoL);
				Extent_pass_New(driver, "Matched || Expected The Import Documentaion PLA Location ID was : "+PLALocationIdText +" || Actual The Bill Off Lading PLA Location is : "+PLALocationIdTextBoL, test, test1);
			}else {
				System.out.println("Not Matched || Expected The Import Documentaion PLA Location ID was : "+PLALocationIdText +" || Actual The Bill Off Lading PLA Location is : "+PLALocationIdTextBoL);
				Extent_fail(driver, "Not Matched || Expected The Import Documentaion PLA Location ID was : "+PLALocationIdText +" || Actual The Bill Off Lading PLA Location is : "+PLALocationIdTextBoL, test, test1);
			}
			if(POLLocationIdText.equals(POLLocationIdTextBol)) {
				System.out.println("Matched || Expected The Import Documentaion POL Location ID was : "+POLLocationIdText +" || Actual The Bill Off Lading POL Location is : "+POLLocationIdTextBol);
				Extent_pass_New(driver, "Matched || Expected The Import Documentaion POL Location ID was : "+POLLocationIdText +" || Actual The Bill Off Lading POL Location is : "+POLLocationIdTextBol, test, test1);
			}else {
				System.out.println("Not Matched || Expected The Import Documentaion POL Location ID was : "+POLLocationIdText +" || Actual The Bill Off Lading POL Location is : "+POLLocationIdTextBol);
				Extent_fail(driver, "Not Matched || Expected The Import Documentaion POL Location ID was : "+POLLocationIdText +" || Actual The Bill Off Lading POL Location is : "+POLLocationIdTextBol, test, test1);
			}
			if(PODLocationIdText.equals(PODLocationIdTextBol)) {
				System.out.println("Matched || Expected The Import Documentaion POD Location ID was : "+PODLocationIdText +" || Actual The Bill Off Lading POD Location is : "+PODLocationIdTextBol);

				Extent_pass_New(driver, "Matched || Expected The Import Documentaion POD Location ID was : "+PODLocationIdText +" || Actual The Bill Off Lading POD Location is : "+PODLocationIdTextBol, test, test1);
			}else {
				System.out.println("Not Matched || Expected The Import Documentaion POD Location ID was : "+PODLocationIdText +" || Actual The Bill Off Lading POD Location is : "+PODLocationIdTextBol);
				Extent_fail(driver, "Not Matched || Expected The Import Documentaion POD Location ID was : "+PODLocationIdText +" || Actual The Bill Off Lading POD Location is : "+PODLocationIdTextBol, test, test1);
			}
			if(PLDLocationIdText.equals(PLDLocationIdTextBoL)) {
				System.out.println("Matched || Expected The Import Documentaion PLD Location ID was : "+PLDLocationIdText +" || Actual The Bill Off Lading PLD Location is : "+PLDLocationIdTextBoL);
				Extent_pass_New(driver, "Matched || Expected The Import Documentaion PLD Location ID was : "+PLDLocationIdText +" || Actual The Bill Off Lading PLD Location is : "+PLDLocationIdTextBoL, test, test1);
			}else {
				System.out.println("Not Matched || Expected The Import Documentaion PLD Location ID was : "+PLDLocationIdText +" || Actual The Bill Off Lading PLD Location is : "+PLDLocationIdTextBoL);
				Extent_fail(driver, "Not Matched || Expected The Import Documentaion PLD Location ID was : "+PLDLocationIdText +" || Actual The Bill Off Lading PLD Location is : "+PLDLocationIdTextBoL, test, test1);
			}
			Step_End(16, "PLA ,POL,POD AND PLD details has shown in billof lading module.", test, test1);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			Step_End(24, "PLA ,POL,POD AND PLD details has shown in billof lading module.", test, test1);

		}else {
			scrollTop(driver);
			Step_Start(20, "if MCN no is available then open the Manifest correction notes module", test, test1);
			Extent_cal(test, test1, "MCN Module");
			
			moduleNavigate(driver, MCN_Module);
			Step_End(20, "if MCN no is available then open the Manifest correction notes module", test, test1);

			Step_Start(21, "retrive the bill or MCN no in manifest correction notes module capture the value and match with import documentation.", test, test1);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_MCN, MCN_Number, MCN_Select_Type2, MCN_Select_Value2, MCN_Select_Type3, MCN_Select_Value3);

			waitForElement(driver, MCN_PLA);
			String PLALocationIdTextBoL=getText(driver, MCN_PLA);
				
			waitForElement(driver, MCN_POL);
			String POLLocationIdTextBol=getText(driver, MCN_POL);
				
			waitForElement(driver, MCN_POD);
			String PODLocationIdTextBol=getText(driver, MCN_POD);
			
			waitForElement(driver, MCN_PLD);
			String PLDLocationIdTextBoL=getText(driver, MCN_PLD);
			
			if(PLALocationIdText.equals(PLALocationIdTextBoL)) {
				System.out.println("Matched || Expected The Import Documentaion PLA Location ID was : "+PLALocationIdText +" || Actual The Bill Off Lading PLA Location is : "+PLALocationIdTextBoL);
				Extent_pass_New(driver, "Matched || Expected The Import Documentaion PLA Location ID was : "+PLALocationIdText +" || Actual The Bill Off Lading PLA Location is : "+PLALocationIdTextBoL, test, test1);
			}else {
				System.out.println("Not Matched || Expected The Import Documentaion PLA Location ID was : "+PLALocationIdText +" || Actual The Bill Off Lading PLA Location is : "+PLALocationIdTextBoL);
				Extent_fail(driver, "Not Matched || Expected The Import Documentaion PLA Location ID was : "+PLALocationIdText +" || Actual The Bill Off Lading PLA Location is : "+PLALocationIdTextBoL, test, test1);
			}
			if(POLLocationIdText.equals(POLLocationIdTextBol)) {
				System.out.println("Matched || Expected The Import Documentaion POL Location ID was : "+POLLocationIdText +" || Actual The Bill Off Lading POL Location is : "+POLLocationIdTextBol);
				Extent_pass_New(driver, "Matched || Expected The Import Documentaion POL Location ID was : "+POLLocationIdText +" || Actual The Bill Off Lading POL Location is : "+POLLocationIdTextBol, test, test1);
			}else {
				System.out.println("Not Matched || Expected The Import Documentaion POL Location ID was : "+POLLocationIdText +" || Actual The Bill Off Lading POL Location is : "+POLLocationIdTextBol);
				Extent_fail(driver, "Not Matched || Expected The Import Documentaion POL Location ID was : "+POLLocationIdText +" || Actual The Bill Off Lading POL Location is : "+POLLocationIdTextBol, test, test1);
			}
			if(PODLocationIdText.equals(PODLocationIdTextBol)) {
				System.out.println("Matched || Expected The Import Documentaion POD Location ID was : "+PODLocationIdText +" || Actual The Bill Off Lading POD Location is : "+PODLocationIdTextBol);
				Extent_pass_New(driver, "Matched || Expected The Import Documentaion POD Location ID was : "+PODLocationIdText +" || Actual The Bill Off Lading POD Location is : "+PODLocationIdTextBol, test, test1);
			}else {
				System.out.println("Not Matched || Expected The Import Documentaion POD Location ID was : "+PODLocationIdText +" || Actual The Bill Off Lading POD Location is : "+PODLocationIdTextBol);
				Extent_fail(driver, "Not Matched || Expected The Import Documentaion POD Location ID was : "+PODLocationIdText +" || Actual The Bill Off Lading POD Location is : "+PODLocationIdTextBol, test, test1);
			}
			if(PLDLocationIdText.equals(PLDLocationIdTextBoL)) {
				System.out.println("Matched || Expected The Import Documentaion PLD Location ID was : "+PLDLocationIdText +" || Actual The Bill Off Lading PLD Location is : "+PLDLocationIdTextBoL);
				Extent_pass_New(driver, "Matched || Expected The Import Documentaion PLD Location ID was : "+PLDLocationIdText +" || Actual The Bill Off Lading PLD Location is : "+PLDLocationIdTextBoL, test, test1);
			}else {
				System.out.println("Not Matched || Expected The Import Documentaion PLD Location ID was : "+PLDLocationIdText +" || Actual The Bill Off Lading PLD Location is : "+PLDLocationIdTextBoL);
				Extent_fail(driver, "Not Matched || Expected The Import Documentaion PLD Location ID was : "+PLDLocationIdText +" || Actual The Bill Off Lading PLD Location is : "+PLDLocationIdTextBoL, test, test1);
			}
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			Step_End(21, "retrive the bill or MCN no in manifest correction notes module capture the value and match with import documentation.", test, test1);

		}

		if(Delete_perform.equalsIgnoreCase("YES")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
	
		Extent_completed(testCaseName, test, test1);

	}
}
	
