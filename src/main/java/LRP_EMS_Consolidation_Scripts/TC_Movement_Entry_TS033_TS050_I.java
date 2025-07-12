package LRP_EMS_Consolidation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Movement_Entry_TS033_TS050_I extends Keywords {

	public void movementEntryIntegration(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset) {
		
		String testCaseName33="TC_Movement_Entry_IntegrationTS033";
		String File_Path33 = TestNgXml.getfilePath_FromExecution().get(testCaseName33);
		String URL = TestNgXml.getdatafromExecution().get("TC_Movement_Entry_TS033_TS050_I");
		String Sheet_Name_033 = TestNgXml.getsheetName_FromExecution().get(testCaseName33);
		Map<String, String> data33 = Utils.GetAllData(Sheet_Name_033, testCaseName33,
				"Dataset" + selected_dataset, File_Path33);
		String username = data33.get("Username");
		String password = data33.get("Password");
		
		navigateUrl(driver, URL);

		// Login

			LRP_Login(driver, username, password);
				
		boolean ts33=true;
		if(ts33==true) {
		
			String testCaseName="TC_Movement_Entry_IntegrationTS033";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_033, testCaseName,
					"Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String eqpNum = data.get("EquipmentNo");
			String atleastFourCharPopup = data.get("AtleastFourCharPopup");
			String activityDateSingle = data.get("ActivityDate");
			String activitySearch = data.get("Activity");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			
			Extent_Start(testCaseName, test, test1);

			//// To Validate no of Characters in Movement Entry
			// Home

			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
			
			
//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);
			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}

			Step_Start(2, "Ensure system should validate if user entered only 3 characters & click search icon.", test,test1);
			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, eqpNum);

			if (!activitySearch.equals("")) {
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activitySearch);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			}
			if (!activityDateSingle.equals("")) {
				waitForElement(driver, activeDateInSingle_L);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle);

				} else {
					click(driver, activeDateInSingle_L);

					if (activityDateSingle.contains("-")) {
						String activityDateSingle_1 = activityDateSingle.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDateSingle_1);

					} else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle);

					}
				}
			}
			if (!activityTime_Input1.equals("")) {
				click(driver, activityTime);

				waitForElement(driver, Calender);
				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);
					waitForDisplay(driver, activityTime_Input);
					clearAndType(driver, activityTime_Input, activityTime_Input1);
					System.out.println("activity_Time" + activityTime_Input1);

				}
				click(driver, activityTime_Close);
			} 
			waitForElement(driver, equipmentSearch_Icon);

			click(driver, equipmentSearch_Icon);
			Step_End(2, "Ensure system should validate if user entered only 3 characters & click search icon.", test,test1);

			Step_Start(3, "Ensure that system should validate as 'Enter atleast four characters of Equipment Number'.",test, test1);
			
			waitForPopup(driver, Popup_Message, atleastFourCharPopup);

			String actualPopup = getText(driver, Popup_Message);

			if (actualPopup.equals(atleastFourCharPopup)) {
				System.out.println("Matched || " +atleastFourCharPopup+" popup is displayed"+ " || Expected Popup : " + atleastFourCharPopup + " || Actual Popup : "
						+ actualPopup);
				Extent_pass_New(driver, "Matched || "+atleastFourCharPopup+" popup is displayed" + " || Expected Popup : " + atleastFourCharPopup + " || ActualPopup : "
						+ actualPopup, test, test1);
			} else {
				System.out.println("Not matched || "+atleastFourCharPopup + " popup is not displayed" + " || Expected Popup : " + atleastFourCharPopup
						+ " || Actual Value  is : " + actualPopup);
				Extent_fail(driver, "Not matched || "+atleastFourCharPopup + " popup is not displayed" + " || Expected Popup : " + atleastFourCharPopup
						+ " || Actual Popup : " + actualPopup, test, test1);
			}

			Step_End(3, "Ensure that system should validate as 'Enter atleast four characters of Equipment Number'.", test,test1);

			Extent_completed(testCaseName, test, test1);
			
		scrollTop(driver); waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		}

		int ts34=34;

		if(ts34==34) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS034";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_034 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_034, testCaseName,
					"Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String equipmentNum = data.get("EquipmentNum");
			String selectActivity = data.get("SelectActivity");

			
			String activityDateSingle34 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			
			Extent_Start(testCaseName, test, test1);
			
			//// To Validate for Blank Activity
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Movement Entry
			Extent_call(test, test1, "Navigating to Movement Entry Page");
			
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}
			
			
			clearAndType(driver, equipmentNoSearchField_L, equipmentNum);
			
			Step_Start(2, "selecting the date", test, test1);
			
			if (!activityDateSingle34.equals("")) {
				waitForElement(driver, activeDateInSingle_L);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle34);

				} else {
					click(driver, activeDateInSingle_L);

					if (activityDateSingle34.contains("-")) {
						String activityDateSingle34_1 = activityDateSingle34.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDateSingle34_1);

					} else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle34);

					}
				}
			}
			if (!activityTime_Input1.equals("")) {
				click(driver, activityTime);

				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);

					clearAndType(driver, activityTime_Input, activityTime_Input1);
					System.out.println("activity_Time" + activityTime_Input1);

				}
				click(driver, activityTime_Close);
			} 
			Step_End(2, "selecting the date", test, test1);
			Step_Start(3, "clicking the show input field by giving blank activity field", test, test1);

			waitForElement(driver, showInputFieldsButton_L);
			click(driver, showInputFieldsButton_L);
			Step_End(3, "clicking the show input field by giving blank activity field", test, test1);

			Step_Start(4, "Ensure that system should validate as 'Select Activity'.", test, test1);
			
			waitForPopup(driver, Popup_Message, selectActivity);

			String actualSelectActivityPopup = getText(driver, Popup_Message);
			if (actualSelectActivityPopup.equals(selectActivity)) {
				System.out.println("Matched || "+selectActivity + " popup is displayed" + " || Expected Popup : " + selectActivity + " || Actual Popup : "
						+ actualSelectActivityPopup);
				Extent_pass_New(driver, "Matched || "+selectActivity + " popup is displayed" + " || Expected Popup : " + selectActivity + " || Actual Popup : "
						+ actualSelectActivityPopup, test, test1);
			} else {
				System.out.println("Not matched || "+selectActivity + " popup is not displayed" + " || Expected Popup : " + selectActivity + " || Actual Popup : "
						+ actualSelectActivityPopup);
				Extent_fail(driver, "Not matched || "+selectActivity + " popup is not displayed" + " || Expected Popup : " + selectActivity + " || Actual Popup : "
						+ actualSelectActivityPopup, test, test1);
			}

			Step_End(4, "Ensure that system should validate as 'Select Activity'.", test, test1);
			Extent_completed(testCaseName, test, test1);

			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		
		int ts35=35;
		if(ts35==35) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS035";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_035 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_035, testCaseName,
					"Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String equipmentNum35 = data.get("EquipmentNum");
			String activitySearch = data.get("Activity");
			String activityDateSingle = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			
			Extent_Start(testCaseName, test, test1);

			// To Check Validation for check digit in single entry

			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}
			
			Step_Start(2, "Ensure system should allow user to enter container no correctly in equipment field", test,test1);

			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, equipmentNum35);
			
			Step_End(2, "Ensure system should allow user to enter container no correctly in equipment field", test, test1);
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activitySearch);
			enter(driver);
			
			if (!activityDateSingle.equals("")) {
				waitForElement(driver, activeDateInSingle_L);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle);

				} else {
					click(driver, activeDateInSingle_L);

					if (activityDateSingle.contains("-")) {
						String activityDateSingle_1 = activityDateSingle.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDateSingle_1);

					} else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle);

					}
				}
			}
			if (!activityTime_Input1.equals("")) {
				click(driver, activityTime);

				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);

					clearAndType(driver, activityTime_Input, activityTime_Input1);
					System.out.println("activity_Time" + activityTime_Input1);

				}
				click(driver, activityTime_Close);
			} 
			
			Step_Start(3, "Ensure that system should validate if user clicks show input fields after giving container no",
					test, test1);
			
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);
			
			
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				Step_End(3, "Ensure that system should validate if user clicks show input fields after giving container no",
						test, test1);

				Step_Start(4,
						"Ensure that system should not proceed further if user clicked No from above confirmation message",
						test, test1);
				Extent_call(test, test1, "clicking the NO option");
				click(driver, popup_Message_No_Button);
				Extent_call(test, test1, "Verify the input field display");

				waitForDisplay(driver, showInputFieldFrame_L);
				if (!isdisplayed(driver, showInputFieldFrame_L)) {
					System.out.println("Matched || Expected : Show input field frame should not be displayed || Actual : Show input field frame is not displayed");
					Extent_pass_New(driver, "Matched || Expected : Show input field frame should not be displayed || Actual : Show input field frame is not displayed", test, test1);
				} else {
					System.out.println("Not Matched || Expected : Show input field frame should not be displayed || Actual : Show input field frame is displayed");
					Extent_fail(driver, "Not Matched || Expected : Show input field frame should not be displayed || Actual : Show input field frame is displayed", test, test1);
				}
			} 

			
			Step_End(4, "Ensure that system should not proceed further if user clicked No from above confirmation message",
					test, test1);
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);
			
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				
				Step_Start(5, " Ensure that system should proceed further if user clicks Yes on the confirmation message",
						test, test1);
				Extent_call(test, test1, "clicking the YES option in the popup");
				click(driver, popup_Message_Yes_Button);

				Step_End(5, " Ensure that system should proceed further if user clicks Yes on the confirmation message",
						test, test1);

				Extent_call(test, test1, "Verify the input field display");
				waitForDisplay(driver, showInputFieldFrame_L);
				if (isdisplayed(driver, showInputFieldFrame_L)) {
					System.out.println("Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed");
					Extent_pass_New(driver, "Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed", test, test1);
				} else {
					System.out.println("Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed");
					Extent_fail(driver, "Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed", test, test1);
				}
			} 

			Extent_completed(testCaseName, test, test1);
			
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		
		int ts36=36;
		if(ts36==36) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS036";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_036 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_036, testCaseName, "Dataset"+selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String invalidEqpNo = data.get("InvalidEqpNumber");
			String invalidEqpNoPopup = data.get("InvalidEquipmentNumberPopup");
			String activitySearch36 = data.get("Activity");
			String activityDateSingle = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			
			Extent_Start(testCaseName, test, test1);

			// To Check Validation if invalid format is given in Equipment no for single
			// entry
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}

			
	Step_Start(2, "Ensure system should validate if user given invalid format characters in equipment no field", test, test1);
			
			clearAndType(driver, equipmentNoSearchField_L, invalidEqpNo);
			
	Step_End(2, "Ensure system should validate if user given invalid format characters in equipment no field", test, test1);
			
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activitySearch36);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);

			
				if (!activityDateSingle.equals("")) {
					waitForElement(driver, activeDateInSingle_L);

					if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateInSingle_L, activityDateSingle);

					} else {
						click(driver, activeDateInSingle_L);

						if (activityDateSingle.contains("-")) {
							String activityDateSingle_1 = activityDateSingle.replace("-", "/");
							clearAndType(driver, activeDateInSingle_L, activityDateSingle_1);

						} else {
							clearAndType(driver, activeDateInSingle_L, activityDateSingle);

						}
					}
				}
				if (!activityTime_Input1.equals("")) {
					click(driver, activityTime);

					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);

						clearAndType(driver, activityTime_Input, activityTime_Input1);
						System.out.println("activity_Time" + activityTime_Input1);

					}
					click(driver, activityTime_Close);
				} 
			
			Step_Start(3, "clicking the show input field", test, test1);
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);
			Step_End(3, "clicking the show input field", test, test1);
			
			Step_Start(4, "Ensure that system should validate as 'Invalid Equipment Number. Check Digit is not applicable' when clicked show input fields after providing incorrect container no", test, test1);

			waitForPopup(driver, Popup_Message, invalidEqpNoPopup);

			String actualInvalidEqpNumPopup = getText(driver, Popup_Message);
			if (actualInvalidEqpNumPopup.equals(invalidEqpNoPopup)) {
				System.out.println("Matched || "+invalidEqpNoPopup + " popup is displayed ||" + " Expected Popup : " + invalidEqpNoPopup + " || Actual Popup : "
						+ actualInvalidEqpNumPopup);
				Extent_pass_New(driver, "Matched || "+invalidEqpNoPopup + " popup is displayed ||" + " Expected Popup : " + invalidEqpNoPopup + " || ActualPopup : "
						+ actualInvalidEqpNumPopup, test, test1);
			} else {
				System.out.println("Not matched || "+invalidEqpNoPopup + " popup is not displayed ||" + " Expected Popup : " + invalidEqpNoPopup
						+ " || Actual Popup  is : " + actualInvalidEqpNumPopup);
				Extent_fail(driver, "Not matched || "+invalidEqpNoPopup + " popup is not displayed ||" + " Expected Popup : " + invalidEqpNoPopup
						+ " || Actual Popup : " + actualInvalidEqpNumPopup, test, test1);
			}
			Step_End(4, "Ensure that system should validate as 'Invalid Equipment Number. Check Digit is not applicable' when clicked show input fields after providing incorrect container no", test, test1);
		
			Extent_completed(testCaseName, test, test1);
			
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		
		int ts37=37;
		
		if(ts37==37) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS037";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_037 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_037, testCaseName,
					"Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String activitySearch37 = data.get("Activity");
			String eqpNumber = data.get("EquipmentNo1");
			String invalidPortCodeError = data.get("InvalidPortCodeError");
			String invalidSizeTypeError = data.get("InvalidSize/TypeError");
			String activityDateSingle37 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			

			Extent_Start(testCaseName, test, test1);

			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}

			
			Step_Start(2,"Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields",test, test1);
			
			Extent_call(test, test1, "giving valid container number");
			waitForElement(driver, equipmentNoSearchField_L);
			clearAndType(driver, equipmentNoSearchField_L, eqpNumber);
			
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activitySearch37);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			if (!activityDateSingle37.equals("")) {
				waitForElement(driver, activeDateInSingle_L);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle37);

				} else {
					click(driver, activeDateInSingle_L);

					if (activityDateSingle37.contains("-")) {
						String activityDateSingle37_1 = activityDateSingle37.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDateSingle37_1);

					} else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle37);

					}
				}
			}
			Extent_call(test, test1, "Entering the time data");
			if (!activityTime_Input1.equals("")) {
				click(driver, activityTime);

				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);

					clearAndType(driver, activityTime_Input, activityTime_Input1);
					System.out.println("activity_Time" + activityTime_Input1);

				}
				click(driver, activityTime_Close);
			} 
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);
			Step_End(2,
					"Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields",
					test, test1);
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);

				waitForDisplay(driver, showInputFieldFrame_L);
				if (isdisplayed(driver, showInputFieldFrame_L)) {
					System.out.println("Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed");
					Extent_pass_New(driver, "Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed", test, test1);
				} else {
					System.out.println("Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed");
					Extent_fail(driver, "Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed", test, test1);
				}
			} 

			Step_Start(3,
					"Ensure that system should validate if user provide incorrect location & terminal which is not mapped in given reference",
					test, test1);
			
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);
			
			Step_End(3,
					"Ensure that system should validate if user provide incorrect location & terminal which is not mapped in given reference",
					test, test1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_Start(4,
					"Ensure that system should validate as 'Invalid PortCode for this Reference No and Invalid size type for this Reference No",
					test, test1);
			waitForElement(driver, errorRecordsFrame_L);

				String actualPortCodeError = getText(driver, error_Invalid_PortCode);
				String actualSizeTypeError = getText(driver, error_Invalid_size_type);

				if (actualPortCodeError.equalsIgnoreCase(invalidPortCodeError)) {
					System.out.println("Matched || "+invalidPortCodeError + " Error is displayed ||" + " Expected Message : " + invalidPortCodeError
							+ " || Actual Message : " + actualPortCodeError);
					Extent_pass_New(driver, "Matched || "+invalidPortCodeError + " Error is displayed ||" + " Expected Message : " + invalidPortCodeError
							+ " || Actual Message : " + actualPortCodeError, test, test1);
				} else {
					System.out.println("Not matched || "+invalidPortCodeError + " Error is not displayed ||" + " Expected Message : " + invalidPortCodeError
							+ " || Actual Message : " + actualPortCodeError);
					Extent_fail(driver, "Not matched || "+invalidPortCodeError + " Error is not displayed ||" + " Expected Message : " + invalidPortCodeError
							+ " || Actual Message : " + actualPortCodeError, test, test1);
				}
				Extent_call(test, test1, "verifying Invalid size/type for this Reference No'.");
				if (actualSizeTypeError.equalsIgnoreCase(invalidSizeTypeError)) {
					System.out.println("Matched || "+invalidSizeTypeError + " Error is displayed ||" + " Expected Message : " + invalidSizeTypeError
							+ " || Actual Message : " + actualSizeTypeError);
					Extent_pass_New(driver, "Matched || "+invalidSizeTypeError + " Error is displayed ||" + " Expected Message : " + invalidSizeTypeError
							+ " || Actual Message : " + actualSizeTypeError, test, test1);
				} else {
					System.out.println("Not matched || "+invalidSizeTypeError + " Error is not displayed ||" + " Expected Message : " + invalidSizeTypeError
							+ " || Actual Message : " + actualSizeTypeError);
					Extent_fail(driver, "Not matched || "+invalidSizeTypeError + " Error is not displayed ||" + " Expected Message : " + invalidSizeTypeError
							+ " || Actual Message : " + actualSizeTypeError, test, test1);
				}
				click(driver, okButtonErrorFrame_L);
			Step_End(4,
					"Ensure that system should validate as 'Invalid PortCode for this Reference No and Invalid size type for this Reference No",
					test, test1);

			Extent_completed(testCaseName, test, test1);

			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			
		}
		
		int ts38=38;
		if(ts38==38) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS038";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_038 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_038, testCaseName,
					"Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String eqpNumber38 = data.get("EquipmentNo1");
			String activitySearch38 = data.get("Activity");
			String invalidReferenceError = data.get("InvalidReferenceError");
			String activityDateSingle38 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			
			Extent_Start(testCaseName, test, test1);


			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}
			
			Step_Start(2,
					"Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields",
					test, test1);
			waitForElement(driver, equipmentNoSearchField_L);
			clearAndType(driver, equipmentNoSearchField_L, eqpNumber38);
			
			
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activitySearch38);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			if (!activityDateSingle38.equals("")) {
				waitForElement(driver, activeDateInSingle_L);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle38);

				} else {
					click(driver, activeDateInSingle_L);

					if (activityDateSingle38.contains("-")) {
						String activityDateSingle38_1 = activityDateSingle38.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDateSingle38_1);

					} else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle38);

					}
				}
			}
			if (!activityTime_Input1.equals("")) {
				click(driver, activityTime);

				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);

					clearAndType(driver, activityTime_Input, activityTime_Input1);
					System.out.println("activity_Time" + activityTime_Input1);

				}
				click(driver, activityTime_Close);
			} 
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);
			Step_End(2,
					"Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields",
					test, test1);
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);

				waitForDisplay(driver, showInputFieldFrame_L);
				if (isdisplayed(driver, showInputFieldFrame_L)) {
					System.out.println("Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed");
					Extent_pass_New(driver, "Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed", test, test1);
				} else {
					System.out.println("Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed");
					Extent_fail(driver, "Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed", test, test1);
				}
			}
			
			Step_Start(3, "Ensure that system should allow user to give valid location & terminal", test, test1);
			Step_Start(4, " Ensure that system should validate if user provide incorrect release ref", test, test1);

			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);
			
			Step_End(3, "Ensure that system should allow user to give valid location & terminal", test, test1);
			Step_End(4, " Ensure that system should validate if user provide incorrect release ref", test, test1);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForElement(driver, errorRecordsFrame_L);

				String actualRefernceNumError = getText(driver, error_Invalid_Reference);
				Step_Start(5, "Ensure that system should validate as 'INVALID REFERENCE NO'", test, test1);
				if (actualRefernceNumError.equalsIgnoreCase(invalidReferenceError)) {
					System.out.println("Matched || "+invalidReferenceError + " Error is displayed ||" + " Expected Popup is : " + invalidReferenceError
							+ " || Actual Popup is : " + actualRefernceNumError);
					Extent_pass_New(driver, "Matched || "+invalidReferenceError + " Error is displayed ||" + " Expected Popup is : " + invalidReferenceError
							+ " || Actual Popup is : " + actualRefernceNumError, test, test1);
					click(driver, okButtonErrorFrame_L);

				} else {
					System.out.println("Not matched || "+invalidReferenceError + " Error is not displayed ||" + " Expected Popup is : " + invalidReferenceError
							+ " || Actual Popup  is : " + actualRefernceNumError);
					Extent_fail(driver, "Not matched || "+invalidReferenceError + " Error is not displayed ||" + " Expected Popup is : " + invalidReferenceError
							+ " || Actual Popup is : " + actualRefernceNumError, test, test1);
				}
				Step_End(5, "Ensure that system should validate as 'INVALID REFERENCE NO'", test, test1);

			Extent_completed(testCaseName, test, test1);
			
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		
		int ts39=39;
		if(ts39==39) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS039";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_039 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_039, testCaseName,
					"Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String eqpNumber39 = data.get("EquipmentNo1");
			String activitySearch39 = data.get("Activity");
			String invalidSizeTypeErrorMes = data.get("InvalidSizeTypeError");
			
			String activityDateSingle39 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");


			Extent_Start(testCaseName, test, test1);

			
			//// To validate with incorrect size type
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

			
//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}
			
			Step_Start(2,
					"Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields",
					test, test1);
			waitForElement(driver, equipmentNoSearchField_L);
			clearAndType(driver, equipmentNoSearchField_L, eqpNumber39);
			
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activitySearch39);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			if (!activityDateSingle39.equals("")) {
				waitForElement(driver, activeDateInSingle_L);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle39);

				} else {
					click(driver, activeDateInSingle_L);

					if (activityDateSingle39.contains("-")) {
						String activityDateSingle39_1 = activityDateSingle39.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDateSingle39_1);

					} else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle39);

					}
				}
			}
			if (!activityTime_Input1.equals("")) {
				click(driver, activityTime);

				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);

					clearAndType(driver, activityTime_Input, activityTime_Input1);
					System.out.println("activity_Time" + activityTime_Input1);

				}
				click(driver, activityTime_Close);
			}
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);

			Step_End(2,
					"Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields",
					test, test1);
			Step_Start(3, " Ensure that system should allow user to give valid location & terminal", test, test1);
			Step_Start(4, " Ensure that system should allow to provide valid release ref", test, test1);

			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);

			Step_End(3, " Ensure that system should allow user to give valid location & terminal", test, test1);

			Step_End(4, " Ensure that system should allow to provide valid release ref", test, test1);

			Step_Start(5,
					"Ensure that system should validate if user provide incorrect size type which is not defined in given release ref",
					test, test1);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForElement(driver, errorRecordsFrame_L);

				String actualSizeTypeError = getText(driver, error_Invalid_size_type);
				Extent_call(test, test1, "Comparing the actual and expected messages below:-");

				if (actualSizeTypeError.equalsIgnoreCase(invalidSizeTypeErrorMes)) {
					System.out.println("Matched || "+invalidSizeTypeErrorMes + " Error is displayed ||" + " Expected Message is : " + invalidSizeTypeErrorMes
							+ " || Actual Message is : " + actualSizeTypeError);
					Extent_pass_New(driver, "Matched || "+invalidSizeTypeErrorMes + " Error is displayed ||" + " Expected Message is : " + invalidSizeTypeErrorMes
							+ " || Actual Message is : " + actualSizeTypeError, test, test1);
					click(driver, okButtonErrorFrame_L);
				} else {
					System.out.println("Not matched || "+invalidSizeTypeErrorMes + " Error is not displayed ||" + " Expected Message is : " + invalidSizeTypeErrorMes
							+ " || Actual Message  is : " + actualSizeTypeError);
					Extent_fail(driver, "Not matched || "+invalidSizeTypeErrorMes + " Error is not displayed ||" + " Expected Message is : " + invalidSizeTypeErrorMes
							+ " || Actual Message is : " + actualSizeTypeError, test, test1);
				}
				Step_End(5,
						"Ensure that system should validate if user provide incorrect size type which is not defined in given release ref",
						test, test1);

			Extent_completed(testCaseName, test, test1);
			
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		
		int ts40=40;
		
		if(ts40==40) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS040";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_040 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_040, testCaseName,
					"Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String eqpNumber40 = data.get("EquipmentNo1");
			String activitySearch40 = data.get("Activity");
			String activityPlacePopup = data.get("ActivityPlacePopup");
			
			String activityDateSingle40 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			String Terminal_Input = data.get("Terminal_Input");

			Extent_Start(testCaseName, test, test1);


			//// To validate with blank in location field
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}
			
			
			Step_Start(2,
					"Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields",
					test, test1);
			waitForElement(driver, equipmentNoSearchField_L);
			clearAndType(driver, equipmentNoSearchField_L, eqpNumber40);
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activitySearch40);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);

			if (!activityDateSingle40.equals("")) {
				waitForElement(driver, activeDateInSingle_L);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle40);

				} else {
					click(driver, activeDateInSingle_L);

					if (activityDateSingle40.contains("-")) {
						String activityDateSingle40_1 = activityDateSingle40.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDateSingle40_1);

					} else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle40);

					}
				}
			}
			if (!activityTime_Input1.equals("")) {
				click(driver, activityTime);

				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);

					clearAndType(driver, activityTime_Input, activityTime_Input1);
					System.out.println("activity_Time" + activityTime_Input1);

				}
				click(driver, activityTime_Close);
			} 
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);
			Step_End(2,
					"Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields",
					test, test1);

			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);

				waitForDisplay(driver, showInputFieldFrame_L);
				if (isdisplayed(driver, showInputFieldFrame_L)) {
					System.out.println("Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed");
					Extent_pass_New(driver, "Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed", test, test1);
				} else {
					System.out.println("Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed");
					Extent_fail(driver, "Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed", test, test1);
				}
			}
			
			Step_Start(3, "Ensure that system should validate if user leave blank for location then try save", test, test1);

			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);

			scrollElementToCenter(driver, depot_SearchButton_ME);
			
			waitForElement(driver, term_Depot_Textfield_ME);
			Newclear(driver, term_Depot_Textfield_ME);
			waitForDisplay(driver, term_Depot_Textfield_ME);
			sendKeys(driver, term_Depot_Textfield_ME, Terminal_Input);
			waitForDisplay(driver, autoCompleteValue_ME);
			enter(driver);
			
			Step_End(3, "Ensure that system should validate if user leave blank for location then try save", test, test1);
			Step_Start(4,"Ensure that system should validate as 'Activity Place must be entered'.",test, test1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, Popup_Message, activityPlacePopup);
			if (isdisplayed(driver, Popup_Message)) {

				String actualActivityPlacePopup = getText(driver, Popup_Message);

				if (actualActivityPlacePopup.equals(activityPlacePopup)) {
					System.out.println("Matched || "+activityPlacePopup + " popup is displayed ||" + " Expected Popup is : " + activityPlacePopup
							+ " || Actual Popup is : " + actualActivityPlacePopup);
					Extent_pass_New(driver, "Matched || "+activityPlacePopup + " popup is displayed ||" + " Expected Popup is : " + activityPlacePopup
							+ " || Actual Popup is : " + actualActivityPlacePopup, test, test1);
				} else {
					System.out.println("Not matched || "+activityPlacePopup + " popup is not displayed ||" + " Expected Popup is : " + activityPlacePopup
							+ " || Actual Popup  is : "+activityPlacePopup + " popup is not displayed ||" + actualActivityPlacePopup);
					Extent_fail(driver, "Not matched || " + " Expected Popup is : " + activityPlacePopup
							+ " || Actual Popup is : " + actualActivityPlacePopup, test, test1);
				}

			}
			Step_End(4, "Ensure that system should validate as 'Activity Place must be entered'.", test, test1);
			Extent_completed(testCaseName, test, test1);
			
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		
		int ts41=41;
		if(ts41==41) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS041";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testCaseName, "Dataset"+selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String bookingNumberMustPopup = data.get("BookingNumberMustPopup");
			String activitySNTS = data.get("ActivitySNTS");
			String activityDate = data.get("ActivityDate");
			String datePicker = data.get("DatePicker");
			String activityTime_Input1 = data.get("ActivityTime");
			
			
			Extent_Start(testCaseName, test, test1);
			
			
