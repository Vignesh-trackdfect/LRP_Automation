package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC70 extends Keywords {

	public void Feeder_Contract_SC70(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC70";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Vendor_Header = Excel_data.get("Vendor_Header");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Verify_popup = Excel_data.get("Verify_popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master",
				test, test1);

		waitForElement(driver, FC_Vendor_Search_Button);
		click(driver, FC_Vendor_Search_Button);

		twoColumnSearchWindow(driver, Vendor_Header, Two_Column_Condition, Vendor_Code);

		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master",
				test, test1);

		Step_Start(3, "Click on the '+' Button to add the all details ", test, test1);

		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);

		Step_End(3, "Click on the '+' Button to add the all details ", test, test1);

		Step_Start(3, "Click cancel.", test, test1);

		waitForElement(driver, FC_Add_Cancel);
		click(driver, FC_Add_Cancel);

		Step_End(3, "Click cancel.", test, test1);

		Step_Start(4, "System should add empty row in the AG grid", test, test1);

		waitForDisplay(driver, AG_Grid_First_Row);

		if (isdisplayed(driver, AG_Grid_First_Row)) {

			System.out.println(
					"Expected result : After click the add port pair cancel button, Empty row should be added in the grid || Actual result : After click the add port pair cancel button, Empty row was added in the grid");
			Extent_pass_New(driver,
					"Expected result : After click the add port pair cancel button, Empty row should be added in the grid || Actual result : After click the add port pair cancel button, Empty row was added in the grid",
					test, test1);
		} else {

			System.out.println(
					"Expected result : After click the add port pair cancel button, Empty row should be added in the grid || Actual result : After click the add port pair cancel button, Empty row was not added in the grid");
			Extent_fail(driver,
					"Expected result : After click the add port pair cancel button, Empty row should be added in the grid || Actual result : After click the add port pair cancel button, Empty row was not added in the grid",
					test, test1);
		}

		Step_End(4, "System should add empty row in the AG grid", test, test1);

		Step_Start(5, "Click save ,It show the validation like Enter POL", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Verify_popup);

		String Actualpopup = getText(driver, popup_Message);

		if (Verify_popup.equals(Actualpopup)) {

			System.out.println("Matched || Expected popup message was : " + Verify_popup
					+ " || Actual popup message was : " + Actualpopup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Verify_popup
					+ " || Actual popup message was : " + Actualpopup, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup message was : " + Verify_popup
					+ " || Actual popup message was : " + Actualpopup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Verify_popup
					+ " || Actual popup message was : " + Actualpopup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(5, "Click save ,It show the validation like Enter POL", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
