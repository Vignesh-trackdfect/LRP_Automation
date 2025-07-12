package LRP_EMS_EDI_Configuration_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_002 extends Keywords {

	public void EMS_EDI_Configuration_TS_002(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_002";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String Select_Format = Excel_data.get("Select_Format");
		String MovementCode_Header = Excel_data.get("MovementCode_Header");
		String Twocolumn_Condition = Excel_data.get("Twocolumn_Condition");
		String MovementCode = Excel_data.get("MovementCode");
		String Select_EDI = Excel_data.get("Select_EDI");
		String Select_EQD = Excel_data.get("Select_EQD");
		String Select_Transport = Excel_data.get("Select_Transport");
		String LOC_Input = Excel_data.get("LOC_Input");
		String RFF_Input = Excel_data.get("RFF_Input");
		String Prev_Move_Condition = Excel_data.get("Prev_Move_Condition");
		String Previous_Move = Excel_data.get("Previous_Move");
		String Special_Condition = Excel_data.get("Special_Condition");
		String Select_Status = Excel_data.get("Select_Status");
		String Save_popup = Excel_data.get("Save_popup");
		String Select_MovementCode = Excel_data.get("Select_MovementCode");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module_Name);

		Step_Start(1, "By default 'By Format' tab opened first", test, test1);

		if (isdisplayed(driver, EEC_Format_Dropdown)) {

			System.out.println(
					"Pass || Expected result is : By Default 'By Fomat' Tab should be opened || Actual result is : By Default 'By Fomat' Tab is opened");
			Extent_pass_New(driver,
					"Pass || Expected result is : By Default 'By Fomat' Tab should be opened || Actual result is : By Default 'By Fomat' Tab is opened",
					test, test1);

		} else {

			System.out.println(
					"Fail || Expected result is : By Default 'By Fomat' Tab should be opened || Actual result is : By Default 'By Fomat' Tab is not opened");
			Extent_fail(driver,
					"Fail || Expected result is : By Default 'By Fomat' Tab should be opened || Actual result is : By Default 'By Fomat' Tab is not opened",
					test, test1);

		}

		if (!isElementEnabled(driver, NewButton_ToolBar)) {

			System.out.println(
					"Pass || Expected result is : By Default 'New button' should be enabled || Actual result is : By Default 'New button' is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : By Default 'New button' should be enabled || Actual result is : By Default 'New button' is enabled",
					test, test1);

		} else {

			System.out.println(
					"Fail || Expected result is : By Default 'New button' should be enabled || Actual result is : By Default 'New button' is disabled");
			Extent_fail(driver,
					"Fail || Expected result is : By Default 'New button' should be enabled || Actual result is : By Default 'New button' is disabled",
					test, test1);

		}

		Step_End(1, "By default 'By Format' tab opened first", test, test1);

		Step_Start(2, "Click the 'Format' dropdown and select the type of EDI you want to edit", test, test1);

		waitForElement(driver, EEC_Format_Dropdown);
		click(driver, EEC_Format_Dropdown);

		waitForElement(driver, EEC_Format_Dropdown);
		formatLocatorClick(driver, EEC_SelectFormat_Option, Select_Format);

		Step_End(2, "Click the 'Format' dropdown and select the type of EDI you want to edit", test, test1);

		Step_Start(3, "Double-click the record you want to remove in the AG grid", test, test1);

		formatLocatorDoubleClick(driver, EEC_MovementSelect, Select_MovementCode);

		Step_End(3, "Double-click the record you want to remove in the AG grid", test, test1);

		Step_Start(4, "Then, edit the fields you want to change", test, test1);

		if (!MovementCode.isEmpty()) {

			waitForElement(driver, EEC_Movement_Code_Search_Button);
			click(driver, EEC_Movement_Code_Search_Button);

			twoColumnSearchWindow(driver, MovementCode_Header, Twocolumn_Condition, MovementCode);

		}

		if (!Select_EDI.isEmpty()) {

			waitForElement(driver, EEC_EDI_Code_Dropdown);
			click(driver, EEC_EDI_Code_Dropdown);

			waitForElement(driver, EEC_EDI_Code_Dropdown);
			formatLocatorClick(driver, EEC_SelectEDI_Option, Select_EDI);

		}

		if (!Select_EQD.isEmpty()) {

			waitForElement(driver, EEC_EQD_Segment);
			click(driver, EEC_EQD_Segment);

			waitForElement(driver, EEC_EDI_Code_Dropdown);
			formatLocatorClick(driver, EEC_SelectEQD_Option, Select_EQD);

		}

		if (!Select_Transport.isEmpty()) {

			waitForElement(driver, EEC_Transport_Mode_Dropdown);
			click(driver, EEC_Transport_Mode_Dropdown);

			waitForElement(driver, EEC_Transport_Mode_Dropdown);
			formatLocatorClick(driver, EEC_SelectTransport_Option, Select_Transport);

		}

		if (!LOC_Input.isEmpty()) {

			waitForElement(driver, EEC_LOC_Input_Field);
			click(driver, EEC_LOC_Input_Field);
			clear(driver, EEC_LOC_Input_Field);
			sendKeys(driver, EEC_LOC_Input_Field, LOC_Input);

		}

		if (!RFF_Input.isEmpty()) {

			waitForElement(driver, EEC_RFF_Input_Field);
			click(driver, EEC_RFF_Input_Field);
			clear(driver, EEC_RFF_Input_Field);
			sendKeys(driver, EEC_RFF_Input_Field, RFF_Input);

		}

		if (Prev_Move_Condition.equals("Yes")) {

			waitForElement(driver, EEC_Previous_Move_Search_Field);
			click(driver, EEC_Previous_Move_Search_Field);

			twoColumnSearchWindow(driver, MovementCode_Header, Twocolumn_Condition, Previous_Move);

		}

		if (Special_Condition.equals("Yes")) {

			waitForElement(driver, EEC_SpecialCondition_Checkbox);
			click(driver, EEC_SpecialCondition_Checkbox);

		}

		if (!Select_Status.isEmpty()) {

			waitForElement(driver, EEC_Status_Activity_Dropdown);
			click(driver, EEC_Status_Activity_Dropdown);

			waitForElement(driver, EEC_Status_Activity_Dropdown);
			formatLocatorClick(driver, EEC_SelectStatus_Option, Select_Status);

		}

		Step_End(4, "Then, edit the fields you want to change", test, test1);

		Step_Start(5, "Click the Add button to add", test, test1);

		waitForElement(driver, EEC_Add_button);
		click(driver, EEC_Add_button);

		Step_End(5, "Click the Add button to add", test, test1);

		Step_Start(6, "Click the save icon in the toolbar", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Save_popup);

		String ActualPopup = getText(driver, popup_Message);

		if (Save_popup.equals(ActualPopup)) {

			System.out.println(
					"System displayed the expected popup || Expected : " + Save_popup + " || Actual : " + ActualPopup);
			Extent_pass_New(driver,
					"System displayed the expected popup || Expected : " + Save_popup + " || Actual : " + ActualPopup,
					test, test1);

		} else {

			System.out.println(
					"System displayed the different popup || Expected : " + Save_popup + " || Actual : " + ActualPopup);
			Extent_fail(driver,
					"System displayed the different popup || Expected : " + Save_popup + " || Actual : " + ActualPopup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(6, "Click the save icon in the toolbar", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
