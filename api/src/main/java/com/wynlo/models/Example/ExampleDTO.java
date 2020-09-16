package com.wynlo.models.Example;

import com.wynlo.models.DTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class ExampleDTO implements Serializable, DTO {

    @NotNull
    private String name;

    /** For deserialization */
    public ExampleDTO() {}

    public ExampleDTO(String name) {
        this.name = name;
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
        ExampleDTO that = (ExampleDTO) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "ExampleDTO{" +
                "name='" + name + '\'' +
                '}';
    }

    public Example toTrueClass() {
        return new Example(
                UUID.randomUUID().toString(),
                this.name
        );
    }


}
