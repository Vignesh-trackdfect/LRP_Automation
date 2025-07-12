package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Ecom_notification_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Ecom_notification", "Reference_Name", Testcases.environmentName);

	public static String EN_By_Customer_Radio_Button = ExcelData.get("EN_By_Customer_Radio_Button");
	public static String EN_Customer_Add_Button = ExcelData.get("EN_Customer_Add_Button");
	public static String EN_Message_Input_Field = ExcelData.get("EN_Message_Input_Field");
	public static String EN_Send_Button = ExcelData.get("EN_Send_Button");
	public static String EN_Login_button = ExcelData.get("EN_Login_button");
	public static String EN_User_Name = ExcelData.get("EN_User_Name");
	public static String EN_Password = ExcelData.get("EN_Password");
	public static String EN_Login_Button = ExcelData.get("EN_Login_Button");
	public static String En_Nofification = ExcelData.get("En_Nofification");
	public static String EN_Nofitication_Option = ExcelData.get("EN_Nofitication_Option");
	public static String CustomerSelectOption_EN = ExcelData.get("CustomerSelectOption_EN");
	public static String Select_Customer_Option_EN = ExcelData.get("Select_Customer_Option_EN");
	public static String Customer_Add_button_EN = ExcelData.get("Customer_Add_button_EN");
	public static String Message_Input_Area_EN = ExcelData.get("Message_Input_Area_EN");
	public static String Send_Button_EN = ExcelData.get("Send_Button_EN");

	
	
}
