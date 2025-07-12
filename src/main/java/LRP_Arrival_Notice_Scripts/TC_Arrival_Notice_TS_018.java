package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_018 extends Keywords {
	
	public void Arrival_Notice_TS_018(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Arrival_Notice_TS_018";

		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String agencyUser =Excel_data.get("AgencyUser");
		String arrival_Module_Search =Excel_data.get("Arrival_Module_Search");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Search_Number = Excel_data.get("Search_Number");
		String bl_Number =Excel_data.get("Bl_Number");
		String columnHeaders =Excel_data.get("columnHeaders");
		String same_popup =Excel_data.get("same_popup").trim();
		
		
		String click_Checkbox=String.format(Arrival_Notice_Locators.checkbox_Click_With_bl_Num, bl_Number);
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		// Login to the Application

		LRP_Login(driver, username, password);

		Extent_call(test, test1,"**Switch the Profile Start**");

		Step_Start(1, "Select the agency ", test, test1);
		
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Select the agency ", test, test1);

		Step_Start(2, ".Search the module name   \"Arrival Notice / Freight Memo\"  in module search", test, test1);

		
		moduleNavigate(driver, arrival_Module_Search);
		Step_End(2, ".Search the module name   \"Arrival Notice / Freight Memo\"  in module search", test, test1);

		
	newButton(driver);
		waitForElement(driver, by_Bl_Number_Button_AN);
		click(driver, by_Bl_Number_Button_AN);
		waitForElement(driver, BL_Search_button_AN);
		click(driver, BL_Search_button_AN);

		globalValueSearchWindow(driver, BL_Condition, Search_Number, bl_Number, "", "", "", "");
	
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		
		
		reArrangeAG_GridColumnsNew(driver, AN_COLOUM, columnHeaders);
		
		
		waitForElement(driver, consignee_Name_Cell18);
		
		Step_Start(3, "getting the consignee and notify name", test, test1);
		
		String consignee_Name = getText(driver, consignee_Name_Cell18);
		waitForElement(driver, notify_Name_Cell18);
		String notify_Name = getText(driver, notify_Name_Cell18);
		
		Step_End(3, "getting the consignee and notify name", test, test1);

		boolean flag=false;
		
		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		
		waitForElement(driver, reset_Filter);
		click(driver, reset_Filter);
		
		if(consignee_Name.equals(notify_Name)) {
			
			flag=true;
			System.out.println("MATCHED || consignee name -> "+consignee_Name+" notify name -> "+notify_Name);
			Extent_pass(driver, "MATCHED || consignee name -> "+consignee_Name+" notify name -> "+notify_Name, test, test1);
			waitForElement(driver, click_Checkbox);
			click(driver, click_Checkbox);
			
			
			
			waitForElement(driver, consignee_Notice);
			click(driver, consignee_Notice);
			waitForElement(driver, Notify_Notice);
			click(driver, Notify_Notice);
			Step_Start(4, "click mail button", test, test1);
			click(driver, mail_Button_AN);
			Step_End(4, "click mail button", test, test1);

		}else {
			System.out.println("NOT MATCHED || consignee name -> "+consignee_Name+" notify name -> "+notify_Name);

			Extent_fail(driver, "MATCHED || consignee name -> "+consignee_Name+" notify name -> "+notify_Name, test, test1);

			
		}
		
		Step_Start(5, "System validates the message as \" consignee and Notify are same \"", test, test1);
		if (flag) {

			waitForPopup(driver, same_Popup, same_popup);      
			String actual_Popup = getText(driver, same_Popup);
			
			if(actual_Popup.equals(same_popup)) {
				
				System.out.println("MATCHED || EXPECTED POPUP -> "+same_popup+" ACTUAL POPUP -> "+actual_Popup);
				Extent_pass(driver, "MATCHED || EXPECTED POPUP -> "+same_popup+" ACTUAL POPUP -> "+actual_Popup, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED POPUP -> "+same_popup+" ACTUAL POPUP -> "+actual_Popup);
				Extent_fail(driver, "NOT MATCHED || EXPECTED POPUP -> "+same_popup+" ACTUAL POPUP -> "+actual_Popup, test, test1);
				
			}
			
		}
		
		Step_End(5, "System validates the message as ->consignee and Notify are same ", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
	}

}
