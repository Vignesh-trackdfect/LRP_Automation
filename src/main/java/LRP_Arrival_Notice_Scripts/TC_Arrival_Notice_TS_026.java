package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_026 extends Keywords{
	
	public void Arrival_Notice_TS_026(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

//	To check system allows to Retrieve "Arrival Notice / Freight Memo" for house bl and house bl no should be matched with Import docuementation screen
		String testCaseName="TC_Arrival_Notice_TS_026";
		
		// Get data from test data

		
		


		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String HBL_search = Excel_data.get("HBL_search");
		String HBL_Number = Excel_data.get("HBL_Number");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String globalSearchOption = Excel_data.get("GlobalSearchOption");
	
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);
		// Login


		LRP_Login(driver, username, password);

	// Switch User
		Step_Start(1, " Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);

		
		Step_End(1, " Switch the agency ", test, test1);
//	Arrival Notice
		Extent_cal(test, test1, module_ArrivalNotice);

		Step_Start(2, "Search the module name  ( \"Arrival Notice / Freight Memo\" ) in module search", test, test1);

		
		moduleNavigate(driver, module_ArrivalNotice);

		
		
		Step_End(2, "Search the module name  ( \"Arrival Notice / Freight Memo\" ) in module search", test, test1);

		Step_Start(3, "Click the search button", test, test1);
//	Retrieve HBL Number	
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		
		
		globalValueSearchWindow(driver, dropdownCondition1, HBL_search, HBL_Number, "","", "","");
		
		
	
		Step_End(3, "Click the search button", test, test1);
		Step_Start(4, "Enter the house Bl number or \"Arrival Notice / Freight Memo\" number", test, test1);
		
		Step_End(4, "Enter the house Bl number or \"Arrival Notice / Freight Memo\" number", test, test1);
		Step_Start(5, "Select the record from grid and fecth the details", test, test1);
		
		
		
		
		Step_End(5, "Select the record from grid and fecth the details", test, test1);
		Step_Start(6, "Ensure system showing the BL details", test, test1);
		
		waitForElement(driver, bl_NO_Searchfield);
		String actual_BL_Number=getAttribute(driver, bl_NO_Searchfield, "value");
		if(!actual_BL_Number.equals("")) {
			Extent_pass(driver, "Matched || Expected System Should showing the BL details || Actual System  showing the BL details", test, test1);
			System.out.println("Matched || Expected System Should showing the BL details || Actual System  showing the BL details");
			
		}else {
			System.out.println("Matched || Expected System Should showing the BL details || Actual System  not showing the BL details");
			Extent_fail(driver, "Matched || Expected System Should showing the BL details || Actual System not showing the BL details", test, test1);
			

		}
		
		Step_End(6, "Ensure system showing the BL details", test, test1);
		Step_Start(7, "Copy the House bl number", test, test1);
		
		Extent_pass(driver, "House BL Number : "+HBL_Number, test, test1);
		System.out.println("House BL Number : "+HBL_Number);
		
		Step_End(7, "Copy the House bl number", test, test1);
		
		// Import Documentation 
		Extent_cal(test, test1, module_ImportDocumentation);
		Step_Start(8, "Open Import documentation ", test, test1);
		
		
		moduleNavigate(driver, module_ImportDocumentation);

		
		
		waitForElement(driver, ANimportDocumentation_Tab);


		Step_End(8, "Open Import documentation ", test, test1);
		Step_Start(9, "Click search button paste the House BL no. by \" HBL \" and fetch the Bl", test, test1);
//		Retrieve HBL Number	
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		
		globalValueSearchWindow1(driver, dropdownCondition1, globalSearchOption, HBL_Number, "","", "","");
		
		
		String retrieve_IMD = String.format(retrieved_Value, actual_BL_Number);
		System.out.println(retrieve_IMD);
		waitForElement(driver, ANGridselect);
		click(driver, ANGridselect);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);

		Step_End(9, "Click search button paste the House BL no. by \" HBL \" and fetch the Bl", test, test1);
		
		Step_Start(10, "Select the House BL from HBL.NO drop down", test, test1);
		waitForElement(driver, hbl_Dropdown);
		waitForElement(driver, hbl_Dropdown);
		click(driver, hbl_Dropdown);
		String select_HBL=String.format(houseBL_Option, HBL_Number);
		click(driver, select_HBL);
		
		Step_End(10, "Select the House BL from HBL.NO drop down", test, test1);
		
		Step_Start(11, "Go to BL/Housebl summary tab", test, test1);
		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver, BL_HBL_Summary_Tab);
		

		Step_End(11, "Go to BL/Housebl summary tab", test, test1);
		Step_Start(12, "Match the copied house bl no with Arrival notice screen", test, test1);
		waitForPopup(driver, bl_HBL_Textfield_Summary_Tab, HBL_Number);      
		String actualHBL_No=getAttribute(driver, bl_HBL_Textfield_Summary_Tab, "value");
		
		if(actualHBL_No.equals(HBL_Number)) {
			Extent_pass(driver, "Matched || Expected hbl number should be shown: "+HBL_Number+" || Actual HBL Number shown as: "+actualHBL_No, test, test1);
			System.out.println("Matched || Expected hbl number should be shown: "+HBL_Number+" || Actual HBL Number shown as: "+actualHBL_No);
		}else {
			System.out.println("Not Matched || Expected hbl number should be shown: "+HBL_Number+" || Actual HBL Number is not shown : "+actualHBL_No);
			Extent_fail(driver, "Not Matched || Expected hbl number should be shown: "+HBL_Number+" || Actual HBL Number is not shown : "+actualHBL_No, test, test1);
		}
		Step_End(12, "Match the copied house bl no with Arrival notice screen", test, test1);
		
		Extent_completed(testCaseName, test, test1);
		
	}

}
