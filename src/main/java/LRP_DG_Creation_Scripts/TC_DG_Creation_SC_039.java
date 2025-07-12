package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_039  extends Keywords {
	public void DG_Creation_SC_039(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_039";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String GlobalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String Column_condition = Excel_data.get("Column_condition");
		String Booking_No_Input = Excel_data.get("Booking_No_Input");
		String UN_Number_Column_Header = Excel_data.get("UN_Number_Column_Header");
		String UN_No = Excel_data.get("UN_No");
		String Exp_Unno_Popup = Excel_data.get("Exp_Unno_Popup");
		
		
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		SwitchProfile(driver, AgencyUser);
		
		moduleNavigate(driver, DG_Creation_Module);

		newButton(driver);

		Step_Start(1, "Retrieve the single container  Book number", test, test1);

		waitForElement(driver, Booking_No_Search_DG);
		click(driver, Booking_No_Search_DG);

		globalValueSearchWindow(driver, GlobalSearch_Condition, GlobalSearchFilterOption1, Booking_No_Input, "", "", "", "");

		Step_End(1, "Retrieve the single container  Book number", test, test1);

		Step_Start(2, "Select the unno system cross checked the DG house rules", test, test1);

		waitForElement(driver, UnNo_Search);
		safeclick(driver, UnNo_Search);
		
		twoColumnSearchWindow(driver, UN_Number_Column_Header, Column_condition, UN_No);
		
		waitForElement(driver, popup_Message);
		String actualUpdatedPopup=getText(driver, popup_Message);
		System.out.println("actualUpdatedPopup:"+actualUpdatedPopup);
		
		if(actualUpdatedPopup.contains(Exp_Unno_Popup)){
			System.out.println("Matched || Expected Popup : 'Selected UNNO status is prohibited. The system should not allow adding the UNNO details.' => " + Exp_Unno_Popup +" || Actual Popup: 'Selected UNNO status is prohibited. The system does not allow adding the UNNO details.' => " + actualUpdatedPopup);
			Extent_pass_New(driver,"Matched || Expected Popup : 'Selected UNNO status is prohibited. The system should not allow adding the UNNO details.' => " + Exp_Unno_Popup +" || Actual Popup: 'Selected UNNO status is prohibited. The system does not allow adding the UNNO details.' => " + actualUpdatedPopup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Popup : 'Selected UNNO status is prohibited. The system should not allow adding the UNNO details.' => " + Exp_Unno_Popup +" || Actual Popup: 'Selected UNNO status is prohibited. The system  allow adding the UNNO details.' => " + actualUpdatedPopup);
			Extent_fail(driver,"Not Matched || Expected Popup : 'Selected UNNO status is prohibited. The system should not allow adding the UNNO details.' => " + Exp_Unno_Popup +" || Actual Popup: 'Selected UNNO status is prohibited. The system  allow adding the UNNO details.' => " + actualUpdatedPopup, test,test1);
		}
		
		Step_End(2, "Select the unno system cross checked the DG house rules", test, test1);	
		
		
		Extent_completed(testCaseName, test, test1);
		

}
}