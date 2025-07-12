package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Ecomm_Registration_Locators {

	//Ecom Registration
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Ecomm_Registration", "Reference_Name", Testcases.environmentName);

	public static String RegisterOption_Ecomm_Register = ExcelData.get("RegisterOption_Ecomm_Register");
	public static String Company_Name_Input_EcommRegister = ExcelData.get("Company_Name_Input_EcommRegister");
	public static String Country_Value_EComm_Register = ExcelData.get("Country_Value_EComm_Register");
	public static String Agency_Ecomm_Register = ExcelData.get("Agency_Ecomm_Register");
	public static String Address_Field_Ecomm_Register = ExcelData.get("Address_Field_Ecomm_Register");
	public static String City_Field_EComm_Register = ExcelData.get("City_Field_EComm_Register");
	public static String Postal_Code_Input_EComm_Register = ExcelData.get("Postal_Code_Input_EComm_Register");
	public static String Next_Button_EComm_Register = ExcelData.get("Next_Button_EComm_Register");
	public static String Email_ID_EComm_Register = ExcelData.get("Email_ID_EComm_Register");
	public static String Password_Field_EComm_Register = ExcelData.get("Password_Field_EComm_Register");
	public static String ConfirmPassword_EComm_Register = ExcelData.get("ConfirmPassword_EComm_Register");
	public static String FirstName_titlt_Ecomm_Register = ExcelData.get("FirstName_titlt_Ecomm_Register");
	public static String FirstName_Field_Ecomm_Register = ExcelData.get("FirstName_Field_Ecomm_Register");
	public static String LastName_Field_Ecomm_Register = ExcelData.get("LastName_Field_Ecomm_Register");
	public static String Country_Code_Input_Ecomm_Register = ExcelData.get("Country_Code_Input_Ecomm_Register");
	public static String Mobile_Code_Input_Ecomm_Register = ExcelData.get("Mobile_Code_Input_Ecomm_Register");
	public static String Time_Zone_Ecomm_Register = ExcelData.get("Time_Zone_Ecomm_Register");
	public static String Phone_Num_Field_Ecomm_Register = ExcelData.get("Phone_Num_Field_Ecomm_Register");
	public static String Mobile_Num_Field_Ecomm_Register = ExcelData.get("Mobile_Num_Field_Ecomm_Register");
	public static String Mandatory_Field_Ecomm_Register = ExcelData.get("Mandatory_Field_Ecomm_Register");


}
