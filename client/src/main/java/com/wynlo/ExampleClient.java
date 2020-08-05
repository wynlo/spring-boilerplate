package com.wynlo;

import com.wynlo.example.ExampleAPI;
import com.wynlo.example.Example;
import org.springframework.http.ResponseEntity;

public class ExampleClient extends AbstractClient implements ExampleAPI {

    @Override
    public ResponseEntity<Example> exampleGet(String Authorization) {
        return this.getRestTemplate().getForEntity(
                this.getHostname() + EXAMPLE_BASE_PATH,
                Example.class
        );
    }

    @Override
    public ResponseEntity<Example> examplePost() {
        return null;
    }
}
