package LRP_End_To_End_Script;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;



public class TC_Movement_Entry_TS_016 extends Keywords {

//	To Create Moves via Multiple Entry in movement entry

	public void Movement_Entry_TS_016(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Movement_Entry_TS_016";
//		Get data from excel sheet

		
		
		
		


		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String activityEqpEntryMulti = Excel_data.get("ActivityEqpEntry");
		String activityDate = Excel_data.get("StartDate");
		String eqpNoMulti_1 = Excel_data.get("EquipmentNo");
		String multiSavedPopup = Excel_data.get("MultipleSavedPopup");
		String activityHour = Excel_data.get("ActivityHour");
		String datePicker = Excel_data.get("DatePicker");
		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String Want_To_Delete = Excel_data.get("Want_To_Delete");
		String DuplicatedContainer = Excel_data.get("Duplicated_Container");
		String thirtyTon = Excel_data.get("30Ton");
		String Location = Excel_data.get("origin");
		String Terminal = Excel_data.get("POL_Terminal_Input_Routing");
		String condition = Excel_data.get("Condition");
		String BL_Search_Filter = Excel_data.get("BL_Search_Filter");
		String Booking_NO = Excel_data.get("Booking_NO");
		String Search_By_BookNo = Excel_data.get("Search_By_BookNo");
		String Booking_Number_Search_Header = Excel_data.get("Booking_Number_Search_Header");
		String Bound = Excel_data.get("Bound");
		String CargoWeight = Excel_data.get("CargoWeight");
		String CarrierSeal = Excel_data.get("CarrierSeal");
		String Condition_Input = Excel_data.get("Condition_Input");
		String Consignee_Name_Header = Excel_data.get("Consignee_Name_Header");
		String ConsigneeName = Excel_data.get("ConsigneeName");
		String CSC_Ref_NO = Excel_data.get("CSC_Ref_NO");
		String CSC_Date = Excel_data.get("CSC_Date");
		String CubicCapacity = Excel_data.get("CubicCapacity");
		String Customer = Excel_data.get("Customer");
		String CustomerDate = Excel_data.get("CustomerDate");
		String D_I = Excel_data.get("D/I");
		String D_I_From = Excel_data.get("D_I_From");
		String D_I_To = Excel_data.get("D_I_To");
		String Delivery_Header = Excel_data.get("Delivery_Header");
		String Delivery_Input = Excel_data.get("Delivery_Input");
		String DeliveryDate = Excel_data.get("DeliveryDate");
		String DeliveryService = Excel_data.get("DeliveryService");
		String DeliveryService_Header = Excel_data.get("DeliveryService_Header");
		String DEST_Header = Excel_data.get("DEST_Header");
		String DEST = Excel_data.get("DEST");
		String Domicile = Excel_data.get("Domicile");
		String Domicile_Header = Excel_data.get("Domicile_Header");
		String Driver = Excel_data.get("Driver");
		String EquipmentStatus = Excel_data.get("EquipmentStatus");
		String F_L_M = Excel_data.get("F_L_M");
		String FleetGroup = Excel_data.get("FleetGroup");
		String ForkPocket = Excel_data.get("ForkPocket");
		String FromService_Header = Excel_data.get("FromService_Header");
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
		String TransportMode = Excel_data.get("TransportMode");
		String MovementType_Code = Excel_data.get("MovementType_Code");
		String O_H_Input = Excel_data.get("O_H_Input");
		String O_L_Input = Excel_data.get("O_L_Input");
		String O_W_Input = Excel_data.get("O_W_Input");
		String O_W_Amount = Excel_data.get("O_W_Amount");
		String O_W_Ind = Excel_data.get("O_W_Ind");
		String Owned = Excel_data.get("Owned");
		String PayLoad = Excel_data.get("PayLoad");
		String PlateNo = Excel_data.get("PlateNo");
		String POD_Header = Excel_data.get("POD_Header");
		String pod_Input = Excel_data.get("Pod_Input");
		String POL_Header = Excel_data.get("POL_Header");
		String pol_Input = Excel_data.get("Pol_Input");
		String PoolCode = Excel_data.get("PoolCode");
		String PoolCode_Header = Excel_data.get("PoolCode_Header");
		String EliminationCode_Header = Excel_data.get("EliminationCode_Header");
		String ReasonCode = Excel_data.get("ReasonCode");
		String Redel_Date = Excel_data.get("Redel_Date");
		String Redel_Place = Excel_data.get("Redel_Place");
		String Redel_Place_Header = Excel_data.get("Redel_Place_Header");
		String refNumber = Excel_data.get("RefNumber");
		String release_Ref_No = Excel_data.get("Release_Ref_No");
		String ReturnDate = Excel_data.get("ReturnDate");
		String Return_Place_Header = Excel_data.get("Return_Place_Header");
		String Return_Place = Excel_data.get("Return_Place");
		String Return_Ref_No = Excel_data.get("Return_Ref_No");
		String Return_to_Fleet_Header = Excel_data.get("Return_to_Fleet_Header");
		String Return_to_Fleet = Excel_data.get("Return_to_Fleet");
		String Service_Header = Excel_data.get("Service_Header");
		String Service = Excel_data.get("Service_Code_new");
		String To_Service_Header = Excel_data.get("To_Service_Header");
		String To_Service = Excel_data.get("To_Service");
		String Shipper_Header = Excel_data.get("Shipper_Header");
		String Shipper = Excel_data.get("Shipper");
		String ShipperOwned = Excel_data.get("ShipperOwned");
		String ShipperSeal = Excel_data.get("ShipperSeal");
		String ShippingLine_Header = Excel_data.get("ShippingLine_Header");
		String ShippingLine = Excel_data.get("ShippingLine");
		String Gross_Stacking_Weight = Excel_data.get("Gross_Stacking_Weight");
		String Stopping_Point_Header = Excel_data.get("Stopping_Point_Header");
		String Stopping_Point = Excel_data.get("Stopping_Point");
		String Stowage = Excel_data.get("Stowage");
		String SubLease_Ref = Excel_data.get("SubLease_Ref");
		String SupplierContract = Excel_data.get("SupplierContract");
		String Survey_Date = Excel_data.get("Survey_Date");
		String Surveyor = Excel_data.get("Surveyor");
		String T_S = Excel_data.get("T_S");
		String Tare = Excel_data.get("Tare");
		String TCT = Excel_data.get("TCT");
		String TDN_Number = Excel_data.get("TDN_Number");
		String TDN_Number_Header = Excel_data.get("TDN_Number_Header");
		String Temp = Excel_data.get("Temp");
		String TIR = Excel_data.get("TIR");
		String To_Term_Depot_Header = Excel_data.get("To_Term_Depot_Header");
		String To_Term_Depot = Excel_data.get("To_Term_Depot");
		String To_Place_Header = Excel_data.get("To_Place_Header");
		String To_Place = Excel_data.get("To_Place");
		String Trade__Header = Excel_data.get("Trade__Header");
		String Trade = Excel_data.get("Trade");
		String TransportService_Header = Excel_data.get("TransportService_Header");
		String TransportService = Excel_data.get("TransportService");
		String Trucker_Header = Excel_data.get("Trucker_Header");
		String Trucker = Excel_data.get("Trucker");
		String UNNO = Excel_data.get("UNNO");
		String VanLocation = Excel_data.get("VanLocation");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String VIA = Excel_data.get("VIA");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Flag_Status = Excel_data.get("Flag_Status");
		String Remarks_Input = Excel_data.get("Remarks_Input");
		String sizeType = Excel_data.get("SizeType");
		String BLNO = Excel_data.get("BLNO");
		String portSearch_Filter = Excel_data.get("PortSearch_Filter");
		String terminalSearch_Filter = Excel_data.get("TerminalSearch_Filter");
		String lesseeSearch_Filter = Excel_data.get("LesseeSearch_Filter");
		String lessorSearch_Filter = Excel_data.get("LessorSearch_Filter");
//		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

//		LRP_Login(driver, username, password);
		
		Step_Start(1, "Enter the module name in the search box and click on the desired module.", test, test1);

//		Module Search
		moduleNavigate(driver, moduleName);
		
		Step_End(1, "Enter the module name in the search box and click on the desired module.", test, test1);

		// Multiple Equipment Entry

		Step_Start(2, "Click the Multiple Equipment Entry tab to proceed.", test, test1);
		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForDisplay(driver, multiEntryMovPage_L);

			Step_End(2, "Click the Multiple Equipment Entry tab to proceed.", test, test1);
			Step_Start(3, "Enter the activity code and press Enter.", test, test1);
			
			waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, activityEqpEntryMulti);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			Step_End(3, "Enter the activity code and press Enter.", test, test1);
			Step_Start(4, "Select the required date from the date picker.", test, test1);
			
