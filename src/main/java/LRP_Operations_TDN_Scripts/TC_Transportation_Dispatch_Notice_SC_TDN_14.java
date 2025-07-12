
package LRP_Operations_TDN_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Tdn_Locators;

public class TC_Transportation_Dispatch_Notice_SC_TDN_14 extends Keywords{

	public void Transportation_Dispatch_Notice_SC_TDN_14(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		String tc_Name="TC_Transportation_Dispatch_Notice_SC_TDN_14";
		
		
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String moduleTDN=Excel_data.get("ModuleTDN");
		String agencyUser = Excel_data.get("AgencyUser");
		String Booking_Number =Excel_data.get("Booking_Number");
		String Shipment_Type =Excel_data.get("Shipment_Type");
		String Booking_Number_perform =Excel_data.get("Booking_Number_perform");
		String Modeof_Transport =Excel_data.get("Modeof_Transport");
		String Vender_Code =Excel_data.get("Vender_Code");
		String Load_Status =Excel_data.get("Load_Status");
		String Transportation_saved =Excel_data.get("Transportation_saved");
		String Dropdown_Condition =Excel_data.get("Dropdown_Condition");
		String Global_search_Wo_No =Excel_data.get("Global_search_Wo_No");
		String Global_search_Vendor_Code_Option1 =Excel_data.get("Global_search_Vendor_Code_Option1");
		String pickup_loc_dd_data =Excel_data.get("pickup_loc_dd_data");
		String pickup_loc_search_data =Excel_data.get("pickup_loc_search_data");
		String condition =Excel_data.get("condition");
		String cust_depot_term_data =Excel_data.get("cust_depot_term_data");
		String cust_dep_search_data =Excel_data.get("cust_dep_search_data");
		String return_loc_dd_data =Excel_data.get("return_loc_dd_data");
		String return_loc_search_data =Excel_data.get("return_loc_search_data");
		String leg_pickupdate =Excel_data.get("leg_pickupdate");
		String leg_return_date =Excel_data.get("leg_return_date");
		String with_chasis_flag =Excel_data.get("with_chasis_flag");
		String chasis_pickup_dd_data =Excel_data.get("chasis_pickup_dd_data");
		String chasis_drop_dd_data =Excel_data.get("chasis_drop_dd_data");
		String cust_depot_term_header =Excel_data.get("cust_depot_term_header");
		String return_location_header =Excel_data.get("return_location_header");
		String pickup_location_header =Excel_data.get("pickup_location_header");
		String chasis_pickup_header =Excel_data.get("chasis_pickup_header");
		String chasis_drop_header =Excel_data.get("chasis_drop_header");
		String chasis_pickup_Search_data =Excel_data.get("chasis_pickup_Search_data");
		String chasis_drop_Search_data =Excel_data.get("chasis_drop_Search_data");
		String Chassis_Mode =Excel_data.get("Chassis_Mode");
		String Search_Type2 =Excel_data.get("Search_Type2");
		String Search_Input2 =Excel_data.get("Search_Input2");
		String Search_Type3 =Excel_data.get("Search_Type3");
		String Search_Input3 =Excel_data.get("Search_Input3");
		String MerchantPopup_Perform = Excel_data.get("MerchantPopup_Perform");
		String Load_status_value=String.format(Tdn_Locators.Load_status_value, Load_Status);
		String shipmenttype_select=String.format(Tdn_Locators.Tshipmenttype_select, Shipment_Type);
		String Auto_rate_Perform = Excel_data.get("Auto_rate_Perform");	
	navigateUrl(driver,url);
	
	Extent_Start(tc_Name, test, test1);
//	Login
		
	LRP_Login(driver, username, password);
	
	Extent_call(test, test1,"**Switch the Profile Start**");


//	Switch the Profile
	
	SwitchProfile(driver, agencyUser);
	
	Extent_cal(test, test1, "Transportaion Dispatch Notice");	
	
	moduleNavigate(driver, moduleTDN);
		
newButton(driver);
		Step_Start(1, "select the Empty repo in shipment drop down.", test, test1);

		waitForElement(driver, Tshipment_Dropdown);
		click(driver, Tshipment_Dropdown);
		safeclick(driver, shipmenttype_select);
		Step_End(1, "select the Empty repo in shipment drop down.", test, test1);

		if (Booking_Number_perform.equalsIgnoreCase("YES")) {

			List<String> datas = splitAndExpand(Booking_Number);
			for (String data1 : datas) {
				Step_Start(2, "Click the plus icon ", test, test1);

				waitForElement(driver, BL_Add);
				safeclick(driver, BL_Add);
				Step_End(2, "Click the plus icon ", test, test1);

				Step_Start(3, "Enter the Work order number and click the search icon.", test, test1);

				globalValueSearchWindow(driver, Dropdown_Condition, Global_search_Wo_No, data1, Search_Type2, Search_Input2, Search_Type3, Search_Input3);
				Step_End(3, "Enter the Work order number and click the search icon.", test, test1);

			}
		} else {
			System.out.println("Booking number was not added");
		}
		if(MerchantPopup_Perform.equalsIgnoreCase("YES")) {
			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver,popup_Message_Yes_Button);
				
			}}
		Step_Start(4, "Select the Container.", test, test1);

		waitForElement(driver, addleg_select);
		click(driver, addleg_select);
		
		Step_End(4, "Select the Container.", test, test1);

		Step_Start(5, "Click the Add Leg button.", test, test1);
		
		waitForElement(driver, add_legbtn);
		click(driver, add_legbtn);
		
		Step_End(5, "Click the Add Leg button.", test, test1);

		Step_Start(6, "Select the Rail in Mode of Transport Dropdown.", test, test1);

		waitForElement(driver, modeof_transport);
		click(driver, modeof_transport);
		
		String Select_ModeOfTransport=String.format(Tdn_Locators.Select_ModeOfTransport, Modeof_Transport);
		waitForElement(driver, Select_ModeOfTransport);
		safeclick(driver, Select_ModeOfTransport);
		
		Step_End(6, "Select the Rail in Mode of Transport Dropdown.", test, test1);

		Step_Start(7, " Select the Vendor code and click the Search icon.", test, test1);

		 waitForElement(driver, vendor_searchicon);
		    click(driver, vendor_searchicon);
	     		
		    globalValueSearchWindow(driver, Dropdown_Condition, Global_search_Vendor_Code_Option1, Vender_Code, Search_Type2, Search_Input2, Search_Type3, Search_Input3);

		    
			//pickuplocation
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
		    
			Step_End(7, " Select the Vendor code and click the Search icon.", test, test1);

			Step_Start(8, "Change the Return Date for booking haulage operation respective date.", test, test1);

