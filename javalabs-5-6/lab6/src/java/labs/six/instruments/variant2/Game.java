package labs.six.instruments.variant2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Paint;

/**
 *
 * Created by thecat on 22.02.15.
 */
public class Game{

    final Scene main;
    int [][] field = new int[4][4];
    int [][] fieldOld = new int[4][4];
    VBox visibleField;
    int rSize = 96;
    LabelBuilder lBuilder = LabelBuilder.create().minHeight(rSize).minWidth(rSize).alignment(Pos.CENTER);

    public Game() {

        VBoxBuilder vboxBld = VBoxBuilder.create();
        visibleField = vboxBld.build();
        visibleField.setMinSize(rSize*5, rSize*4);

        SceneBuilder scnBld = SceneBuilder.create();
        scnBld.fill(Paint.valueOf("black"));
        scnBld.stylesheets(Main.class.getResource("game.css").toExternalForm());
        scnBld.height(rSize*5);
        scnBld.width(rSize*4);
        scnBld.onKeyPressed(new KeyEventHandler(this));
        scnBld.root(visibleField);

        paintField();
        visibleField.layout();
        main = scnBld.build();
    }

    /**
     * обновляет видимое поле в соответствии с полем field
     */
    public final void paintField(){
        if(visibleField.getChildren().size() != 0){
            visibleField.getChildren().clear();
        }
        HBoxBuilder hBoxBuilder = HBoxBuilder.create();
        for (byte rows = 0; rows < 4; rows++) {
            HBox line = hBoxBuilder.build();
            for (byte cols = 0; cols < 4; cols++) {
                Label l = field[rows][cols] == 0 ? new Label(): new Label(String.valueOf(field[rows][cols]));
                lBuilder.applyTo(l);
                l.setStyle(".label0 .label");
                line.getChildren().add(l);
            }
            visibleField.getChildren().add(line);
        }
    }

}
