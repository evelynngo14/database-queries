package org.databasequeries;
import org.databasequeries.QueryModel;
import java.sql.*;

// handles Azure database connection and execution of SQL statements

public class QueryDAO {
    private static final String dbUser = "evelyn";
    private static final String dbPass = "Administrator!";
    private static final String url = String.format("jdbc:sqlserver://cisquerydb1.database.windows.net:1433;database=query-app;user=evelyn@cisquerydb1;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;", dbPass);


    public QueryModel executeSql(String sqlQuery) throws SQLException {
        String queryType = getQueryType(sqlQuery);

        if (queryType == null) {
            return new QueryModel("Error: Query must be SELECT, UPDATE, or DELETE command");
        }

        try (Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);

            if (queryType.equalsIgnoreCase("SELECT")) {
            try (ResultSet resultSet = stmt.executeQuery()) {
                return new QueryModel(formatResultSet(resultSet));
            }
            } else {
                int rowsAffected = stmt.executeUpdate();
                return new QueryModel(String.format("%s command executed. Rows affected: %d", queryType, rowsAffected));
            }

        } catch (SQLException e) {
            return new QueryModel("SQL Error: " + e.getMessage());
        }
    }

    private String getQueryType(String sqlQuery) {
        String queryFormatted = sqlQuery.trim().toUpperCase();
        if (queryFormatted.startsWith("SELECT")) return "SELECT";
        if (queryFormatted.startsWith("UPDATE")) return "UPDATE";
        if (queryFormatted.startsWith("DELETE")) return "DELETE";
        return null;
    }

    private String formatResultSet(ResultSet rs) throws SQLException {
        StringBuilder result = new StringBuilder();
        ResultSetMetaData rsMetaData = rs.getMetaData();

        // append header row
        for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
            result.append(String.format("%-20s\t", rsMetaData.getColumnName(i)));
        }

        result.append("\n");

        result.append("--------------------------------------------------------------------------------\n");

        // append data rows
        while (rs.next()) {
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                result.append(String.format("%-20s\t", rs.getObject(i)));
            }

            result.append("\n");
        }

        return result.toString();
    }
}

