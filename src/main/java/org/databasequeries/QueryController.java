package org.databasequeries;

import javafx.scene.control.TextArea;
import java.sql.SQLException;

public class QueryController {

    private final QueryDAO dao;
    private TextArea resultsArea;


    public QueryController() {
        this.dao = new QueryDAO();
    }

    public void setResultsArea(TextArea resultsArea) {
        this.resultsArea = resultsArea;
    }

    public void executeQuery(String sqlQuery) throws SQLException {
        String query = sqlQuery.trim();
        QueryModel resultModel = dao.executeSql(query);

        if (query.isEmpty()) {
            resultsArea.setText("Query is empty\n");
        }

        if (resultsArea != null) {
            resultsArea.setText(resultModel.getResult());
        }
    }
}