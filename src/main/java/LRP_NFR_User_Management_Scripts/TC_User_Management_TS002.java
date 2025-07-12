package LRP_NFR_User_Management_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_User_Management_TS002 extends Keywords {

	public void User_Management_TS002(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_User_Management_TS002";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Module = Excel_data.get("User_Management_Module");
		String User_To_Edit_Values = Excel_data.get("User_To_Edit_Values");
		String Edit_User_Type = Excel_data.get("Edit_User_Type");
		String Edit_Department = Excel_data.get("Edit_Department");
		String Select_Designation = Excel_data.get("Select_Designation");
		String Edit_System_Code = Excel_data.get("Edit_System_Code");
		String Edit_User_Code = Excel_data.get("Edit_User_Code");
		String Edit_Brach_Code = Excel_data.get("Edit_Brach_Code");
		String User_Edited_Popup = Excel_data.get("User_Edited_Popup");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Module);
		waitForDisplay(driver, NewButton_ToolBar);

		Step_Start(1, ".Select a  username and click on EDIT icon on usermanagement home page", test, test1);

		formatLocatorClick(driver, UserEdit_Button_UM, User_To_Edit_Values);
	

		Step_End(1, ".Select a  username and click on EDIT icon on usermanagement home page", test, test1);

		Step_Start(2, "Click on EDIT button in that Tool bar", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(2, "Click on EDIT button in that Tool bar", test, test1);

		Step_Start(3, "USER ID can't be editable.", test, test1);
		waitForElement(driver, First_Name_Input_UM);
		if (isElementEnabled(driver, User_ID_Input_UM)) {
			System.out.println("Expected Result is : User ID Input should be Editable || Actual Result is : User ID input is Editable");
			Extent_fail(driver, "Expected Result is : User ID Input should be Editable || Actual Result is : User ID input is Editable", test, test1);
		} else {
			System.out.println("Expected Result is : User ID Input should be Editable || Actual Result is : User ID input is not Editable");
			Extent_pass_New(driver, "Expected Result is : User ID Input should be Editable || Actual Result is : User ID input is not Editable", test, test1);
		}
		Step_End(3, "USER ID can't be editable.", test, test1);

		Step_Start(4, "Edit Address field", test, test1);
		String newAddred = generateRandomString(4);
		waitForElement(driver, Address_Input_UM);
		clear(driver, Address_Input_UM);
		sendKeys(driver, Address_Input_UM, newAddred);
		Step_End(4, "Edit Address field", test, test1);

		Step_Start(5, "Edit Telephone number.", test, test1);
		String newTelephone = String.valueOf(generateRandomNumber(4));
		waitForElement(driver, Telephone_Number_Input_UM);
		clear(driver, Telephone_Number_Input_UM);
		sendKeys(driver, Telephone_Number_Input_UM, newTelephone);
		Step_End(5, "Edit Telephone number.", test, test1);

		Step_Start(6, "Edit City", test, test1);
		waitForElement(driver, City_Input_UM);
		clear(driver, City_Input_UM);
		sendKeys(driver, City_Input_UM, " ");

		waitForElement(driver, Select_CityList_UM);
		List<WebElement> cities = listOfElements(driver, Select_CityList_UM);
		int randomCity = generateRandomNumber(1);
		if (randomCity > cities.size()) {
			while (randomCity < cities.size()) {
				randomCity = generateRandomNumber(1);
			}
		}
		String citycol = String.valueOf(randomCity);
		formatLocatorClick(driver, CityValue_UM, citycol);
	
		Step_End(6, "Edit City", test, test1);

		Step_Start(7, "Edit Postal code", test, test1);
		String pincodeChange = String.valueOf(generateRandomNumber(4));
		waitForElement(driver, PinCode_Input_UM);
		clear(driver, PinCode_Input_UM);
		sendKeys(driver, PinCode_Input_UM, pincodeChange);
		Step_End(7, "Edit Postal code", test, test1);

		Step_Start(8, "Edit Fax number", test, test1);
		String faxNumChange = String.valueOf(generateRandomNumber(4));
		waitForElement(driver, Fax_Number_Input_UM);
		clear(driver, Fax_Number_Input_UM);
		sendKeys(driver, Fax_Number_Input_UM, faxNumChange);
		Step_End(8, "Edit Fax number", test, test1);

		Step_Start(9, "Edit User type", test, test1);
		waitForElement(driver, UserType_Input_UM);
		click(driver, UserType_Input_UM);

		formatLocatorClick(driver, Select_UserOption_UM, Edit_User_Type);
		
		waitForElement(driver, UserType_Input_UM);
		if (isdisplayed(driver, UserCode_Input_UM)) {
			click(driver, UserCode_Input_UM);
			formatLocatorClick(driver, DropDown_Select, Edit_User_Code);

		
		}
		waitForElement(driver, UserType_Input_UM);
		if (isdisplayed(driver, Branch_Input_UM)) {
			click(driver, Branch_Input_UM);
			formatLocatorClick(driver, Select_Branch_Value_UM, Edit_Brach_Code);

			
		}
		Step_End(9, "Edit User type", test, test1);

		Step_Start(10, "Edit Department", test, test1);
		waitForElement(driver, Department_input_UM);
		click(driver, Department_input_UM);
		formatLocatorClick(driver, Select_Department_Option_UM, Edit_Department);

	
		Step_End(10, "Edit Department", test, test1);

		Step_Start(11, "Edit Designation", test, test1);
		waitForElement(driver, Designation_Input_UM);
		click(driver, Designation_Input_UM);
		formatLocatorClick(driver, Select_Designation_UM, Select_Designation);

		
		Step_End(11, "Edit Designation", test, test1);

		Step_Start(12, "Edit LOGIN EXPIRY DATE.", test, test1);
		int randomdate = generateRandomNumber(2);
		String Edit_Expirydate = getFutureDate(randomdate);

		waitForElement(driver, Login_Exp_Date_Input_UM);
		selectDatePicker(driver, Login_Exp_Date_Input_UM, Edit_Expirydate);
		Step_End(12, "Edit LOGIN EXPIRY DATE.", test, test1);

		Step_Start(13, "Edit  System Code ", test, test1);
		waitForElement(driver, System_type_Input_UM);
		click(driver, System_type_Input_UM);

		formatLocatorClick(driver, Select_System_Option_UM, Edit_System_Code);

		Step_End(13, "Edit  System Code ", test, test1);

		Step_Start(14, "Enter the SAVE button in the tool bar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(14, "Enter the SAVE button in the tool bar", test, test1);

		Step_Start(15, "Should show as 'User details updated successfully' ", test, test1);

		waitForPopup(driver, Popup_Message, User_Edited_Popup);
		String act_Popup = getText(driver, Popup_Message);

		if (User_Edited_Popup.equals(act_Popup)) {
			System.out.println(
					"Matched || Expected popup : " + User_Edited_Popup + "  ||  Actual  popup   : " + act_Popup);
			Extent_pass_New(driver,
					"Matched || Expected popup : " + User_Edited_Popup + "  ||  Actual  popup   : " + act_Popup, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup : " + User_Edited_Popup + "  ||  Actual  popup   : " + act_Popup);
			Extent_pass_New(driver,
					"Not Matched || Expected popup : " + User_Edited_Popup + "  ||  Actual  popup   : " + act_Popup,
					test, test1);
		}

		Step_End(15, "Should show as 'User details updated successfully' ", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
