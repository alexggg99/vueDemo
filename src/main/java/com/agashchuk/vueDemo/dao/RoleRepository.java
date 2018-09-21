package com.agashchuk.vueDemo.dao;

import com.agashchuk.vueDemo.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
