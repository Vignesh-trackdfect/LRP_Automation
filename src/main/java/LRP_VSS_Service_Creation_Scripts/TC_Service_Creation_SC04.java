package LRP_VSS_Service_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Service_Creation_SC04 extends Keywords {
	
	
//	Check Whether the system shows pop up validation when the user trying to save the data with invalid values
	
	public void Service_Creation_SC04(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
//		Get data from excel sheet
		String tc_name="TC_Service_Creation_SC04";
		
		       
		
		String Username = Excel_data.get("Username");
        String Password = Excel_data.get("Password");
        String ModuleSearch = Excel_data.get("Module_Search");
        String Frequ = Excel_data.get("Frequency");
		String NoShips = Excel_data.get("No_Ships");
		String invalidFrequ = Excel_data.get("InvalidFrequency");
		String invalidNoShips = Excel_data.get("InvalidNoOfShips");
		String service_Code = Excel_data.get("Service_Code");
		String service_Name = Excel_data.get("Service_Name");
		String noOfBound = Excel_data.get("NoOfBound");
		String serviceType = Excel_data.get("ServiceType");
		String ext_Fdr = Excel_data.get("Ext_Fdr");
		String startDate = Excel_data.get("StartDate");
		String endDate = Excel_data.get("EndDate");
		String pnl_ServiceType = Excel_data.get("PNL_ServiceType");
		String status = Excel_data.get("Status");
		String endDateGreaterPopup = Excel_data.get("EndDateGreaterPopup");
		String negativeFrequencyPopup = Excel_data.get("NegativeFrequencyPopup");
		String negativeNoOfShipsPopup = Excel_data.get("NegativeNoOfShipsPopup");
		String date_Picker = Excel_data.get("DatePicker");
		String Ext_FDR_Disable_Status = Excel_data.get("Ext_FDR_Disable_Status");

		
		Extent_Start(tc_name, test, test1);

		navigateUrl(driver, url);
	// Login
		
		LRP_Login(driver, Username, Password);
		
		moduleNavigate(driver, ModuleSearch);
		
		
//	Service creation
		
		Step_Start(1, " Click on the new button in the toolbar",test, test1);
		
		newButton(driver);
		
		Step_End(1, "Click on the new button in the toolbar",test, test1);

		waitForElement(driver, Service_CodeI);		
		System.out.println("Service Code " + service_Code);
		click(driver, Service_CodeI);
		waitForElement(driver, Service_CodeI);		
		sendKeys(driver, Service_CodeI, service_Code);
		
		waitForElement(driver, Service_NameI);
		System.out.println("Service Name " + service_Name);
		sendKeys(driver, Service_NameI, service_Name);
		
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

		
		Step_Start(2, "Enter the Frquency field value with negative(-) number",test, test1);

		waitForElement(driver, Freqency);
		doubleClick(driver, frequency_Textfield);
		new Actions(driver).sendKeys(invalidFrequ).perform();
		
		Step_End(2, "Enter the Frquency field value with negative(-) number",test, test1);

		
		Step_Start(3, "pop message states Frequency should not be Negative and should remove the value entered from the field",test, test1);

		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
		String ActText = getText(driver,popup_Message);
		
		System.out.println(ActText);
		if (negativeFrequencyPopup.equals(ActText)) {
			Extent_pass_New(driver, "Matched || Expected Popup :"+negativeFrequencyPopup+" || Actual Popup :"+ActText, test, test1);
			System.out.println("Matched || Expected Popup :"+negativeFrequencyPopup+" || Actual Popup :"+ActText);
			if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);
			}
			waitForElement(driver, Freqency);
			doubleClick(driver, frequency_Textfield);
			new Actions(driver).sendKeys(Frequ).perform();
			
		}		
//		else {
//			System.out.println("Not Matched || Expected Popup :"+negativeFrequencyPopup+" || Actual Popup :"+ActText);
//
//			extent_fail(driver, "Not Matched || Expected Popup :"+negativeFrequencyPopup+" || Actual Popup :"+ActText, test, test1);
//		}
		}
