package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_055 extends Keywords{
	public void DG_Creation_SC_055(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_055";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String UN_Number_Column_Header = Excel_data.get("UN_Number_Column_Header");
		String Column_condition = Excel_data.get("Column_condition");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String UN_No_values = Excel_data.get("UN_No_values");
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		SwitchProfile(driver, AgencyUser);

		moduleNavigate(driver, DG_Creation_Module);

		newButton(driver);

		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_Start(4, "click multi apply  button", test, test1);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		waitForPopup(driver, popup_Message, Applied_Popup_Exp);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(Applied_Popup_Exp)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup, test, test1);
		}

		Step_End(4, "click multi apply  button", test, test1);
		
		Step_Start(5, "select unno  and weight details cleared", test, test1);	
		
		waitForElement(driver, Gross_Wt_Field);
		String Exp_Gross_Weight = getAttribute(driver, Gross_Wt_Field, "value");
		System.out.println(Exp_Gross_Weight);
		
		waitForElement(driver, Net_Wt_Field);
		String Exp_Weight = getAttribute(driver, Net_Wt_Field, "value");
		System.out.println(Exp_Weight);
		
		scrollTop(driver);
		
		waitForElement(driver, UnNo_Search);
		safeclick(driver, UnNo_Search);
		twoColumnSearchWindow(driver, UN_Number_Column_Header, Column_condition, UN_No_values);
		
		waitForElement(driver, Gross_Wt_Field);
		String Act_Gross_Weight = getAttribute(driver, Gross_Wt_Field, "value");
		
		
		waitForElement(driver, Net_Wt_Field);
		String Act_Weight = getAttribute(driver, Net_Wt_Field, "value");
		
		
		
		if(!Act_Gross_Weight.equals(Exp_Gross_Weight)) {
		
			System.out.println("Matched || Expected: New UNNO system should clear the gross details before providing old data: " + Exp_Gross_Weight +  " || Actual: New UNNO system clears the gross details before providing new data: " + Act_Gross_Weight);		
			Extent_pass_New(driver," Matched || Expected: New UNNO system should clear the gross details before providing old data: " + Exp_Gross_Weight +  " || Actual: New UNNO system clears the gross details before providing new data: " + Act_Gross_Weight, test, test1);
		}else {
			System.out.println("Not Matched || Expected: New UNNO system should clear the gross details before providing old data: " + Exp_Gross_Weight +  " || Actual: New UNNO system Not clears the gross details before providing new data : " + Act_Gross_Weight);		
		    Extent_fail(driver,"Not Matched || Expected: New UNNO system should clear the gross details before providing old data: " + Exp_Gross_Weight +  " || Actual: New UNNO system Not clears the gross details before providing new data: " + Act_Gross_Weight, test, test1);
		}
		
		
		if(!Act_Weight.equals(Exp_Weight)) {
			
			System.out.println("Matched || Expected: New UNNO system should clear the net weight details before providing old data: " + Exp_Weight +  " || Actual: New UNNO system clears the net weight details before providing new data: " + Act_Weight);		
			Extent_pass_New(driver," Matched || Expected: New UNNO system should clear the net weight details before providing old data: " + Exp_Weight +  " || Actual: New UNNO system clears the net weight details before providing new data: " + Act_Weight, test, test1);
		}else {
			System.out.println("Not Matched || Expected: New UNNO system should clear the net weight details before providing old data: " + Exp_Weight +  " || Actual: New UNNO system Not clears the net weight details before providing new data : " + Act_Weight);		
		    Extent_fail(driver,"Not Matched || Expected: New UNNO system should clear the net weight details before providing old data: " + Exp_Weight +  " || Actual: New UNNO system Not clears the net weight details before providing new data: " + Act_Weight, test, test1);
		}
		
		Step_End(5, "select unno  and weight details cleared", test, test1);	
		
		Extent_completed(testCaseName, test, test1);	
		
		

}
}