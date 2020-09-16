package com.wynlo.controllers;

import com.wynlo.models.Example.Example;
import com.mongodb.client.result.DeleteResult;
import com.wynlo.api.ExampleAPI;
import com.wynlo.models.Example.ExampleDTO;
import com.wynlo.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ExampleController implements ExampleAPI {

    private final ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @Override
    @GetMapping(EXAMPLE_PATH_WITH_ID)
    public ResponseEntity<Example> exampleGet(
            @RequestHeader String Authorization,
            @PathVariable("id") String id
    ) {
        Example example = exampleService.getExample(id);
        return ResponseEntity.ok(example);
    }

    @Override
    @GetMapping(EXAMPLE_BASE_PATH)
    public ResponseEntity<List<Example>> exampleGetAll(
            @RequestHeader String Authorization
    ) {
        List<Example> exampleList = exampleService.getAllExamples();
        return ResponseEntity.ok(exampleList);
    }

    @Override
    @PostMapping(EXAMPLE_BASE_PATH)
    public ResponseEntity<Example> examplePost(
            @RequestHeader String Authorization,
            @Valid @RequestBody ExampleDTO exampleDTO
    ) {
        Example newExample = exampleService.addExample(exampleDTO.toTrueClass());
        return ResponseEntity.ok(newExample);
    }

    @Override
    @DeleteMapping(EXAMPLE_PATH_WITH_ID)
    public ResponseEntity<DeleteResult> exampleDelete(
            @RequestHeader String Authorization,
            @PathVariable("id") String id
    ) {
        DeleteResult deleteResult = exampleService.deleteExample(id);
        return ResponseEntity.ok(deleteResult);
    }

    @Override
    @PostMapping(EXAMPLE_PATH_WITH_ID)
    public ResponseEntity<Example> exampleUpdate(
            @RequestHeader String Authorization,
            @Valid @RequestBody Example example
    ) {
        Example newExample = exampleService.updateExample(example);
        return ResponseEntity.ok(newExample);
    }


}
