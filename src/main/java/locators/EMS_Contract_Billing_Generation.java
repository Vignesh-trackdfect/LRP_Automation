package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface EMS_Contract_Billing_Generation{

	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "EMS_Contract_Billing_Generation", "Reference_Name", Testcases.environmentName);

	public static String Aaddbuttonforcontract = ExcelData.get("Aaddbuttonforcontract");
	public static String AMonthclick = ExcelData.get("AMonthclick");
	public static String AFebclick = ExcelData.get("AFebclick");
	public static String Ageneratebill = ExcelData.get("Ageneratebill");
	public static String AEMSLOGINPassword = ExcelData.get("AEMSLOGINPassword");
	public static String APasswordInput = ExcelData.get("APasswordInput");
	public static String APasswordInputOK = ExcelData.get("APasswordInputOK");
	public static String ABillrunmessageOK = ExcelData.get("ABillrunmessageOK");
	public static String AShowbills = ExcelData.get("AShowbills");
	public static String AGriedContractnumber = ExcelData.get("AGriedContractnumber");
	public static String Closebuttonx = ExcelData.get("Closebuttonx");
	public static String Closebuttonx1 = ExcelData.get("Closebuttonx1");
	public static String Monthdroupdwn = ExcelData.get("Monthdroupdwn");
	public static String yeardroupdwn = ExcelData.get("yeardroupdwn");
	public static String contractnumbersearch = ExcelData.get("contractnumbersearch");
	public static String Normalbilling = ExcelData.get("Normalbilling");
	public static String Invoicenumber = ExcelData.get("Invoicenumber");
	public static String Approved = ExcelData.get("Approved");
	public static String Girdtable = ExcelData.get("Girdtable");
	public static String Billgeneratingmsg = ExcelData.get("Billgeneratingmsg");
	public static String stock_report = ExcelData.get("stock_report");
	public static String location_searchicon = ExcelData.get("location_searchicon");
	public static String uploadFile = ExcelData.get("uploadFile");
	public static String lessor_add_icon42 = ExcelData.get("lessor_add_icon42");
	public static String lessor_inp_field42 = ExcelData.get("lessor_inp_field42");
	public static String lessee_add_icon42 = ExcelData.get("lessee_add_icon42");
	public static String lessee_inp_field42 = ExcelData.get("lessee_inp_field42");
	public static String leasekind_add_icon42 = ExcelData.get("leasekind_add_icon42");
	public static String leasekind_inp_field42 = ExcelData.get("leasekind_inp_field42");
	public static String supcon_add_icon42 = ExcelData.get("supcon_add_icon42");
	public static String supcon_inp_field42 = ExcelData.get("supcon_inp_field42");
	public static String cuscon_add_icon42 = ExcelData.get("cuscon_add_icon42");
	public static String cuscon_inp_field42 = ExcelData.get("cuscon_inp_field42");
	public static String sz_tp_special42 = ExcelData.get("sz_tp_special42");
	public static String sz_tp_standard42 = ExcelData.get("sz_tp_standard42");
	public static String service_searchicon42 = ExcelData.get("service_searchicon42");
	public static String service_searchfield42 = ExcelData.get("service_searchfield42");
	public static String countrysearchicon42 = ExcelData.get("countrysearchicon42");
	public static String Removebutton = ExcelData.get("Removebutton");
	public static String Removebuttoncoloumclick = ExcelData.get("Removebuttoncoloumclick");
	public static String REMOVEBUTTON = ExcelData.get("REMOVEBUTTON");
	public static String location_search = ExcelData.get("location_search");
	public static String table_Path = ExcelData.get("table_Path");
	public static String table_path = ExcelData.get("table_path");
	public static String month_click = ExcelData.get("month_click");
	public static String contract_se = ExcelData.get("contract_se");
	public static String ref_num = ExcelData.get("ref_num");
	public static String locationicon16 = ExcelData.get("locationicon16");
	public static String location_search16 = ExcelData.get("location_search16");
	public static String location_value16 = ExcelData.get("location_value16");
	public static String containsclick = ExcelData.get("containsclick");
	public static String Scroll_side = ExcelData.get("Scroll_side");
	public static String scaleout_input = ExcelData.get("scaleout_input");
	public static String AClosex = ExcelData.get("AClosex");
	public static String AClosex1 = ExcelData.get("AClosex1");
	public static String Asavepopup = ExcelData.get("Asavepopup");
	public static String RemovebuttoncoloumclickNO = ExcelData.get("RemovebuttoncoloumclickNO");
	public static String Removepop = ExcelData.get("Removepop");



	
	
	
	
	
	
}
