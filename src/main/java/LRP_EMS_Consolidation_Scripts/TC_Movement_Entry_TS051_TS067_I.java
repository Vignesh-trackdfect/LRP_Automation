package LRP_EMS_Consolidation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Movement_Entry_TS051_TS067_I extends Keywords{
	public void noOfCharactersInMovementEntry51to67(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset) {
		
		String testcase_Name51 = "TC_Movement_Entry_Integration_TS051";
		String URL = TestNgXml.getdatafromExecution().get("TC_Movement_Entry_TS051_TS067_I");
		String File_Path51 = TestNgXml.getfilePath_FromExecution().get(testcase_Name51);
		String Sheet_Name51 = TestNgXml.getsheetName_FromExecution().get(testcase_Name51);
		System.out.println(Sheet_Name51);
		Map<String, String> data51 = Utils.GetAllData(Sheet_Name51, testcase_Name51, "Dataset" + selected_dataset, File_Path51);
		
		String username = data51.get("Username");
		String password = data51.get("Password");
		
		navigateUrl(driver, URL);

		LRP_Login(driver, username, password);
		
					int i = 1;
		
		if(i==1) {

			String testcase_Name = "TC_Movement_Entry_Integration_TS051";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			
			String moduleName = data.get("ModuleMovementEntry");
			String Activity_Move_Txt3 = data.get("Activity_Move");
			String Equip_Number_Txt3 = data.get("Equip_Number");
			String Invalid_Voyage_Exp = data.get("Invalid_Voyage");
			String activityDateSingle51 = data.get("activityDateSingle51");
			String datePicker = data.get("datePicker");
			String activityTime_Input1 = data.get("activityTime_Input1");
			String Invalid_Service_Input = data.get("Invalid_Service_Input");
			String Invalid_Vessel_Input = data.get("Invalid_Vessel_Input");
			String Invalid_Voyage_Input = data.get("Invalid_Voyage_Input");

					Extent_Start(testcase_Name, test, test1);
					

			// To validate if user try to save invalid voyage in LODF
					
					//Module Search
					Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
					moduleNavigate(driver, moduleName);
					Step_End(1, "Enter module name in searchbox & click the module", test, test1);
					Step_Start(2, "Ensure that system should validate if user try save LODF move with all valid details & given invalid voyage", test, test1);

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, Activity_Move_Txt3);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				if (!activityDateSingle51.equals("")) {
					waitForElement(driver, MultiActivity_Date);
					
					
					if(datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, MultiActivity_Date, activityDateSingle51);
							
					}else {
						click(driver, MultiActivity_Date);

						if(activityDateSingle51.contains("-")) {
							String activityDateSingle50_1=activityDateSingle51.replace("-", "/");
							clear(driver,MultiActivity_Date);
							sendKeys(driver, MultiActivity_Date, activityDateSingle50_1);
							
						}else {
						clearAndType(driver, MultiActivity_Date, activityDateSingle51);
						
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
				
				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);

				
				waitForElement(driver, selectGridCell_1_L);
				click(driver, selectGridCell_1_L);
				sendKeys(driver, eqpNum_Inputfield, Equip_Number_Txt3);
			
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);

				Step_End(2, "Ensure that system should validate if user try save LODF move with all valid details & given invalid voyage", test, test1);
				Step_Start(3, "Ensure that system should validate as 'Invalid voyage'.", test, test1);

				waitForPopup(driver, P_Invalid_Voyage_Popup, Invalid_Voyage_Exp);
				String voyage_Popup = getText(driver, P_Invalid_Voyage_Popup);
				if (Invalid_Voyage_Exp.equals(voyage_Popup)) {
					System.out.println("Matched || " + " Expected Popup is : " + Invalid_Voyage_Exp
							+ " || Actual Popup is : " + voyage_Popup);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Invalid_Voyage_Exp
							+ " || Actual Popup is : " + voyage_Popup, test, test1);
				} else {
					System.out.println("Not Matched || " + " Expected Popup is : " + Invalid_Voyage_Exp
							+ " || Actual Popup is : " + voyage_Popup);
					Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Invalid_Voyage_Exp
							+ " || Actual Popup is : " + voyage_Popup, test, test1);
					
				}
				click(driver, P_Ok_Btn);

						Step_End(3, "Ensure that system should validate as 'Invalid voyage'.", test, test1);

						Extent_completed(testcase_Name, test, test1);
			
			
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		if(i==1) {

			String testcase_Name = "TC_Movement_Entry_Integration_TS052";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			
			String moduleName = data.get("ModuleMovementEntry");
			String Activity_Move_Txt4 = data.get("Activity_Move");
			String Equip_Number_Txt4 = data.get("Equip_Number");
			String Invalid_Bound_Exp = data.get("Invalid_Bound");
			String activityDateSingle52 = data.get("activityDateSingle52");
			String activityTime_Input1 = data.get("activityTime_Input1");
			String datePicker = data.get("datePicker");
			
			
			Extent_Start(testcase_Name, test, test1);

			// To validate if user try to save invalid bound in LODF
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

					//Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);
				waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, Activity_Move_Txt4);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				if (!activityDateSingle52.equals("")) {
					waitForElement(driver, MultiActivity_Date);
					
					if(datePicker.equalsIgnoreCase("Yes")) {
						Extent_call(test, test1, "Entering the date,month & year");
						selectDatePicker(driver, MultiActivity_Date, activityDateSingle52);

					}else {
						click(driver, MultiActivity_Date);

						if(activityDateSingle52.contains("-")) {
							String activityDateSingle50_1=activityDateSingle52.replace("-", "/");
							clear(driver,MultiActivity_Date);
							sendKeys(driver, MultiActivity_Date, activityDateSingle50_1);
							
						}else {
						clearAndType(driver, MultiActivity_Date, activityDateSingle52);
						
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

			
	Step_Start(2, " Ensure that system should validate if user try save LODF move with all valid details & given invalid bound ", test, test1);

			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);

			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);
			
			waitForElement(driver, selectGridCell_1_L);
			click(driver, selectGridCell_1_L);
			
			waitForElement(driver, eqpNum_Inputfield);
			sendKeys(driver, eqpNum_Inputfield, Equip_Number_Txt4);
			
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
	Step_End(2, " Ensure that system should validate if user try save LODF move with all valid details & given invalid bound ", test, test1);
			
	Step_Start(3, " Ensure that system should validate as 'Invalid bound'.", test, test1);
				waitForPopup(driver, P_Invalid_Bound_Popup, Invalid_Bound_Exp);
				String Bound_Popup = getText(driver, P_Invalid_Bound_Popup);
				if (Invalid_Bound_Exp.equals(Bound_Popup)) {
					System.out.println("Matched || " + " Expected Message is : " + Invalid_Bound_Exp
							+ " || Actual Message is : " + Bound_Popup);
					Extent_pass_New(driver, "Matched || " + " Expected Message is : " + Invalid_Bound_Exp
							+ " || Actual Message is : " + Bound_Popup, test, test1);
				} else {
					System.out.println("Not Matched || " + " Expected Message is : " + Invalid_Bound_Exp
							+ " || Actual Message is : " + Bound_Popup);
					Extent_fail(driver, "Not Matched || " + " Expected Message is : " + Invalid_Bound_Exp
							+ " || Actual Message is : " + Bound_Popup, test, test1);
					
				}
	Step_End(3, " Ensure that system should validate as 'Invalid bound'.", test, test1);
				click(driver, P_Ok_Btn);
			Extent_completed(testcase_Name, test, test1);

			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {


			String testcase_Name = "TC_Movement_Entry_Integration_TS053";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String Activity_Move_Txt5 = data.get("Activity_Move");
			String Equip_Number_Txt5 = data.get("Equip_Number");
			String Invalid_Terminal_Exp = data.get("Invalid_Terminal");
			String DatePicker = data.get("DatePicker");
			String activityDate = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");

			Extent_Start(testcase_Name, test, test1);

			//// To validate if user given incorrect terminal for DCHF

					//Module Search
			moduleNavigate(driver, moduleName);

			Step_Start(1,
					" try save DCHF move with all valid details & given incorrect terminal which is not matched in booking terminal ",
					test, test1);
			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, Activity_Move_Txt5);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);

				if (!activityDate.equals("")) {
					waitForElement(driver, activeDateField_L);
					click(driver, activeDateField_L);

					if (DatePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateField_L, activityDate);

					} else {
						if (DatePicker.contains("-")) {
							String activityDate_1 = activityDate.replace("-", "/");
							clearAndType(driver, activeDateField_L, activityDate_1);

						} else {
							clearAndType(driver, activeDateField_L, activityDate);

						}
					}
				}

				if (!activityTime_Input1.equals("")) {
					click(driver, activityTimeMultiple);

					waitForElement(driver, Calender);
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);

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

				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);
				
				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);

				waitForElement(driver, selectGridCell_1_L);
				click(driver, selectGridCell_1_L);
				waitForElement(driver, eqpNum_Inputfield);
				sendKeys(driver, eqpNum_Inputfield, Equip_Number_Txt5);

				waitForElement(driver, eqpNum_Inputfield);
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				Step_End(1,
						" try save DCHF move with all valid details & given incorrect terminal which is not matched in booking terminal ",
						test, test1);
				Step_Start(2, "Ensure that system should validate as 'INVALID TERMINAL'.", test, test1);
				waitForPopup(driver, P_Invalid_Terminal_Popup, Invalid_Terminal_Exp);
				String Terminal_Popup = getText(driver, P_Invalid_Terminal_Popup);
				if (Invalid_Terminal_Exp.equals(Terminal_Popup)) {
					System.out.println("Matched || " + " Expected Message is : " + Invalid_Terminal_Exp
							+ " || Actual Message is : " + Terminal_Popup);
					Extent_pass_New(driver, "Matched || " + " Expected Message is : " + Invalid_Terminal_Exp
							+ " || Actual Message is : " + Terminal_Popup, test, test1);
					click(driver, P_Ok_Btn);
				} else {
					System.out.println("Not Matched || " + " Expected Message is : " + Invalid_Terminal_Exp
							+ " || Actual Message is : " + Terminal_Popup);
					Extent_fail(driver, "Not Matched || " + " Expected Message is : " + Invalid_Terminal_Exp
							+ " || Actual Message is : " + Terminal_Popup, test, test1);
					
				}
				Step_End(2, "Ensure that system should validate as 'INVALID TERMINAL'.", test, test1);
				Extent_completed(testcase_Name, test, test1);
			
				scrollTop(driver); waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			
		}
		if(i==1) {
			

			String testcase_Name = "TC_Movement_Entry_Integration_TS054";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			
			String moduleName = data.get("ModuleMovementEntry");
			String Activity_Move_Txt5 = data.get("Activity_Move");
			String Equip_Number_Txt5 = data.get("Equip_Number");
			String Invalid_POD_Exp = data.get("ErrorMessage");
			String DatePicker = data.get("DatePicker");
			String activityDate = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");

			Extent_Start(testcase_Name, test, test1);
			
			//// To validate if user given incorrect terminal for DCHF

					//Module Search
			moduleNavigate(driver, moduleName);

			Step_Start(1,
					" try save DCHF move with all valid details & given incorrect terminal which is not matched in booking terminal ",
					test, test1);
			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, Activity_Move_Txt5);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);

				if (!activityDate.equals("")) {
					waitForElement(driver, activeDateField_L);
					click(driver, activeDateField_L);

					if (DatePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateField_L, activityDate);

					} else {
						if (DatePicker.contains("-")) {
							String activityDate_1 = activityDate.replace("-", "/");
							clearAndType(driver, activeDateField_L, activityDate_1);

						} else {
							clearAndType(driver, activeDateField_L, activityDate);

						}
					}
				}

				if (!activityTime_Input1.equals("")) {
					click(driver, activityTimeMultiple);

					waitForElement(driver, Calender);
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);

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

				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);
				
				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);
			
				waitForElement(driver, selectGridCell_1_L);
				click(driver, selectGridCell_1_L);
				waitForElement(driver, eqpNum_Inputfield);
				sendKeys(driver, eqpNum_Inputfield, Equip_Number_Txt5);

				waitForElement(driver, eqpNum_Inputfield);
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				Step_End(1,
						"Try save DCHF move with all valid details & given incorrect location and terminal which is not matched in booking  ",
						test, test1);
				Step_Start(2, "Ensure that system should validate as 'Activity place and POD are mismatched'.", test,
						test1);
				waitForPopup(driver, P_Invalid_POD_Popup, Invalid_POD_Exp);
				String POD_Popup = getText(driver, P_Invalid_POD_Popup);
				if (POD_Popup.equals(Invalid_POD_Exp)) {
					System.out.println("Matched || " + " Expected Message is : " + Invalid_POD_Exp
							+ " || Actual Message is : " + POD_Popup);
					Extent_pass_New(driver, "Matched || " + " Expected Message is : " + Invalid_POD_Exp
							+ " || Actual Message is : " + POD_Popup, test, test1);
					click(driver, P_Ok_Btn);
				} else {
					System.out.println("Not Matched || " + " Expected Message is : " + Invalid_POD_Exp
							+ " || Actual Message is : " + POD_Popup);
					Extent_fail(driver, "Not Matched || " + " Expected Message is : " + Invalid_POD_Exp
							+ " || Actual Message is : " + POD_Popup, test, test1);
			
				}
				Step_End(2, "Ensure that system should validate as 'Activity place and POD are mismatched'.", test, test1);
				Extent_completed(testcase_Name, test, test1);
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		if(i==1) {
			


			String testcase_Name = "TC_Movement_Entry_Integration_TS055";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String lodfActivity55 = data.get("LodfActivity");
			String service_Popup_Txt = data.get("service_Popup_Txt");
			String activityDateSingle55 = data.get("activityDateSingle55");
			String activityTime_Input1 = data.get("activityTime_Input1");
			String datePicker = data.get("datePicker");
			
			Extent_Start(testcase_Name, test, test1);

			// To validate if user given blank service for LODF or DCHF
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

					//Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Multiple Equipment Entry

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, lodfActivity55);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				if (!activityDateSingle55.equals("")) {
					waitForElement(driver, MultiActivity_Date);
					
					
					if(datePicker.equalsIgnoreCase("Yes")) {
						Extent_call(test, test1, "Entering the date,month & year");
						selectDatePicker(driver, MultiActivity_Date, activityDateSingle55);
							
					}else {
						click(driver, MultiActivity_Date);

						if(activityDateSingle55.contains("-")) {
							String activityDateSingle50_1=activityDateSingle55.replace("-", "/");
							clear(driver,MultiActivity_Date);
						
							sendKeys(driver, MultiActivity_Date, activityDateSingle50_1);
							
						}else {
						clearAndType(driver, MultiActivity_Date, activityDateSingle55);
						
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

				
	Step_Start(2, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for service field since it is mandatory field", test, test1);
				
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);

			waitForElement(driver, service_Textfield_ME);
			click(driver, service_Textfield_ME);
			waitForDisplay(driver, service_Textfield_ME);
			clear(driver, service_Textfield_ME);

			waitForDisplay(driver, location_Textfield_ME);
			scrollElementToCenter(driver, location_Textfield_ME);
			click(driver, location_Textfield_ME);
			

				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);
				
				Step_End(2, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for service field since it is mandatory field", test, test1);
			Step_Start(3, "Ensure that system should validate as 'Service must be entered'.", test, test1);
				
			waitForPopup(driver, Popup_Message, service_Popup_Txt);
				String service_Popup = getText(driver, Popup_Message);
				if (service_Popup_Txt.equals(service_Popup)) {
					System.out.println("Matched || " + " Expected Popup is : " + service_Popup_Txt
							+ " || Actual Popup is : " + service_Popup);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + service_Popup_Txt
							+ " || Actual Popup is : " + service_Popup, test, test1);
				} else {
					System.out.println("Not Matched || " + " Expected Popup is : " + service_Popup_Txt
							+ " || Actual Popup is : " + service_Popup);
					Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + service_Popup_Txt
							+ " || Actual Popup is : " + service_Popup, test, test1);
					
				}
				Step_End(3, "Ensure that system should validate as 'Service must be entered'.", test, test1);
			Extent_completed(testcase_Name, test, test1);
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		
		}
		if(i==1) {

			String testcase_Name = "TC_Movement_Entry_Integration_TS056";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			
			String moduleName = data.get("ModuleMovementEntry");
			String lodfActivity56 = data.get("LodfActivity");
			String Vessel_Popup_Txt = data.get("Vessel_Popup_Txt");
			String activityDateSingle56 = data.get("activityDateSingle56");
			String activityTime_Input1 = data.get("activityTime_Input1");
			String datePicker = data.get("datePicker");
			
				Extent_Start(testcase_Name, test, test1);

			// To validate if user given blank vessel for LODF or DCHF
			
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

					//Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Multiple Equipment Entry

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);
				waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, lodfActivity56);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				if (!activityDateSingle56.equals("")) {
					waitForElement(driver, MultiActivity_Date);
					
					
					if(datePicker.equalsIgnoreCase("Yes")) {
						Extent_call(test, test1, "Entering the date,month & year");
						selectDatePicker(driver, MultiActivity_Date, activityDateSingle56);
							
					}else {
						click(driver, MultiActivity_Date);

						if(activityDateSingle56.contains("-")) {
							String activityDateSingle50_1=activityDateSingle56.replace("-", "/");
							clear(driver,MultiActivity_Date);
						
							sendKeys(driver, MultiActivity_Date, activityDateSingle50_1);
							
						}else {
						clearAndType(driver, MultiActivity_Date, activityDateSingle56);
						
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
				} else {
					System.out.println("activityTime " + "Input Not Available in : " + File_Path);
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

				Step_Start(2, " Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for vessel field since it is mandatory field", test, test1);
				
				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);

				waitForElement(driver, vessel_Textfield_ME);
				click(driver, vessel_Textfield_ME);
				waitForDisplay(driver, vessel_Textfield_ME);
				clear(driver, vessel_Textfield_ME);

				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
				
				Step_End(2, " Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for vessel field since it is mandatory field", test, test1);

				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);
			Step_Start(3, " Ensure that system should validate as 'Vessel must be entered'.", test, test1);
				waitForPopup(driver, Popup_Message, Vessel_Popup_Txt);
				String vessel_Popup = getText(driver, Popup_Message);
				if (Vessel_Popup_Txt.equals(vessel_Popup)) {
					System.out.println("Matched || " + " Expected Popup is : " + Vessel_Popup_Txt
							+ " || Actual Popup is : " + vessel_Popup);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Vessel_Popup_Txt
							+ " || Actual Popup is : " + vessel_Popup, test, test1);
				} else {
					System.out.println("Not Matched || " + " Expected Popup is : " + Vessel_Popup_Txt
							+ " || Actual Popup is : " + vessel_Popup);
					Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Vessel_Popup_Txt
							+ " || Actual Popup is : " + vessel_Popup, test, test1);
								}
			Step_End(3, " Ensure that system should validate as 'Vessel must be entered'.", test, test1);
			
			Extent_completed(testcase_Name, test, test1);
		
		
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			

			String testcase_Name = "TC_Movement_Entry_Integration_TS057";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String lodfActivity57 = data.get("LodfActivity");
			String Voyage_Popup_Txt = data.get("Voyage_Popup_Txt");
			String datePicker = data.get("datePicker");
			String activityDateSingle57 = data.get("activityDateSingle57");
			String activityTime_Input1 = data.get("activityTime_Input1");
			
			Extent_Start(testcase_Name, test, test1);
			// To validate if user given blank voyage for LODF or DCHF
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

			//Module Search
			moduleNavigate(driver, moduleName);

			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Multiple Equipment Entry

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, lodfActivity57);
				waitForDisplay(driver, autoCompleteValue_ME);
				enter(driver);
				
				if (!activityDateSingle57.equals("")) {
					waitForElement(driver, MultiActivity_Date);
					
					
					if(datePicker.equalsIgnoreCase("Yes")) {
						Extent_call(test, test1, "Entering the date,month & year");
						selectDatePicker(driver, MultiActivity_Date, activityDateSingle57);
							
					}else {
						click(driver, MultiActivity_Date);

						if(activityDateSingle57.contains("-")) {
							String activityDateSingle50_1=activityDateSingle57.replace("-", "/");
							clear(driver,MultiActivity_Date);
						
							sendKeys(driver, MultiActivity_Date, activityDateSingle50_1);
							
						}else {
						clearAndType(driver, MultiActivity_Date, activityDateSingle57);
						
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
				} else {
					System.out.println("activityTime " + "Input Not Available in : " + File_Path);
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

	Step_Start(2, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for voyage field since it is mandatory field", test, test1);
				
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);

			waitForElement(driver, voyage_Textfield_ME);
			click(driver, voyage_Textfield_ME);
			waitForDisplay(driver, voyage_Textfield_ME);
			clear(driver, voyage_Textfield_ME);

			waitForElement(driver, location_Textfield_ME);
			click(driver, location_Textfield_ME);
			
			Step_End(2, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for voyage field since it is mandatory field", test, test1);
			Step_Start(3, "Ensure that system should validate as 'Voyage must be entered'.", test, test1);
				
				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);
				
				waitForPopup(driver, Popup_Message, Voyage_Popup_Txt);
				String voyage_Popup = getText(driver, Popup_Message);
				if (Voyage_Popup_Txt.equals(voyage_Popup)) {
					System.out.println("Matched || " + " Expected Popup is : " + Voyage_Popup_Txt
							+ " || Actual Popup is : " + voyage_Popup);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Voyage_Popup_Txt
							+ " || Actual Popup is : " + voyage_Popup, test, test1);
				} else {
					System.out.println("Not Matched || " + " Expected Popup is : " + Voyage_Popup_Txt
							+ " || Actual Popup is : " + voyage_Popup);
					Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Voyage_Popup_Txt
							+ " || Actual Popup is : " + voyage_Popup, test, test1);
				
				}
				
				Step_End(3, "Ensure that system should validate as 'Voyage must be entered'.", test, test1);
			Extent_completed(testcase_Name, test, test1);
		
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			

			String testcase_Name = "TC_Movement_Entry_Integration_TS058";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String moduleName = data.get("ModuleMovementEntry");
			String lodfActivity58 = data.get("LodfActivity");
			String Bound_Popup_Txt = data.get("Bound_Popup_Txt");
			String activityDateSingle58 = data.get("activityDateSingle58");
			String activityTime_Input1 = data.get("activityTime_Input1");
			String datePicker = data.get("datePicker");

			Extent_Start(testcase_Name, test, test1);
			// To validate if user given blank bound for LODF or DCHF
			//Module Search
			moduleNavigate(driver, moduleName);

			// Multiple Equipment Entry

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, lodfActivity58);
				waitForDisplay(driver, autoCompleteValue_ME);
				enter(driver);

				if (!activityDateSingle58.equals("")) {
					waitForElement(driver, MultiActivity_Date);
					if(datePicker.equalsIgnoreCase("Yes")) {
						Extent_call(test, test1, "Entering the date,month & year");
							selectDatePicker(driver, MultiActivity_Date, activityDateSingle58);

						}else {
							if(activityDateSingle58.contains("-")) {
								String activityDateSingle50_1=activityDateSingle58.replace("-", "/");
								clear(driver,activeDateInSingle_L);
								sendKeys(driver, activeDateInSingle_L, activityDateSingle50_1);

							}else {
								clearAndType(driver, activeDateInSingle_L, activityDateSingle58);

							}		
						}
				}

				if (!activityTime_Input1.equals("")) {

					click(driver, activityTimeMultiple);


					if (isdisplayed(driver, Calender)) {
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

				Step_Start(1, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for bound field since it is mandatory field", test, test1);
				
				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);
				
				waitForElement(driver, Bound_ME);
				click(driver, Bound_ME);
				waitForDisplay(driver, Bound_ME);
				clear(driver, Bound_ME);

				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
				
				Step_End(1, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for bound field since it is mandatory field", test, test1);

				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);

				Step_Start(2, "Ensure that system should validate as 'Bound must be entered'.", test, test1);

				waitForPopup(driver, Popup_Message, Bound_Popup_Txt);
				String bound_Popup = getText(driver, Popup_Message);
				if (Bound_Popup_Txt.equals(bound_Popup)) {
					System.out.println("Matched || " + " Expected Popup is : " + Bound_Popup_Txt
							+ " || Actual Popup is : " + bound_Popup);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Bound_Popup_Txt
							+ " || Actual Popup is : " + bound_Popup, test, test1);
				} else {
					System.out.println("Not Matched || " + " Expected Popup is : " + Bound_Popup_Txt
							+ " || Actual Popup is : " + bound_Popup);
					Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Bound_Popup_Txt
							+ " || Actual Popup is : " + bound_Popup, test, test1);

				}
				Step_End(2, "Ensure that system should validate as 'Bound must be entered'.", test, test1);
				Extent_completed(testcase_Name, test, test1);
			
				scrollTop(driver); waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
		}
		if(i==1) {
			
			String testcase_Name = "TC_Movement_Entry_Integration_TS059";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String lodfActivity59 = data.get("LodfActivity");
			String POL_Popup_Txt = data.get("POL_Popup_Txt");
			String activityDateSingle59 = data.get("activityDateSingle59");
			String activityTime_Input1 = data.get("activityTime_Input1");
			String datePicker = data.get("datePicker");
					Extent_Start(testcase_Name, test, test1);

			// To validate if user given blank POL for LODF or DCHF
					
					Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
					//Module Search
					moduleNavigate(driver, moduleName);

					Step_End(1, "Enter module name in searchbox & click the module", test, test1);
					Step_Start(2, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for POL field since it is mandatory field", test, test1);

			// Multiple Equipment Entry
			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, lodfActivity59);
				
				enter(driver);
				if (!activityDateSingle59.equals("")) {
					waitForElement(driver, MultiActivity_Date);
					if(datePicker.equalsIgnoreCase("Yes")) {
						Extent_call(test, test1, "Entering the date,month & year");
							selectDatePicker(driver, MultiActivity_Date, activityDateSingle59);

							
						}else {
						if(activityDateSingle59.contains("-")) {
							String activityDateSingle50_1=activityDateSingle59.replace("-", "/");
							clear(driver,activeDateInSingle_L);
							sendKeys(driver, activeDateInSingle_L, activityDateSingle50_1);
							
						}else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle59);
						
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
				
				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);
				
				waitForElement(driver, POL_Textfield_ME);
				click(driver, POL_Textfield_ME);
				waitForDisplay(driver, POL_Textfield_ME);
				clear(driver, POL_Textfield_ME);
				
				waitForElement(driver, location_Textfield_ME);
				click(driver, location_Textfield_ME);
				
				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);
				
				Step_End(2, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for POL field since it is mandatory field", test, test1);
				Step_Start(3, "Ensure that system should validate as 'POL must be entered'.", test, test1);

				waitForPopup(driver, Popup_Message, POL_Popup_Txt);
				String POL_Popup = getText(driver, Popup_Message);
				if (POL_Popup_Txt.equals(POL_Popup)) {
					System.out.println("Matched || " + " Expected Popup is : " + POL_Popup_Txt
							+ " || Actual Popup is : " + POL_Popup);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + POL_Popup_Txt
							+ " || Actual Popup is : " + POL_Popup, test, test1);
				} else {
					System.out.println("Not Matched || " + " Expected Popup is : " + POL_Popup_Txt
							+ " || Actual Popup is : " + POL_Popup);
					Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + POL_Popup_Txt
							+ " || Actual Popup is : " + POL_Popup, test, test1);
					
				}
				Step_End(3, "Ensure that system should validate as 'POL must be entered'.", test, test1);

			Extent_completed(testcase_Name, test, test1);

			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		
		
		if(i==1) {
			
			

			String testcase_Name = "TC_Movement_Entry_Integration_TS060";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String invalidNextMoveEqpNum = data.get("InvalidNextMoveEqpNum");
			String activityOFHI = data.get("ActivityOFHI");
			String invalidNextMovePopup = data.get("InvalidNextMovePopup");
			String activityDateSingle60 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			String showAllMoves = data.get("ShowAllMoves");

			Extent_Start(testcase_Name, test, test1);

			//// To validate invalid move if user try to insert in between next move
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

					//Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);
			// Movement Entry

			// Single Entry Equipment
			waitForElement(driver, singleEntryMovPage_L);

			Step_Start(2,
						"Ensure that system should validate if user try to insert incorrect inbetween next move which is not mapped in sequence group",
						test, test1);
				waitForElement(driver, equipmentNoSearchField_L);
				sendKeys(driver, equipmentNoSearchField_L, invalidNextMoveEqpNum);
				Step_End(2,
						"Ensure that system should validate if user try to insert incorrect inbetween next move which is not mapped in sequence group",
						test, test1);
				waitForElement(driver, activitySearchFieldInSingle_L);
				sendKeys(driver, activitySearchFieldInSingle_L, activityOFHI);
				enter(driver);
				waitForElement(driver, activeDateInSingle_L);
				click(driver, activeDateInSingle_L);
				if (!activityDateSingle60.equals("")) {
					waitForElement(driver, activeDateInSingle_L);
					click(driver, activeDateInSingle_L);

					if (datePicker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, activeDateInSingle_L, activityDateSingle60);
						
					} else {
						if (activityDateSingle60.contains("-")) {
							String activityDateSingle60_1 = activityDateSingle60.replace("-", "/");
							clearAndType(driver, activeDateInSingle_L, activityDateSingle60_1);
						} else {
							clearAndType(driver, activeDateInSingle_L, activityDateSingle60);

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

			
			Step_Start(3, "Ensure that system should validate as ' Invalid Next Move'.", test, test1);
			waitForPopup(driver, popup_Message, invalidNextMovePopup);

				String actualInvalidNextMovePopup = getText(driver, popup_Message);

				if (actualInvalidNextMovePopup.equals(invalidNextMovePopup)) {
					System.out.println("Matched || " + " Expected Popup is : " + invalidNextMovePopup
							+ " || Actual Popup is : " + actualInvalidNextMovePopup);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + invalidNextMovePopup
							+ " || Actual Popup is : " + actualInvalidNextMovePopup, test, test1);
					click(driver, popup_Message_Ok_Button);
				} else {
					System.out.println("Not matched || " + " Expected Popup is : " + invalidNextMovePopup
							+ " || Actual Popup  is : " + actualInvalidNextMovePopup);
					Extent_fail(driver, "Not matched || " + " Expected Popup is : " + invalidNextMovePopup
							+ " || Actual Popup is : " + actualInvalidNextMovePopup, test, test1);
					
				}

			
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);
			}
			
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_No_Button);
			}
			waitForElement(driver, showAllMoves_CheckBox);
			checkBox(driver, showAllMoves_CheckBox, showAllMoves);

			Step_End(3, "Ensure that system should validate as ' Invalid Next Move'.", test, test1);

			Extent_completed(testcase_Name, test, test1);

		
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			
			String testcase_Name = "TC_Movement_Entry_Integration_TS061";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String invalidPrevMoveEqpNum = data.get("InvalidPrevMoveEqpNum");
			String invalidPrevMovePopup = data.get("InvalidPrevMovePopup");
			String activitySALE = data.get("ActivitySALE");
			String activityDateSingle61 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			String showAllMoves = data.get("ShowAllMoves");

			Extent_Start(testcase_Name, test, test1);

			// To validate invalid move if user try to insert in between previous move
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

					//Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Movement Entry
			

			// Single Entry Equipment
			waitForElement(driver, singleEntryMovPage_L);
				Step_Start(2,
						"Ensure that system should validate if user try to insert incorrect inetween previous move which is not mapped in sequence group",
						test, test1);
				waitForElement(driver, equipmentNoSearchField_L);
				sendKeys(driver, equipmentNoSearchField_L, invalidPrevMoveEqpNum);
				Step_End(2,
						"Ensure that system should validate if user try to insert incorrect inetween previous move which is not mapped in sequence group",
						test, test1);
				waitForElement(driver, activitySearchFieldInSingle_L);
				click(driver, activitySearchFieldInSingle_L);
				waitForElement(driver, activitySearchFieldInSingle_L);
				sendKeys(driver, activitySearchFieldInSingle_L, activitySALE);
				waitForDisplay(driver, autoCompleteValue_ME);
				enter(driver);
				
				waitForElement(driver, activeDateInSingle_L);
				click(driver, activeDateInSingle_L);
				if (!activityDateSingle61.equals("")) {
					waitForElement(driver, activeDateInSingle_L);
					if (datePicker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, activeDateInSingle_L, activityDateSingle61);
						
					} else {
						if (activityDateSingle61.contains("-")) {
							String activityDateSingle61_1 = activityDateSingle61.replace("-", "/");
							clearAndType(driver, activeDateInSingle_L, activityDateSingle61_1);

						} else {
							clearAndType(driver, activeDateInSingle_L, activityDateSingle61);

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

			Step_Start(3, "Ensure that system should validate as ' Invalid Previous Move'.", test, test1);
		
			waitForPopup(driver, popup_Message, invalidPrevMovePopup);

				String actualInvalidPrevMovePopup = getText(driver, popup_Message);

				if (actualInvalidPrevMovePopup.equals(invalidPrevMovePopup)) {
					System.out.println("Matched || " + " Expected Popup is : " + invalidPrevMovePopup
							+ " || Actual Popup is : " + actualInvalidPrevMovePopup);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + invalidPrevMovePopup
							+ " || Actual Popup is : " + actualInvalidPrevMovePopup, test, test1);
					click(driver, popup_Message_Ok_Button);
				} else {
					System.out.println("Not matched || " + " Expected Popup is : " + invalidPrevMovePopup
							+ " || Actual Popup  is : " + actualInvalidPrevMovePopup);
					Extent_fail(driver, "Not matched || " + " Expected Popup is : " + invalidPrevMovePopup
							+ " || Actual Popup is : " + actualInvalidPrevMovePopup, test, test1);
				}


			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_No_Button);
			}
			
			waitForElement(driver, showAllMoves_CheckBox);
			checkBox(driver, showAllMoves_CheckBox, showAllMoves);
			
			Step_End(3, "Ensure that system should validate as ' Invalid Previous Move'.", test, test1);
			Extent_completed(testcase_Name, test, test1);
		
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			
			String testcase_Name = "TC_Movement_Entry_Integration_TS062";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String activitySUBL = data.get("ActivitySUBL");
			String releaseReferenceEnteredPopup = data.get("ReleaseReferenceEnteredPopup");
			String activityDateSingle62 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");

			Extent_Start(testcase_Name, test, test1);

			//// To validate if user try to save SUBL without ref no
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

					//Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Movement Entry
			
			// Multiple Equipment Entry

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, activitySUBL);
				enter(driver);
				waitForElement(driver, activeDateField_L);
				click(driver, activeDateField_L);
				if (!activityDateSingle62.equals("")) {
					waitForElement(driver, activeDateField_L);
					if (datePicker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, activeDateField_L, activityDateSingle62);
						
					} else {
						if (activityDateSingle62.contains("-")) {
							String activityDateSingle62_1 = activityDateSingle62.replace("-", "/");
							clearAndType(driver, activeDateField_L, activityDateSingle62_1);

						} else {
							clearAndType(driver, activeDateField_L, activityDateSingle62);

						}
					}
				}

				if (!activityTime_Input1.equals("")) {
					click(driver, activityTimeMultiple);

					waitForElement(driver, Calender);
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);

						clearAndType(driver, activityTime_Input, activityTime_Input1);
						System.out.println("activity_Time" + activityTime_Input1);

					}
					click(driver, activityTime_Close);
				} 
				
				waitForElement(driver, showInputButton);
				click(driver, showInputButton);

			
			Step_Start(2,
					"Ensure that system should validate if user try to save SUBL move by giving blank in release ref field",
					test, test1);
			
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);
			
			Step_End(2,
					"Ensure that system should validate if user try to save SUBL move by giving blank in release ref field",
					test, test1);
			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);
			Step_Start(3, " Ensure that system should validate as ' Release Reference must be entered'.", test, test1);
			waitForPopup(driver, Popup_Message, releaseReferenceEnteredPopup);

				String actualReleaseRefPopup = getText(driver, Popup_Message);

				if (actualReleaseRefPopup.equals(releaseReferenceEnteredPopup)) {
					System.out.println("Matched || " + " Expected Popup is : " + releaseReferenceEnteredPopup
							+ " || Actual Popup is : " + actualReleaseRefPopup);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + releaseReferenceEnteredPopup
							+ " || Actual Popup is : " + actualReleaseRefPopup, test, test1);
					Extent_pass_New(driver, releaseReferenceEnteredPopup + " popup is displayed", test, test1);
					System.out.println(releaseReferenceEnteredPopup + " popup is displayed");

				} else {
					System.out.println("Not matched || " + " Expected Popup is : " + releaseReferenceEnteredPopup
							+ " || Actual Popup  is : " + actualReleaseRefPopup);
					Extent_fail(driver, "Not matched || " + " Expected Popup is : " + releaseReferenceEnteredPopup
							+ " || Actual Popup is : " + actualReleaseRefPopup, test, test1);
				}

			Step_End(3, " Ensure that system should validate as ' Release Reference must be entered'.", test, test1);
			Extent_completed(testcase_Name, test, test1);
		
			
			scrollTop(driver); scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS063";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_063 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_063, testCaseName,
					"Dataset" + selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");

			String containerNumTS63 = data.get("ContainerNumTS63");
			String movementNotAllowedError = data.get("MovementNotAllowedError");
			String activitySUBL63 = data.get("ActivitySUBL");
			String activityDateSingle63 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			
			Extent_Start(testCaseName, test, test1);

			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
			
