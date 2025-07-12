package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC17 extends Keywords {
	public void EDI_Code_Mapping_SC17(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC17";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Package_Code_Header = Excel_data.get("Package_Code_Header");
		String Liner_Package_Code = Excel_data.get("Liner_Package_Code");
		String EDI_Package_Popup = Excel_data.get("EDI_Package_Popup");
		String Liner_Package_Popup = Excel_data.get("Liner_Package_Popup");
		String Filter_Condition = Excel_data.get("Filter_Condition");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click Package tab", test, test1);

		waitForElement(driver, Click_Package_Tab_ECM);
		click(driver, Click_Package_Tab_ECM);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		Step_End(1, "Select the partner Id and click package tab", test, test1);

		Step_Start(2, "And click the save button now\" Enter The Liner Package", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Liner_Package_Popup);
		String Saved_Popup = getText(driver, popup_Message);
		System.out.println(Liner_Package_Popup);
		if (Saved_Popup.equals(Liner_Package_Popup)) {
			System.out.println("Matched || " + " Expected Liner Package Popup : " + Liner_Package_Popup
					+ " || Actual Liner Package Popup : " + Saved_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Liner Package Popup: " + Liner_Package_Popup
					+ " || Actual Liner Package Popup : " + Saved_Popup, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Liner Package Popup : " + Liner_Package_Popup
					+ " || Actual Liner Package Popup : " + Saved_Popup);
			Extent_fail(driver,"Not Matched || " + " Expected Liner Package Popup : " + Liner_Package_Popup
					+ " || Actual Liner Package Popup : " + Saved_Popup, test, test1);
		}
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		
		Step_End(2, "And click the save button now\" Enter The Liner Package", test, test1);

		Step_Start(3, "Select any data in the liner package", test, test1);

		waitForElement(driver, Liner_Package_Search_ECM);
		click(driver, Liner_Package_Search_ECM);

		twoColumnSearchWindow(driver, Package_Code_Header, Filter_Condition, Liner_Package_Code);

		Step_End(3, "Select any data in the liner package", test, test1);

		Step_Start(4, "And click the save button now\"Enter the EDI Package \" popup should show", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, EDI_Package_Popup);
		String Saved_Popup1 = getText(driver, popup_Message);
		System.out.println(EDI_Package_Popup);
		if (Saved_Popup1.equals(EDI_Package_Popup)) {
			System.out.println("Matched || " + " Expected EDI Package Popup : " + EDI_Package_Popup
					+ " || Actual EDI Package Popup: " + Saved_Popup1);
			Extent_pass_New(driver, "Matched || " + " Expected EDI Package Popup : " + EDI_Package_Popup
					+ " || Actual EDI Package Popup: " + Saved_Popup1, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI Package Popup: " + EDI_Package_Popup
					+ " || Actual EDI Package Popup: " + Saved_Popup1);
			Extent_fail(driver, "Not Matched || " + " Expected EDI Package Popup : " + EDI_Package_Popup
					+ " || Actual EDI Package Popup : " + Saved_Popup1, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4, "And click the save button now\"Enter the EDI Package\" popup should show", test, test1);

		Extent_completed(testCaseName, test, test1);
	
	}
}
