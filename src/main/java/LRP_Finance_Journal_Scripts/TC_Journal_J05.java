package LRP_Finance_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_J05 extends Keywords{
	public void Journal_J05(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Journal_J05";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String journal_Module = Excel_data.get("journal_Module");
		String Global_Search_Option1_Journal = Excel_data.get("Global_Search_Option1_Journal");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String Trans_Number_Input = Excel_data.get("Trans_Number_Input");
		String updated_Popup_Expected = Excel_data.get("updated_Popup_Expected");
		String confirm_Sts_Expected = Excel_data.get("confirm_Sts_Expected");
		String colour_After_Confirm_Expected = Excel_data.get("colour_After_Confirm_Expected").trim();
		String Global_Search_Option2_Journal = Excel_data.get("Global_Search_Option2_Journal");
		String Global_Search_Option3_Journal = Excel_data.get("Global_Search_Option3_Journal");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, journal_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_Start(1, "Retrieve the record to be edited", test, test1);
		globalValueSearchWindow(driver, Dropdown_Condition, Global_Search_Option1_Journal, Trans_Number_Input, Global_Search_Option2_Journal, searchValue2, Global_Search_Option3_Journal, searchValue3);
		Step_End(1, "Retrieve the record to be edited", test, test1);
		Step_Start(2, "Click edit on toolbar", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(2, "Click edit on toolbar", test, test1);
		Step_Start(3, "Click confirm button", test, test1);
		waitForElement(driver, confirm_Btn_Jnl);
		click(driver, confirm_Btn_Jnl);
		Step_End(3, "Click confirm button", test, test1);
		Step_Start(4, "Click save on toolbar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message,updated_Popup_Expected);
		String updated_Popup_Actual = getText(driver, popup_Message);
		if(updated_Popup_Actual.equals(updated_Popup_Expected)) {
			System.out.println("MATCHED ||EXPECTED UPDATED Pop-up value is : "+updated_Popup_Expected+ " || ACTUAL UPDATED Pop-up value is: "+updated_Popup_Actual);
			Extent_pass_New(driver, "MATCHED ||EXPECTED UPDATED Pop-up value is : "+updated_Popup_Expected+ " || ACTUAL UPDATED Pop-up value is: "+updated_Popup_Actual, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("NOT MATCHED ||EXPECTED UPDATED Pop-up value is : "+updated_Popup_Expected+ " || ACTUAL UPDATED Pop-up value is: "+updated_Popup_Actual);
			Extent_fail(driver, "NOT MATCHED ||EXPECTED UPDATED Pop-up value is : "+updated_Popup_Expected+ " || ACTUAL UPDATED Pop-up value is: "+updated_Popup_Actual, test, test1);
		}
		Step_End(4, "Click save on toolbar", test, test1);
		Step_Start(5, "Transaction status changed from draft to confirm", test, test1);
		waitForElement(driver, confirm_Btn_Status_Jnl);
		String confirm_Sts_Actual = getAttribute(driver, confirm_Btn_Status_Jnl, "class");
		if(confirm_Sts_Actual.contains(confirm_Sts_Expected)) {
			System.out.println("MATCHED || EXPECTED CONFIRM STATUS -> "+confirm_Sts_Expected+" || ACTUAL CONFIRM STATUS -> "+confirm_Sts_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED CONFIRM STATUS -> "+confirm_Sts_Expected+" || ACTUAL CONFIRM STATUS -> "+confirm_Sts_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED CONFIRM STATUS -> "+confirm_Sts_Expected+" || ACTUAL CONFIRM STATUS -> "+confirm_Sts_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED CONFIRM STATUS -> "+confirm_Sts_Expected+" || ACTUAL CONFIRM STATUS -> "+confirm_Sts_Actual, test, test1);
		}
		Step_End(5, "Transaction status changed from draft to confirm", test, test1);
		Step_Start(6, "Confirm transaction displayed as green color in trans number field", test, test1);
		waitForElement(driver, trans_Num_Field_Jnl);
		String colour_After_Confirm_ActualCode = getTextBackgroundColor(driver, trans_Num_Field_Jnl).trim();
		String colour_After_Confirm_Actual=getColorName(colour_After_Confirm_ActualCode);
		System.out.println("colour after delete : "+colour_After_Confirm_Actual);
		if(colour_After_Confirm_Actual.equals(colour_After_Confirm_Expected)) {
			System.out.println("MATCHED || EXPECTED COLOUR OF THE TRANS_NUM FIELD AFTER  CONFIRM  : "+ colour_After_Confirm_Expected+" || ACTUAL COLOUR OF THE TRANS_NUM FIELD  AFTER  CONFIRM  : "+colour_After_Confirm_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED COLOUR OF THE TRANS_NUM FIELD AFTER  CONFIRM  : : "+ colour_After_Confirm_Expected+" || ACTUAL COLOUR OF THE TRANS_NUM FIELD  AFTER  CONFIRM  : "+colour_After_Confirm_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED COLOUR OF THE TRANS_NUM FIELD AFTER  CONFIRM  : "+ colour_After_Confirm_Expected+" || ACTUAL COLOUR OF THE TRANS_NUM FIELD  AFTER  CONFIRM  : "+colour_After_Confirm_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED COLOUR OF THE TRANS_NUM FIELD AFTER  CONFIRM  : : "+ colour_After_Confirm_Expected+ "|| ACTUAL COLOUR OF THE TRANS_NUM FIELD  AFTER  CONFIRM  : "+colour_After_Confirm_Actual, test, test1);
		}
		Step_End(6, "Confirm transaction displayed as green color in trans number field", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}