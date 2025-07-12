package LRP_Arrival_Notice_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_035 extends Keywords{
	public void Arrival_Notice_TS_035(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testCaseName = "TC_Arrival_Notice_TS_035";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String bl_Number = Excel_data.get("bl_Number");
		String confirmation_Popup = Excel_data.get("confirmation_Popup");
		String Deleted_Popup = Excel_data.get("Deleted_Popup");
	
				
		
		
		

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Step_Start(1, "Select the transhipment agency ", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Select the transhipment agency ", test, test1);

		Step_Start(2, "Search the module name ( \"Arrival Notice / Freight Memo\" ) in module search", test, test1);


		
		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(2, "Search the module name ( \"Arrival Notice / Freight Memo\" ) in module search", test, test1);

		Step_Start(3, "Enter vessel details in search option and click search ", test, test1);

	newButton(driver);
		waitForElement(driver, AN_servicename);
		sendKeys(driver, AN_servicename, Service);
		waitForElement(driver, ANgrid_vesselcode);
		sendKeys(driver, ANgrid_vesselcode, Vessel);
		sendKeys(driver, ANgrid_voyagecode, Voyage);
		sendKeys(driver, ANgrid_bound, Bound);
		sendKeys(driver, ANgrid_portcode, Port);
		waitForElement(driver, AN_scroll);
		scrollUsingElement(driver, AN_scroll);
		horizontalscroll(driver, AN_scroll, 300);
		click1(driver,ANgrid_terminal);
		sendKeys(driver, ANgrid_terminal, Terminal);
		click(driver, ANgrid_selectbtn);
		Step_End(3, "Enter vessel details in search option and click search ", test, test1);

		Step_Start(4, "After fecthing the Bls select the Bl numbers and click the Delete icon on tool bar", test, test1);

		scrollTop(driver);
		waitForElement(driver, slection_Label_1);
		click(driver, slection_Label_1);
		waitForElement(driver, select_Option_1);
		click(driver, select_Option_1);
		waitForElement(driver, Show_BL_Button);
		click(driver, Show_BL_Button);

		List<String> IB_BL_Numbers= splitAndExpand(bl_Number);

		waitForElement(driver, AN_Arrival_notice_button);
		click(driver, AN_Arrival_notice_button);
		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		click(driver, condition_Filter_AN);
		for(String bl_Num : IB_BL_Numbers) {
			String Check_Box = String.format(Arrival_Notice_Locators.click_checkbox_By_Bl_Num, bl_Num);
		
			waitForElement(driver, condition_Filter_AN);
			click(driver, condition_Filter_AN);
			waitForElement(driver, blNumber_Filter_AN);
			clear(driver, blNumber_Filter_AN);
			waitForElement(driver, blNumber_Filter_AN);
			sendKeys(driver, blNumber_Filter_AN, bl_Num);
			waitForElement(driver, blNumber_Filter_AN);
			waitForElement(driver, Check_Box);
			click(driver, Check_Box);
		}
		Step_End(4, "After fecthing the Bls select the Bl numbers and click the Delete icon on tool bar", test, test1);

		Step_Start(5, "Ensure that system shows the validation message \" Do you want to delete the selected BL Number(s) ?", test, test1);
		scrollTop(driver);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		waitForPopup(driver, popup_Message, confirmation_Popup);     
		String Actual_confirmation_Msg = getText(driver, popup_Message);
		if (confirmation_Popup.trim().equals(Actual_confirmation_Msg.trim())) {
			System.out.println("Matched || Expected Popup value should be shown : " + confirmation_Popup + " || Actual Popup value was : " + Actual_confirmation_Msg);
			Extent_pass(driver,"Matched || Expected Popup value should be shown : " + confirmation_Popup + " || Actual Popup value was : " + Actual_confirmation_Msg, test,test1);
			Step_End(5, "Ensure that system shows the validation message \" Do you want to delete the selected BL Number(s) ?", test, test1);

			Step_Start(6, "Click yes ", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(6, "Click yes ", test, test1);

			Step_Start(7, "Ensure system validates \" Arrival notice deleted \"", test, test1);

		} else {
			System.out.println("Not Matched || Expected Popup value should be shown : " + confirmation_Popup + " || Actual Popup value was : " + Actual_confirmation_Msg);
			Extent_fail(driver,"Not Matched || Expected Popup value should be shown : " + confirmation_Popup + " || Actual Popup value was : " + Actual_confirmation_Msg,test, test1);
		}

		waitForPopup(driver, Popup_Message, Deleted_Popup);    
		String Actual_Deleted_Popup = getText(driver, Popup_Message);
		if (Deleted_Popup.trim().equals(Actual_Deleted_Popup.trim())) {
			System.out.println("Matched || Expected Popup value should be shown : " + Deleted_Popup + " || Actual Popup value was : " + Actual_Deleted_Popup);
			Extent_pass(driver,"Matched || Expected Popup value should be shown : " + Deleted_Popup + " || Actual Popup value was : " + Actual_Deleted_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Popup value was : " + Deleted_Popup + " || Actual Popup value was : " + Actual_Deleted_Popup);
			Extent_fail(driver,"Not Matched || Expected Popup value was : " + Deleted_Popup + " || Actual Popup value was : " + Actual_Deleted_Popup,test, test1);
		}
		Step_End(7, "Ensure system validates \" Arrival notice deleted \"", test, test1);
		Extent_completed(testCaseName, test, test1);

	}
}
