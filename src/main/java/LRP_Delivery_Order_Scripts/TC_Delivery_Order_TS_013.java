package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_013 extends Keywords{
	public void Delivery_Order_TS_013(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_013";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String DeliveryOrderModule = Excel_data.get("DeliveryOrderModule");
		String GlobalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String BL_numbers = Excel_data.get("BL_numbers");
		String Condition = Excel_data.get("Condition");
		String DO_Saved = Excel_data.get("DO_Saved");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String deleted_expected = Excel_data.get("deleted expected");
		String delete_Option = Excel_data.get("delete_Option");
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		Step_Start(2, "Open Delivery order module", test, test1);
		moduleNavigate(driver, DeliveryOrderModule);
		Step_End(2, "Open Delivery order module", test, test1);
		Step_Start(3, "Click new button", test, test1);
		newButton(driver);
		Step_End(3, "Click new button", test, test1);
		Step_Start(4, "Click the  ADD  Button and paste the Bl", test, test1);
		List<String> BL_Numbers = splitAndExpand(BL_numbers);
		for(String BL_Number:BL_Numbers) {
			waitForElement(driver, DO_Add_Button);
			click(driver, DO_Add_Button);
			Step_Start(5, "select Multiple bl's one by one using add button with same steps as 4 - 5", test, test1);
			globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_DO, BL_Number, "", "", "", "");
			Step_End(5, "select Multiple bl's one by one using add button with same steps as 4 - 5", test, test1);
		}
		Step_End(4, "Click the  ADD  Button and paste the Bl", test, test1);
		Step_Start(6, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(6, "Click the SHOW button", test, test1);
		Step_Start(7, "Select the Containers for each bls", test, test1);
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(7, "Select the Containers for each bls", test, test1);
		Step_Start(8, "Click the Save button ", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(8, "Click the Save button ", test, test1);
		Step_Start(9, "Ensure  Delivery order saved  validation done after Do saved", test, test1);
		waitForPopup(driver,Popup_Message,DO_Saved);
		String DO_Saved_Popup=getText(driver, Popup_Message);
		if (DO_Saved_Popup.equals(DO_Saved)) {
			System.out.println("Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup);
			Extent_pass_New(driver,"Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup);
			Extent_fail(driver,"Not Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is  : " + DO_Saved_Popup,test, test1);
		}
		Step_End(9, "Ensure  Delivery order saved  validation done after Do saved", test, test1);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Step_Start(10, "Click the Delete button", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(10, "Click the Delete button", test, test1);
			Step_Start(11, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			waitForPopup(driver, popup_Message,delete_popup_expected);
			String delete_Msg_Actual = getText(driver, popup_Message).trim();
			if(delete_Msg_Actual.equals(delete_popup_expected.trim())) {
				System.out.println("MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual, test, test1);
			}
			Step_End(11, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			Step_Start(12, "Click Yes", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(12, "Click Yes", test, test1);
			Step_Start(13, "Ensure system validated as 'Delivery order deleted'", test, test1);
			waitForPopup(driver,Popup_Message,deleted_expected);
			String do_Deleted_Actual = getText(driver, Popup_Message);
			if(do_Deleted_Actual.equals(deleted_expected)) {
				System.out.println("MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}
			Step_End(13, "Ensure system validated as 'Delivery order deleted'", test, test1);
		}
		Extent_completed(testcase_Name, test, test1);
	}
}