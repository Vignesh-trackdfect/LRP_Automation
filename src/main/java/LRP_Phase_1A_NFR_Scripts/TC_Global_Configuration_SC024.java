package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Global_Configuration_SC024 extends Keywords {
	public void Global_Configuration_SC024(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Global_Configuration_SC024";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Global_Configuration_Module = Excel_data.get("Global_Configuration_Module");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login & open global configuration screen..", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Global_Configuration_Module);

		Step_End(1, "Login & open global configuration screen..", test, test1);

		Step_Start(2, "Sort Attribute column alphabetically, or UserType in descending order", test, test1);

		String GC_Value = getText(driver, GC_first_row_attribute);
		System.out.println("Before Arranging the order, Attribute in first row is :" + GC_Value);

		waitForElement(driver, GC_Attribute_header);
		doubleClick(driver, GC_Attribute_header);

		String GC_Value1 = getText(driver, GC_first_row_attribute);
		System.out.println("After Arranged to Descending order, Attribute in first row is :" + GC_Value1);

		if (!GC_Value.equals(GC_Value1)) {

			System.out.println("Attribute column is changed to descending order, the value is :" + GC_Value1);
			Extent_pass_New(driver, "Attribute column is changed to descending order, the value is :" + GC_Value1, test,
					test1);

		} else {

			System.out.println("Attribute column is  not changed to descending order, the value is :" + GC_Value1);
			Extent_pass(driver, "Attribute column is  not changed to descending order, the value is :" + GC_Value1,
					test, test1);

		}

		Step_End(2, "Sort Attribute column alphabetically, or UserType in descending order", test, test1);

		Step_Start(3, "Open the settings menu and click the “Reset” icon.", test, test1);
		
		Step_Start(4, "All filters should be cleared.Column order should return to default", test, test1);

		waitForElement(driver, GC_Refresh_Button);
		click(driver, GC_Refresh_Button);

		waitForElement(driver, GC_first_row_attribute);
		String GC_Value2 = getText(driver, GC_first_row_attribute);
		System.out.println("Attribute value in first row is :" + GC_Value2);

		if (GC_Value.equals(GC_Value2)) {

			System.out.println(
					"Expected || Before Filtering ,the column in default order And  Attribute value In First row is :"
							+ GC_Value
							+ "Actual || After clicking Reset Button,the column changes to default order ,and the Attribute value in First row is : "
							+ GC_Value2);
			Extent_pass_New(driver, GC_Value2, test, test1);

		} else {

			System.out.println(
					"Expected || Before Filtering ,the column in default order And  Attribute value In First row is :"
							+ GC_Value
							+ "Actual || After clicking Reset Button,the column changes to default order ,and the Attribute value in First row is : "
							+ GC_Value2);
			Extent_fail(driver,
					"Expected || Before Filtering ,the column in default order And  Attribute value In First row is :"
							+ GC_Value
							+ "Actual || After clicking Reset Button,the column changes to default order ,and the Attribute value in First row is : "
							+ GC_Value2,
					test, test1);

		}

		Step_End(3, "Open the settings menu and click the “Reset” icon.", test, test1);

		Step_End(4, "All filters should be cleared.Column order should return to default", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
