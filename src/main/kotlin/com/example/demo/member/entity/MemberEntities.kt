package com.example.demo.member.entity

import com.example.demo.common.status.Gender
import jakarta.persistence.*
import java.time.LocalDate

@Entity
// loginID가 중복되면 안되기 때문에 uniqueConstraints에 추가하게 되었음.
@Table(
    uniqueConstraints = [UniqueConstraint(name = "uk_member_login_id", columnNames = ["loginId"])]
)

class Member(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null, //자동으로 생성되어 가지게 되는 key 값.

    @Column(nullable = false, length = 30, updatable = false) // member가 update 될 때 로그인 아이디는 제외시키도록 함
    val loginId: String, // 아마도 value이지 않을까. ex) {122345332, "jiyun5919"}

    @Column(nullable = false, length = 100)
    val password: String,

    @Column(nullable = false, length = 10)
    val name: String,

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    val birthDate: LocalDate,

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING) // db에 Gender의 String (ex. "남") 을 그대로 입력하겠다.
    val gender: Gender,

    @Column(nullable = false, length = 100)
    val email: String,


)