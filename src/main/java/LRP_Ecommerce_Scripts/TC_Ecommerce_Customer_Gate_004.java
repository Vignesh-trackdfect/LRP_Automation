package LRP_Ecommerce_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Customer_Gate_004 extends Keywords {

	public void Ecommerce_Customer_Gate_004(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Customer_Gate_004";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String Filter_Headers = Excel_data.get("Filter_Headers");
		String User_Email = Excel_data.get("User_Email");
		String Agency_Gate = Excel_data.get("Agency_Gate");
		String User_Code = Excel_data.get("User_Code");
		String Agency_Gate_2 = Excel_data.get("Agency_Gate_2");

		String SystemCode_option = Excel_data.get("SystemCode_option");
		String SystemCode_Condition = Excel_data.get("SystemCode_Condition");
		String SystemCode = Excel_data.get("SystemCode");
		String Expected_PopupMessage = Excel_data.get("Expected_PopupMessage");
		String Updated_Popup = Excel_data.get("Updated_Popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		Step_Start(1, "The system will navigate to the Customer Master Contacts tab", test, test1);

		if (!AgencyName.equals("")) {
			SwitchProfile(driver, AgencyName);
		}

		moduleNavigate(driver, Module_Name);

		formatLocatorClick(driver, ECG_GateSelection, Agency_Gate);

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
					"Expected result is : The customer details are available in the Pending with Line || Actual result is : The customer details are available in the Pending with Line");
			Extent_pass_New(driver,
					"Expected result is : The customer details are available in the Pending with Line || Actual result is : The customer details are available in the Pending with Line",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : The customer details are available in the Pending with Line || Actual result is : The customer details are not available in the Pending with Line");
			Extent_fail(driver,
					"Expected result is : The customer details are available in the Pending with Line || Actual result is : The customer details are not available in the Pending with Line",
					test, test1);

		}

		waitForElement(driver, ECG_Grid_FirstName);
		String Grid_firstname = getText(driver, ECG_Grid_FirstName);

		waitForElement(driver, ECG_Grid_LastName);
		String Grid_Lastname = getText(driver, ECG_Grid_LastName);

		String Fullname = Grid_firstname.concat(" ").concat(Grid_Lastname);

		waitForElement(driver, ECG_Grid_userMobile);
		String Grid_Mobilenum = getText(driver, ECG_Grid_userMobile);

		waitForElement(driver, ECG_Grid_userPhone);
		String Grid_phonenum = getText(driver, ECG_Grid_userPhone);

		waitForElement(driver, ECG_Grid_data1);
		click(driver, ECG_Grid_data1);
		doubleClick(driver, ECG_Grid_data1);

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

		waitForElement(driver, popup_Message);
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

		waitForElement(driver, CUM_SystemCode_Input);

		String Displayed_Systemcode = getAttribute(driver, CUM_SystemCode_Input, "value");

		if (Displayed_Systemcode.equals(SystemCode)) {

			System.out.println("Selected System code details are showing in the Customer master || Expected : "
					+ SystemCode + " || Actual : " + Displayed_Systemcode);
			Extent_pass_New(driver, "Selected System code details are showing in the Customer master || Expected : "
					+ SystemCode + " || Actual : " + Displayed_Systemcode, test, test1);

		} else {

			System.out.println("Selected System code details are not showing in the Customer master || Expected : "
					+ SystemCode + " || Actual : " + Displayed_Systemcode);
			Extent_fail(driver, "Selected System code details are not showing in the Customer master || Expected : "
					+ SystemCode + " || Actual : " + Displayed_Systemcode, test, test1);

		}

		scrollBottom(driver);

		Step_End(1, "The system will navigate to the Customer Master Contacts tab", test, test1);

		Step_Start(2, "The email will be assigned to the Customer Master Contacts tab", test, test1);

		waitForElement(driver, CUM_ContactName);

		String Displayed_ContactName = getAttribute(driver, CUM_ContactName, "value");
		String Displayed_Email = getAttribute(driver, CUM_Email, "value");

		String Displayed_PhoneNum1 = getAttribute(driver, CUM_PhoneNum1, "value");
		String Displayed_PhoneNum2 = getAttribute(driver, CUM_PhoneNum2, "value");
		String Displayed_PhoneNum3 = getAttribute(driver, CUM_PhoneNum3, "value");

		String Displayed_phoneNum = Displayed_PhoneNum1.concat("-").concat(Displayed_PhoneNum2).concat("-")
				.concat(Displayed_PhoneNum3);

		String Displayed_MobileNum1 = getAttribute(driver, CUM_MobileNum1, "value");
		String Displayed_MobileNum2 = getAttribute(driver, CUM_MobileNum2, "value");

		String Displayed_MobileNum = Displayed_MobileNum1.concat("-").concat(Displayed_MobileNum2);

		if (Displayed_ContactName.equals(Fullname)) {

			System.out.println("Expected Name was displayed in the Contacts Tab || Expected : " + Fullname
					+ " || Actual : " + Displayed_ContactName);
			Extent_pass_New(driver, "Expected Name was displayed in the Contacts Tab || Expected : " + Fullname
					+ " || Actual : " + Displayed_ContactName, test, test1);

		} else {

			System.out.println("Expected Name was not displayed in the Contacts Tab || Expected : " + Fullname
					+ " || Actual : " + Displayed_ContactName);
			Extent_fail(driver, "Expected Name was not displayed in the Contacts Tab || Expected : " + Fullname
					+ " || Actual : " + Displayed_ContactName, test, test1);

		}

		if (Displayed_Email.equals(User_Email)) {

			System.out.println("Expected Email was displayed in the Contacts Tab || Expected : " + User_Email
					+ " || Actual : " + Displayed_Email);
			Extent_pass_New(driver, "Expected Email was displayed in the Contacts Tab || Expected : " + User_Email
					+ " || Actual : " + Displayed_Email, test, test1);

		} else {

			System.out.println("Expected Email was not displayed in the Contacts Tab || Expected : " + User_Email
					+ " || Actual : " + Displayed_Email);
			Extent_fail(driver, "Expected Email was not displayed in the Contacts Tab || Expected : " + User_Email
					+ " || Actual : " + Displayed_Email, test, test1);

		}

		if (Displayed_Email.equals(User_Email)) {

			System.out.println("Expected Email was displayed in the Contacts Tab || Expected : " + User_Email
					+ " || Actual : " + Displayed_Email);
			Extent_pass_New(driver, "Expected Email was displayed in the Contacts Tab || Expected : " + User_Email
					+ " || Actual : " + Displayed_Email, test, test1);

		} else {

			System.out.println("Expected Email was not displayed in the Contacts Tab || Expected : " + User_Email
					+ " || Actual : " + Displayed_Email);
			Extent_fail(driver, "Expected Email was not displayed in the Contacts Tab || Expected : " + User_Email
					+ " || Actual : " + Displayed_Email, test, test1);

		}

		if (Displayed_phoneNum.equals(Grid_phonenum)) {

			System.out.println("Expected Email was displayed in the Contacts Tab || Expected : " + Displayed_phoneNum
					+ " || Actual : " + Grid_phonenum);
			Extent_pass_New(driver, "Expected Email was displayed in the Contacts Tab || Expected : " + Displayed_phoneNum
					+ " || Actual : " + Grid_phonenum, test, test1);

		} else {

			System.out.println("Expected Email was not displayed in the Contacts Tab || Expected : "
					+ Displayed_phoneNum + " || Actual : " + Grid_phonenum);
			Extent_fail(driver, "Expected Email was not displayed in the Contacts Tab || Expected : "
					+ Displayed_phoneNum + " || Actual : " + Grid_phonenum, test, test1);

		}

		if (Displayed_MobileNum.equals(Grid_Mobilenum)) {

			System.out.println("Expected Email was displayed in the Contacts Tab || Expected : " + Displayed_MobileNum
					+ " || Actual : " + Grid_Mobilenum);
			Extent_pass_New(driver, "Expected Email was displayed in the Contacts Tab || Expected : " + Displayed_MobileNum
					+ " || Actual : " + Grid_Mobilenum, test, test1);

		} else {

			System.out.println("Expected Email was not displayed in the Contacts Tab || Expected : "
					+ Displayed_MobileNum + " || Actual : " + Grid_Mobilenum);
			Extent_fail(driver, "Expected Email was not displayed in the Contacts Tab || Expected : "
					+ Displayed_MobileNum + " || Actual : " + Grid_Mobilenum, test, test1);

		}

		Step_End(2, "The email will be assigned to the Customer Master Contacts tab", test, test1);

		Step_Start(3, "Click 'Add' in the Contacts tab", test, test1);

		waitForElement(driver, CUM_Add_Contact);
		click(driver, CUM_Add_Contact);

		Step_End(3, "Click 'Add' in the Contacts tab", test, test1);

		Step_Start(4, "Save the Customer Master details", test, test1);

		scrollTop(driver);

		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message);

		String popupmessage = getText(driver, popup_Message);

		if (popupmessage.equals(Updated_Popup)) {

			System.out.println("Customer Master details are updated || Expected popup : " + Updated_Popup
					+ " || Actual popup : " + popupmessage);
			Extent_pass_New(driver, "Customer Master details are updated || Expected popup : " + Updated_Popup
					+ " || Actual popup : " + popupmessage, test, test1);

		} else {

			System.out.println("Customer Master details are not updated || Expected popup : " + Updated_Popup
					+ " || Actual popup : " + popupmessage);
			Extent_fail(driver, "Customer Master details are not updated || Expected popup : " + Updated_Popup
					+ " || Actual popup : " + popupmessage, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4, "Save the Customer Master details", test, test1);

		Step_Start(5, "The email will be activated based on the customer", test, test1);

		List<Map<String, String>> Tabledatas = getTableData(driver, CUM_TableHeader, CUM_TableRowvalue);

		List<String> EmailId = new ArrayList<String>();

		for (Map<String, String> rows : Tabledatas) {

			if (rows.containsKey("Email")) {

				EmailId.add(rows.get("Email"));
			}

		}

		if (EmailId.contains(User_Email)) {

			System.out.println(
					"Expected result is : the given customer details should be added in the grid || Actual result is : the given customer details are added in the grid");
			Extent_pass_New(driver,
					"Expected result is : the given customer details should be added in the grid || Actual result is : the given customer details are added in the grid",
					test, test1);

		} else {

			System.out.println(
					"Expected result is : the given customer details should be added in the grid || Actual result is : the given customer details are not added in the grid");
			Extent_fail(driver,
					"Expected result is : the given customer details should be added in the grid || Actual result is : the given customer details are not added in the grid",
					test, test1);

		}

		Step_End(5, "The email will be activated based on the customer", test, test1);

		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		formatLocatorClick(driver, ECG_GateSelection, Agency_Gate_2);

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
					"Expected result is : The customer details are available in the ACCEPTED || Actual result is : The customer details are available in the ACCEPTED");
			Extent_pass_New(driver,
					"Expected result is : The customer details are available in the ACCEPTED || Actual result is : The customer details are available in the ACCEPTED",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : The customer details are available in the ACCEPTED || Actual result is : The customer details are not available in the ACCEPTED");
			Extent_fail(driver,
					"Expected result is : The customer details are available in the ACCEPTED || Actual result is : The customer details are not available in the ACCEPTED",
					test, test1);

		}
		
		
		Extent_completed(testcase_Name, test, test1);
	}

}
