package LRP_EDI_Creation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Creation_TS_016 extends Keywords {
	public void EDI_Creation_TS_016(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_EDI_Creation_TS_016";

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
		String Agency_Code_input = Excel_data.get("Agency_Code_input");
		String EDI_Updated_Popup = Excel_data.get("EDI_Updated_Popup");
		String UploadBy_Input = Excel_data.get("UploadBy_Input");
		String Sharepath_Input = Excel_data.get("Sharepath_Input");
		String Status_Value = Excel_data.get("Status_Value");

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

		Step_Start(2, "Click the edit button and click the next button 4 time", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		Step_End(2, "Click the edit button and click the next button 4 time", test, test1);

		Step_Start(3, "double click the data based on the filter by profile and sharepath", test, test1);
		Step_Start(4,
				".And click the remove button (or) user want to remove more than one record at time user can select the reqiured data from the grid and rightclick -> click remove option ",
				test, test1);

		waitForElement(driver, EDI_Web_Service_Status);
		click(driver, EDI_Web_Service_Status);

		formatLocatorClick(driver, EDI_Web_Service_Dropdown_Option, Status_Value);

		List<String> Profile_Input_Value = splitAndExpand(UploadBy_Input, ",");
		List<String> Sharepath_Input_Value = splitAndExpand(Sharepath_Input, ",");
		List<String> Agency_Input_Value = splitAndExpand(Agency_Code_input, ",");

		for (int i = 0; i < Profile_Input_Value.size(); i++) {

			waitForElement(driver, EDI_Web_Service_Main_Filter_Grid);
			click(driver, EDI_Web_Service_Main_Filter_Grid);

			waitForElement(driver, EDI_Agency_Code_Input_Filed);
			clear(driver, EDI_Agency_Code_Input_Filed);
			sendKeys(driver, EDI_Agency_Code_Input_Filed, Agency_Input_Value.get(i));

			waitForElement(driver, EDI_Web_Service_Sharepath_Input);
			clear(driver, EDI_Web_Service_Sharepath_Input);
			sendKeys(driver, EDI_Web_Service_Sharepath_Input, Sharepath_Input_Value.get(i));

			waitForElement(driver, EDI_Local_Upload_By_Input);
			clear(driver, EDI_Local_Upload_By_Input);
			sendKeys(driver, EDI_Local_Upload_By_Input, Profile_Input_Value.get(i));

			formatLocatorClick(driver, EDI_Web_Service_Sharepath_Check_Box, Sharepath_Input_Value.get(i));
			if (i == Sharepath_Input_Value.size() - 1) {

				formatRightClick(driver, EDI_Web_Service_Sharepath_Check_Box, Sharepath_Input_Value.get(i));

			}
		}

		waitForElement(driver, EDI_FTP_SFTP_Remove);
		click(driver, EDI_FTP_SFTP_Remove);

		for (int i = 0; i < Profile_Input_Value.size(); i++) {

			waitForElement(driver, EDI_Web_Service_Main_Filter_Grid);
			click(driver, EDI_Web_Service_Main_Filter_Grid);

			waitForElement(driver, EDI_Agency_Code_Input_Filed);
			clear(driver, EDI_Agency_Code_Input_Filed);
			sendKeys(driver, EDI_Agency_Code_Input_Filed, Agency_Input_Value.get(i));

			waitForElement(driver, EDI_Local_Upload_By_Input);
			clear(driver, EDI_Local_Upload_By_Input);
			sendKeys(driver, EDI_Local_Upload_By_Input, Profile_Input_Value.get(i));

			waitForElement(driver, EDI_Web_Service_Sharepath_Input);
			clear(driver, EDI_Web_Service_Sharepath_Input);
			sendKeys(driver, EDI_Web_Service_Sharepath_Input, Sharepath_Input_Value.get(i));

			if (IsEmpty(driver, EDI_Local_Directory_Value)) {
				System.out.println("Matched ||  Expected result : Given profile id : " + Profile_Input_Value.get(i)
						+ " , Share path : " + Sharepath_Input_Value.get(i) + " : and Ageny code : "
						+ Agency_Input_Value.get(i)
						+ "  should be removed  in the grid || Actual result : Given  profile id : "
						+ Profile_Input_Value.get(i) + ",Share path : " + Sharepath_Input_Value.get(i)
						+ "and Ageny code : " + Agency_Input_Value.get(i) + "  removed in the grid  ");
				Extent_pass_New(driver,
						"Matched ||  Expected result : Given profile id : " + Profile_Input_Value.get(i)
								+ " ,Share path : " + Sharepath_Input_Value.get(i) + " : and Ageny code : "
								+ Agency_Input_Value.get(i)
								+ " should be removed  in the grid || Actual result : Given  profile id :  "
								+ Profile_Input_Value.get(i) + ",Share path : " + Sharepath_Input_Value.get(i)
								+ "and Ageny code : " + Agency_Input_Value.get(i) + "  removed in the grid  ",
						test, test1);
			} else {
				System.out.println("Not Matched ||  Expected result : Given profile id : " + Profile_Input_Value.get(i)
						+ " ,Share path : " + Sharepath_Input_Value.get(i) + " : and Ageny code : "
						+ Agency_Input_Value.get(i)
						+ " should be removed  in the grid || Actual result : Given  profile id : "
						+ Profile_Input_Value.get(i) + ",Share path : " + Sharepath_Input_Value.get(i)
						+ "and Ageny code :  " + Agency_Input_Value.get(i) + "  Not removed in the grid  ");
				Extent_fail(driver,
						"Not Matched ||  Expected result : Given profile id : " + Profile_Input_Value.get(i)
								+ "  , Share path :  " + Sharepath_Input_Value.get(i) + " : and Ageny code : "
								+ Agency_Input_Value.get(i)
								+ " should be removed  in the grid || Actual result : Given  profile id : "
								+ Profile_Input_Value.get(i) + ",Share path : " + Sharepath_Input_Value.get(i)
								+ "and Ageny code : " + Agency_Input_Value.get(i) + " Not  removed in the grid  ",
						test, test1);
			}

		}

		Step_End(4,
				".And click the remove button (or) user want to remove more than one record at time user can select the reqiured data from the grid and rightclick -> click remove option ",
				test, test1);
		Step_End(3, "double click the data based on the filter by profile and sharepath", test, test1);

		Step_Start(5, "Click on skip to last check box  and click next button ", test, test1);

		waitForElement(driver, EDI_Web_Service_Skip_Last_Checkbox);
		click(driver, EDI_Web_Service_Skip_Last_Checkbox);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		Step_End(5, "Click on skip to last check box  and click next button ", test, test1);

		Step_Start(6, "Click confirm button ", test, test1);

		waitForElement(driver, Confirm_Button_EDI_Creation);
		click(driver, Confirm_Button_EDI_Creation);

		waitForPopup(driver, popup_Message, EDI_Updated_Popup);
		String Act_Popup = getText(driver, popup_Message);
		if (EDI_Updated_Popup.equals(Act_Popup)) {
			System.out.println("Popup Matched ||  Expected popup message should be : " + EDI_Updated_Popup
					+ " || Actual popup message is display : " + Act_Popup);
			Extent_pass_New(driver, "Popup Matched ||  Expected popup message  should be : " + EDI_Updated_Popup
					+ " || Actual popup message is display : " + Act_Popup, test, test1);
		} else {
			System.out.println("Popup Not Matched ||  Expected popup message should be : " + EDI_Updated_Popup
					+ " || Actual popup message is Not display : " + Act_Popup);
			Extent_fail(driver, "Popup Not Matched ||  Expected popup message should be: " + EDI_Updated_Popup
					+ " || Actual popup message is Not display : " + Act_Popup, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(6, "Click confirm button\r\n" + "", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}