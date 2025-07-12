package LRP_Booking_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC089 extends Keywords {

	public void Booking_SC089 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {


		String tc_Name="TC_Booking_SC089";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser = Excel_data.get("agencyUser");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String equip_data=Excel_data.get("equip_data");
		String popup_msg=Excel_data.get("popup_msg");


		//locators


		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1,"**Switch the Profile Start**");

		SwitchProfile(driver, agencyUser);

		Extent_cal(test, test1,"** Enter Booking Module **");


		
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
		moduleNavigate(driver, search_module);


		Step_Start(2, "Enter the Orgin and delivery", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the Orgin and delivery", test, test1);
		waitForDisplay(driver, Rate_Grid);
		if(isdisplayed(driver, Rate_Grid)) {
			System.out.println("*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed");            
			Extent_pass_New(driver,"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed", test,test1);     
		}                                                                                                                                                                        
		else {  
		waitForElement(driver, RatedBtn);
		click(driver, RatedBtn);
		waitForElement(driver, $Rates);
		click(driver, $Rates);

		waitForElement(driver, rate_reference_tab);
		if(isDisplayed(driver,rate_reference_tab)) {
			System.out.println("*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Showed");            
			Extent_pass_New(driver,"*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Showed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Not Showed");        
			Extent_fail(driver, "*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Not Showed", test,test1); 
		
		}
		}
	

		//Click the equip_type menu
		waitForElement(driver, rate_ref_toolpanel);
		click(driver, rate_ref_toolpanel);

		//Click equip_typefilter icon
		waitForElement(driver, rateref_toolpanel_filter);
		click(driver, rateref_toolpanel_filter);

		//Enter the data in equip_filter search
		List<String> equip_datas = splitAndExpand(equip_data);
		for(String Equip_data : equip_datas) {
			mouseOverToElement(driver, equip_type_filter);
			waitForElement(driver, equip_type_filter);
			clear(driver, equip_type_filter);
			sendKeys(driver, equip_type_filter, Equip_data);
			waitForElement(driver, Rate_No_Select);
			click(driver, Rate_No_Select);
		}
		//click ok button
		waitForElement(driver, ok_btn);
		click(driver, ok_btn);
		
		Step_Start(3, "System validate that the system displays-> Port Pair or Customer is mismatched", test, test1);

		waitForPopup(driver, popup_Message, popup_msg);   
		String error_msg=getText(driver, popup_Message);
		if(error_msg.contains(popup_msg)) {
			Extent_pass_New(driver,"Matched ||Excepted POPUP should be displayed:"+ popup_msg +" Actual POPUP  displayed:"+ error_msg, test, test1);
			System.out.println("Matched ||Excepted POPUP should be displayed:"+ popup_msg +" Actual POPUP  displayed:"+ error_msg);
		}
		else {
			System.out.println("Not matched ||Excepted POPUP should be displayed:"+ popup_msg +" Actual POPUP not displayed:"+ error_msg);
			Extent_fail(driver,"Not matched ||Excepted POPUP should be displayed:"+ popup_msg +" Actual POPUP  not displayed:"+ error_msg, test, test1);
		}
		Step_End(3, "System validate that the system displays-> Port Pair or Customer is mismatched", test, test1);

		Extent_completed(tc_Name, test, test1);
	}
}
