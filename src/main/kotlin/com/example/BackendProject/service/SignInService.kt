package com.example.BackendProject.service

import com.example.BackendProject.dto.SignInForm
import com.example.BackendProject.entity.SignIn
import com.example.BackendProject.repository.SignInRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class SignInService {
    @Autowired
    private lateinit var signInRepository: SignInRepository

    fun index(): List<SignIn>{
        return signInRepository.findAll()
    }

    fun show(email: String): SignIn? {
        return signInRepository.findByIdOrNull(email)
    }

    fun create(dto: SignInForm): SignIn {
        var signin:SignIn = dto.toEntity()
        return signInRepository.save(signin)
    }

    fun update(email: String, password: String, dto: SignInForm): SignIn {
        // 수정용 엔티티
        var signin: SignIn = dto.toEntity()
        // 대상 엔티티
        var target: SignIn = signInRepository.findById(email).orElse(null)

        target.patch(signin)
        var updated: SignIn = signInRepository.save(target)
        return updated
    }

    fun delete(dto: SignInForm): SignIn {
        //대상 엔티티
        var signin: SignIn = dto.toEntity()

        var target: SignIn = signInRepository.findById(signin.getid()).orElse(null)
        //대상삭제
        if (target.is_password(signin))
            signInRepository.delete(target)
        return target
    }
}