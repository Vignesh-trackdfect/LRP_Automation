package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_004 extends Keywords{
	public void Delivery_Order_TS_004(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_004";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String save_Popup_Expected = Excel_data.get("Save_Popup_Expected");
		String wantToDelete_Popup = Excel_data.get("WantToDelete_Popup");
		String DO_Deleted_Popup = Excel_data.get("DO_Deleted_Popup");
		String globalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String doStatus = Excel_data.get("DO_Status");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String delete_Option = Excel_data.get("delete_Option");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		SwitchProfile(driver, agencyUser);
		//	Delivery Order
		Extent_cal(test, test1, module_Delivery_Order);
		Step_Start(1, "Open delivery order module", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		scrollTop(driver);
		Step_End(1, "Open delivery order module", test, test1);
		Step_Start(2, "Click new and click add button", test, test1);
		newButton(driver);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(2, "Click new and click add button", test, test1);
		Step_Start(3, "Paste the Bl number and fetch the BL", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(3, "Paste the Bl number and fetch the BL", test, test1);
		Step_Start(4, "Select the containers", test, test1);
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(4, "Select the containers", test, test1);
		Step_Start(5, "Click the Save button  on Tool bar", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(5, "Click the Save button  on Tool bar", test, test1);
		Step_Start(6, "Ensure \"\" Delivery order saved \"\" validation done after Do saved", test, test1);
		waitForPopup(driver,Popup_Message,save_Popup_Expected);
		String save_Popup_Actual = getText(driver, Popup_Message);
		if(save_Popup_Actual.equals(save_Popup_Expected)) {
			System.out.println("MATCHED || EXPECTED Pop-up value is : "+save_Popup_Expected+" ACTUAL Pop-up value is : "+ save_Popup_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is : "+save_Popup_Expected+" ACTUAL Pop-up value is : "+ save_Popup_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED Pop-up value is : "+save_Popup_Expected+" ACTUAL Pop-up value is : "+ save_Popup_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is : "+save_Popup_Expected+" ACTUAL Pop-up value is : "+ save_Popup_Actual, test, test1);
		}
		waitForElement(driver, DO_Status);
		String actual_Do_Status=getText(driver, DO_Status);
		if(actual_Do_Status.contains(doStatus)) {
			Extent_pass_New(driver, "Matched || Expected Status value is : "+doStatus +" || Actual Status value is : "+actual_Do_Status, test, test1);
			System.out.println("Matched || Expected Status value is : "+doStatus +" || Actual Status value is : "+actual_Do_Status);
		}else {
			System.out.println("Not Matched || Expected Status value is : "+doStatus +" || Actual Status value is : "+actual_Do_Status);
			Extent_fail(driver, "Not Matched || Expected Status value is : "+doStatus +" || Actual Status value is : "+actual_Do_Status, test, test1);
		}
		Step_End(6, "Ensure \"\" Delivery order saved \"\" validation done after Do saved", test, test1);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Extent_call(test, test1, "No need verify below but script must be there.");	
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
		} else {
			System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup,test, test1);
		}
		Step_Start(3, "Click Yes", test, test1);
		click(driver, popup_Message_Yes_Button);
		Step_End(3, "Click Yes", test, test1);
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