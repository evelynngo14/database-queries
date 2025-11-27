package org.databasequeries;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.Builder;
import java.util.Objects;

public class QueryViewBuilder  {
    public static Region ShowGridPane() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(new Label("Database Queries"), 0, 0);
        pane.add(new Label("Add Query"), 1, 0);
        pane.add(new TextField(), 1, 1);
        Button btAdd = new Button("Add Query");
        pane.add(btAdd, 1, 2);
        pane.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/css/customer.css")).toExternalForm());
        return pane;
    }

    private Pane listView() {
        BorderPane pane = new BorderPane();
        ScrollPane scrollPane = ShowGridPane();
        ListView<String> listView = new ListView<>();
        listView.setPrefSize(400, 400);
        listView.getSelectionModel();

        pane.setLeft(new ScrollPane(listView));
    }

    private Node textField(StringProperty property) {
        TextField textField = new TextField();
        return textField;
    }

    private Node textArea() {
        VBox results = new VBox();
        return results;
    }

    private Node createButton() {
        VBox results = new VBox();
        return results;
    }
}
