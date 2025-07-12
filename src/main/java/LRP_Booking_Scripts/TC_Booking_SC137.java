package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


//Check whether in Booking, while select Non -containerized shipment non containerized and non containreized tab enabled
public class TC_Booking_SC137 extends Keywords {

	public void Booking_SC137(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Booking_SC137";

		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ship_opt = Excel_data.get("ship_opt");
		String ship_opt_C = Excel_data.get("ship_opt_C");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		String Shipment_Select = String.format(BKGshipmentType, ship_opt_C);
		String ship_type = String.format(BKGshipmentType, ship_opt);

		// Login
		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyUser);

		// Module search

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, Search);
		
		//	Booking module

		// select the shipment type

		waitForElement(driver, Shipment_Type);
		safeclick(driver, Shipment_Type);

		waitForElement(driver, Shipment_Select);
		safeclick(driver, Shipment_Select);

		waitForDisplay(driver, nonContainerized_Tab);

		if(!isdisplayed(driver, nonContainerized_Tab) && !isdisplayed(driver, non_Containerized_Detail_Tab)) {
			
			System.out.println("*The Expected Result is : System not enable non contianerized and non containerized detail tab || The Actual Result is : System not enable non contianerized and non containerized detail tab");            
			Extent_pass_New(driver,"*The Expected Result is : System not enable non contianerized and non containerized detail tab || The Actual Result is : System not enable non contianerized and non containerized detail tab", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : System not enable non contianerized and non containerized detail tab || The Actual Result is : System enable non contianerized and non containerized detail tab");        
			Extent_fail(driver, "*The Expected Result is : System not enable non contianerized and non containerized detail tab || The Actual Result is : System enable non contianerized and non containerized detail tab", test,test1); 
		
		}
		

		Step_Start(1, "Select the Noncontainerized shipment type in Booking Module ", test, test1);

		waitForElement(driver, Shipment_Type);
		click(driver, Shipment_Type);
		click(driver, ship_type);

		waitForDisplay(driver, nonContainerized_Tab);

		Step_End(1, "Select the Noncontainerized shipment type in Booking Module ", test, test1);

		Step_Start(2, "System enable non contianerized and non containerized detail tab", test, test1);

		if(isdisplayed(driver, nonContainerized_Tab) && isdisplayed(driver, non_Containerized_Detail_Tab)) {
			
			Extent_pass_New(driver, "Matched || Expected Result is : System enabled non contianerized and non containerized detail tab || Actual Result is : System enabled non contianerized and non containerized detail tab", test, test1);
			System.out.println("Matched || Expected Result is : System enabled non contianerized and non containerized detail tab || Actual Result is :System enabled non contianerized and non containerized detail tab");
		}else {
			System.out.println("Not Matched || Expected Result is :System enabled non contianerized and non containerized detail tab || Actual Result is : System NOT enabled non contianerized and non containerized detail tab");
			Extent_fail(driver,"Not Matched || Expected Result is :System enabled non contianerized and non containerized detail tab || Actual Result is : System NOT  enabled non contianerized and non containerized detail tab", test, test1);
		}
		
			
		Step_End(2, "System enable non contianerized and non containerized detail tab", test, test1);
		Extent_completed(testCaseName, test, test1);


	}
}