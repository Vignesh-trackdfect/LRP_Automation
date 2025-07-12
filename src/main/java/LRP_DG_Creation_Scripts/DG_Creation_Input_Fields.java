package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


public class DG_Creation_Input_Fields extends Keywords {


	public void dg_Creation_Input_Fields(WebDriver driver,Map<String, String> Excel_data, ExtentTest test, ExtentTest test1) {
		//		Get data from excel sheet

		String testCaseName1="DG_Creation_Input_Fields";
		
		String Limited_Quantity_Input = Excel_data.get("Limited_Quantity_Input");
		String Expected_Quantity_Input = Excel_data.get("Expected_Quantity_Input");
		String Reported_Quantity_Input = Excel_data.get("Reported_Quantity_Input");
		String Waste_Input = Excel_data.get("Waste_Input");
		String unNo = Excel_data.get("UN_No");
		String emergencyContactField1 = Excel_data.get("emergencyContactField1");
		String emergencyContactField2 = Excel_data.get("emergencyContactField2");
		String emergencyContactField3 = Excel_data.get("emergencyContactField3");
		String contactNameField = Excel_data.get("ContactNameField");
		String grossWtField = Excel_data.get("GrossWtField");
		String netWtField = Excel_data.get("NetWtField");
		String Column_condition = Excel_data.get("Column_condition");
		String UN_Number_Column_Header = Excel_data.get("UN_Number_Column_Header");
		String booking_number = Excel_data.get("Booking_No_Input");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String Technical_Name = Excel_data.get("Technical_Name");
		String Marine_Pollutant = Excel_data.get("Marine_Pollutant");
		String Non_Operated_reefer_Dropdown = Excel_data.get("Non_Operated_reefer_Dropdown");
		String Unit_Input_Values = Excel_data.get("Unit_Input_Values");
		String Inner_Packing_Size_Input = Excel_data.get("Inner_Packing_Size_Input");
		String Net_Explosive_Weight = Excel_data.get("Net_Explosive_Weight");
		String Amendment = Excel_data.get("Amendment");
		String Flash_Point_C = Excel_data.get("Flash_Point_C");
		String Flash_Point_F = Excel_data.get("Flash_Point_F");
		String Segregation_Group = Excel_data.get("Segregation_Group");
		String No_Of_InnerPacking = Excel_data.get("No_Of_InnerPacking");
		String No_Of_OuterPacking = Excel_data.get("No_Of_OuterPacking");
		String Full_Packaging_Code = Excel_data.get("Full_Packaging_Code");

		String Inner_Package_Code_Input = Excel_data.get("Inner_Package_Code_Input");
		String Outer_Package_Code_Input = Excel_data.get("Outer_Package_Code_Input");
		String Outer_Package_Code_Header = Excel_data.get("Outer_Package_Code_Header");
		String Inner_Package_Code_Header = Excel_data.get("Inner_Package_Code_Header");

		Extent_Start(testCaseName1, test, test1);
		
		Step_Start(1, "Retrieve the Book number", test, test1);

		
		waitForElement(driver, Booking_No_Search_DG);
		click(driver, Booking_No_Search_DG);
		globalValueSearchWindow(driver, GlobalSearch_Condition, globalSearchFilterOption1, booking_number, "", "", "", "");
		
		Step_End(1, "Retrieve the Book number", test, test1);
		Step_Start(2, "Select the unno", test, test1);

		waitForElement(driver, UN_NO_Search_DG);
		click(driver, UN_NO_Search_DG);
	
		twoColumnSearchWindow(driver, UN_Number_Column_Header, Column_condition, unNo);
		
		Step_End(2, "Select the unno", test, test1);
		Step_Start(3, "enter the manadatory details.", test, test1);

		if(!Amendment.equals("")) {
			waitForElement(driver, amendment_Dropdown);
			safeclick(driver, amendment_Dropdown);
			formatLocatorClick(driver, DropDown_Select, Amendment);
			}
		
		if(!Non_Operated_reefer_Dropdown.equals("")) {
		waitForElement(driver, DG_Non_Operated_Reefer);
		safeclick(driver, DG_Non_Operated_Reefer);
		formatLocatorClick(driver, DropDown_Select, Non_Operated_reefer_Dropdown);
		}
		
		waitForElement(driver, Technical_Name_Textfield);
		sendKeys(driver, Technical_Name_Textfield, Technical_Name);
		
		if(!Flash_Point_C.equals("") && !Flash_Point_F.equals("")) {

		waitForElement(driver, DG_Flash_Point_C_Input);
		sendKeys(driver, DG_Flash_Point_C_Input, Flash_Point_C);
		waitForElement(driver, DG_Flash_Point_F_Input);
		sendKeys(driver, DG_Flash_Point_F_Input, Flash_Point_F);
		}
		
		if(!Segregation_Group.equals("")) {

			waitForElement(driver, DG_Flash_Point_C_Input);
			sendKeys(driver, DG_Flash_Point_C_Input, Segregation_Group);
			}
		
		waitForElement(driver, Emergency_Contact_Field1);
		safeclick(driver, Emergency_Contact_Field1);
		sendKeys(driver, Emergency_Contact_Field1, emergencyContactField1);
		
		waitForElement(driver, Emergency_Contact_Field2);
		safeclick(driver, Emergency_Contact_Field2);
		sendKeys(driver, Emergency_Contact_Field2, emergencyContactField2);
		
		waitForElement(driver, Emergency_Contact_Field3);
		safeclick(driver, Emergency_Contact_Field3);
		sendKeys(driver, Emergency_Contact_Field3, emergencyContactField3);
		
		waitForElement(driver, Limited_Quantity);
		safeclick(driver, Limited_Quantity);
		formatLocatorClick(driver, DropDown_Select, Limited_Quantity_Input);
		
		waitForElement(driver, Expected_Quantity);
		safeclick(driver, Expected_Quantity);
		formatLocatorClick(driver, DropDown_Select, Expected_Quantity_Input);

		
		waitForElement(driver,Reported_Quantity);
		safeclick(driver, Reported_Quantity);
		formatLocatorClick(driver, DropDown_Select, Reported_Quantity_Input);

		waitForElement(driver, Waste_Field);
		safeclick(driver, Waste_Field);
		formatLocatorClick(driver, DropDown_Select, Waste_Input);

		waitForElement(driver, marine_Pollutant_Dropdown);
		safeclick(driver, marine_Pollutant_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Marine_Pollutant);

		
		waitForElement(driver, Contact_Name_Field);
		sendKeys(driver, Contact_Name_Field, contactNameField);
		
		waitForElement(driver, Outer_Packing_Search_Button);
		click(driver, Outer_Packing_Search_Button);
		twoColumnSearchWindow(driver, Outer_Package_Code_Header, Column_condition, Outer_Package_Code_Input);
 
		waitForElement(driver, No_Of_Outer);
		safeclick(driver, No_Of_Outer);
		sendKeys(driver, No_Of_Outer, No_Of_OuterPacking);
		
		if(!Inner_Package_Code_Input.equals("")) {
		waitForElement(driver, Inner_Packing_Search_Button);
		click(driver, Inner_Packing_Search_Button);
		twoColumnSearchWindow(driver, Inner_Package_Code_Header, Column_condition, Inner_Package_Code_Input);
		}
		
		waitForElement(driver, No_Of_Inner_Packing_Textfield);
		safeclick(driver, No_Of_Inner_Packing_Textfield);
		sendKeys(driver, No_Of_Inner_Packing_Textfield, No_Of_InnerPacking);
		
		waitForElement(driver, DG_Inner_Packing_Size_Input);
		sendKeys(driver, DG_Inner_Packing_Size_Input, Inner_Packing_Size_Input);
		
		waitForElement(driver, DG_Net_Explosive_Weight);
		sendKeys(driver, DG_Net_Explosive_Weight, Net_Explosive_Weight);
		
		waitForElement(driver, Gross_Wt_Field);
		safeclick(driver, Gross_Wt_Field);
		clearAndType(driver, Gross_Wt_Field, grossWtField);
		safeclick(driver, Gross_Wt_Field);
		waitForElement(driver, Net_Wt_Field);
		safeclick(driver, Net_Wt_Field);
		sendKeys(driver, Net_Wt_Field, netWtField);
		
		waitForElement(driver, Gross_Wt_Field);
		safeclick(driver, Gross_Wt_Field);
		
		if(!Unit_Input_Values.equals("")) {
		waitForElement(driver, DG_Unit_Input);
		safeclick(driver, DG_Unit_Input);
		formatLocatorClick(driver, DropDown_Select, Unit_Input_Values);
		}
		
		if(!Full_Packaging_Code.equals("")) {

			waitForElement(driver, full_Packaging_Code_Textfield);
			sendKeys(driver, full_Packaging_Code_Textfield, Full_Packaging_Code);
			}
		
		scrollUsingElement(driver, Multi_Apply_Btn);
		waitForElement(driver, Multi_Apply_Btn);
		
		Step_End(3, "enter the manadatory details.", test, test1);
		
		Extent_completed(testCaseName1, test, test1);
	}

}