			waitForElement(driver, activeDateField_L);

			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, activeDateField_L, activityDate);

			} else {
				if (activityDate.contains("-")) {
					click(driver, activeDateField_L);

					String activityDate_1 = activityDate.replace("-", "/");

					clearAndType(driver, activeDateField_L, activityDate_1);

				} else {
					click(driver, activeDateField_L);

					clearAndType(driver, activeDateField_L, activityDate);

				}
			}

			if (!activityHour.equals("")) {
				waitForElement(driver, activityTimeMultiple);
				click(driver, activityTimeMultiple);

				waitForElement(driver, Calender);
				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);
					waitForElement(driver, activityTime_Input);

					click(driver, activityTime_Input);
					waitForElement(driver, activity_Time);
					clearAndType(driver, activity_Time, activityHour);
					waitForElement(driver, activityTime_Close);
					click(driver, activityTime_Close);

				}

			} 
			Step_End(4, "Select the required date from the date picker.", test, test1);

			Step_Start(5, "Click the Show Input button to continue.", test, test1);

			waitForElement(driver, showInputButton);
			click(driver, showInputButton);

			Step_End(5, "Click the Show Input button to continue.", test, test1);
			Step_Start(6, "Based on the provided data sheet, ensure the script fills in the fields in the correct sequence.", test, test1);
			
			//		Location
			if (!Location.equals("")) {
				scrollElementToCenter(driver, location_SearchButton_ME);
				waitForElement(driver, location_Textfield_ME);
				clear(driver, location_Textfield_ME);
				waitForElement(driver, location_SearchButton_ME);
				click(driver, location_SearchButton_ME);
				twoColumnSearchWindow(driver, portSearch_Filter, condition, Location);
			}
//			Terminal
			if (!Terminal.equals("")) {
				scrollElementToCenter(driver, depot_SearchButton_ME);
				waitForElement(driver, term_Depot_Textfield_ME);
				clear(driver, term_Depot_Textfield_ME);
				waitForElement(driver, depot_SearchButton_ME);
				click(driver, depot_SearchButton_ME);
				twoColumnSearchWindow(driver, terminalSearch_Filter, condition, Terminal);
			}

//					To Place

			if (!To_Place.equals("")) {
				scrollElementToCenter(driver, to_Place_SearchButton_ME);

				waitForElement(driver, to_Place_Textfield_ME);
				clear(driver, to_Place_Textfield_ME);

				waitForElement(driver, to_Place_SearchButton_ME);
				click(driver, to_Place_SearchButton_ME);
				twoColumnSearchWindow(driver, To_Place_Header, condition, To_Place);
			}

//					To Term./Depot

			if (!To_Term_Depot.equals("")) {
				scrollElementToCenter(driver, to_Term_Depot_SearchButton_ME);

				waitForElement(driver, to_Term_Depot_Textfield_ME);
				clear(driver, to_Term_Depot_Textfield_ME);

				waitForElement(driver, to_Term_Depot_SearchButton_ME);
				click(driver, to_Term_Depot_SearchButton_ME);
				twoColumnSearchWindow(driver, To_Term_Depot_Header, condition, To_Term_Depot);
			}

//				size/Type

			if (!sizeType.equals("")) {
				scrollElementToCenter(driver, sizeTypeDropDown_ME);

				waitForElement(driver, sizeTypeDropDown_ME);
				click(driver, sizeTypeDropDown_ME);

				formatLocatorClick(driver, DropDown_Select, sizeType);

			}

//					ISO Code

			if (!ISO_Code.equals("")) {
				scrollElementToCenter(driver, ISO_Code_Dropdown_ME);
				waitForElement(driver, ISO_Code_Dropdown_ME);
				click(driver, ISO_Code_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, ISO_Code);
			}

//					Supplier Contract

			if (!SupplierContract.equals("")) {
				scrollElementToCenter(driver, supplier_Contract_Textfield_ME);

				waitForElement(driver, supplier_Contract_Textfield_ME);
				clearAndType(driver, supplier_Contract_Textfield_ME, SupplierContract);
			}

//					SubLease Ref.

			if (!SubLease_Ref.equals("")) {
				scrollElementToCenter(driver, sublease_Ref_Textfield_ME);

				waitForElement(driver, sublease_Ref_Textfield_ME);
				clearAndType(driver, sublease_Ref_Textfield_ME, SubLease_Ref);
			}

//					Release Ref No.	

			if (!release_Ref_No.equals("")) {
				scrollElementToCenter(driver, release_Ref_No_Textfield_ME);

				waitForElement(driver, release_Ref_No_Textfield_ME);
				clearAndType(driver, release_Ref_No_Textfield_ME, release_Ref_No);
			}

//					Tare

			if (!Tare.equals("")) {
				scrollElementToCenter(driver, tare_Textfield_ME);

				waitForElement(driver, tare_Textfield_ME);
				Newclear(driver, tare_Textfield_ME);
				waitForElement(driver, tare_Textfield_ME);
				sendKeys(driver, tare_Textfield_ME, Tare);

				scrollTop(driver);
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);

			}

