package LRP_Finance_Journal_Upload_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_Upload_JU04 extends Keywords{
	public void Journal_Upload_JU04(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String testcase_Name="TC_Journal_Upload_JU04";
		
		


		String Username = Excel_data.get("Username");                                                                        
		String Password = Excel_data.get("Password");                                                                         
		String module_Name = Excel_data.get("module_Name");                                         
		String Empty_Excel_File_Path = Excel_data.get("Excel_File_Path");                                                                        
		String Empty_Excel_Sheet_Name = Excel_data.get("Excel_Sheet_Name");                                                                         
		String ID_Value_Popup_Msg = Excel_data.get("ID_Value_Popup_Msg");
		
		Extent_Start(testcase_Name, test, test1);                                                                        
		navigateUrl(driver, url); 
		LRP_Login(driver, Username, Password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, module_Name);
		Step_Start(1, "Click new on toolbar", test, test1);
		newButton(driver);
		Step_End(1, "Click new on toolbar", test, test1);
		Step_Start(2, "Click Import Excel option popup window will appear", test, test1);
		waitForElement(driver, JU_Import_Excel_Button);
		click(driver, JU_Import_Excel_Button);
		Step_End(2, "Click Import Excel option popup window will appear", test, test1);
		Step_Start(3, "Click select Excel file option and popup window will appear , now select the excel file which is having the same id number in for multiple entries", test, test1);
		uploadfile_new(driver, JU_Select_Excel_File, Empty_Excel_File_Path);
		waitForElement(driver, JU_Select_Sheet_Option);
		click(driver, JU_Select_Sheet_Option);
		String sheet_Select=String.format(JU_Sheet_Select, Empty_Excel_Sheet_Name);
		waitForElement(driver, sheet_Select);
		click(driver, sheet_Select);
		waitForElement(driver, JU_Load_Sheet_Button);
		click(driver, JU_Load_Sheet_Button);
		waitForElement(driver, JU_Excel_AutoMap_Yes_Button);
		click(driver, JU_Excel_AutoMap_Yes_Button);
		waitForElement(driver, JU_Excel_Upload_Button);
		click(driver, JU_Excel_Upload_Button);
		Step_End(3, "Click select Excel file option and popup window will appear , now select the excel file which is having the same id number in for multiple entries", test, test1);
		Step_Start(4, "Showing the error message as 'Same Id does not exist'", test, test1);
		waitForPopup(driver, popup_Message,ID_Value_Popup_Msg);
		String actual_Popup_Msg = getText(driver, popup_Message);
		if (ID_Value_Popup_Msg.trim().equals(actual_Popup_Msg.trim())) {
			Extent_pass_New(driver, "Matched || Expected Popup Value is : " + ID_Value_Popup_Msg + " || Actual Journal Upload Popup Value is : " + actual_Popup_Msg, test,test1);
			System.out.println("Matched || Expected Popup Value is : " + ID_Value_Popup_Msg + " || Actual Journal Upload Popup Value is : " + actual_Popup_Msg);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Popup Value is : " + ID_Value_Popup_Msg + " || Actual Journal Upload Popup Value is : " + actual_Popup_Msg);
			Extent_fail(driver, "Not Matched || Expected Popup Value is : " + ID_Value_Popup_Msg + " || Actual Journal Upload Popup Value is : " + actual_Popup_Msg, test,test1);
		}
		Step_End(4, "Showing the error message as 'Same Id does not exist'", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}