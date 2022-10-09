package com.example.BackendProject.api

import com.example.BackendProject.dto.ArticleForm
import com.example.BackendProject.dto.SignInForm
import com.example.BackendProject.entity.Article
import com.example.BackendProject.entity.SignIn
import com.example.BackendProject.service.ArticleService
import com.example.BackendProject.service.SignInService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController {
    @Autowired
    private lateinit var articleService: ArticleService


    @PostMapping("/api/articles")
    public fun create(@RequestBody dto: ArticleForm): ResponseEntity<Article> {
        var created: Article = articleService.create(dto)

        return ResponseEntity.status(HttpStatus.OK).body(created)
    }



}