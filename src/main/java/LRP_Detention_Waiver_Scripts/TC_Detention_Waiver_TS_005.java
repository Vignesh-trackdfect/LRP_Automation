package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;



import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_005 extends Keywords {

	public void Detention_Waiver_TS_005(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Detention_Waiver_TS_005";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String dropdownCondition = Excel_data.get("dropdownCondition");
		String BL_Number_Search_Type_DET = Excel_data.get("BL_Number_Search_Type");
		String B_Number_DET = Excel_data.get("BL_Number");
		String Movement_Code = Excel_data.get("Container_Number");
		String Additional_Free_Days = Excel_data.get("Additional _Free_Days");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String WaiverOption = Excel_data.get("Weiver_For");
	

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

		Step_Start(2, "Click on Search", test, test1);

		waitForDisplay(driver, DW_BookingNo_Search);

		if (isElementEnabled(driver, DW_BookingNo_Search)) {

			System.out.println(
					"Pass || Expected result is : BL No Search button should be enabled || Actual result is : BL No Search button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : BL No Search button should be enabled || Actual result is : BL No Search button is enabled",
					test, test1);

			click(driver, DW_BookingNo_Search);
		} else {
			System.out.println(
					"Fail || Expected result is : BL No Search button should be enabled || Actual result is : BL No Search button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : BL No Search button should be enabled || Actual result is : BL No Search button is not enabled",
					test, test1);
		}

		Step_End(2, "Click on Search", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, BL_Number_Search_Type_DET, B_Number_DET, "", "", "", "");

		Step_Start(3, "Click on Show button", test, test1);

		
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
		
waitForElement(driver, DW_Show);
		click(driver, DW_Show);

		Step_End(3, "Click on Show button", test, test1);

		Step_Start(4, "Click on Container checkbox", test, test1);

		List<String> ContainersList = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			mouseOverToElement(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList.add(eletext);
			}
			mouseOverToElement(driver, DW_Select_All_Checkbox);
			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else {
			List<String> Containers_Select = splitAndExpand(Movement_Code);
			waitForElement(driver, Detention_container_Filter);
			click(driver, Detention_container_Filter);
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

	

		Step_End(4, "Click on Container checkbox", test, test1);

		Step_Start(5, "Add additional free days", test, test1);

		isElementEnabled(driver, DW_Additional_Free_Days);

		waitForElement(driver, DW_Additional_Free_Days);

		sendKeys(driver, DW_Additional_Free_Days, Additional_Free_Days);

		click(driver, DW_plus_icon);

		Step_End(5, "Add additional free days", test, test1);

		Step_Start(6, "Get waiver value and  verify that", test, test1);
		
		waitForElement(driver, DW_Waiver_Table_Cell);

		List<WebElement> waiverValueColumn = listOfElements(driver, DW_Waiver_Values_ColumnTable);
		List<String> Act_Waiver_ValuesList = new ArrayList<String>();
		for (WebElement columns : waiverValueColumn) {

			String ColText = columns.getText();
			Act_Waiver_ValuesList.add(ColText);

		}

		for (int i = 0; i < Act_Waiver_ValuesList.size(); i++) {

			String waiverValue = Act_Waiver_ValuesList.get(i);
			double exp_Amount = getNumberValue(Additional_Free_Days);
			double Act_Amount = getNumberValue(waiverValue);
			if (exp_Amount == Act_Amount) {
				System.out.println("Verify that Free time is Entered for Container : " + ContainersList.get(i)+ "  || Expected Free time should be entered as  : " + Additional_Free_Days + " || Actual Free time is entered as : " + waiverValue);
				Extent_pass_New(
						driver, "Verify that Free time is Entered for Container : " + ContainersList.get(i)+ "  || Expected Free time should be entered as  : " + Additional_Free_Days + " || Actual Free time is entered as : " + waiverValue,
						test, test1);
			} else {
				System.out.println("Verify that Free time is Entered for Container : " + ContainersList.get(i)+ "  || Expected Free time should be entered as  : " + Additional_Free_Days + " || Actual Free time is entered as : " + waiverValue);
				Extent_fail(
						driver, "Verify that Free time is Entered for Container : " + ContainersList.get(i)+ "  || Expected Free time should be entered as  : " + Additional_Free_Days + " || Actual Free time is entered as : " + waiverValue,
						test, test1);
			}

		}

		Step_End(6, "Get waiver value and verify that", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
