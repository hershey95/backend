package com.example.BackendProject.api

import com.example.BackendProject.dto.SignInForm
import com.example.BackendProject.entity.SignIn
import com.example.BackendProject.service.SignInService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SignInController {

    @Autowired
    private lateinit var signService: SignInService


    @PostMapping("/api/signin")
    public fun create(@RequestBody dto: SignInForm): Any? {
        var created: SignIn = signService.create(dto)

        return signService.show(created.getid())
    }

    @GetMapping("/api/signin/{email}")
    public fun show(@PathVariable email:String): SignIn? {

        return signService.show(email)
    }

    @PatchMapping("/api/signin/{email}")
    public fun update(@PathVariable email: String, @PathVariable password: String,
                      @RequestBody dto: SignInForm): ResponseEntity<SignIn>{
        var updated: SignIn = signService.update(email,password,dto)
        return ResponseEntity.status(HttpStatus.OK).body(updated)
    }

    @PostMapping("/api/signout")
    public fun delete(@RequestBody dto: SignInForm): ResponseEntity<SignIn>{
        var deleted: SignIn = signService.delete(dto)
        return ResponseEntity.status(HttpStatus.OK).build()
    }


}