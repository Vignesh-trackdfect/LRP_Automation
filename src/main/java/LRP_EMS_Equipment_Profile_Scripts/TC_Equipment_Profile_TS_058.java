package LRP_EMS_Equipment_Profile_Scripts;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Equipment_Profile_TS_058 extends Keywords{
	
//	Check whether that system allows to save a new container records
	
public void saveNewContainerRecords(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
	String testCaseName="TC_Equipment_Profile_TS_058";

//  Get data from excel sheet	
	
	
	
	
    String username = Excel_data.get("Username");
    String password = Excel_data.get("Password");
    String moduleName = Excel_data.get("ModuleEquipmentProfile");
	String tareWeight = Excel_data.get("TareWeight");
	String payLoad = Excel_data.get("PayLoad");
	
	String eqpNoSave=Excel_data.get("EqpProfileEquipmentNo2");
	String eqpType=Excel_data.get("EqpType");
	String sizeType=Excel_data.get("SizeType");
	String soc=Excel_data.get("SOC");
	String eqpuipmentStatus=Excel_data.get("EqpuipmentStatus");
	String fleetGroup=Excel_data.get("FleetGroup");
	String equipmentSavedPopup=Excel_data.get("EquipmentSavedPopup");
	String onHireLocation=Excel_data.get("OnHireLocation");
	String manufactureDate=Excel_data.get("ManufactureDate");
	
	String specialUnit=Excel_data.get("SpecialUnit");
	String eqpOwned=Excel_data.get("Owned");
	String contractRefNumber=Excel_data.get("ContractRefNumber");
	String disposalRegNumber=Excel_data.get("DisposalRegNumber");
	String datePicker=Excel_data.get("DatePicker");
	
	String stackHeight=Excel_data.get("StackHeight");
	String injectionPort=Excel_data.get("InjectionPort");
	String domicile=Excel_data.get("Domicile");
	String contractID1=Excel_data.get("ContractID1");
	String contractID2=Excel_data.get("ContractID2");
	String contractID3=Excel_data.get("ContractID3");
	
	String onhireDate=Excel_data.get("OnhireDate");
	String redeliveryPort=Excel_data.get("RedeliveryPort");
	
	String redeliveryDate=Excel_data.get("RedeliveryDate");
	String leasingRefNo=Excel_data.get("LeasingRefNo");
	String leasingContractNo=Excel_data.get("LeasingContractNo");
	String subleaseContract=Excel_data.get("SubleaseContract");
	String supplierContract=Excel_data.get("SupplierContract");
	String lessorCode=Excel_data.get("LessorCode");
	String lesseeCode=Excel_data.get("LesseeCode");
	String perDiem=Excel_data.get("PerDiem");
	String leaseKind1=Excel_data.get("LeaseKind1");
	String leaseKind2=Excel_data.get("LeaseKind2");
	String leaseTerm=Excel_data.get("LeaseTerm");
	String submittedToJointVenture=Excel_data.get("SubmittedToJointVenture");
	
	String dropdownCondition = Excel_data.get("DropdownCondition");
	String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
	String globalSearchFilterOption2 = Excel_data.get("globalSearchFilterOption2");
	String globalSearchFilterOption3 = Excel_data.get("globalSearchFilterOption3");
	String searchValue2 = Excel_data.get("searchValue2");
	String searchValue3 = Excel_data.get("searchValue3");
	String Want_To_Delete = Excel_data.get("Want_To_Delete");

	navigateUrl(driver, url);

	Extent_Start(testCaseName, test, test1);
	
	String equipmentType=String.format(equipment_Type, eqpType);
	String sizeType1=String.format(size_Type1, sizeType);
	String socInput=String.format(soc_Input, soc);


	// Login
	LRP_Login(driver, username, password);
	
//	Module Search
	moduleNavigate(driver, moduleName);
	
	Step_Start(1,"Click on the New toolbar button." , test, test1);
	
	waitForDisplay(driver,  newButton_EquipmentProfile_Homepage);
	if(isdisplayed(driver,  newButton_EquipmentProfile_Homepage)) {
		click(driver,  newButton_EquipmentProfile_Homepage);
	}
	
	waitForElement(driver, cancel_Common_btn);
	click(driver, cancel_Common_btn);

	
	newButton(driver);
	
	Step_End(1,"Click on the New toolbar button." , test, test1);

	Step_Start(2, "Enter the container number in the \"Equipment Number\" field.", test, test1);
	
	waitForElement(driver, eqpNoTextField_L);
	click(driver, eqpNoTextField_L);
	sendKeys(driver, eqpNoTextField_L, eqpNoSave);

	waitForElement(driver, isoDropDown_L);
	String iso = getText(driver, isoDropDown_L);
	System.out.println("Before ISO:"+iso);
	
	Step_End(2, "Enter the container number in the \"Equipment Number\" field.", test, test1);
	Step_Start(3, "Click the dropdown button for \"Equipment Type.\"", test, test1);
	
	waitForElement(driver, eqpTypeDropDown_L);
	click(driver, eqpTypeDropDown_L);
	
	Step_End(3, "Click the dropdown button for \"Equipment Type.\"", test, test1);
	
	Step_Start(4, "Select the equipment type for the respective container number.", test, test1);

	waitForElement(driver, equipmentType);
	click(driver, equipmentType);
	
	Step_End(4, "Select the equipment type for the respective container number.", test, test1);
	Step_Start(5, "Click the dropdown button for \"Size Type.\"", test, test1);
	
	waitForElement(driver, sizeTypeDropDownEqPro_L);
	click(driver, sizeTypeDropDownEqPro_L);
	
	Step_End(5, "Click the dropdown button for \"Size Type.\"", test, test1);
	
	Step_Start(6, "Select the size type from the dropdown options.", test, test1);
	
		waitForElement(driver, sizeType1);
		click(driver,sizeType1);
		
	waitForElement(driver, isoDropDown_L);
	
	Step_End(6, "Select the size type from the dropdown options.", test, test1);
	
	Step_Start(7, "Check if the ISO values are automatically updated based on the size type.", test, test1);
	
	waitForElement(driver, isoDropDown_L);
	String isoAfter = getText(driver, isoDropDown_L);
	System.out.println("ISO After:" + isoAfter);

	if (!isoAfter.equals(iso)) {
		System.out.println("Not Matched || ISO before : " + iso + " || ISO After  : " + isoAfter);
		Extent_pass_New(driver, "Not Matched || ISO before  : " + iso + " || ISO After : " + isoAfter +"\r\n"+"ISO value is updated automatically and it is verified", test,test1);
		System.out.println("ISO value is updated automatically and it is verified");
	} else {
		System.out.println( "Matched || ISO before  : " + iso + " || ISO After : " + isoAfter);
		System.out.println("ISO value is not updated automatically and it is verified");
		Extent_fail(driver,  "Matched || ISO before  : " + iso + " || ISO After : " + isoAfter+"\r\n"+"ISO value is not updated automatically and it is verified", test,test1);
	}
	Step_End(7, "Check if the ISO values are automatically updated based on the size type.", test, test1);
	
	Step_Start(8, "Choose \"Shipper Owned Container\" (S.O.C) as 'Y' or 'N' using the dropdown.", test, test1);
	
	waitForElement(driver, sosDropDown_L);
	click(driver, sosDropDown_L);
	
	waitForElement(driver, socInput);
	click(driver,socInput);
	
	Step_End(8, "Choose \"Shipper Owned Container\" (S.O.C) as 'Y' or 'N' using the dropdown.", test, test1);
	
	
	if(!onHireLocation.equals("")) {
		click(driver, onHireLocation_Searchfield);
		waitForElement(driver, onHireLocation_Searchfield);
		clearAndType(driver, onHireLocation_Searchfield, onHireLocation);
		enter(driver);
		}
	
	waitForElement(driver, manufacturedDate_L);
	
	if(datePicker.equalsIgnoreCase("Yes")) {
		selectDatePicker(driver, manufacturedDate_L, manufactureDate);

		}else {
			click(driver, manufacturedDate_L);

		if(manufactureDate.contains("-")) {
			String manufactureDate_1=manufactureDate.replace("-", "/");
			clear(driver,manufacturedDate_L);
			sendKeys(driver, manufacturedDate_L, manufactureDate_1);
			
		}else {
		clearAndType(driver, manufacturedDate_L, manufactureDate);
		
		}		
	}
	
	waitForElement(driver, specialUnitDropDown_L);
	click(driver, specialUnitDropDown_L);
	String select_SpecialUnit=String.format(specialUnit_field, specialUnit);
	waitForElement(driver, select_SpecialUnit);
	click(driver, select_SpecialUnit);
	
	
	if(soc.equals("N")) {
		waitForElement(driver, ownedDropdown_L);
		click(driver, ownedDropdown_L);
		
			String select_Owned=String.format(owned_field, eqpOwned);
			waitForElement(driver, select_Owned);
			click(driver, select_Owned);
	}
	
	
	if(!contractRefNumber.equals("")) {
		click(driver, contractRefNum_Textfield);
		clearAndType(driver, contractRefNum_Textfield, contractRefNumber);
	}
	
	if(!disposalRegNumber.equals("")) {
		click(driver, disposalRegNum);
		clearAndType(driver, disposalRegNum, disposalRegNumber);
		}
	
	waitForElement(driver, maxGrossWeightTextField_L);
	String beforeGross = getAttribute(driver, maxGrossWeightTextField_L, "value");
	System.out.println("Before max gross Weight:" + beforeGross);

	Step_Start(9, "Enter the Tare Weight values in the field.", test, test1);
	
	waitForElement(driver, tareWeightTextField_L);
	click(driver, tareWeightTextField_L);
	waitForElement(driver, tareWeightTextField_L);
	clear(driver, tareWeightTextField_L);
	waitForElement(driver, tareWeightTextField_L);
	sendKeys(driver, tareWeightTextField_L, tareWeight);
	waitForElement(driver, tareWeightTextField_L);
	clearAndType(driver, tareWeightTextField_L, tareWeight);

	Step_End(9, "Enter the Tare Weight values in the field.", test, test1);
	Step_Start(10, "Enter the Payload values in the field.", test, test1);
	
	waitForElement(driver, payLoadTextField_L);
	clear(driver, payLoadTextField_L);
	waitForElement(driver, payLoadTextField_L);
	sendKeys(driver, payLoadTextField_L, payLoad);
	
	Step_End(10, "Enter the Payload values in the field.", test, test1);
	Step_Start(11, "Verify if the Max Gross Weight is auto-calculated based on Tare Weight & Payload.", test, test1);
	
	waitForElement(driver, tareWeightTextField_L);
	String tareWeightAfter = getAttribute(driver, tareWeightTextField_L, "value");
	String actual_TareWeight=tareWeightAfter.replace(",", "");
	String payLoadAfter = getAttribute1(driver, payLoadTextField_2, "value");
	String actual_PayLoad=payLoadAfter.replace(",", "");

	System.out.println("Tare weight after:" + tareWeightAfter);
	System.out.println("Payload after:" + payLoadAfter);

	waitForElement(driver, tareWeightTextField_L);
	click(driver, tareWeightTextField_L);
	
	waitForElement(driver, maxGrossWeightTextField_L);
	String afterGross = getAttribute(driver, maxGrossWeightTextField_L, "value");
	System.out.println("After max gross Weight:" + afterGross);
	String act_Gross=afterGross.replace(",", "");
	System.out.println("act_Gross:"+act_Gross);
	
	DecimalFormat df=new DecimalFormat("0.00");

	double tareDoub=Double.parseDouble(actual_TareWeight);
	String actualTareWeight=df.format(tareDoub);
	System.out.println("actualTareWeight:"+actualTareWeight);

	double payDoub=Double.parseDouble(actual_PayLoad);
	String actualPayLoad=df.format(payDoub);
	System.out.println("actualPayLoad:"+actualPayLoad);	
	
	double maxGross=tareDoub+payDoub;
	System.out.println("maxGross:"+maxGross);

	double actual_Gross=Double.parseDouble(act_Gross);
	String actGross=df.format(actual_Gross);
	System.out.println("actual_Gross : "+actGross);
	
	String actMaxGross=df.format(maxGross);
	System.out.println("actMaxGross:"+actMaxGross);
	
	// Verification			
	
	if (actGross.equals(actMaxGross)) {
		System.out.println("Matched || " + " Expected Gross weight  : " + actMaxGross + " || Actual Gross weight  : " + actGross);
		Extent_pass_New(driver,"Matched || " + " Expected Gross weight  : " + actMaxGross + " || Actual Gross weight  : " + actGross,test,test1);
		Extent_pass_New(driver, "max Gross weight is calculated and it is verified", test,test1);
		System.out.println("max Gross weight is calculated and it is verified");
	} else {
		System.out.println("Not matched || " + " Expected Gross weight  : " + actMaxGross + " || Actual Gross weight  : " + actGross);
		System.out.println("max Gross weight is not calculated and it is verified");
		Extent_fail(driver,"Not matched || " + " Expected Gross weight  : " + actMaxGross + " || Actual Gross weight  : " + actGross +"<br>"+"max Gross weight is not calculated and it is verified",test,test1);
	}

	if (actualTareWeight.equals(tareWeight) && actualPayLoad.equals(payLoad)) {
		System.out.println("Matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight);
		Extent_pass_New(driver,"Matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight,test,test1);
		System.out.println("Matched || " + " Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad);
		Extent_pass_New(driver,"Matched || " + " Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad,test,test1);			
		Extent_pass_New(driver, "Tare weight & Pay load are updated and it is verified", test,test1);
		System.out.println("Tare weight & Pay load are updated and it is verified");
	} else {
		System.out.println("Not matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight);
		System.out.println("Not matched || " + " Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad);
		System.out.println("Tare weight & Pay load are not updated and it is verified");
		Extent_fail(driver,"Not matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight+"<br>"+" Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad+"<br>"+"Tare weight & Pay load are not updated and it is verified",test,test1);
	}
	
	Step_End(11, "Verify if the Max Gross Weight is auto-calculated based on Tare Weight & Payload.", test, test1);
	
	if(!stackHeight.equals("")) {
		click(driver, stackHeight_Textfield);
		clearAndType(driver, stackHeight_Textfield, stackHeight);
		waitForElement(driver, grossStacking_Textfield);
		click(driver, grossStacking_Textfield);
		}
	
	if(!injectionPort.equals("")) {
		waitForElement(driver, injectionPort_Dropdown);
		click(driver, injectionPort_Dropdown);
			
			String select_InjectionPort=String.format(injection_Port, injectionPort);
			waitForElement(driver, select_InjectionPort);
			click(driver,select_InjectionPort);
		
	}
	
	if(!domicile.equals("")) {
		click(driver, domcile_Searchfield);
		clearAndType(driver, domcile_Searchfield, domicile);
		enter(driver);
		}
	
	Step_Start(12, "Click the dropdown button for \"Equipment Status.\"", test, test1);
	
	waitForElement(driver, eqpStatusDropDown_L);
	click(driver, eqpStatusDropDown_L);
	
	Step_End(12, "Click the dropdown button for \"Equipment Status.\"", test, test1);

	Step_Start(13, "Select \"Active\" as the Equipment Status from the dropdown options.", test, test1);
		String select_Status=String.format(eqp_Status, eqpuipmentStatus);
		waitForElement(driver, select_Status);
		click(driver, select_Status);
	
	Step_End(13, "Select \"Active\" as the Equipment Status from the dropdown options.", test, test1);
	
	if(!contractID1.equals("")) {
		click(driver, contractId1_Textfield);
		clearAndType(driver, contractId1_Textfield, contractID1);
		}
	
	if(!contractID2.equals("")) {
		click(driver, contractId2_Textfield);
		clearAndType(driver, contractId2_Textfield, contractID2);
		}
	
	if(!contractID3.equals("")) {
		click(driver, contractId3_Textfield);
		clearAndType(driver, contractId3_Textfield, contractID3);
		}
	
	if(!onhireDate.equals("")) {
	waitForElement(driver, onHireDate_Textfield);
	
	if(datePicker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, onHireDate_Textfield, onhireDate);
	
		}else {
			click(driver, onHireDate_Textfield);

		if(onhireDate.contains("-")) {
			String onhireDate_1=onhireDate.replace("-", "/");
			clear(driver,onHireDate_Textfield);
			sendKeys(driver, onHireDate_Textfield, onhireDate_1);
			
		}else {
		clearAndType(driver, onHireDate_Textfield, onhireDate);
		
		}		
	}

	}

	if(!redeliveryPort.equals("")) {
		click(driver, redeliveryPort_Searchfield);
		clearAndType(driver, redeliveryPort_Searchfield, redeliveryPort);
		enter(driver);
		}
	
	if(!redeliveryDate.equals("")) {
		waitForElement(driver, redeliveryDate_Textfield);
		
		if(datePicker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, redeliveryDate_Textfield, redeliveryDate);

			}else {
				click(driver, redeliveryDate_Textfield);

			if(redeliveryDate.contains("-")) {
				String redeliveryDate_1=redeliveryDate.replace("-", "/");
				clear(driver,redeliveryDate_Textfield);
				sendKeys(driver, redeliveryDate_Textfield, redeliveryDate_1);
				
			}else {
			clearAndType(driver, redeliveryDate_Textfield, redeliveryDate);
			}		
		}
		
		}

	Step_Start(14, "Click the dropdown button for \"Fleet Group.\"", test, test1);
	
	waitForElement(driver, fleetGroupDropDown_L);
	click(driver, fleetGroupDropDown_L);
	
	Step_End(14, "Click the dropdown button for \"Fleet Group.\"", test, test1);
	Step_Start(15, "Select \"Active Fleet\" as the Fleet group from the dropdown options.", test, test1);
	
	String select_FleetGroup=String.format(fleet_Group, fleetGroup);
	waitForElement(driver, select_FleetGroup);
	click(driver, select_FleetGroup);

	Step_End(15, "Select \"Active Fleet\" as the Fleet group from the dropdown options.", test, test1);
	
	if(!leasingRefNo.equals("")) {
		click(driver, leasingRefNo_Textfield);
		clearAndType(driver, leasingRefNo_Textfield, leasingRefNo);
		}
	
	if(!leasingContractNo.equals("")) {
		click(driver, leasingContractRef_Textfield);
		clearAndType(driver, leasingContractRef_Textfield, leasingContractNo);
		}
	
	if(!subleaseContract.equals("")) {
		click(driver, subleaseContract_Textfield);
		clearAndType(driver, subleaseContract_Textfield, subleaseContract);
		}
	
	if(!supplierContract.equals("")) {
		click(driver, subleaseContract_Textfield);
		clearAndType(driver, subleaseContract_Textfield, supplierContract);
		}
	
	if(!lessorCode.equals("")) {
		waitForElement(driver, lessorCode_Dropdown);
		click(driver, lessorCode_Dropdown);
		String select_LessorCode=String.format(lessor_Code, lessorCode);
		waitForElement(driver, select_LessorCode);
		click(driver, select_LessorCode);
		
	}
	if(!lesseeCode.equals("")) {
		waitForElement(driver, lesseeCode_Dropdown);
		click(driver, lesseeCode_Dropdown);
		String select_LesseeCode=String.format(lessee_Code, lesseeCode);
		waitForElement(driver, select_LesseeCode);
		click(driver, select_LesseeCode);
	}

	if(!perDiem.equals("")) {
		click(driver, perDiem_Textfield);
		clearAndType(driver, perDiem_Textfield, perDiem);
		}
	
	if(!leaseKind1.equals("")) {
		waitForElement(driver, leaseKind_Dropdown2);
		click(driver, leaseKind_Dropdown2);
		String select_LeaseKind1=String.format(leaseKind_1, leaseKind1);
		waitForElement(driver, select_LeaseKind1);
		click(driver, select_LeaseKind1);
		
	}
	if(!leaseTerm.equals("")) {
		waitForElement(driver, leaseTerm_Dropdown2);
		click(driver, leaseTerm_Dropdown2);
		String select_LeaseTerm=String.format(lease_Term, leaseTerm);
		waitForElement(driver, select_LeaseTerm);
		click(driver, select_LeaseTerm);
		
	}
	
	if(!leaseKind2.equals("")) {
		waitForElement(driver, leaseKind_Dropdown3);
		click(driver, leaseKind_Dropdown3);
		String select_LeaseKind2=String.format(leaseKind_2, leaseKind2);
		waitForElement(driver, select_LeaseKind2);
		click(driver, select_LeaseKind2);
		
	}
	
	if(!submittedToJointVenture.equals("")) {
		waitForElement(driver, submittedToJoint);
		click(driver, submittedToJoint);
		String select_SubmittedToJointVenture=String.format(submittedToJoin_Venture, submittedToJointVenture);
		waitForElement(driver, select_SubmittedToJointVenture);
		click(driver, select_SubmittedToJointVenture);
	}

	scrollTop(driver);
	waitForElement(driver, SaveButton_ToolBar);
	click(driver, SaveButton_ToolBar);

//	Saved popup
	
	waitForPopup(driver, Popup_Message, equipmentSavedPopup);
	String actualSavedPopup=getText(driver, Popup_Message);
	if (actualSavedPopup.equals(equipmentSavedPopup)) {
		
		Extent_pass_New(driver,equipmentSavedPopup+ " popup is displayed", test,test1);
		Extent_pass_New(driver, "Matched || Expected : "+equipmentSavedPopup+" || Actual : "+actualSavedPopup, test,test1);
		System.out.println("Matched || Expected : "+equipmentSavedPopup+" || Actual : "+actualSavedPopup);
		System.out.println(equipmentSavedPopup+" popup is displayed");
	} else {
		System.out.println("Not Matched || Expected : "+equipmentSavedPopup+" || Actual : "+actualSavedPopup);
		System.out.println(equipmentSavedPopup+" popup is not displayed");
		Extent_fail(driver, "Not Matched || Expected : "+equipmentSavedPopup+" || Actual : "+actualSavedPopup+"<br>"+equipmentSavedPopup+" popup is not displayed", test,test1);

	}	


// Retrieve the saved record
	
	Step_Start(16, "Retrive the saved record", test, test1);
	
	scrollTop(driver);
	waitForElement(driver, SearchButton_Toolbar);
	click(driver, SearchButton_Toolbar);
	
	globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, eqpNoSave, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

	if(Want_To_Delete.equalsIgnoreCase("Yes")) {
	scrollTop(driver);
	waitForElement(driver, Delete_button_toolBar);
	click(driver, Delete_button_toolBar);

	waitForElement(driver, popup_Message_Yes_Button);
	click(driver, popup_Message_Yes_Button);
	
	waitForElement(driver, Popup_Message);

}
	Step_End(16, "Retrive the saved record", test, test1);
	
	
	Extent_completed(testCaseName, test, test1);
}

}
