package LRP_Booking_Scripts;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC027 extends Keywords{
	public void Booking_SC027(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC027";

		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String Search =Excel_data.get("Search_input");
		String delivery =Excel_data.get("Delivery");
		String Agt =Excel_data.get("AGR_Party");
		String orgin =Excel_data.get("Orgin");
		String agencyUser = Excel_data.get("AgencyUser");
		String Route_Window =Excel_data.get("Route_Window");


		//locators

		Extent_Start(test_Case_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);

		Extent_call(test, test1,"********** Switch the Profile  - End **********");

		System.out.println("********** Enter Booking Module **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		moduleNavigate(driver, Search);

		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);

		Step_Start(2, "Enter the POL and POD ",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		keyDown(driver);
		enter(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the POL and POD ",test, test1);

		Step_Start(3, "click Route button (EDIT) And validate the Rout Window", test, test1);
		waitForElement(driver, Routingedit);
		safeclick(driver, Routingedit);

		waitForElement(driver, Edit_Route_Window);
		String Actual_Window = getText(driver, Edit_Route_Window);
		if(Route_Window.equals(Actual_Window)) {
			System.out.println("Matched ||  Expected Window Heading is : " + Route_Window + " || Actual Window Heading is: " + Actual_Window);            
			Extent_pass_New(driver, "Matched ||  Expected Window Heading is : " + Route_Window + " || Actual Window Heading is " + Actual_Window, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched ||  Expected Window Heading is : " + Route_Window + " || Actual Window Heading is : " + Actual_Window);        
			Extent_fail(driver, "Not Matched ||  Expected Window Heading is : " + Route_Window + " || Actual Window Heading is : " + Actual_Window, test,test1); 
		} 
		Step_End(3, "click Route button (EDIT) And validate the Rout Window", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}

}
