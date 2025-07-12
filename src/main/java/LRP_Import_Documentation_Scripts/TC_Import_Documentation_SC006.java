package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC006 extends Keywords{

	public void Import_Documentation_SC006(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Import_Documentation_SC006";

		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String moduleID=Excel_data.get("Module_ImportDocumentation");
		String agencyUser = Excel_data.get("AgencyUser");
		String Service_Name = Excel_data.get("Service_Name");
		String vesselcode = Excel_data.get("vesselcode");
		String voyagecode = Excel_data.get("voyagecode");
		String bound = Excel_data.get("bound");
		String portcode = Excel_data.get("portcode");
		String terminal = Excel_data.get("terminal");
		String New_Import_Documentation = Excel_data.get("New_Import_Documentation");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String Select_Search_Type_Import_Doc = Excel_data.get("Select_Search_Type_Import_Doc");
		String bl_Number = Excel_data.get("bl_Number");
		String BL_Condition = Excel_data.get("BL_Condition");
		String pol_Value = Excel_data.get("pol_Value");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String BLModule = Excel_data.get("BLModule");
		String confirmed_Color = Excel_data.get("confirmed_Color");
		String issued_Colour = Excel_data.get("issued_Colour");
		String draft_Colour = Excel_data.get("draft_Colour");
		String Condition = Excel_data.get("Condition");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String Select_Search_Type_BOL = Excel_data.get("Select_Search_Type_BOL");
		String BOL_Select_Type2=Excel_data.get("BOL_Select_Type2");
		String BOL_Select_Value2=Excel_data.get("BOL_Select_Value2");
		String BOL_Select_Type3=Excel_data.get("BOL_Select_Type3");
		String BOL_Select_Value3=Excel_data.get("BOL_Select_Value3");
	
		String Delete_Confirmation_Popup=Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup=Excel_data.get("Delete_Success_Popup");
		

		//  String Get_BL_Number;
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testCaseName, test, test1);
		//		Login
		navigateUrl(driver,url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		
		Extent_cal(test, test1, "Checking the visibility of Main menu");

		Step_Start(1, "Switch to agency", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, "Switch to agency", test, test1);

		Step_Start(2, "Open the import documentation module", test, test1);
	
		moduleNavigate(driver, moduleID);

		Step_End(2, "Open the import documentation module", test, test1);

		//Vignesh-> As discussed with Suresh on 16_04_2025, I have Removed the (Step 3) Codes for validating all the Toolbar functions accessiblity
		
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {

			Step_Start(4, "Click the Home button", test, test1);
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				Step_Start(5, "The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.", test, test1);
				waitForPopup(driver, popup_Message, New_Import_Documentation);
				String new_import_documentation=getText(driver, popup_Message);
				if(new_import_documentation.equals(New_Import_Documentation)) {
					System.out.println("Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation);
					Extent_pass_New(driver, "Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation, test, test1);
				}else {
					System.out.println("Not Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation);
					Extent_fail(driver, "Not Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation, test, test1);
				}

				Step_End(5, "The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.", test, test1);

				Step_Start(6, "Click the Yes button", test, test1);
				waitForElement(driver, popup_Message_Yes_Button);
				safeclick(driver, popup_Message_Yes_Button);
				Step_End(6, "Click the Yes button", test, test1);
			}
			Step_End(4, "Click the Home button", test, test1);

			Step_Start(8, "Enter the valid service.", test, test1);
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service_Name);
			Step_End(8, "Enter the valid service.", test, test1);

			Step_Start(9, "Populate the vessel details based on the provided service.", test, test1);
			Step_Start(10, "Select the service and vessel details.", test, test1);
			
			if(!vesselcode.equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, vesselcode);
			}
			if(!voyagecode.equals("")) {
				sendKeys(driver, grid_voyagecode_IMP_DOC, voyagecode);
			}
			if(!bound.equals("")) {
				sendKeys(driver, grid_bound_IMP_DOC, bound);
			}
			if(!portcode.equals("")) {
				sendKeys(driver, grid_portcodeIMP_DOC, portcode);
			}
			if(!terminal.equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 300);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, terminal);
			}

			waitForElement(driver, Select_Service_Details);
			click(driver,Select_Service_Details);

			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			Step_End(9, "Populate the vessel details based on the provided service.", test, test1);
			Step_End(10, "Select the service and vessel details.", test, test1);
			
			Step_Start(11, "POL Search field-based on datasheet it will set ", test, test1);

			scrollTop(driver);
			if(!pol_Value.equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition, pol_Value);
			}
			Step_End(11, "POL Search field-based on datasheet it will set ", test, test1);

			Step_Start(12, "ALL ,SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);
			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			waitForElement(driver, select_Option_1);
			click(driver, select_Option_1);
			Step_End(12, "ALL ,SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);

			Step_Start(13, "ALL,LOCAL,TRANS-Based on the data set it will set", test, test1);
			waitForElement(driver, slection_Label_2);
			click(driver, slection_Label_2);
			
			waitForElement(driver, select_Option_2);
			click(driver, select_Option_2);
			Step_End(13, "ALL,LOCAL,TRANS-Based on the data set it will set", test, test1);

			Step_Start(14, " Click the Show BL's button.", test, test1);
			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);
			Step_End(14, " Click the Show BL's button.", test, test1);


			Step_Start(15, "The respective service and vessel-based BL's will be shown in the import documentation module", test, test1);
			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);

			waitForElement(driver, BL_Number);
			String Get_BL_Number = getAttribute(driver, BL_Number,"value");
			System.out.println("Get_BL_Number:"+ Get_BL_Number);
			Step_End(15, "The respective service and vessel-based BL's will be shown in the import documentation module.", test, test1);

			Step_Start(16, "retive the bill -bl no search", test, test1);
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, Condition, bl_Number);
			Step_End(16, "retive the bill -bl no search", test, test1);

		}
		
		Extent_call(test, test1, "if the bill is new status-save the import documentation.\r\n"
				+ "if the bill is already saved then edit and go then last save the import documentation.");
		
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
		
		Step_Start(17, "capture  ---bl status has to be shown in import documentation.", test, test1);

		waitForElement(driver, BL_Status_Value_IMP_DOC);
		String Get_BL_Status = getText(driver, BL_Status_Value_IMP_DOC);
		System.out.println("Get_BL_Status:"+ Get_BL_Status);
		Step_End(17, "capture  ---bl status has to be shown in import documentation.", test, test1);

		Extent_call(test, test1, "if the bill is new status-save the import documentation.\r\n"
				+ "if the bill is already saved then edit and go then last save the import documentation.");
		
		Step_Start(18, "open the bill of lading module", test, test1);
		moduleNavigate(driver, BLModule);
		Step_End(18, "open the bill of lading module", test, test1);

		Step_Start(19, "load the bill in bill of lading module ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow1(driver, BL_Condition, Select_Search_Type_BOL, bl_Number, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOL_Select_Value3);
		
		waitForElement(driver, status_input_IMP_DOC);
		sendKeys(driver, status_input_IMP_DOC, Get_BL_Status);
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
	    click(driver, SelectButton);
		Step_End(19, "load the bill in bill of lading module ", test, test1);

        Step_Start(20, "in bill of lading module bill status has shown.", test, test1);
		waitForElement(driver, BL_no_IMD);
		String bill_number_colour= getTextBackgroundColor(driver, BL_no_IMD);
		System.out.println(bill_number_colour);
        
        String bill_Color_Act=getColorName(bill_number_colour);        
		if(confirmed_Color.equalsIgnoreCase(bill_Color_Act)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + confirmed_Color + " || Actual Report Activity is : " + bill_Color_Act);            
			System.out.println("BL status is in Confirmed status");
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + confirmed_Color + " || Actual Report Activity is : " + bill_Color_Act, test,test1);     
		}  else if (issued_Colour.equalsIgnoreCase(bill_Color_Act)) {
			System.out.println("Matched || Expected value was : " + issued_Colour + " || Actual value was : " + bill_Color_Act);
			System.out.println("BL status is in Issued status");
			Extent_pass_New(driver, "Matched || Expected value was : " + issued_Colour + " || Actual value was : " + bill_Color_Act, test,
					test1);
		} else if (draft_Colour.equalsIgnoreCase(bill_Color_Act)) {
			System.out.println("Matched || Expected value was : " + draft_Colour + " || Actual value was : " + bill_Color_Act);
			System.out.println("BL status is in Draft status");
			Extent_pass_New(driver, "Matched || Expected value was : " + draft_Colour + " || Actual value was : " + bill_Color_Act, test,
					test1);
		}else {
			System.out.println("NotMatched || Expected value was : " + confirmed_Color + " || Actual value was : " + bill_Color_Act);
			Extent_fail(driver, "NotMatched || Expected value was : " + confirmed_Color + " || Actual value was : " + bill_Color_Act,
					test, test1);
		}

		waitForElement(driver, Close_Current_tab);
		jsClick(driver, Close_Current_tab);
        Step_End(20, "in bill of lading module bill status has shown.", test, test1);

		 if(Delete_Perform.equalsIgnoreCase("YES")){
			 Extent_cal(test, test1, "delete the bl in import documenation.");
			 deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		 }
	
		Extent_completed(testCaseName, test, test1);

	}
}
