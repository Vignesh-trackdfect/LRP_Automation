package LRP_Detention_Waiver_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_004A extends Keywords {

	public void Detention_Waiver_TS_004A(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Detention_Waiver_TS_004A";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String dropdownCondition = Excel_data.get("dropdownCondition");
		String BL_Number_Search_Type_DET = Excel_data.get("BL_Number_Search_Type");
		String B_Number_DET = Excel_data.get("BL_Number");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String WaiverOption = Excel_data.get("Weiver_For");
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);
		Step_Start(1, "Open Detention weiver Module", test, test1);
	
		moduleNavigate(driver, Detention_Module);
		Step_End(1, "Open Detention weiver Module", test, test1);
		newButton(driver);
		String Waiveroption = String.format(DW_WaiverOption, WaiverOption);

		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);

		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);


		

		Step_Start(2, ". Click on BL No Search Field ", test, test1);

		waitForDisplay(driver, DW_BookingNo_Search);
		if (isElementEnabled(driver, DW_BookingNo_Search)) {
			System.out.println(
					"Pass || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is enabled",
					test, test1);
			click(driver, DW_BookingNo_Search);
		} else {
			System.out.println(
					"Fail || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is not enabled",
					test, test1);
		}

		Step_End(2, ". Click on BL No Search Field ", test, test1);
		Step_Start(3, "Input your Confirm BL No", test, test1);
		Step_Start(4, "Click on show Button", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, BL_Number_Search_Type_DET, B_Number_DET, "", "", "", "");

		Step_End(3, "Input your Confirm BL No", test, test1);
		Step_End(4, "Click on show Button", test, test1);
		Step_Start(5, "Verify that customer detail tab shows customer information match with bl/mcn module", test,
				test1);
		Step_Start(6, "Verify that Container List filed system shows Container list match with bl/mcn module", test,
				test1);
		
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
waitForElement(driver, DW_Show);
		click(driver, DW_Show);

		waitForDisplay(driver, Customer_Details_Gird);
		if (isdisplayed(driver, Customer_Details_Gird)) {
			System.out.println(
					"Pass || Expected result is :Customer details should  be shown in the gird|| Actual result is : Customer details   was shown in the gird");
			Extent_pass_New(driver,
					"Pass || Expected result is : Customer details should  be shown in the gird|| Actual result is : Customer details   was shown in the gird",
					test, test1);

		} else {
			System.out.println(
					"Fail || Expected result is : Customer details should  be shown in the gird || Actual result is : Customer details  was  not shown in the gird");
			Extent_fail(driver,
					"Fail || Expected result is :Customer details should  be shown in the gird|| Actual result is : Customer details   was not shown in the gird",
					test, test1);
		}
		scrollBottom(driver);
		waitForDisplay(driver, Container_Details_Gird);
		if (isdisplayed(driver, Container_Details_Gird)) {
			System.out.println(
					"Pass || Expected result is :Container details should  be shown in the gird|| Actual result is : Container details   was shown in the gird");
			Extent_pass_New(driver,
					"Pass || Expected result is : Container details should  be shown in the gird|| Actual result is : Container details   was shown in the gird",
					test, test1);

		} else {
			System.out.println(
					"Fail || Expected result is : Container details should  be shown in the gird || Actual result is : Container details  was  not shown in the gird");
			Extent_fail(driver,
					"Fail || Expected result is :Container details should  be shown in the gird|| Actual result is : Container details   was not shown in the gird",
					test, test1);
		}

		Extent_completed(testcase_Name, test, test1);

	}
}
