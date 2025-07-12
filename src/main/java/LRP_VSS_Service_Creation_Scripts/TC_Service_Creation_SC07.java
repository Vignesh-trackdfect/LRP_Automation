package LRP_VSS_Service_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Service_Creation_SC07 extends Keywords {

	// InActivating an Record

	public void Service_Creation_SC07(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		//		Get data from excel sheet
		String tc_name="TC_Service_Creation_SC07";

		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String ModuleSearch = Excel_data.get("Module_Search");
		String retriveService_Code = Excel_data.get("RetrieveService_Code");
		String retrieveServiceName = Excel_data.get("RetrieveServiceName");
		String serviceCodeColor = Excel_data.get("ServiceCodeColor");
		String status = Excel_data.get("Status");
		String updatedPopup = Excel_data.get("UpdatedPopup");
		String status_2 = Excel_data.get("status_2");
		String want_To_Activate = Excel_data.get("Want_To_Activate");


		Extent_Start(tc_name, test, test1);
		navigateUrl(driver, url);

		//Login page
		LRP_Login(driver, Username, Password);

		moduleNavigate(driver, ModuleSearch);

		//Retrieve a Service	
		Step_Start(1, "Double Click on the Service Record",test, test1);
		waitForElement(driver, agGrid_Filter);
		click(driver, agGrid_Filter);
		waitForElement(driver, condition_Filter_AG_Grid_SER);
		click(driver, condition_Filter_AG_Grid_SER);
		waitForElement(driver, serviceCode_FilterSearch);
		sendKeys(driver, serviceCode_FilterSearch, retriveService_Code);

		waitForElement(driver, serviceName_FilterSearch);
		sendKeys(driver, serviceName_FilterSearch, retrieveServiceName); 

		waitForElement(driver, select_ServiceCode);
		String actualServiceCode = getText(driver, select_ServiceCode);

		if (actualServiceCode.equalsIgnoreCase(retriveService_Code)) {
			System.out.println("Matched || " + " Expected Service Code : " + retriveService_Code + " || Actual Service Code : " + actualServiceCode);
			Extent_pass_New(driver,"Matched || " + " Expected Service Code : " + retriveService_Code + " || ActualService Code : " + actualServiceCode,test,test1);
		} else {
			System.out.println("Not matched || " + " Expected Service Code : " + retriveService_Code + " || Actual Service Code : " + actualServiceCode);
			Extent_fail(driver,"Not matched || " + " Expected Service Code : " + retriveService_Code + " || Actual Service Code : " + actualServiceCode,test,test1);
		}

		waitForElement(driver, select_ServiceCode);
		click(driver, select_ServiceCode);
		waitForElement(driver, select_ServiceCode);
		doubleClick(driver, select_ServiceCode);			

		Step_End(1, "Double Click on the Service Record",test, test1);

		//Change to Inactive

		Step_Start(2, "Click on the Edit Button from the toolbar",test, test1);
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);

		Step_End(2, "Click on the Edit Button from the toolbar",test, test1);

		Step_Start(3, "Select the Inactive Value from the Status Drop Down",test, test1);

		waitForElement(driver,status_Dropdown_SER);
		click(driver,status_Dropdown_SER);

		String select_Status=String.format(DropDown_Select,status);

		waitForElement(driver, select_Status);
		click(driver, select_Status);

		waitForElement(driver,status_Dropdown_Value_SER);
		String actualStatus = getText(driver,status_Dropdown_Value_SER);

		if (actualStatus.equals(status)) {
			Extent_pass_New(driver, "Matched || Expected :"+status+" || Actual :"+actualStatus, test, test1);
			System.out.println("Matched || Expected :"+status+" || Actual :"+actualStatus);

		}else {
			System.out.println("Not Matched || Expected :"+status+" || Actual :"+actualStatus);
			Extent_fail(driver, "Not Matched || Expected :"+status+" || Actual :"+actualStatus, test, test1);
		}
		Step_End(3, "Select the Inactive Value from the Status Drop Down",test, test1);

		Step_Start(4, "Click on Save Button",test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);

		//	Verify the service creation popup

		waitForPopup(driver, popup_Message, updatedPopup);
		String ActText = getText(driver,popup_Message);
		System.out.println(ActText);
		if (updatedPopup.equals(ActText)) {
			Extent_pass_New(driver, "Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText, test, test1);
			System.out.println("Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText);

			Extent_fail(driver, "Not Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText, test, test1);
		}
		waitForElement(driver, service_Code_Textfield_SER);
		String actualColorCode = getTextBackgroundColor(driver, service_Code_Textfield_SER);
		String actualColor=getColorName(actualColorCode);

		if (actualColor.equalsIgnoreCase(serviceCodeColor)) {
			System.out.println("Matched || " + " Expected Color : " + serviceCodeColor + " || Actual Color : " + actualColor);
			Extent_pass_New(driver,"Matched || " + " Expected Color : " + serviceCodeColor + " || ActualColor : " + actualColor,test,test1);
		} else {
			System.out.println("Not matched || " + " Expected Color : " + serviceCodeColor + " || Actual Color : " + actualColor);
			Extent_fail(driver,"Not matched || " + " Expected Color : " + serviceCodeColor + " || Actual Color : " + actualColor,test,test1);
		}

		Step_End(4, "Click on Save Button",test, test1);

		if(want_To_Activate.equalsIgnoreCase("Yes")) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver,status_Dropdown_SER);
			click(driver,status_Dropdown_SER);

			String select_Status1=String.format(DropDown_Select,status_2);

			waitForElement(driver, select_Status1);
			click(driver, select_Status1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
			if(isdisplayed(driver, popup_Message_Ok_Button)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			}
		}

		Extent_completed(tc_name, test, test1);

	}
}
