package LRP_VSS_Proforma_Service_Creation_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Proforma_Service_Creation_PC09 extends Keywords {

//	InActivating an Record
	
	public void Proforma_Service_Creation_PC09(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

//	Get data from excel sheet
		String tc_name="TC_Proforma_Service_Creation_PC09";

		
		
		String Username = Excel_data.get("Username");
        String Password = Excel_data.get("Password");
        String ModuleSearch = Excel_data.get("Module_Search");
        String proformaCode = Excel_data.get("ProformaCode");
        String inactiveStatus = Excel_data.get("InactiveStatus");
        String confirmStatus = Excel_data.get("ConfirmStatus");
        String draftStatus = Excel_data.get("DraftStatus");
        String proformaUpdatedPopup = Excel_data.get("ProformaUpdatedPopup");
        String proformaCodeColor = Excel_data.get("ProformaCodeColor");
        String dropdownCondition = Excel_data.get("DropdownCondition");
        String globalSearchValueType = Excel_data.get("GlobalSearchValueType");

		Extent_Start(tc_name, test, test1);

        navigateUrl(driver, url);
        
//	Login
        
        LRP_Login(driver, Username, Password);
		
		moduleNavigate(driver, ModuleSearch);
		
	
		
//	Proforma service creation	

//		Retrieve a Record
		Step_Start(1, "Click on the Search Icon ", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
        click(driver,SearchButton_Toolbar);
        
		Step_End(1, "Click on the Search Icon ", test, test1);
		Step_Start(2, "Retirve the record ", test, test1);
		
		globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, proformaCode, "", "", "", "");

		
	     Step_End(2, "Retirve the record ", test, test1);
//	Verify Actual status of retrieved proforma code
		
		waitForElement(driver, proformaStatus);
		String actualStatus=getText(driver, proformaStatus);
		if(actualStatus.equals(draftStatus)) {
			Extent_pass_New(driver, "Matched || Expected proforma status :"+draftStatus+" || Actual proforma status :"+actualStatus, test,test1);
			System.out.println("Matched || Expected proforma status :"+draftStatus+" || Actual proforma status :"+actualStatus);
			
		}else if(actualStatus.equals(confirmStatus)){
			Extent_pass_New(driver, "Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualStatus, test,test1);
			System.out.println("Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualStatus);
		}else {
			System.out.println("Not Matched || Expected proforma status :"+confirmStatus+"/"+draftStatus+" || Actual proforma status :"+actualStatus);
			Extent_fail(driver, "Not Matched || Expected proforma status :"+confirmStatus+"/"+draftStatus+" || Actual proforma status :"+actualStatus, test,test1);
		}
		 waitForDisplay(driver, Proforma_Temp_Remove);
			if(isdisplayed(driver, Proforma_Temp_Remove)){
				waitForElement(driver, Proforma_Temp_Remove);
				click(driver, Proforma_Temp_Remove);
			}
//  Change the status to inactive
		Step_Start(3, "Choose Status as Inactive", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver, proformaStatus);

			waitForElement(driver, proformaStatus);
			click(driver, proformaStatus);
			
			String inactiveStatusOption = String.format(DropDown_Select, inactiveStatus);
			
			waitForElement(driver, inactiveStatusOption);
			click(driver, inactiveStatusOption);
			
			Step_End(3, "Choose Status as Inactive", test, test1);
			
			Step_Start(4, "Click on Save button", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(4, "Click on Save button", test, test1);
//	Verify the proforma service creation popup
				
			   waitForPopup(driver, popup_Message, proformaUpdatedPopup);
				String actualPopup = getText(driver, popup_Message);

				if (actualPopup.contains(proformaUpdatedPopup)) {
					Extent_pass_New(driver, "Matched || Expected :"+proformaUpdatedPopup+" || Actual :"+actualPopup, test,test1);
					System.out.println("Matched || Expected :"+proformaUpdatedPopup+" || Actual :"+actualPopup);
					click(driver, popup_Message_Ok_Button);
				}else {
					System.out.println("Not Matched || Expected :"+proformaUpdatedPopup+" || Actual :"+actualPopup);

					Extent_fail(driver, "Not Matched || Expected :"+proformaUpdatedPopup+" || Actual :"+actualPopup, test,test1);
				}
				
//	Verify the status after change
				Step_Start(5, "Only the Draft/Confirm Status Record will be allowed to change the status", test, test1);
				waitForElement(driver, proformaStatus);
				String statusAfter=getText(driver, proformaStatus);
				if (statusAfter.equals(inactiveStatus)) {
					System.out.println("Matched || " + " Expected  proforma status : " + inactiveStatus + " || Actual  proforma status : " + statusAfter);
					Extent_pass_New(driver,"Matched || " + " Expected  proforma status : " + inactiveStatus + " || Actual proforma status : " + statusAfter,test,test1);
				} else {
					System.out.println("Not matched || " + " Expected  proforma status : " + inactiveStatus + " || Actual  proforma status : " + statusAfter);
					Extent_fail(driver,"Not matched || " + " Expected  proforma status : " + inactiveStatus + " || Actual  proforma status : " + statusAfter,test,test1);
				}
		
		
			Step_End(5, "Only the Draft/Confirm Status Record will be allowed to change the status", test, test1);
			
//Background Color Verification of Proforma code textfield
			
		Step_Start(6, "Now the Proforma Code will be highlighed in Red Background", test, test1);
		
		waitForElement(driver, proforma_code);
		String actColorCode=getTextBackgroundColor(driver, proforma_code);
		String actColor=getColorName(actColorCode);
		
		if (actColor.equalsIgnoreCase(proformaCodeColor)) {
			System.out.println("Matched || " + " Expected  Color : " + proformaCodeColor + " || Actual  Color : " + actColor);
			Extent_pass_New(driver,"Matched || " + " Expected  Color : " + proformaCodeColor + " || Actual Color : " + actColor,test,test1);
			System.out.println("The background color of Proforma Code textfield is red");
			Extent_pass_New(driver, "The background color of Proforma Code textfield is red", test,test1);
		} else {
			System.out.println("Not matched || " + " Expected  Color : " + proformaCodeColor + " || Actual Color : " + actColor);
			Extent_fail(driver,"Not matched || " + " Expected  Color : " + proformaCodeColor + " || Actual  Color : " + actColor,test,test1);
		}
		Step_End(6, "Now the Proforma Code will be highlighed in Red Background", test, test1);

		Extent_completed(tc_name, test, test1);


	}
}
