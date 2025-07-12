package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC075  extends Keywords{
	
	public void Import_Documentation_SC075(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC075";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String SavedPopup = Excel_data.get("SavedPopup");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalID = Excel_data.get("GlobalID");
		String GlobalValue = Excel_data.get("GlobalValue");
		String Empty_reference_value = Excel_data.get("Empty_reference_value");
		String coloum_name = Excel_data.get("coloum_name");
		String container_gird_click = Excel_data.get("container_gird_click");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String Select_search_value_import = Excel_data.get("Select_search_value_import");
		String updated_Popup = Excel_data.get("updated_Popup");
		String popup_After_Delete_Expected = Excel_data.get("popup_After_Delete_Expected");
		String popup_After_Delete_Expected1 = Excel_data.get("popup_After_Delete_Expected1");
		String default_Value = Excel_data.get("default_Value");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String do_you_want_to_delete = Excel_data.get("do_you_want_to_delete");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		 
		Extent_Start(testcase_Name, test, test1);
	   	navigateUrl(driver, url);
	   	LRP_Login(driver, Username, Password);
	   	
	   	Extent_cal(test, test1, "Checking the visibility of Main menu");
	   	
	   	verifyMainMenu(driver);
	   	
	   	Extent_call(test, test1, "********** Switch the Profile - Start **********");
	  
	   	Step_Start(1, "switch the agency and open the global configuration", test, test1);
	   	
	   	SwitchProfile(driver, AgencyUser);
		
	   	Extent_call(test, test1, "********** Switch the Profile - End **********");	
	   	Extent_call(test, test1, "********** Enter Import Documentation Module **********");
	   	
	   	setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue);
	   		
		moduleNavigate(driver, ImportDocumentationModule);
		
		boolean new_status=false;
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {

			waitForElement(driver, SearchButton_Toolbar );
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, BL_Condition, Select_search_value_import, BL_Num, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
				
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
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
				twoColumnSearchWindow(driver, Pol_Header, Condition_Filter, pol_Value);
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
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, BL_Num);
			
		}

		waitForDisplay(driver, BL_status_IMP_DOC);
		String BL_Value=getText(driver, BL_status_IMP_DOC);
		if(!BL_Value.equalsIgnoreCase("NEW")) {
			System.out.println("bl was already saved");
		}else {
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		waitForElement(driver, Edit_Button_toolBar);
		if(isClickable(driver, Edit_Button_toolBar)) {
			click(driver, Edit_Button_toolBar);
		}

		Step_End(8, "open the Import Documentation and Retrieve the bill using tool bar search.(new bill or saved bl )",
				test, test1);

		Step_Start(9, "go to the container tab", test, test1);

		waitForElement(driver,  Container_Tab_IMD);
		click(driver,  Container_Tab_IMD);

		Step_End(9, "go to the container tab", test, test1);

		Step_Start(10, "empty return reference new field and below grid column has to be shown", test, test1);
		
		waitForElement(driver, empty_Ret_Ref_txtfield);
		if(isDisplayed(driver, empty_Ret_Ref_txtfield)) {
			
			Extent_pass_New(driver, "Expected : Empty return reference textfield Should be display || Actual : Empty return reference textfield is displayed", test, test1);
			System.out.println("Expected : Empty return reference textfield Should be display || Actual : Empty return reference textfield is displayed");
			scrollBottom(driver);

		}else {
			System.out.println("Expected : Empty return reference textfield Should be display || Actual : Empty return reference textfield is not displayed");
			Extent_fail(driver, "Expected : Empty return reference textfield Should be display || Actual : Empty return reference textfield is not displayed", test, test1);
		}
		
		waitForElement(driver, commodity_Table_Body);
		if(isDisplayed(driver, commodity_Table_Body)) {
			
			Extent_pass_New(driver, "Expected : commodity_Table_Body  Should be display || Actual : commodity_Table_Body is displayed", test, test1);
			System.out.println("Expected : commodity_Table_Body  Should be display || Actual : commodity_Table_Body is displayed");
			scrollBottom(driver);

		}else {
			System.out.println("Expected : commodity_Table_Body  Should be display || Actual : commodity_Table_Body is not displayed");
			Extent_fail(driver, "Expected : commodity_Table_Body  Should be display || Actual : commodity_Table_Body is not displayed", test, test1);
		}
		
		Step_End(10, "empty return reference new field and below grid column has to be shown", test, test1);
		
		List<String> selective_Containers = splitAndExpand(container_gird_click);
		List<String> Empty_reference_value_datas = splitAndExpand(Empty_reference_value);

		for(int i=0;i<selective_Containers.size();i++) {
			
			scrollBottom(driver);
			 String equipment_id_click = String.format(ImportDocumentation_Locators.container_gird_table_click, selective_Containers.get(i));

				Step_Start(11, "in below grid container has to be shown then Select the Container number Passed via Test Data and double click the container", test, test1);

			waitForElement(driver, equipment_id_click);
			doubleClick(driver, equipment_id_click);
			
			Step_End(11, "in below grid container has to be shown then Select the Container number Passed via Test Data and double click the container", test, test1);

			Step_Start(12, "enter the empty reference no and click the edit button same as other container also", test, test1);
			

			waitForElement(driver, Empty_reference_input_IMP);
			
			if(!Empty_reference_value_datas.get(i).trim().equals("")) {
			clearAndType(driver, Empty_reference_input_IMP,Empty_reference_value_datas.get(i));
			}
			waitForElement(driver, Container_Edit_Button);
			click(driver, Container_Edit_Button);
			
			Step_End(12, "enter the empty reference no and click the edit button same as other container also", test, test1);

		}
		
		Step_Start(13, "saved the import documentation", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		Step_End(13, "saved the import documentation", test, test1);

		Step_Start(14, "system should be validate import documentation is saved", test, test1);

		waitForPopup(driver, popup_Message, SavedPopup);

		String BL_StatusValue = getText(driver, popup_Message);

		if (new_status) {

			if (BL_StatusValue.equalsIgnoreCase(SavedPopup)) {
				System.out.println(
						"Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + SavedPopup);
				Extent_pass_New(driver,
						"Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + SavedPopup,
						test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				safeclick(driver, popup_Message_Ok_Button);


			} else {
				System.out.println("NotMatched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : "
						+ SavedPopup);
				Extent_fail(driver,
						"NotMatched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + SavedPopup,
						test, test1);

			}
			
		}else {
			
			if (BL_StatusValue.equalsIgnoreCase(updated_Popup)) {
				System.out.println(
						"Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + updated_Popup);
				Extent_pass_New(driver,"Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + updated_Popup,test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				safeclick(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : "
						+ updated_Popup);
				Extent_fail(driver,"NotMatched || Expected value was : " + BL_StatusValue + " || Actual value was : " + updated_Popup,test, test1);

			}			
		}
		
		Step_End(14, "system should be validate import documentation is saved", test, test1);

		Step_Start(15, "Verify that empty reference value has shown in container tab below grid", test, test1);
		
		scrollBottom(driver);
		for(int k=0;k<selective_Containers.size();k++) {
			
		List<Map<String, String>> container_table_data = getTableDatawithscroll(driver, Container_Table_Header, Container_Table_Row, Container_Table_Scroll, 80, 3500);
		String empty_ref_value_actual = getValueByFirstColumnAndHeader(container_table_data, "Equipment Id", selective_Containers.get(k), coloum_name);
		
		System.out.println("actual empty reference value is: "+empty_ref_value_actual);
		
	if(!Empty_reference_value_datas.get(k).trim().equals("")) {
		 String expected_empty_ref_value = Empty_reference_value_datas.get(k);
		if(empty_ref_value_actual.equals(expected_empty_ref_value)) {
	   		System.out.println("Matched || Expected value was : " + expected_empty_ref_value + " || Actual value was : " + empty_ref_value_actual);
			Extent_pass_New(driver, "Matched || Expected value was[***Value was takem from data sheet***] : " + expected_empty_ref_value + " || Actual value was [***Value was takem from gird empty return***]: " + empty_ref_value_actual, test,
					test1);

		} else {
			System.out.println("Not Matched || Expected value was : " + expected_empty_ref_value + " || Actual value was : " + empty_ref_value_actual);
			Extent_fail(driver, "Not Matched || Expected value was[***Value was takem from data sheet***] : " + expected_empty_ref_value + " || Actual value was[***Value was takem from gird empty return***] : " + empty_ref_value_actual,
					test, test1);
			
	   	}	}
		Step_End(11, "Verify that empry reference value has shown in container tab below grid .", test, test1);

		}
		Step_End(15, "Verify that empty reference value has shown in container tab below grid", test, test1);

		Step_Start(16, "click the delete icon and system has validate( Do you want to delete import documentation )? -> YES or N0", test, test1);
		Step_Start(17, "click the yes and system has validate import documentation is deleted", test, test1);

		scrollTop(driver);		
		if(do_you_want_to_delete.equalsIgnoreCase("yes")) {
			deleteImportDocument(driver, popup_After_Delete_Expected, popup_After_Delete_Expected1);		
		}
		Step_End(16, "click the delete icon and system has validate( Do you want to delete import documentation )? -> YES or N0", test, test1);
		Step_End(17, "click the yes and system has validate import documentation is deleted", test, test1);

		//reset the global data 
		
		Step_Start(18, "Open the global configuration", test, test1);
		
		reSetGlobalConfiguration(driver, "Yes", GlobalConfigurationModule, GlobalID, default_Value);
		Step_End(18, "Open the global configuration", test, test1);

		Extent_completed(testcase_Name, test, test1);
	
	}
}
