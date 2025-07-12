package LRP_EMS_Equipment_Profile_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Equipment_Profile_TS_061 extends Keywords {
	
//	Check whether that system allows to delete the saved record
	
	public void deleteTheSavedRecord(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Equipment_Profile_TS_061";
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleEquipmentProfile");
		String cannotDelEqp = Excel_data.get("MovementEntry_EquipmentNo");
		String deletedPopup = Excel_data.get("DeletedPopup");
		String noRecords = Excel_data.get("NoRecords");
		String cannotDelelePopup = Excel_data.get("CannotDelelePopup");	
		String eqpNoDelete = Excel_data.get("EquipmentNumber_Delete");
		String wantToDeletepopup = Excel_data.get("WantToDeletePopup");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String globalSearchFilterOption2 = Excel_data.get("globalSearchFilterOption2");
		String globalSearchFilterOption3 = Excel_data.get("globalSearchFilterOption3");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		
		LRP_Login(driver, username, password);

//		Module Search
		moduleNavigate(driver, moduleName);
		
		waitForDisplay(driver,  newButton_EquipmentProfile_Homepage);
		if(isdisplayed(driver,  newButton_EquipmentProfile_Homepage)) {
			click(driver,  newButton_EquipmentProfile_Homepage);
		}

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);

		// Delete

		Step_Start(1, "Click the Global search button in the toolbar", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		Step_End(1, "Click the Global search button in the toolbar", test, test1);
		
		Step_Start(2, "Enter the Equipment Number in the search list", test, test1);
		Step_Start(3, "Click on the search Button once Equipment number entered", test, test1);
		Step_Start(4, "Double click on the saved record from the AgGrid table", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, eqpNoDelete, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

			Step_End(2, "Enter the Equipment Number in the search list", test, test1);
			
			Step_End(3, "Click on the search Button once Equipment number entered", test, test1);
			
			Step_End(4, "Double click on the saved record from the AgGrid table", test, test1);
			Step_Start(5, "Click on the Delete button in the toolbar", test, test1);
			
			scrollTop(driver);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			Step_End(5, "Click on the Delete button in the toolbar", test, test1);
			Step_Start(6, "Press 'Yes' in the Popup message to delete", test, test1);
			
			waitForPopup(driver, popup_Message, wantToDeletepopup);
			String actualWantToDeletePopup1=getText(driver, popup_Message);
			System.out.println("wantToDeletePopup:"+actualWantToDeletePopup1);
			
			if (actualWantToDeletePopup1.equals(wantToDeletepopup)) {				
				System.out.println("Matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup1);
				Extent_pass_New(driver, "Matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup1, test,test1);
				click(driver, popup_Message_Yes_Button);

			} else {
				System.out.println("Not matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup1);
				Extent_fail(driver, "Not matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup1+"<br>"+wantToDeletepopup + " popup is not diplayed and it is verified",test, test1);
			}
			
			Step_End(6, "Press 'Yes' in the Popup message to delete", test, test1);
			
			Step_Start(7, "Deleted popup Verification", test, test1);

			waitForPopup(driver, Popup_Message, deletedPopup);
			String actDeletedPopup = getText(driver, Popup_Message);
			if (actDeletedPopup.equals(deletedPopup)) {
				System.out.println(
						"Matched || " + " Expected popup : " + deletedPopup + " || Actual popup : " + actDeletedPopup);
				Extent_pass_New(driver,
						"Matched || " + " Expected popup : " + deletedPopup + " || Actual popup : " + actDeletedPopup, test,
						test1);
			} else {
				System.out.println(
						"Not matched || " + " Expected popup : " + deletedPopup + " || Actual popup : " + actDeletedPopup);

				Extent_fail(driver,"Not matched || " + " Expected popup : " + deletedPopup + " || Actual popup : " + actDeletedPopup+"<br>"+deletedPopup+" popup is not displayed",test, test1);
			}

			Step_End(7, "Deleted popup Verification", test, test1);

		// Global search
	
			scrollTop(driver);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption1, eqpNoDelete, "", "", "", "");

			waitForPopup(driver, Popup_Message,noRecords);

			String actNoRecords = getText(driver, Popup_Message);
			System.out.println("Actual" + actNoRecords);
			if (actNoRecords.equals(noRecords)) {

				Extent_pass_New(driver,"Matched || " + " Expected  Popup :  " + noRecords + " || Actual  Popup :  " + actNoRecords+"<br>"+noRecords+" popup is displayed", test,test1);
				System.out.println("Matched || " + " Expected  Popup :  " + noRecords + " || Actual  Popup :  " + actNoRecords);
			} else {
				System.out.println("Not matched || " + " Expected  Popup :  " + noRecords + " || Actual  Popup :  " + actNoRecords);

				Extent_fail(driver, "Not matched || " + " Expected Popup :  " + noRecords + " || Actual  Popup :  " + actNoRecords+"<br>"+noRecords+" popup is not displayed",test, test1);
			}
			 waitForElement(driver,globalSearchCloseIcon_L);
			 click(driver, globalSearchCloseIcon_L);
		
		// delete
		if(!cannotDelEqp.equals("")) {
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, cannotDelEqp, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

			scrollTop(driver);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message,wantToDeletepopup);
			String actualWantToDeletePopup=getText(driver, popup_Message);
			System.out.println("wantToDeletePopup:"+actualWantToDeletePopup);
			
			if (actualWantToDeletePopup.equals(wantToDeletepopup)) {				
				System.out.println("Matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup);
				Extent_pass_New(driver, "Matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup, test,test1);
				click(driver, popup_Message_Yes_Button);

			} else {
				System.out.println("Not matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup);
				Extent_fail(driver, "Not matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup+"<br>"+wantToDeletepopup + " popup is not diplayed and it is verified",test, test1);
			}
			

			Step_Start(8, "Cannot delete the Equipment Profile. It has movement entry", test, test1);
			waitForPopup(driver, Popup_Message,cannotDelelePopup);
			String actCannotDel = getText(driver, Popup_Message);
			if (actCannotDel.equals(cannotDelelePopup)) {
				System.out.println("Matched || " + " Expected popup : " + cannotDelelePopup + " || Actual popup : " + actCannotDel);
				Extent_pass_New(driver, "Matched || " + " Expected popup : " + cannotDelelePopup + " || Actual popup : " + actCannotDel, test,test1);
			} else {
				System.out.println("Not matched || " + " Expected popup : " + cannotDelelePopup + " || Actual popup : " + actCannotDel);
				Extent_fail(driver, "Not matched || " + " Expected popup : " + cannotDelelePopup + " || Actual popup : " + actCannotDel+"<br>"+cannotDelelePopup + " popup is not diplayed and it is verified",test, test1);
			}

			Step_End(8, "Cannot delete the Equipment Profile. It has movement entry", test, test1);
		}
		 

		Extent_completed(testCaseName, test, test1);
	}

}
