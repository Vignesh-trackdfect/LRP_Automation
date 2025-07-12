package LRP_End_To_End_Script;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Testcases;
import commonMethods.Utils;

public class TC_End_To_End_SC001 extends Keywords {
	public void End_To_End_SC001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {
		String tc_Name = "TC_End_To_End_SC001";
		Extent_Start(tc_Name, test, test1);
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		Map<String, String> END_TO_END_Excel_data = Utils.getDataAsMap(Testcases.Testdata_Excel,"E2E_Flow", tc_Name, Testcases.dataSet);
		
		String Perform_Service_Creation_Module = END_TO_END_Excel_data.get("Perform_Service_Creation_Module");
		String Perform_ProformaService_Creation_Module = END_TO_END_Excel_data.get("Perform_ProformaService_Creation_Module");
		String Perform_Longterm_Creation_Module = END_TO_END_Excel_data.get("Perform_Longterm_Creation_Module");
		String Perform_Schedule_Security_Module = END_TO_END_Excel_data.get("Perform_Schedule_Security_Module");
		String Perform_Customer_Master_Module = END_TO_END_Excel_data.get("Perform_Customer_Master_Module");
		String Perform_Routing_Module = END_TO_END_Excel_data.get("Perform_Routing_Module");
		String Perform_Rate_Request_Module = END_TO_END_Excel_data.get("Perform_Rate_Request_Module");
		String Perform_Movement_Entry_Module = END_TO_END_Excel_data.get("Perform_Movement_Entry_Module");
		String Perform_Booking_Module = END_TO_END_Excel_data.get("Perform_Booking_Module");
		String Perform_Load_Confirmation_Module = END_TO_END_Excel_data.get("Perform_Load_Confirmation_Module");
		String Perform_Discharge_Confirmation_Module = END_TO_END_Excel_data.get("Perform_Discharge_Confirmation_Module");
		String Perform_Manifest_Closure_Module = END_TO_END_Excel_data.get("Perform_Manifest_Closure_Module");
		String Perform_Discharge_Reconciliation_Module = END_TO_END_Excel_data.get("Perform_Discharge_Reconciliation_Module");
		String Perform_Arrival_Notice_Module = END_TO_END_Excel_data.get("Perform_Arrival_Notice_Module");
		String Perform_Delivery_Order_Module = END_TO_END_Excel_data.get("Perform_Delivery_Order_Module");
		String Movement_Entry_Option = END_TO_END_Excel_data.get("Movement_Entry_Option");
		String Value_Taken_From_E2E = END_TO_END_Excel_data.get("Value_Taken_From_E2E");
		Excel_data.put("Value_Taken_From_E2E", Value_Taken_From_E2E);
		navigateUrl(driver, url);
		// Login
		LRP_Login(driver, Username, Password);
		if (Perform_Service_Creation_Module.equalsIgnoreCase("Yes")) {
			TC_Service_Creation_SC01 sc = new TC_Service_Creation_SC01();
			sc.Service_Creation_SC01(driver, test, test1, selected_dataset, Excel_data, url);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if (Perform_ProformaService_Creation_Module.equalsIgnoreCase("Yes")) {
			TC_Proforma_Service_Creation_PC01 psc = new TC_Proforma_Service_Creation_PC01();
			psc.Proforma_Service_Creation_PC01(driver, test, test1, selected_dataset, Excel_data, url);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if (Perform_Longterm_Creation_Module.equalsIgnoreCase("Yes")) {
			TC_Long_Term_Creation_LT01 lt = new TC_Long_Term_Creation_LT01();
			lt.Long_Term_Creation_LT01(driver, test, test1, selected_dataset, Excel_data, url);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if (Perform_Schedule_Security_Module.equalsIgnoreCase("Yes")) {
			TC_Schedule_Security_SS01 ss = new TC_Schedule_Security_SS01();
			ss.Schedule_Security_SS01(driver, test, test1, selected_dataset, Excel_data, url);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if (Perform_Customer_Master_Module.equalsIgnoreCase("Yes")) {
			TC_Customer_Master_Creation_SC01 cm = new TC_Customer_Master_Creation_SC01();
			cm.Customer_Master_Creation_SC01(driver, test, test1, selected_dataset, Excel_data, url);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if (Perform_Routing_Module.equalsIgnoreCase("Yes")) {
			TC_Routing_SC001 route = new TC_Routing_SC001();
			route.Routing_SC001(driver, test, test1, selected_dataset, Excel_data, url);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if (Perform_Rate_Request_Module.equalsIgnoreCase("Yes")) {
			TC_Rate_Request_SC38 Tc_S_RR = new TC_Rate_Request_SC38();
			Tc_S_RR.Rate_Request_SC38(driver, test, test1, selected_dataset, Excel_data, url);
			scrollTop(driver);
			waitForElement(driver, Srr_no);
			String Srrno = getAttribute(driver, Srr_no, "value");
			Excel_data.put("Srr_Number", Srrno);
			Utils.writeOrUpdateExcelValue(Testcases.File_Path,Testcases.Sheet_Name,Testcases.TestCaseName,Testcases.dataSet, "Srr_Number",Srrno);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if (Perform_Movement_Entry_Module.equalsIgnoreCase("Yes")) {
			if (Movement_Entry_Option.equalsIgnoreCase("Single")) {
				TC_Movement_Entry_TS_015 me = new TC_Movement_Entry_TS_015();
				me.Movement_Entry_TS_015(driver, test, test1, selected_dataset, Excel_data, url);
				scrollTop(driver);
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			}
			if (Movement_Entry_Option.equalsIgnoreCase("Multiple")) {
				TC_Movement_Entry_TS_016 me = new TC_Movement_Entry_TS_016();
				me.Movement_Entry_TS_016(driver, test, test1, selected_dataset, Excel_data, url);
				scrollTop(driver);
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			}
		}
		if (Perform_Booking_Module.equalsIgnoreCase("Yes")) {
			TC_Booking_SC030 booking = new TC_Booking_SC030();
			booking.Booking_SC030(driver, test, test1, selected_dataset, Excel_data, url);
		}
		if (Perform_Load_Confirmation_Module.equalsIgnoreCase("Yes")) {
			TC_Load_Confirmation_SC_LC_01 lc = new TC_Load_Confirmation_SC_LC_01();
			lc.Load_Confirmation_SC_LC_01(driver, test, test1, selected_dataset, Excel_data, url);
		}
		if (Perform_Discharge_Confirmation_Module.equalsIgnoreCase("Yes")) {
			TC_Discharge_Confirmation_SC_DC_01 dc = new TC_Discharge_Confirmation_SC_DC_01();
			dc.Discharge_Confirmation_SC_DC_01(driver, test, test1, selected_dataset, Excel_data, url);
		}
		if (Perform_Manifest_Closure_Module.equalsIgnoreCase("Yes")) {
			TC_MCF_SC001 mcf = new TC_MCF_SC001();
			mcf.MCF_SC001(driver, test, test1, selected_dataset, Excel_data, url);
		}
		if (Perform_Discharge_Reconciliation_Module.equalsIgnoreCase("Yes")) {
			TC_Import_Documentation_SC004 imd = new TC_Import_Documentation_SC004();
			imd.Import_Documentation_SC004(driver, test, test1, selected_dataset, Excel_data, url);
		}
		if (Perform_Arrival_Notice_Module.equalsIgnoreCase("Yes")) {
			TC_Arrival_Notice_TS_011 an = new TC_Arrival_Notice_TS_011();
			an.Arrival_Notice_TS_011(driver, test, test1, selected_dataset, Excel_data, url);
		}

		if (Perform_Delivery_Order_Module.equalsIgnoreCase("Yes")) {
			TC_Delivery_Order_TS_002 do02 = new TC_Delivery_Order_TS_002();
			do02.Delivery_Order_TS_002(driver, test, test1, selected_dataset, Excel_data, url);
		}
		Extent_completed(tc_Name, test, test1);
	}
}
