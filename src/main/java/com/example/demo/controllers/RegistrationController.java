package com.example.demo.controllers;

import com.example.demo.models.Rol;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRep userRep;

    @GetMapping("/registration")
    public String regView(Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String regAction(User user, Model model){
        User userFromDB = userRep.findByLogin(user.getLogin());
        if(userFromDB != null){
            model.addAttribute("error", "Пользователь уже существует");
            return "registration";
        }

        user.setActive(true);
        user.setRoli(Collections.singleton(Rol.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setFamiliya("fam");
//        user.setImya("imya");
//        user.setMail("mail");
//        user.setNick("nick");
//        user.setTelephone("000");
        userRep.save(user);
        return "redirect:/login";
    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;
}
