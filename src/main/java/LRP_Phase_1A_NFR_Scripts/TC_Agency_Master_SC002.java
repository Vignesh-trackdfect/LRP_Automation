package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

    public class TC_Agency_Master_SC002  extends Keywords{
	public void Agency_Master_SC002(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Agency_Master_SC002";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Master_Module  = Excel_data.get("Agency_Master_Module");
		String Agency_Details_Header  = Excel_data.get("Agency_Details_Header");
		String Condition  = Excel_data.get("Condition");
		String Agency_Details_Value  = Excel_data.get("Agency_Details_Value");
		String Port_Code_Header  = Excel_data.get("Port_Code_Header");
		String Template_Name_New_Input  = Excel_data.get("Template_Name_New_Input");
		String CheckBox_Input  = Excel_data.get("CheckBox_Input");
		String Template_Name_old_Input  = Excel_data.get("Template_Name_old_Input");

		

		Extent_Start(testcase_Name, test, test1);
		
		Step_Start(1, "Login & Open agency master screen", test, test1);
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

		Step_Start(4, "Open the saved templates list.Select and apply an existing template", test, test1);
		formatLocatorClick(driver, AM_Template_Header, Template_Name_old_Input);
		Step_End(4, "Open the saved templates list.Select and apply an existing template", test, test1);

		
		Step_Start(5, "Change column visibility, apply different filters, or rearrange the layout to simulate user modifications", test, test1);
		formatLocatorClick(driver, Menu_Button, Port_Code_Header);
		
		waitForElement(driver, AM_Menu_Filter);
		click(driver, AM_Menu_Filter);
		
		waitForElement(driver, AM_Grid_Select_All_Check_Box);
		click(driver, AM_Grid_Select_All_Check_Box);	
		
		waitForElement(driver, AM_Checkbox_Search);
		sendKeys(driver, AM_Checkbox_Search, CheckBox_Input);
		
		formatLocatorClick(driver, AM_Grid_Select_Text_Value,CheckBox_Input);	
		Step_End(5, "Change column visibility, apply different filters, or rearrange the layout to simulate user modifications", test, test1);

		Step_Start(6, "Locate and click the settings or gear icon that opens the options menu", test, test1);

		waitForElement(driver, AM_ToolPanel);
		click(driver, AM_ToolPanel);
		Step_End(6, "Locate and click the settings or gear icon that opens the options menu", test, test1);

		Step_Start(7, "Click the second icon labeled “Save as Template”", test, test1);

		waitForElement(driver, AM_SaveAs_Template);
		click(driver, AM_SaveAs_Template);		
		Step_End(7, "Click the second icon labeled “Save as Template”", test, test1);

		Step_Start(8, "In the input box that appears, type a new, unique template name", test, test1);
		waitForElement(driver, AM_Template_Name);
		sendKeys(driver, AM_Template_Name, Template_Name_New_Input);
		Step_End(8, "In the input box that appears, type a new, unique template name", test, test1);

		Step_Start(9, "Submit the form using the Save or OK button", test, test1);

		waitForElement(driver, AM_Template_Name_Save);
		click(driver, AM_Template_Name_Save);
		Step_End(9, "Submit the form using the Save or OK button", test, test1);

		Step_Start(10, "Go back to another tab(Contacts) and Check again whether saved template is appear", test, test1);

		waitForElement(driver, AM_Contacts_Tab);
		click(driver, AM_Contacts_Tab);
		
		waitForElement(driver, Controlling_Ports_Tab);
		click(driver,Controlling_Ports_Tab );
		
		String Temp_Header = String.format(AM_Template_Header, Template_Name_New_Input);
		
		if(isdisplayed(driver, Temp_Header)) {
			System.out.println("Expected result  is : The given header of the Template should be displayed : "+Template_Name_New_Input+ " || Actual result  is : The given header of the Template is displayed : " +Template_Name_New_Input);
			Extent_pass_New(driver,"Expected result  is : The given header of the Template should be displayed : "+Template_Name_New_Input+ " || Actual result  is : The given header of the Template is  displayed: " +Template_Name_New_Input , test, test1);
		}
		
		else
		{
			System.out.println("Expected result  is : The given header of the Template should be displayed: "+Template_Name_New_Input+ " || Actual result  is : The given header of the Template is not displayed: " +Template_Name_New_Input);
	Extent_fail(driver, "Expected result  is : The given header of the Template should be displayed: "+Template_Name_New_Input+ " || Actual result  is : The given header of the Template is not displayed: " +Template_Name_New_Input, test, test1);
		}
		
		Step_End(10, "Go back to another tab(Contacts) and Check again whether saved template is appear", test, test1);
		
		Extent_completed(testcase_Name, test, test1);

	}
}