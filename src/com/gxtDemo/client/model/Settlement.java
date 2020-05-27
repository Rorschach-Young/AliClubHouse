package com.gxtDemo.client.model;

public class Settlement {
    private String name;

    public Settlement() {
    }

    public Settlement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Settlement{" +
                "name='" + name + '\'' +
                '}';
    }
}
