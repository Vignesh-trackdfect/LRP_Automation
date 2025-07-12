package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Agency_Master_Locators{

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Agency_Master", "Reference_Name", Testcases.environmentName);

	public static String Agency_Type_Input_AM = ExcelData.get("Agency_Type_Input_AM");
	public static String AgencyType_option_AM = ExcelData.get("AgencyType_option_AM");
	public static String Controlling_Ports_AM = ExcelData.get("Controlling_Ports_AM");
	public static String Due_Date_AM = ExcelData.get("Due_Date_AM");
	public static String Agency_Code_Input_AM = ExcelData.get("Agency_Code_Input_AM");
	public static String Agency_Code_SearchBtn_AM = ExcelData.get("Agency_Code_SearchBtn_AM");
	public static String NetAgency_Input_AM = ExcelData.get("NetAgency_Input_AM");
	public static String Agency_Code_Filter_Input_AM = ExcelData.get("Agency_Code_Filter_Input_AM");
	public static String Agency_Name_Input_AM = ExcelData.get("Agency_Name_Input_AM");
	public static String CorporateNameInput = ExcelData.get("CorporateNameInput");
	public static String CarrierCode_search = ExcelData.get("CarrierCode_search");
	public static String Address_Input = ExcelData.get("Address_Input");
	public static String City_Input = ExcelData.get("City_Input");
	public static String CountrySearch = ExcelData.get("CountrySearch");
	public static String UNPort_Search = ExcelData.get("UNPort_Search");
	public static String CurrencyCode_Search = ExcelData.get("CurrencyCode_Search");
	public static String Ph_countryCode = ExcelData.get("Ph_countryCode");
	public static String PhoneNumber_input = ExcelData.get("PhoneNumber_input");
	public static String FaxCode_input = ExcelData.get("FaxCode_input");
	public static String Fax_input = ExcelData.get("Fax_input");
	public static String Email_input = ExcelData.get("Email_input");
	public static String InActive = ExcelData.get("InActive");
	public static String IN_ActiveCheckbox = ExcelData.get("IN_ActiveCheckbox");
	public static String Booking_Number_Input = ExcelData.get("Booking_Number_Input");
	public static String BookingActiveCheck = ExcelData.get("BookingActiveCheck");
	public static String AgencyCodeInput = ExcelData.get("AgencyCodeInput");
	public static String Search_Agency = ExcelData.get("Search_Agency");
	public static String AgencyTypeInput = ExcelData.get("AgencyTypeInput");
	public static String BranchCodeInput = ExcelData.get("BranchCodeInput");
	public static String BranchAgencyCode_Search = ExcelData.get("BranchAgencyCode_Search");
	public static String TypeDropdown = ExcelData.get("TypeDropdown");
	public static String SelectBranch = ExcelData.get("SelectBranch");
	public static String BranchName_Input = ExcelData.get("BranchName_Input");
	public static String Select_office = ExcelData.get("Select_office");

	public static String ControllingPorts_Tab = ExcelData.get("ControllingPorts_Tab");
	public static String AM_ValidFrom = ExcelData.get("AM_ValidFrom");
	public static String AM_ValidTo = ExcelData.get("AM_ValidTo");
	public static String AM_Type = ExcelData.get("AM_Type");
	public static String AM_AddControllingPorts = ExcelData.get("AM_AddControllingPorts");
	public static String AM_Controlling_Ports_Tab = ExcelData.get("AM_Controlling_Ports_Tab");
	public static String AM_Multiple_Filter = ExcelData.get("AM_Multiple_Filter");
	public static String AM_Click_For_More_Options = ExcelData.get("AM_Click_For_More_Options");
	public static String AM_Port_Name_Rows = ExcelData.get("AM_Port_Name_Rows");
	public static String AM_Copy_Option = ExcelData.get("AM_Copy_Option");
	public static String AM_Login_Name_Filter_button = ExcelData.get("AM_Login_Name_Filter_button");
	public static String AM_Paste_Input_Field = ExcelData.get("AM_Paste_Input_Field");
	public static String AM_Selected_Rows = ExcelData.get("AM_Selected_Rows");
	public static String AM_Filter_button = ExcelData.get("AM_Filter_button");
	public static String AM_Selected_Rows_Paste_Input_Field = ExcelData.get("AM_Selected_Rows_Paste_Input_Field");
	public static String AM_Grid_Filter = ExcelData.get("AM_Grid_Filter");
	public static String AM_Grid_Filter_input_field = ExcelData.get("AM_Grid_Filter_input_field");
	public static String AM_Grid_filter_Total_count = ExcelData.get("AM_Grid_filter_Total_count");
	public static String AM_Rest_btn = ExcelData.get("AM_Rest_btn");
	public static String AM_Expier_checkbox = ExcelData.get("AM_Expier_checkbox");
	public static String AM_Selectall_checkbox = ExcelData.get("AM_Selectall_checkbox");
	public static String AM_Export_button_toolBar = ExcelData.get("AM_Export_button_toolBar");
	public static String AM_Expiry_Status_Filter_btn = ExcelData.get("AM_Expiry_Status_Filter_btn");
	public static String AM_Expire_Status_col = ExcelData.get("AM_Expire_Status_col");
	public static String Total_Record_Count = ExcelData.get("Total_Record_Count");
	public static String AM_CSV_Button_Toolbar = ExcelData.get("AM_CSV_Button_Toolbar");
	public static String AM_Fullscreen_Button_toolbar = ExcelData.get("AM_Fullscreen_Button_toolbar");
	public static String AM_fullscreen_display = ExcelData.get("AM_fullscreen_display");
	public static String AM_AgencyDetail_Toolbar = ExcelData.get("AM_AgencyDetail_Toolbar");
	public static String AM_Condition_Filter_Button = ExcelData.get("AM_Condition_Filter_Button");
	public static String AM_Port_Code_input = ExcelData.get("AM_Port_Code_input");
	public static String AM_Grid_Table = ExcelData.get("AM_Grid_Table");
	public static String AM_Grid_Header = ExcelData.get("AM_Grid_Header");
	public static String AM_Grid_Rows = ExcelData.get("AM_Grid_Rows");
	public static String AM_status_Input = ExcelData.get("AM_status_Input");
	public static String Controlling_Ports_Tab = ExcelData.get("Controlling_Ports_Tab");
	public static String Menu_Button = ExcelData.get("Menu_Button");
	public static String Pin_Column = ExcelData.get("Pin_Column");
	public static String Pin_Right = ExcelData.get("Pin_Right");
	public static String Pin_Left = ExcelData.get("Pin_Left");
	public static String Column_Header = ExcelData.get("Column_Header");
	public static String AM_Table_Header = ExcelData.get("AM_Table_Header");
	public static String AM_First_Row = ExcelData.get("AM_First_Row");
	public static String AM_Table_Column_Header = ExcelData.get("AM_Table_Column_Header");
	public static String AM_Total_Records = ExcelData.get("AM_Total_Records");
	public static String AM_Table = ExcelData.get("AM_Table");
	public static String AM_ToolPanel = ExcelData.get("AM_ToolPanel");
	public static String AM_Save_Template = ExcelData.get("AM_Save_Template");
	public static String AM_Template_Name = ExcelData.get("AM_Template_Name");
	public static String AM_Template_Name_Save = ExcelData.get("AM_Template_Name_Save");
	public static String AM_Template_Header = ExcelData.get("AM_Template_Header");
	public static String AM_Grid_Select_All_Check_Box = ExcelData.get("AM_Grid_Select_All_Check_Box");
	public static String AM_Checkbox_Search = ExcelData.get("AM_Checkbox_Search");
	public static String AM_Grid_Select_Text_Value = ExcelData.get("AM_Grid_Select_Text_Value");
	public static String AM_SaveAs_Template = ExcelData.get("AM_SaveAs_Template");
	public static String AM_Menu_Filter = ExcelData.get("AM_Menu_Filter");
	public static String AM_Delete_Templete = ExcelData.get("AM_Delete_Templete");
	public static String AM_Distinct_Filter_Template = ExcelData.get("AM_Distinct_Filter_Template");
	public static String AM_Select_Header = ExcelData.get("AM_Select_Header");
	public static String AM_Total_Record_Count = ExcelData.get("AM_Total_Record_Count");
	public static String AM_Contacts_Tab = ExcelData.get("AM_Contacts_Tab");
	public static String AM_Grid_Col_Id = ExcelData.get("AM_Grid_Col_Id");
	
	public static String Address_Input_AM = ExcelData.get("Address_Input_AM");

	
	
	
}