//			Module Search
			moduleNavigate(driver, moduleName);

			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}

			// Multiple Equipment Entry
	Step_Start(1, "Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields", test, test1);

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);
			
				waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, activitySNTS);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				if(!activityDate.equals("")) {
				waitForElement(driver, activeDateField_L);
				
				if(datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateField_L, activityDate);
		
				}else {
					click(driver, activeDateField_L);

					if(activityDate.contains("-")) {
						String activityDate_1=activityDate.replace("-", "/");
						clearAndType(driver, activeDateField_L, activityDate_1);
						
					}else {
					clearAndType(driver, activeDateField_L, activityDate);
					
					}		
				}
				}
			

				if (!activityTime_Input1.equals("")) {
					
					click(driver, activityTimeMultiple);

					
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);
						
							clearAndType(driver, activityTime_Input, activityTime_Input1);
							System.out.println("activity_Time" + activityTime_Input1);
						
					}
					
					click(driver, activityTime_Close);
				}

				waitForElement(driver, showInputButton);
				click(driver, showInputButton);

				Step_End(1, "Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields", test, test1);
				Step_Start(2, "Ensure that system should allow to enter valid location & terminal for SNTS move", test, test1);
				
				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);
				

				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);
			
				Step_End(2, "Ensure that system should allow to enter valid location & terminal for SNTS move", test, test1);
				Step_Start(3, "Ensure that system should validate if user try to save SNTS move by giving blank in booking no field", test, test1);
				Step_Start(4, " Ensure that system should validate as 'Booking Number must be entered'", test, test1);

			waitForPopup(driver, Popup_Message, bookingNumberMustPopup);

				String actualBookingMustPopup = getText(driver, Popup_Message);

				if (actualBookingMustPopup.equals(bookingNumberMustPopup)) {
					System.out.println("Matched || " +bookingNumberMustPopup + " popup is displayed ||"+ " Expected Popup is : " + bookingNumberMustPopup
							+ " || Actual Popup is : " + actualBookingMustPopup);
					Extent_pass_New(driver, "Matched || " +bookingNumberMustPopup + " popup is displayed ||"+ " Expected Popup is : " + bookingNumberMustPopup
							+ " || Actual Popup is : " + actualBookingMustPopup, test, test1);
				} else {
					System.out.println("Not matched || "+bookingNumberMustPopup + " popup is not displayed ||" + " Expected Popup is : " + bookingNumberMustPopup
							+ " || Actual Popup  is : " + actualBookingMustPopup);
					Extent_fail(driver, "Not matched || "+bookingNumberMustPopup + " popup is not displayed ||" + " Expected Popup is : " + bookingNumberMustPopup
							+ " || Actual Popup is : " + actualBookingMustPopup, test, test1);
				}
				Step_End(3, "Ensure that system should validate if user try to save SNTS move by giving blank in booking no field", test, test1);

			Step_End(4, " Ensure that system should validate as 'Booking Number must be entered'", test, test1);
			Extent_completed(testCaseName, test, test1);
			
			
			scrollTop(driver); scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		
		int ts42=42;
		
		if(ts42==42) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS042";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_042 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_042, testCaseName,
					"Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String ctrDuplicatedPopup = data.get("CTRDuplicated");
			String savedEqpNumber = data.get("SavedEqpNumber");
			String activitySearch42 = data.get("Activity");
			String datePicker = data.get("DatePicker");
			
			String activityDateSingle42 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String showAllMoves = data.get("ShowAllMoves");

			Extent_Start(testCaseName, test, test1);

			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);
			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}

			waitForElement(driver, equipmentNoSearchField_L);
			clearAndType(driver, equipmentNoSearchField_L, savedEqpNumber);
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activitySearch42);
			waitForDisplay(driver, autoCompleteValue_ME);
			enter(driver);

			Step_Start(2,
					" Ensure that system should validate when user try to save multiple move in same acitivty date & time",
					test, test1);
			if (!activityDateSingle42.equals("")) {
				waitForElement(driver, activeDateInSingle_L);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle42);

				} else {
					click(driver, activeDateInSingle_L);

					if (activityDateSingle42.contains("-")) {
						String activityDateSingle42_1 = activityDateSingle42.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDateSingle42_1);

					} else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle42);

					}
				}
			}
			Extent_call(test, test1, "Entering the time data");
			if (!activityTime_Input1.equals("")) {
				click(driver, activityTime);

				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);

					clearAndType(driver, activityTime_Input, activityTime_Input1);
					System.out.println("activity_Time" + activityTime_Input1);

				}
				click(driver, activityTime_Close);
			} 
			
			Step_End(2,
					" Ensure that system should validate when user try to save multiple move in same acitivty date & time",
					test, test1);

			Extent_call(test, test1, "Clicking on show input field");
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);
			Step_Start(3,
					"Ensure that system should validate as 'CTR has duplicated date-time activities' when user click on show input fields",
					test, test1);
			waitForPopup(driver, Popup_Message, ctrDuplicatedPopup);

				String actualCTRPopup = getText(driver, Popup_Message);
				Extent_call(test, test1, "Comparing the actual and expected popups");
				if (actualCTRPopup.equals(ctrDuplicatedPopup)) {
					System.out.println("Matched || " +ctrDuplicatedPopup + " popup is displayed ||"+ " Expected Popup is : " + ctrDuplicatedPopup
							+ " || Actual Popup is : " + actualCTRPopup);
					Extent_pass_New(driver, "Matched || " +ctrDuplicatedPopup + " popup is displayed ||"+ " Expected Popup is : " + ctrDuplicatedPopup
							+ " || Actual Popup is : " + actualCTRPopup, test, test1);
				} else {
					System.out.println("Not matched || "+ctrDuplicatedPopup + " popup is not displayed ||" + " Expected Popup is : " + ctrDuplicatedPopup
							+ " || Actual Popup  is : " + actualCTRPopup);
					Extent_fail(driver, "Not matched || " +ctrDuplicatedPopup + " popup is not displayed ||"+ " Expected Popup is : " + ctrDuplicatedPopup
							+ " || Actual Popup is : " + actualCTRPopup, test, test1);
				}
				Step_End(3,
						"Ensure that system should validate as 'CTR has duplicated date-time activities' when user click on show input fields",
						test, test1);

			waitForElement(driver, showAllMoves_CheckBox);
			checkBox(driver, showAllMoves_CheckBox, showAllMoves);

			Extent_completed(testCaseName, test, test1);

			
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			
		}
		
		int ts43=43;
		
		if(ts43==43) {
			
			String testcase_Name = "TC_Movement_Entry_Integration_TS043";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data43 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String moduleName = data43.get("ModuleMovementEntry");
			String savedEqpNumber43 = data43.get("SavedEqpNumber");
			String invalidSubSequentPopup = data43.get("InvalidSubSequentPopup");
			String invalidActivity = data43.get("InvalidActivity");
			String activityDateSingle43 = data43.get("ActivityDate");
			String activityTime_Input1 = data43.get("ActivityTime");
			String datePicker = data43.get("DatePicker");
			String showAllMoves = data43.get("ShowAllMoves");

			Extent_Start(testcase_Name, test, test1);

			// To validate if user try to proceed with in subsequent move
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}
		
			Step_Start(2, "Ensure that system should allow user to enter valid container no in movement entry", test, test1);

			waitForElement(driver, equipmentNoSearchField_L);
			clearAndType(driver, equipmentNoSearchField_L, savedEqpNumber43);

			Step_End(2, "Ensure that system should allow user to enter valid container no in movement entry", test, test1);
			Step_Start(3, "Ensure that system should validate when user try to enter incorrect next sequence move", test, test1);

			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, invalidActivity);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			Step_End(3, "Ensure that system should validate when user try to enter incorrect next sequence move", test, test1);

			Extent_call(test, test1, "Entering the date");
			if (!activityDateSingle43.equals("")) {
				waitForElement(driver, activeDateInSingle_L);

				if(datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle43);
					}else {
						click(driver, activeDateInSingle_L);

						if(activityDateSingle43.contains("-")) {
							String activityDateSingle43_1=activityDateSingle43.replace("-", "/");
							clearAndType(driver, activeDateInSingle_L, activityDateSingle43_1);

						}else {
							clearAndType(driver, activeDateInSingle_L, activityDateSingle43);

						}		
					}
			}
			if (!activityTime_Input1.equals("")) {
				click(driver, activityTime);

				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);

					clearAndType(driver, activityTime_Input, activityTime_Input1);
					System.out.println("activity_Time" + activityTime_Input1);

				}
				click(driver, activityTime_Close);
			} 


			Extent_call(test, test1, "clicking on show input");
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);
			
			

			Step_Start(4, "Ensure that system should validate as 'Invalid subsequent move. Next possible movements are' with next possible moves due to move not mapped in sequence group", test, test1);
			
			waitForPopup(driver, popup_Message, invalidSubSequentPopup);
				String actualInvalidSubSeqPopup = getText(driver, popup_Message);
				if (!actualInvalidSubSeqPopup.contains(invalidSubSequentPopup)) {
					click(driver, popup_Message_Yes_Button);

				}
				waitForPopup(driver, popup_Message, invalidSubSequentPopup);
				actualInvalidSubSeqPopup = getText(driver, popup_Message);
				Extent_call(test, test1, "Validating the actual and expected popups");
				if (actualInvalidSubSeqPopup.contains(invalidSubSequentPopup)) {
					System.out.println("Matched || " + " Expected Popup is : " + invalidSubSequentPopup
							+ " || Actual Popup is : " + actualInvalidSubSeqPopup);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + invalidSubSequentPopup
							+ " || Actual Popup is : " + actualInvalidSubSeqPopup, test, test1);
					Extent_pass_New(driver, invalidSubSequentPopup + " popup is displayed", test, test1);
					System.out.println(invalidSubSequentPopup + " popup is displayed");
					if(isdisplayed(driver, popup_Message_Ok_Button)) {
						click(driver, popup_Message_Ok_Button);
					}else if(isdisplayed(driver, popup_Message_No_Button)){
					click(driver, popup_Message_No_Button);
					}
				} else {
					System.out.println("Not matched || " + " Expected Popup is : " + invalidSubSequentPopup
							+ " || Actual Popup  is : " + actualInvalidSubSeqPopup);
					Extent_fail(driver, "Not matched || " + " Expected Popup is : " + invalidSubSequentPopup
							+ " || Actual Popup is : " + actualInvalidSubSeqPopup, test, test1);
				}
				waitForElement(driver, showAllMoves_CheckBox);
				checkBox(driver, showAllMoves_CheckBox, showAllMoves);
			Step_End(4, "Ensure that system should validate as 'Invalid subsequent move. Next possible movements are' with next possible moves due to move not mapped in sequence group", test, test1);


			Extent_completed(testcase_Name, test, test1);
			
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		
		int ts44=44;
		if(ts44==44) {
			
			String testcase_Name = "TC_Movement_Entry_Integration_TS044";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data44 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			
			
			String moduleName = data44.get("ModuleMovementEntry");
			String activitySNTS44 = data44.get("ActivitySNTS");
			String invalidPrevLocError = data44.get("InvalidPrevLocPopup");
			String equipmentNumForSNTS = data44.get("EquipmentNumForSNTS");
			String activityDate44=data44.get("ActivityDate");
			
			String datePicker=data44.get("DatePicker");
			String activityTime_Input1=data44.get("ActivityTime");


			Extent_Start(testcase_Name, test, test1);

			//To validate if user try to save SNTS with location not matching with previous move ONHI
			
//			Module Search
			moduleNavigate(driver, moduleName);

			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);
			if (isdisplayed(driver, movementEntryPage_L)) {
				System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
				Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
			}
			
			Step_Start(1, "Ensure that system should allow user to enter valid container no in movement entry", test, test1);
			waitForElement(driver, equipmentNoSearchField_L);
			clearAndType(driver, equipmentNoSearchField_L, equipmentNumForSNTS);
			
			Step_End(1, "Ensure that system should allow user to enter valid container no in movement entry", test, test1);
			Step_Start(2, "Ensure that system should validate when user try to enter incorrect location which is not matched with previous location based on sequence group ", test, test1);

			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activitySNTS44);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			
			if (!activityDate44.equals("")) {
				waitForElement(driver, activeDateInSingle_L);
				
				if(datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDate44);
		
						
				}else {
					click(driver, activeDateInSingle_L);

					if(activityDate44.contains("-")) {
						String activityDate44_1=activityDate44.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDate44_1);
						
					}else {
					clearAndType(driver, activeDateInSingle_L, activityDate44);
					
					}		
				}
			}
			
			if (!activityTime_Input1.equals("")) {
				
				click(driver, activityTime);

				
				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);
					
						clearAndType(driver, activityTime_Input, activityTime_Input1);
						System.out.println("activity_Time" + activityTime_Input1);
					
				}
				
				click(driver, activityTime_Close);
			} 
			
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);
			
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data44, test, test1);
			
			Step_End(2, "Ensure that system should validate when user try to enter incorrect location which is not matched with previous location based on sequence group ", test, test1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			Step_Start(3, "Ensure that system should validate as 'INVALID PREV LOCATIONAL ACTIVITY PLACE OR DEPOT\r\n"
					+ " ' due to location not matched bases on movement sequence setup", test, test1);
			waitForPopup(driver, error_Invalid_PrevCode, invalidPrevLocError);
				
				String actualInvalidPrevLocError=getText(driver, error_Invalid_PrevCode);
								
				if(actualInvalidPrevLocError.equals(invalidPrevLocError)) {
					System.out.println("Matched || " + " Expected Message is : " + invalidPrevLocError + " || Actual Message is : " + actualInvalidPrevLocError);
					Extent_pass_New(driver,"Matched || " + " Expected Message is : " + invalidPrevLocError + " || Actual Message is : " + actualInvalidPrevLocError,test,test1);
					click(driver, okButtonErrorFrame_L);	
				}else {
					System.out.println("Not matched || " + " Expected Message is : " + invalidPrevLocError + " || Actual Message  is : " + actualInvalidPrevLocError);
					Extent_fail(driver,"Not matched || " + " Expected Message is : " + invalidPrevLocError + " || Actual Message is : " + actualInvalidPrevLocError,test,test1);
				}			
				Step_End(3, "Ensure that system should validate as 'INVALID PREV LOCATIONAL ACTIVITY PLACE OR DEPOT\r\n"
						+ " ' due to location not matched bases on movement sequence setup", test, test1);
				
			Extent_completed(testcase_Name, test, test1);
			
				scrollTop(driver); waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
				
		}
		
		int ts45=45;
		
		if(ts45==45) {
			
			String testcase_Name = "TC_Movement_Entry_Integration_TS045";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			
			String moduleName = data.get("ModuleMovementEntry");
			String eqpNumLODF = data.get("EqpNumLODF");
			String lodfActivity = data.get("LodfActivity");
			String activityPlacePOLSameError = data.get("ActivityPlacePOLSameError");
			String activityDateSingle45 = data.get("activityDateSingle45");
			String datePicker = data.get("datePicker");
			String activityTime_Input1 = data.get("activityTime_Input1");


			Extent_Start(testcase_Name, test, test1);
			
			// To validate if user give POL & Activity Place not matched for LODF move

			//Module Search
			moduleNavigate(driver, moduleName);

			// Movement Entry
			waitForDisplay(driver, movementEntryPage_L);

			// Single Entry Equipment

				waitForElement(driver, equipmentNoSearchField_L);
				sendKeys(driver, equipmentNoSearchField_L, eqpNumLODF);
				waitForElement(driver, activitySearchFieldInSingle_L);
				sendKeys(driver, activitySearchFieldInSingle_L, lodfActivity);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				if (!activityDateSingle45.equals("")) {
					waitForElement(driver, activeDateInSingle_L);
					
					if(datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateInSingle_L, activityDateSingle45);
		
							
					}else {
						click(driver, activeDateInSingle_L);

						if(activityDateSingle45.contains("-")) {
							String activityDateSingle_45=activityDateSingle45.replace("-", "/");
							clear(driver,activeDateInSingle_L);
							sendKeys(driver, activeDateInSingle_L, activityDateSingle_45);
							
						}else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle45);
						
						}		
					}
				}
				
				if (!activityTime_Input1.equals("")) {
					waitForElement(driver, activityTime);
					click(driver, activityTime);

					
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);
							clearAndType(driver, activityTime_Input, activityTime_Input1);
							System.out.println("activity_Time" + activityTime_Input1);
						
					}
					
					click(driver, activityTime_Close);
				} 

				waitForElement(driver, showInputSin_L);
				click(driver, showInputSin_L);
			
			
			Step_Start(1, "Ensure that system should validate if user enter incorrect POL & click save after providing all mandatory fields", test, test1);
			
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);
			
			Step_End(1, "Ensure that system should validate if user enter incorrect POL & click save after providing all mandatory fields", test, test1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_Start(2, "Ensure that system should validate as 'Activity Place and POL should be same'", test, test1);

				waitForPopup(driver, activityPlace_Pol_Same_Error, activityPlacePOLSameError);
				String actualActivityPlacePOLSameError = getText(driver, activityPlace_Pol_Same_Error);

				if (actualActivityPlacePOLSameError.equals(activityPlacePOLSameError)) {
					System.out.println("Matched || " + " Expected Message is : " + activityPlacePOLSameError
							+ " || Actual Message is : " + actualActivityPlacePOLSameError);
					Extent_pass_New(driver, "Matched || " + " Expected Message is : " + activityPlacePOLSameError
							+ " || Actual Message is : " + actualActivityPlacePOLSameError, test, test1);
				} else {
					System.out.println("Not matched || " + " Expected Message is : " + activityPlacePOLSameError
							+ " || Actual Message  is : " + actualActivityPlacePOLSameError);
					Extent_fail(driver, "Not matched || " + " Expected Message is : " + activityPlacePOLSameError
							+ " || Actual Message is : " + actualActivityPlacePOLSameError, test, test1);
				}

				click(driver, okButtonErrorFrame_L);
				Step_End(2, "Ensure that system should validate as 'Activity Place and POL should be same'", test, test1);
				Extent_completed(testcase_Name, test, test1);
			
				scrollTop(driver); waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			
		}
		
		
		int ts46=46;
		if(ts46==46) {
			
			String testcase_Name = "TC_Movement_Entry_Integration_TS046";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			
			String moduleName = data.get("ModuleMovementEntry");
			String eqpNumLODF46 = data.get("EqpNumLODF");
			String lodfActivity46 = data.get("LodfActivity");
			String invalidPortError = data.get("InvalidPortError");
			String activityDateSingle46 = data.get("activityDateSingle46");
			String activityTime_Input1 = data.get("activityTime_Input1");
			String datePicker = data.get("datePicker");
			
			Extent_Start(testcase_Name, test, test1);

			// To validate if user given incorrect POD for LODF move
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

					//Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Movement Entry

			// Single Entry Equipment
				waitForElement(driver, equipmentNoSearchField_L);
				sendKeys(driver, equipmentNoSearchField_L, eqpNumLODF46);
				waitForElement(driver, activitySearchFieldInSingle_L);
				sendKeys(driver, activitySearchFieldInSingle_L, lodfActivity46);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				
				Extent_call(test, test1, "Entering the Date & Time period");
				if (!activityDateSingle46.equals("")) {
					waitForElement(driver, activeDateInSingle_L);
					
					
					if(datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateInSingle_L, activityDateSingle46);

							
					}else {
						click(driver, activeDateInSingle_L);

						if(activityDateSingle46.contains("-")) {
							String activityDateSingle46_1=activityDateSingle46.replace("-", "/");
							clear(driver,activeDateInSingle_L);
							sendKeys(driver, activeDateInSingle_L, activityDateSingle46_1);
							
						}else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle46);
						
						}		
					}
				}
				
				if (!activityTime_Input1.equals("")) {
					waitForElement(driver, activityTime);
					click(driver, activityTime);

					
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);
						
						

							clearAndType(driver, activityTime_Input, activityTime_Input1);
							System.out.println("activity_Time" + activityTime_Input1);
						
					}
					
					click(driver, activityTime_Close);
				} 
				waitForElement(driver, showInputSin_L);
				click(driver, showInputSin_L);
			

	      Step_Start(2, "Ensure that system should validate if the given POD is not connected for the load port & click save after providing all mandatory fields", test, test1);

			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(2, "Ensure that system should validate if the given POD is not connected for the load port & click save after providing all mandatory fields", test, test1);
			
	      Step_Start(3, "Ensure that system should validate as 'INVALID PORT. VESSEL NOT CALLING'.", test, test1);
			waitForPopup(driver, invalid_Port_Error, invalidPortError);

				String actualInvalidPortError = getText(driver, invalid_Port_Error);

				if (actualInvalidPortError.equals(invalidPortError)) {
					System.out.println("Matched || " + " Expected Message is : " + invalidPortError + " || Actual Message is : "
							+ actualInvalidPortError);
					Extent_pass_New(driver, "Matched || " + " Expected Message is : " + invalidPortError + " || Actual Message is : "
							+ actualInvalidPortError, test, test1);
				} else {
					System.out.println("Not matched || " + " Expected Message is : " + invalidPortError
							+ " || Actual Message  is : " + actualInvalidPortError);
					Extent_fail(driver, "Not matched || " + " Expected Message is : " + invalidPortError
							+ " || Actual Message is : " + actualInvalidPortError, test, test1);
				}
				Step_End(3, "Ensure that system should validate as 'INVALID PORT. VESSEL NOT CALLING'.", test, test1);
			
				click(driver, okButtonErrorFrame_L);
				Extent_completed(testcase_Name, test, test1);

				scrollTop(driver); waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			
		}
		
		int ts47=47;
		if(ts47==47) {
			
			String testcase_Name = "TC_Movement_Entry_Integration_TS047";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String eqpNumLODF47 = data.get("EqpNumLODF");
			String lodfActivity47 = data.get("LodfActivity");
			String containerNotAvailableError = data.get("ContainerNotAvailableError");
			String activityDateSingle47 = data.get("activityDateSingle47");
			String datePicker = data.get("datePicker");
			String activityTime_Input1 = data.get("activityTime_Input1");

					Extent_Start(testcase_Name, test, test1);


			// To validate if user try to save LODF move without container back update

					//Module Search
					Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
					moduleNavigate(driver, moduleName);

					Step_End(1, "Enter module name in searchbox & click the module", test, test1);
					Step_Start(2, "Ensure that system should validate if user enter all mandatory field correctly without saving previous SNTS move", test, test1);

			// Movement Entry

			// Single Entry Equipment
				waitForElement(driver, equipmentNoSearchField_L);
				sendKeys(driver, equipmentNoSearchField_L, eqpNumLODF47);
				
				waitForElement(driver, activitySearchFieldInSingle_L);
				sendKeys(driver, activitySearchFieldInSingle_L, lodfActivity47);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
			
				if (!activityDateSingle47.equals("")) {
					waitForElement(driver, activeDateInSingle_L);
					
					
					if(datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateInSingle_L, activityDateSingle47);

							
							
					}else {
						click(driver, activeDateInSingle_L);

						if(activityDateSingle47.contains("-")) {
							String activityDateSingle_47=activityDateSingle47.replace("-", "/");
							clear(driver,activeDateInSingle_L);
							sendKeys(driver, activeDateInSingle_L, activityDateSingle_47);
							
						}else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle47);
						
						}		
					}
				}
				
				if (!activityTime_Input1.equals("")) {
					
					waitForElement(driver, activityTime);
					click(driver, activityTime);

					
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);
						
							clearAndType(driver, activityTime_Input, activityTime_Input1);
							System.out.println("activity_Time" + activityTime_Input1);
						
					}
					
					click(driver, activityTime_Close);
				} 

				waitForElement(driver, showInputSin_L);
				click(driver, showInputSin_L);
			
				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);
				
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(2, "Ensure that system should validate if user enter all mandatory field correctly without saving previous SNTS move", test, test1);
			Step_Start(3, " Ensure that system should validate as 'Container not available in booking'.", test, test1);

			waitForElement(driver, errorRecordsFrame_L);

				String actualContainerNotAvailError = getText(driver, container_Not_Available_Error);

				if (actualContainerNotAvailError.equals(containerNotAvailableError)) {
					System.out.println("Matched || " + " Expected Message is : " + containerNotAvailableError
							+ " || Actual Message is : " + actualContainerNotAvailError);
					Extent_pass_New(driver, "Matched || " + " Expected Message is : " + containerNotAvailableError
							+ " || Actual Message is : " + actualContainerNotAvailError, test, test1);
				} else {
					System.out.println("Not matched || " + " Expected Message is : " + containerNotAvailableError
							+ " || Actual Message  is : " + actualContainerNotAvailError);
					Extent_fail(driver, "Not matched || " + " Expected Message is : " + containerNotAvailableError
							+ " || Actual Message is : " + actualContainerNotAvailError, test, test1);
				}

				click(driver, okButtonErrorFrame_L);
				
						Step_End(3, " Ensure that system should validate as 'Container not available in booking'.", test, test1);

						Extent_completed(testcase_Name, test, test1);

				scrollTop(driver); waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
		
		}
		
		int ts48=48;
		if(ts48==48) {
			
			String testcase_Name = "TC_Movement_Entry_Integration_TS048";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String moduleName = data.get("ModuleMovementEntry");
			String equipmentNum48 = data.get("EquipmentNum");
			String activitySearch48 = data.get("Activity");
			String futureActivityDateError = data.get("FutureActivityDateError");
			String activityDateSingle48 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			

			Extent_Start(testcase_Name, test, test1);
			
			// To validate if user try to save move in future date

					//Module Search
			moduleNavigate(driver, moduleName);

			// Movement Entry
			
			Step_Start(1, "Enter all mandatory field & click save by giving activity date in future for any move", test, test1);
			// Single Entry Equipment

				waitForElement(driver, equipmentNoSearchField_L);
				sendKeys(driver, equipmentNoSearchField_L, equipmentNum48);
				
				waitForElement(driver, activitySearchFieldInSingle_L);
				sendKeys(driver, activitySearchFieldInSingle_L, activitySearch48);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				waitForElement(driver, activeDateInSingle_L);
				click(driver, activeDateInSingle_L);

				Extent_call(test, test1, "Entering the Date & Time period");
				if (!activityDateSingle48.equals("")) {
					waitForElement(driver, activeDateInSingle_L);


					if(datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateInSingle_L, activityDateSingle48);


						}else {
							click(driver, activeDateInSingle_L);

							if(activityDateSingle48.contains("-")) {
								String activityDateSingle48_1=activityDateSingle48.replace("-", "/");

								clearAndType(driver, activeDateInSingle_L, activityDateSingle48_1);

							}else {
								clearAndType(driver, activeDateInSingle_L, activityDateSingle48);

							}		
						}
				}

				if (!activityTime_Input1.equals("")) {

					click(driver, activityTime);


					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);

						clearAndType(driver, activityTime_Input, activityTime_Input1);
						System.out.println("activity_Time" + activityTime_Input1);

					}

					click(driver, activityTime_Close);
				} 
				waitForElement(driver, showInputSin_L);
				click(driver, showInputSin_L);

				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Yes_Button);
				}

				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);
				
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);

			Step_End(1, "Enter all mandatory field & click save by giving activity date in future for any move", test, test1);
			Step_Start(2, "Ensure that system should validate as 'Activity Date cannot be in future date'.", test, test1);	
			waitForElement(driver, errorRecordsFrame_L);
				String actualFutureDateError = getText(driver, futureDate_Error);

				if (actualFutureDateError.equals(futureActivityDateError)) {
					System.out.println("Matched || " + " Expected Message is : " + futureActivityDateError
							+ " || Actual Message is : " + actualFutureDateError);
					Extent_pass_New(driver, "Matched || " + " Expected Message is : " + futureActivityDateError
							+ " || Actual Message is : " + actualFutureDateError, test, test1);
					click(driver, okButtonErrorFrame_L);
				} else {
					System.out.println("Not matched || " + " Expected Message is : " + futureActivityDateError
							+ " || Actual Message  is : " + actualFutureDateError);
					Extent_fail(driver, "Not matched || " + " Expected Message is : " + futureActivityDateError
							+ " || Actual Message is : " + actualFutureDateError, test, test1);
				}
				Step_End(2, "Ensure that system should validate as 'Activity Date cannot be in future date'.", test, test1);
				Extent_completed(testcase_Name, test, test1);
				
				scrollTop(driver); waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			
			
		}
		
		int ts49=49;
		if(ts49==49) {
			
			String testcase_Name = "TC_Movement_Entry_Integration_TS049";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			
			
			String moduleName = data.get("ModuleMovementEntry");
			String Activity_Move_Txt1 = data.get("Activity_Move");
			String Equip_Number_Txt1 = data.get("Equip_Number");
			String Invalid_Activity_Date_Exp = data.get("Invalid_Activity_Date");
			String activityDateSingle49 = data.get("activityDateSingle49");
			String datePicker = data.get("datePicker");
			String activityTime_Input1 = data.get("activityTime_Input1");

					Extent_Start(testcase_Name, test, test1);

			// To validate if user try to LODF move with incorrect date

					
					//Module Search
					moduleNavigate(driver, moduleName);

					// Single Entry Equipment
								waitForElement(driver, equipmentNoSearchField_L);
								sendKeys(driver, equipmentNoSearchField_L, Equip_Number_Txt1);
								waitForElement(driver, activitySearchFieldInSingle_L);
								sendKeys(driver, activitySearchFieldInSingle_L, Activity_Move_Txt1);
								waitForElement(driver, autoCompleteValue_ME);
								enter(driver);
								
								if (!activityDateSingle49.equals("")) {
									waitForElement(driver, activeDateInSingle_L);
									
									if(datePicker.equalsIgnoreCase("Yes")) {
										selectDatePicker(driver, activeDateInSingle_L, activityDateSingle49);

											
									}else {
										click(driver, activeDateInSingle_L);

										if(activityDateSingle49.contains("-")) {
											String activityDateSingle_47=activityDateSingle49.replace("-", "/");
											clear(driver,activeDateInSingle_L);
											sendKeys(driver, activeDateInSingle_L, activityDateSingle_47);
											
										}else {
										clearAndType(driver, activeDateInSingle_L, activityDateSingle49);
										
										}		
									}
								}
								
								if (!activityTime_Input1.equals("")) {
									
									waitForElement(driver, activityTime);
									click(driver, activityTime);

									
									if (isDisplayed(driver, Calender)) {
										click(driver, activityTime_Input);
										
											clearAndType(driver, activityTime_Input, activityTime_Input1);
											System.out.println("activity_Time" + activityTime_Input1);
										
									}
									
									click(driver, activityTime_Close);
								}
								waitForElement(driver, showInputSin_L);
								click(driver, showInputSin_L);
						
								Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
								allElements.movementEntryAllElements(driver, data, test, test1);
								
						scrollTop(driver);
						waitForElement(driver, SaveButton_ToolBar);
						click(driver, SaveButton_ToolBar);
						
						Step_Start(2, " Ensure that system should validate as 'Activity Date Should be within Arrival and Departure Date'.", test, test1);

						waitForPopup(driver, P_Invalid_Activity_Date_Popup, Invalid_Activity_Date_Exp);
						String Date_Popup = getText(driver, P_Invalid_Activity_Date_Popup);
						if (Invalid_Activity_Date_Exp.equals(Date_Popup)) {
							System.out.println("Matched || " + " Expected Message is : " + Invalid_Activity_Date_Exp
									+ " || Actual Message is : " + Date_Popup);
							Extent_pass_New(driver, "Matched || " + " Expected Message is : " + Invalid_Activity_Date_Exp
									+ " || Actual Message is : " + Date_Popup, test, test1);
						} else {
							System.out.println("Not Matched || " + " Expected Message is : " + Invalid_Activity_Date_Exp
									+ " || Actual Message is : " + Date_Popup);
							Extent_fail(driver, "Not Matched || " + " Expected Message is : " + Invalid_Activity_Date_Exp
									+ " || Actual Message is : " + Date_Popup, test, test1);
						
						}
					
					click(driver, P_Ok_Btn);
			Step_End(2, " Ensure that system should validate as 'Activity Date Should be within Arrival and Departure Date'.", test, test1);
			Extent_completed(testcase_Name, test, test1);
			
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		
		int ts50=50;
		if(ts50==50) {

			String testcase_Name = "TC_Movement_Entry_Integration_TS050";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			
			String moduleName = data.get("ModuleMovementEntry");
			String Activity_Move_Txt2 = data.get("Activity_Move");
			String Equip_Number_Txt2 = data.get("Equip_Number");
			String Invalid_Service_Exp = data.get("Invalid_Service");
			String activityDateSingle50 = data.get("activityDateSingle50");
			String activityTime_Input1 = data.get("activityTime_Input1");
			String datePicker = data.get("datePicker");
			String Invalid_Service_Input = data.get("Invalid_Service_Input");
			String Invalid_Vessel_Input = data.get("Invalid_Vessel_Input");
			String Invalid_Voyage_Input = data.get("Invalid_Voyage_Input");
			

			Extent_Start(testcase_Name, test, test1);

			// To validate if user try to save invalid service in LODF
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
			
					//Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);
			
				waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, Activity_Move_Txt2);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);

				
				if (!activityDateSingle50.equals("")) {
					waitForElement(driver, MultiActivity_Date);

					if(datePicker.equalsIgnoreCase("Yes")) {
						Extent_call(test, test1, "Entering the date,month & year");
						selectDatePicker(driver, MultiActivity_Date, activityDateSingle50);
							
					}else {
						click(driver, MultiActivity_Date);

						if(activityDateSingle50.contains("-")) {
							String activityDateSingle50_1=activityDateSingle50.replace("-", "/");
							clear(driver,MultiActivity_Date);
							sendKeys(driver, MultiActivity_Date, activityDateSingle50_1);
							
						}else {
						clearAndType(driver, MultiActivity_Date, activityDateSingle50);
						
						}		
					}
				}
				
				if (!activityTime_Input1.equals("")) {
					
					click(driver, activityTimeMultiple);

					
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);
						
						Extent_call(test, test1, "Entering the time");

							clearAndType(driver, activityTime_Input, activityTime_Input1);
							System.out.println("activity_Time" + activityTime_Input1);
						
					}
					
					click(driver, activityTime_Close);
				}
				
				waitForElement(driver, showInputButton);
				click(driver, showInputButton);

				waitForDisplay(driver, showInputFieldFrame_L);
				if (isdisplayed(driver, showInputFieldFrame_L)) {
					System.out.println("Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed");
					Extent_pass_New(driver, "Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed", test, test1);
				} else {
					System.out.println("Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed");
					Extent_fail(driver, "Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed", test, test1);
				}
				
	Step_Start(2, " Ensure that system should validate if user try save LODF move with all valid details & given invalid service", test, test1);
				
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);

			scrollElementToCenter(driver, service_Textfield_ME);
			waitForElement(driver, service_Textfield_ME);
			clearAndType(driver, service_Textfield_ME, Invalid_Service_Input);
			enter(driver);
			
			scrollElementToCenter(driver, vessel_Textfield_ME);
			waitForElement(driver, vessel_Textfield_ME);
			clearAndType(driver, vessel_Textfield_ME, Invalid_Vessel_Input);
			enter(driver);
			
			scrollElementToCenter(driver, voyage_Textfield_ME);
			waitForElement(driver, voyage_Textfield_ME);
			clearAndType(driver, voyage_Textfield_ME, Invalid_Voyage_Input);
			enter(driver);
			
	Step_End(2, " Ensure that system should validate if user try save LODF move with all valid details & given invalid service", test, test1);

				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);
				

				waitForElement(driver, selectGridCell_1_L);
				click(driver, selectGridCell_1_L);
				
				sendKeys(driver, eqpNum_Inputfield, Equip_Number_Txt2);
				
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				
				waitForDisplay(driver, forcebtn);
				if(isDisplayed(driver, forcebtn)) {
					click(driver, forcebtn);
				}
				

				Step_Start(3, "Ensure that system should validate as 'Invalid Service'.", test, test1);
				waitForPopup(driver, P_Invalid_Service_Popup, Invalid_Service_Exp);
				String service_Popup = getText(driver, P_Invalid_Service_Popup);
				if (Invalid_Service_Exp.equals(service_Popup)) {
					System.out.println("Matched || " + " Expected Message is : " + Invalid_Service_Exp
							+ " || Actual Message is : " + service_Popup);
					Extent_pass_New(driver, "Matched || " + " Expected Message is : " + Invalid_Service_Exp
							+ " || Actual Message is : " + service_Popup, test, test1);
				} else {
					System.out.println("Not Matched || " + " Expected Message is : " + Invalid_Service_Exp
							+ " || Actual Message is : " + service_Popup);
					Extent_fail(driver, "Not Matched || " + " Expected Message is : " + Invalid_Service_Exp
							+ " || Actual Message is : " + service_Popup, test, test1);
					
				}
				Step_End(3, "Ensure that system should validate as 'Invalid Service'.", test, test1);

				click(driver, P_Ok_Btn);

			Extent_completed(testcase_Name, test, test1);
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			
		}
		
	}

}
