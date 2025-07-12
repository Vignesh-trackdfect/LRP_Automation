package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Haulage_Expense_Report_locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Haulage_Expense_Report", "Reference_Name", Testcases.environmentName);
	public static String HER_new_button = ExcelData.get("HER_new_button");
	public static String HER_Approved = ExcelData.get("HER_Approved");
	public static String HER_Expense_Summary = ExcelData.get("HER_Expense_Summary");
	public static String HER_Sum_ref_Number = ExcelData.get("HER_Sum_ref_Number");
	public static String HER_Load_agency = ExcelData.get("HER_Load_agency");
	public static String HER_Discharge_Agency = ExcelData.get("HER_Discharge_Agency");
	public static String Haulgae_Expense_Summary = ExcelData.get("Haulgae_Expense_Summary");
	public static String EXP_firstrow = ExcelData.get("EXP_firstrow");
	public static String vendor_Gird_scroll = ExcelData.get("vendor_Gird_scroll");
	public static String vendor_Activity_ref_number = ExcelData.get("vendor_Activity_ref_number");
	public static String vendor_Approved_Expenses_tab = ExcelData.get("vendor_Approved_Expenses_tab");
	public static String Car_Reference_number_text = ExcelData.get("Car_Reference_number_text");
	public static String vendor_Approved_Expenses_tab_close = ExcelData.get("vendor_Approved_Expenses_tab_close");
	public static String Car_Expense_Report_scroll = ExcelData.get("Car_Expense_Report_scroll");
	public static String EXP_Condition_Filter = ExcelData.get("EXP_Condition_Filter");
	public static String EXP_RefNo_input = ExcelData.get("EXP_RefNo_input");
	public static String Hlg_Sum_Ref_No_ExpenseSummary = ExcelData.get("Hlg_Sum_Ref_No_ExpenseSummary");

//
//	public static String HER_new_button="HER_new_button>//div[text()='New']";
//	public static String HER_Approved="HER_Approved>//label[@id='HEX-HEX_HlgExpStslbl1']";
//	public static String HER_Expense_Summary="HER_Expense_Summary>//button[@id='HEX-HEX_btnExpenseSummary']";
//	public static String HER_Sum_ref_Number="HER_Sum_ref_Number>//div[@col-id='hlgsumrefno' and @role='gridcell']";
//    public static String HER_Load_agency="HER_Load_agency>//div[@col-id='loadagency' and @role='gridcell']";
//	public static String HER_Discharge_Agency ="HER_Discharge_Agency>//div[@col-id='disagency' and @role='gridcell']";
//	public static String Haulgae_Expense_Summary = "Haulgae_Expense_Summary>//button[@id='HEX-HEX_btnExpenseSummary']";
//	public static String EXP_firstrow = "Expenses summary first row>//div[@id='HEXEXPDLG-HEXEXPDLG_hlgExpSummary_tbl']//div[@row-id='0']";
//	public static String vendor_Gird_scroll = "vendor_Gird_scroll>(//div[@id='PCI-PCI_invoiceGrid_tbl']//div[@ref='eViewport'])[2]";
//	public static String vendor_Activity_ref_number = "vendor_Activity_ref_number>//div[@id='PCI-PCI_invoiceGrid_tbl']//div[@row-index='0']//div[@col-id='refNo']";
//	public static String vendor_Approved_Expenses_tab = "vendor_Approved_Expenses_tab>//div[@id='CRR_jTabbedPaneExpenses']//a[text()='Approved Expenses']";
//	public static String Car_Reference_number_text = "Car_Reference_number_text>//div[@id='CRR_treeTableEXPDB_tbl']//div[@row-index='0']//div[@col-id='tdrRefNo']";
//	public static String vendor_Approved_Expenses_tab_close = "vendor_Approved_Expenses_tab_close>//span[@id='CRR_expensedlg_title']//following::a[1]";
//	public static String Car_Expense_Report_scroll = "Car_Expense_Report_scroll>(//div[@id='CRR_treeTableEXPDB_tbl']//div[@ref='eViewport'])[2]";
//	public static String EXP_Condition_Filter = "EXP_Condition_Filter>//a[@id='HEXEXPDLG-HEXEXPDLG_hlgExpSummary_conditionFilter_id' and @title]"; //new
//	public static String EXP_RefNo_input = "EXP_RefNo_input>//input[@aria-label='Hlg Sum Ref No Filter Input']";  // new
	//old
//	public static String EXP_RefNo_input = "EXP_RefNo_input>//input[contains(@aria-label,'Sum Ref No Filter Input')]";  //old
	//public static String EXP_Condition_Filter = "EXP_Condition_Filter>(//a[@id='HEXEXPDLG-HEXEXPDLG_hlgExpSummary_conditionFilter_id'])[2]"; //old	
}
