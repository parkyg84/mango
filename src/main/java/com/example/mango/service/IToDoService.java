package com.example.mango.service;
import com.example.mango.domain.dto.ToDoEntityDto;
import java.util.List;

public interface IToDoService {

    List<ToDoEntityDto> selectTodoList() throws Exception;
    void insertTodo() throws Exception;
    void insertTodo(ToDoEntityDto dto) throws Exception;

    //하나만 특정조회
    //예외처리 모두 정리!!
}
