package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Scale_In_Out_Reference{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Scale_In_Out_Reference",
			"Reference_Name", Testcases.environmentName);

	public static String ASearch_Input = ExcelData.get("ASearch_Input");
	public static String AScale_in_ref_input = ExcelData.get("AScale_in_ref_input");
	public static String AContract_no_input = ExcelData.get("AContract_no_input");
	public static String AFrom_Date = ExcelData.get("AFrom_Date");
	public static String AFree_Days_Input = ExcelData.get("AFree_Days_Input");
	public static String APer_Diem_Input = ExcelData.get("APer_Diem_Input");
	public static String AScale_in_pickup_charges = ExcelData.get("AScale_in_pickup_charges");
	public static String AHandling_Charges = ExcelData.get("AHandling_Charges");
	public static String AEquipment_Quantaty = ExcelData.get("AEquipment_Quantaty");
	public static String APre_Trip_Charges = ExcelData.get("APre_Trip_Charges");
	public static String APick_Up_Credit = ExcelData.get("APick_Up_Credit");
	public static String AEquipment_Type_add_button = ExcelData.get("AEquipment_Type_add_button");
	public static String ALocation_Add_Button = ExcelData.get("ALocation_Add_Button");
	public static String AGried_Add_Button = ExcelData.get("AGried_Add_Button");
	public static String Aselectbutton = ExcelData.get("Aselectbutton");
	public static String Asupplierdepot = ExcelData.get("Asupplierdepot");
	public static String ATo_Date = ExcelData.get("ATo_Date");
	public static String ARemarks_Input = ExcelData.get("ARemarks_Input");
	public static String AContractNumsearch = ExcelData.get("AContractNumsearch");
	public static String ASEarchSelect = ExcelData.get("ASEarchSelect");
	public static String Aslabbox = ExcelData.get("Aslabbox");
	public static String AslabboxADD = ExcelData.get("AslabboxADD");
	public static String AslabboxADDTodays = ExcelData.get("AslabboxADDTodays");
	public static String AslabboxADDperdiem = ExcelData.get("AslabboxADDperdiem");
	public static String AslabboxADDperdiemsecond = ExcelData.get("AslabboxADDperdiemsecond");
	public static String AslabboxADDperdiemseconddiem = ExcelData.get("AslabboxADDperdiemseconddiem");
	public static String Ainputcontractnum = ExcelData.get("Ainputcontractnum");
	public static String date_select = ExcelData.get("date_select");
	public static String Calender = ExcelData.get("Calender");
	public static String Slab_ChkBok = ExcelData.get("Slab_ChkBok");
	public static String OneWay_ChkBox = ExcelData.get("OneWay_ChkBox");
	public static String Equip_Prefix_ChkBox = ExcelData.get("Equip_Prefix_ChkBox");
	public static String Reference_Type_Field = ExcelData.get("Reference_Type_Field");
	public static String equipmenttypevalueenter = ExcelData.get("equipmenttypevalueenter");
	public static String service_selectbtn = ExcelData.get("service_selectbtn");
	public static String NorecordsOK = ExcelData.get("NorecordsOK");
	public static String Equipmenttype = ExcelData.get("Equipmenttype");
	public static String Equipmentquenty = ExcelData.get("Equipmentquenty");
	public static String Return_Ref_No = ExcelData.get("Return_Ref_No");
	public static String scrollhorizandal = ExcelData.get("scrollhorizandal");
	public static String Ahomepagesearch = ExcelData.get("Ahomepagesearch");
	public static String Asearchclickbtn = ExcelData.get("Asearchclickbtn");
	public static String Aselectbutton1 = ExcelData.get("Aselectbutton1");
	public static String Adoubleclickperdiem = ExcelData.get("Adoubleclickperdiem");
	public static String Aeditbuttoninside = ExcelData.get("Aeditbuttoninside");
	public static String Acancelbutton = ExcelData.get("Acancelbutton");
	public static String AINNSA = ExcelData.get("AINNSA");
	public static String ADropdone = ExcelData.get("ADropdone");
	public static String Aonewaybox = ExcelData.get("Aonewaybox");
	public static String AAddreturnlocation = ExcelData.get("AAddreturnlocation");
	public static String AResetButton = ExcelData.get("AResetButton");
	public static String reference_type = ExcelData.get("reference_type");
	public static String Gird_click = ExcelData.get("Gird_click");
	public static String A_To_Date = ExcelData.get("A_To_Date");
	public static String Gird_Click = ExcelData.get("Gird_Click");
	public static String Slab_ChkBox = ExcelData.get("Slab_ChkBox");


}
