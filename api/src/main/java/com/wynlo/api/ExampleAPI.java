package com.wynlo.api;

import com.wynlo.models.Example.Example;
import com.wynlo.models.Example.ExampleDTO;
import org.springframework.http.ResponseEntity;

public interface ExampleAPI {

    ResponseEntity exampleGet(
             String Authorization,
            String id
    );

    ResponseEntity exampleGetAll(
             String Authorization
    );

    ResponseEntity examplePost(
             String Authorization,
            ExampleDTO exampleDTO
    );

    ResponseEntity exampleDelete(
             String Authorization,
            String id
    );

    ResponseEntity exampleUpdate(
             String Authorization,
            Example example
    );

    String EXAMPLE_VERSION = "/v1";
    String EXAMPLE_BASE_PATH = EXAMPLE_VERSION + "/example";
    String EXAMPLE_PATH_WITH_ID = EXAMPLE_BASE_PATH + "/{id}";

    String[] EXAMPLE_PATHS_SECURE = new String[] {
             EXAMPLE_BASE_PATH,
             EXAMPLE_PATH_WITH_ID
    };

}
