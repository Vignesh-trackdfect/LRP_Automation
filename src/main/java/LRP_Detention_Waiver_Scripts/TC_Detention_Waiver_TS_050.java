package LRP_Detention_Waiver_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_050 extends Keywords {

	public void Detention_Waiver_TS_050(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_050";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BL_retreive_Type1 = Excel_data.get("BL_retreive_Type1");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number = Excel_data.get("BL_Number");
		String SearchStatus = Excel_data.get("SearchStatus");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

		Step_Start(1, "Open Detention waiver module", test, test1);

		moduleNavigate(driver, Detention_Module);

		Step_End(1, "Open Detention waiver module", test, test1);

		Step_Start(2, "Search and load the Waiver number", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow1(driver, BL_Condition, BL_retreive_Type1, BL_Number, "", "", "", "");

		waitForElement(driver, retrivedGlobalValue);

		Scroll_ElementVisible(driver, DW_Waiverstatus_SearchInput, DW_SearchScroll);

		click(driver, DW_Waiverstatus_SearchInput);
		sendKeys(driver, DW_Waiverstatus_SearchInput, SearchStatus);

		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);

		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
		elementnotvisible1(driver, SelectButton);

		Step_End(2, "Search and load the Waiver number", test, test1);

		Step_Start(3, "Scroll Down and Capture the added Free time", test, test1);

		scrollBottom(driver);

		String Waiverdays = getText(driver, DW_WaiverValue1).trim().replace(",", "");
		int days = (int) Double.parseDouble(Waiverdays);

		String convertedDays = String.valueOf(days);

		String BookNumber = getAttribute(driver, DW_BookingNo_Input, "value");

		String WaiverNumber = getAttribute(driver, DW_WaiverNo, "value");

		String BLNumber = getAttribute(driver, DW_BLNo_Input, "value");

		scrollTop(driver);

		Step_End(3, "Scroll Down and Capture the added Free time", test, test1);

		Step_Start(4, "Click on Print Window", test, test1);

		waitForElement(driver, Print_Button_toolBar);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, Print_Button_toolBar);

		Step_End(4, "Click on Print Window", test, test1);

		Step_Start(5, "System will Open the PDF", test, test1);

		waitForDisplay(driver, DW_PrintScreen);

		switchToFrame(driver, DW_PDF_Iframe);

		if (isdisplayed(driver, DW_PrintScreen)) {

			System.out.println(
					"Expected result : Document viewer page should be displayed || Actual result : Document viewer Page is displayed");
			Extent_pass_New(driver,
					"Expected result : Document viewer page should be displayed || Actual result : Document viewer Page is displayed",
					test, test1);
		} else {
			System.out.println(
					"Expected result : Document viewer page should be displayed || Actual result : Document viewer Page is not displayed");
			Extent_fail(driver,
					"Expected result : Document viewer page should be displayed || Actual result : Document viewer Page is not displayed",
					test, test1);
		}

		Step_End(5, "System will Open the PDF", test, test1);

		Step_Start(6, "Verify that system shows Same Free times and waiver no  in Waiver PDF Page", test, test1);

		String printdaysline = String.format(DW_PrintScreen_WaiverDays, WaiverNumber, convertedDays);

		if (isdisplayed(driver, printdaysline)) {

			System.out.println(
					"Expected result : The displayed grid waiver days should show in the pdf viewer|| Actual result : The displayed grid waiver days are showing in the pdf viewer");
			Extent_pass_New(driver,
					"Expected result : The displayed grid waiver days should show in the pdf viewer|| Actual result : The displayed grid waiver days are showing in the pdf viewer",
					test, test1);
		} else {
			System.out.println(
					"Expected result : The displayed grid waiver days should show in the pdf viewer|| Actual result : The displayed grid waiver days are not showing in the pdf viewer");
			Extent_fail(driver,
					"Expected result : The displayed grid waiver days should show in the pdf viewer|| Actual result : The displayed grid waiver days are not showing in the pdf viewer",
					test, test1);

		}

		String PDF_BookNo = String.format(DW_PrintScreen_Deatils, BookNumber);

		if (isdisplayed(driver, PDF_BookNo)) {

			System.out.println(
					"Expected result : The Book Number should show in the pdf viewer|| Actual result : The Book Number is Showing in the pdf viewer");
			Extent_pass_New(driver,
					"Expected result : The Book Number should show in the pdf viewer|| Actual result : The Book Number is Showing in the pdf viewer",
					test, test1);
		} else {
			System.out.println(
					"Expected result : The Book Number should show in the pdf viewer|| Actual result : The Book Number is not Showing in the pdf viewer");
			Extent_fail(driver,
					"Expected result : The Book Number should show in the pdf viewer|| Actual result : The Book Number is not Showing in the pdf viewer",
					test, test1);

		}

		String PDF_BLNo = String.format(DW_PrintScreen_Deatils, BLNumber);

		if (isdisplayed(driver, PDF_BLNo)) {

			System.out.println(
					"Expected result : The BL Number should show in the pdf viewer|| Actual result : The BL Number is Showing in the pdf viewer");
			Extent_pass_New(driver,
					"Expected result : The BL Number should show in the pdf viewer|| Actual result : The BL Number is Showing in the pdf viewer",
					test, test1);
		} else {
			System.out.println(
					"Expected result : The BL Number should show in the pdf viewer|| Actual result : The BL Number is not Showing in the pdf viewer");
			Extent_fail(driver,
					"Expected result : The BL Number should show in the pdf viewer|| Actual result : The BL Number is not Showing in the pdf viewer",
					test, test1);

		}

		String PDF_WaiverNo = String.format(DW_PrintScreen_Deatils, WaiverNumber);

		if (isdisplayed(driver, PDF_WaiverNo)) {

			System.out.println(
					"Expected result : The Waiver Number should show in the pdf viewer|| Actual result : The Waiver Number is Showing in the pdf viewer");
			Extent_pass_New(driver,
					"Expected result : The Waiver Number should show in the pdf viewer|| Actual result : The Waiver Number is Showing in the pdf viewer",
					test, test1);
		} else {
			System.out.println(
					"Expected result : The Waiver Number should show in the pdf viewer|| Actual result : The Waiver Number is not Showing in the pdf viewer");
			Extent_fail(driver,
					"Expected result : The Waiver Number should show in the pdf viewer|| Actual result : The Waiver Number is not Showing in the pdf viewer",
					test, test1);

		}

		Step_End(6, "Verify that system shows Same Free times and waiver no  in Waiver PDF Page", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
