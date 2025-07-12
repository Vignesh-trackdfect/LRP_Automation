package LRP_VSS_Proforma_Service_Creation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Proforma_Service_Creation_PC07  extends Keywords{
	

	
	public void Proforma_Service_Creation_PC07(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		
//	Get data from excel sheet
		String tc_name="TC_Proforma_Service_Creation_PC07";

		
		
		
       
		String Username = Excel_data.get("Username");
        String Password = Excel_data.get("Password");
        String ModuleSearch = Excel_data.get("Module_Search");
        String service_Code = Excel_data.get("Service_Code");
        String noOfTimeAdd = Excel_data.get("NoOfPortsAdd");
        String proformaCode = Excel_data.get("ProformaCode");
        String portCodeEdit = Excel_data.get("PortCodeEdit");
        String bufferTimeEdit = Excel_data.get("BufferTimeEdit");
        String boundEdit = Excel_data.get("BoundEdit");
        String timeZoneEdit = Excel_data.get("TimeZoneEdit");
        String addRowPortCode = Excel_data.get("AddRowPortCode");
		String terminalCodeEdit = Excel_data.get("TerminalCodeEdit");
		String remarks = Excel_data.get("Remarks");
		String proformaSavedPopup = Excel_data.get("ProformaSavedPopup");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String proformaCode_Search_Header = Excel_data.get("ProformaCode_Search_Header");
		String terminalCode_Search_Header = Excel_data.get("TerminalCode_Search_Header");

		Extent_Start(tc_name, test, test1);

        navigateUrl(driver, url);
        
//	Login
        
        LRP_Login(driver, Username, Password);
		
  		moduleNavigate(driver, ModuleSearch);
		
//	Proforma service creation	
		
		Step_Start(1, "Click on new button ", test, test1);
		newButton(driver);
		
		Step_End(1, "Click on new button ", test, test1);
		

		waitForElement(driver, service_Search_Icon_Psc);
		click(driver, service_Search_Icon_Psc);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, service_Code);
		
		waitForElement(driver, remark_field);
		click(driver, remark_field);
		waitForElement(driver, remark_field);
		sendKeys(driver, remark_field, remarks);

//  Quick Proforma
		
		Step_Start(2, ".Click on Quick Proforma", test, test1);
		
		waitForElement(driver, quickproforma);
	    click(driver,quickproforma);
	    Step_End(2, ".Click on Quick Proforma", test, test1);
		
		Step_Start(3, "Click on Import proforma ", test, test1);
		
		waitForDisplay(driver, Importproforma_Button);
		if(isdisplayed(driver,Importproforma_Button)) {
			Extent_pass_New(driver, "Passed || Expected : Quick profoma page should be opened || Actual : Quick profoma page is opened", test, test1);
			System.out.println("Passed || Expected : Quick profoma page should be opened || Actual : Quick profoma page is opened");
		}else {
			System.out.println("Failed || Expected : Quick profoma page should be opened || Actual : Quick profoma page is not opened");

			Extent_fail(driver, "Failed || Expected : Quick profoma page should be opened || Actual : Quick profoma page is not opened", test, test1);
		}
		
		 waitForDisplay(driver, Proforma_Temp_Remove);
			if(isdisplayed(driver, Proforma_Temp_Remove)){
				waitForElement(driver, Proforma_Temp_Remove);
				click(driver, Proforma_Temp_Remove);
			}
		
		waitForElement(driver, Importproforma_Button);
		click(driver, Importproforma_Button);
		Step_End(3, "Click on Import proforma ", test, test1);
//  Import Proforma tab		

//	Search by Proforma code
		Step_Start(4, "Choose any existing proforma rotation which has to be replicated again", test, test1);
		
		twoColumnSearchWindow(driver, proformaCode_Search_Header, condition, proformaCode);

	    Step_End(4, "Choose any existing proforma rotation which has to be replicated again", test, test1);
		
//	Add Multiple Port codes
		   Step_Start(5, "Edit the data if needed ", test, test1);

		 int j=Integer.parseInt(noOfTimeAdd);
		    for(int i=1;i<=j;i++) {
				waitForElement(driver, quickproforma_portcode);

				String portCode = Excel_data.get("PortCode" + i);

				waitForElement(driver, quickproforma_portcode);
				sendKeys(driver, quickproforma_portcode, portCode);
				waitForElement(driver, port_Code_Panel);
				click(driver, port_Code_Panel);
				waitForElement(driver, quickproforma_portcode);
				clear(driver, quickproforma_portcode);
		    }
		   
//	Edit Rows	    
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

			waitForElement(driver, bufferTime_Row);
			String updatedPortcode5 = String.format(updated_Portcode, portCodeEdit);
			
			String updated_Portcode_New = getText(driver, updatedPortcode5);
			System.out.println("updated_Portcode:" + updated_Portcode_New);

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

			waitForElement(driver, terminalCode_Row1);
			click(driver, terminalCode_Row1);
			
			twoColumnSearchWindow(driver, terminalCode_Search_Header, condition, terminalCodeEdit);

			waitForElement(driver, moveUp_Row);
			click(driver, moveUp_Row);
			waitForElement(driver, moveUp_Row);
			Extent_pass_New(driver, "The row has moved up", test, test1);

			waitForElement(driver, moveDown_Row);
			click(driver, moveDown_Row);
			waitForElement(driver, moveDown_Row);
			Extent_pass_New(driver, "The row has moved down", test, test1);

		   waitForElement(driver, editRow1);
		   click(driver, editRow1);	
		    
			waitForElement(driver,  quickproforma_portcode);
		    clear(driver,quickproforma_portcode);
			waitForElement(driver,  quickproforma_portcode);
		    sendKeys(driver, quickproforma_portcode, addRowPortCode);
		    waitForElement(driver,  quickproforma_portcode);
		    waitForElement(driver, port_Code_Panel);
		    click(driver, port_Code_Panel);
		    
		   waitForElement(driver, addedRowPortCode);
		   doubleClick(driver, addedRowPortCode);
		   Extent_pass_New(driver, "Rows in Quick proforma", test, test1);

//	Port codes in Quick proforma 
		   waitForElement(driver, quickProforma_Ok_Button);

		   ArrayList<String> qproPorts=new ArrayList<String>();
		   
		   
			   List <WebElement>  quickProforma_Rows= listOfElements(driver, quickProformaRows);
			   int size=quickProforma_Rows.size();
	   
			   for(int i=1;i<size;i+=2) {
				  String qport_List=String.format(qpPort, i);
				  waitForElement(driver, qport_List);
				   String qport_New_list = getText(driver, qport_List);
				   qproPorts.add(qport_New_list);
			   }
			   
		  
		   Step_End(5, "Edit the data if needed ", test, test1);
		   
		  // System.out.println("qproPorts:"+qproPorts);
		   	   Step_Start(6, "Click on ok", test, test1);
		   	   
		   waitForElement(driver, quickProforma_Ok_Button);
		   click(driver, quickProforma_Ok_Button);
		   
	Step_End(6, "Click on ok", test, test1);
//	Port codes in Proforma
		   Step_Start(7, "Now the data should be added to the maingrid", test, test1);
		   
		   waitForElement(driver, SaveButton_ToolBar);
		   ArrayList<String> proPorts=new ArrayList<String>();
		   
			   List<WebElement> proformarows_List = listOfElements(driver, proformaRows);
			   
			   for(WebElement quickProformaList:proformarows_List) {
				   String proPortsList=quickProformaList.getText();
				   proPorts.add(proPortsList);  
				   
			   }		   

		   if(proPorts.equals(qproPorts)) {
			   Extent_pass_New(driver, "Matched || Port Codes in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
			   System.out.println("Matched || Port Codes in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);
		   }else {
			   System.out.println("Not Matched || Port Codes in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);

			   Extent_fail(driver, "Not Matched || Port Codes in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
		   }
		   Step_End(7, "Now the data should be added to the maingrid", test, test1);

		   scrollTop(driver);
		   waitForElement(driver, SaveButton_ToolBar);
		   click(driver,SaveButton_ToolBar);

//	Verify the proforma service creation popup

		   waitForPopup(driver, popup_Message, proformaSavedPopup);
			String actualUpdatedPopup = getText(driver, popup_Message);

			if (actualUpdatedPopup.equals(proformaSavedPopup)) {
				Extent_pass_New(driver, "Matched || Expected :"+proformaSavedPopup+" || Actual :"+actualUpdatedPopup, test,test1);
				System.out.println("Matched || Expected :"+proformaSavedPopup+" || Actual :"+actualUpdatedPopup);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected :"+proformaSavedPopup+" || Actual :"+actualUpdatedPopup);
				Extent_fail(driver, "Not Matched || Expected :"+proformaSavedPopup+" || Actual :"+actualUpdatedPopup, test,test1);
			}
			
			Extent_completed(tc_name, test, test1);
			
	    } 
	    } 


