package LRP_Finance_Journal_Upload_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_Upload_JU05 extends Keywords{
	public void Journal_Upload_JU05(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Journal_Upload_JU05";
		
		


		String Username = Excel_data.get("Username");                                                                        
		String Password = Excel_data.get("Password");                                                                         
		String module_Name = Excel_data.get("module_Name");                                         
		String Empty_Excel_File_Path = Excel_data.get("Excel_File_Path");                                                                        
		String Empty_Excel_Sheet_Name = Excel_data.get("Excel_Sheet_Name");                                                                         
		String Verified_Popup_Msg = Excel_data.get("Verified_Popup_Msg");                                         
		String Excel_Column_Header = Excel_data.get("Excel_Column_Header");  
		String JU_Column_Header = Excel_data.get("JU_Column_Header");                                                                        
		String Saved_Popup = Excel_data.get("Saved_Popup");                                                                         
		String globalSearchFilterOption_Journal = Excel_data.get("globalSearchFilterOption_Journal");                                         
		String dropdownCondition = Excel_data.get("dropdownCondition");  
		String Journal_Module = Excel_data.get("Journal_Module");
		String Global_Search_Option2_Journal = Excel_data.get("Global_Search_Option2_Journal");
		String Global_Search_Option3_Journal = Excel_data.get("Global_Search_Option3_Journal");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");

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
		Step_Start(3, "Click select Excel file optiom and popup window will appear and now select the excel file which is having different batch number and multiple entries", test, test1);
		uploadfile_new(driver, JU_Select_Excel_File, Empty_Excel_File_Path);
		waitForElement(driver, JU_Select_Sheet_Option);
		click(driver, JU_Select_Sheet_Option);
		String sheet_Select=String.format(JU_Sheet_Select, Empty_Excel_Sheet_Name);
		waitForElement(driver, sheet_Select);
		click(driver, sheet_Select);
		waitForElement(driver, JU_Load_Sheet_Button);
		click(driver, JU_Load_Sheet_Button);
		Step_End(3, "Click select Excel file optiom and popup window will appear and now select the excel file which is having different batch number and multiple entries", test, test1);
		Step_Start(4, "Excel file loaded in that screen ", test, test1);
		waitForElement(driver, JU_Excel_AutoMap_Yes_Button);
		click(driver, JU_Excel_AutoMap_Yes_Button);
		Step_End(4, "Excel file loaded in that screen ", test, test1);
		Step_Start(5, "Click Upload button", test, test1);
		waitForElement(driver, JU_Excel_Upload_Button);
		click(driver, JU_Excel_Upload_Button);
		Step_End(5, "Click Upload button", test, test1);
		Step_Start(6, "Journal Uploaded successfully in that journal upload screen", test, test1);
		waitForElement(driver, JU_Select_All_Check_Box);
		Step_End(6, "Journal Uploaded successfully in that journal upload screen", test, test1);
		click(driver, JU_Select_All_Check_Box);
		Step_Start(7, "It showing multiple batch number , select the batch number click verify button", test, test1);
		waitForElement(driver, JU_Verify_Button);
		click(driver, JU_Verify_Button);
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
		Step_End(7, "It showing multiple batch number , select the batch number click verify button", test, test1);
		Step_Start(8, "After verified click post button", test, test1);
		waitForElement(driver, JU_Post_Button);
		click(driver, JU_Post_Button);
		Step_End(8, "After verified click post button", test, test1);
		Step_Start(9, "Journal Posted Successfully", test, test1);
		waitForPopup(driver, popup_Message,Saved_Popup);
		String Actual_Popup_Msg = getText(driver, popup_Message);
		if (Saved_Popup.trim().equals(Actual_Popup_Msg.trim())) {
			Extent_pass_New(driver, "Matched || Expected Popup Value is : " + Saved_Popup + " || Actual Journal Upload Popup Value is : " + Actual_Popup_Msg, test,test1);
			System.out.println("Matched || Expected Popup Value is : " + Saved_Popup + " || Actual Journal Upload Popup Value is : " + Actual_Popup_Msg);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Popup Value is : " + Saved_Popup + " || Actual Journal Upload Popup Value is : " + Actual_Popup_Msg);
			Extent_fail(driver, "Not Matched || Expected Popup Value is : " + Saved_Popup + " || Actual Journal Upload Popup Value is : " + Actual_Popup_Msg, test,test1);
		}
		Step_End(9, "Journal Posted Successfully", test, test1);
		Step_Start(10, "Saved Journal entry can able to view in journal module screen", test, test1);
		waitForElement(driver, JU_Table_Value);
		List<Map<String, String>> table_Data = extractTableDataCountMissMatch(driver, JU_Table_Value);
		List<String> trans_Numbers = extractDataByHeader(driver, table_Data,JU_Column_Header);
		int reference_Size = trans_Numbers.size();
		List<String> column_Values = getExcelColumnDataByHeader(Empty_Excel_File_Path, Empty_Excel_Sheet_Name, Excel_Column_Header);
		int values_Size = getUniqueCountFromList(column_Values);
		if (values_Size==reference_Size) {
			Extent_pass_New(driver, "Matched || Expected Number Of Unique Original Ref Values from Excel : " + values_Size + " || Actual Journal Upload Columns Rows Size is : " + reference_Size, test,test1);
			System.out.println( "Matched || Expected Number Of Unique Original Ref Values from Excel : " + values_Size + " || Actual Journal Upload Columns Rows Size is : " + reference_Size);
		} else {
			System.out.println( "Not Matched || Expected Number Of Unique Original Ref Values from Excel : " + values_Size + " || Actual Journal Upload Columns Rows Size is : " + reference_Size);
			Extent_fail(driver, "Not Matched || Expected Number Of Unique Original Ref Values from Excel : " + values_Size + " || Actual Journal Upload Columns Rows Size is : " + reference_Size, test,test1);
		}
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, Journal_Module);
		for(int i=0;i<trans_Numbers.size();i++){
			waitForElement(driver, global_Search_Journal);
			click(driver, global_Search_Journal);
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Journal, trans_Numbers.get(i), Global_Search_Option2_Journal, searchValue2, Global_Search_Option3_Journal, searchValue3);
			waitForElement(driver, trans_Num_Field_Jnl);
			String actualTransNumber_1=getAttribute(driver, trans_Num_Field_Jnl, "value");
			if (trans_Numbers.get(i).equals(actualTransNumber_1)) {
				Extent_pass_New(driver, "Matched || Expected Trans Number Created from Journal Upload : " + trans_Numbers.get(i) + " || Actual Trans Number From Journal MOdule : " + actualTransNumber_1, test,test1);
				System.out.println("Matched || Expected Trans Number Created from Journal Upload : " + trans_Numbers.get(i) + " || Actual Trans Number From Journal MOdule : " + actualTransNumber_1);
			} else {
				System.out.println("Not Matched || Expected Trans Number Created from Journal Upload : " + trans_Numbers.get(i) + " || Actual Trans Number From Journal MOdule : " + actualTransNumber_1);
				Extent_fail(driver, "Not Matched || Expected Trans Number Created from Journal Upload : " + trans_Numbers.get(i) + " || Actual Trans Number From Journal MOdule : " + actualTransNumber_1, test,test1);
			}
		}
		Step_End(10, "Saved Journal entry can able to view in journal module screen", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}