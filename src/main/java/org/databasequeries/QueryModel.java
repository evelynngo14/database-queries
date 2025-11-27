package org.databasequeries;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class QueryModel {
   private QueryModel model;

   private final StringProperty query = new SimpleStringProperty("");

   public QueryModel() {
        this.model = model;
    }

    public String getQuery() {
       return query.get();
    }

    public void setQuery(String query) {
        this.query.set(query);
    }

    public void deleteQuery(String query) {}


}
