package dev.w0fv1.hello.spring;

public class Hellor {

    private final String content;

    public Hellor(String content) {
        this.content = content;
    }

    public void say() {
        System.out.println("Hello, " + content + "!");
    }
}
