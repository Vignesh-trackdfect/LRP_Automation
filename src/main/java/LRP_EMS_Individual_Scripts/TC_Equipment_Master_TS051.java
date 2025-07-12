package LRP_EMS_Individual_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Equipment_Master_Locators;

public class TC_Equipment_Master_TS051 extends Keywords{
	
	public void Equipment_Master_TS051(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCase_Name="TC_Equipment_Master_TS051";
		
		
		String user_Name =Excel_data.get("Userid");
		String pass_word =Excel_data.get("PassWord");
		String Field_Names =Excel_data.get("field_name");
		String equipment_Desc_Input_Txt =Excel_data.get("Equipment_Desc_Input");
		String tare_Input_Txt =Excel_data.get("Tare_Input");
		String breakBulk_DropDown_Input_Txt =Excel_data.get("BreakBulk_DropDown_Input");
		String Chassis_DropDown_Input_Txt =Excel_data.get("Chassis_DropDown_Input_Txt");
		String Special_Chassis_ChkBox =Excel_data.get("Special_Chassis_ChkBox");
		String equipmentType_DropDown_Input_Txt =Excel_data.get("EquipmentType_DropDown_Input");
		String max_Gross_Input_Txt =Excel_data.get("Max_Gross_Input");
		String fleet_DropDown_Input_Txt =Excel_data.get("Fleet_DropDown_Input");
		String length_Input_Txt =Excel_data.get("Length_Input");
		String hight_Input_Txt =Excel_data.get("Hight_Input");
		String width_Input_Txt =Excel_data.get("Width_Input");
		String volume_Input_Txt =Excel_data.get("Volume_Input");
		String mesurement_DropDown_Input_Txt =Excel_data.get("Mesurement_DropDown_Input");
		String teus_DropDown_Input_Txt =Excel_data.get("Teus_DropDown_Input");
		String commercialType_DropDown_Input_Txt =Excel_data.get("CommercialType_DropDown_Input");
		String contractType_DropDown_Input_Txt =Excel_data.get("contractType_DropDown_Input_Txt");
		String dG_Class_DropDown_Input_Txt =Excel_data.get("DG_Class_DropDown_Input");
		String eMS_Type_DropDown_Input_Txt =Excel_data.get("EMS_Type_DropDown_Input");
		String eMS_Group_DropDown_Input_Txt =Excel_data.get("EMS_Group_DropDown_Input");
		String Equipment_Saved_Popup_Txt_Exp =Excel_data.get("Equipment_Saved_Popup_Txt");
		String Equipment_Exists_Popup_Txt =Excel_data.get("Equipment_Exists_Popup_Txt");
		String equip_Type =Excel_data.get("equip_Type");
		String Global_Search_Type =Excel_data.get("Global_Search_Type");
		String Global_Search_Condition =Excel_data.get("Global_Search_Condition");
		String Want_To_Delete = Excel_data.get("Want_To_Delete");

		String newlyAddedEquipment=String.format(Equipment_Master_Locators.newlyAddedEquipment,equip_Type);

		Extent_Start(testCase_Name, test, test1);
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, user_Name, pass_word);
		Extent_call(test, test1, "Enter module name in searchbox & click the module");
		//Enter Equipment Master Module
		moduleNavigate(driver, Field_Names);
		
		Step_Start(1, "Enter valid Size/Type in Equipment size/type field", test, test1);
		waitForElement(driver, P_equipmentType_TxtField);
		click(driver, P_equipmentType_TxtField);
		waitForElement(driver, P_equipmentType_TxtField);
		System.out.println("Equipment Type or Size : "+equip_Type);
		clearAndType(driver, P_equipmentType_TxtField, equip_Type);
		Step_End(1, "Enter valid Size/Type in Equipment size/type field", test, test1);
		
		Step_Start(2, "Enter Description in Equipment Desc field", test, test1);
		waitForElement(driver, P_equipmentDesc_TxtField);
		click(driver, P_equipmentDesc_TxtField);
		waitForElement(driver, P_equipmentDesc_TxtField);
		clearAndType(driver, P_equipmentDesc_TxtField, equipment_Desc_Input_Txt);
		Step_End(2, "Enter Description in Equipment Desc field", test, test1);
		
