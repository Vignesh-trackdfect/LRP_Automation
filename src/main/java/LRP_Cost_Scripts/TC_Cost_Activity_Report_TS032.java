package LRP_Cost_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS032 extends Keywords{

	public void  Cost_Activity_Report_TS032(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS032";
		
		
		
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		
		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		
		String Predictable_Table_Headers = Excel_data.get("Predictable_Table_Headers");
		String Header_Name_Table = Excel_data.get("Header_Name_Table");
		String Expensive_Table_Headers = Excel_data.get("Expensive_Table_Headers");
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
				
		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency ", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency ", test, test1);
		
		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);
		
		Step_Start(3, "Click on the global search option which is available in the tool bar.  ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(3, "Click on the global search option which is available in the tool bar.  ", test, test1);
		
		Step_Start(4, "Check whether it opens a new search window.  ", test, test1);
		Step_Start(5, "Enter the required CAR No. in the CAR No search field.    ", test, test1);
		Step_Start(6, "Then click on the search button", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button. ", test, test1);

		globalValueSearchWindow(driver,CAR_Retrieve_Condition,CAR_Retrieve_Type,CAR_Number_Retrieve,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);

		Step_End(7, "System will show the CAR No. and Click on the select button. ", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field.    ", test, test1);
		Step_End(4, "Check whether it opens a new search window.  ", test, test1);
		
		Step_Start(8, "System will retrieve the CAR ", test, test1);
		waitForElement(driver, Predictable_Reporting_CAR);
		Step_End(8, "System will retrieve the CAR ", test, test1);
		
		Step_Start(9, ".Click the predictable reporting tab.", test, test1);
		click(driver,Predictable_Reporting_CAR);
		waitForElement(driver, Predictable_Table_CAR);
		Step_End(9, ".Click the predictable reporting tab.", test, test1);
		
		Step_Start(10, "Copy the head of all the activities in the predictable reporting tab.", test, test1);
		
		reArrangeAG_GridColumns(driver, Predictable_Table_Headers);
		
		List<Map<String, String>> PredicatableReport_Table = extractTableDataByColumnWithoutScroll(driver,Predictable_Table_CAR);
		System.out.println("PredicatableReport_Table : "+PredicatableReport_Table);
		List<String>  GetHead_Values_Predictable=getValuesByHeader(PredicatableReport_Table,Header_Name_Table);
		
		GetHead_Values_Predictable=removeDuplicates(GetHead_Values_Predictable);
		Step_End(10, "Copy the head of all the activities in the predictable reporting tab.", test, test1);

		Step_Start(11, "Click on the expense report.", test, test1);
		waitForElement(driver, Expensive_Report_Btn_CAR);
		click(driver,Expensive_Report_Btn_CAR);
		Step_End(11, "Click on the expense report.", test, test1);
		
		Step_Start(12, "Select the open expense tab and check whether the copied head of the activities from the predictable reporting tab matches with the head of the activities present in the open expense tab", test, test1);
		waitForElement(driver, Expensive_Table_CAR);
		
		List<String> Actual_Predictable_Header=new ArrayList<String>();
		waitForElement(driver, Expensive_Column_Filt_CAR);
		click(driver, Expensive_Column_Filt_CAR);
		waitForElement(driver, Expensive_Filter_input_CAR);
		jsClick(driver, SelectAll_Checkbox_Expensive_CAR);
		
		List<String> ExpensiveTable_Headers=splitAndExpand(Expensive_Table_Headers);
		for(String FilterHeader : ExpensiveTable_Headers) {
			waitForElement(driver, Expensive_Filter_input_CAR);
			clear(driver, Expensive_Filter_input_CAR);
			waitForElement(driver, Expensive_Filter_input_CAR);
			sendKeys(driver, Expensive_Filter_input_CAR,FilterHeader);
		
			String checkbox=String.format(Select_Column_Expensive_CAR,FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}
		Step_End(12, "Select the open expense tab and check whether the copied head of the activities from the predictable reporting tab matches with the head of the activities present in the open expense tab", test, test1);
		
		Step_Start(13, "If it is  matched Ensure that \"Is predictable\" check box is selected for the activities.", test, test1);
		jsClick(driver, Expensive_Column_Filt_CAR);
		
		waitForElement(driver, Expensive_Table_CAR);
		
		if(isDisplayed(driver, Selected_Expensive_Head_CAR)) {
			List<WebElement>  expesivehead=listOfElements(driver, Selected_Expensive_Head_CAR);
			for(WebElement ele:expesivehead) {
				Actual_Predictable_Header.add(ele.getText());
			}
		}
		Step_End(13, "If it is  matched Ensure that \"Is predictable\" check box is selected for the activities.", test, test1);

		Step_Start(15, "Then select the Approved expenses tab.", test, test1);
		waitForElement(driver, Approved_Expensive_CAR);
		click(driver,Approved_Expensive_CAR);
		Step_End(15, "Then select the Approved expenses tab.", test, test1);

		Step_Start(16, "Check whether the copied head of the activities from the predictable reporting tab matches with the head of the activities present in the open expense tab.", test, test1);

		waitForElement(driver, App_Expensive_Table_CAR);
		
		waitForElement(driver, App_Expensive_Column_Filt_CAR);
		click(driver, App_Expensive_Column_Filt_CAR);
		waitForElement(driver, App_Expensive_Filter_input_CAR);
		jsClick(driver, App_SelectAll_Checkbox_Expensive_CAR);
		
		List<String> AppExpensiveTable_Headers=splitAndExpand(Expensive_Table_Headers);
		for(String FilterHeader : AppExpensiveTable_Headers) {
			waitForElement(driver, App_Expensive_Filter_input_CAR);
			clear(driver, App_Expensive_Filter_input_CAR);
			waitForElement(driver, App_Expensive_Filter_input_CAR);
			sendKeys(driver, App_Expensive_Filter_input_CAR,FilterHeader);
		
			String checkbox=String.format(App_Select_Column_Expensive_CAR,FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}
		jsClick(driver, App_Expensive_Column_Filt_CAR);

		Step_End(16, "Check whether the copied head of the activities from the predictable reporting tab matches with the head of the activities present in the open expense tab.", test, test1);

		Step_Start(17, "If it is  matched Ensure that \"Is predictable\" check box is selected for the activities", test, test1);
		waitForElement(driver, App_Expensive_Table_CAR);
		
		if(isDisplayed(driver, Selected_App_Expensive_Head_CAR)) {
			List<WebElement>  expesivehead=listOfElements(driver, Selected_App_Expensive_Head_CAR);
			for(WebElement ele:expesivehead) {
				Actual_Predictable_Header.add(ele.getText());
			}
		}
		Step_End(17, "If it is  matched Ensure that \"Is predictable\" check box is selected for the activities", test, test1);
		
		Step_Start(18, "If it is not matched Ensure that \"Is predictable\" check box is not selected for the activities", test, test1);
		if(compareLists(GetHead_Values_Predictable,Actual_Predictable_Header)) {
			System.out.println("Expected : Is Predictable CheckBox Should be Matched with Predictable Table Head || Actual : Is Predictable CheckBox Matched with Predictable Table Head");
			Extent_pass_New(driver,"Expected : Is Predictable CheckBox Should be Matched with Predictable Table Head || Actual : Is Predictable CheckBox Matched with Predictable Table Head", test, test1);
		}else {
			System.out.println("Expected : Is Predictable CheckBox Should be Matched with Predictable Table Head || Actual : Is Predictable CheckBox not Matched with Predictable Table Head");
			Extent_fail(driver, "Expected : Is Predictable CheckBox Should be Matched with Predictable Table Head || Actual : Is Predictable CheckBox not Matched with Predictable Table Head", test, test1);
		}
		
		Step_End(18, "If it is not matched Ensure that \"Is predictable\" check box is not selected for the activities", test, test1);
		
		Extent_completed(tc_Name, test, test1);
		
	}
	
}