//					Pay Load

			if (!PayLoad.equals("")) {
				scrollElementToCenter(driver, payload_Textfield_ME);

				waitForElement(driver, payload_Textfield_ME);
				Newclear(driver, payload_Textfield_ME);
				waitForElement(driver, payload_Textfield_ME);
				sendKeys(driver, payload_Textfield_ME, PayLoad);

				scrollTop(driver);
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
			}

//					Gross Weight

			if (!GrossWeight.equals("")) {
				scrollElementToCenter(driver, grossWeight_Textfield_ME);

				waitForElement(driver, grossWeight_Textfield_ME);
				Newclear(driver, grossWeight_Textfield_ME);
				waitForElement(driver, grossWeight_Textfield_ME);
				sendKeys(driver, grossWeight_Textfield_ME, GrossWeight);

				scrollTop(driver);
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
			}

			// Booking No

			if (!Booking_NO.equals("")) {
				scrollElementToCenter(driver, bookingNo_SearchButton_ME);

				waitForElement(driver, booking_No_Textfield_ME);
				clear(driver, booking_No_Textfield_ME);

				waitForElement(driver, bookingNo_SearchButton_ME);
				click(driver, bookingNo_SearchButton_ME);

				waitForDisplay(driver, select_Button);
				if (isdisplayed(driver, globalSearch_Frame_SearchButton)) {
					globalValueSearchWindow(driver, dropdownCondition, Search_By_BookNo, Booking_NO, "", "", "", "");

				} else if (isdisplayed(driver, select_Button)) {
					twoColumnSearchWindow(driver, Booking_Number_Search_Header, condition, Booking_NO);

				}
			}

//				Service

			if (!Service.equals("")&&isdisplayed(driver, Service_SearchButton_ME)) {
				scrollElementToCenter(driver, Service_SearchButton_ME);

				waitForElement(driver, service_Textfield_ME);
				clear(driver, service_Textfield_ME);

				waitForElement(driver, Service_SearchButton_ME);
				click(driver, Service_SearchButton_ME);
				twoColumnSearchWindow(driver, Service_Header, condition, Service);
			}

//				Vessel

			if (!Vessel_Input.equals("")&&isdisplayed(driver, vessel_Textfield_ME)) {
				scrollElementToCenter(driver, vessel_Textfield_ME);
				waitForElement(driver, vessel_Textfield_ME);
				clear(driver, vessel_Textfield_ME);

				waitForElement(driver, vessel_SearchButton_ME);
				click(driver, vessel_SearchButton_ME);
				twoColumnSearchWindow(driver, Vessel_Header, condition, Vessel_Input);
			}

//				Voyage

			if (!Voyage_Input.equals("")) {
				scrollElementToCenter(driver, voyage_Textfield_ME);
				waitForElement(driver, voyage_Textfield_ME);
				clear(driver, voyage_Textfield_ME);

				waitForElement(driver, voyage_SearchButton_ME);
				click(driver, voyage_SearchButton_ME);
				twoColumnSearchWindow(driver, Voyage_Header, condition, Voyage_Input);
			}

			// Bound

			if (!Bound.equals("")) {
				waitForDisplay(driver, Bound_ME);
				scrollElementToCenter(driver, Bound_ME);
				waitForElement(driver, Bound_ME);
				clearAndType(driver, Bound_ME, Bound);
			}

//			BL No
			if (!BLNO.equals("")) {
				scrollElementToCenter(driver, BL_No_SearchBtn_ME);

				waitForElement(driver, BL_No_Textfield_ME);
				clear(driver, BL_No_Textfield_ME);

				waitForElement(driver, BL_No_SearchBtn_ME);
				click(driver, BL_No_SearchBtn_ME);
				twoColumnSearchWindow(driver, BL_Search_Filter, condition, BLNO);
			}

//				 Shipper

			if (!Shipper.equals("")) {
				scrollElementToCenter(driver, shipper_SearchButton_ME);

				waitForElement(driver, shipper_Textfield_ME);
				clear(driver, shipper_Textfield_ME);

				waitForElement(driver, shipper_SearchButton_ME);
				click(driver, shipper_SearchButton_ME);
				twoColumnSearchWindow(driver, Shipper_Header, condition, Shipper);
			}

//					Consignee

			if (!ConsigneeName.equals("")) {
				scrollElementToCenter(driver, consignee_SearchButton_ME);
				waitForElement(driver, Consignee_Textfield_ME);
				clear(driver, Consignee_Textfield_ME);

				waitForElement(driver, consignee_SearchButton_ME);
				click(driver, consignee_SearchButton_ME);
				twoColumnSearchWindow(driver, Consignee_Name_Header, condition, ConsigneeName);
			}

//					POL

			if (!pol_Input.equals("")) {
				scrollElementToCenter(driver, POL_SearchButton_ME);
				waitForElement(driver, POL_Textfield_ME);
				clear(driver, POL_Textfield_ME);

				waitForElement(driver, POL_SearchButton_ME);
				click(driver, POL_SearchButton_ME);
				twoColumnSearchWindow(driver, POL_Header, condition, pol_Input);
			}

//				POD

			if (!pod_Input.equals("")) {
				scrollElementToCenter(driver, POD_SearchButton_ME);
				waitForElement(driver, POD_Textfield_ME);
				clear(driver, POD_Textfield_ME);

				waitForElement(driver, POD_SearchButton_ME);
				click(driver, POD_SearchButton_ME);
				twoColumnSearchWindow(driver, POD_Header, condition, pod_Input);
			}

//				Lease Kind	

			if (!LeaseKind.equals("")) {
				scrollElementToCenter(driver, lease_Kind_Dropdown_ME);

				waitForElement(driver, lease_Kind_Dropdown_ME);
				click(driver, lease_Kind_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, LeaseKind);

			}

//			    	Lessor

			if (!Lessor.equals("")) {
				scrollElementToCenter(driver, lessor_SearchButton_ME);

				waitForElement(driver, lessor_Textfield_ME);
				clear(driver, lessor_Textfield_ME);

				waitForElement(driver, lessor_SearchButton_ME);
				click(driver, lessor_SearchButton_ME);
				twoColumnSearchWindow(driver, lessorSearch_Filter, condition, Lessor);

			}

//					Lessee

			if (!Lessee.equals("")) {
				scrollElementToCenter(driver, lessee_SearchButton_ME);

				waitForElement(driver, lessee_Textfield_ME);
				clear(driver, lessee_Textfield_ME);

				waitForElement(driver, lessee_SearchButton_ME);
				click(driver, lessee_SearchButton_ME);
				twoColumnSearchWindow(driver, lesseeSearch_Filter, condition, Lessee);

			}

