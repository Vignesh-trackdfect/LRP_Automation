package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_041 extends Keywords {

	
	public void Arrival_Notice_TS_041(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		

		String tc_Name="TC_Arrival_Notice_TS_041";
		
		
		

		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String agencyUser =Excel_data.get("AgencyUser");
		String agencyConfigurationModule=Excel_data.get("AgencyConfigurationModule");
		String Attribute_Search=Excel_data.get("Attribute_Search");
		String Agency_Code_search=Excel_data.get("Agency_Code_search");
		String condition_Filter=Excel_data.get("condition_Filter");
		String agency_Select =Excel_data.get("Agency_Select");
		String Attribute=Excel_data.get("Attribute");
		String description_Data=Excel_data.get("Description_Data");
		String value=Excel_data.get("value");
		String ImportDocumentationModule=Excel_data.get("ImportDocumentationModule");
		String dropdownCondition1=Excel_data.get("dropdownCondition1");
		String Search_Number=Excel_data.get("Search_Number");
		String bl_Number =Excel_data.get("Bl_Number");
		String arrival_Module_Search =Excel_data.get("Arrival_Module_Search");
		String Search_Number1=Excel_data.get("Search_Number1");
		String BL_Type_Expected=Excel_data.get("BL_Type");
		String expected_No_Record_Notification=Excel_data.get("Expected_No_Record_Notification");
		

		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);


		LRP_Login(driver, username, password);

		//	Switch the Profile
		Extent_call(test, test1,"**Switch the Profile Start**");

		Step_Start(1, " Switch the agency ", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, " Switch the agency ", test, test1);

		setAgencyConfiguration(driver, agencyConfigurationModule, Agency_Code_search, Attribute_Search, condition_Filter, agency_Select, Attribute, description_Data, value);
		
		


		Step_End(2, "Open the Agency Configuration Module.", test, test1);


		

		moduleNavigate(driver, ImportDocumentationModule);
		waitForElement(driver, SearchButton_Toolbar );
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "","", "","");
		
	
		waitForElement(driver, bl_Type); 
		String bl_Type_Actual = getText(driver, bl_Type);
		
		if(bl_Type_Actual.equals(BL_Type_Expected)) {
			
			System.out.println("Matched || Expected bl type is : "+BL_Type_Expected+" Actual bl type is : "+bl_Type_Actual);
			Extent_pass(driver, "Matched || Expected bl type is : "+BL_Type_Expected+" Actual bl type is : "+bl_Type_Actual, test, test1);
		}else {
			System.out.println("Not Matched || Expected bl type is : "+BL_Type_Expected+" Actual bl type is : "+bl_Type_Actual);
			Extent_fail(driver, "Not Matched || Expected bl type is : "+BL_Type_Expected+" Actual bl type is : "+bl_Type_Actual, test, test1);
			
		}
		scrollTop(driver);

		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		

		moduleNavigate(driver, arrival_Module_Search);

		
		newButton(driver);
		waitForElement(driver, BL_Search_button_AN);
		click(driver, BL_Search_button_AN);
		
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number1, bl_Number, "","", "","");
		
		
		
		
		
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		
		Extent_call(test, test1, "No records popup validation");
		waitForPopup(driver, Popup_Message, expected_No_Record_Notification); 
		String actual_No_Record_Popup = getText(driver, Popup_Message);

		if (actual_No_Record_Popup.equalsIgnoreCase(expected_No_Record_Notification)) {

			Extent_pass(driver, "Matched || Expected no records noti after delete -> " + expected_No_Record_Notification
					+ " Actual no records  noti after delete -> " + actual_No_Record_Popup, test, test1);
			System.out.println("Matched || Expected no records  noti after delete -> " + expected_No_Record_Notification
					+ " Actual no records noti after delete -> " + actual_No_Record_Popup);
		} else {
			
			System.out.println(
					"Not Matched || Expected no records noti after delete -> " + expected_No_Record_Notification
							+ " Actual no records noti after delete -> " + actual_No_Record_Popup);
			Extent_fail(driver,
					"Not Matched || Expected no records noti after delete -> " + expected_No_Record_Notification
							+ " Actual no records noti after delete -> " + actual_No_Record_Popup,
					test, test1);
			

		}
		
		Extent_completed(tc_Name, test, test1);

		
	}
	
	
}
