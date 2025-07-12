package LRP_EMS_Consolidation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.Scale_In_Out_Reference;

public class TC_ScaleIn_ScaleOut_Reference_TS21_to_TS32_I extends Keywords {
	public void Scalein_scaleout_021_032(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset) throws Exception {
		
		// Value are taken from excel sheet
	
 int TC=1;
	     
	     if(TC==1) {
	    	 String testcase_Name = "TC_Scale_In_TS_021_IP";
	 		String URL = TestNgXml.getdatafromExecution().get(testcase_Name);
	 		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
	 		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
	 		System.out.println(Sheet_Name);

	 		Map<String, String> data21 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
	 		String Username = data21.get("Username");
	 		String Password = data21.get("Password");
	 		String Search = data21.get("Search_input");
	 		String contractnum = data21.get("Contract_No");
	 		String scalerefno = data21.get("Scale_Reference_no");
	 		String freedays = data21.get("Free_Days");
	 		String perdiem = data21.get("Per_Diem");
	 		String handelcharges = data21.get("Handles_Charges");
	 		String equipmentque = data21.get("equipment_Quantity");
	 		String pickupcredit = data21.get("PickUp_Credit");
	 		String Pickupcharges = data21.get("Scale_in_pickup_charges");
	 		String savedpopexp = data21.get("PopUpforsaved");
	 		String todayenter = data21.get("TODAYS");
	 		String secondtodayinput = data21.get("secondtoday");
	 		String secondtodayinputdem = data21.get("seconddiem");
	 		String From_date_perform = data21.get("From_date_perform");
	 		String To_Date_perform = data21.get("To_Date_perform");
	 		String Slab_CheckBox = data21.get("Slab_CheckBox");
	 		String One_Way_CheckBox = data21.get("One_Way_CheckBox");
	 		String Equipment_type_perform = data21.get("Equipment_type_perform");
	 		String Reference_Type = data21.get("Reference_Type");
	 		String Contract_Number_Search = data21.get("Contract_Number_Search");
	 		String Equipment_Type_Search = data21.get("Equipment_Type_Search");
	 		String Location_Search = data21.get("Location_Search");
	 		String From_Date_Input = data21.get("From_Date_Input");
	 		String To_Date_Input = data21.get("To_Date_Input");
	 		String One_way_return_location = data21.get("One_way_return_location");
	 		String Equipmenttype_Input = data21.get("Equipmenttype_Input");
	 		String Add_location_port_perform = data21.get("Add_location_port_perform");
	 		String Add_location_port_input = data21.get("Add_location_port_input");
	 		String Condition_Filter = data21.get("Condition_Filter");
	 		String One_Way_Search = data21.get("One_Way_Search");
	 		
	 		String Remarks_input = data21.get("Remarks_input");
	 		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 

	 		
	 		Extent_Start(testcase_Name, test, test1);
	 		
	 		
	 	
	 		navigateUrl(driver, URL);

	 		
	 		// LOGIN
	 		LRP_Login(driver, Username, Password);
	 		
	 		moduleNavigate(driver, Search);
			waitForElement(driver, Reference_Type_Field);
			safeclick(driver, Reference_Type_Field);
				waitForElement(driver, ReferenceType_Select);
				safeclick(driver, ReferenceType_Select);
			

			waitForElement(driver, AContract_no_input);
			waitForElement(driver, AContractNumsearch);
			safeclick(driver, AContractNumsearch);
			waitForElement(driver, Ainputcontractnum);
			twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
			
			waitForElement(driver, Slab_ChkBox);
			checkBox(driver, Slab_ChkBox, Slab_CheckBox);

			// OPTION OF SELECTING THE CHECK BOX
			
			if (isElementAccessible(driver, AslabboxADD)) {
				waitForElement(driver, AslabboxADD);
			
				safeclick(driver, AslabboxADD);
				waitForElement(driver, AslabboxADDTodays);
				doubleClick(driver, AslabboxADDTodays);
				Actionsendkeys(driver, AslabboxADDTodays, todayenter);
				waitForElement(driver, AslabboxADDperdiem);
				doubleClick(driver, AslabboxADDperdiem);
				Actionsendkeys(driver, APer_Diem_Input, perdiem);
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
				System.out.println("Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is selected and filled with data");
			} else {

				System.out.println("Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is not selected and filled with data");
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

			// Handle charges input
			if (!handelcharges.equals("")) {
				waitForElement(driver, AHandling_Charges);
				sendKeys(driver, AHandling_Charges, handelcharges);
			}

			// Equipment quantity input
			if (!equipmentque.equals("")) {
				waitForElement(driver, AEquipment_Quantaty);
				sendKeys(driver, AEquipment_Quantaty, equipmentque);
			}
			// pickup credit input
			if (!pickupcredit.equals("")) {
				waitForElement(driver, APick_Up_Credit);
				sendKeys(driver, APick_Up_Credit, pickupcredit);
			}

			// Remarks input

			if (!Remarks_input.equals("")) {
				waitForElement(driver, ARemarks_Input);
				sendKeys(driver, ARemarks_Input, Remarks_input);
			}

			// Selecting the From Date
			waitForElement(driver, AFrom_Date);
			if (From_date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, AFrom_Date);
				selectDatePicker(driver, AFrom_Date, From_Date_Input);
			} else {
				waitForElement(driver, AFrom_Date);
				clearAndType(driver, AFrom_Date, From_Date_Input);
			}
			
					
					// Selecting the to Date
					
			waitForElement(driver, A_To_Date);
			if (To_Date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, A_To_Date);
				selectDatePicker(driver, A_To_Date, To_Date_Input);
			} else {
				waitForElement(driver, A_To_Date);
				clearAndType(driver, A_To_Date, To_Date_Input);
			}
			
			// selecting oneway check box

			waitForElement(driver, OneWay_ChkBox);

			checkBox(driver, OneWay_ChkBox, One_Way_CheckBox);
			if (One_Way_CheckBox.equals("YES")) {

				List<String> datas = splitAndExpand(One_way_return_location);
				for (String data : datas) {
					
					waitForElement(driver, AAddreturnlocation);
					safeclick(driver, AAddreturnlocation);

					twoColumnSearchWindow(driver, One_Way_Search, Condition_Filter, data);

				}
			} else {
				System.out.println("Expected Result is : One way check box should selected and return location was not added || Actual Result is : One way check box is not selected and return location was not added");
			}

			// Selecting the Equipment type

			if (Equipment_type_perform.equals("YES")) {

				List<String> datas = splitAndExpand(Equipmenttype_Input);
				for (String data : datas) {
					
					waitForElement(driver, AEquipment_Type_add_button);
					safeclick(driver, AEquipment_Type_add_button);
					waitForElement(driver, equipmenttypevalueenter);
					twoColumnSearchWindow(driver, Equipment_Type_Search, Condition_Filter, data);
					

				}
			} else {
				System.out.println("Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added");
			}

			// Selecting the location

			if (Add_location_port_perform.equals("YES")) {

				List<String> datas = splitAndExpand(Add_location_port_input);
				for (String data : datas) {
				
					waitForElement(driver, ALocation_Add_Button);
					safeclick(driver, ALocation_Add_Button);
					twoColumnSearchWindow(driver, Location_Search, Condition_Filter, data);
					
				}
			} else {
				System.out.println("Expected Result is : Location  should  be added || Actual Result is : Location not  added");
			}

			Step_Start(1, " Ensure system should validate if user try to save scale-in by giving blank in Scale-In Ref",test, test1);
			// Entering Scalin reference
			if (!scalerefno.equals("")) {
				waitForElement(driver, AScale_in_ref_input);
				safeclick(driver, AScale_in_ref_input);
				sendKeys(driver, AScale_in_ref_input, scalerefno);
				safeclick(driver, ARemarks_Input);
			}
			// Adding the values into the grid

			waitForElement(driver, AGried_Add_Button);
			safeclick(driver, AGried_Add_Button);
			

			// Saving the records

			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			Step_Start(2, "Ensure that system should validate as 'Enter the Scale-In Ref.'",test, test1);

			waitForPopup(driver, Popup_Message, savedpopexp);
			String Actualpopmsg = getText(driver, Popup_Message);
			System.out.println(Actualpopmsg);

			if (savedpopexp.equals(Actualpopmsg)) {
				System.out.println("Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
						+ Actualpopmsg);
				Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
						+ Actualpopmsg, test, test1);
				Extent_call(test, test1, "**Popup was shown as **"+Actualpopmsg);
			} else {
				System.out.println("Not matched || " + " Expected popup is : " + savedpopexp
						+ " || Actual popup is : " + Actualpopmsg);
				Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedpopexp
						+ " || Actual popup is : " + Actualpopmsg, test, test1);
				
			}
			Step_End(1, " Ensure system should validate if user try to save scale-in by giving blank in Scale-In Ref",test, test1);
			Step_End(2, "Ensure that system should validate as 'Enter the Scale-In Ref.'",test, test1);
			Extent_completed(testcase_Name, test, test1);
			
		
		
	}
	
	     scrollTop(driver);

	     click(driver, Close_Current_tab); 		

 int LT2=2;
	     
	     if(LT2==2) {

	 		String testcase_Name = "TC_Scale_In_TS_022_IP";
	 		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
	 		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
	 		System.out.println(Sheet_Name);

	 		Map<String, String> data22 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
	 	
	 		String Search = data22.get("Search_input");
	 		String contractnum = data22.get("Contract_No");
	 		String Scale_Reference_no = data22.get("Scale_Reference_no");
	 		String freedays = data22.get("Free_Days");
	 		String perdiem = data22.get("Per_Diem");
	 		String handelcharges = data22.get("Handles_Charges");
	 		String equipmentque = data22.get("equipment_Quantity");
	 		String pickupcredit = data22.get("PickUp_Credit");
	 		String Pickupcharges = data22.get("Scale_in_pickup_charges");
	 		String From_date_perform = data22.get("From_date_perform");
	 		String To_Date_perform = data22.get("To_Date_perform");
	 		
	 		String todayenter = data22.get("TODAYS");
	 		String secondtodayinput = data22.get("secondtoday");
	 		String secondtodayinputdem = data22.get("seconddiem");
	 		
	 		String Contract_Number_Search = data22.get("Contract_Number_Search");
	 		String Equipment_Type_Search = data22.get("Equipment_Type_Search");
	 		String Location_Search = data22.get("Location_Search");
	 		String Slab_CheckBox = data22.get("Slab_CheckBox");
	 		
	 		String Equipment_type_perform = data22.get("Equipment_type_perform");
	 		String Reference_Type = data22.get("Reference_Type");
	 		String From_Date_Input = data22.get("From_Date_Input");
	 		String To_Date_Input = data22.get("To_Date_Input");
	 		
	 		String Equipmenttype_Input = data22.get("Equipmenttype_Input");
	 		String Add_location_port_perform = data22.get("Add_location_port_perform");
	 		String Add_location_port_input = data22.get("Add_location_port_input");
	 		String Condition_Filter = data22.get("Condition_Filter");
	 		String Remarks_input = data22.get("Remarks_input");
	 		String PopUpforsaved = data22.get("PopUpforsaved");
	 		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 

	 		Extent_Start(testcase_Name, test, test1);
	 		
			moduleNavigate(driver, Search);
			
			waitForElement(driver, Reference_Type_Field);
			safeclick(driver, Reference_Type_Field);
			
				waitForElement(driver, ReferenceType_Select);
				safeclick(driver, ReferenceType_Select);
				
			waitForElement(driver, AContract_no_input);
			waitForElement(driver, AContractNumsearch);
			safeclick(driver, AContractNumsearch);
			waitForElement(driver, Ainputcontractnum);
			twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
			waitForElement(driver, Slab_ChkBox);
			checkBox(driver, Slab_ChkBox, Slab_CheckBox);

			// OPTION OF SELECTING THE CHECK BOX
		
			if (isElementAccessible(driver, AslabboxADD)) {
				
				waitForElement(driver, AslabboxADD);
				safeclick(driver, AslabboxADD);
				waitForElement(driver, AslabboxADDTodays);
				doubleClick(driver, AslabboxADDTodays);
				
				Actionsendkeys(driver, AslabboxADDTodays, todayenter);
			
				waitForElement(driver, AslabboxADDperdiem);
			
				doubleClick(driver, AslabboxADDperdiem);
				
				Actionsendkeys(driver, APer_Diem_Input, perdiem);
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
				System.out.println("slab box was selected and filled with data");

			} else {
				System.out.println("Slab box was not selected");
				
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

			// Handle charges input
			if (!handelcharges.equals("")) {
				waitForElement(driver, AHandling_Charges);
				sendKeys(driver, AHandling_Charges, handelcharges);
			}

	// Equipment quantity input 
			if (!equipmentque.equals("")) {
				waitForElement(driver, AEquipment_Quantaty);
				sendKeys(driver, AEquipment_Quantaty, equipmentque);
			}
	// pickup credit input
			if (!pickupcredit.equals("")) {
				waitForElement(driver, APick_Up_Credit);
				sendKeys(driver, APick_Up_Credit, pickupcredit);
			}

			// Remarks input

			if (!Remarks_input.equals("")) {
				waitForElement(driver, ARemarks_Input);
				sendKeys(driver, ARemarks_Input, Remarks_input);
			}

			// Selecting the From Date
			waitForElement(driver, AFrom_Date);
			if (From_date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, AFrom_Date);
				selectDatePicker(driver, AFrom_Date, From_Date_Input);
			} else {
				waitForElement(driver, AFrom_Date);
				clearAndType(driver, AFrom_Date, From_Date_Input);
			}
			
			// Selecting the to Date
			waitForElement(driver, A_To_Date);
			if (To_Date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, A_To_Date);
				selectDatePicker(driver, A_To_Date, To_Date_Input);
			} else {
				waitForElement(driver, A_To_Date);
				clearAndType(driver, A_To_Date, To_Date_Input);
			}
			
	// selecting oneway check box

			// Selecting the Equipment type

			if (Equipment_type_perform.equals("YES")) {

				List<String> datas = splitAndExpand(Equipmenttype_Input);
				for (String data : datas) {
					
					waitForElement(driver, AEquipment_Type_add_button);
					safeclick(driver, AEquipment_Type_add_button);
					waitForElement(driver, equipmenttypevalueenter);
					twoColumnSearchWindow(driver, Equipment_Type_Search, Condition_Filter, data);
				}
			} else {
				System.out.println("Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added");
				Extent_fail(driver, "Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added", test, test1);
			}

			// Selecting the location

			if (Add_location_port_perform.equals("YES")) {

				List<String> datas = splitAndExpand(Add_location_port_input);
				for (String data : datas) {
				
					waitForElement(driver, ALocation_Add_Button);
					safeclick(driver, ALocation_Add_Button);
					twoColumnSearchWindow(driver, Location_Search, Condition_Filter, data);
						
				
				}
			} else {
				System.out.println("Expected Result is : Location  should  be added || Actual Result is : Location not  added");
				Extent_fail(driver, "Expected Result is : Location  should  be added || Actual Result is : Location not  added", test, test1);
			}
			Step_Start(1, "Ensure system should validate if user try to save scale-in by giving blank in Scale-Out Ref'",test, test1);
			// Entering Scalout reference
			if (!Scale_Reference_no.equals("")) {
				waitForElement(driver, AScale_in_ref_input);
				safeclick(driver, AScale_in_ref_input);
				sendKeys(driver, AScale_in_ref_input, Scale_Reference_no);
				safeclick(driver, ARemarks_Input);

			} else {
				System.out.println("scaleout reference value was not entered");
				
			}

			// Adding the values into the grid

			waitForElement(driver, AGried_Add_Button);
			safeclick(driver, AGried_Add_Button);
			
			// Saving the records

			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			Step_Start(2, " Ensure that system should validate as 'Enter the Scale-Out Ref.''",test, test1);

			waitForPopup(driver, Popup_Message, PopUpforsaved);
			String Actualpopmsg11 = getText(driver, Popup_Message);
			System.out.println(Actualpopmsg11);

			if (PopUpforsaved.equals(Actualpopmsg11)) {
				System.out.println("Matched || " + " Expected Popup is : " + PopUpforsaved + " || Actual Popup is : "
						+ Actualpopmsg11);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + PopUpforsaved + " || Actual Popup is : "
						+ Actualpopmsg11, test, test1);
				
				Extent_call(test, test1, "**popup was shown as*** "+Actualpopmsg11);
			} else {
				System.out.println("Not matched || " + " Expected Popup is : " + PopUpforsaved
						+ " || Actual Popup is : " + Actualpopmsg11);
				Extent_fail(driver, "Not matched || " + " Expected Popup is : " + PopUpforsaved
						+ " || Actual Popup is : " + Actualpopmsg11, test, test1);
				

			}
			Step_End(1, "Ensure system should validate if user try to save scale-in by giving blank in Scale-Out Ref'",test, test1);
			Step_End(2, " Ensure that system should validate as 'Enter the Scale-Out Ref.''",test, test1);
			Extent_completed(testcase_Name, test, test1);
			
		}

	     scrollTop(driver);
	   
	     click(driver, Close_Current_tab); 		

 int LT3=3;
	     
	     if(LT3==3) {
	    	 
	    	 

	    	 String testcase_Name = "TC_Scale_In_TS_023_IP";
	 		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
	 		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
	 		System.out.println(Sheet_Name);

	 		Map<String, String> data23 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
	 	

	 		String Search = data23.get("Search_input");
	 		String contractnum = data23.get("Contract_No");
	 		String scalerefno = data23.get("Scale_Reference_no");
	 		String freedays = data23.get("Free_Days");
	 		String perdiem = data23.get("Per_Diem");
	 		String handelcharges = data23.get("Handles_Charges");
	 		String equipmentque = data23.get("equipment_Quantity");
	 		String pickupcredit = data23.get("PickUp_Credit");
	 		String Pickupcharges = data23.get("Scale_in_pickup_charges");
	 		String savedpopexp = data23.get("PopUpforsaved");
	 		String todayenter = data23.get("TODAYS");
	 		String secondtodayinput = data23.get("secondtoday");
	 		String secondtodayinputdem = data23.get("seconddiem");
	 		String Slab_CheckBox = data23.get("Slab_CheckBox");
	 		String One_Way_CheckBox = data23.get("One_Way_CheckBox");
	 		String Equipment_type_perform = data23.get("Equipment_type_perform");
	 		String Reference_Type = data23.get("Reference_Type");
	 		String To_Date_perform = data23.get("To_Date_perform");
	 		String From_date_perform = data23.get("From_date_perform");
	 		String Condition_Filter = data23.get("Condition_Filter");
	 		String From_Date_Input = data23.get("From_Date_Input");
	 		String To_Date_Input = data23.get("To_Date_Input");
	 		String One_way_return_location = data23.get("One_way_return_location");
	 		String Equipmenttype_Input = data23.get("Equipmenttype_Input");
	 		String Add_location_port_perform = data23.get("Add_location_port_perform");
	 		String Add_location_port_input = data23.get("Add_location_port_input");
	 		String Contract_Number_Search = data23.get("Contract_Number_Search");
	 		String Equipment_Type_Search = data23.get("Equipment_Type_Search");
	 		String Location_Search = data23.get("Location_Search");
	 		String One_Way_Search = data23.get("One_Way_Search");
	 		String Remarks_input = data23.get("Remarks_input");
	 		
	 		String per_diem_slap = data23.get("per_diem_slap");
	 		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
	 		Extent_Start(testcase_Name, test, test1);
	 		
	 		moduleNavigate(driver, Search);
			waitForElement(driver, Reference_Type_Field);
			safeclick(driver, Reference_Type_Field);
			waitForElement(driver, ReferenceType_Select);
			safeclick(driver, ReferenceType_Select);
			Step_Start(1, " Ensure system should allow user to contract no correctly in that field correctly''",test, test1);
			waitForElement(driver, AContract_no_input);
			waitForElement(driver, AContractNumsearch);
			safeclick(driver, AContractNumsearch);
			waitForElement(driver, Ainputcontractnum);
			twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
			Step_End(1, " Ensure system should allow user to contract no correctly in that field correctly''",test, test1);
			waitForElement(driver, Slab_ChkBox);
			checkBox(driver, Slab_ChkBox, Slab_CheckBox);

			// OPTION OF SELECTING THE CHECK BOX

			if (isElementAccessible(driver, AslabboxADD)) {
				waitForElement(driver, AslabboxADD);

				safeclick(driver, AslabboxADD);

				waitForElement(driver, AslabboxADDTodays);

				doubleClick(driver, AslabboxADDTodays);

				Actionsendkeys(driver, AslabboxADDTodays, todayenter);

				waitForElement(driver, AslabboxADDperdiem);

				doubleClick(driver, AslabboxADDperdiem);

				Actionsendkeys(driver, APer_Diem_Input, per_diem_slap);
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
				System.out.println("Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is selected and filled with data");
			} else {

				System.out.println("Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is not selected and filled with data");
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

			// Handle charges input
			if (!handelcharges.equals("")) {
				waitForElement(driver, AHandling_Charges);
				sendKeys(driver, AHandling_Charges, handelcharges);
			}
			Step_Start(3, " Ensure that system should allow user to enter equipment qty correctly'",test, test1);
			// Equipment quantity input
			if (!equipmentque.equals("")) {
				waitForElement(driver, AEquipment_Quantaty);
				sendKeys(driver, AEquipment_Quantaty, equipmentque);
			}
			Step_End(3, " Ensure that system should allow user to enter equipment qty correctly'",test, test1);
			// pickup credit input
			if (!pickupcredit.equals("")) {
				waitForElement(driver, APick_Up_Credit);
				sendKeys(driver, APick_Up_Credit, pickupcredit);
			}

			// Remarks input

			if (!Remarks_input.equals("")) {
				waitForElement(driver, ARemarks_Input);
				sendKeys(driver, ARemarks_Input, Remarks_input);
			}

			Step_Start(2, " Ensure that system should allow user to select Validity From & To Period correctly'",test, test1);
			// Selecting the From Date
			waitForElement(driver, AFrom_Date);
			if (From_date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, AFrom_Date);
				selectDatePicker(driver, AFrom_Date, From_Date_Input);
			} else {
				waitForElement(driver, AFrom_Date);
				clearAndType(driver, AFrom_Date, From_Date_Input);
			}

			// Selecting the to Date

			waitForElement(driver, A_To_Date);
			if (To_Date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, A_To_Date);
				selectDatePicker(driver, A_To_Date, To_Date_Input);
			} else {
				waitForElement(driver, A_To_Date);
				clearAndType(driver, A_To_Date, To_Date_Input);
			}

			Step_End(2, " Ensure that system should allow user to select Validity From & To Period correctly'",test, test1);
			// selecting oneway check box

			waitForElement(driver, OneWay_ChkBox);

			checkBox(driver, OneWay_ChkBox, One_Way_CheckBox);
			if (One_Way_CheckBox.equals("YES")) {

				List<String> datas = splitAndExpand(One_way_return_location);
				for (String data : datas) {

					waitForElement(driver, AAddreturnlocation);
					safeclick(driver, AAddreturnlocation);

					twoColumnSearchWindow(driver, One_Way_Search, Condition_Filter, data);


				}
			} else {
				System.out.println("one way was not selected and return location was not added");
			}

			// Selecting the Equipment type

			if (Equipment_type_perform.equals("YES")) {

				List<String> datas = splitAndExpand(Equipmenttype_Input);
				for (String data : datas) {

					waitForElement(driver, AEquipment_Type_add_button);
					safeclick(driver, AEquipment_Type_add_button);
					waitForElement(driver, equipmenttypevalueenter);
					twoColumnSearchWindow(driver, Equipment_Type_Search, Condition_Filter, data);

				}
			} else {
				System.out.println("Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added");
				Extent_fail(driver, "Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added", test, test1);
			}
			Step_Start(4, " Ensure that system should allow user to enter location correctly",test, test1);
			// Selecting the location

			if (Add_location_port_perform.equals("YES")) {

				List<String> datas = splitAndExpand(Add_location_port_input);
				for (String data : datas) {

					waitForElement(driver, ALocation_Add_Button);
					safeclick(driver, ALocation_Add_Button);
					twoColumnSearchWindow(driver, Location_Search, Condition_Filter, data);


				}
			} else {
				System.out.println("Expected Result is : Location  should  be added || Actual Result is : Location not  added");
				Extent_fail(driver, "Expected Result is : Location  should  be added || Actual Result is : Location not  added", test, test1);
			}
			Step_End(4, " Ensure that system should allow user to enter location correctly",test, test1);
			// Entering Scalin reference
			if (!scalerefno.equals("")) {
				waitForElement(driver, AScale_in_ref_input);
				safeclick(driver, AScale_in_ref_input);
				sendKeys(driver, AScale_in_ref_input, scalerefno);
				safeclick(driver, ARemarks_Input);
			}
			Step_Start(5, " Ensure that system should validate when user try to click save button without adding data into grid",test, test1);
			// Saving the records

			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			Step_Start(6, "  Ensure that system should validate message as 'Press the add button to add Equipment Type and Quantity'",test, test1);

			waitForPopup(driver, Popup_Message, savedpopexp);
			String Actualpopmsg = getText(driver, Popup_Message);
			System.out.println(Actualpopmsg);

			if (savedpopexp.equals(Actualpopmsg)) {
				System.out.println("Matched || " + " Expected Popup is : " + savedpopexp + " || Actual Popup is : "
						+ Actualpopmsg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + savedpopexp + " || Actual Popup is : "
						+ Actualpopmsg, test, test1);


			} else {
				System.out.println("Not matched || " + " Expected Popup is : " + savedpopexp
						+ " || Actual Popup is : " + Actualpopmsg);
				Extent_fail(driver, "Not matched || " + " Expected Popup is : " + savedpopexp
						+ " || Actual Popup is : " + Actualpopmsg, test, test1);

			}
			Step_End(5, " Ensure that system should validate when user try to click save button without adding data into grid",test, test1);
			Step_End(6, "  Ensure that system should validate message as 'Press the add button to add Equipment Type and Quantity'",test, test1);
			Extent_completed(testcase_Name, test, test1);

		}
	     
	     scrollTop(driver);
	   
	     click(driver, Close_Current_tab); 		

 int LT4=4;
	     
	     if(LT4==4) {
	    	 
	    		// Value are taken from excel sheet
	 		String testcase_Name = "TC_Scale_In_TS_024_IP";
	 		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
	 		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
	 		System.out.println(Sheet_Name);

	 		Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
	 	
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
			String Slab_CheckBox = Excel_data.get("Slab_CheckBox");
			String One_Way_CheckBox = Excel_data.get("One_Way_CheckBox");
			String Equipment_type_perform = Excel_data.get("Equipment_type_perform");
			String Reference_Type = Excel_data.get("Reference_Type");
			String To_Date_perform = Excel_data.get("To_Date_perform");
			String From_date_perform = Excel_data.get("From_date_perform");
			String Condition_Filter = Excel_data.get("Condition_Filter");
			String From_Date_Input = Excel_data.get("From_Date_Input");
			String To_Date_Input = Excel_data.get("To_Date_Input");
			String One_way_return_location = Excel_data.get("One_way_return_location");
			String Equipmenttype_Input = Excel_data.get("Equipmenttype_Input");
			String Add_location_port_perform = Excel_data.get("Add_location_port_perform");
			String Add_location_port_input = Excel_data.get("Add_location_port_input");
			String Remarks_input = Excel_data.get("Remarks_input");
			String per_diem_slap = Excel_data.get("per_diem_slap");	
			String Contract_Number_Search = Excel_data.get("Contract_Number_Search");
			String Equipment_Type_Search = Excel_data.get("Equipment_Type_Search");
			String Location_Search = Excel_data.get("Location_Search");
			String One_Way_Search = Excel_data.get("One_Way_Search");
			String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
			Extent_Start(testcase_Name, test, test1);
			
			
			moduleNavigate(driver, Search);
			waitForElement(driver, Reference_Type_Field);
			safeclick(driver, Reference_Type_Field);
		
			waitForElement(driver, ReferenceType_Select);
			safeclick(driver, ReferenceType_Select);
			Step_Start(1, " Ensure system should allow user to contract no correctly in that field correctly''",test, test1);
			waitForElement(driver, AContract_no_input);
			waitForElement(driver, AContractNumsearch);
			safeclick(driver, AContractNumsearch);
			waitForElement(driver, Ainputcontractnum);
			twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
			
			Step_End(1, " Ensure system should allow user to contract no correctly in that field correctly''",test, test1);
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
			
				Actionsendkeys(driver, APer_Diem_Input, per_diem_slap);
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
				System.out.println("Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is selected and filled with data");
				Extent_pass_New(driver, "Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is selected and filled with data", test, test1);
			} else {

				System.out.println("Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is not selected and filled with data");
				Extent_fail(driver, "Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is not selected and filled with data", test, test1);
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
				//wait(driver, "1");
			}

			// scalein pickup charges input
			if (!Pickupcharges.equals("")) {

				waitForElement(driver, AScale_in_pickup_charges);
				sendKeys(driver, AScale_in_pickup_charges, Pickupcharges);
			}

			// Handle charges input
			if (!handelcharges.equals("")) {
				waitForElement(driver, AHandling_Charges);
				sendKeys(driver, AHandling_Charges, handelcharges);
			}
			Step_Start(3, " Ensure that system should allow user to enter equipment qty correctly'",test, test1);
			// Equipment quantity input
			if (!equipmentque.equals("")) {
				waitForElement(driver, AEquipment_Quantaty);
				sendKeys(driver, AEquipment_Quantaty, equipmentque);
			}
			Step_End(3, " Ensure that system should allow user to enter equipment qty correctly'",test, test1);
			// pickup credit input
			if (!pickupcredit.equals("")) {
				waitForElement(driver, APick_Up_Credit);
				sendKeys(driver, APick_Up_Credit, pickupcredit);
			}

			// Remarks input

			if (!Remarks_input.equals("")) {
				waitForElement(driver, ARemarks_Input);
				sendKeys(driver, ARemarks_Input, Remarks_input);
			}
			Step_Start(2, " Ensure that system should allow user to select Validity From & To Period correctly'",test, test1);
			// Selecting the From Date
			waitForElement(driver, AFrom_Date);
			if (From_date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, AFrom_Date);
				selectDatePicker(driver, AFrom_Date, From_Date_Input);
			} else {
				waitForElement(driver, AFrom_Date);
				clearAndType(driver, AFrom_Date, From_Date_Input);
			}
			// Selecting the to Date
			
			waitForElement(driver, A_To_Date);
			if (To_Date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, A_To_Date);
				selectDatePicker(driver, A_To_Date, To_Date_Input);
			} else {
				waitForElement(driver, A_To_Date);
				clearAndType(driver, A_To_Date, To_Date_Input);
			}
			
					Step_End(2, " Ensure that system should allow user to select Validity From & To Period correctly'",test, test1);
			// selecting oneway check box

			waitForElement(driver, OneWay_ChkBox);

			checkBox(driver, OneWay_ChkBox, One_Way_CheckBox);
			if (One_Way_CheckBox.equals("YES")) {

				List<String> datas = splitAndExpand(One_way_return_location);
				for (String data : datas) {
					
					waitForElement(driver, AAddreturnlocation);
					safeclick(driver, AAddreturnlocation);

					twoColumnSearchWindow(driver, One_Way_Search, Condition_Filter, data);

				}
			} else {
				
				System.out.println("one way was not selected and return location was not added");
			}

			// Selecting the Equipment type

			if (Equipment_type_perform.equals("YES")) {

				List<String> datas = splitAndExpand(Equipmenttype_Input);
				for (String data : datas) {
					
					waitForElement(driver, AEquipment_Type_add_button);
					safeclick(driver, AEquipment_Type_add_button);
					waitForElement(driver, equipmenttypevalueenter);
					twoColumnSearchWindow(driver, Equipment_Type_Search, Condition_Filter, data);
				}
			} else {
				System.out.println("Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added");
				Extent_fail(driver, "Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added", test, test1);
			}
			Step_Start(4, " Ensure that system should allow user to enter location correctly",test, test1);
			// Selecting the location

			if (Add_location_port_perform.equals("YES")) {

				List<String> datas = splitAndExpand(Add_location_port_input);
				for (String data : datas) {
				
					waitForElement(driver, ALocation_Add_Button);
					safeclick(driver, ALocation_Add_Button);
					twoColumnSearchWindow(driver, Location_Search, Condition_Filter, data);
				

				}
			} else {
				System.out.println("Expected Result is : Location  should  be added || Actual Result is : Location not  added");
				Extent_fail(driver, "Expected Result is : Location  should  be added || Actual Result is : Location not  added", test, test1);
			}
			Step_End(4, " Ensure that system should allow user to enter location correctly",test, test1);
			// Entering Scalin reference
			if (!scalerefno.equals("")) {
				waitForElement(driver, AScale_in_ref_input);
				safeclick(driver, AScale_in_ref_input);
				sendKeys(driver, AScale_in_ref_input, scalerefno);
				safeclick(driver, ARemarks_Input);
			}
			Step_Start(5, " Ensure that system should allow user to add data into grid",test, test1);
			// Adding the values into the grid

			waitForElement(driver, AGried_Add_Button);
			safeclick(driver, AGried_Add_Button);
			
		
			Step_End(5, " Ensure that system should allow user to add data into grid",test, test1);
			Step_Start(6, "  Ensure that system should validate when user try to remove data from grid'",test, test1);
			waitForElement(driver, Removebuttoncoloumclick);
			doubleClick(driver, Removebuttoncoloumclick);
			waitForElement(driver, AGried_Add_Button);
			safeclick(driver, AGried_Add_Button);
			waitForElement(driver, Removebutton);
			safeclick(driver, Removebutton);
			Step_Start(7, "  Ensure that system should validate as  'Do you want to delete the selected Equipment Type(s)?'"+ "'",test, test1);
			waitForPopup(driver, popup_Message, ReferenceType_Select);
			String Actualpopmsg5 = getText(driver, popup_Message);
			System.out.println(Actualpopmsg5);

			if (savedpopexp.equals(Actualpopmsg5)) {
				System.out.println("Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
						+ Actualpopmsg5);
				Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
						+ Actualpopmsg5, test, test1);
				Extent_call(test, test1, "**popup was shown as*** "+Actualpopmsg5);
			} else {
				System.out.println("Not matched || " + " Expected popup is : " + savedpopexp
						+ " || Actual popup is : " + Actualpopmsg5);
				Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedpopexp
						+ " || Actual popup is : " + Actualpopmsg5, test, test1);
				
			}
			waitForElement(driver, popup_Message_No_Button);
			safeclick(driver, popup_Message_No_Button);
			Step_End(6, "  Ensure that system should validate when user try to remove data from grid'",test, test1);
			Step_End(7, "  Ensure that system should validate as  'Do you want to delete the selected Equipment Type(s)?'"+ "'",test, test1);
			scrollTop(driver);
			Extent_completed(testcase_Name, test, test1);


	    	}
	     scrollTop(driver);
	 
	     click(driver, Close_Current_tab); 		

 int LT5=5;
	     
	     if(LT5==5) {
	    	 
	    		String testcase_Name = "TC_Scale_In_TS_025_IP";
	    		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
	    		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
	    		System.out.println(Sheet_Name);

	    		Map<String, String> data25 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
	    	
	    		String Search = data25.get("Search_input");
	    		String contractnum = data25.get("Contract_No");
	    		String Scale_Reference_no = data25.get("Scale_Reference_no");
	    		String freedays = data25.get("Free_Days");
	    		String perdiem = data25.get("Per_Diem");
	    		String handelcharges = data25.get("Handles_Charges");
	    		String equipmentque = data25.get("equipment_Quantity");
	    		String pickupcredit = data25.get("PickUp_Credit");
	    		String Pickupcharges = data25.get("Scale_in_pickup_charges");
	    		String From_date_perform = data25.get("From_date_perform");
	    		String To_Date_perform = data25.get("To_Date_perform");
	    		String Condition_Filter = data25.get("Condition_Filter");
	    		String Equipment_type_perform = data25.get("Equipment_type_perform");
	    		String Reference_Type = data25.get("Reference_Type");
	    		
	    		String From_Date_Input = data25.get("From_Date_Input");
	    		String To_Date_Input = data25.get("To_Date_Input");
	    		
	    		String Equipmenttype_Input = data25.get("Equipmenttype_Input");
	    		String Add_location_port_perform = data25.get("Add_location_port_perform");
	    		String Add_location_port_input = data25.get("Add_location_port_input");
	    		
	    		String Remarks_input = data25.get("Remarks_input");
	    		String PopUpforsaved = data25.get("PopUpforsaved");
	    		String Contract_Number_Search = data25.get("Contract_Number_Search");
	    		String Equipment_Type_Search = data25.get("Equipment_Type_Search");
	    		String Location_Search = data25.get("Location_Search");
	    		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
	    		Extent_Start(testcase_Name, test, test1);
	    		
	    		moduleNavigate(driver, Search);
	    		waitForElement(driver, Reference_Type_Field);
	    		safeclick(driver, Reference_Type_Field);
	    			waitForElement(driver, ReferenceType_Select);
	    			safeclick(driver, ReferenceType_Select);
	    		
	    		// selecting the contract number
	    		if (!contractnum.equals("")) {
	    			waitForElement(driver, AContract_no_input);
	    			waitForElement(driver, AContractNumsearch);
	    			safeclick(driver, AContractNumsearch);
	    			waitForElement(driver, Ainputcontractnum);
	    			twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);

	    		} else {
	    			System.out.println("Contract was not selected");
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

	    		// Handle charges input
	    		if (!handelcharges.equals("")) {
	    			waitForElement(driver, AHandling_Charges);
	    			sendKeys(driver, AHandling_Charges, handelcharges);
	    		}

	    // Equipment quantity input 
	    		if (!equipmentque.equals("")) {
	    			waitForElement(driver, AEquipment_Quantaty);
	    			sendKeys(driver, AEquipment_Quantaty, equipmentque);
	    		}
	    // pickup credit input
	    		if (!pickupcredit.equals("")) {
	    			waitForElement(driver, APick_Up_Credit);
	    			sendKeys(driver, APick_Up_Credit, pickupcredit);
	    		}

	    		// Remarks input

	    		if (!Remarks_input.equals("")) {
	    			waitForElement(driver, ARemarks_Input);
	    			sendKeys(driver, ARemarks_Input, Remarks_input);
	    		}

	    		// Selecting the From Date
	    		waitForElement(driver, AFrom_Date);
	    		if (From_date_perform.equalsIgnoreCase("Yes")) {
	    			waitForElement(driver, AFrom_Date);
	    			selectDatePicker(driver, AFrom_Date, From_Date_Input);
	    		} else {
	    			waitForElement(driver, AFrom_Date);
	    			clearAndType(driver, AFrom_Date, From_Date_Input);
	    		}
	    		
	    		// Selecting the to Date
	    		
	    		waitForElement(driver, A_To_Date);
	    		if (To_Date_perform.equalsIgnoreCase("Yes")) {
	    			waitForElement(driver, A_To_Date);
	    			selectDatePicker(driver, A_To_Date, To_Date_Input);
	    		} else {
	    			waitForElement(driver, A_To_Date);
	    			clearAndType(driver, A_To_Date, To_Date_Input);
	    		}
	    		
	    // selecting oneway check box

	    		// Selecting the Equipment type

	    		if (Equipment_type_perform.equals("YES")) {

	    			List<String> datas = splitAndExpand(Equipmenttype_Input);
	    			for (String data : datas) {
	    				//wait(driver, "3");
	    				waitForElement(driver, AEquipment_Type_add_button);
	    				safeclick(driver, AEquipment_Type_add_button);
	    				waitForElement(driver, equipmenttypevalueenter);
	    				twoColumnSearchWindow(driver, Equipment_Type_Search, Condition_Filter, data);

	    			}
	    		} else {
	    			System.out.println("Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added");
	    			Extent_fail(driver, "Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added", test, test1);
	    		}

	    		// Selecting the location

	    		if (Add_location_port_perform.equals("YES")) {

	    			List<String> datas = splitAndExpand(Add_location_port_input);
	    			for (String data : datas) {
	    			
	    				waitForElement(driver, ALocation_Add_Button);
	    				safeclick(driver, ALocation_Add_Button);
	    				twoColumnSearchWindow(driver, Location_Search, Condition_Filter, data);
	    				
	    			}
	    		} else {
	    			System.out.println("Expected Result is : Location  should  be added || Actual Result is : Location not  added");
	    			Extent_fail(driver, "Expected Result is : Location  should  be added || Actual Result is : Location not  added", test, test1);
	    		}

	    		// Entering Scalin reference
	    		if (!Scale_Reference_no.equals("")) {
	    			waitForElement(driver, AScale_in_ref_input);
	    			safeclick(driver, AScale_in_ref_input);
	    			sendKeys(driver, AScale_in_ref_input, Scale_Reference_no);
	    			safeclick(driver, ARemarks_Input);

	    		} else {
	    			System.out.println("scaleout reference value was not entered");
	    		}
	    		Step_Start(1, "  Ensure system should validate if user try to save after adding data into grid then contract no field is blank  ",test, test1);

	    		// Adding the values into the grid

	    		waitForElement(driver, AGried_Add_Button);
	    		safeclick(driver, AGried_Add_Button);
	    	
	    		// Saving the records

	    		waitForElement(driver, SaveButton_ToolBar);
	    		safeclick(driver, SaveButton_ToolBar);
	    		Step_Start(2, " Ensure that system should validate as 'Enter the Supplier Reference.'",test, test1);

	    		waitForPopup(driver, Popup_Message, PopUpforsaved);
	    		String Actualpopmsg11 = getText(driver, Popup_Message);
	    		System.out.println(Actualpopmsg11);

	    		if (PopUpforsaved.equals(Actualpopmsg11)) {
	    			System.out.println("Matched || " + " Expected popup is : " + PopUpforsaved + " || Actual popup is : "
	    					+ Actualpopmsg11);
	    			Extent_pass_New(driver, "Matched || " + " Expected popup is : " + PopUpforsaved + " || Actual popup is : "
	    					+ Actualpopmsg11, test, test1);
	    		} else {
	    			System.out.println("Not matched || " + " Expected popup is : " + PopUpforsaved
	    					+ " || Actual popup is : " + Actualpopmsg11);
	    			Extent_fail(driver, "Not matched || " + " Expected popup is : " + PopUpforsaved
	    					+ " || Actual popup is : " + Actualpopmsg11, test, test1);
	    			

	    		}
	    		Step_End(1, "  Ensure system should validate if user try to save after adding data into grid then contract no field is blank  ",test, test1);
	    		Step_End(2, " Ensure that system should validate as 'Enter the Supplier Reference.'",test, test1);
	    		Extent_completed(testcase_Name, test, test1);
	    	}
	     
	     scrollTop(driver);
	 
	     click(driver, Close_Current_tab); 		

 int LT6=6;
	     
	     if(LT6==6) {
	    	 
	    	 String testcase_Name = "TC_Scale_In_TS_026_IP";
	 		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
	 		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
	 		System.out.println(Sheet_Name);

	 		Map<String, String> data26 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
	 	
	 		String Search = data26.get("Search_input");
	 		String contractnum = data26.get("Contract_No");
	 		String Scale_Reference_no = data26.get("Scale_Reference_no");
	 		String freedays = data26.get("Free_Days");
	 		String perdiem = data26.get("Per_Diem");
	 		String handelcharges = data26.get("Handles_Charges");
	 		String equipmentque = data26.get("equipment_Quantity");
	 		String pickupcredit = data26.get("PickUp_Credit");
	 		String Pickupcharges = data26.get("Scale_in_pickup_charges");
	 		
	 		String todayenter = data26.get("TODAYS");
	 		String secondtodayinput = data26.get("secondtoday");
	 		String secondtodayinputdem = data26.get("seconddiem");
	 		String Slab_CheckBox = data26.get("Slab_CheckBox");
	 		
	 		String Equipment_type_perform = data26.get("Equipment_type_perform");
	 		String Reference_Type = data26.get("Reference_Type");
	 		
	 		String From_Date_Input = data26.get("From_Date_Input");
	 		String To_Date_Input = data26.get("To_Date_Input");
	 		String To_Date_perform = data26.get("To_Date_perform");
	 		String From_date_perform = data26.get("From_date_perform");
	 		
	 		String Equipmenttype_Input = data26.get("Equipmenttype_Input");
	 		String Add_location_port_perform = data26.get("Add_location_port_perform");
	 		String Add_location_port_input = data26.get("Add_location_port_input");
	 		String Condition_Filter = data26.get("Condition_Filter");
	 		String Remarks_input = data26.get("Remarks_input");
	 		String PopUpforsaved = data26.get("PopUpforsaved");
	 		String Contract_Number_Search = data26.get("Contract_Number_Search");
	 		String Equipment_Type_Search = data26.get("Equipment_Type_Search");
	 		String Location_Search = data26.get("Location_Search");
	 		
	 		
	 		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
	 		Extent_Start(testcase_Name, test, test1);
	 		
	 		moduleNavigate(driver, Search);
			waitForElement(driver, Reference_Type_Field);
			safeclick(driver, Reference_Type_Field);
			
				waitForElement(driver, ReferenceType_Select);
				safeclick(driver, ReferenceType_Select);
			
			waitForElement(driver, AContract_no_input);
			waitForElement(driver, AContractNumsearch);
			safeclick(driver, AContractNumsearch);
			waitForElement(driver, Ainputcontractnum);
			twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
		
			waitForElement(driver, Slab_ChkBox);
			checkBox(driver, Slab_ChkBox, Slab_CheckBox);

			// OPTION OF SELECTING THE CHECK BOX
		
			if (isElementAccessible(driver, AslabboxADD)) {
			
				waitForElement(driver, AslabboxADD);
				safeclick(driver, AslabboxADD);
				waitForElement(driver, AslabboxADDTodays);
			
				doubleClick(driver, AslabboxADDTodays);
			
				Actionsendkeys(driver, AslabboxADDTodays, todayenter);
			
				waitForElement(driver, AslabboxADDperdiem);
			
				doubleClick(driver, AslabboxADDperdiem);
				
			
				Actionsendkeys(driver, APer_Diem_Input, perdiem);
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
				System.out.println("Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is selected and filled with data");
			} else {

				System.out.println("Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is not selected and filled with data");
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

			// Handle charges input
			if (!handelcharges.equals("")) {
				waitForElement(driver, AHandling_Charges);
				sendKeys(driver, AHandling_Charges, handelcharges);
			}

	// Equipment quantity input 
			if (!equipmentque.equals("")) {

				waitForElement(driver, AEquipment_Quantaty);
				sendKeys(driver, AEquipment_Quantaty, equipmentque);
			}
	// pickup credit input
			if (!pickupcredit.equals("")) {
				waitForElement(driver, APick_Up_Credit);
				sendKeys(driver, APick_Up_Credit, pickupcredit);
			}

			// Remarks input

			if (!Remarks_input.equals("")) {
				waitForElement(driver, ARemarks_Input);
				sendKeys(driver, ARemarks_Input, Remarks_input);
			}

			// Selecting the From Date
			waitForElement(driver, AFrom_Date);
			if (From_date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, AFrom_Date);
				selectDatePicker(driver, AFrom_Date, From_Date_Input);
			} else {
				waitForElement(driver, AFrom_Date);
				clearAndType(driver, AFrom_Date, From_Date_Input);
			}
			
			// Selecting the to Date
			
			waitForElement(driver, A_To_Date);
			if (To_Date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, A_To_Date);
				selectDatePicker(driver, A_To_Date, To_Date_Input);
			} else {
				waitForElement(driver, A_To_Date);
				clearAndType(driver, A_To_Date, To_Date_Input);
			}
			
	// selecting oneway check box

			// Selecting the Equipment type

			if (Equipment_type_perform.equals("YES")) {

				List<String> datas = splitAndExpand(Equipmenttype_Input);
				for (String data : datas) {
			
					waitForElement(driver, AEquipment_Type_add_button);
					safeclick(driver, AEquipment_Type_add_button);
					waitForElement(driver, equipmenttypevalueenter);
					twoColumnSearchWindow(driver, Equipment_Type_Search, Condition_Filter, data);
					
				}
			} else {
				System.out.println("Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added");
				Extent_fail(driver, "Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added", test, test1);
			}

			// Selecting the location

			if (Add_location_port_perform.equals("YES")) {

				List<String> datas = splitAndExpand(Add_location_port_input);
				for (String data : datas) {
			
					waitForElement(driver, ALocation_Add_Button);
					safeclick(driver, ALocation_Add_Button);
					twoColumnSearchWindow(driver, Location_Search, Condition_Filter, data);
					
				}
			} else {
				System.out.println("Expected Result is : Location  should  be added || Actual Result is : Location not  added");
				Extent_fail(driver, "Expected Result is : Location  should  be added || Actual Result is : Location not  added", test, test1);
			}

			// Entering Scalin reference
			if (!Scale_Reference_no.equals("")) {
				waitForElement(driver, AScale_in_ref_input);
				safeclick(driver, AScale_in_ref_input);
				sendKeys(driver, AScale_in_ref_input, Scale_Reference_no);
				safeclick(driver, ARemarks_Input);

			} else {
				System.out.println("scaleout reference value was not entered");
				Extent_fail(driver, "scaleout reference value was not entered", test, test1);
			}
			Step_Start(1, " Ensure system should validate if user try to add data into grid while Equipment Qty field is blank  ",test, test1);

	//Adding the values into the grid

			waitForElement(driver, AGried_Add_Button);
			safeclick(driver, AGried_Add_Button);
		
			Step_Start(2, "Ensure that system should validate as 'Enter the Equipment Quantity''",test, test1);
		   waitForPopup(driver, Popup_Message, PopUpforsaved);
			String Actualpopmsg11 = getText(driver, Popup_Message);
			System.out.println(Actualpopmsg11);

			if (PopUpforsaved.equals(Actualpopmsg11)) {
				System.out.println("Matched || " + " Expected popup is : " + PopUpforsaved + " || Actual popup is : "
						+ Actualpopmsg11);
				Extent_pass_New(driver, "Matched || " + " Expected popup is : " + PopUpforsaved + " || Actual popup is : "
						+ Actualpopmsg11, test, test1);
				
				
			} else {
				System.out.println("Not matched || " + " Expected popup is : " + PopUpforsaved
						+ " || Actual popup is : " + Actualpopmsg11);
				Extent_fail(driver, "Not matched || " + " Expected popup is : " + PopUpforsaved
						+ " || Actual popup is : " + Actualpopmsg11, test, test1);
			

			}
			Step_End(1, " Ensure system should validate if user try to add data into grid while Equipment Qty field is blank  ",test, test1);
			Step_End(2, "Ensure that system should validate as 'Enter the Equipment Quantity''",test, test1);
			Extent_completed(testcase_Name, test, test1);

			
			
		}
	     
	     scrollTop(driver);
	     click(driver, Close_Current_tab); 		

 int LT7=7;
	     
	     if(LT7==7) {
	    	 
	    	 String testcase_Name = "TC_Scale_In_TS_027_IP";
	 		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
	 		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
	 		System.out.println(Sheet_Name);

	 		Map<String, String> data27 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
	 		String Search = data27.get("Search_input");
	 		String contractnum = data27.get("Contract_No");
	 		String Slab_CheckBox = data27.get("Slab_CheckBox");
	 		String Reference_Type = data27.get("Reference_Type");
	 		String Condition_Filter = data27.get("Condition_Filter");
	 		String Contract_Number_Search = data27.get("Contract_Number_Search");
	 		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
	 		Extent_Start(testcase_Name, test, test1);
	 		
	 		
	 		moduleNavigate(driver, Search);
			waitForElement(driver, Reference_Type_Field);
			safeclick(driver, Reference_Type_Field);
		
			
				waitForElement(driver, ReferenceType_Select);
				safeclick(driver, ReferenceType_Select);
			
			waitForElement(driver, AContract_no_input);
			waitForElement(driver, AContractNumsearch);
			safeclick(driver, AContractNumsearch);
			waitForElement(driver, Ainputcontractnum);
			twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
			Step_Start(1, "Ensure system should allow user to select checkbox for slab''",test, test1);

			// before selecting the slab box

			waitForElement(driver, Slab_ChkBox);
			if (!isElementAccessible(driver, AslabboxADD)) {
				System.out.println("Expected Result is :Add button in slab should not be enable before selecting the slab box ||Actual Result is :Add button in slab is not  enabled before selecting the slab box");
				Extent_pass_New(driver, "Expected Result is :Add button in slab should not be enable before selecting the slab box ||Actual Result is :Add button in slab is not  enabled before selecting the slab box", test, test1);

			} else {
				System.out.println("Expected Result is :Add button in slab should not be enable before selecting the slab box ||Actual Result is :Add button in slab is  enabled before selecting the slab box");
				Extent_fail(driver, "Expected Result is :Add button in slab should not be enable before selecting the slab box ||Actual Result is :Add button in slab is  enabled before selecting the slab box", test, test1);
				
			}
			if (!isElementAccessible(driver, REMOVEBUTTON)) {
				System.out.println("Expected Result is :Remove button in slab should not be enable before selecting the slab box ||Actual Result is :Remove button in slab is not  enabled before selecting the slab box");
				Extent_pass_New(driver, "Expected Result is :Remove button in slab should not be enable before selecting the slab box ||Actual Result is :Remove button in slab is not  enabled before selecting the slab box", test, test1);

			} else {
				System.out.println("Expected Result is :Remove button in slab should not be enable before selecting the slab box ||Actual Result is :Remove button in slab is  enabled before selecting the slab box");
				Extent_fail(driver, "Expected Result is :Remove button in slab should not be enable before selecting the slab box ||Actual Result is :Remove button in slab is  enabled before selecting the slab box", test, test1);
				
			}
			Step_End(1, "Ensure system should allow user to select checkbox for slab''",test, test1);
			Step_Start(2, "Ensure that system should enable Add & remove button only when Slab checkbox is selected'",test, test1);
	// After selecting the slab box

			waitForElement(driver, Slab_ChkBox);
			checkBox(driver, Slab_ChkBox, Slab_CheckBox);
			System.out.println("Slab box Status:" + Slab_CheckBox);
			
			
			
		
			
			
			// OPTION OF SELECTING THE CHECK BOX
			waitForElement(driver, Slab_ChkBox);
			if (isElementAccessible(driver, AslabboxADD)) {
				System.out.println("Expected Result is :Add button in the slab should be enable ||Actual Result is :Add button in the slab is enable");
				Extent_pass_New(driver, "Expected Result is :Add button in the slab should be enable ||Actual Result is :Add button in the slab is enable", test, test1);
			} else {
				System.out.println("Expected Result is :Add button in the slab should be enable ||Actual Result is :Add button in the slab is not enable");
				Extent_fail(driver, "Expected Result is :Add button in the slab should be enable ||Actual Result is :Add button in the slab is not enable", test, test1);
				
			}
			if (isElementAccessible(driver, REMOVEBUTTON)) {
				System.out.println("Expected Result is :Remove button in the slab should be enable ||Actual Result is :Remove button in the slab is enable");
				Extent_pass_New(driver, "Expected Result is :Remove button in the slab should be enable ||Actual Result is :Remove button in the slab is enable", test, test1);
			} else {
				System.out.println("Expected Result is :Remove button in the slab should be enable ||Actual Result is :Remove button in the slab is not enable");
				Extent_fail(driver, "Expected Result is :Remove button in the slab should be enable ||Actual Result is :Remove button in the slab is not enable", test, test1);
				

			}
			Step_End(2, "Ensure that system should enable Add & remove button only when Slab checkbox is selected'",test, test1);
			Extent_completed(testcase_Name, test, test1);
	     }
	     scrollTop(driver);
	   
	     click(driver, Close_Current_tab); 		

 int LT8=8;
	     
	     if(LT8==8) {
	    	 
	    	 
	    		String testcase_Name = "TC_Scale_In_TS_028_IP";
	    		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
	    		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
	    		System.out.println(Sheet_Name);

	    		Map<String, String> data28 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
	    		String Search = data28.get("Search_input");
	    		String contractnum = data28.get("Contract_No");
	    		String Slab_CheckBox = data28.get("Slab_CheckBox");
	    		String Reference_Type = data28.get("Reference_Type");
	    		String TODAYS = data28.get("TODAYS");
	    		String Condition_Filter = data28.get("Condition_Filter");
	    		String perdiem = data28.get("Per_Diem");
	    		String PopUpforsaved = data28.get("PopUpforsaved");
	    		String Contract_Number_Search = data28.get("Contract_Number_Search");
	    		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
	    		Extent_Start(testcase_Name, test, test1);
	    		
	    		
	    		moduleNavigate(driver, Search);
	    		waitForElement(driver, Reference_Type_Field);
	    		safeclick(driver, Reference_Type_Field);
	    		
	    			
	    			waitForElement(driver, ReferenceType_Select);
	    			safeclick(driver, ReferenceType_Select);
	    		
	    		waitForElement(driver, AContract_no_input);
	    		waitForElement(driver, AContractNumsearch);
	    		safeclick(driver, AContractNumsearch);
	    		waitForElement(driver, Ainputcontractnum);
	    		twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
	    		
	    		Step_Start(1, "Ensure system should allow user to select checkbox for slab''",test, test1);
	    		waitForElement(driver, Slab_ChkBox);
	    		checkBox(driver, Slab_ChkBox, Slab_CheckBox);

	    		// OPTION OF SELECTING THE CHECK BOX
	    		waitForElement(driver, AslabboxADD);
	    		if (isElementAccessible(driver, AslabboxADD)) {
	    		
	    			waitForElement(driver, AslabboxADD);
	    			safeclick(driver, AslabboxADD);
	    			waitForElement(driver, AslabboxADDTodays);
	    		
	    			doubleClick(driver, AslabboxADDTodays);
	    		
	    			Actionsendkeys(driver, AslabboxADDTodays, TODAYS);
	    			
	    			waitForElement(driver, AslabboxADDperdiem);
	    			
	    			doubleClick(driver, AslabboxADDperdiem);
	    		
	    			Actionsendkeys(driver, APer_Diem_Input, perdiem);
	    			waitForElement(driver, AScale_in_pickup_charges);
	    			safeclick(driver, AScale_in_pickup_charges);
	    			waitForElement(driver, AslabboxADD);
	    			safeclick(driver, AslabboxADD);
	    		} else {
	    			System.out.println("Slab box was not selected");
	    		}
	    		Step_End(1, "Ensure system should allow user to select checkbox for slab''",test, test1);
	    		Step_Start(2, "Ensure that system should validate when user try to add To slab lesser then From slab'",test, test1);
	    		Step_Start(3, "Ensure that system should validate as 'Enter the To Slab greater than From Slab for the Sz./Tp'.",test, test1);
	    		
	    		waitForPopup(driver, Popup_Message, PopUpforsaved);
	    		String Actualpopmsg7 = getText(driver, Popup_Message);
	    		System.out.println(Actualpopmsg7);
	    		if (PopUpforsaved.equals(Actualpopmsg7)) {
	    			System.out.println("Matched || " + " Expected popup is : " + PopUpforsaved + " || Actual popup is : "
	    					+ Actualpopmsg7);
	    			Extent_pass_New(driver, "Matched || " + " Expected popup is : " + PopUpforsaved + " || Actual popup is : "
	    					+ Actualpopmsg7, test, test1);
	    			Extent_call(test, test1, "**popup was shown as*** "+Actualpopmsg7);
	    		} else {
	    			System.out.println("Not matched || " + " Expected popup is : " + PopUpforsaved
	    					+ " || Actual popup is : " + Actualpopmsg7);
	    			Extent_fail(driver, "Not matched || " + " Expected popup is : " + PopUpforsaved
	    					+ " || Actual popup is : " + Actualpopmsg7, test, test1);
	    			
	    		}
	    		Step_End(2, "Ensure that system should validate when user try to add To slab lesser then From slab'",test, test1);
	    		Step_End(3, "Ensure that system should validate as 'Enter the To Slab greater than From Slab for the Sz./Tp'.",test, test1);
	    		Extent_completed(testcase_Name, test, test1);
	    		
			
			
		}
	     
	     scrollTop(driver);
	     click(driver, Close_Current_tab); 		

 int LT9=9;
	     
	     if(LT9==9) {
	    	 
	    	 String testcase_Name = "TC_Scale_In_TS_029_IP";
	 		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
	 		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
	 		System.out.println(Sheet_Name);

	 		Map<String, String> data29 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
	 		
	 		String Search = data29.get("Search_input");
	 		String contractnum = data29.get("Contract_No");
	 		
	 		String savedpopexp = data29.get("PopUpforsaved");
	 		String todayenter = data29.get("TODAYS");
	 		String Condition_Filter = data29.get("Condition_Filter");
	 		String Slab_CheckBox = data29.get("Slab_CheckBox");
	 		
	 		String Reference_Type = data29.get("Reference_Type");
	 		String Contract_Number_Search = data29.get("Contract_Number_Search");
	 		String per_diem_slap = data29.get("per_diem_slap");
	 		
	 		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
	 		Extent_Start(testcase_Name, test, test1);
	 		
	 		
	 		moduleNavigate(driver, Search);
			waitForElement(driver, Reference_Type_Field);
			safeclick(driver, Reference_Type_Field);
			
			
			waitForElement(driver, ReferenceType_Select);
			safeclick(driver, ReferenceType_Select);
			
			waitForElement(driver, AContract_no_input);
			waitForElement(driver, AContractNumsearch);
			safeclick(driver, AContractNumsearch);
			waitForElement(driver, Ainputcontractnum);
			twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
			
			Step_Start(1, "Ensure system should allow user to select checkbox for slab''",test, test1);
			waitForElement(driver, Slab_ChkBox);
			checkBox(driver, Slab_ChkBox, Slab_CheckBox);
			Step_End(1, "Ensure system should allow user to select checkbox for slab''",test, test1);
			// OPTION OF SELECTING THE CHECK BOX
			
			Step_Start(2, "Ensure that system should validate when user try to add slab without giving Per Diem'",test, test1);
			Step_Start(3, "Ensure that system should validate as 'Enter The Perdiem Value'.m'",test, test1);
			if(isElementAccessible(driver, AslabboxADD)) {
				
				waitForElement(driver, AslabboxADD);
				safeclick(driver, AslabboxADD);
				waitForElement(driver, AslabboxADDTodays);
			
				doubleClick(driver, AslabboxADDTodays);
				
				Actionsendkeys(driver, AslabboxADDTodays, todayenter);
				
				waitForElement(driver, AslabboxADDperdiem);
				
				doubleClick(driver, AslabboxADDperdiem);
	waitForElement(driver, APer_Diem_Input);	
	sendKeys(driver, APer_Diem_Input, per_diem_slap);
				waitForElement(driver, AScale_in_pickup_charges);
				safeclick(driver, AScale_in_pickup_charges);
				
				waitForElement(driver, AslabboxADD);
				safeclick(driver, AslabboxADD);

				waitForPopup(driver, popup_Message, savedpopexp);
				String Actualpopmsg7=getText(driver,popup_Message);
				System.out.println(Actualpopmsg7);
				if (savedpopexp.equals(Actualpopmsg7)) {
					System.out
							.println("Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : " + Actualpopmsg7);
					Extent_pass_New(driver,
							"Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : " + Actualpopmsg7,test,test1);
					
					Extent_call(test, test1, "**popup was shown as*** "+Actualpopmsg7);
				} else {
					System.out.println(
							"Not matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : " + Actualpopmsg7);
					Extent_fail(driver,
							"Not matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : " + Actualpopmsg7,test,test1);
					
				}

	waitForElement(driver, popup_Message_Ok_Button);
	safeclick(driver, popup_Message_Ok_Button);

	Step_End(2, "Ensure that system should validate when user try to add slab without giving Per Diem'",test, test1);
	Step_End(3, "Ensure that system should validate as 'Enter The Perdiem Value'.m'",test, test1);
	Extent_completed(testcase_Name, test, test1);


	    }


	 }
	 		
	 	    scrollTop(driver);
		 
		     click(driver, Close_Current_tab); 		

	 int LT10=10;
		     
		     if(LT10==10) {
		    	 
		    		String testcase_Name = "TC_Scale_In_TS_030_IP";
		    		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
		    		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
		    		System.out.println(Sheet_Name);

		    		Map<String, String> data30 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
		    		
		    	
		    		
		    		String Search = data30.get("Search_input");
		    		String savedpopexp = data30.get("PopUpforsaved");
		    		
		    		String Reference_Type = data30.get("Reference_Type");
		    		
		    		String Contract_No = data30.get("Contract_No");
		    		String Scale_Reference_no = data30.get("Scale_Reference_no");
		    		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
		    		Extent_Start(testcase_Name, test, test1);
		    		
		    		
		    		moduleNavigate(driver, Search);
		    		waitForElement(driver, Reference_Type_Field);
		    		safeclick(driver, Reference_Type_Field);
		    		
		    			
		    			waitForElement(driver, ReferenceType_Select);
		    			safeclick(driver, ReferenceType_Select);
		    			Step_Start(1, "Ensure system should allow user to enter scale-in ref",test, test1);
		    		// Entering Scalin reference
		    		if (!Scale_Reference_no.equals("")) {
		    			waitForElement(driver, AScale_in_ref_input);
		    			safeclick(driver, AScale_in_ref_input);
		    			sendKeys(driver, AScale_in_ref_input, Scale_Reference_no);
		    			safeclick(driver, ARemarks_Input);

		    		} else {
		    			System.out.println("Expected Result is : scaleout reference value should entered || Actual Result is : scaleout reference value is not  entered");
		    		}
		    		Step_End(1, "Ensure system should allow user to enter scale-in ref",test, test1);
		    		Step_Start(2, "Ensure that system should validate if invalid contract is entered & clicked tab for Contract No. field",test, test1);
		    // Entering contract number

		    		waitForElement(driver, AContract_no_input);

		    		sendKeys(driver, AContract_no_input, Contract_No);
		    		enter(driver);
		    		Step_Start(3, " Ensure that system should validate as 'Invalid Supplier Reference'.",test, test1);
		    		waitForPopup(driver, Popup_Message, savedpopexp);
		    		String Actualpopmsg9 = getText(driver, Popup_Message);
		    		System.out.println(Actualpopmsg9);

		    		if (savedpopexp.equals(Actualpopmsg9)) {
		    			System.out.println("Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
		    					+ Actualpopmsg9);
		    			Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
		    					+ Actualpopmsg9, test, test1);
		    			
		    			Extent_call(test, test1, "**popup was shown as*** "+Actualpopmsg9);
		    		} else {
		    			System.out.println("Not matched || " + " Expected popup is : " + savedpopexp
		    					+ " || Actual popup is : " + Actualpopmsg9);
		    			Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedpopexp
		    					+ " || Actual popup is : " + Actualpopmsg9, test, test1);
		    			
		    		}
		    		Step_End(2, "Ensure that system should validate if invalid contract is entered & clicked tab for Contract No. field",test, test1);
		    		Step_End(3, " Ensure that system should validate as 'Invalid Supplier Reference'.",test, test1);
		    		
		    		Extent_completed(testcase_Name, test, test1);
		    	}
		     scrollTop(driver);
		 
		     click(driver, Close_Current_tab); 		

	 int LT11=11;
		     
		     if(LT11==11) {
		    	 
		    		String testcase_Name = "TC_Scale_In_TS_031_IP";
		    		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
		    		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
		    		System.out.println(Sheet_Name);

		    		Map<String, String> data31 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

		    		

		    		String Search = data31.get("Search_input");
		    		String contractnum = data31.get("Contract_No");
		    		String scalerefno = data31.get("Scale_Reference_no");
		    		String freedays = data31.get("Free_Days");
		    		String perdiem = data31.get("Per_Diem");
		    		String handelcharges = data31.get("Handles_Charges");
		    		String equipmentque = data31.get("equipment_Quantity");
		    		String pickupcredit = data31.get("PickUp_Credit");
		    		String Pickupcharges = data31.get("Scale_in_pickup_charges");
		    		String savedpopexp = data31.get("PopUpforsaved");
		    		String todayenter = data31.get("TODAYS");
		    		String secondtodayinput = data31.get("secondtoday");
		    		String secondtodayinputdem = data31.get("seconddiem");
		    		String Slab_CheckBox = data31.get("Slab_CheckBox");
		    		String One_Way_CheckBox = data31.get("One_Way_CheckBox");
		    		String Equipment_type_perform = data31.get("Equipment_type_perform");
		    		String Reference_Type = data31.get("Reference_Type");
		    		String From_Date_Input = data31.get("From_Date_Input");
		    		String To_Date_Input = data31.get("To_Date_Input");
		    		String Equipmenttype_Input = data31.get("Equipmenttype_Input");
		    		String Add_location_port_perform = data31.get("Add_location_port_perform");
		    		String Add_location_port_input = data31.get("Add_location_port_input");
		    		String Remarks_input = data31.get("Remarks_input");
		    		String per_diem_slap = data31.get("per_diem_slap");
		    		String From_date_perform = data31.get("From_date_perform");
		    		String To_Date_perform = data31.get("To_Date_perform");
		    		String Condition_Filter = data31.get("Condition_Filter");
		    		String Contract_Number_Search = data31.get("Contract_Number_Search");
		    		String Equipment_Type_Search = data31.get("Equipment_Type_Search");
		    		String Location_Search = data31.get("Location_Search");
		    		
		    		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
		    		Extent_Start(testcase_Name, test, test1);
		    		
		    		
		    		moduleNavigate(driver, Search);
		    		waitForElement(driver, Reference_Type_Field);
		    		safeclick(driver, Reference_Type_Field);
		    	
		    		
		    			waitForElement(driver, ReferenceType_Select);
		    			safeclick(driver, ReferenceType_Select);
		    		
		    		waitForElement(driver, AContract_no_input);
		    		waitForElement(driver, AContractNumsearch);
		    		safeclick(driver, AContractNumsearch);
		    		waitForElement(driver, Ainputcontractnum);
		    		twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
		    	
		    		waitForElement(driver, Slab_ChkBox);
		    		checkBox(driver, Slab_ChkBox, Slab_CheckBox);

		    		// OPTION OF SELECTING THE CHECK BOX
		    		
		    		if (isElementAccessible(driver, AslabboxADD)) {
		    			
		    			waitForElement(driver, AslabboxADD);
		    			safeclick(driver, AslabboxADD);
		    		
		    			waitForElement(driver, AslabboxADDTodays);
		    			
		    			doubleClick(driver, AslabboxADDTodays);
		    			
		    			Actionsendkeys(driver, AslabboxADDTodays, todayenter);
		    			
		    			waitForElement(driver, AslabboxADDperdiem);
		    			
		    			doubleClick(driver, AslabboxADDperdiem);
		    			
		    			Actionsendkeys(driver, APer_Diem_Input, per_diem_slap);
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
		    			System.out.println("Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is selected and filled with data");
		    		} else {

		    			System.out.println("Expected Result is : slab box should be selected and filled with data || Actual Result is : slab box is not selected and filled with data");
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
		    			//wait(driver, "1");
		    		}

		    // scalein pickup charges input
		    		if (!Pickupcharges.equals("")) {

		    			waitForElement(driver, AScale_in_pickup_charges);
		    			sendKeys(driver, AScale_in_pickup_charges, Pickupcharges);
		    		}

		    		// Handle charges input
		    		if (!handelcharges.equals("")) {
		    			waitForElement(driver, AHandling_Charges);
		    			sendKeys(driver, AHandling_Charges, handelcharges);
		    		}

		    // Equipment quantity input 
		    		if (!equipmentque.equals("")) {
		    			waitForElement(driver, AEquipment_Quantaty);
		    			sendKeys(driver, AEquipment_Quantaty, equipmentque);
		    		}
		    // pickup credit input
		    		if (!pickupcredit.equals("")) {
		    			waitForElement(driver, APick_Up_Credit);
		    			sendKeys(driver, APick_Up_Credit, pickupcredit);
		    		}

		    		// Remarks input

		    		if (!Remarks_input.equals("")) {
		    			waitForElement(driver, ARemarks_Input);
		    			sendKeys(driver, ARemarks_Input, Remarks_input);
		    		}

		    		// Selecting the From Date
		    		waitForElement(driver, AFrom_Date);
		    		if (From_date_perform.equalsIgnoreCase("Yes")) {
		    			waitForElement(driver, AFrom_Date);
		    			selectDatePicker(driver, AFrom_Date, From_Date_Input);
		    		} else {
		    			waitForElement(driver, AFrom_Date);
		    			clearAndType(driver, AFrom_Date, From_Date_Input);
		    		}
		    		
		    		// Selecting the to Date
		    		
		    		waitForElement(driver, A_To_Date);
		    		if (To_Date_perform.equalsIgnoreCase("Yes")) {
		    			waitForElement(driver, A_To_Date);
		    			selectDatePicker(driver, A_To_Date, To_Date_Input);
		    		} else {
		    			waitForElement(driver, A_To_Date);
		    			clearAndType(driver, A_To_Date, To_Date_Input);
		    		}
		    		
		    				Step_Start(2, " Ensure that system should allow user to select one way check box",test, test1);
		    // selecting oneway check box

		    		waitForElement(driver, OneWay_ChkBox);

		    		checkBox(driver, OneWay_ChkBox, One_Way_CheckBox);
		    		Step_Start(3, " Ensure that system should validate if user not given return location",test, test1);
		    		if (One_Way_CheckBox.equals("YES")) {

		    			System.out.println("Expected Result is : One way check box should selected and return location was not added || Actual Result is : One way check box is selected and return location was not added");

		    		} else {
		    			System.out.println("Expected Result is : One way check box should selected and return location was not added || Actual Result is : One way check box is not selected and return location was not added");
		    		}
		    		Step_End(2, " Ensure that system should allow user to select one way check box",test, test1);
		    		Step_End(3, " Ensure that system should validate if user not given return location",test, test1);

		    		// Selecting the Equipment type

		    		if (Equipment_type_perform.equals("YES")) {

		    			List<String> datas = splitAndExpand(Equipmenttype_Input);
		    			for (String data : datas) {
		    			
		    				waitForElement(driver, AEquipment_Type_add_button);
		    				safeclick(driver, AEquipment_Type_add_button);
		    				twoColumnSearchWindow(driver, Equipment_Type_Search, Condition_Filter, data);

		    			}
		    		} else {
		    			System.out.println("Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added");
		    			Extent_fail(driver, "Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added", test, test1);
		    		}

		    		// Selecting the location

		    		if (Add_location_port_perform.equals("YES")) {

		    			List<String> datas = splitAndExpand(Add_location_port_input);
		    			for (String data : datas) {
		    				
		    				waitForElement(driver, ALocation_Add_Button);
		    				safeclick(driver, ALocation_Add_Button);
		    				twoColumnSearchWindow(driver, Location_Search, Condition_Filter, data);
		    					
		    				
		    			}
		    		} else {
		    			System.out.println("Expected Result is : Location  should  be added || Actual Result is : Location not  added");
		    			Extent_fail(driver, "Expected Result is : Location  should  be added || Actual Result is : Location not  added", test, test1);
		    		}
		    		Step_Start(1, " Ensure system should allow user to enter scale-in ref'",test, test1);
		    		// Entering Scalin reference
		    		if (!scalerefno.equals("")) {
		    			waitForElement(driver, AScale_in_ref_input);
		    			safeclick(driver, AScale_in_ref_input);
		    			sendKeys(driver, AScale_in_ref_input, scalerefno);
		    			safeclick(driver, ARemarks_Input);
		    		}
		    		Step_End(1, " Ensure system should allow user to enter scale-in ref'",test, test1);
		    // Adding the values into the grid

		    		waitForElement(driver, AGried_Add_Button);
		    		safeclick(driver, AGried_Add_Button);
		    		

		    		// Saving the records

		    		waitForElement(driver, SaveButton_ToolBar);
		    		safeclick(driver, SaveButton_ToolBar);
		    		Step_Start(4, "  Ensure that system should validate as 'Enter the Return location'.",test, test1);

		    		waitForPopup(driver, Popup_Message, savedpopexp);
		    		String Actualpopmsg = getText(driver, Popup_Message);
		    		System.out.println(Actualpopmsg);

		    		if (savedpopexp.equals(Actualpopmsg)) {
		    			System.out.println("Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
		    					+ Actualpopmsg);
		    			Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
		    					+ Actualpopmsg, test, test1);
		    			
		    			Extent_call(test, test1, "**popup was shown as*** "+Actualpopmsg);
		    			
		    		} else {
		    			System.out.println("Not matched || " + " Expected popup is : " + savedpopexp
		    					+ " || Actual popup is : " + Actualpopmsg);
		    			Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedpopexp
		    					+ " || Actual popup is : " + Actualpopmsg, test, test1);
		    			
		    		}
		    		Step_End(4, "  Ensure that system should validate as 'Enter the Return location'.",test, test1);
		    		Extent_completed(testcase_Name, test, test1);
		    		}

		     
		     scrollTop(driver);
		  
		     click(driver, Close_Current_tab); 		

	 int LT12=12;
		     
		     if(LT12==12) {
		    	 

		 		String testcase_Name = "TC_Scale_In_TS_032_IP";
		 		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
		 		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
		 		System.out.println(Sheet_Name);

		 		Map<String, String> data32 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

		 		String Search = data32.get("Search_input");
		 		String contractnum = data32.get("Contract_No");
		 		String scalerefno = data32.get("Scale_Reference_no");
		 		String freedays = data32.get("Free_Days");
		 		String perdiem = data32.get("Per_Diem");
		 		String handelcharges = data32.get("Handles_Charges");
		 		String equipmentque = data32.get("equipment_Quantity");
		 		String pickupcredit = data32.get("PickUp_Credit");
		 		String Pickupcharges = data32.get("Scale_in_pickup_charges");
		 		String savedpopexp = data32.get("PopUpforsaved");
		 		
		 		String Equipment_type_perform = data32.get("Equipment_type_perform");
		 		String Reference_Type = data32.get("Reference_Type");
		 		String Condition_Filter = data32.get("Condition_Filter");
		 		
		 		String From_Date_Input = data32.get("From_Date_Input");
		 		String To_Date_Input = data32.get("To_Date_Input");
		 		
		 		String Equipmenttype_Input = data32.get("Equipmenttype_Input");
		 		String Add_location_port_perform = data32.get("Add_location_port_perform");
		 		String Add_location_port_input = data32.get("Add_location_port_input");
		 		
		 		String Remarks_input = data32.get("Remarks_input");
		 		
		 		String pickupcredit_1 = data32.get("PickUp_Credit_1");
		 		String equipmentque_1 = data32.get("equipment_Quantity_1");
		 		String handelcharges_1 = data32.get("Scale_in_pickup_charges_1");
		 		String Pickupcharges_1 = data32.get("Scale_in_pickup_charges_1");
		 		String freedays_1 = data32.get("Free_Days_1");
		 		String perdiem_1 = data32.get("Per_Diem_1");
		 		String From_date_perform = data32.get("From_date_perform");
		 		String To_Date_perform = data32.get("To_Date_perform");
		 		String Contract_Number_Search = data32.get("Contract_Number_Search");
		 		String Equipment_Type_Search = data32.get("Equipment_Type_Search");
		 		String Location_Search = data32.get("Location_Search");
		 		
		 		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
		 		Extent_Start(testcase_Name, test, test1);
		 		
		 		
		 		moduleNavigate(driver, Search);
				waitForElement(driver, Reference_Type_Field);
				safeclick(driver, Reference_Type_Field);
				
				
					waitForElement(driver, ReferenceType_Select);
					safeclick(driver, ReferenceType_Select);
				
				waitForElement(driver, AContract_no_input);
				waitForElement(driver, AContractNumsearch);
				safeclick(driver, AContractNumsearch);
				waitForElement(driver, Ainputcontractnum);
				twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
				
			
				Step_Start(1, "Ensure system should allow user to enter scale-in ref",test, test1);
				// Entering Scalin reference

				if (!scalerefno.equals("")) {
					waitForElement(driver, AScale_in_ref_input);
					safeclick(driver, AScale_in_ref_input);
					sendKeys(driver, AScale_in_ref_input, scalerefno);
					safeclick(driver, ARemarks_Input);
				}
				Step_End(1, "Ensure system should allow user to enter scale-in ref",test, test1);
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

				// Handle charges input
				if (!handelcharges.equals("")) {
					waitForElement(driver, AHandling_Charges);
					sendKeys(driver, AHandling_Charges, handelcharges);
				}

		// Equipment quantity input 
				if (!equipmentque.equals("")) {
					waitForElement(driver, AEquipment_Quantaty);
					sendKeys(driver, AEquipment_Quantaty, equipmentque);
				}
		// pickup credit input
				if (!pickupcredit.equals("")) {
					waitForElement(driver, APick_Up_Credit);
					sendKeys(driver, APick_Up_Credit, pickupcredit);
				}

		// Remarks input

				if (!Remarks_input.equals("")) {
					waitForElement(driver, ARemarks_Input);
					sendKeys(driver, ARemarks_Input, Remarks_input);
				}

				// Selecting the From Date
				waitForElement(driver, AFrom_Date);
				if (From_date_perform.equalsIgnoreCase("Yes")) {
					waitForElement(driver, AFrom_Date);
					selectDatePicker(driver, AFrom_Date, From_Date_Input);
				} else {
					waitForElement(driver, AFrom_Date);
					clearAndType(driver, AFrom_Date, From_Date_Input);
				}
				
				// Selecting the to Date
				
				waitForElement(driver, A_To_Date);
				if (To_Date_perform.equalsIgnoreCase("Yes")) {
					waitForElement(driver, A_To_Date);
					selectDatePicker(driver, A_To_Date, To_Date_Input);
				} else {
					waitForElement(driver, A_To_Date);
					clearAndType(driver, A_To_Date, To_Date_Input);
				}
				
				// Selecting the Equipment type

				if (Equipment_type_perform.equals("YES")) {

					List<String> datas = splitAndExpand(Equipmenttype_Input);
					for (String data : datas) {
					
						waitForElement(driver, AEquipment_Type_add_button);
						safeclick(driver, AEquipment_Type_add_button);
						waitForElement(driver, equipmenttypevalueenter);
						twoColumnSearchWindow(driver, Equipment_Type_Search, Condition_Filter, data);
						
					}
				} else {
					System.out.println("Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added");
					Extent_fail(driver, "Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added", test, test1);
				}

				// Selecting the location

				if (Add_location_port_perform.equals("YES")) {

					List<String> datas = splitAndExpand(Add_location_port_input);
					for (String data : datas) {
						
						waitForElement(driver, ALocation_Add_Button);
						safeclick(driver, ALocation_Add_Button);
						twoColumnSearchWindow(driver, Location_Search, Condition_Filter, data);
						
					}
				} else {
					System.out.println("Expected Result is : Location  should  be added || Actual Result is : Location not  added");
					Extent_fail(driver, "Expected Result is : Location  should  be added || Actual Result is : Location not  added", test, test1);
				}
				Step_Start(2, "Ensure that system should allow user to data into grid once all mandatory field is filled",test, test1);
		// Adding the values into the grid

				waitForElement(driver, AGried_Add_Button);
				safeclick(driver, AGried_Add_Button);
				
				Step_End(2, "Ensure that system should allow user to data into grid once all mandatory field is filled",test, test1);
				Step_Start(3, " Ensure that system should validate if user try to add same size/type & location mulitple times",test, test1);
				// Again data adding into the gird

				// Perdiem input

				if (!perdiem.equals("")) {
					waitForElement(driver, APer_Diem_Input);
					safeclick(driver, APer_Diem_Input);
					sendKeys(driver, APer_Diem_Input, perdiem_1);
				}
				// Free days input

				if (!freedays.equals("")) {
					waitForElement(driver, AFree_Days_Input);
					safeclick(driver, AFree_Days_Input);
					sendKeys(driver, AFree_Days_Input, freedays_1);
					
				}

				// scalein pickup charges input
				if (!Pickupcharges.equals("")) {

					waitForElement(driver, AScale_in_pickup_charges);
					sendKeys(driver, AScale_in_pickup_charges, Pickupcharges_1);
				}

				// Handle charges input
				if (!handelcharges.equals("")) {
					waitForElement(driver, AHandling_Charges);
					sendKeys(driver, AHandling_Charges, handelcharges_1);
				}

				// Equipment quantity input
				if (!equipmentque.equals("")) {
					waitForElement(driver, AEquipment_Quantaty);
					sendKeys(driver, AEquipment_Quantaty, equipmentque_1);
				}
				// pickup credit input
				if (!pickupcredit.equals("")) {
					waitForElement(driver, APick_Up_Credit);
					sendKeys(driver, APick_Up_Credit, pickupcredit_1);
				}

				// Remarks input

				if (!Remarks_input.equals("")) {
					waitForElement(driver, ARemarks_Input);
					sendKeys(driver, ARemarks_Input, Remarks_input);
				}

				// Selecting the From Date
			
				waitForElement(driver, AFrom_Date);
				if (From_date_perform.equalsIgnoreCase("Yes")) {
					waitForElement(driver, AFrom_Date);
					selectDatePicker(driver, AFrom_Date, From_Date_Input);
				} else {
					waitForElement(driver, AFrom_Date);
					clearAndType(driver, AFrom_Date, From_Date_Input);
				}
				
				// Selecting the to Date
				
				waitForElement(driver, A_To_Date);
				if (To_Date_perform.equalsIgnoreCase("Yes")) {
					waitForElement(driver, A_To_Date);
					selectDatePicker(driver, A_To_Date, To_Date_Input);
				} else {
					waitForElement(driver, A_To_Date);
					clearAndType(driver, A_To_Date, To_Date_Input);
				}
				

				
				// Selecting the Equipment type

				if (Equipment_type_perform.equals("YES")) {

					List<String> datas = splitAndExpand(Equipmenttype_Input);
					for (String data : datas) {
						
						waitForElement(driver, AEquipment_Type_add_button);
						safeclick(driver, AEquipment_Type_add_button);
						waitForElement(driver, equipmenttypevalueenter);
						twoColumnSearchWindow(driver, Equipment_Type_Search, Condition_Filter, data);
						
					}
				} else {
					System.out.println("Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added");
					Extent_fail(driver, "Expected Result is : Equipment type  should  be added || Actual Result is : Equipment  type not  added", test, test1);
				}

				// Selecting the location

				if (Add_location_port_perform.equals("YES")) {

					List<String> datas = splitAndExpand(Add_location_port_input);
					for (String data : datas) {
						
						waitForElement(driver, ALocation_Add_Button);
						safeclick(driver, ALocation_Add_Button);
						twoColumnSearchWindow(driver, Location_Search, Condition_Filter, data);
						
					}
				} else {
					System.out.println("Expected Result is : Location  should  be added || Actual Result is : Location not  added");
					Extent_fail(driver, "Expected Result is : Location  should  be added || Actual Result is : Location not  added", test, test1);
				}

				// Adding the values into the grid

				waitForElement(driver, AGried_Add_Button);
				safeclick(driver, AGried_Add_Button);
				
				Step_Start(4, "  Ensure that system should validate as 'Combination already Exists'.",test, test1);

				waitForPopup(driver, Popup_Message, savedpopexp);
				String Actualpopmsg = getText(driver, Popup_Message);
				System.out.println(Actualpopmsg);

				if (savedpopexp.equals(Actualpopmsg)) {
					System.out.println("Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
							+ Actualpopmsg);
					Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
							+ Actualpopmsg, test, test1);
					Extent_call(test, test1, "**popup was shown as*** "+Actualpopmsg);
				} else {
					System.out.println("Not matched || " + " Expected popup is : " + savedpopexp
							+ " || Actual popup is : " + Actualpopmsg);
					Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedpopexp
							+ " || Actual popup is : " + Actualpopmsg, test, test1);
					
				}
				Step_End(3, " Ensure that system should validate if user try to add same size/type & location mulitple times",test, test1);
				Step_End(4, "  Ensure that system should validate as 'Combination already Exists'.",test, test1);
				Extent_completed(testcase_Name, test, test1);
			}

		 }

}
		     
