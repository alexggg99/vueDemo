package com.agashchuk.vueDemo.model

import javax.persistence.*

@Entity
@Table(name = "ROLE")
data class Role(@Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                @Column(name = "ID") val id: Long?,
                val name: String? = null) {
    constructor() : this(id = null)
}