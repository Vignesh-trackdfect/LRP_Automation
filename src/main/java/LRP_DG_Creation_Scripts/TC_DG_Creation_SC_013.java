package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_013 extends Keywords {


	public void DG_Creation_SC_013(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_013";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");
		String Net_Weight_Popup = Excel_data.get("Net_Weight_Popup");
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, agencyUser);

		Step_Start(1, "", test, test1);

//		Module Search
		
		moduleNavigate(driver,DG_Creation_Module );
		
		newButton(driver);
		
		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		Step_Start(4, "Enter the net weight greater then gross weight  ", test, test1);

		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		Step_End(4, "Enter the net weight greater then gross weight  ", test, test1);
		Step_Start(5, "click apply to selected container button", test, test1);
		waitForPopup(driver, popup_Message,Net_Weight_Popup);
		String apply_selected_popup = getText(driver, popup_Message);
		System.out.println(apply_selected_popup);
		if(apply_selected_popup.equals(Net_Weight_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected popup is : " + Net_Weight_Popup + " || Actual popup is : " + apply_selected_popup);            
			Extent_pass_New(driver, "Matched || " + " Expected popup is: " + Net_Weight_Popup + " || Actual popup is : " + apply_selected_popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected popup is : " + Net_Weight_Popup + " || Actual popup is : " + apply_selected_popup);        
			Extent_fail(driver, "Not Matched || " + " Expected popup is : " + Net_Weight_Popup + " || Actual popup is : " + apply_selected_popup, test,test1); 
		} 
		Step_End(5, "click apply to selected container button", test, test1);
		Extent_completed(testCaseName, test, test1);

	}

}
