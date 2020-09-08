package com.wynlo.controllers;

import com.mongodb.client.result.DeleteResult;
import com.wynlo.models.Example;
import com.wynlo.api.ExampleAPI;
import com.wynlo.wrappers.ResponseEntityModelWrapper;
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
    @GetMapping(EXAMPLE_GET_PATH)
    public ResponseEntity exampleGet(
            // @RequestHeader String Authorization,
            @PathVariable("id") String id
    ) {
        Example example = exampleService.getExample(id);
        return ResponseEntity.ok(
                ResponseEntityModelWrapper.build(example)
        );
    }

    @Override
    @GetMapping(EXAMPLE_BASE_PATH)
    public ResponseEntity exampleGetAll() {
        List<Example> exampleList = exampleService.getAllExamples();
        return ResponseEntity.ok(
                ResponseEntityModelWrapper.build(exampleList)
        );
    }

    @Override
    @PostMapping(EXAMPLE_BASE_PATH)
    public ResponseEntity examplePost(
            // @RequestHeader String Authorization,
            @Valid @RequestBody Example example
    ) {
        Example newExample = exampleService.addExample(example);
        return ResponseEntity.ok(
                ResponseEntityModelWrapper.build(newExample)
        );
    }

    @Override
    @DeleteMapping(EXAMPLE_DELETE_PATH)
    public ResponseEntity exampleDelete(
            // @RequestHeader String Authorization,
            @PathVariable("id") String id
    ) {
        DeleteResult deleteResult = exampleService.deleteExample(id);
        return ResponseEntity.ok(
                ResponseEntityModelWrapper.build(deleteResult)
        );
    }


}
