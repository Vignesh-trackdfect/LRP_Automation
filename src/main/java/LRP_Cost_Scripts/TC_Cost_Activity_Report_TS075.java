package LRP_Cost_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS075 extends Keywords{

	public void  Cost_Activity_Report_TS075(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS075";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		
		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		
		String User_Level_Security_Module = Excel_data.get("User_Level_Security_Module");
		String Select_User_Condition = Excel_data.get("Select_User_Condition");
		String Reject_Btn_Name_UserLevel_Table = Excel_data.get("Reject_Btn_Name_UserLevel_Table");
		String Approve_Btn_Name_UserLevel_Table = Excel_data.get("Approve_Btn_Name_UserLevel_Table");
		String User_Level_Updated_Popup = Excel_data.get("User_Level_Updated_Popup");

		String User_Header_Name = Excel_data.get("User_Header_Name");
		String Function_Previllage_Header = Excel_data.get("Function_Previllage_Header");
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
			
		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		
		Step_Start(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		
		Step_Start(3, "Click on the global search option which is available in the tool bar.    ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(3, "Click on the global search option which is available in the tool bar.    ", test, test1);
		
		Step_Start(4, "Check whether it opens a new search window. ", test, test1);
		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button. ", test, test1);
		Step_Start(7, "System will show the CAR No ", test, test1);

		globalValueSearchWindow(driver,CAR_Retrieve_Condition,CAR_Retrieve_Type,CAR_Number_Retrieve,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(7, "System will show the CAR No ", test, test1);
		Step_End(6, "Then click on the search button. ", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_End(4, "Check whether it opens a new search window. ", test, test1);

		Step_Start(8, "Click on the select button. Ensure that the system retrieves the saved CAR ", test, test1);
		waitForElement(driver, CAR_Number_Input_CAR);
		Step_End(8, "Click on the select button. Ensure that the system retrieves the saved CAR ", test, test1);

		Step_Start(9, "Then go to ag grid.  ", test, test1);
		boolean approvedBtn_Present=isdisplayed(driver, MSC_Approve_button_CAR);
		boolean rejectBtn_Present=isdisplayed(driver, MSC_Reject_Button_CAR);
		Step_End(9, "Then go to ag grid.  ", test, test1);
		Step_Start(10, "Check whether the approve and reject option is shown below the activities. If not enter the screen name as \"User level security\" in the module search field ", test, test1);
		moduleNavigate(driver, User_Level_Security_Module);
		Step_End(10, "Check whether the approve and reject option is shown below the activities. If not enter the screen name as \"User level security\" in the module search field ", test, test1);

		Step_Start(11, "Click on the global search option.Enter the required username and click on the select option", test, test1);
		waitForElement(driver, user_Search_button_ULS);
		click(driver,user_Search_button_ULS);
		Step_End(11, "Click on the global search option.Enter the required username and click on the select option", test, test1);

		Step_Start(12, "Ensure that the given username gets retrieved. Click on the edit option", test, test1);
		twoColumnSearchWindow(driver,User_Header_Name,Select_User_Condition,username);
		
		waitForElement(driver, UserName_Input_ULS);
		String userNameSelected=getAttribute(driver, UserName_Input_ULS, "value");
		if(username.equalsIgnoreCase(userNameSelected)) {
			System.out.println("Username Retrived in the User Level Security Matched  ||  Expected  : "+username+"  ||  Actual : "+userNameSelected);
			Extent_pass_New(driver, "Username Retrived in the User Level Security Matched  ||  Expected  : "+username+"  ||  Actual : "+userNameSelected, test, test1);
		}else {
			System.out.println("Username Retrived in the User Level Security Not Matched  ||  Expected  : "+username+"  ||  Actual : "+userNameSelected);
			Extent_fail(driver, "Username Retrived in the User Level Security Not Matched  ||  Expected  : "+username+"  ||  Actual : "+userNameSelected, test, test1);
		}
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		Step_End(12, "Ensure that the given username gets retrieved. Click on the edit option", test, test1);
		
		Step_Start(13, "Enter the module name as cost activity report in search field of the second grid", test, test1);
		waitForElement(driver, Load_Module_button_ULS);
		click(driver,Load_Module_button_ULS);
		
		waitForElement(driver, Activity_Filter_Input_ULS);
		sendKeys(driver, Activity_Filter_Input_ULS, Cost_Activity_Report_Module);
		Step_End(13, "Enter the module name as cost activity report in search field of the second grid", test, test1);

		Step_Start(14, "Select the check box of cost activity report. Next click the add option in the Functional privilege", test, test1);
		waitForElement(driver, Cost_Activity_Report_ULS);
		click(driver,Cost_Activity_Report_ULS);
		Step_End(14, "Select the check box of cost activity report. Next click the add option in the Functional privilege", test, test1);

		String reject_Description=String.format(Table_Description_ULS, Reject_Btn_Name_UserLevel_Table);
		String approve_Description=String.format(Table_Description_ULS, Approve_Btn_Name_UserLevel_Table);
		Step_Start(15, "Select the required privilege code and click the select option", test, test1);
		waitForElement(driver, Cost_Activity_Report_ULS);
		if(rejectBtn_Present) {
			if(isdisplayed(driver, reject_Description)) {
				System.out.println("Expected : "+Reject_Btn_Name_UserLevel_Table+" Should Present in the User Level Security table When Reject button is present in the CAR page ||  Actual : "+Reject_Btn_Name_UserLevel_Table+" is Present in the User Level Security table When Reject button is present in the CAR page" );
				Extent_pass_New(driver, "Expected : "+Reject_Btn_Name_UserLevel_Table+" Should Present in the User Level Security table When Reject button is present in the CAR page ||  Actual : "+Reject_Btn_Name_UserLevel_Table+" is Present in the User Level Security table When Reject button is present in the CAR page" , test, test1);
			}else {
				System.out.println("Expected : "+Reject_Btn_Name_UserLevel_Table+" Should Present in the User Level Security table When Reject button is present in the CAR page ||  Actual : "+Reject_Btn_Name_UserLevel_Table+" is not Present in the User Level Security table When Reject button is present in the CAR page" );
				Extent_fail(driver, "Expected : "+Reject_Btn_Name_UserLevel_Table+" Should Present in the User Level Security table When Reject button is present in the CAR page ||  Actual : "+Reject_Btn_Name_UserLevel_Table+" is not Present in the User Level Security table When Reject button is present in the CAR page" , test, test1);
			}
		}else {
			
			if(isdisplayed(driver, reject_Description)) {
				System.out.println("Expected : "+Reject_Btn_Name_UserLevel_Table+" Should not Present in the User Level Security table When Reject button is not present in the CAR page ||  Actual : "+Reject_Btn_Name_UserLevel_Table+" is Present in the User Level Security table When Reject button is not present in the CAR page" );
				Extent_fail(driver, "Expected : "+Reject_Btn_Name_UserLevel_Table+" Should not Present in the User Level Security table When Reject button is not present in the CAR page ||  Actual : "+Reject_Btn_Name_UserLevel_Table+" is Present in the User Level Security table When Reject button is not present in the CAR page" , test, test1);
			}else {
				System.out.println("Expected : "+Reject_Btn_Name_UserLevel_Table+" Should not Present in the User Level Security table When Reject button is not present in the CAR page ||  Actual : "+Reject_Btn_Name_UserLevel_Table+" is not Present in the User Level Security table When Reject button is not present in the CAR page" );
				Extent_pass_New(driver, "Expected : "+Reject_Btn_Name_UserLevel_Table+" Should not Present in the User Level Security table When Reject button is not present in the CAR page ||  Actual : "+Reject_Btn_Name_UserLevel_Table+" is not Present in the User Level Security table When Reject button is not present in the CAR page" , test, test1);
			}
			
			waitForElement(driver, Description_Add_button_ULS);
			click(driver,Description_Add_button_ULS);
			twoColumnSearchWindow(driver,Function_Previllage_Header,Select_User_Condition,Reject_Btn_Name_UserLevel_Table);			
		}
		
		
		if(approvedBtn_Present) {
			if(isdisplayed(driver, approve_Description)) {
				System.out.println("Expected : "+Approve_Btn_Name_UserLevel_Table+" Should Present in the User Level Security table When Approve button is Present in the CAR page ||  Actual : "+Approve_Btn_Name_UserLevel_Table+" is Present in the User Level Security table When Approve button is present in the CAR page" );
				Extent_pass_New(driver, "Expected : "+Approve_Btn_Name_UserLevel_Table+" Should Present in the User Level Security table When Approve button is Present in the CAR page ||  Actual : "+Approve_Btn_Name_UserLevel_Table+" is Present in the User Level Security table When Approve button is present in the CAR page" , test, test1);
			}else {
				System.out.println("Expected : "+Approve_Btn_Name_UserLevel_Table+" Should Present in the User Level Security table When Approve button is Present in the CAR page ||  Actual : "+Approve_Btn_Name_UserLevel_Table+" is not Present in the User Level Security table When Approve button is present in the CAR page" );
				Extent_fail(driver, "Expected : "+Approve_Btn_Name_UserLevel_Table+" Should Present in the User Level Security table When Approve button is Present in the CAR page ||  Actual : "+Approve_Btn_Name_UserLevel_Table+" is not Present in the User Level Security table When Approve button is present in the CAR page" , test, test1);
			}
		}else {
			if(isdisplayed(driver, approve_Description)) {
				System.out.println("Expected : "+Approve_Btn_Name_UserLevel_Table+" Should not Present in the User Level Security table When Approve button is not Present in the CAR page ||  Actual : "+Approve_Btn_Name_UserLevel_Table+" is Present in the User Level Security table When Approve button is not present in the CAR page" );
				Extent_fail(driver, "Expected : "+Approve_Btn_Name_UserLevel_Table+" Should not Present in the User Level Security table When Approve button is not Present in the CAR page ||  Actual : "+Approve_Btn_Name_UserLevel_Table+" is Present in the User Level Security table When Approve button is not present in the CAR page" , test, test1);
			}else {
				System.out.println("Expected : "+Approve_Btn_Name_UserLevel_Table+" Should not Present in the User Level Security table When Approve button is not Present in the CAR page ||  Actual : "+Approve_Btn_Name_UserLevel_Table+" is not Present in the User Level Security table When Approve button is not present in the CAR page" );
				Extent_pass_New(driver, "Expected : "+Approve_Btn_Name_UserLevel_Table+" Should not Present in the User Level Security table When Approve button is not Present in the CAR page ||  Actual : "+Approve_Btn_Name_UserLevel_Table+" is not Present in the User Level Security table When Approve button is not present in the CAR page" , test, test1);
			}
			
			waitForElement(driver, Description_Add_button_ULS);
			click(driver,Description_Add_button_ULS);
			twoColumnSearchWindow(driver,Function_Previllage_Header,Select_User_Condition,Approve_Btn_Name_UserLevel_Table);		
		}
		Step_End(15, "Select the required privilege code and click the select option", test, test1);
		
		Step_Start(16, "Click the save option in the toolbar. System validates as \"User level security updated\". Click on the ok option.     ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, User_Level_Updated_Popup);
		String Popup_Text_Act=getText(driver, popup_Message);
		
		if(Popup_Text_Act.equals(User_Level_Updated_Popup)) {
			System.out.println("Popup Matched  ||   Expected : "+User_Level_Updated_Popup+"   ||   Actual   : "+Popup_Text_Act);
			Extent_pass_New(driver, "Popup Matched  ||   Expected : "+User_Level_Updated_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected : "+User_Level_Updated_Popup+"   ||   Actual   : "+Popup_Text_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+User_Level_Updated_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		Step_End(16, "Click the save option in the toolbar. System validates as \"User level security updated\". Click on the ok option.     ", test, test1);
		
		Step_Start(17, "Then logout the application and login again and click on switch profile option and select for the required agency.  ", test, test1);
		waitForElement(driver, Logout_Icon);
		click(driver,Logout_Icon);
		
		waitForElement(driver, Logout_Yes_Btn);
		click(driver,Logout_Yes_Btn);
		alertAccept(driver);
		
		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, AgencyUser);
		Step_End(17, "Then logout the application and login again and click on switch profile option and select for the required agency.  ", test, test1);

		Step_Start(18, "Enter the screen name as \"Cost Activity Report\" in module search field. ", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(18, "Enter the screen name as \"Cost Activity Report\" in module search field. ", test, test1);

		Step_Start(19, "Click on the global search option which is available in the tool bar ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(19, "Click on the global search option which is available in the tool bar ", test, test1);
		
		Step_Start(20, "Check whether it opens a new search window. ", test, test1);
		Step_Start(21, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(22, "Then click on the search button ", test, test1);
		Step_Start(23, "System will show the CAR No.  ", test, test1);

		globalValueSearchWindow(driver,CAR_Retrieve_Condition,CAR_Retrieve_Type,CAR_Number_Retrieve,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(23, "System will show the CAR No.  ", test, test1);
		Step_End(22, "Then click on the search button ", test, test1);
		Step_End(21, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_End(20, "Check whether it opens a new search window. ", test, test1);

		Step_Start(24, "Click on the select button. Ensure that the system retrieves the saved CAR ", test, test1);
		waitForElement(driver, CAR_Number_Input_CAR);
		Step_End(24, "Click on the select button. Ensure that the system retrieves the saved CAR ", test, test1);
		
		Step_Start(25, "Ensure that required approve and reject option is shown below the added activities", test, test1);
		VerifyElementDisplayed(driver, MSC_Approve_button_CAR);
		VerifyElementDisplayed(driver, MSC_Reject_Button_CAR);
		Step_End(25, "Ensure that required approve and reject option is shown below the added activities", test, test1);
		
		Extent_completed(tc_Name, test, test1);

	}
	
}
