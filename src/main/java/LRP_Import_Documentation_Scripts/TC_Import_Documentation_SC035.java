package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC035 extends Keywords {

	public void Import_Documentation_SC035(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
	
		String testcase_Name="TC_Import_Documentation_SC035";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Discharge_status_Value = Excel_data.get("Discharge_status_Value");
		String Nature_Of_Cargo_Select = Excel_data.get("Nature_Of_Cargo_Select");
		String Item_Type_select = Excel_data.get("Item_Type_select");
		String DPD_Code_Value = Excel_data.get("DPD_Code_Value");
		String US_Customs_Port_Value = Excel_data.get("US_Customs_Port_Value");
		String date_Picker = Excel_data.get("date_Picker");
		String BL_House_Date_Input = Excel_data.get("BL_House_Date_Input");
		String Transport_Service_Value = Excel_data.get("Transport_Service_Value");
		String D_O_Hold = Excel_data.get("D_O_Hold");
		String SavedPopup = Excel_data.get("SavedPopup");
		String Service_Name = Excel_data.get("Service_Name");
		String vesselcode = Excel_data.get("vesselcode");
		String voyagecode = Excel_data.get("voyagecode");
		String bound = Excel_data.get("bound");
		String portcode = Excel_data.get("portcode");
		String terminal = Excel_data.get("terminal");
		String New_Import_Documentation = Excel_data.get("New_Import_Documentation");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String bl_Number = Excel_data.get("bl_Number");
		String pol_Value = Excel_data.get("pol_Value");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String UpdatedPopup = Excel_data.get("UpdatedPopup");
		String Condition = Excel_data.get("Condition");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String Transport_Service_Header=Excel_data.get("Transport_Service_Header");
		String Discharge_Code_Header=Excel_data.get("Discharge_Code_Header");
		String US_Customs_Port_Header=Excel_data.get("US_Customs_Port_Header");

		String Delete_Confirmation_Popup=Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup=Excel_data.get("Delete_Success_Popup");
		
		String Nature_Of_Cargo = String.format(ImportDocumentation_Locators.Nature_Of_Cargo, Nature_Of_Cargo_Select);
		String Item_type = String.format(ImportDocumentation_Locators.Item_type, Item_Type_select);


		//        String Get_BL_Number;
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
	
		SwitchProfile(driver, AgencyUser);

	    Step_Start(1, "open the In Import Documentation and  Retrive the  bill using tool bar search", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
			
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				
				waitForPopup(driver, popup_Message, New_Import_Documentation);
				String new_import_documentation=getText(driver, popup_Message);
				if(new_import_documentation.equals(New_Import_Documentation)) {
					Extent_pass_New(driver, "Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation, test, test1);
					System.out.println("Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation);
				}else {
					Extent_fail(driver, "Not Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation, test, test1);
					System.out.println("Not Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation);
				}

				waitForElement(driver, popup_Message_Yes_Button);
				safeclick(driver, popup_Message_Yes_Button);
			}
			
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service_Name);

			if(!vesselcode.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, vesselcode);
			}
			if(!voyagecode.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, voyagecode);
			}
			if(!bound.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, bound);
			}
			if(!portcode.trim().equals("")) {
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, portcode);
			}
			if(!terminal.trim().equals("")) {
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

			scrollTop(driver);
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition, pol_Value);

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

			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, Condition, bl_Number);			

		}

		Step_End(1, "open the In Import Documentation and  Retrive the  bill using tool bar search.", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (!house_BL_Status.equalsIgnoreCase("NEW")) {
			waitForElement(driver, Edit_Button_toolBar);
			jsClick(driver, Edit_Button_toolBar);
		}

		waitForElement(driver, BL_status_IMP_DOC);
		String Get_BL_Status = getText(driver, BL_status_IMP_DOC);
		System.out.println("Get_BL_Status:"+ Get_BL_Status);

		Step_Start(2, "after retrive the bl,go to the BL/HBL Summary Tab", test, test1);
		waitForElement(driver, BL_HBL_Summary_Tab);
		safeclick(driver, BL_HBL_Summary_Tab);
		Step_End(2, "after retrive the bl,go to the BL/HBL Summary Tab", test, test1);

		scrollBottom(driver);
		if(!Transport_Service_Value.trim().equals("")) {
			Step_Start(3, "click the transport service search field in import documentation.", test, test1);
			waitForElement(driver, Transport_service_SearchButton);
			click(driver, Transport_service_SearchButton);
			Step_End(3, "click the transport service search field in import documentation.", test, test1);
			Step_Start(4, "list of the trasnport serivce ", test, test1);
			Step_Start(5, "select one the transport service", test, test1);

			twoColumnMultipleSearchWindow(driver, Transport_Service_Header, Condition, Transport_Service_Value);

			Step_End(4, "list of the trasnport serivce ", test, test1);
			Step_End(5, "select one the transport service", test, test1);
		}
		
		if (!Discharge_status_Value.trim().equals("")) {
			waitForElement(driver, Discharge_status_search_button);
			click(driver, Discharge_status_search_button);
			twoColumnMultipleSearchWindow(driver, Discharge_Code_Header, Condition, Discharge_status_Value);
		}

		if (!Nature_Of_Cargo_Select.trim().equals("")) {
			click(driver, Nature_Of_Cargo_dropdown);
			waitForElement(driver, Nature_Of_Cargo);
			click(driver, Nature_Of_Cargo);
		}

		if (!Item_Type_select.trim().equals("")) {
			click(driver, Item_type_Dropdown);
			waitForElement(driver, Item_type);
			click(driver, Item_type);
		}

		if (!DPD_Code_Value.trim().equals("")) {
			waitForElement(driver, DPD_Code);
			sendKeys(driver, DPD_Code, DPD_Code_Value);
		}

		if (!US_Customs_Port_Value.trim().equals("")) {
			waitForElement(driver, Customs_Clearance_Station_searchBtn);
			click(driver, Customs_Clearance_Station_searchBtn);
			twoColumnMultipleSearchWindow(driver, US_Customs_Port_Header, Condition, US_Customs_Port_Value);
		}
		if (!BL_House_Date_Input.trim().equals("")) {
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, BL_House_Date, BL_House_Date_Input);
			} else {
				click(driver, BL_House_Date);
				waitForElement(driver, BL_House_Date);
				clearAndType(driver, BL_House_Date, BL_House_Date_Input);
			}
		}

		checkBox(driver, D_O_hold_checkbox, D_O_Hold);
		scrollTop(driver);
				
		Step_Start(6, "click the save button  in tool bar", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(6, "click the save button  in tool bar", test, test1);
		Step_Start(7, "System has popluate the validate import documentation is saved", test, test1);

		waitForPopup(driver, popup_Message, SavedPopup);
		String BL_StatusValue= getText(driver, popup_Message);

		if(BL_StatusValue.equals(SavedPopup)) {
			System.out.println("Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + SavedPopup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + SavedPopup, test,
					test1);
		} else if (BL_StatusValue.equals(UpdatedPopup)) {
			System.out.println("Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + UpdatedPopup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + UpdatedPopup, test,
					test1);
		}else {
			System.out.println("NotMatched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + UpdatedPopup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + UpdatedPopup,
					test, test1);
		}

		Step_End(7, "System has popluate the validate import documentation is saved", test, test1);
		Step_Start(8, "Bl has saved in Import Documentation", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(8, "Bl has saved in Import Documentation", test, test1);

		scrollBottom(driver);
		Step_Start(9, "Verify that Given Transport Service is Selected ", test, test1);
		waitForElement(driver, Transport_Service_TF);
		String Transport_service = getAttribute(driver, Transport_Service_TF, "value");
		System.out.println("Transport Service:" + Transport_service);
		if (Transport_Service_Value.equals(Transport_service)) {
			System.out.println("Matched || Expected value was : " + Transport_Service_Value + " || Actual value was : "
					+ Transport_service);
			Extent_pass_New(driver, "Matched || Expected value was : " + Transport_Service_Value + " || Actual value was : "
					+ Transport_service, test, test1);

		} else {
			System.out.println("NotMatched || Expected value was : " + Transport_Service_Value
					+ " || Actual value was : " + Transport_service);
			Extent_fail(driver, "NotMatched || Expected value was : " + Transport_Service_Value
					+ " || Actual value was : " + Transport_service, test, test1);

		}
		Step_End(9, "Verify that Given Transport Service is Selected ", test, test1);

		Step_Start(10, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(11, "click the yes and system has validate import dcoumentation is deleted .", test, test1);
		
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Step_End(10, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(11, "click the yes and system has validate import dcoumentation is deleted .", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
	}
}