package com.nyrds.platform.gfx;

import com.watabou.noosa.Text;

public class SystemText extends Text {
    public SystemText(String text, float size, boolean b) {
        super(0, 0, 0, 0);
    }

    public SystemText(float v) {
        super(0, 0, 0, 0);
    }

    public static void invalidate() {
    }

    public static void updateFontScale() {
    }

    @Override
    protected void measure() {

    }

    @Override
    public float baseLine() {
        return 0;
    }

    @Override
    public int lines() {
        return 0;
    }
}