//					30 TON

			if (!thirtyTon.equals("")) {
				scrollElementToCenter(driver, thirty_Ton_Dropdown_ME);

				waitForElement(driver, thirty_Ton_Dropdown_ME);
				click(driver, thirty_Ton_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, thirtyTon);
			}

//				Cargo Weight

			if (!CargoWeight.equals("")) {
				scrollElementToCenter(driver, Cargo_Weight_ME);
				waitForElement(driver, Cargo_Weight_ME);

				Newclear(driver, Cargo_Weight_ME);
				waitForElement(driver, Cargo_Weight_ME);
				sendKeys(driver, Cargo_Weight_ME, CargoWeight);

				scrollTop(driver);
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
			}
//		 	CarrierSeal

			if (!CarrierSeal.equals("")) {
				scrollElementToCenter(driver, carrier_Seal_ME);
				waitForElement(driver, carrier_Seal_ME);

				waitForElement(driver, carrier_Seal_ME);
				Newclear(driver, carrier_Seal_ME);
				waitForElement(driver, carrier_Seal_ME);
				sendKeys(driver, carrier_Seal_ME, CarrierSeal);

			}

//			Condition

			if (!Condition_Input.equals("")) {
				scrollElementToCenter(driver, condition_Dropdown_ME);
				waitForElement(driver, condition_Dropdown_ME);
				click(driver, condition_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, Condition_Input);
			}

//			CSC Ref No

			if (!CSC_Ref_NO.equals("")) {
				scrollElementToCenter(driver, CSC_Ref_No_Textfield_ME);
				waitForElement(driver, CSC_Ref_No_Textfield_ME);
				clearAndType(driver, CSC_Ref_No_Textfield_ME, CSC_Ref_NO);

			}

//			CSC Date	

			if (!CSC_Date.equals("")) {
				scrollElementToCenter(driver, CSC_Date_Textfield_ME);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, CSC_Date_Textfield_ME, CSC_Date);
				} else {
					if (CSC_Date.contains("-")) {
						click(driver, CSC_Date_Textfield_ME);
						String CSC_Date_1 = CSC_Date.replace("-", "/");
						clearAndType(driver, CSC_Date_Textfield_ME, CSC_Date_1);

					} else {
						click(driver, CSC_Date_Textfield_ME);
						clearAndType(driver, CSC_Date_Textfield_ME, CSC_Date);
					}
				}
			}

//			Cubic Capacity

			if (!CubicCapacity.equals("")) {
				scrollElementToCenter(driver, cubic_Capacity_Textfield_ME);
				waitForElement(driver, cubic_Capacity_Textfield_ME);

				Newclear(driver, cubic_Capacity_Textfield_ME);
				waitForElement(driver, cubic_Capacity_Textfield_ME);
				sendKeys(driver, cubic_Capacity_Textfield_ME, CubicCapacity);

				scrollTop(driver);
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
			}

			// Customer

			if (!Customer.equals("")) {
				scrollElementToCenter(driver, customer_Textfield_ME);
				waitForElement(driver, customer_Textfield_ME);
				clearAndType(driver, customer_Textfield_ME, Customer);
			}

//			  Customer Date

			if (!CustomerDate.equals("")) {
				scrollElementToCenter(driver, customer_Date_Textfield_ME);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, customer_Date_Textfield_ME, CustomerDate);
				} else {
					if (CustomerDate.contains("-")) {
						click(driver, customer_Date_Textfield_ME);
						String CustomerDate_1 = CustomerDate.replace("-", "/");
						clearAndType(driver, customer_Date_Textfield_ME, CustomerDate_1);

					} else {
						click(driver, customer_Date_Textfield_ME);
						clearAndType(driver, customer_Date_Textfield_ME, CustomerDate);
					}
				}
			}

//			  D/I

			if (!D_I.equals("")) {
				scrollElementToCenter(driver, D_I_Dropdown_ME);

				waitForElement(driver, D_I_Dropdown_ME);
				click(driver, D_I_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, D_I);
			}

//			D/I From

			if (!D_I_From.equals("")) {
				scrollElementToCenter(driver, D_I_From_Textfield_ME);

				waitForElement(driver, D_I_From_Textfield_ME);
				clearAndType(driver, D_I_From_Textfield_ME, D_I_From);

			}

//				D/I To

			if (!D_I_To.equals("")) {
				scrollElementToCenter(driver, D_I_To_Textfield_ME);

				waitForElement(driver, D_I_To_Textfield_ME);
				clearAndType(driver, D_I_To_Textfield_ME, D_I_To);

			}

//				Delivery

			if (!Delivery_Input.equals("")) {

				scrollElementToCenter(driver, delivery_SearchButton_ME);

				waitForElement(driver, delivery_Textfield_ME);
				clear(driver, delivery_Textfield_ME);

				waitForElement(driver, delivery_SearchButton_ME);
				click(driver, delivery_SearchButton_ME);

				twoColumnSearchWindow(driver, Delivery_Header, condition, Delivery_Input);
			}

//				Delivery Date

			if (!DeliveryDate.equals("")) {
				scrollElementToCenter(driver, delivery_Date_Textfield_ME);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, delivery_Date_Textfield_ME, DeliveryDate);
				} else {
					if (DeliveryDate.contains("-")) {
						click(driver, delivery_Date_Textfield_ME);
						String DeliveryDate_1 = DeliveryDate.replace("-", "/");
						clearAndType(driver, delivery_Date_Textfield_ME, DeliveryDate_1);

					} else {
						click(driver, delivery_Date_Textfield_ME);
						clearAndType(driver, delivery_Date_Textfield_ME, DeliveryDate);
					}
				}
			}

//			 Delivery Service

			if (!DeliveryService.equals("")) {

				scrollElementToCenter(driver, delivery_Service_SearchButton_ME);

				waitForElement(driver, delivery_Service_Textfield_ME);
				clear(driver, delivery_Service_Textfield_ME);

				waitForElement(driver, delivery_Service_SearchButton_ME);
				click(driver, delivery_Service_SearchButton_ME);

				twoColumnSearchWindow(driver, DeliveryService_Header, condition, DeliveryService);
			}
//			DEST

			if (!DEST.equals("")) {
				scrollElementToCenter(driver, DEST_Textfield_ME);
				waitForElement(driver, DEST_Textfield_ME);
				clear(driver, DEST_Textfield_ME);

				waitForElement(driver, DEST_SearchButton_ME);
				click(driver, DEST_SearchButton_ME);
				twoColumnSearchWindow(driver, DEST_Header, condition, DEST);
			}

//			  Domicile		

			if (!Domicile.equals("")) {
				scrollElementToCenter(driver, domicile_SearchButton_ME);

				waitForElement(driver, domicile_Textfield_ME);
				clear(driver, domicile_Textfield_ME);

				waitForElement(driver, domicile_SearchButton_ME);
				click(driver, domicile_SearchButton_ME);
				twoColumnSearchWindow(driver, Domicile_Header, condition, Domicile);
			}

