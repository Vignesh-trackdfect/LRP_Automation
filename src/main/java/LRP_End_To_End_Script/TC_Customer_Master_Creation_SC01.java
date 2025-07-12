package LRP_End_To_End_Script;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Testcases;
import commonMethods.Utils;

public class TC_Customer_Master_Creation_SC01 extends Keywords {

	public void Customer_Master_Creation_SC01(WebDriver driver, ExtentTest test, ExtentTest test1,
			String Selected_dataset, Map<String, String> Excel_data, String url) throws Exception {

		String testcaseName = "TC_Customer_Master_Creation_SC01";

		String Condition = Excel_data.get("Condition");
		String Country_Header_CM = Excel_data.get("Country_Header_CM");
		String CustomerMaster = Excel_data.get("CustomerMaster_Input");
		String CountryName = Excel_data.get("CountryName");
		String CustomerName1 = Excel_data.get("CustomerName_Input");
		String CustomerAddress1 = Excel_data.get("CustomerAddress_Input");
		String statecode = Excel_data.get("StateCode_Input");
		String cityName = Excel_data.get("City_Input");
		String emailText = Excel_data.get("EmailText_Input");
		String phoneNo = Excel_data.get("PhNo_Input");
		String taxs1 = Excel_data.get("Tax_1");
		String search_dis1 = Excel_data.get("search_dis1");
		String expected_popup1 = Excel_data.get("Expected_popup1");
		String City_Name_Header = Excel_data.get("City_Name_Header");
		String expected_popup = Excel_data.get("Expected_popup");
		String loc_select = Excel_data.get("loc_select");
		String freeSezNo = Excel_data.get("freeSezNo");
		String bondNo = Excel_data.get("bondNo");
		String zipCod = Excel_data.get("zipCod");
		String Description_Header_CM = Excel_data.get("Description_Header_CM");
		String StartDate = Excel_data.get("StartDate");
		String Customer_Status_CM = Excel_data.get("Customer_Status_CM");
		String Location_Header_CM = Excel_data.get("Location_Header_CM");

		Extent_Start(testcaseName, test, test1);
		moduleNavigate(driver, CustomerMaster);
		newButton(driver);
		waitForElement(driver, searchButton);
		click(driver, searchButton);
		twoColumnSearchWindow(driver, Country_Header_CM, Condition, CountryName);
		waitForElement(driver, userName1);
		sendKeys(driver, userName1, CustomerName1);
		waitForElement(driver, customerAddress);
		sendKeys(driver, customerAddress, CustomerAddress1);
		waitForElement(driver, searchButton1);
		click(driver, searchButton1);
		waitForElement(driver, StateCode);
		sendKeys(driver, StateCode, statecode);
		waitForElement(driver, stateId);
		doubleClick(driver, stateId);
		waitForElement(driver, CitySearch);
		click(driver, CitySearch);
		twoColumnSearchWindow(driver, City_Name_Header, Condition, cityName);
		waitForElement(driver, LocSearch);
		click(driver, LocSearch);
		twoColumnSearchWindow(driver, Location_Header_CM, Condition, loc_select);
		//		waitForElement(driver, LocName);
		//		sendKeys(driver, LocName, loc_select);

		//		waitForElement(driver, LocSel);
		//		click(driver, LocSel);

		waitForElement(driver, Customer_Status_DD);
		click(driver, Customer_Status_DD);
		formatLocatorClick(driver, DropDown_Select, Customer_Status_CM);

		waitForElement(driver, ZipCheckbox1);
		click(driver, ZipCheckbox1);

		waitForElement(driver, Zipcode);
		sendKeys(driver, Zipcode, zipCod);

		waitForElement(driver, FreeCheckbox1);
		click(driver, FreeCheckbox1);

		waitForElement(driver, SezNo);
		sendKeys(driver, SezNo, freeSezNo);

		waitForElement(driver, BondNo);
		sendKeys(driver, BondNo, bondNo);

		waitForElement(driver, BondDate);
		click(driver, BondDate);

		//		waitForElement(driver, DateEnter);
		//		click(driver, DateEnter);
		waitForElement(driver, BondDate);
		selectDatePicker(driver, StartDate);

		waitForElement(driver, EmailText);
		sendKeys(driver, EmailText, emailText);

		waitForElement(driver, PhNo);
		sendKeys(driver, PhNo, phoneNo);

		waitForElement(driver, Email1);
		sendKeys(driver, Email1, emailText);

		// String s2= "argument, shipper ,bookingParty, CONSIGNEE";
		//		List<String> expand = splitAndExpand(search_dis1);
		//		for (String rty : expand) {
		mouseOverToElement(driver, CustomerType);
		waitForElement(driver, CustomerType);
		click(driver, CustomerType);

		//			waitForElement(driver,searchDis);
		//			sendKeys(driver,searchDis,rty);
		//
		//			waitForElement(driver,CheckBox);
		//			click(driver, CheckBox);
		//
		//			waitForElement(driver,selectButton_CM);
		//			click(driver, selectButton_CM);
		//		}
		twoColumnSearchWindowMultipleValue(driver, Description_Header_CM, Condition, search_dis1);
		waitForElement(driver, tax1);
		sendKeys(driver, tax1, taxs1);

		waitForElement(driver, Billing);
		click(driver, Billing);
		scrollBottom(driver);
		waitForElement(driver, checkbox1);
		click(driver, checkbox1);

//		waitForElement(driver, SalesR);
//		click(driver, SalesR);
//
//		waitForElement(driver, searchB);
//		click(driver, searchB);
//
//		waitForElement(driver, searchD);
//		doubleClick(driver, searchD);
//
//		waitForElement(driver, Add1);
//		doubleClick(driver, Add1);
//
//		waitForDisplay(driver, salesRep);
//		if(isdisplayed(driver, salesRep)) {
//			String t1 = getText(driver, salesRep);
//
//		if (t1.equals(expected_popup1)) {
//			System.out.println("expected_popup1 :" + expected_popup1 + "|| Actual popup : " + t1);
//			Extent_pass_New(driver, "expected_popup1 :" + expected_popup1 + "|| Actual popup : " + t1, test, test1);
//		} else {
//			System.out.println("expected_popup1 :" + expected_popup1 + "|| Actual popup : " + t1);
//			Extent_pass_New(driver, "expected_popup1 :" + expected_popup1 + "|| Actual popup : " + t1, test, test1);
//		}
//
//		waitForElement(driver, click_ok);
//		click(driver, click_ok);
//	}
		scrollTop(driver);
	waitForElement(driver, SaveButton);
	click(driver, SaveButton);
	waitForDisplay(driver, already_Exist_Yes);
	if (isdisplayed(driver, already_Exist_Yes)) {
		click(driver, already_Exist_Yes);
	}
	waitForPopup(driver, popup_CM, expected_popup);
	String text = getText(driver, popup_CM);

	if (text.equals(expected_popup)) {
		System.out.println("Expected popup : " + expected_popup + " || The Actual Popup : " + text);
		Extent_pass_New(driver, "Expected popup : " + expected_popup + " || The Actual Popup : " + text, test, test1);
	} else {
		System.out.println("Expected popup : " + expected_popup + " || The Actual Popup : " + text);
		Extent_fail(driver, "Expected popup : " + expected_popup + " || The Actual Popup : " + text, test, test1);
	}

	waitForElement(driver, Ok_Button);
	click(driver, Ok_Button);

	//		waitForElement(driver,DeleTe_Button);
	//		click(driver, DeleTe_Button);
	//
	//		waitForPopup(driver,popup_CM1 , expect_popup1);
	//		String text2 = getText(driver, popup_CM1);
	//
	//		if (text2.equals(expect_popup1)) {
	//			System.out.println("Expected popup : "+expect_popup1+" || The Actual Popup : "+text2);
	//			Extent_pass_New(driver, "Expected popup : "+expect_popup1+" || The Actual Popup : "+text2, test, test1);
	//		}
	//		else {
	//			System.out.println("Expected popup : "+expect_popup1+" || The Actual Popup : "+text2);
	//			Extent_fail(driver, "Expected popup : "+expect_popup1+" || The Actual Popup : "+text2, test, test1);
	//		} 
	//
	//
	//		waitForElement(driver,Cancel_Yes);
	//		click(driver, Cancel_Yes);
	//
	//		waitForElement(driver,confirm_Ok);
	//		click(driver, confirm_Ok);
	//
	//		waitForElement(driver,ColorV);
	//		String color = getTextBackgroundColor(driver, ColorV);
	//		String ActualColorName = getColorName(color);
	//		System.out.println("Expected color : "+ActualColorName);  
	//		System.out.println("Expected color code : "+color); 
	//
	//		if (ActualColorName.equals(Expect_Color)) {
	//			System.out.println("Expected color : "+ActualColorName);
	//			Extent_pass_New(driver, "Expected color : "+ActualColorName,test ,test1);
	//		}
	//		else {
	//			System.out.println("Expected color : "+ActualColorName);
	//			Extent_fail(driver, "Expected color : "+ActualColorName,test ,test1);
	//		} 
	waitForElement(driver, Customer_Code_Field);
	String actual_Customer_Code_Value = getAttribute(driver, Customer_Code_Field, "value");
	System.out.println("actual_Customer_Code_Value : "+actual_Customer_Code_Value);
	Excel_data.put("New_Customer_Code", actual_Customer_Code_Value);
	Utils.writeOrUpdateExcelValue("TestData_End_to_End", "End_To_End_SC001", "TC_End_To_End_SC001", "Dataset1", "New_Customer_Code",actual_Customer_Code_Value);
	//	Map<String, String> dataToWrite = new HashMap<>();
//	dataToWrite.put("New_Customer_Code", actual_Customer_Code_Value);
//	Utils.writeExcelValueByReferenceMap(Testcases.File_Path, Testcases.dataSet, dataToWrite);
	Extent_completed(testcaseName, test, test1);

}
}
