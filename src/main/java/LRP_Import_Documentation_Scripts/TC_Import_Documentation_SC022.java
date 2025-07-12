package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC022 extends Keywords {

	public void Import_Documentation_SC022(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from test data
		String testCaseName="TC_Import_Documentation_SC022";
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_ImportDocumentation=Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition=Excel_data.get("GlobalSearchDropdownCondition");
		String bl_Number=Excel_data.get("BL_Number");
		String module_BillOfLading=Excel_data.get("Module_BillOfLading");
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
		String MCN_Module=Excel_data.get("MCN_Module");
		String Select_Search_Type_MCN=Excel_data.get("Select_Search_Type_MCN");
		String Select_Search_Type_BOL=Excel_data.get("Select_Search_Type_BOL");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String ID_Commodity_Table_Headers=Excel_data.get("ID_Commodity_Table_Headers");
		String BL_Commodity_Table_Headers=Excel_data.get("BL_Commodity_Table_Headers");
		String ID_Table_Name=Excel_data.get("ID_Table_Name");
		String BL_Table_Name=Excel_data.get("BL_Table_Name");
		String pol_Value=Excel_data.get("pol_Value");
		String ConditionFilter=Excel_data.get("ConditionFilter");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String BOL_Select_Type2=Excel_data.get("BOL_Select_Type2");
		String BOL_Select_Value2=Excel_data.get("BOL_Select_Value2");
		String BOL_Select_Type3=Excel_data.get("BOL_Select_Type3");
		String BOL_Select_Value3=Excel_data.get("BOL_Select_Value3");
		String MCN_Select_Type2=Excel_data.get("MCN_Select_Type2");
		String MCN_Select_Value2=Excel_data.get("MCN_Select_Value2");
		String MCN_Select_Type3=Excel_data.get("MCN_Select_Type3");
		String MCN_Select_Value3=Excel_data.get("MCN_Select_Value3");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver,url);

		//		Login

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		Step_Start(1, "switch to agency", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "switch to agency", test, test1);
		
		Extent_cal(test, test1, module_ImportDocumentation);
		Step_Start(2, "open the import documentation module", test, test1);
		moduleNavigate(driver, module_ImportDocumentation);
		Step_End(2, "open the import documentation module", test, test1);

		Step_Start(3, "load the bl in search field", test, test1);
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			waitForElement(driver, SearchButton_Toolbar );
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition, Select_Search_Type_Import_Doc, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
			
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if( IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
			
				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation = getText(driver, popup_Message);
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
	
				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
				}
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
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
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, ConditionFilter, pol_Value);
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
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, ConditionFilter, bl_Number);
		}
		
		Step_End(3, "Load the BL in search field ", test, test1);

		Step_Start(4, "bl is new status then go the BL/HBL summary tab-MCN  field -value is available or not. ", test, test1);

		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver,BL_HBL_Summary_Tab);
		waitForElement(driver, MCN_Text_Field_IMPORT_DOC);
		String MCN_Number = getAttribute(driver, MCN_Text_Field_IMPORT_DOC, "value");
		Step_End(4, "bl is new status then go the BL/HBL summary tab-MCN  field -value is available or not. ", test, test1);

		Step_Start(5, "go to the commodity tab", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (!house_BL_Status.equalsIgnoreCase("NEW")) {
			waitForElement(driver, Edit_Button_toolBar);
			jsClick(driver, Edit_Button_toolBar);
		}
		scrollBottom(driver);
		waitForElement(driver, Commodity_Tab);
		click(driver, Commodity_Tab);
		waitForElement(driver, Commodity_Table_Row);
		Step_End(5, "go to the commodity tab", test, test1);

		Step_Start(6, "Equipment ID,quantity ,package code ,commodity group ,commodity code value has shown", test, test1);

		List<Map<String, String>> commodity_Tabledata = getTableDatawithscroll(driver, Commodity_Table_Header, Commodity_Table_Row,Commodity_Table_Scroll, 80, -2500);
		List<String> columnheaders = splitAndExpand(ID_Commodity_Table_Headers);
		String commodity_Table = TableDataForReport(driver, commodity_Tabledata,ID_Table_Name,columnheaders);
		List<List<String>> importDocumentation_Commodity_Table = getValuesByHeaders(commodity_Tabledata, columnheaders);
		
		if(MCN_Number.equals("")) {
				scrollTop(driver);
			Step_End(6, "Equipment ID,quantity ,package code ,commodity group ,commodity code and description.", test, test1);
			//Bill Of Lading
			Step_Start(7, "Open the bill of lading module", test, test1);
	
			Extent_cal(test, test1, module_BillOfLading);
	
			moduleNavigate(driver, module_BillOfLading);
	
			waitForDisplay(driver, billOfLading_Tab);
			if (isDisplayed(driver, billOfLading_Tab)) {
				System.out.println("Expected Result : "+module_BillOfLading+" module should be Open || Actual result : "+module_BillOfLading+" module is opened");
				Extent_pass_New(driver, "Expected Result : "+module_BillOfLading+" module should be Open || Actual result : "+module_BillOfLading+" module is opened", test, test1);
			} else {
				System.out.println("Expected Result : "+module_BillOfLading+" module should be Open || Actual result : "+module_BillOfLading+" module is not opened");
				Extent_fail(driver, "Expected Result : "+module_BillOfLading+" module should be Open || Actual result : "+module_BillOfLading+" module is not opened", test, test1);
			}
			Step_End(7, "Open the bill of lading module", test, test1);
			Step_Start(8, "Load the bil in bill of lading module", test, test1);
	
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition, Select_Search_Type_BOL, bl_Number, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOL_Select_Value3);

			Step_End(8, "Load the bil in bill of lading module", test, test1);
			Step_Start(9, "Go to the Commodity  tab in bill of lading module", test, test1);
			waitForElement(driver, billOfLading_commodityTab);
			click(driver, billOfLading_commodityTab);
	
			Step_End(9, "Go to the Commodity  tab in bill of lading module", test, test1);
			Step_Start(10, "Commodity details has to be shown", test, test1);
	
			scrollBottom(driver);
			List<Map<String, String>> billOfLading_Commodity = getTableDatawithscroll(driver, commodityTab_Coloumns_BOL, commodityTab_Rows_BOL,billOfLading_commodityTab_Scroll, 80, -2500);
			List<String> BL_columnheaders = splitAndExpand(BL_Commodity_Table_Headers);
			String BL_Commodity_Tabledata = TableDataForReport(driver, billOfLading_Commodity,BL_Table_Name,BL_columnheaders);
			List<List<String>> BL_Commodity_Table = getValuesByHeaders(commodity_Tabledata, columnheaders);
			
			Extent_call(test, test1, "-------verify--------\r\n"
					+ "Equipment ID,quantity ,package code ,commodity group ,commodity code");
			if(Compare_Table_ListsValue(importDocumentation_Commodity_Table, BL_Commodity_Table))	{
				Extent_pass_New(driver,"Matched || Expexted : \n"+ "<pre>" +commodity_Table + "</pre>" +"|| Actual : \n"+ "<pre>" +BL_Commodity_Tabledata+ "</pre>"  , test, test1);
			}else {
				Extent_fail(driver,"Not Matched || Expexted : \n"+ "<pre>" +commodity_Table + "</pre>" +"|| Actual : \n"+ "<pre>" +BL_Commodity_Tabledata+ "</pre>"  , test, test1);
			}
			Step_End(10, "Commodity details has to be shown", test, test1);
		}else {
			scrollTop(driver);
			Step_End(6, "Equipment ID,equipment type ,carrier and shipper seal ,tare weight,cargo weight,gross weight ", test, test1);
			Step_End(7, "Open the MCN module", test, test1);
			Extent_cal(test, test1, "MCN Module");
			moduleNavigate(driver, MCN_Module);
			Step_End(7, "Open the MCN Module ", test, test1);
			Step_Start(8, "Load the bil in MCN Module ", test, test1);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition, Select_Search_Type_MCN, MCN_Number, MCN_Select_Type2, MCN_Select_Value2, MCN_Select_Type3, MCN_Select_Value3);
			
			Step_End(8, "Load the bil in MCN Module ", test, test1);
			
			Step_Start(9, "Go to the container  tab in MCN Module", test, test1);

			waitForElement(driver, Manifest_Commodity_Tab);
			click(driver, Manifest_Commodity_Tab);
			Step_End(9, "Go to the container  tab in bill of lading module", test, test1);
			Step_Start(10, "container details has to be shown", test, test1);
			waitForElement(driver, MCN_Commodity_Table_Headers);
			List<Map<String, String>> container_data_MCN = getTableData(driver, MCN_Commodity_Table_Headers,MCN_Commodity_Table_Rows);
			List<String> BL_Commodity_Headers = splitAndExpand(BL_Commodity_Table_Headers);
			String Commodity_Tabledata_BOL = TableDataForReport(driver,container_data_MCN ,BL_Table_Name,BL_Commodity_Headers);
			List<List<String>> billOfLading_Container_Table = getValuesByHeaders(container_data_MCN, BL_Commodity_Headers);
			Extent_cal(test, test1, "-------verify-----\r\n"+ "Equipment ID,equipment type ,carrier and shipper seal ,tare weight,cargo weight,gross weight");

			if(Compare_Table_ListsValue(importDocumentation_Commodity_Table, billOfLading_Container_Table))	{
				Extent_pass_New(driver, "Matched || Expected : \n" + "<pre>" +commodity_Table + "</pre>"+"\n" + " || Actual : \n" + "<pre>" + Commodity_Tabledata_BOL + "</pre>", test, test1);
			}else{
				Extent_fail(driver, "Not Matched || Expected : \n" + "<pre>" +commodity_Table + "</pre>"+"\n" + " || Actual : \n" + "<pre>" + Commodity_Tabledata_BOL + "</pre>", test, test1);
			}
		}
		Extent_completed(testCaseName, test, test1);
	}
}
