package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Equipment_Master_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Equipment_Master_Locators", "Reference_Name", Testcases.environmentName);

	public static String chassisSel = ExcelData.get("chassisSel");
	public static String breakBulkSel = ExcelData.get("breakBulkSel");
	public static String equipTypeSel = ExcelData.get("equipTypeSel");
	public static String fleetSel = ExcelData.get("fleetSel");
	public static String mesurementSel = ExcelData.get("mesurementSel");
	public static String teusSel = ExcelData.get("teusSel");
	public static String commercialTypeSel = ExcelData.get("commercialTypeSel");
	public static String contractTypeSel = ExcelData.get("contractTypeSel");
	public static String dgClassSel = ExcelData.get("dgClassSel");
	public static String emsTypeSel = ExcelData.get("emsTypeSel");
	public static String emsGroupSel = ExcelData.get("emsGroupSel");
	public static String newlyAddedEquipment = ExcelData.get("newlyAddedEquipment");
	public static String Activity_Code = ExcelData.get("Activity_Code");
	public static String deleted_Column_Value = ExcelData.get("deleted_Column_Value");
	public static String AddedColumnValue = ExcelData.get("AddedColumnValue");
	public static String P_equipmentType_TxtField = ExcelData.get("P_equipmentType_TxtField");
	public static String P_equipmentDesc_TxtField = ExcelData.get("P_equipmentDesc_TxtField");
	public static String P_tare_TxtField = ExcelData.get("P_tare_TxtField");
	public static String P_Chasis_DropDown = ExcelData.get("P_Chasis_DropDown");
	public static String P_Special_Chessis_CheckBox = ExcelData.get("P_Special_Chessis_CheckBox");
	public static String P_breakBulk_DropDown = ExcelData.get("P_breakBulk_DropDown");
	public static String P_equipmentType_DropDown = ExcelData.get("P_equipmentType_DropDown");
	public static String P_Max_Gross_TxtField = ExcelData.get("P_Max_Gross_TxtField");
	public static String P_Fleet_DropDown = ExcelData.get("P_Fleet_DropDown");
	public static String P_Length_TxtField = ExcelData.get("P_Length_TxtField");
	public static String P_Hight_TxtField = ExcelData.get("P_Hight_TxtField");
	public static String P_Width_TxtField = ExcelData.get("P_Width_TxtField");
	public static String P_Volume_TxtField = ExcelData.get("P_Volume_TxtField");
	public static String P_Mesurement_DropDown = ExcelData.get("P_Mesurement_DropDown");
	public static String P_Teus_DropDown = ExcelData.get("P_Teus_DropDown");
	public static String P_CommercialType_DropDown = ExcelData.get("P_CommercialType_DropDown");
	public static String Ems_Contract_DropDown = ExcelData.get("Ems_Contract_DropDown");
	public static String P_DG_Class_DropDown = ExcelData.get("P_DG_Class_DropDown");
	public static String P_EMS_Type_DropDown = ExcelData.get("P_EMS_Type_DropDown");
	public static String P_EMS_Group_DropDown = ExcelData.get("P_EMS_Group_DropDown");
	public static String P_First_Equip_Type = ExcelData.get("P_First_Equip_Type");
	public static String P_Equip_Size_Menu = ExcelData.get("P_Equip_Size_Menu");
	public static String Equip_Size_Filter = ExcelData.get("Equip_Size_Filter");
	public static String P_Equip_Filter_CheckBox = ExcelData.get("P_Equip_Filter_CheckBox");
	public static String P_Filter_First_Value = ExcelData.get("P_Filter_First_Value");
	public static String P_Equip_Filter_Search = ExcelData.get("P_Equip_Filter_Search");
	public static String Equip_Size_Filter_EQP = ExcelData.get("Equip_Size_Filter_EQP");
	public static String P_Equip_Filter_CheckBox_EQP = ExcelData.get("P_Equip_Filter_CheckBox_EQP");
	public static String P_Equip_Filter_Search_EQP = ExcelData.get("P_Equip_Filter_Search_EQP");

	// TC_Equipment_Master_TS051
	
