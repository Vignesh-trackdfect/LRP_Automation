package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Detention_Waiver_TS_012 extends Keywords {

	public void Detention_Waiver_TS_012(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Detention_Waiver_TS_012";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Detention_Module = Excel_data.get("Detention_Module");
		String agencyUser = Excel_data.get("agencyUser");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String WaiverOption = Excel_data.get("Weiver_For");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Condition = Excel_data.get("Condition");
		String Bl_Input_Field = Excel_data.get("BL_Number");
		String Additional_Free_Days = Excel_data.get("Additional_Free_Days");
		String Container_number = Excel_data.get("Container_number");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		SwitchProfile(driver, agencyUser);

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
		Step_Start(2, "Click on BL No Search Field ", test, test1);
		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		globalValueSearchWindow(driver, Condition, BookingSearch_Option, Bl_Input_Field, "", "", "", "");

		Step_End(2, "Click on BL No Search Field ", test, test1);

		Step_Start(3, "Input your Confirm BL No ", test, test1);

		String Booking_No = getAttribute(driver, DW_BookingNo_Input, "value");

		if (Booking_No.equals(Bl_Input_Field)) {

			System.out.println("Given Booking number was retrived || Expected value is : " + Bl_Input_Field
					+ " || Actual value is : " + Booking_No);
			Extent_pass_New(driver, "Given Booking number was retrived || Expected value is : " + Bl_Input_Field
					+ " || Actual value is : " + Booking_No, test, test1);

		} else {

			System.out.println("Given Booking number was not retrived || Expected value is : " + Bl_Input_Field
					+ " || Actual value is : " + Booking_No);
			Extent_fail(driver, "Given Booking number was not retrived || Expected value is : " + Bl_Input_Field
					+ " || Actual value is : " + Booking_No, test, test1);
		}

		Step_End(3, "Input your Confirm BL No ", test, test1);

		Step_Start(4, "Click on show Button select the Row in Container Section", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		waitForElement(driver, DW_Show);
		click(driver, DW_Show);

		Step_End(4, "Click on show Button select the Row in Container Section", test, test1);

		Step_Start(5, " Select theFre time Radio Button.", test, test1);

		scrollUsingElement(driver, DW_Total_records);
		
		
		
		List<String> ContainersList = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList.add(eletext);
			}

			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else {
			waitForElement(driver, Detention_container_Filter);
			click(driver, Detention_container_Filter);
			List<String> Containers_Select = splitAndExpand(Container_number);
			for (String container : Containers_Select) {

				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, container);
				
				String containerInput = String.format(DW_Select_Container_Checkbox, container);
				mouseOverToElement(driver, containerInput);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
			}
			ContainersList.addAll(Containers_Select);
		}
		
		
		


		Step_End(5, " Select theFre time Radio Button.", test, test1);

		Step_Start(6, "Go to free time text field and enter Values as 5789609", test, test1);

		waitForElement(driver, DW_Additional_Free_Days);
		doubleClick(driver, DW_Additional_Free_Days);
	
		Newclear(driver, DW_Additional_Free_Days);
		sendKeys(driver, DW_Additional_Free_Days, Additional_Free_Days);

		Step_End(6, "Go to free time text field and enter Values as 5789609", test, test1);

		Step_Start(7, "Click the Plus(+) button", test, test1);

		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);

		Step_End(7, "Click the Plus(+) button", test, test1);

		Step_Start(8, "Verify  that system added the 5789 free time for requested container", test, test1);
		String firstFourDigits = Additional_Free_Days.substring(0, 4);
		
		
		
		List<WebElement> waiverValueColumn = listOfElements(driver, DW_Waiver_Values_ColumnTable);
		List<String> Act_Waiver_ValuesList = new ArrayList<String>();
		for (WebElement columns : waiverValueColumn) {

			String ColText = columns.getText();
			Act_Waiver_ValuesList.add(ColText);

		}

		for (int i = 0; i < Act_Waiver_ValuesList.size(); i++) {

			String waiverValue = Act_Waiver_ValuesList.get(i);
			double exp_Amount = getNumberValue(firstFourDigits);
			double Act_Amount = getNumberValue(waiverValue);
			if (exp_Amount == Act_Amount) {
				System.out.println("Waiver Value Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected  : " + firstFourDigits + " || Actual : " + waiverValue);
				Extent_pass_New(
						driver, "Waiver Value Matched For the Container : " + ContainersList.get(i)
								+ "  || Expected  : " + firstFourDigits + " || Actual : " + waiverValue,
						test, test1);
			} else {
				System.out.println("Waiver Value Not Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected  : " + firstFourDigits + " || Actual : " + waiverValue);
				Extent_fail(
						driver, "Waiver Value Not Matched For the Container : " + ContainersList.get(i)
								+ "  || Expected  : " + firstFourDigits + " || Actual : " + waiverValue,
						test, test1);
			}

		}
	
		Step_End(8, "Verify  that system added the 5789 free time for requested container", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}