package LRP_VSS_Consolidation_Scripts;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.Coastal_Schedule_Locators;

public class TC_CoastalSchedule_CS7ToCS11 extends Keywords {

	public void CoastalSchedule7To11(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset) {
		
		   int cs=7;
		   if(cs==7) {
			   String testCaseName="TC_Coastal_Schedule_CS07";
				String File_Path_CS07 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
				String Sheet_Name_CS07 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
				String url = TestNgXml.getdatafromExecution().get(testCaseName);
				Map<String, String> Excel_data_07 = Utils.GetAllData(Sheet_Name_CS07, testCaseName, "Dataset"+selected_dataset, File_Path_CS07);

				String Add_Bound_1 =Excel_data_07.get("Add_Bound_1");
				String Add_Bound_2 =Excel_data_07.get("Add_Bound_2");
				String Add_Bound_3 =Excel_data_07.get("Add_Bound_3");
				String Pivot_Voyage_1=Excel_data_07.get( "Pivot_Voyage_1");
				String Pivot_Voyage_2=Excel_data_07.get( "Pivot_Voyage_2");
				String editVoyageText=Excel_data_07.get( "EditVoyageFrameText");
				String pivotBound1=Excel_data_07.get( "PivotBound1");
				String pivotBound2=Excel_data_07.get( "PivotBound2");
				String pivotBound3=Excel_data_07.get( "PivotBound3");
				String pivotVoyage1=Excel_data_07.get( "PivotVoyage1");
				String pivotVoyage2=Excel_data_07.get( "PivotVoyage2");
				String pivotVoyage3=Excel_data_07.get( "PivotVoyage3");
				String headVoyage=Excel_data_07.get( "HeadVoyage");
				String Pivot_Voyage_3=Excel_data_07.get("Pivot_Voyage_3");
				String Username_CS07 =Excel_data_07.get("Username");
				String Password_CS07 =Excel_data_07.get("Password");
				String ModuleSearch_CS07 =Excel_data_07.get("Module_Search");
				String ServiceCode_CS07 =Excel_data_07.get("Service_Code"); 
				String VesselCode_CS07 =Excel_data_07.get("Vessel_Code");
				String voyageNumber_CS07 =Excel_data_07.get("Voyage_Number");
				String portName_CS07 =Excel_data_07.get("Port_Name");
				String edit_Button_CS07 =Excel_data_07.get("Button");
				String Bound_1=Excel_data_07.get("Bound_1");
				String Bound_2 =Excel_data_07.get("Bound_2");
				String Bound_3= Excel_data_07.get("Bound_3");
				String Select_Columns= Excel_data_07.get("Select_Columns");
				String condition = Excel_data_07.get("Condition");
				String service_Search_Header = Excel_data_07.get("Service_Search_Header");
				String vessel_Search_Header = Excel_data_07.get("Vessel_Search_Header");


				
				String Voyage_Toggler8 = String.format(Coastal_Schedule_Locators.Voyage_Toggler7, voyageNumber_CS07);
				String Port_Select =String.format(Coastal_Schedule_Locators.Port_Select7,headVoyage,portName_CS07);
				String edit_Select =String.format(Coastal_Schedule_Locators.edit_Select,edit_Button_CS07);
				String Add_Bound_1_Button = String.format(Coastal_Schedule_Locators.Add_Bound_Button_7,Add_Bound_1);
				String Add_Bound_2_Button = String.format(Coastal_Schedule_Locators.Add_Bound_Button_7,Add_Bound_2);
				String Add_Bound_3_Button = String.format(Coastal_Schedule_Locators.Add_Bound_Button_7,Add_Bound_3);
				String Radio_Button_1 = String.format(Coastal_Schedule_Locators.Radio_Button_7,Pivot_Voyage_1);
				String Radio_Button_2 =String.format(Coastal_Schedule_Locators.Radio_Button_7,Pivot_Voyage_2);
				String Radio_Button_3 =String.format(Coastal_Schedule_Locators.Radio_Button_7,Pivot_Voyage_3);
				String check_Box=String.format(Coastal_Schedule_Locators.check_Box,portName_CS07);
				String select_Voyage =String.format(Coastal_Schedule_Locators.select_Voyage7,voyageNumber_CS07);
				String edit_Bound_1 =String.format(Coastal_Schedule_Locators.edit_Bound_7,Bound_1);
				String edit_Bound_2 = String.format(Coastal_Schedule_Locators.edit_Bound_7,Bound_2);
				String edit_Bound_3 =String.format(Coastal_Schedule_Locators.edit_Bound3_7,Bound_3);
				String NewVoyage =String.format(Coastal_Schedule_Locators.Voyage_New,headVoyage);

				Extent_Start(testCaseName, test, test1);

				navigateUrl(driver, url);
				

				LRP_Login(driver, Username_CS07, Password_CS07);
				
				moduleNavigate(driver, ModuleSearch_CS07);
				
				Step_Start(1, "Enter the Service Code in the service code field", test, test1);

				waitForElement(driver, Service_Search_Btn);
				click(driver, Service_Search_Btn);
				
				twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS07);

				Step_End(1, "Enter the Service Code in the service code field", test, test1);

				Step_Start(2, "Enter the Vessel ", test, test1);

				waitForElement(driver, Vessel_Search_Btn);
				click(driver, Vessel_Search_Btn);

				twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS07);

