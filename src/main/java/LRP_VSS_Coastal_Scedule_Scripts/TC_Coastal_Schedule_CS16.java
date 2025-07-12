package LRP_VSS_Coastal_Scedule_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS16 extends Keywords {


	public void Coastal_Schedule_CS16(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS16";

		String Copied_Popup =Excel_data.get("Copied_Popup");
		String AlreadyExistMsg_Txt =Excel_data.get("AlreadyExistMsg");
		String Copy_Button =Excel_data.get("Copy_Button");
		String Pasted_Popup = Excel_data.get("Pasted_Popup");
		String Username_CS16 =Excel_data.get("Username");
		String Password_CS16 =Excel_data.get("Password");
		String ModuleSearch_CS16 =Excel_data.get("Module_Search");
		String ServiceCode_CS16 =Excel_data.get("Service_Code");
		String VesselCode_CS16 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS16 =Excel_data.get("Voyage_Number");
		String paste_Button_CS15 = Excel_data.get("paste_Button");
		String Cycle_Number_Input= Excel_data.get("Cycle_Number_Input");
		String Voyage_Number_Inputs= Excel_data.get("Voyage_Number_Inputs");
		String date_Picker= Excel_data.get("date_Picker");
		String Voyage_Date= Excel_data.get("Voyage_Date");

		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		
		String button_Select_Copy =  String.format(Coastal_Schedule_Locators.button_Select_Copy, Copy_Button);
		String Voyage =  String.format(Coastal_Schedule_Locators.Voyage_New, voyageNumber_CS16);
		String VoyageVessel =  String.format(Coastal_Schedule_Locators.VoyageVessel, VesselCode_CS16);
		String Newly_Added_Voyage =  String.format(Coastal_Schedule_Locators.Newly_Added_Voyage, Voyage_Number_Inputs,Cycle_Number_Input);
		String Vessel =  String.format(Coastal_Schedule_Locators.Vessel, VesselCode_CS16);
		String button_Select_Paste =  String.format(Coastal_Schedule_Locators.button_Select_Paste, paste_Button_CS15);

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username_CS16, Password_CS16);
		
		moduleNavigate(driver, ModuleSearch_CS16);

		Step_Start(1, "Enter the Service Code  in the service code field", test, test1);
		
		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS16);


		Step_End(1, "Enter the Service Code  in the service code field", test, test1);

		Step_Start(2, "Enter the Vessel ", test, test1);
		
		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS16);


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
		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		Step_Start(4, "click on Voyage that needed to be copied", test, test1);
		
		waitForElement(driver, Voyage);
		click(driver, Voyage);
		Extent_call(test, test1, "Right click on the selected voyage");
		waitForElement(driver, Voyage);
		RightClick(driver, Voyage);
		Extent_call(test, test1, "Copy the selected voyage");
		waitForElement(driver, button_Select_Copy);
		click(driver, button_Select_Copy);
		
		Step_End(4, "click on Voyage that needed to be copied", test, test1);
		waitForPopup(driver, popup_Message, Copied_Popup);
		Step_Start(5, "System shows “Voyage Copied”message", test, test1);
		String popup_Msg = getText(driver, popup_Message);
		if (Copied_Popup.equals(popup_Msg)) {
			System.out.println("Matched || Expected Popup Message was : "+Copied_Popup+" || Actual Popup Message was : "+popup_Msg);
			Extent_pass_New(driver, "Matched || Expected Popup Message was : "+Copied_Popup+" || Actual Popup Message was : "+popup_Msg, test,test1);
		}else {
			System.out.println("Not Matched || Expected Popup Message was : "+Copied_Popup+" || Actual Popup Message was : "+popup_Msg);
			Extent_fail(driver,  "Not Matched || Expected Popup Message was : "+Copied_Popup+" || Actual Popup Message was : "+popup_Msg, test,test1);

		}
		Step_End(5, "System shows “Voyage Copied”message", test, test1);
		click(driver,popup_Message_Ok_Button);
		
		waitForElement(driver, Tree_Structure);
		Step_Start(6, "Right click on the Vessel", test, test1);
		waitForElement(driver, Vessel);
		click(driver, Vessel);
		waitForElement(driver, VoyageVessel);
		RightClick(driver, VoyageVessel);
		
		Step_End(6, "Right click on the Vessel", test, test1);
		Step_Start(7, "Choose Paste Voyage Option", test, test1);
		
		waitForElement(driver, button_Select_Paste);
		click(driver, button_Select_Paste);
		waitForElement(driver, Paste_Ok_Button);
		click(driver, Paste_Ok_Button);
		Step_End(7, "Choose Paste Voyage Option", test, test1);
		Step_Start(8, "If the Voyage has already have the same cycle number as the paste voyage, System should show validation as “Cycle number already exist for the vessel", test, test1);
		waitForPopup(driver, popup_Message, AlreadyExistMsg_Txt);
		String exist_Msg = getText(driver, popup_Message);
		if (AlreadyExistMsg_Txt.equals(exist_Msg)) {
			System.out.println("Matched || Expected Popup Message was : "+AlreadyExistMsg_Txt+" || Actual Popup Message was : "+exist_Msg);
			Extent_pass_New(driver, "Matched || Expected Popup Message was : "+AlreadyExistMsg_Txt+" || Actual Popup Message was : "+exist_Msg, test,test1);
		}else {
			Extent_call(test, test1, "it didn't show -> Cycle number already exist for the vessel");
			System.out.println("Not Matched || Expected Popup Message was : "+AlreadyExistMsg_Txt+" || Actual Popup Message was : "+exist_Msg);
			Extent_fail(driver,  "Not Matched || Expected Popup Message was : "+AlreadyExistMsg_Txt+" || Actual Popup Message was : "+exist_Msg, test,test1);
		}
		Step_End(8, "If the Voyage has already have the same cycle number as the paste voyage, System should show validation as ->Cycle number already exist for the vessel", test, test1);

		click(driver,popup_Message_Ok_Button);

		Step_Start(9, "Edit the Cycle Number", test, test1);
		waitForElement(driver, Cycle_Number_Field);
		clearAndType(driver, Cycle_Number_Field, Cycle_Number_Input);
		Step_End(9, "Edit the Cycle Number", test, test1);
		Step_Start(10, "Edit the voyage Number", test, test1);

		waitForElement(driver, Voyage_Number_Field);
		clearAndType(driver, Voyage_Number_Field, Voyage_Number_Inputs);
		Step_End(10, "Edit the voyage Number", test, test1);
		Step_Start(11, "Edit the Arrival pilot of the first port in the voyage ", test, test1);

		waitForElement(driver, Arrival_Pilot_Date);
		if(date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime(driver, Arrival_Pilot_Date, Voyage_Date);
			
			waitForElement(driver, Cycle_Number_Field);
			click(driver, Cycle_Number_Field);

		}else {
			waitForElement(driver, Arrival_Pilot_Date);
			clearAndType(driver, Arrival_Pilot_Date,Voyage_Date);
			waitForDisplay(driver, calender_close);
			click(driver,calender_close);
		}
		
		Step_End(11, "Edit the Arrival pilot of the first port in the voyage ", test, test1);
		Step_Start(12, "click on Ok", test, test1);
		waitForElement(driver, Paste_Ok_Button);
		click(driver, Paste_Ok_Button);
		Step_End(12, "click on Ok", test, test1);

		Step_Start(13, "System should paste the voyage based on the cycle number ", test, test1);
		waitForDisplay(driver, popup_Message);

		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}
		waitForPopup(driver, popup_Message, Pasted_Popup);
		String Popup_Msg = getText(driver, popup_Message);
		Extent_call(test, test1, "comparing the expected and actual popup messages.....!");
		if (Pasted_Popup.equals(Popup_Msg)) {
			System.out.println("Matched || Expected Popup Message was : "+Pasted_Popup+" || Actual Popup Message was : "+Popup_Msg);
			Extent_pass_New(driver, "Matched || Expected Popup Message was : "+Pasted_Popup+" || Actual Popup Message was : "+Popup_Msg, test,test1);
		}else {
			System.out.println("Not Matched || Expected Popup Message was : "+Pasted_Popup+" || Actual Popup Message was : "+Popup_Msg);
			Extent_fail(driver,  "Not Matched || Expected Popup Message was : "+Pasted_Popup+" || Actual Popup Message was : "+Popup_Msg, test,test1);
		}

		click(driver,popup_Message_Ok_Button);

		waitForDisplay(driver, Newly_Added_Voyage);
		scrollUsingElement(driver, Newly_Added_Voyage);
		if (isdisplayed(driver, Newly_Added_Voyage)) {
			String New_Voyage = getText(driver, Newly_Added_Voyage);
			System.out.println("Matched || Expected : The voyage should be pasted based on the Cycle number || Actual : The voyage is pasted based on the Cycle number || Pasted Voyage Name is : "+New_Voyage);
			Extent_pass_New(driver, "Matched || Expected : The voyage should be pasted based on the Cycle number || Actual : The voyage is pasted based on the Cycle number || Pasted Voyage Name is : "+New_Voyage, test,test1);
		} else {
			System.out.println("Not Matched || TExpected : The voyage should be pasted based on the Cycle number || Actual : The voyage is not pasted based on the Cycle number ");
			Extent_fail(driver, "Not Matched || TExpected : The voyage should be pasted based on the Cycle number || Actual : The voyage is not pasted based on the Cycle number ", test,test1);
		}

		Step_End(13, "System should paste the voyage based on the cycle number ", test, test1);
		Extent_completed(testCaseName, test, test1);


	}
}
