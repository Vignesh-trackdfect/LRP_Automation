package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Detention_Waiver_TS_014 extends Keywords {
	public void Detention_Waiver_TS_014(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Detention_Waiver_TS_014";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Detention_Module = Excel_data.get("Detention_Module");
		String agencyUser = Excel_data.get("agencyUser");
		String Container_number = Excel_data.get("Container_number");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String WaiverOption = Excel_data.get("Weiver_For");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Bl_Input_Field = Excel_data.get("BL_Number");
		String Popup = Excel_data.get("Popup");
		String Seletct_Container_All_Remove = Excel_data.get("Seletct_Container_All_Remove");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String Waiver_By = Excel_data.get("Waiver_By");
		String Waiver_Amount = Excel_data.get("Waiver_Amount");

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

		Step_End(2, "Click on BL No Search Field ", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		globalValueSearchWindow(driver, BookingSearch_Condition, BookingSearch_Option, Bl_Input_Field, "", "", "", "");

		

		Step_End(3, "Input your Confirm BL No", test, test1);

		Step_Start(4, "Click on show Button select the Row in Container Section", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
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

		Step_Start(6, " Go to free time text field and enter Values as 0.", test, test1);

		String enable_check = String.format(DW_Radio_Button, Waiver_By);
		mouseOverToElement(driver, enable_check);
		
		waitForElement(driver, enable_check);
		click(driver, enable_check);

		String Input_Wiver = String.format(Weiver_Input, Waiver_By);
		isElementEnabled(driver, Input_Wiver);
		waitForElement(driver, Input_Wiver);
		doubleClick(driver, Input_Wiver);
	clear(driver, Input_Wiver);
	waitForElement(driver, Input_Wiver);
		sendKeys(driver, Input_Wiver, Waiver_Amount);

		Step_End(6, " Go to free time text field and enter Values as 0.", test, test1);

		Step_Start(7, "Click the Plus(+) button", test, test1);

		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);

		Step_End(7, "Click the Plus(+) button", test, test1);

		Step_Start(8, "system added the free time", test, test1);

		waitForElement(driver, DW_Value);
		String waiver_Value = getText(driver, DW_Value);
		System.out.println("waiver_Value :" + waiver_Value);
		
		if(!Waiver_By.equalsIgnoreCase("Additional Free Days")) {
		double waiverValue=Double.parseDouble(waiver_Value);
		System.out.println("waiverValue :" + waiverValue);

		double WaiverAmount=Double.parseDouble(Waiver_Amount);
		if (WaiverAmount==waiverValue) {
			System.out.println(" Matched ||   Expected  Waiver value is : " + WaiverAmount
					+ "   ||   Actual  Waiver value is : " + waiverValue);
			Extent_pass_New(driver, " Matched ||   Expected  Waiver value is : " + WaiverAmount
					+ "   ||   Actual  Waiver value is : " + waiverValue, test, test1);
		} else {
			System.out.println(" Not Matched ||   Expected  Waiver value is : " + WaiverAmount
					+ "   ||   Actual  Waiver value is : " + waiverValue);
			Extent_fail(driver, " Not Matched ||   Expected Waiver value is : " + WaiverAmount
					+ "   ||   Actual Waiver value is  : " + waiverValue, test, test1);
		}
		}else {
			if (Waiver_Amount.equals(waiver_Value)) {
				System.out.println(" Matched ||   Expected  Waiver value is : " + Waiver_Amount
						+ "   ||   Actual  Waiver value is : " + waiver_Value);
				Extent_pass_New(driver, " Matched ||   Expected  Waiver value is : " + Waiver_Amount
						+ "   ||   Actual  Waiver value is : " + waiver_Value, test, test1);
			} else {
				System.out.println(" Not Matched ||   Expected  Waiver value is : " + Waiver_Amount
						+ "   ||   Actual  Waiver value is : " + waiver_Value);
				Extent_fail(driver, " Not Matched ||   Expected Waiver value is : " + Waiver_Amount
						+ "   ||   Actual Waiver value is  : " + waiver_Value, test, test1);
			}
		}
		Step_Start(9, " select the row in step 8.", test, test1);
		
		
		scrollElementToView(driver, Detention_Container_Grid2_Filter);

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
			List<String> Containers_Select = splitAndExpand(Container_number);
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

		Step_End(10, " click (-)Minus Button and verify the validation", test, test1);

		Step_Start(11, "  Verify the Validation Do you want to remove this row?yes or no", test, test1);

		waitForPopup(driver, popup_Message, Popup);
		String popup_act = getText(driver, popup_Message);

		if (Popup.equals(popup_act)) {
			System.out.println("Matched ||   Expected  popup message is : " + Popup
					+ "   ||   Actual popup message is  : " + popup_act);
			Extent_pass_New(driver, " Matched ||   Expected  popup message is : " + Popup
					+ "   ||   Actual  popup message is : " + popup_act, test, test1);
		} else {
			System.out.println("Not Matched ||   Expected  popup message is : " + Popup
					+ "   ||   Actual  popup message is : " + popup_act);
			Extent_fail(driver, " Not Matched ||   Expected  popup message is : " + Popup
					+ "   ||   Actual  popup message is : " + popup_act, test, test1);
		}

		Step_End(11, " Verify the Validation Do you want to remove this row?yes or no", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
