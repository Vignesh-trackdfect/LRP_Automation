package LRP_EMS_Consolidation_Scripts;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Equipment_Profile_TS057_To_TS061_C extends Keywords {
	
	public void equipmentProfileConsolidate(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset) {
	
		String testCaseName57="TC_Equipment_Profile_TS_057";
		//  Get data from excel sheet	
			String File_Path57 = TestNgXml.getfilePath_FromExecution().get(testCaseName57);
			String Sheet_Name57 = TestNgXml.getsheetName_FromExecution().get(testCaseName57);
			String URL = TestNgXml.getdatafromExecution().get("TC_Equipment_Profile_TS057_To_TS061_C");
			
			Map<String, String> Excel_data57 = Utils.GetAllData(Sheet_Name57, testCaseName57, "Dataset"+selected_Excel_dataset, File_Path57);		
	        String username = Excel_data57.get("Username");
	        String password = Excel_data57.get("Password");
	       
			navigateUrl(driver, URL);

	     // Login
			LRP_Login(driver, username, password);
			
	        boolean ts057=true;
			if(ts057==true) {
			
				String testCaseName="TC_Equipment_Profile_TS_057";
				//  Get data from excel sheet	
					String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
					String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
					
					Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName, "Dataset"+selected_Excel_dataset, File_Path);		
			        String moduleName = Excel_data.get("ModuleEquipmentProfile");
			        String eqpProEqpNo = Excel_data.get("EqpProfileEquipmentNo");
					String tareWeight = Excel_data.get("TareWeight");
					String payLoad = Excel_data.get("PayLoad");
					String updatedPopup = Excel_data.get("UpdatedPopup");

					String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
					String dropdownCondition = Excel_data.get("DropdownCondition");

					String globalSearchFilterOption2 = Excel_data.get("globalSearchFilterOption2");
					String globalSearchFilterOption3 = Excel_data.get("globalSearchFilterOption3");
					String searchValue2 = Excel_data.get("searchValue2");
					String searchValue3 = Excel_data.get("searchValue3");
					
					
					Extent_Start(testCaseName, test, test1);
					
//					Module Search
					moduleNavigate(driver, moduleName);
					
					Step_Start(1, "Click global search icon", test, test1);
					
					waitForDisplay(driver,  newButton_EquipmentProfile_Homepage);
					if(isdisplayed(driver,  newButton_EquipmentProfile_Homepage)) {
						click(driver,  newButton_EquipmentProfile_Homepage);
					}
					
					waitForElement(driver, SearchButton_Toolbar);
					click(driver, SearchButton_Toolbar);
					
					Step_End(1, "Click global search icon ", test, test1);
					Step_Start(2, "Enter valid container no in equipment no field", test, test1);
					
					globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, eqpProEqpNo, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

					
					Step_End(2, "Enter valid container no in equipment no field", test, test1);
					
					waitForElement(driver, eqpNoTextField_L);
					String actEqNo = getAttribute(driver, eqpNoTextField_L, "value");
					System.out.println("Actual:" + actEqNo);
					System.out.println("Expected:" + eqpProEqpNo);
					
					waitForElement(driver, maxGrossWeightTextField_L);
					String beforeGross = getAttribute(driver, maxGrossWeightTextField_L, "value");
					String tareWeightBefore = getAttribute(driver, tareWeightTextField_L, "value");
					String payLoadBefore = getAttribute(driver, payLoadTextField_L, "value");
					System.out.println("Before max gross Weight:" + beforeGross);
					System.out.println("Tare weight before:" + tareWeightBefore);
					System.out.println("Payload before:" + payLoadBefore);
					
					
					Step_Start(3, "Clik Edit button ", test, test1);
						waitForElement(driver, Edit_Button_toolBar);
						click(driver, Edit_Button_toolBar);

						Step_End(3, "Clik Edit button ", test, test1);
						
						Step_Start(4, "Enter updated amount for Tare & Payload field ", test, test1);
						waitForElement(driver, tareWeightTextField_L);
						click(driver, tareWeightTextField_L);
						waitForElement(driver, tareWeightTextField_L);
						clear(driver, tareWeightTextField_L);
						waitForElement(driver, tareWeightTextField_L);
						sendKeys(driver, tareWeightTextField_L, tareWeight);
						waitForElement(driver, tareWeightTextField_L);
						clearAndType(driver, tareWeightTextField_L, tareWeight);

						waitForElement(driver, payLoadTextField_L);
						clear(driver, payLoadTextField_L);
						waitForElement(driver, payLoadTextField_L);
						sendKeys(driver, payLoadTextField_L, payLoad);
						
						scrollTop(driver);
						waitForElement(driver, SaveButton_ToolBar);
						click(driver, SaveButton_ToolBar);
						Step_End(4, "Enter updated amount for Tare & Payload field ", test, test1);
//				Updated popup
					Step_Start(5, "Updated Popup Verification", test, test1);
					waitForPopup(driver, Popup_Message, updatedPopup);

					String actualPopup=getText(driver, Popup_Message);
					System.out.println("actualPopup: "+actualPopup);
					if(actualPopup.equals(updatedPopup)) {
						Extent_pass_New(driver, "Matched || Expected popup: "+updatedPopup+" || Actual popup: "+actualPopup, test, test1);
						System.out.println("Matched || Expected popup: "+updatedPopup+" || Actual popup: "+actualPopup);
					}else {
						System.out.println("Not Matched || Expected popup: "+updatedPopup+" || Actual popup: "+actualPopup);
						Extent_fail(driver, "Not Matched || Expected popup: "+updatedPopup+" || Actual popup: "+actualPopup +"<br>"+updatedPopup+" popup is not displayed", test, test1);
					}
					
					Step_End(5, "Updated Popup Verification", test, test1);
					
					Step_Start(6, "Gross will calculate automatically", test, test1);
					waitForElement(driver, tareWeightTextField_L);
					String tareWeightAfter = getAttribute(driver, tareWeightTextField_L, "value");
					String actual_TareWeight=tareWeightAfter.replace(",", "");
					String payLoadAfter = getAttribute(driver, payLoadTextField_L, "value");
					String actual_PayLoad=payLoadAfter.replace(",", "");

					System.out.println("Tare weight after:" + tareWeightAfter);
					System.out.println("Payload after:" + payLoadAfter);

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
				
					if (actualTareWeight.equals(tareWeight)) {
						System.out.println("Matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight);
						Extent_pass_New(driver,"Matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight,test,test1);
								
						Extent_pass_New(driver, "Tare weight updated and it is verified", test,test1);
						System.out.println("Tare weight updated and it is verified");
					} else {
						System.out.println("Not matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight);
						System.out.println("Tare weight not updated and it is verified");
						Extent_fail(driver,"Not matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight+"<br>"+"Tare weight not updated and it is verified",test,test1);
					}
					if (actualPayLoad.equals(payLoad)) {
						System.out.println("Matched || " + " Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad);
						Extent_pass_New(driver,"Matched || " + " Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad,test,test1);			
						Extent_pass_New(driver, "Pay load updated and it is verified", test,test1);
						System.out.println("Pay load updated and it is verified");
					} else {
						System.out.println("Not matched || " + " Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad);
						System.out.println("Pay load not updated and it is verified");
						Extent_fail(driver,"Not matched || Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad+"<br>"+"Pay load not updated and it is verified",test,test1);
					}
					Step_End(6, "Gross will calculate automatically", test, test1);
				
					Extent_completed(testCaseName, test, test1);

			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			}
			
			boolean ts058=true;
			if(ts058==true) {
				
				String testCaseName="TC_Equipment_Profile_TS_058";

			//  Get data from excel sheet	
				
				String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
				String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
				
				Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName, "Dataset"+selected_Excel_dataset, File_Path);		
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


				Extent_Start(testCaseName, test, test1);
				
				String equipmentType=String.format(equipment_Type, eqpType);
				String sizeType1=String.format(size_Type1, sizeType);
				String socInput=String.format(soc_Input, soc);

//				Module Search
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

//				Saved popup
				
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
				
				scrollTop(driver);
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
				
			}
			
			boolean ts059=true;
			if(ts059==true) {
				
				String testCaseName="TC_Equipment_Profile_TS_059";
				String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
				String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
				Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName,"Dataset" + selected_Excel_dataset, File_Path);
				String moduleName = Excel_data.get("ModuleEquipmentProfile");
				String retrieveRecord = Excel_data.get("RetrieveRecord");
				String dropdownCondition = Excel_data.get("DropdownCondition");
				String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
				String globalSearchFilterOption2 = Excel_data.get("globalSearchFilterOption2");
				String globalSearchFilterOption3 = Excel_data.get("globalSearchFilterOption3");
				String searchValue2 = Excel_data.get("searchValue2");
				String searchValue3 = Excel_data.get("searchValue3");
				
			Extent_Start(testCaseName, test, test1);

//				Module Search
			moduleNavigate(driver, moduleName);
			

			Step_Start(1, "Click the Global search button in the toolbar", test, test1);
			
			waitForDisplay(driver,  newButton_EquipmentProfile_Homepage);
			if(isdisplayed(driver,  newButton_EquipmentProfile_Homepage)) {
				click(driver,  newButton_EquipmentProfile_Homepage);
			}
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			Step_End(1, "Click the Global search button in the toolbar", test, test1);
			
			Step_Start(2, "Enter the saved Equipment Number in the search list", test, test1);
			Step_Start(3, "Click the search button once a valid Equipment number is entered", test, test1);
			Step_Start(4, "Double-click on the saved record from the AgGrid table.", test, test1);

			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, retrieveRecord, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);


				Step_End(2, "Enter the saved Equipment Number in the search list", test, test1);
				Step_End(3, "Click the search button once a valid Equipment number is entered", test, test1);
				Step_End(4, "Double-click on the saved record from the AgGrid table.", test, test1);
				Step_Start(5, "Verify The Retrieved Equipment Number", test, test1);
			
				waitForElement(driver, eqpNoTextField_L);

			String actEqNo = getAttribute(driver, eqpNoTextField_L, "value");
			System.out.println("Actual:" + actEqNo);
			System.out.println("Expected:" + retrieveRecord);
			if (actEqNo.equals(retrieveRecord)) {
				System.out.println("Matched || " + " Expected  : " + retrieveRecord + " || Actual  : " + actEqNo);
				Extent_pass_New(driver, "Matched || " + " Expected  : " + retrieveRecord + " || Actual  : " + actEqNo, test,test1);
				Extent_pass_New(driver, "The saved record is retrieved by using global search and it is verified", test, test1);
				System.out.println("The saved record is retrieved by using global search and it is verified");
			} else {
				System.out.println("Not matched || " + " Expected  : " + retrieveRecord + " || Actual  : " + actEqNo);
				System.out.println("The saved record is not retrieved by using global search and it is verified");
				Extent_fail(driver, "Not matched || " + " Expected  : " + retrieveRecord + " || Actual  : " + actEqNo+"<br>"+"The saved record is not retrieved by using global search and it is verified", test,test1);
			}
			String tareWeightAfter = getAttribute(driver, tareWeightTextField_L, "value");
			String payLoadAfter = getAttribute(driver, payLoadTextField_L, "value");
			String afterGross = getAttribute(driver, maxGrossWeightTextField_L, "value");

			if (!tareWeightAfter.equals("")) {
				System.out.println("Tare weight :" + tareWeightAfter);
				Extent_pass_New(driver, "Tare weight "  + tareWeightAfter, test, test1);
			}
			if (!payLoadAfter.equals("")) {
				System.out.println("Payload :" + payLoadAfter);
				Extent_pass_New(driver, "Payload  " + payLoadAfter, test, test1);
			}
			if (!afterGross.equals("")) {
				System.out.println(" max gross Weight:" + afterGross);
				Extent_pass_New(driver, "Gross weight  " + afterGross, test, test1);
			}

			
			Step_End(5, "Verify The Retrieved Equipment Number", test, test1);
				Extent_completed(testCaseName, test, test1);
				
				scrollTop(driver);
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);				
			}
			
			boolean ts060=true;
			if(ts060==true) {
				
				String testCaseName="TC_Equipment_Profile_TS_060";
				String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
				String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
				Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName,"Dataset" + selected_Excel_dataset, File_Path);
				String moduleName = Excel_data.get("ModuleEquipmentProfile");
				String tareWeightUpdate = Excel_data.get("TareWeight");
				String payLoadUpdate = Excel_data.get("PayLoad");
				String eqpNoEdit = Excel_data.get("EditEqpNo");
				String updatedPopup = Excel_data.get("UpdatedPopup");
				String datePicker = Excel_data.get("DatePicker");
				
				String manufactureDate = Excel_data.get("ManufactureDate");
				String specialUnitUpdate = Excel_data.get("SpecialUnitUpdate");
				String eqpSOC = Excel_data.get("EqpSOC");
				String eqpOwned = Excel_data.get("Owned");
				
				
				String eqpType=Excel_data.get("EqpType");
				String sizeType=Excel_data.get("SizeType");
				String soc=Excel_data.get("SOC");
				String eqpuipmentStatus=Excel_data.get("EqpuipmentStatus");
				String fleetGroup=Excel_data.get("FleetGroup");
				String iso=Excel_data.get("ISO");
				String onHireLocation=Excel_data.get("OnHireLocation");
				String contractRefNumber=Excel_data.get("ContractRefNumber");
				String disposalRegNumber=Excel_data.get("DisposalRegNumber");
				
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

				Extent_Start(testCaseName, test, test1);
				
//				Module Search
				moduleNavigate(driver, moduleName);
				

				Step_Start(1, "Enter the Containner number in the equipment number field.", test, test1);
				
				waitForDisplay(driver,  newButton_EquipmentProfile_Homepage);
				if(isdisplayed(driver,  newButton_EquipmentProfile_Homepage)) {
					click(driver,  newButton_EquipmentProfile_Homepage);
				}
				
				waitForElement(driver, eqpNoTextField_L);
				sendKeys(driver, eqpNoTextField_L, eqpNoEdit);
				
				Step_End(1, "Enter the Containner number in the equipment number field.", test, test1);
				Step_Start(2, "Click the refresh[Yellow colour] button.", test, test1);
				
				waitForElement(driver, refreshButton_L);
				click(driver, refreshButton_L);
				
				Step_End(2, "Click the refresh[Yellow colour] button.", test, test1);
				Step_Start(3, "Click on the \"Edit\" button from the toolbar", test, test1);
				
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
				
				Step_End(3, "Click on the \"Edit\" button from the toolbar", test, test1);
				Step_Start(4, "Edit the Required Fields below {Special Unit, Manufactured Date, Owned, Tare Weight & PayLoad}", test, test1);
				
				Extent_call(test, test1, "Edit Manufactured Date");
				waitForElement(driver, manufacturedDate_L);
				String manufactureDate_1=manufactureDate.replace("-", "/");

				if(datePicker.equalsIgnoreCase("Yes")) {
					if (isDisplayed(driver, Calender)) {
						selectDatePicker(driver, manufacturedDate_L, manufactureDate);
			
					}
					}else {
						click(driver, manufacturedDate_L);

					if(manufactureDate.contains("-")) {
						clear(driver,manufacturedDate_L);
						sendKeys(driver, manufacturedDate_L, manufactureDate_1);
						
					}else {
					clearAndType(driver, manufacturedDate_L, manufactureDate);
					}		
				}
				

				Extent_call(test, test1, "Edit Special Unit");
				waitForElement(driver, specialUnitDropDown_L);
				click(driver, specialUnitDropDown_L);
				String select_SpecialUnit=String.format(specialUnit_field, specialUnitUpdate);
				waitForElement(driver, select_SpecialUnit);
				click(driver, select_SpecialUnit);

				Extent_call(test, test1, "Edit Owned");
				if (eqpSOC.equals("N")) {
					waitForElement(driver, ownedDropdown_L);
					click(driver, ownedDropdown_L);
					String select_Owned=String.format(owned_field, eqpOwned);
					waitForElement(driver, select_Owned);
					click(driver, select_Owned);
				}
				Extent_call(test, test1, "Edit Tare Weight");

				waitForElement(driver, tareWeightTextField_L);
				click(driver, tareWeightTextField_L);
				waitForElement(driver, tareWeightTextField_L);
				clear(driver, tareWeightTextField_L);
				waitForElement(driver, tareWeightTextField_L);
				sendKeys(driver, tareWeightTextField_L, tareWeightUpdate);
				waitForElement(driver, tareWeightTextField_L);
				clearAndType(driver, tareWeightTextField_L, tareWeightUpdate);

				Extent_call(test, test1, "Edit PayLoad");

				waitForElement(driver, payLoadTextField_L);
				clear(driver, payLoadTextField_L);
				waitForElement(driver, payLoadTextField_L);
				sendKeys(driver, payLoadTextField_L, payLoadUpdate);

//				Non mandatory
				
				if(!eqpType.equals("")) {
				waitForElement(driver, eqpTypeDropDown_L);
				click(driver, eqpTypeDropDown_L);
				String equipmentType=String.format(equipment_Type, eqpType);
				waitForElement(driver, equipmentType);
				click(driver, equipmentType);
				}
				
				if(!sizeType.equals("")) {
				waitForElement(driver, sizeTypeDropDownEqPro_L);
				click(driver, sizeTypeDropDownEqPro_L);
				
				String sizeType1=String.format(size_Type1, sizeType);

					waitForElement(driver, sizeType1);
					click(driver,sizeType1);
				
				waitForElement(driver, isoDropDown_L);
				
				String isoAfter = getText(driver, isoDropDown_L);
				System.out.println("ISO After:" + isoAfter);

				if (!isoAfter.equals(iso)) {
					System.out.println("Not Matched || ISO before : " + iso + " || ISO After  : " + isoAfter);
					Extent_pass_New(driver, " Not Matched || ISO before  : " + iso + " || ISO After : " + isoAfter, test,test1);
					Extent_pass_New(driver, "ISO value is updated automatically and it is verified", test,test1);
					System.out.println("ISO value is updated automatically and it is verified");
				} else {
					System.out.println( " Matched || ISO before  : " + iso + " || ISO After : " + isoAfter);
					System.out.println("ISO value is not updated automatically and it is verified");
					Extent_fail(driver,  " Matched || ISO before  : " + iso + " || ISO After : " + isoAfter+"<br>"+"ISO value is not updated automatically and it is verified", test,test1);
				}
				}
				
				if(!eqpSOC.equals("")) {
				waitForElement(driver, sosDropDown_L);
				click(driver, sosDropDown_L);
				String socInput=String.format(soc_Input, soc);

				waitForElement(driver, socInput);
				click(driver,socInput);
				}
				
				
				if(!onHireLocation.equals("")) {
					click(driver, onHireLocation_Searchfield);
					clearAndType(driver, onHireLocation_Searchfield, onHireLocation);
					enter(driver);
					}
				
				if(!contractRefNumber.equals("")) {
					waitForElement(driver, contractRefNum_Textfield);
					click(driver, contractRefNum_Textfield);
					waitForElement(driver, contractRefNum_Textfield);
					clearAndType(driver, contractRefNum_Textfield, contractRefNumber);
					}
				
				if(!disposalRegNumber.equals("")) {
					waitForElement(driver, disposalRegNum);
					click(driver, disposalRegNum);
					waitForElement(driver, disposalRegNum);
					clearAndType(driver, disposalRegNum, disposalRegNumber);
					}
				
				if(!stackHeight.equals("")) {
					waitForElement(driver, stackHeight_Textfield);
					click(driver, stackHeight_Textfield);
					waitForElement(driver, stackHeight_Textfield);
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
					waitForElement(driver, domcile_Searchfield);
					click(driver, domcile_Searchfield);
					waitForElement(driver, domcile_Searchfield);
					clearAndType(driver, domcile_Searchfield, domicile);
					enter(driver);
					
					}
				
				if(!eqpuipmentStatus.equals("")) {		
				waitForElement(driver, eqpStatusDropDown_L);
				click(driver, eqpStatusDropDown_L);
				String select_Status=String.format(eqp_Status, eqpuipmentStatus);

					waitForElement(driver, select_Status);
					click(driver, select_Status);
				}
				
				if(!contractID1.equals("")) {
					waitForElement(driver, contractId1_Textfield);
					click(driver, contractId1_Textfield);
					waitForElement(driver, contractId1_Textfield);
					clearAndType(driver, contractId1_Textfield, contractID1);
					}
				if(!contractID2.equals("")) {
					waitForElement(driver, contractId2_Textfield);
					click(driver, contractId2_Textfield);
					waitForElement(driver, contractId2_Textfield);
					clearAndType(driver, contractId2_Textfield, contractID2);
					}
				
				if(!contractID3.equals("")) {
					waitForElement(driver, contractId3_Textfield);
					click(driver, contractId3_Textfield);
					waitForElement(driver, contractId3_Textfield);
					clearAndType(driver, contractId3_Textfield, contractID3);
					}
				if(!onhireDate.equals("")) {
					waitForElement(driver, onHireDate_Textfield);
				String onhireDate_1=onhireDate.replace("-", "/");

				if(datePicker.equalsIgnoreCase("Yes")) {

					selectDatePicker(driver, onHireDate_Textfield, onhireDate);

					}else {
						click(driver, onHireDate_Textfield);

					if(onhireDate.contains("-")) {
						clear(driver,onHireDate_Textfield);
						wait(driver,"1");
						sendKeys(driver, onHireDate_Textfield, onhireDate_1);
						
					}else {
					clearAndType(driver, onHireDate_Textfield, onhireDate);
					
					}		
				}
				}

				if(!redeliveryPort.equals("")) {
					waitForElement(driver, redeliveryPort_Searchfield);
					click(driver, redeliveryPort_Searchfield);
					waitForElement(driver, redeliveryPort_Searchfield);
					clearAndType(driver, redeliveryPort_Searchfield, redeliveryPort);
					enter(driver);
					}
				
				if(!redeliveryDate.equals("")) {
					waitForElement(driver, redeliveryDate_Textfield);
					String redeliveryDate_1=redeliveryDate.replace("-", "/");

					waitForElement(driver, Calender);
					if(datePicker.equalsIgnoreCase("Yes")) {

						selectDatePicker(driver, redeliveryDate_Textfield, redeliveryDate);

						}
						else {
							click(driver, redeliveryDate_Textfield);

						if(redeliveryDate.contains("-")) {
							clear(driver,redeliveryDate_Textfield);
							sendKeys(driver, redeliveryDate_Textfield, redeliveryDate_1);
							
						}else {
						clearAndType(driver, redeliveryDate_Textfield, redeliveryDate);
						}		
					
					}
					}

				if(!fleetGroup.equals("")) {
				waitForElement(driver, fleetGroupDropDown_L);
				click(driver, fleetGroupDropDown_L);
				String select_FleetGroup=String.format(fleet_Group, fleetGroup);

				waitForElement(driver, select_FleetGroup);
				click(driver, select_FleetGroup);
				}
				
				if(!leasingRefNo.equals("")) {
					waitForElement(driver, leasingRefNo_Textfield);
					click(driver, leasingRefNo_Textfield);
					waitForElement(driver, leasingRefNo_Textfield);
					clearAndType(driver, leasingRefNo_Textfield, leasingRefNo);
					}
				
				if(!leasingContractNo.equals("")) {
					waitForElement(driver, leasingContractRef_Textfield);
					click(driver, leasingContractRef_Textfield);
					waitForElement(driver, leasingContractRef_Textfield);
					clearAndType(driver, leasingContractRef_Textfield, leasingContractNo);
					}
				
				if(!subleaseContract.equals("")) {
					waitForElement(driver, subleaseContract_Textfield);
					click(driver, subleaseContract_Textfield);
					waitForElement(driver, subleaseContract_Textfield);
					clearAndType(driver, subleaseContract_Textfield, subleaseContract);
					}
				if(!supplierContract.equals("")) {
					waitForElement(driver, supplierContract_Textfield);
					click(driver, supplierContract_Textfield);
					waitForElement(driver, supplierContract_Textfield);
					clearAndType(driver, supplierContract_Textfield, supplierContract);
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
					waitForElement(driver, perDiem_Textfield);
					click(driver, perDiem_Textfield);
					waitForElement(driver, perDiem_Textfield);
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
				
				waitForPopup(driver, Popup_Message, updatedPopup);
				String actUpdatedPopup = getText(driver, Popup_Message);
				if (actUpdatedPopup.equals(updatedPopup)) {
					System.out.println("Matched || " + " Expected Popup : " + updatedPopup + " || Actual Popup : " + actUpdatedPopup);

					Extent_pass_New(driver, "Matched || " + " Expected Popup : " + updatedPopup + " || Actual Popup : " + actUpdatedPopup+"<br>"+updatedPopup+" is displayed", test,test1);
				} else {
					System.out.println("Not matched || " + " Expected Popup : " + updatedPopup + " || Actual Popup : " + actUpdatedPopup);

					Extent_fail(driver, "Not matched || " + " Expected Popup : " + updatedPopup + " || Actual Popup : " + actUpdatedPopup+"<br>"+updatedPopup+" is not displayed",test, test1);
				}

				
				String mfdAfter = getAttribute(driver, manufacturedDate_L, "value");
				String spclUnitAfter = getText(driver, specialUnitDropDown_L);
				String ownedAfter = getText(driver, ownedDropdown_L);
				System.out.println("Manufactured Date:" + mfdAfter);
				System.out.println("Special unit After:" + spclUnitAfter);
				System.out.println("Owned before:" + ownedAfter);

				String tareWeightAfter = getAttribute(driver, tareWeightTextField_L, "value");
				String actual_TareWeight=tareWeightAfter.replace(",", "");
				String payLoadAfter = getAttribute(driver, payLoadTextField_L, "value");
				String actual_PayLoad=payLoadAfter.replace(",", "");

				System.out.println("Tare weight after:" + tareWeightAfter);
				System.out.println("Payload after:" + payLoadAfter);

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

				if (actualTareWeight.equals(tareWeightUpdate)) {
					System.out.println("Matched || " + "Expected Tare weight : " + tareWeightUpdate + " || Actual Tare weight : "+ actualTareWeight);
					Extent_pass_New(driver, "Matched || " + "Expected Tare weight : " + tareWeightUpdate + " || Actual Tare weight : "+ actualTareWeight, test, test1);
					
					Extent_pass_New(driver, "Tare weight updated and it is verified", test, test1);
					System.out.println("Tare weight updated and it is verified");
				} else {
					System.out.println("Not matched || " + "Expected Tare weight : " + tareWeightUpdate+ " || Actual Tare weight : " + actualTareWeight);

					System.out.println("Tare weight not updated and it is verified");
					
					Extent_fail(driver, "Not matched || " + "Expected Tare weight : " + tareWeightUpdate+ " || Actual Tare weight : " + actualTareWeight, test, test1);
				}

				if (actualPayLoad.equals(payLoadUpdate)) {
					
					System.out.println("Matched || " + " Expected Payload : " + payLoadUpdate + " || Actual Payload : " + actualPayLoad);
					Extent_pass_New(driver,"Matched || " + " Expected Payload : " + payLoadUpdate + " || Actual Payload : " + actualPayLoad, test,test1);
					Extent_pass_New(driver, "Pay load updated and it is verified", test, test1);
					System.out.println("Pay load updated and it is verified");
				} else {
					
					System.out.println("Not matched || " + " Expected Payload : " + payLoadUpdate + " || Actual Payload : " + actualPayLoad);
					System.out.println("Pay load not updated and it is verified");
					Extent_fail(driver, "Not matched || Expected Payload : " + payLoadUpdate + " || Actual Payload : " + actualPayLoad, test, test1);
				}
				
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

				if (mfdAfter.equals(manufactureDate_1) ) {
					System.out.println("Matched || " + "Expected Manufactured Date  : " + manufactureDate_1
							+ " || Actual Manufactured date : " + mfdAfter);
					Extent_pass_New(driver, "Matched || " + "Expected Manufactured Date  : " + manufactureDate_1
							+ " || Actual Manufactured date : " + mfdAfter, test, test1);
					Extent_pass_New(driver, "manufactured date is edited and it is verified", test, test1);
					System.out.println("manufactured date is edited and it is verified");

				} else {
					System.out.println("Not matched || " + "Expected Manufactured Date  : " + manufactureDate_1
							+ " || manufactured date after : " + mfdAfter);

					Extent_fail(driver, "Not matched || " + "Expected Manufactured Date  : " + manufactureDate_1
							+ " || manufactured date after : " + mfdAfter, test, test1);
				}
				if (spclUnitAfter.equals(specialUnitUpdate)) {
					

					System.out.println("Matched || " + " Expected special unit : " + specialUnitUpdate
							+ " || Actual special unit : " + spclUnitAfter);
					Extent_pass_New(driver, "Matched || " + " Expected special unit : " + specialUnitUpdate
							+ " || Actual special unit : " + spclUnitAfter, test, test1);
					Extent_pass_New(driver, "special unit is edited and it is verified", test, test1);
					System.out.println("special unit is edited and it is verified");
					
				} else {
					
					System.out.println("Not matched || " + " Expected special unit : " + specialUnitUpdate
							+ " || Actual special unit : " + spclUnitAfter);
					
					Extent_fail(driver, "Not matched || " + " Expected special unit : " + specialUnitUpdate
							+ " || Actual special unit : " + spclUnitAfter, test, test1);
				}
				if (ownedAfter.equals(eqpOwned)) {

					System.out.println("Matched || " + "Expected Owned : " + eqpOwned + " || Actual Owned : " + ownedAfter);
					Extent_pass_New(driver, "Matched || " + "Expected Owned : " + eqpOwned + " || Actual Owned : " + ownedAfter, test,
							test1);
					Extent_pass_New(driver, "Owned is edited and it is verified", test, test1);
					System.out.println("Owned is edited and it is verified");
				} else {
					System.out.println("Not matched || " + "Expected Owned : " + eqpOwned + " || Actual Owned : " + ownedAfter);
					Extent_fail(driver, "Not matched || " + "Expected Owned : " + eqpOwned + " || Actual Owned : " + ownedAfter,test, test1);
				}
				Step_End(4, "Edit the Required Fields below {Special Unit, Manufactured Date, Owned, Tare Weight & PayLoad}", test, test1);

				Extent_completed(testCaseName, test, test1); 

				
				scrollTop(driver);
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);				
			}
		boolean ts061=true;
		if(ts061==true) {
			
			String testCaseName="TC_Equipment_Profile_TS_061";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName,"Dataset" + selected_Excel_dataset, File_Path);
			String moduleName = Excel_data.get("ModuleEquipmentProfile");
			String cannotDelEqp = Excel_data.get("MovementEntry_EquipmentNo");
			String deletedPopup = Excel_data.get("DeletedPopup");
			String noRecords = Excel_data.get("NoRecords");
			String cannotDelelePopup = Excel_data.get("CannotDelelePopup");	
			String eqpNoDelete = Excel_data.get("EquipmentNumber_Delete");
			String wantToDeletepopup = Excel_data.get("WantToDeletePopup");
			String dropdownCondition = Excel_data.get("DropdownCondition");
			String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
			String globalSearchFilterOption2 = Excel_data.get("globalSearchFilterOption2");
			String globalSearchFilterOption3 = Excel_data.get("globalSearchFilterOption3");
			String searchValue2 = Excel_data.get("searchValue2");
			String searchValue3 = Excel_data.get("searchValue3");
			
			Extent_Start(testCaseName, test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);
			
			waitForDisplay(driver,  newButton_EquipmentProfile_Homepage);
			if(isdisplayed(driver,  newButton_EquipmentProfile_Homepage)) {
				click(driver,  newButton_EquipmentProfile_Homepage);
			}
			
			waitForElement(driver, cancel_Common_btn);
			click(driver, cancel_Common_btn);

			// Delete

			Step_Start(1, "Click the Global search button in the toolbar", test, test1);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			Step_End(1, "Click the Global search button in the toolbar", test, test1);
			
			Step_Start(2, "Enter the Equipment Number in the search list", test, test1);
			Step_Start(3, "Click on the search Button once Equipment number entered", test, test1);
			Step_Start(4, "Double click on the saved record from the AgGrid table", test, test1);

			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, eqpNoDelete, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

				Step_End(2, "Enter the Equipment Number in the search list", test, test1);
				
				Step_End(3, "Click on the search Button once Equipment number entered", test, test1);
				
				Step_End(4, "Double click on the saved record from the AgGrid table", test, test1);
				Step_Start(5, "Click on the Delete button in the toolbar", test, test1);
				
				scrollTop(driver);
				waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);

				Step_End(5, "Click on the Delete button in the toolbar", test, test1);
				Step_Start(6, "Press 'Yes' in the Popup message to delete", test, test1);
				
				waitForPopup(driver, popup_Message, wantToDeletepopup);
				String actualWantToDeletePopup1=getText(driver, popup_Message);
				System.out.println("wantToDeletePopup:"+actualWantToDeletePopup1);
				
				if (actualWantToDeletePopup1.equals(wantToDeletepopup)) {				
					System.out.println("Matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup1);
					Extent_pass_New(driver, "Matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup1, test,test1);
					click(driver, popup_Message_Yes_Button);

				} else {
					System.out.println("Not matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup1);
					Extent_fail(driver, "Not matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup1+"<br>"+wantToDeletepopup + " popup is not diplayed and it is verified",test, test1);
				}
				
				Step_End(6, "Press 'Yes' in the Popup message to delete", test, test1);
				
				Step_Start(7, "Deleted popup Verification", test, test1);

				waitForPopup(driver, Popup_Message, deletedPopup);
				String actDeletedPopup = getText(driver, Popup_Message);
				if (actDeletedPopup.equals(deletedPopup)) {
					System.out.println(
							"Matched || " + " Expected popup : " + deletedPopup + " || Actual popup : " + actDeletedPopup);
					Extent_pass_New(driver,
							"Matched || " + " Expected popup : " + deletedPopup + " || Actual popup : " + actDeletedPopup, test,
							test1);
				} else {
					System.out.println(
							"Not matched || " + " Expected popup : " + deletedPopup + " || Actual popup : " + actDeletedPopup);

					Extent_fail(driver,"Not matched || " + " Expected popup : " + deletedPopup + " || Actual popup : " + actDeletedPopup+"<br>"+deletedPopup+" popup is not displayed",test, test1);
				}

				Step_End(7, "Deleted popup Verification", test, test1);

			// Global search
		
				scrollTop(driver);
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption1, eqpNoDelete, "", "", "", "");

				waitForPopup(driver, Popup_Message,noRecords);

				String actNoRecords = getText(driver, Popup_Message);
				System.out.println("Actual" + actNoRecords);
				if (actNoRecords.equals(noRecords)) {

					Extent_pass_New(driver,"Matched || " + " Expected  Popup :  " + noRecords + " || Actual  Popup :  " + actNoRecords+"<br>"+noRecords+" popup is displayed", test,test1);
					System.out.println("Matched || " + " Expected  Popup :  " + noRecords + " || Actual  Popup :  " + actNoRecords);
				} else {
					System.out.println("Not matched || " + " Expected  Popup :  " + noRecords + " || Actual  Popup :  " + actNoRecords);

					Extent_fail(driver, "Not matched || " + " Expected Popup :  " + noRecords + " || Actual  Popup :  " + actNoRecords+"<br>"+noRecords+" popup is not displayed",test, test1);
				}
				 waitForElement(driver, globalSearchCloseIcon_L);
				 click(driver, globalSearchCloseIcon_L);
			
			// delete
			if(!cannotDelEqp.equals("")) {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, cannotDelEqp, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

				scrollTop(driver);
				waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);

				waitForPopup(driver, popup_Message,wantToDeletepopup);
				String actualWantToDeletePopup=getText(driver, popup_Message);
				System.out.println("wantToDeletePopup:"+actualWantToDeletePopup);
				
				if (actualWantToDeletePopup.equals(wantToDeletepopup)) {				
					System.out.println("Matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup);
					Extent_pass_New(driver, "Matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup, test,test1);
					click(driver, popup_Message_Yes_Button);

				} else {
					System.out.println("Not matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup);
					Extent_fail(driver, "Not matched || " + " Expected popup : " + wantToDeletepopup + " || Actual popup : " + actualWantToDeletePopup+"<br>"+wantToDeletepopup + " popup is not diplayed and it is verified",test, test1);
				}
				

				Step_Start(8, "Cannot delete the Equipment Profile. It has movement entry", test, test1);
				waitForPopup(driver, Popup_Message,cannotDelelePopup);
				String actCannotDel = getText(driver, Popup_Message);
				if (actCannotDel.equals(cannotDelelePopup)) {
					System.out.println("Matched || " + " Expected popup : " + cannotDelelePopup + " || Actual popup : " + actCannotDel);
					Extent_pass_New(driver, "Matched || " + " Expected popup : " + cannotDelelePopup + " || Actual popup : " + actCannotDel, test,test1);
				} else {
					System.out.println("Not matched || " + " Expected popup : " + cannotDelelePopup + " || Actual popup : " + actCannotDel);
					Extent_fail(driver, "Not matched || " + " Expected popup : " + cannotDelelePopup + " || Actual popup : " + actCannotDel+"<br>"+cannotDelelePopup + " popup is not diplayed and it is verified",test, test1);
				}

				Step_End(8, "Cannot delete the Equipment Profile. It has movement entry", test, test1);
			}

			Extent_completed(testCaseName, test, test1);
		}
	}
}
