package LRP_VSS_Integration_Scripts_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Proforma_Service_Creation_PC03_I extends Keywords {

	public void editRecords(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name="TC_Proforma_Service_Creation_PC03_I";
		
		


		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String ModuleSearch = Excel_data.get("Module_Search");
		String arr_DockDate = Excel_data.get("ArrDockDate");
		String arr_PilotDate = Excel_data.get("ArrPilotDate");
		String dep_DockDate = Excel_data.get("DepDockDate");
		String dep_PilotDate = Excel_data.get("DepPilotDate");
		String firstAndLastPortSame = Excel_data.get("FirstAndLastPortSame");
		String proformaCode = Excel_data.get("ProformaCode");
		String arrDockLessorPopup = Excel_data.get("ArrDockLessorPopup");
		String depDockLessArrDock = Excel_data.get("DepDockLessArrDock");
		String depPilotLessDepDock = Excel_data.get("DepPilotLessDepDock");
		String arrPilotGreaterPrevDep = Excel_data.get("ArrPilotGreaterPrevDep");
		String samePortAndTerminal = Excel_data.get("SamePortAndTerminal");
		String confirmStatus = Excel_data.get("ConfirmStatus");
		String port = Excel_data.get("Port");
		String terminal = Excel_data.get("Terminal");
		String search2 = Excel_data.get("Search_Input_2");
		String search3 = Excel_data.get("Search_Input_3");
		String Ports_Status = Excel_data.get("Ports_Status");
		String date_Picker = Excel_data.get("DatePicker");
		 String dropdownCondition = Excel_data.get("DropdownCondition");
	        String globalSearchValueType = Excel_data.get("GlobalSearchValueType");
	    	String condition = Excel_data.get("Condition");
			String port_Search_Header = Excel_data.get("Port_Search_Header");
			String terminal_Search_Header = Excel_data.get("Terminal_Search_Header");
			String To_Port_Search = Excel_data.get("To_Port_Search");
			String From_Port_Search = Excel_data.get("From_Port_Search");
			String Location_Code_Header = Excel_data.get("Location_Code_Header");
			String condition_Filter = Excel_data.get("condition_Filter");



		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		   LRP_Login(driver, Username, Password);
			
		   moduleNavigate(driver, ModuleSearch);
	        
//			Proforma service creation	

//				Retrieve Record
				Step_Start(1, "Retireve the existing record from the global search", test, test1);
				
				waitForElement(driver, SearchButton_Toolbar);
		        click(driver,SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, proformaCode, "", "", "", "");

				
				Step_End(1, "Retireve the existing record from the global search", test, test1);
				Step_Start(2, "Click on the edit button ", test, test1);
				
					waitForElement(driver, Edit_Button_toolBar); 	    
				    click(driver, Edit_Button_toolBar);
				    
				    waitForDisplay(driver, Proforma_Temp_Remove);
					if(isdisplayed(driver, Proforma_Temp_Remove)){
						waitForElement(driver, Proforma_Temp_Remove);
						click(driver, Proforma_Temp_Remove);
					}
				    Step_End(2, "Click on the edit button ", test, test1);  
					waitForElement(driver, grid_Horizontal_Scrollbar_SPF); 	    
					horizontalscroll(driver, grid_Horizontal_Scrollbar_SPF, 600);
					
					
//				ArrDock	lesser than ArrPilot
					
					Step_Start(3, "Check whether the system shows validation when the Arr Dock values is lesser than Arr pilot", test, test1);

				    waitForElement(driver, arrDockTime);		
					doubleClick(driver, arrDockTime);
							
					if(date_Picker.equalsIgnoreCase("Yes")) {
						
						selectDatePickerWithTime(driver, arrDockTime, arr_DockDate);

					}else {
						if(arr_DockDate.contains("-")) {
							String arr_DockDate1=arr_DockDate.replace("-", "/");
							waitForElement(driver, arrDockTime);
							click(driver,arrDockTime);
							waitForElement(driver, arrDockTime);
							clearAndType(driver, arrDockTime, arr_DockDate1);
							
						}else {
							click(driver,arrDockTime);
							waitForElement(driver, arrDockTime);
							clearAndType(driver, arrDockTime, arr_DockDate);	

							}
						
						waitForElement(driver, calenderclosebutton_SPF);
						click(driver, calenderclosebutton_SPF);
					}
					
					waitForElement(driver, arrDockTime1);
					click(driver, arrDockTime1);
					
					waitForPopup(driver, popup_Message, arrDockLessorPopup);

					String actualPopup = getText(driver, popup_Message);

					if (actualPopup.equals(arrDockLessorPopup)) {
						Extent_pass_New(driver, "Matched || Expected popup :"+arrDockLessorPopup+" || Actual popup :"+actualPopup, test,test1);
						System.out.println("Matched || Expected popup :"+arrDockLessorPopup+" || Actual popup :"+actualPopup);
						click(driver, popup_Message_Ok_Button);
					}else {
						System.out.println("Not Matched || Expected popup :"+arrDockLessorPopup+" || Actual popup :"+actualPopup);

						Extent_fail(driver, "Not Matched || Expected popup :"+arrDockLessorPopup+" || Actual popup :"+actualPopup, test,test1);
					}
					
					waitForElement(driver, grid_Horizontal_Scrollbar_SPF);
					horizontalscroll(driver, grid_Horizontal_Scrollbar_SPF, 600);
					Step_End(3, "Check whether the system shows validation when the Arr Dock values is lesser than Arr pilot", test, test1);

//			DepDock lesser than ArrDock
				
					Step_Start(4, ".Check whether the system shows validation when the Dep Dock values is lesser than Arr Dock", test, test1);

					waitForElement(driver, depDockTime);		
					doubleClick(driver, depDockTime);

					if(date_Picker.equalsIgnoreCase("Yes")) {
						
						selectDatePickerWithTime(driver, depDockTime, dep_DockDate);
						
					}else {
						if(dep_DockDate.contains("-")) {
							String dep_DockDate1=dep_DockDate.replace("-", "/");
							waitForElement(driver, depDockTime);
							click(driver,depDockTime);
							waitForElement(driver, depDockTime);
							clearAndType(driver, depDockTime, dep_DockDate1);
						}else {
							click(driver,depDockTime);
							waitForElement(driver, depDockTime);
							clearAndType(driver, depDockTime, dep_DockDate);	

							}
						
						waitForElement(driver, calenderclosebutton_SPF);
						click(driver, calenderclosebutton_SPF);
					}
					waitForElement(driver, depDockTime1);
						click(driver, depDockTime1);
						
						waitForPopup(driver, popup_Message, depDockLessArrDock);
						String actualPopup2 = getText(driver, popup_Message);

						if (actualPopup2.equals(depDockLessArrDock)) {
							Extent_pass_New(driver, "Matched || Expected popup :"+depDockLessArrDock+" || Actual popup :"+actualPopup2, test,test1);
							System.out.println("Matched || Expected popup :"+depDockLessArrDock+" || Actual popup :"+actualPopup2);
							click(driver, popup_Message_Ok_Button);
						}else {
							System.out.println("Not Matched || Expected popup :"+depDockLessArrDock+" || Actual popup :"+actualPopup2);
							Extent_fail(driver, "Not Matched || Expected popup :"+depDockLessArrDock+" || Actual popup :"+actualPopup2, test,test1);
						}
						
						waitForElement(driver, grid_Horizontal_Scrollbar_SPF);
						horizontalscroll(driver, grid_Horizontal_Scrollbar_SPF, 600);
						Step_End(4, ".Check whether the system shows validation when the Dep Dock values is lesser than Arr Dock", test, test1);
						
//			DepPilot lesser than DepDock
						
					Step_Start(5, "Check whether the system shows validation when the Dep Dock values is Greater than Dep pilot", test, test1);
					    waitForElement(driver, depPilotTime);		
						doubleClick(driver, depPilotTime);
						
						if(date_Picker.equalsIgnoreCase("Yes")) {
							
							selectDatePickerWithTime(driver, depPilotTime, dep_PilotDate);
						
						}else {
							if(dep_PilotDate.contains("-")) {
								String dep_PilotDate1=dep_PilotDate.replace("-", "/");
								waitForElement(driver, depPilotTime);
								click(driver,depPilotTime);
								waitForElement(driver, depPilotTime);
								clearAndType(driver, depPilotTime, dep_PilotDate1);
								
							}else {
								click(driver,depPilotTime);
								waitForElement(driver, depPilotTime);
								clearAndType(driver, depPilotTime, dep_PilotDate);	

								}
							
							waitForElement(driver, calenderclosebutton_SPF);
							click(driver, calenderclosebutton_SPF);
						}
						
						waitForElement(driver, depPilotTime1);
						click(driver, depPilotTime1);
						
						waitForPopup(driver, popup_Message, depPilotLessDepDock);
						String actualPopup3 = getText(driver, popup_Message);

						if (actualPopup3.equals(depPilotLessDepDock)) {
							Extent_pass_New(driver, "Matched || Expected popup :"+depPilotLessDepDock+" || Actual popup :"+actualPopup3, test,test1);
							System.out.println("Matched || Expected popup :"+depPilotLessDepDock+" || Actual popup :"+actualPopup3);
							click(driver, popup_Message_Ok_Button);
						}else {
							System.out.println("Not Matched || Expected popup :"+depPilotLessDepDock+" || Actual popup :"+actualPopup3);

							Extent_fail(driver, "Not Matched || Expected popup :"+depPilotLessDepDock+" || Actual popup :"+actualPopup3, test,test1);
						}
						
						waitForElement(driver, grid_Horizontal_Scrollbar_SPF);
						horizontalscroll(driver, grid_Horizontal_Scrollbar_SPF, -1000);
						Step_End(5, "Check whether the system shows validation when the Dep Dock values is Greater than Dep pilot", test, test1);
						
//			Arr pilot values is Lesser than previous row  Dep pilot
						
						Step_Start(6, ".Check whether the system shows validation when the Arr pilot values is Lesser than previous row  Dep pilot", test, test1);
					    waitForElement(driver, arrPilotTime1);		
						doubleClick(driver, arrPilotTime1);
						
						if(date_Picker.equalsIgnoreCase("Yes")) {
							
							selectDatePickerWithTime(driver, arrPilotTime1, arr_PilotDate);

						}else {
							if(arr_PilotDate.contains("-")) {
								String arr_PilotDate1=arr_PilotDate.replace("-", "/");
								waitForElement(driver, arrPilotTime1);
								click(driver,arrPilotTime1);
								waitForElement(driver, arrPilotTime1);
								clearAndType(driver, arrPilotTime1, arr_PilotDate1);
							}else {
								click(driver,arrPilotTime1);
								waitForElement(driver, arrPilotTime1);
								clearAndType(driver, arrPilotTime1, arr_PilotDate);	

								}
							
							waitForElement(driver, calenderclosebutton_SPF);
							click(driver, calenderclosebutton_SPF);
						}
						
						waitForElement(driver, arrPilotTime);
						click(driver, arrPilotTime);
						
						waitForPopup(driver, popup_Message, arrPilotGreaterPrevDep);
						String actualPopup4 = getText(driver, popup_Message);

						if (actualPopup4.equals(arrPilotGreaterPrevDep)) {
							Extent_pass_New(driver, "Matched || Expected popup :"+arrPilotGreaterPrevDep+" || Actual popup :"+actualPopup4, test,test1);
							System.out.println("Matched || Expected popup :"+arrPilotGreaterPrevDep+" || Actual popup :"+actualPopup4);
							click(driver, popup_Message_Ok_Button);
						}else {
							System.out.println("Not Matched || Expected popup:"+arrPilotGreaterPrevDep+" || Actual popup :"+actualPopup4);

							Extent_fail(driver, "Not Matched || Expected popup :"+arrPilotGreaterPrevDep+" || Actual popup :"+actualPopup4, test,test1);
						}
						
						waitForElement(driver, grid_Horizontal_Scrollbar_SPF);
						horizontalscroll(driver, grid_Horizontal_Scrollbar_SPF, -1000);
						Step_End(6, ".Check whether the system shows validation when the Arr pilot values is Lesser than previous row  Dep pilot", test, test1);
				   
//						Change status to confirm
						Step_Start(7, "Change status to confirm", test, test1);
							
							waitForElement(driver, status_Dropdown_SPF);
							click(driver,status_Dropdown_SPF);
							
							String select_Status=String.format(DropDown_Select,confirmStatus);
							
							waitForElement(driver, select_Status);
							click(driver, select_Status);
						
						
				    	String firstPort=getText(driver, firstPort_3);
						String firstTerminal=getText(driver, firstTerminal_3);
						Step_End(7, "Change status to confirm", test, test1);

				//	Port search
						
						Step_Start(8, "System should not allow if the two rows have same port and same terminal ", test, test1);
						waitForElement(driver, remove_Button_SPF);
				    	click(driver,remove_Button_SPF);
				    	
						waitForDisplay(driver, marineDistance_Frame);
						if(isdisplayed(driver, marineDistance_Frame)) {
							waitForElement(driver, marineDistance_Ok_Button);
							click(driver, marineDistance_Ok_Button);
							}
				    	waitForElement(driver, AGgrid_plusicon);
						click(driver, AGgrid_plusicon);
						waitForElement(driver, portSearch_button_Grid_SPF);
						click(driver, portSearch_button_Grid_SPF);
						
						twoColumnSearchWindow(driver, port_Search_Header, condition, firstPort);

						
						waitForDisplay(driver, marineDistance_Frame);
						if(isdisplayed(driver, marineDistance_Frame)) {
							waitForElement(driver, marineDistance_Ok_Button);
							click(driver, marineDistance_Ok_Button);
							}
						
						
		//Terminal search
										
						waitForElement(driver, search_Terminal);
						click(driver, search_Terminal);
					
						twoColumnSearchWindow(driver, terminal_Search_Header, condition, firstTerminal);

						
							waitForElement(driver, SaveButton_ToolBar);
							click(driver,SaveButton_ToolBar);
							
							waitForPopup(driver, popup_Message, samePortAndTerminal);

							String actualPopup7 = getText(driver, popup_Message);

							if (actualPopup7.equals(samePortAndTerminal)) {
								Extent_pass_New(driver, "Matched || Expected popup :"+samePortAndTerminal+" || Actual popup :"+actualPopup7, test,test1);
								System.out.println("Matched || Expected popup:"+samePortAndTerminal+" || Actual popup :"+actualPopup7);
								Extent_pass_New(driver, samePortAndTerminal+" popup is displayed", test, test1);
								System.out.println( samePortAndTerminal+" popup is displayed");
								click(driver, popup_Message_Ok_Button);
							}else {
								System.out.println("Not Matched || Expected popup :"+samePortAndTerminal+" || Actual popup :"+actualPopup7);

								Extent_fail(driver, "Not Matched || Expected popup :"+samePortAndTerminal+" || Actual popup :"+actualPopup7, test,test1);
							}
							Step_End(8, "System should not allow if the two rows have same port and same terminal ", test, test1);
				    
				    
//			Add port
							Step_Start(9, "System should not allow to save the record, if the first row and last row have the same port and terminal", test, test1);
							waitForElement(driver, SaveButton_ToolBar);
							waitForDisplay(driver, ports3);

							List<WebElement> ports = listOfElements(driver, ports3);
							int noOfPorts=ports.size();
							
							for(int i=2;i<=3;i++) {
								if(i==2) {
									String searchPorts=String.format(search_Port, i);
									waitForElement(driver, searchPorts);
									click(driver, searchPorts);
								}else {
									
									String searchPorts=String.format(search_Port, noOfPorts);
									waitForElement(driver, searchPorts);
									click(driver, searchPorts);
								}
								
					//		Port search
								
								twoColumnSearchWindow(driver, port_Search_Header, condition, port);

								waitForDisplay(driver, marineDistance_Frame);
								if(isdisplayed(driver, marineDistance_Frame)) {
									waitForElement(driver, marineDistance_Ok_Button);
									click(driver, marineDistance_Ok_Button);
									}
//				Terminal search
								
								waitForElement(driver, SaveButton_ToolBar);
							
									if(i==2) {
										String terminalSearch=String.format(terminal_Search,i);
										waitForElement(driver, terminalSearch);
										click(driver, terminalSearch);
									}else {
										String terminalSearch=String.format(terminal_Search,noOfPorts);
										waitForElement(driver, terminalSearch);
										click(driver, terminalSearch);
									}
									
							
									twoColumnSearchWindow(driver, terminal_Search_Header, condition, terminal);
									
							}
							
						Step_End(9, "System should not allow to save the record, if the first row and last row have the same port and terminal", test, test1);
//				Change status to confirm
						Step_Start(10, "Change status to confirm", test, test1);
						
						waitForElement(driver, status_Dropdown_SPF);
						click(driver,status_Dropdown_SPF);
						
						select_Status=String.format(DropDown_Select,confirmStatus);
						
						waitForElement(driver, select_Status);
						click(driver, select_Status);
						
						
						Step_End(10, "Change status to confirm", test, test1);

						waitForElement(driver, SaveButton_ToolBar);
						click(driver,SaveButton_ToolBar);
						
						waitForPopup(driver, popup_Message, firstAndLastPortSame);

						String actualPopup6 = getText(driver, popup_Message);

						if (actualPopup6.equals(firstAndLastPortSame)) {
							Extent_pass_New(driver, "Matched || Expected popup :"+firstAndLastPortSame+" || Actual popup :"+actualPopup6, test,test1);
							System.out.println("Matched || Expected popup :"+firstAndLastPortSame+" || Actual popup :"+actualPopup6);
							click(driver, popup_Message_Ok_Button);
						}else {
							System.out.println("Not Matched || Expected popup :"+firstAndLastPortSame+" || Actual popup :"+actualPopup6);

							Extent_fail(driver, "Not Matched || Expected popup :"+firstAndLastPortSame+" || Actual popup:"+actualPopup6, test,test1);
						}
				
					
			
					
					
			
		Extent_call(test, test1, "Click Get Marine Distance Button");
		waitForElement(driver, Getmarinedistance);
		safeclick(driver, Getmarinedistance);


		ArrayList<String> portName = new ArrayList<String>();
		waitForDisplay(driver, Ports_codes);

		List<WebElement> Ports_code = listOfElements(driver, Ports_codes);

		for (WebElement Ports : Ports_code) {
			String name = Ports.getText();

			System.out.println(name);
			portName.add(name);
		}
		horizontalscroll(driver, scroll_P, 3500);
		waitForDisplay(driver, Distance_codes);

		ArrayList<String> Distance = new ArrayList<String>();
		List<WebElement> Distance_code = listOfElements(driver, Distance_codes);

		for (WebElement distance : Distance_code) {
			String name = distance.getText();

			System.out.println(name);

			Distance.add(name);
		}

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Extent_call(test, test1, "Open Marine distance Module");
		moduleNavigate(driver, search2);


		for (int k = 0; k < portName.size(); k++) {
			if (k + 1 >= portName.size()) {
				break;
			}

			scrollTop(driver);
			
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow1(driver, condition_Filter, From_Port_Search, portName.get(k), To_Port_Search, portName.get(k + 1), "", "");
			waitForDisplay(driver, Popup_Message);
			if (isDisplayed(driver, Popup_Message)) {

				System.out.println("***distance was not found for***" + portName.get(k) + "***" + portName.get(k + 1));
				Extent_pass_New(driver, "***distance is not available for the port pair ***" + portName.get(k) + "***"
						+ portName.get(k + 1), test, test1);
				waitForElement(driver, globalSearchCloseIcon_L);
				safeclick(driver, globalSearchCloseIcon_L);

			} else {

				System.out.println("distance was found");
				Extent_pass_New(driver, "distance was found", test, test1);
			}

			waitForDisplay(driver, retrivedGlobalValue);
			if(isdisplayed(driver, retrivedGlobalValue)) {
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			elementnotvisible1(driver, SelectButton);
			
				waitForElement(driver, Distance_GRidcell_MD);
				String distance_value = getText(driver, Distance_GRidcell_MD);
				System.out.println(distance_value);
				System.out.println(Distance.get(k));

				if (Distance.get(k).contains(distance_value)) {
					Extent_pass_New(driver,
							"***Value taken from long term***" + portName.get(k) + "***" + portName.get(k + 1)
									+ "******" + Distance.get(k) + "***Values taken from Distsnce***" + distance_value,
							test, test1);
					Extent_call(test, test1,
							"***Value taken from long term***" + portName.get(k) + "***" + portName.get(k + 1)
									+ "******" + Distance.get(k) + "***Values taken from Distsnce***" + distance_value);
					System.out.println("Expected result is : distance should  be equal || Actual Result is : Distance is  equal");

				} else {
					System.out.println("Expected result is : distance should  be equal || Actual Result is : Distance is  equal");

					Extent_pass_New(driver,
							"***Value taken from long term***" + portName.get(k) + "***" + portName.get(k + 1)
									+ "******" + Distance.get(k) + "***Values taken from Distsnce***" + distance_value,
							test, test1);

				}

			} else {

				System.out.println("Expected result is : distance should  be found || Actual Result is : Distance is  found");
				Extent_pass_New(driver, "Expected result is : distance should  be found || Actual Result is : Distance is  found", test, test1);

			}
		}
			
		
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		Extent_call(test, test1, "Open Ports Module");

		moduleNavigate(driver, search3);

		
		for (int D = 0; D < portName.size(); D++) {

			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, condition_Filter, Location_Code_Header, portName.get(D), "", "", "", "");
			
			Extent_call(test, test1, "Verify the status of port code");
			waitForElement(driver, Statusforport);
			String Port_status = getText(driver, Statusforport);
			System.out.println(Port_status);
			if (Port_status.equals(Ports_Status)) {
				Extent_pass_New(driver, "**Port code of**" + portName.get(D) + "**Status shown as**" + Port_status, test,
						test1);
			} else {
				System.out.println("Expected result is : ports should  be Active || Actual Result is : Ports is active");
				Extent_fail(driver, "Expected result is : ports should  be Active || Actual Result is : Ports is active", test, test1);
			}
		}

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		
		Extent_completed(testcase_Name, test, test1);

		
	}

}