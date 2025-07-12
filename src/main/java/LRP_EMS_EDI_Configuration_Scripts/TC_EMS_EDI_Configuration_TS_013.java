package LRP_EMS_EDI_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_013 extends Keywords {

	public void EMS_EDI_Configuration_TS_013(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_013";

		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Format_Value = Excel_data.get("Format_Value");
		String Movement_Code_Header = Excel_data.get("Movement_Code_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Movement_Code_Input = Excel_data.get("Movement_Code_Input");
		String Popup = Excel_data.get("Popup");
		String Movement_code_popup = Excel_data.get("Movement_code_popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1,
				"If we click the Saveicon , without selecting Movement code, system will show Select Movementcode",
				test, test1);

		waitForElement(driver, EEC_Format_Dropdown);
		click(driver, EEC_Format_Dropdown);

		formatLocatorClick(driver, DropDown_Select, Format_Value);

		waitForElement(driver, EEC_Save_Button);
		click(driver, EEC_Save_Button);

		waitForPopup(driver, popup_Message, Movement_code_popup);
		String Act_Popup_movement = getText(driver, popup_Message);

		if (Movement_code_popup.equals(Act_Popup_movement)) {
			System.out.println(
					"Matched || After click on save Button the Expected Pop-up value is : " + Movement_code_popup
							+ " ||After click on save Button the Actual Pop-up value is  : " + Act_Popup_movement);
			Extent_pass_New(driver,
					"Matched || After click on save Button the Expected Pop-up value is : " + Movement_code_popup
							+ " ||After click on save Button the Actual Pop-up value is  : " + Act_Popup_movement,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || After click on save Button the Expected Pop-up value is : " + Movement_code_popup
							+ " ||After click on save Button the Actual Pop-up value is  : " + Act_Popup_movement);
			Extent_fail(driver,
					"Not Matched || After click on save Button the Expected Pop-up value is : " + Movement_code_popup
							+ " ||After click on save Button the Actual Pop-up value is  : " + Act_Popup_movement,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, EEC_Movement_Code_Search_Button);
		click(driver, EEC_Movement_Code_Search_Button);

		twoColumnSearchWindow(driver, Movement_Code_Header, Filter_Condition, Movement_Code_Input);

		Step_End(1, "If we click the Saveicon , without selecting Movement code, system will show Select Movementcode",
				test, test1);

		Step_Start(2, ".If we click the saveicon , without selecting EDI code, system will show Select EDI Code", test,
				test1);

		waitForElement(driver, EEC_Save_Button);
		click(driver, EEC_Save_Button);

		waitForPopup(driver, popup_Message, Popup);
		String Act_Popup = getText(driver, popup_Message);

		if (Popup.equals(Act_Popup)) {
			System.out.println("Matched || After click on save Button the Expected Pop-up value is : " + Popup
					+ " ||After click on save Button the Actual Pop-up value is  : " + Act_Popup);
			Extent_pass_New(driver, "Matched || After click on save Button the Expected Pop-up value is : " + Popup
					+ " ||After click on save Button the Actual Pop-up value is  : " + Act_Popup, test, test1);
		} else {
			System.out.println("Not Matched || After click on save Button the Expected Pop-up value is : " + Popup
					+ " ||After click on save Button the Actual Pop-up value is  : " + Act_Popup);
			Extent_fail(driver, "Not Matched || After click on save Button the Expected Pop-up value is : " + Popup
					+ " ||After click on save Button the Actual Pop-up value is  : " + Act_Popup, test, test1);
		}

		Step_End(2, "If we click the saveicon , without selecting EDI code, system will show Select EDI Code", test,
				test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
