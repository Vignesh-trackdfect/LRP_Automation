package LRP_VSS_Proforma_Service_Creation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Proforma_Service_Creation_PC06 extends Keywords {

	public void Proforma_Service_Creation_PC06(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

//		Get data from excel sheet
		String tc_name="TC_Proforma_Service_Creation_PC06";

		
		

		String Username = Excel_data.get("Username");
        String Password = Excel_data.get("Password");
        String ModuleSearch = Excel_data.get("Module_Search");
        String excelFilePath = Excel_data.get("ExcelFilePath");
        String remarks = Excel_data.get("Remarks");
        String rowNumberToRemove = Excel_data.get("RowNumberToRemove");
        String Service_Filter_Data = Excel_data.get("Service_Filter_Data");
        String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");

		
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
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, Service_Filter_Data);

		waitForElement(driver, remark_field);
		click(driver, remark_field);
		waitForElement(driver, remark_field);
		sendKeys(driver, remark_field, remarks);
		
//	Import From Excel
		
		Step_Start(2, "CLick on Import Excel Icon", test, test1);
		 waitForDisplay(driver, Proforma_Temp_Remove);
			if(isdisplayed(driver, Proforma_Temp_Remove)){
				waitForElement(driver, Proforma_Temp_Remove);
				click(driver, Proforma_Temp_Remove);
			}
		
		waitForElement(driver, Importexcelbtn);
		click(driver, Importexcelbtn);
		Step_End(2, "CLick on Import Excel Icon", test, test1);
		waitForElement(driver, Importexcelbtn);

		Step_Start(3, "Upload the Required file ", test, test1);
		
		waitForElement(driver, Loadexcelfile);
		
		uploadfile1(driver,PC_Upload_Excel,excelFilePath);
		
		waitForDisplay(driver, excelDetails_Table);
		if(isdisplayed(driver,excelDetails_Table)) {
			Extent_pass_New(driver, "Passed || Expected : Excel file should be uploaded || Actual : Excel file is uploaded", test, test1);
			System.out.println("Passed || Expected : Excel file should be uploaded || Actual : Excel file is uploaded");
		}else {
			System.out.println("Failed || Expected : Excel file should be uploaded || Actual : Excel file is not uploaded");

			Extent_fail(driver, "Failed || Expected : Excel file should be uploaded || Actual : Excel file is not uploaded", test, test1);
		}
		Step_End(3, "Upload the Required file ", test, test1);
		
//	Remove unwanted rows
		
Step_Start(4, "Remove the unwanted rows if needed ", test, test1);

//  Before remove
		int beforeCount=0;
		
		 List<WebElement> beforeRemove = listOfElements(driver, beforeAndAfterRemove);
			
			beforeCount=beforeRemove.size();
		
			String select_Row=String.format(select_Row_ImportExcel_SPF,rowNumberToRemove);
			
		scrollUsingElement(driver, select_Row);
		
		waitForElement(driver, select_Row);		
		click(driver, select_Row);

		waitForElement(driver, Loadexcelfileremovecoloum);
		mouseOverToElement(driver, Loadexcelfileremovecoloum);
		waitForElement(driver, Loadexcelfileremovecoloum);
		click(driver, Loadexcelfileremovecoloum);
	//  After remove
	
		waitForElement(driver, beforeAndAfterRemove);		
		int afterCount=0;
		
			List<WebElement> afterRemove = listOfElements(driver, beforeAndAfterRemove);
		
		afterCount=afterRemove.size();
		
		
		if (afterCount!=beforeCount) {
			System.out.println("Not Matched || Number Of Rows Before Remove : "+beforeCount+" || Number Of Rows After Remove : "+afterCount);
			Extent_pass_New(driver, "Not Matched || Number Of Rows Before Remove : "+beforeCount+" || Number Of Rows After Remove : "+afterCount, test, test1);
			Extent_pass_New(driver, "The selected row was removed", test,test1);
			System.out.println("The selected row was removed");
		} else {
			System.out.println("Matched || Number Of Rows Before Remove : "+beforeCount+" || Number Of Rows After Remove : "+afterCount);
			Extent_fail(driver, "Matched || Number Of Rows Before Remove : "+beforeCount+" || Number Of Rows After Remove : "+afterCount, test, test1);
			
		}
		
		
Step_End(4, "Remove the unwanted rows if needed ", test, test1);

//	No of ports in Import from excel tab 

		
		ArrayList<String> impPorts=new ArrayList<String>();
		
			List<WebElement> xlRow_List = listOfElements(driver, xlRow);
			for(WebElement xlPorts:xlRow_List ) {
				 
				String xlImpPorts=xlPorts.getText();
				impPorts.add(xlImpPorts);
			}
			
		Step_Start(5, "Click on ok button", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, Loadexcelfileselect1ok);
		click(driver, Loadexcelfileselect1ok);
		Step_End(5, "Click on ok button", test, test1);

//	No of ports in proforma 		
		Step_Start(6, "Now the Excel Data will be added in the main grid", test, test1);
		waitForElement(driver, NewButton_ToolBar);
		   ArrayList<String> proPorts=new ArrayList<String>();
		   
			   List<WebElement> proformaRows_List = listOfElements(driver, proformaRows);
			   for(WebElement quickProformaList:proformaRows_List) {
				   
				   String proPortsList=quickProformaList.getText();
				   proPorts.add(proPortsList);  
				   
			   }		   

		   if(proPorts.equals(impPorts)) {
			   Extent_pass_New(driver, "Matched || Ports in Import From Excel grid : "+impPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
			   System.out.println("Matched || Ports in Import From Excel grid : "+impPorts +" || Ports in Proforma grid : "+proPorts);
		   }else {
			   System.out.println("Not Matched || Ports in Import From Excel grid : "+impPorts +" || Ports in Proforma grid : "+proPorts);

			   Extent_fail(driver, "Not Matched || Ports in Import From Excel grid : "+impPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
		   }
		   
		   Step_End(6, "Now the Excel Data will be added in the main grid", test, test1);
			Extent_completed(tc_name, test, test1);

	}

}
