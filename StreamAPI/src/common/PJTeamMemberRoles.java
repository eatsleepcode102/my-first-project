package common;

public enum PJTeamMemberRoles {
	QUANTITY_SURVEYOR("QSR","QUANTITY_SURVEYOR"),
	CLAIM_OFFICER("CLO","CLAIM_OFFICER"),
	PROJECT_COORDINATOR("PRC","PROJECT_COORDINATOR"),
	SERVICE_ENGINEER("SEN","SERVICE_ENGINEER"),
	PROJECT_DIRECTOR("PDR","PROJECT_DIRECTOR"),
	RESIDENT_TECHNICAL_OFFICER("RTO","RESIDENT_TECHNICAL_OFFICER"),
	PROJECT_MANAGER("PRM","PROJECT_MANAGER"),
	SUBCON_CLAIM_OFFICER("SCO","SUBCON_CLAIM_OFFICER"),
	OPERATION_MANAGER("OPM","OPERATION_MANAGER"),
	CONSTRUCTION_MANAGER("CM","CONSTRUCTION_MANAGER"),
	EXCUTIVE_DIRECTOR("EDR","EXCUTIVE_DIRECTOR"),
	HEAD_OF_DEPARTMENT("HOD","HEAD_OF_DEPARTMENT");

    private String roleCode;
    private String roleName;

    PJTeamMemberRoles(String roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName=roleName;
    }

    public String roleCode() {
        return roleCode;
    }
    
    public String roleName(){
    	return this.roleName;
    }
}