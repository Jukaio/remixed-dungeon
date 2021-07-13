package com.nyrds.platform.input;

import android.view.KeyEvent;

import com.watabou.utils.Signal;

import java.util.ArrayList;

public class Keys {
    public static final int BACK = 0;
    public static final int MENU = 1;
    public static final int VOLUME_UP = 2;
    public static final int VOLUME_DOWN = 3;

    public static Signal<Key> event = new Signal<>(true);

    public static void processTouchEvents(ArrayList<KeyEvent> keyEventsCopy) {
    }

    // TODO: Desktop input processing
    /*public static void processTouchEvents(ArrayList<KeyEvent> events) {

        for (KeyEvent e : events) {

            switch (e.getAction()) {
                case KeyEvent.ACTION_DOWN:
                    event.dispatch(new Key(e.getKeyCode(), true));
                    break;
                case KeyEvent.ACTION_UP:
                    event.dispatch(new Key(e.getKeyCode(), false));
                    break;
            }
        }
    }*/

    public static class Key {

        public int code;
        public boolean pressed;

        public Key( int code, boolean pressed ) {
            this.code = code;
            this.pressed = pressed;
        }
    }
}
