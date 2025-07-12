package LRP_Arrival_Notice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_031 extends Keywords {
	public void Arrival_Notice_TS_031(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		//	To Check the system allows to save the multiple records by vessel option in transhipment location and Match the Service,Vessel and Voyage details with Import documentation screen
		String testCaseName="TC_Arrival_Notice_TS_031";

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
		String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");
		String serviceCode=Excel_data.get("ServiceCode");
		String VesselCode=Excel_data.get("VesselCode");
		String voyage=Excel_data.get("Voyage");
		String bound=Excel_data.get("Bound");
		String portCode=Excel_data.get("PortCode");
		String terminalCode=Excel_data.get("TerminalCode");
		String bl_Numbers=Excel_data.get("BL_Number");
		String arrivalNoticeSavedMsg=Excel_data.get("ArrivalNoticeSavedMsg");
		String module_ImportDocumentation=Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String Search_Number=Excel_data.get("Search_Number");
		String Delete_Perform=Excel_data.get("Delete_Perform");
		String AAN_value2=Excel_data.get("AAN_value2");
		
	
		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);




		// Login


		LRP_Login(driver, username, password);

		Step_Start(1, "Make sure the \" AAN \" configuration enabled in agency configuration screen", test, test1);

		// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);

		setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, condition_Filter, agencyUser, attribute1, description1, AAN_value1);
		
	
		Step_End(1, "Make sure the \" AAN \" configuration enabled in agency configuration screen", test, test1);
		Step_Start(2, "Select the agency to save the \"Arrival Notice / Freight Memo\"", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(2, "Select the agency to save the \"Arrival Notice / Freight Memo\"", test, test1);

		Step_Start(3, "Search the module name  ( \"Arrival Notice / Freight Memo\" ) in module search", test, test1);

		//		Arrival Notice


		moduleNavigate(driver, module_ArrivalNotice);

		Extent_cal(test, test1, module_ArrivalNotice);	
		Step_End(3, "Search the module name  ( \"Arrival Notice / Freight Memo\" ) in module search", test, test1);
		Step_Start(4, "Click the new button on tool bar", test, test1);

		newButton(driver);

		Step_End(4, "Click the new button on tool bar", test, test1);
		Step_Start(5, "Choose the option of By vessel option. ", test, test1);

		waitForElement(driver, byVessel_RadioButton);
		click(driver, byVessel_RadioButton);

		Step_End(5, "Choose the option of By vessel option. ", test, test1);
		Step_Start(6, "Enter the valid Discharge service", test, test1);

		waitForElement(driver, dischargeService_Searchfield);
		click(driver, dischargeService_Searchfield);
		waitForElement(driver, dischargeService_Searchfield);
		sendKeys(driver, dischargeService_Searchfield, serviceCode);

		Step_End(6, "Enter the valid Discharge service", test, test1);
		Step_Start(7, "Choose the respective vessel and voyage details", test, test1);
		waitForElement(driver, vesselCode_Filter);
		click(driver, vesselCode_Filter);
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

		Step_End(7, "Choose the respective vessel and voyage details", test, test1);
		Step_Start(8, "Click the Show button", test, test1);

		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);

		Step_End(8, "Click the Show button", test, test1);
		Step_Start(9, "Click edit button on tool bar", test, test1);
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(9, "Click edit button on tool bar", test, test1);
		Step_Start(10, "Select the Multiple  Bl numbers in below grid", test, test1);

		List<String> bl_Nos = splitAndExpand(bl_Numbers);

		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		waitForElement(driver, condition_Filter_AN);
		click(driver, condition_Filter_AN);
		waitForElement(driver, blNumber_Filter_AN);

		for(int i=0;i<bl_Nos.size();i++) {
			String bl_Number=bl_Nos.get(i);

			clear(driver, blNumber_Filter_AN);
			waitForElement(driver, blNumber_Filter_AN);
			sendKeys(driver, blNumber_Filter_AN,bl_Number );

			String select_checkboxX1 =  String.format(Arrival_Notice_Locators.select_Checkbox1,bl_Number); 
			waitForElement(driver, select_checkboxX1);
			click(driver, select_checkboxX1);
		}
		Step_End(10, "Select the Multiple  Bl numbers in below grid", test, test1);

		Step_Start(11, "Click the save button on tool bar", test, test1);
		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, arrivalNoticeSavedMsg);     
		String actualSavedMsg=getText(driver, Popup_Message);
		System.out.println("actualSavedMsg:"+actualSavedMsg);
		if(actualSavedMsg.equals(arrivalNoticeSavedMsg)) {
			Extent_pass(driver, "Matched || Expected popup should be: "+arrivalNoticeSavedMsg+" || Actual popup shown : "+actualSavedMsg, test, test1);
			System.out.println("Matched || Expected popup should be: "+arrivalNoticeSavedMsg+" || Actual popup shown : "+actualSavedMsg);
		}else {
			System.out.println("Not Matched || Expected popup should be: "+arrivalNoticeSavedMsg+" || Actual popup not shown : "+actualSavedMsg);
			Extent_fail(driver, "Not Matched || Expected popup should be: "+arrivalNoticeSavedMsg+" || Actual popup not shown  : "+actualSavedMsg, test, test1);
		}

		String service_AN=getAttribute(driver, dischargeService_Searchfield, "value");
		String vessel_AN=getAttribute(driver, dischargeVessel_Textfield, "value");
		String voyage_AN=getAttribute(driver, dischargeVoyage_Textfield, "value");
		String bound_AN=getAttribute(driver, dischargeBound_Textfield, "value");
		String pod_AN=getAttribute(driver, pod_Textfield, "value");
		String termminal_AN=getAttribute(driver, terminal_Textfield, "value");

		ArrayList<String> vesselDetails_AN=new ArrayList<>();
		vesselDetails_AN.add(service_AN);
		vesselDetails_AN.add(vessel_AN);
		vesselDetails_AN.add(voyage_AN);
		vesselDetails_AN.add(bound_AN);
		vesselDetails_AN.add(pod_AN);
		vesselDetails_AN.add(termminal_AN);

		System.out.println("vesselDetails_AN:"+vesselDetails_AN);

		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		waitForElement(driver, condition_Filter_AN);
		click(driver, condition_Filter_AN);
		waitForElement(driver, blNumber_Filter_AN);

		for(int i=0;i<bl_Nos.size();i++) {
			String bl_Number=bl_Nos.get(i);

			clear(driver, blNumber_Filter_AN);
			waitForElement(driver, blNumber_Filter_AN);
			sendKeys(driver, blNumber_Filter_AN,bl_Number );


			waitForElement(driver, arrivalNotice_Number);
			String generated_AN_Number=getText(driver, arrivalNotice_Number);
			if(!generated_AN_Number.equals("")) {
				Extent_pass(driver, "Generated Arrival Notice Number : "+generated_AN_Number, test, test1);
				System.out.println("Generated Arrival Notice Number : "+generated_AN_Number);
			}}

			
		Step_End(11, "Click the save button on tool bar", test, test1);

		//		Import Documentation

		Step_Start(12, "After saved Open import documentation screen", test, test1);
		Extent_cal(test, test1, module_ImportDocumentation);


		moduleNavigate(driver, module_ImportDocumentation);

		Step_End(12, "After saved Open import documentation screen", test, test1);

		Step_Start(13, "Verify vessel , voyage ,bound and port with terminal", test, test1);

		Step_Start(14, "Match the details with saved \"Arrival Notice / Freight Memo\"", test, test1);

		for(int i1=0;i1<bl_Nos.size();i1++) {
			String bl_Number1=bl_Nos.get(i1);
			waitForElement(driver, SearchButton_Toolbar );
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number1, "","", "","");
			
			
			waitForElement(driver, servicename);
			String service_IMD=getAttribute(driver, servicename, "value");
			String vessel_IMD=getText(driver, vesselCode_ImportDoc);
			String voyage_IMD=getText(driver, voyage_ImportDoc);
			String bound_IMD=getText(driver, bound_ImportDoc);
			String port_IMD=getText(driver, portCode_ImportDoc);
			String terminal_IMD=getText(driver, terminalCode_ImportDoc);

			
			

			
			
			ArrayList<String> serviceDetails_IMD=new ArrayList<>();

			serviceDetails_IMD.add(service_IMD);
			serviceDetails_IMD.add(vessel_IMD);
			serviceDetails_IMD.add(voyage_IMD);
			serviceDetails_IMD.add(bound_IMD);
			serviceDetails_IMD.add(port_IMD);
			serviceDetails_IMD.add(terminal_IMD);


			if(serviceDetails_IMD.equals(vesselDetails_AN)) {
				Extent_pass(driver, "Matched || Service Details Of "+bl_Number1+" || Expected : "+vesselDetails_AN +" || Actual : "+serviceDetails_IMD, test, test1);
				System.out.println("Matched || Service Details Of "+bl_Number1+" || Expected : "+vesselDetails_AN +" || Actual : "+serviceDetails_IMD);
			}else {
				System.out.println("Not Matched || Service Details Of "+bl_Number1+" || Expected : "+vesselDetails_AN +" || Actual : "+serviceDetails_IMD);
				Extent_fail(driver, "Not Matched || Service Details Of "+bl_Number1+" || Expected : "+vesselDetails_AN +" || Actual : "+serviceDetails_IMD, test, test1);
			}
		}
		Step_End(13, "Verify vessel , voyage ,bound and port with terminal", test, test1);

		Step_End(14, "Match the details with saved \"Arrival Notice / Freight Memo\"", test, test1);
		//	Arrival Notice
		scrollTop(driver);

		Extent_cal(test, test1, module_ArrivalNotice);
		waitForElement(driver, arrivalNotice_Module);
		click(driver, arrivalNotice_Module);
		Step_Start(15, "Click the saved Arrival notice bl and click Delete button", test, test1);

		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		waitForElement(driver, condition_Filter_AN);
		click(driver, condition_Filter_AN);
		waitForElement(driver, blNumber_Filter_AN);

		for(int i1=0;i1<bl_Nos.size();i1++) {
			String bl_Number1=bl_Nos.get(i1);
			clear(driver, blNumber_Filter_AN);
			waitForElement(driver, blNumber_Filter_AN);
			sendKeys(driver, blNumber_Filter_AN,bl_Number1 );					
			String Sselect_CheckBox=String.format(Arrival_Notice_Locators.select_Checkbox1, bl_Number1);
			waitForElement(driver, Sselect_CheckBox);
		}

		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(15, "Click the saved Arrival notice bl and click Delete button", test, test1);
		Step_Start(16, "Click Yes and system validates Arrival notice deleted.", test, test1);
		waitForElement(driver, popup_Message);
		if (isDisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);
		} 
		waitForDisplay(driver, Popup_Message);
		String actualMsg=getText(driver, Popup_Message);
		System.out.println("actualMsg : "+actualMsg);
		waitForDisplay(driver, Popup_Message);
		if(isdisplayed(driver, Popup_Message)){
		String actualMsg1=getText(driver, Popup_Message);
		System.out.println("actualMsg : "+actualMsg1);
			System.out.println(actualMsg1+" popup is displayed");
			Extent_pass(driver, actualMsg1+" popup is displayed", test, test1);
		}}
		
		
		
		
	
		
		
		
		Step_End(16, "Click Yes and system validates Arrival notice deleted.", test, test1);

		// Agency Configuration
		setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, condition_Filter, agencyUser, attribute1, description1, AAN_value2);
	
		Extent_completed(testCaseName, test, test1);
	}
}
