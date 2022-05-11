package com.example.mango.service;

import com.example.mango.domain.dto.ToDoEntityDto;
import com.example.mango.domain.entity.ToDoEntity;
import com.example.mango.domain.repository.ToDoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//매퍼 처리용!!
//https://auth0.com/blog/how-to-automatically-map-jpa-entities-into-dtos-in-spring-boot-using-mapstruct/
//https://dev-splin.github.io/spring/Spring-ModelMapper,MapStruct/
//https://velog.io/@kimview/ModelMapper
//http://modelmapper.org/
//https://yjh5369.tistory.com/entry/JPA-Entity-to-DTO-ModelMapper

//여기요
//https://dbbymoon.tistory.com/4   <---여기 자세히 읽어볼것!!
//https://oingdaddy.tistory.com/350

//dto 빌드패턴
//https://devfunny.tistory.com/409
@Service
public class ToDoServiceImpl implements IToDoService{

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ToDoEntityDto> selectTodoList() throws Exception {

        List<ToDoEntity> entityList = this.toDoRepository.findAll();

        List<ToDoEntityDto> list = entityList
                            .stream()
                            .map(entity -> modelMapper.map(entity, ToDoEntityDto.class))
                            .collect(Collectors.toList());
        return list;
    }

    @Override
    public void insertTodo() throws Exception {
        //디비 접속 등록

        ToDoEntityDto dto = new ToDoEntityDto();
        dto.setMemo("hello");
        dto.setReg_user("parkyg84");
        dto.setReg_date(new Date());


        ToDoEntity entity = new ToDoEntity.ToDoEntityBuilder(dto).build();

        this.toDoRepository.save(entity);
    }

    @Override
    public void insertTodo(ToDoEntityDto dto) throws Exception {

        ToDoEntity entity = new ToDoEntity.ToDoEntityBuilder(dto).build();

        this.toDoRepository.save(entity);
    }
}
