package com.vencer.reina.codefellowship;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class AppUserController {

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AppUserRepository appUserRepository;

    @PostMapping("/users")
    public RedirectView createUser(String username, String password, String dob, String firstname, String lastname, String bio) throws ParseException {
        String hashedpwd = bCryptPasswordEncoder.encode(password);
        Date DOB = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
        AppUser newUser = new AppUser(username,hashedpwd, DOB, firstname, lastname, bio);
        appUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup";
    }

    @GetMapping("/myprofile")
    public String getMyProfilePage() {
        return "myprofile";
    }

//    @PostMapping("/login")
//    public RedirectView loginSuccessGoToMyProfile(Model m, String username, String password) throws ParseException {
//        String hashedpwd = bCryptPasswordEncoder.encode(password);
//        AppUser user = appUserRepository.findByUsername(username);
//
//        if(user != null){
//
////            if(user.getPassword() == hashedpwd){
////                Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
////            Authentication authentication = authenticationManager.authenticate();
//            Authentication authentication = new UsernamePasswordAuthenticationToken(new AppUser(username,password), null, new ArrayList<>());
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//                m.addAttribute("appUser",user);
//                return new RedirectView("/myprofile");
////            }
//
//        }
//
//        return new RedirectView("/login");//refresh page - go back to login back if not right auth
//    }

    @GetMapping("/users/{id}")
    public String getSingleAppUserPage(Model m, @PathVariable String id) {
        long ID = Long.parseLong(id);
        AppUser appUser = appUserRepository.findById(ID);
        m.addAttribute("appUser", appUser);
        return "singleappuser";
    }




}