		Step_Start(3, "Enter tare weight in Tare field", test, test1);
		waitForElement(driver, P_tare_TxtField);
		click(driver, P_tare_TxtField);
		waitForElement(driver, P_tare_TxtField);
		clearAndType(driver, P_tare_TxtField, tare_Input_Txt);
		Step_End(3, "Enter tare weight in Tare field", test, test1);

		if(Chassis_DropDown_Input_Txt.equalsIgnoreCase("YES")) {
		waitForElement(driver, P_Chasis_DropDown);
		click(driver, P_Chasis_DropDown);
	
		formatLocatorClick(driver, DropDown_Select, Chassis_DropDown_Input_Txt);
		
		waitForElement(driver, P_Special_Chessis_CheckBox);
		checkBox(driver, P_Special_Chessis_CheckBox, Special_Chassis_ChkBox);
		}
		
		Step_Start(4, "Select anyone option from Breakbulk dropmenu", test, test1);
		waitForElement(driver, P_breakBulk_DropDown);
		click(driver, P_breakBulk_DropDown);
	
		formatLocatorClick(driver, DropDown_Select, breakBulk_DropDown_Input_Txt);
		
		Step_End(4, "Select anyone option from Breakbulk dropmenu", test, test1);

		Step_Start(5, "Select anyone option from Equipment type dropmenu", test, test1);
		waitForElement(driver, P_equipmentType_DropDown);
		click(driver, P_equipmentType_DropDown);
	
		formatLocatorClick(driver, DropDown_Select, equipmentType_DropDown_Input_Txt);
		
		Step_End(5, "Select anyone option from Equipment type dropmenu", test, test1);


	
		Step_Start(6, "Enter gross weight in maximum gross field", test, test1);
		waitForElement(driver, P_Max_Gross_TxtField);
		click(driver, P_Max_Gross_TxtField);
		waitForElement(driver, P_Max_Gross_TxtField);
		Newclear(driver, P_Max_Gross_TxtField);
		waitForElement(driver, P_Max_Gross_TxtField);
		sendKeys(driver, P_Max_Gross_TxtField, max_Gross_Input_Txt);

//		clearAndType(driver, P_Max_Gross_TxtField, max_Gross_Input_Txt);
		Step_End(6, "Enter gross weight in maximum gross field", test, test1);

		
	
		Step_Start(7, "Select fleet option accordingly", test, test1);
		waitForElement(driver, P_Fleet_DropDown);
		click(driver, P_Fleet_DropDown);
	
		formatLocatorClick(driver, DropDown_Select, fleet_DropDown_Input_Txt);
		
		Step_End(7, "Select fleet option accordingly", test, test1);

		Step_Start(8, "Enter length, height, width, volume correctly", test, test1);
		waitForElement(driver, P_Length_TxtField);
		click(driver, P_Length_TxtField);
		waitForElement(driver, P_Length_TxtField);
		clearAndType(driver, P_Length_TxtField, length_Input_Txt);

		waitForElement(driver, P_Hight_TxtField);
		click(driver, P_Hight_TxtField);
		waitForElement(driver, P_Hight_TxtField);
		clearAndType(driver, P_Hight_TxtField, hight_Input_Txt);

		waitForElement(driver, P_Width_TxtField);
		click(driver, P_Width_TxtField);
		waitForElement(driver, P_Width_TxtField);
		clearAndType(driver, P_Width_TxtField, width_Input_Txt);

		if(!volume_Input_Txt.equalsIgnoreCase("")) {
		waitForElement(driver, P_Volume_TxtField);
		click(driver, P_Volume_TxtField);
		waitForElement(driver, P_Volume_TxtField);
		clearAndType(driver, P_Volume_TxtField, volume_Input_Txt);
		Step_End(8, "Enter length, height, width, volume correctly", test, test1);

	}
		Step_Start(9, "Select Measurement option, teus and commercial type correctly", test, test1);	
		waitForElement(driver, P_Mesurement_DropDown);
		click(driver, P_Mesurement_DropDown);
	
		formatLocatorClick(driver, DropDown_Select, mesurement_DropDown_Input_Txt);

