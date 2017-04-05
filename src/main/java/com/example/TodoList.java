package com.example;


import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoList extends VerticalLayout  implements TodoChangeListener{

    @Autowired
    TodoRepository repository;

    private List<Todo> todos;

    @PostConstruct
    void init() {
        setSpacing(true);
        update();
    }

    private void update() {
        setTodos(repository.findAll());
    }

    private void setTodos(List<Todo> todos) {
        this.todos = todos;
        removeAllComponents();

        todos.forEach(todo -> {
            addComponent(new TodoItemLayout(todo));
        });
    }

    public void save(Todo todo) {
        repository.save(todo);
        update();
    }

    @Override
    public void todoChanged(Todo todo) {
        save(todo);
    }

    public void deleteCompleted() {
        repository.deleteInBatch(
            todos.stream().filter(Todo::isDone).collect(Collectors.toList())
        );

        update();
    }
}
