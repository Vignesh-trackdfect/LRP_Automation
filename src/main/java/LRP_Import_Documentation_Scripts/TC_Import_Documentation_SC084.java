package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC084 extends Keywords{

	public void Import_Documentation_SC084(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC084";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String bl_Number = Excel_data.get("BL_Num");
		String BL_Condition = Excel_data.get("BL_Condition");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String module_AgencyConfiguration = Excel_data.get("AgencyConfigurationModule");
		String agencyConfig_Description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String Confguration_Reset = Excel_data.get("Confguration_Reset");
		String attribute = Excel_data.get("Attribute");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String saved_Popup_IMD=Excel_data.get("Saved_Popup_IMD");
		String updatedPopup=Excel_data.get("UpdatedPopup");
		String wantToDelete_Popup_IMD=Excel_data.get("WantToDelete_Popup_IMD");
		String deleted_Popup_IMD=Excel_data.get("Deleted_Popup_IMD");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup").trim();
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String pol_Value=Excel_data.get("pol_Value");
		String Do_You_Want_Delete_Import_Doc=Excel_data.get("Do_You_Want_Delete_Import_Doc");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String reset = Excel_data.get("reset");


		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		Step_Start(1, "switch the agency and .open the  Agency configuration module ", test, test1);

		SwitchProfile(driver, agencyUser);

		// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);
		   List<Boolean> newlyAdded = setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition_Filter, agencyUser, attribute, agencyConfig_Description, value);


		Step_Start(21, "open the Import Documentationmodule and Retrieve the new bill using tool bar search.or retrive the saved bill then click the edit in tool bar and then go the same steps.", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, bl_Number, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if( IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);

				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation = getText(driver, popup_Message);
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation, test, test1);

				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
				}
				safeclick(driver, popup_Message_Yes_Button);
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
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, bl_Number);
		}
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (!house_BL_Status.equalsIgnoreCase("NEW")) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
		}
		Step_Start(21, "open the Import Documentationmodule and Retrieve the new bill using tool bar search.or retrive the saved bill then click the edit in tool bar and then go the same steps.", test, test1);
		scrollBottom(driver);
		Step_Start(22, "after retrieve the new bl,go to the following tab \r\n"
				+ " Customer ,container ,commodity and charge tab ", test, test1);
		Step_Start(23, "first go to the customer tab double click the customer based on data set (For eg:CN) -add button has disable-then click the reset.", test, test1);
		waitForElement(driver, Customer_Tab_IMD);
		click(driver, Customer_Tab_IMD);
		scrollBottom(driver);
		waitForElement(driver, Customer_Table_Row);
		doubleClick(driver, Customer_Table_Row);
		waitForElement(driver, Customer_Add);
		if(!isClickable(driver, Customer_Add)) {
			System.out.println("Expected : Customer Tab Add Button Should be Disabled || Actual : Customer Tab Add Button is disabled ");
			Extent_pass_New(driver, "Expected : Customer Tab Add Button Should be Disabled || Actual : Customer Tab Add Button is disabled ", test, test1);
			waitForElement(driver, customer_Reset_Button_ID);
			click(driver, customer_Reset_Button_ID);
		}else {
			System.out.println("Expected : Customer Tab Add Button Should be Disabled || Actual : Customer Tab Add Button is not disabled ");
			Extent_fail(driver, "Expected : Customer Tab Add Button Should be Disabled || Actual : Customer Tab Add Button is not disabled ", test, test1);
		}
		Step_End(23, "first go to the customer tab double click the customer based on data set (For eg:CN) -add button has disable-then click the reset.", test, test1);
		Step_Start(24, "then go to the container tab doule click the container based on data set (any container no )-editu button has disable-then click the reset.", test, test1);
		waitForElement(driver,  Container_Tab_IMD);
		click(driver,  Container_Tab_IMD);
		scrollBottom(driver);
		waitForElement(driver, Container_Table_Row);
		doubleClick(driver, Container_Table_Row);
		waitForElement(driver, Container_Edit_Button);
		if(!isClickable(driver, Container_Edit_Button)) {
			System.out.println("Expected : Container Tab Edit Button Should be Disabled || Actual : Container Tab Edit Button is disabled ");
			Extent_pass_New(driver, "Expected : Conatiner Tab Edit Button Should be Disabled || Actual : Customer Tab Edit Button is disabled ", test, test1);
			waitForElement(driver, container_Reset_Button_ID);
			click(driver, container_Reset_Button_ID);
		}else {
			System.out.println("Expected : Container Tab Edit Button Should be Disabled || Actual : Container Tab Edit Button is not disabled ");
			Extent_fail(driver, "Expected : Container Tab Edit Button Should be Disabled || Actual : Conatiner Tab Edit Button is not disabled ", test, test1);
		}
		Step_End(24, "then go to the container tab doule click the container based on data set (any container no )-editu button has disable-then click the reset.", test, test1);
		Step_Start(25, "go to the commodity tab doule click the container based on data set (any container no )-editu button has disable-then click the reset", test, test1);
		waitForElement(driver, Commodity_Tab);
		click(driver, Commodity_Tab);
		scrollBottom(driver);
		waitForElement(driver, Commodity_Table_Row);
		doubleClick(driver, Commodity_Table_Row);
		waitForElement(driver, commodity_Edit_Btn);
		if(!isClickable(driver, commodity_Edit_Btn)) {
			System.out.println("Expected : Commodity Tab Edit Button Should be Disabled || Actual : Commodity Tab Edit Button is disabled ");
			Extent_pass_New(driver, "Expected : Commodity Tab Edit Button Should be Disabled || Actual : Commodity Tab Edit Button is disabled ", test, test1);
			waitForElement(driver, commodity_Reset_Button_ID);
			click(driver, commodity_Reset_Button_ID);
		}else {
			System.out.println("Expected : Commodity Tab Edit Button Should be Disabled || Actual : Commodity Tab Edit Button is not disabled ");
			Extent_fail(driver, "Expected : Commodity Tab Edit Button Should be Disabled || Actual : Commodity Tab Edit Button is not disabled ", test, test1);
		}
		Step_End(25, "go to the commodity tab doule click the container based on data set (any container no )-editu button has disable-then click the reset", test, test1);
		Step_Start(26, "go to the charge tab doule click the charge code based on data set (any charge code )-add and remove button has disable-then click the reset", test, test1);
		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);
		scrollBottom(driver);
		waitForElement(driver, Collect_Charges_Table_Row);
		doubleClick(driver, Collect_Charges_Table_Row);
		waitForElement(driver, collect_charges_remove_IMP_DOC);
		if(!isClickable(driver, collect_charges_remove_IMP_DOC)) {
			System.out.println("Expected : Collect Charges Tab Remove Button Should be Disabled || Actual : Collect Charges Tab Remove Button is disabled ");
			Extent_pass_New(driver, "Expected : Collect Charges Tab Remove Button Should be Disabled || Actual : Collect Charges Tab Remove Button is disabled ", test, test1);
			waitForElement(driver, Collect_Charges_Reset_Button);
			click(driver, Collect_Charges_Reset_Button);
		}else {
			System.out.println("Expected : Collect Charges Tab Remove Button Should be Disabled || Actual : Collect Charges Tab Remove Button is not disabled ");
			Extent_fail(driver, "Expected : Collect Charges Tab Remove Button Should be Disabled || Actual : Collect Charges Tab Remove Button is not disabled ", test, test1);
		}
		Step_End(26, "go to the charge tab doule click the charge code based on data set (any charge code )-add and remove button has disable-then click the reset", test, test1);
		Step_Start(27, "save the import documentation", test, test1);
		scrollTop(driver);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}
		Step_End(27, "save the import documentation", test, test1);
		Step_Start(28, "system has validate -Import Documentation is saved.Ok", test, test1);
		if(house_BL_Status.equals(master_BL_Status)) {
			waitForPopup(driver, popup_Message, saved_Popup_IMD);
			String actualPopup=getText(driver, popup_Message);
			if(actualPopup.equals(saved_Popup_IMD)) {
				System.out.println("Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup);
				Extent_pass_New(driver, "Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup, test, test1);
				waitForElement(driver, popup_Message_Ok_Button);safeclick(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup);
				Extent_fail(driver,"Not Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup, test, test1);
			}
		}else {
			waitForPopup(driver, popup_Message, updatedPopup);
			String actualPopup=getText(driver, popup_Message);
			if(actualPopup.equals(updatedPopup)) {
				System.out.println("Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup);
				Extent_pass_New(driver, "Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup, test, test1);
				waitForElement(driver, popup_Message_Ok_Button);safeclick(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup, test, test1);
			}
		}
		Step_End(28, "system has validate -Import Documentation is saved.Ok", test, test1);
		Step_Start(29, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		scrollTop(driver);
		
		waitForDisplay(driver, NewButton_ToolBar);
		if(IsElementEnabled(driver, NewButton_ToolBar)) {
			System.out.println("Expected Result :  New button Should be Enabled || Actual Result : New Button is Enabled ");
			Extent_pass_New(driver, "Expected Result :  New button Should be Enabled || Actual Result : New Button is Enabled", test, test1);
		}else {
			System.out.println("Expected Result :  New button Should be Enabled || Actual Result : New Button is Not Enabled");
			Extent_fail(driver, "Expected Result :  New button Should be Enabled || Actual Result : New Button is Not Enabled", test, test1);
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
		
		// Verifying Edit button is disabled
		waitForElement(driver, Edit_Button_toolBar);
		if(isClickable(driver, Edit_Button_toolBar)) {
			System.out.println("Expected Result :  Edit button Should be Enabled || Actual Result : Edit Button is Enabled ");
			Extent_pass_New(driver, "Expected Result :  Edit button Should be Enabled || Actual Result : Edit Button is Enabled", test, test1);
		}else {
			System.out.println("Expected Result :  Edit button Should be Enabled || Actual Result : Edit Button is Not Enabled");
			Extent_fail(driver, "Expected Result :  Edit button Should be Enabled || Actual Result : Edit Button is Not Enabled", test, test1);
		}	

		// Verifying Delete button is disabled		
		waitForElement(driver, Delete_button_toolBar);
		if(isClickable(driver, Delete_button_toolBar)) {
			System.out.println("Expected Result :  Delete button Should be Enabled || Actual Result : Delete Button is Enabled ");
			Extent_pass_New(driver, "Expected Result :  Delete button Should be Enabled || Actual Result : Delete Button is Enabled", test, test1);
		}else {
			System.out.println("Expected Result :  Delete button Should be Enabled || Actual Result : Delete Button is Not Enabled");
			Extent_fail(driver, "Expected Result :  Delete button Should be Enabled || Actual Result : Delete Button is Not Enabled", test, test1);
		}	

		Step_End(29, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(30, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_Start(31, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

		if(Do_You_Want_Delete_Import_Doc.equalsIgnoreCase("Yes")) {
			deleteImportDocument(driver, wantToDelete_Popup_IMD, deleted_Popup_IMD);
		}
		
		Step_End(30, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_End(31, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		// Agency Configuration
		Extent_cal(test, test1, "Reset Agency Configuration");
		Extent_cal(test, test1, module_AgencyConfiguration);

		reSetAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition_Filter, agencyUser, agencyConfig_Description, Confguration_Reset, newlyAdded, reset);

		Extent_completed(testcase_Name, test, test1);

	}
}
