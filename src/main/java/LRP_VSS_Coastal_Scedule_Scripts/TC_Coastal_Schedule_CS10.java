package LRP_VSS_Coastal_Scedule_Scripts;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS10 extends Keywords{

	public void Coastal_Schedule_CS10 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS10";

		String Username_CS10 =Excel_data.get("Username");
		String Password_CS10 =Excel_data.get("Password");
		String ModuleSearch_CS10 =Excel_data.get("Module_Search");
		String ServiceCode_CS10 =Excel_data.get("Service_Code"); 
		String VesselCode_CS10 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS10 =Excel_data.get("Voyage_Number");
		String portName_CS10 =Excel_data.get("Port_Name");
		String Bound_1_Popup=Excel_data.get("Bound_1_Popup");
		String Bound_2_Popup =Excel_data.get("Bound_2_Popup");
		String Bound_3_Popup= Excel_data.get("Bound_3_Popup");
		String Add_Bound_1_CS10 =Excel_data.get("Add_Bound_1");
		String Add_Bound_2_CS10 =Excel_data.get("Add_Bound_2");
		String Add_Bound_3_CS10 =Excel_data.get("Add_Bound_3");
		String pivotBound1_CS10=Excel_data.get( "PivotBound1");
		String pivotBound2_CS10=Excel_data.get( "PivotBound2");
		String pivotBound3_CS10=Excel_data.get( "PivotBound3");
		String Bound_1_CS10=Excel_data.get("Bound_1");
		String Bound_2_CS10 =Excel_data.get("Bound_2");
		String Bound_3_CS10= Excel_data.get("Bound_3");
		String remove_Bound_1_CS10=Excel_data.get("remove_Bound_1");
		String remove_Bound_2_CS10 =Excel_data.get("remove_Bound_2");
		String remove_Bound_3_CS10= Excel_data.get("remove_Bound_3");
		String Do_You_Want_Add_Bound_CS10= Excel_data.get("Do_You_Want_Add_Bound");

		String pivot_Bount1= Excel_data.get("Pivot_Bount1");
		String pivot_Bount2= Excel_data.get("Pivot_Bount2");
		String pivot_Bount3= Excel_data.get("Pivot_Bount3");
		String pivotBound_1_Added= Excel_data.get("PivotBound_1_Added");
		String pivotBound_2_Added= Excel_data.get("PivotBound_2_Added");
		String pivotBound_3_Added= Excel_data.get("PivotBound_3_Added");

		String subBoundAddedPopup = Excel_data.get("SubBoundAddedPopup");
		String selectSubBound = Excel_data.get("SubBound");
		String alreadyHaveSubBoundPopup = Excel_data.get("AlreadyHaveSubBoundPopup");
		String subBoundRemovedPopup = Excel_data.get("SubBoundRemovedPopup");
		String cannotRemovePopup = Excel_data.get("CannotRemovePopup");
		String noPivotBound_1_Popup = Excel_data.get("NoPivotBound_1_Popup");
		String noPivotBound_2_Popup = Excel_data.get("NoPivotBound_2_Popup");
		String noPivotBound_3_Popup = Excel_data.get("NoPivotBound_3_Popup");
		String onlyOnePivotBound_Popup = Excel_data.get("OnlyOnePivotBound_Popup");
		String wantToContinuePopup= Excel_data.get("WantToContinuePopup");
		String onlyOneSubBound= Excel_data.get("OnlyOneSubBound");




		String Select_Columns= Excel_data.get("Select_Columns");
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

		navigateUrl(driver, url);
		
		
		LRP_Login(driver, Username_CS10, Password_CS10);
		
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
}
