package com.wynlo.example;

import org.springframework.http.ResponseEntity;

public interface ExampleAPI {

    ResponseEntity<ExampleClass> exampleGet();
    ResponseEntity<ExampleClass> examplePost();

    String EXAMPLE_BASE_PATH = "/example";

}
