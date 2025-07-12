package LRP_VSS_Service_Creation_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Service_Creation_SC01 extends Keywords{	
	
// Check whether the system allows to save the record with valid data 
	
	public void Service_Creation_SC01(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
	
//	Get data from excel sheet

		String tc_name="TC_Service_Creation_SC01";
		
		String Username = Excel_data.get("Username");
        String Password = Excel_data.get("Password");
        String ModuleSearch = Excel_data.get("Module_Search");
        String Frequ = Excel_data.get("Frequency");
		String NoShips = Excel_data.get("No_Ships");
		String service_Code = Excel_data.get("Service_Code");
		String service_Name = Excel_data.get("Service_Name");
		String noOfBound = Excel_data.get("NoOfBound");
		String serviceType = Excel_data.get("ServiceType");
		String ext_Fdr = Excel_data.get("Ext_Fdr");		
		String startDate = Excel_data.get("StartDate");		
		String endDate = Excel_data.get("EndDate");
		String savedPopup = Excel_data.get("SavedPopup");
		String pnl_ServiceType = Excel_data.get("PNL_ServiceType");
		String status = Excel_data.get("Status");
		String date_Picker = Excel_data.get("DatePicker");
		String Ext_FDR_Disable_Status = Excel_data.get("Ext_FDR_Disable_Status");

		
		Extent_Start(tc_name, test, test1);
		navigateUrl(driver, url);
// Login
		
		LRP_Login(driver, Username, Password);
		
		moduleNavigate(driver, ModuleSearch);
		
//	Create new Service
		
		Step_Start(1, " Click on the new button in the toolbar", test, test1);
		
			newButton(driver);
	
		Step_End(1, " Click on the new button in the toolbar", test, test1);
		
		Step_Start(2, "Select the Service Code field and Enter Alphanumeric values upto 4 characters ", test, test1);
	
		waitForElement(driver, Service_CodeI);		
		System.out.println("Service Code : " + service_Code);
		click(driver, Service_CodeI);
		waitForElement(driver, Service_CodeI);		
		sendKeys(driver, Service_CodeI, service_Code);
		
		Step_End(2, "Select the Service Code field and Enter Alphanumeric values upto 4 characters ", test, test1);
		
		Step_Start(3, "Select the Service Name field and Enter Alphanumeric values upto 50 characters", test, test1);
		
		waitForElement(driver, Service_NameI);
		System.out.println("Service Name " + service_Name);
		sendKeys(driver, Service_NameI, service_Name);
	
		Step_End(3, "Select the Service Name field and Enter Alphanumeric values upto 50 characters", test, test1);
		
		Step_Start(4, "Select the bound from the drop down", test, test1);
		
		waitForElement(driver,No_of_Bound);
		click(driver,No_of_Bound);
		
		String selectBound=String.format(DropDown_Select, noOfBound);
		
		waitForElement(driver,selectBound);
		click(driver, selectBound);
	
		Step_End(4, "Select the bound from the drop down", test, test1);
		
		if(!pnl_ServiceType.equals("")) {
		waitForElement(driver,pnlServiceType );
		click(driver,pnlServiceType);
		
		String selectPNL_Service_type=String.format(DropDown_Select, pnl_ServiceType);
		
		waitForElement(driver, selectPNL_Service_type);
		click(driver, selectPNL_Service_type);

		}
		
		
		Step_Start(5, "Select the Service Type from the Service Type drop Down", test, test1);
		
		waitForElement(driver,Service_Type);
		click(driver,Service_Type);
		
		String select_Service=String.format(DropDown_Select, serviceType);
		waitForElement(driver, select_Service);
		click(driver, select_Service);
	
		Step_End(5, "Select the Service Type from the Service Type drop Down", test, test1);
		Step_Start(6, "Enter the Numerical Values in the Frequency field ", test, test1);

		
		waitForElement(driver, Freqency);
		doubleClick(driver, frequency_Textfield);
		new Actions(driver).sendKeys(Frequ).perform();
		Step_End(6, "Enter the Numerical Values in the Frequency field ", test, test1);
		
		Step_Start(7, "Enter the Numerical Values in the No.of Ships field", test, test1);
		waitForElement(driver, No_of_Ships1);
		doubleClick(driver, No_of_Ships1);
		new Actions(driver).sendKeys(NoShips).perform();

		Step_End(7, "Enter the Numerical Values in the No.of Ships field", test, test1);
		
		Step_Start(8, " If the Service Type is chosen as Feeder the choose value from Ext Fdr drop down ", test, test1);
		
		waitForElement(driver, ext_FDR_Dropdown);
		if(!serviceType.equals(Ext_FDR_Disable_Status)) {   
		waitForElement(driver, Ext_Fdr);
		click(driver,Ext_Fdr);
		
		String select_EXT_Fdr=String.format(DropDown_Select,ext_Fdr);
		
		waitForElement(driver, select_EXT_Fdr);
		click(driver, select_EXT_Fdr);
		}
		
		Step_End(8, " If the Service Type is chosen as Feeder the choose value from Ext Fdr drop down ", test, test1);
		Step_Start(9, "Enter the Start Date from the field for the Service ", test, test1);
		
		waitForElement(driver,Start_Date);
		if(date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime(driver, Start_Date, startDate);
		}else {
			if(startDate.contains("-")) {
				String startDate1=startDate.replace("-", "/");
				clear(driver,Start_Date);
				waitForElement(driver, Start_Date);
				sendKeys(driver, Start_Date, startDate1);

			}else {
				clear(driver,Start_Date);
				waitForElement(driver, Start_Date);
				sendKeys(driver, Start_Date, startDate);		
				}
		}
		
		Step_End(9, "Enter the Start Date from the field for the Service ", test, test1);
		
		Step_Start(10, "Enter the End Date greater than the Start Date Given", test, test1);
		
		waitForElement(driver,End_Date);	
		
		if(date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime(driver, End_Date, endDate);
			}else {
			if(endDate.contains("-")) {
				String endDate1=endDate.replace("-", "/");
				clear(driver,End_Date);
				waitForElement(driver, End_Date);
				sendKeys(driver, End_Date, endDate1);

			}else {
			clearAndType(driver, End_Date, endDate);
			}		
		}
		
		
		Step_End(10, "Enter the End Date greater than the Start Date Given", test, test1);
		
		Step_Start(11, "Select the Status as Active from the Status drop down ", test, test1);
		
		waitForElement(driver,status_Dropdown_SER);
		click(driver,status_Dropdown_SER);
		
		String select_Status=String.format(DropDown_Select,status);
		
		waitForElement(driver, select_Status);
		click(driver, select_Status);

		Step_End(11, "Select the Status as Active from the Status drop down ", test, test1);
		
		Step_Start(12, "Click on Save button from the toolbar", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
	
		Step_End(12, "Click on Save button from the toolbar", test, test1);
		
//		Verify the service creation popup

		Step_Start(13, "Should show the pop message says \"Service Creation Saved\"", test, test1);
		
		waitForPopup(driver, popup_Message, savedPopup);
		
			String ActText = getText(driver,popup_Message);
			System.out.println(ActText);
			if (savedPopup.equals(ActText)) {
				Extent_pass_New(driver, "Matched || Expected Popup :"+savedPopup+" || Actual Popup :"+ActText, test, test1);
				System.out.println("Matched || Expected Popup :"+savedPopup+" || Actual Popup :"+ActText);
				click(driver,popup_Message_Ok_Button);

			}else {
				System.out.println("Not Matched || Expected Popup :"+savedPopup+" || Actual Popup :"+ActText);
				Extent_fail(driver, "Not Matched || Expected Popup :"+savedPopup+" || Actual Popup :"+ActText, test, test1);
			}
		
	
//  Get Service code 
		
		waitForElement(driver, service_Code_Textfield_SER);
		String savedValue = getAttribute(driver, service_Code_Textfield_SER, "value");
		System.out.println(savedValue);
		if(savedValue.equalsIgnoreCase(service_Code)) {
			Extent_pass_New(driver, "Matched || Expected service code :"+service_Code+" || Actual service code :"+savedValue, test, test1);
			System.out.println("Matched || Expected service code :"+service_Code+" || Actual service code :"+savedValue);

		}else {
			System.out.println("Not Matched || Expected service code :"+service_Code+" || Actual service code :"+savedValue);
			Extent_fail(driver, "Not Matched || Expected service code :"+service_Code+" || Actual service code :"+savedValue, test, test1);
		}
		
		Step_End(13, "Should show the pop message says Service Creation Saved", test, test1);
		
		Extent_completed(tc_name, test, test1);
	}

}
