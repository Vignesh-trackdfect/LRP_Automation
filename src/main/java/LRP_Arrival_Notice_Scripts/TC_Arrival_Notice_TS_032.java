package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_032 extends Keywords {
public void Arrival_Notice_TS_032(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

//	To check system allows to save "Arrival Notice / Freight Memo" through Import documentation navigation option  in transhipment location.
	
	String testCaseName="TC_Arrival_Notice_TS_032";

		// Get data from test data

		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_AgencyConfiguration=Excel_data.get("Module_AgencyConfiguration");
		String Agency_Code_search=Excel_data.get("Agency_Code_search");
		String Attribute_Search=Excel_data.get("Attribute_Search");
		String condition_Filter=Excel_data.get("Condition_Filter");
		String attribute1=Excel_data.get("Attribute1");
		String description1=Excel_data.get("AttributeDescription1");
		String AAN_value1=Excel_data.get("AAN_value1");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String Search_Number=Excel_data.get("Search_Number");
		String bl_Number=Excel_data.get("BL_Number");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");
		String arrivalNoticeSavedMsg=Excel_data.get("ArrivalNoticeSavedMsg");
		String pinkColorCode=Excel_data.get("PinkColorCode");
		String AAN_value2=Excel_data.get("AAN_value2");
	
	
		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);



		// Login


		LRP_Login(driver, username, password);
	
		
// Agency Configuration
		
		Extent_cal(test, test1, module_AgencyConfiguration);
		Step_Start(1, "Make sure the \" AAN \" configuration enabled in agency configuration screen", test, test1);

		setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, condition_Filter, agencyUser, attribute1, description1, AAN_value1);
		
			
		moduleNavigate(driver, module_AgencyConfiguration);
		
					
				
				Step_End(1, "Make sure the \" AAN \" configuration enabled in agency configuration screen", test, test1);
			
			// Switch User
				Step_Start(2, "Select the  transhipment agency ", test, test1);

				SwitchProfile(driver, agencyUser);
				
				Step_End(2, "Select the  transhipment agency ", test, test1);
				Step_Start(3, "Open import documentation module", test, test1);

//		Import Documentation
				Extent_cal(test, test1, module_ImportDocumentation);
			
				moduleNavigate(driver, module_ImportDocumentation);

				Step_End(3, "Open import documentation module", test, test1);
				Step_Start(4, "Click the search button ", test, test1);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				
				globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "","", "","");
				
				
				
				
				Step_End(5, "Enter the Bl number and click search", test, test1);
				Step_Start(6, "Select the Bl number in shown window", test, test1);
				
			
				waitForElement(driver, BL_status_IMP_DOC);
				String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
				if(!actual_Master_BL_Status.equals(master_BL_Status)) {
					scrollTop(driver);

					click(driver, SaveButton_ToolBar);
					waitForDisplay(driver, popup_Message);
					if(isDisplayed(driver, popup_Message)) {
						click(driver, popup_Message_Ok_Button);
					}
				}
				
				Step_End(6, "Select the Bl number in shown window", test, test1);
				Step_Start(7, "Click the \"Arrival Notice / Freight Memo\" button ", test, test1);
				
				waitForElement(driver, AN_Arrival_notice_button);
				click(driver, AN_Arrival_notice_button);
				
				Step_End(7, "Click the \"Arrival Notice / Freight Memo\" button ", test, test1);

				Extent_cal(test, test1, module_ArrivalNotice);
				
				Step_Start(8, "Ensure that system navigated to \"Arrival Notice / Freight Memo\" screen ", test, test1);
				scrollTop(driver);

				
				Step_End(8, "Ensure that system navigated to \"Arrival Notice / Freight Memo\" screen ", test, test1);
				Step_Start(9, "Click edit button on tool bar ", test, test1);
				
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
				
				Step_End(9, "Click edit button on tool bar", test, test1);
				Step_Start(10, "Select the displayed Bl number ", test, test1);
				
				waitForElement(driver, Nine_Dotted_Icon);
				click(driver, Nine_Dotted_Icon);
				waitForElement(driver, condition_Filter_AN);
				click(driver, condition_Filter_AN);
				waitForElement(driver, blNumber_Filter_AN);
				sendKeys(driver, blNumber_Filter_AN,bl_Number );
				
				String select_checkboxX1 =  String.format(Arrival_Notice_Locators.select_Checkbox1,bl_Number); 
				waitForElement(driver, select_checkboxX1);
				click(driver, select_checkboxX1);
				
				Step_End(10, "Select the displayed Bl number ", test, test1);
				Step_Start(11, "Click the save button on tool bar ", test, test1);
				scrollTop(driver);

				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				
				waitForPopup(driver, Popup_Message, arrivalNoticeSavedMsg);     
				String actualSavedMsg=getText(driver, Popup_Message);
				System.out.println("actualSavedMsg:"+actualSavedMsg);
				if(actualSavedMsg.equals(arrivalNoticeSavedMsg)) {
					Extent_pass(driver, "Matched || Expected popup: "+arrivalNoticeSavedMsg+" || Actual popup: "+actualSavedMsg, test, test1);
					System.out.println("Matched || Expected popup : "+arrivalNoticeSavedMsg+" || Actual popup: "+actualSavedMsg);
				}else {
					System.out.println("Not Matched || Expected popup: "+arrivalNoticeSavedMsg+" || Actual popup: "+actualSavedMsg);
					Extent_fail(driver, "Not Matched || Expected popup: "+arrivalNoticeSavedMsg+" || Actual popup: "+actualSavedMsg, test, test1);
				}
				String actualETA_AN=getAttribute(driver, eta_Date_Textfield, "value");
				Extent_pass(driver, "Expected || ETA Date in Arrival Notice :"+actualETA_AN, test, test1);
				
				waitForElement(driver, Nine_Dotted_Icon);
				click(driver, Nine_Dotted_Icon);
				waitForElement(driver, condition_Filter_AN);
				click(driver, condition_Filter_AN);
				waitForElement(driver, blNumber_Filter_AN);
				sendKeys(driver, blNumber_Filter_AN,bl_Number );
				
				waitForElement(driver, arrivalNotice_Number);
				String generated_AN_Number=getText(driver, arrivalNotice_Number);
				if(!generated_AN_Number.equals("")) {
					Extent_pass(driver, "Generated Arrival Notice Number : "+generated_AN_Number, test, test1);
					System.out.println("Generated Arrival Notice Number : "+generated_AN_Number);
				}
				
				waitForElement(driver, select_checkboxX1);
				click(driver, select_checkboxX1);
				
				waitForElement(driver, Bl_Records_Background_Colour_AN);
				String actualColour1=getTextBackgroundColor(driver, Bl_Records_Background_Colour_AN);
				String actualColour=getColorName(actualColour1);
				System.out.println("actualColour:"+actualColour);
				if(actualColour.equalsIgnoreCase(pinkColorCode)) {
					Extent_pass(driver, "Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row be : "+actualColour, test, test1);
					System.out.println("Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row be : "+actualColour);
				}else if(!actualColour.equalsIgnoreCase(pinkColorCode)) {
					waitForElement(driver, select_checkboxX1);
					click(driver, select_checkboxX1);
					waitForElement(driver, arrivalNotice_Number_Row);
					actualColour=getTextBackgroundColor(driver, arrivalNotice_Number_Row);
					if(actualColour.equalsIgnoreCase(pinkColorCode)) {
						Extent_pass(driver, "Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row be : "+actualColour, test, test1);
						System.out.println("Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row be : "+actualColour);
					}else {
						System.out.println("Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row not same be : "+actualColour);
						Extent_fail(driver, "Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row not same be : "+actualColour, test, test1);
					}
				}else {
					System.out.println("Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row not same be : "+actualColour);
					Extent_fail(driver, "Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row not same be : "+actualColour, test, test1);
				}
				waitForElement(driver, select_checkboxX1);
				click(driver, select_checkboxX1);
				
				Step_End(11, "Click the save button on tool bar ", test, test1);
				Step_Start(12, "after saved go to import documentation screen ", test, test1);
				scrollTop(driver);

				waitForElement(driver, importDocumentation_Tab);
				click(driver, importDocumentation_Tab);
				
				Step_End(12, "after saved go to import documentation screen ", test, test1);
				
