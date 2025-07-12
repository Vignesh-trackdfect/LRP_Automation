package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_015 extends Keywords {


	public void DG_Creation_SC_015(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_015";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");
		String booking_number = Excel_data.get("Booking_No_Input");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, agencyUser);

//		Module Search
		
		moduleNavigate(driver, DG_Creation_Module);
		
		newButton(driver);
		
		Step_Start(1, "Retrieve the Book number", test, test1);

		waitForElement(driver, Booking_No_Search_DG);
		click(driver, Booking_No_Search_DG);
		globalValueSearchWindow(driver, GlobalSearch_Condition, globalSearchFilterOption1, booking_number, "", "", "", "");
		
		Step_End(1, "Retrieve the Book number", test, test1);
		Step_Start(2, "Select the unno", test, test1);

		waitForElement(driver, UN_NO_Search_DG);
		click(driver, UN_NO_Search_DG);
	

		waitForDisplay(driver, two_Column_Search_Row);
		if(isdisplayed(driver, two_Column_Search_Row)) {
			System.out.println("Matched || Expected : UNNO details should be displayed || Actual : UNNO details are displayed");
			Extent_pass_New(driver, "Matched || Expected : UNNO details should be displayed || Actual : UNNO details are displayed", test, test1);
		}else {
			System.out.println("Not Matched || Expected : UNNO details should be displayed || Actual : UNNO details are not displayed");
			Extent_fail(driver, "Not Matched || Expected : UNNO details should be displayed || Actual : UNNO details are not displayed", test, test1);
		}
		Step_End(2, "Select the unno", test, test1);
		
		Extent_completed(testCaseName, test, test1);
	}

}
