package labs.six.instruments.variant2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("2048");
        Game game = new Game();
        primaryStage.setScene(game.main);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
