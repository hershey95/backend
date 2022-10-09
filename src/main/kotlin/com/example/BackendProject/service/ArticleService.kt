package com.example.BackendProject.service

import com.example.BackendProject.dto.ArticleForm
import com.example.BackendProject.entity.Article
import com.example.BackendProject.entity.SignIn
import com.example.BackendProject.repository.ArticleRepository
import com.example.BackendProject.repository.SignInRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ArticleService {
    @Autowired
    private lateinit var articleRepository: ArticleRepository

    @Autowired
    private lateinit var signInRepository: SignInRepository

    fun create(dto: ArticleForm): Article {
        var article:Article = dto.toEntity()

        var target: SignIn = signInRepository.findById(article.getid()).orElse(null)

        return articleRepository.save(article)
    }


}