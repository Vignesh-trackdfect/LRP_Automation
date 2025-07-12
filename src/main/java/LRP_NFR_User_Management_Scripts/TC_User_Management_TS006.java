package LRP_NFR_User_Management_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_User_Management_TS006 extends Keywords {

	public void User_Management_TS006(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_User_Management_TS006";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Module = Excel_data.get("User_Management_Module");
		String Select_InActive_Status = Excel_data.get("Select_InActive_Status");
		String User_Edited_Popup = Excel_data.get("User_Edited_Popup");
		String InActive_Symbol = Excel_data.get("InActive_Status_Code");
		String Active_Status_Code = Excel_data.get("Active_Status_Code");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Module);
		waitForDisplay(driver, NewButton_ToolBar);

		Step_Start(1, "Select a  username and click on EDIT icon on usermanagement home page.", test, test1);
		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);

		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);

		waitForElement(driver, Status_Filter_Input_UM);
		sendKeys(driver, Status_Filter_Input_UM, Active_Status_Code);

		waitForElement(driver, Active_User_Column_UM);
		String ActiveUserName = getText(driver, Active_User_Column_UM);

		
	formatLocatorClick(driver, UserEdit_Button_UM, ActiveUserName);
		Step_End(1, "Select a  username and click on EDIT icon on usermanagement home page.", test, test1);

		Step_Start(2, "Click on EDIT button in that Tool bar.", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(2, "Click on EDIT button in that Tool bar.", test, test1);

		Step_Start(3, "Click the STATUS dropdown and select the INACTIVE in the dropdown", test, test1);
		waitForElement(driver, Status_Input_UM);
		click(driver, Status_Input_UM);

		formatLocatorClick(driver, Select_Status_Option_UM, Select_InActive_Status);

		Step_End(3, "Click the STATUS dropdown and select the INACTIVE in the dropdown", test, test1);

		Step_Start(4,
				"Click the SAVE button in the tool bar and a message of  'User details updated successfully' is displayed and will be navigated to the home page.",
				test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, User_Edited_Popup);

		String act_Popup = getText(driver, Popup_Message);

		if (User_Edited_Popup.equals(act_Popup)) {
			System.out.println("Matched || Expected popup message was : " + User_Edited_Popup
					+ " || Actual popup message was : " + act_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + User_Edited_Popup
					+ " || Actual popup message was : " + act_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + User_Edited_Popup
					+ " || Actual popup message was : " + act_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + User_Edited_Popup
					+ " || Actual popup message was : " + act_Popup, test, test1);
		}
		Step_End(4,
				"Click the SAVE button in the tool bar and a message of  'User details updated successfully' is displayed and will be navigated to the home page.",
				test, test1);

		Step_Start(5,
				"Now search for the specific user, using login name and in the status column , the status of the user will be 'V'.",
				test, test1);
		waitForElement(driver, Created_UserID_Value_UM);

		waitForElement(driver, Filter_click);
		click(driver, Filter_click);

		waitForElement(driver, Login_Name_Filter_Input_UM);
		sendKeys(driver, Login_Name_Filter_Input_UM, ActiveUserName);
	
		String userStatus = String.format(Created_User_StatusColumn_UM, ActiveUserName);
		waitForElement(driver, userStatus);
		String ChangedStatus = getText(driver, userStatus);
		
		if (ChangedStatus.equalsIgnoreCase(InActive_Symbol)) {
			System.out.println(ActiveUserName + " User Status Changed as 'V' After Changing it into InActive, || Exp : "
					+ InActive_Symbol
					+ "  || Actual popup:Now search for the specific user, using login name and in the status column , the status of the user will be 'V' : "
					+ ChangedStatus);
			Extent_pass_New(driver, ActiveUserName + " User Status Changed as 'V' After Changing it into InActive || Exp : "
					+ InActive_Symbol
					+ "  || Actual popup:Now search for the specific user, using login name and in the status column , the status of the user will be 'V' : "
					+ ChangedStatus, test, test1);
		} else {
			System.out.println(ActiveUserName
					+ " User Status Not Changed as 'V' After Changing it into InActive || Exp : " + InActive_Symbol
					+ "  || Actual popup : Now search for the specific user, using login name and in the status column , the status of the user will be not 'V'"
					+ ChangedStatus);
			Extent_fail(driver, ActiveUserName
					+ " User Status Not Changed as 'V' After Changing it into InActive || Exp : " + InActive_Symbol
					+ "  || Actual popup :Now search for the specific user, using login name and in the status column , the status of the user will be not 'V' "
					+ ChangedStatus, test, test1);
		}

		Step_End(5,
				"Now search for the specific user, using login name and in the status column , the status of the user will be 'V'.",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
