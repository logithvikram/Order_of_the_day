package com.example.spring_curd.Exception;

public class Todoexception extends Exception{
    /**
     *
     */
   private static final long serialVersionUID = 1L;
    public Todoexception(String message){
        super(message);
    }
    public static String NotFoundException(String Id){
        return "Todo with"+Id+"Not found ";
    }
    public static String TodoalreadyExist(){
        return "Todo with given name already exits";
    }
}
