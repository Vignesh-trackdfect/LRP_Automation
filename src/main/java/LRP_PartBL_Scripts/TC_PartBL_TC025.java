package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_PartBL_TC025 extends Keywords {
	public void PartBL_TC025(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC025";
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

		if (Expected_Popup.equals(Actual_Savedpopup)) {

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

		Step_Start(5, "Click yes button", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(5, "Click yes button", test, test1);

		Step_Start(6, "System automatically selected the \"\"Move All charges to Master\"\" option.\"", test, test1);

		waitForElement(driver, PBL_Move_All_charges_to_Master_Icon);
		String Class_Value = getAttribute(driver, PBL_Move_All_charges_to_Master_Icon, "class");

		if (Class_Value.contains("bullet")) {
			System.out.println(
					" MATCHED|| The Excepted is : The System Should Automatically Selected the Move All charges to Master option || The Actual is  The System is  Automatically Selected the Move All charges to Master option  ");
			Extent_pass_New(driver,
					" MATCHED|| The Excepted is : The System Should Automatically Selected the Move All charges to Master option || The Actual is  The System is  Automatically Selected the Move All charges to Master option  ",
					test, test1);
		} else {
			System.out.println(
					" NOT MATCHED|| The Excepted is : The System Should Automatically Selected the Move All charges to Master option || The Actual is  The System is Not  Automatically Selected the Move All charges to Master option  ");
			Extent_fail(driver,
					"NOT MATCHED|| The Excepted is : The System Should Automatically Selected the Move All charges to Master option || The Actual is  The System is Not Automatically Selected the Move All charges to Master option  ",
					test, test1);

		}

		Step_End(6, "System automatically selected the \"\"Move All charges to Master\"\" option \"", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
