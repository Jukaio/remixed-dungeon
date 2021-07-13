package com.nyrds.platform.input;

import android.view.MotionEvent;

import com.watabou.utils.PointF;
import com.watabou.utils.Signal;

import java.util.ArrayList;
import java.util.HashMap;

public class Touchscreen {
    public static Signal<Touch> event = new Signal<>(true);

    public static HashMap<Integer,Touch> pointers = new HashMap<>();

    public static float x;
    public static float y;
    public static boolean touched;

    public static void processTouchEvents(ArrayList<MotionEvent> motionEventsCopy) {
    }

    public static class Touch {
        public PointF start;
        public PointF current;
        public boolean down;

    }
}
