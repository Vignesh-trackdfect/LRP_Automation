package LRP_EMS_EDI_Configuration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_004 extends Keywords {

	public void EMS_EDI_Configuration_TS_004(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_004";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Format_Value = Excel_data.get("Format_Value");
		String Tab_Option = Excel_data.get("Tab_Option");
		String AG_Grid_Column_Header = Excel_data.get("AG_Grid_Column_Header");
		String Movement_Code_Values = Excel_data.get("Movement_Code_Values");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_EDI_Name_Values = Excel_data.get("EDI_ID_EDI_Name_Values");
		String Partner_ID_EDI_Name_Values = Excel_data.get("Partner_ID_EDI_Name_Values");
		String Expected_Popup_Message = Excel_data.get("Expected_Popup_Message");
		
		navigateUrl(driver, url);
		
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, username, pass_word);
		
		verifyMainMenu(driver);
		moduleNavigate(driver, Module); 
		Step_Start(1, "By default ' By Format ' tab opens first", test, test1);	
		formatLocatorClick(driver, EEC_Tab_Option, Tab_Option);
		
		Step_End(1, "By default ' By Format ' tab opens first", test, test1);
		Step_Start(2, "Click the ' Format ' dropdown and select the type of EDI you want to apply to the EDI and Partner", test, test1);	
		
		waitForElement(driver, EEC_Format_Dropdown);
		click(driver, EEC_Format_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Format_Value);
		
		Step_End(2, "Click the ' Format ' dropdown and select the type of EDI you want to apply to the EDI and Partner", test, test1);
		Step_Start(3, "Select the list of movements you want to apply to the EDI and Partner", test, test1);
		
		AGGridValueFilterMultipleValue(driver, AG_Grid_Column_Header, Filter_Condition, Movement_Code_Values);
		waitForElement(driver, EEC_Apply_To_EDI_Button);
		click(driver, EEC_Apply_To_EDI_Button);
		Step_End(3, "Select the list of movements you want to apply to the EDI and Partner", test, test1);
		Step_Start(4, "You can filter using the EDI ID or Partner ID, or select the records by scrolling in the grid", test, test1);
		List<String> EDI_Values = splitAndExpand(EDI_ID_EDI_Name_Values, ",");
		List<String> Partner_Values = splitAndExpand(Partner_ID_EDI_Name_Values, ",");
		for( int i = 0; i < EDI_Values.size(); i++ ) {
			waitForElement(driver, EEC_EDI_Name_Filter);
			clear(driver, EEC_EDI_Name_Filter);
			sendKeys(driver, EEC_EDI_Name_Filter, EDI_Values.get(i));
			waitForElement(driver, EEC_Partner_Name_Filter);
			clear(driver, EEC_Partner_Name_Filter);
			sendKeys(driver, EEC_Partner_Name_Filter, Partner_Values.get(i));
			waitForElement(driver, EEC_Select_Id_CheckBox);
			click(driver, EEC_Select_Id_CheckBox);
		}
		
		Step_End(4, "You can filter using the EDI ID or Partner ID, or select the records by scrolling in the grid", test, test1);
		
		Step_Start(5, "After selecting, click the \"Apply\" button", test, test1);
		waitForElement(driver, EEC_Select_Id_Apply_Button);
		click(driver, EEC_Select_Id_Apply_Button);
		
		Step_End(5, "After selecting, click the \"Apply\" button", test, test1);

		Step_Start(6, "The system will show \"EDI ID details updated successfully\" once applied. Click \"OK.\"", test, test1);
	
		waitForPopup(driver, popup_Message, Expected_Popup_Message);
		String Act_Popup =getText(driver, popup_Message);
		
		if(Expected_Popup_Message.equals(Act_Popup)) {
			System.out.println("Matched || After click on Apply Button the Expected Pop-up value is : " + Expected_Popup_Message + " ||After click on Apply Button the Actual Pop-up value is  : " + Act_Popup);
			Extent_pass_New(driver,"Matched || After click on Apply Button the Expected Pop-up value is : " + Expected_Popup_Message + " ||After click on Apply Button the Actual Pop-up value is  : " + Act_Popup,test, test1);
		}else {
			System.out.println("Not Matched || After click on Apply Button the Expected Pop-up value is : " + Expected_Popup_Message + " ||After click on Apply Button the Actual Pop-up value is  : " + Act_Popup);
			Extent_fail(driver,"Not Matched || After click on Apply Button the Expected Pop-up value is : " + Expected_Popup_Message + " ||After click on Apply Button the Actual Pop-up value is  : " + Act_Popup,test, test1);
		}
		Step_End(6, "The system will show \"EDI ID details updated successfully\" once applied. Click \"OK.\"", test, test1);
		Extent_completed(testcase_Name, test, test1);
		
	}
}