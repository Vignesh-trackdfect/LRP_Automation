package LRP_EDI_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Creation_TS_006 extends Keywords {
	public void EDI_Creation_TS_006(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_EDI_Creation_TS_006";

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
		String Profile_Name_header = Excel_data.get("Profile_Name_header");
		String Column_condition = Excel_data.get("Column_condition");
		String Directory_Input = Excel_data.get("Directory_Input");
		String EDI_Updated_Popup = Excel_data.get("EDI_Updated_Popup");
		String EDI_List_Module = Excel_data.get("EDI_List_Module");
		String Updated_Directory_Input = Excel_data.get("Updated_Directory_Input");
		String Updated_Profile_Input = Excel_data.get("Updated_Profile_Input");
		String Updated_Agency_Code_input = Excel_data.get("Updated_Agency_Code_input");
		String EDI_List_Grid_Header = Excel_data.get("EDI_List_Grid_Header");
		

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

		Step_Start(2, "Click the edit button and click the next button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		Step_End(2, "Click the edit button and click the next button", test, test1);

		Step_Start(3, "Click on the profile ID search button and enter the \"/test\" on the directory field ", test,
				test1);
		Step_Start(4, "And change the agency code from the two column search field", test, test1);
		
		waitForElement(driver, EDU_FTP_SFTP_Filter_Option);
		click(driver, EDU_FTP_SFTP_Filter_Option);

		waitForElement(driver, EDI_FTP_SFTP_Directory_Input_Field);
		sendKeys(driver, EDI_FTP_SFTP_Directory_Input_Field, Directory_Input);

		waitForElement(driver, EDI_FTP_SFTP_First_Now);
		doubleClick(driver, EDI_FTP_SFTP_First_Now);

		
		if(!Updated_Directory_Input.equals("")) {

			waitForElement(driver, EDI_Directory_Input);
			clear(driver, EDI_Directory_Input);
			sendKeys(driver, EDI_Directory_Input, Updated_Directory_Input);
		}
		
		if(!Updated_Profile_Input.equals("")) {
			waitForElement(driver, EDI_Profile_Id_Button);
			click(driver, EDI_Profile_Id_Button);
			twoColumnSearchWindow(driver, Profile_Name_header, Column_condition, Updated_Profile_Input);
		}
		
		
		if(!Updated_Agency_Code_input.equals("")) {
			waitForElement(driver, EDI_Agency_Code);
			click(driver, EDI_Agency_Code);
			
			waitForElement(driver, EDI_Agency_Filter_option);
			click(driver, EDI_Agency_Filter_option);
			
			waitForElement(driver, EDI_Agency_Code_Input_Filed);
			sendKeys(driver, EDI_Agency_Code_Input_Filed,Updated_Agency_Code_input);
			
			waitForElement(driver, EDI_Agency_Checkbox);
			click(driver, EDI_Agency_Checkbox);
			
			waitForElement(driver, EDI_Agency_Apply_Button);
			click(driver, EDI_Agency_Apply_Button);
		}
		
		

		waitForElement(driver, EDI_FTP_SFTP_Add_Button);
		click(driver, EDI_FTP_SFTP_Add_Button);
		
		Step_End(4, "And change the agency code from the two column search field", test, test1);
		Step_End(3,"Click on the profile ID search button and select upload by field and enter the \"/\" on the directory field",test, test1);

		Step_Start(5, ".Click on skip to last check box  and click next button  ", test, test1);

		waitForElement(driver, EDI_Skip_Last_CheckBox);
		click(driver, EDI_Skip_Last_CheckBox);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		Step_End(5, ".Click on skip to last check box  and click next button  ", test, test1);

		Step_Start(6, "Click confirm button ", test, test1);

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

		Step_End(6, "Click confirm button ", test, test1);

		Step_Start(7, " Check that updated FTP Directory is shown in the EDI List module in the FTP Directory column",
				test, test1);
		moduleNavigate(driver, EDI_List_Module);

		waitForElement(driver, EDI_List_Filter_Option);
		click(driver, EDI_List_Filter_Option);
		
		 reArrangeAG_GridColumns_Expense_Report(driver, EDI_List_Grid_Header);

		waitForElement(driver, EDI_List_Partner_Id_Input);
		clear(driver, EDI_List_Partner_Id_Input);
		sendKeys(driver, EDI_List_Partner_Id_Input, Act_Partner);

		waitForElement(driver, EDI_List_Edi_Id_Input);
		clear(driver, EDI_List_Edi_Id_Input);
		sendKeys(driver, EDI_List_Edi_Id_Input, EDI_Filter_Value1);


		waitForElement(driver, EDI_List_FTP_Directory_input);
		clear(driver, EDI_List_FTP_Directory_input);
		sendKeys(driver, EDI_List_FTP_Directory_input, Updated_Directory_Input);

		waitForElement(driver, EDI_List_FTP_Value);
		String act_Directory = getText(driver, EDI_List_FTP_Value);
		System.out.println("act_Directory" + act_Directory);

		if (Updated_Directory_Input.equals(act_Directory)) {
			System.out
					.println("Matched ||  Expected result : Given Partener Id,EDI id,FTP Directory should be updated  "
							+ Updated_Directory_Input
							+ "in the grid || Actual result : Given Partener Id,EDI id,FTP Directory  updated in the grid"
							+ act_Directory);
			Extent_pass_New(driver,
					"Matched || Expected result : Given Partener Id,EDI id,FTP Directory should be updated  "
							+ Updated_Directory_Input
							+ "in the grid || Actual result : Given Partener Id,EDI id,FTP Directory  updated in the grid"
							+ act_Directory,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected result : Given Partener Id,EDI id,FTP Directory should be updated  "
							+ Updated_Directory_Input
							+ "in the grid || Actual result : Given Partener Id,EDI id,FTP Directory Not  updated in the grid"
							+ act_Directory);
			Extent_fail(driver,
					"Not Matched ||  Expected result : Given Partener Id,EDI id,FTP Directory should be updated  "
							+ Updated_Directory_Input
							+ "in the grid || Actual result : Given Partener Id,EDI id,FTP Directory Not  updated in the grid"
							+ act_Directory,
					test, test1);

		}

		Step_End(7, " Check that updated FTP Directory is shown in the EDI List module in the FTP Directory column",
				test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}