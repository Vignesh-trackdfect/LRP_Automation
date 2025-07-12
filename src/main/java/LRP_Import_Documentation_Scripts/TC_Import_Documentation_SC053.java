package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC053 extends Keywords{

	public void Import_Documentation_SC053(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC053";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String Export_Agency = Excel_data.get("Export_Agency");
		String Manifest_Module = Excel_data.get("Manifest_Module");
		String Corection_Type_Option = Excel_data.get("Corection_Type_Option");
		String Container_No = Excel_data.get("Container_No");
		String Shipper_Owned_Chk_Box_Select = Excel_data.get("Shipper_Owned_Chk_Box_Select");
		String Round_Trip_Chk_Box_Select = Excel_data.get("Round_Trip_Chk_Box_Select");
		String DG_Chk_Box_Select = Excel_data.get("DG_Chk_Box_Select");
		String Laden_Chk_Box_Select = Excel_data.get("Laden_Chk_Box_Select");
		String One_Way_Chk_Box_Select = Excel_data.get("One_Way_Chk_Box_Select");
		String Container_Load_Type = Excel_data.get("Container_Load_Type");
		String Carrier_Seal_Input = Excel_data.get("Carrier_Seal_Input");
		String Shipper_Seal_Input = Excel_data.get("Shipper_Seal_Input");
		String Other_Seal_Input = Excel_data.get("Other_Seal_Input");
		String SDV_Amount_Input = Excel_data.get("SDV_Amount_Input");
		String Equip_Id_Field_Input = Excel_data.get("Equip_Id_Field_Input");
		String Chassis_Field_Input = Excel_data.get("Chassis_Field_Input");
		String MCN_Remarks_Input = Excel_data.get("MCN_Remarks_Input");
		String MCN_Approved_msg = Excel_data.get("MCN_Approved_msg");
		String Table_Headers=Excel_data.get("Container_Table_Headers");
		String Table_Name=Excel_data.get("Container_Table_Name");
		String Blue_Color=Excel_data.get("Blue_Color");
		String MCN_Table_Headers=Excel_data.get("MCN_Container_Table_Headers");
		String MCN_Table_Name=Excel_data.get("MCN_Container_Table_Name");
		String MCN_Refresh_Popup=Excel_data.get("MCN_Refresh_Popup");
		String MCN_Popup_Msg = Excel_data.get("MCN_Popup_Msg");
		String SavedPopup = Excel_data.get("SavedPopup");
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
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		
		String Import_Documentation_delete_perform=Excel_data.get("Import_Documentation_delete_perform");
		String Delete_Confirmation_Popup=Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup=Excel_data.get("Delete_Success_Popup");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		String Ports_Module=Excel_data.get("Ports_Module");		
		String Ports_Search_Type_Select=Excel_data.get("Ports_Search_Type_Select");		
		String MCN_Retrive_Type=Excel_data.get("MCN_Retrive_Type");
		String Accepted_Popup=Excel_data.get("Accepted_Popup");		
		String Status_Tab_Table_Headers=Excel_data.get("Status_Tab_Table_Headers");		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, "switch to the export agency", test, test1);
		SwitchProfile(driver, Export_Agency);
		Step_End(1, "switch to the export agency", test, test1);

		Step_Start(2, "open the manifest correction notes module (MCN)", test, test1);
		moduleNavigate(driver, Manifest_Module);
		Step_End(2, "open the manifest correction notes module (MCN)", test, test1);

		Step_Start(3, "select the multi correction in correction type field", test, test1);

		waitForElement(driver, Corection_Type_DropDown);
		click(driver, Corection_Type_DropDown);
		formatLocatorClick(driver, correctionType_MCN, Corection_Type_Option);
		Step_End(3, "select the multi correction in correction type field", test, test1);

		Step_Start(4, "load the same bl in bl search field", test, test1);

		waitForElement(driver, BL_Search_Button);
		click(driver, BL_Search_Button);
				
		globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		Step_End(4, "load the same bl in bl search field", test, test1);

		Step_Start(5, "system will be vaidate (Imort Doc already saved Do you want to Continue Click Yes and Go)", test, test1);

		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}
		
		Step_End(5, "system will be vaidate (Imort Doc already saved Do you want to Continue Click Yes and Go)", test, test1);

		Step_Start(6, "datas fetched all the tabs", test, test1);
		Step_End(6, "datas fetched all the tabs", test, test1);
		Step_Start(7, "go to the container  tab", test, test1);
		mouseOverToElement(driver, Manifest_Container_Tab);
		waitForElement(driver, Manifest_Container_Tab);
		click(driver, Manifest_Container_Tab);
		waitForElement(driver, Carrier_Seal_Field);
		Step_End(7, "go to the container  tab", test, test1);
		Step_Start(8, "in below grid container no based commodity details has shown", test, test1);
		List<String>  containersEditList=splitAndExpand(Container_No);
		List<String>  CarrierSealsList=splitAndExpand(Carrier_Seal_Input);
		List<String>  Shipper_Owned_Chk_Box_List=splitAndExpand(Shipper_Owned_Chk_Box_Select);
		List<String>  Round_Trip_Chk_Box_List=splitAndExpand(Round_Trip_Chk_Box_Select);
		List<String>  DG_Chk_Box_List=splitAndExpand(DG_Chk_Box_Select);
		List<String>  Laden_Chk_Box_List=splitAndExpand(Laden_Chk_Box_Select);
		List<String>  One_Way_Chk_Box_List=splitAndExpand(One_Way_Chk_Box_Select);
		List<String>  Container_Load_TypeList=splitAndExpand(Container_Load_Type);
		List<String>  Shipper_Seal_InputList=splitAndExpand(Shipper_Seal_Input);
		List<String>  Other_Seal_InputList=splitAndExpand(Other_Seal_Input);
		List<String>  SDV_Amount_InputList=splitAndExpand(SDV_Amount_Input);
		List<String>  Equip_Id_Field_InputList=splitAndExpand(Equip_Id_Field_Input);
		List<String>  Chassis_Field_InputList=splitAndExpand(Chassis_Field_Input);

		Step_End(8, "in below grid container no based commodity details has shown", test, test1);
		Map<String,List<String>> ExpectedContainerList=new HashMap<String, List<String>>();
		for(int i=0;i<containersEditList.size();i++) {
			List<String>  ValidateColumn=new ArrayList<String>();
			String Container=containersEditList.get(i);
			ValidateColumn.add(CarrierSealsList.get(i));
			ValidateColumn.add(Shipper_Seal_InputList.get(i));
			ExpectedContainerList.put(Container, ValidateColumn);
		}

		Step_Start(9, "click the edit in below grid", test, test1);
		for(int i=0;i<containersEditList.size();i++) {
			Step_End(9,"click the edit in below grid", test, test1);
			String Container_Edit_Select =  String.format(ImportDocumentation_Locators.Container_Edit_Select, containersEditList.get(i));
			waitForElement(driver, Container_Edit_Select);
			click(driver, Container_Edit_Select); 
			
			Step_End(9,"click the edit in below grid", test, test1);

			Step_Start(10, "details will be fetched in the above field", test, test1);
			Step_End(10,"details will be fetched in the above field", test, test1);
			Step_Start(11, "change the carrier seal", test, test1);
			if(CarrierSealsList.size()>i) {
				if(CarrierSealsList.get(i)!=null&&!CarrierSealsList.get(i).trim().equals("")) {
					waitForElement(driver, Carrier_Seal_Field);
					click(driver, Carrier_Seal_Field); 
					clear(driver, Carrier_Seal_Field);
					sendKeys(driver, Carrier_Seal_Field, CarrierSealsList.get(i));
				}
			}
			
			waitForDisplay(driver, Shipper_Owned_Chk_Box);
			if(IsElementEnabled(driver, Shipper_Owned_Chk_Box)) {
				waitForElement(driver, Shipper_Owned_Chk_Box);
				if(Shipper_Owned_Chk_Box_List.size()>i) {
					if(Shipper_Owned_Chk_Box_List.get(i)!=null&&!Shipper_Owned_Chk_Box_List.get(i).trim().equals("")) {
						checkBox(driver, Shipper_Owned_Chk_Box, Shipper_Owned_Chk_Box_List.get(i));
					}
				}
			}
			
			waitForDisplay(driver, Round_Trip_Chk_Box);
			if(IsElementEnabled(driver, Round_Trip_Chk_Box)) {
				waitForElement(driver, Round_Trip_Chk_Box);
				if(Round_Trip_Chk_Box_List.size()>i) {
					if(Round_Trip_Chk_Box_List.get(i)!=null&&!Round_Trip_Chk_Box_List.get(i).trim().equals("")) {
						checkBox(driver, Round_Trip_Chk_Box, Round_Trip_Chk_Box_List.get(i));
					}
				}
			}
			
			waitForDisplay(driver, DG_Chk_Box_IMD);
			if(IsElementEnabled(driver, DG_Chk_Box_IMD)) {
				waitForElement(driver, DG_Chk_Box_IMD);
				if(DG_Chk_Box_List.size()>i) {
					if(DG_Chk_Box_List.get(i)!=null&&!DG_Chk_Box_List.get(i).trim().equals("")) {
						checkBox(driver, DG_Chk_Box_IMD, DG_Chk_Box_List.get(i));
					}
				}
			}
			
			waitForDisplay(driver, Laden_Chk_Box);
			if(IsElementEnabled(driver, Laden_Chk_Box)) {
				waitForElement(driver, Laden_Chk_Box);
				if(Laden_Chk_Box_List.size()>i) {
					if(Laden_Chk_Box_List.get(i)!=null&&!Laden_Chk_Box_List.get(i).trim().equals("")) {
						checkBox(driver, Laden_Chk_Box, Laden_Chk_Box_List.get(i));
					}
				}
			}
			
			waitForDisplay(driver, One_Way_Chk_Box);
			if(IsElementEnabled(driver, One_Way_Chk_Box)) {
				waitForElement(driver, One_Way_Chk_Box);
				if(One_Way_Chk_Box_List.size()>i) {
					if(One_Way_Chk_Box_List.get(i)!=null&&!One_Way_Chk_Box_List.get(i).trim().equals("")) {
						checkBox(driver, One_Way_Chk_Box, One_Way_Chk_Box_List.get(i));
					}
				}
				
			}
			
			waitForDisplay(driver, Shipper_Seal_Field);
			if(IsElementEnabled(driver, Shipper_Seal_Field)) {
				if(Shipper_Seal_InputList.size()>i) {
					if(Shipper_Seal_InputList.get(i)!=null&&!Shipper_Seal_InputList.get(i).trim().equals("")) {					waitForElement(driver, Shipper_Seal_Field);
						click(driver, Shipper_Seal_Field); 
						Newclear(driver, Shipper_Seal_Field);
						sendKeys(driver, Shipper_Seal_Field, Shipper_Seal_InputList.get(i));
						enter(driver);
					}
				}
			}
			
			waitForDisplay(driver, Other_Seal_Field);
			if(IsElementEnabled(driver, Other_Seal_Field)) {
				if(Other_Seal_InputList.size()>i) {
					if(Other_Seal_InputList.get(i)!=null&&!Other_Seal_InputList.get(i).trim().equals("")) {						waitForElement(driver, Other_Seal_Field);
						click(driver, Other_Seal_Field); 
						Newclear(driver, Other_Seal_Field);
						sendKeys(driver, Other_Seal_Field, Other_Seal_InputList.get(i));
						enter(driver);
					}
				}
			}
			
			waitForDisplay(driver, Container_Load_Instruction_DD);
			if(IsElementEnabled(driver, Container_Load_Instruction_DD)) {
				if(Container_Load_TypeList.size()>i) {
					if(Container_Load_TypeList.get(i)!=null&&!Container_Load_TypeList.get(i).trim().equals("")) {		
						waitForElement(driver, Container_Load_Instruction_DD);
						click(driver, Container_Load_Instruction_DD); 
						String Container_Load =  String.format(DropDown_Select, Container_Load_TypeList.get(i));
						waitForElement(driver, Container_Load);
						click(driver, Container_Load);
					}
				}
			}
			
			waitForDisplay(driver, SDV_Amount_Field);
			if(IsElementEnabled(driver, SDV_Amount_Field)) {
				if(SDV_Amount_InputList.size()>i) {
					if(SDV_Amount_InputList.get(i)!=null&&!SDV_Amount_InputList.get(i).trim().equals("")) {						waitForElement(driver, SDV_Amount_Field);
						click(driver, SDV_Amount_Field); 
						Newclear(driver, SDV_Amount_Field);
						sendKeys(driver, SDV_Amount_Field, SDV_Amount_InputList.get(i));
					}
				}
			}
			
			waitForDisplay(driver, Equip_Id_Field);
			if(IsElementEnabled(driver, Equip_Id_Field)) {
				if(Equip_Id_Field_InputList.size()>i) {
					if(Equip_Id_Field_InputList.get(i)!=null&&!Equip_Id_Field_InputList.get(i).trim().equals("")) {						waitForElement(driver, Equip_Id_Field);
						click(driver, Equip_Id_Field); 
						clear(driver, Equip_Id_Field);
						sendKeys(driver, Equip_Id_Field, Equip_Id_Field_InputList.get(i));	
					}
				}
			}
			
			waitForDisplay(driver, Chassis_Field);
			if(IsElementEnabled(driver, Chassis_Field)) {
				if(Chassis_Field_InputList.size()>i) {
					if(Chassis_Field_InputList.get(i)!=null&&!Chassis_Field_InputList.get(i).trim().equals("")) {						waitForElement(driver, Chassis_Field);
						click(driver, Chassis_Field); 
						clear(driver, Chassis_Field);
						sendKeys(driver, Chassis_Field, Chassis_Field_InputList.get(i));	
					}
				}
			}
			
			
			Step_End(11, "change the carrier seal", test, test1);

			Step_Start(12, "click the edit  button", test, test1);
			waitForElement(driver, MCN_Container_Edit);
			click(driver, MCN_Container_Edit);
			
			waitForDisplay(driver, popup_Message_Yes_Button);
			if(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver,popup_Message_Yes_Button);
			}
			Step_End(12, "click the edit  button", test, test1);
		}

		Step_Start(13, "details fetched in below grid", test, test1);
		waitForElement(driver, MCN_Container_Table_Headers);
		List<Map<String, String>> MCN_Chareges_Tabledata = getTableData(driver, MCN_Container_Table_Headers, MCN_Container_Table_Rows);
		List<String> columnheader = splitAndExpand(MCN_Table_Headers);
		String MCN_Container_Tabledata = TableDataForReport(driver, MCN_Chareges_Tabledata,MCN_Table_Name,columnheader);

		Step_End(13, "details fetched in below grid", test, test1);

		Step_Start(14, "click the save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(14, "click the save button", test, test1);

		Step_Start(15, "system has validate", test, test1);

		waitForElement(driver, MCN_Number_Textfield_MCN_Module);
		waitForDisplay(driver, popup_Message);
		if (isDisplayed(driver, popup_Message)) {
			waitForPopup(driver, popup_Message, MCN_Refresh_Popup);
			String actual_MCN_Refresh_Popup=getText(driver, popup_Message);
			if (MCN_Refresh_Popup.trim().equals(actual_MCN_Refresh_Popup.trim())) {
				System.out.println("Matched || Expected Popup was : " + MCN_Refresh_Popup + " || Actual Popup was : " + actual_MCN_Refresh_Popup);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + MCN_Approved_msg + " || Actual Popup was : " + actual_MCN_Refresh_Popup, test,
						test1);
				Step_End(15, "system has validate", test, test1);

				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + MCN_Refresh_Popup + " || Actual Popup was : " + actual_MCN_Refresh_Popup);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + MCN_Refresh_Popup + " || Actual Popup was : " + actual_MCN_Refresh_Popup,
						test, test1);
			}

			Step_Start(16, "Body Tab details not refreshed. Use right click to refresh OK-click ok", test, test1);
			Step_End(16, "Body Tab details not refreshed. Use right click to refresh OK-click ok", test, test1);

			Step_Start(17, "go to Body tab edit button has enable.", test, test1);
			Step_End(17, "go to Body tab edit button has enable.", test, test1);

			Step_Start(18, "click the edit", test, test1);

			waitForElement(driver, Body_Edit_Button);
			click(driver, Body_Edit_Button);
			Step_End(18,"click the edit", test, test1);

			Step_Start(19, "Do you want to edit Body Details? This will be validated in the approval process YES OR NO  ", test, test1);

			waitForPopup(driver, popup_Message,"Do you want to edit Body Details?");
			
			Step_End(19, "Do you want to edit Body Details? This will be validated in the approval process YES OR NO  ", test, test1);

			Step_Start(20, "click the yes", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(20,"click the yes", test, test1);

			Step_Start(21, "right click in body tab", test, test1);

			waitForElement(driver, Text_Area);
			RightClick(driver, Text_Area);
			Step_End(21, "right click in body tab", test, test1);

			Step_Start(22, "mark and no,container and sealnumber refresh words are heighlightes red color", test, test1);
			Step_End(22, "mark and no,container and sealnumber refresh words are heighlightes red color", test, test1);

			Step_Start(23, "click the refresh all", test, test1);

			waitForElement(driver, Refresh_All_Button);
			click(driver, Refresh_All_Button);
			Step_End(23, "click the refresh all", test, test1);

			Step_Start(24, "latest details updtede in body tab.", test, test1);
			Step_End(24, "latest details updtede in body tab.", test, test1);

			Step_Start(25, "click the save button", test, test1);

			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			Step_End(25,"click the save button	", test, test1);
		}
		Step_Start(26, "Do you want to save as Pending or Submit or Cancel for process?\r\n"
				+ "Pending---  Submit-- Cancel--button has enable", test, test1);

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
		
		Step_End(26, "Do you want to save as Pending or Submit or Cancel for process?\r\n"
				+ "Pending---  Submit-- Cancel--button has enable", test, test1);

		Step_Start(27, "click the submit button.", test, test1);

		waitForElement(driver, Manifest_Submit_Button);
		click(driver, Manifest_Submit_Button);
		Step_End(27, "click the submit button.", test, test1);

		Step_Start(28, "system will popluate the mcn remarks window", test, test1);

		waitForElement(driver, Remarks_Field);
		if(isdisplayed(driver, Internal_Option_Remark_MCN)) {
			waitForElement(driver, Internal_Option_Remark_MCN);
			click(driver,Internal_Option_Remark_MCN);
		}
		Step_End(28, "system will popluate the mcn remarks window", test, test1);

		Step_Start(29, "enter the remarks ---click the okay button", test, test1);

		sendKeys(driver, Remarks_Field, MCN_Remarks_Input);
		click(driver, Remarks_OK_Button);
		Step_End(29, "enter the remarks ---click the okay button", test, test1);

		Step_Start(30, "System has validate -Submitted. MCN is moved to approval process OK button", test, test1);
		waitForPopup(driver, popup_Message,"MCN is moved to approval process");
		
		Step_End(30, "System has validate -Submitted. MCN is moved to approval process OK button", test, test1);
		Step_Start(31, "click the ok ", test, test1);
		click(driver, popup_Message_Ok_Button);
		Step_Start(32, "click the edit button in tool bar", test, test1);

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
		
		Step_Start(33, "open the manifest correction notes module", test, test1);
		Step_Start(34, "load the bill in tool bar search", test, test1);
		Step_Start(35, "click the edit button", test, test1);
		Step_Start(36, "system go to status tab accept and reject button has enable", test, test1);
		Step_Start(37, "click the accept button", test, test1);
		Step_Start(38,
				"system has validate -Do you want to accept this MCN ?YES NO button has enable click the yes button",
				test, test1);
		Step_Start(39, "system has validate the ACCEPTED", test, test1);
		Step_Start(40, "click the edit button in tool bar ", test, test1);
		Step_Start(41, "system go to the status tab", test, test1);
		Step_Start(42, "Approve and Reject button has enable", test, test1);
		Step_Start(43, "click the Approve button", test, test1);
		Step_Start(44, "Do you want to approve this MCN ?YES  NO", test, test1);
		click(driver, MCN_Module);
		waitForElement(driver, Close_Current_tab);
		jsClick(driver, Close_Current_tab);
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
		
		Step_End(33, "open the manifest correction notes module", test, test1);
		Step_End(34, "load the bill in tool bar search", test, test1);
		Step_End(35, "click the edit button", test, test1);
		Step_End(36, "system go to status tab accept and reject button has enable", test, test1);
		Step_End(37, "click the accept button", test, test1);
		Step_End(38,
				"system has validate -Do you want to accept this MCN ?YES NO button has enable click the yes button",
				test, test1);

		Step_End(39, "system has validate the ACCEPTED", test, test1);
		Step_End(40, "click the edit button in tool bar ", test, test1);
		Step_End(41, "system go to the status tab", test, test1);
		Step_End(42, "Approve and Reject button has enable", test, test1);
		Step_End(43, "click the Approve button", test, test1);
		Step_End(44, "Do you want to approve this MCN ?YES  NO", test, test1);
		Step_End(45, "click the yes", test, test1);
				Step_Start(46, "system wil popluat the window MCN approval Remarks enter the remarks click the ok", test,
						test1);
		Step_End(47, "system will popluate the validaiton --- MCN approved ", test, test1);

		Step_Start(49, "open the import documentation module", test, test1);
		SwitchProfile(driver, AgencyUser);
		moduleNavigate(driver, ImportDocumentationModule);	
		Step_End(49, "open the import documentation module", test, test1);

		Step_Start(50, "load the bill", test, test1);

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

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
		Step_End(50, "load the bill", test, test1);
		
		Step_Start(51, "In the Container tab, amended container row has shown blue  color", test, test1);

		waitForElement(driver, Container_Tab_IMD);
		click(driver, Container_Tab_IMD);
		scrollBottom(driver);
		for(int i=0;i<containersEditList.size();i++) {
			String New_Added_row1 =  String.format(ImportDocumentation_Locators.New_Added_row1, containersEditList.get(i));
			waitForElement(driver, New_Added_row1);
			String New_Row_color = getTextBackgroundColor(driver, New_Added_row1);
			System.out.println("New_Blue_Color : "+New_Row_color);
			
			String Act_Color=getColorName(New_Row_color);
			if (Blue_Color.trim().equalsIgnoreCase(Act_Color.trim())) {
				
				System.out.println("Matched || The Newly Added "+containersEditList.get(i)+" Row Color Is Blue and the color code is : "+Act_Color);
				Extent_pass_New(driver,"Matched || The Newly Added "+containersEditList.get(i)+" Row Color Is Blue and the color code is : "+Act_Color, test,test1);
			} else {
				System.out.println("Not Matched || The Newly Added "+containersEditList.get(i)+"Row Color Is Not Blue and the color code is : "+Act_Color);
				Extent_fail(driver, "Not Matched || The Newly Added "+containersEditList.get(i)+" Row Color Is Not Blue and the color code is : "+Act_Color,	test, test1);
			}
		}
		
		Step_End(51, "In the Container tab, amended container row has shown blue  color", test, test1);

		Step_Start(52, "Save the Import Documentation", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(52, "Save the Import Documentation", test, test1);

		Step_Start(53, "once saved the import documentation system has validate import documentation is Saved", test, test1);

		waitForPopup(driver, popup_Message, SavedPopup);
		String actual_Updated_Popup=getText(driver, popup_Message);
		if (SavedPopup.trim().equals(actual_Updated_Popup.trim())) {
			System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + actual_Updated_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + actual_Updated_Popup, test,test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + actual_Updated_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + actual_Updated_Popup,test, test1);
		}
		Step_End(53, "once saved the import documentation system has validate import documentation is Saved", test, test1);


		Step_Start(54, "Go to the container Tab", test, test1);
		waitForElement(driver, Container_Tab_IMD);
		click(driver, Container_Tab_IMD);
		Step_End(54, "Go to the container Tab", test, test1);

		Step_Start(55, "updated carrier seal details show from MCN", test, test1);
		scrollBottom(driver);
		waitForElement(driver, Container_Table_Header);
		List<Map<String, String>> customer_Tabledata = getTableData(driver, Container_Table_Header, Container_Table_Row);
		List<String> columnheaders = splitAndExpand(Table_Headers);
		
		String container_Tabledata = TableDataForReport(driver, customer_Tabledata,Table_Name,columnheaders);
		
		Map<String,List<String>> headersValuesAct= getValuesByID(customer_Tabledata,columnheaders.get(0),containersEditList,columnheaders);//      getColumnValuesByHeaders(customer_Tabledata,columnheaders);/
		Step_Start(56, "Verify import documentation ,container tab Updated carrier seal details shown correclty from MCN.", test, test1);

		if(CompareMapListValues2(ExpectedContainerList,headersValuesAct)) {
			System.out.println("Matched || Expected value was : " + ExpectedContainerList + " || Actual value was : " + headersValuesAct);
			Extent_pass_New(driver, "Matched || Expected value was : " + ExpectedContainerList + " || Actual value was : " + headersValuesAct, test,test1);
			Extent_pass_New(driver,"Matched || MCN Customer Table data was : \n"+ "<pre>" +MCN_Container_Tabledata+ "</pre> \n "+ "|| Actual Container Table data was : \n"+ "<pre>" +container_Tabledata+ "</pre>"    , test, test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + ExpectedContainerList + " || Actual value was : " + headersValuesAct);
			Extent_fail(driver, "NotMatched || Expected value was : " + ExpectedContainerList + " || Actual value was : " + headersValuesAct,test, test1);
		}
		Step_End(56, "Verify import documentation ,container tab Updated carrier seal details shown correclty from MCN.", test, test1);
		
		Step_Start(57,"once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(58,"click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(59,"click the yes and system has validate import dcoumentation is deleted", test, test1);

		if(Import_Documentation_delete_perform.equalsIgnoreCase("Yes")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		
		Step_End(59, ".once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_End(58,"click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(57,"click the yes and system has validate import dcoumentation is deleted", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
