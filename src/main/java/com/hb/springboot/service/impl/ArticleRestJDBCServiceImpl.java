package com.hb.springboot.service.impl;

import com.hb.springboot.dao.ArticleJDBCDAO;
import com.hb.springboot.model.ArticleVO;
import com.hb.springboot.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleRestJDBCServiceImpl implements ArticleRestService {

    @Resource
    ArticleJDBCDAO articleJDBCDAO;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public ArticleVO saveArticle(ArticleVO article) {

        articleJDBCDAO.save(article,jdbcTemplate);

        return  article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id,jdbcTemplate);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        articleJDBCDAO.updateById(article,jdbcTemplate);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        return  articleJDBCDAO.findById(id,jdbcTemplate);

    }

    @Override
    public List<ArticleVO> getAll() {
        return articleJDBCDAO.findAll(jdbcTemplate);
    }
}
