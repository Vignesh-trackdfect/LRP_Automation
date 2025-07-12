package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_047 extends Keywords{
	public void Delivery_Order_TS_047(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_047";




		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String globalSearchFilterOption_DO=Excel_data.get("GlobalSearchFilterOption_DO");
		String globalSearch_Number=Excel_data.get("GlobalSearch_Number");
		String globalSearchFilterOption_CustomerSearch=Excel_data.get("GlobalSearchFilterOption_CustomerSearch");
		String globalSearch_Value=Excel_data.get("GlobalSearch_Value");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String do_Saved_Popup = Excel_data.get("DO_Saved_Popup");
		String wantToDelete_Popup = Excel_data.get("WantToDelete_Popup");
		String DO_Deleted_Popup = Excel_data.get("DO_Deleted_Popup");
		String delete_Option = Excel_data.get("delete_Option");
		String Status_Filter_Input = Excel_data.get("Status_Filter_Input");
		String DO_Updated_Popup = Excel_data.get("DO_Updated_Popup");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		Step_Start(2, "Open delivery order module", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(2, "Open delivery order module", test, test1);
		Step_Start(3, "Click search button and paste the DO number /BL number", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver,dropdownCondition,globalSearchFilterOption_DO,globalSearch_Number, "", "", "", "");
		Step_End(3, "Click search button and paste the DO number /BL number", test, test1);
		waitForElement(driver, DO_horizontal_Scroll);
		horizontalscroll(driver, DO_horizontal_Scroll, 2500);
		waitForElement(driver, status_Filter_DO);
		sendKeys(driver, status_Filter_DO, Status_Filter_Input);
		Step_Start(4, "Fetch the Bl and click edit", test, test1);
		waitForDisplay(driver, retrivedGlobalValue);
		if(isdisplayed(driver, retrivedGlobalValue)) {
			Extent_call(test, test1, "For already saved Delivery Order");
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			waitForElement(driver, deliveryCustomer_Checkbox);
			String status = getAttribute(driver,deliveryCustomer_Checkbox,"class");
			if(!extractstatus(status)) {
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
				Step_End(4, "Fetch the Bl and click edit", test, test1);
				Step_Start(5, "Select the delivery customer check box", test, test1);
					waitForElement(driver, deliveryCustomer_Checkbox);
				checkBox(driver, deliveryCustomer_Checkbox, "Yes");
				Step_End(5, "Select the delivery customer check box", test, test1);
				Step_Start(6, "Click the delivery customer code search icon", test, test1);
				waitForElement(driver, deliveryCustomerCode_SearchButton);
				click(driver, deliveryCustomerCode_SearchButton);
				Step_End(6, "Click the delivery customer code search icon", test, test1);
				Step_Start(7, "Fetch the delivery customer using % or customer code", test, test1);
				globalValueSearchWindow(driver,dropdownCondition,globalSearchFilterOption_CustomerSearch,globalSearch_Value, "", "", "", "");
				Step_End(7, "Fetch the delivery customer using % or customer code", test, test1);
				
			}
		}else {
			waitForElement(driver, globalSearchCloseIcon_L);
			click(driver, globalSearchCloseIcon_L);
			Step_Start(3, "Click new and add button", test, test1);
			newButton(driver);
			waitForElement(driver, DO_Add_Button);
			click(driver, DO_Add_Button);
			Step_End(3, "Click new and add button", test, test1);
			Step_Start(4, "Paste the BL and fetch the record", test, test1);
			globalValueSearchWindow(driver,dropdownCondition,globalSearchFilterOption_DO,globalSearch_Number, "", "", "", "");
			Step_End(4, "Paste the BL and fetch the record", test, test1);
			Step_Start(5, "Click show and select the delivery customer check box", test, test1);
			waitForElement(driver, DO_Show_Button);
			click(driver, DO_Show_Button);
			waitForElement(driver, deliveryCustomer_Checkbox);
			checkBox(driver, deliveryCustomer_Checkbox, "Yes");
			Step_End(5, "Click show and select the delivery customer check box", test, test1);
			Step_Start(6, "Click the delivery customer code search icon", test, test1);
			waitForElement(driver, deliveryCustomerCode_SearchButton);
			click(driver, deliveryCustomerCode_SearchButton);
			Step_End(6, "Click the delivery customer code search icon", test, test1);
			Step_Start(7, "Fetch the delivery customer using % or customer code", test, test1);
			globalValueSearchWindow(driver,dropdownCondition,globalSearchFilterOption_CustomerSearch,globalSearch_Value, "", "", "", "");
		}
		Step_End(7, "Fetch the delivery customer using % or customer code", test, test1);
		Step_Start(8, "Select the container and Click save button", test, test1);
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(8, "Select the container and Click save button", test, test1);
		waitForPopup(driver,Popup_Message,do_Saved_Popup);
		String save_Popup_Actual = getText(driver, Popup_Message);
		if(save_Popup_Actual.equals(do_Saved_Popup)) {
			System.out.println("Matched || Expected Delivery Order Pop-up value is : " + do_Saved_Popup + " || Actual Delivery Order Pop-up value is : " + save_Popup_Actual);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + do_Saved_Popup + " || Actual Delivery Order Pop-up value is : " + save_Popup_Actual, test,test1);
		}else if(save_Popup_Actual.equals(DO_Updated_Popup)) {
			Step_Start(8, "Click save and make sure system validating Delivery order updated", test, test1);
			System.out.println("Matched || Expected Delivery Order Pop-up value is : " + DO_Updated_Popup + " || Actual Delivery Order Pop-up value is : " + save_Popup_Actual);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + DO_Updated_Popup + " || Actual Delivery Order Pop-up value is : " + save_Popup_Actual, test,test1);
			Step_End(8, "Click save and make sure system validating Delivery order updated", test, test1);
			}else {
			System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + do_Saved_Popup + " || Actual Delivery Order Pop-up value is : " + save_Popup_Actual);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + do_Saved_Popup + " || Actual Delivery Order Pop-up value is : " + save_Popup_Actual,test, test1);
		}
		Step_Start(9, "Make sure delivery customer details showing in screen", test, test1);
		waitForElement(driver, DO_CustomerCode_Textfield);
		String actualCustomerCode=getAttribute(driver, DO_CustomerCode_Textfield, "value");
		String actualCustomerName=getAttribute(driver, DO_Name_Textfield, "value");
		String actualAddress1=getAttribute(driver, DO_Address_1_Textfield, "value");
		String actualAddress2=getAttribute(driver, DO_Address_2_Textfield, "value");
		ArrayList<String> deliveryCustomerDetails=new ArrayList<String>();
		deliveryCustomerDetails.add(actualCustomerCode);
		deliveryCustomerDetails.add(actualCustomerName);
		deliveryCustomerDetails.add(actualAddress1);
		deliveryCustomerDetails.add(actualAddress2);
		Step_End(9, "Make sure delivery customer details showing in screen", test, test1);
		Step_Start(10, "Capture the delivery  customer details need to be shown in HTML report", test, test1);
		Extent_pass_New(driver, "Retrieved Customer Code Details : "+actualCustomerCode, test, test1);
		Extent_pass_New(driver, "Retrieved Customer Name Details : "+actualCustomerName, test, test1);
		Extent_pass_New(driver, "Retrieved Customer Address 1 Details : "+actualAddress1, test, test1);
		Extent_pass_New(driver, "Retrieved Customer Address 2 Details : "+actualAddress2, test, test1);
		System.out.println("Retrieved Customer Code Details : "+actualCustomerCode);
		System.out.println("Retrieved Customer Name Details : "+actualCustomerName);
		System.out.println("Retrieved Customer Address 1 Details : "+actualAddress1);
		System.out.println("Retrieved Customer Address 2 Details : "+actualAddress2);
		Step_End(10, "Capture the delivery  customer details need to be shown in HTML report", test, test1);
		Extent_call(test, test1, "No need verify below but script must be there.");	
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Step_Start(1, "Click the Delete button", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(1, "Click the Delete button", test, test1);
			Step_Start(2, "system validated as \"\"Are you sure want to delete the Delivery Order? \"\"", test, test1);
			waitForPopup(driver, popup_Message,wantToDelete_Popup);
			String actualWantToDelete_Popup = getText(driver, popup_Message);
			if (actualWantToDelete_Popup.equals(wantToDelete_Popup)) {
				System.out.println("Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup);
				Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup, test,test1);
				Step_End(2, "system validated as \"\"Are you sure want to delete the Delivery Order? \"\"", test, test1);
				Step_Start(3, "Click Yes", test, test1);
				click(driver, popup_Message_Yes_Button);
				Step_End(3, "Click Yes", test, test1);
			} else {
				System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup);
				Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup,test, test1);
			}
			Step_Start(4, "Ensure system validated as Delivery order deleted \"", test, test1);
			waitForPopup(driver,Popup_Message,DO_Deleted_Popup);
			String actual_Deleted_Popup = getText(driver, Popup_Message);
			if (actual_Deleted_Popup.equals(DO_Deleted_Popup)) {
				System.out.println("Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup);
				Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup, test,test1);
			} else {
				System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup);
				Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup,test, test1);
			}
			Step_End(4, "Ensure system validated as Delivery order deleted \"", test, test1);
		}
		Extent_completed(testcase_Name, test, test1);
	}
}
