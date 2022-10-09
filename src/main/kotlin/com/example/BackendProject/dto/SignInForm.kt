package com.example.BackendProject.dto

import com.example.BackendProject.entity.SignIn

class SignInForm {

    private var email: String
    private var password: String
    private var username: String

    constructor(email: String, password: String, username: String) {
        this.email = email
        this.password = password
        this.username = username
    }

    override fun toString(): String {
        return "SignInForm(email='$email', password='$password', username='$username')"
    }

    public fun toEntity(): SignIn{
        return SignIn(email, password, username)
    }
}