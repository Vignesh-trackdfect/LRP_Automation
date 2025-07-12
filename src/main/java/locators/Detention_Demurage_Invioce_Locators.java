package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Detention_Demurage_Invioce_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Detention_Demurage_Invioce", "Reference_Name", Testcases.environmentName);

	public static String Corporate_Agency_SearchButton = ExcelData.get("Corporate_Agency_SearchButton");
	public static String EMS_From_Date_Textfield = ExcelData.get("EMS_From_Date_Textfield");
	public static String EMS_To_Date_Textfield = ExcelData.get("EMS_To_Date_Textfield");
	public static String Shipment_Dropdown = ExcelData.get("Shipment_Dropdown");
	public static String Report_Type_Dropdown = ExcelData.get("Report_Type_Dropdown");
	public static String Show_Button_Det_Dem_Invoice = ExcelData.get("Show_Button_Det_Dem_Invoice");
	public static String Select_All_Checkbox_InvoiceDetails = ExcelData.get("Select_All_Checkbox_InvoiceDetails");
	public static String Transaction_Textfield = ExcelData.get("Transaction_Textfield");
	public static String Detention_Demurrage_Invoice_Popup = ExcelData.get("Detention_Demurrage_Invoice_Popup");
	public static String Detention_Demurrage_Invoice_Popup_Ok_Button = ExcelData.get("Detention_Demurrage_Invoice_Popup_Ok_Button");
	public static String invoiceDetails_Grid_Filter_Button = ExcelData.get("invoiceDetails_Grid_Filter_Button");
	public static String BL_Number_Filter_Searchfield = ExcelData.get("BL_Number_Filter_Searchfield");
	public static String BL_Number_Gridcells = ExcelData.get("BL_Number_Gridcells");
	public static String Remove_Button = ExcelData.get("Remove_Button");
	public static String Detention_Demurrage_Invoice_Popup_Yes_Button = ExcelData.get("Detention_Demurrage_Invoice_Popup_Yes_Button");
	public static String Waiver_Ref_Number_Gridcell = ExcelData.get("Waiver_Ref_Number_Gridcell");

	
	
	
	
}
