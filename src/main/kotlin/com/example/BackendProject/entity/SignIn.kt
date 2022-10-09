package com.example.BackendProject.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class SignIn {

    @Id
    private var email: String

    @Column
    private var password: String

    @Column
    private var username: String

    constructor(email: String, password: String, username: String) {
        this.email = email
        this.password = password
        this.username = username
    }

    override fun toString(): String {

        return "SignIn(email='$email', username='$username')"
    }

    fun getid(): String {
        return this.email
    }

    fun is_password(signin: SignIn): Boolean {
        return this.password == signin.password

    }

    fun patch(signin: SignIn) {
        this.email = signin.email
        this.password = signin.password
        this.username = signin.username
    }

}