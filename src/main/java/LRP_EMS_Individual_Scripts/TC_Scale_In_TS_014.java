package LRP_EMS_Individual_Scripts;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Scale_In_Out_Reference;

public class TC_Scale_In_TS_014 extends Keywords {

	public void Scaleinonewayrecord(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		// Value are taken from excel sheet
		String testcase_Name = "TC_Scale_In_TS_014";
		
		


		String Username = Excel_data.get("Username");// 1,2,4-
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String contractnum = Excel_data.get("Contract_No");
		String scalerefno = Excel_data.get("Scale_Reference_no");
		String freedays = Excel_data.get("Free_Days");
		String perdiem = Excel_data.get("Per_Diem");
		String handelcharges = Excel_data.get("Handles_Charges");
		String equipmentque = Excel_data.get("equipment_Quantity");
		String pickupcredit = Excel_data.get("PickUp_Credit");
		String Pickupcharges = Excel_data.get("Scale_in_pickup_charges");
		String savedpopexp = Excel_data.get("PopUpforsaved");
		String todayenter = Excel_data.get("TODAYS");
		String secondtodayinput = Excel_data.get("secondtoday");
		String secondtodayinputdem = Excel_data.get("seconddiem");
		String Per_Diem_Slap = Excel_data.get("Per_Diem_Slap");
		String Coloum_names = Excel_data.get("Coloum_names");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Slab_CheckBox = Excel_data.get("Slab_CheckBox");
		String One_Way_CheckBox = Excel_data.get("One_Way_CheckBox");
		String Equipment_type_perform = Excel_data.get("Equipment_type_perform");
		String Reference_Type = Excel_data.get("Reference_Type");
		String From_date_perform = Excel_data.get("From_date_perform");
		String To_Date_perform = Excel_data.get("To_Date_perform");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String One_way_return_location = Excel_data.get("One_way_return_location");
		String Equipmenttype_Input = Excel_data.get("Equipmenttype_Input");
		String Add_location_port_perform = Excel_data.get("Add_location_port_perform");
		String Add_location_port_input = Excel_data.get("Add_location_port_input");
		String Contract_Number_Search = Excel_data.get("Contract_Number_Search");
		String Equipment_Type_Search = Excel_data.get("Equipment_Type_Search");
		String Location_Search = Excel_data.get("Location_Search");
		String Remarks_input = Excel_data.get("Remarks_input");
		String One_Way_Search = Excel_data.get("One_Way_Search");
		
		String Want_To_Delete = Excel_data.get("Want_To_Delete");

		
	
		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
		Extent_Start(testcase_Name, test, test1);
		
		
		
		navigateUrl(driver, url);

		
		// LOGIN
		LRP_Login(driver, Username, Password);
		
		
		moduleNavigate(driver, Search);
		

		waitForElement(driver, Reference_Type_Field);
		safeclick(driver, Reference_Type_Field);
			waitForElement(driver, ReferenceType_Select);
			safeclick(driver, ReferenceType_Select);
		
			Step_Start(1, "Select contract no by clicking search icon in contract no",test, test1);
		waitForElement(driver, AContract_no_input);
		waitForElement(driver, AContractNumsearch);
		safeclick(driver, AContractNumsearch);
		Step_End(1, "Select contract no by clicking search icon in contract no",test, test1);
		waitForElement(driver, Ainputcontractnum);
		twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
		
		
		
		waitForElement(driver, Slab_ChkBox);
		checkBox(driver, Slab_ChkBox, Slab_CheckBox);

		// OPTION OF SELECTING THE CHECK BOX
		waitForElement(driver, AslabboxADD);

				if (isElementAccessible(driver, AslabboxADD)) {
					waitForElement(driver, AslabboxADD);
					safeclick(driver, AslabboxADD);
				
					waitForElement(driver, AslabboxADDTodays);
					doubleClick(driver, AslabboxADDTodays);
					 
					Actionsendkeys(driver, AslabboxADDTodays, todayenter);
					 
					waitForElement(driver, AslabboxADDperdiem);
					 
					doubleClick(driver, AslabboxADDperdiem);
					Actionsendkeys(driver, APer_Diem_Input, Per_Diem_Slap);
					waitForElement(driver, AScale_in_pickup_charges);
					  
					safeclick(driver, AScale_in_pickup_charges);
					waitForElement(driver, AslabboxADD);
				
					safeclick(driver, AslabboxADD);
					
					waitForElement(driver, AslabboxADDperdiemsecond);
				
					doubleClick(driver, AslabboxADDperdiemsecond);
					Actionsendkeys(driver, AslabboxADDperdiemsecond, secondtodayinput);

					waitForElement(driver, AslabboxADDperdiemseconddiem);
					 
					doubleClick(driver, AslabboxADDperdiemseconddiem);
					Actionsendkeys(driver, AslabboxADDperdiemseconddiem, secondtodayinputdem);
					System.out.println("Expected Result is :Slab checkbox should be selected and filled with data || Actual Result is : Slab checkbox is selected and filled with data");
					Extent_pass_New(driver, "Expected Result is :Slab checkbox should be selected and filled with data || Actual Result is : Slab checkbox is selected and filled with data", test, test1);
				} else {
					System.out.println("Expected Result is :Slab checkbox should be selected and filled with data || Actual Result is : Slab checkbox is not selected and filled with data");
					Extent_fail(driver, "Expected Result is :Slab checkbox should be selected and filled with data || Actual Result is : Slab checkbox is not selected and filled with data", test, test1);
				}


		// Perdiem input
		if (!perdiem.equals("")) {

			waitForElement(driver, APer_Diem_Input);
			safeclick(driver, APer_Diem_Input);
			sendKeys(driver, APer_Diem_Input, perdiem);
		}
		// Free days input

		if (!freedays.equals("")) {
			waitForElement(driver, AFree_Days_Input);
			safeclick(driver, AFree_Days_Input);
			sendKeys(driver, AFree_Days_Input, freedays);
		}
		Step_Start(6, "Enter values for Scale-in pickup charges in numeric digit",test, test1);
		// scalein pickup charges input
		if (!Pickupcharges.equals("")) {
			waitForElement(driver, AScale_in_pickup_charges);
			sendKeys(driver, AScale_in_pickup_charges, Pickupcharges);
		}
		Step_End(6, "Enter values for Scale-in pickup charges in numeric digit",test, test1);
		// Handle charges input
		if (!handelcharges.equals("")) {
			waitForElement(driver, AHandling_Charges);
			sendKeys(driver, AHandling_Charges, handelcharges);
		}
		Step_Start(8, "Enter values for Equipment quantity in numeric digit",test, test1);
		// Equipment quantity input
		if (!equipmentque.equals("")) {
			waitForElement(driver, AEquipment_Quantaty);
			sendKeys(driver, AEquipment_Quantaty, equipmentque);
		}
		
		Step_Start(7, "Enter values for handling charges in numeric digit",test, test1);
		Step_End(8, "Enter values for Equipment quantity in numeric digit",test, test1);
		// pickup credit input
		if (!pickupcredit.equals("")) {
			waitForElement(driver, APick_Up_Credit);
			sendKeys(driver, APick_Up_Credit, pickupcredit);
		}
		Step_End(7, "Enter values for handling charges in numeric digit",test, test1);
		// Remarks input

		if (!Remarks_input.equals("")) {
			waitForElement(driver, ARemarks_Input);
			sendKeys(driver, ARemarks_Input, Remarks_input);
		}
		Step_Start(3, " Select From & To date with date picker correctly",test, test1);
		// Selecting the From Date
		waitForElement(driver, AFrom_Date);
		if (From_date_perform.equalsIgnoreCase("Yes")) {
			waitForElement(driver, AFrom_Date);
			selectDatePicker(driver, AFrom_Date, From_Date_Input);
		} else {
			waitForElement(driver, AFrom_Date);
			clearAndType(driver, AFrom_Date, From_Date_Input);
		}
		
				Step_End(3, "Select Validity From Date range accordingly in date picker ",test, test1);
				// Selecting the to Date
				Step_Start(4, "-Select Validity To Date range accordingly in date picker ",test, test1);
				waitForElement(driver, A_To_Date);
				if (To_Date_perform.equalsIgnoreCase("Yes")) {
					waitForElement(driver, A_To_Date);
					selectDatePicker(driver, A_To_Date, To_Date_Input);
				} else {
					waitForElement(driver, A_To_Date);
					clearAndType(driver, A_To_Date, To_Date_Input);
				}
				
						
						Step_Start(2, " Select One Way checkbox option",test, test1);
						Step_End(3, " Select From & To date with date picker correctly",test, test1);
		// selecting oneway check box

		waitForElement(driver, OneWay_ChkBox);

		checkBox(driver, OneWay_ChkBox, One_Way_CheckBox);
		if (One_Way_CheckBox.equals("YES")) {

			List<String> datas = splitAndExpand(One_way_return_location);
			for (String data1 : datas) {
				
				Step_Start(5, " click on return location add location",test, test1);
				waitForElement(driver, AAddreturnlocation);
				safeclick(driver, AAddreturnlocation);
				Step_End(5, " click on return location add location",test, test1);
				twoColumnSearchWindow(driver, One_Way_Search, Condition_Filter, data1);
					
				
			}
		} 
		Step_End(2, " Select One Way checkbox option",test, test1);
		Step_Start(4, " click on size type add button, location add button",test, test1);
		// Selecting the Equipment type

		if (Equipment_type_perform.equals("YES")) {

			List<String> datas = splitAndExpand(Equipmenttype_Input);
			for (String data1 : datas) {
				 
				waitForElement(driver, AEquipment_Type_add_button);
				safeclick(driver, AEquipment_Type_add_button);
				waitForElement(driver, equipmenttypevalueenter);
				twoColumnSearchWindow(driver, Equipment_Type_Search, Condition_Filter, data1);

			}
		} 

		// Selecting the location

		if (Add_location_port_perform.equals("YES")) {

			List<String> datas = splitAndExpand(Add_location_port_input);
			for (String data1 : datas) {
				 
				waitForElement(driver, ALocation_Add_Button);
				safeclick(driver, ALocation_Add_Button);
				twoColumnSearchWindow(driver, Location_Search, Condition_Filter, data1);
					

			}
		} 
		Step_End(4, " click on size type add button, location add button",test, test1);
		// Entering Scalin reference
		if (!scalerefno.equals("")) {
			waitForElement(driver, AScale_in_ref_input);
			safeclick(driver, AScale_in_ref_input);
			sendKeys(driver, AScale_in_ref_input, scalerefno);
			safeclick(driver, ARemarks_Input);
		}
		Step_Start(11, "Click add button once all required fields are entered",test, test1);
			// Adding the values into the grid

			waitForElement(driver, AGried_Add_Button);
			safeclick(driver, AGried_Add_Button);
			Step_End(11, "Click add button once all required fields are entered",test, test1);
			Step_Start(12, "Click save button & system should show save message as successfull and auto generate scale-in & scale-out ref",test, test1);
			// Saving the records

			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, Popup_Message, savedpopexp);
			String Actualpopmsg = getText(driver, Popup_Message);
			System.out.println(Actualpopmsg);
			
