package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_029 extends Keywords {

	public void Ecommerce_Gateway_Validator_029(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_029";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Ecomm_Gateway_Module = Excel_data.get("Ecomm_Gateway_Module");
		String Transaction_Type_Value = Excel_data.get("Transaction_Type_Value");
		String From_Date_Value = Excel_data.get("From_Date_Value");
		String To_Date_Value = Excel_data.get("To_Date_Value");
		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String Master_Header_Name = Excel_data.get("Master_Header_Name");
		String Routing_Value = Excel_data.get("Routing_Value");
		String Service_Value = Excel_data.get("Service_Value");
		String Vessel_Value = Excel_data.get("Vessel_Value");
		String Voyage_Value = Excel_data.get("Voyage_Value");
		String Bound_Value = Excel_data.get("Bound_Value");
		String No_Schedule_Poup = Excel_data.get("No_Schedule_Poup");
		String Schedule_Not_Available_Popup = Excel_data.get("Schedule_Not_Available_Popup");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Ecomm_Gateway_Module);

		Step_Start(1, " Enter the Agreement Party  ", test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		String Transaction_type_Select = String.format(EG_Select_Transaction_type, Transaction_Type_Value);
		waitForElement(driver, Transaction_type_Select);
		click(driver, Transaction_type_Select);

		waitForElement(driver, EG_NonProcessed_Checkbox);
		checkBox(driver, EG_NonProcessed_Checkbox, NonProcessed_yes);

		waitForElement(driver, EG_FromDate_Input);
		selectDatePicker(driver, EG_FromDate_Input, From_Date_Value);

		waitForElement(driver, EG_ToDate_Input);
		selectDatePicker(driver, EG_ToDate_Input, To_Date_Value);

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

		waitForDownload(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Retrieved_Record_AG_Gridcell);
		doubleClick(driver, EG_Retrieved_Record_AG_Gridcell);
		
		Step_End(1, " Enter the Agreement Party  ", test, test1);

		Step_Start(2, "  Enter the POL and POD and select the Rates using Rates window   ", test, test1);

		waitForElement(driver, Header_Panel_EComm_Validator);
		if (IsElementEnabled(driver, Edit_Button_toolBar)) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			if (isDisplayed(driver, popup_Message_Ok_Button)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			}
		}

		String Master_header = String.format(Header_Panel_List_Ecomm_Validator, Master_Header_Name);
		waitForElement(driver, Master_header);
		click(driver, Master_header);

		Step_Start(3, " click Route button (EDIT)  ", test, test1);

		waitForElement(driver, Routing_Add_Btn_EComm_Validator);
		click(driver, Routing_Add_Btn_EComm_Validator);

		String Select_Routing = String.format(Routing_Select_ECom_Validator, Routing_Value, Service_Value);

		waitForElement(driver, Select_Routing);
		scrollElementToCenter(driver, Select_Routing);
		waitForElement(driver, Select_Routing);
		click(driver, Select_Routing);
		waitForElement(driver, ok);
		click(driver, ok);
		
		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			String Popup_Act = getText(driver, popup_Message);
			if (Popup_Act.equals(No_Schedule_Poup) || Popup_Act.equals(Schedule_Not_Available_Popup)) {
				System.out.println(
						"Expected : Given Routing input Shedule should be present || Actual : Given Routing input shedule is not present ,  Popup msg "
								+ Popup_Act);
				Extent_FailNew(driver,
						"Expected : Given Routing input Shedule should be present || Actual : Given Routing input shedule is not present ,  Popup msg "
								+ Popup_Act,
						test, test1);
			} else {
				System.out.println(
						"Expected : Routing Should be Selected without any popup after selecting it || Actual : Popup displayed after Selecting the routing,  Popup : "
								+ Popup_Act);
				Extent_fail(driver,
						"Expected : Routing Should be Selected without any popup after selecting it || Actual : Popup displayed after Selecting the routing,  Popup : "
								+ Popup_Act,
						test, test1);
			}
		}

		waitForElement(driver, Routing_Service_value_EV);
		String Actual_Routing_Service = getText(driver, Routing_Service_value_EV);
		if (Actual_Routing_Service.equals(Service_Value)) {
			System.out.println("Expected : Selected Routing Service ('" + Service_Value
					+ "') Should be update in the Routing Column || Actual : Selected Routng Serivice is updated in the Routing Column ('"
					+ Actual_Routing_Service + "')");
			Extent_pass_New(driver, "Expected : Selected Routing Service ('" + Service_Value
					+ "') Should be update in the Routing Column || Actual : Selected Routng Serivice is updated in the Routing Column ('"
					+ Actual_Routing_Service + "')", test, test1);
		} else {
			System.out.println("Expected : Selected Routing Service ('" + Service_Value
					+ "') Should be update in the Routing Column || Actual : Selected Routng Serivice is not updated in the Routing Column ('"
					+ Actual_Routing_Service + "')");
			Extent_fail(driver, "Expected : Selected Routing Service ('" + Service_Value
					+ "') Should be update in the Routing Column || Actual : Selected Routng Serivice is not updated in the Routing Column ('"
					+ Actual_Routing_Service + "')", test, test1);
		}

		waitForElement(driver, Routing_terminal_EV);
		String Routing_Terminal = getText(driver, Routing_terminal_EV);

		Step_End(3, " click Route button (EDIT)  ", test, test1);
		Step_End(2, "  Enter the POL and POD and select the Rates using Rates window   ", test, test1);

		Step_Start(4, " Select the Schedule  ", test, test1);

		waitForElement(driver, Service_Input_EComm_Validator);
		clear(driver, Service_Input_EComm_Validator);
		waitForElement(driver, Service_Input_EComm_Validator);
		sendKeys(driver, Service_Input_EComm_Validator, Actual_Routing_Service);

		waitForElement(driver, Vessel_Search_Input_Ecomm_Validator);
		sendKeys(driver, Vessel_Search_Input_Ecomm_Validator, Vessel_Value);

		waitForElement(driver, Voyage_Search_Input_Ecomm_Validator);
		sendKeys(driver, Voyage_Search_Input_Ecomm_Validator, Voyage_Value);

		waitForElement(driver, Bound_Search_Input_Ecomm_Validator);
		sendKeys(driver, Bound_Search_Input_Ecomm_Validator, Bound_Value);

		waitForElement(driver, First_Row_EComm_Validator);
		click(driver, First_Row_EComm_Validator);

		waitForElement(driver, Select_Button_EComm_Validator);
		click(driver, Select_Button_EComm_Validator);

		Step_End(4, " Select the Schedule  ", test, test1);

		Step_Start(5, "routing and and schedule terminal should be same  ", test, test1);

		waitForElement(driver, Schedule_terminal_EV);
		String Act_Service_Terminal = getText(driver, Schedule_terminal_EV);
		if (Act_Service_Terminal.contains(Routing_Terminal)) {
			System.out.println(
					"Expected : Routing Terminal and Schedule Terminal should be Same || Actaul : Routing Terminal and Schedule Terminal is Same ");
			Extent_pass_New(driver,
					"Expected : Routing Terminal and Schedule Terminal should be Same || Actaul : Routing Terminal and Schedule Terminal is  Same ",
					test, test1);
		} else {
			System.out.println(
					"Expected : Routing Terminal and Schedule Terminal should be Same || Actaul : Routing Terminal and Schedule Terminal is not Same ");
			Extent_fail(driver,
					"Expected : Routing Terminal and Schedule Terminal should be Same || Actaul : Routing Terminal and Schedule Terminal is not Same ",
					test, test1);
		}

		Step_End(5, "routing and and schedule terminal should be same  ", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
