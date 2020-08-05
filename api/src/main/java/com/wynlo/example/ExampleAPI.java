package com.wynlo.example;

import org.springframework.http.ResponseEntity;

public interface ExampleAPI {

    ResponseEntity<Example> exampleGet(String Authorization);
    ResponseEntity<Example> examplePost();

    String EXAMPLE_VERSION = "/v1";
    String EXAMPLE_BASE_PATH = "/example";

}
