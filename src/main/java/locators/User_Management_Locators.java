package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface User_Management_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "User_Management",
			"Reference_Name", Testcases.environmentName);
	
	public static String User_ID_Input_UM = ExcelData.get("User_ID_Input_UM");
	public static String Password_Input_UM = ExcelData.get("Password_Input_UM");
	public static String ConfirmPassword_Input_UM = ExcelData.get("ConfirmPassword_Input_UM");
	public static String First_Name_Input_UM = ExcelData.get("First_Name_Input_UM");
	public static String LastName_Input_UM = ExcelData.get("LastName_Input_UM");
	public static String Email_Id_Input_UM = ExcelData.get("Email_Id_Input_UM");
	public static String Country_Input_UM = ExcelData.get("Country_Input_UM");
	public static String Select_Country_Option_UM = ExcelData.get("Select_Country_Option_UM");
	public static String City_Input_UM = ExcelData.get("City_Input_UM");
	public static String Select_City_Option_UM = ExcelData.get("Select_City_Option_UM");
	public static String Select_CityList_UM = ExcelData.get("Select_CityList_UM");
	public static String CityValue_UM = ExcelData.get("CityValue_UM");
	public static String Address_Input_UM = ExcelData.get("Address_Input_UM");
	public static String TelePhone_Code_Input_UM = ExcelData.get("TelePhone_Code_Input_UM");
	public static String Telephone_Number_Input_UM = ExcelData.get("Telephone_Number_Input_UM");
	public static String PinCode_Input_UM = ExcelData.get("PinCode_Input_UM");
	public static String Fax_Number_Input_UM = ExcelData.get("Fax_Number_Input_UM");
	public static String Filter_click = ExcelData.get("Filter_click");
	public static String UserType_Input_UM = ExcelData.get("UserType_Input_UM");
	public static String Select_UserOption_UM = ExcelData.get("Select_UserOption_UM");
	public static String System_type_Input_UM = ExcelData.get("System_type_Input_UM");
	public static String Select_System_Option_UM = ExcelData.get("Select_System_Option_UM");
	public static String TimeZone_Input_UM = ExcelData.get("TimeZone_Input_UM");
	public static String Select_TimeZone_UM = ExcelData.get("Select_TimeZone_UM");
	public static String DateFormat_Input_UM = ExcelData.get("DateFormat_Input_UM");
	public static String Select_DateFormat_UM = ExcelData.get("Select_DateFormat_UM");
	public static String Carrier_Code_Input_UM = ExcelData.get("Carrier_Code_Input_UM");
	public static String Select_Carrier_Code_UM = ExcelData.get("Select_Carrier_Code_UM");
	public static String Login_Exp_Date_Input_UM = ExcelData.get("Login_Exp_Date_Input_UM");
	public static String Status_Input_UM = ExcelData.get("Status_Input_UM");
	public static String Select_Status_Option_UM = ExcelData.get("Select_Status_Option_UM");
	public static String Department_input_UM = ExcelData.get("Department_input_UM");
	public static String Select_Department_Option_UM = ExcelData.get("Select_Department_Option_UM");
	public static String Designation_Input_UM = ExcelData.get("Designation_Input_UM");
	public static String Select_Designation_UM = ExcelData.get("Select_Designation_UM");
	public static String UserCode_Input_UM = ExcelData.get("UserCode_Input_UM");
	public static String Branch_Input_UM = ExcelData.get("Branch_Input_UM");
	public static String Select_Branch_Value_UM = ExcelData.get("Select_Branch_Value_UM");
	public static String UserEdit_Button_UM = ExcelData.get("UserEdit_Button_UM");
	public static String Created_UserID_Value_UM = ExcelData.get("Created_UserID_Value_UM");
	public static String Active_User_Column_UM = ExcelData.get("Active_User_Column_UM");
	public static String Created_User_StatusColumn_UM = ExcelData.get("Created_User_StatusColumn_UM");
	public static String InValid_Password_Popup1_UM = ExcelData.get("InValid_Password_Popup1_UM");
	public static String InValid_Password_Popup2_UM = ExcelData.get("InValid_Password_Popup2_UM");
	public static String InValid_Password_Popup3_UM = ExcelData.get("InValid_Password_Popup3_UM");
	public static String InValid_Password_Popup4_UM = ExcelData.get("InValid_Password_Popup4_UM");
	public static String Status_Filter_Input_UM = ExcelData.get("Status_Filter_Input_UM");
	public static String Login_Name_Filter_Input_UM = ExcelData.get("Login_Name_Filter_Input_UM");

	
}
