package LRP_Cost_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS015 extends Keywords{
	
	
	public void  Cost_Activity_Report_TS015(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		
		String tc_Name = "TC_Cost_Activity_Report_TS015";
		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		
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
		
		Step_Start(2, "Enter the screen name as \"Cost Activity Report\" in module search field", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field", test, test1);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);
		
		Step_Start(4, ".Check whether it opens a new search window.", test, test1);
		waitForElement(driver, type_Select1);
		Step_End(4, ".Check whether it opens a new search window.", test, test1);
		
		Step_Start(5, "Enter the saved CAR No in the CAR No search field", test, test1);
		Step_Start(6, "Then click on the search button", test, test1);
		Step_Start(7, "System will show the CAR No", test, test1);
		Step_Start(8, "Click on the select button", test, test1);
		globalValueSearchWindow(driver,CAR_Retrieve_Condition1,CAR_Retrieve_Type1,CAR_Number_Retrieve_Value1,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(8, "Click on the select button", test, test1);
		Step_End(7, "System will show the CAR No", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		Step_End(5, "Enter the saved CAR No in the CAR No search field", test, test1);
		
		Step_Start(9, "System will retrieve the CAR", test, test1);
		waitForElement(driver, CAR_Number_Input_CAR);
		Step_End(9, "System will retrieve the CAR", test, test1);
		
		Step_Start(10, "Click on the tool bar Export option and check whether system exports the data", test, test1);
		
		waitForElement(driver, CAR_Summary_Table);
		
		waitForElement(driver, Total_Record_Count_CAR);
		String TotalRecordValue=getText(driver, Total_Record_Count_CAR);
		int TotalRecords_Application=Integer.parseInt(TotalRecordValue);
		System.out.println("TotalRecords_Application :"+TotalRecords_Application);
		
		waitForElement(driver, Export_button_Toolbar);		
		String downlaoad_Path = downloadFile(driver, Export_button_Toolbar);
		
		int row_Count = countNonEmptyRows(downlaoad_Path);
		int TotalRecordsCount_Excel=row_Count-3;
		
		if(TotalRecords_Application==TotalRecordsCount_Excel) {
			System.out.println("Matched || Records Count in Application : " + TotalRecords_Application + " ||  Records Count in Excel : "+ TotalRecordsCount_Excel);
			Extent_pass_New(driver, "Matched || Records Count in Application : " + TotalRecords_Application + " || Records Count in Excel : "+ TotalRecordsCount_Excel, test, test1);
		}else {
			System.out.println("Not Matched || Records Count in Application : " + TotalRecords_Application + " ||  Records Count in Excel : "+ TotalRecordsCount_Excel);
			Extent_fail(driver, "Not Matched || Records Count in Application : " + TotalRecords_Application + " || Records Count in Excel : "+ TotalRecordsCount_Excel, test, test1);
		}
		
		Step_End(10, "Click on the tool bar Export option and check whether system exports the data", test, test1);

		Extent_completed(tc_Name, test, test1);		
		
	}

}
