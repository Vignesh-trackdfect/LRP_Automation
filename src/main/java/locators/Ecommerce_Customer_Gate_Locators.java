package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Ecommerce_Customer_Gate_Locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Ecommerce_Customer_Gate", "Reference_Name", Testcases.environmentName);

	public static String ECG_GateSelection = ExcelData.get("ECG_GateSelection");
	public static String ECG_GridFilter = ExcelData.get("ECG_GridFilter");
	public static String ECG_UserEmail_Filter = ExcelData.get("ECG_UserEmail_Filter");
	public static String ECG_CustomerCode_Filter = ExcelData.get("ECG_CustomerCode_Filter");
	public static String ECG_Grid_data1 = ExcelData.get("ECG_Grid_data1");
	public static String ECG_CustomerCode_Search = ExcelData.get("ECG_CustomerCode_Search");
	public static String ECG_CustomerCode_AddOk = ExcelData.get("ECG_CustomerCode_AddOk");
	public static String ECG_Grid_FirstName = ExcelData.get("ECG_Grid_FirstName");
	public static String ECG_Grid_userPhone = ExcelData.get("ECG_Grid_userPhone");
	public static String ECG_Grid_userMobile = ExcelData.get("ECG_Grid_userMobile");
	public static String ECG_Grid_LastName = ExcelData.get("ECG_Grid_LastName");
	public static String CUM_SystemCode_Input = ExcelData.get("CUM_SystemCode_Input");
	public static String CUM_ContactName = ExcelData.get("CUM_ContactName");
	public static String CUM_Email = ExcelData.get("CUM_Email");
	public static String CUM_PhoneNum1 = ExcelData.get("CUM_PhoneNum1");
	public static String CUM_PhoneNum2 = ExcelData.get("CUM_PhoneNum2");
	public static String CUM_PhoneNum3 = ExcelData.get("CUM_PhoneNum3");
	public static String CUM_MobileNum1 = ExcelData.get("CUM_MobileNum1");
	public static String CUM_MobileNum2 = ExcelData.get("CUM_MobileNum2");
	public static String CUM_Add_Contact = ExcelData.get("CUM_Add_Contact");
	public static String CUM_TableHeader = ExcelData.get("CUM_TableHeader");
	public static String CUM_TableRowvalue = ExcelData.get("CUM_TableRowvalue");
	public static String Outlook_VerficiationEmail = ExcelData.get("Outlook_VerficiationEmail");
	public static String Outlook_VerficiationLink = ExcelData.get("Outlook_VerficiationLink");
	public static String Confirmation_page = ExcelData.get("Confirmation_page");
	public static String Confirmation_Text = ExcelData.get("Confirmation_Text");
	public static String Gmail_VerficiationEmail = ExcelData.get("Gmail_VerficiationEmail");
	public static String Gmail_VerficiationLink = ExcelData.get("Gmail_VerficiationLink");
	public static String Outlook_EmailInput = ExcelData.get("Outlook_EmailInput");
	public static String Outlook_ClickNext = ExcelData.get("Outlook_ClickNext");
	public static String Outlook_PasswordInput = ExcelData.get("Outlook_PasswordInput");
	public static String Gmail_EmailInput = ExcelData.get("Gmail_EmailInput");
	public static String Gmail_ClickNext = ExcelData.get("Gmail_ClickNext");
	public static String Gmail_PasswordInput = ExcelData.get("Gmail_PasswordInput");
	public static String Pendingwithline = ExcelData.get("Pendingwithline");
	public static String ECG_CustomerGrid1 = ExcelData.get("ECG_CustomerGrid1");
	public static String Customer_Master_Gridscroll = ExcelData.get("Customer_Master_Gridscroll");
	public static String Customer_Master_Emailfield = ExcelData.get("Customer_Master_Emailfield");
	public static String ECG_Customercode1 = ExcelData.get("ECG_Customercode1");
	public static String ECG_NewCustomerCode_Search = ExcelData.get("ECG_NewCustomerCode_Search");
	public static String ECG_NewCustomerCode_Insert = ExcelData.get("ECG_NewCustomerCode_Insert");
	public static String Verification_Message_Text = ExcelData.get("Verification_Message_Text");

	
	
}
