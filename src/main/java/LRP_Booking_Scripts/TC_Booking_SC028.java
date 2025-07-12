package LRP_Booking_Scripts;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC028 extends Keywords {
	public void Booking_SC028(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC028";

		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String Search =Excel_data.get("Search_input");
		String delivery =Excel_data.get("Delivery");
		String Agt =Excel_data.get("AGR_Party");
		String orgin =Excel_data.get("Orgin");
		String agencyUser = Excel_data.get("AgencyUser");
		String Commodity_Chk_Box_Exp = Excel_data.get("Commodity_Chk_Box");
		String DG_Chk_Box_Exp = Excel_data.get("DG_Chk_Box");
		String Tar_Chk_Box_Exp = Excel_data.get("Tar_Chk_Box");
		String AFF_Chk_Box_Exp = Excel_data.get("AFF_Chk_Box");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String Service_Name = Excel_data.get("Service_Name");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		//locators
		String Edit_Select=String.format(Booking_Locators.Edit_Select,Service_Name);


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
		Extent_call(test, test1,"********** Select the Check Box in Rates Window **********");
		waitForElement(driver, Commodity_Chk_Box);
		checkBox(driver, Commodity_Chk_Box,Commodity_Chk_Box_Exp);
		waitForElement(driver, DG_Chk_Box);
		checkBox(driver, DG_Chk_Box,DG_Chk_Box_Exp);
		waitForElement(driver, Tar_Chk_Box);
		checkBox(driver, Tar_Chk_Box,Tar_Chk_Box_Exp);
		waitForElement(driver, AFF_Chk_Box);
		checkBox(driver, AFF_Chk_Box,AFF_Chk_Box_Exp);
		waitForElement(driver, Rates_Show_Btn);
		safeclick(driver, Rates_Show_Btn);
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);
		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);
		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		Step_End(2, "Enter the POL and POD and select the Rates using Rates window",test, test1);
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_Start(3, "click Route button (EDIT)", test, test1);
		waitForElement(driver, Routingedit);	
		safeclick(driver, Routingedit);
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			waitForElement(driver, popup_Message_Yes_Button);
			safeclick(driver, popup_Message_Yes_Button);
		}
		String routingedit1 = getText(driver, Edit_Route_Select);
		System.out.println(routingedit1);
		Step_End(3, "click Route button (EDIT)", test, test1);

		Step_Start(3, "Double click the Route details and Verify the Details", test, test1);
		waitForElement(driver, Edit_Select);
		String routingedit = getText(driver, Edit_Select);
		System.out.println(routingedit1);
		waitForElement(driver, Edit_Select);
		doubleClick(driver, Edit_Select);
		if(routingedit1.contains(routingedit)) {  
			System.out.println("Matched || [ Before Routing Window Selected Value is ] : " + routingedit1 + " || [ After editing the routing it was shows ] : " + routingedit);        
			Extent_pass_New(driver,"Matched || [ Before Routing Window Selected Value is ] : " + routingedit1 + " || [ After editing the routing it was shows ] : " + routingedit, test,test1); 
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Before Routing Window Selected Value is ] : " + routingedit1 + " || [ After editing the routing it was shows ] : " + routingedit);            
			Extent_fail(driver,"Not Matched || [ Before Routing Window Selected Value is ] : " + routingedit1 + " || [ After editing the routing it was shows ] : " + routingedit, test,test1);  
		} 
		Step_End(3, "Double click the Route details and Verify the Details", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}