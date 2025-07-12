package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Merge_Booking_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Merge_Booking", "Reference_Name",
			Testcases.environmentName);
	
	public static String MB_Vessel_Search_Button = ExcelData.get("MB_Vessel_Search_Button");
	public static String MB_Service_search_Button = ExcelData.get("MB_Service_search_Button");
	public static String MB_Voyage_Search_Button = ExcelData.get("MB_Voyage_Search_Button");
	public static String MB_PLA_Search_Button = ExcelData.get("MB_PLA_Search_Button");
	public static String MB_POL_Search_Button = ExcelData.get("MB_POL_Search_Button");
	public static String MB_POD_Search_Button = ExcelData.get("MB_POD_Search_Button");
	public static String MB_PLD_Search_Button = ExcelData.get("MB_PLD_Search_Button");
	public static String MB_Agr_Party_Text = ExcelData.get("MB_Agr_Party_Text");
	public static String MB_Show_btn = ExcelData.get("MB_Show_btn");
	public static String MB_BookNum_Select = ExcelData.get("MB_BookNum_Select");
	public static String MB_Next_Button = ExcelData.get("MB_Next_Button");
	public static String MB_Panel_Select = ExcelData.get("MB_Panel_Select");
	public static String MD_Merge_btn = ExcelData.get("MD_Merge_btn");
	public static String MB_Draft_Button = ExcelData.get("MB_Draft_Button");
	public static String MB_Confirm_Button = ExcelData.get("MB_Confirm_Button");
	public static String MB_Un_Containerized_Radio_Button = ExcelData.get("MB_Un_Containerized_Radio_Button");
	public static String Available_Bookings_NO = ExcelData.get("Available_Bookings_NO");
	public static String MB_ADD_Btn = ExcelData.get("MB_ADD_Btn");
	public static String MB_Merged_Btn = ExcelData.get("MB_Merged_Btn");
	public static String Merged_Booking_Container = ExcelData.get("Merged_Booking_Container");
	public static String MD_Service_input = ExcelData.get("MD_Service_input");
	public static String MB_Booking_status = ExcelData.get("MB_Booking_status");
	public static String SOC_Container_Popup = ExcelData.get("SOC_Container_Popup");
	public static String SOC_Validation_Book_Num = ExcelData.get("SOC_Validation_Book_Num");
	public static String Merge_Booking = ExcelData.get("Merge_Booking");
	public static String MB_Merge_btn = ExcelData.get("MB_Merge_btn");
	public static String MB_Confirmed_Button = ExcelData.get("MB_Confirmed_Button");
	public static String POD_Search_Button = ExcelData.get("POD_Search_Button");
	public static String POL_Search_Button = ExcelData.get("POL_Search_Button");
	public static String MB_Voyage_Search_Button1 = ExcelData.get("MB_Voyage_Search_Button1");
	public static String MB_Service_Search_Button1 = ExcelData.get("MB_Service_Search_Button1");
	public static String MB_Vessel_Service_label = ExcelData.get("MB_Vessel_Service_label");
	public static String MB_New_Booking_No = ExcelData.get("MB_New_Booking_No");
	public static String MB_Nominated_Book_No = ExcelData.get("MB_Nominated_Book_No");
	public static String MB_BookNum_To_Merge_Select = ExcelData.get("MB_BookNum_To_Merge_Select");
	public static String MB_Merge_To = ExcelData.get("MB_Merge_To");
	public static String MB_Nominate_Button = ExcelData.get("MB_Nominate_Button");














}
