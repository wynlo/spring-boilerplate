package com.wynlo.controller;

import com.wynlo.example.ExampleAPI;
import com.wynlo.example.ExampleClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController implements ExampleAPI {

    @Override
    @GetMapping(EXAMPLE_BASE_PATH)
    public ResponseEntity<ExampleClass> exampleGet() {
        return new ResponseEntity<>(new ExampleClass(1, "Hello"), HttpStatus.OK);
    }

    @Override
    @PostMapping(EXAMPLE_BASE_PATH)
    public ResponseEntity<ExampleClass> examplePost() {
        return null;
    }
}
