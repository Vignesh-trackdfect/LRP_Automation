package LRP_NFR_User_Management_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_User_Management_TS004 extends Keywords {

	public void User_Management_TS004(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_User_Management_TS004";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Module = Excel_data.get("User_Management_Module");
		String User_Id_Value = Excel_data.get("User_Id_Value");
		String User_ID_Popup = Excel_data.get("User_ID_Popup");
		String Password_Input_Value = Excel_data.get("Password_Input_Value");
		String Password_Popup = Excel_data.get("Password_Popup");
		String Confirm_Password_Popup = Excel_data.get("Confirm_Password_Popup");
		String First_Name_Input_Value = Excel_data.get("First_Name_Input_Value");
		String First_Name_Popup = Excel_data.get("First_Name_Popup");
		String Last_Name_Input_Value = Excel_data.get("Last_Name_Input_Value");
		String Last_Name_Popup = Excel_data.get("Last_Name_Popup");
		String Email_ID_Value = Excel_data.get("Email_ID_Value");
		String Email_ID_Popup = Excel_data.get("Email_ID_Popup");
		String Select_User_Type_Input = Excel_data.get("Select_User_Type_Input");
		String Select_User_Type_Popup = Excel_data.get("Select_User_Type_Popup");
		String Select_User_Code = Excel_data.get("Select_User_Code");
		String Time_Zone_Popup = Excel_data.get("Time_Zone_Popup");
		String Select_Time_Zone = Excel_data.get("Select_Time_Zone");
		String User_Code_Popup = Excel_data.get("User_Code_Popup");
		String Select_Carrier_Code = Excel_data.get("Select_Carrier_Code");
		String Carrier_Code_Popup = Excel_data.get("Carrier_Code_Popup");
		String Select_Branch_Code = Excel_data.get("Select_Branch_Code");
		String Branch_Code_Popup = Excel_data.get("Branch_Code_Popup");
		String Address_Input_Value = Excel_data.get("Address_Input_Value");
		String Address_Popup = Excel_data.get("Address_Popup");
		String Select_Country_Value = Excel_data.get("Select_Country_Value");
		String Country_Select_Popup = Excel_data.get("Country_Select_Popup");
		String Select_City_Value = Excel_data.get("Select_City_Value");
		String City_Select_Popup = Excel_data.get("City_Select_Popup");
		String Postal_Code_Popup = Excel_data.get("Postal_Code_Popup");
		String Postal_Code_Input_Value = Excel_data.get("Postal_Code_Input_Value");
		String Telephone_Number_Popup = Excel_data.get("Telephone_Number_Popup");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Module);

		Step_Start(1, "Click on the New button in the above tool bar.", test, test1);

		newButton(driver);

		Step_End(1, "Click on the New button in the above tool bar.", test, test1);

		Step_Start(2,
				"If user left the user id field as blank and click on save button, the validation message  of 'Enter the user ID' should be shown",
				test, test1);
		waitForElement(driver, User_ID_Input_UM);

		// UserID popup Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, User_ID_Popup);
		String act_Popup = getText(driver, Popup_Message);
		if (User_ID_Popup.equals(act_Popup)) {
			System.out.println("'" + User_ID_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched || Expected popup : If user left the user id field as blank and click on save button, the validation message  of 'Enter the user ID' should be shown : "
							+ User_ID_Popup
							+ "  ||  Actual popup :If  user left the password field as blank click on save button the  popup message is  display : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup : If user left the user id field as blank and click on save button, the validation message  of 'Enter the user ID' should be shown : "
							+ User_ID_Popup
							+ "  ||  Actual popup :If  user left the password field as blank click on save button the  popup message is not display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||Expected popup :  If user left the user id field as blank and click on save button, the validation message  of 'Enter the user ID' should be shown : "
							+ User_ID_Popup
							+ "  ||  Actual popup :If  user left the password field as blank click on save button the  popup message is not display : "
							+ act_Popup,
					test, test1);
		}

		elementnotvisible1(driver, Popup_Message);
		Step_End(2,
				"If user left the user id field as blank and click on save button, the validation message  of 'Enter the user ID' should be shown",
				test, test1);

		Step_Start(3,
				"If  user left the password field as blank and click on save button, the validation message of 'Enter the Password' should be shown.",
				test, test1);

		waitForElement(driver, User_ID_Input_UM);
		sendKeys(driver, User_ID_Input_UM, User_Id_Value);

		// password popup Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Password_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (Password_Popup.equals(act_Popup)) {
			System.out.println("'" + Password_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched || Expected popup :If  user left the password field as blank click on save button Should be show as : "
							+ Password_Popup
							+ "  ||  Actual popup :If  user left the password field as blank click on save button the  popup message is  display : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected popup :If  user left the password field as blank click on save button Should be show as : "
							+ Password_Popup
							+ "  ||  Actual popup :If  user left the password field as blank click on save button the  popup message is not display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected popup :If  user left the password field as blank click on save button Should be show as : "
							+ Password_Popup
							+ "  ||  Actual popup :If  user left the password field as blank click on save button the  popup message is not display : "
							+ act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);
		Step_End(3,
				"If  user left the password field as blank and click on save button, the validation message of 'Enter the Password' should be shown.",
				test, test1);

		Step_Start(4,
				"If  user left the confirm password field as blank and click on save button, the validation message of 'Enter the confirm password' should be displayed.",
				test, test1);

		waitForElement(driver, Password_Input_UM);
		sendKeys(driver, Password_Input_UM, Password_Input_Value);

		// Confirm password popup Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Popup_Message);
		act_Popup = getText(driver, Popup_Message);
		if (Confirm_Password_Popup.equals(act_Popup)) {
			System.out.println("'" + Confirm_Password_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||  Expected popup :If  user left the confirm password field as blank click on save button Should be show as : "
							+ Confirm_Password_Popup
							+ "  ||  Actual popup :If  user left the confirm password field as blank click on save button the  popup message is  display : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected popup :If  user left the confirm password field as blank click on save button Should be show as : "
							+ Confirm_Password_Popup
							+ "  ||  Actual popup :If  user left the confirm password field as blank click on save button the  popup message is not display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected popup :If  user left the confirm password field as blank click on save button Should be show as : "
							+ Confirm_Password_Popup
							+ "  ||  Actual popup :If  user left the confirm password field as blank click on save button the  popup message is not display : "
							+ act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);
		Step_End(4,
				"If  user left the confirm password field as blank and click on save button, the validation message of 'Enter the confirm password' should be displayed.",
				test, test1);

		Step_Start(5,
				"If user left the firstname field as blank and click on save button, the validation message of 'Enter the FirstName' should be displayed.",
				test, test1);
		waitForElement(driver, ConfirmPassword_Input_UM);
		sendKeys(driver, ConfirmPassword_Input_UM, Password_Input_Value);

		// First Name popup Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Popup_Message);
		act_Popup = getText(driver, Popup_Message);
		if (First_Name_Popup.equals(act_Popup)) {
			System.out.println("'" + First_Name_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||  If user left the firstname field as blank and click on save button, the validation message of 'Enter the FirstName' should be displayed : "
							+ First_Name_Popup
							+ "  ||  Actual popup :If user left the firstname field as blank and click on save button the  popup message is not display : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  If user left the firstname field as blank and click on save button, the validation message of 'Enter the FirstName' should be displayed : "
							+ First_Name_Popup
							+ "  ||  Actual popup :If user left the firstname field as blank and click on save button the  popup message is not display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||  If user left the firstname field as blank and click on save button, the validation message of 'Enter the FirstName' should be displayed : "
							+ First_Name_Popup
							+ "  ||  Actual popup :If user left the firstname field as blank and click on save button the  popup message is not display : "
							+ act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);
		Step_End(5,
				"If user left the firstname field as blank and click on save button, the validation message of 'Enter the FirstName' should be displayed.",
				test, test1);

		Step_Start(6,
				"if user left the lastname field as blank and click on save button, the validation message of  'Enter the LastName' should be displayed.",
				test, test1);
		waitForElement(driver, First_Name_Input_UM);
		sendKeys(driver, First_Name_Input_UM, First_Name_Input_Value);

		// Last Name popup Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Last_Name_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (Last_Name_Popup.equals(act_Popup)) {
			System.out.println("'" + Last_Name_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||  Expected popup :If user left the lastname field as blank and click on save button, the validation message of  'Enter the LastName' should be displayed : "
							+ Last_Name_Popup
							+ "  ||  Actual popup :if user left the lastname field as blank click on save button the  popup message is  display : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected popup :If user left the lastname field as blank and click on save button, the validation message of  'Enter the LastName' should be displayed : "
							+ Last_Name_Popup
							+ "  ||  Actual popup :if user left the lastname field as blank click on save button the  popup message is not display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected popup :If user left the lastname field as blank and click on save button, the validation message of  'Enter the LastName' should be displayed : "
							+ Last_Name_Popup
							+ "  ||  Actual popup :if user left the lastname field as blank click on save button the  popup message is not display : "
							+ act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);
		Step_End(6,
				"if user left the lastname field as blank and click on save button, the validation message of  'Enter the LastName' should be displayed.",
				test, test1);

		Step_Start(7,
				"If user left the Email ID field as blank and click on save button, the validation message of  'Enter the Email ID' should be displayed.",
				test, test1);
		waitForElement(driver, LastName_Input_UM);
		sendKeys(driver, LastName_Input_UM, Last_Name_Input_Value);

		// Email ID popup Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

        waitForPopup(driver, Popup_Message, Email_ID_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (Email_ID_Popup.equals(act_Popup)) {
			System.out.println("'" + Email_ID_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||  Expected popup :If user left the Email ID field as blank and click on save button Should be show as : "
							+ Email_ID_Popup
							+ "  ||  Actual popup :If user left the Email ID field as blank and click on save button the  popup message is not display : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected popup :If user left the Email ID field as blank and click on save button Should be show as : "
							+ Email_ID_Popup
							+ "  ||  Actual popup :If user left the Email ID field as blank and click on save button the  popup message is not display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected popup :If user left the Email ID field as blank and click on save button Should be show as : "
							+ Email_ID_Popup
							+ "  ||  Actual popup :If user left the Email ID field as blank and click on save button the  popup message is not display : "
							+ act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);
		Step_End(7,
				"If user left the Email ID field as blank and click on save button, the validation message of  'Enter the Email ID' should be displayed.",
				test, test1);

		Step_Start(13,
				"if user left the usertype field as blank and click on save button, the validation message of 'Select the Usertype' should be displayed.",
				test, test1);
		waitForElement(driver, Email_Id_Input_UM);
		sendKeys(driver, Email_Id_Input_UM, Email_ID_Value);

		// User Type popup Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

        waitForPopup(driver, Popup_Message, Select_User_Type_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (Select_User_Type_Popup.equals(act_Popup)) {
			System.out.println("'" + Select_User_Type_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||  Expected popup :if user left the usertype field as blank and click on save button Should be show as : "
							+ Select_User_Type_Popup
							+ "  ||  Actual popup :if user left the usertype field as blank and click on save button the  popup message is  display : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected popup :if user left the usertype field as blank and click on save button Should be show as : "
							+ Select_User_Type_Popup
							+ "  ||  Actual popup :if user left the usertype field as blank and click on save button the  popup message is not display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected popup :if user left the usertype field as blank and click on save button Should be show as : "
							+ Select_User_Type_Popup
							+ "  ||  Actual popup :if user left the usertype field as blank and click on save button the  popup message is not display : "
							+ act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);
		Step_End(13,
				"if user left the usertype field as blank and click on save button, the validation message of 'Select the Usertype' should be displayed.",
				test, test1);

		Step_Start(17,
				"if user left the Time Zone field as blank and click on save action, the validation message of 'Select the preffered time zone' should be displayed.",
				test, test1);
		waitForElement(driver, UserType_Input_UM);
		click(driver, UserType_Input_UM);

		formatLocatorClick(driver, Select_UserOption_UM, Select_User_Type_Input);
		waitForElement(driver, UserType_Input_UM);

		boolean userCode = isdisplayed(driver, UserCode_Input_UM);
		boolean branchCode = isdisplayed(driver, Branch_Input_UM);

		// Time Zone popup Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Time_Zone_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (Time_Zone_Popup.equals(act_Popup)) {
			System.out.println("'" + Time_Zone_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||  Expected if user left the Time Zone field as blank and click on save action, the validation message of 'Select the preffered time zone' should be displayed: "
							+ Time_Zone_Popup
							+ "  ||  Actual popup :if user left the Time Zone field as blank and click on save action, the validation message of 'Select the preffered time zone is  display : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected if user left the Time Zone field as blank and click on save action, the validation message of 'Select the preffered time zone' should be displayed: "
							+ Time_Zone_Popup
							+ "  ||  Actual popup :if user left the Time Zone field as blank and click on save action, the validation message of 'Select the preffered time zone is not display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected if user left the Time Zone field as blank and click on save action, the validation message of 'Select the preffered time zone' should be displayed: "
							+ Time_Zone_Popup
							+ "  ||  Actual popup :if user left the Time Zone field as blank and click on save action, the validation message of 'Select the preffered time zone is not display : "
							+ act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);

		waitForElement(driver, TimeZone_Input_UM);
		click(driver, TimeZone_Input_UM);
		formatLocatorClick(driver, Select_TimeZone_UM, Select_Time_Zone);

		Step_End(17,
				"if user left the Time Zone field as blank and click on save action, the validation message of 'Select the preffered time zone' should be displayed.",
				test, test1);

		if (userCode) {
			Step_Start(14,
					"if user left the User Code field as blank and click on save button, the validation message of 'Select the User Code' should be displayed",
					test, test1);

			// User Code popup Validation
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, Popup_Message, User_Code_Popup);
			act_Popup = getText(driver, Popup_Message);
			if (User_Code_Popup.equals(act_Popup)) {
				System.out.println("'" + User_Code_Popup + "' Popup Displayed ");
				Extent_pass_New(driver,
						"Matched ||  Expected popup :if user left the User Code field as blank and click on save button Should be show as : "
								+ User_Code_Popup
								+ "  ||  Actual popup :if user left the User Code field as blank and click on save button the  popup message is  display : "
								+ act_Popup,
						test, test1);
			} else {
				System.out.println(
						"Not Matched ||  Expected popup :if user left the User Code field as blank and click on save button Should be show as : "
								+ User_Code_Popup
								+ "  ||  Actual popup :if user left the User Code field as blank and click on save button the  popup message is not display : "
								+ act_Popup);
				Extent_fail(driver,
						"Not Matched ||  Expected popup :if user left the User Code field as blank and click on save button Should be show as : "
								+ User_Code_Popup
								+ "  ||  Actual popup :if user left the User Code field as blank and click on save button the  popup message is not display : "
								+ act_Popup,
						test, test1);
			}
			elementnotvisible1(driver, Popup_Message);

			click(driver, UserCode_Input_UM);
			
			formatLocatorClick(driver, DropDown_Select, Select_User_Code);

			Step_End(14,
					"if user left the User Code field as blank and click on save button, the validation message of 'Select the User Code' should be displayed",
					test, test1);

		}

		if (branchCode) {
			// Branch Code popup Validation
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, Popup_Message, Branch_Code_Popup);
			act_Popup = getText(driver, Popup_Message);
			if (Branch_Code_Popup.equals(act_Popup)) {
				System.out.println("'" + Branch_Code_Popup + "' Popup Displayed ");
				Extent_pass_New(driver,
						"Matched ||  Expected popup :if user left the User Code field as blank and click on save button Should be show as : "
								+ Branch_Code_Popup
								+ "  ||  Actual popup :if user left the User Code field as blank  and click on save button the  popup message is  display : "
								+ act_Popup,
						test, test1);
			} else {
				System.out.println(
						"Not Matched ||  Expected popup :if user left the User Code field as blank and click on save button Should be show as : "
								+ Branch_Code_Popup
								+ "  ||  Actual popup :if user left the User Code field as blank and click on save button the  popup message is not display : "
								+ act_Popup);
				Extent_fail(driver,
						"Not Matched ||  Expected popup :if user left the User Code field as blank and click on save button Should be show as : "
								+ Branch_Code_Popup
								+ "  ||  Actual popup :if user left the User Code field as blank and click on save button the  popup message is not display : "
								+ act_Popup,
						test, test1);
			}
			elementnotvisible1(driver, Popup_Message);

			click(driver, Branch_Input_UM);
			
			formatLocatorClick(driver, Select_Branch_Value_UM, Select_Branch_Code);

		}

		Step_Start(15,
				"if user left the Carrier field as blank and click on save button, the validation message of 'Select the Carrier code' should be displayed.",
				test, test1);
		// Carrier Code popup Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Carrier_Code_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (Carrier_Code_Popup.equals(act_Popup)) {
			System.out.println("'" + Carrier_Code_Popup + "' Popup Displayed ");
			Extent_pass_New(driver, "Matched ||  Expected popup :After click on save button Should be show as : "
					+ Carrier_Code_Popup
					+ "  ||  Actual popup :if user left the Carrier field as blank and click on save button the  popup message is  display : "
					+ act_Popup, test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected popup :if user left the Carrier field as blank and click on save button Should be show as : "
							+ Carrier_Code_Popup
							+ "  ||  Actual popup :if user left the Carrier field as blank and click on save button the  popup message is not display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected popup :if user left the Carrier field as blank and click on save button Should be show as : "
							+ Carrier_Code_Popup
							+ "  ||  Actual popup :if user left the Carrier field as blank and click on save button the  popup message is not display : "
							+ act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);

		waitForElement(driver, Carrier_Code_Input_UM);
		click(driver, Carrier_Code_Input_UM);

		formatLocatorClick(driver, Select_Carrier_Code_UM, Select_Carrier_Code);

		Step_End(15,
				"if user left the Carrier Code field as blank and click on save button, the validation message of 'Select the Carrier code' should be displayed.",
				test, test1);

		if (!Select_User_Type_Input.equals("Local Agency")) {
			Step_Start(10,
					".if user left the address field as blank and click on save button, the validation message of 'Enter the Address' should be displayed",
					test, test1);
			// Address popup Validation
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, Popup_Message, Address_Popup);
			act_Popup = getText(driver, Popup_Message);
			if (Address_Popup.equals(act_Popup)) {
				System.out.println("'" + Address_Popup + "' Popup Displayed ");
				Extent_pass_New(driver,
						"Matched ||  Expected popup :After if user left the address field as blank and click on save button Should be show as : "
								+ Address_Popup
								+ "  ||  Actual popup :After if user left the address field as blank and click on save button the  popup message is not display : "
								+ act_Popup,
						test, test1);
			} else {
				System.out.println(
						"Not Matched ||  Expected popup :After if user left the address field as blank and click on save button Should be show as : "
								+ Address_Popup
								+ "  ||  Actual popup :After if user left the address field as blank and click on save button the  popup message is not display : "
								+ act_Popup);
				Extent_fail(driver,
						"Not Matched ||  Expected popup :After if user left the address field as blank and click on save button Should be show as : "
								+ Address_Popup
								+ "  ||  Actual popup :After if user left the address field as blank and click on save button the  popup message is not display : "
								+ act_Popup,
						test, test1);
			}
			elementnotvisible1(driver, Popup_Message);

			waitForElement(driver, Address_Input_UM);
			sendKeys(driver, Address_Input_UM, Address_Input_Value);
			Step_End(10,
					".if user left the address field as blank and click on save button, the validation message of 'Enter the Address' should be displayed",
					test, test1);

			Step_Start(8,
					"if user left the country field as blank and click on save button, the validation message 'Enter the country' should be displyed",
					test, test1);
			// Country popup Validation
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, Popup_Message, Country_Select_Popup);
			act_Popup = getText(driver, Popup_Message);
			if (Country_Select_Popup.equals(act_Popup)) {
				System.out.println("'" + Country_Select_Popup + "' Popup Displayed ");
				Extent_pass_New(driver,
						"Matched ||  Expected popup :After if user left the country field as blank click on save button Should be show as : "
								+ Country_Select_Popup
								+ "  ||  After if user left the country field as blank click on save button the popup is display : "
								+ act_Popup,
						test, test1);
			} else {
				System.out.println(
						"Not Matched ||  Expected popup :After if user left the country field as blank click on save button Should be show as : "
								+ Country_Select_Popup
								+ "  ||  After if user left the country field as blank click on save button the popup is not display : "
								+ act_Popup);
				Extent_fail(driver,
						"Not Matched ||  Expected popup :After if user left the country field as blankclick on save button Should be show as : "
								+ Country_Select_Popup
								+ "  ||  After if user left the country field as blank click on save button the popup is not  display : "
								+ act_Popup,
						test, test1);
			}
			elementnotvisible1(driver, Popup_Message);

			waitForElement(driver, Country_Input_UM);
			click(driver, Country_Input_UM);

			formatLocatorClick(driver, Select_Country_Option_UM, Select_Country_Value);

			waitForElement(driver, Address_Input_UM);
			sendKeys(driver, Address_Input_UM, Address_Input_Value);
			Step_End(8,
					"if user left the country field as blank and click on save button, the validation message 'Enter the country' should be displyed",
					test, test1);

		}

		Step_Start(9,
				"if user left the city field as blank and click on save button, the validation message of 'Enter the City' should be displayed",
				test, test1);
		// City popup Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, City_Select_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (City_Select_Popup.equals(act_Popup)) {
			System.out.println("'" + City_Select_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||  Expected popup :if user left the city field as blank  click on save button Should be show as : "
							+ City_Select_Popup
							+ "  ||  if user left the city field as blank if user left the country field as blank click on save button the popup is display : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected popup :if user left the city field as blank click on save button Should be show as : "
							+ City_Select_Popup
							+ "  ||  if user left the city field as blank if user left the country field as blank click on save button the popup is not display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected popup :if user left the city field as blank click on save button Should be show as : "
							+ City_Select_Popup
							+ "  ||  if user left the city field as blank if user left the country field as blank click on save button the popup is not display : "
							+ act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);

		waitForElement(driver, City_Input_UM);
		click(driver, City_Input_UM);
		sendKeys(driver, City_Input_UM, " ");

		formatLocatorClick(driver, Select_City_Option_UM, Select_City_Value);
		Step_End(9,
				"if user left the city field as blank and click on save button, the validation message of 'Enter the City' should be displayed",
				test, test1);

		Step_Start(11,
				"if user left the Zipcode field as blank and click on save button, the validation message of 'Enter the Postal/Zipcode' shoud be displayed",
				test, test1);
		// Post Code popup Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Postal_Code_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (Postal_Code_Popup.equals(act_Popup)) {
			System.out.println("'" + Postal_Code_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||  Expected popup :if user left the Zipcode field as blank and click on save button Should be show as : "
							+ Postal_Code_Popup
							+ "  ||  if user left the Zipcode field as blank click on save button the popup is display : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected popup :if user left the Zipcode field as blank and click on save button Should be show as : "
							+ Postal_Code_Popup
							+ "  ||  if user left the Zipcode field as blank click on save button the popup not is display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected popup :if user left the Zipcode field as blank and click on save button Should be show as : "
							+ Postal_Code_Popup
							+ "  ||  if user left the Zipcode field as blank click on save button the popup not is display : "
							+ act_Popup,
					test, test1);
		}
		elementnotvisible1(driver, Popup_Message);

		waitForElement(driver, PinCode_Input_UM);
		sendKeys(driver, PinCode_Input_UM, Postal_Code_Input_Value);
		Step_End(11,
				"if user left the Zipcode field as blank and click on save button, the validation message of 'Enter the Postal/Zipcode' shoud be displayed",
				test, test1);

		Step_Start(12,
				"if user left the telephone field as blank and click on save button, the validation message of 'Enter the telephone Number' should be displayed.",
				test, test1);
		// Telephone Number Validation
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Telephone_Number_Popup);
		act_Popup = getText(driver, Popup_Message);
		if (Telephone_Number_Popup.equals(act_Popup)) {
			System.out.println("'" + Telephone_Number_Popup + "' Popup Displayed ");
			Extent_pass_New(driver,
					"Matched ||  Expected popup :if user left the telephone field as blank click on save button Should be show as : "
							+ Telephone_Number_Popup
							+ "  || if user left the telephone field as blank and click on save button the popup is display : "
							+ act_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected popup :if user left the telephone field as blank click on save button Should be show as : "
							+ Telephone_Number_Popup
							+ "  ||  if user left the telephone field as blank and click on save button the popup is not display : "
							+ act_Popup);
			Extent_fail(driver,
					"Not Matched ||  Expected popup :if user left the telephone field as blank click on save button Should be show as : "
							+ Telephone_Number_Popup
							+ "  ||  if user left the telephone field as blank and click on save button the popup is not display : "
							+ act_Popup,
					test, test1);
		}
		Step_End(12,
				"if user left the telephone field as blank and click on save button, the validation message of 'Enter the telephone Number' should be displayed.",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
