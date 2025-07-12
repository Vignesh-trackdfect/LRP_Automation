package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_002 extends Keywords {

	public void Arrival_Notice_TS_002(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Arrival_Notice_TS_002";
		
		
		


		
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ArrivalNotice_Module = Excel_data.get("ArrivalNotice_Module");
		



		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Switch the agency", test, test1);
		Step_Start(2, "Open Arrival Notice / Freight Memo Module", test, test1);

		
		moduleNavigate(driver, ArrivalNotice_Module);

		Step_End(2, "Open Arrival Notice / Freight Memo Module", test, test1);

		Step_Start(3, "Click on New Button", test, test1);
		newButton(driver);
		Step_End(3, "Click on New Button", test, test1);
		Step_Start(4, "Make sure mentioned filers were enabled", test, test1);
		waitForDisplay(driver, by_Bl_Number_Button_AN);
		if(isDisplayed(driver, by_Bl_Number_Button_AN)) {
		if(isElementEnabled(driver, by_Bl_Number_Button_AN)) {
			Extent_pass(driver, "Matched || Expected Result is : BY BL Number button Should be Enable || Actual Result is : BY BL Number button is Enabled", test, test1);
			System.out.println("Matched || Expected Result is : BY BL Number button Should be Enable || Actual Result is : BY BL Number button is Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is : BY BL Number button Should be Enable || Actual Result is : BY BL Number button is Not Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : BY BL Number button Should be Enable || Actual Result is : BY BL Number button is Not Enabled", test, test1);
		}
		}

		waitForDisplay(driver, by_Vessel_Button_AN);
		if(isDisplayed(driver, by_Bl_Number_Button_AN)) {
		if(isElementEnabled(driver, by_Vessel_Button_AN)) {
			Extent_pass(driver, "Matched || Expected Result is : BY Vessel button Should be Enable || Actual Result is : BY Vessel button is Enabled", test, test1);
			System.out.println("Matched || Expected Result is : BY Vessel button Should be Enable || Actual Result is : BY Vessel button is Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is : BY Vessel button Should be Enable || Actual Result is : BY Vessel button is Not Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : BY Vessel button Should be Enable || Actual Result is : BY Vessel button is Not Enabled", test, test1);
		}
		}
		
		waitForDisplay(driver, by_customer_AN);
		if(isDisplayed(driver, by_Bl_Number_Button_AN)) {
		if(isElementEnabled(driver, by_customer_AN)) {
			
			Extent_pass(driver, "Matched || Expected Result is : BY Customer button Should be Enable || Actual Result is : BY Customer button is Enabled", test, test1);
			System.out.println("Matched || Expected Result is : BY Customer button Should be Enable || Actual Result is : BY Customer button is Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is : BY Customer button Should be Enable || Actual Result is : BY Customer button is Not Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : BY Customer button Should be Enable || Actual Result is : BY Customer button is Not Enabled", test, test1);
		}
		}
		waitForDisplay(driver, by_Remainder_AN);
		if(isDisplayed(driver, by_Remainder_AN)) {
		if(isElementEnabled(driver, by_Remainder_AN)) {
			Extent_pass(driver, "Matched || Expected Result is : BY Remainder button Should be Enable || Actual Result is : BY Remainder button is Enabled", test, test1);
			System.out.println("Matched || Expected Result is : BY Remainder button Should be Enable || Actual Result is : BY Remainder button is Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is : BY Remainder button Should be Enable || Actual Result is : BY Remainder button is Not Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : BY Remainder button Should be Enable || Actual Result is : BY Remainder button is Not Enabled", test, test1);
		}
		}
			
		Step_End(4, "Make sure mentioned filers were enabled", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}

}
