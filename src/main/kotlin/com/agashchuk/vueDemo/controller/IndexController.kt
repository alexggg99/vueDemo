package com.agashchuk.vueDemo.controller

import org.springframework.stereotype.Controller
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView


import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class IndexController {

    @RequestMapping("/")
    fun index() = "index"

    @RequestMapping("/login")
    fun login(@RequestParam(name = "error", required = false) error: Boolean, request: HttpServletRequest): ModelAndView {
        var model = ModelAndView()
        var username = request.session.getAttribute("username") as? String
        if (!StringUtils.isEmpty(username)) {
            model.addObject("username", username)
        }
        model.viewName = "login"
        return model
    }

    @RequestMapping("/loginFailed")
    fun login(response: HttpServletResponse) = response.sendRedirect("/login?error=true")

}
