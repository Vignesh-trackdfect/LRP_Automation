package LRP_VSS_Consolidation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.Coastal_Schedule_Locators;

public class TC_CoastalSchedule_CS1ToCS3 extends Keywords {
	  public static String voyageNumber_CS01;
      public static String portName_CS01;
      public static String unConfirmButton_CS01;
      public static String Radio_Button_CS01;
      public static String confirmButton_CS01;
      public static String VesselCode_CS01;
      public static String ServiceCode_CS01;
      
      //
      public static String ServiceCode_CS02;
      public static String VesselCode_CS02;
      public static String voyageNumber_CS02;
      public static String portName_CS02;
      public static String Move_Button;
      
      //
      public static String ServiceCode_CS03;
      public static String Bound_Input;
      public static String VesselCode_CS03;
      public static String  voyageNumber_CS03;
      public static String  add_Button_CS03;
      public static String portName_CS03;
      public static String RollBack_Port;
      
	public void CoastalSchedule1To3V(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset) {
		
		int a=1;
		
		if(a==1) {
			String testCaseName="TC_Coastal_Schedule_CS01";
			String File_Path_CS01 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_CS01 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
			String url = TestNgXml.getdatafromExecution().get(testCaseName);
			Map<String, String> Excel_data_01 = Utils.GetAllData(Sheet_Name_CS01, testCaseName, "Dataset"+selected_dataset, File_Path_CS01);
			String Username_CS01 =Excel_data_01.get("Username");
			String Password_CS01 =Excel_data_01.get("Password");
			String ModuleSearch_CS01 =Excel_data_01.get("Module_Search");
			String ServiceCode_CS01 =Excel_data_01.get("Service_Code");
			String VesselCode_CS01 =Excel_data_01.get("Vessel_Code");
			String voyageNumber_CS01 =Excel_data_01.get("Voyage_Number");
			String portName_CS01 =Excel_data_01.get("Port_Name");
			String Radio_Button_CS01 =Excel_data_01.get("Radio_Button");
			String ESOPDate_CS01 =Excel_data_01.get("EOSP");
			String confirmButton_CS01 =Excel_data_01.get("confirmButton");
			String ArrPilot_CS01 =Excel_data_01.get( "ArrivalPilot");
			String ALLFASTFEW_CS01 =Excel_data_01.get( "ALLFAST_FEW");
			String AllCastOff_CS01 =Excel_data_01.get( "AllCast_Off");
			String Pilot_CS01 =Excel_data_01.get("PilotAway") ;
			String BOSPDate_CS01 =Excel_data_01.get( "BOSP");
			String NotWorking_Hours_CS01 =Excel_data_01.get("Not_Working");
			String TotalMoves_CS01 =Excel_data_01.get( "TotMoves");
			String Confirmed_Popup_CS01 =Excel_data_01.get( "Confirmed_Popup");
			String Call_Status_Exp_CS01 =Excel_data_01.get( "Call_Status_Exp");
			String Do_You_Want_Unconfirm_CS01 =Excel_data_01.get( "Do_You_Want_Unconfirm");
			String unConfirmButton_CS01 =Excel_data_01.get("Unconfirm_Button");
			String unConfirmPopup_CS01 =Excel_data_01.get("Unconfirm_Popup");
			String unConfirmed_CS01 =Excel_data_01.get("Unconfirmed");
			String date_Picker =Excel_data_01.get("date_Picker");
			String ExpectedBSOP =Excel_data_01.get("ExpectedBSOP");
			String ExpectedAp =Excel_data_01.get("ExpectedAp");
			String ExpectedAc =Excel_data_01.get("ExpectedAc");
			String ExpectedDA =Excel_data_01.get("ExpectedDA");
			String ExpectedD =Excel_data_01.get("ExpectedD");
			String PopUp_Continue =Excel_data_01.get("PopUp_Continue");

			String condition = Excel_data_01.get("Condition");
			String service_Search_Header = Excel_data_01.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data_01.get("Vessel_Search_Header");

			
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
				selectDatePickerWithTime(driver, EOSP_Date, ESOPDate_CS01);
				
				
			} else {
				waitForElement(driver, EOSP_Date);
				clearAndType(driver, EOSP_Date, ESOPDate_CS01);
				
				waitForElement(driver, calender_close);
				click(driver,calender_close);

			}

			
			waitForElement(driver, Arrival_Port);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, Arrival_Port, ArrPilot_CS01);

				
			} else {
				waitForElement(driver, Arrival_Port);
				clearAndType(driver, Arrival_Port, ArrPilot_CS01);
				waitForElement(driver, calender_close);
				click(driver,calender_close);
			}

		
			
			waitForElement(driver, ALL_FAST_FWE);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, ALL_FAST_FWE, ALLFASTFEW_CS01);

				
			} else {
				waitForElement(driver, ALL_FAST_FWE);
				clearAndType(driver, ALL_FAST_FWE, ALLFASTFEW_CS01);
				
				waitForElement(driver, calender_close);
				click(driver,calender_close);
				
			}

			waitForElement(driver, All_Cast_Off);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, All_Cast_Off, AllCastOff_CS01);

				
			} else {
				waitForElement(driver, All_Cast_Off);
				clearAndType(driver, All_Cast_Off, AllCastOff_CS01);
				waitForElement(driver, calender_close);
				click(driver,calender_close);
				
			}

			
			waitForElement(driver, Pilot_Away);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, Pilot_Away, Pilot_CS01);
				
				
			} else {
				waitForElement(driver, Pilot_Away);
				clearAndType(driver, Pilot_Away, Pilot_CS01);
				
				waitForElement(driver, calender_close);
				click(driver,calender_close);
			}
			
		
			
			waitForElement(driver, BOSP_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, BOSP_Date, BOSPDate_CS01);

				
			} else {
				waitForElement(driver, BOSP_Date);
				clearAndType(driver, BOSP_Date, BOSPDate_CS01);
				
				waitForElement(driver, calender_close);
				click(driver,calender_close); 

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
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		
		}		
		int b=2;
		
		if(b==2) {
			String testCaseName="TC_Coastal_Schedule_CS02";
			String File_Path_CS02 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_CS02 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
			Map<String, String> Excel_data_02 = Utils.GetAllData(Sheet_Name_CS02, testCaseName, "Dataset"+selected_dataset, File_Path_CS02);
			String Popforupdate = Excel_data_02.get( "PopForUpdated");
			String ModuleSearch_CS02 =Excel_data_02.get("Module_Search");
			String ServiceCode_CS02 =Excel_data_02.get("Service_Code");
			String VesselCode_CS02 =Excel_data_02.get("Vessel_Code");
			String voyageNumber_CS02 =Excel_data_02.get("Voyage_Number");
			String portName_CS02 =Excel_data_02.get("Port_Name");
			String date_Picker= Excel_data_02.get("date_Picker");
			String Select_Columns = Excel_data_02.get("Select_Columns");
			String Future_Voyage = Excel_data_02.get("Future_Voyage");
			String Current_Voyage = Excel_data_02.get("Current_Voyage");
			String Move_Button = Excel_data_02.get("Move_Button");
			String Move_Button_option = Excel_data_02.get("Move_Button_option");
			String arr_Dock_Date = Excel_data_02.get("arr_Dock_Date");
			String Dept_Dock_Date = Excel_data_02.get("Dept_Dock_Date");
			String Dept_PilotDate = Excel_data_02.get("Dept_PilotDate");
			String arrPilotDate = Excel_data_02.get("ArrPilotDate");

			String condition = Excel_data_02.get("Condition");
			String service_Search_Header = Excel_data_02.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data_02.get("Vessel_Search_Header");
			String table_Name = Excel_data_02.get("Table_Name");
			String RightClick_Perform = Excel_data_02.get("RightClick_Perform");
			String RightClickOptions = Excel_data_02.get("RightClickOptions");



			String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler, voyageNumber_CS02);



			Extent_Start(testCaseName, test, test1);


			moduleNavigate(driver, ModuleSearch_CS02);

			Step_Start(1, "Enter the Service Code in the service code field", test, test1);

			waitForElement(driver, Service_Search_Btn);
			click(driver, Service_Search_Btn);

			twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS02);

			Step_End(1, "Enter the Service Code in the service code field", test, test1);

			Step_Start(2, "Enter the Vessel ", test, test1);

			waitForElement(driver, Vessel_Search_Btn);
			click(driver, Vessel_Search_Btn);

			twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS02);


			Step_End(2, "Enter the Vessel ", test, test1);

			Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			waitForElement(driver, Tree_Structure);
			Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
			waitForElement(driver, Voyage_Toggler);
			String status = getAttribute(driver, Voyage_Toggler, "class");
			if(!status.contains("s")) {
				waitForElement(driver, Voyage_Toggler);
				click(driver, Voyage_Toggler);
			}
			formatLocatorClick(driver, VoyageFirstPortValue, voyageNumber_CS02);
			waitForElement(driver, AG_Grid_First_Port);
			doubleClick(driver, AG_Grid_First_Port);


			if(Future_Voyage.equalsIgnoreCase("Yes")) {
				waitForElement(driver, FutureVoyage_TimeAdjust);
				click(driver, FutureVoyage_TimeAdjust);
			}else if(Current_Voyage.equalsIgnoreCase("Yes")) {
				waitForElement(driver, CurrentVoyage_TimeAdjust);
				click(driver, CurrentVoyage_TimeAdjust);
			}else {
				waitForElement(driver, currentRow_TimeAdjust);
				click(driver, currentRow_TimeAdjust);
			}
			waitForDisplay(driver, VoyageDetails_Temp_Remove);
			if(isdisplayed(driver, VoyageDetails_Temp_Remove)){
				waitForElement(driver, VoyageDetails_Temp_Remove);
				click(driver, VoyageDetails_Temp_Remove);
			}

			reArrangeAG_GridColumns_VoyageWindow(driver, Select_Columns);
			List<String> columns = splitAndExpand(Select_Columns);


			waitForElement(driver, edit_Grid_Total_Records);
			String getTotalRecords=getText(driver, edit_Grid_Total_Records);
			int row_Count=Integer.parseInt(getTotalRecords);
			List<String> portNames = splitAndExpand(portName_CS02, ",");
			List<String> arrPilotDates = splitAndExpand(arrPilotDate, ",");
			List<String> arr_Dock_Dates = splitAndExpand(arr_Dock_Date, ",");
			List<String> Dept_Dock_Dates = splitAndExpand(Dept_Dock_Date, ",");
			List<String> Dept_PilotDates = splitAndExpand(Dept_PilotDate, ",");

			for(int i = 0; i<portNames.size();i++) {
				List<Map<String, String>> voyage_Details_Before = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
				String voyage_Details_before=TableDataForReport(driver, voyage_Details_Before, table_Name, columns);
				String PortArrPilotDate =  String.format(Coastal_Schedule_Locators.PortArrPilotDate, portNames.get(i));
				String arrival_Dock_Date =  String.format(Coastal_Schedule_Locators.arrival_Dock_Date,portNames.get(i) );
				String Departur_Dock_Date =  String.format(Coastal_Schedule_Locators.Departur_Dock_Date, portNames.get(i));
				String Departur_Pilot_Date =  String.format(Coastal_Schedule_Locators.Departur_Pilot_Date, portNames.get(i));


				waitForElement(driver, PortArrPilotDate);
				doubleClick(driver, PortArrPilotDate);

				if (date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePickerWithTime_CS(driver, PortArrPilotDate, arrPilotDates.get(i));
				} else {
					waitForElement(driver, PortArrPilotDate);
					clearAndType(driver, PortArrPilotDate, arrPilotDates.get(i));
					waitForDisplay(driver, calender_close);
					click(driver,calender_close);
				}
				waitForElement(driver, port_Click);
				click(driver, port_Click);
				waitForElement(driver, arrival_Dock_Date);
				doubleClick(driver, arrival_Dock_Date);
				if (date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePickerWithTime_CS(driver, arrival_Dock_Date, arr_Dock_Dates.get(i));
				} else {
					waitForElement(driver, arrival_Dock_Date);
					clearAndType(driver, arrival_Dock_Date, arr_Dock_Dates.get(i));
					waitForDisplay(driver, calender_close);
					click(driver,calender_close);
				}
				formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
				waitForElement(driver, Departur_Dock_Date);
				doubleClick(driver, Departur_Dock_Date);
				if (date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePickerWithTime_CS(driver, Departur_Dock_Date, Dept_Dock_Dates.get(i));
				} else {
					waitForElement(driver, Departur_Dock_Date);
					clearAndType(driver, Departur_Dock_Date, Dept_Dock_Dates.get(i));
					waitForDisplay(driver, calender_close);
					click(driver,calender_close);
				}
				formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
				waitForElement(driver, Departur_Pilot_Date);
				doubleClick(driver, Departur_Pilot_Date);
				if (date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePickerWithTime_CS(driver, Departur_Pilot_Date, Dept_PilotDates.get(i));
				} else {
					waitForElement(driver, Departur_Pilot_Date);
					clearAndType(driver, Departur_Pilot_Date, Dept_PilotDates.get(i));
					waitForDisplay(driver, calender_close);
					click(driver,calender_close);
				}
				formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
				waitForElement(driver, Voyage_Details_Table);
				List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
				String voyage_Details_after=TableDataForReport(driver, voyage_Details_After, table_Name, columns);
				if (!voyage_Details_Before.equals(voyage_Details_After)) {
					Extent_pass_New(driver, " Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
				} else {
					Extent_fail(driver,
							" Not Matched || Before Table Value : \n"+"<pre>" + voyage_Details_before + "</pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
				}
			}
			boolean temp=true;
			List<String> Options = splitAndExpand(RightClickOptions, ",");
			List<String> RightClick_Performs = splitAndExpand(RightClick_Perform, ",");
			List<String> Move_Button_options = splitAndExpand(Move_Button_option, ",");
			List<String> Move_Buttons = splitAndExpand(Move_Button, ",");
			for(int i = 0; i<portNames.size();i++) {
				List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
				String voyage_Details_after=TableDataForReport(driver, voyage_Details_After, table_Name, columns);
				if(Move_Button_options.get(i).equalsIgnoreCase("Yes")&& !Move_Buttons.get(i).equals("")) {
					formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
					String Move =  String.format(Coastal_Schedule_Locators.Move, Move_Buttons.get(i));
					waitForElement(driver, Move);
					click(driver, Move);
					waitForElement(driver, Voyage_Details_Table);
					List<Map<String, String>> voyage_Details_After_Move_Table_Value = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
					String voyage_Details_after_move_Table_Value=TableDataForReport(driver, voyage_Details_After_Move_Table_Value, table_Name, columns);
					if (!voyage_Details_After.equals(voyage_Details_After_Move_Table_Value)) {
						Extent_pass_New(driver, " Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>\n"+"After move Table Value: \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after_move_Table_Value + "</div></pre>", test,test1);
					} else {
						Extent_fail(driver," Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>\n"+"After move Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after_move_Table_Value + "</div></pre>", test,test1);
					}

				}else {
					if(Options.get(i).equalsIgnoreCase("Remove/Omit")&&RightClick_Performs.get(i).equalsIgnoreCase("Yes")) {
						formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
						formatRightClick(driver, Voyage_Details_PortName, portNames.get(i));
						formatLocatorClick(driver, Voyage_Details_RightClickOptions, Options.get(i));
						temp=false;
						waitForElement(driver, Voyage_Details_Table);
						List<Map<String, String>> voyage_Details_After_Move_Table_Value = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
						String voyage_Details_after_move_Table_Value=TableDataForReport(driver, voyage_Details_After_Move_Table_Value, table_Name, columns);
						if (!voyage_Details_After.equals(voyage_Details_After_Move_Table_Value)) {
							Extent_pass_New(driver, " Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>\n"+"After move Table Value: \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after_move_Table_Value + "</div></pre>", test,test1);
						} else {
							Extent_fail(driver," Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>\n"+"After move Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after_move_Table_Value + "</div></pre>", test,test1);
						}
					}
					if(!Options.get(i).equalsIgnoreCase("Remove/Omit")&&temp&&RightClick_Performs.get(i).equalsIgnoreCase("Yes")) {
						formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
						formatRightClick(driver, Voyage_Details_PortName, portNames.get(i));
						formatLocatorClick(driver, Voyage_Details_RightClickOptions, Options.get(i));
					}
				}
			}
			waitForElement(driver, Movetocoastal);
			click(driver, Movetocoastal);

			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}

			waitForPopup(driver, popup_Message, Popforupdate);
			String Pop = getText(driver, popup_Message);
			System.out.println(Pop);
			if (Popforupdate.equals(Pop)) {
				System.out.println("Matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop);
				Extent_pass_New(driver,"Matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop,test,test1);
			} else {
				System.out.println("Not matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop);
				Extent_fail(driver,"Not matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop,test,test1);
			}
			click(driver, popup_Message_Ok_Button);
			Extent_completed(testCaseName, test, test1);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		
		int c=3;
		if(c==3) {
			String testCaseName="TC_Coastal_Schedule_CS03";
			String File_Path_CS03 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_CS03 = TestNgXml.getsheetName_FromExecution().get(testCaseName);

			Map<String, String> Excel_data_03 = Utils.GetAllData(Sheet_Name_CS03, testCaseName, "Dataset"+selected_dataset, File_Path_CS03);
			String ExpectedCA =Excel_data_03.get("ExpectedCA");
			String ExpectedCS =Excel_data_03.get("ExpectedCS"); 
			String Term_Time =Excel_data_03.get("TerminalTime");
			String Bound_Input =Excel_data_03.get("Bound_Input");
			String DistNPort= Excel_data_03.get("Distance_Next_port");
			String SpNport= Excel_data_03.get("Speed_Next_port");
			String BuffTime= Excel_data_03.get("Buffer_Time");
			String ManTI= Excel_data_03.get("Man_TimeIn");
			String ManOUT= Excel_data_03.get("Man_TimeOut");
			String TimeZ= Excel_data_03.get("Time_Zone");
			String dist_Pre_Port= Excel_data_03.get("Distance_Pre_Port");
			String speed_Pre_port= Excel_data_03.get("Speed_Pre_port");
			String ModuleSearch_CS03 =Excel_data_03.get("Module_Search");
			String ServiceCode_CS03 =Excel_data_03.get("Service_Code");
			String VesselCode_CS03 =Excel_data_03.get("Vessel_Code");
			String voyageNumber_CS03 =Excel_data_03.get("Voyage_Number");
			String add_Button_CS03 =Excel_data_03.get("Add_Button");
			String portName_CS03 =Excel_data_03.get("Port_Name");
			String Add_portName= Excel_data_03.get("Add_portName");
			String RollBack_CS03= Excel_data_03.get("RollBack");
			String RollBack_Port= Excel_data_03.get("RollBack_Port");

			String condition = Excel_data_03.get("Condition");
			String service_Search_Header = Excel_data_03.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data_03.get("Vessel_Search_Header");
			
			String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler, voyageNumber_CS03);
			String Port_Select1 =  String.format(Coastal_Schedule_Locators.Port_Select1, voyageNumber_CS03,portName_CS03);
			String Add_Select =  String.format(Coastal_Schedule_Locators.Add_Select, add_Button_CS03);
			String subBound_Select =  String.format(Coastal_Schedule_Locators.subBound_Select, Bound_Input);
			String Select =  String.format(Coastal_Schedule_Locators.Select, RollBack_Port);

			Extent_Start(testCaseName, test, test1);
			

			
			moduleNavigate(driver, ModuleSearch_CS03);
			
			Step_Start(1, "Enter the Service Code in the service code field", test, test1);

			waitForElement(driver, Service_Search_Btn);
			click(driver, Service_Search_Btn);
			
			twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS03);
			
			Step_End(1, "Enter the Service Code in the service code field", test, test1);

			Step_Start(2, "Enter the Vessel ", test, test1);

			waitForElement(driver, Vessel_Search_Btn);
			click(driver, Vessel_Search_Btn);

			twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS03);


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
			Step_Start(5, "click on the port that has to be call confirmed", test, test1);

			waitForElement(driver, Port_Select1);
			click(driver, Port_Select1);	
			Step_End(5, "click on the port that has to be call confirmed", test, test1);
			Step_Start(6,"Right click on it ", test, test1);

			waitForElement(driver, Port_Select1);
			RightClick(driver, Port_Select1);
			Step_End(6,"Right click on it ", test, test1);
			Step_Start(7, "Choose Add Port Option", test, test1);
			waitForElement(driver, Add_Select);
			click(driver, Add_Select);

			Step_End(7, "Choose Add Port Option", test, test1);
			Step_Start(8, "Add port Window appears", test, test1);
			
			waitForDisplay(driver, Add_PortP);
			if(isdisplayed(driver,Add_PortP)) {
				Extent_pass_New(driver, "Passed || Expected : Add Port Details window should be Displayed || Actual : Add Port Details window is Displayed", test, test1);
				System.out.println("Passed || Expected : Add Port Details window should be Displayed || Actual : Add Port Details window is Displayed");
			}else {
				System.out.println("Failed || Expected : Add Port Details window should be Displayed || Actual : Add Port Details window is not Displayed");

				Extent_fail(driver, "Failed || Expected : Add Port Details window should be Displayed || Actual : Add Port Details window is not Displayed", test, test1);
			}
			
			Step_End(8, "Add port Window appears", test, test1);
			Step_Start(9, "Enter the port to be added in the Port Code field", test, test1);

			Actions action = new Actions(driver);
			waitForElement(driver,Port_CodeI);
			click(driver,Port_CodeI);
			sendKeys(driver, Port_CodeI, Add_portName);
			click(driver,Port_CodeSel);
			
			Step_End(9, "Enter the port to be added in the Port Code field", test, test1);
			Step_Start(10, "System should auto capture the Distance from Previous port and Distance from Next port values based on the Adding port(S) Previous port and Next port in the voyage ", test, test1);
			Step_Start(11, "IF the Distance is not presented in the system enter the distance in the fields manually", test, test1);

			waitForElement(driver, distance_PrevoiusPort_CS);
			if(isElementAccessible(driver, distance_PrevoiusPort_CS)) {
				waitForElement(driver,distance_PrevoiusPort_CS);
				click(driver,distance_PrevoiusPort_CS); 
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(dist_Pre_Port).perform();
			}
			waitForElement(driver,Distance_NextPort);
			click(driver,Distance_NextPort);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(DistNPort).perform();
			Step_End(10, "System should auto capture the Distance from Previous port and Distance from Next port values based on the Adding port(S) Previous port and Next port in the voyage ", test, test1);
			Step_End(11, "IF the Distance is not presented in the system enter the distance in the fields manually", test, test1);

			Step_Start(12, "Enter the Speed from previous port and Speed to NExt port field values", test, test1);
			waitForElement(driver,Speed_NextPort);
			click(driver,Speed_NextPort);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(SpNport).perform();
			waitForElement(driver, speed_PreviousPort_CS);
			if(isElementAccessible(driver, speed_PreviousPort_CS)) {
				waitForElement(driver,speed_PreviousPort_CS);
				click(driver,speed_PreviousPort_CS);
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(speed_Pre_port).perform();
			}
			Step_End(12, "Enter the Speed from previous port and Speed to NExt port field values", test, test1);
			Step_Start(13, "Enter the bound values ", test, test1);
			waitForElement(driver,Sub_BoundD);
			click(driver,Sub_BoundD);
			waitForElement(driver,subBound_Select);
			click(driver, subBound_Select);
			Step_End(13, "Enter the bound values ", test, test1);
			Step_Start(14, "Enter the Buffer Time ", test, test1);
			waitForElement(driver,Buff_Time);
			click(driver,Buff_Time);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(BuffTime).perform();
			Step_End(14, "Enter the Buffer Time ", test, test1);

			Step_Start(15, "Enter the Man Time in ", test, test1);

			waitForElement(driver,Man_TimeInP);;
			click(driver,Man_TimeInP);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(ManTI).perform();
			Step_End(15, "Enter the Man Time in ", test, test1);
			Step_Start(16, "Enter the Man Time out ", test, test1);


			waitForElement(driver,Man_TimeoutP);
			click(driver,Man_TimeoutP);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(ManOUT).perform();
			Step_Start(17, "Enter the Man Time out ", test, test1);


			waitForElement(driver,Time_ZoneAp);
			click(driver,Time_ZoneAp);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(TimeZ).perform();

			waitForElement(driver,Terminal_TimeAP);
			click(driver,Terminal_TimeAP);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(Term_Time).perform();



			waitForElement(driver, Coastal_Schedulebtn);
			click(driver,Coastal_Schedulebtn);

			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)){
			waitForPopup(driver, popup_Message, ExpectedCS);

				String ActualText = getText(driver,popup_Message);
				if(ExpectedCS.equals(ActualText)) {
					System.out.println("Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText);
					Extent_pass_New(driver, "Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText, test,test1);
				}else {
					System.out.println("NotMatched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText);
					Extent_fail(driver,  "NotMatched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText, test,test1);
				}
				click(driver,popup_Message_Yes_Button);
			}
			

			
			waitForPopup(driver, popup_Message, ExpectedCA);
				String ActualCA = getText(driver,popup_Message);
				System.out.println(ExpectedCA);
				System.out.println(ActualCA);
				if(ExpectedCA.equals(ActualCA)) {
					System.out.println("Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
					Extent_pass_New(driver, "Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
				}else {
					System.out.println("NotMatched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
					Extent_fail(driver,  "NotMatched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
				}
				click(driver,popup_Message_Ok_Button);


			if(RollBack_CS03.equalsIgnoreCase("Yes")) {
				Step_Start(17, "If the user want to add a already permanently deleted call from the same voyage", test, test1);

				waitForElement(driver, Tree_Structure);
				waitForElement(driver, Voyage_Toggler);
				String status1 = getAttribute(driver, Voyage_Toggler, "class");
				if(!status1.contains("s")) {
					click(driver, Voyage_Toggler);
				}
				waitForElement(driver, Port_Select1);
				click(driver, Port_Select1);	
				waitForElement(driver, Port_Select1);
				RightClick(driver, Port_Select1);

				waitForElement(driver, Add_Select);
				click(driver, Add_Select);
				waitForDisplay(driver, Add_PortP);

				waitForElement(driver, Select);
				click(driver, Select);

				waitForElement(driver, Roll_Back_Btn);
				click(driver, Roll_Back_Btn);


				if(isElementAccessible(driver, distance_PrevoiusPort_CS)) {
					waitForElement(driver,distance_PrevoiusPort_CS);
					click(driver,distance_PrevoiusPort_CS);
					action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
					action.sendKeys(dist_Pre_Port).perform();
				}
				waitForElement(driver,Distance_NextPort);
				click(driver,Distance_NextPort);
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(DistNPort).perform();
				waitForElement(driver,Speed_NextPort);
				click(driver,Speed_NextPort);
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(SpNport).perform();
				if(isElementAccessible(driver, speed_PreviousPort_CS)) {
					waitForElement(driver,speed_PreviousPort_CS);
					click(driver,speed_PreviousPort_CS);
					action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
					action.sendKeys(speed_Pre_port).perform();
				}
				waitForElement(driver,Buff_Time);
				click(driver,Buff_Time);
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(BuffTime).perform();


				waitForElement(driver,Man_TimeInP);;
				click(driver,Man_TimeInP);
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(ManTI).perform();


				waitForElement(driver,Man_TimeoutP);
				click(driver,Man_TimeoutP);
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(ManOUT).perform();


				waitForElement(driver,Time_ZoneAp);
				click(driver,Time_ZoneAp);
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(TimeZ).perform();

				waitForElement(driver,Terminal_TimeAP);
				click(driver,Terminal_TimeAP);
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(Term_Time).perform();
				waitForElement(driver, Coastal_Schedulebtn);
				click(driver,Coastal_Schedulebtn);

				waitForPopup(driver, popup_Message, ExpectedCS);
					 String ActualText = getText(driver,popup_Message);
					if(ExpectedCS.equals(ActualText)) {
						System.out.println("Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText);
						Extent_pass_New(driver, "Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText, test,test1);
					}else {
						System.out.println("NotMatched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText);
						Extent_fail(driver,  "NotMatched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText, test,test1);
					}		
					
					click(driver,popup_Message_Yes_Button);

				


				waitForPopup(driver, popup_Message, ExpectedCA);
					 ActualCA = getText(driver,popup_Message);
					System.out.println(ExpectedCA);
					System.out.println(ActualCA);
					if(ExpectedCA.equals(ActualCA)) {
						System.out.println("Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
						Extent_pass_New(driver, "Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
					}else {
						System.out.println("NotMatched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
						Extent_fail(driver,  "NotMatched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
					}
					click(driver,popup_Message_Ok_Button);

				Step_End(17, "If the user want to add a already permanently deleted call from the same voyage", test, test1);
			}
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			Extent_completed(testCaseName, test, test1);
			
		}
	}

}
