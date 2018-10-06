package com.agashchuk.vueDemo.service

import com.agashchuk.vueDemo.dao.UserRepository
import com.agashchuk.vueDemo.model.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

import java.util.ArrayList
import java.util.HashSet

@Service
class CustomUserDetailsService : UserDetailsService {

    @Autowired
    private lateinit var userRepo: UserRepository

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepo.findUserByUsername(username)
                ?: throw UsernameNotFoundException(String.format("User %s does not exist!", username))

        val authorities = buildUserAuthority(user.role)

        return buildUserForAuthentication(user, authorities)
    }


    fun buildUserForAuthentication(user: com.agashchuk.vueDemo.model.User,
                                   authorities: List<GrantedAuthority>): User {
        return User(user.username, user.password,
                true, true, true, true, authorities)
    }

    private fun buildUserAuthority(role: Role?): List<GrantedAuthority> {

        val setAuths = HashSet<GrantedAuthority>()

        //for (int i = 0; i < roles.size(); i ++){

        //String role = roles.get(i).getAuthority(); //TODO Превратить в строку типа "ROLE_ADMIN"

        setAuths.add(SimpleGrantedAuthority(role!!.name))


        //}

        return ArrayList(
                setAuths)
    }

}
