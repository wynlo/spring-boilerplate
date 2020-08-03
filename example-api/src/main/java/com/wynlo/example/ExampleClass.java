package com.wynlo.example;

import javax.validation.constraints.NotNull;

public class ExampleClass {

    public ExampleClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @NotNull
    private int id;

    @NotNull
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
