package org.databasequeries;

// data structures; holds the raw or processed data

public class QueryModel {
    private final String result;

    public QueryModel(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

}
