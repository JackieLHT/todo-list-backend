package com.oocl.todoList.Repository;
import com.oocl.todoList.Model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String>{
}
