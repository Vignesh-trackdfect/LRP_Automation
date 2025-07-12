package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC18 extends Keywords {
	public void EDI_Code_Mapping_SC18(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC18";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String EDI_Commodity_Code_Popup = Excel_data.get("EDI_Commodity_Code_Popup");
		String Commodity_Code_Popup = Excel_data.get("Commodity_Code_Popup");
		String Commodity_Code = Excel_data.get("Commodity_Code");
		String ComdtyCode_Header = Excel_data.get("ComdtyCode_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click Commodity Code tab", test, test1);

		waitForElement(driver, Commodity_Code_Tab_ECM);
		click(driver, Commodity_Code_Tab_ECM);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		Step_End(1, "Select the partner Id and click Commodity Code tab", test, test1);

		Step_Start(2, "And click the save button now\" Enter The_Commodity_Code_Popup", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Commodity_Code_Popup);
		String Saved_Popup = getText(driver, Popup_Message);
		System.out.println(Saved_Popup);
		if (Saved_Popup.equals(Commodity_Code_Popup)) {
			System.out.println("Matched || " + " Expected Commodiy code Popup : " + Commodity_Code_Popup
					+ " || Actual Commodiy code Popup : " + Saved_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Commodiy code Popup: " + Commodity_Code_Popup
					+ " || Actual Commodiy code Popup : " + Saved_Popup, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Commodiy code Popup : " + Commodity_Code_Popup
					+ " || Actual Commodiy code Popup : " + Saved_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Commodiy code Popup : " + Commodity_Code_Popup
					+ " || Actual Commodiy code Popup : " + Saved_Popup, test, test1);

		}

		Step_End(2, "And click the save button now\" Enter the Commodiy code", test, test1);

		Step_Start(3, "Select any data in the Commodiy code", test, test1);

		waitForElement(driver, Commodity_Code_Search_ECM);
		click(driver, Commodity_Code_Search_ECM);

		twoColumnSearchWindow(driver, ComdtyCode_Header, Filter_Condition, Commodity_Code);

		Step_End(3, "Select any data in in the Commodiy code", test, test1);

		Step_Start(4, "And click the save button now\"Enter the EDICommodiy code\" popup should show", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, EDI_Commodity_Code_Popup);
		String Saved_Popup1 = getText(driver, Popup_Message);
		System.out.println(Saved_Popup1);
		if (Saved_Popup1.equals(EDI_Commodity_Code_Popup)) {
			System.out.println("Matched || " + " Expected EDI_Commodity_Code_Popup : " + EDI_Commodity_Code_Popup
					+ " || Actual EDI_Commodity_Code_Popup : " + Saved_Popup1);
			Extent_pass_New(driver, "Matched || " + " Expected EDI_Commodity_Code_Popup: " + EDI_Commodity_Code_Popup
					+ " || Actual EDI_Commodity_Code_Popup : " + Saved_Popup1, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI_Commodity_Code_Popup : " + EDI_Commodity_Code_Popup
					+ " || Actual EDI_Commodity_Code_Popup : " + Saved_Popup1);
			Extent_fail(driver, "Not Matched || " + " Expected EDI_Commodity_Code_Popup : " + EDI_Commodity_Code_Popup
					+ " || Actual EDI_Commodity_Code_Popup : " + Saved_Popup1, test, test1);

		}

		Step_End(4, "And click the save button now\"Enter the EDICommodiy code\" popup should show", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
