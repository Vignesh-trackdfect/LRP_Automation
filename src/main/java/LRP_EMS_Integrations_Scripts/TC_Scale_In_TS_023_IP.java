package LRP_EMS_Integrations_Scripts;


import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Scale_In_Out_Reference;

public class TC_Scale_In_TS_023_IP extends Keywords {

	public void scaleinsavewithoutAdd(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		// Value are taken from excel sheet

		String testcase_Name = "TC_Scale_In_TS_023_IP";
		
		
		



		String Username = Excel_data.get("Username");// 1,2,4-6
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
		String Contract_Number_Search = Excel_data.get("Contract_Number_Search");
		String Equipment_Type_Search = Excel_data.get("Equipment_Type_Search");
		String Location_Search = Excel_data.get("Location_Search");
		String One_Way_Search = Excel_data.get("One_Way_Search");
		String Remarks_input = Excel_data.get("Remarks_input");

		String per_diem_slap = Excel_data.get("per_diem_slap");
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

}
