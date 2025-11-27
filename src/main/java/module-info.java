module org.example.databasequeries {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens org.databasequeries to javafx.fxml;
    exports org.databasequeries;
}