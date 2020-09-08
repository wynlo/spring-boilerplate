package com.wynlo.api;

import com.wynlo.models.Example;
import org.springframework.http.ResponseEntity;

public interface ExampleAPI {

    ResponseEntity exampleGet(
            // String Authorization,
            String id
    );

    ResponseEntity exampleGetAll(
            // String Authorization
    );

    ResponseEntity examplePost(
            // String Authorization,
            Example example
    );

    ResponseEntity exampleDelete(
//            String Authorization,
            String id
    );

    String EXAMPLE_VERSION = "/v1";
    String EXAMPLE_BASE_PATH = EXAMPLE_VERSION + "/example";
    String EXAMPLE_GET_PATH = EXAMPLE_BASE_PATH + "/{id}";
    String EXAMPLE_DELETE_PATH = EXAMPLE_BASE_PATH + "/{id}";

    String[] EXAMPLE_PATHS_SECURE = new String[] {
//            EXAMPLE_BASE_PATH,
//            EXAMPLE_GET_PATH,
//            EXAMPLE_DELETE_PATH
    };

}
