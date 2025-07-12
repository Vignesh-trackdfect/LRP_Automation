package LRP_VSS_Consolidation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Long_Term_Creation_LT01_LT06 extends Keywords {
	int i;

	public void createlongterm_01_06(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset)
			throws Exception {

	

		int LT1 = 1;

		if (LT1 == 1) {

			String testcase_Name = "TC_Long_Term_Creation_LT01";
			String URL = TestNgXml.getdatafromExecution().get(testcase_Name);
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Username = data.get("Username");
			String Password = data.get("Password");
			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Proforma_code = data.get("Proforma_code");
			String To_Cycle = data.get("To_Cycle");
			String All_proforma_perform = data.get("All_proforma_perform");
			String Add_Vessels_Perform = data.get("Add_Vessels_Perform");
			String Add_TBN_Vessels_Perform = data.get("Add_TBN_Vessels_Perform");
			String Add_Empty_Vessels_Perform = data.get("Add_Empty_Vessels_Perform");
			String Add_Vessels = data.get("Add_Vessels");
			String Add_TBN_Vessels = data.get("Add_TBN_Vessels");
			String Add_Empty_Vessels = data.get("Add_Empty_Vessels");
			String Add_Voyage_Number = data.get("Add_Voyage_Number");
			String Increment_Voyage = data.get("Increment_Voyage");
			String Search_input_2 = data.get("Search_input_2");
			String Long_term_saved_pop_exp = data.get("Long_term_saved_pop_exp");
			String Proforma_Status = data.get("Proforma_Status");
			String Vessels_verify_perform = data.get("Vessels_verify_perform");
			String Search_input_1 = data.get("Search_input_1");
			String Proforma_Code_search = data.get("Proforma_Code_search");
			String dropdown_Condition = data.get("dropdown_Condition");
			String Vessel_Code_Search = data.get("Vessel_Code_Search");
			String Service_Code_Header = data.get("Service_Code_Header");
			String Condition_Filter = data.get("Condition_Filter");
			String Proforma_Code_Header = data.get("Proforma_Code_Header");
			String Vessel_Code_Header = data.get("Vessel_Code_Header");


			//

			Extent_Start(testcase_Name, test, test1);

			navigateUrl(driver, URL);

			LRP_Login(driver, Username, Password);
			
			
			// searching proforma module in active

			moduleNavigate(driver, Search_input_2);

			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdown_Condition,Proforma_Code_search, Proforma_code, "", "", "", "");
			
			waitForElement(driver, checkstatus);
			String status = getText(driver, checkstatus);
			System.out.println(status);
			Extent_pass_New(driver, "***Status shown as proforma was****" + Proforma_code + "******" + status, test, test1);

			if (Proforma_Status.equals(status)) {
				System.out.println("MATCHED || Expected code is : Activity Code Should be display in the Proforma service creation Screen "+ Proforma_Status +"|| Actual code is : Activity Code is displayed in the Proforma service creation Screen "+ status);
			    Extent_pass_New(driver, "MATCHED || Expected code is : Activity Code Should be display in the Proforma service creation Screen "+ Proforma_Status +"|| Actual code is : Activity Code is displayed in the Proforma service creation Screen "+ status, test, test1);
			} else {
				System.out.println("Not MATCHED || Expected code is : Activity Code Should be display in the Proforma service creation Screen "+ Proforma_Status +"|| Actual code is : Activity Code is  not displayed in the Proforma service creation Screen "+ status);
				Extent_fail(driver, "Not MATCHED || Expected code is : Activity Code Should be display in the Proforma service creation Screen "+ Proforma_Status +"|| Actual code is : Activity Code is  not displayed in the Proforma service creation Screen "+ status, test, test1);

			}
			// Verify the vessles is active
			
			moduleNavigate(driver, Search_input_1);
			
			
			waitForElement(driver, switchButton);
			safeclick(driver, switchButton);
			if (Vessels_verify_perform.equals("YES")) {

				List<String> datas = splitAndExpand(Add_Vessels);
				for (String data1 : datas) {
					
					waitForElement(driver, SearchButton_Toolbar);
					safeclick(driver, SearchButton_Toolbar);
					globalValueSearchWindow(driver, dropdown_Condition, Vessel_Code_Search, data1, "", "", "", "");
					

					waitForElement(driver, vesselCode_In_Vessel);
					String Vesselscode = getAttribute(driver, vesselCode_In_Vessel, "value");
					System.out.println(Vesselscode);
					waitForElement(driver, statusDropDown);
					String Vesselscodestatus = getText(driver, statusDropDown);
					System.out.println(Vesselscodestatus);

				}

			} else {
				System.out.println("Expected Result is : Equipment type should not be added || Actual Result is : Equipment type is not  added");
			}

			// searching for module
			
			moduleNavigate(driver, Search);


			Step_Start(1, "safeclick on new button ", test, test1);
			
			newButton(driver);
		
			Step_End(1, "safeclick on new button ", test, test1);


			waitForElement(driver, Globalsearchservice);
			safeclick(driver, Globalsearchservice);
			
			Step_Start(2, "Enter the service code in service field ", test, test1);
			twoColumnSearchWindow(driver, Service_Code_Header,Condition_Filter, service_select);


			Step_End(2, "Enter the service code in service field ", test, test1);

			// selecting all proforma box
			Step_Start(3, "Select the proforma code from the Proforma code drop down ", test, test1);
			waitForElement(driver, Allproformabox);

			checkBox(driver, Allproformabox, All_proforma_perform);

			waitForElement(driver, PerformaCodeSearch);
			safeclick(driver, PerformaCodeSearch);
			
			twoColumnSearchWindow(driver,Proforma_Code_Header, Condition_Filter, Proforma_code);
			
			
			Step_End(3, "Select the proforma code from the Proforma code drop down", test, test1);
			Step_Start(4, "Enter the number of cycles that each vessel has to be run in the To cycle field", test, test1);
			waitForElement(driver, ToCycle);
			clearAndType(driver, ToCycle, To_Cycle);
			Step_End(4, "Enter the number of cycles that each vessel has to be run in the To cycle field", test, test1);
			Step_Start(5, "safeclick on Vessel Add icon and choose the number of actual vessels needed ", test, test1);
			if (Add_Vessels_Perform.equals("YES")) {

				List<String> datas = splitAndExpand(Add_Vessels);
				for (String data1 : datas) {

					waitForElement(driver, AddVessels);
					safeclick(driver, AddVessels);

					twoColumnSearchWindow(driver,Vessel_Code_Header, Condition_Filter, data1);

				}
			} else {
				System.out.println("Expected Result is : Vessels should not selected || Actual Result is : Vessel is not selected ");
			}

			Step_End(5, "safeclick on Vessel Add icon and choose the number of actual vessels needed ", test, test1);
			Step_Start(6,
					"If the voyage needs To-be Notifed vessels. Enter the number of TBN vessels in the field and safeclick on Add icon",
					test, test1);
			if (Add_TBN_Vessels_Perform.equals("YES")) {
				waitForElement(driver, NOOFTBM);
				safeclick(driver, NOOFTBM);

				waitForElement(driver, NOOFTBMInput);
				clearAndType(driver, NOOFTBMInput, Add_TBN_Vessels);
				waitForElement(driver, NOOFTBMInputAdd);
				safeclick(driver, NOOFTBMInputAdd);

			} else {
				System.out.println("Expected Result is : TBM Vessels should not selected || Actual Result is : TBM Vessel is not selected ");

			}

			Step_End(6,
					"If the voyage needs To-be Notifed vessels. Enter the number of TBN vessels in the field and safeclick on Add icon",
					test, test1);
			Step_Start(7,
					"f the voyage needs blank vessels. Enter the number of Blank vessels in the field and safeclick on Add icon",
					test, test1);
			if (Add_Empty_Vessels_Perform.equals("YES")) {
				waitForElement(driver, NOOFTBMEMTY);
				safeclick(driver, NOOFTBMEMTY);

				waitForElement(driver, NOOFTBMInputEMTY);
				clearAndType(driver, NOOFTBMInputEMTY, Add_Empty_Vessels);
				waitForElement(driver, NOOFTBMInputAddEMTY);
				safeclick(driver, NOOFTBMInputAddEMTY);

			} else {
				System.out.println("Expected Result is : Empty Vessels should not selected || Actual Result is : Empty Vessel is not selected ");

			}
			Step_End(7,
					"f the voyage needs blank vessels. Enter the number of Blank vessels in the field and safeclick on Add icon",
					test, test1);

			Step_Start(8, "Enter the Voyage number for the each vessel added ", test, test1);

			waitForElement(driver, Voyagenumberinput);

			try {

				List<WebElement> Selected_Data = listOfElements(driver, voyage_input);

				List<String> datas = splitAndExpand(Add_Voyage_Number);

				for (int i = 0; i < Selected_Data.size(); i++) {
					waitForElement(driver, Voyagenumberinput);

					Click(driver, Selected_Data.get(i));
					Selected_Data.get(i).sendKeys(datas.get(i));
					waitForElement(driver, Voyagenumberinput);
					Click(driver, Selected_Data.get(i));

				}

			} catch (Exception e) {
				Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

			}
			Step_End(8, "Enter the Voyage number for the each vessel added ", test, test1);
			waitForElement(driver, afterclick);
			safeclick(driver, afterclick);
			Step_Start(9, "Enter the number to be added to the voyage number for the next cycle voyage of the same vessel ",
					test, test1);
			waitForElement(driver, Voyagenumberinput);
			try {

				List<WebElement> Selected_Data1 = listOfElements(driver, INcrement_voyage_input);

				List<String> datas1 = splitAndExpand(Increment_Voyage);
				System.out.println("data: " + datas1.get(0));
				for (int i = 0; i < Selected_Data1.size(); i++) {
					Click(driver, Selected_Data1.get(i));
					Newclear_Type(driver);
					Selected_Data1.get(i).sendKeys(Keys.ENTER);
					waitForElement(driver, Voyagenumberinput);
					Selected_Data1.get(i).sendKeys(datas1.get(i) + Keys.ENTER);
					waitForElement(driver, Voyagenumberinput);

				}
			} catch (Exception e) {
				Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

			}
			Step_End(9, "Enter the number to be added to the voyage number for the next cycle voyage of the same vessel ",
					test, test1);
			Step_Start(10, "safeclick on Make Long Term", test, test1);
			waitForElement(driver, Makelongterm);
			safeclick(driver, Makelongterm);

			Step_End(10, "safeclick on Make Long Term", test, test1);
			Step_Start(12, "safeclick on save button", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			scrollBottom(driver);
			Step_End(12, "safeclick on save button", test, test1);

			waitForPopup(driver, popup_Message, Long_term_saved_pop_exp);
			String savedpopAct = getText(driver, popup_Message);
			System.out.println(savedpopAct);
			if (Long_term_saved_pop_exp.equals(savedpopAct)) {
				System.out.println("Matched || " + " Expected popup is : " + Long_term_saved_pop_exp
						+ " || Actual popup is : " + savedpopAct);
				Extent_pass_New(driver, "Matched || " + " Expected popup is : " + Long_term_saved_pop_exp
						+ " || Actual popup is : " + savedpopAct, test, test1);
			} else {
				System.out.println("Not matched || " + " Expected popup is : " + Long_term_saved_pop_exp
						+ " || Actual popup is : " + savedpopAct);
				Extent_fail(driver, "Not matched || " + " Expected popup is : " + Long_term_saved_pop_exp
						+ " || Actual popup is : " + savedpopAct, test, test1);

			}

			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			
			String Long_number = getAttribute(driver, Long_term_Number, "value");
			System.out.println(Long_number);
			Extent_call(test, test1, "****Long_term number was created as*** " + Long_number);

			scrollBottom(driver);

			Step_Start(11,
					"System should create the number of voyages which equals total number of cycles multiplied with the total number of vessels",
					test, test1);
			waitForElement(driver, vessels_code);
			List<WebElement> vessel_Codes11 = listOfElements(driver, vessels_code);
			for (WebElement Vessel_Code1 : vessel_Codes11) {

				waitForElement(driver, Vessel_Code1);
				Click(driver, Vessel_Code1);

			}
			Step_End(11,
					"System should create the number of voyages which equals total number of cycles multiplied with the total number of vessels",
					test, test1);
			Extent_completed(testcase_Name, test, test1);
		}

		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		int LT2 = 2;

		if (LT2 == 2) {
			String testcase_Name = "TC_Long_Term_Creation_LT02";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Add_Vessels_Perform = data.get("Add_Vessels_Perform");
			String Add_TBN_Vessels_Perform = data.get("Add_TBN_Vessels_Perform");
			String Add_Empty_Vessels_Perform = data.get("Add_Empty_Vessels_Perform");
			String Add_Vessels = data.get("Add_Vessels");
			String copy_Voyage_Number = data.get("Copy_Voyage");
			String Copy_pop_exp = data.get("Copy_pop_exp");
			String Past_Pop_Exp = data.get("Past_Pop_Exp");
			String selected_vessels_Perform = data.get("selected_vessels_Perform");
			String selected_vessels_input = data.get("selected_vessels_input");
			String cycle_checkbox_perform = data.get("cycle_checkbox_perform");
			String Date_checkbox_perform = data.get("Date_checkbox_perform");
			String voyage_checkbox_perform = data.get("voyage_checkbox_perform");
			String show_all_cells_checkbox_perform = data.get("show_all_cells_checkbox_perform");
			String show_draft_cells_checkbox_perform = data.get("show_draft_cells_checkbox_perform");
			String show_conform_cells_checkbox_perform = data.get("show_conform_cells_checkbox_perform");
			String show_Actual_conform_cells_checkbox_perform = data.get("show_Actual_conform_cells_checkbox_perform");
			String show_omitted_cells_checkbox_perform = data.get("show_omitted_cells_checkbox_perform");
			String To_cycle_input = data.get("To_cycle_input");
			String From_cycle_input = data.get("From_cycle_input");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");
			String To_voyage_perform = data.get("To_voyage_perform");
			String From_Voyage_Perform = data.get("From_Voyage_Perform");
			String From_voyage_Input = data.get("From_voyage_Input");
			String To_voyage_Input = data.get("To_voyage_Input");
			String Vessels_Code = data.get("Vessels_Code");
			String Service_Code_Header = data.get("Service_Code_Header");
			String Vessel_Code_Header = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header = data.get("From_Voyage_Number_Header");
			String To_Voyage_Number_Header = data.get("To_Voyage_Number_Header");
			String Condition_Filter = data.get("Condition_Filter");
			String Add_Vessel_Code_Header = data.get("Add_Vessel_Code_Header");
			String date_Picker = data.get("date_Picker");
			
			
			
			String ReferenceType_Select1_d = String.format(ReferenceType_Select1, Voyage_Number);
			String ReferenceType_Select2_d = String.format(ReferenceType_Select2, Voyage_Number);
			String ReferenceType_Select3_d = String.format(ReferenceType_Select3, copy_Voyage_Number);

			Extent_Start(testcase_Name, test, test1);
			// searching for module

			
			moduleNavigate(driver, Search);
			
			
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			Step_Start(1, "Retirve the Record via Global Search  ", test, test1);
			waitForElement(driver, searchIconLT);
			safeclick(driver, searchIconLT);
			
			twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);
			
			Step_End(1, "Retirve the Record via Global Search  ", test, test1);

			// selecting the selected vessels
			if (selected_vessels_Perform.equals("YES")) {
				waitForElement(driver, selected_Vessel_Button);
				safeclick(driver, selected_Vessel_Button);
				waitForElement(driver, Addselectedvessels);
				safeclick(driver, Addselectedvessels);
				
				twoColumnSearchWindow(driver, Vessel_Code_Header, Condition_Filter, selected_vessels_input);

			}

			waitForElement(driver, cycle_check_box);
			checkBox(driver, cycle_check_box, cycle_checkbox_perform);
			waitForElement(driver, voyage_check_box);
			checkBox(driver, voyage_check_box, voyage_checkbox_perform);
			waitForElement(driver, showallcells_check_box);
			checkBox(driver, showallcells_check_box, show_all_cells_checkbox_perform);
			waitForElement(driver, showdraftcells_check_box);
			checkBox(driver, showdraftcells_check_box, show_draft_cells_checkbox_perform);
			waitForElement(driver, showconformtcells_check_box);
			checkBox(driver, showconformtcells_check_box, show_conform_cells_checkbox_perform);
			waitForElement(driver, showactualconformtcells_check_box);
			checkBox(driver, showactualconformtcells_check_box, show_Actual_conform_cells_checkbox_perform);
			waitForElement(driver, showomittedcells_check_box);
			checkBox(driver, showomittedcells_check_box, show_omitted_cells_checkbox_perform);

			// From cycle input
			if (!From_cycle_input.equals("")) {
				waitForElement(driver, From_cycle);
				clearAndType(driver, From_cycle, From_cycle_input);
			}

			// To cycle input
			if (!To_cycle_input.equals("")) {
				waitForElement(driver, To_cycle);
				clearAndType(driver, To_cycle, To_cycle_input);
			}

			checkBox(driver, Date_check_box, Date_checkbox_perform);
			
			
			// Selecting the From Date

					waitForElement(driver, From_date_LT);
					if (date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, From_date_LT, From_Date_Input);
					} else {
						waitForElement(driver, From_date_LT);
						clearAndType(driver, From_date_LT, From_Date_Input);
					}
					// Selecting the to Date
					waitForElement(driver, To_Date_LT);
					if (date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, To_Date_LT, To_Date_Input);
					} else {
						waitForElement(driver, To_Date_LT);
						clearAndType(driver, To_Date_LT, To_Date_Input);
					}
			
			


			if (From_Voyage_Perform.equals("YES")) {
				waitForElement(driver, From_voyage_search);
				safeclick(driver, From_voyage_search);
				
				twoColumnSearchWindow(driver, From_Voyage_Number_Header, Condition_Filter, From_voyage_Input);

			}
			
			if (To_voyage_perform.equals("YES")) {
				waitForElement(driver, To_voyage_search);
				safeclick(driver, To_voyage_search);
				twoColumnSearchWindow(driver, To_Voyage_Number_Header, Condition_Filter, To_voyage_Input);
				

			}

			waitForElement(driver, LongTermsearchOk);
			safeclick(driver, LongTermsearchOk);

			Step_Start(2, "Click on Edit button", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);
			waitForElement(driver, Edit_Button_toolBar);

			Step_End(2, "Click on Edit button", test, test1);
			scrollBottom(driver);
			try {
				i = 1;
				waitForElement(driver, vessels_code);

				List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);

				for (WebElement Vessel_Code : vessel_Codes) {
					System.out.println("i : " + i);
					waitForElement(driver, Vessel_Code);

					Click(driver, Vessel_Code);

					if (Vessels_Code.equals(Vessel_Code.getText())) {
						String num = String.valueOf(i);
						String voyage_Num = String.format(voyage_Num_l, num);

						System.out.println(getText(driver, voyage_Num));
						System.out.println(Voyage_Number);
						System.out.println(voyage_Num);
						if (Voyage_Number.equals(getText(driver, voyage_Num))) {

							click(driver, voyage_Num);

							waitForElement(driver, voyage_Num);

							RightClick(driver, voyage_Num);

							// Adding vessels
							waitForDisplay(driver, optionsBox);
							if (isDisplayed(driver, optionsBox)) {
								System.out.println("The expected Result is : Once user right click on the voyage, options Menu bar should be displayed || Acutal result is : Once user right click on the voyage, options Menu bar is displayed");
								Extent_pass_New(driver, "The expected Result is : Once user right click on the voyage, options Menu bar should be displayed || Acutal result is : Once user right click on the voyage, options Menu bar is displayed", test, test1);
								scrollUsingElement(driver, renameLT);
								mouseOverToElement(driver, renameLT);
							} else {
								System.out.println("The expected Result is : Once user right click on the voyage, options Menu bar should be displayed || Acutal result is : Once user right click on the voyage, options Menu bar is not displayed");
								Extent_fail(driver, "The expected Result is : Once user right click on the voyage, options Menu bar should be displayed || Acutal result is : Once user right click on the voyage, options Menu bar is not displayed", test, test1);

							}

							waitForDisplay(driver, addVessel);
							if (isDisplayed(driver, addVessel)) {
								System.out.println("The expected Result is : Once user mousehover on the rename option, options sub Menu bar should be displayed || Acutal result is : Once user mousehover on the rename option, options sub Menu bar should be displayed");
								Extent_pass_New(driver, "The expected Result is : Once user mousehover on the rename option, options sub Menu bar should be displayed || Acutal result is : Once user mousehover on the rename option, options sub Menu bar should be displayed", test, test1);
								safeclick(driver, addVessel);
							} else {
								System.out.println("The expected Result is : Once user mousehover on the rename option, options sub Menu bar should be displayed || Acutal result is : Once user mousehover on the rename option, options sub Menu bar is not displayed");
								Extent_fail(driver, "The expected Result is : Once user mousehover on the rename option, options sub Menu bar should be displayed || Acutal result is : Once user mousehover on the rename option, options sub Menu bar is not displayed", test, test1);

							}

							if (Add_Vessels_Perform.equals("YES")) {
								if (Add_Vessels_Perform.equals("YES")) {
									waitForElement(driver, Addvesseslssearch);
									safeclick(driver, Addvesseslssearch);
									twoColumnSearchWindow(driver, Add_Vessel_Code_Header, Condition_Filter, Add_Vessels);
	                                System.out.println("Expected Result: Vessel should be selected as  " + Add_Vessels + "|| Actual Result: Vessel selected as "+ Add_Vessels);
									Extent_pass_New(driver, "Expected Result: Vessel should be selected as  " + Add_Vessels + "|| Actual Result: Vessel selected as "+ Add_Vessels, test, test1);
									waitForElement(driver, select);
									safeclick(driver, select);
									waitForElement(driver, vesselRenameOkButton);
									safeclick(driver, vesselRenameOkButton);

									scrollBottom(driver);
									waitForElement(driver, ReferenceType_Select1_d);
									click(driver, ReferenceType_Select1_d);
									System.out.println("Expected Result :Vessels should be added as "+ Add_Vessels +" || Actual Result : Vessel is added as "+ Add_Vessels);
									Extent_pass_New(driver, "Expected Result :Vessels should be added as "+ Add_Vessels +" || Actual Result : Vessel is added as "+ Add_Vessels, test, test1);

								} else {
									System.out.println("Expected Result :Vessels should be added as "+ Add_Vessels +" || Actual Result : Vessel is not added as "+ Add_Vessels);
									Extent_fail(driver, "Expected Result :Vessels should be added as "+ Add_Vessels +" || Actual Result : Vessel is not added as "+ Add_Vessels, test, test1);

								}
							}
							if (Add_TBN_Vessels_Perform.equals("YES")) {
								if (Add_TBN_Vessels_Perform.equals("YES")) {
									waitForElement(driver, TBMradiobtnclick);
									safeclick(driver, TBMradiobtnclick);
									waitForElement(driver, vesselRenameOkButton);
									safeclick(driver, vesselRenameOkButton);
									waitForElement(driver, ReferenceType_Select1_d);
									click(driver, ReferenceType_Select1_d);
									System.out.println("Expected Result: Vessel should be added as [TBN]  || Actual Result: Vessel is added as [TBN] ");
									Extent_pass_New(driver, "Expected Result: Vessel should be added as [TBN]  || Actual Result: Vessel is added as [TBN] ", test, test1);
								} else {
									System.out.println("Expected Result: Vessel should be added as [TBN]  || Actual Result: Vessel is not added as [TBN] ");
									Extent_fail(driver, "Expected Result: Vessel should be added as [TBN]  || Actual Result: Vessel is not added as [TBN] ", test, test1);
								}
							}

							if (Add_Empty_Vessels_Perform.equals("YES")) {
								if (Add_Empty_Vessels_Perform.equals("YES")) {
									waitForElement(driver, blankRadioButton);
									safeclick(driver, blankRadioButton);
									Extent_pass_New(driver, "*******Vessels was selected as [Empty vessels]***", test, test1);
									waitForElement(driver, vesselRenameOkButton);
									safeclick(driver, vesselRenameOkButton);

									scrollBottom(driver);
									waitForElement(driver, ReferenceType_Select2_d);
									click(driver, ReferenceType_Select2_d);


								} else {
									System.out.println("Expected Result is : Blank Vessel should not selected || Actual Result is : Blank Vessel is not selected");
									Extent_fail(driver, "Expected Result is : Blank Vessel should not added as [Empty Vessel] || Actual Result is : Blank Vessel is not added as [Empty Vessel]", test, test1);
								}
							}

							// copy the vessels
							Step_Start(3, "Click on the Voyage which needed to be copied(Draft/Confirmed)", test, test1);

							Step_Start(4, "Right click on the Added or Blank Vessel without the voyage ", test, test1);
							waitForElement(driver, ReferenceType_Select3_d);
							click(driver, ReferenceType_Select3_d);

							RightClick(driver, ReferenceType_Select3_d);

							Step_End(4, "Right click on the Added or Blank Vessel without the voyage ", test, test1);
							if (isDisplayed(driver, optionsBox)) {
								System.out.println("The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is displayed");
								Extent_pass_New(driver, "The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is displayed", test, test1);
								scrollUsingElement(driver, cutCopyPasteRemove);
								Step_Start(5, "Choose Cut/Copy/Paste From the menu", test, test1);
								mouseOverToElement(driver, cutCopyPasteRemove);
							} else {
								System.out.println("The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is not displayed");
								Extent_fail(driver, "The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is not displayed", test, test1);
							}
							Step_End(5, "Choose Cut/Copy/Paste From the menu", test, test1);

							if (isDisplayed(driver, subMenuCopyPaste)) {
								System.out.println("The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is displayed");
								Extent_pass_New(driver, "The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is displayed", test, test1);
								Step_Start(6, "Choose Paste option ", test, test1);
								waitForElement(driver, copyInSubMenu);
								safeclick(driver, copyInSubMenu);
							} else {
								System.out.println("The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is not displayed");
								Extent_fail(driver, "The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is not displayed", test, test1);
							}

							Step_End(6, "Choose Paste option ", test, test1);

							waitForPopup(driver, popup_Message, Copy_pop_exp);
							String Copypopact = getText(driver, popup_Message);
							System.out.println(Copypopact);
							if (Copy_pop_exp.equals(Copypopact)) {
								System.out.println("Matched || " + " Expected Activity is : " + Copypopact
										+ " || Actual Activity is : " + Copy_pop_exp);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Copypopact
										+ " || Actual Activity is : " + Copy_pop_exp, test, test1);
								Extent_pass_New(driver, "***Voyage was selected to copy as***" + copy_Voyage_Number, test,
										test1);
							} else {
								System.out.println("Not matched || " + " Expected Activity is : " + Copypopact
										+ " || Actual Activity is : " + Copy_pop_exp);
								Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Copypopact
										+ " || Actual Activity is : " + Copy_pop_exp, test, test1);
							}
							safeclick(driver, popup_Message_Ok_Button);

							Step_End(3, "Click on the Voyage which needed to be copied(Draft/Confirmed)", test, test1);
							// Past A voyage

							click(driver, ReferenceType_Select1_d);

							RightClick(driver, ReferenceType_Select1_d);
							waitForDisplay(driver, optionsBox);

							if (isDisplayed(driver, optionsBox)) {
								System.out.println("The expected Result is : Once user right click on the Voyage options Menu bar should be displayed || Acutal result is : Once user right click on the Voyage Options Menu bar is displayed");
								Extent_pass_New(driver, "The expected Result is : Once user right click on the Voyage options Menu bar should be displayed || Acutal result is : Once user right click on the Voyage Options Menu bar is displayed", test, test1);
								scrollUsingElement(driver, cutCopyPasteRemove);
								mouseOverToElement(driver, cutCopyPasteRemove);
							} else {
								System.out.println("The expected Result is : Once user right click on the Voyage options Menu bar should be displayed || Acutal result is : Once user right click on the Voyage Options Menu bar is not displayed");
								Extent_fail(driver, "The expected Result is : Once user right click on the Voyage options Menu bar should be displayed || Acutal result is : Once user right click on the Voyage Options Menu bar is  not displayed", test, test1);
							}

							waitForDisplay(driver, subMenuCopyPaste);
							if (isDisplayed(driver, subMenuCopyPaste)) {
								System.out.println("The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is displayed");
								Extent_pass_New(driver, "The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is displayed", test, test1);
								safeclick(driver, pasteInSubMenu);
							} else {
								System.out.println("The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is not displayed");
								Extent_fail(driver, "The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is not displayed", test, test1);
							}

							Step_Start(7, ".Now the copied voyage will be pasted on the vessel", test, test1);

							Step_Start(8, "System should show validation “Voyage Pasted”", test, test1);
							waitForPopup(driver, popup_Message, Past_Pop_Exp);
							String pastedpopact = getText(driver, popup_Message);
							System.out.println(pastedpopact);
							if (Past_Pop_Exp.equals(pastedpopact)) {
								System.out.println("Matched || " + " Expected Popup is : " + Past_Pop_Exp
										+ " || Actual Popup is : " + pastedpopact);
								Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Past_Pop_Exp
										+ " || Actual Popup is : " + pastedpopact, test, test1);
							} else {
								System.out.println("Not matched || " + " Expected Popup is : " + Past_Pop_Exp
										+ " || Actual Popup is : " + pastedpopact);
								Extent_fail(driver, "Not matched || " + " Expected Popup is : " + Past_Pop_Exp
										+ " || Actual Popup is : " + pastedpopact, test, test1);

							}
							safeclick(driver, popup_Message_Ok_Button);
							waitForElement(driver, ReferenceType_Select1_d);
							click(driver, ReferenceType_Select1_d);

							System.out.println("Expected Result is: Voyage should be pasted as "+ copy_Voyage_Number + " || Actual Result is : Voyage is pasted as "+ copy_Voyage_Number);
							Extent_pass_New(driver, "Expected Result is: Voyage should be pasted as "+ copy_Voyage_Number + " || Actual Result is : Voyage is pasted as "+ copy_Voyage_Number, test, test1);

							Step_End(7, ".Now the copied voyage will be pasted on the vessel", test, test1);
							Step_End(8, "System should show validation “Voyage Pasted”", test, test1);
							break;
						}
					}

					i++;
				}
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

		}			
			
			Extent_completed(testcase_Name, test, test1);
		}

		scrollTop(driver);

		click(driver, Close_Current_tab);

		int LT3 = 3;

		if (LT3 == 3) {
			String testcase_Name="TC_Long_Term_Creation_LT03";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name,
					"Dataset" + selected_dataset, File_Path);


			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Pop_up_for_confirm  = data.get("Pop_up_for_confirm");
			String Voyage_Confirmed_popEXP  = data.get("Voyage_Confirmed_pop");
			String Vessels_Code  = data.get("Vessels_Code");
			String selected_vessels_Perform  = data.get("selected_vessels_Perform");
			String selected_vessels_input  = data.get("selected_vessels_input");
			String cycle_checkbox_perform  = data.get("cycle_checkbox_perform");
			String Date_checkbox_perform  = data.get("Date_checkbox_perform");
			String voyage_checkbox_perform  = data.get("voyage_checkbox_perform");
			String show_all_cells_checkbox_perform  = data.get("show_all_cells_checkbox_perform");
			String show_draft_cells_checkbox_perform  = data.get("show_draft_cells_checkbox_perform");
			String show_conform_cells_checkbox_perform  = data.get("show_conform_cells_checkbox_perform");
			String show_Actual_conform_cells_checkbox_perform  = data.get("show_Actual_conform_cells_checkbox_perform");
			String show_omitted_cells_checkbox_perform  = data.get("show_omitted_cells_checkbox_perform");
			String To_cycle_input  = data.get("To_cycle_input");
			String From_cycle_input  = data.get("From_cycle_input");
			String From_Date_Input  = data.get("From_Date_Input");
			String To_Date_Input  = data.get("To_Date_Input");
			String To_voyage_perform  = data.get("To_voyage_perform");
			String From_Voyage_Perform  = data.get("From_Voyage_Perform");
			String From_voyage_Input  = data.get("From_voyage_Input");
			String To_voyage_Input  = data.get("To_voyage_Input");
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");


			Extent_Start(testcase_Name, test, test1);


		
			// searching for module

			moduleNavigate(driver, Search);
			Step_Start(1, "Retirve the Record via Global Search ",test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			waitForElement(driver, searchIconLT);
			safeclick(driver, searchIconLT);
			Step_End(1, "Retirve the Record via Global Search  ",test, test1);
			Step_Start(2, "Enter the Service Code in the Service Code field ",test, test1);
			
			twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);

			Step_End(2, "Enter the Service Code in the Service Code field",test, test1);
			Step_Start(3, "Click on Ok button ",test, test1);
			Step_End(3, "Click on Ok button  ",test, test1);


			// selecting the selected vessels
					if (selected_vessels_Perform.equals("YES")) {
						waitForElement(driver, selected_Vessel_Button);
						safeclick(driver, selected_Vessel_Button);
						waitForElement(driver, Addselectedvessels);
						safeclick(driver, Addselectedvessels);
						
						twoColumnSearchWindow(driver, Vessel_Code_Header, Condition_Filter, selected_vessels_input);

					}		

			waitForElement(driver, cycle_check_box);
			checkBox(driver, cycle_check_box, cycle_checkbox_perform);
			waitForElement(driver, voyage_check_box);
			checkBox(driver, voyage_check_box, voyage_checkbox_perform);
			waitForElement(driver, showallcells_check_box);
			checkBox(driver, showallcells_check_box, show_all_cells_checkbox_perform);
			waitForElement(driver, showdraftcells_check_box);
			checkBox(driver, showdraftcells_check_box, show_draft_cells_checkbox_perform);
			waitForElement(driver, showconformtcells_check_box);
			checkBox(driver, showconformtcells_check_box, show_conform_cells_checkbox_perform);
			waitForElement(driver, showactualconformtcells_check_box);
			checkBox(driver, showactualconformtcells_check_box, show_Actual_conform_cells_checkbox_perform);
			waitForElement(driver, showomittedcells_check_box);
			checkBox(driver, showomittedcells_check_box, show_omitted_cells_checkbox_perform);

			// From cycle input 
			if(!From_cycle_input.equals("")) {
				waitForElement(driver, From_cycle);
				clearAndType(driver, From_cycle, From_cycle_input);
			}

			// To cycle input 
			if(!To_cycle_input.equals("")) {
				waitForElement(driver, To_cycle);
				clearAndType(driver, To_cycle, To_cycle_input);
			}
			checkBox(driver, Date_check_box, Date_checkbox_perform);
			
			
			
			
			// Selecting the From Date

			waitForElement(driver, From_date_LT);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, From_date_LT, From_Date_Input);
			} else {
				waitForElement(driver, From_date_LT);
				clearAndType(driver, From_date_LT, From_Date_Input);
			}
			// Selecting the to Date
			waitForElement(driver, To_Date_LT);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, To_Date_LT, To_Date_Input);
			} else {
				waitForElement(driver, To_Date_LT);
				clearAndType(driver, To_Date_LT, To_Date_Input);
			}




			if (From_Voyage_Perform.equals("YES")) {
				waitForElement(driver, From_voyage_search);
				safeclick(driver, From_voyage_search);
				
				twoColumnSearchWindow(driver, From_Voyage_Number_Header, Condition_Filter, From_voyage_Input);

			}
			
			
			if (To_voyage_perform.equals("YES")) {
				waitForElement(driver, To_voyage_search);
				safeclick(driver, To_voyage_search);
				twoColumnSearchWindow(driver, To_Voyage_Number_Header, Condition_Filter, To_voyage_Input);
				

			}

			waitForElement(driver, LongTermsearchOk);
			safeclick(driver, LongTermsearchOk);
			Step_Start(4, "Click on edit button",test, test1);
			
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);
			waitForElement(driver, Edit_Button_toolBar);
			Step_End(4, "Click on edit button ",test, test1);
			scrollBottom(driver);





			List<String> firstHeaders = splitAndExpand1(Vessels_Code);
			List<String> secondHeaders = splitAndExpand1(Voyage_Number);

			Actions actions = new Actions(driver);
			int i = 0;
			for(String firstHeader : firstHeaders) {
				// Locate the table headers
				waitForElement(driver, vessel_Code_Header_LT);

				List<WebElement> tableHeaders = listOfElements(driver, vessel_Code_Header_LT);
				List<WebElement> vessel_Codes = listOfElements(driver, Vessel_Codes_LT);

				// Loop through both header lists

				for (int j=0;j<tableHeaders.size();j++) {
					// Get the current headers for comparison
					String firstTableHeader = tableHeaders.get(j).getText(); // First column header
					String secondTableHeader = vessel_Codes.get(j).getText(); // Second column header

					// Check for matches
					if (firstTableHeader.equals(firstHeaders.get(i)) && secondTableHeader.equals(secondHeaders.get(i))) {
			 // Perform control-click on first headers
						WebElement headerElement = tableHeaders.get(j);
						actions.keyDown(Keys.CONTROL).click(headerElement).keyUp(Keys.CONTROL).perform();

						// Right-click on one of the selected headers (you can choose one of the selected elements)
						i++;
						if(i==firstHeaders.size()) {
							break;
						}
						// Add any additional actions you want to perform after the right-click
					} 
				}
				if(i==firstHeaders.size()) {
					break;
				}
			}
			String rightClickElement = String.format(Voy_Num_LT, secondHeaders.get(0));

			waitForElement(driver, rightClickElement);
			RightClick(driver, rightClickElement);
			Step_End(5, "Right Click on the Draft voyage (Indicating in blue color) ",test, test1);
			Step_Start(6, "Choose Confirm Option ",test, test1);
							waitForElement(driver, Conformbtnlongterm);
							safeclick(driver, Conformbtnlongterm);
							
							Step_End(6, "Choose Confirm Option",test, test1);
							Step_Start(7, "System should show a pop message of confirming to user to change the status ",test, test1);
							waitForPopup(driver, popup_Message, Pop_up_for_confirm);
							String wantconformAct=getText(driver, popup_Message);
							System.out.println(wantconformAct);
									if (wantconformAct.equals(Pop_up_for_confirm)) {
										System.out
												.println("Matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct);
										Extent_pass_New(driver,
												"Matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct,test,test1);
									} else {
										System.out.println(
												"Not matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct);
										Extent_fail(driver,
												"Not matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct,test,test1);
										
									}
									waitForElement(driver, popup_Message_Yes_Button);
									safeclick(driver, popup_Message_Yes_Button);
							
							
								
									if(isDisplayed(driver, continuebutton)) {
										waitForElement(driver, continuebutton);
										safeclick(driver, continuebutton);
										}else {
											System.out.println("Expected Result is : Continue Button should not diplayed ||  Actual Result is : Continue Button is not diplayed");
										}
									Step_End(7, "System should show a pop message of confirming to user to change the status  ",test, test1);
									
							waitForElement(driver, popup_Message_Ok_Button);
							Step_Start(9, "System should show a pop up message of “Voyage Confirmed”",test, test1);
							Step_Start(10, "verify that that should be white colour ang have popup for that validation.",test, test1);
							waitForPopup(driver, popup_Message, Voyage_Confirmed_popEXP);
							String Voyage_Confirmed_popAct =getText(driver, popup_Message);
							System.out.println(Voyage_Confirmed_popAct);

							if (Voyage_Confirmed_popEXP.equals(Voyage_Confirmed_popAct)) {
								System.out
										.println("Matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct);
								Extent_pass_New(driver,
										"Matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct,test,test1);
								Extent_pass_New(driver, "**********Voyage was conformed and background was changed to white colour********", test, test1);
							} else {
								System.out.println(
										"Not matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct);
								Extent_fail(driver,
										"Not matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct,test,test1);
								
							}
							Step_End(9, "System should show a pop up message of “Voyage Confirmed” ",test, test1);
							waitForElement(driver, popup_Message_Ok_Button);
							safeclick(driver, popup_Message_Ok_Button);
							
						    	Step_Start(8, "Clicking on ok should turn voyage color to White",test, test1);
							
							Extent_pass_New(driver, "***Voayage was selected to confirm id*****"+Voyage_Number, test, test1);
							Extent_pass_New(driver, "**********Voyage was conformed and background was changed to white colour********", test, test1);
							Step_End(8, "Clicking on ok should turn voyage color to White",test, test1);
							Step_End(10, "verify that that should be white colour ang have popup for that validation.",test, test1);
							Extent_completed(testcase_Name, test, test1);
		}

		scrollTop(driver);

		click(driver, Close_Current_tab);

		int LT4 = 4;

		if (LT4 == 4) {
			String testcase_Name = "TC_Long_Term_Creation_LT04";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Add_Vessels_Perform = data.get("Add_Vessels_Perform");
			String Add_TBN_Vessels_Perform = data.get("Add_TBN_Vessels_Perform");
			String Add_Empty_Vessels_Perform = data.get("Add_Empty_Vessels_Perform");
			String Add_Vessels = data.get("Add_Vessels");
			String Future_Cycle_Perform = data.get("Future_Cycle_Perform");
			String Future_Renamed_Pop_Exp = data.get("Future_Renamed_Pop_Exp");
			String Current_Renamed_Pop_Exp = data.get("Current_Renamed_Pop_Exp");
			String Vessels_Code = data.get("Vessels_Code");
			String selected_vessels_Perform = data.get("selected_vessels_Perform");
			String selected_vessels_input = data.get("selected_vessels_input");
			String cycle_checkbox_perform = data.get("cycle_checkbox_perform");
			String Date_checkbox_perform = data.get("Date_checkbox_perform");
			String voyage_checkbox_perform = data.get("voyage_checkbox_perform");
			String show_all_cells_checkbox_perform = data.get("show_all_cells_checkbox_perform");
			String show_draft_cells_checkbox_perform = data.get("show_draft_cells_checkbox_perform");
			String show_conform_cells_checkbox_perform = data.get("show_conform_cells_checkbox_perform");
			String show_Actual_conform_cells_checkbox_perform = data.get("show_Actual_conform_cells_checkbox_perform");
			String show_omitted_cells_checkbox_perform = data.get("show_omitted_cells_checkbox_perform");
			String To_cycle_input = data.get("To_cycle_input");
			String From_cycle_input = data.get("From_cycle_input");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");
			String To_voyage_perform = data.get("To_voyage_perform");
			String From_Voyage_Perform = data.get("From_Voyage_Perform");
			String From_voyage_Input = data.get("From_voyage_Input");
			String To_voyage_Input = data.get("To_voyage_Input");
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");
			String Vessel_Code_Header_Rename  = data.get("Vessel_Code_Header_Rename");

	//

			Extent_Start(testcase_Name, test, test1);

			// searching for module
			moduleNavigate(driver, Search);

			
			Step_Start(1, "Retirve the Record via Global Search ", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			waitForElement(driver, searchIconLT);
			safeclick(driver, searchIconLT);
			Step_End(1, "Retirve the Record via Global Search  ", test, test1);
			Step_Start(2, "Enter the Service Code in the Service Code field ", test, test1);
			twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);

			Step_End(2, "Enter the Service Code in the Service Code field", test, test1);
			Step_Start(3, "Click on Ok button ", test, test1);
			Step_End(3, "Click on Ok button  ", test, test1);

			// selecting the selected vessels
			if (selected_vessels_Perform.equals("YES")) {
				waitForElement(driver, selected_Vessel_Button);
				safeclick(driver, selected_Vessel_Button);
				waitForElement(driver, Addselectedvessels);
				safeclick(driver, Addselectedvessels);
				
				twoColumnSearchWindow(driver, Vessel_Code_Header, Condition_Filter, selected_vessels_input);

			}	

			waitForElement(driver, cycle_check_box);
			checkBox(driver, cycle_check_box, cycle_checkbox_perform);
			waitForElement(driver, voyage_check_box);
			checkBox(driver, voyage_check_box, voyage_checkbox_perform);
			waitForElement(driver, showallcells_check_box);
			checkBox(driver, showallcells_check_box, show_all_cells_checkbox_perform);
			waitForElement(driver, showdraftcells_check_box);
			checkBox(driver, showdraftcells_check_box, show_draft_cells_checkbox_perform);
			waitForElement(driver, showconformtcells_check_box);
			checkBox(driver, showconformtcells_check_box, show_conform_cells_checkbox_perform);
			waitForElement(driver, showactualconformtcells_check_box);
			checkBox(driver, showactualconformtcells_check_box, show_Actual_conform_cells_checkbox_perform);
			waitForElement(driver, showomittedcells_check_box);
			checkBox(driver, showomittedcells_check_box, show_omitted_cells_checkbox_perform);

			// From cycle input
			if (!From_cycle_input.equals("")) {
				waitForElement(driver, From_cycle);
				clearAndType(driver, From_cycle, From_cycle_input);
			}

			// To cycle input
			if (!To_cycle_input.equals("")) {
				waitForElement(driver, To_cycle);
				clearAndType(driver, To_cycle, To_cycle_input);
			}

			checkBox(driver, Date_check_box, Date_checkbox_perform);
			
			// Selecting the From Date

			waitForElement(driver, From_date_LT);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, From_date_LT, From_Date_Input);
			} else {
				waitForElement(driver, From_date_LT);
				clearAndType(driver, From_date_LT, From_Date_Input);
			}
			// Selecting the to Date
			waitForElement(driver, To_Date_LT);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, To_Date_LT, To_Date_Input);
			} else {
				waitForElement(driver, To_Date_LT);
				clearAndType(driver, To_Date_LT, To_Date_Input);
			}

			if (From_Voyage_Perform.equals("YES")) {
				waitForElement(driver, From_voyage_search);
				safeclick(driver, From_voyage_search);
				
				twoColumnSearchWindow(driver, From_Voyage_Number_Header, Condition_Filter, From_voyage_Input);

			}
			
			
			if (To_voyage_perform.equals("YES")) {
				waitForElement(driver, To_voyage_search);
				safeclick(driver, To_voyage_search);
				twoColumnSearchWindow(driver, To_Voyage_Number_Header, Condition_Filter, To_voyage_Input);
				

			}

			waitForElement(driver, LongTermsearchOk);
			safeclick(driver, LongTermsearchOk);

			Step_Start(4, "Click on edit button", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);
			waitForElement(driver, Edit_Button_toolBar);

			Step_End(4, "Click on edit button ", test, test1);
			scrollBottom(driver);
			// renaming vessels
			Step_Start(5, "Right Click on the Draft voyage (Indicating in blue color)", test, test1);
			List<String> beforename = new ArrayList<>();

			String Voyage_Num = String.format(voyage_Num, Voyage_Number);
			waitForElement(driver, Voyage_Num);
			String actualVoyage = getText(driver, Voyage_Num);

			waitForElement(driver, vessels_code);

			List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);


			for (WebElement Vessel_Code : vessel_Codes) {
				waitForElement(driver, Vessel_Code);

				if (Vessels_Code.equals(Vessel_Code.getText()) && Future_Cycle_Perform.equalsIgnoreCase("YES")) {

					String before = getText1(driver, Vessel_Code);
					beforename.add(before);
					System.out.println(beforename);

				}
				if (Vessels_Code.equals(Vessel_Code.getText()) && actualVoyage.equals(Voyage_Number)
						&& Future_Cycle_Perform.equalsIgnoreCase("NO")) {

					String before = getText1(driver, Vessel_Code);
					beforename.add(before);
					System.out.println(beforename);
					break;
				}

			}

			System.out.println("actualVoyage:" + actualVoyage);
			System.out.println("Voyage_Number:" + Voyage_Number);

			waitForElement(driver, Voyage_Num);
			click(driver, Voyage_Num);
			waitForElement(driver, Voyage_Num);
			RightClick(driver, Voyage_Num);

			Step_End(5, "Right Click on the Draft voyage (Indicating in blue color) ", test, test1);
			Step_Start(6, "Choose Add/Rename Option", test, test1);
			scrollUsingElement(driver, renameLT);
			waitForElement(driver, renameLT);
			mouseOverToElement(driver, renameLT);
			Step_End(6, "Choose Add/Rename Option ", test, test1);
			Step_Start(7, "Choose Rename Vessel Option from the sub menu ", test, test1);
			waitForElement(driver, Renamevessels);
			safeclick(driver, Renamevessels);
			Step_End(7, "Choose Rename Vessel Option from the sub menu ", test, test1);
			Step_Start(8, "System should show a dialog box", test, test1);
			Step_Start(9, "Enter the Vessel to be Renamed ", test, test1);

			if (Add_Vessels_Perform.equals("YES")) {
				if (Add_Vessels_Perform.equals("YES")) {
					waitForElement(driver, renameFrameSearchIcon);
					safeclick(driver, renameFrameSearchIcon);
					twoColumnSearchWindow(driver, Vessel_Code_Header_Rename, Condition_Filter, Add_Vessels);
					Extent_pass_New(driver, "Expected Result is : Vessels should be selected as "+ Add_Vessels + "Actual Result is : Vessels should be selected as "+ Add_Vessels , test, test1);
				}
			}

			if (Add_TBN_Vessels_Perform.equals("YES")) {
				if (Add_TBN_Vessels_Perform.equals("YES")) {
					waitForElement(driver, Tbn_radio_btn);
					safeclick(driver, Tbn_radio_btn);
					Extent_pass_New(driver, "Expected Result is : Vessels should be selected as [TBN] || Actual  Result is : Vessels should be selected as [TBN]", test, test1);

				}
			}

			if (Add_Empty_Vessels_Perform.equals("YES")) {
				if (Add_Empty_Vessels_Perform.equals("YES")) {
					waitForElement(driver, blank_radio_btn);
					safeclick(driver, blank_radio_btn);
					Extent_pass_New(driver, "Expected Result is : Vessels should be selected as [Empty vessels] || Actual  Result is : Vessels should be selected as [Empty vessels]", test, test1);

				}
			}

			Step_End(9, "Enter the Vessel to be Renamed ", test, test1);

			Step_Start(10,
					"Choose Whether the Renaming of the vessel should affect the future cycles of the renaming vessel",
					test, test1);
			// selecting future
			Step_Start(11, "Choose Future Voyages ", test, test1);
			if (Future_Cycle_Perform.equals("YES")) {
				if (Future_Cycle_Perform.equals("YES")) {
					Step_End(11, "Choose Future Voyages ", test, test1);
					Step_Start(12, "Click on ok  ", test, test1);
					waitForElement(driver, okRename);
					safeclick(driver, okRename);
					Step_End(12, "Click on ok  ", test, test1);

					waitForPopup(driver, popup_Message, Future_Renamed_Pop_Exp);
					String Future_Rename_Pop_Act = getText(driver, popup_Message);
					System.out.println(Future_Rename_Pop_Act);
					Step_Start(16, "Now system should show a validation “Vessel Renamed” ", test, test1);
					if (Future_Renamed_Pop_Exp.equals(Future_Rename_Pop_Act)) {
						System.out.println("Matched || " + " Expected popup is : " + Future_Renamed_Pop_Exp
								+ " || Actual popup is : " + Future_Rename_Pop_Act);
						Extent_pass_New(driver, "Matched || " + " Expected popup is : " + Future_Renamed_Pop_Exp
								+ " || Actual popup is : " + Future_Rename_Pop_Act, test, test1);
					} else {
						System.out.println("Not matched || " + " Expected popup is : " + Future_Renamed_Pop_Exp
								+ " || Actual popup is : " + Future_Rename_Pop_Act);
						Extent_fail(driver, "Not matched || " + " Expected popup is : " + Future_Renamed_Pop_Exp
								+ " || Actual popup is : " + Future_Rename_Pop_Act, test, test1);

					}
					waitForElement(driver, popup_Message_Ok_Button);
					safeclick(driver, popup_Message_Ok_Button);
					Step_End(16, "Now system should show a validation “Vessel Renamed” ", test, test1);
				}
			}
			Step_End(10, "Choose Whether the Renaming of the vessel should affect the future cycles of the renaming vessel",
					test, test1);
			// selecting current status as addind vessels


			Step_Start(13, "Choose Whether the Renaming of the vessel should affect ony the current cycle of the vessel ",
					test, test1);
			Step_Start(14, "Choose Current Voyages  ", test, test1);
			if (Future_Cycle_Perform.equals("NO")) {
				if (Future_Cycle_Perform.equals("NO")) {

					waitForElement(driver, Selec_current_butn);
					safeclick(driver, Selec_current_butn);
					Step_End(14, "Choose Current Voyages  ", test, test1);
					Step_Start(15, "Click on ok ", test, test1);
					waitForElement(driver, okRename);
					safeclick(driver, okRename);
					Step_End(15, "Click on ok ", test, test1);
					Step_Start(16, "Now system should show a validation “Vessel Renamed” ", test, test1);
	                 waitForPopup(driver, popup_Message, Current_Renamed_Pop_Exp);
					String Current_Rename_Pop_Act = getText(driver, popup_Message);
					System.out.println(Current_Rename_Pop_Act);

					if (Current_Renamed_Pop_Exp.equals(Current_Rename_Pop_Act)) {
						System.out.println("Matched || " + " Expected Popup is : " + Current_Renamed_Pop_Exp
								+ " || Actual Popup is : " + Current_Rename_Pop_Act);
						Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Current_Renamed_Pop_Exp
								+ " || Actual Popup is : " + Current_Rename_Pop_Act, test, test1);
						waitForElement(driver, popup_Message_Ok_Button);
						safeclick(driver, popup_Message_Ok_Button);
					} else {
						System.out.println("Not matched || " + " Expected Popup is : " + Current_Renamed_Pop_Exp
								+ " || Actual Popup is : " + Current_Rename_Pop_Act);
						Extent_fail(driver, "Not matched || " + " Expected Popup is : " + Current_Renamed_Pop_Exp
								+ " || Actual Popup is : " + Current_Rename_Pop_Act, test, test1);

					}

				}
			}
			Step_End(16, "Now system should show a validation “Vessel Renamed” ", test, test1);
			Step_End(13, "Choose Whether the Renaming of the vessel should affect ony the current cycle of the vessel ",
					test, test1);

			List<String> afterrename = new ArrayList<>();

			waitForElement(driver, vessels_code);

			List<WebElement> vessel_Codes1 = listOfElements(driver, vessels_code);
			for (WebElement Vessel_Code : vessel_Codes1) {
				waitForElement(driver, Vessel_Code);

				String voyage_Num1 = String.format(voyage_Num, Voyage_Number);
				waitForElement(driver, voyage_Num1);
				String actualVoyage1 = getText(driver, voyage_Num1);

				if (Add_Vessels.equals(Vessel_Code.getText()) && Future_Cycle_Perform.equalsIgnoreCase("YES")) {

					waitForElement(driver, Vessel_Code);

					String After = getText1(driver, Vessel_Code);
					afterrename.add(After);
					System.out.println(afterrename);

				}
				if (Add_Vessels.equals(Vessel_Code.getText()) && actualVoyage1.equals(Voyage_Number)
						&& Future_Cycle_Perform.equalsIgnoreCase("NO")) {

					waitForElement(driver, Vessel_Code);

					String After = getText1(driver, Vessel_Code);
					afterrename.add(After);
					System.out.println(afterrename);
					break;
				}

			}
			if (!beforename.equals(afterrename)) {
				System.out.println("Matched || The expected Result is : Once user before Renaming  the vessel , vessel name is "+ beforename + "|| Acutal result is : Once user after Renaming  the vessel , vessel name should be changed as "+ afterrename);
				Extent_pass_New(driver, "Matched || The expected Result is : Once user before Renaming  the vessel , vessel name is "+ beforename + "|| Acutal result is : Once user after Renaming  the vessel , vessel name should be changed as "+ afterrename,
						test, test1);

			} else {

				System.out
						.println("Matched || The expected Result is : Once user before Renaming  the vessel , vessel name is "+ beforename + "|| Acutal result is : Once user after Renaming  the vessel , vessel name is not changed as "+ afterrename);
				Extent_fail(driver,
						"Matched || The expected Result is : Once user before Renaming  the vessel , vessel name is "+ beforename + "|| Acutal result is : Once user after Renaming  the vessel , vessel name is not changed as "+ afterrename, test,
						test1);

			}
			
			
			Extent_completed(testcase_Name, test, test1);
		}

		scrollTop(driver);

		click(driver, Close_Current_tab);

		int LT5 = 5;

		if (LT5 == 5) {
			String testcase_Name = "TC_Long_Term_Creation_LT05";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Future_Renamed_Pop_Exp = data.get("Future_Renamed_Pop_Exp");
			String Current_Renamed_Pop_Exp = data.get("Current_Renamed_Pop_Exp");
			String Vessels_Code = data.get("Vessels_Code");
			String Voyage_number_input = data.get("Voyage_number_input");
			String Increment_pivot_1 = data.get("Increment_pivot_1");
			String Pivot_Voyage_1 = data.get("Pivot_Voyage_1");
			String Pivot_Voyage_2 = data.get("Pivot_Voyage_2");
			String Pivot_Voyage_3 = data.get("Pivot_Voyage_3");
			String Increment_number_voyage_input_1 = data.get("Increment_number_voyage_input_1");
			String Increment_number_voyage_input_2 = data.get("Increment_number_voyage_input_2");
			String Future_Rename_Perform = data.get("Future_Rename_Perform");
			String selected_vessels_Perform = data.get("selected_vessels_Perform");
			String selected_vessels_input = data.get("selected_vessels_input");
			String cycle_checkbox_perform = data.get("cycle_checkbox_perform");
			String Date_checkbox_perform = data.get("Date_checkbox_perform");
			String voyage_checkbox_perform = data.get("voyage_checkbox_perform");
			String show_all_cells_checkbox_perform = data.get("show_all_cells_checkbox_perform");
			String show_draft_cells_checkbox_perform = data.get("show_draft_cells_checkbox_perform");
			String show_conform_cells_checkbox_perform = data.get("show_conform_cells_checkbox_perform");
			String show_Actual_conform_cells_checkbox_perform = data.get("show_Actual_conform_cells_checkbox_perform");
			String show_omitted_cells_checkbox_perform = data.get("show_omitted_cells_checkbox_perform");
			String To_cycle_input = data.get("To_cycle_input");
			String From_cycle_input = data.get("From_cycle_input");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");
			String To_voyage_perform = data.get("To_voyage_perform");
			String From_Voyage_Perform = data.get("From_Voyage_Perform");
			String From_voyage_Input = data.get("From_voyage_Input");
			String To_voyage_Input = data.get("To_voyage_Input");
			String Pivot_Voyage_perform = data.get("Pivot_Voyage_perform");
			String Head_Voyage_perform = data.get("Head_Voyage_perform");
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");
			//

			Extent_Start(testcase_Name, test, test1);


			// searching for module

			moduleNavigate(driver, Search);

			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			Step_Start(1, "Retirve the Record via Global Search ", test, test1);
			waitForElement(driver, searchIconLT);
			safeclick(driver, searchIconLT);
			Step_End(1, "Retirve the Record via Global Search  ", test, test1);
			Step_Start(2, "Enter the Service Code in the Service Code field ", test, test1);
			twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);

			Step_End(2, "Enter the Service Code in the Service Code field", test, test1);
			Step_Start(3, "Click on Ok button ", test, test1);

			Step_End(3, "Click on Ok button  ", test, test1);

			// selecting the selected vessels
					if (selected_vessels_Perform.equals("YES")) {
						waitForElement(driver, selected_Vessel_Button);
						safeclick(driver, selected_Vessel_Button);
						waitForElement(driver, Addselectedvessels);
						safeclick(driver, Addselectedvessels);
						
						twoColumnSearchWindow(driver, Vessel_Code_Header, Condition_Filter, selected_vessels_input);

					}	

			waitForElement(driver, cycle_check_box);
			checkBox(driver, cycle_check_box, cycle_checkbox_perform);
			waitForElement(driver, voyage_check_box);
			checkBox(driver, voyage_check_box, voyage_checkbox_perform);
			waitForElement(driver, showallcells_check_box);
			checkBox(driver, showallcells_check_box, show_all_cells_checkbox_perform);
			waitForElement(driver, showdraftcells_check_box);
			checkBox(driver, showdraftcells_check_box, show_draft_cells_checkbox_perform);
			waitForElement(driver, showconformtcells_check_box);
			checkBox(driver, showconformtcells_check_box, show_conform_cells_checkbox_perform);
			waitForElement(driver, showactualconformtcells_check_box);
			checkBox(driver, showactualconformtcells_check_box, show_Actual_conform_cells_checkbox_perform);
			waitForElement(driver, showomittedcells_check_box);
			checkBox(driver, showomittedcells_check_box, show_omitted_cells_checkbox_perform);

			// From cycle input
			if (!From_cycle_input.equals("")) {
				waitForElement(driver, From_cycle);
				clearAndType(driver, From_cycle, From_cycle_input);
			}

			// To cycle input
			if (!To_cycle_input.equals("")) {
				waitForElement(driver, To_cycle);
				clearAndType(driver, To_cycle, To_cycle_input);
			}

			checkBox(driver, Date_check_box, Date_checkbox_perform);
			// Selecting the From Date

					waitForElement(driver, From_date_LT);
					if (date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, From_date_LT, From_Date_Input);
					} else {
						waitForElement(driver, From_date_LT);
						clearAndType(driver, From_date_LT, From_Date_Input);
					}
					// Selecting the to Date
					waitForElement(driver, To_Date_LT);
					if (date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, To_Date_LT, To_Date_Input);
					} else {
						waitForElement(driver, To_Date_LT);
						clearAndType(driver, To_Date_LT, To_Date_Input);
					}
					
					if (From_Voyage_Perform.equals("YES")) {
						waitForElement(driver, From_voyage_search);
						safeclick(driver, From_voyage_search);
						
						twoColumnSearchWindow(driver, From_Voyage_Number_Header, Condition_Filter, From_voyage_Input);

					}
					
					
					if (To_voyage_perform.equals("YES")) {
						waitForElement(driver, To_voyage_search);
						safeclick(driver, To_voyage_search);
						twoColumnSearchWindow(driver, To_Voyage_Number_Header, Condition_Filter, To_voyage_Input);
						

					}

			waitForElement(driver, LongTermsearchOk);
			safeclick(driver, LongTermsearchOk);

			Step_Start(4, "Click on edit button", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);
			waitForElement(driver, Edit_Button_toolBar);
			Step_End(4, "Click on edit button ", test, test1);
			scrollBottom(driver);
			// renaming vessels

			Step_Start(5, "Right Click on the Draft voyage (Indicating in blue color)", test, test1);
			List<String> beforename = new ArrayList<>();
			int i = 1;
			waitForElement(driver, vessels_code);

			List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);
			for (WebElement vessel_Code : vessel_Codes) {

				if (vessel_Code.getText().equals(Vessels_Code)) {

					String num = String.valueOf(i);
					String voyagenumbers = String.format(voyage_Num_l, num);

					String Before = getText(driver, voyagenumbers);
					System.out.println(Before);
					beforename.add(Before);
				}
				i++;

			}

			try {
				int i1 = 1;
				waitForElement(driver, vessels_code);

				List<WebElement> vessel_Codes1 = listOfElements(driver, vessels_code);
				for (WebElement Vessel_Code : vessel_Codes1) {

					if (Vessels_Code.equals(Vessel_Code.getText())) {

						String num = String.valueOf(i1);
						String voyage_Num = String.format(voyage_Num_l, num);

						if (Voyage_Number.equals(getText(driver, voyage_Num))) {
							click(driver, voyage_Num);

							RightClick(driver, voyage_Num);
							Step_End(5, "Right Click on the Draft voyage (Indicating in blue color) ", test, test1);
							Step_Start(6, "Choose Add/Rename Option", test, test1);
							scrollUsingElement(driver, renameLT);
							waitForElement(driver, renameLT);
							mouseOverToElement(driver, renameLT);
							Step_Start(7, "Choose Rename Voyage Option from the sub menu )", test, test1);
							safeclick(driver, renameVoyage);

							waitForElement(driver, renameVoyageFrame);
							Step_End(6, "Choose Add/Rename Option ", test, test1);
							Step_End(7, "Choose Rename Voyage Option from the sub menu  ", test, test1);

							Step_Start(8, "System should show a dialog box )", test, test1);
							if (isDisplayed(driver, renameVoyageFrame)) {
								System.out.println("The expected Result is : Once user select rename option. rename voyage frame should be displayed || Acutal result is : Once user select rename option. rename voyage frame is displayed");
								Extent_pass_New(driver, "The expected Result is : Once user select rename option. rename voyage frame should be displayed || Acutal result is : Once user select rename option. rename voyage frame is displayed", test, test1);

							} else {
								System.out.println("The expected Result is : Once user select rename option. rename voyage frame should be displayed || Acutal result is : Once user select rename option. rename voyage frame is not displayed");
								Extent_fail(driver, "The expected Result is : Once user select rename option. rename voyage frame should be displayed || Acutal result is : Once user select rename option. rename voyage frame is not displayed", test, test1);

							}

							Step_Start(16,
									"Choose if only the Head Voyage should be updated. Uncheck the Pivot voyage check box"
											+ ")",
									test, test1);
							Step_Start(17,
									"Choose if only the Pivot Voyage should be updated. Uncheck the Head voyage check box"
											+ ")",
									test, test1);
							waitForElement(driver, voyageNumberTextField);
							safeclick(driver, voyageNumberTextField);
							checkBox(driver, headVoyageCheckBox_l, Head_Voyage_perform);
							checkBox(driver, pivotVoyageCheckBox_l, Pivot_Voyage_perform);

							Step_End(16,
									"Choose if only the Head Voyage should be updated. Uncheck the Pivot voyage check box"
											+ ")",
									test, test1);
							Step_End(17,
									"Choose if only the Pivot Voyage should be updated. Uncheck the Head voyage check box"
											+ ")",
									test, test1);

							Step_End(8, "System should show a dialog box )", test, test1);
							Step_Start(9, "Enter the Voyage Number and the Increment Value ", test, test1);
							// Voyage number input
							if (!Voyage_number_input.equals("")) {
								waitForElement(driver, voyageNumberTextField);
								sendKeys(driver, voyageNumberTextField, Voyage_number_input);
							}

							// Incremet Voyage number input
							if (!Increment_pivot_1.equals("")) {
								waitForElement(driver, incrementVoyageTextField);
								sendKeys(driver, incrementVoyageTextField, Increment_pivot_1);
							}

							// Pivot Voyage_1 number input
							if (!Pivot_Voyage_1.equals("")) {
								waitForElement(driver, pivotVoyage_1_l);
								sendKeys(driver, pivotVoyage_1_l, Pivot_Voyage_1);
							}
							// Pivot Voyage_2 number input
							if (!Pivot_Voyage_2.equals("")) {
								waitForElement(driver, PIVOT_VOYAGE_2);
								sendKeys(driver, PIVOT_VOYAGE_2, Pivot_Voyage_2);
							}
							// Pivot Voyage_3 number input
							if (!Pivot_Voyage_3.equals("")) {
								waitForElement(driver, PIVOT_VOYAGE_3);
								sendKeys(driver, PIVOT_VOYAGE_3, Pivot_Voyage_3);
							}

							// Increment Pivot_1 number input
							if (!Increment_number_voyage_input_1.equals("")) {
								waitForElement(driver, incrementPivot1_l);
								sendKeys(driver, incrementPivot1_l, Increment_number_voyage_input_1);
							}

							// Increment Pivot_2 number input
							if (!Increment_number_voyage_input_2.equals("")) {
								waitForElement(driver, Increment_pivot_2);
								sendKeys(driver, Increment_pivot_2, Increment_number_voyage_input_2);
							}

							// Increment Pivot_3 number input
							if (!Increment_number_voyage_input_1.equals("")) {
								waitForElement(driver, Increment_pivot_3);
								sendKeys(driver, Increment_pivot_3, Increment_number_voyage_input_1);
							}

							Step_End(9, "Enter the Voyage Number and the Increment Value ", test, test1);
							Step_Start(10,
									"Choose Whether the Renaming of the voyage should affect the future cycles of the vessel",
									test, test1);
							if (Future_Rename_Perform.equals("YES")) {
								if (Future_Rename_Perform.equals("YES")) {
									Step_Start(11, "Choose Future Voyages ", test, test1);
									Step_Start(12, "Click on ok ", test, test1);
									waitForElement(driver, renameVoyageFrameOk);
									safeclick(driver, renameVoyageFrameOk);
									Step_End(11, "Choose Future Voyages ", test, test1);
									Step_End(12, "Click on ok ", test, test1);
									waitForPopup(driver, popup_Message, Future_Renamed_Pop_Exp);
									String Future_Rename_Pop_Act_TBN = getText(driver, popup_Message);
									System.out.println(Future_Rename_Pop_Act_TBN);
									Step_Start(18, "Now system should show a validation “Voyage Updated", test, test1);

									if (Future_Renamed_Pop_Exp.equals(Future_Rename_Pop_Act_TBN)) {
										System.out
												.println("Matched || " + " Expected Activity is : " + Future_Renamed_Pop_Exp
														+ " || Actual Activity is : " + Future_Rename_Pop_Act_TBN);
										Extent_pass_New(driver,
												"Matched || " + " Expected Activity is : " + Future_Renamed_Pop_Exp
														+ " || Actual Activity is : " + Future_Rename_Pop_Act_TBN,
												test, test1);
									} else {
										System.out.println(
												"Not matched || " + " Expected Activity is : " + Future_Renamed_Pop_Exp
														+ " || Actual Activity is : " + Future_Rename_Pop_Act_TBN);
										Extent_fail(driver,
												"Not matched || " + " Expected Activity is : " + Future_Renamed_Pop_Exp
														+ " || Actual Activity is : " + Future_Rename_Pop_Act_TBN,
												test, test1);

									}
									Step_End(18, "Now system should show a validation “Voyage Updated", test, test1);
									waitForElement(driver, popup_Message_Ok_Button);
									safeclick(driver, popup_Message_Ok_Button);
								}
							}
							Step_End(10,
									"Choose Whether the Renaming of the voyage should affect the future cycles of the vessel",
									test, test1);
							Step_Start(13,
									"Choose Whether the Renaming of the voyage should affect on the current cycle of the vessel",
									test, test1);
							if (Future_Rename_Perform.equals("NO")) {
								if (Future_Rename_Perform.equals("NO")) {
									Step_Start(14, "Choose current Voyages ", test, test1);
									Step_Start(15, "Click on ok ", test, test1);
									waitForElement(driver, current_voyage);
									safeclick(driver, current_voyage);
									waitForElement(driver, renameVoyageFrameOk);
									safeclick(driver, renameVoyageFrameOk);
									Step_End(14, "Choose current Voyages ", test, test1);
									Step_End(15, "Click on ok ", test, test1);
									Step_Start(18, "Now system should show a validation “Voyage Updated", test, test1);

									waitForPopup(driver, popup_Message, Current_Renamed_Pop_Exp);
									String Current_Rename_Pop_Act = getText(driver, popup_Message);
									System.out.println(Current_Rename_Pop_Act);

									if (Current_Renamed_Pop_Exp.equals(Current_Rename_Pop_Act)) {
										System.out.println(
												"Matched || " + " Expected Activity is : " + Current_Renamed_Pop_Exp
														+ " || Actual Activity is : " + Current_Rename_Pop_Act);
										Extent_pass_New(driver,
												"Matched || " + " Expected Activity is : " + Current_Renamed_Pop_Exp
														+ " || Actual Activity is : " + Current_Rename_Pop_Act,
												test, test1);
									} else {
										System.out.println(
												"Not matched || " + " Expected Activity is : " + Current_Renamed_Pop_Exp
														+ " || Actual Activity is : " + Current_Rename_Pop_Act);
										Extent_fail(driver,
												"Not matched || " + " Expected Activity is : " + Current_Renamed_Pop_Exp
														+ " || Actual Activity is : " + Current_Rename_Pop_Act,
												test, test1);

									}
									Step_End(18, "Now system should show a validation “Voyage Updated", test, test1);
									waitForElement(driver, popup_Message_Ok_Button);
									safeclick(driver, popup_Message_Ok_Button);
									Step_End(13,
											"Choose Whether the Renaming of the voyage should affect on the current cycle of the vessel",
											test, test1);
								}

							}

							break;

						}
					}

					i1++;
				}
			} catch (Exception e) {
				e.printStackTrace();
				Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

			}
			List<String> Afterrename = new ArrayList<>();

			try {

				int i1 = 1;
				waitForElement(driver, vessels_code);

				List<WebElement> vessel_Codes1 = listOfElements(driver, vessels_code);
				for (WebElement vessel_Code : vessel_Codes1) {

					if (vessel_Code.getText().equals(Vessels_Code)) {

						String num = String.valueOf(i1);
						String voyagenumbers = String.format(voyage_Num_l, num);
						String After = getText(driver, voyagenumbers);
						System.out.println(After);
						Afterrename.add(After);
					}
					i1++;

				}

			} catch (Exception e) {
				e.printStackTrace();
				Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

			}

			if (beforename.equals(Afterrename)) {
				System.out.println("Matched || The expected Result is : Once user before Renaming  the voyage , vessel name is "+ beforename+ "|| Acutal result is : Once user after Renaming  the vessel , vessel name should be changed as "+ Afterrename);
				Extent_fail(driver,
						"Matched || The expected Result is : Once user before Renaming  the voyage , vessel name is "+ beforename+ "|| Acutal result is : Once user after Renaming  the vessel , vessel name should be changed as "+ Afterrename,
						test, test1);

			} else {

				System.out.println("Not Matched || The expected Result is : Once user before Renaming  the voyage , vessel name is "+ beforename+ "|| Acutal result is : Once user after Renaming  the vessel , vessel name not  changed as "+ Afterrename);
				Extent_pass_New(driver, "Not Matched || The expected Result is : Once user before Renaming  the voyage , vessel name is "+ beforename+ "|| Acutal result is : Once user after Renaming  the vessel , vessel name not  changed as "+ Afterrename, test, test1);

			}
			Extent_completed(testcase_Name, test, test1);
		}

		scrollTop(driver);

		click(driver, Close_Current_tab);

		int LT6 = 6;

		if (LT6 == 6) {
			String testcase_Name = "TC_Long_Term_Creation_LT06";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Port_Name = data.get("Port_Name");
			String Time_Input = data.get("Time_Input");
			String selected_vessels_Perform = data.get("selected_vessels_Perform");
			String selected_vessels_input = data.get("selected_vessels_input");
			String cycle_checkbox_perform = data.get("cycle_checkbox_perform");
			String Date_checkbox_perform = data.get("Date_checkbox_perform");
			String voyage_checkbox_perform = data.get("voyage_checkbox_perform");
			String show_all_cells_checkbox_perform = data.get("show_all_cells_checkbox_perform");
			String show_draft_cells_checkbox_perform = data.get("show_draft_cells_checkbox_perform");
			String show_conform_cells_checkbox_perform = data.get("show_conform_cells_checkbox_perform");
			String show_Actual_conform_cells_checkbox_perform = data.get("show_Actual_conform_cells_checkbox_perform");
			String show_omitted_cells_checkbox_perform = data.get("show_omitted_cells_checkbox_perform");
			String To_cycle_input = data.get("To_cycle_input");
			String From_cycle_input = data.get("From_cycle_input");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");
			String To_voyage_perform = data.get("To_voyage_perform");
			String From_Voyage_Perform = data.get("From_Voyage_Perform");
			String From_voyage_Input = data.get("From_voyage_Input");
			String To_voyage_Input = data.get("To_voyage_Input");
			String Vessels_Code = data.get("Vessels_Code");
			String From_Date_edit = data.get("From_Date_edit");
			String Pop_up_for_Validation = data.get("Pop_up_for_Validation");
			String Time_input_perform = data.get("Time_input_perform");
			String Pop_up_perform = data.get("Pop_up_perform");
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");
			
			
			
			String beforeadjusttime = null;
			//

			Extent_Start(testcase_Name, test, test1);

			// searching for module

			moduleNavigate(driver, Search);

			Step_Start(1, "Retirve the Record via Global Search ", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			waitForElement(driver, searchIconLT);
			safeclick(driver, searchIconLT);
			Step_End(1, "Retirve the Record via Global Search  ", test, test1);
			Step_Start(2, "Enter the Service Code in the Service Code field ", test, test1);
			twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);

			Step_End(2, "Enter the Service Code in the Service Code field", test, test1);
			Step_Start(3, "Click on Ok button ", test, test1);

			Step_End(3, "Click on Ok button  ", test, test1);

			// selecting the selected vessels
			if (selected_vessels_Perform.equals("YES")) {
				waitForElement(driver, selected_Vessel_Button);
				safeclick(driver, selected_Vessel_Button);
				waitForElement(driver, Addselectedvessels);
				safeclick(driver, Addselectedvessels);
				
				twoColumnSearchWindow(driver, Vessel_Code_Header, Condition_Filter, selected_vessels_input);

			}	

			waitForElement(driver, cycle_check_box);
			checkBox(driver, cycle_check_box, cycle_checkbox_perform);
			waitForElement(driver, voyage_check_box);
			checkBox(driver, voyage_check_box, voyage_checkbox_perform);
			waitForElement(driver, showallcells_check_box);
			checkBox(driver, showallcells_check_box, show_all_cells_checkbox_perform);
			waitForElement(driver, showdraftcells_check_box);
			checkBox(driver, showdraftcells_check_box, show_draft_cells_checkbox_perform);
			waitForElement(driver, showconformtcells_check_box);
			checkBox(driver, showconformtcells_check_box, show_conform_cells_checkbox_perform);
			waitForElement(driver, showactualconformtcells_check_box);
			checkBox(driver, showactualconformtcells_check_box, show_Actual_conform_cells_checkbox_perform);
			waitForElement(driver, showomittedcells_check_box);
			checkBox(driver, showomittedcells_check_box, show_omitted_cells_checkbox_perform);

			// From cycle input
			if (!From_cycle_input.equals("")) {
				waitForElement(driver, From_cycle);
				clearAndType(driver, From_cycle, From_cycle_input);
			}

			// To cycle input
			if (!To_cycle_input.equals("")) {
				waitForElement(driver, To_cycle);
				clearAndType(driver, To_cycle, To_cycle_input);
			}

			checkBox(driver, Date_check_box, Date_checkbox_perform);
			// Selecting the From Date

			waitForElement(driver, From_date_LT);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, From_date_LT, From_Date_Input);
			} else {
				waitForElement(driver, From_date_LT);
				clearAndType(driver, From_date_LT, From_Date_Input);
			}
			// Selecting the to Date
			waitForElement(driver, To_Date_LT);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, To_Date_LT, To_Date_Input);
			} else {
				waitForElement(driver, To_Date_LT);
				clearAndType(driver, To_Date_LT, To_Date_Input);
			}
			
			if (From_Voyage_Perform.equals("YES")) {
				waitForElement(driver, From_voyage_search);
				safeclick(driver, From_voyage_search);
				
				twoColumnSearchWindow(driver, From_Voyage_Number_Header, Condition_Filter, From_voyage_Input);

			}
			
			
			if (To_voyage_perform.equals("YES")) {
				waitForElement(driver, To_voyage_search);
				safeclick(driver, To_voyage_search);
				twoColumnSearchWindow(driver, To_Voyage_Number_Header, Condition_Filter, To_voyage_Input);
				

			}
			waitForElement(driver, LongTermsearchOk);
			safeclick(driver, LongTermsearchOk);

			Step_Start(4, "Click on edit button", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);
			waitForElement(driver, Edit_Button_toolBar);
			scrollBottom(driver);
			Step_End(4, "Click on edit button ", test, test1);
			Step_Start(5, "Right Click on the Draft voyage (Indicating in blue color))", test, test1);
			try {
				int i = 1;
				waitForElement(driver, vessels_code);

				List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);

				for (WebElement Vessel_Code : vessel_Codes) {

					if (Vessels_Code.equals(Vessel_Code.getText())) {

						String num = String.valueOf(i);
						String voyage_Num = String.format(voyage_Num_l, num);

						if (Voyage_Number.equals(getText(driver, voyage_Num))) {

							String port_Date = String.format(port_Date_17, Port_Name, i);
							click(driver, port_Date);

							RightClick(driver, port_Date);
							Step_End(5, "Right Click on the Draft voyage (Indicating in blue color)", test, test1);

							RightClick(driver, voyage_Num);
							Step_Start(7, "Choose Adjust Time Option from the menu ", test, test1);
							mouseOverToElement(driver, AdjustTime);
							waitForElement(driver, AdjustTime1);
							safeclick(driver, AdjustTime1);

							Step_End(7, "Choose Adjust Time Option from the menu ", test, test1);

							Step_Start(8, "System should show a voyage details window box ", test, test1);
							waitForElement(driver, current_voyage);
							safeclick(driver, current_voyage);

							waitForElement(driver, current_voyage);

							horizontalscroll(driver, Scroll_1, 1500);

							List<WebElement> changedate = listOfElements(driver, changee);

							// Check if the list is not empty
							if (changedate.size() > 0) {
								// Get the last element in the list
								WebElement lastElement = changedate.get(changedate.size() - 1);

								// safeclick on the lagst element
								lastElement.click();

								beforeadjusttime = getText1(driver, lastElement);
								System.out.println(beforeadjusttime);
								Extent_pass_New(driver, "Expected Result is : Before adjust time it should be : "+ beforeadjusttime +" Actual Result is : Before adjust time it should be : "+ beforeadjusttime, test, test1);
								doubleClick1(driver, lastElement);

							}

							Step_Start(10, "System should adjust the time based on the user value  ", test, test1);
							if (Time_input_perform.equals("YES")) {

								waitForElement(driver, Time_input);
								sendKeys(driver, Time_input, Time_Input);
							}
							Step_End(10, "System should adjust the time based on the user value  ", test, test1);

							// Selecting the From Date

							Step_Start(9, "Adjust the required fields to adjust the date  ", test, test1);
							selectDatePicker(driver, From_Date_edit);
							if (date_Picker.equalsIgnoreCase("Yes")) {
								selectDatePicker(driver, From_Date_edit);
							} 
							click(driver, Close_Date);
							mouseOverToElement(driver, closedate);
							waitForElement(driver, closedate);
							click(driver, closedate);
							Step_End(9, "Adjust the required fields to adjust the date  ", test, test1);

							Step_Start(11, "Once the date is adjusted Click on move to Long Term button ", test, test1);
							waitForElement(driver, P_MoveTo_Long_Term_Btn);
							safeclick(driver, P_MoveTo_Long_Term_Btn);
							Step_End(11, "Once the date is adjusted Click on move to Long Term button ", test, test1);
							Step_End(8, "System should show a voyage details window box ", test, test1);
							Step_Start(12,
									"System should show validation if the given time of the current voyage last port dep pilot time is greater than the next voyage first port arrival pilot date ",
									test, test1);
							waitForPopup(driver, popup_Message, Pop_up_for_Validation);
							String portaddact = getText(driver, popup_Message);
							System.out.println(portaddact);

							if (Pop_up_for_Validation.equals(portaddact)) {
								System.out.println("Matched || " + " Expected Activity is[Before Adjust time] : "
										+ Pop_up_for_Validation + " || Actual Activity is [After adjust time]: "
										+ portaddact);
								Extent_pass_New(driver,
										"Matched || " + " Expected Activity is[Before Adjust time] : "
												+ Pop_up_for_Validation + " || Actual Activity is[After adjust time] : "
												+ portaddact,
										test, test1);
							} else {
								System.out.println("Not matched || " + " Expected Activity is[Before Adjust time] : "
										+ Pop_up_for_Validation + " || Actual Activity is[After adjust time] : "
										+ portaddact);
								Extent_fail(driver,
										"Not matched || " + " Expected Activity is [Before Adjust time]: "
												+ Pop_up_for_Validation + " || Actual Activity is[After adjust time] : "
												+ portaddact,
										test, test1);

							}

							Step_End(12,
									"System should show validation if the given time of the current voyage last port dep pilot time is greater than the next voyage first port arrival pilot date ",
									test, test1);

							// Popup want to click yes

							if (Pop_up_perform.equals("YES")) {

								waitForElement(driver, popup_Message_Yes_Button);
								safeclick(driver, popup_Message_Yes_Button);

								waitForElement(driver, popup_Message);
								String Updatedact = getText(driver, popup_Message);
								System.out.println(Updatedact);

								waitForElement(driver, popup_Message_Ok_Button);
								safeclick(driver, popup_Message_Ok_Button);

								String port_Date1 = String.format(port_Date_17, Port_Name, i);
								click(driver, port_Date1);

								RightClick(driver, port_Date1);

								mouseOverToElement(driver, AdjustTime);
								waitForElement(driver, AdjustTime1);
								safeclick(driver, AdjustTime1);

								waitForElement(driver, current_voyage);
								safeclick(driver, current_voyage);

								waitForElement(driver, current_voyage);
								horizontalscroll(driver, Scroll_1, 1500);

								waitForElement(driver, changee);

								List<WebElement> changedate1 = listOfElements(driver, changee);

								// Check if the list is not empty
								if (changedate1.size() > 0) {
									// Get the last element in the list
									WebElement lastElement = changedate1.get(changedate1.size() - 1);

									// safeclick on the last element
									lastElement.click();
								
//									waitForPopup(driver, lastElement, beforeadjusttime);
									String afteradjusttime = getText1(driver, lastElement);
									System.out.println(afteradjusttime);

									if (beforeadjusttime.equals(afteradjusttime)) {
										System.out.println("Matched || " + " Expected Activity is[Before Adjust time]: "
												+ beforeadjusttime + " || Actual Activity is[After adjust time] : "
												+ afteradjusttime);
										Extent_pass_New(driver,
												"Matched || " + " Expected Activity is[Before Adjust time] : "
														+ beforeadjusttime + " || Actual Activity is[After adjust time] : "
														+ afteradjusttime,
												test, test1);
									} else {
										System.out.println("Not matched || "
												+ " Expected Activity is[Before Adjust time] : " + beforeadjusttime
												+ " || Actual Activity is [After adjust time]: " + afteradjusttime);
										Extent_fail(driver,
												"Not matched || " + " Expected Activity is[Before Adjust time] : "
														+ beforeadjusttime + " || Actual Activity is [After adjust time]: "
														+ afteradjusttime,
												test, test1);

									}

								}
							}

							// popup want to click No
							if (Pop_up_perform.equals("NO")) {

								waitForElement(driver, popup_Message_Ok_Button);
								safeclick(driver, popup_Message_Ok_Button);
								waitForElement(driver, closeButtonAdjustTime);
								safeclick(driver, closeButtonAdjustTime);

								String port_Date1 = String.format(port_Date_17, Port_Name, i);
								click(driver, port_Date1);

								RightClick(driver, port_Date1);

								mouseOverToElement(driver, AdjustTime);
								waitForElement(driver, AdjustTime1);
								safeclick(driver, AdjustTime1);

								waitForElement(driver, current_voyage);
								safeclick(driver, current_voyage);

								horizontalscroll(driver, Scroll_1, 1500);

								waitForElement(driver, changee);
								List<WebElement> changedate1 = listOfElements(driver, changee);
								// Check if the list is not empty
								if (changedate1.size() > 0) {
									// Get the last element in the list
									WebElement lastElement = changedate1.get(changedate1.size() - 1);

									// safeclick on the last element
									lastElement.click();
//	                                waitForPopup(driver, lastElement, beforeadjusttime);
									String afteradjusttime = getText1(driver, lastElement);
									System.out.println(afteradjusttime);

									if (beforeadjusttime.equals(afteradjusttime)) {
										System.out.println("Matched || " + " Expected Activity is[Before Adjust time] : "
												+ beforeadjusttime + " || Actual Activity is[After adjust time] : "
												+ afteradjusttime);
										Extent_pass_New(driver,
												"Matched || " + " Expected Activity is [Before Adjust time]: "
														+ beforeadjusttime + " || Actual Activity is[After adjust time] : "
														+ afteradjusttime,
												test, test1);
									} else {
										System.out.println("Not matched || "
												+ " Expected Activity is[Before Adjust time] : " + beforeadjusttime
												+ " || Actual Activity is[After adjust time] : " + afteradjusttime);
										Extent_fail(driver,
												"Not matched || " + " Expected Activity is[Before Adjust time] : "
														+ beforeadjusttime + " || Actual Activity is[After adjust time] : "
														+ afteradjusttime,
												test, test1);

									}

								}

							}

							break;

						}

					}

					i++;
				}

			} catch (Exception e) {
				e.printStackTrace();
				Extent_fail(driver,  "Element is not present "+ e.getLocalizedMessage(), test,test1);

			}
			
			
			Extent_completed(testcase_Name, test, test1);

		}

	}
}