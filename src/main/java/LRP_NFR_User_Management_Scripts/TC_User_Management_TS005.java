package LRP_NFR_User_Management_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_User_Management_TS005 extends Keywords {

	public void User_Management_TS005(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_User_Management_TS005";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Module = Excel_data.get("User_Management_Module");
		String InValid_User_ID = Excel_data.get("InValid_User_ID");
		String InValid_User_ID_Popup = Excel_data.get("InValid_User_ID_Popup");
		String Valid_User_Id_Value = Excel_data.get("Valid_User_Id_Value");
		String InValid_Password_Value = Excel_data.get("InValid_Password_Value");
		String Valid_Password = Excel_data.get("Valid_Password");
		String Incorrect_Confirm_Password_Popup = Excel_data.get("Incorrect_Confirm_Password_Popup");
		String InValid_FirstName_value = Excel_data.get("InValid_FirstName_value");
		String Invalid_FirstName_Popup = Excel_data.get("Invalid_FirstName_Popup");
		String Valid_First_Name = Excel_data.get("Valid_First_Name");
		String InValid_LastName_value = Excel_data.get("InValid_LastName_value");
		String Invalid_LastName_Popup = Excel_data.get("Invalid_LastName_Popup");
		String Valid_Last_Name = Excel_data.get("Valid_Last_Name");
		String InValid_Email_ID = Excel_data.get("InValid_Email_ID");
		String InValid_Email_ID_Popup = Excel_data.get("InValid_Email_ID_Popup");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Module);

		Step_Start(1, "Click on the new button in the search bar.", test, test1);

		newButton(driver);

		Step_End(1, "Click on the new button in the search bar.", test, test1);

		Step_Start(2,
				"If we Enter the Special characters in the User ID field and click the save button , a validation message of Special Characters are not allowed for User Id  should be displayed.",
				test, test1);

		waitForElement(driver, User_ID_Input_UM);
		sendKeys(driver, User_ID_Input_UM, InValid_User_ID);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, InValid_User_ID_Popup);

		String act_Popup = getText(driver, Popup_Message);

		if (InValid_User_ID_Popup.equals(act_Popup)) {
			System.out.println(
					"Matched || Expected popup : If we Enter the Special characters in the User ID field and click the save button , a validation message of Special Characters are not allowed for User Id  should be displayed : "
							+ InValid_User_ID_Popup
							+ "  ||  Actual popup : If we Enter the Special characters in the User ID field and click the save button , a validation message of Special Characters are not allowed for User Id  is displayed : "
							+ act_Popup);
			Extent_pass_New(driver,
					"Matched || Expected popup : If we Enter the Special characters in the User ID field and click the save button , a validation message of Special Characters are not allowed for User Id  should be displayed : "
							+ InValid_User_ID_Popup
							+ "  ||  Actual popup : If we Enter the Special characters in the User ID field and click the save button , a validation message of Special Characters are not allowed for User Id  is displayed : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup : If we Enter the Special characters in the User ID field and click the save button , a validation message of Special Characters are not allowed for User Id  should be displayed : "
							+ InValid_User_ID_Popup + "  ||  Actual popup is : " + act_Popup);
			Extent_fail(driver,
					"Not Matched || Expected popup : If we Enter the Special characters in the User ID field and click the save button , a validation message of Special Characters are not allowed for User Id  should be displayed : "
							+ InValid_User_ID_Popup + "  ||  Actual popup is : " + act_Popup,
					test, test1);
		}

		waitForElement(driver, User_ID_Input_UM);
		clear(driver, User_ID_Input_UM);
		sendKeys(driver, User_ID_Input_UM, Valid_User_Id_Value);
		Step_End(2,
				"If we Enter the Special characters in the User ID field and click the save button , a validation message of Special Characters are not allowed for User Id  should be displayed.",
				test, test1);

		Step_Start(3,
				"If we enter Alphabetical characters in the Password field and click the save button , validation message Should displayed",
				test, test1);
		waitForElement(driver, Password_Input_UM);
		sendKeys(driver, Password_Input_UM, InValid_Password_Value);
		List<String> PopupupsExp = validatePasswordErrors(InValid_Password_Value);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		for (String popups : PopupupsExp) {
			VerifyElementDisplayed(driver, popups);
		}
		elementnotvisible1(driver, Popup_Message);

		waitForElement(driver, Password_Input_UM);
		clear(driver, Password_Input_UM);
		sendKeys(driver, Password_Input_UM, Valid_Password);
		Step_End(3,
				"If we enter Alphabetical characters in the Password field and click the save button , validation message Should displayed",
				test, test1);

		Step_Start(4,
				"If we enter a password in the confirm password field which is different from the actual password , a validation message of 'Password and Confirmed Password are not matching' should be displayed",
				test, test1);
		waitForElement(driver, ConfirmPassword_Input_UM);
		sendKeys(driver, ConfirmPassword_Input_UM, InValid_Password_Value);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Incorrect_Confirm_Password_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (Incorrect_Confirm_Password_Popup.equals(act_Popup)) {
			System.out.println("'" + Incorrect_Confirm_Password_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched || Expected popup : If we enter a password in the confirm password field which is different from the actual password , a validation message of 'Password and Confirmed Password are not matching' should be displayed : "
							+ Incorrect_Confirm_Password_Popup
							+ "  ||  Actual popup :If we enter a password in the confirm password field which is different from the actual password , a validation message of 'Password and Confirmed Password are not matching' is displayed : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup : If we enter a password in the confirm password field which is different from the actual password , a validation message of 'Password and Confirmed Password are not matching' should be displayed : "
							+ Incorrect_Confirm_Password_Popup
							+ "  ||  Actual popup :If we enter a password in the confirm password field which is different from the actual password , a validation message of 'Password and Confirmed Password are not matching' is not displayed : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched || Expected popup : If we enter a password in the confirm password field which is different from the actual password , a validation message of 'Password and Confirmed Password are not matching' should be displayed : "
							+ Incorrect_Confirm_Password_Popup
							+ "  ||  Actual popup :If we enter a password in the confirm password field which is different from the actual password , a validation message of 'Password and Confirmed Password are not matching' is not displayed : "
							+ act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);

		waitForElement(driver, ConfirmPassword_Input_UM);
		clear(driver, ConfirmPassword_Input_UM);
		sendKeys(driver, ConfirmPassword_Input_UM, Valid_Password);
		Step_End(4,
				"If we enter a password in the confirm password field which is different from the actual password , a validation message of 'Password and Confirmed Password are not matching' should be displayed",
				test, test1);

		Step_Start(5,
				"If we enter a special characters in the first name click the save button , a validation message of Special Characters are not allowed for First Name should be displayed.",
				test, test1);
		waitForElement(driver, First_Name_Input_UM);
		sendKeys(driver, First_Name_Input_UM, InValid_FirstName_value);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Invalid_FirstName_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (Invalid_FirstName_Popup.equals(act_Popup)) {
			System.out.println("'" + Invalid_FirstName_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||  Expected popup :If we enter a special characters in the first name click the save button , a validation message of Special Characters are not allowed for First Name should be displayed : "
							+ Invalid_FirstName_Popup
							+ "  ||  Actual popup : If we enter a special characters in the first name click the save button , a validation message of Special Characters are not allowed for First Name is displayed. : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected popup :If we enter a special characters in the first name click the save button , a validation message of Special Characters are not allowed for First Name should be displayed. : "
							+ Invalid_FirstName_Popup + "  ||  Actual popup is : " + act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected popup : If we enter a special characters in the first name click the save button , a validation message of Special Characters are not allowed for First Name should be displayed.: "
							+ Invalid_FirstName_Popup + "  ||  Actual popup is : " + act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);

		waitForElement(driver, First_Name_Input_UM);
		clear(driver, First_Name_Input_UM);
		sendKeys(driver, First_Name_Input_UM, Valid_First_Name);
		Step_End(5,
				"If we enter a special characters in the first name click the save button , a validation message of Special Characters are not allowed for First Name should be displayed.",
				test, test1);

		Step_Start(6,
				"If we enter a special characters in the last name click the save button , a validation message of Special Characters are not allowed for last Name should be displayed.",
				test, test1);
		waitForElement(driver, LastName_Input_UM);
		sendKeys(driver, LastName_Input_UM, InValid_LastName_value);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Invalid_LastName_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (Invalid_LastName_Popup.equals(act_Popup)) {
			System.out.println("'" + Invalid_LastName_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||  Expected popup : If we enter a special characters in the last name click the save button , a validation message of Special Characters are not allowed for last Name should be displayed: "
							+ Invalid_LastName_Popup
							+ "  ||  Actual popup :If we enter a special characters in the last name click the save button , a validation message of Special Characters are not allowed for last Name is displayed: "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected popup : If we enter a special characters in the last name click the save button , a validation message of Special Characters are not allowed for last Name should be displayed : "
							+ Invalid_LastName_Popup + "  Actual popup is : " + act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected popup :If we enter a special characters in the last name click the save button , a validation message of Special Characters are not allowed for last Name should be displayed : "
							+ Invalid_LastName_Popup + "  Actual popup is : " + act_Popup,
					test, test1);
		}

		elementnotvisible1(driver, Popup_Message);

		waitForElement(driver, LastName_Input_UM);
		clear(driver, LastName_Input_UM);
		sendKeys(driver, LastName_Input_UM, Valid_Last_Name);
		Step_End(6,
				"If we enter a special characters in the last name click the save button , a validation message of Special Characters are not allowed for last Name should be displayed.",
				test, test1);

		Step_Start(7,
				"If we enter a Alphabetic value in the Email field and click the save button , a validation message of Invalid Email ID format should be displayed.",
				test, test1);
		waitForElement(driver, Email_Id_Input_UM);
		sendKeys(driver, Email_Id_Input_UM, InValid_Email_ID);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, InValid_Email_ID_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (InValid_Email_ID_Popup.equals(act_Popup)) {
			System.out.println("'" + InValid_Email_ID_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||Expected popup :If we enter a Alphabetic value in the Email field and click the save button , a validation message of Invalid Email ID format should be displayed: "
							+ InValid_Email_ID_Popup
							+ "  ||  Actual popup :If we enter a Alphabetic value in the Email field and click the save button , a validation message of Invalid Email ID format is displayed : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup : If we enter a Alphabetic value in the Email field and click the save button , a validation message of Invalid Email ID format should be displayed : "
							+ InValid_Email_ID_Popup + "  ||  Actual popup is : " + act_Popup);
			Extent_fail(driver,
					"Not Matched ||Expected popup :  If we enter a Alphabetic value in the Email field and click the save button , a validation message of Invalid Email ID format should be displayed : "
							+ InValid_Email_ID_Popup + "  ||  Actual popup is : " + act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, popup);

		Step_End(7,
				"If we enter a Alphabetic value in the Email field and click the save button , a validation message of Invalid Email ID format should be displayed.",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