//				Driver

			if (!Driver.equals("")) {
				scrollElementToCenter(driver, driver_Textfield_ME);

				waitForElement(driver, driver_Textfield_ME);
				Newclear(driver, driver_Textfield_ME);
				waitForElement(driver, driver_Textfield_ME);
				sendKeys(driver, driver_Textfield_ME, Driver);

			}

//				Equipment Status

			if (!EquipmentStatus.equals("")) {
				scrollElementToCenter(driver, equipment_Status_Dropdown_ME);
				waitForElement(driver, equipment_Status_Dropdown_ME);
				click(driver, equipment_Status_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, EquipmentStatus);
			}

//				F/L/M

			if (!F_L_M.equals("")) {
				scrollElementToCenter(driver, F_L_M_Textfield_ME);

				waitForElement(driver, F_L_M_Textfield_ME);
				clearAndType(driver, F_L_M_Textfield_ME, F_L_M);
			}

//				Fleet Group

			if (!FleetGroup.equals("")) {
				scrollElementToCenter(driver, fleet_Group_Dropdown_ME);
				waitForElement(driver, fleet_Group_Dropdown_ME);
				click(driver, fleet_Group_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, FleetGroup);
			}
//				Fork Pocket

			if (!ForkPocket.equals("")) {
				scrollElementToCenter(driver, fork_Pocket_Textfield_ME);

				waitForElement(driver, fork_Pocket_Textfield_ME);
				clearAndType(driver, fork_Pocket_Textfield_ME, ForkPocket);
			}

//			From Service

			if (!FromService.equals("")) {

				scrollElementToCenter(driver, from_Service_SearchButton_ME);

				waitForElement(driver, from_Service_Textfield_ME);
				clear(driver, from_Service_Textfield_ME);

				waitForElement(driver, from_Service_SearchButton_ME);
				click(driver, from_Service_SearchButton_ME);

				twoColumnSearchWindow(driver, FromService_Header, condition, FromService);
			}

//			 Linked Genset

			if (!LinkedGenset.equals("")) {
				scrollElementToCenter(driver, linked_Genset_Dropdown_ME);
				waitForElement(driver, linked_Genset_Dropdown_ME);
				click(driver, linked_Genset_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, LinkedGenset);
			}

//			Genset/Powerpack No

			if (!Genset_PowerpackNo.equals("")) {
				scrollElementToCenter(driver, genset_PowerPack_No_Textfield_ME);

				waitForElement(driver, genset_PowerPack_No_Textfield_ME);

				Newclear(driver, genset_PowerPack_No_Textfield_ME);
				waitForElement(driver, genset_PowerPack_No_Textfield_ME);
				sendKeys(driver, genset_PowerPack_No_Textfield_ME, Genset_PowerpackNo);

			}

//				Haulage

			if (!Haulage.equals("")) {
				scrollElementToCenter(driver, haulage_Textfield_ME);

				waitForElement(driver, haulage_Textfield_ME);
				Newclear(driver, haulage_Textfield_ME);
				waitForElement(driver, haulage_Textfield_ME);
				sendKeys(driver, haulage_Textfield_ME, Haulage);

			}

//				Haulier	

			if (!Haulier.equals("")) {
				scrollElementToCenter(driver, haulier_Textfield_ME);

				waitForElement(driver, haulier_Textfield_ME);
				Newclear(driver, haulier_Textfield_ME);
				waitForElement(driver, haulier_Textfield_ME);
				sendKeys(driver, haulier_Textfield_ME, Haulier);
			}

//			 	Height

			if (!Height.equals("")) {
				scrollElementToCenter(driver, height_Dropdown_ME);
				waitForElement(driver, height_Dropdown_ME);
				click(driver, height_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, Height);
			}

//			Helper/S

			if (!Helper_S.equals("")) {
				scrollElementToCenter(driver, helper_S_Textfield_ME);

				waitForElement(driver, helper_S_Textfield_ME);
				clearAndType(driver, helper_S_Textfield_ME, Helper_S);
			}

//		 		IMO

			if (!IMO.equals("")) {
				scrollElementToCenter(driver, IMO_Textfield_ME);

				waitForElement(driver, IMO_Textfield_ME);
				clearAndType(driver, IMO_Textfield_ME, IMO);
			}

//				Injection Port

			if (!InjectionPort.equals("")) {
				scrollElementToCenter(driver, injection_Port_Dropdown_ME);
				waitForElement(driver, injection_Port_Dropdown_ME);
				click(driver, injection_Port_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, InjectionPort);
			}

//				License No

			if (!LicenseNo.equals("")) {
				scrollElementToCenter(driver, license_No_Textfield_ME);

				waitForElement(driver, license_No_Textfield_ME);
				clearAndType(driver, license_No_Textfield_ME, LicenseNo);
			}

//				Maker

			if (!Maker.equals("")) {
				scrollElementToCenter(driver, marker_Textfield_ME);
				waitForElement(driver, marker_Textfield_ME);
				clearAndType(driver, marker_Textfield_ME, Maker);
			}

//				Manufacture Date

			if (!manufactureDate.equals("")) {
				scrollElementToCenter(driver, Manufacture_Date_ME);

				waitForElement(driver, Manufacture_Date_ME);

				if (datePicker.equalsIgnoreCase("Yes")) {

					selectDatePicker(driver, Manufacture_Date_ME, manufactureDate);

				} else {
					click(driver, Manufacture_Date_ME);
					if (manufactureDate.contains("-")) {
						String manufactureDate_1 = manufactureDate.replace("-", "/");
						clearAndType(driver, Manufacture_Date_ME, manufactureDate_1);

					} else {
						clearAndType(driver, Manufacture_Date_ME, manufactureDate);

					}
				}
			}

//				Material	

			if (!Material.equals("")) {
				scrollElementToCenter(driver, material_Textfield_ME);

				waitForElement(driver, material_Textfield_ME);
				clearAndType(driver, material_Textfield_ME, Material);
			}

//				Transport Mode

			if (!TransportMode.equals("")) {
				scrollElementToCenter(driver, transport_Mode_Dropdown_ME);

				waitForElement(driver, transport_Mode_Dropdown_ME);
				click(driver, transport_Mode_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, TransportMode);

			}

//				MovementType Code

			if (!MovementType_Code.equals("")) {
				scrollElementToCenter(driver, MovementType_Code_Textfield_ME);

				waitForElement(driver, MovementType_Code_Textfield_ME);
				clearAndType(driver, MovementType_Code_Textfield_ME, MovementType_Code);
			}

//				O/H

			if (!O_H_Input.equals("")) {
				scrollElementToCenter(driver, O_H_Textfield_ME);

				waitForElement(driver, O_H_Textfield_ME);
				Newclear(driver, O_H_Textfield_ME);
				waitForElement(driver, O_H_Textfield_ME);
				sendKeys(driver, O_H_Textfield_ME, O_H_Input);

				scrollTop(driver);
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
			}

