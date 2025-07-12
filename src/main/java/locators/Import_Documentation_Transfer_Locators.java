package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Import_Documentation_Transfer_Locators {

		
		Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Import_Documentation_Transfer", "Reference_Name", Testcases.environmentName);
		public static String Vessel_input_im_doc_tranfer = ExcelData.get("Vessel_input_im_doc_tranfer");
		public static String Service_filter_input_im_doc_tranfer = ExcelData.get("Service_filter_input_im_doc_tranfer");
		public static String Show_bls_im_doc_tranfer = ExcelData.get("Show_bls_im_doc_tranfer");
		public static String Filter_bl_im_doc_tranfer = ExcelData.get("Filter_bl_im_doc_tranfer");
		public static String delete_check_box_IDT = ExcelData.get("delete_check_box_IDT");
		public static String Delete_btn_IDT = ExcelData.get("Delete_btn_IDT");
	 
		public static String ListedBL_Number_Recon = ExcelData.get("ListedBL_Number_Recon");
		 
	
	 
	
	
	
	

}
