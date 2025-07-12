package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

    public class TC_Agency_Master_SC003  extends Keywords{
	public void Agency_Master_SC003(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Agency_Master_SC003";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Master_Module  = Excel_data.get("Agency_Master_Module");
		String Agency_Details_Header  = Excel_data.get("Agency_Details_Header");
		String Condition  = Excel_data.get("Condition");
		String Agency_Details_Value  = Excel_data.get("Agency_Details_Value");
		String Template_Name_Input  = Excel_data.get("Template_Name_Input");
		String Delete_Popup_Input  = Excel_data.get("Delete_Popup_Input");

		

		Step_Start(1, "Login & Open agency master screen", test, test1);
	
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		moduleNavigate(driver, Agency_Master_Module );
		Step_End(1, "Login & Open agency master screen", test, test1);

		Step_Start(2, "Retrieve Office Agency from the scrreen", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar );
		globalValueSearchWindow(driver,Condition , Agency_Details_Header, Agency_Details_Value, "", "", "", "");
		Step_End(2, "Retrieve Office Agency from the scrreen", test, test1);

		Step_Start(3, "Navigate to Controlling Ports tab", test, test1);

		waitForElement(driver, Controlling_Ports_Tab);
		click(driver,Controlling_Ports_Tab );
		Step_End(3, "Navigate to Controlling Ports tab", test, test1);
		
		Step_Start(4, "Access the saved templates list.Choose an existing template", test, test1);
		formatLocatorClick(driver, AM_Template_Header, Template_Name_Input);
		waitForElement(driver, AM_ToolPanel);
		click(driver, AM_ToolPanel);
		Step_End(4, "Access the saved templates list.Choose an existing template", test, test1);

		Step_Start(5, "Click the third icon labeled Delete Template", test, test1);
		waitForElement(driver, AM_Delete_Templete);
		click(driver, AM_Delete_Templete);
		Step_End(5, "Click the third icon labeled Delete Template", test, test1);

		Step_Start(6, "Check for a message like Template deleted successfully" , test, test1);

		waitForPopup(driver, Popup_Message, Delete_Popup_Input);
		
		String Applied_Pol_Popup = getText(driver, Popup_Message);

		System.out.println(Applied_Pol_Popup);
		if (Delete_Popup_Input.equals(Applied_Pol_Popup)) {
			System.out.println("Matched || " + " Expected saved poup : " + Delete_Popup_Input
					+ " || Actual saved popup : " + Applied_Pol_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + Delete_Popup_Input
					+ " || Actual saved popup is : " + Applied_Pol_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + Delete_Popup_Input
					+ " || Actual saved popup : " + Applied_Pol_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + Delete_Popup_Input
					+ " || Actual saved popup is : " + Applied_Pol_Popup, test, test1);

		}
		Step_End(6, "Check for a message like Template deleted successfully" , test, test1);

		Step_Start(7, "Confirm that Template is no longer in the list" , test, test1);

		String Temp_Header = String.format(AM_Template_Header, Template_Name_Input);

		if(!isdisplayed(driver, Temp_Header)) {
			System.out.println("Expected result  is : The given header of the Template should be displayed : "+Template_Name_Input+ " || Actual result  is : The given header of the Template is displayed : " +Template_Name_Input);
			Extent_pass_New(driver,"Expected result  is : The given header of the Template should be displayed : "+Template_Name_Input+ " || Actual result  is : The given header of the Template is  displayed: " +Template_Name_Input , test, test1);
		}
		
		else
		{
			System.out.println("Expected result  is : The given header of the Template should be displayed: "+Template_Name_Input+ " || Actual result  is : The given header of the Template is not displayed: " +Template_Name_Input);
	Extent_fail(driver, "Expected result  is : The given header of the Template should be displayed: "+Template_Name_Input+ " || Actual result  is : The given header of the Template is not displayed: " +Template_Name_Input, test, test1);
		}
		Step_End(7, "Confirm that Template is no longer in the list" , test, test1);

		
		Extent_completed(testcase_Name, test, test1);

		
}
    }
