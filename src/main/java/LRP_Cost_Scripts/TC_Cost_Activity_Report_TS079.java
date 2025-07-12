package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS079 extends Keywords{

	public void  Cost_Activity_Report_TS079(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS079";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String activity_Module = Excel_data.get("Activity_Module");
		String activityDescription = Excel_data.get("ActivityDescription");
		String activityCode = Excel_data.get("ActivityCode");
		String activity_Type = Excel_data.get("Activity_Type");
		String contract_Type = Excel_data.get("Contract_Type");
		String vendorCode = Excel_data.get("VendorCode");
		String currencyCode = Excel_data.get("CurrencyCode");
		String Amount_Activity = Excel_data.get("Amount_Activity");
		String Amount_Mics = Excel_data.get("Amount_Mics");
		String Select_Mode_type = Excel_data.get("Select_Mode_type");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Service_details_Codition = Excel_data.get("Service_details_Codition");
		String Arrival_Date_Condition = Excel_data.get("Arrival_Date_Condition");
		String Arrival_Date_Value = Excel_data.get("Arrival_Date_Value");
		String Service_Header = Excel_data.get("Service_Header");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String Port_Header = Excel_data.get("Port_Header");
		String Terminal_Header = Excel_data.get("Terminal_Header");
		String Arrival_Date_Header = Excel_data.get("Arrival_Date_Header");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String CAR_Already_Created = Excel_data.get("CAR_Already_Created");
		String Activity_Header_CAR = Excel_data.get("Activity_Header_CAR");
		String EqpType_Filter_Header = Excel_data.get("EqpType_Filter_Header");
		String Quantity = Excel_data.get("Quantity");
		String EqpType = Excel_data.get("EqpType");
		String CAR_Saved_Poupup = Excel_data.get("CAR_Saved_Poupup");
		String Activity_Saved_Popup = Excel_data.get("Activity_Saved_Popup");		
		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		
		Step_Start(1, "Once login to the application, enter the screen name as\"Activity\" in the module search field.", test, test1);
		
		moduleNavigate(driver, activity_Module);
		
		Step_End(1, "Once login to the application, enter the screen name as\"Activity\" in the module search field.", test, test1);
		Step_Start(2, "Enter the Activity code with the required alphabets and give the required activity description and select the actvity type as Sub and contract type as MSC and click the add button and select the required port and then click on the add option,then add the record to AG grid.", test, test1);
		
		waitForElement(driver, switch_Button_CAR);
		click(driver, switch_Button_CAR);
		
		
		List<String> Activity_Codes=splitAndExpand(activityCode);
		List<String> Description_Values=splitAndExpand(activityDescription);
		List<String> currencyCode_Lists=splitAndExpand(currencyCode);
		List<String> Amount_Lists=splitAndExpand(Amount_Activity);		
		
		for(int i=0;i<Activity_Codes.size();i++) {
			
			waitForElement(driver, activity_Code_Textfield);
			sendKeys(driver, activity_Code_Textfield, Activity_Codes.get(i));

			waitForElement(driver, activity_Description_Textfield);
			sendKeys(driver, activity_Description_Textfield, Description_Values.get(i));
			
			waitForElement(driver, activity_Type_Dropdown);
			click(driver, activity_Type_Dropdown);
			formatLocatorClick(driver, DropDown_Select, activity_Type);
			
			waitForElement(driver, contractTypeDropdown);
			click(driver, contractTypeDropdown);
			formatLocatorClick(driver, DropDown_Select, contract_Type);
			
			waitForElement(driver, port_Add_Button);
			click(driver, port_Add_Button);
			
			waitForElement(driver, portCode_Filter);
			click(driver, portCode_Filter);
			sendKeys(driver, portCode_Filter, Port_Code);

			String select_Port=String.format(portList_Filter_Checkbox, Port_Code);
			waitForElement(driver, select_Port);
			click(driver, select_Port);
			
			waitForElement(driver, portList_Filter_Ok_Button);
			click(driver, portList_Filter_Ok_Button);
			
			waitForElement(driver, activity_Currency_Gridcell);
			click(driver, activity_Currency_Gridcell);
			
			waitForElement(driver, activity_Currency_Gridcell_Dropdown);
			click(driver, activity_Currency_Gridcell_Dropdown);
			
			String select_Currency=String.format(DropDown_Select, currencyCode_Lists.get(i));
			waitForElement(driver, select_Currency);
			click(driver, select_Currency);
			
			waitForElement(driver, activity_Amount_Gridcell);
			click(driver, activity_Amount_Gridcell);
			
			waitForElement(driver, activity_Amount_Gridcell_Input);
			click(driver, activity_Amount_Gridcell_Input);
			clearAndType(driver, activity_Amount_Gridcell_Input, Amount_Lists.get(i));
			
			waitForElement(driver, activity_Currency_Gridcell);
			click(driver, activity_Currency_Gridcell);
			
			waitForElement(driver, activity_Add_Button);
			click(driver, activity_Add_Button);			
		}
		
		Step_End(2, "Enter the Activity code with the required alphabets and give the required activity description and select the actvity type as Sub and contract type as MSC and click the add button and select the required port and then click on the add option,then add the record to AG grid.", test, test1);
		Step_Start(3, "Next click the save option in the toolbar", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Activity_Saved_Popup);
		String Activity_SavedPopupAct=getText(driver, popup_Message);
		if(Activity_Saved_Popup.equalsIgnoreCase(Activity_SavedPopupAct)) {
			System.out.println("Popup Matched || Expected : "+Activity_Saved_Popup+" || Actual : "+Activity_SavedPopupAct);
			Extent_pass_New(driver, "Popup Matched || Expected : "+Activity_Saved_Popup+" || Actual : "+Activity_SavedPopupAct, test, test1);
		}else {
			System.out.println("Popup Not Matched || Expected : "+Activity_Saved_Popup+" || Actual : "+Activity_SavedPopupAct);
			Extent_fail(driver, "Popup Not Matched || Expected : "+Activity_Saved_Popup+" || Actual : "+Activity_SavedPopupAct, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(3, "Next click the save option in the toolbar", test, test1);

		Step_Start(4, "Next switch to the required agency and enter the screen name as \"Cost activity report\" in the module search field. Select the contract type as MSC.", test, test1);
	
		SwitchProfile(driver, AgencyUser);
		
		moduleNavigate(driver, Cost_Activity_Report_Module);
		
		waitForElement(driver, Contract_Type_Input_CAR);
		click(driver,Contract_Type_Input_CAR);
		
		String SelectContract=String.format(Select_Contract_Type_CAR, contract_Type);
		waitForElement(driver, SelectContract);
		click(driver,SelectContract);
		
		waitForElement(driver, Mode_Select_Input_CAR);
		click(driver,Mode_Select_Input_CAR);
		
		String SelectModeValue=String.format(Select_Mode_type_CAR, Select_Mode_type);
		waitForElement(driver, SelectModeValue);
		click(driver,SelectModeValue);
		
		Step_End(4, "Next switch to the required agency and enter the screen name as \"Cost activity report\" in the module search field. Select the contract type as MSC.", test, test1);
		Step_Start(5, "Enter the required service,vessel,port,terminal,arrival date from their respective searches.", test, test1);
		
		waitForElement(driver, Service_Search_Btn_CAR);
		click(driver,Service_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Service_Header,Service_details_Codition,Service_Code);

		waitForElement(driver, Vessel_Search_Btn_CAR);
		click(driver,Vessel_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Vessel_Header,Service_details_Codition,Vessel_Code);

		
		waitForElement(driver, Port_Search_Btn_CAR);
		click(driver,Port_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Port_Header,Service_details_Codition,Port_Code);

		
		waitForElement(driver, Terminal_Search_Btn_CAR);
		click(driver,Terminal_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Terminal_Header,Service_details_Codition,Terminal_Code);

		
		waitForElement(driver, Arrival_Date_Search_Btn_CAR);
		click(driver,Arrival_Date_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Arrival_Date_Header,Arrival_Date_Condition,Arrival_Date_Value);

		
		Step_End(5, "Enter the required service,vessel,port,terminal,arrival date from their respective searches.", test, test1);
		
		Step_Start(6, "Click on the show option", test, test1);
		
		waitForElement(driver, Show_Button_CAR);
		click(driver,Show_Button_CAR);
		
		if(isdisplayed(driver, popup_Message)) {
			String popup_Act=getText(driver, popup_Message);
			if(CAR_Already_Created.equals(popup_Act)) {
				System.out.println("Expected : CAR should not Already Created for the given inputs || Actual : CAR Already created for the given inputs");
				Extent_FailNew(driver, "Expected : CAR should not Already Created for the given inputs || Actual : CAR Already created for the given inputs", test, test1);
			}else {
				System.out.println("Expected : Popup Should not Displayed when click the CAR Show button || Actual : Popup displayed When click the CAR Show button , Error : "+popup_Act );
				Extent_fail(driver, "Expected : Popup Should not Displayed when click the CAR Show button || Actual : Popup displayed When click the CAR Show button , Error : "+popup_Act , test, test1);
			}
		}
		
		Step_End(6, "Click on the show option", test, test1);
		
		Step_Start(7, "Next click on the ADD option", test, test1);
		
		waitForElement(driver, ADD_button_MSC_CAR);
		click(driver, ADD_button_MSC_CAR);
		
		
		Step_End(7, "Next click on the ADD option", test, test1);
		Step_Start(8, "Ensure that the newly added activities are shown and select the required sub-activities.", test, test1);

		twoColumnSearchWindowMultipleValue(driver,Activity_Header_CAR,Service_details_Codition,activityCode);

		elementnotvisible1(driver, select_Button);
		List<String> Activities=splitAndExpand(activityCode);
		for(String act:Activities) {
			String UpdatedActivity=String.format(MSC_table_Activity_Column_CAR_New, act);
			if(isDisplayed(driver, UpdatedActivity)) {
				System.out.println("Expected : Newly added Activity '"+act+"' Should Updated in the Table || Actual : Newly added Activity '"+act+"' is Updated in the Table");
				Extent_pass_New(driver, "Expected : Newly added Activity '"+act+"' Should Updated in the Table || Actual : Newly added Activity '"+act+"' is Updated in the Table", test, test1);
			}else {
				System.out.println("Expected : Newly added Activity '"+act+"' Should Updated in the Table || Actual : Newly added Activity '"+act+"' is not Updated in the Table");
				Extent_fail(driver, "Expected : Newly added Activity '"+act+"' Should Updated in the Table || Actual : Newly added Activity '"+act+"' is not Updated in the Table", test, test1);
			}
		}
		
		Step_End(8, "Ensure that the newly added activities are shown and select the required sub-activities.", test, test1);
		Step_Start(9, "Select the required added activities ", test, test1);

		List<String> EqpTypeList=splitAndExpand(EqpType);
		List<String> QuantityList=splitAndExpand(Quantity);
		List<String> Vendor_Code_List=splitAndExpand(vendorCode);
		List<String> Amount_List=splitAndExpand(Amount_Mics);
		
		for(int i=0;i<Activities.size();i++) {
			String UpdatedActivityQuantColumn=String.format(MSC_table_Quantity_Column_CAR_New, Activities.get(i));
			waitForElement(driver, UpdatedActivityQuantColumn);
			doubleClick(driver, UpdatedActivityQuantColumn);
			
			String UpdatedActivityQuan=String.format(MSC_table_Quantity_input_CAR_New, Activities.get(i));
			waitForElement(driver, UpdatedActivityQuan);
			sendKeys(driver, UpdatedActivityQuan, QuantityList.get(i));
			formatLocatorClick(driver, MSC_table_Activity_Column_CAR_New, Activities.get(i));
			
			waitForElement(driver, MSC_Equipment_Type_Button_CAR);
			click(driver,MSC_Equipment_Type_Button_CAR);
			twoColumnSearchWindow(driver,EqpType_Filter_Header,Service_details_Codition,EqpTypeList.get(i));
			
			waitForElement(driver, MSC_Vendor_Code_Button_CAR);
			click(driver,MSC_Vendor_Code_Button_CAR);
			twoColumnSearchWindow(driver,Vendor_Code_Header,Service_details_Codition,Vendor_Code_List.get(i));

			String Activity_Amount_Col=String.format(MSC_Table_Amount_Column_CAR_New, Activities.get(i));
			waitForElement(driver, Activity_Amount_Col);
			doubleClick(driver,Activity_Amount_Col);
			
			String Activity_Amount_Input=String.format(MSC_Table_Amount_Input_CAR_New, Activities.get(i));
			System.out.println("Amount_List : "+Amount_List.get(i));
			waitForElement(driver, Activity_Amount_Input);
			clear(driver,Activity_Amount_Input);
			waitForElement(driver, Activity_Amount_Input);
			sendKeys(driver, Activity_Amount_Input,Amount_List.get(i));
		    
			formatLocatorClick(driver, MSC_table_Activity_Column_CAR_New, Activities.get(i));
		}
		Step_End(9, "Select the required added activities ", test, test1);
		
		Step_Start(10, "Click the save option in the toolbar and system validates as\"Container report activity saved\".Click the ok option.", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, CAR_Saved_Poupup);
		String Act_CAR_SavedPopup=getText(driver, popup_Message);
		if(CAR_Saved_Poupup.equalsIgnoreCase(Act_CAR_SavedPopup)) {
			System.out.println("Popup Matched || Expected : "+CAR_Saved_Poupup+" || Actual : "+Act_CAR_SavedPopup);
			Extent_pass_New(driver, "Popup Matched || Expected : "+CAR_Saved_Poupup+" || Actual : "+Act_CAR_SavedPopup, test, test1);
		}else {
			System.out.println("Popup Not Matched || Expected : "+CAR_Saved_Poupup+" || Actual : "+Act_CAR_SavedPopup);
			Extent_fail(driver, "Popup Not Matched || Expected : "+CAR_Saved_Poupup+" || Actual : "+Act_CAR_SavedPopup, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(10, "Click the save option in the toolbar and system validates as\"Container report activity saved\".Click the ok option.", test, test1);

		Extent_completed(tc_Name, test, test1);
	}
}
