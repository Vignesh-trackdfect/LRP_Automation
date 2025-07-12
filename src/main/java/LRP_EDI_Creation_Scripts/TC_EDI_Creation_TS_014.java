package LRP_EDI_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Creation_TS_014  extends Keywords{
	public void EDI_Creation_TS_014(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_EDI_Creation_TS_014";
		
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
		String Profile_Input = Excel_data.get("Profile_Input");
		String UploadBy_Input = Excel_data.get("UploadBy_Input");
		String Profile_Name_header = Excel_data.get("Profile_Name_header");
		String Column_condition = Excel_data.get("Column_condition");
		String UploadBy_Header = Excel_data.get("UploadBy_Header");
		String Sharepath_Input = Excel_data.get("Sharepath_Input");
		String Status_Value = Excel_data.get("Status_Value");
		
		
		
		 Extent_Start(testcase_Name, test, test1);
			
			navigateUrl(driver, url);
			LRP_Login(driver, Username, Password);
			
			verifyMainMenu(driver);

			SwitchProfile(driver, AgencyUser);
			moduleNavigate(driver, EDI_Creation_Module);

			Step_Start(1, "Retreive a record from global search by using edi id  ",test, test1);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, EDI_Filter_Condition, EDI_Filter_Type1, EDI_Filter_Value1, EDI_Filter_Type2,EDI_Filter_Value2, EDI_Filter_Type3, EDI_Filter_Value3);
			
			Step_End(1, "Retreive a record from global search by using edi id  ",test, test1);
			
			Step_Start(2, "Click the edit button and click the next button 4 time",test, test1);
			
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
			
			Step_End(2, "Click the edit button and click the next button 4 time",test, test1);
			
			Step_Start(3, "Click on the profile ID search button and select Upload By search button from the two column search field",test, test1);
			waitForElement(driver, EDI_Web_Service_Status);
			click(driver, EDI_Web_Service_Status);
			
			formatLocatorClick(driver, EDI_Web_Service_Dropdown_Option, Status_Value);
			
			waitForElement(driver, EDI_Web_Service_Profile_id);
			click(driver, EDI_Web_Service_Profile_id);
			
			twoColumnSearchWindow(driver, Profile_Name_header, Column_condition, Profile_Input);
			
			waitForElement(driver, EDI_Web_Service_Profile_Upload_Id);
			click(driver, EDI_Web_Service_Profile_Upload_Id);
			
			twoColumnSearchWindow(driver, UploadBy_Header, Column_condition, UploadBy_Input);
			
			Step_End(3, "Click on the profile ID search button and select Upload By search button from the two column search field",test, test1);
		
			Step_Start(4, "Enter the \"/\" on the share path text field ",test, test1);
			
			waitForElement(driver, EDI_Web_Service_Profile_Sharepath);
			sendKeys(driver, EDI_Web_Service_Profile_Sharepath, Sharepath_Input);
			
			Step_End(4, "Enter the \"/\" on the share path text field ",test, test1);	
			
			Step_Start(5, "Select the agency code in the two cloumn search field   ",test, test1);	
			
			waitForElement(driver, EDI_Web_Service_Agency_Code);
			click(driver, EDI_Web_Service_Agency_Code);
			
			
			waitForElement(driver, EDI_Web_Service_Agency_Code_Filter);
			click(driver, EDI_Web_Service_Agency_Code_Filter);
			
			waitForElement(driver, EDI_Web_Service_Agency_Code_Input_Filter);
			sendKeys(driver, EDI_Web_Service_Agency_Code_Input_Filter,Agency_Code_input);
		
			
			waitForElement(driver, EDI_Web_Service_Agency_Code_CheckBxo_Option);
			click(driver, EDI_Web_Service_Agency_Code_CheckBxo_Option);
			
			waitForElement(driver, EDI_Web_Service_Agency_Code_Apply_Button);
			click(driver, EDI_Web_Service_Agency_Code_Apply_Button);
			
		
			
			waitForElement(driver, EDI_Web_Service_Main_Filter_Grid);
			click(driver, EDI_Web_Service_Main_Filter_Grid);
		
			
		     waitForElement(driver, EDI_Agency_Code_Input_Filed);
			 sendKeys(driver, EDI_Agency_Code_Input_Filed,Agency_Code_input);
			
			  waitForElement(driver, EDI_Local_Profile_Id_Input);
			  sendKeys(driver, EDI_Local_Profile_Id_Input,Profile_Input);
			  
			  waitForElement(driver, EDI_Web_Service_Sharepath_Input);
			  sendKeys(driver, EDI_Web_Service_Sharepath_Input,Sharepath_Input);
			  
			  
			  waitForElement(driver, EDI_Local_Upload_By_Input);
			  sendKeys(driver, EDI_Local_Upload_By_Input,UploadBy_Input);
			  
			  
			  waitForElement(driver, EDI_Agecy_First_Value);
			  String Act_Agency_Value=getText(driver, EDI_Agecy_First_Value);
			  
			  
			  waitForElement(driver, EDI_Web_Setvice_Profile_Id_value);
			  String Act_Profile_id=getText(driver, EDI_Web_Setvice_Profile_Id_value);
			  
			  waitForElement(driver, EDI_Web_Service_Sharepath_Input_Value);
			  String Act_Sharepath=getText(driver, EDI_Web_Service_Sharepath_Input_Value);
			  
			  if(Act_Agency_Value.equals(Agency_Code_input)) {		
					System.out.println("Matched || Expected Result: The given local 'Agency code' should be created : "+Act_Agency_Value+" in the grid || Actual Result: The given local 'Agency code' was successfully created : "+Agency_Code_input +"in the grid.");			
					 Extent_pass_New(driver, "Matched || Expected Result: The given local 'Agency code' should be created : "+Act_Agency_Value+" in the grid || Actual Result: The given local 'Agency code' was successfully created : "+Agency_Code_input +"in the grid.", test, test1);
			  }else {
				  System.out.println("Matched || Expected Result: The given local 'Agency code' should be created : "+Act_Agency_Value+" in the grid || Actual Result: The given local 'Agency code' was successfully created : "+Agency_Code_input +"in the grid.");			
					 Extent_fail(driver, "Matched || Expected Result: The given local 'Agency code' should be created : "+Act_Agency_Value+" in the grid || Actual Result: The given local 'Agency code' was successfully created : "+Agency_Code_input +"in the grid.", test, test1);  
			  }
			  

			  if(Act_Profile_id.equals(Profile_Input)) {		
					System.out.println("Matched || Expected Result: The given local 'Profile id ' should be created : "+Profile_Input+" in the grid || Actual Result: The given local 'Profile id' was successfully created : "+Act_Profile_id +"in the grid.");			
					 Extent_pass_New(driver, "Matched || Expected Result: The given local 'Profile id' should be created : "+Profile_Input+" in the grid || Actual Result: The given local 'Profile id' was successfully created : "+Act_Profile_id +"in the grid.", test, test1);
			  }else {
				  System.out.println("Matched || Expected Result: The given local 'Profile id' should be created : "+Profile_Input+" in the grid || Actual Result: The given local 'Profile id' was successfully created : "+Act_Profile_id +"in the grid.");			
					 Extent_fail(driver, "Matched || Expected Result: The given local 'Profile id' should be created : "+Profile_Input+" in the grid || Actual Result: The given local 'Profile id' was successfully created : "+Act_Profile_id +"in the grid.", test, test1);  
			  }
			  
			  if(Act_Sharepath.equals(Sharepath_Input)) {		
					System.out.println("Matched || Expected Result: The given local 'Share path ' should be created : "+Sharepath_Input+" in the grid || Actual Result: The given local 'Share path' was successfully created : "+Act_Sharepath +"in the grid.");			
					 Extent_pass_New(driver, "Matched || Expected Result: The given local 'Share path' should be created : "+Sharepath_Input+" in the grid || Actual Result: The given local 'Share path' was successfully created : "+Act_Sharepath +"in the grid.", test, test1);
			  }else {
				  System.out.println("Matched || Expected Result: The given local 'Share path' should be created : "+Sharepath_Input+" in the grid || Actual Result: The given local 'Share path' was successfully created : "+Act_Sharepath +"in the grid.");			
					 Extent_fail(driver, "Matched || Expected Result: The given local 'Share path' should be created : "+Sharepath_Input+" in the grid || Actual Result: The given local 'Share path' was successfully created : "+Act_Sharepath +"in the grid.", test, test1);  
			  }
			  
			  
			
			Step_End(5, "Select the agency code in the two cloumn search field   ",test, test1);		
			
			Step_Start(6, "Click on skip to last check box  and click next button  ",test, test1);	
			
			waitForElement(driver, EDI_Web_Service_Skip_Last_Checkbox);
			click(driver, EDI_Web_Service_Skip_Last_Checkbox);

			waitForElement(driver, Next_Button_EDI_Creation);
			click(driver, Next_Button_EDI_Creation);
		
			
			Step_End(6, "Click on skip to last check box  and click next button  ",test, test1);
			
	        Step_Start(7, "Click confirm button ", test, test1);

			
			waitForElement(driver, Confirm_Button_EDI_Creation);
			click(driver, Confirm_Button_EDI_Creation);

			waitForPopup(driver, popup_Message, EDI_Updated_Popup);
			String Act_Popup = getText(driver, popup_Message);
			if (EDI_Updated_Popup.equals(Act_Popup)) {
				System.out.println("Popup Matched ||  Expected popup message should be : " + EDI_Updated_Popup + " || Actual popup message is display : " + Act_Popup);
				Extent_pass_New(driver, "Popup Matched ||  Expected popup message  should be : " + EDI_Updated_Popup + " || Actual popup message is display : " + Act_Popup,
						test, test1);
			} else {
				System.out.println("Popup Not Matched ||  Expected popup message should be : " + EDI_Updated_Popup + " || Actual popup message is Not display : " + Act_Popup);
				Extent_fail(driver, "Popup Not Matched ||  Expected popup message should be: " + EDI_Updated_Popup + " || Actual popup message is Not display : " + Act_Popup,
						test, test1);
			} 

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(7, "Click confirm button ", test, test1);
			
			 Extent_completed(testcase_Name, test, test1);		
			
			
			
}
}