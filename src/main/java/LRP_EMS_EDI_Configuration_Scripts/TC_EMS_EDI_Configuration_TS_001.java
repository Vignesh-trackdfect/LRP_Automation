package LRP_EMS_EDI_Configuration_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_001 extends Keywords {

	public void EMS_EDI_Configuration_TS_001(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_001";
		
		

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

		Step_End(1, "By default 'By Format' tab opened first", test, test1);

		Step_Start(2, "By default new button is enabled", test, test1);

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

		Step_End(2, "By default new button is enabled", test, test1);

		Step_Start(3, "Click the Format dropdown and select the type of EDI you want to create", test, test1);

		waitForElement(driver, EEC_Format_Dropdown);
		click(driver, EEC_Format_Dropdown);

		waitForElement(driver, EEC_Format_Dropdown);
		formatLocatorClick(driver, EEC_SelectFormat_Option, Select_Format);

		Step_End(3, "Click the Format dropdown and select the type of EDI you want to create", test, test1);

		Step_Start(4,
				"Click the Movement Code search button and select the Movement Code from the two-column search field",
				test, test1);

		waitForElement(driver, EEC_Movement_Code_Search_Button);
		click(driver, EEC_Movement_Code_Search_Button);

		twoColumnSearchWindow(driver, MovementCode_Header, Twocolumn_Condition, MovementCode);

		Step_End(4,
				"Click the Movement Code search button and select the Movement Code from the two-column search field",
				test, test1);

		Step_Start(5, "Click the 'EDI Code' dropdown and select the EDI Code", test, test1);

		waitForElement(driver, EEC_EDI_Code_Dropdown);
		click(driver, EEC_EDI_Code_Dropdown);

		waitForElement(driver, EEC_EDI_Code_Dropdown);
		formatLocatorClick(driver, EEC_SelectEDI_Option, Select_EDI);

		Step_End(5, "Click the 'EDI Code' dropdown and select the EDI Code", test, test1);

		Step_Start(6, "Click the EQD Segment dropdown and select the EQD Code", test, test1);

		if (!Select_EQD.isEmpty()) {

			waitForElement(driver, EEC_EQD_Segment);
			click(driver, EEC_EQD_Segment);

			waitForElement(driver, EEC_EDI_Code_Dropdown);
			formatLocatorClick(driver, EEC_SelectEQD_Option, Select_EQD);

		}

		Step_End(6, "Click the EQD Segment dropdown and select the EQD Code", test, test1);

		Step_Start(7, "Click the Transport Mode dropdown and select the Transport Mode type (optional)", test, test1);

		if (!Select_Transport.isEmpty()) {

			waitForElement(driver, EEC_Transport_Mode_Dropdown);
			click(driver, EEC_Transport_Mode_Dropdown);

			waitForElement(driver, EEC_Transport_Mode_Dropdown);
			formatLocatorClick(driver, EEC_SelectTransport_Option, Select_Transport);

		}

		Step_End(7, "Click the Transport Mode dropdown and select the Transport Mode type (optional)", test, test1);

		Step_Start(8, "Enter the Location Code in the LOC input field (optional)", test, test1);

		if (!LOC_Input.isEmpty()) {

			waitForElement(driver, EEC_LOC_Input_Field);
			click(driver, EEC_LOC_Input_Field);
			sendKeys(driver, EEC_LOC_Input_Field, LOC_Input);

		}

		Step_End(8, "Enter the Location Code in the LOC input field (optional)", test, test1);

		Step_Start(9, "Enter the Reference value in the RFF input field (optional)", test, test1);

		if (!RFF_Input.isEmpty()) {

			waitForElement(driver, EEC_RFF_Input_Field);
			click(driver, EEC_RFF_Input_Field);
			sendKeys(driver, EEC_RFF_Input_Field, RFF_Input);

		}

		Step_End(9, "Enter the Reference value in the RFF input field (optional)", test, test1);

		Step_Start(10,
				"Click the 'Previous Move' search button and select the previous Movement Code from the two-column search field (optional)",
				test, test1);

		if (Prev_Move_Condition.equals("Yes")) {

			waitForElement(driver, EEC_Previous_Move_Search_Field);
			click(driver, EEC_Previous_Move_Search_Field);

			twoColumnSearchWindow(driver, MovementCode_Header, Twocolumn_Condition, Previous_Move);

		}

		Step_End(10,
				"Click the 'Previous Move' search button and select the previous Movement Code from the two-column search field (optional)",
				test, test1);

		Step_Start(11,
				"Click the 'Special Condition' checkbox to enable it, and enter the special condition (optional)", test,
				test1);

		if (Special_Condition.equals("Yes")) {

			waitForElement(driver, EEC_SpecialCondition_Checkbox);
			click(driver, EEC_SpecialCondition_Checkbox);

		}

		Step_End(11, "Click the 'Special Condition' checkbox to enable it, and enter the special condition (optional)",
				test, test1);

		Step_Start(12, "Click the 'Status' dropdown and select the status by default, it is set to 'Active' (optional)",
				test, test1);

		if (!Select_Status.isEmpty()) {

			waitForElement(driver, EEC_Status_Activity_Dropdown);
			click(driver, EEC_Status_Activity_Dropdown);

			waitForElement(driver, EEC_Status_Activity_Dropdown);
			formatLocatorClick(driver, EEC_SelectStatus_Option, Select_Status);

		}

		Step_End(12, "Click the 'Status' dropdown and select the status by default, it is set to 'Active' (optional)",
				test, test1);

		Step_Start(13, "Click the Add button to add", test, test1);

		waitForElement(driver, EEC_Add_button);
		click(driver, EEC_Add_button);

		Step_End(13, "Click the Add button to add", test, test1);

		Step_Start(14, "Click the save icon in the toolbar", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(14, "Click the save icon in the toolbar", test, test1);

		Step_Start(15, "The system will display EMS EDI Movement Code configuration saved. Click OK", test, test1);

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

		Step_End(15, "The system will display EMS EDI Movement Code configuration saved. Click OK", test, test1);

		waitForElement(driver, EEC_ByFormat_Filter);
		click(driver, EEC_ByFormat_Filter);

		if (!MovementCode.isEmpty()) {

			waitForElement(driver, EEC_MovementCode_FilterInput);
			sendKeys(driver, EEC_MovementCode_FilterInput, MovementCode);

		}

		if (!Select_EDI.isEmpty()) {

			waitForElement(driver, EEC_EDICode_FilterInput);
			sendKeys(driver, EEC_EDICode_FilterInput, Select_EDI);

		}

		if (!Select_Transport.isEmpty()) {

			waitForElement(driver, EEC_TSP_FilterInput);
			sendKeys(driver, EEC_TSP_FilterInput, Select_Transport);

		}

		String substring = Select_Status.substring(0, 1);

		if (!Select_Status.isEmpty()) {

			waitForElement(driver, EEC_Status_FilterInput);
			sendKeys(driver, EEC_Status_FilterInput, substring);

		}

		if (isdisplayed(driver, EEC_MovementCodeValue1)) {

			System.out.println(
					"Pass || Expected result is : Newly Added details should displayed in the Grid || Actual result is : Newly Added details are displayed in the Grid");
			Extent_pass_New(driver,
					"Pass || Expected result is : Newly Added details should displayed in the Grid || Actual result is : Newly Added details are displayed in the Grid",
					test, test1);
		} else {
			System.out.println(
					"Pass || Expected result is : Newly Added details should displayed in the Grid || Actual result is : Newly Added details are not displayed in the Grid");
			Extent_fail(driver,
					"Pass || Expected result is : Newly Added details should displayed in the Grid || Actual result is : Newly Added details are not displayed in the Grid",
					test, test1);
		}

		Extent_completed(testcase_Name, test, test1);

	}

}