//				O/L

			if (!O_L_Input.equals("")) {
				scrollElementToCenter(driver, O_L_Textfield_ME);
				waitForElement(driver, O_L_Textfield_ME);

				Newclear(driver, O_L_Textfield_ME);
				waitForElement(driver, O_L_Textfield_ME);
				sendKeys(driver, O_L_Textfield_ME, O_L_Input);

				scrollTop(driver);
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
			}

//				O/W

			if (!O_W_Input.equals("")) {
				scrollElementToCenter(driver, O_W_Textfield_ME);

				waitForElement(driver, O_W_Textfield_ME);

				Newclear(driver, O_W_Textfield_ME);
				waitForElement(driver, O_W_Textfield_ME);
				sendKeys(driver, O_W_Textfield_ME, O_W_Input);

				scrollTop(driver);
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
			}

//				O_W_Amount

			if (!O_W_Amount.equals("")) {
				scrollElementToCenter(driver, O_W_Amount_Textfield_ME);

				waitForElement(driver, O_W_Amount_Textfield_ME);

				Newclear(driver, O_W_Amount_Textfield_ME);
				waitForElement(driver, O_W_Amount_Textfield_ME);
				sendKeys(driver, O_W_Amount_Textfield_ME, O_W_Amount);

				scrollTop(driver);
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
			}

//				O/W Ind.

			if (!O_W_Ind.equals("")) {
				scrollElementToCenter(driver, O_W_Ind_Dropdown_ME);

				waitForElement(driver, O_W_Ind_Dropdown_ME);
				click(driver, O_W_Ind_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, O_W_Ind);

			}

//				Owned

			if (!Owned.equals("")) {
				scrollElementToCenter(driver, owned_Dropdown_ME);

				waitForElement(driver, owned_Dropdown_ME);
				click(driver, owned_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, Owned);

			}

//			Plate No	

			if (!PlateNo.equals("")) {
				scrollElementToCenter(driver, plate_No_Textfield_ME);

				waitForElement(driver, plate_No_Textfield_ME);
				Newclear(driver, plate_No_Textfield_ME);
				waitForElement(driver, plate_No_Textfield_ME);
				sendKeys(driver, plate_No_Textfield_ME, PlateNo);

				clearAndType(driver, plate_No_Textfield_ME, PlateNo);
			}

//			Pool Code

			if (!PoolCode.equals("")) {
				scrollElementToCenter(driver, pool_Code_SearchButton_ME);

				waitForElement(driver, poolCode_Textfield_ME);
				clear(driver, poolCode_Textfield_ME);

				waitForElement(driver, pool_Code_SearchButton_ME);
				click(driver, pool_Code_SearchButton_ME);
				twoColumnSearchWindow(driver, PoolCode_Header, condition, PoolCode);
			}

//				Reason Code

			if (!ReasonCode.equals("")) {
				scrollElementToCenter(driver, reason_Code_SearchButton_ME);

				waitForElement(driver, reasonCode_Textfield_ME);
				clear(driver, reasonCode_Textfield_ME);

				waitForElement(driver, reason_Code_SearchButton_ME);
				click(driver, reason_Code_SearchButton_ME);
				twoColumnSearchWindow(driver, EliminationCode_Header, condition, ReasonCode);
			}

//				Redel. Date

			if (!Redel_Date.equals("")) {
				scrollElementToCenter(driver, redel_Date_Textfield_ME);

				waitForElement(driver, redel_Date_Textfield_ME);

				if (datePicker.equalsIgnoreCase("Yes")) {

					selectDatePicker(driver, redel_Date_Textfield_ME, Redel_Date);

				} else {
					click(driver, redel_Date_Textfield_ME);
					if (Redel_Date.contains("-")) {
						String Redel_Date_1 = Redel_Date.replace("-", "/");
						clearAndType(driver, redel_Date_Textfield_ME, Redel_Date_1);

					} else {
						clearAndType(driver, redel_Date_Textfield_ME, Redel_Date);

					}
				}
			}

//				Redel Place

			if (!Redel_Place.equals("")) {
				scrollElementToCenter(driver, redel_Place_SearchButton_ME);

				waitForElement(driver, redelPlace_Textfield_ME);
				clear(driver, redelPlace_Textfield_ME);

				waitForElement(driver, redel_Place_SearchButton_ME);
				click(driver, redel_Place_SearchButton_ME);
				twoColumnSearchWindow(driver, Redel_Place_Header, condition, Redel_Place);
			}

//			Ref Number

			if (!refNumber.equals("")) {
				scrollElementToCenter(driver, ref_Number_Textfield_ME);

				waitForElement(driver, ref_Number_Textfield_ME);
				clearAndType(driver, ref_Number_Textfield_ME, refNumber);
			}

//			Return Date

			if (!ReturnDate.equals("")) {
				scrollElementToCenter(driver, return_Date_Textfield_ME);

				waitForElement(driver, return_Date_Textfield_ME);

				if (datePicker.equalsIgnoreCase("Yes")) {

					selectDatePicker(driver, return_Date_Textfield_ME, ReturnDate);

				} else {
					click(driver, return_Date_Textfield_ME);
					if (ReturnDate.contains("-")) {
						String ReturnDate_1 = ReturnDate.replace("-", "/");
						clearAndType(driver, return_Date_Textfield_ME, ReturnDate_1);

					} else {
						clearAndType(driver, return_Date_Textfield_ME, ReturnDate);

					}
				}
			}

//				Return Place

			if (!Return_Place.equals("")) {
				scrollElementToCenter(driver, return_Place_SearchButton_ME);

				waitForElement(driver, returnPlace_Textfield_ME);
				clear(driver, returnPlace_Textfield_ME);

				waitForElement(driver, return_Place_SearchButton_ME);
				click(driver, return_Place_SearchButton_ME);
				twoColumnSearchWindow(driver, Return_Place_Header, condition, Return_Place);
			}

//			Return Ref No	

			if (!Return_Ref_No.equals("")) {
				scrollElementToCenter(driver, return_Ref_No_Textfield_ME);

				waitForElement(driver, return_Ref_No_Textfield_ME);
				clearAndType(driver, return_Ref_No_Textfield_ME, Return_Ref_No);
			}

//			Return to Fleet

			if (!Return_to_Fleet.equals("")) {
				scrollElementToCenter(driver, return_To_Fleet_SearchButton_ME);

				waitForElement(driver, returnToFleet_Textfield_ME);
				clear(driver, returnToFleet_Textfield_ME);

				waitForElement(driver, return_To_Fleet_SearchButton_ME);
				click(driver, return_To_Fleet_SearchButton_ME);
				twoColumnSearchWindow(driver, Return_to_Fleet_Header, condition, Return_to_Fleet);
			}

