package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC35 extends Keywords {

	public void Feeder_Contract_SC35(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC35";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Vendor_Header = Excel_data.get("Vendor_Header");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String POL_Header = Excel_data.get("POL_Header");
		String POL_Value = Excel_data.get("POL_Value");
		String POD_Header = Excel_data.get("POD_Header");
		String POD_Value = Excel_data.get("POD_Value");
		String LoadTerm_Header = Excel_data.get("LoadTerm_Header");
		String LoadTerm_Value = Excel_data.get("LoadTerm_Value");
		String EquipmentType = Excel_data.get("EquipmentType");
		String EquipmentStatus = Excel_data.get("EquipmentStatus");
		String NegotiatedBy = Excel_data.get("NegotiatedBy");
		String DurationType = Excel_data.get("DurationType");
		String Pickup_Header = Excel_data.get("Pickup_Header");
		String Pickup_Value = Excel_data.get("Pickup_Value");
		String Drop_Header = Excel_data.get("Drop_Header");
		String Drop_Value = Excel_data.get("Drop_Value");
		String DischargeTerm_Header = Excel_data.get("DischargeTerm_Header");
		String DischargeTerm_Value = Excel_data.get("DischargeTerm_Value");
		String Service_Header = Excel_data.get("Service_Header");
		String Service_Value = Excel_data.get("Service_Value");
		String AmountValue = Excel_data.get("AmountValue");
		String Basis_Option = Excel_data.get("Basis_Option");
		String ValidFrom = Excel_data.get("ValidFrom");
		String ValidTo = Excel_data.get("ValidTo");
		String POL_popup = Excel_data.get("POL_popup");
		String POD_popup = Excel_data.get("POD_popup");
		String Load_Term_popup = Excel_data.get("Load_Term_popup");
		String Discharge_Term_popup = Excel_data.get("Discharge_Term_popup");
		String Equipment_popup = Excel_data.get("Equipment_popup");
		String Equipment_Status_popup = Excel_data.get("Equipment_Status_popup");
		String Service_Code_popup = Excel_data.get("Service_Code_popup");
		String Negotiated_By_popup = Excel_data.get("Negotiated_By_popup");
		String Duration_Type_popup = Excel_data.get("Duration_Type_popup");
		String Pickup_Location_popup = Excel_data.get("Pickup_Location_popup");
		String Drop_Location_popup = Excel_data.get("Drop_Location_popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master",
				test, test1);

		waitForElement(driver, FC_Vendor_Search_Button);
		click(driver, FC_Vendor_Search_Button);

		twoColumnSearchWindow(driver, Vendor_Header, Two_Column_Condition, Vendor_Code);

		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master",
				test, test1);

		Step_Start(3, "Click on the '+' Button to add the all details ", test, test1);

		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);

		Step_End(3, "Click on the '+' Button to add the all details ", test, test1);

		Step_Start(4, "It show the Feeder Contract input details page", test, test1);

		if (isdisplayed(driver, FC_DurationType)) {
			System.out.println(
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is displayed");
			Extent_pass_New(driver,
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is displayed",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is not displayed");
			Extent_fail(driver,
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is not displayed",
					test, test1);

		}

		Step_End(4, "It show the Feeder Contract input details page", test, test1);

		Step_Start(5, "Click \"OK\" ,without enter the values ,It shows the POP up validation based on the field.",
				test, test1);

		if (!POL_Value.equals("")) {
			waitForElement(driver, FC_POL_Search);
			click(driver, FC_POL_Search);

			twoColumnSearchWindow(driver, POL_Header, Two_Column_Condition, POL_Value);
		}
		if (!POD_Value.equals("")) {
			waitForElement(driver, FC_POD_Search);
			click(driver, FC_POD_Search);

			twoColumnSearchWindow(driver, POD_Header, Two_Column_Condition, POD_Value);
		}
		if (!LoadTerm_Value.equals("")) {

			waitForElement(driver, FC_Load_Term);
			click(driver, FC_Load_Term);

			twoColumnSearchWindow(driver, LoadTerm_Header, Two_Column_Condition, LoadTerm_Value);
		}
		if (!EquipmentType.equals("")) {
			waitForElement(driver, FC_EquipmentDropdown);
			click(driver, FC_EquipmentDropdown);

			formatLocatorClick(driver, DropDown_Select, EquipmentType);
		}
		if (!EquipmentStatus.equals("")) {
			waitForElement(driver, FC_EqpStatusDropdown);
			click(driver, FC_EqpStatusDropdown);

			formatLocatorClick(driver, DropDown_Select, EquipmentStatus);
		}

		if (!NegotiatedBy.equals("")) {
			waitForElement(driver, FC_NegotiatedBy_dropdown);
			click(driver, FC_NegotiatedBy_dropdown);

			formatLocatorClick(driver, DropDown_Select, NegotiatedBy);
		}

		if (!DurationType.equals("")) {
			waitForElement(driver, FC_DurationType);
			click(driver, FC_DurationType);

			formatLocatorClick(driver, DropDown_Select, DurationType);
		}

		if (!Pickup_Value.equals("")) {
			waitForElement(driver, FC_PickupTerminal);
			click(driver, FC_PickupTerminal);

			if (POL_Value.equals("")) {
				waitForPopup(driver, popup_Message, Pickup_Location_popup);

				String Actualpopup = getText(driver, popup_Message);

				if (Pickup_Location_popup.equals(Actualpopup)) {

					System.out.println("Matched || Expected popup message was : " + Pickup_Location_popup
							+ " || Actual popup message was : " + Actualpopup);
					Extent_pass_New(driver, "Matched || Expected popup message was : " + Pickup_Location_popup
							+ " || Actual popup message was : " + Actualpopup, test, test1);
				} else {

					System.out.println("Not Matched || Expected popup message was : " + Pickup_Location_popup
							+ " || Actual popup message was : " + Actualpopup);
					Extent_fail(driver, "Not Matched || Expected popup message was : " + Pickup_Location_popup
							+ " || Actual popup message was : " + Actualpopup, test, test1);

				}

				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);

			} else {

				twoColumnSearchWindow(driver, Pickup_Header, Two_Column_Condition, Pickup_Value);
			}
		}

		if (!Drop_Value.equals("")) {
			waitForElement(driver, FC_DropTerminal);
			click(driver, FC_DropTerminal);

			if (POD_Value.equals("")) {

				waitForPopup(driver, popup_Message, Drop_Location_popup);

				String Actualpopup = getText(driver, popup_Message);

				if (Drop_Location_popup.equals(Actualpopup)) {

					System.out.println("Matched || Expected popup message was : " + Drop_Location_popup
							+ " || Actual popup message was : " + Actualpopup);
					Extent_pass_New(driver, "Matched || Expected popup message was : " + Drop_Location_popup
							+ " || Actual popup message was : " + Actualpopup, test, test1);
				} else {

					System.out.println("Not Matched || Expected popup message was : " + Drop_Location_popup
							+ " || Actual popup message was : " + Actualpopup);
					Extent_fail(driver, "Not Matched || Expected popup message was : " + Drop_Location_popup
							+ " || Actual popup message was : " + Actualpopup, test, test1);

				}
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			} else {

				twoColumnSearchWindow(driver, Drop_Header, Two_Column_Condition, Drop_Value);
			}

		}

		if (!DischargeTerm_Value.equals("")) {
			waitForElement(driver, FC_DischargeTerm);
			click(driver, FC_DischargeTerm);

			twoColumnSearchWindow(driver, DischargeTerm_Header, Two_Column_Condition, DischargeTerm_Value);
		}

		if (!Service_Value.equals("")) {
			waitForElement(driver, FC_ServiceCode_Search);
			click(driver, FC_ServiceCode_Search);

			twoColumnSearchWindow(driver, Service_Header, Two_Column_Condition, Service_Value);
		}

		if (!AmountValue.equals("")) {
			waitForElement(driver, FC_AmountInput);
			click(driver, FC_AmountInput);
			Newclear(driver, FC_AmountInput);
			sendKeys(driver, FC_AmountInput, AmountValue);

			Tab(driver);
		}

		if (!Basis_Option.equals("")) {

			waitForElement(driver, FC_BasisDropdown);
			click(driver, FC_BasisDropdown);

			formatLocatorClick(driver, DropDown_Select, Basis_Option);
		}

		if (!ValidTo.equals("")) {

			selectDatePicker(driver, FC_ValidTo, ValidTo);
		}
		if (!ValidFrom.equals("")) {

			selectDatePicker(driver, FC_ValidFrom, ValidFrom);
		}
		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		if (POL_Value.equals("")) {
			waitForPopup(driver, popup_Message, POL_popup);

			String Actualpopup = getText(driver, popup_Message);

			if (POL_popup.equals(Actualpopup)) {

				System.out.println("Matched || Expected popup message was : " + POL_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_pass_New(driver, "Matched || Expected popup message was : " + POL_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);
			} else {

				System.out.println("Not Matched || Expected popup message was : " + POL_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_fail(driver, "Not Matched || Expected popup message was : " + POL_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);

			}
		}

		if (POD_Value.equals("")) {
			waitForPopup(driver, popup_Message, POD_popup);

			String Actualpopup = getText(driver, popup_Message);

			if (POD_popup.equals(Actualpopup)) {

				System.out.println("Matched || Expected popup message was : " + POD_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_pass_New(driver, "Matched || Expected popup message was : " + POD_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);
			} else {

				System.out.println("Not Matched || Expected popup message was : " + POD_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_fail(driver, "Not Matched || Expected popup message was : " + POD_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);

			}
		}

		if (LoadTerm_Value.equals("")) {
			waitForPopup(driver, popup_Message, Load_Term_popup);

			String Actualpopup = getText(driver, popup_Message);

			if (Load_Term_popup.equals(Actualpopup)) {

				System.out.println("Matched || Expected popup message was : " + Load_Term_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_pass_New(driver, "Matched || Expected popup message was : " + Load_Term_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);
			} else {

				System.out.println("Not Matched || Expected popup message was : " + Load_Term_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_fail(driver, "Not Matched || Expected popup message was : " + Load_Term_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);

			}
		}

		if (EquipmentStatus.equals("")) {
			waitForPopup(driver, popup_Message, Equipment_Status_popup);

			String Actualpopup = getText(driver, popup_Message);

			if (Equipment_Status_popup.equals(Actualpopup)) {

				System.out.println("Matched || Expected popup message was : " + Equipment_Status_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_pass_New(driver, "Matched || Expected popup message was : " + Equipment_Status_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);
			} else {

				System.out.println("Not Matched || Expected popup message was : " + Equipment_Status_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_fail(driver, "Not Matched || Expected popup message was : " + Equipment_Status_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);

			}
		}

		if (EquipmentType.equals("")) {
			waitForPopup(driver, popup_Message, Equipment_popup);

			String Actualpopup = getText(driver, popup_Message);

			if (Equipment_popup.equals(Actualpopup)) {

				System.out.println("Matched || Expected popup message was : " + Equipment_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_pass_New(driver, "Matched || Expected popup message was : " + Equipment_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);
			} else {

				System.out.println("Not Matched || Expected popup message was : " + Equipment_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_fail(driver, "Not Matched || Expected popup message was : " + Equipment_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);

			}
		}

		if (NegotiatedBy.equals("")) {

			waitForPopup(driver, popup_Message, Negotiated_By_popup);

			String Actualpopup = getText(driver, popup_Message);

			if (Negotiated_By_popup.equals(Actualpopup)) {

				System.out.println("Matched || Expected popup message was : " + Negotiated_By_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_pass_New(driver, "Matched || Expected popup message was : " + Negotiated_By_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);
			} else {

				System.out.println("Not Matched || Expected popup message was : " + Negotiated_By_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_fail(driver, "Not Matched || Expected popup message was : " + Negotiated_By_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);

			}
		}

		if (DurationType.equals("")) {
			waitForPopup(driver, popup_Message, Duration_Type_popup);

			String Actualpopup = getText(driver, popup_Message);

			if (Duration_Type_popup.equals(Actualpopup)) {

				System.out.println("Matched || Expected popup message was : " + Duration_Type_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_pass_New(driver, "Matched || Expected popup message was : " + Duration_Type_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);
			} else {

				System.out.println("Not Matched || Expected popup message was : " + Duration_Type_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_fail(driver, "Not Matched || Expected popup message was : " + Duration_Type_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);

			}
		}

		if (DischargeTerm_Value.equals("")) {
			waitForPopup(driver, popup_Message, Discharge_Term_popup);

			String Actualpopup = getText(driver, popup_Message);

			if (Discharge_Term_popup.equals(Actualpopup)) {

				System.out.println("Matched || Expected popup message was : " + Discharge_Term_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_pass_New(driver, "Matched || Expected popup message was : " + Discharge_Term_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);
			} else {

				System.out.println("Not Matched || Expected popup message was : " + Discharge_Term_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_fail(driver, "Not Matched || Expected popup message was : " + Discharge_Term_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);

			}
		}
		if (Service_Value.equals("")) {
			waitForPopup(driver, popup_Message, Service_Code_popup);

			String Actualpopup = getText(driver, popup_Message);

			if (Service_Code_popup.equals(Actualpopup)) {

				System.out.println("Matched || Expected popup message was : " + Service_Code_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_pass_New(driver, "Matched || Expected popup message was : " + Service_Code_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);
			} else {

				System.out.println("Not Matched || Expected popup message was : " + Service_Code_popup
						+ " || Actual popup message was : " + Actualpopup);
				Extent_fail(driver, "Not Matched || Expected popup message was : " + Service_Code_popup
						+ " || Actual popup message was : " + Actualpopup, test, test1);

			}
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(5, "Click \"OK\" ,without enter the values ,It shows the POP up validation based on the field.", test,
				test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
