package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS058 extends Keywords {
	public void  Cost_Activity_Report_TS058(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
	
	String tc_Name = "TC_Cost_Activity_Report_TS058";
	String username = Excel_data.get("Username");
	String password = Excel_data.get("Password");
	String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
	String Rejected_pop =Excel_data.get("Rejected_pop");
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
	
	moduleNavigate(driver, Cost_Activity_Report_Module);
	
	Step_End(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);
	
	verifyMainMenu(driver);
	
	Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);
	
	
	waitForElement(driver, seach_Filed);
	click(driver, seach_Filed);
	
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
		
	 List<WebElement> Invoice_NumberColumns=listOfElements(driver, Invoice_Column_MSC_Table_CAR);
	 Actions act=new Actions(driver);
	 act.keyDown(Keys.CONTROL).build().perform();
	 for(int i=0;i<Invoice_NumberColumns.size();i++) {
		 String invoiceNum=Invoice_NumberColumns.get(i).getText();
		 if(!invoiceNum.equals("")) {
			 act.moveToElement(Invoice_NumberColumns.get(i)).build().perform();
			 Invoice_NumberColumns.get(i).click();
		 }
	 }
	 act.keyUp(Keys.CONTROL).build().perform();
	 
	  waitForElement(driver, miss_Rejec);
	  click(driver, miss_Rejec); 
		  
	  Step_End(9, "Select the activities from the grid and click on the reject option", test, test1);
		 
	  Step_Start(10, "If the activities are invoiced and disbursement in taken, system validates as  Invoiced activity cannot be rejected", test, test1); 
	
	  waitForPopup(driver, popup_Message, Rejected_pop);
	  String reject_pop =getText(driver, popup_Message);
	  System.out.println("reject_pop :"+reject_pop);
			 
	  if(Rejected_pop.equals(reject_pop)) {
		  System.out.println("Matched || Exp Popup :"+reject_pop +"actual value :"+Rejected_pop);
		  Extent_pass_New(driver, "Matched || Exp Popup is : " + reject_pop + " || Actual Report Activity is : " + Rejected_pop, test,test1); 
	  }else {
		  System.out.println("Not Matched || Exp Popup :"+reject_pop +" || Actual Popup :"+Rejected_pop);
		  Extent_fail(driver, "Not Matched || Exp Popup is : " + reject_pop + " || Actual Popup is : " + Rejected_pop, test,test1); 
	  }
	  
	  Step_End(10, "If the activities are invoiced and disbursement in taken, system validates as  Invoiced activity cannot be rejected", test, test1); 
	  
	  Step_Start(11, "Click on the ok option", test, test1); 
	  
	  waitForElement(driver, popup_Message_Ok_Button);
	  click(driver, popup_Message_Ok_Button); 
			 
	  Step_End(11, "Click on the ok option", test, test1); 	 
			
	  Extent_completed(tc_Name, test, test1);
	
	}
}
