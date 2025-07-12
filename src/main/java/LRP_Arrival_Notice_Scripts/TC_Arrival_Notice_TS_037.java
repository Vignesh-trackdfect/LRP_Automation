package LRP_Arrival_Notice_Scripts;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_037 extends Keywords{
	public void Arrival_Notice_TS_037(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testcase_Name="TC_Arrival_Notice_TS_037";

		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String agencyUser =Excel_data.get("AgencyUser");
		String arrival_Module_Search =Excel_data.get("Arrival_Module_Search");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Search_Number = Excel_data.get("Search_Number");
		String bl_Number = Excel_data.get("bl_Number");
		String columnHeaders = Excel_data.get("columnHeaders");
		String Manifest_Module = Excel_data.get("Manifest_Module");
		String Corection_Type_Option = Excel_data.get("Corection_Type_Option");
		String Search_Number1 = Excel_data.get("Search_Number1");
		String Customer_Type = Excel_data.get("Customer_Type");
		String Customer_Type_Option = Excel_data.get("Customer_Type_Option");
		String Customer_code =Excel_data.get("Customer_code");
		String Customer = Excel_data.get("Customer_System_Code");
		String MCN_Remarks_Input = Excel_data.get("MCN_Remarks_Input");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String Refresh_Popup_Msg = Excel_data.get("Refresh_Popup_Msg");
		String Request_Type = Excel_data.get("Request_Type");
		
		String request_select =  String.format(Request_Type_select, Request_Type);

		
		
	
	
	


		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		// Login to the Application

		LRP_Login(driver, username, password);

		Step_Start(1, "Switch the agency ", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, "Switch the agency ", test, test1);

		Step_Start(2, "OPEN arrival notice freight memo screen", test, test1);


		
		moduleNavigate(driver, arrival_Module_Search);

		Step_End(2, ".Search the module name   \"Arrival Notice / Freight Memo\"  in module search", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(2, "OPEN arrival notice freight memo screen", test, test1);

		Step_Start(3, "Click search button and paste the BL", test, test1);
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "","", "","");
		
		
		Step_End(3, "Click search button and paste the BL", test, test1);

		Step_Start(4, "Click search and fetch the details.", test, test1);



		Step_End(4, "Click search and fetch the details.", test, test1);

		Step_Start(5, "Copy the consignee customer code and name", test, test1);

		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		click(driver, condition_Filter_AN);
		sendKeys(driver, blNumber_Filter_AN,bl_Number );
		
		reArrangeAG_GridColumnsNew(driver, AN_coloum_click, columnHeaders);
		
		waitForElement(driver, consigneeAddress_AN_Grid);
		String actualconsignee_Code_AN=getText(driver, consignee_Code_AN_Grid);
		String actualConsignee_AN=getText(driver, consignee_AN_Grid);
		System.out.println("actualconsignee_Code_AN :  "+actualconsignee_Code_AN);
		System.out.println("actualConsignee_AN : "+actualConsignee_AN);
		Step_End(5, "Copy the consignee customer code and name", test, test1);

		Step_Start(6, "Manifest Correction notes (MCN)", test, test1);
		scrollTop(driver);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		moduleNavigate(driver, Manifest_Module);

		Step_End(6, "Manifest Correction notes (MCN)", test, test1);

		Step_Start(7, "Select the correction type dropdown button", test, test1);

		waitForElement(driver, Corection_Type_DropDown);
		click(driver, Corection_Type_DropDown);
		String correctionType =  String.format(correctionType_MCN, Corection_Type_Option);
		Step_End(7, "Select the correction type dropdown button", test, test1);

		Step_Start(8, "Select \"change of BL Parties \" option", test, test1);

		waitForElement(driver, correctionType);
		click(driver, correctionType);
		Step_End(8, "Select \"change of BL Parties \" option", test, test1);

		Step_Start(9, "Click the BL search icon", test, test1);

		waitForElement(driver, BL_Search_Button);
		click(driver, BL_Search_Button);
		Step_End(9, "Click the BL search icon", test, test1);

		Step_Start(10, "paste the BL number and select the record ", test, test1);
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number1, bl_Number, "","", "","");
		
	
		Step_End(10, "paste the BL number and select the record ", test, test1);
		Step_Start(11, "Make sure system validated as \" Import Documentation has been done for this BL. Do you want to continue ? \" ", test, test1);

	

	waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);
		}
		Step_End(11, "Make sure system validated as \" Import Documentation has been done for this BL. Do you want to continue ? \" ", test, test1);

		Step_Start(12, "Click yes", test, test1);

		
		Step_End(12, "Click yes", test, test1);

		Step_Start(13, "Click customer tab and select consinee customer", test, test1);

		waitForElement(driver, Manifest_Customer_Tab);
		click(driver, Manifest_Customer_Tab); 
		
	

		String Customer_Select =  String.format(Arrival_Notice_Locators.Customer_Select_AN, Customer_Type);

		waitForElement(driver, Customer_Select);
		click(driver, Customer_Select); 
		Step_End(13, "Click customer tab and select consinee customer", test, test1);

		Step_Start(14, "Click the remove button", test, test1);

		waitForElement(driver, Customer_Remove);
		click(driver, Customer_Remove);
		Step_End(14, "Click the remove button", test, test1);

		Step_Start(15, "Click the customer type dropdown and select consignee", test, test1);

		waitForElement(driver, Customer_Type_Dropdown);
		click(driver, Customer_Type_Dropdown);  
		String Customer_Type_Select =  String.format(Arrival_Notice_Locators.ANCustomer_Type_Select, Customer_Type_Option);

		waitForElement(driver, Customer_Type_Select);
		click(driver, Customer_Type_Select); 
		Step_End(15, "Click the customer type dropdown and select consignee", test, test1);

		Step_Start(16, "Click customer search icon and enter the new customer code ", test, test1);

		waitForElement(driver, Manifest_Customer_Search);
		click(driver, Manifest_Customer_Search); 
		
		globalValueSearchWindow(driver, dropdownCondition1, Customer_code, Customer, "","", "","");	
		
		
		
	
		Step_End(16, "Click customer search icon and enter the new customer code ", test, test1);

		Step_Start(17, "Fetch the customer details", test, test1);

	

		Step_End(17, "Fetch the customer details", test, test1);

		Step_Start(18, "Click Add button and make sure consignee added to th grid ", test, test1);

		waitForElement(driver, Add_Button_mcn);
		click(driver, Add_Button_mcn);
		Step_End(18, "Click Add button and make sure consignee added to th grid ", test, test1);

		Step_Start(19, "Click save button and Ensure \"Do you want to save as Pending or Submit or Cancel for process? \"", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForDisplay(driver, Manifest_Pending_Button);
		if(IsElementEnabled(driver, Manifest_Pending_Button)) {
			
			Extent_pass(driver, "Matched || Expected Result is : Pending Button Should be Enable || Actual Result is : Pending Button  is Enabled", test, test1);
			System.out.println("Matched || Expected Result is : Pending Button  Should be Enable || Actual Result is :Pending Button  is Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is : Pending Button  Should be Enable || Actual Result is : Pending Button  is Not Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : Pending Button  Should be Enable || Actual Result is : DPending Button is Not Enabled", test, test1);
		}
		
		waitForDisplay(driver, Manifest_Submit_Button);
		if(IsElementEnabled(driver, Manifest_Submit_Button)) {
			Extent_pass(driver, "Matched || Expected Result is : Submit Button Should be Enable || Actual Result is : Submit Button  is Enabled", test, test1);
			System.out.println("Matched || Expected Result is : Submit Button  Should be Enable || Actual Result is :Submit Button  is Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is : Submit Button  Should be Enable || Actual Result is : Submit Button  is Not Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : Submit Button  Should be Enable || Actual Result is : Submit Button is Not Enabled", test, test1);
		}
			
		waitForDisplay(driver, Manifest_Cancel_Button);
		if(IsElementEnabled(driver, Manifest_Cancel_Button)) {
			Extent_pass(driver, "Matched || Expected Result is : Cancel Button Should be Enable || Actual Result is : Cancel Button  is Enabled", test, test1);
			System.out.println("Matched || Expected Result is : Cancel Button  Should be Enable || Actual Result is :Cancel Button  is Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is : Cancel Button  Should be Enable || Actual Result is : Cancel Button  is Not Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : Cancel Button  Should be Enable || Actual Result is : Cancel Button is Not Enabled", test, test1);
		}
			
		Step_End(19, "Click save button and Ensure \"Do you want to save as Pending or Submit or Cancel for process? \"", test, test1);

		Step_Start(20, "Click submit ", test, test1);

		waitForElement(driver, Manifest_Submit_Button);
		click(driver, Manifest_Submit_Button);
		Step_End(20, "Click submit ", test, test1);
		Step_Start(21, "Enter the remarks in next window and click OK", test, test1);

		waitForElement(driver, Remarks_Field);
		
		
		waitForDisplay(driver, request_select);
if(isdisplayed(driver, request_select)) {
	
	click(driver, request_select);
}
		sendKeys(driver, Remarks_Field, MCN_Remarks_Input);
		
		
		

		
		click(driver, Remarks_OK_Button);
		Step_End(21, "Enter the remarks in next window and click OK", test, test1);

		Step_Start(22, "Ensure system validated as \" MCN approved \" Click OK", test, test1);

		waitForDisplay(driver, popup_Message);
		if(isDisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Ok_Button);
		}
		Step_End(22, "Ensure system validated as \" MCN approved \" Click OK", test, test1);

		Step_Start(23, "Click cancel button on right corner\r\n"
				+ "", test, test1);

		
		Step_End(23, "Click cancel button on right corner\r\n"
				+ "", test, test1);

		Step_Start(24, "Open import documentation screen.", test, test1);

		waitForElement(driver, Mail_Cancel_button);
		click(driver, Mail_Cancel_button);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);



		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(24, "Open import documentation screen.", test, test1);

		Step_Start(25, "Click search icon and paste the BL number", test, test1);
		waitForElement(driver, SearchButton_Toolbar );
		click(driver, SearchButton_Toolbar);
		
		
		
		
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number1, bl_Number, "","", "","");
		
		Step_End(25, "Click search icon and paste the BL number", test, test1);

		Step_Start(26, "Click search and fetch the record ", test, test1);

	

		Step_End(26, "Click search and fetch the record ", test, test1);

		Step_Start(27, "Click edit button ", test, test1);
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(27, "Click edit button ", test, test1);

		Step_Start(28, "Ensure system showing \" \r\n"
				+ " MCN is available for this BL . Import documentation should be refresh \" and Customer check box has been selected \"", test, test1);

		waitForPopup(driver, Refresh_Popup, Refresh_Popup_Msg);    
		String actual_Refresh_Popup=getText(driver, Refresh_Popup);
		if (Refresh_Popup_Msg.trim().equals(actual_Refresh_Popup.trim())) {
			System.out.println("Matched || Expected value popup  was should be shown : " + Refresh_Popup_Msg + " || Actual value popup was : " + actual_Refresh_Popup);
			Extent_pass(driver, "Matched || Expected value popup was should be shown: " + Refresh_Popup_Msg + " || Actual value popup was : " + actual_Refresh_Popup, test,test1);
			Step_End(28, "Ensure system showing \" \r\n"
					+ " MCN is available for this BL . Import documentation should be refresh \" and Customer check box has been selected \"", test, test1);

			Step_Start(29, "Click refresh button", test, test1);


			click(driver, Refresh_Button);
		} else {
			System.out.println("NotMatched || Expected value popup was should be shown : " + Refresh_Popup_Msg + " || Actual value popup was : " + actual_Refresh_Popup);
			Extent_fail(driver, "NotMatched || Expected value popup was should be shown : " + Refresh_Popup_Msg + " || Actual value popup was : " + actual_Refresh_Popup,test, test1);

		}
		Step_End(29, "Click refresh button", test, test1);

		Step_Start(30, "Ensure consignee customer updated in customer tab", test, test1);
		Step_End(30, "Ensure consignee customer updated in customer tab", test, test1);
		Step_Start(31, "Click save button ", test, test1);
		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(31, "Click save button ", test, test1);

		Step_Start(32, "Ensure system validated as \"Import Documentation is updated \" Click OK", test, test1);

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);
		Step_End(33, "Ensure system validated as \"Import Documentation is updated \" Click OK", test, test1);

		Step_Start(32, "Click arrival notice button", test, test1);

		waitForElement(driver, AN_Arrival_notice_button);
		click(driver, AN_Arrival_notice_button);
		Step_End(33, "Click arrival notice button", test, test1);

		Step_Start(34, "Ensure system navigated to arrival notice screen", test, test1);

		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		click(driver, condition_Filter_AN);
		sendKeys(driver, blNumber_Filter_AN,bl_Number );
		reArrangeAG_GridColumnsNew(driver, AN_coloum_click,columnHeaders);
		
	
		Step_End(34, "Ensure system navigated to arrival notice screen", test, test1);

		Step_Start(35, "Select the BL and scroll right side", test, test1);
		waitForPopup(driver, consigneeAddress_AN_Grid, actualconsignee_Code_AN);    
		String actualconsignee_Code_AN_1=getText(driver, consignee_Code_AN_Grid);
		String actualConsignee_AN_1=getText(driver, consignee_AN_Grid);
		System.out.println("actualconsignee_Code_AN_1 :  "+actualconsignee_Code_AN_1);
		System.out.println("actualConsignee_AN_1 : "+actualConsignee_AN_1);
		Step_End(35, "Select the BL and scroll right side", test, test1);

		Step_Start(36, "Ensure latest consignee customer details has to be updated.", test, test1);

		if (!actualconsignee_Code_AN.trim().equals(actualconsignee_Code_AN_1.trim())) {
			System.out.println("Matched || Expected value Before The Customer Code was : " + actualconsignee_Code_AN + " || Actual value After The Customer Code was : " + actualconsignee_Code_AN_1);
			Extent_pass(driver, "Matched || Expected value Before The Customer Code was : " + actualconsignee_Code_AN + " || Actual value After The Customer Code was : " + actualconsignee_Code_AN_1, test,test1);
		} else {
			System.out.println("Not Matched || Expected value Before The Customer Code was : " + actualconsignee_Code_AN + " || Actual value After The Customer Code was : " + actualconsignee_Code_AN_1);
			Extent_fail(driver, "Not Matched || Expected value Before The Customer Code was : " + actualconsignee_Code_AN + " || Actual value After The Customer Code was : " + actualconsignee_Code_AN_1,test, test1);
		}
		if (!actualConsignee_AN.trim().equals(actualConsignee_AN_1.trim())) {
			System.out.println("Matched || Expected value Before The Customer Name was : " + actualConsignee_AN + " || Actual value After The Customer Name was : " + actualConsignee_AN_1);
			Extent_pass(driver,"Matched || Expected value Before The Customer Name was : " + actualConsignee_AN + " || Actual value After The Customer Name was : " + actualConsignee_AN_1, test,test1);
		} else {
			System.out.println("Not Matched || Expected value Before The Customer Name was : " + actualConsignee_AN + " || Actual value After The Customer Name was : " + actualConsignee_AN_1);
			Extent_fail(driver,"Not Matched || Expected value Before The Customer Name was : " + actualConsignee_AN + " || Actual value After The Customer Name was : " + actualConsignee_AN_1,test, test1);
		}
		Step_End(36, "Ensure latest consignee customer details has to be updated.", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
