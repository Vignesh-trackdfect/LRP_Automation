package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Equipment_Profile_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Equipment_Profile_Locators", "Reference_Name", Testcases.environmentName);

	public static String eqpNoTextField_L = ExcelData.get("eqpNoTextField_L");
	public static String tareWeightTextField_L = ExcelData.get("tareWeightTextField_L");
	public static String tareWeightTextField1_L = ExcelData.get("tareWeightTextField1_L");
	public static String payLoadTextField_L = ExcelData.get("payLoadTextField_L");
	public static String maxGrossWeightTextField_L = ExcelData.get("maxGrossWeightTextField_L");
	public static String nominalCubic_Textfield = ExcelData.get("nominalCubic_Textfield");
	public static String stackHeight_Textfield = ExcelData.get("stackHeight_Textfield");
	public static String grossStacking_Textfield = ExcelData.get("grossStacking_Textfield");
	public static String injectionPort_Dropdown = ExcelData.get("injectionPort_Dropdown");
	public static String domcile_Searchfield = ExcelData.get("domcile_Searchfield");
	public static String eqpStatus_Dropdown = ExcelData.get("eqpStatus_Dropdown");
	public static String contractId1_Textfield = ExcelData.get("contractId1_Textfield");
	public static String contractId2_Textfield = ExcelData.get("contractId2_Textfield");
	public static String contractId3_Textfield = ExcelData.get("contractId3_Textfield");
	public static String onHireDate_Textfield = ExcelData.get("onHireDate_Textfield");
	public static String redeliveryPort_Searchfield = ExcelData.get("redeliveryPort_Searchfield");
	public static String redeliveryDate_Textfield = ExcelData.get("redeliveryDate_Textfield");
	public static String leasingRefNo_Textfield = ExcelData.get("leasingRefNo_Textfield");
	public static String leasingContractRef_Textfield = ExcelData.get("leasingContractRef_Textfield");
	public static String subleaseContract_Textfield = ExcelData.get("subleaseContract_Textfield");
	public static String supplierContract_Textfield = ExcelData.get("supplierContract_Textfield");
	public static String lessorCode_Dropdown = ExcelData.get("lessorCode_Dropdown");
	public static String lesseeCode_Dropdown = ExcelData.get("lesseeCode_Dropdown");
	public static String sublease_Dropdown = ExcelData.get("sublease_Dropdown");
	public static String perDiem_Textfield = ExcelData.get("perDiem_Textfield");
	public static String leaseKind_Dropdown2 = ExcelData.get("leaseKind_Dropdown2");
	public static String leaseTerm_Dropdown2 = ExcelData.get("leaseTerm_Dropdown2");
	public static String leaseKind_Dropdown3 = ExcelData.get("leaseKind_Dropdown3");
	public static String submittedToJoint = ExcelData.get("submittedToJoint");
	public static String eqpTypeDropDown_L = ExcelData.get("eqpTypeDropDown_L");
	public static String sizeTypeDropDownEqPro_L = ExcelData.get("sizeTypeDropDownEqPro_L");
	public static String isoDropDown_L = ExcelData.get("isoDropDown_L");
	public static String sosDropDown_L = ExcelData.get("sosDropDown_L");
	public static String selSos_L = ExcelData.get("selSos_L");
	public static String eqpStatusDropDown_L = ExcelData.get("eqpStatusDropDown_L");
	public static String fleetGroupDropDown_L = ExcelData.get("fleetGroupDropDown_L");
	public static String onHireLocation_Searchfield = ExcelData.get("onHireLocation_Searchfield");
	public static String contractRefNum_Textfield = ExcelData.get("contractRefNum_Textfield");
	public static String disposalRegNum = ExcelData.get("disposalRegNum");
	public static String payLoadTextField_2 = ExcelData.get("payLoadTextField_2");
	public static String refreshButton_L = ExcelData.get("refreshButton_L");
	public static String manufacturedDate_L = ExcelData.get("manufacturedDate_L");
	public static String specialUnitDropDown_L = ExcelData.get("specialUnitDropDown_L");
	public static String ownedDropdown_L = ExcelData.get("ownedDropdown_L");
	public static String retrieved_Record = ExcelData.get("retrieved_Record");
	public static String equipment_Type = ExcelData.get("equipment_Type");
	public static String size_Type1 = ExcelData.get("size_Type1");
	public static String soc_Input = ExcelData.get("soc_Input");
	public static String specialUnit_field = ExcelData.get("specialUnit_field");
	public static String owned_field = ExcelData.get("owned_field");
	public static String injection_Port = ExcelData.get("injection_Port");
	public static String eqp_Status = ExcelData.get("eqp_Status");
	public static String fleet_Group = ExcelData.get("fleet_Group");
	public static String lessor_Code = ExcelData.get("lessor_Code");
	public static String lessee_Code = ExcelData.get("lessee_Code");
	public static String leaseKind_1 = ExcelData.get("leaseKind_1");
	public static String lease_Term = ExcelData.get("lease_Term");
	public static String leaseKind_2 = ExcelData.get("leaseKind_2");
	public static String submittedToJoin_Venture = ExcelData.get("submittedToJoin_Venture");
	public static String  newButton_EquipmentProfile_Homepage = ExcelData.get("newButton_EquipmentProfile_Homepage");

	// TS-057 & TS-059
