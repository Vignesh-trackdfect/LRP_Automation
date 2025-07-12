package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_032 extends Keywords {

	public void Ecommerce_Gateway_Validator_032(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_032";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String Transaction_Type = Excel_data.get("Transaction_Type");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");

		String DateCheckbox_Status = Excel_data.get("DateCheckbox_Status");
		String Given_From_Date = Excel_data.get("Given_From_Date");
		String Given_To_Date = Excel_data.get("Given_To_Date");
		String DatePicker = Excel_data.get("DatePicker");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Autoleg_Configuration_Module_Name = Excel_data.get("Autoleg_Configuration_Module_Name");
		String SearchBy_Service = Excel_data.get("SearchBy_Service");
		String SearchBy_POL = Excel_data.get("SearchBy_POL");
		String SearchBy_POD = Excel_data.get("SearchBy_POD");
		String GlobalSearchDropdown_Condition = Excel_data.get("GlobalSearchDropdown_Condition");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		Step_Start(1,"select the agency",test, test1);

		SwitchProfile(driver, AgencyName);

		Step_End(1,"select the agency",test, test1);
		Step_Start(2,"Click the refresh button on the e-commerce gateway.",test, test1);

		moduleNavigate(driver, Module_Name);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForDownload(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, Transaction_Type);

		if (DateCheckbox_Status.equals("Yes")) {

			checkBox(driver, EG_byDate_Checkbox, DateCheckbox_Status);

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_FromDate_Input);
				selectDatePicker(driver, EG_FromDate_Input, Given_From_Date);

			} else {

				waitForElement(driver, EG_FromDate_Input);
				clear(driver, EG_FromDate_Input);
				sendKeys(driver, EG_FromDate_Input, Given_From_Date);

			}

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_ToDate_Input);
				selectDatePicker(driver, EG_ToDate_Input, Given_To_Date);

			} else {

				waitForElement(driver, EG_ToDate_Input);
				clear(driver, EG_ToDate_Input);
				sendKeys(driver, EG_ToDate_Input, Given_To_Date);

			}

		} else {

			waitForElement(driver, EG_FromDate_Input);

			Given_From_Date = getAttribute(driver, EG_FromDate_Input, "value");
			Given_To_Date = getAttribute(driver, EG_ToDate_Input, "value");

		}

		waitForElement(driver, EG_NonProcessed_Checkbox);
		checkBox(driver, EG_NonProcessed_Checkbox, NonProcessed_yes);

		if (Archive_Condition.equals("Yes")) {

			waitForElement(driver, EG_Archive_Checkbox);
			checkBox(driver, EG_Archive_Checkbox, Archive_Condition);

		}

		if (!Booking_Number.equals("")) {
			waitForElement(driver, EG_BookingNo_input);
			sendKeys(driver, EG_BookingNo_input, Booking_Number);
		}

		if (!Reference_Number.equals("")) {
			waitForElement(driver, EG_ReferenceNo_Input);
			sendKeys(driver, EG_ReferenceNo_Input, Reference_Number);
		}

		if (!bl_NumberInput.equals("")) {
			waitForElement(driver, EG_BLNo_input);
			sendKeys(driver, EG_BLNo_input, bl_NumberInput);
		}

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		Step_End(2,"Click the refresh button on the e-commerce gateway.",test, test1);
		Step_Start(3,"Booking records show a grid.",test, test1);

		waitForElement(driver, EG_Retrieved_Record_AG_Gridcell);
		Step_End(3,"Booking records show a grid.",test, test1);
		Step_Start(4,"Select SI row and double-click the e-commerce validator corrector module",test, test1);

		doubleClick(driver, EG_Retrieved_Record_AG_Gridcell);

		Step_End(4,"Select SI row and double-click the e-commerce validator corrector module",test, test1);
	
		waitForElement(driver, POL_Value_Ecom);
		String polValue=getText(driver, POL_Value_Ecom);
		System.out.println("polValue : "+polValue);
		
		waitForElement(driver, POD_Value_Ecom);
		String podValue=getText(driver, POD_Value_Ecom);
		System.out.println("podValue : "+podValue);
		
		waitForElement(driver, Service);
		String serviceValue=getAttribute(driver, Service, "value");
		System.out.println("serviceValue : "+serviceValue);
		
		Step_Start(5,"Click the Edit button",test, test1);

		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(5,"Click the Edit button",test, test1);
		Step_Start(6,"auto leg configuration module  to serach the bound, POL and POD retrive ",test, test1);

		moduleNavigate(driver, Autoleg_Configuration_Module_Name);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		Step_Start(7,"Select the Booking bound and  auto leg configuration bound different schedule not form the leg",test, test1);

		globalValueSearchWindow(driver, GlobalSearchDropdown_Condition, SearchBy_Service, serviceValue, SearchBy_POL, polValue, SearchBy_POD, podValue);
		
		Step_End(6,"auto leg configuration module  to serach the bound, POL and POD retrive ",test, test1);

		waitForElement(driver, LoadBound_Gridcell_ALC);
		String BoundValue_ALC=getText(driver, LoadBound_Gridcell_ALC);
		System.out.println("BoundValue_ALC : "+BoundValue_ALC);
		
		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		waitForElement(driver, Booking_Module_Navigate_Button);
		click(driver, Booking_Module_Navigate_Button);
		
		
		waitForElement(driver, Bound_Value_Booking);
		String bound_Booking=getText(driver, Bound_Value_Booking);
		System.out.println("bound_Booking : "+bound_Booking);
		
		
		if(bound_Booking.equals(BoundValue_ALC)) {
			System.out.println("Not Matched || Bound in Auto Leg Configuration Module : "+BoundValue_ALC+" || Bound in Booking Module : "+bound_Booking);
			Extent_pass_New(driver, "Not Matched || Bound in Auto Leg Configuration Module : "+BoundValue_ALC+" || Bound in Booking Module : "+bound_Booking, test, test1);
		}else {
			System.out.println("Matched || Bound in Auto Leg Configuration Module : "+BoundValue_ALC+" || Bound in Booking Module : "+bound_Booking);
			Extent_fail(driver, "Matched || Bound in Auto Leg Configuration Module : "+BoundValue_ALC+" || Bound in Booking Module : "+bound_Booking, test, test1);
		
		}
		
		Step_End(7,"Select the Booking bound and  auto leg configuration bound different schedule not form the leg",test, test1);