//				To Service

			if (!To_Service.equals("")) {
				scrollElementToCenter(driver, to_Service_SearchButton_ME);

				waitForElement(driver, to_Service_Textfield_ME);
				clear(driver, to_Service_Textfield_ME);

				waitForElement(driver, to_Service_SearchButton_ME);
				click(driver, to_Service_SearchButton_ME);
				twoColumnSearchWindow(driver, To_Service_Header, condition, To_Service);
			}

//				Shipper Owned

			if (!ShipperOwned.equals("")) {
				scrollElementToCenter(driver, shipper_Owned_Dropdown_ME);

				waitForElement(driver, shipper_Owned_Dropdown_ME);
				click(driver, shipper_Owned_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, ShipperOwned);

			}

//				Shipper Seal

			if (!ShipperSeal.equals("")) {
				scrollElementToCenter(driver, shipper_Seal_Textfield_ME);

				waitForElement(driver, shipper_Seal_Textfield_ME);
				clearAndType(driver, shipper_Seal_Textfield_ME, ShipperSeal);
			}

//			Shipping Line

			if (!ShippingLine.equals("")) {
				scrollElementToCenter(driver, shipping_Line_SearchButton_ME);

				waitForElement(driver, shippingLine_Textfield_ME);
				clear(driver, shippingLine_Textfield_ME);

				waitForElement(driver, shipping_Line_SearchButton_ME);
				click(driver, shipping_Line_SearchButton_ME);
				twoColumnSearchWindow(driver, ShippingLine_Header, condition, ShippingLine);
			}

//				Gross Stacking Weight

			if (!Gross_Stacking_Weight.equals("")) {
				scrollElementToCenter(driver, gross_Stacking_Weight_Textfield_ME);

				waitForElement(driver, gross_Stacking_Weight_Textfield_ME);

				Newclear(driver, gross_Stacking_Weight_Textfield_ME);
				waitForElement(driver, gross_Stacking_Weight_Textfield_ME);
				sendKeys(driver, gross_Stacking_Weight_Textfield_ME, Gross_Stacking_Weight);

				scrollTop(driver);
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
			}

//				Stopping Point

			if (!Stopping_Point.equals("")) {
				scrollElementToCenter(driver, stop_Point_SearchButton_ME);

				waitForElement(driver, stopping_Point_Textfield_ME);
				clear(driver, stopping_Point_Textfield_ME);

				waitForElement(driver, stop_Point_SearchButton_ME);
				click(driver, stop_Point_SearchButton_ME);
				twoColumnSearchWindow(driver, Stopping_Point_Header, condition, Stopping_Point);
			}

//				Stowage

			if (!Stowage.equals("")) {
				scrollElementToCenter(driver, stowage_Textfield_ME);

				waitForElement(driver, stowage_Textfield_ME);

				Newclear(driver, stowage_Textfield_ME);
				waitForElement(driver, stowage_Textfield_ME);
				sendKeys(driver, stowage_Textfield_ME, Stowage);

				scrollTop(driver);
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
			}

//			Survey Date

			if (!Survey_Date.equals("")) {
				scrollElementToCenter(driver, survey_Date_Textfield_ME);

				waitForElement(driver, survey_Date_Textfield_ME);

				if (datePicker.equalsIgnoreCase("Yes")) {

					selectDatePicker(driver, survey_Date_Textfield_ME, Survey_Date);

				} else {
					click(driver, survey_Date_Textfield_ME);
					if (Survey_Date.contains("-")) {
						String Survey_Date_1 = Survey_Date.replace("-", "/");
						clearAndType(driver, survey_Date_Textfield_ME, Survey_Date_1);

					} else {
						clearAndType(driver, survey_Date_Textfield_ME, Survey_Date);

					}
				}
			}

//				Surveyor	

			if (!Surveyor.equals("")) {
				scrollElementToCenter(driver, surveyor_Textfield_ME);

				waitForElement(driver, surveyor_Textfield_ME);
				clearAndType(driver, surveyor_Textfield_ME, Surveyor);
			}

//				T/S

			if (!T_S.equals("")) {
				scrollElementToCenter(driver, T_S_Dropdown_ME);

				waitForElement(driver, T_S_Dropdown_ME);
				click(driver, T_S_Dropdown_ME);

				formatLocatorClick(driver, DropDown_Select, T_S);

			}

//			TCT

			if (!TCT.equals("")) {
				scrollElementToCenter(driver, TCT_Textfield_ME);

				waitForElement(driver, TCT_Textfield_ME);
				clearAndType(driver, TCT_Textfield_ME, TCT);
			}

//				TDN_Number

			if (!TDN_Number.equals("")) {
				scrollElementToCenter(driver, TDN_SearchButton_ME);

				waitForElement(driver, TDN_Number_Textfield_ME);
				clear(driver, TDN_Number_Textfield_ME);

				waitForElement(driver, TDN_SearchButton_ME);
				click(driver, TDN_SearchButton_ME);
				twoColumnSearchWindow(driver, TDN_Number_Header, condition, TDN_Number);
			}

//				Temp

			if (!Temp.equals("")) {
				scrollElementToCenter(driver, temp_Textfield_ME);

				waitForElement(driver, temp_Textfield_ME);
				clearAndType(driver, temp_Textfield_ME, Temp);
			}

//			TIR

			if (!TIR.equals("")) {
				scrollElementToCenter(driver, TIR_Textfield_ME);

				waitForElement(driver, TIR_Textfield_ME);
				clearAndType(driver, TIR_Textfield_ME, TIR);
			}

//				Trade

			if (!Trade.equals("")) {
				scrollElementToCenter(driver, trade_SearchButton_ME);

				waitForElement(driver, trade_Textfield_ME);
				clear(driver, trade_Textfield_ME);

				waitForElement(driver, trade_SearchButton_ME);
				click(driver, trade_SearchButton_ME);
				twoColumnSearchWindow(driver, Trade__Header, condition, Trade);
			}

//				Transport Service

			if (!TransportService.equals("")) {
				scrollElementToCenter(driver, transport_Service_SearchButton_ME);
				waitForElement(driver, transport_Service_Textfield_ME);
				clear(driver, transport_Service_Textfield_ME);

				waitForElement(driver, transport_Service_SearchButton_ME);
				click(driver, transport_Service_SearchButton_ME);
				twoColumnSearchWindow(driver, TransportService_Header, condition, TransportService);
			}

//				Trucker

			if (!Trucker.equals("")) {
				scrollElementToCenter(driver, trucker_SearchButton_ME);

				waitForElement(driver, trucker_Textfield_ME);
				clear(driver, trucker_Textfield_ME);

				waitForElement(driver, trucker_SearchButton_ME);
				click(driver, trucker_SearchButton_ME);
				twoColumnSearchWindow(driver, Trucker_Header, condition, Trucker);
			}

