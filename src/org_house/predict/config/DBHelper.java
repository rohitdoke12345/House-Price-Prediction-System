package org_house.predict.config;
import java.sql.*;
public class DBHelper {
	protected DBconfig db = DBconfig.getDBInstance();
    protected Connection conn=DBconfig.getconnection();
    protected PreparedStatement stmt=DBconfig.getStatement();
    protected ResultSet rs=DBconfig.getResultSet();
}
