package LRP_Detention_Waiver_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_024 extends Keywords {

	public void Detention_Waiver_TS_024(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_024";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String Value = Excel_data.get("Value");
		String Global_Attribute = Excel_data.get("Global_Attribute");
		String BL_Number = Excel_data.get("BL_Number");
		String Global_Configration = Excel_data.get("Global_Configration");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String Value_Reset = Excel_data.get("Value_Reset");
		String Value_Reset_Perform = Excel_data.get("Value_Reset_Perform");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Weiver_For = Excel_data.get("Weiver_For");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

		setGlobalConfiguration(driver, Global_Configration, Global_Attribute, Value);

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

		Step_Start(4, " Click on show Button select the Row in Container Section", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);

		waitForElement(driver, DW_Show);
		click(driver, DW_Show);
		Step_End(4, " Click on show Button select the Row in Container Section", test, test1);

		scrollBottom(driver);

		Step_Start(5, "Verify that Only Exclusive options are listed under DropDown.", test, test1);

		waitForElement(driver, EX_IN_Field);
		click(driver, EX_IN_Field);

		waitForDisplay(driver, exclusive_Field);
		if (!isdisplayed(driver, inclusive_Field) && isdisplayed(driver, exclusive_Field)) {
			System.out.println(
					"Expected result : Exclusive option only should be Displayed in Drop down|| Actual result : Exclusive option only Displayed in Drop down");
			Extent_pass_New(driver,
					"Expected result : Exclusive option only should be Displayed in Drop down|| Actual result : Exclusive option only Displayed in Drop down",
					test, test1);
		} else {
			System.out.println(
					"Expected result : Exclusive option only should be Displayed in Drop down|| Actual result : Exclusive option only not Displayed in Drop down");
			Extent_fail(driver,
					"Expected result : Exclusive option only should be Displayed in Drop down|| Actual result : Exclusive option only not Displayed in Drop down",
					test, test1);
		}

		Step_End(5, "Verify that Only Exclusive options are listed under DropDown.", test, test1);

		scrollTop(driver);

		reSetGlobalConfiguration(driver, Value_Reset_Perform, Global_Configration, Global_Attribute, Value_Reset);

		Extent_completed(testcase_Name, test, test1);

	}
}