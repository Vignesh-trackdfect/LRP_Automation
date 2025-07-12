package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC007 extends Keywords {

	public void CRO_SC007(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC007";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String condition_Filter = Excel_data.get("condition_Filter");
		String terminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String CRO_Popup_Exp = Excel_data.get("CRO_Popup_Exp");
		String From_Date = Excel_data.get("From_Date");
		String To_Date = Excel_data.get("To_Date");
		String Global_Condition = Excel_data.get("Global_Condition");
		String Customer_Code_Value = Excel_data.get("Customer_Code_Value");
		String Customer_Code_Filter = Excel_data.get("Customer_Code_Filter");
		String CRO_Updated_Popup = Excel_data.get("CRO_Updated_Popup");
		String Quantity_Input = Excel_data.get("Quantity_Input");

		
		
		

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		//	Switch the Profile
		SwitchProfile(driver, agencyUser);


		//		Booking module

		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);

	
		//	Create CRO


		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		

		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);

		if(!releaseDepTerminal.equals("")) {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, releaseDepTerminal);
		}else {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, acc_term_value);
		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		String CRO_Popup_Act = getText(driver, Popup_Message);
		System.out.println(CRO_Popup_Act);
		if(CRO_Popup_Exp.equals(CRO_Popup_Act)) {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_pass_New(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}else {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_fail(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}
		
		Step_Start(1, ".Click edit button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
	   click(driver, Edit_Button_toolBar);
		
		Step_End(1, ".Click edit button", test, test1);

	         
		Step_Start(2, "Change the date of valid from date", test, test1);
		
		if(!From_Date.equals("")) {
		waitForElement(driver, Valid_From_CRO);
         selectDatePicker(driver, Valid_From_CRO, From_Date);
         }
         Step_End(2, "Change the date of valid from date", test, test1);
         
         Step_Start(3, "Change the date of Valid Upto date", test, test1);
		
		if(!To_Date.equals("")) {
         waitForElement(driver, Valid_To_CRO);
         selectDatePicker(driver, Valid_To_CRO, To_Date);
	
		}
		
		Step_End(3, "Change the date of Valid Upto date", test, test1);
		Step_Start(7, "Change the Customer details", test, test1);
		Step_Start(8, "Double-click the container details", test, test1);

		
		if(!Customer_Code_Value.equals("")) {
		
		waitForElement(driver, Customer_Details_Search_Button_CRO);
		click(driver, Customer_Details_Search_Button_CRO);
		
		globalValueSearchWindow(driver, Global_Condition, Customer_Code_Filter, Customer_Code_Value, "", "", "", "");
		
		}
		Step_End(8, "Double-click the container details", test, test1);

		Step_End(7, "Change the Customer details", test, test1);

		Step_Start(9, "Add the container quantity", test, test1);

		
		scrollBottom(driver);
		waitForElement(driver, Quantity_TF_CRO);
		sendKeys(driver, Quantity_TF_CRO, Quantity_Input);
		waitForElement(driver, Add_Button_CRO);
		click(driver, Add_Button_CRO);
		scrollTop(driver);
		Step_End(9, "Add the container quantity", test, test1);

		Step_Start(10, "Click Save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(10, "Click Save button", test, test1);

		Step_Start(11, "Validate 'CRO is updated' message is shown", test, test1);

		String CRO_Updated_Act = getText(driver, Popup_Message);
		System.out.println(CRO_Updated_Act);
		if(CRO_Updated_Popup.equals(CRO_Updated_Act)) {
			System.out.println("Matched || Expected Popup : "+CRO_Updated_Popup+ " || Actual Popup :" +CRO_Updated_Act);
			Extent_pass_New(driver, "Matched || Expected Popup : "+CRO_Updated_Popup+ " || Actual Popup :" +CRO_Updated_Act, test, test1);
		}else {
			System.out.println("Matched || Expected Popup : "+CRO_Updated_Popup+ " || Actual Popup :" +CRO_Updated_Act);
			Extent_fail(driver, "Matched || Expected Popup : "+CRO_Updated_Popup+ " || Actual Popup :" +CRO_Updated_Act, test, test1);
		}
		
		Step_End(11, "Validate 'CRO is updated' message is shown", test, test1);

		
		Extent_completed(testCaseName, test, test1);
	}

}
