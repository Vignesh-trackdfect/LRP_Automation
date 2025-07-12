package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Detention_Waiver_TS_015 extends Keywords {

	public void Detention_Waiver_TS_015(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Detention_Waiver_TS_015";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Detention_Module");
		String agencyUser = Excel_data.get("agencyUser");
		String Container_number = Excel_data.get("Container_number");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String Booking_number = Excel_data.get("BL_Number");
		String WaiverOption = Excel_data.get("Weiver_For");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Popup = Excel_data.get("Popup");
		String Seletct_Container_All_Remove = Excel_data.get("Seletct_Container_All_Remove");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String Container_number_Remove = Excel_data.get("Container_number_Remove");
		String Waiver_By = Excel_data.get("Waiver_By");
		String Waiver_Amount = Excel_data.get("Waiver_Amount");


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
		Step_Start(2, "Click on BL No Search Field ", test, test1);

		

		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		Step_End(2, "Click on BL No Search Field ", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		globalValueSearchWindow(driver, BookingSearch_Condition, BookingSearch_Option, Booking_number, "", "", "", "");

		String Booking_No = getAttribute(driver, DW_BookingNo_Input, "value");

		if (Booking_No.equals(Booking_number)) {

			System.out.println("Given Booking number was retrived || Expected value is : " + Booking_number
					+ " || Actual value is : " + Booking_No);
			Extent_pass_New(driver, "Given Booking number was retrived || Expected value is : " + Booking_number
					+ " || Actual value is : " + Booking_No, test, test1);

		} else {

			System.out.println("Given Booking number was not retrived || Expected value is : " + Booking_number
					+ " || Actual value is : " + Booking_No);
			Extent_fail(driver, "Given Booking number was not retrived || Expected value is : " + Booking_number
					+ " || Actual value is : " + Booking_No, test, test1);
		}

		Step_End(3, "Input your Confirm BL No", test, test1);

		Step_Start(4, "Click on show Button select the Row in Container Section", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
		waitForElement(driver, DW_Show);
		click(driver, DW_Show);

		Step_End(4, "Click on show Button select the Row in Container Section", test, test1);

		Step_Start(5, " Select theFre time Radio Button.", test, test1);

		scrollElementToView(driver, Detention_container_Filter);
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
		

		Step_End(5, " Select theFre time Radio Button.", test, test1);

		Step_Start(6, " Go to free time text field and enter Values as 0.", test, test1);

		String enable_check = String.format(DW_Radio_Button, Waiver_By);
		mouseOverToElement(driver, enable_check);
		
		waitForElement(driver, enable_check);
		click(driver, enable_check);

		String Input_Wiver = String.format(Weiver_Input, Waiver_By);
		waitForDisplay(driver, Input_Wiver);
		if(isElementEnabled(driver, Input_Wiver)) {
		waitForElement(driver, Input_Wiver);
		doubleClick(driver, Input_Wiver);
	clear(driver, Input_Wiver);
	waitForElement(driver, Input_Wiver);
		sendKeys(driver, Input_Wiver, Waiver_Amount);
		}
		Step_End(6, " Go to free time text field and enter Values as 0.", test, test1);

		Step_Start(7, "Click the Plus(+) button", test, test1);

		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);

		Step_End(7, "Click the Plus(+) button", test, test1);

		Step_Start(8, "system added the free time", test, test1);
		
		
		
		List<WebElement> waiverValueColumn = listOfElements(driver, DW_Waiver_Values_ColumnTable);
		List<String> Act_Waiver_ValuesList = new ArrayList<String>();
		for (WebElement columns : waiverValueColumn) {

			String ColText = columns.getText();
			Act_Waiver_ValuesList.add(ColText);

		}

		for (int i = 0; i < Act_Waiver_ValuesList.size(); i++) {

			String waiverValue = Act_Waiver_ValuesList.get(i);
			if(!Waiver_By.equalsIgnoreCase("Additional Free Days")) {

			double exp_Amount = getNumberValue(Waiver_Amount);
			double Act_Amount = getNumberValue(waiverValue);
			if (exp_Amount == Act_Amount) {
				System.out.println("Waiver Value Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected  : " + exp_Amount + " || Actual : " + Act_Amount);
				Extent_pass_New(
						driver, "Waiver Value Matched For the Container : " + ContainersList.get(i)
								+ "  || Expected  : " + exp_Amount + " || Actual : " + Act_Amount,
						test, test1);
			} else {
				System.out.println("Waiver Value Not Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected  : " + exp_Amount + " || Actual : " + Act_Amount);
				Extent_fail(
						driver, "Waiver Value Not Matched For the Container : " + ContainersList.get(i)
								+ "  || Expected  : " + exp_Amount + " || Actual : " + Act_Amount,
						test, test1);
			}
			}else {
				if (waiverValue.equals(Waiver_Amount) ) {
					System.out.println("Waiver Value Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + Waiver_Amount + " || Actual : " + waiverValue);
					Extent_pass_New(
							driver, "Waiver Value Matched For the Container : " + ContainersList.get(i)
									+ "  || Expected  : " + Waiver_Amount + " || Actual : " + waiverValue,
							test, test1);
				} else {
					System.out.println("Waiver Value Not Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + Waiver_Amount + " || Actual : " + waiverValue);
					Extent_fail(
							driver, "Waiver Value Not Matched For the Container : " + ContainersList.get(i)
									+ "  || Expected  : " + Waiver_Amount + " || Actual : " + waiverValue,
							test, test1);
				}
			}
		}
	

		Step_Start(9, " select the row in step 8.", test, test1);
		
		scrollElementToView(driver, DW_Select_All_Checkbox_Down);
		List<String> ContainersList1 = new ArrayList<String>();

		if (Seletct_Container_All_Remove.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column_Down);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList1.add(eletext);
			}

			waitForDisplay(driver, DW_Select_All_Checkbox_Down);
			click(driver, DW_Select_All_Checkbox_Down);

		} else {
			waitForElement(driver, Detention_Container_Grid2_Filter);
			click(driver, Detention_Container_Grid2_Filter);
			List<String> Containers_Select = splitAndExpand(Container_number_Remove);
			for (String container : Containers_Select) {

				ContainersList1.addAll(Containers_Select);
				waitForElement(driver, Detention_Container_Grid2_Filter_Searchfield);
				clear(driver, Detention_Container_Grid2_Filter_Searchfield);
				waitForElement(driver, Detention_Container_Grid2_Filter_Searchfield);
				sendKeys(driver, Detention_Container_Grid2_Filter_Searchfield, container);
				
				String containerInput = String.format(DW_Select_Container_Checkbox_Down, container);
				mouseOverToElement(driver, containerInput);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
				waitForElement(driver, Detention_Container_Grid2_Filter_Searchfield);
				clear(driver, Detention_Container_Grid2_Filter_Searchfield);
			
			}
			ContainersList1.addAll(Containers_Select);
		}
		
	
		Step_End(9, " select the row in step 8.", test, test1);

		Step_Start(10, " click (-)Minus Button and verify the validation", test, test1);

		waitForElement(driver, DW_remove_button);
		click(driver, DW_remove_button);

		waitForPopup(driver, popup_Message,Popup);
		String popup_act = getText(driver, popup_Message);

		if (Popup.equals(popup_act)) {
			System.out.println("Matched || Expected popup message is : " + Popup + "   ||   Actual popup message is : "
					+ popup_act);
			Extent_pass_New(driver, " Matched || Expected  : " + Popup + "   ||   Actual   : " + popup_act, test, test1);
		} else {
			System.out.println("Not Matched || Expected  popup message is : " + Popup
					+ "   ||   Actual  popup message is : " + popup_act);
			Extent_fail(driver, " Not Matched || Expected popup message is : " + Popup
					+ "   ||   Actual popup message is  : " + popup_act, test, test1);
		}

		Step_End(10, " click (-)Minus Button and verify the validation", test, test1);

		Step_Start(11, " Make sure that added container should not be removed", test, test1);

		waitForElement(driver, popup_Message_No_Button);
		click(driver, popup_Message_No_Button);
		
		
		List<String> Containers_Select = splitAndExpand(Container_number_Remove);
		for (String container : Containers_Select) {

			String containerInput = String.format(DW_Select_Container_Checkbox_Down, container);
			waitForDisplay(driver, containerInput);
			
		
		ContainersList1.addAll(Containers_Select);
		
		if(isdisplayed(driver, DW_Select_Container_down_gird)) {
		
			System.out.println(
					"Pass || Expected result is : After click on No option added container should not removed || Actual result is : After click on No option added container not removed");
			Extent_pass_New(driver,
					"Pass || Expected result is : After click on No option added container should not removed || Actual result is : After click on No option added container not removed",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : After click on No option added container should not removed || Actual result is : After click on No option added container  removed");
			Extent_fail(driver,
					"Fail || Expected result is : After click on No option added container should not removed || Actual result is : After click on No option added container  removed",
					test, test1);
		}}

		Step_End(11, " Make sure that added container should not be removed", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
