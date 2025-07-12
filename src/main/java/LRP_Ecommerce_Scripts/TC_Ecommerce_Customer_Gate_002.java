package LRP_Ecommerce_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Customer_Gate_002 extends Keywords {

	public void Ecommerce_Customer_Gate_002(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Customer_Gate_002";

		
		

		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String Filter_Headers = Excel_data.get("Filter_Headers");
		String User_Email = Excel_data.get("User_Email");
		String Agency_Gate = Excel_data.get("Agency_Gate");
		String User_Code = Excel_data.get("User_Code");
		String SystemCode_option = Excel_data.get("SystemCode_option");
		String SystemCode_Condition = Excel_data.get("SystemCode_Condition");
		String SystemCode = Excel_data.get("SystemCode");
		String Expected_PopupMessage = Excel_data.get("Expected_PopupMessage");
		String Moveto_Line_Popup = Excel_data.get("Moveto_Line_Popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		Step_Start(1, "Select the agency", test, test1);

		if (!AgencyName.equals("")) {
			SwitchProfile(driver, AgencyName);
		}

		Step_End(1, "Select the agency", test, test1);

		Step_Start(2, "Click Pending with Agency on the Ecom Customer Gate", test, test1);

		moduleNavigate(driver, Module_Name);

		formatLocatorClick(driver, ECG_GateSelection, Agency_Gate);

		Step_End(2, "Click Pending with Agency on the Ecom Customer Gate", test, test1);

		Step_Start(3, "Select the user record and double-click it", test, test1);

		reArrangeAG_GridColumnsNew(driver, AG_Grid_Columns_Button_DW, Filter_Headers);

		waitForElement(driver, ECG_GridFilter);
		click(driver, ECG_GridFilter);

		waitForElement(driver, ECG_UserEmail_Filter);
		sendKeys(driver, ECG_UserEmail_Filter, User_Email);

		if (!User_Code.isEmpty()) {

			waitForElement(driver, ECG_CustomerCode_Filter);
			sendKeys(driver, ECG_CustomerCode_Filter, User_Code);

		}

		if (isdisplayed(driver, ECG_Grid_data1)) {

			System.out.println(
					"Expected result is : The customer details should be available in the Pending with Customer|| Actual result is : The customer details are available in the Pending with Customer");
			Extent_pass_New(driver,
					"Expected result is : The customer details should be available in the Pending with Customer|| Actual result is : The customer details are available in the Pending with Customer",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : The customer details should be available in the Pending with Customer|| Actual result is : The customer details are not available in the Pending with Customer");
			Extent_fail(driver,
					"Expected result is : The customer details should be available in the Pending with Customer|| Actual result is : The customer details are not available in the Pending with Customer",
					test, test1);

		}

		waitForElement(driver, ECG_Grid_data1);
		click(driver, ECG_Grid_data1);
		doubleClick(driver, ECG_Grid_data1);

		Step_End(3, "Select the user record and double-click it", test, test1);

		Step_Start(4, "Add the customer under Pending with Agency", test, test1);

		Step_Start(5, "Select the customer code and click the Insert button", test, test1);

		waitForDisplay(driver, ECG_CustomerCode_Search);

		if (isdisplayed(driver, ECG_CustomerCode_Search)) {

			click(driver, ECG_CustomerCode_Search);

		} else {
			click(driver, ECG_NewCustomerCode_Search);

		}

		globalValueSearchWindow(driver, SystemCode_Condition, SystemCode_option, SystemCode, "", "", "", "");

		waitForDisplay(driver, ECG_CustomerCode_AddOk);

		if (isdisplayed(driver, ECG_CustomerCode_AddOk)) {

			click(driver, ECG_CustomerCode_AddOk);

		} else {
			click(driver, ECG_NewCustomerCode_Insert);

		}

		Step_End(4, "Add the customer under Pending with Agency", test, test1);

		Step_End(5, "Select the customer code and click the Insert button", test, test1);

		Step_Start(6, " The registered email will be linked to the customer code", test, test1);

		waitForPopup(driver, popup_Message, Expected_PopupMessage);
		String ActualPopup_Message = getText(driver, popup_Message);

		if (ActualPopup_Message.contains(Expected_PopupMessage)) {

			System.out.println("Confirmation popup is displayed || Expected popup : " + Expected_PopupMessage
					+ " || Actual popup : " + ActualPopup_Message);
			Extent_pass_New(driver, "Confirmation popup is displayed || Expected popup : " + Expected_PopupMessage
					+ " || Actual popup : " + ActualPopup_Message, test, test1);

		} else {

			System.out.println("Confirmation popup is not displayed || Expected popup : " + Expected_PopupMessage
					+ " || Actual popup : " + ActualPopup_Message);
			Extent_fail(driver, "Confirmation popup is not displayed || Expected popup : " + Expected_PopupMessage
					+ " || Actual popup : " + ActualPopup_Message, test, test1);

		}

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(6, " The registered email will be linked to the customer code", test, test1);

		Step_Start(7, "After clicking 'Yes' the record in the Ecom Customer Gate will move to ''Pending with Line''",
				test, test1);

		waitForPopup(driver, popup_Message, Moveto_Line_Popup);
		String linepopup = getText(driver, popup_Message);

		if (linepopup.equals(Moveto_Line_Popup)) {

			System.out.println("The selected gate is moved to Pending with line || Expected popup : "
					+ Moveto_Line_Popup + " || Actual result is : " + linepopup);
			Extent_pass_New(driver, "The selected gate is moved to Pending with line || Expected popup : "
					+ Moveto_Line_Popup + " || Actual result is : " + linepopup, test, test1);
		} else {

			System.out.println("The selected gate is not moved to Pending with line || Expected popup : "
					+ Moveto_Line_Popup + " || Actual result is : " + linepopup);
			Extent_fail(driver, "The selected gate is not moved to Pending with line || Expected popup : "
					+ Moveto_Line_Popup + " || Actual result is : " + linepopup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		ResetProfile(driver);

		moduleNavigate(driver, Module_Name);

		waitForElement(driver, Pendingwithline);
		jsClick(driver, Pendingwithline);

		reArrangeAG_GridColumnsNew(driver, AG_Grid_Columns_Button_DW, Filter_Headers);

		waitForElement(driver, ECG_GridFilter);
		click(driver, ECG_GridFilter);

		waitForElement(driver, ECG_UserEmail_Filter);
		sendKeys(driver, ECG_UserEmail_Filter, User_Email);

		if (!User_Code.isEmpty()) {

			waitForElement(driver, ECG_CustomerCode_Filter);
			sendKeys(driver, ECG_CustomerCode_Filter, User_Code);

		}

		if (isdisplayed(driver, ECG_Grid_data1)) {

			System.out.println(
					"Expected result is : The Customer gate should move to Pending with line || Actual result is : The Customer gate is moved to Pending with line");
			Extent_pass_New(driver,
					"Expected result is : The Customer gate should move to Pending with line || Actual result is : The Customer gate is moved to Pending with line",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : The Customer gate should move to Pending with line || Actual result is : The Customer gate is not moved to Pending with line");
			Extent_fail(driver,
					"Expected result is : The Customer gate should move to Pending with line || Actual result is : The Customer gate is not moved to Pending with line",
					test, test1);

		}

		Step_End(7, "After clicking 'Yes' the record in the Ecom Customer Gate will move to ''Pending with Line''",
				test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
