package com.wynlo.example;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class Example implements Serializable {

    public Example(int id, String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Example that = (Example) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ExampleClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
