package LRP_Booking_Scripts;

import java.util.Map;


import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC010  extends Keywords{
	public void Booking_SC010(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC010";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String Globalsearchinput = Excel_data.get("Globalsearch");

		navigateUrl(driver, url);
		Extent_Start(test_Case_Name, test, test1);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		moduleNavigate(driver, Search);
		Step_Start(1, "Click on the search icon",test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click1(driver, SearchButton_Toolbar);
		Step_End(1, "Click on the search icon",test, test1);
		Step_Start(2, "Retrieve the existing record",test, test1);
		globalValueSearchWindow(driver,"","",Globalsearchinput,"","","","");
		Step_End(2, "Retrieve the existing record",test, test1);
		Step_Start(3, "System disable the ToolBar",test, test1);
		waitForDisplay(driver, NewButton_ToolBar);
		if(isClickable(driver, NewButton_ToolBar)) {
			System.out.println("Expected Result is : New Button Should be Enabled and Clickable || The Actual Result is : New Button is Enabled and Clickable");
			Extent_pass_New(driver,"Expected Result is : New Button Should be Enabled and Clickable || The Actual Result is : New Button is Enabled and Clickable", test, test1);
		}else {
			System.out.println("Expected Result is : New Button Should be Disabled || The Actual Result is : New Button is Disabled");
			Extent_pass_New(driver,"Expected Result is : New Button Should be Disabled || The Actual Result is : New Button is Disabled", test, test1);
		}
		if(isClickable(driver, SaveButton_ToolBar)) {
			System.out.println("Expected Result is : Save Button Should be Enabled and Clickable || The Actual Result is : Save Button is Enabled and Clickable");
			Extent_pass_New(driver,"Expected Result is : Save Button Should be Enabled and Clickable || The Actual Result is : Save Button is Enabled and Clickable", test, test1);
		}else {
			System.out.println("Expected Result is : Save Button Should be Disabled || The Actual Result is : Save Button is Disabled");
			Extent_pass_New(driver,"Expected Result is : Save Button Should be Disabled || The Actual Result is : Save Button is Disabled", test, test1);
		}
		if(isClickable(driver, Edit_Button_toolBar)) {
			System.out.println("Expected Result is : Edit Button Should be Enabled and Clickable || The Actual Result is : Edit Button is Enabled and Clickable");
			Extent_pass_New(driver,"Expected Result is : Edit Button Should be Enabled and Clickable || The Actual Result is : Edit Button is Enabled and Clickable", test, test1);
		}else {
			System.out.println("Expected Result is : Edit Button Should be Disabled || The Actual Result is : Edit Button is Disabled");
			Extent_pass_New(driver,"Expected Result is : Edit Button Should be Disabled || The Actual Result is : Edit Button is Disabled", test, test1);
		}

		if(isClickable(driver, Delete_button_toolBar)) {
			System.out.println("Expected Result is : Delete Button Should be Enabled and Clickable || The Actual Result is : Delete Button is Enabled and Clickable");
			Extent_pass_New(driver,"Expected Result is : Delete Button Should be Enabled and Clickable || The Actual Result is : Delete Button is Enabled and Clickable", test, test1);
		}else {
			System.out.println("Expected Result is : Delete Button Should be Disabled || The Actual Result is : Delete Button is Disabled");
			Extent_pass_New(driver,"Expected Result is : Delete Button Should be Disabled || The Actual Result is : Delete Button is Disabled", test, test1);
		}

		if(isClickable(driver, cancel_Common_btn)) {
			System.out.println("Expected Result is : Cancel Button Should be Enabled and Clickable || The Actual Result is : Cancel Button is Enabled and Clickable");
			Extent_pass_New(driver,"Expected Result is : Cancel Button Should be Enabled and Clickable || The Actual Result is : Cancel Button is Enabled and Clickable", test, test1);
		}else {
			System.out.println("Expected Result is : Cancel Button Should be Disabled || The Actual Result is : Cancel Button is Disabled");
			Extent_pass_New(driver,"Expected Result is : Cancel Button Should be Disabled || The Actual Result is : Cancel Button is Disabled", test, test1);
		}

		if(isClickable(driver, SaveAs_button_toolBar)) {
			System.out.println("Expected Result is : SaveAs Button Should be Enabled and Clickable || The Actual Result is : SaveAs Button is Enabled and Clickable");
			Extent_pass_New(driver,"Expected Result is : SaveAs Button Should be Enabled and Clickable || The Actual Result is : SaveAs Button is Enabled and Clickable", test, test1);
		}else {
			System.out.println("Expected Result is : SaveAs Button Should be Disabled || The Actual Result is : SaveAs Button is Disabled");
			Extent_pass_New(driver,"Expected Result is : SaveAs Button Should be Disabled || The Actual Result is : SaveAs Button is Disabled", test, test1);
		}
		if(isClickable(driver, Exportbutton)) {
			System.out.println("Expected Result is : Export Button Should be Enabled and Clickable || The Actual Result is : Export Button is Enabled and Clickable");
			Extent_pass_New(driver,"Expected Result is : Export Button Should be Enabled and Clickable || The Actual Result is : Export Button is Enabled and Clickable", test, test1);
		}else {
			System.out.println("Expected Result is : Export Button Should be Disabled || The Actual Result is : Export Button is Disabled");
			Extent_pass_New(driver,"Expected Result is : Export Button Should be Disabled || The Actual Result is : Export Button is Disabled", test, test1);
		}
		Step_Start(3, "System disable the ToolBar",test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}

