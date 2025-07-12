package LRP_NFR_User_Management_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_User_Management_TS001 extends Keywords {

	public void User_Management_TS001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_User_Management_TS001";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Module = Excel_data.get("User_Management_Module");
		String Type_User_Id = Excel_data.get("Type_User_Id");
		String Type_Password = Excel_data.get("Type_Password");
		String Type_FirstName = Excel_data.get("Type_FirstName");
		String Type_LastName = Excel_data.get("Type_LastName");
		String Type_Email_Id = Excel_data.get("Type_Email_Id");
		String Select_Country = Excel_data.get("Select_Country");
		String Select_City = Excel_data.get("Select_City");
		String Type_Address = Excel_data.get("Type_Address");
		String Telephone_Code = Excel_data.get("Telephone_Code");
		String Telephone_Number = Excel_data.get("Telephone_Number");
		String PinCode_Value = Excel_data.get("PinCode_Value");
		String Select_User_Type = Excel_data.get("Select_User_Type");
		String Select_User_Code = Excel_data.get("Select_User_Code");
		String Select_Brach_Code = Excel_data.get("Select_Brach_Code");
		String Select_System_Type = Excel_data.get("Select_System_Type");
		String Select_Time_Zone = Excel_data.get("Select_Time_Zone");
		String Select_Date_Format = Excel_data.get("Select_Date_Format");
		String Select_CarrierCode_Value = Excel_data.get("Select_CarrierCode_Value");
		String Expiry_Date_Value = Excel_data.get("Expiry_Date_Value");
		String Select_Status_value = Excel_data.get("Select_Status_value");
		String User_Created_Popup = Excel_data.get("User_Created_Popup");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Module);

		Step_Start(1, "Click on the NEW button in the tool  bar", test, test1);

		newButton(driver);

		Step_End(1, "Click on the NEW button in the tool  bar", test, test1);

		Step_Start(2, "Enter the USER ID with minimum Three characters.", test, test1);
		waitForElement(driver, User_ID_Input_UM);
		sendKeys(driver, User_ID_Input_UM, Type_User_Id);
		Step_End(2, "Enter the USER ID with minimum Three characters.", test, test1);

		Step_Start(3, "Enter the PASSWORD", test, test1);
		waitForElement(driver, Password_Input_UM);
		sendKeys(driver, Password_Input_UM, Type_Password);
		Step_End(3, "Enter the PASSWORD", test, test1);

		Step_Start(4, "Enter the CONFIRM PASSWORD field", test, test1);
		waitForElement(driver, ConfirmPassword_Input_UM);
		sendKeys(driver, ConfirmPassword_Input_UM, Type_Password);
		Step_End(4, "Enter the CONFIRM PASSWORD field", test, test1);

		Step_Start(5, "Enter the FIRST NAME with minimum 3 characters", test, test1);
		waitForElement(driver, First_Name_Input_UM);
		sendKeys(driver, First_Name_Input_UM, Type_FirstName);
		Step_End(5, "Enter the FIRST NAME with minimum 3 characters", test, test1);

		Step_Start(6, "Enter the LAST NAME with minimum 3 characters.", test, test1);
		waitForElement(driver, LastName_Input_UM);
		sendKeys(driver, LastName_Input_UM, Type_LastName);
		Step_End(6, "Enter the LAST NAME with minimum 3 characters.", test, test1);

		Step_Start(7, "Enter the EMAIL ID with the correct email format", test, test1);
		waitForElement(driver, Email_Id_Input_UM);
		sendKeys(driver, Email_Id_Input_UM, Type_Email_Id);
		Step_End(7, "Enter the EMAIL ID with the correct email format", test, test1);

		Step_Start(8, "Click the COUNTRY dropdown and select one of the countries from the dropdown", test, test1);
		waitForElement(driver, Country_Input_UM);
		click(driver, Country_Input_UM);

		formatLocatorClick(driver, Select_Country_Option_UM, Select_Country);
		
		Step_End(8, "Click the COUNTRY dropdown and select one of the countries from the dropdown", test, test1);

		Step_Start(9,
				"Enter a ' ' (space) in the CITY input field and you can see the number of cities below and you choose one of the cities from the options",
				test, test1);
		waitForElement(driver, City_Input_UM);
		click(driver, City_Input_UM);
		sendKeys(driver, City_Input_UM, " ");

		formatLocatorClick(driver, Select_City_Option_UM, Select_City);

	
		Step_End(9,
				"Enter a ' ' (space) in the CITY input field and you can see the number of cities below and you choose one of the cities from the options",
				test, test1);

		Step_Start(10, "Enter a address in the ADDRESS input field", test, test1);
		waitForElement(driver, Address_Input_UM);
		sendKeys(driver, Address_Input_UM, Type_Address);
		Step_End(10, "Enter a address in the ADDRESS input field", test, test1);

		Step_Start(11, "Enter a Telephone number  based on the country chosen  above", test, test1);
		waitForElement(driver, TelePhone_Code_Input_UM);
		sendKeys(driver, TelePhone_Code_Input_UM, Telephone_Code);

		waitForElement(driver, Telephone_Number_Input_UM);
		sendKeys(driver, Telephone_Number_Input_UM, Telephone_Number);
		Step_End(11, "Enter a Telephone number  based on the country chosen  above", test, test1);

		Step_Start(12, "Enter the PINCODE based on the country chosen above.", test, test1);
		waitForElement(driver, PinCode_Input_UM);
		sendKeys(driver, PinCode_Input_UM, PinCode_Value);
		Step_End(12, "Enter the PINCODE based on the country chosen above.", test, test1);

		Step_Start(13, "Click the USER TYPE dropdown and choose on of the usertype from the dropdown", test, test1);
		waitForElement(driver, UserType_Input_UM);
		click(driver, UserType_Input_UM);

		formatLocatorClick(driver, Select_UserOption_UM, Select_User_Type);

	
		waitForElement(driver, UserType_Input_UM);

		if (isdisplayed(driver, UserCode_Input_UM)) {
			click(driver, UserCode_Input_UM);
			formatLocatorClick(driver, DropDown_Select, Select_User_Code);

	
		}

		waitForElement(driver, UserType_Input_UM);
		if (isdisplayed(driver, Branch_Input_UM)) {
			click(driver, Branch_Input_UM);
			formatLocatorClick(driver, Select_Branch_Value_UM, Select_Brach_Code);

		
		}

		Step_End(13, "Click the USER TYPE dropdown and choose on of the usertype from the dropdown", test, test1);

		Step_Start(14, "Click the SYSTEM TYPE dropdown and choose on of the systemtype from the dropdown.", test,
				test1);
		waitForElement(driver, System_type_Input_UM);
		click(driver, System_type_Input_UM);
		formatLocatorClick(driver, Select_System_Option_UM, Select_System_Type);

		Step_End(14, "Click the SYSTEM TYPE dropdown and choose on of the systemtype from the dropdown.", test, test1);

		Step_Start(15,
				"Click the PREFERRED TIME ZONE dropdown and click one of the timezone based on the country chosen above.",
				test, test1);
		waitForElement(driver, TimeZone_Input_UM);
		click(driver, TimeZone_Input_UM);
		formatLocatorClick(driver, Select_TimeZone_UM, Select_Time_Zone);

		Step_End(15,
				"Click the PREFERRED TIME ZONE dropdown and click one of the timezone based on the country chosen above.",
				test, test1);

		Step_Start(16, "Click the DATE FORMAT dropdown and click one of the format ", test, test1);
		waitForElement(driver, DateFormat_Input_UM);
		click(driver, DateFormat_Input_UM);
		formatLocatorClick(driver, Select_DateFormat_UM, Select_Date_Format);

		Step_End(16, "Click the DATE FORMAT dropdown and click one of the format ", test, test1);

		Step_Start(17, "Click the CARRIER CODE dropdown and click one of the carrier ", test, test1);
		waitForElement(driver, Carrier_Code_Input_UM);
		click(driver, Carrier_Code_Input_UM);
		formatLocatorClick(driver, Select_Carrier_Code_UM, Select_CarrierCode_Value);

		Step_End(17, "Click the CARRIER CODE dropdown and click one of the carrier ", test, test1);

		Step_Start(18,
				"Click the LOGIN EXPIRY DATE and select a date and the selected data should be Present and future date and should not be past date. ",
				test, test1);
		waitForElement(driver, Login_Exp_Date_Input_UM);
		selectDatePicker(driver, Login_Exp_Date_Input_UM, Expiry_Date_Value);
		Step_End(18,
				"Click the LOGIN EXPIRY DATE and select a date and the selected data should be Present and future date and should not be past date. ",
				test, test1);

		Step_Start(19, "Select the STATUS dropdown and select the ACTIVE option", test, test1);
		waitForElement(driver, Status_Input_UM);
		click(driver, Status_Input_UM);
		formatLocatorClick(driver, Select_Status_Option_UM, Select_Status_value);


		Step_End(19, "Select the STATUS dropdown and select the ACTIVE option", test, test1);

		Step_Start(20, "Click the SAVE button in the tool Bar.", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(20, "Click the SAVE button in the tool Bar.", test, test1);

		Step_Start(21, "Should show as 'User details created successfully'", test, test1);

		waitForPopup(driver, Popup_Message, User_Created_Popup);

		String act_Popup = getText(driver, Popup_Message);

		if (User_Created_Popup.equals(act_Popup)) {
			System.out.println(
					"Matched || Expected popup : " + User_Created_Popup + "  ||  Actual  popup   : " + act_Popup);
			Extent_pass_New(driver,
					"Matched || Expected popup : " + User_Created_Popup + "  ||  Actual  popup   : " + act_Popup, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup : " + User_Created_Popup + "  ||  Actual  popup   : " + act_Popup);
			Extent_pass_New(driver,
					"Not Matched || Expected popup : " + User_Created_Popup + "  ||  Actual  popup   : " + act_Popup,
					test, test1);
		}

		Step_End(21, "Should show as 'User details created successfully'", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
