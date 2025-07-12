package LRP_VSS_Service_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Service_Creation_SC02 extends Keywords {

//  Check whether the system allows to edit the saved record 	
	public void Service_Creation_SC02(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

//	Get data from excel sheet
		String tc_name="TC_Service_Creation_SC02";

		
		       		
		String Username = Excel_data.get("Username");
        String Password = Excel_data.get("Password");
        String ModuleSearch = Excel_data.get("Module_Search");
        String Frequ = Excel_data.get("Frequency");
		String NoShips = Excel_data.get("No_Ships");
		String service_Code = Excel_data.get("Service_Code");
		String retrieveServiceName = Excel_data.get("RetrieveServiceName");
		String noOfBound = Excel_data.get("NoOfBound");
		String serviceType = Excel_data.get("ServiceType");
		String ext_Fdr = Excel_data.get("Ext_Fdr");
		String updatedPopup = Excel_data.get("UpdatedPopup");
		String pnl_ServiceType = Excel_data.get("PNL_ServiceType");
		String status = Excel_data.get("Status");
		String serviceName = Excel_data.get("ServiceName");
		String startDate = Excel_data.get("StartDate");		
		String endDate = Excel_data.get("EndDate");
		String date_Picker = Excel_data.get("DatePicker");
		String Ext_FDR_Disable_Status = Excel_data.get("Ext_FDR_Disable_Status");


		Extent_Start(tc_name, test, test1);
		
		navigateUrl(driver, url);

//	Login
		
	LRP_Login(driver, Username, Password);
		
	moduleNavigate(driver, ModuleSearch);	
	

//	Retrieve Service from AG Grid
		
		
			Step_Start(1, " Double click on the saved record from the AgGrid table below", test, test1);
			
			waitForElement(driver, agGrid_Filter);
			click(driver, agGrid_Filter);
			waitForElement(driver, condition_Filter_AG_Grid_SER);
			click(driver, condition_Filter_AG_Grid_SER);
			waitForElement(driver, serviceCode_FilterSearch);
			click(driver, serviceCode_FilterSearch);
			waitForElement(driver, serviceCode_FilterSearch);
			sendKeys(driver, serviceCode_FilterSearch, service_Code);
			
			waitForElement(driver, serviceName_FilterSearch);
			click(driver, serviceName_FilterSearch);
			waitForElement(driver, serviceName_FilterSearch);
			sendKeys(driver, serviceName_FilterSearch, retrieveServiceName);
			
			waitForElement(driver, select_ServiceCode);
			click(driver, select_ServiceCode);
			waitForElement(driver, select_ServiceCode);
			doubleClick(driver, select_ServiceCode);			
			
			Step_End(1, " Double click on the saved record from the AgGrid table below", test, test1);
			
//   Edit The Service
			Step_Start(2, "Click on the **Edit** button from the toolbar", test, test1);
			
		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		
		Step_End(2, "Click on the **Edit** button from the toolbar", test, test1);
		Step_Start(3, "Edit the Fields below -> Service Name, No.of Bound, Service Type, Frequency,No.of Ships, Start Date , End Date}", test, test1);
		
		Extent_call(test, test1, "Edit Service Name");
		
		waitForElement(driver, Service_NameI);
		System.out.println("Service Name " + serviceName);
		clearAndType(driver, Service_NameI, serviceName);
		
		Extent_call(test, test1, "Edit  No.of Bound");

		waitForElement(driver,No_of_Bound);
		click(driver,No_of_Bound);
		
		String selectBound=String.format(DropDown_Select, noOfBound);
		
		waitForElement(driver,selectBound);
		click(driver, selectBound);
		
		
		if(!pnl_ServiceType.equals("")) {
			waitForElement(driver,pnlServiceType );
			click(driver,pnlServiceType);
			
			String selectPNL_Service_type=String.format(DropDown_Select, pnl_ServiceType);
			
			waitForElement(driver, selectPNL_Service_type);
			click(driver, selectPNL_Service_type);

			}
		
		waitForElement(driver,Service_Type);
		click(driver,Service_Type);
		
		String select_Service=String.format(DropDown_Select, serviceType);
		waitForElement(driver, select_Service);
		click(driver, select_Service);
	
		
		Extent_call(test, test1, "Edit Frequency");

		waitForElement(driver, Freqency);
		doubleClick(driver, frequency_Textfield);
		new Actions(driver).sendKeys(Frequ).perform();

		Extent_call(test, test1, "Edit No.of Ships");

		waitForElement(driver, No_of_Ships1);
		doubleClick(driver, No_of_Ships1);
		new Actions(driver).sendKeys(NoShips).perform();

		
		waitForElement(driver, ext_FDR_Dropdown);
		if(!serviceType.equals(Ext_FDR_Disable_Status)) {   
		waitForElement(driver, Ext_Fdr);
		click(driver,Ext_Fdr);
		
		String select_EXT_Fdr=String.format(DropDown_Select,ext_Fdr);
		
		waitForElement(driver, select_EXT_Fdr);
		click(driver, select_EXT_Fdr);
		}
		

		Extent_call(test, test1, "Edit Start Date");

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
		
		Extent_call(test, test1, "Edit End Date");

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
		
		Extent_call(test, test1, "Edit Status");


		waitForElement(driver,status_Dropdown_SER);
		click(driver,status_Dropdown_SER);
		
		String select_Status=String.format(DropDown_Select,status);
		
		waitForElement(driver, select_Status);
		click(driver, select_Status);
		
		Step_End(3, "Edit the Fields below->  Service Name, No.of Bound, Service Type, Frequency,No.of Ships, Start Date , End Date}", test, test1);

//	Verify the service creation popup
		
		Step_Start(4, "Click on Save Button from the toolbar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
	 
		Step_End(4, "Click on Save Button from the toolbar", test, test1);
		Step_Start(5, "Should show the pop up message says\"Service Creation Updated\"", test, test1);
		
		waitForPopup(driver, popup_Message, updatedPopup);
			String ActText = getText(driver,popup_Message);

			System.out.println(ActText);
			if (updatedPopup.equals(ActText)) {
				Extent_pass_New(driver, "Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText, test, test1);
				System.out.println("Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText);
				click(driver,popup_Message_Ok_Button);

			}else {
				System.out.println("Not Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText);
				Extent_fail(driver, "Not Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText, test, test1);
			}
		
		Step_End(5, "Should show the pop up message says Service Creation Updated", test, test1);
		Extent_completed(tc_name, test, test1);
	}

}
