package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_001 extends Keywords{
	public void Delivery_Order_TS_001(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		String testcase_Name="TC_Delivery_Order_TS_001";
		
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String popupMessage = Excel_data.get("PopupMessage");
		String globalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		//	Login 
		LRP_Login(driver, Username, Password);
		//	Delivery order
		Step_Start(1, "Open Delivery order Module in line ", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(1, "Open Delivery order Module in line ", test, test1);
		Step_Start(2, "Click on New Button", test, test1);
		newButton(driver);
		Step_End(2, "Click on New Button", test, test1);
		Step_Start(3, "Click 'ADD ' button", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(3, "Click 'ADD ' button", test, test1);
		Step_Start(4, "Paste the BL and Click show button", test, test1);
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
		Step_End(4, "Paste the BL and Click show button", test, test1);
		Step_Start(5, "Ensure system displays 'No records found '", test, test1);
		waitForPopup(driver,Popup_Message,popupMessage);
		String actual_Popup = getText(driver, Popup_Message);
		if (actual_Popup.equals(popupMessage)) {
			System.out.println("Matched || Expected Delivery Order Pop-up value is : " + popupMessage + " || Actual Delivery Order Pop-up value is : " + actual_Popup);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + popupMessage + " || Actual Delivery Order Pop-up value is : " + actual_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + popupMessage + " || Actual Delivery Order Pop-up value is : " + actual_Popup);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + popupMessage + " || Actual Delivery Order Pop-up value is : " + actual_Popup,test, test1);
		}
		Step_End(5, "Ensure system displays 'No records found '", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
