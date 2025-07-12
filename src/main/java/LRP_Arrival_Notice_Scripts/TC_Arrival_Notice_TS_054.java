package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_054 extends Keywords {
public void  Arrival_Notice_TS_054(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Arrival_Notice_TS_054";
		// Get data from test data

		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_GlobalConfiguration=Excel_data.get("Module_GlobalConfiguration");
		String attribute=Excel_data.get("Attribute");
		String value1=Excel_data.get("Value");
		String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String Search_Number=Excel_data.get("Search_Number");
		String bl_Number=Excel_data.get("BL_Number");
		
		
		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);

		
		// Switch Agency
		Step_Start(1, "Switch to agency", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, "Switch to agency", test, test1);
		// Global configuration
		setGlobalConfiguration(driver, module_GlobalConfiguration, attribute, value1);

	

	
					
			
				Step_Start(2, "Open arrival notice screen", test, test1);

//		Arrival Notice 
				
			
				moduleNavigate(driver, module_ArrivalNotice);

								
			Extent_cal(test, test1, module_ArrivalNotice);
			
				
				Step_End(2, "Open arrival notice screen", test, test1);
				Step_Start(3, "Click search , paste the Bl number and fetch the record", test, test1);
			
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "", "", "", "");
				
				
			

				Step_End(3, "Click search , paste the Bl number and fetch the record", test, test1);
				Step_Start(4, "Click BL N/N copy button", test, test1);
				
				waitForElement(driver, bl_NO_Searchfield);
		
				String select_checkbox1 =  String.format(Arrival_Notice_Locators.bl_select_box,bl_Number); 
				waitForElement(driver, select_checkbox1);
				click(driver, select_checkbox1);
				
				
				if(isDisplayed(driver, BL_N_N_Copy_Button)  && isElementAccessible(driver, BL_N_N_Copy_Button)) {
					
					Extent_pass(driver, "Matched || Expected Result is :System should showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly. || Actual Result is :System  showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly", test, test1);
					System.out.println("Matched || Expected Result is :System should showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly|| Actual Result is  :System  showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly");
				}else {
					System.out.println("Not Matched || Expected Result is :System should not showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly || Actual Result is:System is not showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly");
					Extent_fail(driver,"Not Matched || Expected Result is :System should not showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly|| Actual Result is System is not showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly", test, test1);
				}
					
					waitForElement(driver, BL_N_N_Copy_Button);
					click(driver, BL_N_N_Copy_Button);
					waitForElement(driver, pdf_Viewer_BL_Number);
					switchToFrame(driver, pdf_Viewer_BL_Number);
				
				Step_End(4, "Click BL N/N copy button", test, test1);
				Step_Start(5, "Ensure print page will be opened and match the BL number with arrival notice screen", test, test1);
				
				waitForElement(driver, pdf_Viewer_BL_Number);     
				String actual_pdfViewer_BL_No=getText(driver, pdf_Viewer_BL_Number);
				if(isDisplayed(driver, BL_N_N_Copy_PDF)) {
					System.out.println("Matched || Expected System should print the BL N/N copy details || Actual system print the BL N/N copy details");
					Extent_pass(driver, "Matched || Expected System should print the BL N/N copy details || Actual system print the BL N/N copy details", test, test1);
				}else {
					System.out.println("Matched || Expected System should not print the BL N/N copy details || Actual system not print the BL N/N copy details");
					Extent_pass(driver, "Matched || Expected System should not print the BL N/N copy details || Actual system not print the BL N/N copy details", test, test1);
				}
				
				if (actual_pdfViewer_BL_No.equals(bl_Number)) {
					System.out.println("Matched || Expected : " + bl_Number + " || Actual : " + actual_pdfViewer_BL_No);
					Extent_pass(driver, "Matched || Expected : " + bl_Number + " || Actual : " + actual_pdfViewer_BL_No, test,
							test1);
				} else {
					System.out.println("Not Matched || Expected : " + bl_Number + " || Actual : " + actual_pdfViewer_BL_No);
					Extent_fail(driver, "Not Matched || Expected : " + bl_Number + " || Actual : " + actual_pdfViewer_BL_No, test,
							test1);
				}
				
				Step_End(5, "Ensure print page will be opened and match the BL number with arrival notice screen", test, test1);
				
				Extent_completed(testCaseName, test, test1);

}
}
