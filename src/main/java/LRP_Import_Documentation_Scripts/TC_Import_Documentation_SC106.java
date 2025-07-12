package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC106 extends Keywords{

	public void Import_Documentation_SC106(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC106";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalValue = Excel_data.get("GlobalValue");
		String GlobalID = Excel_data.get("GlobalID");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String SavedPopup = Excel_data.get("SavedPopup");
		String Manifest_Module = Excel_data.get("Manifest_Module");
		String Corection_Type_Option = Excel_data.get("Corection_Type_Option");
		String Customer_Type = Excel_data.get("Customer_Type");
		String Customer_Type_Option = Excel_data.get("Customer_Type_Option");
		String Customer = Excel_data.get("Customer_System_Code");
		String Charge_Code_Input = Excel_data.get("Charge_Code_Input");
		String Base_Rate_Unit_Input = Excel_data.get("Base_Rate_Unit_Input");
		String Curency_Code_Input = Excel_data.get("Curency_Code_Input");
		String Invoice_Currency_Code_Input = Excel_data.get("Invoice_Currency_Code_Input");
		String Equip_Type_Input = Excel_data.get("Equip_Type_Input");
		String Base_Rate_Inpput = Excel_data.get("Base_Rate_Input");
		String Payment_Mode_Input = Excel_data.get("Payment_Mode_Input");
		String Amount_Input = Excel_data.get("Amount_Input");
		String PayBY_Input = Excel_data.get("PayBY_Input");
		String MCN_Remarks_Input = Excel_data.get("MCN_Remarks_Input");
		String Export_Agency = Excel_data.get("Export_Agency");
		String MCN_Popup_Msg = Excel_data.get("MCN_Popup_Msg");
		String MCN_Approved_msg = Excel_data.get("MCN_Approved_msg");
		String MCN_Status_Value = Excel_data.get("MCN_Status_Value");
		String Globalsearch_MCN = Excel_data.get("Globalsearch_MCN");
		String Default_Value = Excel_data.get("Default_Value");
		String UpdatedPopup = Excel_data.get("UpdatedPopup");
		String GlobalsearchCustomer_MCN = Excel_data.get("GlobalsearchCustomer_MCN");
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
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String pol_Value = Excel_data.get("pol_Value");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Condition = Excel_data.get("Condition");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Charge_Code_Header = Excel_data.get("Charge_Code_Header");
		String Unit_Code_Header = Excel_data.get("Unit_Code_Header");
		String Currency_Code_Header = Excel_data.get("Currency_Code_Header");
		String Import_Saved_Verify_Popup_MCN = Excel_data.get("Import_Saved_Verify_Popup_MCN");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		String MCN_Retrive_Type=Excel_data.get("MCN_Retrive_Type");
		String Accepted_Popup=Excel_data.get("Accepted_Popup");		
		String Status_Tab_Table_Headers=Excel_data.get("Status_Tab_Table_Headers");		
		
		String Ports_Module=Excel_data.get("Ports_Module");		
		String Ports_Search_Type_Select=Excel_data.get("Ports_Search_Type_Select");		

		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "Step no 1 to 2 - Global Configuration SetUp start");
	    setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue);
	    Extent_call(test, test1, "Step no 1 to 2 - Global Configuration SetUp End");
	    
		Step_Start(3, "open the Import Documentation Retrieve the  bill using tool bar search.", test, test1);

		moduleNavigate(driver, ImportDocumentationModule);

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, bl_Number, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);


		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {

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
				waitForElement(driver, pol_Text_field);
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
			waitForElement(driver, bl_input_TF);
			twoColumnSearchWindow(driver, BLNumber_Header, Condition, bl_Number);
		}

		Step_End(3, "open the Import Documentation Retrieve the  bill using tool bar search.", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String Get_BL_Status = getText(driver, BL_status_IMP_DOC);
		System.out.println("Get_BL_Status:"+ Get_BL_Status);
			
		Step_Start(4, "import documentation has saved", test, test1);
		if(Get_BL_Status.equalsIgnoreCase("NEW")){
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			waitForPopup(driver, popup_Message, SavedPopup);
	
			String BL_StatusValue= getText(driver, popup_Message);
			if(BL_StatusValue.equals(SavedPopup)) {
				System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + BL_StatusValue);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + BL_StatusValue, test,
						test1);

			}else {
				System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + BL_StatusValue);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + BL_StatusValue,
						test, test1);
			}
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
		}
		Step_End(4, "import documentation has saved", test, test1);
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);	

		Step_Start(5, "MCN has amended with any changes", test, test1);
		
		SwitchProfile(driver, Export_Agency);
		
		moduleNavigate(driver, Manifest_Module);

		waitForElement(driver, Corection_Type_DropDown);
		click(driver, Corection_Type_DropDown);
		String correctionType_ =  String.format(correctionType_MCN, Corection_Type_Option);

		waitForElement(driver, correctionType_);
		click(driver, correctionType_);
		waitForElement(driver, BL_Search_Button);
		click(driver, BL_Search_Button);
		
		globalValueSearchWindow(driver, BL_Condition, Globalsearch_MCN, bl_Number, "", "", "", "");
		
		if(isdisplayed(driver, popup_Message)) {
			String popupAct=getText(driver, popup_Message);
			if(Import_Saved_Verify_Popup_MCN.equalsIgnoreCase(popupAct)) {
				System.out.println("Popup Matched || Expected : "+Import_Saved_Verify_Popup_MCN+" || Actual : "+popupAct);
				Extent_pass(driver, "Popup Matched || Expected : "+Import_Saved_Verify_Popup_MCN+" || Actual : "+popupAct, test, test1);
			}else {
				System.out.println("Popup Not Matched || Expected : "+Import_Saved_Verify_Popup_MCN+" || Actual : "+popupAct);
				Extent_fail(driver, "Popup Not Matched || Expected : "+Import_Saved_Verify_Popup_MCN+" || Actual : "+popupAct, test, test1);
			}
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}
	
		waitForElement(driver, Manifest_Customer_Tab);
		click(driver, Manifest_Customer_Tab); 

		String Customer_Select_ =  String.format(Customer_Select_Option, Customer_Type);

		waitForElement(driver, Customer_Select_);
		click(driver, Customer_Select_); 
		waitForElement(driver, Customer_Remove);
		click(driver, Customer_Remove);

		waitForElement(driver, Customer_Type_Dropdown);
		click(driver, Customer_Type_Dropdown); 

		String Customer_Type_Select_ =  String.format(DropDown_Select, Customer_Type_Option);
		waitForElement(driver, Customer_Type_Select_);
		click(driver, Customer_Type_Select_); 

		if(IsElementEnabled(driver, Manifest_Customer_Search)) {
			waitForElement(driver, Manifest_Customer_Search);
			click(driver, Manifest_Customer_Search); 
			globalValueSearchWindow(driver, BL_Condition, GlobalsearchCustomer_MCN, Customer, "", "", "", "");
		}else {
			waitForElement(driver, Customer_Search_Input_MCN);
			Newclear(driver, Customer_Search_Input_MCN);
			sendKeys(driver, Customer_Search_Input_MCN, Customer);
		     formatLocatorClick(driver, Customer_Search_Value_MCN, Customer);
		}
		
		waitForElement(driver, MCN_CustomerAdd_Button);
		click(driver, MCN_CustomerAdd_Button);

		waitForElement(driver, Manifest_Charges_Tab);
		click(driver, Manifest_Charges_Tab);
		
		if(IsElementEnabled(driver, Charge_Code_Search)) {
			waitForElement(driver, Charge_Code_Search);
			click(driver, Charge_Code_Search);
			twoColumnSearchWindow(driver, Charge_Code_Header, Condition, Charge_Code_Input);

		}else {
			waitForElement(driver, Charge_Input_MCN);
			Newclear(driver, Charge_Input_MCN);
			sendKeys(driver, Charge_Input_MCN, Charge_Code_Input);
			formatLocatorClick(driver, Charge_Value_Select_MCN, Charge_Code_Input);
		}
				
		if(IsElementEnabled(driver, BaseRate_Unit_Search_MCN)) {
			waitForElement(driver, BaseRate_Unit_Search_MCN);
			click(driver, BaseRate_Unit_Search_MCN);
			twoColumnSearchWindow(driver, Unit_Code_Header, Condition, Base_Rate_Unit_Input);
		}else {
			waitForElement(driver, Base_Rate_Unit_Input_MCN);
			Newclear(driver, Base_Rate_Unit_Input_MCN);
			sendKeys(driver, Base_Rate_Unit_Input_MCN, Base_Rate_Unit_Input);
			formatLocatorClick(driver, Charge_Value_Select_MCN, Base_Rate_Unit_Input);
		}
		
		if(IsElementEnabled(driver, Currency_Search)) {
			waitForElement(driver, Currency_Search);
			click(driver, Currency_Search);
			twoColumnSearchWindow(driver, Currency_Code_Header, Condition, Curency_Code_Input);
		}else {
			waitForElement(driver, Currency_Search_Input_MCN);
			Newclear(driver, Currency_Search_Input_MCN);
			sendKeys(driver, Currency_Search_Input_MCN, Curency_Code_Input);
			formatLocatorClick(driver, Charge_Value_Select_MCN, Curency_Code_Input);
		}

		if(isdisplayed(driver, Invoice_Currency_Search)) {
			waitForElement(driver, Invoice_Currency_Search);
			click(driver, Invoice_Currency_Search);
			twoColumnSearchWindow(driver, Currency_Code_Header, Condition, Invoice_Currency_Code_Input);
		}
		waitForElement(driver, Eqp_Type_Dropdown);
		click(driver, Eqp_Type_Dropdown);

		String Eqp_Type_select_ =  String.format(DropDown_Select, Equip_Type_Input);
		waitForElement(driver, Eqp_Type_select_);
		click(driver, Eqp_Type_select_);
		waitForElement(driver, Base_Rate_Field);
		clear(driver, Base_Rate_Field);
		sendKeys(driver, Base_Rate_Field, Base_Rate_Inpput);
		waitForElement(driver, Payment_Mode_Dropdown);
		click(driver, Payment_Mode_Dropdown);

		String Payment_Mode_select_ =  String.format(DropDown_Select, Payment_Mode_Input);
		waitForElement(driver, Payment_Mode_select_);
		click(driver, Payment_Mode_select_);
		waitForElement(driver, Amount_Field);
		clear(driver, Amount_Field);
		sendKeys(driver, Amount_Field,Amount_Input);
		waitForElement(driver, PayBy_Dropdown);
		click(driver, PayBy_Dropdown);
		String PayBy_select_ =  String.format(DropDown_Select, PayBY_Input);
		waitForElement(driver, PayBy_select_);
		click(driver, PayBy_select_);
		waitForElement(driver, Charges_Add_Button);
		click(driver, Charges_Add_Button);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
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
		waitForElement(driver, Manifest_Submit_Button);
		click(driver, Manifest_Submit_Button);
		waitForElement(driver, Remarks_Field);
		if(isdisplayed(driver, Internal_Option_Remark_MCN)) {
			waitForElement(driver, Internal_Option_Remark_MCN);
			click(driver,Internal_Option_Remark_MCN);
		}
		waitForElement(driver, Remarks_Field);
		sendKeys(driver, Remarks_Field, MCN_Remarks_Input);
		click(driver, Remarks_OK_Button);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

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
		List<Map<String, String>> MCN_Chareges_Tabledata = getTableData(driver, MCN_Charges_Table_Headers,MCN_Charges_Table_Rows);
		String elseWhere_Agency = getValueByFirstColumnPartialValueAndHeader(MCN_Chareges_Tabledata, "Payment Mode", "PayAt", "Pay Location");
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
		
		Step_End(5, "MCN has amended with any changes", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_Start(6, "in import documentation retrieve the bl", test, test1);
		
		moduleNavigate(driver, ImportDocumentationModule);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, bl_Number, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);

		Step_End(6, "in import documentation retrieve the bl", test, test1);

		Step_Start(7, "mcn available message has shown", test, test1);
		waitForElement(driver, MCN_Status_IMP_DOC);
		String MCN_Import_status=getText(driver, MCN_Status_IMP_DOC);
		if(MCN_Status_Value.equals(MCN_Import_status)) {
			System.out.println("Matched || Expected value was : " + MCN_Status_Value + " || Actual value was : " + MCN_Import_status);
			Extent_pass_New(driver, "Matched || Expected value was : " + MCN_Status_Value + " || Actual value was : " + MCN_Import_status, test,
					test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + MCN_Status_Value + " || Actual value was : " + MCN_Import_status);
			Extent_fail(driver, "NotMatched || Expected value was : " + MCN_Status_Value + " || Actual value was : " + MCN_Import_status,
					test, test1);
		}

		Step_End(7, "mcn available message has shown", test, test1);

		Step_Start(8, "click edit and pop has shown but cross symbol not shown", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForDisplay(driver, Refresh_Button);
		if(!isdisplayed(driver, MCN_Refresh_Popup_close_button))	{
			System.out.println("Expected : Refresh popup should not display when click Edit button || Actual : Refresh popup is not displayed when click Edit button ");
			Extent_pass_New(driver, "Expected : Refresh popup should not display when click Edit button || Actual : Refresh popup is not displayed when click Edit button ", test, test1);
		}else {
			System.out.println("Expected : Refresh popup should not display when click Edit button || Actual : Refresh popup is displayed when click Edit button ");
			Extent_fail(driver, "Expected : Refresh popup should not display when click Edit button || Actual : Refresh popup is displayed when click Edit button ", test, test1);
		}

		waitForElement(driver, Refresh_Button);
		click(driver, Refresh_Button);
		Step_End(8, "click edit and pop has shown but cross symbol not shown", test, test1);

		Step_Start(9, "Save the Import Documentation. system has validate -Import Documentation is updated.Ok", test, test1);
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
		Step_End(9, "Save the Import Documentation. system has validate -Import Documentation is updated.Ok", test, test1);

		Step_Start(10, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(11, "click the delete icon and system has validate( Do you want to delete import documentation )YES or N0 ", test, test1);
		Step_Start(12, "click the yes and system has validate import documentation is deleted", test, test1);

		if(Delete_Perform.equalsIgnoreCase("YES")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Step_End(10, "click the yes and system has validate import documentation is deleted", test, test1);
		Step_End(11,"click the delete icon and system has validate( Do you want to delete import documentation )YES or N0 " , test, test1);
		Step_End(12, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Extent_call(test, test1, "Reset Global Configuration");		
		reSetGlobalConfiguration(driver, "Yes", GlobalConfigurationModule, GlobalID, Default_Value);
		Extent_call(test, test1, "Reset Global Configuration");
		Extent_completed(testcase_Name, test, test1);

	}

}
