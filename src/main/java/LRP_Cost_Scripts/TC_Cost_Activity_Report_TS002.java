package LRP_Cost_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS002 extends Keywords {
	
	public void  Cost_Activity_Report_TS002(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
	
		String tc_Name = "TC_Cost_Activity_Report_TS002";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String CAR_Retrieve_Type1 = Excel_data.get("CAR_Retrieve_Type1");
		String CAR_Retrieve_Condition1 = Excel_data.get("CAR_Retrieve_Condition1");
		String CAR_Number_Retrieve_Value1 = Excel_data.get("CAR_Number_Retrieve_Value1");
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		
		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		
		
		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);
		
		waitForElement(driver, Global_Search);
		click(driver,Global_Search);
	
		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, ".Check whether the system opens the search window", test, test1);
		
		waitForElement(driver, globalSearch_Frame_SearchButton);
		if(isdisplayed(driver, globalSearch_Frame_SearchButton)) {
			System.out.println("Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver, "Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully" , test, test1);
			
		}else {
			System.out.println("Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver, "Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully" , test, test1);
		}
		
		Step_End(4, ".Check whether the system opens the search window", test, test1);
		
		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button", test, test1);
		Step_Start(8, "Click on the select button.", test, test1);
		
		globalValueSearchWindow(driver,CAR_Retrieve_Condition1,CAR_Retrieve_Type1,CAR_Number_Retrieve_Value1,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(8, "Click on the select button.", test, test1);
		Step_End(7, "System will show the CAR No. and Click on the select button", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		

		Step_Start(9, "System will retrieve the CAR", test, test1);

		waitForElement(driver, Vessel_Search_Btn_CAR);
		
		waitForElement(driver, car_Number_val);
		
		String Carvalue = getAttribute(driver, car_Number_val, "value");

		System.out.println("Carvalue :" + Carvalue);

		if (CAR_Number_Retrieve_Value1.equals(Carvalue)) {
			System.out.println("Matched exp value :" + CAR_Number_Retrieve_Value1 + "actual value :" + Carvalue);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + CAR_Number_Retrieve_Value1
					+ " || Actual Report Activity is : " + Carvalue, test, test1);
		} else {
			System.out.println("Not matched exp value :" + CAR_Number_Retrieve_Value1 + "actual value :" + Carvalue);
			Extent_fail(driver, "Matched || " + " Expected Report Activity is : " + CAR_Number_Retrieve_Value1
					+ " || Actual Report Activity is : " + Carvalue, test, test1);
		}

		Step_End(9, "System will retrieve the CAR", test, test1);
		
		
		Extent_completed(tc_Name, test, test1);	
		
		
		
		
}
}