package LRP_Arrival_Notice_Scripts;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;




public class TC_Arrival_Notice_TS_043  extends Keywords{
	
	public void Arrival_Notice_TS_043(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{
		

		String testcase_Name="TC_Arrival_Notice_TS_043";
		
		
		


		
		
		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String Field_Names =Excel_data.get("Arrival_Module_Search");
		String Service_Code =Excel_data.get("Service_Code");
		String Veesels =Excel_data.get("Veesels");
		String Voyage =Excel_data.get("Voyage");
	    String Bound =Excel_data.get("Bound");
		String Port_code =Excel_data.get("Port_code");
		String Terminal =Excel_data.get("Terminal");
		

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		//Login
			LRP_Login(driver, username, pass_word);

		//Switch User

		Step_Start(1, " Switch the agency ", test, test1);
		
		SwitchProfile(driver, agencyUser);


		Step_End(1, " Switch the agency ", test, test1);
		Step_Start(2, "open \"Arrival Notice / Freight Memo\" screen ", test, test1);

		
		
		moduleNavigate(driver, Field_Names);

		Step_End(2, "open \"Arrival Notice / Freight Memo\" screen ", test, test1);
		Step_Start(3, "Click search button ", test, test1);
	newButton(driver);
		waitForElement(driver, by_vessels_click);
		click(driver,by_vessels_click);
		Step_End(3, "Click search button ", test, test1);
		Step_Start(4, "Enter the respective service,vessel and voyage and click search and fetch the records", test, test1);
		waitForElement(driver, discharge_Service_TF_AN);
		sendKeys(driver, discharge_Service_TF_AN, Service_Code);

		waitForElement(driver, overlay_Service_Code_Txtfield);
		sendKeys(driver, overlay_Service_Code_Txtfield, Service_Code);
		
		waitForElement(driver, overlay_Vessel_Code_Txtfield);
		sendKeys(driver, overlay_Vessel_Code_Txtfield, Veesels);
		
		waitForElement(driver, overlay_Voyage_Code_Txtfield);
		sendKeys(driver, overlay_Voyage_Code_Txtfield, Voyage);
		waitForElement(driver, Bound_input);
		sendKeys(driver, Bound_input, Bound);
		waitForElement(driver, AN_port_code_input);
		sendKeys(driver, AN_port_code_input, Port_code);
		waitForElement(driver, AN_terminal_code_input);
		sendKeys(driver, AN_terminal_code_input, Terminal);
		waitForElement(driver, AN_Select_grid);
		click(driver, AN_Select_grid);
		Step_End(4, "Enter the respective service,vessel and voyage and click search and fetch the records", test, test1);
		Step_Start(5, "Click the AG grid option (New pop up window will be opened )", test, test1);
		waitForElement(driver, by_customer_show);
		click(driver, by_customer_show);
		
		waitForElement(driver, total_records);
		String totalRecords = getText(driver, total_records);
		int number = Integer.parseInt(totalRecords);
		List<String> namelist= new ArrayList<>();
		int size =0; 
		for(int i=0;i<number;i++) {
				String movementcode =  String.format(bl_list,i);
				String movement_Code_text = getTextwithoutfail(driver, movementcode);
				namelist.add(movement_Code_text);
				size++;
				mouseOverToElement(driver, movementcode);
				click(driver, movementcode);
		}	 



    	Step_End(5, "Click the AG grid option (New pop up window will be opened )", test, test1);

System.out.println(namelist);
		
		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		
		Step_Start(6, "Select the Excel icon (Make sure excel has to download in system ) )", test, test1);
		waitForElement(driver, excel_click);
		String downlaoad_Path = downloadFile(driver, excel_click);
		Step_End(6, "Select the Excel icon (Make sure excel has to download in system ) )", test, test1);
		int row_Count = countNonEmptyRows(downlaoad_Path);
		int row_Count_Without_Header = row_Count-1;
	
	
		if (size==row_Count_Without_Header) {
			Extent_pass(driver, "Matched || Expected Total BL Number Count in Arrival notice : " + size + " || Actual Excel Total Records count  : " + row_Count_Without_Header, test, test1);
			System.out.println("Matched || Expected Total BL Number Count in the Arrival notice : " + size + " || Actual Excel Total Records count  : " + row_Count_Without_Header);
		} else {
			System.out.println("Not Matched || Expected Total BL Number Count in the Arrival notice : " + size + " || Actual Excel Total Records count  : " + row_Count_Without_Header);
			Extent_fail(driver, "Not Matched || Expected Total BL Number Count in the Arrival notice : " + size + " || Actual Excel Total Records count  : " + row_Count_Without_Header, test,
					test1);
		}
		Step_Start(7, "Open excel and Copy the Bls match with arrival notice screen.", test, test1);
	
		List<String> headervalue = getColumnValuesByHeader(downlaoad_Path, "BL Number");
		System.out.println(headervalue);
	
	
	
		if (namelist.equals(headervalue)) {
			Extent_pass(driver, "Matched || Expected Total BL Number Count in the Arrival notice : " + namelist + " || Actual Excel Total Records count : " + headervalue, test, test1);
			System.out.println("Matched || Expected Total BL Number Count in the Arrival notice : " + namelist + " || Actual Excel Total Records count : " + headervalue);
		} else {
			System.out.println("Not Matched || Expected Total BL Number Count in the Arrival notice : " + namelist + " || Actual Excel Total Records count : " + headervalue);
			Extent_fail(driver, "Not Matched || Expected Total BL Number Count in the Arrival notice : " + namelist + " || Actual Excel Total Records count : " + headervalue, test,
					test1);
		}
	
		Step_End(7, "Open excel and Copy the Bls match with arrival notice screen.", test, test1);
		
	Extent_completed(testcase_Name, test, test1);

	}
}
