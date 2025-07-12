package LRP_EMS_Integrations_Scripts;


import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Scale_In_Out_Reference;

public class TC_Scale_In_TS_025_IP extends Keywords {

	public void scaleinwithoutcontract(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		// Value are taken from excel sheet
		String testcase_Name = "TC_Scale_In_TS_025_IP";
		
		
		

	
		String Username = Excel_data.get("Username");// 1,2,4-6
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String contractnum = Excel_data.get("Contract_No");
		String Scale_Reference_no = Excel_data.get("Scale_Reference_no");
		String freedays = Excel_data.get("Free_Days");
		String perdiem = Excel_data.get("Per_Diem");
		String handelcharges = Excel_data.get("Handles_Charges");
		String equipmentque = Excel_data.get("equipment_Quantity");
		String pickupcredit = Excel_data.get("PickUp_Credit");
		String Pickupcharges = Excel_data.get("Scale_in_pickup_charges");
		String From_date_perform = Excel_data.get("From_date_perform");
		String To_Date_perform = Excel_data.get("To_Date_perform");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Equipment_type_perform = Excel_data.get("Equipment_type_perform");
		String Reference_Type = Excel_data.get("Reference_Type");
		
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		
		String Equipmenttype_Input = Excel_data.get("Equipmenttype_Input");
		String Add_location_port_perform = Excel_data.get("Add_location_port_perform");
		String Add_location_port_input = Excel_data.get("Add_location_port_input");
		
		String Remarks_input = Excel_data.get("Remarks_input");
		String PopUpforsaved = Excel_data.get("PopUpforsaved");
		String Contract_Number_Search = Excel_data.get("Contract_Number_Search");
		String Equipment_Type_Search = Excel_data.get("Equipment_Type_Search");
		String Location_Search = Excel_data.get("Location_Search");
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
		
		// selecting the contract number
		if (!contractnum.equals("")) {
			waitForElement(driver, AContract_no_input);
			waitForElement(driver, AContractNumsearch);
			safeclick(driver, AContractNumsearch);
			waitForElement(driver, Ainputcontractnum);
			twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);

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
		}

		// Selecting the location

		if (Add_location_port_perform.equals("YES")) {

			List<String> datas = splitAndExpand(Add_location_port_input);
			for (String data : datas) {
			
				waitForElement(driver, ALocation_Add_Button);
				safeclick(driver, ALocation_Add_Button);
				twoColumnSearchWindow(driver, Location_Search, Condition_Filter, data);
				
			}
		} 

		// Entering Scalin reference
		if (!Scale_Reference_no.equals("")) {
			waitForElement(driver, AScale_in_ref_input);
			safeclick(driver, AScale_in_ref_input);
			sendKeys(driver, AScale_in_ref_input, Scale_Reference_no);
			safeclick(driver, ARemarks_Input);

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

}
