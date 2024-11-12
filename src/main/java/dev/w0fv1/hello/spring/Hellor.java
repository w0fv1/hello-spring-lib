package dev.w0fv1.hello.spring;

import org.springframework.stereotype.Component;

public class Hellor {

    private final HellorProperties hellorProperties;

    public Hellor(HellorProperties hellorProperties) {
        this.hellorProperties = hellorProperties;
    }

    public void say() {
        System.out.println("Hello, " + hellorProperties.getContent() + "!");
    }
}
