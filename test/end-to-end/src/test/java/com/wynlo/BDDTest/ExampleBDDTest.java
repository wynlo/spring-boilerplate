package com.wynlo.BDDTest;

import com.wynlo.ExampleClient;
import com.wynlo.TestToken;
import com.wynlo.controllers.ExampleController;
import com.wynlo.dao.Example.ExampleDAO;
import com.wynlo.models.Example.Example;
import com.wynlo.models.Example.ExampleDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext
public class ExampleBDDTest {

    @LocalServerPort
    private String port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ExampleController exampleController;

    @Autowired
    private ExampleDAO exampleDAO;

    @Test
    /** Sanity Check 1 */
    public void contextLoads() {
    }

    @Test
    /** Sanity Check 2 */
    public void controllerLoads() {
        assertThat(exampleController).isNotNull();
    }

    @Test
    /** Sanity Check 3 */
    public void daoLoads() {
        assertThat(exampleDAO).isNotNull();
    }

    private ExampleClient exampleClient;

    @BeforeEach
    void init() {
        exampleClient = new ExampleClient(port, restTemplate);
    }

    @AfterEach
    void cleanUp() {
        exampleDAO.deleteAllExamples();
    }

    @Test
    public void postExampleIsSuccessful() throws Exception {
        ResponseEntity<Example> postResponse = exampleClient.examplePost(TestToken.TEST_TOKEN, new ExampleDTO("A"));
        assertEquals(postResponse.getStatusCodeValue(), 200);
    }

    @Test
    public void successfullyGetAfterPostExample() throws Exception {
        ResponseEntity<Example> postResponse = exampleClient.examplePost(TestToken.TEST_TOKEN, new ExampleDTO("A"));
        ResponseEntity<Example> getResponse = exampleClient.exampleGet(TestToken.TEST_TOKEN, postResponse.getBody().getId());
        assertEquals(getResponse.getStatusCodeValue(), 200);
        assertThat(getResponse.getBody().equals(new Example(postResponse.getBody().getId(), "A")));
    }

    @Test
    public void successfullyGetAllAfterPostExamples() throws Exception {
        exampleClient.examplePost(TestToken.TEST_TOKEN, new ExampleDTO("A"));
        exampleClient.examplePost(TestToken.TEST_TOKEN, new ExampleDTO("B"));
        ResponseEntity<ArrayList<Example>> getAllResponse = exampleClient.exampleGetAll(TestToken.TEST_TOKEN);
        assertEquals(getAllResponse.getStatusCodeValue(), 200);
        assertEquals(getAllResponse.getBody().size(), 2);
    }

    @Test
    public void successfullyDeleteExample() throws Exception {
        ResponseEntity<Example> postResponse = exampleClient.examplePost(TestToken.TEST_TOKEN, new ExampleDTO("A"));
        ResponseEntity<String> deleteResponse = exampleClient.exampleDelete(TestToken.TEST_TOKEN, postResponse.getBody().getId());
        assertEquals(deleteResponse.getStatusCodeValue(), 200);
        assertEquals(deleteResponse.getBody(), "{\"deletedCount\":1}");
        assertEquals(exampleDAO.selectAllExamples().size(), 0);
    }

    @Test
    public void successfullyUpdateExample() throws Exception {
        ResponseEntity<Example> postResponse = exampleClient.examplePost(TestToken.TEST_TOKEN, new ExampleDTO("A"));
        ResponseEntity<Example> updateResponse = exampleClient.exampleUpdate(
                TestToken.TEST_TOKEN,
                new Example(postResponse.getBody().getId(),"B")
        );
        assertEquals(updateResponse.getStatusCodeValue(), 200);
        assertThat(updateResponse.getBody().equals(
                new Example(postResponse.getBody().getId(), "B"))
        );
        assertThat(exampleDAO.selectExampleById(postResponse.getBody().getId()).equals(
                new Example(postResponse.getBody().getId(), "B"))
        );
    }

}
