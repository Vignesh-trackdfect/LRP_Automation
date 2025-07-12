package LRP_Booking_Scripts;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC022 extends Keywords {
	public void Booking_SC022(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC022";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String orgin = Excel_data.get("Orgin");
		String agencyUser = Excel_data.get("AgencyUser");

		//locators
		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);
		Extent_call(test, test1,"********** Switch the Profile  - End **********");
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

		waitForDisplay(driver, Rate_Grid);
		if(isdisplayed(driver, Rate_Grid)) {
			System.out.println("*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed");            
			Extent_pass_New(driver,"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			waitForElement(driver, RatedBtn);
			safeclick(driver, RatedBtn);
			Step_End(2, "Enter the POL and POD and select the Rates using Rates window.",test, test1);
			waitForElement(driver, $Rates);
			safeclick(driver, $Rates);
		} 

		Step_Start(3, "Click Rate button system list the Rates Details", test, test1);
		waitForElement(driver, Rates_Pol_Field);
		String Pol_Value = getAttribute(driver, Rates_Pol_Field, "value");
		if(orgin.equals(Pol_Value)) {
			System.out.println("Matched || " + " Expected POL Text Field Value : " + orgin + " || Actual POL Text Value : " + Pol_Value);            
			Extent_pass_New(driver, "Matched || " + " Expected POL Text Field Value : " + orgin + " || Actual POL Text Value : " + Pol_Value, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected POL Text Field Value : " + orgin + " || Actual POL Text Field Value : " + Pol_Value);        
			Extent_fail(driver, "Not Matched || " + " Expected POL Text Field Value : " + orgin + " || Actual POL Text Field Value : " + Pol_Value, test,test1); 
		} 
		waitForElement(driver, Rates_Pod_Field);
		String Pod_Value = getAttribute(driver, Rates_Pod_Field, "value");
		if(delivery.equals(Pod_Value)) {
			System.out.println("Matched || " + " Expected POD Text Field Value : " + delivery + " || Actual POD Text Field Value : " + Pod_Value);            
			Extent_pass_New(driver, "Matched || " + " Expected POD Text Field Value : " + delivery + " || Actual POD Text Field Value : " + Pod_Value, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected POD Text Field Value : " + delivery + " || Actual POD Text Field Value : " + Pod_Value);        
			Extent_fail(driver, "Not Matched || " + " Expected POD Text Field Value : " + delivery + " || Actual POD Text Field Value : " + Pod_Value, test,test1); 
		} 
		Step_End(3, "Click Rate button system list the Rates Details", test, test1);
		Extent_completed(test_Case_Name, test, test1);


	}
}
