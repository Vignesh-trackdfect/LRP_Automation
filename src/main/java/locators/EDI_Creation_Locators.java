package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface EDI_Creation_Locators {

	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "EDI_Creation", "Reference_Name", Testcases.environmentName);

	public static String Partner_ID_Search_Btn_EDI_Creation = ExcelData.get("Partner_ID_Search_Btn_EDI_Creation");
	public static String Partner_Name_Input_EDI_Creation = ExcelData.get("Partner_Name_Input_EDI_Creation");
	public static String EDI_ID_Search_Btn_EDI_Creation = ExcelData.get("EDI_ID_Search_Btn_EDI_Creation");
	public static String EDI_ID_Input_EDI_Creation = ExcelData.get("EDI_ID_Input_EDI_Creation");
	public static String Direction_Input_EDI_Creation = ExcelData.get("Direction_Input_EDI_Creation");
	public static String Direction_SelectOptions_EDI_Creation = ExcelData.get("Direction_SelectOptions_EDI_Creation");
	public static String EDI_Format_Input_EDI_Creation = ExcelData.get("EDI_Format_Input_EDI_Creation");
	public static String EDI_Format_SelectOptions_EDI_Creation = ExcelData.get("EDI_Format_SelectOptions_EDI_Creation");
	public static String GroupCode_Input_EDI_Creation = ExcelData.get("GroupCode_Input_EDI_Creation");
	public static String GroupCode_SelectOptions_EDI_Creation = ExcelData.get("GroupCode_SelectOptions_EDI_Creation");
	public static String Version_Input_EDI_Creation = ExcelData.get("Version_Input_EDI_Creation");
	public static String Version_SelectOption_EDI_Creation = ExcelData.get("Version_SelectOption_EDI_Creation");
	public static String Category_Search_Btn_EDI_Creation = ExcelData.get("Category_Search_Btn_EDI_Creation");
	public static String Office_Type_Input_EDI_Creation = ExcelData.get("Office_Type_Input_EDI_Creation");
	public static String OffficeType_SelectOption_EDI_Creation = ExcelData.get("OffficeType_SelectOption_EDI_Creation");
	public static String Agency_Code_Search_Btn_EDI_Creation = ExcelData.get("Agency_Code_Search_Btn_EDI_Creation");
	public static String Status_Input_EDI_Creation = ExcelData.get("Status_Input_EDI_Creation");
	public static String Status_SelectOption_EDI_Creation = ExcelData.get("Status_SelectOption_EDI_Creation");
	public static String Prefix_Input_EDI_Creation = ExcelData.get("Prefix_Input_EDI_Creation");
	public static String Prefix_SelectOption_EDI_Creation = ExcelData.get("Prefix_SelectOption_EDI_Creation");
	public static String Next_Button_EDI_Creation = ExcelData.get("Next_Button_EDI_Creation");
	public static String Confirmation_Section_EDI_Creation = ExcelData.get("Confirmation_Section_EDI_Creation");
	public static String Confirm_Button_EDI_Creation = ExcelData.get("Confirm_Button_EDI_Creation");
	public static String SettingBtn_EDI_Creation = ExcelData.get("SettingBtn_EDI_Creation");
	public static String ModeSelect_Input_EDI_Creation = ExcelData.get("ModeSelect_Input_EDI_Creation");
	public static String ModeSelectOption_EDI_Creation = ExcelData.get("ModeSelectOption_EDI_Creation");
	public static String Minute_Input_EDI_Creation = ExcelData.get("Minute_Input_EDI_Creation");
	public static String Apply_Button_EDI_Creation = ExcelData.get("Apply_Button_EDI_Creation");
	public static String Table_EDI_List = ExcelData.get("Table_EDI_List");
	public static String Mode_Column_EDI_List = ExcelData.get("Mode_Column_EDI_List");
	public static String EDI_ID_Filter_Input = ExcelData.get("EDI_ID_Filter_Input");
	public static String PartnerCode_Confirm_EDI_Creation = ExcelData.get("PartnerCode_Confirm_EDI_Creation");
	public static String PartnerName_Confirm_EDI_Creation = ExcelData.get("PartnerName_Confirm_EDI_Creation");
	public static String EDIName_Confirm_EDI_Creation = ExcelData.get("EDIName_Confirm_EDI_Creation");
	public static String EDI_Format_Confirm_EDI_Creation = ExcelData.get("EDI_Format_Confirm_EDI_Creation");
	public static String EDI_ID_Value_EDI_Creation = ExcelData.get("EDI_ID_Value_EDI_Creation");
	public static String Status_Confirm_EDI_Creation = ExcelData.get("Status_Confirm_EDI_Creation");
	public static String Agency_Confirm_EDI_Creation = ExcelData.get("Agency_Confirm_EDI_Creation");
	public static String GenerationMode_Confirm_EDI_Creation = ExcelData.get("GenerationMode_Confirm_EDI_Creation");
	public static String Skip_To_LastCheckbox_EDI_Creation = ExcelData.get("Skip_To_LastCheckbox_EDI_Creation");

	
	//old
