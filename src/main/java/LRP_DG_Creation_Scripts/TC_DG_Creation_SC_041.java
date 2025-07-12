package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_041 extends Keywords {


	public void DG_Creation_SC_041(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_041";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");
		String Popup_Saved_Detail = Excel_data.get("Popup_Saved_Detail");
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		
		
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
		
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		waitForPopup(driver, popup_Message,Applied_Popup_Exp);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if(Applied_Popup.equals(Applied_Popup_Exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Popup is : " + Applied_Popup_Exp + " || Actual Popup is : " + Applied_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + Applied_Popup_Exp + " || Actual Popup is : " + Applied_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Popup is : " + Applied_Popup_Exp + " || Actual Popup is : " + Applied_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Applied_Popup_Exp + " || Actual Popup is : " + Applied_Popup, test,test1); 
		} 
		
		scrollElementToView(driver, DG_Container_Select);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);


		waitForElement(driver, DG_Save_Btn);
		safeclick(driver, DG_Save_Btn);
		waitForPopup(driver, popup_Message, Details_Saved_Popup);
		String Saved_Popup = getText(driver, popup_Message);
		System.out.println(Saved_Popup);
		if (Saved_Popup.equals(Details_Saved_Popup)) {
			System.out.println("Matched || " + " Expected Popup is : " + Details_Saved_Popup + " || Actual Popup is : " + Saved_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + Details_Saved_Popup + " || Actual Popup is : " + Saved_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : " + Details_Saved_Popup + " || Actual Popup is : " + Saved_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Details_Saved_Popup + " || Actual Popup is : " + Saved_Popup, test, test1);
		}


		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		waitForPopup(driver, popup_Message,Applied_Popup_Exp);
		String Popup_Applied = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if(Popup_Applied.equals(Applied_Popup_Exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Popup is : " + Applied_Popup_Exp + " || Actual Popup is : " + Popup_Applied);            
			Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + Applied_Popup_Exp + " || Actual Popup is : " + Popup_Applied, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Popup is : " + Applied_Popup_Exp + " || Actual Popup is : " + Popup_Applied);        
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Applied_Popup_Exp + " || Actual Popup is : " + Popup_Applied, test,test1); 
		}
		
		waitForElement(driver, DG_Save_Btn);
		safeclick(driver, DG_Save_Btn);
		waitForPopup(driver, popup_Message, Popup_Saved_Detail);
		String Popup_Saved = getText(driver, popup_Message);
		if (Popup_Saved.equals(Popup_Saved_Detail)) {
			System.out.println("Matched || " + " Expected Popup is : " + Popup_Saved_Detail + " || Actual Popup is : " + Popup_Saved);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + Popup_Saved_Detail + " || Actual Popup is : " + Popup_Saved, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : " + Popup_Saved_Detail + " || Actual Popup is : " + Popup_Saved);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Popup_Saved_Detail + " || Actual Popup is : " + Popup_Saved, test, test1);
		}

		Step_End(2, "Select the unno(1500) system cross checked the DG house rules", test, test1);
		Extent_completed(testCaseName, test, test1);
	}

}
