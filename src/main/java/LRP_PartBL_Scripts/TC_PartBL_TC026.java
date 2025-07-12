package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_PartBL_TC026 extends Keywords {

	public void PartBL_TC026(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC026";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String PartBL_SearchOption = Excel_data.get("PartBL_SearchOption");
		String BLNumber = Excel_data.get("BLNumber");
		String Expected_Popup = Excel_data.get("Expected_Popup");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);

		Step_Start(1, "Open the Part BL module", test, test1);

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(1, "Open the Part BL module", test, test1);

		Step_Start(2, "Click the \"New\" button", test, test1);

		newButton(driver);

		Step_End(2, "Click the \"New\" button", test, test1);

		Step_Start(3, "Use the BL number search to retrieve the data", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, PartBL_SearchOption, BLNumber, "", "", "", "");

		Step_End(3, "Use the BL number search to retrieve the data", test, test1);

		Step_Start(4,
				"\"For this BL, Invoice has been Issued, Further If You Want to Part BL. You can put all the charges in Master BL only\" popup message shown.",
				test, test1);

		waitForPopup(driver, popup_Message, Expected_Popup);

		String Actual_Savedpopup = getText(driver, popup_Message);

		if (Actual_Savedpopup.equals(Expected_Popup)) {

			System.out.println("Expected popup message was : " + Expected_Popup + " Actual popup message was : "
					+ Actual_Savedpopup);
			Extent_pass_New(driver, "Expected popup message was : " + Expected_Popup + " Actual popup message was : "
					+ Actual_Savedpopup, test, test1);

		} else {

			System.out.println("Expected popup message was : " + Expected_Popup + " Actual popup message was : "
					+ Actual_Savedpopup);
			Extent_fail(driver, "Expected popup message was : " + Expected_Popup + " Actual popup message was : "
					+ Actual_Savedpopup, test, test1);

		}

		Step_End(4,
				"\"For this BL, Invoice has been Issued, Further If You Want to Part BL. You can put all the charges in Master BL only\" popup message shown.",
				test, test1);

		Step_Start(5, "Click no button", test, test1);

		waitForElement(driver, popup_Message_No_Button);
		click(driver, popup_Message_No_Button);

		Step_End(5, "Click no button", test, test1);

		Step_Start(6, "System remove the all details", test, test1);

		waitForElement(driver, PBL_BLInput);

		String BLNum = getAttribute(driver, PBL_BLInput, "value");

		if (BLNum.isEmpty() || BLNum.equals("")) {

			System.out.println(
					"Expected result : After click on No button, system should remove all the details || Actual result : After click on No button, system removed all the details");
			Extent_pass_New(driver,
					"Expected result : After click on No button, system should remove all the details || Actual result : After click on No button, system removed all the details",
					test, test1);

		} else {

			System.out.println(
					"Expected result : After click on No button, system should remove all the details || Actual result : After click on No button, system not removed the details");
			Extent_fail(driver,
					"Expected result : After click on No button, system should remove all the details || Actual result : After click on No button, system not removed the details",
					test, test1);

		}

		Step_End(6, "System remove the all details", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
