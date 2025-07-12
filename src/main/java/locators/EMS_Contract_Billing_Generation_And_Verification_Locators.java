package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface EMS_Contract_Billing_Generation_And_Verification_Locators{

	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "EMS_Contract_Billing_GAV", "Reference_Name", Testcases.environmentName);

	public static String P_Contract_Module_Page = ExcelData.get("P_Contract_Module_Page");
	public static String P_Contact_No_Plus_Btn = ExcelData.get("P_Contact_No_Plus_Btn");
	public static String P_Search_Contract_No_Popup = ExcelData.get("P_Search_Contract_No_Popup");
	public static String P_Search_Contract_No_Popup_SelBtn = ExcelData.get("P_Search_Contract_No_Popup_SelBtn");
	public static String P_Search_Contract_Alert_Msg = ExcelData.get("P_Search_Contract_Alert_Msg");
	public static String P_Search_Contract_Alert_Close = ExcelData.get("P_Search_Contract_Alert_Close");
	public static String P_Search_Contract_No_Popup_Close = ExcelData.get("P_Search_Contract_No_Popup_Close");
	public static String P_Authentication_popup = ExcelData.get("P_Authentication_popup");
	public static String P_Authentication_popup_TxtField = ExcelData.get("P_Authentication_popup_TxtField");
	public static String P_Authentication_popup_Close = ExcelData.get("P_Authentication_popup_Close");
	public static String P_Authentication_popup_OkBtn = ExcelData.get("P_Authentication_popup_OkBtn");
	public static String P_Bill_Period_Month_DD = ExcelData.get("P_Bill_Period_Month_DD");
	public static String P_Bill_Period_Year_Field = ExcelData.get("P_Bill_Period_Year_Field");
	public static String P_Genarate_Bills_Btn = ExcelData.get("P_Genarate_Bills_Btn");
	public static String P_Show_Bills_Btn = ExcelData.get("P_Show_Bills_Btn");
	public static String P_Verify_Btn = ExcelData.get("P_Verify_Btn");
	public static String P_Remark_Txt_Field = ExcelData.get("P_Remark_Txt_Field");
	public static String P_Remark_Ok_Btn = ExcelData.get("P_Remark_Ok_Btn");
	public static String P_ApproveBill_Btn = ExcelData.get("P_ApproveBill_Btn");
	public static String P_ReGenerate_Btn = ExcelData.get("P_ReGenerate_Btn");
	public static String P_Reset_Btn = ExcelData.get("P_Reset_Btn");
	public static String P_Regenaration_Pass_TxtField = ExcelData.get("P_Regenaration_Pass_TxtField");
	public static String P_Regenaration_Pass_OkBtn = ExcelData.get("P_Regenaration_Pass_OkBtn");
	public static String P_Regenaration_Pass_Close = ExcelData.get("P_Regenaration_Pass_Close");
	public static String P_Bill_Run_Status_okBtn = ExcelData.get("P_Bill_Run_Status_okBtn");
	public static String P_Bill_Not_Verify_Msg = ExcelData.get("P_Bill_Not_Verify_Msg");
	public static String P_Approve_Remarks_TxtFiled = ExcelData.get("P_Approve_Remarks_TxtFiled");
	public static String P_Approve_Remarks_OkBtn = ExcelData.get("P_Approve_Remarks_OkBtn");
	public static String Bill_Yes_Btn = ExcelData.get("Bill_Yes_Btn");
	public static String month_Select = ExcelData.get("month_Select");
	public static String element = ExcelData.get("element");
	public static String Generatebutton = ExcelData.get("Generatebutton");
	public static String ContractNo_Select_ChkBox = ExcelData.get("ContractNo_Select_ChkBox");
	public static String verified_Row = ExcelData.get("verified_Row");
	public static String contrac_No = ExcelData.get("contrac_No");
	public static String P_Approve_Remark_Title = ExcelData.get("P_Approve_Remark_Title");
	public static String P_Add_Remark_Title = ExcelData.get("P_Add_Remark_Title");
	public static String P_Invalid_Terms_Popup_Msg = ExcelData.get("P_Invalid_Terms_Popup_Msg");
	public static String P_Invalid_Terms_Popup_YesBtn = ExcelData.get("P_Invalid_Terms_Popup_YesBtn");
	public static String P_Before_ReGen_ContractNo_Value = ExcelData.get("P_Before_ReGen_ContractNo_Value");
	public static String P_After_ReGen_ContractNo_Value = ExcelData.get("P_After_ReGen_ContractNo_Value");
	public static String P_Invalid_Terms_Popup_Close = ExcelData.get("P_Invalid_Terms_Popup_Close");
	public static String P_Verify_Remark_Close = ExcelData.get("P_Verify_Remark_Close");
	public static String P_Approve_Remark_Close = ExcelData.get("P_Approve_Remark_Close");
	public static String P_Missng_Bill_Msg = ExcelData.get("P_Missng_Bill_Msg");
	public static String P_Missng_Bill_CloseBtn = ExcelData.get("P_Missng_Bill_CloseBtn");
	public static String P_Bill_Already_Exist_Popup_Msg = ExcelData.get("P_Bill_Already_Exist_Popup_Msg");
	public static String P_Bill_Already_Exist_Popup_close = ExcelData.get("P_Bill_Already_Exist_Popup_close");
	public static String P_Bill_Already_Exist_Popup_OkBtn = ExcelData.get("P_Bill_Already_Exist_Popup_OkBtn");
	public static String P_Bill_Already_Exist_Popup_NoBtn = ExcelData.get("P_Bill_Already_Exist_Popup_NoBtn");
	public static String P_Bill_Already_Exist_Popup_YesBtn = ExcelData.get("P_Bill_Already_Exist_Popup_YesBtn");

	
	
	//	public static String P_Service_Must_Enter_Popup = "Service_Must_Enter_Popup >//*[text()='Service must be entered']";
