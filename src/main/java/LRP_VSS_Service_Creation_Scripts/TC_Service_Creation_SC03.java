package LRP_VSS_Service_Creation_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



//  Check whether the system shows pop up validation when the user doesnt provide values in the fields 
public class TC_Service_Creation_SC03 extends Keywords {

	public void  Service_Creation_SC03(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
//	Get data from excel sheet
		String tc_name="TC_Service_Creation_SC03";

		
		String Username = Excel_data.get("Username");
        String Password = Excel_data.get("Password");
        String ModuleSearch = Excel_data.get("Module_Search");
        String Frequ = Excel_data.get("Frequency");
		String service_Code = Excel_data.get("Service_Code");
		String service_Name = Excel_data.get("Service_Name");
		String noOfBound = Excel_data.get("NoOfBound");
		String serviceType = Excel_data.get("ServiceType");
		String pnl_ServiceType = Excel_data.get("PNL_ServiceType");
		String serviceCodePopup = Excel_data.get("ServiceCodePopup");
		String serviceNamePopup = Excel_data.get("ServiceNamePopup");
		String noOfBoundPopup = Excel_data.get("NoOfBoundPopup");
		String serviceTypePopup = Excel_data.get("ServiceTypePopup");
		String frequencyPopup = Excel_data.get("FrequencyPopup");
		String shipsGreaterThanZeroPopup = Excel_data.get("ShipsGreaterThanZeroPopup");
		
		
		Extent_Start(tc_name, test, test1);

		navigateUrl(driver, url);
//	Login
		
		LRP_Login(driver, Username, Password);
		
		moduleNavigate(driver, ModuleSearch);
		
		
//	Service Creation
		
		Step_Start(1, " Click on the new button in the toolbar",test, test1);

		newButton(driver);
	
		Step_End(1, "Click on the new button in the toolbar",test, test1);
		
		Step_Start(2, " Click on Save button without entering the value in the Service Code field ",test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(2, "Click on Save button without entering the value in the Service Code field ",test, test1);
		Step_Start(3, "System should show validation pop up as **Enter the Service Code** ",test, test1);

		waitForPopup(driver, popup_Message, serviceCodePopup);
		String actualServiceCodePopup=getText(driver, popup_Message);
		if(actualServiceCodePopup.equals(serviceCodePopup)) {
			Extent_pass_New(driver, "Matched || Expected Popup :"+serviceCodePopup+" || Actual Popup :"+actualServiceCodePopup, test, test1);
			System.out.println("Matched || Expected Popup :"+serviceCodePopup+" || Actual Popup :"+actualServiceCodePopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Popup :"+serviceCodePopup+" || Actual Popup :"+actualServiceCodePopup);
			Extent_fail(driver, "Not Matched || Expected Popup :"+serviceCodePopup+" || Actual Popup :"+actualServiceCodePopup, test, test1);
		}
		
		Step_End(3, "System should show validation pop up as **Enter the Service Code** ",test, test1);
		
//	Invalid input for Service code 
		
		waitForElement(driver, Service_CodeI);		
		System.out.println("Service Code " + service_Code);
		click(driver, Service_CodeI);
		waitForElement(driver, Service_CodeI);		
		sendKeys(driver, Service_CodeI, service_Code);
		
		Step_Start(4, "  Click on Save button without entering the value in the Service Name field ",test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(4, " Click on Save button without entering the value in the Service Name field ",test, test1);
		Step_Start(5, "System should show validation pop up as-> **Enter the Service Name** ",test, test1);

		waitForPopup(driver, popup_Message, serviceNamePopup);
		String actualServiceNamePopup=getText(driver, popup_Message);
		if(actualServiceNamePopup.equals(serviceNamePopup)) {
			Extent_pass_New(driver, "Matched || Expected Popup :"+serviceNamePopup+" || Actual Popup :"+actualServiceNamePopup, test, test1);
			System.out.println("Matched || Expected Popup :"+serviceNamePopup+" || Actual Popup :"+actualServiceNamePopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Popup :"+serviceNamePopup+" || Actual Popup :"+actualServiceNamePopup);
			Extent_fail(driver, "Not Matched || Expected Popup :"+serviceNamePopup+" || Actual Popup :"+actualServiceNamePopup, test, test1);
		}
		
		Step_End(5, "System should show validation pop up as ->**Enter the Service Name**", test, test1);
		
		waitForElement(driver, Service_NameI);
		System.out.println("Service Name " + service_Name);
		sendKeys(driver, Service_NameI, service_Name);
		
		Step_Start(6, "Click on Save button without Choosing  the value in No.of Bound field ", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(6, "Click on Save button without Choosing  the value in No.of Bound field ", test, test1);
		
		Step_Start(7, " System should show validation pop up as ->Enter the Bound ", test, test1);
		
		waitForPopup(driver, popup_Message, noOfBoundPopup);
		String actualNoOfBoundPopup=getText(driver, popup_Message);
		if(actualNoOfBoundPopup.equals(noOfBoundPopup)) {
			Extent_pass_New(driver, "Matched || Expected Popup :"+noOfBoundPopup+" || Actual Popup :"+actualNoOfBoundPopup, test, test1);
			System.out.println("Matched || Expected Popup :"+noOfBoundPopup+" || Actual Popup :"+actualNoOfBoundPopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Popup :"+noOfBoundPopup+" || Actual Popup :"+actualNoOfBoundPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :"+noOfBoundPopup+" || Actual Popup :"+actualNoOfBoundPopup, test, test1);
		}
		
		Step_End(7, " System should show validation pop up as ->Enter the Bound ", test, test1);
		
		waitForElement(driver,No_of_Bound);
		click(driver,No_of_Bound);
		
		String selectBound=String.format(DropDown_Select, noOfBound);
		
		waitForElement(driver,selectBound);
		click(driver, selectBound);

		if(!pnl_ServiceType.equals("")) {
			waitForElement(driver,pnlServiceType );
			click(driver,pnlServiceType);
			
			String selectPNL_Service_type=String.format(DropDown_Select, pnl_ServiceType);
			
			waitForElement(driver, selectPNL_Service_type);
			click(driver, selectPNL_Service_type);

			}
		
		Step_Start(8, "Click on Save button without Choosing the value in the Service Type field ", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(8, "Click on Save button without Choosing the value in the Service Type field ", test, test1);
		Step_Start(9, "System should show validation pop up as ->Enter the Service Type", test, test1);
	
		waitForPopup(driver, popup_Message, serviceTypePopup);
		String actualSizeTypePopup=getText(driver, popup_Message);
		if(actualSizeTypePopup.equals(serviceTypePopup)) {
			Extent_pass_New(driver, "Matched || Expected Popup :"+serviceTypePopup+" || Actual Popup :"+actualSizeTypePopup, test, test1);
			System.out.println("Matched || Expected Popup :"+serviceTypePopup+" || Actual Popup :"+actualSizeTypePopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Popup :"+serviceTypePopup+" || Actual Popup :"+actualSizeTypePopup);
			Extent_fail(driver, "Not Matched || Expected Popup :"+serviceTypePopup+" || Actual Popup :"+actualSizeTypePopup, test, test1);
		}
		Step_End(9, "System should show validation pop up as ->Enter the Service Type", test, test1);
		
		waitForElement(driver,Service_Type);
		click(driver,Service_Type);
		
		String select_Service=String.format(DropDown_Select, serviceType);
		waitForElement(driver, select_Service);
		click(driver, select_Service);

		
		Step_Start(10, "Click on Save button without entering the value in the Frequency field ", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(10, "Click on Save button without entering the value in the Frequency field ", test, test1);
		Step_Start(11, " System should show validation pop up as ->Enter the Frequency", test, test1);
		
		waitForPopup(driver, popup_Message, frequencyPopup);
		String actualFrequencyPopup=getText(driver, popup_Message);
		if(actualFrequencyPopup.equals(frequencyPopup)) {
			Extent_pass_New(driver, "Matched || Expected Popup :"+frequencyPopup+" || Actual Popup :"+actualFrequencyPopup, test, test1);
			System.out.println("Matched || Expected Popup :"+frequencyPopup+" || Actual Popup :"+actualFrequencyPopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Popup :"+frequencyPopup+" || Actual Popup :"+actualFrequencyPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :"+frequencyPopup+" || Actual Popup :"+actualFrequencyPopup, test, test1);
		}
		
		Step_End(11, " System should show validation pop up as ->Enter the Frequency", test, test1);
	
		waitForElement(driver, Freqency);
		doubleClick(driver, frequency_Textfield);
		new Actions(driver).sendKeys(Frequ).perform();

		Step_Start(12, "Click on Save button without entering the value in the No.of Ships field ", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(12, "Click on Save button without entering the value in the No.of Ships field ", test, test1);
		
		Step_Start(13, "System should show validation pop up as ->Enter the No.of Ships ", test, test1);
	
		waitForPopup(driver, popup_Message, shipsGreaterThanZeroPopup);
		String actualshipsGreaterThanZeroPopup=getText(driver, popup_Message);
		if(actualshipsGreaterThanZeroPopup.equals(shipsGreaterThanZeroPopup)) {
			Extent_pass_New(driver, "Matched || Expected Popup :"+shipsGreaterThanZeroPopup+" || Actual Popup :"+actualshipsGreaterThanZeroPopup, test, test1);
			System.out.println("Matched || Expected Popup :"+shipsGreaterThanZeroPopup+" || Actual Popup :"+actualshipsGreaterThanZeroPopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Popup :"+shipsGreaterThanZeroPopup+" || Actual Popup :"+actualshipsGreaterThanZeroPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :"+shipsGreaterThanZeroPopup+" || Actual Popup :"+actualshipsGreaterThanZeroPopup, test, test1);
		}
		
		Step_End(13, "System should show validation pop up as ->Enter the No.of Ships ", test, test1);
			Extent_completed(tc_name, test, test1);

		
	}
		
}
