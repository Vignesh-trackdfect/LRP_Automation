package LRP_VSS_Service_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Service_Creation_SC06 extends Keywords {
	
//	Deleting an Record

	public void Service_Creation_SC06(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
//		Get data from excel sheet
		
		String tc_name="TC_Service_Creation_SC06";

		
		       		
		String Username = Excel_data.get("Username");
        String Password = Excel_data.get("Password");
        String ModuleSearch = Excel_data.get("Module_Search");
		String retriveService_Code = Excel_data.get("RetrieveService_Code");
		String retrieveServiceName = Excel_data.get("RetrieveServiceName");
		String wantToDeletePopup = Excel_data.get("WantToDeletePopup");
		String usedServiceCode = Excel_data.get("UsedServiceCode");
		String usedServiceName = Excel_data.get("UsedServiceName");
		String deletedPopup = Excel_data.get("DeletedPopup");
		String alreadyUsedPopup = Excel_data.get("AlreadyUsedPopup");
		
		
		Extent_Start(tc_name, test, test1);

		navigateUrl(driver, url);
		
		// Login page
		
		LRP_Login(driver, Username, Password);
		
		moduleNavigate(driver, ModuleSearch);
		

		// Service creation
		
		waitForElement(driver, agGrid_Filter);
		click(driver, agGrid_Filter);
		waitForElement(driver, condition_Filter_AG_Grid_SER);
		click(driver, condition_Filter_AG_Grid_SER);
		waitForElement(driver, serviceCode_FilterSearch);
		click(driver, serviceCode_FilterSearch);
		waitForElement(driver, serviceCode_FilterSearch);
		sendKeys(driver, serviceCode_FilterSearch, retriveService_Code);
		
		waitForElement(driver, serviceName_FilterSearch);
		click(driver, serviceName_FilterSearch);
		waitForElement(driver, serviceName_FilterSearch);
		sendKeys(driver, serviceName_FilterSearch, retrieveServiceName); 
		
		waitForElement(driver, select_ServiceCode);
		String actualServiceCode = getText(driver, select_ServiceCode);
		Step_Start(1, "Double Click on the Service Record",test, test1);
		if (actualServiceCode.equalsIgnoreCase(retriveService_Code)) {
			System.out.println("Matched || " + " Expected Service code : " + retriveService_Code + " || Actual Service code : " + actualServiceCode);
			Extent_pass_New(driver,"Matched || " + " Expected Service code : " + retriveService_Code + " || Actual Service code : " + actualServiceCode,test,test1);
			doubleClick(driver, select_ServiceCode);
		
		} else {
			System.out.println("Not matched || " + " Expected Service code : " + retriveService_Code + " || Actual Service code : " + actualServiceCode);
			Extent_fail(driver,"Not matched || " + " Expected Service code : " + retriveService_Code + " || Actual Service code : " + actualServiceCode,test,test1);
		}
		
		
		Step_End(1, "Double Click on the Service Record",test, test1);

//Delete service
		// For No
		
		Step_Start(2, "Click on the Delete icon from the toolbar ",test, test1);
		scrollTop(driver);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);

		Step_End(2, "Click on the Delete icon from the toolbar ",test, test1);
		
		Step_Start(3, "System should pop up a message of ,Do you want to permanently delete",test, test1);

		waitForPopup(driver, popup_Message, wantToDeletePopup);

		String deletPopupAct1 = getText(driver, popup_Message);
		System.out.println(deletPopupAct1);

		if (deletPopupAct1.equals(wantToDeletePopup)) {
			System.out.println("Matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual  Popup : "+ deletPopupAct1);
			Extent_pass_New(driver, "Matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual Popup : "+ deletPopupAct1, test, test1);
			click(driver, popup_Message_No_Button);

		} else {
			System.out.println("Not matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual  Popup : "+ deletPopupAct1);
			Extent_fail(driver, "Not matched || " + " Expected  Popup : " + wantToDeletePopup+ " || Actual  Popup : " + deletPopupAct1, test, test1);
		}
		
		Step_End(3, "System should pop up a message of ,Do you want to permanently delete",test, test1);

		Step_Start(4, "Clicking on No should close the pop up message ",test, test1);

		waitForDisplay(driver, popup_Message);
		if(!isdisplayed(driver, popup_Message)) {		
			Extent_pass_New(driver, wantToDeletePopup + " poppup is closed", test, test1);
			System.out.println(wantToDeletePopup + " poppup is closed");
		} else {	
			System.out.println(wantToDeletePopup + " poppup is not closed");

			Extent_fail(driver, wantToDeletePopup + " poppup is not closed", test, test1);
		}
		 
		Step_End(4, "Clicking on No should close the pop up message ",test, test1);

// For Yes
		scrollTop(driver);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);

		waitForPopup(driver, popup_Message, wantToDeletePopup);

		String deletPopupAct2 = getText(driver, popup_Message);
		if (deletPopupAct2.equals(wantToDeletePopup)) {
			System.out.println("Matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual  Popup : "+ deletPopupAct2);
			Extent_pass_New(driver, "Matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual Popup : "+ deletPopupAct2, test, test1);
			click(driver, popup_Message_Yes_Button);

		} else {
			System.out.println("Not matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual  Popup : "+ deletPopupAct2);
			Extent_fail(driver, "Not matched || " + " Expected  Popup : " + wantToDeletePopup+ " || Actual  Popup : " + deletPopupAct2, test, test1);
		}
		
		Step_Start(5, "Clicking on Yes should remove the record from the grid ",test, test1);

		
		waitForPopup(driver, popup_Message, deletedPopup);
		String actualDeletedPopup = getText(driver, popup_Message);
		if (actualDeletedPopup.equals(deletedPopup)) {
			System.out.println("Matched || " + " Expected  Popup : " + deletedPopup + " || Actual  Popup : "+ actualDeletedPopup);
			Extent_pass_New(driver, "Matched || " + " Expected  Popup : " + deletedPopup + " || Actual Popup : "+ actualDeletedPopup, test, test1);
			click(driver, popup_Message_Ok_Button);
			Extent_pass_New(driver, "Record is removed ", test, test1);

		} else {
			System.out.println("Not matched || " + " Expected  Popup : " + deletedPopup + " || Actual  Popup : "+ actualDeletedPopup);
			Extent_fail(driver, "Not matched || " + " Expected  Popup : " + deletedPopup+ " || Actual  Popup : " + actualDeletedPopup, test, test1);
		}
		
		Step_End(5, "Clicking on No should close the pop up message ",test, test1);

		
