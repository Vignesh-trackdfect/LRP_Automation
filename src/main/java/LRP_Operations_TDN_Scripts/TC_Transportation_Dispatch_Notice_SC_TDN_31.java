package LRP_Operations_TDN_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Transportation_Dispatch_Notice_SC_TDN_31 extends Keywords{

public void Transportation_Dispatch_Notice_SC_TDN_31(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
String testCase_Name ="TC_Transportation_Dispatch_Notice_SC_TDN_31";


String username=Excel_data.get("Username");
String password=Excel_data.get("Password");
String moduleTDN=Excel_data.get("ModuleTDN");
String agencyUser = Excel_data.get("AgencyUser");
String Provisional_perform =Excel_data.get("Provisional_perform");
String Shipment_Type =Excel_data.get("Shipment_Type");
String Booking_Number_perform =Excel_data.get("Booking_Number_perform");
String Trans_select =Excel_data.get("Trans_select");
String Trans_select1 =Excel_data.get("Trans_select1");
String App_Date =Excel_data.get("App_Date");
String App_Date1 =Excel_data.get("App_Date1");
String date_Picker =Excel_data.get("date_Picker");
String tdn_SavedPopup =Excel_data.get("TDN_SavedPopup");
String Modeof_Transport =Excel_data.get("Modeof_Transport");
String Modeof_Transport1 =Excel_data.get("Modeof_Transport1");
String Modeof_Transport_Type =Excel_data.get("Modeof_Transport_Type");
String Modeof_Transport_Type1 =Excel_data.get("Modeof_Transport_Type1");
String Vender_Code =Excel_data.get("Vender_Code");
String Vender_Code1 =Excel_data.get("Vender_Code1");
String Status =Excel_data.get("Status");
String merchantPopup =Excel_data.get("MerchantPopup");
String pickup_loc_dd_data =Excel_data.get("pickup_loc_dd_data");
String pickup_loc_search_data =Excel_data.get("pickup_loc_search_data");
String condition =Excel_data.get("condition");
String cust_depot_term_data =Excel_data.get("cust_depot_term_data");
String cust_dep_search_data =Excel_data.get("cust_dep_search_data");
String return_loc_dd_data =Excel_data.get("return_loc_dd_data");
String return_loc_search_data =Excel_data.get("return_loc_search_data");
String leg_date_Picker =Excel_data.get("leg_date_Picker");
String leg_pickupdate =Excel_data.get("leg_pickupdate");
String with_chasis_flag =Excel_data.get("with_chasis_flag");
String chasis_pickup_dd_data =Excel_data.get("chasis_pickup_dd_data");
String chasis_drop_dd_data =Excel_data.get("chasis_drop_dd_data");
String chasis_pickup_Search_data =Excel_data.get("chasis_pickup_Search_data");
String chasis_drop_Search_data =Excel_data.get("chasis_drop_Search_data");
String Chassis_Mode =Excel_data.get("Chassis_Mode");
String Return_Date =Excel_data.get("Return_Date");
String pickup_loc_dd_data1 =Excel_data.get("pickup_loc_dd_data1");
String pickup_loc_search_data1 =Excel_data.get("pickup_loc_search_data1");
String cust_depot_term_data1 =Excel_data.get("cust_depot_term_data1");
String cust_dep_search_data1 =Excel_data.get("cust_dep_search_data1");
String return_loc_dd_data1 =Excel_data.get("return_loc_dd_data1");
String return_loc_search_data1 =Excel_data.get("return_loc_search_data1");
String leg_pickupdate1 =Excel_data.get("leg_pickupdate1");
String with_chasis_flag1 =Excel_data.get("with_chasis_flag1");
String chasis_pickup_dd_data1 =Excel_data.get("chasis_pickup_dd_data1");
String chasis_drop_dd_data1 =Excel_data.get("chasis_drop_dd_data1");
String chasis_pickup_Search_data1 =Excel_data.get("chasis_pickup_Search_data1");
String chasis_drop_Search_data1 =Excel_data.get("chasis_drop_Search_data1");
String Chassis_Mode1 =Excel_data.get("Chassis_Mode1");
String Return_Date1 =Excel_data.get("Return_Date1");

String Booking_Number1 =Excel_data.get("Booking_Number1");
String Booking_Number_Type_Select1 =Excel_data.get("Booking_Number_Type_Select1");
String ware_House_Type_Select1 =Excel_data.get("ware_House_Type_Select1");
String Ware_House_number1 =Excel_data.get("Ware_House_number1");
String Ware_House_number2 =Excel_data.get("Ware_House_number2");
String Dropdown_Condition =Excel_data.get("Dropdown_Condition");
String cust_depot_term_header =Excel_data.get("cust_depot_term_header");
String return_location_header =Excel_data.get("return_location_header");
String return_location_header1 =Excel_data.get("return_location_header1");
String pickup_location_header =Excel_data.get("pickup_location_header");
String chasis_pickup_header =Excel_data.get("chasis_pickup_header");
String chasis_drop_header =Excel_data.get("chasis_drop_header");
String Global_search_Vendor_Code_Option1 =Excel_data.get("Global_search_Vendor_Code_Option1");
String Vendor_Search_Type2 =Excel_data.get("Vendor_Search_Type2");
String Vendor_Search_Input2 =Excel_data.get("Vendor_Search_Input2");
String Vendor_Search_Type3 =Excel_data.get("Vendor_Search_Type3");
String Vendor_Search_Input3 =Excel_data.get("Vendor_Search_Input3");
String Load_Status_drop_dd_data =Excel_data.get("Load_Status_drop_dd_data");
String Load_Status_drop_dd_data1 =Excel_data.get("Load_Status_drop_dd_data1");
String MerchantPopup_Perform = Excel_data.get("MerchantPopup_Perform");
String Pickup_Date = Excel_data.get("Pickup_Date");
String tdn_SavedPopup1 =Excel_data.get("TDN_SavedPopup1");
String Auto_rate_Perform =Excel_data.get("Auto_rate_Perform");
String shipmenttype_select=String.format(Tshipmenttype_select, Shipment_Type);
navigateUrl(driver,url);

Extent_Start(testCase_Name, test, test1);
// Login
LRP_Login(driver, username, password);
Extent_call(test, test1,"**Switch the Profile Start**");
SwitchProfile(driver, agencyUser);
Extent_cal(test, test1, "Transportaion Dispatch Notice");
moduleNavigate(driver, moduleTDN);
newButton(driver);
waitForElement(driver, Tshipment_Dropdown);
click(driver, Tshipment_Dropdown);
click(driver, shipmenttype_select);

Step_Start(1, "select provisional checkbox.", test, test1);


waitForElement(driver, TProvisional_check_box);
checkBox(driver, TProvisional_check_box, Provisional_perform);

Step_End(1, "select provisional checkbox.", test, test1);
if (Booking_Number_perform.equalsIgnoreCase("YES")) {
List<String> datas = splitAndExpand(Booking_Number1);
for (int i=0;i<datas.size();i++) {
Step_Start(2, "Click add(+) button in BookNo field.", test, test1);
waitForElement(driver, BL_Add);
click(driver, BL_Add);
Step_End(2, "Click add(+) button in BookNo field.", test, test1);
globalValueSearchWindow(driver, Dropdown_Condition, Booking_Number_Type_Select1, datas.get(i), "", "", "", "");
Step_Start(3, "Paste book number and click search button.", test, test1);
Step_End(3, "Paste book number and click search button.", test, test1);
Step_Start(4, "Select the book number", test, test1);
Step_End(4, "Select the book number", test, test1);
}
}
Step_Start(5, " system will display Selected Booking is a Merchant. Do you want to proceed? click yes.", test, test1);
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
Step_End(5, " system will display Selected Booking is a Merchant. Do you want to proceed? click yes.", test, test1);
Step_Start(6, "click customer tab.", test, test1);
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
Step_End(6, "click customer tab.", test, test1);
Step_Start(7, "select book number from dropdown.", test, test1);

waitForElement(driver, TSelect_Booking_DD);
click(driver, TSelect_Booking_DD);
String contract_click1=String.format(bookingNumber_Select, Booking_Number1);
waitForElement(driver, contract_click1);
click(driver, contract_click1);

Step_End(7, "select book number from dropdown.", test, test1);

Step_Start(8, "click all in the box.", test, test1);

waitForElement(driver, TSelect_Booking_all);
click(driver, TSelect_Booking_all);

Step_End(8, "click all in the box.", test, test1);

Step_Start(9, "click search icon in the warehouse field.", test, test1);

waitForElement(driver, TAdd_ware_house);
click(driver, TAdd_ware_house);
globalValueSearchWindow(driver, Dropdown_Condition, ware_House_Type_Select1, Ware_House_number1, "", "", "", "");

Step_End(9, "click search icon in the warehouse field.", test, test1);

Step_Start(10, "enter % in warehouse name.", test, test1);

Step_End(10, "enter % in warehouse name.", test, test1);

Step_Start(11, "click on the warehouse and click select button.", test, test1);

Step_End(11, "click on the warehouse and click select button.", test, test1);


Step_Start(12, "click in app date field and select the current date.", test, test1);
waitForElement(driver, Date_click);
if (date_Picker.equalsIgnoreCase("Yes")) {
selectDatePickerWithTime1(driver, Date_click, App_Date);
} else {
waitForElement(driver, Date_click);
clearAndType(driver, Date_click, App_Date);
}
waitForElement(driver, local_Cust_Field);
click(driver, local_Cust_Field);
Step_End(12, "click in app date field and select the current date.", test, test1);

Step_Start(13, "select mode of transport as truck in dropdown.", test, test1);

waitForElement(driver, mode_of_Trans);
click(driver, mode_of_Trans);
String trans_select=String.format(transModeType, Trans_select);
waitForElement(driver, trans_select);
click(driver, trans_select);
Step_End(13, "select mode of transport as truck in dropdown.", test, test1);

Step_Start(14, "click add button.", test, test1);

click(driver, Customer_Add_Button);

Step_End(14, "click add button.", test, test1);

Step_Start(15, "Click master Tab", test, test1);
waitForElement(driver, TDN_Master_Tab);
click(driver, TDN_Master_Tab);

Step_End(15, "Click master Tab", test, test1);
scrollTop(driver);
waitForElement(driver, SaveButton_ToolBar);
click(driver, SaveButton_ToolBar);
Step_End(15, "click save icon in tool bar.", test, test1);

Step_Start(16, "system will display 'Transportation Dispatch Notice saved', click ok.", test, test1);

waitForPopup(driver, popup_Message, tdn_SavedPopup);
String actual_TDN_SavedPopup=getText(driver, popup_Message);
if(actual_TDN_SavedPopup.equals(tdn_SavedPopup)) {
Extent_pass_New(driver, "Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup, test, test1);
System.out.println("Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup);
click(driver, popup_Message_Ok_Button);
}else {
Extent_fail(driver, "Not Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup, test, test1);
System.out.println("Not Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup);
}

waitForElement(driver, Makeas_draft);
click(driver,Makeas_draft);

Step_End(15, "Click master Tab.", test, test1);


Step_Start(16, "select the container.", test, test1);
waitForElement(driver, addleg_select);
click(driver, addleg_select);

Step_End(16, "select the container.", test, test1);

Step_Start(17, "click add leg button.", test, test1);
waitForElement(driver, addleg);
click(driver, addleg);
Step_End(17, "click add leg button.", test, test1);

Step_Start(18, "select mode of transport as truck in drop down.", test, test1);
waitForElement(driver, modeof_transport);
click(driver, modeof_transport);
String Select_ModeOfTransport=String.format(mode_Of_Transport, Modeof_Transport);
waitForElement(driver, Select_ModeOfTransport);
click(driver, Select_ModeOfTransport);

Step_End(18, "select mode of transport as truck in drop down.", test, test1);

Step_Start(19, " click search icon in vendor details, enter % in vendor code and select the vendor.", test, test1);

//
waitForElement(driver, vendor_searchicon);
click(driver, vendor_searchicon);

globalValueSearchWindow(driver, Dropdown_Condition, Global_search_Vendor_Code_Option1, Vender_Code, Vendor_Search_Type2, Vendor_Search_Input2, Vendor_Search_Type3, Vendor_Search_Input3);
Step_End(19, " click search icon in vendor details, enter % in vendor code and select the vendor.", test, test1);

Step_Start(20, "select Trans. Type Mode as (pickup only/Live load) in dropdown", test, test1);

click(driver,modeof_transport_type);
String Select_ModeOfTransport_type=String.format(mode_Of_Transport, Modeof_Transport_Type);
waitForElement(driver, Select_ModeOfTransport_type);
click(driver, Select_ModeOfTransport_type);
//pickuplocation
waitForElement(driver, pickup_loc_label);
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
//2
waitForElement(driver, cust_Depot_Term_Label);
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
//3
waitForElement(driver, return_location_label);
if(isElementAccessible(driver, return_location_label)&&!return_loc_dd_data.equals("")) {
waitForElement(driver,return_location_label);
click(driver, return_location_label);
String return_loc_dd = String.format(DropDown_Select, return_loc_dd_data);
waitForElement(driver, return_loc_dd);
click(driver, return_loc_dd);
}
if(!return_loc_search_data.equalsIgnoreCase("")) {
waitForElement(driver, return_location_searchicon);
click(driver, return_location_searchicon);
twoColumnSearchWindow(driver, return_location_header, condition, return_loc_search_data);
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
if(!Load_Status_drop_dd_data.equals("")) {
waitForElement(driver, load_status);
click(driver, load_status);
String Load_Status_drop_dd = String.format(DropDown_Select, Load_Status_drop_dd_data);
waitForElement(driver, Load_Status_drop_dd);
click(driver, Load_Status_drop_dd);
}
//4
// if(!leg_pickupdate.equals("")) {
// waitForElement(driver, pickupdate_leg);
// if (leg_date_Picker.equalsIgnoreCase("Yes")) {
// selectDatePickerWithTime1(driver, pickupdate_leg, leg_pickupdate);
// }else {
// waitForElement(driver, pickupdate_leg);
// clearAndType(driver, pickupdate_leg, leg_pickupdate);
// }
// }
if(!Return_Date.equals("")) {
waitForElement(driver, return_Date_Field);
if (date_Picker.equalsIgnoreCase("Yes")) {
selectDatePickerWithTime1(driver, return_Date_Field, Return_Date);
} else {
waitForElement(driver, return_Date_Field);
clearAndType(driver, return_Date_Field, Return_Date);
}
}
if(!leg_pickupdate.equals("")) {
waitForElement(driver, pickupdate_leg);
if (date_Picker.equalsIgnoreCase("Yes")) {
selectDatePickerWithTime1(driver, pickupdate_leg, leg_pickupdate);
} else {
waitForElement(driver, pickupdate_leg);
clearAndType(driver, pickupdate_leg, leg_pickupdate);
}
}
Step_End(20, "select Trans. Type Mode as (pickup only/Live load) in dropdown", test, test1);
Step_Start(21, "click add button and close the pop window", test, test1);

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
Step_End(21, "click add button and close the pop window", test, test1);
Step_Start(22, "click save icon in toolbar.", test, test1);
if(Auto_rate_Perform.equalsIgnoreCase("YES")) {
waitForElement(driver, TDN_Charges_Tab);
click1(driver, TDN_Charges_Tab);
waitForElement(driver, Auto_Rate);
click1(driver, Auto_Rate);
waitForDisplay(driver, popup_Message_Ok_Button);
if(isdisplayed(driver, popup_Message_Ok_Button)) {
click1(driver, popup_Message_Ok_Button);
}}
waitForElement(driver, TDN_Master_Tab);
click1(driver, TDN_Master_Tab);

scrollTop(driver);
waitForElement(driver, SaveButton_ToolBar);
click1(driver, SaveButton_ToolBar);
Step_End(22, "click save icon in toolbar.", test, test1);

waitForElement(driver, popup_Message_Ok_Button);
click(driver, popup_Message_Ok_Button);
Step_Start(23, "Ensure draft checkbox is selected", test, test1);
waitForElement(driver, TDraft_check_box);
String draft_Status = getAttribute(driver, TDraft_check_box, "class");
if(draft_Status.contains(Status))
{
System.out.println("Matched || The Draft Checkbox is Selected");
Extent_pass_New(driver, "Matched || The Draft Checkbox is Selected", test, test1);
}else {
System.out.println("Not Matched || The Draft Checkbox is Not Selected");
Extent_fail(driver, "Not Matched || The Draft Checkbox is Selected", test, test1);
}
Step_End(23, "Ensure draft checkbox is selected", test, test1);
Step_Start(24, "Click add(+) button in BookNo field.- ( BLNO Field for Import TDN )", test, test1);
// waitForElement(driver, tdnPopup_Ok);
// click(driver, tdnPopup_Ok);
waitForDisplay(driver, NewButton_ToolBar);
if(isdisplayed(driver, NewButton_ToolBar) && isElementAccessible(driver, NewButton_ToolBar)) {
click(driver, NewButton_ToolBar);
waitForElement(driver, popup_Message_Yes_Button);
click(driver, popup_Message_Yes_Button);
}
waitForElement(driver, TProvisional_check_box);
checkBox(driver, TProvisional_check_box, Provisional_perform);
if (Booking_Number_perform.equalsIgnoreCase("YES")) {
List<String> datas = splitAndExpand(Booking_Number1);
for (int i=0;i<datas.size();i++) {
Step_Start(2, "Click add(+) button in BookNo field.", test, test1);
waitForElement(driver, BL_Add);
click(driver, BL_Add);
Step_End(2, "Click add(+) button in BookNo field.", test, test1);
globalValueSearchWindow(driver, Dropdown_Condition, Booking_Number_Type_Select1, datas.get(i), "", "", "", "");
Step_Start(3, "Paste book number and click search button.", test, test1);
Step_End(3, "Paste book number and click search button.", test, test1);
Step_Start(4, "Select the book number", test, test1);
Step_End(4, "Select the book number", test, test1);
}
}

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
Step_Start(28, "click customer tab", test, test1);
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
}
Step_End(28, "click customer tab", test, test1);
Step_Start(29, "select book number from dropdown", test, test1);
waitForElement(driver, TSelect_Booking_DD);
click(driver, TSelect_Booking_DD);
String contract_click3=String.format(bookingNumber_Select, Booking_Number1);
waitForElement(driver, contract_click3);
click(driver, contract_click3);
Step_End(29, "select book number from dropdown", test, test1);

Step_Start(30, "click all in the box", test, test1);
waitForElement(driver, TSelect_Booking_all);
click(driver, TSelect_Booking_all);
Step_End(30, "click all in the box", test, test1);
Step_Start(31, "click search icon in the warehouse field", test, test1);
waitForElement(driver, TAdd_ware_house);
click(driver, TAdd_ware_house);
Step_End(31, "click search icon in the warehouse field", test, test1);
Step_Start(32, "enter % in warehouse name", test, test1);

globalValueSearchWindow(driver, Dropdown_Condition, ware_House_Type_Select1, Ware_House_number2, "", "", "", "");

Step_End(32, "enter % in warehouse name", test, test1);
Step_Start(33, "click on the warehouse and click select button", test, test1);

Step_End(33, "click on the warehouse and click select button", test, test1);
Step_Start(34, "click in app date field and select the current date", test, test1);
waitForElement(driver, Date_click);
if (date_Picker.equalsIgnoreCase("Yes")) {
selectDatePickerWithTime1(driver, Date_click, App_Date1);
} else {
waitForElement(driver, Date_click);
clearAndType(driver, Date_click, App_Date1);
}
waitForElement(driver, local_Cust_Field);
click(driver, local_Cust_Field);
Step_End(34, "click in app date field and select the current date", test, test1);
Step_Start(35, "select mode of transport as truck in dropdown", test, test1);

waitForElement(driver, mode_of_Trans);
click(driver, mode_of_Trans);
String trans_select1=String.format(transModeType, Trans_select1);
waitForElement(driver, trans_select1);
click(driver, trans_select1);
Step_End(35, "select mode of transport as truck in dropdown", test, test1);
Step_Start(36, "click add button.", test, test1);

click(driver, Customer_Add_Button);
Step_End(36, "click add button.", test, test1);
Step_Start(37, "Click master Tab", test, test1);
waitForElement(driver, TDN_Master_Tab);
click(driver, TDN_Master_Tab);
waitForElement(driver, TDN_Master_Tab);
click(driver, TDN_Master_Tab);

Step_End(15, "Click master Tab", test, test1);
scrollTop(driver);
waitForElement(driver, SaveButton_ToolBar);
click(driver, SaveButton_ToolBar);
Step_End(15, "click save icon in tool bar.", test, test1);

Step_Start(16, "system will display 'Transportation Dispatch Notice saved', click ok.", test, test1);

waitForPopup(driver, popup_Message, tdn_SavedPopup);
String actual_TDN_SavedPopup1=getText(driver, popup_Message);
if(actual_TDN_SavedPopup1.equals(tdn_SavedPopup)) {
Extent_pass_New(driver, "Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup1, test, test1);
System.out.println("Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup1);
click(driver, popup_Message_Ok_Button);
}else {
Extent_fail(driver, "Not Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup1, test, test1);
System.out.println("Not Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup1);
}

waitForElement(driver, Makeas_draft);
click(driver,Makeas_draft);


Step_End(37, "Click master Tab", test, test1);

Step_Start(38, "select the container.", test, test1);
waitForElement(driver, addleg_select);
click(driver, addleg_select);

Step_End(38, "select the container.", test, test1);

Step_Start(39, "click add leg button.", test, test1);
waitForElement(driver, addleg);
click(driver, addleg);
Step_End(39, "click add leg button.", test, test1);

Step_Start(40, "select mode of transport as truck in drop down.", test, test1);
waitForElement(driver, modeof_transport);
click(driver, modeof_transport);
Select_ModeOfTransport=String.format(mode_Of_Transport, Modeof_Transport1);
waitForElement(driver, Select_ModeOfTransport);
click(driver, Select_ModeOfTransport);

Step_End(40, "select mode of transport as truck in drop down.", test, test1);

Step_Start(41, " click search icon in vendor details, enter % in vendor code and select the vendor.", test, test1);
waitForElement(driver, vendor_searchicon);
click(driver, vendor_searchicon);
globalValueSearchWindow(driver, Dropdown_Condition, Global_search_Vendor_Code_Option1, Vender_Code1, "", "", "", "");
Step_End(41, " click search icon in vendor details, enter % in vendor code and select the vendor.", test, test1);

Step_Start(42, "select Trans. Type Mode as (pickup only/Live load) in dropdown", test, test1);
click(driver,modeof_transport_type);
Select_ModeOfTransport_type=String.format(mode_Of_Transport, Modeof_Transport_Type1);
waitForElement(driver, Select_ModeOfTransport_type);
click(driver, Select_ModeOfTransport_type);
//pickuplocation
waitForElement(driver, pickup_loc_label);
if(!pickup_loc_dd_data1.equals("")) {
waitForElement(driver,pickup_loc_label);
click(driver, pickup_loc_label);
String pickup_dd = String.format(DropDown_Select, pickup_loc_dd_data1);
waitForElement(driver, pickup_dd);
click(driver, pickup_dd);
}
if(!pickup_loc_search_data1.equalsIgnoreCase("")) {
waitForElement(driver, pickup_loc_search_icon);
click(driver, pickup_loc_search_icon);
twoColumnSearchWindow(driver, pickup_location_header, condition, pickup_loc_search_data1);
}
//2
waitForElement(driver, cust_Depot_Term_Label);
if(!cust_depot_term_data1.equals("")) {
waitForElement(driver,cust_Depot_Term_Label);
click(driver, cust_Depot_Term_Label);
String cust_depo_dd = String.format(DropDown_Select, cust_depot_term_data1);
waitForElement(driver, cust_depo_dd);
click(driver, cust_depo_dd);
}
if(!cust_dep_search_data1.equalsIgnoreCase("")) {
waitForElement(driver, cust_depo_term_search_icon);
click(driver, cust_depo_term_search_icon);
twoColumnSearchWindow(driver, cust_depot_term_header, condition, cust_dep_search_data1);
}
//3
// waitForElement(driver, return_location_label);
// if(IsElementAccessible(driver, return_location_label)) {
// waitForElement(driver,return_location_label);
// click(driver, return_location_label);
// String return_loc_dd = String.format(DropDown_Select, return_loc_dd_data1);
// waitForElement(driver, return_loc_dd);
// click(driver, return_loc_dd);
// }
if(!return_loc_search_data1.equalsIgnoreCase("")) {
waitForElement(driver, return_location_searchicon);
click(driver, return_location_searchicon);
twoColumnSearchWindow(driver, return_location_header1, condition, return_loc_search_data1);
}

waitForElement(driver, with_Chassis_Check_Box);
checkBox(driver, with_Chassis_Check_Box, with_chasis_flag1);

if(with_chasis_flag1.equalsIgnoreCase("yes")) {
if(!Chassis_Mode.equals("")) {
String mode_Select = String.format(With_Chassis_Mode, Chassis_Mode1);
waitForElement(driver, mode_Select);
click(driver, mode_Select);
}
if(!chasis_pickup_dd_data.equals("")) {
waitForElement(driver, Chassis_Pickup_Loc_Label);
click(driver, Chassis_Pickup_Loc_Label);
String chasis_pickup_dd = String.format(DropDown_Select, chasis_pickup_dd_data1);
waitForElement(driver, chasis_pickup_dd);
click(driver, chasis_pickup_dd);
}
if(!chasis_pickup_Search_data1.equals("")) {
waitForElement(driver, Chassis_Pickup_Loc_Search);
click(driver, Chassis_Pickup_Loc_Search);
twoColumnSearchWindow(driver, chasis_pickup_header, condition, chasis_pickup_Search_data1);
}
//drop
if(!chasis_drop_dd_data.equals("")) {
waitForElement(driver, Chassis_Drop_Loc_Label);
click(driver, Chassis_Drop_Loc_Label);
String chasis_drop_dd = String.format(DropDown_Select, chasis_drop_dd_data1);
waitForElement(driver, chasis_drop_dd);
click(driver, chasis_drop_dd);
}
if(chasis_drop_Search_data1.equals("")) {
waitForElement(driver, Chassis_Drop_Loc_Search);
click(driver, Chassis_Drop_Loc_Search);
twoColumnSearchWindow(driver, chasis_drop_header, condition, chasis_drop_Search_data1);
}
}
if(!Load_Status_drop_dd_data1.equals("")) {
waitForElement(driver, load_status);
click(driver, load_status);
String Load_Status_drop_dd = String.format(DropDown_Select, Load_Status_drop_dd_data1);
waitForElement(driver, Load_Status_drop_dd);
click(driver, Load_Status_drop_dd);
}
//4
if(!leg_pickupdate1.equals("")) {
waitForElement(driver, pickupdate_leg);
if (leg_date_Picker.equalsIgnoreCase("Yes")) {
selectDatePickerWithTime1(driver, pickupdate_leg, leg_pickupdate1);
}else {
waitForElement(driver, pickupdate_leg);
clearAndType(driver, pickupdate_leg, leg_pickupdate1);
}
}
click(driver, pickupdateclose);
if(!Return_Date1.equals("")) {
waitForElement(driver, return_Date_Field);
if (date_Picker.equalsIgnoreCase("Yes")) {
selectDatePickerWithTime1(driver, return_Date_Field, Return_Date1);
} else {
waitForElement(driver, return_Date_Field);
clearAndType(driver, return_Date_Field, Return_Date1);
}
}
Step_End(42, "select Trans. Type Mode as (pickup only/Live load) in dropdown", test, test1);
Step_Start(43, "Click the Edit button", test, test1);

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
Step_End(43, "Click the Edit button", test, test1);
Step_Start(44, "click save icon in toolbar.", test, test1);
if(Auto_rate_Perform.equalsIgnoreCase("YES")) {
waitForElement(driver, TDN_Charges_Tab);
click1(driver, TDN_Charges_Tab);
waitForElement(driver, Auto_Rate);
click1(driver, Auto_Rate);
waitForDisplay(driver, popup_Message_Ok_Button);
if(isdisplayed(driver, popup_Message_Ok_Button)) {
click1(driver, popup_Message_Ok_Button);
}}
waitForElement(driver, TDN_Master_Tab);
click1(driver, TDN_Master_Tab);

scrollTop(driver);
waitForElement(driver, SaveButton_ToolBar);
click1(driver, SaveButton_ToolBar);
waitForPopup(driver, popup_Message, tdn_SavedPopup);
String actual_TDN_SavedPopup11=getText(driver, popup_Message);
if(actual_TDN_SavedPopup11.equals(tdn_SavedPopup1)) {
Extent_pass_New(driver, "Matched || Expected Pop up : "+tdn_SavedPopup1 +" || Actual Pop up : "+actual_TDN_SavedPopup11, test, test1);
System.out.println("Matched || Expected Pop up : "+tdn_SavedPopup1 +" || Actual Pop up : "+actual_TDN_SavedPopup11);
click(driver, popup_Message_Ok_Button);
}else {
Extent_fail(driver, "Not Matched || Expected Pop up : "+tdn_SavedPopup1 +" || Actual Pop up : "+actual_TDN_SavedPopup11, test, test1);
System.out.println("Not Matched || Expected Pop up : "+tdn_SavedPopup1 +" || Actual Pop up : "+actual_TDN_SavedPopup11);
}
Step_End(44, "click save icon in toolbar.", test, test1);
Extent_completed(testCase_Name, test, test1);
}

}
