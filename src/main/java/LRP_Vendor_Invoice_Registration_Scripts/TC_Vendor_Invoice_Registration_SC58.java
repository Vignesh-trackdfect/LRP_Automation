package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Invoice_Registration_SC58  extends Keywords{
	
	public void Vendor_Invoice_Registration_SC58(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Vendor_Invoice_Registration_SC58";
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String Agency = Excel_data.get("Agency");
		String Vendor_Inv_Number = Excel_data.get("Vendor_Inv_Number");
		String Vendor_Search = Excel_data.get("Vendor_Search");
		String condition = Excel_data.get("Condition");
		String Privilege_search = Excel_data.get("Privilege_search");
		String Privilege_search_input = Excel_data.get("Privilege_search_input");
		String Vendor_search_Checkbox = Excel_data.get("Vendor_search_Checkbox");
		String User_Name_search = Excel_data.get("User_Name_search");
		String User_Search = Excel_data.get("User_Search");
		

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Extent_call(test, test1,"**Switch the Profile Start**");

		SwitchProfile(driver, Agency);
		moduleNavigate(driver, User_Search);
		newButton(driver);
	
		waitForElement(driver, user_Search_button_ULS);
		click(driver, user_Search_button_ULS);
	
	
		twoColumnSearchWindow(driver, User_Name_search, condition, Username);
	
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, Activity_Filter_Input_ULS);
		sendKeys(driver, Activity_Filter_Input_ULS, Module_Name);
		
		formatLocatorClick(driver, Description_select_check_box, Vendor_search_Checkbox);
		
		waitForElement(driver, Description_Add_button_ULS);
		click(driver, Description_Add_button_ULS);
		twoColumnSearchWindow(driver, Privilege_search, condition, Privilege_search_input);
	
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message_Ok_Button);
	click(driver, popup_Message_Ok_Button);
	
	waitForElement(driver, Close_Current_tab);
	click(driver, Close_Current_tab);
	
	Step_Start(1, "Enter the screen name as a \"\"Vendor Invoice Registration\"\" in the Search.", test, test1);
	moduleNavigate(driver, Module_Name);
	Step_End(1, "Enter the screen name as a \"\"Vendor Invoice Registration\"\" in the Search.", test, test1);
	newButton(driver);
	
	waitForElement(driver, SearchButton_Toolbar);
	if(isElementAccessible(driver, SearchButton_Toolbar)) {
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
	}else {
	
	waitForDisplay(driver, cancel_Common_btn);
	if(isElementAccessible(driver, cancel_Common_btn)) {
		click(driver, cancel_Common_btn);
	}
	Step_Start(2, "Click the global search ", test, test1);
	waitForElement(driver, SearchButton_Toolbar);
	click(driver, SearchButton_Toolbar);
	}
	Step_End(2, "Click the global search ", test, test1);
	
	Step_Start(3, "Enter the Vendor invoice Reg no in the Vendor invoice Reg no field. ", test, test1);
	Step_Start(4, "Select the Confirmed Invoice no", test, test1);
	globalValueSearchWindow(driver, condition, Vendor_Search, Vendor_Inv_Number, "","", "","");
	Step_End(4, "Select the Confirmed Invoice no", test, test1);
	Step_End(3, "Enter the Vendor invoice Reg no in the Vendor invoice Reg no field. ", test, test1);
	Step_Start(5, "It show the Post Button based on the Privilege", test, test1);
	waitForDisplay(driver, post_button);
	if(isdisplayed(driver, post_button)) {
		
		System.out.println(
				"Expected result is : Post button should be present after adding Privilege in user level security|| Actual result : Post button is present after adding Privilege in user level security ");
		Extent_pass_New(driver,
				"Expected result is : Post button should be present after adding Privilege in user level security || Actual result : Post button is present after adding Privilege in user level security",
				test, test1);

	} else {

		System.out.println(
				"Expected result is : Post button should be present after adding Privilege in user level security|| Actual result : Post button is not present after adding Privilege in user level security ");
		Extent_fail(driver,
				"Expected result is : Post button should be present after adding Privilege in user level security|| Actual result :Post button is not present after adding Privilege in user level security",
				test, test1);
	
	}
	Step_End(5, "It show the Post Button based on the Privilege", test, test1);
	
	
	waitForElement(driver, Close_Current_tab);
	click(driver, Close_Current_tab);
	
	
	Step_Start(6, "The Privilege in the User level security", test, test1);
	moduleNavigate(driver, User_Search);
	newButton(driver);

	waitForElement(driver, user_Search_button_ULS);
	click(driver, user_Search_button_ULS);


	twoColumnSearchWindow(driver, User_Name_search, condition, Username);

	waitForElement(driver, Edit_Button_toolBar);
	click(driver, Edit_Button_toolBar);
	
	
	waitForElement(driver, Activity_Filter_Input_ULS);
	sendKeys(driver, Activity_Filter_Input_ULS, Module_Name);
	
	formatLocatorClick(driver, Description_select_check_box, Vendor_search_Checkbox);
	
	
	
	waitForElement(driver, privilege_row_click);
	click(driver, privilege_row_click);
	waitForElement(driver, Description_remove_button_ULS);
	click(driver, Description_remove_button_ULS);
	
	waitForElement(driver, SaveButton_ToolBar);
	click(driver, SaveButton_ToolBar);
	waitForElement(driver, popup_Message_Ok_Button);
click(driver, popup_Message_Ok_Button);

waitForElement(driver, Close_Current_tab);
click(driver, Close_Current_tab);
	
waitForElement(driver, Logout_Icon);
click(driver,Logout_Icon);

waitForElement(driver, Logout_Yes_Btn);
click(driver,Logout_Yes_Btn);
alertAccept(driver);

LRP_Login(driver, Username, Password);

Extent_call(test, test1,"**Switch the Profile Start**");

SwitchProfile(driver, Agency);


moduleNavigate(driver, Module_Name);

newButton(driver);
waitForDisplay(driver, cancel_Common_btn);
if(isElementAccessible(driver, cancel_Common_btn)) {
	click(driver, cancel_Common_btn);
}
waitForElement(driver, SearchButton_Toolbar);
click(driver, SearchButton_Toolbar);
globalValueSearchWindow(driver, condition, Vendor_Search, Vendor_Inv_Number, "","", "","");


waitForDisplay(driver, post_button);
if(!isdisplayed(driver, post_button)) {
	
	System.out.println(
			"Expected result is : Post button should be not present after remove Privilege in user level security|| Actual result : Post button  not present after remove Privilege in user level security ");
	Extent_pass_New(driver,
			"Expected result is : Post button should be not present after remove Privilege in user level security || Actual result : Post button  not present after remove Privilege in user level security",
			test, test1);

} else {

	System.out.println(
			"Expected result is : Post button should be is present after remove Privilege in user level security|| Actual result :  Post button  present after remove Privilege in user level security ");
	Extent_fail(driver,
			"Expected result is : Post button should be is present after remove Privilege in user level security|| Actual result : Post button  present after remove Privilege in user level security",
			test, test1);

}
Step_End(6, "The Privilege in the User level security", test, test1);
Extent_completed(testcase_Name, test, test1);
}}
