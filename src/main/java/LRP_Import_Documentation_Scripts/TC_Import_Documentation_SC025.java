package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC025 extends Keywords {

	public void Import_Documentation_SC025(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		//		Get data from test data
		String testcase_Name="TC_Import_Documentation_SC025";
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_ImportDocumentation=Excel_data.get("Module_ImportDocumentation");
		String bl_Number=Excel_data.get("BL_Number");
		String module_BillOfLading=Excel_data.get("Module_BillOfLading");
		String ID_Table_Headers=Excel_data.get("ID_Charges_Table_Headers");
		String BL_Table_Headers=Excel_data.get("BL_Charges_Table_Headers");
		String ID_Table_Name=Excel_data.get("ID_Table_Name");
		String BL_Table_Name=Excel_data.get("BL_Table_Name");
		String dropdownCondition=Excel_data.get("GlobalSearchDropdownCondition");
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
		String pol_Value=Excel_data.get("pol_Value");
		String ConditionFilter=Excel_data.get("ConditionFilter");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
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
		String Charges_Table_Headers_MCN=Excel_data.get("Charges_Table_Headers_MCN");
		String Table_Name_MCN=Excel_data.get("Table_Name_MCN");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		//		Login
		navigateUrl(driver,url);

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
			globalValueSearchWindow(driver, dropdownCondition, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
			
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
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
		Step_End(3, "load the bl in search field", test, test1);

		Step_Start(4, "bl is new status then go the BL/HBL summary tab-MCN  field -value is available or not. \r\n"
				+ "/if the bill is already saved , edit and then go to theBL/HBL summary tab-MCN  field -value is available or not", test, test1);
		scrollTop(driver);
		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver,BL_HBL_Summary_Tab);
		waitForElement(driver, MCN_Text_Field_IMPORT_DOC);
		String MCN_Number = getAttribute(driver, MCN_Text_Field_IMPORT_DOC, "value");
		
		Step_End(4, "bl is new status then go the BL/HBL summary tab-MCN  field -value is available or not. \r\n"
				+ "/if the bill is already saved , edit and then go to theBL/HBL summary tab-MCN  field -value is available or not", test, test1);
	
		Step_Start(5, "Go to the Prepaid charge tab", test, test1);
		scrollBottom(driver);
		waitForElement(driver, Prepaid_Charges_Tab);
		click(driver, Prepaid_Charges_Tab);
		Step_End(5, "Go to the Prepaid charge tab", test, test1);
		
		Step_Start(6, "prepaid and pay at charges has shown", test, test1);
		Step_Start(7, "ave the import documentation.--capture the value in prepaid charges tab- charge code,base rate,quanity ,amount,currency,pay location,pay by .", test, test1);

		scrollBottom(driver);
		waitForElement(driver, importDocumentation_PrepaidCharges_Rows);

		List<Map<String, String>> prepaid_Tabledata = getTableData(driver, importDocumentation_PrepaidCharges_Columns, importDocumentation_PrepaidCharges_Rows);
		List<String> columnheaders = splitAndExpand(ID_Table_Headers);
		String Charges_Tabledata = TableDataForReport(driver, prepaid_Tabledata,ID_Table_Name,columnheaders);
		
		List<List<String>> Expected_Details_ImpDoc=getValuesByHeaders(prepaid_Tabledata,columnheaders);
		Step_End(6, "prepaid and pay at charges has shown", test, test1);
		Step_End(7, "ave the import documentation.--capture the value in prepaid charges tab- charge code,base rate,quanity ,amount,currency,pay location,pay by .", test, test1);

		
		if(MCN_Number.equals("")) {
			//Bill Of Lading
			Step_Start(8, "Open the bill of lading module", test, test1);
			Extent_cal(test, test1, module_BillOfLading);
	
			moduleNavigate(driver, module_BillOfLading);
	
			Step_End(8, "Open the bill of lading module", test, test1);
			Step_Start(9, "Load the bil in bill of lading module", test, test1);
	
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition, Select_Search_Type_BOL, bl_Number, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOL_Select_Value3);
	
			Step_End(9, "Load the bil in bill of lading module", test, test1);
			Step_Start(10, "go the charges tab and capture only payment mode as prepaid and payat charges code,base rate,quanity ,amount,currency,pay location,pay by .and match with import documentation.", test, test1);
			waitForElement(driver, billOfLading_ChargesTab);
			click(driver, billOfLading_ChargesTab);
			scrollBottom(driver);
			waitForElement(driver, chargesTab_Rows_BOL);
			List<Map<String, String>> billOfLading_Charges = getTableDatawithscroll(driver, chargesTab_Coloumns_BOL, chargesTab_Rows_BOL,billOfLading_ChargesTab_Scroll,80,-2500);
			List<String> BL_columnheaders = splitAndExpand(BL_Table_Headers);
		
			String firstcolumnHeader = "Payment Mode";
			String firstColumnValue = "Collect"; 
			List<List<String>> Actual_Values_BOL=getValuesExceptColumnAndHeaders(billOfLading_Charges,firstcolumnHeader,firstColumnValue,BL_columnheaders);
			String BL_charges_Tabledata = TableDataForReport1(driver, Actual_Values_BOL,BL_Table_Name,BL_columnheaders);

			Extent_call(test, test1, "----------verify-----\r\n"
					+ "charge code,base rate,quanity ,amount,currency,pay location,pay by Value");
	
			if(compareTableData(Expected_Details_ImpDoc,Actual_Values_BOL))	{
				Extent_pass_New(driver,"Matched || Expexted : \n"+ "<pre>" +Charges_Tabledata + "</pre>" +"|| Actual : \n"+ "<pre>" +BL_charges_Tabledata+ "</pre>"  , test, test1);
			}else {
				Extent_fail(driver," Not Matched || Expexted : \n"+ "<pre>" +Charges_Tabledata + "</pre>" +"|| Actual : \n"+ "<pre>" +BL_charges_Tabledata+ "</pre>"  , test, test1);
				}	
			Step_End(10, "go the charges tab and capture only payment mode as prepaid and payat charges code,base rate,quanity ,amount,currency,pay location,pay by .and match with import documentation.", test, test1);
		}else {
			scrollTop(driver);
			Step_Start(8, "Open the MCN module", test, test1);
			Extent_cal(test, test1, "MCN Lading");
			moduleNavigate(driver, MCN_Module);
			Step_End(8, "Open the MCN module", test, test1);
			Step_Start(9, "Load the BL in MCN module", test, test1);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);			
			
			globalValueSearchWindow(driver, dropdownCondition, Select_Search_Type_MCN, MCN_Number, MCN_Select_Type2, MCN_Select_Value2, MCN_Select_Type3, MCN_Select_Value3);

			Step_End(9, "Load the BL in MCN module", test, test1);
			Step_Start(10, "go the charges tab and capture only payment mode as prepaid and payat charges code,base rate,quanity ,amount,currency,pay location,pay by .and match with import documentation.", test, test1);

			waitForElement(driver, Manifest_IMO_Tab);
			click(driver, Manifest_IMO_Tab);
			waitForElement(driver, Manifest_Charges_Tab);
			List<Map<String, String>> Charges_data_MCN = getTableData(driver, MCN_Charges_Table_Headers,MCN_Charges_Table_Rows);
			List<String> IMO_Headers = splitAndExpand(Charges_Table_Headers_MCN);

			String firstcolumnHeader = "Payment Mode";
			String firstColumnValue = "Collect"; 
			List<List<String>> Actual_Values_MCN=getValuesExceptColumnAndHeaders(Charges_data_MCN,firstcolumnHeader,firstColumnValue,IMO_Headers);
			String IMO_Table_MCN = TableDataForReport1(driver, Actual_Values_MCN,Table_Name_MCN,IMO_Headers);						
			Extent_cal(test, test1, "-------verify-----\r\n"+ "Equipment ID,equipment type ,carrier and shipper seal ,tare weight,cargo weight,gross weight");
			if(compareTableData(Expected_Details_ImpDoc,Actual_Values_MCN))	{
				Extent_pass_New(driver, "Matched || Expected : \n" + "<pre>" +Charges_Tabledata + "</pre>"+"\n" + " || Actual : \n" + "<pre>" + IMO_Table_MCN + "</pre>", test, test1);
			}else{
				Extent_fail(driver, "Not Matched || Expected : \n" + "<pre>" +Charges_Tabledata + "</pre>"+"\n" + " || Actual : \n" + "<pre>" + IMO_Table_MCN + "</pre>", test, test1);
			}
			Step_End(10, "go the charges tab and capture only payment mode as prepaid and payat charges code,base rate,quanity ,amount,currency,pay location,pay by .and match with import documentation.", test, test1);

		}
		Extent_completed(testcase_Name, test, test1);
	}
}
