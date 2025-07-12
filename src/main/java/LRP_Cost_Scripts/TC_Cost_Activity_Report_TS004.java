package LRP_Cost_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS004 extends Keywords {

	public void Cost_Activity_Report_TS004(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS004";
		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Approved_status = Excel_data.get("Approved_status");
		String Delete_popup_message = Excel_data.get("Delete_popup_message");
		String CAR_Retrieve_Type1 = Excel_data.get("CAR_Retrieve_Type1");
		String CAR_Retrieve_Condition1 = Excel_data.get("CAR_Retrieve_Condition1");
		String CAR_Number_Retrieve_Value1 = Excel_data.get("CAR_Number_Retrieve_Value1");

		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		String Delete_popup = Excel_data.get("Delete_popup");
		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select the required agency.",
				test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.",
				test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		waitForElement(driver, Global_Search);
		click(driver, Global_Search);

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

		globalValueSearchWindow(driver, CAR_Retrieve_Condition1, CAR_Retrieve_Type1, CAR_Number_Retrieve_Value1,
				CAR_Retrieve_Type2, CAR_Number_Retrieve_Value2, CAR_Retrieve_Type3, CAR_Number_Retrieve_Value3);

		Step_End(8, "Click on the select button.", test, test1);
		Step_End(7, "System will show the CAR No. and Click on the select button", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);

		Step_Start(9, "System will retrieve the CAR", test, test1);

		waitForElement(driver, car_Number_val);
		String Carvalue = getAttribute(driver, car_Number_val, "value");

		System.out.println("Carvalue :" + Carvalue);


		Step_End(9, "System will retrieve the CAR", test, test1);

		Step_Start(10, "Click on the Expense Report button", test, test1);

		waitForElement(driver, Expensive_Report_Btn_CAR);
		click(driver, Expensive_Report_Btn_CAR);
		
		waitForElement(driver, Approved_Expensive);
		click(driver, Approved_Expensive);
		
		boolean Approved=false;
		if(isdisplayed(driver, Approved_Expensive_all_values)) {
			Approved=true;
			System.out.println("Expected : After click on Expense Report button , Approval status Should be display || Actual : After click on Expense Report button , Approval status is display Successfully : "+Approved);
			Extent_pass_New(driver, "Expected : After click on Expense Report button , Approval status Should be display || Actual : After click on Expense Report button , Approval status is display Successfully", test, test1);
		}else {
			
			Approved=false;
		}
		
		waitForElement(driver,Expense_Close);
		click(driver, Expense_Close);
		
		
		Step_End(10, "Click on the Expense Report button", test, test1);
		
		Step_Start(11, "Check whether the activities are in approved status", test, test1);

		waitForElement(driver, CAR_Expense_Status);
		String Status_values = getText(driver, CAR_Expense_Status);
		System.out.println("Status_values :" + Status_values);
		
		if(Approved_status.equals(Status_values)) {
			System.out.println(" Matched  ||   Expected Status : "+Approved_status+"   ||   Actual Status  : "+Status_values);
			Extent_pass_New(driver, " Matched  ||   Expected Status : "+Approved_status+"   ||   Actual Status  : "+Status_values, test, test1);
		}else {
			System.out.println(" Not Matched  ||   Expected Status : "+Approved_status+"   ||   Actual Status  : "+Status_values);
			Extent_fail(driver, " Not Matched  ||   Expected Status : "+Approved_status+"   ||   Actual Status  : "+Status_values, test, test1);
		}
		
		
		
		Step_End(11, "Check whether the activities are in approved status", test, test1);
		

		Step_Start(12, "Then Click on the tool bar delete option", test, test1);
		
	
		waitForElement(driver, Delete);
		click(driver, Delete);
		
		Step_End(12, "Then Click on the tool bar delete option", test, test1);
		
		Step_Start(13, "Check whether the system populates the validation message as Do you want to delete Container Activity Report?", test, test1);
		
		
		waitForPopup(driver, popup_Message, Delete_popup);
		String Popup_Text_Act_val=getText(driver, popup_Message);
		
		if(Popup_Text_Act_val.equals(Delete_popup)) {
			System.out.println("Popup Matched  ||  Expected Popup : "+Delete_popup+"   ||   Actual Popup : "+Popup_Text_Act_val);
			Extent_pass_New(driver, "Popup Matched  ||  Expected Popup : "+Delete_popup+"   ||   Actual Popup : "+Popup_Text_Act_val, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||  Expected Popup : "+Delete_popup+"   ||   Actual Popup : "+Popup_Text_Act_val);
			Extent_fail(driver, "Popup Not Matched  ||  Expected Popup : "+Delete_popup+"   ||   Actual Popup : "+Popup_Text_Act_val, test, test1);
		}
		
		Step_End(13, "Check whether the system populates the validation message as Do you want to delete Container Activity Report?", test, test1);	
		
		Step_Start(14, "Click on Yes", test, test1);
		
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		
		Step_End(14, "Click on Yes", test, test1);
		
		Step_Start(15, "Check whether the system shows the validation message like  Expense is approved for some activities. CAR cannot be deleted", test, test1);
		
		waitForPopup(driver, popup_Message, Delete_popup_message);
		String Popup_Delete_Act_val=getText(driver, popup_Message);
		
		if(Popup_Delete_Act_val.equals(Delete_popup_message)) {
			System.out.println("Popup Matched  ||   Expected : "+Delete_popup_message+"   ||   Actual   : "+Popup_Delete_Act_val);
			Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Delete_popup_message+"   ||   Actual   : "+Popup_Delete_Act_val, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected : "+Delete_popup_message+"   ||   Actual   : "+Popup_Delete_Act_val);
			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Delete_popup_message+"   ||   Actual   : "+Popup_Delete_Act_val, test, test1);
		}
		

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(15, "Check whether the system shows the validation message like  Expense is approved for some activities. CAR cannot be deleted", test, test1);	
		
		
		Extent_completed(tc_Name, test, test1);		
		
		
		
	}
}