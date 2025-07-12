package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Outstanding_Freight_Report_SC046 extends Keywords {
	public void Outstanding_Freight_ReportSC46(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Throwable {

		String testcase_Name = "TC_Outstanding_Freight_Report_SC046";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Outstanding_Freight_Report_Module = Excel_data.get("Outstanding_Freight_Report_Module");
		String agency_Line = Excel_data.get("Agency_Line");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Selection_Input = Excel_data.get("Selection_Input");
		String Invoice_Type_Input = Excel_data.get("Invoice_Type_Input");
		String Charge_Type_Input = Excel_data.get("Charge_Type_Input");
		String Scope_Input = Excel_data.get("Scope_Input");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Customer_Select_Type = Excel_data.get("Customer_Select_Type");
		String Condition = Excel_data.get("Condition");
		String Customer_Input = Excel_data.get("Customer_Input");
		String Aging_Days_Input = Excel_data.get("Aging_Days_Input");
		String Date_Picker = Excel_data.get("Date_Picker");
		String Date_Input = Excel_data.get("Date_Input");
		String no_Record_Popup = Excel_data.get("no_Record_Popup");

		String ServiceHeader = Excel_data.get("ServiceHeader");
		String VesselHeader = Excel_data.get("VesselHeader");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String PortHeader = Excel_data.get("PortHeader");
		String Terminal_Name_Header = Excel_data.get("Terminal_Name_Header");
		String Agency_Header = Excel_data.get("Agency_Header");

		String condition_Filter = Excel_data.get("condition_Filter");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);
		Step_Start(1, "OutStanding Freight Report, Can be work in both agency and Line", test, test1);

		if (agency_Line.equals("Agency")) {

			SwitchProfile(driver, AgencyUser);

		} else {
			System.out.println("Switched to Line");
			Extent_cal(test, test1, "Switched to Line");
		}

		Step_End(1, "OutStanding Freight Report, Can be work in both agency and Line", test, test1);
		Step_Start(2, "Open Outstanding Freight Report", test, test1);
		moduleNavigate(driver, Outstanding_Freight_Report_Module);
		Step_End(2, "Open Outstanding Freight Report", test, test1);
		if (!Selection_Input.equals("")) {
			waitForElement(driver, ofr_Selection);
			click(driver, ofr_Selection);
			String select_Option = String.format(DropDown_Select, Selection_Input);
			waitForElement(driver, select_Option);
			click(driver, select_Option);
		}
		if (!Selection_Input.equals("")) {
			waitForElement(driver, ofr_Selection);
			click(driver, ofr_Selection);
			String select_Option = String.format(DropDown_Select, Selection_Input);
			waitForElement(driver, select_Option);
			click(driver, select_Option);
		}
		if (!Invoice_Type_Input.equals("")) {
			waitForElement(driver, ofr_Invoice_Type);
			click(driver, ofr_Invoice_Type);
			String select_Option = String.format(DropDown_Select, Invoice_Type_Input);
			waitForElement(driver, select_Option);
			click(driver, select_Option);
		}
		if (!Charge_Type_Input.equals("")) {
			waitForElement(driver, ofr_Charge_Type);
			click(driver, ofr_Charge_Type);
			String select_Option = String.format(DropDown_Select, Charge_Type_Input);
			waitForElement(driver, select_Option);
			click(driver, select_Option);
		}
		if (!Scope_Input.equals("")) {
			waitForElement(driver, ofr_Scope);
			click(driver, ofr_Scope);
			String select_Option = String.format(DropDown_Select, Scope_Input);
			waitForElement(driver, select_Option);
			click(driver, select_Option);
		}
		if (!agency_Line.equals("Agency") && !Scope_Input.equals("")) {
			waitForElement(driver, ofr_Scope_Plus_Button);
			click(driver, ofr_Scope_Plus_Button);
			twoColumnSearchWindow(driver, Agency_Header, condition_Filter, AgencyUser);
		}
		if (!Date_Input.equals("")) {
			waitForElement(driver, ofr_Invoice_Date);
			if (Date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, ofr_Invoice_Date, Date_Input);
			} else {
				waitForElement(driver, ofr_Invoice_Date);
				click(driver, ofr_Invoice_Date);
				clear(driver, ofr_Invoice_Date);
				sendKeys(driver, ofr_Invoice_Date, Date_Input);
				enter(driver);
			}
		}
		if (!Service_Input.equals("")) {
			waitForElement(driver, ofr_Service_Search_Button);
			click(driver, ofr_Service_Search_Button);
			twoColumnSearchWindow(driver, ServiceHeader, condition_Filter, Service_Input);
		}
		if (!Vessel_Input.equals("")) {
			waitForElement(driver, ofr_Vessel_Search_Button);
			click(driver, ofr_Vessel_Search_Button);
			twoColumnSearchWindow(driver, VesselHeader, condition_Filter, Vessel_Input);
		}
		if (!Voyage_Input.equals("")) {
			waitForElement(driver, ofr_Voyage_Search_Button);
			click(driver, ofr_Voyage_Search_Button);
			twoColumnSearchWindow(driver, Voyage_Header, condition_Filter, Voyage_Input);
		}
		if (!Port_Input.equals("")) {
			waitForElement(driver, ofr_Port_Search_Button);
			click(driver, ofr_Port_Search_Button);
			twoColumnSearchWindow(driver, PortHeader, condition_Filter, Port_Input);
		}
		if (!Terminal_Input.equals("")) {
			waitForElement(driver, ofr_Terminal_Search_Button);
			click(driver, ofr_Terminal_Search_Button);
			twoColumnSearchWindow(driver, Terminal_Name_Header, condition_Filter, Terminal_Input);
		}
		if (!Customer_Input.equals("")) {
			waitForElement(driver, ofr_Customer_Search_Button);
			click(driver, ofr_Customer_Search_Button);

			globalValueSearchWindow(driver, Condition, Customer_Select_Type, Customer_Input, "", "", "", "");

		}
		waitForElement(driver, ofr_Aging_Days);
		sendKeys(driver, ofr_Aging_Days, Aging_Days_Input);

		waitForElement(driver, ofr_Show_Button);
		click(driver, ofr_Show_Button);
		waitForDisplay(driver, II_Total_RecordInput);
		String total_Records = getText(driver, II_Total_RecordInput);
		int TotalRecords_Application = Integer.parseInt(total_Records);
		if (TotalRecords_Application != 0) {
			waitForElement(driver, MoreOption_Grid);
			click(driver, MoreOption_Grid);
			waitForElement(driver, II_Download_Excel_Xlsx);
			String downlaoad_Path = downloadFile(driver, II_Download_Excel_Xlsx);
			int row_Count = countNonEmptyRows(downlaoad_Path);
			int TotalRecordsCount_Excel = row_Count - 1;

			if (TotalRecords_Application == TotalRecordsCount_Excel) {
				System.out.println("Matched || Records Count in Application : " + TotalRecords_Application
						+ " ||  Records Count in Excel : " + TotalRecordsCount_Excel);
				Extent_pass_New(driver, "Matched || Records Count in Application : " + TotalRecords_Application
						+ " || Records Count in Excel : " + TotalRecordsCount_Excel, test, test1);
			} else {
				System.out.println("Not Matched || Records Count in Application : " + TotalRecords_Application
						+ " ||  Records Count in Excel : " + TotalRecordsCount_Excel);
				Extent_fail(driver, "Not Matched || Records Count in Application : " + TotalRecords_Application
						+ " || Records Count in Excel : " + TotalRecordsCount_Excel, test, test1);
			}
		} else {
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				String act_Popup = getText(driver, popup_Message);
				if (no_Record_Popup.equals(act_Popup)) {
					System.out.println(
							"Expected result : No popup message should display || Actual result is : " + act_Popup
									+ " Pop-up is Displayed. The Inputs Are Not Valid. Kindly provide valid inputs.");
					Extent_FailNew(driver,
							"Expected result : No popup message should display || Actual result is : " + act_Popup
									+ " Pop-up is Displayed. The Inputs Are Not Valid. Kindly provide valid inputs.",
							test, test1);
				}
			}
		}
		Extent_completed(testcase_Name, test, test1);
	}
}
