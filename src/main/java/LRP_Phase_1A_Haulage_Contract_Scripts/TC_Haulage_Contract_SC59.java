package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC59  extends Keywords{
	public void Haulage_Contract_SC59(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC59";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Contarct_Numer_Header = Excel_data.get("Contarct_Numer_Header");
		String condition = Excel_data.get("condition");
		String Contract_Number = Excel_data.get("Contract_Number");
		String Refresh_Pop_Expected = Excel_data.get("Refresh_Pop_Expected");
		

	



		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		Step_Start(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		moduleNavigate(driver, Haulage_Contract_Module_Name);
		
		Step_End(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		Step_Start(2, "Click on the global search option which is available in the tool bar.", test, test1);
	
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(2, "Click on the global search option which is available in the tool bar.", test, test1);
		Step_Start(3, "Check whether the system opens the contract details search window.         ", test, test1);
		Step_Start(4, "Enter the saved hlg contract number in the contract number search field.        .", test, test1);
		Step_Start(5, "Click on the search button.     .", test, test1);
		Step_Start(6, "System will show cotract details based on the Contarct number .", test, test1);
		Step_Start(7, "Double click the Contract detials.          .", test, test1);
		globalValueSearchWindow(driver, condition, Contarct_Numer_Header, Contract_Number, "", "", "", "");
		Step_End(3, "Check whether the system opens the contract details search window.         ", test, test1);
		Step_End(4, "Enter the saved hlg contract number in the contract number search field.        .", test, test1);
		Step_End(5, "Click on the search button.     .", test, test1);
		Step_End(6, "System will show cotract details based on the Contarct number .", test, test1);
		Step_End(7, "Double click the Contract detials.          .", test, test1);
		waitForElement(driver, HC_Contarct_Number_Field);	 
		 String validation = getAttribute(driver, HC_Contarct_Number_Field,"value");
		 System.out.println(validation);
			Step_Start(8, "Check whether the system retrieves the saved contract number. ", test, test1);
			
			 if(validation.equals(Contract_Number)) {
	        	 System.out.println("Matched||Expected Value From test data :"+Contract_Number + " || Actual Value Taken after global search the contract number: "+validation);
	        	 Extent_pass_New(driver, "Matched||Expected Value From test data:"+Contract_Number + "||  Actual Value Taken after global search the contract number : "+validation, test, test1);
	         }else {
	        	 System.out.println("NotMatched ||Expected Value From test data:"+Contract_Number + "|| Actual Value Taken after global search the contract number  : "+validation);
	             Extent_fail(driver, "NotMatched ||Expected Value From test data :"+Contract_Number + "|| Actual Value Taken after global search the contract number: "+validation, test, test1);
	         }
		 Step_End(8, "Check whether the system retrieves the saved contract number. ", test, test1);
			
			waitForElement(driver, HC_show_All_Radio_Button);
			click(driver, HC_show_All_Radio_Button);
		 
			waitForElement(driver, HC_Refresh_Button);
			click(driver, HC_Refresh_Button);
			Step_Start(9, "Click the Refresh cache ,It should refresh all the details",test, test1);
			
			waitForElement(driver, popup_Message);	 
	   		 String Refresh_Pop_Actual = getText(driver, popup_Message);
	   		 System.out.println(Refresh_Pop_Actual);
	   		 
	   		 if(Refresh_Pop_Expected.equals(Refresh_Pop_Actual)) {
	           	 System.out.println("Matched||Expected Value Popup is  :"+Refresh_Pop_Expected + " || Actual Value Popup is: "+Refresh_Pop_Actual);
	           	 Extent_pass_New(driver, "Matched||Expected Value Popup is:"+Refresh_Pop_Expected + " || Actual Value Popup is : "+Refresh_Pop_Actual, test, test1);
	            }else {
	           	 System.out.println("NotMatched ||Expected Value Popup is:"+Refresh_Pop_Expected + " || Actual Value Popup is  : "+Refresh_Pop_Actual);
	                Extent_fail(driver, "NotMatched ||Expected Value Popup is :"+Refresh_Pop_Expected + " || Actual Value Popup is: "+Refresh_Pop_Actual, test, test1);
	            }
		 
	   		waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(9, "Click the Refresh cache ,It should refresh all the details",test, test1);
			
		 
		 Extent_completed(testcase_Name, test, test1);
}}
