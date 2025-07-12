package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_003  extends Keywords {

	public void Arrival_Notice_TS_003(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Arrival_Notice_TS_003";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ArrivalNotice_Module = Excel_data.get("ArrivalNotice_Module");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Search_Number = Excel_data.get("Search_Number");
		String BL_Num = Excel_data.get("BL_Num");
		String ArrivalNotice_Saved_Popup = Excel_data.get("ArrivalNotice_Saved_Popup");
		String Saved_Record_Colour = Excel_data.get("Saved_Record_Colour");
		String Delete_Perform = Excel_data.get("Delete_Perform");
	
		
		

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		
		Step_Start(1, "Switch agency and open Arrival Notice / Freight Memo Module", test, test1);
		SwitchProfile(driver, AgencyUser);


		moduleNavigate(driver, ArrivalNotice_Module);

		Step_End(1, "Switch agency and open Arrival Notice / Freight Memo Module", test, test1);

		Step_Start(2, "Click on New Button", test, test1);
		newButton(driver);
		Step_End(2, "Click on New Button", test, test1);
		Step_Start(3, "Click BL number option", test, test1);
		waitForElement(driver, by_Bl_Number_Button_AN);
		click(driver, by_Bl_Number_Button_AN);

		waitForElement(driver, BL_Search_button_AN);
		click(driver, BL_Search_button_AN);


		Step_End(3, "Click BL number option", test, test1);
		Step_Start(4, "paste the Bl", test, test1);
		globalValueSearchWindow(driver, BL_Condition, Search_Number, BL_Num, "", "", "", "");
		
	
		
		Step_End(4, "paste the Bl", test, test1);

		Step_Start(5, "click Show and click on Edit from toolbar", test, test1);
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);


        scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);		
		Step_End(5, "click Show and click on Edit from toolbar", test, test1);

		Step_Start(6, "Select the record and click save button", test, test1);
		String select_Record_AN=String.format(Arrival_Notice_Locators.select_Record_AN, BL_Num);
		waitForElement(driver, select_Record_AN);
		click(driver, select_Record_AN);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForPopup(driver, Popup_Message, ArrivalNotice_Saved_Popup);
		String Saved_Popup=getText(driver, Popup_Message);
		System.out.println(Saved_Popup);
		if(ArrivalNotice_Saved_Popup.equals(Saved_Popup)) {
			System.out.println("Matched || Arrival Notice saved Expected Popup : " + ArrivalNotice_Saved_Popup + " || Arrival Notice saved Actual Popup : " + Saved_Popup);
			Extent_pass(driver, "Matched ||Arrival Notice saved Expected Popup : " + ArrivalNotice_Saved_Popup + " || Arrival Notice saved Actual Popup : " + Saved_Popup, test,
					test1);

		} else {
			System.out.println("NotMatched || Arrival Notice saved Expected Popup : " + ArrivalNotice_Saved_Popup + " || Arrival Notice saved Actual Popup : " + Saved_Popup);
			Extent_fail(driver, "NotMatched ||Arrival Notice saved Expected Popup : " + ArrivalNotice_Saved_Popup + " || Arrival Notice saved Actual Popup : " + Saved_Popup,
					test, test1);
		}	

		Step_End(6, "Select the record and click save button", test, test1);

		String Arrival_Notice_No=String.format(Arrival_Notice_Locators.arrival_Notice_Generated_No_AN, BL_Num);

		String Arrival_Notice_Number=getText(driver, Arrival_Notice_No);
		System.out.println("Arrival Notice Number:"+Arrival_Notice_Number);
		click(driver, Arrival_Notice_No);
		waitForElement(driver, Bl_Records_Background_Colour_AN);
		String Records_Background_Colour=getTextBackgroundColor(driver, Bl_Records_Background_Colour_AN);
		String Records_Background_Colour_exp=getColorName(Records_Background_Colour);
		if(Saved_Record_Colour.equals(Records_Background_Colour_exp)) {
			System.out.println("Matched || Background colour Expected  : " + Saved_Record_Colour + " || Background colour Actual : " + Records_Background_Colour_exp);
			Extent_pass(driver, "Matched ||Background colour Expected : " + Saved_Record_Colour + " || Background colour Actual : " + Records_Background_Colour_exp, test,test1);
		} else {
			System.out.println("NotMatched || Background colour Expected : " + Saved_Record_Colour + " || Background colour Actual : " + Records_Background_Colour_exp);
			Extent_fail(driver, "NotMatched ||Background colour Expected : " + Saved_Record_Colour + " || Background colour Actual : " + Records_Background_Colour_exp,test, test1);
		}	 

		Step_Start(7, "Click the saved Arrival notice bl and click Delete button", test, test1);
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(7, "Click the saved Arrival notice bl and click Delete button", test, test1);
		Step_Start(8, "Click Yes and system validates Arrival notice deleted", test, test1);
		click(driver, popup_Message_Yes_Button);
       Step_End(8, "Click Yes and system validates Arrival notice deleted", test, test1);
		Extent_completed(testcase_Name, test, test1);
		}
	}
}