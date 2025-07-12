package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD27 extends Keywords {
	
public void Discharge_Reconciliation_MD27(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Discharge_Reconciliation_MD27";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Service_Header = Excel_data.get("Service_Header");
		String Plan_Input = Excel_data.get("Plan_Type");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		
		
		
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);	

		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver ,url);
		
		LRP_Login(driver, Username, Password);
		
		Step_Start(1,"Switch to agency",test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency",test, test1);

		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);
		moduleNavigate(driver, Dis_Recon_Module);
		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on New Button", test, test1);
		newButton(driver);
		Step_End(3, "Click on New Button", test, test1);

		Step_Start(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		waitForElement(driver, Service_Option);
		click(driver, Service_Option);
		twoColumnSearchWindow(driver, Service_Header, Filter_Condition, Service_Input);
		
		waitForElement(driver, Vessele_Option);
		click(driver, Vessele_Option);
		twoColumnSearchWindow(driver, Vessel_Header, Filter_Condition, Vessel_Input);
		

		waitForElement(driver, DR_Voyage_Option);
		sendKeys(driver, DR_Voyage_Option, Voyage_Input);

		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);

		if (!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		
		click1(driver,grid_terminal_IMP_DOC);
		sendKeys(driver, grid_terminal_IMP_DOC, Terminal_Input);
		
		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);

		Step_Start(5, " Select the Plan as ALL/Local/Transhipment", test, test1);

		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);

		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);

		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(5, "Select the Plan as ALL/Local/Transhipment", test, test1);

		Step_Start(6, "Click on Download BL Button", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, "Click on Download BL Button", test, test1);
		
		Step_Start(7, "Click on Summary Button", test, test1);
		waitForElement(driver, Show_Summary_Btn_DR);	
		click(driver , Show_Summary_Btn_DR);
		Step_End(7, "Click on Summary Button", test, test1);
		
        Step_Start(8, "Click on non container shipment summary button", test, test1);
		waitForElement(driver, Non_Container_ss_btn);
		click(driver, Non_Container_ss_btn);
		Step_End(8, "Click on non container shipment summary button", test, test1);
		
		Step_Start(9, "Sum all the weight in cargo section and capture it", test, test1);
	        
		
		int j = 0;
		List<String> newValue = new ArrayList<>();
		double totalWeight = 0.0;

		String Cargo_weight = String.format(DR_Cargo_weight, j);

		while (isdisplayed(driver, Cargo_weight)) {
		    mouseOverToElement(driver, Cargo_weight);
		    String Cargo_weight_no = getText(driver, Cargo_weight);

		    if (Cargo_weight_no != null && !Cargo_weight_no.isEmpty()) {
		        newValue.add(Cargo_weight_no);
		        try {
		            // Remove non-numeric characters (like commas, "kg", etc.)
		            String cleanValue = Cargo_weight_no.replaceAll("[^\\d.]", "");
		            totalWeight += Double.parseDouble(cleanValue);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid number format for cargo weight: " + Cargo_weight_no);
		        }
		    }

		    j++;
		    Cargo_weight = String.format(DR_Cargo_weight, j);
		}

		System.out.println("Summed Cargo weight : " + totalWeight);

		
		 Step_End(9, "Sum all the weight in cargo section and capture it", test, test1);
		 
		 Step_Start(10, " Verify that Weight section Weight has Matched with Summed Cargo weight", test, test1); 
		 waitForElement(driver, DR_WT_count);
		 String DR_WT_sum_count =getText(driver, DR_WT_count);
		 
			 
			 if(DR_WT_sum_count.contains(Double.toString(totalWeight))) {
			    System.out.println("Matched || Expected : Weight section Weight has " + DR_WT_sum_count + 
			                       " || Actual : Summed Cargo weight : " + totalWeight);
			    Extent_pass(driver, "Matched || Expected : Weight section Weight has " + DR_WT_sum_count + 
			                " || Actual : Summed Cargo weight : " + totalWeight, test, test1);
			} else {
			    System.out.println("Not Matched || Expected : Weight section Weight has " + DR_WT_sum_count + 
			                       " || Actual : Summed Cargo weight : " + totalWeight);
			    Extent_fail(driver, "Matched || Expected : Weight section Weight has " + DR_WT_sum_count + 
		                " || Actual : Summed Cargo weight : " + totalWeight, test, test1);
			}
		 

		 
		 Step_End(10, " Verify that Weight section Weight has Matched with Summed Cargo weight", test, test1);
		 
		 Extent_completed(testcase_Name, test, test1);
   }
}
