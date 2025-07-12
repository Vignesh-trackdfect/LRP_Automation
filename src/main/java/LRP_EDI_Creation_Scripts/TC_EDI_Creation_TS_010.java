package LRP_EDI_Creation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Creation_TS_010 extends Keywords {
	public void EDI_Creation_TS_010(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_EDI_Creation_TS_010";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String EDI_Creation_Module = Excel_data.get("EDI_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String EDI_Filter_Type1 = Excel_data.get("EDI_Filter_Type1");
		String EDI_Filter_Condition = Excel_data.get("EDI_Filter_Condition");
		String EDI_Filter_Value1 = Excel_data.get("EDI_Filter_Value1");
		String EDI_Filter_Type2 = Excel_data.get("EDI_Filter_Type2");
		String EDI_Filter_Value2 = Excel_data.get("EDI_Filter_Value2");
		String EDI_Filter_Type3 = Excel_data.get("EDI_Filter_Type3");
		String EDI_Filter_Value3 = Excel_data.get("EDI_Filter_Value3");
		String Subject_Input = Excel_data.get("Subject_Input");
		String EDI_List_Module = Excel_data.get("EDI_List_Module");
		String EDI_List_Grid_Header = Excel_data.get("EDI_List_Grid_Header");
		String Profile_Input = Excel_data.get("Profile_Input");
		String Email_Input = Excel_data.get("Email_Input");
		String EDI_Updated_Popup = Excel_data.get("EDI_Updated_Popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);
		moduleNavigate(driver, EDI_Creation_Module);

		Step_Start(1, "Retreive a record from global search by using edi id  ", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, EDI_Filter_Condition, EDI_Filter_Type1, EDI_Filter_Value1, EDI_Filter_Type2,
				EDI_Filter_Value2, EDI_Filter_Type3, EDI_Filter_Value3);

		Step_End(1, "Retreive a record from global search by using edi id  ", test, test1);

		Step_Start(2, "Click the edit button and click the next button 2 time", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		Step_End(2, "Click the edit button and click the next button 2 time", test, test1);

		Step_Start(3, " double click the data based on the filter by profile id and email id,subject", test, test1);
		Step_Start(4,
				"And click the remove button (or) user want to remove more than one record at time user can select the reqiured data from the grid and rightclick -> click remove option ",
				test, test1);

		List<String> Profile_Input_Value = splitAndExpand(Profile_Input, ",");
		List<String> Subject_Input_Value = splitAndExpand(Subject_Input, ",");
		List<String> Email_Input_Value = splitAndExpand(Email_Input, ",");

		for (int i = 0; i < Profile_Input_Value.size(); i++) {

			waitForElement(driver, EDI_Email_Main_Filter_Option);
			click(driver, EDI_Email_Main_Filter_Option);

			waitForElement(driver, EDI_Local_Profile_Id_Input);
			clear(driver, EDI_Local_Profile_Id_Input);
			sendKeys(driver, EDI_Local_Profile_Id_Input, Profile_Input_Value.get(i));

			waitForElement(driver, EDI_Email_Subject_Input_Field);
			clear(driver, EDI_Email_Subject_Input_Field);
			sendKeys(driver, EDI_Email_Subject_Input_Field, Subject_Input_Value.get(i));

			waitForElement(driver, EDI_Email_Email_input_Filter);
			clear(driver, EDI_Email_Email_input_Filter);
			sendKeys(driver, EDI_Email_Email_input_Filter, Email_Input_Value.get(i));

			formatLocatorClick(driver, EDI_Email_email_chechbox, Subject_Input_Value.get(i));
			if (i == Subject_Input_Value.size() - 1) {

				formatRightClick(driver, EDI_Email_Agency_code_Checkbox, Subject_Input_Value.get(i));

			}
		}
		waitForElement(driver, EDI_FTP_SFTP_Remove);
		click(driver, EDI_FTP_SFTP_Remove);

		Step_End(4,
				"And click the remove button (or) user want to remove more than one record at time user can select the reqiured data from the grid and rightclick -> click remove option ",
				test, test1);
		Step_End(3, " double click the data based on the filter by profile id and email id,subject", test, test1);

		Step_Start(5, "Click on skip to last check box  and click next button ", test, test1);

		waitForElement(driver, EDI_Email_Skip_To_Lask_Check_Box);
		click(driver, EDI_Email_Skip_To_Lask_Check_Box);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		Step_End(5, "Click on skip to last check box  and click next button ", test, test1);

		Step_Start(6, "Click confirm button  ", test, test1);

		waitForElement(driver, EDI_Partner_Code);
		String Act_Partner = getText(driver, EDI_Partner_Code);
		System.out.println("Act_Partner :" + Act_Partner);

		waitForElement(driver, EDI_Name);
		String Act_edi_name = getText(driver, EDI_Name);
		System.out.println("Act_edi_name :" + Act_edi_name);

		waitForElement(driver, Confirm_Button_EDI_Creation);
		click(driver, Confirm_Button_EDI_Creation);

		waitForPopup(driver, popup_Message, EDI_Updated_Popup);
		String Act_Popup = getText(driver, popup_Message);
		if (EDI_Updated_Popup.equals(Act_Popup)) {
			System.out.println("Popup Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup);
			Extent_pass_New(driver, "Popup Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup,
					test, test1);
		} else {
			System.out.println("Popup Not Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup);
			Extent_fail(driver, "Popup Not Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(6, "Click confirm button  ", test, test1);
		Step_Start(7, "Check that updated email is shown in the EDI List module in the email column ", test, test1);

		moduleNavigate(driver, EDI_List_Module);

		waitForElement(driver, EDI_List_Filter_Option);
		click(driver, EDI_List_Filter_Option);

		reArrangeAG_GridColumns(driver, EDI_List_Grid_Header);

		for (int i = 0; i < Email_Input_Value.size(); i++) {

			waitForElement(driver, EDI_List_Partner_E_ID_Input);
			clear(driver, EDI_List_Partner_E_ID_Input);
			sendKeys(driver, EDI_List_Partner_E_ID_Input, Email_Input_Value.get(i));

			waitForElement(driver, EDI_Email_Partner_Subject_Field);
			clear(driver, EDI_Email_Partner_Subject_Field);
			sendKeys(driver, EDI_Email_Partner_Subject_Field, Subject_Input_Value.get(i));
		}

		if (IsEmpty(driver, EDI_Email_partner_id_value)) {
			System.out.println(
					"Matched ||  Expected result : Given  profile id and email id,subject should be removed  in the grid || Actual result : Given  profile id and email id,subject removed in the grid  ");
			Extent_pass_New(driver,
					"Matched ||  Expected result : Given  profile id and email id,subject should be removed in the grid || Actual result : Given  profile id and email id,subject  removed in the grid  ",
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected result : Given  profile id and email id,subject should be removed  in the grid || Actual result : Given  profile id and email id,subject Not removed in the grid ");
			Extent_fail(driver,
					"Not Matched ||  Expected result : Given  profile id and email id,subject should be removed in the grid || Actual result : Given  profile id and email id,subject Not removed in the grid ",
					test, test1);

		}

		Step_End(7, "Check that updated email is shown in the EDI List module in the email column ", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}