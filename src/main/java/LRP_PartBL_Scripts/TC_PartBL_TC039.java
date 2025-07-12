package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC039 extends Keywords {
	public void PartBL_TC039(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC039";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String Part_BL_Module_Name = Excel_data.get("Part_BL_Module_Name");
		String Excepted_Part_BL_popup = Excel_data.get("Excepted_Part_BL_popup");
		String Global_BL_Search_Header = Excel_data.get("Global_BL_Search_Header");
		String Quantity_Text_Field = Excel_data.get("Quantity_Text_Field");
		String No_Of_parts_TextField = Excel_data.get("No_Of_parts_TextField");
		String Eqp_ID = Excel_data.get("Eqp_ID");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);
		PartBL_Common_Creation partBL_Data_Creation = new PartBL_Common_Creation();
		Map<String, String> BL_MCN_Numbers = partBL_Data_Creation.Common_PartBL(driver, test, test1, Excel_data);

		String BL_Number = BL_MCN_Numbers.get("BL_Number");

		Step_Start(1, "Open the Part BL module.", test, test1);
		moduleNavigate(driver, Part_BL_Module_Name);

		Step_End(1, "Open the Part BL module.", test, test1);
		
		Step_Start(2, "Click the \"\"Create\"\" button", test, test1);
		
		waitForElement(driver, NewButton_ToolBar);
		click(driver, NewButton_ToolBar);
		
		Step_End(2, "Click the \"\"Create\"\" button", test, test1);
		
		Step_Start(3, "Use the BL number search to retrieve the data", test, test1);
		
		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Global_BL_Search_Header, BL_Number, "", "", "",
				"");
		Step_End(3, "Use the BL number search to retrieve the data", test, test1);

		Step_Start(4, "Enter the number of parts", test, test1);

		waitForElement(driver, PBL_No_Of_parts_Field);
		sendKeys(driver, PBL_No_Of_parts_Field, No_Of_parts_TextField);

		Step_End(4, "Enter the number of parts", test, test1);

		Step_Start(5, "Click the Create button.", test, test1);

		waitForElement(driver, PBL_Create_Btn);
		click(driver, PBL_Create_Btn);

		Step_End(5, "Click the Create button.", test, test1);

		Step_Start(6, "Enter the quantity", test, test1);

		if (!Eqp_ID.equals("")) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, Eqp_ID);
		}

		waitForElement(driver, PBL_Quantity_Field);
		sendKeys(driver, PBL_Quantity_Field, Quantity_Text_Field);

		Step_End(6, "Enter the quantity", test, test1);

		Step_Start(7, "Add the quantity using the (+) symbol", test, test1);

		waitForElement(driver, PBL_Weight_Add_Btn);
		click(driver, PBL_Weight_Add_Btn);

		Step_End(7, "Add the quantity using the (+) symbol", test, test1);

		Step_Start(8, "Click the Apply button..", test, test1);

		waitForElement(driver, PBL_Apply_Btn);
		click(driver, PBL_Apply_Btn);

		Step_End(8, "Click the Apply button.", test, test1);

		Step_Start(9, "Select the charges Move Type Either Package Basis (OR) Move all to Master\"\" message shown.",
				test, test1);

		waitForPopup(driver, popup_Message, Excepted_Part_BL_popup);

		String Actual_Savedpopup = getText(driver, popup_Message);

		if (Excepted_Part_BL_popup.equals(Actual_Savedpopup)) {

			System.out.println("Expected popup message was : " + Excepted_Part_BL_popup + " Actual popup message was : "
					+ Actual_Savedpopup);
			Extent_pass_New(driver, "Expected popup message was : " + Excepted_Part_BL_popup
					+ " Actual popup message was : " + Actual_Savedpopup, test, test1);

		} else {

			System.out.println("Expected popup message was : " + Excepted_Part_BL_popup + " Actual popup message was : "
					+ Actual_Savedpopup);
			Extent_fail(driver, "Expected popup message was : " + Excepted_Part_BL_popup
					+ " Actual popup message was : " + Actual_Savedpopup, test, test1);

		}

		Step_End(9, "Select the charges Move Type Either Package Basis (OR) Move all to Master\"\" message shown.",
				test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
