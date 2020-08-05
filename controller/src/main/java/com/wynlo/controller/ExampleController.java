package com.wynlo.controller;

import com.wynlo.example.ExampleAPI;
import com.wynlo.example.Example;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wynlo.example.ExampleAPI.EXAMPLE_VERSION;

@RestController
@RequestMapping(EXAMPLE_VERSION)
public class ExampleController implements ExampleAPI {

    @GetMapping("/")
    public ResponseEntity<String> helloWorld(
            @NotNull @RequestHeader String Authorization
    ) {
        return ResponseEntity.ok("Hello World");
    }

    @Override
    @GetMapping(EXAMPLE_BASE_PATH)
    public ResponseEntity<Example> exampleGet(
            @NotNull @RequestHeader String Authorization
    ) {
        return ResponseEntity.ok(new Example(1, "Hello"));
    }

    @Override
    @PostMapping(EXAMPLE_BASE_PATH)
    public ResponseEntity<Example> examplePost() {
        return null;
    }
}
