package client.models;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class UniversalLocalizationModel {


    private void addAllDescendents (Parent parent, ArrayList<Node> nodes) {
        for (Node node : parent.getChildrenUnmodifiable( )) {
            if (!nodes.contains(node)) {
                nodes.add(node);
                if (node instanceof Parent) {
                    if (!((Parent) node).getChildrenUnmodifiable( ).isEmpty( )) {
                        addAllDescendents((Parent) node, nodes);
                    }
                }
            }
        }

    }


    public void changeLanguage (Parent root, ResourceBundle bundle) {
        ArrayList<Node> nodes = new ArrayList<>( );
        addAllDescendents(root, nodes);
        nodes.add(root);
        int i = 0;
        for (Node node : nodes) {
            try {
                if ((node instanceof Labeled) & (node != null) & !(node instanceof Cell)) {
                    ((Labeled) node).setText(bundle.getString(node.getId( )));
                }

                if (node instanceof TableView) {
                    for (Object columns : ((TableView) node).getColumns( )) {
                        TableColumn<?, ?> column = (TableColumn) columns;
                        column.setText(bundle.getString(column.getId( )));
                    }
                }

                if (node instanceof TabPane) {
                    for (Tab tab : ((TabPane) node).getTabs( )) {
                        tab.setText(bundle.getString(tab.getId( )));

                    }
                }
            } catch (NullPointerException | MissingResourceException  ex) {
            }
        }

    }

    public void updateLabels(Labeled labeled, String example, ResourceBundle bundle) {
        try {
            labeled.setText(bundle.getString(example));
        } catch (MissingResourceException | NullPointerException ex) {

        }
    }

}
