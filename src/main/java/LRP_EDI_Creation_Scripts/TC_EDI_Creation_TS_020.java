package LRP_EDI_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Creation_TS_020 extends Keywords{

	public void EDI_Creation_TS_020(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_EDI_Creation_TS_020";
		
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
		String Segment_Name_Input = Excel_data.get("Segment_Name_Input");
		String Element_Input = Excel_data.get("Element_Input");
		String Value_Input = Excel_data.get("Value_Input");
		String Sub_Element_Input = Excel_data.get("Sub_Element_Input");
		

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
			
			Step_Start(2, "Click the edit button and click the next button 6 time",test, test1);
			
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
			
			waitForElement(driver, Next_Button_EDI_Creation);
			click(driver, Next_Button_EDI_Creation);
			
			waitForElement(driver, Next_Button_EDI_Creation);
			click(driver, Next_Button_EDI_Creation);
			
			Step_End(2, "Click the edit button and click the next button 6 time",test, test1);
			
			
			Step_Start(3, "Click on the Segment Name and enter the data ",test, test1);
			
			waitForElement(driver, EDI_Segment_Name_Input);
			sendKeys(driver, EDI_Segment_Name_Input, Segment_Name_Input);
			
			Step_End(3, "Click on the Segment Name and enter the data ",test, test1);
			
			
			Step_Start(4, "Click on the Element text field and enter the data ",test, test1);
			
			waitForElement(driver, EDI_Content_Filter_Element_Input);
			sendKeys(driver, EDI_Content_Filter_Element_Input, Element_Input);
			
			waitForElement(driver, EDI_Content_Filter_Sub_Element);
			sendKeys(driver, EDI_Content_Filter_Sub_Element, Sub_Element_Input);
			
			Step_End(4, "Click on the Element text field and enter the data ",test, test1);
			
			Step_Start(5, "Click on the Value text field and enter the data  ",test, test1);
			
			
			waitForElement(driver, EDI_Content_Filter_Value_Input);
			sendKeys(driver, EDI_Content_Filter_Value_Input, Value_Input);
			
			Step_End(5, "Click on the Value text field and enter the data  ",test, test1);
			
			Step_Start(6, ".Select aagency code from the two column search field  ",test, test1);
			
			
			waitForElement(driver, EDI_Content_Filter_Agency_Code);
			click(driver, EDI_Content_Filter_Agency_Code);
			
			waitForElement(driver, EDI_Content_Filter_Agency_Filter);
			click(driver, EDI_Content_Filter_Agency_Filter);
			
			waitForElement(driver, EDI_Content_Filter_input);
			sendKeys(driver, EDI_Content_Filter_input, Agency_Code_input);
			
			waitForElement(driver, EDI_Content_Agancy_Filter_First_Value);
			click(driver, EDI_Content_Agancy_Filter_First_Value);
			
			waitForElement(driver, EDI_Content_Apply_Button);
			click(driver, EDI_Content_Apply_Button);
			
			
			
			waitForElement(driver, EDI_Content_Main_Filter);
			click(driver, EDI_Content_Main_Filter);
			
			
			waitForElement(driver, EDI_Agency_Code_Input_Filed);
			sendKeys(driver, EDI_Agency_Code_Input_Filed,Agency_Code_input);
			
			waitForElement(driver, EDI_Content_Segment_Input);
			sendKeys(driver, EDI_Content_Segment_Input,Segment_Name_Input);
			
			waitForElement(driver, EDI_Content_Value_Input);
			sendKeys(driver, EDI_Content_Value_Input,Value_Input);
			
			
			waitForElement(driver, EDI_Content_Element_Input);
			sendKeys(driver, EDI_Content_Element_Input,Element_Input);
			
			
			
			waitForElement(driver, EDI_Agecy_First_Value);
			String Act_Agency_Value=getText(driver, EDI_Agecy_First_Value);
			
			if(Act_Agency_Value.equals(Agency_Code_input)) {
				 System.out.println("Matched || Expected Result: The given Content Filter 'Agency Code ' : "+Agency_Code_input+" , Segment Name : " +Segment_Name_Input+"  , Value : "+Value_Input+"  and Element Name : "+ Element_Input+" should be created  in the grid || Actual Result: The given Content Filter 'Agency Code ' : "+Agency_Code_input+" , 'Segment Name' : " +Segment_Name_Input+"  , Value : "+Value_Input+"  and Element Name : "+ Element_Input+"  was successfully created in the grid.");			
				 Extent_pass_New(driver, "Matched || Expected Result: The given Content Filter 'Agency Code ' : "+Agency_Code_input+" , Segment Name : " +Segment_Name_Input+"  , Value : "+Value_Input+"  and Element Name : "+ Element_Input+" should be created  in the grid || Actual Result: The given Content Filter 'Agency Code ' : "+Agency_Code_input+" , 'Segment Name' : " +Segment_Name_Input+"  , Value : "+Value_Input+"  and Element Name : "+ Element_Input+"  was successfully created in the grid.", test, test1);
			
			}else {
				
				System.out.println("Not Matched || Expected Result: The given Content Filter 'Agency Code ' : "+Agency_Code_input+" , Segment Name : " +Segment_Name_Input+"  , Value : "+Value_Input+"  and Element Name : "+ Element_Input+" should be created  in the grid || Actual Result: The given Content Filter 'Agency Code ' : "+Agency_Code_input+" , 'Segment Name' : " +Segment_Name_Input+"  , Value : "+Value_Input+"  and Element Name : "+ Element_Input+"  was Not created in the grid.");			
				 Extent_fail(driver, "Not Matched || Expected Result: The given Content Filter 'Agency Code ' : "+Agency_Code_input+" , Segment Name : " +Segment_Name_Input+"  , Value : "+Value_Input+"  and Element Name : "+ Element_Input+" should be created  in the grid || Actual Result: The given Content Filter 'Agency Code ' : "+Agency_Code_input+" , 'Segment Name' : " +Segment_Name_Input+"  , Value : "+Value_Input+"  and Element Name : "+ Element_Input+"  was Not  created in the grid.", test, test1);
		
			}
			
			Step_End(6, ".Select aagency code from the two column search field  ",test, test1);
		
			Step_Start(7, "Click on skip to last check box  and click next button  ",test, test1);
	
			waitForElement(driver, EDI_Content_Skip_To_Last_Checkbox);
			click(driver, EDI_Content_Skip_To_Last_Checkbox);

			waitForElement(driver, Next_Button_EDI_Creation);
			click(driver, Next_Button_EDI_Creation);
			
			Step_End(7, "Click on skip to last check box  and click next button  ",test, test1);
	
			 Step_Start(8, "Click confirm button ", test, test1);

				
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

				Step_End(8, "Click confirm button ", test, test1);
				
				 Extent_completed(testcase_Name, test, test1);	
			
			
}
}