package LRP_NFR_User_Management_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_User_Management_TS003 extends Keywords {

	public void User_Management_TS003(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_User_Management_TS003";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Module = Excel_data.get("User_Management_Module");
		String User_ID_Exist_Popup = Excel_data.get("User_ID_Exist_Popup");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Module);

		waitForElement(driver, Created_UserID_Value_UM);
		String Created_UserID = getText(driver, Created_UserID_Value_UM);

		Step_Start(1, "Click on the NEW button in the tool  bar", test, test1);

		newButton(driver);

		Step_End(1, "Click on the NEW button in the tool  bar", test, test1);

		Step_Start(2, "Enter the USER ID as the Existing Data.", test, test1);
		waitForElement(driver, User_ID_Input_UM);
		sendKeys(driver, User_ID_Input_UM, Created_UserID);
		Step_End(2, "Enter the USER ID as the Existing Data.", test, test1);

		Step_Start(3, "Now try to enter the input in other fields", test, test1);
		waitForElement(driver, Password_Input_UM);
		click(driver, Password_Input_UM);
		Step_End(3, "Now try to enter the input in other fields", test, test1);

		Step_Start(4, "System Should show as 'User ID already exist'.", test, test1);
	
		waitForPopup(driver, Popup_Message, User_ID_Exist_Popup);
		
		String act_Popup = getText(driver, Popup_Message);
		if (User_ID_Exist_Popup.equals(act_Popup)) {
			System.out.println(
					"Matched || Expected popup : " + User_ID_Exist_Popup + "  ||  Actual  popup   : " + act_Popup);
			Extent_pass_New(driver,
					"Matched || Expected popup : " + User_ID_Exist_Popup + "  ||  Actual  popup   : " + act_Popup, test,
					test1);
		}else {
			System.out.println(
					"Not Matched || Expected popup : " + User_ID_Exist_Popup + "  ||  Actual  popup   : " + act_Popup);
			Extent_fail(driver,
					"Not Matched || Expected popup : " + User_ID_Exist_Popup + "  ||  Actual  popup   : " + act_Popup, test,
					test1);
		}

		Step_End(4, "System Should show as 'User ID already exist'.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