//	public static String P_Vessel_Must_Enter_Popup = "Vessel_Must_Enter_Popup >//*[text()='Vessel must be entered']";
//	public static String P_Voyage_Must_Enter_Popup = "Voyage_Must_Enter_Popup >//*[text()='Voyage must be entered']";
//	public static String P_Bound_Must_Select_Popup = "Bound_Must_Select_Popup >//*[text()='Bound must be selected']";
//	public static String P_Service_Txt_Field = "Service_Txt_Field >//input[contains(@id,'txtSinService')]";
//	public static String P_Vessel_Txt_Field = "Vessel_Txt_Field >//input[contains(@id,'txtSinVslCode')]";
//	public static String P_Voyage_Txt_Field = "Voyage_Txt_Field >//input[contains(@id,'txtSinVoyage')]";
//	public static String P_Bound_Txt_Field = "Bound_Txt_Field >//input[contains(@id,'txtSinBound')]";
//	public static String P_POL_Txt_Field = "POL_Txt_Field >//input[contains(@id,'txtSinPOL_input')]";
//	public static String P_POL_Must_Select_Popup = "POL_Must_Select_Popup >//*[text()='POL must be entered']";
//	public static String P_Invalid_Activity_Date_Popup = "Invalid_Activity_Date_Popup >(//div[contains(@id,'errDetList')]//following::td[text()='DA']//following::td)[1]";
//	public static String P_Invalid_Service_Popup = "Invalid_Service_Popup >(//div[contains(@id,'errDetList')]//following::td[text()='IS']//following::td)[1]";
//	public static String P_Invalid_Terminal_Popup = "Invalid_Terminal_Popup >(//div[contains(@id,'errDetList')]//following::td[text()='IT']//following::td)[1]";
//	public static String P_Invalid_Bound_Popup = "Invalid_Bound_Popup >(//div[contains(@id,'errDetList')]//following::td[text()='BO']//following::td)[1]";
//	public static String P_Invalid_Voyage_Popup = "Invalid_Voyage_Popup >(//div[contains(@id,'errDetList')]//following::td[text()='VO']//following::td)[1]";
//	public static String P_Invalid_POD_Popup = "Invalid_POD_Popup >(//div[contains(@id,'errDetList')]//following::td[text()='AG']//following::td)[1]";
	
	

}
