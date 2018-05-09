package dp.structural.facade;

import java.sql.Connection;

public class MySqlHelper {
	
	public static Connection getMySqlDBConnection() {
		return null;
	}
	public void generateMySqlPDFReport(String tableName, Connection con) {
		System.out.println("Mysql pdf report is generated");
	}
	
	public void generateMySqlHTMLReport(String tableName, Connection con) {
		System.out.println("Mysql html report is generated");
	}
}
