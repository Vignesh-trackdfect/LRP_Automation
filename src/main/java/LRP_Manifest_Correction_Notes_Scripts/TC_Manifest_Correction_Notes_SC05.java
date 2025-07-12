package LRP_Manifest_Correction_Notes_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Manifest_Correction_Notes_SC05 extends Keywords{

	String Ports_Module = "";
	String Ports_Search_Type_Select ="";
	String dropdownCondition = "";
	String fromDate="";
	String toDate="";
	String module_MCN_Gate="";
	String module_MCN ="";
	String Want_To_Accept_Popup ="";
	String Accepted_Popup ="";
	String Want_To_Apporove_Popup ="";
	String MCN_Approval_Remarks_Input ="";
	String Approved_Popup ="";
	String datePicker="";
	public void Manifest_Correction_Notes_SC05(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws InterruptedException {
		String testcase_Name="TC_Manifest_Correction_Notes_SC05";
		//		Get Excel_data from test Excel_data

		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_MCN=Excel_data.get("Module_MCN");
		String module_ManifestClosure=Excel_data.get("Module_ManifestClosure");
		String correction_Type=Excel_data.get("CorrectionType");
		String globalSearchFilterOption_MCN=Excel_data.get("GlobalSearchFilterOption_MCN");
		dropdownCondition=Excel_data.get("GlobalSearchDropdownCondition");
		String globalSearch_Value=Excel_data.get("GlobalSearch_Value");
		String globalSearch_Value_Commodity=Excel_data.get("GlobalSearch_Value_Commodity");
		String globalSearchFilterOption_Commodity=Excel_data.get("GlobalSearchFilterOption_Commodity");
		String commodityCode=Excel_data.get("CommodityCode");
		String marks_Number=Excel_data.get("Marks_Number");
		String commodity_Desc=Excel_data.get("Commodity_Desc");
		String cargo_Weight=Excel_data.get("Cargo_Weight");
		String closure_Status_Header=Excel_data.get("Closure_Status_Header");
		String closure_Status=Excel_data.get("Closure_Status");
		Want_To_Accept_Popup=Excel_data.get("Want_To_Accept_Popup");
		Accepted_Popup=Excel_data.get("Accepted_Popup");
		Want_To_Apporove_Popup=Excel_data.get("Want_To_Apporove_Popup");
		Approved_Popup=Excel_data.get("Approved_Popup");
		MCN_Approval_Remarks_Input=Excel_data.get("MCN_Approval_Remarks_Input");
		String globalSearchFilterOption_MCN_Closure=Excel_data.get("GlobalSearchFilterOption_MCN_Closure");
		String want_To_Save_Popup=Excel_data.get("Want_To_Save_Popup");
		String pendingSaved_Popup=Excel_data.get("PendingSaved_Popup");
		String submitted_Saved_Popup=Excel_data.get("Submitted_Saved_Popup");
		String mail_Id=Excel_data.get("Mail_Id");
		String mail_Password=Excel_data.get("Mail_Password");
		String mail_Subject=Excel_data.get("Mail_Subject");
		String approved_Mail_Subject=Excel_data.get("Approved_Mail_Subject");
		String mail_SignIn_Page_Url=Excel_data.get("Mail_SignIn_Page_Url");
		Ports_Module=Excel_data.get("Ports_Module");
		Ports_Search_Type_Select=Excel_data.get("Ports_Search_Type_Select");
		module_MCN_Gate=Excel_data.get("Module_MCN_Gate");
		String MCN_Submit_Remarks_Input=Excel_data.get("MCN_Submit_Remarks_Input");
		String import_Documentation_Popup=Excel_data.get("Import_Documentation_Popup");
		String yellow_ColorCode=Excel_data.get("Yellow_ColorCode");
		fromDate=Excel_data.get("FromDate");
		toDate=Excel_data.get("ToDate");
		String want_To_Close_Manifest_Popup=Excel_data.get("Want_To_Close_Manifest_Popup");
		String bl_Closed_Popup=Excel_data.get("BL_Closed_Popup");
		String status_Tab_Table_Headers=Excel_data.get("Status_Tab_Table_Headers");
		String equipment_ID=Excel_data.get("Equipment_ID");
		String rate_Number=Excel_data.get("Rate_Number");
		String carrier_Seal=Excel_data.get("Carrier_Seal");
		String blue_ColorCode=Excel_data.get("Blue_ColorCode");
		String package_Input=Excel_data.get("Package_Input");
		String commodity_Group=Excel_data.get("Commodity_Group");
		String hs_Code=Excel_data.get("HS_Code");
		String OFR_Popup=Excel_data.get("OFR_Popup");
		String not_Refreshed_Tab=Excel_data.get("Not_Refreshed_Tab");
		String want_To_Edit_Popup=Excel_data.get("Want_To_Edit_Popup");
		String shipper_Seal=Excel_data.get("Shipper_Seal");
		String chassis=Excel_data.get("Chassis");
		String rateRule=Excel_data.get("RateRule");
		String otherSeal=Excel_data.get("OtherSeal");
		String transMovement=Excel_data.get("TransMovement");
		String containerLoadInstruction=Excel_data.get("ContainerLoadInstruction");
		String shipperOwned_Checkbox=Excel_data.get("ShipperOwned_Checkbox");
		String DG_Checkbox=Excel_data.get("DG_Checkbox");
		String laden_Checkbx=Excel_data.get("Laden_Checkbx");
		String equipment_ID_Edit=Excel_data.get("Equipment_ID_Edit");
		String quantity=Excel_data.get("Quantity");
		String volume=Excel_data.get("Volume");
		String netWeight=Excel_data.get("NetWeight");
		String unit=Excel_data.get("Unit");
		String volumeUnit=Excel_data.get("VolumeUnit");
		String alchohol_Checkbox=Excel_data.get("Alchohol_Checkbox");
		String militaryCargo_Checkbox=Excel_data.get("MilitaryCargo_Checkbox");

		navigateUrl(driver,url);
		Extent_Start(testcase_Name, test, test1);
		//		Login
		LRP_Login(driver, username, password);
		Step_Start(1, "switch to agency", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "switch to agency", test, test1);
		//		Manifest Closure
		Extent_cal(test, test1, module_ManifestClosure);
		Step_Start(2, "Retrieve the BL using BL No. or Service/Vessel/Voyage/Bound in manifest closure module.", test, test1);
		moduleNavigate(driver, module_ManifestClosure);
		waitForElement(driver, by_BL_RadioButton_MCN);
		click(driver, by_BL_RadioButton_MCN);
		waitForDisplay(driver, bl_SearchButon_MCN);
		click(driver, bl_SearchButon_MCN);
		Step_Start(3, "Select the BL No. in the grid", test, test1);
		globalValueSearchWindow(driver,dropdownCondition,globalSearchFilterOption_MCN_Closure,globalSearch_Value,"","","","");
		Step_End(3, "Select the BL No. in the grid", test, test1);
		Step_End(2, "Retrieve the BL using BL No. or Service/Vessel/Voyage/Bound in manifest closure module.", test, test1);
		Step_Start(4, "Click Manifest button to close  manifest.", test, test1);
		waitForElement(driver, MCN_Closure_Table_Row);
		List<Map<String, String>> mcn_Closure_TableData = getTableData(driver, MCN_Closure_Table_Column, MCN_Closure_Table_Row);
		List<String> closureStatus = getValuesByHeader(mcn_Closure_TableData, closure_Status_Header);
		if(!closureStatus.get(0).equals(closure_Status)) {
			waitForElement(driver, select_Checkbox_MCN);
			checkBox(driver, select_Checkbox_MCN, "Yes");
			waitForDisplay(driver, closeManifest_Button_MCN);
			click(driver, closeManifest_Button_MCN);
		waitForPopup(driver, popup_Message, want_To_Close_Manifest_Popup);
			String actual_wantToClose_Popup = getText(driver, popup_Message);
			if(actual_wantToClose_Popup.trim().equals(want_To_Close_Manifest_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+want_To_Close_Manifest_Popup+" || Actual Pop-up Message is : "+actual_wantToClose_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+want_To_Close_Manifest_Popup+" || Actual Pop-up Message is : "+actual_wantToClose_Popup, test, test1);
				click(driver, popup_Message_Yes_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+want_To_Close_Manifest_Popup+" || Actual Pop-up Message is : "+actual_wantToClose_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+want_To_Close_Manifest_Popup+" || Actual Pop-up Message is : "+actual_wantToClose_Popup, test, test1);
			}
		waitForPopup(driver, popup_Message, bl_Closed_Popup);
			String actual_Closed_Popup = getText(driver, popup_Message);
			if(actual_Closed_Popup.trim().equals(bl_Closed_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+bl_Closed_Popup+" || Actual Pop-up Message is : "+actual_Closed_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+bl_Closed_Popup+" || Actual Pop-up Message is : "+actual_Closed_Popup, test, test1);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+bl_Closed_Popup+" || Actual Pop-up Message is : "+actual_Closed_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+bl_Closed_Popup+" || Actual Pop-up Message is : "+actual_Closed_Popup, test, test1);
			}
		}
		click(driver, manifest_Closure_Module);
		click(driver, Module_Close);
		Step_End(4, "Click Manifest button to close  manifest.", test, test1);
		Step_Start(5, "Open the Manifest Correction Notes module.", test, test1);
		//		MCN
		Extent_cal(test, test1, module_MCN);
		moduleNavigate(driver, module_MCN);
		Step_End(5, "Open the Manifest Correction Notes module.", test, test1);
		Step_Start(6, "Choose the correction type as \"Cargo Correction\".", test, test1);
		waitForElement(driver, Corection_Type_DropDown);
		click(driver, Corection_Type_DropDown);
		String select_Correction_Type=String.format(DropDown_Select, correction_Type);
		waitForElement(driver, select_Correction_Type);
		click(driver, select_Correction_Type);
		Step_End(6, "Choose the correction type as \"Cargo Correction\".", test, test1);
		Step_Start(7, "Click the edit button in container grid.", test, test1);
		waitForElement(driver, BL_Search_Button_MCN);
		click(driver, BL_Search_Button_MCN);
		globalValueSearchWindow(driver,dropdownCondition,globalSearchFilterOption_MCN,globalSearch_Value,"","","","");
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			String actual_Continue_Popup = getText(driver, popup_Message);
			if(actual_Continue_Popup.trim().equals(import_Documentation_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+import_Documentation_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+import_Documentation_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup, test, test1);
				click(driver, popup_Message_Yes_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+import_Documentation_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+import_Documentation_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup, test, test1);
			}
		}
		//	Container tab
		waitForElement(driver, container_Tab_MCN);
		click(driver, container_Tab_MCN);
		String selectContainerEdit=String.format(containerGrid_Edit_Button, equipment_ID);
		waitForElement(driver, selectContainerEdit);
		click(driver, selectContainerEdit);
		Step_End(7, "Click the edit button in container grid.", test, test1);
		Step_Start(8, "Click the rateref search button to change the rate reference.", test, test1);
		waitForElement(driver, rate_Ref_No_SearchButton_MCN);
		click(driver, rate_Ref_No_SearchButton_MCN);
		Step_End(8, "Click the rateref search button to change the rate reference.", test, test1);
		Step_Start(9, "System will popup the rate reference search window", test, test1);
		waitForDisplay(driver, rate_Reference_Window_MCN);
		if(isdisplayed(driver, rate_Reference_Window_MCN)) {
			System.out.println("Passed || Rate Reference search window is diaplayed");
			Extent_pass_New(driver, "Passed || Rate Reference search window is diaplayed", test, test1);
		}else {
			System.out.println("Failed || Rate Reference search window is not diaplayed");
			Extent_pass_New(driver, "Failed || Rate Reference search window is not diaplayed", test, test1);
		}
		Step_End(9, "System will popup the rate reference search window", test, test1);
		Step_Start(10, "Select the rate reference & click the ok button/ Double click the rate reference.", test, test1);
		if(!rate_Number.equals("")) {
			String select_Rate_No=String.format(rate_No_Select_Checkbox_MCN, rate_Number);
			waitForElement(driver, select_Rate_No);
			checkBox(driver, select_Rate_No, "Yes");
		}else {
			waitForElement(driver, rateNumber_Checkbox_MCN);
			checkBox(driver, rateNumber_Checkbox_MCN, "Yes");
		}
		waitForElement(driver, rate_Refernce_Window_Ok_Button_MCN);
		click(driver, rate_Refernce_Window_Ok_Button_MCN);
		Step_End(10, "Select the rate reference & click the ok button/ Double click the rate reference.", test, test1);
		Step_Start(11, "Change the carrier seal & click edit button", test, test1);
		waitForElement(driver, equipment_ID_Textfield_MCN);
		String actual_EqpNumber=getAttribute(driver, equipment_ID_Textfield_MCN, "value");
		System.out.println("actual_EqpNumber: "+actual_EqpNumber);
		waitForElement(driver, carrier_Seal_Textfield_MCN);
		clearAndType(driver, carrier_Seal_Textfield_MCN, carrier_Seal);
		if(!shipper_Seal.equals("")) {
			waitForElement(driver, shipperSeal_Textfield_MCN);
			clearAndType(driver, shipperSeal_Textfield_MCN, shipper_Seal);
		}
		if(!equipment_ID_Edit.equals("")) {
			waitForElement(driver, equipment_ID_Textfield_MCN);
			clearAndType(driver, equipment_ID_Textfield_MCN, equipment_ID_Edit);
		}
		if(!chassis.equals("")) {
			waitForElement(driver, chassis_Textfield_MCN);
			clearAndType(driver, chassis_Textfield_MCN, chassis);
		}
		if(!rateRule.equals("")) {
			waitForElement(driver, rateRule_Textfield_MCN);
			clearAndType(driver, rateRule_Textfield_MCN, rateRule);
		}
		if(!otherSeal.equals("")) {
			waitForElement(driver, otherSeal_Textfield_MCN);
			clearAndType(driver, otherSeal_Textfield_MCN, otherSeal);
		}
		if(!transMovement.equals("")) {
			waitForElement(driver, trans_Movement_Dropdown_MCN);
			click(driver, trans_Movement_Dropdown_MCN);
			String select_transMovement=String.format(trans_Movement_Dropdown_Option_MCN, transMovement);
			waitForElement(driver, select_transMovement);
			click(driver, select_transMovement);
		}
		if(!containerLoadInstruction.equals("")) {
			waitForElement(driver, containerLoadInstruction_Dropdown_MCN);
			click(driver, containerLoadInstruction_Dropdown_MCN);
			String select_ContainerLoadInstruction=String.format(DropDown_Select, containerLoadInstruction);
			waitForElement(driver, select_ContainerLoadInstruction);
			click(driver, select_ContainerLoadInstruction);
		}
		if(!shipperOwned_Checkbox.equals("")) {
			checkBox(driver, shipperOwned_Checkbox_MCN, shipperOwned_Checkbox);
		}
		if(!DG_Checkbox.equals("")) {
			checkBox(driver, DG_Checkbox_MCN, DG_Checkbox);
		}
		if(!laden_Checkbx.equals("")) {
			checkBox(driver, laden_Checkbox_MCN, laden_Checkbx);
		}
		waitForElement(driver, container_Tab_Edit_Button_MCN);
		click(driver, container_Tab_Edit_Button_MCN);
		Step_End(11, "Change the carrier seal & click edit button", test, test1);
		Step_Start(12, "After edit, System will change the container grid as \"Blue color\"", test, test1);
		String containerGrid_Row=String.format(container_Grid_Row_MCN, actual_EqpNumber);
		waitForElement(driver, containerGrid_Row);
		String actual_containerGrid_Row_Color_Code=getTextBackgroundColor(driver, containerGrid_Row);
		String actual_containerGrid_Row_Color = getColorName(actual_containerGrid_Row_Color_Code);
		if(actual_containerGrid_Row_Color.equalsIgnoreCase(blue_ColorCode)) {
			System.out.println("Matched || The background color of container Grid Row is Blue || Expected Color of Container grid row is : "+blue_ColorCode+" || Actual Color of Container grid row is : "+actual_containerGrid_Row_Color);
			Extent_pass_New(driver, "Matched || The background color of container Grid Row is Blue || Expected Color of Container grid row is : "+blue_ColorCode+" || Actual Color of Container grid row is : "+actual_containerGrid_Row_Color, test, test1);
		}else {
			System.out.println("Not Matched || The background color of container Grid Row is Blue || Expected Color of Container grid row is : "+blue_ColorCode+" || Actual Color of Container grid row is : "+actual_containerGrid_Row_Color);
			Extent_fail(driver, "Not Matched || The background color of container Grid Row is Blue || Expected Color of Container grid row is : "+blue_ColorCode+" || Actual Color of Container grid row is : "+actual_containerGrid_Row_Color, test, test1);
		}
		Step_End(12, "After edit, System will change the container grid as \"Blue color\"", test, test1);
		Step_Start(13, "Click the edit button in commodity grid", test, test1);
		// Commodity tab
		waitForElement(driver, Manifest_Commodity_Tab);
		click(driver, commodity_Tab_MCN);
		String selectCommodityEdit=String.format(commodity_Grid_Edit_Button_MCN, equipment_ID);
		waitForElement(driver, selectCommodityEdit);
		click(driver, selectCommodityEdit);
		Step_End(13, "Click the edit button in commodity grid", test, test1);
		Step_Start(14, "By using easy search system allowed to  select the package.", test, test1);
		waitForElement(driver, package_Searchfield_MCN);
		click(driver, package_Searchfield_MCN);
		clear(driver, package_Searchfield_MCN);
		waitForElement(driver, package_Searchfield_MCN);
		sendKeys(driver, package_Searchfield_MCN, package_Input);
		String select_Package=String.format(autoComplete_Value, package_Input);
		waitForElement(driver, select_Package);
		click(driver, select_Package);
		if(!quantity.equals("")) {
			waitForElement(driver, quantity_Textfield_MCN);
			clearAndType(driver, quantity_Textfield_MCN, quantity);
		}
		Step_End(14, "By using easy search system allowed to  select the package.", test, test1);
		Step_Start(15, "Select the Comdty.Grp.By using easy search.", test, test1);
		if(!commodity_Group.equals("")) {
			waitForElement(driver, comm_Group_Searchfield_MCN);
			click(driver, comm_Group_Searchfield_MCN);
			clear(driver, comm_Group_Searchfield_MCN);
			waitForElement(driver, comm_Group_Searchfield_MCN);
			sendKeys(driver, comm_Group_Searchfield_MCN, commodity_Group);
			String select_Commodity_Group=String.format(autoComplete_Value, commodity_Group);
			waitForElement(driver, select_Commodity_Group);
			click(driver, select_Commodity_Group);
		}else {
			waitForElement(driver, hs_Code_SearchButton_MCN);
			click(driver, hs_Code_SearchButton_MCN);
			waitForElement(driver, type_Select1);
			selectByText(driver, type_Select1, globalSearchFilterOption_Commodity);
			if(globalSearch_Value_Commodity.equals("%")) {
				click(driver, globalSearch_Condition_Dropdown1);
				sendKeys(driver, globalSearch_InputTextfield1, globalSearch_Value_Commodity);
				click(driver, globalSearch_Frame_SearchButton);
				if(!commodityCode.equals("")) {
					waitForElement(driver, commotidyCode_Filter);
					sendKeys(driver, commotidyCode_Filter, commodityCode);
				}
			}else {
				waitForElement(driver, globalSearch_Condition_Dropdown1);
				selectByText(driver, globalSearch_Condition_Dropdown1, dropdownCondition);
				waitForElement(driver, globalSearch_InputTextfield1);
				sendKeys(driver, globalSearch_InputTextfield1, globalSearch_Value_Commodity);
				click(driver, globalSearch_Frame_SearchButton);
			}
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
		}
		Step_End(15, "Select the Comdty.Grp.By using easy search.", test, test1);
		Step_Start(16, "Change the HS Code by using easy search/entering  % symbol in JDLC commodity.", test, test1);
		if(!hs_Code.equals("")) {
			waitForElement(driver, comm_Group_Searchfield_MCN);
			click(driver, comm_Group_Searchfield_MCN);
			clear(driver, comm_Group_Searchfield_MCN);
			waitForElement(driver, comm_Group_Searchfield_MCN);
			sendKeys(driver, comm_Group_Searchfield_MCN, hs_Code);
			String select_HS_Code=String.format(autoComplete_Value, hs_Code);
			waitForElement(driver, select_HS_Code);
			click(driver, select_HS_Code);
		}else {
			waitForElement(driver, hs_Code_SearchButton_MCN);
			click(driver, hs_Code_SearchButton_MCN);
			waitForElement(driver, type_Select1);
			selectByText(driver, type_Select1, globalSearchFilterOption_Commodity);
			if(globalSearch_Value_Commodity.equals("%")) {
				sendKeys(driver, globalSearch_InputTextfield1, globalSearch_Value_Commodity);
				click(driver, globalSearch_Frame_SearchButton);
				if(!commodityCode.equals("")) {
					waitForElement(driver, commotidyCode_Filter);
					sendKeys(driver, commotidyCode_Filter, commodityCode);
				}
			}else {
				waitForElement(driver, globalSearch_Condition_Dropdown1);
				selectByText(driver, globalSearch_Condition_Dropdown1, dropdownCondition);
				click(driver, globalSearch_InputTextfield1);
				sendKeys(driver, globalSearch_InputTextfield1, globalSearch_Value_Commodity);
				click(driver, globalSearch_Frame_SearchButton);
			}
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
		}
		Step_End(16, "Change the HS Code by using easy search/entering  % symbol in JDLC commodity.", test, test1);
		Step_Start(17, "Change Marks No. manually.", test, test1);
		waitForElement(driver, marks_and_Number_Textarea_MCN);
		clearAndType(driver, marks_and_Number_Textarea_MCN, marks_Number);
		Step_End(17, "Change Marks No. manually.", test, test1);
		Step_Start(18, "Enter Commodity Desc. manually/click copy button", test, test1);
		if(!commodity_Desc.equals(" ")) {
			waitForElement(driver, commodity_Desc_MCN);
			clearAndType(driver, commodity_Desc_MCN, commodity_Desc);
		}else {
			waitForElement(driver, copy_Desc_Button_MCN);
			click(driver, copy_Desc_Button_MCN);
		}
		if(!volume.equals("")) {
			waitForElement(driver, volume_Textfield_MCN);
			clearAndType(driver, volume_Textfield_MCN, volume);
		}
		if(!netWeight.equals("")) {
			waitForElement(driver, net_Weight_Textfield_MCN);
			clearAndType(driver, net_Weight_Textfield_MCN, netWeight);
		}
		if(!unit.equals("")) {
			waitForElement(driver, unit_Dropdown_MCN);
			click(driver, unit_Dropdown_MCN);
			String select_Unit=String.format(select_Unit_MCN, unit);
			waitForElement(driver, select_Unit);
			click(driver, select_Unit);
		}
		if(!volumeUnit.equals("")) {
			waitForElement(driver, volume_Unit_Dropdown_MCN);
			click(driver, volume_Unit_Dropdown_MCN);
			String select_Unit=String.format(volume_Unit_Dropdown_Option_MCN, volumeUnit);
			waitForElement(driver, select_Unit);
			click(driver, select_Unit);
		}
		Step_End(18, "Enter Commodity Desc. manually/click copy button", test, test1);
		Step_Start(19, "Change the cargo weight.", test, test1);
		waitForElement(driver, cargo_Weight_Textfield_MCN);
		clearAndType(driver, cargo_Weight_Textfield_MCN, cargo_Weight);
		if(!alchohol_Checkbox.equals("")) {
			checkBox(driver, commodity_Tab_Alcohol_CheckBox_MCN, alchohol_Checkbox);
		}
		if(!militaryCargo_Checkbox.equals("")) {
			checkBox(driver, commodity_Tab_MilitaryCargo_CheckBox_MCN, militaryCargo_Checkbox);
		}
		Step_End(19, "Change the cargo weight.", test, test1);
		Step_Start(20, "After entered  all details click the edit button  in commodity grid system will set all the commodity details.", test, test1);
		waitForElement(driver, commodity_Tab_Edit_Button_MCN);
		click(driver, commodity_Tab_Edit_Button_MCN);
		Step_End(20, "After entered  all details click the edit button  in commodity grid system will set all the commodity details.", test, test1);
		Step_Start(21, "Click save button .", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(21, "Click save button System validated to enter OFR charges.", test, test1);
		Step_Start(22, "If System validated to enter OFR charges click on auto rate button, once charges pop up now click save button.", test, test1);
		waitForDisplay(driver, MCN_Message);
		if(isdisplayed(driver, MCN_Message)) {
			String actual_OFR_Popup1 = getText(driver, MCN_Message);
			if(actual_OFR_Popup1.trim().equals(OFR_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+OFR_Popup+" || Actual Pop-up Message is : "+actual_OFR_Popup1);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+OFR_Popup+" || Actual Pop-up Message is : "+actual_OFR_Popup1, test, test1);
				click(driver, MCN_Message_Close_Button);
				waitForElement(driver, charges_Tab_MCN);
				click(driver, charges_Tab_MCN);
				waitForElement(driver, autoCharges_Button_MCN);
				click(driver, autoCharges_Button_MCN);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+OFR_Popup+" || Actual Pop-up Message is : "+actual_OFR_Popup1);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+OFR_Popup+" || Actual Pop-up Message is : "+actual_OFR_Popup1, test, test1);
			}
		}
		Step_End(22, "If System validated to enter OFR charges click on auto rate button, once charges pop up now click save button.", test, test1);
		Step_Start(23, "Now system validated with \" Body Tab details not refreshed. Use right click to refresh\"", test, test1);
	waitForPopup(driver, popup_Message, not_Refreshed_Tab);
		String actual_NotRefreshed_Popup = getText(driver, popup_Message);
		if(actual_NotRefreshed_Popup.trim().equals(not_Refreshed_Tab.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+not_Refreshed_Tab+" || Actual Pop-up Message is : "+actual_NotRefreshed_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+not_Refreshed_Tab+" || Actual Pop-up Message is : "+actual_NotRefreshed_Popup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+not_Refreshed_Tab+" || Actual Pop-up Message is : "+actual_NotRefreshed_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+not_Refreshed_Tab+" || Actual Pop-up Message is : "+actual_NotRefreshed_Popup, test, test1);
		}
		Step_End(23, "Now system validated with \" Body Tab details not refreshed. Use right click to refresh\"", test, test1);
		Step_Start(24, "Click ok & edit button in body tab System will popup with \"Do you want to edit Body Details? This will be validated in the approval process\". ", test, test1);
		click(driver, popup_Message_Ok_Button);
		waitForElement(driver, body_Tab_Edit_Button_MCN);
		click(driver, body_Tab_Edit_Button_MCN);
	waitForPopup(driver, popup_Message, want_To_Edit_Popup);
		String actual_WantToEdit_Popup = getText(driver, popup_Message);
		if(actual_WantToEdit_Popup.trim().equals(want_To_Edit_Popup)) {
			System.out.println("Matched || Expected Pop-up Message is : "+want_To_Edit_Popup+" || Actual Pop-up Message is : "+actual_WantToEdit_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+want_To_Edit_Popup+" || Actual Pop-up Message is : "+actual_WantToEdit_Popup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+want_To_Edit_Popup+" || Actual Pop-up Message is : "+actual_WantToEdit_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+want_To_Edit_Popup+" || Actual Pop-up Message is : "+actual_WantToEdit_Popup, test, test1);
		}
		Step_End(24, "Click ok & edit button in body tab System will popup with \"Do you want to edit Body Details? This will be validated in the approval process\". ", test, test1);
		Step_Start(25, "Click yes to proceed further.", test, test1);
		click(driver, popup_Message_Yes_Button);
		Step_End(25, "Click yes to proceed further.", test, test1);
		Step_Start(26, "Right click on the body tab and click refresh all.", test, test1);
		waitForElement(driver, Text_Area);
		RightClick(driver, Text_Area);
		waitForElement(driver, Refresh_All_Button);
		click(driver, Refresh_All_Button);
		Step_End(26, "Right click on the body tab and click refresh all.", test, test1);
		Step_Start(27, "Click save button.", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(27, "Click save button.", test, test1);
		Step_Start(28, "System will popup with Pending/Submit/Cancel message", test, test1);
		waitForPopup(driver, popup_Message_MCN, want_To_Save_Popup);
		String actual_Popup = getText(driver, popup_Message_MCN);
		if(actual_Popup.trim().equals(want_To_Save_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}
		Step_End(28, "System will popup with Pending/Submit/Cancel message", test, test1);
		Step_Start(29, "Click pending to proceed", test, test1);
		click(driver, Manifest_Pending_Button);
		Step_End(29, "Click pending to proceed", test, test1);
		Step_Start(30, "System will save the MCN number in pending status with yellow color", test, test1);
	waitForPopup(driver, popup_Message, pendingSaved_Popup);
		String actual_Pending_Popup = getText(driver, popup_Message);
		if(actual_Pending_Popup.trim().contains(pendingSaved_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+pendingSaved_Popup+" || Actual Pop-up Message is : "+actual_Pending_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+pendingSaved_Popup+" || Actual Pop-up Message is : "+actual_Pending_Popup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+pendingSaved_Popup+" || Actual Pop-up Message is : "+actual_Pending_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+pendingSaved_Popup+" || Actual Pop-up Message is : "+actual_Pending_Popup, test, test1);
		}
		waitForElement(driver, MCN_Number_Textfield_MCN_Module);
		String actual_MCN_Number=getAttribute(driver, MCN_Number_Textfield_MCN_Module, "value");
		System.out.println("Generarted MCN Number : "+actual_MCN_Number);
		Extent_pass_New(driver, "Generarted MCN Number : "+actual_MCN_Number, test, test1);
		String actual_MCN_Textfield_Color_Code=getTextBackgroundColor(driver, MCN_Number_Textfield_MCN_Module);
		String actual_MCN_Textfield_Color = getColorName(actual_MCN_Textfield_Color_Code);
		if(actual_MCN_Textfield_Color.equalsIgnoreCase(yellow_ColorCode)) {
			System.out.println("Matched || The background color of MCN Textfield is Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
			Extent_pass_New(driver, "Matched || The background color of MCN Textfield is Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
		}else {
			System.out.println("Not Matched || The background color of MCN Textfield is not Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
			Extent_fail(driver, "Not Matched || The background color of MCN Textfield is not Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
		}
		Step_End(30, "System will save the MCN number in pending status with yellow color", test, test1);
		Step_Start(31, "Now Click edit button in toolbar & click save button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(31, "Now Click edit button in toolbar & click save button", test, test1);
		Step_Start(32, "System will popup  with pending/Submit/Cancel message", test, test1);
		waitForPopup(driver, popup_Message_MCN, want_To_Save_Popup);
		actual_Popup = getText(driver, popup_Message_MCN);
		if(actual_Popup.trim().equals(want_To_Save_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}
		Step_End(32, "System will popup  with pending/Submit/Cancel message", test, test1);
		Step_Start(33, "Now click on submit button then system will open MCN remarks window.", test, test1);
		waitForElement(driver, Manifest_Submit_Button);
		click(driver, Manifest_Submit_Button);
		Step_End(33, "Now click on submit button then system will open MCN remarks window.", test, test1);
		Step_Start(34, "Enter remarks to submit.", test, test1);
		waitForElement(driver, Remarks_Field);
		sendKeys(driver, Remarks_Field, MCN_Submit_Remarks_Input);
		click(driver, Remarks_OK_Button);
		Step_End(34, "Enter remarks to submit.", test, test1);
		Step_Start(35, "Based on entity System will auto approve the MCN.", test, test1);
	waitForPopup(driver, popup_Message, submitted_Saved_Popup);
		String actual_Submitted_Popup = getText(driver, popup_Message);
		if(actual_Submitted_Popup.trim().equals(submitted_Saved_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else if(actual_Submitted_Popup.trim().equals(Approved_Popup.trim())){
			System.out.println("Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup, test, test1);
		}
		Step_End(35, "Based on entity System will auto approve the MCN.", test, test1);
		Step_Start(36, "Then in mail window enter correct mail id and click on send button.", test, test1);
		waitForElement(driver, Mail_To_Field_MCN);
		clearAndType(driver, Mail_To_Field_MCN, mail_Id);
		waitForElement(driver, Mail_Send_Button_MCN);
		click(driver, Mail_Send_Button_MCN);
		Step_End(36, "Then in mail window enter correct mail id and click on send button.", test, test1);
		Step_Start(37, "Then verify whether mail received or not in mail inbox", test, test1);
		waitForElement(driver, MCN_Number_Textfield_MCN_Module);
		if(actual_Submitted_Popup.trim().equals(submitted_Saved_Popup.trim())) {
			mailinator_Verification(driver, mail_SignIn_Page_Url, mail_Id,mail_Subject+actual_MCN_Number);
		}else if(actual_Submitted_Popup.trim().equals(Approved_Popup.trim())){
			mailinator_Verification(driver, mail_SignIn_Page_Url, mail_Id,approved_Mail_Subject+actual_MCN_Number);

		}
		Step_End(37, "Then verify whether mail received or not in mail inbox", test, test1);
		Step_Start(38, "Now in MCN status tab check which are entity are available, if next entity is final port agency ,then switch profile to new pod agency", test, test1);
		waitForElement(driver, status_Tab_MCN);
		click(driver, status_Tab_MCN);
		waitForElement(driver, status_Tab_TableRow_MCN);
		List<Map<String, String>> statusTable_Data = getTableData(driver, status_Tab_TableColumn_MCN, status_Tab_TableRow_MCN);
		List<String> statusTableHeader = splitAndExpand(status_Tab_Table_Headers);
		List<String> entity = getValuesByHeader(statusTable_Data, statusTableHeader.get(0));
		List<String> status = getValuesByHeader(statusTable_Data, statusTableHeader.get(1));
		waitForElement(driver, Master_Tab_MCN);
		click(driver, Master_Tab_MCN);
		waitForElement(driver, POL_Value);
		String origin_Port = getText(driver, POL_Value);
		String final_Port = getText(driver, PLD_Location_MCN);
		String discharge_Port=getText(driver, pod_Port_MCN);
		String DOC_Port = getAttribute(driver, Doc_Agency, "value");
		waitForElement(driver, Manifest_Charges_Tab);
		click(driver, Manifest_Charges_Tab);
		waitForElement(driver, MCN_Charges_Table_Headers);
		List<Map<String, String>> MCN_Chareges_Tabledata = getTableData(driver, MCN_Charges_Table_Headers,
				MCN_Charges_Table_Rows);
		String elseWhere_Agency = getValueByFirstColumnPartialValueAndHeader(MCN_Chareges_Tabledata, "Payment Mode", "PayAt", "Pay Location");
		waitForElement(driver, cancel_Button_MCN);
		click(driver, cancel_Button_MCN);
		click(driver, MCN_Module);
		click(driver, Module_Close);
		Step_End(38, "Now in MCN status tab check which are entity are available, if next entity is final port agency ,then switch profile to new pod agency", test, test1);
		int no_Of_Rows = entity.size();
		for(int i=1;i<no_Of_Rows;i++) {
			switch (entity.get(i)) {
			case "ORIGIN PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					String agency = portModule(driver,origin_Port);
					SwitchProfile(driver, agency);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					agency = portModule(driver,origin_Port);
					SwitchProfile(driver, agency);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					approveMCN(driver);
					break;
				}
				break;
			case "FINAL PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					String agency = portModule(driver,final_Port);
					SwitchProfile(driver, agency);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					agency = portModule(driver,final_Port);
					SwitchProfile(driver, agency);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					approveMCN(driver);
					break;
				}
				break;

			case "DISCHARGE PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					String agency = portModule(driver,discharge_Port);
					SwitchProfile(driver, agency);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					agency = portModule(driver,discharge_Port);
					SwitchProfile(driver, agency);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					approveMCN(driver);
					break;
				}
				break;
			case "DOCUMENTATION AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					SwitchProfile(driver, DOC_Port);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					SwitchProfile(driver, DOC_Port);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					approveMCN(driver);
					break;
				}
				break;
			case "ELSE WHERE AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					String agency = portModule(driver,elseWhere_Agency);
					SwitchProfile(driver, agency);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					agency = portModule(driver,elseWhere_Agency);
					SwitchProfile(driver, agency);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					approveMCN(driver);
					break;
				}
				break;
			case "LINE COMMERCIAL":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					ResetProfile(driver);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					ResetProfile(driver);
					Extent_call(test, test1, "Follow Step 39 to Step 43");
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					approveMCN(driver);
					break;
				}
				break;
			}
		}
		Step_Start(49, "then in mail window enter correct mail id and click on send button.", test, test1);
		waitForDisplay(driver, Mail_To_Field_MCN);
		if(isdisplayed(driver, Mail_To_Field_MCN)) {
			waitForElement(driver, Mail_To_Field_MCN);
			clearAndType(driver, Mail_To_Field_MCN, mail_Id);
			waitForElement(driver, Mail_Send_Button_MCN);
			click(driver, Mail_Send_Button_MCN);
			Step_End(49, "then in mail window enter correct mail id and click on send button.", test, test1);
			Step_Start(50, "then verify whether mail received or not in mail inbox", test, test1);
			waitForElement(driver, MCN_Number_Textfield_MCN_Module);
			mailinator_Verification(driver, mail_SignIn_Page_Url, mail_Id,approved_Mail_Subject+actual_MCN_Number);
			Step_End(50, "then verify whether mail received or not in mail inbox", test, test1);
		}
		Extent_completed(testcase_Name, test, test1);
	}
	public String portModule(WebDriver driver,String Port_Location) {
		moduleNavigate(driver, Ports_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver,dropdownCondition,Ports_Search_Type_Select,Port_Location,"","","","");
		waitForElement(driver, Ports_Agency_text_Field);
		String port_Agency = getAttribute(driver, Ports_Agency_text_Field, "value");
		return port_Agency;
	}
	//	MCN Gate
	public void mcnGateModule(WebDriver driver,String actual_MCN_Number) {
		Step_Start(39, "Open mcn gate module", test, test1);
		moduleNavigate(driver, module_MCN_Gate);
		Step_End(39, "Open mcn gate module", test, test1);
		Step_Start(40, "Choose MCN created date and click show button", test, test1);
		waitForElement(driver, fromDate_MCNGate);
		if(datePicker.equalsIgnoreCase("yes")) {
			selectDatePicker(driver, fromDate_MCNGate, fromDate);
		}else {
			waitForElement(driver, fromDate_MCNGate);
			clearAndType(driver, fromDate_MCNGate, fromDate);
		}
		waitForElement(driver, toDate_MCNGate);
		if(datePicker.equalsIgnoreCase("yes")) {
			selectDatePicker(driver, toDate_MCNGate, toDate);
		}else {
			waitForElement(driver, toDate_MCNGate);
			clearAndType(driver, toDate_MCNGate, toDate);
		}
		waitForElement(driver, show_Button_MCNGate);
		click(driver, show_Button_MCNGate);
		Step_End(40, "Choose MCN created date and click show button", test, test1);
		Step_Start(41, "Then select submit folder record.", test, test1);
		waitForElement(driver, submitted_Option);
		click(driver, submitted_Option);
		Step_End(41, "Then select submit folder record.", test, test1);
		Step_Start(42, "Now using condition filter , filter our MCN number and select then double click in grid.", test, test1);
		waitForElement(driver, filter_Options_Button_MCN_Gate);
		click(driver, filter_Options_Button_MCN_Gate);
		waitForElement(driver, condition_Filter_MCN_Gate);
		click(driver, condition_Filter_MCN_Gate);
		waitForElement(driver, MCN_Number_Filter);
		click(driver, MCN_Number_Filter);
		sendKeys(driver, MCN_Number_Filter, actual_MCN_Number);
		waitForElement(driver, select_MCN_Number_Row);
		click(driver, select_MCN_Number_Row);
		waitForElement(driver, select_MCN_Number_Row);
		doubleClick(driver, select_MCN_Number_Row);
		Step_End(42, "Now using condition filter , filter our MCN number and select then double click in grid.", test, test1);
		Step_Start(43, "System will open MCN module in that click edit button in toolbar", test, test1);
		waitForElement(driver, MCN_Module);
		if (isDisplayed(driver, MCN_Module)) {
			Extent_pass_New(driver, module_MCN + " module is opened", test, test1);
			System.out.println(module_MCN + " module is opened");
		} else {
			System.out.println(module_MCN + " module is not opened");
			Extent_fail(driver, module_MCN + " module is not opened", test, test1);
		}
		Step_End(43, "System will open MCN module in that click edit button in toolbar", test, test1);
	}
	public void acceptMCN(WebDriver driver) {
		waitForElement(driver, Accept_Button_MCN);
		if(isClickable(driver, Accept_Button_MCN)) {
			Step_End(29, "Now system will enable accept button in status tab.", test, test1);
			Step_Start(30, "Click accept button system will pop up \"Do you want to accept this MCN?\"", test, test1);
			waitForElement(driver, Accept_Button_MCN);
			click(driver, Accept_Button_MCN);
		waitForPopup(driver, popup_Message, Want_To_Accept_Popup);
			String actual_Popup = getText(driver, popup_Message);
			if(actual_Popup.trim().equals(Want_To_Accept_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
				Step_End(30, "Click accept button system will pop up \"Do you want to accept this MCN?\"", test, test1);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}
			Step_Start(31, "Click Yes to procced", test, test1);
			click(driver,popup_Message_Yes_Button);
			Step_End(31, "Click Yes to procced", test, test1);
		waitForPopup(driver, popup_Message, Accepted_Popup);
			actual_Popup = getText(driver, popup_Message);
			if(actual_Popup.trim().equals(Accepted_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}
		}
	}
	public void approveMCN(WebDriver driver) {
		Step_Start(44, "Now system will enable approve button in status tab.", test, test1);
		waitForElement(driver, Manifest_Approval_Button);
		if(isClickable(driver, Manifest_Approval_Button)) {
			Step_End(44, "Now system will enable approve button in status tab.", test, test1);
			Step_Start(45, "now click in approve button system will pop up \"\"\"\"Do you want to approve this MCN?\"\"\"\"", test, test1);
			click(driver, Manifest_Approval_Button);
		waitForPopup(driver, popup_Message, Want_To_Apporove_Popup);
			String actual_Popup = getText(driver, popup_Message);
			if(actual_Popup.trim().equals(Want_To_Apporove_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+Want_To_Apporove_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Want_To_Apporove_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+Want_To_Apporove_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Want_To_Apporove_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}
			Step_End(45, "now click in approve button system will pop up \"\"\"\"Do you want to approve this MCN?\"\"\"\"", test, test1);
			Step_Start(46, "click Yes, system will popup to enter MCN approval remarks.", test, test1);
			click(driver,popup_Message_Yes_Button);
			waitForElement(driver, Remarks_Field);
			Step_End(46, "click Yes, system will popup to enter MCN approval remarks.", test, test1);
			Step_Start(47, "Enter remarks and click ok.", test, test1);
			sendKeys(driver, Remarks_Field, MCN_Approval_Remarks_Input);
			click(driver, Remarks_OK_Button);
			Step_End(47, "Enter remarks and click ok.", test, test1);
			Step_Start(48, "Now system will pop \"\"\"\"MCN approved\"\"\"\" message click ok", test, test1);
		waitForPopup(driver, popup_Message, Approved_Popup);
			actual_Popup = getText(driver, popup_Message);
			if(actual_Popup.trim().equals(Approved_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}
			Step_End(48, "Now system will pop \"\"\"\"MCN approved\"\"\"\" message click ok", test, test1);
		}
	}
}