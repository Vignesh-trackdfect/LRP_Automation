package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC33 extends Keywords {
	public void Feeder_Contract_SC33(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_Excel_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC33";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Feeder_Contract_Module_Name = Excel_data.get("Feeder_Contract_Module_Name");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Vendor_Code_Value = Excel_data.get("Vendor_Code_Value");
		String Condition = Excel_data.get("Condition");
		String FC_Pol_Pop_Message = Excel_data.get("FC_Pol_Pop_Message");
		String FC_Input_details_Port_Header = Excel_data.get("FC_Input_details_Port_Header");
		String FC_Input_details_Port_Value = Excel_data.get("FC_Input_details_Port_Value");
		String FC_LoadTerm_Pop_Message = Excel_data.get("FC_LoadTerm_Pop_Message");
		String LoadTerm_Value = Excel_data.get("LoadTerm_Value");
		String LoadTerm_Header = Excel_data.get("LoadTerm_Header");
		String FC_Pod_Pop_Message = Excel_data.get("FC_Pod_Pop_Message");
		String POD_Input_Value = Excel_data.get("POD_Input_Value");
		String POD_Header = Excel_data.get("POD_Header");
		String FC_DischargeTerm_Pop_Message = Excel_data.get("FC_DischargeTerm_Pop_Message");
		String DischargeTerm_Header = Excel_data.get("DischargeTerm_Header");
		String DischargeTerm_Value = Excel_data.get("DischargeTerm_Value");
		String EquipmentType = Excel_data.get("EquipmentType");
		String Eqp_Status_Pop_Message = Excel_data.get("Eqp_Status_Pop_Message");
		String EquipmentStatus = Excel_data.get("EquipmentStatus");
		String ServiceCode_Pop_Message = Excel_data.get("ServiceCode_Pop_Message");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Service_Code_Value = Excel_data.get("Service_Code_Value");
		String Negotiated_Pop_Message = Excel_data.get("Negotiated_Pop_Message");
		String Negotiated_Value = Excel_data.get("Negotiated_Value");
		String Duration_Pop_Message = Excel_data.get("Duration_Pop_Message");
		String Pickup_Header = Excel_data.get("Pickup_Header");
		String Pickup_Value = Excel_data.get("Pickup_Value");
		String Drop_Header = Excel_data.get("Drop_Header");
		String Drop_Value = Excel_data.get("Drop_Value");
		String Amount_Input_Value = Excel_data.get("Amount_Input_Value");
		String Basis_Option = Excel_data.get("Basis_Option");
		String DurationType = Excel_data.get("DurationType");
		String Currency_Code_Header = Excel_data.get("Currency_Code_Header");
		String Currency_Code_Value = Excel_data.get("Currency_Code_Value");
		String Equipment_Pop_Message = Excel_data.get("Equipment_Pop_Message");
		String FC_Pop_Message = Excel_data.get("FC_Pop_Message");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field ", test, test1);
		moduleNavigate(driver, Feeder_Contract_Module_Name);
		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);

		waitForPopup(driver, popup_Message, FC_Pop_Message);

		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(FC_Pop_Message)) {
			System.out.println("Matched || " + " Expected saved poup : " + FC_Pop_Message + " || Actual saved popup : "
					+ Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + FC_Pop_Message
					+ " || Actual saved popup is : " + Applied_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + FC_Pop_Message
					+ " || Actual saved popup : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + FC_Pop_Message
					+ " || Actual saved popup is : " + Applied_Popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click1(driver, popup_Message_Ok_Button);

		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master ",
				test, test1);
	
		waitForElement(driver, FC_Vendor_Search_Button);
		click(driver, FC_Vendor_Search_Button);
		twoColumnSearchWindow(driver, Vendor_Code_Header, Condition, Vendor_Code_Value);
		
		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master ",
				test, test1);

		Step_Start(3, "Click on the '+'Button to add the all details", test, test1);

		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);
		
		Step_End(3, "Click on the '+'Button to add the all details", test, test1);

		Step_Start(4, "Click on the POL and Select the Load loaction.", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		waitForPopup(driver, popup_Message, FC_Pol_Pop_Message);

		String Applied_Pol_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Pol_Popup);
		if (Applied_Pol_Popup.equals(FC_Pol_Pop_Message)) {
			System.out.println("Matched || " + " Expected saved poup : " + FC_Pol_Pop_Message
					+ " || Actual saved popup : " + Applied_Pol_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + FC_Pol_Pop_Message
					+ " || Actual saved popup is : " + Applied_Pol_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + FC_Pol_Pop_Message
					+ " || Actual saved popup : " + Applied_Pol_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + FC_Pol_Pop_Message
					+ " || Actual saved popup is : " + Applied_Pol_Popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, FC_POL_Search);
		click(driver, FC_POL_Search);
		twoColumnSearchWindow(driver, FC_Input_details_Port_Header, Condition, FC_Input_details_Port_Value);

		Step_End(4, "Click on the POL and Select the Load loaction.", test, test1);

		Step_Start(5, "Click on the Load term search button and select the Terminal", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		waitForPopup(driver, popup_Message, FC_LoadTerm_Pop_Message);

		String Applied_LondTerm_Popup = getText(driver, popup_Message);
		System.out.println(Applied_LondTerm_Popup);
		if (Applied_LondTerm_Popup.equals(FC_LoadTerm_Pop_Message)) {
			System.out.println("Matched || " + " Expected saved poup : " + FC_LoadTerm_Pop_Message
					+ " || Actual saved popup : " + Applied_LondTerm_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + FC_LoadTerm_Pop_Message
					+ " || Actual saved popup is : " + Applied_LondTerm_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + FC_LoadTerm_Pop_Message
					+ " || Actual saved popup : " + Applied_LondTerm_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + FC_LoadTerm_Pop_Message
					+ " || Actual saved popup is : " + Applied_LondTerm_Popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, FC_Load_Term);
		click(driver, FC_Load_Term);
		twoColumnSearchWindow(driver, LoadTerm_Header, Condition, LoadTerm_Value);

		Step_End(5, "Click on the Load term search button and select the Terminal", test, test1);

		Step_Start(6, "Click on the POD and select the Discharge loction", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		waitForPopup(driver, popup_Message, FC_Pod_Pop_Message);
		String Applied_Pod_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Pod_Popup);
		if (Applied_Pod_Popup.equals(FC_Pod_Pop_Message)) {
			System.out.println("Matched || " + " Expected saved poup : " + FC_Pod_Pop_Message
					+ " || Actual saved popup : " + Applied_Pod_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + FC_Pod_Pop_Message
					+ " || Actual saved popup is : " + Applied_Pod_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + FC_Pod_Pop_Message
					+ " || Actual saved popup : " + Applied_Pod_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + FC_Pod_Pop_Message
					+ " || Actual saved popup is : " + Applied_Pod_Popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, FC_POD_Search);
		click(driver, FC_POD_Search);
		twoColumnSearchWindow(driver, POD_Header, Condition, POD_Input_Value);
		Step_End(6, "Click on the POD and select the Discharge loction", test, test1);

		Step_Start(7, ".Click on the Discharge term search button and select the Terminal", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		waitForPopup(driver, popup_Message, FC_DischargeTerm_Pop_Message);
		String Applied_DischargeTerm_Popup = getText(driver, popup_Message);
		System.out.println(Applied_DischargeTerm_Popup);
		if (Applied_DischargeTerm_Popup.equals(FC_DischargeTerm_Pop_Message)) {
			System.out.println("Matched || " + " Expected saved poup : " + FC_DischargeTerm_Pop_Message
					+ " || Actual saved popup : " + Applied_DischargeTerm_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + FC_DischargeTerm_Pop_Message
					+ " || Actual saved popup is : " + Applied_DischargeTerm_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + FC_DischargeTerm_Pop_Message
					+ " || Actual saved popup : " + Applied_DischargeTerm_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + FC_DischargeTerm_Pop_Message
					+ " || Actual saved popup is : " + Applied_DischargeTerm_Popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, FC_DischargeTerm);
		click(driver, FC_DischargeTerm);
		twoColumnSearchWindow(driver, DischargeTerm_Header, Condition, DischargeTerm_Value);
		Step_End(7, ".Click on the Discharge term search button and select the Terminal", test, test1);

		Step_Start(8, "Click on the Equipment drop down and select the equipment type", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		waitForPopup(driver, popup_Message, Equipment_Pop_Message);
		String Applied_Equiqment_Popup = getText(driver, popup_Message);

		System.out.println(Applied_Equiqment_Popup);
		if (Applied_Equiqment_Popup.equals(Equipment_Pop_Message)) {
			System.out.println("Matched || " + " Expected saved poup : " + Equipment_Pop_Message
					+ " || Actual saved popup : " + Applied_Equiqment_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + Equipment_Pop_Message
					+ " || Actual saved popup is : " + Applied_Equiqment_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + Equipment_Pop_Message
					+ " || Actual saved popup : " + Applied_Equiqment_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + Equipment_Pop_Message
					+ " || Actual saved popup is : " + Applied_Equiqment_Popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, FC_EquipmentDropdown);
		click(driver, FC_EquipmentDropdown);
		formatLocatorClick(driver, DropDown_Select, EquipmentType);
		Step_End(8, "Click on the Equipment drop down and select the equipment type", test, test1);

		Step_Start(9, "Click on the Eqp status drop down and Select the Status of the Equipment", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		waitForPopup(driver, popup_Message, Eqp_Status_Pop_Message);
		String Applied_EqpStatus_Popup = getText(driver, popup_Message);
		System.out.println(Applied_EqpStatus_Popup);
		if (Applied_EqpStatus_Popup.equals(Eqp_Status_Pop_Message)) {
			System.out.println("Matched || " + " Expected saved poup : " + Eqp_Status_Pop_Message
					+ " || Actual saved popup : " + Applied_EqpStatus_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + Eqp_Status_Pop_Message
					+ " || Actual saved popup is : " + Applied_EqpStatus_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + Eqp_Status_Pop_Message
					+ " || Actual saved popup : " + Applied_EqpStatus_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + Eqp_Status_Pop_Message
					+ " || Actual saved popup is : " + Applied_EqpStatus_Popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, FC_EqpStatusDropdown);
		click(driver, FC_EqpStatusDropdown);
		formatLocatorClick(driver, DropDown_Select, EquipmentStatus);
//		
		Step_End(9, "Click on the Eqp status drop down and Select the Status of the Equipment", test, test1);

		Step_Start(10, "Click on the Service code search button and select the Service code", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		waitForPopup(driver, popup_Message, ServiceCode_Pop_Message);
		String Applied_ServiceCode_Popup = getText(driver, popup_Message);
		System.out.println(Applied_ServiceCode_Popup);
		if (Applied_ServiceCode_Popup.equals(ServiceCode_Pop_Message)) {
			System.out.println("Matched || " + " Expected saved poup : " + ServiceCode_Pop_Message
					+ " || Actual saved popup : " + Applied_ServiceCode_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + ServiceCode_Pop_Message
					+ " || Actual saved popup is : " + Applied_ServiceCode_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + ServiceCode_Pop_Message
					+ " || Actual saved popup : " + Applied_ServiceCode_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + ServiceCode_Pop_Message
					+ " || Actual saved popup is : " + Applied_ServiceCode_Popup, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, FC_ServiceCode_Search);
		click(driver, FC_ServiceCode_Search);
		twoColumnSearchWindow(driver, Service_Code_Header, Condition, Service_Code_Value);

		Step_End(10, "Click on the Service code search button and select the Service code", test, test1);

		Step_Start(11, "Click on the Negotiated By drop down and select the Value", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		waitForPopup(driver, popup_Message, Negotiated_Pop_Message);
		String Applied_Negotiated_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Negotiated_Popup);
		if (Applied_Negotiated_Popup.equals(Negotiated_Pop_Message)) {
			System.out.println("Matched || " + " Expected saved poup : " + Negotiated_Pop_Message
					+ " || Actual saved popup : " + Applied_Negotiated_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + Negotiated_Pop_Message
					+ " || Actual saved popup is : " + Applied_Negotiated_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + Negotiated_Pop_Message
					+ " || Actual saved popup : " + Applied_Negotiated_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + Negotiated_Pop_Message
					+ " || Actual saved popup is : " + Applied_Negotiated_Popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, FC_NegotiatedBy_dropdown);
		click(driver, FC_NegotiatedBy_dropdown);
		formatLocatorClick(driver, DropDown_Select, Negotiated_Value);

		Step_End(11, "Click on the Negotiated By drop down and select the Value", test, test1);

		Step_Start(12, "Select the Duration type", test, test1);

		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);

		waitForPopup(driver, popup_Message, Duration_Pop_Message);
		String Applied_Duration_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Duration_Popup);
		if (Applied_Duration_Popup.equals(Duration_Pop_Message)) {
			System.out.println("Matched || " + " Expected saved poup : " + Duration_Pop_Message
					+ " || Actual saved popup : " + Applied_Duration_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + Duration_Pop_Message
					+ " || Actual saved popup is : " + Applied_Duration_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + Duration_Pop_Message
					+ " || Actual saved popup : " + Applied_Duration_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + Duration_Pop_Message
					+ " || Actual saved popup is : " + Applied_Duration_Popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, FC_DurationType);
		click(driver, FC_DurationType);
		formatLocatorClick(driver, DropDown_Select, DurationType);
		Step_End(12, "Select the Duration type", test, test1);

		Step_Start(13, "Click on the PickupTerminal and Select the terminal based on the POL", test, test1);

		waitForElement(driver, FC_PickupTerminal);
		click(driver, FC_PickupTerminal);
		twoColumnSearchWindow(driver, Pickup_Header, Condition, Pickup_Value);
		Step_End(13, "Click on the PickupTerminal and Select the terminal based on the POL", test, test1);

		Step_Start(14, "Click on the Drop Terminal and select the Terminal based on the POD", test, test1);

		waitForElement(driver, FC_DropTerminal);
		click(driver, FC_DropTerminal);
		twoColumnSearchWindow(driver, Drop_Header, Condition, Drop_Value);
		Step_End(14, "Click on the Drop Terminal and select the Terminal based on the POD", test, test1);

		Step_Start(15, "Click on the Currency search button and select the Currency", test, test1);

		waitForElement(driver, FC_CurrencySearch);
		click(driver, FC_CurrencySearch);

		twoColumnSearchWindow(driver, Currency_Code_Header, Condition, Currency_Code_Value);
		Step_End(15, "Click on the Currency search button and select the Currency", test, test1);

		Step_Start(16, "Click on the amount field and enter the amount based on the currency", test, test1);

		waitForElement(driver, FC_AmountInput);
		click(driver, FC_AmountInput);
		Newclear(driver, FC_AmountInput);
		sendKeys(driver, FC_AmountInput, Amount_Input_Value);
		Step_End(16, "Click on the amount field and enter the amount based on the currency", test, test1);

		Step_Start(17, "Select the Basis while click the Drop down", test, test1);

		waitForElement(driver, FC_BasisDropdown);
		click(driver, FC_BasisDropdown);
		formatLocatorClick(driver, DropDown_Select, Basis_Option);
		Step_End(17, "Select the Basis while click the Drop down", test, test1);

		Step_Start(18, "Select the valid fromand valid to date", test, test1);
		selectDatePicker(driver, FC_ValidTo, ValidTo);
		selectDatePicker(driver, FC_ValidFrom, ValidFrom);
		
		waitForElement(driver, FC_Add_Ok);
		click(driver, FC_Add_Ok);
		
		Step_End(18, "Select the valid fromand valid to date", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}