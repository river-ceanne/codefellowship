package com.vencer.reina.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AppUserController {

    @Autowired
    AppUserRepository appUserRepository;

    @PostMapping("/users")
    public RedirectView createUser(String username, String password){
        AppUser newUser = new AppUser(username,password);
        appUserRepository.save(newUser);
        return new RedirectView("/");
    }

}