//			UNNO

			if (!UNNO.equals("")) {
				scrollElementToCenter(driver, UNNO_Textfield_ME);

				waitForElement(driver, UNNO_Textfield_ME);
				clearAndType(driver, UNNO_Textfield_ME, UNNO);
			}

//			Van Location

			if (!VanLocation.equals("")) {
				scrollElementToCenter(driver, van_Location_Textfield_ME);

				waitForElement(driver, van_Location_Textfield_ME);
				clearAndType(driver, van_Location_Textfield_ME, VanLocation);
			}

//				VIA

			if (!VIA.equals("")) {
				scrollElementToCenter(driver, VIA_Textfield_ME);

				waitForElement(driver, VIA_Textfield_ME);
				clearAndType(driver, VIA_Textfield_ME, VIA);
			}

//				Flag Status

			if (!Flag_Status.equals("")) {
				scrollElementToCenter(driver, flag_Status_Textfield_ME);

				waitForElement(driver, flag_Status_Textfield_ME);
				clearAndType(driver, flag_Status_Textfield_ME, Flag_Status);
			}

//				Remarks

			if (!Remarks_Input.equals("")) {
				scrollElementToCenter(driver, remarks_Textfield_ME);

				waitForElement(driver, remarks_Textfield_ME);
				clearAndType(driver, remarks_Textfield_ME, Remarks_Input);
			}
			
			Step_End(6, "Based on the provided data sheet, ensure the script fills in the fields in the correct sequence.", test, test1);
			
			Step_Start(7, "Once all required fields are entered, click the Add button.", test, test1);
			
			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);

			Step_End(7, "Once all required fields are entered, click the Add button.", test, test1);
			Step_Start(8, "Enter a valid container number in the Equipment No. field within the grid.", test, test1);
			
			String equipmentNumber_Add=String.format(equipmentNumber_Grid_Textfield, 0);
			String equipmentNumber_Input_Add=String.format(equipmentNumber_Grid_Input_Textfield, 0);

			waitForElement(driver, equipmentNumber_Add);
			scrollUsingElement(driver, equipmentNumber_Add);
			waitForElement(driver, equipmentNumber_Add);
			click(driver, equipmentNumber_Add);
			String values = formatEveryValues(eqpNoMulti_1);
			System.out.println(values);

			StringSelection stringSelection = new StringSelection(values);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	        
	        Actions action = new Actions(driver);
	        
	        waitForElement(driver, equipmentNumber_Input_Add);
			mouseOverToElement(driver, equipmentNumber_Input_Add);
			click(driver, equipmentNumber_Input_Add);
			action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
			enter(driver);
			
			Step_End(8, "Enter a valid container number in the Equipment No. field within the grid.", test, test1);

			List<WebElement> totalRows=new ArrayList<WebElement>();
			ArrayList<String> generated_Eqp_No=new ArrayList<String>();
			
			Step_Start(9, "Click the Save button. The system should then display a confirmation message indicating that the data has been saved successfully.", test, test1);

			scrollTop(driver);
			scrollTop(driver);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			String duplicated_Container=String.format(Duplicated_Container, DuplicatedContainer);
			waitForDisplay(driver, errorRecordsFrame_L);
			if (isdisplayed(driver, errorRecordsFrame_L)) {
				
				if(isdisplayed(driver, duplicated_Container)) {
					click(driver, errorRecApply_L);
					
					scrollTop(driver);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);
				}
				
				waitForDisplay(driver, Apply_Check_Digit_Button);
				if (isdisplayed(driver, Apply_Check_Digit_Button)) {
					click(driver, Apply_Check_Digit_Button);

					waitForElement(driver, equipmentDetails_Table_Row);
					totalRows = listOfElements(driver, equipmentDetails_Table_Row);
					
					for(int i=1;i<=totalRows.size();i++) {
						String equipmentNumber_Gridcell=String.format(equipmentDetails_Table_Row_Eqp_No, i);
					
					waitForDisplay(driver, equipmentNumber_Gridcell);
					scrollElementToCenter(driver, equipmentNumber_Gridcell);
					waitForDisplay(driver, equipmentNumber_Gridcell);
					String actualEqpNumber = getText(driver, equipmentNumber_Gridcell);
					Extent_pass_New(driver, "Actual Equipment Number "+(i)+" : "+actualEqpNumber, test, test1);
					generated_Eqp_No.add(actualEqpNumber);
					}
					
				}
				
			
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			}else {
				
				waitForElement(driver, equipmentDetails_Table_Row);
				totalRows = listOfElements(driver, equipmentDetails_Table_Row);
				
				for(int i=1;i<=totalRows.size();i++) {
					String equipmentNumber_Gridcell=String.format(equipmentDetails_Table_Row_Eqp_No, i);
				
				waitForDisplay(driver, equipmentNumber_Gridcell);
				scrollElementToCenter(driver, equipmentNumber_Gridcell);
				waitForDisplay(driver, equipmentNumber_Gridcell);
				String actualEqpNumber = getText(driver, equipmentNumber_Gridcell);
				Extent_pass_New(driver, "Actual Equipment Number "+(i)+" : "+actualEqpNumber, test, test1);
				generated_Eqp_No.add(actualEqpNumber);
				}
			}
//			waitForElement(driver, forcebtn);
//			click(driver, forcebtn);
			waitForPopup(driver, popup_Message, multiSavedPopup);
				String actText = getText(driver, popup_Message);
				if (actText.equals(multiSavedPopup)) {
					System.out.println("Matched || " + " Expected Popup is : " + multiSavedPopup
							+ " || Actual Popup is : " + actText);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + multiSavedPopup
							+ " || Actual Popup is : " + actText+"<br>"+multiSavedPopup + " popup is displayed", test, test1);
					click(driver, popup_Message_Ok_Button);
				} else {
					System.out.println("Not matched || " + " Expected Popup is : " + multiSavedPopup
							+ " || Actual Popup  is : " + actText);
					Extent_fail(driver, "Not matched || " + " Expected Popup is : " + multiSavedPopup
							+ " || Actual Popup is : " + actText+" <br> "+multiSavedPopup + " popup is not displayed", test, test1);
				}
				System.out.println("ActualEqNo:" + generated_Eqp_No);
				Excel_data.put("New_Equipment_ID", String.join(",", generated_Eqp_No));
				System.out.println("New_Equipment_ID"+ String.join(",", generated_Eqp_No));
				
				Utils.writeOrUpdateExcelValue("TestData_End_to_End", "End_To_End_SC001", "TC_End_To_End_SC001", "Dataset1", "New_Equipment_ID", String.join(",", generated_Eqp_No));
			Step_End(9, "Click the Save button. The system should then display a confirmation message indicating that the data has been saved successfully.", test, test1);

		Extent_completed(testCaseName, test, test1);
	}
	
}
