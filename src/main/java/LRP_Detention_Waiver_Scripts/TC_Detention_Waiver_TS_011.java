package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_011 extends Keywords {

	public void Detention_Waiver_TS_011(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Detention_Waiver_TS_011";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Detention_Module");
		String agencyUser = Excel_data.get("agencyUser");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String Booking_number = Excel_data.get("BL_Number");
		String WaiverOption = Excel_data.get("Weiver_For");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Invoice_grid = Excel_data.get("Invoice_grid");
		String Waiver_Lumpsum_popup = Excel_data.get("Waiver_Lumpsum_Popup");
		String Container_number = Excel_data.get("Container_number");
		String Popup_value = Excel_data.get("Popup_value");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String WaiverBy = Excel_data.get("WaiverBy");
		String WaiverByvalue = Excel_data.get("WaiverByvalue");
		

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		SwitchProfile(driver, agencyUser);

		verifyMainMenu(driver);

		Step_Start(1, "Open Detention weiver Module", test, test1);

		moduleNavigate(driver, Module);
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

		Step_Start(4, "Click on show Button select the Row in Container Section,", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
		waitForElement(driver, DW_Show);
		click(driver, DW_Show);

		Step_End(4, "Click on show Button select the Row in Container Section,", test, test1);

		scrollUsingElement(driver, DW_Total_records);

		Step_Start(5, "Verify that Net Tariff Amount  0.00 for the selected container", test, test1);
		waitForElement(driver, DW_Show);
		reArrangeAG_GridColumnsWithoutCheckbox(driver, Invoice_grid);

		List<WebElement> rows = listOfElements(driver, DW_Net_Tariff_Amount);
		ArrayList<String> net_Tariff_amount = new ArrayList<String>();

		for (int i = 0; i < rows.size() - 1; i++) {

			String value = rows.get(i).getText();
			System.out.println("value :" + value);
			net_Tariff_amount.add(value);

			if (value.contains("0.00")) {
				System.out.println("Net_Tariff Amount of Row " + i + 1 + " || Matched ||   Expected  : " + "0.00"
						+ "   ||   Actual   : " + value);
				Extent_pass_New(driver, "Net_Tariff Amount of Row " + i + 1 + " || Matched ||   Expected  : " + "0.00"
						+ "   ||   Actual   : " + value, test, test1);
			} else {
				System.out.println("Net_Tariff Amount of Row " + i + 1 + " || Not Matched ||   Expected  : " + "0.00"
						+ "   ||   Actual   : " + value);
				Extent_fail(driver, "Net_Tariff Amount of Row " + i + 1 + " ||NOt Matched ||   Expected  : " + "0.00"
						+ "   ||   Actual   : " + value, test, test1);
			}

		}
		Step_End(5, "Verify that Net Tariff Amount  0.00 for the selected container", test, test1);

		Step_Start(6, "Select the %/LP  Radio Button", test, test1);

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

		Step_Start(7, "Select the %/LP  Radio Button", test, test1);
		Step_Start(8, "Go to LP/% Field and enter the % /LPas  1000 and 101", test, test1);
		Step_Start(9, "Click the Plus(+) button.", test, test1);

		 if (WaiverBy.equalsIgnoreCase("Waiver Lumpsum")) {

				waitForElement(driver, DW_Lumpsum_radioBtn);
				click(driver, DW_Lumpsum_radioBtn);

				isElementEnabled(driver, DW_Lumpsum_Input);
				waitForElement(driver, DW_Lumpsum_Input);
				Newclear(driver, DW_Lumpsum_Input);
				Actionsendkeys(driver, DW_Lumpsum_Input, WaiverByvalue);
				click(driver, DW_Lumpsum_radioBtn);

				waitForElement(driver, DW_Waiver_Add_button);
				click(driver, DW_Waiver_Add_button);

			

			} else if (WaiverBy.equalsIgnoreCase("Waiver %")) {

				waitForElement(driver, DW_Waiver_percent_RadioBtn);
				click(driver, DW_Waiver_percent_RadioBtn);

				isElementEnabled(driver, DW_Waiver_percent_Input);
				waitForElement(driver, DW_Waiver_percent_Input);
				Newclear(driver, DW_Waiver_percent_Input);
				Actionsendkeys(driver, DW_Waiver_percent_Input, WaiverByvalue);

				waitForElement(driver, DW_Waiver_Add_button);
				click(driver, DW_Waiver_Add_button);

				

			}
		 
		Step_End(6, "Select the %/LP  Radio Button", test, test1);

		Step_End(7, "Select the %/LP  Radio Button", test, test1);


		Step_End(8, "Go to LP/% Field and enter the % /LPas  1000 and 101", test, test1);



		Step_End(9, "Click the Plus(+) button.", test, test1);
		List<String> actContainers = splitAndExpand(Container_number, ",");

		String formattedList = String.join(" , ", actContainers);

		Popup_value = String.format(Popup_value, formattedList);

		waitForPopup(driver, popup_Message, Waiver_Lumpsum_popup);
		String popup_act = getText(driver, popup_Message);

		if (Waiver_Lumpsum_popup.equals(popup_act) ) {
			System.out.println("Matched ||   Expected  popup value is : " + Waiver_Lumpsum_popup
					+ "   ||   Actual   popup value is : " + popup_act);
			Extent_pass_New(driver, " Matched ||   Expected   popup value is : " + Waiver_Lumpsum_popup
					+ "   ||   Actual  popup value is  : " + popup_act, test, test1);
		} else if(Popup_value.equals(popup_act)) {
			System.out.println("Matched ||   Expected  popup value is : " + Popup_value
					+ "   ||   Actual   popup value is : " + popup_act);
			Extent_pass_New(driver, " Matched ||   Expected   popup value is : " + Popup_value
					+ "   ||   Actual  popup value is  : " + popup_act, test, test1);
		}else {
			System.out.println("Not Matched ||   Expected   popup value is : " + Waiver_Lumpsum_popup
					+ "   ||   Actual   popup value is : " + popup_act);
			Extent_fail(driver, " Not Matched ||   Expected  popup value is : " + Waiver_Lumpsum_popup
					+ "   ||   Actual   popup value is : " + popup_act, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Extent_completed(testcase_Name, test, test1);

	}
}