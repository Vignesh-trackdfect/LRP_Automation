package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Detention_Waiver_TS_009 extends Keywords {

	public void Detention_Waiver_TS_009(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Detention_Waiver_TS_009";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String Booking_number = Excel_data.get("BL_Number");
		String WaiverOption = Excel_data.get("Weiver_For");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Container_number = Excel_data.get("Container_number");
		String DW_Addition_Days_Input_Value = Excel_data.get("DW_Addition_Days_Input_Value");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

Step_Start(1, "Open Detention weiver Module", test, test1);
		
		moduleNavigate(driver, Detention_Module);
		Step_End(1, "Open Detention weiver Module", test, test1);


		newButton(driver);
		String Waiveroption = String.format(DW_WaiverOption, WaiverOption);

		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);
		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);

		
		Step_Start(2, "Click on BL No Search Field", test, test1);

		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		Step_End(2, "Click on BL No Search Field", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		globalValueSearchWindow(driver, BookingSearch_Condition, BookingSearch_Option, Booking_number, "", "", "", "");

		Step_End(3, "Input your Confirm BL No", test, test1);

		Step_Start(4, "Click on show Button select the Row in Container Section", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
		waitForElement(driver, DW_Show);
		click(driver, DW_Show);

		List<String> ContainersList = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList.add(eletext);
			}
mouseOverToElement(driver, DW_Select_All_Checkbox);
			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else {
			List<String> Containers_Select = splitAndExpand(Container_number);
			for (String container : Containers_Select) {
				waitForElement(driver, Detention_container_Filter);
				click(driver, Detention_container_Filter);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
				
				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, container);
				String containerInput = String.format(DW_Select_Container_Checkbox, container);
				mouseOverToElement(driver, containerInput);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
			}
			ContainersList.addAll(Containers_Select);
		}
	

		Step_End(4, "Click on show Button select the Row in Container Section", test, test1);

		Step_Start(5, "Select the Free Days Radio Button", test, test1);
		mouseOverToElement(driver, DWAddtionfreedays_Radio_Button);
		waitForElement(driver, DWAddtionfreedays_Radio_Button);
		click(driver, DWAddtionfreedays_Radio_Button);

		Step_End(5, " Select the Free Days Radio Button", test, test1);

		Step_Start(6, "Go to Free Days Field and enter the Free time as Negative Value -5 like. ", test, test1);

		waitForElement(driver, DW_Addition_Days_Input);
		sendKeys(driver, DW_Addition_Days_Input, DW_Addition_Days_Input_Value);
		enter(driver);

		Step_End(6, "Go to Free Days Field and enter the Free time as Negative Value -5 like. ", test, test1);

		Step_Start(7, "Verify that System allowed only postive Value", test, test1);

		waitForElement(driver, DW_Addition_Days_Input);
	

		String negative_value = getAttribute(driver, DW_Addition_Days_Input, "value");

		if (!DW_Addition_Days_Input_Value.equals(negative_value)) {
			System.out.println("System allowed only positive value ||   Expected value given in the test data : " + DW_Addition_Days_Input_Value
					+ "   ||   Actual Application was not taking the nagative value given nagative value was not entered  : " + negative_value);
			Extent_pass_New(driver, "System allowed only positive value ||   Expected  value given in the test data : " + DW_Addition_Days_Input_Value
					+ "   ||   Actual Application was not taking the nagative value given nagative value was not entered  : " + negative_value, test, test1);
		} else {
			System.out.println("System allowed negative value ||   Expected value given in the test data  : " + DW_Addition_Days_Input_Value
					+ "   ||   Actual Application was not taking the nagative value given nagative value was not entered  : " + negative_value);
			Extent_fail(driver, "System allowed negative value ||   Expected value given in the test data  : " + DW_Addition_Days_Input_Value
					+ "   ||   Actual Application was not taking the nagative value given nagative value was not entered  : " + negative_value, test, test1);
		}
		Step_End(7, "Verify that System allowed only postive Value", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}