//		Step_End(5,"Ecommerce validator correcter header tap missmatch details between booking si & BL popup validation should shown",test, test1);
//		
//		scrollTop(driver);
//		waitForElement(driver, Close_Current_tab);
//		click(driver, Close_Current_tab);
//		
//		Step_Start(6,"popup validation msg(The header information between the SI and the Booking/BL is mismatched. Please confirm if you want to refresh the data from the Booking/BL.)   ",test, test1);
//
//		waitForElement(driver, Accept_Btn_EComm_Validator);
//		click(driver, Accept_Btn_EComm_Validator);
//		
//		waitForPopup(driver, Header_Mismatch_Popup, Mismatch_Popup);
//		String actualPopup=getText(driver, Header_Mismatch_Popup);
//		if(actualPopup.equals(Mismatch_Popup)) {
//			System.out.println("Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup);
//			Extent_pass_New(driver, "Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup, test, test1);
//		}else {
//			System.out.println("Not Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup);
//			Extent_fail(driver, "Not Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup, test, test1);
//		
//		}
//		
//		Step_End(6,"popup validation msg(The header information between the SI and the Booking/BL is mismatched. Please confirm if you want to refresh the data from the Booking/BL.)   ",test, test1);
//		Step_Start(7,"click (cancel) in popup validation msg",test, test1);
//
//		waitForElement(driver, Header_Mismatch_Popup_Cancel_Button);
//		click(driver, Header_Mismatch_Popup_Cancel_Button);
//		
//		Step_End(7,"click (cancel) in popup validation msg",test, test1);
//		Step_Start(8,"Click (yes) booking latest details updated in SI header tap system auto refresh the details in  header tab ",test, test1);
//
//		waitForElement(driver, Accept_Btn_EComm_Validator);
//		click(driver, Accept_Btn_EComm_Validator);
//		
//		waitForPopup(driver, Header_Mismatch_Popup, Mismatch_Popup);
//		 actualPopup=getText(driver, Header_Mismatch_Popup);
//		if(actualPopup.equals(Mismatch_Popup)) {
//			System.out.println("Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup);
//			Extent_pass_New(driver, "Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup, test, test1);
//		}else {
//			System.out.println("Not Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup);
//			Extent_fail(driver, "Not Matched || Expected Popup : "+Mismatch_Popup+" || Actual Popup : "+actualPopup, test, test1);
//		
//		}
//		
//		waitForElement(driver, Header_Mismatch_Popup_Yes_Button);
//		click(driver, Header_Mismatch_Popup_Yes_Button);
//		
//		waitForElement(driver, Vessel_Details_TextArea);
//		String vesselDetails_Ecom_After=getAttribute(driver, Vessel_Details_TextArea, "value");
//		System.out.println("vesselDetails_Ecom_After : "+vesselDetails_Ecom_After);
//		
//		if(vesselDetails_Booking.equals(vesselDetails_Ecom_After)) {
//			System.out.println("Matched || Vessel details in E Com Validator : "+vesselDetails_Ecom_After+" || Vessel details in Booking : "+vesselDetails_Booking);
//			Extent_pass_New(driver, "Matched || Vessel details in E Com Validator : "+vesselDetails_Ecom_After+" || Vessel details in Booking : "+vesselDetails_Booking, test, test1);
//		}else {
//			System.out.println("Not Matched || Vessel details in E Com Validator : "+vesselDetails_Ecom_After+" || Vessel details in Booking : "+vesselDetails_Booking);
//			Extent_fail(driver, "Not Matched || Vessel details in E Com Validator : "+vesselDetails_Ecom_After+" || Vessel details in Booking : "+vesselDetails_Booking, test, test1);
//		
//		}
//		
//		Step_End(8,"Click (yes) booking latest details updated in SI header tap system auto refresh the details in  header tab ",test, test1);

		
		Extent_completed(testcase_Name, test, test1);
	}

}
