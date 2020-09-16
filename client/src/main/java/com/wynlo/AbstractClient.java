package com.wynlo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class AbstractClient {

    private String port;
    private TestRestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public AbstractClient(String port, TestRestTemplate restTemplate) {
        this.port = port;
        this.restTemplate = restTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public TestRestTemplate getRestTemplate() {
        return restTemplate;
    }

    public ObjectMapper getObjectMapper() { return objectMapper; }

    public String constructUrl(String path) {
        return "http://localhost:" + port + path;
    }

    public HttpHeaders createHeaders(String bearerToken) {
        return new HttpHeaders() {{
            set("Authorization", bearerToken);
            setContentType(MediaType.APPLICATION_JSON);
        }};
    }


}
