package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC001 extends Keywords{
	public void Import_Documentation_SC001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC001";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Module_Search_BL = Excel_data.get("Module_Search");
		String New_button_verify = Excel_data.get("New_button_verify");
		String Search_button_verify = Excel_data.get("Search_button_verify");
		String Save_button_verify = Excel_data.get("Edit_button_verify");
		String Edit_button_verify = Excel_data.get("New_button_verify");
		String Delete_button_verify = Excel_data.get("Delete_button_verify");
		String Cancel_button_verify = Excel_data.get("Cancel_button_verify");
		String Saveas_button_verify = Excel_data.get("Saveas_button_verify");
		String export_button_verify = Excel_data.get("export_button_verify");
		String Print_button_verify = Excel_data.get("Print_button_verify");
		String First_button_verify = Excel_data.get("First_button_verify");
		String Previous_button_verify = Excel_data.get("Previous_button_verify");
		String Next_button_verify = Excel_data.get("Next_button_verify");
		String Last_button_verify = Excel_data.get("Last_button_verify");
		String Navigate_button_verify = Excel_data.get("Navigate_button_verify");
		String Auto_save_button_verify = Excel_data.get("Auto_save_button_verify");


		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		Step_Start(1, "Switch to agency" , test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency" , test, test1);
		
		Step_Start(2, "open the Import Documentation module" , test, test1);
		moduleNavigate(driver, Module_Search_BL);
		Step_End(2, "open the Import Documentation module" , test, test1);
		Step_Start(3, "In tool bar save button and cancel should enable " , test, test1);
		
		if(Save_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, SaveButton_ToolBar);
			if(isElementEnabled(driver, SaveButton_ToolBar)) {
				System.out.println("Expected Result :  Save button Should be clickable || Actual Result : Save Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Save button Should be clickable || Actual Result : Save Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Save button Should be clickable || Actual Result : Save Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Save button Should be clickable || Actual Result : Save Button is Not clickable", test, test1);
			}			
		}
		if(Cancel_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, cancel_Common_btn);
			if(isElementEnabled(driver, cancel_Common_btn)) {
				System.out.println("Expected Result :  Cancel button Should be clickable || Actual Result : Cancel Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Cancel button Should be clickable || Actual Result : Cancel Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Cancel button Should be clickable || Actual Result : Cancel Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Cancel button Should be clickable || Actual Result : Cancel Button is Not clickable", test, test1);
			}	
			
			
		}
		Step_End(3, "In tool bar save button and cancel should enable " , test, test1);
		Step_Start(4, " other all fields should disable " , test, test1);
		if(New_button_verify.equalsIgnoreCase("YES")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(isElementEnabled(driver, NewButton_ToolBar)) {
				System.out.println("Expected Result :  New button Should be clickable || Actual Result : New Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  New button Should be clickable || Actual Result : New Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  New button Should be clickable || Actual Result : New Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  New button Should be clickable || Actual Result : New Button is Not clickable", test, test1);
			}	
		}
		
		if(Search_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, SearchButton_Toolbar);
			if(isElementEnabled(driver, SearchButton_Toolbar)) {
				System.out.println("Expected Result :  Search button Should be clickable || Actual Result : Search Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Search button Should be clickable || Actual Result : Search Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Search button Should be clickable || Actual Result : Search Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Search button Should be clickable || Actual Result : Search Button is Not clickable", test, test1);
			}	
		}
	
		if(Edit_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, Edit_Button_toolBar);
			if(isElementEnabled(driver, Edit_Button_toolBar)) {
				System.out.println("Expected Result :  Edit button Should be clickable || Actual Result : Edit Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Edit button Should be clickable || Actual Result : Edit Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Edit button Should be clickable || Actual Result : Edit Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Edit button Should be clickable || Actual Result : Edit Button is Not clickable", test, test1);
			}	
		}
		
		if(Delete_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, Delete_button_toolBar);
			if(isElementEnabled(driver, Delete_button_toolBar)) {
				System.out.println("Expected Result :  Delete button Should be clickable || Actual Result : Delete Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Delete button Should be clickable || Actual Result : Delete Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Delete button Should be clickable || Actual Result : Delete Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Delete button Should be clickable || Actual Result : Delete Button is Not clickable", test, test1);
			}	
		}
		
		if(Saveas_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, SaveAs_button_toolBar);
			if(isElementEnabled(driver, SaveAs_button_toolBar)) {
				System.out.println("Expected Result :  Save As button Should be clickable || Actual Result : Save As Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Save As button Should be clickable || Actual Result : Save As Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Save As button Should be clickable || Actual Result : Save As Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Save As button Should be clickable || Actual Result : Save As Button is Not clickable", test, test1);
			}	
			
			
		}
		
		if(export_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, Export_button_Toolbar);
			if(isElementEnabled(driver, Export_button_Toolbar)) {
				System.out.println("Expected Result :  Export button Should be clickable || Actual Result : Export Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Export button Should be clickable || Actual Result : Export Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Export button Should be clickable || Actual Result : Export Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Export button Should be clickable || Actual Result : Export Button is Not clickable", test, test1);
			}	
		}
		if(Print_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, print_Common_btn);
			if(isElementEnabled(driver, print_Common_btn)) {
				System.out.println("Expected Result :  Print button Should be clickable || Actual Result : Print Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Print button Should be clickable || Actual Result : Print Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Save button Should be clickable || Actual Result : Save Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Save button Should be clickable || Actual Result : Save Button is Not clickable", test, test1);
			}	
		}
		
		if(First_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, first_Common_btn);
			if(isElementEnabled(driver, first_Common_btn)) {
				System.out.println("Expected Result :  First Navigate button Should be clickable || Actual Result : First Navigate Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  First Navigate button Should be clickable || Actual Result : First Navigate Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  First Navigate button Should be clickable || Actual Result : First Navigate Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  First Navigate button Should be clickable || Actual Result : First Navigate Button is Not clickable", test, test1);
			}	
		}
		
		if(Previous_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, prev_Common_btn);
			if(isElementEnabled(driver, prev_Common_btn)) {
				System.out.println("Expected Result :  Previous Navigate button Should be clickable || Actual Result : Previous Navigate Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Previous Navigate button Should be clickable || Actual Result : Previous Navigate Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Previous Navigate button Should be clickable || Actual Result : Previous Navigate Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Previous Navigate button Should be clickable || Actual Result : Previous Navigate Button is Not clickable", test, test1);
			}	
		}
		
		
		if(Next_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, next_Common_btn);
			if(isElementEnabled(driver, next_Common_btn)) {
				System.out.println("Expected Result :  Next Navigate button Should be clickable || Actual Result : Next Navigate Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Next Navigate button Should be clickable || Actual Result : Next Navigate Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Next Navigate button Should be clickable || Actual Result : Next Navigate Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Next Navigate button Should be clickable || Actual Result : Next Navigate Button is Not clickable", test, test1);
			}	
		}

		if(Last_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, last_Common_btn);
			if(isElementEnabled(driver, last_Common_btn)) {
				System.out.println("Expected Result :  Last Navigate button Should be clickable || Actual Result : Last Navigate Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Last Navigate button Should be clickable || Actual Result : Last Navigate Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Last Navigate button Should be clickable || Actual Result : Last Navigate Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Last Navigate button Should be clickable || Actual Result : Last Navigate Button is Not clickable", test, test1);
			}	
		}
		if(Navigate_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, navigate_Common_btn);
			if(isElementEnabled(driver, navigate_Common_btn)) {
				System.out.println("Expected Result :  Navigate button Should be clickable || Actual Result : Navigate Button is clickable ");
				Extent_pass_New(driver, "Expected Result :  Navigate button Should be clickable || Actual Result : Navigate Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result :  Navigate button Should be clickable || Actual Result : Navigate Button is Not clickable");
				Extent_pass_New(driver, "Expected Result :  Navigate button Should be clickable || Actual Result : Navigate Button is Not clickable", test, test1);
			}	
		}
		if(Auto_save_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, Autosave_Common_btn);
			if(isElementEnabled(driver, Autosave_Common_btn)) {
				System.out.println("Expected Result : Auto Save button Should be clickable || Actual Result : Auto Save Button is clickable ");
				Extent_pass_New(driver, "Expected Result : Auto Save button Should be clickable || Actual Result : Auto Save Button is clickable", test, test1);
			}else {
				
				System.out.println("Expected Result : Auto Save button Should be clickable || Actual Result : Auto Save Button is Not clickable");
				Extent_pass_New(driver, "Expected Result : Auto Save button Should be clickable || Actual Result : Auto Save Button is Not clickable", test, test1);
			}	
		}
		Step_End(4, " other all fields should disable " , test, test1);

		Extent_completed(testcase_Name, test, test1);
    }
}
