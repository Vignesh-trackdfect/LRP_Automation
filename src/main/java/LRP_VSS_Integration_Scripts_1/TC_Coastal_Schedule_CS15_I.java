package LRP_VSS_Integration_Scripts_1;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS15_I extends Keywords {

	public void CoastalSchedule15I(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Coastal_Schedule_CS15_I";
		
		


		String Exist_Popup_CS15 = Excel_data.get("Exist_Popup");
		String New_Vessel_Name_CS15 = Excel_data.get("New_Vessel_Name");
		String paste_Button_CS15 = Excel_data.get("paste_Button_CS15");
		String Pasted_Popup_CS15 = Excel_data.get("Pasted_Popup");
		String Cycle_Number_Input_CS15= Excel_data.get("Cycle_Number_Input");
		String Voyage_Number_Inputs_CS15= Excel_data.get("Voyage_Number_Inputs");
		String Username_CS15 =Excel_data.get("Username");
		String Password_CS15 =Excel_data.get("Password");
		String ModuleSearch_CS15 =Excel_data.get("Module_Search");
		String ServiceCode_CS15 =Excel_data.get("Service_Code");
		String VesselCode_CS15 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS15 =Excel_data.get("Voyage_Number");
		String Copy_Button_CS15 =Excel_data.get("Copy_Button");
		String Copied_Popup_CS15 =Excel_data.get("Copied_Popup");
		String add_Button_CS15 =Excel_data.get("Button");
		String search2 = Excel_data.get("Search_Input_2");
		String vessel_Status_Exp = Excel_data.get("Vessel_Status");
		String date_Picker= Excel_data.get("date_Picker");
		String Voyage_Date= Excel_data.get("Voyage_Date");

		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String searchBy = Excel_data.get("SearchBy");

		String Voyage =  String.format(Coastal_Schedule_Locators.Voyage_New, voyageNumber_CS15);
		String Paste_Button =  String.format(Coastal_Schedule_Locators.Paste_Button, paste_Button_CS15);
		String add_Vessel_CS15 =  String.format(Coastal_Schedule_Locators.add_Vessel_CS15, add_Button_CS15);
		String Vessel =  String.format(Coastal_Schedule_Locators.Vessel, VesselCode_CS15);
		String New_Vessel =  String.format(Coastal_Schedule_Locators.New_Vessel, New_Vessel_Name_CS15);
		String copy_Button =  String.format(Coastal_Schedule_Locators.copy_Button, Copy_Button_CS15);

		
		navigateUrl(driver, url);
		
		Extent_Start(testcase_Name, test, test1);

LRP_Login(driver, Username_CS15, Password_CS15);
		
		moduleNavigate(driver, ModuleSearch_CS15);


		Step_Start(1, "Enter the Service Code  in the service code field", test, test1);

		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS15);


		Step_End(1, "Enter the Service Code  in the service code field", test, test1);

		Step_Start(2, "Enter the Vessel ", test, test1);

		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS15);

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
		waitForElement(driver, Voyage);
		click(driver, Voyage);

		Step_Start(4, "Click on Vessel", test, test1);
		waitForElement(driver, Vessel);
		click(driver, Vessel);
		Step_End(4, "Click on Vessel", test, test1);

		Step_Start(5, "Right click on it", test, test1);
		waitForElement(driver, Vessel);
		RightClick(driver, Vessel);
		Step_End(5, "Right click on it", test, test1);

		Step_Start(6, "Choose Add Vessel Option", test, test1);
		waitForElement(driver, add_Vessel_CS15);
		click(driver, add_Vessel_CS15);
		waitForElement(driver, AddVesselBox);
		
		Step_End(6, "Choose Add Vessel Option", test, test1);

		Step_Start(7, "Enter Vessel to be added ", test, test1);
		waitForElement(driver, AddVessel_Search_Button);
		click(driver, AddVessel_Search_Button);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, New_Vessel_Name_CS15);

		waitForElement(driver, Add_Vessel_ok);
		click(driver, Add_Vessel_ok);
		
		Step_End(7, "Enter Vessel to be added ", test, test1);

		Step_Start(8, "If the Vessel is already presented under the same service , system should show validation as “Vessel Code already exisits”", test, test1);
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			String popup = getText(driver, popup_Message);
			if (Exist_Popup_CS15.equals(popup)) {
				System.out.println("Matched || Expected Popup Message was : "+Exist_Popup_CS15+" || Actual Popup Message was : "+popup);
				Extent_pass_New(driver, "Matched || Expected Popup Message was : "+Exist_Popup_CS15+" || Actual Popup Message was : "+popup, test,test1);
			}else {
				System.out.println("NotMatched || Expected Popup Message was : "+Exist_Popup_CS15+" || Actual Popup Message was : "+popup);
				Extent_fail(driver,  "NotMatched || Expected Popup Message was : "+Exist_Popup_CS15+" || Actual Popup Message was : "+popup, test,test1);

			}
			Step_End(8, "If the Vessel is already presented under the same service , system should show validation as “Vessel Code already exisits”", test, test1);

			Step_Start(9, "Click on Ok", test, test1);
			
			click(driver,popup_Message_Ok_Button);
			
			Step_End(9, "Click on Ok", test, test1);
		}else {

			Step_Start(10, "Add the voyage using Add voyage option or Copy paste voyage from the another vessel", test, test1);
			waitForElement(driver, Voyage);
			click(driver, Voyage);
			waitForElement(driver, Voyage);
			RightClick(driver, Voyage);
			waitForElement(driver, copy_Button);
			click(driver, copy_Button);
			Step_End(10, "Add the voyage using Add voyage option or Copy paste voyage from the another vessel", test, test1);

			waitForPopup(driver, popup_Message, Copied_Popup_CS15);
			String popup_Msg = getText(driver, popup_Message);
			if (Copied_Popup_CS15.equals(popup_Msg)) {
				System.out.println("Matched || Expected Popup Message was : "+Copied_Popup_CS15+" || Actual Popup Message was : "+popup_Msg);
				Extent_pass_New(driver, "Matched || Expected Popup Message was : "+Copied_Popup_CS15+" || Actual Popup Message was : "+popup_Msg, test,test1);
			}else {
				System.out.println("NotMatched || Expected Popup Message was : "+Copied_Popup_CS15+" || Actual Popup Message was : "+popup_Msg);
				Extent_fail(driver,  "NotMatched || Expected Popup Message was : "+Copied_Popup_CS15+" || Actual Popup Message was : "+popup_Msg, test,test1);
			}
			click(driver,popup_Message_Ok_Button);
			waitForElement(driver, Tree_Structure);
			waitForElement(driver, New_Vessel);
			click(driver, New_Vessel);

			waitForElement(driver, New_Vessel);
			RightClick(driver, New_Vessel);

			waitForElement(driver, Paste_Button);
			click(driver, Paste_Button);
			waitForElement(driver, Cycle_Number_Field);
			clearAndType(driver, Cycle_Number_Field, Cycle_Number_Input_CS15);
			waitForElement(driver, Voyage_Number_Field);
			clearAndType(driver, Voyage_Number_Field, Voyage_Number_Inputs_CS15);

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
			waitForElement(driver, Paste_Ok_Button);
			click(driver, Paste_Ok_Button);

			waitForDisplay(driver, popup_Message);

			if(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}

			waitForPopup(driver, popup_Message, Pasted_Popup_CS15);
			String Popup_Msg = getText(driver, popup_Message);
			if (Pasted_Popup_CS15.equals(Popup_Msg)) {
				System.out.println("Matched || Expected Popup Message was : "+Pasted_Popup_CS15+" || Actual Popup Message was : "+Popup_Msg);
				Extent_pass_New(driver, "Matched || Expected Popup Message was : "+Pasted_Popup_CS15+" || Actual Popup Message was : "+Popup_Msg, test,test1);
			}else {
				System.out.println("NotMatched || Expected Popup Message was : "+Pasted_Popup_CS15+" || Actual Popup Message was : "+Popup_Msg);
				Extent_fail(driver,  "NotMatched || Expected Popup Message was : "+Pasted_Popup_CS15+" || Actual Popup Message was : "+Popup_Msg, test,test1);
			}
			click(driver,popup_Message_Ok_Button);
		}

		Extent_call(test, test1, "Check the Vessel in Vessel module");

		moduleNavigate(driver, search2);

		waitForElement(driver, P_vessel_NewBtn);
		click(driver, P_vessel_NewBtn);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition, searchBy, New_Vessel_Name_CS15, "", "", "", "");
		
		waitForElement(driver, P_vessel_Status_TxtField);
		String vesselStatus = getText(driver, P_vessel_Status_TxtField);
		if (vessel_Status_Exp.equals(vesselStatus)) {
			System.out.println("Matched || " + " Expected  Vessel Status is : " + vessel_Status_Exp
					+ " || Actual  Vessel Status is : " + vesselStatus);
			Extent_pass_New(driver, "Matched || " + " Expected  Vessel Status is : " + vessel_Status_Exp
					+ " || Actual  Vessel Status is : " + vesselStatus, test,test1);
		} else {
			System.out.println("Not Matched || " + " Expected  Vessel Status is : " + vessel_Status_Exp
					+ " || Actual  Vessel Status is : " + vesselStatus);
			Extent_fail(driver, "Not Matched || " + " Expected  Vessel Status is : " + vessel_Status_Exp
					+ " || Actual  Vessel Status is : " + vesselStatus, test,test1);
		}
		Extent_completed(testcase_Name, test, test1);
	
		
	}

}
