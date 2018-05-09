package dp.structural.facade;

public class FacadePatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tableName="Employee";
		
		HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
		HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);	
	}

}
