package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS059 extends Keywords{
   
	public void  Cost_Activity_Report_TS059(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS059";
	
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Submitted_Approved_pop = Excel_data.get("Submitted_Approved_pop");
		String Activity_Rejected_Popup = Excel_data.get("Activity_Rejected_Popup");
		String Header_value = Excel_data.get("Header_value");
		String AgencyUser =Excel_data.get("AgencyUser");
		String CAR_Retrieve_Type1 = Excel_data.get("CAR_Retrieve_Type1");
		String CAR_Retrieve_Condition1 = Excel_data.get("CAR_Retrieve_Condition1");
		String CAR_Number_Retrieve_Value1 = Excel_data.get("CAR_Number_Retrieve_Value1");
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		Extent_Start(tc_Name, test, test1);

		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);

		navigateUrl(driver, url);

		Step_End(1, "Once login to the application and click on switch profile option and select the required agency", test, test1);
		
		Step_Start(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);
		
		LRP_Login(driver, username, password);
		SwitchProfile(driver, AgencyUser);

		
		Step_End(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);
		
		verifyMainMenu(driver);
		
		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);
		
		moduleNavigate(driver, Cost_Activity_Report_Module);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);
		
		Step_Start(4, "Check whether it opens a new search window. ", test, test1);
		
		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button", test, test1);
		
		globalValueSearchWindow(driver,CAR_Retrieve_Condition1,CAR_Retrieve_Type1,CAR_Number_Retrieve_Value1,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(4, "Check whether it opens a new search window. ", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		Step_End(7, "System will show the CAR No. and Click on the select button", test, test1);
		
		Step_Start(8, "System will retrieve the CAR", test, test1);
		
		waitForElement(driver, car_Number_val);
		String Carvalue =getAttribute(driver, car_Number_val, "value");
		
		System.out.println("Carvalue :"+Carvalue);
		
		 Step_End(8, "System will retrieve the CAR", test, test1);	
		 
		 Step_Start(9, "Select the activities from the grid and click on the reject option", test, test1); 
			
		 waitForElement(driver, CAR_Number_Input_CAR);
		 click(driver, MSC_Column_Filt_CAR);
		 waitForElement(driver, MSC_Filter_input_CAR);
		 jsClick(driver, MSC_SelectAll_Checkbox_CAR);
		 
		 List<String> ExpensiveTable_Headers=splitAndExpand(Header_value);
		 for(String FilterHeader : ExpensiveTable_Headers) {
			 waitForElement(driver, MSC_Filter_input_CAR);
			 clear(driver, MSC_Filter_input_CAR);
			 waitForElement(driver, MSC_Filter_input_CAR);
			 sendKeys(driver, MSC_Filter_input_CAR,FilterHeader);
		
			 String checkbox=String.format(Select_Column_MSC_CAR,FilterHeader);
			 waitForDisplay(driver, checkbox);
			 jsClick(driver, checkbox);
		 }
		 jsClick(driver, MSC_Column_Filt_CAR);
		
		 Step_End(9, "Select the activities from the grid and click on the reject option", test, test1);
	
		 Step_Start(11, ".If the activities are in submitted or approved status, System validates as   Activities are rejected Click on the ok option", test, test1); 	
		 
		 List<WebElement> statusColumn=listOfElements(driver, Status_Columns_MSC_Table_CAR);
		 Actions act=new Actions(driver);
		 act.keyDown(Keys.CONTROL).build().perform();
		 boolean submit=false;
		 for (int i=0;i<statusColumn.size();i++) {
			 String statusValue=statusColumn.get(i).getText();
			 if(statusValue.equals("Submitted")||statusValue.contains("Approved")) {
				 act.moveToElement(statusColumn.get(i)).build().perform();
				 statusColumn.get(i).click();
				 submit=true;
			 }	 
		 }
		 act.keyUp(Keys.CONTROL).build().perform();
		 
		 if(submit) {
			 waitForElement(driver, miss_Rejec);
			 click(driver, miss_Rejec); 
			 
			 waitForPopup(driver, popup_Message, Activity_Rejected_Popup);
			 String reject_pop =getText(driver, popup_Message);
			 System.out.println("reject_pop :"+reject_pop);
			 
			 if(Activity_Rejected_Popup.equals(reject_pop)) {
				 System.out.println("Matched || Activities are in submitted or approved status, then Expected Popup  :"+Activity_Rejected_Popup +" || Actual Popup :"+reject_pop);
				 Extent_pass_New(driver, "Matched || Activities are in submitted or approved status, then Expected Popup : " + Activity_Rejected_Popup + " || Actual Popup is : " + reject_pop, test,test1); 
			 }else {
				 System.out.println("Not Matched || Activities are in submitted or approved status, then Expected Popup :"+Activity_Rejected_Popup +" || Actual Popup :"+reject_pop);
				 Extent_fail(driver, "Not Matched || Activities are in submitted or approved status, then Expected Popup : " + Activity_Rejected_Popup + " || Actual Popup is : " + reject_pop, test,test1); 
			 }
			 
			 waitForElement(driver, popup_Message_Ok_Button);
			 click(driver, popup_Message_Ok_Button); 
			 
			 waitForElement(driver, CAR_Number_Input_CAR);
			 click(driver, MSC_Column_Filt_CAR);
			 waitForElement(driver, MSC_Filter_input_CAR);
			 jsClick(driver, MSC_SelectAll_Checkbox_CAR);
			 
			 for(String FilterHeader : ExpensiveTable_Headers) {
				 waitForElement(driver, MSC_Filter_input_CAR);
				 clear(driver, MSC_Filter_input_CAR);
				 waitForElement(driver, MSC_Filter_input_CAR);
				 sendKeys(driver, MSC_Filter_input_CAR,FilterHeader);
			
				 String checkbox=String.format(Select_Column_MSC_CAR,FilterHeader);
				 waitForDisplay(driver, checkbox);
				 jsClick(driver, checkbox);
			 }
			 jsClick(driver, MSC_Column_Filt_CAR);
		 }
		 
		 Step_End(11, ".If the activities are in submitted or approved status, System validates as   Activities are rejected Click on the ok option", test, test1); 	

		 Step_Start(10, "If the activities are in draft status, System validates as Activities are rejected. Click on the ok option", test, test1); 	 	 		
         Step_Start(12, "If the activities are already in rejected status, System validates as Only Submitted / Approved record(s) can be rejected.Click on the ok option", test, test1); 	      

        		 
		 statusColumn=listOfElements(driver, Status_Columns_MSC_Table_CAR);
		 act.keyDown(Keys.SHIFT).build().perform();
		 for (int i=0;i<statusColumn.size();i++) {
			 act.moveToElement(statusColumn.get(i)).build().perform();
			 statusColumn.get(i).click();
		 }
		 act.keyUp(Keys.SHIFT).build().perform();
		 
		 waitForElement(driver, miss_Rejec);
		 click(driver, miss_Rejec); 
            
		 waitForPopup(driver, popup_Message, Submitted_Approved_pop);
		 String reject_pop =getText(driver, popup_Message);
		 System.out.println("reject_pop :"+reject_pop);
		 
		 if(Submitted_Approved_pop.equals(reject_pop)) {
			 System.out.println("Matched || Activities are in Draft or rejected status, then Expected Popup  :"+Submitted_Approved_pop +" || Actual Popup :"+reject_pop);
			 Extent_pass_New(driver, "Matched || Activities are in Draft or rejected status, then Expected Popup : " + Submitted_Approved_pop + " || Actual Popup is : " + reject_pop, test,test1); 
		 }else {
			 System.out.println("Not Matched || Activities are in Draft or rejected status, then Expected Popup :"+Submitted_Approved_pop +" || Actual Popup :"+reject_pop);
			 Extent_fail(driver, "Not Matched || Activities are in Draft or rejected status, then Expected Popup : " + Submitted_Approved_pop + " || Actual Popup is : " + reject_pop, test,test1); 
		 }
		 
		 waitForElement(driver, popup_Message_Ok_Button);
		 click(driver, popup_Message_Ok_Button); 
		 
         Step_End(12, "If the activities are already in rejected status, System validates as Only Submitted / Approved record(s) can be rejected.Click on the ok option", test, test1); 	      	 
		 Step_End(10, "If the activities are in draft status, System validates as Activities are rejected. Click on the ok option", test, test1); 	 	 		
            
		 Extent_completed(tc_Name, test, test1);	
	}
}