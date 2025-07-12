package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC011 extends Keywords{
	////Check whether In line agency system doesn't allow to edit the Booking .
	public void Booking_SC011(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name="TC_Booking_SC011";
		//		Get data from excel sheet

		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String ModuleSearch = Excel_data.get("Module_Search");
		String lineUser = Excel_data.get("LineUser");
		String retrieveBookingNumber = Excel_data.get("RetrieveBookingNumber");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearchFilterOption1=Excel_data.get("GlobalSearchFilterOption1");
		String globalSearchFilterOption2=Excel_data.get("GlobalSearchFilterOption2");
		String globalSearchFilterOption3=Excel_data.get("GlobalSearchFilterOption3");
		String searchValue2=Excel_data.get("searchValue2");
		String searchValue3=Excel_data.get("searchValue3");

		navigateUrl(driver, url);
		Extent_Start(test_Case_Name, test, test1);
		//Login
		LRP_Login(driver, Username, Password);
		//	Verify Line agency				
		waitForElement(driver, type_Of_User);
		String actualUser=getText(driver, type_Of_User);
		if(actualUser.contains(lineUser)) {
			Extent_pass_New(driver,"Matched || Excepted Agency User : "+ lineUser+" || Actual Agency User : "+actualUser, test,test1);
			System.out.println("Matched || Excepted Agency User : "+ lineUser+" || Actual Agency User : "+actualUser);
		}else {
			System.out.println("Not matched || Excepted Agency User : "+ lineUser+" || Actual Agency User : "+actualUser);
			Extent_fail(driver,"Not matched || Excepted Agency User : "+ lineUser+" || Actual Agency User : "+actualUser, test,test1);
		}
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, ModuleSearch);
		Step_Start(1, "Click on the search icon", test, test1);
		// Global search
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(1, "Click on the search icon", test, test1);
		Step_Start(2, "Retrieve the existing record", test, test1);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption1, retrieveBookingNumber, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);
//		Verify Booking	popup
		waitForElement(driver, Booking_No_Field);
		String actualBookingNum=getAttribute(driver, Booking_No_Field, "value");
		if(actualBookingNum.equals(retrieveBookingNumber)) {
			Extent_pass_New(driver,"Matched || Booking Number Retrieved ||Excepted:"+ retrieveBookingNumber+" || Actual:"+actualBookingNum, test,test1);
			System.out.println("Matched || Booking Number Retrieved ||Excepted:"+ retrieveBookingNumber+" || Actual:"+actualBookingNum);
		}else {
			System.out.println("Not matched || Booking Number Not Retrieved ||Excepted:"+ retrieveBookingNumber+" || Actual:"+actualBookingNum);
			Extent_fail(driver,"Not matched ||Booking Number Not Retrieved ||Excepted:"+ retrieveBookingNumber+" || Actual:"+actualBookingNum, test,test1);
		}
		Step_End(2, "Retrieve the existing record", test, test1);
		Step_Start(3, "System disable the ToolBar", test, test1);
		//	Toolbar verification
		waitForElement(driver, Edit_Button_toolBar);
		if(!IsElementEnabled(driver, Edit_Button_toolBar)) {
			Extent_pass_New(driver,"Matched || Expected Result : is Edit button Should be Disable in the Booking screen || Actual Result is : Edit button is Disabled in the Booking screen", test,test1);
			System.out.println("Matched || Expected Result : is Edit button Should be Disable in the Booking screen || Actual Result is : Edit button is Disabled in the Booking screen");
		}else {
			System.out.println("Matched || Expected Result : is Edit button Should be Disable in the Booking screen || Actual Result is : Edit button is Disabled in the Booking screen");
			Extent_fail(driver,"Matched || Expected Result : is Edit button Should be Disable in the Booking screen || Actual Result is : Edit button is Disabled in the Booking screen", test,test1);
		}
		Step_End(3, "System disable the ToolBar", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}