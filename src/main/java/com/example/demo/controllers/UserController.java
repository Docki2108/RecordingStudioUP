package com.example.demo.controllers;

import com.example.demo.models.Rol;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserRep userRep;

    @GetMapping
    public String all_users(Model model)
    {
        model.addAttribute(
                "users",
                userRep.findAll());
        return "users/info-users";
    }

    @GetMapping("/edit/{id}")
    public String user_role(
            @PathVariable("id") Long id,
            Model model)
    {
        Optional<User> user_raw = userRep.findById(id);
        ArrayList<User> userArrayList = new ArrayList<>();

        user_raw.ifPresent(userArrayList::add);

        model.addAttribute("one_user",userArrayList);
        model.addAttribute("roli", Rol.values());
        return "users/edit-users";
    }

    @PostMapping
    public String edit_role(
            @RequestParam("userId") User user,
            @RequestParam("nick") String nick,
            @RequestParam(name = "rol[]", required = false)
            String[] rol
    )
    {
        user.setNick(nick);
        user.getRoli().clear();

        if (rol != null)
        {
            for (String rol_name:
                    rol) {
                user.getRoli().add(Rol.valueOf(rol_name));
            }
        }
        userRep.save(user);
        return "redirect:/admin";
    }
}
