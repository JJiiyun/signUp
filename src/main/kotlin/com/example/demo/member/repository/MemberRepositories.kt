package com.example.demo.member.repository

import com.example.demo.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> { //Repository는 interface로 만들고, JpaRepo를 상속받았음.
    fun findByLoginId(loginId: String): Member? //회원가입 시 아이디 중복 검사를 위해 필요s
}