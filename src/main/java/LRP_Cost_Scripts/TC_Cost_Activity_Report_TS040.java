package LRP_Cost_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS040 extends Keywords{
	
	public void  Cost_Activity_Report_TS040(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS040";
		
		
		
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		
		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		
		String Car_opened_Popup_Text = Excel_data.get("Car_opened_Popup_Text");
		
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
		
		Step_Start(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		
		Step_Start(3, "Click on the global search option which is available in the tool bar.    ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(3, "Click on the global search option which is available in the tool bar.    ", test, test1);
		
		Step_Start(4, "Check whether it opens a new search window. ", test, test1);
		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button. ", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button. ", test, test1);

		globalValueSearchWindow(driver,CAR_Retrieve_Condition,CAR_Retrieve_Type,CAR_Number_Retrieve,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);

		Step_End(7, "System will show the CAR No. and Click on the select button. ", test, test1);
		Step_End(6, "Then click on the search button. ", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_End(4, "Check whether it opens a new search window. ", test, test1);
		
		Step_Start(8, "System will retrieve the CAR. ", test, test1);
		waitForElement(driver, CAR_Open_Button);
		Step_End(8, "System will retrieve the CAR. ", test, test1);
		
		Step_Start(9, "Ensure that CAR is closed which can be identified by seeing the CAR closed message near Agenc ", test, test1);
		VerifyElementDisplayed(driver, CAR_Closed_Label);
		Step_End(9, "Ensure that CAR is closed which can be identified by seeing the CAR closed message near Agenc ", test, test1);
		
		Step_Start(10, "Click on the CAR open option", test, test1);
		click(driver,CAR_Open_Button);
		Step_End(10, "Click on the CAR open option", test, test1);
		
		Step_Start(11, "Ensure that system validates as \"CAR opened successfully. Kindly refresh the CAR\".", test, test1);
		waitForPopup(driver, popup_Message, Car_opened_Popup_Text);
		String PopupText_Act=getText(driver, popup_Message);
		
		if(PopupText_Act.equals(Car_opened_Popup_Text)) {
			System.out.println("Popup Matched  ||   Expected : "+Car_opened_Popup_Text+"   ||   Actual   : "+PopupText_Act);
			Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Car_opened_Popup_Text+"   ||   Actual   : "+PopupText_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected : "+Car_opened_Popup_Text+"   ||   Actual   : "+PopupText_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Car_opened_Popup_Text+"   ||   Actual   : "+PopupText_Act, test, test1);
		}
		Step_End(11, "Ensure that system validates as \"CAR opened successfully. Kindly refresh the CAR\".", test, test1);
	
		Step_Start(12, "Click  on the ok option.", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		Step_End(12, "Click  on the ok option.", test, test1);
		
		Step_Start(13, "Ensure that system doesn't shows as CAR closed information near Agency and the CAR open option changes to CAR close option.", test, test1);
		waitForElement(driver, CAR_Close_Button);
		
		if(isdisplayed(driver, CAR_Closed_Label)) {
			System.out.println("Expected : CAR Closed Label Should not display after Open the CAR  || Actual : CAR Closed Label is displayed after Open the CAR  ");
			Extent_fail(driver, "Expected : CAR Closed Label Should not display after Open the CAR  || Actual : CAR Closed Label is displayed after Open the CAR  ", test, test1);
		}else {
			System.out.println("Expected : CAR Closed Label Should not display after Open the CAR  || Actual : CAR Closed Label is not displayed after Open the CAR  ");
			Extent_pass_New(driver, "Expected : CAR Closed Label Should not display after Open the CAR  || Actual : CAR Closed Label is not displayed after Open the CAR  ", test, test1);
		
		}
		
		Step_End(13, "Ensure that system doesn't shows as CAR closed information near Agency and the CAR open option changes to CAR close option.", test, test1);

		Extent_completed(tc_Name, test, test1);
		
	}
}
