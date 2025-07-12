package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC66 extends Keywords {

	public void Feeder_Contract_SC66(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC66";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Feeder_Contract_Header = Excel_data.get("Feeder_Contract_Header");
		String Feeder_Contract_No = Excel_data.get("Feeder_Contract_No");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String Cache_Refresh_Popup = Excel_data.get("Cache_Refresh_Popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Enter the screen name as \"Feeder contract\" in module search field.", test, test1);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Enter the screen name as \"Feeder contract\" in module search field.", test, test1);
		Step_Start(2, "Click on the global search option which is available in the tool bar", test, test1);
		Step_Start(3, ".Check whether the system opens the contract details search window. ", test, test1);
		Step_Start(4, "Enter the saved fdr contract number in the contract number search field", test, test1);
		Step_Start(5, "Click on the search button", test, test1);
		Step_Start(6, "System will show cotract details based on the Contarct number", test, test1);
		Step_Start(7, "Double click the Contract detials.", test, test1);

		waitForElement(driver, FC_Search_Btn);
		click(driver, FC_Search_Btn);

		if (isdisplayed(driver, FC_Search_Window)) {
			System.out.println(
					"Expected result : Feeder contract search window should be displayed || Actual result : Feeder contract search window should be displayed ");
			Extent_pass_New(driver,
					"Expected result : Feeder contract search window should be displayed  || Actual result : Feeder contract search window should be displayed ",
					test, test1);
		} else {

			System.out.println(
					"Expected result :Feeder contract search window should be displayed  || Actual result : Feeder contract search window should be displayed ");
			Extent_fail(driver,
					"Expected result :Feeder contract search window should be displayed  || Actual result : Feeder contract search window should be displayed ",
					test, test1);

		}

		globalValueSearchWindow(driver, Two_Column_Condition, Feeder_Contract_Header, Feeder_Contract_No, "", "", "",
				"");

		Step_End(2, "Click on the global search option which is available in the tool bar.  ", test, test1);
		Step_End(3, ".Check whether the system opens the contract details search window. ", test, test1);
		Step_End(4, "Enter the saved fdr contract number in the contract number search field", test, test1);
		Step_End(5, "Click on the search button", test, test1);
		Step_End(6, "System will show cotract details based on the Contarct number", test, test1);
		Step_End(7, "Double click the Contract detials.", test, test1);

		Step_Start(8, "Check whether the system retrieves the saved contract number.", test, test1);

		String Act_FC_Contract_No = getAttribute(driver, FDR_Contract__No_Value, "value");
		System.out.println(Act_FC_Contract_No);
		if (Act_FC_Contract_No.equals(Feeder_Contract_No)) {
			System.out.println(
					"Matched || " + " Expected feeder contract number should be displayed : " + Feeder_Contract_No
							+ " || Actual Expected feeder contract number should be displayed : " + Act_FC_Contract_No);
			Extent_pass_New(driver,
					"Matched || " + " Expected feeder contract number should be displayed: " + Feeder_Contract_No
							+ " || Actual feeder contract number should be displayed : " + Act_FC_Contract_No,
					test, test1);

		}

		else {
			System.out.println(
					"Not Matched || " + " Expected feeder contract number should be displayed: " + Feeder_Contract_No
							+ " || Actual Expected feeder contract number should be displayed : " + Act_FC_Contract_No);
			Extent_fail(driver,
					"Not Matched || " + " Expected feeder contract number should be displayed: " + Feeder_Contract_No
							+ " || Actual feeder contract number should be displayed: " + Act_FC_Contract_No,
					test, test1);

		}

		Step_End(8, "Check whether the system retrieves the saved contract number.", test, test1);

		Step_Start(9, "Click the Refresh cache ,It should refresh all the details..", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, FCT_btnRefreshCache);
		click(driver, FCT_btnRefreshCache);

		waitForDisplay(driver, popup_Message);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(Cache_Refresh_Popup)) {
			System.out.println("Matched || " + " Expected It should refresh all the details : " + Cache_Refresh_Popup
					+ " || Actual It should refresh all the details : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected It should refresh all the details: "
					+ Cache_Refresh_Popup + " || Actual It should refresh all the details is : " + Applied_Popup, test,
					test1);

		} else {
			System.out.println("Not Matched || " + " Expected It should refresh all the details : "
					+ Cache_Refresh_Popup + " || Actual Expected It should refresh all the details : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected It should refresh all the details: "
					+ Cache_Refresh_Popup + " || Actual Expected It should refresh all the details: " + Applied_Popup,
					test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(9, "Click the Refresh cache ,It should refresh all the details..", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
