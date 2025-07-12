package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_007 extends Keywords{
	public void Delivery_Order_TS_007(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_007";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String globalSearch_Number=Excel_data.get("GlobalSearch_Number");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String doStatus = Excel_data.get("DO_Status");
		String status_Filer_Data = Excel_data.get("Status_Filer_Data");
		String cannotEditPopup = Excel_data.get("CannotEditPopup");
		String cannotDeletePopup = Excel_data.get("CannotDeletePopup");
		String globalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");


		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		Step_Start(2, "open Delivery order Module, click the search button from tool bar", test, test1);

		//	Delivery Order
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(2, "open Delivery order Module, click the search button from tool bar", test, test1);
		Step_Start(3, "Paste the BLnumber and click on \"\"Select\"\"", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
		Step_Start(4, "Double click on the selected grid", test, test1);
		globalValueSearchWindowScrollAndSelect(driver,status_Filter_DO,status_Filer_Data);
		Step_End(4, "Double click on the selected grid", test, test1);
		Step_End(3, "Paste the BLnumber and click on \"\"Select\"\"", test, test1);
		Step_Start(5, "Capture the status of Delivery Order ( Should be issued )", test, test1);
		waitForElement(driver, DO_Status);
		String actual_Do_Status=getText(driver, DO_Status);
		if(actual_Do_Status.contains(doStatus)) {
			Extent_pass_New(driver, "Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status, test, test1);
			System.out.println("Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status);
		}else {
			System.out.println("Not Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status);
			Extent_fail(driver, "Not Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status, test, test1);
		}
		Step_End(5, "Capture the status of Delivery Order ( Should be issued )", test, test1);
		Step_Start(6, "Click  edit button", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(6, "Click  edit button", test, test1);
		Step_Start(7, "System  validated as \"\"Cannot edit the Issued DO\"\"", test, test1);
		waitForPopup(driver,Popup_Message,cannotEditPopup);
		String actual_edit_Popup = getText(driver, Popup_Message);
		if (actual_edit_Popup.equals(cannotEditPopup)) {
			System.out.println("Matched || Expected Delivery Order Pop-up value is : " + cannotEditPopup + " || Actual Delivery Order Pop-up value is : " + actual_edit_Popup);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + cannotEditPopup + " || Actual Delivery Order Pop-up value is : " + actual_edit_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + cannotEditPopup + " || Actual Delivery Order Pop-up value is : " + actual_edit_Popup);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + cannotEditPopup + " || Actual Delivery Order Pop-up value is : " + actual_edit_Popup,test, test1);
		}

		Step_End(7, "System  validated as \"\"Cannot edit the Issued DO\"\"", test, test1);
		Step_Start(8, "Click the delete button", test, test1);
		scrollTop(driver);
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(8, "Click the delete button", test, test1);
		Step_Start(9, "Ensure  system validated as \" Cannot delete the issued DO\"", test, test1);
		waitForPopup(driver,Popup_Message,cannotDeletePopup);
		String actual_Delete_Popup = getText(driver, Popup_Message);
		if (actual_Delete_Popup.equals(cannotDeletePopup)) {
			System.out.println("Matched || Expected Delivery Order Pop-up value is : " + cannotDeletePopup + " || Actual Delivery Order Pop-up value is : " + actual_Delete_Popup);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + cannotDeletePopup + " || Actual Delivery Order Pop-up value is : " + actual_Delete_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + cannotDeletePopup + " || Actual Delivery Order Pop-up value is : " + actual_Delete_Popup);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + cannotDeletePopup + " || Actual Delivery Order Pop-up value is : " + actual_Delete_Popup,test, test1);
		}
		Step_End(9, "Ensure  system validated as \" Cannot delete the issued DO\"", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}

}
