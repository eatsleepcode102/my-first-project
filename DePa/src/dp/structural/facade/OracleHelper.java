package dp.structural.facade;

import java.sql.Connection;

public class OracleHelper {

	public static Connection getOracleConnection() {
		return null;
	}

	public void generateOraclePDFReport(String tableName, Connection con) {
		System.out.println("Oracle pdf report is generated");
	}

	public void generateOracleHTMlReport(String tableName, Connection con) {
		System.out.println("Oracle html report is generated");
	}
}
