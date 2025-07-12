package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC064 extends Keywords {

	///// Check whether in Booking,  system doesn't display submit and Countered status SRR Rates  and shown only approved SRR Rates(based on RDA plug in configuration true)

	public void Booking_SC064(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_Booking_SC064";

		//		Get data from excel sheet


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String bookingModule = Excel_data.get("ModuleBooking");
		String agencyUser = Excel_data.get("agencyUser");
		String delivery = Excel_data.get("Delivery");
		String origin = Excel_data.get("origin");
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String pluginStatusFalse = Excel_data.get("PluginStatusFalse");
		String pluginStatusTrue = Excel_data.get("PluginStatusTrue");
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");
		String approvedStatus = Excel_data.get("ApprovedStatus");
		String counteredStatus = Excel_data.get("CounteredStatus");
		String submitStatus = Excel_data.get("SubmitStatus");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);

		//	Switch the Profile
		SwitchProfile(driver, agencyUser);

		//		Plugin Configuration module

		Extent_cal(test, test1, "Plugin Configuration");
		Step_Start(1, "Set RDA plugin false", test, test1);

		//	For false condition of RDA plugin 

		//Instead of clicking the first module dropdown,this method select the module name by using excel test data		
			
		moduleNavigate(driver, pluginConfigurationModule);

		Extent_cal(test, test1, pluginConfigurationModule);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);
		String actualPluginID=getText(driver, searched_pluginId);
		if(actualPluginID.equals(pluginID)) {
			Extent_pass_New(driver, pluginID+" plugin ID is available", test,test1);
			System.out.println(pluginID+" plugin ID is available");

			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			formatLocatorClick(driver, pluginValue_Select, pluginStatusFalse);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			//   Verify Plugin Updated popup

			waitForPopup(driver,Popup_Message,pluginUpdatedPopup);
			String actualUpdatedPopup=getText(driver, Popup_Message);
			System.out.println("actualUpdatedPopup:"+actualUpdatedPopup);
			if(actualUpdatedPopup.contains(pluginUpdatedPopup)){
				System.out.println("Matched || Expected popup value is: " + pluginUpdatedPopup + "|| Actual Popup value is:" + actualUpdatedPopup);
				Extent_pass_New(driver, "Matched || Expected popup value is: " + pluginUpdatedPopup + "|| Actual Popup value is:" + actualUpdatedPopup, test,test1);
			} else {
				System.out.println("Not Matched || Expected popup value is: " + pluginUpdatedPopup + "|| Actual Popup value is:" + actualUpdatedPopup);
				Extent_fail(driver, "Not Matched || Expected popup value is: " + pluginUpdatedPopup + "|| Actual Popup value is:" + actualUpdatedPopup, test,test1);
			}
		}else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}

		Step_End(1, "Set RDA plugin false", test, test1);

		//Verify The SRR Rates Status In Booking Module
		Step_Start(2, "Verify The SRR Rates Status In Booking Module", test, test1);

		//	Booking module
		Extent_cal(test, test1, bookingModule);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
				moduleNavigate(driver, bookingModule);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		//	Verify Rate reference tab

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


		waitForElement(driver, statusMenu);
		click(driver, statusMenu);
		waitForElement(driver, grid_Filter);
		click(driver, grid_Filter);

		//		Verify  Approved status

		waitForElement(driver, rateRef_Status_Gridcell);
		String actualAppStatus=getText(driver, rateRef_Status_Gridcell);

		if(actualAppStatus.equals(approvedStatus)) {
			Extent_pass_New(driver,"Matched || Expected status : "+ approvedStatus +"|| Actual status : "+actualAppStatus, test,test1);
			System.out.println("Matched || Expected status : "+ approvedStatus +"|| Actual status : "+actualAppStatus);

			waitForElement(driver, approved_Checkbox);
			click(driver, approved_Checkbox);
		}else {
			System.out.println("Not Matched || Expected status : "+ approvedStatus +"|| Actual status : "+actualAppStatus);
			Extent_fail(driver,"Not Matched || Expected status : "+ approvedStatus +"|| Actual status : "+actualAppStatus, test,test1);
		}

		//		Verify  Countered status 

		waitForElement(driver, rateRef_Status_Gridcell);
		String actualCounterStatus=getText(driver, rateRef_Status_Gridcell);

		if(actualCounterStatus.equals(counteredStatus)) {
			Extent_pass_New(driver,"Matched || Expected status : "+ counteredStatus +"|| Actual status : "+actualCounterStatus, test,test1);
			System.out.println("Matched || Expected status : "+ counteredStatus +"|| Actual status : "+actualCounterStatus);

			waitForElement(driver, countered_Checkbox);
			click(driver, countered_Checkbox);
		}else {
			System.out.println("Not Matched || Expected status : "+ counteredStatus +"|| Actual status : "+actualCounterStatus);
			Extent_fail(driver,"Not Matched || Expected status : "+ counteredStatus +"|| Actual status : "+actualCounterStatus, test,test1);
		}

		//			Verify  Submit status 

		waitForElement(driver, rateRef_Status_Gridcell);
		String actualSubmitStatus=getText(driver, rateRef_Status_Gridcell);

		if(actualSubmitStatus.equals(submitStatus)) {
			Extent_pass_New(driver,"Matched || Expected status : "+ submitStatus +"|| Actual status : "+actualSubmitStatus, test,test1);
			System.out.println("Matched || Expected status : "+ submitStatus +"|| Actual status : "+actualSubmitStatus);
		}else {
			System.out.println("Not Matched || Expected status : "+ submitStatus +"|| Actual status : "+actualSubmitStatus);
			Extent_fail(driver,"Not Matched || Expected status : "+ submitStatus +"|| Actual status : "+actualSubmitStatus, test,test1);
		}
		waitForElement(driver, grid_Filter);
		click(driver, grid_Filter);
		waitForElement(driver, closeRateRef);
		click(driver, closeRateRef);

		waitForElement(driver, Module_Close);		
		click(driver, Module_Close);

		Step_End(2, "Verify The SRR Rates Status In Booking Module", test, test1);
		Step_Start(3, "Set RDA plugin True", test, test1);

		///For True condition of RDA Plugin

		Extent_cal(test, test1, pluginConfigurationModule);
		
		waitForElement(driver, pluginConfiguration_Tab);
		click(driver, pluginConfiguration_Tab);
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);
		String actualPluginID1=getText(driver, searched_pluginId);
		if(actualPluginID1.equals(pluginID)) {
			Extent_pass_New(driver, pluginID+" plugin ID is available", test,test1);
			System.out.println(pluginID+" plugin ID is available");

			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			String select_Status=String.format(pluginValue_Select, pluginStatusTrue);
			waitForElement(driver, select_Status);
			click(driver, select_Status);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			//   Verify Plugin Updated popup

			waitForPopup(driver,Popup_Message,pluginUpdatedPopup);
			String actualUpdatedPopup=getText(driver, Popup_Message);
			System.out.println("actualUpdatedPopup:"+actualUpdatedPopup);
			if(actualUpdatedPopup.contains(pluginUpdatedPopup)){
				System.out.println("Matched || Expected popup value is: " + pluginUpdatedPopup + "|| Actual Popup value is:" + actualUpdatedPopup);
				Extent_pass_New(driver, "Matched || Expected popup value is: " + pluginUpdatedPopup + "|| Actual Popup value is:" + actualUpdatedPopup, test,test1);
			} else {
				System.out.println("Not Matched || Expected popup value is: " + pluginUpdatedPopup + "|| Actual Popup value is:" + actualUpdatedPopup);
				Extent_fail(driver, "Not Matched || Expected popup value is: " + pluginUpdatedPopup + "|| Actual Popup value is:" + actualUpdatedPopup, test,test1);
			}
		}else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}

		Step_End(3, "Set RDA plugin True", test, test1);

		//	Verify The SRR Rates Status In Booking Module

		Step_Start(4, "Verify The SRR Rates Status In Booking Module", test, test1);

		//  Booking module
		Extent_cal(test, test1, "Booking");

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
				moduleNavigate(driver, bookingModule);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);


		// 		Verify Rare reference tab
		waitForDisplay(driver, Rate_Grid);
		if (isdisplayed(driver, Rate_Grid)) {
			System.out.println(
					"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed");
			Extent_pass_New(driver,
					"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed",
					test, test1);
		} else {
			waitForElement(driver, RatedBtn);
			safeclick(driver, RatedBtn);
			Step_End(2, "Enter the POL and POD and select the Rates using Rates window.", test, test1);
			waitForElement(driver, $Rates);
			safeclick(driver, $Rates);
		}
		waitForElement(driver, statusMenu);
		click(driver, statusMenu);
		waitForElement(driver, grid_Filter);
		click(driver, grid_Filter);

		//			Verify  Approved status
		waitForElement(driver, rateRef_Status_Gridcell);
		String actualApproveStatus=getText(driver, rateRef_Status_Gridcell);

		if(actualApproveStatus.equals(approvedStatus)) {
			Extent_pass_New(driver,"Matched || Expected status : "+ approvedStatus +"|| Actual status : "+actualApproveStatus, test,test1);
			System.out.println("Matched || Expected status : "+ approvedStatus +"|| Actual status : "+actualApproveStatus);
			waitForElement(driver, approved_Checkbox);
			click(driver, approved_Checkbox);
		}else {
			System.out.println("Not Matched || Expected status : "+ approvedStatus +"|| Actual status : "+actualApproveStatus);
			Extent_fail(driver,"Not Matched || Expected status : "+ approvedStatus +"|| Actual status : "+actualApproveStatus, test,test1);
		}

		waitForDisplay(driver, rateRef_Status_Gridcell);
		if(!isdisplayed(driver, rateRef_Status_Gridcell)) {
			Extent_pass_New(driver, "Matched || The Expected Result is : Submit & Countered SRR Status Should Not Display || The Actual Result is : Submit & Countered SRR Status Not Displayed", test,test1);
			System.out.println("Matched || The Expected Result is : Submit & Countered SRR Status Should Not Display || The Actual Result is : Submit & Countered SRR Status Not Displayed");
		}else {
			System.out.println("Not Matched || The Expected Result is : Submit & Countered SRR Status Should Not Display || The Actual Result is : Submit & Countered SRR Status Not Displayed");
			Extent_fail(driver,"Not Matched || The Expected Result is : Submit & Countered SRR Status Should Not Display || The Actual Result is : Submit & Countered SRR Status Not Displayed", test,test1);
		}

		waitForElement(driver, grid_Filter);
		click(driver, grid_Filter);
		waitForElement(driver, closeRateRef);
		click(driver, closeRateRef);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);

		Step_End(4, "Verify The SRR Rates Status In Booking Module", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}
