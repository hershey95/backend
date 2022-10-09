package com.example.BackendProject.entity

import javax.persistence.*

@Entity
class Article {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long

    @ManyToOne
    @JoinColumn(name = "id_article")
    private var email: SignIn

    @Column
    private var content: String

    @Column
    private var title: String

    constructor(id: Long, email: SignIn, content: String, title: String) {
        this.id = id
        this.email = email
        this.content = content
        this.title = title
    }

    fun getid(): String {
        return this.email.getid()
    }
}