package com.social.social.user.entity

import jakarta.persistence.*
import org.hibernate.jdbc.Expectation.None
import java.sql.Timestamp
import java.time.LocalDateTime

@Entity
@Table(name = "user")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    var userName: String = "",
    var password: String = "",
    var firstName: String = "",
    var secondName: String = "",
    var bigPicture: String = "",
    var medPicture: String = "",
    var smPicture: String = "",
    var regDate: LocalDateTime = LocalDateTime.now(),
    var email: String = "",
)