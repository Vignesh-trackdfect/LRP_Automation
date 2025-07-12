package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Scale_In_TS_007 extends Keywords {

	public void Scaleinedit(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		// Value are taken from excel sheet
		String testcase_Name = "TC_Scale_In_TS_007";
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String Scale_Reference_no = Excel_data.get("Scale_Reference_no");
		String perdiem = Excel_data.get("Per_Diem");
		String savedpopexp = Excel_data.get("PopUpforsaved");
		String Search_type = Excel_data.get("Search_type");
		String From_date_perform = Excel_data.get("From_date_perform");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String To_Date_perform = Excel_data.get("To_Date_perform");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String Coloum_names = Excel_data.get("Coloum_names");
		String Equipment_ID = Excel_data.get("Equipment_ID");
		String Location = Excel_data.get("Location");
		String Search_value_type = Excel_data.get("Search_value_type");
		
		String select_Option_1 = String.format(Gird_Click, Location,Equipment_ID);
		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver, url);
	
		// Login
		LRP_Login(driver, Username, Password);

	
	

		// Module Search

		moduleNavigate(driver, Search);
		
		Step_Start(1, " Click on Global Search from toolbar",test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, Search_type, Search_value_type, Scale_Reference_no, "", "", "", "");
		Step_End(1, " Click on Global Search from toolbar",test, test1);
		Step_Start(2, " Enter Contract no & click on search button",test, test1);
		// Entering the contract number to search

		
	
		Step_Start(3, " Click on retrieved data for required contract no",test, test1);
	
		scrollTop(driver);
		Step_End(2, " Enter Contract no & click on search button",test, test1);
		Step_End(3, " Click on retrieved data for required contract no",test, test1);
		Step_Start(4, "Click on Edit button from toolbar ",test, test1);
		// Adding into the gird

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		
		scrollBottom(driver);
		Step_End(4, "Click on Edit button from toolbar ",test, test1);
		Step_Start(5, " double click on the required data from grid ",test, test1);
		waitForElement(driver, Adoubleclickperdiem);
		String firist = getText(driver, Adoubleclickperdiem);
		System.out.println(firist);
		String[] a2 = firist.split("\\.");
		System.out.println("Splitted string" + a2[0]);
		waitForElement(driver, select_Option_1);
		doubleClick(driver, select_Option_1);
	
		scrollTop(driver);
		Step_End(5, " double click on the required data from grid ",test, test1);
		// Selecting the From Date
		waitForElement(driver, AFrom_Date);
		if (From_date_perform.equalsIgnoreCase("Yes")) {
			waitForElement(driver, AFrom_Date);
			selectDatePicker(driver, AFrom_Date, From_Date_Input);
		} else {
			waitForElement(driver, AFrom_Date);
			clearAndType(driver, AFrom_Date, From_Date_Input);
		}
		
				Step_End(3, "Select Validity From Date range accordingly in date picker ",test, test1);
				// Selecting the to Date
				Step_Start(4, "-Select Validity To Date range accordingly in date picker ",test, test1);
				waitForElement(driver, A_To_Date);
				if (To_Date_perform.equalsIgnoreCase("Yes")) {
					waitForElement(driver, A_To_Date);
					selectDatePicker(driver, A_To_Date, To_Date_Input);
				} else {
					waitForElement(driver, A_To_Date);
					clearAndType(driver, A_To_Date, To_Date_Input);
				}
				
		Step_Start(6, "Clear the existing values in per diem field ",test, test1);
		Step_Start(7, " Enter new values in per diem field & click on edit button ",test, test1);
		// Perdiem input
		if (!perdiem.equals("")) {
			waitForElement(driver, APer_Diem_Input);
			clear(driver, APer_Diem_Input);
			Step_End(6, "Clear the existing values in per diem field ",test, test1);
			sendKeys(driver, APer_Diem_Input, perdiem);
			waitForElement(driver, APick_Up_Credit);
			safeclick(driver, APick_Up_Credit);
		}
		
		waitForElement(driver, Aeditbuttoninside);
		safeclick(driver, Aeditbuttoninside);
		
		Step_End(7, " Enter new values in per diem field & click on edit button ",test, test1);
		scrollTop(driver);
		Step_Start(8, " Click on save button & updated message shown in screen ",test, test1);
		// Saving after edit
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		waitForElement(driver, AGried_Add_Button);
		scrollUsingElement(driver, AGried_Add_Button);
		// verify the popup for after edit the date and save

		waitForPopup(driver, Popup_Message, savedpopexp);
		String actualmsg = getText(driver, Popup_Message);
		System.out.println(actualmsg);
		if (savedpopexp.equals(actualmsg)) {
			System.out.println(
					"Matched || " + " Expected popup is [Before edit it was shown] : " + savedpopexp + " || Actual popup is [After edit it was shown] : " + actualmsg);
			Extent_pass_New(driver,
					"Matched || " + " Expected popup is [Before edit it was shown] : " + savedpopexp + " || Actual popup is[After edit it was shown]  : " + actualmsg,
					test, test1);
		} else {
			System.out.println("Not matched || " + " Expected popup is[Before edit it was shown] : " + savedpopexp
					+ " || Actual popup is[After edit it was shown]  : " + actualmsg);
			Extent_fail(driver, "Not matched || " + " Expected popup is [Before edit it was shown]: " + savedpopexp
					+ " || Actual popup is[After edit it was shown]  : " + actualmsg, test, test1);
			
		}
		
		// verification before edit value and after edit value
		waitForElement(driver, Adoubleclickperdiem);
		String second = getText(driver, Adoubleclickperdiem);
		System.out.println(second);

		if (a2[0].equals(second)) {
			System.out
					.println("Matched || " + " Expected Activity is : " + a2[0] + " || Actual Activity is : " + second);
			Extent_fail(driver, "Matched || " + " PerDiem want to change aftet edit : " + a2[0]
					+ " || PerDiem was changed : " + second, test, test1);
		
		} else {
			System.out.println(
					"Not matched || " + " Expected Activity is : " + a2[0] + " || Actual Activity is : " + second);
			Extent_pass_New(driver,
					"Not matched || " + " Expected Activity is : " + a2[0] + " || Actual Activity is : " + second, test,
					test1);
			
			Extent_call(test, test1, "Not matched || " + " Expected Activity is : " + a2[0] + " || Actual Activity is : " + second);
		}
		Step_End(8, " Click on save button & updated message shown in screen ",test, test1);
		
		
		Map<String, List<String>> table_view = extractTableDataDirect(driver, table_Path);
		List<String> coloumhearders = splitAndExpand1(Coloum_names);
		
		String table_value = printTable(driver, table_view, coloumhearders);
		Extent_pass_New(driver, "<pre>"+table_value+"</pre>", test, test1);
		// verify data was added in gird
		waitForDisplay(driver, AINNSA);
		if (isdisplayed(driver, AINNSA)) {
			System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid");
			Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid", test, test1);
			Extent_call(test, test1,  "Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid");
			waitForDisplay(driver, Scroll_side);
			if (isdisplayed(driver, Scroll_side)) {
				horizontalscroll(driver, Scroll_side, 1000);
				Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid", test, test1);	
				Extent_call(test, test1,  "Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid");
				
			}
			
		} else {
			System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
			Extent_fail(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid", test, test1);
			
		}
		
		scrollTop(driver);
		Extent_completed(testcase_Name, test, test1);
	}

}
