package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC39 extends Keywords{
	public void Haulage_Contract_SC39(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC39";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String condition = Excel_data.get("condition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Pickup_Location_Header = Excel_data.get("Pickup_Location_Header");
		String Pickup_Location_Code = Excel_data.get("Pickup_Location_Code");
		String Drop_Location_Code = Excel_data.get("Drop_Location_Code");
		String Equipment_Type = Excel_data.get("Equipment_Type");
		String HC_LDN_MTY_Value = Excel_data.get("HC_LDN_MTY_Value");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String Pickup_Type_Value = Excel_data.get("Pickup_Type_Value");
		String Drop_Type_Value = Excel_data.get("Drop_Type_Value");
		String Pickup_Term_Value = Excel_data.get("Pickup_Term_Value");
		String Drop_Term_Value = Excel_data.get("Drop_Term_Value");
		String Haulage_mode_Value = Excel_data.get("Haulage_mode_Value");
		String Trip_Type_Value = Excel_data.get("Trip_Type_Value");
		String User_Name_Input = Excel_data.get("User_Name_Input");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Neg_On_Date = Excel_data.get("Neg_On_Date");
		String Amount_Type = Excel_data.get("Amount_Type");
		String Amount_Input = Excel_data.get("Amount_Input");
		String Currency_Select_Input = Excel_data.get("Currency_Select_Input");
		String Currency_Header = Excel_data.get("Currency_Header");
		String Drop_Terminal_Value = Excel_data.get("Drop_Terminal_Value");
		String Drop_Terminal_Header = Excel_data.get("Drop_Terminal_Header");
		String Pickup_Terminal_Value = Excel_data.get("Pickup_Terminal_Value");
		String Pickup_Terminal_Header = Excel_data.get("Pickup_Terminal_Header");
		String Surcharge_Add_Value = Excel_data.get("Surcharge_Add_Value");
		String Surcharge_code_Header = Excel_data.get("Surcharge_code_Header");
		String remove_popup = Excel_data.get("remove_popup");
		String Amount_Edit_Value = Excel_data.get("Amount_Edit_Value");

	



		
		
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
		
		

		
		Step_Start(18, "Fill the all mandadory details ", test, test1);
		 Step_Start(4, " Click the Pickup Loc search field and select the Pick up location", test, test1);
		waitForElement(driver, HC_Pickup_Location_Search_Button);
		click(driver, HC_Pickup_Location_Search_Button);
		twoColumnMultipleSearchWindow(driver, Pickup_Location_Header, condition, Pickup_Location_Code);
	
		waitForElement(driver, HC_Drop_Location_Search_Button);
		click(driver, HC_Drop_Location_Search_Button);
		twoColumnMultipleSearchWindow(driver, Pickup_Location_Header, condition, Drop_Location_Code);
		 Step_End(4, " Click the Pickup Loc search field and select the Pick up location", test, test1);
		
		
		 
		 Step_Start(5, " Click on the Pick up type drop down and Select the Pick up type based on that we can able to select the select the Pickup terminal.", test, test1);
			waitForElement(driver, HC_Pickup_Type_Dropdown);
			click(driver, HC_Pickup_Type_Dropdown);
			
			  formatLocatorClick(driver, DropDown_Select, Pickup_Type_Value);
			
			  waitForElement(driver, HC_drop_Type_Dropdown);
				click(driver, HC_drop_Type_Dropdown);
				
				  formatLocatorClick(driver, DropDown_Select, Drop_Type_Value);
				
				  waitForElement(driver, HC_Pickup_Term_List);
					click(driver, HC_Pickup_Term_List);
					
					  formatLocatorClick(driver, DropDown_Select, Pickup_Term_Value);
					  
					  
					  if(isElementAccessible(driver, HC_Pickup_Terminal)) {
						    
				          	waitForElement(driver, HC_Pickup_Terminal);
				    		click(driver, HC_Pickup_Terminal);
				    		
				    		twoColumnMultipleSearchWindow(driver, Pickup_Terminal_Header, condition, Pickup_Terminal_Value);
				    		
				    		
					  }
					  Step_End(5, " Click on the Pick up type drop down and Select the Pick up type based on that we can able to select the select the Pickup terminal.", test, test1);
					  
		 

						 Step_Start(6, " Click the Drop Loc search field and select the Drop location", test, test1);

					  waitForElement(driver, HC_Drop_Term_List);
						click(driver, HC_Drop_Term_List);
						
						  formatLocatorClick(driver, DropDown_Select, Drop_Term_Value);
						  Step_End(6, " Click the Drop Loc search field and select the Drop location", test, test1);

						  
	  Step_Start(7, " Click on the Drop type Drop down and Select the Drop type based on that we can able to select the Drop terminal ", test, test1);
						
						  if(isElementAccessible(driver, HC_Drop_Terminal)) {
							    
					          	waitForElement(driver, HC_Drop_Terminal);
					    		click(driver, HC_Drop_Terminal);
					    		
					    		twoColumnMultipleSearchWindow(driver, Drop_Terminal_Header, condition,Drop_Terminal_Value);
						  }
						  Step_End(7, " Click on the Drop type Drop down and Select the Drop type based on that we can able to select the Drop terminal ", test, test1);
						  
							
						   
						  
		 
		 Step_Start(8, "Click on the Equipment drop down and select the Equipment type", test, test1);
		  
		waitForElement(driver, HC_Equipment_select);
		click(driver, HC_Equipment_select);
		
		  formatLocatorClick(driver, DropDown_Select, Equipment_Type);
		  Step_End(8, "Click on the Equipment drop down and select the Equipment type", test, test1);
		  
		  Step_Start(9, "Click on the LDN/MTY drop down and select the Larden or empty", test, test1);
		  
		  waitForElement(driver, HC_LDN_MTY_Select);
			click(driver, HC_LDN_MTY_Select);
			  Step_End(9, "Click on the LDN/MTY drop down and select the Larden or empty", test, test1);
			 Step_Start(10, "Click on the No of eqp units and select the Unit", test, test1);
			  formatLocatorClick(driver, DropDown_Select, HC_LDN_MTY_Value);
			  
			
			  Step_End(10, "Click on the No of eqp units and select the Unit", test, test1);
			  Step_Start(11, ".Click on the Hmode and Trip type drop down and select the value ", test, test1);
			  
			  waitForElement(driver, HC_H_Mode);
				click(driver, HC_H_Mode);
		           formatLocatorClick(driver, DropDown_Select, Haulage_mode_Value);
		           Step_End(11, ".Click on the Hmode and Trip type drop down and select the value ", test, test1);
					  
			  
			  
			  Step_Start(13, ".Select the valid from and valid to date ", test, test1);
			  
				waitForElement(driver, HC_From_Date);
				selectDatePicker(driver, HC_From_Date, From_Date_Input);
				waitForElement(driver, HC_To_Date);
				selectDatePicker(driver, HC_To_Date, To_Date_Input);
				  Step_End(13, ".Select the valid from and valid to date ", test, test1);
				  
				
						           
						           waitForElement(driver, HC_Trip_Types);
						   		click(driver, HC_Trip_Types);
						              formatLocatorClick(driver, DropDown_Select, Trip_Type_Value);	           
						           
						           
						           
						              Step_Start(14, "Click on the Neg by and select the value  ", test, test1);
									  
						           
						      		waitForElement(driver, HC_Neg_on_date);
						    		selectDatePicker(driver, HC_Neg_on_date, Neg_On_Date);
						    		
						    		
						    		
						    		waitForElement(driver, HC_Neg_by_Input);
						    		click(driver, HC_Neg_by_Input);
						    		
						    		twoColumnMultipleSearchWindow(driver, User_Name_Header, condition, User_Name_Input);
						    		
						    		  Step_End(14, "Click on the Neg by and select the value  ", test, test1);
						    		   Step_Start(15, "Click the currency and select the currency code  ", test, test1);
							          	waitForElement(driver, HC_Currency_Search);
							    		click(driver, HC_Currency_Search);
							    		
							    		twoColumnMultipleSearchWindow(driver, Currency_Header, condition, Currency_Select_Input);
							    		   Step_End(15, "Click the currency and select the currency code  ", test, test1);
						    		  
						    		  
						    		  
						    		  Step_Start(16, "Select the amt type  drop dowm and select the type ", test, test1);
						    		 waitForElement(driver, HC_Amount_Select);
								   		click(driver, HC_Amount_Select);
								              formatLocatorClick(driver, DropDown_Select, Amount_Type);	           
								              Step_End(16, "Select the amt type  drop dowm and select the type ", test, test1);
								              Step_Start(17, "Select the amount field  and enter the amount on that field. ", test, test1);
								              waitForElement(driver, HC_Amount_Input);
								              click(driver, HC_Amount_Input);
								              clearAndType(driver, HC_Amount_Input, Amount_Input);
								              
								              Step_End(17, "Select the amount field  and enter the amount on that field. ", test, test1);
								           
								    		   Step_End(18, "Fill the all mandadory details ", test, test1);
								    		   
								    		   Step_Start(19, "Click \"\"OK\"\" to save the details in haulage contract. ", test, test1);
								    		waitForElement(driver, HC_Tab_Ok_Button);
								    		click(driver, HC_Tab_Ok_Button);
								    		  Step_End(19, "Click \"\"OK\"\" to save the details in haulage contract. ", test, test1);
								    		
								    		
								    		  waitForDisplay(driver, HC_Add_Gird_Table);
								    			if (isdisplayed(driver, HC_Add_Gird_Table)) {
								    				System.out.println("Matched || Expected : All mandatory fields should be filled and added in the gird || Actual : All mandatory fields are filled and added in the gird");
								    				Extent_pass_New(driver, "Matched || Expected : All mandatory fields should be filled and added in the gird || Actual : All mandatory fields are filled and added in the gird", test, test1);
								    			} else {
								    				System.out.println("Not Matched || Expected : All mandatory fields should be filled and added in the gird || Actual : All mandatory fields are filled and not added in the gird");
								    				Extent_fail(driver, "Not Matched || Expected : All mandatory fields should be filled and added in the gird || Actual : All mandatory fields are filled and not added in the gird", test, test1);
								    	 
								    			}
								    		waitForElement(driver, HC_Add_Gird_Table);
								    		click(driver, HC_Add_Gird_Table);
								    		
								    		
								    		List<String> surcharge_Value = splitAndExpand(Surcharge_Add_Value);

								    		for (String surcharge : surcharge_Value) {
								    		    if (surcharge != null && !surcharge.trim().isEmpty()) {
								    		        // Step 1: Click Add Button
								    		    	 Step_Start(20, "Click the \"\"+\"\" inDG and select theDG code", test, test1);
								    		        waitForElement(driver, HC_Discharge_Add_Button);
								    		        click(driver, HC_Discharge_Add_Button);

								    		        // Step 2: Search & Select the Surcharge
								    		        twoColumnMultipleSearchWindow(driver, Surcharge_code_Header, condition, surcharge);
								    		        Step_End(20, "Click the \"\"+\"\" inDG and select theDG code", test, test1);
								    		        // Step 3: Format locator and wait for display
								    		        String added = formatLocatorClick(driver, HC_Surcharge_Grid_Value, surcharge);
								    		        waitForDisplay(driver, added);
								    		        
								    		        click(driver, added);
								    		 	  Step_Start(21, "Double click the charge and edit the amount.", test, test1);
								    		    	waitForElement(driver, HC_Amount_Grid);
								    				doubleClick(driver, HC_Amount_Grid);
								    				
								    				clearAndType(driver, HC_Amount_Grid, Amount_Edit_Value);
								    				enter(driver);
								    		 
								    				  Step_End(21, "Double click the charge and edit the amount.", test, test1);
								    				  Step_Start(22, "Select the row and Click remove \"\"-", test, test1);
										    		waitForElement(driver, HC_Remove_surcharge_Button);
										    		click(driver, HC_Remove_surcharge_Button);
										    		waitForElement(driver, popup_Message);
										    		String remove_popup_Act = getText(driver, popup_Message);
										    		System.out.println(remove_popup);
										    		
										    		  if(remove_popup.equals(remove_popup_Act)) {
										    	        	 System.out.println("Matched|| Expected Popup is :"+remove_popup + " || Actual Popup Is : "+remove_popup_Act);
										    	        	 Extent_pass_New(driver, "Matched||Expected Popup is :"+remove_popup + "||  Actual Popup Is  : "+remove_popup_Act, test, test1);
										    	         }else {
										    	        	 System.out.println("NotMatched ||Expected Popup is :"+remove_popup + " || Actual Popup Is  : "+remove_popup_Act);
										    	             Extent_fail(driver, "NotMatched || Expected Popup is :"+remove_popup + "||  Actual Popup Is  : "+remove_popup_Act, test, test1);
										    	         }
										    		
										    		
										    		waitForElement(driver, popup_Message_Yes_Button);
										    		click(driver, popup_Message_Yes_Button);
										    		

								    		        // Step 4: Check if displayed and perform mouse over
								    		        if (!isdisplayed(driver, added)) {
								    		            System.out.println("✅ Charge code was removed: " + surcharge);
								    		            Extent_pass_New(driver, "✅ Charge code was removed: " + surcharge, test, test1);
								    		        } else {
								    		            System.out.println("❌ Charge code NOT removed: " + surcharge);
								    		            Extent_fail(driver, "❌ Charge code NOT removed: " + surcharge, test, test1);
								    		        }
								    		    } else {
								    		        System.out.println("⚠️ Skipped null or empty surcharge value.");
								    		        Extent_fail(driver,"⚠️ Skipped null or empty surcharge value.", test, test1);
								    		    }
								    		}	
								    		  Step_End(22, "Select the row and Click remove \"\"-", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}

}
