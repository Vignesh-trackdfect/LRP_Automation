package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Scale_In_Out_Reference;

public class TC_Scale_In_TS_011 extends Keywords {

	public void Scaleoutedit(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		// Value are taken from excel sheet
		String testcase_Name = "TC_Scale_In_TS_011";



		String Username = Excel_data.get("Username");// 1,2,4-
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String Scale_Reference_no = Excel_data.get("Scale_Reference_no");
		String From_date_perform = Excel_data.get("From_date_perform");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String To_Date_perform = Excel_data.get("To_Date_perform");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String savedpopexp = Excel_data.get("PopUpforsaved");
		String Search_type = Excel_data.get("Search_type");
		String Location = Excel_data.get("Location");
		String Coloum_names = Excel_data.get("Coloum_names");
		String Equipment_ID = Excel_data.get("Equipment_ID");
		String Search_value_type = Excel_data.get("Search_value_type");
	
		
		String girdclick = String.format(Scale_In_Out_Reference.Gird_click, Location,Equipment_ID);
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		// Login
		LRP_Login(driver, Username, Password);

		// Module Search

		moduleNavigate(driver, Search);
		Step_Start(1, " CClick on Global Search from toolbar", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		Step_End(1, " Click on Global Search from toolbar", test, test1);
		globalValueSearchWindow(driver, Search_type, Search_value_type, Scale_Reference_no, "", "", "", "");
		Step_Start(2, "  Enter Contract no & click on search button", test, test1);
		// Entering the contract number to search
		Step_Start(3, " Click on retrieved data for required scale-out ref", test, test1);
	

		Step_End(3, " Click on retrieved data for required scale-out ref", test, test1);
		scrollTop(driver);
		waitForElement(driver, AFrom_Date);
		String Fromdate = getAttribute(driver, AFrom_Date, "value");
		System.out.println(Fromdate);
		String Todate = getAttribute(driver, A_To_Date, "value");
		System.out.println(Todate);
		Step_End(4, " Click on Edit button from toolbar ", test, test1);
		// Adding into the gird

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		Step_Start(4, " Click on Edit button from toolbar ", test, test1);
		Step_Start(6, "  Click the date range & update new date ", test, test1);

		Step_Start(5, "  double click on the required data from grid ", test, test1);
		// Double click on the gird

		waitForElement(driver, girdclick);
		doubleClick(driver, girdclick);

		Step_End(5, "  double click on the required data from grid ", test, test1);

		// Editing the date
		// Selecting the From Date
		waitForElement(driver, AFrom_Date);
		if (From_date_perform.equalsIgnoreCase("Yes")) {
			waitForElement(driver, AFrom_Date);
			selectDatePicker(driver, AFrom_Date, From_Date_Input);
		} else {
			waitForElement(driver, AFrom_Date);
			clearAndType(driver, AFrom_Date, From_Date_Input);
		}
		

		Step_End(3, "Select Validity From Date range accordingly in date picker ", test, test1);
		// Selecting the to Date
		Step_Start(4, "-Select Validity To Date range accordingly in date picker ", test, test1);
		waitForElement(driver, A_To_Date);
		if (To_Date_perform.equalsIgnoreCase("Yes")) {
			waitForElement(driver, A_To_Date);
			selectDatePicker(driver, A_To_Date, To_Date_Input);
		} else {
			waitForElement(driver, A_To_Date);
			clearAndType(driver, A_To_Date, To_Date_Input);
		}
		
		Step_End(6, "  Click the date range & update new date ", test, test1);

		Step_Start(7, "Click on edit button once date range updated", test, test1);

		// Adding the values into the grid

		waitForElement(driver, AGried_Add_Button);
		safeclick(driver, AGried_Add_Button);

		Step_End(7, "Click on edit button once date range updated", test, test1);

		scrollTop(driver);
		Step_Start(8, "Click on save button & updated message shown in screen", test, test1);
		// Saving after edit
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		waitForElement(driver, AGried_Add_Button);
		scrollUsingElement(driver, AGried_Add_Button);
		
		
		Map<String, List<String>> table_view = extractTableDataDirect(driver, table_Path);
		List<String> coloumhearders = splitAndExpand1(Coloum_names);
		
		String table_value = printTable(driver, table_view, coloumhearders);
		Extent_pass_New(driver, "<pre>"+table_value+"</pre>", test, test1);
		
		waitForPopup(driver, Popup_Message, savedpopexp);
		String actualmsg = getText(driver, Popup_Message);
		System.out.println(actualmsg);
		if (savedpopexp.equals(actualmsg)) {
			System.out.println(
					"Matched || " + " Expected Activity is : " + savedpopexp + " || Actual Activity is : " + actualmsg);
			Extent_pass_New(driver,
					"Matched || " + " Expected Activity is : " + savedpopexp + " || Actual Activity is : " + actualmsg,
					test, test1);
		} else {
			System.out.println("Not matched || " + " Expected Activity is : " + savedpopexp
					+ " || Actual Activity is : " + actualmsg);
			Extent_fail(driver, "Not matched || " + " Expected Activity is : " + savedpopexp
					+ " || Actual Activity is : " + actualmsg, test, test1);

		}
		Step_End(8, "Click on save button & updated message shown in screen", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		scrollBottom(driver);
		// Double click on the gird

		waitForElement(driver, girdclick);
		doubleClick(driver, girdclick);

		scrollTop(driver);
		waitForElement(driver, AFrom_Date);
		String Fromdate1 = getAttribute(driver, AFrom_Date, "value");
		System.out.println(Fromdate1);
		String Todate1 = getAttribute(driver, A_To_Date, "Value");
		System.out.println(Todate1);

		if (Fromdate.equals(Fromdate1)) {
			System.out.println(
					"Matched || " + " Expected date is : " + Fromdate + " || Actual date is : " + Fromdate1);
			Extent_fail(driver, "Matched || " + " Date want to change aftet edit : " + Fromdate
					+ " || Date was changed : " + Fromdate1, test, test1);
		} else {
			System.out.println("Not matched || " + " Expected Activity is Date want to change aftet edit  : " + Fromdate
					+ " || Actual Activity isDate was changed  : " + Fromdate1);
			Extent_pass_New(driver, "Not matched || " + " Expected Activity is  Date want to change aftet edit : "
					+ Fromdate + " || Actual Activity is Date was changed : " + Fromdate1, test, test1);

		}

		if (Todate.equals(Todate1)) {
			System.out.println(
					"Matched || " + " Expected date is : " + Todate + " || Actual date is : " + Todate1);
			Extent_fail(driver,
					"Matched || " + " Date want to change aftet edit : " + Todate + " || Date was changed : " + Todate1,
					test, test1);
		} else {
			System.out.println("Not matched || " + " Expected Activity is  Date want to change aftet edit : " + Todate
					+ " || Actual Activity is Date was changed : " + Todate1);
			Extent_pass_New(driver, "Not matched || " + " Expected Activity is  Date want to change aftet edit : " + Todate
					+ " || Actual Activity is Date was changed : " + Todate1, test, test1);

		}

		scrollTop(driver);
		Extent_completed(testcase_Name, test, test1);
	}

}
