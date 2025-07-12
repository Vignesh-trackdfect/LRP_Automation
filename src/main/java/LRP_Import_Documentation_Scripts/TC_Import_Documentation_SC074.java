package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC074 extends Keywords{
	
	public static String module_Search_Data;
	 public static String	bill_NO;
	public void Import_Documentation_SC074(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC074";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String bill_NO = Excel_data.get("Bill_NO");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String attribute_Data = Excel_data.get("Attribute_Data");
		String global_Value = Excel_data.get("Global_Value");
		String global_Config_Module= Excel_data.get("GlobalConfigurationModule");
		module_Search_Data=Excel_data.get("Module_Search");
		String empty_Column_Check = Excel_data.get("Column_Check");
		String Select_search_value_import = Excel_data.get("Select_search_value_import");
		String default_Value = Excel_data.get("default_Value");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
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
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		
		LRP_Login(driver, Username, Password);
		
		Extent_cal(test, test1, "Checking the visibility of Main menu");

		verifyMainMenu(driver);
		
		Step_Start(1, "Switch the agency and open the global configuration", test, test1);
		SwitchProfile(driver, AgencyUser);
		
		setGlobalConfiguration(driver, global_Config_Module, attribute_Data, global_Value);
		
		moduleNavigate(driver, module_Search_Data);
		
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {

			waitForElement(driver, SearchButton_Toolbar );
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition, Select_search_value_import, bill_NO, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
	
			Step_End(8, "Open the Import Documentation and Retrieve the bill using tool bar search (new bl or already saved bl)", test, test1);

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
		
		deleteSavedBL(driver, "NEW", dropdownCondition, bill_NO);
		
		Step_Start(9, "If the new bill - go to the container tab", test, test1);

		waitForElement(driver,  Container_Tab_IMD);
		click(driver,  Container_Tab_IMD);
		
		Step_End(9, "If the new bill - go to the container tab", test, test1);

		Step_Start(10, "Verify empty return reference new field and below grid empty return reference column has to be shown", test, test1);

		waitForDisplay(driver, empty_Ret_Ref_txtfield);
		if(isdisplayed(driver, empty_Ret_Ref_txtfield)) {
			mouseOverToElement(driver, empty_Ret_Ref_txtfield);
			Extent_pass_New(driver, "Expected : Empty return reference textfield Should be display || Actual : Empty return reference textfield is displayed", test, test1);
			System.out.println("Expected : Empty return reference textfield Should be display || Actual : Empty return reference textfield is displayed");
			scrollBottom(driver);
		}else {
			System.out.println("Expected : Empty return reference textfield Should be display || Actual : Empty return reference textfield is not displayed");
			Extent_fail(driver, "Expected : Empty return reference textfield Should be display || Actual : Empty return reference textfield is not displayed", test, test1);
		}

		Step_End(10, "Verify empty return reference new field and below grid empty return reference column has to be shown", test, test1);

		List<Map<String, String>> tableData = getTableDatawithscroll(driver, Container_Table_Header, Container_Table_Row,Container_Table_Scroll,80,0);
		List<String> verify_Empty_Column = splitAndExpand(empty_Column_Check);
		verifyColumnHeadersIsPresent(driver, tableData, verify_Empty_Column);
		scrollTop(driver);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Step_Start(11, "Open the global configuration", test, test1);		
		Step_Start(12, "Select the condition filter in ag grid option", test, test1);
		Step_Start(13, "Filter the attribute", test, test1);
		Step_Start(14, "Select and double click the attribute - value has shown in above field", test, test1);
		Step_Start(15, "Click the edit button in tool bar", test, test1);
		Step_Start(16, "If the config is amended then change the old value", test, test1);
		Step_Start(17, "Click the save button", test, test1);

		reSetGlobalConfiguration(driver, "Yes", global_Config_Module, attribute_Data, default_Value);
		Step_End(17, "Click the save button", test, test1);
		Step_End(16, "If the config is amended then change the old value", test, test1);
		Step_End(15, "Click the edit button in tool bar", test, test1);
		Step_End(14, "Select and double click the attribute - value has shown in above field", test, test1);
		Step_End(13, "Filter the attribute", test, test1);
		Step_End(12, "Select the condition filter in ag grid option", test, test1);
		Step_End(11, "Open the global configuration", test, test1);		


		Extent_completed(testcase_Name, test, test1);
	}
}
