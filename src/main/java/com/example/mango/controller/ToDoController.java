package com.example.mango.controller;


import com.example.mango.domain.dto.ToDoEntityDto;
import com.example.mango.service.IToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private IToDoService toDoService;

    @RequestMapping(value = "/list")
    public List<ToDoEntityDto> index() throws Exception {

        List<ToDoEntityDto> todoList = toDoService.selectTodoList();

        return todoList;
    }


    @RequestMapping(value = "/insert")
    public void insert() throws Exception {
        //insert 시 객체값 json으로 받는다...
        //json으로 받은걸 ...DTO로 만들어서 넣는다.!!
        toDoService.insertTodo();
    }



}
