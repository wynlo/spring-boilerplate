package com.wynlo;

import com.mongodb.client.result.DeleteResult;
import com.wynlo.models.Example.Example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.wynlo.api.ExampleAPI;
import com.wynlo.models.Example.ExampleDTO;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class ExampleClient extends AbstractClient implements ExampleAPI {

    public ExampleClient(String port, TestRestTemplate restTemplate) {
        super(port, restTemplate);
    }

    @Override
    public ResponseEntity<Example> exampleGet(String Authorization, String id) {
        return getRestTemplate().exchange(
                constructUrl(EXAMPLE_BASE_PATH + "/" + id),
                HttpMethod.GET,
                new HttpEntity(createHeaders(Authorization)),
                Example.class
        );
    }

    @Override
    public ResponseEntity<ArrayList<Example>> exampleGetAll(String Authorization) {
        return getRestTemplate().exchange(
                constructUrl(EXAMPLE_BASE_PATH),
                HttpMethod.GET,
                new HttpEntity(createHeaders(Authorization)),
                new ParameterizedTypeReference<ArrayList<Example>>() {}
        );
    }

    @Override
    public ResponseEntity<Example> examplePost(String Authorization, ExampleDTO exampleDTO) throws JsonProcessingException {
        String request = getObjectMapper().writeValueAsString(exampleDTO);
        return getRestTemplate().exchange(
                constructUrl(EXAMPLE_BASE_PATH),
                HttpMethod.POST,
                new HttpEntity(request, createHeaders(Authorization)),
                Example.class
        );
    }

    @Override
    public ResponseEntity<String> exampleDelete(String Authorization, String id) {
        return getRestTemplate().exchange(
                constructUrl(EXAMPLE_BASE_PATH + "/" + id),
                HttpMethod.DELETE,
                new HttpEntity(createHeaders(Authorization)),
                String.class
        );
    }

    @Override
    public ResponseEntity<Example> exampleUpdate(String Authorization, Example example) throws JsonProcessingException {
        String request = getObjectMapper().writeValueAsString(example);
        return getRestTemplate().exchange(
                constructUrl(EXAMPLE_BASE_PATH),
                HttpMethod.POST,
                new HttpEntity(request, createHeaders(Authorization)),
                Example.class
        );
    }

}
