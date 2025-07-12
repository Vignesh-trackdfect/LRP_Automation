package LRP_VSS_Integration_Scripts_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Proforma_Service_Creation_PC05_I extends Keywords {

	public void editingQuickProforma(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

//		Get data from excel sheet

		String testcase_Name="TC_Proforma_Service_Creation_PC05_I";
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String ModuleSearch = Excel_data.get("Module_Search");
		String noOfTimeAdd = Excel_data.get("NoOfPortsAdd");
		String proformaCode = Excel_data.get("ProformaCode");
		String portCodeEdit = Excel_data.get("PortCodeEdit");
		String bufferTimeEdit = Excel_data.get("BufferTimeEdit");
		String boundEdit = Excel_data.get("BoundEdit");
		String timeZoneEdit = Excel_data.get("TimeZoneEdit");
		String addRowPortCode = Excel_data.get("AddRowPortCode");
		String terminalCodeEdit = Excel_data.get("TerminalCodeEdit");
		String search2 = Excel_data.get("Search_Input_2");
		String search3 = Excel_data.get("Search_Input_3");
		String Ports_Status = Excel_data.get("Ports_Status");
		 String dropdownCondition = Excel_data.get("DropdownCondition");
	        String globalSearchValueType = Excel_data.get("GlobalSearchValueType");
			String condition = Excel_data.get("Condition");
			String terminalCode_Search_Header = Excel_data.get("TerminalCode_Search_Header");
			String To_Port_Search = Excel_data.get("To_Port_Search");
			String From_Port_Search = Excel_data.get("From_Port_Search");
			String Location_Code_Header = Excel_data.get("Location_Code_Header");
			String condition_Filter = Excel_data.get("condition_Filter");



		
		
		
		Extent_Start(testcase_Name, test, test1);

		
		navigateUrl(driver, url);

		// Login

		   LRP_Login(driver, Username, Password);
				
		   moduleNavigate(driver, ModuleSearch);
		  		
//			Proforma service creation	


			Step_Start(1, "Click on Global search icon", test, test1);


			waitForElement(driver, SearchButton_Toolbar);
	        click(driver,SearchButton_Toolbar);
	        
			Step_End(1, "Click on Global search icon", test, test1);
			
			globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, proformaCode, "", "", "", "");


//		Edit Quick proforma

			scrollTop(driver);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
			Step_Start(3, "Click on Quick proforma button", test, test1);
			 waitForDisplay(driver, Proforma_Temp_Remove);
				if(isdisplayed(driver, Proforma_Temp_Remove)){
					waitForElement(driver, Proforma_Temp_Remove);
					click(driver, Proforma_Temp_Remove);
				}
			waitForElement(driver, quickproforma);
			click(driver, quickproforma);
			Step_End(3, "Click on Quick proforma button", test, test1);
//		Add Multiple ports in grid

			Step_Start(4, "Enter the Port Code in the Port Code field", test, test1);
			int j = Integer.parseInt(noOfTimeAdd);
			for (int i = 1; i <= j; i++) {
				String portCode = Excel_data.get("PortCode" + i);

				waitForElement(driver, quickproforma_portcode);
				sendKeys(driver, quickproforma_portcode, portCode);
				Step_End(4, "Enter the Port Code in the Port Code field", test, test1);

				Step_Start(5, "Click on enter should add the value to below grid", test, test1);

				waitForElement(driver, port_Code_Panel);
				click(driver, port_Code_Panel);
				
				Extent_pass_New(driver, portCode + " Port has added", test, test1);
				Step_End(5, "Click on enter should add the value to below grid", test, test1);
			}

			Step_Start(6, "To Edit an existing added row, Double click the row and edit the port code", test, test1);
			waitForElement(driver, editRow1);
			click(driver, editRow1);
			waitForElement(driver, editRow1);
			doubleClick(driver, editRow1);

			waitForElement(driver, quickproforma_portcode);
			clear(driver, quickproforma_portcode);
			waitForElement(driver, quickproforma_portcode);
			sendKeys(driver, quickproforma_portcode, portCodeEdit);
			waitForElement(driver, port_Code_Panel);
			click(driver, port_Code_Panel);
			
			Step_End(6, "To Edit an existing added row, Double click the row and edit the port code", test, test1);
			waitForElement(driver, bufferTime_Row);
			String updatedPortcode5 = String.format(updated_Portcode, portCodeEdit);

			String updated_Portcode =getText(driver, updatedPortcode5);
			System.out.println("updated_Portcode:" + updated_Portcode);

			Step_Start(7, "Click on the fields such as , Time zone, Buffer Time , Bound to Edit", test, test1);
			waitForElement(driver, bufferTime_Row);
			click(driver, bufferTime_Row);
			waitForElement(driver, bufferTimeEdit_Row);
			click(driver, bufferTimeEdit_Row);
			waitForElement(driver, bufferTimeEdit_Row);
			clearAndType(driver, bufferTimeEdit_Row, bufferTimeEdit);

			waitForElement(driver, timeZone_Row);
			click(driver, timeZone_Row);
			waitForElement(driver, timeZoneEdit_Row);
			click(driver, timeZoneEdit_Row);
			waitForElement(driver, timeZoneEdit_Row);
			clearAndType(driver, timeZoneEdit_Row, timeZoneEdit);

			waitForElement(driver, bound_Row);
			click(driver, bound_Row);
			String bound_EditOption = String.format(boundEditOption, boundEdit);
			waitForElement(driver, bound_EditOption);
			click(driver, bound_EditOption);
			
			Step_End(7, "Click on the fields such as , Time zone, Buffer Time , Bound to Edit", test, test1);
			Step_Start(8, "Click on Move up / Move down button to change the position of port code ", test, test1);
			waitForElement(driver, moveUp_Row);
			click(driver, moveUp_Row);
			waitForElement(driver, moveUp_Row);
			Extent_pass_New(driver, "The row has moved up", test, test1);

			waitForElement(driver, moveDown_Row);
			click(driver, moveDown_Row);
			waitForElement(driver, moveDown_Row);
			Extent_pass_New(driver, "The row has moved down", test, test1);

			Step_End(8, "Click on Move up / Move down button to change the position of port code ", test, test1);
			waitForElement(driver, editRow1);
			click(driver, editRow1);

			waitForElement(driver, quickproforma_portcode);
			clear(driver, quickproforma_portcode);
			waitForElement(driver, quickproforma_portcode);
			sendKeys(driver, quickproforma_portcode, addRowPortCode);
			waitForElement(driver, quickproforma_portcode);
			waitForElement(driver, port_Code_Panel);
			click(driver, port_Code_Panel);
			
			waitForElement(driver, terminalCode_Row);
			click(driver, terminalCode_Row);
			Step_Start(9, "Click on Terminal Search icon to change the Terminal of the port", test, test1);
			waitForElement(driver, terminalCode_Search);
			click(driver, terminalCode_Search);
			
			twoColumnSearchWindow(driver, terminalCode_Search_Header, condition, terminalCodeEdit);
			
			Step_End(9, "Click on Terminal Search icon to change the Terminal of the port", test, test1);

			waitForElement(driver, terminalCode_Row);
			 String addedRowPortCode_New = getText(driver, addedRowPortCode5);
			
			System.out.println("addedRowPortCode: " +  addedRowPortCode_New);

			waitForElement(driver, terminalCode_Row);
			Extent_pass_New(driver, "Rows in Quick proforma", test, test1);

//		No of ports in Quick proforma 

			ArrayList<String> qproPorts = new ArrayList<String>();
			waitForElement(driver, quickProformaRows);

				List<WebElement> quickProformaRows_New = listOfElements(driver, quickProformaRows);
				
				int size = quickProformaRows_New.size();

				for (int i = 1; i < size; i += 2) {
					
					String qport_New = getText(driver, String.format(qport, i));
					qproPorts.add(qport_New);
				}

			Step_Start(12, "Click on ok ", test, test1);
			waitForElement(driver, quickProforma_Ok_Button);
			click(driver, quickProforma_Ok_Button);
			Step_End(12, "Click on ok ", test, test1);
	//  No of ports in Quick proforma 
			Step_Start(13, "Now the data added to the grid in the outer menu ", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			ArrayList<String> proPorts = new ArrayList<String>();
			waitForElement(driver, proformaRows5);


				List<WebElement> proformaRows = listOfElements(driver, proformaRows5);
				
				for (WebElement quickProformaList : proformaRows) {

					String proPortsList = quickProformaList.getText();
					proPorts.add(proPortsList);

				}
			


		   if(proPorts.equals(qproPorts)) {
			   Extent_pass_New(driver, "Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
			   System.out.println("Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);
		   }else {
			   System.out.println("Not Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);

			   Extent_fail(driver, "Not Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
		   }
		   
		   Step_End(13, "Now the data added to the grid in the outer menu ", test, test1);

		waitForElement(driver, Getmarinedistance);
		safeclick(driver, Getmarinedistance);


		ArrayList<String> portName = new ArrayList<String>();
		waitForElement(driver, Ports_codes);

		List<WebElement> Ports_code = listOfElements(driver, Ports_codes);

		for (WebElement Ports : Ports_code) {
			String name = Ports.getText();

			System.out.println(name);
			portName.add(name);
		}
		horizontalscroll(driver, scroll_P, 3500);

		ArrayList<String> Distance = new ArrayList<String>();
		waitForElement(driver, Distance_codes);
		List<WebElement> Distance_code = listOfElements(driver, distanceList);

		for (WebElement distance : Distance_code) {
			String name = distance.getText();

			System.out.println(name);

			Distance.add(name);
		}
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		Extent_call(test, test1, "Open Marine Distance Module");

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

				System.out.println("Expected result is : distance should  be found || Actual Result is : Distance is  found");
				Extent_pass_New(driver, "Expected result is : distance should  be found || Actual Result is : Distance is  found", test, test1);
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