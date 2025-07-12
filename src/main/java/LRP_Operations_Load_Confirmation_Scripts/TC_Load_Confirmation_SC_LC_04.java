package LRP_Operations_Load_Confirmation_Scripts;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



	public class TC_Load_Confirmation_SC_LC_04 extends Keywords{
				public void Load_Confirmation_SC_LC_04(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
					String testcase_Name="TC_Load_Confirmation_SC_LC_04";
			
			String Username =Excel_data.get("Username");
			String Password =Excel_data.get("Password");
			String AgencyUser =Excel_data.get("AgencyUser");
			String loadConfirmationModule =Excel_data.get("loadConfirmationModule");
			String first_service_data =Excel_data.get("first_service_data");
			String vesselCode =Excel_data.get("vesselCode");
			String Voyagenumber1 =Excel_data.get("Voyagenumber1");
			String Boundinput =Excel_data.get("Boundinput");
			String portCode =Excel_data.get("portCode");
			String terminalCode =Excel_data.get("terminalCode");
			String Container_num = Excel_data.get("Container_num");
			String loadconfirmationpopup_input = Excel_data.get("loadconfirmationpopup");
			String App_Date =Excel_data.get("App_Date");
			String date_Picker =Excel_data.get("date_Picker");

			
			Extent_Start(testcase_Name, test, test1);
			navigateUrl(driver, url);
			
			// Login
			LRP_Login(driver, Username, Password);

//				Switch the Profile
				
					SwitchProfile(driver, AgencyUser);
					
				
					
			// Module search
					Step_Start(1, " Create containerized Booking and capture the book number.", test, test1);

					moduleNavigate(driver, loadConfirmationModule);
				
			
			waitForElement(driver, L_loadConfirmation_Tab);
		
			
			// Search Module
			
			
//		Select service
			
			waitForElement(driver, L_service_Searchfield);
			selectservice(driver, first_service_data, vesselCode, Voyagenumber1, Boundinput, portCode, terminalCode);
			
			waitForElement(driver, L_show_Button);
		    click(driver, L_show_Button);
			
		    
			if(date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, activity_date, App_Date);
				
				}
		    
			waitForElement(driver, AssigningBtn);
			click(driver,AssigningBtn);
			String values = formatValues(Container_num);
			System.out.println(values);

			StringSelection stringSelection = new StringSelection(values);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	        
	        Actions action = new Actions(driver);
	        
	        waitForElement(driver, container_no);
			mouseOverToElement(driver, container_no);
			click(driver, container_no);
			action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
			enter(driver);
			
			waitForElement(driver, match_button);
			click(driver,match_button);
			
			
			waitForElement(driver, L_loadConfirmation_Button);
			click(driver, L_loadConfirmation_Button);
			waitForPopup(driver, popup_Message, loadconfirmationpopup_input);    
			 String SaveRate_PopUp2= getText(driver, popup_Message);
		       
		       
				if(isDisplayed(driver, popup_Message)){
					if(loadconfirmationpopup_input.contains(SaveRate_PopUp2)) {
						System.out.println("Matched || Expected value POPUP was : "+loadconfirmationpopup_input+" || Actual value POPUP was : "+SaveRate_PopUp2);
						Extent_pass_New(driver, "Matched || Expected value POPUP was : "+loadconfirmationpopup_input+" || Actual value POPUP was : "+SaveRate_PopUp2, test, test1);
					}
					else {
						System.out.println("NotMatched || Expected value POPUP was : "+loadconfirmationpopup_input+" || Actual value POPUP was : "+SaveRate_PopUp2);
						Extent_fail(driver,  "NotMatched || Expected value POPUP was : "+loadconfirmationpopup_input+" || Actual value POPUP was : "+SaveRate_PopUp2, test, test1);
					}
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					Extent_completed(testcase_Name, test, test1);
			}
		}
	}