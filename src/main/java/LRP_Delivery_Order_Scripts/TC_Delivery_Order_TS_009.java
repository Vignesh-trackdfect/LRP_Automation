package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_009 extends Keywords{
	public void Delivery_Order_TS_009(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_009";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String globalSearch_Number=Excel_data.get("GlobalSearch_Number");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String status_Filer_Data = Excel_data.get("Status_Filer_Data");
		String globalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String globalSearchFilterOption_IMD = Excel_data.get("GlobalSearchFilterOption_IMD");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		Step_Start(2, "Open Delivery Order module", test, test1);
		//	Delivery Order
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(2, "Open Delivery Order module", test, test1);
		Step_Start(3, "Click the search icon on tool bar.", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(3, "Click the search icon on tool bar.", test, test1);
		Step_Start(4, "Paste the Delivery order number and Click search  fetch the Bl", test, test1);
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
		globalValueSearchWindowScrollAndSelect(driver,status_Filter_DO,status_Filer_Data);
		Step_End(4, "Paste the Delivery order number and Click search  fetch the Bl", test, test1);
		Step_Start(5, "Copy the service,vessel,voyage,bound,port ,terminal and DO issue location.", test, test1);
		waitForElement(driver, DO_Service_Textfield);
		String service_DO=getAttribute(driver, DO_Service_Textfield, "value");
		String vessel_DO=getAttribute(driver, DO_Vessel_Textfield, "value");
		String voyage_DO=getAttribute(driver, DO_Voyage_Textfield, "value");
		String bound_DO=getAttribute(driver, DO_Bound_Textfield, "value");
		String do_Issue_Location_DO=getAttribute(driver, DO_Issue_Location_DO, "value");
		String port_DO=getAttribute(driver, DO_Port_Textfield, "value");
		String terminal_DO=getAttribute(driver, DO_Terminal_Textfield, "value");
		ArrayList<String> serviceDetails_DO=new ArrayList<>();
		serviceDetails_DO.add(service_DO);
		serviceDetails_DO.add(vessel_DO);
		serviceDetails_DO.add(voyage_DO);
		serviceDetails_DO.add(bound_DO);
		serviceDetails_DO.add(port_DO);
		serviceDetails_DO.add(terminal_DO);
		serviceDetails_DO.add(do_Issue_Location_DO);
		Extent_pass_New(driver, "Copied Service details : "+serviceDetails_DO, test, test1);
		Step_End(5, "Copy the service,vessel,voyage,bound,port ,terminal and DO issue location.", test, test1);
		Step_Start(6, "Open import documentation screen", test, test1);
		//	Import Documentation
		moduleNavigate(driver, module_ImportDocumentation);
		Step_End(6, "Open import documentation screen", test, test1);
		Step_Start(7, "Click search button", test, test1);
		waitForElement(driver, SearchButton_Toolbar );
		click(driver, SearchButton_Toolbar);
		Step_End(7, "Click search button", test, test1);
		Step_Start(8, "paste the BL and select the BL", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_IMD, globalSearch_Number, "", "", "", "");
		waitForElement(driver, servicenameImportDoc);
		String service_IMD=getAttribute(driver, servicenameImportDoc, "value");
		String vessel_IMD=getText(driver, vesselCode_ImportDoc);
		String voyage_IMD=getText(driver, voyage_ImportDoc);
		String bound_IMD=getText(driver, bound_ImportDoc);
		String port_IMD=getText(driver, portCode_ImportDoc);
		String terminal_IMD=getText(driver, terminalCode_ImportDoc);
		String do_Issue_Location_IMD=getAttribute(driver, DO_Issue_Location_IMD, "value");
		Step_End(8, "paste the BL and select the BL", test, test1);
		Step_Start(9, "Ensure that service,vessel,voyage,bound,port ,terminal and DO issue location details should be matched from  import documentation screen to Delivery Order\"", test, test1);
		if(service_IMD.equals(service_DO)) {
			Extent_pass_New(driver, "Matched || Service in Import Documentation : "+service_IMD +" || Service in Delivery Order : "+service_DO, test, test1);
			System.out.println("Matched || Service in Import Documentation : "+service_IMD +" || Service in Delivery Order : "+service_DO);
		}else {
			System.out.println("Not Matched || Service in Import Documentation : "+service_IMD +" || Service in Delivery Order : "+service_DO);
			Extent_fail(driver, "Not Matched || Service in Import Documentation : "+service_IMD +" || Service in Delivery Order : "+service_DO, test, test1);
		}
		if(vessel_IMD.equals(vessel_DO)) {
			Extent_pass_New(driver, "Matched || Vessel in Import Documentation : "+vessel_IMD +" || Vessel in Delivery Order : "+vessel_DO, test, test1);
			System.out.println("Matched || Vessel in Import Documentation : "+vessel_IMD +" || Vessel in Delivery Order : "+vessel_DO);
		}else {
			System.out.println("Not Matched || Vessel in Import Documentation : "+vessel_IMD +" || Vessel in Delivery Order : "+vessel_DO);
			Extent_fail(driver, "Not Matched || Vessel in Import Documentation : "+vessel_IMD +" || Vessel in Delivery Order : "+vessel_DO, test, test1);
		}
		if(voyage_IMD.equals(voyage_DO)) {
			Extent_pass_New(driver, "Matched || Voyage in Import Documentation : "+voyage_IMD +" || Voyage in Delivery Order : "+voyage_DO, test, test1);
			System.out.println("Matched || Voyage in Import Documentation : "+voyage_IMD +" || Voyage in Delivery Order : "+voyage_DO);
		}else {
			System.out.println("Not Matched || Voyage in Import Documentation : "+voyage_IMD +" || Voyage in Delivery Order : "+voyage_DO);
			Extent_fail(driver, "Not Matched || Voyage in Import Documentation : "+voyage_IMD +" || Voyage in Delivery Order : "+voyage_DO, test, test1);
		}
		if(bound_IMD.equals(bound_DO)) {
			Extent_pass_New(driver, "Matched || Bound in Import Documentation : "+bound_IMD +" || Bound in Delivery Order : "+bound_DO, test, test1);
			System.out.println("Matched || Bound in Import Documentation : "+bound_IMD +" || Bound in Delivery Order : "+bound_DO);
		}else {
			System.out.println("Not Matched || Bound in Import Documentation : "+bound_IMD +" || Bound in Delivery Order : "+bound_DO);
			Extent_fail(driver, "Not Matched || Bound in Import Documentation : "+bound_IMD +" || Bound in Delivery Order : "+bound_DO, test, test1);
		}
		if(port_IMD.equals(port_DO)) {
			Extent_pass_New(driver, "Matched || Port in Import Documentation : "+port_IMD +" || Port in Delivery Order : "+port_DO, test, test1);
			System.out.println("Matched || Port in Import Documentation : "+port_IMD +" || Port in Delivery Order : "+port_DO);
		}else {
			System.out.println("Not Matched || Port in Import Documentation : "+port_IMD +" || Port in Delivery Order : "+port_DO);
			Extent_fail(driver, "Not Matched || Port in Import Documentation : "+port_IMD +" || Port in Delivery Order : "+port_DO, test, test1);
		}
		if(terminal_IMD.equals(terminal_DO)) {
			Extent_pass_New(driver, "Matched || Terminal in Import Documentation : "+terminal_IMD +" || Terminal in Delivery Order : "+terminal_DO, test, test1);
			System.out.println("Matched || Terminal in Import Documentation : "+terminal_IMD +" || Terminal in Delivery Order : "+terminal_DO);
		}else {
			System.out.println("Not Matched || Terminal in Import Documentation : "+terminal_IMD +" || Terminal in Delivery Order : "+terminal_DO);
			Extent_fail(driver, "Not Matched || Terminal in Import Documentation : "+terminal_IMD +" || Terminal in Delivery Order : "+terminal_DO, test, test1);
		}
		if(do_Issue_Location_IMD.equals(do_Issue_Location_DO)) {
			Extent_pass_New(driver, "Matched || DO Issue Location in Import Documentation : "+do_Issue_Location_IMD +" || DO Issue Location in Delivery Order : "+do_Issue_Location_DO, test, test1);
			System.out.println("Matched || DO Issue Location in Import Documentation : "+do_Issue_Location_IMD +" || DO Issue Location in Delivery Order : "+do_Issue_Location_DO);
		}else {
			System.out.println("Not Matched || DO Issue Location in Import Documentation : "+do_Issue_Location_IMD +" || DO Issue Location in Delivery Order : "+do_Issue_Location_DO);
			Extent_fail(driver, "Not Matched || DO Issue Location in Import Documentation : "+do_Issue_Location_IMD +" || DO Issue Location in Delivery Order : "+do_Issue_Location_DO, test, test1);
		}
		Step_End(9, "Ensure that service,vessel,voyage,bound,port ,terminal and DO issue location details should be matched from  import documentation screen to Delivery Order\"", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}