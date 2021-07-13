package com.nyrds.platform.gl;

import android.graphics.Bitmap;

public class Texture {

    // TODO: OpenGL constants, lets see how to implement it
    // We have textures already in libgdx, let's implement stuff from LIBGDX to our little app here
    public static final int NEAREST	= 0;
    public static final int LINEAR	= 0;

    public static final int REPEAT	= 0;
    public static final int MIRROR	= 0;
    public static final int CLAMP	= 0;

    protected int id;

    public static void activate( int index ) {
    }

    public void bind() {

    }

    public void filter( int minMode, int maxMode ) {
        bind();

    }

    public void wrap( int s, int t ) {
        bind();

    }

    public void delete() {
        int[] ids = {id};

    }

    public void pixels( int w, int h, int[] pixels ) {


    }

    public void pixels( int w, int h, byte[] pixels ) {

    }



    public static Texture create( int width, int height, int[] pixels ) {
        Texture tex = new Texture();
        tex.pixels( width, height, pixels );

        return tex;
    }

    public static Texture create( int width, int height, byte[] pixels ) {
        Texture tex = new Texture();
        tex.pixels( width, height, pixels );

        return tex;
    }

    public int getId() {
        return id;
    }

    protected void bitmap(Bitmap bitmap) {
    }
}
