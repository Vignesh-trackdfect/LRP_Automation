package LRP_Booking_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC106 extends Keywords {
	// check whetherin booking, based on BLF global configuration value - then system not allowed different Loadbound and discharge bound in booking

	public void Booking_SC106(WebDriver driver, ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Booking_SC106";

		// Get data from Excel sheet

		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String bookingModule = Excel_data.get("Module_Search");
		String agencyUser = Excel_data.get("agencyUser");
		String agr_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput1 = Excel_data.get("Boundinput1");
		String globalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String globalAttribute = Excel_data.get("GlobalAttribute");
		String feederScheduleModule = Excel_data.get("FeederScheduleModule");
		String vesselCode = Excel_data.get("VesselCode");
		String globalValue = Excel_data.get("GlobalValue");
		String search_by_condition = Excel_data.get("search_by_condition");	
		String select_by_service_code = Excel_data.get("select_by_service_code");	
		String select_by_vesselcode = Excel_data.get("select_by_vesselcode");	
		String select_by_voyage = Excel_data.get("select_by_voyage");	
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);
		
		
// Login
		LRP_Login(driver, username, password);

//	Switch the Profile
		SwitchProfile(driver, agencyUser);

		// Global configuration
		Extent_cal(test, test1, globalConfigurationModule);

		Step_Start(1, "Set BLF Global Configuration as - ", test, test1);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data	
		
		setGlobalConfiguration(driver, globalConfigurationModule, globalAttribute, globalValue);
		
		
		
		
		Step_End(1, "Set BLF Global Configuration as - ", test, test1);

//		Feeder schedule
		Extent_cal(test, test1, feederScheduleModule);
			Step_Start(2, "Check the Origin & Delivery in Feeder Schedule ", test, test1);
			
			//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
			
			moduleNavigate(driver, feederScheduleModule);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, search_by_condition, select_by_service_code, first_service_data, select_by_vesselcode, vesselCode, select_by_voyage, Voyagenumber1);

			
			waitForElement(driver, ETA_arr_date);

			ArrayList<String> portCodes_FeederSchedule=new ArrayList<String>();
			List<WebElement> portCodes_Feeder=listOfElements(driver, feeder_Schedule_Ports);
			for(WebElement portText:portCodes_Feeder ) {
				String actPorts=portText.getText();
				portCodes_FeederSchedule.add(actPorts);
			}
			
			waitForElement(driver, ETA_arr_date);
			String eta_ArrDate=getText(driver, ETA_arr_date);
			
			
			System.out.println("portCodes_FeederSchedule:"+portCodes_FeederSchedule);
			Extent_pass_New(driver, "Origin and Delivery location in Feeeder Schedule :"+portCodes_FeederSchedule, test, test1);
		
			Step_End(2, "Check the Origin & Delivery in Feeder Schedule ", test, test1);

		// Enter the module name in search box and open that module

			//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
			
			moduleNavigate(driver, bookingModule);
			
		// Booking module
		Extent_cal(test, test1, bookingModule);
		Step_Start(3, "Check the Origin & Delivery in Booking ", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, agr_party);
		tab(driver);
		
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		ArrayList<String> portCodes_Booking=new ArrayList<String>();
		
		portCodes_Booking.add(origin);
		portCodes_Booking.add(delivery);
		
		System.out.println("portCodes_Booking:"+portCodes_Booking);
		Extent_pass_New(driver, "Origin and Delivery location in Booking :"+portCodes_Booking, test, test1);
		
	
		Step_End(3, "Check the Origin & Delivery in Booking ", test, test1);
		Step_Start(4, "Select the Routing & Select the Schedule", test, test1);
		
		// Rates
	
			bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput1);
			
		Step_End(4, "Select the Routing & Select the Schedule", test, test1);
		Step_Start(5, "Verify the Load Voyage & Discharge Voyage should be different in Booking Leg tab", test, test1);
		
		waitForElement(driver, bookingLeg_Tab);
		click(driver, bookingLeg_Tab);
		
		waitForDisplay(driver, load_Voyage);
		if(isDisplayed(driver, load_Voyage)) {
			
			Extent_pass_New(driver, "Booking leg table details are displayed", test, test1);
			System.out.println("Booking leg table details are displayed");
			
			String pod_ETA_LegTab=getText(driver, eta_Date_LegTab);
			String loadVoyage=getText(driver, load_Voyage);
			String dischargeVoyage=getText(driver, discharge_Voyage);
			
			if(loadVoyage.equals(dischargeVoyage) && pod_ETA_LegTab.equals(eta_ArrDate)) {
				Extent_pass_New(driver, "Matched ||Expected ETA Date in Feeder Schedule: "+eta_ArrDate+" ||Actual ETA Date in Booking Leg Tab: "+pod_ETA_LegTab, test, test1);
				System.out.println("Matched || Expected ETA Date in Feeder Schedule: "+eta_ArrDate+" ||Actual  ETA Date in Booking Leg Tab: "+pod_ETA_LegTab);

				Extent_pass_New(driver, " Matched || Expected Load Voyage : "+loadVoyage + " ||Actual Discharge Voyage : "+dischargeVoyage, test, test1);
				System.out.println(" Matched || Expected Load Voyage : "+loadVoyage + " ||Actual Discharge Voyage : "+dischargeVoyage);
				
			}else {
				System.out.println(" Not Matched || Expected Load Voyage : "+loadVoyage + " || Actual Discharge Voyage : "+dischargeVoyage);
				System.out.println("Expected ETA Date in Feeder Schedule: "+eta_ArrDate+" || Actual ETA Date in Booking Leg Tab: "+pod_ETA_LegTab);
				Extent_fail(driver, " Not Matched || Expected Load Voyage : "+loadVoyage + " || Actual Discharge Voyage : "+dischargeVoyage+"<br>"+"ETA Date in Feeder Schedule: "+eta_ArrDate+" || ETA Date in Booking Leg Tab: "+pod_ETA_LegTab, test, test1);

			}
		}else {
			
			Extent_fail(driver, "Booking leg table details are not displayed", test, test1);
			System.out.println("Booking leg table details are not displayed");
		}
		Step_End(5, "Verify the Load Voyage & Discharge Voyage should be different in Booking Leg tab", test, test1);
		
	
		Extent_completed(testCaseName, test, test1);
	}
}
