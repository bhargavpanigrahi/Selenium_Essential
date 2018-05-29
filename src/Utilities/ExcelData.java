package Utilities;

public class ExcelData extends ExcelUtils {

	final static String Path_TestData = System.getProperty("user.dir");
	final static String File_TestData = "//testdata.xlsx";
	protected static  int scenarioid=1;	
	
	protected static String URL = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "Url", 1);
	protected static String Username = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "UserName",  1);
	protected static String Password = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "PassWord",  1);
	protected static String PolicyNo = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "PolicyNumber",  1);
	protected static String Evntdate = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "EventDate",  1);
	protected static String Product = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "Product", 1);
	protected static String scheduleOfbenefits = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "ScheduleOfBenefits", 1);
	protected static String SIScoverage = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "SISCoverage", 1);
	protected static String coverage = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "Coverage", 1);
	protected static String occupation = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "Occupation", 1);
	protected static String relationship = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "Relationship", 1);
	protected static String provincecode = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "ProvinceCode", 1);
	protected static String eventdescription = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "EventDescription", 1);
	protected static String subclaimdescription = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "SubClaimDescription", 1);
	protected static String causecode = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "CauseCode", 1);
	protected static String subclaimcode = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "SubClaimCode", 1);
	protected static String claimtype = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "ClaimType", 1);
	protected static String causeofloss = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "CauseOfLoss", 1);
	protected static String contributingfactor = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "ContributingFactor", 1);
	protected static String conditioncode = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "ConditionCode", 1);
	protected static String causeofdeath = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "CauseOfDeath", 1);
	protected static String medicaldiagnosis = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "MedicalDiagnosis", 1);
	protected static String numberofevents = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "NumberOfEvents", 1);
	protected static String benefittype = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "BenefitType", 1);
	protected static String totalclaimAmt = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "TotalClaimAmt", 1);
	protected static String benificiarytype = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "BenificiaryType", 1);
	protected static String beneficiaryname = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "BeneficiaryName", 1);
	protected static String Benrelationship = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "BenRelationship", 1);
	protected static String indemnitytypecode = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "IndemnityTypeCode", 1);
	protected static String comment = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "Comment", 1);
	protected static String paymentletter = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "PaymentLetter", 1);
	protected static String receiptdate = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "ReceiptDate", 1);
	protected static String paymentdescription = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "PaymentDescription", 1);
	protected static String paymentmethod = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "PaymentMethod", 1);
	protected static String paymentmode = ExcelUtils.getCellData(Path_TestData + File_TestData, "TestData", "PaymentMode", 1);
}
