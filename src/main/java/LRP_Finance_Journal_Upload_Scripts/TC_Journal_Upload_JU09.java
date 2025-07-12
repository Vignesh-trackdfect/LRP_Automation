package LRP_Finance_Journal_Upload_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_Upload_JU09 extends Keywords{

	public void Journal_Upload_JU09(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String testcase_Name="TC_Journal_Upload_JU09";
		
		


		String Username = Excel_data.get("Username");                                                                        
		String Password = Excel_data.get("Password");                                                                         
		String module_Name = Excel_data.get("module_Name");                                         
		String Empty_Excel_File_Path = Excel_data.get("Excel_File_Path");                                                                        
		String Empty_Excel_Sheet_Name = Excel_data.get("Excel_Sheet_Name");                                                                         
		String Verified_Popup_Msg = Excel_data.get("Verified_Popup_Msg");                                         
		String Not_Matched_Remarks = Excel_data.get("Not_Matched_Remarks");  

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
		Step_Start(3, "Click select Excel file option and popup window will appear and now select the excel file which is having same \"Reference Number", test, test1);
		uploadfile_new(driver, JU_Select_Excel_File, Empty_Excel_File_Path);
		waitForElement(driver, JU_Select_Sheet_Option);
		click(driver, JU_Select_Sheet_Option);
		String sheet_Select=String.format(JU_Sheet_Select, Empty_Excel_Sheet_Name);
		waitForElement(driver, sheet_Select);
		click(driver, sheet_Select);
		Step_End(3, "Click select Excel file option and popup window will appear and now select the excel file which is having same \"Reference Number", test, test1);
		Step_Start(4, "Excel file loaded in that screen", test, test1);
		waitForElement(driver, JU_Load_Sheet_Button);
		click(driver, JU_Load_Sheet_Button);
		waitForElement(driver, JU_Excel_AutoMap_Yes_Button);
		click(driver, JU_Excel_AutoMap_Yes_Button);
		Step_End(4, "Excel file loaded in that screen", test, test1);
		Step_Start(5, "Click Upload button", test, test1);
		waitForElement(driver, JU_Excel_Upload_Button);
		click(driver, JU_Excel_Upload_Button);
		Step_End(5, "Click Upload button", test, test1);
		Step_Start(6, "Journal Uploaded successfully in that journal upload screen", test, test1);
		waitForElement(driver, JU_Select_All_Check_Box);
		Step_End(6, "Journal Uploaded successfully in that journal upload screen", test, test1);
		Step_Start(7, "Select the Batch and click verify button", test, test1);
		click(driver, JU_Select_All_Check_Box);
		waitForElement(driver, JU_Verify_Button);
		click(driver, JU_Verify_Button);
		Step_End(7, "Select the Batch and click verify button", test, test1);
		Step_Start(8, "Now  Validation showing ' The sum of dr and cr should be same '", test, test1);
		waitForPopup(driver, popup_Message,Verified_Popup_Msg);
		String actual_Popup_Msg = getText(driver, popup_Message);
		if (Verified_Popup_Msg.trim().equals(actual_Popup_Msg.trim())) {
			Extent_pass_New(driver, "Matched || Expected Popup Value is : " + Verified_Popup_Msg + " || Actual Journal Upload Popup Value is : " + actual_Popup_Msg, test,test1);
			System.out.println("Matched || Expected Popup Value is : " + Verified_Popup_Msg + " || Actual Journal Upload Popup Value is : " + actual_Popup_Msg);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Popup Value is : " + Verified_Popup_Msg + " || Actual Journal Upload Popup Value is : " + actual_Popup_Msg);
			Extent_fail(driver, "Not Matched || Expected Popup Value is : " + Verified_Popup_Msg + " || Actual Journal Upload Popup Value is : " + actual_Popup_Msg, test,test1);
		}
		List<Map<String, String>> table_Data = extractTableDataDirect1(driver, JU_Table_Value);
		List<String> remarks_value = extractDataByHeader(driver, table_Data, "Remarks");
		for(int i=0;i<remarks_value.size();i++) {
			if (Not_Matched_Remarks.equals(Not_Matched_Remarks)) {
				Extent_pass_New(driver, "Matched || Expected Remark Value Should be : " + Not_Matched_Remarks + " || Actual Remarks in Journal Module : " + remarks_value.get(i), test,test1);
				System.out.println("Matched || Expected Remark Value Should be : " + Not_Matched_Remarks + " || Actual Remarks in Journal Module : " + remarks_value.get(i));
			} else {
				System.out.println("Not Matched || Expected Remark Value Should be : " + Not_Matched_Remarks + " || Actual Remarks in Journal Module : " + remarks_value.get(i));
				Extent_fail(driver,"Not Matched || Expected Remark Value Should be : " + Not_Matched_Remarks + " || Actual Remarks in Journal Module : " + remarks_value.get(i), test,test1);
			}
		}
		Step_End(8, "Now  Validation showing ' The sum of dr and cr should be same '", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}