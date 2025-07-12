package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_049  extends Keywords{
	public void Delivery_Order_TS_049(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_049";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String attribute = Excel_data.get("Attribute");
		String description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String bl_Number=Excel_data.get("BL_Number");
		String Status = Excel_data.get("Status");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String module_ImportInvoice = Excel_data.get("module_ImportInvoice");
		String Dock_Msg = Excel_data.get("Dock_Msg");
		String Factory_Msg = Excel_data.get("Factory_Msg");
		String Print_DO_Check_Box_Select = Excel_data.get("Print_DO_Check_Box_Select");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String globalSearchFilterOption_DO = Excel_data.get("globalSearchFilterOption_DO");
		String globalSearchFilterOption_Invoice = Excel_data.get("globalSearchFilterOption_Invoice");
		String Configuration_Reset = Excel_data.get("Configuration_Reset");
		String status_Filer_Data = Excel_data.get("status_Filer_Data");
		String Revert_Action = Excel_data.get("DO_Reset_Action");
		String globalSearchFilterOption_DO_Reset = Excel_data.get("globalSearchFilterOption_DO_Reset");
		String remarks = Excel_data.get("DO_Reset_Remarks");
		String module_Delivery_Order_Reset = Excel_data.get("module_Delivery_Order_Reset");
		String InvoiceReversed_Status_Filer_Data = Excel_data.get("InvoiceReversed_Status_Filer_Data");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String set_As_Default = Excel_data.get("Set_As_Default");
		String Condition = Excel_data.get("Condition");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1,"Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header,Condition, AgencyUser, attribute, description, value);
		Step_Start(5, "Open import invoice screen ", test, test1);
		moduleNavigate(driver, module_ImportInvoice);
		Step_End(5, "Open import invoice screen ", test, test1);
		Step_Start(6, "Click search and paste the bl", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver,dropdownCondition,globalSearchFilterOption_Invoice,bl_Number, "", "", "", "");
		Step_End(6, "Click search and paste the bl", test, test1);
		Step_Start(7, "fetch the record and copy the Destuffing mode", test, test1);
		globalValueSearchWindowScrollAndSelect(driver, InvoiceReversed_Status_Filter, InvoiceReversed_Status_Filer_Data);
		Step_End(7, "fetch the record and copy the Destuffing mode", test, test1);
		Step_Start(8, "Open Delivery order screen", test, test1);
		waitForElement(driver, Import_Invoice_Dock_ChkBox);
		String Dock_Status = getAttribute(driver, Import_Invoice_Dock_ChkBox, "class");
		waitForElement(driver, Import_Invoice_Factory_ChkBox);
		String Factory_Status = getAttribute(driver, Import_Invoice_Factory_ChkBox, "class");
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(8, "Open Delivery order screen", test, test1);
		Step_Start(9, "Click search button and paste the Bl number ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver,dropdownCondition,globalSearchFilterOption_DO,bl_Number, "", "", "", "");
		globalValueSearchWindowScrollAndSelect(driver, status_Filter_DO, status_Filer_Data);

		Step_End(9, "Click search button and paste the Bl number ", test, test1);
		Step_Start(10, "Select the Print DO check box ", test, test1);
		waitForElement(driver, Print_DO_Check_Box);
		checkBox(driver, Print_DO_Check_Box, Print_DO_Check_Box_Select);
		Step_End(10,"Select the Print DO check box ", test, test1);
		Step_Start(11,"Click the Print  button", test, test1);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		Step_End(11, "Click the Print  button", test, test1);
		Step_Start(12,"Ensure System will open print page and header should be matched with copied destuffing mode", test, test1);
		waitForElement(driver, PDF_Viewer);
		switchToFrame(driver, jsp_Iframe);
		if(Dock_Status.contains(Status)) {
			String Dock = String.format(Print_Header, Dock_Msg);
			String Actual_Header = getText(driver, Dock);
			if(Dock_Msg.equals(Actual_Header)) {
				Extent_pass_New(driver, "Matched || Expected PDF Message is : "+Dock_Msg+" || Actual PDF Message is : "+Actual_Header, test, test1);
				System.out.println( "Matched || Expected PDF Message is : "+Dock_Msg+" || Actual PDF Message is : "+Actual_Header);
			}else {
				System.out.println("Not Matched || Expected PDF Message is : "+Dock_Msg+" || Actual PDF Message is : "+Actual_Header);
				Extent_fail(driver,"Not Matched || Expected PDF Message is : "+Dock_Msg+" || Actual PDF Message is : "+Actual_Header, test, test1);
			}
		}else if(Factory_Status.contains(Status)) {
			String factory = String.format(Print_Header, Factory_Msg);
			String Actual_Header = getText(driver,factory);
			if(Factory_Msg.equals(Actual_Header)) {
				Extent_pass_New(driver, "Matched || Expected PDF Message is : "+Factory_Msg+" || Actual PDF Message is : "+Actual_Header, test, test1);
				System.out.println( "Matched || Expected PDF Message is : "+Factory_Msg+" || Actual PDF Message is : "+Actual_Header);
			}else {
				System.out.println("Not Matched || Expected PDF Message is : "+Factory_Msg+" || Actual PDF Message is : "+Actual_Header);
				Extent_fail(driver,"Not Matched || Expected PDF Message is : "+Factory_Msg+" || Actual PDF Message is : "+Actual_Header, test, test1);
			}
		}else {
			System.out.println("Not Matched || Expected Result is : The Invoice Dock (OR) Factory Check Box Should be Selected || The Actual Result is : Invoice Dock (OR) Factory Check Boxes are Not Selected");
			Extent_fail(driver,"Not Matched || Expected Result is : The Invoice Dock (OR) Factory Check Box Should be Selected || The Actual Result is : Invoice Dock (OR) Factory Check Boxes are Not Selected", test, test1);
		}
		Step_End(12, "Ensure System will open print page and header should be matched with copied destuffing mode", test, test1);
		switchToDefaultFrame(driver);
		waitForElement(driver, close_Button_PDF_Viewer);
		click(driver, close_Button_PDF_Viewer);
		if(Revert_Action.equalsIgnoreCase("Yes")) {
			Extent_cal(test, test1, module_Delivery_Order_Reset);
			moduleNavigate(driver, module_Delivery_Order_Reset);
			waitForElement(driver, DO_Number_SearchButton);
			click(driver, DO_Number_SearchButton);
			globalValueSearchWindow(driver,dropdownCondition,globalSearchFilterOption_DO_Reset,bl_Number, "", "", "", "");
			waitForElement(driver, DO_Reset_Remarks_Area);
			sendKeys(driver, DO_Reset_Remarks_Area, remarks);
			waitForElement(driver, DO_Reset_Button);
			click(driver, DO_Reset_Button);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, Configuration_Reset, newlyadded, set_As_Default);
		Extent_completed(testcase_Name, test, test1);
	}
}