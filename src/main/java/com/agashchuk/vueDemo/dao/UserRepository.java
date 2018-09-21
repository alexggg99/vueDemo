package com.agashchuk.vueDemo.dao;

import com.agashchuk.vueDemo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String username);

}
