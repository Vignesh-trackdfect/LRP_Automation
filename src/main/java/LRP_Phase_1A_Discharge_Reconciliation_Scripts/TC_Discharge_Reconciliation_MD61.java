package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD61 extends Keywords {

	public void Discharge_Reconciliation_MD61(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD61";
//Agency 
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Agency_Config_Module = Excel_data.get("Agency_Config_Module");
		String Agency_code_header = Excel_data.get("Agency_code_header");
		String Attribute_code_header = Excel_data.get("Attribute_code_header");
		String Condition = Excel_data.get("Global_Search_Condition");
		String Attribute = Excel_data.get("Agency_Attribute");
		String Description = Excel_data.get("Agency_Description");
		String Value = Excel_data.get("Agency_Value");

		//Import Documentation
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String bl_Number = Excel_data.get("bl_Number");
		String House_BL_Number = Excel_data.get("House_BL_Number");
		String documentation_Saved_Popup_Exp = Excel_data.get("documentation_Saved_Popup_Exp");
		String House_BL_Status_Saved_Exp = Excel_data.get("House_BL_Status_Saved_Exp");
		String ID_Container_Table_Name = Excel_data.get("ID_Container_Table_Name");
		String ID_Containers_Table_Headers = Excel_data.get("ID_Containers_Table_Headers");
		String HBL_Table_Name = Excel_data.get("HBL_Table_Name");
		String HBL_Table_Headers = Excel_data.get("HBL_Table_Headers");
		String HBL_Table_Compare_Header = Excel_data.get("HBL_Table_Compare_Header");
		String Container_Table_Compare_Header = Excel_data.get("Container_Table_Compare_Header");
		String House_BL_Status_New_Exp = Excel_data.get("House_BL_Status_New_Exp");
		String House_BL_Select_All_Container = Excel_data.get("House_BL_Select_All_Container");
		String House_BL_Containers_Select = Excel_data.get("House_BL_Containers_Select");

		// Discharge Recon
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String do_you_want_to_delete = Excel_data.get("do_you_want_to_delete");
		String ImportDoc_Select_Type1 = Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2 = Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3 = Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2 = Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3 = Excel_data.get("ImportDoc_Select_Value3");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String condition = Excel_data.get("condition");
		String pol_Value = Excel_data.get("pol_Value");
		String POL_Search_Header = Excel_data.get("POL_Search_Header");
		String BL_Number_Header = Excel_data.get("BL_Number_Header");
		String Dis_Recon_Module = Excel_data.get("Dis_Recon_Module");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Saved_pop_expected = Excel_data.get("Saved_pop_expected");
		String Shipment_Category = Excel_data.get("Shipment_Category");
		String Plan_Input=Excel_data.get("Plan_Input");
		String Shipment_Category_pop_Expected=Excel_data.get("Shipment_Category_pop_Expected");
		String Discharge_Header=Excel_data.get("Discharge_Header");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);
		String shipment_select = String.format(Change_shipment_select, Shipment_Category);	
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);
		
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency", test, test1);
		
		Step_Start(1, " Switch to agency", test, test1);
		Step_Start(2, " Open Agency configuration module", test, test1);
		Step_Start(3, " Click on New button,if new button not available go below steps", test, test1);
		Step_Start(4, " Click on agency code search Button", test, test1);
		Step_Start(5, "Enter the agency code and click on Show Button,", test, test1);
		Step_Start(6, "Verify that given configuration is already available if available and make sure that value is Marked as -N.Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y'", test, test1);
		Step_Start(7, " if marked as N move to next action", test, test1);
		Step_Start(8, " if Configuration marked as Y then Double click the row and change the Value to N and click (+)button", test, test1);
		Step_Start(9, " if Configuration is not added go to next step,", test, test1);
	
		
		
		setAgencyConfiguration(driver, Agency_Config_Module, Agency_code_header, Attribute_code_header, Condition,
				AgencyUser, Attribute, Description, Value);
		Step_End(1, " Switch to agency", test, test1);
		Step_End(2, " Open Agency configuration module", test, test1);
		Step_End(3, " Click on New button,if new button not available go below steps", test, test1);
		Step_End(4, " Click on agency code search Button", test, test1);
		Step_End(5, "Enter the agency code and click on Show Button,", test, test1);
		Step_End(6, "Verify that given configuration is already available if available and make sure that value is Marked as -N.Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y'", test, test1);
		Step_End(7, " if marked as N move to next action", test, test1);
		Step_End(8, " if Configuration marked as Y then Double click the row and change the Value to N and click (+)button", test, test1);
		Step_End(9, " if Configuration is not added go to next step,", test, test1);
		
		
		
		Step_Start(10.1, "Follow Import Documentation Script Import_Documentation_SC029 to save container based", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, dropdownCondition1, ImportDoc_Select_Type1, bl_Number,
					ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Service")) {

			newButton(driver);

			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, first_service_data);

			waitForElement(driver, grid_vesselcode_IMP_DOC);
			sendKeys(driver, grid_vesselcode_IMP_DOC, Vessels);

			waitForElement(driver, grid_voyagecode_IMP_DOC);
			sendKeys(driver, grid_voyagecode_IMP_DOC, Voyagenumber1);

			waitForElement(driver, grid_bound_IMP_DOC);
			sendKeys(driver, grid_bound_IMP_DOC, Boundinput);

			waitForElement(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, portCode);

			horizontalscroll(driver, grid_scroll, 300);
			click(driver, grid_terminal_IMP_DOC);
			sendKeys(driver, grid_terminal_IMP_DOC, terminalCode);
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);

			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);

			scrollTop(driver);
			scrollTop(driver);
			if (!pol_Value.equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, condition, pol_Value);
			}

			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			click(driver, select_Option_1);
			click(driver, slection_Label_2);
			click(driver, select_Option_2);

			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);

			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);

			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);

			twoColumnMultipleSearchWindow(driver, BL_Number_Header, condition, bl_Number);

		}
		waitForElement(driver, House_Button_Imp_DOC);
		deleteSavedBL(driver, House_BL_Status_New_Exp, dropdownCondition1, bl_Number);

		waitForElement(driver, House_Button_Imp_DOC);
		click(driver, House_Button_Imp_DOC);
		waitForElement(driver, HBL_Commodity_Table_Row);

		Map<String, List<String>> HBL_Updated_Exp = new HashMap<String, List<String>>();// new

		List<Map<String, String>> HBL_Tabledatas = getTableData(driver, HBL_Commodity_Table_Header,
				HBL_Commodity_Table_Row);
		List<String> HBL_columnheaders = splitAndExpand(HBL_Table_Headers);
		String HBL_Container_Tabledata = TableDataForReport(driver, HBL_Tabledatas, HBL_Table_Name, HBL_columnheaders);

		String headerName = "HouseBL No.";
		scrollBottom(driver);
		List<String> HouseBL_NewNumbers = splitAndExpand(House_BL_Number);

		List<String> ContainerValues = splitAndExpand(House_BL_Containers_Select, "/");
		Map<String, List<String>> HouseBL_Container = new HashMap<String, List<String>>();
		for (int k = 0; k < HouseBL_NewNumbers.size(); k++) {
			String HouseBL = HouseBL_NewNumbers.get(k);
			List<String> HouseBLContainer = splitAndExpand(ContainerValues.get(k));
			HouseBL_Container.put(HouseBL, HouseBLContainer);
		}

		if (HouseBL_NewNumbers.size() < 2) {
			List<String> ContainerLists = splitAndExpand2(House_BL_Containers_Select);
			waitForElement(driver, House_BL_Field);
			sendKeys(driver, House_BL_Field, House_BL_Number);
			click(driver, Add_House_BL_Button);

			waitForElement(driver, HBL_No_DropDown1);
			click(driver, HBL_No_DropDown1);
			String DropDown_Select1 = String.format(House_No_Select1, House_BL_Number);
			waitForElement(driver, DropDown_Select1);
			click(driver, DropDown_Select1);
			Map<String, List<String>> HBL_ContainersID_List = getColumnValuesByHeaders(HBL_Tabledatas,
					HBL_columnheaders);
			List<String> HBL_ContainerID_Exp = HBL_ContainersID_List.get(HBL_Table_Compare_Header);
			if (House_BL_Select_All_Container.equals("Yes")) {
				checkBox(driver, HBL_Check_Box, "Yes");
				HBL_Updated_Exp.put(House_BL_Number, HBL_ContainerID_Exp);
			} else {
				selectSpecificContainers(driver, ContainerLists);
				HBL_Updated_Exp.put(House_BL_Number, ContainerLists);
			}
			click(driver, Package_Add_Button);
			waitForElement(driver, HBL_Table_Row);

		} else {
			for (int i = 0; i < HouseBL_NewNumbers.size(); i++) {
				String New_BL_Number = HouseBL_NewNumbers.get(i);
				System.out.println("New_BL_Number : " + New_BL_Number);
				waitForElement(driver, House_BL_Field);
				sendKeys(driver, House_BL_Field, New_BL_Number);
				click(driver, Add_House_BL_Button);
				waitForElement(driver, HBL_No_DropDown1);
				click(driver, HBL_No_DropDown1);
				String DropDown_Select1 = String.format(House_No_Select1, New_BL_Number);
				waitForElement(driver, DropDown_Select1);
				click(driver, DropDown_Select1);
				List<String> BL_Containers = HouseBL_Container.get(New_BL_Number);
				selectSpecificContainers(driver, BL_Containers);
				click(driver, Package_Add_Button);
				waitForElement(driver, HBL_Table_Row);
				HBL_Updated_Exp.put(New_BL_Number, BL_Containers);

				List<Map<String, String>> HBL_Tabledatas_Result = getTableData(driver, HBL_Table_Header, HBL_Table_Row);
				Map<String, List<String>> headersValues = getColumnValuesByHeaders1(HBL_Tabledatas_Result, headerName,
						New_BL_Number, HBL_columnheaders);
				List<String> Act_ContainerNo = headersValues.get(HBL_Table_Compare_Header);

				System.out.println("Act_ContainerNo  : " + Act_ContainerNo);
				System.out.println("ContainerLists  : " + BL_Containers);

			}
		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForDisplay(driver, popup_Message);
		while (isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
			waitForDisplay(driver, popup_Message_Yes_Button);
		}
		
		
		
		waitForPopup(driver, popup_Message, documentation_Saved_Popup_Exp);
		String documentation_Saved_Popup = getText(driver, popup_Message);
		if (documentation_Saved_Popup_Exp.equals(documentation_Saved_Popup)) {
			System.out.println("Matched || Expected Popup was : " + documentation_Saved_Popup_Exp
					+ " || Actual Popup was : " + documentation_Saved_Popup);
			Extent_pass(driver, "Matched || Expected Popup was : " + documentation_Saved_Popup_Exp
					+ " || Actual Popup was : " + documentation_Saved_Popup, test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + documentation_Saved_Popup_Exp
					+ " || Actual Popup was : " + documentation_Saved_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + documentation_Saved_Popup_Exp
					+ " || Actual Popup was : " + documentation_Saved_Popup, test, test1);
		}
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (House_BL_Status_Saved_Exp.equals(house_BL_Status)) {
			System.out.println("Matched || Expected Popup was : " + House_BL_Status_Saved_Exp
					+ " || Actual Popup was : " + house_BL_Status);
			Extent_pass(driver, "Matched || Expected Popup was : " + House_BL_Status_Saved_Exp
					+ " || Actual Popup was : " + house_BL_Status, test, test1);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + House_BL_Status_Saved_Exp
					+ " || Actual Popup was : " + house_BL_Status);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + House_BL_Status_Saved_Exp
					+ " || Actual Popup was : " + house_BL_Status, test, test1);
		}
		List<String> columnheaders = splitAndExpand(ID_Containers_Table_Headers);
		for (int j = 0; j < HBL_Updated_Exp.size(); j++) {
			waitForElement(driver, HBL_No_DropDown);
			click(driver, HBL_No_DropDown);
			String DropDown_Select1 = String.format(DropDown_Select, HouseBL_NewNumbers.get(j));
			click(driver, DropDown_Select1);
			waitForElement(driver, Container_Tab_IMD);
			click(driver, Container_Tab_IMD);
			scrollBottom(driver);
			waitForElement(driver, Container_Table_Header);
			List<Map<String, String>> HBL_Container_Tabledatas = getTableData(driver, Container_Table_Header,
					Container_Table_Row);
			String Container_TabledataExp = TableDataForReport(driver, HBL_Container_Tabledatas,
					ID_Container_Table_Name, columnheaders);
			Map<String, List<String>> headersValues = getColumnValuesByHeaders(HBL_Container_Tabledatas, columnheaders);

			List<String> Container_EquipmentID = headersValues.get(Container_Table_Compare_Header);
			List<String> Container_EquipmentExp = HBL_Updated_Exp.get(HouseBL_NewNumbers.get(j));

			if (CompareListvalues(Container_EquipmentExp, Container_EquipmentID)) {
				System.out.println("  Passed    *********  -> House_BL_Number");
				Extent_pass(driver,
						"Expected Containers updated in the respective House BL  : " + HouseBL_NewNumbers.get(j)
								+ " ||  Exp :  " + Container_EquipmentExp + "  || Act  : " + Container_EquipmentID,
						test, test1);
				Extent_pass(driver, "Matched || Expected Table : " + HBL_Container_Tabledata + " || Actual Table : "
						+ Container_TabledataExp, test, test1);
			} else {
				System.out.println("  Failed    *********  -> House_BL_Number");
				Extent_fail(driver,
						"Expected Containers not updated in the respective House BL  : " + HouseBL_NewNumbers.get(j)
								+ " ||  Exp :  " + Container_EquipmentExp + "  || Act  : " + Container_EquipmentID,
						test, test1);
			}
			scrollTop(driver);
		}

		if (do_you_want_to_delete.equals("Yes")) {
			scrollTop(driver);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, "Do you want to delete");

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Step_End(10.1, "Follow Import Documentation Script Import_Documentation_SC029 to save container based", test, test1);
		Step_Start(10.2, "Open Discharge Reconciliation Module", test, test1);
