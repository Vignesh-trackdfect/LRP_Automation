package LRP_EMS_Consolidation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_EquipmentActivity_TS_054_TS056_C extends Keywords {

	// For every execution, change active value

	public void equipmentActivity54_56(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset)
			throws Exception {

		int TC1=1;

		if(TC1==1) {
			String testcase_Name="TC_EquipmentActivity_SC54";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			String url = TestNgXml.getdatafromExecution().get(testcase_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset,
					File_Path);
			String Username = Excel_data.get("Username");
			String pass_word = Excel_data.get("pass_word");
			String Field_Names3 = Excel_data.get("module");
			String activity_Description = Excel_data.get("DescriptionVal");
			String savePop = Excel_data.get("Save_popup");
			String Activity_Group = Excel_data.get("Activity_Group");
			String Stock_Status = Excel_data.get("Stock_Status");
			String Empty_Full = Excel_data.get("Empty_Full");
			String Soc_Activity = Excel_data.get("Soc_Activity");
			String AllowForce = Excel_data.get("AllowForce");
			String Is_special = Excel_data.get("Is_special");
			String Auto_EIR = Excel_data.get("Auto_EIR");
			String Activity_Type = Excel_data.get("Activity_Type");
			String Stock_Location = Excel_data.get("Stock_Location");
			String EIR_Status = Excel_data.get("EIR_Status");
			String From_Loc = Excel_data.get("From_Loc");
			String To_Loc = Excel_data.get("To_Loc");
			String Link_Chassis = Excel_data.get("Link_Chassis");
			String BookingNoupdate = Excel_data.get("BookingNoupdate");
			String Pool_Chassis_Activity = Excel_data.get("Pool_Chassis_Activity");
			String Transmit_Indicator = Excel_data.get("Transmit_Indicator");
			String Non_Pool_Chassis_Activity = Excel_data.get("Non_Pool_Chassis_Activity");
			String Allow_Interchange = Excel_data.get("Allow_Interchange");
			String Master_Required = Excel_data.get("Master_Required");
			String activeValue = Excel_data.get("activeValue");
			String Exist_Popup = Excel_data.get("Exist_Popup");
			String Want_To_Delete = Excel_data.get("Want_To_Delete");
			String Global_Search_Type = Excel_data.get("Global_Search_Type");
			String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
			
			Extent_Start(testcase_Name, test, test1);

			// login
			navigateUrl(driver, url);
			LRP_Login(driver, Username, pass_word);

			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			// search module
			moduleNavigate(driver, Field_Names3);
			
			Step_Start(1, "Enter Valid Code for Activity code field", test, test1);
			// enter ativity code
			waitForElement(driver, kActivityCodeVal);
			sendKeys(driver, kActivityCodeVal, activeValue);
			System.out.println("Activity Code:"+activeValue);
			Step_End(1, "Enter Valid Code for Activity code field", test, test1);

			Step_Start(2, "Enter Description for Activity Description field", test, test1);

			waitForElement(driver, kActivityDescriptionVal);
			sendKeys(driver, kActivityDescriptionVal, activity_Description);
			enter(driver);
			System.out.println("Activity Description:"+activity_Description);
			Step_End(2, "Enter Description for Activity Description field", test, test1);

			Step_Start(3, " Select dropmenu correctly for Activity group", test, test1);
			// select activity group
			waitForElement(driver, kActivityGroup);
			click(driver, kActivityGroup);
			String Activity_Group_value =  String.format(DropDown_Select,  Activity_Group); 
			waitForElement(driver, Activity_Group_value);
			click(driver, Activity_Group_value);
			Step_End(3, " Select dropmenu correctly for Activity group", test, test1);

			Step_Start(4, "Select dropmenu correctly for Stock Status", test, test1);	 

			// select Stock status value
			waitForElement(driver, kStockStatusVal);
			click(driver, kStockStatusVal);
			String Stock_Status_value =  String.format(DropDown_Select,  Stock_Status); 
			waitForElement(driver, Stock_Status_value);
			click(driver, Stock_Status_value);
			System.out.println("Stock Status:"+Stock_Status);
			Step_End(4, "Select dropmenu correctly for Stock Status", test, test1);	 

			Step_Start(5, "Select dropmenu correctly for Empty/Full", test, test1);
			// select Empty/Full
			waitForElement(driver, kEmptyFullOpt);
			click(driver, kEmptyFullOpt);
			String Empty_Full_value =  String.format(DropDown_Select,  Empty_Full); 

			waitForElement(driver, Empty_Full_value);
			click(driver, Empty_Full_value);
			Step_End(5, "Select dropmenu correctly for Empty/Full", test, test1);

			Step_Start(6, "Select dropmenu correctly for Allow SOC Activity", test, test1);	
			// select Allow SOC Activity
			waitForElement(driver, kAllowSocActivity);
			click(driver, kAllowSocActivity);
			String Soc_activity1 =  String.format(DropDown_Select,  Soc_Activity); 

			click(driver, Soc_activity1);
			Step_End(6, "Select dropmenu correctly for Allow SOC Activity", test, test1);	

			Step_Start(7, "Select dropmenu correctly for Allow Force", test, test1);
			// select allow force
			waitForElement(driver, kAllowForce);
			click(driver, kAllowForce);
			String AllowForce_value =  String.format(DropDown_Select,  AllowForce); 

			click(driver, AllowForce_value);
			Step_End(7, "Select dropmenu correctly for Allow Force", test, test1);

			Step_Start(8, "Select dropmenu correctly for Is special", test, test1);
			// select Is special
		
			waitForElement(driver, kIsSpecial);
			click(driver, kIsSpecial);
			
			String Is_special_value =  String.format(DropDown_Select,  Is_special); 

			click(driver, Is_special_value);

			Step_End(8, "Select dropmenu correctly for Is special", test, test1);

			Step_Start(9, "Select dropmenu correctly for Auto EIR", test, test1);
			
			// select Auto Eir
			waitForElement(driver, kAutoEir);
			click(driver, kAutoEir);
			String Auto_EIR_value =  String.format(DropDown_Select,  Auto_EIR); 

			waitForElement(driver, Auto_EIR_value);
			click(driver, Auto_EIR_value);
			Step_End(9, "Select dropmenu correctly for Auto EIR", test, test1);

			Step_Start(10, "Select dropmenu correctly for Activity Type", test, test1);	
			// select Activity type
			
			waitForElement(driver, kActivityType);
			click(driver, kActivityType);
			String Activity_Type_value =  String.format(DropDown_Select,  Activity_Type); 

			waitForElement(driver, Activity_Type_value);
			click(driver, Activity_Type_value);
			Step_End(10, "Select dropmenu correctly for Activity Type", test, test1);	

			// select stock location
			
			waitForElement(driver, kStockLocation);
			click(driver, kStockLocation);
			String Stock_Location_value =  String.format(DropDown_Select,  Stock_Location); 

			waitForElement(driver, Stock_Location_value);
			click(driver, Stock_Location_value);

			// select Eir status
			
			waitForElement(driver, kEirStatus);
			click(driver, kEirStatus);
			
			String EIR_Status_value =  String.format(DropDown_Select,  EIR_Status); 

			waitForElement(driver, EIR_Status_value);
			click(driver, EIR_Status_value);

			// Select from location
			waitForElement(driver, kFromLoc);
			waitForElement(driver, kFromLoc);
			click(driver, kFromLoc);
			String From_Loc_value =  String.format(DropDown_Select,  From_Loc); 

			waitForElement(driver, From_Loc_value);
			click(driver, From_Loc_value);

			// select to location
			waitForElement(driver, kToLoc);
			click(driver, kToLoc);
			String To_Loc_value =  String.format(DropDown_Select,  To_Loc); 

			click(driver, To_Loc_value);

			
			// non mandatory fields
			if (!Link_Chassis.equals("")) {
				waitForElement(driver, LinkChasis);
				click(driver, LinkChasis);
				String Link_Chassis_value =  String.format(DropDown_Select,  Link_Chassis); 

				click(driver, Link_Chassis_value);


			} else {

				System.out.println("Link_Chassis_Value " + "Input Not Available in test data");
			}

		
			if (!BookingNoupdate.equals("")) {
				waitForElement(driver, BookingNO_Update);
				click(driver, BookingNO_Update);
				String Booking_No_update_value =  String.format(DropDown_Select,  BookingNoupdate); 

				click(driver, Booking_No_update_value);


			} else {

				System.out.println("Booking_No_update_Value " + "Input Not Available in test data");
			}
			
			if (!Pool_Chassis_Activity.equals("")) {
				waitForElement(driver, pool_chasis_Activity);
				click(driver, pool_chasis_Activity);
				String Pool_Chassis_Activity_value =  String.format(DropDown_Select,  Pool_Chassis_Activity); 

				click(driver, Pool_Chassis_Activity_value);


			} else {

				System.out.println("Pool_Chassis_Activity_Value " + "Input Not Available in test data");
			}
			
			if (!Transmit_Indicator.equals("")) {
				waitForElement(driver, TransmitIndicator);
				click(driver, TransmitIndicator);
				
				String Transmit_Indicator_value =  String.format(DropDown_Select,  Transmit_Indicator); 

				click(driver, Transmit_Indicator_value);


			} else {

				System.out.println("Transmit_Indicator_Value " + "Input Not Available in test data");
			}
			
			if (!Non_Pool_Chassis_Activity.equals("")) {
				waitForElement(driver, Non_Pool_ChassisAct);
				click(driver, Non_Pool_ChassisAct);
				String Non_Pool_Chassis_Activity_value =  String.format(DropDown_Select,  Non_Pool_Chassis_Activity); 

				click(driver, Non_Pool_Chassis_Activity_value);

			} else {

				System.out.println("Non_Pool_Chassis_Activity_Value " + "Input Not Available in test data");
			}

			
			if (!Allow_Interchange.equals("")) {
				waitForElement(driver, AllowInterchage);
				click(driver, AllowInterchage);
				
				String Allow_Interchange_value =  String.format(DropDown_Select,  Allow_Interchange); 

				click(driver, Allow_Interchange_value);


			} else {

				System.out.println("Allow_Interchange_Value " + "Input Not Available in test data");
			}
			
			if (!Master_Required.equals("")) {
				waitForElement(driver, MasterReq);
				click(driver, MasterReq);
				String Master_Required_value =  String.format(DropDown_Select,  Master_Required); 

				waitForElement(driver, Master_Required_value);
				click(driver, Master_Required_value);


			} else {

				System.out.println("Master_Required_Value " + "Input Not Available in test data");
			}
			// verify the saved popup
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForPopup(driver, Popup_Message, savePop);
			String popup1 = getText(driver, Popup_Message);
			if (popup1.equals(savePop)) {
				System.out.println("Matched || Expected Popup was : " + savePop + " || Actual Popup was : " + popup1);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + savePop + " || Actual Popup was : " + popup1, test,
						test1);
			} else if (popup1.equals(Exist_Popup.trim())) {
				System.out.println("Matched || Expected Popup was : " + Exist_Popup + " || Actual Popup was : " + popup1);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + Exist_Popup + " || Actual Popup was : " + popup1,
						test, test1);
			}else {
				System.out.println("NotMatched || Expected Popup was : " + savePop + " || Actual Popup was : " + popup1);
				Extent_pass_New(driver, "NotMatched || Expected Popup was : " + savePop + " || Actual Popup was : " + popup1, test,
						test1);
			}

			waitForElement(driver, ActivitySearchOpt);
			click(driver, ActivitySearchOpt);
			waitForElement(driver, Equip_Size_Filter_EA);
			click(driver, Equip_Size_Filter_EA);
			waitForElement(driver, Equip_Filter_CheckBox);
			click(driver, Equip_Filter_CheckBox);
			sendKeys(driver, Equip_Filter_Search, activeValue);
			String active_Value_select =  String.format(Active_Value_Select,  activeValue.toUpperCase()); 
	        waitForElement(driver, active_Value_select);
	        click(driver, active_Value_select);
			waitForElement(driver, Equip_Size_Filter_EA);
			click(driver, Equip_Size_Filter_EA);
			// verify the popup
			waitForElement(driver, Firstgrid);
			String getpopup1 = getText(driver, Firstgrid);
			
			if (getpopup1.equals(activeValue)) {
				System.out
				.println("Matched || Expected value was : " + activeValue + " || Actual value was : " + getpopup1);
				Extent_pass_New(driver,
						"Matched || Expected value was : " + activeValue + " || Actual value was : " + getpopup1, test,
						test1);
			} else {
				System.out.println(
						"NotMatched || Expected value was : " + activeValue + " || Actual value was : " + getpopup1);
				Extent_fail(driver,
						"NotMatched || Expected value was : " + activeValue + " || Actual value was : " + getpopup1, test,
						test1);
			}
			
			if(Want_To_Delete.equalsIgnoreCase("Yes")) {

				scrollTop(driver);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, Global_Search_Condition, Global_Search_Type, activeValue, "", "", "", "");

				waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);

				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);

			    waitForElement(driver, Popup_Message);
				}
				
			Extent_completed(testcase_Name, test, test1);
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		
		
		int TC2=1;

		if(TC2==1) {
			
			String testcase_Name="TC_EquipmentActivity_SC55";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset,
					File_Path);
			String Field_Names3 = Excel_data.get("module");
			String activity_Description = Excel_data.get("DescriptionVal");
			String Activity_Group = Excel_data.get("Activity_Group");
			String Stock_Status = Excel_data.get("Stock_Status");
			String Empty_Full = Excel_data.get("Empty_Full");
			String Soc_Activity = Excel_data.get("Soc_Activity");
			String AllowForce = Excel_data.get("AllowForce");
			String Is_special = Excel_data.get("Is_special");
			String Auto_EIR = Excel_data.get("Auto_EIR");
			String Activity_Type = Excel_data.get("Activity_Type");
			String Stock_Location = Excel_data.get("Stock_Location");
			String EIR_Status = Excel_data.get("EIR_Status");
			String From_Loc = Excel_data.get("From_Loc");
			String To_Loc = Excel_data.get("To_Loc");
			String Link_Chassis = Excel_data.get("Link_Chassis");
			String BookingNoupdate = Excel_data.get("BookingNoupdate");
			String Pool_Chassis_Activity = Excel_data.get("Pool_Chassis_Activity");
			String Transmit_Indicator = Excel_data.get("Transmit_Indicator");
			String Non_Pool_Chassis_Activity = Excel_data.get("Non_Pool_Chassis_Activity");
			String Allow_Interchange = Excel_data.get("Allow_Interchange");
			String Master_Required = Excel_data.get("Master_Required");
			String DeletePopup = Excel_data.get("DeletePopup");
			String savePopup1 = Excel_data.get("savePopup1");
			String activeValue1 = Excel_data.get("activeValue1");
			String Matser_Module = Excel_data.get("Matser_Module");
			String Reactivation_Popup = Excel_data.get("Reactivation_Popup");

			Extent_Start(testcase_Name, test, test1);

			// login

			Extent_Start(testcase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & safeclick the module");
			// search module
			moduleNavigate(driver, Field_Names3);
			
			// Enter activity code
			waitForElement(driver, kActivityCodeVal);
			sendKeys(driver, kActivityCodeVal, activeValue1);
			// enter Description value
			waitForElement(driver, kActivityDescriptionVal);
			sendKeys(driver, kActivityDescriptionVal, activity_Description);
			enter(driver);
			// select activity group
			waitForElement(driver, kActivityGroup);
			safeclick(driver, kActivityGroup);
			
			String Activity_Group_value =  String.format(DropDown_Select,  Activity_Group); 

				waitForElement(driver, Activity_Group_value);
				safeclick(driver, Activity_Group_value);
			
			// Select Stock status value
			waitForElement(driver, kStockStatusVal);
			safeclick(driver, kStockStatusVal);
			
			String Stock_Status_value =  String.format(DropDown_Select,  Stock_Status); 

				safeclick(driver, Stock_Status_value);
			
			// Select Empty/Full
			waitForElement(driver, kEmptyFullOpt);
			safeclick(driver, kEmptyFullOpt);
			String Empty_Full_value =  String.format(DropDown_Select,  Empty_Full); 

			
				safeclick(driver, Empty_Full_value);
			
			// select Allow Soc Activity
			waitForElement(driver, kAllowSocActivity);
			safeclick(driver, kAllowSocActivity);
				
			
			String Soc_activity1 =  String.format(DropDown_Select,  Soc_Activity); 

				safeclick(driver, Soc_activity1);
			
			// Select Allow force
			
			waitForElement(driver, kAllowForce);
			safeclick(driver, kAllowForce);
				
			String AllowForce_value =  String.format(DropDown_Select,  AllowForce); 

				safeclick(driver, AllowForce_value);
			
			// select Is special
			waitForElement(driver, kIsSpecial);
			safeclick(driver, kIsSpecial);
			
			String Is_special_value =  String.format(DropDown_Select,  Is_special); 

				waitForElement(driver, Is_special_value);;
				safeclick(driver, Is_special_value);
			
			// select Auto EIR
		
			waitForElement(driver, kAutoEir);
			safeclick(driver, kAutoEir);
				
			String Auto_EIR_value =  String.format(DropDown_Select,  Auto_EIR); 

				waitForElement(driver, Auto_EIR_value);
				safeclick(driver, Auto_EIR_value);
			
			// select Activity type
			waitForElement(driver, kActivityType);
			safeclick(driver, kActivityType);
			
			String Activity_Type_value =  String.format(DropDown_Select,  Activity_Type); 

				waitForElement(driver, Activity_Type_value);
				safeclick(driver, Activity_Type_value);
			
			// Select stock location
			waitForElement(driver, kStockLocation);
			safeclick(driver, kStockLocation);
				
			String Stock_Location_value =  String.format(DropDown_Select,  Stock_Location); 

				waitForElement(driver, Stock_Location_value);
				safeclick(driver, Stock_Location_value);
			
			// select EIR status
			waitForElement(driver, kEirStatus);
			safeclick(driver, kEirStatus);
			
			String EIR_Status_value =  String.format(DropDown_Select,  EIR_Status); 

			waitForElement(driver, EIR_Status_value);
				safeclick(driver, EIR_Status_value);
		
			// Select From location
			waitForElement(driver, kFromLoc);
			safeclick(driver, kFromLoc);
			String From_Loc_value =  String.format(DropDown_Select,  From_Loc); 

				waitForElement(driver, From_Loc_value);
				safeclick(driver, From_Loc_value);
			
			// Select To Location
			waitForElement(driver, kToLoc);
			safeclick(driver, kToLoc);
			String To_Loc_value =  String.format(DropDown_Select,  To_Loc); 
				waitForElement(driver, To_Loc_value);
				safeclick(driver, To_Loc_value);
			
			// Non-Mandatory fields
			if (!Link_Chassis.equals("")) {
				waitForElement(driver, LinkChasis);
				safeclick(driver, LinkChasis);
				String Link_Chassis_value =  String.format(DropDown_Select,  Link_Chassis); 

				
					safeclick(driver, Link_Chassis_value);
				

			} else {

				System.out.println("Link_Chassis_Value " + "Input Not Available in : " + File_Path);
			}

			if (!BookingNoupdate.equals("")) {
				waitForElement(driver, BookingNO_Update);
				safeclick(driver, BookingNO_Update);
				String Booking_No_update_value =  String.format(DropDown_Select,  BookingNoupdate); 

				
					safeclick(driver, Booking_No_update_value);
				

			} else {

				System.out.println("Booking_No_update_Value " + "Input Not Available in : " + File_Path);
			}
			if (!Pool_Chassis_Activity.equals("")) {
				waitForElement(driver, pool_chasis_Activity);
				safeclick(driver, pool_chasis_Activity);
				
				String Pool_Chassis_Activity_value =  String.format(DropDown_Select,  Pool_Chassis_Activity); 

				
					safeclick(driver, Pool_Chassis_Activity_value);
				

			} else {

				System.out.println("Pool_Chassis_Activity_Value " + "Input Not Available in : " + File_Path);
			}
			if (!Transmit_Indicator.equals("")) {
				waitForElement(driver, TransmitIndicator);
				safeclick(driver, TransmitIndicator);
				String Transmit_Indicator_value =  String.format(DropDown_Select,  Transmit_Indicator); 

				
					safeclick(driver, Transmit_Indicator_value);
				
			} else {

				System.out.println("Transmit_Indicator_Value " + "Input Not Available in : " + File_Path);
			}
			if (!Non_Pool_Chassis_Activity.equals("")) {
				waitForElement(driver, Non_Pool_ChassisAct);
				safeclick(driver, Non_Pool_ChassisAct);
				String Non_Pool_Chassis_Activity_value =  String.format(DropDown_Select,  Non_Pool_Chassis_Activity); 
		
					safeclick(driver, Non_Pool_Chassis_Activity_value);
				

			} else {

				System.out.println("Non_Pool_Chassis_Activity_Value " + "Input Not Available in : " + File_Path);
			}

			if (!Allow_Interchange.equals("")) {
				waitForElement(driver, AllowInterchage);
				safeclick(driver, AllowInterchage);
				String Allow_Interchange_value =  String.format(DropDown_Select,  Allow_Interchange); 	
				safeclick(driver, Allow_Interchange_value);
				

			} else {

				System.out.println("Allow_Interchange_Value " + "Input Not Available in : " + File_Path);
			}
			
			if (!Master_Required.equals("")) {
				waitForElement(driver, MasterReq);
				safeclick(driver, MasterReq);
				String Master_Required_value =  String.format(DropDown_Select,  Master_Required); 
					safeclick(driver, Master_Required_value);
				

			} else {

				System.out.println("Master_Required_Value " + "Input Not Available in : " + File_Path);
			}
			// click save button
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, Popup_Message, savePopup1);
			String getpopup1 = getText(driver, Popup_Message);
			if (getpopup1.equals(savePopup1)) {

				System.out.println("Matched || Expected popup was : " + savePopup1 + " || Actual popup was : " + getpopup1);
				Extent_pass_New(driver, "Matched || Expected popup was : " + savePopup1 + " || Actual popup was : " + getpopup1,
						test, test1);
			} else {
				System.out.println(
						"NotMatched || Expected popup was : " + savePopup1 + " || Actual popup was : " + getpopup1);
				Extent_fail(driver,
						"NotMatched || Expected popup was : " + savePopup1 + " || Actual popup was : " + getpopup1, test,
						test1);
			}
			// safeclick the first grid and delete
			waitForElement(driver, ActivitySearchOpt);
			click(driver, ActivitySearchOpt);
			waitForElement(driver, Equip_Size_Filter_EA);
			click(driver, Equip_Size_Filter_EA);
			waitForElement(driver, Equip_Filter_CheckBox);
			click(driver, Equip_Filter_CheckBox);
			sendKeys(driver, Equip_Filter_Search, activeValue1);
			
			String active_Value_Select =  String.format(Active_Value_Select,  activeValue1); 
			waitForElement(driver, active_Value_Select);
	        click(driver, active_Value_Select);
			String Activity_Code =  String.format(Activity_code,  activeValue1); 

			doubleClick(driver, Activity_Code);
			Step_Start(2, "click delete icon from toolbar", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			safeclick(driver, Delete_button_toolBar);
			Step_End(2, "click delete icon from toolbar", test, test1);

			Step_Start(3, " click 'Yes' while confirming for Do you want to delete", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			safeclick(driver, popup_Message_Yes_Button);
			
			Step_End(3,  "click 'Yes' while confirming for Do you want to delete", test, test1);

			Step_Start(4, " Message will be shown as deleted", test, test1);
			waitForPopup(driver, Popup_Message, DeletePopup);
			String getpopup = getText(driver, Popup_Message);
			if (getpopup.equals(DeletePopup)) {
				System.out.println("Matched || Expected popup was : " + DeletePopup + " || Actual popup was : " + getpopup);
				Extent_pass_New(driver, "Matched || Expected popup was : " + DeletePopup + " || Actual popup was : " + getpopup,
						test, test1);
			} else {
				System.out.println(
						"NotMatched || Expected popup was : " + DeletePopup + " || Actual popup was : " + getpopup);
				Extent_fail(driver,
						"NotMatched || Expected popup was : " + DeletePopup + " || Actual popup was : " + getpopup, test,
						test1);
			}
			Step_End(4, " Message will be shown as deleted", test, test1);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			
			Step_Start(5, "Open Master Reactivation screen", test, test1);
			moduleNavigate(driver, Matser_Module);
			
			
			Step_End(5, "Open Master Reactivation screen", test, test1);
			Step_Start(6, "Click on new button & press 'Yes' option", test, test1);
			newButton(driver);

			
		
			Step_End(6, "Click on new button & press 'Yes' option", test, test1);
			
			
			Step_Start(7, "Click on module name icon", test, test1);
			waitForElement(driver, module_Nume_search_button_MR);
			click(driver, module_Nume_search_button_MR);
			Step_End(7, "Click on module name icon", test, test1);
			
			Step_Start(8, "Select Equipment Activity in module name", test, test1);
			waitForElement(driver, Module_Name_Filter_MR);
			sendKeys(driver, Module_Name_Filter_MR, Field_Names3);
			
			waitForElement(driver, select_Btn_MR);
			click(driver, select_Btn_MR);
			Step_End(8, "Select Equipment Activity in module name", test, test1);
			
			Step_Start(9, "Click show button", test, test1);
			waitForElement(driver, show_Button_MR);
			click(driver, show_Button_MR);
			Step_End(9, "Click show button", test, test1);
			
			Step_Start(10, "Select the deleted size/type", test, test1);
			waitForElement(driver, Activity_Code_TF_MR);
			sendKeys(driver, Activity_Code_TF_MR, activeValue1);
			waitForElement(driver, activity_Code_Select_MR);
			click(driver, activity_Code_Select_MR);
			Step_End(10, "Select the deleted size/type", test, test1);
			
			Step_Start(11, "Click on reactivate button", test, test1);
			waitForElement(driver, reactive_Button_MR);
			click(driver, reactive_Button_MR);
			
			Step_End(11, "Click on reactivate button", test, test1);
			
			Step_Start(12, "System will show message as  Equipment Master Reactivated successfully & then click Ok", test, test1);
		    waitForPopup(driver, popup_Message, Reactivation_Popup);
			String  reactivationpopup = getText(driver, popup_Message);
			if (Reactivation_Popup.equals(reactivationpopup)) {

				System.out.println("Matched || Expected popup was : " + Reactivation_Popup + " || Actual popup was : " + reactivationpopup);
				Extent_pass_New(driver, "Matched || Expected popup was : " + Reactivation_Popup + " || Actual popup was : " + reactivationpopup,
						test, test1);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println(
						"NotMatched || Expected popup was : " + Reactivation_Popup + " || Actual popup was : " + reactivationpopup);
				Extent_fail(driver,
						"NotMatched || Expected popup was : " + Reactivation_Popup + " || Actual popup was : " + reactivationpopup, test,
						test1);
			}
			
			Step_End(12, "System will show message as  Equipment Master Reactivated successfully & then click Ok", test, test1);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			Step_Start(13, "Open Equipment activity screen & then verify that reactivated size/type showing in screen in Activity code filter option", test, test1);
			moduleNavigate(driver, Field_Names3);
			waitForElement(driver, ActivitySearchOpt);
			click(driver, ActivitySearchOpt);
			waitForElement(driver, Equip_Size_Filter_EA);
			click(driver, Equip_Size_Filter_EA);
			waitForElement(driver, Equip_Filter_CheckBox);
			click(driver, Equip_Filter_CheckBox);
			sendKeys(driver, Equip_Filter_Search, activeValue1);
			String active_Value_Select1 =  String.format(Active_Value_Select,  activeValue1.toUpperCase()); 
	        waitForElement(driver, active_Value_Select1);
	        click(driver, active_Value_Select1);
			waitForElement(driver, Equip_Size_Filter_EA);
			click(driver, Equip_Size_Filter_EA);
			// verify the popup
			waitForElement(driver, Firstgrid);
			String activity_Code = getText(driver, Firstgrid);
			
			if (activity_Code.equals(activeValue1)) {
				System.out
				.println("Matched || Expected value was : " + activeValue1 + " || Actual value was : " + activity_Code);
				System.out.println("reactivated size/type showing in screen in Activity code filter option");
				Extent_pass_New(driver,
						"Matched || Expected value was : " + activeValue1 + " || Actual value was : " + activity_Code, test,
						test1);
			} else {
				System.out.println(
						"NotMatched || Expected value was : " + activeValue1 + " || Actual value was : " + activity_Code);
				Extent_fail(driver,
						"NotMatched || Expected value was : " + activeValue1 + " || Actual value was : " + activity_Code, test,
						test1);
			}
			
			
			Step_End(13, "Open Equipment activity screen & then verify that reactivated size/type showing in screen in Activity code filter option", test, test1);
			
			
			
			
			
			
			Extent_completed(testcase_Name, test, test1);
		click(driver, Close_Current_tab);
		}
		
		int TC3=1;

		if(TC3==1) {
			
			String testcase_Name="TC_EquipmentActivity_SC56";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset,
					File_Path);
			
			String Field_Names3 = Excel_data.get("module");
			String activity_Description = Excel_data.get("DescriptionVal");
			String Activity_Group = Excel_data.get("Activity_Group");
			String Stock_Status = Excel_data.get("Stock_Status");
			String Empty_Full = Excel_data.get("Empty_Full");
			String Soc_Activity = Excel_data.get("Soc_Activity");
			String AllowForce = Excel_data.get("AllowForce");
			String Is_special = Excel_data.get("Is_special");
			String Auto_EIR = Excel_data.get("Auto_EIR");
			String Activity_Type = Excel_data.get("Activity_Type");
			String Stock_Location = Excel_data.get("Stock_Location");
			String EIR_Status = Excel_data.get("EIR_Status");
			String From_Loc = Excel_data.get("From_Loc");
			String To_Loc = Excel_data.get("To_Loc");
			String Link_Chassis = Excel_data.get("Link_Chassis");
			String BookingNoupdate = Excel_data.get("BookingNoupdate");
			String Pool_Chassis_Activity = Excel_data.get("Pool_Chassis_Activity");
			String Transmit_Indicator = Excel_data.get("Transmit_Indicator");
			String Non_Pool_Chassis_Activity = Excel_data.get("Non_Pool_Chassis_Activity");
			String Allow_Interchange = Excel_data.get("Allow_Interchange");
			String Master_Required = Excel_data.get("Master_Required");
			String updatedPopup = Excel_data.get("updatedPopup");
			String To_Update = Excel_data.get("To_Update");

			Extent_Start(testcase_Name, test, test1);

			// login

			Extent_Start(testcase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & safeclick the module");
			
			
			
			moduleNavigate(driver, Field_Names3);

			// select first grid and click edit button
			Step_Start(1, "Double click the data grid", test, test1);
			waitForElement(driver, ToolPanel1);
			safeclick(driver, ToolPanel1);
			waitForElement(driver, Confitionfilter1);
			safeclick(driver, Confitionfilter1);
			waitForElement(driver, Activity_Code_TF_EA);
			sendKeys(driver, Activity_Code_TF_EA, To_Update);
			String Activity_Code =  String.format(Activity_code,  To_Update); 
			doubleClick(driver, Activity_Code);
			
			Step_End(1, "Double click the data grid", test, test1);
			Step_Start(2, "click Edit button & Change stock status from dropmenu", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);

			// Non- mandatory fields
			if (!activity_Description.equals("")) {
				waitForElement(driver, kActivityDescriptionVal);
				sendKeys(driver, kActivityDescriptionVal, activity_Description);
				enter(driver);
			} else {

				System.out.println("activity_Description " + "Input Not Available in : " + File_Path);
			}

			if (!Activity_Group.equals("")) {
				waitForElement(driver, kActivityGroup);
				safeclick(driver, kActivityGroup);
				String Activity_Group_value =  String.format(DropDown_Select,  Activity_Group); 

				safeclick(driver, Activity_Group_value);

			} else {

				System.out.println("Activity_Group " + "Input Not Available in : " + File_Path);
			}
			if (!Empty_Full.equals("")) {
				waitForElement(driver, kEmptyFullOpt);
				safeclick(driver, kEmptyFullOpt);
				String Empty_Full_value =  String.format(DropDown_Select,  Empty_Full); 
				safeclick(driver, Empty_Full_value);

			} else {

				System.out.println("Empty_Full " + "Input Not Available in : " + File_Path);
			}

			if (!Soc_Activity.equals("")) {
				waitForElement(driver, kAllowSocActivity);
				safeclick(driver, kAllowSocActivity);
				String Soc_activity1 =  String.format(DropDown_Select,  Soc_Activity); 

				
				safeclick(driver, Soc_activity1);

			} else {

				System.out.println("Soc_Activity " + "Input Not Available in : " + File_Path);
			}
			if (!AllowForce.equals("")) {
				waitForElement(driver, kAllowForce);
				safeclick(driver, kAllowForce);
				String AllowForce_value =  String.format(DropDown_Select,  AllowForce); 

				safeclick(driver, AllowForce_value);

			} else {

				System.out.println("AllowForce " + "Input Not Available in : " + File_Path);
			}
			if (!Is_special.equals("")) {
				waitForElement(driver, kIsSpecial);
				safeclick(driver, kIsSpecial);
				String Is_special_value =  String.format(DropDown_Select,  Is_special); 

				
				safeclick(driver, Is_special_value);

			} else {

				System.out.println("Is_special " + "Input Not Available in : " + File_Path);
			}
			if (!Auto_EIR.equals("")) {

				waitForElement(driver, kAutoEir);
				safeclick(driver, kAutoEir);
				String Auto_EIR_value =  String.format(DropDown_Select,  Auto_EIR); 

				safeclick(driver, Auto_EIR_value);

			} else {

				System.out.println("Auto_EIR " + "Input Not Available in : " + File_Path);
			}
			if (!Activity_Type.equals("")) {

				waitForElement(driver, kActivityType);
				safeclick(driver, kActivityType);
				
				String Activity_Type_value =  String.format(DropDown_Select,  Activity_Type); 

			waitForElement(driver, Activity_Type_value);
				safeclick(driver, Activity_Type_value);

			} else {

				System.out.println("Activity_Type " + "Input Not Available in : " + File_Path);
			}
			if (!Stock_Location.equals("")) {
				waitForElement(driver, kStockLocation);
				safeclick(driver, kStockLocation);
			
				String Stock_Location_value =  String.format(DropDown_Select,  Stock_Location); 

				waitForElement(driver, Stock_Location_value);
				safeclick(driver, Stock_Location_value);

			} else {

				System.out.println("Stock_Location " + "Input Not Available in : " + File_Path);
			}
			if (!EIR_Status.equals("")) {
				waitForElement(driver, kEirStatus);
				safeclick(driver, kEirStatus);
				
				String EIR_Status_value =  String.format(DropDown_Select,  EIR_Status); 

				waitForElement(driver, EIR_Status_value);
				safeclick(driver, EIR_Status_value);

			} else {

				System.out.println("EIR_Status " + "Input Not Available in : " + File_Path);
			}
			if (!From_Loc.equals("")) {
				waitForElement(driver, kFromLoc);
				safeclick(driver, kFromLoc);

				String From_Loc_value =  String.format(DropDown_Select,  From_Loc); 

				waitForElement(driver, From_Loc_value);
				safeclick(driver, From_Loc_value);

			} else {

				System.out.println("From_Loc " + "Input Not Available in : " + File_Path);
			}
			if (!To_Loc.equals("")) {
				waitForElement(driver, kToLoc);
				safeclick(driver, kToLoc);
				
				String To_Loc_value =  String.format(DropDown_Select,  To_Loc); 

				waitForElement(driver, To_Loc_value);
				safeclick(driver, To_Loc_value);

			} else {

				System.out.println("To_Loc " + "Input Not Available in : " + File_Path);
			}
			if (!Link_Chassis.equals("")) {
				waitForElement(driver, LinkChasis);
				safeclick(driver, LinkChasis);
			
				String Link_Chassis_value =  String.format(DropDown_Select,  Link_Chassis); 

			   waitForElement(driver, Link_Chassis_value);
				safeclick(driver, Link_Chassis_value);


			} else {

				System.out.println("Link_Chassis_Value " + "Input Not Available in : " + File_Path);
			}
			if (!BookingNoupdate.equals("")) {
				waitForElement(driver, BookingNO_Update);
				safeclick(driver, BookingNO_Update);
				
				String Booking_No_update_value =  String.format(DropDown_Select,  BookingNoupdate); 

				waitForElement(driver, Booking_No_update_value);
				safeclick(driver, Booking_No_update_value);


			} else {

				System.out.println("Booking_No_update_Value " + "Input Not Available in : " + File_Path);
			}
			if (!Pool_Chassis_Activity.equals("")) {
				waitForElement(driver, pool_chasis_Activity);
				safeclick(driver, pool_chasis_Activity);
				
				String Pool_Chassis_Activity_value =  String.format(DropDown_Select,  Pool_Chassis_Activity); 

				waitForElement(driver, Pool_Chassis_Activity_value);
				safeclick(driver, Pool_Chassis_Activity_value);


			} else {

				System.out.println("Pool_Chassis_Activity_Value " + "Input Not Available in : " + File_Path);
			}
			if (!Transmit_Indicator.equals("")) {
				waitForElement(driver, TransmitIndicator);
				safeclick(driver, TransmitIndicator);
				String Transmit_Indicator_value =  String.format(DropDown_Select,  Transmit_Indicator); 

				waitForElement(driver, Transmit_Indicator_value);
				safeclick(driver, Transmit_Indicator_value);


			} else {

				System.out.println("Transmit_Indicator_Value " + "Input Not Available in : " + File_Path);
			}
			if (!Non_Pool_Chassis_Activity.equals("")) {
				waitForElement(driver, Non_Pool_ChassisAct);
				safeclick(driver, Non_Pool_ChassisAct);
				
				String Non_Pool_Chassis_Activity_value =  String.format(DropDown_Select,  Non_Pool_Chassis_Activity); 

				waitForElement(driver, Non_Pool_Chassis_Activity_value);
				safeclick(driver, Non_Pool_Chassis_Activity_value);


			} else {

				System.out.println("Non_Pool_Chassis_Activity_Value " + "Input Not Available in : " + File_Path);
			}

			if (!Allow_Interchange.equals("")) {
				waitForElement(driver, AllowInterchage);
				safeclick(driver, AllowInterchage);
				String Allow_Interchange_value =  String.format(DropDown_Select,  Allow_Interchange); 	

				waitForElement(driver, Allow_Interchange_value);
				safeclick(driver, Allow_Interchange_value);


			} else {

				System.out.println("Allow_Interchange_Value " + "Input Not Available in : " + File_Path);
			}
			if (!Master_Required.equals("")) {
				waitForElement(driver, MasterReq);
				safeclick(driver, MasterReq);
				
				String Master_Required_value =  String.format(DropDown_Select,  Master_Required); 

				
			waitForElement(driver, Master_Required_value);
				safeclick(driver, Master_Required_value);


			} else {

				System.out.println("Master_Required_Value " + "Input Not Available in : " + File_Path);
			}

			waitForElement(driver, kStockStatusVal);
			safeclick(driver, kStockStatusVal);
			
			String Stock_Status_value =  String.format(DropDown_Select,  Stock_Status); 

			waitForElement(driver, Stock_Status_value);
			safeclick(driver, Stock_Status_value);
			Step_End(2, "click Edit button & Change stock status from dropmenu", test, test1);
			// verify the updated popup
			Step_Start(3, "click Save button", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
		
			waitForPopup(driver, Popup_Message, updatedPopup);
			String getpopup = getText(driver, Popup_Message);
			if (getpopup.equals(updatedPopup)) {
				System.out
				.println("Matched || Expected popup was : " + updatedPopup + " || Actual popup was : " + getpopup);
				Extent_pass_New(driver,
						"Matched || Expected popup was : " + updatedPopup + " || Actual popup was : " + getpopup, test,
						test1);
			} else {
				System.out.println(
						"NotMatched || Expected popup was : " + updatedPopup + " || Actual popup was : " + getpopup);
				Extent_fail(driver,
						"NotMatched || Expected popup was : " + updatedPopup + " || Actual popup was : " + getpopup, test,
						test1);
			}
			Step_End(3, "click Save button", test, test1);
			Extent_completed(testcase_Name, test, test1);

		}
	}
}
