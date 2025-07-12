package LRP_VSS_Integration_Scripts_2;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Coastal_Schedule_CS02H_IP extends Keywords {
	

	public void Coastal_Schedule_CS02H_IP(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS02H_IP";

		// Get data from excel sheet
		
		



		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search_Module_Name = Excel_data.get("Search_Module_Name");
		String ServiceCode = Excel_data.get("ServiceCode");
		String vesselName = Excel_data.get("vesselName");
		String voyage_num1 = Excel_data.get("voyage_num1");
		String PortCode_Value = Excel_data.get("PortCode_Value");
		String CS_BeforePopup_Msg = Excel_data.get("CS_BeforePopup_Msg");
		String Port_Value = Excel_data.get("Port_Value");
		String CS_AfterPopup_Msg = Excel_data.get("CS_AfterPopup_Msg");
		String date_Picker = Excel_data.get("date_Picker");
		String Arr_Pilot_Date = Excel_data.get("Arr_Pilot_Date");
		String Dep_Pilot_Date = Excel_data.get("Dep_Pilot_Date");
		String Select_Columns = Excel_data.get("Select_Columns");
		String table_Name = Excel_data.get("table_Name");
		String Vessel_code_Header_CS = Excel_data.get("Vessel_code_Header_CS");
		String Service_Code_Header_CS = Excel_data.get("Service_Code_Header_CS");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		

		String voyage =  String.format(voyage_, voyage_num1);
		String port_code =  String.format(port_code_, PortCode_Value);
		String Distance_Val =  String.format(Distance_Val_, PortCode_Value);
		String depature_Pilot_Date =  String.format(depature_Pilot_Date_, Port_Value);
		String Arr_Pilot_firstValue =  String.format(Arr_Pilot_firstValue_, Port_Value);
		String Distance_Val1 =  String.format(Distance_Val_, PortCode_Value);
		
		
		

		// Login
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Open Coastal Schedulde", test, test1);
		moduleNavigate(driver, Search_Module_Name);
		Step_End(1, "Open Coastal Schedulde", test, test1);

		Step_Start(2, "Retreive any schedule", test, test1);
		Extent_call(test, test1, "Select Service");
		waitForElement(driver, Service_Search_Btn);
		safeclick(driver, Service_Search_Btn);

		twoColumnSearchWindow(driver, Service_Code_Header_CS, Condition_Filter, ServiceCode);
	
		waitForElement(driver, Vessel_Search_Btn);
		safeclick(driver, Vessel_Search_Btn);
		twoColumnSearchWindow(driver, Vessel_code_Header_CS, Condition_Filter, vesselName);

		Step_End(2, "Retreive any schedule", test, test1);

		Step_Start(3, "Click on Edit Button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		Step_End(3, "Click on Edit Button", test, test1);

		Extent_call(test, test1, "Select voyage");

		Step_Start(4, "Click on Any port call", test, test1);
		waitForElement(driver, voyage);
		safeclick(driver, voyage);
		Step_End(4, "Click on Any port call", test, test1);

		Step_Start(5, "Double click on the voyage", test, test1);
		
		waitForElement(driver, CS_Control_Pannel);
		safeclick(driver, CS_Control_Pannel);
		waitForElement(driver, CS_Condition_filter);
		safeclick(driver, CS_Condition_filter);
		waitForElement(driver, Port_Code_TF);
		sendKeys(driver, Port_Code_TF, PortCode_Value);
		waitForElement(driver, port_code);
		doubleClick(driver, port_code);
		Step_End(5, "Double click on the voyage", test, test1);
		waitForDisplay(driver, VoyageDetails_Temp_Remove);
		if(isDisplayed(driver, VoyageDetails_Temp_Remove)){
			waitForElement(driver, VoyageDetails_Temp_Remove);
			click(driver, VoyageDetails_Temp_Remove);
		}
		waitForElement(driver, Current_voyageBtn);
		safeclick(driver, Current_voyageBtn);
		
       reArrangeAG_GridColumns_VoyageWindow(driver, Select_Columns);
		
		waitForElement(driver, edit_Grid_Total_Records);
		String getTotalRecords=getText(driver, edit_Grid_Total_Records);
		int row_Count=Integer.parseInt(getTotalRecords);
		List<String> columns = splitAndExpand(Select_Columns);
		waitForElement(driver, Voyage_Details_Table);

		List<Map<String, String>> voyage_Details_Before = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String voyage_Details_before=TableDataForReport(driver, voyage_Details_Before, table_Name, columns);




		Step_Start(6, "Enter the Arr pilot date of first port Lesser than the previous voyage last port Dep pilot time",
				test, test1);
		waitForElement(driver, Arr_Pilot_firstValue);
		safeclick(driver, Arr_Pilot_firstValue);

		
		if (date_Picker.equalsIgnoreCase("Yes")) {
			doubleClick(driver, Arr_Pilot_firstValue);
		
		selectDatePickerWithTime(driver, Arr_Pilot_firstValue, Arr_Pilot_Date);
		}
		
//
		waitForElement(driver, Distance_Val);
		click(driver, Distance_Val);

		waitForPopup(driver, popup_Message, CS_BeforePopup_Msg);
		String CS_voyage_Popup = getText(driver, popup_Message);
		if (CS_voyage_Popup.contains(CS_BeforePopup_Msg)) {
			System.out.println("Matched || Expected value was : " + CS_voyage_Popup + " || Actual value was : "
					+ CS_BeforePopup_Msg);
			Extent_pass_New(driver, "Matched || Expected value was : " + CS_voyage_Popup + " || Actual value was : "
					+ CS_BeforePopup_Msg, test, test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + CS_voyage_Popup + " || Actual value was : "
					+ CS_BeforePopup_Msg);
			Extent_fail(driver, "NotMatched || Expected value was : " + CS_voyage_Popup + " || Actual value was : "
					+ CS_BeforePopup_Msg, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		Step_End(6, "Enter the Arr pilot date of first port  Lesser than the previous voyage last port Dep pilot time",
				test, test1);

		
		Step_Start(7,
				"Enter the Dep pilot date of last port i the voyage Greater  than the Next  voyage First  port Arr  pilot time",
				test, test1);
		waitForElement(driver, depature_Pilot_Date);
		click(driver, depature_Pilot_Date);
		
		
		if (date_Picker.equalsIgnoreCase("Yes")) {
			doubleClick(driver, depature_Pilot_Date);
		
		selectDatePickerWithTime(driver, depature_Pilot_Date, Dep_Pilot_Date);
		}
	

		waitForElement(driver, Distance_Val1);
		click(driver, Distance_Val1);
		Step_End(7,
				"Enter the Dep pilot date of last port i the voyage Greater  than the Next  voyage First  port Arr  pilot time",
				test, test1);
		Step_Start(8, "Click on Move to Coastal schedule", test, test1);
		waitForElement(driver, MoveTo_CoastalSchedule);
		safeclick(driver, MoveTo_CoastalSchedule);
		
		
		waitForElement(driver, Voyage_Details_Table);
		List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String voyage_Details_after=TableDataForReport(driver, voyage_Details_After, table_Name, columns);

	
		waitForPopup(driver, popup_Message, CS_AfterPopup_Msg);
		String CS_voyage_Popup1 = getText(driver, popup_Message);
		if (CS_voyage_Popup1.contains(CS_AfterPopup_Msg)) {
			System.out.println("Matched || Expected value was : " + CS_voyage_Popup1 + " || Actual value was : "
					+ CS_AfterPopup_Msg);
			Extent_pass_New(driver, "Matched || Expected value was : " + CS_voyage_Popup1 + " || Actual value was : "
					+ CS_AfterPopup_Msg, test, test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + CS_voyage_Popup1 + " || Actual value was : "
					+ CS_AfterPopup_Msg);
			Extent_fail(driver, "NotMatched || Expected value was : " + CS_voyage_Popup1 + " || Actual value was : "
					+ CS_AfterPopup_Msg, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		
		if (voyage_Details_Before.equals(voyage_Details_After)) {
			Extent_pass_New(driver, " Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
			
		} else {
			Extent_fail(driver,
					" Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
			}
		
		
		Step_End(8, "Click on Move to Coastal schedule", test, test1);
		Extent_completed(testCaseName, test, test1);

	}
}
