package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Current_History_Report_Locators{
	

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Current_History_Report", "Reference_Name", Testcases.environmentName);

	public static String reportByOpt = ExcelData.get("reportByOpt");
	public static String summaryOpt = ExcelData.get("summaryOpt");
	public static String showOpt = ExcelData.get("showOpt");
	public static String includeShipperOwnedOpt = ExcelData.get("includeShipperOwnedOpt");
	public static String displayDragOpt = ExcelData.get("displayDragOpt");
	public static String reportBySelect = ExcelData.get("reportBySelect");
	public static String shipperOwnedOption = ExcelData.get("shipperOwnedOption");
	public static String FromLoc = ExcelData.get("FromLoc");
	public static String ToLoc = ExcelData.get("ToLoc");
	public static String detailsOPt = ExcelData.get("detailsOPt");
	public static String downloadOpt = ExcelData.get("downloadOpt");
	public static String processed = ExcelData.get("processed");
	public static String reportDownload = ExcelData.get("reportDownload");
	public static String To_Date_new = ExcelData.get("To_Date_new");
	public static String ATo_Date = ExcelData.get("ATo_Date");
	public static String khistoryOpt = ExcelData.get("khistoryOpt");
	public static String kDateSearch = ExcelData.get("kDateSearch");
	public static String kActivityDate = ExcelData.get("kActivityDate");
	public static String kMonthSearch = ExcelData.get("kMonthSearch");
	public static String kActivityDateLast = ExcelData.get("kActivityDateLast");
	public static String kCreationDate = ExcelData.get("kCreationDate");
	public static String kCreationDateLast = ExcelData.get("kCreationDateLast");
	public static String kModifyDate = ExcelData.get("kModifyDate");
	public static String kModifyDateLast = ExcelData.get("kModifyDateLast");
	public static String kOkOption = ExcelData.get("kOkOption");
	public static String Report_download = ExcelData.get("Report_download");
	public static String Column_Field = ExcelData.get("Column_Field");
	public static String SizeType_Standard = ExcelData.get("SizeType_Standard");
	public static String StockStatus_PlusBtn = ExcelData.get("StockStatus_PlusBtn");
	public static String Stock_SearchTF = ExcelData.get("Stock_SearchTF");
	public static String Select_Btn = ExcelData.get("Select_Btn");
	public static String Search_Popup = ExcelData.get("Search_Popup");
	public static String Close_Popup = ExcelData.get("Close_Popup");
	public static String Search_Close = ExcelData.get("Search_Close");
	public static String Loc_CloseBtn = ExcelData.get("Loc_CloseBtn");
	public static String StockStatus_MinusBtn = ExcelData.get("StockStatus_MinusBtn");
	public static String ActivityCode_PlusBtn = ExcelData.get("ActivityCode_PlusBtn");
	public static String ActivityCode_TF = ExcelData.get("ActivityCode_TF");
	public static String Service_SearchBtn = ExcelData.get("Service_SearchBtn");
	public static String Servicevalue_TF = ExcelData.get("Servicevalue_TF");
	public static String Value_select = ExcelData.get("Value_select");
	public static String Value_Select_btn = ExcelData.get("Value_Select_btn");
	public static String Disposal_RegNo_SearchBtn = ExcelData.get("Disposal_RegNo_SearchBtn");
	public static String Disposal_RegNo_TF = ExcelData.get("Disposal_RegNo_TF");
	public static String BookNo_SearchBtn = ExcelData.get("BookNo_SearchBtn");
	public static String BookNo_TF = ExcelData.get("BookNo_TF");
	public static String ActivityCode_MinusBtn = ExcelData.get("ActivityCode_MinusBtn");
	public static String SupplierContract_PlusBtn = ExcelData.get("SupplierContract_PlusBtn");
	public static String Suppliercontract_TF = ExcelData.get("Suppliercontract_TF");
	public static String SupplierContract_minusBtn = ExcelData.get("SupplierContract_minusBtn");
	public static String Vessel_PlusBtn = ExcelData.get("Vessel_PlusBtn");
	public static String Vessel_MinusBtn = ExcelData.get("Vessel_MinusBtn");
	public static String LeaseKind_PlusBtn = ExcelData.get("LeaseKind_PlusBtn");
	public static String LeaseKind_TF = ExcelData.get("LeaseKind_TF");
	public static String LeaseKind_MinusBtn = ExcelData.get("LeaseKind_MinusBtn");
	public static String Lease_PlusBtn = ExcelData.get("Lease_PlusBtn");
	public static String Lease_TF = ExcelData.get("Lease_TF");
	public static String Lease_MinusBtn = ExcelData.get("Lease_MinusBtn");
	public static String SizeType_special = ExcelData.get("SizeType_special");
	public static String Region_TF = ExcelData.get("Region_TF");
	public static String POD_TF = ExcelData.get("POD_TF");
	public static String Destination_TF = ExcelData.get("Destination_TF");
	public static String SizeType_PlusBtn = ExcelData.get("SizeType_PlusBtn");
	public static String SizeType_TF = ExcelData.get("SizeType_TF");
	public static String SizeType_MinusBtn = ExcelData.get("SizeType_MinusBtn");
	public static String CustomerContract_PlusBtn = ExcelData.get("CustomerContract_PlusBtn");
	public static String Customercontract_TF = ExcelData.get("Customercontract_TF");
	public static String CustomerContract_minusBtn = ExcelData.get("CustomerContract_minusBtn");
	public static String Lessor_PlusBtn = ExcelData.get("Lessor_PlusBtn");
	public static String Lessor_TF = ExcelData.get("Lessor_TF");
	public static String Lessor_MinusBtn = ExcelData.get("Lessor_MinusBtn");
	public static String Service_TF = ExcelData.get("Service_TF");
	public static String FlagCode_PlusBtn = ExcelData.get("FlagCode_PlusBtn");
	public static String FlagCode_TF = ExcelData.get("FlagCode_TF");
	public static String From_Loc_Hierarchy_Dropdown = ExcelData.get("From_Loc_Hierarchy_Dropdown");
	public static String From_Loc_region_searchbtn = ExcelData.get("From_Loc_region_searchbtn");
	public static String From_Loc_Region_TF = ExcelData.get("From_Loc_Region_TF");
	public static String Loc_POR_searchBtn = ExcelData.get("Loc_POR_searchBtn");
	public static String Loc_POR_TF = ExcelData.get("Loc_POR_TF");
	public static String Loc_POL_TF = ExcelData.get("Loc_POL_TF");
	public static String Loc_POL_SearchBtn = ExcelData.get("Loc_POL_SearchBtn");
	public static String To_Region_searchBtn = ExcelData.get("To_Region_searchBtn");
	public static String To_Region_TF = ExcelData.get("To_Region_TF");
	public static String FlagCode_MinusBtn = ExcelData.get("FlagCode_MinusBtn");
	public static String Disposal_TF = ExcelData.get("Disposal_TF");
	public static String BookNo_Tf = ExcelData.get("BookNo_Tf");
	public static String IncludeBL_checkBox = ExcelData.get("IncludeBL_checkBox");
	public static String To_Loc_Hierarchy_Dropdown = ExcelData.get("To_Loc_Hierarchy_Dropdown");
	public static String Loc_POD_SearchBtn = ExcelData.get("Loc_POD_SearchBtn");
	public static String Loc_POD_TF = ExcelData.get("Loc_POD_TF");
	public static String Loc_Destination_SearchBtn = ExcelData.get("Loc_Destination_SearchBtn");
	public static String Loc_Destination_TF = ExcelData.get("Loc_Destination_TF");
	public static String closeSymbols_CH_R = ExcelData.get("closeSymbols_CH_R");
	public static String dashboard_Title_CH_R = ExcelData.get("dashboard_Title_CH_R");
	public static String portOpt = ExcelData.get("portOpt");
	public static String DeportOpt = ExcelData.get("DeportOpt");





}
