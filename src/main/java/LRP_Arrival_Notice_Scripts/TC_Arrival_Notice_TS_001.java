package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_001 extends Keywords {

	public void Arrival_Notice_TS_001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Arrival_Notice_TS_001";
		
		
		




		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String ArrivalNotice_Module = Excel_data.get("ArrivalNotice_Module");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Search_Number = Excel_data.get("Search_Number");
		String BL_Num = Excel_data.get("BL_Num");
		String Without_agency_Popup = Excel_data.get("Without_agency_Popup");
		


		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);


		Step_Start(1, "Open Arrival Notice / Freight Memo Module", test, test1);

		moduleNavigate(driver, ArrivalNotice_Module);

		Step_End(1, "Open Arrival Notice / Freight Memo Module", test, test1);

		Step_Start(2, "Click on New Button", test, test1);
		newButton(driver);

		Step_End(2, "Click on New Button", test, test1);
		Step_Start(3, "Click BL number option", test, test1);

		waitForElement(driver, BL_Search_button_AN);
		click(driver, BL_Search_button_AN);
		Step_End(3, "Click BL number option", test, test1);

		Step_Start(4, "paste the Bl", test, test1);


		globalValueSearchWindow1(driver, BL_Condition, Search_Number, BL_Num, "", "", "", "");


		Step_End(4, "paste the Bl", test, test1);
		Step_Start(5, "Click search button ", test, test1);

		Step_End(5, "Click search button ", test, test1);

		waitForPopup(driver, Popup_Message, Without_agency_Popup);
		String Popup=getText(driver, Popup_Message);
		if(Without_agency_Popup.equals(Popup)) {
			System.out.println("Matched || Without switching agency BL Retrived Expected Popup : " + Without_agency_Popup + " || Without switching agency BL Retrived Actual Popup : " + Popup);
			Extent_pass(driver, "Matched || Without switching agency BL Retrived Expected Popup : " + Without_agency_Popup + " || Without switching agency BL Retrived Actual Popup : " + Popup, test,
					test1);
		} else {
			System.out.println("NotMatched || Without switching agency BL Retrived Expected Popup : " + Without_agency_Popup + " || Without switching agency BL Retrived Actual Popup : " + Popup);
			Extent_fail(driver, "NotMatched ||Without switching agency BL Retrived Expected Popup : " + Without_agency_Popup + " || Without switching agency BL Retrived Actual Popup : " + Popup,
					test, test1);
		}
		Extent_completed(testcase_Name, test, test1);

	}
}
