package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC076 extends Keywords{
	
	public static String module_Search_Data;
	public static String empty_Column_Check;
	 public static String	bill_NO;
	public void Import_Documentation_SC076(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC076";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String attribute_Data = Excel_data.get("Attribute_Data");
		String global_Value = Excel_data.get("Global_Value");
		String global_Config_Module= Excel_data.get("GlobalConfigurationModule");
		bill_NO = Excel_data.get("Bill_NO");
		module_Search_Data=Excel_data.get("Module_Search");
		empty_Column_Check = Excel_data.get("Column_Check");
		String Select_search_value_import = Excel_data.get("Select_search_value_import");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String SavedPopup = Excel_data.get("SavedPopup");
		String updated_Popup = Excel_data.get("updated_Popup");
		String do_you_want_to_delete = Excel_data.get("do_you_want_to_delete");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);	
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		
		LRP_Login(driver, Username, Password);
		
		verifyMainMenu(driver);
		Step_Start(1, "Switch the agency and open the global configuration", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency and open the global configuration", test, test1);

		Extent_call(test, test1, "opening the glbal config module");
		
	   	setGlobalConfiguration(driver, global_Config_Module, attribute_Data, global_Value);
			
		moduleNavigate(driver, module_Search_Data);
		boolean new_status=false;

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, BL_Condition, Select_search_value_import, bill_NO, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
			
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			
			newButton(driver);
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
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, bill_NO);

		}
		waitForDisplay(driver, BL_status_IMP_DOC);
		String BL_Value=getText(driver, BL_status_IMP_DOC);
		if(!BL_Value.equalsIgnoreCase("NEW")) {
			waitForElement(driver, Edit_Button_toolBar);
			if(isClickable(driver, Edit_Button_toolBar)) {
				click(driver, Edit_Button_toolBar);
			}
		}else {
			new_status=true;
		}
		
		Step_End(8, "Open the Import Documentation and Retrieve the bill using tool bar search (new bill or saved bill)", test, test1);

		Step_Start(9, "Go to the container tab", test, test1);

		waitForElement(driver,  Container_Tab_IMD);
		click(driver,  Container_Tab_IMD);
		
		Step_End(9, "Go to the container tab", test, test1);

		Step_Start(10, "Verify: Empty return reference new field and below grid column has not shown in the container tab", test, test1);
		
		waitForDisplay(driver, empty_Ret_Ref_txtfield);
		if(isdisplayed(driver, empty_Ret_Ref_txtfield)) {
			System.out.println("Expected : Empty return reference textfield Should not be display || Actual : Empty return reference textfield is displayed");
			Extent_fail(driver, "Expected : Empty return reference textfield Should not be display || Actual : Empty return reference textfield is displayed", test, test1);
		}else {
			
			Extent_pass_New(driver, "Expected : Empty return reference textfield Should not be display || Actual : Empty return reference textfield is not displayed", test, test1);
			System.out.println("Expected : Empty return reference textfield Should not be display || Actual : Empty return reference textfield is not displayed");
			
			scrollBottom(driver);
		}
		
		waitForElement(driver, Container_Table_Header);
		List<Map<String, String>> tableData = getTableDatawithscroll(driver, Container_Table_Header, Container_Table_Row,Container_Table_Scroll,80,0);
		List<String> verify_Empty_Column = splitAndExpand(empty_Column_Check);
		
		verifyColumnHeadersNotPresent(driver,tableData, verify_Empty_Column);
		Step_End(10, "Verify: Empty return reference new field and below grid column has not shown in the container tab", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, SavedPopup);

		String BL_StatusValue = getText(driver, popup_Message);

		if (new_status) {

			if (BL_StatusValue.equalsIgnoreCase(SavedPopup)) {
				System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + BL_StatusValue);
				Extent_pass_New(driver,"Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + BL_StatusValue,
						test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				safeclick(driver, popup_Message_Ok_Button);


			} else {
				System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : "	+ BL_StatusValue);
				Extent_fail(driver,"NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + BL_StatusValue,
						test, test1);
			}
			
		}else {
			if (BL_StatusValue.equalsIgnoreCase(updated_Popup)) {
				System.out.println(	"Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + updated_Popup);
				Extent_pass_New(driver,"Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + updated_Popup,test, test1);

				waitForElement(driver, popup_Message_Ok_Button);
				safeclick(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : "+ updated_Popup);
				Extent_fail(driver,"NotMatched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + updated_Popup,test, test1);
			}
		}
		
		scrollTop(driver);
		
		if(do_you_want_to_delete.equalsIgnoreCase("yes")) {
			
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
			
		}
		
		//reset the global data 
		Extent_call(test, test1, "Reset the global data ");
		Step_Start(11, "Open the global configuration", test, test1);
		scrollTop(driver);
		reSetGlobalConfiguration(driver, "Yes", global_Config_Module, attribute_Data, global_Value);
		Step_End(11, "Open the global configuration", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
	
}