moduleNavigate(driver, Dis_Recon_Module);
		
		
		Step_End(10.2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(11, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		newButton(driver);

		Step_End(11, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		
		Step_Start(12, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		   
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
		
				if(!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		Step_End(12, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		
		Step_Start(13, "Select the Plan as ALL/Local/Transhipment", test, test1);
		
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(13, "Select the Plan as ALL/Local/Transhipment", test, test1);
	
		Step_Start(14, "Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(14, "Click on Download BL Button.", test, test1);
		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Discharge_Header);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, bl_Number);
		
		Step_Start(14.1, "Verify that Given BL has Muliple HBls that is Listed Discharge reconciliation module", test, test1);
		List<WebElement> blnumber_gird = listOfElements(driver, Hbl_Number_Gird);
		List<String> textList = new ArrayList<>();

		for (WebElement element : blnumber_gird) {
		    textList.add(element.getText().trim()); 
		
		System.out.println("Texts from elements: " + textList);
		Extent_pass(driver, "HBL Number was shown listed in the gird was :"+textList, test, test1);
		}
		Step_End(14.1, "Verify that Given BL has Muliple HBls that is Listed Discharge reconciliation module", test, test1);
		Step_Start(15, "select Only HBLA Row.", test, test1);
		waitForElement(driver, Bl_Number_input_re_con_row_click);
	click(driver, Bl_Number_input_re_con_row_click);
	Step_End(15, "select Only HBLA Row.", test, test1);
	Step_Start(16, "select the Row and right click it.", test, test1);
	RightClick(driver, Bl_Number_input_re_con_row_click);
	Step_End(16, "select the Row and right click it.", test, test1);
	Step_Start(17, "select as change the shipment category option", test, test1);
	waitForElement(driver, Change_shipment);
	click(driver, Change_shipment);
	Step_End(17, "select as change the shipment category option", test, test1);
	Step_Start(18, "system will be open new window, user can select the Shipment Catagory as DPD+CFS.", test, test1);
	waitForElement(driver, shipment_select);
	click(driver, shipment_select);
	Step_End(18, "system will be open new window, user can select the Shipment Catagory as DPD+CFS.", test, test1);
	Step_Start(19, "and click on Update Button", test, test1);
	waitForElement(driver, Change_shipment_select_update);
	click(driver, Change_shipment_select_update);
	Step_End(19, "and click on Update Button", test, test1);
	Step_Start(20, " Verify that system shows Validation as ' Book Number should be used same Shipment Category' and click on Ok", test, test1);
		waitForPopup(driver, popup_Message,Shipment_Category_pop_Expected);
		String popact = getText(driver, popup_Message);

		if (Shipment_Category_pop_Expected.equals(popact)) {
			System.out.println(
					"Matched || Expected popup message was : " + Shipment_Category_pop_Expected + " || Actual popup message was : " + popact);
			Extent_pass(driver,
					"Matched || Expected popup message was : " + Shipment_Category_pop_Expected + " || Actual popup message was : " + popact, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup message was : " + Shipment_Category_pop_Expected + " || Actual popup message was : " + popact);
			Extent_fail(driver,
					"Not Matched || Expected popup message was : " + Shipment_Category_pop_Expected + " || Actual popup message was  : " + popact,
					test, test1);
		}
		Step_End(20, " Verify that system shows Validation as ' Book Number should be used same Shipment Category' and click on Ok", test, test1);
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, bl_Number);
		Step_Start(20.1, " Select the BLs Related to all the HBLs", test, test1);
		List<WebElement> blnumber_gird1 = listOfElements(driver, Bl_Number_input_re_con_rowfull_click);

		for (int i = 1; i < blnumber_gird1.size(); i++) { // start at 1 to skip first element
		    WebElement element = blnumber_gird1.get(i);

		    Actions actions = new Actions(driver);
		    actions.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
			Step_End(20.1, " Select the BLs Related to all the HBLs", test, test1);
		}
		RightClick(driver, Bl_Number_input_re_con_row_click);
		Step_Start(20.2, " select as change the shipment category option ", test, test1);
		waitForElement(driver, Change_shipment);
		click(driver, Change_shipment);
		Step_End(20.2, " select as change the shipment category option ", test, test1);
		Step_Start(20.3, "system will be open new window, user can select the Shipment Catagory as DPD+CFS", test, test1);
		waitForElement(driver, shipment_select);
		click(driver, shipment_select);
		Step_End(20.3, "system will be open new window, user can select the Shipment Catagory as DPD+CFS", test, test1);
		Step_Start(20.4, " and click on Update Button,", test, test1);
		waitForElement(driver, Change_shipment_select_update);
		click(driver, Change_shipment_select_update);
		Step_End(20.4, " and click on Update Button,", test, test1);
		Step_Start(20.5, " Click on SHipment Category Button", test, test1);
		waitForElement(driver, Shipment_Cat_Button);
		click(driver, Shipment_Cat_Button);
		Step_End(20.5, " Click on SHipment Category Button", test, test1);
		Step_Start(20.6, " system shows shipment category updated. and clik on Ok", test, test1);
		waitForPopup(driver, popup_Message,Saved_pop_expected);
		String popact1 = getText(driver, popup_Message);

		if (Saved_pop_expected.equals(popact1)) {
			System.out.println(
					"Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was : " + popact1);
			Extent_pass(driver,
					"Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was : " + popact1, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was : " + popact1);
			Extent_fail(driver,
					"Not Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was  : " + popact1,
					test, test1);
		}
		Step_End(20.6, " system shows shipment category updated. and clik on Ok", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		
		
		
		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Discharge_Header);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, bl_Number);
		waitForElement(driver, Shipment_type_text);
		
		
		String Shipment_category = getText(driver, Shipment_type_text);

		if (Shipment_Category.equals(Shipment_category)) {
			System.out.println(
					"Matched || Expected Shipment category  was : " + Shipment_Category + " || Actual Shipment category was : " + Shipment_category);
			Extent_pass(driver,
					"Matched || Expected Shipment category was : " + Shipment_Category + " || Actual Shipment category was : " + Shipment_category, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Shipment category was : " + Shipment_Category + " || Actual Shipment category was : " + Shipment_category);
			Extent_fail(driver,
					"Not Matched || Expected Shipment category was : " + Shipment_Category + " || Actual Shipment category was  : " + Shipment_category,
					test, test1);
		}
		Step_Start(21, "Navigate to Import Documentation module", test, test1);
		waitForElement(driver, importDocumentation_Button_DRC);
		click(driver, importDocumentation_Button_DRC);
		Step_End(21, "Navigate to Import Documentation module", test, test1);
		Step_Start(22, "Select the Bl NO in BL NO search", test, test1);
		waitForElement(driver, BL_SearchButton_IMP_DOC);
		click(driver, BL_SearchButton_IMP_DOC);
		
		twoColumnSearchWindow(driver, BL_Number_Header, condition, bl_Number);
		
		Step_End(22, "Select the Bl NO in BL NO search", test, test1);
		

for (int j = 0; j < HBL_Updated_Exp.size(); j++) {
	Step_Start(23, "Select the HBLA and go to BL/HBL summary Place", test, test1);
	Step_Start(25, "Select the HBLB and go to BL/HBL summary Place", test, test1);
	
	waitForElement(driver, HBL_No_DropDown);
	click(driver, HBL_No_DropDown);
	Step_End(23, "Select the HBLA and go to BL/HBL summary Place", test, test1);
	Step_End(25, "Select the HBLB and go to BL/HBL summary Place", test, test1);
	Step_Start(24, "verify that same shipment category listed for HBLA", test, test1);
	Step_Start(26, "verify that same shipment category listed for HBLB", test, test1);
	String DropDown_Select1 = String.format(DropDown_Select, HouseBL_NewNumbers.get(j));
	click(driver, DropDown_Select1);
	Step_End(24, "verify that same shipment category listed for HBLA", test, test1);
	Step_End(26, "verify that same shipment category listed for HBLB", test, test1);
	waitForElement(driver, BL_HBL_Summary_Tab);
	click(driver, BL_HBL_Summary_Tab);
	scrollBottom(driver);
	
	String DPD_Code_Act = getText(driver, DPD_Code_text);

	System.out.println(DPD_Code_Act);

	if (Shipment_Category.equals(DPD_Code_Act)) {
		System.out.println(
				"Matched || Expected Shipment category  was taken in Dischange Reconciliation : " + Shipment_Category + " || Actual Shipment category was  taken in import documentation: " + DPD_Code_Act);
		Extent_pass(driver,
				"Matched || Expected Shipment category was taken in Dischange Reconciliation: " + Shipment_Category + " || Actual Shipment category was taken in import documentation: " + DPD_Code_Act, test,
				test1);
	} else {
		System.out.println(
				"Not Matched || Expected Shipment category was taken in Dischange Reconciliation : " + Shipment_Category + " || Actual Shipment category was taken in import documentation : " + DPD_Code_Act);
		Extent_fail(driver,
				"Not Matched || Expected Shipment category was taken in Dischange Reconciliation: " + Shipment_Category + " || Actual Shipment category was  taken in import documentation: " + DPD_Code_Act,
				test, test1);
	}
	
}
	
		Extent_completed(testcase_Name, test, test1);

		
		

	}

}
