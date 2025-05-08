package com.todo.todo_app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // for getter methods
@Setter // for setter methods
@NoArgsConstructor // -> for non parameterized constructor
public class Todo {
    private int id;
    private String task;
    private boolean completed;

}
