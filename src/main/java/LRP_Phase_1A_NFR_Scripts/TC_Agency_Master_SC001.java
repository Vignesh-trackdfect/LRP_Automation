package LRP_Phase_1A_NFR_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Agency_Master_SC001  extends Keywords{
	public void Agency_Master_SC001(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Agency_Master_SC001";
			
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Master_Module  = Excel_data.get("Agency_Master_Module");
		String Agency_Details_Header  = Excel_data.get("Agency_Details_Header");
		String Condition  = Excel_data.get("Condition");
		String Agency_Details_Value  = Excel_data.get("Agency_Details_Value");
		String Pin_Port_Code_Header  = Excel_data.get("Pin_Port_Code_Header");
		String Template_Name_Input  = Excel_data.get("Template_Name_Input");
		String Popup_Input  = Excel_data.get("Popup_Input");
		String Click_Port_Code_Header  = Excel_data.get("Click_Port_Code_Header");

		
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

		Step_Start(4, "Apply filters, sort columns, or adjust the layout “template”)", test, test1);
		formatLocatorClick(driver, Menu_Button, Pin_Port_Code_Header);
		waitForElement(driver, Pin_Column);
		mouseOverToElement(driver, Pin_Column);
		waitForElement(driver, Pin_Right);
		click(driver, Pin_Right);

		if(isColumnPinnedRight(driver, Column_Header, Pin_Port_Code_Header)) {
			System.out.println("The Column header is been moved to the right");
			Extent_pass_New(driver, "The Column header is been moved to the right", test, test1);
		}
		else {
			System.out.println("The Column header is been is not moved to the right");
			Extent_fail(driver, "The Column header is been is not moved to the right", test, test1);

		}

		formatLocatorClick(driver, AM_Table_Column_Header, Click_Port_Code_Header);

		String totalRecords = getText(driver, AM_Total_Records);
		int rowCount = Integer.parseInt(totalRecords);
		List<Map<String, String>> AcendingTable = extractTableDataByRowIndex(driver, AM_Table, rowCount);
		List<String> accendingValues = getValuesByHeader(AcendingTable, Click_Port_Code_Header);
		System.out.println("accendingValues : "+ accendingValues);
		if(isSortedAscending(accendingValues)) {
			System.out.println("Expected : The Values in the Table should be in the Accending Order" + " || Actual : The values in the Table is in the Accending Order");
			Extent_pass_New(driver,"Expected : The Values in the Table should be in the Accending Order" + " || Actual : The values in the Table is in the Accending Order " , test, test1);
		}
		else {
			System.out.println("Expected : The Values in the Table should be in the Accending Order" + " || Actual : The values in the Table is not in the Accending Order");
			Extent_fail(driver,"Expected : The Values in the Table should be in the Accending Order" + " || Actual : The values in the Table is not in the Accending Order" , test, test1);
		}

		waitForDisplay(driver, AM_Table);
		scrollGridToTop(driver, AM_Table);

		formatLocatorClick(driver, AM_Table_Column_Header, Click_Port_Code_Header);

		List<Map<String, String>> DescendingTable = extractTableDataByRowIndex(driver, AM_Table, rowCount);
		List<String> descendingValues = getValuesByHeader(DescendingTable, Click_Port_Code_Header);
		isSortedDescending(descendingValues);
		if(isSortedDescending(descendingValues)) 
		{
			System.out.println("Expected : The Values in the Table should be in the Descending Order" + " || Actual : The values in the Table is in the Descending Order");
			Extent_pass_New(driver,"Expected : The Values in the Table should be in the Descending Order" + " || Actual : The values in the Table is in the Descending Order " , test, test1);
		}
		else {
			System.out.println("Expected : The Values in the Table should be in the Descending Order" + " || Actual : The values in the Table is not in the Descending Order");
			Extent_fail(driver,"Expected : The Values in the Table should be in the Descending Order" + " || Actual : The values in the Table is not in the Descending Order" , test, test1);

		}

		Step_End(4, "Apply filters, sort columns, or adjust the layout “template”)", test, test1);

		Step_Start(5, "Locate and click the settings or gear icon that opens the options menu", test, test1);

		waitForElement(driver, AM_ToolPanel);
		click(driver, AM_ToolPanel);
		Step_End(5, "Locate and click the settings or gear icon that opens the options menu", test, test1);

		Step_Start(6, "In the pop-up options, click the first icon labeled “Save Template.”", test, test1);

		waitForElement(driver, AM_Save_Template);
		click(driver, AM_Save_Template);
		Step_End(6, "In the pop-up options, click the first icon labeled “Save Template.”", test, test1);

		Step_Start(7, "A dialog or input box should appear.Enter a unique name for the template", test, test1);

		waitForElement(driver, AM_Template_Name);
		sendKeys(driver, AM_Template_Name, Template_Name_Input);
		Step_End(7, "A dialog or input box should appear.Enter a unique name for the template", test, test1);

		Step_Start(8, "Click the Save or OK button", test, test1);

		waitForElement(driver, AM_Template_Name_Save);
		click(driver, AM_Template_Name_Save);
		Step_End(8, "Click the Save or OK button", test, test1);

		Step_Start(9, "Assert that a success message appears", test, test1);
		
		waitForPopup(driver, Popup_Message, Popup_Input);
		
		String Applied_Duration_Popup = getText(driver, Popup_Message);
		System.out.println(Applied_Duration_Popup);
		
		if (Applied_Duration_Popup.equals(Popup_Input)) {
			System.out.println("Matched || " + " Expected saved poup : " + Popup_Input
					+ " || Actual saved popup : " + Applied_Duration_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + Popup_Input
					+ " || Actual saved popup is : " + Applied_Duration_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + Popup_Input
					+ " || Actual saved popup : " + Applied_Duration_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + Popup_Input
					+ " || Actual saved popup is : " + Applied_Duration_Popup, test, test1);

		}

		Step_End(9, "Assert that a success message appears", test, test1);



		Step_Start(10, "Go back to another tab(Contacts) and Check again whether saved template is appear", test, test1);

		waitForElement(driver, AM_Contacts_Tab);
		click(driver, AM_Contacts_Tab);

		waitForElement(driver, Controlling_Ports_Tab);
		click(driver,Controlling_Ports_Tab );

		if(formatLocatorIsDisplayed(driver, AM_Template_Header, Template_Name_Input)) {
			System.out.println("Expected : The Template Name should be displayed : " + Template_Name_Input + " || Actual : The Template Name is displayed : " + Template_Name_Input);
			Extent_pass_New(driver,"Expected : The Template Name should be displayed : " + Template_Name_Input + " || Actual : The Template Name is displayed : " + Template_Name_Input , test, test1);
		}
		else {
			System.out.println("Expected : The Template Name should be displayed : " + Template_Name_Input + " || Actual : The Template Name is not displayed : " + Template_Name_Input);
			Extent_fail(driver, "Expected : The Template Name should be displayed :  "+ Template_Name_Input +  "|| Actual : The Template Name is not displayed : " + Template_Name_Input, test, test1);
		}

		Step_End(10, "Go back to another tab(Contacts) and Check again whether saved template is appear", test, test1);



		Extent_completed(testcase_Name, test, test1);



	}
}
