package com.agashchuk.vueDemo.dao

import com.agashchuk.vueDemo.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun findUserByUsername(username: String): User

}
