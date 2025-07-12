package LRP_Finance_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_J07 extends Keywords {

	public void Journal_J07(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Journal_J07";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String journal_Module = Excel_data.get("journal_Module");
		String Global_Search_Option1_Journal = Excel_data.get("Global_Search_Option1_Journal");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String Doc_Type_Input = Excel_data.get("Doc_Type_Input");
		String description_TextArea_Input = Excel_data.get("description_TextArea_Input");
		String nominal_Name_Filter_Data = Excel_data.get("nominal_Name_Filter_Data");
		String exist_Popup_Expected = Excel_data.get("exist_Popup_Expected");
		String nominal_Search_Header = Excel_data.get("Nominal_Search_Header");
		String condition = Excel_data.get("Condition");
		String Global_Search_Option2_Journal = Excel_data.get("Global_Search_Option2_Journal");
		String Global_Search_Option3_Journal = Excel_data.get("Global_Search_Option3_Journal");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, journal_Module);
		Step_Start(1, "Retrieve the draft record using global search", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Dropdown_Condition, Global_Search_Option1_Journal, Doc_Type_Input, Global_Search_Option2_Journal, searchValue2, Global_Search_Option3_Journal, searchValue3);
		waitForElement(driver, originalRef_Textfield_Jnl);
		String existing_Ref_Num = getAttribute(driver, originalRef_Textfield_Jnl, "value");
		Step_End(1, "Retrieve the draft record using global search", test, test1);
		Step_Start(2, "Click new on toolbar", test, test1);
		newButton(driver);
		Step_End(2, "Click new on toolbar", test, test1);
		Step_Start(3, "Enter the values in original ref field which was already used in another transaction", test,test1);
		waitForElement(driver, originalRef_Textfield_Jnl);
		sendKeys(driver, originalRef_Textfield_Jnl, existing_Ref_Num);
		sendKeys(driver, description_TextArea_Jnl, description_TextArea_Input);
		click(driver, local_Desc_Texfield_Jnl);
		waitForElement(driver, account_Search_Icon);
		click(driver, account_Search_Icon);
		twoColumnSearchWindow(driver, nominal_Search_Header, condition, nominal_Name_Filter_Data);
		Step_End(3, "Enter the values in original ref field which was already used in another transaction", test, test1);
		Step_Start(4, "Click save on toolbar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(4, "Click save on toolbar", test, test1);
		Step_Start(5, "Validation message should be displayed as reference number already exists", test, test1);
		waitForPopup(driver, popup_Message,exist_Popup_Expected);
		String exist_Popup_Actual = getText(driver, popup_Message);
		if(exist_Popup_Actual.equals(exist_Popup_Expected)) {
			System.out.println("MATCHED || EXPECTED EXISTING Pop-up value is -> "+exist_Popup_Expected+" || ACTUAL EXISTING Pop-up value is -> "+exist_Popup_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED EXISTING Pop-up value is -> "+exist_Popup_Expected+" || ACTUAL EXISTING Pop-up value is -> "+exist_Popup_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED EXISTING Pop-up value is -> "+exist_Popup_Expected+" || ACTUAL EXISTING Pop-up value is -> "+exist_Popup_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED EXISTING Pop-up value is -> "+exist_Popup_Expected+" || ACTUAL EXISTING Pop-up value is -> "+exist_Popup_Actual, test, test1);
		}
		Step_End(5, "Validation message should be displayed as reference number already exists", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}