//	public static String PartnerCode_Confirm_EDI_Creation="Partner Code>//td[contains(text(),'Partner Code :')]//ancestor::tr[1]//td[2]"; // old
//	public static String PartnerName_Confirm_EDI_Creation="Partner Name >//td[contains(text(),'Partner Name :')]//ancestor::tr[1]//td[2]";  // old
//	public static String EDIName_Confirm_EDI_Creation="EDI Name >//td[contains(text(),'EDI Name :')]//ancestor::tr[1]//td[2]"; // old	
//	public static String EDI_Format_Confirm_EDI_Creation="EDI Format >//td[contains(text(),'EDI Format :')]//ancestor::tr[1]//td[2]";  //old
//	public static String GenerationMode_Confirm_EDI_Creation="Generation Mode >//td[contains(text(),'Generation Mode :')]//ancestor::tr[1]//td[2]"; // old
//	public static String Agency_Confirm_EDI_Creation="Applicable Agency >//td[contains(text(),'Applicable Agency :')]//ancestor::tr[1]//td[2]";  //old
//	public static String Status_Confirm_EDI_Creation="Status >//td[contains(text(),'Status :')]//ancestor::tr[1]//td[2]";  //old
//	public static String EDI_ID_Value_EDI_Creation="EDI Value>//td[contains(text(),'EDI ID :')]//ancestor::tr[1]//td[2]";  //old	
	
	public static String EDI_Profile_Id_Button = ExcelData.get("EDI_Profile_Id_Button");
	public static String EDI_Upload_By_Button = ExcelData.get("EDI_Upload_By_Button");
	public static String EDI_Directory_Input = ExcelData.get("EDI_Directory_Input");
	public static String EDI_Agency_Code = ExcelData.get("EDI_Agency_Code");
	public static String EDI_Agency_Filter_option = ExcelData.get("EDI_Agency_Filter_option");
	public static String EDI_Agency_Code_Input_Filed = ExcelData.get("EDI_Agency_Code_Input_Filed");
	public static String EDI_Agency_Checkbox = ExcelData.get("EDI_Agency_Checkbox");
	public static String EDI_Agency_Apply_Button = ExcelData.get("EDI_Agency_Apply_Button");
	public static String EDI_Skip_Last_CheckBox = ExcelData.get("EDI_Skip_Last_CheckBox");
	public static String EDI_Partner_Code = ExcelData.get("EDI_Partner_Code");
	public static String EDI_List_Filter_Option = ExcelData.get("EDI_List_Filter_Option");
	public static String EDI_List_Partner_Id_Input = ExcelData.get("EDI_List_Partner_Id_Input");
	public static String EDI_List_Edi_Id_Input = ExcelData.get("EDI_List_Edi_Id_Input");
	public static String EDI_List_FTP_Profile_Input = ExcelData.get("EDI_List_FTP_Profile_Input");
	public static String EDI_Name = ExcelData.get("EDI_Name");
	public static String EDI_List_scroll = ExcelData.get("EDI_List_scroll");
	public static String EDI_List_FTP_Directory_input = ExcelData.get("EDI_List_FTP_Directory_input");
	public static String EDI_List_FTP_Value = ExcelData.get("EDI_List_FTP_Value");
	public static String EDU_FTP_SFTP_Filter_Option = ExcelData.get("EDU_FTP_SFTP_Filter_Option");
	public static String EDI_FTP_SFTP_Agency_Code = ExcelData.get("EDI_FTP_SFTP_Agency_Code");
	public static String EDI_FTP_SFTP_Directory_Input = ExcelData.get("EDI_FTP_SFTP_Directory_Input");
	public static String EDI_FTP_SFTP_First_Now = ExcelData.get("EDI_FTP_SFTP_First_Now");
	public static String EDI_FTP_SFTP_Add_Button = ExcelData.get("EDI_FTP_SFTP_Add_Button");
	public static String EDI_FTP_SFTP_Directory_Input_Field = ExcelData.get("EDI_FTP_SFTP_Directory_Input_Field");
	public static String EDI_FTP_SFTP_Grid_Checkbox = ExcelData.get("EDI_FTP_SFTP_Grid_Checkbox");
	public static String EDI_FTP_SFTP_Remove = ExcelData.get("EDI_FTP_SFTP_Remove");
	public static String EDI_Email_Profile_Id_Button = ExcelData.get("EDI_Email_Profile_Id_Button");
	public static String EDI_Email_Upload_By_Button = ExcelData.get("EDI_Email_Upload_By_Button");
	public static String EDI_Email_id_Button = ExcelData.get("EDI_Email_id_Button");
	public static String EDI_Email_Subject_Input = ExcelData.get("EDI_Email_Subject_Input");
	public static String EDI_Email_Agency_Code_Button = ExcelData.get("EDI_Email_Agency_Code_Button");
	public static String EDI_Email_Agency_Checkbox = ExcelData.get("EDI_Email_Agency_Checkbox");
	public static String EDI_Email_Apply_Button = ExcelData.get("EDI_Email_Apply_Button");
	public static String EDI_Email_Agency_Filter_Option = ExcelData.get("EDI_Email_Agency_Filter_Option");
	public static String EDI_Email_Skip_To_Lask_Check_Box = ExcelData.get("EDI_Email_Skip_To_Lask_Check_Box");
	public static String EDI_List_Partner_E_ID_Input = ExcelData.get("EDI_List_Partner_E_ID_Input");
	public static String EDI_Local_Upload_Button = ExcelData.get("EDI_Local_Upload_Button");
	public static String EDI_Local_Profile_Id_Button = ExcelData.get("EDI_Local_Profile_Id_Button");
	public static String EDI_Local_Directory = ExcelData.get("EDI_Local_Directory");
	public static String EDI_Local_Agency_Code_Button = ExcelData.get("EDI_Local_Agency_Code_Button");
	public static String EDI_Email_partner_id_value = ExcelData.get("EDI_Email_partner_id_value");
	public static String EDI_Local_Agecy_code_Filter = ExcelData.get("EDI_Local_Agecy_code_Filter");
	public static String EDI_Local_Apply_Button = ExcelData.get("EDI_Local_Apply_Button");
	public static String EDI_Local_Agnecy_Code_Checkbox = ExcelData.get("EDI_Local_Agnecy_Code_Checkbox");
	public static String EDI_Local_Main_Filter = ExcelData.get("EDI_Local_Main_Filter");
	public static String EDI_Local_Profile_Id_Input = ExcelData.get("EDI_Local_Profile_Id_Input");
	public static String EDI_Local_Upload_By_Input = ExcelData.get("EDI_Local_Upload_By_Input");
	public static String EDI_Agecy_First_Value = ExcelData.get("EDI_Agecy_First_Value");
	public static String EDI_Local_Directory_Value = ExcelData.get("EDI_Local_Directory_Value");
	public static String EDI_Local_Profile_Id_value = ExcelData.get("EDI_Local_Profile_Id_value");
	public static String EDI_Local_Update_By_Value = ExcelData.get("EDI_Local_Update_By_Value");
	public static String EDI_Local_Skip_Last_Checkbox = ExcelData.get("EDI_Local_Skip_Last_Checkbox");
	public static String EDI_Email_Main_Filter_Option = ExcelData.get("EDI_Email_Main_Filter_Option");
	public static String EDI_Email_Subject_Input_Field = ExcelData.get("EDI_Email_Subject_Input_Field");
	public static String EDI_Email_Email_input_Filter = ExcelData.get("EDI_Email_Email_input_Filter");
	public static String EDI_Email_First_row_Grid = ExcelData.get("EDI_Email_First_row_Grid");
	public static String EDI_Email_Add_Button = ExcelData.get("EDI_Email_Add_Button");
	public static String EDI_Email_Partner_subject = ExcelData.get("EDI_Email_Partner_subject");
	public static String EDI_Email_Partner_Subject_Field = ExcelData.get("EDI_Email_Partner_Subject_Field");
	public static String EDI_Email_email_chechbox = ExcelData.get("EDI_Email_email_chechbox");
	public static String EDI_Email_Remove_Button = ExcelData.get("EDI_Email_Remove_Button");
	public static String EDI_Email_Agency_code_Checkbox = ExcelData.get("EDI_Email_Agency_code_Checkbox");
	public static String EDI_Local_First_Row_Grid = ExcelData.get("EDI_Local_First_Row_Grid");
	public static String EDI_Local_Add_Button = ExcelData.get("EDI_Local_Add_Button");
	public static String EDI_Web_Service_Profile_id = ExcelData.get("EDI_Web_Service_Profile_id");
	public static String EDI_Web_Service_Profile_Upload_Id = ExcelData.get("EDI_Web_Service_Profile_Upload_Id");
	public static String EDI_Web_Service_Profile_Sharepath = ExcelData.get("EDI_Web_Service_Profile_Sharepath");
	public static String EDI_Web_Setvice_Agency_Code = ExcelData.get("EDI_Web_Setvice_Agency_Code");
	public static String EDI_Web_Service_Agency_Code = ExcelData.get("EDI_Web_Service_Agency_Code");
	public static String EDI_Web_Service_Agency_Code_Filter = ExcelData.get("EDI_Web_Service_Agency_Code_Filter");
	public static String EDI_Web_Service_Agency_Code_Input_Filter = ExcelData.get("EDI_Web_Service_Agency_Code_Input_Filter");
	public static String EDI_Web_Service_Agency_Code_Apply_Button = ExcelData.get("EDI_Web_Service_Agency_Code_Apply_Button");
	public static String EDI_Web_Service_Skip_Last_Checkbox = ExcelData.get("EDI_Web_Service_Skip_Last_Checkbox");
	public static String EDI_Web_Service_Profile_id_Input = ExcelData.get("EDI_Web_Service_Profile_id_Input");
	public static String EDI_Web_Service_Sharepath_Input = ExcelData.get("EDI_Web_Service_Sharepath_Input");
	public static String EDI_Local_Status_Dropdown = ExcelData.get("EDI_Local_Status_Dropdown");
	public static String EDI_Local_Status_Option = ExcelData.get("EDI_Local_Status_Option");
	public static String EDI_Local_Directory_Checkbox = ExcelData.get("EDI_Local_Directory_Checkbox");
	public static String EDI_Web_Service_Status = ExcelData.get("EDI_Web_Service_Status");
	public static String EDI_Web_Service_Dropdown_Option = ExcelData.get("EDI_Web_Service_Dropdown_Option");
	public static String EDI_Web_Service_Main_Filter_Grid = ExcelData.get("EDI_Web_Service_Main_Filter_Grid");
	public static String EDI_Web_Setvice_Profile_Id_value = ExcelData.get("EDI_Web_Setvice_Profile_Id_value");
	public static String EDI_Web_Service_Sharepath_Input_Value = ExcelData.get("EDI_Web_Service_Sharepath_Input_Value");
	public static String EDI_Web_Service_Add_Button = ExcelData.get("EDI_Web_Service_Add_Button");
	public static String EDI_Web_Service_Agency_Code_CheckBxo_Option = ExcelData.get("EDI_Web_Service_Agency_Code_CheckBxo_Option");
	public static String EDI_Web_Setvice_Grid_First_Row = ExcelData.get("EDI_Web_Setvice_Grid_First_Row");
	public static String EDI_Web_Service_Sharepath_Check_Box = ExcelData.get("EDI_Web_Service_Sharepath_Check_Box");
	public static String EDI_File_Name_Input = ExcelData.get("EDI_File_Name_Input");
	public static String EDI_File_Agency_Code_Button = ExcelData.get("EDI_File_Agency_Code_Button");
	public static String EDI_File_Agency_Filter_Option = ExcelData.get("EDI_File_Agency_Filter_Option");
	public static String EDI_Filter_Agency_Input = ExcelData.get("EDI_Filter_Agency_Input");
	public static String EDI_Filter_Agency_First_Check_Box = ExcelData.get("EDI_Filter_Agency_First_Check_Box");
	public static String EDI_Filter_Apply_Button = ExcelData.get("EDI_Filter_Apply_Button");
	public static String EDI_File_main_Filter_Option = ExcelData.get("EDI_File_main_Filter_Option");
	public static String EDI_File_Grid_Input_Filed = ExcelData.get("EDI_File_Grid_Input_Filed");
	public static String EDI_FileName_Value = ExcelData.get("EDI_FileName_Value");
	public static String EDI_File_Name_Skip_No_Last_CheckBox = ExcelData.get("EDI_File_Name_Skip_No_Last_CheckBox");
	public static String EDI_File_Name_First_Row = ExcelData.get("EDI_File_Name_First_Row");
	public static String EDI_File_Add_Button = ExcelData.get("EDI_File_Add_Button");
	public static String EDI_File_Name_Check_Box = ExcelData.get("EDI_File_Name_Check_Box");
	public static String EDI_Segment_Name_Input = ExcelData.get("EDI_Segment_Name_Input");
	public static String EDI_Content_Filter_Element_Input = ExcelData.get("EDI_Content_Filter_Element_Input");	
	public static String EDI_Content_Filter_Sub_Element = ExcelData.get("EDI_Content_Filter_Sub_Element");	
	public static String EDI_Content_Filter_Value_Input = ExcelData.get("EDI_Content_Filter_Value_Input");	
	public static String EDI_Content_Filter_Agency_Code = ExcelData.get("EDI_Content_Filter_Agency_Code");	
	public static String EDI_Content_Filter_Agency_Filter = ExcelData.get("EDI_Content_Filter_Agency_Filter");	
	public static String EDI_Content_Filter_input = ExcelData.get("EDI_Content_Filter_input");	
	public static String EDI_Content_Agancy_Filter_First_Value = ExcelData.get("EDI_Content_Agancy_Filter_First_Value");
	public static String EDI_Content_Apply_Button = ExcelData.get("EDI_Content_Apply_Button");
	public static String EDI_Content_Main_Filter = ExcelData.get("EDI_Content_Main_Filter");
	public static String EDI_Content_Segment_Input = ExcelData.get("EDI_Content_Segment_Input");
	public static String EDI_Content_Value_Input = ExcelData.get("EDI_Content_Value_Input");
	public static String EDI_Content_Element_Input = ExcelData.get("EDI_Content_Element_Input");
	public static String EDI_Content_Skip_To_Last_Checkbox = ExcelData.get("EDI_Content_Skip_To_Last_Checkbox");
	public static String EDI_Content_First_Now = ExcelData.get("EDI_Content_First_Now");
	public static String EDI_Content_Add_Button = ExcelData.get("EDI_Content_Add_Button");
	public static String EDI_Content_Segment_Value = ExcelData.get("EDI_Content_Segment_Value");
	public static String EDI_Content_Segement_Check_Box = ExcelData.get("EDI_Content_Segement_Check_Box");

	public static String EDI_Content_First_values = ExcelData.get("EDI_Content_First_values");

	
	
	
	
	
	
}
