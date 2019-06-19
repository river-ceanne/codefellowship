package com.vencer.reina.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @PostMapping("/posts")
    public RedirectView createPost(Principal p, Model m, String body){
        AppUser user = appUserRepository.findByUsername(p.getName());

        if(user != null){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Post post = new Post(body, timestamp, user);
            postRepository.save(post);
        }

        m.addAttribute("principal", p.getName());
        m.addAttribute("appUser", user);
        return new RedirectView("/myprofile");
    }

    @GetMapping("/post")
    public String getPostPage() {
        return "postpage";
    }


}
