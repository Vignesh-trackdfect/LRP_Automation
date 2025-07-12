package LRP_EDI_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Creation_TS_012 extends Keywords {
	public void EDI_Creation_TS_012(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_EDI_Creation_TS_012";

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
		String Directory_Input = Excel_data.get("Directory_Input");
		String Agency_Code_input = Excel_data.get("Agency_Code_input");
		String EDI_Updated_Popup = Excel_data.get("EDI_Updated_Popup");
		String Profile_Input = Excel_data.get("Profile_Input");
		String UploadBy_Input = Excel_data.get("UploadBy_Input");
		String Updated_Directory_Input = Excel_data.get("Updated_Directory_Input");

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

		Step_Start(2, "Click the edit button and click the next button 3 time", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		Step_End(2, "Click the edit button and click the next button 3 time", test, test1);

		Step_Start(3, "Select any one record from the ag grid based on filter by profile id and directory", test,
				test1);

		waitForElement(driver, EDI_Local_Main_Filter);
		click(driver, EDI_Local_Main_Filter);

		waitForElement(driver, EDI_Agency_Code_Input_Filed);
		sendKeys(driver, EDI_Agency_Code_Input_Filed, Agency_Code_input);

		waitForElement(driver, EDI_Local_Profile_Id_Input);
		sendKeys(driver, EDI_Local_Profile_Id_Input, Profile_Input);

		waitForElement(driver, EDI_FTP_SFTP_Directory_Input_Field);
		sendKeys(driver, EDI_FTP_SFTP_Directory_Input_Field, Directory_Input);

		waitForElement(driver, EDI_Local_Upload_By_Input);
		sendKeys(driver, EDI_Local_Upload_By_Input, UploadBy_Input);

		waitForElement(driver, EDI_Local_First_Row_Grid);
		doubleClick(driver, EDI_Local_First_Row_Grid);
		Step_End(3, "Select any one record from the ag grid based on filter by profile id and directory", test, test1);

		Step_Start(4, "Update the directory ", test, test1);

		if (!Updated_Directory_Input.equals("")) {

			waitForElement(driver, EDI_Local_Directory);
			clear(driver, EDI_Local_Directory);
			sendKeys(driver, EDI_Local_Directory, Updated_Directory_Input);
		}

		waitForElement(driver, EDI_Local_Add_Button);
		click(driver, EDI_Local_Add_Button);

		// verify the directory Values update or not

		waitForElement(driver, EDI_Local_Main_Filter);
		click(driver, EDI_Local_Main_Filter);

		waitForElement(driver, EDI_Agency_Code_Input_Filed);
		sendKeys(driver, EDI_Agency_Code_Input_Filed, Agency_Code_input);

		waitForElement(driver, EDI_Local_Profile_Id_Input);
		sendKeys(driver, EDI_Local_Profile_Id_Input, Profile_Input);

		waitForElement(driver, EDI_FTP_SFTP_Directory_Input_Field);
		sendKeys(driver, EDI_FTP_SFTP_Directory_Input_Field, Updated_Directory_Input);

		waitForElement(driver, EDI_Local_Upload_By_Input);
		sendKeys(driver, EDI_Local_Upload_By_Input, UploadBy_Input);

		waitForElement(driver, EDI_Local_Directory_Value);
		String act_Directory = getText(driver, EDI_Local_Directory_Value);

		if (act_Directory.equals(Updated_Directory_Input)) {
			System.out.println("Matched || Expected Result: The given local 'Directory' should be Updated : "
					+ Updated_Directory_Input
					+ " in the grid || Actual Result: The given local 'Directory' was successfully Updated : "
					+ act_Directory + " in the grid.");
			Extent_pass_New(driver,
					"Matched || Expected Result: The given local 'Directory' should be Updated : "
							+ Updated_Directory_Input
							+ " in the grid || Actual Result: The given local 'Directory' was successfully Updated : "
							+ act_Directory + " in the grid.",
					test, test1);
		} else {

			System.out.println("Matched || Expected Result: The given local 'Directory' should be created : "
					+ Updated_Directory_Input
					+ " in the grid || Actual Result: The given local 'Directory' was Not  created : " + act_Directory
					+ " in the grid.");
			Extent_fail(driver,
					"Matched || Expected Result: The given local 'Directory' should be created : "
							+ Updated_Directory_Input
							+ " in the grid || Actual Result: The given local 'Directory' was Not created : "
							+ act_Directory + " in the grid.",
					test, test1);
		}

		Step_End(4, "Update the directory ", test, test1);

		Step_Start(5, "Click on skip to last check box and click next button ", test, test1);

		waitForElement(driver, EDI_Local_Skip_Last_Checkbox);
		click(driver, EDI_Local_Skip_Last_Checkbox);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		Step_End(5, "Click on skip to last check box and click next button ", test, test1);

		Step_Start(6, "Click confirm button", test, test1);

		waitForElement(driver, Confirm_Button_EDI_Creation);
		click(driver, Confirm_Button_EDI_Creation);

		waitForPopup(driver, popup_Message, EDI_Updated_Popup);
		String Act_Popup = getText(driver, popup_Message);
		if (EDI_Updated_Popup.equals(Act_Popup)) {
			System.out.println("Popup Matched ||  Expected : popup message should be display : " + EDI_Updated_Popup
					+ " || Actual : popup message is :  " + Act_Popup);
			Extent_pass_New(driver, "Popup Matched ||  Expected : popup message should be display : "
					+ EDI_Updated_Popup + " || Actual : popup message is : " + Act_Popup, test, test1);
		} else {
			System.out.println("Popup Not Matched ||  Expected : popup message should be display : " + EDI_Updated_Popup
					+ " || Actual : popup message is : " + Act_Popup);
			Extent_fail(driver, "Popup Not Matched ||  Expected : popup message should be display : "
					+ EDI_Updated_Popup + " || Actual : popup message is : " + Act_Popup, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(6, "Click confirm button", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}