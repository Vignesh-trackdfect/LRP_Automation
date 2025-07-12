package LRP_Operations_TDN_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Transportation_Dispatch_Notice_SC_TDN_08 extends Keywords {
 
	public void Transportation_Dispatch_Notice_SC_TDN_08(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
//		Get data from test data
		
		String testCaseName="TC_Transportation_Dispatch_Notice_SC_TDN_08";

		
		

		
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String moduleTDN=Excel_data.get("ModuleTDN");
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String pluginStatusFalse = Excel_data.get("PluginStatusFalse");
		String pluginStatusTrue = Excel_data.get("PluginStatusTrue");		
		String agencyUser = Excel_data.get("AgencyUser");
		String Booking_Number =Excel_data.get("Booking_Number");
		String Draft_perform =Excel_data.get("Draft_perform");
		String Provisional_perform =Excel_data.get("Provisional_perform");
		String Confirmed_perform =Excel_data.get("Confirmed_perform");
		String Cancelled_perform =Excel_data.get("Cancelled_perform");
		String Shipment_Type =Excel_data.get("Shipment_Type");
		String field_select =Excel_data.get("field_select");
		String Ware_House_number =Excel_data.get("Ware_House_number");
		String Trans_select =Excel_data.get("Trans_select");
		String App_Date =Excel_data.get("App_Date");
		String date_Picker =Excel_data.get("date_Picker");
		String Modeof_Transport =Excel_data.get("Modeof_Transport");
		String Modeof_Transport_Type =Excel_data.get("Modeof_Transport_Type");
		String Vender_Code =Excel_data.get("Vender_Code");
		String savedPopup =Excel_data.get("TDN_SavedPopup");
		String Return_Date =Excel_data.get("Return_Date");
		String ware_House_Type_Select =Excel_data.get("Ware_House_Type_Select");
		String global_search_Vendor_Code_Option1 =Excel_data.get("Global_search_Vendor_Code_Option1");
		String dropdown_Condition =Excel_data.get("Dropdown_Condition");
		String merchantPopup =Excel_data.get("MerchantPopup");
		String pickup_loc_dd_data=Excel_data.get("pickup_loc_dd_data");
		String pickup_loc_search_data=Excel_data.get("pickup_loc_search_data");
		String condition=Excel_data.get("condition");
		String cust_depot_term_data=Excel_data.get("cust_depot_term_data");
		String cust_dep_search_data=Excel_data.get("cust_dep_search_data");
		String return_loc_dd_data=Excel_data.get("return_loc_dd_data");
		String return_loc_search_data=Excel_data.get("return_loc_search_data");
		String leg_date_Picker=Excel_data.get("leg_date_Picker");
		String leg_pickupdate=Excel_data.get("leg_pickupdate");
		String chasis_pickup_dd_data=Excel_data.get("chasis_pickup_dd_data");
		String chasis_drop_dd_data=Excel_data.get("chasis_drop_dd_data");
		String with_chasis_flag=Excel_data.get("with_chasis_flag");
		String Chassis_Mode=Excel_data.get("pickup_loc_dd_data");
		String chasis_pickup_Search_data=Excel_data.get("chasis_pickup_Search_data");
		String chasis_drop_Search_data=Excel_data.get("chasis_drop_Search_data");
		String loadStatus=Excel_data.get("LoadStatus");
		String PLD_Input =Excel_data.get("PLD_Input");
		String PLD_Search =Excel_data.get("PLD_Search");
		String PLA_Input =Excel_data.get("PLA_Input");
		String PLA_Search =Excel_data.get("PLA_Search");
		String Address1_Search =Excel_data.get("Address1_Search");
		String Address1_Input =Excel_data.get("Address1_Input");
		String Address2_Search =Excel_data.get("Address2_Search");
		String Address2_Input =Excel_data.get("Address2_Input");
		String Vendor_Input =Excel_data.get("Vendor_Input");
		String Vendor_Name_Search =Excel_data.get("Vendor_Name_Search");
		String Address_Input =Excel_data.get("Address_Input");
		String Address_Search =Excel_data.get("Address_Search");
		String pickup_location_header =Excel_data.get("pickup_location_header");
		String return_location_header =Excel_data.get("return_location_header");
		String chasis_pickup_header =Excel_data.get("chasis_pickup_header");
		String chasis_drop_header =Excel_data.get("chasis_drop_header");
		String cust_depot_term_header =Excel_data.get("cust_depot_term_header");
		String MerchantPopup_Perform = Excel_data.get("MerchantPopup_Perform");
		String PluginConfiguration =Excel_data.get("PluginConfiguration");
	navigateUrl(driver,url);
	
	Extent_Start(testCaseName, test, test1);
//	Login
		
	LRP_Login(driver, username, password);

	
	Extent_call(test, test1,"**Switch the Profile Start**");

	SwitchProfile(driver, agencyUser);
	
	
	Step_Start(1, "Enable plugin \"TCV\" as TRUE.", test, test1);
	

//	Plugin Configuration
		Extent_cal(test, test1, pluginConfigurationModule);
		if(PluginConfiguration.equalsIgnoreCase("YES")) {
		moduleNavigate(driver, pluginConfigurationModule);
		
		waitForElement(driver, pluginConfiguration_Tab);
		
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		sendKeys(driver, TmoduleIdFilter_Searchbox, moduleID);
		
		waitForElement(driver, Tretrieved_PluginID);
		String actualPluginID=getText(driver, Tretrieved_PluginID);
		if(actualPluginID.equals(pluginID)) {
			Extent_pass_New(driver, pluginID+" plugin ID is available", test,test1);
			System.out.println(pluginID+" plugin ID is available");
			
			doubleClick(driver, Tretrieved_PluginID);
			
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
			waitForElement(driver, Condition_Dropdown);
			click(driver, Condition_Dropdown);
			
			String select_Condition=String.format(TpluginStatus_Select, pluginStatusTrue);
			click(driver, select_Condition);
			click(driver, SaveButton_ToolBar);
			
		}else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}
		
		waitForDisplay(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		}
			Step_End(1, "Enable plugin \"TCV\" as TRUE.", test, test1);
			
			Extent_cal(test, test1, moduleTDN);	
			
			moduleNavigate(driver, moduleTDN);

			
				waitForElement(driver, Tshipment_Dropdown);
				click(driver, Tshipment_Dropdown);
				String select_Shipment=String.format(Tshipmenttype_select, Shipment_Type);
				safeclick(driver, select_Shipment);
				
			
			Step_Start(2, "Ensure draft checkbox is selected", test, test1);

			
			waitForElement(driver, TProvisional_check_box);
			checkBox(driver, TProvisional_check_box, Provisional_perform);
			waitForElement(driver, TDraft_check_box);
			checkBox(driver, TDraft_check_box, Draft_perform);
			waitForElement(driver, TDraft_check_box);
			checkBox(driver, TConfirmed_check_box, Confirmed_perform);
			checkBox(driver, TCancelled_check_box, Cancelled_perform);
			
			Step_End(2, "Ensure draft checkbox is selected", test, test1);

				List<String> datas = splitAndExpand(Booking_Number);
				for (String data1 : datas) {
					
					Step_Start(3, "Click add(+) button in BookNo field.", test, test1);

					waitForElement(driver, BL_Add);
					safeclick(driver, BL_Add);
					
					Step_End(3, "Click add(+) button in BookNo field.", test, test1);

				
					
					Step_Start(4, "Paste book number and click search button.", test, test1);
					Step_Start(5, "Select the book number", test, test1);


					globalValueSearchWindow(driver, dropdown_Condition, field_select, data1, PLA_Search, PLA_Input, PLD_Search, PLD_Input);

					Step_End(4, "Paste book number and click search button.", test, test1);


					Step_End(5, "Select the book number", test, test1);

				}
			
			Step_Start(6, "system will display 'Selected Booking is a Merchant. Do you want to proceed?', click yes.", test, test1);

			if(MerchantPopup_Perform.equalsIgnoreCase("YES")) {
				waitForDisplay(driver, popup_Message);   
				if (isdisplayed(driver, popup_Message)) {
					String actualPopup=getText(driver, popup_Message);
					if(actualPopup.equals(merchantPopup)) {
						System.out.println("Matched || Expected popup : "+merchantPopup+" || Actual popup : "+actualPopup);
						Extent_pass_New(driver, "Matched || Expected popup : "+merchantPopup+" || Actual popup : "+actualPopup, test, test1);
						click(driver,popup_Message_Yes_Button);
					}
				}
				}
			Step_End(6, "system will display 'Selected Booking is a Merchant. Do you want to proceed?', click yes.", test, test1);
			
			Step_Start(7, "click customer tab.", test, test1);

			waitForDisplay(driver, master_Tab_Table_Row_TDN);
			if(isdisplayed(driver, master_Tab_Table_Row_TDN)) {
				waitForElement(driver, TDN_Customer_Tab);
				click(driver, TDN_Customer_Tab);
			}else{
				waitForElement(driver, remove_Button_TDN);
				click(driver, remove_Button_TDN);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				waitForElement(driver, TDN_Customer_Tab);
				click(driver, TDN_Customer_Tab);
			}
			
			Step_End(7, "click customer tab.", test, test1);

			Step_Start(8, "select book number from dropdown.", test, test1);

			waitForElement(driver, TSelect_Booking_DD);
			click(driver, TSelect_Booking_DD);
			
			String contract_click1=String.format(bookingNumber_Select, Booking_Number);
			waitForElement(driver, contract_click1);
			click(driver, contract_click1);
			
			Step_End(8, "select book number from dropdown.", test, test1);
			
			Step_Start(9, "click all in the box.", test, test1);

			waitForElement(driver, TSelect_Booking_all);
			click(driver, TSelect_Booking_all);
			
			Step_End(9, "click all in the box.", test, test1);

			Step_Start(10, "click search icon in the warehouse field.", test, test1);

			waitForElement(driver, TAdd_ware_house);
			click(driver, TAdd_ware_house);
			
			
			
			Step_End(10, "click search icon in the warehouse field.", test, test1);

			Step_Start(11, "enter % in warehouse name.", test, test1);

			globalValueSearchWindow(driver, dropdown_Condition, ware_House_Type_Select, Ware_House_number, Address1_Search, Address1_Input, Address2_Search, Address2_Input);
			
			Step_End(11, "enter % in warehouse name.", test, test1);

			Step_Start(12, "click on the warehouse and click select button.", test, test1);

			
			Step_End(12, "click on the warehouse and click select button.", test, test1);

			Step_Start(13, "click in app date field and select the current date.", test, test1);

			
			if (date_Picker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Date_click);
				selectDatePickerWithTime1(driver, Date_click, App_Date);
				click(driver, State_Label);

				
			} else {
				waitForElement(driver, Date_click);
				clearAndType(driver, Date_click, App_Date);
			}
			
			Step_End(13, "click in app date field and select the current date.", test, test1);

			Step_Start(14, "select mode of transport as truck in dropdown.", test, test1);

			waitForElement(driver, mode_of_Trans);
			click(driver, mode_of_Trans);
			String trans_select=String.format(transport_Select, Trans_select);
			waitForElement(driver, trans_select);
			click(driver, trans_select);

			Step_End(14, "select mode of transport as truck in dropdown.", test, test1);

			Step_Start(15, "click add button.", test, test1);

			click(driver, Customer_Add_Button);

			Step_End(15, "click add button.", test, test1);
			Step_Start(16, "Click master Tab.", test, test1);

			waitForElement(driver, TDN_Master_Tab);
			click(driver,TDN_Master_Tab);
			
			Step_End(16, "Click master Tab.", test, test1);
			Step_Start(17, "select the container.", test, test1);

			waitForElement(driver, addleg_select);
			click(driver, addleg_select);
			
			Step_End(17, "select the container.", test, test1);
			Step_Start(18, "click add leg button.", test, test1);

			waitForElement(driver, addleg);
			click(driver, addleg);
			
			Step_End(18, "click add leg button.", test, test1);
			Step_Start(19, "select mode of transport as truck in drop down.", test, test1);

			waitForElement(driver, modeof_transport);
			click(driver, modeof_transport);
			String Select_ModeOfTransport=String.format(mode_Of_Transport, Modeof_Transport);
			safeclick(driver, Select_ModeOfTransport);
			
			Step_End(19, "select mode of transport as truck in drop down.", test, test1);
			Step_Start(20, " click search icon in vendor details, enter % in vendor code and select the vendor.", test, test1);

		    waitForElement(driver, vendor_searchicon);
		    click(driver, vendor_searchicon);
	     		
			globalValueSearchWindow(driver, dropdown_Condition, global_search_Vendor_Code_Option1, Vender_Code, Address_Search, Address_Input, Vendor_Name_Search, Vendor_Input);

			Step_End(20, " click search icon in vendor details, enter % in vendor code and select the vendor.", test, test1);
			Step_Start(21, "select Trans. Type Mode as pickup only in drop down.", test, test1);

			 waitForElement(driver, modeof_transport_type);
				click(driver,modeof_transport_type);
				String Select_ModeOfTransport_type=String.format(DropDown_Select, Modeof_Transport_Type);
				waitForDisplay(driver, Select_ModeOfTransport_type);
				safeclick(driver, Select_ModeOfTransport_type);
				
			
			Step_End(21, "select Trans. Type Mode as pickup only in drop down.", test, test1);
			
			
				waitForElement(driver, pickup_loc_label);
				if(isElementAccessible(driver, pickup_loc_search_icon)) {
				if(!pickup_loc_dd_data.equals("")) {
					waitForElement(driver,pickup_loc_label);
					click(driver, pickup_loc_label);
					String pickup_dd = String.format(DropDown_Select, pickup_loc_dd_data);
					waitForElement(driver, pickup_dd);
					click(driver, pickup_dd);


				}
				if(!pickup_loc_search_data.equalsIgnoreCase("")) {

					waitForElement(driver, pickup_loc_search_icon);
					click(driver, pickup_loc_search_icon);
					twoColumnSearchWindow(driver, pickup_location_header, condition, pickup_loc_search_data);
				}
				}
				//2
				
				waitForElement(driver, cust_Depot_Term_Label);
				if(isElementAccessible(driver, cust_depo_term_search_icon)) {

				if(!cust_depot_term_data.equals("")) {

					waitForElement(driver,cust_Depot_Term_Label);
					click(driver, cust_Depot_Term_Label);

					String cust_depo_dd = String.format(DropDown_Select, cust_depot_term_data);
					waitForElement(driver, cust_depo_dd);
					click(driver, cust_depo_dd);


				}
				if(!cust_dep_search_data.equalsIgnoreCase("")) {

					waitForElement(driver, cust_depo_term_search_icon);
					click(driver, cust_depo_term_search_icon);
					twoColumnSearchWindow(driver, cust_depot_term_header, condition, cust_dep_search_data);
				}
				}
				//3

				waitForElement(driver, return_location_label);
				if(isElementAccessible(driver, return_location_searchicon)) {

					waitForElement(driver,return_location_label);
					click(driver, return_location_label);

					String return_loc_dd = String.format(DropDown_Select, return_loc_dd_data);
					waitForElement(driver, return_loc_dd);
					click(driver, return_loc_dd);

				

				if(!return_loc_search_data.equalsIgnoreCase("")) {

					waitForElement(driver, return_location_searchicon);
					click(driver, return_location_searchicon);
					twoColumnSearchWindow(driver, return_location_header, condition, return_loc_search_data);
				}
				}
			
				waitForElement(driver, with_Chassis_Check_Box);
				checkBox(driver, with_Chassis_Check_Box, with_chasis_flag);

				if(with_chasis_flag.equalsIgnoreCase("yes")) {
					if(!Chassis_Mode.equals("")) {
					String mode_Select = String.format(With_Chassis_Mode, Chassis_Mode);
					waitForElement(driver, mode_Select);
					click(driver, mode_Select);
					}
					if(!chasis_pickup_dd_data.equals("")) {
						waitForElement(driver, Chassis_Pickup_Loc_Label);
					click(driver, Chassis_Pickup_Loc_Label);
					String chasis_pickup_dd = String.format(DropDown_Select, chasis_pickup_dd_data);
					waitForElement(driver, chasis_pickup_dd);
					click(driver, chasis_pickup_dd);
					}
					if(!chasis_pickup_Search_data.equals("")) {
						waitForElement(driver, Chassis_Pickup_Loc_Search);
						click(driver, Chassis_Pickup_Loc_Search);
						twoColumnSearchWindow(driver, chasis_pickup_header, condition, chasis_pickup_Search_data);
					}
					//drop
					if(!chasis_drop_dd_data.equals("")) {
					waitForElement(driver, Chassis_Drop_Loc_Label);
					click(driver, Chassis_Drop_Loc_Label);
					String chasis_drop_dd = String.format(DropDown_Select, chasis_drop_dd_data);
					waitForElement(driver, chasis_drop_dd);
					click(driver, chasis_drop_dd);
					}
					if(chasis_drop_Search_data.equals("")) {
						waitForElement(driver, Chassis_Drop_Loc_Search);
						click(driver, Chassis_Drop_Loc_Search);
						twoColumnSearchWindow(driver, chasis_drop_header, condition, chasis_drop_Search_data);
					}
				}

				//4
				if(!leg_pickupdate.equals("")) {
					waitForElement(driver, pickupdate_leg);
					if (leg_date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePickerWithTime1(driver, pickupdate_leg, leg_pickupdate);
					}else {
						waitForElement(driver, pickupdate_leg);
						clearAndType(driver, pickupdate_leg, leg_pickupdate);
					}
				}
				waitForElement(driver, return_Date_Field);
				if (date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePickerWithTime1(driver, return_Date_Field, Return_Date);
				} else {
					waitForElement(driver, return_Date_Field);
					clearAndType(driver, return_Date_Field, Return_Date);
				}
			
				if(!loadStatus.equals("")) {
					  waitForElement(driver, loadStatus_TDN);
					    click(driver, loadStatus_TDN);
					    
					String cust_depo_dd = String.format(DropDown_Select, loadStatus);
					waitForElement(driver, cust_depo_dd);
					click(driver, cust_depo_dd);
					}
					
			Step_Start(22, "click add button and close the pop window.", test, test1);

		    waitForElement(driver, vendor_Code_addbtn);
		    click(driver, vendor_Code_addbtn);
		    
		    waitForDisplay(driver, popup_Message_Ok_Button);
		    if (isdisplayed(driver, popup_Message_Ok_Button)) {
				click(driver,popup_Message_Ok_Button);
				
			}
		    waitForDisplay(driver, vendor_Code_closebtn);
		    if (isdisplayed(driver, vendor_Code_closebtn)) {
				click(driver,vendor_Code_closebtn);
				
			}
		    
			Step_End(22, "click add button and close the pop window.", test, test1);
				Step_Start(23, " click on the added leg", test, test1);

				waitForElement(driver, legTable_Container_Gridcell);
				click(driver, legTable_Container_Gridcell);
				
				Step_End(23, " click on the added leg", test, test1);

				scrollTop(driver);
				
				Step_Start(24, "click charges tab.", test, test1);
				
				
				waitForElement(driver, Charges);
				click(driver, Charges);
				
				Step_End(24, "click charges tab.", test, test1);
				Step_Start(25, "click auto rate.", test, test1);
				
				waitForElement(driver, Auto_Rate);
				click(driver, Auto_Rate);
				
				Step_End(25, "click auto rate.", test, test1);
				Step_Start(26, "system will fetch the charges from contract.", test, test1);
				
				 waitForElement(driver, popup_Message_Ok_Button);
				   click(driver, popup_Message_Ok_Button);

					Step_End(26, "system will fetch the charges from contract.", test, test1);
					Step_Start(27, "click save icon in tool bar.", test, test1);
				
					scrollTop(driver);
					  waitForElement(driver, SaveButton_ToolBar);
						safeclick(driver, SaveButton_ToolBar);
						
						Step_End(27, "click save icon in tool bar.", test, test1);
					Step_Start(28, "system will display \"\"Transportation Dispatch Notice saved\"\", click ok.\"", test, test1);
	
					waitForPopup(driver, popup_Message, savedPopup);   
					String actual_TDN_SavedPopup1=getText(driver, popup_Message);
					if(actual_TDN_SavedPopup1.equals(savedPopup)) {
						Extent_pass_New(driver, "Matched || Expected Pop up : "+savedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup1, test, test1);
						System.out.println("Matched || Expected Pop up : "+savedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup1);
						click(driver, popup_Message_Ok_Button);
					}else {
						System.out.println("Not Matched || Expected Pop up : "+savedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup1);
						Extent_fail(driver, "Not Matched || Expected Pop up : "+savedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup1, test, test1);
					}
					Step_End(28, "system will display \"\"Transportation Dispatch Notice saved\"\", click ok.", test, test1);
					

//					Plugin Configuration TCV set as False

					 Extent_cal(test, test1, pluginConfigurationModule);
					 if(PluginConfiguration.equalsIgnoreCase("YES")) {
					 moduleNavigate(driver, pluginConfigurationModule);
						
						waitForElement(driver, pluginConfiguration_Tab);
						
						sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
						sendKeys(driver, TmoduleIdFilter_Searchbox, moduleID);
						
						waitForElement(driver, Tretrieved_PluginID);
						String actualPluginID1=getText(driver, Tretrieved_PluginID);
						if(actualPluginID1.equals(pluginID)) {
							Extent_pass_New(driver, pluginID+" plugin ID is available", test,test1);
							System.out.println(pluginID+" plugin ID is available");
							
							waitForElement(driver, Tretrieved_PluginID);
							doubleClick(driver, Tretrieved_PluginID);
							
							waitForElement(driver, Edit_Button_toolBar);
							click(driver, Edit_Button_toolBar);
							
							waitForElement(driver, Condition_Dropdown);
							click(driver, Condition_Dropdown);
							
							String select_Condition=String.format(TpluginStatus_Select, pluginStatusFalse);
							click(driver, select_Condition);
							click(driver, SaveButton_ToolBar);
							
						}else {
							System.out.println(pluginID+" plugin ID is unavailable");
							Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
						}}
					
					Extent_completed(testCaseName, test, test1);	
					
			}	   
			   
			   
}
			   
