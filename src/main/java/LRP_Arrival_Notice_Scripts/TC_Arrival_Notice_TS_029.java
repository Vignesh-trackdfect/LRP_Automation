package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_029 extends Keywords {

	
	public void Arrival_Notice_TS_029(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		//	To Check system allows to save the "Arrival Notice / Freight Memo" through vessel option in Transhipment location
		String testCaseName="TC_Arrival_Notice_TS_029";

		// Get data from test data

		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_AgencyConfiguration=Excel_data.get("Module_AgencyConfiguration");
		String Agency_Code_search = Excel_data.get("Agency_Code_search");
		String Attribute_Search = Excel_data.get("Attribute_Search");
		String attribute1=Excel_data.get("Attribute1");
		String condition_Filter=Excel_data.get("Condition_Filter");
		String description1=Excel_data.get("AttributeDescription1");
		String AAN_value1=Excel_data.get("AAN_value1");
		String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");
		String serviceCode=Excel_data.get("ServiceCode");
		String VesselCode=Excel_data.get("VesselCode");
		String voyage=Excel_data.get("Voyage");
		String bound=Excel_data.get("Bound");
		String portCode=Excel_data.get("PortCode");
		String terminalCode=Excel_data.get("TerminalCode");
		String bl_Number=Excel_data.get("BL_Number");
		String pinkColorCode=Excel_data.get("PinkColorCode");
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
		Step_Start(2, "Open \"Arrival Notice / Freight Memo\"screen (Make sure AAN Agency configuration enabled in agency configuration screen)", test, test1);

		
		setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, condition_Filter, agencyUser, attribute1, description1, AAN_value1);

	
		
		Step_End(2, "Open \"Arrival Notice / Freight Memo\"screen (Make sure AAN Agency configuration enabled in agency configuration screen)", test, test1);
		Step_Start(3, "Click the new button on tool bar", test, test1);

		

	moduleNavigate(driver, module_ArrivalNotice);


		Extent_cal(test, test1, module_ArrivalNotice);	
		
newButton(driver);
		Step_End(3, "Click the new button on tool bar", test, test1);
		Step_Start(4, "Choose the option of By vessel option. ", test, test1);

		waitForElement(driver, byVessel_RadioButton);
		click(driver, byVessel_RadioButton);

		Step_End(4, "Choose the option of By vessel option. ", test, test1);
		Step_Start(5, "Enter the valid Discharge service", test, test1);

		waitForElement(driver, dischargeService_Searchfield);
		click(driver, dischargeService_Searchfield);
		waitForElement(driver, dischargeService_Searchfield);
		sendKeys(driver, dischargeService_Searchfield, serviceCode);

		Step_End(5, "Enter the valid Discharge service", test, test1);
		Step_Start(6, "Choose the respective vessel and voyage details", test, test1);

		waitForElement(driver, vesselCode_Filter);
		click(driver, vesselCode_Filter);
		waitForElement(driver, vesselCode_Filter);
		sendKeys(driver, vesselCode_Filter, VesselCode);

		click(driver, voyageCode_Filter);
		sendKeys(driver, voyageCode_Filter, voyage);

		click(driver, bound_Filter);
		sendKeys(driver, bound_Filter, bound);

		click(driver, portCode_Filter1);
		sendKeys(driver, portCode_Filter1, portCode);

		click(driver, terminal_Filter);
		sendKeys(driver, terminal_Filter, terminalCode);

		waitForElement(driver, retrieved_Service);
		click(driver, retrieved_Service);

		waitForElement(driver, ANgrid_selectbtn);
		click(driver, ANgrid_selectbtn);

		Step_End(6, "Choose the respective vessel and voyage details", test, test1);
		Step_Start(7, "Click the Show button", test, test1);

		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);

		Step_End(7, "Click the Show button", test, test1);
		Step_Start(8, "Click edit button on tool bar", test, test1);
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(8, "Click edit button on tool bar", test, test1);
		Step_Start(9, "Select the displayed Bl number in below grid", test, test1);

		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		waitForElement(driver, condition_Filter_AN);
		click(driver, condition_Filter_AN);
		waitForElement(driver, blNumber_Filter_AN);
		sendKeys(driver, blNumber_Filter_AN,bl_Number );

		String select_checkboxx1 =  String.format(Arrival_Notice_Locators.select_Checkbox1,bl_Number); 
		waitForElement(driver, select_checkboxx1);
		click(driver, select_checkboxx1);

		Step_End(9, "Select the displayed Bl number in below grid", test, test1);
		Step_Start(10, "Click the save button on tool bar", test, test1);
		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, arrivalNoticeSavedMsg);     
		String actualSavedMsg=getText(driver, Popup_Message);
		System.out.println("actualSavedMsg:"+actualSavedMsg);
		if(actualSavedMsg.equals(arrivalNoticeSavedMsg)) {
			Extent_pass(driver, "Matched || Expected : "+arrivalNoticeSavedMsg+" || Actual : "+actualSavedMsg, test, test1);
			System.out.println("Matched || Expected : "+arrivalNoticeSavedMsg+" || Actual : "+actualSavedMsg);
		}else {
			System.out.println("Not Matched || Expected : "+arrivalNoticeSavedMsg+" || Actual : "+actualSavedMsg);
			Extent_fail(driver, "Not Matched || Expected : "+arrivalNoticeSavedMsg+" || Actual : "+actualSavedMsg, test, test1);
		}
		Step_End(10, "Click the save button on tool bar", test, test1);
		Step_Start(11, "Click the saved Arrival notice bl and click Delete button", test, test1);

		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		waitForElement(driver, condition_Filter_AN);
		click(driver, condition_Filter_AN);
		waitForElement(driver, blNumber_Filter_AN);
		sendKeys(driver, blNumber_Filter_AN,bl_Number );

		waitForDisplay(driver, arrivalNotice_Number);
		if(isdisplayed(driver, arrivalNotice_Number)){
		String generated_AN_Number=getText(driver, arrivalNotice_Number);
		if(!generated_AN_Number.equals("")) {
			Extent_pass(driver, "Generated Arrival Notice Number : "+generated_AN_Number, test, test1);
			System.out.println("Generated Arrival Notice Number : "+generated_AN_Number);
		}
		}

		waitForElement(driver, select_checkboxx1);
		click(driver, select_checkboxx1);

		waitForElement(driver, arrivalNotice_Number_Row);
		String actualColour1=getTextBackgroundColor(driver, arrivalNotice_Number_Row);
		String actualColour=getColorName(actualColour1);
		System.out.println("actualColour:"+actualColour);

		if(actualColour.equalsIgnoreCase(pinkColorCode)) {
			
			Extent_pass(driver, "Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row be : "+actualColour, test, test1);
			System.out.println("Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row be : "+actualColour);
		}else {
			System.out.println("Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row not same be : "+actualColour);
			Extent_pass(driver, "Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row not same be : "+actualColour, test, test1);
			
		}
			
		waitForElement(driver, select_checkboxx1);
		click(driver, select_checkboxx1);

		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(11, "Click the saved Arrival notice bl and click Delete button", test, test1);
		Step_Start(12, "Click Yes and system validates Arrival notice deleted.", test, test1);
		waitForElement(driver, popup_Message);
		if (isDisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);
		} 
		waitForDisplay(driver, Popup_Message);
		if(isdisplayed(driver, Popup_Message)){
		String actualMsg=getText(driver, Popup_Message);
		System.out.println("actualMsg : "+actualMsg);
			System.out.println(actualMsg+" popup is displayed");
			Extent_pass(driver, actualMsg+" popup is displayed", test, test1);
		}}
		Step_End(12, "Click Yes and system validates Arrival notice deleted.", test, test1);

		// Agency Configuration
		setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, condition_Filter, agencyUser, attribute1, description1, AAN_value2);
	
		Extent_completed(testCaseName, test, test1);
	}

	
}
