package LRP_VSS_Proforma_Service_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Proforma_Service_Creation_PC08 extends Keywords {

//	Deleting a  Record 
	
	public void Proforma_Service_Creation_PC08(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

//	Get data from excel sheet
		String tc_name="TC_Proforma_Service_Creation_PC08";

		       
		
		String Username = Excel_data.get("Username");
        String Password = Excel_data.get("Password");
        String ModuleSearch = Excel_data.get("Module_Search");
        String draftProformaCode = Excel_data.get("DraftProformaCode");
        String deployedProformaCode = Excel_data.get("DeployedProformaCode");
        String confirmProformaCode = Excel_data.get("ConfirmProformaCode");
        String proformaDeletedPopup = Excel_data.get("ProformaDeletedPopup");
        String alreadyUsedPopup = Excel_data.get("AlreadyUsedPopup");
        String wantToDeletePopup = Excel_data.get("WantToDeletePopup");
        String confirmStatus = Excel_data.get("ConfirmStatus");
        String deployedStatus = Excel_data.get("DeployedStatus");
        String draftStatus = Excel_data.get("DraftStatus");
        String dropdownCondition = Excel_data.get("DropdownCondition");
        String globalSearchValueType = Excel_data.get("GlobalSearchValueType");
  
        
        Extent_Start(tc_name, test, test1);
        navigateUrl(driver, url);

//   Login
        
        LRP_Login(driver, Username, Password);
		
      	moduleNavigate(driver, ModuleSearch);
      		
//	Proforma service creation	

//	Retrieve & Delete Draft Record
		
		Step_Start(1, "Click on the Search Icon ", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
        click(driver,SearchButton_Toolbar);
        
        Step_End(1, "Click on the Search Icon ", test, test1);
        
		Step_Start(2, "Retrieve the Draft record ", test, test1);
		
		globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, draftProformaCode, "", "", "", "");

		
//		Verify Actual status of retrieved proforma code
		waitForElement(driver, proformaStatus);
		String actualDraftStatus = getText(driver, proformaStatus);
		
		if(actualDraftStatus.equals(draftStatus)) {
			Extent_pass_New(driver, "Matched || Expected proforma status:"+draftStatus+" || Actual proforma status :"+actualDraftStatus, test,test1);
			System.out.println("Matched || Expected proforma status :"+draftStatus+" || Actual proforma status :"+actualDraftStatus);
			click(driver, Delete_button_toolBar);
		}else {
			System.out.println("Not Matched || Expected proforma status :"+draftStatus+" || Actual proforma status :"+actualDraftStatus);

			Extent_fail(driver, "Not Matched || Expected proforma status :"+draftStatus+" || Actual proforma status :"+actualDraftStatus, test,test1);
		}
		Step_End(2, "Retrieve the Draft record ", test, test1);
//	Delete 
		Step_Start(3, "Delete the Draft record ", test, test1);

		
		
		   waitForPopup(driver, popup_Message, wantToDeletePopup);
		String actualDeletePopup = getText(driver, popup_Message);

//	Verify The Proforma Service Creation popup
		
		if (actualDeletePopup.equals(wantToDeletePopup)) {
			Extent_pass_New(driver, "Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup, test,test1);
			System.out.println("Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup);
			click(driver, popup_Message_Yes_Button);
		}else {
			System.out.println("Not Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup);

			Extent_fail(driver, "Not Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup, test,test1);
		}
		
		
		   waitForPopup(driver, popup_Message, proformaDeletedPopup);
		String actualDeletedPopup = getText(driver, popup_Message);

		if (actualDeletedPopup.equals(proformaDeletedPopup)) {
			Extent_pass_New(driver, "Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopup, test,test1);
			System.out.println("Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopup);

			Extent_fail(driver, "Not Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopup, test,test1);
		}
		Step_End(3, "Delete the Draft record ", test, test1);
				
//	Retrieve & Delete Confirmed Record
		
		Step_Start(4, "Retrieve the Confirmed record ", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
        click(driver,SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, confirmProformaCode, "", "", "", "");

		
//	Verify Actual status of retrieved proforma code
		
		waitForElement(driver, proformaStatus);
		String actualConfirmStatus8 = getText(driver, proformaStatus);
		
		if(actualConfirmStatus8.equals(confirmStatus)) {
			Extent_pass_New(driver, "Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualConfirmStatus8, test,test1);
			System.out.println("Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualConfirmStatus8);
		}else {
			System.out.println("Not Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualConfirmStatus8);

			Extent_fail(driver, "Not Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualConfirmStatus8, test,test1);
		}
		Step_End(4, "Retrieve the Confirmed record ", test, test1);
//	Delete
		Step_Start(5, "Delete the Confirmed record ", test, test1);
		
		scrollTop(driver);
		waitForDisplay(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);

//	Verify The Proforma Service Creation popup

		   waitForPopup(driver, popup_Message, wantToDeletePopup);
		String actualDeletePopup2 = getText(driver, popup_Message);

		if (actualDeletePopup2.equals(wantToDeletePopup)) {
			Extent_pass_New(driver, "Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup2, test,test1);
			System.out.println("Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup2);
			click(driver, popup_Message_Yes_Button);
		}else {
			System.out.println("Not Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup2);

			Extent_fail(driver, "Not Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup2, test,test1);
		}
		
		
		   waitForPopup(driver, popup_Message, proformaDeletedPopup);
		String actualDeletedPopupConfirm = getText(driver, popup_Message);

		if (actualDeletedPopupConfirm.equals(proformaDeletedPopup)) {
			Extent_pass_New(driver, "Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopupConfirm, test,test1);
			System.out.println("Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopupConfirm);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopupConfirm);

			Extent_fail(driver, "Not Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopupConfirm, test,test1);
		}
		Step_End(5, "Delete the Confirmed record ", test, test1);

//		Retrieve Deployed Record
		Step_Start(6, "Retrieve the Deployed record ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
        click(driver,SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, deployedProformaCode, "", "", "", "");

		
//	Verify Actual status of retrieved proforma code
	
		waitForElement(driver, proformaStatus);
		String actualDeployedStatus8 = getText(driver, proformaStatus);
		if(actualDeployedStatus8.equals(deployedStatus)) {
			Extent_pass_New(driver, "Matched || Expected proforma status :"+deployedStatus+" || Actual proforma status :"+actualDeployedStatus8, test,test1);
			System.out.println("Matched || Expected proforma status :"+deployedStatus+" || Actual proforma status :"+actualDeployedStatus8);
		}else {
			System.out.println("Not Matched || Expected proforma status :"+deployedStatus+" || Actual proforma status :"+actualDeployedStatus8);

			Extent_fail(driver, "Not Matched || Expected proforma status :"+deployedStatus+" || Actual proforma status :"+actualDeployedStatus8, test,test1);
		}
		Step_End(6, "Retrieve the Deployed record ", test, test1);
		
//	Delete the Deployed record 
		
		Step_Start(7, "Delete the Deployed record ", test, test1);
		scrollTop(driver);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		
//	Verify The Proforma Service Creation popup
		
		   waitForPopup(driver, popup_Message, alreadyUsedPopup);
		String actualPopup = getText(driver, popup_Message);

		if (actualPopup.contains(alreadyUsedPopup)) {
			Extent_pass_New(driver, "Matched || Expected popup :"+alreadyUsedPopup+" || Actual popup :"+actualPopup, test,test1);
			System.out.println("Matched || Expected popup :"+alreadyUsedPopup+" || Actual popup :"+actualPopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected popup :"+alreadyUsedPopup+" || Actual popup :"+actualPopup);

			Extent_fail(driver, "Not Matched || Expected popup :"+alreadyUsedPopup+" || Actual popup :"+actualPopup, test,test1);
		}
		Step_End(7, "Delete the Deployed record ", test, test1);
	Extent_completed(tc_name, test, test1);
	}

}
