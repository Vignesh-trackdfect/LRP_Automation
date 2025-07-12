package LRP_EMS_Movement_Entry_Scripts;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Movement_Entry_TS_018 extends Keywords {

//	To Edit & update location and terminal in movement entry via multiple equipment

	public void editUpdateLocationAndTerminalViaMultipleEntry(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Movement_Entry_TS_018";
//		Get data from excel sheet

		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String updatedPopupMulti = Excel_data.get("MultiUpdatedPopup");
		String movement_Code = Excel_data.get("Movement_Code");
		String GlobalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String dropdownCondition_Date = Excel_data.get("dropdownCondition_Date");
		String dropdown_Condition = Excel_data.get("Dropdown_Condition");

		String GlobalSearchFilterOption2 = Excel_data.get("GlobalSearchFilterOption2");
		String GlobalSearchFilterOption3= Excel_data.get("GlobalSearchFilterOption3");
		String Search_Input1 = Excel_data.get("RetrieveEqpNo");
		String Search_Input2 = Excel_data.get("Movement_Code");
		String Search_Input3= Excel_data.get("Activity_Date");

		
		
		String thirtyTon = Excel_data.get("30Ton");
		String Location = Excel_data.get("Location");
		String Terminal = Excel_data.get("TermDepot");
		String Booking_NO=Excel_data.get("Booking_NO");
		String Bound = Excel_data.get("Bound");
		String CargoWeight = Excel_data.get("CargoWeight");
		String CarrierSeal = Excel_data.get("CarrierSeal");
		String Condition_Input = Excel_data.get("Condition_Input");
		String ConsigneeName = Excel_data.get("ConsigneeName");
		String CSC_Ref_NO = Excel_data.get("CSC_Ref_NO");
		String CSC_Date = Excel_data.get("CSC_Date");
		String CubicCapacity = Excel_data.get("CubicCapacity");
		String Customer = Excel_data.get("Customer");
		String CustomerDate = Excel_data.get("CustomerDate");
		String D_I = Excel_data.get("D/I");
		String D_I_From = Excel_data.get("D_I_From");
		String D_I_To = Excel_data.get("D_I_To");
		String Delivery_Input = Excel_data.get("Delivery_Input");
		String DeliveryDate = Excel_data.get("DeliveryDate");
		String DeliveryService = Excel_data.get("DeliveryService");

		String DEST = Excel_data.get("DEST");
		String Domicile = Excel_data.get("Domicile");
		String Driver = Excel_data.get("Driver");
		String EquipmentStatus = Excel_data.get("EquipmentStatus");
		String F_L_M = Excel_data.get("F_L_M");
		String FleetGroup = Excel_data.get("FleetGroup");
		String ForkPocket = Excel_data.get("ForkPocket");
		String FromService = Excel_data.get("FromService");
		String LinkedGenset = Excel_data.get("LinkedGenset");
		String Genset_PowerpackNo = Excel_data.get("Genset_PowerpackNo");
		String GrossWeight = Excel_data.get("GrossWeight");
		String Haulage = Excel_data.get("Haulage");
		String Haulier = Excel_data.get("Haulier");
		String Height = Excel_data.get("Height");
		String Helper_S = Excel_data.get("Helper_S");
		String IMO = Excel_data.get("IMO");
		String InjectionPort = Excel_data.get("InjectionPort");
		String ISO_Code = Excel_data.get("ISO_Code");
		String LeaseKind = Excel_data.get("LeaseKind");
		String Lessee = Excel_data.get("Lessee");
		String Lessor = Excel_data.get("Lessor");
		String LicenseNo = Excel_data.get("LicenseNo");
		String Maker = Excel_data.get("Maker");
		String manufactureDate = Excel_data.get("ManufactureDate");
		String Material = Excel_data.get("Material");
		String MovementType_Code = Excel_data.get("MovementType_Code");
		String O_H_Input = Excel_data.get("O_H_Input");
		String O_L_Input = Excel_data.get("O_L_Input");
		String O_W_Input = Excel_data.get("O_W_Input");
		String O_W_Amount = Excel_data.get("O_W_Amount");
		String O_W_Ind = Excel_data.get("O_W_Ind");
		String Owned = Excel_data.get("Owned");
		String PayLoad = Excel_data.get("PayLoad");

		String PlateNo = Excel_data.get("PlateNo");
		String pod_Input = Excel_data.get("Pod_Input");
		String pol_Input = Excel_data.get("Pol_Input");
		String PoolCode = Excel_data.get("PoolCode");
		String ReasonCode = Excel_data.get("ReasonCode");
		String Redel_Date = Excel_data.get("Redel_Date");
		String Redel_Place = Excel_data.get("Redel_Place");
		String refNumber= Excel_data.get("RefNumber");
		String release_Ref_No= Excel_data.get("Release_Ref_No");
		String ReturnDate= Excel_data.get("ReturnDate");
		String Return_Place= Excel_data.get("Return_Place");
		String Return_Ref_No= Excel_data.get("Return_Ref_No");
		String Return_to_Fleet= Excel_data.get("Return_to_Fleet");
		String Service= Excel_data.get("Service");
		String To_Service= Excel_data.get("To_Service");
		String Shipper= Excel_data.get("Shipper");
		String ShipperOwned= Excel_data.get("ShipperOwned");
		String ShipperSeal= Excel_data.get("ShipperSeal");
		String ShippingLine= Excel_data.get("ShippingLine");
		String Stopping_Point= Excel_data.get("Stopping_Point");
		String Stowage= Excel_data.get("Stowage");
		String SubLease_Ref= Excel_data.get("SubLease_Ref");
		String SupplierContract= Excel_data.get("SupplierContract");
		String Survey_Date= Excel_data.get("Survey_Date");
		String Surveyor= Excel_data.get("Surveyor");
		String T_S= Excel_data.get("T_S");
		String Tare= Excel_data.get("Tare");
		String TCT= Excel_data.get("TCT");
		String TDN_Number= Excel_data.get("TDN_Number");
		String Temp= Excel_data.get("Temp");
		String TIR= Excel_data.get("TIR");
		String To_Term_Depot= Excel_data.get("To_Term_Depot");
		String To_Place= Excel_data.get("To_Place");

		String Trade= Excel_data.get("Trade");
		String TransportService= Excel_data.get("TransportService");
		String Trucker= Excel_data.get("Trucker");
		String UNNO= Excel_data.get("UNNO");
		String VanLocation= Excel_data.get("VanLocation");
		String Vessel_Input= Excel_data.get("Vessel_Input");
		String VIA= Excel_data.get("VIA");
		String Voyage_Input= Excel_data.get("Voyage_Input");
		String Remarks_Input= Excel_data.get("Remarks_Input");
		String sizeType= Excel_data.get("SizeType");
		String BLNO = Excel_data.get("BLNO");
		
		
		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);
		
		// Login

		LRP_Login(driver, username, password);
		
		Step_Start(1, "Enter the module name in the search box and select the module.", test, test1);

//		Search module
			moduleNavigate(driver, moduleName);
		
		// Movement Entry
		
		Step_End(1, "Enter the module name in the search box and select the module.", test, test1);
		Step_Start(2, "Choose the Multiple Equipment Entry option.", test, test1);
		
		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);

		waitForDisplay(driver, multiEntryMovPage_L);
			
			Step_End(2, "Choose the Multiple Equipment Entry option.", test, test1);
			Step_Start(3, "Click on the Global Search icon in the toolbar", test, test1);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			Step_End(3, "Click on the Global Search icon in the toolbar", test, test1);
			Step_Start(4, "Fill in the required filter fields such as Equipment Number, Movement Code, and Activity Date.", test,test1);
			
			
			if (!Search_Input1.equals("")) {
				waitForElement(driver, type_Select1);
				selectByText(driver, type_Select1, GlobalSearchFilterOption1);
				waitForDisplay(driver, type_Select1);
				selectByText(driver, globalSearch_Condition_Dropdown1, dropdown_Condition);
				waitForDisplay(driver, globalSearch_InputTextfield1);
				sendKeys(driver, globalSearch_InputTextfield1, Search_Input1);
			}
			if (!Search_Input2.equals("")) {
				waitForElement(driver, type_Select2);
				selectByText(driver, type_Select2, GlobalSearchFilterOption2);
				waitForDisplay(driver, type_Select2);
				selectByText(driver, globalSearch_Condition_Dropdown2, dropdown_Condition);
				waitForDisplay(driver, globalSearch_InputTextfield2);
				sendKeys(driver, globalSearch_InputTextfield2, Search_Input2);
			}
			if (!Search_Input3.equals("")) {
				waitForElement(driver, type_Select3);
				selectByText(driver, type_Select3, GlobalSearchFilterOption3);
				waitForDisplay(driver, Roe_Date_Condition);
				selectByText(driver, Roe_Date_Condition, dropdownCondition_Date);
				waitForDisplay(driver, Roe_Date_Field);
				sendKeys(driver, Roe_Date_Field, Search_Input3);
			}
			
			Step_End(4, "Fill in the required filter fields such as Equipment Number, Movement Code, and Activity Date.", test,test1);
			Step_Start(5, "Click the Search button to display the relevant results.", test, test1);
			
			waitForElement(driver, globalSearch_Frame_SearchButton);
			click(driver, globalSearch_Frame_SearchButton);
			
			Step_End(5, "Click the Search button to display the relevant results.", test, test1);

			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			elementnotvisible1(driver, SelectButton);
			
			Step_Start(6, "Select the rows to edit", test, test1);

				
				waitForElement(driver, movementCode_Grid_Filter);
				click(driver, movementCode_Grid_Filter);
				waitForElement(driver, movementCode_Grid_Filter);
				sendKeys(driver, movementCode_Grid_Filter, movement_Code);
				
				waitForElement(driver, equipmentDetails_Table_Row);
				click(driver, equipmentDetails_Table_Row);
				
				Actions actions=new Actions(driver);
				actions.keyDown(Keys.SHIFT).perform();
				waitForDisplay(driver, equipmentDetails_Table_Last_Row);
				scrollElementToCenter(driver, equipmentDetails_Table_Last_Row);
				waitForElement(driver, equipmentDetails_Table_Last_Row);
				click(driver, equipmentDetails_Table_Last_Row);
				actions.keyUp(Keys.SHIFT).perform();

				Step_End(6, "Select the rows to edit", test, test1);
				Step_Start(7, "Right-click on the yellow-highlighted area and choose the Edit option.", test, test1);
				
				waitForElement(driver, eqpNoInEqpDetails_L);
				RightClick(driver, eqpNoInEqpDetails_L);
				waitForElement(driver, editOption_L);
				click(driver, editOption_L);

				Step_End(7, "Right-click on the yellow-highlighted area and choose the Edit option.", test, test1);
			
			// Edit
			waitForElement(driver, showInputFieldFrame_L);

				String locBefore1 = getAttribute(driver, location_Textfield_ME, "value");
				String termBefore1 = getAttribute(driver, term_Depot_Textfield_ME, "value");
				System.out.println("Location before edit:" + locBefore1);
				System.out.println("Terminal before edit:" + termBefore1);

				Step_Start(8, "Clear the existing data and enter the updated information as per the data sheet.", test, test1);

				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, Excel_data, test, test1);
				

