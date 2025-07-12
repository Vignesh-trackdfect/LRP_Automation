package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_003 extends Keywords{
	public void Delivery_Order_TS_003(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_003";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String globalSearchFilterOption_DO=Excel_data.get("GlobalSearchFilterOption_DO");
		String globalSearch_Number=Excel_data.get("GlobalSearch_Number");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String popupMessage = Excel_data.get("PopupMessage");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		Step_Start(2, "open Delivery order Module", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(2, "open Delivery order Module", test, test1);
		Step_Start(3, "Click on New Button", test, test1);
		newButton(driver);
		Step_End(3, "Click on New Button", test, test1);
		Step_Start(4, "Click \"ADD \" button", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(4, "Click \"ADD \" button", test, test1);
		Step_Start(5, "Paste the Bl number ( Make sure already Deliver order saved)", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
		Step_End(5, "Paste the Bl number ( Make sure already Deliver order saved)", test, test1);
		Step_Start(6, "Click show button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(6, "Click show button", test, test1);
		Step_Start(7, "Ensure system validates  \" Already saved DO for respective BL  \"", test, test1);
		String expectedPopup=popupMessage+" "+globalSearch_Number+" .";
		waitForPopup(driver,Popup_Message,expectedPopup);
		String actual_Popup = getText(driver, Popup_Message);
		if (actual_Popup.equals(expectedPopup)) {
			System.out.println("Matched || Expected Delivery Order Pop-up value is : " + expectedPopup + " || Actual Delivery Order Pop-up value is : " + actual_Popup);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + expectedPopup + " || Actual Delivery Order Pop-up value is : " + actual_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + expectedPopup + " || Actual Delivery Order Pop-up value is : " + actual_Popup);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + expectedPopup + " || Actual Delivery Order Pop-up value is : " + actual_Popup,test, test1);
		}
		Step_End(7, "Ensure system validates  \" Already saved DO for respective BL  \"", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
