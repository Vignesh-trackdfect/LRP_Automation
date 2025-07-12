package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_033 extends Keywords {

	public void DG_Creation_SC_033(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_033";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");

		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		SwitchProfile(driver, AgencyUser);

		moduleNavigate(driver, DG_Creation_Module);

		newButton(driver);

		Step_Start(1, "Retrieve the Book number with non operator refer N ", test, test1);

		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_End(1, "Retrieve the Book number with non operator refer N ", test, test1);

	    Step_Start(4, "click multi apply  button", test, test1);
		
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);

		waitForPopup(driver, popup_Message, Applied_Popup_Exp);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(Applied_Popup_Exp)) {
			System.out.println("Matched || Expected Popup :" + Applied_Popup_Exp+" ||  'SADT' ,'Control temperature',' Emergency Temperature' should not display  || Actual Popup : " + Applied_Popup_Exp+ " ||  'SADT' ,'Control temperature',' Emergency Temperature' should not display" );
			Extent_pass_New(driver, "Matched || Expected Popup :" + Applied_Popup_Exp+" ||  'SADT' ,'Control temperature',' Emergency Temperature' should not display  || Actual Popup : " + Applied_Popup_Exp+ " ||  'SADT' ,'Control temperature',' Emergency Temperature' should not display" , test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Popup :" + Applied_Popup_Exp+" ||  'SADT' ,'Control temperature',' Emergency Temperature' should not display  || Actual Popup : " + Applied_Popup_Exp+ " ||  'SADT' ,'Control temperature',' Emergency Temperature' should not display" );
			Extent_fail(driver, "Not Matched || Expected Popup :" + Applied_Popup_Exp+" ||  'SADT' ,'Control temperature',' Emergency Temperature' should not display  || Actual Popup : " + Applied_Popup_Exp+ " ||  'SADT' ,'Control temperature',' Emergency Temperature' should not display" , test, test1);
		}
		
	
		Step_End(4, "click multi apply  button", test, test1);	
		
		Extent_completed(testCaseName, test, test1);
	}

}
