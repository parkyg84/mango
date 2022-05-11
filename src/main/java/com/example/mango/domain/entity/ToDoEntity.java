package com.example.mango.domain.entity;


import com.example.mango.domain.dto.ToDoEntityDto;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@ToString
@Getter
@Entity
@Table(name="todo")
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToDoEntity {

    @Id
    @GeneratedValue
    private Long seq_no;
    private String memo;
    private String reg_user;
    private Date reg_date;

    private ToDoEntity(ToDoEntityBuilder builder) {
        this.seq_no = builder.seq_no;
        this.memo = builder.memo;
        this.reg_user = builder.reg_user;
        this.reg_date = builder.reg_date;
    }

    public ToDoEntity(){};


    public static class ToDoEntityBuilder implements CommonBuilder<ToDoEntity> {
        private Long seq_no;
        private String memo;
        private String reg_user;
        private Date reg_date;

        /* 생성자 */
        public ToDoEntityBuilder(ToDoEntityDto dto) {
            this.seq_no = dto.getSeq_no();
            this.memo = dto.getMemo();
            this.reg_user = dto.getReg_user();
            this.reg_date = dto.getReg_date();
        }

        /* build 메소드 호출로 Users 객체 리턴 */
        @Override
        public ToDoEntity build(){
            return new ToDoEntity(this);
        }
    }
}
