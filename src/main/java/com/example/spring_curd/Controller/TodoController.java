package com.example.spring_curd.Controller;

import com.example.spring_curd.Exception.Todoexception;
import com.example.spring_curd.model.Todomodel;
import com.example.spring_curd.repo.Todorepo;
import com.example.spring_curd.service.Todoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {
    @Autowired
    private Todorepo todorepo;
    @Autowired
    private Todoservice todoservice;

     @GetMapping("/todos")
    public ResponseEntity<?> getallTodos(){
        List<Todomodel> todos = todoservice.getAllTodos();
        return new ResponseEntity<>(todos,todos.size() > 0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
    @PostMapping("/todos")
    public ResponseEntity<?> createtodo(@RequestBody Todomodel todo){
    try{
      todoservice.Createtodo(todo);
      return new ResponseEntity<Todomodel>(todo,HttpStatus.OK);
    }catch(ConstraintViolationException e){

    return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
    }
    catch (Todoexception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
    }
    }
    @GetMapping("/todos/{id}")
    public ResponseEntity<?> getsingletodo(@PathVariable("id") String id){
        try{
          return new ResponseEntity<>(todoservice.getsingletodo(id),HttpStatus.OK);
        }catch (Exception e){
         return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

        @PutMapping("/todos/{id}")
        public ResponseEntity<?> updatebyid(@PathVariable("id") String id,@RequestBody Todomodel todo){
            try{
                todoservice.updateTodo(id,todo);
                return new ResponseEntity<>("Update todo with id "+ id,HttpStatus.OK);
            }catch(ConstraintViolationException e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
            }catch (Todoexception e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
            }
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deletebyid(@PathVariable("id") String id ){
        try{
             todoservice.deletebyid(id);
         return new ResponseEntity<>("Sucessfully deleted with id "+ id,HttpStatus.OK);
        }catch(Todoexception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}
