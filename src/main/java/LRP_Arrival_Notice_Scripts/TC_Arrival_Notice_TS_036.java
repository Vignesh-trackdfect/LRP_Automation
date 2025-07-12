package LRP_Arrival_Notice_Scripts;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_036 extends Keywords{
	public void Arrival_Notice_TS_036(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testCaseName = "TC_Arrival_Notice_TS_036";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Search_Number = Excel_data.get("Search_Number");
		String bl_Number = Excel_data.get("bl_Number");
		String Deleted_Popup = Excel_data.get("Deleted_Popup");
		String Delete_Perform=Excel_data.get("Delete_Perform");
		


		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Step_Start(1, "Switch the POD agency ", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Switch the POD agency ", test, test1);

		Step_Start(2, "Open Import documentation screen ", test, test1);

		
		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(2, "Open Import documentation screen ", test, test1);

		Step_Start(3, "Click search button and paste the BL fecth the record", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "","", "","");
		
	
		Step_End(3, "Click search button and paste the BL fecth the record", test, test1);

		Step_Start(4, "Make sure POD and Do issue location should be unique (POD<> DO Issue Location)", test, test1);

	

		scrollTop(driver);
		waitForElement(driver, PODLocationId);
		String POD_Location = getText(driver, PODLocationId);
		waitForElement(driver, ANDo_issue_location_text);
		String Do_issue_Location = getAttribute(driver, ANDo_issue_location_text,"value");
		Step_End(4, "Make sure POD and Do issue location should be unique (POD<> DO Issue Location)", test, test1);

		Step_Start(5, "Navigate Arrival notice from Import documentation screen ", test, test1);

		waitForElement(driver, AN_Arrival_notice_button);
		click(driver, AN_Arrival_notice_button);
		Step_End(5, "Navigate Arrival notice from Import documentation screen ", test, test1);

		Step_Start(6, "Click edit , select the BL and cick save.", test, test1);

		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		click(driver, condition_Filter_AN);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		String Check_Box = String.format(Arrival_Notice_Locators.click_checkbox_By_Bl_Num, bl_Number);
		waitForElement(driver, Check_Box);
		click(driver, Check_Box);
		
		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(6, "Click edit , select the BL and cick save.", test, test1);

		Step_Start(7, "Copy POD from Arrival Notice and match the same with DO Issue Location\r\n"
				+ " No need verify below but script must be there.", test, test1);

		waitForPopup(driver, Popup_Message, Deleted_Popup);    
		String Actual_Saved_Popup = getText(driver, Popup_Message);
		if (Deleted_Popup.trim().equals(Actual_Saved_Popup.trim())) {
			System.out.println("Matched || Expected Popup value should be shown as: " + Deleted_Popup + " || Actual Popup value was : " + Actual_Saved_Popup);
			Extent_pass(driver,"Matched || Expected Popup value should be shown as : " + Deleted_Popup + " || Actual Popup value was : " + Actual_Saved_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Popup value should be shown as : " + Deleted_Popup + " || Actual Popup value was : " + Actual_Saved_Popup);
			Extent_fail(driver,"Not Matched || Expected Popup value should be shown as : " + Deleted_Popup + " || Actual Popup value was : " + Actual_Saved_Popup,test, test1);
		}

		if (!POD_Location.equals(Do_issue_Location)) {
			System.out.println("Not Matched || Tha Actual POD is : " + POD_Location + " || The ActualDO Issue Location is : " + Do_issue_Location+" || POD and DO Issue location is not same");
			Extent_pass(driver,"Not Matched || Tha Actual POD is : " + POD_Location + " || The ActualDO Issue Location is : " + Do_issue_Location+" || POD and DO Issue location is not same", test,test1);
		} else {
			System.out.println("Matched || Tha Actual POD is : " + POD_Location + " || The ActualDO Issue Location is : " + Do_issue_Location+" || POD and DO Issue location is same");
			Extent_fail(driver,"Matched || Tha Actual POD is : " + POD_Location + " || The ActualDO Issue Location is : " + Do_issue_Location+" || POD and DO Issue location is same",test, test1);
		}
		Step_End(7, "Copy POD from Arrival Notice and match the same with DO Issue Location\r\n"
				+ " No need verify below but script must be there.", test, test1);

		Step_Start(8, "Click the saved Arrival notice bl and click Delete button", test, test1);
		
		
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		scrollTop(driver);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(8, "Click the saved Arrival notice bl and click Delete button", test, test1);

		Step_Start(9, "Click Yes and system validates Arrival notice deleted.", test, test1);

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Yes_Button);
		}
		Step_End(9, "Click Yes and system validates Arrival notice deleted.", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}
