package com.agashchuk.vueDemo.model


import javax.persistence.*

@Entity
@Table(name = "MESSAGE")
data class Message(@Id
                   @GeneratedValue(strategy = GenerationType.AUTO)
                   @Column(name = "ID") val id: Long?,
                   val message: String? = null) {
    constructor() : this(id = null)
}
