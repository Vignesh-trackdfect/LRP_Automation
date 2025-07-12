package LRP_EMS_EDI_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_008 extends Keywords {

	public void EMS_EDI_Configuration_TS_008(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_008";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Tab_Option = Excel_data.get("Tab_Option");

		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Partner_ID_input = Excel_data.get("Partner_ID_input");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID_Input = Excel_data.get("EDI_ID_Input");
		String Movement_Code = Excel_data.get("Movement_Code");
		String Saved_pop_Expected = Excel_data.get("Saved_pop_Expected");
		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "Go to the By EDI tab", test, test1);

		formatLocatorClick(driver, EEC_Tab_Option, Tab_Option);

		Step_End(1, "Go to the By EDI tab", test, test1);

		Step_Start(2, "Click the Partner Id search button, and select the partner ID from the two column search", test,
				test1);

		waitForElement(driver, EEC_Partner_Id_Search_Button);
		click(driver, EEC_Partner_Id_Search_Button);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID_input);

		Step_End(2, "Click the Partner Id search button, and select the partner ID from the two column search", test,
				test1);

		Step_Start(3,
				"Click the EDI ID search button, and select the EDI ID from the two column search.Filter using the EDI ID and Partner ID, then click the Search button",
				test, test1);

		waitForElement(driver, EEC_EDI_Id_Search_Button);
		click(driver, EEC_EDI_Id_Search_Button);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID_Input);

		Step_End(3,
				"Click the EDI ID search button, and select the EDI ID from the two column search.Filter using the EDI ID and Partner ID, then click the Search button",
				test, test1);

		Step_Start(4, "Click the show button", test, test1);

		waitForElement(driver, EEC_Show_Button);
		click(driver, EEC_Show_Button);

		Step_End(4, "Click the show button", test, test1);

		Step_Start(6, "Click the \"Show All\" button", test, test1);
		waitForElement(driver, EEC_Show_All_Button);
		click(driver, EEC_Show_All_Button);
		Step_Start(5, ".Once clicked, records will be shown in the AG grid for the selected conditions", test, test1);
		Step_End(6, "Click the \"Show All\" button", test, test1);
		Step_Start(7,
				"After clicked new Ag grid will be shown at the bottom of the screen with the name of \"not mapped to this EDI\"\r\n"
						+ "",
				test, test1);
		Step_Start(8, "The new AG grid records are shown from the \"By Format\" based on the Format value.\r\n" + "",
				test, test1);
		waitForElement(driver, EEC_Show_All_Button);
		String total_before = getText(driver, BY_EDI_Total_redords);
		System.out.println(total_before);
		Step_End(5, ".Once clicked, records will be shown in the AG grid for the selected conditions", test, test1);
		Step_End(7,
				"After clicked new Ag grid will be shown at the bottom of the screen with the name of \"not mapped to this EDI\"\r\n"
						+ "",
				test, test1);
		Step_End(8, "The new AG grid records are shown from the \"By Format\" based on the Format value.\r\n" + "",
				test, test1);
		Step_Start(9, "Select the records from New AG grid and click the \"Add\" button", test, test1);
		formatLocatorClick(driver, BY_EDI_Checkbox2, Movement_Code); 
		waitForElement(driver, EEC_By_EDI_Add_Button);
		click(driver, EEC_By_EDI_Add_Button);
		Step_End(9, "Select the records from New AG grid and click the \"Add\" button", test, test1);

		Step_Start(10, "Then records will be added in the old AG grid.\r\n" + "", test, test1);
		waitForElement(driver, EEC_Show_All_Button);
		String total_After = getText(driver, BY_EDI_Total_redords);
		System.out.println(total_After);

		Step_End(10, "Then records will be added in the old AG grid.\r\n" + "", test, test1);

		Step_Start(11, "Then click the \"Save\" button to save the added movements.\r\n" + "", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(11, "Then click the \"Save\" button to save the added movements.\r\n" + "", test, test1);

		Step_Start(12, "The system show the \"EMS EDI Movementcode configuration saved\" once saved, Click \"OK\"",
				test, test1);
		
		waitForPopup(driver, popup_Message, Saved_pop_Expected);
		String save_pop_Actual = getText(driver, popup_Message);
		System.out.println(save_pop_Actual);
		if (Saved_pop_Expected.equals(save_pop_Actual)) {
			System.out.println("Matched || Expected popup message was : " + Saved_pop_Expected + " || Actual popup message was : "
					+ save_pop_Actual);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Saved_pop_Expected + " || Actual popup message was : "
					+ save_pop_Actual, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + Saved_pop_Expected + " || Actual popup message was : "
					+ save_pop_Actual);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Saved_pop_Expected + " || Actual popup message was  : "
					+ save_pop_Actual, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(12, "The system show the \"EMS EDI Movementcode configuration saved\" once saved, Click \"OK\"", test,
				test1);

		waitForElement(driver, BY_EDI_Filter);
		click(driver, BY_EDI_Filter);

		waitForElement(driver, BY_EDI_Filterinside);
		click(driver, BY_EDI_Filterinside);
		waitForElement(driver, BY_EDI_movement_code_input);
		sendKeys(driver, BY_EDI_movement_code_input, Movement_Code);

		String Add_code = formatLocatorClick(driver, Port_selectt, Movement_Code);
		waitForDisplay(driver, Add_code);
		if (isdisplayed(driver, Add_code)) {
			Extent_pass_New(driver, "**Movement code was added in gird as**" + Movement_Code, test, test1);
		} else {
			extent_fail(driver, "**Movement code was not added in gird as**" + Movement_Code, test, test1);
		}

		if (total_before.equals(total_After)) {
			System.out.println(
					"Matched ||  Value was shown  before adding the movement code TOTAL RECORDS  : " + total_before
							+ " ||  Value was shown  after adding the movement code TOTAL RECORDS: " + total_After);
			Extent_fail(driver,
					"Matched ||  Value was shown  before adding the movement code TOTAL RECORDS: " + total_before
							+ " ||  Value was shown  after adding the movement code TOTAL RECORDS: " + total_After,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Value was shown  before adding the movement code TOTAL RECORDS: " + total_before
							+ " ||  Value was shown  after adding the movement code TOTAL RECORDS : " + total_After);
			Extent_pass_New(driver,
					"Not Matched ||  Value was shown  before adding the movement code TOTAL RECORDS: " + total_before
							+ " ||  Value was shown  after adding the movement code TOTAL RECORDS : " + total_After,
					test, test1);
		}

		Extent_completed(testcase_Name, test, test1);

	}
}
