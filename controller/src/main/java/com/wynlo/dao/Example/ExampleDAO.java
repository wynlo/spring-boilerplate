package com.wynlo.dao.Example;

import com.wynlo.models.Example.Example;
import com.mongodb.client.result.DeleteResult;

import java.util.List;

public interface ExampleDAO {

    Example insertExample(Example example);

    List<Example> selectAllExamples();

    Example selectExampleById(String id);

    DeleteResult deleteExampleById(String id);

    DeleteResult deleteAllExamples();

    Example updateExample(Example example);

}
