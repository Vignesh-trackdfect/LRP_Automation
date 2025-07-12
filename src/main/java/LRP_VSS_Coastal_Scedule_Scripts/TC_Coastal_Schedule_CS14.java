package LRP_VSS_Coastal_Scedule_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS14 extends Keywords {

	public void Coastal_Schedule_CS14(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS14";
		String Portcode = Excel_data.get( "Portcode");
		String Change_BoundsValue = Excel_data.get( "Change_BoundValue");
		String voyage_valuefield = Excel_data.get( "voyage_fieldvalue");
		String distance_valuefield = Excel_data.get( "Distance_Value");
		String speed_valuefield = Excel_data.get( "Speed_Value");
		String buffer_valuefield = Excel_data.get( "Buffer_Value");
		String Mantimein_Valuefield = Excel_data.get( "Mantimein_Value");
		String Mantimeout_Valuefield = Excel_data.get( "Mantimeout_Value");
		String Terminaltime_Valuefield = Excel_data.get( "Terminaltime_Value");
		String Move_Coastal_schedule = Excel_data.get( "Move_Coastalschedule");
		String Voyage_Saved = Excel_data.get( "Voyage_saved");
		String Username_CS14 =Excel_data.get("Username");
		String Password_CS14 =Excel_data.get("Password");
		String ModuleSearch_CS14 =Excel_data.get("Module_Search");
		String ServiceCode_CS14 =Excel_data.get("Service_Code");
		String VesselCode_CS14 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS14 =Excel_data.get("Voyage_Number");
		String add_Button_CS14 =Excel_data.get("Button");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		String Voyage_Start_Date = Excel_data.get("Voyage_Start_Date");
		String Voyage_Start_Date_Perform = Excel_data.get("Voyage_Start_Date_Perform");

		String TerminalCodes = Excel_data.get("TerminalCodes");
		String TimeZone_Values = Excel_data.get("TimeZone_Values");
		String Marine_Distance = Excel_data.get("Marine_Distance");


		String Voyage =  String.format(Coastal_Schedule_Locators.Voyage_Selec, voyageNumber_CS14);
		String button_Select =  String.format(Coastal_Schedule_Locators.button_Select, add_Button_CS14);

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		
		
		LRP_Login(driver, Username_CS14, Password_CS14);
		
		moduleNavigate(driver, ModuleSearch_CS14);


		Step_Start(1, "Enter the Service Code  in the service code field", test, test1);

		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS14);
		
		Step_End(1, "Enter the Service Code  in the service code field", test, test1);

		Step_Start(2, "Enter the Vessel ", test, test1);
		
		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS14);
		
		Step_End(2, "Enter the Vessel ", test, test1);	

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForDisplay(driver, Tree_Structure);
		if(isdisplayed(driver,Tree_Structure)) {
			Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
			System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
		}else {
			System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

			Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
		}

		Step_Start(4, "Click on Any voyage ", test, test1);
		waitForElement(driver, Voyage);
		click(driver, Voyage);
		Step_End(4, "Click on Any voyage ", test, test1);

		Step_Start(5, "Right Click on it ", test, test1);
		waitForElement(driver, Voyage);
		RightClick(driver, Voyage);
		Step_End(5, "Right Click on it ", test, test1);

		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

		Step_Start(6, "Choose Add voyage option", test, test1);
		waitForElement(driver, button_Select);
		click(driver, button_Select);
		Step_End(6, "Choose Add voyage option", test, test1);

		Step_Start(7, "Add Voyage Window appears", test, test1);
		Step_Start(8, "Enter the voyage number in the field ", test, test1);
		waitForElement(driver, voyage_field);
		click(driver, voyage_field);
		sendKeys(driver, voyage_field, voyage_valuefield);

		if(Voyage_Start_Date_Perform.equalsIgnoreCase("Yes")) {
			selectDatePickerWith_Time(driver, voyage_Start_Date, Voyage_Start_Date);
		}
		
		Step_End(8, "Enter the voyage number in the field ", test, test1);
		List<String> port_Codes = splitAndExpand(Portcode,",");

		List<String> terminalCodes = splitAndExpand(TerminalCodes,",");

		List<String> distance_valuefields = splitAndExpand(distance_valuefield,",");
		List<String> speed_valuefields = splitAndExpand(speed_valuefield,",");
		List<String> Change_BoundsValues = splitAndExpand(Change_BoundsValue,",");
		List<String> buffer_valuefields = splitAndExpand(buffer_valuefield,",");
		List<String> Mantimein_Valuefields = splitAndExpand(Mantimein_Valuefield,",");
		List<String> Mantimeout_Valuefields = splitAndExpand(Mantimeout_Valuefield,",");
		List<String> Terminaltime_Valuefields = splitAndExpand(Terminaltime_Valuefield,",");
		for(int i = 0;i<port_Codes.size();i++) {
		Step_Start(9, "Enter the Port Code in the port field ", test, test1);
		waitForElement(driver, port_field);
		click(driver, port_field);
		String portCode=port_Codes.get(i);
		sendKeys(driver, port_field, portCode);
		
		String TerminalCode=terminalCodes.get(i);
		String select_Port_Terminal=String.format(Port_Terminal_Select, portCode,TerminalCode);
		waitForElement(driver, select_Port_Terminal);
		click(driver, select_Port_Terminal);
		
		Step_End(9, "Enter the Port Code in the port field ", test, test1);
		
		
		Actions action = new Actions(driver);
		
		Step_Start(10, "Enter the Distance field value", test, test1);
		waitForElement(driver, Distance_field);
		click(driver, Distance_field_input);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(distance_valuefields.get(i)).perform();
		Step_End(10, "Enter the Distance field value", test, test1);

		Step_Start(11, "Enter the Speed Field value ", test, test1);
		waitForElement(driver, Speed_value);
		click(driver, Speed_value_input);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(speed_valuefields.get(i)).perform();
		
		
		waitForElement(driver, Timezonefield);
		String port1timezonevalue = getAttribute(driver, Timezonefield, "value");
		System.out.println("timezonevalue :" + port1timezonevalue);

		if(!TimeZone_Values.equals("")) {
			List<String> timeZone_Values = splitAndExpand(TimeZone_Values,",");
			String TimeZone=timeZone_Values.get(i);
			clearAndType(driver, Timezonefield, TimeZone);
		}
		
		waitForElement(driver, sub_bound_dropdown);
		click(driver, sub_bound_dropdown);
		Step_End(11, "Enter the Speed Field value ", test, test1);

		Step_Start(12, "Enter the Bound value from the drop-down", test, test1);
		Extent_call(test, test1, "If the Bound is Pivot Enter the Pivot Voyage number ");
		String Bound_Value =  String.format(Coastal_Schedule_Locators.Bound_Value, Change_BoundsValues.get(i));
		waitForElement(driver, Bound_Value);
		click(driver, Bound_Value);
		waitForElement(driver, Added_Bound_Value);
		String bound1Dropdownoption=getText(driver, Added_Bound_Value);
		System.out.println(bound1Dropdownoption);
		if (bound1Dropdownoption.equals( Change_BoundsValues.get(i))) {
			System.out.println("Matched || Expected value was : " + Change_BoundsValues.get(i) + " || Actual value was : "+ bound1Dropdownoption);
			Extent_pass_New(driver, "Matched || Expected value was : " + Change_BoundsValues.get(i) + " || Actual value was : "+ bound1Dropdownoption, test,test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + Change_BoundsValues.get(i)+ " || Actual value was : " + bound1Dropdownoption);
			Extent_fail(driver, "NotMatched || Expected value was : " + Change_BoundsValues.get(i)+ " || Actual value was : " + bound1Dropdownoption, test,test1);
		}
		Step_End(12, "Enter the Bound value from the drop-down", test, test1);


		Step_Start(14, "Enter the Buffer time ", test, test1);
		waitForElement(driver, buffer_timefield_input);
		click(driver, buffer_timefield);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(buffer_valuefields.get(i)).perform();
		
		Step_End(14, "Enter the Buffer time ", test, test1);

		Step_Start(15, ".Enter Man Time in field", test, test1);
		waitForElement(driver, Mantimein_field_input);
		click(driver, Mantimein_field_input);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(Mantimein_Valuefields.get(i)).perform();
		
		Step_End(15, ".Enter Man Time in field", test, test1);

		Step_Start(16, "Enter Man Time out field", test, test1);
		waitForElement(driver, Mantimeout_field_input);
		click(driver, Mantimeout_field_input);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(Mantimeout_Valuefields.get(i)).perform();
		
		Step_End(16, "Enter Man Time out field", test, test1);

		Step_Start(17, "Enter the Terminal Time Field", test, test1);
		waitForElement(driver, Terminaltime_field);
		click(driver, Terminaltime_field);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(Terminaltime_Valuefields.get(i)).perform();
		
		Step_End(17, "Enter the Terminal Time Field", test, test1);

		Step_Start(18, "Click on Add Button", test, test1);
		waitForElement(driver, Addvoyage);
		click(driver, Addvoyage);
		Step_End(18, "Click on Add Button", test, test1);

		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);
		}
		Step_Start(19, "System should add the Port Details in the Port Grid", test, test1);

		if (formatLocatorIsDisplayed(driver, Added_Port_Value, port_Codes.get(i))) {
			System.out.println("Matched || Expected The Port Should be Added || Actual Port is added the port value is : " + port_Codes.get(i));
			Extent_pass_New(driver,"Matched || Expected The Port Should be Added || Actual Port is added the port value is : " + port_Codes.get(i), test,test1);
		} else {
			System.out.println("Matched || Expected The Port Should be Added || Actual Port is Not added ");
			Extent_fail(driver,"Matched || Expected The Port Should be Added || Actual Port is Not added ",test,test1);
		}
	}

		Step_End(19, "System should add the Port Details in the Port Grid", test, test1);

		Step_Start(20, "Time zone Should be captured from the Port Master for the Port added", test, test1);

		Step_End(21, "Repear the process from Step 9 - Step 19", test, test1);

		Step_Start(22, "Click on Move to Coastal Schedule button ", test, test1);
		waitForElement(driver, Movetocoastalschedule);
		click(driver, Movetocoastalschedule);
		Step_End(22, "Click on Move to Coastal Schedule button ", test, test1);

		Step_Start(23, "System should show Confirmation message  ”Are you sure to move to Coastal Schedule ?”", test, test1);
		waitForPopup(driver, popup_Message, Move_Coastal_schedule);
		String Costalschedule_Popupmessage = getText(driver, popup_Message);
		if (Costalschedule_Popupmessage.equals(Move_Coastal_schedule)) {
			System.out.println("Matched || Expected Popup : " + Move_Coastal_schedule + " || Actual Popup : "
					+ Costalschedule_Popupmessage);
			Extent_pass_New(driver, "Matched || Expected Popup : " + Move_Coastal_schedule + " || Actual Popup : "
					+ Costalschedule_Popupmessage, test,test1);
		} else {
			System.out.println("NotMatched || Expected Popup : " + Move_Coastal_schedule + " || Actual Popup : "
					+ Costalschedule_Popupmessage);
			Extent_fail(driver, "NotMatched || Expected Popup : " + Move_Coastal_schedule
					+ " || Actual Popup : " + Costalschedule_Popupmessage, test,test1);
		}
		Step_End(23, "System should show Confirmation message  ”Are you sure to move to Coastal Schedule ?”", test, test1);
		Step_Start(24, "Click on Yes", test, test1);
		click(driver, popup_Message_Yes_Button);
		
		waitForDisplay(driver, marineDistance_Gridcell_CS);
		if(isdisplayed(driver, marineDistance_Gridcell_CS)) {
			click(driver, marineDistance_Gridcell_CS);
			waitForElement(driver, marineDistance_Gridcell_Input_CS);
			clearAndType(driver, marineDistance_Gridcell_Input_CS, Marine_Distance);
			enter(driver);
			waitForElement(driver, marineDistance_Ok_Button_CS);
			click(driver, marineDistance_Ok_Button_CS);

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}
		
		Step_End(24, "Click on Yes", test, test1);
		waitForPopup(driver, popup_Message, Voyage_Saved);
		String Costalschedule_addedpopupmessage = getText(driver, popup_Message);
		System.out.println("Costal schedule added popup message was : " + Costalschedule_addedpopupmessage);
		if (Costalschedule_addedpopupmessage.equals(Voyage_Saved)) {
			System.out.println("Matched || Expected Popup : " + Voyage_Saved + " || Actual Popup : "+ Costalschedule_addedpopupmessage);
			Extent_pass_New(driver, "Matched || Expected Popup : " + Voyage_Saved + " || Actual Popup : "+ Costalschedule_addedpopupmessage, test,test1);
		} else {
			System.out.println("Not Matched || Expected Popup : " + Voyage_Saved + " || Actual Popup : "+ Costalschedule_addedpopupmessage);
			Extent_fail(driver, "Not Matched || Expected Popup : " + Voyage_Saved + " || Actual Popup : "+ Costalschedule_addedpopupmessage, test,test1);
		}
		click(driver, popup_Message_Ok_Button);
		Step_Start(25, "System should add the voyage with the cycle number incremented with the preivous last voyage in the vessel", test, test1);
		waitForElement(driver, Last_Added_Voyage_name);
		String Addedvoyagename = getText(driver, Last_Added_Voyage_name);
		System.out.println("Added voyage name was : " + Addedvoyagename);
		if (Addedvoyagename.contains(voyage_valuefield) ) {
			System.out.println("Matched || Added voyage sequence number was next to the previous voyage sequence number");
			Extent_pass_New(driver, "Matched || Added voyage sequence number was next to the previous voyage sequence number", test,test1);

		} else {
			System.out.println("Not Matched || Added voyage sequence number was not next to the previous voyage sequence number");
			Extent_fail(driver, "Not Matched || Added voyage sequence number was not next to the previous voyage sequence number",test,test1);
		}
		Step_End(25, "System should add the voyage with the cycle number incremented with the preivous last voyage in the vessel", test, test1);
		
		Extent_completed(testCaseName, test, test1);
	}

}
