package com.springboot.web.controller;

import com.springboot.web.entity.User;
import com.sun.xml.internal.fastinfoset.util.StringArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.ArrayUtils;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Entity;
import java.util.Objects;

@Controller
@Slf4j
public class LoginController {

    @GetMapping(value = {"/login","/"})
    public String login(){
        return "login";
    }

    @PostMapping("/dologin")
    public String dologin(User user, HttpSession session){
        log.info(user.toString());
        session.setAttribute("user", user);
        return "redirect:/main.html";
    }

    @GetMapping("/main.html")
    public String main(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if (!Objects.isNull(user) && user.getPassword().length() <=0){
            model.addAttribute("msg", "用户未登录");
            return "login";
        }else return "mail";
    }

    @GetMapping("/index_alt")
    public String index_alt(){
        return "index_alt";
    }
}
