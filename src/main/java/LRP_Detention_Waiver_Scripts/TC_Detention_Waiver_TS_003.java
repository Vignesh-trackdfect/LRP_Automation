package LRP_Detention_Waiver_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_003 extends Keywords {

	public void Detention_Waiver_TS_003(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {
		String testcase_Name = "TC_Detention_Waiver_TS_003";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String dropdownCondition = Excel_data.get("dropdownCondition");
		String BL_Number_Search_Type_DET = Excel_data.get("BL_Number_Search_Type");
		String B_Number_DET = Excel_data.get("BL_Number");
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

		Step_Start(2, "Click on Search", test, test1);

		waitForDisplay(driver, DW_BookingNo_Search);
		if (isElementEnabled(driver, DW_BookingNo_Search)) {

			System.out.println(
					"Pass || Expected result is : Booking Number search button should be enabled || Actual result is : Booking Number search button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : Booking Number search button should be enabled || Actual result is : Booking Number search button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : Booking Number search button should be enabled || Actual result is : Booking Number search button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : Booking Number search button should be enabled || Actual result is : Booking Number search button is not enabled",
					test, test1);
		}
		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		globalValueSearchWindow(driver, dropdownCondition, BL_Number_Search_Type_DET, B_Number_DET, "", "", "", "");

		Step_End(2, "Click on Search", test, test1);
		Step_Start(3, "Click on Storage option", test, test1);
		waitForDisplay(driver, DW_Storage_Option);

		click(driver, DW_Storage_Option);

		waitForDisplay(driver, DW_BookingNo_Input);

		String varName = getAttribute(driver, DW_BookingNo_Input, "value");
		System.out.println(varName);

		if (B_Number_DET.equals(varName)) {
			System.out.println(
					"Matched || Expected BL Number is : " + varName + " || Actual BL Number is : " + B_Number_DET);
			Extent_pass_New(driver,
					"Matched || Expected BL Number is : " + varName + " || Actual BL Number is : " + B_Number_DET, test,
					test1);

		} else {
			System.out.println(
					"Not Matched || Expected BL Number is : " + varName + " || Actual BL Number is : " + B_Number_DET);
			Extent_fail(driver,
					"Not Matched || Expected BL Number is : " + varName + " || Actual BL Number is : " + B_Number_DET,
					test, test1);
		}

		waitForDisplay(driver, DW_BookingNo_Input1);

		String varName1 = getAttribute(driver, DW_BookingNo_Input1, "value");
		System.out.println(varName1);
		if (B_Number_DET.equals(varName1)) {
			System.out.println("Matched || Expected Booking number is : " + varName1 + " || Actual Booking number is : "
					+ B_Number_DET);
			Extent_pass_New(driver, "Matched || Expected Booking number is : " + varName1
					+ " || Actual Booking number is : " + B_Number_DET, test, test1);

		} else {
			System.out.println("Not Matched || Expected Booking number is : " + varName1
					+ " || Actual Booking number is : " + B_Number_DET);
			Extent_fail(driver, "Not Matched || Expected Booking number is : " + varName1
					+ " || Actual Booking number is : " + B_Number_DET, test, test1);
		}

		Step_End(3, "Click on Storage option", test, test1);

		Step_Start(4, "Click on Detention option", test, test1);

		waitForDisplay(driver, DW_Detention_Option);

		click(driver, DW_Detention_Option);

		String varName2 = getAttribute(driver, DW_BookingNo_Input, "value");
		System.out.println(varName2);

		if (B_Number_DET.equals(varName2)) {
			System.out.println("Matched || Expected : BL NUMBER SHOULD NOT BE Cleared AFTER CLICK ON DETENTION BUTTON: " + varName2
					+ " || Actual :BL NUMBER Not Cleared AFTER CLICK ON DETENTION BUTTON : " + B_Number_DET);
			Extent_pass_New(driver, "Matched || Expected : BL NUMBER  SHOULD NOT BE  Cleared AFTER CLICK ON DETENTION BUTTON: " + varName2
					+ " || Actual :BL NUMBER Not Cleared AFTER CLICK ON DETENTION BUTTON : " + B_Number_DET, test, test1);

		} else {
			System.out.println("Not Matched || Expected : BL NUMBER  SHOULD NOT BE  Cleared AFTER CLICK ON DETENTION BUTTON: " + varName2
					+ " || Actual :BL NUMBER Not Cleared AFTER CLICK ON DETENTION BUTTON : " + B_Number_DET);
			Extent_fail(driver, "Not Matched || Expected : BL NUMBER SHOULD NOT BE Cleared AFTER CLICK ON DETENTION BUTTON: " + varName2
					+ " || Actual :BL NUMBER Not Cleared AFTER CLICK ON DETENTION BUTTON : " + B_Number_DET, test, test1);
		}
		Step_End(4, "Click on Detention option", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
