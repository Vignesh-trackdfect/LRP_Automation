package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_028 extends Keywords {
	public void Arrival_Notice_TS_028(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		//	To Check system allows to save the  "Arrival Notice / Freight Memo" in Transhipment location
		String testCaseName="TC_Arrival_Notice_TS_028";

		// Get data from test data

		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_AgencyConfiguration=Excel_data.get("Module_AgencyConfiguration");
		String Agency_Code_search = Excel_data.get("Agency_Code_search");
		String Attribute_Search = Excel_data.get("Attribute_Search");
		String Condition_Filter=Excel_data.get("Condition_Filter");
		String attribute1=Excel_data.get("Attribute1");
		String description1=Excel_data.get("AttributeDescription1");
		String AAN_value1=Excel_data.get("AAN_value1");
		String module_ImportDocumentation=Excel_data.get("Module_ImportDocumentation");
		String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String Search_Number = Excel_data.get("Search_Number");
		String bl_Number=Excel_data.get("BL_Number");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String locationTranshipment=Excel_data.get("LocationTranshipment");
		String arrivalNoticeSavedMsg=Excel_data.get("ArrivalNoticeSavedMsg");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String AAN_value2=Excel_data.get("AAN_value2");
		
	

		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);




		// Login

		LRP_Login(driver, username, password);

		// Switch User
		Step_Start(1, "Select Transhipment agency", test, test1);
		SwitchProfile(driver, agencyUser);

		Step_End(1, "Select Transhipment agency", test, test1);

		// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);
		Step_Start(2, "Open agency configuration screen", test, test1);
		setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, Condition_Filter, agencyUser, attribute1, description1, AAN_value1);

		//		

	
		Step_End(6, "set the value as Y for both", test, test1);

		Step_Start(7, "Ensure that Import documentation saved in transhipment location for bl ", test, test1);

		//		Import Documentation 

		Extent_cal(test, test1, module_ImportDocumentation);


		
		moduleNavigate(driver, module_ImportDocumentation);



		
		waitForElement(driver, SearchButton_Toolbar );
		click(driver, SearchButton_Toolbar);
		
		
		
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "","", "","");
		
		
		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
		if(!actual_Master_BL_Status.equals(master_BL_Status)) {
			click(driver, SaveButton_ToolBar);
			waitForElement(driver, popup_Message);
			if(isDisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Ok_Button);
			}
		}

		waitForDisplay(driver, cargoType);     
		String actualLocation=getText(driver, cargoType);
		if(actualLocation.equals(locationTranshipment)) {
			Extent_pass(driver, "Matched || Expected Location should be shown: "+locationTranshipment+" || Actual Location  shown : "+actualLocation, test, test1);
			System.out.println("Matched || Expected Location should be shown : "+locationTranshipment+" || Actual Location  shown: "+actualLocation);
		}else {
			System.out.println("Not Matched || Expected Location should be shown: "+locationTranshipment+" || Actual Location was not shown: "+actualLocation);
			Extent_fail(driver, "Not Matched || Expected Location should be shown: "+locationTranshipment+" || Actual Location was not shown: "+actualLocation, test, test1);
		}

		Step_End(7, "Ensure that Import documentation saved in transhipment location for bl ", test, test1);
		Step_Start(8, "Click the \"Arrival Notice / Freight Memo\" button ", test, test1);

		click(driver, AN_Arrival_notice_button);

		Step_End(8, "Click the \"Arrival Notice / Freight Memo\" button ", test, test1);
		Step_Start(9, "System will navigates to \"Arrival Notice / Freight Memo\" screen click edit", test, test1);
		Extent_cal(test, test1, module_ArrivalNotice);	

		waitForElement(driver, arrivalNotice_Module);
		
		scrollTop(driver);

		click(driver, Edit_Button_toolBar);

		Step_End(9, "System will navigates to \"Arrival Notice / Freight Memo\" screen click edit", test, test1);
		Step_Start(10, "Select the respected bl and click save button", test, test1);

		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		waitForElement(driver, condition_Filter_AN);
		click(driver, condition_Filter_AN);
		waitForElement(driver, blNumber_Filter_AN);
		sendKeys(driver, blNumber_Filter_AN,bl_Number );
		String select_checkbox1 =  String.format(Arrival_Notice_Locators.select_Checkbox1,bl_Number); 
		waitForElement(driver, select_checkbox1);
		click(driver, select_checkbox1);

		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, arrivalNoticeSavedMsg);     
		String actualSavedMsg=getText(driver, Popup_Message);
		System.out.println("actualSavedMsg:"+actualSavedMsg);
		if(actualSavedMsg.equals(arrivalNoticeSavedMsg)) {
			Extent_pass(driver, "Matched || Expected popup should be shown: "+arrivalNoticeSavedMsg+" || Actual popup  shown: "+actualSavedMsg, test, test1);
			System.out.println("Matched || Expected popup should be shown: "+arrivalNoticeSavedMsg+" || Actual popup  shown : "+actualSavedMsg);
		}else {
			System.out.println("Not Matched || Expected popup should be shown: "+arrivalNoticeSavedMsg+" || Actual popup not shown: "+actualSavedMsg);
			Extent_fail(driver, "Not Matched || Expected popup should be shown : "+arrivalNoticeSavedMsg+" || Actual popup not shown: "+actualSavedMsg, test, test1);
		}
		Step_End(10, "Select the respected bl and click save button", test, test1);
		Step_Start(11, "Click the saved Arrival notice bl and click Delete button", test, test1);

		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		waitForElement(driver, condition_Filter_AN);
		click(driver, condition_Filter_AN);
		waitForElement(driver, blNumber_Filter_AN);
		sendKeys(driver, blNumber_Filter_AN,bl_Number );

		waitForElement(driver, arrivalNotice_Number);
		String generated_AN_Number=getText(driver, arrivalNotice_Number);
		if(!generated_AN_Number.equals("")) {
			
			Extent_pass(driver, "Matched || Expected Generated Arrival Notice Number : "+generated_AN_Number+" || Actual Generated Arrival Notice Number: "+generated_AN_Number, test, test1);
			System.out.println("Matched || Expected Generated Arrival Notice Number : "+generated_AN_Number+" || Actual Generated Arrival Notice Number: "+generated_AN_Number);
		}else {
			System.out.println("Not Matched || Expected Generated Arrival Notice Number : "+generated_AN_Number+" || Actual not Generated Arrival Notice Number: "+generated_AN_Number);
			Extent_fail(driver, "Not Matched || Expected Generated Arrival Notice Number : "+generated_AN_Number+" || Actual not Generated Arrival Notice Number : "+generated_AN_Number, test, test1);
		}
		

		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(11, "Click the saved Arrival notice bl and click Delete button", test, test1);
		Step_Start(12, "Click Yes and system validates Arrival notice deleted.", test, test1);
		waitForDisplay(driver, popup_Message);
		if (isDisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);
		} 
		waitForDisplay(driver, Popup_Message);
		if(isdisplayed(driver, Popup_Message)){
		String actualMsg=getText(driver, Popup_Message);
		System.out.println("actualMsg : "+actualMsg);
			System.out.println(actualMsg+" popup is displayed");
			Extent_pass(driver, actualMsg+" popup is displayed", test, test1);
		}
		}
		
		setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, Condition_Filter, agencyUser, attribute1, description1, AAN_value2);

		Step_End(12, "Click Yes and system validates Arrival notice deleted.", test, test1);

		
		Extent_completed(testCaseName, test, test1);
	}
}
