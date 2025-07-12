package LRP_Finance_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_J03 extends Keywords {

	public void Journal_J03(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Journal_J03";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String journal_Module = Excel_data.get("journal_Module");
		String Global_Search_Option1_Journal = Excel_data.get("Global_Search_Option1_Journal");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String Trans_Number_Input = Excel_data.get("Trans_Number_Input");
		String delete_Approval_Expected = Excel_data.get("delete_Approval_Expected").trim();
		String deleted_Msg_Expected = Excel_data.get("deleted_Msg_Expected").trim();
		String colour_After_Delete_Expected = Excel_data.get("colour_After_Delete_Expected").trim();
		String Global_Search_Option2_Journal = Excel_data.get("Global_Search_Option2_Journal");
		String Global_Search_Option3_Journal = Excel_data.get("Global_Search_Option3_Journal");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, journal_Module);
		Step_Start(1, "Retrieve the record that you are going to delete", test, test1);
		waitForElement(driver, global_Search_Journal);
		click(driver, global_Search_Journal);
		globalValueSearchWindow(driver, Dropdown_Condition, Global_Search_Option1_Journal, Trans_Number_Input, Global_Search_Option2_Journal, searchValue2, Global_Search_Option3_Journal, searchValue3);
		Step_End(1, "Retrieve the record that you are going to delete", test, test1);
		Step_Start(2, "Click delete on toolbar", test, test1);
		waitForElement(driver, delete_Btn_Jnl);
		click(driver, delete_Btn_Jnl);
		Step_End(2, "Click delete on toolbar", test, test1);
		Step_Start(3, "Popup message should be displayed", test, test1);
		waitForPopup(driver, popup_Message,delete_Approval_Expected);
		String delete_Approval_Actual = getText(driver, popup_Message).trim();
		if(delete_Approval_Actual.equals(delete_Approval_Expected)) {
			System.out.println("MATCHED || EXPECTED Pop-up value is AFTER CLICKING DELETE BUTTON : "+ delete_Approval_Expected+" || ACTUAL Pop-up value is AFTER CLICKING DELETE BUTTON : "+delete_Approval_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER CLICKING DELETE BUTTON : "+ delete_Approval_Expected+" || ACTUAL Pop-up value is AFTER CLICKING DELETE BUTTON : "+delete_Approval_Actual, test, test1);
			Step_Start(4, "Click yes to delete the transactions", test, test1);
			click(driver, popup_Message_Yes_Button);
			Step_End(4, "Click yes to delete the transactions", test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER CLICKING DELETE BUTTON : "+ delete_Approval_Expected+" || ACTUAL Pop-up value is AFTER CLICKING DELETE BUTTON : "+delete_Approval_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER CLICKING DELETE BUTTON : "+ delete_Approval_Expected+" || ACTUAL Pop-up value is AFTER CLICKING DELETE BUTTON : "+delete_Approval_Actual, test, test1);
		}
		Step_End(3, "Popup message should be displayed", test, test1);
		Step_Start(5, "Transaction should be deleted and show validation like journal deleted", test, test1);
		waitForPopup(driver, popup_Message,deleted_Msg_Expected);
		String deleted_Msg_Actual = getText(driver, popup_Message).trim();
		if(deleted_Msg_Actual.equals(deleted_Msg_Expected)) {
			System.out.println("MATCHED || EXPECTED Pop-up value is AFTER  DELETE  : "+ deleted_Msg_Expected+" || ACTUAL Pop-up value is AFTER  DELETE  : "+deleted_Msg_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER  DELETE  : "+ deleted_Msg_Expected+" || ACTUAL Pop-up value is AFTER  DELETE  : "+deleted_Msg_Actual, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER  DELETE  : "+ deleted_Msg_Expected+" || ACTUAL Pop-up value is AFTER  DELETE  : "+deleted_Msg_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER  DELETE  : "+ deleted_Msg_Expected+" || ACTUAL Pop-up value is AFTER  DELETE  : "+deleted_Msg_Actual, test, test1);
		}
		Step_End(5, "Transaction should be deleted and show validation like journal deleted", test, test1);
		Step_Start(6, "The deleted transaction should be highlighted in red color", test, test1);
		waitForElement(driver, trans_Num_Field_Jnl);
		String colour_After_Delete_Actual_Code = getTextBackgroundColor(driver, trans_Num_Field_Jnl);
		String colour_After_Delete_Actual=getColorName(colour_After_Delete_Actual_Code);		
		System.out.println("colour after delete : "+colour_After_Delete_Actual);
		if(colour_After_Delete_Actual.equals(colour_After_Delete_Expected)) {
			System.out.println("MATCHED || EXPECTED COLOUR OF THE TRANS_NUM FIELD AFTER  DELETE  : "+ colour_After_Delete_Expected+" || ACTUAL COLOUR OF THE TRANS_NUM FIELD  AFTER  DELETE  : "+colour_After_Delete_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED COLOUR OF THE TRANS_NUM FIELD AFTER  DELETE  : : "+ colour_After_Delete_Expected+" || ACTUAL COLOUR OF THE TRANS_NUM FIELD  AFTER  DELETE  : "+colour_After_Delete_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED COLOUR OF THE TRANS_NUM FIELD AFTER  DELETE  : "+ colour_After_Delete_Expected+" || ACTUAL COLOUR OF THE TRANS_NUM FIELD  AFTER  DELETE  : "+colour_After_Delete_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED COLOUR OF THE TRANS_NUM FIELD AFTER  DELETE  : : "+ colour_After_Delete_Expected+" || ACTUAL COLOUR OF THE TRANS_NUM FIELD  AFTER  DELETE  : "+colour_After_Delete_Actual, test, test1);
		}
		Step_End(6, "The deleted transaction should be highlighted in red color", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
