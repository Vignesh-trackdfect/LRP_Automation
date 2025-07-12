package LRP_EMS_Individual_Scripts;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Scale_In_Out_Reference;

public class TC_Scale_In_TS_010 extends Keywords {

	public void Scaleoutrecord(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Scale_In_TS_010";
		
		


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
		String To_Date_perform = Excel_data.get("To_Date_perform");
		String From_date_perform = Excel_data.get("From_date_perform");
		String Slab_CheckBox = Excel_data.get("Slab_CheckBox");
		String Per_Diem_Slap = Excel_data.get("Per_Diem_Slap");
		String Equipment_type_perform = Excel_data.get("Equipment_type_perform");
		String Reference_Type = Excel_data.get("Reference_Type");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String Equipmenttype_Input = Excel_data.get("Equipmenttype_Input");
		String Add_location_port_perform = Excel_data.get("Add_location_port_perform");
		String Add_location_port_input = Excel_data.get("Add_location_port_input");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Remarks_input = Excel_data.get("Remarks_input");
		String Coloum_names = Excel_data.get("Coloum_names");
		String Contract_Number_Search = Excel_data.get("Contract_Number_Search");
		String Equipment_Type_Search = Excel_data.get("Equipment_Type_Search");
		String Location_Search = Excel_data.get("Location_Search");
		String Want_To_Delete = Excel_data.get("Want_To_Delete");

		Extent_Start(testcase_Name, test, test1);
		
		
		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 

		navigateUrl(driver, url);

	
// LOGIN
		LRP_Login(driver, Username, Password);
		moduleNavigate(driver, Search);

	
		Step_Start(1, " Click on Reference Type drop menu & select scale-out option",test, test1);
		waitForElement(driver, Reference_Type_Field);
		safeclick(driver, Reference_Type_Field);
			waitForElement(driver, ReferenceType_Select);
			safeclick(driver, ReferenceType_Select);
			Step_End(1, " Click on Reference Type drop menu & select scale-out option",test, test1);
			Step_Start(3, "Click search icon for Contract No then select required contract",test, test1);
		waitForElement(driver, AContract_no_input);
		waitForElement(driver, AContractNumsearch);
		safeclick(driver, AContractNumsearch);
		waitForElement(driver, Ainputcontractnum);
		twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
		
		  
		Step_End(3, "Click search icon for Contract No then select required contract",test, test1);
		waitForElement(driver, Slab_ChkBox);
		checkBox(driver, Slab_ChkBox, Slab_CheckBox);
		// OPTION OF SELECTING THE CHECK BOX
		waitForDisplay(driver, AslabboxADD);

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
				} else {
					System.out.println("Expected Result is :Slab checkbox should be selected and filled with data || Actual Result is : Slab checkbox is not selected and filled with data");
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

// scalein pickup charges input
		if (!Pickupcharges.equals("")) {
			waitForElement(driver, AScale_in_pickup_charges);
			sendKeys(driver, AScale_in_pickup_charges, Pickupcharges);
		}
		Step_Start(8, " Enter values for handling charges in numeric digit",test, test1);
		// Handle charges input
		if (!handelcharges.equals("")) {
			waitForElement(driver, AHandling_Charges);
			sendKeys(driver, AHandling_Charges, handelcharges);
		}
		Step_End(8, " Enter values for handling charges in numeric digit",test, test1);
		Step_Start(9, " Enter values for Equipment quantity in numeric digit",test, test1);
// Equipment quantity input 
		if (!equipmentque.equals("")) {
			waitForElement(driver, AEquipment_Quantaty);
			sendKeys(driver, AEquipment_Quantaty, equipmentque);
		}
		Step_Start(7, "Enter values for Scale-out dropoff charges in numeric digit",test, test1);
		Step_End(9, " Enter values for Equipment quantity in numeric digit",test, test1);
		Step_Start(10, " Enter values for Pre trip ins charges in numeric digit when it is required",test, test1);
// pickup credit input
		if (!pickupcredit.equals("")) {
			waitForElement(driver, APick_Up_Credit);
			sendKeys(driver, APick_Up_Credit, pickupcredit);
		}
		
		Step_End(7, "Enter values for Scale-out dropoff charges in numeric digit",test, test1);
		Step_End(10, " Enter values for Pre trip ins charges in numeric digit when it is required",test, test1);
		// Remarks input

		if (!Remarks_input.equals("")) {
			waitForElement(driver, ARemarks_Input);
			sendKeys(driver, ARemarks_Input, Remarks_input);
		}
		Step_Start(4, "Select Validity From Date range accordingly in date picker",test, test1);
		// Selecting the From Date
		waitForElement(driver, AFrom_Date);
		if (From_date_perform.equalsIgnoreCase("Yes")) {
			waitForElement(driver, AFrom_Date);
			selectDatePicker(driver, AFrom_Date, From_Date_Input);
		} else {
			waitForElement(driver, AFrom_Date);
			clearAndType(driver, AFrom_Date, From_Date_Input);
		}
		
				Step_End(4, "Select Validity From Date range accordingly in date picker",test, test1);
				Step_Start(5, "Select Validity To Date range accordingly in date picker",test, test1);
				// Selecting the to Date
			
				waitForElement(driver, A_To_Date);
				if (To_Date_perform.equalsIgnoreCase("Yes")) {
					waitForElement(driver, A_To_Date);
					selectDatePicker(driver, A_To_Date, To_Date_Input);
				} else {
					waitForElement(driver, A_To_Date);
					clearAndType(driver, A_To_Date, To_Date_Input);
				}
				
						Step_End(5, "Select Validity To Date range accordingly in date picker",test, test1);
// selecting oneway check box
						Step_Start(6, "click on size type add button, location add button",test, test1);
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
		Step_Start(2, "Enter Alphanumeric character for Scale-out Reference field",test, test1);
		Step_End(6, "click on size type add button, location add button",test, test1);
		// Entering Scalin reference
		if (!scalerefno.equals("")) {
			waitForElement(driver, AScale_in_ref_input);
			safeclick(driver, AScale_in_ref_input);
			sendKeys(driver, AScale_in_ref_input, scalerefno);
			safeclick(driver, ARemarks_Input);
		}
		Step_End(2, "Enter Alphanumeric character for Scale-out Reference field",test, test1);
		Step_Start(11, " Click add button once all required fields are entered",test, test1);
			// Adding the values into the grid

			waitForElement(driver, AGried_Add_Button);
			safeclick(driver, AGried_Add_Button);
			  
			Step_End(11, " Click add button once all required fields are entered",test, test1);
			Step_Start(12, "  Click save button & system should show save message as successfull",test, test1);
			// Saving the records

			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			
			
			
			waitForElement(driver, AScale_in_ref_input);
			String reference =getAttribute(driver, AScale_in_ref_input, "value");
			System.out.println(reference);
			
			scrollTop(driver);
			Extent_call(test, test1,  "**Scaleout_ref was generated as**"+ reference);
			Extent_pass_New(driver,  "**Scaleout_ref was generated as**"+ reference, test, test1);
		

			// Verifying the validation of saved popup

			waitForPopup(driver, Popup_Message, savedpopexp);
			String Actualpopmsg = getText(driver, Popup_Message);
			System.out.println(Actualpopmsg);

			if (savedpopexp.equals(Actualpopmsg)) {
				System.out.println("Matched || " + " Expected popup is : " + savedpopexp
						+ " || Actual popup is : " + Actualpopmsg);
				Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedpopexp
						+ " || Actual popup is : " + Actualpopmsg, test, test1);
			} else {
				System.out.println("Not matched || " + " Expected popup is : " + savedpopexp
						+ " || Actual popup is : " + Actualpopmsg);
				Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedpopexp
						+ " || Actual popup is : " + Actualpopmsg, test, test1);
				
			}

			scrollUsingElement(driver, AGried_Add_Button);
			
			Map<String, List<String>> table_view = extractTableDataDirect(driver, table_Path);
			List<String> coloumhearders = splitAndExpand1(Coloum_names);
			
			String table_value = printTable(driver, table_view, coloumhearders);
			Extent_pass_New(driver, "<pre>"+table_value+"</pre>", test, test1);

// VERIFY THE DATA IN GIRD

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
				
		
			} else {
				System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
				Extent_fail(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid", test, test1);
				
			}
			Step_End(12, "  Click save button & system should show save message as successfull",test, test1);
			scrollTop(driver);

// Deleting the records
			if(Want_To_Delete.equalsIgnoreCase("Yes")) {

			waitForElement(driver, Delete_button_toolBar);
			safeclick(driver, Delete_button_toolBar);

			waitForElement(driver, popup_Message);
			safeclick(driver, popup_Message_Yes_Button);
			
		    waitForElement(driver, Popup_Message);

			}
			Extent_completed(testcase_Name, test, test1);
		}

	}