//			Module Search
			moduleNavigate(driver, moduleName);

			// Movement Entry
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Multiple Equipment Entry

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, activitySUBL63);
				waitForDisplay(driver, autoCompleteValue_ME);
				enter(driver);
				if (!activityDateSingle63.equals("")) {
					waitForElement(driver, activeDateField_L);
					if (datePicker.equalsIgnoreCase("Yes")) {
						
							selectDatePicker(driver, activeDateField_L, activityDateSingle63);
						
					} else {
						if (activityDateSingle63.contains("-")) {
							String activityDateSingle63_1 = activityDateSingle63.replace("-", "/");
							clearAndType(driver, activeDateField_L, activityDateSingle63_1);

						} else {
							clearAndType(driver, activeDateField_L, activityDateSingle63);

						}
					}
				}

				if (!activityTime_Input1.equals("")) {
					click(driver, activityTimeMultiple);

					waitForElement(driver, Calender);
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);

						clearAndType(driver, activityTime_Input, activityTime_Input1);
						System.out.println("activity_Time" + activityTime_Input1);

					}
					click(driver, activityTime_Close);
				} else {
					System.out.println("activityTime " + "Input Not Available in : " + File_Path);
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
			Step_Start(2,
					"Ensure that system should validate if user try to save SUBL move by giving supplier ref in release ref field instead of sublease reference",
					test, test1);

			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, data, test, test1);
			
			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);
			
			waitForElement(driver, selectGridCell_1_L);
			click(driver, selectGridCell_1_L);
			
			waitForElement(driver, eqpNum_Inputfield);
			sendKeys(driver, eqpNum_Inputfield, containerNumTS63);
			
			Step_End(2,
					"Ensure that system should validate if user try to save SUBL move by giving supplier ref in release ref field instead of sublease reference",
					test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_Start(3, " Ensure that system should validate as ' This movement is not allowed for the Contract'.", test,
					test1);
			waitForPopup(driver, movemet_Not_Allowed_Error, movementNotAllowedError);

				String actualMoveNotAllowedError = getText(driver, movemet_Not_Allowed_Error);

				if (actualMoveNotAllowedError.equals(movementNotAllowedError)) {
					System.out.println("Matched || "+movementNotAllowedError + " Error is displayed ||" + " Expected Message is : " + movementNotAllowedError
							+ " || Actual Message is : " + actualMoveNotAllowedError);
					Extent_pass_New(driver, "Matched || "+movementNotAllowedError + " Error is displayed ||" + " Expected Message is : " + movementNotAllowedError
							+ " || Actual Message is : " + actualMoveNotAllowedError, test, test1);
					click(driver, okButtonErrorFrame_L);
				} else {
					System.out.println("Not matched || "+movementNotAllowedError + " Error is not displayed ||" + " Expected Message is : " + movementNotAllowedError
							+ " || Actual Message  is : " + actualMoveNotAllowedError);
					Extent_fail(driver, "Not matched || "+movementNotAllowedError + " Error is not displayed ||" + " Expected Message is : " + movementNotAllowedError
							+ " || Actual Message is : " + actualMoveNotAllowedError, test, test1);
				}

			Step_End(3, " Ensure that system should validate as ' This movement is not allowed for the Contract'.", test,
					test1);
			Extent_completed(testCaseName, test, test1);
		
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS064";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_064 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_064, testCaseName, "Dataset"+selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String activityRTNL = data.get("ActivityRTNL");
			String eqpNumberRTNL = data.get("EqpNumberRTNL");
			String invalidScaleOutReferenceError = data.get("InvalidScaleOutReferenceError");
			String activityDateSingle64 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			
			Extent_Start(testCaseName, test, test1);

			// To validate Invalid Scale out reference in RTNL
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
			
//			Module Search
			moduleNavigate(driver, moduleName);

			// Movement Entry
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Multiple Equipment Entry

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, activityRTNL);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				if (!activityDateSingle64.equals("")) {
					waitForElement(driver, activeDateField_L);
					if(datePicker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, activeDateField_L, activityDateSingle64);
							
					}else {
						if(activityDateSingle64.contains("-")) {
							String activityDateSingle64_1=activityDateSingle64.replace("-", "/");
							clearAndType(driver, activeDateField_L, activityDateSingle64_1);
							
						}else {
						clearAndType(driver, activeDateField_L, activityDateSingle64);
						
						}		
					}
				}
				
				if (!activityTime_Input1.equals("")) {
					click(driver, activityTimeMultiple);

					waitForElement(driver, Calender);
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);
						
							clearAndType(driver, activityTime_Input, activityTime_Input1);
							System.out.println("activity_Time" + activityTime_Input1);
						
					}
					click(driver, activityTime_Close);
				} else {
					System.out.println("activityTime " + "Input Not Available in : " + File_Path);
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

				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);
				
			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);

			waitForElement(driver, selectGridCell_1_L);
			click(driver, selectGridCell_1_L);
			
			Step_Start(2, "Ensure that system should validate if user try to save RTNL move by giving SUBL ref in RTNL move", test, test1);
			
			waitForDisplay(driver, eqpNum_Inputfield);
			sendKeys(driver, eqpNum_Inputfield, eqpNumberRTNL);
			waitForElement(driver, eqpNum_Inputfield);

			Step_End(2, "Ensure that system should validate if user try to save RTNL move by giving SUBL ref in RTNL move", test, test1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_Start(3, "Ensure that system should validate as 'Invalid Scale out reference'.", test, test1);
			
			waitForPopup(driver, invalid_Scale_Out_Error, invalidScaleOutReferenceError);

				String actuainvalidScaleOutError = getText(driver, invalid_Scale_Out_Error);

				if (actuainvalidScaleOutError.equals(invalidScaleOutReferenceError)) {
					System.out.println("Matched || " +invalidScaleOutReferenceError + " Error is displayed ||"+ " Expected Message is : " + invalidScaleOutReferenceError
							+ " || Actual Message is : " + actuainvalidScaleOutError);
					Extent_pass_New(driver, "Matched || " +invalidScaleOutReferenceError + " Error is displayed ||"+ " Expected Message is : " + invalidScaleOutReferenceError
							+ " || Actual Message is : " + actuainvalidScaleOutError, test, test1);
					click(driver, okButtonErrorFrame_L); 
				} else {
					System.out.println("Not matched || "+invalidScaleOutReferenceError + " Error is not displayed ||" + " Expected Message is : " + invalidScaleOutReferenceError
							+ " || Actual Message  is : " + actuainvalidScaleOutError);
					Extent_fail(driver, "Not matched || " +invalidScaleOutReferenceError + " Error is not displayed ||"+ " Expected Message is : " + invalidScaleOutReferenceError
							+ " || Actual Message is : " + actuainvalidScaleOutError, test, test1);
				}

			Step_End(3, "Ensure that system should validate as 'Invalid Scale out reference'.", test, test1);
			Extent_completed(testCaseName, test, test1);
		
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		
		if(i==1) {
			

			String testCaseName="TC_Movement_Entry_IntegrationTS065";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_065 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_065, testCaseName, "Dataset"+selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String activityONHI = data.get("ActivityONHI");
			String sOCNotAllowedError = data.get("SOCNotAllowedError");
			String equipmentNum65 = data.get("EquipmentNum");
			String activityDateSingle65 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");

			Extent_Start(testCaseName, test, test1);

			//// To validate SOC not allowed for ONHI
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);


			//		Module Search
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

			Step_End(1, "Enter module name in searchbox & click the module", test, test1);
			Step_Start(2, "try to save ONHI move by giving 'Y' in SOC field", test, test1);
			// Multiple Equipment Entry

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, activityONHI);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);

				if (!activityDateSingle65.equals("")) {
					waitForElement(driver, activeDateField_L);
					if(datePicker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, activeDateField_L, activityDateSingle65);
						}else {
							if(activityDateSingle65.contains("-")) {
								String activityDateSingle65_1=activityDateSingle65.replace("-", "/");
								clearAndType(driver, activeDateField_L, activityDateSingle65_1);

							}else {
								clearAndType(driver, activeDateField_L, activityDateSingle65);

							}		
						}
				}

				if (!activityTime_Input1.equals("")) {
					click(driver, activityTimeMultiple);

					waitForElement(driver, Calender);
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);

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

				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);
				
				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);

				waitForElement(driver, selectGridCell_1_L);
				click(driver, selectGridCell_1_L);
				waitForElement(driver, searchEqpNoInGrid_1_L);
				sendKeys(driver, searchEqpNoInGrid_1_L, equipmentNum65);


				scrollTop(driver);
				waitForElement(driver, saveButtonMoveEnt_L);
				click(driver, saveButtonMoveEnt_L);

			waitForDisplay(driver, errorRecordsFrame_L);
			if (isDisplayed(driver, errorRecordsFrame_L)) {
				if (isDisplayed(driver, errorRecApply_L)) {
					click(driver, errorRecApply_L);
				} else if (isDisplayed(driver, okButtonErrorFrame_L)) {
					click(driver, okButtonErrorFrame_L);
				}
			}

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(2, "try to save ONHI move by giving 'Y' in SOC field", test, test1);
			Step_Start(3, "Ensure that system should validate as 'SOC IS NOT ALLOWED FOR ONHIRE'.", test, test1);

			waitForPopup(driver, soc_Not_Allowed_Error2, sOCNotAllowedError);

				String actualSOCNotAllowedError = getText(driver, soc_Not_Allowed_Error2);

				if (actualSOCNotAllowedError.equals(sOCNotAllowedError)) {
					System.out.println("Matched || " +sOCNotAllowedError + " Error is displayed ||"+ " Expected Message is : " + sOCNotAllowedError
							+ " || Actual Message is : " + actualSOCNotAllowedError);
					Extent_pass_New(driver, "Matched || "+sOCNotAllowedError + " Error is displayed ||" + " Expected Message is : " + sOCNotAllowedError
							+ " || Actual Message is : " + actualSOCNotAllowedError, test, test1);
					click(driver, okButtonErrorFrame_L);
				} else {
					System.out.println("Not matched || "+sOCNotAllowedError + " Error is not displayed ||" + " Expected Message is : " + sOCNotAllowedError
							+ " || Actual Message  is : " + actualSOCNotAllowedError);
					Extent_fail(driver, "Not matched || "+sOCNotAllowedError + " Error is not displayed ||" + " Expected Message is : " + sOCNotAllowedError
							+ " || Actual Message is : " + actualSOCNotAllowedError, test, test1);
				}
			Step_End(3, "Ensure that system should validate as 'SOC IS NOT ALLOWED FOR ONHIRE'.", test, test1);
			Extent_completed(testCaseName, test, test1);
		
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS066";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_066 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_066, testCaseName, "Dataset"+selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String activityONHI66 = data.get("ActivityONHI");
			String sizeTypeMustPopup = data.get("SizeTypeMustPopup");
			String activityDateSingle66 = data.get("ActivityDate");
			String activityTime_Input1 = data.get("ActivityTime");
			String datePicker = data.get("DatePicker");
			
			Extent_Start(testCaseName, test, test1);
			
			//// To validate size/type mandatory
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
			
			
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
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			// Multiple Equipment Entry

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, activityONHI66);
				waitForDisplay(driver, autoCompleteValue_ME);
				enter(driver);

				if (!activityDateSingle66.equals("")) {
					waitForElement(driver, activeDateField_L);
					if(datePicker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, activeDateField_L, activityDateSingle66);
							
					}else {
						if(activityDateSingle66.contains("-")) {
							String activityDateSingle66_1=activityDateSingle66.replace("-", "/");
							clearAndType(driver, activeDateField_L, activityDateSingle66_1);
							
						}else {
						clearAndType(driver, activeDateField_L, activityDateSingle66);
						
						}		
					}
				}
				
				if (!activityTime_Input1.equals("")) {
					click(driver, activityTimeMultiple);

					waitForElement(driver, Calender);
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);
						
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
				
				Step_Start(2, "Ensure that system should validate if user try to save ONHI move by giving size/type field as blank", test, test1);
				
				Extent_call(test, test1, "Leaving the size/type as blank");	

				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);

			Step_End(2, "Ensure that system should validate if user try to save ONHI move by giving size/type field as blank", test, test1);
			Step_Start(3, "Ensure that system should validate as 'Size/Type must be selected'.", test, test1);

			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);
			waitForPopup(driver, Popup_Message, sizeTypeMustPopup);

				String actualSizeTypeMustPopup = getText(driver, Popup_Message);

				if (actualSizeTypeMustPopup.equals(sizeTypeMustPopup)) {
					System.out.println("Matched || "+sizeTypeMustPopup + " popup is displayed ||" + " Expected Message is : " + sizeTypeMustPopup
							+ " || Actual Message is : "+sizeTypeMustPopup + " popup is displayed ||" + actualSizeTypeMustPopup);
					Extent_pass_New(driver, "Matched || " + " Expected Message is : " + sizeTypeMustPopup
							+ " || Actual Message is : " + actualSizeTypeMustPopup, test, test1);
				} else {
					System.out.println("Not matched || " +sizeTypeMustPopup + " popup is not displayed ||"+ " Expected Message is : " + sizeTypeMustPopup
							+ " || Actual Message  is : "+sizeTypeMustPopup + " popup is not displayed ||" + actualSizeTypeMustPopup);
					Extent_fail(driver, "Not matched || " + " Expected Message is : " + sizeTypeMustPopup
							+ " || Actual Message is : " + actualSizeTypeMustPopup, test, test1);
				}
			Step_End(3, "Ensure that system should validate as 'Size/Type must be selected'.", test, test1);
			Extent_completed(testCaseName, test, test1);
		
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			
			String testCaseName="TC_Movement_Entry_IntegrationTS067";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_033 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_033, testCaseName, "Dataset"+selected_dataset, File_Path);
			String moduleName = data.get("ModuleMovementEntry");
			String datePicker = data.get("datePicker");
			String lodfActivity67 = data.get("LodfActivity");
			String eqpNumMulti = data.get("EqpNumMulti");
			String activityDateSingle67 = data.get("activityDateSingle67");
			String sizeTypeMismatchError = data.get("SizeTypeMismatchError");
			String activityTime_Input1 = data.get("activityTime_Input1");

			Extent_Start(testCaseName, test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);

			// Movement Entry

			// Multiple Equipment Entry

			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForElement(driver, multiEntryMovPage_L);

			waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, lodfActivity67);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				if (!activityDateSingle67.equals("")) {
					waitForElement(driver, MultiActivity_Date);
					if(datePicker.equalsIgnoreCase("Yes")) {
						Extent_call(test, test1, "Entering the date,month & year");
							selectDatePicker(driver, MultiActivity_Date, activityDateSingle67);
					}else {
						if(activityDateSingle67.contains("-")) {
							String activityDateSingle50_1=activityDateSingle67.replace("-", "/");
							clearAndType(driver, MultiActivity_Date, activityDateSingle50_1);
						}else {
						clearAndType(driver, MultiActivity_Date, activityDateSingle67);
						
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

				waitForDisplay(driver, showInputFieldFrame_L);
				if (isdisplayed(driver, showInputFieldFrame_L)) {
					System.out.println("Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed");
					Extent_pass_New(driver, "Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed", test, test1);
				} else {
					System.out.println("Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed");
					Extent_fail(driver, "Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed", test, test1);
				}
				
				Step_Start(1, " Ensure that system should validate if user try to save LODF move by giving incorrect size/type booking which is not matched the size type of container movement", test, test1);
				
				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, data, test, test1);
				
				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);

				waitForElement(driver, selectGridCell_1_L);
				click(driver, selectGridCell_1_L);
				sendKeys(driver, eqpNum_Inputfield, eqpNumMulti);

				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);

			Step_End(1, " Ensure that system should validate if user try to save LODF move by giving incorrect size/type booking which is not matched the size type of container movement", test, test1);
			Step_Start(2, "Ensure that system should validate as 'Size type mismatch with Booking'.", test, test1);
			
			waitForDisplay(driver, forcebtn);
			if(isdisplayed(driver, forcebtn)) {
				click(driver, forcebtn);
			}

			waitForPopup(driver, sizeType_Mismatch_Error, sizeTypeMismatchError);

				String actualSizeTypeError = getText(driver, sizeType_Mismatch_Error);

				if (actualSizeTypeError.equals(sizeTypeMismatchError)) {
					System.out.println("Matched || " +sizeTypeMismatchError + " Error is displayed ||"+ " Expected Message is : " + sizeTypeMismatchError
							+ " || Actual Message is : " + actualSizeTypeError);
					Extent_pass_New(driver, "Matched || " +sizeTypeMismatchError + " Error is displayed ||"+ " Expected Message is : " + sizeTypeMismatchError
							+ " || Actual Message is : " + actualSizeTypeError, test, test1);
				} else {
					System.out.println("Not matched || "+sizeTypeMismatchError + " Error is not displayed ||" + " Expected Message is : " + sizeTypeMismatchError
							+ " || Actual Message  is : " + actualSizeTypeError);
					Extent_fail(driver, "Not matched || "+sizeTypeMismatchError + " Error is not displayed ||" + " Expected Message is : " + sizeTypeMismatchError
							+ " || Actual Message is : " + actualSizeTypeError, test, test1);
				}
				click(driver, okButtonErrorFrame_L);
				Step_End(2, "Ensure that system should validate as 'Size type mismatch with Booking'.", test, test1);
				Extent_completed(testCaseName, test, test1);
			}
		
			scrollTop(driver); waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		
	
	}
}
