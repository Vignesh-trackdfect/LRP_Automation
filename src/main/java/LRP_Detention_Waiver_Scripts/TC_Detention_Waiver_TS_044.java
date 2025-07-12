package LRP_Detention_Waiver_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_044 extends Keywords {

	public void Detention_Waiver_TS_044(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_044";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BL_retreive_Type1 = Excel_data.get("BL_retreive_Type1");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number = Excel_data.get("BL_Number");
		String SearchStatus = Excel_data.get("SearchStatus");
		String Expected_popup = Excel_data.get("Expected_popup");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

		Step_Start(1, "Open Detention Waiver", test, test1);

		moduleNavigate(driver, Detention_Module);

		Step_End(1, "Open Detention Waiver", test, test1);

		Step_Start(1, "a) Click on Search Button", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(1, "a) Click on Search Button", test, test1);

		Step_Start(2, "Enter Waiver No/ BL NO for Cancelled Ref details", test, test1);

		globalValueSearchWindow1(driver, BL_Condition, BL_retreive_Type1, BL_Number, "", "", "", "");

		Step_End(2, "Enter Waiver No/ BL NO for Cancelled Ref details", test, test1);

		Step_Start(3, "load  the data", test, test1);

		waitForElement(driver, retrivedGlobalValue);

		Scroll_ElementVisible(driver, DW_Waiverstatus_SearchInput, DW_SearchScroll);

		click(driver, DW_Waiverstatus_SearchInput);
		sendKeys(driver, DW_Waiverstatus_SearchInput, SearchStatus);

		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);

		waitForElement(driver, SelectButton);
		click(driver, SelectButton);

		Step_End(3, "load  the data", test, test1);

		Step_Start(4, "Click on Edit Button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(4, "Click on Edit Button", test, test1);

		Step_Start(5, "Verify the Msg Cancelled Waiver cannot be Edited", test, test1);

		waitForPopup(driver, popup_Message, Expected_popup);
		String Cancelled_popup_Message = getText(driver, popup_Message);

		if (Cancelled_popup_Message.equals(Expected_popup)) {

			System.out.println("Expected popup : " + Expected_popup + " || Actual popup : " + Cancelled_popup_Message);
			Extent_pass_New(driver,
					"Expected popup : " + Expected_popup + " || Actual popup : " + Cancelled_popup_Message, test,
					test1);

		} else {
			System.out.println("Expected popup : " + Expected_popup + " || Actual popup : " + Cancelled_popup_Message);
			Extent_fail(driver, "Expected popup : " + Expected_popup + " || Actual popup : " + Cancelled_popup_Message,
					test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(5, "Verify the Msg Cancelled Waiver cannot be Edited", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
