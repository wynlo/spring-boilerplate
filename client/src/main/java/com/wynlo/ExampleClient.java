package com.wynlo;

import com.wynlo.api.ExampleAPI;
import com.wynlo.models.Example;
import org.springframework.http.ResponseEntity;

public class ExampleClient extends AbstractClient implements ExampleAPI {

    @Override
    public ResponseEntity exampleGet(
            // String Authorization,
            String id
    ) {
        return null;
    }

    @Override
    public ResponseEntity exampleGetAll(
            // String Authorization
    ) {
        return null;
    }

    @Override
    public ResponseEntity examplePost(
            // String Authorization,
            Example example
    ) {
        return null;
    }

    @Override
    public ResponseEntity exampleDelete(
            // String Authorization
            String id
    ) {
        return null;
    }
}
