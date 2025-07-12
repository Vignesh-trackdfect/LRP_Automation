package LRP_EMS_Individual_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;




public class TC_EMS_Contract_Registration_TS003 extends Keywords {
	
public void Emscontractregistration03(WebDriver driver,ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception 
{
	
	String tc_Name="TC_EMS_Contract_Registration_TS003";

		
	String Username =Excel_data.get("Username");
	String Password =Excel_data.get("Password");	
	String Search_input =Excel_data.get("Search_input");	
	String contract_no3 =Excel_data.get("contract_no3");	
	String delete_confirm =Excel_data.get("delete_confirm");	
	String Deleted_Message =Excel_data.get("Deleted_Message");	
	String Search_type =Excel_data.get("Search_type");	
	String search_by_con_num = Excel_data.get("search_by_con_num");	
	String Search_Type2 = Excel_data.get("Search_Type2");	
	String Search_Input2 = Excel_data.get("Search_Input2");	
	String Search_Type3 = Excel_data.get("Search_Type3");	
	String Search_Input3 = Excel_data.get("Search_Input3");	
	
	
	
	Extent_Start(tc_Name, test, test1);

	Step_Start(1, "open chrome browser ", test, test1);
	Step_Start(2, "Enter the url", test, test1);

	navigateUrl(driver, url); 
	
	Step_End(2, "Enter the url", test, test1);
	Step_End(1, "open chrome browser ", test, test1);
	
	LRP_Login(driver, Username, Password);
	
	Step_Start(6, "click on search field", test, test1);
	Step_Start(7, "Enter the EMS Contract Registration field in search box", test, test1);
	moduleNavigate(driver, Search_input);

    Step_End(7, "Enter the EMS Contract Registration field in search box", test, test1);
	Step_End(6, "click on search field", test, test1);
	
	Step_Start(8, "Click on Global Search from toolbar", test, test1);
	waitForElement(driver, SearchButton_Toolbar);
	click(driver, SearchButton_Toolbar);
	Step_End(8, "Click on Global Search from toolbar", test, test1);

	Step_Start(9, "Enter Contract no & click on search button", test, test1);
	Step_Start(10, "Click on retrieved data for required contract no", test, test1);

	globalValueSearchWindow(driver, Search_type, search_by_con_num, contract_no3, Search_Type2, Search_Input2, Search_Type3, Search_Input3);
	
	Step_End(9, "Enter Contract no & click on search button", test, test1);
	Step_End(10, "Click on retrieved data for required contract no", test, test1);
	
	Step_Start(11, "Click on Delete icon from toolbar", test, test1);
	    waitForElement(driver, Delete_button_toolBar);
	    click(driver,Delete_button_toolBar);
		Step_End(11, "Click on Delete icon from toolbar", test, test1);

		waitForPopup(driver, popup_Message, delete_confirm);
	    String confirm_delete= getText(driver, popup_Message);
	    
	    if(confirm_delete.equals(delete_confirm)) {
	    	System.out.println("Matched || Expected popup was : "+ delete_confirm +" || Actual popup was : "+ confirm_delete);
	    	Extent_pass_New(driver, "Matched || Expected popup was : "+ delete_confirm +" || Actual popup was : "+ confirm_delete, test, test1);
	    }else {
	    	System.out.println("Not Matched || Expected popup was : "+ delete_confirm +" || Actual popup was : "+ confirm_delete);
	    	Extent_fail(driver,  "Not Matched || Expected popup was : "+ delete_confirm +" || Actual popup was : "+ confirm_delete, test, test1);
	    }
	    
		Step_Start(12, "Click on 'Yes' when pop-up message occurs for confirmation message", test, test1);
	    waitForElement(driver, popup_Message_Yes_Button);
	    click(driver,popup_Message_Yes_Button);
		Step_End(12, "Click on 'Yes' when pop-up message occurs for confirmation message", test, test1);

		Step_Start(13, "verify pop-up message occurs for confirmation message", test, test1);
	    waitForPopup(driver, Popup_Message, Deleted_Message);
		String delete_msg= getText(driver, Popup_Message);

	    if(delete_msg.equals(Deleted_Message)) {
	    	System.out.println("Matched || Expected popup was : "+ Deleted_Message +" || Actual popup was : "+ delete_msg);
	    	Extent_pass_New(driver, "Matched || Expected popup was : "+ Deleted_Message +" || Actual popup was : "+ delete_msg, test, test1);
	    }else {
	    	System.out.println("Not Matched || Expected popup was : "+ Deleted_Message +" || Actual popup was : "+ delete_msg);
	    	Extent_fail(driver,  "Not Matched || Expected popup was : "+ Deleted_Message +" || Actual popup was : "+ delete_msg, test, test1);
	    	}
		Step_End(13, "verify pop-up message occurs for confirmation mess2age", test, test1);
		
		Extent_completed(tc_Name, test, test1);

	    
}

}
