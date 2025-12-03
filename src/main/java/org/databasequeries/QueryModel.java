package org.databasequeries;

// holds the raw data (query result -> string)

public class QueryModel {

    private final String result;

    public QueryModel(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
