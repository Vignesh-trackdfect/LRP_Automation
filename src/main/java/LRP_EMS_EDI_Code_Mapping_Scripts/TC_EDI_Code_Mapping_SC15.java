package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC15 extends Keywords {
	public void EDI_Code_Mapping_SC15(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC15";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Portcode_Headers = Excel_data.get("Portcode_Headers");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Depot_Terminal_Input = Excel_data.get("Depot_Terminal_Input");
		String EDI_Dep_Code_Mapping_Popup = Excel_data.get("EDI_Dep_Code_Mapping_Popup");

		String EDI_Dep_Code_Popup = Excel_data.get("EDI_Dep_Code_Popup");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click Depot tab", test, test1);

		waitForElement(driver, Depot_Tab_ECM);
		click(driver, Depot_Tab_ECM);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		Step_End(1, "Select the partner Id and click Depot tab", test, test1);

		Step_Start(2, "And click the save button now\"Enter The Depot / Terminal\" popup should show", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, EDI_Dep_Code_Mapping_Popup);
		String Saved_Popup4 = getText(driver, popup_Message);
		System.out.println(EDI_Dep_Code_Mapping_Popup);
		if (Saved_Popup4.equals(EDI_Dep_Code_Mapping_Popup)) {
			System.out.println("Matched || " + " Expected Depot / Terminal poup : " + EDI_Dep_Code_Mapping_Popup
					+ " || Actual Depot / Terminal poup : " + Saved_Popup4);
			Extent_pass_New(driver, "Matched || " + " Expected Depot / Terminal poup: " + EDI_Dep_Code_Mapping_Popup
					+ " || Actual Depot / Terminal poup : " + Saved_Popup4, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Depot / Terminal poup : " + EDI_Dep_Code_Mapping_Popup
					+ " || Actual Depot / Terminal poup : " + Saved_Popup4);
			Extent_fail(driver, "Not Matched || " + " Expected Depot / Terminal poup : " + EDI_Dep_Code_Mapping_Popup
					+ " || Actual Depot / Terminal poup : " + Saved_Popup4, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(2, "And click the save button now\"Enter The Depot / Terminal\" popup should show", test, test1);

		Step_Start(3, "Select any data in the Depot/terminal", test, test1);

		waitForElement(driver, Depot_Terminal_Search_ECM);
		click(driver, Depot_Terminal_Search_ECM);

		twoColumnSearchWindow(driver, Portcode_Headers, Filter_Condition, Depot_Terminal_Input);

		Step_End(3, "Select any data in the Depot/terminal", test, test1);

		Step_Start(4, "And click the save button now\"Enter The EDI Dep.Code\" popup should show", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, EDI_Dep_Code_Popup);
		String Saved_Popup5 = getText(driver, popup_Message);
		System.out.println(EDI_Dep_Code_Popup);
		if (Saved_Popup5.equals(EDI_Dep_Code_Popup)) {
			System.out.println("Matched || " + " Expected  EDI Dep.Code poup : " + EDI_Dep_Code_Popup
					+ " || Actual  EDI Dep.Code poup : " + Saved_Popup5);
			Extent_pass_New(driver, "Matched || " + " Expected  EDI Dep.Code poup: " + EDI_Dep_Code_Popup
					+ " || Actual  EDI Dep.Code poup : " + Saved_Popup5, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI Dep.Code poup : " + EDI_Dep_Code_Popup
					+ " || Actual EDI Dep.Code poup : " + Saved_Popup5);
			Extent_fail(driver, "Not Matched || " + " Expected EDI Dep.Code poup : " + EDI_Dep_Code_Popup
					+ " || Actual EDI Dep.Code poup : " + Saved_Popup5, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4, "And click the save button now\"Enter The EDI Dep.Code\" popup should show", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
