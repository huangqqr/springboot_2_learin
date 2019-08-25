package com.hb.springboot.service.impl;

import com.hb.springboot.dao.ArticleJDBCDAO;
import com.hb.springboot.model.ArticleVO;
import com.hb.springboot.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleRestMaxJDBCServiceImpl implements ArticleRestService {

    @Resource
    ArticleJDBCDAO articleJDBCDAO;

    @Resource
    JdbcTemplate primaryJdbcTemplate;

    @Resource
    JdbcTemplate secondaryJdbcTemplate;


    @Transactional
    @Override
    public ArticleVO saveArticle(ArticleVO article) {

        articleJDBCDAO.save(article,primaryJdbcTemplate);

        articleJDBCDAO.save(article,secondaryJdbcTemplate);

        return  article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id,primaryJdbcTemplate);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        articleJDBCDAO.updateById(article,primaryJdbcTemplate);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        return  articleJDBCDAO.findById(id,primaryJdbcTemplate);

    }

    @Override
    public List<ArticleVO> getAll() {
        return articleJDBCDAO.findAll(primaryJdbcTemplate);
    }
}

