package com.example.BackendProject.repository

import com.example.BackendProject.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository :JpaRepository<Article, Long>{

}