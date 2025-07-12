package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Customer_Master_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Customer_Master", "Reference_Name", Testcases.environmentName);

//	public static String Username = ExcelData.get("Username");
//	public static String Password = ExcelData.get("password");
//	public static String Login = ExcelData.get("loginButton");
//	public static String SearchField = ExcelData.get("SearchField");
//	public static String Select_2 = ExcelData.get("Select_2");
	public static String confirm = ExcelData.get("Confirm");
	public static String new_Button = ExcelData.get("New_Button");
	public static String searchButton = ExcelData.get("SearchButton");
	public static String searchButton1 = ExcelData.get("SearchButton1");
	public static String searchCountry = ExcelData.get("SearchCountry");
	public static String countryDetails = ExcelData.get("CountryDetails");
	public static String userName1= ExcelData.get("CustomerName");
	public static String StateCode = ExcelData.get("StateCode");
	public static String CitySearch = ExcelData.get("CitySearch");
	public static String stateId = ExcelData.get("stateId");
	public static String SelectCity = ExcelData.get("SelectCity");
	public static String CityName = ExcelData.get("CityName");
	public static String EmailText = ExcelData.get("EmailText");
	public static String CustomerType = ExcelData.get("CustomerType");
	public static String searchDis = ExcelData.get("searchDis");
	public static String PhNo = ExcelData.get("PhNo");
	public static String Email1 = ExcelData.get("Email1");
	public static String tax1 = ExcelData.get("Tax1");
	public static String status1= ExcelData.get("status1");
	public static String CheckBox = ExcelData.get("CheckBox");
	public static String selectButton_CM = ExcelData.get("selectButton");
	public static String SaveButton = ExcelData.get("SaveButton");
	public static String popup_CM = ExcelData.get("popup1");
	public static String Ok_Button = ExcelData.get("Ok_Button");
	public static String DeleTe_Button = ExcelData.get("DeleTe_Button");
	public static String popup_CM1 = ExcelData.get("popup2");
	public static String Cancel_Yes = ExcelData.get("Cancel_Yes");
	public static String confirm_Ok = ExcelData.get("Confirm_Ok");
	public static String customerAddress = ExcelData.get("CustomerAddress");
	public static String ColorV = ExcelData.get("ColorV");
	public static String Billing = ExcelData.get("Billing");
	public static String checkbox1 = ExcelData.get("checkbox1");
	public static String SalesR = ExcelData.get("SalesR");
	public static String searchB = ExcelData.get("searchB");
	public static String searchD = ExcelData.get("searchD");
	public static String Add1 = ExcelData.get("Add1");
	public static String salesRep = ExcelData.get("salesRep");
	public static String customerNew = ExcelData.get("customerNew");
	public static String click_ok = ExcelData.get("click_ok");
	public static String LocName = ExcelData.get("LocName");
	public static String LocSearch = ExcelData.get("LocSearch");
	public static String LocOk = ExcelData.get("LocOk");
	public static String LocSel = ExcelData.get("LocSel");
	public static String ZipCheckbox1 = ExcelData.get("ZipCheckbox1");
	public static String FreeCheckbox1 = ExcelData.get("FreeCheckbox1");
	public static String SezNo = ExcelData.get("SezNo");
	public static String BondNo = ExcelData.get("BondNo");
	public static String BondDate = ExcelData.get("BondDate");
	public static String DateEnter = ExcelData.get("DateEnter");
	public static String Zipcode = ExcelData.get("Zipcode");
	public static String Customer_Code_Field = ExcelData.get("Customer_Code_Field");
	public static String already_Exist_Yes = ExcelData.get("already_Exist_Yes");
	public static String Customer_Status_DD = ExcelData.get("Customer_Status_DD");
	public static String Bill_Address1 = ExcelData.get("Bill_Address1");
	public static String CustomerName_CM = ExcelData.get("CustomerName_CM");
		
}
