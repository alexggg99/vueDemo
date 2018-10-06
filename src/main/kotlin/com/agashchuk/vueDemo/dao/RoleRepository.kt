package com.agashchuk.vueDemo.dao

import com.agashchuk.vueDemo.model.Role
import org.springframework.data.repository.CrudRepository

interface RoleRepository : CrudRepository<Role, Long>