//4
			
			waitForElement(driver, pickupdate_leg);
			if (!leg_pickupdate.equals("")) {
				
				selectDatePickerWithTime1(driver, pickupdate_leg, leg_pickupdate);
			}else {
				waitForElement(driver, pickupdate_leg);
				clearAndType(driver, pickupdate_leg, leg_pickupdate);
			}
			
			//5

			waitForElement(driver, return_date_leg);
			if (!leg_return_date.equals("")) {
				
				selectDatePickerWithTime1(driver, return_date_leg, leg_return_date);
			
			}else {
				waitForElement(driver, return_Date_Field);
				clearAndType(driver, return_Date_Field, leg_return_date);
			}
	
			Step_End(8, "Change the Return Date for booking haulage operation respective date.", test, test1);

			
			Step_Start(9, "select the Empty in load status Drop-down.", test, test1);

			waitForElement(driver, load_status);
            click1(driver, load_status);
			waitForElement(driver, Load_status_value);
			click(driver,Load_status_value);
			
			Step_End(9, "select the Empty in load status Drop-down.", test, test1);

			Step_Start(10, " Click the Add button and click the Exit icon.", test, test1);

		    waitForElement(driver, vendor_Code_addbtn);
		    click(driver,vendor_Code_addbtn);
		    
		    waitForDisplay(driver, popup_Message_Ok_Button);
		    if(isdisplayed(driver, popup_Message_Ok_Button)) {
		    waitForElement(driver, popup_Message_Ok_Button);
		    click(driver, popup_Message_Ok_Button);
		    }
		    
		    waitForDisplay(driver, vendor_Code_closebtn);
		    if(isdisplayed(driver, vendor_Code_closebtn)) {
		    	  waitForElement(driver, vendor_Code_closebtn);
				    click(driver, vendor_Code_closebtn);
		    }
			Step_Start(10, " Click the Add button and click the Exit icon.", test, test1);

			Step_Start(11, " Click the Save button.", test, test1);
			  waitForElement(driver, TDN_Charges_Tab);
		    click1(driver, TDN_Charges_Tab);
			
			
		    if(Auto_rate_Perform.equalsIgnoreCase("YES")) {			
				List<WebElement> Numberofcontainer = listOfElements(driver, Second_Gird_coloum);		
				for(WebElement ele : Numberofcontainer) {		
					ele.click();	
						
				}		
				  waitForElement(driver, TDN_Charges_Tab);		
				    click1(driver, TDN_Charges_Tab);		
						
						
				    waitForElement(driver, Auto_Rate);		
				    click1(driver, Auto_Rate);		
				    waitForDisplay(driver, popup_Message_Ok_Button);		
				    if(isdisplayed(driver, popup_Message_Ok_Button)) {		
				    	   click1(driver, popup_Message_Ok_Button);	
				    }		
				    waitForElement(driver, TDN_Master_Tab);		
				    click1(driver, TDN_Master_Tab);		
						
				}		
		scrollTop(driver);
		    waitForElement(driver, SaveButton_ToolBar);
		    click1(driver, SaveButton_ToolBar);
		    
			Step_End(11, " Click the Save button.", test, test1);
			waitForPopup(driver, popup_Message, Transportation_saved);   

		    String Transportation_dispatch_savedpopup = getText(driver, popup_Message);
			System.out.println(Transportation_dispatch_savedpopup);
			
			if(Transportation_saved.contains(Transportation_dispatch_savedpopup)) {                                                                                                                  
				System.out.println("Matched || " + " Expected saved popup -> " + Transportation_saved + " || Actual saved popup is :  " + Transportation_dispatch_savedpopup);   
				Extent_pass_New(driver, "Matched || " + " Expected saved popup -> " + Transportation_saved + " || Actual saved popup is :  " + Transportation_dispatch_savedpopup, test, test1);
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected saved popup -> " + Transportation_saved + " || Actual saved popup is :  " + Transportation_dispatch_savedpopup);        
				Extent_fail(driver, "Not Matched || " + "  Expected saved popup -> " + Transportation_saved + " || Actual saved popup is :  " + Transportation_dispatch_savedpopup, test,test1); 
			} 
			
			
			click(driver, popup_Message_Ok_Button);
			Extent_completed(tc_Name, test, test1);

		}
 

}
