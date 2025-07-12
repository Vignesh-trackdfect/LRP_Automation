package LRP_VSS_Proforma_Service_Creation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Proforma_Service_Creation_PC04 extends Keywords{
	
//	Saving Record via Quick Proforma
	
	public void Proforma_Service_Creation_PC04(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
//	Get data from excel sheet
		
		String tc_name="TC_Proforma_Service_Creation_PC04";


		
		       
		
		String Username = Excel_data.get("Username");
        String Password = Excel_data.get("Password");
        String ModuleSearch = Excel_data.get("Module_Search");
        String noOfTimeAdd = Excel_data.get("NoOfPortsAdd");
        String portCodeEdit = Excel_data.get("PortCodeEdit");
        String bufferTimeEdit = Excel_data.get("BufferTimeEdit");
        String boundEdit = Excel_data.get("BoundEdit");
        String timeZoneEdit = Excel_data.get("TimeZoneEdit");
        String addRowPortCode = Excel_data.get("AddRowPortCode");
        String terminalCodeEdit = Excel_data.get("TerminalCodeEdit");
        String remarks = Excel_data.get("Remarks");
        String proformaSavedPopup = Excel_data.get("ProformaSavedPopup");
        String status = Excel_data.get("ProformaStatus");
        String type = Excel_data.get("ProformaType");
        String capacity = Excel_data.get("Capacity");     
        String startDate = Excel_data.get("StartDate");
        String quickProformaStartDate = Excel_data.get("QuickProformaStartDate");
        String defaultSpeed = Excel_data.get("DefaultSpeed");
        String defaultTerminalTime = Excel_data.get("DefaultTerminalTime");
        String defaultTimeZone = Excel_data.get("DefaultTimeZone");
        String defaultDistance = Excel_data.get("DefaultDistance");
        String defaultBufferTime = Excel_data.get("DefaultBufferTime");
        String date_Picker = Excel_data.get("DatePicker");
        String QuickProforma_Panel = Excel_data.get("QuickProforma_Panel");
        String Service_Filter_Data = Excel_data.get("Service_Filter_Data");
        
        String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String terminalCode_Search_Header = Excel_data.get("TerminalCode_Search_Header");


		Extent_Start(tc_name, test, test1);

        
        navigateUrl(driver, url);
	
//   Login
        
        LRP_Login(driver, Username, Password);
		
        moduleNavigate(driver, ModuleSearch);
        
//	 	Proforma service creation	
	 		
	 		
	 		Step_Start(1, "Click on the new button ", test, test1);

	 		newButton(driver);
	 		Step_End(1, "Click on the new button", test, test1);
	 	
	 		waitForElement(driver, service_Search_Icon_Psc);
	 		click(driver, service_Search_Icon_Psc);
	 		
	 		twoColumnSearchWindow(driver, service_Search_Header, condition, Service_Filter_Data);

	 		waitForElement(driver, remark_field);
	 		click(driver, remark_field);
	 		waitForElement(driver, remark_field);
	 		sendKeys(driver, remark_field, remarks);

	 		 waitForDisplay(driver, Proforma_Temp_Remove);
	 			if(isdisplayed(driver, Proforma_Temp_Remove)){
	 				waitForElement(driver, Proforma_Temp_Remove);
	 				click(driver, Proforma_Temp_Remove);
	 			}
	 		waitForElement(driver, proforma_Date);

	 		if(date_Picker.equalsIgnoreCase("Yes")) {
	 			
	 			selectDatePickerWithTime_Proforma(driver, proforma_Date, startDate);

	 		}else {
	 			if(startDate.contains("-")) {
	 				String startDate1=startDate.replace("-", "/");

	 				waitForElement(driver, proforma_Date);

	 				clearAndType(driver, proforma_Date, startDate1);
	 				waitForElement(driver, calenderclosebutton_SPF);
	 				click(driver, calenderclosebutton_SPF);
	 			}else {
	 				waitForElement(driver, proforma_Date);
	 				clearAndType(driver, proforma_Date, startDate);	
	 				waitForElement(driver, calenderclosebutton_SPF);
	 				click(driver, calenderclosebutton_SPF);

	 				}
	 		}

//	 		Non mandatory fields
	 		
	 		if(!status.equals("")) {
	 			waitForElement(driver, status_Dropdown_SPF);
	 			click(driver,status_Dropdown_SPF);
	 			
	 			String select_Status=String.format(DropDown_Select,status);
	 			
	 			waitForElement(driver, select_Status);
	 			click(driver, select_Status);
	 		}
	 		
	 		if(!type.equals("")) {
	 			waitForElement(driver, type_Dropdown);
	 			click(driver,type_Dropdown);
	 			
	 			String select_Type=String.format(DropDown_Select,type);
	 			
	 			waitForElement(driver, select_Type);
	 			click(driver, select_Type);
	 		}

	 		if(!capacity.equals("")) {
	 			waitForElement(driver, capacity_Textfield);
	 			click(driver,capacity_Textfield);
	 			waitForElement(driver, capacity_Textfield);
	 			clearAndType(driver, capacity_Textfield, capacity);

	 		}
	 		
	 	
//	 	Quick proforma
	 		Step_Start(2, "Click on Quick proforma button", test, test1);
	 		waitForElement(driver, quickproforma);
	 	    click(driver,quickproforma);
	 	    Step_End(2, "Click on Quick proforma button", test, test1);
	 	    if(!quickProformaStartDate.equals("")) {
	 	    	waitForElement(driver, quickProforma_StartDate);

	 			if(date_Picker.equalsIgnoreCase("Yes")) {
	 				
	 				selectDatePickerWithTime(driver, quickProforma_StartDate, quickProformaStartDate);

	 				}else {
	 				if(quickProformaStartDate.contains("-")) {
	 					String quickProformaStartDate1=quickProformaStartDate.replace("-", "/");
	 					waitForElement(driver, quickProforma_StartDate);
	 					clearAndType(driver, quickProforma_StartDate, quickProformaStartDate1);
	 					waitForElement(driver, calenderclosebutton_SPF);
	 					click(driver, calenderclosebutton_SPF);
	 			
	 					}else {
	 					waitForElement(driver, quickProforma_StartDate);
	 					clearAndType(driver, quickProforma_StartDate, quickProformaStartDate);	
	 					waitForElement(driver, calenderclosebutton_SPF);
	 					click(driver, calenderclosebutton_SPF);

	 					}
	 			}
	 	    }

//	 	   Non mandatory fields
	 	    
	 	    if(!defaultSpeed.equals("")) {
	 	    	waitForElement(driver, defaultSpeed_Textfield);
	 	    	click(driver, defaultSpeed_Textfield);
	 	    	waitForElement(driver, defaultSpeed_Textfield);
	 	    	clearAndType(driver, defaultSpeed_Textfield, defaultSpeed);
	 	    	
	 	    }
	 	    if(!defaultTerminalTime.equals("")) {
	 	    	waitForElement(driver, defaultTerminalTime_Textfield);
	 	    	click(driver, defaultTerminalTime_Textfield);
	 	    	waitForElement(driver, defaultTerminalTime_Textfield);
	 	    	clearAndType(driver, defaultTerminalTime_Textfield, defaultTerminalTime);
	 	    	
	 	    }
	 	    
	 	    if(!defaultTimeZone.equals("")) {
	 	    	waitForElement(driver, defaultTimeZone_Textfield);
	 	    	click(driver, defaultTimeZone_Textfield);
	 	    	waitForElement(driver, defaultTimeZone_Textfield);
	 	    	clearAndType(driver, defaultTimeZone_Textfield, defaultTimeZone);
	 	    	
	 	    }
	 	    
	 	    if(!defaultDistance.equals("")) {
	 	    	waitForElement(driver, defaultDistance_Textfield);
	 	    	click(driver, defaultDistance_Textfield);
	 	    	waitForElement(driver, defaultDistance_Textfield);
	 	    	clearAndType(driver, defaultDistance_Textfield, defaultDistance);
	 	    	
	 	    } 
	 	    
	 	    if(!defaultBufferTime.equals("")) {
	 	    	waitForElement(driver, defaultBufferTime_Textfield);
	 	    	click(driver, defaultBufferTime_Textfield);
	 	    	waitForElement(driver, defaultBufferTime_Textfield);
	 	    	clearAndType(driver, defaultBufferTime_Textfield, defaultBufferTime);
	 	    	
	 	    } 
	 	    
	     	waitForElement(driver, add_Button);
	 	    click(driver, add_Button);
	 	
//	 	   Add Multiple ports in grid & Edit
	 	    Step_Start(3, "Enter the Port Code in the Port COde field", test, test1);
	 	    int j=Integer.parseInt(noOfTimeAdd);
	 	    for(int i=1;i<=j;i++) {
 		    	waitForElement(driver, quickproforma_portcode);

	 			 String portCode = Excel_data.get("PortCode"+i);
	 			 
	 		    	waitForElement(driver, quickproforma_portcode);
	 		    	sendKeys(driver, quickproforma_portcode, portCode);
	 		    	
	 		    	waitForElement(driver, port_Code_Panel);
	 				click(driver, port_Code_Panel);		
	 				
	 		    	waitForElement(driver, quickproforma_portcode);
	 		    	clear(driver, quickproforma_portcode);
	 		    	
	 			 Extent_call(test, test1, "Repeat sending the portcodes & click enter until the required ports for the voyage is added");
	 	    	
	 	    }
	 	   Step_End(3, "Enter the Port Code in the Port COde field", test, test1);
	 	    
	 	    Step_Start(4, "To Edit an exisitng added row, Double click the row and edit the port code ", test, test1);

	     	waitForElement(driver, editRow);
	     	waitForElement(driver, editRow);
	 	    click(driver, editRow);
	     	waitForElement(driver, editRow);
	 	    doubleClick(driver, editRow);	
	 	    
	     	waitForElement(driver, quickproforma_portcode);
	 	    clear(driver,quickproforma_portcode);
	     	waitForElement(driver, quickproforma_portcode);
	 	    sendKeys(driver, quickproforma_portcode, portCodeEdit);
	     	waitForElement(driver, quickproforma_portcode);
	     	waitForElement(driver, port_Code_Panel);
	 		click(driver, port_Code_Panel);
	 		
	 	    
	     	waitForElement(driver, bufferTime_Row);
	 	    String updatedPortcode =String.format(updated_Portcode, portCodeEdit);
	 	    String updated_Portcode1 = getText(driver, updatedPortcode);
	 	    System.out.println("updated_Portcode:"+updated_Portcode1);
	    
	 	   Step_End(4, "To Edit an exisitng added row, Double click the row and edit the port code ", test, test1);
	 	   
	 	   Step_Start(5, "Click on the fields such as , Time zone, Buffer Time , Bound to Edit & clicking the terminal search icon", test, test1);
	 	   
	 	   click(driver,bufferTime_Row);
	    		waitForElement(driver, bufferTimeEdit_Row);
	 	   click(driver,bufferTimeEdit_Row);
	   		waitForElement(driver, bufferTimeEdit_Row);
	 	   clearAndType(driver, bufferTimeEdit_Row, bufferTimeEdit);
	 	  
	 	   waitForElement(driver, timeZone_Row);
	 	   click(driver,timeZone_Row);
	 	   waitForElement(driver, timeZoneEdit_Row);
	 	   click(driver,timeZoneEdit_Row);
	 	   waitForElement(driver, timeZoneEdit_Row);
	 	   clearAndType(driver, timeZoneEdit_Row, timeZoneEdit);

	 	   waitForElement(driver, bufferTime_Row);
	 		click(driver,bufferTime_Row);
	 	    waitForElement(driver, terminalCode_Row);
	 		click(driver, terminalCode_Row);
	 		
	 		twoColumnSearchWindow(driver, terminalCode_Search_Header, condition, terminalCodeEdit);

	 		waitForElement(driver, bound_Row);
	 	   click(driver, bound_Row);
	 	   
	 	   String bound_EditOption = String.format(boundEditOption, boundEdit);
	 		waitForElement(driver, bound_EditOption);
	 		click(driver, bound_EditOption);
	 		
	 	   Step_End(5, "Click on the fields such as , Time zone, Buffer Time , Bound to Edit &  clicking the terminal search icon", test, test1);
	 	   
	 	   Step_Start(6, "Click on Move up  Move down button to change the position of port code", test, test1);
	 		waitForElement(driver, moveUp_Row);
	 	   click(driver, moveUp_Row);
	 		waitForElement(driver, moveDown_Row);
	 	   Extent_pass_New(driver, "The row has moved up", test, test1);
	 	   
	 	   click(driver, moveDown_Row);
	 	   Extent_pass_New(driver, "The row has moved down", test, test1);

	 	   Step_End(6, "Click on Move up Move down button to change the position of port code", test, test1);
	 	   
	 	   Step_Start(7, "To add a port between port, click on the port row single time ,and enter the port code should add new row with the given port code ", test, test1);
	 		waitForElement(driver, editRow);
	 	   click(driver, editRow);	
	 	    
	 		waitForElement(driver, quickproforma_portcode);
	 	    clear(driver,quickproforma_portcode);
	 	    Extent_call(test, test1, "Sending the portcode and then click enter");
	 		waitForElement(driver, quickproforma_portcode);
	 	    sendKeys(driver, quickproforma_portcode, addRowPortCode);
	 	    
	 	    String portcodePanel=String.format(portcode_Panel,QuickProforma_Panel);
	 	    
	 	    waitForElement(driver, portcodePanel);
	 	    click(driver, portcodePanel);
	 	    

	 		waitForElement(driver, addedRowPortCode);
	 		
	 		System.out.println("addedRowPortCode: "+ getText(driver, addedRowPortCode));
	 	 Step_End(7, "To add a port between port, click on the port row single time ,and enter the port code should add new row with the given port code ", test, test1);
	 	   Extent_pass_New(driver, "Rows in Quick proforma", test, test1);
	 	 
//	 	  No of ports in Quick proforma 
	 	   
	 	   ArrayList<String> qproPorts=new ArrayList<String>();
	 	   
	 		   List <WebElement>  quickProforma_Rows= listOfElements(driver, quickProformaRows);
	 		   int size=quickProforma_Rows.size();
	    System.out.println("size of rows is:"+size);
	 		   for(int i=1;i<size;i+=2) {
	 			   String qp_Port=String.format(qpPort, i);
	 			   String qpPort_List = getText(driver, qp_Port);//need to verify this
	 			   qproPorts.add(qpPort_List);
	 		 
	 		   }
	 	   	   
	 	   waitForElement(driver, quickProforma_Ok_Button);
	 	   click(driver, quickProforma_Ok_Button);

	 //  No of ports in  proforma 

	 	   waitForElement(driver, SaveButton_ToolBar);
	 	   ArrayList<String> proPorts=new ArrayList<String>();
	 		    List<WebElement> proforma_Rows = listOfElements(driver, proformaRows);
	 		   
	 		   for(WebElement quickProformaList:proforma_Rows) {
			 	   waitForElement(driver, proformaRows);
	 			   String proPortsList=quickProformaList.getText();
	 			   proPorts.add(proPortsList);  
	 			   
	 		   }
	 	   if(proPorts.equals(qproPorts)) {
	 		   Extent_pass_New(driver, "Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
	 		   System.out.println("Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);
	 	   }else {
	 		   System.out.println("Not Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);

	 		   Extent_fail(driver, "Not Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
	 	   }
	 	   
//	 	Verify the proforma service creation popup
	 	   
	 	   click(driver,SaveButton_ToolBar);
	 		
	 		waitForPopup(driver, popup_Message, proformaSavedPopup);

	 		String actualUpdatedPopup = getText(driver, popup_Message);

	 		if (actualUpdatedPopup.equals(proformaSavedPopup)) {
	 			Extent_pass_New(driver, "Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+actualUpdatedPopup, test,test1);
	 			System.out.println("Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+actualUpdatedPopup);
	 			click(driver, popup_Message_Ok_Button);
	 		}else {
	 			System.out.println("Not Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+actualUpdatedPopup);

	 			Extent_fail(driver, "Not Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+actualUpdatedPopup, test,test1);
	 		}
		
		Extent_completed(tc_name, test, test1);
		  
	}
	}