				Step_End(2, "Enter the Vessel ", test, test1);

				Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);

				waitForDisplay(driver, Tree_Structure);
				if(isdisplayed(driver,Tree_Structure)) {
					Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
					System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
				}else {
					System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

					Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
				}
				
				Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
				Step_Start(4, "Right click on the voyage to be edited", test, test1);
				waitForElement(driver, Voyage_Toggler8);
				String status = getAttribute(driver, Voyage_Toggler8, "class");
				if(!status.contains("s")) {
					click(driver, Voyage_Toggler8);
				}
				Step_End(4, "Right click on the voyage to be edited", test, test1);

				Step_Start(5, "Choose Edit Voyage option ", test, test1);
				Step_Start(6, "Choose the Ports from the listed out Under the Head Voyage and Enter the Voyage number for the Head voyage ", test, test1);
				waitForElement(driver, select_Voyage);
				click(driver, select_Voyage);	

				waitForElement(driver, select_Voyage);
				RightClick(driver, select_Voyage);

				Step_End(6, "Choose the Ports from the listed out Under the Head Voyage and Enter the Voyage number for the Head voyage ", test, test1);

				String headVy="";
				waitForElement(driver, edit_Select);
				click(driver, edit_Select);
				waitForElement(driver, editVoyageFrame);
				String editVoyageTitle=getText(driver, editVoyageFrame);
				if(editVoyageTitle.equals(editVoyageText)) {
					System.out.println("Matched || " + " Expected Text is : " + editVoyageText + " || Actual Text is : " + editVoyageTitle);
					Extent_pass_New(driver,"Matched || " + " Expected Text is : " + editVoyageText + " || ActualText is : " + editVoyageTitle,test,test1);
					Extent_pass_New(driver, "Edit voyage frame is displayed", test,test1);
					System.out.println("Edit voyage frame is displayed");
					waitForElement(driver, headVoyageTextField);
					sendKeys(driver, headVoyageTextField, headVoyage);
					waitForElement(driver, moveToCSButton);
					click(driver, moveToCSButton);

					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
						click(driver, popup_Message_Yes_Button);
					}

					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {		
						click(driver, popup_Message_Ok_Button);

						waitForElement(driver, hVoyageText);
						headVy=getText(driver, hVoyageText);
						if(headVy.contains(headVoyage)) {
							System.out.println("Matched || " + " Expected Head voyage : " + headVoyage + " || Actual Head voyage : " + headVy);
							Extent_pass_New(driver,"Matched || " + " Expected Head voyage : " + headVoyage + " || ActualHead voyage : " + headVy,test,test1);
						}else {
							System.out.println("Not matched || " + " Expected Head voyage : " + headVoyage + " || Actual Value  is : " + headVy+" || Head voyage is not updated");
							Extent_fail(driver,"Not matched || " + " Expected Head voyage : " + headVoyage + " || Actual Head voyage : " + headVy+" || Head voyage is not updated",test,test1);
						}			 
					}	 
				}else {
					System.out.println("Not Matched || " + " Expected Text : " + editVoyageText + " || Actual Text : " + editVoyageTitle+" || Edit voyage frame is not displayed");
					Extent_fail(driver,"Not Matched || " + " Expected Text : " + editVoyageText + " || ActualText : " + editVoyageTitle+" || Edit voyage frame is not displayed",test,test1);
				}

				Step_End(5, "Choose Edit Voyage option ", test, test1);

				Extent_call(test, test1, "If there is no bound value in the call we add the pivot bound(s) values");

				//pivot bound1	
				
				String updated_HeadVoyage_Toggle =String.format(Coastal_Schedule_Locators.updated_Head_Voyage_Toggle,headVy);

				waitForElement(driver, updated_HeadVoyage_Toggle);
				String status1 = getAttribute(driver, updated_HeadVoyage_Toggle, "class");
				if(!status1.contains("s")) {
					click(driver, updated_HeadVoyage_Toggle);
				}
				
				waitForElement(driver, Port_Select);
				click(driver, Port_Select);	
				waitForElement(driver, Port_Select);
				RightClick(driver, Port_Select);

				waitForElement(driver, Add_Bound_1_Button);
				click(driver, Add_Bound_1_Button);	

				waitForDisplay(driver, addPivotBound1Frame);
				if(isDisplayed(driver, addPivotBound1Frame)) {
					waitForElement(driver, Bouund_DD_1);
					click(driver, Bouund_DD_1);
					waitForElement(driver, edit_Bound_1);
					click(driver, edit_Bound_1);
					waitForElement(driver, addPivotVoyage1InBound);
					sendKeys(driver, addPivotVoyage1InBound, pivotBound1);		
					waitForElement(driver, boundOkButton);
					click(driver, boundOkButton);	

					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message_Ok_Button)) {
						click(driver, popup_Message_Ok_Button);
					}else {
						waitForElement(driver, popup_Message_Yes_Button);
						click(driver, popup_Message_Yes_Button);
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
					}
				}else {
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
				}



				Extent_call(test, test1, "If there is no bound value in the call we add the pivot bound(s) values");
				//	pivot bound2	
				
				waitForElement(driver, updated_HeadVoyage_Toggle);
				String status2 = getAttribute(driver, updated_HeadVoyage_Toggle, "class");
				if(!status2.contains("s")) {
					click(driver, updated_HeadVoyage_Toggle);
				}
				
				waitForElement(driver, Port_Select);
				click(driver, Port_Select);	
				waitForElement(driver, Port_Select);
				RightClick(driver, Port_Select);

				waitForElement(driver, Add_Bound_2_Button);
				click(driver, Add_Bound_2_Button);		

				waitForDisplay(driver, addPivotBound2Frame);
				if (isDisplayed(driver, addPivotBound2Frame)) {
					
					waitForElement(driver, Bouund_DD_2);
					click(driver, Bouund_DD_2);
					waitForElement(driver, edit_Bound_2);
					click(driver, edit_Bound_2);
					waitForElement(driver, addPivotVoyage2InBound);
					sendKeys(driver, addPivotVoyage2InBound, pivotBound2);
					waitForElement(driver, bound2_OkButton);
					click(driver, bound2_OkButton);

					waitForDisplay(driver, popup_Message);
					if (isdisplayed(driver, popup_Message_Ok_Button)) {
						
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
					} else {
						waitForElement(driver, popup_Message_Yes_Button);
						click(driver, popup_Message_Yes_Button);
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
					}
				} else {
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
				}

				Extent_call(test, test1, "If there is no bound value in the call we add the pivot bound(s) values");

				//pivot bound3	
				
				waitForElement(driver, updated_HeadVoyage_Toggle);
				String status3 = getAttribute(driver, updated_HeadVoyage_Toggle, "class");
				if(!status3.contains("s")) {
					click(driver, updated_HeadVoyage_Toggle);
				}
				waitForElement(driver, Port_Select);
				click(driver, Port_Select);	
				waitForElement(driver, Port_Select);
				RightClick(driver, Port_Select);

				waitForElement(driver, Add_Bound_3_Button);
				click(driver, Add_Bound_3_Button);	
				waitForDisplay(driver, addPivotBound3Frame);
				if (isDisplayed(driver, addPivotBound3Frame)) {
					waitForElement(driver, Bouund_DD_3);
					click(driver, Bouund_DD_3);
					waitForElement(driver, edit_Bound_3);
					click(driver, edit_Bound_3);
					waitForElement(driver, addPivotVoyage3InBound);
					sendKeys(driver, addPivotVoyage3InBound, pivotBound3);
					waitForElement(driver, bound3_OkButton);
					click(driver, bound3_OkButton);


					waitForDisplay(driver, popup_Message);
					if (isDisplayed(driver, popup_Message_Ok_Button)) {
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
					} else {
						waitForElement(driver, popup_Message_Yes_Button);
						click(driver, popup_Message_Yes_Button);
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
					}
				} else {
					
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
				}


				//pivot voyage 1
				Step_Start(7, "Switch to Pivot voyage 1 ", test, test1);

				waitForElement(driver, Tree_Structure);
				waitForElement(driver, NewVoyage);
				click(driver, NewVoyage);


				waitForElement(driver, NewVoyage);
				RightClick(driver, NewVoyage);
				waitForElement(driver, edit_Select);
				click(driver, edit_Select);

				waitForElement(driver, editVoyageFrame);
				String editVoyageTitle1=getText(driver, editVoyageFrame);

				System.out.println("Actual:"+editVoyageTitle1);
				System.out.println("Expected"+editVoyageText);

				if(editVoyageTitle1.equals(editVoyageText)) {
					System.out.println("Matched || " + " Expected Text : " + editVoyageText + " || Actual Text : " + editVoyageTitle1);
					Extent_pass_New(driver,"Matched || " + " Expected Text : " + editVoyageText + " || ActualText : " + editVoyageTitle1,test,test1);
					Extent_pass_New(driver, "Edit voyage frame is displayed", test,test1);
					System.out.println("Edit voyage frame is displayed");
					waitForElement(driver, Radio_Button_1);
					click(driver, Radio_Button_1);
					Step_Start(8, "Choose the Ports from the listed out Under the  Pivot voyage 1  and Enter the Voyage number for the  Pivot voyage 1", test, test1);

					waitForElement(driver, pivotVoyageTextField);
					clearAndType(driver, pivotVoyageTextField, pivotVoyage1);
					waitForElement(driver, check_Box);
					click(driver, check_Box);
					waitForElement(driver, moveToCSButton);
					click(driver, moveToCSButton);

					Step_End(8, "Choose the Ports from the listed out Under the  Pivot voyage 1  and Enter the Voyage number for the  Pivot voyage 1", test, test1);

					waitForDisplay(driver, popup_Message);
					if(isDisplayed(driver, popup_Message)) {
						click(driver, popup_Message_Yes_Button);
					}
					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
						click(driver, popup_Message_Ok_Button);
					}		 
				}else {
					System.out.println("Not matched || " + " Expected Text : " + editVoyageText + " || Actual Text : " + editVoyageTitle1+" || Edit voyage frame is not displayed");
					Extent_fail(driver,"Not matched || " + " Expected Text : " + editVoyageText + " || ActualText : " + editVoyageTitle1+" || Edit voyage frame is not displayed",test,test1);
				}
				Step_End(7, "Switch to Pivot voyage 1 ", test, test1);

				//Pivot Voyage 2
				Step_Start(9, "Switch to Pivot voyage 2", test, test1);
				waitForElement(driver, Tree_Structure);
				waitForElement(driver, NewVoyage);
				click(driver, NewVoyage);


				waitForElement(driver, NewVoyage);
				RightClick(driver, NewVoyage);
				waitForElement(driver, edit_Select);
				click(driver, edit_Select);


				waitForElement(driver, editVoyageFrame);
				String editVoyageTitle2=getText(driver, editVoyageFrame);

				System.out.println("Actual:"+editVoyageTitle2);
				System.out.println("Expected"+editVoyageText);

				if(editVoyageTitle2.equals(editVoyageText)) {
					System.out.println("Matched || " + " Expected Text : " + editVoyageText + " || Actual Text : " + editVoyageTitle2);
					Extent_pass_New(driver,"Matched || " + " Expected Text : " + editVoyageText + " || ActualText : " + editVoyageTitle2,test,test1);
					Extent_pass_New(driver, "Edit voyage frame is displayed", test,test1);
					System.out.println("Edit voyage frame is displayed");
					waitForElement(driver, Radio_Button_2);
					click(driver, Radio_Button_2);	
					Step_Start(10, "Choose the Ports from the listed out Under the  Pivot voyage 2  and Enter the Voyage number for the  Pivot voyage 2", test, test1);

					waitForElement(driver, pivotVoyageTextField);
					clearAndType(driver, pivotVoyageTextField, pivotVoyage2);
					waitForElement(driver, check_Box);
					click(driver, check_Box);
					waitForElement(driver, moveToCSButton);
					click(driver, moveToCSButton);
					Step_End(10, "Choose the Ports from the listed out Under the  Pivot voyage 2  and Enter the Voyage number for the  Pivot voyage 2", test, test1);

					waitForDisplay(driver, popup_Message);
					if(isDisplayed(driver, popup_Message)) {
						click(driver, popup_Message_Yes_Button);
					}
					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
						click(driver, popup_Message_Ok_Button);
					}

				}else {
					System.out.println("Not matched || " + " Expected Text : " + editVoyageText + " || Actual Text : " + editVoyageTitle2+" || Edit voyage frame is not displayed");
					Extent_fail(driver,"Not matched || " + " Expected Text : " + editVoyageText + " || ActualText : " + editVoyageTitle2+" || Edit voyage frame is not displayed",test,test1);
				}

				Step_End(9, "Switch to Pivot voyage 2", test, test1);

				Step_Start(11, "Switch to Pivot voyage 3", test, test1);
				//Pivot Voyage 3
				waitForDisplay(driver, Tree_Structure);
				
				waitForElement(driver, NewVoyage);
				click(driver, NewVoyage);

				waitForElement(driver, NewVoyage);
				RightClick(driver, NewVoyage);
				waitForElement(driver, edit_Select);
				click(driver, edit_Select);
				waitForElement(driver, editVoyageFrame);
				String editVoyageTitle3=getText(driver, editVoyageFrame);
				if(editVoyageTitle3.equals(editVoyageText)) {
					System.out.println("Matched || " + " Expected Text : " + editVoyageText + " || Actual Text : " + editVoyageTitle3);
					Extent_pass_New(driver,"Matched || " + " Expected Text : " + editVoyageText + " || ActualText : " + editVoyageTitle3,test,test1);
					Extent_pass_New(driver, "Edit voyage frame is displayed", test,test1);
					System.out.println("Edit voyage frame is displayed");
					waitForElement(driver, Radio_Button_3);
					click(driver, Radio_Button_3);
					Step_Start(12, "Choose the Ports from the listed out Under the Pivot voyage 3  and Enter the Voyage number for the  Pivot voyage 3", test, test1);
					waitForElement(driver, pivotVoyageTextField);
					clearAndType(driver, pivotVoyageTextField, pivotVoyage3);
					waitForElement(driver, check_Box);
					click(driver, check_Box);
					Step_End(12, "Choose the Ports from the listed out Under the Pivot voyage 3  and Enter the Voyage number for the  Pivot voyage 3", test, test1);

					Step_Start(13, "Click on Move to Coastal button", test, test1);

					waitForElement(driver, moveToCSButton);
					click(driver, moveToCSButton);
					Step_End(13, "Click on Move to Coastal button", test, test1);

					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
						click(driver, popup_Message_Yes_Button);
					}
					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
						click(driver, popup_Message_Ok_Button);
					}

				}else {
					System.out.println("Not matched || " + " Expected Text : " + editVoyageText + " || Actual Text : " + editVoyageTitle3+" || Edit voyage frame is not displayed");
					Extent_fail(driver,"Not matched || " + " Expected Text : " + editVoyageText + " || ActualText : " + editVoyageTitle3+" || Edit voyage frame is not displayed",test,test1);
				}

				Step_End(11, "Switch to Pivot voyage 3", test, test1);

				Step_Start(14, "System should update the Voyage numbers from the above actions", test, test1);
				//piv1
				waitForDisplay(driver, Temp_Remove);
				if(isdisplayed(driver, Temp_Remove)){
					waitForElement(driver, Temp_Remove);
					click(driver, Temp_Remove);
				}

				reArrangeAG_Grid_Outer_Column_CS(driver, Select_Columns);
				
				
				String actual_PivotVoyage_1_Gridcell=String.format(pivotVoyage_1_Gridcell, portName_CS07);
				String actual_PivotVoyage_2_Gridcell=String.format(pivotVoyage_2_Gridcell, portName_CS07);
				String actual_PivotVoyage_3_Gridcell=String.format(pivotVoyage_3_Gridcell, portName_CS07);

				waitForElement(driver, actual_PivotVoyage_1_Gridcell);
				String PivVoyage_1 = getText(driver, actual_PivotVoyage_1_Gridcell);
				String PivVoyage_2= getText(driver, actual_PivotVoyage_2_Gridcell);
				String PivVoyage_3= getText(driver, actual_PivotVoyage_3_Gridcell);
				
			
				
				if(pivotVoyage1.equals(PivVoyage_1)) {
					System.out.println("Matched || " + " Expected Pivot Voyage 1 : " + pivotVoyage1 + " || Actual Pivot Voyage 1 : " + PivVoyage_1);
					Extent_pass_New(driver,"Matched || " + " Expected Pivot Voyage 1 : " + pivotVoyage1 + " || ActualPivot Voyage 1 : " + PivVoyage_1,test,test1);
					Extent_pass_New(driver, "Pivot Voyage 1 is updated", test,test1);
					System.out.println("Pivot Voyage 1 is updated");
				}else {
					System.out.println("Not matched || " + " Expected Pivot Voyage 1 : " + pivotVoyage1 + " || Actual Pivot Voyage 1 : " + PivVoyage_1+" || Pivot Voyage 1 is not updated");
					Extent_fail(driver,"Not matched || " + " Expected Pivot Voyage 1 : " + pivotVoyage1 + " || ActualPivot Voyage 1 : " + PivVoyage_1+" || Pivot Voyage 1 is not updated",test,test1);
					Extent_fail(driver, "Pivot Voyage 1 is not updated", test,test1);
					System.out.println("Pivot Voyage 1 is not updated");
				}			 

				//piv2
				
				if(pivotVoyage2.equals(PivVoyage_2)) {
					System.out.println("Matched || " + " Expected Pivot Voyage 2 : " + pivotVoyage2 + " || Actual Pivot Voyage 2 : " + PivVoyage_2);
					Extent_pass_New(driver,"Matched || " + " Expected Pivot Voyage 2 : " + pivotVoyage2 + " || ActualPivot Voyage 2 : " + PivVoyage_2,test,test1);
					Extent_pass_New(driver, "Pivot Voyage 2 is updated", test,test1);
					System.out.println("Pivot Voyage 2 is updated");
				}else {
					System.out.println("Not matched || " + " Expected Pivot Voyage 2 : " + pivotVoyage2 + " || Actual Pivot Voyage 2 : " + PivVoyage_2+" || Pivot Voyage 2 is not updated");
					Extent_fail(driver,"Not matched || " + " Expected Pivot Voyage 2 : " + pivotVoyage2 + " || ActualPivot Voyage 2 : " + PivVoyage_2+" || Pivot Voyage 2 is not updated",test,test1);
				}			 

				//piv3
				
				if(pivotVoyage3.equals(PivVoyage_3)) {
					System.out.println("Matched || " + " Expected Pivot Voyage 3 : " + pivotVoyage3 + " || Actual Pivot Voyage 3 : " + PivVoyage_3);
					Extent_pass_New(driver,"Matched || " + " Expected Pivot Voyage 3 : " + pivotVoyage3 + " || ActualPivot Voyage 3 : " + PivVoyage_3,test,test1);
					Extent_pass_New(driver, "Pivot Voyage 3 is updated", test,test1);
					System.out.println("Pivot Voyage 3 is updated");
				}else {
					System.out.println("Not matched || " + " Expected Pivot Voyage 3 : " + pivotVoyage3 + " || Actual Pivot Voyage 3 : " + PivVoyage_3+" || Pivot Voyage 3 is not updated");
					Extent_fail(driver,"Not matched || " + " Expected Pivot Voyage 3 : " + pivotVoyage3 + " || ActualPivot Voyage 3 : " + PivVoyage_3+" || Pivot Voyage 3 is not updated",test,test1);
				}		
				Step_End(14, "System should update the Voyage numbers from the above actions", test, test1);		Step_End(14, "System should update the Voyage numbers from the above actions", test, test1);
		Extent_completed(testCaseName, test, test1);
		
		   }	
		
		   scrollTop(driver);
		   waitForElement(driver, Close_Current_tab);
		   click(driver, Close_Current_tab); 		
		     
		     
		 int cs8=8;
		 
		 if(cs8==8) {
			 
			 String testCaseName="TC_Coastal_Schedule_CS08";
				String File_Path_CS08 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
				String Sheet_Name_CS08 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
				Map<String, String> Excel_data_08 = Utils.GetAllData(Sheet_Name_CS08, testCaseName, "Dataset"+selected_dataset, File_Path_CS08);
				
				
				String ModuleSearch_CS08 =Excel_data_08.get("Module_Search");
				String ServiceCode_CS08 =Excel_data_08.get("Service_Code"); 
				String VesselCode_CS08 =Excel_data_08.get("Vessel_Code");
				String voyageNumber_CS08 =Excel_data_08.get("Voyage_Number");
				String portName_CS08 =Excel_data_08.get("Port_Name");
				String EditBound_Button_CS08 =Excel_data_08.get("Button");
				String after_Bound_1 =Excel_data_08.get("after_Bound_1");
				String after_Bound_2 =Excel_data_08.get("after_Bound_2");
				String after_Bound_3 =Excel_data_08.get("after_Bound_3");
				String Sub_Bound =Excel_data_08.get("Sub_Bound");
				String PF_Bound =Excel_data_08.get("PF_Bound");
				String Bound_1 =Excel_data_08.get("Bound_1");
				String Bound_2 =Excel_data_08.get("Bound_2");
				String Bound_3 =Excel_data_08.get("Bound_3");
				String Bound_4 =Excel_data_08.get("Sub_Bound_field");
				String Bound_5 =Excel_data_08.get("PF_Bound_field");
				String renamed_Popup =Excel_data_08.get("Renamed_Popup");
				String not_Same_Popup =Excel_data_08.get("Not_Same_Popup");
				String condition = Excel_data_08.get("Condition");
				String service_Search_Header = Excel_data_08.get("Service_Search_Header");
				String vessel_Search_Header = Excel_data_08.get("Vessel_Search_Header");

				String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler8,voyageNumber_CS08);
				String Port_Select = String.format(Coastal_Schedule_Locators.Port_Select8,voyageNumber_CS08,portName_CS08);
				String edit_Bound_1 = String.format(Coastal_Schedule_Locators.edit_Bound,after_Bound_1);
				String edit_Bound_2= String.format(Coastal_Schedule_Locators.edit_Bound,after_Bound_2);
				String edit_Bound_3 =String.format(Coastal_Schedule_Locators.edit_Bound,after_Bound_3);
				String Sub_Bound_edit=String.format(Coastal_Schedule_Locators.Sub_Bound_edit,Sub_Bound);
				String PF_Bound_Edit = String.format(Coastal_Schedule_Locators.PF_Bound_Edit,PF_Bound);
				String editbutton_Select =String.format(Coastal_Schedule_Locators.editbutton_Select,EditBound_Button_CS08);
				String edit_Bound_Button_1 =String.format(Coastal_Schedule_Locators.edit_Bound_Button8,Bound_1);
				String edit_Bound_Button_2 = String.format(Coastal_Schedule_Locators.edit_Bound_Button8,Bound_2);
				String edit_Bound_Button_3 = String.format(Coastal_Schedule_Locators.edit_Bound_Button8,Bound_3);
				String sub_Bound_Button = String.format(Coastal_Schedule_Locators.sub_Bound_Button,Bound_4);
				String PF_Bound_Button =String.format(Coastal_Schedule_Locators.PF_Bound_Button,Bound_5);

				Extent_Start(testCaseName, test, test1);

				
				moduleNavigate(driver, ModuleSearch_CS08);
				
				Step_Start(1, "Enter the Service Code in the service code field", test, test1);

				waitForElement(driver, Service_Search_Btn);
				click(driver, Service_Search_Btn);
				
				twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS08);
				
				Step_End(1, "Enter the Service Code in the service code field", test, test1);

				Step_Start(2, "Enter the Vessel ", test, test1);

				waitForElement(driver, Vessel_Search_Btn);
				click(driver, Vessel_Search_Btn);

				twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS08);


				Step_End(2, "Enter the Vessel ", test, test1);

				Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);

				waitForDisplay(driver, Tree_Structure);
				if(isdisplayed(driver,Tree_Structure)) {
					Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
					System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
				}else {
					System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

					Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
				}

				waitForElement(driver, Voyage_Toggler);
				String status = getAttribute(driver, Voyage_Toggler, "class");
				if(!status.contains("s")) {
					click(driver, Voyage_Toggler);
				}
				Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

				Step_Start(4, "Right click on the port which the bound of the port should be adjusted ", test, test1);
				waitForElement(driver, Port_Select);
				click(driver, Port_Select);	

				waitForElement(driver, Port_Select);
				RightClick(driver, Port_Select);
				waitForElement(driver, editbutton_Select);
				click(driver, editbutton_Select);

				Step_End(4, "Right click on the port which the bound of the port should be adjusted ", test, test1);
				waitForElement(driver, PF_Bound_Button);
				click(driver, PF_Bound_Button);

				Step_Start(5, "Choose Edit Bound Option", test, test1);
				waitForElement(driver, PF_Bound_Edit);
				click(driver, PF_Bound_Edit);
				Step_End(5, "Choose Edit Bound Option", test, test1);

				Step_Start(6, "Update the Bound for the Respective Bound(s)", test, test1);
				waitForElement(driver, sub_Bound_Button);
				click(driver, sub_Bound_Button);
				waitForElement(driver, Sub_Bound_edit);
				click(driver, Sub_Bound_edit);

				waitForElement(driver, edit_Bound_Button_1);
				click(driver, edit_Bound_Button_1);
				waitForElement(driver, edit_Bound_1);
				click(driver, edit_Bound_1);	

				waitForElement(driver, edit_Bound_Button_2);
				click(driver, edit_Bound_Button_2);
				waitForElement(driver, edit_Bound_2);
				click(driver, edit_Bound_2);

				waitForElement(driver, edit_Bound_Button_3);
				click(driver, edit_Bound_Button_3);
				waitForElement(driver, edit_Bound_3);
				click(driver, edit_Bound_3);

				Step_End(6, "Update the Bound for the Respective Bound(s)", test, test1);

				Step_Start(7, "Click on Move to Coastal", test, test1);
				waitForElement(driver, editboundOk);
				click(driver, editboundOk);
				
				waitForDisplay(driver, popup_Message_Yes_Button);
				if(isdisplayed(driver, popup_Message_Yes_Button)) {
					click(driver, popup_Message_Yes_Button);
					}
				
				waitForPopup(driver, popup_Message, renamed_Popup);
				String renamed_Bound_Name = getText(driver, popup_Message);
				if(renamed_Bound_Name.contains(not_Same_Popup)) {
					Extent_pass_New(driver, "Matched || Expected popup is : "+not_Same_Popup+" Actual popup is : "+ renamed_Bound_Name, test, test1);
					System.out.println("Matched || Expected popup is : "+not_Same_Popup+" Actual popup is : "+ renamed_Bound_Name);
				}
				else if (renamed_Popup.equals(renamed_Bound_Name)) {
					Extent_pass_New(driver, "Matched || Expected popup is : "+renamed_Popup+" Actual popup is : "+ renamed_Bound_Name, test, test1);
					System.out.println("Matched || Expected popup is : "+renamed_Popup+" Actual popup is : "+ renamed_Bound_Name);
					click(driver, popup_Message_Ok_Button);
					waitForElement(driver, Port_Select);
					String pivotbound1 = getText(driver, Port_Select);
					String act_Bound_Value = "[" + Sub_Bound + "B]";
					if (pivotbound1.contains(act_Bound_Value)) {
						System.out.println("Matched || Expected Pivot bound : "+act_Bound_Value+" || Actual Pivot bound : "+pivotbound1);
						Extent_pass_New(driver, "Matched || Expected Pivot bound : "+act_Bound_Value+" || Actual Pivot bound : "+pivotbound1, test,test1);
					} else {
						System.out.println("Not Matched || Expected Pivot bound : "+act_Bound_Value+" || Actual Pivot bound : "+pivotbound1);
						Extent_fail(driver, "Not Matched || Expected Pivot bound : "+act_Bound_Value+" || Actual Pivot bound : "+pivotbound1, test,test1);
						
					}
					click(driver, Port_Select);			
				}
				else {
					System.out.println("Bound Renamed text is not displayed");
					Extent_fail(driver, "Bound Renamed text is not displayed", test,test1);
				}
				Step_End(7, "Click on Move to Coastal", test, test1);
				Extent_completed(testCaseName, test, test1);


			}
		 scrollTop(driver);
		   waitForElement(driver, Close_Current_tab);
		   click(driver, Close_Current_tab); 		
		     
		     
		 int cs9=9;
		 
		 if(cs9==9) {
			 String testCaseName="TC_Coastal_Schedule_CS09";
				String File_Path_CS09 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
				String Sheet_Name_CS09 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
				Map<String, String> Excel_data_09 = Utils.GetAllData(Sheet_Name_CS09, testCaseName, "Dataset"+selected_dataset, File_Path_CS09);

				String Add_Bound_1_CS09 =Excel_data_09.get("Add_Bound_1");
				String Add_Bound_2_CS09 =Excel_data_09.get("Add_Bound_2");
				String Add_Bound_3_CS09 =Excel_data_09.get("Add_Bound_3");
				String pivotBound1_CS09=Excel_data_09.get( "PivotBound1");
				String pivotBound2_CS09=Excel_data_09.get( "PivotBound2");
				String pivotBound3_CS09=Excel_data_09.get( "PivotBound3");
				String ModuleSearch_CS09 =Excel_data_09.get("Module_Search");
				String ServiceCode_CS09 =Excel_data_09.get("Service_Code"); 
				String VesselCode_CS09 =Excel_data_09.get("Vessel_Code");
				String voyageNumber_CS09 =Excel_data_09.get("Voyage_Number");
				String portName_CS09 =Excel_data_09.get("Port_Name");
				String Bound_1_CS09=Excel_data_09.get("Bound_1");
				String Bound_2_CS09 =Excel_data_09.get("Bound_2");
				String Bound_3_CS09= Excel_data_09.get("Bound_3");
				String remove_Bound_1_CS09=Excel_data_09.get("remove_Bound_1");
				String remove_Bound_2_CS09 =Excel_data_09.get("remove_Bound_2");
				String remove_Bound_3_CS09= Excel_data_09.get("remove_Bound_3");
				String Do_You_Want_Remove_Bound= Excel_data_09.get("Do_You_Want_Remove_Bound");
				String Select_Columns= Excel_data_09.get("Select_Columns");

				String pivot_Bount1= Excel_data_09.get("Pivot_Bount1");
				String pivot_Bount2= Excel_data_09.get("Pivot_Bount2");
				String pivot_Bount3= Excel_data_09.get("Pivot_Bount3");
				String pivotBound_1_Added= Excel_data_09.get("PivotBound_1_Added");
				String pivotBound_2_Added= Excel_data_09.get("PivotBound_2_Added");
				String pivotBound_3_Added= Excel_data_09.get("PivotBound_3_Added");
				String subBoundAddedPopup = Excel_data_09.get("SubBoundAddedPopup");
				String selectSubBound = Excel_data_09.get("SubBound");
				String alreadyHaveSubBoundPopup = Excel_data_09.get("AlreadyHaveSubBoundPopup");

				String subBoundRemovedPopup = Excel_data_09.get("SubBoundRemovedPopup");
				String cannotRemovePopup = Excel_data_09.get("CannotRemovePopup");
				String noPivotBound_1_Popup = Excel_data_09.get("NoPivotBound_1_Popup");
				String noPivotBound_2_Popup = Excel_data_09.get("NoPivotBound_2_Popup");
				String noPivotBound_3_Popup = Excel_data_09.get("NoPivotBound_3_Popup");
				String onlyOnePivotBound_Popup = Excel_data_09.get("OnlyOnePivotBound_Popup");
				String Bound_1_Popup=Excel_data_09.get("Bound_1_Popup");
				String Bound_2_Popup =Excel_data_09.get("Bound_2_Popup");
				String Bound_3_Popup= Excel_data_09.get("Bound_3_Popup");
				String wantToContinuePopup= Excel_data_09.get("WantToContinuePopup");
				String onlyOneSubBound= Excel_data_09.get("OnlyOneSubBound");



				String  service_Select = String.format(Coastal_Schedule_Locators.serviceSelect, ServiceCode_CS09);
				String  vessel_Select = String.format(Coastal_Schedule_Locators.vesselSelect, VesselCode_CS09);
				String  Voyage_Toggler = String.format(Coastal_Schedule_Locators.voyageToggler, voyageNumber_CS09);
				String add_1_Select =  String.format(Coastal_Schedule_Locators.addBound_Option, Add_Bound_1_CS09);
				String add_2_Select = String.format(Coastal_Schedule_Locators.addBound_Option, Add_Bound_2_CS09);
				String add_3_Select =String.format(Coastal_Schedule_Locators.addBound_Option, Add_Bound_3_CS09);
				String remove_1_Select = String.format(Coastal_Schedule_Locators.removeBound_Option, remove_Bound_1_CS09);
				String remove_2_Select = String.format(Coastal_Schedule_Locators.removeBound_Option, remove_Bound_2_CS09);
				String remove_3_Select = String.format(Coastal_Schedule_Locators.removeBound_Option, remove_Bound_3_CS09);
				String  Port_Select = String.format(Coastal_Schedule_Locators.port_Select, voyageNumber_CS09,portName_CS09);

				String edit_Bound_1 = String.format(Coastal_Schedule_Locators.editBound, Bound_1_CS09);
				String edit_Bound_2 = String.format(Coastal_Schedule_Locators.editBound, Bound_2_CS09);
				String edit_Bound_3 = String.format(Coastal_Schedule_Locators.editBound, Bound_3_CS09);




				Extent_Start(testCaseName, test, test1);

				
				moduleNavigate(driver, ModuleSearch_CS09);

				Step_Start(1, "Enter the Service Code  in the service code field", test, test1);
				waitForElement(driver, Service_Txt_Field);
				sendKeys(driver, Service_Txt_Field, ServiceCode_CS09);
				waitForElement(driver, service_Select);
				click(driver, service_Select);
				
				Step_End(1, "Enter the Service Code  in the service code field", test, test1);

				Step_Start(2, "Enter the Vessel ", test, test1);
				waitForElement(driver, Vessel_Txt_Field);
				sendKeys(driver, Vessel_Txt_Field, VesselCode_CS09);
				waitForElement(driver, vessel_Select);
				click(driver, vessel_Select);
				
				Step_End(2, "Enter the Vessel ", test, test1);
				
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
				
				Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
				waitForDisplay(driver, Tree_Structure);
				if(isdisplayed(driver,Tree_Structure)) {
					Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
					System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
				}else {
					System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

					Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
				}
				Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
				Step_Start(4, "Right click on the port which the bound of the port should be added", test, test1);

				waitForElement(driver, Voyage_Toggler);
				String status = getAttribute(driver, Voyage_Toggler, "class");
				if(!status.contains("s")) {
					click(driver, Voyage_Toggler);
				}


				// Add sub bound
				waitForElement(driver, Port_Select);
				click(driver, Port_Select);
				waitForElement(driver, Port_Select);
				RightClick(driver, Port_Select);
				Step_End(4, "Right click on the port which the bound of the port should be added", test, test1);

				Step_Start(5, "Choose Add Sub Bound Option ", test, test1);

				waitForElement(driver, add_subbound);
				click(driver, add_subbound);

				Step_End(5, "Choose Add Sub Bound Option ", test, test1);
				Step_Start(6, "Choose the Bound from the Drop Down", test, test1);
				Step_Start(7, "System should show Validation if the port already has Sub Bound", test, test1);

				waitForDisplay(driver, popup_Message);
				if(isDisplayed(driver, popup_Message)) {
					String actualPopup=getText(driver, popup_Message);
					System.out.println("actualPopup:"+actualPopup);
					if(actualPopup.equals(alreadyHaveSubBoundPopup)) {

						System.out.println("Matched || " + " Expected Popup is : " + alreadyHaveSubBoundPopup + " || Actual Popup is : " + actualPopup);
						Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + alreadyHaveSubBoundPopup + " || ActualPopup is : " + actualPopup,test,test1);
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver,popup_Message_Ok_Button);

					}

				}else {
					waitForElement(driver, subBound_Dropdown);
					click(driver, subBound_Dropdown);

					String select_SubBound = String.format(Coastal_Schedule_Locators.subBound_Option, selectSubBound);
					waitForElement(driver, select_SubBound);
					click(driver, select_SubBound);

					waitForElement(driver, Subbound_ok);
					click(driver, Subbound_ok);

					Step_End(6, "Choose the Bound from the Drop Down", test, test1);
					waitForPopup(driver, popup_Message, subBoundAddedPopup);
					String actPopup = getText(driver, popup_Message);

					if (actPopup.equals(subBoundAddedPopup)) {
						System.out.println("Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || Actual Popup is : " + actPopup);
						Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || ActualPopup is : " + actPopup,test,test1);
						click(driver,popup_Message_Ok_Button);


					}else if(actPopup.contains(wantToContinuePopup)) {
						System.out.println("Matched || " + " Expected Popup is : " + wantToContinuePopup + " || Actual Popup is : " + actPopup);
						Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + wantToContinuePopup + " || ActualPopup is : " + actPopup,test,test1);
						click(driver,popup_Message_Yes_Button);
						waitForElement(driver, popup_Message_Ok_Button);
						String actPopup2=getText(driver, popup_Message);
						if (actPopup2.equals(subBoundAddedPopup)) {
							System.out.println("Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || Actual Popup is : " + actPopup2);
							Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || ActualPopup is : " + actPopup2,test,test1);
							click(driver,popup_Message_Ok_Button);

						}

					}
					else {
						System.out.println("Not Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || Actual Popup is : " + actPopup);
						Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || ActualPopup is : " + actPopup,test,test1);
					}
				}
				Step_End(7, "System should show Validation if the port already has Sub Bound", test, test1);


				Step_Start(8, "Choose Add Pivot Bound 1 Option ", test, test1);
				//pivot bound1	
				waitForElement(driver, Voyage_Toggler);
				String status1 = getAttribute(driver, Voyage_Toggler, "class");
				if(!status1.contains("s")) {
					click(driver, Voyage_Toggler);
				}
				
				waitForElement(driver, Port_Select);
				click(driver, Port_Select);

				waitForElement(driver, Port_Select);
				RightClick(driver, Port_Select);

				waitForElement(driver, add_1_Select);
				click(driver, add_1_Select);
				Step_End(8, "Choose Add Pivot Bound 1 Option ", test, test1);
				Step_Start(9, "Choose the Bound from the Drop Down", test, test1);
				waitForDisplay(driver, addPivotBound1Frame);
				if(isDisplayed(driver, addPivotBound1Frame)) {
					waitForElement(driver, Bouund_DD_1);
					click(driver, Bouund_DD_1);
					waitForElement(driver, edit_Bound_1);
					click(driver, edit_Bound_1);
					Step_End(9, "Choose the Bound from the Drop Down", test, test1);
					Step_Start(10, "Enter the Pivot Voyage 1 Value", test, test1);
					waitForElement(driver, addPivotVoyage1InBound);
					sendKeys(driver, addPivotVoyage1InBound, pivotBound1_CS09);		
					waitForElement(driver, boundOkButton);
					click(driver, boundOkButton);

					Step_End(10, "Enter the Pivot Voyage 1 Value", test, test1);
					Step_Start(11, "System should show Validation if the port already has Pivot Bound 1", test, test1);

					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
						String actualPopup1=getText(driver, popup_Message);
						System.out.println("actualPopup1:"+actualPopup1);
						if(actualPopup1.equals(pivotBound_1_Added)) {
							System.out.println("Matched || " + " Expected Popup is : " + pivotBound_1_Added + " || Actual Popup is : " + actualPopup1);
							Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivotBound_1_Added + " || ActualPopup is : " + actualPopup1,test,test1);
							click(driver,popup_Message_Ok_Button);
						}else {
							System.out.println("Not Matched || " + " Expected Popup is : " + pivotBound_1_Added + " || Actual Popup is : " + actualPopup1);
							Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + pivotBound_1_Added + " || ActualPopup is : " + actualPopup1,test,test1);
						}
					}
				}else if(isDisplayed(driver, popup_Message)){
					String actPopup=getText(driver, popup_Message);
					if(actPopup.equals(pivot_Bount1)) {
						System.out.println("Matched || " + " Expected Popup is : " + pivot_Bount1 + " || Actual Popup is : " + actPopup);
						Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivot_Bount1 + " || Actual Popup is : " + actPopup,test,test1);
						click(driver,popup_Message_Ok_Button);
					}
				}
				Step_End(11, "System should show Validation if the port already has Pivot Bound 1", test, test1);
				//	pivot bound2	 

				Step_Start(12, "Choose Add Pivot Bound 2 Option ", test, test1);
				
				waitForElement(driver, Voyage_Toggler);
				String status2 = getAttribute(driver, Voyage_Toggler, "class");
				if(!status2.contains("s")) {
					click(driver, Voyage_Toggler);
				}
				
				waitForElement(driver, Port_Select);
				click(driver, Port_Select);

				waitForElement(driver, Port_Select);
				RightClick(driver, Port_Select);

				waitForElement(driver, add_2_Select);
				click(driver, add_2_Select);
				Step_End(12, "Choose Add Pivot Bound 2 Option ", test, test1);

				Step_Start(13, "Choose the Bound from the Drop Down", test, test1);
				waitForDisplay(driver, addPivotBound2Frame);
				if (isDisplayed(driver, addPivotBound2Frame)) {
					Extent_call(test, test1, "Choose the Bound from the Drop Down");
					waitForElement(driver, Bouund_DD_2);
					click(driver, Bouund_DD_2);

					waitForElement(driver, edit_Bound_2);
					click(driver, edit_Bound_2);

					Step_End(13, "Choose the Bound from the Drop Down", test, test1);
					Step_Start(14, "Enter the Pivot Voyage 2 Value", test, test1);

					waitForElement(driver, addPivotVoyage2InBound);
					sendKeys(driver, addPivotVoyage2InBound, pivotBound2_CS09);
					waitForElement(driver, bound2_OkButton);
					click(driver, bound2_OkButton);
					Step_End(14, "Enter the Pivot Voyage 2 Value", test, test1);
					Step_Start(15, "System should show Validation if the port already has Pivot Bound 2", test, test1);

					waitForPopup(driver, popup_Message, pivotBound_2_Added);

					String actualPopup2=getText(driver, popup_Message);
					System.out.println("actualPopup2:"+actualPopup2);
					if(actualPopup2.equals(pivotBound_2_Added)) {
						System.out.println("Matched || " + " Expected Popup is : " + pivotBound_2_Added + " || Actual Popup is : " + actualPopup2);
						Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivotBound_2_Added + " || ActualPopup is : " + actualPopup2,test,test1);
						click(driver,popup_Message_Ok_Button);
					}else {
						System.out.println("Not Matched || " + " Expected Popup is : " + pivotBound_2_Added + " || Actual Popup is : " + actualPopup2);
						Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + pivotBound_2_Added + " || ActualPopup is : " + actualPopup2,test,test1);
					}
				} else if(isDisplayed(driver, popup_Message)){
					String actPopup=getText(driver, popup_Message);
					if(actPopup.equals(pivot_Bount2)) {
						System.out.println("Matched || " + " Expected Popup is : " + pivot_Bount2 + " || Actual Popup is : " + actPopup);
						Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivot_Bount2 + " || Actual Popup is : " + actPopup,test,test1);
						click(driver,popup_Message_Ok_Button);
					}
				}

				Step_End(15, "System should show Validation if the port already has Pivot Bound 2", test, test1);

				Step_Start(16, "Choose Add Pivot Bound 3 Option ", test, test1);
				//pivot bound3	
				
				waitForElement(driver, Voyage_Toggler);
				String status3 = getAttribute(driver, Voyage_Toggler, "class");
				if(!status3.contains("s")) {
					click(driver, Voyage_Toggler);
				}
				
				waitForElement(driver, Port_Select);
				click(driver, Port_Select);

				waitForElement(driver, Port_Select);
				RightClick(driver, Port_Select);
				waitForElement(driver, add_3_Select);
				click(driver, add_3_Select);

				Step_End(16, "Choose Add Pivot Bound 3 Option ", test, test1);
				Step_Start(17, "Choose the Bound from the Drop Down", test, test1);
				waitForDisplay(driver, addPivotBound3Frame);
				if (isDisplayed(driver, addPivotBound3Frame)) {
					Extent_call(test, test1, "Choose the Bound from the Drop Down");
					waitForElement(driver, Bouund_DD_3);
					click(driver, Bouund_DD_3);
					waitForElement(driver, edit_Bound_3);
					click(driver, edit_Bound_3);

					Step_End(17, "Choose the Bound from the Drop Down", test, test1);
					Step_Start(18, "Enter the Pivot Voyage 3 Value", test, test1);
					waitForElement(driver, addPivotVoyage3InBound);
					sendKeys(driver, addPivotVoyage3InBound, pivotBound3_CS09);
					waitForElement(driver, bound3_OkButton);
					click(driver, bound3_OkButton);
					Step_End(18, "Enter the Pivot Voyage 3 Value", test, test1);
					Step_Start(19, "System should show Validation if the port already has Pivot Bound 3", test, test1);
					waitForPopup(driver, popup_Message, pivotBound_3_Added);

					String actualPopup3=getText(driver, popup_Message);
					System.out.println("actualPopup3:"+actualPopup3);
					if(actualPopup3.equals(pivotBound_3_Added)) {
						System.out.println("Matched || " + " Expected Popup is : " + pivotBound_3_Added + " || Actual Popup is : " + actualPopup3);
						Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivotBound_3_Added + " || ActualPopup is : " + actualPopup3,test,test1);
						click(driver,popup_Message_Ok_Button);
					}else {
						System.out.println("Not Matched || " + " Expected Popup is : " + pivotBound_3_Added + " || Actual Popup is : " + actualPopup3);
						Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + pivotBound_3_Added + " || ActualPopup is : " + actualPopup3,test,test1);
					}
				} else if(isDisplayed(driver, popup_Message)){
					String actPopup=getText(driver, popup_Message);
					if(actPopup.equals(pivot_Bount3)) {
						System.out.println("Matched || " + " Expected Popup is : " + pivot_Bount3 + " || Actual Popup is : " + actPopup);
						Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivot_Bount3 + " || Actual Popup is : " + actPopup,test,test1);
						click(driver,popup_Message_Ok_Button);
					}
				}


				Step_End(19, "System should show Validation if the port already has Pivot Bound 3", test, test1);

				waitForElement(driver, Tree_Structure);
				String status4 = getAttribute(driver, Voyage_Toggler, "class");
				if(!status4.contains("s")) {
					waitForElement(driver, Voyage_Toggler);
					click(driver, Voyage_Toggler);
				}
				waitForElement(driver, Port_Select);
				click(driver, Port_Select);	
				waitForDisplay(driver, Temp_Remove);
				if(isdisplayed(driver, Temp_Remove)){
					waitForElement(driver, Temp_Remove);
					click(driver, Temp_Remove);
				}
				
				reArrangeAG_Grid_Outer_Column_CS(driver, Select_Columns);
				
				
				String actual_PivotBound_1_Gridcell=String.format(pivotBound_1_Gridcell, portName_CS09);
				String actual_PivotBound_2_Gridcell=String.format(pivotBound_2_Gridcell, portName_CS09);
				String actual_PivotBound_3_Gridcell=String.format(pivotBound_3_Gridcell, portName_CS09);

				waitForElement(driver, actual_PivotBound_1_Gridcell);
				String beforeBound_1 = getText(driver, actual_PivotBound_1_Gridcell);
				String beforeBound_2= getText(driver, actual_PivotBound_2_Gridcell);
				String beforeBound_3= getText(driver, actual_PivotBound_3_Gridcell);

				//piv1
				if(beforeBound_1.equals(Bound_1_CS09)) {
					System.out.println("Matched || The Expected Added Bound value is : "+Bound_1_CS09+" || The Actuall Added Bound value is : "+beforeBound_1);
					Extent_pass_New(driver, "Matched || The Expected Added Bound value is : "+Bound_1_CS09+" || The Actuall Added Bound value is : "+beforeBound_1, test, test1);
				}else {
					System.out.println("Not Matched || The Expected Added Bound value is : "+Bound_1_CS09+" || Actuall Bound value is Not Added: "+beforeBound_1);
					Extent_fail(driver, "Not Matched || The Expected Added Bound value is : "+Bound_1_CS09+" || The Actuall Added Bound value is : "+beforeBound_1, test, test1);
				}
				//piv2

				if(beforeBound_2.equals(Bound_2_CS09)) {
					System.out.println("Matched || The Expected Added Bound value is : "+Bound_2_CS09+" || The Actuall Added Bound value is : "+beforeBound_2);
					Extent_pass_New(driver, "Matched || The Expected Added Bound value is : "+Bound_2_CS09+" || The Actuall Added Bound value is : "+beforeBound_2, test, test1);
				}else {
					System.out.println("Not Matched || The Expected Added Bound value is : "+Bound_2_CS09+" || Actuall Bound value is Not Added: "+beforeBound_2);
					Extent_fail(driver, "Not Matched || The Expected Added Bound value is : "+Bound_2_CS09+" || The Actuall Added Bound value is : "+beforeBound_2, test, test1);
				}
				//piv3
				
				if(beforeBound_3.equals(Bound_3_CS09)) {
					System.out.println("Matched || The Expected Added Bound value is : "+Bound_3_CS09+" || The Actuall Added Bound value is : "+beforeBound_3);
					Extent_pass_New(driver, "Matched || The Expected Added Bound value is : "+Bound_3_CS09+" || The Actuall Added Bound value is : "+beforeBound_3, test, test1);
				}else {
					System.out.println("Not Matched || The Expected Added Bound value is : "+Bound_3_CS09+" || Actuall Bound value is Not Added: "+beforeBound_3);
					Extent_fail(driver, "Not Matched || The Expected Added Bound value is : "+Bound_3_CS09+" || The Actuall Added Bound value is : "+beforeBound_3, test, test1);
				}


				if(Do_You_Want_Remove_Bound.equalsIgnoreCase("Yes")) {
					Extent_cal(test, test1, "Remove pivot bounds");
					waitForElement(driver, Tree_Structure);
					waitForElement(driver, Voyage_Toggler);
					status4 = getAttribute(driver, Voyage_Toggler, "class");
					if(!status4.contains("s")) {
						click(driver, Voyage_Toggler);
					}



					waitForElement(driver, Port_Select);
					click(driver, Port_Select);

					waitForElement(driver, Port_Select);
					RightClick(driver, Port_Select);


					waitForElement(driver, remove_1_Select);
					click(driver, remove_1_Select);

					Step_End(8, "Click on Remove Pivot bound 1 ", test, test1);
					Step_Start(9, "System should remove the pivot bound 1 ", test, test1);
					Step_Start(10, "If the port doesn’t have pivot bound 1 systems should validation “There is no pivot bound 1 to remove”", test, test1);
					Step_Start(11, "If the pivot bound is the only bound for the port , system should show validation” This Call having only one Bound. So, cannot Remove this Pivot Bound.", test, test1);

					waitForPopup(driver, popup_Message, Bound_1_Popup);
					String pivot_1_Removed = getText(driver, popup_Message);
					if(pivot_1_Removed.equals(Bound_1_Popup)) {
						System.out.println("Matched || " + " Expected Popup : " + Bound_1_Popup + " || Actual Popup : " + pivot_1_Removed);
						Extent_pass_New(driver,"Matched || " + " Expected Popup : " + Bound_1_Popup + " || ActualPopup : " + pivot_1_Removed,test,test1);
						click(driver,popup_Message_Ok_Button);
					} 
					else if(pivot_1_Removed.equals(noPivotBound_1_Popup)) {
						System.out.println("Matched || " + " Expected Popup : " + noPivotBound_1_Popup + " || Actual Popup : " + pivot_1_Removed);
						Extent_pass_New(driver,"Matched || " + " Expected Popup : " + noPivotBound_1_Popup + " || ActualPopup : " + pivot_1_Removed,test,test1);
						click(driver,popup_Message_Ok_Button);
					} 
					else if(pivot_1_Removed.equals(onlyOnePivotBound_Popup)) {
						System.out.println("Matched || " + " Expected Popup : " + onlyOnePivotBound_Popup + " || Actual Popup : " + pivot_1_Removed);
						Extent_pass_New(driver,"Matched || " + " Expected Popup : " + onlyOnePivotBound_Popup + " || ActualPopup : " + pivot_1_Removed,test,test1);
						click(driver,popup_Message_Ok_Button);
					} 	else {
						System.out.println("Not Matched || " + " Expected Popup : " + Bound_1_Popup + " || Actual Popup : " + pivot_1_Removed);
						Extent_fail(driver, "Not Matched || " + " Expected Popup : " + Bound_1_Popup + " || Actual Popup : " + pivot_1_Removed, test, test1);
					}
					Step_End(9, "System should remove the pivot bound 1 ", test, test1);
					Step_End(10, "If the port doesn’t have pivot bound 1 systems should validation “There is no pivot bound 1 to remove”", test, test1);

					Step_End(11, "If the pivot bound is the only bound for the port , system should show validation” This Call having only one Bound. So, cannot Remove this Pivot Bound.", test, test1);
					Step_Start(12, "Click on Remove Pivot bound 2 ", test, test1);

					waitForElement(driver, Tree_Structure);

					waitForElement(driver, Voyage_Toggler);
					status4 = getAttribute(driver, Voyage_Toggler, "class");
					if(!status4.contains("s")) {
						click(driver, Voyage_Toggler);
					}


					waitForElement(driver, Port_Select);
					click(driver, Port_Select);


					waitForElement(driver, Port_Select);
					RightClick(driver, Port_Select);


					waitForElement(driver, remove_2_Select);
					click(driver, remove_2_Select);
					Step_End(12, "Click on Remove Pivot bound 2 ", test, test1);
					Step_Start(13, "System should remove the pivot bound 2 ", test, test1);
					Step_Start(14, "If the port doesn’t have pivot bound 2 systems should validation “There is no pivot bound 2 to remove”", test, test1);
					Step_Start(15, "If the pivot bound is the only bound for the port , system should show validation” This Call having only one Bound. So, cannot Remove this Pivot Bound.", test, test1);

					waitForPopup(driver, popup_Message, Bound_2_Popup);
					String pivot_2_Removed = getText(driver, popup_Message);
					if(pivot_2_Removed.equals(Bound_2_Popup)) {
						System.out.println("Matched || " + " Expected Popup : " + Bound_2_Popup + " || Actual Popup : " + pivot_2_Removed);
						Extent_pass_New(driver,"Matched || " + " Expected Popup : " + Bound_2_Popup + " || ActualPopup : " + pivot_2_Removed,test,test1);
						click(driver,popup_Message_Ok_Button);
					} 
					else if(pivot_2_Removed.equals(noPivotBound_2_Popup)) {
						System.out.println("Matched || " + " Expected Popup : " + noPivotBound_2_Popup + " || Actual Popup : " + pivot_2_Removed);
						Extent_pass_New(driver,"Matched || " + " Expected Popup : " + noPivotBound_2_Popup + " || ActualPopup : " + pivot_2_Removed,test,test1);
						click(driver,popup_Message_Ok_Button);
					} 

					else if(pivot_2_Removed.equals(onlyOnePivotBound_Popup)) {
						System.out.println("Matched || " + " Expected Popup : " + onlyOnePivotBound_Popup + " || Actual Popup : " + pivot_2_Removed);
						Extent_pass_New(driver,"Matched || " + " Expected Popup : " + onlyOnePivotBound_Popup + " || ActualPopup : " + pivot_2_Removed,test,test1);
						click(driver,popup_Message_Ok_Button);
					} else {
						System.out.println("Not Matched || " + " Expected Popup : " + Bound_2_Popup + " || Actual Popup : " + pivot_2_Removed);
						Extent_fail(driver, "Not Matched || " + " Expected Popup : " + Bound_2_Popup + " || Actual Popup : " + pivot_2_Removed, test, test1);
					}
					Step_End(13, "System should remove the pivot bound 2 ", test, test1);

					Step_End(14, "If the port doesn’t have pivot bound 2 systems should validation “There is no pivot bound 2 to remove”", test, test1);

					Step_End(15, "If the pivot bound is the only bound for the port , system should show validation” This Call having only one Bound. So, cannot Remove this Pivot Bound.", test, test1);
					Step_Start(16, "Click on Remove Pivot bound 3 ", test, test1);

					waitForElement(driver, Tree_Structure);
					waitForElement(driver, Voyage_Toggler);
					status4 = getAttribute(driver, Voyage_Toggler, "class");
					if(!status4.contains("s")) {
						click(driver, Voyage_Toggler);
					}

					waitForElement(driver, Port_Select);
					click(driver, Port_Select);

					waitForElement(driver, Port_Select);
					RightClick(driver, Port_Select);

					waitForElement(driver, remove_3_Select);
					click(driver, remove_3_Select);
					Step_Start(16, "Click on Remove Pivot bound 3 ", test, test1);
					Step_Start(17, "System should remove the pivot bound 3 ", test, test1);
					Step_Start(18, "If the port doesn’t have pivot bound 3 systems should validation “There is no pivot bound 3 to remove”", test, test1);
					Step_Start(19, "If the pivot bound is the only bound for the port , system should show validation” This Call having only one Bound. So, cannot Remove this Pivot Bound.", test, test1);

					waitForPopup(driver, popup_Message, Bound_3_Popup);
					String pivot_3_Removed = getText(driver, popup_Message);
					if(pivot_3_Removed.equals(Bound_3_Popup)) {
						System.out.println("Matched || " + " Expected Value is : " + Bound_3_Popup + " || Actual Value is : " + pivot_3_Removed);
						Extent_pass_New(driver,"Matched || " + " Expected Value is : " + Bound_3_Popup + " || ActualValue is : " + pivot_3_Removed,test,test1);
						click(driver,popup_Message_Ok_Button);
					} 
					else if(pivot_3_Removed.equals(noPivotBound_3_Popup)) {
						System.out.println("Matched || " + " Expected Value is : " + noPivotBound_3_Popup + " || Actual Value is : " + pivot_3_Removed);
						Extent_pass_New(driver,"Matched || " + " Expected Value is : " + noPivotBound_3_Popup + " || ActualValue is : " + pivot_3_Removed,test,test1);
						click(driver,popup_Message_Ok_Button);
					} 
					else if(pivot_3_Removed.equals(onlyOnePivotBound_Popup)) {
						System.out.println("Matched || " + " Expected Value is : " + onlyOnePivotBound_Popup + " || Actual Value is : " + pivot_3_Removed);
						Extent_pass_New(driver,"Matched || " + " Expected Value is : " + onlyOnePivotBound_Popup + " || ActualValue is : " + pivot_3_Removed,test,test1);
						click(driver,popup_Message_Ok_Button);
					}else {
						System.out.println("Not Matched || " + " Expected Popup : " + Bound_3_Popup + " || Actual Popup : " + pivot_3_Removed);
						Extent_fail(driver, "Not Matched || " + " Expected Popup : " + Bound_3_Popup + " || Actual Popup : " + pivot_3_Removed, test, test1);
					}
					// Remove sub bound

					waitForElement(driver, Port_Select);
					click(driver, Port_Select);

					waitForElement(driver, Port_Select);
					RightClick(driver, Port_Select);

					waitForElement(driver, Remove_subboundnew);
					click(driver, Remove_subboundnew);


					waitForPopup(driver, popup_Message, subBoundRemovedPopup);
					String actRemovedPopup = getText(driver, popup_Message);

					if (actRemovedPopup.equals(subBoundRemovedPopup)) {
						System.out.println("Matched || " + " Expected Popup : " + subBoundRemovedPopup + " || Actual Popup : " + actRemovedPopup);
						Extent_pass_New(driver,"Matched || " + " Expected Popup : " + subBoundRemovedPopup + " || ActualPopup : " + actRemovedPopup,test,test1);
						click(driver,popup_Message_Ok_Button);
					} 
					else if(actRemovedPopup.equals(cannotRemovePopup)) {
						System.out.println("Matched || " + " Expected Popup : " + cannotRemovePopup + " || Actual Popup : " + actRemovedPopup);
						Extent_pass_New(driver,"Matched || " + " Expected Popup : " + cannotRemovePopup + " || ActualPopup : " + actRemovedPopup,test,test1);
						click(driver,popup_Message_Ok_Button);
					}else if(actRemovedPopup.equals(onlyOneSubBound)) {
						System.out.println("Matched || " + " Expected Popup : " + onlyOneSubBound + " || Actual Popup : " + actRemovedPopup);
						Extent_pass_New(driver,"Matched || " + " Expected Popup : " + onlyOneSubBound + " || ActualPopup : " + actRemovedPopup,test,test1);
						click(driver,popup_Message_Ok_Button);
					}
					else {
						System.out.println("Not Matched || " + " Expected Popup : " + subBoundRemovedPopup + " || Actual Popup : " + actRemovedPopup);
						Extent_fail(driver, "Not Matched || " + " Expected Popup : " + subBoundRemovedPopup + " || Actual Popup : " + actRemovedPopup, test, test1);
					}
				}	
				Extent_completed(testCaseName, test, test1);

					}
					 scrollTop(driver);
					   waitForElement(driver, Close_Current_tab);
					   click(driver, Close_Current_tab); 		
					     
					     
					 int cs10=10;
					 
					 if(cs10==10) {
						 String testCaseName="TC_Coastal_Schedule_CS10";
							String File_Path_CS10 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
							String Sheet_Name_CS10 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
							Map<String, String> Excel_data_10 = Utils.GetAllData(Sheet_Name_CS10, testCaseName, "Dataset"+selected_dataset, File_Path_CS10);

							String ModuleSearch_CS10 =Excel_data_10.get("Module_Search");
							String ServiceCode_CS10 =Excel_data_10.get("Service_Code"); 
							String VesselCode_CS10 =Excel_data_10.get("Vessel_Code");
							String voyageNumber_CS10 =Excel_data_10.get("Voyage_Number");
							String portName_CS10 =Excel_data_10.get("Port_Name");
							String Bound_1_Popup=Excel_data_10.get("Bound_1_Popup");
							String Bound_2_Popup =Excel_data_10.get("Bound_2_Popup");
							String Bound_3_Popup= Excel_data_10.get("Bound_3_Popup");
							String Add_Bound_1_CS10 =Excel_data_10.get("Add_Bound_1");
							String Add_Bound_2_CS10 =Excel_data_10.get("Add_Bound_2");
							String Add_Bound_3_CS10 =Excel_data_10.get("Add_Bound_3");
							String pivotBound1_CS10=Excel_data_10.get( "PivotBound1");
							String pivotBound2_CS10=Excel_data_10.get( "PivotBound2");
							String pivotBound3_CS10=Excel_data_10.get( "PivotBound3");
							String Bound_1_CS10=Excel_data_10.get("Bound_1");
							String Bound_2_CS10 =Excel_data_10.get("Bound_2");
							String Bound_3_CS10= Excel_data_10.get("Bound_3");
							String remove_Bound_1_CS10=Excel_data_10.get("remove_Bound_1");
							String remove_Bound_2_CS10 =Excel_data_10.get("remove_Bound_2");
							String remove_Bound_3_CS10= Excel_data_10.get("remove_Bound_3");
							String Do_You_Want_Add_Bound_CS10= Excel_data_10.get("Do_You_Want_Add_Bound");

							String pivot_Bount1= Excel_data_10.get("Pivot_Bount1");
							String pivot_Bount2= Excel_data_10.get("Pivot_Bount2");
							String pivot_Bount3= Excel_data_10.get("Pivot_Bount3");
							String pivotBound_1_Added= Excel_data_10.get("PivotBound_1_Added");
							String pivotBound_2_Added= Excel_data_10.get("PivotBound_2_Added");
							String pivotBound_3_Added= Excel_data_10.get("PivotBound_3_Added");

							String subBoundAddedPopup = Excel_data_10.get("SubBoundAddedPopup");
							String selectSubBound = Excel_data_10.get("SubBound");
							String alreadyHaveSubBoundPopup = Excel_data_10.get("AlreadyHaveSubBoundPopup");
							String subBoundRemovedPopup = Excel_data_10.get("SubBoundRemovedPopup");
							String cannotRemovePopup = Excel_data_10.get("CannotRemovePopup");
							String noPivotBound_1_Popup = Excel_data_10.get("NoPivotBound_1_Popup");
							String noPivotBound_2_Popup = Excel_data_10.get("NoPivotBound_2_Popup");
							String noPivotBound_3_Popup = Excel_data_10.get("NoPivotBound_3_Popup");
							String onlyOnePivotBound_Popup = Excel_data_10.get("OnlyOnePivotBound_Popup");
							String wantToContinuePopup= Excel_data_10.get("WantToContinuePopup");
							String onlyOneSubBound= Excel_data_10.get("OnlyOneSubBound");




							String Select_Columns= Excel_data_10.get("Select_Columns");
							String  service_Select = String.format(Coastal_Schedule_Locators.serviceSelect, ServiceCode_CS10);
							String  vessel_Select = String.format(Coastal_Schedule_Locators.vesselSelect, VesselCode_CS10);
							String  Voyage_Toggler = String.format(Coastal_Schedule_Locators.voyageToggler, voyageNumber_CS10);
							String add_1_Select =  String.format(Coastal_Schedule_Locators.addBound_Option, Add_Bound_1_CS10);
							String add_2_Select = String.format(Coastal_Schedule_Locators.addBound_Option, Add_Bound_2_CS10);
							String add_3_Select =String.format(Coastal_Schedule_Locators.addBound_Option, Add_Bound_3_CS10);
							String remove_1_Select = String.format(Coastal_Schedule_Locators.removeBound_Option, remove_Bound_1_CS10);
							String remove_2_Select = String.format(Coastal_Schedule_Locators.removeBound_Option, remove_Bound_2_CS10);
							String remove_3_Select = String.format(Coastal_Schedule_Locators.removeBound_Option, remove_Bound_3_CS10);
							String  Port_Select = String.format(Coastal_Schedule_Locators.port_Select, voyageNumber_CS10,portName_CS10);

							String edit_Bound_1 = String.format(Coastal_Schedule_Locators.editBound, Bound_1_CS10);
							String edit_Bound_2 = String.format(Coastal_Schedule_Locators.editBound, Bound_2_CS10);
							String edit_Bound_3 = String.format(Coastal_Schedule_Locators.editBound, Bound_3_CS10);



							Extent_Start(testCaseName, test, test1);

							
							moduleNavigate(driver, ModuleSearch_CS10);

							Step_Start(1, "Enter the Service Code  in the service code field", test, test1);


							waitForElement(driver, Service_Txt_Field);
							sendKeys(driver, Service_Txt_Field, ServiceCode_CS10);

							Step_End(1, "Enter the Service Code  in the service code field", test, test1);

							waitForElement(driver, service_Select);
							click(driver, service_Select);

							Step_Start(2, "Enter the Vessel ", test, test1);

							waitForElement(driver, Vessel_Txt_Field);
							sendKeys(driver, Vessel_Txt_Field, VesselCode_CS10);

							waitForElement(driver, vessel_Select);
							click(driver, vessel_Select);

							Step_End(2, "Enter the Vessel ", test, test1);

							waitForElement(driver, Edit_Button_toolBar);
							click(driver, Edit_Button_toolBar);

							Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

							waitForDisplay(driver, Tree_Structure);
							if(isdisplayed(driver,Tree_Structure)) {
								Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
								System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
							}else {
								System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

								Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
							}
							String status = getAttribute(driver, Voyage_Toggler, "class");
							if(!status.contains("s")) {
								click(driver, Voyage_Toggler);
							}
							Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

							if(Do_You_Want_Add_Bound_CS10.equalsIgnoreCase("Yes")) {
								Extent_cal(test, test1, "Add bounds");

								// Add sub bound
								waitForElement(driver, Port_Select);
								click(driver, Port_Select);
								waitForElement(driver, Port_Select);
								RightClick(driver, Port_Select);

								waitForElement(driver, add_subbound);
								click(driver, add_subbound);

								waitForDisplay(driver, popup_Message);
								if(isdisplayed(driver, popup_Message)) {
									String actualPopup=getText(driver, popup_Message);
									System.out.println("actualPopup:"+actualPopup);
									if(actualPopup.equals(alreadyHaveSubBoundPopup)) {

										System.out.println("Matched || " + " Expected Popup is : " + alreadyHaveSubBoundPopup + " || Actual Popup is : " + actualPopup);
										Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + alreadyHaveSubBoundPopup + " || ActualPopup is : " + actualPopup,test,test1);
										waitForElement(driver, popup_Message_Ok_Button);
										click(driver,popup_Message_Ok_Button);

									}

								}else {
									waitForElement(driver, subBound_Dropdown);
									click(driver, subBound_Dropdown);

									String select_SubBound = String.format(Coastal_Schedule_Locators.subBound_Option, selectSubBound);
									waitForElement(driver, select_SubBound);
									click(driver, select_SubBound);

									waitForElement(driver, Subbound_ok);
									click(driver, Subbound_ok);

									waitForPopup(driver, popup_Message, subBoundAddedPopup);
									String actPopup = getText(driver, popup_Message);

									if (actPopup.equals(subBoundAddedPopup)) {
										System.out.println("Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || Actual Popup is : " + actPopup);
										Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || ActualPopup is : " + actPopup,test,test1);
										click(driver,popup_Message_Ok_Button);


									}else if(actPopup.contains(wantToContinuePopup)) {
										System.out.println("Matched || " + " Expected Popup is : " + wantToContinuePopup + " || Actual Popup is : " + actPopup);
										Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + wantToContinuePopup + " || ActualPopup is : " + actPopup,test,test1);
										click(driver,popup_Message_Yes_Button);
										waitForElement(driver, popup_Message_Ok_Button);
										String actPopup2=getText(driver, popup_Message);
										if (actPopup2.equals(subBoundAddedPopup)) {
											System.out.println("Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || Actual Popup is : " + actPopup2);
											Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || ActualPopup is : " + actPopup2,test,test1);
											click(driver,popup_Message_Ok_Button);

										}

									}
									else {
										System.out.println("Not Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || Actual Popup is : " + actPopup);
										Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + subBoundAddedPopup + " || ActualPopup is : " + actPopup,test,test1);
									}
								}
								//pivot bound1	
								
								waitForElement(driver, Voyage_Toggler);
								String status1 = getAttribute(driver, Voyage_Toggler, "class");
								if(!status1.contains("s")) {
									click(driver, Voyage_Toggler);
								}
								
								waitForElement(driver, Port_Select);
								click(driver, Port_Select);

								waitForElement(driver, Port_Select);
								RightClick(driver, Port_Select);

								waitForElement(driver, add_1_Select);
								click(driver, add_1_Select);
								waitForDisplay(driver, addPivotBound1Frame);
								if(isDisplayed(driver, addPivotBound1Frame)) {
									waitForElement(driver, Bouund_DD_1);
									click(driver, Bouund_DD_1);
									waitForElement(driver, edit_Bound_1);
									click(driver, edit_Bound_1);
									waitForElement(driver, addPivotVoyage1InBound);
									sendKeys(driver, addPivotVoyage1InBound, pivotBound1_CS10);		
									waitForElement(driver, boundOkButton);
									click(driver, boundOkButton);

									waitForDisplay(driver, popup_Message);
									if(isdisplayed(driver, popup_Message)) {
										String actualPopup1=getText(driver, popup_Message);
										System.out.println("actualPopup1:"+actualPopup1);
										if(actualPopup1.equals(pivotBound_1_Added)) {
											System.out.println("Matched || " + " Expected Popup is : " + pivotBound_1_Added + " || Actual Popup is : " + actualPopup1);
											Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivotBound_1_Added + " || ActualPopup is : " + actualPopup1,test,test1);
											click(driver,popup_Message_Ok_Button);
										}else {
											System.out.println("Not Matched || " + " Expected Popup is : " + pivotBound_1_Added + " || Actual Popup is : " + actualPopup1);
											Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + pivotBound_1_Added + " || ActualPopup is : " + actualPopup1,test,test1);
										}
									}
								}else if(isdisplayed(driver, popup_Message)){
									String actPopup=getText(driver, popup_Message);
									if(actPopup.equals(pivot_Bount1)) {
										System.out.println("Matched || " + " Expected Popup is : " + pivot_Bount1 + " || Actual Popup is : " + actPopup);
										Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivot_Bount1 + " || Actual Popup is : " + actPopup,test,test1);
										click(driver,popup_Message_Ok_Button);
									}
								}
								//	pivot bound2	 

								waitForElement(driver, Voyage_Toggler);
								String status2 = getAttribute(driver, Voyage_Toggler, "class");
								if(!status2.contains("s")) {
									click(driver, Voyage_Toggler);
								}
								waitForElement(driver, Port_Select);
								click(driver, Port_Select);

								waitForElement(driver, Port_Select);
								RightClick(driver, Port_Select);

								waitForElement(driver, add_2_Select);
								click(driver, add_2_Select);

								waitForDisplay(driver, addPivotBound2Frame);
								if (isDisplayed(driver, addPivotBound2Frame)) {
									Extent_call(test, test1, "Choose the Bound from the Drop Down");
									waitForElement(driver, Bouund_DD_2);
									click(driver, Bouund_DD_2);

									waitForElement(driver, edit_Bound_2);
									click(driver, edit_Bound_2);


									waitForElement(driver, addPivotVoyage2InBound);
									sendKeys(driver, addPivotVoyage2InBound, pivotBound2_CS10);
									waitForElement(driver, bound2_OkButton);
									click(driver, bound2_OkButton);

									waitForPopup(driver, popup_Message, pivotBound_2_Added);

									String actualPopup2=getText(driver, popup_Message);
									System.out.println("actualPopup2:"+actualPopup2);
									if(actualPopup2.equals(pivotBound_2_Added)) {
										System.out.println("Matched || " + " Expected Popup is : " + pivotBound_2_Added + " || Actual Popup is : " + actualPopup2);
										Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivotBound_2_Added + " || ActualPopup is : " + actualPopup2,test,test1);
										click(driver,popup_Message_Ok_Button);
									}else {
										System.out.println("Not Matched || " + " Expected Popup is : " + pivotBound_2_Added + " || Actual Popup is : " + actualPopup2);
										Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + pivotBound_2_Added + " || ActualPopup is : " + actualPopup2,test,test1);
									}
								} else if(isDisplayed(driver, popup_Message)){
									String actPopup=getText(driver, popup_Message);
									if(actPopup.equals(pivot_Bount2)) {
										System.out.println("Matched || " + " Expected Popup is : " + pivot_Bount2 + " || Actual Popup is : " + actPopup);
										Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivot_Bount2 + " || Actual Popup is : " + actPopup,test,test1);
										click(driver,popup_Message_Ok_Button);
									}
								}

								//pivot bound3	
								waitForElement(driver, Voyage_Toggler);
								String status3 = getAttribute(driver, Voyage_Toggler, "class");
								if(!status3.contains("s")) {
									click(driver, Voyage_Toggler);
								}
								waitForElement(driver, Port_Select);
								click(driver, Port_Select);

								waitForElement(driver, Port_Select);
								RightClick(driver, Port_Select);
								waitForElement(driver, add_3_Select);
								click(driver, add_3_Select);

								waitForDisplay(driver, addPivotBound3Frame);
								if (isdisplayed(driver, addPivotBound3Frame)) {
									Extent_call(test, test1, "Choose the Bound from the Drop Down");
									waitForElement(driver, Bouund_DD_3);
									click(driver, Bouund_DD_3);
									waitForElement(driver, edit_Bound_3);
									click(driver, edit_Bound_3);

									waitForElement(driver, addPivotVoyage3InBound);
									sendKeys(driver, addPivotVoyage3InBound, pivotBound3_CS10);
									waitForElement(driver, bound3_OkButton);
									click(driver, bound3_OkButton);
									waitForPopup(driver, popup_Message, pivotBound_3_Added);

									String actualPopup3=getText(driver, popup_Message);
									System.out.println("actualPopup3:"+actualPopup3);
									if(actualPopup3.equals(pivotBound_3_Added)) {
										System.out.println("Matched || " + " Expected Popup is : " + pivotBound_3_Added + " || Actual Popup is : " + actualPopup3);
										Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivotBound_3_Added + " || ActualPopup is : " + actualPopup3,test,test1);
										click(driver,popup_Message_Ok_Button);
									}else {
										System.out.println("Not Matched || " + " Expected Popup is : " + pivotBound_3_Added + " || Actual Popup is : " + actualPopup3);
										Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + pivotBound_3_Added + " || ActualPopup is : " + actualPopup3,test,test1);
									}
								} else if(isDisplayed(driver, popup_Message)){
									String actPopup=getText(driver, popup_Message);
									if(actPopup.equals(pivot_Bount3)) {
										System.out.println("Matched || " + " Expected Popup is : " + pivot_Bount3 + " || Actual Popup is : " + actPopup);
										Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + pivot_Bount3 + " || Actual Popup is : " + actPopup,test,test1);
										click(driver,popup_Message_Ok_Button);
									}
								}



							}
							waitForElement(driver, Tree_Structure);
							String status1 = getAttribute(driver, Voyage_Toggler, "class");
							if(!status1.contains("s")) {
								waitForElement(driver, Voyage_Toggler);
								click(driver, Voyage_Toggler);
							}
							waitForElement(driver, Port_Select);
							click(driver, Port_Select);		
							waitForDisplay(driver, Temp_Remove);
							if(isdisplayed(driver, Temp_Remove)){
								waitForElement(driver, Temp_Remove);
								click(driver, Temp_Remove);
							}
							
							reArrangeAG_Grid_Outer_Column_CS(driver, Select_Columns);

							String actual_PivotBound_1_Gridcell=String.format(pivotBound_1_Gridcell, portName_CS10);
							String actual_PivotBound_2_Gridcell=String.format(pivotBound_2_Gridcell, portName_CS10);
							String actual_PivotBound_3_Gridcell=String.format(pivotBound_3_Gridcell, portName_CS10);

							waitForElement(driver, actual_PivotBound_1_Gridcell);
							String beforeBound_1 = getText(driver, actual_PivotBound_1_Gridcell);
							String beforeBound_2= getText(driver, actual_PivotBound_2_Gridcell);
							String beforeBound_3= getText(driver, actual_PivotBound_3_Gridcell);
							
							Extent_cal(test, test1, "Remove Bounds");

							waitForElement(driver, Tree_Structure);

							waitForElement(driver, Voyage_Toggler);
							status = getAttribute(driver, Voyage_Toggler, "class");
							if(!status.contains("s")) {
								click(driver, Voyage_Toggler);
							}

							Step_Start(4, "Right click on the port which the bound of the port should be Removed", test, test1);


							Step_Start(5, "Click on Remove Sub Bound ", test, test1);
							Step_Start(6, "System should remove the sub bound from the port ", test, test1);
							Step_Start(7, "If it’s the first port of the voyage , then system should show validation “This is the first port call of the voyage, Sub bound cannot be removed”", test, test1);


							Step_Start(8, "Click on Remove Pivot bound 1 ", test, test1);
							waitForElement(driver, Port_Select);
							click(driver, Port_Select);

							waitForElement(driver, Port_Select);
							RightClick(driver, Port_Select);


							waitForElement(driver, remove_1_Select);
							click(driver, remove_1_Select);

							Step_End(8, "Click on Remove Pivot bound 1 ", test, test1);
							Step_Start(9, "System should remove the pivot bound 1 ", test, test1);
							Step_Start(10, "If the port doesn’t have pivot bound 1 systems should validation “There is no pivot bound 1 to remove”", test, test1);
							Step_Start(11, "If the pivot bound is the only bound for the port , system should show validation” This Call having only one Bound. So, cannot Remove this Pivot Bound.", test, test1);

							waitForPopup(driver, popup_Message, Bound_1_Popup);
							String pivot_1_Removed = getText(driver, popup_Message);
							if(pivot_1_Removed.equals(Bound_1_Popup)) {
								System.out.println("Matched || " + " Expected Popup : " + Bound_1_Popup + " || Actual Popup : " + pivot_1_Removed);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + Bound_1_Popup + " || ActualPopup : " + pivot_1_Removed,test,test1);
								click(driver,popup_Message_Ok_Button);
							} 
							else if(pivot_1_Removed.equals(noPivotBound_1_Popup)) {
								System.out.println("Matched || " + " Expected Popup : " + noPivotBound_1_Popup + " || Actual Popup : " + pivot_1_Removed);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + noPivotBound_1_Popup + " || ActualPopup : " + pivot_1_Removed,test,test1);
								click(driver,popup_Message_Ok_Button);
							} 
							else if(pivot_1_Removed.equals(onlyOnePivotBound_Popup)) {
								System.out.println("Matched || " + " Expected Popup : " + onlyOnePivotBound_Popup + " || Actual Popup : " + pivot_1_Removed);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + onlyOnePivotBound_Popup + " || ActualPopup : " + pivot_1_Removed,test,test1);
								click(driver,popup_Message_Ok_Button);
							} 	else {
								System.out.println("Not Matched || " + " Expected Popup is : " + Bound_1_Popup + " || Actual Popup is : " + pivot_1_Removed);
								Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Bound_1_Popup + " || ActualPopup is : " + pivot_1_Removed,test,test1);
							}
							Step_End(9, "System should remove the pivot bound 1 ", test, test1);
							Step_End(10, "If the port doesn’t have pivot bound 1 systems should validation “There is no pivot bound 1 to remove”", test, test1);

							Step_End(11, "If the pivot bound is the only bound for the port , system should show validation” This Call having only one Bound. So, cannot Remove this Pivot Bound.", test, test1);
							Step_Start(12, "Click on Remove Pivot bound 2 ", test, test1);

							waitForElement(driver, Tree_Structure);

							waitForElement(driver, Voyage_Toggler);
							status = getAttribute(driver, Voyage_Toggler, "class");
							if(!status.contains("s")) {
								click(driver, Voyage_Toggler);
							}

							waitForElement(driver, Port_Select);
							click(driver, Port_Select);


							waitForElement(driver, Port_Select);
							RightClick(driver, Port_Select);


							waitForElement(driver, remove_2_Select);
							click(driver, remove_2_Select);
							Step_End(12, "Click on Remove Pivot bound 2 ", test, test1);
							Step_Start(13, "System should remove the pivot bound 2 ", test, test1);
							Step_Start(14, "If the port doesn’t have pivot bound 2 systems should validation “There is no pivot bound 2 to remove”", test, test1);
							Step_Start(15, "If the pivot bound is the only bound for the port , system should show validation” This Call having only one Bound. So, cannot Remove this Pivot Bound.", test, test1);

							waitForPopup(driver, popup_Message, Bound_2_Popup);

							String pivot_2_Removed = getText(driver, popup_Message);
							if(pivot_2_Removed.equals(Bound_2_Popup)) {
								System.out.println("Matched || " + " Expected Popup : " + Bound_2_Popup + " || Actual Popup : " + pivot_2_Removed);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + Bound_2_Popup + " || ActualPopup : " + pivot_2_Removed,test,test1);
								click(driver,popup_Message_Ok_Button);
							} 
							else if(pivot_2_Removed.equals(noPivotBound_2_Popup)) {
								System.out.println("Matched || " + " Expected Popup : " + noPivotBound_2_Popup + " || Actual Popup : " + pivot_2_Removed);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + noPivotBound_2_Popup + " || ActualPopup : " + pivot_2_Removed,test,test1);
								click(driver,popup_Message_Ok_Button);
							} 

							else if(pivot_2_Removed.equals(onlyOnePivotBound_Popup)) {
								System.out.println("Matched || " + " Expected Popup : " + onlyOnePivotBound_Popup + " || Actual Popup : " + pivot_2_Removed);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + onlyOnePivotBound_Popup + " || ActualPopup : " + pivot_2_Removed,test,test1);
								click(driver,popup_Message_Ok_Button);
							} else {
								System.out.println("Not Matched || " + " Expected Popup is : " + Bound_2_Popup + " || Actual Popup is : " + pivot_2_Removed);
								Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Bound_2_Popup + " || ActualPopup is : " + pivot_2_Removed,test,test1);
							}
							Step_End(13, "System should remove the pivot bound 2 ", test, test1);

							Step_End(14, "If the port doesn’t have pivot bound 2 systems should validation “There is no pivot bound 2 to remove”", test, test1);

							Step_End(15, "If the pivot bound is the only bound for the port , system should show validation” This Call having only one Bound. So, cannot Remove this Pivot Bound.", test, test1);
							Step_Start(16, "Click on Remove Pivot bound 3 ", test, test1);

							waitForElement(driver, Voyage_Toggler);
							status = getAttribute(driver, Voyage_Toggler, "class");
							if(!status.contains("s")) {
								click(driver, Voyage_Toggler);
							}

							waitForElement(driver, Port_Select);
							click(driver, Port_Select);

							waitForElement(driver, Port_Select);
							RightClick(driver, Port_Select);

							waitForElement(driver, remove_3_Select);
							click(driver, remove_3_Select);
							Step_Start(16, "Click on Remove Pivot bound 3 ", test, test1);
							Step_Start(17, "System should remove the pivot bound 3 ", test, test1);
							Step_Start(18, "If the port doesn’t have pivot bound 3 systems should validation “There is no pivot bound 3 to remove”", test, test1);
							Step_Start(19, "If the pivot bound is the only bound for the port , system should show validation” This Call having only one Bound. So, cannot Remove this Pivot Bound.", test, test1);

							waitForPopup(driver, popup_Message, Bound_3_Popup);

							String pivot_3_Removed = getText(driver, popup_Message);
							if(pivot_3_Removed.equals(Bound_3_Popup)) {
								System.out.println("Matched || " + " Expected Popup : " + Bound_3_Popup + " || Actual Popup : " + pivot_3_Removed);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + Bound_3_Popup + " || ActualPopup : " + pivot_3_Removed,test,test1);
								click(driver,popup_Message_Ok_Button);
							} 
							else if(pivot_3_Removed.equals(noPivotBound_3_Popup)) {
								System.out.println("Matched || " + " Expected Popup : " + noPivotBound_3_Popup + " || Actual Popup : " + pivot_3_Removed);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + noPivotBound_3_Popup + " || ActualPopup : " + pivot_3_Removed,test,test1);
								click(driver,popup_Message_Ok_Button);
							} 
							else if(pivot_3_Removed.equals(onlyOnePivotBound_Popup)) {
								System.out.println("Matched || " + " Expected Popup : " + onlyOnePivotBound_Popup + " || Actual Popup : " + pivot_3_Removed);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + onlyOnePivotBound_Popup + " || ActualPopup : " + pivot_3_Removed,test,test1);
								click(driver,popup_Message_Ok_Button);
							}else {
								System.out.println("Not Matched || " + " Expected Popup is : " + Bound_3_Popup + " || Actual Popup is : " + pivot_3_Removed);
								Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Bound_3_Popup + " || ActualPopup is : " + pivot_3_Removed,test,test1);
							}
							// Remove sub bound
							
							waitForElement(driver, Voyage_Toggler);
							status = getAttribute(driver, Voyage_Toggler, "class");
							if(!status.contains("s")) {
								click(driver, Voyage_Toggler);
							}
							
							waitForElement(driver, Port_Select);
							click(driver, Port_Select);

							waitForElement(driver, Port_Select);
							RightClick(driver, Port_Select);

							Step_End(4, "Right click on the port which the bound of the port should be Removed", test, test1);

							waitForElement(driver, Remove_subboundnew);
							click(driver, Remove_subboundnew);

							Step_End(5, "Click on Remove Sub Bound ", test, test1);

							waitForPopup(driver, popup_Message, subBoundRemovedPopup);

							String actRemovedPopup = getText(driver, popup_Message);

							if (actRemovedPopup.equals(subBoundRemovedPopup)) {
								System.out.println("Matched || " + " Expected Popup : " + subBoundRemovedPopup + " || Actual Popup : " + actRemovedPopup);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + subBoundRemovedPopup + " || ActualPopup : " + actRemovedPopup,test,test1);
								click(driver,popup_Message_Ok_Button);
							} 
							else if(actRemovedPopup.equals(cannotRemovePopup)) {
								System.out.println("Matched || " + " Expected Popup : " + cannotRemovePopup + " || Actual Popup : " + actRemovedPopup);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + cannotRemovePopup + " || ActualPopup : " + actRemovedPopup,test,test1);
								click(driver,popup_Message_Ok_Button);
							}else if(actRemovedPopup.equals(onlyOneSubBound)) {
								System.out.println("Matched || " + " Expected Popup : " + onlyOneSubBound + " || Actual Popup : " + actRemovedPopup);
								Extent_pass_New(driver,"Matched || " + " Expected Popup : " + onlyOneSubBound + " || ActualPopup : " + actRemovedPopup,test,test1);
								click(driver,popup_Message_Ok_Button);
							}
							else {
								System.out.println("Not Matched || " + " Expected Popup is : " + subBoundRemovedPopup + " || Actual Popup is : " + actRemovedPopup);
								Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + subBoundRemovedPopup + " || ActualPopup is : " + actRemovedPopup,test,test1);
							}
							Step_End(6, "System should remove the sub bound from the port ", test, test1);

							Step_End(7, "If it’s the first port of the voyage , then system should show validation “This is the first port call of the voyage, Sub bound cannot be removed”", test, test1);

							Step_End(17, "System should remove the pivot bound 3 ", test, test1);
							Step_End(18, "If the port doesn’t have pivot bound 3 systems should validation “There is no pivot bound 3 to remove”", test, test1);

							Step_End(19, "If the pivot bound is the only bound for the port , system should show validation” This Call having only one Bound. So, cannot Remove this Pivot Bound.", test, test1);

							reArrangeAG_Grid_Outer_Column_CS(driver, Select_Columns);

							waitForElement(driver, actual_PivotBound_1_Gridcell);
							String PivBound_1 = getText(driver, actual_PivotBound_1_Gridcell);
							String pivBound_2= getText(driver, actual_PivotBound_2_Gridcell);
							String pivBound_3= getText(driver, actual_PivotBound_3_Gridcell);

							//piv1
							if(PivBound_1.equals("")) {
								System.out.println("Matched || " + " Before Bound 1 : " + beforeBound_1 + " || After Bound 1 : " + PivBound_1);
								Extent_pass_New(driver,"Matched || " + " Before Bound 1 : " + beforeBound_1 + " || After Bound 1 : " + PivBound_1,test,test1);
							}else {
								System.out.println("Not matched || " + " Before Bound 1 : " + beforeBound_1 + " || After Bound 1 : " + PivBound_1);
								Extent_fail(driver,"Not matched || " + " Before Bound 1 : " + beforeBound_1 + " || After Bound : " + PivBound_1,test,test1);
							}			 

							//piv2

							if(pivBound_2.equals("")) {
								System.out.println("Matched || " + " Before Bound 2 : " + beforeBound_2 + " || After Bound 2 : " + pivBound_2);
								Extent_pass_New(driver,"Matched || " + " Before Bound 2 : " + beforeBound_2 + " || After Bound 2 : " + pivBound_2,test,test1);
							}else {
								System.out.println("Not matched || " + " Before Bound 2 : " + beforeBound_2 + " || After Bound 2 : " + pivBound_2);
								Extent_fail(driver,"Not matched || " + " Before Bound 2 : " + beforeBound_2 + " || After Bound 2 : " + pivBound_2,test,test1);
							}			 

							//piv3

							if(pivBound_3.equals("")) {
								System.out.println("Matched || " + " Before Bound 3 : " + beforeBound_3 + " || After Bound 3 : " + pivBound_3);
								Extent_pass_New(driver,"Matched || " + " Before Bound 3 : " + beforeBound_3 + " || After Bound 3 : " + pivBound_3,test,test1);
							}
							else {
								System.out.println("Not matched || " + " Before Bound 3 : " + beforeBound_3 + " || After Bound 3 : " + pivBound_3);
								Extent_fail(driver,"Not matched || " + " Before Bound 3 : " + beforeBound_3 + " || After Bound 3 : " + pivBound_3,test,test1);
							}		 


							Extent_completed(testCaseName, test, test1);	 
						 
					 }
						 
						 
	 scrollTop(driver);
	   waitForElement(driver, Close_Current_tab);
	   click(driver, Close_Current_tab); 		
	     
				     
				 int cs11=11;
				 
				 if(cs11==11) {
					 
					 String testCaseName="TC_Coastal_Schedule_CS11";
						String File_Path_CS11 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
						String Sheet_Name_CS11 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
						Map<String, String> Excel_data_11 = Utils.GetAllData(Sheet_Name_CS11, testCaseName, "Dataset"+selected_dataset, File_Path_CS11);

						String CurrentTerminalRenamed =Excel_data_11.get( "CurrentTerminalRenamed");
						String FutureTerminalRenamed =Excel_data_11.get( "FutureTerminalRenamed");
						String TerminalInput = Excel_data_11.get("TerminalInput");
						String Change_Future_Voyages = Excel_data_11.get("Change_Future_Voyages");
						String ModuleSearch_CS11 =Excel_data_11.get("Module_Search");
						String ServiceCode_CS11 =Excel_data_11.get("Service_Code"); 
						String VesselCode_CS11 =Excel_data_11.get("Vessel_Code");
						String voyageNumber_CS11 =Excel_data_11.get("Voyage_Number");
						String portName_CS11 =Excel_data_11.get("Port_Name");
						String Change_Terminal_Button_CS11 =Excel_data_11.get("Button");
						String condition = Excel_data_11.get("Condition");
						String service_Search_Header = Excel_data_11.get("Service_Search_Header");
						String vessel_Search_Header = Excel_data_11.get("Vessel_Search_Header");
						String terminal_Search_Header = Excel_data_11.get("Terminal_Search_Header");

						
						String future_Voyage = String.format(Coastal_Schedule_Locators.futureVoyage, voyageNumber_CS11);
						String future_VoyageToggler = String.format(Coastal_Schedule_Locators.futureVoyage_Toggler, voyageNumber_CS11);
						String future_VoyagePort = String.format(Coastal_Schedule_Locators.futureVoyage_Port, portName_CS11,portName_CS11);

						String  Voyage_Toggler = String.format(Coastal_Schedule_Locators.voyageToggler, voyageNumber_CS11);
						String  terminal_Change = String.format(Coastal_Schedule_Locators.terminalChangeOption, Change_Terminal_Button_CS11);
						String  Port_Select = String.format(Coastal_Schedule_Locators.port_Select, voyageNumber_CS11,portName_CS11);

						Extent_Start(testCaseName, test, test1);

						
						moduleNavigate(driver, ModuleSearch_CS11);

						Step_Start(1, "Enter the Service Code  in the service code field", test, test1);
						
						waitForElement(driver, Service_Search_Btn);
						click(driver, Service_Search_Btn);
						
						twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS11);
						
						Step_End(1, "Enter the Service Code  in the service code field", test, test1);

						Step_Start(2, "Enter the Vessel ", test, test1);
						

						waitForElement(driver, Vessel_Search_Btn);
						click(driver, Vessel_Search_Btn);

						twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS11);

						Step_End(2, "Enter the Vessel ", test, test1);
						waitForElement(driver, Edit_Button_toolBar);
						click(driver, Edit_Button_toolBar);
						Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
						waitForDisplay(driver, Tree_Structure);
						if(isdisplayed(driver,Tree_Structure)) {
							Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
							System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
						}else {
							System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

							Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
						}
						Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
						waitForElement(driver, Voyage_Toggler);
						String status = getAttribute(driver, Voyage_Toggler, "class");
						if(!status.contains("s")) {
							click(driver, Voyage_Toggler);
						}

						waitForElement(driver, Port_Select);
						click(driver, Port_Select);

						Step_Start(4, "Right click on the port where the terminal has to be Renamed", test, test1);
						waitForElement(driver, Port_Select);
						RightClick(driver, Port_Select);

						Step_End(4, "Right click on the port where the terminal has to be Renamed", test, test1);

						Step_Start(5, "Choose Rename Terminal", test, test1);
						waitForElement(driver, terminal_Change);
						click(driver, terminal_Change);

						waitForElement(driver, Terminal_Search_Btn);
						click(driver,Terminal_Search_Btn);

						twoColumnSearchWindow(driver, terminal_Search_Header, condition, TerminalInput);

						Step_End(5, "Choose Rename Terminal", test, test1);

						Step_Start(6, "Choose Future Voyages", test, test1);
						Step_Start(7, "If the Terminal Should be renamed for all the future cycle of the same port in the same vessel ", test, test1);
						if(Change_Future_Voyages.equalsIgnoreCase("Yes")) {
							waitForElement(driver, Current_Voyage_Btn);

							if(isElementAccessible(driver, futureVoyage_Button)) {
								click(driver, Future_Voyage_Btn);
								System.out.println("Matched || Expected : Future Voyage Button should be Enabled || Actual :  Future Voyage Button Is Enabled");
								Extent_pass_New(driver, "Matched || Expected : Future Voyage Button should be Enabled || Actual :  Future Voyage Button Is Enabled", test, test1);

							}else {
								System.out.println("Not Matched || Expected : Future Voyage Button should be Enabled || Actual :  Future Voyage Button Is  Disabled");
								Extent_fail(driver, "Not Matched || Expected : Future Voyage Button should be Enabled || Actual :  Future Voyage Button Is Disabled", test, test1);
							}
							waitForElement(driver, Termial_Change_Ok);
							click(driver,Termial_Change_Ok);
							waitForPopup(driver, popup_Message, FutureTerminalRenamed);
							String Terminal_Popup= getText(driver, popup_Message);
							if(Terminal_Popup.equals(FutureTerminalRenamed)) {
								System.out.println("Matched || Expected Popup : "+FutureTerminalRenamed+" || Actual Popup : "+Terminal_Popup);
								Extent_pass_New(driver, "Matched || Expected Popup : "+FutureTerminalRenamed+" || Actual Popup : "+Terminal_Popup, test,test1);
							}else {
								System.out.println("NotMatched || Expected Popup : "+FutureTerminalRenamed+" || Actual Popup : "+Terminal_Popup);
								Extent_fail(driver,  "NotMatched || Expected Popup : "+FutureTerminalRenamed+" || Actual Popup : "+Terminal_Popup, test,test1);
							}

							Step_End(6, "Choose Future Voyages", test, test1);

							click(driver,popup_Message_Ok_Button);


							waitForElement(driver, Voyage_Toggler);
							String status1 = getAttribute(driver, Voyage_Toggler, "class");
							if(!status1.contains("s")) {
								click(driver, Voyage_Toggler);
							}
							waitForElement(driver, Port_Select);					
							String terminal = getText(driver, Port_Select);
							if(terminal.contains(TerminalInput)) {
								System.out.println("Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal);
								Extent_pass_New(driver, "Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal, test,test1);
							}else {
								System.out.println("NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal);
								Extent_fail(driver, "NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal, test,test1);
							}
							waitForElement(driver, Tree_Structure);

							if(isDisplayed(driver, future_Voyage)) {
								String status2 = getAttribute(driver, future_VoyageToggler, "class");
								if(!status2.contains("s")) {
									click(driver, future_VoyageToggler);
								}
								waitForElement(driver, future_VoyagePort);
								String terminal1 = getText(driver, future_VoyagePort);
								if(terminal1.contains(TerminalInput)) {
									System.out.println("Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1);
									Extent_pass_New(driver, "Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1, test,test1);
								}else {
									System.out.println("NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1);
									Extent_fail(driver, "NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1, test,test1);
								}
							}
							Step_End(7, "If the Terminal Should be renamed for all the future cycle of the same port in the same vessel ", test, test1);

						}
						else {
							Step_Start(8, "Choose Current voyage ", test, test1);
							Step_Start(9, "If ther terminal should only be renamed for the current voyage", test, test1);
							waitForElement(driver, Current_Voyage_Btn);
							click(driver,Current_Voyage_Btn);
							waitForElement(driver, Termial_Change_Ok);
							click(driver,Termial_Change_Ok);
							waitForPopup(driver, popup_Message, CurrentTerminalRenamed);
							String Terminal_Popup= getText(driver, popup_Message);
							if(Terminal_Popup.equals(CurrentTerminalRenamed)) {
								System.out.println("Matched || Expected Popup : "+CurrentTerminalRenamed+" || Actual Popup : "+Terminal_Popup);
								Extent_pass_New(driver, "Matched || Expected Popup : "+CurrentTerminalRenamed+" || Actual Popup : "+Terminal_Popup, test,test1);
							}else {
								System.out.println("NotMatched || Expected Popup : "+CurrentTerminalRenamed+" || Actual Popup : "+Terminal_Popup);
								Extent_fail(driver,  "NotMatched || Expected Popup : "+CurrentTerminalRenamed+" || Actual Popup : "+Terminal_Popup, test,test1);
							}
							Step_End(8, "Choose Current voyage ", test, test1);
							Step_End(9, "If ther terminal should only be renamed for the current voyage", test, test1);

							click(driver,popup_Message_Ok_Button);
							
							waitForElement(driver, Tree_Structure);
							String status3 = getAttribute(driver, Voyage_Toggler, "class");
							if(!status3.contains("s")) {
								click(driver, Voyage_Toggler);
							}
							waitForElement(driver, Port_Select);
							String terminal = getText(driver, Port_Select);
							if(terminal.contains(TerminalInput)) {
								System.out.println("Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal);
								Extent_pass_New(driver, "Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal, test,test1);
							}else {
								System.out.println("NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal);
								Extent_fail(driver, "NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal, test,test1);
							}					

							waitForElement(driver, Tree_Structure);

							if(isDisplayed(driver, future_Voyage)) {
								String status2 = getAttribute(driver, future_VoyageToggler, "class");
								if(!status2.contains("s")) {
									click(driver, future_VoyageToggler);
								}
								waitForElement(driver, future_VoyagePort);
								String terminal1 = getText(driver, future_VoyagePort);
								if(!terminal1.contains(TerminalInput)) {
									System.out.println("Not Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1);
									Extent_pass_New(driver, "Not Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1, test,test1);
								}else {
									System.out.println("Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1);
									Extent_fail(driver, "Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1, test,test1);
								}
							}

						} 
						Extent_completed(testCaseName, test, test1);
						} 

					}

				}
	 
