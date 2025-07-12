package LRP_VSS_Integration_Scripts_2;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Coastal_CS15_Long_Term_LT04_IP extends Keywords {

	public void integration_LT04_To_CS15(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_CS15_Long_Term_LT04_IP";

		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String coastal_module = Excel_data.get("coastal_module");
		String longterm_module = Excel_data.get("longterm_module");
		String serviceCodeValue = Excel_data.get("serviceCodeValue");
		String vesselName = Excel_data.get("vesselName");
		String addVessel = Excel_data.get("addVessel");
		String vesselCodeExistPopup = Excel_data.get("vesselCodeExistPopup");
		String copiedPopup = Excel_data.get("copiedPopup");
		String pasteVoyageFrame = Excel_data.get("pasteVoyageFrame");
		String pastedPopup = Excel_data.get("pastedPopup");
		String voyage_num = Excel_data.get("voyage_num");
		String addVesselFrame = Excel_data.get("addVesselFrame");
		String Cycle_Number_Input= Excel_data.get("Cycle_Number_Input");
		String Voyage_Number_Inputs= Excel_data.get("Voyage_Number_Inputs");
		String date_Picker= Excel_data.get("date_Picker");
		String Voyage_Date= Excel_data.get("Voyage_Date");
		String Vessel_Code_Header= Excel_data.get("Vessel_Code_Header");
		String Service_Code_Header= Excel_data.get("Service_Code_Header");
		String Vessel_code_Header_CS= Excel_data.get("Vessel_code_Header_CS");
		String Service_Code_Header_CS= Excel_data.get("Service_Code_Header_CS");
		String Renamed_Popup_Lt= Excel_data.get("Renamed_Popup_Lt");
		String Condition_Filter= Excel_data.get("Condition_Filter");
		

		String voyage = String.format(voyage_Lt,voyage_num);
		
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Open Coastal Schedule", test, test1);

		moduleNavigate(driver, coastal_module);
		

		Step_End(1, "Open Coastal Schedule", test, test1);

		Step_Start(2, "Retreive any Service", test, test1);

			waitForElement(driver, Service_Search_Btn);
		safeclick(driver, Service_Search_Btn);

		twoColumnSearchWindow(driver, Service_Code_Header_CS, Condition_Filter, serviceCodeValue);
	
		waitForElement(driver, Vessel_Search_Btn);
		safeclick(driver, Vessel_Search_Btn);
		twoColumnSearchWindow(driver, Vessel_code_Header_CS, Condition_Filter, vesselName);

		Step_End(2, "Retreive any Service", test, test1);

		Step_Start(3, "Click on Edit Button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		Step_End(3, "Click on Edit Button", test, test1);

		Step_Start(4, "Right click on the Vessel ", test, test1);

		waitForElement(driver, voyage);
		safeclick(driver, voyage);

		waitForElement(driver, vessel_Dropdown);
		safeclick(driver, vessel_Dropdown);
		waitForElement(driver, vessel_Dropdown);
		RightClick(driver, vessel_Dropdown);

		Step_End(4, "Right click on the Vessel ", test, test1);

		Step_Start(5, "Add any Vessel ", test, test1);

		scrollUsingElement(driver, addVessel_Option);
		waitForElement(driver, addVessel_Option);
		click(driver, addVessel_Option);
		waitForDisplay(driver, addVessel_Frame);
		if (isDisplayed(driver, addVessel_Frame)) {
			String actualFrameTextAdd = getText(driver, addVessel_Frame);

			if (actualFrameTextAdd.equals(addVesselFrame)) {
				System.out.println("Matched || " + " Expected Value is : " + addVesselFrame + " || Actual Value is : "
						+ actualFrameTextAdd);
				Extent_pass_New(driver, "Matched || " + " Expected Value is : " + addVesselFrame + " || ActualValue is : "
						+ actualFrameTextAdd, test, test1);
				Extent_pass_New(driver, addVesselFrame + " popup is displayed", test, test1);
				System.out.println(addVesselFrame + " popup is displayed");
			} else {
				System.out.println("Not matched || " + " Expected Value is : " + vesselCodeExistPopup
						+ " || Actual Value  is : " + actualFrameTextAdd);
				Extent_fail(driver, "Not matched || " + " Expected Value is : " + vesselCodeExistPopup
						+ " || Actual Value is : " + actualFrameTextAdd, test, test1);
			}
		}

		waitForElement(driver, addvessel_searchicon);
		click(driver, addvessel_searchicon);
		twoColumnSearchWindow(driver, Vessel_Code_Header, Condition_Filter, addVessel);

	
	
		waitForElement(driver, addVessel_Ok_Button);
		safeclick(driver, addVessel_Ok_Button);

		Step_End(5, "Add any Vessel ", test, test1);

		Step_Start(6, "Create or copy paste of any voyage ", test, test1);

		waitForElement(driver, select_Voyage);
		safeclick(driver, select_Voyage);
		waitForElement(driver, select_Voyage);
		RightClick(driver, select_Voyage);
		waitForElement(driver, copyVoyage_Option);
		scrollUsingElement(driver, copyVoyage_Option);
		safeclick(driver, copyVoyage_Option);

		waitForDisplay(driver, popup_Message);
		if (isDisplayed(driver, popup_Message)) {
			String actualCopiedPopup = getText(driver, popup_Message);

			if (actualCopiedPopup.equals(copiedPopup)) {
				System.out.println("Matched || " + " Expected Value is : " + copiedPopup + " || Actual Value is : "
						+ actualCopiedPopup);
				Extent_pass_New(driver, "Matched || " + " Expected Value is : " + copiedPopup + " || ActualValue is : "
						+ actualCopiedPopup, test, test1);
				Extent_pass_New(driver, copiedPopup + " popup is displayed", test, test1);
				System.out.println(copiedPopup + " popup is displayed");
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not matched || " + " Expected Value is : " + copiedPopup + " || Actual Value  is : "
						+ actualCopiedPopup);
				Extent_fail(driver, "Not matched || " + " Expected Value is : " + copiedPopup + " || Actual Value is : "
						+ actualCopiedPopup, test, test1);
			}
		}
		waitForElement(driver, vessel_2_Dropdown);
		safeclick(driver, vessel_2_Dropdown);
		waitForElement(driver, vessel_2_Dropdown);
		RightClick(driver, vessel_2_Dropdown);
		waitForElement(driver, voyage_Paste);
		scrollUsingElement(driver, voyage_Paste);
		waitForElement(driver, voyage_Paste);
		safeclick(driver, voyage_Paste);

		waitForDisplay(driver, pasteVoyage_Frame);
		if (isDisplayed(driver, pasteVoyage_Frame)) {
			String actualFrameTextPaste = getText(driver, pasteVoyage_Frame);

			if (actualFrameTextPaste.equals(pasteVoyageFrame)) {
				System.out.println("Matched || " + " Expected Value is : " + pasteVoyageFrame + " || Actual Value is : "
						+ actualFrameTextPaste);
				Extent_pass_New(driver, "Matched || " + " Expected Value is : " + pasteVoyageFrame + " || ActualValue is : "
						+ actualFrameTextPaste, test, test1);
				Extent_pass_New(driver, pasteVoyageFrame + " popup is displayed", test, test1);
				System.out.println(pasteVoyageFrame + " popup is displayed");
			} else {
				System.out.println("Not matched || " + " Expected Value is : " + pasteVoyageFrame
						+ " || Actual Value  is : " + actualFrameTextPaste);
				Extent_fail(driver, "Not matched || " + " Expected Value is : " + pasteVoyageFrame
						+ " || Actual Value is : " + actualFrameTextPaste, test, test1);
			}
		}
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
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePickerWithTime(driver, Arrival_Pilot_Date, Voyage_Date);
		} else {
			waitForElement(driver, Arrival_Pilot_Date);
			clearAndType(driver, Arrival_Pilot_Date, Voyage_Date);
		}
		
		
		
		waitForElement(driver, Cycle_ok_button);
		click(driver, Cycle_ok_button);
		waitForDisplay(driver, popup_Message);

		if (isDisplayed(driver, popup_Message)) {
			String actualPastedPopup = getText(driver, popup_Message);

			if (actualPastedPopup.equals(pastedPopup)) {
				System.out.println("Matched || " + " Expected Value is : " + pastedPopup + " || Actual Value is : "
						+ actualPastedPopup);
				Extent_pass_New(driver, "Matched || " + " Expected Value is : " + pastedPopup + " || ActualValue is : "
						+ actualPastedPopup, test, test1);
				Extent_pass_New(driver, pastedPopup + " popup is displayed", test, test1);
				System.out.println(pastedPopup + " popup is displayed");
			} else {
				System.out.println("Not matched || " + " Expected Value is : " + pastedPopup + " || Actual Value  is : "
						+ actualPastedPopup);
				Extent_fail(driver, "Not matched || " + " Expected Value is : " + pastedPopup + " || Actual Value is : "
						+ actualPastedPopup, test, test1);
			}
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(6, "Create or copy paste of any voyage ", test, test1);

		Step_Start(7, "Open Long Term", test, test1);

		// Long Term Creation
		
		
		moduleNavigate(driver, longterm_module);

		scrollTop(driver);

		
		Step_Start(8, "Reterieve the Schedule used previously in Long Term ", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);

		waitForElement(driver, searchIconLT);
		safeclick(driver, searchIconLT);
		twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, serviceCodeValue);

		waitForElement(driver, LongTermsearchOk);
		safeclick(driver, LongTermsearchOk);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		Step_End(8, "Reterieve the Schedule used previously in Long Term ", test, test1);

		scrollBottom(driver);

		Step_Start(9, "rename any 1st cycle vessel to the vessel of the vessel name created in the Coastal", test, test1);

		waitForElement(driver, select_First_vessel);
		click(driver, select_First_vessel);
		waitForElement(driver, select_First_vessel);
		RightClick(driver, select_First_vessel);
		waitForElement(driver, add_Rename_Option);
		scrollUsingElement(driver, add_Rename_Option);
		waitForElement(driver, add_Rename_Option);
		mouseOverToElement(driver, add_Rename_Option);
		waitForElement(driver, rename_Vessel_Option);
		safeclick(driver, rename_Vessel_Option);

		waitForElement(driver, renameFrameLT);
		if (isDisplayed(driver, renameFrameLT_Con)) {
			waitForElement(driver, vessel_search_button);
			click(driver, vessel_search_button);
			twoColumnSearchWindow(driver, Vessel_Code_Header, Condition_Filter, addVessel);

			
			waitForElement(driver, ok_Button_Rename);
			safeclick(driver, ok_Button_Rename);

		} else if (isDisplayed(driver, popup_Message)) {
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message);
			waitForElement(driver, select_Sec_vessel);
			safeclick(driver, select_Sec_vessel);
			waitForElement(driver, select_Sec_vessel);
			RightClick(driver, select_Sec_vessel);
			waitForElement(driver, add_Rename_Option);
			scrollUsingElement(driver, add_Rename_Option);
			waitForElement(driver, add_Rename_Option);
			mouseOverToElement(driver, add_Rename_Option);
			waitForElement(driver, rename_Vessel_Option);
			click(driver, rename_Vessel_Option);
		}
		waitForDisplay(driver, errorData_Continue);
		if (isDisplayed(driver, errorData_Continue)) {
			click(driver, errorData_Continue);
		}
		waitForDisplay(driver, popup_Message);
		if (isDisplayed(driver, popup_Message)) {
			waitForElement(driver, popup_Message);
			String actualExistPopup = getText(driver, popup_Message);
			if (actualExistPopup.equals(vesselCodeExistPopup)) {
				System.out.println("Matched || " + " Expected Value is : " + vesselCodeExistPopup + " || Actual Value is : "
						+ actualExistPopup);
				Extent_pass_New(driver, "Matched || " + " Expected Value is : " + vesselCodeExistPopup + " || ActualValue is : "
						+ actualExistPopup, test, test1);
				Extent_pass_New(driver, vesselCodeExistPopup + " popup is displayed", test, test1);
				System.out.println(vesselCodeExistPopup + " popup is displayed");
			} else if(actualExistPopup.equals(Renamed_Popup_Lt)) {
				System.out.println("Matched || " + " Expected Value is : " + Renamed_Popup_Lt + " || Actual Value is : "
						+ actualExistPopup);
				Extent_pass_New(driver, "Matched || " + " Expected Value is : " + Renamed_Popup_Lt + " || ActualValue is : "
						+ actualExistPopup, test, test1);
				Extent_pass_New(driver, Renamed_Popup_Lt + " popup is displayed", test, test1);
				System.out.println(Renamed_Popup_Lt + " popup is displayed");
			}
				else
			{
				System.out.println("Not matched || " + " Expected Value is : " + vesselCodeExistPopup
						+ " || Actual Value  is : " + actualExistPopup);
				Extent_fail(driver, "Not matched || " + " Expected Value is : " + vesselCodeExistPopup
						+ " || Actual Value is : " + actualExistPopup, test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			waitForElement(driver, cancel_Button);
			safeclick(driver, cancel_Button);
		}
		else {
			System.out.println("Expected Result is : Vessel Exist popup should be display || Actual Result is :  Vessel Exist popup not display");
			Extent_fail(driver, "Expected Result is : Vessel Exist popup should be display || Actual Result is :  Vessel Exist popup not display", test, test1);
		}
		Step_End(9, "rename any 1st cycle vessel to the vessel of the vessel name created in the Coastal", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}