//Already Used Popup
		

		waitForElement(driver, agGrid_Filter);
		click(driver, agGrid_Filter);
		waitForElement(driver, condition_Filter_AG_Grid_SER);
		click(driver, condition_Filter_AG_Grid_SER);
		waitForElement(driver, serviceCode_FilterSearch);
		click(driver, serviceCode_FilterSearch);
		waitForElement(driver, serviceCode_FilterSearch);

		sendKeys(driver, serviceCode_FilterSearch, usedServiceCode);
		
		if(!usedServiceName.equals("")) {
		click(driver, serviceName_FilterSearch);
		waitForElement(driver, serviceName_FilterSearch);
		sendKeys(driver, serviceName_FilterSearch,usedServiceName); 
		}
		
		Step_Start(6, "Select Service code",test, test1);

		waitForElement(driver, select_ServiceCode);
		String actualUsedServiceCode = getText(driver, select_ServiceCode);
		

		if (actualUsedServiceCode.equalsIgnoreCase(usedServiceCode)) {
			System.out.println("Matched || " + " Expected Service code : " + usedServiceCode + " || Actual Service code : " + actualUsedServiceCode);
			Extent_pass_New(driver,"Matched || " + " Expected Service code : " + usedServiceCode + " || ActualService code : " + actualUsedServiceCode,test,test1);
			doubleClick(driver, select_ServiceCode);

			
		} else {
			System.out.println("Not matched || " + " Expected Service code : " + usedServiceCode + " || Actual Service code  : " + actualUsedServiceCode);
			Extent_fail(driver,"Not matched || " + " Expected Service code : " + usedServiceCode + " || Actual Service code : " + actualUsedServiceCode,test,test1);
		}
		
		Step_End(6, "Select Service code",test, test1);
		
		
		Step_Start(6, "Click on delete button",test, test1);
		scrollTop(driver);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		
		Step_End(6, "Click on delete button",test, test1);

		
		
		Step_Start(7, "\"The service is already used in Mainline/Feeder Schedules\"",test, test1);

		waitForPopup(driver, popup_Message, alreadyUsedPopup);
		String actualUsedPopup = getText(driver, popup_Message);

		if (actualUsedPopup.equals(alreadyUsedPopup)) {
			System.out.println("Matched || " + " Expected  Popup : " + alreadyUsedPopup + " || Actual  Popup : " + actualUsedPopup);
			Extent_pass_New(driver,"Matched || " + " Expected  Popup : " + alreadyUsedPopup + " || Actual Popup : " + actualUsedPopup,test,test1);
			click(driver, popup_Message_Ok_Button);

		} else {
			System.out.println("Not matched || " + " Expected  Popup : " + alreadyUsedPopup + " || Actual  Popup : " + actualUsedPopup);
			Extent_fail(driver,"Not matched || " + " Expected  Popup : " + alreadyUsedPopup + " || Actual  Popup : " + actualUsedPopup,test,test1);
		}
		
		Step_End(7, "\"The service is already used in Mainline/Feeder Schedules\"",test, test1);


		Extent_completed(tc_name, test, test1);

		

	}

}