//		else {
//			Extent_cal(test, test1, "Expected Failure Due To Functionality Not Working As Expected");
//			Extent_fail(driver, "Frequency should not be Negative popup is not displayed", test, test1);
//			System.out.println("Frequency should not be Negative popup is not displayed");
//		}

		Step_End(3, "pop message states Frequency should not be Negative and should remove the value entered from the field",test, test1);

		Step_Start(4, "Enter the No.of Ships field value with negative(-) number", test, test1);
		
		waitForElement(driver, No_of_Ships1);
		click(driver, No_of_Ships1);

		new Actions(driver).sendKeys(invalidNoShips).perform();
		
		Extent_pass_New(driver, "invalidNoShips: "+invalidNoShips, test, test1);
		System.out.println("invalidNoShips: "+invalidNoShips);
		
		Step_End(4, "Enter the No.of Ships field value with negative(-) number",test, test1);

		Step_Start(5, "pop message states No.of Ships should not be Negative and should remove the value entered from the field",test, test1);
		
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
		String ActText = getText(driver,popup_Message);
		System.out.println(ActText);
		if (negativeNoOfShipsPopup.equals(ActText)) {
			Extent_pass_New(driver, "Matched || Expected Popup :"+negativeNoOfShipsPopup+" || Actual Popup :"+ActText, test, test1);
			System.out.println("Matched || Expected Popup :"+negativeNoOfShipsPopup+" || Actual Popup :"+ActText);
			if(isdisplayed(driver, popup_Message_Ok_Button)) {

			click(driver, popup_Message_Ok_Button);
			}
			waitForElement(driver, No_of_Ships1);
			click(driver, No_of_Ships1);
			new Actions(driver).sendKeys(NoShips).perform();
			
		}
//		else {
//			System.out.println("Not Matched || Expected Popup :"+negativeNoOfShipsPopup+" || Actual Popup :"+ActText);
//
//			extent_fail(driver, "Not Matched || Expected Popup :"+negativeNoOfShipsPopup+" || Actual Popup :"+ActText, test, test1);
//		}
		}
//		else {
//			Extent_cal(test, test1, "Expected Failure Due To Functionality Not Working As Expected");
//			extent_fail(driver, "No.of Ships should not be Negative popup is not displayed", test, test1);
//			System.out.println("No.of Ships should not be Negative popup is not displayed");
//		}
		
		Step_End(5, "pop message states No.of Ships should not be Negative and should remove the value entered from the field",test, test1);

		
		waitForElement(driver, ext_FDR_Dropdown);
		if(!serviceType.equals(Ext_FDR_Disable_Status)) {   
		waitForElement(driver, Ext_Fdr);
		click(driver,Ext_Fdr);
		
		String select_EXT_Fdr=String.format(DropDown_Select,ext_Fdr);
		
		waitForElement(driver, select_EXT_Fdr);
		click(driver, select_EXT_Fdr);
		}
		
		Step_Start(6, "Enter the End Date Lesser than Start Date",test, test1);

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
		
		
		Step_End(6, "Enter the End Date Lesser than Start Date",test, test1);

		waitForElement(driver,status_Dropdown_SER);
		click(driver,status_Dropdown_SER);
		
		String select_Status=String.format(DropDown_Select,status);
		
		waitForElement(driver, select_Status);
		click(driver, select_Status);
		
		Step_Start(7, "Click on Save button",test, test1);

		scrollTop(driver);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		Step_End(7, "Click on Save button", test, test1);
		// End date lesser than start date
		Step_Start(8, "pop up message shows End date should be greater than Start Date", test, test1);
			
		waitForPopup(driver, popup_Message, endDateGreaterPopup);
			String actText = getText(driver,popup_Message);
				
				if (endDateGreaterPopup.equals(actText)) {
					Extent_pass_New(driver, "Matched || Expected Popup :"+endDateGreaterPopup+" || Actual Popup :"+actText, test, test1);
					System.out.println("Matched || Expected Popup :"+endDateGreaterPopup+" || Actual Popup :"+actText);
					click(driver,popup_Message_Ok_Button);

				}else {
					System.out.println("Not Matched || Expected Popup :"+endDateGreaterPopup+" || Actual Popup :"+actText);

					extent_fail(driver, "Not Matched || Expected Popup :"+endDateGreaterPopup+" || Actual Popup :"+actText, test, test1);
				}
		
		Step_End(8, "pop up message shows End date should be greater than Start Date", test, test1);
		
		Extent_completed(tc_name, test, test1);

		
	}

}
