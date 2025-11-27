package org.databasequeries;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class QueryController {
    private final Builder<Region> viewBuilder;
    private final QueryInteractor interactor;

    public QueryController() {
        QueryModel model = new QueryModel();
        interactor = new QueryInteractor(model);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
