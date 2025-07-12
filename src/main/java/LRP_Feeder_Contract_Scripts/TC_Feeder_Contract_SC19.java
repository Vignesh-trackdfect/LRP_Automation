package LRP_Feeder_Contract_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC19 extends Keywords {

	public void Feeder_Contract_SC19(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC19";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Vendor_Header = Excel_data.get("Vendor_Header");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Valid_Term_Color = Excel_data.get("Valid_Term_Color");
		String Deleted_Term_Color = Excel_data.get("Deleted_Term_Color");
		String Haulage_Feeder_Module_Name = Excel_data.get("Haulage_Feeder_Module_Name");
		String Column_Index = Excel_data.get("Column_Index");

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

		Step_Start(4, "It show the Feeder Contract input details page.", test, test1);

		if (isdisplayed(driver, FC_EquipmentDropdown)) {
			System.out.println(
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is displayed");
			Extent_pass_New(driver,
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is displayed",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is not displayed");
			Extent_fail(driver,
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is not displayed",
					test, test1);

		}

		Step_End(4, "It show the Feeder Contract input details page.", test, test1);

		Step_Start(5, "Load and discharge term should need to present in the Haulage/feeder term master", test, test1);

//      Load Term
		waitForElement(driver, FC_Load_Term);
		click(driver, FC_Load_Term);

		waitForElement(driver, two_Column_Search_Column_1_Gridcells);
		List<WebElement> term_Gridcells = listOfElements(driver, two_Column_Search_Column_1_Gridcells);
		ArrayList<String> term_Values_FDR = new ArrayList<String>();

		for (WebElement term_Gridcell : term_Gridcells) {

			String actualTermValue = term_Gridcell.getText();
			term_Values_FDR.add(actualTermValue);
		}

		System.out.println("term_Values_FDR Load: " + term_Values_FDR);

		waitForElement(driver, twoColumnSearch_Cancel_Button);
		click(driver, twoColumnSearch_Cancel_Button);

//		Discharge  Term

		waitForElement(driver, FC_DischargeTerm);
		click(driver, FC_DischargeTerm);

		waitForElement(driver, two_Column_Search_Column_1_Gridcells);
		List<WebElement> term_Gridcells_Discharge = listOfElements(driver, two_Column_Search_Column_1_Gridcells);
		ArrayList<String> term_Values_FDR_Discharge = new ArrayList<String>();

		for (WebElement term_Gridcell : term_Gridcells_Discharge) {

			String actualTermValue = term_Gridcell.getText();
			term_Values_FDR_Discharge.add(actualTermValue);
		}

		System.out.println("term_Values_FDR_Discharge: " + term_Values_FDR_Discharge);

		waitForElement(driver, twoColumnSearch_Cancel_Button);
		click(driver, twoColumnSearch_Cancel_Button);

		waitForElement(driver, Feeder_Contract_Input_Details_Close_Button);
		click(driver, Feeder_Contract_Input_Details_Close_Button);

		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

//		Haulage/Feeder Terms Master

		moduleNavigate(driver, Haulage_Feeder_Module_Name);

		waitForElement(driver, Haulage_Feeder_Terms_Mater_Table);

		String Contract_Term_Column_Gridcells = String.format(FC_Contract_Term_Column_Gridcells, Column_Index);

		List<WebElement> Contract_Value = listOfElements(driver, Contract_Term_Column_Gridcells);
		List<String> blackText = new ArrayList<String>();
		List<String> redText = new ArrayList<String>();

		for (WebElement Contract_Value1 : Contract_Value) {

			String text = Contract_Value1.getText();
			String color = Contract_Value1.getCssValue("color");

			String hexcolor = rgbToHex(color);
			String actualColor = getColorName(hexcolor);
			if (actualColor.equals(Valid_Term_Color)) {
				blackText.add(text);
			} else if (actualColor.equals(Deleted_Term_Color)) {
				redText.add(text);
			}
		}

		System.out.println("Black texts : " + blackText);
		System.out.println("Red texts : " + redText);

//      Load Term		
		for (int i = 0; i < blackText.size(); i++) {
			boolean presence = false;
			String Haulage_Feeder_Terms_Master_Term = blackText.get(i);
			int k = 0;
			for (int j = 0; j < term_Values_FDR.size(); j++) {
				String Feeder_Load_Term = term_Values_FDR.get(k);

				if (Feeder_Load_Term.equals(Haulage_Feeder_Terms_Master_Term)) {
					System.out.println("Matched || Load Terms in Feeder Contracts module : " + Feeder_Load_Term
							+ " ||  Term in Haulage/Feeder Terms Master module :  " + Haulage_Feeder_Terms_Master_Term);
					Extent_pass_New(driver, "Matched || Load Terms in Feeder Contracts module : " + Feeder_Load_Term
							+ " ||  Term in Haulage/Feeder Terms Master module :  " + Haulage_Feeder_Terms_Master_Term,
							test, test1);
					presence = true;
				}
				k++;
			}
			if (presence == false) {
				System.out.println("Not Matched || Load Terms in Feeder Contracts module : " + term_Values_FDR
						+ " ||  Term in Haulage/Feeder Terms Master module :  " + Haulage_Feeder_Terms_Master_Term);
				Extent_fail(driver, "Not Matched || Load Terms in Feeder Contracts module : " + term_Values_FDR
						+ " ||  Term in Haulage/Feeder Terms Master module :  " + Haulage_Feeder_Terms_Master_Term,
						test, test1);
			}
		}
//		Discharge  Term
		for (int i = 0; i < blackText.size(); i++) {
			boolean presence = false;
			String Haulage_Feeder_Terms_Master_Term = blackText.get(i);
			int k = 0;
			for (int j = 0; j < term_Values_FDR_Discharge.size(); j++) {
				String Feeder_Discharge_Term = term_Values_FDR_Discharge.get(k);

				if (Feeder_Discharge_Term.equals(Haulage_Feeder_Terms_Master_Term)) {
					System.out.println("Matched || Discharge Terms in Feeder Contracts module : "
							+ Feeder_Discharge_Term + " ||  Term in Haulage/Feeder Terms Master module :  "
							+ Haulage_Feeder_Terms_Master_Term);
					Extent_pass_New(driver,
							"Matched || Discharge Terms in Feeder Contracts module : " + Feeder_Discharge_Term
									+ " ||  Term in Haulage/Feeder Terms Master module :  "
									+ Haulage_Feeder_Terms_Master_Term,
							test, test1);
					presence = true;
				}
				k++;
			}
			if (presence == false) {
				System.out.println("Not Matched || Discharge Terms in Feeder Contracts module : "
						+ term_Values_FDR_Discharge + " ||  Term in Haulage/Feeder Terms Master module :  "
						+ Haulage_Feeder_Terms_Master_Term);
				Extent_fail(driver,
						"Not Matched || Discharge Terms in Feeder Contracts module : " + term_Values_FDR_Discharge
								+ " ||  Term in Haulage/Feeder Terms Master module :  "
								+ Haulage_Feeder_Terms_Master_Term,
						test, test1);
			}
		}

		Step_End(5, "Load and discharge term should need to present in the Haulage/feeder term master", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