//		public static String eqpNoTextField_L = "eqpNoTextField>//input[@id='CNP-CNP_txtcontainernoNew']";
//
//		public static String tareWeightTextField_L = "tareWeightTextField>//input[@id='CNP-CNP_txttarewght_input']";
//		public static String tareWeightTextField1_L = "tareWeightTextField1>//span[@id='CNP-CNP_txttarewght']";
//		public static String payLoadTextField_L = "payLoadTextField>//input[@id='CNP-CNP_txtpayload_input']";
//		public static String maxGrossWeightTextField_L = "maxGrossWeightTextField>//input[@id='CNP-CNP_txtgrosswght_input']";
////		public static String saveButtonEqpPro_L = "saveButtonEqpPro_L>//button[@id='CNP-CNP_toolbar-btnsave']";		//	un used
////		public static String editButtonEqpPro_L = "editButtonEqpPro>//button[@id='CNP-CNP_toolbar-btnTblEdit']";	//	un used
////		public static String globalSearchEqpPro_L = "globalSearchEqpPro>//button[@id='CNP-CNP_toolbar-btnTblJdlgSearch']";	//	un used
////		public static String eqpNoSearchField_L = "eqpNoSearhField>//input[@id='txt_name1']";		//	un used
////		public static String eqpProfileSearchFrame_L = "eqpProfileSearchFrame>//div[@id='nfr_sch_jdlg']";	//	un used
////		public static String eqProSearchButton_L = "eqProSearchButton>//button[@id='myBtn']";	//	un used
////		public static String selFirstEqPro_L = "selFirstEqPro>//div[@row-id='0']/child::div[@col-id='C1']";	//	un used
////		public static String selectButtonEqPro_L = "selectButtonEqPro>//button[@id='nfr_sch_jdlg_form-jdlg_okbtn']";	//	un used
////
////
////		public static String EquipNo_Field="EquipNo_Field>(//div[@id='search_JDLGView']//following::input[1])[1]";	//	un used
////		public static String EqpProfilePage_L = "EqpProfilePage_L>//a/label[.='Equipment Profile']";	//	un used
//
//		public static String nominalCubic_Textfield="nominalCubic_Textfield>//input[@id='CNP-CNP_txtnomcubcity_input']";
//		public static String stackHeight_Textfield="stackHeight_Textfield>//input[@id='CNP-CNP_txtstkhgt']";
//		public static String grossStacking_Textfield="grossStacking_Textfield>//input[@id='CNP-CNP_txtstcwght']";
//		public static String injectionPort_Dropdown="injectionPort_Dropdown>//label[@id='CNP-CNP_cmbinjectionPort_label']";
//		public static String domcile_Searchfield="domcile_Searchfield>//input[@id='CNP-CNP_txtdomicileprt']";
//		public static String eqpStatus_Dropdown="eqpStatus_Dropdown>//label[@id='CNP-CNP_txtstatus_label']";
//		public static String contractId1_Textfield="contractId1_Textfield>//input[@id='CNP-CNP_txtContrctload']";
//		public static String contractId2_Textfield="contractId2_Textfield>//input[@id='CNP-CNP_txtcontrcload1']";
//		public static String contractId3_Textfield="contractId3_Textfield>//input[@id='CNP-CNP_txtcontrcload2']";
//		public static String onHireDate_Textfield="onHireDate_Textfield>//input[@id='CNP-CNP_txtONHI_input']";
//		public static String redeliveryPort_Searchfield="redeliveryPort_Searchfield>//input[@id='CNP-CNP_txtREDLprt']";
//		public static String redeliveryDate_Textfield="redeliveryDate_Textfield>//input[@id='CNP-CNP_txtREDDDATE_input']";
//		public static String leasingRefNo_Textfield="leasingRefNo_Textfield>//input[@id='CNP-CNP_txtleasingrefno']";
//		public static String leasingContractRef_Textfield="leasingContractRef_Textfield>//input[@id='CNP-CNP_txtleasingcontrref']";
//		public static String subleaseContract_Textfield="subleaseContract_Textfield>//input[@id='CNP-CNP_txtcontrctno']";
//		public static String supplierContract_Textfield="supplierContract_Textfield>//input[@id='CNP-CNP_txtsupcont']";
//		public static String lessorCode_Dropdown="lessorCode_Dropdown>//label[@id='CNP-CNP_cmblessorcode_label']";
//		public static String lesseeCode_Dropdown="lesseeCode_Dropdown>//label[@id='CNP-CNP_cmbleasecode_label']";
//		public static String sublease_Dropdown="lesseeCode_Dropdown>//label[@id='CNP-CNP_cmbsublease_label']";
//		public static String perDiem_Textfield="perDiem_Textfield>//input[@id='CNP-CNP_txtintperdiem']";
//		public static String leaseKind_Dropdown2="leaseKind_Dropdown2>//label[@id='CNP-CNP_cmbleasekind_label']";
//		public static String leaseTerm_Dropdown2="leaseTerm_Dropdown2>//label[@id='CNP-CNP_cmbleaseterm_label']";
//		public static String leaseKind_Dropdown3="leaseKind_Dropdown3>//label[@id='CNP-CNP_cmbleasekind1_label']";
//		public static String submittedToJoint="submittedToJoint>//label[@id='CNP-CNP_cmbjointvent_label']";
//
//
//
//		// TS-058 & TS-061
////		public static String newButtonEqPro_L = "newButtonEqPro>//button[@id='CNP-CNP_toolbar-btnTblNew']";		//	un used
////		public static String cancelButtonEqPro_L = "cancelButtonEqPro>//button[@id='CNP-CNP_toolbar-btnTblCancel']";		//	un used
////		public static String createConfirmPopup_L = "createConfirmPopup>//span[.=' Do you want to create a New Equipment Profile?']";		//	un used
////		public static String createConfirmPopupYes_L = "createConfirmPopupYes>//span[.=' Do you want to create a New Equipment Profile?']/following::button[.='Yes']";		//	un used
//		public static String eqpTypeDropDown_L = "eqpTypeDropDown>//div[@id='CNP-CNP_txtequiptype']";
////		public static String selEqpType_L = "selEqpType>//li[@data-label='CONTAINER']";		//	un used
//		public static String sizeTypeDropDownEqPro_L = "sizeTypeDropDownEqPro>//div[@id='CNP-CNP_cmbsize']";
////		public static String selSizeType_L = "selSizeType>//li[@data-label='20DC']";	//	un used
//		public static String isoDropDown_L = "isoDropDown>//label[@id='CNP-CNP_txtiso_label']";
//		public static String sosDropDown_L = "sosDropDown>//div[@id='CNP-CNP_cmbsoc']";
//		public static String selSos_L = "selSos>//ul[@id='CNP-CNP_cmbsoc_items']/li[@data-label='Y']";
//		public static String eqpStatusDropDown_L = "eqpStatusDropDown>//label[@id='CNP-CNP_txtstatus_label']";
////		public static String selActiveStatus_L = "selActiveStatus>//li[@data-label='ACTIVE']";	//	un used
//		public static String fleetGroupDropDown_L = "fleetGroupDropDown>//label[@id='CNP-CNP_cmbfleetgrp_label']";
////		public static String selActiveFleet_L = "selActiveFleet>//li[@data-label='ACTIVE FLEET']";	//	un used
////		public static String deleteButtonEqpPro_L = "deleteButtonEqpPro>//button[@id='CNP-CNP_toolbar-btnTblDelete']";	//	un used
////		public static String wantToDeleteYes_L = "wantToDeleteYes>//span[.=' Do you want to delete the Equipment Profile?']/following::button[.='Yes']";	//	un used
////		public static String wantToDeletePopup_L = "wantToDeletePopup>//span[.=' Do you want to delete the Equipment Profile?']";	//	un used
////		public static String globalSearchCloseIcon_L = "globalSearchCloseIcon>//span[@id='nfr_sch_jdlg_title']/following-sibling::a[@aria-label='Close']";	//	un used
////		public static String cannotDeletePopup_L = "cannotDeletePopup>(//*[text()='Cannot delete the Equipment Profile. It has movement entry'])[1]";	//	un used
////		public static String eqpProfileDeletedPopup_L = "eqpProfileDeletedPopup>(//*[text()='Equipment Profile is deleted'])[1]";	//	un used
////		public static String eqpProfileSaved_L = "eqpProfileSaved>(//*[text()='Equipment Profile is saved'])[1]";	//	un used
////		public static String eqpProfileUpdatedPopup_L = "eqpProfileUpdatedPopup>(//*[text()='Equipment Profile is updated'])[1]";	//	un used
////		public static String eqpProNoFoundRecordsPopup_L = "eqpProNoFoundRecordsPopup>(//*[text()='No records Found'])[1]";	//	un used
////		public static String EqpSearchCloseButton_L = "EqpSearchCloseButton>//span[@id='nfr_sch_jdlg_title']/following-sibling::a[@aria-label='Close']";	//	un used
////		public static String alraedySavedPopup_L = "alraedySavedPopup>(//*[text()='Equipment Profile already exists in Container'])[1]";	//	un used
//
//		public static String onHireLocation_Searchfield="onHireLocation_Searchfield>//input[@id='CNP-CNP_txtonhire']";
//		public static String contractRefNum_Textfield="contractRefNum_Textfield>//input[@id='CNP-CNP_txtconref']";
//		public static String disposalRegNum="disposalRegNum>//input[@id='CNP-CNP_txtdispogregnoNew']";
//
//		public static String payLoadTextField_2 = "payLoadTextField_2>//input[@id='CNP-CNP_txtpayload_hinput']";
//		// TS-060
//		public static String refreshButton_L = "refreshButton>//button[@id='CNP-CNP_btnrefresh']";
//		public static String manufacturedDate_L = "manufacturedDate>//input[@id='CNP-CNP_DateManu_input']";
//		public static String specialUnitDropDown_L = "specialUnitDropDown>//div[@id='CNP-CNP_cmbspecialUnit']";
////		public static String specialUnitYes_L = "specialUnitYes>//li[@id='CNP-CNP_cmbspecialUnit_0']";	//	un used
////		public static String specialUnitNo_L = "specialUnitNo>//li[@id='CNP-CNP_cmbspecialUnit_1']";	//	un used
//		public static String ownedDropdown_L = "ownedDropdown>//div[@id='CNP-CNP_cmbowned']";
////		public static String ownedY_L = "ownedY>//li[@id='CNP-CNP_cmbowned_0']";	//	un used
////		public static String ownedN_L = "ownedN>//li[@id='CNP-CNP_cmbowned_1']";	//	un used
//		
//		public static String retrieved_Record = "retrieved_Record>//div[text()='%s' and @role='gridcell']";
//		public static String equipment_Type = "equipmentType>//li[@data-label='%s']";
//		public static String size_Type1 = "size_Type1>//li[@data-label='%s']";
//		public static String soc_Input = "soc_Input>//ul[@id='CNP-CNP_cmbsoc_items']/li[@data-label='%s']";
//		public static String specialUnit_field = "specialUnit>//ul[@id='CNP-CNP_cmbspecialUnit_items']/li[@data-label='%s']";
//		public static String owned_field = "owned>//ul[@id='CNP-CNP_cmbowned_items']/li[@data-label='%s']";
//		public static String injection_Port = "injectionPort>//ul[@id='CNP-CNP_cmbinjectionPort_items']/li[@data-label='%s']";
//		public static String eqp_Status = "eqp_Status>//li[@data-label='%s']";
//		public static String fleet_Group = "fleet_Group>//li[@data-label='%s']";
//		public static String lessor_Code = "lessor_Code>//ul[@id='CNP-CNP_cmblessorcode_items']/li[@data-label='%s']";
//		public static String lessee_Code = "lessee_Code>//ul[@id='CNP-CNP_cmbleasecode_items']/li[@data-label='%s']";
//		public static String leaseKind_1 = "leaseKind_1>//ul[@id='CNP-CNP_cmbleasekind_items']/li[@data-label='%s']";
//		public static String lease_Term = "leaseTerm>//ul[@id='CNP-CNP_cmbleaseterm_items']/li[@data-label='%s']";
//		public static String leaseKind_2 = "leaseKind_2>//ul[@id='CNP-CNP_cmbleasekind1_items']/li[@data-label='%S']";
//		public static String submittedToJoin_Venture = "submittedToJoin_Venture>//ul[@id='CNP-CNP_cmbjointvent_items']/li[@data-label='%S']";
//		public static String EqpPopup="EqpPopup>//div[@id='lrp_cust_growl_container']//following::p";	//	un used
}
