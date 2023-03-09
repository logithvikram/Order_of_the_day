package com.example.spring_curd.service;

import com.example.spring_curd.Exception.Todoexception;
import com.example.spring_curd.model.Todomodel;
import com.example.spring_curd.repo.Todorepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Todoserviceimple implements Todoservice    {
    @Autowired
    private Todorepo todorepo;
    @Override
    public void Createtodo(Todomodel todo)throws ConstraintViolationException,Todoexception {
        Optional<Todomodel> todoOptional = todorepo.findbyTodo(todo.getTodo());
        if(todoOptional.isPresent()){
            throw new Todoexception(Todoexception.TodoalreadyExist());
        }
        else{
         todo.setCreatedAt(new Date(System.currentTimeMillis()));
         todorepo.save(todo);
        }
    }

    @Override
    public List<Todomodel> getAllTodos(){
      List<Todomodel> todos =  todorepo.findAll();
      if(todos.size() >0){
          return todos;
      }
      else{
          return new ArrayList<Todomodel>();
      }
    }
    @Override
   public Todomodel getsingletodo(String id)throws Todoexception{
        Optional<Todomodel> OptionalTodo = todorepo.findById(id);
        if(!OptionalTodo.isPresent()){
            throw new Todoexception(Todoexception.NotFoundException(id));
        }else{
            return OptionalTodo.get();
        }
   }
   @Override
    public void updateTodo(String id,Todomodel todo)throws Todoexception{
    Optional<Todomodel> todowithid = todorepo.findById(id);
    Optional<Todomodel> todowithsame = todorepo.findbyTodo(todo.getTodo());
    if(todowithid.isPresent()){
        if(todowithid.isPresent() && !todowithsame.get().getId().equals(id)){
            throw new Todoexception(Todoexception.TodoalreadyExist());

        }
        Todomodel todotoupdate = todowithid.get();
        todotoupdate.setTodo(todo.getTodo());
        todotoupdate.setDesc(todo.getDesc());
        todotoupdate.setCompleted(todo.getCompleted());
        todotoupdate.setUpdateAt(new Date(System.currentTimeMillis()));
        todorepo.save(todotoupdate);

    }else{
        throw new Todoexception(Todoexception.NotFoundException(id));
    }
    }
    @Override
    public void deletebyid(String id)throws Todoexception{
        Optional<Todomodel> todooptional = todorepo.findById(id);
        if(!todooptional.isPresent()){
            throw new Todoexception(Todoexception.NotFoundException(id));
        }else{
            todorepo.deleteById(id);
        }
    }





}
