package com.example.spring_curd.repo;

import com.example.spring_curd.model.Todomodel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Todorepo extends MongoRepository<Todomodel,String> {
    @Query("{'todo':?0}")
    Optional<Todomodel> findbyTodo(String todo);
}
