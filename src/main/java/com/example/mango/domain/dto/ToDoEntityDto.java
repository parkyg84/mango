package com.example.mango.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Data
public class ToDoEntityDto implements Serializable{

//    @JsonProperty("seq_no")
    private Long seq_no;

//    @JsonProperty("memo")
    private String memo;

//    @JsonProperty("reg_user")
    private String reg_user;

//    @JsonProperty("reg_date")
    private Date reg_date;

}
