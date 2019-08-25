package com.hb.springboot;

import com.hb.springboot.controller.ArticleRestController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@Slf4j
@SpringBootTest
public class ArticleRestControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
    }

    @Test
    public void saveArticle() throws Exception {

    }

}
