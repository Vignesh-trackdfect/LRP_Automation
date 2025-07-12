package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC021 extends Keywords {

	public void Import_Documentation_SC021(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Import_Documentation_SC021";
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_ImportDocumentation=Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition");
		String bl_Number=Excel_data.get("BL_Number");
		String module_BillOfLading=Excel_data.get("Module_BillOfLading");
		String ID_container_Table_Headers=Excel_data.get("ID_container_Table_Headers");
		String BL_container_Table_Headers=Excel_data.get("BL_container_Table_Headers");
		String ID_container_Table=Excel_data.get("ID_Table_Name");
		String BL_container_Table=Excel_data.get("BL_Table_Name");
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
		//Login
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		Step_Start(1, "switch to agency", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "switch to agency", test, test1);

		Extent_cal(test, test1, module_ImportDocumentation);
		Step_Start(2, "open the import documentation module", test, test1);
		moduleNavigate(driver, module_ImportDocumentation);
		Step_End(2, "open the import documentation module", test, test1);

		Step_Start(3, ".load the bl in search field", test, test1);
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			waitForElement(driver, SearchButton_Toolbar );
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
			
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
			
				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation = getText(driver, popup_Message);
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup	+ " || Actual Popup was : " + NewImportDocumentation, test, test1);

				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup	+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup	+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
				}
				waitForElement(driver, popup_Message_Yes_Button);
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
		
		Step_End(3, ".load the bl in search field", test, test1);
		
		Step_Start(4, "All datas has to be shown ", test, test1);
		waitForElement(driver, BL_status_IMP_DOC);
		Step_End(4, "All datas has to be shown ", test, test1);
		Step_Start(5, "Go to the container tab", test, test1);
		waitForElement(driver, Container_Tab_IMD);
		click(driver,Container_Tab_IMD);

		Step_End(5, "Go to the container tab", test, test1);
		Step_Start(6, "Equipment ID,equipment type ,carrier and shipper seal ,tare weight,cargo weight,gross weight ", test, test1);
		scrollBottom(driver);
		// Locate the headers table
		List<String> container_headers = splitAndExpand(ID_container_Table_Headers);
		waitForElement(driver, Container_Table_Row);
		List<Map<String, String>> container_data = getTableDatawithscroll(driver, Container_Table_Header, Container_Table_Row,Container_Table_Scroll, 80, -3600);
		String container_Tabledata = TableDataForReport(driver, container_data,ID_container_Table,container_headers);
		List<List<String>> importDocumentation_Container_Table = getValuesByHeaders(container_data, container_headers);
		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver,BL_HBL_Summary_Tab);
		waitForElement(driver, MCN_Text_Field_IMPORT_DOC);
		String MCN_Number = getAttribute(driver, MCN_Text_Field_IMPORT_DOC, "value");
		if(MCN_Number.equals("")) {
			scrollTop(driver);
			Step_End(6, "Equipment ID,equipment type ,carrier and shipper seal ,tare weight,cargo weight,gross weight ", test, test1);
			Step_End(7, "Open the bill of lading module", test, test1);
			Extent_cal(test, test1, "Bill Of Lading");
			moduleNavigate(driver, module_BillOfLading);
			
			Step_End(7, "Open the bill of lading module", test, test1);
			Step_Start(8, "Load the bil in bill of lading module", test, test1);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_BOL, bl_Number, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOL_Select_Value3);

			Step_End(8, "Load the bil in bill of lading module", test, test1);
			Step_Start(9, "Go to the container  tab in bill of lading module", test, test1);

			waitForElement(driver, billOfLading_containerTab);
			click(driver, billOfLading_containerTab);
			Step_End(9, "Go to the container  tab in bill of lading module", test, test1);
			Step_Start(10, "container details has to be shown", test, test1);
			waitForElement(driver, containerTab_Rows_BOL);
			List<Map<String, String>> container_data_BOL = getTableDatawithscroll(driver, containerTab_Coloumns_BOL, containerTab_Rows_BOL,billOfLading_containerTab_Scroll, 80, -4500);
			List<String> BL_Container_Headers = splitAndExpand(BL_container_Table_Headers);
			String container_Tabledata_BOL = TableDataForReport(driver,container_data_BOL ,BL_container_Table,BL_Container_Headers);

			List<List<String>> billOfLading_Container_Table = getValuesByHeaders(container_data_BOL, BL_Container_Headers);
			Extent_cal(test, test1, "-------verify-----\r\n"
					+ "Equipment ID,equipment type ,carrier and shipper seal ,tare weight,cargo weight,gross weight");

			if(compareTableData(importDocumentation_Container_Table, billOfLading_Container_Table))	{
				Extent_pass_New(driver, "Matched || Expected : \n" + "<pre>" +container_Tabledata + "</pre>"+"\n" + " || Actual : \n" + "<pre>" + container_Tabledata_BOL + "</pre>", test, test1);
			}else {
				Extent_fail(driver, "Not Matched || Expected : \n" + "<pre>" +container_Tabledata + "</pre>"+"\n" + " || Actual : \n" + "<pre>" + container_Tabledata_BOL + "</pre>", test, test1);
			}
			Step_End(10, "container details has to be shown", test, test1);
		}else {
			scrollTop(driver);
			Step_End(6, "Equipment ID,equipment type ,carrier and shipper seal ,tare weight,cargo weight,gross weight ", test, test1);
			Step_End(7, "Open the MCN module", test, test1);
			Extent_cal(test, test1, "MCN Module");
			moduleNavigate(driver, MCN_Module);
			Step_End(7, "Open the MCN module", test, test1);
			Step_Start(8, "Load the BL Number in MCN module", test, test1);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);			
			
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_MCN, MCN_Number, MCN_Select_Type2, MCN_Select_Value2, MCN_Select_Type3, MCN_Select_Value3);

			Step_End(8, "Load the BL Number in MCN module", test, test1);
			Step_Start(9, "Go to the container  tab in MCN module", test, test1);

			waitForElement(driver, Manifest_Container_Tab);
			click(driver, Manifest_Container_Tab);
			Step_End(9, "Go to the container  tab in MCN module", test, test1);
			Step_Start(10, "container details has to be shown", test, test1);
			waitForElement(driver, MCN_Container_Tab_Rows);
			List<Map<String, String>> container_data_MCN = getTableDatawithscroll(driver, MCN_Container_Tab_Headers, MCN_Container_Tab_Rows,MCN_Container_Tab_Scroll, 80, -4500);
			List<String> BL_Container_Headers = splitAndExpand(BL_container_Table_Headers);
			String container_Tabledata_BOL = TableDataForReport(driver,container_data_MCN ,BL_container_Table,BL_Container_Headers);

			List<List<String>> billOfLading_Container_Table = getValuesByHeaders(container_data_MCN, BL_Container_Headers);
			Extent_cal(test, test1, "-------verify-----\r\n"+ "Equipment ID,equipment type ,carrier and shipper seal ,tare weight,cargo weight,gross weight");

			if(compareTableData(importDocumentation_Container_Table, billOfLading_Container_Table))	{
				Extent_pass_New(driver, "Matched || Expected : \n" + "<pre>" +container_Tabledata + "</pre>"+"\n" + " || Actual : \n" + "<pre>" + container_Tabledata_BOL + "</pre>", test, test1);
			}else {
				Extent_fail(driver, "Not Matched || Expected : \n" + "<pre>" +container_Tabledata + "</pre>"+"\n" + " || Actual : \n" + "<pre>" + container_Tabledata_BOL + "</pre>", test, test1);
			}
			Step_End(10, "container details has to be shown", test, test1);
		}
		Extent_completed(testCaseName, test, test1);
	}
}