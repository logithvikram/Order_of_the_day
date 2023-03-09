package com.example.spring_curd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todo")
public class Todomodel {
    @Id
    private String id;
    @NotNull(message = "Todo cannot be null")
    private String todo;
    @NotNull(message = "Description cannot be null")
    private String desc;
    @NotNull(message = "Completed cannot be null")
    private Boolean completed;
    private Date createdAt;
    private Date updateAt;


}
