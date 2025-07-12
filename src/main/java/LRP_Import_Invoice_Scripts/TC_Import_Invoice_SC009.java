package LRP_Import_Invoice_Scripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC009 extends Keywords {

	public void Import_Invoice_SC009(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name = "TC_Import_Invoice_SC009";
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_config_module = Excel_data.get("Agency_config_module");
		String import_Invoice_Module = Excel_data.get("import_Invoice_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Attribute_value = Excel_data.get("Attribute_value");
		String Value_checkbox_perform = Excel_data.get("Value_checkbox_perform");
		String Agency_Code = Excel_data.get("Agency_Code");
		String attribute_Header = Excel_data.get("attribute_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String UD_ConfigAttribute = Excel_data.get("UD_ConfigAttribute");
		String ChargesColumn_Header = Excel_data.get("ChargesColumn_Header");
		String AC_ChargeCode_Values = Excel_data.get("AC_ChargeCode_Values");
		String resetOption = Excel_data.get("resetOption");



		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		Extent_call(test, test1, "**Switch the Profile Start**");

		SwitchProfile(driver, AgencyUser);
		Map<String, String> newlyadded = new HashMap<>(); 
		Step_Start(1, " Open Accounting configuration module ", test, test1);

		if (Attribute_value.equalsIgnoreCase("NO_change")) {
			System.out.println("Accounting configiration was not changed");
		} else {
			 newlyadded = setAccountingConfiguration(driver, Agency_config_module, Agency_Code,attribute_Header,Search_Condition,AgencyUser,Attribute_value,UD_ConfigAttribute,ChargesColumn_Header,AC_ChargeCode_Values,Value_checkbox_perform);

		}
		Step_Start(8, "open the import invoice module ", test, test1);
		moduleNavigate(driver, import_Invoice_Module);

		Step_End(8, "open the import invoice module ", test, test1);
		if (Attribute_value.equalsIgnoreCase("NO_change")) {
			Extent_call(test, test1, "Verify that if No Configuration enable system shows below Tabs");

			Extent_call(test, test1, "1. bl details");

			waitForElement(driver, Bl_Detial_tab);
			if (isElementEnabled(driver, Bl_Detial_tab)) {
				System.out.println(
						"Pass || Expected result is : System should show BL Details Tab || Actual result is :  System displayed the show BL Details Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is : System should show BL Details Tab || Actual result is :  System displayed the show BL Details Tab",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : System should show BL Details Tab || Actual result is :  System not displayed the show BL Details Tab");
				Extent_fail(driver,
						"Fail || Expected result is : System should show BL Details Tab || Actual result is :  System not displayed the show BL Details Tab",
						test, test1);
			}

			Extent_call(test, test1, "2. manifest charge");

			if (isElementEnabled(driver, Manifest_charges_tab)) {

				System.out.println(
						"Pass || Expected result is :  System should show Manifest charges Tab || Actual result is : System displayed the show Manifest charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is :  System should show Manifest charges Tab || Actual result is : System displayed the show Manifest charges Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is :  System should show Manifest charges Tab || Actual result is : System not displayed the show Manifest charges Tab");
				Extent_fail(driver,
						"fail || Expected result is :  System should show Manifest charges Tab || Actual result is : System not displayed the show Manifest charges Tab",
						test, test1);
			}

			Extent_call(test, test1, "3. non manifest charge");

			if (isElementEnabled(driver, Non_Manifest_tab)) {

				System.out.println(
						"Pass || Expected result is : System should show Non Manifest charges Tab || Actual result is :System not displayed the show Non Manifest charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is : System should show Non Manifest charges Tab || Actual result is :System not displayed the show Non Manifest charges Tab",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : System should show Non Manifest charges Tab || Actual result is : Non Manifest charges Tab is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : System should show Non Manifest charges Tab || Actual result is : Non Manifest charges Tab is not displayed",
						test, test1);
			}

			Extent_call(test, test1, "4. detention charge");

			if (isElementEnabled(driver, Detention_Charges_tab)) {

				System.out.println(
						"Pass || Expected result is :System should show Detention charges Tab || Actual result is : System displayed the show Detention charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is :System should show Detention charges Tab || Actual result is : System displayed the show Detention charges Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is :System should show Detention charges Tab || Actual result is : System not displayed the show Detention charges Tab");
				Extent_fail(driver,
						"fail || Expected result is :System should show Detention charges Tab || Actual result is : System not displayed the show Detention charges Tab",
						test, test1);
			}

			Extent_call(test, test1, "5. storage charge");

			if (isElementEnabled(driver, port_Storage_tab)) {

				System.out.println(
						"Pass || Expected result is :System should show Storage charges Tab || Actual result is : System displayed the show Storage charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is :System should show Storage charges Tab || Actual result is : System displayed the show Storage charges Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is :System should show Storage charges Tab || Actual result is : System not displayed the show Storage charges Tab");
				Extent_fail(driver,
						"fail || Expected result is :System should show Storage charges Tab || Actual result is : System not displayed the show Storage charges Tab",
						test, test1);
			}

			Extent_call(test, test1, "6. additional charge");

			if (isElementEnabled(driver, Additional_charges_tab)) {

				System.out.println(
						"Pass || Expected result is : System should show Additional charges Tab || Actual result is : System displayed the show Additional charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is : System should show Additional charges Tab || Actual result is : System displayed the show Additional charges Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is : System should show Additional charges Tab || Actual result is : System not displayed the show Additional charges Tab");
				Extent_fail(driver,
						"fail || Expected result is : System should show Additional charges Tab || Actual result is : System not displayed the show Additional charges Tab",
						test, test1);
			}
		}

		if (Attribute_value.equalsIgnoreCase("EIM")) {

			Extent_call(test, test1,
					"Verify  that after load the bl in bl number field system has showing  the  following Tab,when accounting configuration enabled- EIM");

			Extent_call(test, test1, "1. bl details");

			waitForElement(driver, Bl_Detial_tab);
			if (isElementEnabled(driver, Bl_Detial_tab)) {
				System.out.println(
						"Pass || Expected result is :System should show BL Details Tab || Actual result is : System displayed the show BL Details Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is :System should show BL Details Tab || Actual result is : System displayed the show BL Details Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is :System should show BL Details Tab || Actual result is : System not displayed the show BL Details Tab");
				Extent_fail(driver,
						"fail || Expected result is :System should show BL Details Tab || Actual result is : System not displayed the show BL Details Tab",
						test, test1);
			}

			Extent_call(test, test1, "2. manifest charge");

			if (isElementEnabled(driver, Manifest_charges_tab)) {

				System.out.println(
						"Pass || Expected result is : System should show Manifest charges Tab || Actual result is :  System displayed the show Manifest charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is : System should show Manifest charges Tab || Actual result is :  System displayed the show Manifest charges Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is : System should show Manifest charges Tab || Actual result is :  System not displayed the show Manifest charges Tab");
				Extent_fail(driver,
						"fail || Expected result is : System should show Manifest charges Tab || Actual result is :  System not displayed the show Manifest charges Tab",
						test, test1);
			}

			Extent_call(test, test1, "3. non manifest charge");

			if (isElementEnabled(driver, Non_Manifest_tab)) {

				System.out.println(
						"Pass || Expected result is :  System should show Non Manifest charges Tab || Actual result is : System displayed the show Non Manifest charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is :  System should show Non Manifest charges Tab || Actual result is : System displayed the show Non Manifest charges Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is :  System should show Non Manifest charges Tab || Actual result is : System not displayed the show Non Manifest charges Tab");
				Extent_fail(driver,
						"fail || Expected result is :  System should show Non Manifest charges Tab || Actual result is : System not displayed the show Non Manifest charges Tab",
						test, test1);
			}

			Extent_call(test, test1, "4. detention charge");

			if (isElementEnabled(driver, Detention_Charges_tab)) {

				System.out.println(
						"Pass || Expected result is :System should show Detention charges Tab || Actual result is :  System displayed the show Detention charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is :System should show Detention charges Tab || Actual result is :  System displayed the show Detention charges Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is :System should show Detention charges Tab || Actual result is :  System not displayed the show Detention charges Tab");
				Extent_fail(driver,
						"fail || Expected result is :System should show Detention charges Tab || Actual result is :  System not displayed the show Detention charges Tab",
						test, test1);
			}

			Extent_call(test, test1, "5. storage charge");

			if (isElementEnabled(driver, port_Storage_tab)) {

				System.out.println(
						"Pass || Expected result is : System should show Storage charges Tab || Actual result is :System displayed the show Storage charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is : System should show Storage charges Tab || Actual result is :System displayed the show Storage charges Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is : System should show Storage charges Tab || Actual result is :System not displayed the show Storage charges Tab");
				Extent_fail(driver,
						"fail || Expected result is : System should show Storage charges Tab || Actual result is :System not displayed the show Storage charges Tab",
						test, test1);
			}

			Extent_call(test, test1, "6. additional charge");

			if (isElementEnabled(driver, Additional_charges_tab)) {

				System.out.println(
						"Pass || Expected result is : If 'No configuration is enabled, System should show Additional charges Tab || Actual result is : If 'No configuration is enabled, System displayed the show Additional charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is : If 'No configuration is enabled, System should show Additional charges Tab || Actual result is : If 'No configuration is enabled, System displayed the show Additional charges Tab",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : If 'No configuration is enabled, System should show Additional charges Tab || Actual result is : If 'No configuration is enabled, Additional charges Tab is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : If 'No configuration is enabled, System should show Additional charges Tab || Actual result is : If 'No configuration is enabled, Additional charges Tab is not displayed",
						test, test1);
			}

			Extent_call(test, test1, "7. E-invoice details");

			if (isElementEnabled(driver, E_invoice_Details_tab)) {

				System.out.println(
						"Pass || Expected result is :System should show E-invoice details Tab || Actual result is : System displayed the show E-invoice details Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is :System should show E-invoice details Tab || Actual result is : System displayed the show E-invoice details Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is :System should show E-invoice details Tab || Actual result is : System not displayed the show E-invoice details Tab");
				Extent_fail(driver,
						"fail || Expected result is :System should show E-invoice details Tab || Actual result is : System not displayed the show E-invoice details Tab",
						test, test1);
			}
		}

		if (Attribute_value.equalsIgnoreCase("HBR")) {

			Extent_call(test, test1,
					"Columns has to enable based on this accounting config,HBR-Invoice - Enable House BL Remarks Tab");

			Extent_call(test, test1, "1. bl details");

			waitForElement(driver, Bl_Detial_tab);
			if (isElementEnabled(driver, Bl_Detial_tab)) {
				System.out.println(
						"Pass || Expected result is : System should show BL Details Tab || Actual result is :System displayed the show BL Details Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is : System should show BL Details Tab || Actual result is :System displayed the show BL Details Tab",
						test, test1);

			} else {
				System.out.println(
						"Pass || Expected result is : System should show BL Details Tab || Actual result is :System not displayed the show BL Details Tab");
				Extent_fail(driver,
						"Pass || Expected result is : System should show BL Details Tab || Actual result is :System not displayed the show BL Details Tab",
						test, test1);
			}

			Extent_call(test, test1, "2. manifest charge");

			if (isElementEnabled(driver, Manifest_charges_tab)) {

				System.out.println(
						"Pass || Expected result is : System should show Manifest charges Tab || Actual result is : System displayed the show Manifest charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is : System should show Manifest charges Tab || Actual result is : System displayed the show Manifest charges Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is : System should show Manifest charges Tab || Actual result is : System not displayed the show Manifest charges Tab");
				Extent_fail(driver,
						"fail || Expected result is : System should show Manifest charges Tab || Actual result is : System not displayed the show Manifest charges Tab",
						test, test1);
			}

			Extent_call(test, test1, "3. non manifest charge");

			if (isElementEnabled(driver, Non_Manifest_tab)) {

				System.out.println(
						"Pass || Expected result is :System should show Non Manifest charges Tab || Actual result is : System displayed the  Non Manifest charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is :System should show Non Manifest charges Tab || Actual result is : System displayed the  Non Manifest charges Tab",
						test, test1);

			} else {
				System.out.println(
						"fail || Expected result is :System should show Non Manifest charges Tab || Actual result is : System not displayed the  Non Manifest charges Tab");
				Extent_fail(driver,
						"fail || Expected result is :System should show Non Manifest charges Tab || Actual result is : System not displayed the  Non Manifest charges Tab",
						test, test1);
			}

			Extent_call(test, test1, "4. detention charge");

			if (isElementEnabled(driver, Detention_Charges_tab)) {

				System.out.println(
						"Pass || Expected result is :  System should show Detention charges Tab || Actual result is : System displayed the show Detention charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is :  System should show Detention charges Tab || Actual result is : System displayed the show Detention charges Tab",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : System should show Detention charges Tab || Actual result is :  Detention charges Tab is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : System should show Detention charges Tab || Actual result is :  Detention charges Tab is not displayed",
						test, test1);
			}

			Extent_call(test, test1, "5. storage charge");

			if (isElementEnabled(driver, port_Storage_tab)) {

				System.out.println(
						"Pass || Expected result is :System should show Storage charges Tab || Actual result is :System displayed the show Storage charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is : System should show Storage charges Tab || Actual result is : System displayed the show Storage charges Tab",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : System should show Storage charges Tab || Actual result is :  Storage charges Tab is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is :System should show Storage charges Tab || Actual result is : Storage charges Tab is not displayed",
						test, test1);
			}

			Extent_call(test, test1, "6. additional charge");

			if (isElementEnabled(driver, Additional_charges_tab)) {

				System.out.println(
						"Pass || Expected result is : System should show Additional charges Tab || Actual result is : System displayed the show Additional charges Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is :System should show Additional charges Tab || Actual result is : System displayed the show Additional charges Tab",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : System should show Additional charges Tab || Actual result is : Additional charges Tab is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is :  System should show Additional charges Tab || Actual result is : Additional charges Tab is not displayed",
						test, test1);
			}
			Extent_call(test, test1, "7. House BL Remarks");
			waitForElement(driver, House_bl_remarks_tab);
			if (isElementEnabled(driver, House_bl_remarks_tab)) {

				System.out.println(
						"Pass || Expected result is : System should show House BL Remarks Tab || Actual result is : System displayed the show House BL Remarks Tab");
				Extent_pass_New(driver,
						"Pass || Expected result is :System should show House BL Remarks Tab || Actual result is : System displayed the show House BL Remarks Tab",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected result is : System should show House BL Remarks Tab || Actual result is :House BL Remarks Tab is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is :System should show House BL Remarks Tab || Actual result is :  House BL Remarks Tab is not displayed",
						test, test1);
			}
		}

		if (Attribute_value.equalsIgnoreCase("RDC")) {
			if (Value_checkbox_perform.equalsIgnoreCase("YES")) {

				Extent_call(test, test1,
						"Below column  enabled by enabling the accounting config,-RDC-Invoice - Restrict D&D calculation in Export/Import Invoice, If Y");

				Extent_call(test, test1, "1. bl details");

				waitForElement(driver, Bl_Detial_tab);
				if (isElementEnabled(driver, Bl_Detial_tab)) {
					System.out.println(
							"Pass || Expected result is : System should show BL Details Tab || Actual result is :  System displayed the show BL Details Tab");
					Extent_pass_New(driver,
							"Pass || System should show BL Details Tab || Actual result is : System displayed the show BL Details Tab",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : System should show BL Details Tab || Actual result is : BL Details Tab is not displayed");
					Extent_fail(driver,
							"Fail || Expected result is : System should show BL Details Tab || Actual result is : BL Details Tab is not displayed",
							test, test1);
				}

				Extent_call(test, test1, "2. manifest charge");

				if (isElementEnabled(driver, Manifest_charges_tab)) {

					System.out.println(
							"Pass || Expected result is :  System should show Manifest charges Tab || Actual result is : If 'No configuration is enabled, System displayed the show Manifest charges Tab");
					Extent_pass_New(driver,
							"Pass || Expected result is :  System should show Manifest charges Tab || Actual result is : If 'No configuration is enabled, System displayed the show Manifest charges Tab",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : System should show Manifest charges Tab || Actual result is : If 'No configuration is enabled, Manifest charges Tab is not displayed");
					Extent_fail(driver,
							"Fail || Expected result is : System should show Manifest charges Tab || Actual result is : If 'No configuration is enabled, Manifest charges Tab is not displayed",
							test, test1);
				}

				Extent_call(test, test1, "3. non manifest charge");

				if (isElementEnabled(driver, Non_Manifest_tab)) {

					System.out.println(
							"Pass || Expected result is : System should show Non Manifest charges Tab || Actual result is : If 'No configuration is enabled, System displayed the show Non Manifest charges Tab");
					Extent_pass_New(driver,
							"Pass || Expected result is :  System should show Non Manifest charges Tab || Actual result is : If 'No configuration is enabled, System displayed the show Non Manifest charges Tab",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is :  System should show Non Manifest charges Tab || Actual result is : If 'No configuration is enabled, Non Manifest charges Tab is not displayed");
					Extent_fail(driver,
							"Fail || Expected result is : System should show Non Manifest charges Tab || Actual result is : If 'No configuration is enabled, Non Manifest charges Tab is not displayed",
							test, test1);
				}

				Extent_call(test, test1, "4. additional charge");
				if (isElementEnabled(driver, Additional_charges_tab)) {

					System.out.println(
							"Pass || Expected result is :  System should show Additional charges Tab || Actual result is : System displayed the show Additional charges Tab");
					Extent_pass_New(driver,
							"Pass || Expected result is :System should show Additional charges Tab || Actual result is :  System displayed the show Additional charges Tab",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : System should show Additional charges Tab || Actual result is : Additional charges Tab is not displayed");
					Extent_fail(driver,
							"Fail || Expected result is :  System should show Additional charges Tab || Actual result is : Additional charges Tab is not displayed",
							test, test1);
				}
			}

		}

		if (Attribute_value.equalsIgnoreCase("RDC")) {
			if (Value_checkbox_perform.equalsIgnoreCase("NO")) {
				Extent_call(test, test1,
						"Below column  enabled by enabling the accounting config,-RDC-Invoice - Restrict D&D calculation in Export/Import Invoice, If N");
				Extent_call(test, test1, "1. bl details");

				waitForElement(driver, Bl_Detial_tab);
				if (isElementEnabled(driver, Bl_Detial_tab)) {
					System.out.println(
							"Pass || Expected result is : System should show BL Details Tab || Actual result is :  System displayed the show BL Details Tab");
					Extent_pass_New(driver,
							"Pass || Expected result is : System should show BL Details Tab || Actual result is :  System displayed the show BL Details Tab",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is :  System should show BL Details Tab || Actual result is : BL Details Tab is not displayed");
					Extent_fail(driver,
							"Fail || Expected result is : System should show BL Details Tab || Actual result is : BL Details Tab is not displayed",
							test, test1);
				}

				Extent_call(test, test1, "2. manifest charge");

				if (isElementEnabled(driver, Manifest_charges_tab)) {

					System.out.println(
							"Pass || Expected result is : System should show Manifest charges Tab || Actual result is : System displayed the show Manifest charges Tab");
					Extent_pass_New(driver,
							"Pass || Expected result is :  System should show Manifest charges Tab || Actual result is : System displayed the show Manifest charges Tab",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is :  System should show Manifest charges Tab || Actual result is :Manifest charges Tab is not displayed");
					Extent_fail(driver,
							"Fail || Expected result is : System should show Manifest charges Tab || Actual result is : Manifest charges Tab is not displayed",
							test, test1);
				}

				Extent_call(test, test1, "3. non manifest charge");

				if (isElementEnabled(driver, Non_Manifest_tab)) {

					System.out.println(
							"Pass || Expected result is : System should show Non Manifest charges Tab || Actual result is : System displayed the show Non Manifest charges Tab");
					Extent_pass_New(driver,
							"Pass || Expected result is : System should show Non Manifest charges Tab || Actual result is : System displayed the show Non Manifest charges Tab",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is :  System should show Non Manifest charges Tab || Actual result is :  Non Manifest charges Tab is not displayed");
					Extent_fail(driver,
							"Fail || Expected result is : System should show Non Manifest charges Tab || Actual result is : Non Manifest charges Tab is not displayed",
							test, test1);
				}

				Extent_call(test, test1, "4. detention charge");

				if (isElementEnabled(driver, Detention_Charges_tab)) {

					System.out.println(
							"Pass || Expected result is :  System should show Detention charges Tab || Actual result is :  System displayed the show Detention charges Tab");
					Extent_pass_New(driver,
							"Pass || Expected result is : System should show Detention charges Tab || Actual result is : System displayed the show Detention charges Tab",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is : System should show Detention charges Tab || Actual result is :  Detention charges Tab is not displayed");
					Extent_fail(driver,
							"Fail || Expected result is : System should show Detention charges Tab || Actual result is :  Detention charges Tab is not displayed",
							test, test1);
				}

				Extent_call(test, test1, "5. storage charge");

				if (isElementEnabled(driver, port_Storage_tab)) {

					System.out.println(
							"Pass || Expected result is :  System should show Storage charges Tab || Actual result is : System displayed the show Storage charges Tab");
					Extent_pass_New(driver,
							"Pass || Expected result is : System should show Storage charges Tab || Actual result is : System displayed the show Storage charges Tab",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is :  System should show Storage charges Tab || Actual result is :Storage charges Tab is not displayed");
					Extent_fail(driver,
							"Fail || Expected result is : System should show Storage charges Tab || Actual result is : Storage charges Tab is not displayed",
							test, test1);
				}

				Extent_call(test, test1, "6. additional charge");

				if (isElementEnabled(driver, Additional_charges_tab)) {

					System.out.println(
							"Pass || Expected result is : System should show Additional charges Tab || Actual result is :  System displayed the show Additional charges Tab");
					Extent_pass_New(driver,
							"Pass || Expected result is :  System should show Additional charges Tab || Actual result is : System displayed the show Additional charges Tab",
							test, test1);

				} else {
					System.out.println(
							"Fail || Expected result is :  System should show Additional charges Tab || Actual result is :  Additional charges Tab is not displayed");
					Extent_fail(driver,
							"Fail || Expected result is :  System should show Additional charges Tab || Actual result is : Additional charges Tab is not displayed",
							test, test1);
				}
			}

		}

		Extent_call(test, test1,
				"EACH and Every data set system has to Reset the configuration what is available from the Begenning.");

		if (Attribute_value.equalsIgnoreCase("NO_change")) {
			System.out.println("Accounting configiration was not changed");
		} else {
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			reSetAccountingConfiguration(driver, resetOption, newlyadded, Agency_config_module, Agency_Code, Search_Condition, AgencyUser, Attribute_value, UD_ConfigAttribute);

		}

		Extent_completed(tc_Name, test, test1);

	}
}
