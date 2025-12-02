package org.databasequeries;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.SQLException;

public class QueryView extends Application {

    private QueryController queryController;

    @Override
    public void start(Stage primaryStage) {

        queryController = new QueryController();

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(15));
        pane.setHgap(10);
        pane.setVgap(10);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(80);
        pane.getColumnConstraints().addAll(col1, col2);

        // ui components
        Label inputLabel = new Label("Input Query:");
        TextField queryInput = new TextField();
        queryInput.setPromptText("Enter SELECT, UPDATE, or DELETE query... ");
        GridPane.setHgrow(queryInput, Priority.ALWAYS); // make TextField fill available space

        Button executeButton = new Button("Execute Query");
        executeButton.setMaxWidth(Double.MAX_VALUE);

        Label resultsLabel = new Label("Results");
        TextArea resultsTextArea = new TextArea();
        resultsTextArea.setMinHeight(250);
        resultsTextArea.setEditable(false);
        GridPane.setVgrow(resultsTextArea, Priority.ALWAYS);
        GridPane.setHgrow(resultsTextArea, Priority.ALWAYS);

        // output --> controller
        queryController.setResultsArea(resultsTextArea);

        executeButton.setOnAction(event -> {
            String query = queryInput.getText();
            try {
                queryController.executeQuery(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        // split GridPane

        pane.add(inputLabel, 0, 0);
        pane.add(queryInput, 1, 0);

        pane.add(executeButton, 0,1,2,1);
        pane.add(resultsLabel, 0, 2);
        pane.add(resultsTextArea,0,3,2,1);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Database Queries");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
