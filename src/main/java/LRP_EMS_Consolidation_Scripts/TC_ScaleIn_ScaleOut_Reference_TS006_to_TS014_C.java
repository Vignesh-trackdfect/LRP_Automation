package LRP_EMS_Consolidation_Scripts;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.Scale_In_Out_Reference;

public class TC_ScaleIn_ScaleOut_Reference_TS006_to_TS014_C extends Keywords {
	public void Scalein_scaleout_06_014 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset) throws Exception {


	
		
		int TC=1;

		if(TC==1) {
			String testcase_Name = "TC_Scale_In_TS_006";
			String URL = TestNgXml.getdatafromExecution().get(testcase_Name);
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> dataa = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Username = dataa.get("Username");// 1,2,4-6
			String Password = dataa.get("Password");
			String Search = dataa.get("Search_input");
			String contractnum = dataa.get("Contract_No");
			String scalerefno = dataa.get("Scale_Reference_no");
			String freedays = dataa.get("Free_Days");
			String perdiem = dataa.get("Per_Diem");
			String handelcharges = dataa.get("Handles_Charges");
			String equipmentque = dataa.get("equipment_Quantity");
			String pickupcredit = dataa.get("PickUp_Credit");
			String Pickupcharges = dataa.get("Scale_in_pickup_charges");
			String savedpopexp = dataa.get("PopUpforsaved");
			String One_Way_CheckBox = dataa.get("One_Way_CheckBox");
			String Equipment_type_perform = dataa.get("Equipment_type_perform");
			String Reference_Type = dataa.get("Reference_Type");
			String From_Date_Input = dataa.get("From_Date_Input");
			String To_Date_Input = dataa.get("To_Date_Input");
			String One_way_return_location = dataa.get("One_way_return_location");
			String Equipmenttype_Input = dataa.get("Equipmenttype_Input");
			String Add_location_port_perform = dataa.get("Add_location_port_perform");
			String Add_location_port_input = dataa.get("Add_location_port_input");
			String Remarks_input = dataa.get("Remarks_input");
			String To_Date_perform = dataa.get("To_Date_perform");
			String From_date_perform = dataa.get("From_date_perform");
			String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
			String Coloum_names = dataa.get("Coloum_names");
			String Condition_Filter = dataa.get("Condition_Filter");
			String Contract_Number_Search = dataa.get("Contract_Number_Search");
			String One_Way_Search = dataa.get("One_Way_Search");
			String Equipment_Type_Search = dataa.get("Equipment_Type_Search");
			String Location_Search = dataa.get("Location_Search");
			String Want_To_Delete = dataa.get("Want_To_Delete");

			
			Extent_Start(testcase_Name, test, test1);
			
			
		
			navigateUrl(driver, URL);

		
			// LOGIN
			LRP_Login(driver, Username, Password);
			// searching for module

		
			moduleNavigate(driver, Search);
			

			
			waitForElement(driver, Reference_Type_Field);
			safeclick(driver, Reference_Type_Field);
			
				
				waitForElement(driver, ReferenceType_Select);
				safeclick(driver, ReferenceType_Select);
				Step_Start(2, "Click search icon for Contract No then select required contract ",test, test1);
			
			// Entering the contract number

			waitForElement(driver, AContract_no_input);
			waitForElement(driver, AContractNumsearch);
			safeclick(driver, AContractNumsearch);
			waitForElement(driver, Ainputcontractnum);
			twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
		
		
			Step_End(2, "Click search icon for Contract No then select required contract ",test, test1);
		
			// OPTION OF SELECTING THE CHECK BOX
			

			// Perdiem input
			Step_Start(6, " Enter values for Per Diem in numeric digit ",test, test1);
			if (!perdiem.equals("")) {
				waitForElement(driver, APer_Diem_Input);
				safeclick(driver, APer_Diem_Input);
				sendKeys(driver, APer_Diem_Input, perdiem);
			}
			Step_End(6, " Enter values for Per Diem in numeric digit ",test, test1);
			// Free days input
			Step_Start(5, "-Enter values for free days in numeric digit ",test, test1);
			if (!freedays.equals("")) {
				waitForElement(driver, AFree_Days_Input);
				safeclick(driver, AFree_Days_Input);
				sendKeys(driver, AFree_Days_Input, freedays);
				
			}
			Step_End(5, "-Enter values for free days in numeric digit ",test, test1);
			Step_Start(8, "Enter values for Scale-in pickup charges in numeric digit ",test, test1);
			// scalein pickup charges input
			if (!Pickupcharges.equals("")) {
				waitForElement(driver, AScale_in_pickup_charges);
				sendKeys(driver, AScale_in_pickup_charges, Pickupcharges);
			}
			Step_End(8, "Enter values for Scale-in pickup charges in numeric digit ",test, test1);
			Step_Start(9, "Enter values for handling charges in numeric digit",test, test1);
			// Handle charges input
			if (!handelcharges.equals("")) {
				waitForElement(driver, AHandling_Charges);
				sendKeys(driver, AHandling_Charges, handelcharges);
			}
			Step_End(9, "Enter values for handling charges in numeric digit",test, test1);
			Step_Start(10, "Enter values for Equipment quantity in numeric digit",test, test1);
			// Equipment quantity input
			if (!equipmentque.equals("")) {
				waitForElement(driver, AEquipment_Quantaty);
				sendKeys(driver, AEquipment_Quantaty, equipmentque);
			}
			Step_End(10, "Enter values for Equipment quantity in numeric digit",test, test1);
			Step_Start(11, "Enter values for Pre trip ins charges in numeric digit when it is required",test, test1);
			// pickup credit input
			if (!pickupcredit.equals("")) {
				waitForElement(driver, APick_Up_Credit);
				sendKeys(driver, APick_Up_Credit, pickupcredit);
			}
			Step_End(11, "Enter values for Pre trip ins charges in numeric digit when it is required",test, test1);
			// Remarks input

			if (!Remarks_input.equals("")) {
				waitForElement(driver, ARemarks_Input);
				sendKeys(driver, ARemarks_Input, Remarks_input);
			}

			Step_Start(3, "Select Validity From Date range accordingly in date picker ",test, test1);
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
			
			
			
			
			
					Step_End(4, "-Select Validity To Date range accordingly in date picker ",test, test1);

			// selecting oneway check box

			waitForElement(driver, OneWay_ChkBox);

			checkBox(driver, OneWay_ChkBox, One_Way_CheckBox);
			if (One_Way_CheckBox.equals("YES")) {

				List<String> datas = splitAndExpand(One_way_return_location);
				for (String data1 : datas) {
				
					waitForElement(driver, AAddreturnlocation);
					safeclick(driver, AAddreturnlocation);

					twoColumnSearchWindow(driver, One_Way_Search, Condition_Filter, data1);
						
					
				}
			}  

			// Selecting the Equipment type
			Step_Start(7, "click on size type add button, location add button ",test, test1);

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
			Step_End(7, "click on size type add button, location add button ",test, test1);
			Step_Start(1, "Enter Alphanumeric character for Scale-in Reference field ",test, test1);

			// Entering Scalin reference
			if (!scalerefno.equals("")) {
				waitForElement(driver, AScale_in_ref_input);
				safeclick(driver, AScale_in_ref_input);
				sendKeys(driver, AScale_in_ref_input, scalerefno);
				safeclick(driver, ARemarks_Input);
			}
			Step_End(1, "Enter Alphanumeric character for Scale-in Reference field ",test, test1);
			Step_Start(12, "Click add button once all required fields are entered",test, test1);
				// Adding the values into the grid

				waitForElement(driver, AGried_Add_Button);
				click(driver, AGried_Add_Button);
				
				Step_End(12, "Click add button once all required fields are entered",test, test1);
				Step_Start(13, "Click save button & system should show save message as successfull",test, test1);
				// Saving the records

				waitForElement(driver, SaveButton_ToolBar);
				safeclick(driver, SaveButton_ToolBar);

				
				waitForElement(driver, AScale_in_ref_input);
				String referencein =getAttribute(driver, AScale_in_ref_input, "value");
				System.out.println(referencein);
				Extent_call(test, test1,  "**Scalein_ref was generated as**"+ referencein);
				Extent_pass_New(driver,  "**Scalein_ref was generated as**"+ referencein, test, test1);
			
				
				// Verifying the validation of saved popup

				waitForPopup(driver, Popup_Message, savedpopexp);
				String Actualpopmsg = getText(driver, Popup_Message);
				System.out.println(Actualpopmsg);

				if (savedpopexp.equals(Actualpopmsg)) {
					System.out.println("Matched || " + " Expected popup is : " + savedpopexp
							+ " || Actual popup is : " + Actualpopmsg);
					Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedpopexp
							+ " || Actual popup is : " + Actualpopmsg, test, test1);
					Extent_call(test, test1, Actualpopmsg);
				} else {
					System.out.println("Not matched || " + " Expected popup is : " + savedpopexp
							+ " || Actual popup is : " + Actualpopmsg);
					Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedpopexp
							+ " || Actual popup is : " + Actualpopmsg, test, test1);
					
				}
				Step_End(13, "Click save button & system should show save message as successfull",test, test1);
				scrollUsingElement(driver, AGried_Add_Button);

				waitForElement(driver, table_Path);
				Map<String, List<String>> table_view = extractTableDataDirect(driver, table_Path);
				List<String> coloumhearders = splitAndExpand1(Coloum_names);
				
				String table_value = printTable(driver, table_view, coloumhearders);
				Extent_pass_New(driver, "<pre>"+table_value+"</pre>", test, test1);
				
				
				String Location1 = getText(driver, AINNSA);
				System.out.println(Location1);
				Extent_pass_New(driver, "Expected Result is : Location should be shown as "+Location1 +" Actual Result is : Location should be shown as "+Location1, test, test1);

				String equetype = getText(driver, Equipmenttype);
				System.out.println(equetype);
				Extent_pass_New(driver, "Expected Result is : Eqp type should be shown as "+equetype +" Actual Result is : Eqp type should be shown as "+equetype, test, test1);
				String equeque = getText(driver, Equipmentquenty);
				System.out.println(equeque);
				Extent_pass_New(driver, "Expected Result is : eqp quantity should be shown as "+equeque +" Actual Result is : eqp quantity should be shown as "+equeque, test, test1);

				Set<String> arrset1 = new HashSet<String>();
				arrset1.add(equeque);
				arrset1.add(equetype);
				arrset1.add(Location1);

				System.out.println("First Set: " + arrset1);
	              waitForDisplay(driver, AINNSA);
				if (isdisplayed(driver, AINNSA)) {
					System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid");
					Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid", test, test1);
					
					
					waitForDisplay(driver, Scroll_side);
					if (isdisplayed(driver, Scroll_side)) {
						horizontalscroll(driver, Scroll_side, 1000);
						Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid", test, test1);	
						
					}
			
				} 
				else {
					System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
					Extent_fail(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid", test, test1);
					
				}
				scrollTop(driver);

				// Deleting the records

				if(Want_To_Delete.equalsIgnoreCase("Yes")) {

				waitForElement(driver, Delete_button_toolBar);
				safeclick(driver, Delete_button_toolBar);

				waitForElement(driver, popup_Message_Yes_Button);
				safeclick(driver, popup_Message_Yes_Button);
				
			    waitForElement(driver, Popup_Message);

				}
				Extent_completed(testcase_Name, test, test1);
		scrollTop(driver);
	    waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab); 		
		}
		int LT2=2;

		if(LT2==2) {


			// Value are taken from excel sheet
			String testcase_Name = "TC_Scale_In_TS_007";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String Scale_Reference_no = data.get("Scale_Reference_no");
			String perdiem = data.get("Per_Diem");
			String savedpopexp = data.get("PopUpforsaved");
			String Search_type = data.get("Search_type");
			String From_date_perform = data.get("From_date_perform");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_perform = data.get("To_Date_perform");
			String To_Date_Input = data.get("To_Date_Input");
			String Coloum_names = data.get("Coloum_names");
			String Equipment_ID = data.get("Equipment_ID");
			String Location = data.get("Location");
			String Search_value_type = data.get("Search_value_type");
			
			String select_Option_1 = String.format(Gird_Click, Location,Equipment_ID);
			Extent_Start(testcase_Name, test, test1);
			
			

		
		

			// Module Search

			moduleNavigate(driver, Search);
			
			Step_Start(1, " Click on Global Search from toolbar",test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, Search_type, Search_value_type, Scale_Reference_no, "", "", "", "");
			Step_End(1, " Click on Global Search from toolbar",test, test1);
			Step_Start(2, " Enter Contract no & click on search button",test, test1);
			// Entering the contract number to search

			
		
			Step_Start(3, " Click on retrieved data for required contract no",test, test1);
		
			scrollTop(driver);
			Step_End(2, " Enter Contract no & click on search button",test, test1);
			Step_End(3, " Click on retrieved data for required contract no",test, test1);
			Step_Start(4, "Click on Edit button from toolbar ",test, test1);
			// Adding into the gird

			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);
			
			scrollBottom(driver);
			Step_End(4, "Click on Edit button from toolbar ",test, test1);
			Step_Start(5, " double click on the required data from grid ",test, test1);
			waitForElement(driver, Adoubleclickperdiem);
			String firist = getText(driver, Adoubleclickperdiem);
			System.out.println(firist);
			String[] a2 = firist.split("\\.");
			System.out.println("Splitted string" + a2[0]);
			waitForElement(driver, select_Option_1);
			doubleClick(driver, select_Option_1);
		
			scrollTop(driver);
			Step_End(5, " double click on the required data from grid ",test, test1);
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
					
			Step_Start(6, "Clear the existing values in per diem field ",test, test1);
			Step_Start(7, " Enter new values in per diem field & click on edit button ",test, test1);
			// Perdiem input
			if (!perdiem.equals("")) {
				waitForElement(driver, APer_Diem_Input);
				clear(driver, APer_Diem_Input);
				Step_End(6, "Clear the existing values in per diem field ",test, test1);
				sendKeys(driver, APer_Diem_Input, perdiem);
				waitForElement(driver, APick_Up_Credit);
				safeclick(driver, APick_Up_Credit);
			}
			
			waitForElement(driver, Aeditbuttoninside);
			safeclick(driver, Aeditbuttoninside);
			
			Step_End(7, " Enter new values in per diem field & click on edit button ",test, test1);
			scrollTop(driver);
			Step_Start(8, " Click on save button & updated message shown in screen ",test, test1);
			// Saving after edit
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			waitForElement(driver, AGried_Add_Button);
			scrollUsingElement(driver, AGried_Add_Button);
			// verify the popup for after edit the date and save

			waitForPopup(driver, Popup_Message, savedpopexp);
			String actualmsg = getText(driver, Popup_Message);
			System.out.println(actualmsg);
			if (savedpopexp.equals(actualmsg)) {
				System.out.println(
						"Matched || " + " Expected popup is [Before edit it was shown] : " + savedpopexp + " || Actual popup is [After edit it was shown] : " + actualmsg);
				Extent_pass_New(driver,
						"Matched || " + " Expected popup is [Before edit it was shown] : " + savedpopexp + " || Actual popup is[After edit it was shown]  : " + actualmsg,
						test, test1);
			} else {
				System.out.println("Not matched || " + " Expected popup is[Before edit it was shown] : " + savedpopexp
						+ " || Actual popup is[After edit it was shown]  : " + actualmsg);
				Extent_fail(driver, "Not matched || " + " Expected popup is [Before edit it was shown]: " + savedpopexp
						+ " || Actual popup is[After edit it was shown]  : " + actualmsg, test, test1);
				
			}
			
			// verification before edit value and after edit value
			waitForElement(driver, Adoubleclickperdiem);
			String second = getText(driver, Adoubleclickperdiem);
			System.out.println(second);

			if (a2[0].equals(second)) {
				System.out
						.println("Matched || " + " Expected Activity is : " + a2[0] + " || Actual Activity is : " + second);
				Extent_fail(driver, "Matched || " + " PerDiem want to change aftet edit : " + a2[0]
						+ " || PerDiem was changed : " + second, test, test1);
			
			} else {
				System.out.println(
						"Not matched || " + " Expected Activity is : " + a2[0] + " || Actual Activity is : " + second);
				Extent_pass_New(driver,
						"Not matched || " + " Expected Activity is : " + a2[0] + " || Actual Activity is : " + second, test,
						test1);
				
				Extent_call(test, test1, "Not matched || " + " Expected Activity is : " + a2[0] + " || Actual Activity is : " + second);
			}
			Step_End(8, " Click on save button & updated message shown in screen ",test, test1);
			
			
			Map<String, List<String>> table_view = extractTableDataDirect(driver, table_Path);
			List<String> coloumhearders = splitAndExpand1(Coloum_names);
			
			String table_value = printTable(driver, table_view, coloumhearders);
			Extent_pass_New(driver, "<pre>"+table_value+"</pre>", test, test1);
			// verify data was added in gird
			waitForDisplay(driver, AINNSA);
			if (isdisplayed(driver, AINNSA)) {
				System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid");
				Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid", test, test1);
				Extent_call(test, test1,  "Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid");
				isDisplayed(driver, Scroll_side);
				if (isDisplayed(driver, Scroll_side)) {
					horizontalscroll(driver, Scroll_side, 1000);
					Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid", test, test1);	
					Extent_call(test, test1,  "Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid");
					
				}
				
			} else {
				System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
				Extent_fail(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid", test, test1);
				
			}
			
			scrollTop(driver);
			Extent_completed(testcase_Name, test, test1);
		scrollTop(driver);

		click(driver, Close_Current_tab); 		
		}
		int LT3=3;

		if(LT3==3) {


			String testcase_Name = "TC_Scale_In_TS_008";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String contractnum = data.get("Contract_No");
			String scalerefno = data.get("Scale_Reference_no");
			String freedays = data.get("Free_Days");
			String perdiem = data.get("Per_Diem");
			String handelcharges = data.get("Handles_Charges");
			String equipmentque = data.get("equipment_Quantity");
			String pickupcredit = data.get("PickUp_Credit");
			String Pickupcharges = data.get("Scale_in_pickup_charges");
			String savedpopexp = data.get("PopUpforsaved");
			String todayenter = data.get("TODAYS");
			String secondtodayinput = data.get("secondtoday");
			String secondtodayinputdem = data.get("seconddiem");
			String Slab_CheckBox = data.get("Slab_CheckBox");
			String One_Way_CheckBox = data.get("One_Way_CheckBox");
			String Equipment_type_perform = data.get("Equipment_type_perform");
			String Reference_Type = data.get("Reference_Type");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");
			String One_way_return_location = data.get("One_way_return_location");
			String Equipmenttype_Input = data.get("Equipmenttype_Input");
			String Add_location_port_perform = data.get("Add_location_port_perform");
			String Add_location_port_input = data.get("Add_location_port_input");
			String Remarks_input = data.get("Remarks_input");
			String Per_Diem_Slap = data.get("Per_Diem_Slap");
			String To_Date_perform = data.get("To_Date_perform");
			String From_date_perform = data.get("From_date_perform");
			String Coloum_names = data.get("Coloum_names");
			String No_Records_pop = data.get("No-Records_pop");
			String Deleted_pop_exp = data.get("Deleted_pop_exp");
			String Search_type = data.get("Search_type");
			String Condition_Filter = data.get("Condition_Filter");
			String Contract_Number_Search = data.get("Contract_Number_Search");
			String One_Way_Search = data.get("One_Way_Search");
			String Equipment_Type_Search = data.get("Equipment_Type_Search");
			String Location_Search = data.get("Location_Search");
			String Search_value_type = data.get("Search_value_type");
			String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
			
			Extent_Start(testcase_Name, test, test1);
			
			
			Step_Start(1, "Create Scalein data record",test, test1);
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
					
					waitForDisplay(driver, Slab_ChkBox);

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
			if (pickupcredit.equals("")) {
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
				for (String data1 : datas) {
					
					waitForElement(driver, AAddreturnlocation);
					safeclick(driver, AAddreturnlocation);

					
					twoColumnSearchWindow(driver, One_Way_Search, Condition_Filter, data1);
						
					
				}
			}

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

				waitForDisplay(driver, AINNSA);
				if (isdisplayed(driver, AINNSA)) {
					System.out.println("Expected Result is :Data was should be shown in grid ||Actual Result is :Data was is shown in grid");
					Extent_pass_New(driver, "Expected Result is :Data was should be shown in grid ||Actual Result is :Data was is shown in grid", test, test1);
				} else {
					System.out.println("Expected Result is :Data was should be shown in grid ||Actual Result is :Data was is not shown in grid");
					Extent_fail(driver, "Expected Result is :Data was should be shown in grid ||Actual Result is :Data was is not shown in grid", test, test1);
					
				}
				scrollTop(driver);
			
			
				
				
				waitForElement(driver, AScale_in_ref_input);
				String reference =getAttribute(driver, AScale_in_ref_input, "value");
				System.out.println(reference);
				scrollTop(driver);
				
				Step_Start(1, " Click on Global Search from toolbar",test, test1);
				waitForElement(driver, SearchButton_Toolbar);
				safeclick(driver, SearchButton_Toolbar);
				Step_End(1, " Click on Global Search from toolbar",test, test1);
				Step_Start(2, "  Enter Contract no & click on search button",test, test1);
				// Entering the contract number to search
				Step_Start(3, " Click on retrieved data for required scale-out ref",test, test1);
				globalValueSearchWindow(driver, Search_type, Search_value_type, reference, "", "", "", "");
				Step_End(2, "  Enter Contract no & click on search button",test, test1);
			
			
				Step_Start(2, " Click on Delete icon from toolbar",test, test1);
				
				// Deleting the records

				waitForElement(driver, Delete_button_toolBar);
				safeclick(driver, Delete_button_toolBar);
				Step_End(2, " Click on Delete icon from toolbar",test, test1);
				Step_Start(3, " Click on 'Yes' when pop-up message occurs for confirmation",test, test1);
				waitForElement(driver, popup_Message);

				safeclick(driver, popup_Message_Yes_Button);
				// verify the popup for delete
				waitForPopup(driver, Popup_Message, Deleted_pop_exp);
				String actualmsg = getText(driver, Popup_Message);
				System.out.println(actualmsg);
				if (Deleted_pop_exp.equals(actualmsg)) {
					System.out.println("Matched || " + " Expected popup is : " + Deleted_pop_exp
							+ " || Actual popup is : " + actualmsg);
					Extent_pass_New(driver, "Matched || " + " Expected popup is : " + Deleted_pop_exp
							+ " || Actual popup is : " + actualmsg, test, test1);
				} else {
					System.out.println("Not matched || " + " Expected popup is : " + Deleted_pop_exp
							+ " || Actual popup is : " + actualmsg);
					Extent_fail(driver, "Not matched || " + " Expected popup is : " + Deleted_pop_exp
							+ " || Actual popup is : " + actualmsg, test, test1);
				}
				Step_End(3, " Click on 'Yes' when pop-up message occurs for confirmation",test, test1);
				Step_Start(4, " Check that data is showing in global search ",test, test1);
				// seraching the record in global search

				waitForElement(driver, SearchButton_Toolbar);
				safeclick(driver, SearchButton_Toolbar);
				globalValueSearchWindow1(driver, Search_type, Search_value_type, scalerefno, "", "", "", "");
				
				
				// verify the no records in global search
				waitForPopup(driver, Popup_Message, No_Records_pop);
				String actualmsg1 = getText(driver, Popup_Message);
				System.out.println(actualmsg1);
				if (No_Records_pop.equals(actualmsg1)) {
					System.out.println("Matched || " + " Expected popup is : " + No_Records_pop
							+ " || Actual popup is : " + actualmsg1);
					Extent_pass_New(driver, "Matched || " + " Expected popup is : " + No_Records_pop
							+ " || Actual popup is : " + actualmsg1, test, test1);
				} else {
					System.out.println("Not matched || " + " Expected popup is : " + No_Records_pop
							+ " || Actual popup is : " + actualmsg1);
					Extent_fail(driver, "Not matched || " + " Expected popup is : " + No_Records_pop
							+ " || Actual popup is : " + actualmsg1, test, test1);
				}
				Step_End(4, " Check that data is showing in global search ",test, test1);
				
				Extent_completed(testcase_Name, test, test1);
				
				
				waitForElement(driver, globalSearchCloseIcon_L);
				safeclick(driver, globalSearchCloseIcon_L);
				// closing the tab for global search
				waitForElement(driver, Close_Current_tab);
				safeclick(driver, Close_Current_tab);
				
				
			}

		scrollTop(driver);


		int LT4=4;

		if(LT4==4) {

			String testcase_Name = "TC_Scale_In_TS_009";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String Search = data.get("Search_input");
			String Scale_Reference_no = data.get("Scale_Reference_no");
			String Search_type = data.get("Search_type");
			String Coloum_names = data.get("Coloum_names");
			String Search_value_type = data.get("Search_value_type");
			
			Extent_Start(testcase_Name, test, test1);
		
			moduleNavigate(driver, Search);
			// home page displayed
			Step_Start(1, " Click on Global Search from toolbar",test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			// seaeching the data in global search
			Step_End(1, "Click on Global Search from toolbar",test, test1);
			Step_Start(2, "Enter Contract no accordingly & click on search button",test, test1);
			globalValueSearchWindow(driver, Search_type, Search_value_type, Scale_Reference_no, "", "", "", "");
			
		
			waitForElement(driver, AScale_in_ref_input);
			String reference =getAttribute(driver, AScale_in_ref_input, "value");
			System.out.println(reference);
			scrollTop(driver);
			Step_End(2, "Enter Contract no accordingly & click on search button",test, test1);
			Step_Start(3, "Click on retrieved data for required contract no",test, test1);
			// verifying the gird
		
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
			if (isDisplayed(driver, scrollhorizandal)) {
			horizontalscroll(driver, scrollhorizandal, 500);
			horizontalscroll(driver, scrollhorizandal, -500);
			}

			waitForDisplay(driver, AINNSA);
			if (isdisplayed(driver, AINNSA)) {
				System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
				Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid", test, test1);
				
				waitForDisplay(driver, Scroll_side);
				if (isdisplayed(driver, Scroll_side)) {
					horizontalscroll(driver, Scroll_side, 1000);
					Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid", test, test1);	
					
				}
				
			} else {
				System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
				Extent_fail(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid", test, test1);
			}
			
			
			if (Scale_Reference_no.equals(reference)) {
				System.out.println("Matched || " + " Expected Activity is : " + Scale_Reference_no
						+ " || Actual Activity is : " + reference);
				Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Scale_Reference_no
						+ " || Actual Activity is : " + reference, test, test1);
				Extent_pass_New(driver," Scale-out Data was retrived", test, test1);
			} else {
				System.out.println("Not matched || " + " Expected Activity is : " + Scale_Reference_no
						+ " || Actual Activity is : " + reference);
				Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Scale_Reference_no
						+ " || Actual Activity is : " + reference, test, test1);
			
				
			}
			
			
			
			Step_End(3, "Click on retrieved data for required contract no",test, test1);
			
			Extent_completed(testcase_Name, test, test1);
		}

		scrollTop(driver);
		waitForElement(driver, Close_Current_tab); 		
		click(driver, Close_Current_tab); 		

		int LT5=5;

		if(LT5==5) {

			String testcase_Name = "TC_Scale_In_TS_010";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String Search = data.get("Search_input");
			String contractnum = data.get("Contract_No");
			String scalerefno = data.get("Scale_Reference_no");
			String freedays = data.get("Free_Days");
			String perdiem = data.get("Per_Diem");
			String handelcharges = data.get("Handles_Charges");
			String equipmentque = data.get("equipment_Quantity");
			String pickupcredit = data.get("PickUp_Credit");
			String Pickupcharges = data.get("Scale_in_pickup_charges");
			String savedpopexp = data.get("PopUpforsaved");
			String todayenter = data.get("TODAYS");
			String secondtodayinput = data.get("secondtoday");
			String secondtodayinputdem = data.get("seconddiem");
			String To_Date_perform = data.get("To_Date_perform");
			String From_date_perform = data.get("From_date_perform");
			String Slab_CheckBox = data.get("Slab_CheckBox");
			String Per_Diem_Slap = data.get("Per_Diem_Slap");


			String Equipment_type_perform = data.get("Equipment_type_perform");
			String Reference_Type = data.get("Reference_Type");

			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");

			String Equipmenttype_Input = data.get("Equipmenttype_Input");
			String Add_location_port_perform = data.get("Add_location_port_perform");
			String Add_location_port_input = data.get("Add_location_port_input");
			String Condition_Filter = data.get("Condition_Filter");
			String Remarks_input = data.get("Remarks_input");
			String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
			String Coloum_names = data.get("Coloum_names");
			String Contract_Number_Search = data.get("Contract_Number_Search");
			String Equipment_Type_Search = data.get("Equipment_Type_Search");
			String Location_Search = data.get("Location_Search");
			String Want_To_Delete = data.get("Want_To_Delete");

			
			Extent_Start(testcase_Name, test, test1);
			
			
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

		scrollTop(driver);
		waitForElement(driver, Close_Current_tab); 		
		click(driver, Close_Current_tab); 			

		int LT6=6;

		if(LT6==6) {

			// Value are taken from excel sheet
			String testcase_Name = "TC_Scale_In_TS_011";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String Scale_Reference_no = data.get("Scale_Reference_no");
			String From_date_perform = data.get("From_date_perform");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_perform = data.get("To_Date_perform");
			String To_Date_Input = data.get("To_Date_Input");
			String savedpopexp = data.get("PopUpforsaved");
			String Search_type = data.get("Search_type");
			String Location = data.get("Location");
			String Coloum_names = data.get("Coloum_names");
			String Equipment_ID = data.get("Equipment_ID");
			String Search_value_type = data.get("Search_value_type");
			String girdclick = String.format(Scale_In_Out_Reference.Gird_click, Location,Equipment_ID);
			Extent_Start(testcase_Name, test, test1);


			// Module Search

			moduleNavigate(driver, Search);
			Step_Start(1, " CClick on Global Search from toolbar", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			Step_End(1, " Click on Global Search from toolbar", test, test1);
			globalValueSearchWindow(driver, Search_type, Search_value_type, Scale_Reference_no, "", "", "", "");
			Step_Start(2, "  Enter Contract no & click on search button", test, test1);
			// Entering the contract number to search
			Step_Start(3, " Click on retrieved data for required scale-out ref", test, test1);
		

			Step_End(3, " Click on retrieved data for required scale-out ref", test, test1);
			scrollTop(driver);
			waitForElement(driver, AFrom_Date);
			String Fromdate = getAttribute(driver, AFrom_Date, "value");
			System.out.println(Fromdate);
			String Todate = getAttribute(driver, A_To_Date, "value");
			System.out.println(Todate);
			Step_End(4, " Click on Edit button from toolbar ", test, test1);
			// Adding into the gird

			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);
			Step_Start(4, " Click on Edit button from toolbar ", test, test1);
			Step_Start(6, "  Click the date range & update new date ", test, test1);

			Step_Start(5, "  double click on the required data from grid ", test, test1);
			// Double click on the gird

			waitForElement(driver, girdclick);
			doubleClick(driver, girdclick);

			Step_End(5, "  double click on the required data from grid ", test, test1);

			// Editing the date
			// Selecting the From Date
			waitForElement(driver, AFrom_Date);
			if (From_date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, AFrom_Date);
				selectDatePicker(driver, AFrom_Date, From_Date_Input);
			} else {
				waitForElement(driver, AFrom_Date);
				clearAndType(driver, AFrom_Date, From_Date_Input);
			}
			

			Step_End(3, "Select Validity From Date range accordingly in date picker ", test, test1);
			// Selecting the to Date
			Step_Start(4, "-Select Validity To Date range accordingly in date picker ", test, test1);
			waitForElement(driver, A_To_Date);
			if (To_Date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, A_To_Date);
				selectDatePicker(driver, A_To_Date, To_Date_Input);
			} else {
				waitForElement(driver, A_To_Date);
				clearAndType(driver, A_To_Date, To_Date_Input);
			}
			
			Step_End(6, "  Click the date range & update new date ", test, test1);

			Step_Start(7, "Click on edit button once date range updated", test, test1);

			// Adding the values into the grid

			waitForElement(driver, AGried_Add_Button);
			safeclick(driver, AGried_Add_Button);

			Step_End(7, "Click on edit button once date range updated", test, test1);

			scrollTop(driver);
			Step_Start(8, "Click on save button & updated message shown in screen", test, test1);
			// Saving after edit
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			waitForElement(driver, AGried_Add_Button);
			scrollUsingElement(driver, AGried_Add_Button);
			
			
			Map<String, List<String>> table_view = extractTableDataDirect(driver, table_Path);
			List<String> coloumhearders = splitAndExpand1(Coloum_names);
			
			String table_value = printTable(driver, table_view, coloumhearders);
			Extent_pass_New(driver, "<pre>"+table_value+"</pre>", test, test1);
			
			waitForPopup(driver, Popup_Message, savedpopexp);
			String actualmsg = getText(driver, Popup_Message);
			System.out.println(actualmsg);
			if (savedpopexp.equals(actualmsg)) {
				System.out.println(
						"Matched || " + " Expected Activity is : " + savedpopexp + " || Actual Activity is : " + actualmsg);
				Extent_pass_New(driver,
						"Matched || " + " Expected Activity is : " + savedpopexp + " || Actual Activity is : " + actualmsg,
						test, test1);
			} else {
				System.out.println("Not matched || " + " Expected Activity is : " + savedpopexp
						+ " || Actual Activity is : " + actualmsg);
				Extent_fail(driver, "Not matched || " + " Expected Activity is : " + savedpopexp
						+ " || Actual Activity is : " + actualmsg, test, test1);

			}
			Step_End(8, "Click on save button & updated message shown in screen", test, test1);
			scrollTop(driver);
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);

			scrollBottom(driver);
			// Double click on the gird

			waitForElement(driver, girdclick);
			doubleClick(driver, girdclick);

			scrollTop(driver);
			waitForElement(driver, AFrom_Date);
			String Fromdate1 = getAttribute(driver, AFrom_Date, "value");
			System.out.println(Fromdate1);
			String Todate1 = getAttribute(driver, A_To_Date, "Value");
			System.out.println(Todate1);

			if (Fromdate.equals(Fromdate1)) {
				System.out.println(
						"Matched || " + " Expected date is : " + Fromdate + " || Actual date is : " + Fromdate1);
				Extent_fail(driver, "Matched || " + " Date want to change aftet edit : " + Fromdate
						+ " || Date was changed : " + Fromdate1, test, test1);
			} else {
				System.out.println("Not matched || " + " Expected Activity is Date want to change aftet edit  : " + Fromdate
						+ " || Actual Activity isDate was changed  : " + Fromdate1);
				Extent_pass_New(driver, "Not matched || " + " Expected Activity is  Date want to change aftet edit : "
						+ Fromdate + " || Actual Activity is Date was changed : " + Fromdate1, test, test1);

			}

			if (Todate.equals(Todate1)) {
				System.out.println(
						"Matched || " + " Expected date is : " + Todate + " || Actual date is : " + Todate1);
				Extent_fail(driver,
						"Matched || " + " Date want to change aftet edit : " + Todate + " || Date was changed : " + Todate1,
						test, test1);
			} else {
				System.out.println("Not matched || " + " Expected Activity is  Date want to change aftet edit : " + Todate
						+ " || Actual Activity is Date was changed : " + Todate1);
				Extent_pass_New(driver, "Not matched || " + " Expected Activity is  Date want to change aftet edit : " + Todate
						+ " || Actual Activity is Date was changed : " + Todate1, test, test1);

			}

			scrollTop(driver);
			Extent_completed(testcase_Name, test, test1);
		}

		scrollTop(driver);
		waitForElement(driver, Close_Current_tab); 		
		click(driver, Close_Current_tab); 			

		int LT7=7;

		if(LT7==7) {


			String testcase_Name = "TC_Scale_In_TS_012";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String Search = data.get("Search_input");
			String contractnum = data.get("Contract_No");
			String scalerefno = data.get("Scale_Reference_no");
			String freedays = data.get("Free_Days");
			String perdiem = data.get("Per_Diem");
			String handelcharges = data.get("Handles_Charges");
			String equipmentque = data.get("equipment_Quantity");
			String pickupcredit = data.get("PickUp_Credit");
			String Pickupcharges = data.get("Scale_in_pickup_charges");
			String savedpopexp = data.get("PopUpforsaved");
			String todayenter = data.get("TODAYS");
			String secondtodayinput = data.get("secondtoday");
			String secondtodayinputdem = data.get("seconddiem");
			String Slab_CheckBox = data.get("Slab_CheckBox");
			String Equipment_type_perform = data.get("Equipment_type_perform");
			String Reference_Type = data.get("Reference_Type");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");
			String Equipmenttype_Input = data.get("Equipmenttype_Input");
			String Add_location_port_perform = data.get("Add_location_port_perform");
			String Add_location_port_input = data.get("Add_location_port_input");
			String Remarks_input = data.get("Remarks_input");
			String No_Records_pop = data.get("No-Records_pop");
			String Deleted_pop_exp = data.get("Deleted_pop_exp");
			String Search_type = data.get("Search_type");
			String From_date_perform = data.get("From_date_perform");
			String To_Date_perform = data.get("To_Date_perform");
			String Per_Diem_Slap = data.get("Per_Diem_Slap");
			String Coloum_names = data.get("Coloum_names");
			String Condition_Filter = data.get("Condition_Filter");
			String Contract_Number_Search = data.get("Contract_Number_Search");
			String Equipment_Type_Search = data.get("Equipment_Type_Search");
			String Location_Search = data.get("Location_Search");
			String Search_value_type = data.get("Search_value_type");
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

			waitForElement(driver, AFrom_Date);
			if (From_date_perform.equalsIgnoreCase("Yes")) {
				waitForElement(driver, AFrom_Date);
				selectDatePicker(driver, AFrom_Date, From_Date_Input);
			}    {
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
				
				waitForElement(driver, AScale_in_ref_input);
				String reference =getAttribute(driver, AScale_in_ref_input, "value");
				System.out.println(reference);
				scrollTop(driver);
				
				Step_Start(1, " CClick on Global Search from toolbar",test, test1);
				waitForElement(driver, SearchButton_Toolbar);
				safeclick(driver, SearchButton_Toolbar);
				Step_End(1, " Click on Global Search from toolbar",test, test1);
				
				Step_Start(2, "  Enter Contract no & click on search button",test, test1);
				// Entering the contract number to search
				Step_Start(3, " Click on retrieved data for required scale-out ref",test, test1);
				globalValueSearchWindow(driver, Search_type, Search_value_type, reference, "", "", "", "");
			
				
				Step_End(2, "  Enter Contract no & click on search button",test, test1);
			
			
				Step_End(3, " Click on retrieved data for required scale-out ref",test, test1);
				Step_Start(4, "Click on Delete icon from toolbar",test, test1);

				// Deleting the records

				waitForElement(driver, Delete_button_toolBar);
				safeclick(driver, Delete_button_toolBar);
				Step_Start(5, "Click on 'Yes' when pop-up message occurs for confirmation",test, test1);

				waitForElement(driver, popup_Message_Yes_Button);
				safeclick(driver, popup_Message_Yes_Button);
				
				waitForPopup(driver, Popup_Message, Deleted_pop_exp);
				String actualmsg = getText(driver, Popup_Message);
				System.out.println(actualmsg);
				if (Deleted_pop_exp.equals(actualmsg)) {
					System.out.println("Matched || " + " Expected popup is : " + Deleted_pop_exp
							+ " || Actual popup is : " + actualmsg);
					Extent_pass_New(driver, "Matched || " + " Expected popup is : " + Deleted_pop_exp
							+ " || Actual popup is : " + actualmsg, test, test1);
				} else {
					System.out.println("Not matched || " + " Expected popup is : " + Deleted_pop_exp
							+ " || Actual popup is : " + actualmsg);
					Extent_fail(driver, "Not matched || " + " Expected popup is : " + Deleted_pop_exp
							+ " || Actual popup is : " + actualmsg, test, test1);
					
				}
				Step_End(4, "Click on Delete icon from toolbar",test, test1);
				Step_End(5, "Click on 'Yes' when pop-up message occurs for confirmation",test, test1);
				
				waitForElement(driver, SearchButton_Toolbar);
				safeclick(driver, SearchButton_Toolbar);
				globalValueSearchWindow1(driver, Search_type, Search_value_type, scalerefno, "", "", "", "");
				
				// verify the no records in global search
				waitForPopup(driver, Popup_Message, No_Records_pop);

				String actualmsg1 = getText(driver, Popup_Message);
				System.out.println(actualmsg1);
				if (No_Records_pop.equals(actualmsg1)) {
					System.out.println("Matched || " + " Expected popup is : " + No_Records_pop
							+ " || Actual popup is : " + actualmsg1);
					Extent_pass_New(driver, "Matched || " + " Expected popup is : " + No_Records_pop
							+ " || Actual popup is : " + actualmsg1, test, test1);
				} else {
					System.out.println("Not matched || " + " Expected popup is : " + No_Records_pop
							+ " || Actual popup is : " + actualmsg1);
					Extent_fail(driver, "Not matched || " + " Expected popup is : " + No_Records_pop
							+ " || Actual popup is : " + actualmsg1, test, test1);
					
				}
				// closing the tab for global search
				
				Extent_completed(testcase_Name, test, test1);
				
				
				// closing the tab for global search
				waitForElement(driver, globalSearchCloseIcon_L);
				safeclick(driver, globalSearchCloseIcon_L);
				waitForElement(driver, Close_Current_tab);
				safeclick(driver, Close_Current_tab);
			}



		scrollTop(driver);


		int LT9=9;

		if(LT9==9) {

			String testcase_Name = "TC_Scale_In_TS_013";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String Search = data.get("Search_input");
			String Scale_Reference_no = data.get("Scale_Reference_no");
			String Search_type = data.get("Search_type");
			String Coloum_names = data.get("Coloum_names");
			
			String Search_value_type = data.get("Search_value_type");
			Extent_Start(testcase_Name, test, test1);
			

			
			// login
			moduleNavigate(driver, Search);
			Step_Start(1, "Click on Global Search from toolbar",test, test1);
			// home page displayed
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			// seaeching the data in global search
		
			Step_End(1, "Click on Global Search from toolbar",test, test1);
			Step_Start(2, "Enter Contract no accordingly & click on search button",test, test1);
			Step_Start(3, "Click on retrieved data for required contract no",test, test1);
			globalValueSearchWindow(driver, Search_type, Search_value_type, Scale_Reference_no, "", "", "", "");
			
			
			waitForElement(driver, AScale_in_ref_input);
			String reference =getAttribute(driver, AScale_in_ref_input, "value");
			System.out.println(reference);
			scrollTop(driver);
			
			Step_End(2, "Enter Contract no accordingly & click on search button",test, test1);
			// verifying the gird

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
			if (isDisplayed(driver, AINNSA)) {
				System.out.println("Data was shown in grid");
				Extent_pass_New(driver, "***Data was shown in grid***", test, test1);
				
				waitForDisplay(driver, Scroll_side);
				if (isdisplayed(driver, Scroll_side)) {
					horizontalscroll(driver, Scroll_side, 1000);
					System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
					Extent_pass_New(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is  shown in grid", test, test1);	
					
				}
		
				
				
			} else {
				System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
				Extent_fail(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid", test, test1);
				
			}

			Set<String> arrset1 = new HashSet<String>();
			arrset1.add(equeque);
			arrset1.add(equetype);
			arrset1.add(Location1);

			System.out.println("First Set: " + arrset1);
			Step_End(3, "Click on retrieved data for required contract no",test, test1);
			
			if (Scale_Reference_no.equals(reference)) {
				System.out.println("Matched || " + " Expected Activity is : " + Scale_Reference_no
						+ " || Actual Activity is : " + reference);
				Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Scale_Reference_no
						+ " || Actual Activity is : " + reference, test, test1);
				Extent_pass_New(driver," Scale-out Data was retrived", test, test1);
			} else {
				System.out.println("Not matched || " + " Expected Activity is : " + Scale_Reference_no
						+ " || Actual Activity is : " + reference);
				Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Scale_Reference_no
						+ " || Actual Activity is : " + reference, test, test1);
			
				
			}
			Extent_completed(testcase_Name, test, test1);
		}

		scrollTop(driver);
		waitForElement(driver, Close_Current_tab); 		
		click(driver, Close_Current_tab); 	 		

		int LT10=10;

		if(LT10==10) {
			// Value are taken from excel sheet
			String testcase_Name = "TC_Scale_In_TS_014";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String contractnum = data.get("Contract_No");
			String scalerefno = data.get("Scale_Reference_no");
			String freedays = data.get("Free_Days");
			String perdiem = data.get("Per_Diem");
			String handelcharges = data.get("Handles_Charges");
			String equipmentque = data.get("equipment_Quantity");
			String pickupcredit = data.get("PickUp_Credit");
			String Pickupcharges = data.get("Scale_in_pickup_charges");
			String savedpopexp = data.get("PopUpforsaved");
			String todayenter = data.get("TODAYS");
			String secondtodayinput = data.get("secondtoday");
			String secondtodayinputdem = data.get("seconddiem");
			String Per_Diem_Slap = data.get("Per_Diem_Slap");
			String Coloum_names = data.get("Coloum_names");
			String Condition_Filter = data.get("Condition_Filter");
			
			String Slab_CheckBox = data.get("Slab_CheckBox");
			String One_Way_CheckBox = data.get("One_Way_CheckBox");
			String Equipment_type_perform = data.get("Equipment_type_perform");
			String Reference_Type = data.get("Reference_Type");
			String From_date_perform = data.get("From_date_perform");
			String To_Date_perform = data.get("To_Date_perform");

			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");
			String One_way_return_location = data.get("One_way_return_location");
			String Equipmenttype_Input = data.get("Equipmenttype_Input");
			String Add_location_port_perform = data.get("Add_location_port_perform");
			String Add_location_port_input = data.get("Add_location_port_input");
			String Contract_Number_Search = data.get("Contract_Number_Search");
			String Equipment_Type_Search = data.get("Equipment_Type_Search");
			String Location_Search = data.get("Location_Search");
			String Remarks_input = data.get("Remarks_input");
			String One_Way_Search = data.get("One_Way_Search");
			String Want_To_Delete = data.get("Want_To_Delete");

			String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
			Extent_Start(testcase_Name, test, test1);
			
			
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
				}
				Extent_completed(testcase_Name, test, test1);
				
				
			}

	}

}
