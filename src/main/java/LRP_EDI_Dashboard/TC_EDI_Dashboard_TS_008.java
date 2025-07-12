package LRP_EDI_Dashboard;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Dashboard_TS_008 extends Keywords{
	public void EDI_Dashboard_TS_008(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EDI_Dashboard_TS_008";
	
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String EDI_Dashboard_Module = Excel_data.get("EDI_Dashboard_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String Column_condition = Excel_data.get("Column_condition");
		String Agency_Code_Input = Excel_data.get("Agency_Code_Input");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID_Value = Excel_data.get("EDI_ID_Value");
		String Mess_Function_Drop_Down = Excel_data.get("Mess_Function_Drop_Down");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String POL = Excel_data.get("POL");
		String Operation_Type_Dropdown = Excel_data.get("Operation_Type_Dropdown");

		
	     Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);
		moduleNavigate(driver, EDI_Dashboard_Module);
		

		Step_Start(1, "Enter the agency code (AEESAD)",test, test1);
		
		waitForElement(driver, EDI_DB_Agency_Button);
		click(driver,EDI_DB_Agency_Button);
		
		twoColumnSearchWindow(driver, AgencyCode_Header, Column_condition, Agency_Code_Input);
		
		Step_End(1, "Enter the agency code (AEESAD)",test, test1);	
		
		Step_Start(2, "Enter the EDI details (EDI312)",test, test1);	
		
		waitForElement(driver, EDI_DB_EDI_Buttton);
		click(driver,EDI_DB_EDI_Buttton);
		
		
		twoColumnMultipleSearchWindow(driver, EDI_ID_Header, Column_condition, EDI_ID_Value);
		
		Step_End(2, "Enter the EDI details (EDI312)",test, test1);	
			
		Step_Start(3, "Select the New and Update option in the mes.function ",test, test1);	
		
		waitForDisplay(driver, EDI_DB_Mess_Function_Dropdwn);
		if(	IsElementEnabled(driver, EDI_DB_Mess_Function_Dropdwn)) {
			
			waitForElement(driver, EDI_DB_Mess_Function_Dropdwn);
			click(driver, EDI_DB_Mess_Function_Dropdwn);
			formatLocatorClick(driver, EDI_DB_Select_Mess_fuction, Mess_Function_Drop_Down);
			
		}
		
		Step_End(3, "Select the New and Update option in the mes.function ",test, test1);
		
		Step_Start(4, "Select the operation type(Export) ",test, test1);	

	
		waitForDisplay(driver, EDI_DB_Operation_Type_DropDown);
		if(IsElementEnabled(driver, EDI_DB_Operation_Type_DropDown)) {
			
			waitForElement(driver, EDI_DB_Operation_Type_DropDown);
			click(driver, EDI_DB_Operation_Type_DropDown);
			
			formatLocatorClick(driver, EDI_DB_Operation_Type_Option, Operation_Type_Dropdown);
		}
		Step_End(4, "Select the operation type(Export) ",test, test1);
	
		Step_Start(5, "Select Service code field (0610) ",test, test1);	
		Step_Start(6, "Select any data from the favorite search",test, test1);	
		
		waitForElement(driver, EDI_Service_Code_Input);
		sendKeys(driver, EDI_Service_Code_Input, Service_Code);

		waitForElement(driver, EDI_DB_Vessel_input);
		clear(driver, EDI_DB_Vessel_input);
		waitForElement(driver, EDI_DB_Vessel_input);
		sendKeys(driver, EDI_DB_Vessel_input, Vessel_Code);

		waitForElement(driver, EDI_DB_Voyage_Input);
		clear(driver, EDI_DB_Voyage_Input);
		waitForElement(driver, EDI_DB_Voyage_Input);
		sendKeys(driver, EDI_DB_Voyage_Input, Voyage);

		waitForElement(driver, EDI_DB_Bound);
		clear(driver, EDI_DB_Bound);
		waitForElement(driver, EDI_DB_Bound);
		sendKeys(driver, EDI_DB_Bound, Bound);

		waitForElement(driver, EDI_DB_Pol_Input);
		clear(driver, EDI_DB_Pol_Input);
		waitForElement(driver, EDI_DB_Pol_Input);
		sendKeys(driver, EDI_DB_Pol_Input, POL);
		
		waitForElement(driver, EDI_DB_Service_First_Row);
		doubleClick(driver, EDI_DB_Service_First_Row);
		
		
		Step_End(6, "Select any data from the favorite search",test, test1);	
		Step_End(5, "Select Service code field (0610) ",test, test1);	
		
		Step_Start(7, "Click the report view check box ",test, test1);	
	
		waitForElement(driver, EDI_DB_Report_Check_Box);
		click(driver,EDI_DB_Report_Check_Box);
		
		Step_End(7, "Click the report view check box ",test, test1);	
		
		Step_Start(8, "User can't able to click the  Generate EDI\r\n"+ "button and rest button  ",test, test1);	
		
		waitForDisplay(driver, EDI_DB_Generate_EDI_Button);
		if(!IsElementEnabled(driver, EDI_DB_Generate_EDI_Button)) {
			
			System.out.println("Matched: Expected: Once 'Report and View' checkbox is clicked, the 'Generate EDI' button should be disabled and not clickable || Actual: Once 'Report and View' checkbox is clicked, the 'Generate EDI' button is disabled and not clickable");
		    Extent_pass_New(driver, "Matched: Expected: Once 'Report and View' checkbox is clicked, the 'Generate EDI' button should be disabled and not clickable || Actual: Once 'Report and View' checkbox is clicked, the 'Generate EDI' button is disabled and not clickable", test, test1);
		}else {
			
			System.out.println("Not Matched: Expected: Once 'Report and View' checkbox is clicked, the 'Generate EDI' button should be disabled and not clickable || Actual: Once 'Report and View' checkbox is clicked, the 'Generate EDI' button is disabled and  clickable");
		    Extent_fail(driver, "Matched: Expected: Once 'Report and View' checkbox is clicked, the 'Generate EDI' button should be disabled and not clickable || Actual: Once 'Report and View' checkbox is clicked, the 'Generate EDI' button is disabled and  clickable", test, test1);
		}
		
		
		waitForDisplay(driver, EDI_DB_Reset_Button);
		if(!IsElementEnabled(driver, EDI_DB_Reset_Button)) {
			
			System.out.println("Matched: Expected: Once 'Rest' Button checkbox is clicked, the 'Rest' button should be disabled and not clickable || Actual: Once 'Rest'  Button checkbox is clicked, the 'Generate EDI' button is disabled and not clickable");
		    Extent_pass_New(driver, "Matched: Expected: Once 'Rest'  Button checkbox is clicked, the 'Generate EDI' button should be disabled and not clickable || Actual: Once 'Rest'  Button checkbox is clicked, the 'Generate EDI' button is disabled and not clickable", test, test1);
		}else {
			
			System.out.println("Not Matched: Expected: Once 'Rest'  Button checkbox is clicked, the 'Generate EDI' button should be disabled and not clickable || Actual: Once 'Rest'  Button checkbox is clicked, the 'Generate EDI' button is disabled and  clickable");
		    Extent_fail(driver, "Matched: Expected: Once 'Rest'  Button checkbox is clicked, the 'Generate EDI' button should be disabled and not clickable || Actual: Once 'Rest'  Button checkbox is clicked, the 'Generate EDI' button is disabled and  clickable", test, test1);
		}
		
		
		Step_End(8, "User can't able to click the  Generate EDI\r\n"+ "button and rest button  ",test, test1);	
		
		Extent_completed(testcase_Name, test, test1);
		
		
}
}