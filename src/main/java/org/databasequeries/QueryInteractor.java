package org.databasequeries;

public class QueryInteractor {
    private QueryModel model;

    public QueryInteractor(QueryModel model) {
        this.model = model;
    }

    public void executeQuery() {
        System.out.println("Executing Query");
    }
}

