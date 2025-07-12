package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Common_Locators extends Detention_Demurage_Extention_Locators, Accounting_Configuration_Locators,
		ActivityDefinition_Locators, Agency_Configiration_Locators, Agency_Master_Locators, Arrival_Notice_Locators,
		Bill_Of_Lading_Locators, Bill_Upload_Gate, Billing_Invoice_Locators, Booking_Locators, CAR_Approval_Locators,
		Coastal_Schedule_Locators, Contract_Management_System_Locators, Contract_Mapping_Locators,
		Cost_Activity_Report_Locators, Current_History_Report_Locators, Customer_Statement_Report_Locators,
		Delivery_Order_Locators, Detention_Waiver_Locators, Disbursement_Locators, Discharge_Confirmation_Locators,
		Discharge_Recollination_Locators, Ecommerce_Gateway_Locators, Ecommerce_Validator_Locators,
		EDI_Creation_Locators, EDI_Request_Submission_Locators,
		EMS_Contract_Billing_Generation_And_Verification_Locators, EMS_Contract_Billing_Generation,
		Ems_Contract_Registration_Locators, EMS_EDI_Configuration_Locators, EMS_Gate_Locators, Enquiry_History_Locators,
		Equipment_Activity_Locators, Equipment_Master_Locators, Equipment_Profile_Locators,
		Global_Activity_Mapping_Locators, Global_Configuration_Locators, Import_Invoice_Locators,
		ImportDocumentation_Locators, Invoice_Locators, Invoice_Reversal_Locators, Journal_Locators,
		Journal_Uploads_Locators, LoadConfirmation_Locators, Long_Term_Creation_Locators, Maraine_Distance_Locators,
		Master_Reactivation_Locators, MCN_Locators, Movement_Entry_Locators, On_Off_Hire_Locators,
		Outstanding_Freight_Report_Locators, Payable_Payment_Locators, Plugin_Configuration_Locators, Ports_Locators,
		Predictable_Activity_Locators, Proforma_Service_Creation_Locators, Rate_Request_Loactors, Receipt_Locators,
		Receivable_Receipt_Locators, Recurring_Journal_Locators, Reversal_Locators, Scale_In_Out_Reference,
		Schedule_Security_Locators, Service_Creation_Locators, Srr_Gate_Locators, Supplier_Invoice_Locators,
		Tdn_Locators, User_Level_Security_Locators, User_Management_Locators, Vendor_Contract_Locators,
		Vendor_Invoice_Registration_Locators, Vessel_Locators, Work_Order_Creation_Locators,
		Ecommerce_Customer_Gate_Locators, Ecommerce_Notice_Locators, Ecom_insurance_acess,
		EcommHotLineContacts_Locators, EComm_KYC_Detail_Locators, DA_Master_Setup_Locators, Customer_Master_Locators,
		Routing_Locators, Treasury_ROE_Locators, Ecomm_Registration_Locators, Capacity_Allocation,
		Ecommerce_Email_To_Customers_Locators, Ecommerce_Customer_Agency_Mapping_Locators, Invoice_Report_Locators,
		Manifest_Closure_Force_Locators, Ecom_notification_Locators, Split_Booking_Locators,
		Detention_Demurage_Invioce_Locators, Local_Contacts_Locators, Merge_Booking_Locators, Vessel_Info_Locators,
		Printout_Configuration_Locators, CRO_Locators, Repair_Approval_Locators, Day_Light_Configuration_Locators,
		Slot_Cost_Calcuator_Locators, Global_Search_Locators, Feeder_Contract_Locators, Rate_Request_RR_Loactors,
		User_Management_Report_Locators, Operation_list_View_Locators, Haulage_Contract_Locators,
		Ecom_Commodity_Restriction_Locator, Import_Documentation_Transfer_Locators, Discharge_Planning_Locators,
		Vendor_Master_Locators, Vendor_Invoice_Disbursement_Currency_Locators, Haulage_Expense_Report_locators,
		Cost_Configuration_Locators, ENDPoint_Configuration_Locators, EDI_Dashboard_Locators, EDI_Code_Mapping_Locators,
		EDI_Tracker_Locators, Split_BL_Locators, DG_Creation_Locators, Regional_Trade_Mapping_Locators,
		PartBL_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Common_Locators", "Reference_Name",
			Testcases.environmentName);

	public static String Username_input = ExcelData.get("Username_input");
	public static String Password_input = ExcelData.get("Password_input");
	public static String Login = ExcelData.get("Login");
	public static String Home_Logo = ExcelData.get("Home_Logo");
	public static String Search_Input = ExcelData.get("Search_Input");
	public static String Module_Select = ExcelData.get("Module_Select");
	public static String SaveButton_ToolBar = ExcelData.get("SaveButton_ToolBar");
	public static String popup_Message = ExcelData.get("popup_Message");
	public static String popup_Message_Ok_Button = ExcelData.get("popup_Message_Ok_Button");
	public static String Edit_Button_toolBar = ExcelData.get("Edit_Button_toolBar");
	public static String Logout_Icon = ExcelData.get("Logout_Icon");
	public static String Logout_Yes_Btn = ExcelData.get("Logout_Yes_Btn");
	public static String timeInput = ExcelData.get("timeInput");
	public static String date_select = ExcelData.get("date_select");
	public static String dateSelect = ExcelData.get("dateSelect");
	public static String Module_Close = ExcelData.get("Module_Close");
	public static String Current_Module_Name = ExcelData.get("Current_Module_Name");
	public static String total_records = ExcelData.get("total_records");
	public static String Processing_Locator = ExcelData.get("Processing_Locator");
	public static String Filter_Field = ExcelData.get("Filter_Field");
	public static String contains_Click = ExcelData.get("contains_Click");
	public static String select_Button = ExcelData.get("select_Button");
	public static String Filter_Field1 = ExcelData.get("Filter_Field1");
	public static String Filter_Field2 = ExcelData.get("Filter_Field2");
	public static String Filter_Button1 = ExcelData.get("Filter_Button1");
	public static String Filter_Button2 = ExcelData.get("Filter_Button2");
	public static String column_values_Right = ExcelData.get("column_values_Right");
	public static String hide_Menu_ID = ExcelData.get("hide_Menu_ID");
	public static String main_Menu_ID = ExcelData.get("main_Menu_ID");
	public static String close_second_tab = ExcelData.get("close_second_tab");
	public static String first_tab_inside_click = ExcelData.get("first_tab_inside_click");
	public static String Doc_Agency = ExcelData.get("Doc_Agency");
	public static String Profile_Dropdown = ExcelData.get("Profile_Dropdown");
	public static String Corporate_Profile = ExcelData.get("Corporate_Profile");
	public static String Location_Profile = ExcelData.get("Location_Profile");
	public static String reset_Profile_Button = ExcelData.get("reset_Profile_Button");
	public static String Amount_header = ExcelData.get("Amount_header");
	public static String Date_Select = ExcelData.get("Date_Select");
	public static String Switch_Profile = ExcelData.get("Switch_Profile");
	public static String agency_Code_Filter = ExcelData.get("agency_Code_Filter");
	public static String select_Agency = ExcelData.get("select_Agency");
	public static String Switch_Profile_Button = ExcelData.get("Switch_Profile_Button");
	public static String Month_DD = ExcelData.get("Month_DD");
	public static String Year_DD = ExcelData.get("Year_DD");
	public static String select_Second = ExcelData.get("select_Second");
	public static String select_Third = ExcelData.get("select_Third");
	public static String globalSearch_Frame = ExcelData.get("globalSearch_Frame");
	public static String type_Select1 = ExcelData.get("type_Select1");
	public static String type_Select2 = ExcelData.get("type_Select2");
	public static String type_Select3 = ExcelData.get("type_Select3");
	public static String globalSearch_Condition_Dropdown1 = ExcelData.get("globalSearch_Condition_Dropdown1");
	public static String globalSearch_Condition_Dropdown2 = ExcelData.get("globalSearch_Condition_Dropdown2");
	public static String globalSearch_Condition_Dropdown3 = ExcelData.get("globalSearch_Condition_Dropdown3");
	public static String globalSearch_InputTextfield1 = ExcelData.get("globalSearch_InputTextfield1");
	public static String globalSearch_InputTextfield2 = ExcelData.get("globalSearch_InputTextfield2");
	public static String globalSearch_InputTextfield3 = ExcelData.get("globalSearch_InputTextfield3");
	public static String globalSearch_Frame_SearchButton = ExcelData.get("globalSearch_Frame_SearchButton");
	public static String retrivedGlobalValue = ExcelData.get("retrivedGlobalValue");
	public static String SelectButton = ExcelData.get("SelectButton");
	public static String FilterOption_Menu = ExcelData.get("FilterOption_Menu");
	public static String retrieved_Value_Select = ExcelData.get("retrieved_Value_Select");
	public static String select_first = ExcelData.get("select_first");
	public static String popup_Message_Yes_Button = ExcelData.get("popup_Message_Yes_Button");
	public static String popup_Message_No_Button = ExcelData.get("popup_Message_No_Button");
	public static String Popup_Message = ExcelData.get("Popup_Message");
	public static String First_Row_select = ExcelData.get("First_Row_select");
	public static String globalSearchCloseIcon_L = ExcelData.get("globalSearchCloseIcon_L");
	public static String Column_SelectMenu = ExcelData.get("Column_SelectMenu");
	public static String SelectAll_Column_CheckBox = ExcelData.get("SelectAll_Column_CheckBox");
	public static String Column_Search_Input = ExcelData.get("Column_Search_Input");
	public static String Select_Column_tableHead = ExcelData.get("Select_Column_tableHead");
	public static String Select_Column_Head = ExcelData.get("Select_Column_Head");
	public static String Close_Date = ExcelData.get("Close_Date");
	public static String AG_Grid_Column_EComm_Gateway = ExcelData.get("AG_Grid_Column_EComm_Gateway");
	public static String AG_Grid_Columns_Button = ExcelData.get("AG_Grid_Columns_Button");
	public static String AG_Grid_Column_All_Select_Checkbox = ExcelData.get("AG_Grid_Column_All_Select_Checkbox");
	public static String AG_Grid_Column_Searchbox = ExcelData.get("AG_Grid_Column_Searchbox");
	public static String AG_Grid_Column_Checkboxs = ExcelData.get("AG_Grid_Column_Checkboxs");
	public static String AG_Grid_First_Row = ExcelData.get("AG_Grid_First_Row");
	public static String Close_Current_tab = ExcelData.get("Close_Current_tab");
	public static String DropDown_Select = ExcelData.get("DropDown_Select");
	public static String total_records_in_car = ExcelData.get("total_records_in_car");
	public static String two_Column_Search_Column_Header = ExcelData.get("two_Column_Search_Column_Header");
	public static String Filter_Input_Field = ExcelData.get("Filter_Input_Field");
	public static String Filter_Button = ExcelData.get("Filter_Button");
	public static String Filter_Operator = ExcelData.get("Filter_Operator");
	public static String Equals_Option = ExcelData.get("Equals_Option");
	public static String column_Value = ExcelData.get("column_Value");
	public static String Car_Close = ExcelData.get("Car_Close");
	public static String Attachement_Button_toolBar = ExcelData.get("Attachement_Button_toolBar");
	public static String First_Row_click = ExcelData.get("First_Row_click");
	public static String Attach_File_button = ExcelData.get("Attach_File_button");
	public static String Upload_button = ExcelData.get("Upload_button");
	public static String Attached_FileName = ExcelData.get("Attached_FileName");
	public static String Export_button_Toolbar = ExcelData.get("Export_button_Toolbar");
	public static String Remove_attachment_yes = ExcelData.get("Remove_attachment_yes");
	public static String package_search_input_select = ExcelData.get("package_search_input_select");
	public static String SearchButton_Toolbar = ExcelData.get("SearchButton_Toolbar");
	public static String Delete_button_toolBar = ExcelData.get("Delete_button_toolBar");
	public static String Print_Button_toolBar = ExcelData.get("Print_Button_toolBar");
	public static String NewButton_ToolBar = ExcelData.get("NewButton_ToolBar");
	public static String SaveAs_button_toolBar = ExcelData.get("SaveAs_button_toolBar");
	public static String Export_button_toolBar = ExcelData.get("Export_button_toolBar");
	public static String cancel_Common_btn = ExcelData.get("cancel_Common_btn");
	public static String print_Common_btn = ExcelData.get("print_Common_btn");
	public static String first_Common_btn = ExcelData.get("first_Common_btn");
	public static String prev_Common_btn = ExcelData.get("prev_Common_btn");
	public static String next_Common_btn = ExcelData.get("next_Common_btn");
	public static String last_Common_btn = ExcelData.get("last_Common_btn");
	public static String Auto_Save_Common_btn = ExcelData.get("Auto_Save_Common_btn");
	public static String navigate_Common_btn = ExcelData.get("navigate_Common_btn");
	public static String Autosave_Common_btn = ExcelData.get("Autosave_Common_btn");
	public static String droup_select_discharge = ExcelData.get("droup_select_discharge");
	public static String AG_Grid_Columns_Button_DW = ExcelData.get("AG_Grid_Columns_Button_DW");
	public static String AG_Grid_Column_All_Select_Checkbox_DW = ExcelData.get("AG_Grid_Column_All_Select_Checkbox_DW");
	public static String AG_Grid_Column_Searchbox_DW = ExcelData.get("AG_Grid_Column_Searchbox_DW");
	public static String AG_Grid_Column_Checkboxs_DW = ExcelData.get("AG_Grid_Column_Checkboxs_DW");
	public static String MoreOption_Grid = ExcelData.get("MoreOption_Grid");
	public static String AG_Grid_Headers = ExcelData.get("AG_Grid_Headers");
	public static String AG_Grid_Filter_Field = ExcelData.get("AG_Grid_Filter_Field");
	public static String AG_Grid_Filter_Button = ExcelData.get("AG_Grid_Filter_Button");
	public static String AG_Grid_Row_CheckBox = ExcelData.get("AG_Grid_Row_CheckBox");
	public static String AG_Grid_Columns_Button1 = ExcelData.get("AG_Grid_Columns_Button1");
	public static String AG_Grid_Column_All_Select_Checkbox1 = ExcelData.get("AG_Grid_Column_All_Select_Checkbox1");
	public static String AG_Grid_Column_Searchbox1 = ExcelData.get("AG_Grid_Column_Searchbox1");
	public static String AG_Grid_Column_Checkboxs1 = ExcelData.get("AG_Grid_Column_Checkboxs1");
	public static String MoreOption_Grid_V2 = ExcelData.get("MoreOption_Grid_V2");
	public static String FilterOption_Menu_V2 = ExcelData.get("FilterOption_Menu_V2");
	public static String AG_Gridcolumns_new = ExcelData.get("AG_Gridcolumns_new");
	public static String Expense_AG_Grid_Column = ExcelData.get("Expense_AG_Grid_Column");
	public static String Expense_AG_Grid_Select_All_Checkbox = ExcelData.get("Expense_AG_Grid_Select_All_Checkbox");
	public static String Expense_AG_Grid_Searchbox = ExcelData.get("Expense_AG_Grid_Searchbox");
	public static String Version_Field = ExcelData.get("Version_Field");
	public static String verticalscroll = ExcelData.get("verticalscroll");
	public static String Outlook_OTP = ExcelData.get("Outlook_OTP");
	public static String OTP_Mail_Content = ExcelData.get("OTP_Mail_Content");
	public static String OTP_Input_Field = ExcelData.get("OTP_Input_Field");
	public static String OTP_Proceed_Button = ExcelData.get("OTP_Proceed_Button");
	public static String Loading_Locator = ExcelData.get("Loading_Locator");
	public static String AG_Grid_Table_Data_Headers = ExcelData.get("AG_Grid_Table_Data_Headers");
	public static String AG_Grid_Table_Data_Rows = ExcelData.get("AG_Grid_Table_Data_Rows");
	public static String AG_Grid_Blank_Filter_Option = ExcelData.get("AG_Grid_Blank_Filter_Option");

	public static String two_Column_Search_Column_1_Gridcells = ExcelData.get("two_Column_Search_Column_1_Gridcells");
	public static String twoColumnSearch_Cancel_Button = ExcelData.get("twoColumnSearch_Cancel_Button");
	public static String two_Column_Search_Row = ExcelData.get("two_Column_Search_Row");

	public static String AG_Grid_DistinctFilter_Filterbutton = ExcelData.get("AG_Grid_DistinctFilter_Filterbutton");
	public static String AG_Grid_DistinctFilter_FilterInput = ExcelData.get("AG_Grid_DistinctFilter_FilterInput");
	public static String AG_Grid_DistinctFilter_SelectAll = ExcelData.get("AG_Grid_DistinctFilter_SelectAll");
	public static String AG_Grid_DistinctFilter_Selectvalue = ExcelData.get("AG_Grid_DistinctFilter_Selectvalue");
	public static String AG_Grid_DistinctFilter_FilterTab = ExcelData.get("AG_Grid_DistinctFilter_FilterTab");
	public static String AG_FilterOptionScroller = ExcelData.get("AG_FilterOptionScroller");

	public static String Download_CSV_Option = ExcelData.get("Download_CSV_Option");

	public static String AG_Grid_Inputs_HeaderColumn = ExcelData.get("AG_Grid_Inputs_HeaderColumn");
	public static String Grid_Filter_InputField = ExcelData.get("Grid_Filter_InputField");
	public static String Selected_Row_Grid = ExcelData.get("Selected_Row_Grid");

	public static String Login_With_OTP_Button = ExcelData.get("Login_With_OTP_Button");
	public static String Orgin_Agency_Name = ExcelData.get("Orgin_Agency_Name");
	public static String Year_Text_Value = ExcelData.get("Year_Text_Value");
	public static String Month_Text_Value = ExcelData.get("Month_Text_Value");
	public static String Date_Text_Value = ExcelData.get("Date_Text_Value");
	public static String previous_Button_DatePicker = ExcelData.get("previous_Button_DatePicker");
	public static String next_Button_DatePicker = ExcelData.get("next_Button_DatePicker");
	public static String Table_Headers_AgGrid = ExcelData.get("Table_Headers_AgGrid");
	public static String Table_Headers_AgGrid_Values = ExcelData.get("Table_Headers_AgGrid_Values");
}
