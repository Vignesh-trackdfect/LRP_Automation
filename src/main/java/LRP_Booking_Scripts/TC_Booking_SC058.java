package LRP_Booking_Scripts;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC058 extends Keywords {
	public void Booking_SC058(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC058";

		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String search_module =Excel_data.get("Search_input");
		String delivery =Excel_data.get("Delivery");
		String Agt =Excel_data.get("AGR_Party");
		String orgin =Excel_data.get("Orgin");
		String agencyUser = Excel_data.get("AgencyUser");
		String Service_Name = Excel_data.get("Service_Name");

		//locators
		String Edit_Select=String.format(Booking_Locators.Edit_Select,Service_Name);

		Extent_Start(test_Case_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);

		Extent_call(test, test1,"********** Switch the Profile  - End **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
				moduleNavigate(driver, search_module);

		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);

		Step_Start(2, "Enter the POL and POD",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		keyboardArrowDown(driver);

		enter(driver);

		waitForElement(driver, DeliveryInput);
		safeclick(driver, DeliveryInput);
		clearAndType(driver, DeliveryInput, delivery);
		keyboardArrowDown(driver);
		enter(driver);
		Step_End(2, "Enter the POL and POD",test, test1);

		Step_Start(3, "click Route button (EDIT) and verify the Details", test, test1);
		waitForElement(driver, Routingedit);	
		safeclick(driver, Routingedit);
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			waitForElement(driver, popup_Message_Yes_Button);
			safeclick(driver, popup_Message_Yes_Button);
		}
		waitForElement(driver, Edit_Select);
		String routingedit1 = getText(driver, Edit_Select);
		System.out.println(routingedit1);
		waitForElement(driver, Edit_Select);
		doubleClick(driver, Edit_Select);
		Step_End(3, "click Route button (EDIT) and verify the Details", test, test1);

		Step_Start(4,"Verify the Service name value",test, test1);
		waitForElement(driver, FirstserviceInput);
		String routingedit = getAttribute(driver, FirstserviceInput,"value");
		if(routingedit1.contains(routingedit)) {  
			System.out.println(" Matched || " + "[Before Routing Window Selected Value is] : " + routingedit1 + " || [After editing the routing the service text field was shows] : " + routingedit);        
			Extent_pass_New(driver, "Matched || " + "[Before Routing Window Selected Value is] : " + routingedit1 + " || [After editing the routing the service text field was shows]: " + routingedit, test,test1); 
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + "  [Before Routing Window Selected Value is]: " + routingedit1 + " || [After editing the routing the service text field was shows] : " + routingedit);            
			Extent_fail(driver, "Not Matched || " + " [Before Routing Window Selected Value is] : " + routingedit1 + " ||  [After editing the routing the service text field was shows] : " + routingedit, test,test1);  
		} 
		waitForDisplay(driver, popup_Message);		
		if(isdisplayed(driver,popup_Message)) {
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
		}
		Step_End(4,"Verify the Service name value",test, test1);
		Extent_completed(test_Case_Name,test, test1);


	}
}
