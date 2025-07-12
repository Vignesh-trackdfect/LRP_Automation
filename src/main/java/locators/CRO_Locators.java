package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface CRO_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "CRO", "Reference_Name", Testcases.environmentName);
	public static String booking_No_SearchButton_CRO = ExcelData.get("booking_No_SearchButton_CRO");
	public static String acceptance_Terminal_SearchButton_CRO = ExcelData.get("acceptance_Terminal_SearchButton_CRO");
	public static String BL_Type_SearchButton_CRO = ExcelData.get("BL_Type_SearchButton_CRO");
	public static String Booking_No_Field_CRO = ExcelData.get("Booking_No_Field_CRO");
	public static String Terminal_ETA_Date_CRO = ExcelData.get("Terminal_ETA_Date_CRO");
	public static String Valid_To_CRO = ExcelData.get("Valid_To_CRO");
	public static String Terminal_ETD_Date_CRO = ExcelData.get("Terminal_ETD_Date_CRO");

	
	public static String PCM_Dropdown_CRO = ExcelData.get("PCM_Dropdown_CRO");
//	public static String moduleName_Search_Dropdown = ExcelData.get("moduleName_Search_Dropdown");
//	public static String band_Select = ExcelData.get("band_Select");
	public static String Release_Terminal_SearchButton_CRO = ExcelData.get("Release_Terminal_SearchButton_CRO");
	public static String Agency_Special_Remarks_input = ExcelData.get("Agency_Special_Remarks_input");
	public static String Release_No_CRO = ExcelData.get("Release_No_CRO");
	public static String Commodity_first_grid = ExcelData.get("Commodity_first_grid");
	public static String Multi_copy_click = ExcelData.get("Multi_copy_click");
	public static String Multi_copy_click_all = ExcelData.get("Multi_copy_click_all");
	public static String Multi_copy_click_all_ok = ExcelData.get("Multi_copy_click_all_ok");
	public static String Cro_WithoutBooking_CheckBox = ExcelData.get("Cro_WithoutBooking_CheckBox");
	public static String Cro_WithBooking_CheckBox = ExcelData.get("Cro_WithBooking_CheckBox");
	public static String Equipment_SearchButton_CRO = ExcelData.get("Equipment_SearchButton_CRO");
	public static String Add_Button_CRO = ExcelData.get("Add_Button_CRO");
	public static String CRO_Ports_SearchButton_CRO = ExcelData.get("CRO_Ports_SearchButton_CRO");
	public static String Quantity_TF_CRO = ExcelData.get("Quantity_TF_CRO");
	public static String Release_number_Input = ExcelData.get("Release_number_Input");
	public static String Booking_Cus_type_Select = ExcelData.get("Booking_Cus_Type");
	public static String Booking_Customer_Remove_Btn = ExcelData.get("Booking_Customer_Remove_Btn");
	public static String Booking_Customer_Add_Btn = ExcelData.get("Booking_Customer_Add_Btn");
	public static String Cro_Remarks_TextField = ExcelData.get("Cro_Remarks_TextField");
	public static String Valid_From_CRO = ExcelData.get("Valid_From_CRO");
	public static String Customer_Details_Search_Button_CRO = ExcelData.get("Customer_Details_Search_Button_CRO");
	public static String Container_Released_Date = ExcelData.get("Container_Released_Date");
	public static String Container_Grid_First_row = ExcelData.get("Container_Grid_First_row");
	public static String Stock_Button_CRO = ExcelData.get("Stock_Button_CRO");
	public static String CRO_Without_Booking_Radio_Button = ExcelData.get("CRO_Without_Booking_Radio_Button");
	public static String Ports_Search_Button_CRO = ExcelData.get("Ports_Search_Button_CRO");
	public static String By_Type_Search_Button_CRO = ExcelData.get("By_Type_Search_Button_CRO");
	public static String Haulier_Search_Button_CRO = ExcelData.get("Haulier_Search_Button_CRO");
	public static String By_Container_No_CRO = ExcelData.get("By_Container_No_CRO");
	public static String DG_Ref_No_CRO = ExcelData.get("DG_Ref_No_CRO");
	public static String Type_CRO = ExcelData.get("Type_CRO");
	public static String IMDGClass_CRO = ExcelData.get("IMDGClass_CRO");
	public static String NOR_CRO = ExcelData.get("NOR_CRO");
	public static String Remark_Button = ExcelData.get("Remark_Button");
	public static String Description_Text = ExcelData.get("Description_Text");
	public static String Description_Add_Button = ExcelData.get("Description_Add_Button");
	public static String CRO_Tab_Verify = ExcelData.get("CRO_Tab_Verify");
	public static String CRO_Service = ExcelData.get("CRO_Service");
	public static String CRO_Vessel = ExcelData.get("CRO_Vessel");
	public static String CRO_Voyage = ExcelData.get("CRO_Voyage");
	public static String CRO_Bound = ExcelData.get("CRO_Bound");
	public static String CRO_PLA = ExcelData.get("CRO_PLA");
	public static String CRO_POL = ExcelData.get("CRO_POL");
	public static String CRO_POD = ExcelData.get("CRO_POD");
	public static String CRO_PLD = ExcelData.get("CRO_PLD");
	public static String CRO_ETA = ExcelData.get("CRO_ETA");
	public static String CRO_ETD = ExcelData.get("CRO_ETD");

	public static String CRO_Release_Terminal_Name_Textfield = ExcelData.get("CRO_Release_Terminal_Name_Textfield");
	public static String CRO_Booking_No = ExcelData.get("CRO_Booking_No");
	public static String CRO_Release_Terminal_Search_Btn = ExcelData.get("CRO_Release_Terminal_Search_Btn");

	public static String Container_Type_CRO = ExcelData.get("Container_Type_CRO");
	public static String CRO_Quantity = ExcelData.get("CRO_Quantity");
	public static String CRO_Edit_btn = ExcelData.get("CRO_Edit_btn");
	
	public static String Bookng_Customer_Table_Header = ExcelData.get("Bookng_Customer_Table_Header");
	public static String Bookng_Customer_Table_Row = ExcelData.get("Bookng_Customer_Table_Row");
	public static String Bookng_Customer_Name_By_CUS_Type = ExcelData.get("Bookng_Customer_Name_By_CUS_Type");
	public static String Booking_Customer_Names = ExcelData.get("Booking_Customer_Names");
	public static String CRO_Customer = ExcelData.get("CRO_Customer");
	public static String Cro_Customer_Search_Bttn = ExcelData.get("Cro_Customer_Search_Bttn");
	public static String Cro_Customer_Names = ExcelData.get("Cro_Customer_Names");
	public static String Global_Search_Cancel = ExcelData.get("Global_Search_Cancel");
	
	
}
