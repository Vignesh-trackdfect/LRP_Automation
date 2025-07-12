package LRP_VSS_Proforma_Service_Creation_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Proforma_Service_Creation_PC02 extends Keywords{
	
//	Saving Record in Confirm Mode 
	
		public void Proforma_Service_Creation_PC02(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
			
			String tc_name="TC_Proforma_Service_Creation_PC02";

			
				       
			
			String Username = Excel_data.get("Username");
	        String Password = Excel_data.get("Password");
	        String ModuleSearch = Excel_data.get("Module_Search");
	        String proformaCode = Excel_data.get("ProformaCode");
	        String bound = Excel_data.get("Bound");
	        String boundPopup = Excel_data.get("BoundPopup");       
	        String proformaUpdatedPopup = Excel_data.get("ProformaUpdatedPopup");
	        String greenColor = Excel_data.get("GreenColor");
	        String proforma_Status = Excel_data.get("ProformaStatus");
	        String dropdownCondition = Excel_data.get("DropdownCondition");
	        String globalSearchValueType = Excel_data.get("GlobalSearchValueType");

	        
	        Extent_Start(tc_name, test, test1);
	        navigateUrl(driver, url);
			
	    	LRP_Login(driver, Username, Password);
			
			moduleNavigate(driver, ModuleSearch);
			
			
//	Retrieve the existing  record by Global Search		
			Step_Start(1, "Click on the search icon", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
	        click(driver,SearchButton_Toolbar);
			Step_End(1, "Click on the search icon", test, test1);
			
			Step_Start(2, "Retrieve the existing record", test, test1);

			globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, proformaCode, "", "", "", "");
		
		
			 waitForDisplay(driver, Proforma_Temp_Remove);
				if(isdisplayed(driver, Proforma_Temp_Remove)){
					waitForElement(driver, Proforma_Temp_Remove);
					click(driver, Proforma_Temp_Remove);
				}	
			Step_End(2, "Retrieve the existing record", test, test1);
			
			Step_Start(3, "Select the status as “Confirmed” from the status drop down", test, test1);
			scrollTop(driver);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
//  Change status			
			
			if(!proforma_Status.equals("")) {
				waitForElement(driver, status_Dropdown_SPF);
				click(driver,status_Dropdown_SPF);
				
				String select_Status=String.format(DropDown_Select,proforma_Status);
				
				waitForElement(driver, select_Status);
				click(driver, select_Status);
			}
			
			
			waitForElement(driver, proformaStatus);
			String StatusDropdownoption=getText(driver, proformaStatus);
			System.out.println(StatusDropdownoption);
			
			if(StatusDropdownoption.equals(proforma_Status)) {
				Extent_pass_New(driver, "Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption, test,test1);
				System.out.println("Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption);
			}else {
				System.out.println("Not Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption);

				Extent_fail(driver, "Not Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption, test,test1);
			}
	
			Step_End(3, "Select the status as “Confirmed” from the status drop down", test, test1);
			
			Step_Start(4, "Click On Save Button", test, test1);
			
			scrollTop(driver);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
			
			Step_End(4, "Click On Save Button", test, test1);
// Bound popup			
			Step_Start(5, "IF the proforma doesn’t have splitted the bound,System should show the validation as Enter the bound Details", test, test1);
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
			String boundmessage =getText(driver, popup_Message);
			Step_Start(6, "CLick on Save button", test, test1);

			if(boundmessage.equals(boundPopup)) {
				Extent_pass_New(driver, "Matched || Expected popup :"+boundPopup+" || Actual popup :"+boundmessage, test,test1);
				System.out.println("Matched || Expected popup :"+boundPopup+" || Actual popup :"+boundmessage);
				click(driver, popup_Message_Ok_Button);
				
				
				waitForElement(driver, bound_Gridcell);
				doubleClick(driver, bound_Gridcell);
				
				String selectBound=String.format(select_Bound, bound);
				waitForElement(driver, selectBound);
				click(driver, selectBound);
				
				scrollTop(driver);

				waitForElement(driver, SaveButton_ToolBar);
				click(driver,SaveButton_ToolBar);
				
			}
	
			}
			Step_End(5, "IF the proforma doesn’t have splitted the bound,System should show the validation as Enter the bound Details", test, test1);
			Step_End(6, "CLick on Save button", test, test1);

// Proforma updated popup
			
			Step_Start(7, "system should show the validation as the PRoforma is Confirmed ", test, test1);
			waitForPopup(driver, popup_Message, proformaUpdatedPopup);
			String actualUpdatedPopup = getText(driver, popup_Message);

			if (actualUpdatedPopup.equals(proformaUpdatedPopup)) {
				Extent_pass_New(driver, "Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup, test,test1);
				System.out.println("Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup);

				Extent_fail(driver, "Not Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup, test,test1);
			}
			Step_End(7, "system should show the validation as the PRoforma is Confirmed ", test, test1);
			
			Step_Start(8, "Highlighted with Green background in the proforma code", test, test1);
	         
			waitForElement(driver, proforma_code);
			String actualColorCode = getTextBackgroundColor(driver, proforma_code);
			String actualColor = getColorName(actualColorCode);
			
			if (actualColor.equals(greenColor)) {
				Extent_pass_New(driver, "Matched || Expected color :"+greenColor+" || Actual color :"+actualColor, test,test1);
				System.out.println("Matched || Expected color :"+greenColor+" || Actual color :"+actualColor);	
				Extent_pass_New(driver, "The background color of Proforma code textfield is Green", test, test1);
				System.out.println("The background color of Proforma code textfield is Green");
			}else {
				System.out.println("Not Matched || Expected color :"+greenColor+" || Actual color :"+actualColor);

				Extent_fail(driver, "Not Matched || Expected color :"+greenColor+" || Actual color :"+actualColor, test,test1);
			}
			Step_End(8, "Highlighted with Green background in the proforma code", test, test1);
			
			Extent_completed(tc_name, test, test1);
			
	}

}
