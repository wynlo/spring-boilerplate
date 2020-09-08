package com.wynlo.dao;

import com.mongodb.client.result.DeleteResult;
import com.wynlo.models.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndReplaceOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

// https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo-template.save-update-remove

@Repository
public class MongoExampleDataAccessService implements ExampleDAO {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoExampleDataAccessService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Example insertExample(Example example) {
        mongoTemplate.insert(example);
        return example;
    }

    @Override
    public List<Example> selectAllExamples() {
        return mongoTemplate.findAll(Example.class);
    }

    @Override
    public Example selectExampleById(String id) {
        return mongoTemplate.findOne(query(where("id").is(id)), Example.class);
    }

    @Override
    public DeleteResult deleteExampleById(String id) {
        return mongoTemplate.remove(query(where("id").is(id)), Example.class);
    }

    @Override
    public Example updateExample(Example example) {
        return mongoTemplate
                .update(Example.class)
                .matching(query(where("id").is(example.getId())))
                .replaceWith(example)
                .withOptions(FindAndReplaceOptions.options().upsert())
                .as(Example.class)
                .findAndReplaceValue();
    }
}
