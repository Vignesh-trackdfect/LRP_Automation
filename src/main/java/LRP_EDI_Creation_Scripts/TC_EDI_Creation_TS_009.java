package LRP_EDI_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Creation_TS_009 extends Keywords {
	public void EDI_Creation_TS_009(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_EDI_Creation_TS_009";
		
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
		String Column_condition = Excel_data.get("Column_condition");
		String EDI_Updated_Popup = Excel_data.get("EDI_Updated_Popup");
		String EDI_List_Module = Excel_data.get("EDI_List_Module");
		String EDI_List_Grid_Header = Excel_data.get("EDI_List_Grid_Header");
		String Agency_Code_input = Excel_data.get("Agency_Code_input");
		String Profile_Input = Excel_data.get("Profile_Input");
		String Subject_Input = Excel_data.get("Subject_Input");
		String Email_Input = Excel_data.get("Email_Input");
		String UploadBy_Input = Excel_data.get("UploadBy_Input");
		String Updated_Subject_Input = Excel_data.get("Updated_Subject_Input");
		String Updated_UploadBy = Excel_data.get("Updated_UploadBy");
		String UploadBy_Header = Excel_data.get("UploadBy_Header");
		String Updated_Email_id = Excel_data.get("Updated_Email_id");
		
		
		
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

		Step_Start(2, "Click the edit button and click the next button 2time", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);
		
		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);
		
		Step_End(2, "Click the edit button and click the next button 2time", test, test1);
		
		Step_Start(3, "Select any one record from the ag grid", test, test1);
		
		waitForElement(driver, EDI_Email_Main_Filter_Option);
		click(driver,EDI_Email_Main_Filter_Option);
		
		waitForElement(driver, EDI_Agency_Code_Input_Filed);
		sendKeys(driver, EDI_Agency_Code_Input_Filed,Agency_Code_input);
		
		waitForElement(driver, EDI_Local_Profile_Id_Input);
		sendKeys(driver, EDI_Local_Profile_Id_Input,Profile_Input);
		
		waitForElement(driver, EDI_Email_Subject_Input_Field);
		sendKeys(driver, EDI_Email_Subject_Input_Field,Subject_Input);
		
		waitForElement(driver, EDI_Email_Email_input_Filter);
		sendKeys(driver, EDI_Email_Email_input_Filter,Email_Input);
		
		waitForElement(driver, EDI_Local_Upload_By_Input);
		sendKeys(driver, EDI_Local_Upload_By_Input,UploadBy_Input);
		
		waitForElement(driver, EDI_Email_First_row_Grid);
		doubleClick(driver, EDI_Email_First_row_Grid);
		
		
		Step_End(3, "Select any one record from the ag grid", test, test1);
		
		Step_Start(4, "And update the email id and Subject", test, test1);
		
		if(!Updated_Subject_Input.equals("")) {

			waitForElement(driver, EDI_Email_Subject_Input);
			clear(driver,EDI_Email_Subject_Input);
			sendKeys(driver, EDI_Email_Subject_Input, Updated_Subject_Input);
		}
		
		
		if(!Updated_UploadBy.equals("")) {

			waitForElement(driver, EDI_Email_Upload_By_Button);
			click(driver, EDI_Email_Upload_By_Button);
			twoColumnSearchWindow(driver, UploadBy_Header, Column_condition, Updated_UploadBy);
		}
		
		if(!Updated_Email_id.equals("")) {
			waitForElement(driver, EDI_Email_id_Button);
			clear(driver,EDI_Email_id_Button);
			sendKeys(driver, EDI_Email_id_Button,Updated_Email_id);
		}
		
		Step_End(4, "And update the email id and Subject", test, test1);
		
		Step_Start(5, "Click the add button ", test, test1);
		
		waitForElement(driver, EDI_Email_Add_Button);
		click(driver, EDI_Email_Add_Button);
	
		Step_End(5, "Click the add button ", test, test1);	

		Step_Start(6, "Click the skip to last icon and click the next ", test, test1);	
		
		waitForElement(driver, EDI_Email_Skip_To_Lask_Check_Box);
		click(driver, EDI_Email_Skip_To_Lask_Check_Box);
		
		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);
		
		Step_End(6, "Click the skip to last icon and click the next ", test, test1);	
		
		 Step_Start(7, "Click confirm button ",test, test1);
			
			waitForElement(driver, EDI_Partner_Code);
			String Act_Partner =getText(driver, EDI_Partner_Code);
			System.out.println("Act_Partner :"+Act_Partner);
			
			waitForElement(driver, EDI_Name);
			String Act_edi_name =getText(driver, EDI_Name);
			System.out.println("Act_edi_name :"+Act_edi_name);
			
			waitForElement(driver, Confirm_Button_EDI_Creation);
			click(driver, Confirm_Button_EDI_Creation);
			
			waitForPopup(driver, popup_Message, EDI_Updated_Popup);
			String Act_Popup = getText(driver, popup_Message);
			if (EDI_Updated_Popup.equals(Act_Popup)) {
				System.out.println("Popup Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup);
				Extent_pass_New(driver, "Popup Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup, test,
						test1);
			} else {
				System.out.println("Popup Not Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup);
				Extent_fail(driver, "Popup Not Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup,
						test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
			 Step_End(7, "Click confirm button ",test, test1);
			 
			 Step_Start(8, "Check that updated email is shown in the EDI List module in the email column ",test, test1);
		
			 moduleNavigate(driver, EDI_List_Module);
				
				
				waitForElement(driver, EDI_List_Filter_Option);
				click(driver, EDI_List_Filter_Option);
				
				
				reArrangeAG_GridColumns(driver, EDI_List_Grid_Header);
			    
				waitForElement(driver, EDI_List_Partner_Id_Input);
				clear(driver, EDI_List_Partner_Id_Input);
				sendKeys(driver, EDI_List_Partner_Id_Input,Act_Partner);
				
				waitForElement(driver, EDI_List_Edi_Id_Input);
				clear(driver, EDI_List_Edi_Id_Input);
				sendKeys(driver, EDI_List_Edi_Id_Input,EDI_Filter_Value1);
				
				
				waitForElement(driver, EDI_Email_Partner_Subject_Field);
				clear(driver, EDI_Email_Partner_Subject_Field);
				sendKeys(driver, EDI_Email_Partner_Subject_Field,Updated_Subject_Input);
				
			    waitForElement(driver, EDI_List_Partner_E_ID_Input);
			    clear(driver, EDI_List_Partner_E_ID_Input);
			    sendKeys(driver, EDI_List_Partner_E_ID_Input, Updated_Email_id);
				
				 waitForElement(driver, EDI_Email_partner_id_value);
			     String act_mail = getText(driver, EDI_Email_partner_id_value);
			     System.out.println("act_mail"+act_mail);
				
				if(act_mail.equals(Updated_Email_id)) {
					System.out.println("Matched || Expected Partner E-Email Id should be : " + Updated_Email_id + " || Actual Partner E-Email Id is : " + act_mail);
					Extent_pass_New(driver, "Matched || Expected Partner E-Email Id should be : " + Updated_Email_id + " || Actual Partner E-Email Id is : " + act_mail, test, test1);
				}else {
					System.out.println("Not Matched || Expected Partner E-Email Id should be : " + Updated_Email_id + " || Actual Partner E-Email Id is : " + act_mail);
					Extent_fail(driver, "Not Matched || Expected Partner E-Email Id should be : " + Updated_Email_id + " || Actual  Partner E-Email Id is : " + act_mail, test,test1);
					
				}
				
				 waitForElement(driver, EDI_Email_Partner_subject);
			     String act_subject = getText(driver, EDI_Email_Partner_subject);
			   
			 	if(act_subject.equals(Updated_Subject_Input)) {
					System.out.println("Matched || Expected 'Subject' should be : " + Updated_Subject_Input + " || Actual 'Subject' is : " + act_subject);
					Extent_pass_New(driver, "Matched || Expected 'Subject' should be : " + Updated_Subject_Input + " || Actual 'Subject' is : " + act_subject, test, test1);
				}else {
					System.out.println("Not Matched || Expected 'Subject' should be : " + Updated_Subject_Input + " || Actual 'Subject' is : " + act_subject);
					Extent_fail(driver, "Not Matched || Expected 'Subject' should be : " + Updated_Subject_Input + " || Actual  'Subject' is : " + act_subject, test,test1);
					
				}  
			Step_End(8, "Check that updated email is shown in the EDI List module in the email column ",test, test1);
			 	
			 Extent_completed(testcase_Name, test, test1);
			 
			 	
}
}