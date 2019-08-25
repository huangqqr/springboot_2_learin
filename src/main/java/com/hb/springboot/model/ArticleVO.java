package com.hb.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

//有参构造方法
@AllArgsConstructor
//get set
@Data
//无参构造方法
//@NoArgsConstructor
@Builder
public class ArticleVO {


    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private List<Reader> reader;

}
