package com.wynlo.example;

import org.springframework.http.ResponseEntity;

public interface ExampleAPI {

    ResponseEntity<ExampleClass> getExample();
    ResponseEntity<ExampleClass> postExample();

    String EXAMPLE_BASE_PATH = "/example";
    String EXAMPLE_BASE_PATH_HELLO_WORLD = EXAMPLE_BASE_PATH + "/hello";

}
