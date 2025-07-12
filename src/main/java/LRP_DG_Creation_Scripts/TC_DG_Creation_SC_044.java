package LRP_DG_Creation_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_044 extends Keywords {


	public void DG_Creation_SC_044(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_044";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");
		String Popup_Saved_Detail = Excel_data.get("Popup_Saved_Detail");
		
		
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
		
		Step_Start(4, "click multi apply  button", test, test1);
		
		scrollElementToView(driver, Multi_Apply_Btn);
		waitForElement(driver, DG_Container_Select);
		String Before_Container = getText(driver, DG_Container_Select);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		waitForPopup(driver, popup_Message, Popup_Saved_Detail);
		String Saved_Popup = getText(driver, popup_Message);
		System.out.println(Saved_Popup);
		if(Saved_Popup.equals(Popup_Saved_Detail)) {                                                                                                                  
			System.out.println("Matched || " + " Expected PoPup is : " + Popup_Saved_Detail + " || Actual Report Activity is : " + Saved_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Popup_Saved_Detail + " || Actual Report Activity is : " + Saved_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Popup_Saved_Detail + " || Actual Report Activity is : " + Saved_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Popup_Saved_Detail + " || Actual Report Activity is : " + Saved_Popup, test,test1); 
		} 
		
		waitForElement(driver, DG_Container_Select);
		String After_Container = getText(driver, DG_Container_Select);	
		System.out.println(After_Container);
		if(!After_Container.equals(Before_Container)) {                                                                                                                  
			System.out.println("Matched || " + " Container Number Before : " + Before_Container + " || Container Number After : " + After_Container);            
			Extent_pass_New(driver, "Matched || " + " Container Number Before is: " + Before_Container + " || Container Number After : " + After_Container, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Container Number Before : " + Before_Container + " || Container Number After : " + After_Container);        
			Extent_fail(driver, "Not Matched || " + " Container Number Before : " + Before_Container + " || Container Number After : " + After_Container, test,test1); 
		} 
		
		
		Step_End(4, "click multi apply  button", test, test1);
		Extent_completed(testCaseName, test, test1);
	}

}
