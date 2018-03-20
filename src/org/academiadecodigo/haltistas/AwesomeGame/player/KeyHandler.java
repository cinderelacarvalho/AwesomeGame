package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyHandler implements KeyboardHandler {

    private PlayerNetwork player;

    KeyHandler(PlayerNetwork player) {

        this.player = player;

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_UP);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);
    }


    //TODO delete souts
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                System.out.println("UP");
                player.sendMsg("up");
                break;

            case KeyboardEvent.KEY_DOWN:
                System.out.println("down");
                player.sendMsg("down");
                break;

            case KeyboardEvent.KEY_LEFT:
                System.out.println("left");
                player.sendMsg("left");
                break;

            case KeyboardEvent.KEY_RIGHT:
                System.out.println("right");
                player.sendMsg("right");
                break;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
