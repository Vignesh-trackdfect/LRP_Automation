package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC063 extends Keywords {

	public void Import_Documentation_SC063(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		//		Get data from test data
		String testcase_Name="TC_Import_Documentation_SC063";
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_ImportDocumentation=Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition=Excel_data.get("GlobalSearchDropdownCondition");
		String bl_Number=Excel_data.get("BL_Number");
		String module_BillOfLading=Excel_data.get("Module_BillOfLading");
		String ID_Commodity_Table_Headers=Excel_data.get("ID_Commodity_Table_Headers");
		String BL_Commodity_Table_Headers=Excel_data.get("BL_Commodity_Table_Headers");
		String ID_Table_Name=Excel_data.get("ID_Table_Name");
		String BL_Table_Name=Excel_data.get("BL_Table_Name");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
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
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String ImportDoc_Select_Type2 = Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Value2 = Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Type3 = Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value3 = Excel_data.get("ImportDoc_Select_Value3");
		String BL_No_Search = Excel_data.get("BL_No_Search");
		String BOL_Select_Type2 = Excel_data.get("BOL_Select_Type2");
		String BOL_Select_Value2 = Excel_data.get("BOL_Select_Value2");
		String BOL_Select_Type3 = Excel_data.get("BOL_Select_Type3");
		String BOLSelect_Value3 = Excel_data.get("BOLSelect_Value3");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);
		//		Login
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, agencyUser);

		Extent_cal(test, test1, module_ImportDocumentation);

		Step_Start(1, "Open Import Documentation module", test, test1);
		moduleNavigate(driver, module_ImportDocumentation);
		Step_End(1, "Open Import Documentation module", test, test1);

		Step_Start(2, "CLick Search Button and Load the BL No", test, test1);
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, dropdownCondition, Select_Search_Type_Import_Doc, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);


		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if( IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation = getText(driver, popup_Message);
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected value was : " + NewImportDocumentationPopup+ " || Actual value was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected value was : " + NewImportDocumentationPopup+ " || Actual value was : " + NewImportDocumentation, test, test1);
	
				} else {
					System.out.println("NotMatched || Expected value was : " + NewImportDocumentationPopup	+ " || Actual value was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected value was : " + NewImportDocumentationPopup	+ " || Actual value was : " + NewImportDocumentation, test, test1);
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
		
		Step_End(2, "CLick Search Button and Load the BL No", test, test1);
		Step_Start(3, "Go to the Reference tab", test, test1);
		waitForElement(driver, Reference_Tab_IMD);
		click(driver, Reference_Tab_IMD);
		Step_End(3, "Go to the Reference tab", test, test1);
		Step_Start(4, "In Reference  tab,reference name and reference value has shown", test, test1);
		scrollBottom(driver);
		waitForElement(driver, ID_Reference_Table_Header);
		List<Map<String, String>> commodity_Tabledata = getTableData(driver, ID_Reference_Table_Header, ID_Reference_Table_Row);
		List<String> columnheaders = splitAndExpand(ID_Commodity_Table_Headers);
		String commodity_Table = TableDataForReport(driver, commodity_Tabledata,ID_Table_Name,columnheaders);
		//Assuming you have these lists
		List<String> commodity_EquipmentIds = new ArrayList<>();
		// Loop through each row of data
		for (int i = 0; i < commodity_Tabledata.size(); i++) {
			Map<String, String> row = commodity_Tabledata.get(i);
			// Store values in the respective lists
			commodity_EquipmentIds.add(row.get("Reference Name"));
			// Append the values in a formatted manner
		}
		Step_End(4, "In Reference  tab,reference name and reference value has shown", test, test1);
		Step_Start(5, "open the bill of lading module", test, test1);
		Extent_cal(test, test1, module_BillOfLading);
		moduleNavigate(driver, module_BillOfLading);
		
		Step_End(5, "open the bill of lading module", test, test1);
		Step_Start(6, "load the bl in bill module", test, test1);
		scrollTop(driver);
		click(driver, SearchButton_Toolbar);
		waitForElement(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, BL_No_Search, bl_Number, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOLSelect_Value3);
		
		Step_End(6, "load the bl in bill module", test, test1);
		//Bill Of Lading
		Step_Start(7, "go to the ref and status ", test, test1);

		waitForElement(driver, BL_Reference_Tab);
		click(driver, BL_Reference_Tab);
		Step_End(7, "go to the ref and status ", test, test1);
		Step_Start(8, "value has to shown in ref and status tab", test, test1);

		scrollBottom(driver);
		waitForElement(driver, BL_Reference_Table_Header);
		List<Map<String, String>> billOfLading_Commodity = getTableData(driver, BL_Reference_Table_Header, BL_Reference_Table_Row);
		List<String> BL_columnheaders = splitAndExpand(BL_Commodity_Table_Headers);
		String BL_Commodity_Tabledata = TableDataForReport(driver, billOfLading_Commodity,BL_Table_Name,BL_columnheaders);
		//Assuming you have these lists
		List<String> commodity_EquipmentIds_BOL = new ArrayList<>();
		// Loop through each row of data
		for (int i = 0; i < billOfLading_Commodity.size(); i++) {
			Map<String, String> row = billOfLading_Commodity.get(i);
			// Store values in the respective lists
			commodity_EquipmentIds_BOL.add(row.get("Reference Name"));
			// Append the values in a formatted manner
		}
		Step_End(8, "value has to shown in ref and status tab", test, test1);
		Step_Start(9, "Capture the Values in Import Doc module and Capture value in BL module and Compare Both", test, test1);
		if(commodity_EquipmentIds_BOL.equals(commodity_EquipmentIds))	{
			Extent_pass_New(driver,"Matched || Expexted : \n"+ "<pre>" +commodity_Table + "</pre>" +"|| Actual : \n"+ "<pre>" +BL_Commodity_Tabledata+ "</pre>"  , test, test1);
		}else {
			System.out.println("Not Matched || EquipmentID in Import Documentation Module:"+commodity_EquipmentIds+"|| EquipmentID in Bill of Lading Module:"+commodity_EquipmentIds_BOL);
			Extent_fail(driver, "Not Matched || EquipmentID in Import Documentation Module:"+commodity_EquipmentIds+"|| EquipmentID in Bill of Lading Module:"+commodity_EquipmentIds_BOL, test, test1);
		}
		Step_End(9, "Go to the Commodity  tab in bill of lading module", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
