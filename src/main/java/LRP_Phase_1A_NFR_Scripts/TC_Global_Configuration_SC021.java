package LRP_Phase_1A_NFR_Scripts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Global_Configuration_SC021 extends Keywords {

	public void Global_Configuration_SC021(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Global_Configuration_SC021";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Attribute_ColumnName = Excel_data.get("Attribute_ColumnName");
		String Attribute_value = Excel_data.get("Attribute_value");
		String Description_ColumnName = Excel_data.get("Description_ColumnName");
		String Description_value = Excel_data.get("Description_value");
		String Type_ColumnName = Excel_data.get("Type_ColumnName");
		String Type_value = Excel_data.get("Type_value");
		String Value_ColumnName = Excel_data.get("Value_ColumnName");
		String ValueField_value = Excel_data.get("ValueField_value");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login & open global configuration screen", test, test1);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Login & open global configuration screen", test, test1);

		Step_Start(2,
				"Scroll through a specific column (e.g., \"Type\") and identify that it contains duplicate values (e.g., multiple \"Varchar\" entries)",
				test, test1);

		waitForElement(driver, GC_Total_Records);
		String Exp_Record = getText(driver, GC_Total_Records);

		List<String> AllValues = new ArrayList<String>();

		for (int i = 0; i < Integer.parseInt(Exp_Record); i++) {

			String Gridcolumn = String.format(GC_AttributeList, i);

			mouseOverToElement(driver, Gridcolumn);

			String GridValues = getText(driver, Gridcolumn);

			AllValues.add(GridValues);

		}

		Set<String> uniqueItems = new HashSet<>();
		Set<String> duplicates = new HashSet<>();

		for (String item : AllValues) {
			if (!uniqueItems.add(item)) {
				duplicates.add(item); // Already exists → it's a duplicate
			}
		}

		System.out.println("Duplicate values: " + duplicates);

		System.out.println(
				"Expected result : Duplicate values should not present in the grid || Actual result : Duplicate values are present in the grid and the duplicate values are - "
						+ duplicates);
		Extent_cal(test, test1,
				"Expected result : Duplicate values should not present in the grid || Actual result : Duplicate values are present in the grid and the duplicate values are - "
						+ duplicates);

		waitForElement(driver, GC_Refresh_button_option);
		click(driver, GC_Refresh_button_option);

		Step_End(2,
				"Scroll through a specific column (e.g., \"Type\") and identify that it contains duplicate values (e.g., multiple \"Varchar\" entries)",
				test, test1);

		Step_Start(3, "Click the “Distinct Filter” Icon on tool bar header.", test, test1);

		waitForElement(driver, GC_Distinct_Filter);
		click(driver, GC_Distinct_Filter);

		Step_End(3, "Click the “Distinct Filter” Icon on tool bar header.", test, test1);

		Step_Start(4, "A dropdown or selection list will appear. Choose a column like 'Type'", test, test1);

		Step_Start(5, "Check that the grid now only displays one row per unique value in the selected column.", test,
				test1);

		AG_DistinctFilter(driver, Attribute_ColumnName, Attribute_value);

		List<String> GridFiltered_Values = new ArrayList<String>();

		List<WebElement> attributelist = listOfElements(driver, GC_AttributeGridList);

		for (WebElement ele : attributelist) {

			String GridValues = getText1(driver, ele);

			GridFiltered_Values.add(GridValues);

		}

		for (String GridFiltered_Value : GridFiltered_Values) {

			if (GridFiltered_Value.equalsIgnoreCase(Attribute_value)) {

				System.out.println("Expected result : Filtered value " + Attribute_value
						+ " only should be present in the Grid || Actual result : Filtered values " + GridFiltered_Value
						+ " only showing in the grid");
				Extent_pass_New(driver,
						"Expected result : Filtered value " + Attribute_value
								+ " only should be present in the Grid || Actual result : Filtered values "
								+ GridFiltered_Value + " only showing in the grid",
						test, test1);

			} else {

				System.out.println("Expected result : Filtered value " + Attribute_value
						+ " only should be present in the Grid || Actual result : other than the Filtered value "
						+ GridFiltered_Value + " was present in the grid");
				Extent_fail(driver, "Expected result : Filtered value " + Attribute_value
						+ " only should be present in the Grid || Actual result : other than the Filtered value "
						+ GridFiltered_Value + "  was present in the grid", test, test1);

			}

		}

		waitForElement(driver, GC_Reset_Button);
		click(driver, GC_Reset_Button);

		waitForElement(driver, GC_Distinct_Filter);
		click(driver, GC_Distinct_Filter);

		AG_DistinctFilter(driver, Type_ColumnName, Type_value);

		List<String> GridFiltered_Values2 = new ArrayList<String>();

		List<WebElement> Typelist = listOfElements(driver, GC_TypeGridList);

		for (WebElement ele : Typelist) {

			String GridValues = getText1(driver, ele);

			GridFiltered_Values2.add(GridValues);

		}

		for (String GridFiltered_Value : GridFiltered_Values2) {

			if (GridFiltered_Value.equalsIgnoreCase(Type_value)) {

				System.out.println("Expected result : Filtered value " + Type_value
						+ " only should be present in the Grid || Actual result : Filtered values " + GridFiltered_Value
						+ " only showing in the grid");
				Extent_pass_New(driver,
						"Expected result : Filtered value " + Type_value
								+ " only should be present in the Grid || Actual result : Filtered values "
								+ GridFiltered_Value + " only showing in the grid",
						test, test1);

			} else {

				System.out.println("Expected result : Filtered value " + Type_value
						+ " only should be present in the Grid || Actual result : other than the Filtered value "
						+ GridFiltered_Value + " was present in the grid");
				Extent_fail(driver, "Expected result : Filtered value " + Type_value
						+ " only should be present in the Grid || Actual result : other than the Filtered value "
						+ GridFiltered_Value + "  was present in the grid", test, test1);

			}

		}

		waitForElement(driver, GC_Reset_Button);
		click(driver, GC_Reset_Button);

		waitForElement(driver, GC_Distinct_Filter);
		click(driver, GC_Distinct_Filter);

		AG_DistinctFilter(driver, Description_ColumnName, Description_value);

		List<String> GridFiltered_Values3 = new ArrayList<String>();

		List<WebElement> desclist = listOfElements(driver, GC_DescriptionGridList);

		for (WebElement ele : desclist) {

			String GridValues = getText1(driver, ele);

			GridFiltered_Values3.add(GridValues);

		}

		for (String GridFiltered_Value : GridFiltered_Values3) {

			if (GridFiltered_Value.equalsIgnoreCase(Description_value)) {

				System.out.println("Expected result : Filtered value " + Description_value
						+ " only should be present in the Grid || Actual result : Filtered values " + GridFiltered_Value
						+ " only showing in the grid");
				Extent_pass_New(driver,
						"Expected result : Filtered value " + Description_value
								+ " only should be present in the Grid || Actual result : Filtered values "
								+ GridFiltered_Value + " only showing in the grid",
						test, test1);

			} else {

				System.out.println("Expected result : Filtered value " + Description_value
						+ " only should be present in the Grid || Actual result : other than the Filtered value "
						+ GridFiltered_Value + " was present in the grid");
				Extent_fail(driver, "Expected result : Filtered value " + Description_value
						+ " only should be present in the Grid || Actual result : other than the Filtered value "
						+ GridFiltered_Value + "  was present in the grid", test, test1);

			}

		}

		waitForElement(driver, GC_Reset_Button);
		click(driver, GC_Reset_Button);

		waitForElement(driver, GC_Distinct_Filter);
		click(driver, GC_Distinct_Filter);

		AG_DistinctFilter(driver, Value_ColumnName, ValueField_value);

		List<String> GridFiltered_Values4 = new ArrayList<String>();

		List<WebElement> valuelist = listOfElements(driver, GC_ValueGridList);

		for (WebElement ele : valuelist) {

			String GridValues = getText1(driver, ele);

			GridFiltered_Values4.add(GridValues);

		}

		for (String GridFiltered_Value : GridFiltered_Values4) {

			if (GridFiltered_Value.equalsIgnoreCase(ValueField_value)) {

				System.out.println("Expected result : Filtered value " + ValueField_value
						+ " only should be present in the Grid || Actual result : Filtered values " + GridFiltered_Value
						+ " only showing in the grid");
				Extent_pass_New(driver,
						"Expected result : Filtered value " + ValueField_value
								+ " only should be present in the Grid || Actual result : Filtered values "
								+ GridFiltered_Value + " only showing in the grid",
						test, test1);

			} else {

				System.out.println("Expected result : Filtered value " + ValueField_value
						+ " only should be present in the Grid || Actual result : other than the Filtered value "
						+ GridFiltered_Value + " was present in the grid");
				Extent_fail(driver, "Expected result : Filtered value " + ValueField_value
						+ " only should be present in the Grid || Actual result : other than the Filtered value "
						+ GridFiltered_Value + "  was present in the grid", test, test1);

			}

		}

		waitForElement(driver, GC_Reset_Button);
		click(driver, GC_Reset_Button);

		Step_End(4, "A dropdown or selection list will appear. Choose a column like 'Type'", test, test1);

		Step_End(5, "Check that the grid now only displays one row per unique value in the selected column.", test,
				test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
