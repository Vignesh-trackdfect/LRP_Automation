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



public class TC_Detention_Waiver_TS_018 extends Keywords {

	public void Detention_Waiver_TS_018(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_018";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String Bl_Input_Field = Excel_data.get("BL_Number");
		String Container_number_Add = Excel_data.get("Container_number_Add");
		String Waiver_Lumsum_Days_Input = Excel_data.get("Waiver_Lumsum_Days_Input");
		String Pop_Expected = Excel_data.get("Pop_Expected");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String Weiver_For = Excel_data.get("Weiver_For");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

		Step_Start(1, "Open Detention weiver Module", test, test1);
		
		moduleNavigate(driver, Detention_Module);
		Step_End(1, "Open Detention weiver Module", test, test1);


		newButton(driver);
		String Waiveroption = String.format(DW_WaiverOption, Weiver_For);

		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);
		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);
		Step_Start(2, "Click on BL No Search Field", test, test1);
		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		Step_End(2, "Click on BL No Search Field", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		globalValueSearchWindow(driver, BookingSearch_Condition, BookingSearch_Option, Bl_Input_Field, "", "", "", "");

		Step_End(3, "Input your Confirm BL No", test, test1);

		Step_Start(4, " Click on show Button select the Row in Container Section", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);

		waitForElement(driver, DW_Show);
		click(driver, DW_Show);
		Step_End(4, " Click on show Button select the Row in Container Section", test, test1);
		
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
			List<String> Containers_Select = splitAndExpand(Container_number_Add);
			for (String container : Containers_Select) {

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
	
		Step_Start(5, "Select the LP  Radio Button", test, test1);
		scrollUsingElement(driver, Waiver_lumsum_radio_button);
		waitForElement(driver, Waiver_lumsum_radio_button);
		click(driver, Waiver_lumsum_radio_button);
		Step_End(5, "Select the LP  Radio Button", test, test1);
		
		// Add Additional days

			Step_Start(6, "Go to LP Field and enter the LP as   More than Net tariff Amount and 9999", test, test1);
			
			mouseOverToElement(driver, Waiver_lumsum_iput);
			waitForElement(driver, Waiver_lumsum_iput);
			doubleClick(driver, Waiver_lumsum_iput);

			Newclear(driver, Waiver_lumsum_iput);

			sendKeys(driver, Waiver_lumsum_iput, Waiver_Lumsum_Days_Input);

			Step_End(6, "Go to LP Field and enter the LP as   More than Net tariff Amount and 9999", test, test1);

			Step_Start(7, " Click the Plus(+) button", test, test1);

			waitForElement(driver, DW_Add_button);
			click(driver, DW_Add_button);

			Step_End(7, " Click the Plus(+) button", test, test1);

			Step_Start(8, "Verify that system shows the Validation as Expected", test, test1);

			waitForPopup(driver, popup_Message, Pop_Expected);
			String popact = getText(driver, popup_Message);

			if (Pop_Expected.equals(popact)) {
				System.out.println("Matched || Expected popup message was : " + Pop_Expected
						+ " || Actual popup message was : " + popact);
				Extent_pass_New(driver, "Matched || Expected popup message was : " + Pop_Expected
						+ " || Actual popup message was : " + popact, test, test1);
			} else {
				System.out.println("Not Matched || Expected popup message was : " + Pop_Expected
						+ " || Actual popup message was : " + popact);
				Extent_fail(driver, "Not Matched || Expected popup message was : " + Pop_Expected
						+ " || Actual popup message was  : " + popact, test, test1);
			}

			click(driver, popup_Message_Ok_Button);
		
		Step_End(8, "Verify that system shows the Validation as Expected", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}