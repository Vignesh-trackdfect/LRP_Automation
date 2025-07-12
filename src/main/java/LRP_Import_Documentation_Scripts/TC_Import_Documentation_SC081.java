package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC081  extends Keywords{

	public void Import_Documentation_SC081(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC081";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String AgencyConfiguration = Excel_data.get("AgencyConfiguration");
		String description = Excel_data.get("description");
		String attribute = Excel_data.get("attribute");
		String value = Excel_data.get("value");
		String default_value = Excel_data.get("default_value");
		String container_gird_click = Excel_data.get("container_gird_click");
		String UpdatedPopup = Excel_data.get("UpdatedPopup");
		String SavedPopup = Excel_data.get("SavedPopup");
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
		String pol_Value = Excel_data.get("pol_Value");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String Condition = Excel_data.get("Condition");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String reset = Excel_data.get("reset");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		String equipment_id_click = String.format(ImportDocumentation_Locators.commodity_gird_table_click, container_gird_click);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);		
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);
		
		List<Boolean> newlyAdded = setAgencyConfiguration(driver, AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, attribute, description, value);
		
		Step_Start(20, "open the Import Documentation and Retrieve the  new bill using tool bar search", test, test1);
		
		moduleNavigate(driver, ImportDocumentationModule);

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, bl_Number, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);


		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {

			Step_Start(4, "Click the Home button", test, test1);
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
			 twoColumnSearchWindow(driver, BLNumber_Header, Condition, bl_Number);
		}
		
		Step_End(20, "open the Import Documentation and Retrieve the  new bill using tool bar search", test, test1);

		Step_Start(21, "after retrieve the new bl,go to the commodity  tab.or after retrive the already saved bill click the edit in tool bar and then go to the commodity tab", test, test1);

	     scrollBottom(driver);
		waitForElement(driver, Commodity_Tab);
		click(driver, Commodity_Tab);

		Step_End(21, "after retrieve the new bl,go to the commodity  tab.or after retrive the already saved bill click the edit in tool bar and then go to the commodity tab", test, test1);

		Step_Start(22, "in below grid commodity details has shown", test, test1);
		scrollBottom(driver);
		waitForElement(driver, equipment_id_click);
		Step_End(22, "in below grid commodity details has shown", test, test1);

		Step_Start(23, "select and double tick the container below fields are disable cargo weight ,volume, package has disable", test, test1);
		doubleClick(driver, equipment_id_click);

		Step_Start(24, "unable to change the commodity details in commodity", test, test1);
		if(!isClickable(driver, cargo_weight_input)) {
			System.out.println("Expected : Cargo Weight should not be Editable || Actual : Cargo Weight is not Editable ");
			Extent_pass_New(driver, "Expected : Cargo Weight should not be Editable || Actual : Cargo Weight is not Editable ", test, test1);
		}else {
			System.out.println("Expected : Cargo Weight should not be Editable || Actual : Cargo Weight is Editable ");
			Extent_fail(driver, "Expected : Cargo Weight should not be Editable || Actual : Cargo Weight is Editable ", test, test1);
		}
		if(!isClickable(driver, volume_input)) {
			System.out.println("Expected : Volume should not be Editable || Actual : Volume is not Editable ");
			Extent_pass_New(driver, "Expected : Volume should not be Editable || Actual : Volume is not Editable ", test, test1);
		}else {
			System.out.println("Expected : Volume should not be Editable || Actual : Volume is Editable ");
			Extent_fail(driver, "Expected : Volume should not be Editable || Actual : Volume is Editable ", test, test1);
		}

		if(!isClickable(driver, package_search)) {
			System.out.println("Expected : Package should not be Editable || Actual : Volume is not Editable ");
			Extent_pass_New(driver, "Expected : Package should not be Editable || Actual : Volume is not Editable ", test, test1);
		}else {
			System.out.println("Expected : Package should not be Editable || Actual : Volume is Editable ");
			Extent_fail(driver, "Expected : Package should not be Editable || Actual : Volume is Editable ", test, test1);
		}	
		
		waitForElement(driver, Commodity_Tab_Reset_Button);
		click(driver, Commodity_Tab_Reset_Button);
		scrollTop(driver);
		
		Step_End(23, "select and double tick the container below fields are disable cargo weight ,volume, package has disable", test, test1);
		Step_End(24, "unable to change the commodity details in commodity", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (!house_BL_Status.equalsIgnoreCase("NEW")) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
		}
		
		waitForElement(driver, BL_status_IMP_DOC);
		String Get_BL_Status = getText(driver, BL_status_IMP_DOC);
		System.out.println("Get_BL_Status:"+ Get_BL_Status);
		
		Step_Start(25, "save the imp documentation", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

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


		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		

		Step_End(25, "save the imp documentation", test, test1);
		Step_Start(26, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(27, ".click the delete icon and system has validate( Do you want to delete import documentation YES or N0", test, test1);
		Step_Start(28, "click the yes and system has validate import documentation is deleted ..", test, test1);

		if(Delete_Perform.equalsIgnoreCase("YES")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Step_End(26, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_End(27, ".click the delete icon and system has validate( Do you want to delete import documentation YES or N0", test, test1);
		Step_End(28, "click the yes and system has validate import documentation is deleted ..", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_Start(29, "Go to Agency configuration module", test, test1);
		reSetAgencyConfiguration(driver, AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, default_value, newlyAdded, reset);
		Step_End(29, "Go to Agency configuration module", test, test1);

		Extent_completed(testcase_Name, test, test1);


	}
	
}
