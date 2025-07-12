package LRP_VSS_Integration_Scripts_2;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_LongTerm_LT03B_IP extends Keywords {

	public void LongTerm_LT03B_IP(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_LongTerm_LT03B_IP";


		

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
		String Voyage_Confirmed_pop = Excel_data.get("Voyage_Confirmed_pop");
		String Arr_Pilot_date_Input = Excel_data.get("Arr_Pilot_date_Input");
		String date_Picker = Excel_data.get("date_Picker");
		String Select_Columns = Excel_data.get("Select_Columns");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String table_Name = Excel_data.get("table_Name");
		String Vessel_code_Header_CS = Excel_data.get("Vessel_code_Header_CS");
		String Service_Code_Header_CS = Excel_data.get("Service_Code_Header_CS");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		
		
		
	

		Extent_Start(testCaseName, test, test1);
		// Login
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		// Search coastal schedule module
		
		moduleNavigate(driver, Search_Module_Name);
	
		Step_Start(1, "Retreive the Schedule in CS", test, test1);
		waitForElement(driver, Service_Search_Btn);
		safeclick(driver, Service_Search_Btn);

		twoColumnSearchWindow(driver, Service_Code_Header_CS, Condition_Filter, ServiceCode);
	
		waitForElement(driver, Vessel_Search_Btn);
		safeclick(driver, Vessel_Search_Btn);
		twoColumnSearchWindow(driver, Vessel_code_Header_CS, Condition_Filter, vesselName);

		
		Step_End(1, "Retreive the Schedule in CS", test, test1);
		Step_Start(2, "safeclick on Edit Button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		Step_End(2, "safeclick on Edit Button", test, test1);

		Extent_call(test, test1, "Select Voyage");
		String Voyage =  String.format(voyage_, voyage_num1);
	   waitForElement(driver, Voyage);
		safeclick(driver, Voyage);
		Step_Start(3, "Double safeclick on the Schedule to adjust the time of the Schedule", test, test1);

		waitForElement(driver, CS_Control_Pannel);
		safeclick(driver, CS_Control_Pannel);
		waitForElement(driver, CS_Condition_filter);
		safeclick(driver, CS_Condition_filter);
		waitForElement(driver, Port_Code_TF);
		sendKeys(driver, Port_Code_TF, PortCode_Value);
		String port_code =  String.format(port_code_, PortCode_Value);
		doubleClick(driver, port_code);
		Extent_call(test, test1, "Adjust date in ARR Pilot");
		
		
		String voyage_det_portcode =  String.format(voyage_det_portcode_, PortCode_Value);
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

		
		waitForElement(driver, voyage_det_portcode);
		String portcode_row = getAttribute(driver, voyage_det_portcode, "aria-rowindex");
		System.out.println("portcode_row: " + portcode_row);
		
		
		String arr_Pilot_Date =  String.format(Arr_Pilot_date, portcode_row);

		waitForElement(driver, arr_Pilot_Date);

		if (date_Picker.equalsIgnoreCase("Yes")) {
			doubleClick(driver, arr_Pilot_Date);
		
		selectDatePickerWithTime(driver, arr_Pilot_Date, Arr_Pilot_date_Input);
		}
		

		String Distance_Val =  String.format(Distance_Val_, PortCode_Value);
		waitForElement(driver, Distance_Val);
		safeclick(driver, Distance_Val);
		String arr_Pilot_Date1 =  String.format(arr_Pilot_Date2, portcode_row);

		waitForElement(driver, arr_Pilot_Date1);
		String Arr_Pilot_Before1 = getText(driver, arr_Pilot_Date1);
		System.out.println("arr_Pilot_Date_before:" + Arr_Pilot_Before1);
		waitForElement(driver, Voyage_Details_Table);

		List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String voyage_Details_after=TableDataForReport(driver, voyage_Details_After, table_Name, columns);

		

		waitForElement(driver, MoveTo_CoastalSchedule);
		safeclick(driver, MoveTo_CoastalSchedule);
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isDisplayed(driver, popup_Message_Yes_Button)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);


		Step_End(3, "Double safeclick on the Schedule to adjust the time of the Schedule", test, test1);

		Step_Start(4, "Open Long Term Module", test, test1);
		
		moduleNavigate(driver, SearchBox);
	
		Step_End(5, "Open Long Term Module", test, test1);
		scrollTop(driver);

		Step_Start(5, "Retreive the same Schedule previously time adjusted in Coastal Schedule", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		waitForElement(driver, searchIconLT);
		safeclick(driver, searchIconLT);
		
		
		
		twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, ServiceCode);
		waitForElement(driver, LongTermsearchOk);
		safeclick(driver, LongTermsearchOk);

		Step_End(5, "Retreive the same Schedule previously time adjusted in Coastal Schedule", test, test1);
		
		Step_Start(6, "Click on Edit Button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		Step_End(6, "Click on Edit Button", test, test1);
		Step_Start(7, "Right click on the voyage", test, test1);
		waitForElement(driver, longTermTab);

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
						waitForElement(driver, voyage_Num);
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
		Step_End(7, "Right click on the voyage", test, test1);
		Step_Start(8, "Choose Draft option", test, test1);
		waitForElement(driver, Draftbutton);
		safeclick(driver, Draftbutton);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		Step_End(8, "Choose Draft option", test, test1);
		Step_Start(9, "Once Again Right click on the same voyage", test, test1);
		waitForElement(driver, longTermTab);

		String voy2 = null;
		try {
			int i = 1;
			waitForElement(driver, vessel_codes);

			List<WebElement> vesselCodes = listOfElements(driver, vessel_codes);
			for (WebElement Vessel_Code : vesselCodes) {
				String Vessel = getText1(driver, Vessel_Code);
				if (Vessels_Code.equals(Vessel)) {
					String voyage_Num = String.format(voyNumber, i);
					voy2 = getText(driver, voyage_Num);
					if (Voyage_Number.equals(voy2)) {
						click(driver, voyage_Num);
						waitForElement(driver, voyage_Num);
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
		Step_End(9, "Once Again Right click on the same voyage", test, test1);
		Step_Start(10, "Choose Confirm option", test, test1);
		waitForElement(driver, Conformbtnlongterm);
		safeclick(driver, Conformbtnlongterm);

		waitForElement(driver, popup_Message_Yes_Button);
		safeclick(driver, popup_Message_Yes_Button);

		waitForDisplay(driver, continuebutton);
		if (isDisplayed(driver, continuebutton)) {
			waitForElement(driver, continuebutton);
			safeclick(driver, continuebutton);
		} else {
			System.out.println("Expected Result is : Continue Button should be display || Actual Result is : Continue button is not displayed");
		}

		waitForPopup(driver, popup_Message, Voyage_Confirmed_pop);
		String Voyage_Confirmed_popAct = getText(driver, popup_Message);
		System.out.println(Voyage_Confirmed_popAct);

		if (Voyage_Confirmed_pop.equals(Voyage_Confirmed_popAct)) {
			System.out.println("Matched || " + " Expected Activity is : " + Voyage_Confirmed_pop
					+ " || Actual Activity is : " + Voyage_Confirmed_popAct);
			Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Voyage_Confirmed_pop
					+ " || Actual Activity is : " + Voyage_Confirmed_popAct, test, test1);
			Extent_pass_New(driver, "**********Voyage was deleted and background was changed to white colour********", test,
					test1);
		} else {
			System.out.println("Not matched || " + " Expected Activity is : " + Voyage_Confirmed_pop
					+ " || Actual Activity is : " + Voyage_Confirmed_popAct);
			Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Voyage_Confirmed_pop
					+ " || Actual Activity is : " + Voyage_Confirmed_popAct, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		Step_End(10, "Choose Confirm option", test, test1);
		Step_Start(11, "Reterive the Voyage in Coastal Schedule ", test, test1);
		String voy3 = null;
		try {
			int i = 1;
			waitForElement(driver, vessel_codes);

			List<WebElement> vesselCodes = listOfElements(driver, vessel_codes);
			for (WebElement Vessel_Code : vesselCodes) {
				String Vessel = getText1(driver, Vessel_Code);
				if (Vessels_Code.equals(Vessel)) {
					String voyage_Num = String.format(voyNumber, i);
					voy3 = getText(driver, voyage_Num);
					if (Voyage_Number.equals(voy3)) {
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
		
		String moved_portcode =  String.format(moved_portcode1, PortCode_Value);
        waitForElement(driver, moved_portcode);
		String portcode_row1 = getAttribute(driver, moved_portcode, "aria-rowindex");
		System.out.println("portcode_row: " + portcode_row1);

		
		String LT_Arr_Pilot_After =  String.format(LT_Arr_Pilot_After_, portcode_row1);
		
		waitForElement(driver, LT_Arr_Pilot_After);
		String LT_Arr_Pilot_after_Date = getText(driver, LT_Arr_Pilot_After);
		System.out.println(LT_Arr_Pilot_after_Date);

		waitForElement(driver, closeButtonAdjustTime);
		safeclick(driver, closeButtonAdjustTime);
		
		waitForElement(driver, closemodule2);
		click(driver, closemodule2);
		Step_Start(11, "Reterive the Voyage in Coastal Schedule ", test, test1);

		waitForElement(driver, Cancel_button1);
		waitForElement(driver, Cancel_button1);
		click(driver, Cancel_button1);
		
		
		waitForElement(driver, Service_Search_Btn);
		safeclick(driver, Service_Search_Btn);
		twoColumnSearchWindow(driver, Service_Code_Header_CS, Condition_Filter, ServiceCode);

		

		waitForElement(driver, Vessel_Search_Btn);
		safeclick(driver, Vessel_Search_Btn);
		twoColumnSearchWindow(driver, Vessel_code_Header_CS, Condition_Filter, vesselName);

		// select vessel
		
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
    //click refresh button
		waitForElement(driver, refresh_Button1);
		click(driver, refresh_Button1);
		

		Step_End(11, "Reterive the Voyage in Coastal Schedule ", test, test1);


		String voyage1 =  String.format(voyage_, voyage_num1);
	   waitForElement(driver, voyage1);
		safeclick(driver, voyage1);

		waitForElement(driver, CS_Control_Pannel);
		safeclick(driver, CS_Control_Pannel);
		waitForElement(driver, CS_Condition_filter);
		safeclick(driver, CS_Condition_filter);
		waitForElement(driver, Port_Code_TF);
		sendKeys(driver, Port_Code_TF, PortCode_Value);
		String port_code1 =  String.format(port_code_, PortCode_Value);
		doubleClick(driver, port_code1);
		
		
		String voyage_det_portcode1 =  String.format(voyage_det_portcode_, PortCode_Value);
		reArrangeAG_GridColumns_VoyageWindow(driver, Select_Columns);

		
		waitForElement(driver, voyage_det_portcode1);
		String portcode_row2 = getAttribute(driver, voyage_det_portcode1, "aria-rowindex");
		System.out.println("portcode_row: " + portcode_row2);
		
		if (!voyage_Details_Before.equals(voyage_Details_After)) {
			Extent_pass_New(driver, "Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
			
		} else {
			Extent_fail(driver,
					"  Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
			}
		String arr_Pilot_Date3 =  String.format(Arr_Pilot_date, portcode_row2);


		waitForElement(driver, arr_Pilot_Date3);
		String Arr_Pilot_Before2 = getText(driver, arr_Pilot_Date3);
		System.out.println("arr_Pilot_Date_before:" + Arr_Pilot_Before2);

		Step_Start(12, "Compare the voyage dates", test, test1);
		if (Arr_Pilot_Before2.equals(LT_Arr_Pilot_after_Date)) {
			System.out.println(" matched || " + " Expected date is : " + Arr_Pilot_Before2
					+ " || Actual date is : " + LT_Arr_Pilot_after_Date);
			Extent_pass_New(driver, " matched || " + " Expected date is : " + Arr_Pilot_Before2
					+ " || Actual date is : " + LT_Arr_Pilot_after_Date, test, test1);

		} else {
			System.out.println(" Not matched || " + " Expected date is : " + Arr_Pilot_Before2
					+ " || Actual date is : " + LT_Arr_Pilot_after_Date);
			Extent_fail(driver, "Not matched || " + " Expected date is : " + Arr_Pilot_Before2
					+ " || Actual date is : " + LT_Arr_Pilot_after_Date, test, test1);
		}
		
		Step_End(12, "Compare the voyage dates", test, test1);
		
		Extent_completed(testCaseName, test, test1);

	}
}