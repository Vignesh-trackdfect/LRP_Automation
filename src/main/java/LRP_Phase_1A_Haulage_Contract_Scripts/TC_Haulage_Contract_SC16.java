package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC16 extends Keywords{
	public void Haulage_Contract_SC16(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC16";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String condition = Excel_data.get("condition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Haulage_Feeder_Module_Name = Excel_data.get("Haulage_Feeder_Module_Name");



		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		Step_Start(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		moduleNavigate(driver, Haulage_Contract_Module_Name);
		
		Step_End(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);
	
		waitForElement(driver, Vendor_Search_Button);
		click(driver, Vendor_Search_Button);
		
		
		twoColumnMultipleSearchWindow(driver, Vendor_Code_Header, condition, Vendor_Code);
		
		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);

		Step_Start(3, "Click on the \"+\" Button to add the all details ", test, test1);
		waitForElement(driver, HC_Plus_Button);
		click(driver, HC_Plus_Button);
		
		Step_End(3, "Click on the \"+\" Button to add the all details ", test, test1);
		
		
		Step_Start(4, "It show the Haulage Contract input details page", test, test1);
		waitForDisplay(driver, HC_Haulage_Contract_Input_Page);
		if(isdisplayed(driver, HC_Haulage_Contract_Input_Page)) {
			System.out.println("Matched||Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ");
			Extent_pass_New(driver, "Matched||Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ", test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ");
		    Extent_fail(driver, "NotMatched||Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ", test, test1);
		}
		
		Step_End(4, "It show the Haulage Contract input details page", test, test1);
		
		Step_Start(5, "While choose Pick and drop term should be present in the Haulage/Feeder term master.", test, test1);
		
		waitForElement(driver, HC_Pickup_Term_List);
		click(driver, HC_Pickup_Term_List);
		
		waitForElement(driver, HC_Pickup_Term_List_Inside);
		String[] values = splitXpath(HC_Pickup_Term_List_Inside);
		List<WebElement> elements = driver.findElements(By.xpath(values[1]));
		List<String> textvalues = new ArrayList<String>();
		List<String> SplitValue = new ArrayList<String>();
		
//		for (WebElement element : elements) {
		for (int i=1; i<elements.size(); i++) {
		    String text = elements.get(i).getText();
		    textvalues.add(text);

		    // Split the text by "(" and store only the first part (or full as needed)
		    String[] split = text.split("\\(");
		    if (split.length > 0) {
		    	SplitValue.add(split[0].trim());  // Add the part before '('
		    } else {
		    	SplitValue.add(text);  // Fallback if no '(' is found
		    }
		}
		
		System.out.println("Pick up Term : "+textvalues);
		System.out.println("Splited Pick up Term : "+SplitValue);
		
		
		List<WebElement> pickup_Type_Value_Actual = listOfElements(driver, HC_Pickup_Term_List_Inside);
		
		
		
		  System.out.println(pickup_Type_Value_Actual);
		  
		  
		  waitForElement(driver, HC_Drop_Term_List);
			click(driver, HC_Drop_Term_List);
			
			waitForElement(driver, HC_Drop_Term_List_Inside);
			String[] values1 = splitXpath(HC_Drop_Term_List_Inside);
			List<WebElement> elements1 = driver.findElements(By.xpath(values1[1]));
			List<String> textvalues1 = new ArrayList<String>();
			
//			for(WebElement element:elements1) {
			for(int i =1; i<elements1.size(); i++) {
				
				String text = elements1.get(i).getText();
				textvalues1.add(text);
			}
			
			System.out.println("Pick up Term : "+textvalues1);
			
			
			
			
			
			
			List<WebElement> Droup_Type_Value_Actual = listOfElements(driver, HC_Drop_Term_List_Inside);
			
			
			
			  System.out.println(Droup_Type_Value_Actual);
			  

         
         if(textvalues.equals(textvalues1)) {
        	 System.out.println("Matched||Expected Value taken Pickup term Droup Down :"+textvalues + " ||Actual Value taken Droup term Droup Down: "+textvalues1);
        	 Extent_pass_New(driver, "Matched||Expected Value taken Pickup term Droup Down:"+textvalues + "|| Actual Value taken Droup term Droup Down  : "+textvalues1, test, test1);
         }else {
        	 System.out.println("NotMatched||Expected Value taken Pickup term Droup Down:"+textvalues + "||Actual Value taken Droup term Droup Down  : "+textvalues1);
        	 Extent_fail(driver, "NotMatched||Expected Value taken Pickup term Droup Down :"+textvalues + " ||Actual Value taken Droup term Droup Down: "+textvalues1, test, test1);
         }
         
         waitForElement(driver, HC_Tab_Close);
			click(driver, HC_Tab_Close);
		
         
         
         moduleNavigate(driver, Haulage_Feeder_Module_Name);
         
         
         
			List<WebElement> Contract_Value = listOfElements(driver, HC_Contract_Team_Gird);
			List<String> blackText = new ArrayList<String>();
			List<String> redText = new ArrayList<String>();

			for (WebElement Contract_Value1 : Contract_Value) {

				String text = Contract_Value1.getText();
				String color = Contract_Value1.getCssValue("color");

				String hexcolor = rgbToHex(color);

				if ("#000000".equals(hexcolor)) {
					blackText.add(text);
				} else if ("#FF0000".equals(hexcolor)) {
					redText.add(text);
				}
			}
			
			System.out.println("Black texts : "+blackText);
			System.out.println("Red texts : "+redText);
			
			
			
			

			List<String> notFound = new ArrayList<>();

			for (String blackVal : blackText) {
			    boolean matchFound = false;

			    for (String splitVal : SplitValue) {
			        if (blackVal.equalsIgnoreCase(splitVal)) {
			            matchFound = true;
			            break;
			        }
			    }

			    if (!matchFound) {
			        notFound.add(blackVal); // case-insensitive no match
			    }
			}

			if (notFound.isEmpty()) {
			    System.out.println("✅ All blackText values are found in SplitValue (ignore case).");
			    Extent_pass_New(driver, "✅ All blackText values are found in SplitValue", test, test1);
			} else {
			    System.out.println("❌ These blackText values are NOT in SplitValue (ignore case): " + notFound);
			    Extent_fail(driver, "❌ These blackText values are NOT in SplitValue", test, test1);

			}
			Step_End(5, "While choose Pick and drop term should be present in the Haulage/Feeder term master.", test, test1);
         Extent_completed(testcase_Name, test, test1);
		
	}

}
