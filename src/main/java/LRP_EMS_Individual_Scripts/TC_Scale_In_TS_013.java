package LRP_EMS_Individual_Scripts;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Scale_In_TS_013 extends Keywords {

	public void ScaleoutRetrieve(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		// Value are taken from excel sheet
		String testcase_Name = "TC_Scale_In_TS_013";
		
		


		String Username = Excel_data.get("Username");// 1,2,4-
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String Scale_Reference_no = Excel_data.get("Scale_Reference_no");
		String Search_type = Excel_data.get("Search_type");
		String Coloum_names = Excel_data.get("Coloum_names");
		String Search_value_type = Excel_data.get("Search_value_type");
		
		
		Extent_Start(testcase_Name, test, test1);
		
		
		

		navigateUrl(driver, url);

	
		// login
		LRP_Login(driver, Username, Password);
		moduleNavigate(driver, Search);
		Step_Start(1, "Click on Global Search from toolbar",test, test1);
		// home page displayed
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		// seaeching the data in global search
	
		Step_End(1, "Click on Global Search from toolbar",test, test1);
		Step_Start(2, "Enter Contract no accordingly & click on search button",test, test1);
		Step_Start(3, "Click on retrieved data for required contract no",test, test1);
		globalValueSearchWindow(driver, Search_type, Search_value_type, Scale_Reference_no, "", "", "", "");
		
		
		waitForElement(driver, AScale_in_ref_input);
		String reference =getAttribute(driver, AScale_in_ref_input, "value");
		System.out.println(reference);
		scrollTop(driver);
		
		Step_End(2, "Enter Contract no accordingly & click on search button",test, test1);
		// verifying the gird

		scrollUsingElement(driver, AGried_Add_Button);
		
		Map<String, List<String>> table_view = extractTableDataDirect(driver, table_Path);
		List<String> coloumhearders = splitAndExpand1(Coloum_names);
		
		String table_value = printTable(driver, table_view, coloumhearders);
		Extent_pass_New(driver, "<pre>"+table_value+"</pre>", test, test1);

		String Location1 = getText(driver, AINNSA);
		System.out.println(Location1);
		Extent_pass_New(driver, "Location shown as" + "****" + Location1, test, test1);

		String equetype = getText(driver, Equipmenttype);
		System.out.println(equetype);
		Extent_pass_New(driver, "equipmentquantity shown as" + "****" + equetype, test, test1);

		String equeque = getText(driver, Equipmentquenty);
		System.out.println(equeque);
		Extent_pass_New(driver, "equipmenttime shown as " + "****" + equeque, test, test1);
		if (isDisplayed(driver, AINNSA)) {
			System.out.println("Data was shown in grid");
			Extent_pass_New(driver, "***Data was shown in grid***", test, test1);
			
			waitForDisplay(driver, Scroll_side);
			if (isdisplayed(driver, Scroll_side)) {
				horizontalscroll(driver, Scroll_side, 1000);
				System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
				Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is  shown in grid", test, test1);	
				
			}
	
			
			
		} else {
			System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
			Extent_fail(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid", test, test1);
			
		}

		Set<String> arrset1 = new HashSet<String>();
		arrset1.add(equeque);
		arrset1.add(equetype);
		arrset1.add(Location1);

		System.out.println("First Set: " + arrset1);
		Step_End(3, "Click on retrieved data for required contract no",test, test1);
		
		if (Scale_Reference_no.equals(reference)) {
			System.out.println("Matched || " + " Expected Activity is : " + Scale_Reference_no
					+ " || Actual Activity is : " + reference);
			Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Scale_Reference_no
					+ " || Actual Activity is : " + reference, test, test1);
			Extent_pass_New(driver," Scale-out Data was retrived", test, test1);
		} else {
			System.out.println("Not matched || " + " Expected Activity is : " + Scale_Reference_no
					+ " || Actual Activity is : " + reference);
			Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Scale_Reference_no
					+ " || Actual Activity is : " + reference, test, test1);
		
			
		}
		Extent_completed(testcase_Name, test, test1);
	}
}
