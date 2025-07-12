package LRP_Detention_Waiver_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Detention_Waiver_TS_027 extends Keywords {

	public void Detention_Waiver_TS_027(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Throwable {

		String testcase_Name = "TC_Detention_Waiver_TS_027";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String BL_Number = Excel_data.get("BL_Number");
		String Global_Configuration_Module = Excel_data.get("Global_Configuration_Module");
		String Global_Configuration_Attribute = Excel_data.get("Global_Configuration_Attribute");
		String Global_Configuration_Value = Excel_data.get("Global_Configuration_Value");
		String Global_Configuration_Reset_Value = Excel_data.get("Global_Configuration_Reset_Value");
		String Global_Configuration_Reset_Option = Excel_data.get("Global_Configuration_Reset_Option");
		String Radio_Button_Option = Excel_data.get("Radio_Button_Option");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Weiver_For = Excel_data.get("Weiver_For");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		setGlobalConfiguration(driver, Global_Configuration_Module, Global_Configuration_Attribute,
				Global_Configuration_Value);
		SwitchProfile(driver, AgencyName);
		Extent_cal(test, test1, "Open Detention Waiver");
		
		Step_Start(1, "Open Detention weiver Module", test, test1);
		
		moduleNavigate(driver, Detention_Module);
		Step_End(1, "Open Detention weiver Module", test, test1);


		newButton(driver);
		String Waiveroption = String.format(DW_WaiverOption, Weiver_For);

		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);
		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);
		Step_Start(2, "Click on BL No Search Field", test, test1);
		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		Step_End(2, "Click on BL No Search Field", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		globalValueSearchWindow(driver, BookingSearch_Condition, BookingSearch_Option, BL_Number, "", "", "", "");

		Step_End(3, "Input your Confirm BL No", test, test1);

		Step_Start(4, " Click on show Button", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
		
		waitForElement(driver, DW_Show);
		click(driver, DW_Show);
		
		Step_End(4, "Click on show Button", test, test1);
		Step_Start(5, "Verify that % Radio button and % Text Field not available", test, test1);
		scrollUsingElement(driver, DW_Total_records);
		waitForElement(driver, DW_Total_records);
		if (!formatLocatorIsDisplayed(driver, DW_Radio_Button, Radio_Button_Option)) {
			
			System.out.println(
					"Expected result : Expected Weiver % radio button should not displayed\"  || Actual result :  Weiver % radio button  not displayed\"");
			Extent_pass_New(driver,
					"Expected result : Expected Weiver % radio button should not displayed\" || Actual result :Weiver % radio button  not displayed\\\"",
					test, test1);
		} else {
			System.out.println(
					"Expected result : Expected Weiver % radio button should not displayed\"|| Actual result : Weiver % radio button   displayed\\\"\"");
			Extent_fail(driver,
					"Expected result :Expected Weiver % radio button should not displayed\"|| Actual result : Weiver % radio button   displayed\\\"",
					test, test1);
		}
			
		
		Step_End(5, "Verify that % Radio button and % Text Field not available", test, test1);

		reSetGlobalConfiguration(driver, Global_Configuration_Reset_Option, Global_Configuration_Module,
				Global_Configuration_Attribute, Global_Configuration_Reset_Value);

		Extent_completed(testcase_Name, test, test1);
	}
}
