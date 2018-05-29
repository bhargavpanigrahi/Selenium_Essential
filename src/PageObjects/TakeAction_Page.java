package PageObjects;

import java.util.HashMap;
import java.util.Map;

import utility.WebDr;

public class TakeAction_Page {
	
	public static void SetPage_takeAction()
	{
		Map<String, String> takeAction_Page_Objects=new HashMap<String, String>();
		
		takeAction_Page_Objects.put("PolicyNo_CBX", "ID|ConfirmPolicyNumber");
		takeAction_Page_Objects.put("SISPolicyNo_CBX", "XPATH|(//input[@id='ConfirmSISPolicyNumber'])[1]");
		takeAction_Page_Objects.put("EventDate_CBX", "XPATH|//input[@id='ConfirmEventDate']");
		takeAction_Page_Objects.put("EventDescription_CBX", "XPATH|//input[@id='ConfirmEventDescription']");
		takeAction_Page_Objects.put("SubClaimDescrption_CBX", "XPATH|(//input[@id='ConfirmSISPolicyNumber'])[2]");
		takeAction_Page_Objects.put("PotientialForRecovery_CBX", "ID|VerifyPotentialForRecoveryNo");
		takeAction_Page_Objects.put("CauseOfDeath_TBX", "ID|CauseOfDeath");
		takeAction_Page_Objects.put("No_CBX", "ID|CestaBasicaNo");
		takeAction_Page_Objects.put("MedicalDiagnosis_TBX", "XPATH|//input[@name='$PpyWorkPage$pMedicalDiagnosis']");
		takeAction_Page_Objects.put("Sumbit_BTN", "ID|submitButton");
		takeAction_Page_Objects.put("NumberOfEvents_TBX", "ID|NumberOfEvents");
		takeAction_Page_Objects.put("BenefitType_DDL", "XPATH|//select[@id='BenefitType']");
		takeAction_Page_Objects.put("TotalClaimAmount_TBX", "ID|TotalClaimAmount");
		takeAction_Page_Objects.put("BenificiaryType_DDL", "XPATH|//select[@id='BenificiaryType']");
		takeAction_Page_Objects.put("AddBeneficiary_ICON", "XPATH|//a[@class='iconInsert']");
		takeAction_Page_Objects.put("SelectBeneficiary_CBX", "XPATH|//input[@id='IsSelectedBen']");
		takeAction_Page_Objects.put("SelectBeneficiary_CBX", "ID|BENBeneficiaryName");
		takeAction_Page_Objects.put("SelectBeneficiary_CBX", "ID|BENBeneficiaryName");
		
		
		WebDr.page_Objects=takeAction_Page_Objects;
		
		
		
	}
	
	

}
