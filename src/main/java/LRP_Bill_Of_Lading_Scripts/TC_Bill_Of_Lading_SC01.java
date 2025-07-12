package LRP_Bill_Of_Lading_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Bill_Of_Lading_SC01  extends Keywords{
	
	
	public void Bill_Of_Lading_SC01(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Bill_Of_Lading_SC01";
		
		



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

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch to agency" , test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency" , test, test1);
	

		Step_Start(2, "open the Bill of Lading module" , test, test1);
		moduleNavigate(driver, Module_Search_BL);
		
		Step_End(2, "open the Bill of Lading module" , test, test1);
		Step_Start(3, "In tool bar save button and cancel should enable " , test, test1);
		
		if(Save_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, SaveButton_ToolBar);
			if(isElementEnabled(driver, SaveButton_ToolBar)) {
				
				Extent_pass_New(driver, "Matched || Expected Result is : Save button Should be Enable || Actual Result is :  Save button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  Save button Should be Enable || Actual Result is :Save button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  Save button not Should be Enable || Actual Result is : Save button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  Save button not Should be Enable || Actual Result is : Save button IS NOT Enable", test, test1);
			}
				
			
			
		}
		if(Cancel_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, cancel_Common_btn);
			if(isElementEnabled(driver, cancel_Common_btn)) {
				Extent_pass_New(driver, "Matched || Expected Result is : Cancle button Should be Enable || Actual Result is :  Cancle button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  Cancle button Should be Enable || Actual Result is :Cancle button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  Cancle button Should not be Enable || Actual Result is : Cancle button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  Cancle button Should not be Enable || Actual Result is : Cancle button IS NOT Enable", test, test1);
			}
				
			
			
		}
		Step_End(3, "In tool bar save button and cancel should enable " , test, test1);
		Step_Start(4, " other all fields should disable " , test, test1);
		if(New_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, NewButton_ToolBar);
			if(isElementEnabled(driver, NewButton_ToolBar)) {
				Extent_pass_New(driver, "Matched || Expected Result is : New button Should be Enable || Actual Result is :  New button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  New button Should be Enable || Actual Result is :New button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  New button Should not be Enable || Actual Result is : New button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  New button Should not be Enable || Actual Result is : New button IS NOT Enable", test, test1);
			}
			
			
			
		}
		
		if(Search_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, SearchButton_Toolbar);
			if(isElementEnabled(driver, SearchButton_Toolbar)) {
				
				Extent_pass_New(driver, "Matched || Expected Result is : Search button Should be Enable || Actual Result is :  Search button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  Search button Should be Enable || Actual Result is :Search button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  Search button Should not be Enable || Actual Result is : Search button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  Search button Should  not be Enable || Actual Result is : Search button IS NOT Enable", test, test1);
			}
		}
	
		if(Edit_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, Edit_Button_toolBar);
			if(isElementEnabled(driver, Edit_Button_toolBar)) {
			
				Extent_pass_New(driver, "Matched || Expected Result is : Edit button Should be Enable || Actual Result is :  Edit button IS Enable", test, test1);
			System.out.println("Matched || Expected Result is :  Edit button Should be Enable || Actual Result is :Edit button IS Enable");
		}else {
			System.out.println("Not Matched || Expected Result is :  Edit button Should not be Enable || Actual Result is : Edit button IS NOT Enable");
			Extent_pass_New(driver,"Not Matched || Expected Result is :  Edit button Should not be Enable || Actual Result is : Edit button IS NOT Enable", test, test1);
		}
	}
		if(Delete_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, Delete_button_toolBar);
			if(isElementEnabled(driver, Delete_button_toolBar)) {
				Extent_pass_New(driver, "Matched || Expected Result is : Delete button Should be Enable || Actual Result is :  Delete button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  Delete button Should be Enable || Actual Result is :Delete button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  Delete button Should not be Enable || Actual Result is : Delete button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  Delete button Should not be Enable || Actual Result is : Delete button IS NOT Enable", test, test1);
			}
		}
				
	
		
		if(Saveas_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, SaveAs_button_toolBar);
			if(isElementEnabled(driver, SaveAs_button_toolBar)) {
				Extent_pass_New(driver, "Matched || Expected Result is : SaveAS button Should be Enable || Actual Result is :  SaveAS button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  SaveAS button Should be Enable || Actual Result is :SaveAS button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  SaveAS button Should not be Enable || Actual Result is : SaveAS button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  SaveAS button Should not be Enable || Actual Result is : SaveAS button IS NOT Enable", test, test1);
			}
		}
			
		if(export_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, Export_button_toolBar);
			if(isElementEnabled(driver, Export_button_toolBar)) {
				Extent_pass_New(driver, "Matched || Expected Result is : export button Should be Enable || Actual Result is :  export button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  export button Should be Enable || Actual Result is :export button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  export button Should not be Enable || Actual Result is : export button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  export button Should not be Enable || Actual Result is : export button IS NOT Enable", test, test1);
			}
		}
			
		if(Print_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, print_Common_btn);
			if(isElementEnabled(driver, print_Common_btn)) {
				Extent_pass_New(driver, "Matched || Expected Result is : Print button Should be Enable || Actual Result is :  Print button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  Print button Should be Enable || Actual Result is :Print button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  Print button Should not be Enable || Actual Result is : Print button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  Print button Should not be Enable || Actual Result is : Print button IS NOT Enable", test, test1);
			}
		}
				
		if(First_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, first_Common_btn);
			if(isElementEnabled(driver, first_Common_btn)) {
				Extent_pass_New(driver, "Matched || Expected Result is : *Move to first button Should be Enable || Actual Result is :  *Move to first button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  *Move to first button Should be Enable || Actual Result is :*Move to first button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  *Move to first button Should not be Enable || Actual Result is : *Move to first button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  *Move to first button Should not be Enable || Actual Result is : *Move to first button IS NOT Enable", test, test1);
			}
		}
				
		
		if(Previous_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, prev_Common_btn);
			if(isElementEnabled(driver, prev_Common_btn)) {
				Extent_pass_New(driver, "Matched || Expected Result is : Move to previous button Should be Enable || Actual Result is :  Move to previous button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  Move to previous button Should be Enable || Actual Result is :Move to previous button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  Move to previous button Should not be Enable || Actual Result is : Move to previous button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  Move to previous button Should not be Enable || Actual Result is : Move to previous button IS NOT Enable", test, test1);
			}
		}
				
		
		
		if(Next_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, next_Common_btn);
			if(isElementEnabled(driver, next_Common_btn)) {
				Extent_pass_New(driver, "Matched || Expected Result is : Move to next button Should be Enable || Actual Result is :  Move to next button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  Move to next button Should be Enable || Actual Result is :Move to next button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  Move to next button Should not be Enable || Actual Result is : Move to next button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  Move to next button Should not be Enable || Actual Result is : Move to next button IS NOT Enable", test, test1);
			}
		}
			
		if(Last_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, last_Common_btn);
			if(isElementEnabled(driver, last_Common_btn)) {
				Extent_pass_New(driver, "Matched || Expected Result is : Move to last button Should be Enable || Actual Result is :  Move to last button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  Move to last button Should be Enable || Actual Result is :Move to last button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  Move to last button Should not be Enable || Actual Result is : Move to last button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  Move to last button Should not be Enable || Actual Result is : Move to last button IS NOT Enable", test, test1);
			}
		}
				
		if(Navigate_button_verify.equalsIgnoreCase("YES")) {
			waitForElement(driver, navigate_Common_btn);
			if(isElementEnabled(driver, navigate_Common_btn)) {
				Extent_pass_New(driver, "Matched || Expected Result is : Navigate button Should be Enable || Actual Result is :  Navigate button IS Enable", test, test1);
				System.out.println("Matched || Expected Result is :  Navigate button Should be Enable || Actual Result is :Navigate button IS Enable");
			}else {
				System.out.println("Not Matched || Expected Result is :  Navigate button Should not be Enable || Actual Result is : Navigate button IS NOT Enable");
				Extent_pass_New(driver,"Not Matched || Expected Result is :  Navigate button Should not be Enable || Actual Result is : Navigate button IS NOT Enable", test, test1);
			}
		}
				
		Step_End(4, " other all fields should disable " , test, test1);

Extent_completed(testcase_Name, test, test1);
}}
