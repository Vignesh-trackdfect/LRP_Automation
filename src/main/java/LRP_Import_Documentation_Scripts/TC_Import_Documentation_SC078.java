package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC078 extends Keywords{

	public void Import_Documentation_SC078(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC078";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String BL_Condition = Excel_data.get("BL_Condition");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalID = Excel_data.get("GlobalID");
		String GlobalValue = Excel_data.get("GlobalValue");
		String Container_coulmns_check = Excel_data.get("Container_coulmns_check");
		String GlobalValue1 = Excel_data.get("GlobalValue1");
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
		String UpdatedPopup = Excel_data.get("UpdatedPopup");	
		String SavedPopup = Excel_data.get("SavedPopup");	
		String Delete_Perform = Excel_data.get("Delete_Perform");	
		String Condition = Excel_data.get("Condition");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);		
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);

	   	setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue);

		Step_Start(3, "open the import documentation module", test, test1);		
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(3, "open the import documentation module", test, test1);

		Step_Start(4, "In Import Documentation Retrieve the  bill using tool bar search", test, test1);
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
		
		Step_End(4, "In Import Documentation Retrieve the  bill using tool bar search", test, test1);
		scrollBottom(driver);
		Step_Start(5, "go to the container tab", test, test1);
		waitForElement(driver,  Container_Tab_IMD);
		click(driver,  Container_Tab_IMD);
		
		Step_End(5, "go to the container tab", test, test1);
		
		scrollBottom(driver);
		Step_Start(6, " Colums EX det freedays ,ex sto freedays,imp det free days and imp sto free days column Has not shown under Container Tab", test, test1);
		waitForElement(driver, Container_Table_Header);
		List<Map<String, String>> tableData = getTableDatawithscroll(driver, Container_Table_Header, Container_Table_Row,Container_Table_Scroll,80,-2500);
		List<String> verify_Columns = splitAndExpand(Container_coulmns_check);

		verifyColumnHeadersNotPresent(driver, tableData, verify_Columns);
      Step_End(6, " Colums EX det freedays ,ex sto freedays,imp det free days and imp sto free days column Has not shown under Container Tab", test, test1);
      
      scrollTop(driver);
      waitForElement(driver, BL_status_IMP_DOC);
      String Get_BL_Status = getText(driver, BL_status_IMP_DOC);
      System.out.println("Get_BL_Status:"+ Get_BL_Status);
      
      if(Get_BL_Status.equalsIgnoreCase("NEW")){
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
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
			}

      if(Delete_Perform.equalsIgnoreCase("YES")){
			scrollTop(driver);
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
      }
		waitForElement(driver, Close_Current_tab);
		jsClick(driver, Close_Current_tab);	
		
		
		reSetGlobalConfiguration(driver, "Yes", GlobalConfigurationModule, GlobalID, GlobalValue1);
      
		Extent_completed(testcase_Name, test, test1);

	}

}
