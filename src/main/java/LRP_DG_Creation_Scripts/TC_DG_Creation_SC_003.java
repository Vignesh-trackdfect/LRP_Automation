package LRP_DG_Creation_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_003 extends Keywords {

	public void DG_Creation_SC_003(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		// Value are taken from excel sheet
		String testcase_Name = "TC_DG_Creation_SC_003";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Code = Excel_data.get("Agency_Code");
		
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String UN_Number_Column_Header = Excel_data.get("UN_Number_Column_Header");
		String booking_number = Excel_data.get("Booking_No_Input");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String Limited_Quantity_Input = Excel_data.get("Limited_Quantity_Input");
		String Expected_Quantity_Input = Excel_data.get("Expected_Quantity_Input");
		String Reported_Quantity_Input = Excel_data.get("Reported_Quantity_Input");
		String Waste_Input = Excel_data.get("Waste_Input");
		String emergencyContactField1 = Excel_data.get("emergencyContactField1");
		String emergencyContactField2 = Excel_data.get("emergencyContactField2");
		String emergencyContactField3 = Excel_data.get("emergencyContactField3");
		String contactNameField = Excel_data.get("ContactNameField");
		String noOfOuter = Excel_data.get("NoOfOuter");
		String grossWtField = Excel_data.get("GrossWtField");
		String netWtField = Excel_data.get("NetWtField");
		String Column_condition = Excel_data.get("Column_condition");
		String Inner_Package_Code_Input = Excel_data.get("Inner_Package_Code_Input");
		String Outer_Package_Code_Input = Excel_data.get("Outer_Package_Code_Input");
		String Outer_Package_Code_Header = Excel_data.get("Outer_Package_Code_Header");
		String Inner_Package_Code_Header = Excel_data.get("Inner_Package_Code_Header");
		String UN_No = Excel_data.get("UN_No");

		String Limited_Quantity_Popup = Excel_data.get("Limited_Quantity_Popup");
		String Excepted_Quantity_Popup = Excel_data.get("Excepted_Quantity_Popup");
		String Reportable_Quantity_Popup = Excel_data.get("Reportable_Quantity_Popup");
		String Waste_Popup = Excel_data.get("Waste_Popup");
		String Emergency_Contact_Number_Popup = Excel_data.get("Emergency_Contact_Number_Popup");
		String Outer_Pack_Code_Popup = Excel_data.get("Outer_Pack_Code_Popup");
		String Outer_Quantity_Popup = Excel_data.get("Outer_Quantity_Popup");
		String Gross_Weight_Popup = Excel_data.get("Gross_Weight_Popup");
		String ALL_Containers_Popup = Excel_data.get("ALL_Containers_Popup");


		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		SwitchProfile(driver, Agency_Code);
		moduleNavigate(driver, DG_Creation_Module);
		newButton(driver);

		waitForElement(driver, Booking_No_Search_DG);
		click(driver, Booking_No_Search_DG);
		globalValueSearchWindow(driver, GlobalSearch_Condition, globalSearchFilterOption1, booking_number, "", "", "", "");
		
		Step_End(1, "Retrieve the Book number ", test, test1);

		waitForElement(driver, UN_NO_Search_DG);
		click(driver, UN_NO_Search_DG);
	
		twoColumnSearchWindow(driver, UN_Number_Column_Header, Column_condition, UN_No);

		Step_Start(2, "click multiapply(System validate all mandatory values) ", test, test1);

		scrollElementToView(driver, Multi_Apply_Btn);
		waitForElement(driver, Multiple_Apply_button);
		safeclick(driver, Multiple_Apply_button);

		waitForPopup(driver, popup_Message, Limited_Quantity_Popup);
		String Actual_Limited_Quantity_Popup = getText(driver, popup_Message);

		if (Actual_Limited_Quantity_Popup.equals(Limited_Quantity_Popup)) {
			System.out.println("Matched || Expected popup message was : " + Limited_Quantity_Popup
					+ " || Actual popup message was : " + Actual_Limited_Quantity_Popup);
			Extent_pass(driver, "Matched || Expected popup message was : " + Limited_Quantity_Popup
					+ " || Actual popup message was : " + Actual_Limited_Quantity_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + Limited_Quantity_Popup
					+ " || Actual popup message was : " + Actual_Limited_Quantity_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Limited_Quantity_Popup
					+ " || Actual popup message was  : " + Actual_Limited_Quantity_Popup, test, test1);

		}
		click(driver, popup_Message_Ok_Button);
		scrollTop(driver);

		waitForElement(driver, Limited_Quantity);
		safeclick(driver, Limited_Quantity);
		formatLocatorClick(driver, DropDown_Select, Limited_Quantity_Input);

		scrollElementToView(driver, Multi_Apply_Btn);
		waitForElement(driver, Multiple_Apply_button);
		safeclick(driver, Multiple_Apply_button);

		waitForPopup(driver, popup_Message, Excepted_Quantity_Popup);
		String Actual_Excepted_Quantity_Popup = getText(driver, popup_Message);

		if (Actual_Excepted_Quantity_Popup.equals(Excepted_Quantity_Popup)) {
			System.out.println("Matched || Expected popup message was : " + Excepted_Quantity_Popup
					+ " || Actual popup message was : " + Actual_Excepted_Quantity_Popup);
			Extent_pass(driver, "Matched || Expected popup message was : " + Excepted_Quantity_Popup
					+ " || Actual popup message was : " + Actual_Excepted_Quantity_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + Excepted_Quantity_Popup
					+ " || Actual popup message was : " + Actual_Excepted_Quantity_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Excepted_Quantity_Popup
					+ " || Actual popup message was  : " + Actual_Excepted_Quantity_Popup, test, test1);
		}
		click(driver, popup_Message_Ok_Button);
		scrollTop(driver);

		waitForElement(driver, Expected_Quantity);
		safeclick(driver, Expected_Quantity);
		formatLocatorClick(driver, DropDown_Select, Expected_Quantity_Input);


		scrollElementToView(driver, Multi_Apply_Btn);
		waitForElement(driver, Multiple_Apply_button);
		safeclick(driver, Multiple_Apply_button);

		waitForPopup(driver, popup_Message, Reportable_Quantity_Popup);
		String Actual_Reportable_Quantity_Popup = getText(driver, popup_Message);

		if (Actual_Reportable_Quantity_Popup.equals(Reportable_Quantity_Popup)) {
			System.out.println("Matched || Expected popup message was : " + Reportable_Quantity_Popup
					+ " || Actual popup message was : " + Actual_Reportable_Quantity_Popup);
			Extent_pass(driver, "Matched || Expected popup message was : " + Reportable_Quantity_Popup
					+ " || Actual popup message was : " + Actual_Reportable_Quantity_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + Reportable_Quantity_Popup
					+ " || Actual popup message was : " + Actual_Reportable_Quantity_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Reportable_Quantity_Popup
					+ " || Actual popup message was  : " + Actual_Reportable_Quantity_Popup, test, test1);
		}
			click(driver, popup_Message_Ok_Button);
			scrollTop(driver);

			waitForElement(driver,Reported_Quantity);
			safeclick(driver, Reported_Quantity);
			formatLocatorClick(driver, DropDown_Select, Reported_Quantity_Input);

			scrollElementToView(driver, Multi_Apply_Btn);
			waitForElement(driver, Multiple_Apply_button);
			safeclick(driver, Multiple_Apply_button);

			waitForPopup(driver, popup_Message, Waste_Popup);
			String Actual_Waste_Popup = getText(driver, popup_Message);
			if (Actual_Waste_Popup.equals(Waste_Popup)) {
				System.out.println("Matched || Expected popup message was : " + Waste_Popup
						+ " || Actual popup message was : " + Actual_Waste_Popup);
				Extent_pass(driver, "Matched || Expected popup message was : " + Waste_Popup
						+ " || Actual popup message was : " + Actual_Waste_Popup, test, test1);
			} else {
				System.out.println("Not Matched || Expected popup message was : " + Waste_Popup
						+ " || Actual popup message was : " + Actual_Waste_Popup);
				Extent_fail(driver, "Not Matched || Expected popup message was : " + Waste_Popup
						+ " || Actual popup message was  : " + Actual_Waste_Popup, test, test1);
				
			}

				click(driver, popup_Message_Ok_Button);
				scrollTop(driver);

				waitForElement(driver, Waste_Field);
				safeclick(driver, Waste_Field);
				formatLocatorClick(driver, DropDown_Select, Waste_Input);

				waitForElement(driver, Contact_Name_Field);
				sendKeys(driver, Contact_Name_Field, contactNameField);
				
				scrollElementToView(driver, Multi_Apply_Btn);
				waitForElement(driver, Multiple_Apply_button);
				safeclick(driver, Multiple_Apply_button);
				
				waitForPopup(driver, popup_Message, Emergency_Contact_Number_Popup);
				String Actual_Emergency_Contact_Number_Popup = getText(driver, popup_Message);
				if (Actual_Emergency_Contact_Number_Popup.equals(Emergency_Contact_Number_Popup)) {
					System.out.println("Matched || Expected popup message was : " + Emergency_Contact_Number_Popup
							+ " || Actual popup message was : " + Actual_Emergency_Contact_Number_Popup);
					Extent_pass(driver, "Matched || Expected popup message was : " + Emergency_Contact_Number_Popup
							+ " || Actual popup message was : " + Actual_Emergency_Contact_Number_Popup, test, test1);
				} else {
					System.out.println("Not Matched || Expected popup message was : " + Emergency_Contact_Number_Popup
							+ " || Actual popup message was : " + Actual_Emergency_Contact_Number_Popup);
					Extent_fail(driver, "Not Matched || Expected popup message was : " + Emergency_Contact_Number_Popup
							+ " || Actual popup message was  : " + Actual_Emergency_Contact_Number_Popup, test, test1);
				}

				click(driver, popup_Message_Ok_Button);
				scrollTop(driver);

				waitForElement(driver, Emergency_Contact_Field1);
				safeclick(driver, Emergency_Contact_Field1);
				sendKeys(driver, Emergency_Contact_Field1, emergencyContactField1);
				
				waitForElement(driver, Emergency_Contact_Field2);
				safeclick(driver, Emergency_Contact_Field2);
				sendKeys(driver, Emergency_Contact_Field2, emergencyContactField2);
				
				waitForElement(driver, Emergency_Contact_Field3);
				safeclick(driver, Emergency_Contact_Field3);
				sendKeys(driver, Emergency_Contact_Field3, emergencyContactField3);

				scrollElementToView(driver, Multi_Apply_Btn);
				waitForElement(driver, Multiple_Apply_button);
				safeclick(driver, Multiple_Apply_button);
				
				waitForPopup(driver, popup_Message, Outer_Pack_Code_Popup);
				String Actual_Outer_Pack_Code_Popup = getText(driver, popup_Message);
				if (Actual_Outer_Pack_Code_Popup.equals(Outer_Pack_Code_Popup)) {
					System.out.println("Matched || Expected popup message was : " + Outer_Pack_Code_Popup
							+ " || Actual popup message was : " + Actual_Outer_Pack_Code_Popup);
					Extent_pass(driver, "Matched || Expected popup message was : " + Outer_Pack_Code_Popup
							+ " || Actual popup message was : " + Actual_Outer_Pack_Code_Popup, test, test1);
				} else {
					System.out.println("Not Matched || Expected popup message was : " + Outer_Pack_Code_Popup
							+ " || Actual popup message was : " + Actual_Outer_Pack_Code_Popup);
					Extent_fail(driver, "Not Matched || Expected popup message was : " + Outer_Pack_Code_Popup
							+ " || Actual popup message was  : " + Actual_Outer_Pack_Code_Popup, test, test1);
				}
					
				click(driver, popup_Message_Ok_Button);
				scrollTop(driver);

				waitForElement(driver, Outer_Packing_Search_Button);
				click(driver, Outer_Packing_Search_Button);
				twoColumnSearchWindow(driver, Outer_Package_Code_Header, Column_condition, Outer_Package_Code_Input);
			
				scrollElementToView(driver, Multi_Apply_Btn);
				waitForElement(driver, Multiple_Apply_button);
				safeclick(driver, Multiple_Apply_button);
				
				
				waitForPopup(driver, popup_Message, Outer_Quantity_Popup);
				String Actual_Outer_Quantity_Popup = getText(driver, popup_Message);
				if (Actual_Outer_Quantity_Popup.equals(Outer_Quantity_Popup)) {
					System.out.println("Matched || Expected popup message was : " + Outer_Quantity_Popup
							+ " || Actual popup message was : " + Actual_Outer_Quantity_Popup);
					Extent_pass(driver, "Matched || Expected popup message was : " + Outer_Quantity_Popup
							+ " || Actual popup message was : " + Actual_Outer_Quantity_Popup, test, test1);
				} else {
					System.out.println("Not Matched || Expected popup message was : " + Outer_Quantity_Popup
							+ " || Actual popup message was : " + Actual_Outer_Quantity_Popup);
					Extent_fail(driver, "Not Matched || Expected popup message was : " + Outer_Quantity_Popup
							+ " || Actual popup message was  : " + Actual_Outer_Quantity_Popup, test, test1);
				}
				click(driver, popup_Message_Ok_Button);
				scrollTop(driver);

				if(!Inner_Package_Code_Input.equals("")) {
					waitForElement(driver, Inner_Packing_Search_Button);
					click(driver, Inner_Packing_Search_Button);
					twoColumnSearchWindow(driver, Inner_Package_Code_Header, Column_condition, Inner_Package_Code_Input);
					}
					
					waitForElement(driver, No_Of_Outer);
					safeclick(driver, No_Of_Outer);
					sendKeys(driver, No_Of_Outer, noOfOuter);
				

				scrollElementToView(driver, Multi_Apply_Btn);
				waitForElement(driver, Multiple_Apply_button);
				safeclick(driver, Multiple_Apply_button);
				
				waitForPopup(driver, popup_Message, Gross_Weight_Popup);
				String Actual_Gross_Weight_Popup = getText(driver, popup_Message);
				if (Actual_Gross_Weight_Popup.equals(Gross_Weight_Popup)) {
					System.out.println("Matched || Expected popup message was : " + Gross_Weight_Popup
							+ " || Actual popup message was : " + Actual_Gross_Weight_Popup);
					Extent_pass(driver, "Matched || Expected popup message was : " + Gross_Weight_Popup
							+ " || Actual popup message was : " + Actual_Gross_Weight_Popup, test, test1);
				} else {
					System.out.println("Not Matched || Expected popup message was : " + Gross_Weight_Popup
							+ " || Actual popup message was : " + Actual_Gross_Weight_Popup);
					Extent_fail(driver, "Not Matched || Expected popup message was : " + Gross_Weight_Popup
							+ " || Actual popup message was  : " + Actual_Gross_Weight_Popup, test, test1);
					
				}
				click(driver, popup_Message_Ok_Button);
				scrollTop(driver);

				waitForElement(driver, Gross_Wt_Field);
				safeclick(driver, Gross_Wt_Field);
				clearAndType(driver, Gross_Wt_Field, grossWtField);
				safeclick(driver, Gross_Wt_Field);
				waitForElement(driver, Net_Wt_Field);
				safeclick(driver, Net_Wt_Field);
				sendKeys(driver, Net_Wt_Field, netWtField);

				scrollElementToView(driver, Multi_Apply_Btn);
				waitForElement(driver, Multiple_Apply_button);
				safeclick(driver, Multiple_Apply_button);
				
				waitForPopup(driver, popup_Message, ALL_Containers_Popup);
				String Actual_ALL_Containers_Popup = getText(driver, popup_Message);
				if (Actual_ALL_Containers_Popup.equals(ALL_Containers_Popup)) {
					System.out.println("Matched || Expected popup message was : " + ALL_Containers_Popup
							+ " || Actual popup message was : " + Actual_ALL_Containers_Popup);
					Extent_pass(driver, "Matched || Expected popup message was : " + ALL_Containers_Popup
							+ " || Actual popup message was : " + Actual_ALL_Containers_Popup, test, test1);
				} else {
					System.out.println("Not Matched || Expected popup message was : " + ALL_Containers_Popup
							+ " || Actual popup message was : " + Actual_ALL_Containers_Popup);
					Extent_fail(driver, "Not Matched || Expected popup message was : " + ALL_Containers_Popup
							+ " || Actual popup message was  : " + Actual_ALL_Containers_Popup, test, test1);
				}
				
				click(driver, popup_Message_Ok_Button);
				scrollTop(driver);

				

				Step_End(2, "click multiapply(System validate all mandatory values) ", test, test1);

				Extent_completed(testcase_Name, test, test1);
			}
		
}
		
	

	
