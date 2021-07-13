package com.nyrds.platform.gl;

public class Program {
    private int handle;

    public Program() {

    }

    public int handle() {
        return handle;
    }

    public void attach( Shader shader ) {

    }

    public void link() {

    }

    public Attribute attribute(String name ) {
        return null;
    }

    public Uniform uniform(String name ) {
        return null;
    }

    public void use() {

    }

    public void delete() {

    }

    public static Program create( Shader ...shaders ) {
        Program program = new Program();
        for (Shader shader : shaders) {
            program.attach(shader);
        }
        program.link();
        return program;
    }
}
