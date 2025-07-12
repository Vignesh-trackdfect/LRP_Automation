package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC051 extends Keywords{

	public void Import_Documentation_SC051(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC051";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String SavedPopup = Excel_data.get("SavedPopup");
		String Export_Agency = Excel_data.get("Export_Agency");
		String Manifest_Module = Excel_data.get("Manifest_Module");
		String Corection_Type_Option = Excel_data.get("Corection_Type_Option");
		String Container_No = Excel_data.get("Container_No");
		String Alchohol_Check_Box_Select = Excel_data.get("Alchohol_Check_Box_Select");
		String MilitaryCargo_Check_Box_Select = Excel_data.get("MilitaryCargo_Check_Box_Select");
		String Quantity_Input = Excel_data.get("Quantity_Input");
		String Package_Input = Excel_data.get("Package_Input");
		String Comm_Group_Input = Excel_data.get("Comm_Group_Input");
		String HS_Code_Input = Excel_data.get("HS_Code_Input");
		String Cargo_Weigt_Input = Excel_data.get("Cargo_Weigt_Input");
		String Net_Weight_Input = Excel_data.get("Net_Weight_Input");
		String Unit_Weight_Type = Excel_data.get("Unit_Weight_Type");
		String Volume_Input = Excel_data.get("Volume_Input");
		String Unit_Size_Type = Excel_data.get("Unit_Size_Type");
		String Marks_And_Numbers_Input = Excel_data.get("Marks_And_Numbers_Input");
		String Commodity_Desc_Input = Excel_data.get("Commodity_Desc_Input");
		String MCN_Remarks_Input = Excel_data.get("MCN_Remarks_Input");
		String MCN_Popup_Msg = Excel_data.get("MCN_Popup_Msg");
		String MCN_Approved_msg = Excel_data.get("MCN_Approved_msg");
		String Refresh_Popup_Msg = Excel_data.get("Refresh_Popup_Msg");
		String Updated_Popup_Msg = Excel_data.get("Updated_Popup_Msg");
		String Table_Headers=Excel_data.get("Commodity_Table_Headers");
		String Table_Name=Excel_data.get("Commodity_Table_Name");
		String Blue_Color=Excel_data.get("Blue_Color");
		String MCN_Refresh_Popup=Excel_data.get("MCN_Refresh_Popup");
		String MCN_Table_Headers=Excel_data.get("MCN_Commodity_Table_Headers");
		String MCN_Table_Name=Excel_data.get("MCN_Commodity_Table_Name");
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String Port = Excel_data.get("Portcode");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String HS_Code_Select_Type1=Excel_data.get("HS_Code_Select_Type1");
		String HS_Code_Select_Type2=Excel_data.get("HS_Code_Select_Type2");
		String HS_Code_Select_Type3=Excel_data.get("HS_Code_Select_Type3");
		String HS_Code_Select_Value2=Excel_data.get("HS_Code_Select_Value2");
		String HS_Code_Select_Value3=Excel_data.get("HS_Code_Select_Value3");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String MCN_Do_You_want_Edit_Popup=Excel_data.get("MCN_Do_You_want_Edit_Popup");

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		String Ports_Module=Excel_data.get("Ports_Module");		
		String Ports_Search_Type_Select=Excel_data.get("Ports_Search_Type_Select");		
		String MCN_Retrive_Type=Excel_data.get("MCN_Retrive_Type");
		String Accepted_Popup=Excel_data.get("Accepted_Popup");		
		String Status_Tab_Table_Headers=Excel_data.get("Status_Tab_Table_Headers");		
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);
		Step_Start(1, "open the import documentaiton module.", test, test1);

		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(1, "open the import documentaiton module.", test, test1);

		Step_Start(2, "load the bl in import documentation module.", test, test1);

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
		
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(isClickable(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation=getText(driver, popup_Message).trim();
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation, test,test1);
					safeclick(driver, popup_Message_Yes_Button);
				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation,test, test1);
				}
			
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
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition_Filter, pol_Value);
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
			
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, Condition_Filter, BL_Num);	
		}
		
		Step_End(2, "load the bl in import documentation module.", test, test1);

		Step_Start(3, "bl has saved in import documentation.", test, test1);
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status=getText(driver, BL_status_IMP_DOC).trim();
		if (house_BL_Status.equals("NEW")) {
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			waitForPopup(driver, popup_Message, SavedPopup);
			String ImportDocumentationSaved=getText(driver, popup_Message);
			if (SavedPopup.equals(ImportDocumentationSaved)) {
				System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,
						test1);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved,
						test, test1);
				
			}
		}
		Step_End(3, "bl has saved in import documentation.", test, test1);

		Step_Start(4, "switch to the export agency", test, test1);
		SwitchProfile(driver, Export_Agency);
		
		Step_End(4, "switch to the export agency", test, test1);

		Step_Start(5, "open the manifest correction notes module (MCN)", test, test1);

		moduleNavigate(driver, Manifest_Module);
		Step_End(5, "open the manifest correction notes module (MCN)", test, test1);

		Step_Start(6, "select the multi correction in correction type field", test, test1);
		waitForElement(driver, Corection_Type_DropDown);
		click(driver, Corection_Type_DropDown);
		formatLocatorClick(driver, correctionType_MCN, Corection_Type_Option);
		Step_End(6, "select the multi correction in correction type field", test, test1);

		Step_Start(7, "load the same bl in bl search field", test, test1);

		waitForElement(driver, BL_Search_Button);
		click(driver, BL_Search_Button);
		globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
	
		Step_End(7, "load the same bl in bl search field", test, test1);

		Step_Start(8, "system will be vaidate (Import Doc already saved Do you want to Continue Click Yes and Go)", test, test1);

		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}
		
		Step_End(8, "system will be vaidate (Import Doc already saved Do you want to Continue Click Yes and Go)", test, test1);

		Step_Start(9, "datas fetched all the tabs", test, test1);
		Step_End(9, "datas fetched all the tabs", test, test1);
		Step_Start(10, "go to the commodity  tab", test, test1);

		waitForElement(driver, Manifest_Commodity_Tab);
		click(driver, Manifest_Commodity_Tab);  
		Step_End(10, "go to the commodity  tab", test, test1);

		Step_Start(11, "in below grid container no based commodity details has shown", test, test1);
		Step_End(11, "in below grid container no based commodity details has shown", test, test1);

		Step_Start(12, "click the edit in below grid", test, test1);
		
		
		List<String> datas = splitAndExpand(Container_No);
		List<String> datas1 = splitAndExpand(Quantity_Input);
		List<String> datas2 = splitAndExpand(Package_Input);
		List<String> datas3 = splitAndExpand(Comm_Group_Input);
		List<String> datas4 = splitAndExpand(HS_Code_Input);
		List<String> datas5 = splitAndExpand(Cargo_Weigt_Input);
		List<String> datas6 = splitAndExpand(Net_Weight_Input);
		List<String> datas7 = splitAndExpand(Unit_Weight_Type);
		List<String> datas8 = splitAndExpand(Volume_Input);
		List<String> datas9 = splitAndExpand(Unit_Size_Type);
		List<String> datas10 = splitAndExpand(Marks_And_Numbers_Input);
		List<String> datas11 = splitAndExpand(Commodity_Desc_Input);
		
		waitForElement(driver, MCN_Commodity_Table_Headers);
		for (int i=0 ;i<datas.size();i++) {

			String Commodity_Edit_Selectnew =  String.format(Commodity_Edit_Select, datas.get(i));
	
			waitForElement(driver, Commodity_Edit_Selectnew);
			click(driver, Commodity_Edit_Selectnew); 
			Step_End(12,"click the edit in below grid", test, test1);
	
			Step_Start(13, "details will be fetched in the above field", test, test1);
			Step_End(13,"details will be fetched in the above field", test, test1);
	
			Step_Start(14, "change the quantity", test, test1);
	
			if(Quantity_Input!=null&&!Quantity_Input.equals("")) {
				waitForElement(driver, Commodity_Quantity_IMD);
				clearAndType(driver, Commodity_Quantity_IMD, datas1.get(i));
			}
			Step_End(14, "change the quantity", test, test1);
	
			Step_Start(15, "change the volume", test, test1);
	
			waitForElement(driver, Alchohol_Check_Box);
			checkBox(driver, Alchohol_Check_Box, Alchohol_Check_Box_Select);
			waitForElement(driver, MilitaryCargo_Check_Box);
			checkBox(driver, MilitaryCargo_Check_Box, MilitaryCargo_Check_Box_Select);
			if(Package_Input!=null&&!Package_Input.equals("")) {
				waitForElement(driver, Package_Text_Field);
				click(driver, Package_Text_Field); 
				clear(driver, Package_Text_Field);
				sendKeys(driver, Package_Text_Field, datas2.get(i));
				enter(driver);
			}
			if(Comm_Group_Input!=null&&!Comm_Group_Input.equals("")) {
				waitForElement(driver, Comm_Group_Field);
				click(driver, Comm_Group_Field); 
				clear(driver, Comm_Group_Field);
				sendKeys(driver, Comm_Group_Field, datas3.get(i));
				enter(driver);
			}
			if(HS_Code_Input!=null&&!HS_Code_Input.equals("")) {
				waitForElement(driver, HS_Code_Search_IMD);
				click(driver, HS_Code_Search_IMD); 
				
				globalValueSearchWindow(driver, BL_Condition, HS_Code_Select_Type1, datas4.get(i), HS_Code_Select_Type2, HS_Code_Select_Value2, HS_Code_Select_Type3, HS_Code_Select_Value3);
			}
			if(Cargo_Weigt_Input!=null&&!Cargo_Weigt_Input.equals("")) {
				waitForElement(driver, Cargo_Weigt_Field);
				click(driver, Cargo_Weigt_Field); 
				clear(driver, Cargo_Weigt_Field);
				sendKeys(driver, Cargo_Weigt_Field, datas5.get(i));
			}
			if(Net_Weight_Input!=null&&!Net_Weight_Input.equals("")) {
				waitForElement(driver, Net_Weight_Field);
				click(driver, Net_Weight_Field); 
				clear(driver, Net_Weight_Field);
				sendKeys(driver, Net_Weight_Field, datas6.get(i));
			}
			if(Unit_Weight_Type!=null&&!Unit_Weight_Type.equals("")) {
				waitForElement(driver, Unit_Weight_DropDown);
				click(driver, Unit_Weight_DropDown); 
				String Unit_Weightval =  String.format(DropDown_Select, datas7.get(i));
				waitForElement(driver, Unit_Weightval);
				click(driver, Unit_Weightval);
			}
			if(Volume_Input!=null&&!Volume_Input.equals("")) {
				waitForElement(driver, Volume_Field);
				click(driver, Volume_Field); 
				clear(driver, Volume_Field);
				sendKeys(driver, Volume_Field, datas8.get(i));
			}Step_End(15, "change the volume", test, test1);
	
			Step_Start(16, "click the add button", test, test1);
	
			if(Unit_Size_Type!=null&&!Unit_Size_Type.equals("")) {
				waitForElement(driver, Unit_Size_DropDown);
				click(driver, Unit_Size_DropDown); 
				String Unit_Sizesf =  String.format(DropDown_Select, datas9.get(i));
				waitForElement(driver, Unit_Sizesf);
				click(driver, Unit_Sizesf);
			}
			if(Marks_And_Numbers_Input!=null&&!Marks_And_Numbers_Input.equals("")) {
				waitForElement(driver, Marks_Number_Field);
				click(driver, Marks_Number_Field); 
				clear(driver, Marks_Number_Field);
				sendKeys(driver, Marks_Number_Field, datas10.get(i));	
			}
			if(Commodity_Desc_Input!=null&&!Commodity_Desc_Input.equals("")) {
				waitForElement(driver, Comm_Desc_Field);
				click(driver, Comm_Desc_Field); 
				clear(driver, Comm_Desc_Field);
				sendKeys(driver, Comm_Desc_Field, datas11.get(i));	
			}
	
			waitForElement(driver, Commodity_Edit_Button);
			click(driver, Commodity_Edit_Button);
		}
		Step_End(16, "click the add button", test, test1);

		Step_Start(17, "details fetched in below grid", test, test1);
		waitForElement(driver, MCN_Commodity_Table_Headers);
		List<Map<String, String>> MCN_Chareges_Tabledata = getTableData(driver, MCN_Commodity_Table_Headers, MCN_Commodity_Table_Rows);
		List<String> columnheaders = splitAndExpand(MCN_Table_Headers);
		String MCN_Commodity_Tabledata = TableDataForReport(driver, MCN_Chareges_Tabledata,MCN_Table_Name,columnheaders);

		Step_End(17, "details fetched in below grid", test, test1);

		Step_Start(18, "click the save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(18, "click the save button", test, test1);

		Step_Start(19, "system has validate", test, test1);
		waitForPopup(driver, popup_Message, MCN_Refresh_Popup);
		String actual_MCN_Refresh_Popup=getText(driver, popup_Message);
		if (MCN_Refresh_Popup.trim().equals(actual_MCN_Refresh_Popup.trim())) {
			System.out.println("Matched || Expected Popup was : " + MCN_Refresh_Popup + " || Actual Popup was : " + actual_MCN_Refresh_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + MCN_Approved_msg + " || Actual Popup was : " + actual_MCN_Refresh_Popup, test,
					test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + MCN_Refresh_Popup + " || Actual Popup was : " + actual_MCN_Refresh_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + MCN_Refresh_Popup + " || Actual Popup was : " + actual_MCN_Refresh_Popup,
					test, test1);

		}
		Step_End(19, "system has validate", test, test1);

		Step_Start(20, "Body Tab details not refreshed. Use right click to refresh OK-click ok", test, test1);
		Step_Start(21, "go to Body tab edit button has enable.", test, test1);
		Step_Start(22, "click the edit", test, test1);

		waitForElement(driver, Body_Edit_Button);
		click(driver, Body_Edit_Button);
		Step_End(20, "Body Tab details not refreshed. Use right click to refresh OK-click ok", test, test1);

		Step_End(21, "go to Body tab edit button has enable.", test, test1);
		Step_End(22,"click the edit", test, test1);

		Step_Start(23, "Do you want to edit Body Details? This will be validated in the approval process YES OR NO  ", test, test1);
		
		waitForPopup(driver, popup_Message,MCN_Do_You_want_Edit_Popup);//code modified here by vignesh on 12.04.2025
		String act_text_popup = getText(driver, popup_Message);
		if(act_text_popup.equals(MCN_Do_You_want_Edit_Popup)) {
			System.out.println("Matched || Expected popup : "+MCN_Do_You_want_Edit_Popup+" || Actual : the actual popup value was : "+act_text_popup);
			Extent_pass_New(driver, "Matched || Expected popup : "+MCN_Do_You_want_Edit_Popup+" || Actual : the actual popup value was : "+act_text_popup, test, test1);
		}else {
			System.out.println("Not Matched || Expected popup : "+MCN_Do_You_want_Edit_Popup+" || Actual : the actual popup value was : "+act_text_popup);
			Extent_fail(driver, "Not Matched || Expected popup : "+MCN_Do_You_want_Edit_Popup+" || Actual : the actual popup value was : "+act_text_popup, test, test1);
		}
		
		Step_End(23, "Do you want to edit Body Details? This will be validated in the approval process YES OR NO  ", test, test1);
		Step_Start(24, "click the yes", test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		Step_End(24,"click the yes", test, test1);

		Step_Start(25, "right click in body tab", test, test1);

		waitForElement(driver, Text_Area);
		RightClick(driver, Text_Area);
		Step_End(25, "right click in body tab", test, test1);

		Step_Start(26, " cargo description ,weight refresh and container summary referesh words are heighlightes red color.", test, test1);
		Step_End(26, " cargo description ,weight refresh and container summary referesh words are heighlightes red color.", test, test1);

		Step_Start(27, "click the refresh all", test, test1);

		waitForElement(driver, Refresh_All_Button);
		click(driver, Refresh_All_Button);
		Step_End(27, "click the refresh all", test, test1);

		Step_Start(28, "latest details updtede in body tab.", test, test1);
		Step_End(28, "latest details updtede in body tab.", test, test1);

		Step_Start(29, "click the save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(29,"click the save button	", test, test1);

		Step_Start(30, "Do you want to save as Pending or Submit or Cancel for process?\r\n"
				+ "Pending---  Submit-- Cancel--button has enable", test, test1);

		waitForDisplay(driver, Manifest_Pending_Button);
		if (IsElementEnabled(driver, Manifest_Pending_Button)) {
			System.out.println("Expected Result : Pending Button Should be Enabled || Actual Result : Pending button is enabled ");
			Extent_pass_New(driver, "Expected Result : Pending Button Should be Enabled || Actual Result : Pending button is enabled ", test, test1);
		} else {
			System.out.println("Expected Result : Pending Button Should be Enabled || Actual Result : Pending button is disabled ");
			Extent_fail(driver, "Expected Result : Pending Button Should be Enabled || Actual Result : Pending button is disabled ", test, test1);
		}
		waitForDisplay(driver, Manifest_Submit_Button);
		if (IsElementEnabled(driver, Manifest_Submit_Button)) {
			System.out.println("Expected Result : Submit Button Should be Enabled || Actual Result : Submit button is enabled ");
			Extent_pass_New(driver, "Expected Result : Submit Button Should be Enabled || Actual Result : Submit button is enabled ", test, test1);
		} else {
			System.out.println("Expected Result : Submit Button Should be Enabled || Actual Result : Submit button is disabled ");
			Extent_fail(driver, "Expected Result : Submit Button Should be Enabled || Actual Result : Submit button is disabled ", test, test1);
		}
		waitForDisplay(driver, Manifest_Cancel_Button);
		if (IsElementEnabled(driver, Manifest_Cancel_Button)) {
			System.out.println("Expected Result : Cancel Button Should be Enabled || Actual Result : Cancel button is enabled ");
			Extent_pass_New(driver, "Expected Result : Cancel Button Should be Enabled || Actual Result : Cancel button is enabled ", test, test1);
		} else {
			System.out.println("Expected Result : Cancel Button Should be Enabled || Actual Result : Cancel button is disabled ");
			Extent_fail(driver, "Expected Result : Cancel Button Should be Enabled || Actual Result : Cancel button is disabled ", test, test1);
		}
		
		Step_End(30, "Do you want to save as Pending or Submit or Cancel for process?\r\n"
				+ "Pending---  Submit-- Cancel--button has enable", test, test1);

		Step_Start(31, "click the submit button.", test, test1);

		waitForElement(driver, Manifest_Submit_Button);
		click(driver, Manifest_Submit_Button);
		Step_End(31, "click the submit button.", test, test1);

		Step_Start(32, "system will popluate the mcn remarks window", test, test1);

		waitForElement(driver, Remarks_Field);
		if(isdisplayed(driver, Internal_Option_Remark_MCN)) {
			waitForElement(driver, Internal_Option_Remark_MCN);
			click(driver,Internal_Option_Remark_MCN);
		}
		Step_End(32, "system will popluate the mcn remarks window", test, test1);

		Step_Start(33, "enter the remarks ---click the okay button", test, test1);

		sendKeys(driver, Remarks_Field, MCN_Remarks_Input);
		click(driver, Remarks_OK_Button);
		Step_End(33, "enter the remarks ---click the okay button", test, test1);

		Step_Start(34, "System has validate -Submitted. MCN is moved to approval process OK button", test, test1);

		waitForDisplay(driver, popup_Message);
		if(isDisplayed(driver, popup_Message)) {
			String act_text = getText(driver, popup_Message);
			System.out.println("Matched || Expected popup : MCN is moved to approval process || Actual ; the actual popup value was : "+act_text);
			Extent_pass_New(driver, "Matched || Expected popup : MCN is moved to approval process || Actual ; the actual popup value was : "+act_text, test, test1);
			Step_Start(35, "click the ok ", test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(35, "click the ok ", test, test1);
		}
		Step_End(34, "System has validate -Submitted. MCN is moved to approval process OK button", test, test1);


		Step_Start(36, "clcik the edit button in tool bar", test, test1);

		if(isdisplayed(driver, Mail_Cancel_button)) {
			waitForElement(driver, Mail_Cancel_button);
			click(driver, Mail_Cancel_button);
		}

		waitForElement(driver, status_Tab_MCN);
		click(driver, status_Tab_MCN);
		waitForElement(driver, status_Tab_TableRow_MCN);
		List<Map<String, String>> statusTable_Data = getTableData(driver, status_Tab_TableColumn_MCN, status_Tab_TableRow_MCN);
		List<String> statusTableHeader = splitAndExpand(Status_Tab_Table_Headers);
		List<String> entity = getValuesByHeader(statusTable_Data, statusTableHeader.get(0));
		List<String> status = getValuesByHeader(statusTable_Data, statusTableHeader.get(1));
		waitForElement(driver, Master_Tab_MCN);
		click(driver, Master_Tab_MCN);
		waitForElement(driver, POL_Value);
		String origin_Port = getText(driver, POL_Value);
		String final_Port = getText(driver, PLD_Location_MCN);
		String discharge_Port=getText(driver, pod_Port_MCN);
		String DOC_Port = getAttribute(driver, Doc_Agency, "value");
		String Issue_Agency= getAttribute(driver, BL_Issue_Agency_MCN, "value");
		
		String actual_MCN_Number=getAttribute(driver, MCN_Number_Textfield_MCN_Module, "value");
		System.out.println("Generarted MCN Number : "+actual_MCN_Number);
		
		waitForElement(driver, Manifest_Charges_Tab);
		click(driver, Manifest_Charges_Tab);
		waitForElement(driver, MCN_Charges_Table_Headers);
		List<Map<String, String>> MCN_Chareges_Tabledata1 = getTableData(driver, MCN_Charges_Table_Headers,MCN_Charges_Table_Rows);
		String elseWhere_Agency = getValueByFirstColumnPartialValueAndHeader(MCN_Chareges_Tabledata1, "Payment Mode", "PayAt", "Pay Location");
		waitForElement(driver, cancel_Button_MCN);
		click(driver, cancel_Button_MCN);
		click(driver, MCN_Module);
		waitForElement(driver, Close_Current_tab);
		jsClick(driver, Close_Current_tab);
		Step_End(28, "Now in MCN status tab check which are entity are available, if next entity is final port agency", test, test1);
		int no_Of_Rows = entity.size();
		for(int i=1;i<no_Of_Rows;i++) {
			switch (entity.get(i)) {
			case "ORIGIN PORT AGENCY":
				
				String agency = portModule(driver,origin_Port,Ports_Module,BL_Condition,Ports_Search_Type_Select);
				SwitchProfile(driver, agency);
				
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
		
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			case "FINAL PORT AGENCY":
				
				agency = portModule(driver,final_Port,Ports_Module,BL_Condition,Ports_Search_Type_Select);
				SwitchProfile(driver, agency);
				
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
		
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
				
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			case "DISCHARGE PORT AGENCY":
				
				 agency = portModule(driver,discharge_Port,Ports_Module,BL_Condition,Ports_Search_Type_Select);
				 SwitchProfile(driver, agency);
					
				 moduleNavigate(driver, Manifest_Module);
				 
				 waitForElement(driver, SearchButton_Toolbar);
					click(driver,SearchButton_Toolbar);
				 globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
		
				 if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				 }
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			case "DOCUMENTATION AGENCY":
				
				SwitchProfile(driver, DOC_Port);
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
		
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			case "BL ISSUE AGENCY":
				
				SwitchProfile(driver, Issue_Agency);
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
				
			case "ELSE WHERE AGENCY":
				
				agency = portModule(driver,elseWhere_Agency,Ports_Module,BL_Condition,Ports_Search_Type_Select);
				SwitchProfile(driver, agency);
				
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			case "LINE COMMERCIAL":
				ResetProfile(driver);
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
		
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			}
		}
		
		
		Step_Start(50, "open the import documentation module", test, test1);
		SwitchProfile(driver, AgencyUser);

		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(50, "open the import documentation module", test, test1);

		Step_Start(51, "load the bill", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		Step_End(51, "load the bill", test, test1);

		Step_Start(52, "In Import Documentation, the words \"(MCN Available )\" are shown red color.", test, test1);
		Step_End(52, "In Import Documentation, the words \"(MCN Available )\" are shown red color.", test, test1);

		Step_Start(53, "Click the Edit button in the toolbar search.", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(53, "Click the Edit button in the toolbar search.", test, test1);

		Step_Start(54, " The system will display the following validation message:  \r\n"
				+ "   \"MCN is available for this BL. Import documentation should be refreshed.\"  \r\n"
				+ "   Below are checkboxes:\r\n"
				+ "   1. All\r\n"
				+ "   2. Charges\r\n"
				+ "   3. Customer\r\n"
				+ "   4. Container & Commodity \r\n"
				+ "   5. Commodity (automatically marked)\r\n"
				+ "   6. BL/House BL Summary  \r\n"
				+ "   Refresh or Cancel\r\n"
				+ "", test, test1);

		waitForPopup(driver, Refresh_Popup,Refresh_Popup_Msg);
		String actual_Refresh_Popup=getText(driver, Refresh_Popup);
		if (Refresh_Popup_Msg.trim().equals(actual_Refresh_Popup.trim())) {
			System.out.println("Matched || Expected Popup was : " + Refresh_Popup_Msg + " || Actual Popup was : " + actual_Refresh_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + Refresh_Popup_Msg + " || Actual Popup was : " + actual_Refresh_Popup, test,test1);
			Step_End(54, " The system will display the following validation message:  \r\n"
					+ "   \"MCN is available for this BL. Import documentation should be refreshed.\"  \r\n"
					+ "   Below are checkboxes:\r\n"
					+ "   1. All\r\n"
					+ "   2. Charges\r\n"
					+ "   3. Customer\r\n"
					+ "   4. Container & Commodity \r\n"
					+ "   5. Commodity (automatically marked)\r\n"
					+ "   6. BL/House BL Summary  \r\n"
					+ "   Refresh or Cancel\r\n"
					+ "", test, test1);

			Step_Start(55, "Click the Refresh button.", test, test1);
			click(driver, Refresh_Button);
			Step_End(55, "Click the Refresh button.", test, test1);

			Step_Start(56, "In the Commodity tab, amended commodity row has shown blue  color.", test, test1);

		} else {
			System.out.println("NotMatched || Expected Popup was : " + Refresh_Popup_Msg + " || Actual Popup was : " + actual_Refresh_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + Refresh_Popup_Msg + " || Actual Popup was : " + actual_Refresh_Popup,test, test1);

		}

		waitForElement(driver, Commodity_Tab);
		click(driver, Commodity_Tab);
		scrollBottom(driver);
		String New_Added_rowe =  String.format(New_Added_row, Container_No);
		waitForElement(driver, New_Added_rowe);
		String New_Row_color = getTextBackgroundColor(driver, New_Added_rowe);
		System.out.println("New_Blue_Color : "+New_Row_color);
		String Act_Color=getColorName(New_Row_color);
		
		if (Blue_Color.trim().equalsIgnoreCase(Act_Color.trim())) {
			System.out.println("Matched || The Newly Added Row Color Is Green and the color  is : "+Act_Color);
			Extent_pass_New(driver,"Matched || The Newly Added Row Color Is Green and the color  is : "+Act_Color, test,test1);
		} else {
			System.out.println("Not Matched || The Newly Added Row Color Is Not in Green and the Act color  is : "+Act_Color);
			Extent_fail(driver, "Not Matched || The Newly Added Row Color Is Not in Green and the Act color  is : "+Act_Color,
					test, test1);
		}
		Step_End(56, "In the Commodity tab, amended commodity row has shown blue  color.", test, test1);

		Step_Start(57, "Save the Import Documentation", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(57, "Save the Import Documentation", test, test1);

		Step_Start(58, "once saved the import documentation system has validate import documentation is update", test, test1);

		waitForPopup(driver, popup_Message, Updated_Popup_Msg);
		String actual_Updated_Popup=getText(driver, popup_Message);
		if (Updated_Popup_Msg.trim().equals(actual_Updated_Popup.trim())) {
			System.out.println("Matched || Expected Popup was : " + Updated_Popup_Msg + " || Actual Popup was : " + actual_Updated_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + Updated_Popup_Msg + " || Actual Popup was : " + actual_Updated_Popup, test,test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + Updated_Popup_Msg + " || Actual Popup was : " + actual_Updated_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + Updated_Popup_Msg + " || Actual Popup was : " + actual_Updated_Popup,test, test1);

		}
		Step_End(58, "once saved the import documentation system has validate import documentation is update", test, test1);


		Step_Start(59, "Go to the commodity Tab ", test, test1);
		Step_End(59, "Go to the commodity Tab ", test, test1);

		Step_Start(60, "updated volume and quantity details show from MCN", test, test1);

		scrollBottom(driver);
		
		String addedRow_=String.format(New_Added_row, Container_No);
		
		if(isDisplayed(driver, addedRow_)) {
			System.out.println("Expected Result : Newly Added Charges code Should be shown in the Charges Tab || Actual : Newly Added Charges code shown in the Charges Tab");
			Extent_pass_New(driver, "Expected Result : Newly Added Charges code Should be shown in the Charges Tab || Actual : Newly Added Charges code shown in the Charges Tab", test, test1);
		}else {
			System.out.println("Expected Result : Newly Added Charges code Should be shown in the Charges Tab || Actual : Newly Added Charges code not shown in the Charges Tab");
			Extent_fail(driver, "Expected Result : Newly Added Charges code Should be shown in the Charges Tab || Actual : Newly Added Charges code not shown in the Charges Tab", test, test1);
		}
		Step_End(60, "updated volume and quantity details show from MCN", test, test1);

		Step_Start(61, "Verify import documentation ,Commodity tab volume and quantity  details shown correclty from MCN.", test, test1);
		waitForElement(driver, Commodity_Table_Header);
		List<Map<String, String>> customer_Tabledata = getTableData(driver, Commodity_Table_Header, Commodity_Table_Row);
		List<String> columnheader = splitAndExpand(Table_Headers);
		String Commodity_Tabledata = TableDataForReport(driver, customer_Tabledata,Table_Name,columnheader);
		for (int i=0 ;i<datas.size();i++) {

		String Updated_Quantity=getValueByFirstColumnAndHeader(customer_Tabledata, "Equipment Id", datas.get(i), "Quantity");
		String Updated_Volume=getValueByFirstColumnAndHeader(customer_Tabledata, "Equipment Id", datas.get(i), "Volume");
		
		if (datas1.get(i).trim().equals(Updated_Quantity.trim())) {
			System.out.println("Matched || Expected value was : " + datas1.get(i) + " || Actual value was : " + Updated_Quantity);
			Extent_pass_New(driver, "Matched || Expected value was : " + datas1.get(i) + " || Actual value was : " + Updated_Quantity, test,test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + datas1.get(i) + " || Actual value was : " + Updated_Quantity);
			Extent_fail(driver, "NotMatched || Expected value was : " + datas1.get(i) + " || Actual value was : " + Updated_Quantity,test, test1);
		}
		String[] act_Volueme = Updated_Volume.split("\\.");
		if (datas8.get(i).trim().equals(act_Volueme[0])) {
			System.out.println("Matched || Expected value was : " + datas8.get(i) + " || Actual value was : " + Updated_Volume);
			Extent_pass_New(driver, "Matched || Expected value was : " + datas8.get(i) + " || Actual value was : " + Updated_Volume, test,test1);
			Extent_pass_New(driver,"Matched || MCN Customer Table data was : \n"+ "<pre>" +MCN_Commodity_Tabledata+ "</pre> \n "+ "|| Actual Customer Table data was : \n"+ "<pre>" +Commodity_Tabledata+ "</pre>"    , test, test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + datas8.get(i) + " || Actual value was : " + Updated_Volume);
			Extent_fail(driver, "NotMatched || Expected value was : " + datas8.get(i) + " || Actual value was : " + Updated_Volume,test, test1);

		}
		}
		Step_End(61, "Verify import documentation ,Commodity tab volume and quantity  details shown correclty from MCN.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
