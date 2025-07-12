package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Split_Booking_Locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Split_Booking", "Reference_Name", Testcases.environmentName);

	public static String SB_booking_search_checkbox = ExcelData.get("SB_booking_search_checkbox");
	public static String SB_bookingnio_search_btn = ExcelData.get("SB_bookingnio_search_btn");
	public static String SB_Show_btn = ExcelData.get("SB_Show_btn");

	

}