			waitForElement(driver, scaleout_input);
			String referenceout =getAttribute(driver, scaleout_input, "value");
			System.out.println(referenceout);
			// printing the scalein/out data
			
			
			waitForElement(driver, AScale_in_ref_input);
			String referencein =getAttribute(driver, AScale_in_ref_input, "value");
			System.out.println(referencein);
			Extent_call(test, test1,  "**Scalein_ref was generated as**"+ referencein);
		
			
			
			
			
			Extent_call(test, test1,  "**Scaleout_ref was generated as**"+ referenceout);

			// Verifying the validation of saved popup

			

			if (savedpopexp.equals(Actualpopmsg)) {
				System.out.println("Matched || " + " Expected Activity is : " + savedpopexp
						+ " || Actual Activity is : " + Actualpopmsg);
				Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + savedpopexp
						+ " || Actual Activity is : " + Actualpopmsg, test, test1);
			} else {
				System.out.println("Not matched || " + " Expected Activity is : " + savedpopexp
						+ " || Actual Activity is : " + Actualpopmsg);
				Extent_fail(driver, "Not matched || " + " Expected Activity is : " + savedpopexp
						+ " || Actual Activity is : " + Actualpopmsg, test, test1);
				
			}
			Step_End(12, "Click save button & system should show save message as successfull and auto generate scale-in & scale-out ref",test, test1);
			scrollUsingElement(driver, AGried_Add_Button);

			Map<String, List<String>> table_view = extractTableDataDirect(driver, table_Path);
			List<String> coloumhearders = splitAndExpand1(Coloum_names);
			
			String table_value = printTable(driver, table_view, coloumhearders);
			Extent_pass_New(driver, "<pre>"+table_value+"</pre>", test, test1);
			String Location1 = getText(driver, AINNSA);
			System.out.println(Location1);
			Extent_pass_New(driver, "Location shown as" + "****" + Location1, test, test1);

			String equetype = getText(driver, Equipmenttype);
			System.out.println(equetype);
			Extent_pass_New(driver, "equipmentquantity shown as" + "****" + equetype, test, test1);
			String equeque = getText(driver, Equipmentquenty);
			System.out.println(equeque);
			Extent_pass_New(driver, "equipmenttime shown as " + "****" + equeque, test, test1);

			Set<String> arrset1 = new HashSet<String>();
			arrset1.add(equeque);
			arrset1.add(equetype);
			arrset1.add(Location1);

			System.out.println("First Set: " + arrset1);

			if (isDisplayed(driver, AINNSA)) {
				System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is  shown in grid");
				Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is  shown in grid", test, test1);
				waitForDisplay(driver, Scroll_side);
				if (isdisplayed(driver, Scroll_side)) {
					horizontalscroll(driver, Scroll_side, 1000);
					Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is  shown in grid", test, test1);	
					
				}
			
			} else {
				System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
				Extent_fail(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid", test, test1);
				
			}
			
			if(Want_To_Delete.equalsIgnoreCase("Yes")) {

			scrollTop(driver);

			// Deleting the records

			waitForElement(driver, Delete_button_toolBar);
			safeclick(driver, Delete_button_toolBar);

			waitForElement(driver, popup_Message_Yes_Button);
			safeclick(driver, popup_Message_Yes_Button);
			
		    waitForElement(driver, Popup_Message);

			Extent_completed(testcase_Name, test, test1);
			}
		}

	}

