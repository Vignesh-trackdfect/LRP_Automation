package LRP_VSS_Coastal_Scedule_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS07 extends Keywords {

	public void Coastal_Schedule_CS07(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS07";

		String Add_Bound_1 =Excel_data.get("Add_Bound_1");
		String Add_Bound_2 =Excel_data.get("Add_Bound_2");
		String Add_Bound_3 =Excel_data.get("Add_Bound_3");
		String Pivot_Voyage_1=Excel_data.get( "Pivot_Voyage_1");
		String Pivot_Voyage_2=Excel_data.get( "Pivot_Voyage_2");
		String editVoyageText=Excel_data.get( "EditVoyageFrameText");
		String pivotBound1=Excel_data.get( "PivotBound1");
		String pivotBound2=Excel_data.get( "PivotBound2");
		String pivotBound3=Excel_data.get( "PivotBound3");
		String pivotVoyage1=Excel_data.get( "PivotVoyage1");
		String pivotVoyage2=Excel_data.get( "PivotVoyage2");
		String pivotVoyage3=Excel_data.get( "PivotVoyage3");
		String headVoyage=Excel_data.get( "HeadVoyage");
		String Pivot_Voyage_3=Excel_data.get("Pivot_Voyage_3");
		String Username_CS07 =Excel_data.get("Username");
		String Password_CS07 =Excel_data.get("Password");
		String ModuleSearch_CS07 =Excel_data.get("Module_Search");
		String ServiceCode_CS07 =Excel_data.get("Service_Code"); 
		String VesselCode_CS07 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS07 =Excel_data.get("Voyage_Number");
		String portName_CS07 =Excel_data.get("Port_Name");
		String edit_Button_CS07 =Excel_data.get("Button");
		String Bound_1=Excel_data.get("Bound_1");
		String Bound_2 =Excel_data.get("Bound_2");
		String Bound_3= Excel_data.get("Bound_3");
		String Select_Columns= Excel_data.get("Select_Columns");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");


		
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
		String edit_Bound_2 = String.format(DropDown_Select,Bound_2);
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
		Step_End(14, "System should update the Voyage numbers from the above actions", test, test1);
		Extent_completed(testCaseName, test, test1);

	}
}
