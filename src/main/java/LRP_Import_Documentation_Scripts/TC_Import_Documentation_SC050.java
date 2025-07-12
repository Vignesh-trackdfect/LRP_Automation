package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC050 extends Keywords{

	public void Import_Documentation_SC050(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC050";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String SavedPopup = Excel_data.get("SavedPopup");
		String Export_Agency = Excel_data.get("Export_Agency");
		String Manifest_Module = Excel_data.get("Manifest_Module");
		String Corection_Type_Option = Excel_data.get("Corection_Type_Option");
		String Customer = Excel_data.get("Customer_System_Code");
		String Customer_Type_Option = Excel_data.get("Customer_Type_Option");
		String Customer_Type = Excel_data.get("Customer_Type");
		String MCN_Remarks_Input = Excel_data.get("MCN_Remarks_Input");
		String MCN_Popup_Msg = Excel_data.get("MCN_Popup_Msg");
		String MCN_Approved_msg = Excel_data.get("MCN_Approved_msg");
		String Refresh_Popup_Msg = Excel_data.get("Refresh_Popup_Msg");
		String Updated_Popup_Msg = Excel_data.get("Updated_Popup_Msg");
		String Table_Headers=Excel_data.get("customer_Table_Headers");
		String Table_Name=Excel_data.get("customer_Table_Name");
		String Green_Color=Excel_data.get("Green_Color");
		String MCN_Table_Headers=Excel_data.get("MCN_Charges_Table_Headers");
		String MCN_Table_Name=Excel_data.get("MCN_Chareges_Table_Name");
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String Port = Excel_data.get("Port");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Remove_Charge_perform = Excel_data.get("Remove_Charge_perform");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Import_Documentation_delete_perform = Excel_data.get("Import_Documentation_delete_perform");
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String Customer_Select_Type1=Excel_data.get("Customer_Select_Type1");
		String Customer_Select_Type2=Excel_data.get("Customer_Select_Type2");
		String Customer_Select_Type3=Excel_data.get("Customer_Select_Type3");
		String Customer_Select_Value2=Excel_data.get("Customer_Select_Value2");
		String Customer_Select_Value3=Excel_data.get("Customer_Select_Value3");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String Ports_Module=Excel_data.get("Ports_Module");		
		String Ports_Search_Type_Select=Excel_data.get("Ports_Search_Type_Select");		
		String MCN_Retrive_Type=Excel_data.get("MCN_Retrive_Type");
		String Accepted_Popup=Excel_data.get("Accepted_Popup");		
		String Status_Tab_Table_Headers=Excel_data.get("Status_Tab_Table_Headers");		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);
		Step_Start(1, "open the import documentaiton module.", test, test1);
	
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(1, "open the import documentaiton module.", test, test1);

		Step_Start(2, "load the bl in import documentation module.", test, test1);

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if( IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation=getText(driver, popup_Message).trim();
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation, test,test1);
					safeclick(driver, popup_Message_Yes_Button);
				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation,test, test1);
				}
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
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition_Filter, pol_Value);
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
			
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, Condition_Filter, BL_Num);	

		}

		Step_End(2, "load the bl in import documentation module.", test, test1);

		Step_Start(3, "bl has saved in import documentation.", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status=getText(driver, BL_status_IMP_DOC).trim();
		if (house_BL_Status.equals("NEW")) {
			click(driver, SaveButton_ToolBar);
			waitForPopup(driver, popup_Message, SavedPopup);
			String ImportDocumentationSaved=getText(driver, popup_Message);
			if (SavedPopup.equals(ImportDocumentationSaved)) {
				System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,
						test1);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved,
						test, test1);
			}
		}
		Step_End(3, "bl has saved in import documentation.", test, test1);

		Step_Start(4, "switch to the export agency", test, test1);
		SwitchProfile(driver, Export_Agency);

		Step_End(4, "switch to the export agency", test, test1);

		Step_Start(5, "open the manifest correction notes module (MCN)", test, test1);

		moduleNavigate(driver, Manifest_Module);
		Step_End(5, "open the manifest correction notes module (MCN)", test, test1);

		Step_Start(6, "select the multi correction in correction type field", test, test1);

		waitForElement(driver, Corection_Type_DropDown);
		click(driver, Corection_Type_DropDown);
		formatLocatorClick(driver, correctionType_MCN, Corection_Type_Option);
		Step_End(6, "select the multi correction in correction type field", test, test1);

		Step_Start(7, "load the same bl in bl search field", test, test1);

		waitForElement(driver, BL_Search_Button);
		click(driver, BL_Search_Button);
		
		globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		Step_End(7, "load the same bl in bl search field", test, test1);

		Step_Start(8, "system will be vaidate (Import Doc already saved Do you want to Continue Click Yes and Go)", test, test1);

		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}
		
		Step_End(8, "system will be vaidate (Import Doc already saved Do you want to Continue Click Yes and Go)", test, test1);

		Step_Start(9, "datas fetched all the tabs", test, test1);
		Step_End(9, "datas fetched all the tabs", test, test1);

		Step_Start(10, "go to the customer  tab", test, test1);

		waitForElement(driver, Manifest_Customer_Tab);
		click(driver, Manifest_Customer_Tab); 
		Step_End(10, "go to the customer  tab", test, test1);
		Step_Start(11, "select the Consignee and click the remove button", test, test1);


		if(Remove_Charge_perform.equalsIgnoreCase("YES")) {
			List<String> datas = splitAndExpand(Customer_Type);
			for (int i=0 ;i<datas.size();i++) {

				String Customer_Selectva = String.format(Select_Customer_Row_MCN,datas.get(i));
				waitForElement(driver, Customer_Selectva);
				click(driver, Customer_Selectva); 
				waitForElement(driver, Customer_Remove);
				click(driver, Customer_Remove);
			}
		}


		Step_End(11, "select the Consignee and click the remove button", test, test1);

		Step_Start(12, "consignee row shows red color", test, test1);
		Step_End(12,"consignee row shows red color", test, test1);

		Step_Start(13, "customer type dropdown field -Agreement party,Booking Party,Shipper,Consignee,Notify", test, test1);

		Step_End(13,"customer type dropdown field -Agreement party,Booking Party,Shipper,Consignee,Notify", test, test1);

		Step_Start(14, "select the consignee", test, test1);

		List<String> datas = splitAndExpand(Customer_Type_Option);
		List<String> datas1 = splitAndExpand(Customer);

		for (int i=0 ;i<datas.size();i++) {
			
			waitForElement(driver, Customer_Type_Dropdown);
			click(driver, Customer_Type_Dropdown);  
			
			String Customer_Type_Select =  String.format(DropDown_Select, datas.get(i));
			waitForElement(driver, Customer_Type_Select);
			click(driver, Customer_Type_Select); 
			Step_End(14, "select the consignee", test, test1);

			Step_Start(15, "select the customer name using search field", test, test1);
			Step_Start(16, "once select the customer ", test, test1);
			Step_Start(17, "customer details fetched in following fields Customer,Name,Address,PO BOX No,City,Country,ZIP,Telephone,FAX,MAIL.", test, test1);
			
			if(IsElementEnabled(driver, Manifest_Customer_Search)) {
				waitForElement(driver, Manifest_Customer_Search);
				click(driver, Manifest_Customer_Search); 
				globalValueSearchWindow(driver, BL_Condition, Customer_Select_Type1, datas1.get(i), Customer_Select_Type2, Customer_Select_Value2, Customer_Select_Type3, Customer_Select_Value3);
			}else {
				waitForElement(driver, Customer_Search_Input_MCN);
				Newclear(driver, Customer_Search_Input_MCN);
				sendKeys(driver, Customer_Search_Input_MCN, datas1.get(i));
				formatLocatorClick(driver, Customer_Search_Value_MCN, datas1.get(i));
			}
			
			Step_End(15, "select the customer name using search field", test, test1);

			Step_End(16, "once select the customer ", test, test1);

			Step_End(17, "customer details fetched in following fields Customer,Name,Address,PO BOX No,City,Country,ZIP,Telephone,FAX,MAIL.", test, test1);

			Step_Start(18, "click the add buton", test, test1);

			waitForElement(driver, Customer_Add_Button_MCN);
			click(driver, Customer_Add_Button_MCN);
		}
		Step_End(18, "click the add buton", test, test1);

		Step_Start(19, "details will be fected in the below grid shows greencolor", test, test1);
		Step_End(19, "details will be fected in the below grid shows greencolor", test, test1);

		Step_Start(20, "click the save button in tool bar", test, test1);
		waitForElement(driver, MCN_Customer_Table_Headers);
		List<Map<String, String>> MCN_Chareges_Tabledata = getTableData(driver, MCN_Customer_Table_Headers, MCN_Customer_Table_Rows);
		List<String> columnheaders = splitAndExpand(MCN_Table_Headers);
		String MCN_customer_Tabledata = TableDataForReport(driver, MCN_Chareges_Tabledata,MCN_Table_Name,columnheaders);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(20, "click the save button in tool bar", test, test1);

		Step_Start(21, "system has validate Do you want to save as Pending or Submit or Cancel for process?\\nPending--- \\n Submit-- \\n Cancel--button has enable", test, test1);

		waitForDisplay(driver, Manifest_Pending_Button);
		if (IsElementEnabled(driver, Manifest_Pending_Button)) {
			System.out.println("Expected Result : Pending Button Should be Enabled || Actual Result : Pending button is enabled ");
			Extent_pass_New(driver, "Expected Result : Pending Button Should be Enabled || Actual Result : Pending button is enabled ", test, test1);
		} else {
			System.out.println("Expected Result : Pending Button Should be Enabled || Actual Result : Pending button is disabled ");
			Extent_fail(driver, "Expected Result : Pending Button Should be Enabled || Actual Result : Pending button is disabled ", test, test1);
		}
		waitForDisplay(driver, Manifest_Submit_Button);
		if (IsElementEnabled(driver, Manifest_Submit_Button)) {
			System.out.println("Expected Result : Submit Button Should be Enabled || Actual Result : Submit button is enabled ");
			Extent_pass_New(driver, "Expected Result : Submit Button Should be Enabled || Actual Result : Submit button is enabled ", test, test1);
		} else {
			System.out.println("Expected Result : Submit Button Should be Enabled || Actual Result : Submit button is disabled ");
			Extent_fail(driver, "Expected Result : Submit Button Should be Enabled || Actual Result : Submit button is disabled ", test, test1);
		}
		waitForDisplay(driver, Manifest_Cancel_Button);
		if (IsElementEnabled(driver, Manifest_Cancel_Button)) {
			System.out.println("Expected Result : Cancel Button Should be Enabled || Actual Result : Cancel button is enabled ");
			Extent_pass_New(driver, "Expected Result : Cancel Button Should be Enabled || Actual Result : Cancel button is enabled ", test, test1);
		} else {
			System.out.println("Expected Result : Cancel Button Should be Enabled || Actual Result : Cancel button is disabled ");
			Extent_fail(driver, "Expected Result : Cancel Button Should be Enabled || Actual Result : Cancel button is disabled ", test, test1);
		}
		Step_End(21, "system has validate Do you want to save as Pending or Submit or Cancel for process?\\nPending--- \\n Submit-- \\n Cancel--button has enable", test, test1);

		Step_Start(22, "click the submit button.", test, test1);
		waitForElement(driver, Manifest_Submit_Button);
		click(driver, Manifest_Submit_Button);
		Step_End(22,"click the submit button.", test, test1);

		Step_Start(23, "system will popluate the mcn remarks window", test, test1);

		waitForElement(driver, Remarks_Field);
		if(isdisplayed(driver, Internal_Option_Remark_MCN)) {
			waitForElement(driver, Internal_Option_Remark_MCN);
			click(driver,Internal_Option_Remark_MCN);
		}
		Step_End(23, "system will popluate the mcn remarks window", test, test1);

		Step_Start(24, "enter the remarks ---click the okay button", test, test1);

		sendKeys(driver, Remarks_Field, MCN_Remarks_Input);
		click(driver, Remarks_OK_Button);


		Step_End(24,"enter the remarks ---click the okay button", test, test1);

		Step_Start(25, "System has validate -Submitted. MCN is moved to approval process OK button", test, test1);
		waitForPopup(driver, popup_Message,"MCN is moved to approval process");
		
		Step_End(25, "System has validate -Submitted. MCN is moved to approval process OK button", test, test1);

		Step_Start(26, "click the ok", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(26, "click the ok", test, test1);

		Step_Start(27, "click the edit button in tool bar", test, test1);
		Step_Start(28, "system will be validate --- MCN is moved to FINAL PORT AGENCY for their approval and acceptance OK", test, test1);
		Step_Start(29, "click ok", test, test1);

		if(isdisplayed(driver, Mail_Cancel_button)) {
			waitForElement(driver, Mail_Cancel_button);
			click(driver, Mail_Cancel_button);
		}

		
		waitForElement(driver, status_Tab_MCN);
		click(driver, status_Tab_MCN);
		waitForElement(driver, status_Tab_TableRow_MCN);
		List<Map<String, String>> statusTable_Data = getTableData(driver, status_Tab_TableColumn_MCN, status_Tab_TableRow_MCN);
		List<String> statusTableHeader = splitAndExpand(Status_Tab_Table_Headers);
		List<String> entity = getValuesByHeader(statusTable_Data, statusTableHeader.get(0));
		List<String> status = getValuesByHeader(statusTable_Data, statusTableHeader.get(1));
		waitForElement(driver, Master_Tab_MCN);
		click(driver, Master_Tab_MCN);
		waitForElement(driver, POL_Value);
		String origin_Port = getText(driver, POL_Value);
		String final_Port = getText(driver, PLD_Location_MCN);
		String discharge_Port=getText(driver, pod_Port_MCN);
		String DOC_Port = getAttribute(driver, Doc_Agency, "value");
		String Issue_Agency= getAttribute(driver, BL_Issue_Agency_MCN, "value");
		
		String actual_MCN_Number=getAttribute(driver, MCN_Number_Textfield_MCN_Module, "value");
		System.out.println("Generarted MCN Number : "+actual_MCN_Number);
		
		waitForElement(driver, Manifest_Charges_Tab);
		click(driver, Manifest_Charges_Tab);
		waitForElement(driver, MCN_Charges_Table_Headers);
		List<Map<String, String>> MCN_Chareges_Tabledata1 = getTableData(driver, MCN_Charges_Table_Headers,MCN_Charges_Table_Rows);
		String elseWhere_Agency = getValueByFirstColumnPartialValueAndHeader(MCN_Chareges_Tabledata1, "Payment Mode", "PayAt", "Pay Location");
		waitForElement(driver, cancel_Button_MCN);
		click(driver, cancel_Button_MCN);
		click(driver, MCN_Module);
		waitForElement(driver, Close_Current_tab);
		jsClick(driver, Close_Current_tab);
		Step_End(28, "Now in MCN status tab check which are entity are available, if next entity is final port agency", test, test1);
		int no_Of_Rows = entity.size();
		for(int i=1;i<no_Of_Rows;i++) {
			switch (entity.get(i)) {
			case "ORIGIN PORT AGENCY":
				
				String agency = portModule(driver,origin_Port,Ports_Module,BL_Condition,Ports_Search_Type_Select);
				SwitchProfile(driver, agency);
				
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
		
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			case "FINAL PORT AGENCY":
				
				agency = portModule(driver,final_Port,Ports_Module,BL_Condition,Ports_Search_Type_Select);
				SwitchProfile(driver, agency);
				
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
		
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
				
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			case "DISCHARGE PORT AGENCY":
				
				 agency = portModule(driver,discharge_Port,Ports_Module,BL_Condition,Ports_Search_Type_Select);
				 SwitchProfile(driver, agency);
					
				 moduleNavigate(driver, Manifest_Module);
				 
				 waitForElement(driver, SearchButton_Toolbar);
					click(driver,SearchButton_Toolbar);
				 globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
		
				 if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				 }
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			case "DOCUMENTATION AGENCY":
				
				SwitchProfile(driver, DOC_Port);
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
		
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			case "BL ISSUE AGENCY":
				
				SwitchProfile(driver, Issue_Agency);
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
				
			case "ELSE WHERE AGENCY":
				
				agency = portModule(driver,elseWhere_Agency,Ports_Module,BL_Condition,Ports_Search_Type_Select);
				SwitchProfile(driver, agency);
				
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			case "LINE COMMERCIAL":
				ResetProfile(driver);
				moduleNavigate(driver, Manifest_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, MCN_Retrive_Type, actual_MCN_Number, "", "", "", "");
		
				if(IsElementEnabled(driver, Edit_Button_toolBar)) {
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
				}
				
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					acceptMCN(driver,Accepted_Popup);
					break;
				case "<<Awaiting For Approval>>":
					approveMCN(driver,MCN_Popup_Msg,MCN_Remarks_Input,MCN_Approved_msg);
					break;
				}
				break;
			}
		}
		
		
		Step_Start(40, "open the import documentation module", test, test1);
		SwitchProfile(driver, AgencyUser);

		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(40, "open the import documentation module", test, test1);

		Step_Start(41, "load the bill", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		Step_End(41, "load the bill", test, test1);

		Step_Start(42, "In Import Documentation, the words \"(MCN Available )\" are shown red color.", test, test1);
		Step_End(42, "In Import Documentation, the words \"(MCN Available )\" are shown red color.", test, test1);

		Step_Start(43, "Click the Edit button in the toolbar search", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(43, "Click the Edit button in the toolbar search", test, test1);

		Step_Start(44, "The system will display the following validation message:  \"MCN is available for this BL. Import documentation should be refreshed.\" Below are checkboxes: Click All Check Box  Refresh or Cancel", test, test1);

		waitForPopup(driver, Refresh_Popup,Refresh_Popup_Msg);
		String actual_Refresh_Popup=getText(driver, Refresh_Popup);
		if (Refresh_Popup_Msg.trim().equals(actual_Refresh_Popup.trim())) {
			System.out.println("Matched || Expected Popup was : " + Refresh_Popup_Msg + " || Actual Popup was : " + actual_Refresh_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + Refresh_Popup_Msg + " || Actual Popup was : " + actual_Refresh_Popup, test,test1);
			Step_End(44, "The system will display the following validation message:  \"MCN is available for this BL. Import documentation should be refreshed.\" Below are checkboxes: Click All Check Box  Refresh or Cancel", test, test1);

			Step_Start(45, "Click the Refresh button.", test, test1);

			click(driver, Refresh_Button);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + Refresh_Popup_Msg + " || Actual Popup was : " + actual_Refresh_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + Refresh_Popup_Msg + " || Actual Popup was : " + actual_Refresh_Popup,test, test1);

		}
		Step_End(45, "Click the Refresh button.", test, test1);

		Step_Start(46, " In the Customer tab, Added new Consginee customer row has shown green color.", test, test1);


		waitForElement(driver, Customer_Tab_IMD);
		click(driver, Customer_Tab_IMD);
		scrollBottom(driver);

		List<String> datast = splitAndExpand(Customer_Type);
		for (int i=0 ;i<datast.size();i++) {

			String New_Added_row =  String.format(ImportDocumentation_Locators.New_Added_row2, datast.get(i));

			waitForElement(driver, New_Added_row);
			String New_Row_color = getTextBackgroundColor(driver, New_Added_row);
			System.out.println("New_Green_Color : "+New_Row_color);
			
			String Act_Color=getColorName(New_Row_color);
			if (Green_Color.trim().equalsIgnoreCase(Act_Color)) {
				System.out.println("Matched || The Newly Added Row Color Is Green and the color code is : "+Act_Color);
				Extent_pass_New(driver,"Matched || The Newly Added Row Color Is Green and the color code is : "+Act_Color, test,test1);
			} else {
				System.out.println("Not Matched || The Newly Added Row Color Is Not Green and the color  is : "+Act_Color);
				Extent_fail(driver, "Not Matched || The Newly Added Row Color Is Not Green and the color  is : "+Act_Color,
						test, test1);
			}
			
		}
		scrollTop(driver);
		Step_End(46, " In the Customer tab, Added new Consginee customer row has shown green color.", test, test1);

		Step_Start(47, "Save the Import Documentation.", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(47, "Save the Import Documentation.", test, test1);

		Step_Start(48, "once saved the import documentation system has validate import documentation is update.", test, test1);

		waitForPopup(driver, popup_Message, Updated_Popup_Msg);
		String actual_Updated_Popup=getText(driver, popup_Message);
		if (Updated_Popup_Msg.trim().equals(actual_Updated_Popup.trim())) {
			System.out.println("Matched || Expected Popup was : " + Updated_Popup_Msg + " || Actual Popup was : " + actual_Updated_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + Updated_Popup_Msg + " || Actual Popup was : " + actual_Updated_Popup, test,test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + Updated_Popup_Msg + " || Actual Popup was : " + actual_Updated_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + Updated_Popup_Msg + " || Actual Popup was : " + actual_Updated_Popup,test, test1);

		}
		Step_End(48, "once saved the import documentation system has validate import documentation is update.", test, test1);

		Step_Start(49, "Go to the Customer Tab first grid new consignee customer has shown.green color", test, test1);

		scrollBottom(driver);
		
		List<String> datast1 = splitAndExpand(Customer_Type);
		for (int i=0 ;i<datas.size();i++) {

			String New_Added_row =  String.format(ImportDocumentation_Locators.New_Added_row2, datast1.get(i));
			waitForDisplay(driver, New_Added_row);
			if(isdisplayed(driver, New_Added_row)) {
				System.out.println("Expected Result : Newly Added Charges code Should be shown in the Charges Tab || Actual : Newly Added Charges code shown in the Charges Tab");
				Extent_pass_New(driver, "Expected Result : Newly Added Charges code Should be shown in the Charges Tab || Actual : Newly Added Charges code shown in the Charges Tab", test, test1);
			}else {
				System.out.println("Expected Result : Newly Added Charges code Should be shown in the Charges Tab || Actual : Newly Added Charges code "+datast1.get(i)+"not shown in the Charges Tab");
				Extent_fail(driver, "Expected Result : Newly Added Charges code Should be shown in the Charges Tab || Actual : Newly Added Charges code "+datast1.get(i)+"not shown in the Charges Tab", test, test1);
			}
		}
		Step_End(49, "Go to the Customer Tab first grid new consignee customer has shown.green color", test, test1);

		Step_Start(50, "last  grid  removed consignee customer has shown.", test, test1);
		Step_End(50, "last  grid  removed consignee customer has shown. ", test, test1);

		Step_Start(51, "Verify  import documentation ,Customer tab newly added Customer code has shown from MCN.", test, test1);
		List<String> datast11 = splitAndExpand(Customer);
		List<Map<String, String>> customer_Tabledata = getTableData(driver, Customer_Table_Header, Customer_Table_Row);
		List<String> columnheader = splitAndExpand(Table_Headers);
		String charges_Tabledata = TableDataForReport(driver, customer_Tabledata,Table_Name,columnheader);
		Extent_pass_New(driver,"Matched || MCN Customer Table data was : \n"+ "<pre>" +MCN_customer_Tabledata+ "</pre> \n "+ "|| Actual Customer Table data was : \n"+ "<pre>" +charges_Tabledata+ "</pre>"    , test, test1);

		for (int i=0 ;i<datas.size();i++) {
			String Updated_Customer_Code=getValueByFirstColumnAndHeader(customer_Tabledata, "Customer Type", datast.get(i), "System Code");
			if (datast11.get(i).equals(Updated_Customer_Code.trim())) {
				System.out.println("Matched || Expected value was : " + datast11.get(i) + " || Actual value was : " + Updated_Customer_Code);
				Extent_pass_New(driver, "Matched || Expected value was : " + datast11.get(i) + " || Actual value was : " + Updated_Customer_Code, test,test1);
			} else {
				System.out.println("NotMatched || Expected value was : " + datast11.get(i) + " || Actual value was : " + Updated_Customer_Code);
				Extent_fail(driver, "NotMatched || Expected value was : " + datast11.get(i) + " || Actual value was : " + Updated_Customer_Code,test, test1);

			}}
		Step_End(51, "Verify  import documentation ,Customer tab newly added Customer code has shown from MCN.", test, test1);

		if(Import_Documentation_delete_perform.equalsIgnoreCase("YES")) {
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}

		Extent_completed(testcase_Name, test, test1);

	}
}
