package LRP_VSS_Integration_Scripts_2;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Coastal_Schedule_CS02I_IP extends Keywords {

	public void adjustingArrDate(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Coastal_Schedule_CS02I_IP";

		// Get data from excel sheet
		
		



		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search_Module_Name = Excel_data.get("Search_Module_Name");
		String ServiceCode = Excel_data.get("ServiceCode");
		String vesselName = Excel_data.get("vesselName");
		String voyage_num1 = Excel_data.get("voyage_num1");
		String PortCode_Value = Excel_data.get("PortCode_Value");
		String SearchBox = Excel_data.get("SearchBox");
		String Vessels_Code = Excel_data.get("Vessels_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Arr_Pilot_Date = Excel_data.get("Arr_Pilot_Date");
		String date_Picker = Excel_data.get("date_Picker");
		String Select_Columns = Excel_data.get("Select_Columns");
		String table_Name = Excel_data.get("table_Name");
		String Vessel_code_Header_CS = Excel_data.get("Vessel_code_Header_CS");
		String Service_Code_Header_CS = Excel_data.get("Service_Code_Header_CS");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");

		

		

		String voyage =  String.format(voyage_, voyage_num1);
		String port_code =  String.format(port_code_, PortCode_Value);
		String CS_Arr_Pilot_firstValue =  String.format(Arr_Pilot_firstValue_, PortCode_Value);
		String Distance_Val =  String.format(Distance_Val_, PortCode_Value);
		String CS_Arr_Pilot_firstValue1 =  String.format(Arr_Pilot_firstValue_, PortCode_Value);
		String moved_portcode =  String.format(moved_portcode1, PortCode_Value);
	
		


		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Step_Start(1, "Open Coastal Schedulde", test, test1);
		moduleNavigate(driver, Search_Module_Name);

		
		Step_End(1, "Open Coastal Schedulde", test, test1);
		Step_Start(2, "Retreive any schedule", test, test1);
		waitForElement(driver, Service_Search_Btn);
		safeclick(driver, Service_Search_Btn);

		twoColumnSearchWindow(driver, Service_Code_Header_CS, Condition_Filter, ServiceCode);
	
		waitForElement(driver, Vessel_Search_Btn);
		safeclick(driver, Vessel_Search_Btn);
		twoColumnSearchWindow(driver, Vessel_code_Header_CS, Condition_Filter, vesselName);

		Step_End(2, "Retreive any schedule", test, test1);
		Step_Start(3, "safeclick on Edit Button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		Step_End(3, "safeclick on Edit Button", test, test1);
		Step_Start(4, "Click on Any port call", test, test1);
		waitForElement(driver, voyage);
		safeclick(driver, voyage);
		Step_End(4, "Click on Any port call", test, test1);
		Step_Start(5, "Double click on the voyage ", test, test1);
		waitForElement(driver, CS_Control_Pannel);
		safeclick(driver, CS_Control_Pannel);
		waitForElement(driver, CS_Condition_filter);
		safeclick(driver, CS_Condition_filter);
		waitForElement(driver, Port_Code_TF);
		sendKeys(driver, Port_Code_TF, PortCode_Value);
		waitForElement(driver, port_code);
		doubleClick(driver, port_code);

		Step_End(5, "Double click on the voyage ", test, test1);
		waitForDisplay(driver, VoyageDetails_Temp_Remove);
		if(isDisplayed(driver, VoyageDetails_Temp_Remove)){
			waitForElement(driver, VoyageDetails_Temp_Remove);
			click(driver, VoyageDetails_Temp_Remove);
		}
		
reArrangeAG_GridColumns_VoyageWindow(driver, Select_Columns);
		
		waitForElement(driver, edit_Grid_Total_Records);
		String getTotalRecords=getText(driver, edit_Grid_Total_Records);
		int row_Count=Integer.parseInt(getTotalRecords);
		List<String> columns = splitAndExpand(Select_Columns);
		waitForElement(driver, Voyage_Details_Table);

		List<Map<String, String>> voyage_Details_Before = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String voyage_Details_before=TableDataForReport(driver, voyage_Details_Before, table_Name, columns);


		Step_Start(6, "Adjust the Arr Pilot DAte", test, test1);
		waitForElement(driver, CS_Arr_Pilot_firstValue);
		String CS_arrPilotDateBefore = getText(driver, CS_Arr_Pilot_firstValue);
		System.out.println("arrPilotDateBefore:" + CS_arrPilotDateBefore);
		safeclick(driver, CS_Arr_Pilot_firstValue);
		
		
		if (date_Picker.equalsIgnoreCase("Yes")) {
			doubleClick(driver, CS_Arr_Pilot_firstValue);
		
		selectDatePickerWithTime(driver, CS_Arr_Pilot_firstValue, Arr_Pilot_Date);
		}

	
	waitForElement(driver, Distance_Val);
		safeclick(driver, Distance_Val);

        waitForElement(driver, CS_Arr_Pilot_firstValue1);
		String CS_arrPilotDateAfter = getText(driver, CS_Arr_Pilot_firstValue1);
		System.out.println("arrPilotDateAfter:" + CS_arrPilotDateAfter);
		waitForElement(driver, Voyage_Details_Table);

		List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String voyage_Details_after=TableDataForReport(driver, voyage_Details_After, table_Name, columns);
		
		
		waitForElement(driver, MoveTo_CoastalSchedule);
		safeclick(driver, MoveTo_CoastalSchedule);
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isDisplayed(driver, popup_Message_Yes_Button)) {
		waitForElement(driver, popup_Message_Yes_Button);
		safeclick(driver, popup_Message_Yes_Button);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		Step_Start(7, "Open Long Term Creation", test, test1);
		
		moduleNavigate(driver, SearchBox);
		Step_End(7, "Open Long Term Creation", test, test1);
		Step_Start(8, "Reterive the same schedule used in the coastal ", test, test1);
		waitForElement(driver, longTermTab);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		waitForElement(driver, searchIconLT);
		safeclick(driver, searchIconLT);
		twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, ServiceCode);

		waitForElement(driver, LongTermsearchOk);
		safeclick(driver, LongTermsearchOk);
		Step_End(8, "Reterive the same schedule used in the coastal ", test, test1);
		Step_Start(9, "Click on Edit Button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		Step_End(9, "Click on Edit Button", test, test1);
		Step_Start(10, "Check the Voyage dates of the voyage which got time adjusted in the coastal scheedule ", test,
				test1);
		
		String voy1 = null;
		try {
			int i = 1;
			waitForElement(driver, vessel_codes);

			List<WebElement> vesselCodes = listOfElements(driver, vessel_codes);
			for (WebElement Vessel_Code : vesselCodes) {
				String Vessel = getText1(driver, Vessel_Code);
				if (Vessels_Code.equals(Vessel)) {
					String voyage_Num = String.format(voyNumber, i);
					voy1 = getText(driver, voyage_Num);
					if (Voyage_Number.equals(voy1)) {
						click(driver, voyage_Num);
						RightClick(driver, voyage_Num);

						break;
					}

				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

		}

		waitForElement(driver, adjustTime);
		mouseOverToElement(driver, adjustTime);
		waitForElement(driver, AdjustTime2);
		safeclick(driver, AdjustTime2);
	   waitForElement(driver, moved_portcode);
		String portcode_row = getAttribute(driver, moved_portcode, "aria-rowindex");
		System.out.println("portcode_row: " + portcode_row);
		String LT_Arr_Pilot_before =  String.format(LT_Arr_Pilot_before_, portcode_row);
		
		waitForElement(driver, LT_Arr_Pilot_before);
		String LT_Arr_Pilot_before_Date = getText(driver, LT_Arr_Pilot_before);
		System.out.println(LT_Arr_Pilot_before_Date);

		waitForElement(driver, closeButtonAdjustTime);
		safeclick(driver, closeButtonAdjustTime);
		// verify after adjusting date in coastal schedule ,Long term voyage date
		// changed or not
		if (!CS_arrPilotDateAfter.equals(LT_Arr_Pilot_before_Date)) {
			System.out.println("Not matched || + Before changing the date : " + LT_Arr_Pilot_before_Date + " || After changing the date: "
					+ CS_arrPilotDateAfter);
			Extent_pass_New(driver,
					"Not matched || " + " Before changing the date: " + LT_Arr_Pilot_before_Date + " || After changing the date : " + CS_arrPilotDateAfter,
					test, test1);
		} else {
			System.out.println("matched || " + " Before changing the date: " + LT_Arr_Pilot_before_Date + " || After changing the date: "
					+ CS_arrPilotDateAfter);
			Extent_fail(driver,
					"matched || " + " Before changing the date: " + LT_Arr_Pilot_before_Date + " || After changing the date: " + CS_arrPilotDateAfter,
					test, test1);

		}
		
		
		if (!voyage_Details_Before.equals(voyage_Details_After)) {
			Extent_pass_New(driver, "Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
			
		} else {
			Extent_fail(driver,
					" Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
			}
		Step_End(10, "Check the Voyage dates of the voyage which got time adjusted in the coastal scheedule ", test,
				test1);
		Extent_completed(testCaseName, test, test1);

	}
}