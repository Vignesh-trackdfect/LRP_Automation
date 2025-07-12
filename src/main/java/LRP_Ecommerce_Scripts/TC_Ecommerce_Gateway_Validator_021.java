package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_021 extends Keywords{

	public void Ecommerce_Gateway_Validator_021(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_021";

		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Ecomm_Gateway_Module = Excel_data.get("Ecomm_Gateway_Module");

		String Transaction_Type_Value = Excel_data.get("Transaction_Type_Value");
		String From_Date_Value = Excel_data.get("From_Date_Value");
		String To_Date_Value = Excel_data.get("To_Date_Value");
		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String Master_Header_Name = Excel_data.get("Master_Header_Name");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String service_Code = Excel_data.get("service_Code");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
				
		SwitchProfile(driver, AgencyName);
		
		moduleNavigate(driver, Ecomm_Gateway_Module);
		
		Step_Start(1, " Enter the Agreement Party  ", test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver,EG_Transaction_type);
		
		String Transaction_type_Select=String.format(EG_Select_Transaction_type, Transaction_Type_Value);
		waitForElement(driver, Transaction_type_Select);
		click(driver,Transaction_type_Select);
				
		waitForElement(driver, EG_NonProcessed_Checkbox);
		checkBox(driver, EG_NonProcessed_Checkbox, NonProcessed_yes);
		
		waitForElement(driver, EG_FromDate_Input);
		selectDatePicker(driver, EG_FromDate_Input, From_Date_Value);
		
		waitForElement(driver, EG_ToDate_Input);
		selectDatePicker(driver, EG_ToDate_Input, To_Date_Value);
		
		
		if (Archive_Condition.equals("Yes")) {

			waitForElement(driver, EG_Archive_Checkbox);
			checkBox(driver, EG_Archive_Checkbox, Archive_Condition);

		}
		
		if (!Booking_Number.equals("")) {
			waitForElement(driver, EG_BookingNo_input);
			sendKeys(driver, EG_BookingNo_input, Booking_Number);
		}

		if (!Reference_Number.equals("")) {
			waitForElement(driver, EG_ReferenceNo_Input);
			sendKeys(driver, EG_ReferenceNo_Input, Reference_Number);
		}

		if (!bl_NumberInput.equals("")) {
			waitForElement(driver, EG_BLNo_input);
			sendKeys(driver, EG_BLNo_input, bl_NumberInput);
		}

		waitForDownload(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Retrieved_Record_AG_Gridcell);
		doubleClick(driver, EG_Retrieved_Record_AG_Gridcell);
		
		Step_End(1, " Enter the Agreement Party  ", test, test1);

		Step_Start(2, "  Enter the POL and POD    ", test, test1);
		Step_Start(3, " click Route button (EDIT)  ", test, test1);

		waitForElement(driver, Header_Panel_EComm_Validator);
		if(IsElementEnabled(driver, Edit_Button_toolBar)) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver,Edit_Button_toolBar);
			waitForDisplay(driver, popup_Message_Ok_Button);
			if(isdisplayed(driver, popup_Message_Ok_Button)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
			}
		}
		
		String Master_header=String.format(Header_Panel_List_Ecomm_Validator, Master_Header_Name);
		waitForElement(driver, Master_header);
		click(driver,Master_header);
		Step_End(3, " click Route button (EDIT)  ", test, test1);
		Step_End(2, "  Enter the POL and POD    ", test, test1);

		Step_Start(4, "Double click the Route details ", test, test1);
		waitForElement(driver, Routing_Add_Btn_EComm_Validator);
		click(driver,Routing_Add_Btn_EComm_Validator);
		String Select_Routing = String.format(Routing_Select_ECom_Validator, Terminal_Code, service_Code);

		scrollUsingElement(driver, Select_Routing);
		waitForElement(driver, Select_Routing);
		
		doubleClick(driver,Select_Routing);
		
		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver,popup_Message_Ok_Button);
		}
		

		waitForElement(driver, Selected_Routing_Row_EV);
		String Selected_Routing_Column=String.format(Selected_Routing_Terminal_EV, Terminal_Code);
		if(isDisplayed(driver, Selected_Routing_Column)) {
			System.out.println("Expected : Double click the row in Routing window, system Should attach Route details correctly || Actual : Double clicked row (Terminal='"+Terminal_Code+"') in Routing window, system attached the Route details correctly");
			Extent_pass_New(driver, "Expected : Double click the row in Routing window, system Should attach Route details correctly || Actual : Double clicked row (Terminal='"+Terminal_Code+"') in Routing window, system attached the Route details correctly", test, test1);
		}else {
			System.out.println("Expected : Double click the row in Routing window, system Should attach Route details correctly || Actual : Double clicked row (Terminal='"+Terminal_Code+"') in Routing window, system not attached the Route details correctly");
			Extent_fail(driver, "Expected : Double click the row in Routing window, system Should attach Route details correctly || Actual : Double clicked row (Terminal='"+Terminal_Code+"') in Routing window, system not attached the Route details correctly", test, test1);
		}
		
		Step_End(4, "Double click the Route details ", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
		
	}
}
