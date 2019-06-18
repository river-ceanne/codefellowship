package com.vencer.reina.codefellowship;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Controller
public class CodefellowshipController {

    @GetMapping("/codefellowship")
    public String getCodefellowship2(){
        return "codefellowship";
    }

    @GetMapping("/")
    public String getCodefellowship(Principal p, Model m) {
        if(p != null){
            System.out.println(p.getName());
            m.addAttribute("principal", p.getName());
        }else{
            m.addAttribute("principal", "user");
        }

        return "codefellowship";
    }


}
