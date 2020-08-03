package com.wynlo;

import com.wynlo.example.ExampleAPI;
import com.wynlo.example.ExampleClass;
import org.springframework.http.ResponseEntity;

public class ExampleClient extends AbstractClient implements ExampleAPI {

    @Override
    public ResponseEntity<ExampleClass> exampleGet() {
        return this.getRestTemplate().getForEntity(
                this.getHostname() + EXAMPLE_BASE_PATH,
                ExampleClass.class
        );
    }

    @Override
    public ResponseEntity<ExampleClass> examplePost() {
        return null;
    }
}
