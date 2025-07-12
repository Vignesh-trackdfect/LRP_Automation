package LRP_Arrival_Notice_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_017 extends Keywords {
	
	public void Arrival_Notice_TS_017(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Arrival_Notice_TS_017";

		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String agencyUser =Excel_data.get("AgencyUser");
		String arrival_Module_Search =Excel_data.get("Arrival_Module_Search");
		String discharge_Service_Data =Excel_data.get("Discharge_Service_Data");
		String service_data =Excel_data.get("Service_data");
		String vessel =Excel_data.get("Vessel");
		String voyage =Excel_data.get("Voyage");
		String bl_Numbers_To_Select =Excel_data.get("Bl_Number's_To_Select");
	
		

		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);


		LRP_Login(driver, username, password);


		Extent_call(test, test1,"**Switch the Profile Start**");

		Step_Start(1, "Select the agency ", test, test1);
		
		SwitchProfile(driver, agencyUser);

		
		Step_End(1, "Select the agency ", test, test1);

		Step_Start(2, ".Search the module name   \"Arrival Notice / Freight Memo\"  in module search", test, test1);

		moduleNavigate(driver, arrival_Module_Search);

		Step_End(2, ".Search the module name   \"Arrival Notice / Freight Memo\"  in module search", test, test1);
newButton(driver);
		
		waitForElement(driver, by_Vessel_AN);
		click(driver, by_Vessel_AN);

		Step_Start(3, " Enter service, vessel voyage details in search option and click search ", test, test1);
		waitForElement(driver, discharge_Srvce_Txtfld_AN);
		sendKeys(driver, discharge_Srvce_Txtfld_AN, discharge_Service_Data);
		waitForElement(driver, overlay_Box);
		sendKeys(driver, overlay_Service_Code_Txtfield, service_data);
		sendKeys(driver, overlay_Vessel_Code_Txtfield, vessel);
		sendKeys(driver, overlay_Voyage_Code_Txtfield, voyage);
		waitForElement(driver, Overlay_panel_First_Click);
		click(driver, Overlay_panel_First_Click);
		waitForElement(driver, Vessel_Select_Btn);
		click(driver, Vessel_Select_Btn);
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		Step_End(3, " Enter service, vessel voyage details in search option and click search ", test, test1);

		
		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		click(driver, condition_Filter_AN);

		List<String> bl_Num_To_Select = splitAndExpand(bl_Numbers_To_Select);
		
		Extent_call(test, test1, "clicking on particular bl_numbers checkbox");
		
			Step_Start(4, "Select the below mentioned Bls and click the Print icon on tool bar ", test, test1);
			for(String bl_Num:bl_Num_To_Select) {
			String click_Chckbox_By_Bl_Number=String.format(Arrival_Notice_Locators.click_Chckbox_By_Bl_Number, bl_Num);
			waitForElement(driver, condition_Filter_AN);
			click(driver, condition_Filter_AN);
			waitForElement(driver, blNumber_Filter_AN);
			clear(driver, blNumber_Filter_AN);
			waitForElement(driver, blNumber_Filter_AN);
			sendKeys(driver, blNumber_Filter_AN, bl_Num);
			waitForElement(driver, blNumber_Filter_AN);
			waitForElement(driver, click_Chckbox_By_Bl_Number);
			mouseOverToElement(driver, click_Chckbox_By_Bl_Number);
			click(driver, click_Chckbox_By_Bl_Number);
		}
			scrollTop(driver);

		waitForElement(driver, print_Btn_Toolbar_AN);
		safeclick(driver, print_Btn_Toolbar_AN);
		Step_End(4, "Select the below mentioned Bls and click the Print icon on tool bar ", test, test1);

		Extent_call(test, test1, "switching to the iframe");
		Step_Start(5, "Ensure that Print page should be open and shown the respective details", test, test1);
		waitForElement(driver, PDF_Viewer);
		switchToFrame(driver, jsp_Iframe);
		waitForElement(driver, form_Total_Pages_AN);
		String pageCount = getText(driver, form_Total_Pages_AN);
int j=0;
		String[] pageCount_Split = pageCount.split(" ");
		int total_Pages_In_Form = Integer.parseInt(pageCount_Split[1]);
		System.out.println("total pages in the form is: " + total_Pages_In_Form);
		for (int i = 1; i <= total_Pages_In_Form; i++) {
			

			if (i % 2 != 0) {
				String jsp_Pages = String.format(Arrival_Notice_Locators.jsp_Form_Page, i);
				String bl_No_Value = String.format(Arrival_Notice_Locators.bl_Number_In_Form, i,bl_Num_To_Select.get(j));
				waitForElement(driver, page_Form_Txtfld);
				doubleClick(driver, page_Form_Txtfld);
				clearAndType1(driver, page_Form_Txtfld,Integer.toString(i));
				enter(driver);
				waitForElement(driver, jsp_Pages);
				scrollUsingElement(driver, jsp_Pages);

				waitForElement(driver, bl_No_Value);
				scrollUsingElement(driver, bl_No_Value);
				String bl_Num_In_Form = getText(driver, bl_No_Value);
				
				  bl_Num_In_Form = bl_Num_In_Form.trim(); // Trim whitespace
				  if(bl_Num_In_Form.contains(":")) {
			        bl_Num_In_Form = bl_Num_In_Form.replace(":", "");//remove colon
				  }
				 boolean matchFound = false; // Flag to indicate if a match is found
				 Step_Start(6, "Scroll the PDF  down and get the BL numbers  from PDF, same requires to match with Arrival Notice screen", test, test1);
	                for (String blNumber : bl_Num_To_Select) {
	                    if (bl_Num_In_Form.equals(blNumber)) {
	                        matchFound = true; // Set flag to true if a match is found
	                        System.out.println("MATCHED || Expected the selected bl numbers are: " + bl_Num_To_Select + " Actual And the number in the form is: " + bl_Num_In_Form);
	                        System.out.println("The searched bl number is present in the form.");
	                        Extent_pass(driver, "MATCHED || Expected the selected bl numbers are: " + bl_Num_To_Select + " Actual And the number in the form is: " + bl_Num_In_Form, test, test1);
	                        break; // Exit the loop once a match is found
	                    }
	                }
	                
					 Step_End(6, "Scroll the PDF  down and get the BL numbers  from PDF, same requires to match with Arrival Notice screen", test, test1);


	                // If no match was found
	                if (!matchFound) {
	                    System.out.println("NOT MATCHED || Expected the selected bl numbers are: " + bl_Num_To_Select + " Actual And the number in the form is: " + bl_Num_In_Form);
	                    System.out.println("The searched bl number is not present in the form.");
	                    Extent_fail(driver, "NOT MATCHED || Expected the selected bl numbers are: " + bl_Num_To_Select + " Actual And the number in the form is: " + bl_Num_In_Form, test, test1);
	                }
			j++;
			}
		}
		
		Step_End(5, "Ensure that Print page should be open and shown the respective details", test, test1);

		
		Extent_completed(testcase_Name, test, test1);

	}
	
	
}
