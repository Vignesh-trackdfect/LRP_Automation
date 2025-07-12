package LRP_Detention_Waiver_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_016B extends Keywords {
	public void Detention_Waiver_TS_016B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_016B";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("agencyUser");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String Booking_number = Excel_data.get("BL_Number");
		String WaiverOption = Excel_data.get("Weiver_For");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Container_number_Add = Excel_data.get("Container_number");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String Waiver_By = Excel_data.get("Waiver_By");
		String Waiver_Lumpsum = Excel_data.get("Waiver_Amount");
		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

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

		scrollElementToView(driver, Detention_container_Filter);
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
			List<String> Containers_Select = splitAndExpand(Container_number_Add);
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
		Step_End(4, "Click on show Button select the Row in Container Section", test, test1);

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
		sendKeys(driver, Input_Wiver, Waiver_Lumpsum);

		Step_Start(9, "select the row in step 8.", test, test1);
		Step_Start(7, "Click the Plus(+) button", test, test1);

		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);

		Step_End(7, "Click the Plus(+) button", test, test1);
			mouseOverToElement(driver, DW_Select_All_Checkbox_Down);
			waitForElement(driver, DW_Select_All_Checkbox_Down);
			click(driver, DW_Select_All_Checkbox_Down);

			Step_End(9, "select the row in step 8.", test, test1);
			Step_Start(10, "click (-)Minus Button and Validation Occqur and Click on Yes in that", test, test1);
			waitForElement(driver, DW_remove_button);
			click(driver, DW_remove_button);
			Step_End(10, "click (-)Minus Button and Validation Occqur and Click on Yes in that", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_Start(11, "Verify that selected Container is removed.", test, test1);
		
			scrollBottom(driver);
			waitForDisplay(driver, DW_Select_Container_down_gird);
			if (!isdisplayed(driver, DW_Select_Container_down_gird)) {
				System.out.println("Expected result : All Cotainers should  be removed || Actual result : All Containers was  removed after clicking remove button ");
				Extent_pass_New(driver,"Expected result : All  Cotainers should  be removed || Actual result : All Containers was  removed after click remove button ",test, test1);
			} else {
				System.out.println("Expected result : All Cotainers should  be removed || Actual result : All Containers was not removed after clicking remove button ");
				Extent_fail(driver, "Expected result : All Cotainers should  be removed || Actual result : All Containers was not removed after click remove button ", test, test1);
			}
		

		Step_End(11, "Verify that selected Container is removed.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
