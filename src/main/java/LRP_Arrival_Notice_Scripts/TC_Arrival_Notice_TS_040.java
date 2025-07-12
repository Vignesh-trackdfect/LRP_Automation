package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_040 extends Keywords{
	
	public void Arrival_Notice_TS_040(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		String tc_Name="TC_Arrival_Notice_TS_040";
		
		
		

		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String agencyUser =Excel_data.get("AgencyUser");
		String agencyConfigurationModule=Excel_data.get("AgencyConfigurationModule");
		String Attribute_Search=Excel_data.get("Attribute_Search");
		String Agency_Code_search=Excel_data.get("Agency_Code_search");
		String condition_Filter=Excel_data.get("condition_Filter");
		String Attribute=Excel_data.get("Attribute");
		String description_Data=Excel_data.get("Description_Data");
		String value=Excel_data.get("value");
		String agency_Select =Excel_data.get("Agency_Select");
		String ImportDocumentationModule=Excel_data.get("ImportDocumentationModule");
		String dropdownCondition1=Excel_data.get("dropdownCondition1");
		String Search_Number=Excel_data.get("Search_Number");
		String bl_Number =Excel_data.get("Bl_Number");
		String BL_Type_Expected=Excel_data.get("BL_Type");
		String arrival_Module_Search =Excel_data.get("Arrival_Module_Search");
		String discharge_Service_Data =Excel_data.get("Discharge_Service_Data");
		String service_data =Excel_data.get("Service_data");
		String vessel =Excel_data.get("Vessel");
		String voyage =Excel_data.get("Voyage");
		String saved_Popup_Expected=Excel_data.get("saved_Popup_Expected");
		String Delete_Perform=Excel_data.get("Delete_Perform");
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);


		LRP_Login(driver, username, password);


		//	Switch the Profile
		Extent_call(test, test1,"**Switch the Profile Start**");


		SwitchProfile(driver, agencyUser);

		Step_Start(1, "Open Agency configuration screen", test, test1);

		setAgencyConfiguration(driver, agencyConfigurationModule, Agency_Code_search, Attribute_Search, condition_Filter, agency_Select, Attribute, description_Data, value);
		
		
		
		
		Step_End(1, "Open Agency configuration screen", test, test1);




		moduleNavigate(driver, ImportDocumentationModule);

		
		click(driver, SearchButton_Toolbar);
		waitForElement(driver, SearchButton_Toolbar );
		
		
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "","", "","");
		
		
		waitForPopup(driver, bl_Type, BL_Type_Expected); 
		String bl_Type_Actual = getText(driver, bl_Type);
		
		if(bl_Type_Actual.equals(BL_Type_Expected)) {
			
			System.out.println("Matched || Expected bl type is : "+BL_Type_Expected+" Actual bl type is : "+bl_Type_Actual);
			Extent_pass(driver, "Matched || Expected bl type is : "+BL_Type_Expected+" Actual bl type is : "+bl_Type_Actual, test, test1);
		}else {
			System.out.println("Not Matched || Expected bl type is : "+BL_Type_Expected+" Actual bl type is : "+bl_Type_Actual);
			Extent_fail(driver, "Not Matched || Expected bl type is : "+BL_Type_Expected+" Actual bl type is : "+bl_Type_Actual, test, test1);
			
		}
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Step_Start(4, "Open 'Arrival Notice / Freight Memo' notice", test, test1);


		
		moduleNavigate(driver, arrival_Module_Search);

	
		Step_End(4, "Open 'Arrival Notice / Freight Memo' notice", test, test1);

		Step_Start(5, "Click new and pass the part BL number", test, test1);
	newButton(driver);
		waitForElement(driver, by_Vessel_AN);
		click(driver, by_Vessel_AN);
		
		waitForElement(driver, discharge_Srvce_Txtfld_AN);
		sendKeys(driver, discharge_Srvce_Txtfld_AN, discharge_Service_Data);
		waitForElement(driver, overlay_Box);
		sendKeys(driver, overlay_Service_Code_Txtfield, service_data);
		sendKeys(driver, overlay_Vessel_Code_Txtfield, vessel);
		sendKeys(driver, overlay_Voyage_Code_Txtfield, voyage);
		waitForElement(driver, Overlay_panel_First_Click);
		click(driver, Overlay_panel_First_Click);
		waitForElement(driver, Vessel_Select_Btn);
		click(driver, Vessel_Select_Btn);
		
		
		Step_End(5, "Click new and pass the part BL number", test, test1);
	
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		
		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		waitForElement(driver, condition_Filter_AN);
		click(driver, condition_Filter_AN);
		waitForElement(driver, bl_Number_Input);
		sendKeys(driver, bl_Number_Input,bl_Number );
		
		Step_Start(6, "Select the record then Click edit", test, test1);
		String click_checkbox_By_Bl_Num=String.format(Arrival_Notice_Locators.click_checkbox_By_Bl_Num, bl_Number);
		waitForElement(driver, click_checkbox_By_Bl_Num);
		click(driver, click_checkbox_By_Bl_Num);
		
		
		scrollTop(driver);

		click(driver, Edit_Button_toolBar);
		Step_End(6, "Select the record then Click edit", test, test1);

		Step_Start(7, "Select the records and Click save button", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		Step_End(7, "Select the records and Click save button", test, test1);
		

Step_Start(8, "Ensure system validated as arrival notice saved", test, test1);


waitForPopup(driver, Popup_Message, saved_Popup_Expected); 
		String actual_Saved_Popup = getText(driver, Popup_Message);
		
		if(actual_Saved_Popup.equals(saved_Popup_Expected)) {
			
			System.out.println("Able to save the arrival Notice for partlot bl");
			System.out.println("Matched || Expected saved popup -> "+saved_Popup_Expected+" Actual saved popup -> "+actual_Saved_Popup);
			Extent_pass(driver, "Matched || Expected saved popup -> "+saved_Popup_Expected+" Actual saved popup -> "+actual_Saved_Popup, test, test1);
			
		}else {
			System.out.println("Can't Able to save the arrival Notice for partlot bl");
			System.out.println("Not Matched ||  Expected saved popup -> "+saved_Popup_Expected +" Actual popup message -> "+ actual_Saved_Popup);
			Extent_fail(driver,"Not Matched ||  Expected saved popup -> "+saved_Popup_Expected +" Actual popup message -> "+ actual_Saved_Popup , test, test1);
			
		}
		
		Step_End(8, "Ensure system validated as arrival notice saved", test, test1);
	
		Step_Start(9, "Click the saved Arrival notice BL and click Delete button", test, test1);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		scrollTop(driver);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(9, "Click the saved Arrival notice BL and click Delete button", test, test1);

		Step_Start(10, "Click Yes and system validates Arrival notice deleted", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		}
		Step_End(10, "Click Yes and system validates Arrival notice deleted", test, test1);

	Extent_completed(tc_Name, test, test1);
		
		
		
		
		
	}

}
