package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_004 extends Keywords {

	public void Arrival_Notice_TS_004(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Arrival_Notice_TS_004";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ArrivalNotice_Module = Excel_data.get("ArrivalNotice_Module");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Search_Number = Excel_data.get("Search_Number");
		String BL_Num = Excel_data.get("BL_Num");
		String BL_Search_Button_Check = Excel_data.get("BL_Search_Button_Check");
		String Show_Button_Check = Excel_data.get("Show_Button_Check");
		String Fax_Button_Check = Excel_data.get("Fax_Button_Check");
		String pol_TF_check = Excel_data.get("pol_TF_check");
		String ETD_TF_Check = Excel_data.get("ETD_TF_Check");
		String ETA_TF_Check = Excel_data.get("ETA_TF_Check");
		String pod_TF_Check = Excel_data.get("pod_TF_Check");
		String discharge_Bound_TF_Check = Excel_data.get("discharge_Bound_TF_Check");
		String blNn_copy_Button_Check = Excel_data.get("blNn_copy_Button_Check");
		String Auction_Notice_Button_Check = Excel_data.get("Auction_Notice_Button_Check");
		String Discharge_Service_TF_Check = Excel_data.get("Discharge_Service_TF_Check");
		String discharge_Vessel_TF_Check = Excel_data.get("discharge_Vessel_TF_Check");
		String discharge_Voyage_TF_check = Excel_data.get("discharge_Voyage_TF_check");
		String BL_Number_TF_check = Excel_data.get("BL_Number_TF_check");
		String discharge_Terminal_TF_Check = Excel_data.get("discharge_Terminal_TF_Check");
		String Mail_Button_Check = Excel_data.get("Mail_Button_Check");
		String ArrivalNotice_Saved_Popup = Excel_data.get("ArrivalNotice_Saved_Popup");
		String Saved_Record_Colour = Excel_data.get("Saved_Record_Colour");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		
	
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch agency and open Arrival Notice / Freight Memo Module", test, test1);
		SwitchProfile(driver, AgencyUser);
		
		

		
		moduleNavigate(driver, ArrivalNotice_Module);

		Step_End(1, "Switch agency and open Arrival Notice / Freight Memo Module", test, test1);

		Step_Start(2, "Click on New Button", test, test1);

		newButton(driver);

		Step_End(2, "Click on New Button", test, test1);
		Step_Start(3, "Click BL number option", test, test1);
		waitForElement(driver, by_Bl_Number_Button_AN);
		click(driver, by_Bl_Number_Button_AN);
		
		waitForElement(driver, BL_Search_button_AN);
		click(driver, BL_Search_button_AN);
		Step_End(3, "Click BL number option", test, test1);
		Step_Start(4, "paste the Bl", test, test1);
		globalValueSearchWindow(driver, BL_Condition, Search_Number, BL_Num, "", "", "", "");
	
		Step_End(4, "paste the Bl", test, test1);

		Step_Start(5, "click Show and click on Edit from toolbar", test, test1);
		
		if(BL_Search_Button_Check.equalsIgnoreCase("Y")) {
		if(isClickable(driver, BL_Search_button_AN)) {
			
			Extent_pass(driver, "Matched || Expected Result is : BY BL Search button Should be Enable || Actual Result is : BY BL Search button is Enabled", test, test1);
			System.out.println("Matched || Expected Result is : BY BL Search button Should be Enable || Actual Result is : BY BL Search button is Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is : BY BL Search button Should be Enable || Actual Result is : BY BL Search button is Not Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : BY BL Search button Should be Enable || Actual Result is : BY BL Search button is Not Enabled", test, test1);
		}
		}
			

		
		if(Show_Button_Check.equalsIgnoreCase("Y")) {
		if(isClickable(driver, show_Btn_An)) {
			
			Extent_pass(driver, "Matched || Expected Result is :Shown button Should be Enable || Actual Result is :Shown button is Enabled", test, test1);
			System.out.println("Matched || Expected Result is : Shown button Should be Enable || Actual Result is : Shown button is Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :Shown button Should be Enable || Actual Result is : Shown button is Not Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : Shown button Should be Enable || Actual Result is : Shown  button is Not Enabled", test, test1);
		}
		}
			
		
		if(Fax_Button_Check.equalsIgnoreCase("Y")) {
		if(elementNotclickable(driver, fax_Button_AN)) {
			Extent_pass(driver, "Matched || Expected Result is :Fax button Should not be Enable || Actual Result is :Fax button is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : Fax button Should not be Enable || Actual Result is : Fax button is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :Fax button Should  be Enable  || Actual Result is : Fax button is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : Fax button Should  be Enable  || Actual Result is : Fax button is  Enabled", test, test1);
		}
		}

		
		if(Auction_Notice_Button_Check.equalsIgnoreCase("Y")) {
		if(elementNotclickable(driver, auction_Notice_Button_AN)) {
			Extent_pass(driver, "Matched || Expected Result is :Auction Notice button Should not be Enable || Actual Result is :Auction Notice button is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : Auction Notice button Should not be Enable || Actual Result is : Auction Notice button is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :Auction Notice button Should  be Enable  || Actual Result is : Auction Notice button is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : Auction Notice button Should  be Enable  || Actual Result is : Auction Notice button is  Enabled", test, test1);
		}
		}
		
		
		if(Mail_Button_Check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, mail_Button_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :Mail button Should not be Enable || Actual Result is :Mail button is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : Mail button Should not be Enable || Actual Result is : Mail button is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :Mail button Should  be Enable  || Actual Result is : Mail button is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : Mail button Should  be Enable  || Actual Result is : Mail button is  Enabled", test, test1);
			}
			}
				
			
		if(blNn_copy_Button_Check.equalsIgnoreCase("Y")) {
		if(elementNotclickable(driver, blNn_copy_Button_AN)) {
			Extent_pass(driver, "Matched || Expected Result is :BLNNCopy button Should not be Enable || Actual Result is :BLNNCopy button is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : BLNNCopy button Should not be Enable || Actual Result is : BLNNCopy button is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :BLNNCopy button Should  be Enable  || Actual Result is : BLNNCopy button is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : BLNNCopy button Should  be Enable  || Actual Result is : BLNNCopy button is  Enabled", test, test1);
		}
		}
		
		
		if(BL_Number_TF_check.equalsIgnoreCase("Y")) {
		if(elementNotEditable(driver, bl_Number_TF_AN)) {
			Extent_pass(driver, "Matched || Expected Result is :BL Number TF button Should not be Enable || Actual Result is :BL Number TF button is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : BL Number TF button Should not be Enable || Actual Result is : BL Number TF button is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :BL Number TF button Should  be Enable  || Actual Result is : BL Number TF button is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : BL Number TF button Should  be Enable  || Actual Result is : BL Number TF button is  Enabled", test, test1);
		}
		}
		
		if(Discharge_Service_TF_Check.equalsIgnoreCase("Y")) {
		if(!isElementEnabled(driver, discharge_Service_TF_AN)) {
			
			Extent_pass(driver, "Matched || Expected Result is :Discharge Service  TF Should not be Enable || Actual Result is :Discharge Service  TF is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : Discharge Service  TF Should not be Enable || Actual Result is : Discharge Service  TF is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :Discharge Service  TF Should  be Enable  || Actual Result is : Discharge Service  TF is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : Discharge Service  TF Should  be Enable  || Actual Result is : Discharge Service  TF is  Enabled", test, test1);
		}
		}
		
		
		if(discharge_Vessel_TF_Check.equalsIgnoreCase("Y")) {
		if(elementNotEditable(driver, discharge_Vessel_TF_AN)) {
			
			Extent_pass(driver, "Matched || Expected Result is :Discharge Vessel  TF Should not be Enable || Actual Result is :Discharge Vessel  TF is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : Discharge Vessel  TF Should not be Enable || Actual Result is : Discharge Vessel  TF is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :Discharge Vessel  TF Should  be Enable  || Actual Result is : Discharge Vessel  TF is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : Discharge Vessel  TF Should  be Enable  || Actual Result is : Discharge Vessel  TF is  Enabled", test, test1);
		}
		}
		
		if(discharge_Voyage_TF_check.equalsIgnoreCase("Y")) {
		if(elementNotEditable(driver, discharge_Voyage_TF_AN)) {
			Extent_pass(driver, "Matched || Expected Result is :Discharge Voyage  TF Should not be Enable || Actual Result is :Discharge Voyage  TF is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : Discharge Voyage  TF Should not be Enable || Actual Result is : Discharge Voyage  TF is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :Discharge Voyage  TF Should  be Enable  || Actual Result is : Discharge Voyage  TF is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : Discharge Voyage  TF Should  be Enable  || Actual Result is : Discharge Voyage  TF is  Enabled", test, test1);
		}
		}
		
		if(discharge_Bound_TF_Check.equalsIgnoreCase("Y")) {
		if(elementNotEditable(driver, discharge_Bound_TF_AN)) {
			
			Extent_pass(driver, "Matched || Expected Result is :Discharge Bound  TF Should not be Enable || Actual Result is :Discharge Bound  TF is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : Discharge Bound  TF Should not be Enable || Actual Result is : Discharge Bound  TF is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :Discharge Bound  TF Should  be Enable  || Actual Result is : Discharge Bound  TF is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : Discharge Bound  TF Should  be Enable  || Actual Result is : Discharge Bound  TF is  Enabled", test, test1);
		}
		}
		
		
		if(pod_TF_Check.equalsIgnoreCase("Y")) {
		if(elementNotEditable(driver, pod_TF_AN)) {
			Extent_pass(driver, "Matched || Expected Result is :POD  TF Should not be Enable || Actual Result is :POD  TF is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : POD  TF Should not be Enable || Actual Result is : POD  TF is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :POD  TF Should  be Enable  || Actual Result is : POD  TF is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : POD  TF  Should  be Enable  || Actual Result is : POD  TF is  Enabled", test, test1);
		}
		}
		
		
		if(discharge_Terminal_TF_Check.equalsIgnoreCase("Y")) {
		if(elementNotEditable(driver, discharge_Terminal_TF_AN)) {
			Extent_pass(driver, "Matched || Expected Result is :Discharge Terminal  TF Should not be Enable || Actual Result is :Discharge Terminal  TF is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : Discharge Terminal  TF Should not be Enable || Actual Result is : Discharge Terminal  TF is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :Discharge Terminal  TF Should  be Enable  || Actual Result is : Discharge Terminal  TF is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : Discharge Terminal  TF  Should  be Enable  || Actual Result is : Discharge Terminal  TF is  Enabled", test, test1);
		}
		}
		
		
		if(ETA_TF_Check.equalsIgnoreCase("Y")) {
		if(elementNotEditable(driver, ETA_TF_AN)) {
			Extent_pass(driver, "Matched || Expected Result is :ETA  TF Should not be Enable || Actual Result is :ETA  TF is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : ETA  TF Should not be Enable || Actual Result is : ETA TF is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :ETA  TF Should  be Enable  || Actual Result is : ETA  TF is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : ETA  TF  Should  be Enable  || Actual Result is : ETA  TF is  Enabled", test, test1);
		}
		}
		
		
		if(ETD_TF_Check.equalsIgnoreCase("Y")) {
		if(elementNotEditable(driver, ETD_TF_AN)) {
			Extent_pass(driver, "Matched || Expected Result is :ETD  TF Should not be Enable || Actual Result is :ETD  TF is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : ETD  TF Should not be Enable || Actual Result is : ETD TF is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :ETD  TF Should  be Enable  || Actual Result is : ETD  TF is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : ETD  TF  Should  be Enable  || Actual Result is : ETD  TF is  Enabled", test, test1);
		}
		}
		
		if(pol_TF_check.equalsIgnoreCase("Y")) {
		if(elementNotEditable(driver, pol_TF_AN)) {
			Extent_pass(driver, "Matched || Expected Result is :POL  TF Should not be Enable || Actual Result is :POL  TF is not Enabled", test, test1);
			System.out.println("Matched || Expected Result is : POL  TF Should not be Enable || Actual Result is : POL TF is not Enabled");
		}else {
			System.out.println("Not Matched || Expected Result is :POL  TF Should  be Enable  || Actual Result is : POL  TF is  Enabled");
			Extent_fail(driver,"Not Matched || Expected Result is : POL  TF  Should  be Enable  || Actual Result is : POL  TF is  Enabled", test, test1);
		}
		}
		
	
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);

		
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);		
		Step_End(5, "click Show and click on Edit from toolbar", test, test1);
		
		Step_Start(6, "Select the record from the grid and click save button", test, test1);
		String select_Record_AN=String.format(Arrival_Notice_Locators.select_Record_AN, BL_Num);
		waitForElement(driver, select_Record_AN);
		click(driver, select_Record_AN);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForPopup(driver, Popup_Message, ArrivalNotice_Saved_Popup);
		String Saved_Popup=getText(driver, Popup_Message);
		System.out.println(Saved_Popup);
		if(ArrivalNotice_Saved_Popup.equals(Saved_Popup)) {
			System.out.println("Matched || Arrival Notice saved Expected Popup : " + ArrivalNotice_Saved_Popup + " || Arrival Notice saved Actual Popup : " + Saved_Popup);
			Extent_pass(driver, "Matched ||Arrival Notice saved Expected Popup : " + ArrivalNotice_Saved_Popup + " || Arrival Notice saved Actual Popup : " + Saved_Popup, test,
					test1);

		} else {
			System.out.println("NotMatched || Arrival Notice saved Expected Popup : " + ArrivalNotice_Saved_Popup + " || Arrival Notice saved Actual Popup : " + Saved_Popup);
			Extent_fail(driver, "NotMatched ||Arrival Notice saved Expected Popup : " + ArrivalNotice_Saved_Popup + " || Arrival Notice saved Actual Popup : " + Saved_Popup,
					test, test1);
		}	

		Step_End(6, "Select the record and click save button", test, test1);
		
		String Arrival_Notice_No=String.format(Arrival_Notice_Locators.arrival_Notice_Generated_No_AN, BL_Num);

		String Arrival_Notice_Number=getText(driver, Arrival_Notice_No);
		System.out.println("Arrival Notice Number:"+Arrival_Notice_Number);
         click(driver, Arrival_Notice_No);
         waitForElement(driver, Bl_Records_Background_Colour_AN);
         String Records_Background_Colour1=getTextBackgroundColor(driver, Bl_Records_Background_Colour_AN);
         String Records_Background_Colour=getColorName(Records_Background_Colour1);
         if(Saved_Record_Colour.equals(Records_Background_Colour)) {
        	 System.out.println("Matched || Background colour Expected  : " + Saved_Record_Colour + " || Background colour Actual : " + Records_Background_Colour);
 			Extent_pass(driver, "Matched ||Background colour Expected : " + Saved_Record_Colour + " || Background colour Actual : " + Records_Background_Colour, test,
 					test1);

 		} else {
 			System.out.println("NotMatched || Background colour Expected : " + Saved_Record_Colour + " || Background colour Actual : " + Records_Background_Colour);
 			Extent_fail(driver, "NotMatched ||Background colour Expected : " + Saved_Record_Colour + " || Background colour Actual : " + Records_Background_Colour,
 					test, test1);
 		}	 
        
         
         Step_Start(7, "Click the saved Arrival notice bl and click Delete button", test, test1);
 		scrollTop(driver);
 		if(Delete_Perform.equalsIgnoreCase("YES")) {
 		waitForElement(driver, Delete_button_toolBar);
 		click(driver, Delete_button_toolBar);
 		Step_End(7, "Click the saved Arrival notice bl and click Delete button", test, test1);
 		Step_Start(8, "Click Yes and system validates Arrival notice deleted", test, test1);
 		click(driver, popup_Message_Yes_Button);
 		}
 		Step_End(8, "Click Yes and system validates Arrival notice deleted", test, test1);

         
        Extent_completed(testcase_Name, test, test1);
         
		
	}

}
