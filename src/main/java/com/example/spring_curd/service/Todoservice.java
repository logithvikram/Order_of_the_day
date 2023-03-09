package com.example.spring_curd.service;

import com.example.spring_curd.Exception.Todoexception;
import com.example.spring_curd.model.Todomodel;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;


public interface Todoservice {
public void Createtodo(Todomodel todo)throws ConstraintViolationException, Todoexception;
public List<Todomodel> getAllTodos();
public Todomodel getsingletodo(String id) throws Todoexception;
public void updateTodo(String id,Todomodel todo)throws Todoexception;
public void deletebyid(String id)throws Todoexception;
}
