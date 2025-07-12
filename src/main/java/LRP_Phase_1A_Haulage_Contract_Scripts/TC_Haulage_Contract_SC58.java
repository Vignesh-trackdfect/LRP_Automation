package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC58 extends Keywords{
	public void Haulage_Contract_SC58(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC58";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Global_Condition = Excel_data.get("Global_Condition");
		String global_Retrive_Type = Excel_data.get("global_Retrive_Type");
		String HC_Number = Excel_data.get("HC_Number");
		String Remove_Popup_Exp = Excel_data.get("Remove_Popup_Exp");
		String HC_Updated_Popup = Excel_data.get("HC_Updated_Popup");







		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);

		moduleNavigate(driver, Haulage_Contract_Module_Name);

		Step_End(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the global search option which is available in the tool bar.", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(2, "Click on the global search option which is available in the tool bar.", test, test1);
		Step_Start(3, "Check whether the system opens the contract details search window.         ", test, test1);
		Step_Start(4, "Enter the saved hlg contract number in the contract number search field.        .", test, test1);
		Step_Start(5, "Click on the search button.     .", test, test1);
		Step_Start(6, "System will show cotract details based on the Contarct number .", test, test1);
		Step_Start(7, "Double click the Contract detials.          .", test, test1);

		globalValueSearchWindow(driver, Global_Condition,global_Retrive_Type, HC_Number, "", "", "", "");
		Step_End(3, "Check whether the system opens the contract details search window.         ", test, test1);
		Step_End(4, "Enter the saved hlg contract number in the contract number search field.        .", test, test1);
		Step_End(5, "Click on the search button.     .", test, test1);
		Step_End(6, "System will show cotract details based on the Contarct number .", test, test1);
		Step_End(7, "Double click the Contract detials.          .", test, test1);

		Step_Start(8, ".Double click the Existing record", test, test1);
		waitForElement(driver, HC_show_All_Radio_Button);
		click(driver, HC_show_All_Radio_Button);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, HC_Add_Gird_Table);
		click(driver, HC_Add_Gird_Table);
		Step_End(8, ".Double click the Existing record", test, test1);


		Step_Start(9, "Click the Remove button.", test, test1);
		waitForElement(driver, HC_Remove_Button);
		click(driver, HC_Remove_Button);
		Step_End(9, "Click the Remove button.", test, test1);

		waitForPopup(driver, popup_Message, Remove_Popup_Exp);

		String Remove_Popup_Act =getText(driver, popup_Message);

		if(Remove_Popup_Exp.equals(Remove_Popup_Act)) {

			System.out.println("Matched || Expected Result is : "+ Remove_Popup_Exp + " Actual Result is : "+ Remove_Popup_Act);
			Extent_pass_New(driver, "Matched || Expected Result is : "+ Remove_Popup_Exp + " Actual Result is : "+ Remove_Popup_Act, test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

		}else {
			System.out.println("Not Matched || Expected Result is : "+ Remove_Popup_Exp + " Actual Result is : "+ Remove_Popup_Act);
			Extent_fail(driver, "Not Matched || Expected Result is : "+ Remove_Popup_Exp + " Actual Result is : "+ Remove_Popup_Act, test, test1);
		}

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, HC_Updated_Popup);
		String HC_Updated_Popup_Act =getText(driver, popup_Message);

		if(HC_Updated_Popup.equals(HC_Updated_Popup_Act)) {

			System.out.println("Matched || Expected Result is : "+ HC_Updated_Popup + " Actual Result is : "+ HC_Updated_Popup_Act);
			Extent_pass_New(driver, "Matched || Expected Result is : "+ HC_Updated_Popup + " Actual Result is : "+ HC_Updated_Popup_Act, test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}else {
			System.out.println("Not Matched || Expected Result is : "+ HC_Updated_Popup + " Actual Result is : "+ HC_Updated_Popup_Act);
			Extent_fail(driver, "Not Matched || Expected Result is : "+ HC_Updated_Popup + " Actual Result is : "+ HC_Updated_Popup_Act, test, test1);
		}
		Extent_completed(testcase_Name, test, test1);

	}

}
