package com.hb.springboot.service;

import com.hb.springboot.model.ArticleVO;

import java.util.List;

public interface ArticleRestService {

    public ArticleVO saveArticle(ArticleVO article);

    public void deleteArticle(Long id);

    public void updateArticle(ArticleVO article);

    public ArticleVO getArticle(Long id);

    public List<ArticleVO> getAll();
}