// Select required Checkbox to edit
				

				waitForElement(driver, editButtonMultiMove_L);
				click(driver, editButtonMultiMove_L);
				
				waitForElement(driver, selectCheckboxFrame_L);
				if (isDisplayed(driver, selectCheckboxFrame_L)) {
					
					if(!thirtyTon.equals("")) {
						 
						scrollElementToCenter(driver, thirtyDon_CheckBox);
						waitForElement(driver, thirtyDon_CheckBox);
						click(driver, thirtyDon_CheckBox);

						}
					
					if(!Location.equals("")) {
					 
					scrollElementToCenter(driver, activePlaceCheckbox_L);
					waitForElement(driver, activePlaceCheckbox_L);
					click(driver, activePlaceCheckbox_L);

					}
					if(!Terminal.equals("")) {
						 
						scrollElementToCenter(driver, depotCheckbox_L);
						waitForElement(driver, depotCheckbox_L);
						click(driver, depotCheckbox_L);
					}
					
					if(!sizeType.equals("")) {
						 
						scrollElementToCenter(driver, sizeTypeCheckBox_L);
						waitForElement(driver, sizeTypeCheckBox_L);
						click(driver, sizeTypeCheckBox_L);
					}
					if(!ISO_Code.equals("")) {
						 
						scrollElementToCenter(driver, isoCheckBox_L);
						waitForElement(driver, isoCheckBox_L);
						click(driver, isoCheckBox_L);
					}
					if(!LeaseKind.equals("")) {
						 
						scrollElementToCenter(driver, leaseKind_CheckBox);
						waitForElement(driver, leaseKind_CheckBox);
						click(driver, leaseKind_CheckBox);
					}
					if(!Lessor.equals("")) {
						 
						scrollElementToCenter(driver, lessor_CheckBox);
						waitForElement(driver, lessor_CheckBox);
						click(driver, lessor_CheckBox);
					}
					if(!Lessee.equals("")) {
						 
						scrollElementToCenter(driver, lessee_CheckBox);
						waitForElement(driver, lessee_CheckBox);
						click(driver, lessee_CheckBox);
					}
					if(!Remarks_Input.equals("")) {
						 
						scrollElementToCenter(driver, remark_ChecBox);
						waitForElement(driver, remark_ChecBox);
						click(driver, remark_ChecBox);
					}
					if(!release_Ref_No.equals("")) {
						 
						scrollElementToCenter(driver, releaseRefCheckBox_L);
						waitForElement(driver, releaseRefCheckBox_L);
						click(driver, releaseRefCheckBox_L);
					}
					if(!PayLoad.equals("")) {
						 
						scrollElementToCenter(driver, payLoad_Checkbox_L);
						waitForElement(driver, payLoad_Checkbox_L);
						click(driver, payLoad_Checkbox_L);
					}
					if(!GrossWeight.equals("")) {
						 
						scrollElementToCenter(driver, grossWeihgt_Checkbox_L);
						waitForElement(driver, grossWeihgt_Checkbox_L);
						click(driver, grossWeihgt_Checkbox_L);
					}
					if(!SupplierContract.equals("")) {
						 
						scrollElementToCenter(driver, supplierContract_CheckBox);
						waitForElement(driver, supplierContract_CheckBox);
						click(driver, supplierContract_CheckBox);
					}
					if(!manufactureDate.equals("")) {
						 
						scrollElementToCenter(driver, manufactureDate_CheckBox);
						waitForElement(driver, manufactureDate_CheckBox);
						click(driver, manufactureDate_CheckBox);
					}
					if(!refNumber.equals("")) {
						 
						scrollElementToCenter(driver, refNumber_CheckBox);
						waitForElement(driver, refNumber_CheckBox);
						click(driver, refNumber_CheckBox);
					}
					
					
					if(!BLNO.equals("")) {
						 
						scrollElementToCenter(driver, blNo_ChecBox);
						waitForElement(driver, blNo_ChecBox);
						click(driver, blNo_ChecBox);

						}
					
					if(!Booking_NO.equals("")) {
						 
						scrollElementToCenter(driver, Booking_No_Checkbox_L);
						waitForElement(driver, Booking_No_Checkbox_L);
						click(driver, Booking_No_Checkbox_L);

						}
					
					if(!Bound.equals("")) {
						 
						scrollElementToCenter(driver, Bound_Checkbox_L);
						waitForElement(driver, Bound_Checkbox_L);
						click(driver, Bound_Checkbox_L);

						}
					
					if(!CargoWeight.equals("")) {
						 
						scrollElementToCenter(driver, CargoWeight_Checkbox_L);
						waitForElement(driver, CargoWeight_Checkbox_L);
						click(driver, CargoWeight_Checkbox_L);

						}
					
					if(!CargoWeight.equals("")) {
						 
						scrollElementToCenter(driver, Carrier_Seal_Checkbox_L);
						waitForElement(driver, Carrier_Seal_Checkbox_L);
						click(driver, Carrier_Seal_Checkbox_L);

						}
					
					if(!CarrierSeal.equals("")) {
						 
						scrollElementToCenter(driver, releaseRefCheckBox_L);
						waitForElement(driver, releaseRefCheckBox_L);
						click(driver, releaseRefCheckBox_L);
					}
					
					if(!Condition_Input.equals("")) {
						 
						scrollElementToCenter(driver, Condition_Checkbox_L);
						waitForElement(driver, Condition_Checkbox_L);
						click(driver, Condition_Checkbox_L);
					}
					
					if(!ConsigneeName.equals("")) {
						 
						scrollElementToCenter(driver, Consignee_Checkbox_L);
						waitForElement(driver, Consignee_Checkbox_L);
						click(driver, Consignee_Checkbox_L);
					}
					
					if(!CSC_Ref_NO.equals("")) {
						 
						scrollElementToCenter(driver, CSC_Checkbox_L);
						waitForElement(driver, CSC_Checkbox_L);
						click(driver, CSC_Checkbox_L);
					}
					
					if(!CSC_Date.equals("")) {
						 
						scrollElementToCenter(driver, CSC_Date_Checkbox_L);
						waitForElement(driver, CSC_Date_Checkbox_L);
						click(driver, CSC_Date_Checkbox_L);
					}
					
					if(!CubicCapacity.equals("")) {
						 
						scrollElementToCenter(driver, Cubic_Capacity_Checkbox_L);
						waitForElement(driver, Cubic_Capacity_Checkbox_L);
						click(driver, Cubic_Capacity_Checkbox_L);
					}
					if(!Customer.equals("")) {
						 
						scrollElementToCenter(driver, Customer_Checkbox_L);
						waitForElement(driver, Customer_Checkbox_L);
						click(driver, Customer_Checkbox_L);
					}
					
				
					if(!CustomerDate.equals("")) {
						 
						scrollElementToCenter(driver, Customer_Date_Checkbox_L);
						waitForElement(driver, Customer_Date_Checkbox_L);
						click(driver, Customer_Date_Checkbox_L);
					}
					
					if(!D_I.equals("")) {
						 
						scrollElementToCenter(driver, D_I_Checkbox_L);
						waitForElement(driver, D_I_Checkbox_L);
						click(driver, D_I_Checkbox_L);
					}
					
					if(!D_I_From.equals("")) {
						 
						scrollElementToCenter(driver, D_I_From_Checkbox_L);
						waitForElement(driver, D_I_From_Checkbox_L);
						click(driver, D_I_From_Checkbox_L);
					}
					if(!D_I_To.equals("")) {
						 
						scrollElementToCenter(driver, D_I_To_Checkbox_L);
						waitForElement(driver, D_I_To_Checkbox_L);
						click(driver, D_I_To_Checkbox_L);
					}
					if(!Delivery_Input.equals("")) {
						 
						scrollElementToCenter(driver, Delivery_Checkbox_L);
						waitForElement(driver, Delivery_Checkbox_L);
						click(driver, Delivery_Checkbox_L);
					}
					if(!DeliveryDate.equals("")) {
						 
						scrollElementToCenter(driver, Delivery_Date_Checkbox_L);
						waitForElement(driver, Delivery_Date_Checkbox_L);
						click(driver, Delivery_Date_Checkbox_L);
					}
					if(!DeliveryService.equals("")) {
						 
						scrollElementToCenter(driver, Delivery_Service_Checkbox_L);
						waitForElement(driver, Delivery_Service_Checkbox_L);
						click(driver, Delivery_Service_Checkbox_L);
					}
					if(!DEST.equals("")) {
						 
						scrollElementToCenter(driver, Destination_Checkbox_L);
						waitForElement(driver, Destination_Checkbox_L);
						click(driver, Destination_Checkbox_L);
					}
					if(!Domicile.equals("")) {
						 
						scrollElementToCenter(driver, Domicile_Checkbox_L);
						waitForElement(driver, Domicile_Checkbox_L);
						click(driver, Domicile_Checkbox_L);
					}
					if(!Driver.equals("")) {
						 
						scrollElementToCenter(driver, Driver_Checkbox_L);
						waitForElement(driver, Driver_Checkbox_L);
						click(driver, Driver_Checkbox_L);
					}
					if(!EquipmentStatus.equals("")) {
						 
						scrollElementToCenter(driver, Equipment_Status_Checkbox_L);
						waitForElement(driver, Equipment_Status_Checkbox_L);
						click(driver, Equipment_Status_Checkbox_L);
					}
					if(!F_L_M.equals("")) {
						 
						scrollElementToCenter(driver, F_L_M_Checkbox_L);
						waitForElement(driver, F_L_M_Checkbox_L);
						click(driver, F_L_M_Checkbox_L);
					}
					if(!FleetGroup.equals("")) {
						 
						scrollElementToCenter(driver, Fleet_Group_Checkbox_L);
						waitForElement(driver, Fleet_Group_Checkbox_L);
						click(driver, Fleet_Group_Checkbox_L);
					}
					if(!ForkPocket.equals("")) {
						 
						scrollElementToCenter(driver, Fork_Pocket_Checkbox_L);
						waitForElement(driver, Fork_Pocket_Checkbox_L);
						click(driver, Fork_Pocket_Checkbox_L);
					}
					if(!FromService.equals("")) {
						 
						scrollElementToCenter(driver, From_Service_Checkbox_L);
						waitForElement(driver, From_Service_Checkbox_L);
						click(driver, From_Service_Checkbox_L);
					}
					if(!Genset_PowerpackNo.equals("")) {
						 
						scrollElementToCenter(driver, Genset_Number_Checkbox_L);
						waitForElement(driver, Genset_Number_Checkbox_L);
						click(driver, Genset_Number_Checkbox_L);
					}
					if(!Haulage.equals("")) {
						 
						scrollElementToCenter(driver, Haulage_Checkbox_L);
						waitForElement(driver, Haulage_Checkbox_L);
						click(driver, Haulage_Checkbox_L);
					}
					if(!Haulier.equals("")) {
						 
						scrollElementToCenter(driver, Haulier_Checkbox_L);
						waitForElement(driver, Haulier_Checkbox_L);
						click(driver, Haulier_Checkbox_L);
					}
					if(!Height.equals("")) {
						 
						scrollElementToCenter(driver, Height_Checkbox_L);
						waitForElement(driver, Height_Checkbox_L);
						click(driver, Height_Checkbox_L);
					}
					if(!Helper_S.equals("")) {
						 
						scrollElementToCenter(driver, Helper_S_Checkbox_L_Checkbox_L);
						waitForElement(driver, Helper_S_Checkbox_L_Checkbox_L);
						click(driver, Helper_S_Checkbox_L_Checkbox_L);
					}
					if(!InjectionPort.equals("")) {
						 
						scrollElementToCenter(driver, Injection_Port_Checkbox_L);
						waitForElement(driver, Injection_Port_Checkbox_L);
						click(driver, Injection_Port_Checkbox_L);
					}
					if(!IMO.equals("")) {
						 
						scrollElementToCenter(driver, IMO_Checkbox_L);
						waitForElement(driver, IMO_Checkbox_L);
						click(driver, IMO_Checkbox_L);
					}
					if(!LicenseNo.equals("")) {
						 
						scrollElementToCenter(driver, License_No_Checkbox_L);
						waitForElement(driver, License_No_Checkbox_L);
						click(driver, License_No_Checkbox_L);
					}
					if(!LinkedGenset.equals("")) {
						 
						scrollElementToCenter(driver, Linked_Genset_Checkbox_L);
						waitForElement(driver, Linked_Genset_Checkbox_L);
						click(driver, Linked_Genset_Checkbox_L);
					}
					if(!Maker.equals("")) {
						 
						scrollElementToCenter(driver, Maker_Checkbox_L);
						waitForElement(driver, Maker_Checkbox_L);
						click(driver, Maker_Checkbox_L);
					}
					if(!Material.equals("")) {
						 
						scrollElementToCenter(driver, Material_Checkbox_L);
						waitForElement(driver, Material_Checkbox_L);
						click(driver, Material_Checkbox_L);
					}
					if(!MovementType_Code.equals("")) {
						 
						scrollElementToCenter(driver, MovementType_Code_Checkbox_L);
						waitForElement(driver, MovementType_Code_Checkbox_L);
						click(driver, MovementType_Code_Checkbox_L);
					}
					if(!O_H_Input.equals("")) {
						 
						scrollElementToCenter(driver, O_H_Checkbox_L);
						waitForElement(driver, O_H_Checkbox_L);
						click(driver, O_H_Checkbox_L);
					}
					if(!O_L_Input.equals("")) {
						 
						scrollElementToCenter(driver, O_L_Checkbox_L);
						waitForElement(driver, O_L_Checkbox_L);
						click(driver, O_L_Checkbox_L);
					}
					if(!O_W_Input.equals("")) {
						 
						scrollElementToCenter(driver, O_W_Checkbox_L);
						waitForElement(driver, O_W_Checkbox_L);
						click(driver, O_W_Checkbox_L);
					}
					if(!O_W_Amount.equals("")) {
						 
						scrollElementToCenter(driver, O_Weight_Amount_Checkbox_L);
						waitForElement(driver, O_Weight_Amount_Checkbox_L);
						click(driver, O_Weight_Amount_Checkbox_L);
					}if(!O_W_Ind.equals("")) {
						 
						scrollElementToCenter(driver, O_Weight_Indicator_Checkbox_L);
						waitForElement(driver, O_Weight_Indicator_Checkbox_L);
						click(driver, O_Weight_Indicator_Checkbox_L);
					}
					
					if(!Owned.equals("")) {
						 
						scrollElementToCenter(driver, Owned_Checkbox_Lv);
						waitForElement(driver, Owned_Checkbox_Lv);
						click(driver, Owned_Checkbox_Lv);
					}
					if(!PlateNo.equals("")) {
						 
						scrollElementToCenter(driver, Plate_No_Checkbox_L);
						waitForElement(driver, Plate_No_Checkbox_L);
						click(driver, Plate_No_Checkbox_L);
					}
					if(!pod_Input.equals("")) {
						 
						scrollElementToCenter(driver, POD_Checkbox_L);
						waitForElement(driver, POD_Checkbox_L);
						click(driver, POD_Checkbox_L);
					}
					if(!pol_Input.equals("")) {
						 
						scrollElementToCenter(driver, POL_Checkbox_L);
						waitForElement(driver, POL_Checkbox_L);
						click(driver, POL_Checkbox_L);
					}
					if(!PoolCode.equals("")) {
						 
						scrollElementToCenter(driver, PoolCode_Checkbox_L);
						waitForElement(driver, PoolCode_Checkbox_L);
						click(driver, PoolCode_Checkbox_L);
					}
					if(!ReasonCode.equals("")) {
						 
						scrollElementToCenter(driver, Reason_Elimination_Code_Checkbox_L);
						waitForElement(driver, Reason_Elimination_Code_Checkbox_L);
						click(driver, Reason_Elimination_Code_Checkbox_L);
					}
					if(!Redel_Date.equals("")) {
						 
						scrollElementToCenter(driver, Redelivery_Date_Checkbox_L);
						waitForElement(driver, Redelivery_Date_Checkbox_L);
						click(driver, Redelivery_Date_Checkbox_L);
					}
					if(!Redel_Place.equals("")) {
						 
						scrollElementToCenter(driver, Redelivery_Place_Checkbox_L);
						waitForElement(driver, Redelivery_Place_Checkbox_L);
						click(driver, Redelivery_Place_Checkbox_L);
					}
					if(!ReturnDate.equals("")) {
						 
						scrollElementToCenter(driver, Return_Date_Checkbox_L);
						waitForElement(driver, Return_Date_Checkbox_L);
						click(driver, Return_Date_Checkbox_L);
					}
					if(!Return_Place.equals("")) {
						 
						scrollElementToCenter(driver, Return_Place_Checkbox_L);
						waitForElement(driver, Return_Place_Checkbox_L);
						click(driver, Return_Place_Checkbox_L);
					}
					if(!Return_Ref_No.equals("")) {
						 
						scrollElementToCenter(driver, Return_Reference_Checkbox_L);
						waitForElement(driver, Return_Reference_Checkbox_L);
						click(driver, Return_Reference_Checkbox_L);
					}
					if(!Return_to_Fleet.equals("")) {
						 
						scrollElementToCenter(driver, Return_to_Fleet_Checkbox_L);
						waitForElement(driver, Return_to_Fleet_Checkbox_L);
						click(driver, Return_to_Fleet_Checkbox_L);
					}
					if(!Service.equals("")) {
						 
						scrollElementToCenter(driver, Service_Checkbox_L);
						waitForElement(driver, Service_Checkbox_L);
						click(driver, Service_Checkbox_L);
					}
					if(!To_Service.equals("")) {
						 
						scrollElementToCenter(driver, ServiceTO_Checkbox_L);
						waitForElement(driver, ServiceTO_Checkbox_L);
						click(driver, ServiceTO_Checkbox_L);
					}
					if(!Shipper.equals("")) {
						 
						scrollElementToCenter(driver, Shipper_Checkbox_L);
						waitForElement(driver, Shipper_Checkbox_L);
						click(driver, Shipper_Checkbox_L);
					}
					if(!ShipperOwned.equals("")) {
						 
						scrollElementToCenter(driver, Shipper_Owned_Checkbox_L);
						waitForElement(driver, Shipper_Owned_Checkbox_L);
						click(driver, Shipper_Owned_Checkbox_L);
					}
					if(!ShipperSeal.equals("")) {
						 
						scrollElementToCenter(driver, Shipper_Seal_Checkbox_L);
						waitForElement(driver, Shipper_Seal_Checkbox_L);
						click(driver, Shipper_Seal_Checkbox_L);
					}
					if(!ShippingLine.equals("")) {
						 
						scrollElementToCenter(driver, Shipping_Line_Checkbox_L);
						waitForElement(driver, Shipping_Line_Checkbox_L);
						click(driver, Shipping_Line_Checkbox_L);
					}
					if(!Stopping_Point.equals("")) {
						 
						scrollElementToCenter(driver, Stopping_Point_Checkbox_L);
						waitForElement(driver, Stopping_Point_Checkbox_L);
						click(driver, Stopping_Point_Checkbox_L);
					}
					if(!Stowage.equals("")) {
						 
						scrollElementToCenter(driver, Stowage_Checkbox_L);
						waitForElement(driver, Stowage_Checkbox_L);
						click(driver, Stowage_Checkbox_L);
					}
					if(!SubLease_Ref.equals("")) {
						 
						scrollElementToCenter(driver, SubLeaseRefNo_Checkbox_L);
						waitForElement(driver, SubLeaseRefNo_Checkbox_L);
						click(driver, SubLeaseRefNo_Checkbox_L);
					}
					if(!Survey_Date.equals("")) {
						 
						scrollElementToCenter(driver, Survey_date_Checkbox_L);
						waitForElement(driver, Survey_date_Checkbox_L);
						click(driver, Survey_date_Checkbox_L);
					}
					if(!Surveyor.equals("")) {
						 
						scrollElementToCenter(driver, Surveyor_Checkbox_L);
						waitForElement(driver, Surveyor_Checkbox_L);
						click(driver, Surveyor_Checkbox_L);
					}
					if(!T_S.equals("")) {
						 
						scrollElementToCenter(driver, T_S_Checkbox_L);
						waitForElement(driver, T_S_Checkbox_L);
						click(driver, T_S_Checkbox_L);
					}
					if(!Tare.equals("")) {
						 
						scrollElementToCenter(driver, Tare_Checkbox_L);
						waitForElement(driver, Tare_Checkbox_L);
						click(driver, Tare_Checkbox_L);
					}
					if(!TCT.equals("")) {
						 
						scrollElementToCenter(driver, TCT_Checkbox_L);
						waitForElement(driver, TCT_Checkbox_L);
						click(driver, TCT_Checkbox_L);
					}
					if(!TDN_Number.equals("")) {
						 
						scrollElementToCenter(driver, TDN_Number_Checkbox_L);
						waitForElement(driver, TDN_Number_Checkbox_L);
						click(driver, TDN_Number_Checkbox_L);
					}
					if(!Temp.equals("")) {
						 
						scrollElementToCenter(driver, Temp_Checkbox_L);
						waitForElement(driver, Temp_Checkbox_L);
						click(driver, Temp_Checkbox_L);
					}
					if(!TIR.equals("")) {
						 
						scrollElementToCenter(driver, TIR_Checkbox_L);
						waitForElement(driver, TIR_Checkbox_L);
						click(driver, TIR_Checkbox_L);
					}
					if(!To_Place.equals("")) {
						 
						scrollElementToCenter(driver, To_Place_Checkbox_L);
						waitForElement(driver, To_Place_Checkbox_L);
						click(driver, To_Place_Checkbox_L);
					}
					if(!To_Term_Depot.equals("")) {
						 
						scrollElementToCenter(driver, To_Depot_Checkbox_L);
						waitForElement(driver, To_Depot_Checkbox_L);
						click(driver, To_Depot_Checkbox_L);
					}
					
					if(!Trade.equals("")) {
						 
						scrollElementToCenter(driver, Trade_Checkbox_L);
						waitForElement(driver, Trade_Checkbox_L);
						click(driver, Trade_Checkbox_L);
					}
					
					if(!TransportService.equals("")) {
						 
						scrollElementToCenter(driver, Transport_Service_Checkbox_L);
						waitForElement(driver, Transport_Service_Checkbox_L);
						click(driver, Transport_Service_Checkbox_L);
					}
					
					if(!Trucker.equals("")) {
						 
						scrollElementToCenter(driver, Trucker_Checkbox_L);
						waitForElement(driver, Trucker_Checkbox_L);
						click(driver, Trucker_Checkbox_L);
					}
					
					if(!UNNO.equals("")) {
						 
						scrollElementToCenter(driver, UNNO_Checkbox_L);
						waitForElement(driver, UNNO_Checkbox_L);
						click(driver, UNNO_Checkbox_L);
					}
					
					if(!VanLocation.equals("")) {
						 
						scrollElementToCenter(driver, Van_Location_Checkbox_L);
						waitForElement(driver, Van_Location_Checkbox_L);
						click(driver, Van_Location_Checkbox_L);
					}
					
					if(!Vessel_Input.equals("")) {
						 
						scrollElementToCenter(driver, Vessel_Checkbox_L);
						waitForElement(driver, Vessel_Checkbox_L);
						click(driver, Vessel_Checkbox_L);
					}
					
					if(!VIA.equals("")) {
						 
						scrollElementToCenter(driver, VIA_Checkbox_L);
						waitForElement(driver, VIA_Checkbox_L);
						click(driver, VIA_Checkbox_L);
					}
					
					if(!Voyage_Input.equals("")) {
						 
						scrollElementToCenter(driver, Voyage_Checkbox_L);
						waitForElement(driver, Voyage_Checkbox_L);
						click(driver, Voyage_Checkbox_L);
					}
					
					waitForElement(driver, selectCheckboxOk_L);
					click(driver, selectCheckboxOk_L);
				}

				Step_End(8, "Clear the existing data and enter the updated information as per the data sheet.", test, test1);
				Step_Start(9, "Click the Edit button, then click Save.", test, test1);

				waitForElement(driver, verifyActivePlace_L);
				String actActivePlace = getText(driver, verifyActivePlace_L);
				String actDepot = getText(driver, verifyDepot_L);
				System.out.println("Actual Active Place:" + actActivePlace);
				System.out.println("Actual Dpot:" + actDepot);

				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);

				Step_End(9, "Click the Edit button, then click Save.", test, test1);
				Step_Start(10, "A confirmation message will appear indicating that the data has been successfully updated.", test, test1);

				waitForPopup(driver, popup_Message, updatedPopupMulti);
				String actText = getText(driver, popup_Message);
					if (actText.equals(updatedPopupMulti)) {
						System.out.println("Matched || "+updatedPopupMulti + " popup is displayed" + " Expected Popup is : " + updatedPopupMulti+ " || Actual Popup is : " + actText);
						Extent_pass_New(driver, "Matched || " +updatedPopupMulti + " popup is displayed"+ " Expected Popup is : " + updatedPopupMulti+ " || ActualPopup is : " + actText, test, test1);

						click(driver, popup_Message_Ok_Button);
					} else {
						System.out.println("Not matched || "+updatedPopupMulti + " popup is not displayed" + " Expected Popup is : " + updatedPopupMulti
								+ " || Actual Popup  is : " + actText);
						Extent_fail(driver, "Not matched || "+updatedPopupMulti + " popup is not displayed" + " Expected Popup is : " + updatedPopupMulti
								+ " || Actual Popup is : " + actText, test, test1);
					}

				Step_End(10, "A confirmation message will appear indicating that the data has been successfully updated.", test, test1);

		Extent_completed(testCaseName, test, test1);
	}
}
