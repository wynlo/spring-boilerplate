package com.wynlo.services;

import com.mongodb.client.result.DeleteResult;
import com.wynlo.dao.Example.ExampleDAO;
import com.wynlo.models.Example.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {

    private final ExampleDAO exampleDAO;

    @Autowired
    public ExampleService(@Qualifier("mongoDAO") ExampleDAO exampleDAO) {
        this.exampleDAO = exampleDAO;
    }

    public Example addExample(Example example) {
        return exampleDAO.insertExample(example);
    }

    public Example getExample(String id) {
        return exampleDAO.selectExampleById(id);
    }

    public List<Example> getAllExamples() {
        return exampleDAO.selectAllExamples();
    }

    public DeleteResult deleteExample(String id) {
        return exampleDAO.deleteExampleById(id);
    }

    public Example updateExample(Example example) { return exampleDAO.updateExample(example); }

}