package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface PartBL_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "PartBL_Locators", "Reference_Name",
			Testcases.environmentName);

	public static String PBL_No_SearchBtn = ExcelData.get("PBL_No_SearchBtn");
	public static String PBL_No_Of_parts_Field = ExcelData.get("PBL_No_Of_parts_Field");
	public static String PBL_Create_Btn = ExcelData.get("PBL_Create_Btn");
	public static String PBL_Weight_Checkbox = ExcelData.get("PBL_Weight_Checkbox");
	public static String PBL_Move_All_Charges_Checkbox = ExcelData.get("PBL_Move_All_Charges_Checkbox");
	public static String PBL_Apply_Btn = ExcelData.get("PBL_Apply_Btn");
	public static String PBL_Weight_Field = ExcelData.get("PBL_Weight_Field");
	public static String PBL_Weight_Add_Btn = ExcelData.get("PBL_Weight_Add_Btn");
	public static String PBL_No_Dropdown = ExcelData.get("PBL_No_Dropdown");
	public static String PBL_No_Dropdown_Sel = ExcelData.get("PBL_No_Dropdown_Sel");
	public static String PBL_Equipment_Dropdown = ExcelData.get("PBL_Equipment_Dropdown");
	public static String PBL_Quantity_Field = ExcelData.get("PBL_Quantity_Field");

	public static String PBL_AddCargo = ExcelData.get("PBL_AddCargo");
	public static String PBL_BLDropdown = ExcelData.get("PBL_BLDropdown");
	public static String PBL_CommodityGrid_Headers = ExcelData.get("PBL_CommodityGrid_Headers");
	public static String PBL_CommodityGrid_Row = ExcelData.get("PBL_CommodityGrid_Row");
	public static String PBL_Commodity_Dropdown = ExcelData.get("PBL_Commodity_Dropdown");
	public static String PBL_PackageDropdown = ExcelData.get("PBL_PackageDropdown");
	public static String PBL_EqpIdDropdown = ExcelData.get("PBL_EqpIdDropdown");
	public static String PBL_ChildBL_ID = ExcelData.get("PBL_ChildBL_ID");
	public static String PBL_Movecharges_Package_radio = ExcelData.get("PBL_Movecharges_Package_radio");
	public static String PBL_PartBL_ID = ExcelData.get("PBL_PartBL_ID");
	public static String PBL_BLInput = ExcelData.get("PBL_BLInput");
	public static String PBL_Movecharges_enable = ExcelData.get("PBL_Movecharges_enable");
	public static String PBL_Container_Grid_Row = ExcelData.get("PBL_Container_Grid_Row");
	public static String PBL_CARGO_Remove_Btn = ExcelData.get("PBL_CARGO_Remove_Btn");
	public static String PBL_Container_Grid_Row_value = ExcelData.get("PBL_Container_Grid_Row_value");
	public static String PBL_Charges_Bttn = ExcelData.get("PBL_Charges_Bttn");

	public static String PBL_BLCharges_Table_Header = ExcelData.get("PBL_BLCharges_Table_Header");
	public static String PBL_BLCharges_Table_Row = ExcelData.get("PBL_BLCharges_Table_Row");
	public static String PBL_Table_Row = ExcelData.get("PBL_Table_Row");
	public static String PBL_Table_Header = ExcelData.get("PBL_Table_Header");
	public static String PBL_Move_All_charges_to_Master_Icon = ExcelData.get("PBL_Move_All_charges_to_Master_Icon");
	
	public static String PBL_MCN_ID = ExcelData.get("PBL_MCN_ID");
	public static String PBL_mcn_list = ExcelData.get("PBL_mcn_list");
	public static String PBL_Bol_navigate = ExcelData.get("PBL_Bol_navigate");
	public static String PBL_Package_radiobutton = ExcelData.get("PBL_Package_radiobutton");
	public static String PBL_Weight_radiobutton = ExcelData.get("PBL_Weight_radiobutton");
	
	

}