//	public static String chassisSel = "chassisSel>//ul[contains(@id,'EQP-EQP_cmbChassis_items')]//li[contains(text(),'%s')]";	//old
//	public static String breakBulkSel="breakBulkSel>//ul[contains(@id,'EQP-EQP_cmbBreakbulk_items')]//li[contains(text(),'%s')]";	//old
//	public static String equipTypeSel="equipTypeSel>//ul[contains(@id,'EQP-EQP_cmbtype_items')]//li[contains(text(),'%s')]";	//old
//	public static String fleetSel="fleetSel>//ul[contains(@id,'EQP-EQP_cmbFleet_items')]//li[contains(text(),'%s')]";	//old
//	public static String mesurementSel="mesurementSel>//ul[contains(@id,'EQP-EQP_txtmeasurement_items')]//li[contains(text(),'%s')]";	//old
//	public static String teusSel="teusSel>//ul[contains(@id,'EQP-EQP_cmbteus_items')]//li[contains(text(),'%s')]";	//old
//	public static String commercialTypeSel="commercialTypeSel>//ul[contains(@id,'EQP-EQP_cmbComtype_items')]//li[contains(text(),'%s')]";	//old
//	public static String contractTypeSel="contractTypeSel>//ul[contains(@id,'EQP-EQP_cmbContract_items')]//li[contains(text(),'%s')]";	//old
//	public static String dgClassSel="dgClassSel>//ul[contains(@id,'EQP-EQP_cmbClstype_items')]//li[contains(text(),'%s')]";	//old
//	public static String emsTypeSel="emsTypeSel>//ul[contains(@id,'EQP-EQP_cmbEmsType_items')]//li[contains(text(),'%s')]";	//old
//	public static String emsGroupSel="emsGroupSel>//ul[contains(@id,'EQP-EQP_txtEmsGroup_items')]//li[contains(text(),'%s')]";	//old
//		public static String chassisSel = "chassisSel>//ul[@id='EQP-EQP_cmbChassis_items']//li[text()='%s']";	//new
//		public static String breakBulkSel="breakBulkSel>//ul[@id='EQP-EQP_cmbBreakbulk_items']//li[text()='%s']";	//new
//		public static String equipTypeSel="equipTypeSel>//ul[@id='EQP-EQP_cmbtype_items']//li[text()='%s']";	//new
//		public static String fleetSel="fleetSel>//ul[@id='EQP-EQP_cmbFleet_items']//li[text()='%s']";	//new
//		public static String mesurementSel="mesurementSel>//ul[@id='EQP-EQP_txtmeasurement_items']//li[text()='%s']";	//new
//		public static String teusSel="teusSel>//ul[@id='EQP-EQP_cmbteus_items']//li[text()='%s']";	//new
//		public static String commercialTypeSel="commercialTypeSel>//ul[@id='EQP-EQP_cmbComtype_items']//li[text()='%s']";	//new
//		public static String contractTypeSel="contractTypeSel>//ul[@id='EQP-EQP_cmbContract_items']//li[text()='%s']";	//new
//		public static String dgClassSel="dgClassSel>//ul[@id='EQP-EQP_cmbClstype_items']//li[text()='%s']";	//new
//		public static String emsTypeSel="emsTypeSel>//ul[@id='EQP-EQP_cmbEmsType_items']//li[text()='%s']";	//new
//		public static String emsGroupSel="emsGroupSel>//ul[@id='EQP-EQP_txtEmsGroup_items']//li[text()='%s']";	//new
////		public static String newlyAddedEquipment="newlyAddedEquipment>//div[contains(text(),'%s')]";	//old
//		public static String newlyAddedEquipment="newlyAddedEquipment>//div[text()='%s']";	//new
//
//		public static String Activity_Code = "Activity_Code>//div[text()='%s']";
//		public static String deleted_Column_Value = "deleted_Column_Value>//label[text()='%s']//ancestor::tr[1]";
//		public static String AddedColumnValue = "AddedColumnValue>//label[text()='%s']//..";
////		public static String P_Equip_Mas_Cancel_Btn = "Enq_His_Cancel_Btn >(//label[contains(text(),'Equipment Master')])[1]//following::a[3]";	//unused
//
////		public static String P_equipmentMaster = "EquipmentMaster >//div[contains(@style,'display: block')]//span[text()='Equipment Master']";	//unused
////		public static String P_equipmentMaster_Page = "EquipmentMaster_Page >(//label[contains(text(),'Equipment Master')])[1]";	//unused
//		
////		public static String P_equipmentType_TxtField = "EquipmentType_TxtField >//input[contains(@id,'EQP-EQP_txtEqpCode')]";  //old
//		public static String P_equipmentType_TxtField = "EquipmentType_TxtField >//input[@id='EQP-EQP_txtEqpCode']";	//new
//		
////		public static String P_equipmentDesc_TxtField = "EquipmentDesc_TxtField >//input[contains(@id,'EQP-EQP_txtEqpName')]";  //old
//		public static String P_equipmentDesc_TxtField = "EquipmentDesc_TxtField >//input[@id='EQP-EQP_txtEqpName']";	//new
////		public static String P_tare_TxtField = "Tare_TxtField >//input[contains(@id,'EQP-EQP_txtTareKg_input')]";  //old
//		public static String P_tare_TxtField = "Tare_TxtField >//input[@id='EQP-EQP_txtTareKg_input']";	//new
//
////		public static String P_Chasis_DropDown = "P_Chasis_DropDown >//label[contains(@id,'EQP_cmbChassis_label')]";	//old
//		public static String P_Chasis_DropDown = "P_Chasis_DropDown >//label[@id='EQP-EQP_cmbChassis_label']";	//new
//
////		public static String P_Special_Chessis_CheckBox = "P_Chasis_DropDown >//div[contains(@id,'EQP_chkSpecialchassis')]//div[2]";	//old
//		public static String P_Special_Chessis_CheckBox = "P_Chasis_DropDown >//div[@id='EQP-EQP_chkSpecialchassis']/div[contains(@class,'chkbox')]";	// There is no unique attribute value 	//new
//
////		public static String P_breakBulk_DropDown = "BreakBulk_DropDown >//label[contains(@id,'EQP-EQP_cmbBreakbulk_label')]";	//old
//		public static String P_breakBulk_DropDown = "BreakBulk_DropDown >//label[@id='EQP-EQP_cmbBreakbulk_label']";	//new
//
////		public static String P_equipmentType_DropDown = "equipmentType_DropDown >//label[contains(@id,'EQP-EQP_cmbtype_label')]";	//old
//		public static String P_equipmentType_DropDown = "equipmentType_DropDown >//label[@id='EQP-EQP_cmbtype_label']";	//new
//
////		public static String P_Max_Gross_TxtField = "Max_Gross_TxtField >//input[contains(@id,'EQP-EQP_txtGrossKg_input')]";	//old
//		public static String P_Max_Gross_TxtField = "Max_Gross_TxtField >//input[@id='EQP-EQP_txtGrossKg_input']";	//new
//
////		public static String P_Fleet_DropDown = "Fleet_DropDown >//label[contains(@id,'EQP-EQP_cmbFleet_label')]";	//old
//		public static String P_Fleet_DropDown = "Fleet_DropDown >//label[@id='EQP-EQP_cmbFleet_label']";	//new
//
////		public static String P_Length_TxtField = "Length_TxtField >//input[contains(@id,'EQP-EQP_txtlength_input')]";	//old
//		public static String P_Length_TxtField = "Length_TxtField >//input[@id='EQP-EQP_txtlength_input']";	//new
//
////		public static String P_Hight_TxtField = "Hight_TxtField >//input[contains(@id,'EQP-EQP_txtheight_input')]";	//old
//		public static String P_Hight_TxtField = "Hight_TxtField >//input[@id='EQP-EQP_txtheight_input']";	//new
//
////		public static String P_Width_TxtField = "Width_TxtField >//input[contains(@id,'EQP-EQP_txtwidth_input')]";	//old
//		public static String P_Width_TxtField = "Width_TxtField >//input[@id='EQP-EQP_txtwidth_input']";	//new
//
////		public static String P_Volume_TxtField = "Volume_TxtField >//input[contains(@id,'EQP-EQP_txtVolume_input')]";	//old
//		public static String P_Volume_TxtField = "Volume_TxtField >//input[@id='EQP-EQP_txtVolume_input']";	//new
//
////		public static String P_Mesurement_DropDown = "Mesurement_DropDown >//label[contains(@id,'EQP-EQP_txtmeasurement_label')]";	//old
//		public static String P_Mesurement_DropDown = "Mesurement_DropDown >//label[@id='EQP-EQP_txtmeasurement_label']";	//new
//
////		public static String P_Teus_DropDown = "Teus_DropDown >//label[contains(@id,'EQP-EQP_cmbteus_label')]";	//old
//		public static String P_Teus_DropDown = "Teus_DropDown >//label[@id='EQP-EQP_cmbteus_label']";	//new
//
////		public static String P_CommercialType_DropDown = "CommercialType_DropDown >//label[contains(@id,'EQP-EQP_cmbComtype_label')]";	//old
//		public static String P_CommercialType_DropDown = "CommercialType_DropDown >//label[@id='EQP-EQP_cmbComtype_label']";	//new
//
////		public static String Ems_Contract_DropDown = "Ems_Contract_DropDown >//label[contains(@id,'EQP_cmbContract_label')]";	//old
//		public static String Ems_Contract_DropDown = "Ems_Contract_DropDown >//label[@id='EQP-EQP_cmbContract_label']";	//new
//
////		public static String P_DG_Class_DropDown = "DG_Class_DropDown >//label[contains(@id,'EQP-EQP_cmbClstype_label')]";	//old
//		public static String P_DG_Class_DropDown = "DG_Class_DropDown >//label[@id='EQP-EQP_cmbClstype_label']";	//new
//
////		public static String P_EMS_Type_DropDown = "EMS_Type_DropDown >//label[contains(@id,'EQP-EQP_cmbEmsType_label')]";	//old
//		public static String P_EMS_Type_DropDown = "EMS_Type_DropDown >//label[@id='EQP-EQP_cmbEmsType_label']";	//new
//
////		public static String P_EMS_Group_DropDown = "EMS_Group_DropDown >//label[contains(@id,'EQP-EQP_txtEmsGroup_label')]";	//old
//		public static String P_EMS_Group_DropDown = "EMS_Group_DropDown >//label[@id='EQP-EQP_txtEmsGroup_label']";	//new
//
////		public static String P_Save_Btn = "P_Save_Btn >//button[contains(@id,'btnsave')]";	//unused
////		public static String PopUp = "PopUp >//div[@id='lrp_cust_growl_container']//p";	//unused
//
////		public static String P_Global_Search_Btn = "P_Global_Search_Btn >//button[contains(@id,'myBtn')]";	//unused
////		public static String P_Global_Search_TxtField = "Global_Search_TxtField >(//div[@id='var_char']//following::input)[1]";	//unused
////		public static String P_Global_Sel_Btn = "Global_Sel_Btn>//button[contains(@id,'nfr_sch_jdlg_form-jdlg_okbtn')]";	//unused
//
//		// TC_Equipment_Master_TS052
////		public static String P_Delete_Btn = "Delete_Btn >//button[contains(@id,'btnTblDelete')]";	//unused
//		public static String P_First_Equip_Type = "First_Equip_Type >(//div[@id='EQP-EQP_equp_grid']//div[@role='gridcell'])[1]";
//		public static String P_Equip_Size_Menu = "Equip_Size_Menu >(//div[@id='EQP-EQP_equp_grid']//div[@role='presentation']//following::span[@ref='eMenu'])[1]";
//		public static String Equip_Size_Filter = "Equip_Size_Filter >//span[@aria-label='filter']";
//		public static String P_Equip_Filter_CheckBox = "Equip_Filter_CheckBox >//*[@ref='eCheckbox']//*[text()='(Select All)']";
//		public static String P_Filter_First_Value = "Filter_First_Value >(//div[@ref='eCheckbox']//div[1])[2]";
//		public static String P_Equip_Filter_Search = "Equip_Filter_Search >(//div[@ref='eBody']//input[@ref='eInput'])[1]";
////		public static String P_Deleted_PopUp = "Deleted_PopUp >//span[contains(text(),'Do you want to delete')]";	//unused
////		public static String P_Deleted_PopUp_YesBtn = "Deleted_PopUp_YesBtn >//button[contains(text(),'Yes')]";	//unused
////		public static String P_Global_Search_Close = "Global_Search_Close >//div[@id='nfr_sch_jdlg']//a[@aria-label='Close']";	//unused
//
//		// TC_Equipment_Master_TS053
////		public static String P_Edit_Btn = "Edit_Btn >//button[contains(@id,'btnTblEdit')]";	//unused
////		public static String P_EquipUpdated_PopUp = "EquipUpdated_PopUp >//*[contains(text(),'Equipment updated')]";	//unused
////		public static String P_Global_Search = "Global_Search >//button[contains(@id,'btnTblJdlgSearch')]";	//unused
//		public static String Equip_Size_Filter_EQP = "Equip_Size_Filter_EQP >//span[@aria-label='filter']";
//		public static String P_Equip_Filter_CheckBox_EQP = "Equip_Filter_CheckBox >//*[@ref='eCheckbox']//*[text()='(Select All)']";
//		public static String P_Equip_Filter_Search_EQP = "Equip_Filter_Search >(//div[@ref='eBody']//input[@ref='eInput'])[1]";
}
