package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_035 extends Keywords {


	public void DG_Creation_SC_035(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_035";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");

		String Contact_Name_Popup = Excel_data.get("Contact_Name_Popup");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, agencyUser);

//		Module Search
		
		moduleNavigate(driver, DG_Creation_Module);
		
		
		newButton(driver);
		
		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_Start(4, "click multi apply  button.", test, test1);

		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		waitForPopup(driver, popup_Message,Contact_Name_Popup);
		String contactName_Popup = getText(driver, popup_Message);
		System.out.println("contactName_Popup"+contactName_Popup);
		if(contactName_Popup.equals(Contact_Name_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Contact_Name_Popup + " || Actual Report Activity is : " + contactName_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Contact_Name_Popup + " || Actual Report Activity is : " + contactName_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Contact_Name_Popup + " || Actual Report Activity is : " + contactName_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Contact_Name_Popup + " || Actual Report Activity is : " + contactName_Popup, test,test1); 
		} 
		Step_End(4, "click multi apply  button.", test, test1);
		
		Extent_completed(testCaseName, test, test1);
	}

}
