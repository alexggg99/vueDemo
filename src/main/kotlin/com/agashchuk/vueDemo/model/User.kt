package com.agashchuk.vueDemo.model

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "USER")
data class User(@Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                @Column(name = "ID") val id: Long?,
                var name: String? = null,
                var userpic: String? = null,
                var email: String? = null,
                var gender: String? = null,
                var locale: String? = null,
                var lastVisit: LocalDateTime? = null,
                var username: String? = null,
                @JsonIgnore var password: String? = null ,
                @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "role_id")var role: Role? = null) {
    constructor() : this(id = null)
}

