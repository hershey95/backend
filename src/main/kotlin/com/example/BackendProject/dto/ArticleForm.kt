package com.example.BackendProject.dto

import com.example.BackendProject.entity.Article
import com.example.BackendProject.entity.SignIn

class ArticleForm {


    private var id: Long
    private var email: SignIn
    private var content: String
    private var title: String

    constructor(id: Long, email: SignIn, content: String, title: String) {
        this.id = id
        this.email = email
        this.content = content
        this.title = title
    }

    public fun toEntity(): Article{
        return Article(id,email,content,title)
    }

}