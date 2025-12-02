module org.databasequeries {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;
    requires java.management;

    opens org.databasequeries to javafx.fxml, javafx.graphics;
    exports org.databasequeries;
}