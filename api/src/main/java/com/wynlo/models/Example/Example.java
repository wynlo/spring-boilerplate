package com.wynlo.models.Example;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class Example implements Serializable {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String name;

    /** For deserialization */
    public Example() {}

    /** For updating existing Example */
    public Example(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    public String toString() {
        return "ExampleClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
