package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_015 extends Keywords{
	public void Delivery_Order_TS_015(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_015";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Condition = Excel_data.get("Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String DeliveryOrderModule = Excel_data.get("DeliveryOrderModule");
		String Do_Popup = Excel_data.get("Do_Popup");
		String GlobalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		Step_Start(2, "Open Delivery order module", test, test1);
		moduleNavigate(driver, DeliveryOrderModule);
		Step_End(2, "Open Delivery order module", test, test1);
		Step_Start(3, "Click new button", test, test1);
		newButton(driver);
		Step_End(3, "Click new button", test, test1);
		List<String> Bl_Numbers = splitAndExpand(BL_Num);
		for(String bl_Number:Bl_Numbers) {
			Step_Start(4, "Click the \" ADD \" Button", test, test1);
			waitForElement(driver, DO_Add_Button);
			click(driver, DO_Add_Button);
			Step_End(4, "Click the \" ADD \" Button", test, test1);
			Step_Start(5, "Select mentioned BLs  by using BL search", test, test1);
			globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_DO, bl_Number, "", "", "", "");
		}
		Step_End(5, "Select mentioned BLs  by using BL search", test, test1);
		Step_Start(6, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(6, "Click the SHOW button", test, test1);
		Step_Start(7, "Ensure system validated as Select BLs for the same Customer", test, test1);
		waitForPopup(driver,Popup_Message,Do_Popup);
		String BL_Popup=getText(driver, Popup_Message);
		if (Do_Popup.equals(BL_Popup)) {
			System.out.println("Matched || Expected Pop-up value was : " + Do_Popup + " || Actual Pop-up value was : " + BL_Popup);
			Extent_pass_New(driver,"Matched || Expected Pop-up value was : " + Do_Popup + " || Actual Pop-up value was : " + BL_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up value was : " + Do_Popup + " || Actual Pop-up value was : " + BL_Popup);
			Extent_fail(driver,"Not Matched || Expected Pop-up value was : " + Do_Popup + " || Actual Pop-up value was  : " + BL_Popup,test, test1);
		}
		Step_End(7, "Ensure system validated as Select BLs for the same Customer", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
