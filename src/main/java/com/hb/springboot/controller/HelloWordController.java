package com.hb.springboot.controller;

import com.hb.springboot.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWordController {

    @RequestMapping("/hello")
    public ArticleVO hello () {
        //Author author = new Author(1L,"黄博ß");
        ArticleVO author = ArticleVO.builder().id(3L).author("测试").build();
        log.info("测试"+author);
        return author;
    }
}