//			Import Documentation
				Extent_cal(test, test1, module_ImportDocumentation);
				
				Step_Start(13, "Check ETA date from  Import documentation screen and match with \"Arrival Notice / Freight Memo\" screen", test, test1);
				waitForElement(driver, eta_Date_ImportDoc);
				String actualETA=getText(driver, eta_Date_ImportDoc);
				
				if(actualETA.equals(actualETA_AN)) {
					Extent_pass(driver, "Matched || Expected date shown in ETA: "+actualETA_AN+" || Actual date shown in ETA; "+actualETA, test, test1);
					System.out.println("Matched || Expected date shown in ETA: "+actualETA_AN+" || Actual date shown in ETA; "+actualETA);
				}else {
					System.out.println("Not Matched || Expected date shown in ETA: "+actualETA_AN+" || Actual date shown in ETA ; "+actualETA);
					Extent_fail(driver, "Not Matched || Expected date shown in ETA: "+actualETA_AN+" || Actual date shown in ETA; "+actualETA, test, test1);
				}
				
				Step_End(13, "Check ETA date from  Import documentation screen and match with \"Arrival Notice / Freight Memo\" screen", test, test1);
				Step_Start(14, "Click the saved Arrival notice bl and click Delete button", test, test1);
				scrollTop(driver);

				waitForElement(driver, arrivalNotice_Module);
				click(driver, arrivalNotice_Module);
				
				waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);
				
				Step_End(14, "Click the saved Arrival notice bl and click Delete button", test, test1);
				Step_Start(15, "Click Yes and system validates Arrival notice deleted.", test, test1);
				
				waitForDisplay(driver, popup_Message);
				if (isDisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Yes_Button);
				} 
				waitForElement(driver, Popup_Message);
				String actualMsg=getText(driver, Popup_Message);
				System.out.println("actualMsg : "+actualMsg);

				if(!actualMsg.equals("")) {
					Extent_pass(driver, actualMsg+" popup is displayed", test, test1);
					System.out.println(actualMsg+" popup is displayed");
				}
				
				Step_End(15, "Click Yes and system validates Arrival notice deleted.", test, test1);
				
	// Agency Configuration
				setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, condition_Filter, agencyUser, attribute1, description1, AAN_value2);
				
				Extent_cal(test, test1, module_AgencyConfiguration);
				Step_Start(16, "Open agency configuration screen", test, test1);

				
			
						Extent_completed(testCaseName, test, test1);
}
}
