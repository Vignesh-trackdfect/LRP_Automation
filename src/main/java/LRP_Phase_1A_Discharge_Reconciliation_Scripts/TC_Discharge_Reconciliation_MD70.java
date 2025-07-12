package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD70 extends Keywords{


public void  Discharge_Reconciliation_MD70 (WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) { 

	String testcase_Name = "TC_Discharge_Reconciliation_MD70";

	String username = Excel_data.get("Username");
	String pass_word = Excel_data.get("Password");
	String Dis_Recon_Module = Excel_data.get("Dis_Recon_Module");
	String AgencyUser = Excel_data.get("AgencyUser");
	String Action_By = Excel_data.get("Action_By");
	String NewButton = Excel_data.get("NewButton");
	String SearchButton = Excel_data.get("SearchButton");
	String SaveButton = Excel_data.get("SaveButton");
	String EditButton = Excel_data.get("EditButton");
	String DeleteButton = Excel_data.get("DeleteButton");
	String CancelButton = Excel_data.get("CancelButton");
	String SaveAsButton = Excel_data.get("SaveAsButton");
	String ExportButton = Excel_data.get("ExportButton");
	String PrintButton = Excel_data.get("PrintButton");
	String Move_To_First_Record_Button = Excel_data.get("Move_To_First_Record_Button");
	String Move_To_Previous_Record_Button = Excel_data.get("Move_To_Previous_Record_Button");
	String Move_To_Next_Record_Button = Excel_data.get("Move_To_Next_Record_Button");
	String Move_To_Last_Record_Button = Excel_data.get("Move_To_Last_Record_Button");
	
	
	Extent_Start(testcase_Name , test, test1);
	navigateUrl(driver, url);
	
	// Login to the Application
	LRP_Login(driver, username, pass_word);
			verifyMainMenu(driver);
	
			SwitchProfile(driver, AgencyUser);

	
			Step_Start(1, "Open Discharge reconciliation module", test, test1);
			moduleNavigate(driver, Dis_Recon_Module);
			Step_End(1, "Open Discharge reconciliation module", test, test1);
			Step_Start(2, "Only the  New Button Will be enabled"+ "Clicking on new button", test, test1);
			if (Action_By.equalsIgnoreCase("By Opening module")) {
				Step_Start(3, "By Opening Module", test, test1);
				System.out.println("By Opening module");
				Step_End(2, "Only the  New Button Will be enabled"+ "Clicking on new button", test, test1);
				

			} else if (Action_By.equalsIgnoreCase("By Click New Button")) {
				Step_Start(3, "Click on new button", test, test1);
				System.out.println("By Click New Button");

				newButton(driver);

				Step_End(2, "Only the  New Button Will be enabled"+ "Clicking on new button", test, test1);
				

			}

			else if (Action_By.equalsIgnoreCase("By Click Cancel Button")) {


				newButton(driver);

				Step_Start(3, "Cancel should be enabled all other button disable,\r\n"
						+ "Clicking on Cancel Button,", test, test1);
				waitForElement(driver, cancel_Common_btn);
				click(driver, cancel_Common_btn);
				Step_End(3, "Cancel should be enabled all other button disable,\r\n"
						+ "Clicking on Cancel Button,", test, test1);
				
			}
			Step_Start(4, "New button will be enable all other button are disable.", test, test1);
			if (NewButton.equalsIgnoreCase("Enable")) {

				waitForElement(driver,  NewButton_ToolBar);

				if (isElementEnabled(driver, NewButton_ToolBar)) {
					System.out.println(
							"Pass || Expected result is : New button should be enabled || Actual result is : New button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : New button should be enabled || Actual result is : New button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : New button should be enabled || Actual result is : New button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : New button should be enabled || Actual result is : New button is disabled",
							test, test1);
				}
			} else if (NewButton.equalsIgnoreCase("Disable")) {

				waitForElement(driver, NewButton_ToolBar);

				if (!isElementEnabled(driver, NewButton_ToolBar)) {
					System.out.println(
							"Pass || Expected result is : New button should be disabled || Actual result is : New button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : New button should be disabled || Actual result is : New button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : New button should be disabled || Actual result is : New button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : New button should be disabled || Actual result is : New button is enabled",
							test, test1);
				}

			}

			if (SearchButton.equalsIgnoreCase("Enable")) {

				if (isElementEnabled(driver, SearchButton_Toolbar)) {
					System.out.println(
							"Pass || Expected result is : Search button should be enabled || Actual result is : Search button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : Search button should be enabled || Actual result is : Search button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Search button should be enabled || Actual result is : Search button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : Search button should be enabled || Actual result is : Search button is disabled",
							test, test1);
				}

			} else if (SearchButton.equalsIgnoreCase("Disable")) {

				if (!isElementEnabled(driver, SearchButton_Toolbar)) {

					System.out.println(
							"Pass || Expected result is : Search button should be disabled || Actual result is : Search button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : Search button should be disabled || Actual result is : Search button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Search button should be disabled || Actual result is : Search button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : Search button should be disabled || Actual result is : Search button is enabled",
							test, test1);
				}
			}

			if (SaveButton.equalsIgnoreCase("Enable")) {
				if (isElementEnabled(driver, SaveButton_ToolBar)) {
					System.out.println(
							"Pass || Expected result is : Save button should be enabled || Actual result is : Save button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : Save button should be enabled || Actual result is : Save button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Save button should be enabled || Actual result is : Save button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : Save button should be enabled || Actual result is : Save button is disabled",
							test, test1);
				}
			} else if (SaveButton.equalsIgnoreCase("Disable")) {

				if (!isElementEnabled(driver, SaveButton_ToolBar)) {

					System.out.println(
							"Pass || Expected result is : Save button should be disabled || Actual result is : Save button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : Save button should be disabled || Actual result is : Save button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Save button should be disabled || Actual result is : Save button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : Save button should be disabled || Actual result is : Save button is enabled",
							test, test1);
				}
			}

			if (EditButton.equalsIgnoreCase("Enable")) {
				if (isElementEnabled(driver, Edit_Button_toolBar)) {
					System.out.println(
							"Pass || Expected result is : Edit button should be enabled || Actual result is : Edit button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : Edit button should be enabled || Actual result is : Edit button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Edit button should be enabled || Actual result is : Edit button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : Edit button should be enabled || Actual result is : Edit button is disabled",
							test, test1);
				}
			} else if (EditButton.equalsIgnoreCase("Disable")) {

				if (!isElementEnabled(driver, Edit_Button_toolBar)) {

					System.out.println(
							"Pass || Expected result is : Edit button should be disabled || Actual result is : Edit button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : Edit button should be disabled || Actual result is : Edit button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Edit button should be disabled || Actual result is : Edit button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : Edit button should be disabled || Actual result is : Edit button is enabled",
							test, test1);
				}
			}

			if (DeleteButton.equalsIgnoreCase("Enable")) {

				if (isElementEnabled(driver, Delete_button_toolBar)) {
					System.out.println(
							"Pass || Expected result is : Delete button should be enabled || Actual result is : Delete button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : Delete button should be enabled || Actual result is : Delete button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Delete button should be enabled || Actual result is : Delete button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : Delete button should be enabled || Actual result is : Delete button is disabled",
							test, test1);
				}
			} else if (DeleteButton.equalsIgnoreCase("Disable")) {

				if (!isElementEnabled(driver, Delete_button_toolBar)) {

					System.out.println(
							"Pass || Expected result is : Delete button should be disabled || Actual result is : Delete button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : Delete button should be disabled || Actual result is : Delete button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Delete button should be disabled || Actual result is : Delete button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : Delete button should be disabled || Actual result is : Delete button is enabled",
							test, test1);
				}
			}

			if (CancelButton.equalsIgnoreCase("Enable")) {
				if (isElementEnabled(driver, cancel_Common_btn)) {
					System.out.println(
							"Pass || Expected result is : Cancel button should be enabled || Actual result is : Cancel button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : Cancel button should be enabled || Actual result is : Cancel button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Cancel button should be enabled || Actual result is : Cancel button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : Cancel button should be enabled || Actual result is : Cancel button is disabled",
							test, test1);
				}
			} else if (CancelButton.equalsIgnoreCase("Disable")) {

				if (!isElementEnabled(driver, cancel_Common_btn)) {

					System.out.println(
							"Pass || Expected result is : Cancel button should be disabled || Actual result is : Cancel button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : Cancel button should be disabled || Actual result is : Cancel button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Cancel button should be disabled || Actual result is : Cancel button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : Cancel button should be disabled || Actual result is : Cancel button is enabled",
							test, test1);
				}
			}

			if (SaveAsButton.equalsIgnoreCase("Enable")) {

				if (isElementEnabled(driver, SaveAs_button_toolBar)) {
					System.out.println(
							"Pass || Expected result is : SaveAs button should be enabled || Actual result is : SaveAs button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : SaveAs button should be enabled || Actual result is : SaveAs button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : SaveAs button should be enabled || Actual result is : SaveAs button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : SaveAs button should be enabled || Actual result is : SaveAs button is disabled",
							test, test1);
				}
			} else if (SaveAsButton.equalsIgnoreCase("Disable")) {

				if (!isElementEnabled(driver, SaveAs_button_toolBar)) {

					System.out.println(
							"Pass || Expected result is : SaveAs button should be disabled || Actual result is : SaveAs button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : SaveAs button should be disabled || Actual result is : SaveAs button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : SaveAs button should be disabled || Actual result is : SaveAs button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : SaveAs button should be disabled || Actual result is : SaveAs button is enabled",
							test, test1);
				}
			}

			if (ExportButton.equalsIgnoreCase("Enable")) {

				if (isElementEnabled(driver, Export_button_Discharge)) {
					System.out.println(
							"Pass || Expected result is : Export button should be enabled || Actual result is : Export button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : Export button should be enabled || Actual result is : Export button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Export button should be enabled || Actual result is : Export button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : Export button should be enabled || Actual result is : Export button is disabled",
							test, test1);
				}
			} else if (ExportButton.equalsIgnoreCase("Disable")) {

				if (!isElementEnabled(driver, Export_button_Discharge)) {

					System.out.println(
							"Pass || Expected result is : Export button should be disabled || Actual result is : Export button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : Export button should be disabled || Actual result is : Export button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Export button should be disabled || Actual result is : Export button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : Export button should be disabled || Actual result is : Export button is enabled",
							test, test1);
				}
			}

			if (PrintButton.equalsIgnoreCase("Enable")) {

				if (isElementEnabled(driver, print_Common_btn)) {
					System.out.println(
							"Pass || Expected result is : Print button should be enabled || Actual result is : Print button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : Print button should be enabled || Actual result is : Print button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Print button should be enabled || Actual result is : Print button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : Print button should be enabled || Actual result is : Print button is disabled",
							test, test1);
				}
			} else if (PrintButton.equalsIgnoreCase("Disable")) {

				if (!isElementEnabled(driver, print_Common_btn)) {

					System.out.println(
							"Pass || Expected result is : Print button should be disabled || Actual result is : Print button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : Print button should be disabled || Actual result is : Print button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Print button should be disabled || Actual result is : Print button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : Print button should be disabled || Actual result is : Print button is enabled",
							test, test1);
				}
			}

			if (Move_To_First_Record_Button.equalsIgnoreCase("Enable")) {

				if (isElementEnabled(driver, first_Common_btn)) {
					System.out.println(
							"Pass || Expected result is : Move to first button should be enabled || Actual result is : Move to first button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : Move to first button should be enabled || Actual result is : Move to first button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Move to first button should be enabled || Actual result is : Move to first button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : Move to first button should be enabled || Actual result is : Move to first button is disabled",
							test, test1);
				}
			} else if (Move_To_First_Record_Button.equalsIgnoreCase("Disable")) {

				if (!isElementEnabled(driver, first_Common_btn)) {

					System.out.println(
							"Pass || Expected result is : Move to first button should be disabled || Actual result is : Move to first button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : Move to first button should be disabled || Actual result is : Move to first button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Move to first button should be disabled || Actual result is : Move to first button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : Move to first button should be disabled || Actual result is : Move to first button is enabled",
							test, test1);
				}
			}

			if (Move_To_Previous_Record_Button.equalsIgnoreCase("Enable")) {

				if (isElementEnabled(driver, prev_Common_btn)) {
					System.out.println(
							"Pass || Expected result is : Move to previous button should be enabled || Actual result is : Move to previous button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : Move to previous button should be enabled || Actual result is : Move to previous button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Move to previous button should be enabled || Actual result is : Move to previous button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : Move to previous button should be enabled || Actual result is : Move to previous button is disabled",
							test, test1);
				}
			} else if (Move_To_Previous_Record_Button.equalsIgnoreCase("Disable")) {

				if (!isElementEnabled(driver, prev_Common_btn)) {

					System.out.println(
							"Pass || Expected result is : Move to previous button should be disabled || Actual result is : Move to previous button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : Move to previous button should be disabled || Actual result is : Move to previous button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Move to previous button should be disabled || Actual result is : Move to previous button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : Move to previous button should be disabled || Actual result is : Move to previous button is enabled",
							test, test1);
				}
			}

			if (Move_To_Next_Record_Button.equalsIgnoreCase("Enable")) {

				if (isElementEnabled(driver, next_Common_btn)) {
					System.out.println(
							"Pass || Expected result is : Move to Next button should be enabled || Actual result is : Move to Next button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : Move to Next button should be enabled || Actual result is : Move to Next button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Move to Next button should be enabled || Actual result is : Move to Next button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : Move to Next button should be enabled || Actual result is : Move to Next button is disabled",
							test, test1);
				}
			} else if (Move_To_Next_Record_Button.equalsIgnoreCase("Disable")) {

				if (!isElementEnabled(driver, next_Common_btn)) {

					System.out.println(
							"Pass || Expected result is : Move to Next button should be disabled || Actual result is : Move to Next button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : Move to Next button should be disabled || Actual result is : Move to Next button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Move to Next button should be disabled || Actual result is : Move to Next button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : Move to Next button should be disabled || Actual result is : Move to Next button is enabled",
							test, test1);
				}
			}

			if (Move_To_Last_Record_Button.equalsIgnoreCase("Enable")) {

				if (isElementEnabled(driver, last_Common_btn)) {
					System.out.println(
							"Pass || Expected result is : Move to Last button should be enabled || Actual result is : Move to Last button is enabled");
					Extent_pass(driver,
							"Pass || Expected result is : Move to Last button should be enabled || Actual result is : Move to Last button is enabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Move to Last button should be enabled || Actual result is : Move to Last button is disabled");
					Extent_fail(driver,
							"Fail || Expected result is : Move to Last button should be enabled || Actual result is : Move to Last button is disabled",
							test, test1);
				}
			} else if (Move_To_Last_Record_Button.equalsIgnoreCase("Disable")) {
				if (!isElementEnabled(driver, last_Common_btn)) {

					System.out.println(
							"Pass || Expected result is : Move to Last button should be disabled || Actual result is : Move to Last button is disabled");
					Extent_pass(driver,
							"Pass || Expected result is : Move to Last button should be disabled || Actual result is : Move to Last button is disabled",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : Move to Last button should be disabled || Actual result is : Move to Last button is enabled");
					Extent_fail(driver,
							"Fail || Expected result is : Move to Last button should be disabled || Actual result is : Move to Last button is enabled",
							test, test1);
				}
				Step_Start(4, "New button will be enable all other button are disable.", test, test1);
			
			
		
			
}
			Extent_completed(testcase_Name, test, test1);
}}			
				
				
				
				
