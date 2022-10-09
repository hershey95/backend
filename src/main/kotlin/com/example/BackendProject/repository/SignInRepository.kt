package com.example.BackendProject.repository

import com.example.BackendProject.entity.SignIn
import org.springframework.data.repository.CrudRepository


interface SignInRepository : CrudRepository<SignIn, String>{
    override fun findAll(): List<SignIn> {
        TODO("Not yet implemented")
    }
}