		waitForElement(driver, P_Teus_DropDown);
		click(driver, P_Teus_DropDown);
	
		formatLocatorClick(driver, DropDown_Select, teus_DropDown_Input_Txt);

		waitForElement(driver, P_CommercialType_DropDown);
		click(driver, P_CommercialType_DropDown);
	
		formatLocatorClick(driver, DropDown_Select, commercialType_DropDown_Input_Txt);
		
		Step_End(9, "Select Measurement option, teus and commercial type correctly", test, test1);

		if(!contractType_DropDown_Input_Txt.equals("")) {
		Step_Start(10, "Select DG Classification and EMS group correctly", test, test1);	
		waitForElement(driver, Ems_Contract_DropDown);
		click(driver, Ems_Contract_DropDown);
		formatLocatorClick(driver, DropDown_Select, contractType_DropDown_Input_Txt);
		}

		waitForElement(driver, P_DG_Class_DropDown);
		click(driver, P_DG_Class_DropDown);
	
		formatLocatorClick(driver, DropDown_Select, dG_Class_DropDown_Input_Txt);
		

		if(!eMS_Type_DropDown_Input_Txt.equals("")) {
		waitForElement(driver, P_EMS_Type_DropDown);
		click(driver, P_EMS_Type_DropDown);
	
		formatLocatorClick(driver, DropDown_Select, eMS_Type_DropDown_Input_Txt);
		}
		waitForElement(driver, P_EMS_Group_DropDown);
		click(driver, P_EMS_Group_DropDown);
	
		formatLocatorClick(driver, DropDown_Select, eMS_Group_DropDown_Input_Txt);
		
		Step_End(10, "Select DG Classification and EMS group correctly", test, test1);


		Step_Start(11, "Click save button and message shown as saved successfully", test, test1);	
	
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, Popup_Message, Equipment_Saved_Popup_Txt_Exp);
		String savedMsg =getText(driver, Popup_Message);
		Step_End(11, "Click save button and message shown as saved successfully", test, test1);

		
		if(Equipment_Saved_Popup_Txt_Exp.equals(savedMsg)) {
			System.out.println("Matched || " + " Expected Popup is : " + Equipment_Saved_Popup_Txt_Exp + " || Actual Popup is : " + savedMsg);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Equipment_Saved_Popup_Txt_Exp + " || Actual Popup is : " + savedMsg, test,test1);
		}else if(Equipment_Exists_Popup_Txt.equals(savedMsg)) {
			System.out.println("Matched || " + " Expected Popup is : " + Equipment_Exists_Popup_Txt + " || Actual Popup is : " + savedMsg);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Equipment_Exists_Popup_Txt + " || Actual Popup is : " + savedMsg, test,test1);
		}else {
			System.out.println("Not Matched || " + " Expected Popup is : " + Equipment_Saved_Popup_Txt_Exp + " || Actual Popup is : " + savedMsg);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Equipment_Saved_Popup_Txt_Exp + " || Actual Popup is : " + savedMsg, test,test1);
		}
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow1(driver, Global_Search_Condition, Global_Search_Type, equip_Type, "", "", "", "");
		
		waitForElement(driver, newlyAddedEquipment);
		String newlyAddedEquipmentText = getText(driver, newlyAddedEquipment);
		if(equip_Type.equals(newlyAddedEquipmentText)) {
			System.out.println("Matched || " + " Expected Equipment Type is : " + equip_Type + " || Actual Equipment Type is : " + newlyAddedEquipmentText);
			Extent_pass_New(driver, "Matched || " + " Expected Equipment Type is : " + equip_Type + " || Actual Equipment Type is : " + newlyAddedEquipmentText, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected Equipment Type is : " + equip_Type + " || Actual Equipment Type is : " + newlyAddedEquipmentText);
			Extent_fail(driver, "Not Matched || " + " Expected Equipment Type is : " + equip_Type + " || Actual Equipment Type is : " + newlyAddedEquipmentText, test,test1);
		}
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
		
		if(Want_To_Delete.equalsIgnoreCase("Yes")) {

		scrollTop(driver);
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

	    waitForElement(driver, Popup_Message);
		}
		
		Extent_completed(testCase_Name, test, test1);
		
	}
}
