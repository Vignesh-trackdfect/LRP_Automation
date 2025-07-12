package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC020 extends Keywords {

	public void Import_Documentation_SC020(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Import_Documentation_SC020";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String importDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String master_BL_Status = Excel_data.get("Master_BL_Status");
		String BillOfLadingModule = Excel_data.get("BillOfLadingModule");
		String ID_Table_Headers=Excel_data.get("ID_Customer_Table_Headers");
		String BL_Table_Headers=Excel_data.get("BL_Customer_Table_Headers");
		String ID_Table_Name=Excel_data.get("ID_Table_Name");
		String BL_Table_Name=Excel_data.get("BL_Table_Name");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String globalSearchFilterOption_IMD=Excel_data.get("GlobalSearchFilterOption_IMD");
		String globalSearchFilterOption_BOL=Excel_data.get("GlobalSearchFilterOption_BOL");
		String MCN_Module=Excel_data.get("MCN_Module");
		String MCN_Table_Headers=Excel_data.get("MCN_Customer_Table_Headers");
		String conditionFilter=Excel_data.get("ConditionFilter");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Terminal = Excel_data.get("Terminal");
		String Port = Excel_data.get("Port");
		String all_Dropdown_1 = Excel_data.get("All_Dropdown_1");
		String all_Dropdown_2 = Excel_data.get("All_Dropdown_2");
		String POL_Loction = Excel_data.get("POL_Loction");
		String BL_Retrieve_Option = Excel_data.get("BL_Retrieve_Option");
		String wantToDelete = Excel_data.get("WantToDelete");
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
		String MCN_Select_Type1=Excel_data.get("MCN_Select_Type1");
		String MCN_Select_Type2=Excel_data.get("MCN_Select_Type2");
		String MCN_Select_Value2=Excel_data.get("MCN_Select_Value2");
		String MCN_Select_Type3=Excel_data.get("MCN_Select_Type3");
		String MCN_Select_Value3=Excel_data.get("MCN_Select_Value3");

		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		Step_Start(1, "switch to agency ", test, test1);
		SwitchProfile(driver, agencyUser);
		
		Step_End(1, "switch to agency ", test, test1);
		Step_Start(2, "open the import documentation module", test, test1);	
		
		moduleNavigate(driver, importDocumentationModule);
		
		Step_End(2, "open the import documentation module", test, test1);
		Step_Start(3, "load the bl in search field", test, test1);
		
		if(BL_Retrieve_Option.equals("By Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
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
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Port);
			}
			
			if(!Terminal.trim().equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 300);
				waitForElement(driver, grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
			}
			
			waitForElement(driver, Select_Service_Details);
			click(driver,Select_Service_Details);
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			
			if(!POL_Loction.trim().equals("")) {
				waitForElement(driver, POLSearch);
				safeclick(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, conditionFilter, POL_Loction);
			}
						
			waitForElement(driver, all_Dropdown_1_IMD);
			click(driver, all_Dropdown_1_IMD);
			
			String select_All_Dropdown_1_Option=String.format(all_Dropdown_1_Option_IMD, all_Dropdown_1);
			waitForElement(driver, select_All_Dropdown_1_Option);
			click(driver, select_All_Dropdown_1_Option);
			
			waitForElement(driver, all_Dropdown_2_IMD);
			click(driver, all_Dropdown_2_IMD);
			
			String select_All_Dropdown_2_Option=String.format(all_Dropdown_2_Option_IMD, all_Dropdown_2);
			waitForElement(driver, select_All_Dropdown_2_Option);
			click(driver, select_All_Dropdown_2_Option);
			
			waitForElement(driver, Show_BL_Button);
			safeclick(driver, Show_BL_Button);
			
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, conditionFilter, globalSearch_Number);

		}else if(BL_Retrieve_Option.equals("By BL")) {
				
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, globalSearch_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
		}
		
		Step_End(3, "load the bl in search field", test, test1);
		Step_Start(4, "bl is new status then go the BL/HBL summary tab-MCN  field -value is available or not. \r\n"
				+ "/if the bill is already saved , edit and then go to theBL/HBL summary tab-MCN  field -value is available or not", test, test1);
		
		Step_Start(5, "if MCN number available capture the MCN no and bill no", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status = getText(driver, BL_status_IMP_DOC);
		String MCN_Number = "";
		if (actual_Master_BL_Status.equals(master_BL_Status)) {
			waitForElement(driver, BL_HBL_Summary_Tab);
			click(driver,BL_HBL_Summary_Tab);
			waitForElement(driver, MCN_Text_Field_IMPORT_DOC);
			MCN_Number = getAttribute(driver, MCN_Text_Field_IMPORT_DOC, "value");
			if(MCN_Number.equals("")) {
				System.out.println("Actual MCN Number : "+MCN_Number);
				Extent_pass_New(driver, "Actual MCN Number : "+MCN_Number, test, test1);
			}
		}else{
			
			waitForElement(driver, BL_HBL_Summary_Tab);
			click(driver,BL_HBL_Summary_Tab);
			waitForElement(driver, MCN_Text_Field_IMPORT_DOC);
			MCN_Number = getAttribute(driver, MCN_Text_Field_IMPORT_DOC, "value");
			
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			if(MCN_Number.equals("")) {
				System.out.println("Actual MCN Number : "+MCN_Number);
				Extent_pass_New(driver, "Actual MCN Number : "+MCN_Number, test, test1);
			}
		}


		Step_End(4, "bl is new status then go the BL/HBL summary tab-MCN  field -value is available or not. \r\n"
				+ "/if the bill is already saved , edit and then go to theBL/HBL summary tab-MCN  field -value is available or not", test, test1);
		Step_End(5, "if MCN number available capture the MCN no and bill no", test, test1);
				
		Step_Start(6, "go to the customers tab", test, test1);
		scrollBottom(driver);
		waitForElement(driver, Customer_Tab_IMD);
		safeclick(driver, Customer_Tab_IMD);
		Step_End(6, "go to the customers tab", test, test1);
		
		Step_Start(7, "Customer type ,system code ,name ,address1,city , country, and Email  has shown.", test, test1);
	
		
		waitForElement(driver, Customer_Table_Header);
		List<Map<String, String>> ID_Customer_Tabledata = getTableData(driver, Customer_Table_Header, Customer_Table_Row);
		List<String> columnheaders = splitAndExpand(ID_Table_Headers);
		String customer_Tabledata = TableDataForReport(driver, ID_Customer_Tabledata,ID_Table_Name,columnheaders);//Assuming you have these lists
		List<String> ID_Customer_Types_List = new ArrayList<>();
		// Loop through each row of data
		for (int i = 0; i < ID_Customer_Tabledata.size(); i++) {
			Map<String, String> row = ID_Customer_Tabledata.get(i);
			// Store values in the respective lists
			ID_Customer_Types_List.add(row.get("Customer Type"));
		}
		
		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver,BL_HBL_Summary_Tab);
		waitForElement(driver, MCN_Text_Field_IMPORT_DOC);
		MCN_Number = getAttribute(driver, MCN_Text_Field_IMPORT_DOC, "value");
		
		Step_End(7, "Customer type ,system code ,name ,address1,city , country, and Email  has shown.", test, test1);
		Step_Start(8, "save the import documentation.--in customer tab -capture the value - Customer type ,system code ,name ,address1,city , country, and Email ", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		Step_End(8, "save the import documentation.--in customer tab -capture the value - Customer type ,system code ,name ,address1,city , country, and Email ", test, test1);

		if(!MCN_Number.equals("")) {
			scrollTop(driver);
			
			Step_Start(9, "open the Manifest correction notes module", test, test1);
			
			Extent_cal(test, test1, MCN_Module);
			moduleNavigate(driver, MCN_Module);

			Step_End(9, "open the Manifest correction notes module", test, test1);
			Step_Start(10, "retrive the bill no or MCN no in manifest correction notes module", test, test1);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, MCN_Select_Type1, MCN_Number, MCN_Select_Type2, MCN_Select_Value2, MCN_Select_Type3, MCN_Select_Value3);
			
			Step_End(10, "retrive the bill no or MCN no in manifest correction notes module", test, test1);
			Step_Start(11, "go to the customer tab capture the value and match with import documentation.", test, test1);

			waitForElement(driver, customer_Tab_MCN);
			click(driver, customer_Tab_MCN);
			
			List<Map<String, String>> MCN_Customer_Tabledata = getTableData(driver, customer_Tab_Column_MCN, customer_Tab_Row_MCN);
			List<String> MCN_columnheaders = splitAndExpand(MCN_Table_Headers);
			String MCN_Tabledata = TableDataForReport(driver, MCN_Customer_Tabledata,BL_Table_Name,MCN_columnheaders);//Assuming you have these lists
			List<String> MCN_Customer_Types_List = new ArrayList<>();
			// Loop through each row of data
			for (int i = 0; i < MCN_Customer_Tabledata.size(); i++) {
				Map<String, String> row = MCN_Customer_Tabledata.get(i);
				// Store values in the respective lists
				MCN_Customer_Types_List.add(row.get("Customer Type"));
			}
			if(ID_Customer_Types_List.equals(MCN_Customer_Types_List)) {
				Extent_pass_New(driver,"Matched || Expexted : \n"+ "<pre>" +customer_Tabledata + "</pre>" +"|| Actual : \n"+ "<pre>" +MCN_Tabledata+ "</pre>"  , test, test1);
				}else {
				System.out.println("Not matched || ID Customer Type:"+ID_Customer_Types_List +"    ||    BL Customer type:"+ MCN_Customer_Types_List);
				Extent_fail(driver,"Not Matched || ID Customer Type:"+ID_Customer_Types_List +"    ||    BL Customer type:"+ MCN_Customer_Types_List , test, test1);
			}
			
			waitForElement(driver, cancel_Button_MCN);
			click(driver, cancel_Button_MCN);
			
			Step_End(11, "go to the customer tab capture the value and match with import documentation.", test, test1);

		}else {
			scrollTop(driver);
			Step_Start(8, "Open the bill of lading module", test, test1);

			Extent_cal(test, test1, BillOfLadingModule);
			moduleNavigate(driver, BillOfLadingModule);
			
			waitForDisplay(driver, billOfLading_Tab);
			if (isDisplayed(driver, billOfLading_Tab)) {
				System.out.println("Expected Result : "+BillOfLadingModule+" module should be Open || Actual result : "+BillOfLadingModule+" module is opened");
				Extent_pass_New(driver, "Expected Result : "+BillOfLadingModule+" module should be Open || Actual result : "+BillOfLadingModule+" module is opened", test, test1);
			} else {
				System.out.println("Expected Result : "+BillOfLadingModule+" module should be Open || Actual result : "+BillOfLadingModule+" module is not opened");
				Extent_fail(driver, "Expected Result : "+BillOfLadingModule+" module should be Open || Actual result : "+BillOfLadingModule+" module is not opened", test, test1);
			}
			
			Step_End(8, "Open the bill of lading module", test, test1);
			Step_Start(9, "Load the bil in bill of lading module", test, test1);
		
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_BOL, globalSearch_Number, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOL_Select_Value3);

			Step_End(9, "Load the bil in bill of lading module", test, test1);
			Step_Start(10, "Go to the container  tab in bill of lading module", test, test1);

			waitForElement(driver, BL_customerTab);
			click1(driver, BL_customerTab);
			Step_End(10, "go to the customer tab in bill of lading module", test, test1);
			waitForElement(driver, BL_customerTab);

			Step_Start(11,"go to the customer tab capture the value and match with import documentation.", test, test1);


			List<Map<String, String>> BL_Customer_Tabledata = getTableData(driver, BL_Customer_Table_Header, BL_Customer_Table_Row);
			List<String> BL_columnheaders = splitAndExpand(BL_Table_Headers);
			String BL_Tabledata = TableDataForReport(driver, BL_Customer_Tabledata,BL_Table_Name,BL_columnheaders);//Assuming you have these lists
			List<String> BL_Customer_Types_List = new ArrayList<>();
			// Loop through each row of data
			for (int i = 0; i < BL_Customer_Tabledata.size(); i++) {
				Map<String, String> row = BL_Customer_Tabledata.get(i);
				// Store values in the respective lists
				BL_Customer_Types_List.add(row.get("Customer Type"));
			}
			if(ID_Customer_Types_List.equals(BL_Customer_Types_List)) {
				Extent_pass_New(driver,"Matched || Expexted : \n"+ "<pre>" +customer_Tabledata + "</pre>" +"|| Actual : \n"+ "<pre>" +BL_Tabledata+ "</pre>"  , test, test1);
				}else {
				System.out.println("Not matched || ID Customer Type:"+ID_Customer_Types_List +"       ||      BL Customer type:"+ BL_Customer_Types_List);
				Extent_fail(driver,"Not Matched || ID Customer Type:"+ID_Customer_Types_List +"       ||      BL Customer type:"+ BL_Customer_Types_List , test, test1);
			}

			Step_End(11,"go to the customer tab capture the value and match with import documentation.", test, test1);
		}

		Extent_call(test, test1, "once match with bl/MCN and import documnetation.\r\n"+ "delete the bl in import documenation.");
		scrollTop(driver);
		
		if(wantToDelete.equalsIgnoreCase("Yes")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Extent_call(test, test1, "once match with bl/MCN and import documnetation.\r\n"+ "delete the bl in import documenation.");

		Extent_completed(testCaseName, test, test1);

	}
}
