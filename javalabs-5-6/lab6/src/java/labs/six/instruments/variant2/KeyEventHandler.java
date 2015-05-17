package labs.six.instruments.variant2;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * Created by thecat on 22.02.15.
 */
public class KeyEventHandler implements EventHandler<KeyEvent> {

    final Game game;

    public KeyEventHandler(Game game) {
        this.game = game;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        System.out.println("pressed key '"+ (keyEvent.isControlDown() ? "CTRL + " : "") + (keyEvent.isAltDown() ? KeyCode.ALT + " + "  : "") + keyEvent.getCode()+ "'");
    }

}
