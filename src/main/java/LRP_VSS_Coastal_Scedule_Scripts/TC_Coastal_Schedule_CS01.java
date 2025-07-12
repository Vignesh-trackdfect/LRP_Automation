package LRP_VSS_Coastal_Scedule_Scripts;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;
public class TC_Coastal_Schedule_CS01 extends Keywords{

	public void Coastal_Schedule_CS01(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS01";
		String Username_CS01 =Excel_data.get("Username");
		String Password_CS01 =Excel_data.get("Password");
		String ModuleSearch_CS01 =Excel_data.get("Module_Search");
		String ServiceCode_CS01 =Excel_data.get("Service_Code");
		String VesselCode_CS01 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS01 =Excel_data.get("Voyage_Number");
		String portName_CS01 =Excel_data.get("Port_Name");
		String Radio_Button_CS01 =Excel_data.get("Radio_Button");
		String ESOPDate_CS01 =Excel_data.get("EOSP");
		String confirmButton_CS01 =Excel_data.get("confirmButton");
		String ArrPilot_CS01 =Excel_data.get( "ArrivalPilot");
		String ALLFASTFEW_CS01 =Excel_data.get( "ALLFAST_FEW");
		String AllCastOff_CS01 =Excel_data.get( "AllCast_Off");
		String Pilot_CS01 =Excel_data.get("PilotAway") ;
		String BOSPDate_CS01 =Excel_data.get( "BOSP");
		String NotWorking_Hours_CS01 =Excel_data.get("Not_Working");
		String TotalMoves_CS01 =Excel_data.get( "TotMoves");
		String Confirmed_Popup_CS01 =Excel_data.get( "Confirmed_Popup");
		String Call_Status_Exp_CS01 =Excel_data.get( "Call_Status_Exp");
		String Do_You_Want_Unconfirm_CS01 =Excel_data.get( "Do_You_Want_Unconfirm");
		String unConfirmButton_CS01 =Excel_data.get("Unconfirm_Button");
		String unConfirmPopup_CS01 =Excel_data.get("Unconfirm_Popup");
		String unConfirmed_CS01 =Excel_data.get("Unconfirmed");
		String date_Picker =Excel_data.get("date_Picker");
		String ExpectedBSOP =Excel_data.get("ExpectedBSOP");
		String ExpectedAp =Excel_data.get("ExpectedAp");
		String ExpectedAc =Excel_data.get("ExpectedAc");
		String ExpectedDA =Excel_data.get("ExpectedDA");
		String ExpectedD =Excel_data.get("ExpectedD");
		String PopUp_Continue =Excel_data.get("PopUp_Continue");

		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");


		//locatros		
		String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler, voyageNumber_CS01);
		String Port_Select1 =  String.format(Coastal_Schedule_Locators.Port_Select1, voyageNumber_CS01,portName_CS01);
		String confirm_Select = String.format(Coastal_Schedule_Locators.confirm_Select, confirmButton_CS01);
		String Radio_Button = String.format(Coastal_Schedule_Locators.Radio_Button, Radio_Button_CS01);	
		String unconfirm_Select = String.format(Coastal_Schedule_Locators.unconfirm_Select, unConfirmButton_CS01);
		String Status = String.format(Coastal_Schedule_Locators.status, voyageNumber_CS01,portName_CS01);

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);


		LRP_Login(driver, Username_CS01, Password_CS01);

		moduleNavigate(driver, ModuleSearch_CS01);


		Step_Start(1, "Enter the Service Code in the service code field", test, test1);

		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);

		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS01);


		Step_End(1, "Enter the Service Code in the service code field", test, test1);

		Step_Start(2, "Enter the Vessel ", test, test1);
		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS01);


		Step_End(2, "Enter the Vessel ", test, test1);

		Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, Tree_Structure);
		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

		Step_Start(4, "Choose the first voyage", test, test1);
		waitForElement(driver, Voyage_Toggler);
		String status = getAttribute(driver, Voyage_Toggler, "class");
		if(!status.contains("s")) {
			click(driver, Voyage_Toggler);
		}
		Step_End(4, "Choose the first voyage", test, test1);
		Step_Start(5, "Click on the port that has to be call confirmed", test, test1);
		waitForElement(driver, Port_Select1);
		click(driver, Port_Select1);	
		Step_End(5, "Click on the port that has to be call confirmed", test, test1);
		Step_Start(6,"Right Click on it ", test, test1);
		waitForElement(driver, Port_Select1);
		RightClick(driver, Port_Select1);
		Step_End(6,"Right Click on it ", test, test1);
		Step_Start(7, "Choose the Call Confirmation/Time Adjustment option from the menu", test, test1);
		waitForElement(driver, confirm_Select);
		click(driver, confirm_Select);
		Step_End(7, "Choose the Call Confirmation/Time Adjustment option from the menu", test, test1);
		Step_Start(8, "Adjust the Dates as per the requirement in under the tab of Call Confirm", test, test1);

		waitForElement(driver, Radio_Button);
		click(driver, Radio_Button);
		Step_Start(9, "The Order of Date as below EOSP<Arrival Pilot<ALL FAST/FWEALL FAST/FEW<All Cast off<Pilot Away<BOSP", test, test1);
		waitForElement(driver, EOSP_Date);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePickerWithTime_CS(driver, EOSP_Date, ESOPDate_CS01);
		} else {
			if(Pilot_CS01.contains("-")) {
				waitForElement(driver, EOSP_Date);
				clearAndType(driver, EOSP_Date, ESOPDate_CS01.replace("-", "/"));
			}else {
				waitForElement(driver, EOSP_Date);
				clearAndType(driver, EOSP_Date, ESOPDate_CS01);
			}
			waitForDisplay(driver, calender_close);
			if(isdisplayed(driver, calender_close)) {
				click(driver,calender_close);
			}
		}

		waitForElement(driver, Arrival_Port);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePickerWithTime_CS(driver, Arrival_Port, ArrPilot_CS01);
		} else {
			if(Pilot_CS01.contains("-")) {
				waitForElement(driver, Arrival_Port);
				clearAndType(driver, Arrival_Port, ArrPilot_CS01.replace("-", "/"));
			}else {
				waitForElement(driver, Arrival_Port);
				clearAndType(driver, Arrival_Port, ArrPilot_CS01);
			}
			waitForDisplay(driver, calender_close);
			if(isdisplayed(driver, calender_close)) {
				click(driver,calender_close);
			}
		}

		waitForElement(driver, ALL_FAST_FWE);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePickerWithTime_CS(driver, ALL_FAST_FWE, ALLFASTFEW_CS01);
		} else {
			if(Pilot_CS01.contains("-")) {
				waitForElement(driver, ALL_FAST_FWE);
				clearAndType(driver, ALL_FAST_FWE, ALLFASTFEW_CS01.replace("-", "/"));
			}else {
				waitForElement(driver, ALL_FAST_FWE);
				clearAndType(driver, ALL_FAST_FWE, ALLFASTFEW_CS01);
			}
			waitForDisplay(driver, calender_close);
			if(isdisplayed(driver, calender_close)) {
				click(driver,calender_close);
			}

		}

		waitForElement(driver, All_Cast_Off);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePickerWithTime_CS(driver, All_Cast_Off, AllCastOff_CS01);
		} else {
			if(Pilot_CS01.contains("-")) {
				waitForElement(driver, All_Cast_Off);
				clearAndType(driver, All_Cast_Off, AllCastOff_CS01.replace("-", "/"));
			}else {
				waitForElement(driver, All_Cast_Off);
				clearAndType(driver, All_Cast_Off, AllCastOff_CS01);
			}
			waitForDisplay(driver, calender_close);
			if(isdisplayed(driver, calender_close)) {
				click(driver,calender_close);
			}
		}


		waitForElement(driver, Pilot_Away);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePickerWithTime_CS(driver, Pilot_Away, Pilot_CS01);
		} else {
			if(Pilot_CS01.contains("-")) {
				waitForElement(driver, Pilot_Away);
				clearAndType(driver, Pilot_Away, Pilot_CS01.replace("-", "/"));
			}else {
				waitForElement(driver, Pilot_Away);
				clearAndType(driver, Pilot_Away, Pilot_CS01);
			}
			waitForDisplay(driver, calender_close);
			if(isdisplayed(driver, calender_close)) {
				click(driver,calender_close);
			}
		}



		waitForElement(driver, BOSP_Date);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePickerWithTime_CS(driver, BOSP_Date, BOSPDate_CS01);
		} else {
			if(Pilot_CS01.contains("-")) {
				waitForElement(driver, BOSP_Date);
				clearAndType(driver, BOSP_Date, BOSPDate_CS01.replace("-", "/"));
			}else {
				waitForElement(driver, Pilot_Away);
				clearAndType(driver, Pilot_Away, BOSPDate_CS01);
			}
			waitForDisplay(driver, calender_close);
			if(isdisplayed(driver, calender_close)) {
				click(driver,calender_close);
			}
		}

		waitForElement(driver,Not_Working_Hours);
		clearAndType(driver,Not_Working_Hours,NotWorking_Hours_CS01);

		waitForElement(driver,Total_Moves);
		clearAndType(driver, Total_Moves, TotalMoves_CS01);
		waitForElement(driver, Update_Coastal_Schedule);
		click(driver,Update_Coastal_Schedule);

		Step_End(8, "Adjust the Dates as per the requirement in under the tab of Call Confirm", test, test1);
		Step_Start(9, "The Order of Date as below EOSP<Arrival Pilot<ALL FAST/FWEALL FAST/FEW<All Cast off<Pilot Away<BOSP", test, test1);

		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			String continue_Msg = getText(driver, popup_Message);
			System.out.println(continue_Msg);
			if(continue_Msg.contains(PopUp_Continue)) {
				System.out.println("Matched || Expected If the not Working hours is 0 , system should ask for :"+PopUp_Continue+" || Actual Popup Message was : "+continue_Msg);
				Extent_pass_New(driver, "Matched || Expected If the not Working hours is 0 , system should ask for :"+PopUp_Continue+" || Actual Popup Message was : "+continue_Msg, test,test1);
			}
			Step_Start(10, "Click on “Yes” to proceed", test, test1);
			click(driver,popup_Message_Yes_Button);
			Step_End(10, "Click on “Yes” to proceed", test, test1);
		}
		Step_Start(11, "System should refresh the screen and the Port Call will be highlighted in green with thumbs up symbol before the port code identifying the call Is confirmed", test, test1);


		waitForPopup(driver, popup_Message, Confirmed_Popup_CS01);
		String ActualCA = getText(driver,popup_Message);
		System.out.println(Confirmed_Popup_CS01);
		System.out.println(ActualCA);
		if(ActualCA.equals(Confirmed_Popup_CS01)) {
			System.out.println("Matched || Expected Popup Message is : "+Confirmed_Popup_CS01+" || Actual Popup Message is : "+ActualCA);
			Extent_pass_New(driver, "Matched || Expected Popup Message is : "+Confirmed_Popup_CS01+" || Actual Popup Message is : "+ActualCA, test,test1);
			click(driver,popup_Message_Ok_Button);
			waitForElement(driver, Voyage_Toggler);
			String Toggler = getAttribute(driver, Voyage_Toggler, "class");
			if(!Toggler.contains("s")) {
				click(driver, Voyage_Toggler);
			}
			waitForElement(driver, Port_Select1);
			String call_Status = getAttribute(driver, Status, "class");
			if(call_Status.contains(Call_Status_Exp_CS01)) {
				Extent_pass_New(driver, "Matched || Expected : Dot Circle symbol should be changed to Green Thumbs Up Symbol || Actual :  Dot Circle symbol is changed to Green Thumbs Up Symbol", test,test1);
				System.out.println("Matched || Expected : Dot Circle symbol should be changed to Green Thumbs Up Symbol || Actual :  Dot Circle symbol is changed to Green Thumbs Up Symbol");
			}else {
				System.out.println("Not Matched || Expected : Dot Circle symbol should be changed to Green Thumbs Up Symbol || Actual :  Dot Circle symbol is not changed to Green Thumbs Up Symbol");
				Extent_fail(driver, "Not Matched || Expected : Dot Circle symbol should be changed to Green Thumbs Up Symbol || Actual :  Dot Circle symbol is not changed to Green Thumbs Up Symbol", test,test1);
			}
		}else if(ActualCA.equals(ExpectedD)) {
			System.out.println("Matched || Expected Popup Message is : "+ExpectedD+" || Actual Popup Message is : "+ActualCA);
			Extent_pass_New(driver, "Matched || Expected Popup Message is : "+ExpectedD+" || Actual Popup Message is : "+ActualCA, test,test1);
		}else if(ActualCA.equals(ExpectedDA)) {
			System.out.println("Matched || Expected Popup Message is : "+ExpectedDA+" || Actual Popup Message is : "+ActualCA);
			Extent_pass_New(driver, "Matched || Expected Popup Message is : "+ExpectedDA+" || Actual Popup Message is : "+ActualCA, test,test1);
		}else if(ActualCA.equals(ExpectedAc)) {
			System.out.println("Matched || Expected Popup Message is : "+ExpectedAc+" || Actual Popup Message is : "+ActualCA);
			Extent_pass_New(driver, "Matched || Expected Popup Message is : "+ExpectedAc+" || Actual Popup Message is : "+ActualCA, test,test1);
		}else if(ActualCA.equals(ExpectedAp)) {
			System.out.println("Matched || Expected Popup Message is : "+ExpectedAp+" || Actual Popup Message is : "+ActualCA);
			Extent_pass_New(driver, "Matched || Expected Popup Message is : "+ExpectedAp+" || Actual Popup Message is : "+ActualCA, test,test1);
		}else if(ActualCA.equals(ExpectedBSOP)) {
			System.out.println("Matched || Expected Popup Message is : "+ExpectedBSOP+" || Actual Popup Message is : "+ActualCA);
			Extent_pass_New(driver, "Matched || Expected Popup Message is : "+ExpectedBSOP+" || Actual Popup Message is : "+ActualCA, test,test1);
		}
		else {
			System.out.println("NotMatched || Expected Popup Message is : "+Confirmed_Popup_CS01+" || Actual Popup Message is : "+ActualCA);
			Extent_fail(driver,  "NotMatched || Expected Popup Message is : "+Confirmed_Popup_CS01+" || Actual Popup Message is : "+ActualCA, test,test1);
		}

		Step_End(11, "System should refresh the screen and the Port Call will be highlighted in green with thumbs up symbol before the port code identifying the call Is confirmed", test, test1);
		if(Do_You_Want_Unconfirm_CS01.equalsIgnoreCase("Yes")) {
			Extent_call(test, test1, " If you give Do You Want Unconfirm is Yes then It will be Unconfirm the call");
			waitForElement(driver, Port_Select1);
			click(driver, Port_Select1);	
			waitForElement(driver, Port_Select1);
			RightClick(driver, Port_Select1);
			waitForElement(driver, unconfirm_Select);
			click(driver, unconfirm_Select);

			waitForPopup(driver, popup_Message, unConfirmPopup_CS01);
			String Actual_popup= getText(driver,popup_Message);
			if(Actual_popup.equals(unConfirmPopup_CS01)) {
				System.out.println("Matched || Expected Popup Message is : "+unConfirmPopup_CS01+" || Actual Popup Message is : "+Actual_popup);
				Extent_pass_New(driver, "Matched || Expected Popup Message is : "+unConfirmPopup_CS01+" || Actual Popup Message is : "+Actual_popup, test,test1);
				click(driver,popup_Message_Yes_Button);
			}else {
				System.out.println("NotMatched || Expected Popup Message is : "+unConfirmPopup_CS01+" || Actual Popup Message is : "+Actual_popup);
				Extent_fail(driver,  "NotMatched || Expected Popup Message is : "+unConfirmPopup_CS01+" || Actual Popup Message is : "+Actual_popup, test,test1);
			}

			waitForPopup(driver, popup_Message, unConfirmed_CS01);
			String Popup_Text = getText(driver,popup_Message);
			if(Popup_Text.equals(unConfirmed_CS01)) {
				System.out.println("Matched || Expected Popup Message is : "+unConfirmed_CS01+" || Actual Popup Message is : "+Popup_Text);
				Extent_pass_New(driver, "Matched || Expected Popup Message is : "+unConfirmed_CS01+" || Actual Popup Message is : "+Popup_Text, test,test1);
				click(driver,popup_Message_Ok_Button);
			}else {
				System.out.println("NotMatched || Expected Popup Message is : "+unConfirmed_CS01+" || Actual Popup Message is : "+Popup_Text);
				Extent_fail(driver,  "NotMatched || Expected Popup Message is : "+unConfirmed_CS01+" || Actual Popup Message is : "+Popup_Text, test,test1);
			}
		}

		Extent_completed(testCaseName, test, test1);
	}
}