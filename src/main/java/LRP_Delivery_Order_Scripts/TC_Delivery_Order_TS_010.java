package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_010 extends Keywords{
	public void Delivery_Order_TS_010(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_010";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String globalSearch_Number=Excel_data.get("GlobalSearch_Number");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String wantToDelete_Popup = Excel_data.get("WantToDelete_Popup");
		String DO_Deleted_Popup = Excel_data.get("DO_Deleted_Popup");
		String redColorCode = Excel_data.get("RedColorCode");
		String status_Filer_Data = Excel_data.get("Status_Filer_Data");
		String globalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String wantToSave = Excel_data.get("WantToSave");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		Step_Start(2, "open Delivery order Module", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(2, "open Delivery order Module", test, test1);
		Step_Start(3, "Click the search and paste the Bl number and click on select", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
		globalValueSearchWindowScrollAndSelect(driver,status_Filter_DO,status_Filer_Data);
		Step_End(3, "Click the search and paste the Bl number and click on select", test, test1);
		Step_Start(4, "After records set in the field and Click Delete button", test, test1);
		scrollTop(driver);
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(4, "After records set in the field and Click Delete button", test, test1);
		Step_Start(5, "system validates  \"  Are you sure want to delete the Delivery Order? \"", test, test1);
		waitForPopup(driver, popup_Message,wantToDelete_Popup);
		String actualWantToDelete_Popup = getText(driver, popup_Message);
		if (actualWantToDelete_Popup.equals(wantToDelete_Popup)) {
			System.out.println("Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup,test, test1);
		}
		Step_End(5, "system validates  \"  Are you sure want to delete the Delivery Order? \"", test, test1);
		Step_Start(6, "Click Yes", test, test1);
		click(driver, popup_Message_Yes_Button);
		Step_End(6, "Click Yes", test, test1);
		Step_Start(7, "Ensure System validated as Delivery order deleted and Do number shown in red colour.", test, test1);
		waitForPopup(driver,Popup_Message,DO_Deleted_Popup);
		String actual_Deleted_Popup = getText(driver, Popup_Message);
		if (actual_Deleted_Popup.equals(DO_Deleted_Popup)) {
			System.out.println("Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup,test, test1);
		}
		waitForElement(driver, deliveryOrderNumber_Textfield);
		String actualColorCode=getTextBackgroundColor(driver, deliveryOrderNumber_Textfield);
		String actualColor = getColorName(actualColorCode);
		if (actualColor.equalsIgnoreCase(redColorCode)) {
			System.out.println("Matched || Delivery Order Textfield Color is Red || Expected Delivery Order Textfield Color : " + redColorCode + " || Actual Delivery Order Textfield Color : " + actualColor);
			Extent_pass_New(driver,"Matched || Delivery Order Textfield Color is Red || Expected Delivery Order Textfield Color : " + redColorCode + " || Actual Delivery Order Textfield Color : " + actualColor, test,test1);
		} else {
			System.out.println("Not Matched || Delivery Order Textfield Color is not Red || Expected Delivery Order Textfield Color : " + redColorCode + " || Actual Delivery Order Textfield Color : " + actualColor);
			Extent_fail(driver,"Not Matched || Delivery Order Textfield Color is not Red || Expected Delivery Order Textfield Color : " + redColorCode + " || Actual Delivery Order Textfield Color : " + actualColor,test, test1);
		}
		Step_End(7, "Ensure System validated as Delivery order deleted and Do number shown in red colour.", test, test1);
		if(wantToSave.equalsIgnoreCase("Yes")) {
			newButton(driver);
			waitForElement(driver, DO_Add_Button);
			click(driver, DO_Add_Button);
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
			waitForElement(driver, DO_Show_Button);
			click(driver, DO_Show_Button);
			scrollBottom(driver);
			waitForElement(driver, select_All_Checkbox_DO);
			click(driver, select_All_Checkbox_DO);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
		}
		Extent_completed(testcase_Name, test, test1);
	}
}