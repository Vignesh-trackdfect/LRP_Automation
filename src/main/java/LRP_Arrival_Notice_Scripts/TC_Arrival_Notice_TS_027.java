package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_027 extends Keywords {
public void Arrival_Notice_TS_027(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

//	To check system allows to Delete "Arrival Notice / Freight Memo" for house bl 
		String testCaseName="TC_Arrival_Notice_TS_027";

		// Get data from test data

		
		


		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String HBL_search = Excel_data.get("HBL_search");
		String HBL_Number = Excel_data.get("HBL_Number");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String wantToDeletePopup = Excel_data.get("WantToDeletePopup");
		String deletedPopup = Excel_data.get("DeletedPopup");
		
		
	
	
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);
		// Login

		LRP_Login(driver, username, password);


	// Switch User
		Step_Start(1, " Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);

		Step_End(1, " Switch the agency ", test, test1);
//	Arrival Notice
		Extent_cal(test, test1, module_ArrivalNotice);

		Step_Start(2, "Open  \"Arrival Notice / Freight Memo\" screen", test, test1);
		

		moduleNavigate(driver, module_ArrivalNotice);

		
	
		Step_End(2, "Open  \"Arrival Notice / Freight Memo\" screen", test, test1);

		Step_Start(3, "select the search icon", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		
		
		globalValueSearchWindow(driver, dropdownCondition1, HBL_search, HBL_Number, "","", "","");
	
		
		Step_End(4, "Paste the  house BL number and search", test, test1);
		Step_Start(5, "Select the house Bl number ", test, test1);
		
	
		
		String selectCheckbox=String.format(HBL_CheckBox, HBL_Number);
		waitForElement(driver, selectCheckbox);
		click(driver, selectCheckbox);
		
		Step_End(5, "Select the house Bl number ", test, test1);
		Step_Start(6, "Click the delete button on tool bar ", test, test1);
		
		waitForElement(driver, bl_NO_Searchfield);
		String actual_BL_Number=getAttribute(driver, bl_NO_Searchfield, "value");
		if(!actual_BL_Number.equals("")) {
			Extent_pass(driver, "Matched || Expected System Should showing the BL details || Actual System  showing the BL details", test, test1);
			System.out.println("Matched || Expected System Should showing the BL details || Actual System  showing the BL details");
			
		}else {
			System.out.println("Matched || Expected System Should showing the BL details || Actual System  not showing the BL details");
			Extent_fail(driver, "Matched || Expected System Should showing the BL details || Actual System not showing the BL details", test, test1);
			

		}
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		
		Step_End(6, "Click the delete button on tool bar ", test, test1);
		Step_Start(7, "Ensure that system shows the validation message \"  Do you want to delete the selected BL Number(s) ? ", test, test1);
		waitForPopup(driver, popup_Message, wantToDeletePopup);      
		String actualPopup=getText(driver, popup_Message);
		if (actualPopup.equals(wantToDeletePopup)) {
			Extent_pass(driver, "Matched || Expected popup should be: " + wantToDeletePopup + " || Actual popup is: " + actualPopup, test,test1);
			System.out.println("Matched || Expected popup should be: " + wantToDeletePopup + " || Actual :popup is " + actualPopup);
			Step_End(7, "Ensure that system shows the validation message \"  Do you want to delete the selected BL Number(s) ? ", test, test1);
			Step_Start(8, "Click yes", test, test1);
			
			click(driver, popup_Message_Yes_Button);
			
			Step_End(8, "Click yes", test, test1);

		} else {
			System.out.println("Not Matched || Expected  popup should be: " + wantToDeletePopup + " || Actual pop not came : " + actualPopup);
			Extent_fail(driver, "Not Matched || Expected popup should be : " + wantToDeletePopup + " || Actual pop not came: " + actualPopup, test,test1);
		}
		waitForPopup(driver, Popup_Message, deletedPopup);    
		String actualMsg=getText(driver, Popup_Message);
		if(actualMsg.equals(deletedPopup)) {
			Extent_pass(driver, "Matched || Expected : " + deletedPopup + " || Actual : " + actualMsg, test,test1);
			System.out.println("Matched || Expected : " + deletedPopup + " || Actual : " + actualMsg);
		} else {
			System.out.println("Not Matched || Expected : " + deletedPopup + " || Actual : " + actualMsg);
			Extent_fail(driver, "Not Matched || Expected : " + deletedPopup + " || Actual : " + actualMsg, test,test1);
		}
		}
		
		
		Extent_completed(testCaseName, test, test1);
}
}
