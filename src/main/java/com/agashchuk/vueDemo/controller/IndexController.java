package com.agashchuk.vueDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(name = "error", required = false) boolean error, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        String  username = (String) request.getSession().getAttribute("username");
        if (!StringUtils.isEmpty(username)) {
            model.addObject("username", username);
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping("/loginFailed")
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login?error=true");
    }

}
