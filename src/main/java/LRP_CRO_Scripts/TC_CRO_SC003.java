package LRP_CRO_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_CRO_SC003 extends Keywords {

	public void CRO_SC003(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC003";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String CRO_Tab = Excel_data.get("CRO_Tab");
		
		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);

		//	Switch the Profile
		SwitchProfile(driver, agencyUser);


		//		Booking module
		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
		

		//	Create CRO
		
		Step_Start(1, "Navigate CRO from booking screen..", test, test1);


		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		Step_End(1, "Navigate CRO from booking screen..", test, test1);
		
		
		Step_Start(2, "Check the schedule details in CRO.", test, test1);		
		waitForElement(driver, CRO_Tab_Verify);
		String Act_CRO_Tab = getText(driver, CRO_Tab_Verify);
		System.out.println("opened tab :" + Act_CRO_Tab);
		if(CRO_Tab.equals(Act_CRO_Tab)) {
			Extent_pass(driver,"Matched || Expected CRO Tab opened : "+CRO_Tab+" ||  Actual CRO Tab opened : "+ Act_CRO_Tab, test,test1);
			System.out.println("Matched || Expected CRO Tab opened : "+CRO_Tab+" || Actual CRO Tab opened: "+ Act_CRO_Tab);
		}else {
			System.out.println("Not Matched || Expected CRO Tab opened : "+CRO_Tab+" || Actual CRO Tab opened: "+ Act_CRO_Tab);
			Extent_fail(driver,"Not Matched || Expected CRO Tab opened : "+CRO_Tab+" || Actual CRO Tab opened: "+ Act_CRO_Tab, test,test1);
						
		}
		
		//booking deatils
		
		waitForElement(driver, Booking_Tab);
		click(driver, Booking_Tab);
		
		waitForElement(driver, BKG_Bound_Value);
		String Exp_Booking_Bound_Value = getText(driver, BKG_Bound_Value);
		System.out.println("view Bound value :" + Exp_Booking_Bound_Value);		


		waitForElement(driver, Booking_Servicecode);
		String Exp_Service = getAttribute(driver, Booking_Servicecode, "value");
		System.out.println("view service code :" + Exp_Service);
		
		waitForElement(driver, vessleValue);
		String Act_vessleValue = getText(driver, vessleValue);
		System.out.println("view  vessleValue  :" + Act_vessleValue);
		
		waitForElement(driver, Booking_Voyage);
		String Exp_voyageValue = getText(driver, Booking_Voyage);
		System.out.println("view Booking_Voyage :" + Exp_voyageValue);
		
		
		waitForElement(driver, Booking_POL);
		String Act_Booking_POL=getAttribute(driver, Booking_POL,"value");
		System.out.println("view Booking POL :" + Act_Booking_POL);
		

		waitForElement(driver, Booking_POD);
		String Act_Booking_POD=getAttribute(driver, Booking_POD,"value");
		System.out.println("view Booking_POD :" + Act_Booking_POD);
		
		
		waitForElement(driver, Booking_Origin);
		String Act_Booking_Origin = getText(driver, Booking_Origin);
		System.out.println("view Booking_Origin deatils :" + Act_Booking_Origin);
		
		waitForElement(driver, ETD_date);
		String Act_ETD_date = getText(driver, ETD_date);
		System.out.println("view ETD_date :" + Act_ETD_date);
		
		String[] Date = Act_ETD_date.split("-");
		String ETD_Date = Date[1];
		System.out.println("Splited view ETD_date :" + ETD_Date);
		
		waitForElement(driver, ETA_date);
		String Act_ETA_date = getText(driver, ETA_date);
		System.out.println("view ETA_date :" + Act_ETA_date);
		
		String[] Date1 = Act_ETA_date.split("-");
		String ETA_Date = Date1[1];
		System.out.println("Splited view ETD_date :" + ETA_Date);
		
		waitForElement(driver, CRO_Tab_Verify);
		click(driver, CRO_Tab_Verify);
	
		
		
		waitForElement(driver, CRO_Service);
		String Act_CRO_Service = getText(driver, CRO_Service);
		System.out.println("view CRO_Service :" + Act_CRO_Service);
		
		waitForElement(driver, CRO_Vessel);
		String Act_CRO_Vessel = getText(driver, CRO_Vessel);
		System.out.println("view CRO_Vessel :" + Act_CRO_Vessel);
		
		waitForElement(driver, CRO_Voyage);
		String Act_CRO_Voyage = getText(driver, CRO_Voyage);
		System.out.println("view CRO_Voyage :" + Act_CRO_Voyage);
		
		waitForElement(driver, CRO_Bound);
		String Act_CRO_Bound = getText(driver, CRO_Bound);
		System.out.println("view CRO_Bound :" + Act_CRO_Bound);
		
		
		
		waitForElement(driver, CRO_PLA);
		String Act_CRO_PLA = getText(driver, CRO_PLA);
		System.out.println("view CRO_PLA :" + Act_CRO_PLA);
		
		waitForElement(driver, CRO_POL);
		String Act_CRO_POL = getText(driver, CRO_POL);
		System.out.println("view CRO_POL :" + Act_CRO_POL);
		
		waitForElement(driver, CRO_POD);
		String Act_CRO_POD = getText(driver, CRO_POD);
		System.out.println("view CRO_POD :" + Act_CRO_POD);
		
		waitForElement(driver, CRO_PLD);
		String Act_CRO_PLD = getText(driver, CRO_PLD);
		System.out.println("view CRO_PLD :" + Act_CRO_PLD);
		
		waitForElement(driver, CRO_ETA);
		String Act_CRO_ETA = getText(driver, CRO_ETA);
		System.out.println("view CRO_ETA :" + Act_CRO_ETA);
		
		waitForElement(driver, CRO_ETD);
		String Act_CRO_ETD = getText(driver, CRO_ETD);
		System.out.println("view CRO_ETD :" + Act_CRO_ETD);
		
		int start = Act_Booking_POD.indexOf('(');
		int end = Act_Booking_POD.indexOf(')');

		String Booking_POD = "";
		if (start != -1 && end != -1 && start < end) {
			Booking_POD = Act_Booking_POD.substring(start + 1, end);
		}

		System.out.println("POD Value: "+ Booking_POD);
		
		
		int start1 = Act_Booking_POL.indexOf('(');
		int end1= Act_Booking_POL.indexOf(')');

		String Booking_POL = "";
		if (start1 != -1 && end1 != -1 && start1 < end) {
			Booking_POL = Act_Booking_POL.substring(start1 + 1, end);
		}

		System.out.println("POL Value: "+ Booking_POL);
		
		
		if(Exp_Service.equals(Act_CRO_Service)) {
			Extent_pass_New(driver, "Matched || Expected Result for service code (Booking) : "+Exp_Service+" || Actual Result for service code (CRO) : "+Act_CRO_Service, test,test1);
			System.out.println("Matched || Expected Result for service code (Booking): "+Exp_Service+" || Actual Result for service code (CRO) :"+Act_CRO_Service);
			
		}else {
			System.out.println(" Not Matched || Expected Result for service code (Booking) : "+Exp_Service+" || Actual Result for service code (CRO) :"+Act_CRO_Service);
			Extent_fail(driver, "Not Matched || Expected Result for service code (Booking) : "+Exp_Service+" || Actual Result for service code (CRO) : "+Act_CRO_Service, test,test1);
		}
		
		
		
		if(Exp_Booking_Bound_Value.equals(Act_CRO_Bound)) {
			Extent_pass_New(driver, "Matched || Expected Result for Bound value (Booking) : "+Exp_Booking_Bound_Value+" || Actual Result for Bound value (CRO) : "+Act_CRO_Bound, test,test1);
			System.out.println("Matched || Expected Result for Bound value (Booking): "+Exp_Booking_Bound_Value+" || Actual Result for Bound value (CRO) :"+Act_CRO_Bound);
			
		}else {
			System.out.println(" Not Matched || Expected Result for Bound value (Booking): "+Exp_Booking_Bound_Value+" || Actual Result for Bound value (CRO) :"+Act_CRO_Bound);
			Extent_fail(driver, "Not Matched || Expected Result for Bound value (Booking): "+Exp_Booking_Bound_Value+" || Actual Result for Bound value (CRO) :"+Act_CRO_Bound, test,test1);
		}
		
	
		if(Act_vessleValue.equals(Act_CRO_Vessel)) {
			Extent_pass_New(driver, "Matched || Expected Result for Vessel value (Booking): "+Act_CRO_Vessel+" || Actual Result for Vessel value (CRO) :"+Act_vessleValue, test,test1);
			System.out.println("Matched || Expected Result for Vessel value (Booking): "+Act_CRO_Vessel+" || Actual Result for Vessel value (CRO) :"+Act_vessleValue);
			
		}else {
			System.out.println(" Not Matched || Expected Result for Vessel value (Booking): "+Act_CRO_Vessel+" || Actual Result for Vessel value (CRO) :"+Act_vessleValue);
			Extent_fail(driver, "Not Matched || Expected Result for Vessel value (Booking): "+Act_CRO_Vessel+" || Actual Result for Vessel value (CRO) :"+Act_vessleValue, test,test1);
		}
		
		if(Exp_voyageValue.equals(Act_CRO_Voyage)) {
			Extent_pass_New(driver, "Matched || Expected Result for Voyage value (Booking): "+Exp_voyageValue+" || Actual Result for Voyage value (CRO) :"+Act_CRO_Voyage, test,test1);
			System.out.println("Matched || Expected Result for Voyage value (Booking): "+Exp_voyageValue+" || Actual Result for Voyage value (CRO) :"+Act_CRO_Voyage);
			
		}else {
			System.out.println(" Not Matched || Expected Result for Voyage value (Booking): "+Exp_voyageValue+" || Actual Result for Voyage value (CRO) :"+Act_CRO_Voyage);
			Extent_fail(driver, "Not Matched || Expected Result for Voyage value (Booking): "+Exp_voyageValue+" || Actual Result for Voyage value (CRO) :"+Act_CRO_Voyage, test,test1);
		}
		
		
		if(Booking_POL.contains(Act_CRO_POL)) {
			Extent_pass_New(driver, "Matched || Expected Result  for POL value (Booking): "+Booking_POL+" || Actual Result for POL value (CRO) :"+Act_CRO_POL, test,test1);
			System.out.println("Matched || Expected Result for POL value (Booking): "+Booking_POL+" || Actual Result for POL value (CRO) :"+Act_CRO_POL);
			
		}else {
			System.out.println(" Not Matched || Expected Result for POL value (Booking): "+Booking_POL+" || Actual Result for POL value (CRO) :"+Act_CRO_POL);
			Extent_fail(driver, "Not Matched || Expected Result for POL value (Booking): "+Booking_POL+" || Actual Result for POL value (CRO) :"+Act_CRO_POL, test,test1);
		}
		
		if(Booking_POD.equals(Act_CRO_POD)) {
			Extent_pass_New(driver, "Matched || Expected Result for POD value (Booking): "+Booking_POD+" || Actual Result for POD value (CRO) :"+Act_CRO_POD, test,test1);
			System.out.println("Matched || Expected Result for POD value (Booking): "+Booking_POD+" || Actual Result for POD value (CRO) :"+Act_CRO_POD);
			
		}else {
			System.out.println(" Not Matched || Expected Result for POD value (Booking): "+Booking_POD+" || Actual Result for POD value (CRO) :"+Act_CRO_POD);
			Extent_fail(driver, "Not Matched || Expected Result for POD value (Booking): "+Booking_POD+" || Actual Result for POD value (CRO) :"+Act_CRO_POD, test,test1);
		}
		
		if(Booking_POD.equals(Act_CRO_PLD)) {
			Extent_pass_New(driver, "Matched || Expected Result for PLD value (Booking): "+Booking_POD+" || Actual Result for PLD value (CRO) :"+Act_CRO_PLD, test,test1);
			System.out.println("Matched || Expected Result for PLD value (Booking): "+Booking_POD+" || Actual Result for PLD value (CRO) :"+Act_CRO_PLD);
			
		}else {
			System.out.println(" Not Matched || Expected Result for PLD value (Booking): "+Booking_POD+" || Actual Result for PLD value (CRO): "+Act_CRO_PLD);
			Extent_fail(driver, "Not Matched || Expected Result for PLD value (Booking): "+Booking_POD+" || Actual Result for PLD value (CRO) :"+Act_CRO_PLD, test,test1);
		}
		
		
				
//		if(ETA_Date.equals(Act_CRO_ETA)) {
//			Extent_pass_New(driver, "Matched || Expected Result for ETA date (Booking) : "+ETA_Date+" || Actual Result for ETA date (CRO) :"+Act_CRO_ETA, test,test1);
//			System.out.println("Matched || Expected Result for ETA date (Booking): "+ETA_Date+" || Actual Result for ETA date (CRO) :"+Act_CRO_ETA);
//			
//		}else {
//			System.out.println(" Not Matched || Expected Result for ETA date (Booking): "+ETA_Date+" || Actual Result for ETA date (CRO) :"+Act_CRO_ETA);
//			Extent_fail(driver, "Not Matched || Expected Result for ETA date (Booking): "+ETA_Date+" || Actual Result for ETA date (CRO) :"+Act_CRO_ETA, test,test1);
//		}
		
		if(ETD_Date.equals(Act_CRO_ETD)) {
			Extent_pass_New(driver, "Matched || Expected Result for ETD date (Booking): "+ETD_Date+" || Actual Result for ETD date (CRO) :"+Act_CRO_ETD, test,test1);
			System.out.println("Matched || Expected Result for ETD date (Booking): "+ETD_Date+" || Actual Result for ETD date (CRO) :"+Act_CRO_ETD);
			
		}else {
			System.out.println(" Not Matched || Expected Result for ETD date (Booking): "+ETD_Date+" || Actual Result for ETD date (CRO) :"+Act_CRO_ETD);
			Extent_fail(driver, "Not Matched || Expected Result for ETD date (Booking): "+ETD_Date+" || Actual Result for ETD date (CRO) :"+Act_CRO_ETD, test,test1);
		}
		
		Step_End(2, "Check the schedule details in CRO.", test, test1);
		
		Extent_completed(testCaseName, test, test1);
		
	}
	}
