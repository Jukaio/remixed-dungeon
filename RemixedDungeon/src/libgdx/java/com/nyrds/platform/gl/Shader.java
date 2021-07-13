package com.nyrds.platform.gl;

public class Shader {
    public static final int VERTEX		= 0;
    public static final int FRAGMENT	= 0;

    private final int handle;

    public Shader( int type ) {
        handle = 0;
    }

    public int handle() {
        return handle;
    }

    public void source( String src ) {

    }

    public void compile() {

    }

    public void delete() {

    }

    public static Shader createCompiled( int type, String src ) {
        Shader shader = new Shader( type );
        shader.source( src );
        shader.compile();
        return shader;
    }
}
