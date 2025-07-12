package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS063 extends Keywords{

	public void  Cost_Activity_Report_TS063(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS063";
		
		
		
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);
       Step_Start(1, "Once login to the application and click on switch profile option and select the required agency", test, test1);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency", test, test1);

		Step_Start(2, "Enter the screen name as \"Cost Activity Report\" in module search field", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field", test, test1);
		
		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);
		
		Step_Start(4, "Check whether it opens a new search window", test, test1);
		
		globalValueSearchWindow(driver, CAR_Retrieve_Condition, CAR_Retrieve_Type, CAR_Number_Retrieve, CAR_Retrieve_Type2, CAR_Number_Retrieve_Value2, CAR_Retrieve_Type3, CAR_Number_Retrieve_Value3);
		Step_End(4, "Check whether it opens a new search window", test, test1);
		
		
		Step_End(5, "Enter the required CAR No. in the CAR No search field", test, test1);
		
		Step_Start(6, "Then click on the search button", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		
		Step_Start(7, "System will show the CAR No. and Click on the select button", test, test1);
		Step_End(7, "System will show the CAR No. and Click on the select button", test, test1);

		Step_Start(8, "System will retrieve the CAR", test, test1);
		waitForElement(driver, Expensive_Report_Btn_CAR);
		Step_End(8, "System will retrieve the CAR", test, test1);
		
		Step_Start(9, "Click on the expense report", test, test1);
		click(driver,Expensive_Report_Btn_CAR);
		Step_End(9, "Click on the expense report", test, test1);
		
		waitForElement(driver, expensive_Report_table);

		List<Map<String, String>> Befor_expensive_Table_Data = extractTableDataDirect1(driver, expensive_Report_table);
		
		System.out.println("Befor_expensive_Table_Data :"+Befor_expensive_Table_Data);
		
		Step_Start(10, "Click on the regenerate option", test, test1);
		waitForElement(driver, regenerate_Btn_CAR);
		click(driver, regenerate_Btn_CAR);
		
		Step_End(10, "Click on the regenerate option", test, test1);
		waitForElement(driver, expensive_Report_table);
		
      List<Map<String, String>> After_expensive_Table_Data = extractTableDataDirect1(driver, expensive_Report_table);
		
		System.out.println("After_expensive_Table_Data :"+After_expensive_Table_Data);
		
		if(Befor_expensive_Table_Data.equals(After_expensive_Table_Data)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Befor_expensive_Table_Data+ " || Actual Report Activity is : " + After_expensive_Table_Data);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Befor_expensive_Table_Data+ " || Actual Report Activity is : " + After_expensive_Table_Data, test,test1);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Befor_expensive_Table_Data+ " || Actual Report Activity is : " + After_expensive_Table_Data);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Befor_expensive_Table_Data+ " || Actual Report Activity is : " + After_expensive_Table_Data, test,test1);
		}
		
		Extent_completed(tc_Name, test, test1);
		
	}

}
