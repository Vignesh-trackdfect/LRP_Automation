package LRP_Finance_Journal_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Journal_J06 extends Keywords {
	public void Journal_J06(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Journal_J06";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String journal_Module = Excel_data.get("journal_Module");
		String Global_Search_Option1_Journal = Excel_data.get("Global_Search_Option1_Journal");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String Trans_Number_Input = Excel_data.get("Trans_Number_Input");
		String saveAs_Enable_Check_Expected = Excel_data.get("saveAs_Enable_Check_Expected");
		String Trans_Number_Text_Expected = Excel_data.get("Trans_Number_Text_Expected");
		String amount_Txtfield_Data = Excel_data.get("amount_Txtfield_Data");
		String draft_Sts_Expected = Excel_data.get("draft_Sts_Expected");
		String Global_Search_Option2_Journal = Excel_data.get("Global_Search_Option2_Journal");
		String Global_Search_Option3_Journal = Excel_data.get("Global_Search_Option3_Journal");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");
		String originalRef = Excel_data.get("OriginalRef");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, journal_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_Start(1, "Retrieve the confirmed transactions using global search", test, test1);
		globalValueSearchWindow(driver, Dropdown_Condition, Global_Search_Option1_Journal, Trans_Number_Input, Global_Search_Option2_Journal, searchValue2, Global_Search_Option3_Journal, searchValue3);
		Step_End(1, "Retrieve the confirmed transactions using global search", test, test1);
		Step_Start(2, "Click edit on toolbar", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(2, "Click edit on toolbar", test, test1);
		Step_Start(3, "Now save as button will enable", test, test1);
		waitForElement(driver, SaveAs_button_toolBar);
		String saveAs_Enable_Check_Actual = getAttribute(driver, SaveAs_button_toolBar, "aria-disabled");
		if(saveAs_Enable_Check_Actual.equalsIgnoreCase(saveAs_Enable_Check_Expected)) {
			System.out.println("MATCHED || EXPECTED SAVE_AS BUTTON ENABLITY -> "+saveAs_Enable_Check_Expected+ "||ACTUAL SAVE_AS BUTTON ENABLITY -> "+saveAs_Enable_Check_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED SAVE_AS BUTTON ENABLITY -> "+saveAs_Enable_Check_Expected+ "||ACTUAL SAVE_AS BUTTON ENABLITY -> "+saveAs_Enable_Check_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED SAVE_AS BUTTON ENABLITY -> "+saveAs_Enable_Check_Expected+ "||ACTUAL SAVE_AS BUTTON ENABLITY -> "+saveAs_Enable_Check_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED SAVE_AS BUTTON ENABLITY -> "+saveAs_Enable_Check_Expected+ "||ACTUAL SAVE_AS BUTTON ENABLITY -> "+saveAs_Enable_Check_Actual, test, test1);
		}
		Step_End(3, "Now save as button will enable", test, test1);
		Step_Start(4, "Click on save as button", test, test1);
		click(driver, SaveAs_button_toolBar);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		Step_End(4, "Click on save as button", test, test1);
		Step_Start(5, "Now the transaction becomes editable to the user and the transaction number field is displayed as New", test, test1);
		waitForElement(driver, trans_Num_Field_Jnl);
		String trans_Num_Text_Actual = getAttribute(driver, trans_Num_Field_Jnl, "value");
		if(trans_Num_Text_Actual.equals(Trans_Number_Text_Expected)) {
			System.out.println("MATCHED || EXPECTED TRANS_NUMBER VALUE AFTER CLICKING SAVE_AS BUTTON -> "+Trans_Number_Text_Expected+"|| ACTUAL TRANS_NUMBER VALUE AFTER CLICKING SAVE_AS BUTTON -> "+trans_Num_Text_Actual);
			Extent_pass_symbol(driver, "MATCHED || EXPECTED TRANS_NUMBER VALUE AFTER CLICKING SAVE_AS BUTTON -> "+Trans_Number_Text_Expected+"|| ACTUAL TRANS_NUMBER VALUE AFTER CLICKING SAVE_AS BUTTON -> "+trans_Num_Text_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED TRANS_NUMBER VALUE AFTER CLICKING SAVE_AS BUTTON -> "+Trans_Number_Text_Expected+"|| ACTUAL TRANS_NUMBER VALUE AFTER CLICKING SAVE_AS BUTTON -> "+trans_Num_Text_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED TRANS_NUMBER VALUE AFTER CLICKING SAVE_AS BUTTON -> "+Trans_Number_Text_Expected+"|| ACTUAL TRANS_NUMBER VALUE AFTER CLICKING SAVE_AS BUTTON -> "+trans_Num_Text_Actual, test, test1);
		}
		Step_End(5, "Now the transaction becomes editable to the user and the transaction number field is displayed as New", test, test1);
		Step_Start(6, "Now all the fields are editable and new DR and CR can be added", test, test1);
		// 1st row
		waitForElement(driver, journal_Table_First_Row_Fourth_Cell);
		doubleClick(driver, journal_Table_First_Row_Fourth_Cell);
		waitForElement(driver, originalRef_Textfield);
		clearAndType(driver, originalRef_Textfield, originalRef);
		waitForElement(driver, amount_Txtfield_Jnl);
		click(driver, amount_Txtfield_Jnl);
		clearAndType(driver, amount_Txtfield_Jnl, amount_Txtfield_Data);
		waitForElement(driver, description_TextArea_Jnl);
		click(driver, description_TextArea_Jnl);
		waitForElement(driver, plus_Btn_Jnl);
		click(driver, plus_Btn_Jnl);
		
		waitForDisplay(driver, ok_Btn_Jnl);
		if(isdisplayed(driver, ok_Btn_Jnl)) {
			click(driver, ok_Btn_Jnl);
			
		}
		
		// 2nd row
		waitForElement(driver, journal_Table_Second_Row_Fourth_Cell);
		doubleClick(driver, journal_Table_Second_Row_Fourth_Cell);
		waitForElement(driver, amount_Txtfield_Jnl);
		click(driver, amount_Txtfield_Jnl);
		clearAndType(driver, amount_Txtfield_Jnl, amount_Txtfield_Data);
		waitForElement(driver, description_TextArea_Jnl);
		click(driver, description_TextArea_Jnl);
		waitForElement(driver, plus_Btn_Jnl);
		click(driver, plus_Btn_Jnl);
		waitForDisplay(driver, ok_Btn_Jnl);
		if(isdisplayed(driver, ok_Btn_Jnl)) {
			click(driver, ok_Btn_Jnl);
			
		}
	
		Step_End(6, "Now all the fields are editable and new DR and CR can be added", test, test1);
		Step_Start(7, "After adding all the values, click save on toolbar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(7, "After adding all the values, click save on toolbar", test, test1);
		Step_Start(8, "Transaction should be saved in draft mode", test, test1);
		waitForElement(driver, draft_Btn_Status_Jnl);
		String draft_Status_Actual = getAttribute(driver, draft_Btn_Status_Jnl, "class");
		if(draft_Status_Actual.contains(draft_Sts_Expected)) {
			System.out.println("MATCHED || EXPECTED DRAFT STATUS -> "+draft_Sts_Expected+" || ACTUAL DRAFT STATUS -> "+draft_Status_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED DRAFT STATUS -> "+draft_Sts_Expected+" || ACTUAL DRAFT STATUS -> "+draft_Status_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED DRAFT STATUS -> "+draft_Sts_Expected+" || ACTUAL DRAFT STATUS -> "+draft_Status_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED DRAFT STATUS -> "+draft_Sts_Expected+" || ACTUAL DRAFT STATUS -> "+draft_Status_Actual, test, test1);
		}
		Step_End(8, "Transaction should be saved in draft mode", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}